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

package com.google.cloud.run.v2.samples;

// [START run_v2_generated_servicesclient_getiampolicy_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.run.v2.ServiceName;
import com.google.cloud.run.v2.ServicesClient;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;

public class AsyncGetIamPolicy {

  public static void main(String[] args) throws Exception {
    asyncGetIamPolicy();
  }

  public static void asyncGetIamPolicy() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ServicesClient servicesClient = ServicesClient.create()) {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      ApiFuture<Policy> future = servicesClient.getIamPolicyCallable().futureCall(request);
      // Do something.
      Policy response = future.get();
    }
  }
}
// [END run_v2_generated_servicesclient_getiampolicy_async]
