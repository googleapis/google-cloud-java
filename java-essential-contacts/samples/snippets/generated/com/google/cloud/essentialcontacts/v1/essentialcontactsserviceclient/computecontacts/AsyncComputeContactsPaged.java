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

package com.google.cloud.essentialcontacts.v1.samples;

// [START essentialcontacts_v1_generated_essentialcontactsserviceclient_computecontacts_paged_async]
import com.google.cloud.essentialcontacts.v1.ComputeContactsRequest;
import com.google.cloud.essentialcontacts.v1.ComputeContactsResponse;
import com.google.cloud.essentialcontacts.v1.Contact;
import com.google.cloud.essentialcontacts.v1.EssentialContactsServiceClient;
import com.google.cloud.essentialcontacts.v1.NotificationCategory;
import com.google.cloud.essentialcontacts.v1.ProjectName;
import com.google.common.base.Strings;
import java.util.ArrayList;

public class AsyncComputeContactsPaged {

  public static void main(String[] args) throws Exception {
    asyncComputeContactsPaged();
  }

  public static void asyncComputeContactsPaged() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (EssentialContactsServiceClient essentialContactsServiceClient =
        EssentialContactsServiceClient.create()) {
      ComputeContactsRequest request =
          ComputeContactsRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .addAllNotificationCategories(new ArrayList<NotificationCategory>())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ComputeContactsResponse response =
            essentialContactsServiceClient.computeContactsCallable().call(request);
        for (Contact element : response.getContactsList()) {
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
// [END essentialcontacts_v1_generated_essentialcontactsserviceclient_computecontacts_paged_async]
