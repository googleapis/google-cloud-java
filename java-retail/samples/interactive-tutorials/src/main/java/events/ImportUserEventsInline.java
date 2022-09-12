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
 * Import user events into a catalog from inline source using Retail API
 */

package events;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.retail.v2.ImportMetadata;
import com.google.cloud.retail.v2.ImportUserEventsRequest;
import com.google.cloud.retail.v2.ImportUserEventsResponse;
import com.google.cloud.retail.v2.UserEvent;
import com.google.cloud.retail.v2.UserEventInlineSource;
import com.google.cloud.retail.v2.UserEventInputConfig;
import com.google.cloud.retail.v2.UserEventServiceClient;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class ImportUserEventsInline {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = ServiceOptions.getDefaultProjectId();
    String defaultCatalog =
        String.format("projects/%s/locations/global/catalogs/default_catalog", projectId);

    importUserEventsFromInlineSource(defaultCatalog);
  }

  public static void importUserEventsFromInlineSource(String defaultCatalog)
      throws IOException, ExecutionException, InterruptedException {
    try {
      int userEventsNumber = 3;
      int awaitDuration = 30;
      List<UserEvent> userEvents = new ArrayList<>();

      for (int i = 0; i < userEventsNumber; i++) {
        Instant time = Instant.now();
        Timestamp timestamp = Timestamp.newBuilder().setSeconds(time.getEpochSecond()).build();

        UserEvent userEvent =
            UserEvent.newBuilder()
                .setEventType("home-page-view")
                .setVisitorId(UUID.randomUUID().toString())
                .setEventTime(timestamp)
                .build();

        userEvents.add(userEvent);

        System.out.printf("User Event: %s%n", i);
        System.out.println(userEvent);
      }

      UserEventInlineSource inlineSource =
          UserEventInlineSource.newBuilder().addAllUserEvents(userEvents).build();

      UserEventInputConfig inputConfig =
          UserEventInputConfig.newBuilder().setUserEventInlineSource(inlineSource).build();

      ImportUserEventsRequest importRequest =
          ImportUserEventsRequest.newBuilder()
              .setParent(defaultCatalog)
              .setInputConfig(inputConfig)
              .build();
      System.out.printf("Import user events from inline source request: %s%n", importRequest);

      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests. After completing all of your requests, call
      // the "close" method on the client to safely clean up any remaining background resources.
      try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
        OperationFuture<ImportUserEventsResponse, ImportMetadata> importOperation =
            userEventServiceClient.importUserEventsAsync(importRequest);

        System.out.printf("The operation was started: %s%n", importOperation.getName());
        System.out.println("Please wait till operation is done.");

        userEventServiceClient.awaitTermination(awaitDuration, TimeUnit.SECONDS);
        System.out.println("Import user events operation is done.");

        if (importOperation.getMetadata().get() != null) {
          System.out.printf(
              "Number of successfully imported events: %s%n",
              importOperation.getMetadata().get().getSuccessCount());

          System.out.printf(
              "Number of failures during the importing: %s%n",
              importOperation.getMetadata().get().getFailureCount());
        } else {
          System.out.println("Metadata in bigQuery operation is empty.");
        }
        if (importOperation.get() != null) {
          System.out.printf("Operation result: %s%n", importOperation.get());
        } else {
          System.out.println("Operation result is empty.");
        }
      }
    } catch (BigQueryException e) {
      System.out.printf("Exception message: %s", e.getMessage());
    }
  }
}
