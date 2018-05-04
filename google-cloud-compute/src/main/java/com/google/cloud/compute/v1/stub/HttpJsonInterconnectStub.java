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

import static com.google.cloud.compute.v1.InterconnectClient.ListInterconnectsPagedResponse;

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
import com.google.cloud.compute.v1.DeleteInterconnectHttpRequest;
import com.google.cloud.compute.v1.GetInterconnectHttpRequest;
import com.google.cloud.compute.v1.InsertInterconnectHttpRequest;
import com.google.cloud.compute.v1.Interconnect;
import com.google.cloud.compute.v1.InterconnectList;
import com.google.cloud.compute.v1.ListInterconnectsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchInterconnectHttpRequest;
import com.google.cloud.compute.v1.ProjectGlobalInterconnectName;
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
public class HttpJsonInterconnectStub extends InterconnectStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteInterconnectHttpRequest, Operation>
      deleteInterconnectMethodDescriptor =
          ApiMethodDescriptor.<DeleteInterconnectHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.interconnects.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteInterconnectHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/interconnects/{interconnect}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalInterconnectName.newFactory())
                      .setResourceNameField("interconnect")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetInterconnectHttpRequest, Interconnect>
      getInterconnectMethodDescriptor =
          ApiMethodDescriptor.<GetInterconnectHttpRequest, Interconnect>newBuilder()
              .setFullMethodName("compute.interconnects.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetInterconnectHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/interconnects/{interconnect}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalInterconnectName.newFactory())
                      .setResourceNameField("interconnect")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Interconnect>newBuilder()
                      .setResponseInstance(Interconnect.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertInterconnectHttpRequest, Operation>
      insertInterconnectMethodDescriptor =
          ApiMethodDescriptor.<InsertInterconnectHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.interconnects.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertInterconnectHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/interconnects"))
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
  public static final ApiMethodDescriptor<ListInterconnectsHttpRequest, InterconnectList>
      listInterconnectsMethodDescriptor =
          ApiMethodDescriptor.<ListInterconnectsHttpRequest, InterconnectList>newBuilder()
              .setFullMethodName("compute.interconnects.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListInterconnectsHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/interconnects"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<InterconnectList>newBuilder()
                      .setResponseInstance(InterconnectList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchInterconnectHttpRequest, Operation>
      patchInterconnectMethodDescriptor =
          ApiMethodDescriptor.<PatchInterconnectHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.interconnects.patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<PatchInterconnectHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/interconnects/{interconnect}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalInterconnectName.newFactory())
                      .setResourceNameField("interconnect")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteInterconnectHttpRequest, Operation> deleteInterconnectCallable;
  private final UnaryCallable<GetInterconnectHttpRequest, Interconnect> getInterconnectCallable;
  private final UnaryCallable<InsertInterconnectHttpRequest, Operation> insertInterconnectCallable;
  private final UnaryCallable<ListInterconnectsHttpRequest, InterconnectList>
      listInterconnectsCallable;
  private final UnaryCallable<ListInterconnectsHttpRequest, ListInterconnectsPagedResponse>
      listInterconnectsPagedCallable;
  private final UnaryCallable<PatchInterconnectHttpRequest, Operation> patchInterconnectCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonInterconnectStub create(InterconnectStubSettings settings)
      throws IOException {
    return new HttpJsonInterconnectStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonInterconnectStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonInterconnectStub(
        InterconnectStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonInterconnectStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonInterconnectStub(
        InterconnectStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonInterconnectStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonInterconnectStub(InterconnectStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonInterconnectCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonInterconnectStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonInterconnectStub(
      InterconnectStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteInterconnectHttpRequest, Operation>
        deleteInterconnectTransportSettings =
            HttpJsonCallSettings.<DeleteInterconnectHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteInterconnectMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetInterconnectHttpRequest, Interconnect>
        getInterconnectTransportSettings =
            HttpJsonCallSettings.<GetInterconnectHttpRequest, Interconnect>newBuilder()
                .setMethodDescriptor(getInterconnectMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertInterconnectHttpRequest, Operation>
        insertInterconnectTransportSettings =
            HttpJsonCallSettings.<InsertInterconnectHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertInterconnectMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListInterconnectsHttpRequest, InterconnectList>
        listInterconnectsTransportSettings =
            HttpJsonCallSettings.<ListInterconnectsHttpRequest, InterconnectList>newBuilder()
                .setMethodDescriptor(listInterconnectsMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchInterconnectHttpRequest, Operation>
        patchInterconnectTransportSettings =
            HttpJsonCallSettings.<PatchInterconnectHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(patchInterconnectMethodDescriptor)
                .build();

    this.deleteInterconnectCallable =
        callableFactory.createUnaryCallable(
            deleteInterconnectTransportSettings,
            settings.deleteInterconnectSettings(),
            clientContext);
    this.getInterconnectCallable =
        callableFactory.createUnaryCallable(
            getInterconnectTransportSettings, settings.getInterconnectSettings(), clientContext);
    this.insertInterconnectCallable =
        callableFactory.createUnaryCallable(
            insertInterconnectTransportSettings,
            settings.insertInterconnectSettings(),
            clientContext);
    this.listInterconnectsCallable =
        callableFactory.createUnaryCallable(
            listInterconnectsTransportSettings,
            settings.listInterconnectsSettings(),
            clientContext);
    this.listInterconnectsPagedCallable =
        callableFactory.createPagedCallable(
            listInterconnectsTransportSettings,
            settings.listInterconnectsSettings(),
            clientContext);
    this.patchInterconnectCallable =
        callableFactory.createUnaryCallable(
            patchInterconnectTransportSettings,
            settings.patchInterconnectSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteInterconnectHttpRequest, Operation> deleteInterconnectCallable() {
    return deleteInterconnectCallable;
  }

  @BetaApi
  public UnaryCallable<GetInterconnectHttpRequest, Interconnect> getInterconnectCallable() {
    return getInterconnectCallable;
  }

  @BetaApi
  public UnaryCallable<InsertInterconnectHttpRequest, Operation> insertInterconnectCallable() {
    return insertInterconnectCallable;
  }

  @BetaApi
  public UnaryCallable<ListInterconnectsHttpRequest, ListInterconnectsPagedResponse>
      listInterconnectsPagedCallable() {
    return listInterconnectsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListInterconnectsHttpRequest, InterconnectList> listInterconnectsCallable() {
    return listInterconnectsCallable;
  }

  @BetaApi
  public UnaryCallable<PatchInterconnectHttpRequest, Operation> patchInterconnectCallable() {
    return patchInterconnectCallable;
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
