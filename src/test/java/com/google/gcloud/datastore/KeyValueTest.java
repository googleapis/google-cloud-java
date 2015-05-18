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

public class KeyValueTest {

  private static final Key CONTENT = Key.builder("ds", "kind", 1).build();

  @Test
  public void testToBuilder() throws Exception {
    KeyValue value = KeyValue.of(CONTENT);
    assertEquals(value, value.toBuilder().build());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testOf() throws Exception {
    KeyValue value = KeyValue.of(CONTENT);
    assertEquals(CONTENT, value.get());
    assertFalse(value.hasIndexed());
    assertFalse(value.hasMeaning());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testBuilder() throws Exception {
    KeyValue.Builder builder = KeyValue.builder(CONTENT);
    KeyValue value = builder.meaning(1).indexed(false).build();
    assertEquals(CONTENT, value.get());
    assertTrue(value.hasMeaning());
    assertEquals(Integer.valueOf(1), value.meaning());
    assertTrue(value.hasIndexed());
    assertFalse(value.indexed());
  }
}
