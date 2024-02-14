/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.aiplatform.v1beta1.samples;

// [START aiplatform_v1beta1_generated_FeatureOnlineStoreAdminService_ListFeatureOnlineStores_Paged_async]
import com.google.cloud.aiplatform.v1beta1.FeatureOnlineStore;
import com.google.cloud.aiplatform.v1beta1.FeatureOnlineStoreAdminServiceClient;
import com.google.cloud.aiplatform.v1beta1.ListFeatureOnlineStoresRequest;
import com.google.cloud.aiplatform.v1beta1.ListFeatureOnlineStoresResponse;
import com.google.cloud.aiplatform.v1beta1.LocationName;
import com.google.common.base.Strings;

public class AsyncListFeatureOnlineStoresPaged {

  public static void main(String[] args) throws Exception {
    asyncListFeatureOnlineStoresPaged();
  }

  public static void asyncListFeatureOnlineStoresPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (FeatureOnlineStoreAdminServiceClient featureOnlineStoreAdminServiceClient =
        FeatureOnlineStoreAdminServiceClient.create()) {
      ListFeatureOnlineStoresRequest request =
          ListFeatureOnlineStoresRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setOrderBy("orderBy-1207110587")
              .build();
      while (true) {
        ListFeatureOnlineStoresResponse response =
            featureOnlineStoreAdminServiceClient.listFeatureOnlineStoresCallable().call(request);
        for (FeatureOnlineStore element : response.getFeatureOnlineStoresList()) {
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
// [END aiplatform_v1beta1_generated_FeatureOnlineStoreAdminService_ListFeatureOnlineStores_Paged_async]
