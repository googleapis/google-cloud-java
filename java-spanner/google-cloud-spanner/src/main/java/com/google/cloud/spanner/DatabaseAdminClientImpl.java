/*
 * Copyright 2019 Google LLC
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

import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.longrunning.OperationFutureImpl;
import com.google.api.gax.paging.Page;
import com.google.cloud.Policy;
import com.google.cloud.Policy.DefaultMarshaller;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.DatabaseInfo.DatabaseField;
import com.google.cloud.spanner.Options.ListOption;
import com.google.cloud.spanner.SpannerImpl.PageFetcher;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.cloud.spanner.spi.v1.SpannerRpc.Paginated;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.iam.v1.GetPolicyOptions;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.spanner.admin.database.v1.*;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;

/** Default implementation of {@link DatabaseAdminClient}. */
class DatabaseAdminClientImpl implements DatabaseAdminClient {
  private static final class PolicyMarshaller extends DefaultMarshaller {
    @Override
    protected Policy fromPb(com.google.iam.v1.Policy policyPb) {
      return super.fromPb(policyPb);
    }

    @Override
    protected com.google.iam.v1.Policy toPb(Policy policy) {
      return super.toPb(policy);
    }
  }

  private final String projectId;
  private final SpannerRpc rpc;
  private final PolicyMarshaller policyMarshaller = new PolicyMarshaller();
  private static final String EXPIRE_TIME_MASK = "expire_time";

  DatabaseAdminClientImpl(String projectId, SpannerRpc rpc) {
    this.projectId = projectId;
    this.rpc = rpc;
  }

  /** Generates a random operation id for long-running database operations. */
  private static String randomOperationId() {
    UUID uuid = UUID.randomUUID();
    return ("r" + uuid.toString()).replace("-", "_");
  }

  @Override
  public Database.Builder newDatabaseBuilder(DatabaseId databaseId) {
    return new Database.Builder(this, databaseId);
  }

  @Override
  public Backup.Builder newBackupBuilder(BackupId backupId) {
    return new Backup.Builder(this, backupId);
  }

  @Override
  public Restore.Builder newRestoreBuilder(BackupId source, DatabaseId destination) {
    return new Restore.Builder(source, destination);
  }

  @Override
  public OperationFuture<Database, RestoreDatabaseMetadata> restoreDatabase(
      String backupInstanceId, String backupId, String restoreInstanceId, String restoreDatabaseId)
      throws SpannerException {
    return restoreDatabase(
        newRestoreBuilder(
                BackupId.of(projectId, backupInstanceId, backupId),
                DatabaseId.of(projectId, restoreInstanceId, restoreDatabaseId))
            .build());
  }

  @Override
  public OperationFuture<Database, RestoreDatabaseMetadata> restoreDatabase(Restore restore)
      throws SpannerException {
    final OperationFuture<com.google.spanner.admin.database.v1.Database, RestoreDatabaseMetadata>
        rawOperationFuture = rpc.restoreDatabase(restore);

    return new OperationFutureImpl<>(
        rawOperationFuture.getPollingFuture(),
        rawOperationFuture.getInitialFuture(),
        snapshot ->
            Database.fromProto(
                ProtoOperationTransformers.ResponseTransformer.create(
                        com.google.spanner.admin.database.v1.Database.class)
                    .apply(snapshot),
                DatabaseAdminClientImpl.this),
        ProtoOperationTransformers.MetadataTransformer.create(RestoreDatabaseMetadata.class),
        e -> {
          throw SpannerExceptionFactory.newSpannerException(e);
        });
  }

  @Override
  public OperationFuture<Backup, CreateBackupMetadata> createBackup(
      String instanceId, String backupId, String databaseId, Timestamp expireTime)
      throws SpannerException {
    final Backup backupInfo =
        newBackupBuilder(BackupId.of(projectId, instanceId, backupId))
            .setDatabase(DatabaseId.of(projectId, instanceId, databaseId))
            .setExpireTime(expireTime)
            .build();

    return createBackup(backupInfo);
  }

