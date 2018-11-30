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
import com.google.cloud.compute.v1.stub.NodeTemplateStub;
import com.google.cloud.compute.v1.stub.NodeTemplateStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (NodeTemplateClient nodeTemplateClient = NodeTemplateClient.create()) {
 *   ProjectRegionNodeTemplateName nodeTemplate = ProjectRegionNodeTemplateName.of("[PROJECT]", "[REGION]", "[NODE_TEMPLATE]");
 *   Operation response = nodeTemplateClient.deleteNodeTemplate(nodeTemplate);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the nodeTemplateClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of NodeTemplateSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * NodeTemplateSettings nodeTemplateSettings =
 *     NodeTemplateSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NodeTemplateClient nodeTemplateClient =
 *     NodeTemplateClient.create(nodeTemplateSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * NodeTemplateSettings nodeTemplateSettings =
 *     NodeTemplateSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NodeTemplateClient nodeTemplateClient =
 *     NodeTemplateClient.create(nodeTemplateSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class NodeTemplateClient implements BackgroundResource {
  private final NodeTemplateSettings settings;
  private final NodeTemplateStub stub;

  /** Constructs an instance of NodeTemplateClient with default settings. */
  public static final NodeTemplateClient create() throws IOException {
    return create(NodeTemplateSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NodeTemplateClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final NodeTemplateClient create(NodeTemplateSettings settings) throws IOException {
    return new NodeTemplateClient(settings);
  }

  /**
   * Constructs an instance of NodeTemplateClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use NodeTemplateSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final NodeTemplateClient create(NodeTemplateStub stub) {
    return new NodeTemplateClient(stub);
  }

  /**
   * Constructs an instance of NodeTemplateClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected NodeTemplateClient(NodeTemplateSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((NodeTemplateStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected NodeTemplateClient(NodeTemplateStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final NodeTemplateSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public NodeTemplateStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of node templates.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplateClient nodeTemplateClient = NodeTemplateClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (NodeTemplatesScopedList element : nodeTemplateClient.aggregatedListNodeTemplates(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListNodeTemplatesPagedResponse aggregatedListNodeTemplates(
      ProjectName project) {
    AggregatedListNodeTemplatesHttpRequest request =
        AggregatedListNodeTemplatesHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListNodeTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of node templates.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplateClient nodeTemplateClient = NodeTemplateClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (NodeTemplatesScopedList element : nodeTemplateClient.aggregatedListNodeTemplates(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListNodeTemplatesPagedResponse aggregatedListNodeTemplates(
      String project) {
    AggregatedListNodeTemplatesHttpRequest request =
        AggregatedListNodeTemplatesHttpRequest.newBuilder().setProject(project).build();
    return aggregatedListNodeTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of node templates.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplateClient nodeTemplateClient = NodeTemplateClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListNodeTemplatesHttpRequest request = AggregatedListNodeTemplatesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (NodeTemplatesScopedList element : nodeTemplateClient.aggregatedListNodeTemplates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListNodeTemplatesPagedResponse aggregatedListNodeTemplates(
      AggregatedListNodeTemplatesHttpRequest request) {
    return aggregatedListNodeTemplatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of node templates.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplateClient nodeTemplateClient = NodeTemplateClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListNodeTemplatesHttpRequest request = AggregatedListNodeTemplatesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;AggregatedListNodeTemplatesPagedResponse&gt; future = nodeTemplateClient.aggregatedListNodeTemplatesPagedCallable().futureCall(request);
   *   // Do something
   *   for (NodeTemplatesScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListNodeTemplatesHttpRequest, AggregatedListNodeTemplatesPagedResponse>
      aggregatedListNodeTemplatesPagedCallable() {
    return stub.aggregatedListNodeTemplatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of node templates.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplateClient nodeTemplateClient = NodeTemplateClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListNodeTemplatesHttpRequest request = AggregatedListNodeTemplatesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     NodeTemplateAggregatedList response = nodeTemplateClient.aggregatedListNodeTemplatesCallable().call(request);
   *     for (NodeTemplatesScopedList element : response.getItemsMap()) {
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
  @BetaApi
  public final UnaryCallable<AggregatedListNodeTemplatesHttpRequest, NodeTemplateAggregatedList>
      aggregatedListNodeTemplatesCallable() {
    return stub.aggregatedListNodeTemplatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified NodeTemplate resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplateClient nodeTemplateClient = NodeTemplateClient.create()) {
   *   ProjectRegionNodeTemplateName nodeTemplate = ProjectRegionNodeTemplateName.of("[PROJECT]", "[REGION]", "[NODE_TEMPLATE]");
   *   Operation response = nodeTemplateClient.deleteNodeTemplate(nodeTemplate);
   * }
   * </code></pre>
   *
   * @param nodeTemplate Name of the NodeTemplate resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteNodeTemplate(ProjectRegionNodeTemplateName nodeTemplate) {

    DeleteNodeTemplateHttpRequest request =
        DeleteNodeTemplateHttpRequest.newBuilder()
            .setNodeTemplate(nodeTemplate == null ? null : nodeTemplate.toString())
            .build();
    return deleteNodeTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified NodeTemplate resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplateClient nodeTemplateClient = NodeTemplateClient.create()) {
   *   ProjectRegionNodeTemplateName nodeTemplate = ProjectRegionNodeTemplateName.of("[PROJECT]", "[REGION]", "[NODE_TEMPLATE]");
   *   Operation response = nodeTemplateClient.deleteNodeTemplate(nodeTemplate.toString());
   * }
   * </code></pre>
   *
   * @param nodeTemplate Name of the NodeTemplate resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteNodeTemplate(String nodeTemplate) {

    DeleteNodeTemplateHttpRequest request =
        DeleteNodeTemplateHttpRequest.newBuilder().setNodeTemplate(nodeTemplate).build();
    return deleteNodeTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified NodeTemplate resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplateClient nodeTemplateClient = NodeTemplateClient.create()) {
   *   ProjectRegionNodeTemplateName nodeTemplate = ProjectRegionNodeTemplateName.of("[PROJECT]", "[REGION]", "[NODE_TEMPLATE]");
   *   DeleteNodeTemplateHttpRequest request = DeleteNodeTemplateHttpRequest.newBuilder()
   *     .setNodeTemplate(nodeTemplate.toString())
   *     .build();
   *   Operation response = nodeTemplateClient.deleteNodeTemplate(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteNodeTemplate(DeleteNodeTemplateHttpRequest request) {
    return deleteNodeTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified NodeTemplate resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplateClient nodeTemplateClient = NodeTemplateClient.create()) {
   *   ProjectRegionNodeTemplateName nodeTemplate = ProjectRegionNodeTemplateName.of("[PROJECT]", "[REGION]", "[NODE_TEMPLATE]");
   *   DeleteNodeTemplateHttpRequest request = DeleteNodeTemplateHttpRequest.newBuilder()
   *     .setNodeTemplate(nodeTemplate.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = nodeTemplateClient.deleteNodeTemplateCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteNodeTemplateHttpRequest, Operation>
      deleteNodeTemplateCallable() {
    return stub.deleteNodeTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified node template. Gets a list of available node templates by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplateClient nodeTemplateClient = NodeTemplateClient.create()) {
   *   ProjectRegionNodeTemplateName nodeTemplate = ProjectRegionNodeTemplateName.of("[PROJECT]", "[REGION]", "[NODE_TEMPLATE]");
   *   NodeTemplate response = nodeTemplateClient.getNodeTemplate(nodeTemplate);
   * }
   * </code></pre>
   *
   * @param nodeTemplate Name of the node template to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final NodeTemplate getNodeTemplate(ProjectRegionNodeTemplateName nodeTemplate) {

    GetNodeTemplateHttpRequest request =
        GetNodeTemplateHttpRequest.newBuilder()
            .setNodeTemplate(nodeTemplate == null ? null : nodeTemplate.toString())
            .build();
    return getNodeTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified node template. Gets a list of available node templates by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplateClient nodeTemplateClient = NodeTemplateClient.create()) {
   *   ProjectRegionNodeTemplateName nodeTemplate = ProjectRegionNodeTemplateName.of("[PROJECT]", "[REGION]", "[NODE_TEMPLATE]");
   *   NodeTemplate response = nodeTemplateClient.getNodeTemplate(nodeTemplate.toString());
   * }
   * </code></pre>
   *
   * @param nodeTemplate Name of the node template to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final NodeTemplate getNodeTemplate(String nodeTemplate) {

    GetNodeTemplateHttpRequest request =
        GetNodeTemplateHttpRequest.newBuilder().setNodeTemplate(nodeTemplate).build();
    return getNodeTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified node template. Gets a list of available node templates by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplateClient nodeTemplateClient = NodeTemplateClient.create()) {
   *   ProjectRegionNodeTemplateName nodeTemplate = ProjectRegionNodeTemplateName.of("[PROJECT]", "[REGION]", "[NODE_TEMPLATE]");
   *   GetNodeTemplateHttpRequest request = GetNodeTemplateHttpRequest.newBuilder()
   *     .setNodeTemplate(nodeTemplate.toString())
   *     .build();
   *   NodeTemplate response = nodeTemplateClient.getNodeTemplate(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final NodeTemplate getNodeTemplate(GetNodeTemplateHttpRequest request) {
    return getNodeTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified node template. Gets a list of available node templates by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplateClient nodeTemplateClient = NodeTemplateClient.create()) {
   *   ProjectRegionNodeTemplateName nodeTemplate = ProjectRegionNodeTemplateName.of("[PROJECT]", "[REGION]", "[NODE_TEMPLATE]");
   *   GetNodeTemplateHttpRequest request = GetNodeTemplateHttpRequest.newBuilder()
   *     .setNodeTemplate(nodeTemplate.toString())
   *     .build();
   *   ApiFuture&lt;NodeTemplate&gt; future = nodeTemplateClient.getNodeTemplateCallable().futureCall(request);
   *   // Do something
   *   NodeTemplate response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetNodeTemplateHttpRequest, NodeTemplate> getNodeTemplateCallable() {
    return stub.getNodeTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a NodeTemplate resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplateClient nodeTemplateClient = NodeTemplateClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   NodeTemplate nodeTemplateResource = NodeTemplate.newBuilder().build();
   *   Operation response = nodeTemplateClient.insertNodeTemplate(region, nodeTemplateResource);
   * }
   * </code></pre>
   *
   * @param region The name of the region for this request.
   * @param nodeTemplateResource A Node Template resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertNodeTemplate(
      ProjectRegionName region, NodeTemplate nodeTemplateResource) {

    InsertNodeTemplateHttpRequest request =
        InsertNodeTemplateHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .setNodeTemplateResource(nodeTemplateResource)
            .build();
    return insertNodeTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a NodeTemplate resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplateClient nodeTemplateClient = NodeTemplateClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   NodeTemplate nodeTemplateResource = NodeTemplate.newBuilder().build();
   *   Operation response = nodeTemplateClient.insertNodeTemplate(region.toString(), nodeTemplateResource);
   * }
   * </code></pre>
   *
   * @param region The name of the region for this request.
   * @param nodeTemplateResource A Node Template resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertNodeTemplate(String region, NodeTemplate nodeTemplateResource) {

    InsertNodeTemplateHttpRequest request =
        InsertNodeTemplateHttpRequest.newBuilder()
            .setRegion(region)
            .setNodeTemplateResource(nodeTemplateResource)
            .build();
    return insertNodeTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a NodeTemplate resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplateClient nodeTemplateClient = NodeTemplateClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   NodeTemplate nodeTemplateResource = NodeTemplate.newBuilder().build();
   *   InsertNodeTemplateHttpRequest request = InsertNodeTemplateHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .setNodeTemplateResource(nodeTemplateResource)
   *     .build();
   *   Operation response = nodeTemplateClient.insertNodeTemplate(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertNodeTemplate(InsertNodeTemplateHttpRequest request) {
    return insertNodeTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a NodeTemplate resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplateClient nodeTemplateClient = NodeTemplateClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   NodeTemplate nodeTemplateResource = NodeTemplate.newBuilder().build();
   *   InsertNodeTemplateHttpRequest request = InsertNodeTemplateHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .setNodeTemplateResource(nodeTemplateResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = nodeTemplateClient.insertNodeTemplateCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertNodeTemplateHttpRequest, Operation>
      insertNodeTemplateCallable() {
    return stub.insertNodeTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of node templates available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplateClient nodeTemplateClient = NodeTemplateClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (NodeTemplate element : nodeTemplateClient.listNodeTemplates(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region The name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListNodeTemplatesPagedResponse listNodeTemplates(ProjectRegionName region) {
    ListNodeTemplatesHttpRequest request =
        ListNodeTemplatesHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listNodeTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of node templates available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplateClient nodeTemplateClient = NodeTemplateClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (NodeTemplate element : nodeTemplateClient.listNodeTemplates(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region The name of the region for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListNodeTemplatesPagedResponse listNodeTemplates(String region) {
    ListNodeTemplatesHttpRequest request =
        ListNodeTemplatesHttpRequest.newBuilder().setRegion(region).build();
    return listNodeTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of node templates available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplateClient nodeTemplateClient = NodeTemplateClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListNodeTemplatesHttpRequest request = ListNodeTemplatesHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   for (NodeTemplate element : nodeTemplateClient.listNodeTemplates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListNodeTemplatesPagedResponse listNodeTemplates(
      ListNodeTemplatesHttpRequest request) {
    return listNodeTemplatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of node templates available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplateClient nodeTemplateClient = NodeTemplateClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListNodeTemplatesHttpRequest request = ListNodeTemplatesHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   ApiFuture&lt;ListNodeTemplatesPagedResponse&gt; future = nodeTemplateClient.listNodeTemplatesPagedCallable().futureCall(request);
   *   // Do something
   *   for (NodeTemplate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListNodeTemplatesHttpRequest, ListNodeTemplatesPagedResponse>
      listNodeTemplatesPagedCallable() {
    return stub.listNodeTemplatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of node templates available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTemplateClient nodeTemplateClient = NodeTemplateClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   ListNodeTemplatesHttpRequest request = ListNodeTemplatesHttpRequest.newBuilder()
   *     .setRegion(region.toString())
   *     .build();
   *   while (true) {
   *     NodeTemplateList response = nodeTemplateClient.listNodeTemplatesCallable().call(request);
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
  @BetaApi
  public final UnaryCallable<ListNodeTemplatesHttpRequest, NodeTemplateList>
      listNodeTemplatesCallable() {
    return stub.listNodeTemplatesCallable();
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

  public static class AggregatedListNodeTemplatesPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListNodeTemplatesHttpRequest,
          NodeTemplateAggregatedList,
          NodeTemplatesScopedList,
          AggregatedListNodeTemplatesPage,
          AggregatedListNodeTemplatesFixedSizeCollection> {

    public static ApiFuture<AggregatedListNodeTemplatesPagedResponse> createAsync(
        PageContext<
                AggregatedListNodeTemplatesHttpRequest,
                NodeTemplateAggregatedList,
                NodeTemplatesScopedList>
            context,
        ApiFuture<NodeTemplateAggregatedList> futureResponse) {
      ApiFuture<AggregatedListNodeTemplatesPage> futurePage =
          AggregatedListNodeTemplatesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              AggregatedListNodeTemplatesPage, AggregatedListNodeTemplatesPagedResponse>() {
            @Override
            public AggregatedListNodeTemplatesPagedResponse apply(
                AggregatedListNodeTemplatesPage input) {
              return new AggregatedListNodeTemplatesPagedResponse(input);
            }
          });
    }

    private AggregatedListNodeTemplatesPagedResponse(AggregatedListNodeTemplatesPage page) {
      super(page, AggregatedListNodeTemplatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListNodeTemplatesPage
      extends AbstractPage<
          AggregatedListNodeTemplatesHttpRequest,
          NodeTemplateAggregatedList,
          NodeTemplatesScopedList,
          AggregatedListNodeTemplatesPage> {

    private AggregatedListNodeTemplatesPage(
        PageContext<
                AggregatedListNodeTemplatesHttpRequest,
                NodeTemplateAggregatedList,
                NodeTemplatesScopedList>
            context,
        NodeTemplateAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListNodeTemplatesPage createEmptyPage() {
      return new AggregatedListNodeTemplatesPage(null, null);
    }

    @Override
    protected AggregatedListNodeTemplatesPage createPage(
        PageContext<
                AggregatedListNodeTemplatesHttpRequest,
                NodeTemplateAggregatedList,
                NodeTemplatesScopedList>
            context,
        NodeTemplateAggregatedList response) {
      return new AggregatedListNodeTemplatesPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListNodeTemplatesPage> createPageAsync(
        PageContext<
                AggregatedListNodeTemplatesHttpRequest,
                NodeTemplateAggregatedList,
                NodeTemplatesScopedList>
            context,
        ApiFuture<NodeTemplateAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListNodeTemplatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListNodeTemplatesHttpRequest,
          NodeTemplateAggregatedList,
          NodeTemplatesScopedList,
          AggregatedListNodeTemplatesPage,
          AggregatedListNodeTemplatesFixedSizeCollection> {

    private AggregatedListNodeTemplatesFixedSizeCollection(
        List<AggregatedListNodeTemplatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListNodeTemplatesFixedSizeCollection createEmptyCollection() {
      return new AggregatedListNodeTemplatesFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListNodeTemplatesFixedSizeCollection createCollection(
        List<AggregatedListNodeTemplatesPage> pages, int collectionSize) {
      return new AggregatedListNodeTemplatesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNodeTemplatesPagedResponse
      extends AbstractPagedListResponse<
          ListNodeTemplatesHttpRequest,
          NodeTemplateList,
          NodeTemplate,
          ListNodeTemplatesPage,
          ListNodeTemplatesFixedSizeCollection> {

    public static ApiFuture<ListNodeTemplatesPagedResponse> createAsync(
        PageContext<ListNodeTemplatesHttpRequest, NodeTemplateList, NodeTemplate> context,
        ApiFuture<NodeTemplateList> futureResponse) {
      ApiFuture<ListNodeTemplatesPage> futurePage =
          ListNodeTemplatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListNodeTemplatesPage, ListNodeTemplatesPagedResponse>() {
            @Override
            public ListNodeTemplatesPagedResponse apply(ListNodeTemplatesPage input) {
              return new ListNodeTemplatesPagedResponse(input);
            }
          });
    }

    private ListNodeTemplatesPagedResponse(ListNodeTemplatesPage page) {
      super(page, ListNodeTemplatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNodeTemplatesPage
      extends AbstractPage<
          ListNodeTemplatesHttpRequest, NodeTemplateList, NodeTemplate, ListNodeTemplatesPage> {

    private ListNodeTemplatesPage(
        PageContext<ListNodeTemplatesHttpRequest, NodeTemplateList, NodeTemplate> context,
        NodeTemplateList response) {
      super(context, response);
    }

    private static ListNodeTemplatesPage createEmptyPage() {
      return new ListNodeTemplatesPage(null, null);
    }

    @Override
    protected ListNodeTemplatesPage createPage(
        PageContext<ListNodeTemplatesHttpRequest, NodeTemplateList, NodeTemplate> context,
        NodeTemplateList response) {
      return new ListNodeTemplatesPage(context, response);
    }

    @Override
    public ApiFuture<ListNodeTemplatesPage> createPageAsync(
        PageContext<ListNodeTemplatesHttpRequest, NodeTemplateList, NodeTemplate> context,
        ApiFuture<NodeTemplateList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNodeTemplatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNodeTemplatesHttpRequest,
          NodeTemplateList,
          NodeTemplate,
          ListNodeTemplatesPage,
          ListNodeTemplatesFixedSizeCollection> {

    private ListNodeTemplatesFixedSizeCollection(
        List<ListNodeTemplatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNodeTemplatesFixedSizeCollection createEmptyCollection() {
      return new ListNodeTemplatesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNodeTemplatesFixedSizeCollection createCollection(
        List<ListNodeTemplatesPage> pages, int collectionSize) {
      return new ListNodeTemplatesFixedSizeCollection(pages, collectionSize);
    }
  }
}
