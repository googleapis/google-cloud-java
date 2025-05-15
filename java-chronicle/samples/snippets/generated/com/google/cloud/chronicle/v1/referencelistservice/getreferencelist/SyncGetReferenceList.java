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

package com.google.cloud.chronicle.v1.samples;

// [START chronicle_v1_generated_ReferenceListService_GetReferenceList_sync]
import com.google.cloud.chronicle.v1.GetReferenceListRequest;
import com.google.cloud.chronicle.v1.ReferenceList;
import com.google.cloud.chronicle.v1.ReferenceListName;
import com.google.cloud.chronicle.v1.ReferenceListServiceClient;
import com.google.cloud.chronicle.v1.ReferenceListView;

public class SyncGetReferenceList {

  public static void main(String[] args) throws Exception {
    syncGetReferenceList();
  }

  public static void syncGetReferenceList() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ReferenceListServiceClient referenceListServiceClient =
        ReferenceListServiceClient.create()) {
      GetReferenceListRequest request =
          GetReferenceListRequest.newBuilder()
              .setName(
                  ReferenceListName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[REFERENCE_LIST]")
                      .toString())
              .setView(ReferenceListView.forNumber(0))
              .build();
      ReferenceList response = referenceListServiceClient.getReferenceList(request);
    }
  }
}
// [END chronicle_v1_generated_ReferenceListService_GetReferenceList_sync]
