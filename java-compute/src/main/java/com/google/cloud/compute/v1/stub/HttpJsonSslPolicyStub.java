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

import static com.google.cloud.compute.v1.SslPolicyClient.ListSslPoliciesPagedResponse;

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
import com.google.cloud.compute.v1.DeleteSslPolicyHttpRequest;
import com.google.cloud.compute.v1.GetSslPolicyHttpRequest;
import com.google.cloud.compute.v1.InsertSslPolicyHttpRequest;
import com.google.cloud.compute.v1.ListAvailableFeaturesSslPoliciesHttpRequest;
import com.google.cloud.compute.v1.ListSslPoliciesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchSslPolicyHttpRequest;
import com.google.cloud.compute.v1.ProjectGlobalSslPolicyName;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.SslPoliciesList;
import com.google.cloud.compute.v1.SslPoliciesListAvailableFeaturesResponse;
import com.google.cloud.compute.v1.SslPolicy;
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
public class HttpJsonSslPolicyStub extends SslPolicyStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteSslPolicyHttpRequest, Operation>
      deleteSslPolicyMethodDescriptor =
          ApiMethodDescriptor.<DeleteSslPolicyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.sslPolicies.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteSslPolicyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/sslPolicies/{sslPolicy}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalSslPolicyName.newFactory())
                      .setResourceNameField("sslPolicy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetSslPolicyHttpRequest, SslPolicy>
      getSslPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetSslPolicyHttpRequest, SslPolicy>newBuilder()
              .setFullMethodName("compute.sslPolicies.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetSslPolicyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/sslPolicies/{sslPolicy}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalSslPolicyName.newFactory())
                      .setResourceNameField("sslPolicy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<SslPolicy>newBuilder()
                      .setResponseInstance(SslPolicy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertSslPolicyHttpRequest, Operation>
      insertSslPolicyMethodDescriptor =
          ApiMethodDescriptor.<InsertSslPolicyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.sslPolicies.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertSslPolicyHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/sslPolicies"))
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
  public static final ApiMethodDescriptor<ListSslPoliciesHttpRequest, SslPoliciesList>
      listSslPoliciesMethodDescriptor =
          ApiMethodDescriptor.<ListSslPoliciesHttpRequest, SslPoliciesList>newBuilder()
              .setFullMethodName("compute.sslPolicies.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListSslPoliciesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/sslPolicies"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<SslPoliciesList>newBuilder()
                      .setResponseInstance(SslPoliciesList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          ListAvailableFeaturesSslPoliciesHttpRequest, SslPoliciesListAvailableFeaturesResponse>
      listAvailableFeaturesSslPoliciesMethodDescriptor =
          ApiMethodDescriptor
              .<ListAvailableFeaturesSslPoliciesHttpRequest,
                  SslPoliciesListAvailableFeaturesResponse>
                  newBuilder()
              .setFullMethodName("compute.sslPolicies.listAvailableFeatures")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<ListAvailableFeaturesSslPoliciesHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/sslPolicies/listAvailableFeatures"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser
                      .<SslPoliciesListAvailableFeaturesResponse>newBuilder()
                      .setResponseInstance(
                          SslPoliciesListAvailableFeaturesResponse.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchSslPolicyHttpRequest, Operation>
      patchSslPolicyMethodDescriptor =
          ApiMethodDescriptor.<PatchSslPolicyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.sslPolicies.patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<PatchSslPolicyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/sslPolicies/{sslPolicy}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalSslPolicyName.newFactory())
                      .setResourceNameField("sslPolicy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteSslPolicyHttpRequest, Operation> deleteSslPolicyCallable;
  private final UnaryCallable<GetSslPolicyHttpRequest, SslPolicy> getSslPolicyCallable;
  private final UnaryCallable<InsertSslPolicyHttpRequest, Operation> insertSslPolicyCallable;
  private final UnaryCallable<ListSslPoliciesHttpRequest, SslPoliciesList> listSslPoliciesCallable;
  private final UnaryCallable<ListSslPoliciesHttpRequest, ListSslPoliciesPagedResponse>
      listSslPoliciesPagedCallable;
  private final UnaryCallable<
          ListAvailableFeaturesSslPoliciesHttpRequest, SslPoliciesListAvailableFeaturesResponse>
      listAvailableFeaturesSslPoliciesCallable;
  private final UnaryCallable<PatchSslPolicyHttpRequest, Operation> patchSslPolicyCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSslPolicyStub create(SslPolicyStubSettings settings)
      throws IOException {
    return new HttpJsonSslPolicyStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSslPolicyStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonSslPolicyStub(SslPolicyStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonSslPolicyStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSslPolicyStub(
        SslPolicyStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSslPolicyStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSslPolicyStub(SslPolicyStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonSslPolicyCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSslPolicyStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSslPolicyStub(
      SslPolicyStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteSslPolicyHttpRequest, Operation> deleteSslPolicyTransportSettings =
        HttpJsonCallSettings.<DeleteSslPolicyHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSslPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetSslPolicyHttpRequest, SslPolicy> getSslPolicyTransportSettings =
        HttpJsonCallSettings.<GetSslPolicyHttpRequest, SslPolicy>newBuilder()
            .setMethodDescriptor(getSslPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertSslPolicyHttpRequest, Operation> insertSslPolicyTransportSettings =
        HttpJsonCallSettings.<InsertSslPolicyHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(insertSslPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListSslPoliciesHttpRequest, SslPoliciesList>
        listSslPoliciesTransportSettings =
            HttpJsonCallSettings.<ListSslPoliciesHttpRequest, SslPoliciesList>newBuilder()
                .setMethodDescriptor(listSslPoliciesMethodDescriptor)
                .build();
    HttpJsonCallSettings<
            ListAvailableFeaturesSslPoliciesHttpRequest, SslPoliciesListAvailableFeaturesResponse>
        listAvailableFeaturesSslPoliciesTransportSettings =
            HttpJsonCallSettings
                .<ListAvailableFeaturesSslPoliciesHttpRequest,
                    SslPoliciesListAvailableFeaturesResponse>
                    newBuilder()
                .setMethodDescriptor(listAvailableFeaturesSslPoliciesMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchSslPolicyHttpRequest, Operation> patchSslPolicyTransportSettings =
        HttpJsonCallSettings.<PatchSslPolicyHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(patchSslPolicyMethodDescriptor)
            .build();

    this.deleteSslPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteSslPolicyTransportSettings, settings.deleteSslPolicySettings(), clientContext);
    this.getSslPolicyCallable =
        callableFactory.createUnaryCallable(
            getSslPolicyTransportSettings, settings.getSslPolicySettings(), clientContext);
    this.insertSslPolicyCallable =
        callableFactory.createUnaryCallable(
            insertSslPolicyTransportSettings, settings.insertSslPolicySettings(), clientContext);
    this.listSslPoliciesCallable =
        callableFactory.createUnaryCallable(
            listSslPoliciesTransportSettings, settings.listSslPoliciesSettings(), clientContext);
    this.listSslPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listSslPoliciesTransportSettings, settings.listSslPoliciesSettings(), clientContext);
    this.listAvailableFeaturesSslPoliciesCallable =
        callableFactory.createUnaryCallable(
            listAvailableFeaturesSslPoliciesTransportSettings,
            settings.listAvailableFeaturesSslPoliciesSettings(),
            clientContext);
    this.patchSslPolicyCallable =
        callableFactory.createUnaryCallable(
            patchSslPolicyTransportSettings, settings.patchSslPolicySettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteSslPolicyHttpRequest, Operation> deleteSslPolicyCallable() {
    return deleteSslPolicyCallable;
  }

  @BetaApi
  public UnaryCallable<GetSslPolicyHttpRequest, SslPolicy> getSslPolicyCallable() {
    return getSslPolicyCallable;
  }

  @BetaApi
  public UnaryCallable<InsertSslPolicyHttpRequest, Operation> insertSslPolicyCallable() {
    return insertSslPolicyCallable;
  }

  @BetaApi
  public UnaryCallable<ListSslPoliciesHttpRequest, ListSslPoliciesPagedResponse>
      listSslPoliciesPagedCallable() {
    return listSslPoliciesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListSslPoliciesHttpRequest, SslPoliciesList> listSslPoliciesCallable() {
    return listSslPoliciesCallable;
  }

  @BetaApi
  public UnaryCallable<
          ListAvailableFeaturesSslPoliciesHttpRequest, SslPoliciesListAvailableFeaturesResponse>
      listAvailableFeaturesSslPoliciesCallable() {
    return listAvailableFeaturesSslPoliciesCallable;
  }

  @BetaApi
  public UnaryCallable<PatchSslPolicyHttpRequest, Operation> patchSslPolicyCallable() {
    return patchSslPolicyCallable;
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
