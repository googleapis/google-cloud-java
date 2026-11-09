/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.designcenter.v1.samples;

// [START designcenter_v1_generated_DesignCenter_CreateCatalogTemplate_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.designcenter.v1.CatalogName;
import com.google.cloud.designcenter.v1.CatalogTemplate;
import com.google.cloud.designcenter.v1.CreateCatalogTemplateRequest;
import com.google.cloud.designcenter.v1.DesignCenterClient;

public class AsyncCreateCatalogTemplate {

  public static void main(String[] args) throws Exception {
    asyncCreateCatalogTemplate();
  }

  public static void asyncCreateCatalogTemplate() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
      CreateCatalogTemplateRequest request =
          CreateCatalogTemplateRequest.newBuilder()
              .setParent(
                  CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]").toString())
              .setCatalogTemplateId("catalogTemplateId-1740091346")
              .setCatalogTemplate(CatalogTemplate.newBuilder().build())
              .build();
      ApiFuture<CatalogTemplate> future =
          designCenterClient.createCatalogTemplateCallable().futureCall(request);
      // Do something.
      CatalogTemplate response = future.get();
    }
  }
}
// [END designcenter_v1_generated_DesignCenter_CreateCatalogTemplate_async]
