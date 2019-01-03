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
package com.google.cloud.bigtable.data.v2.stub.readrows;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.common.truth.Truth;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

@RunWith(JUnit4.class)
public class ReadRowsFirstCallableTest {
  private static final RequestContext REQUEST_CONTEXT =
      RequestContext.create("fake-project", "fake-instance", "fake-profile");
  private UnaryCallable<Query, Row> innerCallable;
  private ArgumentCaptor<Query> innerQuery;
  private SettableApiFuture<Row> innerResult;

  @SuppressWarnings("unchecked")
  @Before
  public void setUp() {
    innerCallable = Mockito.mock(UnaryCallable.class);
    innerQuery = ArgumentCaptor.forClass(Query.class);
    innerResult = SettableApiFuture.create();
    Mockito.when(innerCallable.futureCall(innerQuery.capture(), Mockito.any(ApiCallContext.class)))
        .thenReturn(innerResult);
  }

  @Test
  public void testLimitAdded() {
    ReadRowsFirstCallable<Row> callable = new ReadRowsFirstCallable<>(innerCallable);
    innerResult.set(null);
    callable.call(Query.create("fake-table"));

    Truth.assertThat(innerQuery.getValue().toProto(REQUEST_CONTEXT))
        .isEqualTo(Query.create("fake-table").limit(1).toProto(REQUEST_CONTEXT));
  }

  @Test
  public void testLimitChanged() {
    ReadRowsFirstCallable<Row> callable = new ReadRowsFirstCallable<>(innerCallable);
    innerResult.set(null);
    callable.call(Query.create("fake-table").limit(1_000));

    Truth.assertThat(innerQuery.getValue().toProto(REQUEST_CONTEXT))
        .isEqualTo(Query.create("fake-table").limit(1).toProto(REQUEST_CONTEXT));
  }
}
