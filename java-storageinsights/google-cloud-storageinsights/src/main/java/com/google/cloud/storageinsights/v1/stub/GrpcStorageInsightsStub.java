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

package com.google.cloud.storageinsights.v1.stub;

import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListDatasetConfigsPagedResponse;
import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListLocationsPagedResponse;
import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListReportConfigsPagedResponse;
import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListReportDetailsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.storageinsights.v1.CreateDatasetConfigRequest;
import com.google.cloud.storageinsights.v1.CreateReportConfigRequest;
import com.google.cloud.storageinsights.v1.DatasetConfig;
import com.google.cloud.storageinsights.v1.DeleteDatasetConfigRequest;
import com.google.cloud.storageinsights.v1.DeleteReportConfigRequest;
import com.google.cloud.storageinsights.v1.GetDatasetConfigRequest;
import com.google.cloud.storageinsights.v1.GetReportConfigRequest;
import com.google.cloud.storageinsights.v1.GetReportDetailRequest;
import com.google.cloud.storageinsights.v1.LinkDatasetRequest;
import com.google.cloud.storageinsights.v1.LinkDatasetResponse;
import com.google.cloud.storageinsights.v1.ListDatasetConfigsRequest;
import com.google.cloud.storageinsights.v1.ListDatasetConfigsResponse;
import com.google.cloud.storageinsights.v1.ListReportConfigsRequest;
import com.google.cloud.storageinsights.v1.ListReportConfigsResponse;
import com.google.cloud.storageinsights.v1.ListReportDetailsRequest;
import com.google.cloud.storageinsights.v1.ListReportDetailsResponse;
import com.google.cloud.storageinsights.v1.OperationMetadata;
import com.google.cloud.storageinsights.v1.ReportConfig;
import com.google.cloud.storageinsights.v1.ReportDetail;
import com.google.cloud.storageinsights.v1.UnlinkDatasetRequest;
import com.google.cloud.storageinsights.v1.UpdateDatasetConfigRequest;
import com.google.cloud.storageinsights.v1.UpdateReportConfigRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the StorageInsights service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcStorageInsightsStub extends StorageInsightsStub {
  private static final MethodDescriptor<ListReportConfigsRequest, ListReportConfigsResponse>
      listReportConfigsMethodDescriptor =
          MethodDescriptor.<ListReportConfigsRequest, ListReportConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.storageinsights.v1.StorageInsights/ListReportConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListReportConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListReportConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetReportConfigRequest, ReportConfig>
      getReportConfigMethodDescriptor =
          MethodDescriptor.<GetReportConfigRequest, ReportConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.storageinsights.v1.StorageInsights/GetReportConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetReportConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReportConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateReportConfigRequest, ReportConfig>
      createReportConfigMethodDescriptor =
          MethodDescriptor.<CreateReportConfigRequest, ReportConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.storageinsights.v1.StorageInsights/CreateReportConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateReportConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReportConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateReportConfigRequest, ReportConfig>
      updateReportConfigMethodDescriptor =
          MethodDescriptor.<UpdateReportConfigRequest, ReportConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.storageinsights.v1.StorageInsights/UpdateReportConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateReportConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReportConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteReportConfigRequest, Empty>
      deleteReportConfigMethodDescriptor =
          MethodDescriptor.<DeleteReportConfigRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.storageinsights.v1.StorageInsights/DeleteReportConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteReportConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListReportDetailsRequest, ListReportDetailsResponse>
      listReportDetailsMethodDescriptor =
          MethodDescriptor.<ListReportDetailsRequest, ListReportDetailsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.storageinsights.v1.StorageInsights/ListReportDetails")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListReportDetailsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListReportDetailsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetReportDetailRequest, ReportDetail>
      getReportDetailMethodDescriptor =
          MethodDescriptor.<GetReportDetailRequest, ReportDetail>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.storageinsights.v1.StorageInsights/GetReportDetail")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetReportDetailRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReportDetail.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDatasetConfigsRequest, ListDatasetConfigsResponse>
      listDatasetConfigsMethodDescriptor =
          MethodDescriptor.<ListDatasetConfigsRequest, ListDatasetConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.storageinsights.v1.StorageInsights/ListDatasetConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDatasetConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDatasetConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDatasetConfigRequest, DatasetConfig>
      getDatasetConfigMethodDescriptor =
          MethodDescriptor.<GetDatasetConfigRequest, DatasetConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.storageinsights.v1.StorageInsights/GetDatasetConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDatasetConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DatasetConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDatasetConfigRequest, Operation>
      createDatasetConfigMethodDescriptor =
          MethodDescriptor.<CreateDatasetConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.storageinsights.v1.StorageInsights/CreateDatasetConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDatasetConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDatasetConfigRequest, Operation>
      updateDatasetConfigMethodDescriptor =
          MethodDescriptor.<UpdateDatasetConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.storageinsights.v1.StorageInsights/UpdateDatasetConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDatasetConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDatasetConfigRequest, Operation>
      deleteDatasetConfigMethodDescriptor =
          MethodDescriptor.<DeleteDatasetConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.storageinsights.v1.StorageInsights/DeleteDatasetConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDatasetConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<LinkDatasetRequest, Operation> linkDatasetMethodDescriptor =
      MethodDescriptor.<LinkDatasetRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.storageinsights.v1.StorageInsights/LinkDataset")
          .setRequestMarshaller(ProtoUtils.marshaller(LinkDatasetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UnlinkDatasetRequest, Operation>
      unlinkDatasetMethodDescriptor =
          MethodDescriptor.<UnlinkDatasetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.storageinsights.v1.StorageInsights/UnlinkDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UnlinkDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private final UnaryCallable<ListReportConfigsRequest, ListReportConfigsResponse>
      listReportConfigsCallable;
  private final UnaryCallable<ListReportConfigsRequest, ListReportConfigsPagedResponse>
      listReportConfigsPagedCallable;
  private final UnaryCallable<GetReportConfigRequest, ReportConfig> getReportConfigCallable;
  private final UnaryCallable<CreateReportConfigRequest, ReportConfig> createReportConfigCallable;
  private final UnaryCallable<UpdateReportConfigRequest, ReportConfig> updateReportConfigCallable;
  private final UnaryCallable<DeleteReportConfigRequest, Empty> deleteReportConfigCallable;
  private final UnaryCallable<ListReportDetailsRequest, ListReportDetailsResponse>
      listReportDetailsCallable;
  private final UnaryCallable<ListReportDetailsRequest, ListReportDetailsPagedResponse>
      listReportDetailsPagedCallable;
  private final UnaryCallable<GetReportDetailRequest, ReportDetail> getReportDetailCallable;
  private final UnaryCallable<ListDatasetConfigsRequest, ListDatasetConfigsResponse>
      listDatasetConfigsCallable;
  private final UnaryCallable<ListDatasetConfigsRequest, ListDatasetConfigsPagedResponse>
      listDatasetConfigsPagedCallable;
  private final UnaryCallable<GetDatasetConfigRequest, DatasetConfig> getDatasetConfigCallable;
  private final UnaryCallable<CreateDatasetConfigRequest, Operation> createDatasetConfigCallable;
  private final OperationCallable<CreateDatasetConfigRequest, DatasetConfig, OperationMetadata>
      createDatasetConfigOperationCallable;
  private final UnaryCallable<UpdateDatasetConfigRequest, Operation> updateDatasetConfigCallable;
  private final OperationCallable<UpdateDatasetConfigRequest, DatasetConfig, OperationMetadata>
      updateDatasetConfigOperationCallable;
  private final UnaryCallable<DeleteDatasetConfigRequest, Operation> deleteDatasetConfigCallable;
  private final OperationCallable<DeleteDatasetConfigRequest, Empty, OperationMetadata>
      deleteDatasetConfigOperationCallable;
  private final UnaryCallable<LinkDatasetRequest, Operation> linkDatasetCallable;
  private final OperationCallable<LinkDatasetRequest, LinkDatasetResponse, OperationMetadata>
      linkDatasetOperationCallable;
  private final UnaryCallable<UnlinkDatasetRequest, Operation> unlinkDatasetCallable;
  private final OperationCallable<UnlinkDatasetRequest, Empty, OperationMetadata>
      unlinkDatasetOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcStorageInsightsStub create(StorageInsightsStubSettings settings)
      throws IOException {
    return new GrpcStorageInsightsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcStorageInsightsStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcStorageInsightsStub(
        StorageInsightsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcStorageInsightsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcStorageInsightsStub(
        StorageInsightsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcStorageInsightsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcStorageInsightsStub(
      StorageInsightsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcStorageInsightsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcStorageInsightsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcStorageInsightsStub(
      StorageInsightsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListReportConfigsRequest, ListReportConfigsResponse>
        listReportConfigsTransportSettings =
            GrpcCallSettings.<ListReportConfigsRequest, ListReportConfigsResponse>newBuilder()
                .setMethodDescriptor(listReportConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetReportConfigRequest, ReportConfig> getReportConfigTransportSettings =
        GrpcCallSettings.<GetReportConfigRequest, ReportConfig>newBuilder()
            .setMethodDescriptor(getReportConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateReportConfigRequest, ReportConfig> createReportConfigTransportSettings =
        GrpcCallSettings.<CreateReportConfigRequest, ReportConfig>newBuilder()
            .setMethodDescriptor(createReportConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateReportConfigRequest, ReportConfig> updateReportConfigTransportSettings =
        GrpcCallSettings.<UpdateReportConfigRequest, ReportConfig>newBuilder()
            .setMethodDescriptor(updateReportConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "report_config.name", String.valueOf(request.getReportConfig().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteReportConfigRequest, Empty> deleteReportConfigTransportSettings =
        GrpcCallSettings.<DeleteReportConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteReportConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListReportDetailsRequest, ListReportDetailsResponse>
        listReportDetailsTransportSettings =
            GrpcCallSettings.<ListReportDetailsRequest, ListReportDetailsResponse>newBuilder()
                .setMethodDescriptor(listReportDetailsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetReportDetailRequest, ReportDetail> getReportDetailTransportSettings =
        GrpcCallSettings.<GetReportDetailRequest, ReportDetail>newBuilder()
            .setMethodDescriptor(getReportDetailMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDatasetConfigsRequest, ListDatasetConfigsResponse>
        listDatasetConfigsTransportSettings =
            GrpcCallSettings.<ListDatasetConfigsRequest, ListDatasetConfigsResponse>newBuilder()
                .setMethodDescriptor(listDatasetConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDatasetConfigRequest, DatasetConfig> getDatasetConfigTransportSettings =
        GrpcCallSettings.<GetDatasetConfigRequest, DatasetConfig>newBuilder()
            .setMethodDescriptor(getDatasetConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateDatasetConfigRequest, Operation> createDatasetConfigTransportSettings =
        GrpcCallSettings.<CreateDatasetConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(createDatasetConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDatasetConfigRequest, Operation> updateDatasetConfigTransportSettings =
        GrpcCallSettings.<UpdateDatasetConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDatasetConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "dataset_config.name", String.valueOf(request.getDatasetConfig().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDatasetConfigRequest, Operation> deleteDatasetConfigTransportSettings =
        GrpcCallSettings.<DeleteDatasetConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDatasetConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<LinkDatasetRequest, Operation> linkDatasetTransportSettings =
        GrpcCallSettings.<LinkDatasetRequest, Operation>newBuilder()
            .setMethodDescriptor(linkDatasetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UnlinkDatasetRequest, Operation> unlinkDatasetTransportSettings =
        GrpcCallSettings.<UnlinkDatasetRequest, Operation>newBuilder()
            .setMethodDescriptor(unlinkDatasetMethodDescriptor)
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

    this.listReportConfigsCallable =
        callableFactory.createUnaryCallable(
            listReportConfigsTransportSettings,
            settings.listReportConfigsSettings(),
            clientContext);
    this.listReportConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listReportConfigsTransportSettings,
            settings.listReportConfigsSettings(),
            clientContext);
    this.getReportConfigCallable =
        callableFactory.createUnaryCallable(
            getReportConfigTransportSettings, settings.getReportConfigSettings(), clientContext);
    this.createReportConfigCallable =
        callableFactory.createUnaryCallable(
            createReportConfigTransportSettings,
            settings.createReportConfigSettings(),
            clientContext);
    this.updateReportConfigCallable =
        callableFactory.createUnaryCallable(
            updateReportConfigTransportSettings,
            settings.updateReportConfigSettings(),
            clientContext);
    this.deleteReportConfigCallable =
        callableFactory.createUnaryCallable(
            deleteReportConfigTransportSettings,
            settings.deleteReportConfigSettings(),
            clientContext);
    this.listReportDetailsCallable =
        callableFactory.createUnaryCallable(
            listReportDetailsTransportSettings,
            settings.listReportDetailsSettings(),
            clientContext);
    this.listReportDetailsPagedCallable =
        callableFactory.createPagedCallable(
            listReportDetailsTransportSettings,
            settings.listReportDetailsSettings(),
            clientContext);
    this.getReportDetailCallable =
        callableFactory.createUnaryCallable(
            getReportDetailTransportSettings, settings.getReportDetailSettings(), clientContext);
    this.listDatasetConfigsCallable =
        callableFactory.createUnaryCallable(
            listDatasetConfigsTransportSettings,
            settings.listDatasetConfigsSettings(),
            clientContext);
    this.listDatasetConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listDatasetConfigsTransportSettings,
            settings.listDatasetConfigsSettings(),
            clientContext);
    this.getDatasetConfigCallable =
        callableFactory.createUnaryCallable(
            getDatasetConfigTransportSettings, settings.getDatasetConfigSettings(), clientContext);
    this.createDatasetConfigCallable =
        callableFactory.createUnaryCallable(
            createDatasetConfigTransportSettings,
            settings.createDatasetConfigSettings(),
            clientContext);
    this.createDatasetConfigOperationCallable =
        callableFactory.createOperationCallable(
            createDatasetConfigTransportSettings,
            settings.createDatasetConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.updateDatasetConfigCallable =
        callableFactory.createUnaryCallable(
            updateDatasetConfigTransportSettings,
            settings.updateDatasetConfigSettings(),
            clientContext);
    this.updateDatasetConfigOperationCallable =
        callableFactory.createOperationCallable(
            updateDatasetConfigTransportSettings,
            settings.updateDatasetConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteDatasetConfigCallable =
        callableFactory.createUnaryCallable(
            deleteDatasetConfigTransportSettings,
            settings.deleteDatasetConfigSettings(),
            clientContext);
    this.deleteDatasetConfigOperationCallable =
        callableFactory.createOperationCallable(
            deleteDatasetConfigTransportSettings,
            settings.deleteDatasetConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.linkDatasetCallable =
        callableFactory.createUnaryCallable(
            linkDatasetTransportSettings, settings.linkDatasetSettings(), clientContext);
    this.linkDatasetOperationCallable =
        callableFactory.createOperationCallable(
            linkDatasetTransportSettings,
            settings.linkDatasetOperationSettings(),
            clientContext,
            operationsStub);
    this.unlinkDatasetCallable =
        callableFactory.createUnaryCallable(
            unlinkDatasetTransportSettings, settings.unlinkDatasetSettings(), clientContext);
    this.unlinkDatasetOperationCallable =
        callableFactory.createOperationCallable(
            unlinkDatasetTransportSettings,
            settings.unlinkDatasetOperationSettings(),
            clientContext,
            operationsStub);
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
  public UnaryCallable<ListReportConfigsRequest, ListReportConfigsResponse>
      listReportConfigsCallable() {
    return listReportConfigsCallable;
  }

  @Override
  public UnaryCallable<ListReportConfigsRequest, ListReportConfigsPagedResponse>
      listReportConfigsPagedCallable() {
    return listReportConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<GetReportConfigRequest, ReportConfig> getReportConfigCallable() {
    return getReportConfigCallable;
  }

  @Override
  public UnaryCallable<CreateReportConfigRequest, ReportConfig> createReportConfigCallable() {
    return createReportConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateReportConfigRequest, ReportConfig> updateReportConfigCallable() {
    return updateReportConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteReportConfigRequest, Empty> deleteReportConfigCallable() {
    return deleteReportConfigCallable;
  }

  @Override
  public UnaryCallable<ListReportDetailsRequest, ListReportDetailsResponse>
      listReportDetailsCallable() {
    return listReportDetailsCallable;
  }

  @Override
  public UnaryCallable<ListReportDetailsRequest, ListReportDetailsPagedResponse>
      listReportDetailsPagedCallable() {
    return listReportDetailsPagedCallable;
  }

  @Override
  public UnaryCallable<GetReportDetailRequest, ReportDetail> getReportDetailCallable() {
    return getReportDetailCallable;
  }

  @Override
  public UnaryCallable<ListDatasetConfigsRequest, ListDatasetConfigsResponse>
      listDatasetConfigsCallable() {
    return listDatasetConfigsCallable;
  }

  @Override
  public UnaryCallable<ListDatasetConfigsRequest, ListDatasetConfigsPagedResponse>
      listDatasetConfigsPagedCallable() {
    return listDatasetConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDatasetConfigRequest, DatasetConfig> getDatasetConfigCallable() {
    return getDatasetConfigCallable;
  }

  @Override
  public UnaryCallable<CreateDatasetConfigRequest, Operation> createDatasetConfigCallable() {
    return createDatasetConfigCallable;
  }

  @Override
  public OperationCallable<CreateDatasetConfigRequest, DatasetConfig, OperationMetadata>
      createDatasetConfigOperationCallable() {
    return createDatasetConfigOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDatasetConfigRequest, Operation> updateDatasetConfigCallable() {
    return updateDatasetConfigCallable;
  }

  @Override
  public OperationCallable<UpdateDatasetConfigRequest, DatasetConfig, OperationMetadata>
      updateDatasetConfigOperationCallable() {
    return updateDatasetConfigOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDatasetConfigRequest, Operation> deleteDatasetConfigCallable() {
    return deleteDatasetConfigCallable;
  }

  @Override
  public OperationCallable<DeleteDatasetConfigRequest, Empty, OperationMetadata>
      deleteDatasetConfigOperationCallable() {
    return deleteDatasetConfigOperationCallable;
  }

  @Override
  public UnaryCallable<LinkDatasetRequest, Operation> linkDatasetCallable() {
    return linkDatasetCallable;
  }

  @Override
  public OperationCallable<LinkDatasetRequest, LinkDatasetResponse, OperationMetadata>
      linkDatasetOperationCallable() {
    return linkDatasetOperationCallable;
  }

  @Override
  public UnaryCallable<UnlinkDatasetRequest, Operation> unlinkDatasetCallable() {
    return unlinkDatasetCallable;
  }

  @Override
  public OperationCallable<UnlinkDatasetRequest, Empty, OperationMetadata>
      unlinkDatasetOperationCallable() {
    return unlinkDatasetOperationCallable;
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
