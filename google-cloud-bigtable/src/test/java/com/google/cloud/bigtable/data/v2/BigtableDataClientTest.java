/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStub;
import com.google.cloud.bigtable.data.v2.wrappers.Query;
import com.google.cloud.bigtable.data.v2.wrappers.Row;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BigtableDataClientTest {
  @Mock private EnhancedBigtableStub mockStub;
  @Mock private ServerStreamingCallable<Query, Row> mockReadRowsCallable;

  private BigtableDataClient bigtableDataClient;

  @Before
  public void setUp() {
    Mockito.when(mockStub.readRowsCallable()).thenReturn(mockReadRowsCallable);
    bigtableDataClient = new BigtableDataClient(mockStub);
  }

  @Test
  public void proxyCloseTest() throws Exception {
    bigtableDataClient.close();
    Mockito.verify(mockStub).close();
  }

  @Test
  public void proxyReadRowsCallableTest() {
    assertThat(bigtableDataClient.readRowsCallable()).isSameAs(mockReadRowsCallable);
  }

  @Test
  public void proxyReadRowsSyncTest() {
    Query query = Query.create("fake-table");
    bigtableDataClient.readRows(query);

    Mockito.verify(mockReadRowsCallable).call(query);
  }

  @Test
  public void proxyReadRowsAsyncTest() {
    Query query = Query.create("fake-table");
    @SuppressWarnings("unchecked")
    ResponseObserver<Row> mockObserver = Mockito.mock(ResponseObserver.class);
    bigtableDataClient.readRowsAsync(query, mockObserver);

    Mockito.verify(mockReadRowsCallable).call(query, mockObserver);
  }
}
