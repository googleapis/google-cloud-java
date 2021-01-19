/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.bigquery.datatransfer.v1.stub;

import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListDataSourcesPagedResponse;
import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListTransferConfigsPagedResponse;
import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListTransferLogsPagedResponse;
import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListTransferRunsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest;
import com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse;
import com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest;
import com.google.cloud.bigquery.datatransfer.v1.DataSource;
import com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest;
import com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest;
import com.google.cloud.bigquery.datatransfer.v1.GetDataSourceRequest;
import com.google.cloud.bigquery.datatransfer.v1.GetTransferConfigRequest;
import com.google.cloud.bigquery.datatransfer.v1.GetTransferRunRequest;
import com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest;
import com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesResponse;
import com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsRequest;
import com.google.cloud.bigquery.datatransfer.v1.ListTransferConfigsResponse;
import com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsRequest;
import com.google.cloud.bigquery.datatransfer.v1.ListTransferLogsResponse;
import com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsRequest;
import com.google.cloud.bigquery.datatransfer.v1.ListTransferRunsResponse;
import com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsRequest;
import com.google.cloud.bigquery.datatransfer.v1.ScheduleTransferRunsResponse;
import com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsRequest;
import com.google.cloud.bigquery.datatransfer.v1.StartManualTransferRunsResponse;
import com.google.cloud.bigquery.datatransfer.v1.TransferConfig;
import com.google.cloud.bigquery.datatransfer.v1.TransferRun;
import com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DataTransferService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDataTransferServiceStub extends DataTransferServiceStub {
  private static final MethodDescriptor<GetDataSourceRequest, DataSource>
      getDataSourceMethodDescriptor =
          MethodDescriptor.<GetDataSourceRequest, DataSource>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/GetDataSource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataSource.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDataSourcesRequest, ListDataSourcesResponse>
      listDataSourcesMethodDescriptor =
          MethodDescriptor.<ListDataSourcesRequest, ListDataSourcesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/ListDataSources")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataSourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataSourcesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateTransferConfigRequest, TransferConfig>
      createTransferConfigMethodDescriptor =
          MethodDescriptor.<CreateTransferConfigRequest, TransferConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/CreateTransferConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTransferConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TransferConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateTransferConfigRequest, TransferConfig>
      updateTransferConfigMethodDescriptor =
          MethodDescriptor.<UpdateTransferConfigRequest, TransferConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/UpdateTransferConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTransferConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TransferConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTransferConfigRequest, Empty>
      deleteTransferConfigMethodDescriptor =
          MethodDescriptor.<DeleteTransferConfigRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/DeleteTransferConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTransferConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTransferConfigRequest, TransferConfig>
      getTransferConfigMethodDescriptor =
          MethodDescriptor.<GetTransferConfigRequest, TransferConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/GetTransferConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetTransferConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TransferConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListTransferConfigsRequest, ListTransferConfigsResponse>
      listTransferConfigsMethodDescriptor =
          MethodDescriptor.<ListTransferConfigsRequest, ListTransferConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/ListTransferConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTransferConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTransferConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>
      scheduleTransferRunsMethodDescriptor =
          MethodDescriptor.<ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/ScheduleTransferRuns")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ScheduleTransferRunsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ScheduleTransferRunsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          StartManualTransferRunsRequest, StartManualTransferRunsResponse>
      startManualTransferRunsMethodDescriptor =
          MethodDescriptor
              .<StartManualTransferRunsRequest, StartManualTransferRunsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/StartManualTransferRuns")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StartManualTransferRunsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(StartManualTransferRunsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTransferRunRequest, TransferRun>
      getTransferRunMethodDescriptor =
          MethodDescriptor.<GetTransferRunRequest, TransferRun>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/GetTransferRun")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetTransferRunRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TransferRun.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTransferRunRequest, Empty>
      deleteTransferRunMethodDescriptor =
          MethodDescriptor.<DeleteTransferRunRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/DeleteTransferRun")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTransferRunRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListTransferRunsRequest, ListTransferRunsResponse>
      listTransferRunsMethodDescriptor =
          MethodDescriptor.<ListTransferRunsRequest, ListTransferRunsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/ListTransferRuns")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTransferRunsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTransferRunsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListTransferLogsRequest, ListTransferLogsResponse>
      listTransferLogsMethodDescriptor =
          MethodDescriptor.<ListTransferLogsRequest, ListTransferLogsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/ListTransferLogs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTransferLogsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTransferLogsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CheckValidCredsRequest, CheckValidCredsResponse>
      checkValidCredsMethodDescriptor =
          MethodDescriptor.<CheckValidCredsRequest, CheckValidCredsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/CheckValidCreds")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CheckValidCredsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CheckValidCredsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetDataSourceRequest, DataSource> getDataSourceCallable;
  private final UnaryCallable<ListDataSourcesRequest, ListDataSourcesResponse>
      listDataSourcesCallable;
  private final UnaryCallable<ListDataSourcesRequest, ListDataSourcesPagedResponse>
      listDataSourcesPagedCallable;
  private final UnaryCallable<CreateTransferConfigRequest, TransferConfig>
      createTransferConfigCallable;
  private final UnaryCallable<UpdateTransferConfigRequest, TransferConfig>
      updateTransferConfigCallable;
  private final UnaryCallable<DeleteTransferConfigRequest, Empty> deleteTransferConfigCallable;
  private final UnaryCallable<GetTransferConfigRequest, TransferConfig> getTransferConfigCallable;
  private final UnaryCallable<ListTransferConfigsRequest, ListTransferConfigsResponse>
      listTransferConfigsCallable;
  private final UnaryCallable<ListTransferConfigsRequest, ListTransferConfigsPagedResponse>
      listTransferConfigsPagedCallable;
  private final UnaryCallable<ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>
      scheduleTransferRunsCallable;
  private final UnaryCallable<StartManualTransferRunsRequest, StartManualTransferRunsResponse>
      startManualTransferRunsCallable;
  private final UnaryCallable<GetTransferRunRequest, TransferRun> getTransferRunCallable;
  private final UnaryCallable<DeleteTransferRunRequest, Empty> deleteTransferRunCallable;
  private final UnaryCallable<ListTransferRunsRequest, ListTransferRunsResponse>
      listTransferRunsCallable;
  private final UnaryCallable<ListTransferRunsRequest, ListTransferRunsPagedResponse>
      listTransferRunsPagedCallable;
  private final UnaryCallable<ListTransferLogsRequest, ListTransferLogsResponse>
      listTransferLogsCallable;
  private final UnaryCallable<ListTransferLogsRequest, ListTransferLogsPagedResponse>
      listTransferLogsPagedCallable;
  private final UnaryCallable<CheckValidCredsRequest, CheckValidCredsResponse>
      checkValidCredsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDataTransferServiceStub create(DataTransferServiceStubSettings settings)
      throws IOException {
    return new GrpcDataTransferServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataTransferServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataTransferServiceStub(
        DataTransferServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataTransferServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataTransferServiceStub(
        DataTransferServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataTransferServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataTransferServiceStub(
      DataTransferServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDataTransferServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataTransferServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataTransferServiceStub(
      DataTransferServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetDataSourceRequest, DataSource> getDataSourceTransportSettings =
        GrpcCallSettings.<GetDataSourceRequest, DataSource>newBuilder()
            .setMethodDescriptor(getDataSourceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetDataSourceRequest>() {
                  @Override
                  public Map<String, String> extract(GetDataSourceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListDataSourcesRequest, ListDataSourcesResponse>
        listDataSourcesTransportSettings =
            GrpcCallSettings.<ListDataSourcesRequest, ListDataSourcesResponse>newBuilder()
                .setMethodDescriptor(listDataSourcesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListDataSourcesRequest>() {
                      @Override
                      public Map<String, String> extract(ListDataSourcesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CreateTransferConfigRequest, TransferConfig>
        createTransferConfigTransportSettings =
            GrpcCallSettings.<CreateTransferConfigRequest, TransferConfig>newBuilder()
                .setMethodDescriptor(createTransferConfigMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CreateTransferConfigRequest>() {
                      @Override
                      public Map<String, String> extract(CreateTransferConfigRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<UpdateTransferConfigRequest, TransferConfig>
        updateTransferConfigTransportSettings =
            GrpcCallSettings.<UpdateTransferConfigRequest, TransferConfig>newBuilder()
                .setMethodDescriptor(updateTransferConfigMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<UpdateTransferConfigRequest>() {
                      @Override
                      public Map<String, String> extract(UpdateTransferConfigRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put(
                            "transfer_config.name",
                            String.valueOf(request.getTransferConfig().getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeleteTransferConfigRequest, Empty> deleteTransferConfigTransportSettings =
        GrpcCallSettings.<DeleteTransferConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTransferConfigMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteTransferConfigRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteTransferConfigRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetTransferConfigRequest, TransferConfig> getTransferConfigTransportSettings =
        GrpcCallSettings.<GetTransferConfigRequest, TransferConfig>newBuilder()
            .setMethodDescriptor(getTransferConfigMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetTransferConfigRequest>() {
                  @Override
                  public Map<String, String> extract(GetTransferConfigRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListTransferConfigsRequest, ListTransferConfigsResponse>
        listTransferConfigsTransportSettings =
            GrpcCallSettings.<ListTransferConfigsRequest, ListTransferConfigsResponse>newBuilder()
                .setMethodDescriptor(listTransferConfigsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListTransferConfigsRequest>() {
                      @Override
                      public Map<String, String> extract(ListTransferConfigsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>
        scheduleTransferRunsTransportSettings =
            GrpcCallSettings.<ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>newBuilder()
                .setMethodDescriptor(scheduleTransferRunsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ScheduleTransferRunsRequest>() {
                      @Override
                      public Map<String, String> extract(ScheduleTransferRunsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<StartManualTransferRunsRequest, StartManualTransferRunsResponse>
        startManualTransferRunsTransportSettings =
            GrpcCallSettings
                .<StartManualTransferRunsRequest, StartManualTransferRunsResponse>newBuilder()
                .setMethodDescriptor(startManualTransferRunsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<StartManualTransferRunsRequest>() {
                      @Override
                      public Map<String, String> extract(StartManualTransferRunsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetTransferRunRequest, TransferRun> getTransferRunTransportSettings =
        GrpcCallSettings.<GetTransferRunRequest, TransferRun>newBuilder()
            .setMethodDescriptor(getTransferRunMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetTransferRunRequest>() {
                  @Override
                  public Map<String, String> extract(GetTransferRunRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteTransferRunRequest, Empty> deleteTransferRunTransportSettings =
        GrpcCallSettings.<DeleteTransferRunRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTransferRunMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteTransferRunRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteTransferRunRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListTransferRunsRequest, ListTransferRunsResponse>
        listTransferRunsTransportSettings =
            GrpcCallSettings.<ListTransferRunsRequest, ListTransferRunsResponse>newBuilder()
                .setMethodDescriptor(listTransferRunsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListTransferRunsRequest>() {
                      @Override
                      public Map<String, String> extract(ListTransferRunsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ListTransferLogsRequest, ListTransferLogsResponse>
        listTransferLogsTransportSettings =
            GrpcCallSettings.<ListTransferLogsRequest, ListTransferLogsResponse>newBuilder()
                .setMethodDescriptor(listTransferLogsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListTransferLogsRequest>() {
                      @Override
                      public Map<String, String> extract(ListTransferLogsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CheckValidCredsRequest, CheckValidCredsResponse>
        checkValidCredsTransportSettings =
            GrpcCallSettings.<CheckValidCredsRequest, CheckValidCredsResponse>newBuilder()
                .setMethodDescriptor(checkValidCredsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CheckValidCredsRequest>() {
                      @Override
                      public Map<String, String> extract(CheckValidCredsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();

    this.getDataSourceCallable =
        callableFactory.createUnaryCallable(
            getDataSourceTransportSettings, settings.getDataSourceSettings(), clientContext);
    this.listDataSourcesCallable =
        callableFactory.createUnaryCallable(
            listDataSourcesTransportSettings, settings.listDataSourcesSettings(), clientContext);
    this.listDataSourcesPagedCallable =
        callableFactory.createPagedCallable(
            listDataSourcesTransportSettings, settings.listDataSourcesSettings(), clientContext);
    this.createTransferConfigCallable =
        callableFactory.createUnaryCallable(
            createTransferConfigTransportSettings,
            settings.createTransferConfigSettings(),
            clientContext);
    this.updateTransferConfigCallable =
        callableFactory.createUnaryCallable(
            updateTransferConfigTransportSettings,
            settings.updateTransferConfigSettings(),
            clientContext);
    this.deleteTransferConfigCallable =
        callableFactory.createUnaryCallable(
            deleteTransferConfigTransportSettings,
            settings.deleteTransferConfigSettings(),
            clientContext);
    this.getTransferConfigCallable =
        callableFactory.createUnaryCallable(
            getTransferConfigTransportSettings,
            settings.getTransferConfigSettings(),
            clientContext);
    this.listTransferConfigsCallable =
        callableFactory.createUnaryCallable(
            listTransferConfigsTransportSettings,
            settings.listTransferConfigsSettings(),
            clientContext);
    this.listTransferConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listTransferConfigsTransportSettings,
            settings.listTransferConfigsSettings(),
            clientContext);
    this.scheduleTransferRunsCallable =
        callableFactory.createUnaryCallable(
            scheduleTransferRunsTransportSettings,
            settings.scheduleTransferRunsSettings(),
            clientContext);
    this.startManualTransferRunsCallable =
        callableFactory.createUnaryCallable(
            startManualTransferRunsTransportSettings,
            settings.startManualTransferRunsSettings(),
            clientContext);
    this.getTransferRunCallable =
        callableFactory.createUnaryCallable(
            getTransferRunTransportSettings, settings.getTransferRunSettings(), clientContext);
    this.deleteTransferRunCallable =
        callableFactory.createUnaryCallable(
            deleteTransferRunTransportSettings,
            settings.deleteTransferRunSettings(),
            clientContext);
    this.listTransferRunsCallable =
        callableFactory.createUnaryCallable(
            listTransferRunsTransportSettings, settings.listTransferRunsSettings(), clientContext);
    this.listTransferRunsPagedCallable =
        callableFactory.createPagedCallable(
            listTransferRunsTransportSettings, settings.listTransferRunsSettings(), clientContext);
    this.listTransferLogsCallable =
        callableFactory.createUnaryCallable(
            listTransferLogsTransportSettings, settings.listTransferLogsSettings(), clientContext);
    this.listTransferLogsPagedCallable =
        callableFactory.createPagedCallable(
            listTransferLogsTransportSettings, settings.listTransferLogsSettings(), clientContext);
    this.checkValidCredsCallable =
        callableFactory.createUnaryCallable(
            checkValidCredsTransportSettings, settings.checkValidCredsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<GetDataSourceRequest, DataSource> getDataSourceCallable() {
    return getDataSourceCallable;
  }

  public UnaryCallable<ListDataSourcesRequest, ListDataSourcesResponse> listDataSourcesCallable() {
    return listDataSourcesCallable;
  }

  public UnaryCallable<ListDataSourcesRequest, ListDataSourcesPagedResponse>
      listDataSourcesPagedCallable() {
    return listDataSourcesPagedCallable;
  }

  public UnaryCallable<CreateTransferConfigRequest, TransferConfig> createTransferConfigCallable() {
    return createTransferConfigCallable;
  }

  public UnaryCallable<UpdateTransferConfigRequest, TransferConfig> updateTransferConfigCallable() {
    return updateTransferConfigCallable;
  }

  public UnaryCallable<DeleteTransferConfigRequest, Empty> deleteTransferConfigCallable() {
    return deleteTransferConfigCallable;
  }

  public UnaryCallable<GetTransferConfigRequest, TransferConfig> getTransferConfigCallable() {
    return getTransferConfigCallable;
  }

  public UnaryCallable<ListTransferConfigsRequest, ListTransferConfigsResponse>
      listTransferConfigsCallable() {
    return listTransferConfigsCallable;
  }

  public UnaryCallable<ListTransferConfigsRequest, ListTransferConfigsPagedResponse>
      listTransferConfigsPagedCallable() {
    return listTransferConfigsPagedCallable;
  }

  public UnaryCallable<ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>
      scheduleTransferRunsCallable() {
    return scheduleTransferRunsCallable;
  }

  public UnaryCallable<StartManualTransferRunsRequest, StartManualTransferRunsResponse>
      startManualTransferRunsCallable() {
    return startManualTransferRunsCallable;
  }

  public UnaryCallable<GetTransferRunRequest, TransferRun> getTransferRunCallable() {
    return getTransferRunCallable;
  }

  public UnaryCallable<DeleteTransferRunRequest, Empty> deleteTransferRunCallable() {
    return deleteTransferRunCallable;
  }

  public UnaryCallable<ListTransferRunsRequest, ListTransferRunsResponse>
      listTransferRunsCallable() {
    return listTransferRunsCallable;
  }

  public UnaryCallable<ListTransferRunsRequest, ListTransferRunsPagedResponse>
      listTransferRunsPagedCallable() {
    return listTransferRunsPagedCallable;
  }

  public UnaryCallable<ListTransferLogsRequest, ListTransferLogsResponse>
      listTransferLogsCallable() {
    return listTransferLogsCallable;
  }

  public UnaryCallable<ListTransferLogsRequest, ListTransferLogsPagedResponse>
      listTransferLogsPagedCallable() {
    return listTransferLogsPagedCallable;
  }

  public UnaryCallable<CheckValidCredsRequest, CheckValidCredsResponse> checkValidCredsCallable() {
    return checkValidCredsCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
