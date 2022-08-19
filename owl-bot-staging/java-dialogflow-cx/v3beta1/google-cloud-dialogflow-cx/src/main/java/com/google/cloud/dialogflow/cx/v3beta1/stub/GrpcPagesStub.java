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

package com.google.cloud.dialogflow.cx.v3beta1.stub;

import static com.google.cloud.dialogflow.cx.v3beta1.PagesClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.PagesClient.ListPagesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3beta1.CreatePageRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeletePageRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetPageRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListPagesRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListPagesResponse;
import com.google.cloud.dialogflow.cx.v3beta1.Page;
import com.google.cloud.dialogflow.cx.v3beta1.UpdatePageRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
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
 * gRPC stub implementation for the Pages service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcPagesStub extends PagesStub {
  private static final MethodDescriptor<ListPagesRequest, ListPagesResponse>
      listPagesMethodDescriptor =
          MethodDescriptor.<ListPagesRequest, ListPagesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Pages/ListPages")
              .setRequestMarshaller(ProtoUtils.marshaller(ListPagesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListPagesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPageRequest, Page> getPageMethodDescriptor =
      MethodDescriptor.<GetPageRequest, Page>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Pages/GetPage")
          .setRequestMarshaller(ProtoUtils.marshaller(GetPageRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Page.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreatePageRequest, Page> createPageMethodDescriptor =
      MethodDescriptor.<CreatePageRequest, Page>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Pages/CreatePage")
          .setRequestMarshaller(ProtoUtils.marshaller(CreatePageRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Page.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdatePageRequest, Page> updatePageMethodDescriptor =
      MethodDescriptor.<UpdatePageRequest, Page>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Pages/UpdatePage")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdatePageRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Page.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeletePageRequest, Empty> deletePageMethodDescriptor =
      MethodDescriptor.<DeletePageRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Pages/DeletePage")
          .setRequestMarshaller(ProtoUtils.marshaller(DeletePageRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
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
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private final UnaryCallable<ListPagesRequest, ListPagesResponse> listPagesCallable;
  private final UnaryCallable<ListPagesRequest, ListPagesPagedResponse> listPagesPagedCallable;
  private final UnaryCallable<GetPageRequest, Page> getPageCallable;
  private final UnaryCallable<CreatePageRequest, Page> createPageCallable;
  private final UnaryCallable<UpdatePageRequest, Page> updatePageCallable;
  private final UnaryCallable<DeletePageRequest, Empty> deletePageCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcPagesStub create(PagesStubSettings settings) throws IOException {
    return new GrpcPagesStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPagesStub create(ClientContext clientContext) throws IOException {
    return new GrpcPagesStub(PagesStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPagesStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPagesStub(
        PagesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcPagesStub, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcPagesStub(PagesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcPagesCallableFactory());
  }

  /**
   * Constructs an instance of GrpcPagesStub, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcPagesStub(
      PagesStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListPagesRequest, ListPagesResponse> listPagesTransportSettings =
        GrpcCallSettings.<ListPagesRequest, ListPagesResponse>newBuilder()
            .setMethodDescriptor(listPagesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetPageRequest, Page> getPageTransportSettings =
        GrpcCallSettings.<GetPageRequest, Page>newBuilder()
            .setMethodDescriptor(getPageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreatePageRequest, Page> createPageTransportSettings =
        GrpcCallSettings.<CreatePageRequest, Page>newBuilder()
            .setMethodDescriptor(createPageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdatePageRequest, Page> updatePageTransportSettings =
        GrpcCallSettings.<UpdatePageRequest, Page>newBuilder()
            .setMethodDescriptor(updatePageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("page.name", String.valueOf(request.getPage().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeletePageRequest, Empty> deletePageTransportSettings =
        GrpcCallSettings.<DeletePageRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.listPagesCallable =
        callableFactory.createUnaryCallable(
            listPagesTransportSettings, settings.listPagesSettings(), clientContext);
    this.listPagesPagedCallable =
        callableFactory.createPagedCallable(
            listPagesTransportSettings, settings.listPagesSettings(), clientContext);
    this.getPageCallable =
        callableFactory.createUnaryCallable(
            getPageTransportSettings, settings.getPageSettings(), clientContext);
    this.createPageCallable =
        callableFactory.createUnaryCallable(
            createPageTransportSettings, settings.createPageSettings(), clientContext);
    this.updatePageCallable =
        callableFactory.createUnaryCallable(
            updatePageTransportSettings, settings.updatePageSettings(), clientContext);
    this.deletePageCallable =
        callableFactory.createUnaryCallable(
            deletePageTransportSettings, settings.deletePageSettings(), clientContext);
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
  public UnaryCallable<ListPagesRequest, ListPagesResponse> listPagesCallable() {
    return listPagesCallable;
  }

  @Override
  public UnaryCallable<ListPagesRequest, ListPagesPagedResponse> listPagesPagedCallable() {
    return listPagesPagedCallable;
  }

  @Override
  public UnaryCallable<GetPageRequest, Page> getPageCallable() {
    return getPageCallable;
  }

  @Override
  public UnaryCallable<CreatePageRequest, Page> createPageCallable() {
    return createPageCallable;
  }

  @Override
  public UnaryCallable<UpdatePageRequest, Page> updatePageCallable() {
    return updatePageCallable;
  }

  @Override
  public UnaryCallable<DeletePageRequest, Empty> deletePageCallable() {
    return deletePageCallable;
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
