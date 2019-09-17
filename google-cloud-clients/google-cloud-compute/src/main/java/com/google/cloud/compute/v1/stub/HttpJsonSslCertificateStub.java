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

import static com.google.cloud.compute.v1.SslCertificateClient.AggregatedListSslCertificatesPagedResponse;
import static com.google.cloud.compute.v1.SslCertificateClient.ListSslCertificatesPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListSslCertificatesHttpRequest;
import com.google.cloud.compute.v1.DeleteSslCertificateHttpRequest;
import com.google.cloud.compute.v1.GetSslCertificateHttpRequest;
import com.google.cloud.compute.v1.InsertSslCertificateHttpRequest;
import com.google.cloud.compute.v1.ListSslCertificatesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectGlobalSslCertificateName;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.SslCertificate;
import com.google.cloud.compute.v1.SslCertificateAggregatedList;
import com.google.cloud.compute.v1.SslCertificateList;
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
public class HttpJsonSslCertificateStub extends SslCertificateStub {
  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListSslCertificatesHttpRequest, SslCertificateAggregatedList>
      aggregatedListSslCertificatesMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListSslCertificatesHttpRequest, SslCertificateAggregatedList>newBuilder()
              .setFullMethodName("compute.sslCertificates.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<AggregatedListSslCertificatesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/aggregated/sslCertificates"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<SslCertificateAggregatedList>newBuilder()
                      .setResponseInstance(SslCertificateAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteSslCertificateHttpRequest, Operation>
      deleteSslCertificateMethodDescriptor =
          ApiMethodDescriptor.<DeleteSslCertificateHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.sslCertificates.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteSslCertificateHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/sslCertificates/{sslCertificate}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalSslCertificateName.newFactory())
                      .setResourceNameField("sslCertificate")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetSslCertificateHttpRequest, SslCertificate>
      getSslCertificateMethodDescriptor =
          ApiMethodDescriptor.<GetSslCertificateHttpRequest, SslCertificate>newBuilder()
              .setFullMethodName("compute.sslCertificates.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetSslCertificateHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/sslCertificates/{sslCertificate}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalSslCertificateName.newFactory())
                      .setResourceNameField("sslCertificate")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<SslCertificate>newBuilder()
                      .setResponseInstance(SslCertificate.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertSslCertificateHttpRequest, Operation>
      insertSslCertificateMethodDescriptor =
          ApiMethodDescriptor.<InsertSslCertificateHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.sslCertificates.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertSslCertificateHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/sslCertificates"))
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
  public static final ApiMethodDescriptor<ListSslCertificatesHttpRequest, SslCertificateList>
      listSslCertificatesMethodDescriptor =
          ApiMethodDescriptor.<ListSslCertificatesHttpRequest, SslCertificateList>newBuilder()
              .setFullMethodName("compute.sslCertificates.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListSslCertificatesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/sslCertificates"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<SslCertificateList>newBuilder()
                      .setResponseInstance(SslCertificateList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<
          AggregatedListSslCertificatesHttpRequest, SslCertificateAggregatedList>
      aggregatedListSslCertificatesCallable;
  private final UnaryCallable<
          AggregatedListSslCertificatesHttpRequest, AggregatedListSslCertificatesPagedResponse>
      aggregatedListSslCertificatesPagedCallable;
  private final UnaryCallable<DeleteSslCertificateHttpRequest, Operation>
      deleteSslCertificateCallable;
  private final UnaryCallable<GetSslCertificateHttpRequest, SslCertificate>
      getSslCertificateCallable;
  private final UnaryCallable<InsertSslCertificateHttpRequest, Operation>
      insertSslCertificateCallable;
  private final UnaryCallable<ListSslCertificatesHttpRequest, SslCertificateList>
      listSslCertificatesCallable;
  private final UnaryCallable<ListSslCertificatesHttpRequest, ListSslCertificatesPagedResponse>
      listSslCertificatesPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSslCertificateStub create(SslCertificateStubSettings settings)
      throws IOException {
    return new HttpJsonSslCertificateStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSslCertificateStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSslCertificateStub(
        SslCertificateStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonSslCertificateStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSslCertificateStub(
        SslCertificateStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSslCertificateStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSslCertificateStub(
      SslCertificateStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSslCertificateCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSslCertificateStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSslCertificateStub(
      SslCertificateStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListSslCertificatesHttpRequest, SslCertificateAggregatedList>
        aggregatedListSslCertificatesTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListSslCertificatesHttpRequest, SslCertificateAggregatedList>
                    newBuilder()
                .setMethodDescriptor(aggregatedListSslCertificatesMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteSslCertificateHttpRequest, Operation>
        deleteSslCertificateTransportSettings =
            HttpJsonCallSettings.<DeleteSslCertificateHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteSslCertificateMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetSslCertificateHttpRequest, SslCertificate>
        getSslCertificateTransportSettings =
            HttpJsonCallSettings.<GetSslCertificateHttpRequest, SslCertificate>newBuilder()
                .setMethodDescriptor(getSslCertificateMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertSslCertificateHttpRequest, Operation>
        insertSslCertificateTransportSettings =
            HttpJsonCallSettings.<InsertSslCertificateHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertSslCertificateMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListSslCertificatesHttpRequest, SslCertificateList>
        listSslCertificatesTransportSettings =
            HttpJsonCallSettings.<ListSslCertificatesHttpRequest, SslCertificateList>newBuilder()
                .setMethodDescriptor(listSslCertificatesMethodDescriptor)
                .build();

    this.aggregatedListSslCertificatesCallable =
        callableFactory.createUnaryCallable(
            aggregatedListSslCertificatesTransportSettings,
            settings.aggregatedListSslCertificatesSettings(),
            clientContext);
    this.aggregatedListSslCertificatesPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListSslCertificatesTransportSettings,
            settings.aggregatedListSslCertificatesSettings(),
            clientContext);
    this.deleteSslCertificateCallable =
        callableFactory.createUnaryCallable(
            deleteSslCertificateTransportSettings,
            settings.deleteSslCertificateSettings(),
            clientContext);
    this.getSslCertificateCallable =
        callableFactory.createUnaryCallable(
            getSslCertificateTransportSettings,
            settings.getSslCertificateSettings(),
            clientContext);
    this.insertSslCertificateCallable =
        callableFactory.createUnaryCallable(
            insertSslCertificateTransportSettings,
            settings.insertSslCertificateSettings(),
            clientContext);
    this.listSslCertificatesCallable =
        callableFactory.createUnaryCallable(
            listSslCertificatesTransportSettings,
            settings.listSslCertificatesSettings(),
            clientContext);
    this.listSslCertificatesPagedCallable =
        callableFactory.createPagedCallable(
            listSslCertificatesTransportSettings,
            settings.listSslCertificatesSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<
          AggregatedListSslCertificatesHttpRequest, AggregatedListSslCertificatesPagedResponse>
      aggregatedListSslCertificatesPagedCallable() {
    return aggregatedListSslCertificatesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListSslCertificatesHttpRequest, SslCertificateAggregatedList>
      aggregatedListSslCertificatesCallable() {
    return aggregatedListSslCertificatesCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteSslCertificateHttpRequest, Operation> deleteSslCertificateCallable() {
    return deleteSslCertificateCallable;
  }

  @BetaApi
  public UnaryCallable<GetSslCertificateHttpRequest, SslCertificate> getSslCertificateCallable() {
    return getSslCertificateCallable;
  }

  @BetaApi
  public UnaryCallable<InsertSslCertificateHttpRequest, Operation> insertSslCertificateCallable() {
    return insertSslCertificateCallable;
  }

  @BetaApi
  public UnaryCallable<ListSslCertificatesHttpRequest, ListSslCertificatesPagedResponse>
      listSslCertificatesPagedCallable() {
    return listSslCertificatesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListSslCertificatesHttpRequest, SslCertificateList>
      listSslCertificatesCallable() {
    return listSslCertificatesCallable;
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
