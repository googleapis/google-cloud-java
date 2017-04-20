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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.cloud.Timestamp;
import org.junit.Test;

public class TimestampValueTest {

  private static final Timestamp CONTENT = Timestamp.now();

  @Test
  public void testToBuilder() throws Exception {
    TimestampValue value = TimestampValue.of(CONTENT);
    assertEquals(value, value.toBuilder().build());
  }

  @Test
  public void testOf() throws Exception {
    TimestampValue value = TimestampValue.of(CONTENT);
    assertEquals(CONTENT, value.get());
    assertFalse(value.excludeFromIndexes());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testBuilder() throws Exception {
    TimestampValue.Builder builder = TimestampValue.newBuilder(CONTENT);
    TimestampValue value = builder.setMeaning(1).setExcludeFromIndexes(true).build();
    assertEquals(CONTENT, value.get());
    assertEquals(1, value.getMeaning());
    assertTrue(value.excludeFromIndexes());
  }
}
