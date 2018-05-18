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

import static com.google.cloud.compute.v1.FirewallClient.ListFirewallsPagedResponse;

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
import com.google.cloud.compute.v1.DeleteFirewallHttpRequest;
import com.google.cloud.compute.v1.Firewall;
import com.google.cloud.compute.v1.FirewallList;
import com.google.cloud.compute.v1.GetFirewallHttpRequest;
import com.google.cloud.compute.v1.InsertFirewallHttpRequest;
import com.google.cloud.compute.v1.ListFirewallsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchFirewallHttpRequest;
import com.google.cloud.compute.v1.ProjectGlobalFirewallName;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.UpdateFirewallHttpRequest;
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
public class HttpJsonFirewallStub extends FirewallStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteFirewallHttpRequest, Operation>
      deleteFirewallMethodDescriptor =
          ApiMethodDescriptor.<DeleteFirewallHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.firewalls.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteFirewallHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/firewalls/{firewall}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalFirewallName.newFactory())
                      .setResourceNameField("firewall")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetFirewallHttpRequest, Firewall>
      getFirewallMethodDescriptor =
          ApiMethodDescriptor.<GetFirewallHttpRequest, Firewall>newBuilder()
              .setFullMethodName("compute.firewalls.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetFirewallHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/firewalls/{firewall}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalFirewallName.newFactory())
                      .setResourceNameField("firewall")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Firewall>newBuilder()
                      .setResponseInstance(Firewall.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertFirewallHttpRequest, Operation>
      insertFirewallMethodDescriptor =
          ApiMethodDescriptor.<InsertFirewallHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.firewalls.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertFirewallHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/firewalls"))
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
  public static final ApiMethodDescriptor<ListFirewallsHttpRequest, FirewallList>
      listFirewallsMethodDescriptor =
          ApiMethodDescriptor.<ListFirewallsHttpRequest, FirewallList>newBuilder()
              .setFullMethodName("compute.firewalls.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListFirewallsHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/firewalls"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<FirewallList>newBuilder()
                      .setResponseInstance(FirewallList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchFirewallHttpRequest, Operation>
      patchFirewallMethodDescriptor =
          ApiMethodDescriptor.<PatchFirewallHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.firewalls.patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<PatchFirewallHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/firewalls/{firewall}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalFirewallName.newFactory())
                      .setResourceNameField("firewall")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<UpdateFirewallHttpRequest, Operation>
      updateFirewallMethodDescriptor =
          ApiMethodDescriptor.<UpdateFirewallHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.firewalls.update")
              .setHttpMethod(HttpMethods.PUT)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<UpdateFirewallHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/firewalls/{firewall}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalFirewallName.newFactory())
                      .setResourceNameField("firewall")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteFirewallHttpRequest, Operation> deleteFirewallCallable;
  private final UnaryCallable<GetFirewallHttpRequest, Firewall> getFirewallCallable;
  private final UnaryCallable<InsertFirewallHttpRequest, Operation> insertFirewallCallable;
  private final UnaryCallable<ListFirewallsHttpRequest, FirewallList> listFirewallsCallable;
  private final UnaryCallable<ListFirewallsHttpRequest, ListFirewallsPagedResponse>
      listFirewallsPagedCallable;
  private final UnaryCallable<PatchFirewallHttpRequest, Operation> patchFirewallCallable;
  private final UnaryCallable<UpdateFirewallHttpRequest, Operation> updateFirewallCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonFirewallStub create(FirewallStubSettings settings)
      throws IOException {
    return new HttpJsonFirewallStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonFirewallStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonFirewallStub(FirewallStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonFirewallStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonFirewallStub(
        FirewallStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonFirewallStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonFirewallStub(FirewallStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonFirewallCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonFirewallStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonFirewallStub(
      FirewallStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteFirewallHttpRequest, Operation> deleteFirewallTransportSettings =
        HttpJsonCallSettings.<DeleteFirewallHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteFirewallMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetFirewallHttpRequest, Firewall> getFirewallTransportSettings =
        HttpJsonCallSettings.<GetFirewallHttpRequest, Firewall>newBuilder()
            .setMethodDescriptor(getFirewallMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertFirewallHttpRequest, Operation> insertFirewallTransportSettings =
        HttpJsonCallSettings.<InsertFirewallHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(insertFirewallMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListFirewallsHttpRequest, FirewallList> listFirewallsTransportSettings =
        HttpJsonCallSettings.<ListFirewallsHttpRequest, FirewallList>newBuilder()
            .setMethodDescriptor(listFirewallsMethodDescriptor)
            .build();
    HttpJsonCallSettings<PatchFirewallHttpRequest, Operation> patchFirewallTransportSettings =
        HttpJsonCallSettings.<PatchFirewallHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(patchFirewallMethodDescriptor)
            .build();
    HttpJsonCallSettings<UpdateFirewallHttpRequest, Operation> updateFirewallTransportSettings =
        HttpJsonCallSettings.<UpdateFirewallHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(updateFirewallMethodDescriptor)
            .build();

    this.deleteFirewallCallable =
        callableFactory.createUnaryCallable(
            deleteFirewallTransportSettings, settings.deleteFirewallSettings(), clientContext);
    this.getFirewallCallable =
        callableFactory.createUnaryCallable(
            getFirewallTransportSettings, settings.getFirewallSettings(), clientContext);
    this.insertFirewallCallable =
        callableFactory.createUnaryCallable(
            insertFirewallTransportSettings, settings.insertFirewallSettings(), clientContext);
    this.listFirewallsCallable =
        callableFactory.createUnaryCallable(
            listFirewallsTransportSettings, settings.listFirewallsSettings(), clientContext);
    this.listFirewallsPagedCallable =
        callableFactory.createPagedCallable(
            listFirewallsTransportSettings, settings.listFirewallsSettings(), clientContext);
    this.patchFirewallCallable =
        callableFactory.createUnaryCallable(
            patchFirewallTransportSettings, settings.patchFirewallSettings(), clientContext);
    this.updateFirewallCallable =
        callableFactory.createUnaryCallable(
            updateFirewallTransportSettings, settings.updateFirewallSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteFirewallHttpRequest, Operation> deleteFirewallCallable() {
    return deleteFirewallCallable;
  }

  @BetaApi
  public UnaryCallable<GetFirewallHttpRequest, Firewall> getFirewallCallable() {
    return getFirewallCallable;
  }

  @BetaApi
  public UnaryCallable<InsertFirewallHttpRequest, Operation> insertFirewallCallable() {
    return insertFirewallCallable;
  }

  @BetaApi
  public UnaryCallable<ListFirewallsHttpRequest, ListFirewallsPagedResponse>
      listFirewallsPagedCallable() {
    return listFirewallsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListFirewallsHttpRequest, FirewallList> listFirewallsCallable() {
    return listFirewallsCallable;
  }

  @BetaApi
  public UnaryCallable<PatchFirewallHttpRequest, Operation> patchFirewallCallable() {
    return patchFirewallCallable;
  }

  @BetaApi
  public UnaryCallable<UpdateFirewallHttpRequest, Operation> updateFirewallCallable() {
    return updateFirewallCallable;
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
