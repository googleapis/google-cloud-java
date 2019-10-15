/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.datacatalog.v1beta1.it;

import static org.junit.Assert.assertEquals;

import com.google.cloud.ServiceOptions;
import com.google.cloud.datacatalog.EntryGroup;
import com.google.cloud.datacatalog.EntryGroupName;
import com.google.cloud.datacatalog.FieldName;
import com.google.cloud.datacatalog.FieldType;
import com.google.cloud.datacatalog.LocationName;
import com.google.cloud.datacatalog.TagTemplate;
import com.google.cloud.datacatalog.TagTemplateField;
import com.google.cloud.datacatalog.TagTemplateName;
import com.google.cloud.datacatalog.v1beta1.DataCatalogClient;
import com.google.cloud.datacatalog.v1beta1.DataCatalogHelper;
import com.google.iam.v1.Policy;
import com.google.protobuf.FieldMask;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSystemTest {
  private static DataCatalogClient client;

  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final String TAG_TEMPLATE_ID = DataCatalogHelper.generateTagTemplateId();
  private static final String TAG_TEMPLATE_FIELD_ID = DataCatalogHelper.generateTagTempleFieldId();
  private static final String ENTRY_GROUP_ID = DataCatalogHelper.generateEntryGroupId();
  private static final String TAG_TEMPLATE_DISPLAY_NAME = "test-tag-template-display";
  private static final String ENTRY_GROUP_DISPLAY_NAME = "test-entry-group-display";
  private static final String DESCRIPTION = "test-description";
  private static final String LOCATION = "us-central1";
  private static final String PII = "PII";
  private static final boolean FORCE = true;
  private static final String PARENT = LocationName.format(PROJECT_ID, LOCATION);
  private static final String TAG_TEMPLATE_NAME =
      TagTemplateName.format(PROJECT_ID, LOCATION, TAG_TEMPLATE_ID);
  private static final String ENTRY_GROUP_NAME =
      EntryGroupName.format(PROJECT_ID, LOCATION, ENTRY_GROUP_ID);
  private static final String FIELD_NAME =
      FieldName.format(PROJECT_ID, LOCATION, TAG_TEMPLATE_ID, TAG_TEMPLATE_FIELD_ID);

  private static final TagTemplateField SOURCE_FIELD =
      TagTemplateField.newBuilder()
          .setDisplayName("Source of data asset")
          .setType(FieldType.newBuilder().setPrimitiveType(FieldType.PrimitiveType.STRING).build())
          .build();

  private static final TagTemplateField NUM_ROWS_FIELD =
      TagTemplateField.newBuilder()
          .setDisplayName("Number of rows in data asset")
          .setType(FieldType.newBuilder().setPrimitiveType(FieldType.PrimitiveType.DOUBLE).build())
          .build();

  private static final TagTemplateField PII_FIELD =
      TagTemplateField.newBuilder()
          .setDisplayName(PII)
          .setType(FieldType.newBuilder().setPrimitiveType(FieldType.PrimitiveType.BOOL).build())
          .build();

  private static final TagTemplate TAGTEMPLATE =
      TagTemplate.newBuilder()
          .setName(TAG_TEMPLATE_ID)
          .setDisplayName(TAG_TEMPLATE_DISPLAY_NAME)
          .putFields("source", SOURCE_FIELD)
          .putFields("num_rows", NUM_ROWS_FIELD)
          .build();

  private static final EntryGroup ENTRY_GROUP =
      EntryGroup.newBuilder()
          .setName(ENTRY_GROUP_ID)
          .setDisplayName(ENTRY_GROUP_DISPLAY_NAME)
          .setDescription(DESCRIPTION)
          .build();

  @BeforeClass
  public static void beforeClass() throws Exception {
    client = DataCatalogClient.create();
    client.createTagTemplate(PARENT, TAG_TEMPLATE_ID, TAGTEMPLATE);
    client.createEntryGroup(PARENT, ENTRY_GROUP_ID, ENTRY_GROUP);
  }

  @AfterClass
  public static void afterClass() {
    client.deleteEntryGroup(ENTRY_GROUP_NAME);
    client.deleteTagTemplateField(FIELD_NAME, FORCE);
    client.deleteTagTemplate(TAG_TEMPLATE_NAME, FORCE);
    client.close();
  }

  @Test
  public void getTagTemplateTest() {
    TagTemplate response = client.getTagTemplate(TAG_TEMPLATE_NAME);
    assertEquals(TAG_TEMPLATE_NAME, response.getName());
    assertEquals(TAG_TEMPLATE_DISPLAY_NAME, response.getDisplayName());
  }

  @Test
  public void createTagTemplateFieldTest() {
    TagTemplateField response =
        client.createTagTemplateField(TAG_TEMPLATE_NAME, TAG_TEMPLATE_FIELD_ID, PII_FIELD);
    assertEquals(PII, response.getDisplayName());
  }

  @Test
  public void getEntryGroupTest() {
    FieldMask readMask = FieldMask.newBuilder().build();
    EntryGroup response = client.getEntryGroup(ENTRY_GROUP_NAME, readMask);
    assertEquals(ENTRY_GROUP_NAME, response.getName());
    assertEquals(ENTRY_GROUP_DISPLAY_NAME, response.getDisplayName());
  }

  @Test
  public void setIamPolicyTest() {
    Policy policy = Policy.newBuilder().setVersion(1).build();
    Policy response = client.setIamPolicy(TAG_TEMPLATE_NAME, policy);
    assertEquals(1, response.getVersion());
  }

  @Test
  public void getIamPolicyTest() {
    Policy response = client.getIamPolicy(TAG_TEMPLATE_NAME);
    assertEquals(1, response.getVersion());
  }
}
