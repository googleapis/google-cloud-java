/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.dialogflow.v2beta1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.stub.ToolsStub;
import com.google.cloud.dialogflow.v2beta1.stub.ToolsStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Tool Service for LLM powered Agent Assist. Tools can be used to interact
 * with remote APIs (e.g. fetching orders) to retrieve additional information as input to LLM.
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
 * try (ToolsClient toolsClient = ToolsClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Tool tool = Tool.newBuilder().build();
 *   String toolId = "toolId-868061997";
 *   Tool response = toolsClient.createTool(parent, tool, toolId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ToolsClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTool</td>
 *      <td><p> Creates a tool.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTool(CreateToolRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createTool(LocationName parent, Tool tool, String toolId)
 *           <li><p> createTool(String parent, Tool tool, String toolId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createToolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTool</td>
 *      <td><p> Retrieves a tool.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTool(GetToolRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTool(ToolName name)
 *           <li><p> getTool(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getToolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTools</td>
 *      <td><p> Lists tools.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTools(ListToolsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTools(LocationName parent)
 *           <li><p> listTools(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listToolsPagedCallable()
 *           <li><p> listToolsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteTool</td>
 *      <td><p> Deletes a tool.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteTool(DeleteToolRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteTool(ToolName name)
 *           <li><p> deleteTool(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteToolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTool</td>
 *      <td><p> Updates a tool.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTool(UpdateToolRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateTool(Tool tool, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateToolCallable()
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
 * <p>This class can be customized by passing in a custom instance of ToolsSettings to create(). For
 * example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ToolsSettings toolsSettings =
 *     ToolsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ToolsClient toolsClient = ToolsClient.create(toolsSettings);
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
 * ToolsSettings toolsSettings = ToolsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ToolsClient toolsClient = ToolsClient.create(toolsSettings);
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
 * ToolsSettings toolsSettings = ToolsSettings.newHttpJsonBuilder().build();
 * ToolsClient toolsClient = ToolsClient.create(toolsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ToolsClient implements BackgroundResource {
  private final ToolsSettings settings;
  private final ToolsStub stub;

  /** Constructs an instance of ToolsClient with default settings. */
  public static final ToolsClient create() throws IOException {
    return create(ToolsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ToolsClient, using the given settings. The channels are created based
   * on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ToolsClient create(ToolsSettings settings) throws IOException {
    return new ToolsClient(settings);
  }

  /**
   * Constructs an instance of ToolsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(ToolsSettings).
   */
  public static final ToolsClient create(ToolsStub stub) {
    return new ToolsClient(stub);
  }

  /**
   * Constructs an instance of ToolsClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected ToolsClient(ToolsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ToolsStubSettings) settings.getStubSettings()).createStub();
  }

  protected ToolsClient(ToolsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ToolsSettings getSettings() {
    return settings;
  }

  public ToolsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Tool tool = Tool.newBuilder().build();
   *   String toolId = "toolId-868061997";
   *   Tool response = toolsClient.createTool(parent, tool, toolId);
   * }
   * }</pre>
   *
   * @param parent Required. The project/location to create tool for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;`
   * @param tool Required. The tool to create.
   * @param toolId Optional. The ID to use for the tool, which will become the final component of
   *     the tool's resource name.
   *     <p>The tool ID must be compliant with the regression formula `[a-zA-Z][a-zA-Z0-9_-]&#42;`
   *     with the characters length in range of [3,64]. If the field is not provide, an Id will be
   *     auto-generated. If the field is provided, the caller is responsible for 1. the uniqueness
   *     of the ID, otherwise the request will be rejected. 2. the consistency for whether to use
   *     custom ID or not under a project to better ensure uniqueness.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tool createTool(LocationName parent, Tool tool, String toolId) {
    CreateToolRequest request =
        CreateToolRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTool(tool)
            .setToolId(toolId)
            .build();
    return createTool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Tool tool = Tool.newBuilder().build();
   *   String toolId = "toolId-868061997";
   *   Tool response = toolsClient.createTool(parent, tool, toolId);
   * }
   * }</pre>
   *
   * @param parent Required. The project/location to create tool for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;`
   * @param tool Required. The tool to create.
   * @param toolId Optional. The ID to use for the tool, which will become the final component of
   *     the tool's resource name.
   *     <p>The tool ID must be compliant with the regression formula `[a-zA-Z][a-zA-Z0-9_-]&#42;`
   *     with the characters length in range of [3,64]. If the field is not provide, an Id will be
   *     auto-generated. If the field is provided, the caller is responsible for 1. the uniqueness
   *     of the ID, otherwise the request will be rejected. 2. the consistency for whether to use
   *     custom ID or not under a project to better ensure uniqueness.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tool createTool(String parent, Tool tool, String toolId) {
    CreateToolRequest request =
        CreateToolRequest.newBuilder().setParent(parent).setTool(tool).setToolId(toolId).build();
    return createTool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   CreateToolRequest request =
   *       CreateToolRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTool(Tool.newBuilder().build())
   *           .setToolId("toolId-868061997")
   *           .build();
   *   Tool response = toolsClient.createTool(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tool createTool(CreateToolRequest request) {
    return createToolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   CreateToolRequest request =
   *       CreateToolRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTool(Tool.newBuilder().build())
   *           .setToolId("toolId-868061997")
   *           .build();
   *   ApiFuture<Tool> future = toolsClient.createToolCallable().futureCall(request);
   *   // Do something.
   *   Tool response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateToolRequest, Tool> createToolCallable() {
    return stub.createToolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   ToolName name = ToolName.of("[PROJECT]", "[LOCATION]", "[TOOL]");
   *   Tool response = toolsClient.getTool(name);
   * }
   * }</pre>
   *
   * @param name Required. The tool resource name to retrieve. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/tools/&lt;Tool ID&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tool getTool(ToolName name) {
    GetToolRequest request =
        GetToolRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   String name = ToolName.of("[PROJECT]", "[LOCATION]", "[TOOL]").toString();
   *   Tool response = toolsClient.getTool(name);
   * }
   * }</pre>
   *
   * @param name Required. The tool resource name to retrieve. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/tools/&lt;Tool ID&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tool getTool(String name) {
    GetToolRequest request = GetToolRequest.newBuilder().setName(name).build();
    return getTool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   GetToolRequest request =
   *       GetToolRequest.newBuilder()
   *           .setName(ToolName.of("[PROJECT]", "[LOCATION]", "[TOOL]").toString())
   *           .build();
   *   Tool response = toolsClient.getTool(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tool getTool(GetToolRequest request) {
    return getToolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   GetToolRequest request =
   *       GetToolRequest.newBuilder()
   *           .setName(ToolName.of("[PROJECT]", "[LOCATION]", "[TOOL]").toString())
   *           .build();
   *   ApiFuture<Tool> future = toolsClient.getToolCallable().futureCall(request);
   *   // Do something.
   *   Tool response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetToolRequest, Tool> getToolCallable() {
    return stub.getToolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tools.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Tool element : toolsClient.listTools(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project/location to list tools for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListToolsPagedResponse listTools(LocationName parent) {
    ListToolsRequest request =
        ListToolsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listTools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tools.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Tool element : toolsClient.listTools(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project/location to list tools for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListToolsPagedResponse listTools(String parent) {
    ListToolsRequest request = ListToolsRequest.newBuilder().setParent(parent).build();
    return listTools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tools.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   ListToolsRequest request =
   *       ListToolsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Tool element : toolsClient.listTools(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListToolsPagedResponse listTools(ListToolsRequest request) {
    return listToolsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tools.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   ListToolsRequest request =
   *       ListToolsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Tool> future = toolsClient.listToolsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Tool element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListToolsRequest, ListToolsPagedResponse> listToolsPagedCallable() {
    return stub.listToolsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tools.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   ListToolsRequest request =
   *       ListToolsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListToolsResponse response = toolsClient.listToolsCallable().call(request);
   *     for (Tool element : response.getToolsList()) {
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
  public final UnaryCallable<ListToolsRequest, ListToolsResponse> listToolsCallable() {
    return stub.listToolsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   ToolName name = ToolName.of("[PROJECT]", "[LOCATION]", "[TOOL]");
   *   toolsClient.deleteTool(name);
   * }
   * }</pre>
   *
   * @param name Required. The tool resource name to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/tools/&lt;Tool ID&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTool(ToolName name) {
    DeleteToolRequest request =
        DeleteToolRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteTool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   String name = ToolName.of("[PROJECT]", "[LOCATION]", "[TOOL]").toString();
   *   toolsClient.deleteTool(name);
   * }
   * }</pre>
   *
   * @param name Required. The tool resource name to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/tools/&lt;Tool ID&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTool(String name) {
    DeleteToolRequest request = DeleteToolRequest.newBuilder().setName(name).build();
    deleteTool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   DeleteToolRequest request =
   *       DeleteToolRequest.newBuilder()
   *           .setName(ToolName.of("[PROJECT]", "[LOCATION]", "[TOOL]").toString())
   *           .build();
   *   toolsClient.deleteTool(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTool(DeleteToolRequest request) {
    deleteToolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   DeleteToolRequest request =
   *       DeleteToolRequest.newBuilder()
   *           .setName(ToolName.of("[PROJECT]", "[LOCATION]", "[TOOL]").toString())
   *           .build();
   *   ApiFuture<Empty> future = toolsClient.deleteToolCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteToolRequest, Empty> deleteToolCallable() {
    return stub.deleteToolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   Tool tool = Tool.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Tool response = toolsClient.updateTool(tool, updateMask);
   * }
   * }</pre>
   *
   * @param tool Required. The tool to update. The name field of tool is to identify the tool to
   *     update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tool updateTool(Tool tool, FieldMask updateMask) {
    UpdateToolRequest request =
        UpdateToolRequest.newBuilder().setTool(tool).setUpdateMask(updateMask).build();
    return updateTool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   UpdateToolRequest request =
   *       UpdateToolRequest.newBuilder()
   *           .setTool(Tool.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Tool response = toolsClient.updateTool(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tool updateTool(UpdateToolRequest request) {
    return updateToolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   UpdateToolRequest request =
   *       UpdateToolRequest.newBuilder()
   *           .setTool(Tool.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Tool> future = toolsClient.updateToolCallable().futureCall(request);
   *   // Do something.
   *   Tool response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateToolRequest, Tool> updateToolCallable() {
    return stub.updateToolCallable();
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
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : toolsClient.listLocations(request).iterateAll()) {
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
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = toolsClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = toolsClient.listLocationsCallable().call(request);
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
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = toolsClient.getLocation(request);
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
   * try (ToolsClient toolsClient = ToolsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = toolsClient.getLocationCallable().futureCall(request);
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

  public static class ListToolsPagedResponse
      extends AbstractPagedListResponse<
          ListToolsRequest, ListToolsResponse, Tool, ListToolsPage, ListToolsFixedSizeCollection> {

    public static ApiFuture<ListToolsPagedResponse> createAsync(
        PageContext<ListToolsRequest, ListToolsResponse, Tool> context,
        ApiFuture<ListToolsResponse> futureResponse) {
      ApiFuture<ListToolsPage> futurePage =
          ListToolsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListToolsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListToolsPagedResponse(ListToolsPage page) {
      super(page, ListToolsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListToolsPage
      extends AbstractPage<ListToolsRequest, ListToolsResponse, Tool, ListToolsPage> {

    private ListToolsPage(
        PageContext<ListToolsRequest, ListToolsResponse, Tool> context,
        ListToolsResponse response) {
      super(context, response);
    }

    private static ListToolsPage createEmptyPage() {
      return new ListToolsPage(null, null);
    }

    @Override
    protected ListToolsPage createPage(
        PageContext<ListToolsRequest, ListToolsResponse, Tool> context,
        ListToolsResponse response) {
      return new ListToolsPage(context, response);
    }

    @Override
    public ApiFuture<ListToolsPage> createPageAsync(
        PageContext<ListToolsRequest, ListToolsResponse, Tool> context,
        ApiFuture<ListToolsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListToolsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListToolsRequest, ListToolsResponse, Tool, ListToolsPage, ListToolsFixedSizeCollection> {

    private ListToolsFixedSizeCollection(List<ListToolsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListToolsFixedSizeCollection createEmptyCollection() {
      return new ListToolsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListToolsFixedSizeCollection createCollection(
        List<ListToolsPage> pages, int collectionSize) {
      return new ListToolsFixedSizeCollection(pages, collectionSize);
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
