resource "aws_iam_role" "beanstalk_ec2" {
  assume_role_policy    = "{\"Statement\":[{\"Action\":\"sts:AssumeRole\",\"Effect\":\"Allow\",\"Principal\":{\"Service\":\"ec2.amazonaws.com\"}}],\"Version\":\"2012-10-17\"}"
  description           = "Allows EC2 instances to call AWS services on your behalf."
  force_detach_policies = false
  managed_policy_arns   = ["arn:aws:iam::aws:policy/AWSElasticBeanstalkMulticontainerDocker", "arn:aws:iam::aws:policy/AWSElasticBeanstalkWebTier", "arn:aws:iam::aws:policy/AWSElasticBeanstalkWorkerTier"]
  max_session_duration  = 3600
  name                  = "aws-elasticbeanstalk-ec2"
  path                  = "/"
}

resource "aws_iam_instance_profile" "beanstalk_ec2" {
  name = "aws-elasticbeanstalk-ec2-profile"
  role = aws_iam_role.beanstalk_ec2.name
}

resource "aws_s3_bucket" "beanstalk_bucket" {
  bucket        = "beanfarm-deploy-bucket"
  force_destroy = true
}

# resource "aws_s3_object" "default_jar" {
#   bucket = aws_s3_bucket.beanstalk_bucket.id
#   key    = "dummy_api.jar"
#   source = "dummy_api.jar"
#   acl    = "private"

#   depends_on = [aws_s3_bucket.beanstalk_bucket]
# }

# resource "aws_elastic_beanstalk_application_version" "default" {
#   name         = "default-app"
#   application  = aws_elastic_beanstalk_application.api_app.name
#   bucket       = aws_s3_bucket.beanstalk_bucket.id
#   key          = aws_s3_object.default_jar.key
#   force_delete = true
# }

resource "aws_elastic_beanstalk_application" "api_app" {
  name        = "api-app"
  description = "App for java API"
}

resource "aws_elastic_beanstalk_environment" "api_env" {
  name                = "api-env"
  application         = aws_elastic_beanstalk_application.api_app.name
  solution_stack_name = "64bit Amazon Linux 2023 v4.2.1 running Corretto 21"
  tier                = "WebServer"
  # version_label       = aws_elastic_beanstalk_application_version.default.name

  setting {
    namespace = "aws:ec2:vpc"
    name      = "VPCId"
    value     = module.vpc.vpc_id
  }
  setting {
    namespace = "aws:autoscaling:launchconfiguration"
    name      = "IamInstanceProfile"
    value     = aws_iam_instance_profile.beanstalk_ec2.name
  }
  setting {
    namespace = "aws:ec2:vpc"
    name      = "Subnets"
    value     = join(",", module.vpc.public_subnets)
  }
  setting {
    namespace = "aws:ec2:instances"
    name      = "InstanceTypes"
    value     = "t3.micro"
  }
  setting {
    namespace = "aws:elasticbeanstalk:healthreporting:system"
    name      = "SystemType"
    value     = "basic"
  }
  setting {
    namespace = "aws:elasticbeanstalk:application"
    name      = "Application Healthcheck URL"
    value     = "/"
  }
  setting {
    namespace = "aws:elasticbeanstalk:command"
    name      = "Timeout"
    value     = "60"
  }
  setting {
    namespace = "aws:elasticbeanstalk:command"
    name      = "IgnoreHealthCheck"
    value     = "true"
  }
  setting {
    namespace = "aws:elasticbeanstalk:environment"
    name      = "EnvironmentType"
    value     = "SingleInstance"
  }
  setting {
    namespace = "aws:elasticbeanstalk:managedactions"
    name      = "ManagedActionsEnabled"
    value     = "false"
  }
  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "SPRING_DATASOURCE_USERNAME"
    value     = module.rds.db_instance_username
  }
  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "SPRING_DATASOURCE_PASSWORD"
    value     = jsondecode(data.aws_secretsmanager_secret_version.db-details.secret_string)["password"]
  }
  setting {
    namespace = "aws:elasticbeanstalk:application:environment"
    name      = "SPRING_DATASOURCE_URL"
    value     = "jdbc:postgresql://${module.rds.db_instance_address}:5432/beanfarmdb"
  }
}

data "aws_secretsmanager_secret_version" "db-details" {
  secret_id = module.rds.db_instance_master_user_secret_arn
}

# output "elastic_beanstalk_app_url" {
#   value = "http://${aws_elastic_beanstalk_environment.api_env.cname}"
# }