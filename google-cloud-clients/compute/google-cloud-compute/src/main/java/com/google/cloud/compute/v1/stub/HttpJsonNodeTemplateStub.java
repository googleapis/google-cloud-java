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

import static com.google.cloud.compute.v1.NodeTemplateClient.AggregatedListNodeTemplatesPagedResponse;
import static com.google.cloud.compute.v1.NodeTemplateClient.ListNodeTemplatesPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListNodeTemplatesHttpRequest;
import com.google.cloud.compute.v1.DeleteNodeTemplateHttpRequest;
import com.google.cloud.compute.v1.GetIamPolicyNodeTemplateHttpRequest;
import com.google.cloud.compute.v1.GetNodeTemplateHttpRequest;
import com.google.cloud.compute.v1.InsertNodeTemplateHttpRequest;
import com.google.cloud.compute.v1.ListNodeTemplatesHttpRequest;
import com.google.cloud.compute.v1.NodeTemplate;
import com.google.cloud.compute.v1.NodeTemplateAggregatedList;
import com.google.cloud.compute.v1.NodeTemplateList;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.ProjectRegionNodeTemplateName;
import com.google.cloud.compute.v1.ProjectRegionNodeTemplateResourceName;
import com.google.cloud.compute.v1.SetIamPolicyNodeTemplateHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsNodeTemplateHttpRequest;
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
public class HttpJsonNodeTemplateStub extends NodeTemplateStub {
  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListNodeTemplatesHttpRequest, NodeTemplateAggregatedList>
      aggregatedListNodeTemplatesMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListNodeTemplatesHttpRequest, NodeTemplateAggregatedList>newBuilder()
              .setFullMethodName("compute.nodeTemplates.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<AggregatedListNodeTemplatesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/aggregated/nodeTemplates"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<NodeTemplateAggregatedList>newBuilder()
                      .setResponseInstance(NodeTemplateAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteNodeTemplateHttpRequest, Operation>
      deleteNodeTemplateMethodDescriptor =
          ApiMethodDescriptor.<DeleteNodeTemplateHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.nodeTemplates.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteNodeTemplateHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/nodeTemplates/{nodeTemplate}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionNodeTemplateName.newFactory())
                      .setResourceNameField("nodeTemplate")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetNodeTemplateHttpRequest, NodeTemplate>
      getNodeTemplateMethodDescriptor =
          ApiMethodDescriptor.<GetNodeTemplateHttpRequest, NodeTemplate>newBuilder()
              .setFullMethodName("compute.nodeTemplates.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetNodeTemplateHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/nodeTemplates/{nodeTemplate}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionNodeTemplateName.newFactory())
                      .setResourceNameField("nodeTemplate")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<NodeTemplate>newBuilder()
                      .setResponseInstance(NodeTemplate.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetIamPolicyNodeTemplateHttpRequest, Policy>
      getIamPolicyNodeTemplateMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyNodeTemplateHttpRequest, Policy>newBuilder()
              .setFullMethodName("compute.nodeTemplates.getIamPolicy")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetIamPolicyNodeTemplateHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/nodeTemplates/{resource}/getIamPolicy"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionNodeTemplateResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Policy>newBuilder()
                      .setResponseInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertNodeTemplateHttpRequest, Operation>
      insertNodeTemplateMethodDescriptor =
          ApiMethodDescriptor.<InsertNodeTemplateHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.nodeTemplates.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertNodeTemplateHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/nodeTemplates"))
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
  public static final ApiMethodDescriptor<ListNodeTemplatesHttpRequest, NodeTemplateList>
      listNodeTemplatesMethodDescriptor =
          ApiMethodDescriptor.<ListNodeTemplatesHttpRequest, NodeTemplateList>newBuilder()
              .setFullMethodName("compute.nodeTemplates.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListNodeTemplatesHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/nodeTemplates"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<NodeTemplateList>newBuilder()
                      .setResponseInstance(NodeTemplateList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetIamPolicyNodeTemplateHttpRequest, Policy>
      setIamPolicyNodeTemplateMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyNodeTemplateHttpRequest, Policy>newBuilder()
              .setFullMethodName("compute.nodeTemplates.setIamPolicy")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<SetIamPolicyNodeTemplateHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/nodeTemplates/{resource}/setIamPolicy"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionNodeTemplateResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Policy>newBuilder()
                      .setResponseInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          TestIamPermissionsNodeTemplateHttpRequest, TestPermissionsResponse>
      testIamPermissionsNodeTemplateMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsNodeTemplateHttpRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("compute.nodeTemplates.testIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<TestIamPermissionsNodeTemplateHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/nodeTemplates/{resource}/testIamPermissions"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionNodeTemplateResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TestPermissionsResponse>newBuilder()
                      .setResponseInstance(TestPermissionsResponse.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AggregatedListNodeTemplatesHttpRequest, NodeTemplateAggregatedList>
      aggregatedListNodeTemplatesCallable;
  private final UnaryCallable<
          AggregatedListNodeTemplatesHttpRequest, AggregatedListNodeTemplatesPagedResponse>
      aggregatedListNodeTemplatesPagedCallable;
  private final UnaryCallable<DeleteNodeTemplateHttpRequest, Operation> deleteNodeTemplateCallable;
  private final UnaryCallable<GetNodeTemplateHttpRequest, NodeTemplate> getNodeTemplateCallable;
  private final UnaryCallable<GetIamPolicyNodeTemplateHttpRequest, Policy>
      getIamPolicyNodeTemplateCallable;
  private final UnaryCallable<InsertNodeTemplateHttpRequest, Operation> insertNodeTemplateCallable;
  private final UnaryCallable<ListNodeTemplatesHttpRequest, NodeTemplateList>
      listNodeTemplatesCallable;
  private final UnaryCallable<ListNodeTemplatesHttpRequest, ListNodeTemplatesPagedResponse>
      listNodeTemplatesPagedCallable;
  private final UnaryCallable<SetIamPolicyNodeTemplateHttpRequest, Policy>
      setIamPolicyNodeTemplateCallable;
  private final UnaryCallable<TestIamPermissionsNodeTemplateHttpRequest, TestPermissionsResponse>
      testIamPermissionsNodeTemplateCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonNodeTemplateStub create(NodeTemplateStubSettings settings)
      throws IOException {
    return new HttpJsonNodeTemplateStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonNodeTemplateStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonNodeTemplateStub(
        NodeTemplateStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonNodeTemplateStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonNodeTemplateStub(
        NodeTemplateStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonNodeTemplateStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonNodeTemplateStub(NodeTemplateStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonNodeTemplateCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonNodeTemplateStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonNodeTemplateStub(
      NodeTemplateStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListNodeTemplatesHttpRequest, NodeTemplateAggregatedList>
        aggregatedListNodeTemplatesTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListNodeTemplatesHttpRequest, NodeTemplateAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListNodeTemplatesMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteNodeTemplateHttpRequest, Operation>
        deleteNodeTemplateTransportSettings =
            HttpJsonCallSettings.<DeleteNodeTemplateHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteNodeTemplateMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetNodeTemplateHttpRequest, NodeTemplate>
        getNodeTemplateTransportSettings =
            HttpJsonCallSettings.<GetNodeTemplateHttpRequest, NodeTemplate>newBuilder()
                .setMethodDescriptor(getNodeTemplateMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetIamPolicyNodeTemplateHttpRequest, Policy>
        getIamPolicyNodeTemplateTransportSettings =
            HttpJsonCallSettings.<GetIamPolicyNodeTemplateHttpRequest, Policy>newBuilder()
                .setMethodDescriptor(getIamPolicyNodeTemplateMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertNodeTemplateHttpRequest, Operation>
        insertNodeTemplateTransportSettings =
            HttpJsonCallSettings.<InsertNodeTemplateHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertNodeTemplateMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListNodeTemplatesHttpRequest, NodeTemplateList>
        listNodeTemplatesTransportSettings =
            HttpJsonCallSettings.<ListNodeTemplatesHttpRequest, NodeTemplateList>newBuilder()
                .setMethodDescriptor(listNodeTemplatesMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetIamPolicyNodeTemplateHttpRequest, Policy>
        setIamPolicyNodeTemplateTransportSettings =
            HttpJsonCallSettings.<SetIamPolicyNodeTemplateHttpRequest, Policy>newBuilder()
                .setMethodDescriptor(setIamPolicyNodeTemplateMethodDescriptor)
                .build();
    HttpJsonCallSettings<TestIamPermissionsNodeTemplateHttpRequest, TestPermissionsResponse>
        testIamPermissionsNodeTemplateTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsNodeTemplateHttpRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsNodeTemplateMethodDescriptor)
                .build();

    this.aggregatedListNodeTemplatesCallable =
        callableFactory.createUnaryCallable(
            aggregatedListNodeTemplatesTransportSettings,
            settings.aggregatedListNodeTemplatesSettings(),
            clientContext);
    this.aggregatedListNodeTemplatesPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListNodeTemplatesTransportSettings,
            settings.aggregatedListNodeTemplatesSettings(),
            clientContext);
    this.deleteNodeTemplateCallable =
        callableFactory.createUnaryCallable(
            deleteNodeTemplateTransportSettings,
            settings.deleteNodeTemplateSettings(),
            clientContext);
    this.getNodeTemplateCallable =
        callableFactory.createUnaryCallable(
            getNodeTemplateTransportSettings, settings.getNodeTemplateSettings(), clientContext);
    this.getIamPolicyNodeTemplateCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyNodeTemplateTransportSettings,
            settings.getIamPolicyNodeTemplateSettings(),
            clientContext);
    this.insertNodeTemplateCallable =
        callableFactory.createUnaryCallable(
            insertNodeTemplateTransportSettings,
            settings.insertNodeTemplateSettings(),
            clientContext);
    this.listNodeTemplatesCallable =
        callableFactory.createUnaryCallable(
            listNodeTemplatesTransportSettings,
            settings.listNodeTemplatesSettings(),
            clientContext);
    this.listNodeTemplatesPagedCallable =
        callableFactory.createPagedCallable(
            listNodeTemplatesTransportSettings,
            settings.listNodeTemplatesSettings(),
            clientContext);
    this.setIamPolicyNodeTemplateCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyNodeTemplateTransportSettings,
            settings.setIamPolicyNodeTemplateSettings(),
            clientContext);
    this.testIamPermissionsNodeTemplateCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsNodeTemplateTransportSettings,
            settings.testIamPermissionsNodeTemplateSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<
          AggregatedListNodeTemplatesHttpRequest, AggregatedListNodeTemplatesPagedResponse>
      aggregatedListNodeTemplatesPagedCallable() {
    return aggregatedListNodeTemplatesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListNodeTemplatesHttpRequest, NodeTemplateAggregatedList>
      aggregatedListNodeTemplatesCallable() {
    return aggregatedListNodeTemplatesCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteNodeTemplateHttpRequest, Operation> deleteNodeTemplateCallable() {
    return deleteNodeTemplateCallable;
  }

  @BetaApi
  public UnaryCallable<GetNodeTemplateHttpRequest, NodeTemplate> getNodeTemplateCallable() {
    return getNodeTemplateCallable;
  }

  @BetaApi
  public UnaryCallable<GetIamPolicyNodeTemplateHttpRequest, Policy>
      getIamPolicyNodeTemplateCallable() {
    return getIamPolicyNodeTemplateCallable;
  }

  @BetaApi
  public UnaryCallable<InsertNodeTemplateHttpRequest, Operation> insertNodeTemplateCallable() {
    return insertNodeTemplateCallable;
  }

  @BetaApi
  public UnaryCallable<ListNodeTemplatesHttpRequest, ListNodeTemplatesPagedResponse>
      listNodeTemplatesPagedCallable() {
    return listNodeTemplatesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListNodeTemplatesHttpRequest, NodeTemplateList> listNodeTemplatesCallable() {
    return listNodeTemplatesCallable;
  }

  @BetaApi
  public UnaryCallable<SetIamPolicyNodeTemplateHttpRequest, Policy>
      setIamPolicyNodeTemplateCallable() {
    return setIamPolicyNodeTemplateCallable;
  }

  @BetaApi
  public UnaryCallable<TestIamPermissionsNodeTemplateHttpRequest, TestPermissionsResponse>
      testIamPermissionsNodeTemplateCallable() {
    return testIamPermissionsNodeTemplateCallable;
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
