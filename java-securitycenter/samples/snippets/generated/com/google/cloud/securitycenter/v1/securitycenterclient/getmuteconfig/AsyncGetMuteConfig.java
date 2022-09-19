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

package com.google.cloud.securitycenter.v1.samples;

// [START securitycenter_v1_generated_securitycenterclient_getmuteconfig_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.securitycenter.v1.GetMuteConfigRequest;
import com.google.cloud.securitycenter.v1.MuteConfig;
import com.google.cloud.securitycenter.v1.MuteConfigName;
import com.google.cloud.securitycenter.v1.SecurityCenterClient;

public class AsyncGetMuteConfig {

  public static void main(String[] args) throws Exception {
    asyncGetMuteConfig();
  }

  public static void asyncGetMuteConfig() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SecurityCenterClient securityCenterClient = SecurityCenterClient.create()) {
      GetMuteConfigRequest request =
          GetMuteConfigRequest.newBuilder()
              .setName(
                  MuteConfigName.ofOrganizationMuteConfigName("[ORGANIZATION]", "[MUTE_CONFIG]")
                      .toString())
              .build();
      ApiFuture<MuteConfig> future =
          securityCenterClient.getMuteConfigCallable().futureCall(request);
      // Do something.
      MuteConfig response = future.get();
    }
  }
}
// [END securitycenter_v1_generated_securitycenterclient_getmuteconfig_async]
