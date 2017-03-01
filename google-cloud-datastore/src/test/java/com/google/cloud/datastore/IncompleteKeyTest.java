/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.datastore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class IncompleteKeyTest {

  private static IncompleteKey pk1, pk2;
  private static IncompleteKey deprecatedPk1, deprecatedPk2;
  private static Key parent1;

  @Before
  public void setUp() {
    pk1 = IncompleteKey.newBuilder("ds", "kind1").build();
    parent1 = Key.newBuilder("ds", "kind2", 10).setNamespace("ns").build();
    pk2 = IncompleteKey.newBuilder(parent1, "kind3").build();
    deprecatedPk1 = IncompleteKey.builder("ds", "kind1").build();
    deprecatedPk2 = IncompleteKey.builder(parent1, "kind3").build();
  }

  @Test
  public void testBuilders() throws Exception {
    assertEquals("ds", pk1.getProjectId());
    assertEquals("kind1", pk1.getKind());
    assertTrue(pk1.getAncestors().isEmpty());

    assertEquals("ds", pk2.getProjectId());
    assertEquals("kind3", pk2.getKind());
    assertEquals(parent1.getPath(), pk2.getAncestors());

    assertEquals(pk2, IncompleteKey.newBuilder(pk2).build());
    IncompleteKey pk3 = IncompleteKey.newBuilder(pk2).setKind("kind4").build();
    assertEquals("ds", pk3.getProjectId());
    assertEquals("kind4", pk3.getKind());
    assertEquals(parent1.getPath(), pk3.getAncestors());
  }

  @Test
  public void testBuildersDeprecated() throws Exception {
    assertEquals("ds", deprecatedPk1.projectId());
    assertEquals("kind1", deprecatedPk1.kind());
    assertTrue(deprecatedPk1.ancestors().isEmpty());

    assertEquals("ds", deprecatedPk2.projectId());
    assertEquals("kind3", deprecatedPk2.kind());
    assertEquals(parent1.path(), deprecatedPk2.ancestors());

    assertEquals(deprecatedPk2, IncompleteKey.builder(deprecatedPk2).build());
    IncompleteKey deprecatedPk3 = IncompleteKey.builder(deprecatedPk2).kind("kind4").build();
    assertEquals("ds", deprecatedPk3.projectId());
    assertEquals("kind4", deprecatedPk3.kind());
    assertEquals(parent1.path(), deprecatedPk3.ancestors());
  }

  @Test
  public void testParent() {
    assertNull(pk1.getParent());
    assertEquals(parent1, pk2.getParent());
    Key parent2 = Key.newBuilder("ds", "kind3", "name").setNamespace("ns").build();
    IncompleteKey pk3 = IncompleteKey.newBuilder(parent2, "kind3").build();
    assertEquals(parent2, pk3.getParent());
  }

  @Test
  public void testParentDeprecated() {
    assertNull(deprecatedPk1.parent());
    assertEquals(parent1, deprecatedPk2.parent());
    Key parent2 = Key.newBuilder("ds", "kind3", "name").setName("ns").build();
    IncompleteKey deprecatedPk3 = IncompleteKey.builder(parent2, "kind3").build();
    assertEquals(parent2, deprecatedPk3.parent());
  }
}
