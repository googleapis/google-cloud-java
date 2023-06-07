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

package com.google.cloud.compute.v1.samples;

// [START compute_v1_generated_UrlMaps_InvalidateCache_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.compute.v1.CacheInvalidationRule;
import com.google.cloud.compute.v1.InvalidateCacheUrlMapRequest;
import com.google.cloud.compute.v1.UrlMapsClient;
import com.google.longrunning.Operation;

public class AsyncInvalidateCache {

  public static void main(String[] args) throws Exception {
    asyncInvalidateCache();
  }

  public static void asyncInvalidateCache() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (UrlMapsClient urlMapsClient = UrlMapsClient.create()) {
      InvalidateCacheUrlMapRequest request =
          InvalidateCacheUrlMapRequest.newBuilder()
              .setCacheInvalidationRuleResource(CacheInvalidationRule.newBuilder().build())
              .setProject("project-309310695")
              .setRequestId("requestId693933066")
              .setUrlMap("urlMap-836780691")
              .build();
      ApiFuture<Operation> future = urlMapsClient.invalidateCacheCallable().futureCall(request);
      // Do something.
      com.google.cloud.compute.v1.Operation response = future.get();
    }
  }
}
// [END compute_v1_generated_UrlMaps_InvalidateCache_async]
