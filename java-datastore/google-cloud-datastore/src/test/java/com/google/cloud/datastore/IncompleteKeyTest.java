/*
 * Copyright 2015 Google LLC
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

  private static IncompleteKey pk1, pk2, pk4, pk5;
  private static Key parent1, parent2;

  @Before
  public void setUp() {
    pk1 = IncompleteKey.newBuilder("ds", "kind1").build();
    parent1 = Key.newBuilder("ds", "kind2", 10).setNamespace("ns").build();
    parent2 = Key.newBuilder("ds", "kind2", 10, "test-db").setNamespace("ns").build();
    pk2 = IncompleteKey.newBuilder(parent1, "kind3").build();
    pk4 = IncompleteKey.newBuilderWithDatabaseId("ds", "kind3", "test-db").build();
    pk5 = IncompleteKey.newBuilder(parent2, "kind4").build();
  }

  @Test
  public void testBuilders() {
    assertEquals("ds", pk1.getProjectId());
    assertEquals("", pk1.getDatabaseId());
    assertEquals("kind1", pk1.getKind());
    assertTrue(pk1.getAncestors().isEmpty());

    assertEquals("ds", pk2.getProjectId());
    assertEquals("", pk2.getDatabaseId());
    assertEquals("kind3", pk2.getKind());
    assertEquals(parent1.getPath(), pk2.getAncestors());

    assertEquals(pk2, IncompleteKey.newBuilder(pk2).build());
    IncompleteKey pk3 = IncompleteKey.newBuilder(pk2).setKind("kind4").build();
    assertEquals("ds", pk3.getProjectId());
    assertEquals("", pk3.getDatabaseId());
    assertEquals("kind4", pk3.getKind());
    assertEquals(parent1.getPath(), pk3.getAncestors());

    assertEquals("ds", pk4.getProjectId());
    assertEquals("test-db", pk4.getDatabaseId());
    assertEquals("kind3", pk4.getKind());
    assertTrue(pk4.getAncestors().isEmpty());

    assertEquals("ds", pk5.getProjectId());
    assertEquals("test-db", pk5.getDatabaseId());
    assertEquals("kind4", pk5.getKind());
    assertEquals(parent2.getPath(), pk5.getAncestors());
  }

  @Test
  public void testParent() {
    assertNull(pk1.getParent());
    assertEquals(parent1, pk2.getParent());
    assertEquals(parent2, pk5.getParent());
    Key parent2 = Key.newBuilder("ds", "kind3", "name").setNamespace("ns").build();
    IncompleteKey pk3 = IncompleteKey.newBuilder(parent2, "kind3").build();
    assertEquals(parent2, pk3.getParent());
  }
}
