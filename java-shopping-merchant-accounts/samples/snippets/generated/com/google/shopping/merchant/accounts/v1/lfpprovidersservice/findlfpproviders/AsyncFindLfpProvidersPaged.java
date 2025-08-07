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

package com.google.shopping.merchant.accounts.v1.samples;

// [START merchantapi_v1_generated_LfpProvidersService_FindLfpProviders_Paged_async]
import com.google.common.base.Strings;
import com.google.shopping.merchant.accounts.v1.FindLfpProvidersRequest;
import com.google.shopping.merchant.accounts.v1.FindLfpProvidersResponse;
import com.google.shopping.merchant.accounts.v1.LfpProvider;
import com.google.shopping.merchant.accounts.v1.LfpProvidersServiceClient;
import com.google.shopping.merchant.accounts.v1.OmnichannelSettingName;

public class AsyncFindLfpProvidersPaged {

  public static void main(String[] args) throws Exception {
    asyncFindLfpProvidersPaged();
  }

  public static void asyncFindLfpProvidersPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (LfpProvidersServiceClient lfpProvidersServiceClient = LfpProvidersServiceClient.create()) {
      FindLfpProvidersRequest request =
          FindLfpProvidersRequest.newBuilder()
              .setParent(OmnichannelSettingName.of("[ACCOUNT]", "[OMNICHANNEL_SETTING]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        FindLfpProvidersResponse response =
            lfpProvidersServiceClient.findLfpProvidersCallable().call(request);
        for (LfpProvider element : response.getLfpProvidersList()) {
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
// [END merchantapi_v1_generated_LfpProvidersService_FindLfpProviders_Paged_async]
