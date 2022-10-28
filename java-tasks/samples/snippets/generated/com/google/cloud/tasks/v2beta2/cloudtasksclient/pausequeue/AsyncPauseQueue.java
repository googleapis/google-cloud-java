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

package com.google.cloud.tasks.v2beta2.samples;

// [START cloudtasks_v2beta2_generated_cloudtasksclient_pausequeue_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.tasks.v2beta2.CloudTasksClient;
import com.google.cloud.tasks.v2beta2.PauseQueueRequest;
import com.google.cloud.tasks.v2beta2.Queue;
import com.google.cloud.tasks.v2beta2.QueueName;

public class AsyncPauseQueue {

  public static void main(String[] args) throws Exception {
    asyncPauseQueue();
  }

  public static void asyncPauseQueue() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudTasksClient cloudTasksClient = CloudTasksClient.create()) {
      PauseQueueRequest request =
          PauseQueueRequest.newBuilder()
              .setName(QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]").toString())
              .build();
      ApiFuture<Queue> future = cloudTasksClient.pauseQueueCallable().futureCall(request);
      // Do something.
      Queue response = future.get();
    }
  }
}
// [END cloudtasks_v2beta2_generated_cloudtasksclient_pausequeue_async]
