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

import static com.google.cloud.compute.v1.TargetSslProxyClient.ListTargetSslProxiesPagedResponse;

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
import com.google.cloud.compute.v1.DeleteTargetSslProxyHttpRequest;
import com.google.cloud.compute.v1.GetTargetSslProxyHttpRequest;
import com.google.cloud.compute.v1.InsertTargetSslProxyHttpRequest;
import com.google.cloud.compute.v1.ListTargetSslProxiesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectGlobalTargetSslProxyName;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.SetBackendServiceTargetSslProxyHttpRequest;
import com.google.cloud.compute.v1.SetProxyHeaderTargetSslProxyHttpRequest;
import com.google.cloud.compute.v1.SetSslCertificatesTargetSslProxyHttpRequest;
import com.google.cloud.compute.v1.SetSslPolicyTargetSslProxyHttpRequest;
import com.google.cloud.compute.v1.TargetSslProxy;
import com.google.cloud.compute.v1.TargetSslProxyList;
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
public class HttpJsonTargetSslProxyStub extends TargetSslProxyStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteTargetSslProxyHttpRequest, Operation>
      deleteTargetSslProxyMethodDescriptor =
          ApiMethodDescriptor.<DeleteTargetSslProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetSslProxies.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteTargetSslProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/targetSslProxies/{targetSslProxy}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalTargetSslProxyName.newFactory())
                      .setResourceNameField("targetSslProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetTargetSslProxyHttpRequest, TargetSslProxy>
      getTargetSslProxyMethodDescriptor =
          ApiMethodDescriptor.<GetTargetSslProxyHttpRequest, TargetSslProxy>newBuilder()
              .setFullMethodName("compute.targetSslProxies.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetTargetSslProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/targetSslProxies/{targetSslProxy}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalTargetSslProxyName.newFactory())
                      .setResourceNameField("targetSslProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetSslProxy>newBuilder()
                      .setResponseInstance(TargetSslProxy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertTargetSslProxyHttpRequest, Operation>
      insertTargetSslProxyMethodDescriptor =
          ApiMethodDescriptor.<InsertTargetSslProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetSslProxies.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertTargetSslProxyHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/targetSslProxies"))
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
  public static final ApiMethodDescriptor<ListTargetSslProxiesHttpRequest, TargetSslProxyList>
      listTargetSslProxiesMethodDescriptor =
          ApiMethodDescriptor.<ListTargetSslProxiesHttpRequest, TargetSslProxyList>newBuilder()
              .setFullMethodName("compute.targetSslProxies.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListTargetSslProxiesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/targetSslProxies"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetSslProxyList>newBuilder()
                      .setResponseInstance(TargetSslProxyList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetBackendServiceTargetSslProxyHttpRequest, Operation>
      setBackendServiceTargetSslProxyMethodDescriptor =
          ApiMethodDescriptor.<SetBackendServiceTargetSslProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetSslProxies.setBackendService")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<SetBackendServiceTargetSslProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/targetSslProxies/{targetSslProxy}/setBackendService"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalTargetSslProxyName.newFactory())
                      .setResourceNameField("targetSslProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetProxyHeaderTargetSslProxyHttpRequest, Operation>
      setProxyHeaderTargetSslProxyMethodDescriptor =
          ApiMethodDescriptor.<SetProxyHeaderTargetSslProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetSslProxies.setProxyHeader")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<SetProxyHeaderTargetSslProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/targetSslProxies/{targetSslProxy}/setProxyHeader"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalTargetSslProxyName.newFactory())
                      .setResourceNameField("targetSslProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetSslCertificatesTargetSslProxyHttpRequest, Operation>
      setSslCertificatesTargetSslProxyMethodDescriptor =
          ApiMethodDescriptor.<SetSslCertificatesTargetSslProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetSslProxies.setSslCertificates")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<SetSslCertificatesTargetSslProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/targetSslProxies/{targetSslProxy}/setSslCertificates"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalTargetSslProxyName.newFactory())
                      .setResourceNameField("targetSslProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetSslPolicyTargetSslProxyHttpRequest, Operation>
      setSslPolicyTargetSslProxyMethodDescriptor =
          ApiMethodDescriptor.<SetSslPolicyTargetSslProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetSslProxies.setSslPolicy")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<SetSslPolicyTargetSslProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/targetSslProxies/{targetSslProxy}/setSslPolicy"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalTargetSslProxyName.newFactory())
                      .setResourceNameField("targetSslProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteTargetSslProxyHttpRequest, Operation>
      deleteTargetSslProxyCallable;
  private final UnaryCallable<GetTargetSslProxyHttpRequest, TargetSslProxy>
      getTargetSslProxyCallable;
  private final UnaryCallable<InsertTargetSslProxyHttpRequest, Operation>
      insertTargetSslProxyCallable;
  private final UnaryCallable<ListTargetSslProxiesHttpRequest, TargetSslProxyList>
      listTargetSslProxiesCallable;
  private final UnaryCallable<ListTargetSslProxiesHttpRequest, ListTargetSslProxiesPagedResponse>
      listTargetSslProxiesPagedCallable;
  private final UnaryCallable<SetBackendServiceTargetSslProxyHttpRequest, Operation>
      setBackendServiceTargetSslProxyCallable;
  private final UnaryCallable<SetProxyHeaderTargetSslProxyHttpRequest, Operation>
      setProxyHeaderTargetSslProxyCallable;
  private final UnaryCallable<SetSslCertificatesTargetSslProxyHttpRequest, Operation>
      setSslCertificatesTargetSslProxyCallable;
  private final UnaryCallable<SetSslPolicyTargetSslProxyHttpRequest, Operation>
      setSslPolicyTargetSslProxyCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTargetSslProxyStub create(TargetSslProxyStubSettings settings)
      throws IOException {
    return new HttpJsonTargetSslProxyStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTargetSslProxyStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTargetSslProxyStub(
        TargetSslProxyStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonTargetSslProxyStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTargetSslProxyStub(
        TargetSslProxyStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTargetSslProxyStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetSslProxyStub(
      TargetSslProxyStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonTargetSslProxyCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTargetSslProxyStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetSslProxyStub(
      TargetSslProxyStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteTargetSslProxyHttpRequest, Operation>
        deleteTargetSslProxyTransportSettings =
            HttpJsonCallSettings.<DeleteTargetSslProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteTargetSslProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetTargetSslProxyHttpRequest, TargetSslProxy>
        getTargetSslProxyTransportSettings =
            HttpJsonCallSettings.<GetTargetSslProxyHttpRequest, TargetSslProxy>newBuilder()
                .setMethodDescriptor(getTargetSslProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertTargetSslProxyHttpRequest, Operation>
        insertTargetSslProxyTransportSettings =
            HttpJsonCallSettings.<InsertTargetSslProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertTargetSslProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListTargetSslProxiesHttpRequest, TargetSslProxyList>
        listTargetSslProxiesTransportSettings =
            HttpJsonCallSettings.<ListTargetSslProxiesHttpRequest, TargetSslProxyList>newBuilder()
                .setMethodDescriptor(listTargetSslProxiesMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetBackendServiceTargetSslProxyHttpRequest, Operation>
        setBackendServiceTargetSslProxyTransportSettings =
            HttpJsonCallSettings.<SetBackendServiceTargetSslProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setBackendServiceTargetSslProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetProxyHeaderTargetSslProxyHttpRequest, Operation>
        setProxyHeaderTargetSslProxyTransportSettings =
            HttpJsonCallSettings.<SetProxyHeaderTargetSslProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setProxyHeaderTargetSslProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetSslCertificatesTargetSslProxyHttpRequest, Operation>
        setSslCertificatesTargetSslProxyTransportSettings =
            HttpJsonCallSettings
                .<SetSslCertificatesTargetSslProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setSslCertificatesTargetSslProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetSslPolicyTargetSslProxyHttpRequest, Operation>
        setSslPolicyTargetSslProxyTransportSettings =
            HttpJsonCallSettings.<SetSslPolicyTargetSslProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setSslPolicyTargetSslProxyMethodDescriptor)
                .build();

    this.deleteTargetSslProxyCallable =
        callableFactory.createUnaryCallable(
            deleteTargetSslProxyTransportSettings,
            settings.deleteTargetSslProxySettings(),
            clientContext);
    this.getTargetSslProxyCallable =
        callableFactory.createUnaryCallable(
            getTargetSslProxyTransportSettings,
            settings.getTargetSslProxySettings(),
            clientContext);
    this.insertTargetSslProxyCallable =
        callableFactory.createUnaryCallable(
            insertTargetSslProxyTransportSettings,
            settings.insertTargetSslProxySettings(),
            clientContext);
    this.listTargetSslProxiesCallable =
        callableFactory.createUnaryCallable(
            listTargetSslProxiesTransportSettings,
            settings.listTargetSslProxiesSettings(),
            clientContext);
    this.listTargetSslProxiesPagedCallable =
        callableFactory.createPagedCallable(
            listTargetSslProxiesTransportSettings,
            settings.listTargetSslProxiesSettings(),
            clientContext);
    this.setBackendServiceTargetSslProxyCallable =
        callableFactory.createUnaryCallable(
            setBackendServiceTargetSslProxyTransportSettings,
            settings.setBackendServiceTargetSslProxySettings(),
            clientContext);
    this.setProxyHeaderTargetSslProxyCallable =
        callableFactory.createUnaryCallable(
            setProxyHeaderTargetSslProxyTransportSettings,
            settings.setProxyHeaderTargetSslProxySettings(),
            clientContext);
    this.setSslCertificatesTargetSslProxyCallable =
        callableFactory.createUnaryCallable(
            setSslCertificatesTargetSslProxyTransportSettings,
            settings.setSslCertificatesTargetSslProxySettings(),
            clientContext);
    this.setSslPolicyTargetSslProxyCallable =
        callableFactory.createUnaryCallable(
            setSslPolicyTargetSslProxyTransportSettings,
            settings.setSslPolicyTargetSslProxySettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteTargetSslProxyHttpRequest, Operation> deleteTargetSslProxyCallable() {
    return deleteTargetSslProxyCallable;
  }

  @BetaApi
  public UnaryCallable<GetTargetSslProxyHttpRequest, TargetSslProxy> getTargetSslProxyCallable() {
    return getTargetSslProxyCallable;
  }

  @BetaApi
  public UnaryCallable<InsertTargetSslProxyHttpRequest, Operation> insertTargetSslProxyCallable() {
    return insertTargetSslProxyCallable;
  }

  @BetaApi
  public UnaryCallable<ListTargetSslProxiesHttpRequest, ListTargetSslProxiesPagedResponse>
      listTargetSslProxiesPagedCallable() {
    return listTargetSslProxiesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListTargetSslProxiesHttpRequest, TargetSslProxyList>
      listTargetSslProxiesCallable() {
    return listTargetSslProxiesCallable;
  }

  @BetaApi
  public UnaryCallable<SetBackendServiceTargetSslProxyHttpRequest, Operation>
      setBackendServiceTargetSslProxyCallable() {
    return setBackendServiceTargetSslProxyCallable;
  }

  @BetaApi
  public UnaryCallable<SetProxyHeaderTargetSslProxyHttpRequest, Operation>
      setProxyHeaderTargetSslProxyCallable() {
    return setProxyHeaderTargetSslProxyCallable;
  }

  @BetaApi
  public UnaryCallable<SetSslCertificatesTargetSslProxyHttpRequest, Operation>
      setSslCertificatesTargetSslProxyCallable() {
    return setSslCertificatesTargetSslProxyCallable;
  }

  @BetaApi
  public UnaryCallable<SetSslPolicyTargetSslProxyHttpRequest, Operation>
      setSslPolicyTargetSslProxyCallable() {
    return setSslPolicyTargetSslProxyCallable;
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
