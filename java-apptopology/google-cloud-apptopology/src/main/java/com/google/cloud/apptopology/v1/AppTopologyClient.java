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

package com.google.cloud.apptopology.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apptopology.v1.stub.AppTopologyStub;
import com.google.cloud.apptopology.v1.stub.AppTopologyStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service describing handlers for resources
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
 * try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
 *   DiscoveredResourcesTopologyName name =
 *       DiscoveredResourcesTopologyName.of("[PROJECT]", "[LOCATION]");
 *   List<String> topologyDomains = new ArrayList<>();
 *   GenerateDiscoveredResourcesTopologyResponse response =
 *       appTopologyClient.generateDiscoveredResourcesTopology(name, topologyDomains);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AppTopologyClient object to clean up resources such as
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
 *      <td><p> GenerateDiscoveredResourcesTopology</td>
 *      <td><p> Generate the topology for all resources in the given project. If the project represents an [app boundary](https://cloud.google.com/app-hub/docs/reference/rest/v1/Boundary), the topology is generated for all resources in the boundary.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateDiscoveredResourcesTopology(GenerateDiscoveredResourcesTopologyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> generateDiscoveredResourcesTopology(DiscoveredResourcesTopologyName name, List&lt;String&gt; topologyDomains)
 *           <li><p> generateDiscoveredResourcesTopology(String name, List&lt;String&gt; topologyDomains)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateDiscoveredResourcesTopologyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSchema</td>
 *      <td><p> Retrieves the schema for the specified topology domain. The schema defines the NodeTypes and EdgeTypes that are supported in GenerateDiscoveredResourcesTopology requests and responses for a given domain.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSchema(GetSchemaRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSchema(SchemaName name)
 *           <li><p> getSchema(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSchemaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDomain</td>
 *      <td><p> Retrieves the specified topology domain.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDomain(GetDomainRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDomain(DomainName name)
 *           <li><p> getDomain(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDomainCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDomains</td>
 *      <td><p> Lists the topology domains available in a specific location. Only `global` location is supported.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDomains(ListDomainsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDomains(LocationName parent)
 *           <li><p> listDomains(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDomainsPagedCallable()
 *           <li><p> listDomainsCallable()
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
 * <p>This class can be customized by passing in a custom instance of AppTopologySettings to
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
 * AppTopologySettings appTopologySettings =
 *     AppTopologySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AppTopologyClient appTopologyClient = AppTopologyClient.create(appTopologySettings);
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
 * AppTopologySettings appTopologySettings =
 *     AppTopologySettings.newBuilder().setEndpoint(myEndpoint).build();
 * AppTopologyClient appTopologyClient = AppTopologyClient.create(appTopologySettings);
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
 * AppTopologySettings appTopologySettings = AppTopologySettings.newHttpJsonBuilder().build();
 * AppTopologyClient appTopologyClient = AppTopologyClient.create(appTopologySettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class AppTopologyClient implements BackgroundResource {
  private final @Nullable AppTopologySettings settings;
  private final AppTopologyStub stub;

  /** Constructs an instance of AppTopologyClient with default settings. */
  public static final AppTopologyClient create() throws IOException {
    return create(AppTopologySettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AppTopologyClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AppTopologyClient create(AppTopologySettings settings) throws IOException {
    return new AppTopologyClient(settings);
  }

  /**
   * Constructs an instance of AppTopologyClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(AppTopologySettings).
   */
  public static final AppTopologyClient create(AppTopologyStub stub) {
    return new AppTopologyClient(stub);
  }

  /**
   * Constructs an instance of AppTopologyClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AppTopologyClient(AppTopologySettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AppTopologyStubSettings) settings.getStubSettings()).createStub();
  }

  protected AppTopologyClient(AppTopologyStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable AppTopologySettings getSettings() {
    return settings;
  }

  public AppTopologyStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate the topology for all resources in the given project. If the project represents an [app
   * boundary](https://cloud.google.com/app-hub/docs/reference/rest/v1/Boundary), the topology is
   * generated for all resources in the boundary.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
   *   DiscoveredResourcesTopologyName name =
   *       DiscoveredResourcesTopologyName.of("[PROJECT]", "[LOCATION]");
   *   List<String> topologyDomains = new ArrayList<>();
   *   GenerateDiscoveredResourcesTopologyResponse response =
   *       appTopologyClient.generateDiscoveredResourcesTopology(name, topologyDomains);
   * }
   * }</pre>
   *
   * @param name Required. The project to query discoverable resources on. Expected format:
   *     `projects/{project}/locations/{location}/discoveredResourcesTopology`. Only `global`
   *     location is supported.
   * @param topologyDomains Required. The full resource name of the domain of the app topology.
   *     Format: `projects/{project}/locations/{location}/domains/{domain}` Caller must have
   *     apptopology.domains.get permission on each of the domains.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateDiscoveredResourcesTopologyResponse generateDiscoveredResourcesTopology(
      @Nullable DiscoveredResourcesTopologyName name, List<String> topologyDomains) {
    GenerateDiscoveredResourcesTopologyRequest request =
        GenerateDiscoveredResourcesTopologyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .addAllTopologyDomains(topologyDomains)
            .build();
    return generateDiscoveredResourcesTopology(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate the topology for all resources in the given project. If the project represents an [app
   * boundary](https://cloud.google.com/app-hub/docs/reference/rest/v1/Boundary), the topology is
   * generated for all resources in the boundary.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
   *   String name = DiscoveredResourcesTopologyName.of("[PROJECT]", "[LOCATION]").toString();
   *   List<String> topologyDomains = new ArrayList<>();
   *   GenerateDiscoveredResourcesTopologyResponse response =
   *       appTopologyClient.generateDiscoveredResourcesTopology(name, topologyDomains);
   * }
   * }</pre>
   *
   * @param name Required. The project to query discoverable resources on. Expected format:
   *     `projects/{project}/locations/{location}/discoveredResourcesTopology`. Only `global`
   *     location is supported.
   * @param topologyDomains Required. The full resource name of the domain of the app topology.
   *     Format: `projects/{project}/locations/{location}/domains/{domain}` Caller must have
   *     apptopology.domains.get permission on each of the domains.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateDiscoveredResourcesTopologyResponse generateDiscoveredResourcesTopology(
      String name, List<String> topologyDomains) {
    GenerateDiscoveredResourcesTopologyRequest request =
        GenerateDiscoveredResourcesTopologyRequest.newBuilder()
            .setName(name)
            .addAllTopologyDomains(topologyDomains)
            .build();
    return generateDiscoveredResourcesTopology(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate the topology for all resources in the given project. If the project represents an [app
   * boundary](https://cloud.google.com/app-hub/docs/reference/rest/v1/Boundary), the topology is
   * generated for all resources in the boundary.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
   *   GenerateDiscoveredResourcesTopologyRequest request =
   *       GenerateDiscoveredResourcesTopologyRequest.newBuilder()
   *           .setName(DiscoveredResourcesTopologyName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllTopologyDomains(new ArrayList<String>())
   *           .build();
   *   GenerateDiscoveredResourcesTopologyResponse response =
   *       appTopologyClient.generateDiscoveredResourcesTopology(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateDiscoveredResourcesTopologyResponse generateDiscoveredResourcesTopology(
      GenerateDiscoveredResourcesTopologyRequest request) {
    return generateDiscoveredResourcesTopologyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate the topology for all resources in the given project. If the project represents an [app
   * boundary](https://cloud.google.com/app-hub/docs/reference/rest/v1/Boundary), the topology is
   * generated for all resources in the boundary.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
   *   GenerateDiscoveredResourcesTopologyRequest request =
   *       GenerateDiscoveredResourcesTopologyRequest.newBuilder()
   *           .setName(DiscoveredResourcesTopologyName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllTopologyDomains(new ArrayList<String>())
   *           .build();
   *   ApiFuture<GenerateDiscoveredResourcesTopologyResponse> future =
   *       appTopologyClient.generateDiscoveredResourcesTopologyCallable().futureCall(request);
   *   // Do something.
   *   GenerateDiscoveredResourcesTopologyResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GenerateDiscoveredResourcesTopologyRequest, GenerateDiscoveredResourcesTopologyResponse>
      generateDiscoveredResourcesTopologyCallable() {
    return stub.generateDiscoveredResourcesTopologyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the schema for the specified topology domain. The schema defines the NodeTypes and
   * EdgeTypes that are supported in GenerateDiscoveredResourcesTopology requests and responses for
   * a given domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
   *   SchemaName name = SchemaName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");
   *   Schema response = appTopologyClient.getSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the singleton domain schema resource. Format:
   *     `projects/{project}/locations/{location}/domains/{domain}/schema`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schema getSchema(@Nullable SchemaName name) {
    GetSchemaRequest request =
        GetSchemaRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the schema for the specified topology domain. The schema defines the NodeTypes and
   * EdgeTypes that are supported in GenerateDiscoveredResourcesTopology requests and responses for
   * a given domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
   *   String name = SchemaName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString();
   *   Schema response = appTopologyClient.getSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the singleton domain schema resource. Format:
   *     `projects/{project}/locations/{location}/domains/{domain}/schema`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schema getSchema(String name) {
    GetSchemaRequest request = GetSchemaRequest.newBuilder().setName(name).build();
    return getSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the schema for the specified topology domain. The schema defines the NodeTypes and
   * EdgeTypes that are supported in GenerateDiscoveredResourcesTopology requests and responses for
   * a given domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
   *   GetSchemaRequest request =
   *       GetSchemaRequest.newBuilder()
   *           .setName(SchemaName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
   *           .build();
   *   Schema response = appTopologyClient.getSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schema getSchema(GetSchemaRequest request) {
    return getSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the schema for the specified topology domain. The schema defines the NodeTypes and
   * EdgeTypes that are supported in GenerateDiscoveredResourcesTopology requests and responses for
   * a given domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
   *   GetSchemaRequest request =
   *       GetSchemaRequest.newBuilder()
   *           .setName(SchemaName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
   *           .build();
   *   ApiFuture<Schema> future = appTopologyClient.getSchemaCallable().futureCall(request);
   *   // Do something.
   *   Schema response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSchemaRequest, Schema> getSchemaCallable() {
    return stub.getSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified topology domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
   *   DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");
   *   Domain response = appTopologyClient.getDomain(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the domain to retrieve. Format:
   *     `projects/{project}/locations/{location}/domains/{domain}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Domain getDomain(@Nullable DomainName name) {
    GetDomainRequest request =
        GetDomainRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDomain(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified topology domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
   *   String name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString();
   *   Domain response = appTopologyClient.getDomain(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the domain to retrieve. Format:
   *     `projects/{project}/locations/{location}/domains/{domain}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Domain getDomain(String name) {
    GetDomainRequest request = GetDomainRequest.newBuilder().setName(name).build();
    return getDomain(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified topology domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
   *   GetDomainRequest request =
   *       GetDomainRequest.newBuilder()
   *           .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
   *           .build();
   *   Domain response = appTopologyClient.getDomain(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Domain getDomain(GetDomainRequest request) {
    return getDomainCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified topology domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
   *   GetDomainRequest request =
   *       GetDomainRequest.newBuilder()
   *           .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
   *           .build();
   *   ApiFuture<Domain> future = appTopologyClient.getDomainCallable().futureCall(request);
   *   // Do something.
   *   Domain response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDomainRequest, Domain> getDomainCallable() {
    return stub.getDomainCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the topology domains available in a specific location. Only `global` location is
   * supported.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Domain element : appTopologyClient.listDomains(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location to list domains for. Format:
   *     `projects/{project}/locations/{location}` Only `global` location is supported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDomainsPagedResponse listDomains(@Nullable LocationName parent) {
    ListDomainsRequest request =
        ListDomainsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDomains(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the topology domains available in a specific location. Only `global` location is
   * supported.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Domain element : appTopologyClient.listDomains(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location to list domains for. Format:
   *     `projects/{project}/locations/{location}` Only `global` location is supported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDomainsPagedResponse listDomains(String parent) {
    ListDomainsRequest request = ListDomainsRequest.newBuilder().setParent(parent).build();
    return listDomains(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the topology domains available in a specific location. Only `global` location is
   * supported.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
   *   ListDomainsRequest request =
   *       ListDomainsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Domain element : appTopologyClient.listDomains(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDomainsPagedResponse listDomains(ListDomainsRequest request) {
    return listDomainsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the topology domains available in a specific location. Only `global` location is
   * supported.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
   *   ListDomainsRequest request =
   *       ListDomainsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Domain> future = appTopologyClient.listDomainsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Domain element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDomainsRequest, ListDomainsPagedResponse>
      listDomainsPagedCallable() {
    return stub.listDomainsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the topology domains available in a specific location. Only `global` location is
   * supported.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
   *   ListDomainsRequest request =
   *       ListDomainsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDomainsResponse response = appTopologyClient.listDomainsCallable().call(request);
   *     for (Domain element : response.getDomainsList()) {
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
  public final UnaryCallable<ListDomainsRequest, ListDomainsResponse> listDomainsCallable() {
    return stub.listDomainsCallable();
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
   * try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : appTopologyClient.listLocations(request).iterateAll()) {
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
   * try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       appTopologyClient.listLocationsPagedCallable().futureCall(request);
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
   * try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = appTopologyClient.listLocationsCallable().call(request);
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
   * try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = appTopologyClient.getLocation(request);
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
   * try (AppTopologyClient appTopologyClient = AppTopologyClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = appTopologyClient.getLocationCallable().futureCall(request);
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

  public static class ListDomainsPagedResponse
      extends AbstractPagedListResponse<
          ListDomainsRequest,
          ListDomainsResponse,
          Domain,
          ListDomainsPage,
          ListDomainsFixedSizeCollection> {

    public static ApiFuture<ListDomainsPagedResponse> createAsync(
        PageContext<ListDomainsRequest, ListDomainsResponse, Domain> context,
        ApiFuture<ListDomainsResponse> futureResponse) {
      ApiFuture<ListDomainsPage> futurePage =
          ListDomainsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListDomainsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListDomainsPagedResponse(ListDomainsPage page) {
      super(page, ListDomainsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDomainsPage
      extends AbstractPage<ListDomainsRequest, ListDomainsResponse, Domain, ListDomainsPage> {

    private ListDomainsPage(
        @Nullable PageContext<ListDomainsRequest, ListDomainsResponse, Domain> context,
        @Nullable ListDomainsResponse response) {
      super(context, response);
    }

    private static ListDomainsPage createEmptyPage() {
      return new ListDomainsPage(null, null);
    }

    @Override
    protected ListDomainsPage createPage(
        @Nullable PageContext<ListDomainsRequest, ListDomainsResponse, Domain> context,
        @Nullable ListDomainsResponse response) {
      return new ListDomainsPage(context, response);
    }

    @Override
    public ApiFuture<ListDomainsPage> createPageAsync(
        @Nullable PageContext<ListDomainsRequest, ListDomainsResponse, Domain> context,
        ApiFuture<ListDomainsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDomainsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDomainsRequest,
          ListDomainsResponse,
          Domain,
          ListDomainsPage,
          ListDomainsFixedSizeCollection> {

    private ListDomainsFixedSizeCollection(
        @Nullable List<ListDomainsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDomainsFixedSizeCollection createEmptyCollection() {
      return new ListDomainsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDomainsFixedSizeCollection createCollection(
        @Nullable List<ListDomainsPage> pages, int collectionSize) {
      return new ListDomainsFixedSizeCollection(pages, collectionSize);
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
