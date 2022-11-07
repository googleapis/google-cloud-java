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

package com.google.cloud.recaptchaenterprise.v1beta1.samples;

// [START recaptchaenterprise_v1beta1_generated_RecaptchaEnterpriseServiceV1Beta1Settings_CreateAssessment_sync]
import com.google.cloud.recaptchaenterprise.v1beta1.RecaptchaEnterpriseServiceV1Beta1Settings;
import java.time.Duration;

public class SyncCreateAssessment {

  public static void main(String[] args) throws Exception {
    syncCreateAssessment();
  }

  public static void syncCreateAssessment() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    RecaptchaEnterpriseServiceV1Beta1Settings.Builder
        recaptchaEnterpriseServiceV1Beta1SettingsBuilder =
            RecaptchaEnterpriseServiceV1Beta1Settings.newBuilder();
    recaptchaEnterpriseServiceV1Beta1SettingsBuilder
        .createAssessmentSettings()
        .setRetrySettings(
            recaptchaEnterpriseServiceV1Beta1SettingsBuilder
                .createAssessmentSettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    RecaptchaEnterpriseServiceV1Beta1Settings recaptchaEnterpriseServiceV1Beta1Settings =
        recaptchaEnterpriseServiceV1Beta1SettingsBuilder.build();
  }
}
// [END recaptchaenterprise_v1beta1_generated_RecaptchaEnterpriseServiceV1Beta1Settings_CreateAssessment_sync]
