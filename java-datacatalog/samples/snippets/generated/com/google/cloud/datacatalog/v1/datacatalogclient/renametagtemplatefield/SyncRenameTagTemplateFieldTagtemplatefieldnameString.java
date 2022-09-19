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

package com.google.cloud.datacatalog.v1.samples;

// [START datacatalog_v1_generated_datacatalogclient_renametagtemplatefield_tagtemplatefieldnamestring_sync]
import com.google.cloud.datacatalog.v1.DataCatalogClient;
import com.google.cloud.datacatalog.v1.TagTemplateField;
import com.google.cloud.datacatalog.v1.TagTemplateFieldName;

public class SyncRenameTagTemplateFieldTagtemplatefieldnameString {

  public static void main(String[] args) throws Exception {
    syncRenameTagTemplateFieldTagtemplatefieldnameString();
  }

  public static void syncRenameTagTemplateFieldTagtemplatefieldnameString() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
      TagTemplateFieldName name =
          TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
      String newTagTemplateFieldId = "newTagTemplateFieldId2008993953";
      TagTemplateField response =
          dataCatalogClient.renameTagTemplateField(name, newTagTemplateFieldId);
    }
  }
}
// [END datacatalog_v1_generated_datacatalogclient_renametagtemplatefield_tagtemplatefieldnamestring_sync]
