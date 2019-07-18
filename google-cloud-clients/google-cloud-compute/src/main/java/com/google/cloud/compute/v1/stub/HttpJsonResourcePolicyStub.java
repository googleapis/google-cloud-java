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

import static com.google.cloud.compute.v1.ResourcePolicyClient.AggregatedListResourcePoliciesPagedResponse;
import static com.google.cloud.compute.v1.ResourcePolicyClient.ListResourcePoliciesPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListResourcePoliciesHttpRequest;
import com.google.cloud.compute.v1.DeleteResourcePolicyHttpRequest;
import com.google.cloud.compute.v1.GetIamPolicyResourcePolicyHttpRequest;
import com.google.cloud.compute.v1.GetResourcePolicyHttpRequest;
import com.google.cloud.compute.v1.InsertResourcePolicyHttpRequest;
import com.google.cloud.compute.v1.ListResourcePoliciesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.ProjectRegionResourcePolicyName;
import com.google.cloud.compute.v1.ProjectRegionResourcePolicyResourceName;
import com.google.cloud.compute.v1.ResourcePolicy;
import com.google.cloud.compute.v1.ResourcePolicyAggregatedList;
import com.google.cloud.compute.v1.ResourcePolicyList;
import com.google.cloud.compute.v1.SetIamPolicyResourcePolicyHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsResourcePolicyHttpRequest;
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
public class HttpJsonResourcePolicyStub extends ResourcePolicyStub {
  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListResourcePoliciesHttpRequest, ResourcePolicyAggregatedList>
      aggregatedListResourcePoliciesMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListResourcePoliciesHttpRequest, ResourcePolicyAggregatedList>newBuilder()
              .setFullMethodName("compute.resourcePolicies.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<AggregatedListResourcePoliciesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/aggregated/resourcePolicies"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<ResourcePolicyAggregatedList>newBuilder()
                      .setResponseInstance(ResourcePolicyAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteResourcePolicyHttpRequest, Operation>
      deleteResourcePolicyMethodDescriptor =
          ApiMethodDescriptor.<DeleteResourcePolicyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.resourcePolicies.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteResourcePolicyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/resourcePolicies/{resourcePolicy}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionResourcePolicyName.newFactory())
                      .setResourceNameField("resourcePolicy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetResourcePolicyHttpRequest, ResourcePolicy>
      getResourcePolicyMethodDescriptor =
          ApiMethodDescriptor.<GetResourcePolicyHttpRequest, ResourcePolicy>newBuilder()
              .setFullMethodName("compute.resourcePolicies.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetResourcePolicyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/resourcePolicies/{resourcePolicy}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionResourcePolicyName.newFactory())
                      .setResourceNameField("resourcePolicy")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<ResourcePolicy>newBuilder()
                      .setResponseInstance(ResourcePolicy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetIamPolicyResourcePolicyHttpRequest, Policy>
      getIamPolicyResourcePolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyResourcePolicyHttpRequest, Policy>newBuilder()
              .setFullMethodName("compute.resourcePolicies.getIamPolicy")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetIamPolicyResourcePolicyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/resourcePolicies/{resource}/getIamPolicy"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionResourcePolicyResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Policy>newBuilder()
                      .setResponseInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertResourcePolicyHttpRequest, Operation>
      insertResourcePolicyMethodDescriptor =
          ApiMethodDescriptor.<InsertResourcePolicyHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.resourcePolicies.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertResourcePolicyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/resourcePolicies"))
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
  public static final ApiMethodDescriptor<ListResourcePoliciesHttpRequest, ResourcePolicyList>
      listResourcePoliciesMethodDescriptor =
          ApiMethodDescriptor.<ListResourcePoliciesHttpRequest, ResourcePolicyList>newBuilder()
              .setFullMethodName("compute.resourcePolicies.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListResourcePoliciesHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/resourcePolicies"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<ResourcePolicyList>newBuilder()
                      .setResponseInstance(ResourcePolicyList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetIamPolicyResourcePolicyHttpRequest, Policy>
      setIamPolicyResourcePolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyResourcePolicyHttpRequest, Policy>newBuilder()
              .setFullMethodName("compute.resourcePolicies.setIamPolicy")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<SetIamPolicyResourcePolicyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/resourcePolicies/{resource}/setIamPolicy"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionResourcePolicyResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Policy>newBuilder()
                      .setResponseInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          TestIamPermissionsResourcePolicyHttpRequest, TestPermissionsResponse>
      testIamPermissionsResourcePolicyMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsResourcePolicyHttpRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("compute.resourcePolicies.testIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<TestIamPermissionsResourcePolicyHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/resourcePolicies/{resource}/testIamPermissions"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionResourcePolicyResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TestPermissionsResponse>newBuilder()
                      .setResponseInstance(TestPermissionsResponse.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<
          AggregatedListResourcePoliciesHttpRequest, ResourcePolicyAggregatedList>
      aggregatedListResourcePoliciesCallable;
  private final UnaryCallable<
          AggregatedListResourcePoliciesHttpRequest, AggregatedListResourcePoliciesPagedResponse>
      aggregatedListResourcePoliciesPagedCallable;
  private final UnaryCallable<DeleteResourcePolicyHttpRequest, Operation>
      deleteResourcePolicyCallable;
  private final UnaryCallable<GetResourcePolicyHttpRequest, ResourcePolicy>
      getResourcePolicyCallable;
  private final UnaryCallable<GetIamPolicyResourcePolicyHttpRequest, Policy>
      getIamPolicyResourcePolicyCallable;
  private final UnaryCallable<InsertResourcePolicyHttpRequest, Operation>
      insertResourcePolicyCallable;
  private final UnaryCallable<ListResourcePoliciesHttpRequest, ResourcePolicyList>
      listResourcePoliciesCallable;
  private final UnaryCallable<ListResourcePoliciesHttpRequest, ListResourcePoliciesPagedResponse>
      listResourcePoliciesPagedCallable;
  private final UnaryCallable<SetIamPolicyResourcePolicyHttpRequest, Policy>
      setIamPolicyResourcePolicyCallable;
  private final UnaryCallable<TestIamPermissionsResourcePolicyHttpRequest, TestPermissionsResponse>
      testIamPermissionsResourcePolicyCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonResourcePolicyStub create(ResourcePolicyStubSettings settings)
      throws IOException {
    return new HttpJsonResourcePolicyStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonResourcePolicyStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonResourcePolicyStub(
        ResourcePolicyStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonResourcePolicyStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonResourcePolicyStub(
        ResourcePolicyStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonResourcePolicyStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonResourcePolicyStub(
      ResourcePolicyStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonResourcePolicyCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonResourcePolicyStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonResourcePolicyStub(
      ResourcePolicyStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListResourcePoliciesHttpRequest, ResourcePolicyAggregatedList>
        aggregatedListResourcePoliciesTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListResourcePoliciesHttpRequest, ResourcePolicyAggregatedList>
                    newBuilder()
                .setMethodDescriptor(aggregatedListResourcePoliciesMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteResourcePolicyHttpRequest, Operation>
        deleteResourcePolicyTransportSettings =
            HttpJsonCallSettings.<DeleteResourcePolicyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteResourcePolicyMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetResourcePolicyHttpRequest, ResourcePolicy>
        getResourcePolicyTransportSettings =
            HttpJsonCallSettings.<GetResourcePolicyHttpRequest, ResourcePolicy>newBuilder()
                .setMethodDescriptor(getResourcePolicyMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetIamPolicyResourcePolicyHttpRequest, Policy>
        getIamPolicyResourcePolicyTransportSettings =
            HttpJsonCallSettings.<GetIamPolicyResourcePolicyHttpRequest, Policy>newBuilder()
                .setMethodDescriptor(getIamPolicyResourcePolicyMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertResourcePolicyHttpRequest, Operation>
        insertResourcePolicyTransportSettings =
            HttpJsonCallSettings.<InsertResourcePolicyHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertResourcePolicyMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListResourcePoliciesHttpRequest, ResourcePolicyList>
        listResourcePoliciesTransportSettings =
            HttpJsonCallSettings.<ListResourcePoliciesHttpRequest, ResourcePolicyList>newBuilder()
                .setMethodDescriptor(listResourcePoliciesMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetIamPolicyResourcePolicyHttpRequest, Policy>
        setIamPolicyResourcePolicyTransportSettings =
            HttpJsonCallSettings.<SetIamPolicyResourcePolicyHttpRequest, Policy>newBuilder()
                .setMethodDescriptor(setIamPolicyResourcePolicyMethodDescriptor)
                .build();
    HttpJsonCallSettings<TestIamPermissionsResourcePolicyHttpRequest, TestPermissionsResponse>
        testIamPermissionsResourcePolicyTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsResourcePolicyHttpRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsResourcePolicyMethodDescriptor)
                .build();

    this.aggregatedListResourcePoliciesCallable =
        callableFactory.createUnaryCallable(
            aggregatedListResourcePoliciesTransportSettings,
            settings.aggregatedListResourcePoliciesSettings(),
            clientContext);
    this.aggregatedListResourcePoliciesPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListResourcePoliciesTransportSettings,
            settings.aggregatedListResourcePoliciesSettings(),
            clientContext);
    this.deleteResourcePolicyCallable =
        callableFactory.createUnaryCallable(
            deleteResourcePolicyTransportSettings,
            settings.deleteResourcePolicySettings(),
            clientContext);
    this.getResourcePolicyCallable =
        callableFactory.createUnaryCallable(
            getResourcePolicyTransportSettings,
            settings.getResourcePolicySettings(),
            clientContext);
    this.getIamPolicyResourcePolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyResourcePolicyTransportSettings,
            settings.getIamPolicyResourcePolicySettings(),
            clientContext);
    this.insertResourcePolicyCallable =
        callableFactory.createUnaryCallable(
            insertResourcePolicyTransportSettings,
            settings.insertResourcePolicySettings(),
            clientContext);
    this.listResourcePoliciesCallable =
        callableFactory.createUnaryCallable(
            listResourcePoliciesTransportSettings,
            settings.listResourcePoliciesSettings(),
            clientContext);
    this.listResourcePoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listResourcePoliciesTransportSettings,
            settings.listResourcePoliciesSettings(),
            clientContext);
    this.setIamPolicyResourcePolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyResourcePolicyTransportSettings,
            settings.setIamPolicyResourcePolicySettings(),
            clientContext);
    this.testIamPermissionsResourcePolicyCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsResourcePolicyTransportSettings,
            settings.testIamPermissionsResourcePolicySettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<
          AggregatedListResourcePoliciesHttpRequest, AggregatedListResourcePoliciesPagedResponse>
      aggregatedListResourcePoliciesPagedCallable() {
    return aggregatedListResourcePoliciesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListResourcePoliciesHttpRequest, ResourcePolicyAggregatedList>
      aggregatedListResourcePoliciesCallable() {
    return aggregatedListResourcePoliciesCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteResourcePolicyHttpRequest, Operation> deleteResourcePolicyCallable() {
    return deleteResourcePolicyCallable;
  }

  @BetaApi
  public UnaryCallable<GetResourcePolicyHttpRequest, ResourcePolicy> getResourcePolicyCallable() {
    return getResourcePolicyCallable;
  }

  @BetaApi
  public UnaryCallable<GetIamPolicyResourcePolicyHttpRequest, Policy>
      getIamPolicyResourcePolicyCallable() {
    return getIamPolicyResourcePolicyCallable;
  }

  @BetaApi
  public UnaryCallable<InsertResourcePolicyHttpRequest, Operation> insertResourcePolicyCallable() {
    return insertResourcePolicyCallable;
  }

  @BetaApi
  public UnaryCallable<ListResourcePoliciesHttpRequest, ListResourcePoliciesPagedResponse>
      listResourcePoliciesPagedCallable() {
    return listResourcePoliciesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListResourcePoliciesHttpRequest, ResourcePolicyList>
      listResourcePoliciesCallable() {
    return listResourcePoliciesCallable;
  }

  @BetaApi
  public UnaryCallable<SetIamPolicyResourcePolicyHttpRequest, Policy>
      setIamPolicyResourcePolicyCallable() {
    return setIamPolicyResourcePolicyCallable;
  }

  @BetaApi
  public UnaryCallable<TestIamPermissionsResourcePolicyHttpRequest, TestPermissionsResponse>
      testIamPermissionsResourcePolicyCallable() {
    return testIamPermissionsResourcePolicyCallable;
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
