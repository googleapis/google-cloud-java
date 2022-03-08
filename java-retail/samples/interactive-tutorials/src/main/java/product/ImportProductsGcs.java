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

// [START retail_import_products_from_gcs]

/*
 * Import products into a catalog from gcs using Retail API
 */

package product;

import com.google.cloud.retail.v2.GcsSource;
import com.google.cloud.retail.v2.ImportErrorsConfig;
import com.google.cloud.retail.v2.ImportMetadata;
import com.google.cloud.retail.v2.ImportProductsRequest;
import com.google.cloud.retail.v2.ImportProductsRequest.ReconciliationMode;
import com.google.cloud.retail.v2.ImportProductsResponse;
import com.google.cloud.retail.v2.ProductInputConfig;
import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import java.io.IOException;
import java.util.Collections;

public class ImportProductsGcs {

  private static final String PROJECT_ID = System.getenv("PROJECT_ID");
  private static final String DEFAULT_CATALOG =
      String.format(
          "projects/%s/locations/global/catalogs/default_catalog/" + "branches/default_branch",
          PROJECT_ID);
  private static final String GCS_BUCKET = String.format("gs://%s", System.getenv("BUCKET_NAME"));
  private static final String GCS_ERROR_BUCKET = String.format("%s/errors", GCS_BUCKET);
  private static final String GCS_PRODUCTS_OBJECT = "products.json";
  // TO CHECK ERROR HANDLING USE THE JSON WITH INVALID PRODUCT
  // GCS_PRODUCTS_OBJECT = "products_some_invalid.json"

  public static void main(String[] args) throws IOException, InterruptedException {
    ImportProductsRequest importGcsRequest = getImportProductsGcsRequest(GCS_PRODUCTS_OBJECT);
    waitForOperationCompletion(importGcsRequest);
  }

  public static ImportProductsRequest getImportProductsGcsRequest(String gcsObjectName) {
    GcsSource gcsSource =
        GcsSource.newBuilder()
            .addAllInputUris(
                Collections.singleton(String.format("%s/%s", GCS_BUCKET, gcsObjectName)))
            .build();

    ProductInputConfig inputConfig =
        ProductInputConfig.newBuilder().setGcsSource(gcsSource).build();

    System.out.println("GRS source: " + gcsSource.getInputUrisList());

    ImportErrorsConfig errorsConfig =
        ImportErrorsConfig.newBuilder().setGcsPrefix(GCS_ERROR_BUCKET).build();

    ImportProductsRequest importRequest =
        ImportProductsRequest.newBuilder()
            .setParent(DEFAULT_CATALOG)
            .setReconciliationMode(ReconciliationMode.INCREMENTAL)
            .setInputConfig(inputConfig)
            .setErrorsConfig(errorsConfig)
            .build();

    System.out.println("Import products from google cloud source request: " + importRequest);

    return importRequest;
  }

  private static void waitForOperationCompletion(ImportProductsRequest importRequest)
      throws IOException, InterruptedException {
    try (ProductServiceClient serviceClient = ProductServiceClient.create()) {
      String operationName = serviceClient.importProductsCallable().call(importRequest).getName();
      System.out.printf("OperationName = %s\n", operationName);

      OperationsClient operationsClient = serviceClient.getOperationsClient();
      Operation operation = operationsClient.getOperation(operationName);

      while (!operation.getDone()) {
        // Keep polling the operation periodically until the import task is done.
        int awaitDuration = 30000;
        Thread.sleep(awaitDuration);
        operation = operationsClient.getOperation(operationName);
      }

      if (operation.hasMetadata()) {
        ImportMetadata metadata = operation.getMetadata().unpack(ImportMetadata.class);
        System.out.printf(
            "Number of successfully imported products: %s\n", metadata.getSuccessCount());
        System.out.printf(
            "Number of failures during the importing: %s\n", metadata.getFailureCount());
      }

      if (operation.hasResponse()) {
        ImportProductsResponse response =
            operation.getResponse().unpack(ImportProductsResponse.class);
        System.out.printf("Operation result: %s%n", response);
      }
    }
  }
}

// [END retail_import_products_from_gcs]
