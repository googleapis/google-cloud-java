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

package com.google.cloud.run.v2.stub.samples;

// [START run_v2_generated_revisionsstubsettings_getrevision_sync]
import com.google.cloud.run.v2.stub.RevisionsStubSettings;
import java.time.Duration;

public class SyncGetRevision {

  public static void main(String[] args) throws Exception {
    syncGetRevision();
  }

  public static void syncGetRevision() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    RevisionsStubSettings.Builder revisionsSettingsBuilder = RevisionsStubSettings.newBuilder();
    revisionsSettingsBuilder
        .getRevisionSettings()
        .setRetrySettings(
            revisionsSettingsBuilder
                .getRevisionSettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    RevisionsStubSettings revisionsSettings = revisionsSettingsBuilder.build();
  }
}
// [END run_v2_generated_revisionsstubsettings_getrevision_sync]
