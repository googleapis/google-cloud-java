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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.FeaturedContentNativeDashboardServiceClient.ListFeaturedContentNativeDashboardsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.FeaturedContentNativeDashboard;
import com.google.cloud.chronicle.v1.GetFeaturedContentNativeDashboardRequest;
import com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardRequest;
import com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardResponse;
import com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsRequest;
import com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the FeaturedContentNativeDashboardService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcFeaturedContentNativeDashboardServiceStub
    extends FeaturedContentNativeDashboardServiceStub {
  private static final MethodDescriptor<
          GetFeaturedContentNativeDashboardRequest, FeaturedContentNativeDashboard>
      getFeaturedContentNativeDashboardMethodDescriptor =
          MethodDescriptor
              .<GetFeaturedContentNativeDashboardRequest, FeaturedContentNativeDashboard>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FeaturedContentNativeDashboardService/GetFeaturedContentNativeDashboard")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetFeaturedContentNativeDashboardRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FeaturedContentNativeDashboard.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListFeaturedContentNativeDashboardsRequest, ListFeaturedContentNativeDashboardsResponse>
      listFeaturedContentNativeDashboardsMethodDescriptor =
          MethodDescriptor
              .<ListFeaturedContentNativeDashboardsRequest,
                  ListFeaturedContentNativeDashboardsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FeaturedContentNativeDashboardService/ListFeaturedContentNativeDashboards")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListFeaturedContentNativeDashboardsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListFeaturedContentNativeDashboardsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          InstallFeaturedContentNativeDashboardRequest,
          InstallFeaturedContentNativeDashboardResponse>
      installFeaturedContentNativeDashboardMethodDescriptor =
          MethodDescriptor
              .<InstallFeaturedContentNativeDashboardRequest,
                  InstallFeaturedContentNativeDashboardResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FeaturedContentNativeDashboardService/InstallFeaturedContentNativeDashboard")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      InstallFeaturedContentNativeDashboardRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      InstallFeaturedContentNativeDashboardResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<
          GetFeaturedContentNativeDashboardRequest, FeaturedContentNativeDashboard>
      getFeaturedContentNativeDashboardCallable;
  private final UnaryCallable<
          ListFeaturedContentNativeDashboardsRequest, ListFeaturedContentNativeDashboardsResponse>
      listFeaturedContentNativeDashboardsCallable;
  private final UnaryCallable<
          ListFeaturedContentNativeDashboardsRequest,
          ListFeaturedContentNativeDashboardsPagedResponse>
      listFeaturedContentNativeDashboardsPagedCallable;
  private final UnaryCallable<
          InstallFeaturedContentNativeDashboardRequest,
          InstallFeaturedContentNativeDashboardResponse>
      installFeaturedContentNativeDashboardCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcFeaturedContentNativeDashboardServiceStub create(
      FeaturedContentNativeDashboardServiceStubSettings settings) throws IOException {
    return new GrpcFeaturedContentNativeDashboardServiceStub(
        settings, ClientContext.create(settings));
  }

  public static final GrpcFeaturedContentNativeDashboardServiceStub create(
      ClientContext clientContext) throws IOException {
    return new GrpcFeaturedContentNativeDashboardServiceStub(
        FeaturedContentNativeDashboardServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcFeaturedContentNativeDashboardServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcFeaturedContentNativeDashboardServiceStub(
        FeaturedContentNativeDashboardServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcFeaturedContentNativeDashboardServiceStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected GrpcFeaturedContentNativeDashboardServiceStub(
      FeaturedContentNativeDashboardServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcFeaturedContentNativeDashboardServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcFeaturedContentNativeDashboardServiceStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected GrpcFeaturedContentNativeDashboardServiceStub(
      FeaturedContentNativeDashboardServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetFeaturedContentNativeDashboardRequest, FeaturedContentNativeDashboard>
        getFeaturedContentNativeDashboardTransportSettings =
            GrpcCallSettings
                .<GetFeaturedContentNativeDashboardRequest, FeaturedContentNativeDashboard>
                    newBuilder()
                .setMethodDescriptor(getFeaturedContentNativeDashboardMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<
            ListFeaturedContentNativeDashboardsRequest, ListFeaturedContentNativeDashboardsResponse>
        listFeaturedContentNativeDashboardsTransportSettings =
            GrpcCallSettings
                .<ListFeaturedContentNativeDashboardsRequest,
                    ListFeaturedContentNativeDashboardsResponse>
                    newBuilder()
                .setMethodDescriptor(listFeaturedContentNativeDashboardsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<
            InstallFeaturedContentNativeDashboardRequest,
            InstallFeaturedContentNativeDashboardResponse>
        installFeaturedContentNativeDashboardTransportSettings =
            GrpcCallSettings
                .<InstallFeaturedContentNativeDashboardRequest,
                    InstallFeaturedContentNativeDashboardResponse>
                    newBuilder()
                .setMethodDescriptor(installFeaturedContentNativeDashboardMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();

    this.getFeaturedContentNativeDashboardCallable =
        callableFactory.createUnaryCallable(
            getFeaturedContentNativeDashboardTransportSettings,
            settings.getFeaturedContentNativeDashboardSettings(),
            clientContext);
    this.listFeaturedContentNativeDashboardsCallable =
        callableFactory.createUnaryCallable(
            listFeaturedContentNativeDashboardsTransportSettings,
            settings.listFeaturedContentNativeDashboardsSettings(),
            clientContext);
    this.listFeaturedContentNativeDashboardsPagedCallable =
        callableFactory.createPagedCallable(
            listFeaturedContentNativeDashboardsTransportSettings,
            settings.listFeaturedContentNativeDashboardsSettings(),
            clientContext);
    this.installFeaturedContentNativeDashboardCallable =
        callableFactory.createUnaryCallable(
            installFeaturedContentNativeDashboardTransportSettings,
            settings.installFeaturedContentNativeDashboardSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetFeaturedContentNativeDashboardRequest, FeaturedContentNativeDashboard>
      getFeaturedContentNativeDashboardCallable() {
    return getFeaturedContentNativeDashboardCallable;
  }

  @Override
  public UnaryCallable<
          ListFeaturedContentNativeDashboardsRequest, ListFeaturedContentNativeDashboardsResponse>
      listFeaturedContentNativeDashboardsCallable() {
    return listFeaturedContentNativeDashboardsCallable;
  }

  @Override
  public UnaryCallable<
          ListFeaturedContentNativeDashboardsRequest,
          ListFeaturedContentNativeDashboardsPagedResponse>
      listFeaturedContentNativeDashboardsPagedCallable() {
    return listFeaturedContentNativeDashboardsPagedCallable;
  }

  @Override
  public UnaryCallable<
          InstallFeaturedContentNativeDashboardRequest,
          InstallFeaturedContentNativeDashboardResponse>
      installFeaturedContentNativeDashboardCallable() {
    return installFeaturedContentNativeDashboardCallable;
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
