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

import static com.google.cloud.discoveryengine.v1.DataStoreServiceClient.ListDataStoresPagedResponse;

import com.google.api.HttpRule;
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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1.CreateDataStoreMetadata;
import com.google.cloud.discoveryengine.v1.CreateDataStoreRequest;
import com.google.cloud.discoveryengine.v1.DataStore;
import com.google.cloud.discoveryengine.v1.DeleteDataStoreMetadata;
import com.google.cloud.discoveryengine.v1.DeleteDataStoreRequest;
import com.google.cloud.discoveryengine.v1.GetDataStoreRequest;
import com.google.cloud.discoveryengine.v1.ListDataStoresRequest;
import com.google.cloud.discoveryengine.v1.ListDataStoresResponse;
import com.google.cloud.discoveryengine.v1.UpdateDataStoreRequest;
import com.google.common.collect.ImmutableMap;
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
 * REST stub implementation for the DataStoreService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonDataStoreServiceStub extends DataStoreServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(DeleteDataStoreMetadata.getDescriptor())
          .add(Empty.getDescriptor())
          .add(DataStore.getDescriptor())
          .add(CreateDataStoreMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateDataStoreRequest, Operation>
      createDataStoreMethodDescriptor =
          ApiMethodDescriptor.<CreateDataStoreRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1.DataStoreService/CreateDataStore")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDataStoreRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/dataStores",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataStoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=projects/*/locations/*/collections/*}/dataStores")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataStoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "cmekConfigName", request.getCmekConfigName());
                            serializer.putQueryParam(
                                fields,
                                "createAdvancedSiteSearch",
                                request.getCreateAdvancedSiteSearch());
                            serializer.putQueryParam(
                                fields, "dataStoreId", request.getDataStoreId());
                            serializer.putQueryParam(
                                fields, "disableCmek", request.getDisableCmek());
                            serializer.putQueryParam(
                                fields,
                                "skipDefaultSchemaCreation",
                                request.getSkipDefaultSchemaCreation());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataStore", request.getDataStore(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateDataStoreRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetDataStoreRequest, DataStore>
      getDataStoreMethodDescriptor =
          ApiMethodDescriptor.<GetDataStoreRequest, DataStore>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1.DataStoreService/GetDataStore")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataStoreRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataStores/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataStoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=projects/*/locations/*/collections/*/dataStores/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataStoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataStore>newBuilder()
                      .setDefaultInstance(DataStore.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDataStoresRequest, ListDataStoresResponse>
      listDataStoresMethodDescriptor =
          ApiMethodDescriptor.<ListDataStoresRequest, ListDataStoresResponse>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1.DataStoreService/ListDataStores")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDataStoresRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/dataStores",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataStoresRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=projects/*/locations/*/collections/*}/dataStores")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataStoresRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDataStoresResponse>newBuilder()
                      .setDefaultInstance(ListDataStoresResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDataStoreRequest, Operation>
      deleteDataStoreMethodDescriptor =
          ApiMethodDescriptor.<DeleteDataStoreRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1.DataStoreService/DeleteDataStore")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDataStoreRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataStores/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataStoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=projects/*/locations/*/collections/*/dataStores/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataStoreRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (DeleteDataStoreRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateDataStoreRequest, DataStore>
      updateDataStoreMethodDescriptor =
          ApiMethodDescriptor.<UpdateDataStoreRequest, DataStore>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1.DataStoreService/UpdateDataStore")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDataStoreRequest>newBuilder()
                      .setPath(
                          "/v1/{dataStore.name=projects/*/locations/*/dataStores/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataStoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "dataStore.name", request.getDataStore().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{dataStore.name=projects/*/locations/*/collections/*/dataStores/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataStoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataStore", request.getDataStore(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataStore>newBuilder()
                      .setDefaultInstance(DataStore.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateDataStoreRequest, Operation> createDataStoreCallable;
  private final OperationCallable<CreateDataStoreRequest, DataStore, CreateDataStoreMetadata>
      createDataStoreOperationCallable;
  private final UnaryCallable<GetDataStoreRequest, DataStore> getDataStoreCallable;
  private final UnaryCallable<ListDataStoresRequest, ListDataStoresResponse> listDataStoresCallable;
  private final UnaryCallable<ListDataStoresRequest, ListDataStoresPagedResponse>
      listDataStoresPagedCallable;
  private final UnaryCallable<DeleteDataStoreRequest, Operation> deleteDataStoreCallable;
  private final OperationCallable<DeleteDataStoreRequest, Empty, DeleteDataStoreMetadata>
      deleteDataStoreOperationCallable;
  private final UnaryCallable<UpdateDataStoreRequest, DataStore> updateDataStoreCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDataStoreServiceStub create(DataStoreServiceStubSettings settings)
      throws IOException {
    return new HttpJsonDataStoreServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDataStoreServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDataStoreServiceStub(
        DataStoreServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDataStoreServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDataStoreServiceStub(
        DataStoreServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDataStoreServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataStoreServiceStub(
      DataStoreServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDataStoreServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDataStoreServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataStoreServiceStub(
      DataStoreServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1/{name=projects/*/operations/*}:cancel")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setPost(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/branches/*/operations/*}:cancel")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setPost(
                                    "/v1/{name=projects/*/locations/*/collections/*/engines/*/operations/*}:cancel")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setPost(
                                    "/v1/{name=projects/*/locations/*/dataStores/*/branches/*/operations/*}:cancel")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataConnector/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/branches/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/models/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/schemas/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/targetSites/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/engines/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/dataStores/*/branches/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/dataStores/*/models/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/dataStores/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/identityMappingStores/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*}/operations")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataConnector}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/branches/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/models/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/schemas/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/targetSites}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/engines/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/dataStores/*/branches/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/dataStores/*/models/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*/locations/*/dataStores/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/identityMappingStores/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*/locations/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*}/operations")
                                .build())
                        .build())
                .build());

    HttpJsonCallSettings<CreateDataStoreRequest, Operation> createDataStoreTransportSettings =
        HttpJsonCallSettings.<CreateDataStoreRequest, Operation>newBuilder()
            .setMethodDescriptor(createDataStoreMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetDataStoreRequest, DataStore> getDataStoreTransportSettings =
        HttpJsonCallSettings.<GetDataStoreRequest, DataStore>newBuilder()
            .setMethodDescriptor(getDataStoreMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListDataStoresRequest, ListDataStoresResponse>
        listDataStoresTransportSettings =
            HttpJsonCallSettings.<ListDataStoresRequest, ListDataStoresResponse>newBuilder()
                .setMethodDescriptor(listDataStoresMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteDataStoreRequest, Operation> deleteDataStoreTransportSettings =
        HttpJsonCallSettings.<DeleteDataStoreRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDataStoreMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateDataStoreRequest, DataStore> updateDataStoreTransportSettings =
        HttpJsonCallSettings.<UpdateDataStoreRequest, DataStore>newBuilder()
            .setMethodDescriptor(updateDataStoreMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("data_store.name", String.valueOf(request.getDataStore().getName()));
                  return builder.build();
                })
            .build();

    this.createDataStoreCallable =
        callableFactory.createUnaryCallable(
            createDataStoreTransportSettings, settings.createDataStoreSettings(), clientContext);
    this.createDataStoreOperationCallable =
        callableFactory.createOperationCallable(
            createDataStoreTransportSettings,
            settings.createDataStoreOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getDataStoreCallable =
        callableFactory.createUnaryCallable(
            getDataStoreTransportSettings, settings.getDataStoreSettings(), clientContext);
    this.listDataStoresCallable =
        callableFactory.createUnaryCallable(
            listDataStoresTransportSettings, settings.listDataStoresSettings(), clientContext);
    this.listDataStoresPagedCallable =
        callableFactory.createPagedCallable(
            listDataStoresTransportSettings, settings.listDataStoresSettings(), clientContext);
    this.deleteDataStoreCallable =
        callableFactory.createUnaryCallable(
            deleteDataStoreTransportSettings, settings.deleteDataStoreSettings(), clientContext);
    this.deleteDataStoreOperationCallable =
        callableFactory.createOperationCallable(
            deleteDataStoreTransportSettings,
            settings.deleteDataStoreOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateDataStoreCallable =
        callableFactory.createUnaryCallable(
            updateDataStoreTransportSettings, settings.updateDataStoreSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createDataStoreMethodDescriptor);
    methodDescriptors.add(getDataStoreMethodDescriptor);
    methodDescriptors.add(listDataStoresMethodDescriptor);
    methodDescriptors.add(deleteDataStoreMethodDescriptor);
    methodDescriptors.add(updateDataStoreMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateDataStoreRequest, Operation> createDataStoreCallable() {
    return createDataStoreCallable;
  }

  @Override
  public OperationCallable<CreateDataStoreRequest, DataStore, CreateDataStoreMetadata>
      createDataStoreOperationCallable() {
    return createDataStoreOperationCallable;
  }

  @Override
  public UnaryCallable<GetDataStoreRequest, DataStore> getDataStoreCallable() {
    return getDataStoreCallable;
  }

  @Override
  public UnaryCallable<ListDataStoresRequest, ListDataStoresResponse> listDataStoresCallable() {
    return listDataStoresCallable;
  }

  @Override
  public UnaryCallable<ListDataStoresRequest, ListDataStoresPagedResponse>
      listDataStoresPagedCallable() {
    return listDataStoresPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteDataStoreRequest, Operation> deleteDataStoreCallable() {
    return deleteDataStoreCallable;
  }

  @Override
  public OperationCallable<DeleteDataStoreRequest, Empty, DeleteDataStoreMetadata>
      deleteDataStoreOperationCallable() {
    return deleteDataStoreOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDataStoreRequest, DataStore> updateDataStoreCallable() {
    return updateDataStoreCallable;
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
