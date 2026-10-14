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

package com.google.cloud.dialogflow.v2;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2.stub.CompanionAgentsStub;
import com.google.cloud.dialogflow.v2.stub.CompanionAgentsStubSettings;
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
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing companion agents.
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
 * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   CompanionAgent companionAgent = CompanionAgent.newBuilder().build();
 *   String companionAgentId = "companionAgentId-580252076";
 *   CompanionAgent response =
 *       companionAgentsClient.createCompanionAgent(parent, companionAgent, companionAgentId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CompanionAgentsClient object to clean up resources
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
 *      <td><p> CreateCompanionAgent</td>
 *      <td><p> Creates a companion agent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCompanionAgent(CreateCompanionAgentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createCompanionAgent(LocationName parent, CompanionAgent companionAgent, String companionAgentId)
 *           <li><p> createCompanionAgent(String parent, CompanionAgent companionAgent, String companionAgentId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCompanionAgentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCompanionAgent</td>
 *      <td><p> Gets a companion agent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCompanionAgent(GetCompanionAgentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCompanionAgent(CompanionAgentName name)
 *           <li><p> getCompanionAgent(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCompanionAgentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCompanionAgent</td>
 *      <td><p> Updates a companion agent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateCompanionAgent(UpdateCompanionAgentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateCompanionAgent(CompanionAgent companionAgent, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCompanionAgentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCompanionAgent</td>
 *      <td><p> Deletes a companion agent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteCompanionAgent(DeleteCompanionAgentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteCompanionAgent(CompanionAgentName name)
 *           <li><p> deleteCompanionAgent(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCompanionAgentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCompanionAgents</td>
 *      <td><p> Lists companion agents.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCompanionAgents(ListCompanionAgentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCompanionAgents(LocationName parent)
 *           <li><p> listCompanionAgents(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCompanionAgentsPagedCallable()
 *           <li><p> listCompanionAgentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.
 * <p> This method lists locations based on the resource scope provided inthe [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field: &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If `name` follows the format`projects/{project}`, the method lists locations visible to thatspecific project. This includes public, private, or otherproject-specific locations enabled for the project.
 * <p> For gRPC and client library implementations, the resource name ispassed as the `name` field. For direct service calls, the resourcename isincorporated into the request path based on the specific serviceimplementation and version.</td>
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
 * <p>This class can be customized by passing in a custom instance of CompanionAgentsSettings to
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
 * CompanionAgentsSettings companionAgentsSettings =
 *     CompanionAgentsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CompanionAgentsClient companionAgentsClient =
 *     CompanionAgentsClient.create(companionAgentsSettings);
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
 * CompanionAgentsSettings companionAgentsSettings =
 *     CompanionAgentsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CompanionAgentsClient companionAgentsClient =
 *     CompanionAgentsClient.create(companionAgentsSettings);
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
 * CompanionAgentsSettings companionAgentsSettings =
 *     CompanionAgentsSettings.newHttpJsonBuilder().build();
 * CompanionAgentsClient companionAgentsClient =
 *     CompanionAgentsClient.create(companionAgentsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class CompanionAgentsClient implements BackgroundResource {
  private final @Nullable CompanionAgentsSettings settings;
  private final CompanionAgentsStub stub;

  /** Constructs an instance of CompanionAgentsClient with default settings. */
  public static final CompanionAgentsClient create() throws IOException {
    return create(CompanionAgentsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CompanionAgentsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CompanionAgentsClient create(CompanionAgentsSettings settings)
      throws IOException {
    return new CompanionAgentsClient(settings);
  }

  /**
   * Constructs an instance of CompanionAgentsClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(CompanionAgentsSettings).
   */
  public static final CompanionAgentsClient create(CompanionAgentsStub stub) {
    return new CompanionAgentsClient(stub);
  }

  /**
   * Constructs an instance of CompanionAgentsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CompanionAgentsClient(CompanionAgentsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CompanionAgentsStubSettings) settings.getStubSettings()).createStub();
  }

  protected CompanionAgentsClient(CompanionAgentsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable CompanionAgentsSettings getSettings() {
    return settings;
  }

  public CompanionAgentsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a companion agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   CompanionAgent companionAgent = CompanionAgent.newBuilder().build();
   *   String companionAgentId = "companionAgentId-580252076";
   *   CompanionAgent response =
   *       companionAgentsClient.createCompanionAgent(parent, companionAgent, companionAgentId);
   * }
   * }</pre>
   *
   * @param parent Required. Resource identifier of the project creating the companion agent.
   *     Format: `projects/{project}/locations/{location}`
   * @param companionAgent Required. The companion agent to create.
   * @param companionAgentId Optional. The resource ID of the companion agent to create. If not
   *     provided, the server will auto-generate a resource ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CompanionAgent createCompanionAgent(
      @Nullable LocationName parent, CompanionAgent companionAgent, String companionAgentId) {
    CreateCompanionAgentRequest request =
        CreateCompanionAgentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCompanionAgent(companionAgent)
            .setCompanionAgentId(companionAgentId)
            .build();
    return createCompanionAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a companion agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   CompanionAgent companionAgent = CompanionAgent.newBuilder().build();
   *   String companionAgentId = "companionAgentId-580252076";
   *   CompanionAgent response =
   *       companionAgentsClient.createCompanionAgent(parent, companionAgent, companionAgentId);
   * }
   * }</pre>
   *
   * @param parent Required. Resource identifier of the project creating the companion agent.
   *     Format: `projects/{project}/locations/{location}`
   * @param companionAgent Required. The companion agent to create.
   * @param companionAgentId Optional. The resource ID of the companion agent to create. If not
   *     provided, the server will auto-generate a resource ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CompanionAgent createCompanionAgent(
      String parent, CompanionAgent companionAgent, String companionAgentId) {
    CreateCompanionAgentRequest request =
        CreateCompanionAgentRequest.newBuilder()
            .setParent(parent)
            .setCompanionAgent(companionAgent)
            .setCompanionAgentId(companionAgentId)
            .build();
    return createCompanionAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a companion agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   CreateCompanionAgentRequest request =
   *       CreateCompanionAgentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCompanionAgent(CompanionAgent.newBuilder().build())
   *           .setCompanionAgentId("companionAgentId-580252076")
   *           .build();
   *   CompanionAgent response = companionAgentsClient.createCompanionAgent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CompanionAgent createCompanionAgent(CreateCompanionAgentRequest request) {
    return createCompanionAgentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a companion agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   CreateCompanionAgentRequest request =
   *       CreateCompanionAgentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCompanionAgent(CompanionAgent.newBuilder().build())
   *           .setCompanionAgentId("companionAgentId-580252076")
   *           .build();
   *   ApiFuture<CompanionAgent> future =
   *       companionAgentsClient.createCompanionAgentCallable().futureCall(request);
   *   // Do something.
   *   CompanionAgent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCompanionAgentRequest, CompanionAgent>
      createCompanionAgentCallable() {
    return stub.createCompanionAgentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a companion agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   CompanionAgentName name =
   *       CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]");
   *   CompanionAgent response = companionAgentsClient.getCompanionAgent(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique resource identifier of the CompanionAgent to get all
   *     information for. Format:
   *     `projects/{project}/locations/{location}/companionAgents/{companion_agent}`. Contains the
   *     information about the {project}, {location}, and {companion_agent}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CompanionAgent getCompanionAgent(@Nullable CompanionAgentName name) {
    GetCompanionAgentRequest request =
        GetCompanionAgentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCompanionAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a companion agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   String name =
   *       CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]").toString();
   *   CompanionAgent response = companionAgentsClient.getCompanionAgent(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique resource identifier of the CompanionAgent to get all
   *     information for. Format:
   *     `projects/{project}/locations/{location}/companionAgents/{companion_agent}`. Contains the
   *     information about the {project}, {location}, and {companion_agent}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CompanionAgent getCompanionAgent(String name) {
    GetCompanionAgentRequest request = GetCompanionAgentRequest.newBuilder().setName(name).build();
    return getCompanionAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a companion agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   GetCompanionAgentRequest request =
   *       GetCompanionAgentRequest.newBuilder()
   *           .setName(
   *               CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]").toString())
   *           .build();
   *   CompanionAgent response = companionAgentsClient.getCompanionAgent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CompanionAgent getCompanionAgent(GetCompanionAgentRequest request) {
    return getCompanionAgentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a companion agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   GetCompanionAgentRequest request =
   *       GetCompanionAgentRequest.newBuilder()
   *           .setName(
   *               CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]").toString())
   *           .build();
   *   ApiFuture<CompanionAgent> future =
   *       companionAgentsClient.getCompanionAgentCallable().futureCall(request);
   *   // Do something.
   *   CompanionAgent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCompanionAgentRequest, CompanionAgent> getCompanionAgentCallable() {
    return stub.getCompanionAgentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a companion agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   CompanionAgent companionAgent = CompanionAgent.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CompanionAgent response =
   *       companionAgentsClient.updateCompanionAgent(companionAgent, updateMask);
   * }
   * }</pre>
   *
   * @param companionAgent Required. The Companion Agent to update.
   * @param updateMask Optional. Update mask for Companion Agent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CompanionAgent updateCompanionAgent(
      CompanionAgent companionAgent, FieldMask updateMask) {
    UpdateCompanionAgentRequest request =
        UpdateCompanionAgentRequest.newBuilder()
            .setCompanionAgent(companionAgent)
            .setUpdateMask(updateMask)
            .build();
    return updateCompanionAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a companion agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   UpdateCompanionAgentRequest request =
   *       UpdateCompanionAgentRequest.newBuilder()
   *           .setCompanionAgent(CompanionAgent.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   CompanionAgent response = companionAgentsClient.updateCompanionAgent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CompanionAgent updateCompanionAgent(UpdateCompanionAgentRequest request) {
    return updateCompanionAgentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a companion agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   UpdateCompanionAgentRequest request =
   *       UpdateCompanionAgentRequest.newBuilder()
   *           .setCompanionAgent(CompanionAgent.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<CompanionAgent> future =
   *       companionAgentsClient.updateCompanionAgentCallable().futureCall(request);
   *   // Do something.
   *   CompanionAgent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCompanionAgentRequest, CompanionAgent>
      updateCompanionAgentCallable() {
    return stub.updateCompanionAgentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a companion agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   CompanionAgentName name =
   *       CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]");
   *   companionAgentsClient.deleteCompanionAgent(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique resource identifier of the CompanionAgent to delete. Format:
   *     `projects/{project}/locations/{location}/companionAgents/{companion_agent}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCompanionAgent(@Nullable CompanionAgentName name) {
    DeleteCompanionAgentRequest request =
        DeleteCompanionAgentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteCompanionAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a companion agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   String name =
   *       CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]").toString();
   *   companionAgentsClient.deleteCompanionAgent(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique resource identifier of the CompanionAgent to delete. Format:
   *     `projects/{project}/locations/{location}/companionAgents/{companion_agent}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCompanionAgent(String name) {
    DeleteCompanionAgentRequest request =
        DeleteCompanionAgentRequest.newBuilder().setName(name).build();
    deleteCompanionAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a companion agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   DeleteCompanionAgentRequest request =
   *       DeleteCompanionAgentRequest.newBuilder()
   *           .setName(
   *               CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]").toString())
   *           .build();
   *   companionAgentsClient.deleteCompanionAgent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCompanionAgent(DeleteCompanionAgentRequest request) {
    deleteCompanionAgentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a companion agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   DeleteCompanionAgentRequest request =
   *       DeleteCompanionAgentRequest.newBuilder()
   *           .setName(
   *               CompanionAgentName.of("[PROJECT]", "[LOCATION]", "[COMPANION_AGENT]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       companionAgentsClient.deleteCompanionAgentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCompanionAgentRequest, Empty> deleteCompanionAgentCallable() {
    return stub.deleteCompanionAgentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists companion agents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (CompanionAgent element :
   *       companionAgentsClient.listCompanionAgents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name to list the companion agents for. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCompanionAgentsPagedResponse listCompanionAgents(@Nullable LocationName parent) {
    ListCompanionAgentsRequest request =
        ListCompanionAgentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCompanionAgents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists companion agents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (CompanionAgent element :
   *       companionAgentsClient.listCompanionAgents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name to list the companion agents for. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCompanionAgentsPagedResponse listCompanionAgents(String parent) {
    ListCompanionAgentsRequest request =
        ListCompanionAgentsRequest.newBuilder().setParent(parent).build();
    return listCompanionAgents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists companion agents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   ListCompanionAgentsRequest request =
   *       ListCompanionAgentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (CompanionAgent element :
   *       companionAgentsClient.listCompanionAgents(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCompanionAgentsPagedResponse listCompanionAgents(
      ListCompanionAgentsRequest request) {
    return listCompanionAgentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists companion agents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   ListCompanionAgentsRequest request =
   *       ListCompanionAgentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<CompanionAgent> future =
   *       companionAgentsClient.listCompanionAgentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CompanionAgent element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCompanionAgentsRequest, ListCompanionAgentsPagedResponse>
      listCompanionAgentsPagedCallable() {
    return stub.listCompanionAgentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists companion agents.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   ListCompanionAgentsRequest request =
   *       ListCompanionAgentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListCompanionAgentsResponse response =
   *         companionAgentsClient.listCompanionAgentsCallable().call(request);
   *     for (CompanionAgent element : response.getCompanionAgentsList()) {
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
  public final UnaryCallable<ListCompanionAgentsRequest, ListCompanionAgentsResponse>
      listCompanionAgentsCallable() {
    return stub.listCompanionAgentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : companionAgentsClient.listLocations(request).iterateAll()) {
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
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       companionAgentsClient.listLocationsPagedCallable().futureCall(request);
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
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         companionAgentsClient.listLocationsCallable().call(request);
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
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = companionAgentsClient.getLocation(request);
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
   * try (CompanionAgentsClient companionAgentsClient = CompanionAgentsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = companionAgentsClient.getLocationCallable().futureCall(request);
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

  public static class ListCompanionAgentsPagedResponse
      extends AbstractPagedListResponse<
          ListCompanionAgentsRequest,
          ListCompanionAgentsResponse,
          CompanionAgent,
          ListCompanionAgentsPage,
          ListCompanionAgentsFixedSizeCollection> {

    public static ApiFuture<ListCompanionAgentsPagedResponse> createAsync(
        PageContext<ListCompanionAgentsRequest, ListCompanionAgentsResponse, CompanionAgent>
            context,
        ApiFuture<ListCompanionAgentsResponse> futureResponse) {
      ApiFuture<ListCompanionAgentsPage> futurePage =
          ListCompanionAgentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCompanionAgentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCompanionAgentsPagedResponse(ListCompanionAgentsPage page) {
      super(page, ListCompanionAgentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCompanionAgentsPage
      extends AbstractPage<
          ListCompanionAgentsRequest,
          ListCompanionAgentsResponse,
          CompanionAgent,
          ListCompanionAgentsPage> {

    private ListCompanionAgentsPage(
        @Nullable
            PageContext<ListCompanionAgentsRequest, ListCompanionAgentsResponse, CompanionAgent>
            context,
        @Nullable ListCompanionAgentsResponse response) {
      super(context, response);
    }

    private static ListCompanionAgentsPage createEmptyPage() {
      return new ListCompanionAgentsPage(null, null);
    }

    @Override
    protected ListCompanionAgentsPage createPage(
        @Nullable
            PageContext<ListCompanionAgentsRequest, ListCompanionAgentsResponse, CompanionAgent>
            context,
        @Nullable ListCompanionAgentsResponse response) {
      return new ListCompanionAgentsPage(context, response);
    }

    @Override
    public ApiFuture<ListCompanionAgentsPage> createPageAsync(
        @Nullable
            PageContext<ListCompanionAgentsRequest, ListCompanionAgentsResponse, CompanionAgent>
            context,
        ApiFuture<ListCompanionAgentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCompanionAgentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCompanionAgentsRequest,
          ListCompanionAgentsResponse,
          CompanionAgent,
          ListCompanionAgentsPage,
          ListCompanionAgentsFixedSizeCollection> {

    private ListCompanionAgentsFixedSizeCollection(
        @Nullable List<ListCompanionAgentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCompanionAgentsFixedSizeCollection createEmptyCollection() {
      return new ListCompanionAgentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCompanionAgentsFixedSizeCollection createCollection(
        @Nullable List<ListCompanionAgentsPage> pages, int collectionSize) {
      return new ListCompanionAgentsFixedSizeCollection(pages, collectionSize);
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
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
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

    private ListLocationsFixedSizeCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
