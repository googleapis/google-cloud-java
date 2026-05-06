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
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
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
import com.google.rpc.Code;
import com.google.spanner.admin.database.v1.Backup;
import com.google.spanner.admin.database.v1.BackupInfo;
import com.google.spanner.admin.database.v1.CreateBackupMetadata;
import com.google.spanner.admin.database.v1.CreateBackupRequest;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.database.v1.CreateDatabaseRequest;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.database.v1.Database.State;
import com.google.spanner.admin.database.v1.DatabaseAdminGrpc.DatabaseAdminImplBase;
import com.google.spanner.admin.database.v1.DatabaseRole;
import com.google.spanner.admin.database.v1.DeleteBackupRequest;
import com.google.spanner.admin.database.v1.DropDatabaseRequest;
import com.google.spanner.admin.database.v1.GetBackupRequest;
import com.google.spanner.admin.database.v1.GetDatabaseDdlRequest;
import com.google.spanner.admin.database.v1.GetDatabaseDdlResponse;
import com.google.spanner.admin.database.v1.GetDatabaseRequest;
import com.google.spanner.admin.database.v1.ListBackupOperationsRequest;
import com.google.spanner.admin.database.v1.ListBackupOperationsResponse;
import com.google.spanner.admin.database.v1.ListBackupsRequest;
import com.google.spanner.admin.database.v1.ListBackupsResponse;
import com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest;
import com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse;
import com.google.spanner.admin.database.v1.ListDatabaseRolesRequest;
import com.google.spanner.admin.database.v1.ListDatabaseRolesResponse;
import com.google.spanner.admin.database.v1.ListDatabasesRequest;
import com.google.spanner.admin.database.v1.ListDatabasesResponse;
import com.google.spanner.admin.database.v1.OperationProgress;
import com.google.spanner.admin.database.v1.OptimizeRestoredDatabaseMetadata;
import com.google.spanner.admin.database.v1.RestoreDatabaseMetadata;
import com.google.spanner.admin.database.v1.RestoreDatabaseRequest;
import com.google.spanner.admin.database.v1.RestoreInfo;
import com.google.spanner.admin.database.v1.RestoreSourceType;
import com.google.spanner.admin.database.v1.UpdateBackupRequest;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest;
import io.grpc.ServerServiceDefinition;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MockDatabaseAdminServiceImpl extends DatabaseAdminImplBase implements MockGrpcService {
  private static final class MockDatabase {
    private final String name;
    private State state;
    private final Timestamp createTime;
    private final List<String> ddl = new ArrayList<>();
    private final RestoreInfo restoreInfo;

    private MockDatabase(String name, List<String> ddl, RestoreInfo restoreInfo) {
      this.name = name;
      this.state = State.CREATING;
      this.createTime =
          Timestamp.newBuilder().setSeconds(System.currentTimeMillis() / 1000L).build();
      this.ddl.addAll(ddl);
      this.restoreInfo = restoreInfo;
    }

    private Database toProto() {
      return Database.newBuilder()
          .setCreateTime(createTime)
          .setName(name)
          .setRestoreInfo(restoreInfo == null ? RestoreInfo.getDefaultInstance() : restoreInfo)
          .setState(state)
          .build();
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

  static final class MockBackup {
    private final String name;
    private Backup.State state;
    private final Timestamp createTime;
    private final String database;
    private final List<String> ddl = new ArrayList<>();
    private final List<String> referencingDatabases = new ArrayList<>();
    private final long size;
    private Timestamp expireTime;

    private MockBackup(String name, Backup backup, MockDatabase database) {
      this.name = name;
      this.state = Backup.State.CREATING;
      this.createTime =
          Timestamp.newBuilder().setSeconds(System.currentTimeMillis() / 1000L).build();
      this.database = database.name;
      this.ddl.addAll(database.ddl);
      this.size = RND.nextInt(Integer.MAX_VALUE);
      this.expireTime = backup.getExpireTime();
    }

    private Backup toProto() {
      return Backup.newBuilder()
          .setCreateTime(createTime)
          .setDatabase(database)
          .setExpireTime(expireTime)
          .setName(name)
          .setSizeBytes(size)
          .setState(state)
          .addAllReferencingDatabases(referencingDatabases)
          .build();
    }

    private BackupInfo toBackupInfo() {
      return BackupInfo.newBuilder()
          .setBackup(name)
          .setCreateTime(createTime)
          .setSourceDatabase(database)
          .build();
    }

    public String getName() {
      return name;
    }

    public String getDatabase() {
      return database;
    }

    public Timestamp getExpireTime() {
      return expireTime;
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
    public Database call() {
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
            operation.toBuilder()
                .setMetadata(Any.pack(metadata))
                .setDone(true)
                .setResponse(Any.pack(Empty.getDefaultInstance()))
                .build());
      }
      return Empty.getDefaultInstance();
    }
  }

  private final class CreateBackupCallable implements Callable<Backup> {
    private final String operationName;
    private final String name;

    private CreateBackupCallable(String operationName, String name) {
      this.operationName = operationName;
      this.name = name;
    }

    @Override
    public Backup call() throws Exception {
      MockBackup backup = backups.get(name);
      Backup proto = backup.toProto();
      Operation operation = operations.get(operationName);
      for (int progress = 1; progress <= 100; progress++) {
        operation = operations.get(operationName);
        long sleep = createBackupOperationExecutionTime / 100;
        if (progress == 100) {
          sleep += createBackupOperationExecutionTime % 100;
        }
        Thread.sleep(sleep);
        if (operation != null) {
          CreateBackupMetadata metadata =
              operation.getMetadata().unpack(CreateBackupMetadata.class);
          metadata =
              metadata.toBuilder()
                  .setProgress(
                      metadata.getProgress().toBuilder().setProgressPercent(progress).build())
                  .build();
          operations.update(
              operation.toBuilder()
                  .setMetadata(Any.pack(metadata))
                  .setResponse(Any.pack(proto))
                  .build());
        }
      }
      backup.state = Backup.State.READY;
      proto = backup.toProto();
      if (operation != null) {
        CreateBackupMetadata metadata = operation.getMetadata().unpack(CreateBackupMetadata.class);
        metadata =
            metadata.toBuilder()
                .setProgress(
                    metadata.getProgress().toBuilder()
                        .setProgressPercent(100)
                        .setEndTime(currentTime())
                        .build())
                .build();
        operations.update(
            operation.toBuilder()
                .setDone(true)
                .setMetadata(Any.pack(metadata))
                .setResponse(Any.pack(proto))
                .build());
      }
      return proto;
    }
  }

  private final class RestoreDatabaseCallable implements Callable<Database> {
    private final String operationName;
    private final String name;

    private RestoreDatabaseCallable(String operationName, String name) {
      this.operationName = operationName;
      this.name = name;
    }

    @Override
    public Database call() throws Exception {
      MockDatabase db = databases.get(name);
      db.state = State.READY_OPTIMIZING;
      Database proto = db.toProto();
      Operation operation = operations.get(operationName);
      for (int progress = 1; progress <= 100; progress++) {
        long sleep = restoreDatabaseOperationExecutionTime / 100;
        if (progress == 100) {
          sleep += restoreDatabaseOperationExecutionTime % 100;
        }
        Thread.sleep(sleep);
        if (operation != null) {
          RestoreDatabaseMetadata metadata =
              operation.getMetadata().unpack(RestoreDatabaseMetadata.class);
          metadata =
              metadata.toBuilder()
                  .setProgress(
                      metadata.getProgress().toBuilder().setProgressPercent(progress).build())
                  .build();
          operations.update(
              operation.toBuilder()
                  .setMetadata(Any.pack(metadata))
                  .setResponse(Any.pack(proto))
                  .build());
        }
      }
      db.state = State.READY_OPTIMIZING;
      proto = db.toProto();
      if (operation != null) {
        RestoreDatabaseMetadata metadata =
            operation.getMetadata().unpack(RestoreDatabaseMetadata.class);
        metadata =
            metadata.toBuilder()
                .setProgress(
                    metadata.getProgress().toBuilder()
                        .setEndTime(currentTime())
                        .setProgressPercent(100)
                        .build())
                .build();
        operations.update(
            operation.toBuilder()
                .setDone(true)
                .setMetadata(Any.pack(metadata))
                .setResponse(Any.pack(proto))
                .build());
      }
      return proto;
    }
  }

  private final class OptimizeDatabaseCallable implements Callable<Database> {
    private final String operationName;
    private final String restoreOperationName;
    private final String name;

    private OptimizeDatabaseCallable(
        String operationName, String restoreOperationName, String name) {
      this.operationName = operationName;
      this.restoreOperationName = restoreOperationName;
      this.name = name;
    }

    @Override
    public Database call() throws Exception {
      MockDatabase db = databases.get(name);
      Operation operation = operations.get(operationName);
      try {
        // Wait until the restore operation has finished.
        Operation restoreOperation = operations.get(restoreOperationName);
        while (!restoreOperation.getDone()) {
          Thread.sleep(10L);
          restoreOperation = operations.get(restoreOperationName);
        }
        Thread.sleep(optimizeDatabaseOperationExecutionTime);
        db.state = State.READY;
        Database proto = db.toProto();
        if (operation != null) {
          operations.update(
              operation.toBuilder().setDone(true).setResponse(Any.pack(proto)).build());
        }
        return proto;
      } catch (Exception e) {
        if (operation != null) {
          Database proto = db.toProto();
          operations.update(
              operation.toBuilder()
                  .setDone(true)
                  .setError(fromException(e))
                  .setResponse(Any.pack(proto))
                  .build());
        }
        throw e;
      }
    }
  }

  private com.google.rpc.Status fromException(Exception e) {
    int code = Code.UNKNOWN_VALUE;
    if (e instanceof InterruptedException) {
      code = Code.CANCELLED_VALUE;
    }
    return com.google.rpc.Status.newBuilder().setCode(code).setMessage(e.getMessage()).build();
  }

  private final Queue<AbstractMessage> requests = new ConcurrentLinkedQueue<>();
  private ConcurrentMap<String, Policy> policies = new ConcurrentHashMap<>();
  private static final String EXPIRE_TIME_MASK = "expire_time";
  private static final Random RND = new Random();
  private final Queue<Exception> exceptions = new ConcurrentLinkedQueue<>();
  private volatile CountDownLatch freezeLock = new CountDownLatch(0);
  private final ConcurrentMap<String, MockDatabase> databases = new ConcurrentHashMap<>();
  private final ConcurrentMap<String, MockBackup> backups = new ConcurrentHashMap<>();
  private final ConcurrentMap<String, Set<String>> filterMatches = new ConcurrentHashMap<>();
  private final List<DatabaseRole> databaseRoles = new ArrayList<>();
  private final MockOperationsServiceImpl operations;

  private long createBackupOperationExecutionTime;
  private long restoreDatabaseOperationExecutionTime;
  private long optimizeDatabaseOperationExecutionTime;

  private SimulatedExecutionTime createBackupStartupExecutionTime = SimulatedExecutionTime.none();
  private SimulatedExecutionTime createBackupResponseExecutionTime = SimulatedExecutionTime.none();
  private SimulatedExecutionTime createDatabaseStartupExecutionTime = SimulatedExecutionTime.none();
  private SimulatedExecutionTime createDatabaseResponseExecutionTime =
      SimulatedExecutionTime.none();
  private SimulatedExecutionTime getDatabaseExecutionTime = SimulatedExecutionTime.none();
  private SimulatedExecutionTime restoreDatabaseStartupExecutionTime =
      SimulatedExecutionTime.none();
  private SimulatedExecutionTime restoreDatabaseResponseExecutionTime =
      SimulatedExecutionTime.none();

  public MockDatabaseAdminServiceImpl(MockOperationsServiceImpl operations) {
    this.operations = operations;
  }

  @Override
  public void createDatabase(
      CreateDatabaseRequest request, StreamObserver<Operation> responseObserver) {
    requests.add(request);
    try {
      createDatabaseStartupExecutionTime.simulateExecutionTime(exceptions, false, freezeLock);
      String id = request.getCreateStatement().replace("CREATE DATABASE ", "");
      if (id.startsWith("`") && id.endsWith("`")) {
        id = id.substring(1, id.length() - 1);
      }
      String name = String.format("%s/databases/%s", request.getParent(), id);
      MockDatabase db = new MockDatabase(name, request.getExtraStatementsList(), null);
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
        createDatabaseResponseExecutionTime.simulateExecutionTime(exceptions, false, freezeLock);
        responseObserver.onNext(operation);
        responseObserver.onCompleted();
      } else {
        responseObserver.onError(
            Status.ALREADY_EXISTS
                .withDescription(String.format("Database with name %s already exists", name))
                .asRuntimeException());
      }
    } catch (Throwable t) {
      responseObserver.onError(t);
    }
  }

  @Override
  public void dropDatabase(DropDatabaseRequest request, StreamObserver<Empty> responseObserver) {
    requests.add(request);
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
    requests.add(request);
    try {
      getDatabaseExecutionTime.simulateExecutionTime(exceptions, false, freezeLock);
      MockDatabase db = databases.get(request.getName());
      if (db != null) {
        responseObserver.onNext(
            Database.newBuilder()
                .setName(request.getName())
                .setCreateTime(db.createTime)
                .setState(State.READY)
                .build());
        responseObserver.onCompleted();
      } else {
        responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
      }
    } catch (Throwable t) {
      responseObserver.onError(t);
    }
  }

  @Override
  public void getDatabaseDdl(
      GetDatabaseDdlRequest request, StreamObserver<GetDatabaseDdlResponse> responseObserver) {
    requests.add(request);
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
    requests.add(request);
    List<Database> dbs = new ArrayList<>(databases.size());
    for (Entry<String, MockDatabase> entry : databases.entrySet()) {
      dbs.add(
          Database.newBuilder()
              .setName(entry.getKey())
              .setCreateTime(entry.getValue().createTime)
              .setState(State.READY)
              .build());
    }
    responseObserver.onNext(ListDatabasesResponse.newBuilder().addAllDatabases(dbs).build());
    responseObserver.onCompleted();
  }

  @Override
  public void listDatabaseOperations(
      ListDatabaseOperationsRequest request,
      StreamObserver<ListDatabaseOperationsResponse> responseObserver) {
    requests.add(request);
    ListDatabaseOperationsResponse.Builder builder = ListDatabaseOperationsResponse.newBuilder();
    try {
      for (Operation op : operations.iterable()) {
        if (op.getName().matches(".*?/databases\\/.*?/operations/.*?")
            && op.getName().startsWith(request.getParent())) {
          if (matchesFilter(op, request.getFilter())) {
            builder.addOperations(op);
          }
        }
      }
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    } catch (Exception e) {
      responseObserver.onError(e);
    }
  }

  @Override
  public void listDatabaseRoles(
      ListDatabaseRolesRequest request,
      StreamObserver<ListDatabaseRolesResponse> responseObserver) {
    requests.add(request);
    List<com.google.spanner.admin.database.v1.DatabaseRole> dbRoles =
        new ArrayList<>(databaseRoles.size());
    for (DatabaseRole entry : databaseRoles) {
      dbRoles.add(
          com.google.spanner.admin.database.v1.DatabaseRole.newBuilder()
              .setName(entry.getName())
              .build());
    }

    responseObserver.onNext(
        ListDatabaseRolesResponse.newBuilder().addAllDatabaseRoles(dbRoles).build());
    responseObserver.onCompleted();
  }

  private boolean matchesFilter(Object obj, String filter) throws Exception {
    if (!Strings.isNullOrEmpty(filter)) {
      Set<String> matches = filterMatches.get(filter);
      if (matches != null) {
        String name = (String) obj.getClass().getMethod("getName").invoke(obj);
        return matches.contains(name);
      }
      if (obj instanceof Operation) {
        Operation operation = (Operation) obj;
        Pattern pattern =
            Pattern.compile(
                "(?:\\(metadata.@type:type.googleapis.com/(.*)\\)) AND"
                    + " (?:\\(metadata.(?:name|database):(.*)\\)|\\(name:(.*)/operations/\\))");
        Matcher matcher = pattern.matcher(filter);
        if (matcher.matches()) {
          String type = matcher.group(1);
          String objectName = matcher.group(2);
          if (objectName == null) {
            objectName = matcher.group(3);
          }
          Any anyMetadata = operation.getMetadata();
          if (anyMetadata.getTypeUrl().endsWith(type)) {
            if (type.equals(CreateBackupMetadata.getDescriptor().getFullName())) {
              CreateBackupMetadata metadata =
                  operation.getMetadata().unpack(CreateBackupMetadata.class);
              return metadata.getName().equals(objectName);
            } else if (type.equals(CreateDatabaseMetadata.getDescriptor().getFullName())) {
              CreateDatabaseMetadata metadata =
                  operation.getMetadata().unpack(CreateDatabaseMetadata.class);
              return metadata.getDatabase().equals(objectName);
            } else if (type.equals(RestoreDatabaseMetadata.getDescriptor().getFullName())) {
              RestoreDatabaseMetadata metadata =
                  operation.getMetadata().unpack(RestoreDatabaseMetadata.class);
              return metadata.getName().equals(objectName);
            }
          }
        }
      }
      return false;
    }
    return true;
  }

  @Override
  public void updateDatabaseDdl(
      UpdateDatabaseDdlRequest request, StreamObserver<Operation> responseObserver) {
    requests.add(request);
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
  public void createBackup(
      CreateBackupRequest request, StreamObserver<Operation> responseObserver) {
    requests.add(request);
    try {
      createBackupStartupExecutionTime.simulateExecutionTime(exceptions, false, freezeLock);
      String name = String.format("%s/backups/%s", request.getParent(), request.getBackupId());
      MockDatabase db = databases.get(request.getBackup().getDatabase());
      if (db == null) {
        responseObserver.onError(
            Status.NOT_FOUND
                .withDescription(
                    String.format(
                        "Database with name %s not found", request.getBackup().getDatabase()))
                .asRuntimeException());
        return;
      }
      MockBackup bck = new MockBackup(name, request.getBackup(), db);
      if (backups.putIfAbsent(name, bck) == null) {
        CreateBackupMetadata metadata =
            CreateBackupMetadata.newBuilder()
                .setName(name)
                .setDatabase(bck.database)
                .setProgress(
                    OperationProgress.newBuilder()
                        .setStartTime(
                            Timestamp.newBuilder()
                                .setSeconds(System.currentTimeMillis() / 1000L)
                                .build())
                        .setProgressPercent(0))
                .build();
        Operation operation =
            Operation.newBuilder()
                .setMetadata(Any.pack(metadata))
                .setResponse(Any.pack(bck.toProto()))
                .setName(operations.generateOperationName(name))
                .build();
        operations.addOperation(operation, new CreateBackupCallable(operation.getName(), name));

        createBackupResponseExecutionTime.simulateExecutionTime(exceptions, false, freezeLock);
        responseObserver.onNext(operation);
        responseObserver.onCompleted();
      } else {
        responseObserver.onError(
            Status.ALREADY_EXISTS
                .withDescription(String.format("Backup with name %s already exists", name))
                .asRuntimeException());
      }
    } catch (Throwable t) {
      responseObserver.onError(t);
    }
  }

  @Override
  public void deleteBackup(DeleteBackupRequest request, StreamObserver<Empty> responseObserver) {
    requests.add(request);
    MockBackup bck = backups.get(request.getName());
    if (backups.remove(request.getName(), bck)) {
      responseObserver.onNext(Empty.getDefaultInstance());
      responseObserver.onCompleted();
    } else {
      responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
    }
  }

  @Override
  public void getBackup(GetBackupRequest request, StreamObserver<Backup> responseObserver) {
    requests.add(request);
    MockBackup bck = backups.get(request.getName());
    if (bck != null) {
      responseObserver.onNext(
          Backup.newBuilder()
              .setName(request.getName())
              .setCreateTime(bck.createTime)
              .setDatabase(bck.database)
              .setExpireTime(bck.expireTime)
              .setSizeBytes(bck.size)
              .setState(Backup.State.READY)
              .build());
      responseObserver.onCompleted();
    } else {
      responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
    }
  }

  @Override
  public void listBackups(
      ListBackupsRequest request, StreamObserver<ListBackupsResponse> responseObserver) {
    requests.add(request);
    List<Backup> bcks = new ArrayList<>(backups.size());
    try {
      for (Entry<String, MockBackup> entry : backups.entrySet()) {
        if (matchesFilter(entry.getValue(), request.getFilter())) {
          bcks.add(
              Backup.newBuilder()
                  .setName(entry.getKey())
                  .setCreateTime(entry.getValue().createTime)
                  .setDatabase(entry.getValue().database)
                  .setExpireTime(entry.getValue().expireTime)
                  .setSizeBytes(entry.getValue().size)
                  .setState(Backup.State.READY)
                  .build());
        }
      }
      responseObserver.onNext(ListBackupsResponse.newBuilder().addAllBackups(bcks).build());
      responseObserver.onCompleted();
    } catch (Exception e) {
      responseObserver.onError(e);
    }
  }

  @Override
  public void listBackupOperations(
      ListBackupOperationsRequest request,
      StreamObserver<ListBackupOperationsResponse> responseObserver) {
    requests.add(request);
    ListBackupOperationsResponse.Builder builder = ListBackupOperationsResponse.newBuilder();
    try {
      for (Operation op : operations.iterable()) {
        if (op.getName().matches(".*?/backups/.*?/operations/.*?")
            && op.getName().startsWith(request.getParent())) {
          if (matchesFilter(op, request.getFilter())) {
            builder.addOperations(op);
          }
        }
      }
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    } catch (Exception e) {
      responseObserver.onError(e);
    }
  }

  @Override
  public void updateBackup(UpdateBackupRequest request, StreamObserver<Backup> responseObserver) {
    requests.add(request);
    MockBackup bck = backups.get(request.getBackup().getName());
    if (bck != null) {
      if (request.getUpdateMask().getPathsList().contains(EXPIRE_TIME_MASK)) {
        bck.expireTime = request.getBackup().getExpireTime();
      }
      responseObserver.onNext(
          Backup.newBuilder()
              .setName(bck.name)
              .setCreateTime(bck.createTime)
              .setDatabase(bck.database)
              .setExpireTime(bck.expireTime)
              .setSizeBytes(bck.size)
              .setState(Backup.State.READY)
              .build());
      responseObserver.onCompleted();
    } else {
      responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
    }
  }

  @Override
  public void restoreDatabase(
      RestoreDatabaseRequest request, StreamObserver<Operation> responseObserver) {
    requests.add(request);
    try {
      restoreDatabaseStartupExecutionTime.simulateExecutionTime(exceptions, false, freezeLock);
      MockBackup bck = backups.get(request.getBackup());
      if (bck != null) {
        String name =
            String.format("%s/databases/%s", request.getParent(), request.getDatabaseId());
        MockDatabase db =
            new MockDatabase(
                name,
                bck.ddl,
                RestoreInfo.newBuilder()
                    .setBackupInfo(bck.toBackupInfo())
                    .setSourceType(RestoreSourceType.BACKUP)
                    .build());
        if (databases.putIfAbsent(name, db) == null) {
          bck.referencingDatabases.add(db.name);
          Operation optimizeOperation =
              Operation.newBuilder()
                  .setDone(false)
                  .setName(operations.generateOperationName(name))
                  .setMetadata(
                      Any.pack(
                          OptimizeRestoredDatabaseMetadata.newBuilder()
                              .setName(name)
                              .setProgress(
                                  OperationProgress.newBuilder()
                                      .setStartTime(currentTime())
                                      .setProgressPercent(0)
                                      .build())
                              .build()))
                  .setResponse(Any.pack(db.toProto()))
                  .build();
          RestoreDatabaseMetadata metadata =
              RestoreDatabaseMetadata.newBuilder()
                  .setBackupInfo(bck.toBackupInfo())
                  .setName(name)
                  .setProgress(
                      OperationProgress.newBuilder()
                          .setStartTime(currentTime())
                          .setProgressPercent(0)
                          .build())
                  .setOptimizeDatabaseOperationName(optimizeOperation.getName())
                  .setSourceType(RestoreSourceType.BACKUP)
                  .build();
          Operation operation =
              Operation.newBuilder()
                  .setMetadata(Any.pack(metadata))
                  .setResponse(Any.pack(db.toProto()))
                  .setDone(false)
                  .setName(operations.generateOperationName(name))
                  .build();
          operations.addOperation(
              operation, new RestoreDatabaseCallable(operation.getName(), name));
          operations.addOperation(
              optimizeOperation,
              new OptimizeDatabaseCallable(optimizeOperation.getName(), operation.getName(), name));
          restoreDatabaseResponseExecutionTime.simulateExecutionTime(exceptions, false, freezeLock);
          responseObserver.onNext(operation);
          responseObserver.onCompleted();
        } else {
          responseObserver.onError(Status.ALREADY_EXISTS.asRuntimeException());
        }
      } else {
        responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
      }
    } catch (Throwable t) {
      responseObserver.onError(t);
    }
  }

  @Override
  public void getIamPolicy(GetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    requests.add(request);
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
    requests.add(request);
    policies.put(request.getResource(), request.getPolicy());
    responseObserver.onNext(request.getPolicy());
    responseObserver.onCompleted();
  }

  @Override
  public void testIamPermissions(
      TestIamPermissionsRequest request,
      StreamObserver<TestIamPermissionsResponse> responseObserver) {
    requests.add(request);
    // Just return the same permissions as in the request, as we don't have any credentials.
    responseObserver.onNext(
        TestIamPermissionsResponse.newBuilder()
            .addAllPermissions(request.getPermissionsList())
            .build());
    responseObserver.onCompleted();
  }

  @Override
  public List<AbstractMessage> getRequests() {
    return new ArrayList<>(requests);
  }

  public void clearRequests() {
    requests.clear();
  }

  public int countRequestsOfType(final Class<? extends AbstractMessage> type) {
    return Collections2.filter(getRequests(), input -> input.getClass().equals(type)).size();
  }

  @Override
  public void addResponse(AbstractMessage response) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void addException(Exception exception) {
    exceptions.add(exception);
  }

  public void addFilterMatches(String filter, String... names) {
    Set<String> matches = filterMatches.computeIfAbsent(filter, k -> new HashSet<>());
    matches.addAll(Arrays.asList(names));
  }

  public void clearFilterMatches() {
    filterMatches.clear();
  }

  @Override
  public ServerServiceDefinition getServiceDefinition() {
    return bindService();
  }

  @Override
  public void reset() {
    requests.clear();
    exceptions.clear();
    policies.clear();
    databases.clear();
    backups.clear();
    filterMatches.clear();
  }

  public void removeAllExecutionTimes() {
    createBackupStartupExecutionTime = SimulatedExecutionTime.none();
    createBackupResponseExecutionTime = SimulatedExecutionTime.none();
    createBackupOperationExecutionTime = 0L;
    createDatabaseStartupExecutionTime = SimulatedExecutionTime.none();
    createDatabaseResponseExecutionTime = SimulatedExecutionTime.none();
    restoreDatabaseStartupExecutionTime = SimulatedExecutionTime.none();
    restoreDatabaseResponseExecutionTime = SimulatedExecutionTime.none();
    restoreDatabaseOperationExecutionTime = 0L;
  }

  private Timestamp currentTime() {
    return Timestamp.newBuilder().setSeconds(System.currentTimeMillis() * 1000L).build();
  }

  public void setCreateBackupStartupExecutionTime(SimulatedExecutionTime exec) {
    this.createBackupStartupExecutionTime = exec;
  }

  public void setCreateBackupResponseExecutionTime(SimulatedExecutionTime exec) {
    this.createBackupResponseExecutionTime = exec;
  }

  public void setCreateDatabaseStartupExecutionTime(SimulatedExecutionTime exec) {
    this.createDatabaseStartupExecutionTime = exec;
  }

  public void setCreateDatabaseResponseExecutionTime(SimulatedExecutionTime exec) {
    this.createDatabaseResponseExecutionTime = exec;
  }

  public void setRestoreDatabaseStartupExecutionTime(SimulatedExecutionTime exec) {
    this.restoreDatabaseStartupExecutionTime = exec;
  }

  public void setRestoreDatabaseResponseExecutionTime(SimulatedExecutionTime exec) {
    this.restoreDatabaseResponseExecutionTime = exec;
  }
}
