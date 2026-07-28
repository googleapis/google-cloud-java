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

package com.google.cloud.productregistry.v1.samples;

// [START cloudproductregistry_v1_generated_CloudProductRegistryReadService_GetLogicalProductVariant_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.productregistry.v1.CloudProductRegistryReadServiceClient;
import com.google.cloud.productregistry.v1.GetLogicalProductVariantRequest;
import com.google.cloud.productregistry.v1.LogicalProductVariant;
import com.google.cloud.productregistry.v1.LogicalProductVariantName;

public class AsyncGetLogicalProductVariant {

  public static void main(String[] args) throws Exception {
    asyncGetLogicalProductVariant();
  }

  public static void asyncGetLogicalProductVariant() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
        CloudProductRegistryReadServiceClient.create()) {
      GetLogicalProductVariantRequest request =
          GetLogicalProductVariantRequest.newBuilder()
              .setName(LogicalProductVariantName.of("[LOGICAL_PRODUCT]", "[VARIANT]").toString())
              .build();
      ApiFuture<LogicalProductVariant> future =
          cloudProductRegistryReadServiceClient
              .getLogicalProductVariantCallable()
              .futureCall(request);
      // Do something.
      LogicalProductVariant response = future.get();
    }
  }
}
// [END cloudproductregistry_v1_generated_CloudProductRegistryReadService_GetLogicalProductVariant_async]
