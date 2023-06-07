/*
 * Copyright 2023 Google LLC
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

package com.google.dataflow.v1beta3.stub.samples;

// [START dataflow_v1beta3_generated_JobsV1Beta3StubSettings_CreateJob_sync]
import com.google.dataflow.v1beta3.stub.JobsV1Beta3StubSettings;
import java.time.Duration;

public class SyncCreateJob {

  public static void main(String[] args) throws Exception {
    syncCreateJob();
  }

  public static void syncCreateJob() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    JobsV1Beta3StubSettings.Builder jobsV1Beta3SettingsBuilder =
        JobsV1Beta3StubSettings.newBuilder();
    jobsV1Beta3SettingsBuilder
        .createJobSettings()
        .setRetrySettings(
            jobsV1Beta3SettingsBuilder
                .createJobSettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    JobsV1Beta3StubSettings jobsV1Beta3Settings = jobsV1Beta3SettingsBuilder.build();
  }
}
// [END dataflow_v1beta3_generated_JobsV1Beta3StubSettings_CreateJob_sync]
