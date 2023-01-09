/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.run.v2.stub;

import static com.google.cloud.run.v2.ExecutionsClient.ListExecutionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.run.v2.DeleteExecutionRequest;
import com.google.cloud.run.v2.Execution;
import com.google.cloud.run.v2.GetExecutionRequest;
import com.google.cloud.run.v2.ListExecutionsRequest;
import com.google.cloud.run.v2.ListExecutionsResponse;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Executions service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcExecutionsStub extends ExecutionsStub {
  private static final MethodDescriptor<GetExecutionRequest, Execution>
      getExecutionMethodDescriptor =
          MethodDescriptor.<GetExecutionRequest, Execution>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.run.v2.Executions/GetExecution")
              .setRequestMarshaller(ProtoUtils.marshaller(GetExecutionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Execution.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListExecutionsRequest, ListExecutionsResponse>
      listExecutionsMethodDescriptor =
          MethodDescriptor.<ListExecutionsRequest, ListExecutionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.run.v2.Executions/ListExecutions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListExecutionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListExecutionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteExecutionRequest, Operation>
      deleteExecutionMethodDescriptor =
          MethodDescriptor.<DeleteExecutionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.run.v2.Executions/DeleteExecution")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteExecutionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetExecutionRequest, Execution> getExecutionCallable;
  private final UnaryCallable<ListExecutionsRequest, ListExecutionsResponse> listExecutionsCallable;
  private final UnaryCallable<ListExecutionsRequest, ListExecutionsPagedResponse>
      listExecutionsPagedCallable;
  private final UnaryCallable<DeleteExecutionRequest, Operation> deleteExecutionCallable;
  private final OperationCallable<DeleteExecutionRequest, Execution, Execution>
      deleteExecutionOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcExecutionsStub create(ExecutionsStubSettings settings)
      throws IOException {
    return new GrpcExecutionsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcExecutionsStub create(ClientContext clientContext) throws IOException {
    return new GrpcExecutionsStub(ExecutionsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcExecutionsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcExecutionsStub(
        ExecutionsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcExecutionsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcExecutionsStub(ExecutionsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcExecutionsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcExecutionsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcExecutionsStub(
      ExecutionsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetExecutionRequest, Execution> getExecutionTransportSettings =
        GrpcCallSettings.<GetExecutionRequest, Execution>newBuilder()
            .setMethodDescriptor(getExecutionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListExecutionsRequest, ListExecutionsResponse>
        listExecutionsTransportSettings =
            GrpcCallSettings.<ListExecutionsRequest, ListExecutionsResponse>newBuilder()
                .setMethodDescriptor(listExecutionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteExecutionRequest, Operation> deleteExecutionTransportSettings =
        GrpcCallSettings.<DeleteExecutionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteExecutionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.getExecutionCallable =
        callableFactory.createUnaryCallable(
            getExecutionTransportSettings, settings.getExecutionSettings(), clientContext);
    this.listExecutionsCallable =
        callableFactory.createUnaryCallable(
            listExecutionsTransportSettings, settings.listExecutionsSettings(), clientContext);
    this.listExecutionsPagedCallable =
        callableFactory.createPagedCallable(
            listExecutionsTransportSettings, settings.listExecutionsSettings(), clientContext);
    this.deleteExecutionCallable =
        callableFactory.createUnaryCallable(
            deleteExecutionTransportSettings, settings.deleteExecutionSettings(), clientContext);
    this.deleteExecutionOperationCallable =
        callableFactory.createOperationCallable(
            deleteExecutionTransportSettings,
            settings.deleteExecutionOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetExecutionRequest, Execution> getExecutionCallable() {
    return getExecutionCallable;
  }

  @Override
  public UnaryCallable<ListExecutionsRequest, ListExecutionsResponse> listExecutionsCallable() {
    return listExecutionsCallable;
  }

  @Override
  public UnaryCallable<ListExecutionsRequest, ListExecutionsPagedResponse>
      listExecutionsPagedCallable() {
    return listExecutionsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteExecutionRequest, Operation> deleteExecutionCallable() {
    return deleteExecutionCallable;
  }

  @Override
  public OperationCallable<DeleteExecutionRequest, Execution, Execution>
      deleteExecutionOperationCallable() {
    return deleteExecutionOperationCallable;
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
