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
import com.google.cloud.compute.v1.GetLicenseCodeHttpRequest;
import com.google.cloud.compute.v1.LicenseCode;
import com.google.cloud.compute.v1.ProjectGlobalLicenseCodeName;
import com.google.cloud.compute.v1.ProjectGlobalLicenseCodeResourceName;
import com.google.cloud.compute.v1.TestIamPermissionsLicenseCodeHttpRequest;
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
public class HttpJsonLicenseCodeStub extends LicenseCodeStub {
  @InternalApi
  public static final ApiMethodDescriptor<GetLicenseCodeHttpRequest, LicenseCode>
      getLicenseCodeMethodDescriptor =
          ApiMethodDescriptor.<GetLicenseCodeHttpRequest, LicenseCode>newBuilder()
              .setFullMethodName("compute.licenseCodes.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetLicenseCodeHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/licenseCodes/{licenseCode}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalLicenseCodeName.newFactory())
                      .setResourceNameField("licenseCode")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<LicenseCode>newBuilder()
                      .setResponseInstance(LicenseCode.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          TestIamPermissionsLicenseCodeHttpRequest, TestPermissionsResponse>
      testIamPermissionsLicenseCodeMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsLicenseCodeHttpRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("compute.licenseCodes.testIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<TestIamPermissionsLicenseCodeHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/licenseCodes/{resource}/testIamPermissions"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalLicenseCodeResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TestPermissionsResponse>newBuilder()
                      .setResponseInstance(TestPermissionsResponse.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<GetLicenseCodeHttpRequest, LicenseCode> getLicenseCodeCallable;
  private final UnaryCallable<TestIamPermissionsLicenseCodeHttpRequest, TestPermissionsResponse>
      testIamPermissionsLicenseCodeCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonLicenseCodeStub create(LicenseCodeStubSettings settings)
      throws IOException {
    return new HttpJsonLicenseCodeStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonLicenseCodeStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonLicenseCodeStub(LicenseCodeStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonLicenseCodeStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonLicenseCodeStub(
        LicenseCodeStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonLicenseCodeStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonLicenseCodeStub(LicenseCodeStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonLicenseCodeCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonLicenseCodeStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonLicenseCodeStub(
      LicenseCodeStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetLicenseCodeHttpRequest, LicenseCode> getLicenseCodeTransportSettings =
        HttpJsonCallSettings.<GetLicenseCodeHttpRequest, LicenseCode>newBuilder()
            .setMethodDescriptor(getLicenseCodeMethodDescriptor)
            .build();
    HttpJsonCallSettings<TestIamPermissionsLicenseCodeHttpRequest, TestPermissionsResponse>
        testIamPermissionsLicenseCodeTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsLicenseCodeHttpRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsLicenseCodeMethodDescriptor)
                .build();

    this.getLicenseCodeCallable =
        callableFactory.createUnaryCallable(
            getLicenseCodeTransportSettings, settings.getLicenseCodeSettings(), clientContext);
    this.testIamPermissionsLicenseCodeCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsLicenseCodeTransportSettings,
            settings.testIamPermissionsLicenseCodeSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<GetLicenseCodeHttpRequest, LicenseCode> getLicenseCodeCallable() {
    return getLicenseCodeCallable;
  }

  @BetaApi
  public UnaryCallable<TestIamPermissionsLicenseCodeHttpRequest, TestPermissionsResponse>
      testIamPermissionsLicenseCodeCallable() {
    return testIamPermissionsLicenseCodeCallable;
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
