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

import static com.google.cloud.compute.v1.RegionTargetHttpProxyClient.ListRegionTargetHttpProxiesPagedResponse;

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
import com.google.cloud.compute.v1.DeleteRegionTargetHttpProxyHttpRequest;
import com.google.cloud.compute.v1.GetRegionTargetHttpProxyHttpRequest;
import com.google.cloud.compute.v1.InsertRegionTargetHttpProxyHttpRequest;
import com.google.cloud.compute.v1.ListRegionTargetHttpProxiesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.ProjectRegionTargetHttpProxyName;
import com.google.cloud.compute.v1.SetUrlMapRegionTargetHttpProxyHttpRequest;
import com.google.cloud.compute.v1.TargetHttpProxy;
import com.google.cloud.compute.v1.TargetHttpProxyList;
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
public class HttpJsonRegionTargetHttpProxyStub extends RegionTargetHttpProxyStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteRegionTargetHttpProxyHttpRequest, Operation>
      deleteRegionTargetHttpProxyMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionTargetHttpProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionTargetHttpProxies.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<DeleteRegionTargetHttpProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/targetHttpProxies/{targetHttpProxy}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionTargetHttpProxyName.newFactory())
                      .setResourceNameField("targetHttpProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetRegionTargetHttpProxyHttpRequest, TargetHttpProxy>
      getRegionTargetHttpProxyMethodDescriptor =
          ApiMethodDescriptor.<GetRegionTargetHttpProxyHttpRequest, TargetHttpProxy>newBuilder()
              .setFullMethodName("compute.regionTargetHttpProxies.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetRegionTargetHttpProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/targetHttpProxies/{targetHttpProxy}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionTargetHttpProxyName.newFactory())
                      .setResourceNameField("targetHttpProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetHttpProxy>newBuilder()
                      .setResponseInstance(TargetHttpProxy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertRegionTargetHttpProxyHttpRequest, Operation>
      insertRegionTargetHttpProxyMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionTargetHttpProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionTargetHttpProxies.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<InsertRegionTargetHttpProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/targetHttpProxies"))
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
  public static final ApiMethodDescriptor<
          ListRegionTargetHttpProxiesHttpRequest, TargetHttpProxyList>
      listRegionTargetHttpProxiesMethodDescriptor =
          ApiMethodDescriptor
              .<ListRegionTargetHttpProxiesHttpRequest, TargetHttpProxyList>newBuilder()
              .setFullMethodName("compute.regionTargetHttpProxies.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<ListRegionTargetHttpProxiesHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/targetHttpProxies"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetHttpProxyList>newBuilder()
                      .setResponseInstance(TargetHttpProxyList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetUrlMapRegionTargetHttpProxyHttpRequest, Operation>
      setUrlMapRegionTargetHttpProxyMethodDescriptor =
          ApiMethodDescriptor.<SetUrlMapRegionTargetHttpProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionTargetHttpProxies.setUrlMap")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<SetUrlMapRegionTargetHttpProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/targetHttpProxies/{targetHttpProxy}/setUrlMap"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionTargetHttpProxyName.newFactory())
                      .setResourceNameField("targetHttpProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteRegionTargetHttpProxyHttpRequest, Operation>
      deleteRegionTargetHttpProxyCallable;
  private final UnaryCallable<GetRegionTargetHttpProxyHttpRequest, TargetHttpProxy>
      getRegionTargetHttpProxyCallable;
  private final UnaryCallable<InsertRegionTargetHttpProxyHttpRequest, Operation>
      insertRegionTargetHttpProxyCallable;
  private final UnaryCallable<ListRegionTargetHttpProxiesHttpRequest, TargetHttpProxyList>
      listRegionTargetHttpProxiesCallable;
  private final UnaryCallable<
          ListRegionTargetHttpProxiesHttpRequest, ListRegionTargetHttpProxiesPagedResponse>
      listRegionTargetHttpProxiesPagedCallable;
  private final UnaryCallable<SetUrlMapRegionTargetHttpProxyHttpRequest, Operation>
      setUrlMapRegionTargetHttpProxyCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionTargetHttpProxyStub create(
      RegionTargetHttpProxyStubSettings settings) throws IOException {
    return new HttpJsonRegionTargetHttpProxyStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionTargetHttpProxyStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionTargetHttpProxyStub(
        RegionTargetHttpProxyStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionTargetHttpProxyStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionTargetHttpProxyStub(
        RegionTargetHttpProxyStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionTargetHttpProxyStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionTargetHttpProxyStub(
      RegionTargetHttpProxyStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRegionTargetHttpProxyCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionTargetHttpProxyStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionTargetHttpProxyStub(
      RegionTargetHttpProxyStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteRegionTargetHttpProxyHttpRequest, Operation>
        deleteRegionTargetHttpProxyTransportSettings =
            HttpJsonCallSettings.<DeleteRegionTargetHttpProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteRegionTargetHttpProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetRegionTargetHttpProxyHttpRequest, TargetHttpProxy>
        getRegionTargetHttpProxyTransportSettings =
            HttpJsonCallSettings.<GetRegionTargetHttpProxyHttpRequest, TargetHttpProxy>newBuilder()
                .setMethodDescriptor(getRegionTargetHttpProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertRegionTargetHttpProxyHttpRequest, Operation>
        insertRegionTargetHttpProxyTransportSettings =
            HttpJsonCallSettings.<InsertRegionTargetHttpProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertRegionTargetHttpProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListRegionTargetHttpProxiesHttpRequest, TargetHttpProxyList>
        listRegionTargetHttpProxiesTransportSettings =
            HttpJsonCallSettings
                .<ListRegionTargetHttpProxiesHttpRequest, TargetHttpProxyList>newBuilder()
                .setMethodDescriptor(listRegionTargetHttpProxiesMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetUrlMapRegionTargetHttpProxyHttpRequest, Operation>
        setUrlMapRegionTargetHttpProxyTransportSettings =
            HttpJsonCallSettings.<SetUrlMapRegionTargetHttpProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setUrlMapRegionTargetHttpProxyMethodDescriptor)
                .build();

    this.deleteRegionTargetHttpProxyCallable =
        callableFactory.createUnaryCallable(
            deleteRegionTargetHttpProxyTransportSettings,
            settings.deleteRegionTargetHttpProxySettings(),
            clientContext);
    this.getRegionTargetHttpProxyCallable =
        callableFactory.createUnaryCallable(
            getRegionTargetHttpProxyTransportSettings,
            settings.getRegionTargetHttpProxySettings(),
            clientContext);
    this.insertRegionTargetHttpProxyCallable =
        callableFactory.createUnaryCallable(
            insertRegionTargetHttpProxyTransportSettings,
            settings.insertRegionTargetHttpProxySettings(),
            clientContext);
    this.listRegionTargetHttpProxiesCallable =
        callableFactory.createUnaryCallable(
            listRegionTargetHttpProxiesTransportSettings,
            settings.listRegionTargetHttpProxiesSettings(),
            clientContext);
    this.listRegionTargetHttpProxiesPagedCallable =
        callableFactory.createPagedCallable(
            listRegionTargetHttpProxiesTransportSettings,
            settings.listRegionTargetHttpProxiesSettings(),
            clientContext);
    this.setUrlMapRegionTargetHttpProxyCallable =
        callableFactory.createUnaryCallable(
            setUrlMapRegionTargetHttpProxyTransportSettings,
            settings.setUrlMapRegionTargetHttpProxySettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteRegionTargetHttpProxyHttpRequest, Operation>
      deleteRegionTargetHttpProxyCallable() {
    return deleteRegionTargetHttpProxyCallable;
  }

  @BetaApi
  public UnaryCallable<GetRegionTargetHttpProxyHttpRequest, TargetHttpProxy>
      getRegionTargetHttpProxyCallable() {
    return getRegionTargetHttpProxyCallable;
  }

  @BetaApi
  public UnaryCallable<InsertRegionTargetHttpProxyHttpRequest, Operation>
      insertRegionTargetHttpProxyCallable() {
    return insertRegionTargetHttpProxyCallable;
  }

  @BetaApi
  public UnaryCallable<
          ListRegionTargetHttpProxiesHttpRequest, ListRegionTargetHttpProxiesPagedResponse>
      listRegionTargetHttpProxiesPagedCallable() {
    return listRegionTargetHttpProxiesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionTargetHttpProxiesHttpRequest, TargetHttpProxyList>
      listRegionTargetHttpProxiesCallable() {
    return listRegionTargetHttpProxiesCallable;
  }

  @BetaApi
  public UnaryCallable<SetUrlMapRegionTargetHttpProxyHttpRequest, Operation>
      setUrlMapRegionTargetHttpProxyCallable() {
    return setUrlMapRegionTargetHttpProxyCallable;
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
