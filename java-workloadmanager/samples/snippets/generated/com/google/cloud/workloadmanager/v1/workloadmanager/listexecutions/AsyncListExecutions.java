/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.workloadmanager.v1.samples;

// [START workloadmanager_v1_generated_WorkloadManager_ListExecutions_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.workloadmanager.v1.EvaluationName;
import com.google.cloud.workloadmanager.v1.Execution;
import com.google.cloud.workloadmanager.v1.ListExecutionsRequest;
import com.google.cloud.workloadmanager.v1.WorkloadManagerClient;

public class AsyncListExecutions {

  public static void main(String[] args) throws Exception {
    asyncListExecutions();
  }

  public static void asyncListExecutions() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (WorkloadManagerClient workloadManagerClient = WorkloadManagerClient.create()) {
      ListExecutionsRequest request =
          ListExecutionsRequest.newBuilder()
              .setParent(EvaluationName.of("[PROJECT]", "[LOCATION]", "[EVALUATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .build();
      ApiFuture<Execution> future =
          workloadManagerClient.listExecutionsPagedCallable().futureCall(request);
      // Do something.
      for (Execution element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END workloadmanager_v1_generated_WorkloadManager_ListExecutions_async]
