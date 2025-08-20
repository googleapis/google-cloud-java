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

// [START geminidataanalytics_v1beta_generated_ContextRetrievalService_RetrieveBigQueryTableContext_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.geminidataanalytics.v1beta.ContextRetrievalServiceClient;
import com.google.cloud.geminidataanalytics.v1beta.DirectLookup;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextResponse;
import java.util.ArrayList;

public class AsyncRetrieveBigQueryTableContext {

  public static void main(String[] args) throws Exception {
    asyncRetrieveBigQueryTableContext();
  }

  public static void asyncRetrieveBigQueryTableContext() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ContextRetrievalServiceClient contextRetrievalServiceClient =
        ContextRetrievalServiceClient.create()) {
      RetrieveBigQueryTableContextRequest request =
          RetrieveBigQueryTableContextRequest.newBuilder()
              .setProject("project-309310695")
              .setParent("parent-995424086")
              .setQuery("query107944136")
              .addAllDirectLookup(new ArrayList<DirectLookup>())
              .build();
      ApiFuture<RetrieveBigQueryTableContextResponse> future =
          contextRetrievalServiceClient.retrieveBigQueryTableContextCallable().futureCall(request);
      // Do something.
      RetrieveBigQueryTableContextResponse response = future.get();
    }
  }
}
// [END geminidataanalytics_v1beta_generated_ContextRetrievalService_RetrieveBigQueryTableContext_async]
