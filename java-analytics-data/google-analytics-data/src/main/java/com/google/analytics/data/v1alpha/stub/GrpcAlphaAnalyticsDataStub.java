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

package com.google.analytics.data.v1alpha.stub;

import static com.google.analytics.data.v1alpha.AlphaAnalyticsDataClient.ListAudienceListsPagedResponse;
import static com.google.analytics.data.v1alpha.AlphaAnalyticsDataClient.ListRecurringAudienceListsPagedResponse;
import static com.google.analytics.data.v1alpha.AlphaAnalyticsDataClient.ListReportTasksPagedResponse;

import com.google.analytics.data.v1alpha.AudienceList;
import com.google.analytics.data.v1alpha.AudienceListMetadata;
import com.google.analytics.data.v1alpha.CreateAudienceListRequest;
import com.google.analytics.data.v1alpha.CreateRecurringAudienceListRequest;
import com.google.analytics.data.v1alpha.CreateReportTaskRequest;
import com.google.analytics.data.v1alpha.GetAudienceListRequest;
import com.google.analytics.data.v1alpha.GetRecurringAudienceListRequest;
import com.google.analytics.data.v1alpha.GetReportTaskRequest;
import com.google.analytics.data.v1alpha.ListAudienceListsRequest;
import com.google.analytics.data.v1alpha.ListAudienceListsResponse;
import com.google.analytics.data.v1alpha.ListRecurringAudienceListsRequest;
import com.google.analytics.data.v1alpha.ListRecurringAudienceListsResponse;
import com.google.analytics.data.v1alpha.ListReportTasksRequest;
import com.google.analytics.data.v1alpha.ListReportTasksResponse;
import com.google.analytics.data.v1alpha.QueryAudienceListRequest;
import com.google.analytics.data.v1alpha.QueryAudienceListResponse;
import com.google.analytics.data.v1alpha.QueryReportTaskRequest;
import com.google.analytics.data.v1alpha.QueryReportTaskResponse;
import com.google.analytics.data.v1alpha.RecurringAudienceList;
import com.google.analytics.data.v1alpha.ReportTask;
import com.google.analytics.data.v1alpha.ReportTaskMetadata;
import com.google.analytics.data.v1alpha.RunFunnelReportRequest;
import com.google.analytics.data.v1alpha.RunFunnelReportResponse;
import com.google.analytics.data.v1alpha.SheetExportAudienceListRequest;
import com.google.analytics.data.v1alpha.SheetExportAudienceListResponse;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AlphaAnalyticsData service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcAlphaAnalyticsDataStub extends AlphaAnalyticsDataStub {
  private static final MethodDescriptor<RunFunnelReportRequest, RunFunnelReportResponse>
      runFunnelReportMethodDescriptor =
          MethodDescriptor.<RunFunnelReportRequest, RunFunnelReportResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.analytics.data.v1alpha.AlphaAnalyticsData/RunFunnelReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RunFunnelReportRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RunFunnelReportResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateAudienceListRequest, Operation>
      createAudienceListMethodDescriptor =
          MethodDescriptor.<CreateAudienceListRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.data.v1alpha.AlphaAnalyticsData/CreateAudienceList")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAudienceListRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<QueryAudienceListRequest, QueryAudienceListResponse>
      queryAudienceListMethodDescriptor =
          MethodDescriptor.<QueryAudienceListRequest, QueryAudienceListResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.data.v1alpha.AlphaAnalyticsData/QueryAudienceList")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(QueryAudienceListRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(QueryAudienceListResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          SheetExportAudienceListRequest, SheetExportAudienceListResponse>
      sheetExportAudienceListMethodDescriptor =
          MethodDescriptor
              .<SheetExportAudienceListRequest, SheetExportAudienceListResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.data.v1alpha.AlphaAnalyticsData/SheetExportAudienceList")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SheetExportAudienceListRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SheetExportAudienceListResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAudienceListRequest, AudienceList>
      getAudienceListMethodDescriptor =
          MethodDescriptor.<GetAudienceListRequest, AudienceList>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.analytics.data.v1alpha.AlphaAnalyticsData/GetAudienceList")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAudienceListRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AudienceList.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAudienceListsRequest, ListAudienceListsResponse>
      listAudienceListsMethodDescriptor =
          MethodDescriptor.<ListAudienceListsRequest, ListAudienceListsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.data.v1alpha.AlphaAnalyticsData/ListAudienceLists")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAudienceListsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAudienceListsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateRecurringAudienceListRequest, RecurringAudienceList>
      createRecurringAudienceListMethodDescriptor =
          MethodDescriptor.<CreateRecurringAudienceListRequest, RecurringAudienceList>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.data.v1alpha.AlphaAnalyticsData/CreateRecurringAudienceList")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateRecurringAudienceListRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RecurringAudienceList.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRecurringAudienceListRequest, RecurringAudienceList>
      getRecurringAudienceListMethodDescriptor =
          MethodDescriptor.<GetRecurringAudienceListRequest, RecurringAudienceList>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.data.v1alpha.AlphaAnalyticsData/GetRecurringAudienceList")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetRecurringAudienceListRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RecurringAudienceList.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListRecurringAudienceListsRequest, ListRecurringAudienceListsResponse>
      listRecurringAudienceListsMethodDescriptor =
          MethodDescriptor
              .<ListRecurringAudienceListsRequest, ListRecurringAudienceListsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.data.v1alpha.AlphaAnalyticsData/ListRecurringAudienceLists")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRecurringAudienceListsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRecurringAudienceListsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateReportTaskRequest, Operation>
      createReportTaskMethodDescriptor =
          MethodDescriptor.<CreateReportTaskRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.analytics.data.v1alpha.AlphaAnalyticsData/CreateReportTask")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateReportTaskRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<QueryReportTaskRequest, QueryReportTaskResponse>
      queryReportTaskMethodDescriptor =
          MethodDescriptor.<QueryReportTaskRequest, QueryReportTaskResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.analytics.data.v1alpha.AlphaAnalyticsData/QueryReportTask")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(QueryReportTaskRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(QueryReportTaskResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetReportTaskRequest, ReportTask>
      getReportTaskMethodDescriptor =
          MethodDescriptor.<GetReportTaskRequest, ReportTask>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.analytics.data.v1alpha.AlphaAnalyticsData/GetReportTask")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetReportTaskRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReportTask.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListReportTasksRequest, ListReportTasksResponse>
      listReportTasksMethodDescriptor =
          MethodDescriptor.<ListReportTasksRequest, ListReportTasksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.analytics.data.v1alpha.AlphaAnalyticsData/ListReportTasks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListReportTasksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListReportTasksResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<RunFunnelReportRequest, RunFunnelReportResponse>
      runFunnelReportCallable;
  private final UnaryCallable<CreateAudienceListRequest, Operation> createAudienceListCallable;
  private final OperationCallable<CreateAudienceListRequest, AudienceList, AudienceListMetadata>
      createAudienceListOperationCallable;
  private final UnaryCallable<QueryAudienceListRequest, QueryAudienceListResponse>
      queryAudienceListCallable;
  private final UnaryCallable<SheetExportAudienceListRequest, SheetExportAudienceListResponse>
      sheetExportAudienceListCallable;
  private final UnaryCallable<GetAudienceListRequest, AudienceList> getAudienceListCallable;
  private final UnaryCallable<ListAudienceListsRequest, ListAudienceListsResponse>
      listAudienceListsCallable;
  private final UnaryCallable<ListAudienceListsRequest, ListAudienceListsPagedResponse>
      listAudienceListsPagedCallable;
  private final UnaryCallable<CreateRecurringAudienceListRequest, RecurringAudienceList>
      createRecurringAudienceListCallable;
  private final UnaryCallable<GetRecurringAudienceListRequest, RecurringAudienceList>
      getRecurringAudienceListCallable;
  private final UnaryCallable<ListRecurringAudienceListsRequest, ListRecurringAudienceListsResponse>
      listRecurringAudienceListsCallable;
  private final UnaryCallable<
          ListRecurringAudienceListsRequest, ListRecurringAudienceListsPagedResponse>
      listRecurringAudienceListsPagedCallable;
  private final UnaryCallable<CreateReportTaskRequest, Operation> createReportTaskCallable;
  private final OperationCallable<CreateReportTaskRequest, ReportTask, ReportTaskMetadata>
      createReportTaskOperationCallable;
  private final UnaryCallable<QueryReportTaskRequest, QueryReportTaskResponse>
      queryReportTaskCallable;
  private final UnaryCallable<GetReportTaskRequest, ReportTask> getReportTaskCallable;
  private final UnaryCallable<ListReportTasksRequest, ListReportTasksResponse>
      listReportTasksCallable;
  private final UnaryCallable<ListReportTasksRequest, ListReportTasksPagedResponse>
      listReportTasksPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAlphaAnalyticsDataStub create(AlphaAnalyticsDataStubSettings settings)
      throws IOException {
    return new GrpcAlphaAnalyticsDataStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAlphaAnalyticsDataStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAlphaAnalyticsDataStub(
        AlphaAnalyticsDataStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAlphaAnalyticsDataStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAlphaAnalyticsDataStub(
        AlphaAnalyticsDataStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAlphaAnalyticsDataStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAlphaAnalyticsDataStub(
      AlphaAnalyticsDataStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcAlphaAnalyticsDataCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAlphaAnalyticsDataStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAlphaAnalyticsDataStub(
      AlphaAnalyticsDataStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<RunFunnelReportRequest, RunFunnelReportResponse>
        runFunnelReportTransportSettings =
            GrpcCallSettings.<RunFunnelReportRequest, RunFunnelReportResponse>newBuilder()
                .setMethodDescriptor(runFunnelReportMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("property", String.valueOf(request.getProperty()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateAudienceListRequest, Operation> createAudienceListTransportSettings =
        GrpcCallSettings.<CreateAudienceListRequest, Operation>newBuilder()
            .setMethodDescriptor(createAudienceListMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<QueryAudienceListRequest, QueryAudienceListResponse>
        queryAudienceListTransportSettings =
            GrpcCallSettings.<QueryAudienceListRequest, QueryAudienceListResponse>newBuilder()
                .setMethodDescriptor(queryAudienceListMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SheetExportAudienceListRequest, SheetExportAudienceListResponse>
        sheetExportAudienceListTransportSettings =
            GrpcCallSettings
                .<SheetExportAudienceListRequest, SheetExportAudienceListResponse>newBuilder()
                .setMethodDescriptor(sheetExportAudienceListMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetAudienceListRequest, AudienceList> getAudienceListTransportSettings =
        GrpcCallSettings.<GetAudienceListRequest, AudienceList>newBuilder()
            .setMethodDescriptor(getAudienceListMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAudienceListsRequest, ListAudienceListsResponse>
        listAudienceListsTransportSettings =
            GrpcCallSettings.<ListAudienceListsRequest, ListAudienceListsResponse>newBuilder()
                .setMethodDescriptor(listAudienceListsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateRecurringAudienceListRequest, RecurringAudienceList>
        createRecurringAudienceListTransportSettings =
            GrpcCallSettings.<CreateRecurringAudienceListRequest, RecurringAudienceList>newBuilder()
                .setMethodDescriptor(createRecurringAudienceListMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetRecurringAudienceListRequest, RecurringAudienceList>
        getRecurringAudienceListTransportSettings =
            GrpcCallSettings.<GetRecurringAudienceListRequest, RecurringAudienceList>newBuilder()
                .setMethodDescriptor(getRecurringAudienceListMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListRecurringAudienceListsRequest, ListRecurringAudienceListsResponse>
        listRecurringAudienceListsTransportSettings =
            GrpcCallSettings
                .<ListRecurringAudienceListsRequest, ListRecurringAudienceListsResponse>newBuilder()
                .setMethodDescriptor(listRecurringAudienceListsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateReportTaskRequest, Operation> createReportTaskTransportSettings =
        GrpcCallSettings.<CreateReportTaskRequest, Operation>newBuilder()
            .setMethodDescriptor(createReportTaskMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<QueryReportTaskRequest, QueryReportTaskResponse>
        queryReportTaskTransportSettings =
            GrpcCallSettings.<QueryReportTaskRequest, QueryReportTaskResponse>newBuilder()
                .setMethodDescriptor(queryReportTaskMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetReportTaskRequest, ReportTask> getReportTaskTransportSettings =
        GrpcCallSettings.<GetReportTaskRequest, ReportTask>newBuilder()
            .setMethodDescriptor(getReportTaskMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListReportTasksRequest, ListReportTasksResponse>
        listReportTasksTransportSettings =
            GrpcCallSettings.<ListReportTasksRequest, ListReportTasksResponse>newBuilder()
                .setMethodDescriptor(listReportTasksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.runFunnelReportCallable =
        callableFactory.createUnaryCallable(
            runFunnelReportTransportSettings, settings.runFunnelReportSettings(), clientContext);
    this.createAudienceListCallable =
        callableFactory.createUnaryCallable(
            createAudienceListTransportSettings,
            settings.createAudienceListSettings(),
            clientContext);
    this.createAudienceListOperationCallable =
        callableFactory.createOperationCallable(
            createAudienceListTransportSettings,
            settings.createAudienceListOperationSettings(),
            clientContext,
            operationsStub);
    this.queryAudienceListCallable =
        callableFactory.createUnaryCallable(
            queryAudienceListTransportSettings,
            settings.queryAudienceListSettings(),
            clientContext);
    this.sheetExportAudienceListCallable =
        callableFactory.createUnaryCallable(
            sheetExportAudienceListTransportSettings,
            settings.sheetExportAudienceListSettings(),
            clientContext);
    this.getAudienceListCallable =
        callableFactory.createUnaryCallable(
            getAudienceListTransportSettings, settings.getAudienceListSettings(), clientContext);
    this.listAudienceListsCallable =
        callableFactory.createUnaryCallable(
            listAudienceListsTransportSettings,
            settings.listAudienceListsSettings(),
            clientContext);
    this.listAudienceListsPagedCallable =
        callableFactory.createPagedCallable(
            listAudienceListsTransportSettings,
            settings.listAudienceListsSettings(),
            clientContext);
    this.createRecurringAudienceListCallable =
        callableFactory.createUnaryCallable(
            createRecurringAudienceListTransportSettings,
            settings.createRecurringAudienceListSettings(),
            clientContext);
    this.getRecurringAudienceListCallable =
        callableFactory.createUnaryCallable(
            getRecurringAudienceListTransportSettings,
            settings.getRecurringAudienceListSettings(),
            clientContext);
    this.listRecurringAudienceListsCallable =
        callableFactory.createUnaryCallable(
            listRecurringAudienceListsTransportSettings,
            settings.listRecurringAudienceListsSettings(),
            clientContext);
    this.listRecurringAudienceListsPagedCallable =
        callableFactory.createPagedCallable(
            listRecurringAudienceListsTransportSettings,
            settings.listRecurringAudienceListsSettings(),
            clientContext);
    this.createReportTaskCallable =
        callableFactory.createUnaryCallable(
            createReportTaskTransportSettings, settings.createReportTaskSettings(), clientContext);
    this.createReportTaskOperationCallable =
        callableFactory.createOperationCallable(
            createReportTaskTransportSettings,
            settings.createReportTaskOperationSettings(),
            clientContext,
            operationsStub);
    this.queryReportTaskCallable =
        callableFactory.createUnaryCallable(
            queryReportTaskTransportSettings, settings.queryReportTaskSettings(), clientContext);
    this.getReportTaskCallable =
        callableFactory.createUnaryCallable(
            getReportTaskTransportSettings, settings.getReportTaskSettings(), clientContext);
    this.listReportTasksCallable =
        callableFactory.createUnaryCallable(
            listReportTasksTransportSettings, settings.listReportTasksSettings(), clientContext);
    this.listReportTasksPagedCallable =
        callableFactory.createPagedCallable(
            listReportTasksTransportSettings, settings.listReportTasksSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<RunFunnelReportRequest, RunFunnelReportResponse> runFunnelReportCallable() {
    return runFunnelReportCallable;
  }

  @Override
  public UnaryCallable<CreateAudienceListRequest, Operation> createAudienceListCallable() {
    return createAudienceListCallable;
  }

  @Override
  public OperationCallable<CreateAudienceListRequest, AudienceList, AudienceListMetadata>
      createAudienceListOperationCallable() {
    return createAudienceListOperationCallable;
  }

  @Override
  public UnaryCallable<QueryAudienceListRequest, QueryAudienceListResponse>
      queryAudienceListCallable() {
    return queryAudienceListCallable;
  }

  @Override
  public UnaryCallable<SheetExportAudienceListRequest, SheetExportAudienceListResponse>
      sheetExportAudienceListCallable() {
    return sheetExportAudienceListCallable;
  }

  @Override
  public UnaryCallable<GetAudienceListRequest, AudienceList> getAudienceListCallable() {
    return getAudienceListCallable;
  }

  @Override
  public UnaryCallable<ListAudienceListsRequest, ListAudienceListsResponse>
      listAudienceListsCallable() {
    return listAudienceListsCallable;
  }

  @Override
  public UnaryCallable<ListAudienceListsRequest, ListAudienceListsPagedResponse>
      listAudienceListsPagedCallable() {
    return listAudienceListsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateRecurringAudienceListRequest, RecurringAudienceList>
      createRecurringAudienceListCallable() {
    return createRecurringAudienceListCallable;
  }

  @Override
  public UnaryCallable<GetRecurringAudienceListRequest, RecurringAudienceList>
      getRecurringAudienceListCallable() {
    return getRecurringAudienceListCallable;
  }

  @Override
  public UnaryCallable<ListRecurringAudienceListsRequest, ListRecurringAudienceListsResponse>
      listRecurringAudienceListsCallable() {
    return listRecurringAudienceListsCallable;
  }

  @Override
  public UnaryCallable<ListRecurringAudienceListsRequest, ListRecurringAudienceListsPagedResponse>
      listRecurringAudienceListsPagedCallable() {
    return listRecurringAudienceListsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateReportTaskRequest, Operation> createReportTaskCallable() {
    return createReportTaskCallable;
  }

  @Override
  public OperationCallable<CreateReportTaskRequest, ReportTask, ReportTaskMetadata>
      createReportTaskOperationCallable() {
    return createReportTaskOperationCallable;
  }

  @Override
  public UnaryCallable<QueryReportTaskRequest, QueryReportTaskResponse> queryReportTaskCallable() {
    return queryReportTaskCallable;
  }

  @Override
  public UnaryCallable<GetReportTaskRequest, ReportTask> getReportTaskCallable() {
    return getReportTaskCallable;
  }

  @Override
  public UnaryCallable<ListReportTasksRequest, ListReportTasksResponse> listReportTasksCallable() {
    return listReportTasksCallable;
  }

  @Override
  public UnaryCallable<ListReportTasksRequest, ListReportTasksPagedResponse>
      listReportTasksPagedCallable() {
    return listReportTasksPagedCallable;
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
