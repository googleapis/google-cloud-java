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

package com.google.cloud.discoveryengine.v1.samples;

// [START discoveryengine_v1_generated_SiteSearchEngineService_FetchSitemaps_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.discoveryengine.v1.FetchSitemapsRequest;
import com.google.cloud.discoveryengine.v1.FetchSitemapsResponse;
import com.google.cloud.discoveryengine.v1.SiteSearchEngineName;
import com.google.cloud.discoveryengine.v1.SiteSearchEngineServiceClient;

public class AsyncFetchSitemaps {

  public static void main(String[] args) throws Exception {
    asyncFetchSitemaps();
  }

  public static void asyncFetchSitemaps() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
        SiteSearchEngineServiceClient.create()) {
      FetchSitemapsRequest request =
          FetchSitemapsRequest.newBuilder()
              .setParent(
                  SiteSearchEngineName.ofProjectLocationDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                      .toString())
              .setMatcher(FetchSitemapsRequest.Matcher.newBuilder().build())
              .build();
      ApiFuture<FetchSitemapsResponse> future =
          siteSearchEngineServiceClient.fetchSitemapsCallable().futureCall(request);
      // Do something.
      FetchSitemapsResponse response = future.get();
    }
  }
}
// [END discoveryengine_v1_generated_SiteSearchEngineService_FetchSitemaps_async]
