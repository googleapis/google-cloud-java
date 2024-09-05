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

package com.google.cloud.apihub.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apihub.v1.stub.HostProjectRegistrationServiceStub;
import com.google.cloud.apihub.v1.stub.HostProjectRegistrationServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: This service is used for managing the host project registrations.
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
 * try (HostProjectRegistrationServiceClient hostProjectRegistrationServiceClient =
 *     HostProjectRegistrationServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   HostProjectRegistration hostProjectRegistration =
 *       HostProjectRegistration.newBuilder().build();
 *   String hostProjectRegistrationId = "hostProjectRegistrationId1352651365";
 *   HostProjectRegistration response =
 *       hostProjectRegistrationServiceClient.createHostProjectRegistration(
 *           parent, hostProjectRegistration, hostProjectRegistrationId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the HostProjectRegistrationServiceClient object to clean
 * up resources such as threads. In the example above, try-with-resources is used, which
 * automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateHostProjectRegistration</td>
 *      <td><p> Create a host project registration. A Google cloud project can be registered as a host project if it is not attached as a runtime project to another host project. A project can be registered as a host project only once. Subsequent register calls for the same project will fail.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createHostProjectRegistration(CreateHostProjectRegistrationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createHostProjectRegistration(LocationName parent, HostProjectRegistration hostProjectRegistration, String hostProjectRegistrationId)
 *           <li><p> createHostProjectRegistration(String parent, HostProjectRegistration hostProjectRegistration, String hostProjectRegistrationId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createHostProjectRegistrationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetHostProjectRegistration</td>
 *      <td><p> Get a host project registration.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getHostProjectRegistration(GetHostProjectRegistrationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getHostProjectRegistration(HostProjectRegistrationName name)
 *           <li><p> getHostProjectRegistration(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getHostProjectRegistrationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListHostProjectRegistrations</td>
 *      <td><p> Lists host project registrations.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listHostProjectRegistrations(ListHostProjectRegistrationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listHostProjectRegistrations(LocationName parent)
 *           <li><p> listHostProjectRegistrations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listHostProjectRegistrationsPagedCallable()
 *           <li><p> listHostProjectRegistrationsCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * HostProjectRegistrationServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * HostProjectRegistrationServiceSettings hostProjectRegistrationServiceSettings =
 *     HostProjectRegistrationServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * HostProjectRegistrationServiceClient hostProjectRegistrationServiceClient =
 *     HostProjectRegistrationServiceClient.create(hostProjectRegistrationServiceSettings);
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
 * HostProjectRegistrationServiceSettings hostProjectRegistrationServiceSettings =
 *     HostProjectRegistrationServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * HostProjectRegistrationServiceClient hostProjectRegistrationServiceClient =
 *     HostProjectRegistrationServiceClient.create(hostProjectRegistrationServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class HostProjectRegistrationServiceClient implements BackgroundResource {
  private final HostProjectRegistrationServiceSettings settings;
  private final HostProjectRegistrationServiceStub stub;

  /** Constructs an instance of HostProjectRegistrationServiceClient with default settings. */
  public static final HostProjectRegistrationServiceClient create() throws IOException {
    return create(HostProjectRegistrationServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of HostProjectRegistrationServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final HostProjectRegistrationServiceClient create(
      HostProjectRegistrationServiceSettings settings) throws IOException {
    return new HostProjectRegistrationServiceClient(settings);
  }

  /**
   * Constructs an instance of HostProjectRegistrationServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using
   * create(HostProjectRegistrationServiceSettings).
   */
  public static final HostProjectRegistrationServiceClient create(
      HostProjectRegistrationServiceStub stub) {
    return new HostProjectRegistrationServiceClient(stub);
  }

  /**
   * Constructs an instance of HostProjectRegistrationServiceClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HostProjectRegistrationServiceClient(HostProjectRegistrationServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((HostProjectRegistrationServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected HostProjectRegistrationServiceClient(HostProjectRegistrationServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final HostProjectRegistrationServiceSettings getSettings() {
    return settings;
  }

  public HostProjectRegistrationServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a host project registration. A Google cloud project can be registered as a host project
   * if it is not attached as a runtime project to another host project. A project can be registered
   * as a host project only once. Subsequent register calls for the same project will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HostProjectRegistrationServiceClient hostProjectRegistrationServiceClient =
   *     HostProjectRegistrationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   HostProjectRegistration hostProjectRegistration =
   *       HostProjectRegistration.newBuilder().build();
   *   String hostProjectRegistrationId = "hostProjectRegistrationId1352651365";
   *   HostProjectRegistration response =
   *       hostProjectRegistrationServiceClient.createHostProjectRegistration(
   *           parent, hostProjectRegistration, hostProjectRegistrationId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for the host project. Format:
   *     `projects/{project}/locations/{location}`
   * @param hostProjectRegistration Required. The host project registration to register.
   * @param hostProjectRegistrationId Required. The ID to use for the Host Project Registration,
   *     which will become the final component of the host project registration's resource name. The
   *     ID must be the same as the Google cloud project specified in the
   *     host_project_registration.gcp_project field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HostProjectRegistration createHostProjectRegistration(
      LocationName parent,
      HostProjectRegistration hostProjectRegistration,
      String hostProjectRegistrationId) {
    CreateHostProjectRegistrationRequest request =
        CreateHostProjectRegistrationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setHostProjectRegistration(hostProjectRegistration)
            .setHostProjectRegistrationId(hostProjectRegistrationId)
            .build();
    return createHostProjectRegistration(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a host project registration. A Google cloud project can be registered as a host project
   * if it is not attached as a runtime project to another host project. A project can be registered
   * as a host project only once. Subsequent register calls for the same project will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HostProjectRegistrationServiceClient hostProjectRegistrationServiceClient =
   *     HostProjectRegistrationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   HostProjectRegistration hostProjectRegistration =
   *       HostProjectRegistration.newBuilder().build();
   *   String hostProjectRegistrationId = "hostProjectRegistrationId1352651365";
   *   HostProjectRegistration response =
   *       hostProjectRegistrationServiceClient.createHostProjectRegistration(
   *           parent, hostProjectRegistration, hostProjectRegistrationId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for the host project. Format:
   *     `projects/{project}/locations/{location}`
   * @param hostProjectRegistration Required. The host project registration to register.
   * @param hostProjectRegistrationId Required. The ID to use for the Host Project Registration,
   *     which will become the final component of the host project registration's resource name. The
   *     ID must be the same as the Google cloud project specified in the
   *     host_project_registration.gcp_project field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HostProjectRegistration createHostProjectRegistration(
      String parent,
      HostProjectRegistration hostProjectRegistration,
      String hostProjectRegistrationId) {
    CreateHostProjectRegistrationRequest request =
        CreateHostProjectRegistrationRequest.newBuilder()
            .setParent(parent)
            .setHostProjectRegistration(hostProjectRegistration)
            .setHostProjectRegistrationId(hostProjectRegistrationId)
            .build();
    return createHostProjectRegistration(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a host project registration. A Google cloud project can be registered as a host project
   * if it is not attached as a runtime project to another host project. A project can be registered
   * as a host project only once. Subsequent register calls for the same project will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HostProjectRegistrationServiceClient hostProjectRegistrationServiceClient =
   *     HostProjectRegistrationServiceClient.create()) {
   *   CreateHostProjectRegistrationRequest request =
   *       CreateHostProjectRegistrationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setHostProjectRegistrationId("hostProjectRegistrationId1352651365")
   *           .setHostProjectRegistration(HostProjectRegistration.newBuilder().build())
   *           .build();
   *   HostProjectRegistration response =
   *       hostProjectRegistrationServiceClient.createHostProjectRegistration(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HostProjectRegistration createHostProjectRegistration(
      CreateHostProjectRegistrationRequest request) {
    return createHostProjectRegistrationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a host project registration. A Google cloud project can be registered as a host project
   * if it is not attached as a runtime project to another host project. A project can be registered
   * as a host project only once. Subsequent register calls for the same project will fail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HostProjectRegistrationServiceClient hostProjectRegistrationServiceClient =
   *     HostProjectRegistrationServiceClient.create()) {
   *   CreateHostProjectRegistrationRequest request =
   *       CreateHostProjectRegistrationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setHostProjectRegistrationId("hostProjectRegistrationId1352651365")
   *           .setHostProjectRegistration(HostProjectRegistration.newBuilder().build())
   *           .build();
   *   ApiFuture<HostProjectRegistration> future =
   *       hostProjectRegistrationServiceClient
   *           .createHostProjectRegistrationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   HostProjectRegistration response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateHostProjectRegistrationRequest, HostProjectRegistration>
      createHostProjectRegistrationCallable() {
    return stub.createHostProjectRegistrationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a host project registration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HostProjectRegistrationServiceClient hostProjectRegistrationServiceClient =
   *     HostProjectRegistrationServiceClient.create()) {
   *   HostProjectRegistrationName name =
   *       HostProjectRegistrationName.of("[PROJECT]", "[LOCATION]", "[HOST_PROJECT_REGISTRATION]");
   *   HostProjectRegistration response =
   *       hostProjectRegistrationServiceClient.getHostProjectRegistration(name);
   * }
   * }</pre>
   *
   * @param name Required. Host project registration resource name.
   *     projects/{project}/locations/{location}/hostProjectRegistrations/{host_project_registration_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HostProjectRegistration getHostProjectRegistration(
      HostProjectRegistrationName name) {
    GetHostProjectRegistrationRequest request =
        GetHostProjectRegistrationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getHostProjectRegistration(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a host project registration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HostProjectRegistrationServiceClient hostProjectRegistrationServiceClient =
   *     HostProjectRegistrationServiceClient.create()) {
   *   String name =
   *       HostProjectRegistrationName.of("[PROJECT]", "[LOCATION]", "[HOST_PROJECT_REGISTRATION]")
   *           .toString();
   *   HostProjectRegistration response =
   *       hostProjectRegistrationServiceClient.getHostProjectRegistration(name);
   * }
   * }</pre>
   *
   * @param name Required. Host project registration resource name.
   *     projects/{project}/locations/{location}/hostProjectRegistrations/{host_project_registration_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HostProjectRegistration getHostProjectRegistration(String name) {
    GetHostProjectRegistrationRequest request =
        GetHostProjectRegistrationRequest.newBuilder().setName(name).build();
    return getHostProjectRegistration(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a host project registration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HostProjectRegistrationServiceClient hostProjectRegistrationServiceClient =
   *     HostProjectRegistrationServiceClient.create()) {
   *   GetHostProjectRegistrationRequest request =
   *       GetHostProjectRegistrationRequest.newBuilder()
   *           .setName(
   *               HostProjectRegistrationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[HOST_PROJECT_REGISTRATION]")
   *                   .toString())
   *           .build();
   *   HostProjectRegistration response =
   *       hostProjectRegistrationServiceClient.getHostProjectRegistration(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HostProjectRegistration getHostProjectRegistration(
      GetHostProjectRegistrationRequest request) {
    return getHostProjectRegistrationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a host project registration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HostProjectRegistrationServiceClient hostProjectRegistrationServiceClient =
   *     HostProjectRegistrationServiceClient.create()) {
   *   GetHostProjectRegistrationRequest request =
   *       GetHostProjectRegistrationRequest.newBuilder()
   *           .setName(
   *               HostProjectRegistrationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[HOST_PROJECT_REGISTRATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<HostProjectRegistration> future =
   *       hostProjectRegistrationServiceClient
   *           .getHostProjectRegistrationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   HostProjectRegistration response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetHostProjectRegistrationRequest, HostProjectRegistration>
      getHostProjectRegistrationCallable() {
    return stub.getHostProjectRegistrationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists host project registrations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HostProjectRegistrationServiceClient hostProjectRegistrationServiceClient =
   *     HostProjectRegistrationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (HostProjectRegistration element :
   *       hostProjectRegistrationServiceClient.listHostProjectRegistrations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of host projects. Format:
   *     `projects/&#42;/locations/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHostProjectRegistrationsPagedResponse listHostProjectRegistrations(
      LocationName parent) {
    ListHostProjectRegistrationsRequest request =
        ListHostProjectRegistrationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listHostProjectRegistrations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists host project registrations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HostProjectRegistrationServiceClient hostProjectRegistrationServiceClient =
   *     HostProjectRegistrationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (HostProjectRegistration element :
   *       hostProjectRegistrationServiceClient.listHostProjectRegistrations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of host projects. Format:
   *     `projects/&#42;/locations/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHostProjectRegistrationsPagedResponse listHostProjectRegistrations(
      String parent) {
    ListHostProjectRegistrationsRequest request =
        ListHostProjectRegistrationsRequest.newBuilder().setParent(parent).build();
    return listHostProjectRegistrations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists host project registrations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HostProjectRegistrationServiceClient hostProjectRegistrationServiceClient =
   *     HostProjectRegistrationServiceClient.create()) {
   *   ListHostProjectRegistrationsRequest request =
   *       ListHostProjectRegistrationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (HostProjectRegistration element :
   *       hostProjectRegistrationServiceClient.listHostProjectRegistrations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHostProjectRegistrationsPagedResponse listHostProjectRegistrations(
      ListHostProjectRegistrationsRequest request) {
    return listHostProjectRegistrationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists host project registrations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HostProjectRegistrationServiceClient hostProjectRegistrationServiceClient =
   *     HostProjectRegistrationServiceClient.create()) {
   *   ListHostProjectRegistrationsRequest request =
   *       ListHostProjectRegistrationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<HostProjectRegistration> future =
   *       hostProjectRegistrationServiceClient
   *           .listHostProjectRegistrationsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (HostProjectRegistration element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListHostProjectRegistrationsRequest, ListHostProjectRegistrationsPagedResponse>
      listHostProjectRegistrationsPagedCallable() {
    return stub.listHostProjectRegistrationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists host project registrations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HostProjectRegistrationServiceClient hostProjectRegistrationServiceClient =
   *     HostProjectRegistrationServiceClient.create()) {
   *   ListHostProjectRegistrationsRequest request =
   *       ListHostProjectRegistrationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListHostProjectRegistrationsResponse response =
   *         hostProjectRegistrationServiceClient
   *             .listHostProjectRegistrationsCallable()
   *             .call(request);
   *     for (HostProjectRegistration element : response.getHostProjectRegistrationsList()) {
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
          ListHostProjectRegistrationsRequest, ListHostProjectRegistrationsResponse>
      listHostProjectRegistrationsCallable() {
    return stub.listHostProjectRegistrationsCallable();
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
   * try (HostProjectRegistrationServiceClient hostProjectRegistrationServiceClient =
   *     HostProjectRegistrationServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element :
   *       hostProjectRegistrationServiceClient.listLocations(request).iterateAll()) {
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
   * try (HostProjectRegistrationServiceClient hostProjectRegistrationServiceClient =
   *     HostProjectRegistrationServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       hostProjectRegistrationServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (HostProjectRegistrationServiceClient hostProjectRegistrationServiceClient =
   *     HostProjectRegistrationServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         hostProjectRegistrationServiceClient.listLocationsCallable().call(request);
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
   * try (HostProjectRegistrationServiceClient hostProjectRegistrationServiceClient =
   *     HostProjectRegistrationServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = hostProjectRegistrationServiceClient.getLocation(request);
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
   * try (HostProjectRegistrationServiceClient hostProjectRegistrationServiceClient =
   *     HostProjectRegistrationServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       hostProjectRegistrationServiceClient.getLocationCallable().futureCall(request);
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

  public static class ListHostProjectRegistrationsPagedResponse
      extends AbstractPagedListResponse<
          ListHostProjectRegistrationsRequest,
          ListHostProjectRegistrationsResponse,
          HostProjectRegistration,
          ListHostProjectRegistrationsPage,
          ListHostProjectRegistrationsFixedSizeCollection> {

    public static ApiFuture<ListHostProjectRegistrationsPagedResponse> createAsync(
        PageContext<
                ListHostProjectRegistrationsRequest,
                ListHostProjectRegistrationsResponse,
                HostProjectRegistration>
            context,
        ApiFuture<ListHostProjectRegistrationsResponse> futureResponse) {
      ApiFuture<ListHostProjectRegistrationsPage> futurePage =
          ListHostProjectRegistrationsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListHostProjectRegistrationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListHostProjectRegistrationsPagedResponse(ListHostProjectRegistrationsPage page) {
      super(page, ListHostProjectRegistrationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListHostProjectRegistrationsPage
      extends AbstractPage<
          ListHostProjectRegistrationsRequest,
          ListHostProjectRegistrationsResponse,
          HostProjectRegistration,
          ListHostProjectRegistrationsPage> {

    private ListHostProjectRegistrationsPage(
        PageContext<
                ListHostProjectRegistrationsRequest,
                ListHostProjectRegistrationsResponse,
                HostProjectRegistration>
            context,
        ListHostProjectRegistrationsResponse response) {
      super(context, response);
    }

    private static ListHostProjectRegistrationsPage createEmptyPage() {
      return new ListHostProjectRegistrationsPage(null, null);
    }

    @Override
    protected ListHostProjectRegistrationsPage createPage(
        PageContext<
                ListHostProjectRegistrationsRequest,
                ListHostProjectRegistrationsResponse,
                HostProjectRegistration>
            context,
        ListHostProjectRegistrationsResponse response) {
      return new ListHostProjectRegistrationsPage(context, response);
    }

    @Override
    public ApiFuture<ListHostProjectRegistrationsPage> createPageAsync(
        PageContext<
                ListHostProjectRegistrationsRequest,
                ListHostProjectRegistrationsResponse,
                HostProjectRegistration>
            context,
        ApiFuture<ListHostProjectRegistrationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListHostProjectRegistrationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListHostProjectRegistrationsRequest,
          ListHostProjectRegistrationsResponse,
          HostProjectRegistration,
          ListHostProjectRegistrationsPage,
          ListHostProjectRegistrationsFixedSizeCollection> {

    private ListHostProjectRegistrationsFixedSizeCollection(
        List<ListHostProjectRegistrationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListHostProjectRegistrationsFixedSizeCollection createEmptyCollection() {
      return new ListHostProjectRegistrationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListHostProjectRegistrationsFixedSizeCollection createCollection(
        List<ListHostProjectRegistrationsPage> pages, int collectionSize) {
      return new ListHostProjectRegistrationsFixedSizeCollection(pages, collectionSize);
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
