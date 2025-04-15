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

package com.google.cloud.dataplex.v1.samples;

// [START dataplex_v1_generated_CmekService_ListEncryptionConfigs_Paged_async]
import com.google.cloud.dataplex.v1.CmekServiceClient;
import com.google.cloud.dataplex.v1.EncryptionConfig;
import com.google.cloud.dataplex.v1.ListEncryptionConfigsRequest;
import com.google.cloud.dataplex.v1.ListEncryptionConfigsResponse;
import com.google.cloud.dataplex.v1.OrganizationLocationName;
import com.google.common.base.Strings;

public class AsyncListEncryptionConfigsPaged {

  public static void main(String[] args) throws Exception {
    asyncListEncryptionConfigsPaged();
  }

  public static void asyncListEncryptionConfigsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CmekServiceClient cmekServiceClient = CmekServiceClient.create()) {
      ListEncryptionConfigsRequest request =
          ListEncryptionConfigsRequest.newBuilder()
              .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .build();
      while (true) {
        ListEncryptionConfigsResponse response =
            cmekServiceClient.listEncryptionConfigsCallable().call(request);
        for (EncryptionConfig element : response.getEncryptionConfigsList()) {
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
// [END dataplex_v1_generated_CmekService_ListEncryptionConfigs_Paged_async]
