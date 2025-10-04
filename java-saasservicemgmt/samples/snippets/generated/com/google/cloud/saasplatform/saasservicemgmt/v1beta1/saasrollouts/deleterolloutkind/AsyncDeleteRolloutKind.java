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

package com.google.cloud.saasplatform.saasservicemgmt.v1beta1.samples;

// [START saasservicemgmt_v1beta1_generated_SaasRollouts_DeleteRolloutKind_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKindName;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRolloutsClient;
import com.google.protobuf.Empty;

public class AsyncDeleteRolloutKind {

  public static void main(String[] args) throws Exception {
    asyncDeleteRolloutKind();
  }

  public static void asyncDeleteRolloutKind() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
      DeleteRolloutKindRequest request =
          DeleteRolloutKindRequest.newBuilder()
              .setName(
                  RolloutKindName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_KIND_ID]").toString())
              .setEtag("etag3123477")
              .setValidateOnly(true)
              .setRequestId("requestId693933066")
              .build();
      ApiFuture<Empty> future = saasRolloutsClient.deleteRolloutKindCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END saasservicemgmt_v1beta1_generated_SaasRollouts_DeleteRolloutKind_async]
