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

import static com.google.cloud.compute.v1.InterconnectLocationClient.ListInterconnectLocationsPagedResponse;

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
import com.google.cloud.compute.v1.GetInterconnectLocationHttpRequest;
import com.google.cloud.compute.v1.InterconnectLocation;
import com.google.cloud.compute.v1.InterconnectLocationList;
import com.google.cloud.compute.v1.ListInterconnectLocationsHttpRequest;
import com.google.cloud.compute.v1.ProjectGlobalInterconnectLocationName;
import com.google.cloud.compute.v1.ProjectName;
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
public class HttpJsonInterconnectLocationStub extends InterconnectLocationStub {
  @InternalApi
  public static final ApiMethodDescriptor<GetInterconnectLocationHttpRequest, InterconnectLocation>
      getInterconnectLocationMethodDescriptor =
          ApiMethodDescriptor.<GetInterconnectLocationHttpRequest, InterconnectLocation>newBuilder()
              .setFullMethodName("compute.interconnectLocations.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetInterconnectLocationHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/interconnectLocations/{interconnectLocation}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalInterconnectLocationName.newFactory())
                      .setResourceNameField("interconnectLocation")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<InterconnectLocation>newBuilder()
                      .setResponseInstance(InterconnectLocation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          ListInterconnectLocationsHttpRequest, InterconnectLocationList>
      listInterconnectLocationsMethodDescriptor =
          ApiMethodDescriptor
              .<ListInterconnectLocationsHttpRequest, InterconnectLocationList>newBuilder()
              .setFullMethodName("compute.interconnectLocations.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListInterconnectLocationsHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/interconnectLocations"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<InterconnectLocationList>newBuilder()
                      .setResponseInstance(InterconnectLocationList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<GetInterconnectLocationHttpRequest, InterconnectLocation>
      getInterconnectLocationCallable;
  private final UnaryCallable<ListInterconnectLocationsHttpRequest, InterconnectLocationList>
      listInterconnectLocationsCallable;
  private final UnaryCallable<
          ListInterconnectLocationsHttpRequest, ListInterconnectLocationsPagedResponse>
      listInterconnectLocationsPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonInterconnectLocationStub create(
      InterconnectLocationStubSettings settings) throws IOException {
    return new HttpJsonInterconnectLocationStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonInterconnectLocationStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonInterconnectLocationStub(
        InterconnectLocationStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonInterconnectLocationStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonInterconnectLocationStub(
        InterconnectLocationStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonInterconnectLocationStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonInterconnectLocationStub(
      InterconnectLocationStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonInterconnectLocationCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonInterconnectLocationStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonInterconnectLocationStub(
      InterconnectLocationStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetInterconnectLocationHttpRequest, InterconnectLocation>
        getInterconnectLocationTransportSettings =
            HttpJsonCallSettings
                .<GetInterconnectLocationHttpRequest, InterconnectLocation>newBuilder()
                .setMethodDescriptor(getInterconnectLocationMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListInterconnectLocationsHttpRequest, InterconnectLocationList>
        listInterconnectLocationsTransportSettings =
            HttpJsonCallSettings
                .<ListInterconnectLocationsHttpRequest, InterconnectLocationList>newBuilder()
                .setMethodDescriptor(listInterconnectLocationsMethodDescriptor)
                .build();

    this.getInterconnectLocationCallable =
        callableFactory.createUnaryCallable(
            getInterconnectLocationTransportSettings,
            settings.getInterconnectLocationSettings(),
            clientContext);
    this.listInterconnectLocationsCallable =
        callableFactory.createUnaryCallable(
            listInterconnectLocationsTransportSettings,
            settings.listInterconnectLocationsSettings(),
            clientContext);
    this.listInterconnectLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listInterconnectLocationsTransportSettings,
            settings.listInterconnectLocationsSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<GetInterconnectLocationHttpRequest, InterconnectLocation>
      getInterconnectLocationCallable() {
    return getInterconnectLocationCallable;
  }

  @BetaApi
  public UnaryCallable<ListInterconnectLocationsHttpRequest, ListInterconnectLocationsPagedResponse>
      listInterconnectLocationsPagedCallable() {
    return listInterconnectLocationsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListInterconnectLocationsHttpRequest, InterconnectLocationList>
      listInterconnectLocationsCallable() {
    return listInterconnectLocationsCallable;
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
