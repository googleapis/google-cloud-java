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

import static com.google.cloud.compute.v1.HttpsHealthCheckClient.ListHttpsHealthChecksPagedResponse;

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
import com.google.cloud.compute.v1.DeleteHttpsHealthCheckHttpRequest;
import com.google.cloud.compute.v1.GetHttpsHealthCheckHttpRequest;
import com.google.cloud.compute.v1.HttpsHealthCheck2;
import com.google.cloud.compute.v1.HttpsHealthCheckList;
import com.google.cloud.compute.v1.InsertHttpsHealthCheckHttpRequest;
import com.google.cloud.compute.v1.ListHttpsHealthChecksHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchHttpsHealthCheckHttpRequest;
import com.google.cloud.compute.v1.ProjectGlobalHttpsHealthCheckName;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.UpdateHttpsHealthCheckHttpRequest;
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
public class HttpJsonHttpsHealthCheckStub extends HttpsHealthCheckStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteHttpsHealthCheckHttpRequest, Operation>
      deleteHttpsHealthCheckMethodDescriptor =
          ApiMethodDescriptor.<DeleteHttpsHealthCheckHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.httpsHealthChecks.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteHttpsHealthCheckHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/httpsHealthChecks/{httpsHealthCheck}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalHttpsHealthCheckName.newFactory())
                      .setResourceNameField("httpsHealthCheck")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetHttpsHealthCheckHttpRequest, HttpsHealthCheck2>
      getHttpsHealthCheckMethodDescriptor =
          ApiMethodDescriptor.<GetHttpsHealthCheckHttpRequest, HttpsHealthCheck2>newBuilder()
              .setFullMethodName("compute.httpsHealthChecks.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetHttpsHealthCheckHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/httpsHealthChecks/{httpsHealthCheck}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalHttpsHealthCheckName.newFactory())
                      .setResourceNameField("httpsHealthCheck")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<HttpsHealthCheck2>newBuilder()
                      .setResponseInstance(HttpsHealthCheck2.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertHttpsHealthCheckHttpRequest, Operation>
      insertHttpsHealthCheckMethodDescriptor =
          ApiMethodDescriptor.<InsertHttpsHealthCheckHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.httpsHealthChecks.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertHttpsHealthCheckHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/httpsHealthChecks"))
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
  public static final ApiMethodDescriptor<ListHttpsHealthChecksHttpRequest, HttpsHealthCheckList>
      listHttpsHealthChecksMethodDescriptor =
          ApiMethodDescriptor.<ListHttpsHealthChecksHttpRequest, HttpsHealthCheckList>newBuilder()
              .setFullMethodName("compute.httpsHealthChecks.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListHttpsHealthChecksHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/httpsHealthChecks"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<HttpsHealthCheckList>newBuilder()
                      .setResponseInstance(HttpsHealthCheckList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchHttpsHealthCheckHttpRequest, Operation>
      patchHttpsHealthCheckMethodDescriptor =
          ApiMethodDescriptor.<PatchHttpsHealthCheckHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.httpsHealthChecks.patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<PatchHttpsHealthCheckHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/httpsHealthChecks/{httpsHealthCheck}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalHttpsHealthCheckName.newFactory())
                      .setResourceNameField("httpsHealthCheck")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<UpdateHttpsHealthCheckHttpRequest, Operation>
      updateHttpsHealthCheckMethodDescriptor =
          ApiMethodDescriptor.<UpdateHttpsHealthCheckHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.httpsHealthChecks.update")
              .setHttpMethod(HttpMethods.PUT)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<UpdateHttpsHealthCheckHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/httpsHealthChecks/{httpsHealthCheck}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalHttpsHealthCheckName.newFactory())
                      .setResourceNameField("httpsHealthCheck")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteHttpsHealthCheckHttpRequest, Operation>
      deleteHttpsHealthCheckCallable;
  private final UnaryCallable<GetHttpsHealthCheckHttpRequest, HttpsHealthCheck2>
      getHttpsHealthCheckCallable;
  private final UnaryCallable<InsertHttpsHealthCheckHttpRequest, Operation>
      insertHttpsHealthCheckCallable;
  private final UnaryCallable<ListHttpsHealthChecksHttpRequest, HttpsHealthCheckList>
      listHttpsHealthChecksCallable;
  private final UnaryCallable<ListHttpsHealthChecksHttpRequest, ListHttpsHealthChecksPagedResponse>
      listHttpsHealthChecksPagedCallable;
  private final UnaryCallable<PatchHttpsHealthCheckHttpRequest, Operation>
      patchHttpsHealthCheckCallable;
  private final UnaryCallable<UpdateHttpsHealthCheckHttpRequest, Operation>
      updateHttpsHealthCheckCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonHttpsHealthCheckStub create(HttpsHealthCheckStubSettings settings)
      throws IOException {
    return new HttpJsonHttpsHealthCheckStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonHttpsHealthCheckStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonHttpsHealthCheckStub(
        HttpsHealthCheckStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonHttpsHealthCheckStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonHttpsHealthCheckStub(
        HttpsHealthCheckStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonHttpsHealthCheckStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonHttpsHealthCheckStub(
      HttpsHealthCheckStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonHttpsHealthCheckCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonHttpsHealthCheckStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonHttpsHealthCheckStub(
      HttpsHealthCheckStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteHttpsHealthCheckHttpRequest, Operation>
        deleteHttpsHealthCheckTransportSettings =
            HttpJsonCallSettings.<DeleteHttpsHealthCheckHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteHttpsHealthCheckMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetHttpsHealthCheckHttpRequest, HttpsHealthCheck2>
        getHttpsHealthCheckTransportSettings =
            HttpJsonCallSettings.<GetHttpsHealthCheckHttpRequest, HttpsHealthCheck2>newBuilder()
                .setMethodDescriptor(getHttpsHealthCheckMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertHttpsHealthCheckHttpRequest, Operation>
        insertHttpsHealthCheckTransportSettings =
            HttpJsonCallSettings.<InsertHttpsHealthCheckHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertHttpsHealthCheckMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListHttpsHealthChecksHttpRequest, HttpsHealthCheckList>
        listHttpsHealthChecksTransportSettings =
            HttpJsonCallSettings
                .<ListHttpsHealthChecksHttpRequest, HttpsHealthCheckList>newBuilder()
                .setMethodDescriptor(listHttpsHealthChecksMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchHttpsHealthCheckHttpRequest, Operation>
        patchHttpsHealthCheckTransportSettings =
            HttpJsonCallSettings.<PatchHttpsHealthCheckHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(patchHttpsHealthCheckMethodDescriptor)
                .build();
    HttpJsonCallSettings<UpdateHttpsHealthCheckHttpRequest, Operation>
        updateHttpsHealthCheckTransportSettings =
            HttpJsonCallSettings.<UpdateHttpsHealthCheckHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(updateHttpsHealthCheckMethodDescriptor)
                .build();

    this.deleteHttpsHealthCheckCallable =
        callableFactory.createUnaryCallable(
            deleteHttpsHealthCheckTransportSettings,
            settings.deleteHttpsHealthCheckSettings(),
            clientContext);
    this.getHttpsHealthCheckCallable =
        callableFactory.createUnaryCallable(
            getHttpsHealthCheckTransportSettings,
            settings.getHttpsHealthCheckSettings(),
            clientContext);
    this.insertHttpsHealthCheckCallable =
        callableFactory.createUnaryCallable(
            insertHttpsHealthCheckTransportSettings,
            settings.insertHttpsHealthCheckSettings(),
            clientContext);
    this.listHttpsHealthChecksCallable =
        callableFactory.createUnaryCallable(
            listHttpsHealthChecksTransportSettings,
            settings.listHttpsHealthChecksSettings(),
            clientContext);
    this.listHttpsHealthChecksPagedCallable =
        callableFactory.createPagedCallable(
            listHttpsHealthChecksTransportSettings,
            settings.listHttpsHealthChecksSettings(),
            clientContext);
    this.patchHttpsHealthCheckCallable =
        callableFactory.createUnaryCallable(
            patchHttpsHealthCheckTransportSettings,
            settings.patchHttpsHealthCheckSettings(),
            clientContext);
    this.updateHttpsHealthCheckCallable =
        callableFactory.createUnaryCallable(
            updateHttpsHealthCheckTransportSettings,
            settings.updateHttpsHealthCheckSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteHttpsHealthCheckHttpRequest, Operation>
      deleteHttpsHealthCheckCallable() {
    return deleteHttpsHealthCheckCallable;
  }

  @BetaApi
  public UnaryCallable<GetHttpsHealthCheckHttpRequest, HttpsHealthCheck2>
      getHttpsHealthCheckCallable() {
    return getHttpsHealthCheckCallable;
  }

  @BetaApi
  public UnaryCallable<InsertHttpsHealthCheckHttpRequest, Operation>
      insertHttpsHealthCheckCallable() {
    return insertHttpsHealthCheckCallable;
  }

  @BetaApi
  public UnaryCallable<ListHttpsHealthChecksHttpRequest, ListHttpsHealthChecksPagedResponse>
      listHttpsHealthChecksPagedCallable() {
    return listHttpsHealthChecksPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListHttpsHealthChecksHttpRequest, HttpsHealthCheckList>
      listHttpsHealthChecksCallable() {
    return listHttpsHealthChecksCallable;
  }

  @BetaApi
  public UnaryCallable<PatchHttpsHealthCheckHttpRequest, Operation>
      patchHttpsHealthCheckCallable() {
    return patchHttpsHealthCheckCallable;
  }

  @BetaApi
  public UnaryCallable<UpdateHttpsHealthCheckHttpRequest, Operation>
      updateHttpsHealthCheckCallable() {
    return updateHttpsHealthCheckCallable;
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
