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

package com.google.monitoring.metricsscope.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.monitoring.metricsscope.v1.CreateMonitoredProjectRequest;
import com.google.monitoring.metricsscope.v1.DeleteMonitoredProjectRequest;
import com.google.monitoring.metricsscope.v1.GetMetricsScopeRequest;
import com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectRequest;
import com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectResponse;
import com.google.monitoring.metricsscope.v1.MetricsScope;
import com.google.monitoring.metricsscope.v1.MonitoredProject;
import com.google.monitoring.metricsscope.v1.OperationMetadata;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the MetricsScopes service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcMetricsScopesStub extends MetricsScopesStub {
  private static final MethodDescriptor<GetMetricsScopeRequest, MetricsScope>
      getMetricsScopeMethodDescriptor =
          MethodDescriptor.<GetMetricsScopeRequest, MetricsScope>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.metricsscope.v1.MetricsScopes/GetMetricsScope")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMetricsScopeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MetricsScope.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListMetricsScopesByMonitoredProjectRequest, ListMetricsScopesByMonitoredProjectResponse>
      listMetricsScopesByMonitoredProjectMethodDescriptor =
          MethodDescriptor
              .<ListMetricsScopesByMonitoredProjectRequest,
                  ListMetricsScopesByMonitoredProjectResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.monitoring.metricsscope.v1.MetricsScopes/ListMetricsScopesByMonitoredProject")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListMetricsScopesByMonitoredProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListMetricsScopesByMonitoredProjectResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateMonitoredProjectRequest, Operation>
      createMonitoredProjectMethodDescriptor =
          MethodDescriptor.<CreateMonitoredProjectRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.monitoring.metricsscope.v1.MetricsScopes/CreateMonitoredProject")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMonitoredProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteMonitoredProjectRequest, Operation>
      deleteMonitoredProjectMethodDescriptor =
          MethodDescriptor.<DeleteMonitoredProjectRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.monitoring.metricsscope.v1.MetricsScopes/DeleteMonitoredProject")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteMonitoredProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetMetricsScopeRequest, MetricsScope> getMetricsScopeCallable;
  private final UnaryCallable<
          ListMetricsScopesByMonitoredProjectRequest, ListMetricsScopesByMonitoredProjectResponse>
      listMetricsScopesByMonitoredProjectCallable;
  private final UnaryCallable<CreateMonitoredProjectRequest, Operation>
      createMonitoredProjectCallable;
  private final OperationCallable<
          CreateMonitoredProjectRequest, MonitoredProject, OperationMetadata>
      createMonitoredProjectOperationCallable;
  private final UnaryCallable<DeleteMonitoredProjectRequest, Operation>
      deleteMonitoredProjectCallable;
  private final OperationCallable<DeleteMonitoredProjectRequest, Empty, OperationMetadata>
      deleteMonitoredProjectOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcMetricsScopesStub create(MetricsScopesStubSettings settings)
      throws IOException {
    return new GrpcMetricsScopesStub(settings, ClientContext.create(settings));
  }

  public static final GrpcMetricsScopesStub create(ClientContext clientContext) throws IOException {
    return new GrpcMetricsScopesStub(MetricsScopesStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMetricsScopesStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMetricsScopesStub(
        MetricsScopesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcMetricsScopesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMetricsScopesStub(MetricsScopesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcMetricsScopesCallableFactory());
  }

  /**
   * Constructs an instance of GrpcMetricsScopesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMetricsScopesStub(
      MetricsScopesStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetMetricsScopeRequest, MetricsScope> getMetricsScopeTransportSettings =
        GrpcCallSettings.<GetMetricsScopeRequest, MetricsScope>newBuilder()
            .setMethodDescriptor(getMetricsScopeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<
            ListMetricsScopesByMonitoredProjectRequest, ListMetricsScopesByMonitoredProjectResponse>
        listMetricsScopesByMonitoredProjectTransportSettings =
            GrpcCallSettings
                .<ListMetricsScopesByMonitoredProjectRequest,
                    ListMetricsScopesByMonitoredProjectResponse>
                    newBuilder()
                .setMethodDescriptor(listMetricsScopesByMonitoredProjectMethodDescriptor)
                .build();
    GrpcCallSettings<CreateMonitoredProjectRequest, Operation>
        createMonitoredProjectTransportSettings =
            GrpcCallSettings.<CreateMonitoredProjectRequest, Operation>newBuilder()
                .setMethodDescriptor(createMonitoredProjectMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteMonitoredProjectRequest, Operation>
        deleteMonitoredProjectTransportSettings =
            GrpcCallSettings.<DeleteMonitoredProjectRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMonitoredProjectMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();

    this.getMetricsScopeCallable =
        callableFactory.createUnaryCallable(
            getMetricsScopeTransportSettings, settings.getMetricsScopeSettings(), clientContext);
    this.listMetricsScopesByMonitoredProjectCallable =
        callableFactory.createUnaryCallable(
            listMetricsScopesByMonitoredProjectTransportSettings,
            settings.listMetricsScopesByMonitoredProjectSettings(),
            clientContext);
    this.createMonitoredProjectCallable =
        callableFactory.createUnaryCallable(
            createMonitoredProjectTransportSettings,
            settings.createMonitoredProjectSettings(),
            clientContext);
    this.createMonitoredProjectOperationCallable =
        callableFactory.createOperationCallable(
            createMonitoredProjectTransportSettings,
            settings.createMonitoredProjectOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteMonitoredProjectCallable =
        callableFactory.createUnaryCallable(
            deleteMonitoredProjectTransportSettings,
            settings.deleteMonitoredProjectSettings(),
            clientContext);
    this.deleteMonitoredProjectOperationCallable =
        callableFactory.createOperationCallable(
            deleteMonitoredProjectTransportSettings,
            settings.deleteMonitoredProjectOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetMetricsScopeRequest, MetricsScope> getMetricsScopeCallable() {
    return getMetricsScopeCallable;
  }

  @Override
  public UnaryCallable<
          ListMetricsScopesByMonitoredProjectRequest, ListMetricsScopesByMonitoredProjectResponse>
      listMetricsScopesByMonitoredProjectCallable() {
    return listMetricsScopesByMonitoredProjectCallable;
  }

  @Override
  public UnaryCallable<CreateMonitoredProjectRequest, Operation> createMonitoredProjectCallable() {
    return createMonitoredProjectCallable;
  }

  @Override
  public OperationCallable<CreateMonitoredProjectRequest, MonitoredProject, OperationMetadata>
      createMonitoredProjectOperationCallable() {
    return createMonitoredProjectOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteMonitoredProjectRequest, Operation> deleteMonitoredProjectCallable() {
    return deleteMonitoredProjectCallable;
  }

  @Override
  public OperationCallable<DeleteMonitoredProjectRequest, Empty, OperationMetadata>
      deleteMonitoredProjectOperationCallable() {
    return deleteMonitoredProjectOperationCallable;
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
