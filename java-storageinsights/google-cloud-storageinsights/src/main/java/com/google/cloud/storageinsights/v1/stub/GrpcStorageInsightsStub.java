/*
 * Copyright 2022 Google LLC
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

import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListLocationsPagedResponse;
import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListReportConfigsPagedResponse;
import static com.google.cloud.storageinsights.v1.StorageInsightsClient.ListReportDetailsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.storageinsights.v1.CreateReportConfigRequest;
import com.google.cloud.storageinsights.v1.DeleteReportConfigRequest;
import com.google.cloud.storageinsights.v1.GetReportConfigRequest;
import com.google.cloud.storageinsights.v1.GetReportDetailRequest;
import com.google.cloud.storageinsights.v1.ListReportConfigsRequest;
import com.google.cloud.storageinsights.v1.ListReportConfigsResponse;
import com.google.cloud.storageinsights.v1.ListReportDetailsRequest;
import com.google.cloud.storageinsights.v1.ListReportDetailsResponse;
import com.google.cloud.storageinsights.v1.ReportConfig;
import com.google.cloud.storageinsights.v1.ReportDetail;
import com.google.cloud.storageinsights.v1.UpdateReportConfigRequest;
import com.google.common.collect.ImmutableMap;
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
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetReportConfigRequest, ReportConfig> getReportConfigTransportSettings =
        GrpcCallSettings.<GetReportConfigRequest, ReportConfig>newBuilder()
            .setMethodDescriptor(getReportConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateReportConfigRequest, ReportConfig> createReportConfigTransportSettings =
        GrpcCallSettings.<CreateReportConfigRequest, ReportConfig>newBuilder()
            .setMethodDescriptor(createReportConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateReportConfigRequest, ReportConfig> updateReportConfigTransportSettings =
        GrpcCallSettings.<UpdateReportConfigRequest, ReportConfig>newBuilder()
            .setMethodDescriptor(updateReportConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "report_config.name", String.valueOf(request.getReportConfig().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteReportConfigRequest, Empty> deleteReportConfigTransportSettings =
        GrpcCallSettings.<DeleteReportConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteReportConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListReportDetailsRequest, ListReportDetailsResponse>
        listReportDetailsTransportSettings =
            GrpcCallSettings.<ListReportDetailsRequest, ListReportDetailsResponse>newBuilder()
                .setMethodDescriptor(listReportDetailsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetReportDetailRequest, ReportDetail> getReportDetailTransportSettings =
        GrpcCallSettings.<GetReportDetailRequest, ReportDetail>newBuilder()
            .setMethodDescriptor(getReportDetailMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
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
