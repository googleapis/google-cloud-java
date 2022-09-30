/*
 * Copyright 2020 Google Inc.
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

// [START data_catalog_quickstart]
import com.google.cloud.datacatalog.v1.CreateTagRequest;
import com.google.cloud.datacatalog.v1.CreateTagTemplateRequest;
import com.google.cloud.datacatalog.v1.DataCatalogClient;
import com.google.cloud.datacatalog.v1.Entry;
import com.google.cloud.datacatalog.v1.FieldType;
import com.google.cloud.datacatalog.v1.FieldType.EnumType;
import com.google.cloud.datacatalog.v1.FieldType.EnumType.EnumValue;
import com.google.cloud.datacatalog.v1.FieldType.PrimitiveType;
import com.google.cloud.datacatalog.v1.LocationName;
import com.google.cloud.datacatalog.v1.LookupEntryRequest;
import com.google.cloud.datacatalog.v1.Tag;
import com.google.cloud.datacatalog.v1.TagField;
import com.google.cloud.datacatalog.v1.TagTemplate;
import com.google.cloud.datacatalog.v1.TagTemplateField;
import java.io.IOException;

public class Quickstart {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String tagTemplateId = "my_tag_template";
    createTags(projectId, tagTemplateId);
  }

  public static void createTags(String projectId, String tagTemplateId) throws IOException {
    // Currently, Data Catalog stores metadata in the us-central1 region.
    String location = "us-central1";

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {

      // -------------------------------
      // Create a Tag Template.
      // -------------------------------
      TagTemplateField sourceField =
          TagTemplateField.newBuilder()
              .setDisplayName("Source of data asset")
              .setType(FieldType.newBuilder().setPrimitiveType(PrimitiveType.STRING).build())
              .build();

      TagTemplateField numRowsField =
          TagTemplateField.newBuilder()
              .setDisplayName("Number of rows in data asset")
              .setType(FieldType.newBuilder().setPrimitiveType(PrimitiveType.DOUBLE).build())
              .build();

      TagTemplateField hasPiiField =
          TagTemplateField.newBuilder()
              .setDisplayName("Has PII")
              .setType(FieldType.newBuilder().setPrimitiveType(PrimitiveType.BOOL).build())
              .build();

      TagTemplateField piiTypeField =
          TagTemplateField.newBuilder()
              .setDisplayName("PII type")
              .setType(
                  FieldType.newBuilder()
                      .setEnumType(
                          EnumType.newBuilder()
                              .addAllowedValues(
                                  EnumValue.newBuilder().setDisplayName("EMAIL").build())
                              .addAllowedValues(
                                  EnumValue.newBuilder()
                                      .setDisplayName("SOCIAL SECURITY NUMBER")
                                      .build())
                              .addAllowedValues(
                                  EnumValue.newBuilder().setDisplayName("NONE").build())
                              .build())
                      .build())
              .build();

      TagTemplate tagTemplate =
          TagTemplate.newBuilder()
              .setDisplayName("Demo Tag Template")
              .putFields("source", sourceField)
              .putFields("num_rows", numRowsField)
              .putFields("has_pii", hasPiiField)
              .putFields("pii_type", piiTypeField)
              .build();

      CreateTagTemplateRequest createTagTemplateRequest =
          CreateTagTemplateRequest.newBuilder()
              .setParent(
                  LocationName.newBuilder()
                      .setProject(projectId)
                      .setLocation(location)
                      .build()
                      .toString())
              .setTagTemplateId(tagTemplateId)
              .setTagTemplate(tagTemplate)
              .build();

      // Create the Tag Template.
      tagTemplate = dataCatalogClient.createTagTemplate(createTagTemplateRequest);

      // -------------------------------
      // Lookup Data Catalog's Entry referring to the table.
      // -------------------------------
      String linkedResource =
          String.format(
              "//bigquery.googleapis.com/projects/%s/datasets/test_dataset/tables/test_table",
              projectId);
      LookupEntryRequest lookupEntryRequest =
          LookupEntryRequest.newBuilder().setLinkedResource(linkedResource).build();
      Entry tableEntry = dataCatalogClient.lookupEntry(lookupEntryRequest);

      // -------------------------------
      // Attach a Tag to the table.
      // -------------------------------
      TagField sourceValue =
          TagField.newBuilder().setStringValue("Copied from tlc_yellow_trips_2017").build();
      TagField numRowsValue = TagField.newBuilder().setDoubleValue(113496874).build();
      TagField hasPiiValue = TagField.newBuilder().setBoolValue(false).build();
      TagField piiTypeValue =
          TagField.newBuilder()
              .setEnumValue(TagField.EnumValue.newBuilder().setDisplayName("NONE").build())
              .build();

      Tag tag =
          Tag.newBuilder()
              .setTemplate(tagTemplate.getName())
              .putFields("source", sourceValue)
              .putFields("num_rows", numRowsValue)
              .putFields("has_pii", hasPiiValue)
              .putFields("pii_type", piiTypeValue)
              .build();

      CreateTagRequest createTagRequest =
          CreateTagRequest.newBuilder().setParent(tableEntry.getName()).setTag(tag).build();

      dataCatalogClient.createTag(createTagRequest);
      System.out.printf("Tag created successfully");
    }
  }
}
// [END data_catalog_quickstart]
