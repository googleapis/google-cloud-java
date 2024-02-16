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
package com.google.cloud.bigtable.data.v2.stub.metrics;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

import com.google.api.gax.core.FixedExecutorProvider;
import com.google.api.gax.grpc.ChannelPoolSettings;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.bigtable.v2.*;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.FakeServiceBuilder;
import com.google.cloud.bigtable.data.v2.models.*;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStub;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStubSettings;
import com.google.cloud.bigtable.stats.StatsRecorderWrapperForConnection;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

@RunWith(JUnit4.class)
public class ErrorCountPerConnectionTest {
  private static final String SUCCESS_TABLE_NAME = "some-table";
  private static final String ERROR_TABLE_NAME = "nonexistent-table";
  private Server server;
  private final FakeService fakeService = new FakeService();
  private EnhancedBigtableStubSettings.Builder builder;
  private ArgumentCaptor<Runnable> runnableCaptor;
  private StatsRecorderWrapperForConnection statsRecorderWrapperForConnection;

  @Before
  public void setup() throws Exception {
    server = FakeServiceBuilder.create(fakeService).start();

    ScheduledExecutorService executors = Mockito.mock(ScheduledExecutorService.class);
    builder =
        BigtableDataSettings.newBuilderForEmulator(server.getPort())
            .stubSettings()
            .setBackgroundExecutorProvider(FixedExecutorProvider.create(executors))
            .setProjectId("fake-project")
            .setInstanceId("fake-instance");
    runnableCaptor = ArgumentCaptor.forClass(Runnable.class);
    Mockito.when(
            executors.scheduleAtFixedRate(runnableCaptor.capture(), anyLong(), anyLong(), any()))
        .thenReturn(null);

    statsRecorderWrapperForConnection = Mockito.mock(StatsRecorderWrapperForConnection.class);
  }

  @After
  public void tearDown() throws Exception {
    if (server != null) {
      server.shutdown();
    }
  }

  @Test
  public void readWithOneChannel() throws Exception {
    EnhancedBigtableStub stub = EnhancedBigtableStub.create(builder.build());
    long errorCount = 0;

    for (int i = 0; i < 20; i++) {
      Query query;
      if (i % 3 == 0) {
        query = Query.create(ERROR_TABLE_NAME);
        errorCount += 1;
      } else {
        query = Query.create(SUCCESS_TABLE_NAME);
      }
      try {
        stub.readRowsCallable().call(query).iterator().hasNext();
      } catch (Exception e) {
        // noop
      }
    }
    ArgumentCaptor<Long> errorCountCaptor = ArgumentCaptor.forClass(long.class);
    Mockito.doNothing()
        .when(statsRecorderWrapperForConnection)
        .putAndRecordPerConnectionErrorCount(errorCountCaptor.capture());
    runInterceptorTasksAndAssertCount();
    List<Long> allErrorCounts = errorCountCaptor.getAllValues();
    assertThat(allErrorCounts.size()).isEqualTo(1);
    assertThat(allErrorCounts.get(0)).isEqualTo(errorCount);
  }

  @Test
  public void readWithTwoChannels() throws Exception {
    EnhancedBigtableStubSettings.Builder builderWithTwoChannels =
        builder.setTransportChannelProvider(
            ((InstantiatingGrpcChannelProvider) builder.getTransportChannelProvider())
                .toBuilder()
                .setChannelPoolSettings(ChannelPoolSettings.staticallySized(2))
                .build());
    EnhancedBigtableStub stub = EnhancedBigtableStub.create(builderWithTwoChannels.build());
    long totalErrorCount = 0;

    for (int i = 0; i < 20; i++) {
      try {
        if (i < 10) {
          totalErrorCount += 1;
          stub.readRowsCallable().call(Query.create(ERROR_TABLE_NAME)).iterator().hasNext();
        } else {
          stub.readRowsCallable().call(Query.create(SUCCESS_TABLE_NAME)).iterator().hasNext();
        }
      } catch (Exception e) {
        // noop
      }
    }
    ArgumentCaptor<Long> errorCountCaptor = ArgumentCaptor.forClass(long.class);
    Mockito.doNothing()
        .when(statsRecorderWrapperForConnection)
        .putAndRecordPerConnectionErrorCount(errorCountCaptor.capture());
    runInterceptorTasksAndAssertCount();

    List<Long> allErrorCounts = errorCountCaptor.getAllValues();
    assertThat(allErrorCounts.size()).isEqualTo(2);
    // Requests get assigned to channels using a Round Robin algorithm, so half to each.
    assertThat(allErrorCounts).containsExactly(totalErrorCount / 2, totalErrorCount / 2);
  }

