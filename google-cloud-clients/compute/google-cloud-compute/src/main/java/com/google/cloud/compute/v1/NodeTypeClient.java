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
import com.google.cloud.compute.v1.stub.NodeTypeStub;
import com.google.cloud.compute.v1.stub.NodeTypeStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
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
 * try (NodeTypeClient nodeTypeClient = NodeTypeClient.create()) {
 *   ProjectZoneNodeTypeName nodeType = ProjectZoneNodeTypeName.of("[PROJECT]", "[ZONE]", "[NODE_TYPE]");
 *   NodeType response = nodeTypeClient.getNodeType(nodeType);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the nodeTypeClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of NodeTypeSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * NodeTypeSettings nodeTypeSettings =
 *     NodeTypeSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NodeTypeClient nodeTypeClient =
 *     NodeTypeClient.create(nodeTypeSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * NodeTypeSettings nodeTypeSettings =
 *     NodeTypeSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NodeTypeClient nodeTypeClient =
 *     NodeTypeClient.create(nodeTypeSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class NodeTypeClient implements BackgroundResource {
  private final NodeTypeSettings settings;
  private final NodeTypeStub stub;

  /** Constructs an instance of NodeTypeClient with default settings. */
  public static final NodeTypeClient create() throws IOException {
    return create(NodeTypeSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NodeTypeClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final NodeTypeClient create(NodeTypeSettings settings) throws IOException {
    return new NodeTypeClient(settings);
  }

  /**
   * Constructs an instance of NodeTypeClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use NodeTypeSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final NodeTypeClient create(NodeTypeStub stub) {
    return new NodeTypeClient(stub);
  }

  /**
   * Constructs an instance of NodeTypeClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected NodeTypeClient(NodeTypeSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((NodeTypeStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected NodeTypeClient(NodeTypeStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final NodeTypeSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public NodeTypeStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of node types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTypeClient nodeTypeClient = NodeTypeClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (NodeTypesScopedList element : nodeTypeClient.aggregatedListNodeTypes(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListNodeTypesPagedResponse aggregatedListNodeTypes(ProjectName project) {
    AggregatedListNodeTypesHttpRequest request =
        AggregatedListNodeTypesHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListNodeTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of node types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTypeClient nodeTypeClient = NodeTypeClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (NodeTypesScopedList element : nodeTypeClient.aggregatedListNodeTypes(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListNodeTypesPagedResponse aggregatedListNodeTypes(String project) {
    AggregatedListNodeTypesHttpRequest request =
        AggregatedListNodeTypesHttpRequest.newBuilder().setProject(project).build();
    return aggregatedListNodeTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of node types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTypeClient nodeTypeClient = NodeTypeClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListNodeTypesHttpRequest request = AggregatedListNodeTypesHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   for (NodeTypesScopedList element : nodeTypeClient.aggregatedListNodeTypes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListNodeTypesPagedResponse aggregatedListNodeTypes(
      AggregatedListNodeTypesHttpRequest request) {
    return aggregatedListNodeTypesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of node types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTypeClient nodeTypeClient = NodeTypeClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListNodeTypesHttpRequest request = AggregatedListNodeTypesHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   ApiFuture&lt;AggregatedListNodeTypesPagedResponse&gt; future = nodeTypeClient.aggregatedListNodeTypesPagedCallable().futureCall(request);
   *   // Do something
   *   for (NodeTypesScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListNodeTypesHttpRequest, AggregatedListNodeTypesPagedResponse>
      aggregatedListNodeTypesPagedCallable() {
    return stub.aggregatedListNodeTypesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an aggregated list of node types.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTypeClient nodeTypeClient = NodeTypeClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListNodeTypesHttpRequest request = AggregatedListNodeTypesHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   while (true) {
   *     NodeTypeAggregatedList response = nodeTypeClient.aggregatedListNodeTypesCallable().call(request);
   *     for (NodeTypesScopedList element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListNodeTypesHttpRequest, NodeTypeAggregatedList>
      aggregatedListNodeTypesCallable() {
    return stub.aggregatedListNodeTypesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified node type. Gets a list of available node types by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTypeClient nodeTypeClient = NodeTypeClient.create()) {
   *   ProjectZoneNodeTypeName nodeType = ProjectZoneNodeTypeName.of("[PROJECT]", "[ZONE]", "[NODE_TYPE]");
   *   NodeType response = nodeTypeClient.getNodeType(nodeType);
   * }
   * </code></pre>
   *
   * @param nodeType Name of the node type to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final NodeType getNodeType(ProjectZoneNodeTypeName nodeType) {

    GetNodeTypeHttpRequest request =
        GetNodeTypeHttpRequest.newBuilder()
            .setNodeType(nodeType == null ? null : nodeType.toString())
            .build();
    return getNodeType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified node type. Gets a list of available node types by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTypeClient nodeTypeClient = NodeTypeClient.create()) {
   *   ProjectZoneNodeTypeName nodeType = ProjectZoneNodeTypeName.of("[PROJECT]", "[ZONE]", "[NODE_TYPE]");
   *   NodeType response = nodeTypeClient.getNodeType(nodeType.toString());
   * }
   * </code></pre>
   *
   * @param nodeType Name of the node type to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final NodeType getNodeType(String nodeType) {

    GetNodeTypeHttpRequest request =
        GetNodeTypeHttpRequest.newBuilder().setNodeType(nodeType).build();
    return getNodeType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified node type. Gets a list of available node types by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTypeClient nodeTypeClient = NodeTypeClient.create()) {
   *   String formattedNodeType = ProjectZoneNodeTypeName.format("[PROJECT]", "[ZONE]", "[NODE_TYPE]");
   *   GetNodeTypeHttpRequest request = GetNodeTypeHttpRequest.newBuilder()
   *     .setNodeType(formattedNodeType)
   *     .build();
   *   NodeType response = nodeTypeClient.getNodeType(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final NodeType getNodeType(GetNodeTypeHttpRequest request) {
    return getNodeTypeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified node type. Gets a list of available node types by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTypeClient nodeTypeClient = NodeTypeClient.create()) {
   *   String formattedNodeType = ProjectZoneNodeTypeName.format("[PROJECT]", "[ZONE]", "[NODE_TYPE]");
   *   GetNodeTypeHttpRequest request = GetNodeTypeHttpRequest.newBuilder()
   *     .setNodeType(formattedNodeType)
   *     .build();
   *   ApiFuture&lt;NodeType&gt; future = nodeTypeClient.getNodeTypeCallable().futureCall(request);
   *   // Do something
   *   NodeType response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetNodeTypeHttpRequest, NodeType> getNodeTypeCallable() {
    return stub.getNodeTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of node types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTypeClient nodeTypeClient = NodeTypeClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (NodeType element : nodeTypeClient.listNodeTypes(zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone The name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListNodeTypesPagedResponse listNodeTypes(ProjectZoneName zone) {
    ListNodeTypesHttpRequest request =
        ListNodeTypesHttpRequest.newBuilder()
            .setZone(zone == null ? null : zone.toString())
            .build();
    return listNodeTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of node types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTypeClient nodeTypeClient = NodeTypeClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (NodeType element : nodeTypeClient.listNodeTypes(zone.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone The name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListNodeTypesPagedResponse listNodeTypes(String zone) {
    ListNodeTypesHttpRequest request = ListNodeTypesHttpRequest.newBuilder().setZone(zone).build();
    return listNodeTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of node types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTypeClient nodeTypeClient = NodeTypeClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   ListNodeTypesHttpRequest request = ListNodeTypesHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .build();
   *   for (NodeType element : nodeTypeClient.listNodeTypes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListNodeTypesPagedResponse listNodeTypes(ListNodeTypesHttpRequest request) {
    return listNodeTypesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of node types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTypeClient nodeTypeClient = NodeTypeClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   ListNodeTypesHttpRequest request = ListNodeTypesHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .build();
   *   ApiFuture&lt;ListNodeTypesPagedResponse&gt; future = nodeTypeClient.listNodeTypesPagedCallable().futureCall(request);
   *   // Do something
   *   for (NodeType element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListNodeTypesHttpRequest, ListNodeTypesPagedResponse>
      listNodeTypesPagedCallable() {
    return stub.listNodeTypesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of node types available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (NodeTypeClient nodeTypeClient = NodeTypeClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   ListNodeTypesHttpRequest request = ListNodeTypesHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .build();
   *   while (true) {
   *     NodeTypeList response = nodeTypeClient.listNodeTypesCallable().call(request);
   *     for (NodeType element : response.getItemsList()) {
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
  public final UnaryCallable<ListNodeTypesHttpRequest, NodeTypeList> listNodeTypesCallable() {
    return stub.listNodeTypesCallable();
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

  public static class AggregatedListNodeTypesPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListNodeTypesHttpRequest,
          NodeTypeAggregatedList,
          NodeTypesScopedList,
          AggregatedListNodeTypesPage,
          AggregatedListNodeTypesFixedSizeCollection> {

    public static ApiFuture<AggregatedListNodeTypesPagedResponse> createAsync(
        PageContext<AggregatedListNodeTypesHttpRequest, NodeTypeAggregatedList, NodeTypesScopedList>
            context,
        ApiFuture<NodeTypeAggregatedList> futureResponse) {
      ApiFuture<AggregatedListNodeTypesPage> futurePage =
          AggregatedListNodeTypesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<AggregatedListNodeTypesPage, AggregatedListNodeTypesPagedResponse>() {
            @Override
            public AggregatedListNodeTypesPagedResponse apply(AggregatedListNodeTypesPage input) {
              return new AggregatedListNodeTypesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private AggregatedListNodeTypesPagedResponse(AggregatedListNodeTypesPage page) {
      super(page, AggregatedListNodeTypesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListNodeTypesPage
      extends AbstractPage<
          AggregatedListNodeTypesHttpRequest,
          NodeTypeAggregatedList,
          NodeTypesScopedList,
          AggregatedListNodeTypesPage> {

    private AggregatedListNodeTypesPage(
        PageContext<AggregatedListNodeTypesHttpRequest, NodeTypeAggregatedList, NodeTypesScopedList>
            context,
        NodeTypeAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListNodeTypesPage createEmptyPage() {
      return new AggregatedListNodeTypesPage(null, null);
    }

    @Override
    protected AggregatedListNodeTypesPage createPage(
        PageContext<AggregatedListNodeTypesHttpRequest, NodeTypeAggregatedList, NodeTypesScopedList>
            context,
        NodeTypeAggregatedList response) {
      return new AggregatedListNodeTypesPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListNodeTypesPage> createPageAsync(
        PageContext<AggregatedListNodeTypesHttpRequest, NodeTypeAggregatedList, NodeTypesScopedList>
            context,
        ApiFuture<NodeTypeAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListNodeTypesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListNodeTypesHttpRequest,
          NodeTypeAggregatedList,
          NodeTypesScopedList,
          AggregatedListNodeTypesPage,
          AggregatedListNodeTypesFixedSizeCollection> {

    private AggregatedListNodeTypesFixedSizeCollection(
        List<AggregatedListNodeTypesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListNodeTypesFixedSizeCollection createEmptyCollection() {
      return new AggregatedListNodeTypesFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListNodeTypesFixedSizeCollection createCollection(
        List<AggregatedListNodeTypesPage> pages, int collectionSize) {
      return new AggregatedListNodeTypesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNodeTypesPagedResponse
      extends AbstractPagedListResponse<
          ListNodeTypesHttpRequest,
          NodeTypeList,
          NodeType,
          ListNodeTypesPage,
          ListNodeTypesFixedSizeCollection> {

    public static ApiFuture<ListNodeTypesPagedResponse> createAsync(
        PageContext<ListNodeTypesHttpRequest, NodeTypeList, NodeType> context,
        ApiFuture<NodeTypeList> futureResponse) {
      ApiFuture<ListNodeTypesPage> futurePage =
          ListNodeTypesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListNodeTypesPage, ListNodeTypesPagedResponse>() {
            @Override
            public ListNodeTypesPagedResponse apply(ListNodeTypesPage input) {
              return new ListNodeTypesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListNodeTypesPagedResponse(ListNodeTypesPage page) {
      super(page, ListNodeTypesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNodeTypesPage
      extends AbstractPage<ListNodeTypesHttpRequest, NodeTypeList, NodeType, ListNodeTypesPage> {

    private ListNodeTypesPage(
        PageContext<ListNodeTypesHttpRequest, NodeTypeList, NodeType> context,
        NodeTypeList response) {
      super(context, response);
    }

    private static ListNodeTypesPage createEmptyPage() {
      return new ListNodeTypesPage(null, null);
    }

    @Override
    protected ListNodeTypesPage createPage(
        PageContext<ListNodeTypesHttpRequest, NodeTypeList, NodeType> context,
        NodeTypeList response) {
      return new ListNodeTypesPage(context, response);
    }

    @Override
    public ApiFuture<ListNodeTypesPage> createPageAsync(
        PageContext<ListNodeTypesHttpRequest, NodeTypeList, NodeType> context,
        ApiFuture<NodeTypeList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNodeTypesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNodeTypesHttpRequest,
          NodeTypeList,
          NodeType,
          ListNodeTypesPage,
          ListNodeTypesFixedSizeCollection> {

    private ListNodeTypesFixedSizeCollection(List<ListNodeTypesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNodeTypesFixedSizeCollection createEmptyCollection() {
      return new ListNodeTypesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNodeTypesFixedSizeCollection createCollection(
        List<ListNodeTypesPage> pages, int collectionSize) {
      return new ListNodeTypesFixedSizeCollection(pages, collectionSize);
    }
  }
}
