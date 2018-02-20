/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
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

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.ClientContext;
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
import com.google.cloud.bigquery.datatransfer.v1.TransferConfig;
import com.google.cloud.bigquery.datatransfer.v1.TransferRun;
import com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for BigQuery Data Transfer API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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

  private final BackgroundResource backgroundResources;

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

  public static final GrpcDataTransferServiceStub create(DataTransferServiceStubSettings settings)
      throws IOException {
    return new GrpcDataTransferServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataTransferServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataTransferServiceStub(
        DataTransferServiceStubSettings.newBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcDataTransferServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataTransferServiceStub(
      DataTransferServiceStubSettings settings, ClientContext clientContext) throws IOException {

    GrpcCallSettings<GetDataSourceRequest, DataSource> getDataSourceTransportSettings =
        GrpcCallSettings.<GetDataSourceRequest, DataSource>newBuilder()
            .setMethodDescriptor(getDataSourceMethodDescriptor)
            .build();
    GrpcCallSettings<ListDataSourcesRequest, ListDataSourcesResponse>
        listDataSourcesTransportSettings =
            GrpcCallSettings.<ListDataSourcesRequest, ListDataSourcesResponse>newBuilder()
                .setMethodDescriptor(listDataSourcesMethodDescriptor)
                .build();
    GrpcCallSettings<CreateTransferConfigRequest, TransferConfig>
        createTransferConfigTransportSettings =
            GrpcCallSettings.<CreateTransferConfigRequest, TransferConfig>newBuilder()
                .setMethodDescriptor(createTransferConfigMethodDescriptor)
                .build();
    GrpcCallSettings<UpdateTransferConfigRequest, TransferConfig>
        updateTransferConfigTransportSettings =
            GrpcCallSettings.<UpdateTransferConfigRequest, TransferConfig>newBuilder()
                .setMethodDescriptor(updateTransferConfigMethodDescriptor)
                .build();
    GrpcCallSettings<DeleteTransferConfigRequest, Empty> deleteTransferConfigTransportSettings =
        GrpcCallSettings.<DeleteTransferConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTransferConfigMethodDescriptor)
            .build();
    GrpcCallSettings<GetTransferConfigRequest, TransferConfig> getTransferConfigTransportSettings =
        GrpcCallSettings.<GetTransferConfigRequest, TransferConfig>newBuilder()
            .setMethodDescriptor(getTransferConfigMethodDescriptor)
            .build();
    GrpcCallSettings<ListTransferConfigsRequest, ListTransferConfigsResponse>
        listTransferConfigsTransportSettings =
            GrpcCallSettings.<ListTransferConfigsRequest, ListTransferConfigsResponse>newBuilder()
                .setMethodDescriptor(listTransferConfigsMethodDescriptor)
                .build();
    GrpcCallSettings<ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>
        scheduleTransferRunsTransportSettings =
            GrpcCallSettings.<ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>newBuilder()
                .setMethodDescriptor(scheduleTransferRunsMethodDescriptor)
                .build();
    GrpcCallSettings<GetTransferRunRequest, TransferRun> getTransferRunTransportSettings =
        GrpcCallSettings.<GetTransferRunRequest, TransferRun>newBuilder()
            .setMethodDescriptor(getTransferRunMethodDescriptor)
            .build();
    GrpcCallSettings<DeleteTransferRunRequest, Empty> deleteTransferRunTransportSettings =
        GrpcCallSettings.<DeleteTransferRunRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTransferRunMethodDescriptor)
            .build();
    GrpcCallSettings<ListTransferRunsRequest, ListTransferRunsResponse>
        listTransferRunsTransportSettings =
            GrpcCallSettings.<ListTransferRunsRequest, ListTransferRunsResponse>newBuilder()
                .setMethodDescriptor(listTransferRunsMethodDescriptor)
                .build();
    GrpcCallSettings<ListTransferLogsRequest, ListTransferLogsResponse>
        listTransferLogsTransportSettings =
            GrpcCallSettings.<ListTransferLogsRequest, ListTransferLogsResponse>newBuilder()
                .setMethodDescriptor(listTransferLogsMethodDescriptor)
                .build();
    GrpcCallSettings<CheckValidCredsRequest, CheckValidCredsResponse>
        checkValidCredsTransportSettings =
            GrpcCallSettings.<CheckValidCredsRequest, CheckValidCredsResponse>newBuilder()
                .setMethodDescriptor(checkValidCredsMethodDescriptor)
                .build();

    this.getDataSourceCallable =
        GrpcCallableFactory.createUnaryCallable(
            getDataSourceTransportSettings, settings.getDataSourceSettings(), clientContext);
    this.listDataSourcesCallable =
        GrpcCallableFactory.createUnaryCallable(
            listDataSourcesTransportSettings, settings.listDataSourcesSettings(), clientContext);
    this.listDataSourcesPagedCallable =
        GrpcCallableFactory.createPagedCallable(
            listDataSourcesTransportSettings, settings.listDataSourcesSettings(), clientContext);
    this.createTransferConfigCallable =
        GrpcCallableFactory.createUnaryCallable(
            createTransferConfigTransportSettings,
            settings.createTransferConfigSettings(),
            clientContext);
    this.updateTransferConfigCallable =
        GrpcCallableFactory.createUnaryCallable(
            updateTransferConfigTransportSettings,
            settings.updateTransferConfigSettings(),
            clientContext);
    this.deleteTransferConfigCallable =
        GrpcCallableFactory.createUnaryCallable(
            deleteTransferConfigTransportSettings,
            settings.deleteTransferConfigSettings(),
            clientContext);
    this.getTransferConfigCallable =
        GrpcCallableFactory.createUnaryCallable(
            getTransferConfigTransportSettings,
            settings.getTransferConfigSettings(),
            clientContext);
    this.listTransferConfigsCallable =
        GrpcCallableFactory.createUnaryCallable(
            listTransferConfigsTransportSettings,
            settings.listTransferConfigsSettings(),
            clientContext);
    this.listTransferConfigsPagedCallable =
        GrpcCallableFactory.createPagedCallable(
            listTransferConfigsTransportSettings,
            settings.listTransferConfigsSettings(),
            clientContext);
    this.scheduleTransferRunsCallable =
        GrpcCallableFactory.createUnaryCallable(
            scheduleTransferRunsTransportSettings,
            settings.scheduleTransferRunsSettings(),
            clientContext);
    this.getTransferRunCallable =
        GrpcCallableFactory.createUnaryCallable(
            getTransferRunTransportSettings, settings.getTransferRunSettings(), clientContext);
    this.deleteTransferRunCallable =
        GrpcCallableFactory.createUnaryCallable(
            deleteTransferRunTransportSettings,
            settings.deleteTransferRunSettings(),
            clientContext);
    this.listTransferRunsCallable =
        GrpcCallableFactory.createUnaryCallable(
            listTransferRunsTransportSettings, settings.listTransferRunsSettings(), clientContext);
    this.listTransferRunsPagedCallable =
        GrpcCallableFactory.createPagedCallable(
            listTransferRunsTransportSettings, settings.listTransferRunsSettings(), clientContext);
    this.listTransferLogsCallable =
        GrpcCallableFactory.createUnaryCallable(
            listTransferLogsTransportSettings, settings.listTransferLogsSettings(), clientContext);
    this.listTransferLogsPagedCallable =
        GrpcCallableFactory.createPagedCallable(
            listTransferLogsTransportSettings, settings.listTransferLogsSettings(), clientContext);
    this.checkValidCredsCallable =
        GrpcCallableFactory.createUnaryCallable(
            checkValidCredsTransportSettings, settings.checkValidCredsSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<GetDataSourceRequest, DataSource> getDataSourceCallable() {
    return getDataSourceCallable;
  }

  public UnaryCallable<ListDataSourcesRequest, ListDataSourcesPagedResponse>
      listDataSourcesPagedCallable() {
    return listDataSourcesPagedCallable;
  }

  public UnaryCallable<ListDataSourcesRequest, ListDataSourcesResponse> listDataSourcesCallable() {
    return listDataSourcesCallable;
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

  public UnaryCallable<ListTransferConfigsRequest, ListTransferConfigsPagedResponse>
      listTransferConfigsPagedCallable() {
    return listTransferConfigsPagedCallable;
  }

  public UnaryCallable<ListTransferConfigsRequest, ListTransferConfigsResponse>
      listTransferConfigsCallable() {
    return listTransferConfigsCallable;
  }

  public UnaryCallable<ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>
      scheduleTransferRunsCallable() {
    return scheduleTransferRunsCallable;
  }

  public UnaryCallable<GetTransferRunRequest, TransferRun> getTransferRunCallable() {
    return getTransferRunCallable;
  }

  public UnaryCallable<DeleteTransferRunRequest, Empty> deleteTransferRunCallable() {
    return deleteTransferRunCallable;
  }

  public UnaryCallable<ListTransferRunsRequest, ListTransferRunsPagedResponse>
      listTransferRunsPagedCallable() {
    return listTransferRunsPagedCallable;
  }

  public UnaryCallable<ListTransferRunsRequest, ListTransferRunsResponse>
      listTransferRunsCallable() {
    return listTransferRunsCallable;
  }

  public UnaryCallable<ListTransferLogsRequest, ListTransferLogsPagedResponse>
      listTransferLogsPagedCallable() {
    return listTransferLogsPagedCallable;
  }

  public UnaryCallable<ListTransferLogsRequest, ListTransferLogsResponse>
      listTransferLogsCallable() {
    return listTransferLogsCallable;
  }

  public UnaryCallable<CheckValidCredsRequest, CheckValidCredsResponse> checkValidCredsCallable() {
    return checkValidCredsCallable;
  }

  @Override
  public final void close() throws Exception {
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
