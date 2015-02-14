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
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class KeyTest {

  @Test
  public void testHasId() throws Exception {
    Key.Builder builder = Key.builder("d", "k", 10);
    Key key = builder.build();
    assertTrue(key.hasId());
    key = builder.name("bla").build();
    assertFalse(key.hasId());
  }

  @Test
  public void testId() throws Exception {
    Key.Builder builder = Key.builder("d", "k", 10);
    Key key = builder.build();
    assertEquals(Long.valueOf(10), key.id());
    key = builder.id(100).build();
    assertEquals(Long.valueOf(100), key.id());
  }

  @Test
  public void testHasName() throws Exception {
    Key.Builder builder = Key.builder("d", "k", "n");
    Key key = builder.build();
    assertTrue(key.hasName());
    key = builder.id(1).build();
    assertFalse(key.hasName());
  }

  @Test
  public void testName() throws Exception {
    Key.Builder builder = Key.builder("d", "k", "n");
    Key key = builder.build();
    assertEquals("n", key.name());
    key = builder.name("o").build();
    assertEquals("o", key.name());
  }

  @Test
  public void testNameOrId() throws Exception {
    Key.Builder builder = Key.builder("d", "k", "n");
    Key key = builder.build();
    assertEquals("n", key.nameOrId());
    key = builder.id(1).build();
    assertEquals(Long.valueOf(1), key.nameOrId());
  }

  @Test
  public void testToAndFromUrlSafe() throws Exception {
    Key key = Key.builder("d", "k", "n").build();
    String urlSafe = key.toUrlSafe();
    Key copy = Key.fromUrlSafe(urlSafe);
    assertEquals(key, copy);
  }
}
