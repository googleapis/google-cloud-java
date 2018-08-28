/*
 * Copyright 2018 Google LLC
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

package com.example.dialogflow;

import static com.google.common.truth.Truth.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Integration (system) tests for {@link SessionEntityTypeManagement}.
 */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class SessionEntityTypeManagementIT {
  private static String SESSION_ID = "fake_session_for_testing";
  private static String ENTITY_TYPE_DISPLAY_NAME = "fake_display_name_for_testing";
  private static List<String> ENTITY_VALUES = Arrays.asList("fake_entity_value_1",
      "fake_entity_value_2");
  private static String PROJECT_ID = System.getenv().get("GOOGLE_CLOUD_PROJECT");
  private ByteArrayOutputStream bout;
  private PrintStream out;

  private SessionEntityTypeManagement sessionEntityTypeManagement;
  private EntityTypeManagement entityTypeManagement;

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
    sessionEntityTypeManagement = new SessionEntityTypeManagement();
    entityTypeManagement = new EntityTypeManagement();
  }


  @After
  public void tearDown() {
    System.setOut(null);
  }


  @Test
  public void testCreateDeleteSessionEntityType() throws Exception {
    // Create session entity type
    entityTypeManagement.createEntityType(ENTITY_TYPE_DISPLAY_NAME, PROJECT_ID, "KIND_MAP");

    sessionEntityTypeManagement.createSessionEntityType(PROJECT_ID, SESSION_ID, ENTITY_VALUES,
        ENTITY_TYPE_DISPLAY_NAME, 1);

    sessionEntityTypeManagement.listSessionEntityTypes(PROJECT_ID, SESSION_ID);

    String got = bout.toString();
    assertThat(got).contains(SESSION_ID);
    assertThat(got).contains(ENTITY_TYPE_DISPLAY_NAME);
    for (String entityValue : ENTITY_VALUES) {
      assertThat(got).contains(entityValue);
    }

    // Delete session entity type
    bout.reset();
    sessionEntityTypeManagement.deleteSessionEntityType(PROJECT_ID, SESSION_ID,
        ENTITY_TYPE_DISPLAY_NAME);

    sessionEntityTypeManagement.listSessionEntityTypes(PROJECT_ID, SESSION_ID);

    got = bout.toString();
    assertThat(got).doesNotContain(ENTITY_TYPE_DISPLAY_NAME);
    for (String entityValue : ENTITY_VALUES) {
      assertThat(got).doesNotContain(entityValue);
    }

    List<String> entityTypesIds = entityTypeManagement.getEntityTypeIds(ENTITY_TYPE_DISPLAY_NAME,
        PROJECT_ID);

    for (String entityTypeId : entityTypesIds) {
      entityTypeManagement.deleteEntityType(entityTypeId, PROJECT_ID);
    }
  }
}
