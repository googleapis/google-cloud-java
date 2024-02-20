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

package com.google.cloud.discoveryengine.v1.samples;

// [START discoveryengine_v1_generated_SiteSearchEngineService_RecrawlUris_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.discoveryengine.v1.RecrawlUrisMetadata;
import com.google.cloud.discoveryengine.v1.RecrawlUrisRequest;
import com.google.cloud.discoveryengine.v1.RecrawlUrisResponse;
import com.google.cloud.discoveryengine.v1.SiteSearchEngineName;
import com.google.cloud.discoveryengine.v1.SiteSearchEngineServiceClient;
import java.util.ArrayList;

public class AsyncRecrawlUrisLRO {

  public static void main(String[] args) throws Exception {
    asyncRecrawlUrisLRO();
  }

  public static void asyncRecrawlUrisLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
        SiteSearchEngineServiceClient.create()) {
      RecrawlUrisRequest request =
          RecrawlUrisRequest.newBuilder()
              .setSiteSearchEngine(
                  SiteSearchEngineName.ofProjectLocationDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                      .toString())
              .addAllUris(new ArrayList<String>())
              .build();
      OperationFuture<RecrawlUrisResponse, RecrawlUrisMetadata> future =
          siteSearchEngineServiceClient.recrawlUrisOperationCallable().futureCall(request);
      // Do something.
      RecrawlUrisResponse response = future.get();
    }
  }
}
// [END discoveryengine_v1_generated_SiteSearchEngineService_RecrawlUris_LRO_async]
