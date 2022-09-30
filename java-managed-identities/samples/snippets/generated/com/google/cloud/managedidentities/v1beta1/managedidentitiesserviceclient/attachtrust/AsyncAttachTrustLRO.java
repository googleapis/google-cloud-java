/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.managedidentities.v1beta1.samples;

// [START managedidentities_v1beta1_generated_managedidentitiesserviceclient_attachtrust_lro_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.managedidentities.v1beta1.AttachTrustRequest;
import com.google.cloud.managedidentities.v1beta1.Domain;
import com.google.cloud.managedidentities.v1beta1.DomainName;
import com.google.cloud.managedidentities.v1beta1.ManagedIdentitiesServiceClient;
import com.google.cloud.managedidentities.v1beta1.OpMetadata;
import com.google.cloud.managedidentities.v1beta1.Trust;

public class AsyncAttachTrustLRO {

  public static void main(String[] args) throws Exception {
    asyncAttachTrustLRO();
  }

  public static void asyncAttachTrustLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
        ManagedIdentitiesServiceClient.create()) {
      AttachTrustRequest request =
          AttachTrustRequest.newBuilder()
              .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
              .setTrust(Trust.newBuilder().build())
              .build();
      OperationFuture<Domain, OpMetadata> future =
          managedIdentitiesServiceClient.attachTrustOperationCallable().futureCall(request);
      // Do something.
      Domain response = future.get();
    }
  }
}
// [END managedidentities_v1beta1_generated_managedidentitiesserviceclient_attachtrust_lro_async]
