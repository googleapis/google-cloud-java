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
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.partialResultSetWithToken;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.partialResultSetWithoutToken;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.prepareResponse;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringValue;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.ExecuteQueryRequest;
import com.google.bigtable.v2.ExecuteQueryResponse;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.FakeServiceBuilder;
import com.google.cloud.bigtable.data.v2.internal.PrepareResponse;
import com.google.cloud.bigtable.data.v2.internal.PreparedStatementImpl;
import com.google.cloud.bigtable.data.v2.internal.ProtoResultSetMetadata;
import com.google.cloud.bigtable.data.v2.internal.ProtoSqlRow;
import com.google.cloud.bigtable.data.v2.internal.SqlRow;
import com.google.cloud.bigtable.data.v2.models.sql.PreparedStatement;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStub;
import com.google.cloud.bigtable.gaxx.testing.FakeStreamingApi.ServerStreamingStashCallable;
import io.grpc.Context;
import io.grpc.Deadline;
import io.grpc.Server;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ExecuteQueryCallableTest {

  private static final class FakePreparedStatement extends PreparedStatementImpl {

    public FakePreparedStatement() {
      super(
          PrepareResponse.fromProto(prepareResponse(metadata(columnMetadata("foo", stringType())))),
          new HashMap<>(),
          null,
          null);
    }

    @Override
    public PreparedQueryData markExpiredAndStartRefresh(
        PreparedQueryVersion expiredPreparedQueryVersion) {
      return getLatestPrepareResponse();
    }

    @Override
    public void assertUsingSameStub(EnhancedBigtableStub stub) {}
  }

  private static final PreparedStatement PREPARED_STATEMENT = new FakePreparedStatement();

  private Server server;
  private FakeService fakeService = new FakeService();
  private EnhancedBigtableStub stub;

  @Before
  public void setup() throws IOException {
    server = FakeServiceBuilder.create(fakeService).start();

    BigtableDataSettings settings =
        BigtableDataSettings.newBuilderForEmulator(server.getPort())
            .setProjectId("fake-project")
            .setInstanceId("fake-instance")
            .build();

    stub = EnhancedBigtableStub.create(settings.getStubSettings());
  }

  @After
  public void tearDown() {
    stub.close();
    server.shutdown();
  }

  @Test
  public void testCallContextAndServerStreamSetup() {
    SqlRow row =
        ProtoSqlRow.create(
            ProtoResultSetMetadata.fromProto(metadata(columnMetadata("test", stringType()))),
            Collections.singletonList(stringValue("foo")));
    ServerStreamingStashCallable<ExecuteQueryCallContext, SqlRow> innerCallable =
        new ServerStreamingStashCallable<>(Collections.singletonList(row));
    ExecuteQueryCallable callable = new ExecuteQueryCallable(innerCallable);
    SqlServerStream stream = callable.call(PREPARED_STATEMENT.bind().build());

    assertThat(stream.metadataFuture())
        .isEqualTo(innerCallable.getActualRequest().resultSetMetadataFuture());
    Iterator<SqlRow> responseIterator = stream.rows().iterator();
    assertThat(responseIterator.next()).isEqualTo(row);
    assertThat(responseIterator.hasNext()).isFalse();
  }

  @Test
  public void testExecuteQueryRequestsSetDefaultDeadline() {
    SqlServerStream stream = stub.executeQueryCallable().call(PREPARED_STATEMENT.bind().build());
    // We don't care about this, just assert we get a response
    boolean rowReceived = false;
    for (SqlRow sqlRow : stream.rows()) {
      rowReceived = true;
    }
    assertThat(rowReceived).isTrue();
    // We have 30m default, we give it a wide range to avoid flakiness, this is mostly just
    // checking that some default is set
    assertThat(fakeService.deadlineMillisRemaining).isLessThan(1800000L);
  }

  @Test
  public void testExecuteQueryRequestsRespectDeadline() throws IOException {
    BigtableDataSettings.Builder overrideSettings =
        BigtableDataSettings.newBuilderForEmulator(server.getPort())
            .setProjectId("fake-project")
            .setInstanceId("fake-instance");
    overrideSettings
        .stubSettings()
        .executeQuerySettings()
        .setRetrySettings(
            RetrySettings.newBuilder()
                .setInitialRpcTimeoutDuration(Duration.ofMillis(10))
                .setMaxRpcTimeoutDuration(Duration.ofMillis(10))
                .build());

    try (EnhancedBigtableStub overrideDeadline =
        EnhancedBigtableStub.create(overrideSettings.build().getStubSettings())) {
      SqlServerStream streamOverride =
          overrideDeadline.executeQueryCallable().call(PREPARED_STATEMENT.bind().build());
      Iterator<SqlRow> overrideIterator = streamOverride.rows().iterator();
      // We don't care about this but are reusing the fake service that tests retries
      assertThrows(DeadlineExceededException.class, overrideIterator::next).getCause();
    }
  }

  private static class FakeService extends BigtableGrpc.BigtableImplBase {

    private long deadlineMillisRemaining;

    @Override
    public void executeQuery(
        ExecuteQueryRequest request, StreamObserver<ExecuteQueryResponse> responseObserver) {
      Deadline deadline = Context.current().getDeadline();
      if (deadline != null) {
        deadlineMillisRemaining = deadline.timeRemaining(TimeUnit.MILLISECONDS);
      } else {
        // set to max long when deadline isn't set
        deadlineMillisRemaining = Long.MAX_VALUE;
      }
      // Sleep for 100ms to trigger deadline exceeded for tests with a shorter deadline
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      responseObserver.onNext(partialResultSetWithoutToken(stringValue("foo")));
      responseObserver.onNext(partialResultSetWithToken(stringValue("bar")));
      responseObserver.onCompleted();
    }
  }
}
