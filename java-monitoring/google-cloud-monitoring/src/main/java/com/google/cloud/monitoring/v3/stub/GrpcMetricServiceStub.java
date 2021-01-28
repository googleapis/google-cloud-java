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

package com.google.cloud.monitoring.v3.stub;

import static com.google.cloud.monitoring.v3.MetricServiceClient.ListMetricDescriptorsPagedResponse;
import static com.google.cloud.monitoring.v3.MetricServiceClient.ListMonitoredResourceDescriptorsPagedResponse;
import static com.google.cloud.monitoring.v3.MetricServiceClient.ListTimeSeriesPagedResponse;

import com.google.api.MetricDescriptor;
import com.google.api.MonitoredResourceDescriptor;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
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
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the MetricService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcMetricServiceStub extends MetricServiceStub {
  private static final MethodDescriptor<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
      listMonitoredResourceDescriptorsMethodDescriptor =
          MethodDescriptor
              .<ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.monitoring.v3.MetricService/ListMonitoredResourceDescriptors")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListMonitoredResourceDescriptorsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListMonitoredResourceDescriptorsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetMonitoredResourceDescriptorRequest, MonitoredResourceDescriptor>
      getMonitoredResourceDescriptorMethodDescriptor =
          MethodDescriptor
              .<GetMonitoredResourceDescriptorRequest, MonitoredResourceDescriptor>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.monitoring.v3.MetricService/GetMonitoredResourceDescriptor")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMonitoredResourceDescriptorRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(MonitoredResourceDescriptor.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListMetricDescriptorsRequest, ListMetricDescriptorsResponse>
      listMetricDescriptorsMethodDescriptor =
          MethodDescriptor.<ListMetricDescriptorsRequest, ListMetricDescriptorsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.v3.MetricService/ListMetricDescriptors")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMetricDescriptorsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMetricDescriptorsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetMetricDescriptorRequest, MetricDescriptor>
      getMetricDescriptorMethodDescriptor =
          MethodDescriptor.<GetMetricDescriptorRequest, MetricDescriptor>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.v3.MetricService/GetMetricDescriptor")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMetricDescriptorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MetricDescriptor.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateMetricDescriptorRequest, MetricDescriptor>
      createMetricDescriptorMethodDescriptor =
          MethodDescriptor.<CreateMetricDescriptorRequest, MetricDescriptor>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.v3.MetricService/CreateMetricDescriptor")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMetricDescriptorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MetricDescriptor.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteMetricDescriptorRequest, Empty>
      deleteMetricDescriptorMethodDescriptor =
          MethodDescriptor.<DeleteMetricDescriptorRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.v3.MetricService/DeleteMetricDescriptor")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteMetricDescriptorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListTimeSeriesRequest, ListTimeSeriesResponse>
      listTimeSeriesMethodDescriptor =
          MethodDescriptor.<ListTimeSeriesRequest, ListTimeSeriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.v3.MetricService/ListTimeSeries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTimeSeriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTimeSeriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateTimeSeriesRequest, Empty>
      createTimeSeriesMethodDescriptor =
          MethodDescriptor.<CreateTimeSeriesRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.v3.MetricService/CreateTimeSeries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTimeSeriesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

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

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcMetricServiceStub create(MetricServiceStubSettings settings)
      throws IOException {
    return new GrpcMetricServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcMetricServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcMetricServiceStub(MetricServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMetricServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMetricServiceStub(
        MetricServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcMetricServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMetricServiceStub(MetricServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcMetricServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcMetricServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMetricServiceStub(
      MetricServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<
            ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
        listMonitoredResourceDescriptorsTransportSettings =
            GrpcCallSettings
                .<ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
                    newBuilder()
                .setMethodDescriptor(listMonitoredResourceDescriptorsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListMonitoredResourceDescriptorsRequest>() {
                      @Override
                      public Map<String, String> extract(
                          ListMonitoredResourceDescriptorsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetMonitoredResourceDescriptorRequest, MonitoredResourceDescriptor>
        getMonitoredResourceDescriptorTransportSettings =
            GrpcCallSettings
                .<GetMonitoredResourceDescriptorRequest, MonitoredResourceDescriptor>newBuilder()
                .setMethodDescriptor(getMonitoredResourceDescriptorMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GetMonitoredResourceDescriptorRequest>() {
                      @Override
                      public Map<String, String> extract(
                          GetMonitoredResourceDescriptorRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ListMetricDescriptorsRequest, ListMetricDescriptorsResponse>
        listMetricDescriptorsTransportSettings =
            GrpcCallSettings
                .<ListMetricDescriptorsRequest, ListMetricDescriptorsResponse>newBuilder()
                .setMethodDescriptor(listMetricDescriptorsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListMetricDescriptorsRequest>() {
                      @Override
                      public Map<String, String> extract(ListMetricDescriptorsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetMetricDescriptorRequest, MetricDescriptor>
        getMetricDescriptorTransportSettings =
            GrpcCallSettings.<GetMetricDescriptorRequest, MetricDescriptor>newBuilder()
                .setMethodDescriptor(getMetricDescriptorMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GetMetricDescriptorRequest>() {
                      @Override
                      public Map<String, String> extract(GetMetricDescriptorRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CreateMetricDescriptorRequest, MetricDescriptor>
        createMetricDescriptorTransportSettings =
            GrpcCallSettings.<CreateMetricDescriptorRequest, MetricDescriptor>newBuilder()
                .setMethodDescriptor(createMetricDescriptorMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CreateMetricDescriptorRequest>() {
                      @Override
                      public Map<String, String> extract(CreateMetricDescriptorRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeleteMetricDescriptorRequest, Empty> deleteMetricDescriptorTransportSettings =
        GrpcCallSettings.<DeleteMetricDescriptorRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteMetricDescriptorMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteMetricDescriptorRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteMetricDescriptorRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListTimeSeriesRequest, ListTimeSeriesResponse>
        listTimeSeriesTransportSettings =
            GrpcCallSettings.<ListTimeSeriesRequest, ListTimeSeriesResponse>newBuilder()
                .setMethodDescriptor(listTimeSeriesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListTimeSeriesRequest>() {
                      @Override
                      public Map<String, String> extract(ListTimeSeriesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CreateTimeSeriesRequest, Empty> createTimeSeriesTransportSettings =
        GrpcCallSettings.<CreateTimeSeriesRequest, Empty>newBuilder()
            .setMethodDescriptor(createTimeSeriesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateTimeSeriesRequest>() {
                  @Override
                  public Map<String, String> extract(CreateTimeSeriesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();

    this.listMonitoredResourceDescriptorsCallable =
        callableFactory.createUnaryCallable(
            listMonitoredResourceDescriptorsTransportSettings,
            settings.listMonitoredResourceDescriptorsSettings(),
            clientContext);
    this.listMonitoredResourceDescriptorsPagedCallable =
        callableFactory.createPagedCallable(
            listMonitoredResourceDescriptorsTransportSettings,
            settings.listMonitoredResourceDescriptorsSettings(),
            clientContext);
    this.getMonitoredResourceDescriptorCallable =
        callableFactory.createUnaryCallable(
            getMonitoredResourceDescriptorTransportSettings,
            settings.getMonitoredResourceDescriptorSettings(),
            clientContext);
    this.listMetricDescriptorsCallable =
        callableFactory.createUnaryCallable(
            listMetricDescriptorsTransportSettings,
            settings.listMetricDescriptorsSettings(),
            clientContext);
    this.listMetricDescriptorsPagedCallable =
        callableFactory.createPagedCallable(
            listMetricDescriptorsTransportSettings,
            settings.listMetricDescriptorsSettings(),
            clientContext);
    this.getMetricDescriptorCallable =
        callableFactory.createUnaryCallable(
            getMetricDescriptorTransportSettings,
            settings.getMetricDescriptorSettings(),
            clientContext);
    this.createMetricDescriptorCallable =
        callableFactory.createUnaryCallable(
            createMetricDescriptorTransportSettings,
            settings.createMetricDescriptorSettings(),
            clientContext);
    this.deleteMetricDescriptorCallable =
        callableFactory.createUnaryCallable(
            deleteMetricDescriptorTransportSettings,
            settings.deleteMetricDescriptorSettings(),
            clientContext);
    this.listTimeSeriesCallable =
        callableFactory.createUnaryCallable(
            listTimeSeriesTransportSettings, settings.listTimeSeriesSettings(), clientContext);
    this.listTimeSeriesPagedCallable =
        callableFactory.createPagedCallable(
            listTimeSeriesTransportSettings, settings.listTimeSeriesSettings(), clientContext);
    this.createTimeSeriesCallable =
        callableFactory.createUnaryCallable(
            createTimeSeriesTransportSettings, settings.createTimeSeriesSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
      listMonitoredResourceDescriptorsCallable() {
    return listMonitoredResourceDescriptorsCallable;
  }

  public UnaryCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsPagedResponse>
      listMonitoredResourceDescriptorsPagedCallable() {
    return listMonitoredResourceDescriptorsPagedCallable;
  }

  public UnaryCallable<GetMonitoredResourceDescriptorRequest, MonitoredResourceDescriptor>
      getMonitoredResourceDescriptorCallable() {
    return getMonitoredResourceDescriptorCallable;
  }

  public UnaryCallable<ListMetricDescriptorsRequest, ListMetricDescriptorsResponse>
      listMetricDescriptorsCallable() {
    return listMetricDescriptorsCallable;
  }

  public UnaryCallable<ListMetricDescriptorsRequest, ListMetricDescriptorsPagedResponse>
      listMetricDescriptorsPagedCallable() {
    return listMetricDescriptorsPagedCallable;
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

  public UnaryCallable<ListTimeSeriesRequest, ListTimeSeriesResponse> listTimeSeriesCallable() {
    return listTimeSeriesCallable;
  }

  public UnaryCallable<ListTimeSeriesRequest, ListTimeSeriesPagedResponse>
      listTimeSeriesPagedCallable() {
    return listTimeSeriesPagedCallable;
  }

  public UnaryCallable<CreateTimeSeriesRequest, Empty> createTimeSeriesCallable() {
    return createTimeSeriesCallable;
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
