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
 * REST stub implementation for the IdentityMappingStoreService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonIdentityMappingStoreServiceStub extends IdentityMappingStoreServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(ImportIdentityMappingsResponse.getDescriptor())
          .add(IdentityMappingEntryOperationMetadata.getDescriptor())
          .add(DeleteIdentityMappingStoreMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateIdentityMappingStoreRequest, IdentityMappingStore>
      createIdentityMappingStoreMethodDescriptor =
          ApiMethodDescriptor.<CreateIdentityMappingStoreRequest, IdentityMappingStore>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.IdentityMappingStoreService/CreateIdentityMappingStore")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateIdentityMappingStoreRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/identityMappingStores",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateIdentityMappingStoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateIdentityMappingStoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "cmekConfigName", request.getCmekConfigName());
                            serializer.putQueryParam(
                                fields, "disableCmek", request.getDisableCmek());
                            serializer.putQueryParam(
                                fields,
                                "identityMappingStoreId",
                                request.getIdentityMappingStoreId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "identityMappingStore",
                                      request.getIdentityMappingStore(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IdentityMappingStore>newBuilder()
                      .setDefaultInstance(IdentityMappingStore.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIdentityMappingStoreRequest, IdentityMappingStore>
      getIdentityMappingStoreMethodDescriptor =
          ApiMethodDescriptor.<GetIdentityMappingStoreRequest, IdentityMappingStore>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.IdentityMappingStoreService/GetIdentityMappingStore")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIdentityMappingStoreRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/identityMappingStores/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIdentityMappingStoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIdentityMappingStoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IdentityMappingStore>newBuilder()
                      .setDefaultInstance(IdentityMappingStore.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteIdentityMappingStoreRequest, Operation>
      deleteIdentityMappingStoreMethodDescriptor =
          ApiMethodDescriptor.<DeleteIdentityMappingStoreRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.IdentityMappingStoreService/DeleteIdentityMappingStore")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteIdentityMappingStoreRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/identityMappingStores/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteIdentityMappingStoreRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteIdentityMappingStoreRequest> serializer =
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
                  (DeleteIdentityMappingStoreRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ImportIdentityMappingsRequest, Operation>
      importIdentityMappingsMethodDescriptor =
          ApiMethodDescriptor.<ImportIdentityMappingsRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.IdentityMappingStoreService/ImportIdentityMappings")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportIdentityMappingsRequest>newBuilder()
                      .setPath(
                          "/v1/{identityMappingStore=projects/*/locations/*/identityMappingStores/*}:importIdentityMappings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportIdentityMappingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "identityMappingStore", request.getIdentityMappingStore());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportIdentityMappingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearIdentityMappingStore().build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ImportIdentityMappingsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<PurgeIdentityMappingsRequest, Operation>
      purgeIdentityMappingsMethodDescriptor =
          ApiMethodDescriptor.<PurgeIdentityMappingsRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.IdentityMappingStoreService/PurgeIdentityMappings")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PurgeIdentityMappingsRequest>newBuilder()
                      .setPath(
                          "/v1/{identityMappingStore=projects/*/locations/*/identityMappingStores/*}:purgeIdentityMappings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PurgeIdentityMappingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "identityMappingStore", request.getIdentityMappingStore());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PurgeIdentityMappingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearIdentityMappingStore().build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PurgeIdentityMappingsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListIdentityMappingsRequest, ListIdentityMappingsResponse>
      listIdentityMappingsMethodDescriptor =
          ApiMethodDescriptor
              .<ListIdentityMappingsRequest, ListIdentityMappingsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.IdentityMappingStoreService/ListIdentityMappings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListIdentityMappingsRequest>newBuilder()
                      .setPath(
                          "/v1/{identityMappingStore=projects/*/locations/*/identityMappingStores/*}:listIdentityMappings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListIdentityMappingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "identityMappingStore", request.getIdentityMappingStore());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListIdentityMappingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListIdentityMappingsResponse>newBuilder()
                      .setDefaultInstance(ListIdentityMappingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListIdentityMappingStoresRequest, ListIdentityMappingStoresResponse>
      listIdentityMappingStoresMethodDescriptor =
          ApiMethodDescriptor
              .<ListIdentityMappingStoresRequest, ListIdentityMappingStoresResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.IdentityMappingStoreService/ListIdentityMappingStores")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListIdentityMappingStoresRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/identityMappingStores",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListIdentityMappingStoresRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListIdentityMappingStoresRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListIdentityMappingStoresResponse>newBuilder()
                      .setDefaultInstance(ListIdentityMappingStoresResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonIdentityMappingStoreServiceStub create(
      IdentityMappingStoreServiceStubSettings settings) throws IOException {
    return new HttpJsonIdentityMappingStoreServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonIdentityMappingStoreServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonIdentityMappingStoreServiceStub(
        IdentityMappingStoreServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonIdentityMappingStoreServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonIdentityMappingStoreServiceStub(
        IdentityMappingStoreServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonIdentityMappingStoreServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonIdentityMappingStoreServiceStub(
      IdentityMappingStoreServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonIdentityMappingStoreServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonIdentityMappingStoreServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonIdentityMappingStoreServiceStub(
      IdentityMappingStoreServiceStubSettings settings,
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

    HttpJsonCallSettings<CreateIdentityMappingStoreRequest, IdentityMappingStore>
        createIdentityMappingStoreTransportSettings =
            HttpJsonCallSettings
                .<CreateIdentityMappingStoreRequest, IdentityMappingStore>newBuilder()
                .setMethodDescriptor(createIdentityMappingStoreMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetIdentityMappingStoreRequest, IdentityMappingStore>
        getIdentityMappingStoreTransportSettings =
            HttpJsonCallSettings.<GetIdentityMappingStoreRequest, IdentityMappingStore>newBuilder()
                .setMethodDescriptor(getIdentityMappingStoreMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteIdentityMappingStoreRequest, Operation>
        deleteIdentityMappingStoreTransportSettings =
            HttpJsonCallSettings.<DeleteIdentityMappingStoreRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteIdentityMappingStoreMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ImportIdentityMappingsRequest, Operation>
        importIdentityMappingsTransportSettings =
            HttpJsonCallSettings.<ImportIdentityMappingsRequest, Operation>newBuilder()
                .setMethodDescriptor(importIdentityMappingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "identity_mapping_store",
                          String.valueOf(request.getIdentityMappingStore()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<PurgeIdentityMappingsRequest, Operation>
        purgeIdentityMappingsTransportSettings =
            HttpJsonCallSettings.<PurgeIdentityMappingsRequest, Operation>newBuilder()
                .setMethodDescriptor(purgeIdentityMappingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "identity_mapping_store",
                          String.valueOf(request.getIdentityMappingStore()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListIdentityMappingsRequest, ListIdentityMappingsResponse>
        listIdentityMappingsTransportSettings =
            HttpJsonCallSettings
                .<ListIdentityMappingsRequest, ListIdentityMappingsResponse>newBuilder()
                .setMethodDescriptor(listIdentityMappingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "identity_mapping_store",
                          String.valueOf(request.getIdentityMappingStore()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListIdentityMappingStoresRequest, ListIdentityMappingStoresResponse>
        listIdentityMappingStoresTransportSettings =
            HttpJsonCallSettings
                .<ListIdentityMappingStoresRequest, ListIdentityMappingStoresResponse>newBuilder()
                .setMethodDescriptor(listIdentityMappingStoresMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createIdentityMappingStoreMethodDescriptor);
    methodDescriptors.add(getIdentityMappingStoreMethodDescriptor);
    methodDescriptors.add(deleteIdentityMappingStoreMethodDescriptor);
    methodDescriptors.add(importIdentityMappingsMethodDescriptor);
    methodDescriptors.add(purgeIdentityMappingsMethodDescriptor);
    methodDescriptors.add(listIdentityMappingsMethodDescriptor);
    methodDescriptors.add(listIdentityMappingStoresMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
