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

package com.google.cloud.dataplex.v1.samples;

// [START dataplex_v1_generated_DataTaxonomyService_CreateDataAttribute_sync]
import com.google.cloud.dataplex.v1.CreateDataAttributeRequest;
import com.google.cloud.dataplex.v1.DataAttribute;
import com.google.cloud.dataplex.v1.DataTaxonomyName;
import com.google.cloud.dataplex.v1.DataTaxonomyServiceClient;

public class SyncCreateDataAttribute {

  public static void main(String[] args) throws Exception {
    syncCreateDataAttribute();
  }

  public static void syncCreateDataAttribute() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataTaxonomyServiceClient dataTaxonomyServiceClient = DataTaxonomyServiceClient.create()) {
      CreateDataAttributeRequest request =
          CreateDataAttributeRequest.newBuilder()
              .setParent(
                  DataTaxonomyName.of("[PROJECT]", "[LOCATION]", "[DATA_TAXONOMY_ID]").toString())
              .setDataAttributeId("dataAttributeId-44128563")
              .setDataAttribute(DataAttribute.newBuilder().build())
              .setValidateOnly(true)
              .build();
      DataAttribute response = dataTaxonomyServiceClient.createDataAttributeAsync(request).get();
    }
  }
}
// [END dataplex_v1_generated_DataTaxonomyService_CreateDataAttribute_sync]
