/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.RouterClient.AggregatedListRoutersPagedResponse;
import static com.google.cloud.compute.v1.RouterClient.ListRoutersPagedResponse;

import com.google.api.client.http.HttpMethods;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMessageHttpRequestFormatter;
import com.google.api.gax.httpjson.ApiMessageHttpResponseParser;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.compute.v1.AggregatedListRoutersHttpRequest;
import com.google.cloud.compute.v1.DeleteRouterHttpRequest;
import com.google.cloud.compute.v1.GetRouterHttpRequest;
import com.google.cloud.compute.v1.GetRouterStatusRouterHttpRequest;
import com.google.cloud.compute.v1.InsertRouterHttpRequest;
import com.google.cloud.compute.v1.ListRoutersHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRouterHttpRequest;
import com.google.cloud.compute.v1.PreviewRouterHttpRequest;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.ProjectRegionRouterName;
import com.google.cloud.compute.v1.Router;
import com.google.cloud.compute.v1.RouterAggregatedList;
import com.google.cloud.compute.v1.RouterList;
import com.google.cloud.compute.v1.RouterStatusResponse;
import com.google.cloud.compute.v1.RoutersPreviewResponse;
import com.google.cloud.compute.v1.UpdateRouterHttpRequest;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * HTTP stub implementation for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonRouterStub extends RouterStub {
  @InternalApi
  public static final ApiMethodDescriptor<AggregatedListRoutersHttpRequest, RouterAggregatedList>
      aggregatedListRoutersMethodDescriptor =
          ApiMethodDescriptor.<AggregatedListRoutersHttpRequest, RouterAggregatedList>newBuilder()
              .setFullMethodName("compute.routers.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<AggregatedListRoutersHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/aggregated/routers"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<RouterAggregatedList>newBuilder()
                      .setResponseInstance(RouterAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteRouterHttpRequest, Operation>
      deleteRouterMethodDescriptor =
          ApiMethodDescriptor.<DeleteRouterHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.routers.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteRouterHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/routers/{router}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionRouterName.newFactory())
                      .setResourceNameField("router")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetRouterHttpRequest, Router> getRouterMethodDescriptor =
      ApiMethodDescriptor.<GetRouterHttpRequest, Router>newBuilder()
          .setFullMethodName("compute.routers.get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ApiMessageHttpRequestFormatter.<GetRouterHttpRequest>newBuilder()
                  .setPathTemplate(
                      PathTemplate.create("{project}/regions/{region}/routers/{router}"))
                  .setQueryParams(Sets.<String>newHashSet())
                  .setResourceNameFactory(ProjectRegionRouterName.newFactory())
                  .setResourceNameField("router")
                  .build())
          .setResponseParser(
              ApiMessageHttpResponseParser.<Router>newBuilder()
                  .setResponseInstance(Router.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetRouterStatusRouterHttpRequest, RouterStatusResponse>
      getRouterStatusRouterMethodDescriptor =
          ApiMethodDescriptor.<GetRouterStatusRouterHttpRequest, RouterStatusResponse>newBuilder()
              .setFullMethodName("compute.routers.getRouterStatus")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetRouterStatusRouterHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/routers/{router}/getRouterStatus"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionRouterName.newFactory())
                      .setResourceNameField("router")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<RouterStatusResponse>newBuilder()
                      .setResponseInstance(RouterStatusResponse.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertRouterHttpRequest, Operation>
      insertRouterMethodDescriptor =
          ApiMethodDescriptor.<InsertRouterHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.routers.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertRouterHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/regions/{region}/routers"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListRoutersHttpRequest, RouterList>
      listRoutersMethodDescriptor =
          ApiMethodDescriptor.<ListRoutersHttpRequest, RouterList>newBuilder()
              .setFullMethodName("compute.routers.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListRoutersHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/regions/{region}/routers"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<RouterList>newBuilder()
                      .setResponseInstance(RouterList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchRouterHttpRequest, Operation>
      patchRouterMethodDescriptor =
          ApiMethodDescriptor.<PatchRouterHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.routers.patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<PatchRouterHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/routers/{router}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionRouterName.newFactory())
                      .setResourceNameField("router")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PreviewRouterHttpRequest, RoutersPreviewResponse>
      previewRouterMethodDescriptor =
          ApiMethodDescriptor.<PreviewRouterHttpRequest, RoutersPreviewResponse>newBuilder()
              .setFullMethodName("compute.routers.preview")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<PreviewRouterHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/routers/{router}/preview"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionRouterName.newFactory())
                      .setResourceNameField("router")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<RoutersPreviewResponse>newBuilder()
                      .setResponseInstance(RoutersPreviewResponse.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<UpdateRouterHttpRequest, Operation>
      updateRouterMethodDescriptor =
          ApiMethodDescriptor.<UpdateRouterHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.routers.update")
              .setHttpMethod(HttpMethods.PUT)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<UpdateRouterHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/routers/{router}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionRouterName.newFactory())
                      .setResourceNameField("router")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AggregatedListRoutersHttpRequest, RouterAggregatedList>
      aggregatedListRoutersCallable;
  private final UnaryCallable<AggregatedListRoutersHttpRequest, AggregatedListRoutersPagedResponse>
      aggregatedListRoutersPagedCallable;
  private final UnaryCallable<DeleteRouterHttpRequest, Operation> deleteRouterCallable;
  private final UnaryCallable<GetRouterHttpRequest, Router> getRouterCallable;
  private final UnaryCallable<GetRouterStatusRouterHttpRequest, RouterStatusResponse>
      getRouterStatusRouterCallable;
  private final UnaryCallable<InsertRouterHttpRequest, Operation> insertRouterCallable;
  private final UnaryCallable<ListRoutersHttpRequest, RouterList> listRoutersCallable;
  private final UnaryCallable<ListRoutersHttpRequest, ListRoutersPagedResponse>
      listRoutersPagedCallable;
  private final UnaryCallable<PatchRouterHttpRequest, Operation> patchRouterCallable;
  private final UnaryCallable<PreviewRouterHttpRequest, RoutersPreviewResponse>
      previewRouterCallable;
  private final UnaryCallable<UpdateRouterHttpRequest, Operation> updateRouterCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRouterStub create(RouterStubSettings settings) throws IOException {
    return new HttpJsonRouterStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRouterStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonRouterStub(RouterStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRouterStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRouterStub(
        RouterStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRouterStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRouterStub(RouterStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRouterCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRouterStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRouterStub(
      RouterStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListRoutersHttpRequest, RouterAggregatedList>
        aggregatedListRoutersTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListRoutersHttpRequest, RouterAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListRoutersMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteRouterHttpRequest, Operation> deleteRouterTransportSettings =
        HttpJsonCallSettings.<DeleteRouterHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRouterMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetRouterHttpRequest, Router> getRouterTransportSettings =
        HttpJsonCallSettings.<GetRouterHttpRequest, Router>newBuilder()
            .setMethodDescriptor(getRouterMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetRouterStatusRouterHttpRequest, RouterStatusResponse>
        getRouterStatusRouterTransportSettings =
            HttpJsonCallSettings
                .<GetRouterStatusRouterHttpRequest, RouterStatusResponse>newBuilder()
                .setMethodDescriptor(getRouterStatusRouterMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertRouterHttpRequest, Operation> insertRouterTransportSettings =
        HttpJsonCallSettings.<InsertRouterHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(insertRouterMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListRoutersHttpRequest, RouterList> listRoutersTransportSettings =
        HttpJsonCallSettings.<ListRoutersHttpRequest, RouterList>newBuilder()
            .setMethodDescriptor(listRoutersMethodDescriptor)
            .build();
    HttpJsonCallSettings<PatchRouterHttpRequest, Operation> patchRouterTransportSettings =
        HttpJsonCallSettings.<PatchRouterHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(patchRouterMethodDescriptor)
            .build();
    HttpJsonCallSettings<PreviewRouterHttpRequest, RoutersPreviewResponse>
        previewRouterTransportSettings =
            HttpJsonCallSettings.<PreviewRouterHttpRequest, RoutersPreviewResponse>newBuilder()
                .setMethodDescriptor(previewRouterMethodDescriptor)
                .build();
    HttpJsonCallSettings<UpdateRouterHttpRequest, Operation> updateRouterTransportSettings =
        HttpJsonCallSettings.<UpdateRouterHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(updateRouterMethodDescriptor)
            .build();

    this.aggregatedListRoutersCallable =
        callableFactory.createUnaryCallable(
            aggregatedListRoutersTransportSettings,
            settings.aggregatedListRoutersSettings(),
            clientContext);
    this.aggregatedListRoutersPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListRoutersTransportSettings,
            settings.aggregatedListRoutersSettings(),
            clientContext);
    this.deleteRouterCallable =
        callableFactory.createUnaryCallable(
            deleteRouterTransportSettings, settings.deleteRouterSettings(), clientContext);
    this.getRouterCallable =
        callableFactory.createUnaryCallable(
            getRouterTransportSettings, settings.getRouterSettings(), clientContext);
    this.getRouterStatusRouterCallable =
        callableFactory.createUnaryCallable(
            getRouterStatusRouterTransportSettings,
            settings.getRouterStatusRouterSettings(),
            clientContext);
    this.insertRouterCallable =
        callableFactory.createUnaryCallable(
            insertRouterTransportSettings, settings.insertRouterSettings(), clientContext);
    this.listRoutersCallable =
        callableFactory.createUnaryCallable(
            listRoutersTransportSettings, settings.listRoutersSettings(), clientContext);
    this.listRoutersPagedCallable =
        callableFactory.createPagedCallable(
            listRoutersTransportSettings, settings.listRoutersSettings(), clientContext);
    this.patchRouterCallable =
        callableFactory.createUnaryCallable(
            patchRouterTransportSettings, settings.patchRouterSettings(), clientContext);
    this.previewRouterCallable =
        callableFactory.createUnaryCallable(
            previewRouterTransportSettings, settings.previewRouterSettings(), clientContext);
    this.updateRouterCallable =
        callableFactory.createUnaryCallable(
            updateRouterTransportSettings, settings.updateRouterSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<AggregatedListRoutersHttpRequest, AggregatedListRoutersPagedResponse>
      aggregatedListRoutersPagedCallable() {
    return aggregatedListRoutersPagedCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListRoutersHttpRequest, RouterAggregatedList>
      aggregatedListRoutersCallable() {
    return aggregatedListRoutersCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteRouterHttpRequest, Operation> deleteRouterCallable() {
    return deleteRouterCallable;
  }

  @BetaApi
  public UnaryCallable<GetRouterHttpRequest, Router> getRouterCallable() {
    return getRouterCallable;
  }

  @BetaApi
  public UnaryCallable<GetRouterStatusRouterHttpRequest, RouterStatusResponse>
      getRouterStatusRouterCallable() {
    return getRouterStatusRouterCallable;
  }

  @BetaApi
  public UnaryCallable<InsertRouterHttpRequest, Operation> insertRouterCallable() {
    return insertRouterCallable;
  }

  @BetaApi
  public UnaryCallable<ListRoutersHttpRequest, ListRoutersPagedResponse>
      listRoutersPagedCallable() {
    return listRoutersPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListRoutersHttpRequest, RouterList> listRoutersCallable() {
    return listRoutersCallable;
  }

  @BetaApi
  public UnaryCallable<PatchRouterHttpRequest, Operation> patchRouterCallable() {
    return patchRouterCallable;
  }

  @BetaApi
  public UnaryCallable<PreviewRouterHttpRequest, RoutersPreviewResponse> previewRouterCallable() {
    return previewRouterCallable;
  }

  @BetaApi
  public UnaryCallable<UpdateRouterHttpRequest, Operation> updateRouterCallable() {
    return updateRouterCallable;
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
