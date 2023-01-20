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

package com.google.cloud.security.privateca.v1beta1.samples;

// [START privateca_v1beta1_generated_CertificateAuthorityService_GetReusableConfig_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.security.privateca.v1beta1.CertificateAuthorityServiceClient;
import com.google.cloud.security.privateca.v1beta1.GetReusableConfigRequest;
import com.google.cloud.security.privateca.v1beta1.ReusableConfig;
import com.google.cloud.security.privateca.v1beta1.ReusableConfigName;

public class AsyncGetReusableConfig {

  public static void main(String[] args) throws Exception {
    asyncGetReusableConfig();
  }

  public static void asyncGetReusableConfig() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {
      GetReusableConfigRequest request =
          GetReusableConfigRequest.newBuilder()
              .setName(
                  ReusableConfigName.of("[PROJECT]", "[LOCATION]", "[REUSABLE_CONFIG]").toString())
              .build();
      ApiFuture<ReusableConfig> future =
          certificateAuthorityServiceClient.getReusableConfigCallable().futureCall(request);
      // Do something.
      ReusableConfig response = future.get();
    }
  }
}
// [END privateca_v1beta1_generated_CertificateAuthorityService_GetReusableConfig_async]
