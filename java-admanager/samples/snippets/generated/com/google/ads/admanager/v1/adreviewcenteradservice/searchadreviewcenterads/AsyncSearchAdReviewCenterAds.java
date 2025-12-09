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

// [START admanager_v1_generated_AdReviewCenterAdService_SearchAdReviewCenterAds_async]
import com.google.ads.admanager.v1.AdReviewCenterAd;
import com.google.ads.admanager.v1.AdReviewCenterAdServiceClient;
import com.google.ads.admanager.v1.SearchAdReviewCenterAdsRequest;
import com.google.ads.admanager.v1.WebPropertyName;
import com.google.api.core.ApiFuture;
import com.google.type.Interval;
import java.util.ArrayList;

public class AsyncSearchAdReviewCenterAds {

  public static void main(String[] args) throws Exception {
    asyncSearchAdReviewCenterAds();
  }

  public static void asyncSearchAdReviewCenterAds() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AdReviewCenterAdServiceClient adReviewCenterAdServiceClient =
        AdReviewCenterAdServiceClient.create()) {
      SearchAdReviewCenterAdsRequest request =
          SearchAdReviewCenterAdsRequest.newBuilder()
              .setParent(WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .addAllAdReviewCenterAdId(new ArrayList<String>())
              .setDateTimeRange(Interval.newBuilder().build())
              .addAllSearchText(new ArrayList<String>())
              .addAllBuyerAccountId(new ArrayList<Long>())
              .build();
      ApiFuture<AdReviewCenterAd> future =
          adReviewCenterAdServiceClient.searchAdReviewCenterAdsPagedCallable().futureCall(request);
      // Do something.
      for (AdReviewCenterAd element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END admanager_v1_generated_AdReviewCenterAdService_SearchAdReviewCenterAds_async]
