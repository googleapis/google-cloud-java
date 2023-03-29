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

package com.google.cloud.gkemulticloud.v1.samples;

// [START gkemulticloud_v1_generated_AzureClusters_DeleteAzureNodePool_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.gkemulticloud.v1.AzureClustersClient;
import com.google.cloud.gkemulticloud.v1.AzureNodePoolName;
import com.google.cloud.gkemulticloud.v1.DeleteAzureNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.OperationMetadata;
import com.google.protobuf.Empty;

public class AsyncDeleteAzureNodePoolLRO {

  public static void main(String[] args) throws Exception {
    asyncDeleteAzureNodePoolLRO();
  }

  public static void asyncDeleteAzureNodePoolLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
      DeleteAzureNodePoolRequest request =
          DeleteAzureNodePoolRequest.newBuilder()
              .setName(
                  AzureNodePoolName.of(
                          "[PROJECT]", "[LOCATION]", "[AZURE_CLUSTER]", "[AZURE_NODE_POOL]")
                      .toString())
              .setValidateOnly(true)
              .setAllowMissing(true)
              .setEtag("etag3123477")
              .build();
      OperationFuture<Empty, OperationMetadata> future =
          azureClustersClient.deleteAzureNodePoolOperationCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END gkemulticloud_v1_generated_AzureClusters_DeleteAzureNodePool_LRO_async]
