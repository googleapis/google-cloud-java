/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.workflows.executions.v1beta.stub;

import static com.google.cloud.workflows.executions.v1beta.ExecutionsClient.ListExecutionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.workflows.executions.v1beta.CancelExecutionRequest;
import com.google.cloud.workflows.executions.v1beta.CreateExecutionRequest;
import com.google.cloud.workflows.executions.v1beta.Execution;
import com.google.cloud.workflows.executions.v1beta.GetExecutionRequest;
import com.google.cloud.workflows.executions.v1beta.ListExecutionsRequest;
import com.google.cloud.workflows.executions.v1beta.ListExecutionsResponse;
import com.google.common.collect.ImmutableMap;
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
  private static final MethodDescriptor<ListExecutionsRequest, ListExecutionsResponse>
      listExecutionsMethodDescriptor =
          MethodDescriptor.<ListExecutionsRequest, ListExecutionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.workflows.executions.v1beta.Executions/ListExecutions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListExecutionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListExecutionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateExecutionRequest, Execution>
      createExecutionMethodDescriptor =
          MethodDescriptor.<CreateExecutionRequest, Execution>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.workflows.executions.v1beta.Executions/CreateExecution")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateExecutionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Execution.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetExecutionRequest, Execution>
      getExecutionMethodDescriptor =
          MethodDescriptor.<GetExecutionRequest, Execution>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workflows.executions.v1beta.Executions/GetExecution")
              .setRequestMarshaller(ProtoUtils.marshaller(GetExecutionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Execution.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CancelExecutionRequest, Execution>
      cancelExecutionMethodDescriptor =
          MethodDescriptor.<CancelExecutionRequest, Execution>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.workflows.executions.v1beta.Executions/CancelExecution")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CancelExecutionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Execution.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListExecutionsRequest, ListExecutionsResponse> listExecutionsCallable;
  private final UnaryCallable<ListExecutionsRequest, ListExecutionsPagedResponse>
      listExecutionsPagedCallable;
  private final UnaryCallable<CreateExecutionRequest, Execution> createExecutionCallable;
  private final UnaryCallable<GetExecutionRequest, Execution> getExecutionCallable;
  private final UnaryCallable<CancelExecutionRequest, Execution> cancelExecutionCallable;

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

    GrpcCallSettings<ListExecutionsRequest, ListExecutionsResponse>
        listExecutionsTransportSettings =
            GrpcCallSettings.<ListExecutionsRequest, ListExecutionsResponse>newBuilder()
                .setMethodDescriptor(listExecutionsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListExecutionsRequest>() {
                      @Override
                      public Map<String, String> extract(ListExecutionsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CreateExecutionRequest, Execution> createExecutionTransportSettings =
        GrpcCallSettings.<CreateExecutionRequest, Execution>newBuilder()
            .setMethodDescriptor(createExecutionMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateExecutionRequest>() {
                  @Override
                  public Map<String, String> extract(CreateExecutionRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetExecutionRequest, Execution> getExecutionTransportSettings =
        GrpcCallSettings.<GetExecutionRequest, Execution>newBuilder()
            .setMethodDescriptor(getExecutionMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetExecutionRequest>() {
                  @Override
                  public Map<String, String> extract(GetExecutionRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CancelExecutionRequest, Execution> cancelExecutionTransportSettings =
        GrpcCallSettings.<CancelExecutionRequest, Execution>newBuilder()
            .setMethodDescriptor(cancelExecutionMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CancelExecutionRequest>() {
                  @Override
                  public Map<String, String> extract(CancelExecutionRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();

    this.listExecutionsCallable =
        callableFactory.createUnaryCallable(
            listExecutionsTransportSettings, settings.listExecutionsSettings(), clientContext);
    this.listExecutionsPagedCallable =
        callableFactory.createPagedCallable(
            listExecutionsTransportSettings, settings.listExecutionsSettings(), clientContext);
    this.createExecutionCallable =
        callableFactory.createUnaryCallable(
            createExecutionTransportSettings, settings.createExecutionSettings(), clientContext);
    this.getExecutionCallable =
        callableFactory.createUnaryCallable(
            getExecutionTransportSettings, settings.getExecutionSettings(), clientContext);
    this.cancelExecutionCallable =
        callableFactory.createUnaryCallable(
            cancelExecutionTransportSettings, settings.cancelExecutionSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<ListExecutionsRequest, ListExecutionsResponse> listExecutionsCallable() {
    return listExecutionsCallable;
  }

  public UnaryCallable<ListExecutionsRequest, ListExecutionsPagedResponse>
      listExecutionsPagedCallable() {
    return listExecutionsPagedCallable;
  }

  public UnaryCallable<CreateExecutionRequest, Execution> createExecutionCallable() {
    return createExecutionCallable;
  }

  public UnaryCallable<GetExecutionRequest, Execution> getExecutionCallable() {
    return getExecutionCallable;
  }

  public UnaryCallable<CancelExecutionRequest, Execution> cancelExecutionCallable() {
    return cancelExecutionCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
