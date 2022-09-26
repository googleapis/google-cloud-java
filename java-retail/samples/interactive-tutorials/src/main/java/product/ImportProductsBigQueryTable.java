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

/*
 * Import products into a catalog from big query table using Retail API
 */

package product;

import com.google.cloud.ServiceOptions;
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
import java.util.concurrent.TimeUnit;

public class ImportProductsBigQueryTable {

  public static void main(String[] args) throws IOException, InterruptedException {
    String projectId = ServiceOptions.getDefaultProjectId();
    // To check for error handling, replace the below variable with the invalid branch name.
    // String branchName = "invalid_branch_name";
    String branchName =
        String.format(
            "projects/%s/locations/global/catalogs/default_catalog/branches/0", projectId);
    String datasetId = "products";
    // To check for error handling, replace the below variable with table id that contains invalid
    // products.
    // String tableId = "products_some_invalid";
    String tableId = "products";

    importProductsFromBigQuery(projectId, branchName, datasetId, tableId);
  }

  public static void importProductsFromBigQuery(
      String projectId, String branchName, String datasetId, String tableId)
      throws IOException, InterruptedException {
    // TRY THE FULL RECONCILIATION MODE HERE:
    ReconciliationMode reconciliationMode = ReconciliationMode.INCREMENTAL;
    String dataSchema = "product";

    BigQuerySource bigQuerySource =
        BigQuerySource.newBuilder()
            .setProjectId(projectId)
            .setDatasetId(datasetId)
            .setTableId(tableId)
            .setDataSchema(dataSchema)
            .build();

    ProductInputConfig inputConfig =
        ProductInputConfig.newBuilder().setBigQuerySource(bigQuerySource).build();

    ImportProductsRequest importRequest =
        ImportProductsRequest.newBuilder()
            .setParent(branchName)
            .setReconciliationMode(reconciliationMode)
            .setInputConfig(inputConfig)
            .build();
    System.out.printf("Import products from big query table request: %s%n", importRequest);

    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (ProductServiceClient serviceClient = ProductServiceClient.create()) {
      String operationName = serviceClient.importProductsCallable().call(importRequest).getName();
      System.out.printf("OperationName = %s%n", operationName);

      OperationsClient operationsClient = serviceClient.getOperationsClient();
      Operation operation = operationsClient.getOperation(operationName);

      while (!operation.getDone()) {
        // Keep polling the operation periodically until the import task is done.
        TimeUnit.SECONDS.sleep(30);
        operation = operationsClient.getOperation(operationName);
      }

      if (operation.hasMetadata()) {
        ImportMetadata metadata = operation.getMetadata().unpack(ImportMetadata.class);
        System.out.printf(
            "Number of successfully imported products: %s%n", metadata.getSuccessCount());
        System.out.printf(
            "Number of failures during the importing: %s%n", metadata.getFailureCount());
      }

      if (operation.hasResponse()) {
        ImportProductsResponse response =
            operation.getResponse().unpack(ImportProductsResponse.class);
        System.out.printf("Operation result: %s%n", response);
      }
    }
  }
}
