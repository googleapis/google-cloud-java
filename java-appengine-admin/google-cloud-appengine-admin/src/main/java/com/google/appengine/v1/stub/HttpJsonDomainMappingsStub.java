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
 * REST stub implementation for the DomainMappings service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonDomainMappingsStub extends DomainMappingsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(DomainMapping.getDescriptor())
          .add(OperationMetadataV1.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListDomainMappingsRequest, ListDomainMappingsResponse>
      listDomainMappingsMethodDescriptor =
          ApiMethodDescriptor.<ListDomainMappingsRequest, ListDomainMappingsResponse>newBuilder()
              .setFullMethodName("google.appengine.v1.DomainMappings/ListDomainMappings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDomainMappingsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=apps/*}/domainMappings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDomainMappingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDomainMappingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDomainMappingsResponse>newBuilder()
                      .setDefaultInstance(ListDomainMappingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDomainMappingRequest, DomainMapping>
      getDomainMappingMethodDescriptor =
          ApiMethodDescriptor.<GetDomainMappingRequest, DomainMapping>newBuilder()
              .setFullMethodName("google.appengine.v1.DomainMappings/GetDomainMapping")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDomainMappingRequest>newBuilder()
                      .setPath(
                          "/v1/{name=apps/*/domainMappings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDomainMappingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDomainMappingRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DomainMapping>newBuilder()
                      .setDefaultInstance(DomainMapping.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDomainMappingRequest, Operation>
      createDomainMappingMethodDescriptor =
          ApiMethodDescriptor.<CreateDomainMappingRequest, Operation>newBuilder()
              .setFullMethodName("google.appengine.v1.DomainMappings/CreateDomainMapping")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDomainMappingRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=apps/*}/domainMappings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDomainMappingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDomainMappingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "overrideStrategy", request.getOverrideStrategy());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("domainMapping", request.getDomainMapping(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateDomainMappingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateDomainMappingRequest, Operation>
      updateDomainMappingMethodDescriptor =
          ApiMethodDescriptor.<UpdateDomainMappingRequest, Operation>newBuilder()
              .setFullMethodName("google.appengine.v1.DomainMappings/UpdateDomainMapping")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDomainMappingRequest>newBuilder()
                      .setPath(
                          "/v1/{name=apps/*/domainMappings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDomainMappingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDomainMappingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("domainMapping", request.getDomainMapping(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateDomainMappingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteDomainMappingRequest, Operation>
      deleteDomainMappingMethodDescriptor =
          ApiMethodDescriptor.<DeleteDomainMappingRequest, Operation>newBuilder()
              .setFullMethodName("google.appengine.v1.DomainMappings/DeleteDomainMapping")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDomainMappingRequest>newBuilder()
                      .setPath(
                          "/v1/{name=apps/*/domainMappings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDomainMappingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDomainMappingRequest> serializer =
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
                  (DeleteDomainMappingRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
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
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDomainMappingsStub create(DomainMappingsStubSettings settings)
      throws IOException {
    return new HttpJsonDomainMappingsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDomainMappingsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDomainMappingsStub(
        DomainMappingsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDomainMappingsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDomainMappingsStub(
        DomainMappingsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDomainMappingsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDomainMappingsStub(
      DomainMappingsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDomainMappingsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDomainMappingsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDomainMappingsStub(
      DomainMappingsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListDomainMappingsRequest, ListDomainMappingsResponse>
        listDomainMappingsTransportSettings =
            HttpJsonCallSettings.<ListDomainMappingsRequest, ListDomainMappingsResponse>newBuilder()
                .setMethodDescriptor(listDomainMappingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetDomainMappingRequest, DomainMapping> getDomainMappingTransportSettings =
        HttpJsonCallSettings.<GetDomainMappingRequest, DomainMapping>newBuilder()
            .setMethodDescriptor(getDomainMappingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateDomainMappingRequest, Operation>
        createDomainMappingTransportSettings =
            HttpJsonCallSettings.<CreateDomainMappingRequest, Operation>newBuilder()
                .setMethodDescriptor(createDomainMappingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateDomainMappingRequest, Operation>
        updateDomainMappingTransportSettings =
            HttpJsonCallSettings.<UpdateDomainMappingRequest, Operation>newBuilder()
                .setMethodDescriptor(updateDomainMappingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteDomainMappingRequest, Operation>
        deleteDomainMappingTransportSettings =
            HttpJsonCallSettings.<DeleteDomainMappingRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteDomainMappingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listDomainMappingsMethodDescriptor);
    methodDescriptors.add(getDomainMappingMethodDescriptor);
    methodDescriptors.add(createDomainMappingMethodDescriptor);
    methodDescriptors.add(updateDomainMappingMethodDescriptor);
    methodDescriptors.add(deleteDomainMappingMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
