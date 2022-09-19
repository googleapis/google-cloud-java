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
 * Import user events into a catalog from GCS using Retail API
 */

package events;

import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.PermissionDeniedException;
import com.google.cloud.retail.v2.GcsSource;
import com.google.cloud.retail.v2.ImportErrorsConfig;
import com.google.cloud.retail.v2.ImportMetadata;
import com.google.cloud.retail.v2.ImportUserEventsRequest;
import com.google.cloud.retail.v2.ImportUserEventsResponse;
import com.google.cloud.retail.v2.UserEventInputConfig;
import com.google.cloud.retail.v2.UserEventServiceClient;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import java.io.IOException;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class ImportUserEventsGcs {

  public static void main(String[] args) throws IOException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String defaultCatalog =
        String.format("projects/%s/locations/global/catalogs/default_catalog", projectId);
    // TO CHECK ERROR HANDLING PASTE THE INVALID CATALOG NAME HERE:
    // defaultCatalog = "invalid_catalog_name";
    String bucketName = System.getenv("EVENTS_BUCKET_NAME");
    String gcsUserEventsObject = "user_events.json";
    // TO CHECK ERROR HANDLING USE THE JSON WITH INVALID USER EVENT:
    // gcsUserEventsObject = "user_events_some_invalid.json";

    importUserEventsFromGcs(defaultCatalog, bucketName, gcsUserEventsObject);
  }

  public static void importUserEventsFromGcs(
      String defaultCatalog, String bucketName, String gcsUserEventsObject)
      throws IOException, InterruptedException {
    String gcsBucket = String.format("gs://%s", bucketName);
    String gcsErrorsBucket = String.format("%s/error", gcsBucket);

    GcsSource gcsSource =
        GcsSource.newBuilder()
            .addInputUris(String.format("%s/%s", gcsBucket, gcsUserEventsObject))
            .build();

    UserEventInputConfig inputConfig =
        UserEventInputConfig.newBuilder().setGcsSource(gcsSource).build();

    System.out.println("GCS source: " + gcsSource.getInputUrisList());

    ImportErrorsConfig errorsConfig =
        ImportErrorsConfig.newBuilder().setGcsPrefix(gcsErrorsBucket).build();

    ImportUserEventsRequest importRequest =
        ImportUserEventsRequest.newBuilder()
            .setParent(defaultCatalog)
            .setInputConfig(inputConfig)
            .setErrorsConfig(errorsConfig)
            .build();
    System.out.printf("Import user events from google cloud source request: %s%n", importRequest);

    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (UserEventServiceClient serviceClient = UserEventServiceClient.create()) {
      String operationName = serviceClient.importUserEventsCallable().call(importRequest).getName();

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
            "Number of successfully imported events: %s%n", metadata.getSuccessCount());
        System.out.printf(
            "Number of failures during the importing: %s%n", metadata.getFailureCount());
      } else {
        System.out.println("Metadata is empty.");
      }

      if (operation.hasResponse()) {
        ImportUserEventsResponse response =
            operation.getResponse().unpack(ImportUserEventsResponse.class);
        System.out.printf("Operation result: %s%n", response);
      } else {
        System.out.println("Operation result is empty.");
      }
    } catch (InvalidArgumentException e) {
      System.out.printf(
          "%s%n'%s' file does not exist in the bucket. Please "
              + "make sure you have followed the setting up instructions.",
          e.getMessage(), gcsUserEventsObject);
    } catch (PermissionDeniedException e) {
      System.out.println(e.getMessage());
    }
  }
}
