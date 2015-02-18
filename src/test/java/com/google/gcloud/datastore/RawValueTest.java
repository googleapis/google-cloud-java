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

import com.google.api.services.datastore.DatastoreV1;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RawValueTest {

  private static final DatastoreV1.Value CONTENT = StringValue.of("hello").toPb();

  @Test
  public void testToBuilder() throws Exception {
    RawValue value = RawValue.of(CONTENT);
    assertEquals(value, value.toBuilder().build());
  }

  @Test
  public void testOf() throws Exception {
    RawValue value = RawValue.of(CONTENT);
    assertEquals(CONTENT, value.get());
    assertFalse(value.hasIndexed());
    assertFalse(value.hasMeaning());
  }

  @Test
  public void testBuilder() throws Exception {
    RawValue.Builder builder = RawValue.builder(CONTENT);
    RawValue value = builder.meaning(1).indexed(false).build();
    assertEquals(CONTENT, value.get());
    assertTrue(value.hasMeaning());
    assertEquals(Integer.valueOf(1), value.meaning());
    assertTrue(value.hasIndexed());
    assertFalse(value.indexed());
  }
}
