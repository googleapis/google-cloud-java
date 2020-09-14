# Cloud Data Loss Prevention (DLP) API Samples

<a href="https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-dlp&page=editor&open_in_editor=samples/snippets/README.md">
<img alt="Open in Cloud Shell" src ="http://gstatic.com/cloudssh/images/open-btn.png"></a>

The [Data Loss Prevention API](https://cloud.google.com/dlp/docs/) provides programmatic access to 
a powerful detection engine for personally identifiable information and other privacy-sensitive data
 in unstructured data streams.

## Setup
- A Google Cloud project with billing enabled
- [Enable](https://console.cloud.google.com/launcher/details/google/dlp.googleapis.com) the DLP API.
- [Create a service account](https://cloud.google.com/docs/authentication/getting-started)
and set the `GOOGLE_APPLICATION_CREDENTIALS` environment variable pointing to the downloaded credentials file.

## Running

To run a specific sample, edit any variables under the `TODO(developer):` in the
function at the top of each sample, and then execute the function as convenient.

For example, if using the command line you might use the following (replacing 
`<CLASS_NAME>` with the name of the sample):
```bash
mvn exec:java -Dexec.mainClass="dlp.snippets.<CLASS_NAME>"
```


## Testing

### Setup
- Ensure that `GOOGLE_APPLICATION_CREDENTIALS` points to authorized service account credentials file.
- Set the `DLP_DEID_WRAPPED_KEY` environment variable to an AES-256 key encrypted ('wrapped') [with a Cloud Key Management Service (KMS) key](https://cloud.google.com/kms/docs/encrypt-decrypt).
- Set the `DLP_DEID_KEY_NAME` environment variable to the path-name of the Cloud KMS key you wrapped `DLP_DEID_WRAPPED_KEY` with.
- [Create a Google Cloud Storage bucket](https://console.cloud.google.com/storage) and upload [test.txt](src/test/resources/test.txt).
    - Set the `GCS_PATH` environment variable to point to the path for the bucket.
- Copy and paste the data below into a CSV file and [create a BigQuery table](https://cloud.google.com/bigquery/docs/loading-data-local) from the file:
    ```$xslt
    Name,TelephoneNumber,Mystery,Age,Gender
    James,(567) 890-1234,8291 3627 8250 1234,19,Male
    Gandalf,(223) 456-7890,4231 5555 6781 9876,27,Male
    Dumbledore,(313) 337-1337,6291 8765 1095 7629,27,Male
    Joe,(452) 223-1234,3782 2288 1166 3030,35,Male
    Marie,(452) 223-1234,8291 3627 8250 1234,35,Female
    Carrie,(567) 890-1234,2253 5218 4251 4526,35,Female
    ```
  - Set the `BIGQUERY_DATASET` and `BIGQUERY_TABLE` environment values.
- [Create a Google Cloud Pub/Sub](https://console.cloud.google.com/datastore) topic and and a subscription that is subscribed to the topic.
    - Set the `PUB_SUB_TOPIC` and `PUB_SUB_SUBSCRIPTION` environment variables to the corresponding values.
- [Create a Google Cloud Datastore](https://console.cloud.google.com/datastore) kind and add an entity with properties:
  - `property1` : john@doe.com
  - `property2` : 343-343-3435
-  Update the Datastore kind in [InspectTests.java](src/test/java/dlp/snippets/InspectTests.java).


### Run
Run all tests:
```
   mvn clean verify
```
