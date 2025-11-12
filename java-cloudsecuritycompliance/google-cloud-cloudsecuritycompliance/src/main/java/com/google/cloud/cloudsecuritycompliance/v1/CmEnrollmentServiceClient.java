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

package com.google.cloud.cloudsecuritycompliance.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.cloudsecuritycompliance.v1.stub.CmEnrollmentServiceStub;
import com.google.cloud.cloudsecuritycompliance.v1.stub.CmEnrollmentServiceStubSettings;
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
 * Service Description: Service describing CmEnrollment related RPCs for complianceManager.
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
 * try (CmEnrollmentServiceClient cmEnrollmentServiceClient = CmEnrollmentServiceClient.create()) {
 *   CmEnrollment cmEnrollment = CmEnrollment.newBuilder().build();
 *   FieldMask updateMask = FieldMask.newBuilder().build();
 *   CmEnrollment response =
 *       cmEnrollmentServiceClient.updateCmEnrollment(cmEnrollment, updateMask);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CmEnrollmentServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCmEnrollment</td>
 *      <td><p> Updates the Compliance Manager enrollment for a resource to facilitate an audit. Use this method to enroll a resource in Compliance Manager or to create or update feature-specific configurations.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateCmEnrollment(UpdateCmEnrollmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateCmEnrollment(CmEnrollment cmEnrollment, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCmEnrollmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CalculateEffectiveCmEnrollment</td>
 *      <td><p> Calculates the effective Compliance Manager enrollment for a resource. An effective enrollment is either a direct enrollment of a resource (if it exists), or an enrollment of the closest parent of a resource that's enrolled in Compliance Manager.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> calculateEffectiveCmEnrollment(CalculateEffectiveCmEnrollmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> calculateEffectiveCmEnrollment(CmEnrollmentName name)
 *           <li><p> calculateEffectiveCmEnrollment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> calculateEffectiveCmEnrollmentCallable()
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
 * <p>This class can be customized by passing in a custom instance of CmEnrollmentServiceSettings to
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
 * CmEnrollmentServiceSettings cmEnrollmentServiceSettings =
 *     CmEnrollmentServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CmEnrollmentServiceClient cmEnrollmentServiceClient =
 *     CmEnrollmentServiceClient.create(cmEnrollmentServiceSettings);
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
 * CmEnrollmentServiceSettings cmEnrollmentServiceSettings =
 *     CmEnrollmentServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CmEnrollmentServiceClient cmEnrollmentServiceClient =
 *     CmEnrollmentServiceClient.create(cmEnrollmentServiceSettings);
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
 * CmEnrollmentServiceSettings cmEnrollmentServiceSettings =
 *     CmEnrollmentServiceSettings.newHttpJsonBuilder().build();
 * CmEnrollmentServiceClient cmEnrollmentServiceClient =
 *     CmEnrollmentServiceClient.create(cmEnrollmentServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CmEnrollmentServiceClient implements BackgroundResource {
  private final CmEnrollmentServiceSettings settings;
  private final CmEnrollmentServiceStub stub;

  /** Constructs an instance of CmEnrollmentServiceClient with default settings. */
  public static final CmEnrollmentServiceClient create() throws IOException {
    return create(CmEnrollmentServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CmEnrollmentServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CmEnrollmentServiceClient create(CmEnrollmentServiceSettings settings)
      throws IOException {
    return new CmEnrollmentServiceClient(settings);
  }

  /**
   * Constructs an instance of CmEnrollmentServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(CmEnrollmentServiceSettings).
   */
  public static final CmEnrollmentServiceClient create(CmEnrollmentServiceStub stub) {
    return new CmEnrollmentServiceClient(stub);
  }

  /**
   * Constructs an instance of CmEnrollmentServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected CmEnrollmentServiceClient(CmEnrollmentServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CmEnrollmentServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected CmEnrollmentServiceClient(CmEnrollmentServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CmEnrollmentServiceSettings getSettings() {
    return settings;
  }

  public CmEnrollmentServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Compliance Manager enrollment for a resource to facilitate an audit. Use this
   * method to enroll a resource in Compliance Manager or to create or update feature-specific
   * configurations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmEnrollmentServiceClient cmEnrollmentServiceClient = CmEnrollmentServiceClient.create()) {
   *   CmEnrollment cmEnrollment = CmEnrollment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CmEnrollment response =
   *       cmEnrollmentServiceClient.updateCmEnrollment(cmEnrollment, updateMask);
   * }
   * }</pre>
   *
   * @param cmEnrollment Required. The Compliance Manager enrollment to update. The `name` field is
   *     used to identify the settings that you want to update.
   * @param updateMask Optional. The list of fields that you want to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CmEnrollment updateCmEnrollment(CmEnrollment cmEnrollment, FieldMask updateMask) {
    UpdateCmEnrollmentRequest request =
        UpdateCmEnrollmentRequest.newBuilder()
            .setCmEnrollment(cmEnrollment)
            .setUpdateMask(updateMask)
            .build();
    return updateCmEnrollment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Compliance Manager enrollment for a resource to facilitate an audit. Use this
   * method to enroll a resource in Compliance Manager or to create or update feature-specific
   * configurations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmEnrollmentServiceClient cmEnrollmentServiceClient = CmEnrollmentServiceClient.create()) {
   *   UpdateCmEnrollmentRequest request =
   *       UpdateCmEnrollmentRequest.newBuilder()
   *           .setCmEnrollment(CmEnrollment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   CmEnrollment response = cmEnrollmentServiceClient.updateCmEnrollment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CmEnrollment updateCmEnrollment(UpdateCmEnrollmentRequest request) {
    return updateCmEnrollmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Compliance Manager enrollment for a resource to facilitate an audit. Use this
   * method to enroll a resource in Compliance Manager or to create or update feature-specific
   * configurations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmEnrollmentServiceClient cmEnrollmentServiceClient = CmEnrollmentServiceClient.create()) {
   *   UpdateCmEnrollmentRequest request =
   *       UpdateCmEnrollmentRequest.newBuilder()
   *           .setCmEnrollment(CmEnrollment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<CmEnrollment> future =
   *       cmEnrollmentServiceClient.updateCmEnrollmentCallable().futureCall(request);
   *   // Do something.
   *   CmEnrollment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCmEnrollmentRequest, CmEnrollment> updateCmEnrollmentCallable() {
    return stub.updateCmEnrollmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Calculates the effective Compliance Manager enrollment for a resource. An effective enrollment
   * is either a direct enrollment of a resource (if it exists), or an enrollment of the closest
   * parent of a resource that's enrolled in Compliance Manager.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmEnrollmentServiceClient cmEnrollmentServiceClient = CmEnrollmentServiceClient.create()) {
   *   CmEnrollmentName name =
   *       CmEnrollmentName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]");
   *   CalculateEffectiveCmEnrollmentResponse response =
   *       cmEnrollmentServiceClient.calculateEffectiveCmEnrollment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Compliance Manager enrollment to calculate.
   *     <p>Supported formats are the following:
   *     <ul>
   *       <li>`organizations/{organization_id}/locations/{location}/cmEnrollment`
   *       <li>`folders/{folder_id}/locations/{location}/cmEnrollment`
   *       <li>`projects/{project_id}/locations/{location}/cmEnrollment`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CalculateEffectiveCmEnrollmentResponse calculateEffectiveCmEnrollment(
      CmEnrollmentName name) {
    CalculateEffectiveCmEnrollmentRequest request =
        CalculateEffectiveCmEnrollmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return calculateEffectiveCmEnrollment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Calculates the effective Compliance Manager enrollment for a resource. An effective enrollment
   * is either a direct enrollment of a resource (if it exists), or an enrollment of the closest
   * parent of a resource that's enrolled in Compliance Manager.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmEnrollmentServiceClient cmEnrollmentServiceClient = CmEnrollmentServiceClient.create()) {
   *   String name =
   *       CmEnrollmentName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]").toString();
   *   CalculateEffectiveCmEnrollmentResponse response =
   *       cmEnrollmentServiceClient.calculateEffectiveCmEnrollment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Compliance Manager enrollment to calculate.
   *     <p>Supported formats are the following:
   *     <ul>
   *       <li>`organizations/{organization_id}/locations/{location}/cmEnrollment`
   *       <li>`folders/{folder_id}/locations/{location}/cmEnrollment`
   *       <li>`projects/{project_id}/locations/{location}/cmEnrollment`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CalculateEffectiveCmEnrollmentResponse calculateEffectiveCmEnrollment(String name) {
    CalculateEffectiveCmEnrollmentRequest request =
        CalculateEffectiveCmEnrollmentRequest.newBuilder().setName(name).build();
    return calculateEffectiveCmEnrollment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Calculates the effective Compliance Manager enrollment for a resource. An effective enrollment
   * is either a direct enrollment of a resource (if it exists), or an enrollment of the closest
   * parent of a resource that's enrolled in Compliance Manager.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmEnrollmentServiceClient cmEnrollmentServiceClient = CmEnrollmentServiceClient.create()) {
   *   CalculateEffectiveCmEnrollmentRequest request =
   *       CalculateEffectiveCmEnrollmentRequest.newBuilder()
   *           .setName(
   *               CmEnrollmentName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]")
   *                   .toString())
   *           .build();
   *   CalculateEffectiveCmEnrollmentResponse response =
   *       cmEnrollmentServiceClient.calculateEffectiveCmEnrollment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CalculateEffectiveCmEnrollmentResponse calculateEffectiveCmEnrollment(
      CalculateEffectiveCmEnrollmentRequest request) {
    return calculateEffectiveCmEnrollmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Calculates the effective Compliance Manager enrollment for a resource. An effective enrollment
   * is either a direct enrollment of a resource (if it exists), or an enrollment of the closest
   * parent of a resource that's enrolled in Compliance Manager.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CmEnrollmentServiceClient cmEnrollmentServiceClient = CmEnrollmentServiceClient.create()) {
   *   CalculateEffectiveCmEnrollmentRequest request =
   *       CalculateEffectiveCmEnrollmentRequest.newBuilder()
   *           .setName(
   *               CmEnrollmentName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CalculateEffectiveCmEnrollmentResponse> future =
   *       cmEnrollmentServiceClient.calculateEffectiveCmEnrollmentCallable().futureCall(request);
   *   // Do something.
   *   CalculateEffectiveCmEnrollmentResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          CalculateEffectiveCmEnrollmentRequest, CalculateEffectiveCmEnrollmentResponse>
      calculateEffectiveCmEnrollmentCallable() {
    return stub.calculateEffectiveCmEnrollmentCallable();
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
   * try (CmEnrollmentServiceClient cmEnrollmentServiceClient = CmEnrollmentServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : cmEnrollmentServiceClient.listLocations(request).iterateAll()) {
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
   * try (CmEnrollmentServiceClient cmEnrollmentServiceClient = CmEnrollmentServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       cmEnrollmentServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (CmEnrollmentServiceClient cmEnrollmentServiceClient = CmEnrollmentServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         cmEnrollmentServiceClient.listLocationsCallable().call(request);
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
   * try (CmEnrollmentServiceClient cmEnrollmentServiceClient = CmEnrollmentServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = cmEnrollmentServiceClient.getLocation(request);
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
   * try (CmEnrollmentServiceClient cmEnrollmentServiceClient = CmEnrollmentServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       cmEnrollmentServiceClient.getLocationCallable().futureCall(request);
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
