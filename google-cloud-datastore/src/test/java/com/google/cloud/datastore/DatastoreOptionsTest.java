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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.cloud.datastore.spi.DatastoreRpc;
import com.google.cloud.datastore.spi.DatastoreRpcFactory;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class DatastoreOptionsTest {

  private static final String PROJECT_ID = "project-id";
  private static final int PORT = 8080;
  private DatastoreRpcFactory datastoreRpcFactory;
  private DatastoreRpc datastoreRpc;
  private DatastoreOptions.Builder options;

  @Before
  public void setUp() {
    datastoreRpcFactory = EasyMock.createMock(DatastoreRpcFactory.class);
    datastoreRpc = EasyMock.createMock(DatastoreRpc.class);
    options = DatastoreOptions.newBuilder()
        .setServiceRpcFactory(datastoreRpcFactory)
        .setProjectId(PROJECT_ID)
        .setHost("http://localhost:" + PORT);
    EasyMock.expect(datastoreRpcFactory.create(EasyMock.anyObject(DatastoreOptions.class)))
        .andReturn(datastoreRpc)
        .anyTimes();
    EasyMock.replay(datastoreRpcFactory, datastoreRpc);
  }

  @Test
  public void testProjectId() throws Exception {
    assertEquals(PROJECT_ID, options.build().getProjectId());
  }

  @Test
  public void testHost() throws Exception {
    assertEquals("http://localhost:" + PORT, options.build().getHost());
  }

  @Test
  public void testNamespace() throws Exception {
    assertTrue(options.build().getNamespace().isEmpty());
    assertEquals("ns1", options.setNamespace("ns1").build().getNamespace());
  }

  @Test
  public void testDatastore() throws Exception {
    assertSame(datastoreRpc, options.build().getRpc());
  }

  @Test
  public void testToBuilder() throws Exception {
    DatastoreOptions original = options.setNamespace("ns1").build();
    DatastoreOptions copy = original.toBuilder().build();
    assertEquals(original.getProjectId(), copy.getProjectId());
    assertEquals(original.getNamespace(), copy.getNamespace());
    assertEquals(original.getHost(), copy.getHost());
    assertEquals(original.getRetryParams(), copy.getRetryParams());
    assertEquals(original.getCredentials(), copy.getCredentials());
  }
}
