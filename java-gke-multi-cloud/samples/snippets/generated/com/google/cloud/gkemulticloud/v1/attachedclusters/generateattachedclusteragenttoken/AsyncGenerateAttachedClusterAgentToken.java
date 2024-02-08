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

package com.google.cloud.gkemulticloud.v1.samples;

// [START gkemulticloud_v1_generated_AttachedClusters_GenerateAttachedClusterAgentToken_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.gkemulticloud.v1.AttachedClusterName;
import com.google.cloud.gkemulticloud.v1.AttachedClustersClient;
import com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterAgentTokenRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterAgentTokenResponse;

public class AsyncGenerateAttachedClusterAgentToken {

  public static void main(String[] args) throws Exception {
    asyncGenerateAttachedClusterAgentToken();
  }

  public static void asyncGenerateAttachedClusterAgentToken() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
      GenerateAttachedClusterAgentTokenRequest request =
          GenerateAttachedClusterAgentTokenRequest.newBuilder()
              .setAttachedCluster(
                  AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]")
                      .toString())
              .setSubjectToken("subjectToken-1519661011")
              .setSubjectTokenType("subjectTokenType1839592711")
              .setVersion("version351608024")
              .setGrantType("grantType-1219832202")
              .setAudience("audience975628804")
              .setScope("scope109264468")
              .setRequestedTokenType("requestedTokenType1733106949")
              .setOptions("options-1249474914")
              .build();
      ApiFuture<GenerateAttachedClusterAgentTokenResponse> future =
          attachedClustersClient.generateAttachedClusterAgentTokenCallable().futureCall(request);
      // Do something.
      GenerateAttachedClusterAgentTokenResponse response = future.get();
    }
  }
}
// [END gkemulticloud_v1_generated_AttachedClusters_GenerateAttachedClusterAgentToken_async]
