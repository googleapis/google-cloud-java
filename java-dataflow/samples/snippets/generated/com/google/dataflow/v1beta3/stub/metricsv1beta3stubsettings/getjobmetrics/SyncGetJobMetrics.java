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

// [START dataflow_v1beta3_generated_MetricsV1Beta3StubSettings_GetJobMetrics_sync]
import com.google.dataflow.v1beta3.stub.MetricsV1Beta3StubSettings;
import java.time.Duration;

public class SyncGetJobMetrics {

  public static void main(String[] args) throws Exception {
    syncGetJobMetrics();
  }

  public static void syncGetJobMetrics() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    MetricsV1Beta3StubSettings.Builder metricsV1Beta3SettingsBuilder =
        MetricsV1Beta3StubSettings.newBuilder();
    metricsV1Beta3SettingsBuilder
        .getJobMetricsSettings()
        .setRetrySettings(
            metricsV1Beta3SettingsBuilder
                .getJobMetricsSettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    MetricsV1Beta3StubSettings metricsV1Beta3Settings = metricsV1Beta3SettingsBuilder.build();
  }
}
// [END dataflow_v1beta3_generated_MetricsV1Beta3StubSettings_GetJobMetrics_sync]
