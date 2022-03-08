# How to set up/ tear down the test resources

## Required environment variables

To successfully import the catalog data for tests, the following environment variables should be
set:

- PROJECT_ID
- PROJECT_NUMBER
- BUCKET_NAME

The Secret Manager name is set in .kokoro/presubmit/common.cfg file, SECRET_MANAGER_KEYS variable.

## Import catalog data

There is a JSON file with valid products prepared in the `product` directory:
`resources/products.json`.

Run the `CreateTestResources` to perform the following actions:

- create the GCS bucket <BUCKET_NAME>;
- upload the product data from `resources/products.json` file to the bucket;
- import products to the default branch of the Retail catalog;
- upload the product data from `resources/user_events.json` file to the bucket;
- create a BigQuery dataset and table `products`;
- insert products from resources/products.json to the created products table;
- create a BigQuery dataset and table `events`;
- insert user events from resources/user_events.json to the created events table;

```
mvn compile exec:java -Dexec.mainClass="init.CreateTestResources"
```

In the result 316 products should be created in the test project catalog.

## Remove catalog data

Run the `RemoveTestResources` to perform the following actions:

- remove all objects from the GCS bucket <BUCKET_NAME>;
- remove the <BUCKET_NAME> bucket;
- delete all products from the Retail catalog;
- remove all objects from the GCS bucket <BUCKET_NAME>;
- remove dataset `products` along with tables;
- remove dataset `user_events` along with tables;

```
mvn compile exec:java -Dexec.mainClass="init.RemoveTestResources"
```