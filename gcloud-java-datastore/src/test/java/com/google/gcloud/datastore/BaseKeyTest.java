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

import com.google.common.collect.ImmutableList;
import com.google.protobuf.InvalidProtocolBufferException;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BaseKeyTest {

  private class Builder extends BaseKey.Builder<Builder> {

    Builder(String projectId) {
      super(projectId);
    }

    Builder(String projectId, String kind) {
      super(projectId, kind);
    }

    @Override
    protected BaseKey build() {
      ImmutableList.Builder<PathElement> path = ImmutableList.builder();
      path.addAll(ancestors);
      path.add(PathElement.of(kind));
      return new BaseKey(projectId, namespace, path.build()) {
        @Override
        protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
          return null;
        }
      };
    }
  }

  @Test
  public void testDataset() throws Exception {
    Builder builder = new Builder("ds1", "k");
    BaseKey key = builder.build();
    assertEquals("ds1", key.projectId());
    key = builder.projectId("ds2").build();
    assertEquals("ds2", key.projectId());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadDatasetInConstructor() throws Exception {
    new Builder(" ", "k");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadDatasetInSetter() throws Exception {
    Builder builder = new Builder("d", "k");
    builder.projectId(" ");
  }

  @Test
  public void testNamespace() throws Exception {
    Builder builder = new Builder("ds", "k");
    BaseKey key = builder.build();
    assertNull(key.namespace());
    key = builder.namespace("ns").build();
    assertEquals("ns", key.namespace());
  }

  @Test
  public void testKind() throws Exception {
    Builder builder = new Builder("ds", "k1");
    BaseKey key = builder.build();
    assertEquals("k1", key.kind());
    key = builder.kind("k2").build();
    assertEquals("k2", key.kind());
  }

  @Test(expected = NullPointerException.class)
  public void testNoKind() throws Exception {
    Builder builder = new Builder("ds");
    builder.build();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadKindInConstructor() throws Exception {
    new Builder("ds", "");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadKindInSetter() throws Exception {
    Builder builder = new Builder("ds", "k1");
    builder.kind("");
  }

  @Test
  public void testAncestors() throws Exception {
    Builder builder = new Builder("ds", "k");
    BaseKey key = builder.build();
    assertTrue(key.ancestors().isEmpty());
    List<PathElement> path = new ArrayList<>();
    path.add(PathElement.of("p1","v1"));
    key = builder.ancestors(path.get(0)).build();
    assertEquals(path, key.ancestors());
    path.add(PathElement.of("p2","v2"));
    key = builder.ancestors(path.get(1)).build();
    assertEquals(path, key.ancestors());
  }
}
