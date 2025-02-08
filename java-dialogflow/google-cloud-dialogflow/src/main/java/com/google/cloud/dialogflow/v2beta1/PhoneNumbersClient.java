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
import com.google.cloud.dialogflow.v2beta1.stub.PhoneNumbersStub;
import com.google.cloud.dialogflow.v2beta1.stub.PhoneNumbersStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing
 * [PhoneNumbers][google.cloud.dialogflow.v2beta1.PhoneNumber].
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
 * try (PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create()) {
 *   PhoneNumber phoneNumber = PhoneNumber.newBuilder().build();
 *   FieldMask updateMask = FieldMask.newBuilder().build();
 *   PhoneNumber response = phoneNumbersClient.updatePhoneNumber(phoneNumber, updateMask);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PhoneNumbersClient object to clean up resources such
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
 *      <td><p> ListPhoneNumbers</td>
 *      <td><p> Returns the list of all phone numbers in the specified project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPhoneNumbers(ListPhoneNumbersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPhoneNumbers(LocationName parent)
 *           <li><p> listPhoneNumbers(ProjectName parent)
 *           <li><p> listPhoneNumbers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPhoneNumbersPagedCallable()
 *           <li><p> listPhoneNumbersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdatePhoneNumber</td>
 *      <td><p> Updates the specified `PhoneNumber`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updatePhoneNumber(UpdatePhoneNumberRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updatePhoneNumber(PhoneNumber phoneNumber, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updatePhoneNumberCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeletePhoneNumber</td>
 *      <td><p> Requests deletion of a `PhoneNumber`. The `PhoneNumber` is moved into the [DELETE_REQUESTED][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.DELETE_REQUESTED] state immediately, and is deleted approximately 30 days later. This method may only be called on a `PhoneNumber` in the [ACTIVE][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.ACTIVE] state.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deletePhoneNumber(DeletePhoneNumberRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deletePhoneNumber(PhoneNumberName name)
 *           <li><p> deletePhoneNumber(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deletePhoneNumberCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UndeletePhoneNumber</td>
 *      <td><p> Cancels the deletion request for a `PhoneNumber`. This method may only be called on a `PhoneNumber` in the [DELETE_REQUESTED][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.DELETE_REQUESTED] state.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> undeletePhoneNumber(UndeletePhoneNumberRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> undeletePhoneNumber(PhoneNumberName name)
 *           <li><p> undeletePhoneNumber(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> undeletePhoneNumberCallable()
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
 * <p>This class can be customized by passing in a custom instance of PhoneNumbersSettings to
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
 * PhoneNumbersSettings phoneNumbersSettings =
 *     PhoneNumbersSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create(phoneNumbersSettings);
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
 * PhoneNumbersSettings phoneNumbersSettings =
 *     PhoneNumbersSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create(phoneNumbersSettings);
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
 * PhoneNumbersSettings phoneNumbersSettings = PhoneNumbersSettings.newHttpJsonBuilder().build();
 * PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create(phoneNumbersSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class PhoneNumbersClient implements BackgroundResource {
  private final PhoneNumbersSettings settings;
  private final PhoneNumbersStub stub;

  /** Constructs an instance of PhoneNumbersClient with default settings. */
  public static final PhoneNumbersClient create() throws IOException {
    return create(PhoneNumbersSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PhoneNumbersClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PhoneNumbersClient create(PhoneNumbersSettings settings) throws IOException {
    return new PhoneNumbersClient(settings);
  }

  /**
   * Constructs an instance of PhoneNumbersClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(PhoneNumbersSettings).
   */
  public static final PhoneNumbersClient create(PhoneNumbersStub stub) {
    return new PhoneNumbersClient(stub);
  }

  /**
   * Constructs an instance of PhoneNumbersClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected PhoneNumbersClient(PhoneNumbersSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PhoneNumbersStubSettings) settings.getStubSettings()).createStub();
  }

  protected PhoneNumbersClient(PhoneNumbersStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PhoneNumbersSettings getSettings() {
    return settings;
  }

  public PhoneNumbersStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all phone numbers in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (PhoneNumber element : phoneNumbersClient.listPhoneNumbers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project to list all `PhoneNumber` resources from. Format:
   *     `projects/&lt;Project ID&gt;`. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPhoneNumbersPagedResponse listPhoneNumbers(LocationName parent) {
    ListPhoneNumbersRequest request =
        ListPhoneNumbersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPhoneNumbers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all phone numbers in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (PhoneNumber element : phoneNumbersClient.listPhoneNumbers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project to list all `PhoneNumber` resources from. Format:
   *     `projects/&lt;Project ID&gt;`. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPhoneNumbersPagedResponse listPhoneNumbers(ProjectName parent) {
    ListPhoneNumbersRequest request =
        ListPhoneNumbersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPhoneNumbers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all phone numbers in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (PhoneNumber element : phoneNumbersClient.listPhoneNumbers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project to list all `PhoneNumber` resources from. Format:
   *     `projects/&lt;Project ID&gt;`. Format: `projects/&lt;Project ID&gt;/locations/&lt;Location
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPhoneNumbersPagedResponse listPhoneNumbers(String parent) {
    ListPhoneNumbersRequest request =
        ListPhoneNumbersRequest.newBuilder().setParent(parent).build();
    return listPhoneNumbers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all phone numbers in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create()) {
   *   ListPhoneNumbersRequest request =
   *       ListPhoneNumbersRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   for (PhoneNumber element : phoneNumbersClient.listPhoneNumbers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPhoneNumbersPagedResponse listPhoneNumbers(ListPhoneNumbersRequest request) {
    return listPhoneNumbersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all phone numbers in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create()) {
   *   ListPhoneNumbersRequest request =
   *       ListPhoneNumbersRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<PhoneNumber> future =
   *       phoneNumbersClient.listPhoneNumbersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PhoneNumber element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPhoneNumbersRequest, ListPhoneNumbersPagedResponse>
      listPhoneNumbersPagedCallable() {
    return stub.listPhoneNumbersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all phone numbers in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create()) {
   *   ListPhoneNumbersRequest request =
   *       ListPhoneNumbersRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListPhoneNumbersResponse response =
   *         phoneNumbersClient.listPhoneNumbersCallable().call(request);
   *     for (PhoneNumber element : response.getPhoneNumbersList()) {
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
  public final UnaryCallable<ListPhoneNumbersRequest, ListPhoneNumbersResponse>
      listPhoneNumbersCallable() {
    return stub.listPhoneNumbersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified `PhoneNumber`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create()) {
   *   PhoneNumber phoneNumber = PhoneNumber.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   PhoneNumber response = phoneNumbersClient.updatePhoneNumber(phoneNumber, updateMask);
   * }
   * }</pre>
   *
   * @param phoneNumber Required. The `PhoneNumber` to update.
   * @param updateMask Optional. The mask to control which fields get updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhoneNumber updatePhoneNumber(PhoneNumber phoneNumber, FieldMask updateMask) {
    UpdatePhoneNumberRequest request =
        UpdatePhoneNumberRequest.newBuilder()
            .setPhoneNumber(phoneNumber)
            .setUpdateMask(updateMask)
            .build();
    return updatePhoneNumber(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified `PhoneNumber`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create()) {
   *   UpdatePhoneNumberRequest request =
   *       UpdatePhoneNumberRequest.newBuilder()
   *           .setPhoneNumber(PhoneNumber.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   PhoneNumber response = phoneNumbersClient.updatePhoneNumber(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhoneNumber updatePhoneNumber(UpdatePhoneNumberRequest request) {
    return updatePhoneNumberCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified `PhoneNumber`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create()) {
   *   UpdatePhoneNumberRequest request =
   *       UpdatePhoneNumberRequest.newBuilder()
   *           .setPhoneNumber(PhoneNumber.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<PhoneNumber> future =
   *       phoneNumbersClient.updatePhoneNumberCallable().futureCall(request);
   *   // Do something.
   *   PhoneNumber response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePhoneNumberRequest, PhoneNumber> updatePhoneNumberCallable() {
    return stub.updatePhoneNumberCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests deletion of a `PhoneNumber`. The `PhoneNumber` is moved into the
   * [DELETE_REQUESTED][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.DELETE_REQUESTED]
   * state immediately, and is deleted approximately 30 days later. This method may only be called
   * on a `PhoneNumber` in the
   * [ACTIVE][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.ACTIVE] state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create()) {
   *   PhoneNumberName name =
   *       PhoneNumberName.ofProjectPhoneNumberName("[PROJECT]", "[PHONE_NUMBER]");
   *   PhoneNumber response = phoneNumbersClient.deletePhoneNumber(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique identifier of the `PhoneNumber` to delete. Format:
   *     `projects/&lt;Project ID&gt;/phoneNumbers/&lt;PhoneNumber ID&gt;`. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/phoneNumbers/&lt;PhoneNumber
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhoneNumber deletePhoneNumber(PhoneNumberName name) {
    DeletePhoneNumberRequest request =
        DeletePhoneNumberRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deletePhoneNumber(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests deletion of a `PhoneNumber`. The `PhoneNumber` is moved into the
   * [DELETE_REQUESTED][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.DELETE_REQUESTED]
   * state immediately, and is deleted approximately 30 days later. This method may only be called
   * on a `PhoneNumber` in the
   * [ACTIVE][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.ACTIVE] state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create()) {
   *   String name =
   *       PhoneNumberName.ofProjectPhoneNumberName("[PROJECT]", "[PHONE_NUMBER]").toString();
   *   PhoneNumber response = phoneNumbersClient.deletePhoneNumber(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique identifier of the `PhoneNumber` to delete. Format:
   *     `projects/&lt;Project ID&gt;/phoneNumbers/&lt;PhoneNumber ID&gt;`. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/phoneNumbers/&lt;PhoneNumber
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhoneNumber deletePhoneNumber(String name) {
    DeletePhoneNumberRequest request = DeletePhoneNumberRequest.newBuilder().setName(name).build();
    return deletePhoneNumber(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests deletion of a `PhoneNumber`. The `PhoneNumber` is moved into the
   * [DELETE_REQUESTED][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.DELETE_REQUESTED]
   * state immediately, and is deleted approximately 30 days later. This method may only be called
   * on a `PhoneNumber` in the
   * [ACTIVE][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.ACTIVE] state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create()) {
   *   DeletePhoneNumberRequest request =
   *       DeletePhoneNumberRequest.newBuilder()
   *           .setName(
   *               PhoneNumberName.ofProjectPhoneNumberName("[PROJECT]", "[PHONE_NUMBER]")
   *                   .toString())
   *           .build();
   *   PhoneNumber response = phoneNumbersClient.deletePhoneNumber(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhoneNumber deletePhoneNumber(DeletePhoneNumberRequest request) {
    return deletePhoneNumberCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests deletion of a `PhoneNumber`. The `PhoneNumber` is moved into the
   * [DELETE_REQUESTED][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.DELETE_REQUESTED]
   * state immediately, and is deleted approximately 30 days later. This method may only be called
   * on a `PhoneNumber` in the
   * [ACTIVE][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.ACTIVE] state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create()) {
   *   DeletePhoneNumberRequest request =
   *       DeletePhoneNumberRequest.newBuilder()
   *           .setName(
   *               PhoneNumberName.ofProjectPhoneNumberName("[PROJECT]", "[PHONE_NUMBER]")
   *                   .toString())
   *           .build();
   *   ApiFuture<PhoneNumber> future =
   *       phoneNumbersClient.deletePhoneNumberCallable().futureCall(request);
   *   // Do something.
   *   PhoneNumber response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeletePhoneNumberRequest, PhoneNumber> deletePhoneNumberCallable() {
    return stub.deletePhoneNumberCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the deletion request for a `PhoneNumber`. This method may only be called on a
   * `PhoneNumber` in the
   * [DELETE_REQUESTED][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.DELETE_REQUESTED]
   * state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create()) {
   *   PhoneNumberName name =
   *       PhoneNumberName.ofProjectPhoneNumberName("[PROJECT]", "[PHONE_NUMBER]");
   *   PhoneNumber response = phoneNumbersClient.undeletePhoneNumber(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique identifier of the `PhoneNumber` to delete. Format:
   *     `projects/&lt;Project ID&gt;/phoneNumbers/&lt;PhoneNumber ID&gt;`. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/phoneNumbers/&lt;PhoneNumber
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhoneNumber undeletePhoneNumber(PhoneNumberName name) {
    UndeletePhoneNumberRequest request =
        UndeletePhoneNumberRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return undeletePhoneNumber(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the deletion request for a `PhoneNumber`. This method may only be called on a
   * `PhoneNumber` in the
   * [DELETE_REQUESTED][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.DELETE_REQUESTED]
   * state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create()) {
   *   String name =
   *       PhoneNumberName.ofProjectPhoneNumberName("[PROJECT]", "[PHONE_NUMBER]").toString();
   *   PhoneNumber response = phoneNumbersClient.undeletePhoneNumber(name);
   * }
   * }</pre>
   *
   * @param name Required. The unique identifier of the `PhoneNumber` to delete. Format:
   *     `projects/&lt;Project ID&gt;/phoneNumbers/&lt;PhoneNumber ID&gt;`. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/phoneNumbers/&lt;PhoneNumber
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhoneNumber undeletePhoneNumber(String name) {
    UndeletePhoneNumberRequest request =
        UndeletePhoneNumberRequest.newBuilder().setName(name).build();
    return undeletePhoneNumber(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the deletion request for a `PhoneNumber`. This method may only be called on a
   * `PhoneNumber` in the
   * [DELETE_REQUESTED][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.DELETE_REQUESTED]
   * state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create()) {
   *   UndeletePhoneNumberRequest request =
   *       UndeletePhoneNumberRequest.newBuilder()
   *           .setName(
   *               PhoneNumberName.ofProjectPhoneNumberName("[PROJECT]", "[PHONE_NUMBER]")
   *                   .toString())
   *           .build();
   *   PhoneNumber response = phoneNumbersClient.undeletePhoneNumber(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PhoneNumber undeletePhoneNumber(UndeletePhoneNumberRequest request) {
    return undeletePhoneNumberCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the deletion request for a `PhoneNumber`. This method may only be called on a
   * `PhoneNumber` in the
   * [DELETE_REQUESTED][google.cloud.dialogflow.v2beta1.PhoneNumber.LifecycleState.DELETE_REQUESTED]
   * state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create()) {
   *   UndeletePhoneNumberRequest request =
   *       UndeletePhoneNumberRequest.newBuilder()
   *           .setName(
   *               PhoneNumberName.ofProjectPhoneNumberName("[PROJECT]", "[PHONE_NUMBER]")
   *                   .toString())
   *           .build();
   *   ApiFuture<PhoneNumber> future =
   *       phoneNumbersClient.undeletePhoneNumberCallable().futureCall(request);
   *   // Do something.
   *   PhoneNumber response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeletePhoneNumberRequest, PhoneNumber>
      undeletePhoneNumberCallable() {
    return stub.undeletePhoneNumberCallable();
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
   * try (PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : phoneNumbersClient.listLocations(request).iterateAll()) {
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
   * try (PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       phoneNumbersClient.listLocationsPagedCallable().futureCall(request);
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
   * try (PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = phoneNumbersClient.listLocationsCallable().call(request);
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
   * try (PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = phoneNumbersClient.getLocation(request);
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
   * try (PhoneNumbersClient phoneNumbersClient = PhoneNumbersClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = phoneNumbersClient.getLocationCallable().futureCall(request);
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

  public static class ListPhoneNumbersPagedResponse
      extends AbstractPagedListResponse<
          ListPhoneNumbersRequest,
          ListPhoneNumbersResponse,
          PhoneNumber,
          ListPhoneNumbersPage,
          ListPhoneNumbersFixedSizeCollection> {

    public static ApiFuture<ListPhoneNumbersPagedResponse> createAsync(
        PageContext<ListPhoneNumbersRequest, ListPhoneNumbersResponse, PhoneNumber> context,
        ApiFuture<ListPhoneNumbersResponse> futureResponse) {
      ApiFuture<ListPhoneNumbersPage> futurePage =
          ListPhoneNumbersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPhoneNumbersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPhoneNumbersPagedResponse(ListPhoneNumbersPage page) {
      super(page, ListPhoneNumbersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPhoneNumbersPage
      extends AbstractPage<
          ListPhoneNumbersRequest, ListPhoneNumbersResponse, PhoneNumber, ListPhoneNumbersPage> {

    private ListPhoneNumbersPage(
        PageContext<ListPhoneNumbersRequest, ListPhoneNumbersResponse, PhoneNumber> context,
        ListPhoneNumbersResponse response) {
      super(context, response);
    }

    private static ListPhoneNumbersPage createEmptyPage() {
      return new ListPhoneNumbersPage(null, null);
    }

    @Override
    protected ListPhoneNumbersPage createPage(
        PageContext<ListPhoneNumbersRequest, ListPhoneNumbersResponse, PhoneNumber> context,
        ListPhoneNumbersResponse response) {
      return new ListPhoneNumbersPage(context, response);
    }

    @Override
    public ApiFuture<ListPhoneNumbersPage> createPageAsync(
        PageContext<ListPhoneNumbersRequest, ListPhoneNumbersResponse, PhoneNumber> context,
        ApiFuture<ListPhoneNumbersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPhoneNumbersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPhoneNumbersRequest,
          ListPhoneNumbersResponse,
          PhoneNumber,
          ListPhoneNumbersPage,
          ListPhoneNumbersFixedSizeCollection> {

    private ListPhoneNumbersFixedSizeCollection(
        List<ListPhoneNumbersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPhoneNumbersFixedSizeCollection createEmptyCollection() {
      return new ListPhoneNumbersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPhoneNumbersFixedSizeCollection createCollection(
        List<ListPhoneNumbersPage> pages, int collectionSize) {
      return new ListPhoneNumbersFixedSizeCollection(pages, collectionSize);
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
