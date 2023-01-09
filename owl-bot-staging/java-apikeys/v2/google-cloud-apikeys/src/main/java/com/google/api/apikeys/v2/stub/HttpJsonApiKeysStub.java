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
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the ApiKeys service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonApiKeysStub extends ApiKeysStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Empty.getDescriptor()).add(Key.getDescriptor()).build();

  private static final ApiMethodDescriptor<CreateKeyRequest, Operation> createKeyMethodDescriptor =
      ApiMethodDescriptor.<CreateKeyRequest, Operation>newBuilder()
          .setFullMethodName("google.api.apikeys.v2.ApiKeys/CreateKey")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateKeyRequest>newBuilder()
                  .setPath(
                      "/v2/{parent=projects/*/locations/*}/keys",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateKeyRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateKeyRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "keyId", request.getKeyId());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request -> ProtoRestSerializer.create().toBody("key", request.getKey(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (CreateKeyRequest request, Operation response) ->
                  HttpJsonOperationSnapshot.create(response))
          .build();

  private static final ApiMethodDescriptor<ListKeysRequest, ListKeysResponse>
      listKeysMethodDescriptor =
          ApiMethodDescriptor.<ListKeysRequest, ListKeysResponse>newBuilder()
              .setFullMethodName("google.api.apikeys.v2.ApiKeys/ListKeys")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListKeysRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/keys",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListKeysRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListKeysRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "showDeleted", request.getShowDeleted());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListKeysResponse>newBuilder()
                      .setDefaultInstance(ListKeysResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetKeyRequest, Key> getKeyMethodDescriptor =
      ApiMethodDescriptor.<GetKeyRequest, Key>newBuilder()
          .setFullMethodName("google.api.apikeys.v2.ApiKeys/GetKey")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetKeyRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/locations/*/keys/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetKeyRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetKeyRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Key>newBuilder()
                  .setDefaultInstance(Key.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetKeyStringRequest, GetKeyStringResponse>
      getKeyStringMethodDescriptor =
          ApiMethodDescriptor.<GetKeyStringRequest, GetKeyStringResponse>newBuilder()
              .setFullMethodName("google.api.apikeys.v2.ApiKeys/GetKeyString")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetKeyStringRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/keys/*}/keyString",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetKeyStringRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetKeyStringRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GetKeyStringResponse>newBuilder()
                      .setDefaultInstance(GetKeyStringResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateKeyRequest, Operation> updateKeyMethodDescriptor =
      ApiMethodDescriptor.<UpdateKeyRequest, Operation>newBuilder()
          .setFullMethodName("google.api.apikeys.v2.ApiKeys/UpdateKey")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateKeyRequest>newBuilder()
                  .setPath(
                      "/v2/{key.name=projects/*/locations/*/keys/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateKeyRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "key.name", request.getKey().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateKeyRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request -> ProtoRestSerializer.create().toBody("key", request.getKey(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (UpdateKeyRequest request, Operation response) ->
                  HttpJsonOperationSnapshot.create(response))
          .build();

  private static final ApiMethodDescriptor<DeleteKeyRequest, Operation> deleteKeyMethodDescriptor =
      ApiMethodDescriptor.<DeleteKeyRequest, Operation>newBuilder()
          .setFullMethodName("google.api.apikeys.v2.ApiKeys/DeleteKey")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteKeyRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/locations/*/keys/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteKeyRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteKeyRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "etag", request.getEtag());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (DeleteKeyRequest request, Operation response) ->
                  HttpJsonOperationSnapshot.create(response))
          .build();

  private static final ApiMethodDescriptor<UndeleteKeyRequest, Operation>
      undeleteKeyMethodDescriptor =
          ApiMethodDescriptor.<UndeleteKeyRequest, Operation>newBuilder()
              .setFullMethodName("google.api.apikeys.v2.ApiKeys/UndeleteKey")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UndeleteKeyRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/keys/*}:undelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UndeleteKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UndeleteKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UndeleteKeyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<LookupKeyRequest, LookupKeyResponse>
      lookupKeyMethodDescriptor =
          ApiMethodDescriptor.<LookupKeyRequest, LookupKeyResponse>newBuilder()
              .setFullMethodName("google.api.apikeys.v2.ApiKeys/LookupKey")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<LookupKeyRequest>newBuilder()
                      .setPath(
                          "/v2/keys:lookupKey",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<LookupKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<LookupKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "keyString", request.getKeyString());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LookupKeyResponse>newBuilder()
                      .setDefaultInstance(LookupKeyResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonApiKeysStub create(ApiKeysStubSettings settings) throws IOException {
    return new HttpJsonApiKeysStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonApiKeysStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonApiKeysStub(ApiKeysStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonApiKeysStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonApiKeysStub(
        ApiKeysStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonApiKeysStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonApiKeysStub(ApiKeysStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonApiKeysCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonApiKeysStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonApiKeysStub(
      ApiKeysStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateKeyRequest, Operation> createKeyTransportSettings =
        HttpJsonCallSettings.<CreateKeyRequest, Operation>newBuilder()
            .setMethodDescriptor(createKeyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListKeysRequest, ListKeysResponse> listKeysTransportSettings =
        HttpJsonCallSettings.<ListKeysRequest, ListKeysResponse>newBuilder()
            .setMethodDescriptor(listKeysMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetKeyRequest, Key> getKeyTransportSettings =
        HttpJsonCallSettings.<GetKeyRequest, Key>newBuilder()
            .setMethodDescriptor(getKeyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetKeyStringRequest, GetKeyStringResponse> getKeyStringTransportSettings =
        HttpJsonCallSettings.<GetKeyStringRequest, GetKeyStringResponse>newBuilder()
            .setMethodDescriptor(getKeyStringMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateKeyRequest, Operation> updateKeyTransportSettings =
        HttpJsonCallSettings.<UpdateKeyRequest, Operation>newBuilder()
            .setMethodDescriptor(updateKeyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteKeyRequest, Operation> deleteKeyTransportSettings =
        HttpJsonCallSettings.<DeleteKeyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteKeyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UndeleteKeyRequest, Operation> undeleteKeyTransportSettings =
        HttpJsonCallSettings.<UndeleteKeyRequest, Operation>newBuilder()
            .setMethodDescriptor(undeleteKeyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<LookupKeyRequest, LookupKeyResponse> lookupKeyTransportSettings =
        HttpJsonCallSettings.<LookupKeyRequest, LookupKeyResponse>newBuilder()
            .setMethodDescriptor(lookupKeyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.createKeyCallable =
        callableFactory.createUnaryCallable(
            createKeyTransportSettings, settings.createKeySettings(), clientContext);
    this.createKeyOperationCallable =
        callableFactory.createOperationCallable(
            createKeyTransportSettings,
            settings.createKeyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.deleteKeyCallable =
        callableFactory.createUnaryCallable(
            deleteKeyTransportSettings, settings.deleteKeySettings(), clientContext);
    this.deleteKeyOperationCallable =
        callableFactory.createOperationCallable(
            deleteKeyTransportSettings,
            settings.deleteKeyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.undeleteKeyCallable =
        callableFactory.createUnaryCallable(
            undeleteKeyTransportSettings, settings.undeleteKeySettings(), clientContext);
    this.undeleteKeyOperationCallable =
        callableFactory.createOperationCallable(
            undeleteKeyTransportSettings,
            settings.undeleteKeyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.lookupKeyCallable =
        callableFactory.createUnaryCallable(
            lookupKeyTransportSettings, settings.lookupKeySettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createKeyMethodDescriptor);
    methodDescriptors.add(listKeysMethodDescriptor);
    methodDescriptors.add(getKeyMethodDescriptor);
    methodDescriptors.add(getKeyStringMethodDescriptor);
    methodDescriptors.add(updateKeyMethodDescriptor);
    methodDescriptors.add(deleteKeyMethodDescriptor);
    methodDescriptors.add(undeleteKeyMethodDescriptor);
    methodDescriptors.add(lookupKeyMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
