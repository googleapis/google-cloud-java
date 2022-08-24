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

package com.google.cloud.monitoring.dashboard.v1.stub;

import static com.google.cloud.monitoring.dashboard.v1.DashboardsServiceClient.ListDashboardsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.monitoring.dashboard.v1.CreateDashboardRequest;
import com.google.monitoring.dashboard.v1.Dashboard;
import com.google.monitoring.dashboard.v1.DeleteDashboardRequest;
import com.google.monitoring.dashboard.v1.GetDashboardRequest;
import com.google.monitoring.dashboard.v1.ListDashboardsRequest;
import com.google.monitoring.dashboard.v1.ListDashboardsResponse;
import com.google.monitoring.dashboard.v1.UpdateDashboardRequest;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DashboardsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDashboardsServiceStub extends DashboardsServiceStub {
  private static final MethodDescriptor<CreateDashboardRequest, Dashboard>
      createDashboardMethodDescriptor =
          MethodDescriptor.<CreateDashboardRequest, Dashboard>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.dashboard.v1.DashboardsService/CreateDashboard")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDashboardRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Dashboard.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDashboardsRequest, ListDashboardsResponse>
      listDashboardsMethodDescriptor =
          MethodDescriptor.<ListDashboardsRequest, ListDashboardsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.dashboard.v1.DashboardsService/ListDashboards")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDashboardsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDashboardsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDashboardRequest, Dashboard>
      getDashboardMethodDescriptor =
          MethodDescriptor.<GetDashboardRequest, Dashboard>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.dashboard.v1.DashboardsService/GetDashboard")
              .setRequestMarshaller(ProtoUtils.marshaller(GetDashboardRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Dashboard.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDashboardRequest, Empty>
      deleteDashboardMethodDescriptor =
          MethodDescriptor.<DeleteDashboardRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.dashboard.v1.DashboardsService/DeleteDashboard")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDashboardRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDashboardRequest, Dashboard>
      updateDashboardMethodDescriptor =
          MethodDescriptor.<UpdateDashboardRequest, Dashboard>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.dashboard.v1.DashboardsService/UpdateDashboard")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDashboardRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Dashboard.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateDashboardRequest, Dashboard> createDashboardCallable;
  private final UnaryCallable<ListDashboardsRequest, ListDashboardsResponse> listDashboardsCallable;
  private final UnaryCallable<ListDashboardsRequest, ListDashboardsPagedResponse>
      listDashboardsPagedCallable;
  private final UnaryCallable<GetDashboardRequest, Dashboard> getDashboardCallable;
  private final UnaryCallable<DeleteDashboardRequest, Empty> deleteDashboardCallable;
  private final UnaryCallable<UpdateDashboardRequest, Dashboard> updateDashboardCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDashboardsServiceStub create(DashboardsServiceStubSettings settings)
      throws IOException {
    return new GrpcDashboardsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDashboardsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDashboardsServiceStub(
        DashboardsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDashboardsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDashboardsServiceStub(
        DashboardsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDashboardsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDashboardsServiceStub(
      DashboardsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDashboardsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDashboardsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDashboardsServiceStub(
      DashboardsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateDashboardRequest, Dashboard> createDashboardTransportSettings =
        GrpcCallSettings.<CreateDashboardRequest, Dashboard>newBuilder()
            .setMethodDescriptor(createDashboardMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListDashboardsRequest, ListDashboardsResponse>
        listDashboardsTransportSettings =
            GrpcCallSettings.<ListDashboardsRequest, ListDashboardsResponse>newBuilder()
                .setMethodDescriptor(listDashboardsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetDashboardRequest, Dashboard> getDashboardTransportSettings =
        GrpcCallSettings.<GetDashboardRequest, Dashboard>newBuilder()
            .setMethodDescriptor(getDashboardMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteDashboardRequest, Empty> deleteDashboardTransportSettings =
        GrpcCallSettings.<DeleteDashboardRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDashboardMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateDashboardRequest, Dashboard> updateDashboardTransportSettings =
        GrpcCallSettings.<UpdateDashboardRequest, Dashboard>newBuilder()
            .setMethodDescriptor(updateDashboardMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("dashboard.name", String.valueOf(request.getDashboard().getName()));
                  return params.build();
                })
            .build();

    this.createDashboardCallable =
        callableFactory.createUnaryCallable(
            createDashboardTransportSettings, settings.createDashboardSettings(), clientContext);
    this.listDashboardsCallable =
        callableFactory.createUnaryCallable(
            listDashboardsTransportSettings, settings.listDashboardsSettings(), clientContext);
    this.listDashboardsPagedCallable =
        callableFactory.createPagedCallable(
            listDashboardsTransportSettings, settings.listDashboardsSettings(), clientContext);
    this.getDashboardCallable =
        callableFactory.createUnaryCallable(
            getDashboardTransportSettings, settings.getDashboardSettings(), clientContext);
    this.deleteDashboardCallable =
        callableFactory.createUnaryCallable(
            deleteDashboardTransportSettings, settings.deleteDashboardSettings(), clientContext);
    this.updateDashboardCallable =
        callableFactory.createUnaryCallable(
            updateDashboardTransportSettings, settings.updateDashboardSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateDashboardRequest, Dashboard> createDashboardCallable() {
    return createDashboardCallable;
  }

  @Override
  public UnaryCallable<ListDashboardsRequest, ListDashboardsResponse> listDashboardsCallable() {
    return listDashboardsCallable;
  }

  @Override
  public UnaryCallable<ListDashboardsRequest, ListDashboardsPagedResponse>
      listDashboardsPagedCallable() {
    return listDashboardsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDashboardRequest, Dashboard> getDashboardCallable() {
    return getDashboardCallable;
  }

  @Override
  public UnaryCallable<DeleteDashboardRequest, Empty> deleteDashboardCallable() {
    return deleteDashboardCallable;
  }

  @Override
  public UnaryCallable<UpdateDashboardRequest, Dashboard> updateDashboardCallable() {
    return updateDashboardCallable;
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
