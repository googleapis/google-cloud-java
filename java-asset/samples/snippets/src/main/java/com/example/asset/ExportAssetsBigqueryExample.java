/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.asset;

// [START asset_quickstart_export_assets_bigquery]
// Imports the Google Cloud client library

import com.google.cloud.ServiceOptions;
import com.google.cloud.asset.v1.AssetServiceClient;
import com.google.cloud.asset.v1.BigQueryDestination;
import com.google.cloud.asset.v1.ExportAssetsRequest;
import com.google.cloud.asset.v1.ExportAssetsResponse;
import com.google.cloud.asset.v1.OutputConfig;
import com.google.cloud.asset.v1.ProjectName;

public class ExportAssetsBigqueryExample {

  // Use the default project Id.
  private static final String projectId = ServiceOptions.getDefaultProjectId();

  // Export assets for a project.
  // @param args path where the results will be exported to.
  public static void exportBigQuery(String bigqueryDataset, String bigqueryTable) throws Exception {
    try (AssetServiceClient client = AssetServiceClient.create()) {
      ProjectName parent = ProjectName.of(projectId);
      OutputConfig outputConfig =
          OutputConfig.newBuilder()
              .setBigqueryDestination(
                  BigQueryDestination.newBuilder()
                      .setDataset(bigqueryDataset)
                      .setTable(bigqueryTable)
                      .setForce(true)
                      .build())
              .build();
      ExportAssetsRequest request =
          ExportAssetsRequest.newBuilder()
              .setParent(parent.toString())
              .setOutputConfig(outputConfig)
              .build();
      ExportAssetsResponse response = client.exportAssetsAsync(request).get();
      System.out.println(response);
    }
  }
}
// [END asset_quickstart_export_assets_bigquery]
