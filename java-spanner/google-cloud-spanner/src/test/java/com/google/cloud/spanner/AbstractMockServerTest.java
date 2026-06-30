/*
 * Copyright 2023 Google LLC
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

import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.admin.database.v1.MockDatabaseAdminImpl;
import com.google.cloud.spanner.admin.instance.v1.MockInstanceAdminImpl;
import com.google.longrunning.GetOperationRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsGrpc.OperationsImplBase;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.rpc.Code;
import com.google.rpc.Status;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import io.grpc.Server;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

abstract class AbstractMockServerTest {
  protected static MockSpannerServiceImpl mockSpanner;
  public static MockInstanceAdminImpl mockInstanceAdmin;
  public static MockDatabaseAdminImpl mockDatabaseAdmin;
  public static OperationsImplBase mockOperations;
  protected static Server server;
  protected static LocalChannelProvider channelProvider;

  protected Spanner spanner;

  @BeforeClass
  public static void startMockServer() throws Exception {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D); // We don't want any unpredictable aborted transactions.
    mockInstanceAdmin = new MockInstanceAdminImpl();
    mockDatabaseAdmin = new MockDatabaseAdminImpl();
    mockOperations =
        new OperationsImplBase() {
          AtomicBoolean done = new AtomicBoolean(false);

          @Override
          public void getOperation(
              GetOperationRequest request,
              StreamObserver<com.google.longrunning.Operation> responseObserver) {
            responseObserver.onNext(
                Operation.newBuilder()
                    .setDone(done.getAndSet(!done.get()))
                    .setName(request.getName())
                    .setMetadata(
                        Any.pack(
                            UpdateDatabaseDdlMetadata.newBuilder()
                                .setDatabase("projects/proj/instances/inst/databases/db")
                                .build()))
                    .setResponse(Any.pack(Empty.getDefaultInstance()))
                    .build());
            responseObserver.onCompleted();
          }
        };

    String uniqueName = InProcessServerBuilder.generateName();
    server =
        InProcessServerBuilder.forName(uniqueName)
            .addService(mockSpanner)
            .addService(mockInstanceAdmin)
            .addService(mockDatabaseAdmin)
            .addService(mockOperations)
            .build()
            .start();
    channelProvider = LocalChannelProvider.create(uniqueName);
  }

  @AfterClass
  public static void stopMockServer() throws InterruptedException {
    server.shutdown();
    server.awaitTermination();
  }

  @Before
  public void createSpannerInstance() {
    spanner =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance())
            .setSessionPoolOption(SessionPoolOptions.newBuilder().setFailOnSessionLeak().build())
            .build()
            .getService();
  }

  @After
  public void cleanup() {
    spanner.close();
    mockSpanner.reset();
    mockSpanner.removeAllExecutionTimes();
  }

  void addUpdateDdlResponse() {
    mockDatabaseAdmin.addResponse(
        Operation.newBuilder()
            .setMetadata(
                Any.pack(
                    UpdateDatabaseDdlMetadata.newBuilder()
                        .setDatabase("projects/proj/instances/inst/databases/db")
                        .build()))
            .setName("projects/proj/instances/inst/databases/db/operations/1")
            .setDone(false)
            .setResponse(Any.pack(Empty.getDefaultInstance()))
            .build());
  }

  void addUpdateDdlError() {
    mockDatabaseAdmin.addResponse(
        Operation.newBuilder()
            .setMetadata(
                Any.pack(
                    UpdateDatabaseDdlMetadata.newBuilder()
                        .setDatabase("projects/proj/instances/inst/databases/db")
                        .build()))
            .setName("projects/proj/instances/inst/databases/db/operations/1")
            .setDone(true)
            .setResponse(Any.pack(Empty.getDefaultInstance()))
            .setError(
                Status.newBuilder()
                    .setCode(Code.FAILED_PRECONDITION_VALUE)
                    .setMessage("test error")
                    .build())
            .build());
  }
}
