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

import static com.google.cloud.compute.v1.RegionTargetHttpsProxyClient.ListRegionTargetHttpsProxiesPagedResponse;

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
import com.google.cloud.compute.v1.DeleteRegionTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.GetRegionTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.InsertRegionTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.ListRegionTargetHttpsProxiesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.ProjectRegionTargetHttpsProxyName;
import com.google.cloud.compute.v1.SetSslCertificatesRegionTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.SetUrlMapRegionTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.TargetHttpsProxy;
import com.google.cloud.compute.v1.TargetHttpsProxyList;
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
public class HttpJsonRegionTargetHttpsProxyStub extends RegionTargetHttpsProxyStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteRegionTargetHttpsProxyHttpRequest, Operation>
      deleteRegionTargetHttpsProxyMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionTargetHttpsProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionTargetHttpsProxies.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<DeleteRegionTargetHttpsProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/targetHttpsProxies/{targetHttpsProxy}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionTargetHttpsProxyName.newFactory())
                      .setResourceNameField("targetHttpsProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetRegionTargetHttpsProxyHttpRequest, TargetHttpsProxy>
      getRegionTargetHttpsProxyMethodDescriptor =
          ApiMethodDescriptor.<GetRegionTargetHttpsProxyHttpRequest, TargetHttpsProxy>newBuilder()
              .setFullMethodName("compute.regionTargetHttpsProxies.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetRegionTargetHttpsProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/targetHttpsProxies/{targetHttpsProxy}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionTargetHttpsProxyName.newFactory())
                      .setResourceNameField("targetHttpsProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetHttpsProxy>newBuilder()
                      .setResponseInstance(TargetHttpsProxy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertRegionTargetHttpsProxyHttpRequest, Operation>
      insertRegionTargetHttpsProxyMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionTargetHttpsProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionTargetHttpsProxies.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<InsertRegionTargetHttpsProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/targetHttpsProxies"))
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
          ListRegionTargetHttpsProxiesHttpRequest, TargetHttpsProxyList>
      listRegionTargetHttpsProxiesMethodDescriptor =
          ApiMethodDescriptor
              .<ListRegionTargetHttpsProxiesHttpRequest, TargetHttpsProxyList>newBuilder()
              .setFullMethodName("compute.regionTargetHttpsProxies.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<ListRegionTargetHttpsProxiesHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/targetHttpsProxies"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetHttpsProxyList>newBuilder()
                      .setResponseInstance(TargetHttpsProxyList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          SetSslCertificatesRegionTargetHttpsProxyHttpRequest, Operation>
      setSslCertificatesRegionTargetHttpsProxyMethodDescriptor =
          ApiMethodDescriptor
              .<SetSslCertificatesRegionTargetHttpsProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionTargetHttpsProxies.setSslCertificates")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<SetSslCertificatesRegionTargetHttpsProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/targetHttpsProxies/{targetHttpsProxy}/setSslCertificates"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionTargetHttpsProxyName.newFactory())
                      .setResourceNameField("targetHttpsProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetUrlMapRegionTargetHttpsProxyHttpRequest, Operation>
      setUrlMapRegionTargetHttpsProxyMethodDescriptor =
          ApiMethodDescriptor.<SetUrlMapRegionTargetHttpsProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionTargetHttpsProxies.setUrlMap")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<SetUrlMapRegionTargetHttpsProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/targetHttpsProxies/{targetHttpsProxy}/setUrlMap"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionTargetHttpsProxyName.newFactory())
                      .setResourceNameField("targetHttpsProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteRegionTargetHttpsProxyHttpRequest, Operation>
      deleteRegionTargetHttpsProxyCallable;
  private final UnaryCallable<GetRegionTargetHttpsProxyHttpRequest, TargetHttpsProxy>
      getRegionTargetHttpsProxyCallable;
  private final UnaryCallable<InsertRegionTargetHttpsProxyHttpRequest, Operation>
      insertRegionTargetHttpsProxyCallable;
  private final UnaryCallable<ListRegionTargetHttpsProxiesHttpRequest, TargetHttpsProxyList>
      listRegionTargetHttpsProxiesCallable;
  private final UnaryCallable<
          ListRegionTargetHttpsProxiesHttpRequest, ListRegionTargetHttpsProxiesPagedResponse>
      listRegionTargetHttpsProxiesPagedCallable;
  private final UnaryCallable<SetSslCertificatesRegionTargetHttpsProxyHttpRequest, Operation>
      setSslCertificatesRegionTargetHttpsProxyCallable;
  private final UnaryCallable<SetUrlMapRegionTargetHttpsProxyHttpRequest, Operation>
      setUrlMapRegionTargetHttpsProxyCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionTargetHttpsProxyStub create(
      RegionTargetHttpsProxyStubSettings settings) throws IOException {
    return new HttpJsonRegionTargetHttpsProxyStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionTargetHttpsProxyStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionTargetHttpsProxyStub(
        RegionTargetHttpsProxyStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionTargetHttpsProxyStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionTargetHttpsProxyStub(
        RegionTargetHttpsProxyStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionTargetHttpsProxyStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionTargetHttpsProxyStub(
      RegionTargetHttpsProxyStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRegionTargetHttpsProxyCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionTargetHttpsProxyStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionTargetHttpsProxyStub(
      RegionTargetHttpsProxyStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteRegionTargetHttpsProxyHttpRequest, Operation>
        deleteRegionTargetHttpsProxyTransportSettings =
            HttpJsonCallSettings.<DeleteRegionTargetHttpsProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteRegionTargetHttpsProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetRegionTargetHttpsProxyHttpRequest, TargetHttpsProxy>
        getRegionTargetHttpsProxyTransportSettings =
            HttpJsonCallSettings
                .<GetRegionTargetHttpsProxyHttpRequest, TargetHttpsProxy>newBuilder()
                .setMethodDescriptor(getRegionTargetHttpsProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertRegionTargetHttpsProxyHttpRequest, Operation>
        insertRegionTargetHttpsProxyTransportSettings =
            HttpJsonCallSettings.<InsertRegionTargetHttpsProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertRegionTargetHttpsProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListRegionTargetHttpsProxiesHttpRequest, TargetHttpsProxyList>
        listRegionTargetHttpsProxiesTransportSettings =
            HttpJsonCallSettings
                .<ListRegionTargetHttpsProxiesHttpRequest, TargetHttpsProxyList>newBuilder()
                .setMethodDescriptor(listRegionTargetHttpsProxiesMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetSslCertificatesRegionTargetHttpsProxyHttpRequest, Operation>
        setSslCertificatesRegionTargetHttpsProxyTransportSettings =
            HttpJsonCallSettings
                .<SetSslCertificatesRegionTargetHttpsProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setSslCertificatesRegionTargetHttpsProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetUrlMapRegionTargetHttpsProxyHttpRequest, Operation>
        setUrlMapRegionTargetHttpsProxyTransportSettings =
            HttpJsonCallSettings.<SetUrlMapRegionTargetHttpsProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setUrlMapRegionTargetHttpsProxyMethodDescriptor)
                .build();

    this.deleteRegionTargetHttpsProxyCallable =
        callableFactory.createUnaryCallable(
            deleteRegionTargetHttpsProxyTransportSettings,
            settings.deleteRegionTargetHttpsProxySettings(),
            clientContext);
    this.getRegionTargetHttpsProxyCallable =
        callableFactory.createUnaryCallable(
            getRegionTargetHttpsProxyTransportSettings,
            settings.getRegionTargetHttpsProxySettings(),
            clientContext);
    this.insertRegionTargetHttpsProxyCallable =
        callableFactory.createUnaryCallable(
            insertRegionTargetHttpsProxyTransportSettings,
            settings.insertRegionTargetHttpsProxySettings(),
            clientContext);
    this.listRegionTargetHttpsProxiesCallable =
        callableFactory.createUnaryCallable(
            listRegionTargetHttpsProxiesTransportSettings,
            settings.listRegionTargetHttpsProxiesSettings(),
            clientContext);
    this.listRegionTargetHttpsProxiesPagedCallable =
        callableFactory.createPagedCallable(
            listRegionTargetHttpsProxiesTransportSettings,
            settings.listRegionTargetHttpsProxiesSettings(),
            clientContext);
    this.setSslCertificatesRegionTargetHttpsProxyCallable =
        callableFactory.createUnaryCallable(
            setSslCertificatesRegionTargetHttpsProxyTransportSettings,
            settings.setSslCertificatesRegionTargetHttpsProxySettings(),
            clientContext);
    this.setUrlMapRegionTargetHttpsProxyCallable =
        callableFactory.createUnaryCallable(
            setUrlMapRegionTargetHttpsProxyTransportSettings,
            settings.setUrlMapRegionTargetHttpsProxySettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteRegionTargetHttpsProxyHttpRequest, Operation>
      deleteRegionTargetHttpsProxyCallable() {
    return deleteRegionTargetHttpsProxyCallable;
  }

  @BetaApi
  public UnaryCallable<GetRegionTargetHttpsProxyHttpRequest, TargetHttpsProxy>
      getRegionTargetHttpsProxyCallable() {
    return getRegionTargetHttpsProxyCallable;
  }

  @BetaApi
  public UnaryCallable<InsertRegionTargetHttpsProxyHttpRequest, Operation>
      insertRegionTargetHttpsProxyCallable() {
    return insertRegionTargetHttpsProxyCallable;
  }

  @BetaApi
  public UnaryCallable<
          ListRegionTargetHttpsProxiesHttpRequest, ListRegionTargetHttpsProxiesPagedResponse>
      listRegionTargetHttpsProxiesPagedCallable() {
    return listRegionTargetHttpsProxiesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionTargetHttpsProxiesHttpRequest, TargetHttpsProxyList>
      listRegionTargetHttpsProxiesCallable() {
    return listRegionTargetHttpsProxiesCallable;
  }

  @BetaApi
  public UnaryCallable<SetSslCertificatesRegionTargetHttpsProxyHttpRequest, Operation>
      setSslCertificatesRegionTargetHttpsProxyCallable() {
    return setSslCertificatesRegionTargetHttpsProxyCallable;
  }

  @BetaApi
  public UnaryCallable<SetUrlMapRegionTargetHttpsProxyHttpRequest, Operation>
      setUrlMapRegionTargetHttpsProxyCallable() {
    return setUrlMapRegionTargetHttpsProxyCallable;
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
