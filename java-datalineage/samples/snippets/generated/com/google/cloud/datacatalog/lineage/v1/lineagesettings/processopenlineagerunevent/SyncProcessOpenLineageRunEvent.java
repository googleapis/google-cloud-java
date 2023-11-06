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

package com.google.cloud.datacatalog.lineage.v1.samples;

// [START datalineage_v1_generated_LineageSettings_ProcessOpenLineageRunEvent_sync]
import com.google.cloud.datacatalog.lineage.v1.LineageSettings;
import java.time.Duration;

public class SyncProcessOpenLineageRunEvent {

  public static void main(String[] args) throws Exception {
    syncProcessOpenLineageRunEvent();
  }

  public static void syncProcessOpenLineageRunEvent() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    LineageSettings.Builder lineageSettingsBuilder = LineageSettings.newBuilder();
    lineageSettingsBuilder
        .processOpenLineageRunEventSettings()
        .setRetrySettings(
            lineageSettingsBuilder
                .processOpenLineageRunEventSettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    LineageSettings lineageSettings = lineageSettingsBuilder.build();
  }
}
// [END datalineage_v1_generated_LineageSettings_ProcessOpenLineageRunEvent_sync]
