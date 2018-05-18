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

import static com.google.cloud.compute.v1.ZoneClient.ListZonesPagedResponse;

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
import com.google.cloud.compute.v1.GetZoneHttpRequest;
import com.google.cloud.compute.v1.ListZonesHttpRequest;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectZoneName;
import com.google.cloud.compute.v1.Zone;
import com.google.cloud.compute.v1.ZoneList;
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
public class HttpJsonZoneStub extends ZoneStub {
  @InternalApi
  public static final ApiMethodDescriptor<GetZoneHttpRequest, Zone> getZoneMethodDescriptor =
      ApiMethodDescriptor.<GetZoneHttpRequest, Zone>newBuilder()
          .setFullMethodName("compute.zones.get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ApiMessageHttpRequestFormatter.<GetZoneHttpRequest>newBuilder()
                  .setPathTemplate(PathTemplate.create("{project}/zones/{zone}"))
                  .setQueryParams(Sets.<String>newHashSet())
                  .setResourceNameFactory(ProjectZoneName.newFactory())
                  .setResourceNameField("zone")
                  .build())
          .setResponseParser(
              ApiMessageHttpResponseParser.<Zone>newBuilder()
                  .setResponseInstance(Zone.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListZonesHttpRequest, ZoneList>
      listZonesMethodDescriptor =
          ApiMethodDescriptor.<ListZonesHttpRequest, ZoneList>newBuilder()
              .setFullMethodName("compute.zones.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListZonesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/zones"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<ZoneList>newBuilder()
                      .setResponseInstance(ZoneList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<GetZoneHttpRequest, Zone> getZoneCallable;
  private final UnaryCallable<ListZonesHttpRequest, ZoneList> listZonesCallable;
  private final UnaryCallable<ListZonesHttpRequest, ListZonesPagedResponse> listZonesPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonZoneStub create(ZoneStubSettings settings) throws IOException {
    return new HttpJsonZoneStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonZoneStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonZoneStub(ZoneStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonZoneStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonZoneStub(
        ZoneStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonZoneStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected HttpJsonZoneStub(ZoneStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonZoneCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonZoneStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected HttpJsonZoneStub(
      ZoneStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetZoneHttpRequest, Zone> getZoneTransportSettings =
        HttpJsonCallSettings.<GetZoneHttpRequest, Zone>newBuilder()
            .setMethodDescriptor(getZoneMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListZonesHttpRequest, ZoneList> listZonesTransportSettings =
        HttpJsonCallSettings.<ListZonesHttpRequest, ZoneList>newBuilder()
            .setMethodDescriptor(listZonesMethodDescriptor)
            .build();

    this.getZoneCallable =
        callableFactory.createUnaryCallable(
            getZoneTransportSettings, settings.getZoneSettings(), clientContext);
    this.listZonesCallable =
        callableFactory.createUnaryCallable(
            listZonesTransportSettings, settings.listZonesSettings(), clientContext);
    this.listZonesPagedCallable =
        callableFactory.createPagedCallable(
            listZonesTransportSettings, settings.listZonesSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<GetZoneHttpRequest, Zone> getZoneCallable() {
    return getZoneCallable;
  }

  @BetaApi
  public UnaryCallable<ListZonesHttpRequest, ListZonesPagedResponse> listZonesPagedCallable() {
    return listZonesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListZonesHttpRequest, ZoneList> listZonesCallable() {
    return listZonesCallable;
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
