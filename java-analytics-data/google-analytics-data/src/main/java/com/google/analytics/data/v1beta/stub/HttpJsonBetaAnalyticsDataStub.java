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

package com.google.analytics.data.v1beta.stub;

import static com.google.analytics.data.v1beta.BetaAnalyticsDataClient.ListAudienceExportsPagedResponse;

import com.google.analytics.data.v1beta.AudienceExport;
import com.google.analytics.data.v1beta.AudienceExportMetadata;
import com.google.analytics.data.v1beta.BatchRunPivotReportsRequest;
import com.google.analytics.data.v1beta.BatchRunPivotReportsResponse;
import com.google.analytics.data.v1beta.BatchRunReportsRequest;
import com.google.analytics.data.v1beta.BatchRunReportsResponse;
import com.google.analytics.data.v1beta.CheckCompatibilityRequest;
import com.google.analytics.data.v1beta.CheckCompatibilityResponse;
import com.google.analytics.data.v1beta.CreateAudienceExportRequest;
import com.google.analytics.data.v1beta.GetAudienceExportRequest;
import com.google.analytics.data.v1beta.GetMetadataRequest;
import com.google.analytics.data.v1beta.ListAudienceExportsRequest;
import com.google.analytics.data.v1beta.ListAudienceExportsResponse;
import com.google.analytics.data.v1beta.Metadata;
import com.google.analytics.data.v1beta.QueryAudienceExportRequest;
import com.google.analytics.data.v1beta.QueryAudienceExportResponse;
import com.google.analytics.data.v1beta.RunPivotReportRequest;
import com.google.analytics.data.v1beta.RunPivotReportResponse;
import com.google.analytics.data.v1beta.RunRealtimeReportRequest;
import com.google.analytics.data.v1beta.RunRealtimeReportResponse;
import com.google.analytics.data.v1beta.RunReportRequest;
import com.google.analytics.data.v1beta.RunReportResponse;
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
 * REST stub implementation for the BetaAnalyticsData service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonBetaAnalyticsDataStub extends BetaAnalyticsDataStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(AudienceExportMetadata.getDescriptor())
          .add(AudienceExport.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<RunReportRequest, RunReportResponse>
      runReportMethodDescriptor =
          ApiMethodDescriptor.<RunReportRequest, RunReportResponse>newBuilder()
              .setFullMethodName("google.analytics.data.v1beta.BetaAnalyticsData/RunReport")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RunReportRequest>newBuilder()
                      .setPath(
                          "/v1beta/{property=properties/*}:runReport",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RunReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "property", request.getProperty());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RunReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearProperty().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RunReportResponse>newBuilder()
                      .setDefaultInstance(RunReportResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RunPivotReportRequest, RunPivotReportResponse>
      runPivotReportMethodDescriptor =
          ApiMethodDescriptor.<RunPivotReportRequest, RunPivotReportResponse>newBuilder()
              .setFullMethodName("google.analytics.data.v1beta.BetaAnalyticsData/RunPivotReport")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RunPivotReportRequest>newBuilder()
                      .setPath(
                          "/v1beta/{property=properties/*}:runPivotReport",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RunPivotReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "property", request.getProperty());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RunPivotReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearProperty().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RunPivotReportResponse>newBuilder()
                      .setDefaultInstance(RunPivotReportResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchRunReportsRequest, BatchRunReportsResponse>
      batchRunReportsMethodDescriptor =
          ApiMethodDescriptor.<BatchRunReportsRequest, BatchRunReportsResponse>newBuilder()
              .setFullMethodName("google.analytics.data.v1beta.BetaAnalyticsData/BatchRunReports")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchRunReportsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{property=properties/*}:batchRunReports",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRunReportsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "property", request.getProperty());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRunReportsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearProperty().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchRunReportsResponse>newBuilder()
                      .setDefaultInstance(BatchRunReportsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchRunPivotReportsRequest, BatchRunPivotReportsResponse>
      batchRunPivotReportsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchRunPivotReportsRequest, BatchRunPivotReportsResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.data.v1beta.BetaAnalyticsData/BatchRunPivotReports")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchRunPivotReportsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{property=properties/*}:batchRunPivotReports",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRunPivotReportsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "property", request.getProperty());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRunPivotReportsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearProperty().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchRunPivotReportsResponse>newBuilder()
                      .setDefaultInstance(BatchRunPivotReportsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetMetadataRequest, Metadata>
      getMetadataMethodDescriptor =
          ApiMethodDescriptor.<GetMetadataRequest, Metadata>newBuilder()
              .setFullMethodName("google.analytics.data.v1beta.BetaAnalyticsData/GetMetadata")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetMetadataRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=properties/*/metadata}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetMetadataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetMetadataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Metadata>newBuilder()
                      .setDefaultInstance(Metadata.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RunRealtimeReportRequest, RunRealtimeReportResponse>
      runRealtimeReportMethodDescriptor =
          ApiMethodDescriptor.<RunRealtimeReportRequest, RunRealtimeReportResponse>newBuilder()
              .setFullMethodName("google.analytics.data.v1beta.BetaAnalyticsData/RunRealtimeReport")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RunRealtimeReportRequest>newBuilder()
                      .setPath(
                          "/v1beta/{property=properties/*}:runRealtimeReport",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RunRealtimeReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "property", request.getProperty());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RunRealtimeReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearProperty().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RunRealtimeReportResponse>newBuilder()
                      .setDefaultInstance(RunRealtimeReportResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CheckCompatibilityRequest, CheckCompatibilityResponse>
      checkCompatibilityMethodDescriptor =
          ApiMethodDescriptor.<CheckCompatibilityRequest, CheckCompatibilityResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.data.v1beta.BetaAnalyticsData/CheckCompatibility")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CheckCompatibilityRequest>newBuilder()
                      .setPath(
                          "/v1beta/{property=properties/*}:checkCompatibility",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CheckCompatibilityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "property", request.getProperty());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CheckCompatibilityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearProperty().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CheckCompatibilityResponse>newBuilder()
                      .setDefaultInstance(CheckCompatibilityResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAudienceExportRequest, Operation>
      createAudienceExportMethodDescriptor =
          ApiMethodDescriptor.<CreateAudienceExportRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.analytics.data.v1beta.BetaAnalyticsData/CreateAudienceExport")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAudienceExportRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=properties/*}/audienceExports",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAudienceExportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAudienceExportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("audienceExport", request.getAudienceExport(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateAudienceExportRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<QueryAudienceExportRequest, QueryAudienceExportResponse>
      queryAudienceExportMethodDescriptor =
          ApiMethodDescriptor.<QueryAudienceExportRequest, QueryAudienceExportResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.data.v1beta.BetaAnalyticsData/QueryAudienceExport")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<QueryAudienceExportRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=properties/*/audienceExports/*}:query",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<QueryAudienceExportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<QueryAudienceExportRequest> serializer =
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
                  ProtoMessageResponseParser.<QueryAudienceExportResponse>newBuilder()
                      .setDefaultInstance(QueryAudienceExportResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAudienceExportRequest, AudienceExport>
      getAudienceExportMethodDescriptor =
          ApiMethodDescriptor.<GetAudienceExportRequest, AudienceExport>newBuilder()
              .setFullMethodName("google.analytics.data.v1beta.BetaAnalyticsData/GetAudienceExport")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAudienceExportRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=properties/*/audienceExports/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAudienceExportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAudienceExportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AudienceExport>newBuilder()
                      .setDefaultInstance(AudienceExport.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAudienceExportsRequest, ListAudienceExportsResponse>
      listAudienceExportsMethodDescriptor =
          ApiMethodDescriptor.<ListAudienceExportsRequest, ListAudienceExportsResponse>newBuilder()
              .setFullMethodName(
                  "google.analytics.data.v1beta.BetaAnalyticsData/ListAudienceExports")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAudienceExportsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=properties/*}/audienceExports",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAudienceExportsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAudienceExportsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAudienceExportsResponse>newBuilder()
                      .setDefaultInstance(ListAudienceExportsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<RunReportRequest, RunReportResponse> runReportCallable;
  private final UnaryCallable<RunPivotReportRequest, RunPivotReportResponse> runPivotReportCallable;
  private final UnaryCallable<BatchRunReportsRequest, BatchRunReportsResponse>
      batchRunReportsCallable;
  private final UnaryCallable<BatchRunPivotReportsRequest, BatchRunPivotReportsResponse>
      batchRunPivotReportsCallable;
  private final UnaryCallable<GetMetadataRequest, Metadata> getMetadataCallable;
  private final UnaryCallable<RunRealtimeReportRequest, RunRealtimeReportResponse>
      runRealtimeReportCallable;
  private final UnaryCallable<CheckCompatibilityRequest, CheckCompatibilityResponse>
      checkCompatibilityCallable;
  private final UnaryCallable<CreateAudienceExportRequest, Operation> createAudienceExportCallable;
  private final OperationCallable<
          CreateAudienceExportRequest, AudienceExport, AudienceExportMetadata>
      createAudienceExportOperationCallable;
  private final UnaryCallable<QueryAudienceExportRequest, QueryAudienceExportResponse>
      queryAudienceExportCallable;
  private final UnaryCallable<GetAudienceExportRequest, AudienceExport> getAudienceExportCallable;
  private final UnaryCallable<ListAudienceExportsRequest, ListAudienceExportsResponse>
      listAudienceExportsCallable;
  private final UnaryCallable<ListAudienceExportsRequest, ListAudienceExportsPagedResponse>
      listAudienceExportsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonBetaAnalyticsDataStub create(BetaAnalyticsDataStubSettings settings)
      throws IOException {
    return new HttpJsonBetaAnalyticsDataStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonBetaAnalyticsDataStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonBetaAnalyticsDataStub(
        BetaAnalyticsDataStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonBetaAnalyticsDataStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonBetaAnalyticsDataStub(
        BetaAnalyticsDataStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonBetaAnalyticsDataStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBetaAnalyticsDataStub(
      BetaAnalyticsDataStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonBetaAnalyticsDataCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonBetaAnalyticsDataStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBetaAnalyticsDataStub(
      BetaAnalyticsDataStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<RunReportRequest, RunReportResponse> runReportTransportSettings =
        HttpJsonCallSettings.<RunReportRequest, RunReportResponse>newBuilder()
            .setMethodDescriptor(runReportMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("property", String.valueOf(request.getProperty()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RunPivotReportRequest, RunPivotReportResponse>
        runPivotReportTransportSettings =
            HttpJsonCallSettings.<RunPivotReportRequest, RunPivotReportResponse>newBuilder()
                .setMethodDescriptor(runPivotReportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("property", String.valueOf(request.getProperty()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchRunReportsRequest, BatchRunReportsResponse>
        batchRunReportsTransportSettings =
            HttpJsonCallSettings.<BatchRunReportsRequest, BatchRunReportsResponse>newBuilder()
                .setMethodDescriptor(batchRunReportsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("property", String.valueOf(request.getProperty()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchRunPivotReportsRequest, BatchRunPivotReportsResponse>
        batchRunPivotReportsTransportSettings =
            HttpJsonCallSettings
                .<BatchRunPivotReportsRequest, BatchRunPivotReportsResponse>newBuilder()
                .setMethodDescriptor(batchRunPivotReportsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("property", String.valueOf(request.getProperty()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetMetadataRequest, Metadata> getMetadataTransportSettings =
        HttpJsonCallSettings.<GetMetadataRequest, Metadata>newBuilder()
            .setMethodDescriptor(getMetadataMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RunRealtimeReportRequest, RunRealtimeReportResponse>
        runRealtimeReportTransportSettings =
            HttpJsonCallSettings.<RunRealtimeReportRequest, RunRealtimeReportResponse>newBuilder()
                .setMethodDescriptor(runRealtimeReportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("property", String.valueOf(request.getProperty()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CheckCompatibilityRequest, CheckCompatibilityResponse>
        checkCompatibilityTransportSettings =
            HttpJsonCallSettings.<CheckCompatibilityRequest, CheckCompatibilityResponse>newBuilder()
                .setMethodDescriptor(checkCompatibilityMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("property", String.valueOf(request.getProperty()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateAudienceExportRequest, Operation>
        createAudienceExportTransportSettings =
            HttpJsonCallSettings.<CreateAudienceExportRequest, Operation>newBuilder()
                .setMethodDescriptor(createAudienceExportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<QueryAudienceExportRequest, QueryAudienceExportResponse>
        queryAudienceExportTransportSettings =
            HttpJsonCallSettings
                .<QueryAudienceExportRequest, QueryAudienceExportResponse>newBuilder()
                .setMethodDescriptor(queryAudienceExportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetAudienceExportRequest, AudienceExport>
        getAudienceExportTransportSettings =
            HttpJsonCallSettings.<GetAudienceExportRequest, AudienceExport>newBuilder()
                .setMethodDescriptor(getAudienceExportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListAudienceExportsRequest, ListAudienceExportsResponse>
        listAudienceExportsTransportSettings =
            HttpJsonCallSettings
                .<ListAudienceExportsRequest, ListAudienceExportsResponse>newBuilder()
                .setMethodDescriptor(listAudienceExportsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.runReportCallable =
        callableFactory.createUnaryCallable(
            runReportTransportSettings, settings.runReportSettings(), clientContext);
    this.runPivotReportCallable =
        callableFactory.createUnaryCallable(
            runPivotReportTransportSettings, settings.runPivotReportSettings(), clientContext);
    this.batchRunReportsCallable =
        callableFactory.createUnaryCallable(
            batchRunReportsTransportSettings, settings.batchRunReportsSettings(), clientContext);
    this.batchRunPivotReportsCallable =
        callableFactory.createUnaryCallable(
            batchRunPivotReportsTransportSettings,
            settings.batchRunPivotReportsSettings(),
            clientContext);
    this.getMetadataCallable =
        callableFactory.createUnaryCallable(
            getMetadataTransportSettings, settings.getMetadataSettings(), clientContext);
    this.runRealtimeReportCallable =
        callableFactory.createUnaryCallable(
            runRealtimeReportTransportSettings,
            settings.runRealtimeReportSettings(),
            clientContext);
    this.checkCompatibilityCallable =
        callableFactory.createUnaryCallable(
            checkCompatibilityTransportSettings,
            settings.checkCompatibilitySettings(),
            clientContext);
    this.createAudienceExportCallable =
        callableFactory.createUnaryCallable(
            createAudienceExportTransportSettings,
            settings.createAudienceExportSettings(),
            clientContext);
    this.createAudienceExportOperationCallable =
        callableFactory.createOperationCallable(
            createAudienceExportTransportSettings,
            settings.createAudienceExportOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.queryAudienceExportCallable =
        callableFactory.createUnaryCallable(
            queryAudienceExportTransportSettings,
            settings.queryAudienceExportSettings(),
            clientContext);
    this.getAudienceExportCallable =
        callableFactory.createUnaryCallable(
            getAudienceExportTransportSettings,
            settings.getAudienceExportSettings(),
            clientContext);
    this.listAudienceExportsCallable =
        callableFactory.createUnaryCallable(
            listAudienceExportsTransportSettings,
            settings.listAudienceExportsSettings(),
            clientContext);
    this.listAudienceExportsPagedCallable =
        callableFactory.createPagedCallable(
            listAudienceExportsTransportSettings,
            settings.listAudienceExportsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(runReportMethodDescriptor);
    methodDescriptors.add(runPivotReportMethodDescriptor);
    methodDescriptors.add(batchRunReportsMethodDescriptor);
    methodDescriptors.add(batchRunPivotReportsMethodDescriptor);
    methodDescriptors.add(getMetadataMethodDescriptor);
    methodDescriptors.add(runRealtimeReportMethodDescriptor);
    methodDescriptors.add(checkCompatibilityMethodDescriptor);
    methodDescriptors.add(createAudienceExportMethodDescriptor);
    methodDescriptors.add(queryAudienceExportMethodDescriptor);
    methodDescriptors.add(getAudienceExportMethodDescriptor);
    methodDescriptors.add(listAudienceExportsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<RunReportRequest, RunReportResponse> runReportCallable() {
    return runReportCallable;
  }

  @Override
  public UnaryCallable<RunPivotReportRequest, RunPivotReportResponse> runPivotReportCallable() {
    return runPivotReportCallable;
  }

  @Override
  public UnaryCallable<BatchRunReportsRequest, BatchRunReportsResponse> batchRunReportsCallable() {
    return batchRunReportsCallable;
  }

  @Override
  public UnaryCallable<BatchRunPivotReportsRequest, BatchRunPivotReportsResponse>
      batchRunPivotReportsCallable() {
    return batchRunPivotReportsCallable;
  }

  @Override
  public UnaryCallable<GetMetadataRequest, Metadata> getMetadataCallable() {
    return getMetadataCallable;
  }

  @Override
  public UnaryCallable<RunRealtimeReportRequest, RunRealtimeReportResponse>
      runRealtimeReportCallable() {
    return runRealtimeReportCallable;
  }

  @Override
  public UnaryCallable<CheckCompatibilityRequest, CheckCompatibilityResponse>
      checkCompatibilityCallable() {
    return checkCompatibilityCallable;
  }

  @Override
  public UnaryCallable<CreateAudienceExportRequest, Operation> createAudienceExportCallable() {
    return createAudienceExportCallable;
  }

  @Override
  public OperationCallable<CreateAudienceExportRequest, AudienceExport, AudienceExportMetadata>
      createAudienceExportOperationCallable() {
    return createAudienceExportOperationCallable;
  }

  @Override
  public UnaryCallable<QueryAudienceExportRequest, QueryAudienceExportResponse>
      queryAudienceExportCallable() {
    return queryAudienceExportCallable;
  }

  @Override
  public UnaryCallable<GetAudienceExportRequest, AudienceExport> getAudienceExportCallable() {
    return getAudienceExportCallable;
  }

  @Override
  public UnaryCallable<ListAudienceExportsRequest, ListAudienceExportsResponse>
      listAudienceExportsCallable() {
    return listAudienceExportsCallable;
  }

  @Override
  public UnaryCallable<ListAudienceExportsRequest, ListAudienceExportsPagedResponse>
      listAudienceExportsPagedCallable() {
    return listAudienceExportsPagedCallable;
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
