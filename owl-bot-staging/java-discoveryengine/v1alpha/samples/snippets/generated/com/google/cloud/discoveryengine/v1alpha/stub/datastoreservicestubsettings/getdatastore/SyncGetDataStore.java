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

package com.google.cloud.discoveryengine.v1alpha.stub.samples;

// [START discoveryengine_v1alpha_generated_DataStoreServiceStubSettings_GetDataStore_sync]
import com.google.cloud.discoveryengine.v1alpha.stub.DataStoreServiceStubSettings;
import java.time.Duration;

public class SyncGetDataStore {

  public static void main(String[] args) throws Exception {
    syncGetDataStore();
  }

  public static void syncGetDataStore() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    DataStoreServiceStubSettings.Builder dataStoreServiceSettingsBuilder =
        DataStoreServiceStubSettings.newBuilder();
    dataStoreServiceSettingsBuilder
        .getDataStoreSettings()
        .setRetrySettings(
            dataStoreServiceSettingsBuilder
                .getDataStoreSettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    DataStoreServiceStubSettings dataStoreServiceSettings = dataStoreServiceSettingsBuilder.build();
  }
}
// [END discoveryengine_v1alpha_generated_DataStoreServiceStubSettings_GetDataStore_sync]
