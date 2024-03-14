resource "aws_s3_bucket" "beanstalk_bucket" {
  bucket        = "beanfarm-packaging-bucket"
  force_destroy = true
}