/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.geminidataanalytics.v1beta.samples;

// [START geminidataanalytics_v1beta_generated_ContextRetrievalService_RetrieveBigQueryTableSuggestedDescriptions_sync]
import com.google.cloud.geminidataanalytics.v1beta.ContextRetrievalServiceClient;
import com.google.cloud.geminidataanalytics.v1beta.DirectLookup;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableSuggestedDescriptionsRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableSuggestedDescriptionsResponse;
import java.util.ArrayList;

public class SyncRetrieveBigQueryTableSuggestedDescriptions {

  public static void main(String[] args) throws Exception {
    syncRetrieveBigQueryTableSuggestedDescriptions();
  }

  public static void syncRetrieveBigQueryTableSuggestedDescriptions() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ContextRetrievalServiceClient contextRetrievalServiceClient =
        ContextRetrievalServiceClient.create()) {
      RetrieveBigQueryTableSuggestedDescriptionsRequest request =
          RetrieveBigQueryTableSuggestedDescriptionsRequest.newBuilder()
              .setParent("parent-995424086")
              .addAllDirectLookup(new ArrayList<DirectLookup>())
              .build();
      RetrieveBigQueryTableSuggestedDescriptionsResponse response =
          contextRetrievalServiceClient.retrieveBigQueryTableSuggestedDescriptions(request);
    }
  }
}
// [END geminidataanalytics_v1beta_generated_ContextRetrievalService_RetrieveBigQueryTableSuggestedDescriptions_sync]
