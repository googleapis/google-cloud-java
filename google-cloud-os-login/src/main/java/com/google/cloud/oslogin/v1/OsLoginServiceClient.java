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
package com.google.cloud.oslogin.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.oslogin.common.OsLoginProto.SshPublicKey;
import com.google.cloud.oslogin.v1.stub.OsLoginServiceStub;
import com.google.cloud.oslogin.v1.stub.OsLoginServiceStubSettings;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Cloud OS Login API
 *
 * <p>The Cloud OS Login API allows you to manage users and their associated SSH public keys for
 * logging into virtual machines on Google Cloud Platform.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
 *   ProjectName name = ProjectName.of("[USER]", "[PROJECT]");
 *   osLoginServiceClient.deletePosixAccount(name);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the osLoginServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
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
 * <pre>
 * <code>
 * OsLoginServiceSettings osLoginServiceSettings =
 *     OsLoginServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * OsLoginServiceClient osLoginServiceClient =
 *     OsLoginServiceClient.create(osLoginServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * OsLoginServiceSettings osLoginServiceSettings =
 *     OsLoginServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * OsLoginServiceClient osLoginServiceClient =
 *     OsLoginServiceClient.create(osLoginServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
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
   * for advanced usage - prefer to use OsLoginServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected OsLoginServiceClient(OsLoginServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final OsLoginServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public OsLoginServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a POSIX account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   ProjectName name = ProjectName.of("[USER]", "[PROJECT]");
   *   osLoginServiceClient.deletePosixAccount(name);
   * }
   * </code></pre>
   *
   * @param name A reference to the POSIX account to update. POSIX accounts are identified by the
   *     project ID they are associated with. A reference to the POSIX account is in format
   *     `users/{user}/projects/{project}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePosixAccount(ProjectName name) {

    DeletePosixAccountRequest request =
        DeletePosixAccountRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deletePosixAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a POSIX account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   ProjectName name = ProjectName.of("[USER]", "[PROJECT]");
   *   osLoginServiceClient.deletePosixAccount(name.toString());
   * }
   * </code></pre>
   *
   * @param name A reference to the POSIX account to update. POSIX accounts are identified by the
   *     project ID they are associated with. A reference to the POSIX account is in format
   *     `users/{user}/projects/{project}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deletePosixAccount(String name) {

    DeletePosixAccountRequest request =
        DeletePosixAccountRequest.newBuilder().setName(name).build();
    deletePosixAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a POSIX account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   ProjectName name = ProjectName.of("[USER]", "[PROJECT]");
   *   DeletePosixAccountRequest request = DeletePosixAccountRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   osLoginServiceClient.deletePosixAccount(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final void deletePosixAccount(DeletePosixAccountRequest request) {
    deletePosixAccountCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a POSIX account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   ProjectName name = ProjectName.of("[USER]", "[PROJECT]");
   *   DeletePosixAccountRequest request = DeletePosixAccountRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = osLoginServiceClient.deletePosixAccountCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeletePosixAccountRequest, Empty> deletePosixAccountCallable() {
    return stub.deletePosixAccountCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes an SSH public key.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   FingerprintName name = FingerprintName.of("[USER]", "[FINGERPRINT]");
   *   osLoginServiceClient.deleteSshPublicKey(name);
   * }
   * </code></pre>
   *
   * @param name The fingerprint of the public key to update. Public keys are identified by their
   *     SHA-256 fingerprint. The fingerprint of the public key is in format
   *     `users/{user}/sshPublicKeys/{fingerprint}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSshPublicKey(FingerprintName name) {

    DeleteSshPublicKeyRequest request =
        DeleteSshPublicKeyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes an SSH public key.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   FingerprintName name = FingerprintName.of("[USER]", "[FINGERPRINT]");
   *   osLoginServiceClient.deleteSshPublicKey(name.toString());
   * }
   * </code></pre>
   *
   * @param name The fingerprint of the public key to update. Public keys are identified by their
   *     SHA-256 fingerprint. The fingerprint of the public key is in format
   *     `users/{user}/sshPublicKeys/{fingerprint}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSshPublicKey(String name) {

    DeleteSshPublicKeyRequest request =
        DeleteSshPublicKeyRequest.newBuilder().setName(name).build();
    deleteSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes an SSH public key.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   FingerprintName name = FingerprintName.of("[USER]", "[FINGERPRINT]");
   *   DeleteSshPublicKeyRequest request = DeleteSshPublicKeyRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   osLoginServiceClient.deleteSshPublicKey(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final void deleteSshPublicKey(DeleteSshPublicKeyRequest request) {
    deleteSshPublicKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes an SSH public key.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   FingerprintName name = FingerprintName.of("[USER]", "[FINGERPRINT]");
   *   DeleteSshPublicKeyRequest request = DeleteSshPublicKeyRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = osLoginServiceClient.deleteSshPublicKeyCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteSshPublicKeyRequest, Empty> deleteSshPublicKeyCallable() {
    return stub.deleteSshPublicKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the profile information used for logging in to a virtual machine on Google Compute
   * Engine.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   UserName name = UserName.of("[USER]");
   *   LoginProfile response = osLoginServiceClient.getLoginProfile(name);
   * }
   * </code></pre>
   *
   * @param name The unique ID for the user in format `users/{user}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LoginProfile getLoginProfile(UserName name) {

    GetLoginProfileRequest request =
        GetLoginProfileRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getLoginProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the profile information used for logging in to a virtual machine on Google Compute
   * Engine.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   UserName name = UserName.of("[USER]");
   *   LoginProfile response = osLoginServiceClient.getLoginProfile(name.toString());
   * }
   * </code></pre>
   *
   * @param name The unique ID for the user in format `users/{user}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LoginProfile getLoginProfile(String name) {

    GetLoginProfileRequest request = GetLoginProfileRequest.newBuilder().setName(name).build();
    return getLoginProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the profile information used for logging in to a virtual machine on Google Compute
   * Engine.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   UserName name = UserName.of("[USER]");
   *   GetLoginProfileRequest request = GetLoginProfileRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   LoginProfile response = osLoginServiceClient.getLoginProfile(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final LoginProfile getLoginProfile(GetLoginProfileRequest request) {
    return getLoginProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the profile information used for logging in to a virtual machine on Google Compute
   * Engine.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   UserName name = UserName.of("[USER]");
   *   GetLoginProfileRequest request = GetLoginProfileRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;LoginProfile&gt; future = osLoginServiceClient.getLoginProfileCallable().futureCall(request);
   *   // Do something
   *   LoginProfile response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetLoginProfileRequest, LoginProfile> getLoginProfileCallable() {
    return stub.getLoginProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an SSH public key.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   FingerprintName name = FingerprintName.of("[USER]", "[FINGERPRINT]");
   *   SshPublicKey response = osLoginServiceClient.getSshPublicKey(name);
   * }
   * </code></pre>
   *
   * @param name The fingerprint of the public key to retrieve. Public keys are identified by their
   *     SHA-256 fingerprint. The fingerprint of the public key is in format
   *     `users/{user}/sshPublicKeys/{fingerprint}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SshPublicKey getSshPublicKey(FingerprintName name) {

    GetSshPublicKeyRequest request =
        GetSshPublicKeyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an SSH public key.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   FingerprintName name = FingerprintName.of("[USER]", "[FINGERPRINT]");
   *   SshPublicKey response = osLoginServiceClient.getSshPublicKey(name.toString());
   * }
   * </code></pre>
   *
   * @param name The fingerprint of the public key to retrieve. Public keys are identified by their
   *     SHA-256 fingerprint. The fingerprint of the public key is in format
   *     `users/{user}/sshPublicKeys/{fingerprint}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SshPublicKey getSshPublicKey(String name) {

    GetSshPublicKeyRequest request = GetSshPublicKeyRequest.newBuilder().setName(name).build();
    return getSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an SSH public key.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   FingerprintName name = FingerprintName.of("[USER]", "[FINGERPRINT]");
   *   GetSshPublicKeyRequest request = GetSshPublicKeyRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   SshPublicKey response = osLoginServiceClient.getSshPublicKey(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final SshPublicKey getSshPublicKey(GetSshPublicKeyRequest request) {
    return getSshPublicKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves an SSH public key.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   FingerprintName name = FingerprintName.of("[USER]", "[FINGERPRINT]");
   *   GetSshPublicKeyRequest request = GetSshPublicKeyRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;SshPublicKey&gt; future = osLoginServiceClient.getSshPublicKeyCallable().futureCall(request);
   *   // Do something
   *   SshPublicKey response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetSshPublicKeyRequest, SshPublicKey> getSshPublicKeyCallable() {
    return stub.getSshPublicKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds an SSH public key and returns the profile information. Default POSIX account information
   * is set when no username and UID exist as part of the login profile.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   UserName parent = UserName.of("[USER]");
   *   SshPublicKey sshPublicKey = SshPublicKey.newBuilder().build();
   *   ImportSshPublicKeyResponse response = osLoginServiceClient.importSshPublicKey(parent, sshPublicKey);
   * }
   * </code></pre>
   *
   * @param parent The unique ID for the user in format `users/{user}`.
   * @param sshPublicKey The SSH public key and expiration time.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportSshPublicKeyResponse importSshPublicKey(
      UserName parent, SshPublicKey sshPublicKey) {

    ImportSshPublicKeyRequest request =
        ImportSshPublicKeyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSshPublicKey(sshPublicKey)
            .build();
    return importSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds an SSH public key and returns the profile information. Default POSIX account information
   * is set when no username and UID exist as part of the login profile.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   UserName parent = UserName.of("[USER]");
   *   SshPublicKey sshPublicKey = SshPublicKey.newBuilder().build();
   *   ImportSshPublicKeyResponse response = osLoginServiceClient.importSshPublicKey(parent.toString(), sshPublicKey);
   * }
   * </code></pre>
   *
   * @param parent The unique ID for the user in format `users/{user}`.
   * @param sshPublicKey The SSH public key and expiration time.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportSshPublicKeyResponse importSshPublicKey(
      String parent, SshPublicKey sshPublicKey) {

    ImportSshPublicKeyRequest request =
        ImportSshPublicKeyRequest.newBuilder()
            .setParent(parent)
            .setSshPublicKey(sshPublicKey)
            .build();
    return importSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds an SSH public key and returns the profile information. Default POSIX account information
   * is set when no username and UID exist as part of the login profile.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   UserName parent = UserName.of("[USER]");
   *   SshPublicKey sshPublicKey = SshPublicKey.newBuilder().build();
   *   String projectId = "";
   *   ImportSshPublicKeyResponse response = osLoginServiceClient.importSshPublicKey(parent, sshPublicKey, projectId);
   * }
   * </code></pre>
   *
   * @param parent The unique ID for the user in format `users/{user}`.
   * @param sshPublicKey The SSH public key and expiration time.
   * @param projectId The project ID of the Google Cloud Platform project.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportSshPublicKeyResponse importSshPublicKey(
      UserName parent, SshPublicKey sshPublicKey, String projectId) {

    ImportSshPublicKeyRequest request =
        ImportSshPublicKeyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSshPublicKey(sshPublicKey)
            .setProjectId(projectId)
            .build();
    return importSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds an SSH public key and returns the profile information. Default POSIX account information
   * is set when no username and UID exist as part of the login profile.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   UserName parent = UserName.of("[USER]");
   *   SshPublicKey sshPublicKey = SshPublicKey.newBuilder().build();
   *   String projectId = "";
   *   ImportSshPublicKeyResponse response = osLoginServiceClient.importSshPublicKey(parent.toString(), sshPublicKey, projectId);
   * }
   * </code></pre>
   *
   * @param parent The unique ID for the user in format `users/{user}`.
   * @param sshPublicKey The SSH public key and expiration time.
   * @param projectId The project ID of the Google Cloud Platform project.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportSshPublicKeyResponse importSshPublicKey(
      String parent, SshPublicKey sshPublicKey, String projectId) {

    ImportSshPublicKeyRequest request =
        ImportSshPublicKeyRequest.newBuilder()
            .setParent(parent)
            .setSshPublicKey(sshPublicKey)
            .setProjectId(projectId)
            .build();
    return importSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds an SSH public key and returns the profile information. Default POSIX account information
   * is set when no username and UID exist as part of the login profile.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   UserName parent = UserName.of("[USER]");
   *   SshPublicKey sshPublicKey = SshPublicKey.newBuilder().build();
   *   ImportSshPublicKeyRequest request = ImportSshPublicKeyRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setSshPublicKey(sshPublicKey)
   *     .build();
   *   ImportSshPublicKeyResponse response = osLoginServiceClient.importSshPublicKey(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportSshPublicKeyResponse importSshPublicKey(ImportSshPublicKeyRequest request) {
    return importSshPublicKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds an SSH public key and returns the profile information. Default POSIX account information
   * is set when no username and UID exist as part of the login profile.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   UserName parent = UserName.of("[USER]");
   *   SshPublicKey sshPublicKey = SshPublicKey.newBuilder().build();
   *   ImportSshPublicKeyRequest request = ImportSshPublicKeyRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setSshPublicKey(sshPublicKey)
   *     .build();
   *   ApiFuture&lt;ImportSshPublicKeyResponse&gt; future = osLoginServiceClient.importSshPublicKeyCallable().futureCall(request);
   *   // Do something
   *   ImportSshPublicKeyResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ImportSshPublicKeyRequest, ImportSshPublicKeyResponse>
      importSshPublicKeyCallable() {
    return stub.importSshPublicKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an SSH public key and returns the profile information. This method supports patch
   * semantics.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   FingerprintName name = FingerprintName.of("[USER]", "[FINGERPRINT]");
   *   SshPublicKey sshPublicKey = SshPublicKey.newBuilder().build();
   *   SshPublicKey response = osLoginServiceClient.updateSshPublicKey(name, sshPublicKey);
   * }
   * </code></pre>
   *
   * @param name The fingerprint of the public key to update. Public keys are identified by their
   *     SHA-256 fingerprint. The fingerprint of the public key is in format
   *     `users/{user}/sshPublicKeys/{fingerprint}`.
   * @param sshPublicKey The SSH public key and expiration time.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SshPublicKey updateSshPublicKey(FingerprintName name, SshPublicKey sshPublicKey) {

    UpdateSshPublicKeyRequest request =
        UpdateSshPublicKeyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setSshPublicKey(sshPublicKey)
            .build();
    return updateSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an SSH public key and returns the profile information. This method supports patch
   * semantics.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   FingerprintName name = FingerprintName.of("[USER]", "[FINGERPRINT]");
   *   SshPublicKey sshPublicKey = SshPublicKey.newBuilder().build();
   *   SshPublicKey response = osLoginServiceClient.updateSshPublicKey(name.toString(), sshPublicKey);
   * }
   * </code></pre>
   *
   * @param name The fingerprint of the public key to update. Public keys are identified by their
   *     SHA-256 fingerprint. The fingerprint of the public key is in format
   *     `users/{user}/sshPublicKeys/{fingerprint}`.
   * @param sshPublicKey The SSH public key and expiration time.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SshPublicKey updateSshPublicKey(String name, SshPublicKey sshPublicKey) {

    UpdateSshPublicKeyRequest request =
        UpdateSshPublicKeyRequest.newBuilder().setName(name).setSshPublicKey(sshPublicKey).build();
    return updateSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an SSH public key and returns the profile information. This method supports patch
   * semantics.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   FingerprintName name = FingerprintName.of("[USER]", "[FINGERPRINT]");
   *   SshPublicKey sshPublicKey = SshPublicKey.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   SshPublicKey response = osLoginServiceClient.updateSshPublicKey(name, sshPublicKey, updateMask);
   * }
   * </code></pre>
   *
   * @param name The fingerprint of the public key to update. Public keys are identified by their
   *     SHA-256 fingerprint. The fingerprint of the public key is in format
   *     `users/{user}/sshPublicKeys/{fingerprint}`.
   * @param sshPublicKey The SSH public key and expiration time.
   * @param updateMask Mask to control which fields get updated. Updates all if not present.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SshPublicKey updateSshPublicKey(
      FingerprintName name, SshPublicKey sshPublicKey, FieldMask updateMask) {

    UpdateSshPublicKeyRequest request =
        UpdateSshPublicKeyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setSshPublicKey(sshPublicKey)
            .setUpdateMask(updateMask)
            .build();
    return updateSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an SSH public key and returns the profile information. This method supports patch
   * semantics.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   FingerprintName name = FingerprintName.of("[USER]", "[FINGERPRINT]");
   *   SshPublicKey sshPublicKey = SshPublicKey.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   SshPublicKey response = osLoginServiceClient.updateSshPublicKey(name.toString(), sshPublicKey, updateMask);
   * }
   * </code></pre>
   *
   * @param name The fingerprint of the public key to update. Public keys are identified by their
   *     SHA-256 fingerprint. The fingerprint of the public key is in format
   *     `users/{user}/sshPublicKeys/{fingerprint}`.
   * @param sshPublicKey The SSH public key and expiration time.
   * @param updateMask Mask to control which fields get updated. Updates all if not present.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SshPublicKey updateSshPublicKey(
      String name, SshPublicKey sshPublicKey, FieldMask updateMask) {

    UpdateSshPublicKeyRequest request =
        UpdateSshPublicKeyRequest.newBuilder()
            .setName(name)
            .setSshPublicKey(sshPublicKey)
            .setUpdateMask(updateMask)
            .build();
    return updateSshPublicKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an SSH public key and returns the profile information. This method supports patch
   * semantics.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   FingerprintName name = FingerprintName.of("[USER]", "[FINGERPRINT]");
   *   SshPublicKey sshPublicKey = SshPublicKey.newBuilder().build();
   *   UpdateSshPublicKeyRequest request = UpdateSshPublicKeyRequest.newBuilder()
   *     .setName(name.toString())
   *     .setSshPublicKey(sshPublicKey)
   *     .build();
   *   SshPublicKey response = osLoginServiceClient.updateSshPublicKey(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SshPublicKey updateSshPublicKey(UpdateSshPublicKeyRequest request) {
    return updateSshPublicKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an SSH public key and returns the profile information. This method supports patch
   * semantics.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (OsLoginServiceClient osLoginServiceClient = OsLoginServiceClient.create()) {
   *   FingerprintName name = FingerprintName.of("[USER]", "[FINGERPRINT]");
   *   SshPublicKey sshPublicKey = SshPublicKey.newBuilder().build();
   *   UpdateSshPublicKeyRequest request = UpdateSshPublicKeyRequest.newBuilder()
   *     .setName(name.toString())
   *     .setSshPublicKey(sshPublicKey)
   *     .build();
   *   ApiFuture&lt;SshPublicKey&gt; future = osLoginServiceClient.updateSshPublicKeyCallable().futureCall(request);
   *   // Do something
   *   SshPublicKey response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateSshPublicKeyRequest, SshPublicKey> updateSshPublicKeyCallable() {
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
