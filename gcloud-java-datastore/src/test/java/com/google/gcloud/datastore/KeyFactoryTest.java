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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class KeyFactoryTest {

  private static final String PROJECT_ID = "projectid";

  private KeyFactory keyFactory;

  @Before
  public void setUp() {
    keyFactory = new KeyFactory(PROJECT_ID).kind("k");
  }

  @Test
  public void testReset() {
    IncompleteKey key =
        keyFactory.projectId("ds1").namespace("ns1").ancestors(PathElement.of("p", 1)).build();
    assertEquals("k", key.kind());
    assertEquals("ds1", key.projectId());
    assertEquals("ns1", key.namespace());
    assertEquals(1, key.ancestors().size());

    keyFactory.reset();
    try {
      keyFactory.newKey(1);
    } catch (NullPointerException ex) {
      assertEquals("kind must not be null", ex.getMessage());
    }
    keyFactory.kind("k1");
    key = keyFactory.newKey();
    assertEquals("k1", key.kind());
    assertEquals(PROJECT_ID, key.projectId());
    assertNull(key.namespace());
    assertTrue(key.ancestors().isEmpty());

    keyFactory = new KeyFactory(PROJECT_ID, "ns1").kind("k");
    key = keyFactory.newKey();
    assertEquals(PROJECT_ID, key.projectId());
    assertEquals("ns1", key.namespace());
    key = keyFactory.projectId("bla1").namespace("bla2").build();
    assertEquals("bla1", key.projectId());
    assertEquals("bla2", key.namespace());
    keyFactory.reset().kind("kind");
    key = keyFactory.newKey();
    assertEquals(PROJECT_ID, key.projectId());
    assertEquals("ns1", key.namespace());
    assertEquals("kind", key.kind());
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
    new KeyFactory(PROJECT_ID).build();
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
    assertEquals(PROJECT_ID, key.projectId());
    assertEquals(namespace, key.namespace());
    assertEquals(ancestors.length, key.ancestors().size());
    Iterator<PathElement> iter = key.ancestors().iterator();
    for (PathElement ancestor : ancestors) {
      assertEquals(ancestor, iter.next());
    }
  }
}
