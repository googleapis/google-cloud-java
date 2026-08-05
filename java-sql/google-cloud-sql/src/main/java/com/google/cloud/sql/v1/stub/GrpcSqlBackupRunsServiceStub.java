/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.sql.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.sql.v1.BackupRun;
import com.google.cloud.sql.v1.BackupRunsListResponse;
import com.google.cloud.sql.v1.Operation;
import com.google.cloud.sql.v1.SqlBackupRunsDeleteRequest;
import com.google.cloud.sql.v1.SqlBackupRunsGetRequest;
import com.google.cloud.sql.v1.SqlBackupRunsInsertRequest;
import com.google.cloud.sql.v1.SqlBackupRunsListRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SqlBackupRunsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcSqlBackupRunsServiceStub extends SqlBackupRunsServiceStub {
  private static final MethodDescriptor<SqlBackupRunsDeleteRequest, Operation>
      deleteMethodDescriptor =
          MethodDescriptor.<SqlBackupRunsDeleteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlBackupRunsService/Delete")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlBackupRunsDeleteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlBackupRunsGetRequest, BackupRun> getMethodDescriptor =
      MethodDescriptor.<SqlBackupRunsGetRequest, BackupRun>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.sql.v1.SqlBackupRunsService/Get")
          .setRequestMarshaller(ProtoUtils.marshaller(SqlBackupRunsGetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(BackupRun.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<SqlBackupRunsInsertRequest, Operation>
      insertMethodDescriptor =
          MethodDescriptor.<SqlBackupRunsInsertRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlBackupRunsService/Insert")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlBackupRunsInsertRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlBackupRunsListRequest, BackupRunsListResponse>
      listMethodDescriptor =
          MethodDescriptor.<SqlBackupRunsListRequest, BackupRunsListResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1.SqlBackupRunsService/List")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlBackupRunsListRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BackupRunsListResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<SqlBackupRunsDeleteRequest, Operation> deleteCallable;
  private final UnaryCallable<SqlBackupRunsGetRequest, BackupRun> getCallable;
  private final UnaryCallable<SqlBackupRunsInsertRequest, Operation> insertCallable;
  private final UnaryCallable<SqlBackupRunsListRequest, BackupRunsListResponse> listCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  private static final PathTemplate DELETE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}/backupRuns/{id}");
  private static final PathTemplate GET_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}/backupRuns/{id}");
  private static final PathTemplate INSERT_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate LIST_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");

  public static final GrpcSqlBackupRunsServiceStub create(SqlBackupRunsServiceStubSettings settings)
      throws IOException {
    return new GrpcSqlBackupRunsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSqlBackupRunsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSqlBackupRunsServiceStub(
        SqlBackupRunsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSqlBackupRunsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSqlBackupRunsServiceStub(
        SqlBackupRunsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSqlBackupRunsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSqlBackupRunsServiceStub(
      SqlBackupRunsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcSqlBackupRunsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSqlBackupRunsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSqlBackupRunsServiceStub(
      SqlBackupRunsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<SqlBackupRunsDeleteRequest, Operation> deleteTransportSettings =
        GrpcCallSettings.<SqlBackupRunsDeleteRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("id", String.valueOf(request.getId()));
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("id", String.valueOf(request.getId()));
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return DELETE_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlBackupRunsGetRequest, BackupRun> getTransportSettings =
        GrpcCallSettings.<SqlBackupRunsGetRequest, BackupRun>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("id", String.valueOf(request.getId()));
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("id", String.valueOf(request.getId()));
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return GET_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlBackupRunsInsertRequest, Operation> insertTransportSettings =
        GrpcCallSettings.<SqlBackupRunsInsertRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return INSERT_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlBackupRunsListRequest, BackupRunsListResponse> listTransportSettings =
        GrpcCallSettings.<SqlBackupRunsListRequest, BackupRunsListResponse>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return LIST_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();

    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<SqlBackupRunsDeleteRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<SqlBackupRunsGetRequest, BackupRun> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<SqlBackupRunsInsertRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<SqlBackupRunsListRequest, BackupRunsListResponse> listCallable() {
    return listCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
