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

package com.google.cloud.rapidmigrationassessment.v1.stub;

import static com.google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessmentClient.ListCollectorsPagedResponse;
import static com.google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessmentClient.ListLocationsPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.rapidmigrationassessment.v1.Annotation;
import com.google.cloud.rapidmigrationassessment.v1.Collector;
import com.google.cloud.rapidmigrationassessment.v1.CreateAnnotationRequest;
import com.google.cloud.rapidmigrationassessment.v1.CreateCollectorRequest;
import com.google.cloud.rapidmigrationassessment.v1.DeleteCollectorRequest;
import com.google.cloud.rapidmigrationassessment.v1.GetAnnotationRequest;
import com.google.cloud.rapidmigrationassessment.v1.GetCollectorRequest;
import com.google.cloud.rapidmigrationassessment.v1.ListCollectorsRequest;
import com.google.cloud.rapidmigrationassessment.v1.ListCollectorsResponse;
import com.google.cloud.rapidmigrationassessment.v1.OperationMetadata;
import com.google.cloud.rapidmigrationassessment.v1.PauseCollectorRequest;
import com.google.cloud.rapidmigrationassessment.v1.RegisterCollectorRequest;
import com.google.cloud.rapidmigrationassessment.v1.ResumeCollectorRequest;
import com.google.cloud.rapidmigrationassessment.v1.UpdateCollectorRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the RapidMigrationAssessment service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonRapidMigrationAssessmentStub extends RapidMigrationAssessmentStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Collector.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Annotation.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateCollectorRequest, Operation>
      createCollectorMethodDescriptor =
          ApiMethodDescriptor.<CreateCollectorRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessment/CreateCollector")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCollectorRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/collectors",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCollectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCollectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "collectorId", request.getCollectorId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("collector", request.getCollector(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateCollectorRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateAnnotationRequest, Operation>
      createAnnotationMethodDescriptor =
          ApiMethodDescriptor.<CreateAnnotationRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessment/CreateAnnotation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAnnotationRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/annotations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAnnotationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAnnotationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("annotation", request.getAnnotation(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateAnnotationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetAnnotationRequest, Annotation>
      getAnnotationMethodDescriptor =
          ApiMethodDescriptor.<GetAnnotationRequest, Annotation>newBuilder()
              .setFullMethodName(
                  "google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessment/GetAnnotation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAnnotationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/annotations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAnnotationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAnnotationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Annotation>newBuilder()
                      .setDefaultInstance(Annotation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListCollectorsRequest, ListCollectorsResponse>
      listCollectorsMethodDescriptor =
          ApiMethodDescriptor.<ListCollectorsRequest, ListCollectorsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessment/ListCollectors")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCollectorsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/collectors",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCollectorsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCollectorsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCollectorsResponse>newBuilder()
                      .setDefaultInstance(ListCollectorsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCollectorRequest, Collector>
      getCollectorMethodDescriptor =
          ApiMethodDescriptor.<GetCollectorRequest, Collector>newBuilder()
              .setFullMethodName(
                  "google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessment/GetCollector")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCollectorRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/collectors/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCollectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCollectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Collector>newBuilder()
                      .setDefaultInstance(Collector.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCollectorRequest, Operation>
      updateCollectorMethodDescriptor =
          ApiMethodDescriptor.<UpdateCollectorRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessment/UpdateCollector")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCollectorRequest>newBuilder()
                      .setPath(
                          "/v1/{collector.name=projects/*/locations/*/collectors/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCollectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "collector.name", request.getCollector().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCollectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("collector", request.getCollector(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateCollectorRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteCollectorRequest, Operation>
      deleteCollectorMethodDescriptor =
          ApiMethodDescriptor.<DeleteCollectorRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessment/DeleteCollector")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCollectorRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/collectors/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCollectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCollectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteCollectorRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ResumeCollectorRequest, Operation>
      resumeCollectorMethodDescriptor =
          ApiMethodDescriptor.<ResumeCollectorRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessment/ResumeCollector")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResumeCollectorRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/collectors/*}:resume",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ResumeCollectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ResumeCollectorRequest> serializer =
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
                  (ResumeCollectorRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RegisterCollectorRequest, Operation>
      registerCollectorMethodDescriptor =
          ApiMethodDescriptor.<RegisterCollectorRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessment/RegisterCollector")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RegisterCollectorRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/collectors/*}:register",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RegisterCollectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RegisterCollectorRequest> serializer =
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
                  (RegisterCollectorRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<PauseCollectorRequest, Operation>
      pauseCollectorMethodDescriptor =
          ApiMethodDescriptor.<PauseCollectorRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessment/PauseCollector")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PauseCollectorRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/collectors/*}:pause",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PauseCollectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PauseCollectorRequest> serializer =
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
                  (PauseCollectorRequest request, Operation response) ->
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
                          "/v1/{name=projects/*}/locations",
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
                          "/v1/{name=projects/*/locations/*}",
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

  private final UnaryCallable<CreateCollectorRequest, Operation> createCollectorCallable;
  private final OperationCallable<CreateCollectorRequest, Collector, OperationMetadata>
      createCollectorOperationCallable;
  private final UnaryCallable<CreateAnnotationRequest, Operation> createAnnotationCallable;
  private final OperationCallable<CreateAnnotationRequest, Annotation, OperationMetadata>
      createAnnotationOperationCallable;
  private final UnaryCallable<GetAnnotationRequest, Annotation> getAnnotationCallable;
  private final UnaryCallable<ListCollectorsRequest, ListCollectorsResponse> listCollectorsCallable;
  private final UnaryCallable<ListCollectorsRequest, ListCollectorsPagedResponse>
      listCollectorsPagedCallable;
  private final UnaryCallable<GetCollectorRequest, Collector> getCollectorCallable;
  private final UnaryCallable<UpdateCollectorRequest, Operation> updateCollectorCallable;
  private final OperationCallable<UpdateCollectorRequest, Collector, OperationMetadata>
      updateCollectorOperationCallable;
  private final UnaryCallable<DeleteCollectorRequest, Operation> deleteCollectorCallable;
  private final OperationCallable<DeleteCollectorRequest, Collector, OperationMetadata>
      deleteCollectorOperationCallable;
  private final UnaryCallable<ResumeCollectorRequest, Operation> resumeCollectorCallable;
  private final OperationCallable<ResumeCollectorRequest, Collector, OperationMetadata>
      resumeCollectorOperationCallable;
  private final UnaryCallable<RegisterCollectorRequest, Operation> registerCollectorCallable;
  private final OperationCallable<RegisterCollectorRequest, Collector, OperationMetadata>
      registerCollectorOperationCallable;
  private final UnaryCallable<PauseCollectorRequest, Operation> pauseCollectorCallable;
  private final OperationCallable<PauseCollectorRequest, Collector, OperationMetadata>
      pauseCollectorOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRapidMigrationAssessmentStub create(
      RapidMigrationAssessmentStubSettings settings) throws IOException {
    return new HttpJsonRapidMigrationAssessmentStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRapidMigrationAssessmentStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRapidMigrationAssessmentStub(
        RapidMigrationAssessmentStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonRapidMigrationAssessmentStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRapidMigrationAssessmentStub(
        RapidMigrationAssessmentStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRapidMigrationAssessmentStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRapidMigrationAssessmentStub(
      RapidMigrationAssessmentStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRapidMigrationAssessmentCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRapidMigrationAssessmentStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRapidMigrationAssessmentStub(
      RapidMigrationAssessmentStubSettings settings,
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
                        .setPost("/v1/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<CreateCollectorRequest, Operation> createCollectorTransportSettings =
        HttpJsonCallSettings.<CreateCollectorRequest, Operation>newBuilder()
            .setMethodDescriptor(createCollectorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateAnnotationRequest, Operation> createAnnotationTransportSettings =
        HttpJsonCallSettings.<CreateAnnotationRequest, Operation>newBuilder()
            .setMethodDescriptor(createAnnotationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetAnnotationRequest, Annotation> getAnnotationTransportSettings =
        HttpJsonCallSettings.<GetAnnotationRequest, Annotation>newBuilder()
            .setMethodDescriptor(getAnnotationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListCollectorsRequest, ListCollectorsResponse>
        listCollectorsTransportSettings =
            HttpJsonCallSettings.<ListCollectorsRequest, ListCollectorsResponse>newBuilder()
                .setMethodDescriptor(listCollectorsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetCollectorRequest, Collector> getCollectorTransportSettings =
        HttpJsonCallSettings.<GetCollectorRequest, Collector>newBuilder()
            .setMethodDescriptor(getCollectorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateCollectorRequest, Operation> updateCollectorTransportSettings =
        HttpJsonCallSettings.<UpdateCollectorRequest, Operation>newBuilder()
            .setMethodDescriptor(updateCollectorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("collector.name", String.valueOf(request.getCollector().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteCollectorRequest, Operation> deleteCollectorTransportSettings =
        HttpJsonCallSettings.<DeleteCollectorRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteCollectorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ResumeCollectorRequest, Operation> resumeCollectorTransportSettings =
        HttpJsonCallSettings.<ResumeCollectorRequest, Operation>newBuilder()
            .setMethodDescriptor(resumeCollectorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RegisterCollectorRequest, Operation> registerCollectorTransportSettings =
        HttpJsonCallSettings.<RegisterCollectorRequest, Operation>newBuilder()
            .setMethodDescriptor(registerCollectorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<PauseCollectorRequest, Operation> pauseCollectorTransportSettings =
        HttpJsonCallSettings.<PauseCollectorRequest, Operation>newBuilder()
            .setMethodDescriptor(pauseCollectorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
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

    this.createCollectorCallable =
        callableFactory.createUnaryCallable(
            createCollectorTransportSettings, settings.createCollectorSettings(), clientContext);
    this.createCollectorOperationCallable =
        callableFactory.createOperationCallable(
            createCollectorTransportSettings,
            settings.createCollectorOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createAnnotationCallable =
        callableFactory.createUnaryCallable(
            createAnnotationTransportSettings, settings.createAnnotationSettings(), clientContext);
    this.createAnnotationOperationCallable =
        callableFactory.createOperationCallable(
            createAnnotationTransportSettings,
            settings.createAnnotationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getAnnotationCallable =
        callableFactory.createUnaryCallable(
            getAnnotationTransportSettings, settings.getAnnotationSettings(), clientContext);
    this.listCollectorsCallable =
        callableFactory.createUnaryCallable(
            listCollectorsTransportSettings, settings.listCollectorsSettings(), clientContext);
    this.listCollectorsPagedCallable =
        callableFactory.createPagedCallable(
            listCollectorsTransportSettings, settings.listCollectorsSettings(), clientContext);
    this.getCollectorCallable =
        callableFactory.createUnaryCallable(
            getCollectorTransportSettings, settings.getCollectorSettings(), clientContext);
    this.updateCollectorCallable =
        callableFactory.createUnaryCallable(
            updateCollectorTransportSettings, settings.updateCollectorSettings(), clientContext);
    this.updateCollectorOperationCallable =
        callableFactory.createOperationCallable(
            updateCollectorTransportSettings,
            settings.updateCollectorOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteCollectorCallable =
        callableFactory.createUnaryCallable(
            deleteCollectorTransportSettings, settings.deleteCollectorSettings(), clientContext);
    this.deleteCollectorOperationCallable =
        callableFactory.createOperationCallable(
            deleteCollectorTransportSettings,
            settings.deleteCollectorOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.resumeCollectorCallable =
        callableFactory.createUnaryCallable(
            resumeCollectorTransportSettings, settings.resumeCollectorSettings(), clientContext);
    this.resumeCollectorOperationCallable =
        callableFactory.createOperationCallable(
            resumeCollectorTransportSettings,
            settings.resumeCollectorOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.registerCollectorCallable =
        callableFactory.createUnaryCallable(
            registerCollectorTransportSettings,
            settings.registerCollectorSettings(),
            clientContext);
    this.registerCollectorOperationCallable =
        callableFactory.createOperationCallable(
            registerCollectorTransportSettings,
            settings.registerCollectorOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.pauseCollectorCallable =
        callableFactory.createUnaryCallable(
            pauseCollectorTransportSettings, settings.pauseCollectorSettings(), clientContext);
    this.pauseCollectorOperationCallable =
        callableFactory.createOperationCallable(
            pauseCollectorTransportSettings,
            settings.pauseCollectorOperationSettings(),
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
    methodDescriptors.add(createCollectorMethodDescriptor);
    methodDescriptors.add(createAnnotationMethodDescriptor);
    methodDescriptors.add(getAnnotationMethodDescriptor);
    methodDescriptors.add(listCollectorsMethodDescriptor);
    methodDescriptors.add(getCollectorMethodDescriptor);
    methodDescriptors.add(updateCollectorMethodDescriptor);
    methodDescriptors.add(deleteCollectorMethodDescriptor);
    methodDescriptors.add(resumeCollectorMethodDescriptor);
    methodDescriptors.add(registerCollectorMethodDescriptor);
    methodDescriptors.add(pauseCollectorMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateCollectorRequest, Operation> createCollectorCallable() {
    return createCollectorCallable;
  }

  @Override
  public OperationCallable<CreateCollectorRequest, Collector, OperationMetadata>
      createCollectorOperationCallable() {
    return createCollectorOperationCallable;
  }

  @Override
  public UnaryCallable<CreateAnnotationRequest, Operation> createAnnotationCallable() {
    return createAnnotationCallable;
  }

  @Override
  public OperationCallable<CreateAnnotationRequest, Annotation, OperationMetadata>
      createAnnotationOperationCallable() {
    return createAnnotationOperationCallable;
  }

  @Override
  public UnaryCallable<GetAnnotationRequest, Annotation> getAnnotationCallable() {
    return getAnnotationCallable;
  }

  @Override
  public UnaryCallable<ListCollectorsRequest, ListCollectorsResponse> listCollectorsCallable() {
    return listCollectorsCallable;
  }

  @Override
  public UnaryCallable<ListCollectorsRequest, ListCollectorsPagedResponse>
      listCollectorsPagedCallable() {
    return listCollectorsPagedCallable;
  }

  @Override
  public UnaryCallable<GetCollectorRequest, Collector> getCollectorCallable() {
    return getCollectorCallable;
  }

  @Override
  public UnaryCallable<UpdateCollectorRequest, Operation> updateCollectorCallable() {
    return updateCollectorCallable;
  }

  @Override
  public OperationCallable<UpdateCollectorRequest, Collector, OperationMetadata>
      updateCollectorOperationCallable() {
    return updateCollectorOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteCollectorRequest, Operation> deleteCollectorCallable() {
    return deleteCollectorCallable;
  }

  @Override
  public OperationCallable<DeleteCollectorRequest, Collector, OperationMetadata>
      deleteCollectorOperationCallable() {
    return deleteCollectorOperationCallable;
  }

  @Override
  public UnaryCallable<ResumeCollectorRequest, Operation> resumeCollectorCallable() {
    return resumeCollectorCallable;
  }

  @Override
  public OperationCallable<ResumeCollectorRequest, Collector, OperationMetadata>
      resumeCollectorOperationCallable() {
    return resumeCollectorOperationCallable;
  }

  @Override
  public UnaryCallable<RegisterCollectorRequest, Operation> registerCollectorCallable() {
    return registerCollectorCallable;
  }

  @Override
  public OperationCallable<RegisterCollectorRequest, Collector, OperationMetadata>
      registerCollectorOperationCallable() {
    return registerCollectorOperationCallable;
  }

  @Override
  public UnaryCallable<PauseCollectorRequest, Operation> pauseCollectorCallable() {
    return pauseCollectorCallable;
  }

  @Override
  public OperationCallable<PauseCollectorRequest, Collector, OperationMetadata>
      pauseCollectorOperationCallable() {
    return pauseCollectorOperationCallable;
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
