/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.datacatalog;

// [START data_catalog_create_tag_template]
import com.google.cloud.datacatalog.v1.CreateTagTemplateRequest;
import com.google.cloud.datacatalog.v1.DataCatalogClient;
import com.google.cloud.datacatalog.v1.FieldType;
import com.google.cloud.datacatalog.v1.LocationName;
import com.google.cloud.datacatalog.v1.TagTemplate;
import com.google.cloud.datacatalog.v1.TagTemplateField;
import java.io.IOException;

// Sample to create tag template
public class CreateTagTemplate {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "MY_PROJECT_ID";
    String location = "MY_LOCATION";
    LocationName locationName = LocationName.of(projectId, location);
    String tagTemplateId = "MY_TAG_TEMPLATE_ID";
    TagTemplateField sourceField =
        TagTemplateField.newBuilder()
            .setDisplayName("Your display name")
            .setType(
                FieldType.newBuilder().setPrimitiveType(FieldType.PrimitiveType.STRING).build())
            .build();
    TagTemplate tagTemplate =
        TagTemplate.newBuilder()
            .setDisplayName("Your display name")
            .putFields("sourceField", sourceField)
            .build();
    createTagTemplate(locationName, tagTemplateId, tagTemplate);
  }

  public static void createTagTemplate(
      LocationName name, String tagTemplateId, TagTemplate template) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DataCatalogClient client = DataCatalogClient.create()) {
      CreateTagTemplateRequest request =
          CreateTagTemplateRequest.newBuilder()
              .setParent(name.toString())
              .setTagTemplateId(tagTemplateId)
              .setTagTemplate(template)
              .build();
      client.createTagTemplate(request);
      System.out.println("Tag template created successfully");
    }
  }
}
// [END data_catalog_create_tag_template]
