/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.bigquery.connection.v1beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.bigquery.connection.v1beta1.stub.ConnectionServiceStub;
import com.google.cloud.bigquery.connection.v1beta1.stub.ConnectionServiceStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.UInt32Value;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Manages external data source connections and credentials.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the ConnectionServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 * <p>This class can be customized by passing in a custom instance of ConnectionServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * ConnectionServiceSettings connectionServiceSettings =
 *     ConnectionServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ConnectionServiceClient connectionServiceClient =
 *     ConnectionServiceClient.create(connectionServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * ConnectionServiceSettings connectionServiceSettings =
 *     ConnectionServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ConnectionServiceClient connectionServiceClient =
 *     ConnectionServiceClient.create(connectionServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ConnectionServiceClient implements BackgroundResource {
  private final ConnectionServiceSettings settings;
  private final ConnectionServiceStub stub;

  /** Constructs an instance of ConnectionServiceClient with default settings. */
  public static final ConnectionServiceClient create() throws IOException {
    return create(ConnectionServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ConnectionServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ConnectionServiceClient create(ConnectionServiceSettings settings)
      throws IOException {
    return new ConnectionServiceClient(settings);
  }

  /**
   * Constructs an instance of ConnectionServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(ConnectionServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ConnectionServiceClient create(ConnectionServiceStub stub) {
    return new ConnectionServiceClient(stub);
  }

  /**
   * Constructs an instance of ConnectionServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ConnectionServiceClient(ConnectionServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ConnectionServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ConnectionServiceClient(ConnectionServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ConnectionServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ConnectionServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new connection.
   *
   * @param parent Required. Parent resource name. Must be in the format
   *     `projects/{project_id}/locations/{location_id}`
   * @param connection Required. Connection to create.
   * @param connectionId Optional. Connection id that should be assigned to the created connection.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectionProto.Connection createConnection(
      LocationName parent, ConnectionProto.Connection connection, String connectionId) {
    ConnectionProto.CreateConnectionRequest request =
        ConnectionProto.CreateConnectionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setConnection(connection)
            .setConnectionId(connectionId)
            .build();
    return createConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new connection.
   *
   * @param parent Required. Parent resource name. Must be in the format
   *     `projects/{project_id}/locations/{location_id}`
   * @param connection Required. Connection to create.
   * @param connectionId Optional. Connection id that should be assigned to the created connection.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectionProto.Connection createConnection(
      String parent, ConnectionProto.Connection connection, String connectionId) {
    ConnectionProto.CreateConnectionRequest request =
        ConnectionProto.CreateConnectionRequest.newBuilder()
            .setParent(parent)
            .setConnection(connection)
            .setConnectionId(connectionId)
            .build();
    return createConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new connection.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectionProto.Connection createConnection(
      ConnectionProto.CreateConnectionRequest request) {
    return createConnectionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new connection.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ConnectionProto.CreateConnectionRequest, ConnectionProto.Connection>
      createConnectionCallable() {
    return stub.createConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns specified connection.
   *
   * @param name Required. Name of the requested connection, for example:
   *     `projects/{project_id}/locations/{location_id}/connections/{connection_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectionProto.Connection getConnection(ConnectionName name) {
    ConnectionProto.GetConnectionRequest request =
        ConnectionProto.GetConnectionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns specified connection.
   *
   * @param name Required. Name of the requested connection, for example:
   *     `projects/{project_id}/locations/{location_id}/connections/{connection_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectionProto.Connection getConnection(String name) {
    ConnectionProto.GetConnectionRequest request =
        ConnectionProto.GetConnectionRequest.newBuilder().setName(name).build();
    return getConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns specified connection.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectionProto.Connection getConnection(
      ConnectionProto.GetConnectionRequest request) {
    return getConnectionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns specified connection.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ConnectionProto.GetConnectionRequest, ConnectionProto.Connection>
      getConnectionCallable() {
    return stub.getConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of connections in the given project.
   *
   * @param parent Required. Parent resource name. Must be in the form:
   *     `projects/{project_id}/locations/{location_id}`
   * @param maxResults Required. Maximum number of results per page.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectionProto.ListConnectionsResponse listConnections(
      LocationName parent, UInt32Value maxResults) {
    ConnectionProto.ListConnectionsRequest request =
        ConnectionProto.ListConnectionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMaxResults(maxResults)
            .build();
    return listConnections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of connections in the given project.
   *
   * @param parent Required. Parent resource name. Must be in the form:
   *     `projects/{project_id}/locations/{location_id}`
   * @param maxResults Required. Maximum number of results per page.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectionProto.ListConnectionsResponse listConnections(
      String parent, UInt32Value maxResults) {
    ConnectionProto.ListConnectionsRequest request =
        ConnectionProto.ListConnectionsRequest.newBuilder()
            .setParent(parent)
            .setMaxResults(maxResults)
            .build();
    return listConnections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of connections in the given project.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectionProto.ListConnectionsResponse listConnections(
      ConnectionProto.ListConnectionsRequest request) {
    return listConnectionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of connections in the given project.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<
          ConnectionProto.ListConnectionsRequest, ConnectionProto.ListConnectionsResponse>
      listConnectionsCallable() {
    return stub.listConnectionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified connection. For security reasons, also resets credential if connection
   * properties are in the update field mask.
   *
   * @param name Required. Name of the connection to update, for example:
   *     `projects/{project_id}/locations/{location_id}/connections/{connection_id}`
   * @param connection Required. Connection containing the updated fields.
   * @param updateMask Required. Update mask for the connection fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectionProto.Connection updateConnection(
      ConnectionName name, ConnectionProto.Connection connection, FieldMask updateMask) {
    ConnectionProto.UpdateConnectionRequest request =
        ConnectionProto.UpdateConnectionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setConnection(connection)
            .setUpdateMask(updateMask)
            .build();
    return updateConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified connection. For security reasons, also resets credential if connection
   * properties are in the update field mask.
   *
   * @param name Required. Name of the connection to update, for example:
   *     `projects/{project_id}/locations/{location_id}/connections/{connection_id}`
   * @param connection Required. Connection containing the updated fields.
   * @param updateMask Required. Update mask for the connection fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectionProto.Connection updateConnection(
      String name, ConnectionProto.Connection connection, FieldMask updateMask) {
    ConnectionProto.UpdateConnectionRequest request =
        ConnectionProto.UpdateConnectionRequest.newBuilder()
            .setName(name)
            .setConnection(connection)
            .setUpdateMask(updateMask)
            .build();
    return updateConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified connection. For security reasons, also resets credential if connection
   * properties are in the update field mask.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ConnectionProto.Connection updateConnection(
      ConnectionProto.UpdateConnectionRequest request) {
    return updateConnectionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified connection. For security reasons, also resets credential if connection
   * properties are in the update field mask.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ConnectionProto.UpdateConnectionRequest, ConnectionProto.Connection>
      updateConnectionCallable() {
    return stub.updateConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the credential for the specified connection.
   *
   * @param name Required. Name of the connection, for example:
   *     `projects/{project_id}/locations/{location_id}/connections/{connection_id}/credential`
   * @param credential Required. Credential to use with the connection.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void updateConnectionCredential(
      String name, ConnectionProto.ConnectionCredential credential) {
    ConnectionProto.UpdateConnectionCredentialRequest request =
        ConnectionProto.UpdateConnectionCredentialRequest.newBuilder()
            .setName(name)
            .setCredential(credential)
            .build();
    updateConnectionCredential(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the credential for the specified connection.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void updateConnectionCredential(
      ConnectionProto.UpdateConnectionCredentialRequest request) {
    updateConnectionCredentialCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the credential for the specified connection.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ConnectionProto.UpdateConnectionCredentialRequest, Empty>
      updateConnectionCredentialCallable() {
    return stub.updateConnectionCredentialCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes connection and associated credential.
   *
   * @param name Required. Name of the deleted connection, for example:
   *     `projects/{project_id}/locations/{location_id}/connections/{connection_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConnection(ConnectionName name) {
    ConnectionProto.DeleteConnectionRequest request =
        ConnectionProto.DeleteConnectionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes connection and associated credential.
   *
   * @param name Required. Name of the deleted connection, for example:
   *     `projects/{project_id}/locations/{location_id}/connections/{connection_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConnection(String name) {
    ConnectionProto.DeleteConnectionRequest request =
        ConnectionProto.DeleteConnectionRequest.newBuilder().setName(name).build();
    deleteConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes connection and associated credential.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConnection(ConnectionProto.DeleteConnectionRequest request) {
    deleteConnectionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes connection and associated credential.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ConnectionProto.DeleteConnectionRequest, Empty>
      deleteConnectionCallable() {
    return stub.deleteConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * and does not have a policy set.
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param options OPTIONAL: A `GetPolicyOptions` object for specifying options to `GetIamPolicy`.
   *     This field is only used by Cloud IAM.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(ResourceName resource, GetPolicyOptions options) {
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setOptions(options)
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * and does not have a policy set.
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param options OPTIONAL: A `GetPolicyOptions` object for specifying options to `GetIamPolicy`.
   *     This field is only used by Cloud IAM.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource, GetPolicyOptions options) {
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder().setResource(resource).setOptions(options).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * and does not have a policy set.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policy if the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(ResourceName resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setPolicy(policy)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If the resource does not
   * exist, this will return an empty set of permissions, not a NOT_FOUND error.
   *
   * <p>Note: This operation is designed to be used for building permission-aware UIs and
   * command-line tools, not for authorization checking. This operation may "fail open" without
   * warning.
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      ResourceName resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If the resource does not
   * exist, this will return an empty set of permissions, not a NOT_FOUND error.
   *
   * <p>Note: This operation is designed to be used for building permission-aware UIs and
   * command-line tools, not for authorization checking. This operation may "fail open" without
   * warning.
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      String resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If the resource does not
   * exist, this will return an empty set of permissions, not a NOT_FOUND error.
   *
   * <p>Note: This operation is designed to be used for building permission-aware UIs and
   * command-line tools, not for authorization checking. This operation may "fail open" without
   * warning.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If the resource does not
   * exist, this will return an empty set of permissions, not a NOT_FOUND error.
   *
   * <p>Note: This operation is designed to be used for building permission-aware UIs and
   * command-line tools, not for authorization checking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
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
}
