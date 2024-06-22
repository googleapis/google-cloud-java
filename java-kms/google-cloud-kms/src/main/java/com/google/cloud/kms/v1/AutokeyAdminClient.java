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

package com.google.cloud.kms.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.kms.v1.stub.AutokeyAdminStub;
import com.google.cloud.kms.v1.stub.AutokeyAdminStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides interfaces for managing Cloud KMS Autokey folder-level
 * configurations. A configuration is inherited by all descendent projects. A configuration at one
 * folder overrides any other configurations in its ancestry. Setting a configuration on a folder is
 * a prerequisite for Cloud KMS Autokey, so that users working in a descendant project can request
 * provisioned [CryptoKeys][google.cloud.kms.v1.CryptoKey], ready for Customer Managed Encryption
 * Key (CMEK) use, on-demand.
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
 * try (AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create()) {
 *   AutokeyConfig autokeyConfig = AutokeyConfig.newBuilder().build();
 *   FieldMask updateMask = FieldMask.newBuilder().build();
 *   AutokeyConfig response = autokeyAdminClient.updateAutokeyConfig(autokeyConfig, updateMask);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AutokeyAdminClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAutokeyConfig</td>
 *      <td><p> Updates the [AutokeyConfig][google.cloud.kms.v1.AutokeyConfig] for a folder. The caller must have both `cloudkms.autokeyConfigs.update` permission on the parent folder and `cloudkms.cryptoKeys.setIamPolicy` permission on the provided key project. A [KeyHandle][google.cloud.kms.v1.KeyHandle] creation in the folder's descendant projects will use this configuration to determine where to create the resulting [CryptoKey][google.cloud.kms.v1.CryptoKey].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAutokeyConfig(UpdateAutokeyConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateAutokeyConfig(AutokeyConfig autokeyConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAutokeyConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAutokeyConfig</td>
 *      <td><p> Returns the [AutokeyConfig][google.cloud.kms.v1.AutokeyConfig] for a folder.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAutokeyConfig(GetAutokeyConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAutokeyConfig(AutokeyConfigName name)
 *           <li><p> getAutokeyConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAutokeyConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ShowEffectiveAutokeyConfig</td>
 *      <td><p> Returns the effective Cloud KMS Autokey configuration for a given project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> showEffectiveAutokeyConfig(ShowEffectiveAutokeyConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> showEffectiveAutokeyConfig(ProjectName parent)
 *           <li><p> showEffectiveAutokeyConfig(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> showEffectiveAutokeyConfigCallable()
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
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified resource. Replacesany existing policy.
 * <p> Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.</td>
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
 *      <td><p> Gets the access control policy for a resource. Returns an empty policyif the resource exists and does not have a policy set.</td>
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
 *      <td><p> Returns permissions that a caller has on the specified resource. If theresource does not exist, this will return an empty set ofpermissions, not a `NOT_FOUND` error.
 * <p> Note: This operation is designed to be used for buildingpermission-aware UIs and command-line tools, not for authorizationchecking. This operation may "fail open" without warning.</td>
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
 * <p>This class can be customized by passing in a custom instance of AutokeyAdminSettings to
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
 * AutokeyAdminSettings autokeyAdminSettings =
 *     AutokeyAdminSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create(autokeyAdminSettings);
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
 * AutokeyAdminSettings autokeyAdminSettings =
 *     AutokeyAdminSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create(autokeyAdminSettings);
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
 * AutokeyAdminSettings autokeyAdminSettings = AutokeyAdminSettings.newHttpJsonBuilder().build();
 * AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create(autokeyAdminSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AutokeyAdminClient implements BackgroundResource {
  private final AutokeyAdminSettings settings;
  private final AutokeyAdminStub stub;

  /** Constructs an instance of AutokeyAdminClient with default settings. */
  public static final AutokeyAdminClient create() throws IOException {
    return create(AutokeyAdminSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AutokeyAdminClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AutokeyAdminClient create(AutokeyAdminSettings settings) throws IOException {
    return new AutokeyAdminClient(settings);
  }

  /**
   * Constructs an instance of AutokeyAdminClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(AutokeyAdminSettings).
   */
  public static final AutokeyAdminClient create(AutokeyAdminStub stub) {
    return new AutokeyAdminClient(stub);
  }

  /**
   * Constructs an instance of AutokeyAdminClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AutokeyAdminClient(AutokeyAdminSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AutokeyAdminStubSettings) settings.getStubSettings()).createStub();
  }

  protected AutokeyAdminClient(AutokeyAdminStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AutokeyAdminSettings getSettings() {
    return settings;
  }

  public AutokeyAdminStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [AutokeyConfig][google.cloud.kms.v1.AutokeyConfig] for a folder. The caller must
   * have both `cloudkms.autokeyConfigs.update` permission on the parent folder and
   * `cloudkms.cryptoKeys.setIamPolicy` permission on the provided key project. A
   * [KeyHandle][google.cloud.kms.v1.KeyHandle] creation in the folder's descendant projects will
   * use this configuration to determine where to create the resulting
   * [CryptoKey][google.cloud.kms.v1.CryptoKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create()) {
   *   AutokeyConfig autokeyConfig = AutokeyConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AutokeyConfig response = autokeyAdminClient.updateAutokeyConfig(autokeyConfig, updateMask);
   * }
   * }</pre>
   *
   * @param autokeyConfig Required. [AutokeyConfig][google.cloud.kms.v1.AutokeyConfig] with values
   *     to update.
   * @param updateMask Required. Masks which fields of the
   *     [AutokeyConfig][google.cloud.kms.v1.AutokeyConfig] to update, e.g. `keyProject`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutokeyConfig updateAutokeyConfig(
      AutokeyConfig autokeyConfig, FieldMask updateMask) {
    UpdateAutokeyConfigRequest request =
        UpdateAutokeyConfigRequest.newBuilder()
            .setAutokeyConfig(autokeyConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateAutokeyConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [AutokeyConfig][google.cloud.kms.v1.AutokeyConfig] for a folder. The caller must
   * have both `cloudkms.autokeyConfigs.update` permission on the parent folder and
   * `cloudkms.cryptoKeys.setIamPolicy` permission on the provided key project. A
   * [KeyHandle][google.cloud.kms.v1.KeyHandle] creation in the folder's descendant projects will
   * use this configuration to determine where to create the resulting
   * [CryptoKey][google.cloud.kms.v1.CryptoKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create()) {
   *   UpdateAutokeyConfigRequest request =
   *       UpdateAutokeyConfigRequest.newBuilder()
   *           .setAutokeyConfig(AutokeyConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AutokeyConfig response = autokeyAdminClient.updateAutokeyConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutokeyConfig updateAutokeyConfig(UpdateAutokeyConfigRequest request) {
    return updateAutokeyConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [AutokeyConfig][google.cloud.kms.v1.AutokeyConfig] for a folder. The caller must
   * have both `cloudkms.autokeyConfigs.update` permission on the parent folder and
   * `cloudkms.cryptoKeys.setIamPolicy` permission on the provided key project. A
   * [KeyHandle][google.cloud.kms.v1.KeyHandle] creation in the folder's descendant projects will
   * use this configuration to determine where to create the resulting
   * [CryptoKey][google.cloud.kms.v1.CryptoKey].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create()) {
   *   UpdateAutokeyConfigRequest request =
   *       UpdateAutokeyConfigRequest.newBuilder()
   *           .setAutokeyConfig(AutokeyConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<AutokeyConfig> future =
   *       autokeyAdminClient.updateAutokeyConfigCallable().futureCall(request);
   *   // Do something.
   *   AutokeyConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAutokeyConfigRequest, AutokeyConfig>
      updateAutokeyConfigCallable() {
    return stub.updateAutokeyConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the [AutokeyConfig][google.cloud.kms.v1.AutokeyConfig] for a folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create()) {
   *   AutokeyConfigName name = AutokeyConfigName.of("[FOLDER]");
   *   AutokeyConfig response = autokeyAdminClient.getAutokeyConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the [AutokeyConfig][google.cloud.kms.v1.AutokeyConfig] resource,
   *     e.g. `folders/{FOLDER_NUMBER}/autokeyConfig`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutokeyConfig getAutokeyConfig(AutokeyConfigName name) {
    GetAutokeyConfigRequest request =
        GetAutokeyConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAutokeyConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the [AutokeyConfig][google.cloud.kms.v1.AutokeyConfig] for a folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create()) {
   *   String name = AutokeyConfigName.of("[FOLDER]").toString();
   *   AutokeyConfig response = autokeyAdminClient.getAutokeyConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the [AutokeyConfig][google.cloud.kms.v1.AutokeyConfig] resource,
   *     e.g. `folders/{FOLDER_NUMBER}/autokeyConfig`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutokeyConfig getAutokeyConfig(String name) {
    GetAutokeyConfigRequest request = GetAutokeyConfigRequest.newBuilder().setName(name).build();
    return getAutokeyConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the [AutokeyConfig][google.cloud.kms.v1.AutokeyConfig] for a folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create()) {
   *   GetAutokeyConfigRequest request =
   *       GetAutokeyConfigRequest.newBuilder()
   *           .setName(AutokeyConfigName.of("[FOLDER]").toString())
   *           .build();
   *   AutokeyConfig response = autokeyAdminClient.getAutokeyConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutokeyConfig getAutokeyConfig(GetAutokeyConfigRequest request) {
    return getAutokeyConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the [AutokeyConfig][google.cloud.kms.v1.AutokeyConfig] for a folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create()) {
   *   GetAutokeyConfigRequest request =
   *       GetAutokeyConfigRequest.newBuilder()
   *           .setName(AutokeyConfigName.of("[FOLDER]").toString())
   *           .build();
   *   ApiFuture<AutokeyConfig> future =
   *       autokeyAdminClient.getAutokeyConfigCallable().futureCall(request);
   *   // Do something.
   *   AutokeyConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAutokeyConfigRequest, AutokeyConfig> getAutokeyConfigCallable() {
    return stub.getAutokeyConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the effective Cloud KMS Autokey configuration for a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ShowEffectiveAutokeyConfigResponse response =
   *       autokeyAdminClient.showEffectiveAutokeyConfig(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Name of the resource project to the show effective Cloud KMS Autokey
   *     configuration for. This may be helpful for interrogating the effect of nested folder
   *     configurations on a given resource project.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ShowEffectiveAutokeyConfigResponse showEffectiveAutokeyConfig(ProjectName parent) {
    ShowEffectiveAutokeyConfigRequest request =
        ShowEffectiveAutokeyConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return showEffectiveAutokeyConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the effective Cloud KMS Autokey configuration for a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   ShowEffectiveAutokeyConfigResponse response =
   *       autokeyAdminClient.showEffectiveAutokeyConfig(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Name of the resource project to the show effective Cloud KMS Autokey
   *     configuration for. This may be helpful for interrogating the effect of nested folder
   *     configurations on a given resource project.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ShowEffectiveAutokeyConfigResponse showEffectiveAutokeyConfig(String parent) {
    ShowEffectiveAutokeyConfigRequest request =
        ShowEffectiveAutokeyConfigRequest.newBuilder().setParent(parent).build();
    return showEffectiveAutokeyConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the effective Cloud KMS Autokey configuration for a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create()) {
   *   ShowEffectiveAutokeyConfigRequest request =
   *       ShowEffectiveAutokeyConfigRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .build();
   *   ShowEffectiveAutokeyConfigResponse response =
   *       autokeyAdminClient.showEffectiveAutokeyConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ShowEffectiveAutokeyConfigResponse showEffectiveAutokeyConfig(
      ShowEffectiveAutokeyConfigRequest request) {
    return showEffectiveAutokeyConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the effective Cloud KMS Autokey configuration for a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create()) {
   *   ShowEffectiveAutokeyConfigRequest request =
   *       ShowEffectiveAutokeyConfigRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .build();
   *   ApiFuture<ShowEffectiveAutokeyConfigResponse> future =
   *       autokeyAdminClient.showEffectiveAutokeyConfigCallable().futureCall(request);
   *   // Do something.
   *   ShowEffectiveAutokeyConfigResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ShowEffectiveAutokeyConfigRequest, ShowEffectiveAutokeyConfigResponse>
      showEffectiveAutokeyConfigCallable() {
    return stub.showEffectiveAutokeyConfigCallable();
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
   * try (AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : autokeyAdminClient.listLocations(request).iterateAll()) {
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
   * try (AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       autokeyAdminClient.listLocationsPagedCallable().futureCall(request);
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
   * try (AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = autokeyAdminClient.listLocationsCallable().call(request);
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
   * try (AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = autokeyAdminClient.getLocation(request);
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
   * try (AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = autokeyAdminClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(AutokeyConfigName.of("[FOLDER]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = autokeyAdminClient.setIamPolicy(request);
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
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(AutokeyConfigName.of("[FOLDER]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = autokeyAdminClient.setIamPolicyCallable().futureCall(request);
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
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(AutokeyConfigName.of("[FOLDER]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = autokeyAdminClient.getIamPolicy(request);
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
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(AutokeyConfigName.of("[FOLDER]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = autokeyAdminClient.getIamPolicyCallable().futureCall(request);
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
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
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
   * try (AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(AutokeyConfigName.of("[FOLDER]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = autokeyAdminClient.testIamPermissions(request);
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
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
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
   * try (AutokeyAdminClient autokeyAdminClient = AutokeyAdminClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(AutokeyConfigName.of("[FOLDER]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       autokeyAdminClient.testIamPermissionsCallable().futureCall(request);
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
