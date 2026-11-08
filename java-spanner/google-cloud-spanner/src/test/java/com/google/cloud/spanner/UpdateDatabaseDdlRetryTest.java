/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.AlreadyExistsException;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.longrunning.GetOperationRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsGrpc.OperationsImplBase;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.spanner.admin.database.v1.DatabaseName;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.StreamObserver;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UpdateDatabaseDdlRetryTest {
  private static final String PROJECT = "test-project";
  private static final String INSTANCE = "test-instance";
  private static final String DATABASE = "test-db";
  private static final DatabaseName DATABASE_NAME = DatabaseName.of(PROJECT, INSTANCE, DATABASE);

  private static Server server;
  private static LocalChannelProvider channelProvider;

  private static final AtomicBoolean dropFirstResponse = new AtomicBoolean(false);
  private static final AtomicBoolean initiallyDone = new AtomicBoolean(true);
  private static final AtomicInteger autoOpSeq = new AtomicInteger(0);
  private static final AtomicInteger getOpCompleteAfterPolls = new AtomicInteger(0);
  private static final Set<String> appliedDdls = ConcurrentHashMap.newKeySet();
  private static final Map<String, Operation> operations = new ConcurrentHashMap<>();
  private static final List<UpdateDatabaseDdlRequest> ddlRequests = new CopyOnWriteArrayList<>();
  private static final List<GetOperationRequest> getOperationRequests =
      new CopyOnWriteArrayList<>();

  private Spanner spanner;

  @BeforeClass
  public static void startServer() throws Exception {
    com.google.spanner.admin.database.v1.DatabaseAdminGrpc.DatabaseAdminImplBase dbAdminService =
        new com.google.spanner.admin.database.v1.DatabaseAdminGrpc.DatabaseAdminImplBase() {
          @Override
          public void updateDatabaseDdl(
              UpdateDatabaseDdlRequest request, StreamObserver<Operation> responseObserver) {
            ddlRequests.add(request);
            String opId = request.getOperationId();
            if (opId.isEmpty()) {
              opId = "_auto_op_" + autoOpSeq.incrementAndGet();
            }
            String opName = request.getDatabase() + "/operations/" + opId;
            if (!request.getOperationId().isEmpty() && operations.containsKey(opName)) {
              responseObserver.onError(
                  Status.ALREADY_EXISTS
                      .withDescription("Operation with name " + opName + " already exists.")
                      .asRuntimeException());
              return;
            }
            for (String stmt : request.getStatementsList()) {
              if (!appliedDdls.add(stmt)) {
                responseObserver.onError(
                    Status.FAILED_PRECONDITION
                        .withDescription("Duplicate column name Venues.Revenue.")
                        .asRuntimeException());
                return;
              }
            }
            Operation op =
                Operation.newBuilder()
                    .setName(opName)
                    .setDone(initiallyDone.get())
                    .setMetadata(
                        Any.pack(
                            UpdateDatabaseDdlMetadata.newBuilder()
                                .setDatabase(request.getDatabase())
                                .addAllStatements(request.getStatementsList())
                                .build()))
                    .setResponse(Any.pack(Empty.getDefaultInstance()))
                    .build();
            operations.put(opName, op);
            if (dropFirstResponse.compareAndSet(true, false)) {
              responseObserver.onError(
                  Status.UNAVAILABLE
                      .withDescription("Simulated dropped response after DDL accepted")
                      .asRuntimeException());
              return;
            }
            responseObserver.onNext(op);
            responseObserver.onCompleted();
          }
        };

    OperationsImplBase opsService =
        new OperationsImplBase() {
          @Override
          public void getOperation(
              GetOperationRequest request, StreamObserver<Operation> responseObserver) {
            getOperationRequests.add(request);
            Operation op = operations.get(request.getName());
            if (op == null) {
              responseObserver.onError(
                  Status.NOT_FOUND
                      .withDescription("Operation not found: " + request.getName())
                      .asRuntimeException());
              return;
            }
            if (!op.getDone() && getOpCompleteAfterPolls.decrementAndGet() <= 0) {
              op = op.toBuilder().setDone(true).build();
              operations.put(request.getName(), op);
            }
            responseObserver.onNext(op);
            responseObserver.onCompleted();
          }
        };

    String uniqueName = InProcessServerBuilder.generateName();
    server =
        InProcessServerBuilder.forName(uniqueName)
            .addService(dbAdminService)
            .addService(opsService)
            .build()
            .start();
    channelProvider = LocalChannelProvider.create(uniqueName);
  }

  @AfterClass
  public static void stopServer() throws InterruptedException {
    if (server != null) {
      server.shutdown();
      server.awaitTermination();
    }
  }

  @Before
  public void setUp() {
    dropFirstResponse.set(false);
    initiallyDone.set(true);
    autoOpSeq.set(0);
    getOpCompleteAfterPolls.set(0);
    appliedDdls.clear();
    operations.clear();
    ddlRequests.clear();
    getOperationRequests.clear();

    SpannerOptions.Builder builder = SpannerOptions.newBuilder();
    builder
        .getDatabaseAdminStubSettingsBuilder()
        .updateDatabaseDdlOperationSettings()
        .setPollingAlgorithm(
            OperationTimedPollAlgorithm.create(
                RetrySettings.newBuilder()
                    .setInitialRpcTimeoutDuration(Duration.ofSeconds(5L))
                    .setInitialRetryDelayDuration(Duration.ofMillis(5L))
                    .setMaxRetryDelayDuration(Duration.ofMillis(20L))
                    .setMaxRpcTimeoutDuration(Duration.ofSeconds(5L))
                    .setMaxAttempts(10)
                    .setTotalTimeoutDuration(Duration.ofSeconds(10L))
                    .setRetryDelayMultiplier(1.0)
                    .setRpcTimeoutMultiplier(1.0)
                    .build()));
    builder
        .getDatabaseAdminStubSettingsBuilder()
        .updateDatabaseDdlOperationSettings()
        .setInitialCallSettings(
            builder
                .getDatabaseAdminStubSettingsBuilder()
                .updateDatabaseDdlOperationSettings()
                .getInitialCallSettings()
                .toBuilder()
                .setRetrySettings(
                    RetrySettings.newBuilder()
                        .setInitialRpcTimeoutDuration(Duration.ofSeconds(5L))
                        .setInitialRetryDelayDuration(Duration.ofMillis(5L))
                        .setMaxRetryDelayDuration(Duration.ofMillis(20L))
                        .setMaxRpcTimeoutDuration(Duration.ofSeconds(5L))
                        .setMaxAttempts(5)
                        .setTotalTimeoutDuration(Duration.ofSeconds(10L))
                        .setRetryDelayMultiplier(1.0)
                        .setRpcTimeoutMultiplier(1.0)
                        .build())
                .build());
    spanner =
        builder
            .setProjectId(PROJECT)
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance())
            .build()
            .getService();
  }

  @After
  public void tearDown() {
    if (spanner != null) {
      spanner.close();
    }
  }

  @Test
  public void updateDatabaseDdlAsync_emptyOperationId_retriesIdempotentlyAfterServerCommit()
      throws Exception {
    dropFirstResponse.set(true);
    try (DatabaseAdminClient client = spanner.createDatabaseAdminClient()) {
      client
          .updateDatabaseDdlAsync(
              DATABASE_NAME,
              Collections.singletonList("ALTER TABLE Venues ADD COLUMN Revenue NUMERIC"))
          .get();
    }

    assertThat(ddlRequests).hasSize(2);
    String firstOpId = ddlRequests.get(0).getOperationId();
    assertThat(firstOpId).matches("[a-z][a-z0-9_]*");
    assertThat(ddlRequests.get(1).getOperationId()).isEqualTo(firstOpId);
    assertThat(getOperationRequests).isNotEmpty();
    assertThat(getOperationRequests.get(0).getName())
        .isEqualTo(DATABASE_NAME + "/operations/" + firstOpId);
  }

  @Test
  public void updateDatabaseDdlAsync_emptyOperationId_setsOperationIdOnSuccess() throws Exception {
    try (DatabaseAdminClient client = spanner.createDatabaseAdminClient()) {
      client
          .updateDatabaseDdlAsync(
              DATABASE_NAME,
              Collections.singletonList("ALTER TABLE Venues ADD COLUMN Revenue NUMERIC"))
          .get();
    }

    assertThat(ddlRequests).hasSize(1);
    assertThat(ddlRequests.get(0).getOperationId()).matches("[a-z][a-z0-9_]*");
  }

  @Test
  public void updateDatabaseDdlAsync_explicitOperationId_stillThrowsAlreadyExists() {
    String explicitOpId = "explicit_op_123";
    String opName = DATABASE_NAME + "/operations/" + explicitOpId;
    operations.put(opName, Operation.newBuilder().setName(opName).setDone(true).build());

    try (DatabaseAdminClient client = spanner.createDatabaseAdminClient()) {
      UpdateDatabaseDdlRequest request =
          UpdateDatabaseDdlRequest.newBuilder()
              .setDatabase(DATABASE_NAME.toString())
              .addStatements("ALTER TABLE Venues ADD COLUMN Revenue NUMERIC")
              .setOperationId(explicitOpId)
              .build();
      ExecutionException ex =
          assertThrows(
              ExecutionException.class, () -> client.updateDatabaseDdlAsync(request).get());
      assertThat(ex).hasCauseThat().isInstanceOf(AlreadyExistsException.class);
    }

    assertThat(ddlRequests).hasSize(1);
    assertThat(ddlRequests.get(0).getOperationId()).isEqualTo(explicitOpId);
    assertThat(getOperationRequests).isEmpty();
  }

  @Test
  public void updateDatabaseDdlAsync_emptyOperationId_resumesAndPollsIncompleteOperation()
      throws Exception {
    dropFirstResponse.set(true);
    initiallyDone.set(false);
    getOpCompleteAfterPolls.set(2);

    try (DatabaseAdminClient client = spanner.createDatabaseAdminClient()) {
      client
          .updateDatabaseDdlAsync(
              DATABASE_NAME,
              Collections.singletonList("ALTER TABLE Venues ADD COLUMN Revenue NUMERIC"))
          .get();
    }

    assertThat(ddlRequests).hasSize(2);
    String firstOpId = ddlRequests.get(0).getOperationId();
    assertThat(firstOpId).isNotEmpty();
    assertThat(ddlRequests.get(1).getOperationId()).isEqualTo(firstOpId);
    assertThat(getOperationRequests.size()).isAtLeast(2);
  }
}
