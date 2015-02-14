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
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PartialKeyTest {

  @Test
  public void testBuilders() throws Exception {
    PartialKey pk1 = PartialKey.builder("ds", "kind1").build();
    assertEquals("ds", pk1.dataset());
    assertEquals("kind1", pk1.kind());
    assertTrue(pk1.ancestors().isEmpty());

    Key parent = Key.builder("ds", "kind2", 10).build();
    PartialKey pk2 = PartialKey.builder(parent, "kind3").build();
    assertEquals("ds", pk2.dataset());
    assertEquals("kind3", pk2.kind());
    assertEquals(parent.path(), pk2.ancestors());

    assertEquals(pk2, PartialKey.builder(pk2).build());
    PartialKey pk3 = PartialKey.builder(pk2).kind("kind4").build();
    assertEquals("ds", pk3.dataset());
    assertEquals("kind4", pk3.kind());
    assertEquals(parent.path(), pk3.ancestors());
  }
}
