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
  private static final UnaryCallable<ListLogMetricsRequest, ListLogMetricsResponse>
      directListLogMetricsCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.logging.v2.MetricsServiceV2/ListLogMetrics",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListLogMetricsRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListLogMetricsResponse.getDefaultInstance())));
  private static final UnaryCallable<GetLogMetricRequest, LogMetric> directGetLogMetricCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.logging.v2.MetricsServiceV2/GetLogMetric",
              io.grpc.protobuf.ProtoUtils.marshaller(GetLogMetricRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(LogMetric.getDefaultInstance())));
  private static final UnaryCallable<CreateLogMetricRequest, LogMetric>
      directCreateLogMetricCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.logging.v2.MetricsServiceV2/CreateLogMetric",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      CreateLogMetricRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(LogMetric.getDefaultInstance())));
  private static final UnaryCallable<UpdateLogMetricRequest, LogMetric>
      directUpdateLogMetricCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.logging.v2.MetricsServiceV2/UpdateLogMetric",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      UpdateLogMetricRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(LogMetric.getDefaultInstance())));
  private static final UnaryCallable<DeleteLogMetricRequest, Empty> directDeleteLogMetricCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.logging.v2.MetricsServiceV2/DeleteLogMetric",
              io.grpc.protobuf.ProtoUtils.marshaller(DeleteLogMetricRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Empty.getDefaultInstance())));

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
    return new GrpcMetricsServiceV2Stub(MetricsSettings.defaultBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcMetricsServiceV2Stub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMetricsServiceV2Stub(MetricsSettings settings, ClientContext clientContext)
      throws IOException {

    this.listLogMetricsCallable =
        GrpcCallableFactory.create(
            directListLogMetricsCallable, settings.listLogMetricsSettings(), clientContext);
    this.listLogMetricsPagedCallable =
        GrpcCallableFactory.createPagedVariant(
            directListLogMetricsCallable, settings.listLogMetricsSettings(), clientContext);
    this.getLogMetricCallable =
        GrpcCallableFactory.create(
            directGetLogMetricCallable, settings.getLogMetricSettings(), clientContext);
    this.createLogMetricCallable =
        GrpcCallableFactory.create(
            directCreateLogMetricCallable, settings.createLogMetricSettings(), clientContext);
    this.updateLogMetricCallable =
        GrpcCallableFactory.create(
            directUpdateLogMetricCallable, settings.updateLogMetricSettings(), clientContext);
    this.deleteLogMetricCallable =
        GrpcCallableFactory.create(
            directDeleteLogMetricCallable, settings.deleteLogMetricSettings(), clientContext);

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
