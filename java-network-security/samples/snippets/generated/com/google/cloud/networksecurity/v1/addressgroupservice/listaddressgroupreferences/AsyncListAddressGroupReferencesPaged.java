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

package com.google.cloud.networksecurity.v1.samples;

// [START networksecurity_v1_generated_AddressGroupService_ListAddressGroupReferences_Paged_async]
import com.google.cloud.networksecurity.v1.AddressGroupName;
import com.google.cloud.networksecurity.v1.AddressGroupServiceClient;
import com.google.cloud.networksecurity.v1.ListAddressGroupReferencesRequest;
import com.google.cloud.networksecurity.v1.ListAddressGroupReferencesResponse;
import com.google.common.base.Strings;

public class AsyncListAddressGroupReferencesPaged {

  public static void main(String[] args) throws Exception {
    asyncListAddressGroupReferencesPaged();
  }

  public static void asyncListAddressGroupReferencesPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
      ListAddressGroupReferencesRequest request =
          ListAddressGroupReferencesRequest.newBuilder()
              .setAddressGroup(
                  AddressGroupName.ofProjectLocationAddressGroupName(
                          "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]")
                      .toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListAddressGroupReferencesResponse response =
            addressGroupServiceClient.listAddressGroupReferencesCallable().call(request);
        for (ListAddressGroupReferencesResponse.AddressGroupReference element :
            response.getAddressGroupReferencesList()) {
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
// [END networksecurity_v1_generated_AddressGroupService_ListAddressGroupReferences_Paged_async]
