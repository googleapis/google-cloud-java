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

import static com.google.cloud.compute.v1.HttpHealthCheckClient.ListHttpHealthChecksPagedResponse;

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
import com.google.cloud.compute.v1.DeleteHttpHealthCheckHttpRequest;
import com.google.cloud.compute.v1.GetHttpHealthCheckHttpRequest;
import com.google.cloud.compute.v1.HttpHealthCheck2;
import com.google.cloud.compute.v1.HttpHealthCheckList;
import com.google.cloud.compute.v1.InsertHttpHealthCheckHttpRequest;
import com.google.cloud.compute.v1.ListHttpHealthChecksHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchHttpHealthCheckHttpRequest;
import com.google.cloud.compute.v1.ProjectGlobalHttpHealthCheckName;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.UpdateHttpHealthCheckHttpRequest;
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
public class HttpJsonHttpHealthCheckStub extends HttpHealthCheckStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteHttpHealthCheckHttpRequest, Operation>
      deleteHttpHealthCheckMethodDescriptor =
          ApiMethodDescriptor.<DeleteHttpHealthCheckHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.httpHealthChecks.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteHttpHealthCheckHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/httpHealthChecks/{httpHealthCheck}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalHttpHealthCheckName.newFactory())
                      .setResourceNameField("httpHealthCheck")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetHttpHealthCheckHttpRequest, HttpHealthCheck2>
      getHttpHealthCheckMethodDescriptor =
          ApiMethodDescriptor.<GetHttpHealthCheckHttpRequest, HttpHealthCheck2>newBuilder()
              .setFullMethodName("compute.httpHealthChecks.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetHttpHealthCheckHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/httpHealthChecks/{httpHealthCheck}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalHttpHealthCheckName.newFactory())
                      .setResourceNameField("httpHealthCheck")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<HttpHealthCheck2>newBuilder()
                      .setResponseInstance(HttpHealthCheck2.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertHttpHealthCheckHttpRequest, Operation>
      insertHttpHealthCheckMethodDescriptor =
          ApiMethodDescriptor.<InsertHttpHealthCheckHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.httpHealthChecks.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertHttpHealthCheckHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/httpHealthChecks"))
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
  public static final ApiMethodDescriptor<ListHttpHealthChecksHttpRequest, HttpHealthCheckList>
      listHttpHealthChecksMethodDescriptor =
          ApiMethodDescriptor.<ListHttpHealthChecksHttpRequest, HttpHealthCheckList>newBuilder()
              .setFullMethodName("compute.httpHealthChecks.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListHttpHealthChecksHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/httpHealthChecks"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<HttpHealthCheckList>newBuilder()
                      .setResponseInstance(HttpHealthCheckList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchHttpHealthCheckHttpRequest, Operation>
      patchHttpHealthCheckMethodDescriptor =
          ApiMethodDescriptor.<PatchHttpHealthCheckHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.httpHealthChecks.patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<PatchHttpHealthCheckHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/httpHealthChecks/{httpHealthCheck}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalHttpHealthCheckName.newFactory())
                      .setResourceNameField("httpHealthCheck")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<UpdateHttpHealthCheckHttpRequest, Operation>
      updateHttpHealthCheckMethodDescriptor =
          ApiMethodDescriptor.<UpdateHttpHealthCheckHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.httpHealthChecks.update")
              .setHttpMethod(HttpMethods.PUT)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<UpdateHttpHealthCheckHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/httpHealthChecks/{httpHealthCheck}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalHttpHealthCheckName.newFactory())
                      .setResourceNameField("httpHealthCheck")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteHttpHealthCheckHttpRequest, Operation>
      deleteHttpHealthCheckCallable;
  private final UnaryCallable<GetHttpHealthCheckHttpRequest, HttpHealthCheck2>
      getHttpHealthCheckCallable;
  private final UnaryCallable<InsertHttpHealthCheckHttpRequest, Operation>
      insertHttpHealthCheckCallable;
  private final UnaryCallable<ListHttpHealthChecksHttpRequest, HttpHealthCheckList>
      listHttpHealthChecksCallable;
  private final UnaryCallable<ListHttpHealthChecksHttpRequest, ListHttpHealthChecksPagedResponse>
      listHttpHealthChecksPagedCallable;
  private final UnaryCallable<PatchHttpHealthCheckHttpRequest, Operation>
      patchHttpHealthCheckCallable;
  private final UnaryCallable<UpdateHttpHealthCheckHttpRequest, Operation>
      updateHttpHealthCheckCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonHttpHealthCheckStub create(HttpHealthCheckStubSettings settings)
      throws IOException {
    return new HttpJsonHttpHealthCheckStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonHttpHealthCheckStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonHttpHealthCheckStub(
        HttpHealthCheckStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonHttpHealthCheckStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonHttpHealthCheckStub(
        HttpHealthCheckStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonHttpHealthCheckStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonHttpHealthCheckStub(
      HttpHealthCheckStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonHttpHealthCheckCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonHttpHealthCheckStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonHttpHealthCheckStub(
      HttpHealthCheckStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteHttpHealthCheckHttpRequest, Operation>
        deleteHttpHealthCheckTransportSettings =
            HttpJsonCallSettings.<DeleteHttpHealthCheckHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteHttpHealthCheckMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetHttpHealthCheckHttpRequest, HttpHealthCheck2>
        getHttpHealthCheckTransportSettings =
            HttpJsonCallSettings.<GetHttpHealthCheckHttpRequest, HttpHealthCheck2>newBuilder()
                .setMethodDescriptor(getHttpHealthCheckMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertHttpHealthCheckHttpRequest, Operation>
        insertHttpHealthCheckTransportSettings =
            HttpJsonCallSettings.<InsertHttpHealthCheckHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertHttpHealthCheckMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListHttpHealthChecksHttpRequest, HttpHealthCheckList>
        listHttpHealthChecksTransportSettings =
            HttpJsonCallSettings.<ListHttpHealthChecksHttpRequest, HttpHealthCheckList>newBuilder()
                .setMethodDescriptor(listHttpHealthChecksMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchHttpHealthCheckHttpRequest, Operation>
        patchHttpHealthCheckTransportSettings =
            HttpJsonCallSettings.<PatchHttpHealthCheckHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(patchHttpHealthCheckMethodDescriptor)
                .build();
    HttpJsonCallSettings<UpdateHttpHealthCheckHttpRequest, Operation>
        updateHttpHealthCheckTransportSettings =
            HttpJsonCallSettings.<UpdateHttpHealthCheckHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(updateHttpHealthCheckMethodDescriptor)
                .build();

    this.deleteHttpHealthCheckCallable =
        callableFactory.createUnaryCallable(
            deleteHttpHealthCheckTransportSettings,
            settings.deleteHttpHealthCheckSettings(),
            clientContext);
    this.getHttpHealthCheckCallable =
        callableFactory.createUnaryCallable(
            getHttpHealthCheckTransportSettings,
            settings.getHttpHealthCheckSettings(),
            clientContext);
    this.insertHttpHealthCheckCallable =
        callableFactory.createUnaryCallable(
            insertHttpHealthCheckTransportSettings,
            settings.insertHttpHealthCheckSettings(),
            clientContext);
    this.listHttpHealthChecksCallable =
        callableFactory.createUnaryCallable(
            listHttpHealthChecksTransportSettings,
            settings.listHttpHealthChecksSettings(),
            clientContext);
    this.listHttpHealthChecksPagedCallable =
        callableFactory.createPagedCallable(
            listHttpHealthChecksTransportSettings,
            settings.listHttpHealthChecksSettings(),
            clientContext);
    this.patchHttpHealthCheckCallable =
        callableFactory.createUnaryCallable(
            patchHttpHealthCheckTransportSettings,
            settings.patchHttpHealthCheckSettings(),
            clientContext);
    this.updateHttpHealthCheckCallable =
        callableFactory.createUnaryCallable(
            updateHttpHealthCheckTransportSettings,
            settings.updateHttpHealthCheckSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteHttpHealthCheckHttpRequest, Operation>
      deleteHttpHealthCheckCallable() {
    return deleteHttpHealthCheckCallable;
  }

  @BetaApi
  public UnaryCallable<GetHttpHealthCheckHttpRequest, HttpHealthCheck2>
      getHttpHealthCheckCallable() {
    return getHttpHealthCheckCallable;
  }

  @BetaApi
  public UnaryCallable<InsertHttpHealthCheckHttpRequest, Operation>
      insertHttpHealthCheckCallable() {
    return insertHttpHealthCheckCallable;
  }

  @BetaApi
  public UnaryCallable<ListHttpHealthChecksHttpRequest, ListHttpHealthChecksPagedResponse>
      listHttpHealthChecksPagedCallable() {
    return listHttpHealthChecksPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListHttpHealthChecksHttpRequest, HttpHealthCheckList>
      listHttpHealthChecksCallable() {
    return listHttpHealthChecksCallable;
  }

  @BetaApi
  public UnaryCallable<PatchHttpHealthCheckHttpRequest, Operation> patchHttpHealthCheckCallable() {
    return patchHttpHealthCheckCallable;
  }

  @BetaApi
  public UnaryCallable<UpdateHttpHealthCheckHttpRequest, Operation>
      updateHttpHealthCheckCallable() {
    return updateHttpHealthCheckCallable;
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
