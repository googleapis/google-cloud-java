/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner;

import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.database.v1.CreateDatabaseRequest;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.database.v1.Database.State;
import com.google.spanner.admin.database.v1.DatabaseAdminGrpc.DatabaseAdminImplBase;
import com.google.spanner.admin.database.v1.DropDatabaseRequest;
import com.google.spanner.admin.database.v1.GetDatabaseDdlRequest;
import com.google.spanner.admin.database.v1.GetDatabaseDdlResponse;
import com.google.spanner.admin.database.v1.GetDatabaseRequest;
import com.google.spanner.admin.database.v1.ListDatabasesRequest;
import com.google.spanner.admin.database.v1.ListDatabasesResponse;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest;
import io.grpc.ServerServiceDefinition;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

public class MockDatabaseAdminServiceImpl extends DatabaseAdminImplBase implements MockGrpcService {
  private static final class MockDatabase {
    private final String name;
    private State state;
    private final List<String> ddl = new ArrayList<>();

    private MockDatabase(String name, List<String> ddl) {
      this.name = name;
      this.state = State.CREATING;
      this.ddl.addAll(ddl);
    }

    private Database toProto() {
      return Database.newBuilder().setName(name).setState(state).build();
    }

    @Override
    public boolean equals(Object o) {
      if (!(o instanceof MockDatabase)) {
        return false;
      }
      return ((MockDatabase) o).name.equals(this.name);
    }

    @Override
    public int hashCode() {
      return name.hashCode();
    }
  }

  private final class CreateDatabaseCallable implements Callable<Database> {
    private final String operationName;
    private final String name;

    private CreateDatabaseCallable(String operationName, String name) {
      this.operationName = operationName;
      this.name = name;
    }

    @Override
    public Database call() throws Exception {
      MockDatabase db = databases.get(name);
      db.state = State.READY;
      Database proto = db.toProto();
      Operation operation = operations.get(operationName);
      if (operation != null) {
        operations.update(operation.toBuilder().setDone(true).setResponse(Any.pack(proto)).build());
      }
      return proto;
    }
  }

  private final class UpdateDatabaseDdlCallable implements Callable<Empty> {
    private final String operationName;

    private UpdateDatabaseDdlCallable(String operationName) {
      this.operationName = operationName;
    }

    @Override
    public Empty call() throws Exception {
      Operation operation = operations.get(operationName);
      if (operation != null) {
        UpdateDatabaseDdlMetadata metadata =
            operation.getMetadata().unpack(UpdateDatabaseDdlMetadata.class);
        List<Timestamp> commitTimestamps = new ArrayList<>(metadata.getStatementsCount());
        for (int i = 0; i < metadata.getStatementsCount(); i++) {
          commitTimestamps.add(currentTime());
        }
        metadata = metadata.toBuilder().addAllCommitTimestamps(commitTimestamps).build();
        operations.update(
            operation
                .toBuilder()
                .setMetadata(Any.pack(metadata))
                .setDone(true)
                .setResponse(Any.pack(Empty.getDefaultInstance()))
                .build());
      }
      return Empty.getDefaultInstance();
    }
  }

  private ConcurrentMap<String, Policy> policies = new ConcurrentHashMap<>();
  private final Queue<Exception> exceptions = new ConcurrentLinkedQueue<>();
  private final ConcurrentMap<String, MockDatabase> databases = new ConcurrentHashMap<>();
  private final MockOperationsServiceImpl operations;

  public MockDatabaseAdminServiceImpl(MockOperationsServiceImpl operations) {
    this.operations = operations;
  }

  @Override
  public void createDatabase(
      CreateDatabaseRequest request, StreamObserver<Operation> responseObserver) {
    String id = request.getCreateStatement().replace("CREATE DATABASE ", "");
    if (id.startsWith("`") && id.endsWith("`")) {
      id = id.substring(1, id.length() - 1);
    }
    String name = String.format("%s/databases/%s", request.getParent(), id);
    MockDatabase db = new MockDatabase(name, request.getExtraStatementsList());
    if (databases.putIfAbsent(name, db) == null) {
      CreateDatabaseMetadata metadata =
          CreateDatabaseMetadata.newBuilder().setDatabase(name).build();
      Database database = Database.newBuilder().setName(name).setState(db.state).build();
      Operation operation =
          Operation.newBuilder()
              .setMetadata(Any.pack(metadata))
              .setResponse(Any.pack(database))
              .setDone(false)
              .setName(operations.generateOperationName(name))
              .build();
      operations.addOperation(operation, new CreateDatabaseCallable(operation.getName(), name));
      responseObserver.onNext(operation);
      responseObserver.onCompleted();
    } else {
      responseObserver.onError(
          Status.ALREADY_EXISTS
              .withDescription(String.format("Database with name %s already exists", name))
              .asRuntimeException());
    }
  }

