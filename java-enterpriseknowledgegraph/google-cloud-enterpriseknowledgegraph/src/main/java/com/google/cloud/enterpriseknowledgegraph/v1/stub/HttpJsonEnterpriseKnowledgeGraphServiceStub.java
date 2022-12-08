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

package com.google.cloud.enterpriseknowledgegraph.v1.stub;

import static com.google.cloud.enterpriseknowledgegraph.v1.EnterpriseKnowledgeGraphServiceClient.ListEntityReconciliationJobsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.enterpriseknowledgegraph.v1.CancelEntityReconciliationJobRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.CreateEntityReconciliationJobRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.DeleteEntityReconciliationJobRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob;
import com.google.cloud.enterpriseknowledgegraph.v1.GetEntityReconciliationJobRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsResponse;
import com.google.cloud.enterpriseknowledgegraph.v1.LookupPublicKgRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.LookupPublicKgResponse;
import com.google.cloud.enterpriseknowledgegraph.v1.LookupRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.LookupResponse;
import com.google.cloud.enterpriseknowledgegraph.v1.SearchPublicKgRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.SearchPublicKgResponse;
import com.google.cloud.enterpriseknowledgegraph.v1.SearchRequest;
import com.google.cloud.enterpriseknowledgegraph.v1.SearchResponse;
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
 * REST stub implementation for the EnterpriseKnowledgeGraphService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonEnterpriseKnowledgeGraphServiceStub
    extends EnterpriseKnowledgeGraphServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          CreateEntityReconciliationJobRequest, EntityReconciliationJob>
      createEntityReconciliationJobMethodDescriptor =
          ApiMethodDescriptor
              .<CreateEntityReconciliationJobRequest, EntityReconciliationJob>newBuilder()
              .setFullMethodName(
                  "google.cloud.enterpriseknowledgegraph.v1.EnterpriseKnowledgeGraphService/CreateEntityReconciliationJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEntityReconciliationJobRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/entityReconciliationJobs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEntityReconciliationJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEntityReconciliationJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "entityReconciliationJob",
                                      request.getEntityReconciliationJob(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EntityReconciliationJob>newBuilder()
                      .setDefaultInstance(EntityReconciliationJob.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetEntityReconciliationJobRequest, EntityReconciliationJob>
      getEntityReconciliationJobMethodDescriptor =
          ApiMethodDescriptor
              .<GetEntityReconciliationJobRequest, EntityReconciliationJob>newBuilder()
              .setFullMethodName(
                  "google.cloud.enterpriseknowledgegraph.v1.EnterpriseKnowledgeGraphService/GetEntityReconciliationJob")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEntityReconciliationJobRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/entityReconciliationJobs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEntityReconciliationJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEntityReconciliationJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EntityReconciliationJob>newBuilder()
                      .setDefaultInstance(EntityReconciliationJob.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListEntityReconciliationJobsRequest, ListEntityReconciliationJobsResponse>
      listEntityReconciliationJobsMethodDescriptor =
          ApiMethodDescriptor
              .<ListEntityReconciliationJobsRequest, ListEntityReconciliationJobsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.enterpriseknowledgegraph.v1.EnterpriseKnowledgeGraphService/ListEntityReconciliationJobs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEntityReconciliationJobsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/entityReconciliationJobs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEntityReconciliationJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEntityReconciliationJobsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListEntityReconciliationJobsResponse>newBuilder()
                      .setDefaultInstance(ListEntityReconciliationJobsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CancelEntityReconciliationJobRequest, Empty>
      cancelEntityReconciliationJobMethodDescriptor =
          ApiMethodDescriptor.<CancelEntityReconciliationJobRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.enterpriseknowledgegraph.v1.EnterpriseKnowledgeGraphService/CancelEntityReconciliationJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CancelEntityReconciliationJobRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/entityReconciliationJobs/*}:cancel",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CancelEntityReconciliationJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CancelEntityReconciliationJobRequest> serializer =
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
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteEntityReconciliationJobRequest, Empty>
      deleteEntityReconciliationJobMethodDescriptor =
          ApiMethodDescriptor.<DeleteEntityReconciliationJobRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.enterpriseknowledgegraph.v1.EnterpriseKnowledgeGraphService/DeleteEntityReconciliationJob")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEntityReconciliationJobRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/entityReconciliationJobs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEntityReconciliationJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEntityReconciliationJobRequest> serializer =
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

  private static final ApiMethodDescriptor<LookupRequest, LookupResponse> lookupMethodDescriptor =
      ApiMethodDescriptor.<LookupRequest, LookupResponse>newBuilder()
          .setFullMethodName(
              "google.cloud.enterpriseknowledgegraph.v1.EnterpriseKnowledgeGraphService/Lookup")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<LookupRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=projects/*/locations/*}/cloudKnowledgeGraphEntities:Lookup",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<LookupRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<LookupRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "ids", request.getIdsList());
                        serializer.putQueryParam(fields, "languages", request.getLanguagesList());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<LookupResponse>newBuilder()
                  .setDefaultInstance(LookupResponse.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<SearchRequest, SearchResponse> searchMethodDescriptor =
      ApiMethodDescriptor.<SearchRequest, SearchResponse>newBuilder()
          .setFullMethodName(
              "google.cloud.enterpriseknowledgegraph.v1.EnterpriseKnowledgeGraphService/Search")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<SearchRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=projects/*/locations/*}/cloudKnowledgeGraphEntities:Search",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<SearchRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<SearchRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "languages", request.getLanguagesList());
                        serializer.putQueryParam(fields, "limit", request.getLimit());
                        serializer.putQueryParam(fields, "query", request.getQuery());
                        serializer.putQueryParam(fields, "types", request.getTypesList());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<SearchResponse>newBuilder()
                  .setDefaultInstance(SearchResponse.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<LookupPublicKgRequest, LookupPublicKgResponse>
      lookupPublicKgMethodDescriptor =
          ApiMethodDescriptor.<LookupPublicKgRequest, LookupPublicKgResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.enterpriseknowledgegraph.v1.EnterpriseKnowledgeGraphService/LookupPublicKg")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<LookupPublicKgRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/publicKnowledgeGraphEntities:Lookup",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<LookupPublicKgRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<LookupPublicKgRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "ids", request.getIdsList());
                            serializer.putQueryParam(
                                fields, "languages", request.getLanguagesList());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LookupPublicKgResponse>newBuilder()
                      .setDefaultInstance(LookupPublicKgResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SearchPublicKgRequest, SearchPublicKgResponse>
      searchPublicKgMethodDescriptor =
          ApiMethodDescriptor.<SearchPublicKgRequest, SearchPublicKgResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.enterpriseknowledgegraph.v1.EnterpriseKnowledgeGraphService/SearchPublicKg")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchPublicKgRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/publicKnowledgeGraphEntities:Search",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchPublicKgRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchPublicKgRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "languages", request.getLanguagesList());
                            serializer.putQueryParam(fields, "limit", request.getLimit());
                            serializer.putQueryParam(fields, "query", request.getQuery());
                            serializer.putQueryParam(fields, "types", request.getTypesList());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchPublicKgResponse>newBuilder()
                      .setDefaultInstance(SearchPublicKgResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateEntityReconciliationJobRequest, EntityReconciliationJob>
      createEntityReconciliationJobCallable;
  private final UnaryCallable<GetEntityReconciliationJobRequest, EntityReconciliationJob>
      getEntityReconciliationJobCallable;
  private final UnaryCallable<
          ListEntityReconciliationJobsRequest, ListEntityReconciliationJobsResponse>
      listEntityReconciliationJobsCallable;
  private final UnaryCallable<
          ListEntityReconciliationJobsRequest, ListEntityReconciliationJobsPagedResponse>
      listEntityReconciliationJobsPagedCallable;
  private final UnaryCallable<CancelEntityReconciliationJobRequest, Empty>
      cancelEntityReconciliationJobCallable;
  private final UnaryCallable<DeleteEntityReconciliationJobRequest, Empty>
      deleteEntityReconciliationJobCallable;
  private final UnaryCallable<LookupRequest, LookupResponse> lookupCallable;
  private final UnaryCallable<SearchRequest, SearchResponse> searchCallable;
  private final UnaryCallable<LookupPublicKgRequest, LookupPublicKgResponse> lookupPublicKgCallable;
  private final UnaryCallable<SearchPublicKgRequest, SearchPublicKgResponse> searchPublicKgCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonEnterpriseKnowledgeGraphServiceStub create(
      EnterpriseKnowledgeGraphServiceStubSettings settings) throws IOException {
    return new HttpJsonEnterpriseKnowledgeGraphServiceStub(
        settings, ClientContext.create(settings));
  }

  public static final HttpJsonEnterpriseKnowledgeGraphServiceStub create(
      ClientContext clientContext) throws IOException {
    return new HttpJsonEnterpriseKnowledgeGraphServiceStub(
        EnterpriseKnowledgeGraphServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonEnterpriseKnowledgeGraphServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonEnterpriseKnowledgeGraphServiceStub(
        EnterpriseKnowledgeGraphServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonEnterpriseKnowledgeGraphServiceStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonEnterpriseKnowledgeGraphServiceStub(
      EnterpriseKnowledgeGraphServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonEnterpriseKnowledgeGraphServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonEnterpriseKnowledgeGraphServiceStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonEnterpriseKnowledgeGraphServiceStub(
      EnterpriseKnowledgeGraphServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateEntityReconciliationJobRequest, EntityReconciliationJob>
        createEntityReconciliationJobTransportSettings =
            HttpJsonCallSettings
                .<CreateEntityReconciliationJobRequest, EntityReconciliationJob>newBuilder()
                .setMethodDescriptor(createEntityReconciliationJobMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetEntityReconciliationJobRequest, EntityReconciliationJob>
        getEntityReconciliationJobTransportSettings =
            HttpJsonCallSettings
                .<GetEntityReconciliationJobRequest, EntityReconciliationJob>newBuilder()
                .setMethodDescriptor(getEntityReconciliationJobMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListEntityReconciliationJobsRequest, ListEntityReconciliationJobsResponse>
        listEntityReconciliationJobsTransportSettings =
            HttpJsonCallSettings
                .<ListEntityReconciliationJobsRequest, ListEntityReconciliationJobsResponse>
                    newBuilder()
                .setMethodDescriptor(listEntityReconciliationJobsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CancelEntityReconciliationJobRequest, Empty>
        cancelEntityReconciliationJobTransportSettings =
            HttpJsonCallSettings.<CancelEntityReconciliationJobRequest, Empty>newBuilder()
                .setMethodDescriptor(cancelEntityReconciliationJobMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteEntityReconciliationJobRequest, Empty>
        deleteEntityReconciliationJobTransportSettings =
            HttpJsonCallSettings.<DeleteEntityReconciliationJobRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteEntityReconciliationJobMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<LookupRequest, LookupResponse> lookupTransportSettings =
        HttpJsonCallSettings.<LookupRequest, LookupResponse>newBuilder()
            .setMethodDescriptor(lookupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SearchRequest, SearchResponse> searchTransportSettings =
        HttpJsonCallSettings.<SearchRequest, SearchResponse>newBuilder()
            .setMethodDescriptor(searchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<LookupPublicKgRequest, LookupPublicKgResponse>
        lookupPublicKgTransportSettings =
            HttpJsonCallSettings.<LookupPublicKgRequest, LookupPublicKgResponse>newBuilder()
                .setMethodDescriptor(lookupPublicKgMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SearchPublicKgRequest, SearchPublicKgResponse>
        searchPublicKgTransportSettings =
            HttpJsonCallSettings.<SearchPublicKgRequest, SearchPublicKgResponse>newBuilder()
                .setMethodDescriptor(searchPublicKgMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.createEntityReconciliationJobCallable =
        callableFactory.createUnaryCallable(
            createEntityReconciliationJobTransportSettings,
            settings.createEntityReconciliationJobSettings(),
            clientContext);
    this.getEntityReconciliationJobCallable =
        callableFactory.createUnaryCallable(
            getEntityReconciliationJobTransportSettings,
            settings.getEntityReconciliationJobSettings(),
            clientContext);
    this.listEntityReconciliationJobsCallable =
        callableFactory.createUnaryCallable(
            listEntityReconciliationJobsTransportSettings,
            settings.listEntityReconciliationJobsSettings(),
            clientContext);
    this.listEntityReconciliationJobsPagedCallable =
        callableFactory.createPagedCallable(
            listEntityReconciliationJobsTransportSettings,
            settings.listEntityReconciliationJobsSettings(),
            clientContext);
    this.cancelEntityReconciliationJobCallable =
        callableFactory.createUnaryCallable(
            cancelEntityReconciliationJobTransportSettings,
            settings.cancelEntityReconciliationJobSettings(),
            clientContext);
    this.deleteEntityReconciliationJobCallable =
        callableFactory.createUnaryCallable(
            deleteEntityReconciliationJobTransportSettings,
            settings.deleteEntityReconciliationJobSettings(),
            clientContext);
    this.lookupCallable =
        callableFactory.createUnaryCallable(
            lookupTransportSettings, settings.lookupSettings(), clientContext);
    this.searchCallable =
        callableFactory.createUnaryCallable(
            searchTransportSettings, settings.searchSettings(), clientContext);
    this.lookupPublicKgCallable =
        callableFactory.createUnaryCallable(
            lookupPublicKgTransportSettings, settings.lookupPublicKgSettings(), clientContext);
    this.searchPublicKgCallable =
        callableFactory.createUnaryCallable(
            searchPublicKgTransportSettings, settings.searchPublicKgSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createEntityReconciliationJobMethodDescriptor);
    methodDescriptors.add(getEntityReconciliationJobMethodDescriptor);
    methodDescriptors.add(listEntityReconciliationJobsMethodDescriptor);
    methodDescriptors.add(cancelEntityReconciliationJobMethodDescriptor);
    methodDescriptors.add(deleteEntityReconciliationJobMethodDescriptor);
    methodDescriptors.add(lookupMethodDescriptor);
    methodDescriptors.add(searchMethodDescriptor);
    methodDescriptors.add(lookupPublicKgMethodDescriptor);
    methodDescriptors.add(searchPublicKgMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateEntityReconciliationJobRequest, EntityReconciliationJob>
      createEntityReconciliationJobCallable() {
    return createEntityReconciliationJobCallable;
  }

  @Override
  public UnaryCallable<GetEntityReconciliationJobRequest, EntityReconciliationJob>
      getEntityReconciliationJobCallable() {
    return getEntityReconciliationJobCallable;
  }

  @Override
  public UnaryCallable<ListEntityReconciliationJobsRequest, ListEntityReconciliationJobsResponse>
      listEntityReconciliationJobsCallable() {
    return listEntityReconciliationJobsCallable;
  }

  @Override
  public UnaryCallable<
          ListEntityReconciliationJobsRequest, ListEntityReconciliationJobsPagedResponse>
      listEntityReconciliationJobsPagedCallable() {
    return listEntityReconciliationJobsPagedCallable;
  }

  @Override
  public UnaryCallable<CancelEntityReconciliationJobRequest, Empty>
      cancelEntityReconciliationJobCallable() {
    return cancelEntityReconciliationJobCallable;
  }

  @Override
  public UnaryCallable<DeleteEntityReconciliationJobRequest, Empty>
      deleteEntityReconciliationJobCallable() {
    return deleteEntityReconciliationJobCallable;
  }

  @Override
  public UnaryCallable<LookupRequest, LookupResponse> lookupCallable() {
    return lookupCallable;
  }

  @Override
  public UnaryCallable<SearchRequest, SearchResponse> searchCallable() {
    return searchCallable;
  }

  @Override
  public UnaryCallable<LookupPublicKgRequest, LookupPublicKgResponse> lookupPublicKgCallable() {
    return lookupPublicKgCallable;
  }

  @Override
  public UnaryCallable<SearchPublicKgRequest, SearchPublicKgResponse> searchPublicKgCallable() {
    return searchPublicKgCallable;
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
