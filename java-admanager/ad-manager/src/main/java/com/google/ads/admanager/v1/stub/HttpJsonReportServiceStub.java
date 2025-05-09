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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.ReportServiceClient.FetchReportResultRowsPagedResponse;
import static com.google.ads.admanager.v1.ReportServiceClient.ListReportsPagedResponse;

import com.google.ads.admanager.v1.CreateReportRequest;
import com.google.ads.admanager.v1.FetchReportResultRowsRequest;
import com.google.ads.admanager.v1.FetchReportResultRowsResponse;
import com.google.ads.admanager.v1.GetReportRequest;
import com.google.ads.admanager.v1.ListReportsRequest;
import com.google.ads.admanager.v1.ListReportsResponse;
import com.google.ads.admanager.v1.Report;
import com.google.ads.admanager.v1.RunReportMetadata;
import com.google.ads.admanager.v1.RunReportRequest;
import com.google.ads.admanager.v1.RunReportResponse;
import com.google.ads.admanager.v1.UpdateReportRequest;
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
 * REST stub implementation for the ReportService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonReportServiceStub extends ReportServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(RunReportMetadata.getDescriptor())
          .add(RunReportResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<GetReportRequest, Report> getReportMethodDescriptor =
      ApiMethodDescriptor.<GetReportRequest, Report>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.ReportService/GetReport")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetReportRequest>newBuilder()
                  .setPath(
                      "/v1/{name=networks/*/reports/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetReportRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetReportRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Report>newBuilder()
                  .setDefaultInstance(Report.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListReportsRequest, ListReportsResponse>
      listReportsMethodDescriptor =
          ApiMethodDescriptor.<ListReportsRequest, ListReportsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ReportService/ListReports")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReportsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/reports",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReportsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListReportsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "skip", request.getSkip());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListReportsResponse>newBuilder()
                      .setDefaultInstance(ListReportsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateReportRequest, Report>
      createReportMethodDescriptor =
          ApiMethodDescriptor.<CreateReportRequest, Report>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ReportService/CreateReport")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateReportRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/reports",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("report", request.getReport(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Report>newBuilder()
                      .setDefaultInstance(Report.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateReportRequest, Report>
      updateReportMethodDescriptor =
          ApiMethodDescriptor.<UpdateReportRequest, Report>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ReportService/UpdateReport")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateReportRequest>newBuilder()
                      .setPath(
                          "/v1/{report.name=networks/*/reports/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "report.name", request.getReport().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("report", request.getReport(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Report>newBuilder()
                      .setDefaultInstance(Report.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RunReportRequest, Operation> runReportMethodDescriptor =
      ApiMethodDescriptor.<RunReportRequest, Operation>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.ReportService/RunReport")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<RunReportRequest>newBuilder()
                  .setPath(
                      "/v1/{name=networks/*/reports/*}:run",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<RunReportRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
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
                              .toBody("*", request.toBuilder().clearName().build(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (RunReportRequest request, Operation response) ->
                  HttpJsonOperationSnapshot.create(response))
          .build();

  private static final ApiMethodDescriptor<
          FetchReportResultRowsRequest, FetchReportResultRowsResponse>
      fetchReportResultRowsMethodDescriptor =
          ApiMethodDescriptor
              .<FetchReportResultRowsRequest, FetchReportResultRowsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ReportService/FetchReportResultRows")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchReportResultRowsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/reports/*/results/*}:fetchRows",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchReportResultRowsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchReportResultRowsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchReportResultRowsResponse>newBuilder()
                      .setDefaultInstance(FetchReportResultRowsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetReportRequest, Report> getReportCallable;
  private final UnaryCallable<ListReportsRequest, ListReportsResponse> listReportsCallable;
  private final UnaryCallable<ListReportsRequest, ListReportsPagedResponse>
      listReportsPagedCallable;
  private final UnaryCallable<CreateReportRequest, Report> createReportCallable;
  private final UnaryCallable<UpdateReportRequest, Report> updateReportCallable;
  private final UnaryCallable<RunReportRequest, Operation> runReportCallable;
  private final OperationCallable<RunReportRequest, RunReportResponse, RunReportMetadata>
      runReportOperationCallable;
  private final UnaryCallable<FetchReportResultRowsRequest, FetchReportResultRowsResponse>
      fetchReportResultRowsCallable;
  private final UnaryCallable<FetchReportResultRowsRequest, FetchReportResultRowsPagedResponse>
      fetchReportResultRowsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonReportServiceStub create(ReportServiceStubSettings settings)
      throws IOException {
    return new HttpJsonReportServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonReportServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonReportServiceStub(
        ReportServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonReportServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonReportServiceStub(
        ReportServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonReportServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonReportServiceStub(
      ReportServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonReportServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonReportServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonReportServiceStub(
      ReportServiceStubSettings settings,
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
                        .setGet("/v1/{name=networks/*/operations/reports/runs/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=networks/*/operations/reports/exports/*}")
                                .build())
                        .build())
                .build());

    HttpJsonCallSettings<GetReportRequest, Report> getReportTransportSettings =
        HttpJsonCallSettings.<GetReportRequest, Report>newBuilder()
            .setMethodDescriptor(getReportMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListReportsRequest, ListReportsResponse> listReportsTransportSettings =
        HttpJsonCallSettings.<ListReportsRequest, ListReportsResponse>newBuilder()
            .setMethodDescriptor(listReportsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateReportRequest, Report> createReportTransportSettings =
        HttpJsonCallSettings.<CreateReportRequest, Report>newBuilder()
            .setMethodDescriptor(createReportMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateReportRequest, Report> updateReportTransportSettings =
        HttpJsonCallSettings.<UpdateReportRequest, Report>newBuilder()
            .setMethodDescriptor(updateReportMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("report.name", String.valueOf(request.getReport().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RunReportRequest, Operation> runReportTransportSettings =
        HttpJsonCallSettings.<RunReportRequest, Operation>newBuilder()
            .setMethodDescriptor(runReportMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<FetchReportResultRowsRequest, FetchReportResultRowsResponse>
        fetchReportResultRowsTransportSettings =
            HttpJsonCallSettings
                .<FetchReportResultRowsRequest, FetchReportResultRowsResponse>newBuilder()
                .setMethodDescriptor(fetchReportResultRowsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.getReportCallable =
        callableFactory.createUnaryCallable(
            getReportTransportSettings, settings.getReportSettings(), clientContext);
    this.listReportsCallable =
        callableFactory.createUnaryCallable(
            listReportsTransportSettings, settings.listReportsSettings(), clientContext);
    this.listReportsPagedCallable =
        callableFactory.createPagedCallable(
            listReportsTransportSettings, settings.listReportsSettings(), clientContext);
    this.createReportCallable =
        callableFactory.createUnaryCallable(
            createReportTransportSettings, settings.createReportSettings(), clientContext);
    this.updateReportCallable =
        callableFactory.createUnaryCallable(
            updateReportTransportSettings, settings.updateReportSettings(), clientContext);
    this.runReportCallable =
        callableFactory.createUnaryCallable(
            runReportTransportSettings, settings.runReportSettings(), clientContext);
    this.runReportOperationCallable =
        callableFactory.createOperationCallable(
            runReportTransportSettings,
            settings.runReportOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.fetchReportResultRowsCallable =
        callableFactory.createUnaryCallable(
            fetchReportResultRowsTransportSettings,
            settings.fetchReportResultRowsSettings(),
            clientContext);
    this.fetchReportResultRowsPagedCallable =
        callableFactory.createPagedCallable(
            fetchReportResultRowsTransportSettings,
            settings.fetchReportResultRowsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getReportMethodDescriptor);
    methodDescriptors.add(listReportsMethodDescriptor);
    methodDescriptors.add(createReportMethodDescriptor);
    methodDescriptors.add(updateReportMethodDescriptor);
    methodDescriptors.add(runReportMethodDescriptor);
    methodDescriptors.add(fetchReportResultRowsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<GetReportRequest, Report> getReportCallable() {
    return getReportCallable;
  }

  @Override
  public UnaryCallable<ListReportsRequest, ListReportsResponse> listReportsCallable() {
    return listReportsCallable;
  }

  @Override
  public UnaryCallable<ListReportsRequest, ListReportsPagedResponse> listReportsPagedCallable() {
    return listReportsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateReportRequest, Report> createReportCallable() {
    return createReportCallable;
  }

  @Override
  public UnaryCallable<UpdateReportRequest, Report> updateReportCallable() {
    return updateReportCallable;
  }

  @Override
  public UnaryCallable<RunReportRequest, Operation> runReportCallable() {
    return runReportCallable;
  }

  @Override
  public OperationCallable<RunReportRequest, RunReportResponse, RunReportMetadata>
      runReportOperationCallable() {
    return runReportOperationCallable;
  }

  @Override
  public UnaryCallable<FetchReportResultRowsRequest, FetchReportResultRowsResponse>
      fetchReportResultRowsCallable() {
    return fetchReportResultRowsCallable;
  }

  @Override
  public UnaryCallable<FetchReportResultRowsRequest, FetchReportResultRowsPagedResponse>
      fetchReportResultRowsPagedCallable() {
    return fetchReportResultRowsPagedCallable;
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