  @Override
  public OperationFuture<Backup, CreateBackupMetadata> createBackup(Backup backupInfo)
      throws SpannerException {
    Preconditions.checkArgument(
        backupInfo.getExpireTime() != null, "Cannot create a backup without an expire time");
    Preconditions.checkArgument(
        backupInfo.getDatabase() != null, "Cannot create a backup without a source database");

    final OperationFuture<com.google.spanner.admin.database.v1.Backup, CreateBackupMetadata>
        rawOperationFuture = rpc.createBackup(backupInfo);

    return new OperationFutureImpl<>(
        rawOperationFuture.getPollingFuture(),
        rawOperationFuture.getInitialFuture(),
        snapshot -> {
          com.google.spanner.admin.database.v1.Backup proto =
              ProtoOperationTransformers.ResponseTransformer.create(
                      com.google.spanner.admin.database.v1.Backup.class)
                  .apply(snapshot);
          return Backup.fromProto(
              com.google.spanner.admin.database.v1.Backup.newBuilder(proto)
                  .setName(proto.getName())
                  .setExpireTime(proto.getExpireTime())
                  .setVersionTime(proto.getVersionTime())
                  .setState(proto.getState())
                  .setEncryptionInfo(proto.getEncryptionInfo())
                  .build(),
              DatabaseAdminClientImpl.this);
        },
        ProtoOperationTransformers.MetadataTransformer.create(CreateBackupMetadata.class),
        e -> {
          throw SpannerExceptionFactory.newSpannerException(e);
        });
  }

  @Override
  public OperationFuture<Backup, CopyBackupMetadata> copyBackup(
      String instanceId, String sourceBackupId, String destinationBackupId, Timestamp expireTime)
      throws SpannerException {
    final Backup destinationBackup =
        newBackupBuilder(BackupId.of(projectId, instanceId, destinationBackupId))
            .setExpireTime(expireTime)
            .build();

    return copyBackup(BackupId.of(projectId, instanceId, sourceBackupId), destinationBackup);
  }

  @Override
  public OperationFuture<Backup, CopyBackupMetadata> copyBackup(
      BackupId sourceBackupId, Backup destinationBackup) throws SpannerException {
    Preconditions.checkNotNull(sourceBackupId);
    Preconditions.checkNotNull(destinationBackup);

    final OperationFuture<com.google.spanner.admin.database.v1.Backup, CopyBackupMetadata>
        rawOperationFuture = rpc.copyBackup(sourceBackupId, destinationBackup);

    return new OperationFutureImpl<>(
        rawOperationFuture.getPollingFuture(),
        rawOperationFuture.getInitialFuture(),
        snapshot -> {
          com.google.spanner.admin.database.v1.Backup proto =
              ProtoOperationTransformers.ResponseTransformer.create(
                      com.google.spanner.admin.database.v1.Backup.class)
                  .apply(snapshot);
          return Backup.fromProto(
              com.google.spanner.admin.database.v1.Backup.newBuilder(proto)
                  .setName(proto.getName())
                  .setExpireTime(proto.getExpireTime())
                  .setEncryptionInfo(proto.getEncryptionInfo())
                  .build(),
              DatabaseAdminClientImpl.this);
        },
        ProtoOperationTransformers.MetadataTransformer.create(CopyBackupMetadata.class),
        e -> {
          throw SpannerExceptionFactory.newSpannerException(e);
        });
  }

  @Override
  public Backup updateBackup(String instanceId, String backupId, Timestamp expireTime) {
    String backupName = getBackupName(instanceId, backupId);
    final com.google.spanner.admin.database.v1.Backup backup =
        com.google.spanner.admin.database.v1.Backup.newBuilder()
            .setName(backupName)
            .setExpireTime(expireTime.toProto())
            .build();
    // Only update the expire time of the backup.
    final FieldMask updateMask = FieldMask.newBuilder().addPaths(EXPIRE_TIME_MASK).build();
    try {
      return Backup.fromProto(rpc.updateBackup(backup, updateMask), DatabaseAdminClientImpl.this);
    } catch (Exception e) {
      throw SpannerExceptionFactory.newSpannerException(e);
    }
  }

