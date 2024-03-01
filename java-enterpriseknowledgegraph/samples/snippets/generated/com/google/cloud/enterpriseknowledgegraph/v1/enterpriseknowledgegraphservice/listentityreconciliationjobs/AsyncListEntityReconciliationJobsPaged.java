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

package com.google.cloud.enterpriseknowledgegraph.v1.samples;

// [START enterpriseknowledgegraph_v1_generated_EnterpriseKnowledgeGraphService_ListEntityReconciliationJobs_Paged_async]
import com.google.cloud.enterpriseknowledgegraph.v1.EnterpriseKnowledgeGraphServiceClient;
import com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob;
import com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsResponse;
import com.google.cloud.enterpriseknowledgegraph.v1.LocationName;
import com.google.common.base.Strings;

public class AsyncListEntityReconciliationJobsPaged {

  public static void main(String[] args) throws Exception {
    asyncListEntityReconciliationJobsPaged();
  }

  public static void asyncListEntityReconciliationJobsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (EnterpriseKnowledgeGraphServiceClient enterpriseKnowledgeGraphServiceClient =
        EnterpriseKnowledgeGraphServiceClient.create()) {
      ListEntityReconciliationJobsRequest request =
          ListEntityReconciliationJobsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListEntityReconciliationJobsResponse response =
            enterpriseKnowledgeGraphServiceClient
                .listEntityReconciliationJobsCallable()
                .call(request);
        for (EntityReconciliationJob element : response.getEntityReconciliationJobsList()) {
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
// [END enterpriseknowledgegraph_v1_generated_EnterpriseKnowledgeGraphService_ListEntityReconciliationJobs_Paged_async]
