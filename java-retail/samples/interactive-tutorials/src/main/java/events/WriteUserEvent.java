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
 * Write user events into a catalog from inline source using Retail API
 */

package events;

import static setup.SetupCleanup.purgeUserEvent;

import com.google.cloud.ServiceOptions;
import com.google.cloud.retail.v2.UserEvent;
import com.google.cloud.retail.v2.UserEventServiceClient;
import com.google.cloud.retail.v2.WriteUserEventRequest;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class WriteUserEvent {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = ServiceOptions.getDefaultProjectId();
    String defaultCatalog =
        String.format("projects/%s/locations/global/catalogs/default_catalog", projectId);
    // visitorId generated randomly.
    String visitorId = UUID.randomUUID().toString();

    writeUserEvent(defaultCatalog, visitorId);
  }

  public static void writeUserEvent(String defaultCatalog, String visitorId)
      throws IOException, ExecutionException, InterruptedException {
    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
      Timestamp timestamp =
          Timestamp.newBuilder().setSeconds(Instant.now().getEpochSecond()).build();

      UserEvent userEvent =
          UserEvent.newBuilder()
              .setEventType("home-page-view")
              .setVisitorId(visitorId)
              .setEventTime(timestamp)
              .build();
      System.out.println(userEvent);

      WriteUserEventRequest writeUserEventRequest =
          WriteUserEventRequest.newBuilder()
              .setUserEvent(userEvent)
              .setParent(defaultCatalog)
              .build();
      System.out.printf("Write user event request: %s%n", writeUserEventRequest);

      userEventServiceClient.writeUserEvent(writeUserEventRequest);
      System.out.printf("Written user event: %s%n", userEvent);
    }

    purgeUserEvent(visitorId);
  }
}
