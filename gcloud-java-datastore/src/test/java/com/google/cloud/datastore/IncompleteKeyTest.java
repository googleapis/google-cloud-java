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
  private static Key parent1;

  @Before
  public void setUp() {
    pk1 = IncompleteKey.builder("ds", "kind1").build();
    parent1 = Key.builder("ds", "kind2", 10).namespace("ns").build();
    pk2 = IncompleteKey.builder(parent1, "kind3").build();
  }

  @Test
  public void testBuilders() throws Exception {
    assertEquals("ds", pk1.projectId());
    assertEquals("kind1", pk1.kind());
    assertTrue(pk1.ancestors().isEmpty());

    assertEquals("ds", pk2.projectId());
    assertEquals("kind3", pk2.kind());
    assertEquals(parent1.path(), pk2.ancestors());

    assertEquals(pk2, IncompleteKey.builder(pk2).build());
    IncompleteKey pk3 = IncompleteKey.builder(pk2).kind("kind4").build();
    assertEquals("ds", pk3.projectId());
    assertEquals("kind4", pk3.kind());
    assertEquals(parent1.path(), pk3.ancestors());
  }

  @Test
  public void testParent() {
    assertNull(pk1.parent());
    assertEquals(parent1, pk2.parent());
    Key parent2 = Key.builder("ds", "kind3", "name").namespace("ns").build();
    IncompleteKey pk3 = IncompleteKey.builder(parent2, "kind3").build();
    assertEquals(parent2, pk3.parent());
  }
}
