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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.cloud.dialogflow.v2.EntityType;
import com.google.cloud.dialogflow.v2.EntityType.Kind;
import com.google.cloud.dialogflow.v2.SessionEntityType;
import com.google.cloud.dialogflow.v2.SessionEntityTypesClient;
import com.google.cloud.dialogflow.v2.SessionName;

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

  @Before
  public void setUp() {
    System.setOut(new PrintStream(new ByteArrayOutputStream()));
  }

  @After
  public void tearDown() throws Exception {
    try (SessionEntityTypesClient sessionEntityTypesClient = SessionEntityTypesClient.create()) {
      SessionName session = SessionName.of(PROJECT_ID, SESSION_ID);

      // Performs the list session entity types request
      for (SessionEntityType sessionEntityType :
          sessionEntityTypesClient.listSessionEntityTypes(session).iterateAll()) {
        if (sessionEntityType.getName().equals(ENTITY_TYPE_DISPLAY_NAME)) {
          sessionEntityTypesClient.deleteSessionEntityType(sessionEntityType.getName());
        }
      }
    }
    System.setOut(null);
  }

  @Test
  public void testCreateDeleteSessionEntityType() throws Exception {
    // Create session entity type
    EntityType entityType = EntityTypeManagement
        .createEntityType(ENTITY_TYPE_DISPLAY_NAME, PROJECT_ID, "KIND_MAP");
    assertEquals(Kind.valueOf("KIND_MAP"), entityType.getKind());

    SessionEntityTypeManagement.createSessionEntityType(
        PROJECT_ID, SESSION_ID, ENTITY_VALUES, ENTITY_TYPE_DISPLAY_NAME, 1);

    List<SessionEntityType> sessionEntityTypes = SessionEntityTypeManagement
        .listSessionEntityTypes(PROJECT_ID, SESSION_ID);
    assertEquals(1, sessionEntityTypes.size());
    SessionEntityType sessionEntityType = sessionEntityTypes.get(0);
    assertThat(sessionEntityType.getName()).contains(SESSION_ID);
    assertThat(sessionEntityType.getName()).contains(ENTITY_TYPE_DISPLAY_NAME);

    for (String entityValue : ENTITY_VALUES) {
      assertTrue(sessionEntityType
          .getEntitiesList().stream().anyMatch(e -> e.getValue().equals(entityValue)));
    }

    // Delete session entity type
    SessionEntityTypeManagement.deleteSessionEntityType(
        PROJECT_ID, SESSION_ID, ENTITY_TYPE_DISPLAY_NAME);

    sessionEntityTypes = SessionEntityTypeManagement.listSessionEntityTypes(PROJECT_ID, SESSION_ID);
    assertEquals(0, sessionEntityTypes.size());

    List<String> entityTypesIds = EntityTypeManagement.getEntityTypeIds(
        ENTITY_TYPE_DISPLAY_NAME, PROJECT_ID);

    for (String entityTypeId : entityTypesIds) {
      EntityTypeManagement.deleteEntityType(entityTypeId, PROJECT_ID);
    }
  }
}
