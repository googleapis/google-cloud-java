/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.developerconnect.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.developerconnect.v1.stub.DeveloperConnectStub;
import com.google.cloud.developerconnect.v1.stub.DeveloperConnectStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

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
 * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
 *   ConnectionName name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
 *   Connection response = developerConnectClient.getConnection(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DeveloperConnectClient object to clean up resources
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
 *      <td><p> ListConnections</td>
 *      <td><p> Lists Connections in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listConnections(ListConnectionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listConnections(LocationName parent)
 *           <li><p> listConnections(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listConnectionsPagedCallable()
 *           <li><p> listConnectionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetConnection</td>
 *      <td><p> Gets details of a single Connection.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getConnection(GetConnectionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getConnection(ConnectionName name)
 *           <li><p> getConnection(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getConnectionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateConnection</td>
 *      <td><p> Creates a new Connection in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createConnectionAsync(CreateConnectionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createConnectionAsync(LocationName parent, Connection connection, String connectionId)
 *           <li><p> createConnectionAsync(String parent, Connection connection, String connectionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createConnectionOperationCallable()
 *           <li><p> createConnectionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateConnection</td>
 *      <td><p> Updates the parameters of a single Connection.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateConnectionAsync(UpdateConnectionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateConnectionAsync(Connection connection, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateConnectionOperationCallable()
 *           <li><p> updateConnectionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteConnection</td>
 *      <td><p> Deletes a single Connection.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteConnectionAsync(DeleteConnectionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteConnectionAsync(ConnectionName name)
 *           <li><p> deleteConnectionAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteConnectionOperationCallable()
 *           <li><p> deleteConnectionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateGitRepositoryLink</td>
 *      <td><p> Creates a GitRepositoryLink. Upon linking a Git Repository, Developer Connect will configure the Git Repository to send webhook events to Developer Connect. Connections that use Firebase GitHub Application will have events forwarded to the Firebase service. All other Connections will have events forwarded to Cloud Build.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createGitRepositoryLinkAsync(CreateGitRepositoryLinkRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createGitRepositoryLinkAsync(ConnectionName parent, GitRepositoryLink gitRepositoryLink, String gitRepositoryLinkId)
 *           <li><p> createGitRepositoryLinkAsync(String parent, GitRepositoryLink gitRepositoryLink, String gitRepositoryLinkId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createGitRepositoryLinkOperationCallable()
 *           <li><p> createGitRepositoryLinkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteGitRepositoryLink</td>
 *      <td><p> Deletes a single GitRepositoryLink.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteGitRepositoryLinkAsync(DeleteGitRepositoryLinkRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteGitRepositoryLinkAsync(GitRepositoryLinkName name)
 *           <li><p> deleteGitRepositoryLinkAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteGitRepositoryLinkOperationCallable()
 *           <li><p> deleteGitRepositoryLinkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListGitRepositoryLinks</td>
 *      <td><p> Lists GitRepositoryLinks in a given project, location, and connection.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listGitRepositoryLinks(ListGitRepositoryLinksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listGitRepositoryLinks(ConnectionName parent)
 *           <li><p> listGitRepositoryLinks(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listGitRepositoryLinksPagedCallable()
 *           <li><p> listGitRepositoryLinksCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetGitRepositoryLink</td>
 *      <td><p> Gets details of a single GitRepositoryLink.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getGitRepositoryLink(GetGitRepositoryLinkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getGitRepositoryLink(GitRepositoryLinkName name)
 *           <li><p> getGitRepositoryLink(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getGitRepositoryLinkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchReadWriteToken</td>
 *      <td><p> Fetches read/write token of a given gitRepositoryLink.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchReadWriteToken(FetchReadWriteTokenRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> fetchReadWriteToken(GitRepositoryLinkName gitRepositoryLink)
 *           <li><p> fetchReadWriteToken(String gitRepositoryLink)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchReadWriteTokenCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchReadToken</td>
 *      <td><p> Fetches read token of a given gitRepositoryLink.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchReadToken(FetchReadTokenRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> fetchReadToken(GitRepositoryLinkName gitRepositoryLink)
 *           <li><p> fetchReadToken(String gitRepositoryLink)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchReadTokenCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchLinkableGitRepositories</td>
 *      <td><p> FetchLinkableGitRepositories returns a list of git repositories from an SCM that are available to be added to a Connection.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchLinkableGitRepositories(FetchLinkableGitRepositoriesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> fetchLinkableGitRepositories(ConnectionName connection)
 *           <li><p> fetchLinkableGitRepositories(String connection)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchLinkableGitRepositoriesPagedCallable()
 *           <li><p> fetchLinkableGitRepositoriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchGitHubInstallations</td>
 *      <td><p> FetchGitHubInstallations returns the list of GitHub Installations that are available to be added to a Connection. For github.com, only installations accessible to the authorizer token are returned. For GitHub Enterprise, all installations are returned.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchGitHubInstallations(FetchGitHubInstallationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> fetchGitHubInstallations(ConnectionName connection)
 *           <li><p> fetchGitHubInstallations(String connection)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchGitHubInstallationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchGitRefs</td>
 *      <td><p> Fetch the list of branches or tags for a given repository.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchGitRefs(FetchGitRefsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> fetchGitRefs(GitRepositoryLinkName gitRepositoryLink, FetchGitRefsRequest.RefType refType)
 *           <li><p> fetchGitRefs(String gitRepositoryLink, FetchGitRefsRequest.RefType refType)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchGitRefsPagedCallable()
 *           <li><p> fetchGitRefsCallable()
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
 * <p>This class can be customized by passing in a custom instance of DeveloperConnectSettings to
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
 * DeveloperConnectSettings developerConnectSettings =
 *     DeveloperConnectSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DeveloperConnectClient developerConnectClient =
 *     DeveloperConnectClient.create(developerConnectSettings);
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
 * DeveloperConnectSettings developerConnectSettings =
 *     DeveloperConnectSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DeveloperConnectClient developerConnectClient =
 *     DeveloperConnectClient.create(developerConnectSettings);
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
 * DeveloperConnectSettings developerConnectSettings =
 *     DeveloperConnectSettings.newHttpJsonBuilder().build();
 * DeveloperConnectClient developerConnectClient =
 *     DeveloperConnectClient.create(developerConnectSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DeveloperConnectClient implements BackgroundResource {
  private final DeveloperConnectSettings settings;
  private final DeveloperConnectStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of DeveloperConnectClient with default settings. */
  public static final DeveloperConnectClient create() throws IOException {
    return create(DeveloperConnectSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DeveloperConnectClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DeveloperConnectClient create(DeveloperConnectSettings settings)
      throws IOException {
    return new DeveloperConnectClient(settings);
  }

  /**
   * Constructs an instance of DeveloperConnectClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(DeveloperConnectSettings).
   */
  public static final DeveloperConnectClient create(DeveloperConnectStub stub) {
    return new DeveloperConnectClient(stub);
  }

  /**
   * Constructs an instance of DeveloperConnectClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DeveloperConnectClient(DeveloperConnectSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DeveloperConnectStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected DeveloperConnectClient(DeveloperConnectStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final DeveloperConnectSettings getSettings() {
    return settings;
  }

  public DeveloperConnectStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Connections in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Connection element : developerConnectClient.listConnections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListConnectionsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectionsPagedResponse listConnections(LocationName parent) {
    ListConnectionsRequest request =
        ListConnectionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listConnections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Connections in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Connection element : developerConnectClient.listConnections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListConnectionsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectionsPagedResponse listConnections(String parent) {
    ListConnectionsRequest request = ListConnectionsRequest.newBuilder().setParent(parent).build();
    return listConnections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Connections in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   ListConnectionsRequest request =
   *       ListConnectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Connection element : developerConnectClient.listConnections(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConnectionsPagedResponse listConnections(ListConnectionsRequest request) {
    return listConnectionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Connections in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   ListConnectionsRequest request =
   *       ListConnectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Connection> future =
   *       developerConnectClient.listConnectionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Connection element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListConnectionsRequest, ListConnectionsPagedResponse>
      listConnectionsPagedCallable() {
    return stub.listConnectionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Connections in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   ListConnectionsRequest request =
   *       ListConnectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListConnectionsResponse response =
   *         developerConnectClient.listConnectionsCallable().call(request);
   *     for (Connection element : response.getConnectionsList()) {
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
  public final UnaryCallable<ListConnectionsRequest, ListConnectionsResponse>
      listConnectionsCallable() {
    return stub.listConnectionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   ConnectionName name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
   *   Connection response = developerConnectClient.getConnection(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Connection getConnection(ConnectionName name) {
    GetConnectionRequest request =
        GetConnectionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   String name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString();
   *   Connection response = developerConnectClient.getConnection(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Connection getConnection(String name) {
    GetConnectionRequest request = GetConnectionRequest.newBuilder().setName(name).build();
    return getConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   GetConnectionRequest request =
   *       GetConnectionRequest.newBuilder()
   *           .setName(ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
   *           .build();
   *   Connection response = developerConnectClient.getConnection(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Connection getConnection(GetConnectionRequest request) {
    return getConnectionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   GetConnectionRequest request =
   *       GetConnectionRequest.newBuilder()
   *           .setName(ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
   *           .build();
   *   ApiFuture<Connection> future =
   *       developerConnectClient.getConnectionCallable().futureCall(request);
   *   // Do something.
   *   Connection response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConnectionRequest, Connection> getConnectionCallable() {
    return stub.getConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Connection in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Connection connection = Connection.newBuilder().build();
   *   String connectionId = "connectionId1923106969";
   *   Connection response =
   *       developerConnectClient.createConnectionAsync(parent, connection, connectionId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param connection Required. The resource being created
   * @param connectionId Required. Id of the requesting object If auto-generating Id server-side,
   *     remove this field and connection_id from the method_signature of Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Connection, OperationMetadata> createConnectionAsync(
      LocationName parent, Connection connection, String connectionId) {
    CreateConnectionRequest request =
        CreateConnectionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConnection(connection)
            .setConnectionId(connectionId)
            .build();
    return createConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Connection in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Connection connection = Connection.newBuilder().build();
   *   String connectionId = "connectionId1923106969";
   *   Connection response =
   *       developerConnectClient.createConnectionAsync(parent, connection, connectionId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param connection Required. The resource being created
   * @param connectionId Required. Id of the requesting object If auto-generating Id server-side,
   *     remove this field and connection_id from the method_signature of Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Connection, OperationMetadata> createConnectionAsync(
      String parent, Connection connection, String connectionId) {
    CreateConnectionRequest request =
        CreateConnectionRequest.newBuilder()
            .setParent(parent)
            .setConnection(connection)
            .setConnectionId(connectionId)
            .build();
    return createConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Connection in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   CreateConnectionRequest request =
   *       CreateConnectionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConnectionId("connectionId1923106969")
   *           .setConnection(Connection.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   Connection response = developerConnectClient.createConnectionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Connection, OperationMetadata> createConnectionAsync(
      CreateConnectionRequest request) {
    return createConnectionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Connection in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   CreateConnectionRequest request =
   *       CreateConnectionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConnectionId("connectionId1923106969")
   *           .setConnection(Connection.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Connection, OperationMetadata> future =
   *       developerConnectClient.createConnectionOperationCallable().futureCall(request);
   *   // Do something.
   *   Connection response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateConnectionRequest, Connection, OperationMetadata>
      createConnectionOperationCallable() {
    return stub.createConnectionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Connection in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   CreateConnectionRequest request =
   *       CreateConnectionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setConnectionId("connectionId1923106969")
   *           .setConnection(Connection.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       developerConnectClient.createConnectionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateConnectionRequest, Operation> createConnectionCallable() {
    return stub.createConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   Connection connection = Connection.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Connection response =
   *       developerConnectClient.updateConnectionAsync(connection, updateMask).get();
   * }
   * }</pre>
   *
   * @param connection Required. The resource being updated
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Connection resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Connection, OperationMetadata> updateConnectionAsync(
      Connection connection, FieldMask updateMask) {
    UpdateConnectionRequest request =
        UpdateConnectionRequest.newBuilder()
            .setConnection(connection)
            .setUpdateMask(updateMask)
            .build();
    return updateConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   UpdateConnectionRequest request =
   *       UpdateConnectionRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setConnection(Connection.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   Connection response = developerConnectClient.updateConnectionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Connection, OperationMetadata> updateConnectionAsync(
      UpdateConnectionRequest request) {
    return updateConnectionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   UpdateConnectionRequest request =
   *       UpdateConnectionRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setConnection(Connection.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Connection, OperationMetadata> future =
   *       developerConnectClient.updateConnectionOperationCallable().futureCall(request);
   *   // Do something.
   *   Connection response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateConnectionRequest, Connection, OperationMetadata>
      updateConnectionOperationCallable() {
    return stub.updateConnectionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   UpdateConnectionRequest request =
   *       UpdateConnectionRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setConnection(Connection.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       developerConnectClient.updateConnectionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateConnectionRequest, Operation> updateConnectionCallable() {
    return stub.updateConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   ConnectionName name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
   *   developerConnectClient.deleteConnectionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteConnectionAsync(
      ConnectionName name) {
    DeleteConnectionRequest request =
        DeleteConnectionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   String name = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString();
   *   developerConnectClient.deleteConnectionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteConnectionAsync(String name) {
    DeleteConnectionRequest request = DeleteConnectionRequest.newBuilder().setName(name).build();
    return deleteConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   DeleteConnectionRequest request =
   *       DeleteConnectionRequest.newBuilder()
   *           .setName(ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   developerConnectClient.deleteConnectionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteConnectionAsync(
      DeleteConnectionRequest request) {
    return deleteConnectionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   DeleteConnectionRequest request =
   *       DeleteConnectionRequest.newBuilder()
   *           .setName(ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       developerConnectClient.deleteConnectionOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteConnectionRequest, Empty, OperationMetadata>
      deleteConnectionOperationCallable() {
    return stub.deleteConnectionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   DeleteConnectionRequest request =
   *       DeleteConnectionRequest.newBuilder()
   *           .setName(ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       developerConnectClient.deleteConnectionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteConnectionRequest, Operation> deleteConnectionCallable() {
    return stub.deleteConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a GitRepositoryLink. Upon linking a Git Repository, Developer Connect will configure
   * the Git Repository to send webhook events to Developer Connect. Connections that use Firebase
   * GitHub Application will have events forwarded to the Firebase service. All other Connections
   * will have events forwarded to Cloud Build.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   ConnectionName parent = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
   *   GitRepositoryLink gitRepositoryLink = GitRepositoryLink.newBuilder().build();
   *   String gitRepositoryLinkId = "gitRepositoryLinkId684669585";
   *   GitRepositoryLink response =
   *       developerConnectClient
   *           .createGitRepositoryLinkAsync(parent, gitRepositoryLink, gitRepositoryLinkId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param gitRepositoryLink Required. The resource being created
   * @param gitRepositoryLinkId Required. The ID to use for the repository, which will become the
   *     final component of the repository's resource name. This ID should be unique in the
   *     connection. Allows alphanumeric characters and any of -._~%!$&amp;'()&#42;+,;={@literal @}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GitRepositoryLink, OperationMetadata> createGitRepositoryLinkAsync(
      ConnectionName parent, GitRepositoryLink gitRepositoryLink, String gitRepositoryLinkId) {
    CreateGitRepositoryLinkRequest request =
        CreateGitRepositoryLinkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGitRepositoryLink(gitRepositoryLink)
            .setGitRepositoryLinkId(gitRepositoryLinkId)
            .build();
    return createGitRepositoryLinkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a GitRepositoryLink. Upon linking a Git Repository, Developer Connect will configure
   * the Git Repository to send webhook events to Developer Connect. Connections that use Firebase
   * GitHub Application will have events forwarded to the Firebase service. All other Connections
   * will have events forwarded to Cloud Build.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   String parent = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString();
   *   GitRepositoryLink gitRepositoryLink = GitRepositoryLink.newBuilder().build();
   *   String gitRepositoryLinkId = "gitRepositoryLinkId684669585";
   *   GitRepositoryLink response =
   *       developerConnectClient
   *           .createGitRepositoryLinkAsync(parent, gitRepositoryLink, gitRepositoryLinkId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param gitRepositoryLink Required. The resource being created
   * @param gitRepositoryLinkId Required. The ID to use for the repository, which will become the
   *     final component of the repository's resource name. This ID should be unique in the
   *     connection. Allows alphanumeric characters and any of -._~%!$&amp;'()&#42;+,;={@literal @}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GitRepositoryLink, OperationMetadata> createGitRepositoryLinkAsync(
      String parent, GitRepositoryLink gitRepositoryLink, String gitRepositoryLinkId) {
    CreateGitRepositoryLinkRequest request =
        CreateGitRepositoryLinkRequest.newBuilder()
            .setParent(parent)
            .setGitRepositoryLink(gitRepositoryLink)
            .setGitRepositoryLinkId(gitRepositoryLinkId)
            .build();
    return createGitRepositoryLinkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a GitRepositoryLink. Upon linking a Git Repository, Developer Connect will configure
   * the Git Repository to send webhook events to Developer Connect. Connections that use Firebase
   * GitHub Application will have events forwarded to the Firebase service. All other Connections
   * will have events forwarded to Cloud Build.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   CreateGitRepositoryLinkRequest request =
   *       CreateGitRepositoryLinkRequest.newBuilder()
   *           .setParent(ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
   *           .setGitRepositoryLink(GitRepositoryLink.newBuilder().build())
   *           .setGitRepositoryLinkId("gitRepositoryLinkId684669585")
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   GitRepositoryLink response =
   *       developerConnectClient.createGitRepositoryLinkAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GitRepositoryLink, OperationMetadata> createGitRepositoryLinkAsync(
      CreateGitRepositoryLinkRequest request) {
    return createGitRepositoryLinkOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a GitRepositoryLink. Upon linking a Git Repository, Developer Connect will configure
   * the Git Repository to send webhook events to Developer Connect. Connections that use Firebase
   * GitHub Application will have events forwarded to the Firebase service. All other Connections
   * will have events forwarded to Cloud Build.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   CreateGitRepositoryLinkRequest request =
   *       CreateGitRepositoryLinkRequest.newBuilder()
   *           .setParent(ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
   *           .setGitRepositoryLink(GitRepositoryLink.newBuilder().build())
   *           .setGitRepositoryLinkId("gitRepositoryLinkId684669585")
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<GitRepositoryLink, OperationMetadata> future =
   *       developerConnectClient.createGitRepositoryLinkOperationCallable().futureCall(request);
   *   // Do something.
   *   GitRepositoryLink response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateGitRepositoryLinkRequest, GitRepositoryLink, OperationMetadata>
      createGitRepositoryLinkOperationCallable() {
    return stub.createGitRepositoryLinkOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a GitRepositoryLink. Upon linking a Git Repository, Developer Connect will configure
   * the Git Repository to send webhook events to Developer Connect. Connections that use Firebase
   * GitHub Application will have events forwarded to the Firebase service. All other Connections
   * will have events forwarded to Cloud Build.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   CreateGitRepositoryLinkRequest request =
   *       CreateGitRepositoryLinkRequest.newBuilder()
   *           .setParent(ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
   *           .setGitRepositoryLink(GitRepositoryLink.newBuilder().build())
   *           .setGitRepositoryLinkId("gitRepositoryLinkId684669585")
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       developerConnectClient.createGitRepositoryLinkCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateGitRepositoryLinkRequest, Operation>
      createGitRepositoryLinkCallable() {
    return stub.createGitRepositoryLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single GitRepositoryLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   GitRepositoryLinkName name =
   *       GitRepositoryLinkName.of(
   *           "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]");
   *   developerConnectClient.deleteGitRepositoryLinkAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGitRepositoryLinkAsync(
      GitRepositoryLinkName name) {
    DeleteGitRepositoryLinkRequest request =
        DeleteGitRepositoryLinkRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteGitRepositoryLinkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single GitRepositoryLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   String name =
   *       GitRepositoryLinkName.of(
   *               "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]")
   *           .toString();
   *   developerConnectClient.deleteGitRepositoryLinkAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGitRepositoryLinkAsync(String name) {
    DeleteGitRepositoryLinkRequest request =
        DeleteGitRepositoryLinkRequest.newBuilder().setName(name).build();
    return deleteGitRepositoryLinkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single GitRepositoryLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   DeleteGitRepositoryLinkRequest request =
   *       DeleteGitRepositoryLinkRequest.newBuilder()
   *           .setName(
   *               GitRepositoryLinkName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   developerConnectClient.deleteGitRepositoryLinkAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGitRepositoryLinkAsync(
      DeleteGitRepositoryLinkRequest request) {
    return deleteGitRepositoryLinkOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single GitRepositoryLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   DeleteGitRepositoryLinkRequest request =
   *       DeleteGitRepositoryLinkRequest.newBuilder()
   *           .setName(
   *               GitRepositoryLinkName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       developerConnectClient.deleteGitRepositoryLinkOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteGitRepositoryLinkRequest, Empty, OperationMetadata>
      deleteGitRepositoryLinkOperationCallable() {
    return stub.deleteGitRepositoryLinkOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single GitRepositoryLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   DeleteGitRepositoryLinkRequest request =
   *       DeleteGitRepositoryLinkRequest.newBuilder()
   *           .setName(
   *               GitRepositoryLinkName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       developerConnectClient.deleteGitRepositoryLinkCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGitRepositoryLinkRequest, Operation>
      deleteGitRepositoryLinkCallable() {
    return stub.deleteGitRepositoryLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GitRepositoryLinks in a given project, location, and connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   ConnectionName parent = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
   *   for (GitRepositoryLink element :
   *       developerConnectClient.listGitRepositoryLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListGitRepositoryLinksRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGitRepositoryLinksPagedResponse listGitRepositoryLinks(ConnectionName parent) {
    ListGitRepositoryLinksRequest request =
        ListGitRepositoryLinksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listGitRepositoryLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GitRepositoryLinks in a given project, location, and connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   String parent = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString();
   *   for (GitRepositoryLink element :
   *       developerConnectClient.listGitRepositoryLinks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListGitRepositoryLinksRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGitRepositoryLinksPagedResponse listGitRepositoryLinks(String parent) {
    ListGitRepositoryLinksRequest request =
        ListGitRepositoryLinksRequest.newBuilder().setParent(parent).build();
    return listGitRepositoryLinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GitRepositoryLinks in a given project, location, and connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   ListGitRepositoryLinksRequest request =
   *       ListGitRepositoryLinksRequest.newBuilder()
   *           .setParent(ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (GitRepositoryLink element :
   *       developerConnectClient.listGitRepositoryLinks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGitRepositoryLinksPagedResponse listGitRepositoryLinks(
      ListGitRepositoryLinksRequest request) {
    return listGitRepositoryLinksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GitRepositoryLinks in a given project, location, and connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   ListGitRepositoryLinksRequest request =
   *       ListGitRepositoryLinksRequest.newBuilder()
   *           .setParent(ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<GitRepositoryLink> future =
   *       developerConnectClient.listGitRepositoryLinksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (GitRepositoryLink element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGitRepositoryLinksRequest, ListGitRepositoryLinksPagedResponse>
      listGitRepositoryLinksPagedCallable() {
    return stub.listGitRepositoryLinksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GitRepositoryLinks in a given project, location, and connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   ListGitRepositoryLinksRequest request =
   *       ListGitRepositoryLinksRequest.newBuilder()
   *           .setParent(ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListGitRepositoryLinksResponse response =
   *         developerConnectClient.listGitRepositoryLinksCallable().call(request);
   *     for (GitRepositoryLink element : response.getGitRepositoryLinksList()) {
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
  public final UnaryCallable<ListGitRepositoryLinksRequest, ListGitRepositoryLinksResponse>
      listGitRepositoryLinksCallable() {
    return stub.listGitRepositoryLinksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single GitRepositoryLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   GitRepositoryLinkName name =
   *       GitRepositoryLinkName.of(
   *           "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]");
   *   GitRepositoryLink response = developerConnectClient.getGitRepositoryLink(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GitRepositoryLink getGitRepositoryLink(GitRepositoryLinkName name) {
    GetGitRepositoryLinkRequest request =
        GetGitRepositoryLinkRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getGitRepositoryLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single GitRepositoryLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   String name =
   *       GitRepositoryLinkName.of(
   *               "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]")
   *           .toString();
   *   GitRepositoryLink response = developerConnectClient.getGitRepositoryLink(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GitRepositoryLink getGitRepositoryLink(String name) {
    GetGitRepositoryLinkRequest request =
        GetGitRepositoryLinkRequest.newBuilder().setName(name).build();
    return getGitRepositoryLink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single GitRepositoryLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   GetGitRepositoryLinkRequest request =
   *       GetGitRepositoryLinkRequest.newBuilder()
   *           .setName(
   *               GitRepositoryLinkName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]")
   *                   .toString())
   *           .build();
   *   GitRepositoryLink response = developerConnectClient.getGitRepositoryLink(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GitRepositoryLink getGitRepositoryLink(GetGitRepositoryLinkRequest request) {
    return getGitRepositoryLinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single GitRepositoryLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   GetGitRepositoryLinkRequest request =
   *       GetGitRepositoryLinkRequest.newBuilder()
   *           .setName(
   *               GitRepositoryLinkName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]")
   *                   .toString())
   *           .build();
   *   ApiFuture<GitRepositoryLink> future =
   *       developerConnectClient.getGitRepositoryLinkCallable().futureCall(request);
   *   // Do something.
   *   GitRepositoryLink response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGitRepositoryLinkRequest, GitRepositoryLink>
      getGitRepositoryLinkCallable() {
    return stub.getGitRepositoryLinkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches read/write token of a given gitRepositoryLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   GitRepositoryLinkName gitRepositoryLink =
   *       GitRepositoryLinkName.of(
   *           "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]");
   *   FetchReadWriteTokenResponse response =
   *       developerConnectClient.fetchReadWriteToken(gitRepositoryLink);
   * }
   * }</pre>
   *
   * @param gitRepositoryLink Required. The resource name of the gitRepositoryLink in the format
   *     `projects/&#42;/locations/&#42;/connections/&#42;/gitRepositoryLinks/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchReadWriteTokenResponse fetchReadWriteToken(
      GitRepositoryLinkName gitRepositoryLink) {
    FetchReadWriteTokenRequest request =
        FetchReadWriteTokenRequest.newBuilder()
            .setGitRepositoryLink(gitRepositoryLink == null ? null : gitRepositoryLink.toString())
            .build();
    return fetchReadWriteToken(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches read/write token of a given gitRepositoryLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   String gitRepositoryLink =
   *       GitRepositoryLinkName.of(
   *               "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]")
   *           .toString();
   *   FetchReadWriteTokenResponse response =
   *       developerConnectClient.fetchReadWriteToken(gitRepositoryLink);
   * }
   * }</pre>
   *
   * @param gitRepositoryLink Required. The resource name of the gitRepositoryLink in the format
   *     `projects/&#42;/locations/&#42;/connections/&#42;/gitRepositoryLinks/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchReadWriteTokenResponse fetchReadWriteToken(String gitRepositoryLink) {
    FetchReadWriteTokenRequest request =
        FetchReadWriteTokenRequest.newBuilder().setGitRepositoryLink(gitRepositoryLink).build();
    return fetchReadWriteToken(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches read/write token of a given gitRepositoryLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   FetchReadWriteTokenRequest request =
   *       FetchReadWriteTokenRequest.newBuilder()
   *           .setGitRepositoryLink(
   *               GitRepositoryLinkName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]")
   *                   .toString())
   *           .build();
   *   FetchReadWriteTokenResponse response = developerConnectClient.fetchReadWriteToken(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchReadWriteTokenResponse fetchReadWriteToken(FetchReadWriteTokenRequest request) {
    return fetchReadWriteTokenCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches read/write token of a given gitRepositoryLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   FetchReadWriteTokenRequest request =
   *       FetchReadWriteTokenRequest.newBuilder()
   *           .setGitRepositoryLink(
   *               GitRepositoryLinkName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]")
   *                   .toString())
   *           .build();
   *   ApiFuture<FetchReadWriteTokenResponse> future =
   *       developerConnectClient.fetchReadWriteTokenCallable().futureCall(request);
   *   // Do something.
   *   FetchReadWriteTokenResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>
      fetchReadWriteTokenCallable() {
    return stub.fetchReadWriteTokenCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches read token of a given gitRepositoryLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   GitRepositoryLinkName gitRepositoryLink =
   *       GitRepositoryLinkName.of(
   *           "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]");
   *   FetchReadTokenResponse response = developerConnectClient.fetchReadToken(gitRepositoryLink);
   * }
   * }</pre>
   *
   * @param gitRepositoryLink Required. The resource name of the gitRepositoryLink in the format
   *     `projects/&#42;/locations/&#42;/connections/&#42;/gitRepositoryLinks/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchReadTokenResponse fetchReadToken(GitRepositoryLinkName gitRepositoryLink) {
    FetchReadTokenRequest request =
        FetchReadTokenRequest.newBuilder()
            .setGitRepositoryLink(gitRepositoryLink == null ? null : gitRepositoryLink.toString())
            .build();
    return fetchReadToken(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches read token of a given gitRepositoryLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   String gitRepositoryLink =
   *       GitRepositoryLinkName.of(
   *               "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]")
   *           .toString();
   *   FetchReadTokenResponse response = developerConnectClient.fetchReadToken(gitRepositoryLink);
   * }
   * }</pre>
   *
   * @param gitRepositoryLink Required. The resource name of the gitRepositoryLink in the format
   *     `projects/&#42;/locations/&#42;/connections/&#42;/gitRepositoryLinks/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchReadTokenResponse fetchReadToken(String gitRepositoryLink) {
    FetchReadTokenRequest request =
        FetchReadTokenRequest.newBuilder().setGitRepositoryLink(gitRepositoryLink).build();
    return fetchReadToken(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches read token of a given gitRepositoryLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   FetchReadTokenRequest request =
   *       FetchReadTokenRequest.newBuilder()
   *           .setGitRepositoryLink(
   *               GitRepositoryLinkName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]")
   *                   .toString())
   *           .build();
   *   FetchReadTokenResponse response = developerConnectClient.fetchReadToken(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchReadTokenResponse fetchReadToken(FetchReadTokenRequest request) {
    return fetchReadTokenCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches read token of a given gitRepositoryLink.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   FetchReadTokenRequest request =
   *       FetchReadTokenRequest.newBuilder()
   *           .setGitRepositoryLink(
   *               GitRepositoryLinkName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]")
   *                   .toString())
   *           .build();
   *   ApiFuture<FetchReadTokenResponse> future =
   *       developerConnectClient.fetchReadTokenCallable().futureCall(request);
   *   // Do something.
   *   FetchReadTokenResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchReadTokenRequest, FetchReadTokenResponse>
      fetchReadTokenCallable() {
    return stub.fetchReadTokenCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * FetchLinkableGitRepositories returns a list of git repositories from an SCM that are available
   * to be added to a Connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   ConnectionName connection = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
   *   for (LinkableGitRepository element :
   *       developerConnectClient.fetchLinkableGitRepositories(connection).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param connection Required. The name of the Connection. Format:
   *     `projects/&#42;/locations/&#42;/connections/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchLinkableGitRepositoriesPagedResponse fetchLinkableGitRepositories(
      ConnectionName connection) {
    FetchLinkableGitRepositoriesRequest request =
        FetchLinkableGitRepositoriesRequest.newBuilder()
            .setConnection(connection == null ? null : connection.toString())
            .build();
    return fetchLinkableGitRepositories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * FetchLinkableGitRepositories returns a list of git repositories from an SCM that are available
   * to be added to a Connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   String connection = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString();
   *   for (LinkableGitRepository element :
   *       developerConnectClient.fetchLinkableGitRepositories(connection).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param connection Required. The name of the Connection. Format:
   *     `projects/&#42;/locations/&#42;/connections/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchLinkableGitRepositoriesPagedResponse fetchLinkableGitRepositories(
      String connection) {
    FetchLinkableGitRepositoriesRequest request =
        FetchLinkableGitRepositoriesRequest.newBuilder().setConnection(connection).build();
    return fetchLinkableGitRepositories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * FetchLinkableGitRepositories returns a list of git repositories from an SCM that are available
   * to be added to a Connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   FetchLinkableGitRepositoriesRequest request =
   *       FetchLinkableGitRepositoriesRequest.newBuilder()
   *           .setConnection(
   *               ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (LinkableGitRepository element :
   *       developerConnectClient.fetchLinkableGitRepositories(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchLinkableGitRepositoriesPagedResponse fetchLinkableGitRepositories(
      FetchLinkableGitRepositoriesRequest request) {
    return fetchLinkableGitRepositoriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * FetchLinkableGitRepositories returns a list of git repositories from an SCM that are available
   * to be added to a Connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   FetchLinkableGitRepositoriesRequest request =
   *       FetchLinkableGitRepositoriesRequest.newBuilder()
   *           .setConnection(
   *               ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<LinkableGitRepository> future =
   *       developerConnectClient.fetchLinkableGitRepositoriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LinkableGitRepository element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          FetchLinkableGitRepositoriesRequest, FetchLinkableGitRepositoriesPagedResponse>
      fetchLinkableGitRepositoriesPagedCallable() {
    return stub.fetchLinkableGitRepositoriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * FetchLinkableGitRepositories returns a list of git repositories from an SCM that are available
   * to be added to a Connection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   FetchLinkableGitRepositoriesRequest request =
   *       FetchLinkableGitRepositoriesRequest.newBuilder()
   *           .setConnection(
   *               ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     FetchLinkableGitRepositoriesResponse response =
   *         developerConnectClient.fetchLinkableGitRepositoriesCallable().call(request);
   *     for (LinkableGitRepository element : response.getLinkableGitRepositoriesList()) {
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
  public final UnaryCallable<
          FetchLinkableGitRepositoriesRequest, FetchLinkableGitRepositoriesResponse>
      fetchLinkableGitRepositoriesCallable() {
    return stub.fetchLinkableGitRepositoriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * FetchGitHubInstallations returns the list of GitHub Installations that are available to be
   * added to a Connection. For github.com, only installations accessible to the authorizer token
   * are returned. For GitHub Enterprise, all installations are returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   ConnectionName connection = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]");
   *   FetchGitHubInstallationsResponse response =
   *       developerConnectClient.fetchGitHubInstallations(connection);
   * }
   * }</pre>
   *
   * @param connection Required. The resource name of the connection in the format
   *     `projects/&#42;/locations/&#42;/connections/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchGitHubInstallationsResponse fetchGitHubInstallations(
      ConnectionName connection) {
    FetchGitHubInstallationsRequest request =
        FetchGitHubInstallationsRequest.newBuilder()
            .setConnection(connection == null ? null : connection.toString())
            .build();
    return fetchGitHubInstallations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * FetchGitHubInstallations returns the list of GitHub Installations that are available to be
   * added to a Connection. For github.com, only installations accessible to the authorizer token
   * are returned. For GitHub Enterprise, all installations are returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   String connection = ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString();
   *   FetchGitHubInstallationsResponse response =
   *       developerConnectClient.fetchGitHubInstallations(connection);
   * }
   * }</pre>
   *
   * @param connection Required. The resource name of the connection in the format
   *     `projects/&#42;/locations/&#42;/connections/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchGitHubInstallationsResponse fetchGitHubInstallations(String connection) {
    FetchGitHubInstallationsRequest request =
        FetchGitHubInstallationsRequest.newBuilder().setConnection(connection).build();
    return fetchGitHubInstallations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * FetchGitHubInstallations returns the list of GitHub Installations that are available to be
   * added to a Connection. For github.com, only installations accessible to the authorizer token
   * are returned. For GitHub Enterprise, all installations are returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   FetchGitHubInstallationsRequest request =
   *       FetchGitHubInstallationsRequest.newBuilder()
   *           .setConnection(
   *               ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
   *           .build();
   *   FetchGitHubInstallationsResponse response =
   *       developerConnectClient.fetchGitHubInstallations(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchGitHubInstallationsResponse fetchGitHubInstallations(
      FetchGitHubInstallationsRequest request) {
    return fetchGitHubInstallationsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * FetchGitHubInstallations returns the list of GitHub Installations that are available to be
   * added to a Connection. For github.com, only installations accessible to the authorizer token
   * are returned. For GitHub Enterprise, all installations are returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   FetchGitHubInstallationsRequest request =
   *       FetchGitHubInstallationsRequest.newBuilder()
   *           .setConnection(
   *               ConnectionName.of("[PROJECT]", "[LOCATION]", "[CONNECTION]").toString())
   *           .build();
   *   ApiFuture<FetchGitHubInstallationsResponse> future =
   *       developerConnectClient.fetchGitHubInstallationsCallable().futureCall(request);
   *   // Do something.
   *   FetchGitHubInstallationsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchGitHubInstallationsRequest, FetchGitHubInstallationsResponse>
      fetchGitHubInstallationsCallable() {
    return stub.fetchGitHubInstallationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch the list of branches or tags for a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   GitRepositoryLinkName gitRepositoryLink =
   *       GitRepositoryLinkName.of(
   *           "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]");
   *   FetchGitRefsRequest.RefType refType = FetchGitRefsRequest.RefType.forNumber(0);
   *   for (String element :
   *       developerConnectClient.fetchGitRefs(gitRepositoryLink, refType).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param gitRepositoryLink Required. The resource name of GitRepositoryLink in the format
   *     `projects/&#42;/locations/&#42;/connections/&#42;/gitRepositoryLinks/&#42;`.
   * @param refType Required. Type of refs to fetch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchGitRefsPagedResponse fetchGitRefs(
      GitRepositoryLinkName gitRepositoryLink, FetchGitRefsRequest.RefType refType) {
    FetchGitRefsRequest request =
        FetchGitRefsRequest.newBuilder()
            .setGitRepositoryLink(gitRepositoryLink == null ? null : gitRepositoryLink.toString())
            .setRefType(refType)
            .build();
    return fetchGitRefs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch the list of branches or tags for a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   String gitRepositoryLink =
   *       GitRepositoryLinkName.of(
   *               "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]")
   *           .toString();
   *   FetchGitRefsRequest.RefType refType = FetchGitRefsRequest.RefType.forNumber(0);
   *   for (String element :
   *       developerConnectClient.fetchGitRefs(gitRepositoryLink, refType).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param gitRepositoryLink Required. The resource name of GitRepositoryLink in the format
   *     `projects/&#42;/locations/&#42;/connections/&#42;/gitRepositoryLinks/&#42;`.
   * @param refType Required. Type of refs to fetch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchGitRefsPagedResponse fetchGitRefs(
      String gitRepositoryLink, FetchGitRefsRequest.RefType refType) {
    FetchGitRefsRequest request =
        FetchGitRefsRequest.newBuilder()
            .setGitRepositoryLink(gitRepositoryLink)
            .setRefType(refType)
            .build();
    return fetchGitRefs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch the list of branches or tags for a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   FetchGitRefsRequest request =
   *       FetchGitRefsRequest.newBuilder()
   *           .setGitRepositoryLink(
   *               GitRepositoryLinkName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (String element : developerConnectClient.fetchGitRefs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchGitRefsPagedResponse fetchGitRefs(FetchGitRefsRequest request) {
    return fetchGitRefsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch the list of branches or tags for a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   FetchGitRefsRequest request =
   *       FetchGitRefsRequest.newBuilder()
   *           .setGitRepositoryLink(
   *               GitRepositoryLinkName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<String> future =
   *       developerConnectClient.fetchGitRefsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (String element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchGitRefsRequest, FetchGitRefsPagedResponse>
      fetchGitRefsPagedCallable() {
    return stub.fetchGitRefsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch the list of branches or tags for a given repository.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   FetchGitRefsRequest request =
   *       FetchGitRefsRequest.newBuilder()
   *           .setGitRepositoryLink(
   *               GitRepositoryLinkName.of(
   *                       "[PROJECT]", "[LOCATION]", "[CONNECTION]", "[GIT_REPOSITORY_LINK]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     FetchGitRefsResponse response = developerConnectClient.fetchGitRefsCallable().call(request);
   *     for (String element : response.getRefNamesList()) {
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
  public final UnaryCallable<FetchGitRefsRequest, FetchGitRefsResponse> fetchGitRefsCallable() {
    return stub.fetchGitRefsCallable();
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
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : developerConnectClient.listLocations(request).iterateAll()) {
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
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       developerConnectClient.listLocationsPagedCallable().futureCall(request);
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
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         developerConnectClient.listLocationsCallable().call(request);
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
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = developerConnectClient.getLocation(request);
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
   * try (DeveloperConnectClient developerConnectClient = DeveloperConnectClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = developerConnectClient.getLocationCallable().futureCall(request);
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

  public static class ListConnectionsPagedResponse
      extends AbstractPagedListResponse<
          ListConnectionsRequest,
          ListConnectionsResponse,
          Connection,
          ListConnectionsPage,
          ListConnectionsFixedSizeCollection> {

    public static ApiFuture<ListConnectionsPagedResponse> createAsync(
        PageContext<ListConnectionsRequest, ListConnectionsResponse, Connection> context,
        ApiFuture<ListConnectionsResponse> futureResponse) {
      ApiFuture<ListConnectionsPage> futurePage =
          ListConnectionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListConnectionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListConnectionsPagedResponse(ListConnectionsPage page) {
      super(page, ListConnectionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListConnectionsPage
      extends AbstractPage<
          ListConnectionsRequest, ListConnectionsResponse, Connection, ListConnectionsPage> {

    private ListConnectionsPage(
        PageContext<ListConnectionsRequest, ListConnectionsResponse, Connection> context,
        ListConnectionsResponse response) {
      super(context, response);
    }

    private static ListConnectionsPage createEmptyPage() {
      return new ListConnectionsPage(null, null);
    }

    @Override
    protected ListConnectionsPage createPage(
        PageContext<ListConnectionsRequest, ListConnectionsResponse, Connection> context,
        ListConnectionsResponse response) {
      return new ListConnectionsPage(context, response);
    }

    @Override
    public ApiFuture<ListConnectionsPage> createPageAsync(
        PageContext<ListConnectionsRequest, ListConnectionsResponse, Connection> context,
        ApiFuture<ListConnectionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListConnectionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListConnectionsRequest,
          ListConnectionsResponse,
          Connection,
          ListConnectionsPage,
          ListConnectionsFixedSizeCollection> {

    private ListConnectionsFixedSizeCollection(
        List<ListConnectionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListConnectionsFixedSizeCollection createEmptyCollection() {
      return new ListConnectionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListConnectionsFixedSizeCollection createCollection(
        List<ListConnectionsPage> pages, int collectionSize) {
      return new ListConnectionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListGitRepositoryLinksPagedResponse
      extends AbstractPagedListResponse<
          ListGitRepositoryLinksRequest,
          ListGitRepositoryLinksResponse,
          GitRepositoryLink,
          ListGitRepositoryLinksPage,
          ListGitRepositoryLinksFixedSizeCollection> {

    public static ApiFuture<ListGitRepositoryLinksPagedResponse> createAsync(
        PageContext<
                ListGitRepositoryLinksRequest, ListGitRepositoryLinksResponse, GitRepositoryLink>
            context,
        ApiFuture<ListGitRepositoryLinksResponse> futureResponse) {
      ApiFuture<ListGitRepositoryLinksPage> futurePage =
          ListGitRepositoryLinksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListGitRepositoryLinksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListGitRepositoryLinksPagedResponse(ListGitRepositoryLinksPage page) {
      super(page, ListGitRepositoryLinksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGitRepositoryLinksPage
      extends AbstractPage<
          ListGitRepositoryLinksRequest,
          ListGitRepositoryLinksResponse,
          GitRepositoryLink,
          ListGitRepositoryLinksPage> {

    private ListGitRepositoryLinksPage(
        PageContext<
                ListGitRepositoryLinksRequest, ListGitRepositoryLinksResponse, GitRepositoryLink>
            context,
        ListGitRepositoryLinksResponse response) {
      super(context, response);
    }

    private static ListGitRepositoryLinksPage createEmptyPage() {
      return new ListGitRepositoryLinksPage(null, null);
    }

    @Override
    protected ListGitRepositoryLinksPage createPage(
        PageContext<
                ListGitRepositoryLinksRequest, ListGitRepositoryLinksResponse, GitRepositoryLink>
            context,
        ListGitRepositoryLinksResponse response) {
      return new ListGitRepositoryLinksPage(context, response);
    }

    @Override
    public ApiFuture<ListGitRepositoryLinksPage> createPageAsync(
        PageContext<
                ListGitRepositoryLinksRequest, ListGitRepositoryLinksResponse, GitRepositoryLink>
            context,
        ApiFuture<ListGitRepositoryLinksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGitRepositoryLinksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGitRepositoryLinksRequest,
          ListGitRepositoryLinksResponse,
          GitRepositoryLink,
          ListGitRepositoryLinksPage,
          ListGitRepositoryLinksFixedSizeCollection> {

    private ListGitRepositoryLinksFixedSizeCollection(
        List<ListGitRepositoryLinksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGitRepositoryLinksFixedSizeCollection createEmptyCollection() {
      return new ListGitRepositoryLinksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGitRepositoryLinksFixedSizeCollection createCollection(
        List<ListGitRepositoryLinksPage> pages, int collectionSize) {
      return new ListGitRepositoryLinksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class FetchLinkableGitRepositoriesPagedResponse
      extends AbstractPagedListResponse<
          FetchLinkableGitRepositoriesRequest,
          FetchLinkableGitRepositoriesResponse,
          LinkableGitRepository,
          FetchLinkableGitRepositoriesPage,
          FetchLinkableGitRepositoriesFixedSizeCollection> {

    public static ApiFuture<FetchLinkableGitRepositoriesPagedResponse> createAsync(
        PageContext<
                FetchLinkableGitRepositoriesRequest,
                FetchLinkableGitRepositoriesResponse,
                LinkableGitRepository>
            context,
        ApiFuture<FetchLinkableGitRepositoriesResponse> futureResponse) {
      ApiFuture<FetchLinkableGitRepositoriesPage> futurePage =
          FetchLinkableGitRepositoriesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new FetchLinkableGitRepositoriesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private FetchLinkableGitRepositoriesPagedResponse(FetchLinkableGitRepositoriesPage page) {
      super(page, FetchLinkableGitRepositoriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class FetchLinkableGitRepositoriesPage
      extends AbstractPage<
          FetchLinkableGitRepositoriesRequest,
          FetchLinkableGitRepositoriesResponse,
          LinkableGitRepository,
          FetchLinkableGitRepositoriesPage> {

    private FetchLinkableGitRepositoriesPage(
        PageContext<
                FetchLinkableGitRepositoriesRequest,
                FetchLinkableGitRepositoriesResponse,
                LinkableGitRepository>
            context,
        FetchLinkableGitRepositoriesResponse response) {
      super(context, response);
    }

    private static FetchLinkableGitRepositoriesPage createEmptyPage() {
      return new FetchLinkableGitRepositoriesPage(null, null);
    }

    @Override
    protected FetchLinkableGitRepositoriesPage createPage(
        PageContext<
                FetchLinkableGitRepositoriesRequest,
                FetchLinkableGitRepositoriesResponse,
                LinkableGitRepository>
            context,
        FetchLinkableGitRepositoriesResponse response) {
      return new FetchLinkableGitRepositoriesPage(context, response);
    }

    @Override
    public ApiFuture<FetchLinkableGitRepositoriesPage> createPageAsync(
        PageContext<
                FetchLinkableGitRepositoriesRequest,
                FetchLinkableGitRepositoriesResponse,
                LinkableGitRepository>
            context,
        ApiFuture<FetchLinkableGitRepositoriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class FetchLinkableGitRepositoriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          FetchLinkableGitRepositoriesRequest,
          FetchLinkableGitRepositoriesResponse,
          LinkableGitRepository,
          FetchLinkableGitRepositoriesPage,
          FetchLinkableGitRepositoriesFixedSizeCollection> {

    private FetchLinkableGitRepositoriesFixedSizeCollection(
        List<FetchLinkableGitRepositoriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static FetchLinkableGitRepositoriesFixedSizeCollection createEmptyCollection() {
      return new FetchLinkableGitRepositoriesFixedSizeCollection(null, 0);
    }

    @Override
    protected FetchLinkableGitRepositoriesFixedSizeCollection createCollection(
        List<FetchLinkableGitRepositoriesPage> pages, int collectionSize) {
      return new FetchLinkableGitRepositoriesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class FetchGitRefsPagedResponse
      extends AbstractPagedListResponse<
          FetchGitRefsRequest,
          FetchGitRefsResponse,
          String,
          FetchGitRefsPage,
          FetchGitRefsFixedSizeCollection> {

    public static ApiFuture<FetchGitRefsPagedResponse> createAsync(
        PageContext<FetchGitRefsRequest, FetchGitRefsResponse, String> context,
        ApiFuture<FetchGitRefsResponse> futureResponse) {
      ApiFuture<FetchGitRefsPage> futurePage =
          FetchGitRefsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new FetchGitRefsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private FetchGitRefsPagedResponse(FetchGitRefsPage page) {
      super(page, FetchGitRefsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class FetchGitRefsPage
      extends AbstractPage<FetchGitRefsRequest, FetchGitRefsResponse, String, FetchGitRefsPage> {

    private FetchGitRefsPage(
        PageContext<FetchGitRefsRequest, FetchGitRefsResponse, String> context,
        FetchGitRefsResponse response) {
      super(context, response);
    }

    private static FetchGitRefsPage createEmptyPage() {
      return new FetchGitRefsPage(null, null);
    }

    @Override
    protected FetchGitRefsPage createPage(
        PageContext<FetchGitRefsRequest, FetchGitRefsResponse, String> context,
        FetchGitRefsResponse response) {
      return new FetchGitRefsPage(context, response);
    }

    @Override
    public ApiFuture<FetchGitRefsPage> createPageAsync(
        PageContext<FetchGitRefsRequest, FetchGitRefsResponse, String> context,
        ApiFuture<FetchGitRefsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class FetchGitRefsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          FetchGitRefsRequest,
          FetchGitRefsResponse,
          String,
          FetchGitRefsPage,
          FetchGitRefsFixedSizeCollection> {

    private FetchGitRefsFixedSizeCollection(List<FetchGitRefsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static FetchGitRefsFixedSizeCollection createEmptyCollection() {
      return new FetchGitRefsFixedSizeCollection(null, 0);
    }

    @Override
    protected FetchGitRefsFixedSizeCollection createCollection(
        List<FetchGitRefsPage> pages, int collectionSize) {
      return new FetchGitRefsFixedSizeCollection(pages, collectionSize);
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
