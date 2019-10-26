/*
 * Copyright 2019 Google LLC
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

import static org.junit.Assert.assertThat;

import com.google.cloud.datacatalog.EntryGroupName;
import com.google.cloud.datacatalog.EntryName;
import com.google.cloud.datacatalog.v1beta1.DataCatalogClient;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration (system) tests for {@link CreateFilesetEntry} and {@link CreateEntryGroup}. */
@RunWith(JUnit4.class)
public class CreateEntryTests {

  private ByteArrayOutputStream bout;

  private static String ENTRY_GROUP_ID_NO_CHILDREN =
      "entry_group_no_children_" + UUID.randomUUID().toString().substring(0, 8);
  private static String PARENT_ENTRY_GROUP_ID =
      "fileset_entry_group_parent_" + UUID.randomUUID().toString().substring(0, 8);
  private static String ENTRY_ID =
      "fileset_entry_id_" + UUID.randomUUID().toString().substring(0, 8);
  private static String LOCATION = "us-central1";
  private static String PROJECT_ID = System.getenv().get("GOOGLE_CLOUD_PROJECT");

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bout));
  }

  @After
  public void tearDown() {
    System.setOut(null);
    bout.reset();
  }

  @AfterClass
  public static void tearDownClass() {
    try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
      dataCatalogClient.deleteEntryGroup(
          EntryGroupName.of(PROJECT_ID, LOCATION, ENTRY_GROUP_ID_NO_CHILDREN).toString());

      dataCatalogClient.deleteEntry(
          EntryName.of(PROJECT_ID, LOCATION, PARENT_ENTRY_GROUP_ID, ENTRY_ID).toString());
      dataCatalogClient.deleteEntryGroup(
          EntryGroupName.of(PROJECT_ID, LOCATION, PARENT_ENTRY_GROUP_ID).toString());
    } catch (Exception e) {
      System.out.println("Error in cleaning up test data:\n" + e.toString());
    }
  }

  @Test
  public void testCreateFilesetEntry() {
    // Must create a Entry Group before creating the entry.
    CreateEntryGroup.createEntryGroup(PROJECT_ID, PARENT_ENTRY_GROUP_ID);
    CreateFilesetEntry.createEntry(PROJECT_ID, PARENT_ENTRY_GROUP_ID, ENTRY_ID);

    String output = bout.toString();

    String entryTemplate =
        "Entry created with name: projects/%s/locations/us-central1/entryGroups/%s/entries/%s";
    assertThat(
        output,
        CoreMatchers.containsString(
            String.format(entryTemplate, PROJECT_ID, PARENT_ENTRY_GROUP_ID, ENTRY_ID)));
  }

  @Test
  public void testCreateEntryGroup() {
    CreateEntryGroup.createEntryGroup(PROJECT_ID, ENTRY_GROUP_ID_NO_CHILDREN);

    String output = bout.toString();

    String entryGroupTemplate =
        "Entry Group created with name: projects/%s/locations/us-central1/entryGroups/%s";
    assertThat(
        output,
        CoreMatchers.containsString(
            String.format(entryGroupTemplate, PROJECT_ID, ENTRY_GROUP_ID_NO_CHILDREN)));
  }
}