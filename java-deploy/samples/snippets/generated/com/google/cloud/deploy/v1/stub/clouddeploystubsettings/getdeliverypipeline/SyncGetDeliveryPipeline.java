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

package com.google.cloud.deploy.v1.stub.samples;

// [START deploy_v1_generated_clouddeploystubsettings_getdeliverypipeline_sync]
import com.google.cloud.deploy.v1.stub.CloudDeployStubSettings;
import java.time.Duration;

public class SyncGetDeliveryPipeline {

  public static void main(String[] args) throws Exception {
    syncGetDeliveryPipeline();
  }

  public static void syncGetDeliveryPipeline() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    CloudDeployStubSettings.Builder cloudDeploySettingsBuilder =
        CloudDeployStubSettings.newBuilder();
    cloudDeploySettingsBuilder
        .getDeliveryPipelineSettings()
        .setRetrySettings(
            cloudDeploySettingsBuilder
                .getDeliveryPipelineSettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    CloudDeployStubSettings cloudDeploySettings = cloudDeploySettingsBuilder.build();
  }
}
// [END deploy_v1_generated_clouddeploystubsettings_getdeliverypipeline_sync]
