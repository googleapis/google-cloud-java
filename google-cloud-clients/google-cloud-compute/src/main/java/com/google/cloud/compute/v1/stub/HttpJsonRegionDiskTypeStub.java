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

import static com.google.cloud.compute.v1.RegionDiskTypeClient.ListRegionDiskTypesPagedResponse;

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
import com.google.cloud.compute.v1.DiskType;
import com.google.cloud.compute.v1.GetRegionDiskTypeHttpRequest;
import com.google.cloud.compute.v1.ListRegionDiskTypesHttpRequest;
import com.google.cloud.compute.v1.ProjectRegionDiskTypeName;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.RegionDiskTypeList;
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
public class HttpJsonRegionDiskTypeStub extends RegionDiskTypeStub {
  @InternalApi
  public static final ApiMethodDescriptor<GetRegionDiskTypeHttpRequest, DiskType>
      getRegionDiskTypeMethodDescriptor =
          ApiMethodDescriptor.<GetRegionDiskTypeHttpRequest, DiskType>newBuilder()
              .setFullMethodName("compute.regionDiskTypes.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetRegionDiskTypeHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/diskTypes/{diskType}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionDiskTypeName.newFactory())
                      .setResourceNameField("diskType")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<DiskType>newBuilder()
                      .setResponseInstance(DiskType.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListRegionDiskTypesHttpRequest, RegionDiskTypeList>
      listRegionDiskTypesMethodDescriptor =
          ApiMethodDescriptor.<ListRegionDiskTypesHttpRequest, RegionDiskTypeList>newBuilder()
              .setFullMethodName("compute.regionDiskTypes.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListRegionDiskTypesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/regions/{region}/diskTypes"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<RegionDiskTypeList>newBuilder()
                      .setResponseInstance(RegionDiskTypeList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<GetRegionDiskTypeHttpRequest, DiskType> getRegionDiskTypeCallable;
  private final UnaryCallable<ListRegionDiskTypesHttpRequest, RegionDiskTypeList>
      listRegionDiskTypesCallable;
  private final UnaryCallable<ListRegionDiskTypesHttpRequest, ListRegionDiskTypesPagedResponse>
      listRegionDiskTypesPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionDiskTypeStub create(RegionDiskTypeStubSettings settings)
      throws IOException {
    return new HttpJsonRegionDiskTypeStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionDiskTypeStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionDiskTypeStub(
        RegionDiskTypeStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionDiskTypeStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionDiskTypeStub(
        RegionDiskTypeStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionDiskTypeStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionDiskTypeStub(
      RegionDiskTypeStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRegionDiskTypeCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionDiskTypeStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionDiskTypeStub(
      RegionDiskTypeStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetRegionDiskTypeHttpRequest, DiskType>
        getRegionDiskTypeTransportSettings =
            HttpJsonCallSettings.<GetRegionDiskTypeHttpRequest, DiskType>newBuilder()
                .setMethodDescriptor(getRegionDiskTypeMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListRegionDiskTypesHttpRequest, RegionDiskTypeList>
        listRegionDiskTypesTransportSettings =
            HttpJsonCallSettings.<ListRegionDiskTypesHttpRequest, RegionDiskTypeList>newBuilder()
                .setMethodDescriptor(listRegionDiskTypesMethodDescriptor)
                .build();

    this.getRegionDiskTypeCallable =
        callableFactory.createUnaryCallable(
            getRegionDiskTypeTransportSettings,
            settings.getRegionDiskTypeSettings(),
            clientContext);
    this.listRegionDiskTypesCallable =
        callableFactory.createUnaryCallable(
            listRegionDiskTypesTransportSettings,
            settings.listRegionDiskTypesSettings(),
            clientContext);
    this.listRegionDiskTypesPagedCallable =
        callableFactory.createPagedCallable(
            listRegionDiskTypesTransportSettings,
            settings.listRegionDiskTypesSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<GetRegionDiskTypeHttpRequest, DiskType> getRegionDiskTypeCallable() {
    return getRegionDiskTypeCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionDiskTypesHttpRequest, ListRegionDiskTypesPagedResponse>
      listRegionDiskTypesPagedCallable() {
    return listRegionDiskTypesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionDiskTypesHttpRequest, RegionDiskTypeList>
      listRegionDiskTypesCallable() {
    return listRegionDiskTypesCallable;
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
