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
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.gcloud.spi.DatastoreRpc;
import com.google.gcloud.spi.DatastoreRpcFactory;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class DatastoreServiceOptionsTest {

  private static final String DATASET = "dataset";
  private DatastoreRpcFactory datastoreRpcFactory;
  private DatastoreRpc datastoreRpc;
  private DatastoreServiceOptions.Builder options;

  @Before
  public void setUp() throws IOException, InterruptedException {
    datastoreRpcFactory = EasyMock.createMock(DatastoreRpcFactory.class);
    datastoreRpc = EasyMock.createMock(DatastoreRpc.class);
    options = DatastoreServiceOptions.builder()
        .normalizeDataset(false)
        .serviceRpcFactory(datastoreRpcFactory)
        .dataset(DATASET)
        .host("http://localhost:" + LocalGcdHelper.PORT);
    EasyMock.expect(datastoreRpcFactory.create(EasyMock.anyObject(DatastoreServiceOptions.class)))
        .andReturn(datastoreRpc)
        .anyTimes();
    EasyMock.replay(datastoreRpcFactory, datastoreRpc);
  }

  @Test
  public void testDataset() throws Exception {
    assertEquals(DATASET, options.build().dataset());
  }

  @Test
  public void testHost() throws Exception {
    assertEquals("http://localhost:" + LocalGcdHelper.PORT, options.build().host());
  }

  @Test
  public void testNamespace() throws Exception {
    assertNull(options.build().namespace());
    assertEquals("ns1", options.namespace("ns1").build().namespace());
  }

  @Test
  public void testForce() throws Exception {
    assertFalse(options.build().force());
    assertTrue(options.force(true).build().force());
  }

  @Test
  public void testDatastore() throws Exception {
    assertSame(datastoreRpcFactory, options.build().serviceRpcFactory());
    assertSame(datastoreRpc, options.build().datastoreRpc());
  }

  @Test
  public void testToBuilder() throws Exception {
    DatastoreServiceOptions original = options.namespace("ns1").force(true).build();
    DatastoreServiceOptions copy = original.toBuilder().build();
    assertEquals(original.dataset(), copy.dataset());
    assertEquals(original.namespace(), copy.namespace());
    assertEquals(original.host(), copy.host());
    assertEquals(original.force(), copy.force());
    assertEquals(original.retryParams(), copy.retryParams());
    assertEquals(original.authCredentials(), copy.authCredentials());
  }
}
