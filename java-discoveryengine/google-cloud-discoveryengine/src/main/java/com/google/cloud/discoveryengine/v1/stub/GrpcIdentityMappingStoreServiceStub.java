/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.discoveryengine.v1.stub;

import static com.google.cloud.discoveryengine.v1.IdentityMappingStoreServiceClient.ListIdentityMappingStoresPagedResponse;
import static com.google.cloud.discoveryengine.v1.IdentityMappingStoreServiceClient.ListIdentityMappingsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1.CreateIdentityMappingStoreRequest;
import com.google.cloud.discoveryengine.v1.DeleteIdentityMappingStoreMetadata;
import com.google.cloud.discoveryengine.v1.DeleteIdentityMappingStoreRequest;
import com.google.cloud.discoveryengine.v1.GetIdentityMappingStoreRequest;
import com.google.cloud.discoveryengine.v1.IdentityMappingEntryOperationMetadata;
import com.google.cloud.discoveryengine.v1.IdentityMappingStore;
import com.google.cloud.discoveryengine.v1.ImportIdentityMappingsRequest;
import com.google.cloud.discoveryengine.v1.ImportIdentityMappingsResponse;
import com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresRequest;
import com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresResponse;
import com.google.cloud.discoveryengine.v1.ListIdentityMappingsRequest;
import com.google.cloud.discoveryengine.v1.ListIdentityMappingsResponse;
import com.google.cloud.discoveryengine.v1.PurgeIdentityMappingsRequest;
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
 * gRPC stub implementation for the IdentityMappingStoreService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcIdentityMappingStoreServiceStub extends IdentityMappingStoreServiceStub {
  private static final MethodDescriptor<CreateIdentityMappingStoreRequest, IdentityMappingStore>
      createIdentityMappingStoreMethodDescriptor =
          MethodDescriptor.<CreateIdentityMappingStoreRequest, IdentityMappingStore>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.IdentityMappingStoreService/CreateIdentityMappingStore")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateIdentityMappingStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(IdentityMappingStore.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetIdentityMappingStoreRequest, IdentityMappingStore>
      getIdentityMappingStoreMethodDescriptor =
          MethodDescriptor.<GetIdentityMappingStoreRequest, IdentityMappingStore>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.IdentityMappingStoreService/GetIdentityMappingStore")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetIdentityMappingStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(IdentityMappingStore.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteIdentityMappingStoreRequest, Operation>
      deleteIdentityMappingStoreMethodDescriptor =
          MethodDescriptor.<DeleteIdentityMappingStoreRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.IdentityMappingStoreService/DeleteIdentityMappingStore")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteIdentityMappingStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ImportIdentityMappingsRequest, Operation>
      importIdentityMappingsMethodDescriptor =
          MethodDescriptor.<ImportIdentityMappingsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.IdentityMappingStoreService/ImportIdentityMappings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportIdentityMappingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<PurgeIdentityMappingsRequest, Operation>
      purgeIdentityMappingsMethodDescriptor =
          MethodDescriptor.<PurgeIdentityMappingsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.IdentityMappingStoreService/PurgeIdentityMappings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PurgeIdentityMappingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListIdentityMappingsRequest, ListIdentityMappingsResponse>
      listIdentityMappingsMethodDescriptor =
          MethodDescriptor.<ListIdentityMappingsRequest, ListIdentityMappingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.IdentityMappingStoreService/ListIdentityMappings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListIdentityMappingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListIdentityMappingsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListIdentityMappingStoresRequest, ListIdentityMappingStoresResponse>
      listIdentityMappingStoresMethodDescriptor =
          MethodDescriptor
              .<ListIdentityMappingStoresRequest, ListIdentityMappingStoresResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.IdentityMappingStoreService/ListIdentityMappingStores")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListIdentityMappingStoresRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListIdentityMappingStoresResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateIdentityMappingStoreRequest, IdentityMappingStore>
      createIdentityMappingStoreCallable;
  private final UnaryCallable<GetIdentityMappingStoreRequest, IdentityMappingStore>
      getIdentityMappingStoreCallable;
  private final UnaryCallable<DeleteIdentityMappingStoreRequest, Operation>
      deleteIdentityMappingStoreCallable;
  private final OperationCallable<
          DeleteIdentityMappingStoreRequest, Empty, DeleteIdentityMappingStoreMetadata>
      deleteIdentityMappingStoreOperationCallable;
  private final UnaryCallable<ImportIdentityMappingsRequest, Operation>
      importIdentityMappingsCallable;
  private final OperationCallable<
          ImportIdentityMappingsRequest,
          ImportIdentityMappingsResponse,
          IdentityMappingEntryOperationMetadata>
      importIdentityMappingsOperationCallable;
  private final UnaryCallable<PurgeIdentityMappingsRequest, Operation>
      purgeIdentityMappingsCallable;
  private final OperationCallable<
          PurgeIdentityMappingsRequest, Empty, IdentityMappingEntryOperationMetadata>
      purgeIdentityMappingsOperationCallable;
  private final UnaryCallable<ListIdentityMappingsRequest, ListIdentityMappingsResponse>
      listIdentityMappingsCallable;
  private final UnaryCallable<ListIdentityMappingsRequest, ListIdentityMappingsPagedResponse>
      listIdentityMappingsPagedCallable;
  private final UnaryCallable<ListIdentityMappingStoresRequest, ListIdentityMappingStoresResponse>
      listIdentityMappingStoresCallable;
  private final UnaryCallable<
          ListIdentityMappingStoresRequest, ListIdentityMappingStoresPagedResponse>
      listIdentityMappingStoresPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcIdentityMappingStoreServiceStub create(
      IdentityMappingStoreServiceStubSettings settings) throws IOException {
    return new GrpcIdentityMappingStoreServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcIdentityMappingStoreServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcIdentityMappingStoreServiceStub(
        IdentityMappingStoreServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcIdentityMappingStoreServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcIdentityMappingStoreServiceStub(
        IdentityMappingStoreServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcIdentityMappingStoreServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcIdentityMappingStoreServiceStub(
      IdentityMappingStoreServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcIdentityMappingStoreServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcIdentityMappingStoreServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcIdentityMappingStoreServiceStub(
      IdentityMappingStoreServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateIdentityMappingStoreRequest, IdentityMappingStore>
        createIdentityMappingStoreTransportSettings =
            GrpcCallSettings.<CreateIdentityMappingStoreRequest, IdentityMappingStore>newBuilder()
                .setMethodDescriptor(createIdentityMappingStoreMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetIdentityMappingStoreRequest, IdentityMappingStore>
        getIdentityMappingStoreTransportSettings =
            GrpcCallSettings.<GetIdentityMappingStoreRequest, IdentityMappingStore>newBuilder()
                .setMethodDescriptor(getIdentityMappingStoreMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteIdentityMappingStoreRequest, Operation>
        deleteIdentityMappingStoreTransportSettings =
            GrpcCallSettings.<DeleteIdentityMappingStoreRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteIdentityMappingStoreMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ImportIdentityMappingsRequest, Operation>
        importIdentityMappingsTransportSettings =
            GrpcCallSettings.<ImportIdentityMappingsRequest, Operation>newBuilder()
                .setMethodDescriptor(importIdentityMappingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "identity_mapping_store",
                          String.valueOf(request.getIdentityMappingStore()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<PurgeIdentityMappingsRequest, Operation>
        purgeIdentityMappingsTransportSettings =
            GrpcCallSettings.<PurgeIdentityMappingsRequest, Operation>newBuilder()
                .setMethodDescriptor(purgeIdentityMappingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "identity_mapping_store",
                          String.valueOf(request.getIdentityMappingStore()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListIdentityMappingsRequest, ListIdentityMappingsResponse>
        listIdentityMappingsTransportSettings =
            GrpcCallSettings.<ListIdentityMappingsRequest, ListIdentityMappingsResponse>newBuilder()
                .setMethodDescriptor(listIdentityMappingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "identity_mapping_store",
                          String.valueOf(request.getIdentityMappingStore()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListIdentityMappingStoresRequest, ListIdentityMappingStoresResponse>
        listIdentityMappingStoresTransportSettings =
            GrpcCallSettings
                .<ListIdentityMappingStoresRequest, ListIdentityMappingStoresResponse>newBuilder()
                .setMethodDescriptor(listIdentityMappingStoresMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.createIdentityMappingStoreCallable =
        callableFactory.createUnaryCallable(
            createIdentityMappingStoreTransportSettings,
            settings.createIdentityMappingStoreSettings(),
            clientContext);
    this.getIdentityMappingStoreCallable =
        callableFactory.createUnaryCallable(
            getIdentityMappingStoreTransportSettings,
            settings.getIdentityMappingStoreSettings(),
            clientContext);
    this.deleteIdentityMappingStoreCallable =
        callableFactory.createUnaryCallable(
            deleteIdentityMappingStoreTransportSettings,
            settings.deleteIdentityMappingStoreSettings(),
            clientContext);
    this.deleteIdentityMappingStoreOperationCallable =
        callableFactory.createOperationCallable(
            deleteIdentityMappingStoreTransportSettings,
            settings.deleteIdentityMappingStoreOperationSettings(),
            clientContext,
            operationsStub);
    this.importIdentityMappingsCallable =
        callableFactory.createUnaryCallable(
            importIdentityMappingsTransportSettings,
            settings.importIdentityMappingsSettings(),
            clientContext);
    this.importIdentityMappingsOperationCallable =
        callableFactory.createOperationCallable(
            importIdentityMappingsTransportSettings,
            settings.importIdentityMappingsOperationSettings(),
            clientContext,
            operationsStub);
    this.purgeIdentityMappingsCallable =
        callableFactory.createUnaryCallable(
            purgeIdentityMappingsTransportSettings,
            settings.purgeIdentityMappingsSettings(),
            clientContext);
    this.purgeIdentityMappingsOperationCallable =
        callableFactory.createOperationCallable(
            purgeIdentityMappingsTransportSettings,
            settings.purgeIdentityMappingsOperationSettings(),
            clientContext,
            operationsStub);
    this.listIdentityMappingsCallable =
        callableFactory.createUnaryCallable(
            listIdentityMappingsTransportSettings,
            settings.listIdentityMappingsSettings(),
            clientContext);
    this.listIdentityMappingsPagedCallable =
        callableFactory.createPagedCallable(
            listIdentityMappingsTransportSettings,
            settings.listIdentityMappingsSettings(),
            clientContext);
    this.listIdentityMappingStoresCallable =
        callableFactory.createUnaryCallable(
            listIdentityMappingStoresTransportSettings,
            settings.listIdentityMappingStoresSettings(),
            clientContext);
    this.listIdentityMappingStoresPagedCallable =
        callableFactory.createPagedCallable(
            listIdentityMappingStoresTransportSettings,
            settings.listIdentityMappingStoresSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateIdentityMappingStoreRequest, IdentityMappingStore>
      createIdentityMappingStoreCallable() {
    return createIdentityMappingStoreCallable;
  }

  @Override
  public UnaryCallable<GetIdentityMappingStoreRequest, IdentityMappingStore>
      getIdentityMappingStoreCallable() {
    return getIdentityMappingStoreCallable;
  }

  @Override
  public UnaryCallable<DeleteIdentityMappingStoreRequest, Operation>
      deleteIdentityMappingStoreCallable() {
    return deleteIdentityMappingStoreCallable;
  }

  @Override
  public OperationCallable<
          DeleteIdentityMappingStoreRequest, Empty, DeleteIdentityMappingStoreMetadata>
      deleteIdentityMappingStoreOperationCallable() {
    return deleteIdentityMappingStoreOperationCallable;
  }

  @Override
  public UnaryCallable<ImportIdentityMappingsRequest, Operation> importIdentityMappingsCallable() {
    return importIdentityMappingsCallable;
  }

  @Override
  public OperationCallable<
          ImportIdentityMappingsRequest,
          ImportIdentityMappingsResponse,
          IdentityMappingEntryOperationMetadata>
      importIdentityMappingsOperationCallable() {
    return importIdentityMappingsOperationCallable;
  }

  @Override
  public UnaryCallable<PurgeIdentityMappingsRequest, Operation> purgeIdentityMappingsCallable() {
    return purgeIdentityMappingsCallable;
  }

  @Override
  public OperationCallable<
          PurgeIdentityMappingsRequest, Empty, IdentityMappingEntryOperationMetadata>
      purgeIdentityMappingsOperationCallable() {
    return purgeIdentityMappingsOperationCallable;
  }

  @Override
  public UnaryCallable<ListIdentityMappingsRequest, ListIdentityMappingsResponse>
      listIdentityMappingsCallable() {
    return listIdentityMappingsCallable;
  }

  @Override
  public UnaryCallable<ListIdentityMappingsRequest, ListIdentityMappingsPagedResponse>
      listIdentityMappingsPagedCallable() {
    return listIdentityMappingsPagedCallable;
  }

  @Override
  public UnaryCallable<ListIdentityMappingStoresRequest, ListIdentityMappingStoresResponse>
      listIdentityMappingStoresCallable() {
    return listIdentityMappingStoresCallable;
  }

  @Override
  public UnaryCallable<ListIdentityMappingStoresRequest, ListIdentityMappingStoresPagedResponse>
      listIdentityMappingStoresPagedCallable() {
    return listIdentityMappingStoresPagedCallable;
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
