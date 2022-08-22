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

package com.google.cloud.policytroubleshooter.v1.samples;

// [START policytroubleshooter_v1_generated_iamcheckerclient_troubleshootiampolicy_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.policytroubleshooter.v1.IamCheckerClient;
import com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyRequest;
import com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyResponse;
import google.cloud.policytroubleshooter.v1.Explanations;

public class AsyncTroubleshootIamPolicy {

  public static void main(String[] args) throws Exception {
    asyncTroubleshootIamPolicy();
  }

  public static void asyncTroubleshootIamPolicy() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (IamCheckerClient iamCheckerClient = IamCheckerClient.create()) {
      TroubleshootIamPolicyRequest request =
          TroubleshootIamPolicyRequest.newBuilder()
              .setAccessTuple(Explanations.AccessTuple.newBuilder().build())
              .build();
      ApiFuture<TroubleshootIamPolicyResponse> future =
          iamCheckerClient.troubleshootIamPolicyCallable().futureCall(request);
      // Do something.
      TroubleshootIamPolicyResponse response = future.get();
    }
  }
}
// [END policytroubleshooter_v1_generated_iamcheckerclient_troubleshootiampolicy_async]
