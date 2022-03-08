/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package setup;

import static com.google.cloud.storage.StorageClass.STANDARD;

import com.google.api.gax.paging.Page;
import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.DatasetDeleteOption;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.FormatOptions;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.LoadJobConfiguration;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.TableDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.retail.v2.CreateProductRequest;
import com.google.cloud.retail.v2.DeleteProductRequest;
import com.google.cloud.retail.v2.FulfillmentInfo;
import com.google.cloud.retail.v2.GetProductRequest;
import com.google.cloud.retail.v2.PriceInfo;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.Product.Availability;
import com.google.cloud.retail.v2.Product.Type;
import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class SetupCleanup {

  private static final String PROJECT_ID = System.getenv("PROJECT_ID");
  private static final Storage STORAGE =
      StorageOptions.newBuilder().setProjectId(PROJECT_ID).build().getService();
  private static final String DEFAULT_BRANCH_NAME =
      String.format(
          "projects/%s/locations/global/catalogs/default_catalog/" + "branches/default_branch",
          PROJECT_ID);

  public static Product generateProduct() {
    float price = 30.0f;
    float originalPrice = 35.5f;

    PriceInfo priceInfo =
        PriceInfo.newBuilder()
            .setPrice(price)
            .setOriginalPrice(originalPrice)
            .setCurrencyCode("USD")
            .build();

    FulfillmentInfo fulfillmentInfo =
        FulfillmentInfo.newBuilder()
            .setType("pickup-in-store")
            .addAllPlaceIds(Arrays.asList("store0", "store1"))
            .build();

    return Product.newBuilder()
        .setTitle("Nest Mini")
        .setType(Type.PRIMARY)
        .addCategories("Speakers and displays")
        .addBrands("Google")
        .setPriceInfo(priceInfo)
        .setAvailability(Availability.IN_STOCK)
        .addFulfillmentInfo(fulfillmentInfo)
        .build();
  }

  public static Product createProduct(String productId) throws IOException {
    CreateProductRequest createProductRequest =
        CreateProductRequest.newBuilder()
            .setProduct(generateProduct())
            .setProductId(productId)
            .setParent(DEFAULT_BRANCH_NAME)
            .build();
    System.out.printf("Create product request: %s%n", createProductRequest);

    Product createdProduct = ProductServiceClient.create().createProduct(createProductRequest);
    System.out.printf("Created product: %s%n", createdProduct);

    return createdProduct;
  }

  public static Product getProduct(String productName) throws IOException {
    Product product = Product.newBuilder().build();

    GetProductRequest getProductRequest =
        GetProductRequest.newBuilder().setName(productName).build();

    try {
      product = ProductServiceClient.create().getProduct(getProductRequest);
      System.out.println("Get product response: " + product);
      return product;
    } catch (NotFoundException e) {
      System.out.printf("Product %s not found", productName);
      return product;
    }
  }

  public static void deleteProduct(String productName) throws IOException {
    DeleteProductRequest deleteProductRequest =
        DeleteProductRequest.newBuilder().setName(productName).build();
    System.out.printf("Delete product request %s%n", deleteProductRequest);

    ProductServiceClient.create().deleteProduct(deleteProductRequest);
    System.out.printf("Product %s was deleted.%n", productName);
  }

  public static Bucket createBucket(String bucketName) {
    Bucket bucket = null;
    System.out.printf("Creating new bucket: %s %n", bucketName);

    if (checkIfBucketExists(bucketName)) {
      System.out.printf("Bucket %s already exists. %n", bucketName);
      Page<Bucket> bucketList = STORAGE.list();
      for (Bucket itrBucket : bucketList.iterateAll()) {
        if (itrBucket.getName().equals(bucketName)) {
          bucket = itrBucket;
        }
      }
    } else {
      bucket =
          STORAGE.create(
              BucketInfo.newBuilder(bucketName)
                  .setStorageClass(STANDARD)
                  .setLocation("US")
                  .build());

      System.out.println(
          "Bucket was created "
              + bucket.getName()
              + " in "
              + bucket.getLocation()
              + " with storage class "
              + bucket.getStorageClass());
    }

    return bucket;
  }

  public static boolean checkIfBucketExists(String bucketToCheck) {
    boolean bucketExists = false;

    Page<Bucket> bucketList = STORAGE.list();
    for (Bucket bucket : bucketList.iterateAll()) {
      if (bucket.getName().equals(bucketToCheck)) {
        bucketExists = true;
        break;
      }
    }

    return bucketExists;
  }

  public static void deleteBucket(String bucketName) {
    try {
      Bucket bucket = STORAGE.get(bucketName);
      if (bucket != null) {
        bucket.delete();
      }
    } catch (StorageException e) {
      System.out.printf("Bucket is not empty. Deleting objects from bucket.%n");
      deleteObjectsFromBucket(STORAGE.get(bucketName));
      System.out.printf("Bucket %s was deleted.%n", STORAGE.get(bucketName).getName());
    }

    if (STORAGE.get(bucketName) == null) {
      System.out.printf("Bucket '%s' already deleted.%n", bucketName);
    }
  }

  public static void deleteObjectsFromBucket(Bucket bucket) {
    Page<Blob> blobs = bucket.list();
    for (Blob blob : blobs.iterateAll()) {
      blob.delete();
    }
    System.out.printf("All objects are deleted from GCS bucket %s%n", bucket.getName());
  }

  public static void uploadObject(String bucketName, String objectName, String filePath)
      throws IOException {
    BlobId blobId = BlobId.of(bucketName, objectName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
    STORAGE.create(blobInfo, Files.readAllBytes(Paths.get(filePath)));
    System.out.println(
        "File " + filePath + " uploaded to bucket " + bucketName + " as " + objectName);
  }

  public static void createBqDataset(String datasetName) {
    try {
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
      DatasetInfo datasetInfo = DatasetInfo.newBuilder(datasetName).build();
      Dataset newDataset = bigquery.create(datasetInfo);
      String newDatasetName = newDataset.getDatasetId().getDataset();
      System.out.printf("Dataset '%s' created successfully.%n", newDatasetName);
    } catch (BigQueryException e) {
      System.out.printf("Dataset '%s' already exists.%n", datasetName);
    }
  }

  public static void deleteDataset(String projectId, String datasetName) {
    try {
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
      DatasetId datasetId = DatasetId.of(projectId, datasetName);
      boolean success = bigquery.delete(datasetId, DatasetDeleteOption.deleteContents());
      if (success) {
        System.out.printf("Dataset '%s' deleted successfully.%n", datasetName);
      } else {
        System.out.printf("Dataset '%s' was not found.%n", datasetName);
      }
    } catch (BigQueryException e) {
      System.out.printf("Dataset '%s' was not deleted.%n%s", datasetName, e);
    }
  }

  public static void createBqTable(String datasetName, String tableName, Schema schema) {
    try {
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
      TableId tableId = TableId.of(datasetName, tableName);
      TableDefinition tableDefinition = StandardTableDefinition.of(schema);
      TableInfo tableInfo = TableInfo.newBuilder(tableId, tableDefinition).build();
      bigquery.create(tableInfo);
      System.out.printf("Table '%s' created successfully.%n", tableName);
    } catch (BigQueryException e) {
      System.out.printf("Table '%s' already exists.%n", tableName);
    }
  }

  public static void uploadDataToBqTable(
      String datasetName, String tableName, String sourceUri, Schema schema) {
    try {
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
      TableId tableId = TableId.of(datasetName, tableName);
      LoadJobConfiguration loadConfig =
          LoadJobConfiguration.newBuilder(tableId, sourceUri)
              .setFormatOptions(FormatOptions.json())
              .setSchema(schema)
              .build();
      Job job = bigquery.create(JobInfo.of(loadConfig));
      job = job.waitFor();
      if (job.isDone()) {
        System.out.printf("Json from GCS successfully loaded in a table '%s'.%n", tableName);
      } else {
        System.out.println(
            "BigQuery was unable to load into the table due to an error:"
                + job.getStatus().getError());
      }
    } catch (BigQueryException | InterruptedException e) {
      System.out.println("Column not added during load append \n" + e);
    }
  }

  public static Gson getGson() {
    JsonDeserializer<LegacySQLTypeName> typeDeserializer =
        (jsonElement, type, deserializationContext) -> {
          return LegacySQLTypeName.valueOf(jsonElement.getAsString());
        };

    JsonDeserializer<FieldList> subFieldsDeserializer =
        (jsonElement, type, deserializationContext) -> {
          Field[] fields =
              deserializationContext.deserialize(jsonElement.getAsJsonArray(), Field[].class);
          return FieldList.of(fields);
        };

    return new GsonBuilder()
        .registerTypeAdapter(LegacySQLTypeName.class, typeDeserializer)
        .registerTypeAdapter(FieldList.class, subFieldsDeserializer)
        .create();
  }
}
