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

package com.google.cloud.recommendationengine.v1beta1.samples;

// [START recommendationengine_v1beta1_generated_catalogserviceclient_importcatalogitems_catalognamestringinputconfigimporterrorsconfig_sync]
import com.google.cloud.recommendationengine.v1beta1.CatalogName;
import com.google.cloud.recommendationengine.v1beta1.CatalogServiceClient;
import com.google.cloud.recommendationengine.v1beta1.ImportCatalogItemsResponse;
import com.google.cloud.recommendationengine.v1beta1.ImportErrorsConfig;
import com.google.cloud.recommendationengine.v1beta1.InputConfig;

public class SyncImportCatalogItemsCatalognameStringInputconfigImporterrorsconfig {

  public static void main(String[] args) throws Exception {
    syncImportCatalogItemsCatalognameStringInputconfigImporterrorsconfig();
  }

  public static void syncImportCatalogItemsCatalognameStringInputconfigImporterrorsconfig()
      throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
      CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
      String requestId = "requestId693933066";
      InputConfig inputConfig = InputConfig.newBuilder().build();
      ImportErrorsConfig errorsConfig = ImportErrorsConfig.newBuilder().build();
      ImportCatalogItemsResponse response =
          catalogServiceClient
              .importCatalogItemsAsync(parent, requestId, inputConfig, errorsConfig)
              .get();
    }
  }
}
// [END recommendationengine_v1beta1_generated_catalogserviceclient_importcatalogitems_catalognamestringinputconfigimporterrorsconfig_sync]
