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
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;

public class KeyFactoryTest {

  private static final String PROJECT_ID = "projectid";

  private KeyFactory keyFactory;
  private KeyFactory deprecatedKeyFactory;

  @Before
  public void setUp() {
    keyFactory = new KeyFactory(PROJECT_ID).setKind("k");
  }

  @Test
  public void testReset() {
    IncompleteKey key =
        keyFactory
            .setProjectId("ds1")
            .setNamespace("ns1")
            .addAncestor(PathElement.of("p", 1))
            .build();
    assertEquals("k", key.getKind());
    assertEquals("ds1", key.getProjectId());
    assertEquals("ns1", key.getNamespace());
    assertEquals(1, key.getAncestors().size());

    keyFactory.reset();
    try {
      keyFactory.newKey(1);
    } catch (NullPointerException ex) {
      assertEquals("kind must not be null", ex.getMessage());
    }
    keyFactory.setKind("k1");
    key = keyFactory.newKey();
    assertEquals("k1", key.getKind());
    assertEquals(PROJECT_ID, key.getProjectId());
    assertTrue(key.getNamespace().isEmpty());
    assertTrue(key.getAncestors().isEmpty());

    keyFactory = new KeyFactory(PROJECT_ID, "ns1").setKind("k");
    key = keyFactory.newKey();
    assertEquals(PROJECT_ID, key.getProjectId());
    assertEquals("ns1", key.getNamespace());
    key = keyFactory.setProjectId("bla1").setNamespace("bla2").build();
    assertEquals("bla1", key.getProjectId());
    assertEquals("bla2", key.getNamespace());
    keyFactory.reset().setKind("kind");
    key = keyFactory.newKey();
    assertEquals(PROJECT_ID, key.getProjectId());
    assertEquals("ns1", key.getNamespace());
    assertEquals("kind", key.getKind());
  }

  @Test
  public void testNewKey() throws Exception {
    Key key = keyFactory.newKey(1);
    verifyKey(key, 1L, "");
    key = keyFactory.newKey("n");
    verifyKey(key, "n", "");
    PathElement p1 = PathElement.of("k1", "n");
    PathElement p2 = PathElement.of("k2", 10);
    key = keyFactory.setNamespace("ns").addAncestors(p1, p2).newKey("k3");
    verifyKey(key, "k3", "ns", p1, p2);
  }

  @Test
  public void testNewIncompleteKey() throws Exception {
    IncompleteKey key = keyFactory.newKey();
    verifyIncompleteKey(key, "");
    PathElement p1 = PathElement.of("k1", "n");
    PathElement p2 = PathElement.of("k2", 10);
    key = keyFactory.setNamespace("ns").addAncestors(p1, p2).newKey();
    verifyIncompleteKey(key, "ns", p1, p2);
  }

  @Test(expected = NullPointerException.class)
  public void testNewIncompleteWithNoKind() {
    new KeyFactory(PROJECT_ID).build();
  }

  private void verifyKey(Key key, String name, String namespace, PathElement... ancestors) {
    assertEquals(name, key.getName());
    verifyIncompleteKey(key, namespace, ancestors);
  }

  private void verifyKey(Key key, Long id, String namespace, PathElement... ancestors) {
    assertEquals(id, key.getId());
    verifyIncompleteKey(key, namespace, ancestors);
  }

  private void verifyIncompleteKey(IncompleteKey key, String namespace, PathElement... ancestors) {
    assertEquals("k", key.getKind());
    assertEquals(PROJECT_ID, key.getProjectId());
    assertEquals(namespace, key.getNamespace());
    assertEquals(ancestors.length, key.getAncestors().size());
    Iterator<PathElement> iter = key.getAncestors().iterator();
    for (PathElement ancestor : ancestors) {
      assertEquals(ancestor, iter.next());
    }
  }
}
