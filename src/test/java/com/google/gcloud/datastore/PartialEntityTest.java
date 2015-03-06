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
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class PartialEntityTest {

  private static final Key KEY1 = Key.builder("ds1", "k1", "n1").build();
  private static final IncompleteKey PARTIAL_KEY = IncompleteKey.builder("ds1", "k2").build();
  private static final Entity ENTITY = Entity.builder(KEY1).set("foo", "bar").build();
  private static final PartialEntity PARTIAL_ENTITY =
      PartialEntity.builder(PARTIAL_KEY).set("a", "b").build();

  @Test
  public void testGetKey() throws Exception {
    assertEquals(PARTIAL_KEY, PARTIAL_ENTITY.key());
    assertEquals("b", PARTIAL_ENTITY.getString("a"));
  }

  @Test
  public void testNoKey() throws Exception {
    PartialEntity entity = PartialEntity.builder().set("foo", "bar").build();
    assertNull(entity.key());
    assertEquals("bar", entity.getString("foo"));
  }

  @Test
  public void testCopyFromPartialEntity() throws Exception {
    PartialEntity entity = Entity.builder(PARTIAL_ENTITY).build();
    assertEquals(PARTIAL_ENTITY, entity);
    entity = Entity.builder(PARTIAL_ENTITY).key(KEY1).build();
    assertNotEquals(PARTIAL_ENTITY, entity);
    assertEquals(PARTIAL_ENTITY.properties(), entity.properties());
    assertNotEquals(PARTIAL_ENTITY.key(), entity.key());
    assertEquals(KEY1, entity.key());
  }

  @Test
  public void testCopyFromEntity() throws Exception {
    PartialEntity entity = Entity.builder(ENTITY).build();
    assertEquals(ENTITY, entity);
  }
}
