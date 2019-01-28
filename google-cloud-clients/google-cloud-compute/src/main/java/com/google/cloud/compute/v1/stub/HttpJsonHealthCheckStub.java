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

import static com.google.cloud.compute.v1.HealthCheckClient.ListHealthChecksPagedResponse;

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
import com.google.cloud.compute.v1.DeleteHealthCheckHttpRequest;
import com.google.cloud.compute.v1.GetHealthCheckHttpRequest;
import com.google.cloud.compute.v1.HealthCheck;
import com.google.cloud.compute.v1.HealthCheckList;
import com.google.cloud.compute.v1.InsertHealthCheckHttpRequest;
import com.google.cloud.compute.v1.ListHealthChecksHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchHealthCheckHttpRequest;
import com.google.cloud.compute.v1.ProjectGlobalHealthCheckName;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.UpdateHealthCheckHttpRequest;
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
public class HttpJsonHealthCheckStub extends HealthCheckStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteHealthCheckHttpRequest, Operation>
      deleteHealthCheckMethodDescriptor =
          ApiMethodDescriptor.<DeleteHealthCheckHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.healthChecks.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteHealthCheckHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/healthChecks/{healthCheck}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalHealthCheckName.newFactory())
                      .setResourceNameField("healthCheck")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetHealthCheckHttpRequest, HealthCheck>
      getHealthCheckMethodDescriptor =
          ApiMethodDescriptor.<GetHealthCheckHttpRequest, HealthCheck>newBuilder()
              .setFullMethodName("compute.healthChecks.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetHealthCheckHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/healthChecks/{healthCheck}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalHealthCheckName.newFactory())
                      .setResourceNameField("healthCheck")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<HealthCheck>newBuilder()
                      .setResponseInstance(HealthCheck.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertHealthCheckHttpRequest, Operation>
      insertHealthCheckMethodDescriptor =
          ApiMethodDescriptor.<InsertHealthCheckHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.healthChecks.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertHealthCheckHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/healthChecks"))
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
  public static final ApiMethodDescriptor<ListHealthChecksHttpRequest, HealthCheckList>
      listHealthChecksMethodDescriptor =
          ApiMethodDescriptor.<ListHealthChecksHttpRequest, HealthCheckList>newBuilder()
              .setFullMethodName("compute.healthChecks.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListHealthChecksHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/healthChecks"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<HealthCheckList>newBuilder()
                      .setResponseInstance(HealthCheckList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchHealthCheckHttpRequest, Operation>
      patchHealthCheckMethodDescriptor =
          ApiMethodDescriptor.<PatchHealthCheckHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.healthChecks.patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<PatchHealthCheckHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/healthChecks/{healthCheck}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalHealthCheckName.newFactory())
                      .setResourceNameField("healthCheck")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<UpdateHealthCheckHttpRequest, Operation>
      updateHealthCheckMethodDescriptor =
          ApiMethodDescriptor.<UpdateHealthCheckHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.healthChecks.update")
              .setHttpMethod(HttpMethods.PUT)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<UpdateHealthCheckHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/healthChecks/{healthCheck}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalHealthCheckName.newFactory())
                      .setResourceNameField("healthCheck")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteHealthCheckHttpRequest, Operation> deleteHealthCheckCallable;
  private final UnaryCallable<GetHealthCheckHttpRequest, HealthCheck> getHealthCheckCallable;
  private final UnaryCallable<InsertHealthCheckHttpRequest, Operation> insertHealthCheckCallable;
  private final UnaryCallable<ListHealthChecksHttpRequest, HealthCheckList>
      listHealthChecksCallable;
  private final UnaryCallable<ListHealthChecksHttpRequest, ListHealthChecksPagedResponse>
      listHealthChecksPagedCallable;
  private final UnaryCallable<PatchHealthCheckHttpRequest, Operation> patchHealthCheckCallable;
  private final UnaryCallable<UpdateHealthCheckHttpRequest, Operation> updateHealthCheckCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonHealthCheckStub create(HealthCheckStubSettings settings)
      throws IOException {
    return new HttpJsonHealthCheckStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonHealthCheckStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonHealthCheckStub(HealthCheckStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonHealthCheckStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonHealthCheckStub(
        HealthCheckStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonHealthCheckStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonHealthCheckStub(HealthCheckStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonHealthCheckCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonHealthCheckStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonHealthCheckStub(
      HealthCheckStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteHealthCheckHttpRequest, Operation>
        deleteHealthCheckTransportSettings =
            HttpJsonCallSettings.<DeleteHealthCheckHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteHealthCheckMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetHealthCheckHttpRequest, HealthCheck> getHealthCheckTransportSettings =
        HttpJsonCallSettings.<GetHealthCheckHttpRequest, HealthCheck>newBuilder()
            .setMethodDescriptor(getHealthCheckMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertHealthCheckHttpRequest, Operation>
        insertHealthCheckTransportSettings =
            HttpJsonCallSettings.<InsertHealthCheckHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertHealthCheckMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListHealthChecksHttpRequest, HealthCheckList>
        listHealthChecksTransportSettings =
            HttpJsonCallSettings.<ListHealthChecksHttpRequest, HealthCheckList>newBuilder()
                .setMethodDescriptor(listHealthChecksMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchHealthCheckHttpRequest, Operation> patchHealthCheckTransportSettings =
        HttpJsonCallSettings.<PatchHealthCheckHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(patchHealthCheckMethodDescriptor)
            .build();
    HttpJsonCallSettings<UpdateHealthCheckHttpRequest, Operation>
        updateHealthCheckTransportSettings =
            HttpJsonCallSettings.<UpdateHealthCheckHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(updateHealthCheckMethodDescriptor)
                .build();

    this.deleteHealthCheckCallable =
        callableFactory.createUnaryCallable(
            deleteHealthCheckTransportSettings,
            settings.deleteHealthCheckSettings(),
            clientContext);
    this.getHealthCheckCallable =
        callableFactory.createUnaryCallable(
            getHealthCheckTransportSettings, settings.getHealthCheckSettings(), clientContext);
    this.insertHealthCheckCallable =
        callableFactory.createUnaryCallable(
            insertHealthCheckTransportSettings,
            settings.insertHealthCheckSettings(),
            clientContext);
    this.listHealthChecksCallable =
        callableFactory.createUnaryCallable(
            listHealthChecksTransportSettings, settings.listHealthChecksSettings(), clientContext);
    this.listHealthChecksPagedCallable =
        callableFactory.createPagedCallable(
            listHealthChecksTransportSettings, settings.listHealthChecksSettings(), clientContext);
    this.patchHealthCheckCallable =
        callableFactory.createUnaryCallable(
            patchHealthCheckTransportSettings, settings.patchHealthCheckSettings(), clientContext);
    this.updateHealthCheckCallable =
        callableFactory.createUnaryCallable(
            updateHealthCheckTransportSettings,
            settings.updateHealthCheckSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteHealthCheckHttpRequest, Operation> deleteHealthCheckCallable() {
    return deleteHealthCheckCallable;
  }

  @BetaApi
  public UnaryCallable<GetHealthCheckHttpRequest, HealthCheck> getHealthCheckCallable() {
    return getHealthCheckCallable;
  }

  @BetaApi
  public UnaryCallable<InsertHealthCheckHttpRequest, Operation> insertHealthCheckCallable() {
    return insertHealthCheckCallable;
  }

  @BetaApi
  public UnaryCallable<ListHealthChecksHttpRequest, ListHealthChecksPagedResponse>
      listHealthChecksPagedCallable() {
    return listHealthChecksPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListHealthChecksHttpRequest, HealthCheckList> listHealthChecksCallable() {
    return listHealthChecksCallable;
  }

  @BetaApi
  public UnaryCallable<PatchHealthCheckHttpRequest, Operation> patchHealthCheckCallable() {
    return patchHealthCheckCallable;
  }

  @BetaApi
  public UnaryCallable<UpdateHealthCheckHttpRequest, Operation> updateHealthCheckCallable() {
    return updateHealthCheckCallable;
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