  @Override
  public void deleteBackup(String instanceId, String backupId) {
    final String backupName = getBackupName(instanceId, backupId);
    try {
      rpc.deleteBackup(backupName);
    } catch (Exception e) {
      throw SpannerExceptionFactory.newSpannerException(e);
    }
  }

  @Override
  public Backup getBackup(String instanceId, String backupId) throws SpannerException {
    final String backupName = getBackupName(instanceId, backupId);
    return Backup.fromProto(rpc.getBackup(backupName), DatabaseAdminClientImpl.this);
  }

  @Override
  public final Page<Operation> listBackupOperations(String instanceId, ListOption... options) {
    final String instanceName = getInstanceName(instanceId);
    final Options listOptions = Options.fromListOptions(options);
    final int pageSize = listOptions.hasPageSize() ? listOptions.pageSize() : 0;
    final String filter = listOptions.hasFilter() ? listOptions.filter() : null;
    final String pageToken = listOptions.hasPageToken() ? listOptions.pageToken() : null;

    PageFetcher<Operation, Operation> pageFetcher =
        new PageFetcher<Operation, Operation>() {
          @Override
          public Paginated<Operation> getNextPage(String nextPageToken) {
            return rpc.listBackupOperations(instanceName, pageSize, filter, pageToken);
          }

          @Override
          public Operation fromProto(Operation proto) {
            return proto;
          }
        };
    if (listOptions.hasPageToken()) {
      pageFetcher.setNextPageToken(listOptions.pageToken());
    }
    return pageFetcher.getNextPage();
  }

  @Override
  public final Page<Operation> listDatabaseOperations(String instanceId, ListOption... options) {
    final String instanceName = getInstanceName(instanceId);
    final Options listOptions = Options.fromListOptions(options);
    final int pageSize = listOptions.hasPageSize() ? listOptions.pageSize() : 0;
    final String filter = listOptions.hasFilter() ? listOptions.filter() : null;
    final String pageToken = listOptions.hasPageToken() ? listOptions.pageToken() : null;

    PageFetcher<Operation, Operation> pageFetcher =
        new PageFetcher<Operation, Operation>() {
          @Override
          public Paginated<Operation> getNextPage(String nextPageToken) {
            return rpc.listDatabaseOperations(instanceName, pageSize, filter, pageToken);
          }

          @Override
          public Operation fromProto(Operation proto) {
            return proto;
          }
        };
    if (listOptions.hasPageToken()) {
      pageFetcher.setNextPageToken(listOptions.pageToken());
    }
    return pageFetcher.getNextPage();
  }

  @Override
  public final Page<DatabaseRole> listDatabaseRoles(
      String instanceId, String databaseId, ListOption... options) {
    final String databaseName = getDatabaseName(instanceId, databaseId);
    final Options listOptions = Options.fromListOptions(options);
    final int pageSize = listOptions.hasPageSize() ? listOptions.pageSize() : 0;

    PageFetcher<DatabaseRole, com.google.spanner.admin.database.v1.DatabaseRole> pageFetcher =
        new PageFetcher<DatabaseRole, com.google.spanner.admin.database.v1.DatabaseRole>() {
          @Override
          public Paginated<com.google.spanner.admin.database.v1.DatabaseRole> getNextPage(
              String nextPageToken) {
            try {
              return rpc.listDatabaseRoles(databaseName, pageSize, nextPageToken);
            } catch (SpannerException e) {
              throw SpannerExceptionFactory.newSpannerException(
                  e.getErrorCode(),
                  String.format(
                      "Failed to list the databases roles of %s with pageToken %s: %s",
                      databaseName,
                      MoreObjects.firstNonNull(nextPageToken, "<null>"),
                      e.getMessage()),
                  e);
            }
          }

          @Override
          public DatabaseRole fromProto(com.google.spanner.admin.database.v1.DatabaseRole proto) {
            return DatabaseRole.fromProto(proto);
          }
        };
    if (listOptions.hasPageToken()) {
      pageFetcher.setNextPageToken(listOptions.pageToken());
    }
    return pageFetcher.getNextPage();
  }

