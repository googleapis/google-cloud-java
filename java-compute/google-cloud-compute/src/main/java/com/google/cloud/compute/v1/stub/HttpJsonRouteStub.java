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

import static com.google.cloud.compute.v1.RouteClient.ListRoutesPagedResponse;

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
import com.google.cloud.compute.v1.DeleteRouteHttpRequest;
import com.google.cloud.compute.v1.GetRouteHttpRequest;
import com.google.cloud.compute.v1.InsertRouteHttpRequest;
import com.google.cloud.compute.v1.ListRoutesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectGlobalRouteName;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.Route;
import com.google.cloud.compute.v1.RouteList;
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
public class HttpJsonRouteStub extends RouteStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteRouteHttpRequest, Operation>
      deleteRouteMethodDescriptor =
          ApiMethodDescriptor.<DeleteRouteHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.routes.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteRouteHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/routes/{route}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalRouteName.newFactory())
                      .setResourceNameField("route")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetRouteHttpRequest, Route> getRouteMethodDescriptor =
      ApiMethodDescriptor.<GetRouteHttpRequest, Route>newBuilder()
          .setFullMethodName("compute.routes.get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ApiMessageHttpRequestFormatter.<GetRouteHttpRequest>newBuilder()
                  .setPathTemplate(PathTemplate.create("{project}/global/routes/{route}"))
                  .setQueryParams(Sets.<String>newHashSet())
                  .setResourceNameFactory(ProjectGlobalRouteName.newFactory())
                  .setResourceNameField("route")
                  .build())
          .setResponseParser(
              ApiMessageHttpResponseParser.<Route>newBuilder()
                  .setResponseInstance(Route.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertRouteHttpRequest, Operation>
      insertRouteMethodDescriptor =
          ApiMethodDescriptor.<InsertRouteHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.routes.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertRouteHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/routes"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListRoutesHttpRequest, RouteList>
      listRoutesMethodDescriptor =
          ApiMethodDescriptor.<ListRoutesHttpRequest, RouteList>newBuilder()
              .setFullMethodName("compute.routes.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListRoutesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/routes"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<RouteList>newBuilder()
                      .setResponseInstance(RouteList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteRouteHttpRequest, Operation> deleteRouteCallable;
  private final UnaryCallable<GetRouteHttpRequest, Route> getRouteCallable;
  private final UnaryCallable<InsertRouteHttpRequest, Operation> insertRouteCallable;
  private final UnaryCallable<ListRoutesHttpRequest, RouteList> listRoutesCallable;
  private final UnaryCallable<ListRoutesHttpRequest, ListRoutesPagedResponse>
      listRoutesPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRouteStub create(RouteStubSettings settings) throws IOException {
    return new HttpJsonRouteStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRouteStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonRouteStub(RouteStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRouteStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRouteStub(
        RouteStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRouteStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRouteStub(RouteStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRouteCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRouteStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRouteStub(
      RouteStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteRouteHttpRequest, Operation> deleteRouteTransportSettings =
        HttpJsonCallSettings.<DeleteRouteHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRouteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetRouteHttpRequest, Route> getRouteTransportSettings =
        HttpJsonCallSettings.<GetRouteHttpRequest, Route>newBuilder()
            .setMethodDescriptor(getRouteMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertRouteHttpRequest, Operation> insertRouteTransportSettings =
        HttpJsonCallSettings.<InsertRouteHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(insertRouteMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListRoutesHttpRequest, RouteList> listRoutesTransportSettings =
        HttpJsonCallSettings.<ListRoutesHttpRequest, RouteList>newBuilder()
            .setMethodDescriptor(listRoutesMethodDescriptor)
            .build();

    this.deleteRouteCallable =
        callableFactory.createUnaryCallable(
            deleteRouteTransportSettings, settings.deleteRouteSettings(), clientContext);
    this.getRouteCallable =
        callableFactory.createUnaryCallable(
            getRouteTransportSettings, settings.getRouteSettings(), clientContext);
    this.insertRouteCallable =
        callableFactory.createUnaryCallable(
            insertRouteTransportSettings, settings.insertRouteSettings(), clientContext);
    this.listRoutesCallable =
        callableFactory.createUnaryCallable(
            listRoutesTransportSettings, settings.listRoutesSettings(), clientContext);
    this.listRoutesPagedCallable =
        callableFactory.createPagedCallable(
            listRoutesTransportSettings, settings.listRoutesSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteRouteHttpRequest, Operation> deleteRouteCallable() {
    return deleteRouteCallable;
  }

  @BetaApi
  public UnaryCallable<GetRouteHttpRequest, Route> getRouteCallable() {
    return getRouteCallable;
  }

  @BetaApi
  public UnaryCallable<InsertRouteHttpRequest, Operation> insertRouteCallable() {
    return insertRouteCallable;
  }

  @BetaApi
  public UnaryCallable<ListRoutesHttpRequest, ListRoutesPagedResponse> listRoutesPagedCallable() {
    return listRoutesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListRoutesHttpRequest, RouteList> listRoutesCallable() {
    return listRoutesCallable;
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
