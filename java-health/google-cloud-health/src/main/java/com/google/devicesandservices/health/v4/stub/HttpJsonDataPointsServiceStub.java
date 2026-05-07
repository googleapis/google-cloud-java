/*
 * Copyright 2026 Google LLC
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

package com.google.devicesandservices.health.v4.stub;

import static com.google.devicesandservices.health.v4.DataPointsServiceClient.ListDataPointsPagedResponse;
import static com.google.devicesandservices.health.v4.DataPointsServiceClient.ReconcileDataPointsPagedResponse;
import static com.google.devicesandservices.health.v4.DataPointsServiceClient.RollUpDataPointsPagedResponse;

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
import com.google.devicesandservices.health.v4.BatchDeleteDataPointsOperationMetadata;
import com.google.devicesandservices.health.v4.BatchDeleteDataPointsRequest;
import com.google.devicesandservices.health.v4.BatchDeleteDataPointsResponse;
import com.google.devicesandservices.health.v4.CreateDataPointOperationMetadata;
import com.google.devicesandservices.health.v4.CreateDataPointRequest;
import com.google.devicesandservices.health.v4.DailyRollUpDataPointsRequest;
import com.google.devicesandservices.health.v4.DailyRollUpDataPointsResponse;
import com.google.devicesandservices.health.v4.DataPoint;
import com.google.devicesandservices.health.v4.ExportExerciseTcxRequest;
import com.google.devicesandservices.health.v4.ExportExerciseTcxResponse;
import com.google.devicesandservices.health.v4.GetDataPointRequest;
import com.google.devicesandservices.health.v4.ListDataPointsRequest;
import com.google.devicesandservices.health.v4.ListDataPointsResponse;
import com.google.devicesandservices.health.v4.ReconcileDataPointsRequest;
import com.google.devicesandservices.health.v4.ReconcileDataPointsResponse;
import com.google.devicesandservices.health.v4.RollUpDataPointsRequest;
import com.google.devicesandservices.health.v4.RollUpDataPointsResponse;
import com.google.devicesandservices.health.v4.UpdateDataPointOperationMetadata;
import com.google.devicesandservices.health.v4.UpdateDataPointRequest;
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
 * REST stub implementation for the DataPointsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonDataPointsServiceStub extends DataPointsServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(UpdateDataPointOperationMetadata.getDescriptor())
          .add(BatchDeleteDataPointsOperationMetadata.getDescriptor())
          .add(CreateDataPointOperationMetadata.getDescriptor())
          .add(BatchDeleteDataPointsResponse.getDescriptor())
          .add(DataPoint.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<GetDataPointRequest, DataPoint>
      getDataPointMethodDescriptor =
          ApiMethodDescriptor.<GetDataPointRequest, DataPoint>newBuilder()
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataPointsService/GetDataPoint")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataPointRequest>newBuilder()
                      .setPath(
                          "/v4/{name=users/*/dataTypes/*/dataPoints/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataPointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataPointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataPoint>newBuilder()
                      .setDefaultInstance(DataPoint.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDataPointsRequest, ListDataPointsResponse>
      listDataPointsMethodDescriptor =
          ApiMethodDescriptor.<ListDataPointsRequest, ListDataPointsResponse>newBuilder()
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataPointsService/ListDataPoints")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDataPointsRequest>newBuilder()
                      .setPath(
                          "/v4/{parent=users/*/dataTypes/*}/dataPoints",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataPointsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataPointsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListDataPointsResponse>newBuilder()
                      .setDefaultInstance(ListDataPointsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDataPointRequest, Operation>
      createDataPointMethodDescriptor =
          ApiMethodDescriptor.<CreateDataPointRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataPointsService/CreateDataPoint")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDataPointRequest>newBuilder()
                      .setPath(
                          "/v4/{parent=users/*/dataTypes/*}/dataPoints",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataPointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataPointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataPoint", request.getDataPoint(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateDataPointRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateDataPointRequest, Operation>
      updateDataPointMethodDescriptor =
          ApiMethodDescriptor.<UpdateDataPointRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataPointsService/UpdateDataPoint")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDataPointRequest>newBuilder()
                      .setPath(
                          "/v4/{dataPoint.name=users/*/dataTypes/*/dataPoints/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataPointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "dataPoint.name", request.getDataPoint().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataPointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataPoint", request.getDataPoint(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateDataPointRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<BatchDeleteDataPointsRequest, Operation>
      batchDeleteDataPointsMethodDescriptor =
          ApiMethodDescriptor.<BatchDeleteDataPointsRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataPointsService/BatchDeleteDataPoints")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDeleteDataPointsRequest>newBuilder()
                      .setPath(
                          "/v4/{parent=users/*/dataTypes/*}/dataPoints:batchDelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteDataPointsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteDataPointsRequest> serializer =
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
                  (BatchDeleteDataPointsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ReconcileDataPointsRequest, ReconcileDataPointsResponse>
      reconcileDataPointsMethodDescriptor =
          ApiMethodDescriptor.<ReconcileDataPointsRequest, ReconcileDataPointsResponse>newBuilder()
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataPointsService/ReconcileDataPoints")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ReconcileDataPointsRequest>newBuilder()
                      .setPath(
                          "/v4/{parent=users/*/dataTypes/*}/dataPoints:reconcile",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ReconcileDataPointsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ReconcileDataPointsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "dataSourceFamily", request.getDataSourceFamily());
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReconcileDataPointsResponse>newBuilder()
                      .setDefaultInstance(ReconcileDataPointsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RollUpDataPointsRequest, RollUpDataPointsResponse>
      rollUpDataPointsMethodDescriptor =
          ApiMethodDescriptor.<RollUpDataPointsRequest, RollUpDataPointsResponse>newBuilder()
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataPointsService/RollUpDataPoints")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RollUpDataPointsRequest>newBuilder()
                      .setPath(
                          "/v4/{parent=users/*/dataTypes/*}/dataPoints:rollUp",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RollUpDataPointsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RollUpDataPointsRequest> serializer =
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
                  ProtoMessageResponseParser.<RollUpDataPointsResponse>newBuilder()
                      .setDefaultInstance(RollUpDataPointsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          DailyRollUpDataPointsRequest, DailyRollUpDataPointsResponse>
      dailyRollUpDataPointsMethodDescriptor =
          ApiMethodDescriptor
              .<DailyRollUpDataPointsRequest, DailyRollUpDataPointsResponse>newBuilder()
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataPointsService/DailyRollUpDataPoints")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DailyRollUpDataPointsRequest>newBuilder()
                      .setPath(
                          "/v4/{parent=users/*/dataTypes/*}/dataPoints:dailyRollUp",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DailyRollUpDataPointsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DailyRollUpDataPointsRequest> serializer =
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
                  ProtoMessageResponseParser.<DailyRollUpDataPointsResponse>newBuilder()
                      .setDefaultInstance(DailyRollUpDataPointsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ExportExerciseTcxRequest, ExportExerciseTcxResponse>
      exportExerciseTcxMethodDescriptor =
          ApiMethodDescriptor.<ExportExerciseTcxRequest, ExportExerciseTcxResponse>newBuilder()
              .setFullMethodName(
                  "google.devicesandservices.health.v4.DataPointsService/ExportExerciseTcx")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportExerciseTcxRequest>newBuilder()
                      .setPath(
                          "/v4/{name=users/*/dataTypes/*/dataPoints/*}:exportExerciseTcx",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportExerciseTcxRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportExerciseTcxRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "partialData", request.getPartialData());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ExportExerciseTcxResponse>newBuilder()
                      .setDefaultInstance(ExportExerciseTcxResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetDataPointRequest, DataPoint> getDataPointCallable;
  private final UnaryCallable<ListDataPointsRequest, ListDataPointsResponse> listDataPointsCallable;
  private final UnaryCallable<ListDataPointsRequest, ListDataPointsPagedResponse>
      listDataPointsPagedCallable;
  private final UnaryCallable<CreateDataPointRequest, Operation> createDataPointCallable;
  private final OperationCallable<
          CreateDataPointRequest, DataPoint, CreateDataPointOperationMetadata>
      createDataPointOperationCallable;
  private final UnaryCallable<UpdateDataPointRequest, Operation> updateDataPointCallable;
  private final OperationCallable<
          UpdateDataPointRequest, DataPoint, UpdateDataPointOperationMetadata>
      updateDataPointOperationCallable;
  private final UnaryCallable<BatchDeleteDataPointsRequest, Operation>
      batchDeleteDataPointsCallable;
  private final OperationCallable<
          BatchDeleteDataPointsRequest,
          BatchDeleteDataPointsResponse,
          BatchDeleteDataPointsOperationMetadata>
      batchDeleteDataPointsOperationCallable;
  private final UnaryCallable<ReconcileDataPointsRequest, ReconcileDataPointsResponse>
      reconcileDataPointsCallable;
  private final UnaryCallable<ReconcileDataPointsRequest, ReconcileDataPointsPagedResponse>
      reconcileDataPointsPagedCallable;
  private final UnaryCallable<RollUpDataPointsRequest, RollUpDataPointsResponse>
      rollUpDataPointsCallable;
  private final UnaryCallable<RollUpDataPointsRequest, RollUpDataPointsPagedResponse>
      rollUpDataPointsPagedCallable;
  private final UnaryCallable<DailyRollUpDataPointsRequest, DailyRollUpDataPointsResponse>
      dailyRollUpDataPointsCallable;
  private final UnaryCallable<ExportExerciseTcxRequest, ExportExerciseTcxResponse>
      exportExerciseTcxCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDataPointsServiceStub create(DataPointsServiceStubSettings settings)
      throws IOException {
    return new HttpJsonDataPointsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDataPointsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDataPointsServiceStub(
        DataPointsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDataPointsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDataPointsServiceStub(
        DataPointsServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDataPointsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataPointsServiceStub(
      DataPointsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDataPointsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDataPointsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataPointsServiceStub(
      DataPointsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<GetDataPointRequest, DataPoint> getDataPointTransportSettings =
        HttpJsonCallSettings.<GetDataPointRequest, DataPoint>newBuilder()
            .setMethodDescriptor(getDataPointMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListDataPointsRequest, ListDataPointsResponse>
        listDataPointsTransportSettings =
            HttpJsonCallSettings.<ListDataPointsRequest, ListDataPointsResponse>newBuilder()
                .setMethodDescriptor(listDataPointsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateDataPointRequest, Operation> createDataPointTransportSettings =
        HttpJsonCallSettings.<CreateDataPointRequest, Operation>newBuilder()
            .setMethodDescriptor(createDataPointMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<UpdateDataPointRequest, Operation> updateDataPointTransportSettings =
        HttpJsonCallSettings.<UpdateDataPointRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDataPointMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("data_point.name", String.valueOf(request.getDataPoint().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchDeleteDataPointsRequest, Operation>
        batchDeleteDataPointsTransportSettings =
            HttpJsonCallSettings.<BatchDeleteDataPointsRequest, Operation>newBuilder()
                .setMethodDescriptor(batchDeleteDataPointsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<ReconcileDataPointsRequest, ReconcileDataPointsResponse>
        reconcileDataPointsTransportSettings =
            HttpJsonCallSettings
                .<ReconcileDataPointsRequest, ReconcileDataPointsResponse>newBuilder()
                .setMethodDescriptor(reconcileDataPointsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RollUpDataPointsRequest, RollUpDataPointsResponse>
        rollUpDataPointsTransportSettings =
            HttpJsonCallSettings.<RollUpDataPointsRequest, RollUpDataPointsResponse>newBuilder()
                .setMethodDescriptor(rollUpDataPointsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<DailyRollUpDataPointsRequest, DailyRollUpDataPointsResponse>
        dailyRollUpDataPointsTransportSettings =
            HttpJsonCallSettings
                .<DailyRollUpDataPointsRequest, DailyRollUpDataPointsResponse>newBuilder()
                .setMethodDescriptor(dailyRollUpDataPointsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<ExportExerciseTcxRequest, ExportExerciseTcxResponse>
        exportExerciseTcxTransportSettings =
            HttpJsonCallSettings.<ExportExerciseTcxRequest, ExportExerciseTcxResponse>newBuilder()
                .setMethodDescriptor(exportExerciseTcxMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();

    this.getDataPointCallable =
        callableFactory.createUnaryCallable(
            getDataPointTransportSettings, settings.getDataPointSettings(), clientContext);
    this.listDataPointsCallable =
        callableFactory.createUnaryCallable(
            listDataPointsTransportSettings, settings.listDataPointsSettings(), clientContext);
    this.listDataPointsPagedCallable =
        callableFactory.createPagedCallable(
            listDataPointsTransportSettings, settings.listDataPointsSettings(), clientContext);
    this.createDataPointCallable =
        callableFactory.createUnaryCallable(
            createDataPointTransportSettings, settings.createDataPointSettings(), clientContext);
    this.createDataPointOperationCallable =
        callableFactory.createOperationCallable(
            createDataPointTransportSettings,
            settings.createDataPointOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateDataPointCallable =
        callableFactory.createUnaryCallable(
            updateDataPointTransportSettings, settings.updateDataPointSettings(), clientContext);
    this.updateDataPointOperationCallable =
        callableFactory.createOperationCallable(
            updateDataPointTransportSettings,
            settings.updateDataPointOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.batchDeleteDataPointsCallable =
        callableFactory.createUnaryCallable(
            batchDeleteDataPointsTransportSettings,
            settings.batchDeleteDataPointsSettings(),
            clientContext);
    this.batchDeleteDataPointsOperationCallable =
        callableFactory.createOperationCallable(
            batchDeleteDataPointsTransportSettings,
            settings.batchDeleteDataPointsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.reconcileDataPointsCallable =
        callableFactory.createUnaryCallable(
            reconcileDataPointsTransportSettings,
            settings.reconcileDataPointsSettings(),
            clientContext);
    this.reconcileDataPointsPagedCallable =
        callableFactory.createPagedCallable(
            reconcileDataPointsTransportSettings,
            settings.reconcileDataPointsSettings(),
            clientContext);
    this.rollUpDataPointsCallable =
        callableFactory.createUnaryCallable(
            rollUpDataPointsTransportSettings, settings.rollUpDataPointsSettings(), clientContext);
    this.rollUpDataPointsPagedCallable =
        callableFactory.createPagedCallable(
            rollUpDataPointsTransportSettings, settings.rollUpDataPointsSettings(), clientContext);
    this.dailyRollUpDataPointsCallable =
        callableFactory.createUnaryCallable(
            dailyRollUpDataPointsTransportSettings,
            settings.dailyRollUpDataPointsSettings(),
            clientContext);
    this.exportExerciseTcxCallable =
        callableFactory.createUnaryCallable(
            exportExerciseTcxTransportSettings,
            settings.exportExerciseTcxSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getDataPointMethodDescriptor);
    methodDescriptors.add(listDataPointsMethodDescriptor);
    methodDescriptors.add(createDataPointMethodDescriptor);
    methodDescriptors.add(updateDataPointMethodDescriptor);
    methodDescriptors.add(batchDeleteDataPointsMethodDescriptor);
    methodDescriptors.add(reconcileDataPointsMethodDescriptor);
    methodDescriptors.add(rollUpDataPointsMethodDescriptor);
    methodDescriptors.add(dailyRollUpDataPointsMethodDescriptor);
    methodDescriptors.add(exportExerciseTcxMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<GetDataPointRequest, DataPoint> getDataPointCallable() {
    return getDataPointCallable;
  }

  @Override
  public UnaryCallable<ListDataPointsRequest, ListDataPointsResponse> listDataPointsCallable() {
    return listDataPointsCallable;
  }

  @Override
  public UnaryCallable<ListDataPointsRequest, ListDataPointsPagedResponse>
      listDataPointsPagedCallable() {
    return listDataPointsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateDataPointRequest, Operation> createDataPointCallable() {
    return createDataPointCallable;
  }

  @Override
  public OperationCallable<CreateDataPointRequest, DataPoint, CreateDataPointOperationMetadata>
      createDataPointOperationCallable() {
    return createDataPointOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDataPointRequest, Operation> updateDataPointCallable() {
    return updateDataPointCallable;
  }

  @Override
  public OperationCallable<UpdateDataPointRequest, DataPoint, UpdateDataPointOperationMetadata>
      updateDataPointOperationCallable() {
    return updateDataPointOperationCallable;
  }

  @Override
  public UnaryCallable<BatchDeleteDataPointsRequest, Operation> batchDeleteDataPointsCallable() {
    return batchDeleteDataPointsCallable;
  }

  @Override
  public OperationCallable<
          BatchDeleteDataPointsRequest,
          BatchDeleteDataPointsResponse,
          BatchDeleteDataPointsOperationMetadata>
      batchDeleteDataPointsOperationCallable() {
    return batchDeleteDataPointsOperationCallable;
  }

  @Override
  public UnaryCallable<ReconcileDataPointsRequest, ReconcileDataPointsResponse>
      reconcileDataPointsCallable() {
    return reconcileDataPointsCallable;
  }

  @Override
  public UnaryCallable<ReconcileDataPointsRequest, ReconcileDataPointsPagedResponse>
      reconcileDataPointsPagedCallable() {
    return reconcileDataPointsPagedCallable;
  }

  @Override
  public UnaryCallable<RollUpDataPointsRequest, RollUpDataPointsResponse>
      rollUpDataPointsCallable() {
    return rollUpDataPointsCallable;
  }

  @Override
  public UnaryCallable<RollUpDataPointsRequest, RollUpDataPointsPagedResponse>
      rollUpDataPointsPagedCallable() {
    return rollUpDataPointsPagedCallable;
  }

  @Override
  public UnaryCallable<DailyRollUpDataPointsRequest, DailyRollUpDataPointsResponse>
      dailyRollUpDataPointsCallable() {
    return dailyRollUpDataPointsCallable;
  }

  @Override
  public UnaryCallable<ExportExerciseTcxRequest, ExportExerciseTcxResponse>
      exportExerciseTcxCallable() {
    return exportExerciseTcxCallable;
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
