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

package com.google.appengine.v1.stub;

import static com.google.appengine.v1.DomainMappingsClient.ListDomainMappingsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.appengine.v1.CreateDomainMappingRequest;
import com.google.appengine.v1.DeleteDomainMappingRequest;
import com.google.appengine.v1.DomainMapping;
import com.google.appengine.v1.GetDomainMappingRequest;
import com.google.appengine.v1.ListDomainMappingsRequest;
import com.google.appengine.v1.ListDomainMappingsResponse;
import com.google.appengine.v1.OperationMetadataV1;
import com.google.appengine.v1.UpdateDomainMappingRequest;
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
 * gRPC stub implementation for the DomainMappings service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDomainMappingsStub extends DomainMappingsStub {
  private static final MethodDescriptor<ListDomainMappingsRequest, ListDomainMappingsResponse>
      listDomainMappingsMethodDescriptor =
          MethodDescriptor.<ListDomainMappingsRequest, ListDomainMappingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.appengine.v1.DomainMappings/ListDomainMappings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDomainMappingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDomainMappingsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDomainMappingRequest, DomainMapping>
      getDomainMappingMethodDescriptor =
          MethodDescriptor.<GetDomainMappingRequest, DomainMapping>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.appengine.v1.DomainMappings/GetDomainMapping")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDomainMappingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DomainMapping.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDomainMappingRequest, Operation>
      createDomainMappingMethodDescriptor =
          MethodDescriptor.<CreateDomainMappingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.appengine.v1.DomainMappings/CreateDomainMapping")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDomainMappingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDomainMappingRequest, Operation>
      updateDomainMappingMethodDescriptor =
          MethodDescriptor.<UpdateDomainMappingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.appengine.v1.DomainMappings/UpdateDomainMapping")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDomainMappingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDomainMappingRequest, Operation>
      deleteDomainMappingMethodDescriptor =
          MethodDescriptor.<DeleteDomainMappingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.appengine.v1.DomainMappings/DeleteDomainMapping")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDomainMappingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListDomainMappingsRequest, ListDomainMappingsResponse>
      listDomainMappingsCallable;
  private final UnaryCallable<ListDomainMappingsRequest, ListDomainMappingsPagedResponse>
      listDomainMappingsPagedCallable;
  private final UnaryCallable<GetDomainMappingRequest, DomainMapping> getDomainMappingCallable;
  private final UnaryCallable<CreateDomainMappingRequest, Operation> createDomainMappingCallable;
  private final OperationCallable<CreateDomainMappingRequest, DomainMapping, OperationMetadataV1>
      createDomainMappingOperationCallable;
  private final UnaryCallable<UpdateDomainMappingRequest, Operation> updateDomainMappingCallable;
  private final OperationCallable<UpdateDomainMappingRequest, DomainMapping, OperationMetadataV1>
      updateDomainMappingOperationCallable;
  private final UnaryCallable<DeleteDomainMappingRequest, Operation> deleteDomainMappingCallable;
  private final OperationCallable<DeleteDomainMappingRequest, Empty, OperationMetadataV1>
      deleteDomainMappingOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDomainMappingsStub create(DomainMappingsStubSettings settings)
      throws IOException {
    return new GrpcDomainMappingsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDomainMappingsStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDomainMappingsStub(
        DomainMappingsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDomainMappingsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDomainMappingsStub(
        DomainMappingsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDomainMappingsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDomainMappingsStub(DomainMappingsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDomainMappingsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDomainMappingsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDomainMappingsStub(
      DomainMappingsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListDomainMappingsRequest, ListDomainMappingsResponse>
        listDomainMappingsTransportSettings =
            GrpcCallSettings.<ListDomainMappingsRequest, ListDomainMappingsResponse>newBuilder()
                .setMethodDescriptor(listDomainMappingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetDomainMappingRequest, DomainMapping> getDomainMappingTransportSettings =
        GrpcCallSettings.<GetDomainMappingRequest, DomainMapping>newBuilder()
            .setMethodDescriptor(getDomainMappingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateDomainMappingRequest, Operation> createDomainMappingTransportSettings =
        GrpcCallSettings.<CreateDomainMappingRequest, Operation>newBuilder()
            .setMethodDescriptor(createDomainMappingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateDomainMappingRequest, Operation> updateDomainMappingTransportSettings =
        GrpcCallSettings.<UpdateDomainMappingRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDomainMappingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteDomainMappingRequest, Operation> deleteDomainMappingTransportSettings =
        GrpcCallSettings.<DeleteDomainMappingRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDomainMappingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.listDomainMappingsCallable =
        callableFactory.createUnaryCallable(
            listDomainMappingsTransportSettings,
            settings.listDomainMappingsSettings(),
            clientContext);
    this.listDomainMappingsPagedCallable =
        callableFactory.createPagedCallable(
            listDomainMappingsTransportSettings,
            settings.listDomainMappingsSettings(),
            clientContext);
    this.getDomainMappingCallable =
        callableFactory.createUnaryCallable(
            getDomainMappingTransportSettings, settings.getDomainMappingSettings(), clientContext);
    this.createDomainMappingCallable =
        callableFactory.createUnaryCallable(
            createDomainMappingTransportSettings,
            settings.createDomainMappingSettings(),
            clientContext);
    this.createDomainMappingOperationCallable =
        callableFactory.createOperationCallable(
            createDomainMappingTransportSettings,
            settings.createDomainMappingOperationSettings(),
            clientContext,
            operationsStub);
    this.updateDomainMappingCallable =
        callableFactory.createUnaryCallable(
            updateDomainMappingTransportSettings,
            settings.updateDomainMappingSettings(),
            clientContext);
    this.updateDomainMappingOperationCallable =
        callableFactory.createOperationCallable(
            updateDomainMappingTransportSettings,
            settings.updateDomainMappingOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteDomainMappingCallable =
        callableFactory.createUnaryCallable(
            deleteDomainMappingTransportSettings,
            settings.deleteDomainMappingSettings(),
            clientContext);
    this.deleteDomainMappingOperationCallable =
        callableFactory.createOperationCallable(
            deleteDomainMappingTransportSettings,
            settings.deleteDomainMappingOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListDomainMappingsRequest, ListDomainMappingsResponse>
      listDomainMappingsCallable() {
    return listDomainMappingsCallable;
  }

  @Override
  public UnaryCallable<ListDomainMappingsRequest, ListDomainMappingsPagedResponse>
      listDomainMappingsPagedCallable() {
    return listDomainMappingsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDomainMappingRequest, DomainMapping> getDomainMappingCallable() {
    return getDomainMappingCallable;
  }

  @Override
  public UnaryCallable<CreateDomainMappingRequest, Operation> createDomainMappingCallable() {
    return createDomainMappingCallable;
  }

  @Override
  public OperationCallable<CreateDomainMappingRequest, DomainMapping, OperationMetadataV1>
      createDomainMappingOperationCallable() {
    return createDomainMappingOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDomainMappingRequest, Operation> updateDomainMappingCallable() {
    return updateDomainMappingCallable;
  }

  @Override
  public OperationCallable<UpdateDomainMappingRequest, DomainMapping, OperationMetadataV1>
      updateDomainMappingOperationCallable() {
    return updateDomainMappingOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDomainMappingRequest, Operation> deleteDomainMappingCallable() {
    return deleteDomainMappingCallable;
  }

  @Override
  public OperationCallable<DeleteDomainMappingRequest, Empty, OperationMetadataV1>
      deleteDomainMappingOperationCallable() {
    return deleteDomainMappingOperationCallable;
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
