/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.licensemanager.v1.stub.samples;

// [START licensemanager_v1_generated_LicenseManagerStubSettings_CreateConfiguration_sync]
import com.google.api.gax.longrunning.OperationalTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.TimedRetryAlgorithm;
import com.google.cloud.licensemanager.v1.stub.LicenseManagerStubSettings;
import java.time.Duration;

public class SyncCreateConfiguration {

  public static void main(String[] args) throws Exception {
    syncCreateConfiguration();
  }

  public static void syncCreateConfiguration() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    LicenseManagerStubSettings.Builder licenseManagerSettingsBuilder =
        LicenseManagerStubSettings.newBuilder();
    TimedRetryAlgorithm timedRetryAlgorithm =
        OperationalTimedPollAlgorithm.create(
            RetrySettings.newBuilder()
                .setInitialRetryDelayDuration(Duration.ofMillis(500))
                .setRetryDelayMultiplier(1.5)
                .setMaxRetryDelayDuration(Duration.ofMillis(5000))
                .setTotalTimeoutDuration(Duration.ofHours(24))
                .build());
    licenseManagerSettingsBuilder
        .createClusterOperationSettings()
        .setPollingAlgorithm(timedRetryAlgorithm)
        .build();
  }
}
// [END licensemanager_v1_generated_LicenseManagerStubSettings_CreateConfiguration_sync]
