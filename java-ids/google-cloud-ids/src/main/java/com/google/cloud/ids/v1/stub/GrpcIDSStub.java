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

package com.google.cloud.ids.v1.stub;

import static com.google.cloud.ids.v1.IDSClient.ListEndpointsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.ids.v1.CreateEndpointRequest;
import com.google.cloud.ids.v1.DeleteEndpointRequest;
import com.google.cloud.ids.v1.Endpoint;
import com.google.cloud.ids.v1.GetEndpointRequest;
import com.google.cloud.ids.v1.ListEndpointsRequest;
import com.google.cloud.ids.v1.ListEndpointsResponse;
import com.google.cloud.ids.v1.OperationMetadata;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the IDS service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcIDSStub extends IDSStub {
  private static final MethodDescriptor<ListEndpointsRequest, ListEndpointsResponse>
      listEndpointsMethodDescriptor =
          MethodDescriptor.<ListEndpointsRequest, ListEndpointsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ids.v1.IDS/ListEndpoints")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEndpointsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEndpointsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetEndpointRequest, Endpoint> getEndpointMethodDescriptor =
      MethodDescriptor.<GetEndpointRequest, Endpoint>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.ids.v1.IDS/GetEndpoint")
          .setRequestMarshaller(ProtoUtils.marshaller(GetEndpointRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Endpoint.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateEndpointRequest, Operation>
      createEndpointMethodDescriptor =
          MethodDescriptor.<CreateEndpointRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ids.v1.IDS/CreateEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteEndpointRequest, Operation>
      deleteEndpointMethodDescriptor =
          MethodDescriptor.<DeleteEndpointRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ids.v1.IDS/DeleteEndpoint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListEndpointsRequest, ListEndpointsResponse> listEndpointsCallable;
  private final UnaryCallable<ListEndpointsRequest, ListEndpointsPagedResponse>
      listEndpointsPagedCallable;
  private final UnaryCallable<GetEndpointRequest, Endpoint> getEndpointCallable;
  private final UnaryCallable<CreateEndpointRequest, Operation> createEndpointCallable;
  private final OperationCallable<CreateEndpointRequest, Endpoint, OperationMetadata>
      createEndpointOperationCallable;
  private final UnaryCallable<DeleteEndpointRequest, Operation> deleteEndpointCallable;
  private final OperationCallable<DeleteEndpointRequest, Empty, OperationMetadata>
      deleteEndpointOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcIDSStub create(IDSStubSettings settings) throws IOException {
    return new GrpcIDSStub(settings, ClientContext.create(settings));
  }

  public static final GrpcIDSStub create(ClientContext clientContext) throws IOException {
    return new GrpcIDSStub(IDSStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcIDSStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcIDSStub(IDSStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcIDSStub, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcIDSStub(IDSStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcIDSCallableFactory());
  }

  /**
   * Constructs an instance of GrpcIDSStub, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcIDSStub(
      IDSStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListEndpointsRequest, ListEndpointsResponse> listEndpointsTransportSettings =
        GrpcCallSettings.<ListEndpointsRequest, ListEndpointsResponse>newBuilder()
            .setMethodDescriptor(listEndpointsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetEndpointRequest, Endpoint> getEndpointTransportSettings =
        GrpcCallSettings.<GetEndpointRequest, Endpoint>newBuilder()
            .setMethodDescriptor(getEndpointMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateEndpointRequest, Operation> createEndpointTransportSettings =
        GrpcCallSettings.<CreateEndpointRequest, Operation>newBuilder()
            .setMethodDescriptor(createEndpointMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteEndpointRequest, Operation> deleteEndpointTransportSettings =
        GrpcCallSettings.<DeleteEndpointRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEndpointMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.listEndpointsCallable =
        callableFactory.createUnaryCallable(
            listEndpointsTransportSettings, settings.listEndpointsSettings(), clientContext);
    this.listEndpointsPagedCallable =
        callableFactory.createPagedCallable(
            listEndpointsTransportSettings, settings.listEndpointsSettings(), clientContext);
    this.getEndpointCallable =
        callableFactory.createUnaryCallable(
            getEndpointTransportSettings, settings.getEndpointSettings(), clientContext);
    this.createEndpointCallable =
        callableFactory.createUnaryCallable(
            createEndpointTransportSettings, settings.createEndpointSettings(), clientContext);
    this.createEndpointOperationCallable =
        callableFactory.createOperationCallable(
            createEndpointTransportSettings,
            settings.createEndpointOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteEndpointCallable =
        callableFactory.createUnaryCallable(
            deleteEndpointTransportSettings, settings.deleteEndpointSettings(), clientContext);
    this.deleteEndpointOperationCallable =
        callableFactory.createOperationCallable(
            deleteEndpointTransportSettings,
            settings.deleteEndpointOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
  public UnaryCallable<GetEndpointRequest, Endpoint> getEndpointCallable() {
    return getEndpointCallable;
  }

  @Override
  public UnaryCallable<CreateEndpointRequest, Operation> createEndpointCallable() {
    return createEndpointCallable;
  }

  @Override
  public OperationCallable<CreateEndpointRequest, Endpoint, OperationMetadata>
      createEndpointOperationCallable() {
    return createEndpointOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEndpointRequest, Operation> deleteEndpointCallable() {
    return deleteEndpointCallable;
  }

  @Override
  public OperationCallable<DeleteEndpointRequest, Empty, OperationMetadata>
      deleteEndpointOperationCallable() {
    return deleteEndpointOperationCallable;
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
