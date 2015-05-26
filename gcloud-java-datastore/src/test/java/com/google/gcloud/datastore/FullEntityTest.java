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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FullEntityTest {

  private static final Key KEY1 = Key.builder("ds1", "k1", "n1").build();
  private static final Key KEY2 = Key.builder("ds1", "k2", 1).build();
  private static final IncompleteKey INCOMPLETE_KEY = IncompleteKey.builder("ds1", "k2").build();
  private static final Entity ENTITY = Entity.builder(KEY1).set("foo", "bar").build();
  private static final FullEntity<Key> COMPLETE_ENTITY1 = ENTITY;
  private static final FullEntity<Key> COMPLETE_ENTITY2 =
      FullEntity.builder(KEY2).set("foo", "bar").build();
  private static final FullEntity<IncompleteKey> INCOMPLETE_ENTITY =
      Entity.builder(INCOMPLETE_KEY).set("a", "b").build();

  @Test
  public void testFullEntity() throws Exception {
    assertTrue(COMPLETE_ENTITY1.hasKey());
    assertEquals(KEY1, COMPLETE_ENTITY1.key());
    assertEquals("bar", COMPLETE_ENTITY1.getString("foo"));

    assertTrue(COMPLETE_ENTITY2.hasKey());
    assertEquals(KEY2, COMPLETE_ENTITY2.key());
    assertEquals("bar", COMPLETE_ENTITY2.getString("foo"));
  }

  @Test
  public void testNoKey() throws Exception {
    FullEntity<IncompleteKey> entity = FullEntity.builder().set("foo", "bar").build();
    assertFalse(entity.hasKey());
    assertNull(entity.key());
    assertEquals("bar", entity.getString("foo"));

    entity = FullEntity.builder((IncompleteKey) null).build();
    assertFalse(entity.hasKey());
    assertNull(entity.key());
  }

  @Test
  public void testCopyFrom() throws Exception {
    FullEntity.Builder<Key> builder1 = FullEntity.builder(ENTITY);
    assertEquals(ENTITY, builder1.build());

    builder1 = FullEntity.builder(COMPLETE_ENTITY1);
    assertEquals(COMPLETE_ENTITY1, builder1.build());

    FullEntity.Builder<IncompleteKey> builder2 = FullEntity.builder(INCOMPLETE_ENTITY);
    assertEquals(INCOMPLETE_ENTITY, builder2.build());
  }
}
