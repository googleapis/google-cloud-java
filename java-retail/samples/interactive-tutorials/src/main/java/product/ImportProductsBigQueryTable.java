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

// [START retail_import_products_from_big_query]

/*
 * Import products into a catalog from big query table using Retail API
 */

package product;

import com.google.cloud.retail.v2.BigQuerySource;
import com.google.cloud.retail.v2.ImportMetadata;
import com.google.cloud.retail.v2.ImportProductsRequest;
import com.google.cloud.retail.v2.ImportProductsRequest.ReconciliationMode;
import com.google.cloud.retail.v2.ImportProductsResponse;
import com.google.cloud.retail.v2.ProductInputConfig;
import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import java.io.IOException;

public class ImportProductsBigQueryTable {

  private static final String PROJECT_ID = System.getenv("PROJECT_ID");
  private static final String DEFAULT_CATALOG =
      String.format(
          "projects/%s/locations/global/catalogs/default_catalog/" + "branches/0", PROJECT_ID);
  private static final String DATASET_ID = "products";
  private static final String TABLE_ID = "products";
  // TO CHECK ERROR HANDLING USE THE TABLE WITH INVALID PRODUCTS:
  // TABLE_ID = "products_some_invalid"
  private static final String DATA_SCHEMA = "product";

  public static void main(String[] args) throws IOException, InterruptedException {
    // TRY THE FULL RECONCILIATION MODE HERE:
    ReconciliationMode reconciliationMode = ReconciliationMode.INCREMENTAL;
    ImportProductsRequest importBigQueryRequest =
        getImportProductsBigQueryRequest(reconciliationMode);
    waitForOperationCompletion(importBigQueryRequest);
  }

  public static ImportProductsRequest getImportProductsBigQueryRequest(
      ReconciliationMode reconciliationMode) {
    BigQuerySource bigQuerySource =
        BigQuerySource.newBuilder()
            .setProjectId(PROJECT_ID)
            .setDatasetId(DATASET_ID)
            .setTableId(TABLE_ID)
            .setDataSchema(DATA_SCHEMA)
            .build();

    ProductInputConfig inputConfig =
        ProductInputConfig.newBuilder().setBigQuerySource(bigQuerySource).build();

    ImportProductsRequest importRequest =
        ImportProductsRequest.newBuilder()
            .setParent(DEFAULT_CATALOG)
            .setReconciliationMode(reconciliationMode)
            .setInputConfig(inputConfig)
            .build();
    System.out.printf("Import products from big query table request: %s%n", importRequest);

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

// [END retail_import_products_from_big_query]
