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

public class BooleanValueTest {

  @Test
  public void testToBuilder() throws Exception {
    BooleanValue value = BooleanValue.of(true);
    assertEquals(value, value.toBuilder().build());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testOf() throws Exception {
    BooleanValue value = BooleanValue.of(false);
    assertFalse(value.get());
    assertFalse(value.hasIndexed());
    assertFalse(value.hasMeaning());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testBuilder() throws Exception {
    BooleanValue.Builder builder = BooleanValue.builder(true);
    BooleanValue value = builder.meaning(1).indexed(true).build();
    assertTrue(value.get());
    assertTrue(value.hasMeaning());
    assertEquals(Integer.valueOf(1), value.meaning());
    assertTrue(value.hasIndexed());
    assertTrue(value.indexed());
  }
}
