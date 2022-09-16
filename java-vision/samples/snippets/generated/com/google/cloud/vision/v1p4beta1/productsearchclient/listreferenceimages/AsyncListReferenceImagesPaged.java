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

package com.google.cloud.vision.v1p4beta1.samples;

// [START vision_v1p4beta1_generated_productsearchclient_listreferenceimages_paged_async]
import com.google.cloud.vision.v1p4beta1.ListReferenceImagesRequest;
import com.google.cloud.vision.v1p4beta1.ListReferenceImagesResponse;
import com.google.cloud.vision.v1p4beta1.ProductName;
import com.google.cloud.vision.v1p4beta1.ProductSearchClient;
import com.google.cloud.vision.v1p4beta1.ReferenceImage;
import com.google.common.base.Strings;

public class AsyncListReferenceImagesPaged {

  public static void main(String[] args) throws Exception {
    asyncListReferenceImagesPaged();
  }

  public static void asyncListReferenceImagesPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
      ListReferenceImagesRequest request =
          ListReferenceImagesRequest.newBuilder()
              .setParent(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListReferenceImagesResponse response =
            productSearchClient.listReferenceImagesCallable().call(request);
        for (ReferenceImage element : response.getReferenceImagesList()) {
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
// [END vision_v1p4beta1_generated_productsearchclient_listreferenceimages_paged_async]
