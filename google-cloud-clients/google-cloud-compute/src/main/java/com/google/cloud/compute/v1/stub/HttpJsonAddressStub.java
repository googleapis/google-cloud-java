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

import static com.google.cloud.compute.v1.AddressClient.AggregatedListAddressesPagedResponse;
import static com.google.cloud.compute.v1.AddressClient.ListAddressesPagedResponse;

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
import com.google.cloud.compute.v1.AddressAggregatedList;
import com.google.cloud.compute.v1.AddressList;
import com.google.cloud.compute.v1.AggregatedListAddressesHttpRequest;
import com.google.cloud.compute.v1.DeleteAddressHttpRequest;
import com.google.cloud.compute.v1.GetAddressHttpRequest;
import com.google.cloud.compute.v1.InsertAddressHttpRequest;
import com.google.cloud.compute.v1.ListAddressesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectRegionAddressName;
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
public class HttpJsonAddressStub extends AddressStub {
  @InternalApi
  public static final ApiMethodDescriptor<AggregatedListAddressesHttpRequest, AddressAggregatedList>
      aggregatedListAddressesMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListAddressesHttpRequest, AddressAggregatedList>newBuilder()
              .setFullMethodName("compute.addresses.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<AggregatedListAddressesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/aggregated/addresses"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<AddressAggregatedList>newBuilder()
                      .setResponseInstance(AddressAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteAddressHttpRequest, Operation>
      deleteAddressMethodDescriptor =
          ApiMethodDescriptor.<DeleteAddressHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.addresses.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteAddressHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/addresses/{address}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionAddressName.newFactory())
                      .setResourceNameField("address")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetAddressHttpRequest, Address>
      getAddressMethodDescriptor =
          ApiMethodDescriptor.<GetAddressHttpRequest, Address>newBuilder()
              .setFullMethodName("compute.addresses.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetAddressHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/addresses/{address}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionAddressName.newFactory())
                      .setResourceNameField("address")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Address>newBuilder()
                      .setResponseInstance(Address.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertAddressHttpRequest, Operation>
      insertAddressMethodDescriptor =
          ApiMethodDescriptor.<InsertAddressHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.addresses.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertAddressHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/regions/{region}/addresses"))
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
  public static final ApiMethodDescriptor<ListAddressesHttpRequest, AddressList>
      listAddressesMethodDescriptor =
          ApiMethodDescriptor.<ListAddressesHttpRequest, AddressList>newBuilder()
              .setFullMethodName("compute.addresses.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListAddressesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/regions/{region}/addresses"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<AddressList>newBuilder()
                      .setResponseInstance(AddressList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AggregatedListAddressesHttpRequest, AddressAggregatedList>
      aggregatedListAddressesCallable;
  private final UnaryCallable<
          AggregatedListAddressesHttpRequest, AggregatedListAddressesPagedResponse>
      aggregatedListAddressesPagedCallable;
  private final UnaryCallable<DeleteAddressHttpRequest, Operation> deleteAddressCallable;
  private final UnaryCallable<GetAddressHttpRequest, Address> getAddressCallable;
  private final UnaryCallable<InsertAddressHttpRequest, Operation> insertAddressCallable;
  private final UnaryCallable<ListAddressesHttpRequest, AddressList> listAddressesCallable;
  private final UnaryCallable<ListAddressesHttpRequest, ListAddressesPagedResponse>
      listAddressesPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAddressStub create(AddressStubSettings settings) throws IOException {
    return new HttpJsonAddressStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAddressStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonAddressStub(AddressStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonAddressStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAddressStub(
        AddressStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAddressStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAddressStub(AddressStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAddressCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAddressStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAddressStub(
      AddressStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListAddressesHttpRequest, AddressAggregatedList>
        aggregatedListAddressesTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListAddressesHttpRequest, AddressAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListAddressesMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteAddressHttpRequest, Operation> deleteAddressTransportSettings =
        HttpJsonCallSettings.<DeleteAddressHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAddressMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetAddressHttpRequest, Address> getAddressTransportSettings =
        HttpJsonCallSettings.<GetAddressHttpRequest, Address>newBuilder()
            .setMethodDescriptor(getAddressMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertAddressHttpRequest, Operation> insertAddressTransportSettings =
        HttpJsonCallSettings.<InsertAddressHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(insertAddressMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListAddressesHttpRequest, AddressList> listAddressesTransportSettings =
        HttpJsonCallSettings.<ListAddressesHttpRequest, AddressList>newBuilder()
            .setMethodDescriptor(listAddressesMethodDescriptor)
            .build();

    this.aggregatedListAddressesCallable =
        callableFactory.createUnaryCallable(
            aggregatedListAddressesTransportSettings,
            settings.aggregatedListAddressesSettings(),
            clientContext);
    this.aggregatedListAddressesPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListAddressesTransportSettings,
            settings.aggregatedListAddressesSettings(),
            clientContext);
    this.deleteAddressCallable =
        callableFactory.createUnaryCallable(
            deleteAddressTransportSettings, settings.deleteAddressSettings(), clientContext);
    this.getAddressCallable =
        callableFactory.createUnaryCallable(
            getAddressTransportSettings, settings.getAddressSettings(), clientContext);
    this.insertAddressCallable =
        callableFactory.createUnaryCallable(
            insertAddressTransportSettings, settings.insertAddressSettings(), clientContext);
    this.listAddressesCallable =
        callableFactory.createUnaryCallable(
            listAddressesTransportSettings, settings.listAddressesSettings(), clientContext);
    this.listAddressesPagedCallable =
        callableFactory.createPagedCallable(
            listAddressesTransportSettings, settings.listAddressesSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<AggregatedListAddressesHttpRequest, AggregatedListAddressesPagedResponse>
      aggregatedListAddressesPagedCallable() {
    return aggregatedListAddressesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListAddressesHttpRequest, AddressAggregatedList>
      aggregatedListAddressesCallable() {
    return aggregatedListAddressesCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteAddressHttpRequest, Operation> deleteAddressCallable() {
    return deleteAddressCallable;
  }

  @BetaApi
  public UnaryCallable<GetAddressHttpRequest, Address> getAddressCallable() {
    return getAddressCallable;
  }

  @BetaApi
  public UnaryCallable<InsertAddressHttpRequest, Operation> insertAddressCallable() {
    return insertAddressCallable;
  }

  @BetaApi
  public UnaryCallable<ListAddressesHttpRequest, ListAddressesPagedResponse>
      listAddressesPagedCallable() {
    return listAddressesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListAddressesHttpRequest, AddressList> listAddressesCallable() {
    return listAddressesCallable;
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
