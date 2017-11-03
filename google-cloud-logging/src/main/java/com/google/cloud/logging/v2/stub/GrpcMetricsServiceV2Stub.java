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
package com.google.cloud.logging.v2.stub;

import static com.google.cloud.logging.v2.PagedResponseWrappers.ListLogMetricsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.logging.v2.MetricsSettings;
import com.google.logging.v2.CreateLogMetricRequest;
import com.google.logging.v2.DeleteLogMetricRequest;
import com.google.logging.v2.GetLogMetricRequest;
import com.google.logging.v2.ListLogMetricsRequest;
import com.google.logging.v2.ListLogMetricsResponse;
import com.google.logging.v2.LogMetric;
import com.google.logging.v2.UpdateLogMetricRequest;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Stackdriver Logging API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class GrpcMetricsServiceV2Stub extends MetricsServiceV2Stub {

  private static final MethodDescriptor<ListLogMetricsRequest, ListLogMetricsResponse>
      listLogMetricsMethodDescriptor =
          MethodDescriptor.<ListLogMetricsRequest, ListLogMetricsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.MetricsServiceV2/ListLogMetrics")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLogMetricsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLogMetricsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetLogMetricRequest, LogMetric>
      getLogMetricMethodDescriptor =
          MethodDescriptor.<GetLogMetricRequest, LogMetric>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.MetricsServiceV2/GetLogMetric")
              .setRequestMarshaller(ProtoUtils.marshaller(GetLogMetricRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LogMetric.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<CreateLogMetricRequest, LogMetric>
      createLogMetricMethodDescriptor =
          MethodDescriptor.<CreateLogMetricRequest, LogMetric>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.MetricsServiceV2/CreateLogMetric")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateLogMetricRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LogMetric.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<UpdateLogMetricRequest, LogMetric>
      updateLogMetricMethodDescriptor =
          MethodDescriptor.<UpdateLogMetricRequest, LogMetric>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.MetricsServiceV2/UpdateLogMetric")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateLogMetricRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LogMetric.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<DeleteLogMetricRequest, Empty>
      deleteLogMetricMethodDescriptor =
          MethodDescriptor.<DeleteLogMetricRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.MetricsServiceV2/DeleteLogMetric")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteLogMetricRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<ListLogMetricsRequest, ListLogMetricsResponse> listLogMetricsCallable;
  private final UnaryCallable<ListLogMetricsRequest, ListLogMetricsPagedResponse>
      listLogMetricsPagedCallable;
  private final UnaryCallable<GetLogMetricRequest, LogMetric> getLogMetricCallable;
  private final UnaryCallable<CreateLogMetricRequest, LogMetric> createLogMetricCallable;
  private final UnaryCallable<UpdateLogMetricRequest, LogMetric> updateLogMetricCallable;
  private final UnaryCallable<DeleteLogMetricRequest, Empty> deleteLogMetricCallable;

  public static final GrpcMetricsServiceV2Stub create(MetricsSettings settings) throws IOException {
    return new GrpcMetricsServiceV2Stub(settings, ClientContext.create(settings));
  }

  public static final GrpcMetricsServiceV2Stub create(ClientContext clientContext)
      throws IOException {
    return new GrpcMetricsServiceV2Stub(MetricsSettings.newBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcMetricsServiceV2Stub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMetricsServiceV2Stub(MetricsSettings settings, ClientContext clientContext)
      throws IOException {

    GrpcCallSettings<ListLogMetricsRequest, ListLogMetricsResponse>
        listLogMetricsTransportSettings =
            GrpcCallSettings.<ListLogMetricsRequest, ListLogMetricsResponse>newBuilder()
                .setMethodDescriptor(listLogMetricsMethodDescriptor)
                .build();
    GrpcCallSettings<GetLogMetricRequest, LogMetric> getLogMetricTransportSettings =
        GrpcCallSettings.<GetLogMetricRequest, LogMetric>newBuilder()
            .setMethodDescriptor(getLogMetricMethodDescriptor)
            .build();
    GrpcCallSettings<CreateLogMetricRequest, LogMetric> createLogMetricTransportSettings =
        GrpcCallSettings.<CreateLogMetricRequest, LogMetric>newBuilder()
            .setMethodDescriptor(createLogMetricMethodDescriptor)
            .build();
    GrpcCallSettings<UpdateLogMetricRequest, LogMetric> updateLogMetricTransportSettings =
        GrpcCallSettings.<UpdateLogMetricRequest, LogMetric>newBuilder()
            .setMethodDescriptor(updateLogMetricMethodDescriptor)
            .build();
    GrpcCallSettings<DeleteLogMetricRequest, Empty> deleteLogMetricTransportSettings =
        GrpcCallSettings.<DeleteLogMetricRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteLogMetricMethodDescriptor)
            .build();

    this.listLogMetricsCallable =
        GrpcCallableFactory.createUnaryCallable(
            listLogMetricsTransportSettings, settings.listLogMetricsSettings(), clientContext);
    this.listLogMetricsPagedCallable =
        GrpcCallableFactory.createPagedCallable(
            listLogMetricsTransportSettings, settings.listLogMetricsSettings(), clientContext);
    this.getLogMetricCallable =
        GrpcCallableFactory.createUnaryCallable(
            getLogMetricTransportSettings, settings.getLogMetricSettings(), clientContext);
    this.createLogMetricCallable =
        GrpcCallableFactory.createUnaryCallable(
            createLogMetricTransportSettings, settings.createLogMetricSettings(), clientContext);
    this.updateLogMetricCallable =
        GrpcCallableFactory.createUnaryCallable(
            updateLogMetricTransportSettings, settings.updateLogMetricSettings(), clientContext);
    this.deleteLogMetricCallable =
        GrpcCallableFactory.createUnaryCallable(
            deleteLogMetricTransportSettings, settings.deleteLogMetricSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<ListLogMetricsRequest, ListLogMetricsPagedResponse>
      listLogMetricsPagedCallable() {
    return listLogMetricsPagedCallable;
  }

  public UnaryCallable<ListLogMetricsRequest, ListLogMetricsResponse> listLogMetricsCallable() {
    return listLogMetricsCallable;
  }

  public UnaryCallable<GetLogMetricRequest, LogMetric> getLogMetricCallable() {
    return getLogMetricCallable;
  }

  public UnaryCallable<CreateLogMetricRequest, LogMetric> createLogMetricCallable() {
    return createLogMetricCallable;
  }

  public UnaryCallable<UpdateLogMetricRequest, LogMetric> updateLogMetricCallable() {
    return updateLogMetricCallable;
  }

  public UnaryCallable<DeleteLogMetricRequest, Empty> deleteLogMetricCallable() {
    return deleteLogMetricCallable;
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
