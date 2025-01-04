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

package com.google.cloud.dialogflow.v2beta1.samples;

// [START dialogflow_v2beta1_generated_SipTrunks_ListSipTrunks_Paged_async]
import com.google.cloud.dialogflow.v2beta1.ListSipTrunksRequest;
import com.google.cloud.dialogflow.v2beta1.ListSipTrunksResponse;
import com.google.cloud.dialogflow.v2beta1.LocationName;
import com.google.cloud.dialogflow.v2beta1.SipTrunk;
import com.google.cloud.dialogflow.v2beta1.SipTrunksClient;
import com.google.common.base.Strings;

public class AsyncListSipTrunksPaged {

  public static void main(String[] args) throws Exception {
    asyncListSipTrunksPaged();
  }

  public static void asyncListSipTrunksPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
      ListSipTrunksRequest request =
          ListSipTrunksRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListSipTrunksResponse response = sipTrunksClient.listSipTrunksCallable().call(request);
        for (SipTrunk element : response.getSipTrunksList()) {
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
// [END dialogflow_v2beta1_generated_SipTrunks_ListSipTrunks_Paged_async]
