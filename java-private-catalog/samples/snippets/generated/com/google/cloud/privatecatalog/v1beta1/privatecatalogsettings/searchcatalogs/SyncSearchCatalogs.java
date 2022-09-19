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

package com.google.cloud.privatecatalog.v1beta1.samples;

// [START privatecatalog_v1beta1_generated_privatecatalogsettings_searchcatalogs_sync]
import com.google.cloud.privatecatalog.v1beta1.PrivateCatalogSettings;
import java.time.Duration;

public class SyncSearchCatalogs {

  public static void main(String[] args) throws Exception {
    syncSearchCatalogs();
  }

  public static void syncSearchCatalogs() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    PrivateCatalogSettings.Builder privateCatalogSettingsBuilder =
        PrivateCatalogSettings.newBuilder();
    privateCatalogSettingsBuilder
        .searchCatalogsSettings()
        .setRetrySettings(
            privateCatalogSettingsBuilder.searchCatalogsSettings().getRetrySettings().toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    PrivateCatalogSettings privateCatalogSettings = privateCatalogSettingsBuilder.build();
  }
}
// [END privatecatalog_v1beta1_generated_privatecatalogsettings_searchcatalogs_sync]
