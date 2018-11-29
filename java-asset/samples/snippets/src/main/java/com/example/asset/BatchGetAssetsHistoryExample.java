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

// [START asset_quickstart_batch_get_assets_history]
// Imports the Google Cloud client library

import com.google.cloud.ServiceOptions;
import com.google.cloud.asset.v1beta1.AssetServiceClient;
import com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryRequest;
import com.google.cloud.asset.v1beta1.BatchGetAssetsHistoryResponse;
import com.google.cloud.asset.v1beta1.ContentType;
import com.google.cloud.asset.v1beta1.ProjectName;
import com.google.cloud.asset.v1beta1.TimeWindow;
import java.util.Arrays;

public class BatchGetAssetsHistoryExample {

  // Use the default project Id.
  private static final String projectId = ServiceOptions.getDefaultProjectId();

  // Export assets for a project.
  // @param args path where the results will be exported to.
  public static void main(String... args) throws Exception {
    // Asset names, e.g.: "//storage.googleapis.com/[BUCKET_NAME]"
    String[] assetNames = args[0].split(",");
    try (AssetServiceClient client = AssetServiceClient.create()) {
      ProjectName parent = ProjectName.of(projectId);
      ContentType contentType = ContentType.CONTENT_TYPE_UNSPECIFIED;
      TimeWindow readTimeWindow = TimeWindow.newBuilder().build();
      BatchGetAssetsHistoryRequest request = BatchGetAssetsHistoryRequest.newBuilder()
          .setParent(parent.toString())
          .addAllAssetNames(Arrays.asList(assetNames))
          .setContentType(contentType)
          .setReadTimeWindow(readTimeWindow)
          .build();
      BatchGetAssetsHistoryResponse response = client.batchGetAssetsHistory(request);
      System.out.println(response);
    }
  }
}
// [END asset_quickstart_batch_get_assets_history]
