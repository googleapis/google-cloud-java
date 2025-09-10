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

package com.google.cloud.bigquery.datatransfer.v1.stub;

import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListDataSourcesPagedResponse;
import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListTransferConfigsPagedResponse;
import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListTransferLogsPagedResponse;
import static com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListTransferRunsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsRequest;
import com.google.cloud.bigquery.datatransfer.v1.CheckValidCredsResponse;
import com.google.cloud.bigquery.datatransfer.v1.CreateTransferConfigRequest;
import com.google.cloud.bigquery.datatransfer.v1.DataSource;
import com.google.cloud.bigquery.datatransfer.v1.DeleteTransferConfigRequest;
import com.google.cloud.bigquery.datatransfer.v1.DeleteTransferRunRequest;
import com.google.cloud.bigquery.datatransfer.v1.EnrollDataSourcesRequest;
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
import com.google.cloud.bigquery.datatransfer.v1.UnenrollDataSourcesRequest;
import com.google.cloud.bigquery.datatransfer.v1.UpdateTransferConfigRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
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
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<EnrollDataSourcesRequest, Empty>
      enrollDataSourcesMethodDescriptor =
          MethodDescriptor.<EnrollDataSourcesRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/EnrollDataSources")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(EnrollDataSourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UnenrollDataSourcesRequest, Empty>
      unenrollDataSourcesMethodDescriptor =
          MethodDescriptor.<UnenrollDataSourcesRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.datatransfer.v1.DataTransferService/UnenrollDataSources")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UnenrollDataSourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
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
  private final UnaryCallable<EnrollDataSourcesRequest, Empty> enrollDataSourcesCallable;
  private final UnaryCallable<UnenrollDataSourcesRequest, Empty> unenrollDataSourcesCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

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
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDataSourcesRequest, ListDataSourcesResponse>
        listDataSourcesTransportSettings =
            GrpcCallSettings.<ListDataSourcesRequest, ListDataSourcesResponse>newBuilder()
                .setMethodDescriptor(listDataSourcesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateTransferConfigRequest, TransferConfig>
        createTransferConfigTransportSettings =
            GrpcCallSettings.<CreateTransferConfigRequest, TransferConfig>newBuilder()
                .setMethodDescriptor(createTransferConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateTransferConfigRequest, TransferConfig>
        updateTransferConfigTransportSettings =
            GrpcCallSettings.<UpdateTransferConfigRequest, TransferConfig>newBuilder()
                .setMethodDescriptor(updateTransferConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "transfer_config.name",
                          String.valueOf(request.getTransferConfig().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteTransferConfigRequest, Empty> deleteTransferConfigTransportSettings =
        GrpcCallSettings.<DeleteTransferConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTransferConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetTransferConfigRequest, TransferConfig> getTransferConfigTransportSettings =
        GrpcCallSettings.<GetTransferConfigRequest, TransferConfig>newBuilder()
            .setMethodDescriptor(getTransferConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListTransferConfigsRequest, ListTransferConfigsResponse>
        listTransferConfigsTransportSettings =
            GrpcCallSettings.<ListTransferConfigsRequest, ListTransferConfigsResponse>newBuilder()
                .setMethodDescriptor(listTransferConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>
        scheduleTransferRunsTransportSettings =
            GrpcCallSettings.<ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>newBuilder()
                .setMethodDescriptor(scheduleTransferRunsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<StartManualTransferRunsRequest, StartManualTransferRunsResponse>
        startManualTransferRunsTransportSettings =
            GrpcCallSettings
                .<StartManualTransferRunsRequest, StartManualTransferRunsResponse>newBuilder()
                .setMethodDescriptor(startManualTransferRunsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetTransferRunRequest, TransferRun> getTransferRunTransportSettings =
        GrpcCallSettings.<GetTransferRunRequest, TransferRun>newBuilder()
            .setMethodDescriptor(getTransferRunMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteTransferRunRequest, Empty> deleteTransferRunTransportSettings =
        GrpcCallSettings.<DeleteTransferRunRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTransferRunMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListTransferRunsRequest, ListTransferRunsResponse>
        listTransferRunsTransportSettings =
            GrpcCallSettings.<ListTransferRunsRequest, ListTransferRunsResponse>newBuilder()
                .setMethodDescriptor(listTransferRunsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListTransferLogsRequest, ListTransferLogsResponse>
        listTransferLogsTransportSettings =
            GrpcCallSettings.<ListTransferLogsRequest, ListTransferLogsResponse>newBuilder()
                .setMethodDescriptor(listTransferLogsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CheckValidCredsRequest, CheckValidCredsResponse>
        checkValidCredsTransportSettings =
            GrpcCallSettings.<CheckValidCredsRequest, CheckValidCredsResponse>newBuilder()
                .setMethodDescriptor(checkValidCredsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<EnrollDataSourcesRequest, Empty> enrollDataSourcesTransportSettings =
        GrpcCallSettings.<EnrollDataSourcesRequest, Empty>newBuilder()
            .setMethodDescriptor(enrollDataSourcesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UnenrollDataSourcesRequest, Empty> unenrollDataSourcesTransportSettings =
        GrpcCallSettings.<UnenrollDataSourcesRequest, Empty>newBuilder()
            .setMethodDescriptor(unenrollDataSourcesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
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
    this.enrollDataSourcesCallable =
        callableFactory.createUnaryCallable(
            enrollDataSourcesTransportSettings,
            settings.enrollDataSourcesSettings(),
            clientContext);
    this.unenrollDataSourcesCallable =
        callableFactory.createUnaryCallable(
            unenrollDataSourcesTransportSettings,
            settings.unenrollDataSourcesSettings(),
            clientContext);
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetDataSourceRequest, DataSource> getDataSourceCallable() {
    return getDataSourceCallable;
  }

  @Override
  public UnaryCallable<ListDataSourcesRequest, ListDataSourcesResponse> listDataSourcesCallable() {
    return listDataSourcesCallable;
  }

  @Override
  public UnaryCallable<ListDataSourcesRequest, ListDataSourcesPagedResponse>
      listDataSourcesPagedCallable() {
    return listDataSourcesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateTransferConfigRequest, TransferConfig> createTransferConfigCallable() {
    return createTransferConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateTransferConfigRequest, TransferConfig> updateTransferConfigCallable() {
    return updateTransferConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteTransferConfigRequest, Empty> deleteTransferConfigCallable() {
    return deleteTransferConfigCallable;
  }

  @Override
  public UnaryCallable<GetTransferConfigRequest, TransferConfig> getTransferConfigCallable() {
    return getTransferConfigCallable;
  }

  @Override
  public UnaryCallable<ListTransferConfigsRequest, ListTransferConfigsResponse>
      listTransferConfigsCallable() {
    return listTransferConfigsCallable;
  }

  @Override
  public UnaryCallable<ListTransferConfigsRequest, ListTransferConfigsPagedResponse>
      listTransferConfigsPagedCallable() {
    return listTransferConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<ScheduleTransferRunsRequest, ScheduleTransferRunsResponse>
      scheduleTransferRunsCallable() {
    return scheduleTransferRunsCallable;
  }

  @Override
  public UnaryCallable<StartManualTransferRunsRequest, StartManualTransferRunsResponse>
      startManualTransferRunsCallable() {
    return startManualTransferRunsCallable;
  }

  @Override
  public UnaryCallable<GetTransferRunRequest, TransferRun> getTransferRunCallable() {
    return getTransferRunCallable;
  }

  @Override
  public UnaryCallable<DeleteTransferRunRequest, Empty> deleteTransferRunCallable() {
    return deleteTransferRunCallable;
  }

  @Override
  public UnaryCallable<ListTransferRunsRequest, ListTransferRunsResponse>
      listTransferRunsCallable() {
    return listTransferRunsCallable;
  }

  @Override
  public UnaryCallable<ListTransferRunsRequest, ListTransferRunsPagedResponse>
      listTransferRunsPagedCallable() {
    return listTransferRunsPagedCallable;
  }

  @Override
  public UnaryCallable<ListTransferLogsRequest, ListTransferLogsResponse>
      listTransferLogsCallable() {
    return listTransferLogsCallable;
  }

  @Override
  public UnaryCallable<ListTransferLogsRequest, ListTransferLogsPagedResponse>
      listTransferLogsPagedCallable() {
    return listTransferLogsPagedCallable;
  }

  @Override
  public UnaryCallable<CheckValidCredsRequest, CheckValidCredsResponse> checkValidCredsCallable() {
    return checkValidCredsCallable;
  }

  @Override
  public UnaryCallable<EnrollDataSourcesRequest, Empty> enrollDataSourcesCallable() {
    return enrollDataSourcesCallable;
  }

  @Override
  public UnaryCallable<UnenrollDataSourcesRequest, Empty> unenrollDataSourcesCallable() {
    return unenrollDataSourcesCallable;
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
