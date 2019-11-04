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

import static com.google.cloud.compute.v1.GlobalAddressClient.ListGlobalAddressesPagedResponse;

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
import com.google.cloud.compute.v1.Address;
import com.google.cloud.compute.v1.AddressList;
import com.google.cloud.compute.v1.DeleteGlobalAddressHttpRequest;
import com.google.cloud.compute.v1.GetGlobalAddressHttpRequest;
import com.google.cloud.compute.v1.InsertGlobalAddressHttpRequest;
import com.google.cloud.compute.v1.ListGlobalAddressesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectGlobalAddressName;
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
public class HttpJsonGlobalAddressStub extends GlobalAddressStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteGlobalAddressHttpRequest, Operation>
      deleteGlobalAddressMethodDescriptor =
          ApiMethodDescriptor.<DeleteGlobalAddressHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.globalAddresses.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteGlobalAddressHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/addresses/{address}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalAddressName.newFactory())
                      .setResourceNameField("address")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetGlobalAddressHttpRequest, Address>
      getGlobalAddressMethodDescriptor =
          ApiMethodDescriptor.<GetGlobalAddressHttpRequest, Address>newBuilder()
              .setFullMethodName("compute.globalAddresses.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetGlobalAddressHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/addresses/{address}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalAddressName.newFactory())
                      .setResourceNameField("address")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Address>newBuilder()
                      .setResponseInstance(Address.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertGlobalAddressHttpRequest, Operation>
      insertGlobalAddressMethodDescriptor =
          ApiMethodDescriptor.<InsertGlobalAddressHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.globalAddresses.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertGlobalAddressHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/addresses"))
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
  public static final ApiMethodDescriptor<ListGlobalAddressesHttpRequest, AddressList>
      listGlobalAddressesMethodDescriptor =
          ApiMethodDescriptor.<ListGlobalAddressesHttpRequest, AddressList>newBuilder()
              .setFullMethodName("compute.globalAddresses.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListGlobalAddressesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/addresses"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<AddressList>newBuilder()
                      .setResponseInstance(AddressList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteGlobalAddressHttpRequest, Operation>
      deleteGlobalAddressCallable;
  private final UnaryCallable<GetGlobalAddressHttpRequest, Address> getGlobalAddressCallable;
  private final UnaryCallable<InsertGlobalAddressHttpRequest, Operation>
      insertGlobalAddressCallable;
  private final UnaryCallable<ListGlobalAddressesHttpRequest, AddressList>
      listGlobalAddressesCallable;
  private final UnaryCallable<ListGlobalAddressesHttpRequest, ListGlobalAddressesPagedResponse>
      listGlobalAddressesPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGlobalAddressStub create(GlobalAddressStubSettings settings)
      throws IOException {
    return new HttpJsonGlobalAddressStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGlobalAddressStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGlobalAddressStub(
        GlobalAddressStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonGlobalAddressStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGlobalAddressStub(
        GlobalAddressStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGlobalAddressStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGlobalAddressStub(
      GlobalAddressStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonGlobalAddressCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGlobalAddressStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGlobalAddressStub(
      GlobalAddressStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteGlobalAddressHttpRequest, Operation>
        deleteGlobalAddressTransportSettings =
            HttpJsonCallSettings.<DeleteGlobalAddressHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteGlobalAddressMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetGlobalAddressHttpRequest, Address> getGlobalAddressTransportSettings =
        HttpJsonCallSettings.<GetGlobalAddressHttpRequest, Address>newBuilder()
            .setMethodDescriptor(getGlobalAddressMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertGlobalAddressHttpRequest, Operation>
        insertGlobalAddressTransportSettings =
            HttpJsonCallSettings.<InsertGlobalAddressHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertGlobalAddressMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListGlobalAddressesHttpRequest, AddressList>
        listGlobalAddressesTransportSettings =
            HttpJsonCallSettings.<ListGlobalAddressesHttpRequest, AddressList>newBuilder()
                .setMethodDescriptor(listGlobalAddressesMethodDescriptor)
                .build();

    this.deleteGlobalAddressCallable =
        callableFactory.createUnaryCallable(
            deleteGlobalAddressTransportSettings,
            settings.deleteGlobalAddressSettings(),
            clientContext);
    this.getGlobalAddressCallable =
        callableFactory.createUnaryCallable(
            getGlobalAddressTransportSettings, settings.getGlobalAddressSettings(), clientContext);
    this.insertGlobalAddressCallable =
        callableFactory.createUnaryCallable(
            insertGlobalAddressTransportSettings,
            settings.insertGlobalAddressSettings(),
            clientContext);
    this.listGlobalAddressesCallable =
        callableFactory.createUnaryCallable(
            listGlobalAddressesTransportSettings,
            settings.listGlobalAddressesSettings(),
            clientContext);
    this.listGlobalAddressesPagedCallable =
        callableFactory.createPagedCallable(
            listGlobalAddressesTransportSettings,
            settings.listGlobalAddressesSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteGlobalAddressHttpRequest, Operation> deleteGlobalAddressCallable() {
    return deleteGlobalAddressCallable;
  }

  @BetaApi
  public UnaryCallable<GetGlobalAddressHttpRequest, Address> getGlobalAddressCallable() {
    return getGlobalAddressCallable;
  }

  @BetaApi
  public UnaryCallable<InsertGlobalAddressHttpRequest, Operation> insertGlobalAddressCallable() {
    return insertGlobalAddressCallable;
  }

  @BetaApi
  public UnaryCallable<ListGlobalAddressesHttpRequest, ListGlobalAddressesPagedResponse>
      listGlobalAddressesPagedCallable() {
    return listGlobalAddressesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListGlobalAddressesHttpRequest, AddressList> listGlobalAddressesCallable() {
    return listGlobalAddressesCallable;
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
