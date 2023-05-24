/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.datastream.v1.samples;

// [START datastream_v1_generated_Datastream_StopBackfillJob_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.datastream.v1.DatastreamClient;
import com.google.cloud.datastream.v1.StopBackfillJobRequest;
import com.google.cloud.datastream.v1.StopBackfillJobResponse;
import com.google.cloud.datastream.v1.StreamObjectName;

public class AsyncStopBackfillJob {

  public static void main(String[] args) throws Exception {
    asyncStopBackfillJob();
  }

  public static void asyncStopBackfillJob() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DatastreamClient datastreamClient = DatastreamClient.create()) {
      StopBackfillJobRequest request =
          StopBackfillJobRequest.newBuilder()
              .setObject(
                  StreamObjectName.of("[PROJECT]", "[LOCATION]", "[STREAM]", "[OBJECT]").toString())
              .build();
      ApiFuture<StopBackfillJobResponse> future =
          datastreamClient.stopBackfillJobCallable().futureCall(request);
      // Do something.
      StopBackfillJobResponse response = future.get();
    }
  }
}
// [END datastream_v1_generated_Datastream_StopBackfillJob_async]
