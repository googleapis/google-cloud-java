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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FullEntityTest {

  private static final Key KEY1 = Key.newBuilder("ds1", "k1", "n1").build();
  private static final Key KEY2 = Key.newBuilder("ds1", "k2", 1).build();
  private static final IncompleteKey INCOMPLETE_KEY = IncompleteKey.newBuilder("ds1", "k2").build();
  private static final Entity ENTITY = Entity.newBuilder(KEY1).set("foo", "bar").build();
  private static final FullEntity<Key> COMPLETE_ENTITY1 = ENTITY;
  private static final FullEntity<Key> COMPLETE_ENTITY2 =
      FullEntity.newBuilder(KEY2).set("foo", "bar").build();
  private static final FullEntity<IncompleteKey> INCOMPLETE_ENTITY =
      Entity.newBuilder(INCOMPLETE_KEY).set("a", "b").build();

  @Test
  public void testFullEntity() {
    assertTrue(COMPLETE_ENTITY1.hasKey());
    assertEquals(KEY1, COMPLETE_ENTITY1.getKey());
    assertEquals("bar", COMPLETE_ENTITY1.getString("foo"));

    assertTrue(COMPLETE_ENTITY2.hasKey());
    assertEquals(KEY2, COMPLETE_ENTITY2.getKey());
    assertEquals("bar", COMPLETE_ENTITY2.getString("foo"));
  }

  @Test
  public void testNoKey() {
    FullEntity<IncompleteKey> entity = FullEntity.newBuilder().set("foo", "bar").build();
    assertFalse(entity.hasKey());
    assertNull(entity.getKey());
    assertEquals("bar", entity.getString("foo"));

    entity = FullEntity.newBuilder((IncompleteKey) null).build();
    assertFalse(entity.hasKey());
    assertNull(entity.getKey());
  }

  @Test
  public void testCopyFrom() {
    FullEntity.Builder<Key> builder1 = FullEntity.newBuilder(ENTITY);
    assertEquals(ENTITY, builder1.build());

    builder1 = FullEntity.newBuilder(COMPLETE_ENTITY1);
    assertEquals(COMPLETE_ENTITY1, builder1.build());

    FullEntity.Builder<IncompleteKey> builder2 = FullEntity.newBuilder(INCOMPLETE_ENTITY);
    assertEquals(INCOMPLETE_ENTITY, builder2.build());
  }
}
