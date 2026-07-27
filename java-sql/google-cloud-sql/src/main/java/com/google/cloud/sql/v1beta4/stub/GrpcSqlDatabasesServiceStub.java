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

package com.google.cloud.sql.v1beta4.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.sql.v1beta4.Database;
import com.google.cloud.sql.v1beta4.DatabasesListResponse;
import com.google.cloud.sql.v1beta4.Operation;
import com.google.cloud.sql.v1beta4.SqlDatabasesDeleteRequest;
import com.google.cloud.sql.v1beta4.SqlDatabasesGetRequest;
import com.google.cloud.sql.v1beta4.SqlDatabasesInsertRequest;
import com.google.cloud.sql.v1beta4.SqlDatabasesListRequest;
import com.google.cloud.sql.v1beta4.SqlDatabasesUpdateRequest;
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
 * gRPC stub implementation for the SqlDatabasesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcSqlDatabasesServiceStub extends SqlDatabasesServiceStub {
  private static final MethodDescriptor<SqlDatabasesDeleteRequest, Operation>
      deleteMethodDescriptor =
          MethodDescriptor.<SqlDatabasesDeleteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1beta4.SqlDatabasesService/Delete")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlDatabasesDeleteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlDatabasesGetRequest, Database> getMethodDescriptor =
      MethodDescriptor.<SqlDatabasesGetRequest, Database>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.sql.v1beta4.SqlDatabasesService/Get")
          .setRequestMarshaller(ProtoUtils.marshaller(SqlDatabasesGetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Database.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<SqlDatabasesInsertRequest, Operation>
      insertMethodDescriptor =
          MethodDescriptor.<SqlDatabasesInsertRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1beta4.SqlDatabasesService/Insert")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlDatabasesInsertRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlDatabasesListRequest, DatabasesListResponse>
      listMethodDescriptor =
          MethodDescriptor.<SqlDatabasesListRequest, DatabasesListResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1beta4.SqlDatabasesService/List")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlDatabasesListRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DatabasesListResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlDatabasesUpdateRequest, Operation>
      patchMethodDescriptor =
          MethodDescriptor.<SqlDatabasesUpdateRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1beta4.SqlDatabasesService/Patch")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlDatabasesUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlDatabasesUpdateRequest, Operation>
      updateMethodDescriptor =
          MethodDescriptor.<SqlDatabasesUpdateRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1beta4.SqlDatabasesService/Update")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlDatabasesUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<SqlDatabasesDeleteRequest, Operation> deleteCallable;
  private final UnaryCallable<SqlDatabasesGetRequest, Database> getCallable;
  private final UnaryCallable<SqlDatabasesInsertRequest, Operation> insertCallable;
  private final UnaryCallable<SqlDatabasesListRequest, DatabasesListResponse> listCallable;
  private final UnaryCallable<SqlDatabasesUpdateRequest, Operation> patchCallable;
  private final UnaryCallable<SqlDatabasesUpdateRequest, Operation> updateCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  private static final PathTemplate DELETE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}/databases/{database}");
  private static final PathTemplate GET_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}/databases/{database}");
  private static final PathTemplate INSERT_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate LIST_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");
  private static final PathTemplate PATCH_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}/databases/{database}");
  private static final PathTemplate UPDATE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}/databases/{database}");

  public static final GrpcSqlDatabasesServiceStub create(SqlDatabasesServiceStubSettings settings)
      throws IOException {
    return new GrpcSqlDatabasesServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSqlDatabasesServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSqlDatabasesServiceStub(
        SqlDatabasesServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSqlDatabasesServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSqlDatabasesServiceStub(
        SqlDatabasesServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSqlDatabasesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSqlDatabasesServiceStub(
      SqlDatabasesServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcSqlDatabasesServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSqlDatabasesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSqlDatabasesServiceStub(
      SqlDatabasesServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<SqlDatabasesDeleteRequest, Operation> deleteTransportSettings =
        GrpcCallSettings.<SqlDatabasesDeleteRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database", String.valueOf(request.getDatabase()));
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("database", String.valueOf(request.getDatabase()));
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return DELETE_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlDatabasesGetRequest, Database> getTransportSettings =
        GrpcCallSettings.<SqlDatabasesGetRequest, Database>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database", String.valueOf(request.getDatabase()));
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("database", String.valueOf(request.getDatabase()));
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return GET_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlDatabasesInsertRequest, Operation> insertTransportSettings =
        GrpcCallSettings.<SqlDatabasesInsertRequest, Operation>newBuilder()
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
    GrpcCallSettings<SqlDatabasesListRequest, DatabasesListResponse> listTransportSettings =
        GrpcCallSettings.<SqlDatabasesListRequest, DatabasesListResponse>newBuilder()
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
    GrpcCallSettings<SqlDatabasesUpdateRequest, Operation> patchTransportSettings =
        GrpcCallSettings.<SqlDatabasesUpdateRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database", String.valueOf(request.getDatabase()));
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("database", String.valueOf(request.getDatabase()));
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return PATCH_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlDatabasesUpdateRequest, Operation> updateTransportSettings =
        GrpcCallSettings.<SqlDatabasesUpdateRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database", String.valueOf(request.getDatabase()));
                  builder.add("instance", String.valueOf(request.getInstance()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("database", String.valueOf(request.getDatabase()));
                  resourceNameSegments.put("instance", String.valueOf(request.getInstance()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return UPDATE_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
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
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
    this.updateCallable =
        callableFactory.createUnaryCallable(
            updateTransportSettings, settings.updateSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<SqlDatabasesDeleteRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<SqlDatabasesGetRequest, Database> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<SqlDatabasesInsertRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<SqlDatabasesListRequest, DatabasesListResponse> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<SqlDatabasesUpdateRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public UnaryCallable<SqlDatabasesUpdateRequest, Operation> updateCallable() {
    return updateCallable;
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
