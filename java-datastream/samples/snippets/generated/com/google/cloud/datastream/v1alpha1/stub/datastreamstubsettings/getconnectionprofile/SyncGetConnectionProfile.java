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

package com.google.cloud.datastream.v1alpha1.stub.samples;

// [START datastream_v1alpha1_generated_datastreamstubsettings_getconnectionprofile_sync]
import com.google.cloud.datastream.v1alpha1.stub.DatastreamStubSettings;
import java.time.Duration;

public class SyncGetConnectionProfile {

  public static void main(String[] args) throws Exception {
    syncGetConnectionProfile();
  }

  public static void syncGetConnectionProfile() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    DatastreamStubSettings.Builder datastreamSettingsBuilder = DatastreamStubSettings.newBuilder();
    datastreamSettingsBuilder
        .getConnectionProfileSettings()
        .setRetrySettings(
            datastreamSettingsBuilder
                .getConnectionProfileSettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    DatastreamStubSettings datastreamSettings = datastreamSettingsBuilder.build();
  }
}
// [END datastream_v1alpha1_generated_datastreamstubsettings_getconnectionprofile_sync]
