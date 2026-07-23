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
import com.google.cloud.sql.v1beta4.Operation;
import com.google.cloud.sql.v1beta4.OperationsListResponse;
import com.google.cloud.sql.v1beta4.SqlOperationsCancelRequest;
import com.google.cloud.sql.v1beta4.SqlOperationsGetRequest;
import com.google.cloud.sql.v1beta4.SqlOperationsListRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
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
 * gRPC stub implementation for the SqlOperationsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcSqlOperationsServiceStub extends SqlOperationsServiceStub {
  private static final MethodDescriptor<SqlOperationsGetRequest, Operation> getMethodDescriptor =
      MethodDescriptor.<SqlOperationsGetRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.sql.v1beta4.SqlOperationsService/Get")
          .setRequestMarshaller(ProtoUtils.marshaller(SqlOperationsGetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<SqlOperationsListRequest, OperationsListResponse>
      listMethodDescriptor =
          MethodDescriptor.<SqlOperationsListRequest, OperationsListResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1beta4.SqlOperationsService/List")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SqlOperationsListRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(OperationsListResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SqlOperationsCancelRequest, Empty> cancelMethodDescriptor =
      MethodDescriptor.<SqlOperationsCancelRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.sql.v1beta4.SqlOperationsService/Cancel")
          .setRequestMarshaller(
              ProtoUtils.marshaller(SqlOperationsCancelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private final UnaryCallable<SqlOperationsGetRequest, Operation> getCallable;
  private final UnaryCallable<SqlOperationsListRequest, OperationsListResponse> listCallable;
  private final UnaryCallable<SqlOperationsCancelRequest, Empty> cancelCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  private static final PathTemplate GET_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/operations/{operation}");
  private static final PathTemplate LIST_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}");
  private static final PathTemplate CANCEL_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/operations/{operation}");

  public static final GrpcSqlOperationsServiceStub create(SqlOperationsServiceStubSettings settings)
      throws IOException {
    return new GrpcSqlOperationsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSqlOperationsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSqlOperationsServiceStub(
        SqlOperationsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSqlOperationsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSqlOperationsServiceStub(
        SqlOperationsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSqlOperationsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSqlOperationsServiceStub(
      SqlOperationsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcSqlOperationsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSqlOperationsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSqlOperationsServiceStub(
      SqlOperationsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<SqlOperationsGetRequest, Operation> getTransportSettings =
        GrpcCallSettings.<SqlOperationsGetRequest, Operation>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("operation", String.valueOf(request.getOperation()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("operation", String.valueOf(request.getOperation()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return GET_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlOperationsListRequest, OperationsListResponse> listTransportSettings =
        GrpcCallSettings.<SqlOperationsListRequest, OperationsListResponse>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return LIST_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    GrpcCallSettings<SqlOperationsCancelRequest, Empty> cancelTransportSettings =
        GrpcCallSettings.<SqlOperationsCancelRequest, Empty>newBuilder()
            .setMethodDescriptor(cancelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("operation", String.valueOf(request.getOperation()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("operation", String.valueOf(request.getOperation()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  return CANCEL_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();

    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.cancelCallable =
        callableFactory.createUnaryCallable(
            cancelTransportSettings, settings.cancelSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<SqlOperationsGetRequest, Operation> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<SqlOperationsListRequest, OperationsListResponse> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<SqlOperationsCancelRequest, Empty> cancelCallable() {
    return cancelCallable;
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
