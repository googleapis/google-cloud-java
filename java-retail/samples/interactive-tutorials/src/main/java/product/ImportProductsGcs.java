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
 * Import products into a catalog from gcs using Retail API
 */

package product;

import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.PermissionDeniedException;
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
import java.io.IOException;
import java.time.Instant;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class ImportProductsGcs {

  public static void main(String[] args) throws IOException, InterruptedException {
    String projectId = ServiceOptions.getDefaultProjectId();
    String branchName =
        String.format(
            "projects/%s/locations/global/catalogs/default_catalog/branches/0", projectId);

    String bucketName = System.getenv("BUCKET_NAME");
    String gcsBucket = String.format("gs://%s", bucketName);
    String gcsErrorBucket = String.format("%s/errors", gcsBucket);

    // To check error handling, use an invalid catalog in request
    // branchName =
    // String.format("projects/%s/locations/global/catalogs/invalid_catalog/branches/default_branch", projectId);

    String gcsProductsObject = "products.json";
    // To check error handling, use an invalid product JSON.
    // gcsProductsObject = "products_some_invalid.json"

    importProductsFromGcs(branchName, gcsBucket, gcsProductsObject);
  }

  public static void importProductsFromGcs(
      String branchName, String gcsBucket, String gcsProductsObject)
      throws IOException, InterruptedException {
    String gcsErrorBucket = String.format("%s/errors", gcsBucket);

    GcsSource gcsSource =
        GcsSource.newBuilder()
            .addAllInputUris(
                Collections.singleton(String.format("%s/%s", gcsBucket, gcsProductsObject)))
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

    System.out.printf("Import products from google cloud source request: %s%n", importRequest);

    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (ProductServiceClient serviceClient = ProductServiceClient.create()) {
      String operationName = serviceClient.importProductsCallable().call(importRequest).getName();

      System.out.println("The operation was started.");
      System.out.printf("OperationName = %s%n", operationName);

      OperationsClient operationsClient = serviceClient.getOperationsClient();
      Operation operation = operationsClient.getOperation(operationName);

      Instant deadline = Instant.now().plusSeconds(60);

      while (!operation.getDone() || Instant.now().isBefore(deadline)) {
        System.out.println("Please wait till operation is done.");
        TimeUnit.SECONDS.sleep(30);
        operation = operationsClient.getOperation(operationName);
      }

      if (operation.hasMetadata()) {
        ImportMetadata metadata = operation.getMetadata().unpack(ImportMetadata.class);
        System.out.printf(
            "Number of successfully imported products: %s%n", metadata.getSuccessCount());
        System.out.printf(
            "Number of failures during the importing: %s%n", metadata.getFailureCount());
      } else {
        System.out.println("Metadata is empty.");
      }

      if (operation.hasResponse()) {
        ImportProductsResponse response =
            operation.getResponse().unpack(ImportProductsResponse.class);
        System.out.printf("Operation result: %s%n", response);
      } else {
        System.out.println("Operation result is empty.");
      }
    } catch (InvalidArgumentException e) {
      System.out.printf(
          "%s%n'%s' file does not exist in the bucket. Please "
              + "make sure you have followed the setting up instructions.",
          e.getMessage(), gcsProductsObject);
    } catch (PermissionDeniedException e) {
      System.out.println(e.getMessage());
    }
  }
}
