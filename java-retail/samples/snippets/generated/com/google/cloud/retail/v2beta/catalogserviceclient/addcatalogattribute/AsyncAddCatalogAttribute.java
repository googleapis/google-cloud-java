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

package com.google.cloud.retail.v2beta.samples;

// [START retail_v2beta_generated_catalogserviceclient_addcatalogattribute_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.retail.v2beta.AddCatalogAttributeRequest;
import com.google.cloud.retail.v2beta.AttributesConfig;
import com.google.cloud.retail.v2beta.AttributesConfigName;
import com.google.cloud.retail.v2beta.CatalogAttribute;
import com.google.cloud.retail.v2beta.CatalogServiceClient;

public class AsyncAddCatalogAttribute {

  public static void main(String[] args) throws Exception {
    asyncAddCatalogAttribute();
  }

  public static void asyncAddCatalogAttribute() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
      AddCatalogAttributeRequest request =
          AddCatalogAttributeRequest.newBuilder()
              .setAttributesConfig(
                  AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
              .setCatalogAttribute(CatalogAttribute.newBuilder().build())
              .build();
      ApiFuture<AttributesConfig> future =
          catalogServiceClient.addCatalogAttributeCallable().futureCall(request);
      // Do something.
      AttributesConfig response = future.get();
    }
  }
}
// [END retail_v2beta_generated_catalogserviceclient_addcatalogattribute_async]
