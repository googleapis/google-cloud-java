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

package com.google.cloud.commerce.consumer.procurement.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.commerce.consumer.procurement.v1.stub.LicenseManagementServiceStub;
import com.google.cloud.commerce.consumer.procurement.v1.stub.LicenseManagementServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing licenses.
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
 * try (LicenseManagementServiceClient licenseManagementServiceClient =
 *     LicenseManagementServiceClient.create()) {
 *   String name = "name3373707";
 *   LicensePool response = licenseManagementServiceClient.getLicensePool(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LicenseManagementServiceClient object to clean up
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
 *      <td><p> GetLicensePool</td>
 *      <td><p> Gets the license pool.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLicensePool(GetLicensePoolRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getLicensePool(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLicensePoolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateLicensePool</td>
 *      <td><p> Updates the license pool if one exists for this Order.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateLicensePool(UpdateLicensePoolRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateLicensePool(LicensePool licensePool, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateLicensePoolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Assign</td>
 *      <td><p> Assigns a license to a user.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> assign(AssignRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> assign(String parent, List&lt;String&gt; usernames)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> assignCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Unassign</td>
 *      <td><p> Unassigns a license from a user.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> unassign(UnassignRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> unassign(String parent, List&lt;String&gt; usernames)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> unassignCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> EnumerateLicensedUsers</td>
 *      <td><p> Enumerates all users assigned a license.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> enumerateLicensedUsers(EnumerateLicensedUsersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> enumerateLicensedUsers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> enumerateLicensedUsersPagedCallable()
 *           <li><p> enumerateLicensedUsersCallable()
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
 * LicenseManagementServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LicenseManagementServiceSettings licenseManagementServiceSettings =
 *     LicenseManagementServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LicenseManagementServiceClient licenseManagementServiceClient =
 *     LicenseManagementServiceClient.create(licenseManagementServiceSettings);
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
 * LicenseManagementServiceSettings licenseManagementServiceSettings =
 *     LicenseManagementServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LicenseManagementServiceClient licenseManagementServiceClient =
 *     LicenseManagementServiceClient.create(licenseManagementServiceSettings);
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
 * LicenseManagementServiceSettings licenseManagementServiceSettings =
 *     LicenseManagementServiceSettings.newHttpJsonBuilder().build();
 * LicenseManagementServiceClient licenseManagementServiceClient =
 *     LicenseManagementServiceClient.create(licenseManagementServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class LicenseManagementServiceClient implements BackgroundResource {
  private final LicenseManagementServiceSettings settings;
  private final LicenseManagementServiceStub stub;

  /** Constructs an instance of LicenseManagementServiceClient with default settings. */
  public static final LicenseManagementServiceClient create() throws IOException {
    return create(LicenseManagementServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LicenseManagementServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final LicenseManagementServiceClient create(
      LicenseManagementServiceSettings settings) throws IOException {
    return new LicenseManagementServiceClient(settings);
  }

  /**
   * Constructs an instance of LicenseManagementServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(LicenseManagementServiceSettings).
   */
  public static final LicenseManagementServiceClient create(LicenseManagementServiceStub stub) {
    return new LicenseManagementServiceClient(stub);
  }

  /**
   * Constructs an instance of LicenseManagementServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected LicenseManagementServiceClient(LicenseManagementServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((LicenseManagementServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected LicenseManagementServiceClient(LicenseManagementServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final LicenseManagementServiceSettings getSettings() {
    return settings;
  }

  public LicenseManagementServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the license pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagementServiceClient licenseManagementServiceClient =
   *     LicenseManagementServiceClient.create()) {
   *   String name = "name3373707";
   *   LicensePool response = licenseManagementServiceClient.getLicensePool(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the license pool to get. Format:
   *     `billingAccounts/{billing_account}/orders/{order}/licensePool`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LicensePool getLicensePool(String name) {
    GetLicensePoolRequest request = GetLicensePoolRequest.newBuilder().setName(name).build();
    return getLicensePool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the license pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagementServiceClient licenseManagementServiceClient =
   *     LicenseManagementServiceClient.create()) {
   *   GetLicensePoolRequest request =
   *       GetLicensePoolRequest.newBuilder().setName("name3373707").build();
   *   LicensePool response = licenseManagementServiceClient.getLicensePool(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LicensePool getLicensePool(GetLicensePoolRequest request) {
    return getLicensePoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the license pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagementServiceClient licenseManagementServiceClient =
   *     LicenseManagementServiceClient.create()) {
   *   GetLicensePoolRequest request =
   *       GetLicensePoolRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<LicensePool> future =
   *       licenseManagementServiceClient.getLicensePoolCallable().futureCall(request);
   *   // Do something.
   *   LicensePool response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLicensePoolRequest, LicensePool> getLicensePoolCallable() {
    return stub.getLicensePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the license pool if one exists for this Order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagementServiceClient licenseManagementServiceClient =
   *     LicenseManagementServiceClient.create()) {
   *   LicensePool licensePool = LicensePool.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   LicensePool response =
   *       licenseManagementServiceClient.updateLicensePool(licensePool, updateMask);
   * }
   * }</pre>
   *
   * @param licensePool Required. The license pool to update.
   *     <p>The license pool's name field is used to identify the license pool to update. Format:
   *     `billingAccounts/{billing_account}/orders/{order}/licensePool`.
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LicensePool updateLicensePool(LicensePool licensePool, FieldMask updateMask) {
    UpdateLicensePoolRequest request =
        UpdateLicensePoolRequest.newBuilder()
            .setLicensePool(licensePool)
            .setUpdateMask(updateMask)
            .build();
    return updateLicensePool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the license pool if one exists for this Order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagementServiceClient licenseManagementServiceClient =
   *     LicenseManagementServiceClient.create()) {
   *   UpdateLicensePoolRequest request =
   *       UpdateLicensePoolRequest.newBuilder()
   *           .setLicensePool(LicensePool.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   LicensePool response = licenseManagementServiceClient.updateLicensePool(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LicensePool updateLicensePool(UpdateLicensePoolRequest request) {
    return updateLicensePoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the license pool if one exists for this Order.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagementServiceClient licenseManagementServiceClient =
   *     LicenseManagementServiceClient.create()) {
   *   UpdateLicensePoolRequest request =
   *       UpdateLicensePoolRequest.newBuilder()
   *           .setLicensePool(LicensePool.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<LicensePool> future =
   *       licenseManagementServiceClient.updateLicensePoolCallable().futureCall(request);
   *   // Do something.
   *   LicensePool response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateLicensePoolRequest, LicensePool> updateLicensePoolCallable() {
    return stub.updateLicensePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Assigns a license to a user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagementServiceClient licenseManagementServiceClient =
   *     LicenseManagementServiceClient.create()) {
   *   String parent = "parent-995424086";
   *   List<String> usernames = new ArrayList<>();
   *   AssignResponse response = licenseManagementServiceClient.assign(parent, usernames);
   * }
   * }</pre>
   *
   * @param parent Required. License pool name.
   * @param usernames Required. Username. Format: `name{@literal @}domain.com`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AssignResponse assign(String parent, List<String> usernames) {
    AssignRequest request =
        AssignRequest.newBuilder().setParent(parent).addAllUsernames(usernames).build();
    return assign(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Assigns a license to a user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagementServiceClient licenseManagementServiceClient =
   *     LicenseManagementServiceClient.create()) {
   *   AssignRequest request =
   *       AssignRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllUsernames(new ArrayList<String>())
   *           .build();
   *   AssignResponse response = licenseManagementServiceClient.assign(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AssignResponse assign(AssignRequest request) {
    return assignCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Assigns a license to a user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagementServiceClient licenseManagementServiceClient =
   *     LicenseManagementServiceClient.create()) {
   *   AssignRequest request =
   *       AssignRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllUsernames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<AssignResponse> future =
   *       licenseManagementServiceClient.assignCallable().futureCall(request);
   *   // Do something.
   *   AssignResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AssignRequest, AssignResponse> assignCallable() {
    return stub.assignCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unassigns a license from a user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagementServiceClient licenseManagementServiceClient =
   *     LicenseManagementServiceClient.create()) {
   *   String parent = "parent-995424086";
   *   List<String> usernames = new ArrayList<>();
   *   UnassignResponse response = licenseManagementServiceClient.unassign(parent, usernames);
   * }
   * }</pre>
   *
   * @param parent Required. License pool name.
   * @param usernames Required. Username. Format: `name{@literal @}domain.com`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnassignResponse unassign(String parent, List<String> usernames) {
    UnassignRequest request =
        UnassignRequest.newBuilder().setParent(parent).addAllUsernames(usernames).build();
    return unassign(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unassigns a license from a user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagementServiceClient licenseManagementServiceClient =
   *     LicenseManagementServiceClient.create()) {
   *   UnassignRequest request =
   *       UnassignRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllUsernames(new ArrayList<String>())
   *           .build();
   *   UnassignResponse response = licenseManagementServiceClient.unassign(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnassignResponse unassign(UnassignRequest request) {
    return unassignCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unassigns a license from a user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagementServiceClient licenseManagementServiceClient =
   *     LicenseManagementServiceClient.create()) {
   *   UnassignRequest request =
   *       UnassignRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllUsernames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<UnassignResponse> future =
   *       licenseManagementServiceClient.unassignCallable().futureCall(request);
   *   // Do something.
   *   UnassignResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UnassignRequest, UnassignResponse> unassignCallable() {
    return stub.unassignCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enumerates all users assigned a license.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagementServiceClient licenseManagementServiceClient =
   *     LicenseManagementServiceClient.create()) {
   *   String parent = "parent-995424086";
   *   for (LicensedUser element :
   *       licenseManagementServiceClient.enumerateLicensedUsers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. License pool name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EnumerateLicensedUsersPagedResponse enumerateLicensedUsers(String parent) {
    EnumerateLicensedUsersRequest request =
        EnumerateLicensedUsersRequest.newBuilder().setParent(parent).build();
    return enumerateLicensedUsers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enumerates all users assigned a license.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagementServiceClient licenseManagementServiceClient =
   *     LicenseManagementServiceClient.create()) {
   *   EnumerateLicensedUsersRequest request =
   *       EnumerateLicensedUsersRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (LicensedUser element :
   *       licenseManagementServiceClient.enumerateLicensedUsers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EnumerateLicensedUsersPagedResponse enumerateLicensedUsers(
      EnumerateLicensedUsersRequest request) {
    return enumerateLicensedUsersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enumerates all users assigned a license.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagementServiceClient licenseManagementServiceClient =
   *     LicenseManagementServiceClient.create()) {
   *   EnumerateLicensedUsersRequest request =
   *       EnumerateLicensedUsersRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<LicensedUser> future =
   *       licenseManagementServiceClient.enumerateLicensedUsersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LicensedUser element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<EnumerateLicensedUsersRequest, EnumerateLicensedUsersPagedResponse>
      enumerateLicensedUsersPagedCallable() {
    return stub.enumerateLicensedUsersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enumerates all users assigned a license.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LicenseManagementServiceClient licenseManagementServiceClient =
   *     LicenseManagementServiceClient.create()) {
   *   EnumerateLicensedUsersRequest request =
   *       EnumerateLicensedUsersRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     EnumerateLicensedUsersResponse response =
   *         licenseManagementServiceClient.enumerateLicensedUsersCallable().call(request);
   *     for (LicensedUser element : response.getLicensedUsersList()) {
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
  public final UnaryCallable<EnumerateLicensedUsersRequest, EnumerateLicensedUsersResponse>
      enumerateLicensedUsersCallable() {
    return stub.enumerateLicensedUsersCallable();
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

  public static class EnumerateLicensedUsersPagedResponse
      extends AbstractPagedListResponse<
          EnumerateLicensedUsersRequest,
          EnumerateLicensedUsersResponse,
          LicensedUser,
          EnumerateLicensedUsersPage,
          EnumerateLicensedUsersFixedSizeCollection> {

    public static ApiFuture<EnumerateLicensedUsersPagedResponse> createAsync(
        PageContext<EnumerateLicensedUsersRequest, EnumerateLicensedUsersResponse, LicensedUser>
            context,
        ApiFuture<EnumerateLicensedUsersResponse> futureResponse) {
      ApiFuture<EnumerateLicensedUsersPage> futurePage =
          EnumerateLicensedUsersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new EnumerateLicensedUsersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private EnumerateLicensedUsersPagedResponse(EnumerateLicensedUsersPage page) {
      super(page, EnumerateLicensedUsersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class EnumerateLicensedUsersPage
      extends AbstractPage<
          EnumerateLicensedUsersRequest,
          EnumerateLicensedUsersResponse,
          LicensedUser,
          EnumerateLicensedUsersPage> {

    private EnumerateLicensedUsersPage(
        PageContext<EnumerateLicensedUsersRequest, EnumerateLicensedUsersResponse, LicensedUser>
            context,
        EnumerateLicensedUsersResponse response) {
      super(context, response);
    }

    private static EnumerateLicensedUsersPage createEmptyPage() {
      return new EnumerateLicensedUsersPage(null, null);
    }

    @Override
    protected EnumerateLicensedUsersPage createPage(
        PageContext<EnumerateLicensedUsersRequest, EnumerateLicensedUsersResponse, LicensedUser>
            context,
        EnumerateLicensedUsersResponse response) {
      return new EnumerateLicensedUsersPage(context, response);
    }

    @Override
    public ApiFuture<EnumerateLicensedUsersPage> createPageAsync(
        PageContext<EnumerateLicensedUsersRequest, EnumerateLicensedUsersResponse, LicensedUser>
            context,
        ApiFuture<EnumerateLicensedUsersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class EnumerateLicensedUsersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          EnumerateLicensedUsersRequest,
          EnumerateLicensedUsersResponse,
          LicensedUser,
          EnumerateLicensedUsersPage,
          EnumerateLicensedUsersFixedSizeCollection> {

    private EnumerateLicensedUsersFixedSizeCollection(
        List<EnumerateLicensedUsersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static EnumerateLicensedUsersFixedSizeCollection createEmptyCollection() {
      return new EnumerateLicensedUsersFixedSizeCollection(null, 0);
    }

    @Override
    protected EnumerateLicensedUsersFixedSizeCollection createCollection(
        List<EnumerateLicensedUsersPage> pages, int collectionSize) {
      return new EnumerateLicensedUsersFixedSizeCollection(pages, collectionSize);
    }
  }
}
