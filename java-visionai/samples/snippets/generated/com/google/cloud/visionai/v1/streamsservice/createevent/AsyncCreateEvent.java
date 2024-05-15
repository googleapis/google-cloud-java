/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.visionai.v1.samples;

// [START visionai_v1_generated_StreamsService_CreateEvent_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.visionai.v1.ClusterName;
import com.google.cloud.visionai.v1.CreateEventRequest;
import com.google.cloud.visionai.v1.Event;
import com.google.cloud.visionai.v1.StreamsServiceClient;
import com.google.longrunning.Operation;

public class AsyncCreateEvent {

  public static void main(String[] args) throws Exception {
    asyncCreateEvent();
  }

  public static void asyncCreateEvent() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
      CreateEventRequest request =
          CreateEventRequest.newBuilder()
              .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
              .setEventId("eventId-1376502443")
              .setEvent(Event.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      ApiFuture<Operation> future = streamsServiceClient.createEventCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END visionai_v1_generated_StreamsService_CreateEvent_async]
