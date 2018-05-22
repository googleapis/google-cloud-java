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

import static com.google.cloud.compute.v1.LicenseClient.ListLicensesPagedResponse;

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
import com.google.cloud.compute.v1.DeleteLicenseHttpRequest;
import com.google.cloud.compute.v1.GetLicenseHttpRequest;
import com.google.cloud.compute.v1.InsertLicenseHttpRequest;
import com.google.cloud.compute.v1.License;
import com.google.cloud.compute.v1.LicensesListResponse;
import com.google.cloud.compute.v1.ListLicensesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectGlobalLicenseName;
import com.google.cloud.compute.v1.ProjectGlobalLicenseResourceName;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.TestIamPermissionsLicenseHttpRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
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
public class HttpJsonLicenseStub extends LicenseStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteLicenseHttpRequest, Operation>
      deleteLicenseMethodDescriptor =
          ApiMethodDescriptor.<DeleteLicenseHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.licenses.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteLicenseHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/licenses/{license}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalLicenseName.newFactory())
                      .setResourceNameField("license")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetLicenseHttpRequest, License>
      getLicenseMethodDescriptor =
          ApiMethodDescriptor.<GetLicenseHttpRequest, License>newBuilder()
              .setFullMethodName("compute.licenses.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetLicenseHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/licenses/{license}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalLicenseName.newFactory())
                      .setResourceNameField("license")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<License>newBuilder()
                      .setResponseInstance(License.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertLicenseHttpRequest, Operation>
      insertLicenseMethodDescriptor =
          ApiMethodDescriptor.<InsertLicenseHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.licenses.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertLicenseHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/licenses"))
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
  public static final ApiMethodDescriptor<ListLicensesHttpRequest, LicensesListResponse>
      listLicensesMethodDescriptor =
          ApiMethodDescriptor.<ListLicensesHttpRequest, LicensesListResponse>newBuilder()
              .setFullMethodName("compute.licenses.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListLicensesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/licenses"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<LicensesListResponse>newBuilder()
                      .setResponseInstance(LicensesListResponse.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          TestIamPermissionsLicenseHttpRequest, TestPermissionsResponse>
      testIamPermissionsLicenseMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsLicenseHttpRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("compute.licenses.testIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<TestIamPermissionsLicenseHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/licenses/{resource}/testIamPermissions"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalLicenseResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TestPermissionsResponse>newBuilder()
                      .setResponseInstance(TestPermissionsResponse.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteLicenseHttpRequest, Operation> deleteLicenseCallable;
  private final UnaryCallable<GetLicenseHttpRequest, License> getLicenseCallable;
  private final UnaryCallable<InsertLicenseHttpRequest, Operation> insertLicenseCallable;
  private final UnaryCallable<ListLicensesHttpRequest, LicensesListResponse> listLicensesCallable;
  private final UnaryCallable<ListLicensesHttpRequest, ListLicensesPagedResponse>
      listLicensesPagedCallable;
  private final UnaryCallable<TestIamPermissionsLicenseHttpRequest, TestPermissionsResponse>
      testIamPermissionsLicenseCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonLicenseStub create(LicenseStubSettings settings) throws IOException {
    return new HttpJsonLicenseStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonLicenseStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonLicenseStub(LicenseStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonLicenseStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonLicenseStub(
        LicenseStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonLicenseStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonLicenseStub(LicenseStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonLicenseCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonLicenseStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonLicenseStub(
      LicenseStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteLicenseHttpRequest, Operation> deleteLicenseTransportSettings =
        HttpJsonCallSettings.<DeleteLicenseHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteLicenseMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetLicenseHttpRequest, License> getLicenseTransportSettings =
        HttpJsonCallSettings.<GetLicenseHttpRequest, License>newBuilder()
            .setMethodDescriptor(getLicenseMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertLicenseHttpRequest, Operation> insertLicenseTransportSettings =
        HttpJsonCallSettings.<InsertLicenseHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(insertLicenseMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListLicensesHttpRequest, LicensesListResponse>
        listLicensesTransportSettings =
            HttpJsonCallSettings.<ListLicensesHttpRequest, LicensesListResponse>newBuilder()
                .setMethodDescriptor(listLicensesMethodDescriptor)
                .build();
    HttpJsonCallSettings<TestIamPermissionsLicenseHttpRequest, TestPermissionsResponse>
        testIamPermissionsLicenseTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsLicenseHttpRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsLicenseMethodDescriptor)
                .build();

    this.deleteLicenseCallable =
        callableFactory.createUnaryCallable(
            deleteLicenseTransportSettings, settings.deleteLicenseSettings(), clientContext);
    this.getLicenseCallable =
        callableFactory.createUnaryCallable(
            getLicenseTransportSettings, settings.getLicenseSettings(), clientContext);
    this.insertLicenseCallable =
        callableFactory.createUnaryCallable(
            insertLicenseTransportSettings, settings.insertLicenseSettings(), clientContext);
    this.listLicensesCallable =
        callableFactory.createUnaryCallable(
            listLicensesTransportSettings, settings.listLicensesSettings(), clientContext);
    this.listLicensesPagedCallable =
        callableFactory.createPagedCallable(
            listLicensesTransportSettings, settings.listLicensesSettings(), clientContext);
    this.testIamPermissionsLicenseCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsLicenseTransportSettings,
            settings.testIamPermissionsLicenseSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteLicenseHttpRequest, Operation> deleteLicenseCallable() {
    return deleteLicenseCallable;
  }

  @BetaApi
  public UnaryCallable<GetLicenseHttpRequest, License> getLicenseCallable() {
    return getLicenseCallable;
  }

  @BetaApi
  public UnaryCallable<InsertLicenseHttpRequest, Operation> insertLicenseCallable() {
    return insertLicenseCallable;
  }

  @BetaApi
  public UnaryCallable<ListLicensesHttpRequest, ListLicensesPagedResponse>
      listLicensesPagedCallable() {
    return listLicensesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListLicensesHttpRequest, LicensesListResponse> listLicensesCallable() {
    return listLicensesCallable;
  }

  @BetaApi
  public UnaryCallable<TestIamPermissionsLicenseHttpRequest, TestPermissionsResponse>
      testIamPermissionsLicenseCallable() {
    return testIamPermissionsLicenseCallable;
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
