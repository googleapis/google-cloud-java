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

package com.google.apps.meet.v2;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.apps.meet.v2.stub.SpacesServiceStub;
import com.google.apps.meet.v2.stub.SpacesServiceStubSettings;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: REST API for services dealing with spaces.
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
 * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
 *   Space space = Space.newBuilder().build();
 *   Space response = spacesServiceClient.createSpace(space);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SpacesServiceClient object to clean up resources such
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
 *      <td><p> CreateSpace</td>
 *      <td><p> Creates a space.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSpace(CreateSpaceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSpace(Space space)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSpaceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSpace</td>
 *      <td><p> Gets a space by `space_id` or `meeting_code`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSpace(GetSpaceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSpace(SpaceName name)
 *           <li><p> getSpace(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSpaceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSpace</td>
 *      <td><p> Updates a space.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSpace(UpdateSpaceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSpace(Space space, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSpaceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> EndActiveConference</td>
 *      <td><p> Ends an active conference (if there's one).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> endActiveConference(EndActiveConferenceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> endActiveConference(SpaceName name)
 *           <li><p> endActiveConference(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> endActiveConferenceCallable()
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
 * <p>This class can be customized by passing in a custom instance of SpacesServiceSettings to
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
 * SpacesServiceSettings spacesServiceSettings =
 *     SpacesServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SpacesServiceClient spacesServiceClient = SpacesServiceClient.create(spacesServiceSettings);
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
 * SpacesServiceSettings spacesServiceSettings =
 *     SpacesServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SpacesServiceClient spacesServiceClient = SpacesServiceClient.create(spacesServiceSettings);
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
 * SpacesServiceSettings spacesServiceSettings =
 *     SpacesServiceSettings.newHttpJsonBuilder().build();
 * SpacesServiceClient spacesServiceClient = SpacesServiceClient.create(spacesServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class SpacesServiceClient implements BackgroundResource {
  private final SpacesServiceSettings settings;
  private final SpacesServiceStub stub;

  /** Constructs an instance of SpacesServiceClient with default settings. */
  public static final SpacesServiceClient create() throws IOException {
    return create(SpacesServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SpacesServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SpacesServiceClient create(SpacesServiceSettings settings)
      throws IOException {
    return new SpacesServiceClient(settings);
  }

  /**
   * Constructs an instance of SpacesServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(SpacesServiceSettings).
   */
  public static final SpacesServiceClient create(SpacesServiceStub stub) {
    return new SpacesServiceClient(stub);
  }

  /**
   * Constructs an instance of SpacesServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SpacesServiceClient(SpacesServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SpacesServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SpacesServiceClient(SpacesServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SpacesServiceSettings getSettings() {
    return settings;
  }

  public SpacesServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   Space space = Space.newBuilder().build();
   *   Space response = spacesServiceClient.createSpace(space);
   * }
   * }</pre>
   *
   * @param space Space to be created. As of May 2023, the input space can be empty. Later on the
   *     input space can be non-empty when space configuration is introduced.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space createSpace(Space space) {
    CreateSpaceRequest request = CreateSpaceRequest.newBuilder().setSpace(space).build();
    return createSpace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   CreateSpaceRequest request =
   *       CreateSpaceRequest.newBuilder().setSpace(Space.newBuilder().build()).build();
   *   Space response = spacesServiceClient.createSpace(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space createSpace(CreateSpaceRequest request) {
    return createSpaceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   CreateSpaceRequest request =
   *       CreateSpaceRequest.newBuilder().setSpace(Space.newBuilder().build()).build();
   *   ApiFuture<Space> future = spacesServiceClient.createSpaceCallable().futureCall(request);
   *   // Do something.
   *   Space response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSpaceRequest, Space> createSpaceCallable() {
    return stub.createSpaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a space by `space_id` or `meeting_code`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   SpaceName name = SpaceName.of("[SPACE]");
   *   Space response = spacesServiceClient.getSpace(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the space.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space getSpace(SpaceName name) {
    GetSpaceRequest request =
        GetSpaceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSpace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a space by `space_id` or `meeting_code`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   String name = SpaceName.of("[SPACE]").toString();
   *   Space response = spacesServiceClient.getSpace(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the space.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space getSpace(String name) {
    GetSpaceRequest request = GetSpaceRequest.newBuilder().setName(name).build();
    return getSpace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a space by `space_id` or `meeting_code`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   GetSpaceRequest request =
   *       GetSpaceRequest.newBuilder().setName(SpaceName.of("[SPACE]").toString()).build();
   *   Space response = spacesServiceClient.getSpace(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space getSpace(GetSpaceRequest request) {
    return getSpaceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a space by `space_id` or `meeting_code`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   GetSpaceRequest request =
   *       GetSpaceRequest.newBuilder().setName(SpaceName.of("[SPACE]").toString()).build();
   *   ApiFuture<Space> future = spacesServiceClient.getSpaceCallable().futureCall(request);
   *   // Do something.
   *   Space response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSpaceRequest, Space> getSpaceCallable() {
    return stub.getSpaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   Space space = Space.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Space response = spacesServiceClient.updateSpace(space, updateMask);
   * }
   * }</pre>
   *
   * @param space Required. Space to be updated.
   * @param updateMask Optional. Field mask used to specify the fields to be updated in the space.
   *     If update_mask isn't provided, it defaults to '&#42;' and updates all fields provided in
   *     the request, including deleting fields not set in the request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space updateSpace(Space space, FieldMask updateMask) {
    UpdateSpaceRequest request =
        UpdateSpaceRequest.newBuilder().setSpace(space).setUpdateMask(updateMask).build();
    return updateSpace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   UpdateSpaceRequest request =
   *       UpdateSpaceRequest.newBuilder()
   *           .setSpace(Space.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Space response = spacesServiceClient.updateSpace(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Space updateSpace(UpdateSpaceRequest request) {
    return updateSpaceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a space.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   UpdateSpaceRequest request =
   *       UpdateSpaceRequest.newBuilder()
   *           .setSpace(Space.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Space> future = spacesServiceClient.updateSpaceCallable().futureCall(request);
   *   // Do something.
   *   Space response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSpaceRequest, Space> updateSpaceCallable() {
    return stub.updateSpaceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Ends an active conference (if there's one).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   SpaceName name = SpaceName.of("[SPACE]");
   *   spacesServiceClient.endActiveConference(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the space.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void endActiveConference(SpaceName name) {
    EndActiveConferenceRequest request =
        EndActiveConferenceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    endActiveConference(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Ends an active conference (if there's one).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   String name = SpaceName.of("[SPACE]").toString();
   *   spacesServiceClient.endActiveConference(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the space.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void endActiveConference(String name) {
    EndActiveConferenceRequest request =
        EndActiveConferenceRequest.newBuilder().setName(name).build();
    endActiveConference(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Ends an active conference (if there's one).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   EndActiveConferenceRequest request =
   *       EndActiveConferenceRequest.newBuilder()
   *           .setName(SpaceName.of("[SPACE]").toString())
   *           .build();
   *   spacesServiceClient.endActiveConference(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void endActiveConference(EndActiveConferenceRequest request) {
    endActiveConferenceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Ends an active conference (if there's one).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
   *   EndActiveConferenceRequest request =
   *       EndActiveConferenceRequest.newBuilder()
   *           .setName(SpaceName.of("[SPACE]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       spacesServiceClient.endActiveConferenceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EndActiveConferenceRequest, Empty> endActiveConferenceCallable() {
    return stub.endActiveConferenceCallable();
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
