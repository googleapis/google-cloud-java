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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.gcloud.datastore.spi.DatastoreRpc;
import com.google.gcloud.datastore.spi.DatastoreRpcFactory;
import com.google.gcloud.datastore.testing.LocalGcdHelper;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class DatastoreOptionsTest {

  private static final String PROJECT_ID = "project_id";
  private static final int PORT = LocalGcdHelper.findAvailablePort(LocalGcdHelper.DEFAULT_PORT);
  private DatastoreRpcFactory datastoreRpcFactory;
  private DatastoreRpc datastoreRpc;
  private DatastoreOptions.Builder options;

  @Before
  public void setUp() {
    datastoreRpcFactory = EasyMock.createMock(DatastoreRpcFactory.class);
    datastoreRpc = EasyMock.createMock(DatastoreRpc.class);
    options = DatastoreOptions.builder()
        .normalizeDataset(false)
        .serviceRpcFactory(datastoreRpcFactory)
        .projectId(PROJECT_ID)
        .host("http://localhost:" + PORT);
    EasyMock.expect(datastoreRpcFactory.create(EasyMock.anyObject(DatastoreOptions.class)))
        .andReturn(datastoreRpc)
        .anyTimes();
    EasyMock.replay(datastoreRpcFactory, datastoreRpc);
  }

  @Test
  public void testProjectId() throws Exception {
    assertEquals(PROJECT_ID, options.build().projectId());
  }

  @Test
  public void testHost() throws Exception {
    assertEquals("http://localhost:" + PORT, options.build().host());
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
    assertSame(datastoreRpc, options.build().rpc());
  }

  @Test
  public void testToBuilder() throws Exception {
    DatastoreOptions original = options.namespace("ns1").force(true).build();
    DatastoreOptions copy = original.toBuilder().build();
    assertEquals(original.projectId(), copy.projectId());
    assertEquals(original.namespace(), copy.namespace());
    assertEquals(original.host(), copy.host());
    assertEquals(original.force(), copy.force());
    assertEquals(original.retryParams(), copy.retryParams());
    assertEquals(original.authCredentials(), copy.authCredentials());
  }
}
