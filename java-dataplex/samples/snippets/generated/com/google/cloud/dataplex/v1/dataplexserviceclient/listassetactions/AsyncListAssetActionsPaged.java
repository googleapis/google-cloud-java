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

package com.google.cloud.dataplex.v1.samples;

// [START dataplex_v1_generated_dataplexserviceclient_listassetactions_paged_async]
import com.google.cloud.dataplex.v1.Action;
import com.google.cloud.dataplex.v1.AssetName;
import com.google.cloud.dataplex.v1.DataplexServiceClient;
import com.google.cloud.dataplex.v1.ListActionsResponse;
import com.google.cloud.dataplex.v1.ListAssetActionsRequest;
import com.google.common.base.Strings;

public class AsyncListAssetActionsPaged {

  public static void main(String[] args) throws Exception {
    asyncListAssetActionsPaged();
  }

  public static void asyncListAssetActionsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataplexServiceClient dataplexServiceClient = DataplexServiceClient.create()) {
      ListAssetActionsRequest request =
          ListAssetActionsRequest.newBuilder()
              .setParent(
                  AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListActionsResponse response =
            dataplexServiceClient.listAssetActionsCallable().call(request);
        for (Action element : response.getActionsList()) {
          // doThingsWith(element);
        }
        String nextPageToken = response.getNextPageToken();
        if (!Strings.isNullOrEmpty(nextPageToken)) {
          request = request.toBuilder().setPageToken(nextPageToken).build();
        } else {
          break;
        }
      }
    }
  }
}
// [END dataplex_v1_generated_dataplexserviceclient_listassetactions_paged_async]
