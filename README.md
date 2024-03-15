<div align="center">

# Cloud Farming - Project Description

<br>
  
[![Commits](https://img.shields.io/github/commit-activity/w/CldFarm/cloud-farming)](https://github.com/CldFarm/cloud-farming/activity)
[![CI/CD](https://github.com/CldFarm/cloud-farming/actions/workflows/prod-ci-cd.yaml/badge.svg)](https://github.com/CldFarm/cloud-farming/actions/workflows/prod-ci-cd.yaml)

</div>

Welcome to the new and growing cloud solution for managing your Bean Crop Production. AgriCloud provides farmers with easy access to the Bean Cloud via their Google account, empowering them to efficiently manage their bean provisions.

Create, Update, Terminate, and Grow!

With AgriCloud, farmers can effortlessly perform a variety of bean-related activities with just a single click. Adjust soil moisture levels with ease, add water as needed! Require more sunlight? No problem! AgriCloud offers real-time crop management capabilities, allowing you to optimize your farming practices and become the best farmer you can be.


## Project Resources:

[![Documentation](https://img.shields.io/badge/View-Project%20Documentation-blue?style=for-the-badge)](https://bbd-gradprojects.atlassian.net/wiki/spaces/AMYXZ/overview)&ensp;

[![Project Management](https://img.shields.io/badge/View-Project%20Issue%20Board-blue?style=for-the-badge)](https://bbd-gradprojects.atlassian.net/jira/software/projects/CF/boards/1)&ensp;


## Setup
1. Clone this repository to your local machine. 
   ```
   git clone https://github.com/CldFarm/cloud-farming
   ```

2. Set up a role in your AWS account for this repository. Follow the instructions provided in the AWS Security Blog: [Use IAM Roles to Connect GitHub Actions to Actions in AWS](https://aws.amazon.com/blogs/security/use-iam-roles-to-connect-github-actions-to-actions-in-aws/).

3. Configure secret variables in the GitHub repository settings:
   - Go to Settings > Secrets and Variables.
   - Under Actions, set the secret variable "AWS_ASSUME_ROLE" to the ARN of your IAM role.

4. Todo

## Runing fully locally
This project uses Java 21.

#### API
**Found in `apps/api`**

The Spring application sources an `api.env` file for secrets. The required values are as follows:
```env
spring.datasource.url = jdbc:postgresql://localhost:5432/your_db
spring.datasource.username = your_name
spring.datasource.password = your_pass
```

To run this, we can use `./gradlew bootRun` to run in the terminal.

#### CLI
**Found in `apps/cli`**

Similar to the API, we source a `cli.env`. Required values as follows:
```env
SPRING_SECURITY_OAUTH2_CLIENT_REGISTRATION_GOOGLE_CLIENT_SECRET=...
SPRING_SECURITY_OAUTH2_CLIENT_REGISTRATION_GOOGLE_CLIENT_ID=...
API_ENDPOINT=...
```

To run this with the full power of the spring shell, you must first compile and then run the JAR.

```sh
./gradlew bootJar
java -jar build/libs/cli-0.0.1-SNAPSHOT.jar
```

#### Database
Requires a PostgreSQL database. You can set this up however you want, and choose your own username and password, as long as you set the env variables.
