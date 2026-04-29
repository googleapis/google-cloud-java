# How to run the samples

1. Clone this repo and navigate to the `snippets` directory.
   ```shell
   git clone https://github.com/googleapis/java-pubsub
   cd java-pubsub/samples/snippets
   ```

1. [Obtain GCP user access credentials] via a web flow for your application. 
   ```shell
   gcloud auth application-default login
   ```

1. With [Maven] installed, run a sample that has the to-do section completed:
   ```shell
   mvn clean compile exec:java -Dexec.mainClass=pubsub.CreateTopicExample
   ```
   
1. To run the samples test:
   ```shell
   mvn -Dtest=pubsub.AdminIT test
   ```

[Maven]: https://maven.apache.org/
[Obtain GCP user access credentials]: https://cloud.google.com/sdk/gcloud/reference/auth/application-default/login