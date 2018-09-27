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

import com.google.cloud.dialogflow.v2.EntityType;
import com.google.cloud.dialogflow.v2.EntityType.Entity;
import com.google.protobuf.ProtocolStringList;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

/**
 * Integration (system) tests for {@link EntityManagement} and {@link EntityTypeManagement}.
 */
@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class EntityManagementIT {
  private static String PROJECT_ID = System.getenv().get("GOOGLE_CLOUD_PROJECT");
  private static String ENTITY_TYPE_DISPLAY_NAME = "fake_entity_type_for_testing";
  private static String ENTITY_VALUE_1 = "fake_entity_for_testing_1";
  private static String ENTITY_VALUE_2 = "fake_entity_for_testing_2";
  private static List<String> SYNONYMS = Arrays.asList("fake_synonym_for_testing_1",
      "fake_synonym_for_testing_2");

  @Before
  public void setUp() {
    System.setOut(new PrintStream(new ByteArrayOutputStream()));
  }

  @After
  public void tearDown() {
    System.setOut(null);
  }

  @Test
  public void testCreateEntityType() throws Exception {
    List<String> entityTypeIds = EntityTypeManagement.getEntityTypeIds(
        ENTITY_TYPE_DISPLAY_NAME, PROJECT_ID);

    assertThat(entityTypeIds.size()).isEqualTo(0);

    EntityType entityType = EntityTypeManagement.createEntityType(
        ENTITY_TYPE_DISPLAY_NAME, PROJECT_ID, "KIND_MAP");
    assertEquals(ENTITY_TYPE_DISPLAY_NAME, entityType.getDisplayName());

    entityTypeIds = EntityTypeManagement.getEntityTypeIds(
        ENTITY_TYPE_DISPLAY_NAME, PROJECT_ID);

    assertThat(entityTypeIds.size()).isEqualTo(1);
  }

  @Test
  public void testCreateEntityWithCreatedEntityType() throws Exception {
    List<String> entityTypeIds = EntityTypeManagement.getEntityTypeIds(ENTITY_TYPE_DISPLAY_NAME,
        PROJECT_ID);

    EntityManagement.createEntity(
        PROJECT_ID, entityTypeIds.get(0), ENTITY_VALUE_1, Collections.singletonList(""));
    EntityManagement.createEntity(
        PROJECT_ID, entityTypeIds.get(0), ENTITY_VALUE_2, SYNONYMS);

    List<Entity> entities = EntityManagement.listEntities(PROJECT_ID, entityTypeIds.get(0));
    assertEquals(2, entities.size());

    int entityOneInd = entities.get(0).getValue().equals(ENTITY_VALUE_1) ? 0 : 1;
    int entityTwoInd = entityOneInd == 0 ? 1 : 0;
    assertEquals(ENTITY_VALUE_1, entities.get(entityOneInd).getValue());
    assertEquals(ENTITY_VALUE_2, entities.get(entityTwoInd).getValue());
    ProtocolStringList synonyms = entities.get(entityTwoInd).getSynonymsList();
    assertEquals(2, synonyms.size());
    for (String synonym : SYNONYMS) {
      assertThat(synonyms).contains(synonym);
    }
  }

  @Test
  public void testDeleteEntity() throws Exception {
    List<String> entityTypeIds = EntityTypeManagement.getEntityTypeIds(
        ENTITY_TYPE_DISPLAY_NAME, PROJECT_ID);

    EntityManagement.deleteEntity(PROJECT_ID, entityTypeIds.get(0), ENTITY_VALUE_1);
    EntityManagement.deleteEntity(PROJECT_ID, entityTypeIds.get(0), ENTITY_VALUE_2);

    List<Entity> entities = EntityManagement.listEntities(PROJECT_ID, entityTypeIds.get(0));
    assertEquals(0, entities.size());
  }

  @Test
  public void testDeleteEntityType() throws Exception {
    List<String> entityTypeIds = EntityTypeManagement.getEntityTypeIds(
        ENTITY_TYPE_DISPLAY_NAME, PROJECT_ID);

    for (String entityTypeId : entityTypeIds) {
      EntityTypeManagement.deleteEntityType(entityTypeId, PROJECT_ID);
    }

    entityTypeIds = EntityTypeManagement.getEntityTypeIds(ENTITY_TYPE_DISPLAY_NAME, PROJECT_ID);
    assertThat(entityTypeIds.size()).isEqualTo(0);
  }
}
