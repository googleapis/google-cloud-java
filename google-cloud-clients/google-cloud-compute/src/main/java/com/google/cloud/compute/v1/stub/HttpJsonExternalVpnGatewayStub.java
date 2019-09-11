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

import static com.google.cloud.compute.v1.ExternalVpnGatewayClient.ListExternalVpnGatewaysPagedResponse;

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
import com.google.cloud.compute.v1.DeleteExternalVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.ExternalVpnGateway;
import com.google.cloud.compute.v1.ExternalVpnGatewayList;
import com.google.cloud.compute.v1.GetExternalVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.InsertExternalVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.ListExternalVpnGatewaysHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectGlobalExternalVpnGatewayName;
import com.google.cloud.compute.v1.ProjectGlobalExternalVpnGatewayResourceName;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.SetLabelsExternalVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsExternalVpnGatewayHttpRequest;
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
public class HttpJsonExternalVpnGatewayStub extends ExternalVpnGatewayStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteExternalVpnGatewayHttpRequest, Operation>
      deleteExternalVpnGatewayMethodDescriptor =
          ApiMethodDescriptor.<DeleteExternalVpnGatewayHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.externalVpnGateways.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteExternalVpnGatewayHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/externalVpnGateways/{externalVpnGateway}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalExternalVpnGatewayName.newFactory())
                      .setResourceNameField("externalVpnGateway")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetExternalVpnGatewayHttpRequest, ExternalVpnGateway>
      getExternalVpnGatewayMethodDescriptor =
          ApiMethodDescriptor.<GetExternalVpnGatewayHttpRequest, ExternalVpnGateway>newBuilder()
              .setFullMethodName("compute.externalVpnGateways.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetExternalVpnGatewayHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/externalVpnGateways/{externalVpnGateway}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalExternalVpnGatewayName.newFactory())
                      .setResourceNameField("externalVpnGateway")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<ExternalVpnGateway>newBuilder()
                      .setResponseInstance(ExternalVpnGateway.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertExternalVpnGatewayHttpRequest, Operation>
      insertExternalVpnGatewayMethodDescriptor =
          ApiMethodDescriptor.<InsertExternalVpnGatewayHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.externalVpnGateways.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertExternalVpnGatewayHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/externalVpnGateways"))
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
  public static final ApiMethodDescriptor<
          ListExternalVpnGatewaysHttpRequest, ExternalVpnGatewayList>
      listExternalVpnGatewaysMethodDescriptor =
          ApiMethodDescriptor
              .<ListExternalVpnGatewaysHttpRequest, ExternalVpnGatewayList>newBuilder()
              .setFullMethodName("compute.externalVpnGateways.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListExternalVpnGatewaysHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/externalVpnGateways"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<ExternalVpnGatewayList>newBuilder()
                      .setResponseInstance(ExternalVpnGatewayList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetLabelsExternalVpnGatewayHttpRequest, Operation>
      setLabelsExternalVpnGatewayMethodDescriptor =
          ApiMethodDescriptor.<SetLabelsExternalVpnGatewayHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.externalVpnGateways.setLabels")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<SetLabelsExternalVpnGatewayHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/externalVpnGateways/{resource}/setLabels"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(
                          ProjectGlobalExternalVpnGatewayResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          TestIamPermissionsExternalVpnGatewayHttpRequest, TestPermissionsResponse>
      testIamPermissionsExternalVpnGatewayMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsExternalVpnGatewayHttpRequest, TestPermissionsResponse>
                  newBuilder()
              .setFullMethodName("compute.externalVpnGateways.testIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<TestIamPermissionsExternalVpnGatewayHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/externalVpnGateways/{resource}/testIamPermissions"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(
                          ProjectGlobalExternalVpnGatewayResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TestPermissionsResponse>newBuilder()
                      .setResponseInstance(TestPermissionsResponse.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteExternalVpnGatewayHttpRequest, Operation>
      deleteExternalVpnGatewayCallable;
  private final UnaryCallable<GetExternalVpnGatewayHttpRequest, ExternalVpnGateway>
      getExternalVpnGatewayCallable;
  private final UnaryCallable<InsertExternalVpnGatewayHttpRequest, Operation>
      insertExternalVpnGatewayCallable;
  private final UnaryCallable<ListExternalVpnGatewaysHttpRequest, ExternalVpnGatewayList>
      listExternalVpnGatewaysCallable;
  private final UnaryCallable<
          ListExternalVpnGatewaysHttpRequest, ListExternalVpnGatewaysPagedResponse>
      listExternalVpnGatewaysPagedCallable;
  private final UnaryCallable<SetLabelsExternalVpnGatewayHttpRequest, Operation>
      setLabelsExternalVpnGatewayCallable;
  private final UnaryCallable<
          TestIamPermissionsExternalVpnGatewayHttpRequest, TestPermissionsResponse>
      testIamPermissionsExternalVpnGatewayCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonExternalVpnGatewayStub create(ExternalVpnGatewayStubSettings settings)
      throws IOException {
    return new HttpJsonExternalVpnGatewayStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonExternalVpnGatewayStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonExternalVpnGatewayStub(
        ExternalVpnGatewayStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonExternalVpnGatewayStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonExternalVpnGatewayStub(
        ExternalVpnGatewayStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonExternalVpnGatewayStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonExternalVpnGatewayStub(
      ExternalVpnGatewayStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonExternalVpnGatewayCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonExternalVpnGatewayStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonExternalVpnGatewayStub(
      ExternalVpnGatewayStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteExternalVpnGatewayHttpRequest, Operation>
        deleteExternalVpnGatewayTransportSettings =
            HttpJsonCallSettings.<DeleteExternalVpnGatewayHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteExternalVpnGatewayMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetExternalVpnGatewayHttpRequest, ExternalVpnGateway>
        getExternalVpnGatewayTransportSettings =
            HttpJsonCallSettings.<GetExternalVpnGatewayHttpRequest, ExternalVpnGateway>newBuilder()
                .setMethodDescriptor(getExternalVpnGatewayMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertExternalVpnGatewayHttpRequest, Operation>
        insertExternalVpnGatewayTransportSettings =
            HttpJsonCallSettings.<InsertExternalVpnGatewayHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertExternalVpnGatewayMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListExternalVpnGatewaysHttpRequest, ExternalVpnGatewayList>
        listExternalVpnGatewaysTransportSettings =
            HttpJsonCallSettings
                .<ListExternalVpnGatewaysHttpRequest, ExternalVpnGatewayList>newBuilder()
                .setMethodDescriptor(listExternalVpnGatewaysMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetLabelsExternalVpnGatewayHttpRequest, Operation>
        setLabelsExternalVpnGatewayTransportSettings =
            HttpJsonCallSettings.<SetLabelsExternalVpnGatewayHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setLabelsExternalVpnGatewayMethodDescriptor)
                .build();
    HttpJsonCallSettings<TestIamPermissionsExternalVpnGatewayHttpRequest, TestPermissionsResponse>
        testIamPermissionsExternalVpnGatewayTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsExternalVpnGatewayHttpRequest, TestPermissionsResponse>
                    newBuilder()
                .setMethodDescriptor(testIamPermissionsExternalVpnGatewayMethodDescriptor)
                .build();

    this.deleteExternalVpnGatewayCallable =
        callableFactory.createUnaryCallable(
            deleteExternalVpnGatewayTransportSettings,
            settings.deleteExternalVpnGatewaySettings(),
            clientContext);
    this.getExternalVpnGatewayCallable =
        callableFactory.createUnaryCallable(
            getExternalVpnGatewayTransportSettings,
            settings.getExternalVpnGatewaySettings(),
            clientContext);
    this.insertExternalVpnGatewayCallable =
        callableFactory.createUnaryCallable(
            insertExternalVpnGatewayTransportSettings,
            settings.insertExternalVpnGatewaySettings(),
            clientContext);
    this.listExternalVpnGatewaysCallable =
        callableFactory.createUnaryCallable(
            listExternalVpnGatewaysTransportSettings,
            settings.listExternalVpnGatewaysSettings(),
            clientContext);
    this.listExternalVpnGatewaysPagedCallable =
        callableFactory.createPagedCallable(
            listExternalVpnGatewaysTransportSettings,
            settings.listExternalVpnGatewaysSettings(),
            clientContext);
    this.setLabelsExternalVpnGatewayCallable =
        callableFactory.createUnaryCallable(
            setLabelsExternalVpnGatewayTransportSettings,
            settings.setLabelsExternalVpnGatewaySettings(),
            clientContext);
    this.testIamPermissionsExternalVpnGatewayCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsExternalVpnGatewayTransportSettings,
            settings.testIamPermissionsExternalVpnGatewaySettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteExternalVpnGatewayHttpRequest, Operation>
      deleteExternalVpnGatewayCallable() {
    return deleteExternalVpnGatewayCallable;
  }

  @BetaApi
  public UnaryCallable<GetExternalVpnGatewayHttpRequest, ExternalVpnGateway>
      getExternalVpnGatewayCallable() {
    return getExternalVpnGatewayCallable;
  }

  @BetaApi
  public UnaryCallable<InsertExternalVpnGatewayHttpRequest, Operation>
      insertExternalVpnGatewayCallable() {
    return insertExternalVpnGatewayCallable;
  }

  @BetaApi
  public UnaryCallable<ListExternalVpnGatewaysHttpRequest, ListExternalVpnGatewaysPagedResponse>
      listExternalVpnGatewaysPagedCallable() {
    return listExternalVpnGatewaysPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListExternalVpnGatewaysHttpRequest, ExternalVpnGatewayList>
      listExternalVpnGatewaysCallable() {
    return listExternalVpnGatewaysCallable;
  }

  @BetaApi
  public UnaryCallable<SetLabelsExternalVpnGatewayHttpRequest, Operation>
      setLabelsExternalVpnGatewayCallable() {
    return setLabelsExternalVpnGatewayCallable;
  }

  @BetaApi
  public UnaryCallable<TestIamPermissionsExternalVpnGatewayHttpRequest, TestPermissionsResponse>
      testIamPermissionsExternalVpnGatewayCallable() {
    return testIamPermissionsExternalVpnGatewayCallable;
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
