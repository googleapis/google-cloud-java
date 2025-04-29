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

package com.google.cloud.datastore.v1.stub;

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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.datastore.v1.AllocateIdsRequest;
import com.google.datastore.v1.AllocateIdsResponse;
import com.google.datastore.v1.BeginTransactionRequest;
import com.google.datastore.v1.BeginTransactionResponse;
import com.google.datastore.v1.CommitRequest;
import com.google.datastore.v1.CommitResponse;
import com.google.datastore.v1.LookupRequest;
import com.google.datastore.v1.LookupResponse;
import com.google.datastore.v1.ReserveIdsRequest;
import com.google.datastore.v1.ReserveIdsResponse;
import com.google.datastore.v1.RollbackRequest;
import com.google.datastore.v1.RollbackResponse;
import com.google.datastore.v1.RunAggregationQueryRequest;
import com.google.datastore.v1.RunAggregationQueryResponse;
import com.google.datastore.v1.RunQueryRequest;
import com.google.datastore.v1.RunQueryResponse;
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
 * REST stub implementation for the Datastore service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonDatastoreStub extends DatastoreStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<LookupRequest, LookupResponse> lookupMethodDescriptor =
      ApiMethodDescriptor.<LookupRequest, LookupResponse>newBuilder()
          .setFullMethodName("google.datastore.v1.Datastore/Lookup")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<LookupRequest>newBuilder()
                  .setPath(
                      "/v1/projects/{projectId}:lookup",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<LookupRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "projectId", request.getProjectId());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<LookupRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearProjectId().build(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<LookupResponse>newBuilder()
                  .setDefaultInstance(LookupResponse.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<RunQueryRequest, RunQueryResponse>
      runQueryMethodDescriptor =
          ApiMethodDescriptor.<RunQueryRequest, RunQueryResponse>newBuilder()
              .setFullMethodName("google.datastore.v1.Datastore/RunQuery")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RunQueryRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}:runQuery",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RunQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RunQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearProjectId().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RunQueryResponse>newBuilder()
                      .setDefaultInstance(RunQueryResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RunAggregationQueryRequest, RunAggregationQueryResponse>
      runAggregationQueryMethodDescriptor =
          ApiMethodDescriptor.<RunAggregationQueryRequest, RunAggregationQueryResponse>newBuilder()
              .setFullMethodName("google.datastore.v1.Datastore/RunAggregationQuery")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RunAggregationQueryRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}:runAggregationQuery",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RunAggregationQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RunAggregationQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearProjectId().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RunAggregationQueryResponse>newBuilder()
                      .setDefaultInstance(RunAggregationQueryResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionMethodDescriptor =
          ApiMethodDescriptor.<BeginTransactionRequest, BeginTransactionResponse>newBuilder()
              .setFullMethodName("google.datastore.v1.Datastore/BeginTransaction")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BeginTransactionRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}:beginTransaction",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BeginTransactionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BeginTransactionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearProjectId().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BeginTransactionResponse>newBuilder()
                      .setDefaultInstance(BeginTransactionResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CommitRequest, CommitResponse> commitMethodDescriptor =
      ApiMethodDescriptor.<CommitRequest, CommitResponse>newBuilder()
          .setFullMethodName("google.datastore.v1.Datastore/Commit")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CommitRequest>newBuilder()
                  .setPath(
                      "/v1/projects/{projectId}:commit",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CommitRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "projectId", request.getProjectId());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CommitRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearProjectId().build(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<CommitResponse>newBuilder()
                  .setDefaultInstance(CommitResponse.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<RollbackRequest, RollbackResponse>
      rollbackMethodDescriptor =
          ApiMethodDescriptor.<RollbackRequest, RollbackResponse>newBuilder()
              .setFullMethodName("google.datastore.v1.Datastore/Rollback")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RollbackRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}:rollback",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RollbackRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RollbackRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearProjectId().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RollbackResponse>newBuilder()
                      .setDefaultInstance(RollbackResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AllocateIdsRequest, AllocateIdsResponse>
      allocateIdsMethodDescriptor =
          ApiMethodDescriptor.<AllocateIdsRequest, AllocateIdsResponse>newBuilder()
              .setFullMethodName("google.datastore.v1.Datastore/AllocateIds")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AllocateIdsRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}:allocateIds",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AllocateIdsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AllocateIdsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearProjectId().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AllocateIdsResponse>newBuilder()
                      .setDefaultInstance(AllocateIdsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ReserveIdsRequest, ReserveIdsResponse>
      reserveIdsMethodDescriptor =
          ApiMethodDescriptor.<ReserveIdsRequest, ReserveIdsResponse>newBuilder()
              .setFullMethodName("google.datastore.v1.Datastore/ReserveIds")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ReserveIdsRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}:reserveIds",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ReserveIdsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ReserveIdsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearProjectId().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReserveIdsResponse>newBuilder()
                      .setDefaultInstance(ReserveIdsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<LookupRequest, LookupResponse> lookupCallable;
  private final UnaryCallable<RunQueryRequest, RunQueryResponse> runQueryCallable;
  private final UnaryCallable<RunAggregationQueryRequest, RunAggregationQueryResponse>
      runAggregationQueryCallable;
  private final UnaryCallable<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionCallable;
  private final UnaryCallable<CommitRequest, CommitResponse> commitCallable;
  private final UnaryCallable<RollbackRequest, RollbackResponse> rollbackCallable;
  private final UnaryCallable<AllocateIdsRequest, AllocateIdsResponse> allocateIdsCallable;
  private final UnaryCallable<ReserveIdsRequest, ReserveIdsResponse> reserveIdsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  private static final PathTemplate LOOKUP_0_PATH_TEMPLATE = PathTemplate.create("{project_id=**}");
  private static final PathTemplate LOOKUP_1_PATH_TEMPLATE =
      PathTemplate.create("{database_id=**}");
  private static final PathTemplate RUN_QUERY_0_PATH_TEMPLATE =
      PathTemplate.create("{project_id=**}");
  private static final PathTemplate RUN_QUERY_1_PATH_TEMPLATE =
      PathTemplate.create("{database_id=**}");
  private static final PathTemplate RUN_AGGREGATION_QUERY_0_PATH_TEMPLATE =
      PathTemplate.create("{project_id=**}");
  private static final PathTemplate RUN_AGGREGATION_QUERY_1_PATH_TEMPLATE =
      PathTemplate.create("{database_id=**}");
  private static final PathTemplate BEGIN_TRANSACTION_0_PATH_TEMPLATE =
      PathTemplate.create("{project_id=**}");
  private static final PathTemplate BEGIN_TRANSACTION_1_PATH_TEMPLATE =
      PathTemplate.create("{database_id=**}");
  private static final PathTemplate COMMIT_0_PATH_TEMPLATE = PathTemplate.create("{project_id=**}");
  private static final PathTemplate COMMIT_1_PATH_TEMPLATE =
      PathTemplate.create("{database_id=**}");
  private static final PathTemplate ROLLBACK_0_PATH_TEMPLATE =
      PathTemplate.create("{project_id=**}");
  private static final PathTemplate ROLLBACK_1_PATH_TEMPLATE =
      PathTemplate.create("{database_id=**}");
  private static final PathTemplate ALLOCATE_IDS_0_PATH_TEMPLATE =
      PathTemplate.create("{project_id=**}");
  private static final PathTemplate ALLOCATE_IDS_1_PATH_TEMPLATE =
      PathTemplate.create("{database_id=**}");
  private static final PathTemplate RESERVE_IDS_0_PATH_TEMPLATE =
      PathTemplate.create("{project_id=**}");
  private static final PathTemplate RESERVE_IDS_1_PATH_TEMPLATE =
      PathTemplate.create("{database_id=**}");

  public static final HttpJsonDatastoreStub create(DatastoreStubSettings settings)
      throws IOException {
    return new HttpJsonDatastoreStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDatastoreStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonDatastoreStub(
        DatastoreStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDatastoreStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDatastoreStub(
        DatastoreStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDatastoreStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDatastoreStub(DatastoreStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonDatastoreCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDatastoreStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDatastoreStub(
      DatastoreStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<LookupRequest, LookupResponse> lookupTransportSettings =
        HttpJsonCallSettings.<LookupRequest, LookupResponse>newBuilder()
            .setMethodDescriptor(lookupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getProjectId(), "project_id", LOOKUP_0_PATH_TEMPLATE);
                  builder.add(request.getDatabaseId(), "database_id", LOOKUP_1_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RunQueryRequest, RunQueryResponse> runQueryTransportSettings =
        HttpJsonCallSettings.<RunQueryRequest, RunQueryResponse>newBuilder()
            .setMethodDescriptor(runQueryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getProjectId(), "project_id", RUN_QUERY_0_PATH_TEMPLATE);
                  builder.add(request.getDatabaseId(), "database_id", RUN_QUERY_1_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RunAggregationQueryRequest, RunAggregationQueryResponse>
        runAggregationQueryTransportSettings =
            HttpJsonCallSettings
                .<RunAggregationQueryRequest, RunAggregationQueryResponse>newBuilder()
                .setMethodDescriptor(runAggregationQueryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getProjectId(),
                          "project_id",
                          RUN_AGGREGATION_QUERY_0_PATH_TEMPLATE);
                      builder.add(
                          request.getDatabaseId(),
                          "database_id",
                          RUN_AGGREGATION_QUERY_1_PATH_TEMPLATE);
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BeginTransactionRequest, BeginTransactionResponse>
        beginTransactionTransportSettings =
            HttpJsonCallSettings.<BeginTransactionRequest, BeginTransactionResponse>newBuilder()
                .setMethodDescriptor(beginTransactionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getProjectId(), "project_id", BEGIN_TRANSACTION_0_PATH_TEMPLATE);
                      builder.add(
                          request.getDatabaseId(),
                          "database_id",
                          BEGIN_TRANSACTION_1_PATH_TEMPLATE);
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CommitRequest, CommitResponse> commitTransportSettings =
        HttpJsonCallSettings.<CommitRequest, CommitResponse>newBuilder()
            .setMethodDescriptor(commitMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getProjectId(), "project_id", COMMIT_0_PATH_TEMPLATE);
                  builder.add(request.getDatabaseId(), "database_id", COMMIT_1_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RollbackRequest, RollbackResponse> rollbackTransportSettings =
        HttpJsonCallSettings.<RollbackRequest, RollbackResponse>newBuilder()
            .setMethodDescriptor(rollbackMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getProjectId(), "project_id", ROLLBACK_0_PATH_TEMPLATE);
                  builder.add(request.getDatabaseId(), "database_id", ROLLBACK_1_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<AllocateIdsRequest, AllocateIdsResponse> allocateIdsTransportSettings =
        HttpJsonCallSettings.<AllocateIdsRequest, AllocateIdsResponse>newBuilder()
            .setMethodDescriptor(allocateIdsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getProjectId(), "project_id", ALLOCATE_IDS_0_PATH_TEMPLATE);
                  builder.add(request.getDatabaseId(), "database_id", ALLOCATE_IDS_1_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ReserveIdsRequest, ReserveIdsResponse> reserveIdsTransportSettings =
        HttpJsonCallSettings.<ReserveIdsRequest, ReserveIdsResponse>newBuilder()
            .setMethodDescriptor(reserveIdsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getProjectId(), "project_id", RESERVE_IDS_0_PATH_TEMPLATE);
                  builder.add(request.getDatabaseId(), "database_id", RESERVE_IDS_1_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();

    this.lookupCallable =
        callableFactory.createUnaryCallable(
            lookupTransportSettings, settings.lookupSettings(), clientContext);
    this.runQueryCallable =
        callableFactory.createUnaryCallable(
            runQueryTransportSettings, settings.runQuerySettings(), clientContext);
    this.runAggregationQueryCallable =
        callableFactory.createUnaryCallable(
            runAggregationQueryTransportSettings,
            settings.runAggregationQuerySettings(),
            clientContext);
    this.beginTransactionCallable =
        callableFactory.createUnaryCallable(
            beginTransactionTransportSettings, settings.beginTransactionSettings(), clientContext);
    this.commitCallable =
        callableFactory.createUnaryCallable(
            commitTransportSettings, settings.commitSettings(), clientContext);
    this.rollbackCallable =
        callableFactory.createUnaryCallable(
            rollbackTransportSettings, settings.rollbackSettings(), clientContext);
    this.allocateIdsCallable =
        callableFactory.createUnaryCallable(
            allocateIdsTransportSettings, settings.allocateIdsSettings(), clientContext);
    this.reserveIdsCallable =
        callableFactory.createUnaryCallable(
            reserveIdsTransportSettings, settings.reserveIdsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(lookupMethodDescriptor);
    methodDescriptors.add(runQueryMethodDescriptor);
    methodDescriptors.add(runAggregationQueryMethodDescriptor);
    methodDescriptors.add(beginTransactionMethodDescriptor);
    methodDescriptors.add(commitMethodDescriptor);
    methodDescriptors.add(rollbackMethodDescriptor);
    methodDescriptors.add(allocateIdsMethodDescriptor);
    methodDescriptors.add(reserveIdsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<LookupRequest, LookupResponse> lookupCallable() {
    return lookupCallable;
  }

  @Override
  public UnaryCallable<RunQueryRequest, RunQueryResponse> runQueryCallable() {
    return runQueryCallable;
  }

  @Override
  public UnaryCallable<RunAggregationQueryRequest, RunAggregationQueryResponse>
      runAggregationQueryCallable() {
    return runAggregationQueryCallable;
  }

  @Override
  public UnaryCallable<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionCallable() {
    return beginTransactionCallable;
  }

  @Override
  public UnaryCallable<CommitRequest, CommitResponse> commitCallable() {
    return commitCallable;
  }

  @Override
  public UnaryCallable<RollbackRequest, RollbackResponse> rollbackCallable() {
    return rollbackCallable;
  }

  @Override
  public UnaryCallable<AllocateIdsRequest, AllocateIdsResponse> allocateIdsCallable() {
    return allocateIdsCallable;
  }

  @Override
  public UnaryCallable<ReserveIdsRequest, ReserveIdsResponse> reserveIdsCallable() {
    return reserveIdsCallable;
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
