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

import static com.google.cloud.compute.v1.NodeGroupClient.AggregatedListNodeGroupsPagedResponse;
import static com.google.cloud.compute.v1.NodeGroupClient.ListNodeGroupsPagedResponse;
import static com.google.cloud.compute.v1.NodeGroupClient.ListNodesNodeGroupsPagedResponse;

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
import com.google.cloud.compute.v1.AddNodesNodeGroupHttpRequest;
import com.google.cloud.compute.v1.AggregatedListNodeGroupsHttpRequest;
import com.google.cloud.compute.v1.DeleteNodeGroupHttpRequest;
import com.google.cloud.compute.v1.DeleteNodesNodeGroupHttpRequest;
import com.google.cloud.compute.v1.GetIamPolicyNodeGroupHttpRequest;
import com.google.cloud.compute.v1.GetNodeGroupHttpRequest;
import com.google.cloud.compute.v1.InsertNodeGroupHttpRequest;
import com.google.cloud.compute.v1.ListNodeGroupsHttpRequest;
import com.google.cloud.compute.v1.ListNodesNodeGroupsHttpRequest;
import com.google.cloud.compute.v1.NodeGroup;
import com.google.cloud.compute.v1.NodeGroupAggregatedList;
import com.google.cloud.compute.v1.NodeGroupList;
import com.google.cloud.compute.v1.NodeGroupsListNodes;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectZoneName;
import com.google.cloud.compute.v1.ProjectZoneNodeGroupName;
import com.google.cloud.compute.v1.ProjectZoneNodeGroupResourceName;
import com.google.cloud.compute.v1.SetIamPolicyNodeGroupHttpRequest;
import com.google.cloud.compute.v1.SetNodeTemplateNodeGroupHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsNodeGroupHttpRequest;
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
public class HttpJsonNodeGroupStub extends NodeGroupStub {
  @InternalApi
  public static final ApiMethodDescriptor<AddNodesNodeGroupHttpRequest, Operation>
      addNodesNodeGroupMethodDescriptor =
          ApiMethodDescriptor.<AddNodesNodeGroupHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.nodeGroups.addNodes")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<AddNodesNodeGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/nodeGroups/{nodeGroup}/addNodes"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneNodeGroupName.newFactory())
                      .setResourceNameField("nodeGroup")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListNodeGroupsHttpRequest, NodeGroupAggregatedList>
      aggregatedListNodeGroupsMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListNodeGroupsHttpRequest, NodeGroupAggregatedList>newBuilder()
              .setFullMethodName("compute.nodeGroups.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<AggregatedListNodeGroupsHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/aggregated/nodeGroups"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<NodeGroupAggregatedList>newBuilder()
                      .setResponseInstance(NodeGroupAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteNodeGroupHttpRequest, Operation>
      deleteNodeGroupMethodDescriptor =
          ApiMethodDescriptor.<DeleteNodeGroupHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.nodeGroups.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteNodeGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/zones/{zone}/nodeGroups/{nodeGroup}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneNodeGroupName.newFactory())
                      .setResourceNameField("nodeGroup")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteNodesNodeGroupHttpRequest, Operation>
      deleteNodesNodeGroupMethodDescriptor =
          ApiMethodDescriptor.<DeleteNodesNodeGroupHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.nodeGroups.deleteNodes")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteNodesNodeGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/nodeGroups/{nodeGroup}/deleteNodes"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneNodeGroupName.newFactory())
                      .setResourceNameField("nodeGroup")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetNodeGroupHttpRequest, NodeGroup>
      getNodeGroupMethodDescriptor =
          ApiMethodDescriptor.<GetNodeGroupHttpRequest, NodeGroup>newBuilder()
              .setFullMethodName("compute.nodeGroups.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetNodeGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/zones/{zone}/nodeGroups/{nodeGroup}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectZoneNodeGroupName.newFactory())
                      .setResourceNameField("nodeGroup")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<NodeGroup>newBuilder()
                      .setResponseInstance(NodeGroup.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetIamPolicyNodeGroupHttpRequest, Policy>
      getIamPolicyNodeGroupMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyNodeGroupHttpRequest, Policy>newBuilder()
              .setFullMethodName("compute.nodeGroups.getIamPolicy")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetIamPolicyNodeGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/nodeGroups/{resource}/getIamPolicy"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectZoneNodeGroupResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Policy>newBuilder()
                      .setResponseInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertNodeGroupHttpRequest, Operation>
      insertNodeGroupMethodDescriptor =
          ApiMethodDescriptor.<InsertNodeGroupHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.nodeGroups.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertNodeGroupHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/zones/{zone}/nodeGroups"))
                      .setQueryParams(Sets.<String>newHashSet("initialNodeCount", "requestId"))
                      .setResourceNameFactory(ProjectZoneName.newFactory())
                      .setResourceNameField("zone")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListNodeGroupsHttpRequest, NodeGroupList>
      listNodeGroupsMethodDescriptor =
          ApiMethodDescriptor.<ListNodeGroupsHttpRequest, NodeGroupList>newBuilder()
              .setFullMethodName("compute.nodeGroups.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListNodeGroupsHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/zones/{zone}/nodeGroups"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectZoneName.newFactory())
                      .setResourceNameField("zone")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<NodeGroupList>newBuilder()
                      .setResponseInstance(NodeGroupList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListNodesNodeGroupsHttpRequest, NodeGroupsListNodes>
      listNodesNodeGroupsMethodDescriptor =
          ApiMethodDescriptor.<ListNodesNodeGroupsHttpRequest, NodeGroupsListNodes>newBuilder()
              .setFullMethodName("compute.nodeGroups.listNodes")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListNodesNodeGroupsHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/nodeGroups/{nodeGroup}/listNodes"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectZoneNodeGroupName.newFactory())
                      .setResourceNameField("nodeGroup")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<NodeGroupsListNodes>newBuilder()
                      .setResponseInstance(NodeGroupsListNodes.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetIamPolicyNodeGroupHttpRequest, Policy>
      setIamPolicyNodeGroupMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyNodeGroupHttpRequest, Policy>newBuilder()
              .setFullMethodName("compute.nodeGroups.setIamPolicy")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<SetIamPolicyNodeGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/nodeGroups/{resource}/setIamPolicy"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectZoneNodeGroupResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Policy>newBuilder()
                      .setResponseInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetNodeTemplateNodeGroupHttpRequest, Operation>
      setNodeTemplateNodeGroupMethodDescriptor =
          ApiMethodDescriptor.<SetNodeTemplateNodeGroupHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.nodeGroups.setNodeTemplate")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<SetNodeTemplateNodeGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/nodeGroups/{nodeGroup}/setNodeTemplate"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneNodeGroupName.newFactory())
                      .setResourceNameField("nodeGroup")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          TestIamPermissionsNodeGroupHttpRequest, TestPermissionsResponse>
      testIamPermissionsNodeGroupMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsNodeGroupHttpRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("compute.nodeGroups.testIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<TestIamPermissionsNodeGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/nodeGroups/{resource}/testIamPermissions"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectZoneNodeGroupResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TestPermissionsResponse>newBuilder()
                      .setResponseInstance(TestPermissionsResponse.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AddNodesNodeGroupHttpRequest, Operation> addNodesNodeGroupCallable;
  private final UnaryCallable<AggregatedListNodeGroupsHttpRequest, NodeGroupAggregatedList>
      aggregatedListNodeGroupsCallable;
  private final UnaryCallable<
          AggregatedListNodeGroupsHttpRequest, AggregatedListNodeGroupsPagedResponse>
      aggregatedListNodeGroupsPagedCallable;
  private final UnaryCallable<DeleteNodeGroupHttpRequest, Operation> deleteNodeGroupCallable;
  private final UnaryCallable<DeleteNodesNodeGroupHttpRequest, Operation>
      deleteNodesNodeGroupCallable;
  private final UnaryCallable<GetNodeGroupHttpRequest, NodeGroup> getNodeGroupCallable;
  private final UnaryCallable<GetIamPolicyNodeGroupHttpRequest, Policy>
      getIamPolicyNodeGroupCallable;
  private final UnaryCallable<InsertNodeGroupHttpRequest, Operation> insertNodeGroupCallable;
  private final UnaryCallable<ListNodeGroupsHttpRequest, NodeGroupList> listNodeGroupsCallable;
  private final UnaryCallable<ListNodeGroupsHttpRequest, ListNodeGroupsPagedResponse>
      listNodeGroupsPagedCallable;
  private final UnaryCallable<ListNodesNodeGroupsHttpRequest, NodeGroupsListNodes>
      listNodesNodeGroupsCallable;
  private final UnaryCallable<ListNodesNodeGroupsHttpRequest, ListNodesNodeGroupsPagedResponse>
      listNodesNodeGroupsPagedCallable;
  private final UnaryCallable<SetIamPolicyNodeGroupHttpRequest, Policy>
      setIamPolicyNodeGroupCallable;
  private final UnaryCallable<SetNodeTemplateNodeGroupHttpRequest, Operation>
      setNodeTemplateNodeGroupCallable;
  private final UnaryCallable<TestIamPermissionsNodeGroupHttpRequest, TestPermissionsResponse>
      testIamPermissionsNodeGroupCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonNodeGroupStub create(NodeGroupStubSettings settings)
      throws IOException {
    return new HttpJsonNodeGroupStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonNodeGroupStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonNodeGroupStub(NodeGroupStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonNodeGroupStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonNodeGroupStub(
        NodeGroupStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonNodeGroupStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonNodeGroupStub(NodeGroupStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonNodeGroupCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonNodeGroupStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonNodeGroupStub(
      NodeGroupStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AddNodesNodeGroupHttpRequest, Operation>
        addNodesNodeGroupTransportSettings =
            HttpJsonCallSettings.<AddNodesNodeGroupHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(addNodesNodeGroupMethodDescriptor)
                .build();
    HttpJsonCallSettings<AggregatedListNodeGroupsHttpRequest, NodeGroupAggregatedList>
        aggregatedListNodeGroupsTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListNodeGroupsHttpRequest, NodeGroupAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListNodeGroupsMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteNodeGroupHttpRequest, Operation> deleteNodeGroupTransportSettings =
        HttpJsonCallSettings.<DeleteNodeGroupHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteNodeGroupMethodDescriptor)
            .build();
    HttpJsonCallSettings<DeleteNodesNodeGroupHttpRequest, Operation>
        deleteNodesNodeGroupTransportSettings =
            HttpJsonCallSettings.<DeleteNodesNodeGroupHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteNodesNodeGroupMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetNodeGroupHttpRequest, NodeGroup> getNodeGroupTransportSettings =
        HttpJsonCallSettings.<GetNodeGroupHttpRequest, NodeGroup>newBuilder()
            .setMethodDescriptor(getNodeGroupMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetIamPolicyNodeGroupHttpRequest, Policy>
        getIamPolicyNodeGroupTransportSettings =
            HttpJsonCallSettings.<GetIamPolicyNodeGroupHttpRequest, Policy>newBuilder()
                .setMethodDescriptor(getIamPolicyNodeGroupMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertNodeGroupHttpRequest, Operation> insertNodeGroupTransportSettings =
        HttpJsonCallSettings.<InsertNodeGroupHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(insertNodeGroupMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListNodeGroupsHttpRequest, NodeGroupList> listNodeGroupsTransportSettings =
        HttpJsonCallSettings.<ListNodeGroupsHttpRequest, NodeGroupList>newBuilder()
            .setMethodDescriptor(listNodeGroupsMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListNodesNodeGroupsHttpRequest, NodeGroupsListNodes>
        listNodesNodeGroupsTransportSettings =
            HttpJsonCallSettings.<ListNodesNodeGroupsHttpRequest, NodeGroupsListNodes>newBuilder()
                .setMethodDescriptor(listNodesNodeGroupsMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetIamPolicyNodeGroupHttpRequest, Policy>
        setIamPolicyNodeGroupTransportSettings =
            HttpJsonCallSettings.<SetIamPolicyNodeGroupHttpRequest, Policy>newBuilder()
                .setMethodDescriptor(setIamPolicyNodeGroupMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetNodeTemplateNodeGroupHttpRequest, Operation>
        setNodeTemplateNodeGroupTransportSettings =
            HttpJsonCallSettings.<SetNodeTemplateNodeGroupHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setNodeTemplateNodeGroupMethodDescriptor)
                .build();
    HttpJsonCallSettings<TestIamPermissionsNodeGroupHttpRequest, TestPermissionsResponse>
        testIamPermissionsNodeGroupTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsNodeGroupHttpRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsNodeGroupMethodDescriptor)
                .build();

    this.addNodesNodeGroupCallable =
        callableFactory.createUnaryCallable(
            addNodesNodeGroupTransportSettings,
            settings.addNodesNodeGroupSettings(),
            clientContext);
    this.aggregatedListNodeGroupsCallable =
        callableFactory.createUnaryCallable(
            aggregatedListNodeGroupsTransportSettings,
            settings.aggregatedListNodeGroupsSettings(),
            clientContext);
    this.aggregatedListNodeGroupsPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListNodeGroupsTransportSettings,
            settings.aggregatedListNodeGroupsSettings(),
            clientContext);
    this.deleteNodeGroupCallable =
        callableFactory.createUnaryCallable(
            deleteNodeGroupTransportSettings, settings.deleteNodeGroupSettings(), clientContext);
    this.deleteNodesNodeGroupCallable =
        callableFactory.createUnaryCallable(
            deleteNodesNodeGroupTransportSettings,
            settings.deleteNodesNodeGroupSettings(),
            clientContext);
    this.getNodeGroupCallable =
        callableFactory.createUnaryCallable(
            getNodeGroupTransportSettings, settings.getNodeGroupSettings(), clientContext);
    this.getIamPolicyNodeGroupCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyNodeGroupTransportSettings,
            settings.getIamPolicyNodeGroupSettings(),
            clientContext);
    this.insertNodeGroupCallable =
        callableFactory.createUnaryCallable(
            insertNodeGroupTransportSettings, settings.insertNodeGroupSettings(), clientContext);
    this.listNodeGroupsCallable =
        callableFactory.createUnaryCallable(
            listNodeGroupsTransportSettings, settings.listNodeGroupsSettings(), clientContext);
    this.listNodeGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listNodeGroupsTransportSettings, settings.listNodeGroupsSettings(), clientContext);
    this.listNodesNodeGroupsCallable =
        callableFactory.createUnaryCallable(
            listNodesNodeGroupsTransportSettings,
            settings.listNodesNodeGroupsSettings(),
            clientContext);
    this.listNodesNodeGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listNodesNodeGroupsTransportSettings,
            settings.listNodesNodeGroupsSettings(),
            clientContext);
    this.setIamPolicyNodeGroupCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyNodeGroupTransportSettings,
            settings.setIamPolicyNodeGroupSettings(),
            clientContext);
    this.setNodeTemplateNodeGroupCallable =
        callableFactory.createUnaryCallable(
            setNodeTemplateNodeGroupTransportSettings,
            settings.setNodeTemplateNodeGroupSettings(),
            clientContext);
    this.testIamPermissionsNodeGroupCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsNodeGroupTransportSettings,
            settings.testIamPermissionsNodeGroupSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<AddNodesNodeGroupHttpRequest, Operation> addNodesNodeGroupCallable() {
    return addNodesNodeGroupCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListNodeGroupsHttpRequest, AggregatedListNodeGroupsPagedResponse>
      aggregatedListNodeGroupsPagedCallable() {
    return aggregatedListNodeGroupsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListNodeGroupsHttpRequest, NodeGroupAggregatedList>
      aggregatedListNodeGroupsCallable() {
    return aggregatedListNodeGroupsCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteNodeGroupHttpRequest, Operation> deleteNodeGroupCallable() {
    return deleteNodeGroupCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteNodesNodeGroupHttpRequest, Operation> deleteNodesNodeGroupCallable() {
    return deleteNodesNodeGroupCallable;
  }

  @BetaApi
  public UnaryCallable<GetNodeGroupHttpRequest, NodeGroup> getNodeGroupCallable() {
    return getNodeGroupCallable;
  }

  @BetaApi
  public UnaryCallable<GetIamPolicyNodeGroupHttpRequest, Policy> getIamPolicyNodeGroupCallable() {
    return getIamPolicyNodeGroupCallable;
  }

  @BetaApi
  public UnaryCallable<InsertNodeGroupHttpRequest, Operation> insertNodeGroupCallable() {
    return insertNodeGroupCallable;
  }

  @BetaApi
  public UnaryCallable<ListNodeGroupsHttpRequest, ListNodeGroupsPagedResponse>
      listNodeGroupsPagedCallable() {
    return listNodeGroupsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListNodeGroupsHttpRequest, NodeGroupList> listNodeGroupsCallable() {
    return listNodeGroupsCallable;
  }

  @BetaApi
  public UnaryCallable<ListNodesNodeGroupsHttpRequest, ListNodesNodeGroupsPagedResponse>
      listNodesNodeGroupsPagedCallable() {
    return listNodesNodeGroupsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListNodesNodeGroupsHttpRequest, NodeGroupsListNodes>
      listNodesNodeGroupsCallable() {
    return listNodesNodeGroupsCallable;
  }

  @BetaApi
  public UnaryCallable<SetIamPolicyNodeGroupHttpRequest, Policy> setIamPolicyNodeGroupCallable() {
    return setIamPolicyNodeGroupCallable;
  }

  @BetaApi
  public UnaryCallable<SetNodeTemplateNodeGroupHttpRequest, Operation>
      setNodeTemplateNodeGroupCallable() {
    return setNodeTemplateNodeGroupCallable;
  }

  @BetaApi
  public UnaryCallable<TestIamPermissionsNodeGroupHttpRequest, TestPermissionsResponse>
      testIamPermissionsNodeGroupCallable() {
    return testIamPermissionsNodeGroupCallable;
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
