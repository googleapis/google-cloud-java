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

package com.google.cloud.aiplatform.v1beta1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.stub.ExtensionRegistryServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.ExtensionRegistryServiceStubSettings;
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
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service for managing Vertex AI's Extension registry.
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
 * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
 *     ExtensionRegistryServiceClient.create()) {
 *   ExtensionName name = ExtensionName.of("[PROJECT]", "[LOCATION]", "[EXTENSION]");
 *   Extension response = extensionRegistryServiceClient.getExtension(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ExtensionRegistryServiceClient object to clean up
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
 *      <td><p> ImportExtension</td>
 *      <td><p> Imports an Extension.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importExtensionAsync(ImportExtensionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> importExtensionAsync(LocationName parent, Extension extension)
 *           <li><p> importExtensionAsync(String parent, Extension extension)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importExtensionOperationCallable()
 *           <li><p> importExtensionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetExtension</td>
 *      <td><p> Gets an Extension.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getExtension(GetExtensionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getExtension(ExtensionName name)
 *           <li><p> getExtension(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getExtensionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListExtensions</td>
 *      <td><p> Lists Extensions in a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listExtensions(ListExtensionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listExtensions(LocationName parent)
 *           <li><p> listExtensions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listExtensionsPagedCallable()
 *           <li><p> listExtensionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateExtension</td>
 *      <td><p> Updates an Extension.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateExtension(UpdateExtensionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateExtension(Extension extension, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateExtensionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteExtension</td>
 *      <td><p> Deletes an Extension.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteExtensionAsync(DeleteExtensionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteExtensionAsync(ExtensionName name)
 *           <li><p> deleteExtensionAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteExtensionOperationCallable()
 *           <li><p> deleteExtensionCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * ExtensionRegistryServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ExtensionRegistryServiceSettings extensionRegistryServiceSettings =
 *     ExtensionRegistryServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ExtensionRegistryServiceClient extensionRegistryServiceClient =
 *     ExtensionRegistryServiceClient.create(extensionRegistryServiceSettings);
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
 * ExtensionRegistryServiceSettings extensionRegistryServiceSettings =
 *     ExtensionRegistryServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ExtensionRegistryServiceClient extensionRegistryServiceClient =
 *     ExtensionRegistryServiceClient.create(extensionRegistryServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ExtensionRegistryServiceClient implements BackgroundResource {
  private final ExtensionRegistryServiceSettings settings;
  private final ExtensionRegistryServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of ExtensionRegistryServiceClient with default settings. */
  public static final ExtensionRegistryServiceClient create() throws IOException {
    return create(ExtensionRegistryServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ExtensionRegistryServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final ExtensionRegistryServiceClient create(
      ExtensionRegistryServiceSettings settings) throws IOException {
    return new ExtensionRegistryServiceClient(settings);
  }

  /**
   * Constructs an instance of ExtensionRegistryServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(ExtensionRegistryServiceSettings).
   */
  public static final ExtensionRegistryServiceClient create(ExtensionRegistryServiceStub stub) {
    return new ExtensionRegistryServiceClient(stub);
  }

  /**
   * Constructs an instance of ExtensionRegistryServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ExtensionRegistryServiceClient(ExtensionRegistryServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((ExtensionRegistryServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected ExtensionRegistryServiceClient(ExtensionRegistryServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final ExtensionRegistryServiceSettings getSettings() {
    return settings;
  }

  public ExtensionRegistryServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports an Extension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Extension extension = Extension.newBuilder().build();
   *   Extension response =
   *       extensionRegistryServiceClient.importExtensionAsync(parent, extension).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to import the Extension in. Format:
   *     `projects/{project}/locations/{location}`
   * @param extension Required. The Extension to import.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Extension, ImportExtensionOperationMetadata> importExtensionAsync(
      LocationName parent, Extension extension) {
    ImportExtensionRequest request =
        ImportExtensionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setExtension(extension)
            .build();
    return importExtensionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports an Extension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Extension extension = Extension.newBuilder().build();
   *   Extension response =
   *       extensionRegistryServiceClient.importExtensionAsync(parent, extension).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to import the Extension in. Format:
   *     `projects/{project}/locations/{location}`
   * @param extension Required. The Extension to import.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Extension, ImportExtensionOperationMetadata> importExtensionAsync(
      String parent, Extension extension) {
    ImportExtensionRequest request =
        ImportExtensionRequest.newBuilder().setParent(parent).setExtension(extension).build();
    return importExtensionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports an Extension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   ImportExtensionRequest request =
   *       ImportExtensionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setExtension(Extension.newBuilder().build())
   *           .build();
   *   Extension response = extensionRegistryServiceClient.importExtensionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Extension, ImportExtensionOperationMetadata> importExtensionAsync(
      ImportExtensionRequest request) {
    return importExtensionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports an Extension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   ImportExtensionRequest request =
   *       ImportExtensionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setExtension(Extension.newBuilder().build())
   *           .build();
   *   OperationFuture<Extension, ImportExtensionOperationMetadata> future =
   *       extensionRegistryServiceClient.importExtensionOperationCallable().futureCall(request);
   *   // Do something.
   *   Extension response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ImportExtensionRequest, Extension, ImportExtensionOperationMetadata>
      importExtensionOperationCallable() {
    return stub.importExtensionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports an Extension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   ImportExtensionRequest request =
   *       ImportExtensionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setExtension(Extension.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       extensionRegistryServiceClient.importExtensionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportExtensionRequest, Operation> importExtensionCallable() {
    return stub.importExtensionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an Extension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   ExtensionName name = ExtensionName.of("[PROJECT]", "[LOCATION]", "[EXTENSION]");
   *   Extension response = extensionRegistryServiceClient.getExtension(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Extension resource. Format:
   *     `projects/{project}/locations/{location}/extensions/{extension}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Extension getExtension(ExtensionName name) {
    GetExtensionRequest request =
        GetExtensionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getExtension(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an Extension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   String name = ExtensionName.of("[PROJECT]", "[LOCATION]", "[EXTENSION]").toString();
   *   Extension response = extensionRegistryServiceClient.getExtension(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Extension resource. Format:
   *     `projects/{project}/locations/{location}/extensions/{extension}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Extension getExtension(String name) {
    GetExtensionRequest request = GetExtensionRequest.newBuilder().setName(name).build();
    return getExtension(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an Extension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   GetExtensionRequest request =
   *       GetExtensionRequest.newBuilder()
   *           .setName(ExtensionName.of("[PROJECT]", "[LOCATION]", "[EXTENSION]").toString())
   *           .build();
   *   Extension response = extensionRegistryServiceClient.getExtension(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Extension getExtension(GetExtensionRequest request) {
    return getExtensionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an Extension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   GetExtensionRequest request =
   *       GetExtensionRequest.newBuilder()
   *           .setName(ExtensionName.of("[PROJECT]", "[LOCATION]", "[EXTENSION]").toString())
   *           .build();
   *   ApiFuture<Extension> future =
   *       extensionRegistryServiceClient.getExtensionCallable().futureCall(request);
   *   // Do something.
   *   Extension response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetExtensionRequest, Extension> getExtensionCallable() {
    return stub.getExtensionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Extensions in a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Extension element : extensionRegistryServiceClient.listExtensions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the Extensions from. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExtensionsPagedResponse listExtensions(LocationName parent) {
    ListExtensionsRequest request =
        ListExtensionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listExtensions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Extensions in a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Extension element : extensionRegistryServiceClient.listExtensions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the Extensions from. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExtensionsPagedResponse listExtensions(String parent) {
    ListExtensionsRequest request = ListExtensionsRequest.newBuilder().setParent(parent).build();
    return listExtensions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Extensions in a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   ListExtensionsRequest request =
   *       ListExtensionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Extension element :
   *       extensionRegistryServiceClient.listExtensions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExtensionsPagedResponse listExtensions(ListExtensionsRequest request) {
    return listExtensionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Extensions in a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   ListExtensionsRequest request =
   *       ListExtensionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Extension> future =
   *       extensionRegistryServiceClient.listExtensionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Extension element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListExtensionsRequest, ListExtensionsPagedResponse>
      listExtensionsPagedCallable() {
    return stub.listExtensionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Extensions in a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   ListExtensionsRequest request =
   *       ListExtensionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListExtensionsResponse response =
   *         extensionRegistryServiceClient.listExtensionsCallable().call(request);
   *     for (Extension element : response.getExtensionsList()) {
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
  public final UnaryCallable<ListExtensionsRequest, ListExtensionsResponse>
      listExtensionsCallable() {
    return stub.listExtensionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Extension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   Extension extension = Extension.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Extension response = extensionRegistryServiceClient.updateExtension(extension, updateMask);
   * }
   * }</pre>
   *
   * @param extension Required. The Extension which replaces the resource on the server.
   * @param updateMask Required. Mask specifying which fields to update. Supported fields:
   *     <p>&#42; `display_name` &#42; `description` &#42; `runtime_config` &#42;
   *     `tool_use_examples` &#42; `manifest.description`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Extension updateExtension(Extension extension, FieldMask updateMask) {
    UpdateExtensionRequest request =
        UpdateExtensionRequest.newBuilder()
            .setExtension(extension)
            .setUpdateMask(updateMask)
            .build();
    return updateExtension(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Extension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   UpdateExtensionRequest request =
   *       UpdateExtensionRequest.newBuilder()
   *           .setExtension(Extension.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Extension response = extensionRegistryServiceClient.updateExtension(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Extension updateExtension(UpdateExtensionRequest request) {
    return updateExtensionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Extension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   UpdateExtensionRequest request =
   *       UpdateExtensionRequest.newBuilder()
   *           .setExtension(Extension.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Extension> future =
   *       extensionRegistryServiceClient.updateExtensionCallable().futureCall(request);
   *   // Do something.
   *   Extension response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateExtensionRequest, Extension> updateExtensionCallable() {
    return stub.updateExtensionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Extension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   ExtensionName name = ExtensionName.of("[PROJECT]", "[LOCATION]", "[EXTENSION]");
   *   extensionRegistryServiceClient.deleteExtensionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Extension resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/extensions/{extension}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteExtensionAsync(
      ExtensionName name) {
    DeleteExtensionRequest request =
        DeleteExtensionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteExtensionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Extension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   String name = ExtensionName.of("[PROJECT]", "[LOCATION]", "[EXTENSION]").toString();
   *   extensionRegistryServiceClient.deleteExtensionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Extension resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/extensions/{extension}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteExtensionAsync(String name) {
    DeleteExtensionRequest request = DeleteExtensionRequest.newBuilder().setName(name).build();
    return deleteExtensionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Extension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   DeleteExtensionRequest request =
   *       DeleteExtensionRequest.newBuilder()
   *           .setName(ExtensionName.of("[PROJECT]", "[LOCATION]", "[EXTENSION]").toString())
   *           .build();
   *   extensionRegistryServiceClient.deleteExtensionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteExtensionAsync(
      DeleteExtensionRequest request) {
    return deleteExtensionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Extension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   DeleteExtensionRequest request =
   *       DeleteExtensionRequest.newBuilder()
   *           .setName(ExtensionName.of("[PROJECT]", "[LOCATION]", "[EXTENSION]").toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       extensionRegistryServiceClient.deleteExtensionOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteExtensionRequest, Empty, DeleteOperationMetadata>
      deleteExtensionOperationCallable() {
    return stub.deleteExtensionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Extension.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   DeleteExtensionRequest request =
   *       DeleteExtensionRequest.newBuilder()
   *           .setName(ExtensionName.of("[PROJECT]", "[LOCATION]", "[EXTENSION]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       extensionRegistryServiceClient.deleteExtensionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteExtensionRequest, Operation> deleteExtensionCallable() {
    return stub.deleteExtensionCallable();
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
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : extensionRegistryServiceClient.listLocations(request).iterateAll()) {
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
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       extensionRegistryServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         extensionRegistryServiceClient.listLocationsCallable().call(request);
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
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = extensionRegistryServiceClient.getLocation(request);
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
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       extensionRegistryServiceClient.getLocationCallable().futureCall(request);
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
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AnnotationSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[ANNOTATION_SPEC]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = extensionRegistryServiceClient.setIamPolicy(request);
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
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AnnotationSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[ANNOTATION_SPEC]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       extensionRegistryServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AnnotationSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[ANNOTATION_SPEC]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = extensionRegistryServiceClient.getIamPolicy(request);
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
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AnnotationSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[ANNOTATION_SPEC]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       extensionRegistryServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AnnotationSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[ANNOTATION_SPEC]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response =
   *       extensionRegistryServiceClient.testIamPermissions(request);
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
   * try (ExtensionRegistryServiceClient extensionRegistryServiceClient =
   *     ExtensionRegistryServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AnnotationSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[ANNOTATION_SPEC]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       extensionRegistryServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListExtensionsPagedResponse
      extends AbstractPagedListResponse<
          ListExtensionsRequest,
          ListExtensionsResponse,
          Extension,
          ListExtensionsPage,
          ListExtensionsFixedSizeCollection> {

    public static ApiFuture<ListExtensionsPagedResponse> createAsync(
        PageContext<ListExtensionsRequest, ListExtensionsResponse, Extension> context,
        ApiFuture<ListExtensionsResponse> futureResponse) {
      ApiFuture<ListExtensionsPage> futurePage =
          ListExtensionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListExtensionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListExtensionsPagedResponse(ListExtensionsPage page) {
      super(page, ListExtensionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListExtensionsPage
      extends AbstractPage<
          ListExtensionsRequest, ListExtensionsResponse, Extension, ListExtensionsPage> {

    private ListExtensionsPage(
        PageContext<ListExtensionsRequest, ListExtensionsResponse, Extension> context,
        ListExtensionsResponse response) {
      super(context, response);
    }

    private static ListExtensionsPage createEmptyPage() {
      return new ListExtensionsPage(null, null);
    }

    @Override
    protected ListExtensionsPage createPage(
        PageContext<ListExtensionsRequest, ListExtensionsResponse, Extension> context,
        ListExtensionsResponse response) {
      return new ListExtensionsPage(context, response);
    }

    @Override
    public ApiFuture<ListExtensionsPage> createPageAsync(
        PageContext<ListExtensionsRequest, ListExtensionsResponse, Extension> context,
        ApiFuture<ListExtensionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListExtensionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListExtensionsRequest,
          ListExtensionsResponse,
          Extension,
          ListExtensionsPage,
          ListExtensionsFixedSizeCollection> {

    private ListExtensionsFixedSizeCollection(List<ListExtensionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListExtensionsFixedSizeCollection createEmptyCollection() {
      return new ListExtensionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListExtensionsFixedSizeCollection createCollection(
        List<ListExtensionsPage> pages, int collectionSize) {
      return new ListExtensionsFixedSizeCollection(pages, collectionSize);
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
