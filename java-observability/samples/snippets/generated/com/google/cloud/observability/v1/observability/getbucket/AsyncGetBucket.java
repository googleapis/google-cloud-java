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

package com.google.cloud.observability.v1.samples;

// [START observability_v1_generated_Observability_GetBucket_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.observability.v1.Bucket;
import com.google.cloud.observability.v1.BucketName;
import com.google.cloud.observability.v1.GetBucketRequest;
import com.google.cloud.observability.v1.ObservabilityClient;

public class AsyncGetBucket {

  public static void main(String[] args) throws Exception {
    asyncGetBucket();
  }

  public static void asyncGetBucket() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ObservabilityClient observabilityClient = ObservabilityClient.create()) {
      GetBucketRequest request =
          GetBucketRequest.newBuilder()
              .setName(BucketName.of("[PROJECT]", "[LOCATION]", "[BUCKET]").toString())
              .build();
      ApiFuture<Bucket> future = observabilityClient.getBucketCallable().futureCall(request);
      // Do something.
      Bucket response = future.get();
    }
  }
}
// [END observability_v1_generated_Observability_GetBucket_async]
