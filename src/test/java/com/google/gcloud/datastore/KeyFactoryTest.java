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

import static junit.framework.TestCase.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class KeyFactoryTest {

  private static final String DATASET = "dataset";

  private KeyFactory keyFactory;

  @Before
  public void setUp() {
    keyFactory = new KeyFactory(DATASET).kind("k");
  }

  @Test
  public void testNewKey() throws Exception {
    Key key = keyFactory.newKey(1);
    verifyKey(key, 1L, null);
    key = keyFactory.newKey("n");
    verifyKey(key, "n", null);
    PathElement p1 = PathElement.of("k1", "n");
    PathElement p2 = PathElement.of("k2", 10);
    key = keyFactory.namespace("ns").ancestors(p1, p2).newKey("k3");
    verifyKey(key, "k3", "ns", p1, p2);
  }

  @Test
  public void testNewIncompleteKey() throws Exception {
    IncompleteKey key = keyFactory.newKey();
    verifyIncompleteKey(key, null);
    PathElement p1 = PathElement.of("k1", "n");
    PathElement p2 = PathElement.of("k2", 10);
    key = keyFactory.namespace("ns").ancestors(p1, p2).newKey();
    verifyIncompleteKey(key, "ns", p1, p2);
  }

  @Test(expected = NullPointerException.class)
  public void testNewIncompleteWithNoKind() {
    new KeyFactory(DATASET).build();
  }

  private void verifyKey(Key key, String name, String namespace, PathElement... ancestors) {
    assertEquals(name, key.name());
    verifyIncompleteKey(key, namespace, ancestors);
  }

  private void verifyKey(Key key, Long id, String namespace, PathElement... ancestors) {
    assertEquals(id, key.id());
    verifyIncompleteKey(key, namespace, ancestors);
  }

  private void verifyIncompleteKey(IncompleteKey key, String namespace, PathElement... ancestors) {
    assertEquals("k", key.kind());
    assertEquals(DATASET, key.dataset());
    assertEquals(namespace, key.namespace());
    assertEquals(ancestors.length, key.ancestors().size());
    Iterator<PathElement> iter = key.ancestors().iterator();
    for (PathElement ancestor : ancestors) {
      assertEquals(ancestor, iter.next());
    }
  }
}
