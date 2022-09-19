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

// [START channel_v1_generated_cloudchannelserviceclient_listcustomerrepricingconfigs_paged_async]
import com.google.cloud.channel.v1.CloudChannelServiceClient;
import com.google.cloud.channel.v1.CustomerName;
import com.google.cloud.channel.v1.CustomerRepricingConfig;
import com.google.cloud.channel.v1.ListCustomerRepricingConfigsRequest;
import com.google.cloud.channel.v1.ListCustomerRepricingConfigsResponse;
import com.google.common.base.Strings;

public class AsyncListCustomerRepricingConfigsPaged {

  public static void main(String[] args) throws Exception {
    asyncListCustomerRepricingConfigsPaged();
  }

  public static void asyncListCustomerRepricingConfigsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudChannelServiceClient cloudChannelServiceClient = CloudChannelServiceClient.create()) {
      ListCustomerRepricingConfigsRequest request =
          ListCustomerRepricingConfigsRequest.newBuilder()
              .setParent(CustomerName.of("[ACCOUNT]", "[CUSTOMER]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      while (true) {
        ListCustomerRepricingConfigsResponse response =
            cloudChannelServiceClient.listCustomerRepricingConfigsCallable().call(request);
        for (CustomerRepricingConfig element : response.getCustomerRepricingConfigsList()) {
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
// [END channel_v1_generated_cloudchannelserviceclient_listcustomerrepricingconfigs_paged_async]
