/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.apiregistry.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apiregistry.v1.stub.CloudApiRegistryStub;
import com.google.cloud.apiregistry.v1.stub.CloudApiRegistryStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Cloud API Registry service provides a central registry for managing API
 * Data.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
 *   McpServerName name =
 *       McpServerName.ofProjectLocationMcpServerName("[PROJECT]", "[LOCATION]", "[MCP_SERVER]");
 *   McpServer response = cloudApiRegistryClient.getMcpServer(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CloudApiRegistryClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetMcpServer</td>
 *      <td><p> Gets a single McpServer.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMcpServer(GetMcpServerRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMcpServer(McpServerName name)
 *           <li><p> getMcpServer(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMcpServerCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMcpServers</td>
 *      <td><p> Lists McpServers in a given Project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMcpServers(ListMcpServersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMcpServers(LocationName parent)
 *           <li><p> listMcpServers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMcpServersPagedCallable()
 *           <li><p> listMcpServersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetMcpTool</td>
 *      <td><p> Gets a single McpTool.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMcpTool(GetMcpToolRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMcpTool(McpToolName name)
 *           <li><p> getMcpTool(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMcpToolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMcpTools</td>
 *      <td><p> Lists McpTools in a given McpServer.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMcpTools(ListMcpToolsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMcpTools(McpServerName parent)
 *           <li><p> listMcpTools(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMcpToolsPagedCallable()
 *           <li><p> listMcpToolsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocationsPagedCallable()
 *           <li><p> listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of CloudApiRegistrySettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudApiRegistrySettings cloudApiRegistrySettings =
 *     CloudApiRegistrySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CloudApiRegistryClient cloudApiRegistryClient =
 *     CloudApiRegistryClient.create(cloudApiRegistrySettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudApiRegistrySettings cloudApiRegistrySettings =
 *     CloudApiRegistrySettings.newBuilder().setEndpoint(myEndpoint).build();
 * CloudApiRegistryClient cloudApiRegistryClient =
 *     CloudApiRegistryClient.create(cloudApiRegistrySettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudApiRegistrySettings cloudApiRegistrySettings =
 *     CloudApiRegistrySettings.newHttpJsonBuilder().build();
 * CloudApiRegistryClient cloudApiRegistryClient =
 *     CloudApiRegistryClient.create(cloudApiRegistrySettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CloudApiRegistryClient implements BackgroundResource {
  private final CloudApiRegistrySettings settings;
  private final CloudApiRegistryStub stub;

  /** Constructs an instance of CloudApiRegistryClient with default settings. */
  public static final CloudApiRegistryClient create() throws IOException {
    return create(CloudApiRegistrySettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CloudApiRegistryClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CloudApiRegistryClient create(CloudApiRegistrySettings settings)
      throws IOException {
    return new CloudApiRegistryClient(settings);
  }

  /**
   * Constructs an instance of CloudApiRegistryClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(CloudApiRegistrySettings).
   */
  public static final CloudApiRegistryClient create(CloudApiRegistryStub stub) {
    return new CloudApiRegistryClient(stub);
  }

  /**
   * Constructs an instance of CloudApiRegistryClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CloudApiRegistryClient(CloudApiRegistrySettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CloudApiRegistryStubSettings) settings.getStubSettings()).createStub();
  }

  protected CloudApiRegistryClient(CloudApiRegistryStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CloudApiRegistrySettings getSettings() {
    return settings;
  }

  public CloudApiRegistryStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single McpServer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
   *   McpServerName name =
   *       McpServerName.ofProjectLocationMcpServerName("[PROJECT]", "[LOCATION]", "[MCP_SERVER]");
   *   McpServer response = cloudApiRegistryClient.getMcpServer(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource Format:
   *     projects/{project}/locations/{location}/mcpServers/{mcp_server}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final McpServer getMcpServer(McpServerName name) {
    GetMcpServerRequest request =
        GetMcpServerRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getMcpServer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single McpServer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
   *   String name =
   *       McpServerName.ofProjectLocationApiNamespaceMcpServerName(
   *               "[PROJECT]", "[LOCATION]", "[API_NAMESPACE]", "[MCP_SERVER]")
   *           .toString();
   *   McpServer response = cloudApiRegistryClient.getMcpServer(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource Format:
   *     projects/{project}/locations/{location}/mcpServers/{mcp_server}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final McpServer getMcpServer(String name) {
    GetMcpServerRequest request = GetMcpServerRequest.newBuilder().setName(name).build();
    return getMcpServer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single McpServer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
   *   GetMcpServerRequest request =
   *       GetMcpServerRequest.newBuilder()
   *           .setName(
   *               McpServerName.ofProjectLocationMcpServerName(
   *                       "[PROJECT]", "[LOCATION]", "[MCP_SERVER]")
   *                   .toString())
   *           .build();
   *   McpServer response = cloudApiRegistryClient.getMcpServer(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final McpServer getMcpServer(GetMcpServerRequest request) {
    return getMcpServerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single McpServer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
   *   GetMcpServerRequest request =
   *       GetMcpServerRequest.newBuilder()
   *           .setName(
   *               McpServerName.ofProjectLocationMcpServerName(
   *                       "[PROJECT]", "[LOCATION]", "[MCP_SERVER]")
   *                   .toString())
   *           .build();
   *   ApiFuture<McpServer> future =
   *       cloudApiRegistryClient.getMcpServerCallable().futureCall(request);
   *   // Do something.
   *   McpServer response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMcpServerRequest, McpServer> getMcpServerCallable() {
    return stub.getMcpServerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists McpServers in a given Project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (McpServer element : cloudApiRegistryClient.listMcpServers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListMcpServersRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMcpServersPagedResponse listMcpServers(LocationName parent) {
    ListMcpServersRequest request =
        ListMcpServersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMcpServers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists McpServers in a given Project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (McpServer element : cloudApiRegistryClient.listMcpServers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListMcpServersRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMcpServersPagedResponse listMcpServers(String parent) {
    ListMcpServersRequest request = ListMcpServersRequest.newBuilder().setParent(parent).build();
    return listMcpServers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists McpServers in a given Project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
   *   ListMcpServersRequest request =
   *       ListMcpServersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (McpServer element : cloudApiRegistryClient.listMcpServers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMcpServersPagedResponse listMcpServers(ListMcpServersRequest request) {
    return listMcpServersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists McpServers in a given Project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
   *   ListMcpServersRequest request =
   *       ListMcpServersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<McpServer> future =
   *       cloudApiRegistryClient.listMcpServersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (McpServer element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMcpServersRequest, ListMcpServersPagedResponse>
      listMcpServersPagedCallable() {
    return stub.listMcpServersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists McpServers in a given Project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
   *   ListMcpServersRequest request =
   *       ListMcpServersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListMcpServersResponse response =
   *         cloudApiRegistryClient.listMcpServersCallable().call(request);
   *     for (McpServer element : response.getMcpServersList()) {
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
   * }</pre>
   */
  public final UnaryCallable<ListMcpServersRequest, ListMcpServersResponse>
      listMcpServersCallable() {
    return stub.listMcpServersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single McpTool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
   *   McpToolName name =
   *       McpToolName.ofProjectLocationMcpServerMcpToolName(
   *           "[PROJECT]", "[LOCATION]", "[MCP_SERVER]", "[MCP_TOOL]");
   *   McpTool response = cloudApiRegistryClient.getMcpTool(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource Format:
   *     projects/{project}/locations/{location}/mcpServers/{mcp_server}/mcpTools/{mcp_tool}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final McpTool getMcpTool(McpToolName name) {
    GetMcpToolRequest request =
        GetMcpToolRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getMcpTool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single McpTool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
   *   String name =
   *       McpToolName.ofProjectLocationApiNamespaceMcpServerMcpToolName(
   *               "[PROJECT]", "[LOCATION]", "[API_NAMESPACE]", "[MCP_SERVER]", "[MCP_TOOL]")
   *           .toString();
   *   McpTool response = cloudApiRegistryClient.getMcpTool(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource Format:
   *     projects/{project}/locations/{location}/mcpServers/{mcp_server}/mcpTools/{mcp_tool}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final McpTool getMcpTool(String name) {
    GetMcpToolRequest request = GetMcpToolRequest.newBuilder().setName(name).build();
    return getMcpTool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single McpTool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
   *   GetMcpToolRequest request =
   *       GetMcpToolRequest.newBuilder()
   *           .setName(
   *               McpToolName.ofProjectLocationMcpServerMcpToolName(
   *                       "[PROJECT]", "[LOCATION]", "[MCP_SERVER]", "[MCP_TOOL]")
   *                   .toString())
   *           .build();
   *   McpTool response = cloudApiRegistryClient.getMcpTool(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final McpTool getMcpTool(GetMcpToolRequest request) {
    return getMcpToolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single McpTool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
   *   GetMcpToolRequest request =
   *       GetMcpToolRequest.newBuilder()
   *           .setName(
   *               McpToolName.ofProjectLocationMcpServerMcpToolName(
   *                       "[PROJECT]", "[LOCATION]", "[MCP_SERVER]", "[MCP_TOOL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<McpTool> future = cloudApiRegistryClient.getMcpToolCallable().futureCall(request);
   *   // Do something.
   *   McpTool response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMcpToolRequest, McpTool> getMcpToolCallable() {
    return stub.getMcpToolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists McpTools in a given McpServer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
   *   McpServerName parent =
   *       McpServerName.ofProjectLocationMcpServerName("[PROJECT]", "[LOCATION]", "[MCP_SERVER]");
   *   for (McpTool element : cloudApiRegistryClient.listMcpTools(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListMcpToolsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMcpToolsPagedResponse listMcpTools(McpServerName parent) {
    ListMcpToolsRequest request =
        ListMcpToolsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMcpTools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists McpTools in a given McpServer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
   *   String parent =
   *       McpServerName.ofProjectLocationApiNamespaceMcpServerName(
   *               "[PROJECT]", "[LOCATION]", "[API_NAMESPACE]", "[MCP_SERVER]")
   *           .toString();
   *   for (McpTool element : cloudApiRegistryClient.listMcpTools(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListMcpToolsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMcpToolsPagedResponse listMcpTools(String parent) {
    ListMcpToolsRequest request = ListMcpToolsRequest.newBuilder().setParent(parent).build();
    return listMcpTools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists McpTools in a given McpServer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
   *   ListMcpToolsRequest request =
   *       ListMcpToolsRequest.newBuilder()
   *           .setParent(
   *               McpServerName.ofProjectLocationMcpServerName(
   *                       "[PROJECT]", "[LOCATION]", "[MCP_SERVER]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (McpTool element : cloudApiRegistryClient.listMcpTools(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMcpToolsPagedResponse listMcpTools(ListMcpToolsRequest request) {
    return listMcpToolsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists McpTools in a given McpServer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
   *   ListMcpToolsRequest request =
   *       ListMcpToolsRequest.newBuilder()
   *           .setParent(
   *               McpServerName.ofProjectLocationMcpServerName(
   *                       "[PROJECT]", "[LOCATION]", "[MCP_SERVER]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<McpTool> future =
   *       cloudApiRegistryClient.listMcpToolsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (McpTool element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMcpToolsRequest, ListMcpToolsPagedResponse>
      listMcpToolsPagedCallable() {
    return stub.listMcpToolsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists McpTools in a given McpServer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
   *   ListMcpToolsRequest request =
   *       ListMcpToolsRequest.newBuilder()
   *           .setParent(
   *               McpServerName.ofProjectLocationMcpServerName(
   *                       "[PROJECT]", "[LOCATION]", "[MCP_SERVER]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListMcpToolsResponse response = cloudApiRegistryClient.listMcpToolsCallable().call(request);
   *     for (McpTool element : response.getMcpToolsList()) {
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
   * }</pre>
   */
  public final UnaryCallable<ListMcpToolsRequest, ListMcpToolsResponse> listMcpToolsCallable() {
    return stub.listMcpToolsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : cloudApiRegistryClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       cloudApiRegistryClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         cloudApiRegistryClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
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
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = cloudApiRegistryClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = cloudApiRegistryClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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

  public static class ListMcpServersPagedResponse
      extends AbstractPagedListResponse<
          ListMcpServersRequest,
          ListMcpServersResponse,
          McpServer,
          ListMcpServersPage,
          ListMcpServersFixedSizeCollection> {

    public static ApiFuture<ListMcpServersPagedResponse> createAsync(
        PageContext<ListMcpServersRequest, ListMcpServersResponse, McpServer> context,
        ApiFuture<ListMcpServersResponse> futureResponse) {
      ApiFuture<ListMcpServersPage> futurePage =
          ListMcpServersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMcpServersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMcpServersPagedResponse(ListMcpServersPage page) {
      super(page, ListMcpServersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMcpServersPage
      extends AbstractPage<
          ListMcpServersRequest, ListMcpServersResponse, McpServer, ListMcpServersPage> {

    private ListMcpServersPage(
        PageContext<ListMcpServersRequest, ListMcpServersResponse, McpServer> context,
        ListMcpServersResponse response) {
      super(context, response);
    }

    private static ListMcpServersPage createEmptyPage() {
      return new ListMcpServersPage(null, null);
    }

    @Override
    protected ListMcpServersPage createPage(
        PageContext<ListMcpServersRequest, ListMcpServersResponse, McpServer> context,
        ListMcpServersResponse response) {
      return new ListMcpServersPage(context, response);
    }

    @Override
    public ApiFuture<ListMcpServersPage> createPageAsync(
        PageContext<ListMcpServersRequest, ListMcpServersResponse, McpServer> context,
        ApiFuture<ListMcpServersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMcpServersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMcpServersRequest,
          ListMcpServersResponse,
          McpServer,
          ListMcpServersPage,
          ListMcpServersFixedSizeCollection> {

    private ListMcpServersFixedSizeCollection(List<ListMcpServersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMcpServersFixedSizeCollection createEmptyCollection() {
      return new ListMcpServersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMcpServersFixedSizeCollection createCollection(
        List<ListMcpServersPage> pages, int collectionSize) {
      return new ListMcpServersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMcpToolsPagedResponse
      extends AbstractPagedListResponse<
          ListMcpToolsRequest,
          ListMcpToolsResponse,
          McpTool,
          ListMcpToolsPage,
          ListMcpToolsFixedSizeCollection> {

    public static ApiFuture<ListMcpToolsPagedResponse> createAsync(
        PageContext<ListMcpToolsRequest, ListMcpToolsResponse, McpTool> context,
        ApiFuture<ListMcpToolsResponse> futureResponse) {
      ApiFuture<ListMcpToolsPage> futurePage =
          ListMcpToolsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMcpToolsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMcpToolsPagedResponse(ListMcpToolsPage page) {
      super(page, ListMcpToolsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMcpToolsPage
      extends AbstractPage<ListMcpToolsRequest, ListMcpToolsResponse, McpTool, ListMcpToolsPage> {

    private ListMcpToolsPage(
        PageContext<ListMcpToolsRequest, ListMcpToolsResponse, McpTool> context,
        ListMcpToolsResponse response) {
      super(context, response);
    }

    private static ListMcpToolsPage createEmptyPage() {
      return new ListMcpToolsPage(null, null);
    }

    @Override
    protected ListMcpToolsPage createPage(
        PageContext<ListMcpToolsRequest, ListMcpToolsResponse, McpTool> context,
        ListMcpToolsResponse response) {
      return new ListMcpToolsPage(context, response);
    }

    @Override
    public ApiFuture<ListMcpToolsPage> createPageAsync(
        PageContext<ListMcpToolsRequest, ListMcpToolsResponse, McpTool> context,
        ApiFuture<ListMcpToolsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMcpToolsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMcpToolsRequest,
          ListMcpToolsResponse,
          McpTool,
          ListMcpToolsPage,
          ListMcpToolsFixedSizeCollection> {

    private ListMcpToolsFixedSizeCollection(List<ListMcpToolsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMcpToolsFixedSizeCollection createEmptyCollection() {
      return new ListMcpToolsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMcpToolsFixedSizeCollection createCollection(
        List<ListMcpToolsPage> pages, int collectionSize) {
      return new ListMcpToolsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
