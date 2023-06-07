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

package com.google.cloud.metastore.v1alpha.samples;

// [START metastore_v1alpha_generated_DataprocMetastoreFederation_CreateFederation_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.metastore.v1alpha.CreateFederationRequest;
import com.google.cloud.metastore.v1alpha.DataprocMetastoreFederationClient;
import com.google.cloud.metastore.v1alpha.Federation;
import com.google.cloud.metastore.v1alpha.LocationName;
import com.google.cloud.metastore.v1alpha.OperationMetadata;

public class AsyncCreateFederationLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateFederationLRO();
  }

  public static void asyncCreateFederationLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataprocMetastoreFederationClient dataprocMetastoreFederationClient =
        DataprocMetastoreFederationClient.create()) {
      CreateFederationRequest request =
          CreateFederationRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setFederationId("federationId-735921218")
              .setFederation(Federation.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      OperationFuture<Federation, OperationMetadata> future =
          dataprocMetastoreFederationClient.createFederationOperationCallable().futureCall(request);
      // Do something.
      Federation response = future.get();
    }
  }
}
// [END metastore_v1alpha_generated_DataprocMetastoreFederation_CreateFederation_LRO_async]
