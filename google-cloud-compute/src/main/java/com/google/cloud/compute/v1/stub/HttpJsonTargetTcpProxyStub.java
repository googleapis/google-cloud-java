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

import static com.google.cloud.compute.v1.TargetTcpProxyClient.ListTargetTcpProxiesPagedResponse;

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
import com.google.cloud.compute.v1.DeleteTargetTcpProxyHttpRequest;
import com.google.cloud.compute.v1.GetTargetTcpProxyHttpRequest;
import com.google.cloud.compute.v1.InsertTargetTcpProxyHttpRequest;
import com.google.cloud.compute.v1.ListTargetTcpProxiesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectGlobalTargetTcpProxyName;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.SetBackendServiceTargetTcpProxyHttpRequest;
import com.google.cloud.compute.v1.SetProxyHeaderTargetTcpProxyHttpRequest;
import com.google.cloud.compute.v1.TargetTcpProxy;
import com.google.cloud.compute.v1.TargetTcpProxyList;
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
public class HttpJsonTargetTcpProxyStub extends TargetTcpProxyStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteTargetTcpProxyHttpRequest, Operation>
      deleteTargetTcpProxyMethodDescriptor =
          ApiMethodDescriptor.<DeleteTargetTcpProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetTcpProxies.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteTargetTcpProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/targetTcpProxies/{targetTcpProxy}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalTargetTcpProxyName.newFactory())
                      .setResourceNameField("targetTcpProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetTargetTcpProxyHttpRequest, TargetTcpProxy>
      getTargetTcpProxyMethodDescriptor =
          ApiMethodDescriptor.<GetTargetTcpProxyHttpRequest, TargetTcpProxy>newBuilder()
              .setFullMethodName("compute.targetTcpProxies.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetTargetTcpProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/targetTcpProxies/{targetTcpProxy}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalTargetTcpProxyName.newFactory())
                      .setResourceNameField("targetTcpProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetTcpProxy>newBuilder()
                      .setResponseInstance(TargetTcpProxy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertTargetTcpProxyHttpRequest, Operation>
      insertTargetTcpProxyMethodDescriptor =
          ApiMethodDescriptor.<InsertTargetTcpProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetTcpProxies.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertTargetTcpProxyHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/targetTcpProxies"))
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
  public static final ApiMethodDescriptor<ListTargetTcpProxiesHttpRequest, TargetTcpProxyList>
      listTargetTcpProxiesMethodDescriptor =
          ApiMethodDescriptor.<ListTargetTcpProxiesHttpRequest, TargetTcpProxyList>newBuilder()
              .setFullMethodName("compute.targetTcpProxies.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListTargetTcpProxiesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/targetTcpProxies"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetTcpProxyList>newBuilder()
                      .setResponseInstance(TargetTcpProxyList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetBackendServiceTargetTcpProxyHttpRequest, Operation>
      setBackendServiceTargetTcpProxyMethodDescriptor =
          ApiMethodDescriptor.<SetBackendServiceTargetTcpProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetTcpProxies.setBackendService")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<SetBackendServiceTargetTcpProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/targetTcpProxies/{targetTcpProxy}/setBackendService"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalTargetTcpProxyName.newFactory())
                      .setResourceNameField("targetTcpProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetProxyHeaderTargetTcpProxyHttpRequest, Operation>
      setProxyHeaderTargetTcpProxyMethodDescriptor =
          ApiMethodDescriptor.<SetProxyHeaderTargetTcpProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetTcpProxies.setProxyHeader")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<SetProxyHeaderTargetTcpProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/targetTcpProxies/{targetTcpProxy}/setProxyHeader"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalTargetTcpProxyName.newFactory())
                      .setResourceNameField("targetTcpProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteTargetTcpProxyHttpRequest, Operation>
      deleteTargetTcpProxyCallable;
  private final UnaryCallable<GetTargetTcpProxyHttpRequest, TargetTcpProxy>
      getTargetTcpProxyCallable;
  private final UnaryCallable<InsertTargetTcpProxyHttpRequest, Operation>
      insertTargetTcpProxyCallable;
  private final UnaryCallable<ListTargetTcpProxiesHttpRequest, TargetTcpProxyList>
      listTargetTcpProxiesCallable;
  private final UnaryCallable<ListTargetTcpProxiesHttpRequest, ListTargetTcpProxiesPagedResponse>
      listTargetTcpProxiesPagedCallable;
  private final UnaryCallable<SetBackendServiceTargetTcpProxyHttpRequest, Operation>
      setBackendServiceTargetTcpProxyCallable;
  private final UnaryCallable<SetProxyHeaderTargetTcpProxyHttpRequest, Operation>
      setProxyHeaderTargetTcpProxyCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTargetTcpProxyStub create(TargetTcpProxyStubSettings settings)
      throws IOException {
    return new HttpJsonTargetTcpProxyStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTargetTcpProxyStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTargetTcpProxyStub(
        TargetTcpProxyStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonTargetTcpProxyStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTargetTcpProxyStub(
        TargetTcpProxyStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTargetTcpProxyStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetTcpProxyStub(
      TargetTcpProxyStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonTargetTcpProxyCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTargetTcpProxyStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetTcpProxyStub(
      TargetTcpProxyStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteTargetTcpProxyHttpRequest, Operation>
        deleteTargetTcpProxyTransportSettings =
            HttpJsonCallSettings.<DeleteTargetTcpProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteTargetTcpProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetTargetTcpProxyHttpRequest, TargetTcpProxy>
        getTargetTcpProxyTransportSettings =
            HttpJsonCallSettings.<GetTargetTcpProxyHttpRequest, TargetTcpProxy>newBuilder()
                .setMethodDescriptor(getTargetTcpProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertTargetTcpProxyHttpRequest, Operation>
        insertTargetTcpProxyTransportSettings =
            HttpJsonCallSettings.<InsertTargetTcpProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertTargetTcpProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListTargetTcpProxiesHttpRequest, TargetTcpProxyList>
        listTargetTcpProxiesTransportSettings =
            HttpJsonCallSettings.<ListTargetTcpProxiesHttpRequest, TargetTcpProxyList>newBuilder()
                .setMethodDescriptor(listTargetTcpProxiesMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetBackendServiceTargetTcpProxyHttpRequest, Operation>
        setBackendServiceTargetTcpProxyTransportSettings =
            HttpJsonCallSettings.<SetBackendServiceTargetTcpProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setBackendServiceTargetTcpProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetProxyHeaderTargetTcpProxyHttpRequest, Operation>
        setProxyHeaderTargetTcpProxyTransportSettings =
            HttpJsonCallSettings.<SetProxyHeaderTargetTcpProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setProxyHeaderTargetTcpProxyMethodDescriptor)
                .build();

    this.deleteTargetTcpProxyCallable =
        callableFactory.createUnaryCallable(
            deleteTargetTcpProxyTransportSettings,
            settings.deleteTargetTcpProxySettings(),
            clientContext);
    this.getTargetTcpProxyCallable =
        callableFactory.createUnaryCallable(
            getTargetTcpProxyTransportSettings,
            settings.getTargetTcpProxySettings(),
            clientContext);
    this.insertTargetTcpProxyCallable =
        callableFactory.createUnaryCallable(
            insertTargetTcpProxyTransportSettings,
            settings.insertTargetTcpProxySettings(),
            clientContext);
    this.listTargetTcpProxiesCallable =
        callableFactory.createUnaryCallable(
            listTargetTcpProxiesTransportSettings,
            settings.listTargetTcpProxiesSettings(),
            clientContext);
    this.listTargetTcpProxiesPagedCallable =
        callableFactory.createPagedCallable(
            listTargetTcpProxiesTransportSettings,
            settings.listTargetTcpProxiesSettings(),
            clientContext);
    this.setBackendServiceTargetTcpProxyCallable =
        callableFactory.createUnaryCallable(
            setBackendServiceTargetTcpProxyTransportSettings,
            settings.setBackendServiceTargetTcpProxySettings(),
            clientContext);
    this.setProxyHeaderTargetTcpProxyCallable =
        callableFactory.createUnaryCallable(
            setProxyHeaderTargetTcpProxyTransportSettings,
            settings.setProxyHeaderTargetTcpProxySettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteTargetTcpProxyHttpRequest, Operation> deleteTargetTcpProxyCallable() {
    return deleteTargetTcpProxyCallable;
  }

  @BetaApi
  public UnaryCallable<GetTargetTcpProxyHttpRequest, TargetTcpProxy> getTargetTcpProxyCallable() {
    return getTargetTcpProxyCallable;
  }

  @BetaApi
  public UnaryCallable<InsertTargetTcpProxyHttpRequest, Operation> insertTargetTcpProxyCallable() {
    return insertTargetTcpProxyCallable;
  }

  @BetaApi
  public UnaryCallable<ListTargetTcpProxiesHttpRequest, ListTargetTcpProxiesPagedResponse>
      listTargetTcpProxiesPagedCallable() {
    return listTargetTcpProxiesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListTargetTcpProxiesHttpRequest, TargetTcpProxyList>
      listTargetTcpProxiesCallable() {
    return listTargetTcpProxiesCallable;
  }

  @BetaApi
  public UnaryCallable<SetBackendServiceTargetTcpProxyHttpRequest, Operation>
      setBackendServiceTargetTcpProxyCallable() {
    return setBackendServiceTargetTcpProxyCallable;
  }

  @BetaApi
  public UnaryCallable<SetProxyHeaderTargetTcpProxyHttpRequest, Operation>
      setProxyHeaderTargetTcpProxyCallable() {
    return setProxyHeaderTargetTcpProxyCallable;
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
