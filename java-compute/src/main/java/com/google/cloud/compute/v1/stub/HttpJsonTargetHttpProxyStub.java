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

import static com.google.cloud.compute.v1.TargetHttpProxyClient.AggregatedListTargetHttpProxiesPagedResponse;
import static com.google.cloud.compute.v1.TargetHttpProxyClient.ListTargetHttpProxiesPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListTargetHttpProxiesHttpRequest;
import com.google.cloud.compute.v1.DeleteTargetHttpProxyHttpRequest;
import com.google.cloud.compute.v1.GetTargetHttpProxyHttpRequest;
import com.google.cloud.compute.v1.InsertTargetHttpProxyHttpRequest;
import com.google.cloud.compute.v1.ListTargetHttpProxiesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectGlobalTargetHttpProxyName;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectTargetHttpProxyName;
import com.google.cloud.compute.v1.SetUrlMapTargetHttpProxyHttpRequest;
import com.google.cloud.compute.v1.TargetHttpProxy;
import com.google.cloud.compute.v1.TargetHttpProxyAggregatedList;
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
public class HttpJsonTargetHttpProxyStub extends TargetHttpProxyStub {
  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListTargetHttpProxiesHttpRequest, TargetHttpProxyAggregatedList>
      aggregatedListTargetHttpProxiesMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListTargetHttpProxiesHttpRequest, TargetHttpProxyAggregatedList>
                  newBuilder()
              .setFullMethodName("compute.targetHttpProxies.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<AggregatedListTargetHttpProxiesHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/aggregated/targetHttpProxies"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetHttpProxyAggregatedList>newBuilder()
                      .setResponseInstance(TargetHttpProxyAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteTargetHttpProxyHttpRequest, Operation>
      deleteTargetHttpProxyMethodDescriptor =
          ApiMethodDescriptor.<DeleteTargetHttpProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetHttpProxies.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteTargetHttpProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/targetHttpProxies/{targetHttpProxy}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalTargetHttpProxyName.newFactory())
                      .setResourceNameField("targetHttpProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetTargetHttpProxyHttpRequest, TargetHttpProxy>
      getTargetHttpProxyMethodDescriptor =
          ApiMethodDescriptor.<GetTargetHttpProxyHttpRequest, TargetHttpProxy>newBuilder()
              .setFullMethodName("compute.targetHttpProxies.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetTargetHttpProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/targetHttpProxies/{targetHttpProxy}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalTargetHttpProxyName.newFactory())
                      .setResourceNameField("targetHttpProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetHttpProxy>newBuilder()
                      .setResponseInstance(TargetHttpProxy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertTargetHttpProxyHttpRequest, Operation>
      insertTargetHttpProxyMethodDescriptor =
          ApiMethodDescriptor.<InsertTargetHttpProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetHttpProxies.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertTargetHttpProxyHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/targetHttpProxies"))
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
  public static final ApiMethodDescriptor<ListTargetHttpProxiesHttpRequest, TargetHttpProxyList>
      listTargetHttpProxiesMethodDescriptor =
          ApiMethodDescriptor.<ListTargetHttpProxiesHttpRequest, TargetHttpProxyList>newBuilder()
              .setFullMethodName("compute.targetHttpProxies.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListTargetHttpProxiesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/targetHttpProxies"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetHttpProxyList>newBuilder()
                      .setResponseInstance(TargetHttpProxyList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetUrlMapTargetHttpProxyHttpRequest, Operation>
      setUrlMapTargetHttpProxyMethodDescriptor =
          ApiMethodDescriptor.<SetUrlMapTargetHttpProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetHttpProxies.setUrlMap")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<SetUrlMapTargetHttpProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/targetHttpProxies/{targetHttpProxy}/setUrlMap"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectTargetHttpProxyName.newFactory())
                      .setResourceNameField("targetHttpProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<
          AggregatedListTargetHttpProxiesHttpRequest, TargetHttpProxyAggregatedList>
      aggregatedListTargetHttpProxiesCallable;
  private final UnaryCallable<
          AggregatedListTargetHttpProxiesHttpRequest, AggregatedListTargetHttpProxiesPagedResponse>
      aggregatedListTargetHttpProxiesPagedCallable;
  private final UnaryCallable<DeleteTargetHttpProxyHttpRequest, Operation>
      deleteTargetHttpProxyCallable;
  private final UnaryCallable<GetTargetHttpProxyHttpRequest, TargetHttpProxy>
      getTargetHttpProxyCallable;
  private final UnaryCallable<InsertTargetHttpProxyHttpRequest, Operation>
      insertTargetHttpProxyCallable;
  private final UnaryCallable<ListTargetHttpProxiesHttpRequest, TargetHttpProxyList>
      listTargetHttpProxiesCallable;
  private final UnaryCallable<ListTargetHttpProxiesHttpRequest, ListTargetHttpProxiesPagedResponse>
      listTargetHttpProxiesPagedCallable;
  private final UnaryCallable<SetUrlMapTargetHttpProxyHttpRequest, Operation>
      setUrlMapTargetHttpProxyCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTargetHttpProxyStub create(TargetHttpProxyStubSettings settings)
      throws IOException {
    return new HttpJsonTargetHttpProxyStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTargetHttpProxyStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTargetHttpProxyStub(
        TargetHttpProxyStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonTargetHttpProxyStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTargetHttpProxyStub(
        TargetHttpProxyStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTargetHttpProxyStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetHttpProxyStub(
      TargetHttpProxyStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonTargetHttpProxyCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTargetHttpProxyStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetHttpProxyStub(
      TargetHttpProxyStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListTargetHttpProxiesHttpRequest, TargetHttpProxyAggregatedList>
        aggregatedListTargetHttpProxiesTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListTargetHttpProxiesHttpRequest, TargetHttpProxyAggregatedList>
                    newBuilder()
                .setMethodDescriptor(aggregatedListTargetHttpProxiesMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteTargetHttpProxyHttpRequest, Operation>
        deleteTargetHttpProxyTransportSettings =
            HttpJsonCallSettings.<DeleteTargetHttpProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteTargetHttpProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetTargetHttpProxyHttpRequest, TargetHttpProxy>
        getTargetHttpProxyTransportSettings =
            HttpJsonCallSettings.<GetTargetHttpProxyHttpRequest, TargetHttpProxy>newBuilder()
                .setMethodDescriptor(getTargetHttpProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertTargetHttpProxyHttpRequest, Operation>
        insertTargetHttpProxyTransportSettings =
            HttpJsonCallSettings.<InsertTargetHttpProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertTargetHttpProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListTargetHttpProxiesHttpRequest, TargetHttpProxyList>
        listTargetHttpProxiesTransportSettings =
            HttpJsonCallSettings.<ListTargetHttpProxiesHttpRequest, TargetHttpProxyList>newBuilder()
                .setMethodDescriptor(listTargetHttpProxiesMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetUrlMapTargetHttpProxyHttpRequest, Operation>
        setUrlMapTargetHttpProxyTransportSettings =
            HttpJsonCallSettings.<SetUrlMapTargetHttpProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setUrlMapTargetHttpProxyMethodDescriptor)
                .build();

    this.aggregatedListTargetHttpProxiesCallable =
        callableFactory.createUnaryCallable(
            aggregatedListTargetHttpProxiesTransportSettings,
            settings.aggregatedListTargetHttpProxiesSettings(),
            clientContext);
    this.aggregatedListTargetHttpProxiesPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListTargetHttpProxiesTransportSettings,
            settings.aggregatedListTargetHttpProxiesSettings(),
            clientContext);
    this.deleteTargetHttpProxyCallable =
        callableFactory.createUnaryCallable(
            deleteTargetHttpProxyTransportSettings,
            settings.deleteTargetHttpProxySettings(),
            clientContext);
    this.getTargetHttpProxyCallable =
        callableFactory.createUnaryCallable(
            getTargetHttpProxyTransportSettings,
            settings.getTargetHttpProxySettings(),
            clientContext);
    this.insertTargetHttpProxyCallable =
        callableFactory.createUnaryCallable(
            insertTargetHttpProxyTransportSettings,
            settings.insertTargetHttpProxySettings(),
            clientContext);
    this.listTargetHttpProxiesCallable =
        callableFactory.createUnaryCallable(
            listTargetHttpProxiesTransportSettings,
            settings.listTargetHttpProxiesSettings(),
            clientContext);
    this.listTargetHttpProxiesPagedCallable =
        callableFactory.createPagedCallable(
            listTargetHttpProxiesTransportSettings,
            settings.listTargetHttpProxiesSettings(),
            clientContext);
    this.setUrlMapTargetHttpProxyCallable =
        callableFactory.createUnaryCallable(
            setUrlMapTargetHttpProxyTransportSettings,
            settings.setUrlMapTargetHttpProxySettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<
          AggregatedListTargetHttpProxiesHttpRequest, AggregatedListTargetHttpProxiesPagedResponse>
      aggregatedListTargetHttpProxiesPagedCallable() {
    return aggregatedListTargetHttpProxiesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListTargetHttpProxiesHttpRequest, TargetHttpProxyAggregatedList>
      aggregatedListTargetHttpProxiesCallable() {
    return aggregatedListTargetHttpProxiesCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteTargetHttpProxyHttpRequest, Operation>
      deleteTargetHttpProxyCallable() {
    return deleteTargetHttpProxyCallable;
  }

  @BetaApi
  public UnaryCallable<GetTargetHttpProxyHttpRequest, TargetHttpProxy>
      getTargetHttpProxyCallable() {
    return getTargetHttpProxyCallable;
  }

  @BetaApi
  public UnaryCallable<InsertTargetHttpProxyHttpRequest, Operation>
      insertTargetHttpProxyCallable() {
    return insertTargetHttpProxyCallable;
  }

  @BetaApi
  public UnaryCallable<ListTargetHttpProxiesHttpRequest, ListTargetHttpProxiesPagedResponse>
      listTargetHttpProxiesPagedCallable() {
    return listTargetHttpProxiesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListTargetHttpProxiesHttpRequest, TargetHttpProxyList>
      listTargetHttpProxiesCallable() {
    return listTargetHttpProxiesCallable;
  }

  @BetaApi
  public UnaryCallable<SetUrlMapTargetHttpProxyHttpRequest, Operation>
      setUrlMapTargetHttpProxyCallable() {
    return setUrlMapTargetHttpProxyCallable;
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
