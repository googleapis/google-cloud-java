/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.compute.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.NodeTemplatesStub;
import com.google.cloud.compute.v1.stub.NodeTemplatesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The NodeTemplates API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
 *   String project = "";
 *   String region = "";
 *   String nodeTemplate = "";
 *   Operation response = nodeTemplatesClient.delete(project, region, nodeTemplate);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the nodeTemplatesClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of NodeTemplatesSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * NodeTemplatesSettings nodeTemplatesSettings =
 *     NodeTemplatesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NodeTemplatesClient nodeTemplatesClient =
 *     NodeTemplatesClient.create(nodeTemplatesSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * NodeTemplatesSettings nodeTemplatesSettings =
 *     NodeTemplatesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NodeTemplatesClient nodeTemplatesClient =
 *     NodeTemplatesClient.create(nodeTemplatesSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class NodeTemplatesClient implements BackgroundResource {
  private final NodeTemplatesSettings settings;
  private final NodeTemplatesStub stub;

  /** Constructs an instance of NodeTemplatesClient with default settings. */
  public static final NodeTemplatesClient create() throws IOException {
    return create(NodeTemplatesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NodeTemplatesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final NodeTemplatesClient create(NodeTemplatesSettings settings)
      throws IOException {
    return new NodeTemplatesClient(settings);
  }

  /**
   * Constructs an instance of NodeTemplatesClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use NodeTemplatesSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final NodeTemplatesClient create(NodeTemplatesStub stub) {
    return new NodeTemplatesClient(stub);
  }

  /**
   * Constructs an instance of NodeTemplatesClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected NodeTemplatesClient(NodeTemplatesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((NodeTemplatesStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected NodeTemplatesClient(NodeTemplatesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final NodeTemplatesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public NodeTemplatesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of node templates.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   String project = "";
   *   for (Entry&lt;String, NodeTemplatesScopedList&gt; element : nodeTemplatesClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListNodeTemplatesRequest request =
        AggregatedListNodeTemplatesRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of node templates.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   String project = "";
   *   AggregatedListNodeTemplatesRequest request = AggregatedListNodeTemplatesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Entry&lt;String, NodeTemplatesScopedList&gt; element : nodeTemplatesClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListNodeTemplatesRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of node templates.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   String project = "";
   *   AggregatedListNodeTemplatesRequest request = AggregatedListNodeTemplatesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;AggregatedListPagedResponse&gt; future = nodeTemplatesClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something
   *   for (Entry&lt;String, NodeTemplatesScopedList&gt; element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<AggregatedListNodeTemplatesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of node templates.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   String project = "";
   *   AggregatedListNodeTemplatesRequest request = AggregatedListNodeTemplatesRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     NodeTemplateAggregatedList response = nodeTemplatesClient.aggregatedListCallable().call(request);
   *     for (Entry&lt;String, NodeTemplatesScopedList&gt; element : response.getItemsMap()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<AggregatedListNodeTemplatesRequest, NodeTemplateAggregatedList>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified NodeTemplate resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String nodeTemplate = "";
   *   Operation response = nodeTemplatesClient.delete(project, region, nodeTemplate);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param nodeTemplate Name of the NodeTemplate resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String region, String nodeTemplate) {
    DeleteNodeTemplateRequest request =
        DeleteNodeTemplateRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setNodeTemplate(nodeTemplate)
            .build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified NodeTemplate resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   String nodeTemplate = "";
   *   String project = "";
   *   String region = "";
   *   DeleteNodeTemplateRequest request = DeleteNodeTemplateRequest.newBuilder()
   *     .setNodeTemplate(nodeTemplate)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = nodeTemplatesClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteNodeTemplateRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified NodeTemplate resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   String nodeTemplate = "";
   *   String project = "";
   *   String region = "";
   *   DeleteNodeTemplateRequest request = DeleteNodeTemplateRequest.newBuilder()
   *     .setNodeTemplate(nodeTemplate)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = nodeTemplatesClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteNodeTemplateRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified node template. Gets a list of available node templates by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String nodeTemplate = "";
   *   NodeTemplate response = nodeTemplatesClient.get(project, region, nodeTemplate);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param nodeTemplate Name of the node template to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NodeTemplate get(String project, String region, String nodeTemplate) {
    GetNodeTemplateRequest request =
        GetNodeTemplateRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setNodeTemplate(nodeTemplate)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified node template. Gets a list of available node templates by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   String nodeTemplate = "";
   *   String project = "";
   *   String region = "";
   *   GetNodeTemplateRequest request = GetNodeTemplateRequest.newBuilder()
   *     .setNodeTemplate(nodeTemplate)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   NodeTemplate response = nodeTemplatesClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NodeTemplate get(GetNodeTemplateRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified node template. Gets a list of available node templates by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   String nodeTemplate = "";
   *   String project = "";
   *   String region = "";
   *   GetNodeTemplateRequest request = GetNodeTemplateRequest.newBuilder()
   *     .setNodeTemplate(nodeTemplate)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;NodeTemplate&gt; future = nodeTemplatesClient.getCallable().futureCall(request);
   *   // Do something
   *   NodeTemplate response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetNodeTemplateRequest, NodeTemplate> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   Policy response = nodeTemplatesClient.getIamPolicy(project, region, resource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String project, String region, String resource) {
    GetIamPolicyNodeTemplateRequest request =
        GetIamPolicyNodeTemplateRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setResource(resource)
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   GetIamPolicyNodeTemplateRequest request = GetIamPolicyNodeTemplateRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResource(resource)
   *     .build();
   *   Policy response = nodeTemplatesClient.getIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyNodeTemplateRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   GetIamPolicyNodeTemplateRequest request = GetIamPolicyNodeTemplateRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResource(resource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = nodeTemplatesClient.getIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetIamPolicyNodeTemplateRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a NodeTemplate resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   NodeTemplate nodeTemplateResource = NodeTemplate.newBuilder().build();
   *   Operation response = nodeTemplatesClient.insert(project, region, nodeTemplateResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param nodeTemplateResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, String region, NodeTemplate nodeTemplateResource) {
    InsertNodeTemplateRequest request =
        InsertNodeTemplateRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setNodeTemplateResource(nodeTemplateResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a NodeTemplate resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   NodeTemplate nodeTemplateResource = NodeTemplate.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   InsertNodeTemplateRequest request = InsertNodeTemplateRequest.newBuilder()
   *     .setNodeTemplateResource(nodeTemplateResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   Operation response = nodeTemplatesClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertNodeTemplateRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a NodeTemplate resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   NodeTemplate nodeTemplateResource = NodeTemplate.newBuilder().build();
   *   String project = "";
   *   String region = "";
   *   InsertNodeTemplateRequest request = InsertNodeTemplateRequest.newBuilder()
   *     .setNodeTemplateResource(nodeTemplateResource)
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = nodeTemplatesClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertNodeTemplateRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of node templates available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   for (NodeTemplate element : nodeTemplatesClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region) {
    ListNodeTemplatesRequest request =
        ListNodeTemplatesRequest.newBuilder().setProject(project).setRegion(region).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of node templates available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListNodeTemplatesRequest request = ListNodeTemplatesRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   for (NodeTemplate element : nodeTemplatesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListNodeTemplatesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of node templates available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListNodeTemplatesRequest request = ListNodeTemplatesRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = nodeTemplatesClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (NodeTemplate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListNodeTemplatesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of node templates available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   ListNodeTemplatesRequest request = ListNodeTemplatesRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .build();
   *   while (true) {
   *     NodeTemplateList response = nodeTemplatesClient.listCallable().call(request);
   *     for (NodeTemplate element : response.getItemsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListNodeTemplatesRequest, NodeTemplateList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   RegionSetPolicyRequest regionSetPolicyRequestResource = RegionSetPolicyRequest.newBuilder().build();
   *   Policy response = nodeTemplatesClient.setIamPolicy(project, region, resource, regionSetPolicyRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param resource Name or id of the resource for this request.
   * @param regionSetPolicyRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(
      String project,
      String region,
      String resource,
      RegionSetPolicyRequest regionSetPolicyRequestResource) {
    SetIamPolicyNodeTemplateRequest request =
        SetIamPolicyNodeTemplateRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setResource(resource)
            .setRegionSetPolicyRequestResource(regionSetPolicyRequestResource)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   RegionSetPolicyRequest regionSetPolicyRequestResource = RegionSetPolicyRequest.newBuilder().build();
   *   String resource = "";
   *   SetIamPolicyNodeTemplateRequest request = SetIamPolicyNodeTemplateRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionSetPolicyRequestResource(regionSetPolicyRequestResource)
   *     .setResource(resource)
   *     .build();
   *   Policy response = nodeTemplatesClient.setIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyNodeTemplateRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   RegionSetPolicyRequest regionSetPolicyRequestResource = RegionSetPolicyRequest.newBuilder().build();
   *   String resource = "";
   *   SetIamPolicyNodeTemplateRequest request = SetIamPolicyNodeTemplateRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setRegionSetPolicyRequestResource(regionSetPolicyRequestResource)
   *     .setResource(resource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = nodeTemplatesClient.setIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetIamPolicyNodeTemplateRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = nodeTemplatesClient.testIamPermissions(project, region, resource, testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      String project,
      String region,
      String resource,
      TestPermissionsRequest testPermissionsRequestResource) {
    TestIamPermissionsNodeTemplateRequest request =
        TestIamPermissionsNodeTemplateRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsNodeTemplateRequest request = TestIamPermissionsNodeTemplateRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResource(resource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   TestPermissionsResponse response = nodeTemplatesClient.testIamPermissions(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsNodeTemplateRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplatesClient nodeTemplatesClient = NodeTemplatesClient.create()) {
   *   String project = "";
   *   String region = "";
   *   String resource = "";
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsNodeTemplateRequest request = TestIamPermissionsNodeTemplateRequest.newBuilder()
   *     .setProject(project)
   *     .setRegion(region)
   *     .setResource(resource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   ApiFuture&lt;TestPermissionsResponse&gt; future = nodeTemplatesClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something
   *   TestPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<TestIamPermissionsNodeTemplateRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class AggregatedListPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListNodeTemplatesRequest,
          NodeTemplateAggregatedList,
          Entry<String, NodeTemplatesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListNodeTemplatesRequest,
                NodeTemplateAggregatedList,
                Entry<String, NodeTemplatesScopedList>>
            context,
        ApiFuture<NodeTemplateAggregatedList> futureResponse) {
      ApiFuture<AggregatedListPage> futurePage =
          AggregatedListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<AggregatedListPage, AggregatedListPagedResponse>() {
            @Override
            public AggregatedListPagedResponse apply(AggregatedListPage input) {
              return new AggregatedListPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private AggregatedListPagedResponse(AggregatedListPage page) {
      super(page, AggregatedListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListPage
      extends AbstractPage<
          AggregatedListNodeTemplatesRequest,
          NodeTemplateAggregatedList,
          Entry<String, NodeTemplatesScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListNodeTemplatesRequest,
                NodeTemplateAggregatedList,
                Entry<String, NodeTemplatesScopedList>>
            context,
        NodeTemplateAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListNodeTemplatesRequest,
                NodeTemplateAggregatedList,
                Entry<String, NodeTemplatesScopedList>>
            context,
        NodeTemplateAggregatedList response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListNodeTemplatesRequest,
                NodeTemplateAggregatedList,
                Entry<String, NodeTemplatesScopedList>>
            context,
        ApiFuture<NodeTemplateAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListNodeTemplatesRequest,
          NodeTemplateAggregatedList,
          Entry<String, NodeTemplatesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    private AggregatedListFixedSizeCollection(List<AggregatedListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListFixedSizeCollection createEmptyCollection() {
      return new AggregatedListFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListFixedSizeCollection createCollection(
        List<AggregatedListPage> pages, int collectionSize) {
      return new AggregatedListFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListNodeTemplatesRequest,
          NodeTemplateList,
          NodeTemplate,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListNodeTemplatesRequest, NodeTemplateList, NodeTemplate> context,
        ApiFuture<NodeTemplateList> futureResponse) {
      ApiFuture<ListPage> futurePage =
          ListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListPage, ListPagedResponse>() {
            @Override
            public ListPagedResponse apply(ListPage input) {
              return new ListPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListPagedResponse(ListPage page) {
      super(page, ListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPage
      extends AbstractPage<ListNodeTemplatesRequest, NodeTemplateList, NodeTemplate, ListPage> {

    private ListPage(
        PageContext<ListNodeTemplatesRequest, NodeTemplateList, NodeTemplate> context,
        NodeTemplateList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListNodeTemplatesRequest, NodeTemplateList, NodeTemplate> context,
        NodeTemplateList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListNodeTemplatesRequest, NodeTemplateList, NodeTemplate> context,
        ApiFuture<NodeTemplateList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNodeTemplatesRequest,
          NodeTemplateList,
          NodeTemplate,
          ListPage,
          ListFixedSizeCollection> {

    private ListFixedSizeCollection(List<ListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFixedSizeCollection createEmptyCollection() {
      return new ListFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFixedSizeCollection createCollection(List<ListPage> pages, int collectionSize) {
      return new ListFixedSizeCollection(pages, collectionSize);
    }
  }
}
