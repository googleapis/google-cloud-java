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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EntityTest {

  private static final Key KEY1 = Key.newBuilder("ds1", "k1", "n1").build();
  private static final Key KEY2 = Key.newBuilder("ds1", "k2", 1).build();
  private static final IncompleteKey INCOMPLETE_KEY = IncompleteKey.newBuilder("ds1", "k2").build();
  private static final Entity ENTITY = Entity.newBuilder(KEY1).set("foo", "bar").build();
  private static final FullEntity<IncompleteKey> INCOMPLETE_ENTITY =
      Entity.newBuilder(INCOMPLETE_KEY).set("a", "b").build();

  @Test
  public void testEntity() {
    assertTrue(ENTITY.hasKey());
    assertEquals(KEY1, ENTITY.getKey());
    assertEquals("bar", ENTITY.getString("foo"));
  }

  @Test
  public void testCopyFrom() {
    Entity.Builder builder = Entity.newBuilder(ENTITY);
    assertEquals(ENTITY, builder.build());
    Entity entity = builder.setKey(KEY2).build();
    assertNotEquals(ENTITY, entity);
    assertEquals(KEY2, entity.getKey());
    assertEquals(ENTITY.getProperties(), entity.getProperties());
  }

  @Test
  public void testCopyFromIncompleteEntity() {
    Entity.Builder builder = Entity.newBuilder(KEY2, INCOMPLETE_ENTITY);
    Entity entity = builder.build();
    assertNotEquals(INCOMPLETE_ENTITY, entity);
    assertEquals(INCOMPLETE_ENTITY.getProperties(), entity.getProperties());
  }

  @Test
  public void testEntitySize() {
    assertEquals(ENTITY.toPb().getSerializedSize(), Entity.calculateSerializedSize(ENTITY));
  }
}
