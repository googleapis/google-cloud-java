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

package com.google.cloud.aiplatform.v1beta1.samples;

// [START aiplatform_v1beta1_generated_ReasoningEngineRuntimeRevisionService_ListReasoningEngineRuntimeRevisions_sync]
import com.google.cloud.aiplatform.v1beta1.ListReasoningEngineRuntimeRevisionsRequest;
import com.google.cloud.aiplatform.v1beta1.ReasoningEngineName;
import com.google.cloud.aiplatform.v1beta1.ReasoningEngineRuntimeRevision;
import com.google.cloud.aiplatform.v1beta1.ReasoningEngineRuntimeRevisionServiceClient;

public class SyncListReasoningEngineRuntimeRevisions {

  public static void main(String[] args) throws Exception {
    syncListReasoningEngineRuntimeRevisions();
  }

  public static void syncListReasoningEngineRuntimeRevisions() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
        ReasoningEngineRuntimeRevisionServiceClient.create()) {
      ListReasoningEngineRuntimeRevisionsRequest request =
          ListReasoningEngineRuntimeRevisionsRequest.newBuilder()
              .setParent(
                  ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]")
                      .toString())
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      for (ReasoningEngineRuntimeRevision element :
          reasoningEngineRuntimeRevisionServiceClient
              .listReasoningEngineRuntimeRevisions(request)
              .iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END aiplatform_v1beta1_generated_ReasoningEngineRuntimeRevisionService_ListReasoningEngineRuntimeRevisions_sync]
