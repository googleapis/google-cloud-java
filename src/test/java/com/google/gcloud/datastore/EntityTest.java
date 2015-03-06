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

package com.google.gcloud.datastore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class EntityTest {

  private static final Key KEY1 = Key.builder("ds1", "k1", "n1").build();
  private static final Key KEY2 = Key.builder("ds1", "k2", 1).build();
  private static final IncompleteKey PARTIAL_KEY = IncompleteKey.builder("ds1", "k2").build();
  private static final Entity ENTITY = Entity.builder(KEY1).set("foo", "bar").build();
  private static final PartialEntity PARTIAL_ENTITY =
      PartialEntity.builder(PARTIAL_KEY).set("a", "b").build();

  @Test
  public void testGetKey() throws Exception {
    assertEquals(KEY1, ENTITY.key());
    assertEquals("bar", ENTITY.getString("foo"));
  }

  @Test
  public void testCopyFrom() throws Exception {
    Entity.Builder builder = Entity.builder(ENTITY);
    assertEquals(ENTITY, builder.build());
    Entity entity = builder.key(KEY2).build();
    assertNotEquals(ENTITY, entity);
    assertEquals(KEY2, entity.key());
    assertEquals(ENTITY.properties(), entity.properties());
  }

  @Test
  public void testCopyFromPartialEntity() throws Exception {
    Entity.Builder builder = Entity.builder(KEY2, PARTIAL_ENTITY);
    Entity entity = builder.build();
    assertNotEquals(PARTIAL_ENTITY, entity);
    assertEquals(PARTIAL_ENTITY.properties(), entity.properties());
  }
}
