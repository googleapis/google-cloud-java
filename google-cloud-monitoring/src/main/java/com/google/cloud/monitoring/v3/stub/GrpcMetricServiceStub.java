/*
 * Copyright 2017, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.monitoring.v3.stub;

import static com.google.cloud.monitoring.v3.PagedResponseWrappers.ListMetricDescriptorsPagedResponse;
import static com.google.cloud.monitoring.v3.PagedResponseWrappers.ListMonitoredResourceDescriptorsPagedResponse;
import static com.google.cloud.monitoring.v3.PagedResponseWrappers.ListTimeSeriesPagedResponse;

import com.google.api.MetricDescriptor;
import com.google.api.MonitoredResourceDescriptor;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.monitoring.v3.MetricServiceSettings;
import com.google.monitoring.v3.CreateMetricDescriptorRequest;
import com.google.monitoring.v3.CreateTimeSeriesRequest;
import com.google.monitoring.v3.DeleteMetricDescriptorRequest;
import com.google.monitoring.v3.GetMetricDescriptorRequest;
import com.google.monitoring.v3.GetMonitoredResourceDescriptorRequest;
import com.google.monitoring.v3.ListMetricDescriptorsRequest;
import com.google.monitoring.v3.ListMetricDescriptorsResponse;
import com.google.monitoring.v3.ListMonitoredResourceDescriptorsRequest;
import com.google.monitoring.v3.ListMonitoredResourceDescriptorsResponse;
import com.google.monitoring.v3.ListTimeSeriesRequest;
import com.google.monitoring.v3.ListTimeSeriesResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Stackdriver Monitoring API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class GrpcMetricServiceStub extends MetricServiceStub {
  private static final UnaryCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
      directListMonitoredResourceDescriptorsCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.monitoring.v3.MetricService/ListMonitoredResourceDescriptors",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListMonitoredResourceDescriptorsRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListMonitoredResourceDescriptorsResponse.getDefaultInstance())));
  private static final UnaryCallable<
          GetMonitoredResourceDescriptorRequest, MonitoredResourceDescriptor>
      directGetMonitoredResourceDescriptorCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.monitoring.v3.MetricService/GetMonitoredResourceDescriptor",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      GetMonitoredResourceDescriptorRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      MonitoredResourceDescriptor.getDefaultInstance())));
  private static final UnaryCallable<ListMetricDescriptorsRequest, ListMetricDescriptorsResponse>
      directListMetricDescriptorsCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.monitoring.v3.MetricService/ListMetricDescriptors",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListMetricDescriptorsRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListMetricDescriptorsResponse.getDefaultInstance())));
  private static final UnaryCallable<GetMetricDescriptorRequest, MetricDescriptor>
      directGetMetricDescriptorCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.monitoring.v3.MetricService/GetMetricDescriptor",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      GetMetricDescriptorRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(MetricDescriptor.getDefaultInstance())));
  private static final UnaryCallable<CreateMetricDescriptorRequest, MetricDescriptor>
      directCreateMetricDescriptorCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.monitoring.v3.MetricService/CreateMetricDescriptor",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      CreateMetricDescriptorRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(MetricDescriptor.getDefaultInstance())));
  private static final UnaryCallable<DeleteMetricDescriptorRequest, Empty>
      directDeleteMetricDescriptorCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.monitoring.v3.MetricService/DeleteMetricDescriptor",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      DeleteMetricDescriptorRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(Empty.getDefaultInstance())));
  private static final UnaryCallable<ListTimeSeriesRequest, ListTimeSeriesResponse>
      directListTimeSeriesCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.monitoring.v3.MetricService/ListTimeSeries",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListTimeSeriesRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListTimeSeriesResponse.getDefaultInstance())));
  private static final UnaryCallable<CreateTimeSeriesRequest, Empty>
      directCreateTimeSeriesCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.monitoring.v3.MetricService/CreateTimeSeries",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      CreateTimeSeriesRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(Empty.getDefaultInstance())));

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
      listMonitoredResourceDescriptorsCallable;
  private final UnaryCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsPagedResponse>
      listMonitoredResourceDescriptorsPagedCallable;
  private final UnaryCallable<GetMonitoredResourceDescriptorRequest, MonitoredResourceDescriptor>
      getMonitoredResourceDescriptorCallable;
  private final UnaryCallable<ListMetricDescriptorsRequest, ListMetricDescriptorsResponse>
      listMetricDescriptorsCallable;
  private final UnaryCallable<ListMetricDescriptorsRequest, ListMetricDescriptorsPagedResponse>
      listMetricDescriptorsPagedCallable;
  private final UnaryCallable<GetMetricDescriptorRequest, MetricDescriptor>
      getMetricDescriptorCallable;
  private final UnaryCallable<CreateMetricDescriptorRequest, MetricDescriptor>
      createMetricDescriptorCallable;
  private final UnaryCallable<DeleteMetricDescriptorRequest, Empty> deleteMetricDescriptorCallable;
  private final UnaryCallable<ListTimeSeriesRequest, ListTimeSeriesResponse> listTimeSeriesCallable;
  private final UnaryCallable<ListTimeSeriesRequest, ListTimeSeriesPagedResponse>
      listTimeSeriesPagedCallable;
  private final UnaryCallable<CreateTimeSeriesRequest, Empty> createTimeSeriesCallable;

  public static final GrpcMetricServiceStub create(MetricServiceSettings settings)
      throws IOException {
    return new GrpcMetricServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcMetricServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcMetricServiceStub(MetricServiceSettings.defaultBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcMetricServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMetricServiceStub(MetricServiceSettings settings, ClientContext clientContext)
      throws IOException {

    this.listMonitoredResourceDescriptorsCallable =
        GrpcCallableFactory.create(
            directListMonitoredResourceDescriptorsCallable,
            settings.listMonitoredResourceDescriptorsSettings(),
            clientContext);
    this.listMonitoredResourceDescriptorsPagedCallable =
        GrpcCallableFactory.createPagedVariant(
            directListMonitoredResourceDescriptorsCallable,
            settings.listMonitoredResourceDescriptorsSettings(),
            clientContext);
    this.getMonitoredResourceDescriptorCallable =
        GrpcCallableFactory.create(
            directGetMonitoredResourceDescriptorCallable,
            settings.getMonitoredResourceDescriptorSettings(),
            clientContext);
    this.listMetricDescriptorsCallable =
        GrpcCallableFactory.create(
            directListMetricDescriptorsCallable,
            settings.listMetricDescriptorsSettings(),
            clientContext);
    this.listMetricDescriptorsPagedCallable =
        GrpcCallableFactory.createPagedVariant(
            directListMetricDescriptorsCallable,
            settings.listMetricDescriptorsSettings(),
            clientContext);
    this.getMetricDescriptorCallable =
        GrpcCallableFactory.create(
            directGetMetricDescriptorCallable,
            settings.getMetricDescriptorSettings(),
            clientContext);
    this.createMetricDescriptorCallable =
        GrpcCallableFactory.create(
            directCreateMetricDescriptorCallable,
            settings.createMetricDescriptorSettings(),
            clientContext);
    this.deleteMetricDescriptorCallable =
        GrpcCallableFactory.create(
            directDeleteMetricDescriptorCallable,
            settings.deleteMetricDescriptorSettings(),
            clientContext);
    this.listTimeSeriesCallable =
        GrpcCallableFactory.create(
            directListTimeSeriesCallable, settings.listTimeSeriesSettings(), clientContext);
    this.listTimeSeriesPagedCallable =
        GrpcCallableFactory.createPagedVariant(
            directListTimeSeriesCallable, settings.listTimeSeriesSettings(), clientContext);
    this.createTimeSeriesCallable =
        GrpcCallableFactory.create(
            directCreateTimeSeriesCallable, settings.createTimeSeriesSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsPagedResponse>
      listMonitoredResourceDescriptorsPagedCallable() {
    return listMonitoredResourceDescriptorsPagedCallable;
  }

  public UnaryCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
      listMonitoredResourceDescriptorsCallable() {
    return listMonitoredResourceDescriptorsCallable;
  }

  public UnaryCallable<GetMonitoredResourceDescriptorRequest, MonitoredResourceDescriptor>
      getMonitoredResourceDescriptorCallable() {
    return getMonitoredResourceDescriptorCallable;
  }

  public UnaryCallable<ListMetricDescriptorsRequest, ListMetricDescriptorsPagedResponse>
      listMetricDescriptorsPagedCallable() {
    return listMetricDescriptorsPagedCallable;
  }

  public UnaryCallable<ListMetricDescriptorsRequest, ListMetricDescriptorsResponse>
      listMetricDescriptorsCallable() {
    return listMetricDescriptorsCallable;
  }

  public UnaryCallable<GetMetricDescriptorRequest, MetricDescriptor> getMetricDescriptorCallable() {
    return getMetricDescriptorCallable;
  }

  public UnaryCallable<CreateMetricDescriptorRequest, MetricDescriptor>
      createMetricDescriptorCallable() {
    return createMetricDescriptorCallable;
  }

  public UnaryCallable<DeleteMetricDescriptorRequest, Empty> deleteMetricDescriptorCallable() {
    return deleteMetricDescriptorCallable;
  }

  public UnaryCallable<ListTimeSeriesRequest, ListTimeSeriesPagedResponse>
      listTimeSeriesPagedCallable() {
    return listTimeSeriesPagedCallable;
  }

  public UnaryCallable<ListTimeSeriesRequest, ListTimeSeriesResponse> listTimeSeriesCallable() {
    return listTimeSeriesCallable;
  }

  public UnaryCallable<CreateTimeSeriesRequest, Empty> createTimeSeriesCallable() {
    return createTimeSeriesCallable;
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
