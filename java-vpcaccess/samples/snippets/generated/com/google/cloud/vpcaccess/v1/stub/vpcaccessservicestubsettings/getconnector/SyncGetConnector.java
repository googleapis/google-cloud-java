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

package com.google.cloud.vpcaccess.v1.stub.samples;

// [START vpcaccess_v1_generated_vpcaccessservicestubsettings_getconnector_sync]
import com.google.cloud.vpcaccess.v1.stub.VpcAccessServiceStubSettings;
import java.time.Duration;

public class SyncGetConnector {

  public static void main(String[] args) throws Exception {
    syncGetConnector();
  }

  public static void syncGetConnector() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    VpcAccessServiceStubSettings.Builder vpcAccessServiceSettingsBuilder =
        VpcAccessServiceStubSettings.newBuilder();
    vpcAccessServiceSettingsBuilder
        .getConnectorSettings()
        .setRetrySettings(
            vpcAccessServiceSettingsBuilder
                .getConnectorSettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    VpcAccessServiceStubSettings vpcAccessServiceSettings = vpcAccessServiceSettingsBuilder.build();
  }
}
// [END vpcaccess_v1_generated_vpcaccessservicestubsettings_getconnector_sync]
