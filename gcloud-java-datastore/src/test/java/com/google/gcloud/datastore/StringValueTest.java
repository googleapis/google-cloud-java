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

public class StringValueTest {

  private static final String CONTENT = "hello world";

  @Test
  public void testToBuilder() throws Exception {
    StringValue value = StringValue.of(CONTENT);
    assertEquals(value, value.toBuilder().build());
  }

  @Test
  public void testOf() throws Exception {
    StringValue value = StringValue.of(CONTENT);
    assertEquals(CONTENT, value.get());
    assertFalse(value.excludeFromIndexes());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testBuilder() throws Exception {
    StringValue.Builder builder = StringValue.builder(CONTENT);
    StringValue value = builder.meaning(1).excludeFromIndexes(true).build();
    assertEquals(CONTENT, value.get());
    assertEquals(1, value.meaning());
    assertTrue(value.excludeFromIndexes());
  }
}
