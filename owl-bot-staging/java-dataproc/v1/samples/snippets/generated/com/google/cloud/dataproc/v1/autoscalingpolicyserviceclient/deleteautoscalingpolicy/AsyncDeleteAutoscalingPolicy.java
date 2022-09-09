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

package com.google.cloud.dataproc.v1.samples;

// [START dataproc_v1_generated_autoscalingpolicyserviceclient_deleteautoscalingpolicy_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.dataproc.v1.AutoscalingPolicyName;
import com.google.cloud.dataproc.v1.AutoscalingPolicyServiceClient;
import com.google.cloud.dataproc.v1.DeleteAutoscalingPolicyRequest;
import com.google.protobuf.Empty;

public class AsyncDeleteAutoscalingPolicy {

  public static void main(String[] args) throws Exception {
    asyncDeleteAutoscalingPolicy();
  }

  public static void asyncDeleteAutoscalingPolicy() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
        AutoscalingPolicyServiceClient.create()) {
      DeleteAutoscalingPolicyRequest request =
          DeleteAutoscalingPolicyRequest.newBuilder()
              .setName(
                  AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
                          "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]")
                      .toString())
              .build();
      ApiFuture<Empty> future =
          autoscalingPolicyServiceClient.deleteAutoscalingPolicyCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END dataproc_v1_generated_autoscalingpolicyserviceclient_deleteautoscalingpolicy_async]
