/*
 * Copyright 2018 Google LLC
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

import com.google.cloud.ServiceOptions;
import com.google.cloud.asset.v1beta1.AssetServiceClient;
import com.google.cloud.asset.v1beta1.ExportAssetsRequest;
import com.google.cloud.asset.v1beta1.ExportAssetsResponse;
import com.google.cloud.asset.v1beta1.GcsDestination;
import com.google.cloud.asset.v1beta1.OutputConfig;
import com.google.cloud.asset.v1beta1.ProjectName;

// [START asset_quickstart_export_assets]
// Imports the Google Cloud client library

public class ExportAssetsExample {

  // Use the default project Id.
  private static final String projectId = ServiceOptions.getDefaultProjectId();

  // Export assets for a project.
  // @param args path where the results will be exported to.
  public static void main(String... args) throws Exception {
    // Gcs path, e.g.: "gs://<my_asset_bucket>/<my_asset_dump_file>"
    String exportPath = args[0];
    try (AssetServiceClient client = AssetServiceClient.create()) {
      ProjectName parent = ProjectName.of(projectId);
      OutputConfig outputConfig =
          OutputConfig.newBuilder()
              .setGcsDestination(GcsDestination.newBuilder().setUri(exportPath).build())
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
// [END asset_quickstart]
