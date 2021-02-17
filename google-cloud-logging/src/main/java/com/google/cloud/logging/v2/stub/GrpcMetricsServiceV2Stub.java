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

package com.google.cloud.logging.v2.stub;

import static com.google.cloud.logging.v2.MetricsClient.ListLogMetricsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.logging.v2.CreateLogMetricRequest;
import com.google.logging.v2.DeleteLogMetricRequest;
import com.google.logging.v2.GetLogMetricRequest;
import com.google.logging.v2.ListLogMetricsRequest;
import com.google.logging.v2.ListLogMetricsResponse;
import com.google.logging.v2.LogMetric;
import com.google.logging.v2.UpdateLogMetricRequest;
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
 * gRPC stub implementation for the MetricsServiceV2 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
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

  private final UnaryCallable<ListLogMetricsRequest, ListLogMetricsResponse> listLogMetricsCallable;
  private final UnaryCallable<ListLogMetricsRequest, ListLogMetricsPagedResponse>
      listLogMetricsPagedCallable;
  private final UnaryCallable<GetLogMetricRequest, LogMetric> getLogMetricCallable;
  private final UnaryCallable<CreateLogMetricRequest, LogMetric> createLogMetricCallable;
  private final UnaryCallable<UpdateLogMetricRequest, LogMetric> updateLogMetricCallable;
  private final UnaryCallable<DeleteLogMetricRequest, Empty> deleteLogMetricCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcMetricsServiceV2Stub create(MetricsServiceV2StubSettings settings)
      throws IOException {
    return new GrpcMetricsServiceV2Stub(settings, ClientContext.create(settings));
  }

  public static final GrpcMetricsServiceV2Stub create(ClientContext clientContext)
      throws IOException {
    return new GrpcMetricsServiceV2Stub(
        MetricsServiceV2StubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMetricsServiceV2Stub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMetricsServiceV2Stub(
        MetricsServiceV2StubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcMetricsServiceV2Stub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMetricsServiceV2Stub(
      MetricsServiceV2StubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcMetricsServiceV2CallableFactory());
  }

  /**
   * Constructs an instance of GrpcMetricsServiceV2Stub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMetricsServiceV2Stub(
      MetricsServiceV2StubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListLogMetricsRequest, ListLogMetricsResponse>
        listLogMetricsTransportSettings =
            GrpcCallSettings.<ListLogMetricsRequest, ListLogMetricsResponse>newBuilder()
                .setMethodDescriptor(listLogMetricsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListLogMetricsRequest>() {
                      @Override
                      public Map<String, String> extract(ListLogMetricsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetLogMetricRequest, LogMetric> getLogMetricTransportSettings =
        GrpcCallSettings.<GetLogMetricRequest, LogMetric>newBuilder()
            .setMethodDescriptor(getLogMetricMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetLogMetricRequest>() {
                  @Override
                  public Map<String, String> extract(GetLogMetricRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("metric_name", String.valueOf(request.getMetricName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateLogMetricRequest, LogMetric> createLogMetricTransportSettings =
        GrpcCallSettings.<CreateLogMetricRequest, LogMetric>newBuilder()
            .setMethodDescriptor(createLogMetricMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateLogMetricRequest>() {
                  @Override
                  public Map<String, String> extract(CreateLogMetricRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateLogMetricRequest, LogMetric> updateLogMetricTransportSettings =
        GrpcCallSettings.<UpdateLogMetricRequest, LogMetric>newBuilder()
            .setMethodDescriptor(updateLogMetricMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateLogMetricRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateLogMetricRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("metric_name", String.valueOf(request.getMetricName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteLogMetricRequest, Empty> deleteLogMetricTransportSettings =
        GrpcCallSettings.<DeleteLogMetricRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteLogMetricMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteLogMetricRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteLogMetricRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("metric_name", String.valueOf(request.getMetricName()));
                    return params.build();
                  }
                })
            .build();

    this.listLogMetricsCallable =
        callableFactory.createUnaryCallable(
            listLogMetricsTransportSettings, settings.listLogMetricsSettings(), clientContext);
    this.listLogMetricsPagedCallable =
        callableFactory.createPagedCallable(
            listLogMetricsTransportSettings, settings.listLogMetricsSettings(), clientContext);
    this.getLogMetricCallable =
        callableFactory.createUnaryCallable(
            getLogMetricTransportSettings, settings.getLogMetricSettings(), clientContext);
    this.createLogMetricCallable =
        callableFactory.createUnaryCallable(
            createLogMetricTransportSettings, settings.createLogMetricSettings(), clientContext);
    this.updateLogMetricCallable =
        callableFactory.createUnaryCallable(
            updateLogMetricTransportSettings, settings.updateLogMetricSettings(), clientContext);
    this.deleteLogMetricCallable =
        callableFactory.createUnaryCallable(
            deleteLogMetricTransportSettings, settings.deleteLogMetricSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListLogMetricsRequest, ListLogMetricsResponse> listLogMetricsCallable() {
    return listLogMetricsCallable;
  }

  @Override
  public UnaryCallable<ListLogMetricsRequest, ListLogMetricsPagedResponse>
      listLogMetricsPagedCallable() {
    return listLogMetricsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLogMetricRequest, LogMetric> getLogMetricCallable() {
    return getLogMetricCallable;
  }

  @Override
  public UnaryCallable<CreateLogMetricRequest, LogMetric> createLogMetricCallable() {
    return createLogMetricCallable;
  }

  @Override
  public UnaryCallable<UpdateLogMetricRequest, LogMetric> updateLogMetricCallable() {
    return updateLogMetricCallable;
  }

  @Override
  public UnaryCallable<DeleteLogMetricRequest, Empty> deleteLogMetricCallable() {
    return deleteLogMetricCallable;
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
