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

package com.google.cloud.networksecurity.v1beta1.samples;

// [START networksecurity_v1beta1_generated_networksecurityclient_getservertlspolicy_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.networksecurity.v1beta1.GetServerTlsPolicyRequest;
import com.google.cloud.networksecurity.v1beta1.NetworkSecurityClient;
import com.google.cloud.networksecurity.v1beta1.ServerTlsPolicy;
import com.google.cloud.networksecurity.v1beta1.ServerTlsPolicyName;

public class AsyncGetServerTlsPolicy {

  public static void main(String[] args) throws Exception {
    asyncGetServerTlsPolicy();
  }

  public static void asyncGetServerTlsPolicy() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
      GetServerTlsPolicyRequest request =
          GetServerTlsPolicyRequest.newBuilder()
              .setName(
                  ServerTlsPolicyName.of("[PROJECT]", "[LOCATION]", "[SERVER_TLS_POLICY]")
                      .toString())
              .build();
      ApiFuture<ServerTlsPolicy> future =
          networkSecurityClient.getServerTlsPolicyCallable().futureCall(request);
      // Do something.
      ServerTlsPolicy response = future.get();
    }
  }
}
// [END networksecurity_v1beta1_generated_networksecurityclient_getservertlspolicy_async]
