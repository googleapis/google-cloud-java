/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.dialogflow.cx.v3.stub;

import static com.google.cloud.dialogflow.cx.v3.EntityTypesClient.ListEntityTypesPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.EntityTypesClient.ListLocationsPagedResponse;

import com.google.api.HttpRule;
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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3.CreateEntityTypeRequest;
import com.google.cloud.dialogflow.cx.v3.DeleteEntityTypeRequest;
import com.google.cloud.dialogflow.cx.v3.EntityType;
import com.google.cloud.dialogflow.cx.v3.ExportEntityTypesMetadata;
import com.google.cloud.dialogflow.cx.v3.ExportEntityTypesRequest;
import com.google.cloud.dialogflow.cx.v3.ExportEntityTypesResponse;
import com.google.cloud.dialogflow.cx.v3.GetEntityTypeRequest;
import com.google.cloud.dialogflow.cx.v3.ImportEntityTypesMetadata;
import com.google.cloud.dialogflow.cx.v3.ImportEntityTypesRequest;
import com.google.cloud.dialogflow.cx.v3.ImportEntityTypesResponse;
import com.google.cloud.dialogflow.cx.v3.ListEntityTypesRequest;
import com.google.cloud.dialogflow.cx.v3.ListEntityTypesResponse;
import com.google.cloud.dialogflow.cx.v3.UpdateEntityTypeRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * REST stub implementation for the EntityTypes service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonEntityTypesStub extends EntityTypesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(ImportEntityTypesResponse.getDescriptor())
          .add(ExportEntityTypesResponse.getDescriptor())
          .add(ImportEntityTypesMetadata.getDescriptor())
          .add(ExportEntityTypesMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<GetEntityTypeRequest, EntityType>
      getEntityTypeMethodDescriptor =
          ApiMethodDescriptor.<GetEntityTypeRequest, EntityType>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3.EntityTypes/GetEntityType")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEntityTypeRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*/locations/*/agents/*/entityTypes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEntityTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEntityTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EntityType>newBuilder()
                      .setDefaultInstance(EntityType.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateEntityTypeRequest, EntityType>
      createEntityTypeMethodDescriptor =
          ApiMethodDescriptor.<CreateEntityTypeRequest, EntityType>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3.EntityTypes/CreateEntityType")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEntityTypeRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*/agents/*}/entityTypes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEntityTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEntityTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("entityType", request.getEntityType(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EntityType>newBuilder()
                      .setDefaultInstance(EntityType.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateEntityTypeRequest, EntityType>
      updateEntityTypeMethodDescriptor =
          ApiMethodDescriptor.<UpdateEntityTypeRequest, EntityType>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3.EntityTypes/UpdateEntityType")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateEntityTypeRequest>newBuilder()
                      .setPath(
                          "/v3/{entityType.name=projects/*/locations/*/agents/*/entityTypes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEntityTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "entityType.name", request.getEntityType().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEntityTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("entityType", request.getEntityType(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EntityType>newBuilder()
                      .setDefaultInstance(EntityType.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteEntityTypeRequest, Empty>
      deleteEntityTypeMethodDescriptor =
          ApiMethodDescriptor.<DeleteEntityTypeRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3.EntityTypes/DeleteEntityType")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEntityTypeRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*/locations/*/agents/*/entityTypes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEntityTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEntityTypeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListEntityTypesRequest, ListEntityTypesResponse>
      listEntityTypesMethodDescriptor =
          ApiMethodDescriptor.<ListEntityTypesRequest, ListEntityTypesResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3.EntityTypes/ListEntityTypes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEntityTypesRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*/agents/*}/entityTypes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEntityTypesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEntityTypesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListEntityTypesResponse>newBuilder()
                      .setDefaultInstance(ListEntityTypesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ExportEntityTypesRequest, Operation>
      exportEntityTypesMethodDescriptor =
          ApiMethodDescriptor.<ExportEntityTypesRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3.EntityTypes/ExportEntityTypes")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportEntityTypesRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*/agents/*}/entityTypes:export",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportEntityTypesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportEntityTypesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExportEntityTypesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ImportEntityTypesRequest, Operation>
      importEntityTypesMethodDescriptor =
          ApiMethodDescriptor.<ImportEntityTypesRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3.EntityTypes/ImportEntityTypes")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportEntityTypesRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*/agents/*}/entityTypes:import",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportEntityTypesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportEntityTypesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ImportEntityTypesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetEntityTypeRequest, EntityType> getEntityTypeCallable;
  private final UnaryCallable<CreateEntityTypeRequest, EntityType> createEntityTypeCallable;
  private final UnaryCallable<UpdateEntityTypeRequest, EntityType> updateEntityTypeCallable;
  private final UnaryCallable<DeleteEntityTypeRequest, Empty> deleteEntityTypeCallable;
  private final UnaryCallable<ListEntityTypesRequest, ListEntityTypesResponse>
      listEntityTypesCallable;
  private final UnaryCallable<ListEntityTypesRequest, ListEntityTypesPagedResponse>
      listEntityTypesPagedCallable;
  private final UnaryCallable<ExportEntityTypesRequest, Operation> exportEntityTypesCallable;
  private final OperationCallable<
          ExportEntityTypesRequest, ExportEntityTypesResponse, ExportEntityTypesMetadata>
      exportEntityTypesOperationCallable;
  private final UnaryCallable<ImportEntityTypesRequest, Operation> importEntityTypesCallable;
  private final OperationCallable<
          ImportEntityTypesRequest, ImportEntityTypesResponse, ImportEntityTypesMetadata>
      importEntityTypesOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonEntityTypesStub create(EntityTypesStubSettings settings)
      throws IOException {
    return new HttpJsonEntityTypesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonEntityTypesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonEntityTypesStub(
        EntityTypesStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonEntityTypesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonEntityTypesStub(
        EntityTypesStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonEntityTypesStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonEntityTypesStub(EntityTypesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonEntityTypesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonEntityTypesStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonEntityTypesStub(
      EntityTypesStubSettings settings,
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
                        .setPost("/v3/{name=projects/*/operations/*}:cancel")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setPost("/v3/{name=projects/*/locations/*/operations/*}:cancel")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v3/{name=projects/*/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v3/{name=projects/*/locations/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v3/{name=projects/*}/operations")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v3/{name=projects/*/locations/*}/operations")
                                .build())
                        .build())
                .build());

    HttpJsonCallSettings<GetEntityTypeRequest, EntityType> getEntityTypeTransportSettings =
        HttpJsonCallSettings.<GetEntityTypeRequest, EntityType>newBuilder()
            .setMethodDescriptor(getEntityTypeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateEntityTypeRequest, EntityType> createEntityTypeTransportSettings =
        HttpJsonCallSettings.<CreateEntityTypeRequest, EntityType>newBuilder()
            .setMethodDescriptor(createEntityTypeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateEntityTypeRequest, EntityType> updateEntityTypeTransportSettings =
        HttpJsonCallSettings.<UpdateEntityTypeRequest, EntityType>newBuilder()
            .setMethodDescriptor(updateEntityTypeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "entity_type.name", String.valueOf(request.getEntityType().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteEntityTypeRequest, Empty> deleteEntityTypeTransportSettings =
        HttpJsonCallSettings.<DeleteEntityTypeRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteEntityTypeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListEntityTypesRequest, ListEntityTypesResponse>
        listEntityTypesTransportSettings =
            HttpJsonCallSettings.<ListEntityTypesRequest, ListEntityTypesResponse>newBuilder()
                .setMethodDescriptor(listEntityTypesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ExportEntityTypesRequest, Operation> exportEntityTypesTransportSettings =
        HttpJsonCallSettings.<ExportEntityTypesRequest, Operation>newBuilder()
            .setMethodDescriptor(exportEntityTypesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ImportEntityTypesRequest, Operation> importEntityTypesTransportSettings =
        HttpJsonCallSettings.<ImportEntityTypesRequest, Operation>newBuilder()
            .setMethodDescriptor(importEntityTypesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getEntityTypeCallable =
        callableFactory.createUnaryCallable(
            getEntityTypeTransportSettings, settings.getEntityTypeSettings(), clientContext);
    this.createEntityTypeCallable =
        callableFactory.createUnaryCallable(
            createEntityTypeTransportSettings, settings.createEntityTypeSettings(), clientContext);
    this.updateEntityTypeCallable =
        callableFactory.createUnaryCallable(
            updateEntityTypeTransportSettings, settings.updateEntityTypeSettings(), clientContext);
    this.deleteEntityTypeCallable =
        callableFactory.createUnaryCallable(
            deleteEntityTypeTransportSettings, settings.deleteEntityTypeSettings(), clientContext);
    this.listEntityTypesCallable =
        callableFactory.createUnaryCallable(
            listEntityTypesTransportSettings, settings.listEntityTypesSettings(), clientContext);
    this.listEntityTypesPagedCallable =
        callableFactory.createPagedCallable(
            listEntityTypesTransportSettings, settings.listEntityTypesSettings(), clientContext);
    this.exportEntityTypesCallable =
        callableFactory.createUnaryCallable(
            exportEntityTypesTransportSettings,
            settings.exportEntityTypesSettings(),
            clientContext);
    this.exportEntityTypesOperationCallable =
        callableFactory.createOperationCallable(
            exportEntityTypesTransportSettings,
            settings.exportEntityTypesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.importEntityTypesCallable =
        callableFactory.createUnaryCallable(
            importEntityTypesTransportSettings,
            settings.importEntityTypesSettings(),
            clientContext);
    this.importEntityTypesOperationCallable =
        callableFactory.createOperationCallable(
            importEntityTypesTransportSettings,
            settings.importEntityTypesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getEntityTypeMethodDescriptor);
    methodDescriptors.add(createEntityTypeMethodDescriptor);
    methodDescriptors.add(updateEntityTypeMethodDescriptor);
    methodDescriptors.add(deleteEntityTypeMethodDescriptor);
    methodDescriptors.add(listEntityTypesMethodDescriptor);
    methodDescriptors.add(exportEntityTypesMethodDescriptor);
    methodDescriptors.add(importEntityTypesMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<GetEntityTypeRequest, EntityType> getEntityTypeCallable() {
    return getEntityTypeCallable;
  }

  @Override
  public UnaryCallable<CreateEntityTypeRequest, EntityType> createEntityTypeCallable() {
    return createEntityTypeCallable;
  }

  @Override
  public UnaryCallable<UpdateEntityTypeRequest, EntityType> updateEntityTypeCallable() {
    return updateEntityTypeCallable;
  }

  @Override
  public UnaryCallable<DeleteEntityTypeRequest, Empty> deleteEntityTypeCallable() {
    return deleteEntityTypeCallable;
  }

  @Override
  public UnaryCallable<ListEntityTypesRequest, ListEntityTypesResponse> listEntityTypesCallable() {
    return listEntityTypesCallable;
  }

  @Override
  public UnaryCallable<ListEntityTypesRequest, ListEntityTypesPagedResponse>
      listEntityTypesPagedCallable() {
    return listEntityTypesPagedCallable;
  }

  @Override
  public UnaryCallable<ExportEntityTypesRequest, Operation> exportEntityTypesCallable() {
    return exportEntityTypesCallable;
  }

  @Override
  public OperationCallable<
          ExportEntityTypesRequest, ExportEntityTypesResponse, ExportEntityTypesMetadata>
      exportEntityTypesOperationCallable() {
    return exportEntityTypesOperationCallable;
  }

  @Override
  public UnaryCallable<ImportEntityTypesRequest, Operation> importEntityTypesCallable() {
    return importEntityTypesCallable;
  }

  @Override
  public OperationCallable<
          ImportEntityTypesRequest, ImportEntityTypesResponse, ImportEntityTypesMetadata>
      importEntityTypesOperationCallable() {
    return importEntityTypesOperationCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
