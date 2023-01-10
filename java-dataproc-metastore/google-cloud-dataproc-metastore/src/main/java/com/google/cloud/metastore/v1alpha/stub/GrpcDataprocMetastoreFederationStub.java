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

package com.google.cloud.metastore.v1alpha.stub;

import static com.google.cloud.metastore.v1alpha.DataprocMetastoreFederationClient.ListFederationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.metastore.v1alpha.CreateFederationRequest;
import com.google.cloud.metastore.v1alpha.DeleteFederationRequest;
import com.google.cloud.metastore.v1alpha.Federation;
import com.google.cloud.metastore.v1alpha.GetFederationRequest;
import com.google.cloud.metastore.v1alpha.ListFederationsRequest;
import com.google.cloud.metastore.v1alpha.ListFederationsResponse;
import com.google.cloud.metastore.v1alpha.OperationMetadata;
import com.google.cloud.metastore.v1alpha.UpdateFederationRequest;
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
 * gRPC stub implementation for the DataprocMetastoreFederation service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcDataprocMetastoreFederationStub extends DataprocMetastoreFederationStub {
  private static final MethodDescriptor<ListFederationsRequest, ListFederationsResponse>
      listFederationsMethodDescriptor =
          MethodDescriptor.<ListFederationsRequest, ListFederationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.metastore.v1alpha.DataprocMetastoreFederation/ListFederations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListFederationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFederationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetFederationRequest, Federation>
      getFederationMethodDescriptor =
          MethodDescriptor.<GetFederationRequest, Federation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.metastore.v1alpha.DataprocMetastoreFederation/GetFederation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetFederationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Federation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateFederationRequest, Operation>
      createFederationMethodDescriptor =
          MethodDescriptor.<CreateFederationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.metastore.v1alpha.DataprocMetastoreFederation/CreateFederation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateFederationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateFederationRequest, Operation>
      updateFederationMethodDescriptor =
          MethodDescriptor.<UpdateFederationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.metastore.v1alpha.DataprocMetastoreFederation/UpdateFederation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateFederationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteFederationRequest, Operation>
      deleteFederationMethodDescriptor =
          MethodDescriptor.<DeleteFederationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.metastore.v1alpha.DataprocMetastoreFederation/DeleteFederation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteFederationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListFederationsRequest, ListFederationsResponse>
      listFederationsCallable;
  private final UnaryCallable<ListFederationsRequest, ListFederationsPagedResponse>
      listFederationsPagedCallable;
  private final UnaryCallable<GetFederationRequest, Federation> getFederationCallable;
  private final UnaryCallable<CreateFederationRequest, Operation> createFederationCallable;
  private final OperationCallable<CreateFederationRequest, Federation, OperationMetadata>
      createFederationOperationCallable;
  private final UnaryCallable<UpdateFederationRequest, Operation> updateFederationCallable;
  private final OperationCallable<UpdateFederationRequest, Federation, OperationMetadata>
      updateFederationOperationCallable;
  private final UnaryCallable<DeleteFederationRequest, Operation> deleteFederationCallable;
  private final OperationCallable<DeleteFederationRequest, Empty, OperationMetadata>
      deleteFederationOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDataprocMetastoreFederationStub create(
      DataprocMetastoreFederationStubSettings settings) throws IOException {
    return new GrpcDataprocMetastoreFederationStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataprocMetastoreFederationStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataprocMetastoreFederationStub(
        DataprocMetastoreFederationStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataprocMetastoreFederationStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataprocMetastoreFederationStub(
        DataprocMetastoreFederationStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataprocMetastoreFederationStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataprocMetastoreFederationStub(
      DataprocMetastoreFederationStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDataprocMetastoreFederationCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataprocMetastoreFederationStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataprocMetastoreFederationStub(
      DataprocMetastoreFederationStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListFederationsRequest, ListFederationsResponse>
        listFederationsTransportSettings =
            GrpcCallSettings.<ListFederationsRequest, ListFederationsResponse>newBuilder()
                .setMethodDescriptor(listFederationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetFederationRequest, Federation> getFederationTransportSettings =
        GrpcCallSettings.<GetFederationRequest, Federation>newBuilder()
            .setMethodDescriptor(getFederationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateFederationRequest, Operation> createFederationTransportSettings =
        GrpcCallSettings.<CreateFederationRequest, Operation>newBuilder()
            .setMethodDescriptor(createFederationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateFederationRequest, Operation> updateFederationTransportSettings =
        GrpcCallSettings.<UpdateFederationRequest, Operation>newBuilder()
            .setMethodDescriptor(updateFederationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("federation.name", String.valueOf(request.getFederation().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteFederationRequest, Operation> deleteFederationTransportSettings =
        GrpcCallSettings.<DeleteFederationRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteFederationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.listFederationsCallable =
        callableFactory.createUnaryCallable(
            listFederationsTransportSettings, settings.listFederationsSettings(), clientContext);
    this.listFederationsPagedCallable =
        callableFactory.createPagedCallable(
            listFederationsTransportSettings, settings.listFederationsSettings(), clientContext);
    this.getFederationCallable =
        callableFactory.createUnaryCallable(
            getFederationTransportSettings, settings.getFederationSettings(), clientContext);
    this.createFederationCallable =
        callableFactory.createUnaryCallable(
            createFederationTransportSettings, settings.createFederationSettings(), clientContext);
    this.createFederationOperationCallable =
        callableFactory.createOperationCallable(
            createFederationTransportSettings,
            settings.createFederationOperationSettings(),
            clientContext,
            operationsStub);
    this.updateFederationCallable =
        callableFactory.createUnaryCallable(
            updateFederationTransportSettings, settings.updateFederationSettings(), clientContext);
    this.updateFederationOperationCallable =
        callableFactory.createOperationCallable(
            updateFederationTransportSettings,
            settings.updateFederationOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteFederationCallable =
        callableFactory.createUnaryCallable(
            deleteFederationTransportSettings, settings.deleteFederationSettings(), clientContext);
    this.deleteFederationOperationCallable =
        callableFactory.createOperationCallable(
            deleteFederationTransportSettings,
            settings.deleteFederationOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListFederationsRequest, ListFederationsResponse> listFederationsCallable() {
    return listFederationsCallable;
  }

  @Override
  public UnaryCallable<ListFederationsRequest, ListFederationsPagedResponse>
      listFederationsPagedCallable() {
    return listFederationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetFederationRequest, Federation> getFederationCallable() {
    return getFederationCallable;
  }

  @Override
  public UnaryCallable<CreateFederationRequest, Operation> createFederationCallable() {
    return createFederationCallable;
  }

  @Override
  public OperationCallable<CreateFederationRequest, Federation, OperationMetadata>
      createFederationOperationCallable() {
    return createFederationOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateFederationRequest, Operation> updateFederationCallable() {
    return updateFederationCallable;
  }

  @Override
  public OperationCallable<UpdateFederationRequest, Federation, OperationMetadata>
      updateFederationOperationCallable() {
    return updateFederationOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteFederationRequest, Operation> deleteFederationCallable() {
    return deleteFederationCallable;
  }

  @Override
  public OperationCallable<DeleteFederationRequest, Empty, OperationMetadata>
      deleteFederationOperationCallable() {
    return deleteFederationOperationCallable;
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