  @Override
  public Page<Backup> listBackups(String instanceId, ListOption... options) {
    final String instanceName = getInstanceName(instanceId);
    final Options listOptions = Options.fromListOptions(options);
    final String filter = listOptions.hasFilter() ? listOptions.filter() : null;
    final int pageSize = listOptions.hasPageSize() ? listOptions.pageSize() : 0;

    PageFetcher<Backup, com.google.spanner.admin.database.v1.Backup> pageFetcher =
        new PageFetcher<Backup, com.google.spanner.admin.database.v1.Backup>() {
          @Override
          public Paginated<com.google.spanner.admin.database.v1.Backup> getNextPage(
              String nextPageToken) {
            return rpc.listBackups(instanceName, pageSize, filter, nextPageToken);
          }

          @Override
          public Backup fromProto(com.google.spanner.admin.database.v1.Backup proto) {
            return Backup.fromProto(proto, DatabaseAdminClientImpl.this);
          }
        };
    if (listOptions.hasPageToken()) {
      pageFetcher.setNextPageToken(listOptions.pageToken());
    }
    return pageFetcher.getNextPage();
  }

  @Override
  public OperationFuture<Database, CreateDatabaseMetadata> createDatabase(
      String instanceId, String databaseId, Iterable<String> statements) throws SpannerException {
    return createDatabase(
        newDatabaseBuilder(DatabaseId.of(projectId, instanceId, databaseId))
            .setDialect(Dialect.GOOGLE_STANDARD_SQL)
            .build(),
        statements);
  }

  @Override
  public OperationFuture<Database, CreateDatabaseMetadata> createDatabase(
      Database database, Iterable<String> statements) throws SpannerException {
    final Dialect dialect = Preconditions.checkNotNull(database.getDialect());
    final String createStatement =
        dialect.createDatabaseStatementFor(database.getId().getDatabase());

    return createDatabase(createStatement, database, statements);
  }

  @Override
  public OperationFuture<Database, CreateDatabaseMetadata> createDatabase(
      String instanceId,
      String createDatabaseStatement,
      Dialect dialect,
      Iterable<String> statements)
      throws SpannerException {
    Database database =
        newDatabaseBuilder(DatabaseId.of(projectId, instanceId, "")).setDialect(dialect).build();

    return createDatabase(createDatabaseStatement, database, statements);
  }

  private OperationFuture<Database, CreateDatabaseMetadata> createDatabase(
      String createStatement, Database database, Iterable<String> statements)
      throws SpannerException {
    OperationFuture<com.google.spanner.admin.database.v1.Database, CreateDatabaseMetadata>
        rawOperationFuture =
            rpc.createDatabase(
                database.getId().getInstanceId().getName(), createStatement, statements, database);
    return new OperationFutureImpl<>(
        rawOperationFuture.getPollingFuture(),
        rawOperationFuture.getInitialFuture(),
        snapshot ->
            Database.fromProto(
                ProtoOperationTransformers.ResponseTransformer.create(
                        com.google.spanner.admin.database.v1.Database.class)
                    .apply(snapshot),
                DatabaseAdminClientImpl.this),
        ProtoOperationTransformers.MetadataTransformer.create(CreateDatabaseMetadata.class),
        e -> {
          throw SpannerExceptionFactory.newSpannerException(e);
        });
  }

