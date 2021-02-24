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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.EndpointServiceClient.ListEndpointsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.CreateEndpointOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateEndpointRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteEndpointRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeployModelOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeployModelRequest;
import com.google.cloud.aiplatform.v1beta1.DeployModelResponse;
import com.google.cloud.aiplatform.v1beta1.Endpoint;
import com.google.cloud.aiplatform.v1beta1.GetEndpointRequest;
import com.google.cloud.aiplatform.v1beta1.ListEndpointsRequest;
import com.google.cloud.aiplatform.v1beta1.ListEndpointsResponse;
import com.google.cloud.aiplatform.v1beta1.UndeployModelOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UndeployModelRequest;
import com.google.cloud.aiplatform.v1beta1.UndeployModelResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateEndpointRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the EndpointService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcEndpointServiceStub extends EndpointServiceStub {
  private static final MethodDescriptor<CreateEndpointRequest, Operation>
      createEndpointMethodDescriptor =
          MethodDescriptor.<CreateEndpointRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.EndpointService/CreateEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetEndpointRequest, Endpoint> getEndpointMethodDescriptor =
      MethodDescriptor.<GetEndpointRequest, Endpoint>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.EndpointService/GetEndpoint")
          .setRequestMarshaller(ProtoUtils.marshaller(GetEndpointRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Endpoint.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListEndpointsRequest, ListEndpointsResponse>
      listEndpointsMethodDescriptor =
          MethodDescriptor.<ListEndpointsRequest, ListEndpointsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.EndpointService/ListEndpoints")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEndpointsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEndpointsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateEndpointRequest, Endpoint>
      updateEndpointMethodDescriptor =
          MethodDescriptor.<UpdateEndpointRequest, Endpoint>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.EndpointService/UpdateEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Endpoint.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteEndpointRequest, Operation>
      deleteEndpointMethodDescriptor =
          MethodDescriptor.<DeleteEndpointRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.EndpointService/DeleteEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeployModelRequest, Operation> deployModelMethodDescriptor =
      MethodDescriptor.<DeployModelRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.EndpointService/DeployModel")
          .setRequestMarshaller(ProtoUtils.marshaller(DeployModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UndeployModelRequest, Operation>
      undeployModelMethodDescriptor =
          MethodDescriptor.<UndeployModelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.EndpointService/UndeployModel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeployModelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateEndpointRequest, Operation> createEndpointCallable;
  private final OperationCallable<CreateEndpointRequest, Endpoint, CreateEndpointOperationMetadata>
      createEndpointOperationCallable;
  private final UnaryCallable<GetEndpointRequest, Endpoint> getEndpointCallable;
  private final UnaryCallable<ListEndpointsRequest, ListEndpointsResponse> listEndpointsCallable;
  private final UnaryCallable<ListEndpointsRequest, ListEndpointsPagedResponse>
      listEndpointsPagedCallable;
  private final UnaryCallable<UpdateEndpointRequest, Endpoint> updateEndpointCallable;
  private final UnaryCallable<DeleteEndpointRequest, Operation> deleteEndpointCallable;
  private final OperationCallable<DeleteEndpointRequest, Empty, DeleteOperationMetadata>
      deleteEndpointOperationCallable;
  private final UnaryCallable<DeployModelRequest, Operation> deployModelCallable;
  private final OperationCallable<
          DeployModelRequest, DeployModelResponse, DeployModelOperationMetadata>
      deployModelOperationCallable;
  private final UnaryCallable<UndeployModelRequest, Operation> undeployModelCallable;
  private final OperationCallable<
          UndeployModelRequest, UndeployModelResponse, UndeployModelOperationMetadata>
      undeployModelOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcEndpointServiceStub create(EndpointServiceStubSettings settings)
      throws IOException {
    return new GrpcEndpointServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcEndpointServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcEndpointServiceStub(
        EndpointServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcEndpointServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcEndpointServiceStub(
        EndpointServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcEndpointServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcEndpointServiceStub(
      EndpointServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcEndpointServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcEndpointServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcEndpointServiceStub(
      EndpointServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateEndpointRequest, Operation> createEndpointTransportSettings =
        GrpcCallSettings.<CreateEndpointRequest, Operation>newBuilder()
            .setMethodDescriptor(createEndpointMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateEndpointRequest>() {
                  @Override
                  public Map<String, String> extract(CreateEndpointRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetEndpointRequest, Endpoint> getEndpointTransportSettings =
        GrpcCallSettings.<GetEndpointRequest, Endpoint>newBuilder()
            .setMethodDescriptor(getEndpointMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetEndpointRequest>() {
                  @Override
                  public Map<String, String> extract(GetEndpointRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListEndpointsRequest, ListEndpointsResponse> listEndpointsTransportSettings =
        GrpcCallSettings.<ListEndpointsRequest, ListEndpointsResponse>newBuilder()
            .setMethodDescriptor(listEndpointsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListEndpointsRequest>() {
                  @Override
                  public Map<String, String> extract(ListEndpointsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateEndpointRequest, Endpoint> updateEndpointTransportSettings =
        GrpcCallSettings.<UpdateEndpointRequest, Endpoint>newBuilder()
            .setMethodDescriptor(updateEndpointMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateEndpointRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateEndpointRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("endpoint.name", String.valueOf(request.getEndpoint().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteEndpointRequest, Operation> deleteEndpointTransportSettings =
        GrpcCallSettings.<DeleteEndpointRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEndpointMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteEndpointRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteEndpointRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeployModelRequest, Operation> deployModelTransportSettings =
        GrpcCallSettings.<DeployModelRequest, Operation>newBuilder()
            .setMethodDescriptor(deployModelMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeployModelRequest>() {
                  @Override
                  public Map<String, String> extract(DeployModelRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("endpoint", String.valueOf(request.getEndpoint()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UndeployModelRequest, Operation> undeployModelTransportSettings =
        GrpcCallSettings.<UndeployModelRequest, Operation>newBuilder()
            .setMethodDescriptor(undeployModelMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UndeployModelRequest>() {
                  @Override
                  public Map<String, String> extract(UndeployModelRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("endpoint", String.valueOf(request.getEndpoint()));
                    return params.build();
                  }
                })
            .build();

    this.createEndpointCallable =
        callableFactory.createUnaryCallable(
            createEndpointTransportSettings, settings.createEndpointSettings(), clientContext);
    this.createEndpointOperationCallable =
        callableFactory.createOperationCallable(
            createEndpointTransportSettings,
            settings.createEndpointOperationSettings(),
            clientContext,
            operationsStub);
    this.getEndpointCallable =
        callableFactory.createUnaryCallable(
            getEndpointTransportSettings, settings.getEndpointSettings(), clientContext);
    this.listEndpointsCallable =
        callableFactory.createUnaryCallable(
            listEndpointsTransportSettings, settings.listEndpointsSettings(), clientContext);
    this.listEndpointsPagedCallable =
        callableFactory.createPagedCallable(
            listEndpointsTransportSettings, settings.listEndpointsSettings(), clientContext);
    this.updateEndpointCallable =
        callableFactory.createUnaryCallable(
            updateEndpointTransportSettings, settings.updateEndpointSettings(), clientContext);
    this.deleteEndpointCallable =
        callableFactory.createUnaryCallable(
            deleteEndpointTransportSettings, settings.deleteEndpointSettings(), clientContext);
    this.deleteEndpointOperationCallable =
        callableFactory.createOperationCallable(
            deleteEndpointTransportSettings,
            settings.deleteEndpointOperationSettings(),
            clientContext,
            operationsStub);
    this.deployModelCallable =
        callableFactory.createUnaryCallable(
            deployModelTransportSettings, settings.deployModelSettings(), clientContext);
    this.deployModelOperationCallable =
        callableFactory.createOperationCallable(
            deployModelTransportSettings,
            settings.deployModelOperationSettings(),
            clientContext,
            operationsStub);
    this.undeployModelCallable =
        callableFactory.createUnaryCallable(
            undeployModelTransportSettings, settings.undeployModelSettings(), clientContext);
    this.undeployModelOperationCallable =
        callableFactory.createOperationCallable(
            undeployModelTransportSettings,
            settings.undeployModelOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateEndpointRequest, Operation> createEndpointCallable() {
    return createEndpointCallable;
  }

  @Override
  public OperationCallable<CreateEndpointRequest, Endpoint, CreateEndpointOperationMetadata>
      createEndpointOperationCallable() {
    return createEndpointOperationCallable;
  }

  @Override
  public UnaryCallable<GetEndpointRequest, Endpoint> getEndpointCallable() {
    return getEndpointCallable;
  }

  @Override
  public UnaryCallable<ListEndpointsRequest, ListEndpointsResponse> listEndpointsCallable() {
    return listEndpointsCallable;
  }

  @Override
  public UnaryCallable<ListEndpointsRequest, ListEndpointsPagedResponse>
      listEndpointsPagedCallable() {
    return listEndpointsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateEndpointRequest, Endpoint> updateEndpointCallable() {
    return updateEndpointCallable;
  }

  @Override
  public UnaryCallable<DeleteEndpointRequest, Operation> deleteEndpointCallable() {
    return deleteEndpointCallable;
  }

  @Override
  public OperationCallable<DeleteEndpointRequest, Empty, DeleteOperationMetadata>
      deleteEndpointOperationCallable() {
    return deleteEndpointOperationCallable;
  }

  @Override
  public UnaryCallable<DeployModelRequest, Operation> deployModelCallable() {
    return deployModelCallable;
  }

  @Override
  public OperationCallable<DeployModelRequest, DeployModelResponse, DeployModelOperationMetadata>
      deployModelOperationCallable() {
    return deployModelOperationCallable;
  }

  @Override
  public UnaryCallable<UndeployModelRequest, Operation> undeployModelCallable() {
    return undeployModelCallable;
  }

  @Override
  public OperationCallable<
          UndeployModelRequest, UndeployModelResponse, UndeployModelOperationMetadata>
      undeployModelOperationCallable() {
    return undeployModelOperationCallable;
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
