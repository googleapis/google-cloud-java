/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.support.v2;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.support.v2.stub.CaseServiceStub;
import com.google.cloud.support.v2.stub.CaseServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service to manage Google Cloud support cases.
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
 * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
 *   CaseName name = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");
 *   Case response = caseServiceClient.getCase(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CaseServiceClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    <tr>
 *      <td>GetCase</td>
 *      <td><p>Retrieve the specified case.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getCase(GetCaseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getCase(CaseName name)
 *           <li>getCase(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getCaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListCases</td>
 *      <td><p>Retrieve all cases under the specified parent.
 *
 *  Note: Listing cases under an Organization returns only the cases directly
 *  parented by that organization. To retrieve all cases under an organization,
 *  including cases parented by projects under that organization, use
 *  `cases.search`.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listCases(ListCasesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listCases(OrganizationName parent)
 *           <li>listCases(ProjectName parent)
 *           <li>listCases(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listCasesPagedCallable()
 *           <li>listCasesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>SearchCases</td>
 *      <td><p>Search cases using the specified query.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>searchCases(SearchCasesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>searchCasesPagedCallable()
 *           <li>searchCasesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateCase</td>
 *      <td><p>Create a new case and associate it with the given Google Cloud Resource.
 *  The case object must have the following fields set: `display_name`,
 *  `description`, `classification`, and `priority`.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createCase(CreateCaseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>createCase(OrganizationName parent, Case case_)
 *           <li>createCase(ProjectName parent, Case case_)
 *           <li>createCase(String parent, Case case_)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createCaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateCase</td>
 *      <td><p>Update the specified case. Only a subset of fields can be updated.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateCase(UpdateCaseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>updateCase(Case case_, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateCaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>EscalateCase</td>
 *      <td><p>Escalate a case. Escalating a case will initiate the Google Cloud Support
 *  escalation management process.
 *
 *  This operation is only available to certain Customer Care tiers. Go to
 *  https://cloud.google.com/support and look for 'Technical support
 *  escalations' in the feature list to find out which tiers are able to
 *  perform escalations.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>escalateCase(EscalateCaseRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>escalateCaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CloseCase</td>
 *      <td><p>Close the specified case.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>closeCase(CloseCaseRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>closeCaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>SearchCaseClassifications</td>
 *      <td><p>Retrieve valid classifications to be used when creating a support case.
 *  The classications are hierarchical, with each classification containing
 *  all levels of the hierarchy, separated by " > ". For example "Technical
 *  Issue > Compute > Compute Engine".</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>searchCaseClassifications(SearchCaseClassificationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>searchCaseClassificationsPagedCallable()
 *           <li>searchCaseClassificationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of CaseServiceSettings to
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
 * CaseServiceSettings caseServiceSettings =
 *     CaseServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CaseServiceClient caseServiceClient = CaseServiceClient.create(caseServiceSettings);
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
 * CaseServiceSettings caseServiceSettings =
 *     CaseServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CaseServiceClient caseServiceClient = CaseServiceClient.create(caseServiceSettings);
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
 * CaseServiceSettings caseServiceSettings = CaseServiceSettings.newHttpJsonBuilder().build();
 * CaseServiceClient caseServiceClient = CaseServiceClient.create(caseServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CaseServiceClient implements BackgroundResource {
  private final CaseServiceSettings settings;
  private final CaseServiceStub stub;

  /** Constructs an instance of CaseServiceClient with default settings. */
  public static final CaseServiceClient create() throws IOException {
    return create(CaseServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CaseServiceClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CaseServiceClient create(CaseServiceSettings settings) throws IOException {
    return new CaseServiceClient(settings);
  }

  /**
   * Constructs an instance of CaseServiceClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(CaseServiceSettings).
   */
  public static final CaseServiceClient create(CaseServiceStub stub) {
    return new CaseServiceClient(stub);
  }

  /**
   * Constructs an instance of CaseServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CaseServiceClient(CaseServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CaseServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected CaseServiceClient(CaseServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CaseServiceSettings getSettings() {
    return settings;
  }

  public CaseServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the specified case.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   CaseName name = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");
   *   Case response = caseServiceClient.getCase(name);
   * }
   * }</pre>
   *
   * @param name Required. The fully qualified name of a case to be retrieved.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Case getCase(CaseName name) {
    GetCaseRequest request =
        GetCaseRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the specified case.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   String name = CaseName.ofOrganizationCaseName("[ORGANIZATION]", "[CASE]").toString();
   *   Case response = caseServiceClient.getCase(name);
   * }
   * }</pre>
   *
   * @param name Required. The fully qualified name of a case to be retrieved.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Case getCase(String name) {
    GetCaseRequest request = GetCaseRequest.newBuilder().setName(name).build();
    return getCase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the specified case.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   GetCaseRequest request =
   *       GetCaseRequest.newBuilder()
   *           .setName(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
   *           .build();
   *   Case response = caseServiceClient.getCase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Case getCase(GetCaseRequest request) {
    return getCaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the specified case.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   GetCaseRequest request =
   *       GetCaseRequest.newBuilder()
   *           .setName(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
   *           .build();
   *   ApiFuture<Case> future = caseServiceClient.getCaseCallable().futureCall(request);
   *   // Do something.
   *   Case response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCaseRequest, Case> getCaseCallable() {
    return stub.getCaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve all cases under the specified parent.
   *
   * <p>Note: Listing cases under an Organization returns only the cases directly parented by that
   * organization. To retrieve all cases under an organization, including cases parented by projects
   * under that organization, use `cases.search`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   for (Case element : caseServiceClient.listCases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The fully qualified name of parent resource to list cases under.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCasesPagedResponse listCases(OrganizationName parent) {
    ListCasesRequest request =
        ListCasesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listCases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve all cases under the specified parent.
   *
   * <p>Note: Listing cases under an Organization returns only the cases directly parented by that
   * organization. To retrieve all cases under an organization, including cases parented by projects
   * under that organization, use `cases.search`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (Case element : caseServiceClient.listCases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The fully qualified name of parent resource to list cases under.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCasesPagedResponse listCases(ProjectName parent) {
    ListCasesRequest request =
        ListCasesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listCases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve all cases under the specified parent.
   *
   * <p>Note: Listing cases under an Organization returns only the cases directly parented by that
   * organization. To retrieve all cases under an organization, including cases parented by projects
   * under that organization, use `cases.search`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   for (Case element : caseServiceClient.listCases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The fully qualified name of parent resource to list cases under.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCasesPagedResponse listCases(String parent) {
    ListCasesRequest request = ListCasesRequest.newBuilder().setParent(parent).build();
    return listCases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve all cases under the specified parent.
   *
   * <p>Note: Listing cases under an Organization returns only the cases directly parented by that
   * organization. To retrieve all cases under an organization, including cases parented by projects
   * under that organization, use `cases.search`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   ListCasesRequest request =
   *       ListCasesRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Case element : caseServiceClient.listCases(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCasesPagedResponse listCases(ListCasesRequest request) {
    return listCasesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve all cases under the specified parent.
   *
   * <p>Note: Listing cases under an Organization returns only the cases directly parented by that
   * organization. To retrieve all cases under an organization, including cases parented by projects
   * under that organization, use `cases.search`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   ListCasesRequest request =
   *       ListCasesRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Case> future = caseServiceClient.listCasesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Case element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCasesRequest, ListCasesPagedResponse> listCasesPagedCallable() {
    return stub.listCasesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve all cases under the specified parent.
   *
   * <p>Note: Listing cases under an Organization returns only the cases directly parented by that
   * organization. To retrieve all cases under an organization, including cases parented by projects
   * under that organization, use `cases.search`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   ListCasesRequest request =
   *       ListCasesRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListCasesResponse response = caseServiceClient.listCasesCallable().call(request);
   *     for (Case element : response.getCasesList()) {
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
  public final UnaryCallable<ListCasesRequest, ListCasesResponse> listCasesCallable() {
    return stub.listCasesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search cases using the specified query.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   SearchCasesRequest request =
   *       SearchCasesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Case element : caseServiceClient.searchCases(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchCasesPagedResponse searchCases(SearchCasesRequest request) {
    return searchCasesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search cases using the specified query.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   SearchCasesRequest request =
   *       SearchCasesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Case> future = caseServiceClient.searchCasesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Case element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchCasesRequest, SearchCasesPagedResponse>
      searchCasesPagedCallable() {
    return stub.searchCasesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search cases using the specified query.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   SearchCasesRequest request =
   *       SearchCasesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchCasesResponse response = caseServiceClient.searchCasesCallable().call(request);
   *     for (Case element : response.getCasesList()) {
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
  public final UnaryCallable<SearchCasesRequest, SearchCasesResponse> searchCasesCallable() {
    return stub.searchCasesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new case and associate it with the given Google Cloud Resource. The case object must
   * have the following fields set: `display_name`, `description`, `classification`, and `priority`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   Case case_ = Case.newBuilder().build();
   *   Case response = caseServiceClient.createCase(parent, case_);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the Google Cloud Resource under which the case should be
   *     created.
   * @param case_ Required. The case to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Case createCase(OrganizationName parent, Case case_) {
    CreateCaseRequest request =
        CreateCaseRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCase(case_)
            .build();
    return createCase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new case and associate it with the given Google Cloud Resource. The case object must
   * have the following fields set: `display_name`, `description`, `classification`, and `priority`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Case case_ = Case.newBuilder().build();
   *   Case response = caseServiceClient.createCase(parent, case_);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the Google Cloud Resource under which the case should be
   *     created.
   * @param case_ Required. The case to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Case createCase(ProjectName parent, Case case_) {
    CreateCaseRequest request =
        CreateCaseRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCase(case_)
            .build();
    return createCase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new case and associate it with the given Google Cloud Resource. The case object must
   * have the following fields set: `display_name`, `description`, `classification`, and `priority`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   String parent = OrganizationName.of("[ORGANIZATION]").toString();
   *   Case case_ = Case.newBuilder().build();
   *   Case response = caseServiceClient.createCase(parent, case_);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the Google Cloud Resource under which the case should be
   *     created.
   * @param case_ Required. The case to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Case createCase(String parent, Case case_) {
    CreateCaseRequest request =
        CreateCaseRequest.newBuilder().setParent(parent).setCase(case_).build();
    return createCase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new case and associate it with the given Google Cloud Resource. The case object must
   * have the following fields set: `display_name`, `description`, `classification`, and `priority`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   CreateCaseRequest request =
   *       CreateCaseRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setCase(Case.newBuilder().build())
   *           .build();
   *   Case response = caseServiceClient.createCase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Case createCase(CreateCaseRequest request) {
    return createCaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new case and associate it with the given Google Cloud Resource. The case object must
   * have the following fields set: `display_name`, `description`, `classification`, and `priority`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   CreateCaseRequest request =
   *       CreateCaseRequest.newBuilder()
   *           .setParent(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setCase(Case.newBuilder().build())
   *           .build();
   *   ApiFuture<Case> future = caseServiceClient.createCaseCallable().futureCall(request);
   *   // Do something.
   *   Case response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCaseRequest, Case> createCaseCallable() {
    return stub.createCaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the specified case. Only a subset of fields can be updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   Case case_ = Case.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Case response = caseServiceClient.updateCase(case_, updateMask);
   * }
   * }</pre>
   *
   * @param case_ Required. The case object to update.
   * @param updateMask A list of attributes of the case object that should be updated as part of
   *     this request. Supported values are `priority`, `display_name`, and
   *     `subscriber_email_addresses`. If no fields are specified, all supported fields are updated.
   *     <p>WARNING: If you do not provide a field mask, then you might accidentally clear some
   *     fields. For example, if you leave the field mask empty and do not provide a value for
   *     `subscriber_email_addresses`, then `subscriber_email_addresses` is updated to empty.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Case updateCase(Case case_, FieldMask updateMask) {
    UpdateCaseRequest request =
        UpdateCaseRequest.newBuilder().setCase(case_).setUpdateMask(updateMask).build();
    return updateCase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the specified case. Only a subset of fields can be updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   UpdateCaseRequest request =
   *       UpdateCaseRequest.newBuilder()
   *           .setCase(Case.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Case response = caseServiceClient.updateCase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Case updateCase(UpdateCaseRequest request) {
    return updateCaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the specified case. Only a subset of fields can be updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   UpdateCaseRequest request =
   *       UpdateCaseRequest.newBuilder()
   *           .setCase(Case.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Case> future = caseServiceClient.updateCaseCallable().futureCall(request);
   *   // Do something.
   *   Case response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCaseRequest, Case> updateCaseCallable() {
    return stub.updateCaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Escalate a case. Escalating a case will initiate the Google Cloud Support escalation management
   * process.
   *
   * <p>This operation is only available to certain Customer Care tiers. Go to
   * https://cloud.google.com/support and look for 'Technical support escalations' in the feature
   * list to find out which tiers are able to perform escalations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   EscalateCaseRequest request =
   *       EscalateCaseRequest.newBuilder()
   *           .setName(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
   *           .setEscalation(Escalation.newBuilder().build())
   *           .build();
   *   Case response = caseServiceClient.escalateCase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Case escalateCase(EscalateCaseRequest request) {
    return escalateCaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Escalate a case. Escalating a case will initiate the Google Cloud Support escalation management
   * process.
   *
   * <p>This operation is only available to certain Customer Care tiers. Go to
   * https://cloud.google.com/support and look for 'Technical support escalations' in the feature
   * list to find out which tiers are able to perform escalations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   EscalateCaseRequest request =
   *       EscalateCaseRequest.newBuilder()
   *           .setName(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
   *           .setEscalation(Escalation.newBuilder().build())
   *           .build();
   *   ApiFuture<Case> future = caseServiceClient.escalateCaseCallable().futureCall(request);
   *   // Do something.
   *   Case response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EscalateCaseRequest, Case> escalateCaseCallable() {
    return stub.escalateCaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Close the specified case.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   CloseCaseRequest request =
   *       CloseCaseRequest.newBuilder()
   *           .setName(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
   *           .build();
   *   Case response = caseServiceClient.closeCase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Case closeCase(CloseCaseRequest request) {
    return closeCaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Close the specified case.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   CloseCaseRequest request =
   *       CloseCaseRequest.newBuilder()
   *           .setName(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
   *           .build();
   *   ApiFuture<Case> future = caseServiceClient.closeCaseCallable().futureCall(request);
   *   // Do something.
   *   Case response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CloseCaseRequest, Case> closeCaseCallable() {
    return stub.closeCaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve valid classifications to be used when creating a support case. The classications are
   * hierarchical, with each classification containing all levels of the hierarchy, separated by "
   * &gt; ". For example "Technical Issue &gt; Compute &gt; Compute Engine".
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   SearchCaseClassificationsRequest request =
   *       SearchCaseClassificationsRequest.newBuilder()
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (CaseClassification element :
   *       caseServiceClient.searchCaseClassifications(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchCaseClassificationsPagedResponse searchCaseClassifications(
      SearchCaseClassificationsRequest request) {
    return searchCaseClassificationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve valid classifications to be used when creating a support case. The classications are
   * hierarchical, with each classification containing all levels of the hierarchy, separated by "
   * &gt; ". For example "Technical Issue &gt; Compute &gt; Compute Engine".
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   SearchCaseClassificationsRequest request =
   *       SearchCaseClassificationsRequest.newBuilder()
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<CaseClassification> future =
   *       caseServiceClient.searchCaseClassificationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CaseClassification element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          SearchCaseClassificationsRequest, SearchCaseClassificationsPagedResponse>
      searchCaseClassificationsPagedCallable() {
    return stub.searchCaseClassificationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve valid classifications to be used when creating a support case. The classications are
   * hierarchical, with each classification containing all levels of the hierarchy, separated by "
   * &gt; ". For example "Technical Issue &gt; Compute &gt; Compute Engine".
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
   *   SearchCaseClassificationsRequest request =
   *       SearchCaseClassificationsRequest.newBuilder()
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchCaseClassificationsResponse response =
   *         caseServiceClient.searchCaseClassificationsCallable().call(request);
   *     for (CaseClassification element : response.getCaseClassificationsList()) {
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
  public final UnaryCallable<SearchCaseClassificationsRequest, SearchCaseClassificationsResponse>
      searchCaseClassificationsCallable() {
    return stub.searchCaseClassificationsCallable();
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

  public static class ListCasesPagedResponse
      extends AbstractPagedListResponse<
          ListCasesRequest, ListCasesResponse, Case, ListCasesPage, ListCasesFixedSizeCollection> {

    public static ApiFuture<ListCasesPagedResponse> createAsync(
        PageContext<ListCasesRequest, ListCasesResponse, Case> context,
        ApiFuture<ListCasesResponse> futureResponse) {
      ApiFuture<ListCasesPage> futurePage =
          ListCasesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListCasesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListCasesPagedResponse(ListCasesPage page) {
      super(page, ListCasesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCasesPage
      extends AbstractPage<ListCasesRequest, ListCasesResponse, Case, ListCasesPage> {

    private ListCasesPage(
        PageContext<ListCasesRequest, ListCasesResponse, Case> context,
        ListCasesResponse response) {
      super(context, response);
    }

    private static ListCasesPage createEmptyPage() {
      return new ListCasesPage(null, null);
    }

    @Override
    protected ListCasesPage createPage(
        PageContext<ListCasesRequest, ListCasesResponse, Case> context,
        ListCasesResponse response) {
      return new ListCasesPage(context, response);
    }

    @Override
    public ApiFuture<ListCasesPage> createPageAsync(
        PageContext<ListCasesRequest, ListCasesResponse, Case> context,
        ApiFuture<ListCasesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCasesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCasesRequest, ListCasesResponse, Case, ListCasesPage, ListCasesFixedSizeCollection> {

    private ListCasesFixedSizeCollection(List<ListCasesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCasesFixedSizeCollection createEmptyCollection() {
      return new ListCasesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCasesFixedSizeCollection createCollection(
        List<ListCasesPage> pages, int collectionSize) {
      return new ListCasesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchCasesPagedResponse
      extends AbstractPagedListResponse<
          SearchCasesRequest,
          SearchCasesResponse,
          Case,
          SearchCasesPage,
          SearchCasesFixedSizeCollection> {

    public static ApiFuture<SearchCasesPagedResponse> createAsync(
        PageContext<SearchCasesRequest, SearchCasesResponse, Case> context,
        ApiFuture<SearchCasesResponse> futureResponse) {
      ApiFuture<SearchCasesPage> futurePage =
          SearchCasesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new SearchCasesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private SearchCasesPagedResponse(SearchCasesPage page) {
      super(page, SearchCasesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchCasesPage
      extends AbstractPage<SearchCasesRequest, SearchCasesResponse, Case, SearchCasesPage> {

    private SearchCasesPage(
        PageContext<SearchCasesRequest, SearchCasesResponse, Case> context,
        SearchCasesResponse response) {
      super(context, response);
    }

    private static SearchCasesPage createEmptyPage() {
      return new SearchCasesPage(null, null);
    }

    @Override
    protected SearchCasesPage createPage(
        PageContext<SearchCasesRequest, SearchCasesResponse, Case> context,
        SearchCasesResponse response) {
      return new SearchCasesPage(context, response);
    }

    @Override
    public ApiFuture<SearchCasesPage> createPageAsync(
        PageContext<SearchCasesRequest, SearchCasesResponse, Case> context,
        ApiFuture<SearchCasesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchCasesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchCasesRequest,
          SearchCasesResponse,
          Case,
          SearchCasesPage,
          SearchCasesFixedSizeCollection> {

    private SearchCasesFixedSizeCollection(List<SearchCasesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchCasesFixedSizeCollection createEmptyCollection() {
      return new SearchCasesFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchCasesFixedSizeCollection createCollection(
        List<SearchCasesPage> pages, int collectionSize) {
      return new SearchCasesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchCaseClassificationsPagedResponse
      extends AbstractPagedListResponse<
          SearchCaseClassificationsRequest,
          SearchCaseClassificationsResponse,
          CaseClassification,
          SearchCaseClassificationsPage,
          SearchCaseClassificationsFixedSizeCollection> {

    public static ApiFuture<SearchCaseClassificationsPagedResponse> createAsync(
        PageContext<
                SearchCaseClassificationsRequest,
                SearchCaseClassificationsResponse,
                CaseClassification>
            context,
        ApiFuture<SearchCaseClassificationsResponse> futureResponse) {
      ApiFuture<SearchCaseClassificationsPage> futurePage =
          SearchCaseClassificationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchCaseClassificationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchCaseClassificationsPagedResponse(SearchCaseClassificationsPage page) {
      super(page, SearchCaseClassificationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchCaseClassificationsPage
      extends AbstractPage<
          SearchCaseClassificationsRequest,
          SearchCaseClassificationsResponse,
          CaseClassification,
          SearchCaseClassificationsPage> {

    private SearchCaseClassificationsPage(
        PageContext<
                SearchCaseClassificationsRequest,
                SearchCaseClassificationsResponse,
                CaseClassification>
            context,
        SearchCaseClassificationsResponse response) {
      super(context, response);
    }

    private static SearchCaseClassificationsPage createEmptyPage() {
      return new SearchCaseClassificationsPage(null, null);
    }

    @Override
    protected SearchCaseClassificationsPage createPage(
        PageContext<
                SearchCaseClassificationsRequest,
                SearchCaseClassificationsResponse,
                CaseClassification>
            context,
        SearchCaseClassificationsResponse response) {
      return new SearchCaseClassificationsPage(context, response);
    }

    @Override
    public ApiFuture<SearchCaseClassificationsPage> createPageAsync(
        PageContext<
                SearchCaseClassificationsRequest,
                SearchCaseClassificationsResponse,
                CaseClassification>
            context,
        ApiFuture<SearchCaseClassificationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchCaseClassificationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchCaseClassificationsRequest,
          SearchCaseClassificationsResponse,
          CaseClassification,
          SearchCaseClassificationsPage,
          SearchCaseClassificationsFixedSizeCollection> {

    private SearchCaseClassificationsFixedSizeCollection(
        List<SearchCaseClassificationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchCaseClassificationsFixedSizeCollection createEmptyCollection() {
      return new SearchCaseClassificationsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchCaseClassificationsFixedSizeCollection createCollection(
        List<SearchCaseClassificationsPage> pages, int collectionSize) {
      return new SearchCaseClassificationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
