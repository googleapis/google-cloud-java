/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.eventarc.publishing.v1.samples;

// [START eventarcpublishing_v1_generated_Publisher_PublishChannelConnectionEvents_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.eventarc.publishing.v1.PublishChannelConnectionEventsRequest;
import com.google.cloud.eventarc.publishing.v1.PublishChannelConnectionEventsResponse;
import com.google.cloud.eventarc.publishing.v1.PublisherClient;
import com.google.protobuf.Any;
import java.util.ArrayList;

public class AsyncPublishChannelConnectionEvents {

  public static void main(String[] args) throws Exception {
    asyncPublishChannelConnectionEvents();
  }

  public static void asyncPublishChannelConnectionEvents() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (PublisherClient publisherClient = PublisherClient.create()) {
      PublishChannelConnectionEventsRequest request =
          PublishChannelConnectionEventsRequest.newBuilder()
              .setChannelConnection("channelConnection-1932021695")
              .addAllEvents(new ArrayList<Any>())
              .addAllTextEvents(new ArrayList<String>())
              .build();
      ApiFuture<PublishChannelConnectionEventsResponse> future =
          publisherClient.publishChannelConnectionEventsCallable().futureCall(request);
      // Do something.
      PublishChannelConnectionEventsResponse response = future.get();
    }
  }
}
// [END eventarcpublishing_v1_generated_Publisher_PublishChannelConnectionEvents_async]
