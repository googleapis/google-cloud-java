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

package com.google.api.apikeys.v2.stub;

import static com.google.api.apikeys.v2.ApiKeysClient.ListKeysPagedResponse;

import com.google.api.apikeys.v2.CreateKeyRequest;
import com.google.api.apikeys.v2.DeleteKeyRequest;
import com.google.api.apikeys.v2.GetKeyRequest;
import com.google.api.apikeys.v2.GetKeyStringRequest;
import com.google.api.apikeys.v2.GetKeyStringResponse;
import com.google.api.apikeys.v2.Key;
import com.google.api.apikeys.v2.ListKeysRequest;
import com.google.api.apikeys.v2.ListKeysResponse;
import com.google.api.apikeys.v2.LookupKeyRequest;
import com.google.api.apikeys.v2.LookupKeyResponse;
import com.google.api.apikeys.v2.UndeleteKeyRequest;
import com.google.api.apikeys.v2.UpdateKeyRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
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
 * gRPC stub implementation for the ApiKeys service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcApiKeysStub extends ApiKeysStub {
  private static final MethodDescriptor<CreateKeyRequest, Operation> createKeyMethodDescriptor =
      MethodDescriptor.<CreateKeyRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.api.apikeys.v2.ApiKeys/CreateKey")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateKeyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListKeysRequest, ListKeysResponse>
      listKeysMethodDescriptor =
          MethodDescriptor.<ListKeysRequest, ListKeysResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.apikeys.v2.ApiKeys/ListKeys")
              .setRequestMarshaller(ProtoUtils.marshaller(ListKeysRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListKeysResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetKeyRequest, Key> getKeyMethodDescriptor =
      MethodDescriptor.<GetKeyRequest, Key>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.api.apikeys.v2.ApiKeys/GetKey")
          .setRequestMarshaller(ProtoUtils.marshaller(GetKeyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Key.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetKeyStringRequest, GetKeyStringResponse>
      getKeyStringMethodDescriptor =
          MethodDescriptor.<GetKeyStringRequest, GetKeyStringResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.apikeys.v2.ApiKeys/GetKeyString")
              .setRequestMarshaller(ProtoUtils.marshaller(GetKeyStringRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GetKeyStringResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateKeyRequest, Operation> updateKeyMethodDescriptor =
      MethodDescriptor.<UpdateKeyRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.api.apikeys.v2.ApiKeys/UpdateKey")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateKeyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteKeyRequest, Operation> deleteKeyMethodDescriptor =
      MethodDescriptor.<DeleteKeyRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.api.apikeys.v2.ApiKeys/DeleteKey")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteKeyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UndeleteKeyRequest, Operation> undeleteKeyMethodDescriptor =
      MethodDescriptor.<UndeleteKeyRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.api.apikeys.v2.ApiKeys/UndeleteKey")
          .setRequestMarshaller(ProtoUtils.marshaller(UndeleteKeyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<LookupKeyRequest, LookupKeyResponse>
      lookupKeyMethodDescriptor =
          MethodDescriptor.<LookupKeyRequest, LookupKeyResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.apikeys.v2.ApiKeys/LookupKey")
              .setRequestMarshaller(ProtoUtils.marshaller(LookupKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LookupKeyResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateKeyRequest, Operation> createKeyCallable;
  private final OperationCallable<CreateKeyRequest, Key, Empty> createKeyOperationCallable;
  private final UnaryCallable<ListKeysRequest, ListKeysResponse> listKeysCallable;
  private final UnaryCallable<ListKeysRequest, ListKeysPagedResponse> listKeysPagedCallable;
  private final UnaryCallable<GetKeyRequest, Key> getKeyCallable;
  private final UnaryCallable<GetKeyStringRequest, GetKeyStringResponse> getKeyStringCallable;
  private final UnaryCallable<UpdateKeyRequest, Operation> updateKeyCallable;
  private final OperationCallable<UpdateKeyRequest, Key, Empty> updateKeyOperationCallable;
  private final UnaryCallable<DeleteKeyRequest, Operation> deleteKeyCallable;
  private final OperationCallable<DeleteKeyRequest, Key, Empty> deleteKeyOperationCallable;
  private final UnaryCallable<UndeleteKeyRequest, Operation> undeleteKeyCallable;
  private final OperationCallable<UndeleteKeyRequest, Key, Empty> undeleteKeyOperationCallable;
  private final UnaryCallable<LookupKeyRequest, LookupKeyResponse> lookupKeyCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcApiKeysStub create(ApiKeysStubSettings settings) throws IOException {
    return new GrpcApiKeysStub(settings, ClientContext.create(settings));
  }

  public static final GrpcApiKeysStub create(ClientContext clientContext) throws IOException {
    return new GrpcApiKeysStub(ApiKeysStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcApiKeysStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcApiKeysStub(
        ApiKeysStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcApiKeysStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcApiKeysStub(ApiKeysStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcApiKeysCallableFactory());
  }

  /**
   * Constructs an instance of GrpcApiKeysStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcApiKeysStub(
      ApiKeysStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateKeyRequest, Operation> createKeyTransportSettings =
        GrpcCallSettings.<CreateKeyRequest, Operation>newBuilder()
            .setMethodDescriptor(createKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListKeysRequest, ListKeysResponse> listKeysTransportSettings =
        GrpcCallSettings.<ListKeysRequest, ListKeysResponse>newBuilder()
            .setMethodDescriptor(listKeysMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetKeyRequest, Key> getKeyTransportSettings =
        GrpcCallSettings.<GetKeyRequest, Key>newBuilder()
            .setMethodDescriptor(getKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetKeyStringRequest, GetKeyStringResponse> getKeyStringTransportSettings =
        GrpcCallSettings.<GetKeyStringRequest, GetKeyStringResponse>newBuilder()
            .setMethodDescriptor(getKeyStringMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateKeyRequest, Operation> updateKeyTransportSettings =
        GrpcCallSettings.<UpdateKeyRequest, Operation>newBuilder()
            .setMethodDescriptor(updateKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("key.name", String.valueOf(request.getKey().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteKeyRequest, Operation> deleteKeyTransportSettings =
        GrpcCallSettings.<DeleteKeyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UndeleteKeyRequest, Operation> undeleteKeyTransportSettings =
        GrpcCallSettings.<UndeleteKeyRequest, Operation>newBuilder()
            .setMethodDescriptor(undeleteKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<LookupKeyRequest, LookupKeyResponse> lookupKeyTransportSettings =
        GrpcCallSettings.<LookupKeyRequest, LookupKeyResponse>newBuilder()
            .setMethodDescriptor(lookupKeyMethodDescriptor)
            .build();

    this.createKeyCallable =
        callableFactory.createUnaryCallable(
            createKeyTransportSettings, settings.createKeySettings(), clientContext);
    this.createKeyOperationCallable =
        callableFactory.createOperationCallable(
            createKeyTransportSettings,
            settings.createKeyOperationSettings(),
            clientContext,
            operationsStub);
    this.listKeysCallable =
        callableFactory.createUnaryCallable(
            listKeysTransportSettings, settings.listKeysSettings(), clientContext);
    this.listKeysPagedCallable =
        callableFactory.createPagedCallable(
            listKeysTransportSettings, settings.listKeysSettings(), clientContext);
    this.getKeyCallable =
        callableFactory.createUnaryCallable(
            getKeyTransportSettings, settings.getKeySettings(), clientContext);
    this.getKeyStringCallable =
        callableFactory.createUnaryCallable(
            getKeyStringTransportSettings, settings.getKeyStringSettings(), clientContext);
    this.updateKeyCallable =
        callableFactory.createUnaryCallable(
            updateKeyTransportSettings, settings.updateKeySettings(), clientContext);
    this.updateKeyOperationCallable =
        callableFactory.createOperationCallable(
            updateKeyTransportSettings,
            settings.updateKeyOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteKeyCallable =
        callableFactory.createUnaryCallable(
            deleteKeyTransportSettings, settings.deleteKeySettings(), clientContext);
    this.deleteKeyOperationCallable =
        callableFactory.createOperationCallable(
            deleteKeyTransportSettings,
            settings.deleteKeyOperationSettings(),
            clientContext,
            operationsStub);
    this.undeleteKeyCallable =
        callableFactory.createUnaryCallable(
            undeleteKeyTransportSettings, settings.undeleteKeySettings(), clientContext);
    this.undeleteKeyOperationCallable =
        callableFactory.createOperationCallable(
            undeleteKeyTransportSettings,
            settings.undeleteKeyOperationSettings(),
            clientContext,
            operationsStub);
    this.lookupKeyCallable =
        callableFactory.createUnaryCallable(
            lookupKeyTransportSettings, settings.lookupKeySettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateKeyRequest, Operation> createKeyCallable() {
    return createKeyCallable;
  }

  @Override
  public OperationCallable<CreateKeyRequest, Key, Empty> createKeyOperationCallable() {
    return createKeyOperationCallable;
  }

  @Override
  public UnaryCallable<ListKeysRequest, ListKeysResponse> listKeysCallable() {
    return listKeysCallable;
  }

  @Override
  public UnaryCallable<ListKeysRequest, ListKeysPagedResponse> listKeysPagedCallable() {
    return listKeysPagedCallable;
  }

  @Override
  public UnaryCallable<GetKeyRequest, Key> getKeyCallable() {
    return getKeyCallable;
  }

  @Override
  public UnaryCallable<GetKeyStringRequest, GetKeyStringResponse> getKeyStringCallable() {
    return getKeyStringCallable;
  }

  @Override
  public UnaryCallable<UpdateKeyRequest, Operation> updateKeyCallable() {
    return updateKeyCallable;
  }

  @Override
  public OperationCallable<UpdateKeyRequest, Key, Empty> updateKeyOperationCallable() {
    return updateKeyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteKeyRequest, Operation> deleteKeyCallable() {
    return deleteKeyCallable;
  }

  @Override
  public OperationCallable<DeleteKeyRequest, Key, Empty> deleteKeyOperationCallable() {
    return deleteKeyOperationCallable;
  }

  @Override
  public UnaryCallable<UndeleteKeyRequest, Operation> undeleteKeyCallable() {
    return undeleteKeyCallable;
  }

  @Override
  public OperationCallable<UndeleteKeyRequest, Key, Empty> undeleteKeyOperationCallable() {
    return undeleteKeyOperationCallable;
  }

  @Override
  public UnaryCallable<LookupKeyRequest, LookupKeyResponse> lookupKeyCallable() {
    return lookupKeyCallable;
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
