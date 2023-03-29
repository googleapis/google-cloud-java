/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.oslogin.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.oslogin.common.OsLoginProto;
import com.google.cloud.oslogin.common.PosixAccountName;
import com.google.cloud.oslogin.common.SshPublicKeyName;
import com.google.cloud.oslogin.common.UserName;
import com.google.cloud.oslogin.v1.stub.OsLoginServiceStub;
import com.google.cloud.oslogin.v1.stub.OsLoginServiceStubSettings;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Cloud OS Login API
 *
 * <p>The Cloud OS Login API allows you to manage users and their associated SSH public keys for
 * logging into virtual machines on Google Cloud Platform.
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
 * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
 *   UserName parent = UserName.of("[USER]");
 *   OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
 *   OsLoginProto.SshPublicKey response =
 *       osLoginServiceClient.createSshPublicKey(parent, sshPublicKey);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the OsLoginServiceClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of OsLoginServiceSettings to
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
 * OsLoginServiceSettings osLoginServiceSettings =
 *     OsLoginServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create(osLoginServiceSettings);
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
 * OsLoginServiceSettings osLoginServiceSettings =
 *     OsLoginServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create(osLoginServiceSettings);
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
 * OsLoginServiceSettings osLoginServiceSettings =
 *     OsLoginServiceSettings.newHttpJsonBuilder().build();
 * OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create(osLoginServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class OsLoginServiceClient implements BackgroundResource {
  private final OsLoginServiceSettings settings;
  private final OsLoginServiceStub stub;

  /** Constructs an instance of OsLoginServiceClient with default settings. */
  public static final OsLoginServiceClient create() throws IOException {
    return create(OsLoginServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of OsLoginServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final OsLoginServiceClient create(OsLoginServiceSettings settings)
      throws IOException {
    return new OsLoginServiceClient(settings);
  }

  /**
   * Constructs an instance of OsLoginServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(OsLoginServiceSettings).
   */
  public static final OsLoginServiceClient create(OsLoginServiceStub stub) {
    return new OsLoginServiceClient(stub);
  }

  /**
   * Constructs an instance of OsLoginServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected OsLoginServiceClient(OsLoginServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((OsLoginServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected OsLoginServiceClient(OsLoginServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final OsLoginServiceSettings getSettings() {
    return settings;
  }

  public OsLoginServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an SSH public key
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   UserName parent = UserName.of("[USER]");
   *   OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
   *   OsLoginProto.SshPublicKey response =
   *       osLoginServiceClient.createSshPublicKey(parent, sshPublicKey);
   * }
   * }</pre>
   *
   * @param parent Required. The unique ID for the user in format `users/{user}`.
   * @param sshPublicKey Required. The SSH public key and expiration time.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OsLoginProto.SshPublicKey createSshPublicKey(
      UserName parent, OsLoginProto.SshPublicKey sshPublicKey) {
    CreateSshPublicKeyRequest request =
        CreateSshPublicKeyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSshPublicKey(sshPublicKey)
            .build();
    return createSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an SSH public key
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   String parent = UserName.of("[USER]").toString();
   *   OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
   *   OsLoginProto.SshPublicKey response =
   *       osLoginServiceClient.createSshPublicKey(parent, sshPublicKey);
   * }
   * }</pre>
   *
   * @param parent Required. The unique ID for the user in format `users/{user}`.
   * @param sshPublicKey Required. The SSH public key and expiration time.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OsLoginProto.SshPublicKey createSshPublicKey(
      String parent, OsLoginProto.SshPublicKey sshPublicKey) {
    CreateSshPublicKeyRequest request =
        CreateSshPublicKeyRequest.newBuilder()
            .setParent(parent)
            .setSshPublicKey(sshPublicKey)
            .build();
    return createSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an SSH public key
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   CreateSshPublicKeyRequest request =
   *       CreateSshPublicKeyRequest.newBuilder()
   *           .setParent(UserName.of("[USER]").toString())
   *           .setSshPublicKey(OsLoginProto.SshPublicKey.newBuilder().build())
   *           .build();
   *   OsLoginProto.SshPublicKey response = osLoginServiceClient.createSshPublicKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OsLoginProto.SshPublicKey createSshPublicKey(CreateSshPublicKeyRequest request) {
    return createSshPublicKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an SSH public key
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   CreateSshPublicKeyRequest request =
   *       CreateSshPublicKeyRequest.newBuilder()
   *           .setParent(UserName.of("[USER]").toString())
   *           .setSshPublicKey(OsLoginProto.SshPublicKey.newBuilder().build())
   *           .build();
   *   ApiFuture<OsLoginProto.SshPublicKey> future =
   *       osLoginServiceClient.createSshPublicKeyCallable().futureCall(request);
   *   // Do something.
   *   OsLoginProto.SshPublicKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSshPublicKeyRequest, OsLoginProto.SshPublicKey>
      createSshPublicKeyCallable() {
    return stub.createSshPublicKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a POSIX account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   PosixAccountName name = PosixAccountName.of("[USER]", "[PROJECT]");
   *   osLoginServiceClient.deletePosixAccount(name);
   * }
   * }</pre>
   *
   * @param name Required. A reference to the POSIX account to update. POSIX accounts are identified
   *     by the project ID they are associated with. A reference to the POSIX account is in format
   *     `users/{user}/projects/{project}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePosixAccount(PosixAccountName name) {
    DeletePosixAccountRequest request =
        DeletePosixAccountRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deletePosixAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a POSIX account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   String name = PosixAccountName.of("[USER]", "[PROJECT]").toString();
   *   osLoginServiceClient.deletePosixAccount(name);
   * }
   * }</pre>
   *
   * @param name Required. A reference to the POSIX account to update. POSIX accounts are identified
   *     by the project ID they are associated with. A reference to the POSIX account is in format
   *     `users/{user}/projects/{project}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePosixAccount(String name) {
    DeletePosixAccountRequest request =
        DeletePosixAccountRequest.newBuilder().setName(name).build();
    deletePosixAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a POSIX account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   DeletePosixAccountRequest request =
   *       DeletePosixAccountRequest.newBuilder()
   *           .setName(PosixAccountName.of("[USER]", "[PROJECT]").toString())
   *           .build();
   *   osLoginServiceClient.deletePosixAccount(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePosixAccount(DeletePosixAccountRequest request) {
    deletePosixAccountCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a POSIX account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   DeletePosixAccountRequest request =
   *       DeletePosixAccountRequest.newBuilder()
   *           .setName(PosixAccountName.of("[USER]", "[PROJECT]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       osLoginServiceClient.deletePosixAccountCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePosixAccountRequest, Empty> deletePosixAccountCallable() {
    return stub.deletePosixAccountCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an SSH public key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   SshPublicKeyName name = SshPublicKeyName.of("[USER]", "[FINGERPRINT]");
   *   osLoginServiceClient.deleteSshPublicKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The fingerprint of the public key to update. Public keys are identified
   *     by their SHA-256 fingerprint. The fingerprint of the public key is in format
   *     `users/{user}/sshPublicKeys/{fingerprint}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSshPublicKey(SshPublicKeyName name) {
    DeleteSshPublicKeyRequest request =
        DeleteSshPublicKeyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an SSH public key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   String name = SshPublicKeyName.of("[USER]", "[FINGERPRINT]").toString();
   *   osLoginServiceClient.deleteSshPublicKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The fingerprint of the public key to update. Public keys are identified
   *     by their SHA-256 fingerprint. The fingerprint of the public key is in format
   *     `users/{user}/sshPublicKeys/{fingerprint}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSshPublicKey(String name) {
    DeleteSshPublicKeyRequest request =
        DeleteSshPublicKeyRequest.newBuilder().setName(name).build();
    deleteSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an SSH public key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   DeleteSshPublicKeyRequest request =
   *       DeleteSshPublicKeyRequest.newBuilder()
   *           .setName(SshPublicKeyName.of("[USER]", "[FINGERPRINT]").toString())
   *           .build();
   *   osLoginServiceClient.deleteSshPublicKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSshPublicKey(DeleteSshPublicKeyRequest request) {
    deleteSshPublicKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an SSH public key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   DeleteSshPublicKeyRequest request =
   *       DeleteSshPublicKeyRequest.newBuilder()
   *           .setName(SshPublicKeyName.of("[USER]", "[FINGERPRINT]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       osLoginServiceClient.deleteSshPublicKeyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSshPublicKeyRequest, Empty> deleteSshPublicKeyCallable() {
    return stub.deleteSshPublicKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the profile information used for logging in to a virtual machine on Google Compute
   * Engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   UserName name = UserName.of("[USER]");
   *   LoginProfile response = osLoginServiceClient.getLoginProfile(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique ID for the user in format `users/{user}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LoginProfile getLoginProfile(UserName name) {
    GetLoginProfileRequest request =
        GetLoginProfileRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getLoginProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the profile information used for logging in to a virtual machine on Google Compute
   * Engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   String name = UserName.of("[USER]").toString();
   *   LoginProfile response = osLoginServiceClient.getLoginProfile(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique ID for the user in format `users/{user}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LoginProfile getLoginProfile(String name) {
    GetLoginProfileRequest request = GetLoginProfileRequest.newBuilder().setName(name).build();
    return getLoginProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the profile information used for logging in to a virtual machine on Google Compute
   * Engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   GetLoginProfileRequest request =
   *       GetLoginProfileRequest.newBuilder()
   *           .setName(UserName.of("[USER]").toString())
   *           .setProjectId("projectId-894832108")
   *           .setSystemId("systemId1976085418")
   *           .build();
   *   LoginProfile response = osLoginServiceClient.getLoginProfile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LoginProfile getLoginProfile(GetLoginProfileRequest request) {
    return getLoginProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the profile information used for logging in to a virtual machine on Google Compute
   * Engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   GetLoginProfileRequest request =
   *       GetLoginProfileRequest.newBuilder()
   *           .setName(UserName.of("[USER]").toString())
   *           .setProjectId("projectId-894832108")
   *           .setSystemId("systemId1976085418")
   *           .build();
   *   ApiFuture<LoginProfile> future =
   *       osLoginServiceClient.getLoginProfileCallable().futureCall(request);
   *   // Do something.
   *   LoginProfile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLoginProfileRequest, LoginProfile> getLoginProfileCallable() {
    return stub.getLoginProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an SSH public key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   SshPublicKeyName name = SshPublicKeyName.of("[USER]", "[FINGERPRINT]");
   *   OsLoginProto.SshPublicKey response = osLoginServiceClient.getSshPublicKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The fingerprint of the public key to retrieve. Public keys are identified
   *     by their SHA-256 fingerprint. The fingerprint of the public key is in format
   *     `users/{user}/sshPublicKeys/{fingerprint}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OsLoginProto.SshPublicKey getSshPublicKey(SshPublicKeyName name) {
    GetSshPublicKeyRequest request =
        GetSshPublicKeyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an SSH public key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   String name = SshPublicKeyName.of("[USER]", "[FINGERPRINT]").toString();
   *   OsLoginProto.SshPublicKey response = osLoginServiceClient.getSshPublicKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The fingerprint of the public key to retrieve. Public keys are identified
   *     by their SHA-256 fingerprint. The fingerprint of the public key is in format
   *     `users/{user}/sshPublicKeys/{fingerprint}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OsLoginProto.SshPublicKey getSshPublicKey(String name) {
    GetSshPublicKeyRequest request = GetSshPublicKeyRequest.newBuilder().setName(name).build();
    return getSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an SSH public key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   GetSshPublicKeyRequest request =
   *       GetSshPublicKeyRequest.newBuilder()
   *           .setName(SshPublicKeyName.of("[USER]", "[FINGERPRINT]").toString())
   *           .build();
   *   OsLoginProto.SshPublicKey response = osLoginServiceClient.getSshPublicKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OsLoginProto.SshPublicKey getSshPublicKey(GetSshPublicKeyRequest request) {
    return getSshPublicKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an SSH public key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   GetSshPublicKeyRequest request =
   *       GetSshPublicKeyRequest.newBuilder()
   *           .setName(SshPublicKeyName.of("[USER]", "[FINGERPRINT]").toString())
   *           .build();
   *   ApiFuture<OsLoginProto.SshPublicKey> future =
   *       osLoginServiceClient.getSshPublicKeyCallable().futureCall(request);
   *   // Do something.
   *   OsLoginProto.SshPublicKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSshPublicKeyRequest, OsLoginProto.SshPublicKey>
      getSshPublicKeyCallable() {
    return stub.getSshPublicKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds an SSH public key and returns the profile information. Default POSIX account information
   * is set when no username and UID exist as part of the login profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   UserName parent = UserName.of("[USER]");
   *   OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
   *   ImportSshPublicKeyResponse response =
   *       osLoginServiceClient.importSshPublicKey(parent, sshPublicKey);
   * }
   * }</pre>
   *
   * @param parent Required. The unique ID for the user in format `users/{user}`.
   * @param sshPublicKey Optional. The SSH public key and expiration time.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportSshPublicKeyResponse importSshPublicKey(
      UserName parent, OsLoginProto.SshPublicKey sshPublicKey) {
    ImportSshPublicKeyRequest request =
        ImportSshPublicKeyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSshPublicKey(sshPublicKey)
            .build();
    return importSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds an SSH public key and returns the profile information. Default POSIX account information
   * is set when no username and UID exist as part of the login profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   String parent = UserName.of("[USER]").toString();
   *   OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
   *   ImportSshPublicKeyResponse response =
   *       osLoginServiceClient.importSshPublicKey(parent, sshPublicKey);
   * }
   * }</pre>
   *
   * @param parent Required. The unique ID for the user in format `users/{user}`.
   * @param sshPublicKey Optional. The SSH public key and expiration time.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportSshPublicKeyResponse importSshPublicKey(
      String parent, OsLoginProto.SshPublicKey sshPublicKey) {
    ImportSshPublicKeyRequest request =
        ImportSshPublicKeyRequest.newBuilder()
            .setParent(parent)
            .setSshPublicKey(sshPublicKey)
            .build();
    return importSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds an SSH public key and returns the profile information. Default POSIX account information
   * is set when no username and UID exist as part of the login profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   UserName parent = UserName.of("[USER]");
   *   OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
   *   String projectId = "projectId-894832108";
   *   ImportSshPublicKeyResponse response =
   *       osLoginServiceClient.importSshPublicKey(parent, sshPublicKey, projectId);
   * }
   * }</pre>
   *
   * @param parent Required. The unique ID for the user in format `users/{user}`.
   * @param sshPublicKey Optional. The SSH public key and expiration time.
   * @param projectId The project ID of the Google Cloud Platform project.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportSshPublicKeyResponse importSshPublicKey(
      UserName parent, OsLoginProto.SshPublicKey sshPublicKey, String projectId) {
    ImportSshPublicKeyRequest request =
        ImportSshPublicKeyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSshPublicKey(sshPublicKey)
            .setProjectId(projectId)
            .build();
    return importSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds an SSH public key and returns the profile information. Default POSIX account information
   * is set when no username and UID exist as part of the login profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   String parent = UserName.of("[USER]").toString();
   *   OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
   *   String projectId = "projectId-894832108";
   *   ImportSshPublicKeyResponse response =
   *       osLoginServiceClient.importSshPublicKey(parent, sshPublicKey, projectId);
   * }
   * }</pre>
   *
   * @param parent Required. The unique ID for the user in format `users/{user}`.
   * @param sshPublicKey Optional. The SSH public key and expiration time.
   * @param projectId The project ID of the Google Cloud Platform project.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportSshPublicKeyResponse importSshPublicKey(
      String parent, OsLoginProto.SshPublicKey sshPublicKey, String projectId) {
    ImportSshPublicKeyRequest request =
        ImportSshPublicKeyRequest.newBuilder()
            .setParent(parent)
            .setSshPublicKey(sshPublicKey)
            .setProjectId(projectId)
            .build();
    return importSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds an SSH public key and returns the profile information. Default POSIX account information
   * is set when no username and UID exist as part of the login profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   ImportSshPublicKeyRequest request =
   *       ImportSshPublicKeyRequest.newBuilder()
   *           .setParent(UserName.of("[USER]").toString())
   *           .setSshPublicKey(OsLoginProto.SshPublicKey.newBuilder().build())
   *           .setProjectId("projectId-894832108")
   *           .build();
   *   ImportSshPublicKeyResponse response = osLoginServiceClient.importSshPublicKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportSshPublicKeyResponse importSshPublicKey(ImportSshPublicKeyRequest request) {
    return importSshPublicKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds an SSH public key and returns the profile information. Default POSIX account information
   * is set when no username and UID exist as part of the login profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   ImportSshPublicKeyRequest request =
   *       ImportSshPublicKeyRequest.newBuilder()
   *           .setParent(UserName.of("[USER]").toString())
   *           .setSshPublicKey(OsLoginProto.SshPublicKey.newBuilder().build())
   *           .setProjectId("projectId-894832108")
   *           .build();
   *   ApiFuture<ImportSshPublicKeyResponse> future =
   *       osLoginServiceClient.importSshPublicKeyCallable().futureCall(request);
   *   // Do something.
   *   ImportSshPublicKeyResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportSshPublicKeyRequest, ImportSshPublicKeyResponse>
      importSshPublicKeyCallable() {
    return stub.importSshPublicKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an SSH public key and returns the profile information. This method supports patch
   * semantics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   SshPublicKeyName name = SshPublicKeyName.of("[USER]", "[FINGERPRINT]");
   *   OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
   *   OsLoginProto.SshPublicKey response =
   *       osLoginServiceClient.updateSshPublicKey(name, sshPublicKey);
   * }
   * }</pre>
   *
   * @param name Required. The fingerprint of the public key to update. Public keys are identified
   *     by their SHA-256 fingerprint. The fingerprint of the public key is in format
   *     `users/{user}/sshPublicKeys/{fingerprint}`.
   * @param sshPublicKey Required. The SSH public key and expiration time.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OsLoginProto.SshPublicKey updateSshPublicKey(
      SshPublicKeyName name, OsLoginProto.SshPublicKey sshPublicKey) {
    UpdateSshPublicKeyRequest request =
        UpdateSshPublicKeyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setSshPublicKey(sshPublicKey)
            .build();
    return updateSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an SSH public key and returns the profile information. This method supports patch
   * semantics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   String name = SshPublicKeyName.of("[USER]", "[FINGERPRINT]").toString();
   *   OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
   *   OsLoginProto.SshPublicKey response =
   *       osLoginServiceClient.updateSshPublicKey(name, sshPublicKey);
   * }
   * }</pre>
   *
   * @param name Required. The fingerprint of the public key to update. Public keys are identified
   *     by their SHA-256 fingerprint. The fingerprint of the public key is in format
   *     `users/{user}/sshPublicKeys/{fingerprint}`.
   * @param sshPublicKey Required. The SSH public key and expiration time.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OsLoginProto.SshPublicKey updateSshPublicKey(
      String name, OsLoginProto.SshPublicKey sshPublicKey) {
    UpdateSshPublicKeyRequest request =
        UpdateSshPublicKeyRequest.newBuilder().setName(name).setSshPublicKey(sshPublicKey).build();
    return updateSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an SSH public key and returns the profile information. This method supports patch
   * semantics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   SshPublicKeyName name = SshPublicKeyName.of("[USER]", "[FINGERPRINT]");
   *   OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   OsLoginProto.SshPublicKey response =
   *       osLoginServiceClient.updateSshPublicKey(name, sshPublicKey, updateMask);
   * }
   * }</pre>
   *
   * @param name Required. The fingerprint of the public key to update. Public keys are identified
   *     by their SHA-256 fingerprint. The fingerprint of the public key is in format
   *     `users/{user}/sshPublicKeys/{fingerprint}`.
   * @param sshPublicKey Required. The SSH public key and expiration time.
   * @param updateMask Mask to control which fields get updated. Updates all if not present.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OsLoginProto.SshPublicKey updateSshPublicKey(
      SshPublicKeyName name, OsLoginProto.SshPublicKey sshPublicKey, FieldMask updateMask) {
    UpdateSshPublicKeyRequest request =
        UpdateSshPublicKeyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setSshPublicKey(sshPublicKey)
            .setUpdateMask(updateMask)
            .build();
    return updateSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an SSH public key and returns the profile information. This method supports patch
   * semantics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   String name = SshPublicKeyName.of("[USER]", "[FINGERPRINT]").toString();
   *   OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   OsLoginProto.SshPublicKey response =
   *       osLoginServiceClient.updateSshPublicKey(name, sshPublicKey, updateMask);
   * }
   * }</pre>
   *
   * @param name Required. The fingerprint of the public key to update. Public keys are identified
   *     by their SHA-256 fingerprint. The fingerprint of the public key is in format
   *     `users/{user}/sshPublicKeys/{fingerprint}`.
   * @param sshPublicKey Required. The SSH public key and expiration time.
   * @param updateMask Mask to control which fields get updated. Updates all if not present.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OsLoginProto.SshPublicKey updateSshPublicKey(
      String name, OsLoginProto.SshPublicKey sshPublicKey, FieldMask updateMask) {
    UpdateSshPublicKeyRequest request =
        UpdateSshPublicKeyRequest.newBuilder()
            .setName(name)
            .setSshPublicKey(sshPublicKey)
            .setUpdateMask(updateMask)
            .build();
    return updateSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an SSH public key and returns the profile information. This method supports patch
   * semantics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   UpdateSshPublicKeyRequest request =
   *       UpdateSshPublicKeyRequest.newBuilder()
   *           .setName(SshPublicKeyName.of("[USER]", "[FINGERPRINT]").toString())
   *           .setSshPublicKey(OsLoginProto.SshPublicKey.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OsLoginProto.SshPublicKey response = osLoginServiceClient.updateSshPublicKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OsLoginProto.SshPublicKey updateSshPublicKey(UpdateSshPublicKeyRequest request) {
    return updateSshPublicKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an SSH public key and returns the profile information. This method supports patch
   * semantics.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   UpdateSshPublicKeyRequest request =
   *       UpdateSshPublicKeyRequest.newBuilder()
   *           .setName(SshPublicKeyName.of("[USER]", "[FINGERPRINT]").toString())
   *           .setSshPublicKey(OsLoginProto.SshPublicKey.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<OsLoginProto.SshPublicKey> future =
   *       osLoginServiceClient.updateSshPublicKeyCallable().futureCall(request);
   *   // Do something.
   *   OsLoginProto.SshPublicKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSshPublicKeyRequest, OsLoginProto.SshPublicKey>
      updateSshPublicKeyCallable() {
    return stub.updateSshPublicKeyCallable();
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
