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

package com.google.shopping.merchant.promotions.v1beta.samples;

// [START merchantapi_v1beta_generated_PromotionsService_ListPromotions_Paged_async]
import com.google.common.base.Strings;
import com.google.shopping.merchant.promotions.v1beta.ListPromotionsRequest;
import com.google.shopping.merchant.promotions.v1beta.ListPromotionsResponse;
import com.google.shopping.merchant.promotions.v1beta.Promotion;
import com.google.shopping.merchant.promotions.v1beta.PromotionsServiceClient;

public class AsyncListPromotionsPaged {

  public static void main(String[] args) throws Exception {
    asyncListPromotionsPaged();
  }

  public static void asyncListPromotionsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (PromotionsServiceClient promotionsServiceClient = PromotionsServiceClient.create()) {
      ListPromotionsRequest request =
          ListPromotionsRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListPromotionsResponse response =
            promotionsServiceClient.listPromotionsCallable().call(request);
        for (Promotion element : response.getPromotionsList()) {
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
// [END merchantapi_v1beta_generated_PromotionsService_ListPromotions_Paged_async]
