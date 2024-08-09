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

import static com.google.cloud.discoveryengine.v1alpha.SampleQueryServiceClient.ListSampleQueriesPagedResponse;

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
import com.google.cloud.discoveryengine.v1alpha.CreateSampleQueryRequest;
import com.google.cloud.discoveryengine.v1alpha.DeleteSampleQueryRequest;
import com.google.cloud.discoveryengine.v1alpha.GetSampleQueryRequest;
import com.google.cloud.discoveryengine.v1alpha.ImportSampleQueriesMetadata;
import com.google.cloud.discoveryengine.v1alpha.ImportSampleQueriesRequest;
import com.google.cloud.discoveryengine.v1alpha.ImportSampleQueriesResponse;
import com.google.cloud.discoveryengine.v1alpha.ListSampleQueriesRequest;
import com.google.cloud.discoveryengine.v1alpha.ListSampleQueriesResponse;
import com.google.cloud.discoveryengine.v1alpha.SampleQuery;
import com.google.cloud.discoveryengine.v1alpha.UpdateSampleQueryRequest;
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
 * REST stub implementation for the SampleQueryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonSampleQueryServiceStub extends SampleQueryServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(ImportSampleQueriesResponse.getDescriptor())
          .add(ImportSampleQueriesMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<GetSampleQueryRequest, SampleQuery>
      getSampleQueryMethodDescriptor =
          ApiMethodDescriptor.<GetSampleQueryRequest, SampleQuery>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SampleQueryService/GetSampleQuery")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSampleQueryRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/sampleQuerySets/*/sampleQueries/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSampleQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSampleQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SampleQuery>newBuilder()
                      .setDefaultInstance(SampleQuery.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListSampleQueriesRequest, ListSampleQueriesResponse>
      listSampleQueriesMethodDescriptor =
          ApiMethodDescriptor.<ListSampleQueriesRequest, ListSampleQueriesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SampleQueryService/ListSampleQueries")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSampleQueriesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/sampleQuerySets/*}/sampleQueries",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSampleQueriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSampleQueriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSampleQueriesResponse>newBuilder()
                      .setDefaultInstance(ListSampleQueriesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateSampleQueryRequest, SampleQuery>
      createSampleQueryMethodDescriptor =
          ApiMethodDescriptor.<CreateSampleQueryRequest, SampleQuery>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SampleQueryService/CreateSampleQuery")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSampleQueryRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/sampleQuerySets/*}/sampleQueries",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSampleQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSampleQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "sampleQueryId", request.getSampleQueryId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("sampleQuery", request.getSampleQuery(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SampleQuery>newBuilder()
                      .setDefaultInstance(SampleQuery.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSampleQueryRequest, SampleQuery>
      updateSampleQueryMethodDescriptor =
          ApiMethodDescriptor.<UpdateSampleQueryRequest, SampleQuery>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SampleQueryService/UpdateSampleQuery")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSampleQueryRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{sampleQuery.name=projects/*/locations/*/sampleQuerySets/*/sampleQueries/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSampleQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "sampleQuery.name", request.getSampleQuery().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSampleQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("sampleQuery", request.getSampleQuery(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SampleQuery>newBuilder()
                      .setDefaultInstance(SampleQuery.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSampleQueryRequest, Empty>
      deleteSampleQueryMethodDescriptor =
          ApiMethodDescriptor.<DeleteSampleQueryRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SampleQueryService/DeleteSampleQuery")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSampleQueryRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/sampleQuerySets/*/sampleQueries/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSampleQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSampleQueryRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<ImportSampleQueriesRequest, Operation>
      importSampleQueriesMethodDescriptor =
          ApiMethodDescriptor.<ImportSampleQueriesRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SampleQueryService/ImportSampleQueries")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportSampleQueriesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/sampleQuerySets/*}/sampleQueries:import",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportSampleQueriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportSampleQueriesRequest> serializer =
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
                  (ImportSampleQueriesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<GetSampleQueryRequest, SampleQuery> getSampleQueryCallable;
  private final UnaryCallable<ListSampleQueriesRequest, ListSampleQueriesResponse>
      listSampleQueriesCallable;
  private final UnaryCallable<ListSampleQueriesRequest, ListSampleQueriesPagedResponse>
      listSampleQueriesPagedCallable;
  private final UnaryCallable<CreateSampleQueryRequest, SampleQuery> createSampleQueryCallable;
  private final UnaryCallable<UpdateSampleQueryRequest, SampleQuery> updateSampleQueryCallable;
  private final UnaryCallable<DeleteSampleQueryRequest, Empty> deleteSampleQueryCallable;
  private final UnaryCallable<ImportSampleQueriesRequest, Operation> importSampleQueriesCallable;
  private final OperationCallable<
          ImportSampleQueriesRequest, ImportSampleQueriesResponse, ImportSampleQueriesMetadata>
      importSampleQueriesOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSampleQueryServiceStub create(SampleQueryServiceStubSettings settings)
      throws IOException {
    return new HttpJsonSampleQueryServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSampleQueryServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSampleQueryServiceStub(
        SampleQueryServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSampleQueryServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSampleQueryServiceStub(
        SampleQueryServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSampleQueryServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSampleQueryServiceStub(
      SampleQueryServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSampleQueryServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSampleQueryServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSampleQueryServiceStub(
      SampleQueryServiceStubSettings settings,
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
                        .setPost(
                            "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/branches/*/operations/*}:cancel")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setPost(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/branches/*/operations/*}:cancel")
                                .build())
                        .build())
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
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/identity_mapping_stores/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1alpha/{name=projects/*/locations/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/sampleQuerySets/*/operations/*}")
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
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/identity_mapping_stores/*}/operations")
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

    HttpJsonCallSettings<GetSampleQueryRequest, SampleQuery> getSampleQueryTransportSettings =
        HttpJsonCallSettings.<GetSampleQueryRequest, SampleQuery>newBuilder()
            .setMethodDescriptor(getSampleQueryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListSampleQueriesRequest, ListSampleQueriesResponse>
        listSampleQueriesTransportSettings =
            HttpJsonCallSettings.<ListSampleQueriesRequest, ListSampleQueriesResponse>newBuilder()
                .setMethodDescriptor(listSampleQueriesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateSampleQueryRequest, SampleQuery> createSampleQueryTransportSettings =
        HttpJsonCallSettings.<CreateSampleQueryRequest, SampleQuery>newBuilder()
            .setMethodDescriptor(createSampleQueryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateSampleQueryRequest, SampleQuery> updateSampleQueryTransportSettings =
        HttpJsonCallSettings.<UpdateSampleQueryRequest, SampleQuery>newBuilder()
            .setMethodDescriptor(updateSampleQueryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "sample_query.name", String.valueOf(request.getSampleQuery().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteSampleQueryRequest, Empty> deleteSampleQueryTransportSettings =
        HttpJsonCallSettings.<DeleteSampleQueryRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSampleQueryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ImportSampleQueriesRequest, Operation>
        importSampleQueriesTransportSettings =
            HttpJsonCallSettings.<ImportSampleQueriesRequest, Operation>newBuilder()
                .setMethodDescriptor(importSampleQueriesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getSampleQueryCallable =
        callableFactory.createUnaryCallable(
            getSampleQueryTransportSettings, settings.getSampleQuerySettings(), clientContext);
    this.listSampleQueriesCallable =
        callableFactory.createUnaryCallable(
            listSampleQueriesTransportSettings,
            settings.listSampleQueriesSettings(),
            clientContext);
    this.listSampleQueriesPagedCallable =
        callableFactory.createPagedCallable(
            listSampleQueriesTransportSettings,
            settings.listSampleQueriesSettings(),
            clientContext);
    this.createSampleQueryCallable =
        callableFactory.createUnaryCallable(
            createSampleQueryTransportSettings,
            settings.createSampleQuerySettings(),
            clientContext);
    this.updateSampleQueryCallable =
        callableFactory.createUnaryCallable(
            updateSampleQueryTransportSettings,
            settings.updateSampleQuerySettings(),
            clientContext);
    this.deleteSampleQueryCallable =
        callableFactory.createUnaryCallable(
            deleteSampleQueryTransportSettings,
            settings.deleteSampleQuerySettings(),
            clientContext);
    this.importSampleQueriesCallable =
        callableFactory.createUnaryCallable(
            importSampleQueriesTransportSettings,
            settings.importSampleQueriesSettings(),
            clientContext);
    this.importSampleQueriesOperationCallable =
        callableFactory.createOperationCallable(
            importSampleQueriesTransportSettings,
            settings.importSampleQueriesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getSampleQueryMethodDescriptor);
    methodDescriptors.add(listSampleQueriesMethodDescriptor);
    methodDescriptors.add(createSampleQueryMethodDescriptor);
    methodDescriptors.add(updateSampleQueryMethodDescriptor);
    methodDescriptors.add(deleteSampleQueryMethodDescriptor);
    methodDescriptors.add(importSampleQueriesMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<GetSampleQueryRequest, SampleQuery> getSampleQueryCallable() {
    return getSampleQueryCallable;
  }

  @Override
  public UnaryCallable<ListSampleQueriesRequest, ListSampleQueriesResponse>
      listSampleQueriesCallable() {
    return listSampleQueriesCallable;
  }

  @Override
  public UnaryCallable<ListSampleQueriesRequest, ListSampleQueriesPagedResponse>
      listSampleQueriesPagedCallable() {
    return listSampleQueriesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateSampleQueryRequest, SampleQuery> createSampleQueryCallable() {
    return createSampleQueryCallable;
  }

  @Override
  public UnaryCallable<UpdateSampleQueryRequest, SampleQuery> updateSampleQueryCallable() {
    return updateSampleQueryCallable;
  }

  @Override
  public UnaryCallable<DeleteSampleQueryRequest, Empty> deleteSampleQueryCallable() {
    return deleteSampleQueryCallable;
  }

  @Override
  public UnaryCallable<ImportSampleQueriesRequest, Operation> importSampleQueriesCallable() {
    return importSampleQueriesCallable;
  }

  @Override
  public OperationCallable<
          ImportSampleQueriesRequest, ImportSampleQueriesResponse, ImportSampleQueriesMetadata>
      importSampleQueriesOperationCallable() {
    return importSampleQueriesOperationCallable;
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
