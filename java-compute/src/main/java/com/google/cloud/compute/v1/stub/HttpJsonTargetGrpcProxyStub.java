/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.compute.v1.TargetGrpcProxyClient.ListTargetGrpcProxiesPagedResponse;

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
import com.google.cloud.compute.v1.DeleteTargetGrpcProxyHttpRequest;
import com.google.cloud.compute.v1.GetTargetGrpcProxyHttpRequest;
import com.google.cloud.compute.v1.InsertTargetGrpcProxyHttpRequest;
import com.google.cloud.compute.v1.ListTargetGrpcProxiesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchTargetGrpcProxyHttpRequest;
import com.google.cloud.compute.v1.ProjectGlobalTargetGrpcProxyName;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.TargetGrpcProxy;
import com.google.cloud.compute.v1.TargetGrpcProxyList;
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
public class HttpJsonTargetGrpcProxyStub extends TargetGrpcProxyStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteTargetGrpcProxyHttpRequest, Operation>
      deleteTargetGrpcProxyMethodDescriptor =
          ApiMethodDescriptor.<DeleteTargetGrpcProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetGrpcProxies.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteTargetGrpcProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/targetGrpcProxies/{targetGrpcProxy}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalTargetGrpcProxyName.newFactory())
                      .setResourceNameField("targetGrpcProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetTargetGrpcProxyHttpRequest, TargetGrpcProxy>
      getTargetGrpcProxyMethodDescriptor =
          ApiMethodDescriptor.<GetTargetGrpcProxyHttpRequest, TargetGrpcProxy>newBuilder()
              .setFullMethodName("compute.targetGrpcProxies.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetTargetGrpcProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/targetGrpcProxies/{targetGrpcProxy}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalTargetGrpcProxyName.newFactory())
                      .setResourceNameField("targetGrpcProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetGrpcProxy>newBuilder()
                      .setResponseInstance(TargetGrpcProxy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertTargetGrpcProxyHttpRequest, Operation>
      insertTargetGrpcProxyMethodDescriptor =
          ApiMethodDescriptor.<InsertTargetGrpcProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetGrpcProxies.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertTargetGrpcProxyHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/targetGrpcProxies"))
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
  public static final ApiMethodDescriptor<ListTargetGrpcProxiesHttpRequest, TargetGrpcProxyList>
      listTargetGrpcProxiesMethodDescriptor =
          ApiMethodDescriptor.<ListTargetGrpcProxiesHttpRequest, TargetGrpcProxyList>newBuilder()
              .setFullMethodName("compute.targetGrpcProxies.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListTargetGrpcProxiesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/targetGrpcProxies"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetGrpcProxyList>newBuilder()
                      .setResponseInstance(TargetGrpcProxyList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchTargetGrpcProxyHttpRequest, Operation>
      patchTargetGrpcProxyMethodDescriptor =
          ApiMethodDescriptor.<PatchTargetGrpcProxyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetGrpcProxies.patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<PatchTargetGrpcProxyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/targetGrpcProxies/{targetGrpcProxy}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalTargetGrpcProxyName.newFactory())
                      .setResourceNameField("targetGrpcProxy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteTargetGrpcProxyHttpRequest, Operation>
      deleteTargetGrpcProxyCallable;
  private final UnaryCallable<GetTargetGrpcProxyHttpRequest, TargetGrpcProxy>
      getTargetGrpcProxyCallable;
  private final UnaryCallable<InsertTargetGrpcProxyHttpRequest, Operation>
      insertTargetGrpcProxyCallable;
  private final UnaryCallable<ListTargetGrpcProxiesHttpRequest, TargetGrpcProxyList>
      listTargetGrpcProxiesCallable;
  private final UnaryCallable<ListTargetGrpcProxiesHttpRequest, ListTargetGrpcProxiesPagedResponse>
      listTargetGrpcProxiesPagedCallable;
  private final UnaryCallable<PatchTargetGrpcProxyHttpRequest, Operation>
      patchTargetGrpcProxyCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTargetGrpcProxyStub create(TargetGrpcProxyStubSettings settings)
      throws IOException {
    return new HttpJsonTargetGrpcProxyStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTargetGrpcProxyStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTargetGrpcProxyStub(
        TargetGrpcProxyStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonTargetGrpcProxyStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTargetGrpcProxyStub(
        TargetGrpcProxyStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTargetGrpcProxyStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetGrpcProxyStub(
      TargetGrpcProxyStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonTargetGrpcProxyCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTargetGrpcProxyStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetGrpcProxyStub(
      TargetGrpcProxyStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteTargetGrpcProxyHttpRequest, Operation>
        deleteTargetGrpcProxyTransportSettings =
            HttpJsonCallSettings.<DeleteTargetGrpcProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteTargetGrpcProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetTargetGrpcProxyHttpRequest, TargetGrpcProxy>
        getTargetGrpcProxyTransportSettings =
            HttpJsonCallSettings.<GetTargetGrpcProxyHttpRequest, TargetGrpcProxy>newBuilder()
                .setMethodDescriptor(getTargetGrpcProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertTargetGrpcProxyHttpRequest, Operation>
        insertTargetGrpcProxyTransportSettings =
            HttpJsonCallSettings.<InsertTargetGrpcProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertTargetGrpcProxyMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListTargetGrpcProxiesHttpRequest, TargetGrpcProxyList>
        listTargetGrpcProxiesTransportSettings =
            HttpJsonCallSettings.<ListTargetGrpcProxiesHttpRequest, TargetGrpcProxyList>newBuilder()
                .setMethodDescriptor(listTargetGrpcProxiesMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchTargetGrpcProxyHttpRequest, Operation>
        patchTargetGrpcProxyTransportSettings =
            HttpJsonCallSettings.<PatchTargetGrpcProxyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(patchTargetGrpcProxyMethodDescriptor)
                .build();

    this.deleteTargetGrpcProxyCallable =
        callableFactory.createUnaryCallable(
            deleteTargetGrpcProxyTransportSettings,
            settings.deleteTargetGrpcProxySettings(),
            clientContext);
    this.getTargetGrpcProxyCallable =
        callableFactory.createUnaryCallable(
            getTargetGrpcProxyTransportSettings,
            settings.getTargetGrpcProxySettings(),
            clientContext);
    this.insertTargetGrpcProxyCallable =
        callableFactory.createUnaryCallable(
            insertTargetGrpcProxyTransportSettings,
            settings.insertTargetGrpcProxySettings(),
            clientContext);
    this.listTargetGrpcProxiesCallable =
        callableFactory.createUnaryCallable(
            listTargetGrpcProxiesTransportSettings,
            settings.listTargetGrpcProxiesSettings(),
            clientContext);
    this.listTargetGrpcProxiesPagedCallable =
        callableFactory.createPagedCallable(
            listTargetGrpcProxiesTransportSettings,
            settings.listTargetGrpcProxiesSettings(),
            clientContext);
    this.patchTargetGrpcProxyCallable =
        callableFactory.createUnaryCallable(
            patchTargetGrpcProxyTransportSettings,
            settings.patchTargetGrpcProxySettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteTargetGrpcProxyHttpRequest, Operation>
      deleteTargetGrpcProxyCallable() {
    return deleteTargetGrpcProxyCallable;
  }

  @BetaApi
  public UnaryCallable<GetTargetGrpcProxyHttpRequest, TargetGrpcProxy>
      getTargetGrpcProxyCallable() {
    return getTargetGrpcProxyCallable;
  }

  @BetaApi
  public UnaryCallable<InsertTargetGrpcProxyHttpRequest, Operation>
      insertTargetGrpcProxyCallable() {
    return insertTargetGrpcProxyCallable;
  }

  @BetaApi
  public UnaryCallable<ListTargetGrpcProxiesHttpRequest, ListTargetGrpcProxiesPagedResponse>
      listTargetGrpcProxiesPagedCallable() {
    return listTargetGrpcProxiesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListTargetGrpcProxiesHttpRequest, TargetGrpcProxyList>
      listTargetGrpcProxiesCallable() {
    return listTargetGrpcProxiesCallable;
  }

  @BetaApi
  public UnaryCallable<PatchTargetGrpcProxyHttpRequest, Operation> patchTargetGrpcProxyCallable() {
    return patchTargetGrpcProxyCallable;
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
