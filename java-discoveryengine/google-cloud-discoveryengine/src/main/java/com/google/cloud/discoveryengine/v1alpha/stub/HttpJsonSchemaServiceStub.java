/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.discoveryengine.v1alpha.stub;

import static com.google.cloud.discoveryengine.v1alpha.SchemaServiceClient.ListSchemasPagedResponse;

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
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.CreateSchemaMetadata;
import com.google.cloud.discoveryengine.v1alpha.CreateSchemaRequest;
import com.google.cloud.discoveryengine.v1alpha.DeleteSchemaMetadata;
import com.google.cloud.discoveryengine.v1alpha.DeleteSchemaRequest;
import com.google.cloud.discoveryengine.v1alpha.GetSchemaRequest;
import com.google.cloud.discoveryengine.v1alpha.ListSchemasRequest;
import com.google.cloud.discoveryengine.v1alpha.ListSchemasResponse;
import com.google.cloud.discoveryengine.v1alpha.Schema;
import com.google.cloud.discoveryengine.v1alpha.UpdateSchemaMetadata;
import com.google.cloud.discoveryengine.v1alpha.UpdateSchemaRequest;
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
 * REST stub implementation for the SchemaService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonSchemaServiceStub extends SchemaServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Schema.getDescriptor())
          .add(Empty.getDescriptor())
          .add(UpdateSchemaMetadata.getDescriptor())
          .add(DeleteSchemaMetadata.getDescriptor())
          .add(CreateSchemaMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<GetSchemaRequest, Schema> getSchemaMethodDescriptor =
      ApiMethodDescriptor.<GetSchemaRequest, Schema>newBuilder()
          .setFullMethodName("google.cloud.discoveryengine.v1alpha.SchemaService/GetSchema")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSchemaRequest>newBuilder()
                  .setPath(
                      "/v1alpha/{name=projects/*/locations/*/dataStores/*/schemas/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetSchemaRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setAdditionalPaths(
                      "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/schemas/*}")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetSchemaRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Schema>newBuilder()
                  .setDefaultInstance(Schema.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListSchemasRequest, ListSchemasResponse>
      listSchemasMethodDescriptor =
          ApiMethodDescriptor.<ListSchemasRequest, ListSchemasResponse>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1alpha.SchemaService/ListSchemas")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSchemasRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/dataStores/*}/schemas",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSchemasRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{parent=projects/*/locations/*/collections/*/dataStores/*}/schemas")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSchemasRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSchemasResponse>newBuilder()
                      .setDefaultInstance(ListSchemasResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateSchemaRequest, Operation>
      createSchemaMethodDescriptor =
          ApiMethodDescriptor.<CreateSchemaRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1alpha.SchemaService/CreateSchema")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSchemaRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/dataStores/*}/schemas",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSchemaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{parent=projects/*/locations/*/collections/*/dataStores/*}/schemas")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSchemaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "schemaId", request.getSchemaId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("schema", request.getSchema(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateSchemaRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateSchemaRequest, Operation>
      updateSchemaMethodDescriptor =
          ApiMethodDescriptor.<UpdateSchemaRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1alpha.SchemaService/UpdateSchema")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSchemaRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{schema.name=projects/*/locations/*/dataStores/*/schemas/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSchemaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "schema.name", request.getSchema().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{schema.name=projects/*/locations/*/collections/*/dataStores/*/schemas/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSchemaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("schema", request.getSchema(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateSchemaRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteSchemaRequest, Operation>
      deleteSchemaMethodDescriptor =
          ApiMethodDescriptor.<DeleteSchemaRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1alpha.SchemaService/DeleteSchema")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSchemaRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/dataStores/*/schemas/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSchemaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/schemas/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSchemaRequest> serializer =
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
                  (DeleteSchemaRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<GetSchemaRequest, Schema> getSchemaCallable;
  private final UnaryCallable<ListSchemasRequest, ListSchemasResponse> listSchemasCallable;
  private final UnaryCallable<ListSchemasRequest, ListSchemasPagedResponse>
      listSchemasPagedCallable;
  private final UnaryCallable<CreateSchemaRequest, Operation> createSchemaCallable;
  private final OperationCallable<CreateSchemaRequest, Schema, CreateSchemaMetadata>
      createSchemaOperationCallable;
  private final UnaryCallable<UpdateSchemaRequest, Operation> updateSchemaCallable;
  private final OperationCallable<UpdateSchemaRequest, Schema, UpdateSchemaMetadata>
      updateSchemaOperationCallable;
  private final UnaryCallable<DeleteSchemaRequest, Operation> deleteSchemaCallable;
  private final OperationCallable<DeleteSchemaRequest, Empty, DeleteSchemaMetadata>
      deleteSchemaOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSchemaServiceStub create(SchemaServiceStubSettings settings)
      throws IOException {
    return new HttpJsonSchemaServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSchemaServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSchemaServiceStub(
        SchemaServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSchemaServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSchemaServiceStub(
        SchemaServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSchemaServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSchemaServiceStub(
      SchemaServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSchemaServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSchemaServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSchemaServiceStub(
      SchemaServiceStubSettings settings,
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
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet(
                            "/v1alpha/{name=projects/*/locations/*/collections/*/dataConnector/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/branches/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/models/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/schemas/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/targetSites/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/engines/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/branches/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/models/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/evaluations/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1alpha/{name=projects/*/locations/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1alpha/{name=projects/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet(
                            "/v1alpha/{name=projects/*/locations/*/collections/*/dataConnector}/operations")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/branches/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/models/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/schemas/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/targetSites}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/engines/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/branches/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/models/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1alpha/{name=projects/*/locations/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1alpha/{name=projects/*}/operations")
                                .build())
                        .build())
                .build());

    HttpJsonCallSettings<GetSchemaRequest, Schema> getSchemaTransportSettings =
        HttpJsonCallSettings.<GetSchemaRequest, Schema>newBuilder()
            .setMethodDescriptor(getSchemaMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListSchemasRequest, ListSchemasResponse> listSchemasTransportSettings =
        HttpJsonCallSettings.<ListSchemasRequest, ListSchemasResponse>newBuilder()
            .setMethodDescriptor(listSchemasMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateSchemaRequest, Operation> createSchemaTransportSettings =
        HttpJsonCallSettings.<CreateSchemaRequest, Operation>newBuilder()
            .setMethodDescriptor(createSchemaMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateSchemaRequest, Operation> updateSchemaTransportSettings =
        HttpJsonCallSettings.<UpdateSchemaRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSchemaMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("schema.name", String.valueOf(request.getSchema().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteSchemaRequest, Operation> deleteSchemaTransportSettings =
        HttpJsonCallSettings.<DeleteSchemaRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSchemaMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getSchemaCallable =
        callableFactory.createUnaryCallable(
            getSchemaTransportSettings, settings.getSchemaSettings(), clientContext);
    this.listSchemasCallable =
        callableFactory.createUnaryCallable(
            listSchemasTransportSettings, settings.listSchemasSettings(), clientContext);
    this.listSchemasPagedCallable =
        callableFactory.createPagedCallable(
            listSchemasTransportSettings, settings.listSchemasSettings(), clientContext);
    this.createSchemaCallable =
        callableFactory.createUnaryCallable(
            createSchemaTransportSettings, settings.createSchemaSettings(), clientContext);
    this.createSchemaOperationCallable =
        callableFactory.createOperationCallable(
            createSchemaTransportSettings,
            settings.createSchemaOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateSchemaCallable =
        callableFactory.createUnaryCallable(
            updateSchemaTransportSettings, settings.updateSchemaSettings(), clientContext);
    this.updateSchemaOperationCallable =
        callableFactory.createOperationCallable(
            updateSchemaTransportSettings,
            settings.updateSchemaOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteSchemaCallable =
        callableFactory.createUnaryCallable(
            deleteSchemaTransportSettings, settings.deleteSchemaSettings(), clientContext);
    this.deleteSchemaOperationCallable =
        callableFactory.createOperationCallable(
            deleteSchemaTransportSettings,
            settings.deleteSchemaOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getSchemaMethodDescriptor);
    methodDescriptors.add(listSchemasMethodDescriptor);
    methodDescriptors.add(createSchemaMethodDescriptor);
    methodDescriptors.add(updateSchemaMethodDescriptor);
    methodDescriptors.add(deleteSchemaMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<GetSchemaRequest, Schema> getSchemaCallable() {
    return getSchemaCallable;
  }

  @Override
  public UnaryCallable<ListSchemasRequest, ListSchemasResponse> listSchemasCallable() {
    return listSchemasCallable;
  }

  @Override
  public UnaryCallable<ListSchemasRequest, ListSchemasPagedResponse> listSchemasPagedCallable() {
    return listSchemasPagedCallable;
  }

  @Override
  public UnaryCallable<CreateSchemaRequest, Operation> createSchemaCallable() {
    return createSchemaCallable;
  }

  @Override
  public OperationCallable<CreateSchemaRequest, Schema, CreateSchemaMetadata>
      createSchemaOperationCallable() {
    return createSchemaOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateSchemaRequest, Operation> updateSchemaCallable() {
    return updateSchemaCallable;
  }

  @Override
  public OperationCallable<UpdateSchemaRequest, Schema, UpdateSchemaMetadata>
      updateSchemaOperationCallable() {
    return updateSchemaOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteSchemaRequest, Operation> deleteSchemaCallable() {
    return deleteSchemaCallable;
  }

  @Override
  public OperationCallable<DeleteSchemaRequest, Empty, DeleteSchemaMetadata>
      deleteSchemaOperationCallable() {
    return deleteSchemaOperationCallable;
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
