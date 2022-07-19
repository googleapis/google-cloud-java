# Getting Started with Datastore Samples

## Running a sample using Cloud Shell

The Google Cloud Shell has application default credentials from its compute instance which will allow you to run samples without having to obtain `GOOGLE_APPLICATION_CREDENTIALS`.
Go to the [Datastore Client Readme](https://github.com/googleapis/java-datastore#samples) to run each sample in the Cloud Shell.

## Running a sample at the command line

1. First set up the `GOOGLE_CLOUD_PROJECT` environment variable.

2. Obtain authentication credentials.

    Create local credentials by running the following command and following the
    oauth2 flow (read more about the command [here][auth_command]):

        gcloud auth application-default login

    Or manually set the `GOOGLE_APPLICATION_CREDENTIALS` environment variable
    to point to a service account key JSON file path.

    Learn more at [Setting Up Authentication for Server to Server Production Applications][ADC].

Now you can run a sample:

1. `cd samples/snippets` - all samples are located in the `java-datastore/samples/snippets` directory.
2. `mvn compile exec:java -Dexec.mainClass="com.google.datastore.snippets.TaskList"` - this runs the [TaskList sample](https://github.com/googleapis/java-datastore/blob/master/samples/snippets/src/main/java/com/google/datastore/snippets/TaskList.java).

[ADC]: https://developers.google.com/identity/protocols/application-default-credentials
[auth_command]: https://cloud.google.com/sdk/gcloud/reference/beta/auth/application-default/login
