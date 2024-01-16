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

package com.google.cloud.batch.v1alpha.samples;

// [START batch_v1alpha_generated_BatchService_ListTasks_sync]
import com.google.cloud.batch.v1alpha.BatchServiceClient;
import com.google.cloud.batch.v1alpha.ListTasksRequest;
import com.google.cloud.batch.v1alpha.Task;
import com.google.cloud.batch.v1alpha.TaskGroupName;

public class SyncListTasks {

  public static void main(String[] args) throws Exception {
    syncListTasks();
  }

  public static void syncListTasks() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (BatchServiceClient batchServiceClient = BatchServiceClient.create()) {
      ListTasksRequest request =
          ListTasksRequest.newBuilder()
              .setParent(
                  TaskGroupName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[TASK_GROUP]").toString())
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      for (Task element : batchServiceClient.listTasks(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END batch_v1alpha_generated_BatchService_ListTasks_sync]
