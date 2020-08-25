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

import static com.google.cloud.compute.v1.RegionHealthCheckServiceClient.ListRegionHealthCheckServicesPagedResponse;

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
import com.google.cloud.compute.v1.DeleteRegionHealthCheckServiceHttpRequest;
import com.google.cloud.compute.v1.GetRegionHealthCheckServiceHttpRequest;
import com.google.cloud.compute.v1.HealthCheckService;
import com.google.cloud.compute.v1.HealthCheckServicesList;
import com.google.cloud.compute.v1.InsertRegionHealthCheckServiceHttpRequest;
import com.google.cloud.compute.v1.ListRegionHealthCheckServicesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRegionHealthCheckServiceHttpRequest;
import com.google.cloud.compute.v1.ProjectRegionHealthCheckServiceName;
import com.google.cloud.compute.v1.ProjectRegionName;
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
public class HttpJsonRegionHealthCheckServiceStub extends RegionHealthCheckServiceStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteRegionHealthCheckServiceHttpRequest, Operation>
      deleteRegionHealthCheckServiceMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionHealthCheckServiceHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionHealthCheckServices.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<DeleteRegionHealthCheckServiceHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/healthCheckServices/{healthCheckService}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionHealthCheckServiceName.newFactory())
                      .setResourceNameField("healthCheckService")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          GetRegionHealthCheckServiceHttpRequest, HealthCheckService>
      getRegionHealthCheckServiceMethodDescriptor =
          ApiMethodDescriptor
              .<GetRegionHealthCheckServiceHttpRequest, HealthCheckService>newBuilder()
              .setFullMethodName("compute.regionHealthCheckServices.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<GetRegionHealthCheckServiceHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/healthCheckServices/{healthCheckService}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionHealthCheckServiceName.newFactory())
                      .setResourceNameField("healthCheckService")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<HealthCheckService>newBuilder()
                      .setResponseInstance(HealthCheckService.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertRegionHealthCheckServiceHttpRequest, Operation>
      insertRegionHealthCheckServiceMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionHealthCheckServiceHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionHealthCheckServices.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<InsertRegionHealthCheckServiceHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/healthCheckServices"))
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
          ListRegionHealthCheckServicesHttpRequest, HealthCheckServicesList>
      listRegionHealthCheckServicesMethodDescriptor =
          ApiMethodDescriptor
              .<ListRegionHealthCheckServicesHttpRequest, HealthCheckServicesList>newBuilder()
              .setFullMethodName("compute.regionHealthCheckServices.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<ListRegionHealthCheckServicesHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/healthCheckServices"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<HealthCheckServicesList>newBuilder()
                      .setResponseInstance(HealthCheckServicesList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchRegionHealthCheckServiceHttpRequest, Operation>
      patchRegionHealthCheckServiceMethodDescriptor =
          ApiMethodDescriptor.<PatchRegionHealthCheckServiceHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionHealthCheckServices.patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<PatchRegionHealthCheckServiceHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/healthCheckServices/{healthCheckService}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionHealthCheckServiceName.newFactory())
                      .setResourceNameField("healthCheckService")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteRegionHealthCheckServiceHttpRequest, Operation>
      deleteRegionHealthCheckServiceCallable;
  private final UnaryCallable<GetRegionHealthCheckServiceHttpRequest, HealthCheckService>
      getRegionHealthCheckServiceCallable;
  private final UnaryCallable<InsertRegionHealthCheckServiceHttpRequest, Operation>
      insertRegionHealthCheckServiceCallable;
  private final UnaryCallable<ListRegionHealthCheckServicesHttpRequest, HealthCheckServicesList>
      listRegionHealthCheckServicesCallable;
  private final UnaryCallable<
          ListRegionHealthCheckServicesHttpRequest, ListRegionHealthCheckServicesPagedResponse>
      listRegionHealthCheckServicesPagedCallable;
  private final UnaryCallable<PatchRegionHealthCheckServiceHttpRequest, Operation>
      patchRegionHealthCheckServiceCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionHealthCheckServiceStub create(
      RegionHealthCheckServiceStubSettings settings) throws IOException {
    return new HttpJsonRegionHealthCheckServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionHealthCheckServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionHealthCheckServiceStub(
        RegionHealthCheckServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionHealthCheckServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionHealthCheckServiceStub(
        RegionHealthCheckServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionHealthCheckServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionHealthCheckServiceStub(
      RegionHealthCheckServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRegionHealthCheckServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionHealthCheckServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionHealthCheckServiceStub(
      RegionHealthCheckServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteRegionHealthCheckServiceHttpRequest, Operation>
        deleteRegionHealthCheckServiceTransportSettings =
            HttpJsonCallSettings.<DeleteRegionHealthCheckServiceHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteRegionHealthCheckServiceMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetRegionHealthCheckServiceHttpRequest, HealthCheckService>
        getRegionHealthCheckServiceTransportSettings =
            HttpJsonCallSettings
                .<GetRegionHealthCheckServiceHttpRequest, HealthCheckService>newBuilder()
                .setMethodDescriptor(getRegionHealthCheckServiceMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertRegionHealthCheckServiceHttpRequest, Operation>
        insertRegionHealthCheckServiceTransportSettings =
            HttpJsonCallSettings.<InsertRegionHealthCheckServiceHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertRegionHealthCheckServiceMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListRegionHealthCheckServicesHttpRequest, HealthCheckServicesList>
        listRegionHealthCheckServicesTransportSettings =
            HttpJsonCallSettings
                .<ListRegionHealthCheckServicesHttpRequest, HealthCheckServicesList>newBuilder()
                .setMethodDescriptor(listRegionHealthCheckServicesMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchRegionHealthCheckServiceHttpRequest, Operation>
        patchRegionHealthCheckServiceTransportSettings =
            HttpJsonCallSettings.<PatchRegionHealthCheckServiceHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(patchRegionHealthCheckServiceMethodDescriptor)
                .build();

    this.deleteRegionHealthCheckServiceCallable =
        callableFactory.createUnaryCallable(
            deleteRegionHealthCheckServiceTransportSettings,
            settings.deleteRegionHealthCheckServiceSettings(),
            clientContext);
    this.getRegionHealthCheckServiceCallable =
        callableFactory.createUnaryCallable(
            getRegionHealthCheckServiceTransportSettings,
            settings.getRegionHealthCheckServiceSettings(),
            clientContext);
    this.insertRegionHealthCheckServiceCallable =
        callableFactory.createUnaryCallable(
            insertRegionHealthCheckServiceTransportSettings,
            settings.insertRegionHealthCheckServiceSettings(),
            clientContext);
    this.listRegionHealthCheckServicesCallable =
        callableFactory.createUnaryCallable(
            listRegionHealthCheckServicesTransportSettings,
            settings.listRegionHealthCheckServicesSettings(),
            clientContext);
    this.listRegionHealthCheckServicesPagedCallable =
        callableFactory.createPagedCallable(
            listRegionHealthCheckServicesTransportSettings,
            settings.listRegionHealthCheckServicesSettings(),
            clientContext);
    this.patchRegionHealthCheckServiceCallable =
        callableFactory.createUnaryCallable(
            patchRegionHealthCheckServiceTransportSettings,
            settings.patchRegionHealthCheckServiceSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteRegionHealthCheckServiceHttpRequest, Operation>
      deleteRegionHealthCheckServiceCallable() {
    return deleteRegionHealthCheckServiceCallable;
  }

  @BetaApi
  public UnaryCallable<GetRegionHealthCheckServiceHttpRequest, HealthCheckService>
      getRegionHealthCheckServiceCallable() {
    return getRegionHealthCheckServiceCallable;
  }

  @BetaApi
  public UnaryCallable<InsertRegionHealthCheckServiceHttpRequest, Operation>
      insertRegionHealthCheckServiceCallable() {
    return insertRegionHealthCheckServiceCallable;
  }

  @BetaApi
  public UnaryCallable<
          ListRegionHealthCheckServicesHttpRequest, ListRegionHealthCheckServicesPagedResponse>
      listRegionHealthCheckServicesPagedCallable() {
    return listRegionHealthCheckServicesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionHealthCheckServicesHttpRequest, HealthCheckServicesList>
      listRegionHealthCheckServicesCallable() {
    return listRegionHealthCheckServicesCallable;
  }

  @BetaApi
  public UnaryCallable<PatchRegionHealthCheckServiceHttpRequest, Operation>
      patchRegionHealthCheckServiceCallable() {
    return patchRegionHealthCheckServiceCallable;
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
