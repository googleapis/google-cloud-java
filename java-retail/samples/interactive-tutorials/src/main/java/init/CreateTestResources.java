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

package init;

import com.google.cloud.ServiceOptions;
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
import events.setup.EventsCreateBigQueryTable;
import events.setup.EventsCreateGcsBucket;
import java.io.IOException;
import java.util.Collections;
import product.setup.ProductsCreateBigqueryTable;
import product.setup.ProductsCreateGcsBucket;

public class CreateTestResources {

  public static void main(String... args) throws IOException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = ServiceOptions.getDefaultProjectId();
    String bucketName = System.getenv("BUCKET_NAME");
    String gcsBucket = String.format("gs://%s", System.getenv("BUCKET_NAME"));
    String gcsErrorBucket = String.format("%s/errors", gcsBucket);
    String branchName =
        String.format(
            "projects/%s/locations/global/catalogs/default_catalog/branches/0", projectId);

    ProductsCreateGcsBucket.main();
    EventsCreateGcsBucket.main();
    importProductsFromGcs(bucketName, gcsErrorBucket, branchName);
    ProductsCreateBigqueryTable.main();
    EventsCreateBigQueryTable.main();
  }

  public static void importProductsFromGcs(
      String bucketName, String gcsErrorBucket, String branchName)
      throws IOException, InterruptedException {
    GcsSource gcsSource =
        GcsSource.newBuilder()
            .addAllInputUris(
                Collections.singleton(String.format("gs://%s/%s", bucketName, "products.json")))
            .build();
    ProductInputConfig inputConfig =
        ProductInputConfig.newBuilder().setGcsSource(gcsSource).build();
    System.out.println("GRS source: " + gcsSource.getInputUrisList());

    ImportErrorsConfig errorsConfig =
        ImportErrorsConfig.newBuilder().setGcsPrefix(gcsErrorBucket).build();
    ImportProductsRequest importRequest =
        ImportProductsRequest.newBuilder()
            .setParent(branchName)
            .setReconciliationMode(ReconciliationMode.INCREMENTAL)
            .setInputConfig(inputConfig)
            .setErrorsConfig(errorsConfig)
            .build();
    System.out.println("Import products from google cloud source request: " + importRequest);

    try (ProductServiceClient serviceClient = ProductServiceClient.create()) {
      String operationName = serviceClient.importProductsCallable().call(importRequest).getName();
      System.out.printf("OperationName = %s\n", operationName);

      OperationsClient operationsClient = serviceClient.getOperationsClient();
      Operation operation = operationsClient.getOperation(operationName);

      while (!operation.getDone()) {
        System.out.println("Please wait till operation is completed.");
        // Keep polling the operation periodically until the import task is done.
        Thread.sleep(30_000);
        operation = operationsClient.getOperation(operationName);
      }

      System.out.println("Import products operation is completed.");

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
        System.out.printf("Operation result: %s", response);
      }
    }
  }
}