  @Override
  public Database getDatabase(String instanceId, String databaseId) throws SpannerException {
    String dbName = getDatabaseName(instanceId, databaseId);
    return Database.fromProto(rpc.getDatabase(dbName), DatabaseAdminClientImpl.this);
  }

  @Override
  public OperationFuture<Database, UpdateDatabaseMetadata> updateDatabase(
      Database database, DatabaseField... fieldsToUpdate) throws SpannerException {
    FieldMask fieldMask = DatabaseInfo.DatabaseField.toFieldMask(fieldsToUpdate);
    OperationFuture<com.google.spanner.admin.database.v1.Database, UpdateDatabaseMetadata>
        rawOperationFuture = rpc.updateDatabase(database.toProto(), fieldMask);
    return new OperationFutureImpl<>(
        rawOperationFuture.getPollingFuture(),
        rawOperationFuture.getInitialFuture(),
        snapshot ->
            Database.fromProto(
                ProtoOperationTransformers.ResponseTransformer.create(
                        com.google.spanner.admin.database.v1.Database.class)
                    .apply(snapshot),
                DatabaseAdminClientImpl.this),
        ProtoOperationTransformers.MetadataTransformer.create(UpdateDatabaseMetadata.class),
        e -> {
          throw SpannerExceptionFactory.newSpannerException(e);
        });
  }

  @Override
  public OperationFuture<Void, UpdateDatabaseDdlMetadata> updateDatabaseDdl(
      final String instanceId,
      final String databaseId,
      final Iterable<String> statements,
      @Nullable String operationId)
      throws SpannerException {

    return updateDatabaseDdl(
        newDatabaseBuilder(DatabaseId.of(projectId, instanceId, databaseId)).build(),
        statements,
        operationId);
  }

  @Override
  public OperationFuture<Void, UpdateDatabaseDdlMetadata> updateDatabaseDdl(
      Database database, final Iterable<String> statements, @Nullable String operationId)
      throws SpannerException {
    final String opId = operationId != null ? operationId : randomOperationId();
    OperationFuture<Empty, UpdateDatabaseDdlMetadata> rawOperationFuture =
        rpc.updateDatabaseDdl(database, statements, opId);
    return new OperationFutureImpl<>(
        rawOperationFuture.getPollingFuture(),
        rawOperationFuture.getInitialFuture(),
        snapshot -> {
          ProtoOperationTransformers.ResponseTransformer.create(Empty.class).apply(snapshot);
          return null;
        },
        ProtoOperationTransformers.MetadataTransformer.create(UpdateDatabaseDdlMetadata.class),
        e -> {
          throw SpannerExceptionFactory.newSpannerException(e);
        });
  }

  @Override
  public void dropDatabase(String instanceId, String databaseId) throws SpannerException {
    String dbName = getDatabaseName(instanceId, databaseId);
    rpc.dropDatabase(dbName);
  }

  @Override
  public List<String> getDatabaseDdl(String instanceId, String databaseId) {
    return getDatabaseDdlResponse(instanceId, databaseId).getStatementsList();
  }

  @Override
  public GetDatabaseDdlResponse getDatabaseDdlResponse(String instanceId, String databaseId) {
    String dbName = getDatabaseName(instanceId, databaseId);
    return rpc.getDatabaseDdl(dbName);
  }

