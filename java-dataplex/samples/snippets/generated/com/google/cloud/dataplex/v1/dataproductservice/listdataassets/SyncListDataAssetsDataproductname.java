/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.dataplex.v1.samples;

// [START dataplex_v1_generated_DataProductService_ListDataAssets_Dataproductname_sync]
import com.google.cloud.dataplex.v1.DataAsset;
import com.google.cloud.dataplex.v1.DataProductName;
import com.google.cloud.dataplex.v1.DataProductServiceClient;

public class SyncListDataAssetsDataproductname {

  public static void main(String[] args) throws Exception {
    syncListDataAssetsDataproductname();
  }

  public static void syncListDataAssetsDataproductname() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataProductServiceClient dataProductServiceClient = DataProductServiceClient.create()) {
      DataProductName parent = DataProductName.of("[PROJECT]", "[LOCATION]", "[DATA_PRODUCT]");
      for (DataAsset element : dataProductServiceClient.listDataAssets(parent).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END dataplex_v1_generated_DataProductService_ListDataAssets_Dataproductname_sync]
