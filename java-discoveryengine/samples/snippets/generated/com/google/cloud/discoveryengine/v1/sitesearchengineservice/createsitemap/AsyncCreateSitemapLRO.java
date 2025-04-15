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

// [START discoveryengine_v1_generated_SiteSearchEngineService_CreateSitemap_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.discoveryengine.v1.CreateSitemapMetadata;
import com.google.cloud.discoveryengine.v1.CreateSitemapRequest;
import com.google.cloud.discoveryengine.v1.SiteSearchEngineName;
import com.google.cloud.discoveryengine.v1.SiteSearchEngineServiceClient;
import com.google.cloud.discoveryengine.v1.Sitemap;

public class AsyncCreateSitemapLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateSitemapLRO();
  }

  public static void asyncCreateSitemapLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SiteSearchEngineServiceClient siteSearchEngineServiceClient =
        SiteSearchEngineServiceClient.create()) {
      CreateSitemapRequest request =
          CreateSitemapRequest.newBuilder()
              .setParent(
                  SiteSearchEngineName.ofProjectLocationDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                      .toString())
              .setSitemap(Sitemap.newBuilder().build())
              .build();
      OperationFuture<Sitemap, CreateSitemapMetadata> future =
          siteSearchEngineServiceClient.createSitemapOperationCallable().futureCall(request);
      // Do something.
      Sitemap response = future.get();
    }
  }
}
// [END discoveryengine_v1_generated_SiteSearchEngineService_CreateSitemap_LRO_async]
