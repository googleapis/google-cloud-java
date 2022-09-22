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

package com.google.cloud.asset.v1.samples;

// [START asset_v1_generated_assetserviceclient_exportassets_sync]
import com.google.cloud.asset.v1.AssetServiceClient;
import com.google.cloud.asset.v1.ContentType;
import com.google.cloud.asset.v1.ExportAssetsRequest;
import com.google.cloud.asset.v1.ExportAssetsResponse;
import com.google.cloud.asset.v1.FolderName;
import com.google.cloud.asset.v1.OutputConfig;
import com.google.protobuf.Timestamp;
import java.util.ArrayList;

public class SyncExportAssets {

  public static void main(String[] args) throws Exception {
    syncExportAssets();
  }

  public static void syncExportAssets() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
      ExportAssetsRequest request =
          ExportAssetsRequest.newBuilder()
              .setParent(FolderName.of("[FOLDER]").toString())
              .setReadTime(Timestamp.newBuilder().build())
              .addAllAssetTypes(new ArrayList<String>())
              .setContentType(ContentType.forNumber(0))
              .setOutputConfig(OutputConfig.newBuilder().build())
              .addAllRelationshipTypes(new ArrayList<String>())
              .build();
      ExportAssetsResponse response = assetServiceClient.exportAssetsAsync(request).get();
    }
  }
}
// [END asset_v1_generated_assetserviceclient_exportassets_sync]
