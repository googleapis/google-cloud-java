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

import static com.google.cloud.compute.v1.RegionHealthCheckClient.ListRegionHealthChecksPagedResponse;

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
import com.google.cloud.compute.v1.DeleteRegionHealthCheckHttpRequest;
import com.google.cloud.compute.v1.GetRegionHealthCheckHttpRequest;
import com.google.cloud.compute.v1.HealthCheck;
import com.google.cloud.compute.v1.HealthCheckList;
import com.google.cloud.compute.v1.InsertRegionHealthCheckHttpRequest;
import com.google.cloud.compute.v1.ListRegionHealthChecksHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRegionHealthCheckHttpRequest;
import com.google.cloud.compute.v1.ProjectRegionHealthCheckName;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.UpdateRegionHealthCheckHttpRequest;
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
public class HttpJsonRegionHealthCheckStub extends RegionHealthCheckStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteRegionHealthCheckHttpRequest, Operation>
      deleteRegionHealthCheckMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionHealthCheckHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionHealthChecks.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteRegionHealthCheckHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/healthChecks/{healthCheck}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionHealthCheckName.newFactory())
                      .setResourceNameField("healthCheck")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetRegionHealthCheckHttpRequest, HealthCheck>
      getRegionHealthCheckMethodDescriptor =
          ApiMethodDescriptor.<GetRegionHealthCheckHttpRequest, HealthCheck>newBuilder()
              .setFullMethodName("compute.regionHealthChecks.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetRegionHealthCheckHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/healthChecks/{healthCheck}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionHealthCheckName.newFactory())
                      .setResourceNameField("healthCheck")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<HealthCheck>newBuilder()
                      .setResponseInstance(HealthCheck.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertRegionHealthCheckHttpRequest, Operation>
      insertRegionHealthCheckMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionHealthCheckHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionHealthChecks.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertRegionHealthCheckHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/healthChecks"))
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
  public static final ApiMethodDescriptor<ListRegionHealthChecksHttpRequest, HealthCheckList>
      listRegionHealthChecksMethodDescriptor =
          ApiMethodDescriptor.<ListRegionHealthChecksHttpRequest, HealthCheckList>newBuilder()
              .setFullMethodName("compute.regionHealthChecks.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListRegionHealthChecksHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/healthChecks"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<HealthCheckList>newBuilder()
                      .setResponseInstance(HealthCheckList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchRegionHealthCheckHttpRequest, Operation>
      patchRegionHealthCheckMethodDescriptor =
          ApiMethodDescriptor.<PatchRegionHealthCheckHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionHealthChecks.patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<PatchRegionHealthCheckHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/healthChecks/{healthCheck}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionHealthCheckName.newFactory())
                      .setResourceNameField("healthCheck")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<UpdateRegionHealthCheckHttpRequest, Operation>
      updateRegionHealthCheckMethodDescriptor =
          ApiMethodDescriptor.<UpdateRegionHealthCheckHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionHealthChecks.update")
              .setHttpMethod(HttpMethods.PUT)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<UpdateRegionHealthCheckHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/healthChecks/{healthCheck}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionHealthCheckName.newFactory())
                      .setResourceNameField("healthCheck")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteRegionHealthCheckHttpRequest, Operation>
      deleteRegionHealthCheckCallable;
  private final UnaryCallable<GetRegionHealthCheckHttpRequest, HealthCheck>
      getRegionHealthCheckCallable;
  private final UnaryCallable<InsertRegionHealthCheckHttpRequest, Operation>
      insertRegionHealthCheckCallable;
  private final UnaryCallable<ListRegionHealthChecksHttpRequest, HealthCheckList>
      listRegionHealthChecksCallable;
  private final UnaryCallable<
          ListRegionHealthChecksHttpRequest, ListRegionHealthChecksPagedResponse>
      listRegionHealthChecksPagedCallable;
  private final UnaryCallable<PatchRegionHealthCheckHttpRequest, Operation>
      patchRegionHealthCheckCallable;
  private final UnaryCallable<UpdateRegionHealthCheckHttpRequest, Operation>
      updateRegionHealthCheckCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionHealthCheckStub create(RegionHealthCheckStubSettings settings)
      throws IOException {
    return new HttpJsonRegionHealthCheckStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionHealthCheckStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionHealthCheckStub(
        RegionHealthCheckStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionHealthCheckStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionHealthCheckStub(
        RegionHealthCheckStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionHealthCheckStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionHealthCheckStub(
      RegionHealthCheckStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRegionHealthCheckCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionHealthCheckStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionHealthCheckStub(
      RegionHealthCheckStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteRegionHealthCheckHttpRequest, Operation>
        deleteRegionHealthCheckTransportSettings =
            HttpJsonCallSettings.<DeleteRegionHealthCheckHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteRegionHealthCheckMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetRegionHealthCheckHttpRequest, HealthCheck>
        getRegionHealthCheckTransportSettings =
            HttpJsonCallSettings.<GetRegionHealthCheckHttpRequest, HealthCheck>newBuilder()
                .setMethodDescriptor(getRegionHealthCheckMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertRegionHealthCheckHttpRequest, Operation>
        insertRegionHealthCheckTransportSettings =
            HttpJsonCallSettings.<InsertRegionHealthCheckHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertRegionHealthCheckMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListRegionHealthChecksHttpRequest, HealthCheckList>
        listRegionHealthChecksTransportSettings =
            HttpJsonCallSettings.<ListRegionHealthChecksHttpRequest, HealthCheckList>newBuilder()
                .setMethodDescriptor(listRegionHealthChecksMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchRegionHealthCheckHttpRequest, Operation>
        patchRegionHealthCheckTransportSettings =
            HttpJsonCallSettings.<PatchRegionHealthCheckHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(patchRegionHealthCheckMethodDescriptor)
                .build();
    HttpJsonCallSettings<UpdateRegionHealthCheckHttpRequest, Operation>
        updateRegionHealthCheckTransportSettings =
            HttpJsonCallSettings.<UpdateRegionHealthCheckHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(updateRegionHealthCheckMethodDescriptor)
                .build();

    this.deleteRegionHealthCheckCallable =
        callableFactory.createUnaryCallable(
            deleteRegionHealthCheckTransportSettings,
            settings.deleteRegionHealthCheckSettings(),
            clientContext);
    this.getRegionHealthCheckCallable =
        callableFactory.createUnaryCallable(
            getRegionHealthCheckTransportSettings,
            settings.getRegionHealthCheckSettings(),
            clientContext);
    this.insertRegionHealthCheckCallable =
        callableFactory.createUnaryCallable(
            insertRegionHealthCheckTransportSettings,
            settings.insertRegionHealthCheckSettings(),
            clientContext);
    this.listRegionHealthChecksCallable =
        callableFactory.createUnaryCallable(
            listRegionHealthChecksTransportSettings,
            settings.listRegionHealthChecksSettings(),
            clientContext);
    this.listRegionHealthChecksPagedCallable =
        callableFactory.createPagedCallable(
            listRegionHealthChecksTransportSettings,
            settings.listRegionHealthChecksSettings(),
            clientContext);
    this.patchRegionHealthCheckCallable =
        callableFactory.createUnaryCallable(
            patchRegionHealthCheckTransportSettings,
            settings.patchRegionHealthCheckSettings(),
            clientContext);
    this.updateRegionHealthCheckCallable =
        callableFactory.createUnaryCallable(
            updateRegionHealthCheckTransportSettings,
            settings.updateRegionHealthCheckSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteRegionHealthCheckHttpRequest, Operation>
      deleteRegionHealthCheckCallable() {
    return deleteRegionHealthCheckCallable;
  }

  @BetaApi
  public UnaryCallable<GetRegionHealthCheckHttpRequest, HealthCheck>
      getRegionHealthCheckCallable() {
    return getRegionHealthCheckCallable;
  }

  @BetaApi
  public UnaryCallable<InsertRegionHealthCheckHttpRequest, Operation>
      insertRegionHealthCheckCallable() {
    return insertRegionHealthCheckCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionHealthChecksHttpRequest, ListRegionHealthChecksPagedResponse>
      listRegionHealthChecksPagedCallable() {
    return listRegionHealthChecksPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionHealthChecksHttpRequest, HealthCheckList>
      listRegionHealthChecksCallable() {
    return listRegionHealthChecksCallable;
  }

  @BetaApi
  public UnaryCallable<PatchRegionHealthCheckHttpRequest, Operation>
      patchRegionHealthCheckCallable() {
    return patchRegionHealthCheckCallable;
  }

  @BetaApi
  public UnaryCallable<UpdateRegionHealthCheckHttpRequest, Operation>
      updateRegionHealthCheckCallable() {
    return updateRegionHealthCheckCallable;
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
