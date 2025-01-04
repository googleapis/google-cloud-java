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

package com.google.cloud.dialogflow.v2beta1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.stub.SipTrunksStub;
import com.google.cloud.dialogflow.v2beta1.stub.SipTrunksStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing [SipTrunks][google.cloud.dialogflow.v2beta1.SipTrunk].
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
 * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   SipTrunk sipTrunk = SipTrunk.newBuilder().build();
 *   SipTrunk response = sipTrunksClient.createSipTrunk(parent, sipTrunk);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SipTrunksClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSipTrunk</td>
 *      <td><p> Creates a SipTrunk for a specified location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSipTrunk(CreateSipTrunkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSipTrunk(LocationName parent, SipTrunk sipTrunk)
 *           <li><p> createSipTrunk(String parent, SipTrunk sipTrunk)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSipTrunkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSipTrunk</td>
 *      <td><p> Deletes a specified SipTrunk.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSipTrunk(DeleteSipTrunkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteSipTrunk(SipTrunkName name)
 *           <li><p> deleteSipTrunk(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSipTrunkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSipTrunks</td>
 *      <td><p> Returns a list of SipTrunks in the specified location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSipTrunks(ListSipTrunksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSipTrunks(LocationName parent)
 *           <li><p> listSipTrunks(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSipTrunksPagedCallable()
 *           <li><p> listSipTrunksCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSipTrunk</td>
 *      <td><p> Retrieves the specified SipTrunk.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSipTrunk(GetSipTrunkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSipTrunk(SipTrunkName name)
 *           <li><p> getSipTrunk(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSipTrunkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSipTrunk</td>
 *      <td><p> Updates the specified SipTrunk.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSipTrunk(UpdateSipTrunkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSipTrunk(SipTrunk sipTrunk, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSipTrunkCallable()
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
 * <p>This class can be customized by passing in a custom instance of SipTrunksSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SipTrunksSettings sipTrunksSettings =
 *     SipTrunksSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SipTrunksClient sipTrunksClient = SipTrunksClient.create(sipTrunksSettings);
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
 * SipTrunksSettings sipTrunksSettings =
 *     SipTrunksSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SipTrunksClient sipTrunksClient = SipTrunksClient.create(sipTrunksSettings);
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
 * SipTrunksSettings sipTrunksSettings = SipTrunksSettings.newHttpJsonBuilder().build();
 * SipTrunksClient sipTrunksClient = SipTrunksClient.create(sipTrunksSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SipTrunksClient implements BackgroundResource {
  private final SipTrunksSettings settings;
  private final SipTrunksStub stub;

  /** Constructs an instance of SipTrunksClient with default settings. */
  public static final SipTrunksClient create() throws IOException {
    return create(SipTrunksSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SipTrunksClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SipTrunksClient create(SipTrunksSettings settings) throws IOException {
    return new SipTrunksClient(settings);
  }

  /**
   * Constructs an instance of SipTrunksClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(SipTrunksSettings).
   */
  public static final SipTrunksClient create(SipTrunksStub stub) {
    return new SipTrunksClient(stub);
  }

  /**
   * Constructs an instance of SipTrunksClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected SipTrunksClient(SipTrunksSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SipTrunksStubSettings) settings.getStubSettings()).createStub();
  }

  protected SipTrunksClient(SipTrunksStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SipTrunksSettings getSettings() {
    return settings;
  }

  public SipTrunksStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a SipTrunk for a specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   SipTrunk sipTrunk = SipTrunk.newBuilder().build();
   *   SipTrunk response = sipTrunksClient.createSipTrunk(parent, sipTrunk);
   * }
   * }</pre>
   *
   * @param parent Required. The location to create a SIP trunk for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;`.
   * @param sipTrunk Required. The SIP trunk to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SipTrunk createSipTrunk(LocationName parent, SipTrunk sipTrunk) {
    CreateSipTrunkRequest request =
        CreateSipTrunkRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSipTrunk(sipTrunk)
            .build();
    return createSipTrunk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a SipTrunk for a specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   SipTrunk sipTrunk = SipTrunk.newBuilder().build();
   *   SipTrunk response = sipTrunksClient.createSipTrunk(parent, sipTrunk);
   * }
   * }</pre>
   *
   * @param parent Required. The location to create a SIP trunk for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;`.
   * @param sipTrunk Required. The SIP trunk to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SipTrunk createSipTrunk(String parent, SipTrunk sipTrunk) {
    CreateSipTrunkRequest request =
        CreateSipTrunkRequest.newBuilder().setParent(parent).setSipTrunk(sipTrunk).build();
    return createSipTrunk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a SipTrunk for a specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   CreateSipTrunkRequest request =
   *       CreateSipTrunkRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSipTrunk(SipTrunk.newBuilder().build())
   *           .build();
   *   SipTrunk response = sipTrunksClient.createSipTrunk(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SipTrunk createSipTrunk(CreateSipTrunkRequest request) {
    return createSipTrunkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a SipTrunk for a specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   CreateSipTrunkRequest request =
   *       CreateSipTrunkRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSipTrunk(SipTrunk.newBuilder().build())
   *           .build();
   *   ApiFuture<SipTrunk> future = sipTrunksClient.createSipTrunkCallable().futureCall(request);
   *   // Do something.
   *   SipTrunk response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSipTrunkRequest, SipTrunk> createSipTrunkCallable() {
    return stub.createSipTrunkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specified SipTrunk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   SipTrunkName name = SipTrunkName.of("[PROJECT]", "[LOCATION]", "[SIPTRUNK]");
   *   sipTrunksClient.deleteSipTrunk(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the SIP trunk to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/sipTrunks/&lt;SipTrunk ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSipTrunk(SipTrunkName name) {
    DeleteSipTrunkRequest request =
        DeleteSipTrunkRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteSipTrunk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specified SipTrunk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   String name = SipTrunkName.of("[PROJECT]", "[LOCATION]", "[SIPTRUNK]").toString();
   *   sipTrunksClient.deleteSipTrunk(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the SIP trunk to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/sipTrunks/&lt;SipTrunk ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSipTrunk(String name) {
    DeleteSipTrunkRequest request = DeleteSipTrunkRequest.newBuilder().setName(name).build();
    deleteSipTrunk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specified SipTrunk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   DeleteSipTrunkRequest request =
   *       DeleteSipTrunkRequest.newBuilder()
   *           .setName(SipTrunkName.of("[PROJECT]", "[LOCATION]", "[SIPTRUNK]").toString())
   *           .build();
   *   sipTrunksClient.deleteSipTrunk(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSipTrunk(DeleteSipTrunkRequest request) {
    deleteSipTrunkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specified SipTrunk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   DeleteSipTrunkRequest request =
   *       DeleteSipTrunkRequest.newBuilder()
   *           .setName(SipTrunkName.of("[PROJECT]", "[LOCATION]", "[SIPTRUNK]").toString())
   *           .build();
   *   ApiFuture<Empty> future = sipTrunksClient.deleteSipTrunkCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSipTrunkRequest, Empty> deleteSipTrunkCallable() {
    return stub.deleteSipTrunkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of SipTrunks in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (SipTrunk element : sipTrunksClient.listSipTrunks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location to list SIP trunks from. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSipTrunksPagedResponse listSipTrunks(LocationName parent) {
    ListSipTrunksRequest request =
        ListSipTrunksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSipTrunks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of SipTrunks in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (SipTrunk element : sipTrunksClient.listSipTrunks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location to list SIP trunks from. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSipTrunksPagedResponse listSipTrunks(String parent) {
    ListSipTrunksRequest request = ListSipTrunksRequest.newBuilder().setParent(parent).build();
    return listSipTrunks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of SipTrunks in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   ListSipTrunksRequest request =
   *       ListSipTrunksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SipTrunk element : sipTrunksClient.listSipTrunks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSipTrunksPagedResponse listSipTrunks(ListSipTrunksRequest request) {
    return listSipTrunksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of SipTrunks in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   ListSipTrunksRequest request =
   *       ListSipTrunksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SipTrunk> future = sipTrunksClient.listSipTrunksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SipTrunk element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSipTrunksRequest, ListSipTrunksPagedResponse>
      listSipTrunksPagedCallable() {
    return stub.listSipTrunksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of SipTrunks in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   ListSipTrunksRequest request =
   *       ListSipTrunksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSipTrunksResponse response = sipTrunksClient.listSipTrunksCallable().call(request);
   *     for (SipTrunk element : response.getSipTrunksList()) {
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
  public final UnaryCallable<ListSipTrunksRequest, ListSipTrunksResponse> listSipTrunksCallable() {
    return stub.listSipTrunksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified SipTrunk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   SipTrunkName name = SipTrunkName.of("[PROJECT]", "[LOCATION]", "[SIPTRUNK]");
   *   SipTrunk response = sipTrunksClient.getSipTrunk(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the SIP trunk to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/sipTrunks/&lt;SipTrunk ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SipTrunk getSipTrunk(SipTrunkName name) {
    GetSipTrunkRequest request =
        GetSipTrunkRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSipTrunk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified SipTrunk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   String name = SipTrunkName.of("[PROJECT]", "[LOCATION]", "[SIPTRUNK]").toString();
   *   SipTrunk response = sipTrunksClient.getSipTrunk(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the SIP trunk to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/sipTrunks/&lt;SipTrunk ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SipTrunk getSipTrunk(String name) {
    GetSipTrunkRequest request = GetSipTrunkRequest.newBuilder().setName(name).build();
    return getSipTrunk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified SipTrunk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   GetSipTrunkRequest request =
   *       GetSipTrunkRequest.newBuilder()
   *           .setName(SipTrunkName.of("[PROJECT]", "[LOCATION]", "[SIPTRUNK]").toString())
   *           .build();
   *   SipTrunk response = sipTrunksClient.getSipTrunk(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SipTrunk getSipTrunk(GetSipTrunkRequest request) {
    return getSipTrunkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified SipTrunk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   GetSipTrunkRequest request =
   *       GetSipTrunkRequest.newBuilder()
   *           .setName(SipTrunkName.of("[PROJECT]", "[LOCATION]", "[SIPTRUNK]").toString())
   *           .build();
   *   ApiFuture<SipTrunk> future = sipTrunksClient.getSipTrunkCallable().futureCall(request);
   *   // Do something.
   *   SipTrunk response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSipTrunkRequest, SipTrunk> getSipTrunkCallable() {
    return stub.getSipTrunkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified SipTrunk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   SipTrunk sipTrunk = SipTrunk.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   SipTrunk response = sipTrunksClient.updateSipTrunk(sipTrunk, updateMask);
   * }
   * }</pre>
   *
   * @param sipTrunk Required. The SipTrunk to update.
   * @param updateMask Optional. The mask to control which fields get updated. If the mask is not
   *     present, all fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SipTrunk updateSipTrunk(SipTrunk sipTrunk, FieldMask updateMask) {
    UpdateSipTrunkRequest request =
        UpdateSipTrunkRequest.newBuilder().setSipTrunk(sipTrunk).setUpdateMask(updateMask).build();
    return updateSipTrunk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified SipTrunk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   UpdateSipTrunkRequest request =
   *       UpdateSipTrunkRequest.newBuilder()
   *           .setSipTrunk(SipTrunk.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   SipTrunk response = sipTrunksClient.updateSipTrunk(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SipTrunk updateSipTrunk(UpdateSipTrunkRequest request) {
    return updateSipTrunkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified SipTrunk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   UpdateSipTrunkRequest request =
   *       UpdateSipTrunkRequest.newBuilder()
   *           .setSipTrunk(SipTrunk.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<SipTrunk> future = sipTrunksClient.updateSipTrunkCallable().futureCall(request);
   *   // Do something.
   *   SipTrunk response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSipTrunkRequest, SipTrunk> updateSipTrunkCallable() {
    return stub.updateSipTrunkCallable();
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
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : sipTrunksClient.listLocations(request).iterateAll()) {
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
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = sipTrunksClient.listLocationsPagedCallable().futureCall(request);
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
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = sipTrunksClient.listLocationsCallable().call(request);
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
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = sipTrunksClient.getLocation(request);
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
   * try (SipTrunksClient sipTrunksClient = SipTrunksClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = sipTrunksClient.getLocationCallable().futureCall(request);
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

  public static class ListSipTrunksPagedResponse
      extends AbstractPagedListResponse<
          ListSipTrunksRequest,
          ListSipTrunksResponse,
          SipTrunk,
          ListSipTrunksPage,
          ListSipTrunksFixedSizeCollection> {

    public static ApiFuture<ListSipTrunksPagedResponse> createAsync(
        PageContext<ListSipTrunksRequest, ListSipTrunksResponse, SipTrunk> context,
        ApiFuture<ListSipTrunksResponse> futureResponse) {
      ApiFuture<ListSipTrunksPage> futurePage =
          ListSipTrunksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSipTrunksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSipTrunksPagedResponse(ListSipTrunksPage page) {
      super(page, ListSipTrunksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSipTrunksPage
      extends AbstractPage<
          ListSipTrunksRequest, ListSipTrunksResponse, SipTrunk, ListSipTrunksPage> {

    private ListSipTrunksPage(
        PageContext<ListSipTrunksRequest, ListSipTrunksResponse, SipTrunk> context,
        ListSipTrunksResponse response) {
      super(context, response);
    }

    private static ListSipTrunksPage createEmptyPage() {
      return new ListSipTrunksPage(null, null);
    }

    @Override
    protected ListSipTrunksPage createPage(
        PageContext<ListSipTrunksRequest, ListSipTrunksResponse, SipTrunk> context,
        ListSipTrunksResponse response) {
      return new ListSipTrunksPage(context, response);
    }

    @Override
    public ApiFuture<ListSipTrunksPage> createPageAsync(
        PageContext<ListSipTrunksRequest, ListSipTrunksResponse, SipTrunk> context,
        ApiFuture<ListSipTrunksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSipTrunksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSipTrunksRequest,
          ListSipTrunksResponse,
          SipTrunk,
          ListSipTrunksPage,
          ListSipTrunksFixedSizeCollection> {

    private ListSipTrunksFixedSizeCollection(List<ListSipTrunksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSipTrunksFixedSizeCollection createEmptyCollection() {
      return new ListSipTrunksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSipTrunksFixedSizeCollection createCollection(
        List<ListSipTrunksPage> pages, int collectionSize) {
      return new ListSipTrunksFixedSizeCollection(pages, collectionSize);
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
