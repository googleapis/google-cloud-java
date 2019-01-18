/*
 * Copyright 2019 Google LLC
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

import static com.google.cloud.compute.v1.RegionClient.ListRegionsPagedResponse;

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
import com.google.cloud.compute.v1.GetRegionHttpRequest;
import com.google.cloud.compute.v1.ListRegionsHttpRequest;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.Region;
import com.google.cloud.compute.v1.RegionList;
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
public class HttpJsonRegionStub extends RegionStub {
  @InternalApi
  public static final ApiMethodDescriptor<GetRegionHttpRequest, Region> getRegionMethodDescriptor =
      ApiMethodDescriptor.<GetRegionHttpRequest, Region>newBuilder()
          .setFullMethodName("compute.regions.get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ApiMessageHttpRequestFormatter.<GetRegionHttpRequest>newBuilder()
                  .setPathTemplate(PathTemplate.create("{project}/regions/{region}"))
                  .setQueryParams(Sets.<String>newHashSet())
                  .setResourceNameFactory(ProjectRegionName.newFactory())
                  .setResourceNameField("region")
                  .build())
          .setResponseParser(
              ApiMessageHttpResponseParser.<Region>newBuilder()
                  .setResponseInstance(Region.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListRegionsHttpRequest, RegionList>
      listRegionsMethodDescriptor =
          ApiMethodDescriptor.<ListRegionsHttpRequest, RegionList>newBuilder()
              .setFullMethodName("compute.regions.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListRegionsHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/regions"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<RegionList>newBuilder()
                      .setResponseInstance(RegionList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<GetRegionHttpRequest, Region> getRegionCallable;
  private final UnaryCallable<ListRegionsHttpRequest, RegionList> listRegionsCallable;
  private final UnaryCallable<ListRegionsHttpRequest, ListRegionsPagedResponse>
      listRegionsPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionStub create(RegionStubSettings settings) throws IOException {
    return new HttpJsonRegionStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonRegionStub(RegionStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionStub(
        RegionStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRegionStub(RegionStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRegionCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRegionStub(
      RegionStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetRegionHttpRequest, Region> getRegionTransportSettings =
        HttpJsonCallSettings.<GetRegionHttpRequest, Region>newBuilder()
            .setMethodDescriptor(getRegionMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListRegionsHttpRequest, RegionList> listRegionsTransportSettings =
        HttpJsonCallSettings.<ListRegionsHttpRequest, RegionList>newBuilder()
            .setMethodDescriptor(listRegionsMethodDescriptor)
            .build();

    this.getRegionCallable =
        callableFactory.createUnaryCallable(
            getRegionTransportSettings, settings.getRegionSettings(), clientContext);
    this.listRegionsCallable =
        callableFactory.createUnaryCallable(
            listRegionsTransportSettings, settings.listRegionsSettings(), clientContext);
    this.listRegionsPagedCallable =
        callableFactory.createPagedCallable(
            listRegionsTransportSettings, settings.listRegionsSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<GetRegionHttpRequest, Region> getRegionCallable() {
    return getRegionCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionsHttpRequest, ListRegionsPagedResponse>
      listRegionsPagedCallable() {
    return listRegionsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionsHttpRequest, RegionList> listRegionsCallable() {
    return listRegionsCallable;
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
