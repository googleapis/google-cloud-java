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

import static com.google.cloud.compute.v1.InstanceTemplateClient.ListInstanceTemplatesPagedResponse;

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
import com.google.cloud.compute.v1.DeleteInstanceTemplateHttpRequest;
import com.google.cloud.compute.v1.GetIamPolicyInstanceTemplateHttpRequest;
import com.google.cloud.compute.v1.GetInstanceTemplateHttpRequest;
import com.google.cloud.compute.v1.InsertInstanceTemplateHttpRequest;
import com.google.cloud.compute.v1.InstanceTemplate;
import com.google.cloud.compute.v1.InstanceTemplateList;
import com.google.cloud.compute.v1.ListInstanceTemplatesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.ProjectGlobalInstanceTemplateName;
import com.google.cloud.compute.v1.ProjectGlobalInstanceTemplateResourceName;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.SetIamPolicyInstanceTemplateHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsInstanceTemplateHttpRequest;
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
public class HttpJsonInstanceTemplateStub extends InstanceTemplateStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteInstanceTemplateHttpRequest, Operation>
      deleteInstanceTemplateMethodDescriptor =
          ApiMethodDescriptor.<DeleteInstanceTemplateHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.instanceTemplates.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteInstanceTemplateHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/instanceTemplates/{instanceTemplate}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalInstanceTemplateName.newFactory())
                      .setResourceNameField("instanceTemplate")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetInstanceTemplateHttpRequest, InstanceTemplate>
      getInstanceTemplateMethodDescriptor =
          ApiMethodDescriptor.<GetInstanceTemplateHttpRequest, InstanceTemplate>newBuilder()
              .setFullMethodName("compute.instanceTemplates.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetInstanceTemplateHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/instanceTemplates/{instanceTemplate}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalInstanceTemplateName.newFactory())
                      .setResourceNameField("instanceTemplate")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<InstanceTemplate>newBuilder()
                      .setResponseInstance(InstanceTemplate.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetIamPolicyInstanceTemplateHttpRequest, Policy>
      getIamPolicyInstanceTemplateMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyInstanceTemplateHttpRequest, Policy>newBuilder()
              .setFullMethodName("compute.instanceTemplates.getIamPolicy")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<GetIamPolicyInstanceTemplateHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/instanceTemplates/{resource}/getIamPolicy"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(
                          ProjectGlobalInstanceTemplateResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Policy>newBuilder()
                      .setResponseInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertInstanceTemplateHttpRequest, Operation>
      insertInstanceTemplateMethodDescriptor =
          ApiMethodDescriptor.<InsertInstanceTemplateHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.instanceTemplates.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertInstanceTemplateHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/instanceTemplates"))
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
  public static final ApiMethodDescriptor<ListInstanceTemplatesHttpRequest, InstanceTemplateList>
      listInstanceTemplatesMethodDescriptor =
          ApiMethodDescriptor.<ListInstanceTemplatesHttpRequest, InstanceTemplateList>newBuilder()
              .setFullMethodName("compute.instanceTemplates.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListInstanceTemplatesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/instanceTemplates"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<InstanceTemplateList>newBuilder()
                      .setResponseInstance(InstanceTemplateList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetIamPolicyInstanceTemplateHttpRequest, Policy>
      setIamPolicyInstanceTemplateMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyInstanceTemplateHttpRequest, Policy>newBuilder()
              .setFullMethodName("compute.instanceTemplates.setIamPolicy")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<SetIamPolicyInstanceTemplateHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/instanceTemplates/{resource}/setIamPolicy"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(
                          ProjectGlobalInstanceTemplateResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Policy>newBuilder()
                      .setResponseInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          TestIamPermissionsInstanceTemplateHttpRequest, TestPermissionsResponse>
      testIamPermissionsInstanceTemplateMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsInstanceTemplateHttpRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("compute.instanceTemplates.testIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<TestIamPermissionsInstanceTemplateHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/instanceTemplates/{resource}/testIamPermissions"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(
                          ProjectGlobalInstanceTemplateResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TestPermissionsResponse>newBuilder()
                      .setResponseInstance(TestPermissionsResponse.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteInstanceTemplateHttpRequest, Operation>
      deleteInstanceTemplateCallable;
  private final UnaryCallable<GetInstanceTemplateHttpRequest, InstanceTemplate>
      getInstanceTemplateCallable;
  private final UnaryCallable<GetIamPolicyInstanceTemplateHttpRequest, Policy>
      getIamPolicyInstanceTemplateCallable;
  private final UnaryCallable<InsertInstanceTemplateHttpRequest, Operation>
      insertInstanceTemplateCallable;
  private final UnaryCallable<ListInstanceTemplatesHttpRequest, InstanceTemplateList>
      listInstanceTemplatesCallable;
  private final UnaryCallable<ListInstanceTemplatesHttpRequest, ListInstanceTemplatesPagedResponse>
      listInstanceTemplatesPagedCallable;
  private final UnaryCallable<SetIamPolicyInstanceTemplateHttpRequest, Policy>
      setIamPolicyInstanceTemplateCallable;
  private final UnaryCallable<
          TestIamPermissionsInstanceTemplateHttpRequest, TestPermissionsResponse>
      testIamPermissionsInstanceTemplateCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonInstanceTemplateStub create(InstanceTemplateStubSettings settings)
      throws IOException {
    return new HttpJsonInstanceTemplateStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonInstanceTemplateStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonInstanceTemplateStub(
        InstanceTemplateStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonInstanceTemplateStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonInstanceTemplateStub(
        InstanceTemplateStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonInstanceTemplateStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonInstanceTemplateStub(
      InstanceTemplateStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonInstanceTemplateCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonInstanceTemplateStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonInstanceTemplateStub(
      InstanceTemplateStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteInstanceTemplateHttpRequest, Operation>
        deleteInstanceTemplateTransportSettings =
            HttpJsonCallSettings.<DeleteInstanceTemplateHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteInstanceTemplateMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetInstanceTemplateHttpRequest, InstanceTemplate>
        getInstanceTemplateTransportSettings =
            HttpJsonCallSettings.<GetInstanceTemplateHttpRequest, InstanceTemplate>newBuilder()
                .setMethodDescriptor(getInstanceTemplateMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetIamPolicyInstanceTemplateHttpRequest, Policy>
        getIamPolicyInstanceTemplateTransportSettings =
            HttpJsonCallSettings.<GetIamPolicyInstanceTemplateHttpRequest, Policy>newBuilder()
                .setMethodDescriptor(getIamPolicyInstanceTemplateMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertInstanceTemplateHttpRequest, Operation>
        insertInstanceTemplateTransportSettings =
            HttpJsonCallSettings.<InsertInstanceTemplateHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertInstanceTemplateMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListInstanceTemplatesHttpRequest, InstanceTemplateList>
        listInstanceTemplatesTransportSettings =
            HttpJsonCallSettings
                .<ListInstanceTemplatesHttpRequest, InstanceTemplateList>newBuilder()
                .setMethodDescriptor(listInstanceTemplatesMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetIamPolicyInstanceTemplateHttpRequest, Policy>
        setIamPolicyInstanceTemplateTransportSettings =
            HttpJsonCallSettings.<SetIamPolicyInstanceTemplateHttpRequest, Policy>newBuilder()
                .setMethodDescriptor(setIamPolicyInstanceTemplateMethodDescriptor)
                .build();
    HttpJsonCallSettings<TestIamPermissionsInstanceTemplateHttpRequest, TestPermissionsResponse>
        testIamPermissionsInstanceTemplateTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsInstanceTemplateHttpRequest, TestPermissionsResponse>
                    newBuilder()
                .setMethodDescriptor(testIamPermissionsInstanceTemplateMethodDescriptor)
                .build();

    this.deleteInstanceTemplateCallable =
        callableFactory.createUnaryCallable(
            deleteInstanceTemplateTransportSettings,
            settings.deleteInstanceTemplateSettings(),
            clientContext);
    this.getInstanceTemplateCallable =
        callableFactory.createUnaryCallable(
            getInstanceTemplateTransportSettings,
            settings.getInstanceTemplateSettings(),
            clientContext);
    this.getIamPolicyInstanceTemplateCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyInstanceTemplateTransportSettings,
            settings.getIamPolicyInstanceTemplateSettings(),
            clientContext);
    this.insertInstanceTemplateCallable =
        callableFactory.createUnaryCallable(
            insertInstanceTemplateTransportSettings,
            settings.insertInstanceTemplateSettings(),
            clientContext);
    this.listInstanceTemplatesCallable =
        callableFactory.createUnaryCallable(
            listInstanceTemplatesTransportSettings,
            settings.listInstanceTemplatesSettings(),
            clientContext);
    this.listInstanceTemplatesPagedCallable =
        callableFactory.createPagedCallable(
            listInstanceTemplatesTransportSettings,
            settings.listInstanceTemplatesSettings(),
            clientContext);
    this.setIamPolicyInstanceTemplateCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyInstanceTemplateTransportSettings,
            settings.setIamPolicyInstanceTemplateSettings(),
            clientContext);
    this.testIamPermissionsInstanceTemplateCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsInstanceTemplateTransportSettings,
            settings.testIamPermissionsInstanceTemplateSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteInstanceTemplateHttpRequest, Operation>
      deleteInstanceTemplateCallable() {
    return deleteInstanceTemplateCallable;
  }

  @BetaApi
  public UnaryCallable<GetInstanceTemplateHttpRequest, InstanceTemplate>
      getInstanceTemplateCallable() {
    return getInstanceTemplateCallable;
  }

  @BetaApi
  public UnaryCallable<GetIamPolicyInstanceTemplateHttpRequest, Policy>
      getIamPolicyInstanceTemplateCallable() {
    return getIamPolicyInstanceTemplateCallable;
  }

  @BetaApi
  public UnaryCallable<InsertInstanceTemplateHttpRequest, Operation>
      insertInstanceTemplateCallable() {
    return insertInstanceTemplateCallable;
  }

  @BetaApi
  public UnaryCallable<ListInstanceTemplatesHttpRequest, ListInstanceTemplatesPagedResponse>
      listInstanceTemplatesPagedCallable() {
    return listInstanceTemplatesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListInstanceTemplatesHttpRequest, InstanceTemplateList>
      listInstanceTemplatesCallable() {
    return listInstanceTemplatesCallable;
  }

  @BetaApi
  public UnaryCallable<SetIamPolicyInstanceTemplateHttpRequest, Policy>
      setIamPolicyInstanceTemplateCallable() {
    return setIamPolicyInstanceTemplateCallable;
  }

  @BetaApi
  public UnaryCallable<TestIamPermissionsInstanceTemplateHttpRequest, TestPermissionsResponse>
      testIamPermissionsInstanceTemplateCallable() {
    return testIamPermissionsInstanceTemplateCallable;
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
