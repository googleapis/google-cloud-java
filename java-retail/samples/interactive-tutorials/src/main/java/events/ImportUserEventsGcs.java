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

// [START retail_import_user_events_from_gcs]

/*
 * Import user events into a catalog from GCS using Retail API
 */

package events;

import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.retail.v2.GcsSource;
import com.google.cloud.retail.v2.ImportErrorsConfig;
import com.google.cloud.retail.v2.ImportMetadata;
import com.google.cloud.retail.v2.ImportUserEventsRequest;
import com.google.cloud.retail.v2.ImportUserEventsResponse;
import com.google.cloud.retail.v2.UserEventInputConfig;
import com.google.cloud.retail.v2.UserEventServiceClient;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import events.setup.EventsCreateGcsBucket;
import java.io.IOException;

public class ImportUserEventsGcs {

  public static void main(String[] args) throws IOException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = ServiceOptions.getDefaultProjectId();
    String defaultCatalog =
        String.format("projects/%s/locations/global/catalogs/default_catalog", projectId);
    // TO CHECK ERROR HANDLING PASTE THE INVALID CATALOG NAME HERE: defaultCatalog =
    // "invalid_catalog_name"
    String gcsEventsObject = "user_events.json";
    // TO CHECK ERROR HANDLING USE THE JSON WITH INVALID USER EVENT: gcsEventsObject =
    // "user_events_some_invalid.json"

    importUserEventsFromGcs(gcsEventsObject, defaultCatalog);
  }

  public static void importUserEventsFromGcs(String gcsEventsObject, String defaultCatalog)
      throws IOException, InterruptedException {
    try {
      String gcsBucket = String.format("gs://%s", EventsCreateGcsBucket.getBucketName());
      String gcsErrorsBucket = String.format("%s/error", gcsBucket);

      GcsSource gcsSource =
          GcsSource.newBuilder()
              .addInputUris(String.format("%s/%s", gcsBucket, gcsEventsObject))
              .build();

      UserEventInputConfig inputConfig =
          UserEventInputConfig.newBuilder().setGcsSource(gcsSource).build();

      ImportErrorsConfig errorsConfig =
          ImportErrorsConfig.newBuilder().setGcsPrefix(gcsErrorsBucket).build();

      ImportUserEventsRequest importRequest =
          ImportUserEventsRequest.newBuilder()
              .setParent(defaultCatalog)
              .setInputConfig(inputConfig)
              .setErrorsConfig(errorsConfig)
              .build();

      System.out.printf("Import user events from google cloud source request: %s%n", importRequest);

      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests. After completing all of your requests, call
      // the "close" method on the client to safely clean up any remaining background resources.
      try (UserEventServiceClient serviceClient = UserEventServiceClient.create()) {
        String operationName =
            serviceClient.importUserEventsCallable().call(importRequest).getName();

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
              "Number of successfully imported events: %s\n", metadata.getSuccessCount());
          System.out.printf(
              "Number of failures during the importing: %s\n", metadata.getFailureCount());
        }

        if (operation.hasResponse()) {
          ImportUserEventsResponse response =
              operation.getResponse().unpack(ImportUserEventsResponse.class);
          System.out.printf("Operation result: %s%n", response);
        }
      } catch (InvalidArgumentException e) {
        System.out.printf(
            "Given GCS input path was not found. %n%s%n "
                + "Please run CreateTestResources class to create resources.",
            e.getMessage());
      }
    } catch (BigQueryException e) {
      System.out.printf("Exception message: %s", e.getMessage());
    }
  }
}

// [END retail_import_user_events_from_gcs]
