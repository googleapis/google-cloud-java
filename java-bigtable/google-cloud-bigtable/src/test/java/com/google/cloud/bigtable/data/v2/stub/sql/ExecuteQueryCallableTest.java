/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.sql;

import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.columnMetadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.metadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringValue;
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.bigtable.data.v2.internal.ProtoResultSetMetadata;
import com.google.cloud.bigtable.data.v2.internal.ProtoSqlRow;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.internal.SqlRow;
import com.google.cloud.bigtable.data.v2.models.sql.Statement;
import com.google.cloud.bigtable.gaxx.testing.FakeStreamingApi.ServerStreamingStashCallable;
import java.util.Collections;
import java.util.Iterator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ExecuteQueryCallableTest {

  private static final RequestContext REQUEST_CONTEXT =
      RequestContext.create("fake-project", "fake-instance", "fake-profile");

  @Test
  public void testCallContextAndServerStreamSetup() {
    SqlRow row =
        ProtoSqlRow.create(
            ProtoResultSetMetadata.fromProto(
                metadata(columnMetadata("test", stringType())).getMetadata()),
            Collections.singletonList(stringValue("foo")));
    ServerStreamingStashCallable<ExecuteQueryCallContext, SqlRow> innerCallable =
        new ServerStreamingStashCallable<>(Collections.singletonList(row));
    ExecuteQueryCallable callable = new ExecuteQueryCallable(innerCallable, REQUEST_CONTEXT);
    SqlServerStream stream = callable.call(Statement.of("SELECT * FROM table"));

    assertThat(stream.metadataFuture())
        .isEqualTo(innerCallable.getActualRequest().resultSetMetadataFuture());
    Iterator<SqlRow> responseIterator = stream.rows().iterator();
    assertThat(responseIterator.next()).isEqualTo(row);
    assertThat(responseIterator.hasNext()).isFalse();
  }
}
