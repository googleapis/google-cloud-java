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

package com.google.cloud.secretmanager.v1beta1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.secretmanager.v1beta1.stub.SecretManagerServiceStub;
import com.google.cloud.secretmanager.v1beta1.stub.SecretManagerServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Secret Manager Service
 *
 * <p>Manages secrets and operations using those secrets. Implements a REST model with the following
 * objects:
 *
 * <ul>
 *   <li>[Secret][google.cloud.secrets.v1beta1.Secret]
 *   <li>[SecretVersion][google.cloud.secrets.v1beta1.SecretVersion]
 * </ul>
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
 * try (SecretManagerServiceClient secretManagerServiceClient =
 *     SecretManagerServiceClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   String secretId = "secretId945974251";
 *   Secret secret = Secret.newBuilder().build();
 *   Secret response = secretManagerServiceClient.createSecret(parent, secretId, secret);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SecretManagerServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListSecrets</td>
 *      <td><p> Lists [Secrets][google.cloud.secrets.v1beta1.Secret].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSecrets(ListSecretsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSecrets(ProjectName parent)
 *           <li><p> listSecrets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSecretsPagedCallable()
 *           <li><p> listSecretsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSecret</td>
 *      <td><p> Creates a new [Secret][google.cloud.secrets.v1beta1.Secret] containing no [SecretVersions][google.cloud.secrets.v1beta1.SecretVersion].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSecret(CreateSecretRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSecret(ProjectName parent, String secretId, Secret secret)
 *           <li><p> createSecret(String parent, String secretId, Secret secret)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSecretCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AddSecretVersion</td>
 *      <td><p> Creates a new [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] containing secret data and attaches it to an existing [Secret][google.cloud.secrets.v1beta1.Secret].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> addSecretVersion(AddSecretVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> addSecretVersion(SecretName parent, SecretPayload payload)
 *           <li><p> addSecretVersion(String parent, SecretPayload payload)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> addSecretVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSecret</td>
 *      <td><p> Gets metadata for a given [Secret][google.cloud.secrets.v1beta1.Secret].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSecret(GetSecretRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSecret(SecretName name)
 *           <li><p> getSecret(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSecretCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSecret</td>
 *      <td><p> Updates metadata of an existing [Secret][google.cloud.secrets.v1beta1.Secret].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSecret(UpdateSecretRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSecret(Secret secret, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSecretCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSecret</td>
 *      <td><p> Deletes a [Secret][google.cloud.secrets.v1beta1.Secret].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSecret(DeleteSecretRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteSecret(SecretName name)
 *           <li><p> deleteSecret(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSecretCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSecretVersions</td>
 *      <td><p> Lists [SecretVersions][google.cloud.secrets.v1beta1.SecretVersion]. This call does not return secret data.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSecretVersions(ListSecretVersionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSecretVersions(SecretName parent)
 *           <li><p> listSecretVersions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSecretVersionsPagedCallable()
 *           <li><p> listSecretVersionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSecretVersion</td>
 *      <td><p> Gets metadata for a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
 * <p>  `projects/&#42;/secrets/&#42;/versions/latest` is an alias to the `latest` [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSecretVersion(GetSecretVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSecretVersion(SecretVersionName name)
 *           <li><p> getSecretVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSecretVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AccessSecretVersion</td>
 *      <td><p> Accesses a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion]. This call returns the secret data.
 * <p>  `projects/&#42;/secrets/&#42;/versions/latest` is an alias to the `latest` [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> accessSecretVersion(AccessSecretVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> accessSecretVersion(SecretVersionName name)
 *           <li><p> accessSecretVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> accessSecretVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DisableSecretVersion</td>
 *      <td><p> Disables a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
 * <p>  Sets the [state][google.cloud.secrets.v1beta1.SecretVersion.state] of the [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] to [DISABLED][google.cloud.secrets.v1beta1.SecretVersion.State.DISABLED].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> disableSecretVersion(DisableSecretVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> disableSecretVersion(SecretVersionName name)
 *           <li><p> disableSecretVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> disableSecretVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> EnableSecretVersion</td>
 *      <td><p> Enables a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
 * <p>  Sets the [state][google.cloud.secrets.v1beta1.SecretVersion.state] of the [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] to [ENABLED][google.cloud.secrets.v1beta1.SecretVersion.State.ENABLED].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> enableSecretVersion(EnableSecretVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> enableSecretVersion(SecretVersionName name)
 *           <li><p> enableSecretVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> enableSecretVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DestroySecretVersion</td>
 *      <td><p> Destroys a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
 * <p>  Sets the [state][google.cloud.secrets.v1beta1.SecretVersion.state] of the [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] to [DESTROYED][google.cloud.secrets.v1beta1.SecretVersion.State.DESTROYED] and irrevocably destroys the secret data.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> destroySecretVersion(DestroySecretVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> destroySecretVersion(SecretVersionName name)
 *           <li><p> destroySecretVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> destroySecretVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified secret. Replaces any existing policy.
 * <p>  Permissions on [SecretVersions][google.cloud.secrets.v1beta1.SecretVersion] are enforced according to the policy set on the associated [Secret][google.cloud.secrets.v1beta1.Secret].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a secret. Returns empty policy if the secret exists and does not have a policy set.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has for the specified secret. If the secret does not exist, this call returns an empty set of permissions, not a NOT_FOUND error.
 * <p>  Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may "fail open" without warning.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
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
 * <p>This class can be customized by passing in a custom instance of SecretManagerServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SecretManagerServiceSettings secretManagerServiceSettings =
 *     SecretManagerServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SecretManagerServiceClient secretManagerServiceClient =
 *     SecretManagerServiceClient.create(secretManagerServiceSettings);
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
 * SecretManagerServiceSettings secretManagerServiceSettings =
 *     SecretManagerServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SecretManagerServiceClient secretManagerServiceClient =
 *     SecretManagerServiceClient.create(secretManagerServiceSettings);
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
 * SecretManagerServiceSettings secretManagerServiceSettings =
 *     SecretManagerServiceSettings.newHttpJsonBuilder().build();
 * SecretManagerServiceClient secretManagerServiceClient =
 *     SecretManagerServiceClient.create(secretManagerServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SecretManagerServiceClient implements BackgroundResource {
  private final SecretManagerServiceSettings settings;
  private final SecretManagerServiceStub stub;

  /** Constructs an instance of SecretManagerServiceClient with default settings. */
  public static final SecretManagerServiceClient create() throws IOException {
    return create(SecretManagerServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SecretManagerServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SecretManagerServiceClient create(SecretManagerServiceSettings settings)
      throws IOException {
    return new SecretManagerServiceClient(settings);
  }

  /**
   * Constructs an instance of SecretManagerServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(SecretManagerServiceSettings).
   */
  public static final SecretManagerServiceClient create(SecretManagerServiceStub stub) {
    return new SecretManagerServiceClient(stub);
  }

  /**
   * Constructs an instance of SecretManagerServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected SecretManagerServiceClient(SecretManagerServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SecretManagerServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SecretManagerServiceClient(SecretManagerServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SecretManagerServiceSettings getSettings() {
    return settings;
  }

  public SecretManagerServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Secrets][google.cloud.secrets.v1beta1.Secret].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (Secret element : secretManagerServiceClient.listSecrets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the project associated with the
   *     [Secrets][google.cloud.secrets.v1beta1.Secret], in the format `projects/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecretsPagedResponse listSecrets(ProjectName parent) {
    ListSecretsRequest request =
        ListSecretsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSecrets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Secrets][google.cloud.secrets.v1beta1.Secret].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (Secret element : secretManagerServiceClient.listSecrets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the project associated with the
   *     [Secrets][google.cloud.secrets.v1beta1.Secret], in the format `projects/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecretsPagedResponse listSecrets(String parent) {
    ListSecretsRequest request = ListSecretsRequest.newBuilder().setParent(parent).build();
    return listSecrets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Secrets][google.cloud.secrets.v1beta1.Secret].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   ListSecretsRequest request =
   *       ListSecretsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Secret element : secretManagerServiceClient.listSecrets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecretsPagedResponse listSecrets(ListSecretsRequest request) {
    return listSecretsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Secrets][google.cloud.secrets.v1beta1.Secret].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   ListSecretsRequest request =
   *       ListSecretsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Secret> future =
   *       secretManagerServiceClient.listSecretsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Secret element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSecretsRequest, ListSecretsPagedResponse>
      listSecretsPagedCallable() {
    return stub.listSecretsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Secrets][google.cloud.secrets.v1beta1.Secret].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   ListSecretsRequest request =
   *       ListSecretsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSecretsResponse response =
   *         secretManagerServiceClient.listSecretsCallable().call(request);
   *     for (Secret element : response.getSecretsList()) {
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
  public final UnaryCallable<ListSecretsRequest, ListSecretsResponse> listSecretsCallable() {
    return stub.listSecretsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [Secret][google.cloud.secrets.v1beta1.Secret] containing no
   * [SecretVersions][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String secretId = "secretId945974251";
   *   Secret secret = Secret.newBuilder().build();
   *   Secret response = secretManagerServiceClient.createSecret(parent, secretId, secret);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the project to associate with the
   *     [Secret][google.cloud.secrets.v1beta1.Secret], in the format `projects/&#42;`.
   * @param secretId Required. This must be unique within the project.
   *     <p>A secret ID is a string with a maximum length of 255 characters and can contain
   *     uppercase and lowercase letters, numerals, and the hyphen (`-`) and underscore (`_`)
   *     characters.
   * @param secret Required. A [Secret][google.cloud.secrets.v1beta1.Secret] with initial field
   *     values.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Secret createSecret(ProjectName parent, String secretId, Secret secret) {
    CreateSecretRequest request =
        CreateSecretRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSecretId(secretId)
            .setSecret(secret)
            .build();
    return createSecret(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [Secret][google.cloud.secrets.v1beta1.Secret] containing no
   * [SecretVersions][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   String secretId = "secretId945974251";
   *   Secret secret = Secret.newBuilder().build();
   *   Secret response = secretManagerServiceClient.createSecret(parent, secretId, secret);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the project to associate with the
   *     [Secret][google.cloud.secrets.v1beta1.Secret], in the format `projects/&#42;`.
   * @param secretId Required. This must be unique within the project.
   *     <p>A secret ID is a string with a maximum length of 255 characters and can contain
   *     uppercase and lowercase letters, numerals, and the hyphen (`-`) and underscore (`_`)
   *     characters.
   * @param secret Required. A [Secret][google.cloud.secrets.v1beta1.Secret] with initial field
   *     values.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Secret createSecret(String parent, String secretId, Secret secret) {
    CreateSecretRequest request =
        CreateSecretRequest.newBuilder()
            .setParent(parent)
            .setSecretId(secretId)
            .setSecret(secret)
            .build();
    return createSecret(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [Secret][google.cloud.secrets.v1beta1.Secret] containing no
   * [SecretVersions][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   CreateSecretRequest request =
   *       CreateSecretRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setSecretId("secretId945974251")
   *           .setSecret(Secret.newBuilder().build())
   *           .build();
   *   Secret response = secretManagerServiceClient.createSecret(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Secret createSecret(CreateSecretRequest request) {
    return createSecretCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [Secret][google.cloud.secrets.v1beta1.Secret] containing no
   * [SecretVersions][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   CreateSecretRequest request =
   *       CreateSecretRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setSecretId("secretId945974251")
   *           .setSecret(Secret.newBuilder().build())
   *           .build();
   *   ApiFuture<Secret> future =
   *       secretManagerServiceClient.createSecretCallable().futureCall(request);
   *   // Do something.
   *   Secret response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSecretRequest, Secret> createSecretCallable() {
    return stub.createSecretCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] containing secret
   * data and attaches it to an existing [Secret][google.cloud.secrets.v1beta1.Secret].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   SecretName parent = SecretName.of("[PROJECT]", "[SECRET]");
   *   SecretPayload payload = SecretPayload.newBuilder().build();
   *   SecretVersion response = secretManagerServiceClient.addSecretVersion(parent, payload);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the [Secret][google.cloud.secrets.v1beta1.Secret]
   *     to associate with the [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] in the
   *     format `projects/&#42;/secrets/&#42;`.
   * @param payload Required. The secret payload of the
   *     [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecretVersion addSecretVersion(SecretName parent, SecretPayload payload) {
    AddSecretVersionRequest request =
        AddSecretVersionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPayload(payload)
            .build();
    return addSecretVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] containing secret
   * data and attaches it to an existing [Secret][google.cloud.secrets.v1beta1.Secret].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   String parent = SecretName.of("[PROJECT]", "[SECRET]").toString();
   *   SecretPayload payload = SecretPayload.newBuilder().build();
   *   SecretVersion response = secretManagerServiceClient.addSecretVersion(parent, payload);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the [Secret][google.cloud.secrets.v1beta1.Secret]
   *     to associate with the [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] in the
   *     format `projects/&#42;/secrets/&#42;`.
   * @param payload Required. The secret payload of the
   *     [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecretVersion addSecretVersion(String parent, SecretPayload payload) {
    AddSecretVersionRequest request =
        AddSecretVersionRequest.newBuilder().setParent(parent).setPayload(payload).build();
    return addSecretVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] containing secret
   * data and attaches it to an existing [Secret][google.cloud.secrets.v1beta1.Secret].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   AddSecretVersionRequest request =
   *       AddSecretVersionRequest.newBuilder()
   *           .setParent(SecretName.of("[PROJECT]", "[SECRET]").toString())
   *           .setPayload(SecretPayload.newBuilder().build())
   *           .build();
   *   SecretVersion response = secretManagerServiceClient.addSecretVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecretVersion addSecretVersion(AddSecretVersionRequest request) {
    return addSecretVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] containing secret
   * data and attaches it to an existing [Secret][google.cloud.secrets.v1beta1.Secret].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   AddSecretVersionRequest request =
   *       AddSecretVersionRequest.newBuilder()
   *           .setParent(SecretName.of("[PROJECT]", "[SECRET]").toString())
   *           .setPayload(SecretPayload.newBuilder().build())
   *           .build();
   *   ApiFuture<SecretVersion> future =
   *       secretManagerServiceClient.addSecretVersionCallable().futureCall(request);
   *   // Do something.
   *   SecretVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddSecretVersionRequest, SecretVersion> addSecretVersionCallable() {
    return stub.addSecretVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets metadata for a given [Secret][google.cloud.secrets.v1beta1.Secret].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   SecretName name = SecretName.of("[PROJECT]", "[SECRET]");
   *   Secret response = secretManagerServiceClient.getSecret(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the [Secret][google.cloud.secrets.v1beta1.Secret],
   *     in the format `projects/&#42;/secrets/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Secret getSecret(SecretName name) {
    GetSecretRequest request =
        GetSecretRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSecret(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets metadata for a given [Secret][google.cloud.secrets.v1beta1.Secret].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   String name = SecretName.of("[PROJECT]", "[SECRET]").toString();
   *   Secret response = secretManagerServiceClient.getSecret(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the [Secret][google.cloud.secrets.v1beta1.Secret],
   *     in the format `projects/&#42;/secrets/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Secret getSecret(String name) {
    GetSecretRequest request = GetSecretRequest.newBuilder().setName(name).build();
    return getSecret(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets metadata for a given [Secret][google.cloud.secrets.v1beta1.Secret].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   GetSecretRequest request =
   *       GetSecretRequest.newBuilder()
   *           .setName(SecretName.of("[PROJECT]", "[SECRET]").toString())
   *           .build();
   *   Secret response = secretManagerServiceClient.getSecret(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Secret getSecret(GetSecretRequest request) {
    return getSecretCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets metadata for a given [Secret][google.cloud.secrets.v1beta1.Secret].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   GetSecretRequest request =
   *       GetSecretRequest.newBuilder()
   *           .setName(SecretName.of("[PROJECT]", "[SECRET]").toString())
   *           .build();
   *   ApiFuture<Secret> future = secretManagerServiceClient.getSecretCallable().futureCall(request);
   *   // Do something.
   *   Secret response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSecretRequest, Secret> getSecretCallable() {
    return stub.getSecretCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates metadata of an existing [Secret][google.cloud.secrets.v1beta1.Secret].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   Secret secret = Secret.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Secret response = secretManagerServiceClient.updateSecret(secret, updateMask);
   * }
   * }</pre>
   *
   * @param secret Required. [Secret][google.cloud.secrets.v1beta1.Secret] with updated field
   *     values.
   * @param updateMask Required. Specifies the fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Secret updateSecret(Secret secret, FieldMask updateMask) {
    UpdateSecretRequest request =
        UpdateSecretRequest.newBuilder().setSecret(secret).setUpdateMask(updateMask).build();
    return updateSecret(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates metadata of an existing [Secret][google.cloud.secrets.v1beta1.Secret].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   UpdateSecretRequest request =
   *       UpdateSecretRequest.newBuilder()
   *           .setSecret(Secret.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Secret response = secretManagerServiceClient.updateSecret(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Secret updateSecret(UpdateSecretRequest request) {
    return updateSecretCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates metadata of an existing [Secret][google.cloud.secrets.v1beta1.Secret].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   UpdateSecretRequest request =
   *       UpdateSecretRequest.newBuilder()
   *           .setSecret(Secret.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Secret> future =
   *       secretManagerServiceClient.updateSecretCallable().futureCall(request);
   *   // Do something.
   *   Secret response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSecretRequest, Secret> updateSecretCallable() {
    return stub.updateSecretCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Secret][google.cloud.secrets.v1beta1.Secret].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   SecretName name = SecretName.of("[PROJECT]", "[SECRET]");
   *   secretManagerServiceClient.deleteSecret(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the [Secret][google.cloud.secrets.v1beta1.Secret] to
   *     delete in the format `projects/&#42;/secrets/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSecret(SecretName name) {
    DeleteSecretRequest request =
        DeleteSecretRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteSecret(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Secret][google.cloud.secrets.v1beta1.Secret].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   String name = SecretName.of("[PROJECT]", "[SECRET]").toString();
   *   secretManagerServiceClient.deleteSecret(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the [Secret][google.cloud.secrets.v1beta1.Secret] to
   *     delete in the format `projects/&#42;/secrets/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSecret(String name) {
    DeleteSecretRequest request = DeleteSecretRequest.newBuilder().setName(name).build();
    deleteSecret(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Secret][google.cloud.secrets.v1beta1.Secret].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   DeleteSecretRequest request =
   *       DeleteSecretRequest.newBuilder()
   *           .setName(SecretName.of("[PROJECT]", "[SECRET]").toString())
   *           .build();
   *   secretManagerServiceClient.deleteSecret(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSecret(DeleteSecretRequest request) {
    deleteSecretCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Secret][google.cloud.secrets.v1beta1.Secret].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   DeleteSecretRequest request =
   *       DeleteSecretRequest.newBuilder()
   *           .setName(SecretName.of("[PROJECT]", "[SECRET]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       secretManagerServiceClient.deleteSecretCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSecretRequest, Empty> deleteSecretCallable() {
    return stub.deleteSecretCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [SecretVersions][google.cloud.secrets.v1beta1.SecretVersion]. This call does not return
   * secret data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   SecretName parent = SecretName.of("[PROJECT]", "[SECRET]");
   *   for (SecretVersion element :
   *       secretManagerServiceClient.listSecretVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the [Secret][google.cloud.secrets.v1beta1.Secret]
   *     associated with the [SecretVersions][google.cloud.secrets.v1beta1.SecretVersion] to list,
   *     in the format `projects/&#42;/secrets/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecretVersionsPagedResponse listSecretVersions(SecretName parent) {
    ListSecretVersionsRequest request =
        ListSecretVersionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSecretVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [SecretVersions][google.cloud.secrets.v1beta1.SecretVersion]. This call does not return
   * secret data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   String parent = SecretName.of("[PROJECT]", "[SECRET]").toString();
   *   for (SecretVersion element :
   *       secretManagerServiceClient.listSecretVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the [Secret][google.cloud.secrets.v1beta1.Secret]
   *     associated with the [SecretVersions][google.cloud.secrets.v1beta1.SecretVersion] to list,
   *     in the format `projects/&#42;/secrets/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecretVersionsPagedResponse listSecretVersions(String parent) {
    ListSecretVersionsRequest request =
        ListSecretVersionsRequest.newBuilder().setParent(parent).build();
    return listSecretVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [SecretVersions][google.cloud.secrets.v1beta1.SecretVersion]. This call does not return
   * secret data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   ListSecretVersionsRequest request =
   *       ListSecretVersionsRequest.newBuilder()
   *           .setParent(SecretName.of("[PROJECT]", "[SECRET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SecretVersion element :
   *       secretManagerServiceClient.listSecretVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecretVersionsPagedResponse listSecretVersions(
      ListSecretVersionsRequest request) {
    return listSecretVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [SecretVersions][google.cloud.secrets.v1beta1.SecretVersion]. This call does not return
   * secret data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   ListSecretVersionsRequest request =
   *       ListSecretVersionsRequest.newBuilder()
   *           .setParent(SecretName.of("[PROJECT]", "[SECRET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SecretVersion> future =
   *       secretManagerServiceClient.listSecretVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SecretVersion element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSecretVersionsRequest, ListSecretVersionsPagedResponse>
      listSecretVersionsPagedCallable() {
    return stub.listSecretVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [SecretVersions][google.cloud.secrets.v1beta1.SecretVersion]. This call does not return
   * secret data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   ListSecretVersionsRequest request =
   *       ListSecretVersionsRequest.newBuilder()
   *           .setParent(SecretName.of("[PROJECT]", "[SECRET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSecretVersionsResponse response =
   *         secretManagerServiceClient.listSecretVersionsCallable().call(request);
   *     for (SecretVersion element : response.getVersionsList()) {
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
  public final UnaryCallable<ListSecretVersionsRequest, ListSecretVersionsResponse>
      listSecretVersionsCallable() {
    return stub.listSecretVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets metadata for a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>`projects/&#42;/secrets/&#42;/versions/latest` is an alias to the `latest`
   * [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");
   *   SecretVersion response = secretManagerServiceClient.getSecretVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] in the format
   *     `projects/&#42;/secrets/&#42;/versions/&#42;`.
   *     `projects/&#42;/secrets/&#42;/versions/latest` is an alias to the `latest`
   *     [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecretVersion getSecretVersion(SecretVersionName name) {
    GetSecretVersionRequest request =
        GetSecretVersionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSecretVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets metadata for a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>`projects/&#42;/secrets/&#42;/versions/latest` is an alias to the `latest`
   * [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   String name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString();
   *   SecretVersion response = secretManagerServiceClient.getSecretVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] in the format
   *     `projects/&#42;/secrets/&#42;/versions/&#42;`.
   *     `projects/&#42;/secrets/&#42;/versions/latest` is an alias to the `latest`
   *     [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecretVersion getSecretVersion(String name) {
    GetSecretVersionRequest request = GetSecretVersionRequest.newBuilder().setName(name).build();
    return getSecretVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets metadata for a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>`projects/&#42;/secrets/&#42;/versions/latest` is an alias to the `latest`
   * [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   GetSecretVersionRequest request =
   *       GetSecretVersionRequest.newBuilder()
   *           .setName(SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString())
   *           .build();
   *   SecretVersion response = secretManagerServiceClient.getSecretVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecretVersion getSecretVersion(GetSecretVersionRequest request) {
    return getSecretVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets metadata for a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>`projects/&#42;/secrets/&#42;/versions/latest` is an alias to the `latest`
   * [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   GetSecretVersionRequest request =
   *       GetSecretVersionRequest.newBuilder()
   *           .setName(SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString())
   *           .build();
   *   ApiFuture<SecretVersion> future =
   *       secretManagerServiceClient.getSecretVersionCallable().futureCall(request);
   *   // Do something.
   *   SecretVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSecretVersionRequest, SecretVersion> getSecretVersionCallable() {
    return stub.getSecretVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Accesses a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion]. This call returns the
   * secret data.
   *
   * <p>`projects/&#42;/secrets/&#42;/versions/latest` is an alias to the `latest`
   * [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");
   *   AccessSecretVersionResponse response = secretManagerServiceClient.accessSecretVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] in the format
   *     `projects/&#42;/secrets/&#42;/versions/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessSecretVersionResponse accessSecretVersion(SecretVersionName name) {
    AccessSecretVersionRequest request =
        AccessSecretVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return accessSecretVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Accesses a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion]. This call returns the
   * secret data.
   *
   * <p>`projects/&#42;/secrets/&#42;/versions/latest` is an alias to the `latest`
   * [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   String name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString();
   *   AccessSecretVersionResponse response = secretManagerServiceClient.accessSecretVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] in the format
   *     `projects/&#42;/secrets/&#42;/versions/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessSecretVersionResponse accessSecretVersion(String name) {
    AccessSecretVersionRequest request =
        AccessSecretVersionRequest.newBuilder().setName(name).build();
    return accessSecretVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Accesses a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion]. This call returns the
   * secret data.
   *
   * <p>`projects/&#42;/secrets/&#42;/versions/latest` is an alias to the `latest`
   * [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   AccessSecretVersionRequest request =
   *       AccessSecretVersionRequest.newBuilder()
   *           .setName(SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString())
   *           .build();
   *   AccessSecretVersionResponse response =
   *       secretManagerServiceClient.accessSecretVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AccessSecretVersionResponse accessSecretVersion(AccessSecretVersionRequest request) {
    return accessSecretVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Accesses a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion]. This call returns the
   * secret data.
   *
   * <p>`projects/&#42;/secrets/&#42;/versions/latest` is an alias to the `latest`
   * [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   AccessSecretVersionRequest request =
   *       AccessSecretVersionRequest.newBuilder()
   *           .setName(SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString())
   *           .build();
   *   ApiFuture<AccessSecretVersionResponse> future =
   *       secretManagerServiceClient.accessSecretVersionCallable().futureCall(request);
   *   // Do something.
   *   AccessSecretVersionResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AccessSecretVersionRequest, AccessSecretVersionResponse>
      accessSecretVersionCallable() {
    return stub.accessSecretVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>Sets the [state][google.cloud.secrets.v1beta1.SecretVersion.state] of the
   * [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] to
   * [DISABLED][google.cloud.secrets.v1beta1.SecretVersion.State.DISABLED].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");
   *   SecretVersion response = secretManagerServiceClient.disableSecretVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] to disable in the format
   *     `projects/&#42;/secrets/&#42;/versions/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecretVersion disableSecretVersion(SecretVersionName name) {
    DisableSecretVersionRequest request =
        DisableSecretVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return disableSecretVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>Sets the [state][google.cloud.secrets.v1beta1.SecretVersion.state] of the
   * [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] to
   * [DISABLED][google.cloud.secrets.v1beta1.SecretVersion.State.DISABLED].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   String name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString();
   *   SecretVersion response = secretManagerServiceClient.disableSecretVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] to disable in the format
   *     `projects/&#42;/secrets/&#42;/versions/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecretVersion disableSecretVersion(String name) {
    DisableSecretVersionRequest request =
        DisableSecretVersionRequest.newBuilder().setName(name).build();
    return disableSecretVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>Sets the [state][google.cloud.secrets.v1beta1.SecretVersion.state] of the
   * [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] to
   * [DISABLED][google.cloud.secrets.v1beta1.SecretVersion.State.DISABLED].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   DisableSecretVersionRequest request =
   *       DisableSecretVersionRequest.newBuilder()
   *           .setName(SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString())
   *           .build();
   *   SecretVersion response = secretManagerServiceClient.disableSecretVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecretVersion disableSecretVersion(DisableSecretVersionRequest request) {
    return disableSecretVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>Sets the [state][google.cloud.secrets.v1beta1.SecretVersion.state] of the
   * [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] to
   * [DISABLED][google.cloud.secrets.v1beta1.SecretVersion.State.DISABLED].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   DisableSecretVersionRequest request =
   *       DisableSecretVersionRequest.newBuilder()
   *           .setName(SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString())
   *           .build();
   *   ApiFuture<SecretVersion> future =
   *       secretManagerServiceClient.disableSecretVersionCallable().futureCall(request);
   *   // Do something.
   *   SecretVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DisableSecretVersionRequest, SecretVersion>
      disableSecretVersionCallable() {
    return stub.disableSecretVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>Sets the [state][google.cloud.secrets.v1beta1.SecretVersion.state] of the
   * [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] to
   * [ENABLED][google.cloud.secrets.v1beta1.SecretVersion.State.ENABLED].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");
   *   SecretVersion response = secretManagerServiceClient.enableSecretVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] to enable in the format
   *     `projects/&#42;/secrets/&#42;/versions/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecretVersion enableSecretVersion(SecretVersionName name) {
    EnableSecretVersionRequest request =
        EnableSecretVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return enableSecretVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>Sets the [state][google.cloud.secrets.v1beta1.SecretVersion.state] of the
   * [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] to
   * [ENABLED][google.cloud.secrets.v1beta1.SecretVersion.State.ENABLED].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   String name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString();
   *   SecretVersion response = secretManagerServiceClient.enableSecretVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] to enable in the format
   *     `projects/&#42;/secrets/&#42;/versions/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecretVersion enableSecretVersion(String name) {
    EnableSecretVersionRequest request =
        EnableSecretVersionRequest.newBuilder().setName(name).build();
    return enableSecretVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>Sets the [state][google.cloud.secrets.v1beta1.SecretVersion.state] of the
   * [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] to
   * [ENABLED][google.cloud.secrets.v1beta1.SecretVersion.State.ENABLED].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   EnableSecretVersionRequest request =
   *       EnableSecretVersionRequest.newBuilder()
   *           .setName(SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString())
   *           .build();
   *   SecretVersion response = secretManagerServiceClient.enableSecretVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecretVersion enableSecretVersion(EnableSecretVersionRequest request) {
    return enableSecretVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>Sets the [state][google.cloud.secrets.v1beta1.SecretVersion.state] of the
   * [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] to
   * [ENABLED][google.cloud.secrets.v1beta1.SecretVersion.State.ENABLED].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   EnableSecretVersionRequest request =
   *       EnableSecretVersionRequest.newBuilder()
   *           .setName(SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString())
   *           .build();
   *   ApiFuture<SecretVersion> future =
   *       secretManagerServiceClient.enableSecretVersionCallable().futureCall(request);
   *   // Do something.
   *   SecretVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EnableSecretVersionRequest, SecretVersion>
      enableSecretVersionCallable() {
    return stub.enableSecretVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Destroys a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>Sets the [state][google.cloud.secrets.v1beta1.SecretVersion.state] of the
   * [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] to
   * [DESTROYED][google.cloud.secrets.v1beta1.SecretVersion.State.DESTROYED] and irrevocably
   * destroys the secret data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   SecretVersionName name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]");
   *   SecretVersion response = secretManagerServiceClient.destroySecretVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] to destroy in the format
   *     `projects/&#42;/secrets/&#42;/versions/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecretVersion destroySecretVersion(SecretVersionName name) {
    DestroySecretVersionRequest request =
        DestroySecretVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return destroySecretVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Destroys a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>Sets the [state][google.cloud.secrets.v1beta1.SecretVersion.state] of the
   * [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] to
   * [DESTROYED][google.cloud.secrets.v1beta1.SecretVersion.State.DESTROYED] and irrevocably
   * destroys the secret data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   String name = SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString();
   *   SecretVersion response = secretManagerServiceClient.destroySecretVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] to destroy in the format
   *     `projects/&#42;/secrets/&#42;/versions/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecretVersion destroySecretVersion(String name) {
    DestroySecretVersionRequest request =
        DestroySecretVersionRequest.newBuilder().setName(name).build();
    return destroySecretVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Destroys a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>Sets the [state][google.cloud.secrets.v1beta1.SecretVersion.state] of the
   * [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] to
   * [DESTROYED][google.cloud.secrets.v1beta1.SecretVersion.State.DESTROYED] and irrevocably
   * destroys the secret data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   DestroySecretVersionRequest request =
   *       DestroySecretVersionRequest.newBuilder()
   *           .setName(SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString())
   *           .build();
   *   SecretVersion response = secretManagerServiceClient.destroySecretVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecretVersion destroySecretVersion(DestroySecretVersionRequest request) {
    return destroySecretVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Destroys a [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion].
   *
   * <p>Sets the [state][google.cloud.secrets.v1beta1.SecretVersion.state] of the
   * [SecretVersion][google.cloud.secrets.v1beta1.SecretVersion] to
   * [DESTROYED][google.cloud.secrets.v1beta1.SecretVersion.State.DESTROYED] and irrevocably
   * destroys the secret data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   DestroySecretVersionRequest request =
   *       DestroySecretVersionRequest.newBuilder()
   *           .setName(SecretVersionName.of("[PROJECT]", "[SECRET]", "[SECRET_VERSION]").toString())
   *           .build();
   *   ApiFuture<SecretVersion> future =
   *       secretManagerServiceClient.destroySecretVersionCallable().futureCall(request);
   *   // Do something.
   *   SecretVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DestroySecretVersionRequest, SecretVersion>
      destroySecretVersionCallable() {
    return stub.destroySecretVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified secret. Replaces any existing policy.
   *
   * <p>Permissions on [SecretVersions][google.cloud.secrets.v1beta1.SecretVersion] are enforced
   * according to the policy set on the associated [Secret][google.cloud.secrets.v1beta1.Secret].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(SecretName.of("[PROJECT]", "[SECRET]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = secretManagerServiceClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified secret. Replaces any existing policy.
   *
   * <p>Permissions on [SecretVersions][google.cloud.secrets.v1beta1.SecretVersion] are enforced
   * according to the policy set on the associated [Secret][google.cloud.secrets.v1beta1.Secret].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(SecretName.of("[PROJECT]", "[SECRET]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       secretManagerServiceClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a secret. Returns empty policy if the secret exists and does
   * not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(SecretName.of("[PROJECT]", "[SECRET]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = secretManagerServiceClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a secret. Returns empty policy if the secret exists and does
   * not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(SecretName.of("[PROJECT]", "[SECRET]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       secretManagerServiceClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has for the specified secret. If the secret does not exist,
   * this call returns an empty set of permissions, not a NOT_FOUND error.
   *
   * <p>Note: This operation is designed to be used for building permission-aware UIs and
   * command-line tools, not for authorization checking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(SecretName.of("[PROJECT]", "[SECRET]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = secretManagerServiceClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has for the specified secret. If the secret does not exist,
   * this call returns an empty set of permissions, not a NOT_FOUND error.
   *
   * <p>Note: This operation is designed to be used for building permission-aware UIs and
   * command-line tools, not for authorization checking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecretManagerServiceClient secretManagerServiceClient =
   *     SecretManagerServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(SecretName.of("[PROJECT]", "[SECRET]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       secretManagerServiceClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
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

  public static class ListSecretsPagedResponse
      extends AbstractPagedListResponse<
          ListSecretsRequest,
          ListSecretsResponse,
          Secret,
          ListSecretsPage,
          ListSecretsFixedSizeCollection> {

    public static ApiFuture<ListSecretsPagedResponse> createAsync(
        PageContext<ListSecretsRequest, ListSecretsResponse, Secret> context,
        ApiFuture<ListSecretsResponse> futureResponse) {
      ApiFuture<ListSecretsPage> futurePage =
          ListSecretsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSecretsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSecretsPagedResponse(ListSecretsPage page) {
      super(page, ListSecretsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSecretsPage
      extends AbstractPage<ListSecretsRequest, ListSecretsResponse, Secret, ListSecretsPage> {

    private ListSecretsPage(
        PageContext<ListSecretsRequest, ListSecretsResponse, Secret> context,
        ListSecretsResponse response) {
      super(context, response);
    }

    private static ListSecretsPage createEmptyPage() {
      return new ListSecretsPage(null, null);
    }

    @Override
    protected ListSecretsPage createPage(
        PageContext<ListSecretsRequest, ListSecretsResponse, Secret> context,
        ListSecretsResponse response) {
      return new ListSecretsPage(context, response);
    }

    @Override
    public ApiFuture<ListSecretsPage> createPageAsync(
        PageContext<ListSecretsRequest, ListSecretsResponse, Secret> context,
        ApiFuture<ListSecretsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSecretsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSecretsRequest,
          ListSecretsResponse,
          Secret,
          ListSecretsPage,
          ListSecretsFixedSizeCollection> {

    private ListSecretsFixedSizeCollection(List<ListSecretsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSecretsFixedSizeCollection createEmptyCollection() {
      return new ListSecretsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSecretsFixedSizeCollection createCollection(
        List<ListSecretsPage> pages, int collectionSize) {
      return new ListSecretsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSecretVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListSecretVersionsRequest,
          ListSecretVersionsResponse,
          SecretVersion,
          ListSecretVersionsPage,
          ListSecretVersionsFixedSizeCollection> {

    public static ApiFuture<ListSecretVersionsPagedResponse> createAsync(
        PageContext<ListSecretVersionsRequest, ListSecretVersionsResponse, SecretVersion> context,
        ApiFuture<ListSecretVersionsResponse> futureResponse) {
      ApiFuture<ListSecretVersionsPage> futurePage =
          ListSecretVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSecretVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSecretVersionsPagedResponse(ListSecretVersionsPage page) {
      super(page, ListSecretVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSecretVersionsPage
      extends AbstractPage<
          ListSecretVersionsRequest,
          ListSecretVersionsResponse,
          SecretVersion,
          ListSecretVersionsPage> {

    private ListSecretVersionsPage(
        PageContext<ListSecretVersionsRequest, ListSecretVersionsResponse, SecretVersion> context,
        ListSecretVersionsResponse response) {
      super(context, response);
    }

    private static ListSecretVersionsPage createEmptyPage() {
      return new ListSecretVersionsPage(null, null);
    }

    @Override
    protected ListSecretVersionsPage createPage(
        PageContext<ListSecretVersionsRequest, ListSecretVersionsResponse, SecretVersion> context,
        ListSecretVersionsResponse response) {
      return new ListSecretVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListSecretVersionsPage> createPageAsync(
        PageContext<ListSecretVersionsRequest, ListSecretVersionsResponse, SecretVersion> context,
        ApiFuture<ListSecretVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSecretVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSecretVersionsRequest,
          ListSecretVersionsResponse,
          SecretVersion,
          ListSecretVersionsPage,
          ListSecretVersionsFixedSizeCollection> {

    private ListSecretVersionsFixedSizeCollection(
        List<ListSecretVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSecretVersionsFixedSizeCollection createEmptyCollection() {
      return new ListSecretVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSecretVersionsFixedSizeCollection createCollection(
        List<ListSecretVersionsPage> pages, int collectionSize) {
      return new ListSecretVersionsFixedSizeCollection(pages, collectionSize);
    }
  }
}
