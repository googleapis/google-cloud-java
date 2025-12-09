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

// [START admanager_v1_generated_AdReviewCenterAdService_BatchBlockAdReviewCenterAds_String_sync]
import com.google.ads.admanager.v1.AdReviewCenterAdServiceClient;
import com.google.ads.admanager.v1.BatchBlockAdReviewCenterAdsResponse;
import com.google.ads.admanager.v1.WebPropertyName;

public class SyncBatchBlockAdReviewCenterAdsString {

  public static void main(String[] args) throws Exception {
    syncBatchBlockAdReviewCenterAdsString();
  }

  public static void syncBatchBlockAdReviewCenterAdsString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AdReviewCenterAdServiceClient adReviewCenterAdServiceClient =
        AdReviewCenterAdServiceClient.create()) {
      String parent = WebPropertyName.of("[NETWORK_CODE]", "[WEB_PROPERTY]").toString();
      BatchBlockAdReviewCenterAdsResponse response =
          adReviewCenterAdServiceClient.batchBlockAdReviewCenterAdsAsync(parent).get();
    }
  }
}
// [END admanager_v1_generated_AdReviewCenterAdService_BatchBlockAdReviewCenterAds_String_sync]
