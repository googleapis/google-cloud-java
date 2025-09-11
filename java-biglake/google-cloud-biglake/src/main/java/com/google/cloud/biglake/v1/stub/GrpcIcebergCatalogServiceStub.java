/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.biglake.v1.stub;

import static com.google.cloud.biglake.v1.IcebergCatalogServiceClient.ListIcebergCatalogsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.biglake.v1.CreateIcebergCatalogRequest;
import com.google.cloud.biglake.v1.FailoverIcebergCatalogRequest;
import com.google.cloud.biglake.v1.FailoverIcebergCatalogResponse;
import com.google.cloud.biglake.v1.GetIcebergCatalogRequest;
import com.google.cloud.biglake.v1.IcebergCatalog;
import com.google.cloud.biglake.v1.ListIcebergCatalogsRequest;
import com.google.cloud.biglake.v1.ListIcebergCatalogsResponse;
import com.google.cloud.biglake.v1.UpdateIcebergCatalogRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the IcebergCatalogService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcIcebergCatalogServiceStub extends IcebergCatalogServiceStub {
  private static final MethodDescriptor<GetIcebergCatalogRequest, IcebergCatalog>
      getIcebergCatalogMethodDescriptor =
          MethodDescriptor.<GetIcebergCatalogRequest, IcebergCatalog>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.biglake.v1.IcebergCatalogService/GetIcebergCatalog")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetIcebergCatalogRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(IcebergCatalog.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListIcebergCatalogsRequest, ListIcebergCatalogsResponse>
      listIcebergCatalogsMethodDescriptor =
          MethodDescriptor.<ListIcebergCatalogsRequest, ListIcebergCatalogsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.biglake.v1.IcebergCatalogService/ListIcebergCatalogs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListIcebergCatalogsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListIcebergCatalogsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateIcebergCatalogRequest, IcebergCatalog>
      updateIcebergCatalogMethodDescriptor =
          MethodDescriptor.<UpdateIcebergCatalogRequest, IcebergCatalog>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.biglake.v1.IcebergCatalogService/UpdateIcebergCatalog")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateIcebergCatalogRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(IcebergCatalog.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateIcebergCatalogRequest, IcebergCatalog>
      createIcebergCatalogMethodDescriptor =
          MethodDescriptor.<CreateIcebergCatalogRequest, IcebergCatalog>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.biglake.v1.IcebergCatalogService/CreateIcebergCatalog")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateIcebergCatalogRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(IcebergCatalog.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          FailoverIcebergCatalogRequest, FailoverIcebergCatalogResponse>
      failoverIcebergCatalogMethodDescriptor =
          MethodDescriptor
              .<FailoverIcebergCatalogRequest, FailoverIcebergCatalogResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.biglake.v1.IcebergCatalogService/FailoverIcebergCatalog")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FailoverIcebergCatalogRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FailoverIcebergCatalogResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GetIcebergCatalogRequest, IcebergCatalog> getIcebergCatalogCallable;
  private final UnaryCallable<ListIcebergCatalogsRequest, ListIcebergCatalogsResponse>
      listIcebergCatalogsCallable;
  private final UnaryCallable<ListIcebergCatalogsRequest, ListIcebergCatalogsPagedResponse>
      listIcebergCatalogsPagedCallable;
  private final UnaryCallable<UpdateIcebergCatalogRequest, IcebergCatalog>
      updateIcebergCatalogCallable;
  private final UnaryCallable<CreateIcebergCatalogRequest, IcebergCatalog>
      createIcebergCatalogCallable;
  private final UnaryCallable<FailoverIcebergCatalogRequest, FailoverIcebergCatalogResponse>
      failoverIcebergCatalogCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcIcebergCatalogServiceStub create(
      IcebergCatalogServiceStubSettings settings) throws IOException {
    return new GrpcIcebergCatalogServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcIcebergCatalogServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcIcebergCatalogServiceStub(
        IcebergCatalogServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcIcebergCatalogServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcIcebergCatalogServiceStub(
        IcebergCatalogServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcIcebergCatalogServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcIcebergCatalogServiceStub(
      IcebergCatalogServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcIcebergCatalogServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcIcebergCatalogServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcIcebergCatalogServiceStub(
      IcebergCatalogServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetIcebergCatalogRequest, IcebergCatalog> getIcebergCatalogTransportSettings =
        GrpcCallSettings.<GetIcebergCatalogRequest, IcebergCatalog>newBuilder()
            .setMethodDescriptor(getIcebergCatalogMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListIcebergCatalogsRequest, ListIcebergCatalogsResponse>
        listIcebergCatalogsTransportSettings =
            GrpcCallSettings.<ListIcebergCatalogsRequest, ListIcebergCatalogsResponse>newBuilder()
                .setMethodDescriptor(listIcebergCatalogsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateIcebergCatalogRequest, IcebergCatalog>
        updateIcebergCatalogTransportSettings =
            GrpcCallSettings.<UpdateIcebergCatalogRequest, IcebergCatalog>newBuilder()
                .setMethodDescriptor(updateIcebergCatalogMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "iceberg_catalog.name",
                          String.valueOf(request.getIcebergCatalog().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateIcebergCatalogRequest, IcebergCatalog>
        createIcebergCatalogTransportSettings =
            GrpcCallSettings.<CreateIcebergCatalogRequest, IcebergCatalog>newBuilder()
                .setMethodDescriptor(createIcebergCatalogMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<FailoverIcebergCatalogRequest, FailoverIcebergCatalogResponse>
        failoverIcebergCatalogTransportSettings =
            GrpcCallSettings
                .<FailoverIcebergCatalogRequest, FailoverIcebergCatalogResponse>newBuilder()
                .setMethodDescriptor(failoverIcebergCatalogMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.getIcebergCatalogCallable =
        callableFactory.createUnaryCallable(
            getIcebergCatalogTransportSettings,
            settings.getIcebergCatalogSettings(),
            clientContext);
    this.listIcebergCatalogsCallable =
        callableFactory.createUnaryCallable(
            listIcebergCatalogsTransportSettings,
            settings.listIcebergCatalogsSettings(),
            clientContext);
    this.listIcebergCatalogsPagedCallable =
        callableFactory.createPagedCallable(
            listIcebergCatalogsTransportSettings,
            settings.listIcebergCatalogsSettings(),
            clientContext);
    this.updateIcebergCatalogCallable =
        callableFactory.createUnaryCallable(
            updateIcebergCatalogTransportSettings,
            settings.updateIcebergCatalogSettings(),
            clientContext);
    this.createIcebergCatalogCallable =
        callableFactory.createUnaryCallable(
            createIcebergCatalogTransportSettings,
            settings.createIcebergCatalogSettings(),
            clientContext);
    this.failoverIcebergCatalogCallable =
        callableFactory.createUnaryCallable(
            failoverIcebergCatalogTransportSettings,
            settings.failoverIcebergCatalogSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetIcebergCatalogRequest, IcebergCatalog> getIcebergCatalogCallable() {
    return getIcebergCatalogCallable;
  }

  @Override
  public UnaryCallable<ListIcebergCatalogsRequest, ListIcebergCatalogsResponse>
      listIcebergCatalogsCallable() {
    return listIcebergCatalogsCallable;
  }

  @Override
  public UnaryCallable<ListIcebergCatalogsRequest, ListIcebergCatalogsPagedResponse>
      listIcebergCatalogsPagedCallable() {
    return listIcebergCatalogsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateIcebergCatalogRequest, IcebergCatalog> updateIcebergCatalogCallable() {
    return updateIcebergCatalogCallable;
  }

  @Override
  public UnaryCallable<CreateIcebergCatalogRequest, IcebergCatalog> createIcebergCatalogCallable() {
    return createIcebergCatalogCallable;
  }

  @Override
  public UnaryCallable<FailoverIcebergCatalogRequest, FailoverIcebergCatalogResponse>
      failoverIcebergCatalogCallable() {
    return failoverIcebergCatalogCallable;
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
