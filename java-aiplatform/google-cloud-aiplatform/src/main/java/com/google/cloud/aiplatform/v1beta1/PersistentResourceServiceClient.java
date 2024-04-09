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
import com.google.cloud.aiplatform.v1beta1.stub.PersistentResourceServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.PersistentResourceServiceStubSettings;
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
 * Service Description: A service for managing Vertex AI's machine learning PersistentResource.
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
 * try (PersistentResourceServiceClient persistentResourceServiceClient =
 *     PersistentResourceServiceClient.create()) {
 *   PersistentResourceName name =
 *       PersistentResourceName.of("[PROJECT]", "[LOCATION]", "[PERSISTENT_RESOURCE]");
 *   PersistentResource response = persistentResourceServiceClient.getPersistentResource(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PersistentResourceServiceClient object to clean up
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
 *      <td><p> CreatePersistentResource</td>
 *      <td><p> Creates a PersistentResource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createPersistentResourceAsync(CreatePersistentResourceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createPersistentResourceAsync(LocationName parent, PersistentResource persistentResource, String persistentResourceId)
 *           <li><p> createPersistentResourceAsync(String parent, PersistentResource persistentResource, String persistentResourceId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createPersistentResourceOperationCallable()
 *           <li><p> createPersistentResourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPersistentResource</td>
 *      <td><p> Gets a PersistentResource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPersistentResource(GetPersistentResourceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPersistentResource(PersistentResourceName name)
 *           <li><p> getPersistentResource(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPersistentResourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPersistentResources</td>
 *      <td><p> Lists PersistentResources in a Location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPersistentResources(ListPersistentResourcesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPersistentResources(LocationName parent)
 *           <li><p> listPersistentResources(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPersistentResourcesPagedCallable()
 *           <li><p> listPersistentResourcesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeletePersistentResource</td>
 *      <td><p> Deletes a PersistentResource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deletePersistentResourceAsync(DeletePersistentResourceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deletePersistentResourceAsync(PersistentResourceName name)
 *           <li><p> deletePersistentResourceAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deletePersistentResourceOperationCallable()
 *           <li><p> deletePersistentResourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePersistentResource</td>
 *      <td><p> Updates a PersistentResource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePersistentResourceAsync(UpdatePersistentResourceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updatePersistentResourceAsync(PersistentResource persistentResource, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePersistentResourceOperationCallable()
 *           <li><p> updatePersistentResourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RebootPersistentResource</td>
 *      <td><p> Reboots a PersistentResource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> rebootPersistentResourceAsync(RebootPersistentResourceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> rebootPersistentResourceAsync(PersistentResourceName name)
 *           <li><p> rebootPersistentResourceAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> rebootPersistentResourceOperationCallable()
 *           <li><p> rebootPersistentResourceCallable()
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
 * PersistentResourceServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PersistentResourceServiceSettings persistentResourceServiceSettings =
 *     PersistentResourceServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PersistentResourceServiceClient persistentResourceServiceClient =
 *     PersistentResourceServiceClient.create(persistentResourceServiceSettings);
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
 * PersistentResourceServiceSettings persistentResourceServiceSettings =
 *     PersistentResourceServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PersistentResourceServiceClient persistentResourceServiceClient =
 *     PersistentResourceServiceClient.create(persistentResourceServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class PersistentResourceServiceClient implements BackgroundResource {
  private final PersistentResourceServiceSettings settings;
  private final PersistentResourceServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of PersistentResourceServiceClient with default settings. */
  public static final PersistentResourceServiceClient create() throws IOException {
    return create(PersistentResourceServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PersistentResourceServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final PersistentResourceServiceClient create(
      PersistentResourceServiceSettings settings) throws IOException {
    return new PersistentResourceServiceClient(settings);
  }

  /**
   * Constructs an instance of PersistentResourceServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(PersistentResourceServiceSettings).
   */
  public static final PersistentResourceServiceClient create(PersistentResourceServiceStub stub) {
    return new PersistentResourceServiceClient(stub);
  }

  /**
   * Constructs an instance of PersistentResourceServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected PersistentResourceServiceClient(PersistentResourceServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((PersistentResourceServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected PersistentResourceServiceClient(PersistentResourceServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final PersistentResourceServiceSettings getSettings() {
    return settings;
  }

  public PersistentResourceServiceStub getStub() {
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
   * Creates a PersistentResource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   PersistentResource persistentResource = PersistentResource.newBuilder().build();
   *   String persistentResourceId = "persistentResourceId-2123080768";
   *   PersistentResource response =
   *       persistentResourceServiceClient
   *           .createPersistentResourceAsync(parent, persistentResource, persistentResourceId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the PersistentResource in.
   *     Format: `projects/{project}/locations/{location}`
   * @param persistentResource Required. The PersistentResource to create.
   * @param persistentResourceId Required. The ID to use for the PersistentResource, which become
   *     the final component of the PersistentResource's resource name.
   *     <p>The maximum length is 63 characters, and valid characters are
   *     `/^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$/`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PersistentResource, CreatePersistentResourceOperationMetadata>
      createPersistentResourceAsync(
          LocationName parent, PersistentResource persistentResource, String persistentResourceId) {
    CreatePersistentResourceRequest request =
        CreatePersistentResourceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPersistentResource(persistentResource)
            .setPersistentResourceId(persistentResourceId)
            .build();
    return createPersistentResourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a PersistentResource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   PersistentResource persistentResource = PersistentResource.newBuilder().build();
   *   String persistentResourceId = "persistentResourceId-2123080768";
   *   PersistentResource response =
   *       persistentResourceServiceClient
   *           .createPersistentResourceAsync(parent, persistentResource, persistentResourceId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the PersistentResource in.
   *     Format: `projects/{project}/locations/{location}`
   * @param persistentResource Required. The PersistentResource to create.
   * @param persistentResourceId Required. The ID to use for the PersistentResource, which become
   *     the final component of the PersistentResource's resource name.
   *     <p>The maximum length is 63 characters, and valid characters are
   *     `/^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$/`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PersistentResource, CreatePersistentResourceOperationMetadata>
      createPersistentResourceAsync(
          String parent, PersistentResource persistentResource, String persistentResourceId) {
    CreatePersistentResourceRequest request =
        CreatePersistentResourceRequest.newBuilder()
            .setParent(parent)
            .setPersistentResource(persistentResource)
            .setPersistentResourceId(persistentResourceId)
            .build();
    return createPersistentResourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a PersistentResource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   CreatePersistentResourceRequest request =
   *       CreatePersistentResourceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPersistentResource(PersistentResource.newBuilder().build())
   *           .setPersistentResourceId("persistentResourceId-2123080768")
   *           .build();
   *   PersistentResource response =
   *       persistentResourceServiceClient.createPersistentResourceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PersistentResource, CreatePersistentResourceOperationMetadata>
      createPersistentResourceAsync(CreatePersistentResourceRequest request) {
    return createPersistentResourceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a PersistentResource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   CreatePersistentResourceRequest request =
   *       CreatePersistentResourceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPersistentResource(PersistentResource.newBuilder().build())
   *           .setPersistentResourceId("persistentResourceId-2123080768")
   *           .build();
   *   OperationFuture<PersistentResource, CreatePersistentResourceOperationMetadata> future =
   *       persistentResourceServiceClient
   *           .createPersistentResourceOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   PersistentResource response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreatePersistentResourceRequest,
          PersistentResource,
          CreatePersistentResourceOperationMetadata>
      createPersistentResourceOperationCallable() {
    return stub.createPersistentResourceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a PersistentResource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   CreatePersistentResourceRequest request =
   *       CreatePersistentResourceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPersistentResource(PersistentResource.newBuilder().build())
   *           .setPersistentResourceId("persistentResourceId-2123080768")
   *           .build();
   *   ApiFuture<Operation> future =
   *       persistentResourceServiceClient.createPersistentResourceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreatePersistentResourceRequest, Operation>
      createPersistentResourceCallable() {
    return stub.createPersistentResourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a PersistentResource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   PersistentResourceName name =
   *       PersistentResourceName.of("[PROJECT]", "[LOCATION]", "[PERSISTENT_RESOURCE]");
   *   PersistentResource response = persistentResourceServiceClient.getPersistentResource(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the PersistentResource resource. Format:
   *     `projects/{project_id_or_number}/locations/{location_id}/persistentResources/{persistent_resource_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PersistentResource getPersistentResource(PersistentResourceName name) {
    GetPersistentResourceRequest request =
        GetPersistentResourceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getPersistentResource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a PersistentResource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   String name =
   *       PersistentResourceName.of("[PROJECT]", "[LOCATION]", "[PERSISTENT_RESOURCE]").toString();
   *   PersistentResource response = persistentResourceServiceClient.getPersistentResource(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the PersistentResource resource. Format:
   *     `projects/{project_id_or_number}/locations/{location_id}/persistentResources/{persistent_resource_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PersistentResource getPersistentResource(String name) {
    GetPersistentResourceRequest request =
        GetPersistentResourceRequest.newBuilder().setName(name).build();
    return getPersistentResource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a PersistentResource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   GetPersistentResourceRequest request =
   *       GetPersistentResourceRequest.newBuilder()
   *           .setName(
   *               PersistentResourceName.of("[PROJECT]", "[LOCATION]", "[PERSISTENT_RESOURCE]")
   *                   .toString())
   *           .build();
   *   PersistentResource response = persistentResourceServiceClient.getPersistentResource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PersistentResource getPersistentResource(GetPersistentResourceRequest request) {
    return getPersistentResourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a PersistentResource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   GetPersistentResourceRequest request =
   *       GetPersistentResourceRequest.newBuilder()
   *           .setName(
   *               PersistentResourceName.of("[PROJECT]", "[LOCATION]", "[PERSISTENT_RESOURCE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<PersistentResource> future =
   *       persistentResourceServiceClient.getPersistentResourceCallable().futureCall(request);
   *   // Do something.
   *   PersistentResource response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPersistentResourceRequest, PersistentResource>
      getPersistentResourceCallable() {
    return stub.getPersistentResourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PersistentResources in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (PersistentResource element :
   *       persistentResourceServiceClient.listPersistentResources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the PersistentResources from.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPersistentResourcesPagedResponse listPersistentResources(LocationName parent) {
    ListPersistentResourcesRequest request =
        ListPersistentResourcesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPersistentResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PersistentResources in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (PersistentResource element :
   *       persistentResourceServiceClient.listPersistentResources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the PersistentResources from.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPersistentResourcesPagedResponse listPersistentResources(String parent) {
    ListPersistentResourcesRequest request =
        ListPersistentResourcesRequest.newBuilder().setParent(parent).build();
    return listPersistentResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PersistentResources in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   ListPersistentResourcesRequest request =
   *       ListPersistentResourcesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (PersistentResource element :
   *       persistentResourceServiceClient.listPersistentResources(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPersistentResourcesPagedResponse listPersistentResources(
      ListPersistentResourcesRequest request) {
    return listPersistentResourcesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PersistentResources in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   ListPersistentResourcesRequest request =
   *       ListPersistentResourcesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<PersistentResource> future =
   *       persistentResourceServiceClient
   *           .listPersistentResourcesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (PersistentResource element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPersistentResourcesRequest, ListPersistentResourcesPagedResponse>
      listPersistentResourcesPagedCallable() {
    return stub.listPersistentResourcesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists PersistentResources in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   ListPersistentResourcesRequest request =
   *       ListPersistentResourcesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPersistentResourcesResponse response =
   *         persistentResourceServiceClient.listPersistentResourcesCallable().call(request);
   *     for (PersistentResource element : response.getPersistentResourcesList()) {
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
  public final UnaryCallable<ListPersistentResourcesRequest, ListPersistentResourcesResponse>
      listPersistentResourcesCallable() {
    return stub.listPersistentResourcesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a PersistentResource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   PersistentResourceName name =
   *       PersistentResourceName.of("[PROJECT]", "[LOCATION]", "[PERSISTENT_RESOURCE]");
   *   persistentResourceServiceClient.deletePersistentResourceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the PersistentResource to be deleted. Format:
   *     `projects/{project}/locations/{location}/persistentResources/{persistent_resource}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deletePersistentResourceAsync(
      PersistentResourceName name) {
    DeletePersistentResourceRequest request =
        DeletePersistentResourceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deletePersistentResourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a PersistentResource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   String name =
   *       PersistentResourceName.of("[PROJECT]", "[LOCATION]", "[PERSISTENT_RESOURCE]").toString();
   *   persistentResourceServiceClient.deletePersistentResourceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the PersistentResource to be deleted. Format:
   *     `projects/{project}/locations/{location}/persistentResources/{persistent_resource}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deletePersistentResourceAsync(
      String name) {
    DeletePersistentResourceRequest request =
        DeletePersistentResourceRequest.newBuilder().setName(name).build();
    return deletePersistentResourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a PersistentResource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   DeletePersistentResourceRequest request =
   *       DeletePersistentResourceRequest.newBuilder()
   *           .setName(
   *               PersistentResourceName.of("[PROJECT]", "[LOCATION]", "[PERSISTENT_RESOURCE]")
   *                   .toString())
   *           .build();
   *   persistentResourceServiceClient.deletePersistentResourceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deletePersistentResourceAsync(
      DeletePersistentResourceRequest request) {
    return deletePersistentResourceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a PersistentResource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   DeletePersistentResourceRequest request =
   *       DeletePersistentResourceRequest.newBuilder()
   *           .setName(
   *               PersistentResourceName.of("[PROJECT]", "[LOCATION]", "[PERSISTENT_RESOURCE]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       persistentResourceServiceClient
   *           .deletePersistentResourceOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeletePersistentResourceRequest, Empty, DeleteOperationMetadata>
      deletePersistentResourceOperationCallable() {
    return stub.deletePersistentResourceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a PersistentResource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   DeletePersistentResourceRequest request =
   *       DeletePersistentResourceRequest.newBuilder()
   *           .setName(
   *               PersistentResourceName.of("[PROJECT]", "[LOCATION]", "[PERSISTENT_RESOURCE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       persistentResourceServiceClient.deletePersistentResourceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePersistentResourceRequest, Operation>
      deletePersistentResourceCallable() {
    return stub.deletePersistentResourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a PersistentResource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   PersistentResource persistentResource = PersistentResource.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   PersistentResource response =
   *       persistentResourceServiceClient
   *           .updatePersistentResourceAsync(persistentResource, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param persistentResource Required. The PersistentResource to update.
   *     <p>The PersistentResource's `name` field is used to identify the PersistentResource to
   *     update. Format:
   *     `projects/{project}/locations/{location}/persistentResources/{persistent_resource}`
   * @param updateMask Required. Specify the fields to be overwritten in the PersistentResource by
   *     the update method.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PersistentResource, UpdatePersistentResourceOperationMetadata>
      updatePersistentResourceAsync(PersistentResource persistentResource, FieldMask updateMask) {
    UpdatePersistentResourceRequest request =
        UpdatePersistentResourceRequest.newBuilder()
            .setPersistentResource(persistentResource)
            .setUpdateMask(updateMask)
            .build();
    return updatePersistentResourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a PersistentResource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   UpdatePersistentResourceRequest request =
   *       UpdatePersistentResourceRequest.newBuilder()
   *           .setPersistentResource(PersistentResource.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   PersistentResource response =
   *       persistentResourceServiceClient.updatePersistentResourceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PersistentResource, UpdatePersistentResourceOperationMetadata>
      updatePersistentResourceAsync(UpdatePersistentResourceRequest request) {
    return updatePersistentResourceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a PersistentResource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   UpdatePersistentResourceRequest request =
   *       UpdatePersistentResourceRequest.newBuilder()
   *           .setPersistentResource(PersistentResource.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<PersistentResource, UpdatePersistentResourceOperationMetadata> future =
   *       persistentResourceServiceClient
   *           .updatePersistentResourceOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   PersistentResource response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdatePersistentResourceRequest,
          PersistentResource,
          UpdatePersistentResourceOperationMetadata>
      updatePersistentResourceOperationCallable() {
    return stub.updatePersistentResourceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a PersistentResource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   UpdatePersistentResourceRequest request =
   *       UpdatePersistentResourceRequest.newBuilder()
   *           .setPersistentResource(PersistentResource.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       persistentResourceServiceClient.updatePersistentResourceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePersistentResourceRequest, Operation>
      updatePersistentResourceCallable() {
    return stub.updatePersistentResourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reboots a PersistentResource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   PersistentResourceName name =
   *       PersistentResourceName.of("[PROJECT]", "[LOCATION]", "[PERSISTENT_RESOURCE]");
   *   PersistentResource response =
   *       persistentResourceServiceClient.rebootPersistentResourceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the PersistentResource resource. Format:
   *     `projects/{project_id_or_number}/locations/{location_id}/persistentResources/{persistent_resource_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PersistentResource, RebootPersistentResourceOperationMetadata>
      rebootPersistentResourceAsync(PersistentResourceName name) {
    RebootPersistentResourceRequest request =
        RebootPersistentResourceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return rebootPersistentResourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reboots a PersistentResource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   String name =
   *       PersistentResourceName.of("[PROJECT]", "[LOCATION]", "[PERSISTENT_RESOURCE]").toString();
   *   PersistentResource response =
   *       persistentResourceServiceClient.rebootPersistentResourceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the PersistentResource resource. Format:
   *     `projects/{project_id_or_number}/locations/{location_id}/persistentResources/{persistent_resource_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PersistentResource, RebootPersistentResourceOperationMetadata>
      rebootPersistentResourceAsync(String name) {
    RebootPersistentResourceRequest request =
        RebootPersistentResourceRequest.newBuilder().setName(name).build();
    return rebootPersistentResourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reboots a PersistentResource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   RebootPersistentResourceRequest request =
   *       RebootPersistentResourceRequest.newBuilder()
   *           .setName(
   *               PersistentResourceName.of("[PROJECT]", "[LOCATION]", "[PERSISTENT_RESOURCE]")
   *                   .toString())
   *           .build();
   *   PersistentResource response =
   *       persistentResourceServiceClient.rebootPersistentResourceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PersistentResource, RebootPersistentResourceOperationMetadata>
      rebootPersistentResourceAsync(RebootPersistentResourceRequest request) {
    return rebootPersistentResourceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reboots a PersistentResource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   RebootPersistentResourceRequest request =
   *       RebootPersistentResourceRequest.newBuilder()
   *           .setName(
   *               PersistentResourceName.of("[PROJECT]", "[LOCATION]", "[PERSISTENT_RESOURCE]")
   *                   .toString())
   *           .build();
   *   OperationFuture<PersistentResource, RebootPersistentResourceOperationMetadata> future =
   *       persistentResourceServiceClient
   *           .rebootPersistentResourceOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   PersistentResource response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RebootPersistentResourceRequest,
          PersistentResource,
          RebootPersistentResourceOperationMetadata>
      rebootPersistentResourceOperationCallable() {
    return stub.rebootPersistentResourceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reboots a PersistentResource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   RebootPersistentResourceRequest request =
   *       RebootPersistentResourceRequest.newBuilder()
   *           .setName(
   *               PersistentResourceName.of("[PROJECT]", "[LOCATION]", "[PERSISTENT_RESOURCE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       persistentResourceServiceClient.rebootPersistentResourceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RebootPersistentResourceRequest, Operation>
      rebootPersistentResourceCallable() {
    return stub.rebootPersistentResourceCallable();
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
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : persistentResourceServiceClient.listLocations(request).iterateAll()) {
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
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       persistentResourceServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         persistentResourceServiceClient.listLocationsCallable().call(request);
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
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = persistentResourceServiceClient.getLocation(request);
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
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       persistentResourceServiceClient.getLocationCallable().futureCall(request);
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
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = persistentResourceServiceClient.setIamPolicy(request);
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
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       persistentResourceServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = persistentResourceServiceClient.getIamPolicy(request);
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
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       persistentResourceServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response =
   *       persistentResourceServiceClient.testIamPermissions(request);
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
   * try (PersistentResourceServiceClient persistentResourceServiceClient =
   *     PersistentResourceServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       persistentResourceServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListPersistentResourcesPagedResponse
      extends AbstractPagedListResponse<
          ListPersistentResourcesRequest,
          ListPersistentResourcesResponse,
          PersistentResource,
          ListPersistentResourcesPage,
          ListPersistentResourcesFixedSizeCollection> {

    public static ApiFuture<ListPersistentResourcesPagedResponse> createAsync(
        PageContext<
                ListPersistentResourcesRequest, ListPersistentResourcesResponse, PersistentResource>
            context,
        ApiFuture<ListPersistentResourcesResponse> futureResponse) {
      ApiFuture<ListPersistentResourcesPage> futurePage =
          ListPersistentResourcesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPersistentResourcesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPersistentResourcesPagedResponse(ListPersistentResourcesPage page) {
      super(page, ListPersistentResourcesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPersistentResourcesPage
      extends AbstractPage<
          ListPersistentResourcesRequest,
          ListPersistentResourcesResponse,
          PersistentResource,
          ListPersistentResourcesPage> {

    private ListPersistentResourcesPage(
        PageContext<
                ListPersistentResourcesRequest, ListPersistentResourcesResponse, PersistentResource>
            context,
        ListPersistentResourcesResponse response) {
      super(context, response);
    }

    private static ListPersistentResourcesPage createEmptyPage() {
      return new ListPersistentResourcesPage(null, null);
    }

    @Override
    protected ListPersistentResourcesPage createPage(
        PageContext<
                ListPersistentResourcesRequest, ListPersistentResourcesResponse, PersistentResource>
            context,
        ListPersistentResourcesResponse response) {
      return new ListPersistentResourcesPage(context, response);
    }

    @Override
    public ApiFuture<ListPersistentResourcesPage> createPageAsync(
        PageContext<
                ListPersistentResourcesRequest, ListPersistentResourcesResponse, PersistentResource>
            context,
        ApiFuture<ListPersistentResourcesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPersistentResourcesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPersistentResourcesRequest,
          ListPersistentResourcesResponse,
          PersistentResource,
          ListPersistentResourcesPage,
          ListPersistentResourcesFixedSizeCollection> {

    private ListPersistentResourcesFixedSizeCollection(
        List<ListPersistentResourcesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPersistentResourcesFixedSizeCollection createEmptyCollection() {
      return new ListPersistentResourcesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPersistentResourcesFixedSizeCollection createCollection(
        List<ListPersistentResourcesPage> pages, int collectionSize) {
      return new ListPersistentResourcesFixedSizeCollection(pages, collectionSize);
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
