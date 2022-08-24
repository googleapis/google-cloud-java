# Retail Search Interactive Tutorials

## Run tutorials in Cloud Shell

To advance with the interactive tutorials, use Retail Search step-by-step manuals on the right side of the Cloud Shell IDE: 
![Interactive tutorials](images/tutorial1.png)

The interactive tutorial should open by default. If it didn’t, click on the Tutorial symbol in the menu bar to open the step-by-step manual:
![Toggle tutorial](images/tutorials2.png)

For more details about the Cloud Shell environment, refer to the [Cloud Shell documentation](https://cloud.google.com/shell/docs).

## Interactive tutorial flow

Interactive guides are intended to help you understand the features provided by Google Cloud Retail Search and test the Retail API in action.

To proceed with the tutorial, choose a language you’ll be deploying your project in:
![Select a programming language](images/tutorials3.png)


To begin with the tutorial workflow, click the Start button:
![Begin with the tutorial](images/tutorials4.png)

Then, you can use Next and Previous buttons to navigate the tutorial pages.

## Java code samples

The code here demonstrates how to consume Google Retail Search API in Java

## Get started with the Google Cloud Retail API

The Retail API provides you with the following possibilities to: 
  - Create and maintaining the catalog data. 
  - Fine-tune the search configuration.
  - Import and maintain the user events data.

You can find the information about the Retail services in the [documentation](https://cloud.google.com/retail/docs)

If you would like to have a closer look at the Retail API features and try them yourself,
the best option is to use the [Interactive Tutorials](https://cloud.google.com/retail/docs/overview). In the documentation chapters find the "Guide me" button, the tutorials will be launched in the CloudShell environment, and you will be able to request the Retail services and check the response with minimum time and effort.

The code samples in the directory **java-retail/samples/interactive-tutorials** are explicitly created for use with the Retail Interactive Tutorials.

If, for some reason, you have decided to proceed with these code samples without the tutorial, please go through the following steps and set up the required preconditions.

## Prepare your work environment

To prepare the work environment you should perform the following steps:
- Create a service account.
- Create a service account key and set it to authorize your calls to the Retail API.
- Install Google Cloud Retail library.

### There are two ways to set up your work environment:

- If you want to **speed up the process** of setting up the working environment, run the script java-retail/samples/interactive-tutorials/samples/interactive-tutorials/src/main/java/user_environment_setup.sh and skip the next **set up the work environment step-by-step** tutorial step:

    ```bash
    bash java-retail/samples/interactive-tutorials/user_environment_setup.sh
    ```

- If you want to perform the environment set up step by step along with getting the explanation you should proceed with the next tutorial step.

## Set up the work environment step-by-step

### Create service account

To access the Retail API, you must create a service account. Check that you are an owner of your Google Cloud project on the [IAM page](https://console.cloud.google.com/iam-admin/iam).

1. To create a service account, perform the following command:

    ```bash
    gcloud iam service-accounts create <YOUR_SERVICE_ACCOUNT_ID>
    ```

1. Assign the needed roles to your service account:

    ```bash
    for role in {retail.admin,editor,bigquery.admin}
    do gcloud projects add-iam-policy-binding <YOUR_PROJECT_ID> --member="serviceAccount:<YOUR_SERVICE_ACCOUNT_ID>@<YOUR_PROJECT_ID>.iam.gserviceaccount.com" --role="roles/${role}"
    done
    ```

1. Use the following command to show the service account email:

    ```bash
    gcloud iam service-accounts list|grep <YOUR_SERVICE_ACCOUNT_ID>
    ```

    Copy the service account email.


1.  Upload your service account key JSON file and use it to activate the service
    account:

    ```bash
    gcloud iam service-accounts keys create ~/key.json --iam-account <YOUR_SERVICE_ACCOUNT_EMAIL>
    ```

    ```bash
    gcloud auth activate-service-account --key-file ~/key.json
    ```

1.  Set the key as the GOOGLE_APPLICATION_CREDENTIALS environment variable to
    use it for sending requests to the Retail API.

    ```bash
    export GOOGLE_APPLICATION_CREDENTIALS=~/key.json
    ```

### Google Cloud Retail libraries

Learn more about the [Java Google Cloud Retail library](https://googleapis.dev/java/google-cloud-retail/latest/index.html).

## Congrats!  You have configured your work environment

1. Check that you are in the directory with code samples.

    The code samples for each of the Retail services are stored in different directories.

    Go to the code samples directory, your starting point to run more commands.

    ```bash
    cd java-retail/samples/interactive-tutorials/
    ```

## Import catalog data

<i>This step is required if this is the first Retail API tutorial that you run.
Otherwise, you can skip it.</i>

There is a java-retail/samples/interactive-tutorials/src/main/resources/products.json file with valid products prepared in the `resources` directory.

The other file, java-retail/samples/interactive-tutorials/src/main/resources/products_some_invalid.json, contains both valid and invalid products. You will use it to check the error handling.

- If you want to **speed up the process**, run the following script in the Terminal directory to import all products to catalog and skip the next **Prepare the catalog data step-by-step** tutorial step:

    ```bash
    bash java-retail/samples/interactive-tutorials/user_import_data_to_catalog.sh
    ```

- If you want to upload products to the catalog step by step along with getting the explanation, you should proceed with the next tutorial step.

## Prepare the catalog data step-by-step

### Upload catalog data to Cloud Storage

In your own project you need to create a Cloud Storage bucket and put the JSON file there.
The bucket name must be unique. For convenience, you can name it `<YOUR_PROJECT_ID>_<TIMESTAMP>`.

1. The code samples for each of the Retail services are stored in different directories.

    Go to the code samples directory, your starting point to run more commands.

    ```bash
    cd java-retail/samples/interactive-tutorials
    ```

1. To create the bucket and upload the JSON file, open java-retail/samples/interactive-tutorials/src/main/java/product/setup/ProductsCreateGcsBucket.java file

1. Go to the **product** directory and run the following command in the Terminal:

    ```bash
    mvn compile exec:java
    -Dexec.mainClass=product.setup.ProductsCreateGcsBucket
    ```

    Now you can see the bucket is created in the [Cloud Storage](https://console.cloud.google.com/storage/browser), and the files are uploaded.

1. The name of the created Cloud Storage bucket is shown in the Terminal.

    ```
    The gcs bucket <YOUR_PROJECT_ID>_<TIMESTAMP> was created
    ```

    Copy the name and set it as the environment variable `BUCKET_NAME`:

    ```bash
    export BUCKET_NAME=<YOUR_BUCKET_NAME>
    ```

### Import products to the Retail Catalog

To import the prepared products to a catalog, open java-retail/samples/interactive-tutorials/src/main/java/product/ImportProductsGcs.java file and run the following command in the Terminal:

```bash
mvn compile exec:java -Dexec.mainClass=product.ImportProductsGcs
```

## Your Retail catalog is ready to use!
 
### Running code samples

Use maven command to run specific code sample:

```
mvn compile exec:java -Dexec.mainClass="package.CodeSampleClass"
```

### Running unit tests

Use maven command to run specific unit test class:

```
mvn test -Dtest=TestClassName
```

Use maven command to run all unit tests:

```
mvn test
```
