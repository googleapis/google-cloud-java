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

package com.google.cloud.dialogflow.v2;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2.stub.EncryptionSpecServiceStub;
import com.google.cloud.dialogflow.v2.stub.EncryptionSpecServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Manages encryption spec settings for Dialogflow and Agent Assist.
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
 * try (EncryptionSpecServiceClient encryptionSpecServiceClient =
 *     EncryptionSpecServiceClient.create()) {
 *   EncryptionSpecName name = EncryptionSpecName.of("[PROJECT]", "[LOCATION]");
 *   EncryptionSpec response = encryptionSpecServiceClient.getEncryptionSpec(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the EncryptionSpecServiceClient object to clean up
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
 *      <td><p> GetEncryptionSpec</td>
 *      <td><p> Gets location-level encryption key specification.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEncryptionSpec(GetEncryptionSpecRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEncryptionSpec(EncryptionSpecName name)
 *           <li><p> getEncryptionSpec(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEncryptionSpecCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> InitializeEncryptionSpec</td>
 *      <td><p> Initializes a location-level encryption key specification.  An error will be thrown if the location has resources already created before the initialization. Once the encryption specification is initialized at a location, it is immutable and all newly created resources under the location will be encrypted with the existing specification.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> initializeEncryptionSpecAsync(InitializeEncryptionSpecRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> initializeEncryptionSpecAsync(EncryptionSpec encryptionSpec)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> initializeEncryptionSpecOperationCallable()
 *           <li><p> initializeEncryptionSpecCallable()
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
 * <p>This class can be customized by passing in a custom instance of EncryptionSpecServiceSettings
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
 * EncryptionSpecServiceSettings encryptionSpecServiceSettings =
 *     EncryptionSpecServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * EncryptionSpecServiceClient encryptionSpecServiceClient =
 *     EncryptionSpecServiceClient.create(encryptionSpecServiceSettings);
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
 * EncryptionSpecServiceSettings encryptionSpecServiceSettings =
 *     EncryptionSpecServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * EncryptionSpecServiceClient encryptionSpecServiceClient =
 *     EncryptionSpecServiceClient.create(encryptionSpecServiceSettings);
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
 * EncryptionSpecServiceSettings encryptionSpecServiceSettings =
 *     EncryptionSpecServiceSettings.newHttpJsonBuilder().build();
 * EncryptionSpecServiceClient encryptionSpecServiceClient =
 *     EncryptionSpecServiceClient.create(encryptionSpecServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class EncryptionSpecServiceClient implements BackgroundResource {
  private final EncryptionSpecServiceSettings settings;
  private final EncryptionSpecServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of EncryptionSpecServiceClient with default settings. */
  public static final EncryptionSpecServiceClient create() throws IOException {
    return create(EncryptionSpecServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of EncryptionSpecServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final EncryptionSpecServiceClient create(EncryptionSpecServiceSettings settings)
      throws IOException {
    return new EncryptionSpecServiceClient(settings);
  }

  /**
   * Constructs an instance of EncryptionSpecServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(EncryptionSpecServiceSettings).
   */
  public static final EncryptionSpecServiceClient create(EncryptionSpecServiceStub stub) {
    return new EncryptionSpecServiceClient(stub);
  }

  /**
   * Constructs an instance of EncryptionSpecServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected EncryptionSpecServiceClient(EncryptionSpecServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((EncryptionSpecServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected EncryptionSpecServiceClient(EncryptionSpecServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final EncryptionSpecServiceSettings getSettings() {
    return settings;
  }

  public EncryptionSpecServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets location-level encryption key specification.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EncryptionSpecServiceClient encryptionSpecServiceClient =
   *     EncryptionSpecServiceClient.create()) {
   *   EncryptionSpecName name = EncryptionSpecName.of("[PROJECT]", "[LOCATION]");
   *   EncryptionSpec response = encryptionSpecServiceClient.getEncryptionSpec(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the encryption spec resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EncryptionSpec getEncryptionSpec(EncryptionSpecName name) {
    GetEncryptionSpecRequest request =
        GetEncryptionSpecRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getEncryptionSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets location-level encryption key specification.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EncryptionSpecServiceClient encryptionSpecServiceClient =
   *     EncryptionSpecServiceClient.create()) {
   *   String name = EncryptionSpecName.of("[PROJECT]", "[LOCATION]").toString();
   *   EncryptionSpec response = encryptionSpecServiceClient.getEncryptionSpec(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the encryption spec resource to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EncryptionSpec getEncryptionSpec(String name) {
    GetEncryptionSpecRequest request = GetEncryptionSpecRequest.newBuilder().setName(name).build();
    return getEncryptionSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets location-level encryption key specification.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EncryptionSpecServiceClient encryptionSpecServiceClient =
   *     EncryptionSpecServiceClient.create()) {
   *   GetEncryptionSpecRequest request =
   *       GetEncryptionSpecRequest.newBuilder()
   *           .setName(EncryptionSpecName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   EncryptionSpec response = encryptionSpecServiceClient.getEncryptionSpec(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EncryptionSpec getEncryptionSpec(GetEncryptionSpecRequest request) {
    return getEncryptionSpecCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets location-level encryption key specification.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EncryptionSpecServiceClient encryptionSpecServiceClient =
   *     EncryptionSpecServiceClient.create()) {
   *   GetEncryptionSpecRequest request =
   *       GetEncryptionSpecRequest.newBuilder()
   *           .setName(EncryptionSpecName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<EncryptionSpec> future =
   *       encryptionSpecServiceClient.getEncryptionSpecCallable().futureCall(request);
   *   // Do something.
   *   EncryptionSpec response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEncryptionSpecRequest, EncryptionSpec> getEncryptionSpecCallable() {
    return stub.getEncryptionSpecCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initializes a location-level encryption key specification. An error will be thrown if the
   * location has resources already created before the initialization. Once the encryption
   * specification is initialized at a location, it is immutable and all newly created resources
   * under the location will be encrypted with the existing specification.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EncryptionSpecServiceClient encryptionSpecServiceClient =
   *     EncryptionSpecServiceClient.create()) {
   *   EncryptionSpec encryptionSpec = EncryptionSpec.newBuilder().build();
   *   InitializeEncryptionSpecResponse response =
   *       encryptionSpecServiceClient.initializeEncryptionSpecAsync(encryptionSpec).get();
   * }
   * }</pre>
   *
   * @param encryptionSpec Required. The encryption spec used for CMEK encryption. It is required
   *     that the kms key is in the same region as the endpoint. The same key will be used for all
   *     provisioned resources, if encryption is available. If the kms_key_name is left empty, no
   *     encryption will be enforced.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InitializeEncryptionSpecResponse, InitializeEncryptionSpecMetadata>
      initializeEncryptionSpecAsync(EncryptionSpec encryptionSpec) {
    InitializeEncryptionSpecRequest request =
        InitializeEncryptionSpecRequest.newBuilder().setEncryptionSpec(encryptionSpec).build();
    return initializeEncryptionSpecAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initializes a location-level encryption key specification. An error will be thrown if the
   * location has resources already created before the initialization. Once the encryption
   * specification is initialized at a location, it is immutable and all newly created resources
   * under the location will be encrypted with the existing specification.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EncryptionSpecServiceClient encryptionSpecServiceClient =
   *     EncryptionSpecServiceClient.create()) {
   *   InitializeEncryptionSpecRequest request =
   *       InitializeEncryptionSpecRequest.newBuilder()
   *           .setEncryptionSpec(EncryptionSpec.newBuilder().build())
   *           .build();
   *   InitializeEncryptionSpecResponse response =
   *       encryptionSpecServiceClient.initializeEncryptionSpecAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InitializeEncryptionSpecResponse, InitializeEncryptionSpecMetadata>
      initializeEncryptionSpecAsync(InitializeEncryptionSpecRequest request) {
    return initializeEncryptionSpecOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initializes a location-level encryption key specification. An error will be thrown if the
   * location has resources already created before the initialization. Once the encryption
   * specification is initialized at a location, it is immutable and all newly created resources
   * under the location will be encrypted with the existing specification.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EncryptionSpecServiceClient encryptionSpecServiceClient =
   *     EncryptionSpecServiceClient.create()) {
   *   InitializeEncryptionSpecRequest request =
   *       InitializeEncryptionSpecRequest.newBuilder()
   *           .setEncryptionSpec(EncryptionSpec.newBuilder().build())
   *           .build();
   *   OperationFuture<InitializeEncryptionSpecResponse, InitializeEncryptionSpecMetadata> future =
   *       encryptionSpecServiceClient
   *           .initializeEncryptionSpecOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   InitializeEncryptionSpecResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          InitializeEncryptionSpecRequest,
          InitializeEncryptionSpecResponse,
          InitializeEncryptionSpecMetadata>
      initializeEncryptionSpecOperationCallable() {
    return stub.initializeEncryptionSpecOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initializes a location-level encryption key specification. An error will be thrown if the
   * location has resources already created before the initialization. Once the encryption
   * specification is initialized at a location, it is immutable and all newly created resources
   * under the location will be encrypted with the existing specification.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EncryptionSpecServiceClient encryptionSpecServiceClient =
   *     EncryptionSpecServiceClient.create()) {
   *   InitializeEncryptionSpecRequest request =
   *       InitializeEncryptionSpecRequest.newBuilder()
   *           .setEncryptionSpec(EncryptionSpec.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       encryptionSpecServiceClient.initializeEncryptionSpecCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InitializeEncryptionSpecRequest, Operation>
      initializeEncryptionSpecCallable() {
    return stub.initializeEncryptionSpecCallable();
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
   * try (EncryptionSpecServiceClient encryptionSpecServiceClient =
   *     EncryptionSpecServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : encryptionSpecServiceClient.listLocations(request).iterateAll()) {
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
   * try (EncryptionSpecServiceClient encryptionSpecServiceClient =
   *     EncryptionSpecServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       encryptionSpecServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (EncryptionSpecServiceClient encryptionSpecServiceClient =
   *     EncryptionSpecServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         encryptionSpecServiceClient.listLocationsCallable().call(request);
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
   * try (EncryptionSpecServiceClient encryptionSpecServiceClient =
   *     EncryptionSpecServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = encryptionSpecServiceClient.getLocation(request);
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
   * try (EncryptionSpecServiceClient encryptionSpecServiceClient =
   *     EncryptionSpecServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       encryptionSpecServiceClient.getLocationCallable().futureCall(request);
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
