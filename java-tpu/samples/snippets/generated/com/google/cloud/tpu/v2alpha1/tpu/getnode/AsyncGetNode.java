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

package com.google.cloud.tpu.v2alpha1.samples;

// [START tpu_v2alpha1_generated_Tpu_GetNode_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.tpu.v2alpha1.GetNodeRequest;
import com.google.cloud.tpu.v2alpha1.Node;
import com.google.cloud.tpu.v2alpha1.NodeName;
import com.google.cloud.tpu.v2alpha1.TpuClient;

public class AsyncGetNode {

  public static void main(String[] args) throws Exception {
    asyncGetNode();
  }

  public static void asyncGetNode() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TpuClient tpuClient = TpuClient.create()) {
      GetNodeRequest request =
          GetNodeRequest.newBuilder()
              .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
              .build();
      ApiFuture<Node> future = tpuClient.getNodeCallable().futureCall(request);
      // Do something.
      Node response = future.get();
    }
  }
}
// [END tpu_v2alpha1_generated_Tpu_GetNode_async]
