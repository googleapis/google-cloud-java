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

package com.google.cloud.modelarmor.v1beta.samples;

// [START modelarmor_v1beta_generated_ModelArmor_ListTemplates_Paged_async]
import com.google.cloud.modelarmor.v1beta.ListTemplatesRequest;
import com.google.cloud.modelarmor.v1beta.ListTemplatesResponse;
import com.google.cloud.modelarmor.v1beta.LocationName;
import com.google.cloud.modelarmor.v1beta.ModelArmorClient;
import com.google.cloud.modelarmor.v1beta.Template;
import com.google.common.base.Strings;

public class AsyncListTemplatesPaged {

  public static void main(String[] args) throws Exception {
    asyncListTemplatesPaged();
  }

  public static void asyncListTemplatesPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ModelArmorClient modelArmorClient = ModelArmorClient.create()) {
      ListTemplatesRequest request =
          ListTemplatesRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .build();
      while (true) {
        ListTemplatesResponse response = modelArmorClient.listTemplatesCallable().call(request);
        for (Template element : response.getTemplatesList()) {
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
// [END modelarmor_v1beta_generated_ModelArmor_ListTemplates_Paged_async]
