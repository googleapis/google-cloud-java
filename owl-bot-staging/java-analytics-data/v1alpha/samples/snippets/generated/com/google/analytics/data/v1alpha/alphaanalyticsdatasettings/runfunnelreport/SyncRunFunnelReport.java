/*
 * Copyright 2024 Google LLC
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

package com.google.analytics.data.v1alpha.samples;

// [START analyticsdata_v1alpha_generated_AlphaAnalyticsDataSettings_RunFunnelReport_sync]
import com.google.analytics.data.v1alpha.AlphaAnalyticsDataSettings;
import java.time.Duration;

public class SyncRunFunnelReport {

  public static void main(String[] args) throws Exception {
    syncRunFunnelReport();
  }

  public static void syncRunFunnelReport() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    AlphaAnalyticsDataSettings.Builder alphaAnalyticsDataSettingsBuilder =
        AlphaAnalyticsDataSettings.newBuilder();
    alphaAnalyticsDataSettingsBuilder
        .runFunnelReportSettings()
        .setRetrySettings(
            alphaAnalyticsDataSettingsBuilder
                .runFunnelReportSettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    AlphaAnalyticsDataSettings alphaAnalyticsDataSettings =
        alphaAnalyticsDataSettingsBuilder.build();
  }
}
// [END analyticsdata_v1alpha_generated_AlphaAnalyticsDataSettings_RunFunnelReport_sync]
