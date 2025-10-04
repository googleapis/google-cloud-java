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

package com.google.cloud.configdelivery.v1beta.samples;

// [START configdelivery_v1beta_generated_ConfigDelivery_ListVariants_Paged_async]
import com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient;
import com.google.cloud.configdelivery.v1beta.ListVariantsRequest;
import com.google.cloud.configdelivery.v1beta.ListVariantsResponse;
import com.google.cloud.configdelivery.v1beta.ReleaseName;
import com.google.cloud.configdelivery.v1beta.Variant;
import com.google.common.base.Strings;

public class AsyncListVariantsPaged {

  public static void main(String[] args) throws Exception {
    asyncListVariantsPaged();
  }

  public static void asyncListVariantsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
      ListVariantsRequest request =
          ListVariantsRequest.newBuilder()
              .setParent(
                  ReleaseName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_BUNDLE]", "[RELEASE]")
                      .toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .build();
      while (true) {
        ListVariantsResponse response = configDeliveryClient.listVariantsCallable().call(request);
        for (Variant element : response.getVariantsList()) {
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
// [END configdelivery_v1beta_generated_ConfigDelivery_ListVariants_Paged_async]
