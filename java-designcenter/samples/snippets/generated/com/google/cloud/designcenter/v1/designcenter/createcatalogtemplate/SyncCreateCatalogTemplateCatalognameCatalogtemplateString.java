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

// [START designcenter_v1_generated_DesignCenter_CreateCatalogTemplate_CatalognameCatalogtemplateString_sync]
import com.google.cloud.designcenter.v1.CatalogName;
import com.google.cloud.designcenter.v1.CatalogTemplate;
import com.google.cloud.designcenter.v1.DesignCenterClient;

public class SyncCreateCatalogTemplateCatalognameCatalogtemplateString {

  public static void main(String[] args) throws Exception {
    syncCreateCatalogTemplateCatalognameCatalogtemplateString();
  }

  public static void syncCreateCatalogTemplateCatalognameCatalogtemplateString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
      CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[SPACE]", "[CATALOG]");
      CatalogTemplate catalogTemplate = CatalogTemplate.newBuilder().build();
      String catalogTemplateId = "catalogTemplateId-1740091346";
      CatalogTemplate response =
          designCenterClient.createCatalogTemplate(parent, catalogTemplate, catalogTemplateId);
    }
  }
}
// [END designcenter_v1_generated_DesignCenter_CreateCatalogTemplate_CatalognameCatalogtemplateString_sync]
