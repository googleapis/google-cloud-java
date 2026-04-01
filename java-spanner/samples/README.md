# Getting Started with Cloud Spanner and the Google Cloud Client libraries

<a href="https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-spanner&page=editor&open_in_editor=samples/README.md">
<img alt="Open in Cloud Shell" src ="http://gstatic.com/cloudssh/images/open-btn.png"></a>

[Cloud Spanner][Spanner] is a horizontally-scalable database-as-a-service
with transactions and SQL support.
These sample Java applications demonstrate how to access the Spanner API using
the [Google Cloud Client Library for Java][java-spanner].

[Spanner]: https://cloud.google.com/spanner/
[java-spanner]: https://github.com/googleapis/java-spanner

## Quickstart

Install [Maven](http://maven.apache.org/).

Build your project from the root directory (`java-spanner`):

    mvn clean package -DskipTests
    cd samples/snippets
    mvn package

Every subsequent command here should be run from a subdirectory `samples/snippets`.

### Running samples

Usage:

    java -jar target/spanner-snippets/spanner-google-cloud-samples.jar operation my-instance my-database

#### Examples

Create Database:

    java -jar target/spanner-google-cloud-samples-jar-with-dependencies.jar my-instance my-database

Listing database operations:

    java -jar target/spanner-snippets/spanner-google-cloud-samples.jar listdatabaseoperations my-instance my-database