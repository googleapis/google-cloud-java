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

package com.google.cloud.cloudsecuritycompliance.v1.stub;

import static com.google.cloud.cloudsecuritycompliance.v1.MonitoringClient.ListControlComplianceSummariesPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.MonitoringClient.ListFindingSummariesPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.MonitoringClient.ListFrameworkComplianceSummariesPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.MonitoringClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.cloudsecuritycompliance.v1.AggregateFrameworkComplianceReportRequest;
import com.google.cloud.cloudsecuritycompliance.v1.AggregateFrameworkComplianceReportResponse;
import com.google.cloud.cloudsecuritycompliance.v1.FetchFrameworkComplianceReportRequest;
import com.google.cloud.cloudsecuritycompliance.v1.FrameworkComplianceReport;
import com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesResponse;
import com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesResponse;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Monitoring service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcMonitoringStub extends MonitoringStub {
  private static final MethodDescriptor<
          ListFrameworkComplianceSummariesRequest, ListFrameworkComplianceSummariesResponse>
      listFrameworkComplianceSummariesMethodDescriptor =
          MethodDescriptor
              .<ListFrameworkComplianceSummariesRequest, ListFrameworkComplianceSummariesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Monitoring/ListFrameworkComplianceSummaries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListFrameworkComplianceSummariesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListFrameworkComplianceSummariesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListFindingSummariesRequest, ListFindingSummariesResponse>
      listFindingSummariesMethodDescriptor =
          MethodDescriptor.<ListFindingSummariesRequest, ListFindingSummariesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Monitoring/ListFindingSummaries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListFindingSummariesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFindingSummariesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          FetchFrameworkComplianceReportRequest, FrameworkComplianceReport>
      fetchFrameworkComplianceReportMethodDescriptor =
          MethodDescriptor
              .<FetchFrameworkComplianceReportRequest, FrameworkComplianceReport>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Monitoring/FetchFrameworkComplianceReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchFrameworkComplianceReportRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FrameworkComplianceReport.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListControlComplianceSummariesRequest, ListControlComplianceSummariesResponse>
      listControlComplianceSummariesMethodDescriptor =
          MethodDescriptor
              .<ListControlComplianceSummariesRequest, ListControlComplianceSummariesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Monitoring/ListControlComplianceSummaries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListControlComplianceSummariesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListControlComplianceSummariesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          AggregateFrameworkComplianceReportRequest, AggregateFrameworkComplianceReportResponse>
      aggregateFrameworkComplianceReportMethodDescriptor =
          MethodDescriptor
              .<AggregateFrameworkComplianceReportRequest,
                  AggregateFrameworkComplianceReportResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Monitoring/AggregateFrameworkComplianceReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      AggregateFrameworkComplianceReportRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      AggregateFrameworkComplianceReportResponse.getDefaultInstance()))
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

  private final UnaryCallable<
          ListFrameworkComplianceSummariesRequest, ListFrameworkComplianceSummariesResponse>
      listFrameworkComplianceSummariesCallable;
  private final UnaryCallable<
          ListFrameworkComplianceSummariesRequest, ListFrameworkComplianceSummariesPagedResponse>
      listFrameworkComplianceSummariesPagedCallable;
  private final UnaryCallable<ListFindingSummariesRequest, ListFindingSummariesResponse>
      listFindingSummariesCallable;
  private final UnaryCallable<ListFindingSummariesRequest, ListFindingSummariesPagedResponse>
      listFindingSummariesPagedCallable;
  private final UnaryCallable<FetchFrameworkComplianceReportRequest, FrameworkComplianceReport>
      fetchFrameworkComplianceReportCallable;
  private final UnaryCallable<
          ListControlComplianceSummariesRequest, ListControlComplianceSummariesResponse>
      listControlComplianceSummariesCallable;
  private final UnaryCallable<
          ListControlComplianceSummariesRequest, ListControlComplianceSummariesPagedResponse>
      listControlComplianceSummariesPagedCallable;
  private final UnaryCallable<
          AggregateFrameworkComplianceReportRequest, AggregateFrameworkComplianceReportResponse>
      aggregateFrameworkComplianceReportCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcMonitoringStub create(MonitoringStubSettings settings)
      throws IOException {
    return new GrpcMonitoringStub(settings, ClientContext.create(settings));
  }

  public static final GrpcMonitoringStub create(ClientContext clientContext) throws IOException {
    return new GrpcMonitoringStub(MonitoringStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMonitoringStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMonitoringStub(
        MonitoringStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcMonitoringStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMonitoringStub(MonitoringStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcMonitoringCallableFactory());
  }

  /**
   * Constructs an instance of GrpcMonitoringStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMonitoringStub(
      MonitoringStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<
            ListFrameworkComplianceSummariesRequest, ListFrameworkComplianceSummariesResponse>
        listFrameworkComplianceSummariesTransportSettings =
            GrpcCallSettings
                .<ListFrameworkComplianceSummariesRequest, ListFrameworkComplianceSummariesResponse>
                    newBuilder()
                .setMethodDescriptor(listFrameworkComplianceSummariesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListFindingSummariesRequest, ListFindingSummariesResponse>
        listFindingSummariesTransportSettings =
            GrpcCallSettings.<ListFindingSummariesRequest, ListFindingSummariesResponse>newBuilder()
                .setMethodDescriptor(listFindingSummariesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<FetchFrameworkComplianceReportRequest, FrameworkComplianceReport>
        fetchFrameworkComplianceReportTransportSettings =
            GrpcCallSettings
                .<FetchFrameworkComplianceReportRequest, FrameworkComplianceReport>newBuilder()
                .setMethodDescriptor(fetchFrameworkComplianceReportMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListControlComplianceSummariesRequest, ListControlComplianceSummariesResponse>
        listControlComplianceSummariesTransportSettings =
            GrpcCallSettings
                .<ListControlComplianceSummariesRequest, ListControlComplianceSummariesResponse>
                    newBuilder()
                .setMethodDescriptor(listControlComplianceSummariesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            AggregateFrameworkComplianceReportRequest, AggregateFrameworkComplianceReportResponse>
        aggregateFrameworkComplianceReportTransportSettings =
            GrpcCallSettings
                .<AggregateFrameworkComplianceReportRequest,
                    AggregateFrameworkComplianceReportResponse>
                    newBuilder()
                .setMethodDescriptor(aggregateFrameworkComplianceReportMethodDescriptor)
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

    this.listFrameworkComplianceSummariesCallable =
        callableFactory.createUnaryCallable(
            listFrameworkComplianceSummariesTransportSettings,
            settings.listFrameworkComplianceSummariesSettings(),
            clientContext);
    this.listFrameworkComplianceSummariesPagedCallable =
        callableFactory.createPagedCallable(
            listFrameworkComplianceSummariesTransportSettings,
            settings.listFrameworkComplianceSummariesSettings(),
            clientContext);
    this.listFindingSummariesCallable =
        callableFactory.createUnaryCallable(
            listFindingSummariesTransportSettings,
            settings.listFindingSummariesSettings(),
            clientContext);
    this.listFindingSummariesPagedCallable =
        callableFactory.createPagedCallable(
            listFindingSummariesTransportSettings,
            settings.listFindingSummariesSettings(),
            clientContext);
    this.fetchFrameworkComplianceReportCallable =
        callableFactory.createUnaryCallable(
            fetchFrameworkComplianceReportTransportSettings,
            settings.fetchFrameworkComplianceReportSettings(),
            clientContext);
    this.listControlComplianceSummariesCallable =
        callableFactory.createUnaryCallable(
            listControlComplianceSummariesTransportSettings,
            settings.listControlComplianceSummariesSettings(),
            clientContext);
    this.listControlComplianceSummariesPagedCallable =
        callableFactory.createPagedCallable(
            listControlComplianceSummariesTransportSettings,
            settings.listControlComplianceSummariesSettings(),
            clientContext);
    this.aggregateFrameworkComplianceReportCallable =
        callableFactory.createUnaryCallable(
            aggregateFrameworkComplianceReportTransportSettings,
            settings.aggregateFrameworkComplianceReportSettings(),
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
  public UnaryCallable<
          ListFrameworkComplianceSummariesRequest, ListFrameworkComplianceSummariesResponse>
      listFrameworkComplianceSummariesCallable() {
    return listFrameworkComplianceSummariesCallable;
  }

  @Override
  public UnaryCallable<
          ListFrameworkComplianceSummariesRequest, ListFrameworkComplianceSummariesPagedResponse>
      listFrameworkComplianceSummariesPagedCallable() {
    return listFrameworkComplianceSummariesPagedCallable;
  }

  @Override
  public UnaryCallable<ListFindingSummariesRequest, ListFindingSummariesResponse>
      listFindingSummariesCallable() {
    return listFindingSummariesCallable;
  }

  @Override
  public UnaryCallable<ListFindingSummariesRequest, ListFindingSummariesPagedResponse>
      listFindingSummariesPagedCallable() {
    return listFindingSummariesPagedCallable;
  }

  @Override
  public UnaryCallable<FetchFrameworkComplianceReportRequest, FrameworkComplianceReport>
      fetchFrameworkComplianceReportCallable() {
    return fetchFrameworkComplianceReportCallable;
  }

  @Override
  public UnaryCallable<
          ListControlComplianceSummariesRequest, ListControlComplianceSummariesResponse>
      listControlComplianceSummariesCallable() {
    return listControlComplianceSummariesCallable;
  }

  @Override
  public UnaryCallable<
          ListControlComplianceSummariesRequest, ListControlComplianceSummariesPagedResponse>
      listControlComplianceSummariesPagedCallable() {
    return listControlComplianceSummariesPagedCallable;
  }

  @Override
  public UnaryCallable<
          AggregateFrameworkComplianceReportRequest, AggregateFrameworkComplianceReportResponse>
      aggregateFrameworkComplianceReportCallable() {
    return aggregateFrameworkComplianceReportCallable;
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
