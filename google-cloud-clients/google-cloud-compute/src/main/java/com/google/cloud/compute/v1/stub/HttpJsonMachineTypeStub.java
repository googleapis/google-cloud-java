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

import static com.google.cloud.compute.v1.MachineTypeClient.AggregatedListMachineTypesPagedResponse;
import static com.google.cloud.compute.v1.MachineTypeClient.ListMachineTypesPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListMachineTypesHttpRequest;
import com.google.cloud.compute.v1.GetMachineTypeHttpRequest;
import com.google.cloud.compute.v1.ListMachineTypesHttpRequest;
import com.google.cloud.compute.v1.MachineType;
import com.google.cloud.compute.v1.MachineTypeAggregatedList;
import com.google.cloud.compute.v1.MachineTypeList;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectZoneMachineTypeName;
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
public class HttpJsonMachineTypeStub extends MachineTypeStub {
  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListMachineTypesHttpRequest, MachineTypeAggregatedList>
      aggregatedListMachineTypesMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListMachineTypesHttpRequest, MachineTypeAggregatedList>newBuilder()
              .setFullMethodName("compute.machineTypes.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<AggregatedListMachineTypesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/aggregated/machineTypes"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<MachineTypeAggregatedList>newBuilder()
                      .setResponseInstance(MachineTypeAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetMachineTypeHttpRequest, MachineType>
      getMachineTypeMethodDescriptor =
          ApiMethodDescriptor.<GetMachineTypeHttpRequest, MachineType>newBuilder()
              .setFullMethodName("compute.machineTypes.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetMachineTypeHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/zones/{zone}/machineTypes/{machineType}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectZoneMachineTypeName.newFactory())
                      .setResourceNameField("machineType")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<MachineType>newBuilder()
                      .setResponseInstance(MachineType.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListMachineTypesHttpRequest, MachineTypeList>
      listMachineTypesMethodDescriptor =
          ApiMethodDescriptor.<ListMachineTypesHttpRequest, MachineTypeList>newBuilder()
              .setFullMethodName("compute.machineTypes.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListMachineTypesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/zones/{zone}/machineTypes"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectZoneName.newFactory())
                      .setResourceNameField("zone")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<MachineTypeList>newBuilder()
                      .setResponseInstance(MachineTypeList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AggregatedListMachineTypesHttpRequest, MachineTypeAggregatedList>
      aggregatedListMachineTypesCallable;
  private final UnaryCallable<
          AggregatedListMachineTypesHttpRequest, AggregatedListMachineTypesPagedResponse>
      aggregatedListMachineTypesPagedCallable;
  private final UnaryCallable<GetMachineTypeHttpRequest, MachineType> getMachineTypeCallable;
  private final UnaryCallable<ListMachineTypesHttpRequest, MachineTypeList>
      listMachineTypesCallable;
  private final UnaryCallable<ListMachineTypesHttpRequest, ListMachineTypesPagedResponse>
      listMachineTypesPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonMachineTypeStub create(MachineTypeStubSettings settings)
      throws IOException {
    return new HttpJsonMachineTypeStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonMachineTypeStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonMachineTypeStub(MachineTypeStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonMachineTypeStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonMachineTypeStub(
        MachineTypeStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonMachineTypeStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonMachineTypeStub(MachineTypeStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonMachineTypeCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonMachineTypeStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonMachineTypeStub(
      MachineTypeStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListMachineTypesHttpRequest, MachineTypeAggregatedList>
        aggregatedListMachineTypesTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListMachineTypesHttpRequest, MachineTypeAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMachineTypesMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetMachineTypeHttpRequest, MachineType> getMachineTypeTransportSettings =
        HttpJsonCallSettings.<GetMachineTypeHttpRequest, MachineType>newBuilder()
            .setMethodDescriptor(getMachineTypeMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListMachineTypesHttpRequest, MachineTypeList>
        listMachineTypesTransportSettings =
            HttpJsonCallSettings.<ListMachineTypesHttpRequest, MachineTypeList>newBuilder()
                .setMethodDescriptor(listMachineTypesMethodDescriptor)
                .build();

    this.aggregatedListMachineTypesCallable =
        callableFactory.createUnaryCallable(
            aggregatedListMachineTypesTransportSettings,
            settings.aggregatedListMachineTypesSettings(),
            clientContext);
    this.aggregatedListMachineTypesPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListMachineTypesTransportSettings,
            settings.aggregatedListMachineTypesSettings(),
            clientContext);
    this.getMachineTypeCallable =
        callableFactory.createUnaryCallable(
            getMachineTypeTransportSettings, settings.getMachineTypeSettings(), clientContext);
    this.listMachineTypesCallable =
        callableFactory.createUnaryCallable(
            listMachineTypesTransportSettings, settings.listMachineTypesSettings(), clientContext);
    this.listMachineTypesPagedCallable =
        callableFactory.createPagedCallable(
            listMachineTypesTransportSettings, settings.listMachineTypesSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<
          AggregatedListMachineTypesHttpRequest, AggregatedListMachineTypesPagedResponse>
      aggregatedListMachineTypesPagedCallable() {
    return aggregatedListMachineTypesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListMachineTypesHttpRequest, MachineTypeAggregatedList>
      aggregatedListMachineTypesCallable() {
    return aggregatedListMachineTypesCallable;
  }

  @BetaApi
  public UnaryCallable<GetMachineTypeHttpRequest, MachineType> getMachineTypeCallable() {
    return getMachineTypeCallable;
  }

  @BetaApi
  public UnaryCallable<ListMachineTypesHttpRequest, ListMachineTypesPagedResponse>
      listMachineTypesPagedCallable() {
    return listMachineTypesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListMachineTypesHttpRequest, MachineTypeList> listMachineTypesCallable() {
    return listMachineTypesCallable;
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
