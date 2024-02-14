/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.aiplatform.v1.samples;

// [START aiplatform_v1_generated_ModelGardenService_GetPublisherModel_sync]
import com.google.cloud.aiplatform.v1.GetPublisherModelRequest;
import com.google.cloud.aiplatform.v1.ModelGardenServiceClient;
import com.google.cloud.aiplatform.v1.PublisherModel;
import com.google.cloud.aiplatform.v1.PublisherModelName;
import com.google.cloud.aiplatform.v1.PublisherModelView;

public class SyncGetPublisherModel {

  public static void main(String[] args) throws Exception {
    syncGetPublisherModel();
  }

  public static void syncGetPublisherModel() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
      GetPublisherModelRequest request =
          GetPublisherModelRequest.newBuilder()
              .setName(PublisherModelName.of("[PUBLISHER]", "[MODEL]").toString())
              .setLanguageCode("languageCode-2092349083")
              .setView(PublisherModelView.forNumber(0))
              .build();
      PublisherModel response = modelGardenServiceClient.getPublisherModel(request);
    }
  }
}
// [END aiplatform_v1_generated_ModelGardenService_GetPublisherModel_sync]
