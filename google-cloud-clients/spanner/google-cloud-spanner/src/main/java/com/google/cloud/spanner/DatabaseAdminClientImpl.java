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

import com.google.api.core.ApiFunction;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.longrunning.OperationFutureImpl;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.paging.Page;
import com.google.cloud.spanner.Options.ListOption;
import com.google.cloud.spanner.SpannerImpl.PageFetcher;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.cloud.spanner.spi.v1.SpannerRpc.Paginated;
import com.google.common.base.Preconditions;
import com.google.protobuf.Empty;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

/** Default implementation of {@link DatabaseAdminClient}. */
class DatabaseAdminClientImpl implements DatabaseAdminClient {
  private final String projectId;
  private final SpannerRpc rpc;

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
  public OperationFuture<Database, CreateDatabaseMetadata> createDatabase(
      String instanceId, String databaseId, Iterable<String> statements) throws SpannerException {
    // CreateDatabase() is not idempotent, so we're not retrying this request.
    String instanceName = getInstanceName(instanceId);
    String createStatement = "CREATE DATABASE `" + databaseId + "`";
    OperationFuture<com.google.spanner.admin.database.v1.Database, CreateDatabaseMetadata>
        rawOperationFuture = rpc.createDatabase(instanceName, createStatement, statements);
    return new OperationFutureImpl<Database, CreateDatabaseMetadata>(
        rawOperationFuture.getPollingFuture(),
        rawOperationFuture.getInitialFuture(),
        new ApiFunction<OperationSnapshot, Database>() {
          @Override
          public Database apply(OperationSnapshot snapshot) {
            return Database.fromProto(
                ProtoOperationTransformers.ResponseTransformer.create(
                        com.google.spanner.admin.database.v1.Database.class)
                    .apply(snapshot),
                DatabaseAdminClientImpl.this);
          }
        },
        ProtoOperationTransformers.MetadataTransformer.create(CreateDatabaseMetadata.class),
        new ApiFunction<Exception, Database>() {
          @Override
          public Database apply(Exception e) {
            throw SpannerExceptionFactory.newSpannerException(e);
          }
        });
  }

  @Override
  public Database getDatabase(String instanceId, String databaseId) throws SpannerException {
    final String dbName = getDatabaseName(instanceId, databaseId);
    Callable<Database> callable =
        new Callable<Database>() {
          @Override
          public Database call() throws Exception {
            return Database.fromProto(rpc.getDatabase(dbName), DatabaseAdminClientImpl.this);
          }
        };
    return SpannerImpl.runWithRetries(callable);
  }

  @Override
  public OperationFuture<Void, UpdateDatabaseDdlMetadata> updateDatabaseDdl(
      final String instanceId,
      final String databaseId,
      final Iterable<String> statements,
      @Nullable String operationId)
      throws SpannerException {
    final String dbName = getDatabaseName(instanceId, databaseId);
    final String opId = operationId != null ? operationId : randomOperationId();
    OperationFuture<Empty, UpdateDatabaseDdlMetadata> rawOperationFuture =
        rpc.updateDatabaseDdl(dbName, statements, opId);
    return new OperationFutureImpl<Void, UpdateDatabaseDdlMetadata>(
        rawOperationFuture.getPollingFuture(),
        rawOperationFuture.getInitialFuture(),
        new ApiFunction<OperationSnapshot, Void>() {
          @Override
          public Void apply(OperationSnapshot snapshot) {
            ProtoOperationTransformers.ResponseTransformer.create(Empty.class).apply(snapshot);
            return null;
          }
        },
        ProtoOperationTransformers.MetadataTransformer.create(UpdateDatabaseDdlMetadata.class),
        new ApiFunction<Exception, Void>() {
          @Override
          public Void apply(Exception e) {
            throw SpannerExceptionFactory.newSpannerException(e);
          }
        });
  }

  @Override
  public void dropDatabase(String instanceId, String databaseId) throws SpannerException {
    final String dbName = getDatabaseName(instanceId, databaseId);
    Callable<Void> callable =
        new Callable<Void>() {
          @Override
          public Void call() throws Exception {
            rpc.dropDatabase(dbName);
            return null;
          }
        };
    SpannerImpl.runWithRetries(callable);
  }

  @Override
  public List<String> getDatabaseDdl(String instanceId, String databaseId) {
    final String dbName = getDatabaseName(instanceId, databaseId);
    Callable<List<String>> callable =
        new Callable<List<String>>() {
          @Override
          public List<String> call() throws Exception {
            return rpc.getDatabaseDdl(dbName);
          }
        };
    return SpannerImpl.runWithRetries(callable);
  }

  @Override
  public Page<Database> listDatabases(String instanceId, ListOption... options) {
    final String instanceName = getInstanceName(instanceId);
    final Options listOptions = Options.fromListOptions(options);
    Preconditions.checkArgument(
        !listOptions.hasFilter(), "Filter option is not support by" + "listDatabases");
    final int pageSize = listOptions.hasPageSize() ? listOptions.pageSize() : 0;
    PageFetcher<Database, com.google.spanner.admin.database.v1.Database> pageFetcher =
        new PageFetcher<Database, com.google.spanner.admin.database.v1.Database>() {
          @Override
          public Paginated<com.google.spanner.admin.database.v1.Database> getNextPage(
              String nextPageToken) {
            return rpc.listDatabases(instanceName, pageSize, nextPageToken);
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

  private String getInstanceName(String instanceId) {
    return new InstanceId(projectId, instanceId).getName();
  }

  private String getDatabaseName(String instanceId, String databaseId) {
    return new DatabaseId(new InstanceId(projectId, instanceId), databaseId).getName();
  }
}
