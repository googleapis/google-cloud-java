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

import static com.google.cloud.compute.v1.RegionSslCertificateClient.ListRegionSslCertificatesPagedResponse;

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
import com.google.cloud.compute.v1.DeleteRegionSslCertificateHttpRequest;
import com.google.cloud.compute.v1.GetRegionSslCertificateHttpRequest;
import com.google.cloud.compute.v1.InsertRegionSslCertificateHttpRequest;
import com.google.cloud.compute.v1.ListRegionSslCertificatesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.ProjectRegionSslCertificateName;
import com.google.cloud.compute.v1.SslCertificate;
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
public class HttpJsonRegionSslCertificateStub extends RegionSslCertificateStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteRegionSslCertificateHttpRequest, Operation>
      deleteRegionSslCertificateMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionSslCertificateHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionSslCertificates.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteRegionSslCertificateHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/sslCertificates/{sslCertificate}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionSslCertificateName.newFactory())
                      .setResourceNameField("sslCertificate")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetRegionSslCertificateHttpRequest, SslCertificate>
      getRegionSslCertificateMethodDescriptor =
          ApiMethodDescriptor.<GetRegionSslCertificateHttpRequest, SslCertificate>newBuilder()
              .setFullMethodName("compute.regionSslCertificates.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetRegionSslCertificateHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/sslCertificates/{sslCertificate}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionSslCertificateName.newFactory())
                      .setResourceNameField("sslCertificate")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<SslCertificate>newBuilder()
                      .setResponseInstance(SslCertificate.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertRegionSslCertificateHttpRequest, Operation>
      insertRegionSslCertificateMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionSslCertificateHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionSslCertificates.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertRegionSslCertificateHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/sslCertificates"))
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
  public static final ApiMethodDescriptor<ListRegionSslCertificatesHttpRequest, SslCertificateList>
      listRegionSslCertificatesMethodDescriptor =
          ApiMethodDescriptor.<ListRegionSslCertificatesHttpRequest, SslCertificateList>newBuilder()
              .setFullMethodName("compute.regionSslCertificates.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListRegionSslCertificatesHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/sslCertificates"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<SslCertificateList>newBuilder()
                      .setResponseInstance(SslCertificateList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteRegionSslCertificateHttpRequest, Operation>
      deleteRegionSslCertificateCallable;
  private final UnaryCallable<GetRegionSslCertificateHttpRequest, SslCertificate>
      getRegionSslCertificateCallable;
  private final UnaryCallable<InsertRegionSslCertificateHttpRequest, Operation>
      insertRegionSslCertificateCallable;
  private final UnaryCallable<ListRegionSslCertificatesHttpRequest, SslCertificateList>
      listRegionSslCertificatesCallable;
  private final UnaryCallable<
          ListRegionSslCertificatesHttpRequest, ListRegionSslCertificatesPagedResponse>
      listRegionSslCertificatesPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionSslCertificateStub create(
      RegionSslCertificateStubSettings settings) throws IOException {
    return new HttpJsonRegionSslCertificateStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionSslCertificateStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionSslCertificateStub(
        RegionSslCertificateStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionSslCertificateStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionSslCertificateStub(
        RegionSslCertificateStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionSslCertificateStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionSslCertificateStub(
      RegionSslCertificateStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRegionSslCertificateCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionSslCertificateStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionSslCertificateStub(
      RegionSslCertificateStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteRegionSslCertificateHttpRequest, Operation>
        deleteRegionSslCertificateTransportSettings =
            HttpJsonCallSettings.<DeleteRegionSslCertificateHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteRegionSslCertificateMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetRegionSslCertificateHttpRequest, SslCertificate>
        getRegionSslCertificateTransportSettings =
            HttpJsonCallSettings.<GetRegionSslCertificateHttpRequest, SslCertificate>newBuilder()
                .setMethodDescriptor(getRegionSslCertificateMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertRegionSslCertificateHttpRequest, Operation>
        insertRegionSslCertificateTransportSettings =
            HttpJsonCallSettings.<InsertRegionSslCertificateHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertRegionSslCertificateMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListRegionSslCertificatesHttpRequest, SslCertificateList>
        listRegionSslCertificatesTransportSettings =
            HttpJsonCallSettings
                .<ListRegionSslCertificatesHttpRequest, SslCertificateList>newBuilder()
                .setMethodDescriptor(listRegionSslCertificatesMethodDescriptor)
                .build();

    this.deleteRegionSslCertificateCallable =
        callableFactory.createUnaryCallable(
            deleteRegionSslCertificateTransportSettings,
            settings.deleteRegionSslCertificateSettings(),
            clientContext);
    this.getRegionSslCertificateCallable =
        callableFactory.createUnaryCallable(
            getRegionSslCertificateTransportSettings,
            settings.getRegionSslCertificateSettings(),
            clientContext);
    this.insertRegionSslCertificateCallable =
        callableFactory.createUnaryCallable(
            insertRegionSslCertificateTransportSettings,
            settings.insertRegionSslCertificateSettings(),
            clientContext);
    this.listRegionSslCertificatesCallable =
        callableFactory.createUnaryCallable(
            listRegionSslCertificatesTransportSettings,
            settings.listRegionSslCertificatesSettings(),
            clientContext);
    this.listRegionSslCertificatesPagedCallable =
        callableFactory.createPagedCallable(
            listRegionSslCertificatesTransportSettings,
            settings.listRegionSslCertificatesSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteRegionSslCertificateHttpRequest, Operation>
      deleteRegionSslCertificateCallable() {
    return deleteRegionSslCertificateCallable;
  }

  @BetaApi
  public UnaryCallable<GetRegionSslCertificateHttpRequest, SslCertificate>
      getRegionSslCertificateCallable() {
    return getRegionSslCertificateCallable;
  }

  @BetaApi
  public UnaryCallable<InsertRegionSslCertificateHttpRequest, Operation>
      insertRegionSslCertificateCallable() {
    return insertRegionSslCertificateCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionSslCertificatesHttpRequest, ListRegionSslCertificatesPagedResponse>
      listRegionSslCertificatesPagedCallable() {
    return listRegionSslCertificatesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionSslCertificatesHttpRequest, SslCertificateList>
      listRegionSslCertificatesCallable() {
    return listRegionSslCertificatesCallable;
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