  @Override
  public void dropDatabase(DropDatabaseRequest request, StreamObserver<Empty> responseObserver) {
    MockDatabase db = databases.get(request.getDatabase());
    if (databases.remove(request.getDatabase(), db)) {
      responseObserver.onNext(Empty.getDefaultInstance());
      responseObserver.onCompleted();
    } else {
      responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
    }
  }

  @Override
  public void getDatabase(GetDatabaseRequest request, StreamObserver<Database> responseObserver) {
    MockDatabase db = databases.get(request.getName());
    if (db != null) {
      responseObserver.onNext(
          Database.newBuilder().setName(request.getName()).setState(State.READY).build());
      responseObserver.onCompleted();
    } else {
      responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
    }
  }

  @Override
  public void getDatabaseDdl(
      GetDatabaseDdlRequest request, StreamObserver<GetDatabaseDdlResponse> responseObserver) {
    MockDatabase db = databases.get(request.getDatabase());
    if (db != null) {
      responseObserver.onNext(GetDatabaseDdlResponse.newBuilder().addAllStatements(db.ddl).build());
      responseObserver.onCompleted();
    } else {
      responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
    }
  }

  @Override
  public void listDatabases(
      ListDatabasesRequest request, StreamObserver<ListDatabasesResponse> responseObserver) {
    List<Database> dbs = new ArrayList<>(databases.size());
    for (Entry<String, MockDatabase> entry : databases.entrySet()) {
      dbs.add(Database.newBuilder().setName(entry.getKey()).setState(State.READY).build());
    }
    responseObserver.onNext(ListDatabasesResponse.newBuilder().addAllDatabases(dbs).build());
    responseObserver.onCompleted();
  }

  @Override
  public void updateDatabaseDdl(
      UpdateDatabaseDdlRequest request, StreamObserver<Operation> responseObserver) {
    MockDatabase db = databases.get(request.getDatabase());
    if (db != null) {
      db.ddl.addAll(request.getStatementsList());
      UpdateDatabaseDdlMetadata metadata =
          UpdateDatabaseDdlMetadata.newBuilder()
              .setDatabase(request.getDatabase())
              .addAllStatements(request.getStatementsList())
              .build();
      Operation operation =
          Operation.newBuilder()
              .setMetadata(Any.pack(metadata))
              .setResponse(Any.pack(Empty.getDefaultInstance()))
              .setDone(true)
              .setName(operations.generateOperationName(request.getDatabase()))
              .build();
      operations.addOperation(operation, new UpdateDatabaseDdlCallable(operation.getName()));
      responseObserver.onNext(operation);
      responseObserver.onCompleted();
    } else {
      responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
    }
  }

  @Override
  public void getIamPolicy(GetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    Policy policy = policies.get(request.getResource());
    if (policy != null) {
      responseObserver.onNext(policy);
    } else {
      responseObserver.onNext(Policy.getDefaultInstance());
    }
    responseObserver.onCompleted();
  }

  @Override
  public void setIamPolicy(SetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    policies.put(request.getResource(), request.getPolicy());
    responseObserver.onNext(request.getPolicy());
    responseObserver.onCompleted();
  }

  @Override
  public void testIamPermissions(
      TestIamPermissionsRequest request,
      StreamObserver<TestIamPermissionsResponse> responseObserver) {
    // Just return the same permissions as in the request, as we don't have any credentials.
    responseObserver.onNext(
        TestIamPermissionsResponse.newBuilder()
            .addAllPermissions(request.getPermissionsList())
            .build());
    responseObserver.onCompleted();
  }

  @Override
  public List<AbstractMessage> getRequests() {
    return Collections.emptyList();
  }

  @Override
  public void addResponse(AbstractMessage response) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void addException(Exception exception) {
    exceptions.add(exception);
  }

  @Override
  public ServerServiceDefinition getServiceDefinition() {
    return bindService();
  }

  @Override
  public void reset() {
    exceptions.clear();
    policies.clear();
    databases.clear();
  }

  private Timestamp currentTime() {
    return Timestamp.newBuilder().setSeconds(System.currentTimeMillis() * 1000L).build();
  }
}
