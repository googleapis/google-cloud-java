/*
 * Copyright 2025 Google LLC
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
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.int64Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.metadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.preparedStatement;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringType;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.core.SettableApiFuture;
import com.google.cloud.bigtable.data.v2.internal.SqlRow;
import com.google.cloud.bigtable.data.v2.models.sql.PreparedStatement;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSetMetadata;
import com.google.cloud.bigtable.data.v2.stub.sql.MetadataErrorHandlingCallable.MetadataErrorHandlingObserver;
import com.google.cloud.bigtable.gaxx.testing.MockStreamingApi.MockResponseObserver;
import com.google.cloud.bigtable.gaxx.testing.MockStreamingApi.MockServerStreamingCall;
import com.google.cloud.bigtable.gaxx.testing.MockStreamingApi.MockServerStreamingCallable;
import com.google.cloud.bigtable.gaxx.testing.MockStreamingApi.MockStreamController;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MetadataErrorHandlingCallableTest {
  private ExecuteQueryCallContext callContext;
  private MockResponseObserver<SqlRow> outerObserver;
  private SettableApiFuture<ResultSetMetadata> metadataFuture;
  private MetadataErrorHandlingCallable.MetadataErrorHandlingObserver observer;

  @Before
  public void setUp() {
    metadataFuture = SettableApiFuture.create();
    PreparedStatement preparedStatement =
        preparedStatement(
            metadata(columnMetadata("foo", stringType()), columnMetadata("bar", int64Type())));

    callContext = SqlProtoFactory.callContext(preparedStatement.bind().build(), metadataFuture);
    outerObserver = new MockResponseObserver<>(true);
    observer = new MetadataErrorHandlingObserver(outerObserver, callContext);
  }

  // cancel will manifest as an onError call so these are testing both cancellation and
  // other exceptions
  @Test
  public void observer_passesThroughErrorAndSetsMetadataException() {
    MockServerStreamingCallable<ExecuteQueryCallContext, SqlRow> innerCallable =
        new MockServerStreamingCallable<>();
    innerCallable.call(callContext, observer);
    MockServerStreamingCall<ExecuteQueryCallContext, SqlRow> lastCall = innerCallable.popLastCall();
    MockStreamController<SqlRow> innerController = lastCall.getController();

    innerController.getObserver().onError(new CancellationException("Cancelled"));

    assertThat(metadataFuture.isDone()).isTrue();
    assertThrows(ExecutionException.class, metadataFuture::get);
    ExecutionException e = assertThrows(ExecutionException.class, metadataFuture::get);
    assertThat(e.getCause()).isInstanceOf(CancellationException.class);
    assertThat(outerObserver.isDone()).isTrue();
    assertThat(outerObserver.getFinalError()).isInstanceOf(CancellationException.class);
  }
}
