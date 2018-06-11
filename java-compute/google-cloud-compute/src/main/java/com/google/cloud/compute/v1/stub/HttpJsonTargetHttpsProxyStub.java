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

import static com.google.cloud.compute.v1.TargetHttpsProxyClient.ListTargetHttpsProxiesPagedResponse;

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
import com.google.cloud.compute.v1.DeleteTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.GetTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.InsertTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.ListTargetHttpsProxiesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectGlobalTargetHttpsProxyName;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectTargetHttpsProxyName;
import com.google.cloud.compute.v1.SetSslCertificatesTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.SetSslPolicyTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.SetUrlMapTargetHttpsProxyHttpRequest;
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
public class HttpJsonTargetHttpsProxyStub extends TargetHttpsProxyStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteTargetHttpsProxyHttpRequest, Operation>
      deleteTargetHttpsProxyMethodDescriptor =
          ApiMethodDescriptor.<DeleteTargetHttpsProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetHttpsProxies.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteTargetHttpsProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/targetHttpsProxies/{targetHttpsProxy}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalTargetHttpsProxyName.newFactory())
                      .setResourceNameField("targetHttpsProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetTargetHttpsProxyHttpRequest, TargetHttpsProxy>
      getTargetHttpsProxyMethodDescriptor =
          ApiMethodDescriptor.<GetTargetHttpsProxyHttpRequest, TargetHttpsProxy>newBuilder()
              .setFullMethodName("compute.targetHttpsProxies.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetTargetHttpsProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/targetHttpsProxies/{targetHttpsProxy}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalTargetHttpsProxyName.newFactory())
                      .setResourceNameField("targetHttpsProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetHttpsProxy>newBuilder()
                      .setResponseInstance(TargetHttpsProxy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertTargetHttpsProxyHttpRequest, Operation>
      insertTargetHttpsProxyMethodDescriptor =
          ApiMethodDescriptor.<InsertTargetHttpsProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetHttpsProxies.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertTargetHttpsProxyHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/targetHttpsProxies"))
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
  public static final ApiMethodDescriptor<ListTargetHttpsProxiesHttpRequest, TargetHttpsProxyList>
      listTargetHttpsProxiesMethodDescriptor =
          ApiMethodDescriptor.<ListTargetHttpsProxiesHttpRequest, TargetHttpsProxyList>newBuilder()
              .setFullMethodName("compute.targetHttpsProxies.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListTargetHttpsProxiesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/targetHttpsProxies"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetHttpsProxyList>newBuilder()
                      .setResponseInstance(TargetHttpsProxyList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetSslCertificatesTargetHttpsProxyHttpRequest, Operation>
      setSslCertificatesTargetHttpsProxyMethodDescriptor =
          ApiMethodDescriptor.<SetSslCertificatesTargetHttpsProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetHttpsProxies.setSslCertificates")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<SetSslCertificatesTargetHttpsProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/targetHttpsProxies/{targetHttpsProxy}/setSslCertificates"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectTargetHttpsProxyName.newFactory())
                      .setResourceNameField("targetHttpsProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetSslPolicyTargetHttpsProxyHttpRequest, Operation>
      setSslPolicyTargetHttpsProxyMethodDescriptor =
          ApiMethodDescriptor.<SetSslPolicyTargetHttpsProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetHttpsProxies.setSslPolicy")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<SetSslPolicyTargetHttpsProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/targetHttpsProxies/{targetHttpsProxy}/setSslPolicy"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalTargetHttpsProxyName.newFactory())
                      .setResourceNameField("targetHttpsProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetUrlMapTargetHttpsProxyHttpRequest, Operation>
      setUrlMapTargetHttpsProxyMethodDescriptor =
          ApiMethodDescriptor.<SetUrlMapTargetHttpsProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetHttpsProxies.setUrlMap")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<SetUrlMapTargetHttpsProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/targetHttpsProxies/{targetHttpsProxy}/setUrlMap"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectTargetHttpsProxyName.newFactory())
                      .setResourceNameField("targetHttpsProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteTargetHttpsProxyHttpRequest, Operation>
      deleteTargetHttpsProxyCallable;
  private final UnaryCallable<GetTargetHttpsProxyHttpRequest, TargetHttpsProxy>
      getTargetHttpsProxyCallable;
  private final UnaryCallable<InsertTargetHttpsProxyHttpRequest, Operation>
      insertTargetHttpsProxyCallable;
  private final UnaryCallable<ListTargetHttpsProxiesHttpRequest, TargetHttpsProxyList>
      listTargetHttpsProxiesCallable;
  private final UnaryCallable<
          ListTargetHttpsProxiesHttpRequest, ListTargetHttpsProxiesPagedResponse>
      listTargetHttpsProxiesPagedCallable;
  private final UnaryCallable<SetSslCertificatesTargetHttpsProxyHttpRequest, Operation>
      setSslCertificatesTargetHttpsProxyCallable;
  private final UnaryCallable<SetSslPolicyTargetHttpsProxyHttpRequest, Operation>
      setSslPolicyTargetHttpsProxyCallable;
  private final UnaryCallable<SetUrlMapTargetHttpsProxyHttpRequest, Operation>
      setUrlMapTargetHttpsProxyCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTargetHttpsProxyStub create(TargetHttpsProxyStubSettings settings)
      throws IOException {
    return new HttpJsonTargetHttpsProxyStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTargetHttpsProxyStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTargetHttpsProxyStub(
        TargetHttpsProxyStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonTargetHttpsProxyStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTargetHttpsProxyStub(
        TargetHttpsProxyStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTargetHttpsProxyStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetHttpsProxyStub(
      TargetHttpsProxyStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonTargetHttpsProxyCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTargetHttpsProxyStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetHttpsProxyStub(
      TargetHttpsProxyStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteTargetHttpsProxyHttpRequest, Operation>
        deleteTargetHttpsProxyTransportSettings =
            HttpJsonCallSettings.<DeleteTargetHttpsProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteTargetHttpsProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetTargetHttpsProxyHttpRequest, TargetHttpsProxy>
        getTargetHttpsProxyTransportSettings =
            HttpJsonCallSettings.<GetTargetHttpsProxyHttpRequest, TargetHttpsProxy>newBuilder()
                .setMethodDescriptor(getTargetHttpsProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertTargetHttpsProxyHttpRequest, Operation>
        insertTargetHttpsProxyTransportSettings =
            HttpJsonCallSettings.<InsertTargetHttpsProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertTargetHttpsProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListTargetHttpsProxiesHttpRequest, TargetHttpsProxyList>
        listTargetHttpsProxiesTransportSettings =
            HttpJsonCallSettings
                .<ListTargetHttpsProxiesHttpRequest, TargetHttpsProxyList>newBuilder()
                .setMethodDescriptor(listTargetHttpsProxiesMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetSslCertificatesTargetHttpsProxyHttpRequest, Operation>
        setSslCertificatesTargetHttpsProxyTransportSettings =
            HttpJsonCallSettings
                .<SetSslCertificatesTargetHttpsProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setSslCertificatesTargetHttpsProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetSslPolicyTargetHttpsProxyHttpRequest, Operation>
        setSslPolicyTargetHttpsProxyTransportSettings =
            HttpJsonCallSettings.<SetSslPolicyTargetHttpsProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setSslPolicyTargetHttpsProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetUrlMapTargetHttpsProxyHttpRequest, Operation>
        setUrlMapTargetHttpsProxyTransportSettings =
            HttpJsonCallSettings.<SetUrlMapTargetHttpsProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setUrlMapTargetHttpsProxyMethodDescriptor)
                .build();

    this.deleteTargetHttpsProxyCallable =
        callableFactory.createUnaryCallable(
            deleteTargetHttpsProxyTransportSettings,
            settings.deleteTargetHttpsProxySettings(),
            clientContext);
    this.getTargetHttpsProxyCallable =
        callableFactory.createUnaryCallable(
            getTargetHttpsProxyTransportSettings,
            settings.getTargetHttpsProxySettings(),
            clientContext);
    this.insertTargetHttpsProxyCallable =
        callableFactory.createUnaryCallable(
            insertTargetHttpsProxyTransportSettings,
            settings.insertTargetHttpsProxySettings(),
            clientContext);
    this.listTargetHttpsProxiesCallable =
        callableFactory.createUnaryCallable(
            listTargetHttpsProxiesTransportSettings,
            settings.listTargetHttpsProxiesSettings(),
            clientContext);
    this.listTargetHttpsProxiesPagedCallable =
        callableFactory.createPagedCallable(
            listTargetHttpsProxiesTransportSettings,
            settings.listTargetHttpsProxiesSettings(),
            clientContext);
    this.setSslCertificatesTargetHttpsProxyCallable =
        callableFactory.createUnaryCallable(
            setSslCertificatesTargetHttpsProxyTransportSettings,
            settings.setSslCertificatesTargetHttpsProxySettings(),
            clientContext);
    this.setSslPolicyTargetHttpsProxyCallable =
        callableFactory.createUnaryCallable(
            setSslPolicyTargetHttpsProxyTransportSettings,
            settings.setSslPolicyTargetHttpsProxySettings(),
            clientContext);
    this.setUrlMapTargetHttpsProxyCallable =
        callableFactory.createUnaryCallable(
            setUrlMapTargetHttpsProxyTransportSettings,
            settings.setUrlMapTargetHttpsProxySettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteTargetHttpsProxyHttpRequest, Operation>
      deleteTargetHttpsProxyCallable() {
    return deleteTargetHttpsProxyCallable;
  }

  @BetaApi
  public UnaryCallable<GetTargetHttpsProxyHttpRequest, TargetHttpsProxy>
      getTargetHttpsProxyCallable() {
    return getTargetHttpsProxyCallable;
  }

  @BetaApi
  public UnaryCallable<InsertTargetHttpsProxyHttpRequest, Operation>
      insertTargetHttpsProxyCallable() {
    return insertTargetHttpsProxyCallable;
  }

  @BetaApi
  public UnaryCallable<ListTargetHttpsProxiesHttpRequest, ListTargetHttpsProxiesPagedResponse>
      listTargetHttpsProxiesPagedCallable() {
    return listTargetHttpsProxiesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListTargetHttpsProxiesHttpRequest, TargetHttpsProxyList>
      listTargetHttpsProxiesCallable() {
    return listTargetHttpsProxiesCallable;
  }

  @BetaApi
  public UnaryCallable<SetSslCertificatesTargetHttpsProxyHttpRequest, Operation>
      setSslCertificatesTargetHttpsProxyCallable() {
    return setSslCertificatesTargetHttpsProxyCallable;
  }

  @BetaApi
  public UnaryCallable<SetSslPolicyTargetHttpsProxyHttpRequest, Operation>
      setSslPolicyTargetHttpsProxyCallable() {
    return setSslPolicyTargetHttpsProxyCallable;
  }

  @BetaApi
  public UnaryCallable<SetUrlMapTargetHttpsProxyHttpRequest, Operation>
      setUrlMapTargetHttpsProxyCallable() {
    return setUrlMapTargetHttpsProxyCallable;
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
