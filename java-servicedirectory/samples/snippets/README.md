# Service Directory

[Service Directory](https://cloud.google.com/service-directory/) is a platform
for discovering, publishing, and connecting services. It offers customers a
single place to register and discover their services in a consistent and
reliable way, regardless of their environment. These sample Java applications
demonstrate how to access the Service Directory API using the Google Java API
Client Libraries.

## Prerequisites

### Enable the API

You must enable the Service Directory API for your project in order to use these
samples. You can do so
[here](https://console.cloud.google.com/flows/enableapi?apiid=servicedirectory.googleapis.com&_ga=2.140387959.57242806.1585772225-360187285.1585772225).

### Set Environment Variables

You must set your project ID in order to run the tests

`$ export GOOGLE_CLOUD_PROJECT=<your-project-id-here>`

### Grant Permissions

You must ensure that the
[user account or service account](https://cloud.google.com/iam/docs/service-accounts#differences_between_a_service_account_and_a_user_account)
you used to authorize your gcloud session has the proper permissions to edit
Service Directory resources for your project. In the Cloud Console under IAM,
add the `Service Directory Admin` role to the project whose service account
you're using to test.

More information can be found in the
[Authentication docs](https://cloud.google.com/docs/authentication/production).

## Quickstart

Install [Maven](https://maven.apache.org/).

Build your project with:

    mvn clean package -DskipTests

You can run all tests with:

    mvn clean verify
