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

import static com.google.cloud.compute.v1.DiskTypeClient.AggregatedListDiskTypesPagedResponse;
import static com.google.cloud.compute.v1.DiskTypeClient.ListDiskTypesPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListDiskTypesHttpRequest;
import com.google.cloud.compute.v1.DiskType;
import com.google.cloud.compute.v1.DiskTypeAggregatedList;
import com.google.cloud.compute.v1.DiskTypeList;
import com.google.cloud.compute.v1.GetDiskTypeHttpRequest;
import com.google.cloud.compute.v1.ListDiskTypesHttpRequest;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectZoneDiskTypeName;
import com.google.cloud.compute.v1.ProjectZoneName;
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
public class HttpJsonDiskTypeStub extends DiskTypeStub {
  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListDiskTypesHttpRequest, DiskTypeAggregatedList>
      aggregatedListDiskTypesMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListDiskTypesHttpRequest, DiskTypeAggregatedList>newBuilder()
              .setFullMethodName("compute.diskTypes.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<AggregatedListDiskTypesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/aggregated/diskTypes"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<DiskTypeAggregatedList>newBuilder()
                      .setResponseInstance(DiskTypeAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetDiskTypeHttpRequest, DiskType>
      getDiskTypeMethodDescriptor =
          ApiMethodDescriptor.<GetDiskTypeHttpRequest, DiskType>newBuilder()
              .setFullMethodName("compute.diskTypes.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetDiskTypeHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/zones/{zone}/diskTypes/{diskType}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectZoneDiskTypeName.newFactory())
                      .setResourceNameField("diskType")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<DiskType>newBuilder()
                      .setResponseInstance(DiskType.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListDiskTypesHttpRequest, DiskTypeList>
      listDiskTypesMethodDescriptor =
          ApiMethodDescriptor.<ListDiskTypesHttpRequest, DiskTypeList>newBuilder()
              .setFullMethodName("compute.diskTypes.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListDiskTypesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/zones/{zone}/diskTypes"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectZoneName.newFactory())
                      .setResourceNameField("zone")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<DiskTypeList>newBuilder()
                      .setResponseInstance(DiskTypeList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AggregatedListDiskTypesHttpRequest, DiskTypeAggregatedList>
      aggregatedListDiskTypesCallable;
  private final UnaryCallable<
          AggregatedListDiskTypesHttpRequest, AggregatedListDiskTypesPagedResponse>
      aggregatedListDiskTypesPagedCallable;
  private final UnaryCallable<GetDiskTypeHttpRequest, DiskType> getDiskTypeCallable;
  private final UnaryCallable<ListDiskTypesHttpRequest, DiskTypeList> listDiskTypesCallable;
  private final UnaryCallable<ListDiskTypesHttpRequest, ListDiskTypesPagedResponse>
      listDiskTypesPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDiskTypeStub create(DiskTypeStubSettings settings)
      throws IOException {
    return new HttpJsonDiskTypeStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDiskTypeStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonDiskTypeStub(DiskTypeStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonDiskTypeStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDiskTypeStub(
        DiskTypeStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDiskTypeStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDiskTypeStub(DiskTypeStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonDiskTypeCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDiskTypeStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDiskTypeStub(
      DiskTypeStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListDiskTypesHttpRequest, DiskTypeAggregatedList>
        aggregatedListDiskTypesTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListDiskTypesHttpRequest, DiskTypeAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListDiskTypesMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetDiskTypeHttpRequest, DiskType> getDiskTypeTransportSettings =
        HttpJsonCallSettings.<GetDiskTypeHttpRequest, DiskType>newBuilder()
            .setMethodDescriptor(getDiskTypeMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListDiskTypesHttpRequest, DiskTypeList> listDiskTypesTransportSettings =
        HttpJsonCallSettings.<ListDiskTypesHttpRequest, DiskTypeList>newBuilder()
            .setMethodDescriptor(listDiskTypesMethodDescriptor)
            .build();

    this.aggregatedListDiskTypesCallable =
        callableFactory.createUnaryCallable(
            aggregatedListDiskTypesTransportSettings,
            settings.aggregatedListDiskTypesSettings(),
            clientContext);
    this.aggregatedListDiskTypesPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListDiskTypesTransportSettings,
            settings.aggregatedListDiskTypesSettings(),
            clientContext);
    this.getDiskTypeCallable =
        callableFactory.createUnaryCallable(
            getDiskTypeTransportSettings, settings.getDiskTypeSettings(), clientContext);
    this.listDiskTypesCallable =
        callableFactory.createUnaryCallable(
            listDiskTypesTransportSettings, settings.listDiskTypesSettings(), clientContext);
    this.listDiskTypesPagedCallable =
        callableFactory.createPagedCallable(
            listDiskTypesTransportSettings, settings.listDiskTypesSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<AggregatedListDiskTypesHttpRequest, AggregatedListDiskTypesPagedResponse>
      aggregatedListDiskTypesPagedCallable() {
    return aggregatedListDiskTypesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListDiskTypesHttpRequest, DiskTypeAggregatedList>
      aggregatedListDiskTypesCallable() {
    return aggregatedListDiskTypesCallable;
  }

  @BetaApi
  public UnaryCallable<GetDiskTypeHttpRequest, DiskType> getDiskTypeCallable() {
    return getDiskTypeCallable;
  }

  @BetaApi
  public UnaryCallable<ListDiskTypesHttpRequest, ListDiskTypesPagedResponse>
      listDiskTypesPagedCallable() {
    return listDiskTypesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListDiskTypesHttpRequest, DiskTypeList> listDiskTypesCallable() {
    return listDiskTypesCallable;
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