  @Override
  public Page<Database> listDatabases(String instanceId, ListOption... options) {
    final String instanceName = getInstanceName(instanceId);
    final Options listOptions = Options.fromListOptions(options);
    Preconditions.checkArgument(
        !listOptions.hasFilter(), "Filter option is not supported by listDatabases");
    final int pageSize = listOptions.hasPageSize() ? listOptions.pageSize() : 0;
    PageFetcher<Database, com.google.spanner.admin.database.v1.Database> pageFetcher =
        new PageFetcher<Database, com.google.spanner.admin.database.v1.Database>() {
          @Override
          public Paginated<com.google.spanner.admin.database.v1.Database> getNextPage(
              String nextPageToken) {
            try {
              return rpc.listDatabases(instanceName, pageSize, nextPageToken);
            } catch (SpannerException e) {
              throw SpannerExceptionFactory.newSpannerException(
                  e.getErrorCode(),
                  String.format(
                      "Failed to list the databases of %s with pageToken %s: %s",
                      instanceName,
                      MoreObjects.firstNonNull(nextPageToken, "<null>"),
                      e.getMessage()),
                  e);
            }
          }

          @Override
          public Database fromProto(com.google.spanner.admin.database.v1.Database proto) {
            return Database.fromProto(proto, DatabaseAdminClientImpl.this);
          }
        };
    if (listOptions.hasPageToken()) {
      pageFetcher.setNextPageToken(listOptions.pageToken());
    }
    return pageFetcher.getNextPage();
  }

  @Override
  public void cancelOperation(String name) {
    Preconditions.checkNotNull(name);
    rpc.cancelOperation(name);
  }

  @Override
  public Operation getOperation(String name) {
    Preconditions.checkNotNull(name);
    return rpc.getOperation(name);
  }

  @Override
  public Policy getDatabaseIAMPolicy(String instanceId, String databaseId, int version) {
    final String databaseName = DatabaseId.of(projectId, instanceId, databaseId).getName();
    GetPolicyOptions options = null;
    if (version > 0) {
      options = GetPolicyOptions.newBuilder().setRequestedPolicyVersion(version).build();
    }
    return policyMarshaller.fromPb(rpc.getDatabaseAdminIAMPolicy(databaseName, options));
  }

  @Override
  public Policy setDatabaseIAMPolicy(String instanceId, String databaseId, Policy policy) {
    Preconditions.checkNotNull(policy);
    String databaseName = DatabaseId.of(projectId, instanceId, databaseId).getName();
    return policyMarshaller.fromPb(
        rpc.setDatabaseAdminIAMPolicy(databaseName, policyMarshaller.toPb(policy)));
  }

  @Override
  public Iterable<String> testDatabaseIAMPermissions(
      String instanceId, String databaseId, Iterable<String> permissions) {
    Preconditions.checkNotNull(permissions);
    String databaseName = DatabaseId.of(projectId, instanceId, databaseId).getName();
    return rpc.testDatabaseAdminIAMPermissions(databaseName, permissions).getPermissionsList();
  }

  @Override
  public Policy getBackupIAMPolicy(String instanceId, String backupId) {
    final String databaseName = BackupId.of(projectId, instanceId, backupId).getName();
    return policyMarshaller.fromPb(rpc.getDatabaseAdminIAMPolicy(databaseName, null));
  }

  @Override
  public Policy setBackupIAMPolicy(String instanceId, String backupId, final Policy policy) {
    Preconditions.checkNotNull(policy);
    final String databaseName = BackupId.of(projectId, instanceId, backupId).getName();
    return policyMarshaller.fromPb(
        rpc.setDatabaseAdminIAMPolicy(databaseName, policyMarshaller.toPb(policy)));
  }

  @Override
  public Iterable<String> testBackupIAMPermissions(
      String instanceId, String backupId, final Iterable<String> permissions) {
    Preconditions.checkNotNull(permissions);
    final String databaseName = BackupId.of(projectId, instanceId, backupId).getName();
    return rpc.testDatabaseAdminIAMPermissions(databaseName, permissions).getPermissionsList();
  }

  private String getInstanceName(String instanceId) {
    return new InstanceId(projectId, instanceId).getName();
  }

  private String getDatabaseName(String instanceId, String databaseId) {
    return new DatabaseId(new InstanceId(projectId, instanceId), databaseId).getName();
  }

  private String getBackupName(String instanceId, String backupId) {
    InstanceId instance = new InstanceId(projectId, instanceId);
    return new BackupId(instance, backupId).getName();
  }
}
