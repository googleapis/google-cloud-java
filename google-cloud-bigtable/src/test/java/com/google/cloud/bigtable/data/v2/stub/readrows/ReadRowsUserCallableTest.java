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

import com.google.cloud.bigtable.data.v2.models.InstanceName;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.gaxx.testing.FakeStreamingApi.ServerStreamingStashCallable;
import com.google.common.truth.Truth;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ReadRowsUserCallableTest {
  private static final RequestContext REQUEST_CONTEXT =
      RequestContext.create(InstanceName.of("fake-project", "fake-instance"), "fake-profile");

  @Test
  public void testRequestConverted() {
    ServerStreamingStashCallable<ReadRowsRequest, Row> innerCallable =
        new ServerStreamingStashCallable<>();
    ReadRowsUserCallable<Row> callable = new ReadRowsUserCallable<>(innerCallable, REQUEST_CONTEXT);
    Query query = Query.create("fake-table");

    callable.call(query);

    Truth.assertThat(innerCallable.getActualRequest()).isEqualTo(query.toProto(REQUEST_CONTEXT));
  }

  @Test
  public void testFirstIsLimited() {
    ServerStreamingStashCallable<ReadRowsRequest, Row> innerCallable =
        new ServerStreamingStashCallable<>();
    ReadRowsUserCallable<Row> callable = new ReadRowsUserCallable<>(innerCallable, REQUEST_CONTEXT);
    Query query = Query.create("fake-table");

    callable.first().call(query);

    Truth.assertThat(innerCallable.getActualRequest())
        .isEqualTo(query.limit(1).toProto(REQUEST_CONTEXT));
  }
}
