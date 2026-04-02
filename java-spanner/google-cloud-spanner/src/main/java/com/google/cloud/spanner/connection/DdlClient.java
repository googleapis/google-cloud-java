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

package com.google.cloud.spanner.connection;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.MissingDefaultSequenceKindException;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Convenience class for executing Data Definition Language statements on transactions that support
 * DDL statements, i.e. DdlBatchTransaction and SingleUseTransaction.
 */
class DdlClient {
  private final DatabaseAdminClient dbAdminClient;
  private final Supplier<Dialect> dialectSupplier;
  private final String projectId;
  private final String instanceId;
  private final String databaseName;

  static class Builder {
    private DatabaseAdminClient dbAdminClient;
    private Supplier<Dialect> dialectSupplier;
    private String projectId;
    private String instanceId;
    private String databaseName;

    private Builder() {}

    Builder setDatabaseAdminClient(DatabaseAdminClient client) {
      Preconditions.checkNotNull(client);
      this.dbAdminClient = client;
      return this;
    }

    Builder setDialectSupplier(Supplier<Dialect> dialectSupplier) {
      this.dialectSupplier = Preconditions.checkNotNull(dialectSupplier);
      return this;
    }

    Builder setProjectId(String projectId) {
      Preconditions.checkArgument(
          !Strings.isNullOrEmpty(projectId), "Empty projectId is not allowed");
      this.projectId = projectId;
      return this;
    }

    Builder setInstanceId(String instanceId) {
      Preconditions.checkArgument(
          !Strings.isNullOrEmpty(instanceId), "Empty instanceId is not allowed");
      this.instanceId = instanceId;
      return this;
    }

    Builder setDatabaseName(String name) {
      Preconditions.checkArgument(
          !Strings.isNullOrEmpty(name), "Empty database name is not allowed");
      this.databaseName = name;
      return this;
    }

    DdlClient build() {
      Preconditions.checkState(dbAdminClient != null, "No DatabaseAdminClient specified");
      Preconditions.checkState(dialectSupplier != null, "No dialect supplier specified");
      Preconditions.checkState(!Strings.isNullOrEmpty(projectId), "No ProjectId specified");
      Preconditions.checkState(!Strings.isNullOrEmpty(instanceId), "No InstanceId specified");
      Preconditions.checkArgument(
          !Strings.isNullOrEmpty(databaseName), "No database name specified");
      return new DdlClient(this);
    }
  }

  static Builder newBuilder() {
    return new Builder();
  }

  private DdlClient(Builder builder) {
    this.dbAdminClient = builder.dbAdminClient;
    this.dialectSupplier = builder.dialectSupplier;
    this.projectId = builder.projectId;
    this.instanceId = builder.instanceId;
    this.databaseName = builder.databaseName;
  }

  OperationFuture<Database, CreateDatabaseMetadata> executeCreateDatabase(
      String createStatement, Dialect dialect) {
    Preconditions.checkArgument(isCreateDatabaseStatement(dialect, createStatement));
    return dbAdminClient.createDatabase(
        instanceId, createStatement, dialect, Collections.emptyList());
  }

  /** Execute a single DDL statement. */
  OperationFuture<Void, UpdateDatabaseDdlMetadata> executeDdl(String ddl, byte[] protoDescriptors) {
    return executeDdl(Collections.singletonList(ddl), protoDescriptors);
  }

  /** Execute a list of DDL statements as one operation. */
  OperationFuture<Void, UpdateDatabaseDdlMetadata> executeDdl(
      List<String> statements, byte[] protoDescriptors) {
    if (statements.stream()
        .anyMatch(sql -> isCreateDatabaseStatement(this.dialectSupplier.get(), sql))) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT, "CREATE DATABASE is not supported in a DDL batch");
    }
    Database.Builder dbBuilder =
        dbAdminClient.newDatabaseBuilder(DatabaseId.of(projectId, instanceId, databaseName));
    if (protoDescriptors != null) {
      dbBuilder.setProtoDescriptors(protoDescriptors);
    }
    Database db = dbBuilder.build();
    return dbAdminClient.updateDatabaseDdl(
        db,
        statements.stream().map(DdlClient::stripTrailingSemicolon).collect(Collectors.toList()),
        null);
  }

  static String stripTrailingSemicolon(String input) {
    if (!input.contains(";")) {
      return input;
    }
    String trimmed = input.trim();
    if (trimmed.endsWith(";")) {
      return trimmed.substring(0, trimmed.length() - 1);
    }
    return input;
  }

  /** Returns true if the statement is a `CREATE DATABASE ...` statement. */
  static boolean isCreateDatabaseStatement(Dialect dialect, String statement) {
    SimpleParser parser = new SimpleParser(dialect, statement);
    return parser.eatKeyword("create", "database");
  }

  void runWithRetryForMissingDefaultSequenceKind(
      Consumer<Integer> runnable,
      String defaultSequenceKind,
      Dialect dialect,
      AtomicReference<OperationFuture<Void, UpdateDatabaseDdlMetadata>> operationReference) {
    try {
      runnable.accept(0);
    } catch (Throwable t) {
      SpannerException spannerException = SpannerExceptionFactory.asSpannerException(t);
      if (!Strings.isNullOrEmpty(defaultSequenceKind)
          && spannerException instanceof MissingDefaultSequenceKindException) {
        setDefaultSequenceKind(defaultSequenceKind, dialect);
        int restartIndex = 0;
        if (operationReference.get() != null) {
          try {
            UpdateDatabaseDdlMetadata metadata = operationReference.get().getMetadata().get();
            restartIndex = metadata.getCommitTimestampsCount();
          } catch (Throwable ignore) {
          }
        }
        runnable.accept(restartIndex);
        return;
      }
      throw t;
    }
  }

  private void setDefaultSequenceKind(String defaultSequenceKind, Dialect dialect) {
    String ddl =
        dialect == Dialect.POSTGRESQL
            ? "alter database \"%s\" set spanner.default_sequence_kind = '%s'"
            : "alter database `%s` set options (default_sequence_kind='%s')";
    ddl = String.format(ddl, databaseName, defaultSequenceKind);
    try {
      executeDdl(ddl, null).get();
    } catch (ExecutionException executionException) {
      throw SpannerExceptionFactory.asSpannerException(executionException.getCause());
    } catch (InterruptedException interruptedException) {
      throw SpannerExceptionFactory.propagateInterrupt(interruptedException);
    }
  }
}
