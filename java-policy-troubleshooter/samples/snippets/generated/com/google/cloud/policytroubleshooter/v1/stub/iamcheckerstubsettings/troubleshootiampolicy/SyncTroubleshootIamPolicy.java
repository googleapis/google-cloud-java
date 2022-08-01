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

package com.google.cloud.policytroubleshooter.v1.stub.samples;

// [START policytroubleshooter_v1_generated_iamcheckerstubsettings_troubleshootiampolicy_sync]
import com.google.cloud.policytroubleshooter.v1.stub.IamCheckerStubSettings;
import java.time.Duration;

public class SyncTroubleshootIamPolicy {

  public static void main(String[] args) throws Exception {
    syncTroubleshootIamPolicy();
  }

  public static void syncTroubleshootIamPolicy() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    IamCheckerStubSettings.Builder iamCheckerSettingsBuilder = IamCheckerStubSettings.newBuilder();
    iamCheckerSettingsBuilder
        .troubleshootIamPolicySettings()
        .setRetrySettings(
            iamCheckerSettingsBuilder
                .troubleshootIamPolicySettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    IamCheckerStubSettings iamCheckerSettings = iamCheckerSettingsBuilder.build();
  }
}
// [END policytroubleshooter_v1_generated_iamcheckerstubsettings_troubleshootiampolicy_sync]
