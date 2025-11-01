/*
 * Copyright 2025 Google LLC
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

package com.google.ads.admanager.v1.samples;

// [START admanager_v1_generated_CmsMetadataKeyService_ListCmsMetadataKeys_Paged_async]
import com.google.ads.admanager.v1.CmsMetadataKey;
import com.google.ads.admanager.v1.CmsMetadataKeyServiceClient;
import com.google.ads.admanager.v1.ListCmsMetadataKeysRequest;
import com.google.ads.admanager.v1.ListCmsMetadataKeysResponse;
import com.google.ads.admanager.v1.NetworkName;
import com.google.common.base.Strings;

public class AsyncListCmsMetadataKeysPaged {

  public static void main(String[] args) throws Exception {
    asyncListCmsMetadataKeysPaged();
  }

  public static void asyncListCmsMetadataKeysPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CmsMetadataKeyServiceClient cmsMetadataKeyServiceClient =
        CmsMetadataKeyServiceClient.create()) {
      ListCmsMetadataKeysRequest request =
          ListCmsMetadataKeysRequest.newBuilder()
              .setParent(NetworkName.of("[NETWORK_CODE]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .setSkip(3532159)
              .build();
      while (true) {
        ListCmsMetadataKeysResponse response =
            cmsMetadataKeyServiceClient.listCmsMetadataKeysCallable().call(request);
        for (CmsMetadataKey element : response.getCmsMetadataKeysList()) {
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
// [END admanager_v1_generated_CmsMetadataKeyService_ListCmsMetadataKeys_Paged_async]
