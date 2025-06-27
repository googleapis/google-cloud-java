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

package com.google.shopping.merchant.productstudio.v1alpha.samples;

// [START merchantapi_v1alpha_generated_ImageService_RemoveProductImageBackground_sync]
import com.google.shopping.merchant.productstudio.v1alpha.ImageServiceClient;
import com.google.shopping.merchant.productstudio.v1alpha.InputImage;
import com.google.shopping.merchant.productstudio.v1alpha.OutputImageConfig;
import com.google.shopping.merchant.productstudio.v1alpha.RemoveImageBackgroundConfig;
import com.google.shopping.merchant.productstudio.v1alpha.RemoveProductImageBackgroundRequest;
import com.google.shopping.merchant.productstudio.v1alpha.RemoveProductImageBackgroundResponse;

public class SyncRemoveProductImageBackground {

  public static void main(String[] args) throws Exception {
    syncRemoveProductImageBackground();
  }

  public static void syncRemoveProductImageBackground() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ImageServiceClient imageServiceClient = ImageServiceClient.create()) {
      RemoveProductImageBackgroundRequest request =
          RemoveProductImageBackgroundRequest.newBuilder()
              .setName("name3373707")
              .setOutputConfig(OutputImageConfig.newBuilder().build())
              .setInputImage(InputImage.newBuilder().build())
              .setConfig(RemoveImageBackgroundConfig.newBuilder().build())
              .build();
      RemoveProductImageBackgroundResponse response =
          imageServiceClient.removeProductImageBackground(request);
    }
  }
}
// [END merchantapi_v1alpha_generated_ImageService_RemoveProductImageBackground_sync]