  @Test
  public void readOverTwoPeriods() throws Exception {
    EnhancedBigtableStub stub = EnhancedBigtableStub.create(builder.build());
    long errorCount = 0;

    for (int i = 0; i < 20; i++) {
      Query query;
      if (i % 3 == 0) {
        query = Query.create(ERROR_TABLE_NAME);
        errorCount += 1;
      } else {
        query = Query.create(SUCCESS_TABLE_NAME);
      }
      try {
        stub.readRowsCallable().call(query).iterator().hasNext();
      } catch (Exception e) {
        // noop
      }
    }
    ArgumentCaptor<Long> errorCountCaptor = ArgumentCaptor.forClass(long.class);
    Mockito.doNothing()
        .when(statsRecorderWrapperForConnection)
        .putAndRecordPerConnectionErrorCount(errorCountCaptor.capture());
    runInterceptorTasksAndAssertCount();
    List<Long> allErrorCounts = errorCountCaptor.getAllValues();
    assertThat(allErrorCounts.size()).isEqualTo(1);
    assertThat(allErrorCounts.get(0)).isEqualTo(errorCount);

    errorCount = 0;

    for (int i = 0; i < 20; i++) {
      Query query;
      if (i % 3 == 0) {
        query = Query.create(SUCCESS_TABLE_NAME);
      } else {
        query = Query.create(ERROR_TABLE_NAME);
        errorCount += 1;
      }
      try {
        stub.readRowsCallable().call(query).iterator().hasNext();
      } catch (Exception e) {
        // noop
      }
    }
    errorCountCaptor = ArgumentCaptor.forClass(long.class);
    Mockito.doNothing()
        .when(statsRecorderWrapperForConnection)
        .putAndRecordPerConnectionErrorCount(errorCountCaptor.capture());
    runInterceptorTasksAndAssertCount();
    allErrorCounts = errorCountCaptor.getAllValues();
    assertThat(allErrorCounts.size()).isEqualTo(1);
    assertThat(allErrorCounts.get(0)).isEqualTo(errorCount);
  }

  @Test
  public void ignoreInactiveConnection() throws Exception {
    EnhancedBigtableStub stub = EnhancedBigtableStub.create(builder.build());

    ArgumentCaptor<Long> errorCountCaptor = ArgumentCaptor.forClass(long.class);
    Mockito.doNothing()
        .when(statsRecorderWrapperForConnection)
        .putAndRecordPerConnectionErrorCount(errorCountCaptor.capture());
    runInterceptorTasksAndAssertCount();
    List<Long> allErrorCounts = errorCountCaptor.getAllValues();
    assertThat(allErrorCounts).isEmpty();
  }

  @Test
  public void noFailedRequests() throws Exception {
    EnhancedBigtableStub stub = EnhancedBigtableStub.create(builder.build());

    for (int i = 0; i < 20; i++) {
      try {
        stub.readRowsCallable().call(Query.create(SUCCESS_TABLE_NAME)).iterator().hasNext();
      } catch (Exception e) {
        // noop
      }
    }
    ArgumentCaptor<Long> errorCountCaptor = ArgumentCaptor.forClass(long.class);
    Mockito.doNothing()
        .when(statsRecorderWrapperForConnection)
        .putAndRecordPerConnectionErrorCount(errorCountCaptor.capture());
    runInterceptorTasksAndAssertCount();
    List<Long> allErrorCounts = errorCountCaptor.getAllValues();
    assertThat(allErrorCounts.size()).isEqualTo(1);
    assertThat(allErrorCounts.get(0)).isEqualTo(0);
  }

  private void runInterceptorTasksAndAssertCount() {
    int actualNumOfTasks = 0;
    for (Runnable runnable : runnableCaptor.getAllValues()) {
      if (runnable instanceof ErrorCountPerConnectionMetricTracker) {
        ((ErrorCountPerConnectionMetricTracker) runnable)
            .setStatsRecorderWrapperForConnection(statsRecorderWrapperForConnection);
        runnable.run();
        actualNumOfTasks++;
      }
    }
    assertThat(actualNumOfTasks).isEqualTo(1);
  }

  static class FakeService extends BigtableGrpc.BigtableImplBase {
    @Override
    public void readRows(
        ReadRowsRequest request, StreamObserver<ReadRowsResponse> responseObserver) {
      if (request.getTableName().contains(SUCCESS_TABLE_NAME)) {
        responseObserver.onNext(ReadRowsResponse.getDefaultInstance());
        responseObserver.onCompleted();
      } else {
        // Send a non-retriable error, since otherwise the client tries to use the mocked
        // ScheduledExecutorService object for retyring, resulting in a hang.
        StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
        responseObserver.onError(exception);
      }
    }
  }
}
