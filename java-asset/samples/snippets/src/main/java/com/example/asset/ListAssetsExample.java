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

import com.google.cloud.asset.v1.AssetServiceClient;
import com.google.cloud.asset.v1.AssetServiceClient.ListAssetsPagedResponse;
import com.google.cloud.asset.v1.ContentType;
import com.google.cloud.asset.v1.ListAssetsRequest;
import com.google.cloud.asset.v1.ProjectName;
import java.util.Arrays;

// [START asset_quickstart_list_assets]
// Imports the Google Cloud client library

public class ListAssetsExample {

  public static void listAssets() throws Exception {
    // The project id of the asset parent to list.
    String projectId = "YOUR_PROJECT_ID";
    // The asset types to list. E.g.,
    // ["storage.googleapis.com/Bucket", "bigquery.googleapis.com/Table"].
    // See full list of supported asset types at
    // https://cloud.google.com/asset-inventory/docs/supported-asset-types.
    String[] assetTypes = {"YOUR_ASSET_TYPES_TO_LIST"};
    // The asset content type to list. E.g., ContentType.CONTENT_TYPE_UNSPECIFIED.
    // See full list of content types at
    // https://cloud.google.com/asset-inventory/docs/reference/rpc/google.cloud.asset.v1#contenttype
    ContentType contentType = ContentType.CONTENT_TYPE_UNSPECIFIED;
    listAssets(projectId, assetTypes, contentType);
  }

  public static void listAssets(String projectId, String[] assetTypes, ContentType contentType)
      throws Exception {
    try (AssetServiceClient client = AssetServiceClient.create()) {
      ProjectName parent = ProjectName.of(projectId);

      // Build initial ListAssetsRequest without setting page token.
      ListAssetsRequest request =
          ListAssetsRequest.newBuilder()
              .setParent(parent.toString())
              .addAllAssetTypes(Arrays.asList(assetTypes))
              .setContentType(contentType)
              .build();

      // Repeatedly call ListAssets until page token is empty.
      ListAssetsPagedResponse response = client.listAssets(request);
      System.out.println(response);
      while (!response.getNextPageToken().isEmpty()) {
        request = request.toBuilder().setPageToken(response.getNextPageToken()).build();
        response = client.listAssets(request);
        System.out.println(response);
      }
    }
  }
}
// [END asset_quickstart_list_assets]
