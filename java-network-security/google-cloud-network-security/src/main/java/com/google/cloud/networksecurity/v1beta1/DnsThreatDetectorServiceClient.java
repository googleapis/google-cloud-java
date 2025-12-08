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

package com.google.cloud.networksecurity.v1beta1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networksecurity.v1beta1.stub.DnsThreatDetectorServiceStub;
import com.google.cloud.networksecurity.v1beta1.stub.DnsThreatDetectorServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Network Security API for DNS Threat Detectors.
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
 * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
 *     DnsThreatDetectorServiceClient.create()) {
 *   DnsThreatDetectorName name =
 *       DnsThreatDetectorName.of("[PROJECT]", "[LOCATION]", "[DNS_THREAT_DETECTOR]");
 *   DnsThreatDetector response = dnsThreatDetectorServiceClient.getDnsThreatDetector(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DnsThreatDetectorServiceClient object to clean up
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
 *      <td><p> ListDnsThreatDetectors</td>
 *      <td><p> Lists DnsThreatDetectors in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDnsThreatDetectors(ListDnsThreatDetectorsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDnsThreatDetectors(LocationName parent)
 *           <li><p> listDnsThreatDetectors(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDnsThreatDetectorsPagedCallable()
 *           <li><p> listDnsThreatDetectorsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDnsThreatDetector</td>
 *      <td><p> Gets the details of a single DnsThreatDetector.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDnsThreatDetector(GetDnsThreatDetectorRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDnsThreatDetector(DnsThreatDetectorName name)
 *           <li><p> getDnsThreatDetector(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDnsThreatDetectorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDnsThreatDetector</td>
 *      <td><p> Creates a new DnsThreatDetector in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDnsThreatDetector(CreateDnsThreatDetectorRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createDnsThreatDetector(LocationName parent, DnsThreatDetector dnsThreatDetector, String dnsThreatDetectorId)
 *           <li><p> createDnsThreatDetector(String parent, DnsThreatDetector dnsThreatDetector, String dnsThreatDetectorId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDnsThreatDetectorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDnsThreatDetector</td>
 *      <td><p> Updates a single DnsThreatDetector.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDnsThreatDetector(UpdateDnsThreatDetectorRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDnsThreatDetector(DnsThreatDetector dnsThreatDetector, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDnsThreatDetectorCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDnsThreatDetector</td>
 *      <td><p> Deletes a single DnsThreatDetector.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDnsThreatDetector(DeleteDnsThreatDetectorRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteDnsThreatDetector(DnsThreatDetectorName name)
 *           <li><p> deleteDnsThreatDetector(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDnsThreatDetectorCallable()
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
 * DnsThreatDetectorServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DnsThreatDetectorServiceSettings dnsThreatDetectorServiceSettings =
 *     DnsThreatDetectorServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
 *     DnsThreatDetectorServiceClient.create(dnsThreatDetectorServiceSettings);
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
 * DnsThreatDetectorServiceSettings dnsThreatDetectorServiceSettings =
 *     DnsThreatDetectorServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
 *     DnsThreatDetectorServiceClient.create(dnsThreatDetectorServiceSettings);
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
 * DnsThreatDetectorServiceSettings dnsThreatDetectorServiceSettings =
 *     DnsThreatDetectorServiceSettings.newHttpJsonBuilder().build();
 * DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
 *     DnsThreatDetectorServiceClient.create(dnsThreatDetectorServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DnsThreatDetectorServiceClient implements BackgroundResource {
  private final DnsThreatDetectorServiceSettings settings;
  private final DnsThreatDetectorServiceStub stub;

  /** Constructs an instance of DnsThreatDetectorServiceClient with default settings. */
  public static final DnsThreatDetectorServiceClient create() throws IOException {
    return create(DnsThreatDetectorServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DnsThreatDetectorServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final DnsThreatDetectorServiceClient create(
      DnsThreatDetectorServiceSettings settings) throws IOException {
    return new DnsThreatDetectorServiceClient(settings);
  }

  /**
   * Constructs an instance of DnsThreatDetectorServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(DnsThreatDetectorServiceSettings).
   */
  public static final DnsThreatDetectorServiceClient create(DnsThreatDetectorServiceStub stub) {
    return new DnsThreatDetectorServiceClient(stub);
  }

  /**
   * Constructs an instance of DnsThreatDetectorServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DnsThreatDetectorServiceClient(DnsThreatDetectorServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((DnsThreatDetectorServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected DnsThreatDetectorServiceClient(DnsThreatDetectorServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DnsThreatDetectorServiceSettings getSettings() {
    return settings;
  }

  public DnsThreatDetectorServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DnsThreatDetectors in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (DnsThreatDetector element :
   *       dnsThreatDetectorServiceClient.listDnsThreatDetectors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for `ListDnsThreatDetectorsRequest`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDnsThreatDetectorsPagedResponse listDnsThreatDetectors(LocationName parent) {
    ListDnsThreatDetectorsRequest request =
        ListDnsThreatDetectorsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDnsThreatDetectors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DnsThreatDetectors in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (DnsThreatDetector element :
   *       dnsThreatDetectorServiceClient.listDnsThreatDetectors(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent value for `ListDnsThreatDetectorsRequest`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDnsThreatDetectorsPagedResponse listDnsThreatDetectors(String parent) {
    ListDnsThreatDetectorsRequest request =
        ListDnsThreatDetectorsRequest.newBuilder().setParent(parent).build();
    return listDnsThreatDetectors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DnsThreatDetectors in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   ListDnsThreatDetectorsRequest request =
   *       ListDnsThreatDetectorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DnsThreatDetector element :
   *       dnsThreatDetectorServiceClient.listDnsThreatDetectors(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDnsThreatDetectorsPagedResponse listDnsThreatDetectors(
      ListDnsThreatDetectorsRequest request) {
    return listDnsThreatDetectorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DnsThreatDetectors in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   ListDnsThreatDetectorsRequest request =
   *       ListDnsThreatDetectorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DnsThreatDetector> future =
   *       dnsThreatDetectorServiceClient.listDnsThreatDetectorsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DnsThreatDetector element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDnsThreatDetectorsRequest, ListDnsThreatDetectorsPagedResponse>
      listDnsThreatDetectorsPagedCallable() {
    return stub.listDnsThreatDetectorsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DnsThreatDetectors in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   ListDnsThreatDetectorsRequest request =
   *       ListDnsThreatDetectorsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDnsThreatDetectorsResponse response =
   *         dnsThreatDetectorServiceClient.listDnsThreatDetectorsCallable().call(request);
   *     for (DnsThreatDetector element : response.getDnsThreatDetectorsList()) {
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
  public final UnaryCallable<ListDnsThreatDetectorsRequest, ListDnsThreatDetectorsResponse>
      listDnsThreatDetectorsCallable() {
    return stub.listDnsThreatDetectorsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single DnsThreatDetector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   DnsThreatDetectorName name =
   *       DnsThreatDetectorName.of("[PROJECT]", "[LOCATION]", "[DNS_THREAT_DETECTOR]");
   *   DnsThreatDetector response = dnsThreatDetectorServiceClient.getDnsThreatDetector(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the DnsThreatDetector resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DnsThreatDetector getDnsThreatDetector(DnsThreatDetectorName name) {
    GetDnsThreatDetectorRequest request =
        GetDnsThreatDetectorRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDnsThreatDetector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single DnsThreatDetector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   String name =
   *       DnsThreatDetectorName.of("[PROJECT]", "[LOCATION]", "[DNS_THREAT_DETECTOR]").toString();
   *   DnsThreatDetector response = dnsThreatDetectorServiceClient.getDnsThreatDetector(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the DnsThreatDetector resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DnsThreatDetector getDnsThreatDetector(String name) {
    GetDnsThreatDetectorRequest request =
        GetDnsThreatDetectorRequest.newBuilder().setName(name).build();
    return getDnsThreatDetector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single DnsThreatDetector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   GetDnsThreatDetectorRequest request =
   *       GetDnsThreatDetectorRequest.newBuilder()
   *           .setName(
   *               DnsThreatDetectorName.of("[PROJECT]", "[LOCATION]", "[DNS_THREAT_DETECTOR]")
   *                   .toString())
   *           .build();
   *   DnsThreatDetector response = dnsThreatDetectorServiceClient.getDnsThreatDetector(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DnsThreatDetector getDnsThreatDetector(GetDnsThreatDetectorRequest request) {
    return getDnsThreatDetectorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a single DnsThreatDetector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   GetDnsThreatDetectorRequest request =
   *       GetDnsThreatDetectorRequest.newBuilder()
   *           .setName(
   *               DnsThreatDetectorName.of("[PROJECT]", "[LOCATION]", "[DNS_THREAT_DETECTOR]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DnsThreatDetector> future =
   *       dnsThreatDetectorServiceClient.getDnsThreatDetectorCallable().futureCall(request);
   *   // Do something.
   *   DnsThreatDetector response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDnsThreatDetectorRequest, DnsThreatDetector>
      getDnsThreatDetectorCallable() {
    return stub.getDnsThreatDetectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DnsThreatDetector in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   DnsThreatDetector dnsThreatDetector = DnsThreatDetector.newBuilder().build();
   *   String dnsThreatDetectorId = "dnsThreatDetectorId-1579667324";
   *   DnsThreatDetector response =
   *       dnsThreatDetectorServiceClient.createDnsThreatDetector(
   *           parent, dnsThreatDetector, dnsThreatDetectorId);
   * }
   * }</pre>
   *
   * @param parent Required. The value for the parent of the DnsThreatDetector resource.
   * @param dnsThreatDetector Required. The `DnsThreatDetector` resource to create.
   * @param dnsThreatDetectorId Optional. The ID of the requesting DnsThreatDetector object. If this
   *     field is not supplied, the service generates an identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DnsThreatDetector createDnsThreatDetector(
      LocationName parent, DnsThreatDetector dnsThreatDetector, String dnsThreatDetectorId) {
    CreateDnsThreatDetectorRequest request =
        CreateDnsThreatDetectorRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDnsThreatDetector(dnsThreatDetector)
            .setDnsThreatDetectorId(dnsThreatDetectorId)
            .build();
    return createDnsThreatDetector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DnsThreatDetector in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   DnsThreatDetector dnsThreatDetector = DnsThreatDetector.newBuilder().build();
   *   String dnsThreatDetectorId = "dnsThreatDetectorId-1579667324";
   *   DnsThreatDetector response =
   *       dnsThreatDetectorServiceClient.createDnsThreatDetector(
   *           parent, dnsThreatDetector, dnsThreatDetectorId);
   * }
   * }</pre>
   *
   * @param parent Required. The value for the parent of the DnsThreatDetector resource.
   * @param dnsThreatDetector Required. The `DnsThreatDetector` resource to create.
   * @param dnsThreatDetectorId Optional. The ID of the requesting DnsThreatDetector object. If this
   *     field is not supplied, the service generates an identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DnsThreatDetector createDnsThreatDetector(
      String parent, DnsThreatDetector dnsThreatDetector, String dnsThreatDetectorId) {
    CreateDnsThreatDetectorRequest request =
        CreateDnsThreatDetectorRequest.newBuilder()
            .setParent(parent)
            .setDnsThreatDetector(dnsThreatDetector)
            .setDnsThreatDetectorId(dnsThreatDetectorId)
            .build();
    return createDnsThreatDetector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DnsThreatDetector in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   CreateDnsThreatDetectorRequest request =
   *       CreateDnsThreatDetectorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDnsThreatDetectorId("dnsThreatDetectorId-1579667324")
   *           .setDnsThreatDetector(DnsThreatDetector.newBuilder().build())
   *           .build();
   *   DnsThreatDetector response = dnsThreatDetectorServiceClient.createDnsThreatDetector(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DnsThreatDetector createDnsThreatDetector(CreateDnsThreatDetectorRequest request) {
    return createDnsThreatDetectorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new DnsThreatDetector in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   CreateDnsThreatDetectorRequest request =
   *       CreateDnsThreatDetectorRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDnsThreatDetectorId("dnsThreatDetectorId-1579667324")
   *           .setDnsThreatDetector(DnsThreatDetector.newBuilder().build())
   *           .build();
   *   ApiFuture<DnsThreatDetector> future =
   *       dnsThreatDetectorServiceClient.createDnsThreatDetectorCallable().futureCall(request);
   *   // Do something.
   *   DnsThreatDetector response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDnsThreatDetectorRequest, DnsThreatDetector>
      createDnsThreatDetectorCallable() {
    return stub.createDnsThreatDetectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single DnsThreatDetector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   DnsThreatDetector dnsThreatDetector = DnsThreatDetector.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DnsThreatDetector response =
   *       dnsThreatDetectorServiceClient.updateDnsThreatDetector(dnsThreatDetector, updateMask);
   * }
   * }</pre>
   *
   * @param dnsThreatDetector Required. The DnsThreatDetector resource being updated.
   * @param updateMask Optional. The field mask is used to specify the fields to be overwritten in
   *     the DnsThreatDetector resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the mask is not provided then all fields present in the request will be
   *     overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DnsThreatDetector updateDnsThreatDetector(
      DnsThreatDetector dnsThreatDetector, FieldMask updateMask) {
    UpdateDnsThreatDetectorRequest request =
        UpdateDnsThreatDetectorRequest.newBuilder()
            .setDnsThreatDetector(dnsThreatDetector)
            .setUpdateMask(updateMask)
            .build();
    return updateDnsThreatDetector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single DnsThreatDetector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   UpdateDnsThreatDetectorRequest request =
   *       UpdateDnsThreatDetectorRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDnsThreatDetector(DnsThreatDetector.newBuilder().build())
   *           .build();
   *   DnsThreatDetector response = dnsThreatDetectorServiceClient.updateDnsThreatDetector(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DnsThreatDetector updateDnsThreatDetector(UpdateDnsThreatDetectorRequest request) {
    return updateDnsThreatDetectorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single DnsThreatDetector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   UpdateDnsThreatDetectorRequest request =
   *       UpdateDnsThreatDetectorRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDnsThreatDetector(DnsThreatDetector.newBuilder().build())
   *           .build();
   *   ApiFuture<DnsThreatDetector> future =
   *       dnsThreatDetectorServiceClient.updateDnsThreatDetectorCallable().futureCall(request);
   *   // Do something.
   *   DnsThreatDetector response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDnsThreatDetectorRequest, DnsThreatDetector>
      updateDnsThreatDetectorCallable() {
    return stub.updateDnsThreatDetectorCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DnsThreatDetector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   DnsThreatDetectorName name =
   *       DnsThreatDetectorName.of("[PROJECT]", "[LOCATION]", "[DNS_THREAT_DETECTOR]");
   *   dnsThreatDetectorServiceClient.deleteDnsThreatDetector(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the DnsThreatDetector resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDnsThreatDetector(DnsThreatDetectorName name) {
    DeleteDnsThreatDetectorRequest request =
        DeleteDnsThreatDetectorRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteDnsThreatDetector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DnsThreatDetector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   String name =
   *       DnsThreatDetectorName.of("[PROJECT]", "[LOCATION]", "[DNS_THREAT_DETECTOR]").toString();
   *   dnsThreatDetectorServiceClient.deleteDnsThreatDetector(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the DnsThreatDetector resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDnsThreatDetector(String name) {
    DeleteDnsThreatDetectorRequest request =
        DeleteDnsThreatDetectorRequest.newBuilder().setName(name).build();
    deleteDnsThreatDetector(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DnsThreatDetector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   DeleteDnsThreatDetectorRequest request =
   *       DeleteDnsThreatDetectorRequest.newBuilder()
   *           .setName(
   *               DnsThreatDetectorName.of("[PROJECT]", "[LOCATION]", "[DNS_THREAT_DETECTOR]")
   *                   .toString())
   *           .build();
   *   dnsThreatDetectorServiceClient.deleteDnsThreatDetector(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDnsThreatDetector(DeleteDnsThreatDetectorRequest request) {
    deleteDnsThreatDetectorCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single DnsThreatDetector.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   DeleteDnsThreatDetectorRequest request =
   *       DeleteDnsThreatDetectorRequest.newBuilder()
   *           .setName(
   *               DnsThreatDetectorName.of("[PROJECT]", "[LOCATION]", "[DNS_THREAT_DETECTOR]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       dnsThreatDetectorServiceClient.deleteDnsThreatDetectorCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDnsThreatDetectorRequest, Empty>
      deleteDnsThreatDetectorCallable() {
    return stub.deleteDnsThreatDetectorCallable();
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
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : dnsThreatDetectorServiceClient.listLocations(request).iterateAll()) {
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
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       dnsThreatDetectorServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         dnsThreatDetectorServiceClient.listLocationsCallable().call(request);
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
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = dnsThreatDetectorServiceClient.getLocation(request);
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
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       dnsThreatDetectorServiceClient.getLocationCallable().futureCall(request);
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
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = dnsThreatDetectorServiceClient.setIamPolicy(request);
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
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       dnsThreatDetectorServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = dnsThreatDetectorServiceClient.getIamPolicy(request);
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
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       dnsThreatDetectorServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response =
   *       dnsThreatDetectorServiceClient.testIamPermissions(request);
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
   * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
   *     DnsThreatDetectorServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       dnsThreatDetectorServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListDnsThreatDetectorsPagedResponse
      extends AbstractPagedListResponse<
          ListDnsThreatDetectorsRequest,
          ListDnsThreatDetectorsResponse,
          DnsThreatDetector,
          ListDnsThreatDetectorsPage,
          ListDnsThreatDetectorsFixedSizeCollection> {

    public static ApiFuture<ListDnsThreatDetectorsPagedResponse> createAsync(
        PageContext<
                ListDnsThreatDetectorsRequest, ListDnsThreatDetectorsResponse, DnsThreatDetector>
            context,
        ApiFuture<ListDnsThreatDetectorsResponse> futureResponse) {
      ApiFuture<ListDnsThreatDetectorsPage> futurePage =
          ListDnsThreatDetectorsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDnsThreatDetectorsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDnsThreatDetectorsPagedResponse(ListDnsThreatDetectorsPage page) {
      super(page, ListDnsThreatDetectorsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDnsThreatDetectorsPage
      extends AbstractPage<
          ListDnsThreatDetectorsRequest,
          ListDnsThreatDetectorsResponse,
          DnsThreatDetector,
          ListDnsThreatDetectorsPage> {

    private ListDnsThreatDetectorsPage(
        PageContext<
                ListDnsThreatDetectorsRequest, ListDnsThreatDetectorsResponse, DnsThreatDetector>
            context,
        ListDnsThreatDetectorsResponse response) {
      super(context, response);
    }

    private static ListDnsThreatDetectorsPage createEmptyPage() {
      return new ListDnsThreatDetectorsPage(null, null);
    }

    @Override
    protected ListDnsThreatDetectorsPage createPage(
        PageContext<
                ListDnsThreatDetectorsRequest, ListDnsThreatDetectorsResponse, DnsThreatDetector>
            context,
        ListDnsThreatDetectorsResponse response) {
      return new ListDnsThreatDetectorsPage(context, response);
    }

    @Override
    public ApiFuture<ListDnsThreatDetectorsPage> createPageAsync(
        PageContext<
                ListDnsThreatDetectorsRequest, ListDnsThreatDetectorsResponse, DnsThreatDetector>
            context,
        ApiFuture<ListDnsThreatDetectorsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDnsThreatDetectorsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDnsThreatDetectorsRequest,
          ListDnsThreatDetectorsResponse,
          DnsThreatDetector,
          ListDnsThreatDetectorsPage,
          ListDnsThreatDetectorsFixedSizeCollection> {

    private ListDnsThreatDetectorsFixedSizeCollection(
        List<ListDnsThreatDetectorsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDnsThreatDetectorsFixedSizeCollection createEmptyCollection() {
      return new ListDnsThreatDetectorsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDnsThreatDetectorsFixedSizeCollection createCollection(
        List<ListDnsThreatDetectorsPage> pages, int collectionSize) {
      return new ListDnsThreatDetectorsFixedSizeCollection(pages, collectionSize);
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
