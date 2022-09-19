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

package com.google.cloud.channel.v1.samples;

// [START channel_v1_generated_cloudchannelserviceclient_listoffers_paged_async]
import com.google.cloud.channel.v1.CloudChannelServiceClient;
import com.google.cloud.channel.v1.ListOffersRequest;
import com.google.cloud.channel.v1.ListOffersResponse;
import com.google.cloud.channel.v1.Offer;
import com.google.common.base.Strings;

public class AsyncListOffersPaged {

  public static void main(String[] args) throws Exception {
    asyncListOffersPaged();
  }

  public static void asyncListOffersPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
      ListOffersRequest request =
          ListOffersRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setLanguageCode("languageCode-2092349083")
              .build();
      while (true) {
        ListOffersResponse response = cloudChannelServiceClient.listOffersCallable().call(request);
        for (Offer element : response.getOffersList()) {
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
// [END channel_v1_generated_cloudchannelserviceclient_listoffers_paged_async]
