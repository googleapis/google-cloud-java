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

import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.retail.v2.BigQuerySource;
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

public class ImportUserEventsBigQuery {

  public static void main(String[] args) throws IOException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = ServiceOptions.getDefaultProjectId();
    String defaultCatalog =
        String.format("projects/%s/locations/global/catalogs/default_catalog", projectId);
    // TO CHECK ERROR HANDLING PASTE THE INVALID CATALOG NAME HERE:
    // defaultCatalog = "invalid_catalog_name";
    String datasetId = "user_events";
    String tableId = "events";
    // TO CHECK ERROR HANDLING USE THE TABLE OF INVALID USER EVENTS:
    // tableId = "events_some_invalid";

    importUserEventsFromBigQuery(projectId, defaultCatalog, datasetId, tableId);
  }

  public static void importUserEventsFromBigQuery(
      String projectId, String defaultCatalog, String datasetId, String tableId)
      throws IOException, InterruptedException {

    try {
      String dataSchema = "user_event";

      BigQuerySource bigQuerySource =
          BigQuerySource.newBuilder()
              .setProjectId(projectId)
              .setDatasetId(datasetId)
              .setTableId(tableId)
              .setDataSchema(dataSchema)
              .build();

      UserEventInputConfig inputConfig =
          UserEventInputConfig.newBuilder().setBigQuerySource(bigQuerySource).build();

      ImportUserEventsRequest importRequest =
          ImportUserEventsRequest.newBuilder()
              .setParent(defaultCatalog)
              .setInputConfig(inputConfig)
              .build();

      System.out.printf("Import user events from BigQuery source request: %s%n", importRequest);

      // Initialize client that will be used to send requests. This client only
      // needs to be created once, and can be reused for multiple requests. After
      // completing all of your requests, call the "close" method on the client to
      // safely clean up any remaining background resources.
      try (UserEventServiceClient serviceClient = UserEventServiceClient.create()) {
        String operationName =
            serviceClient.importUserEventsCallable().call(importRequest).getName();

        System.out.printf("OperationName = %s%n", operationName);
        OperationsClient operationsClient = serviceClient.getOperationsClient();
        Operation operation = operationsClient.getOperation(operationName);

        Instant deadline = Instant.now().plusSeconds(60);

        while (!operation.getDone() || Instant.now().isBefore(deadline)) {
          // Keep polling the operation periodically until the import task is done.
          TimeUnit.SECONDS.sleep(30);
          operation = operationsClient.getOperation(operationName);
        }

        if (operation.hasMetadata()) {
          ImportMetadata metadata = operation.getMetadata().unpack(ImportMetadata.class);
          System.out.printf(
              "Number of successfully imported events: %s%n", metadata.getSuccessCount());
          System.out.printf(
              "Number of failures during the importing: %s%n", metadata.getFailureCount());
        }

        if (operation.hasResponse()) {
          ImportUserEventsResponse response =
              operation.getResponse().unpack(ImportUserEventsResponse.class);
          System.out.printf("Operation result: %s%n", response);
        }
      }
    } catch (BigQueryException e) {
      System.out.printf("Exception message: %s", e.getMessage());
    } catch (NotFoundException e) {
      System.out.printf("Catalog name is not found.%n%s%n", e.getMessage());
    }
  }
}
