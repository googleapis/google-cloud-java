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

package com.google.cloud.networkmanagement.v1beta1.stub;

import static com.google.cloud.networkmanagement.v1beta1.ReachabilityServiceClient.ListConnectivityTestsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.networkmanagement.v1beta1.ConnectivityTest;
import com.google.cloud.networkmanagement.v1beta1.CreateConnectivityTestRequest;
import com.google.cloud.networkmanagement.v1beta1.DeleteConnectivityTestRequest;
import com.google.cloud.networkmanagement.v1beta1.GetConnectivityTestRequest;
import com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsRequest;
import com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsResponse;
import com.google.cloud.networkmanagement.v1beta1.OperationMetadata;
import com.google.cloud.networkmanagement.v1beta1.RerunConnectivityTestRequest;
import com.google.cloud.networkmanagement.v1beta1.UpdateConnectivityTestRequest;
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
 * gRPC stub implementation for the ReachabilityService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcReachabilityServiceStub extends ReachabilityServiceStub {
  private static final MethodDescriptor<ListConnectivityTestsRequest, ListConnectivityTestsResponse>
      listConnectivityTestsMethodDescriptor =
          MethodDescriptor.<ListConnectivityTestsRequest, ListConnectivityTestsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkmanagement.v1beta1.ReachabilityService/ListConnectivityTests")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConnectivityTestsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConnectivityTestsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetConnectivityTestRequest, ConnectivityTest>
      getConnectivityTestMethodDescriptor =
          MethodDescriptor.<GetConnectivityTestRequest, ConnectivityTest>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkmanagement.v1beta1.ReachabilityService/GetConnectivityTest")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConnectivityTestRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ConnectivityTest.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateConnectivityTestRequest, Operation>
      createConnectivityTestMethodDescriptor =
          MethodDescriptor.<CreateConnectivityTestRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkmanagement.v1beta1.ReachabilityService/CreateConnectivityTest")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateConnectivityTestRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateConnectivityTestRequest, Operation>
      updateConnectivityTestMethodDescriptor =
          MethodDescriptor.<UpdateConnectivityTestRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkmanagement.v1beta1.ReachabilityService/UpdateConnectivityTest")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateConnectivityTestRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RerunConnectivityTestRequest, Operation>
      rerunConnectivityTestMethodDescriptor =
          MethodDescriptor.<RerunConnectivityTestRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkmanagement.v1beta1.ReachabilityService/RerunConnectivityTest")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RerunConnectivityTestRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteConnectivityTestRequest, Operation>
      deleteConnectivityTestMethodDescriptor =
          MethodDescriptor.<DeleteConnectivityTestRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkmanagement.v1beta1.ReachabilityService/DeleteConnectivityTest")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteConnectivityTestRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListConnectivityTestsRequest, ListConnectivityTestsResponse>
      listConnectivityTestsCallable;
  private final UnaryCallable<ListConnectivityTestsRequest, ListConnectivityTestsPagedResponse>
      listConnectivityTestsPagedCallable;
  private final UnaryCallable<GetConnectivityTestRequest, ConnectivityTest>
      getConnectivityTestCallable;
  private final UnaryCallable<CreateConnectivityTestRequest, Operation>
      createConnectivityTestCallable;
  private final OperationCallable<
          CreateConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      createConnectivityTestOperationCallable;
  private final UnaryCallable<UpdateConnectivityTestRequest, Operation>
      updateConnectivityTestCallable;
  private final OperationCallable<
          UpdateConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      updateConnectivityTestOperationCallable;
  private final UnaryCallable<RerunConnectivityTestRequest, Operation>
      rerunConnectivityTestCallable;
  private final OperationCallable<RerunConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      rerunConnectivityTestOperationCallable;
  private final UnaryCallable<DeleteConnectivityTestRequest, Operation>
      deleteConnectivityTestCallable;
  private final OperationCallable<DeleteConnectivityTestRequest, Empty, OperationMetadata>
      deleteConnectivityTestOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcReachabilityServiceStub create(ReachabilityServiceStubSettings settings)
      throws IOException {
    return new GrpcReachabilityServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcReachabilityServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcReachabilityServiceStub(
        ReachabilityServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcReachabilityServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcReachabilityServiceStub(
        ReachabilityServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcReachabilityServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcReachabilityServiceStub(
      ReachabilityServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcReachabilityServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcReachabilityServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcReachabilityServiceStub(
      ReachabilityServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListConnectivityTestsRequest, ListConnectivityTestsResponse>
        listConnectivityTestsTransportSettings =
            GrpcCallSettings
                .<ListConnectivityTestsRequest, ListConnectivityTestsResponse>newBuilder()
                .setMethodDescriptor(listConnectivityTestsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetConnectivityTestRequest, ConnectivityTest>
        getConnectivityTestTransportSettings =
            GrpcCallSettings.<GetConnectivityTestRequest, ConnectivityTest>newBuilder()
                .setMethodDescriptor(getConnectivityTestMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateConnectivityTestRequest, Operation>
        createConnectivityTestTransportSettings =
            GrpcCallSettings.<CreateConnectivityTestRequest, Operation>newBuilder()
                .setMethodDescriptor(createConnectivityTestMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateConnectivityTestRequest, Operation>
        updateConnectivityTestTransportSettings =
            GrpcCallSettings.<UpdateConnectivityTestRequest, Operation>newBuilder()
                .setMethodDescriptor(updateConnectivityTestMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("resource.name", String.valueOf(request.getResource().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<RerunConnectivityTestRequest, Operation>
        rerunConnectivityTestTransportSettings =
            GrpcCallSettings.<RerunConnectivityTestRequest, Operation>newBuilder()
                .setMethodDescriptor(rerunConnectivityTestMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteConnectivityTestRequest, Operation>
        deleteConnectivityTestTransportSettings =
            GrpcCallSettings.<DeleteConnectivityTestRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteConnectivityTestMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();

    this.listConnectivityTestsCallable =
        callableFactory.createUnaryCallable(
            listConnectivityTestsTransportSettings,
            settings.listConnectivityTestsSettings(),
            clientContext);
    this.listConnectivityTestsPagedCallable =
        callableFactory.createPagedCallable(
            listConnectivityTestsTransportSettings,
            settings.listConnectivityTestsSettings(),
            clientContext);
    this.getConnectivityTestCallable =
        callableFactory.createUnaryCallable(
            getConnectivityTestTransportSettings,
            settings.getConnectivityTestSettings(),
            clientContext);
    this.createConnectivityTestCallable =
        callableFactory.createUnaryCallable(
            createConnectivityTestTransportSettings,
            settings.createConnectivityTestSettings(),
            clientContext);
    this.createConnectivityTestOperationCallable =
        callableFactory.createOperationCallable(
            createConnectivityTestTransportSettings,
            settings.createConnectivityTestOperationSettings(),
            clientContext,
            operationsStub);
    this.updateConnectivityTestCallable =
        callableFactory.createUnaryCallable(
            updateConnectivityTestTransportSettings,
            settings.updateConnectivityTestSettings(),
            clientContext);
    this.updateConnectivityTestOperationCallable =
        callableFactory.createOperationCallable(
            updateConnectivityTestTransportSettings,
            settings.updateConnectivityTestOperationSettings(),
            clientContext,
            operationsStub);
    this.rerunConnectivityTestCallable =
        callableFactory.createUnaryCallable(
            rerunConnectivityTestTransportSettings,
            settings.rerunConnectivityTestSettings(),
            clientContext);
    this.rerunConnectivityTestOperationCallable =
        callableFactory.createOperationCallable(
            rerunConnectivityTestTransportSettings,
            settings.rerunConnectivityTestOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteConnectivityTestCallable =
        callableFactory.createUnaryCallable(
            deleteConnectivityTestTransportSettings,
            settings.deleteConnectivityTestSettings(),
            clientContext);
    this.deleteConnectivityTestOperationCallable =
        callableFactory.createOperationCallable(
            deleteConnectivityTestTransportSettings,
            settings.deleteConnectivityTestOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListConnectivityTestsRequest, ListConnectivityTestsResponse>
      listConnectivityTestsCallable() {
    return listConnectivityTestsCallable;
  }

  @Override
  public UnaryCallable<ListConnectivityTestsRequest, ListConnectivityTestsPagedResponse>
      listConnectivityTestsPagedCallable() {
    return listConnectivityTestsPagedCallable;
  }

  @Override
  public UnaryCallable<GetConnectivityTestRequest, ConnectivityTest> getConnectivityTestCallable() {
    return getConnectivityTestCallable;
  }

  @Override
  public UnaryCallable<CreateConnectivityTestRequest, Operation> createConnectivityTestCallable() {
    return createConnectivityTestCallable;
  }

  @Override
  public OperationCallable<CreateConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      createConnectivityTestOperationCallable() {
    return createConnectivityTestOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateConnectivityTestRequest, Operation> updateConnectivityTestCallable() {
    return updateConnectivityTestCallable;
  }

  @Override
  public OperationCallable<UpdateConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      updateConnectivityTestOperationCallable() {
    return updateConnectivityTestOperationCallable;
  }

  @Override
  public UnaryCallable<RerunConnectivityTestRequest, Operation> rerunConnectivityTestCallable() {
    return rerunConnectivityTestCallable;
  }

  @Override
  public OperationCallable<RerunConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      rerunConnectivityTestOperationCallable() {
    return rerunConnectivityTestOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteConnectivityTestRequest, Operation> deleteConnectivityTestCallable() {
    return deleteConnectivityTestCallable;
  }

  @Override
  public OperationCallable<DeleteConnectivityTestRequest, Empty, OperationMetadata>
      deleteConnectivityTestOperationCallable() {
    return deleteConnectivityTestOperationCallable;
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
