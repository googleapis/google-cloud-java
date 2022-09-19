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

package com.google.cloud.tasks.v2beta3.samples;

// [START tasks_v2beta3_generated_cloudtasksclient_listtasks_paged_async]
import com.google.cloud.tasks.v2beta3.CloudTasksClient;
import com.google.cloud.tasks.v2beta3.ListTasksRequest;
import com.google.cloud.tasks.v2beta3.ListTasksResponse;
import com.google.cloud.tasks.v2beta3.QueueName;
import com.google.cloud.tasks.v2beta3.Task;
import com.google.common.base.Strings;

public class AsyncListTasksPaged {

  public static void main(String[] args) throws Exception {
    asyncListTasksPaged();
  }

  public static void asyncListTasksPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudTasksClient cloudTasksClient = CloudTasksClient.create()) {
      ListTasksRequest request =
          ListTasksRequest.newBuilder()
              .setParent(QueueName.of("[PROJECT]", "[LOCATION]", "[QUEUE]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListTasksResponse response = cloudTasksClient.listTasksCallable().call(request);
        for (Task element : response.getTasksList()) {
          // doThingsWith(element);
        }
        String nextPageToken = response.getNextPageToken();
        if (!Strings.isNullOrEmpty(nextPageToken)) {
          request = request.toBuilder().setPageToken(nextPageToken).build();
        } else {
          break;
        }
      }
    }
  }
}
// [END tasks_v2beta3_generated_cloudtasksclient_listtasks_paged_async]
