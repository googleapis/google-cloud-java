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

package com.google.cloud.gaming.v1.stub;

import static com.google.cloud.gaming.v1.RealmsServiceClient.ListRealmsPagedResponse;

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
import com.google.cloud.gaming.v1.CreateRealmRequest;
import com.google.cloud.gaming.v1.DeleteRealmRequest;
import com.google.cloud.gaming.v1.GetRealmRequest;
import com.google.cloud.gaming.v1.ListRealmsRequest;
import com.google.cloud.gaming.v1.ListRealmsResponse;
import com.google.cloud.gaming.v1.OperationMetadata;
import com.google.cloud.gaming.v1.PreviewRealmUpdateRequest;
import com.google.cloud.gaming.v1.PreviewRealmUpdateResponse;
import com.google.cloud.gaming.v1.Realm;
import com.google.cloud.gaming.v1.UpdateRealmRequest;
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
 * REST stub implementation for the RealmsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonRealmsServiceStub extends RealmsServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(OperationMetadata.getDescriptor())
          .add(Empty.getDescriptor())
          .add(Realm.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListRealmsRequest, ListRealmsResponse>
      listRealmsMethodDescriptor =
          ApiMethodDescriptor.<ListRealmsRequest, ListRealmsResponse>newBuilder()
              .setFullMethodName("google.cloud.gaming.v1.RealmsService/ListRealms")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRealmsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/realms",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRealmsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRealmsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRealmsResponse>newBuilder()
                      .setDefaultInstance(ListRealmsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRealmRequest, Realm> getRealmMethodDescriptor =
      ApiMethodDescriptor.<GetRealmRequest, Realm>newBuilder()
          .setFullMethodName("google.cloud.gaming.v1.RealmsService/GetRealm")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetRealmRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/realms/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetRealmRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetRealmRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Realm>newBuilder()
                  .setDefaultInstance(Realm.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateRealmRequest, Operation>
      createRealmMethodDescriptor =
          ApiMethodDescriptor.<CreateRealmRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gaming.v1.RealmsService/CreateRealm")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateRealmRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/realms",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRealmRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRealmRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "realmId", request.getRealmId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("realm", request.getRealm(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateRealmRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteRealmRequest, Operation>
      deleteRealmMethodDescriptor =
          ApiMethodDescriptor.<DeleteRealmRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gaming.v1.RealmsService/DeleteRealm")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRealmRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/realms/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRealmRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRealmRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (DeleteRealmRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateRealmRequest, Operation>
      updateRealmMethodDescriptor =
          ApiMethodDescriptor.<UpdateRealmRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gaming.v1.RealmsService/UpdateRealm")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateRealmRequest>newBuilder()
                      .setPath(
                          "/v1/{realm.name=projects/*/locations/*/realms/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRealmRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "realm.name", request.getRealm().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRealmRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("realm", request.getRealm(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateRealmRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<PreviewRealmUpdateRequest, PreviewRealmUpdateResponse>
      previewRealmUpdateMethodDescriptor =
          ApiMethodDescriptor.<PreviewRealmUpdateRequest, PreviewRealmUpdateResponse>newBuilder()
              .setFullMethodName("google.cloud.gaming.v1.RealmsService/PreviewRealmUpdate")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PreviewRealmUpdateRequest>newBuilder()
                      .setPath(
                          "/v1/{realm.name=projects/*/locations/*/realms/*}:previewUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PreviewRealmUpdateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "realm.name", request.getRealm().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PreviewRealmUpdateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "previewTime", request.getPreviewTime());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("realm", request.getRealm(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PreviewRealmUpdateResponse>newBuilder()
                      .setDefaultInstance(PreviewRealmUpdateResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListRealmsRequest, ListRealmsResponse> listRealmsCallable;
  private final UnaryCallable<ListRealmsRequest, ListRealmsPagedResponse> listRealmsPagedCallable;
  private final UnaryCallable<GetRealmRequest, Realm> getRealmCallable;
  private final UnaryCallable<CreateRealmRequest, Operation> createRealmCallable;
  private final OperationCallable<CreateRealmRequest, Realm, OperationMetadata>
      createRealmOperationCallable;
  private final UnaryCallable<DeleteRealmRequest, Operation> deleteRealmCallable;
  private final OperationCallable<DeleteRealmRequest, Empty, OperationMetadata>
      deleteRealmOperationCallable;
  private final UnaryCallable<UpdateRealmRequest, Operation> updateRealmCallable;
  private final OperationCallable<UpdateRealmRequest, Realm, OperationMetadata>
      updateRealmOperationCallable;
  private final UnaryCallable<PreviewRealmUpdateRequest, PreviewRealmUpdateResponse>
      previewRealmUpdateCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRealmsServiceStub create(RealmsServiceStubSettings settings)
      throws IOException {
    return new HttpJsonRealmsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRealmsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRealmsServiceStub(
        RealmsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonRealmsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRealmsServiceStub(
        RealmsServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRealmsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRealmsServiceStub(
      RealmsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRealmsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRealmsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRealmsServiceStub(
      RealmsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListRealmsRequest, ListRealmsResponse> listRealmsTransportSettings =
        HttpJsonCallSettings.<ListRealmsRequest, ListRealmsResponse>newBuilder()
            .setMethodDescriptor(listRealmsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetRealmRequest, Realm> getRealmTransportSettings =
        HttpJsonCallSettings.<GetRealmRequest, Realm>newBuilder()
            .setMethodDescriptor(getRealmMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateRealmRequest, Operation> createRealmTransportSettings =
        HttpJsonCallSettings.<CreateRealmRequest, Operation>newBuilder()
            .setMethodDescriptor(createRealmMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteRealmRequest, Operation> deleteRealmTransportSettings =
        HttpJsonCallSettings.<DeleteRealmRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRealmMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateRealmRequest, Operation> updateRealmTransportSettings =
        HttpJsonCallSettings.<UpdateRealmRequest, Operation>newBuilder()
            .setMethodDescriptor(updateRealmMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<PreviewRealmUpdateRequest, PreviewRealmUpdateResponse>
        previewRealmUpdateTransportSettings =
            HttpJsonCallSettings.<PreviewRealmUpdateRequest, PreviewRealmUpdateResponse>newBuilder()
                .setMethodDescriptor(previewRealmUpdateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.listRealmsCallable =
        callableFactory.createUnaryCallable(
            listRealmsTransportSettings, settings.listRealmsSettings(), clientContext);
    this.listRealmsPagedCallable =
        callableFactory.createPagedCallable(
            listRealmsTransportSettings, settings.listRealmsSettings(), clientContext);
    this.getRealmCallable =
        callableFactory.createUnaryCallable(
            getRealmTransportSettings, settings.getRealmSettings(), clientContext);
    this.createRealmCallable =
        callableFactory.createUnaryCallable(
            createRealmTransportSettings, settings.createRealmSettings(), clientContext);
    this.createRealmOperationCallable =
        callableFactory.createOperationCallable(
            createRealmTransportSettings,
            settings.createRealmOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteRealmCallable =
        callableFactory.createUnaryCallable(
            deleteRealmTransportSettings, settings.deleteRealmSettings(), clientContext);
    this.deleteRealmOperationCallable =
        callableFactory.createOperationCallable(
            deleteRealmTransportSettings,
            settings.deleteRealmOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateRealmCallable =
        callableFactory.createUnaryCallable(
            updateRealmTransportSettings, settings.updateRealmSettings(), clientContext);
    this.updateRealmOperationCallable =
        callableFactory.createOperationCallable(
            updateRealmTransportSettings,
            settings.updateRealmOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.previewRealmUpdateCallable =
        callableFactory.createUnaryCallable(
            previewRealmUpdateTransportSettings,
            settings.previewRealmUpdateSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listRealmsMethodDescriptor);
    methodDescriptors.add(getRealmMethodDescriptor);
    methodDescriptors.add(createRealmMethodDescriptor);
    methodDescriptors.add(deleteRealmMethodDescriptor);
    methodDescriptors.add(updateRealmMethodDescriptor);
    methodDescriptors.add(previewRealmUpdateMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListRealmsRequest, ListRealmsResponse> listRealmsCallable() {
    return listRealmsCallable;
  }

  @Override
  public UnaryCallable<ListRealmsRequest, ListRealmsPagedResponse> listRealmsPagedCallable() {
    return listRealmsPagedCallable;
  }

  @Override
  public UnaryCallable<GetRealmRequest, Realm> getRealmCallable() {
    return getRealmCallable;
  }

  @Override
  public UnaryCallable<CreateRealmRequest, Operation> createRealmCallable() {
    return createRealmCallable;
  }

  @Override
  public OperationCallable<CreateRealmRequest, Realm, OperationMetadata>
      createRealmOperationCallable() {
    return createRealmOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteRealmRequest, Operation> deleteRealmCallable() {
    return deleteRealmCallable;
  }

  @Override
  public OperationCallable<DeleteRealmRequest, Empty, OperationMetadata>
      deleteRealmOperationCallable() {
    return deleteRealmOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateRealmRequest, Operation> updateRealmCallable() {
    return updateRealmCallable;
  }

  @Override
  public OperationCallable<UpdateRealmRequest, Realm, OperationMetadata>
      updateRealmOperationCallable() {
    return updateRealmOperationCallable;
  }

  @Override
  public UnaryCallable<PreviewRealmUpdateRequest, PreviewRealmUpdateResponse>
      previewRealmUpdateCallable() {
    return previewRealmUpdateCallable;
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
