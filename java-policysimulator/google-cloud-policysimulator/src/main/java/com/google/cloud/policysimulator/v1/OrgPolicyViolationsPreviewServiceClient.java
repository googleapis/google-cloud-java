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

package com.google.cloud.policysimulator.v1;

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
import com.google.cloud.policysimulator.v1.stub.OrgPolicyViolationsPreviewServiceStub;
import com.google.cloud.policysimulator.v1.stub.OrgPolicyViolationsPreviewServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Violations Preview API service for OrgPolicy.
 *
 * <p>An [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] is
 * a preview of the violations that will exist as soon as a proposed OrgPolicy change is submitted.
 * To create an
 * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview], the API
 * user specifies the changes they wish to make and requests the generation of a preview via
 * [GenerateViolationsPreview][]. the OrgPolicy Simulator service then scans the API user's
 * currently existing resources to determine these resources violate the newly set OrgPolicy.
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
 * try (OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
 *     OrgPolicyViolationsPreviewServiceClient.create()) {
 *   OrgPolicyViolationsPreviewName name =
 *       OrgPolicyViolationsPreviewName.of(
 *           "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]");
 *   OrgPolicyViolationsPreview response =
 *       orgPolicyViolationsPreviewServiceClient.getOrgPolicyViolationsPreview(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the OrgPolicyViolationsPreviewServiceClient object to
 * clean up resources such as threads. In the example above, try-with-resources is used, which
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
 *      <td><p> ListOrgPolicyViolationsPreviews</td>
 *      <td><p> ListOrgPolicyViolationsPreviews lists each [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] in an organization. Each [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] is available for at least 7 days.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listOrgPolicyViolationsPreviews(ListOrgPolicyViolationsPreviewsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listOrgPolicyViolationsPreviews(OrganizationLocationName parent)
 *           <li><p> listOrgPolicyViolationsPreviews(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listOrgPolicyViolationsPreviewsPagedCallable()
 *           <li><p> listOrgPolicyViolationsPreviewsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetOrgPolicyViolationsPreview</td>
 *      <td><p> GetOrgPolicyViolationsPreview gets the specified [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]. Each [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] is available for at least 7 days.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getOrgPolicyViolationsPreview(GetOrgPolicyViolationsPreviewRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getOrgPolicyViolationsPreview(OrgPolicyViolationsPreviewName name)
 *           <li><p> getOrgPolicyViolationsPreview(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getOrgPolicyViolationsPreviewCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateOrgPolicyViolationsPreview</td>
 *      <td><p> CreateOrgPolicyViolationsPreview creates an [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] for the proposed changes in the provided [OrgPolicyViolationsPreview.OrgPolicyOverlay][]. The changes to OrgPolicy are specified by this `OrgPolicyOverlay`. The resources to scan are inferred from these specified changes.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createOrgPolicyViolationsPreviewAsync(CreateOrgPolicyViolationsPreviewRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createOrgPolicyViolationsPreviewAsync(OrganizationLocationName parent, OrgPolicyViolationsPreview orgPolicyViolationsPreview, String orgPolicyViolationsPreviewId)
 *           <li><p> createOrgPolicyViolationsPreviewAsync(String parent, OrgPolicyViolationsPreview orgPolicyViolationsPreview, String orgPolicyViolationsPreviewId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createOrgPolicyViolationsPreviewOperationCallable()
 *           <li><p> createOrgPolicyViolationsPreviewCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListOrgPolicyViolations</td>
 *      <td><p> ListOrgPolicyViolations lists the [OrgPolicyViolations][] that are present in an [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listOrgPolicyViolations(ListOrgPolicyViolationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listOrgPolicyViolations(OrgPolicyViolationsPreviewName parent)
 *           <li><p> listOrgPolicyViolations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listOrgPolicyViolationsPagedCallable()
 *           <li><p> listOrgPolicyViolationsCallable()
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
 * OrgPolicyViolationsPreviewServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OrgPolicyViolationsPreviewServiceSettings orgPolicyViolationsPreviewServiceSettings =
 *     OrgPolicyViolationsPreviewServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
 *     OrgPolicyViolationsPreviewServiceClient.create(orgPolicyViolationsPreviewServiceSettings);
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
 * OrgPolicyViolationsPreviewServiceSettings orgPolicyViolationsPreviewServiceSettings =
 *     OrgPolicyViolationsPreviewServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
 *     OrgPolicyViolationsPreviewServiceClient.create(orgPolicyViolationsPreviewServiceSettings);
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
 * OrgPolicyViolationsPreviewServiceSettings orgPolicyViolationsPreviewServiceSettings =
 *     OrgPolicyViolationsPreviewServiceSettings.newHttpJsonBuilder().build();
 * OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
 *     OrgPolicyViolationsPreviewServiceClient.create(orgPolicyViolationsPreviewServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class OrgPolicyViolationsPreviewServiceClient implements BackgroundResource {
  private final OrgPolicyViolationsPreviewServiceSettings settings;
  private final OrgPolicyViolationsPreviewServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of OrgPolicyViolationsPreviewServiceClient with default settings. */
  public static final OrgPolicyViolationsPreviewServiceClient create() throws IOException {
    return create(OrgPolicyViolationsPreviewServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of OrgPolicyViolationsPreviewServiceClient, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any settings that are
   * not set.
   */
  public static final OrgPolicyViolationsPreviewServiceClient create(
      OrgPolicyViolationsPreviewServiceSettings settings) throws IOException {
    return new OrgPolicyViolationsPreviewServiceClient(settings);
  }

  /**
   * Constructs an instance of OrgPolicyViolationsPreviewServiceClient, using the given stub for
   * making calls. This is for advanced usage - prefer using
   * create(OrgPolicyViolationsPreviewServiceSettings).
   */
  public static final OrgPolicyViolationsPreviewServiceClient create(
      OrgPolicyViolationsPreviewServiceStub stub) {
    return new OrgPolicyViolationsPreviewServiceClient(stub);
  }

  /**
   * Constructs an instance of OrgPolicyViolationsPreviewServiceClient, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected OrgPolicyViolationsPreviewServiceClient(
      OrgPolicyViolationsPreviewServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub =
        ((OrgPolicyViolationsPreviewServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected OrgPolicyViolationsPreviewServiceClient(OrgPolicyViolationsPreviewServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final OrgPolicyViolationsPreviewServiceSettings getSettings() {
    return settings;
  }

  public OrgPolicyViolationsPreviewServiceStub getStub() {
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
   * ListOrgPolicyViolationsPreviews lists each
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] in an
   * organization. Each
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] is
   * available for at least 7 days.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
   *     OrgPolicyViolationsPreviewServiceClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (OrgPolicyViolationsPreview element :
   *       orgPolicyViolationsPreviewServiceClient
   *           .listOrgPolicyViolationsPreviews(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent the violations are scoped to. Format:
   *     `organizations/{organization}/locations/{location}`
   *     <p>Example: `organizations/my-example-org/locations/global`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOrgPolicyViolationsPreviewsPagedResponse listOrgPolicyViolationsPreviews(
      OrganizationLocationName parent) {
    ListOrgPolicyViolationsPreviewsRequest request =
        ListOrgPolicyViolationsPreviewsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listOrgPolicyViolationsPreviews(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ListOrgPolicyViolationsPreviews lists each
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] in an
   * organization. Each
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] is
   * available for at least 7 days.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
   *     OrgPolicyViolationsPreviewServiceClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (OrgPolicyViolationsPreview element :
   *       orgPolicyViolationsPreviewServiceClient
   *           .listOrgPolicyViolationsPreviews(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent the violations are scoped to. Format:
   *     `organizations/{organization}/locations/{location}`
   *     <p>Example: `organizations/my-example-org/locations/global`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOrgPolicyViolationsPreviewsPagedResponse listOrgPolicyViolationsPreviews(
      String parent) {
    ListOrgPolicyViolationsPreviewsRequest request =
        ListOrgPolicyViolationsPreviewsRequest.newBuilder().setParent(parent).build();
    return listOrgPolicyViolationsPreviews(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ListOrgPolicyViolationsPreviews lists each
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] in an
   * organization. Each
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] is
   * available for at least 7 days.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
   *     OrgPolicyViolationsPreviewServiceClient.create()) {
   *   ListOrgPolicyViolationsPreviewsRequest request =
   *       ListOrgPolicyViolationsPreviewsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (OrgPolicyViolationsPreview element :
   *       orgPolicyViolationsPreviewServiceClient
   *           .listOrgPolicyViolationsPreviews(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOrgPolicyViolationsPreviewsPagedResponse listOrgPolicyViolationsPreviews(
      ListOrgPolicyViolationsPreviewsRequest request) {
    return listOrgPolicyViolationsPreviewsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ListOrgPolicyViolationsPreviews lists each
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] in an
   * organization. Each
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] is
   * available for at least 7 days.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
   *     OrgPolicyViolationsPreviewServiceClient.create()) {
   *   ListOrgPolicyViolationsPreviewsRequest request =
   *       ListOrgPolicyViolationsPreviewsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<OrgPolicyViolationsPreview> future =
   *       orgPolicyViolationsPreviewServiceClient
   *           .listOrgPolicyViolationsPreviewsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (OrgPolicyViolationsPreview element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListOrgPolicyViolationsPreviewsRequest, ListOrgPolicyViolationsPreviewsPagedResponse>
      listOrgPolicyViolationsPreviewsPagedCallable() {
    return stub.listOrgPolicyViolationsPreviewsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ListOrgPolicyViolationsPreviews lists each
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] in an
   * organization. Each
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] is
   * available for at least 7 days.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
   *     OrgPolicyViolationsPreviewServiceClient.create()) {
   *   ListOrgPolicyViolationsPreviewsRequest request =
   *       ListOrgPolicyViolationsPreviewsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListOrgPolicyViolationsPreviewsResponse response =
   *         orgPolicyViolationsPreviewServiceClient
   *             .listOrgPolicyViolationsPreviewsCallable()
   *             .call(request);
   *     for (OrgPolicyViolationsPreview element : response.getOrgPolicyViolationsPreviewsList()) {
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
          ListOrgPolicyViolationsPreviewsRequest, ListOrgPolicyViolationsPreviewsResponse>
      listOrgPolicyViolationsPreviewsCallable() {
    return stub.listOrgPolicyViolationsPreviewsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * GetOrgPolicyViolationsPreview gets the specified
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]. Each
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] is
   * available for at least 7 days.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
   *     OrgPolicyViolationsPreviewServiceClient.create()) {
   *   OrgPolicyViolationsPreviewName name =
   *       OrgPolicyViolationsPreviewName.of(
   *           "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]");
   *   OrgPolicyViolationsPreview response =
   *       orgPolicyViolationsPreviewServiceClient.getOrgPolicyViolationsPreview(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the OrgPolicyViolationsPreview to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OrgPolicyViolationsPreview getOrgPolicyViolationsPreview(
      OrgPolicyViolationsPreviewName name) {
    GetOrgPolicyViolationsPreviewRequest request =
        GetOrgPolicyViolationsPreviewRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getOrgPolicyViolationsPreview(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * GetOrgPolicyViolationsPreview gets the specified
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]. Each
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] is
   * available for at least 7 days.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
   *     OrgPolicyViolationsPreviewServiceClient.create()) {
   *   String name =
   *       OrgPolicyViolationsPreviewName.of(
   *               "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]")
   *           .toString();
   *   OrgPolicyViolationsPreview response =
   *       orgPolicyViolationsPreviewServiceClient.getOrgPolicyViolationsPreview(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the OrgPolicyViolationsPreview to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OrgPolicyViolationsPreview getOrgPolicyViolationsPreview(String name) {
    GetOrgPolicyViolationsPreviewRequest request =
        GetOrgPolicyViolationsPreviewRequest.newBuilder().setName(name).build();
    return getOrgPolicyViolationsPreview(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * GetOrgPolicyViolationsPreview gets the specified
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]. Each
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] is
   * available for at least 7 days.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
   *     OrgPolicyViolationsPreviewServiceClient.create()) {
   *   GetOrgPolicyViolationsPreviewRequest request =
   *       GetOrgPolicyViolationsPreviewRequest.newBuilder()
   *           .setName(
   *               OrgPolicyViolationsPreviewName.of(
   *                       "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]")
   *                   .toString())
   *           .build();
   *   OrgPolicyViolationsPreview response =
   *       orgPolicyViolationsPreviewServiceClient.getOrgPolicyViolationsPreview(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OrgPolicyViolationsPreview getOrgPolicyViolationsPreview(
      GetOrgPolicyViolationsPreviewRequest request) {
    return getOrgPolicyViolationsPreviewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * GetOrgPolicyViolationsPreview gets the specified
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]. Each
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] is
   * available for at least 7 days.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
   *     OrgPolicyViolationsPreviewServiceClient.create()) {
   *   GetOrgPolicyViolationsPreviewRequest request =
   *       GetOrgPolicyViolationsPreviewRequest.newBuilder()
   *           .setName(
   *               OrgPolicyViolationsPreviewName.of(
   *                       "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]")
   *                   .toString())
   *           .build();
   *   ApiFuture<OrgPolicyViolationsPreview> future =
   *       orgPolicyViolationsPreviewServiceClient
   *           .getOrgPolicyViolationsPreviewCallable()
   *           .futureCall(request);
   *   // Do something.
   *   OrgPolicyViolationsPreview response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOrgPolicyViolationsPreviewRequest, OrgPolicyViolationsPreview>
      getOrgPolicyViolationsPreviewCallable() {
    return stub.getOrgPolicyViolationsPreviewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * CreateOrgPolicyViolationsPreview creates an
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] for
   * the proposed changes in the provided [OrgPolicyViolationsPreview.OrgPolicyOverlay][]. The
   * changes to OrgPolicy are specified by this `OrgPolicyOverlay`. The resources to scan are
   * inferred from these specified changes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
   *     OrgPolicyViolationsPreviewServiceClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   OrgPolicyViolationsPreview orgPolicyViolationsPreview =
   *       OrgPolicyViolationsPreview.newBuilder().build();
   *   String orgPolicyViolationsPreviewId = "orgPolicyViolationsPreviewId2098912671";
   *   OrgPolicyViolationsPreview response =
   *       orgPolicyViolationsPreviewServiceClient
   *           .createOrgPolicyViolationsPreviewAsync(
   *               parent, orgPolicyViolationsPreview, orgPolicyViolationsPreviewId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The organization under which this
   *     [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
   *     will be created.
   *     <p>Example: `organizations/my-example-org/locations/global`
   * @param orgPolicyViolationsPreview Required. The
   *     [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] to
   *     generate.
   * @param orgPolicyViolationsPreviewId Optional. An optional user-specified ID for the
   *     [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview].
   *     If not provided, a random ID will be generated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          OrgPolicyViolationsPreview, CreateOrgPolicyViolationsPreviewOperationMetadata>
      createOrgPolicyViolationsPreviewAsync(
          OrganizationLocationName parent,
          OrgPolicyViolationsPreview orgPolicyViolationsPreview,
          String orgPolicyViolationsPreviewId) {
    CreateOrgPolicyViolationsPreviewRequest request =
        CreateOrgPolicyViolationsPreviewRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setOrgPolicyViolationsPreview(orgPolicyViolationsPreview)
            .setOrgPolicyViolationsPreviewId(orgPolicyViolationsPreviewId)
            .build();
    return createOrgPolicyViolationsPreviewAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * CreateOrgPolicyViolationsPreview creates an
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] for
   * the proposed changes in the provided [OrgPolicyViolationsPreview.OrgPolicyOverlay][]. The
   * changes to OrgPolicy are specified by this `OrgPolicyOverlay`. The resources to scan are
   * inferred from these specified changes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
   *     OrgPolicyViolationsPreviewServiceClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   OrgPolicyViolationsPreview orgPolicyViolationsPreview =
   *       OrgPolicyViolationsPreview.newBuilder().build();
   *   String orgPolicyViolationsPreviewId = "orgPolicyViolationsPreviewId2098912671";
   *   OrgPolicyViolationsPreview response =
   *       orgPolicyViolationsPreviewServiceClient
   *           .createOrgPolicyViolationsPreviewAsync(
   *               parent, orgPolicyViolationsPreview, orgPolicyViolationsPreviewId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The organization under which this
   *     [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
   *     will be created.
   *     <p>Example: `organizations/my-example-org/locations/global`
   * @param orgPolicyViolationsPreview Required. The
   *     [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] to
   *     generate.
   * @param orgPolicyViolationsPreviewId Optional. An optional user-specified ID for the
   *     [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview].
   *     If not provided, a random ID will be generated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          OrgPolicyViolationsPreview, CreateOrgPolicyViolationsPreviewOperationMetadata>
      createOrgPolicyViolationsPreviewAsync(
          String parent,
          OrgPolicyViolationsPreview orgPolicyViolationsPreview,
          String orgPolicyViolationsPreviewId) {
    CreateOrgPolicyViolationsPreviewRequest request =
        CreateOrgPolicyViolationsPreviewRequest.newBuilder()
            .setParent(parent)
            .setOrgPolicyViolationsPreview(orgPolicyViolationsPreview)
            .setOrgPolicyViolationsPreviewId(orgPolicyViolationsPreviewId)
            .build();
    return createOrgPolicyViolationsPreviewAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * CreateOrgPolicyViolationsPreview creates an
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] for
   * the proposed changes in the provided [OrgPolicyViolationsPreview.OrgPolicyOverlay][]. The
   * changes to OrgPolicy are specified by this `OrgPolicyOverlay`. The resources to scan are
   * inferred from these specified changes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
   *     OrgPolicyViolationsPreviewServiceClient.create()) {
   *   CreateOrgPolicyViolationsPreviewRequest request =
   *       CreateOrgPolicyViolationsPreviewRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setOrgPolicyViolationsPreview(OrgPolicyViolationsPreview.newBuilder().build())
   *           .setOrgPolicyViolationsPreviewId("orgPolicyViolationsPreviewId2098912671")
   *           .build();
   *   OrgPolicyViolationsPreview response =
   *       orgPolicyViolationsPreviewServiceClient
   *           .createOrgPolicyViolationsPreviewAsync(request)
   *           .get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          OrgPolicyViolationsPreview, CreateOrgPolicyViolationsPreviewOperationMetadata>
      createOrgPolicyViolationsPreviewAsync(CreateOrgPolicyViolationsPreviewRequest request) {
    return createOrgPolicyViolationsPreviewOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * CreateOrgPolicyViolationsPreview creates an
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] for
   * the proposed changes in the provided [OrgPolicyViolationsPreview.OrgPolicyOverlay][]. The
   * changes to OrgPolicy are specified by this `OrgPolicyOverlay`. The resources to scan are
   * inferred from these specified changes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
   *     OrgPolicyViolationsPreviewServiceClient.create()) {
   *   CreateOrgPolicyViolationsPreviewRequest request =
   *       CreateOrgPolicyViolationsPreviewRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setOrgPolicyViolationsPreview(OrgPolicyViolationsPreview.newBuilder().build())
   *           .setOrgPolicyViolationsPreviewId("orgPolicyViolationsPreviewId2098912671")
   *           .build();
   *   OperationFuture<OrgPolicyViolationsPreview, CreateOrgPolicyViolationsPreviewOperationMetadata>
   *       future =
   *           orgPolicyViolationsPreviewServiceClient
   *               .createOrgPolicyViolationsPreviewOperationCallable()
   *               .futureCall(request);
   *   // Do something.
   *   OrgPolicyViolationsPreview response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateOrgPolicyViolationsPreviewRequest,
          OrgPolicyViolationsPreview,
          CreateOrgPolicyViolationsPreviewOperationMetadata>
      createOrgPolicyViolationsPreviewOperationCallable() {
    return stub.createOrgPolicyViolationsPreviewOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * CreateOrgPolicyViolationsPreview creates an
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview] for
   * the proposed changes in the provided [OrgPolicyViolationsPreview.OrgPolicyOverlay][]. The
   * changes to OrgPolicy are specified by this `OrgPolicyOverlay`. The resources to scan are
   * inferred from these specified changes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
   *     OrgPolicyViolationsPreviewServiceClient.create()) {
   *   CreateOrgPolicyViolationsPreviewRequest request =
   *       CreateOrgPolicyViolationsPreviewRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setOrgPolicyViolationsPreview(OrgPolicyViolationsPreview.newBuilder().build())
   *           .setOrgPolicyViolationsPreviewId("orgPolicyViolationsPreviewId2098912671")
   *           .build();
   *   ApiFuture<Operation> future =
   *       orgPolicyViolationsPreviewServiceClient
   *           .createOrgPolicyViolationsPreviewCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateOrgPolicyViolationsPreviewRequest, Operation>
      createOrgPolicyViolationsPreviewCallable() {
    return stub.createOrgPolicyViolationsPreviewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ListOrgPolicyViolations lists the [OrgPolicyViolations][] that are present in an
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
   *     OrgPolicyViolationsPreviewServiceClient.create()) {
   *   OrgPolicyViolationsPreviewName parent =
   *       OrgPolicyViolationsPreviewName.of(
   *           "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]");
   *   for (OrgPolicyViolation element :
   *       orgPolicyViolationsPreviewServiceClient.listOrgPolicyViolations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The OrgPolicyViolationsPreview to get OrgPolicyViolations from. Format:
   *     organizations/{organization}/locations/{location}/orgPolicyViolationsPreviews/{orgPolicyViolationsPreview}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOrgPolicyViolationsPagedResponse listOrgPolicyViolations(
      OrgPolicyViolationsPreviewName parent) {
    ListOrgPolicyViolationsRequest request =
        ListOrgPolicyViolationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listOrgPolicyViolations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ListOrgPolicyViolations lists the [OrgPolicyViolations][] that are present in an
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
   *     OrgPolicyViolationsPreviewServiceClient.create()) {
   *   String parent =
   *       OrgPolicyViolationsPreviewName.of(
   *               "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]")
   *           .toString();
   *   for (OrgPolicyViolation element :
   *       orgPolicyViolationsPreviewServiceClient.listOrgPolicyViolations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The OrgPolicyViolationsPreview to get OrgPolicyViolations from. Format:
   *     organizations/{organization}/locations/{location}/orgPolicyViolationsPreviews/{orgPolicyViolationsPreview}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOrgPolicyViolationsPagedResponse listOrgPolicyViolations(String parent) {
    ListOrgPolicyViolationsRequest request =
        ListOrgPolicyViolationsRequest.newBuilder().setParent(parent).build();
    return listOrgPolicyViolations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ListOrgPolicyViolations lists the [OrgPolicyViolations][] that are present in an
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
   *     OrgPolicyViolationsPreviewServiceClient.create()) {
   *   ListOrgPolicyViolationsRequest request =
   *       ListOrgPolicyViolationsRequest.newBuilder()
   *           .setParent(
   *               OrgPolicyViolationsPreviewName.of(
   *                       "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (OrgPolicyViolation element :
   *       orgPolicyViolationsPreviewServiceClient.listOrgPolicyViolations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOrgPolicyViolationsPagedResponse listOrgPolicyViolations(
      ListOrgPolicyViolationsRequest request) {
    return listOrgPolicyViolationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ListOrgPolicyViolations lists the [OrgPolicyViolations][] that are present in an
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
   *     OrgPolicyViolationsPreviewServiceClient.create()) {
   *   ListOrgPolicyViolationsRequest request =
   *       ListOrgPolicyViolationsRequest.newBuilder()
   *           .setParent(
   *               OrgPolicyViolationsPreviewName.of(
   *                       "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<OrgPolicyViolation> future =
   *       orgPolicyViolationsPreviewServiceClient
   *           .listOrgPolicyViolationsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (OrgPolicyViolation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsPagedResponse>
      listOrgPolicyViolationsPagedCallable() {
    return stub.listOrgPolicyViolationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ListOrgPolicyViolations lists the [OrgPolicyViolations][] that are present in an
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrgPolicyViolationsPreviewServiceClient orgPolicyViolationsPreviewServiceClient =
   *     OrgPolicyViolationsPreviewServiceClient.create()) {
   *   ListOrgPolicyViolationsRequest request =
   *       ListOrgPolicyViolationsRequest.newBuilder()
   *           .setParent(
   *               OrgPolicyViolationsPreviewName.of(
   *                       "[ORGANIZATION]", "[LOCATION]", "[ORG_POLICY_VIOLATIONS_PREVIEW]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListOrgPolicyViolationsResponse response =
   *         orgPolicyViolationsPreviewServiceClient.listOrgPolicyViolationsCallable().call(request);
   *     for (OrgPolicyViolation element : response.getOrgPolicyViolationsList()) {
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
  public final UnaryCallable<ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsResponse>
      listOrgPolicyViolationsCallable() {
    return stub.listOrgPolicyViolationsCallable();
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

  public static class ListOrgPolicyViolationsPreviewsPagedResponse
      extends AbstractPagedListResponse<
          ListOrgPolicyViolationsPreviewsRequest,
          ListOrgPolicyViolationsPreviewsResponse,
          OrgPolicyViolationsPreview,
          ListOrgPolicyViolationsPreviewsPage,
          ListOrgPolicyViolationsPreviewsFixedSizeCollection> {

    public static ApiFuture<ListOrgPolicyViolationsPreviewsPagedResponse> createAsync(
        PageContext<
                ListOrgPolicyViolationsPreviewsRequest,
                ListOrgPolicyViolationsPreviewsResponse,
                OrgPolicyViolationsPreview>
            context,
        ApiFuture<ListOrgPolicyViolationsPreviewsResponse> futureResponse) {
      ApiFuture<ListOrgPolicyViolationsPreviewsPage> futurePage =
          ListOrgPolicyViolationsPreviewsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListOrgPolicyViolationsPreviewsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListOrgPolicyViolationsPreviewsPagedResponse(ListOrgPolicyViolationsPreviewsPage page) {
      super(page, ListOrgPolicyViolationsPreviewsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListOrgPolicyViolationsPreviewsPage
      extends AbstractPage<
          ListOrgPolicyViolationsPreviewsRequest,
          ListOrgPolicyViolationsPreviewsResponse,
          OrgPolicyViolationsPreview,
          ListOrgPolicyViolationsPreviewsPage> {

    private ListOrgPolicyViolationsPreviewsPage(
        PageContext<
                ListOrgPolicyViolationsPreviewsRequest,
                ListOrgPolicyViolationsPreviewsResponse,
                OrgPolicyViolationsPreview>
            context,
        ListOrgPolicyViolationsPreviewsResponse response) {
      super(context, response);
    }

    private static ListOrgPolicyViolationsPreviewsPage createEmptyPage() {
      return new ListOrgPolicyViolationsPreviewsPage(null, null);
    }

    @Override
    protected ListOrgPolicyViolationsPreviewsPage createPage(
        PageContext<
                ListOrgPolicyViolationsPreviewsRequest,
                ListOrgPolicyViolationsPreviewsResponse,
                OrgPolicyViolationsPreview>
            context,
        ListOrgPolicyViolationsPreviewsResponse response) {
      return new ListOrgPolicyViolationsPreviewsPage(context, response);
    }

    @Override
    public ApiFuture<ListOrgPolicyViolationsPreviewsPage> createPageAsync(
        PageContext<
                ListOrgPolicyViolationsPreviewsRequest,
                ListOrgPolicyViolationsPreviewsResponse,
                OrgPolicyViolationsPreview>
            context,
        ApiFuture<ListOrgPolicyViolationsPreviewsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListOrgPolicyViolationsPreviewsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListOrgPolicyViolationsPreviewsRequest,
          ListOrgPolicyViolationsPreviewsResponse,
          OrgPolicyViolationsPreview,
          ListOrgPolicyViolationsPreviewsPage,
          ListOrgPolicyViolationsPreviewsFixedSizeCollection> {

    private ListOrgPolicyViolationsPreviewsFixedSizeCollection(
        List<ListOrgPolicyViolationsPreviewsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListOrgPolicyViolationsPreviewsFixedSizeCollection createEmptyCollection() {
      return new ListOrgPolicyViolationsPreviewsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListOrgPolicyViolationsPreviewsFixedSizeCollection createCollection(
        List<ListOrgPolicyViolationsPreviewsPage> pages, int collectionSize) {
      return new ListOrgPolicyViolationsPreviewsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListOrgPolicyViolationsPagedResponse
      extends AbstractPagedListResponse<
          ListOrgPolicyViolationsRequest,
          ListOrgPolicyViolationsResponse,
          OrgPolicyViolation,
          ListOrgPolicyViolationsPage,
          ListOrgPolicyViolationsFixedSizeCollection> {

    public static ApiFuture<ListOrgPolicyViolationsPagedResponse> createAsync(
        PageContext<
                ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsResponse, OrgPolicyViolation>
            context,
        ApiFuture<ListOrgPolicyViolationsResponse> futureResponse) {
      ApiFuture<ListOrgPolicyViolationsPage> futurePage =
          ListOrgPolicyViolationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListOrgPolicyViolationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListOrgPolicyViolationsPagedResponse(ListOrgPolicyViolationsPage page) {
      super(page, ListOrgPolicyViolationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListOrgPolicyViolationsPage
      extends AbstractPage<
          ListOrgPolicyViolationsRequest,
          ListOrgPolicyViolationsResponse,
          OrgPolicyViolation,
          ListOrgPolicyViolationsPage> {

    private ListOrgPolicyViolationsPage(
        PageContext<
                ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsResponse, OrgPolicyViolation>
            context,
        ListOrgPolicyViolationsResponse response) {
      super(context, response);
    }

    private static ListOrgPolicyViolationsPage createEmptyPage() {
      return new ListOrgPolicyViolationsPage(null, null);
    }

    @Override
    protected ListOrgPolicyViolationsPage createPage(
        PageContext<
                ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsResponse, OrgPolicyViolation>
            context,
        ListOrgPolicyViolationsResponse response) {
      return new ListOrgPolicyViolationsPage(context, response);
    }

    @Override
    public ApiFuture<ListOrgPolicyViolationsPage> createPageAsync(
        PageContext<
                ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsResponse, OrgPolicyViolation>
            context,
        ApiFuture<ListOrgPolicyViolationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListOrgPolicyViolationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListOrgPolicyViolationsRequest,
          ListOrgPolicyViolationsResponse,
          OrgPolicyViolation,
          ListOrgPolicyViolationsPage,
          ListOrgPolicyViolationsFixedSizeCollection> {

    private ListOrgPolicyViolationsFixedSizeCollection(
        List<ListOrgPolicyViolationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListOrgPolicyViolationsFixedSizeCollection createEmptyCollection() {
      return new ListOrgPolicyViolationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListOrgPolicyViolationsFixedSizeCollection createCollection(
        List<ListOrgPolicyViolationsPage> pages, int collectionSize) {
      return new ListOrgPolicyViolationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
