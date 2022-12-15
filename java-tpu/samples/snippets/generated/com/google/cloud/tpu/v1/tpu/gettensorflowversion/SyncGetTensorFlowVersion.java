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

package com.google.cloud.tpu.v1.samples;

// [START tpu_v1_generated_Tpu_GetTensorFlowVersion_sync]
import com.google.cloud.tpu.v1.GetTensorFlowVersionRequest;
import com.google.cloud.tpu.v1.TensorFlowVersion;
import com.google.cloud.tpu.v1.TensorFlowVersionName;
import com.google.cloud.tpu.v1.TpuClient;

public class SyncGetTensorFlowVersion {

  public static void main(String[] args) throws Exception {
    syncGetTensorFlowVersion();
  }

  public static void syncGetTensorFlowVersion() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TpuClient tpuClient = TpuClient.create()) {
      GetTensorFlowVersionRequest request =
          GetTensorFlowVersionRequest.newBuilder()
              .setName(
                  TensorFlowVersionName.of("[PROJECT]", "[LOCATION]", "[TENSOR_FLOW_VERSION]")
                      .toString())
              .build();
      TensorFlowVersion response = tpuClient.getTensorFlowVersion(request);
    }
  }
}
// [END tpu_v1_generated_Tpu_GetTensorFlowVersion_sync]
