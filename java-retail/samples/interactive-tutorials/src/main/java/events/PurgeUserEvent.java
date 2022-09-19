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
 * Purge user events into a catalog from inline source using Retail API
 */

package events;

import static setup.SetupCleanup.writeUserEvent;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.retail.v2.PurgeMetadata;
import com.google.cloud.retail.v2.PurgeUserEventsRequest;
import com.google.cloud.retail.v2.PurgeUserEventsResponse;
import com.google.cloud.retail.v2.UserEventServiceClient;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class PurgeUserEvent {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String defaultCatalog =
        String.format("projects/%s/locations/global/catalogs/default_catalog", projectId);
    // visitorId generated randomly.
    String visitorId = UUID.randomUUID().toString();

    callPurgeUserEvents(defaultCatalog, visitorId);
  }

  public static void callPurgeUserEvents(String defaultCatalog, String visitorId)
      throws IOException, ExecutionException, InterruptedException {
    writeUserEvent(visitorId);

    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
      PurgeUserEventsRequest purgeUserEventsRequest =
          PurgeUserEventsRequest.newBuilder()
              // TO CHECK ERROR HANDLING SET INVALID FILTER HERE:
              .setFilter(String.format("visitorId=\"%s\"", visitorId))
              .setParent(defaultCatalog)
              .setForce(true)
              .build();
      System.out.printf("Purge user events request: %s%n", purgeUserEventsRequest);

      OperationFuture<PurgeUserEventsResponse, PurgeMetadata> purgeOperation =
          userEventServiceClient.purgeUserEventsAsync(purgeUserEventsRequest);

      System.out.printf("The purge operation was started: %s%n", purgeOperation.getName());
    }
  }
}
