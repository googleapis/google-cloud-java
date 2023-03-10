/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.resourcemanager.v3;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.resourcemanager.v3.stub.OrganizationsStub;
import com.google.cloud.resourcemanager.v3.stub.OrganizationsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Allows users to manage their organization resources.
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
 * try (OrganizationsClient organizationsClient = OrganizationsClient.create()) {
 *   OrganizationName name = OrganizationName.of("[ORGANIZATION]");
 *   Organization response = organizationsClient.getOrganization(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the OrganizationsClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of OrganizationsSettings to
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
 * OrganizationsSettings organizationsSettings =
 *     OrganizationsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * OrganizationsClient organizationsClient = OrganizationsClient.create(organizationsSettings);
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
 * OrganizationsSettings organizationsSettings =
 *     OrganizationsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * OrganizationsClient organizationsClient = OrganizationsClient.create(organizationsSettings);
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
 * OrganizationsSettings organizationsSettings =
 *     OrganizationsSettings.newHttpJsonBuilder().build();
 * OrganizationsClient organizationsClient = OrganizationsClient.create(organizationsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class OrganizationsClient implements BackgroundResource {
  private final OrganizationsSettings settings;
  private final OrganizationsStub stub;

  /** Constructs an instance of OrganizationsClient with default settings. */
  public static final OrganizationsClient create() throws IOException {
    return create(OrganizationsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of OrganizationsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final OrganizationsClient create(OrganizationsSettings settings)
      throws IOException {
    return new OrganizationsClient(settings);
  }

  /**
   * Constructs an instance of OrganizationsClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(OrganizationsSettings).
   */
  public static final OrganizationsClient create(OrganizationsStub stub) {
    return new OrganizationsClient(stub);
  }

  /**
   * Constructs an instance of OrganizationsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected OrganizationsClient(OrganizationsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((OrganizationsStubSettings) settings.getStubSettings()).createStub();
  }

  protected OrganizationsClient(OrganizationsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final OrganizationsSettings getSettings() {
    return settings;
  }

  public OrganizationsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches an organization resource identified by the specified resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationsClient organizationsClient = OrganizationsClient.create()) {
   *   OrganizationName name = OrganizationName.of("[ORGANIZATION]");
   *   Organization response = organizationsClient.getOrganization(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Organization to fetch. This is the
   *     organization's relative path in the API, formatted as "organizations/[organizationId]". For
   *     example, "organizations/1234".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Organization getOrganization(OrganizationName name) {
    GetOrganizationRequest request =
        GetOrganizationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getOrganization(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches an organization resource identified by the specified resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationsClient organizationsClient = OrganizationsClient.create()) {
   *   String name = OrganizationName.of("[ORGANIZATION]").toString();
   *   Organization response = organizationsClient.getOrganization(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Organization to fetch. This is the
   *     organization's relative path in the API, formatted as "organizations/[organizationId]". For
   *     example, "organizations/1234".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Organization getOrganization(String name) {
    GetOrganizationRequest request = GetOrganizationRequest.newBuilder().setName(name).build();
    return getOrganization(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches an organization resource identified by the specified resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationsClient organizationsClient = OrganizationsClient.create()) {
   *   GetOrganizationRequest request =
   *       GetOrganizationRequest.newBuilder()
   *           .setName(OrganizationName.of("[ORGANIZATION]").toString())
   *           .build();
   *   Organization response = organizationsClient.getOrganization(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Organization getOrganization(GetOrganizationRequest request) {
    return getOrganizationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches an organization resource identified by the specified resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationsClient organizationsClient = OrganizationsClient.create()) {
   *   GetOrganizationRequest request =
   *       GetOrganizationRequest.newBuilder()
   *           .setName(OrganizationName.of("[ORGANIZATION]").toString())
   *           .build();
   *   ApiFuture<Organization> future =
   *       organizationsClient.getOrganizationCallable().futureCall(request);
   *   // Do something.
   *   Organization response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOrganizationRequest, Organization> getOrganizationCallable() {
    return stub.getOrganizationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches organization resources that are visible to the user and satisfy the specified filter.
   * This method returns organizations in an unspecified order. New organizations do not necessarily
   * appear at the end of the results, and may take a small amount of time to appear.
   *
   * <p>Search will only return organizations on which the user has the permission
   * `resourcemanager.organizations.get`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationsClient organizationsClient = OrganizationsClient.create()) {
   *   String query = "query107944136";
   *   for (Organization element : organizationsClient.searchOrganizations(query).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param query Optional. An optional query string used to filter the Organizations to return in
   *     the response. Query rules are case-insensitive.
   *     <p>``` | Field | Description |
   *     |------------------|--------------------------------------------| | directoryCustomerId,
   *     owner.directoryCustomerId | Filters by directory customer id. | | domain | Filters by
   *     domain. | ```
   *     <p>Organizations may be queried by `directoryCustomerId` or by `domain`, where the domain
   *     is a G Suite domain, for example:
   *     <ul>
   *       <li>Query `directorycustomerid:123456789` returns Organization resources with
   *           `owner.directory_customer_id` equal to `123456789`.
   *       <li>Query `domain:google.com` returns Organization resources corresponding to the domain
   *           `google.com`.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchOrganizationsPagedResponse searchOrganizations(String query) {
    SearchOrganizationsRequest request =
        SearchOrganizationsRequest.newBuilder().setQuery(query).build();
    return searchOrganizations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches organization resources that are visible to the user and satisfy the specified filter.
   * This method returns organizations in an unspecified order. New organizations do not necessarily
   * appear at the end of the results, and may take a small amount of time to appear.
   *
   * <p>Search will only return organizations on which the user has the permission
   * `resourcemanager.organizations.get`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationsClient organizationsClient = OrganizationsClient.create()) {
   *   SearchOrganizationsRequest request =
   *       SearchOrganizationsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setQuery("query107944136")
   *           .build();
   *   for (Organization element : organizationsClient.searchOrganizations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchOrganizationsPagedResponse searchOrganizations(
      SearchOrganizationsRequest request) {
    return searchOrganizationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches organization resources that are visible to the user and satisfy the specified filter.
   * This method returns organizations in an unspecified order. New organizations do not necessarily
   * appear at the end of the results, and may take a small amount of time to appear.
   *
   * <p>Search will only return organizations on which the user has the permission
   * `resourcemanager.organizations.get`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationsClient organizationsClient = OrganizationsClient.create()) {
   *   SearchOrganizationsRequest request =
   *       SearchOrganizationsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setQuery("query107944136")
   *           .build();
   *   ApiFuture<Organization> future =
   *       organizationsClient.searchOrganizationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Organization element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchOrganizationsRequest, SearchOrganizationsPagedResponse>
      searchOrganizationsPagedCallable() {
    return stub.searchOrganizationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches organization resources that are visible to the user and satisfy the specified filter.
   * This method returns organizations in an unspecified order. New organizations do not necessarily
   * appear at the end of the results, and may take a small amount of time to appear.
   *
   * <p>Search will only return organizations on which the user has the permission
   * `resourcemanager.organizations.get`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationsClient organizationsClient = OrganizationsClient.create()) {
   *   SearchOrganizationsRequest request =
   *       SearchOrganizationsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setQuery("query107944136")
   *           .build();
   *   while (true) {
   *     SearchOrganizationsResponse response =
   *         organizationsClient.searchOrganizationsCallable().call(request);
   *     for (Organization element : response.getOrganizationsList()) {
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
  public final UnaryCallable<SearchOrganizationsRequest, SearchOrganizationsResponse>
      searchOrganizationsCallable() {
    return stub.searchOrganizationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for an organization resource. The policy may be empty if no such
   * policy or resource exists. The `resource` field should be the organization's resource name, for
   * example: "organizations/123".
   *
   * <p>Authorization requires the IAM permission `resourcemanager.organizations.getIamPolicy` on
   * the specified organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationsClient organizationsClient = OrganizationsClient.create()) {
   *   ResourceName resource = OrganizationName.of("[ORGANIZATION]");
   *   Policy response = organizationsClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(ResourceName resource) {
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for an organization resource. The policy may be empty if no such
   * policy or resource exists. The `resource` field should be the organization's resource name, for
   * example: "organizations/123".
   *
   * <p>Authorization requires the IAM permission `resourcemanager.organizations.getIamPolicy` on
   * the specified organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationsClient organizationsClient = OrganizationsClient.create()) {
   *   String resource = FolderName.of("[FOLDER]").toString();
   *   Policy response = organizationsClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for an organization resource. The policy may be empty if no such
   * policy or resource exists. The `resource` field should be the organization's resource name, for
   * example: "organizations/123".
   *
   * <p>Authorization requires the IAM permission `resourcemanager.organizations.getIamPolicy` on
   * the specified organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationsClient organizationsClient = OrganizationsClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = organizationsClient.getIamPolicy(request);
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
   * Gets the access control policy for an organization resource. The policy may be empty if no such
   * policy or resource exists. The `resource` field should be the organization's resource name, for
   * example: "organizations/123".
   *
   * <p>Authorization requires the IAM permission `resourcemanager.organizations.getIamPolicy` on
   * the specified organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationsClient organizationsClient = OrganizationsClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = organizationsClient.getIamPolicyCallable().futureCall(request);
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
   * Sets the access control policy on an organization resource. Replaces any existing policy. The
   * `resource` field should be the organization's resource name, for example: "organizations/123".
   *
   * <p>Authorization requires the IAM permission `resourcemanager.organizations.setIamPolicy` on
   * the specified organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationsClient organizationsClient = OrganizationsClient.create()) {
   *   ResourceName resource = OrganizationName.of("[ORGANIZATION]");
   *   Policy response = organizationsClient.setIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(ResourceName resource) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on an organization resource. Replaces any existing policy. The
   * `resource` field should be the organization's resource name, for example: "organizations/123".
   *
   * <p>Authorization requires the IAM permission `resourcemanager.organizations.setIamPolicy` on
   * the specified organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationsClient organizationsClient = OrganizationsClient.create()) {
   *   String resource = FolderName.of("[FOLDER]").toString();
   *   Policy response = organizationsClient.setIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource) {
    SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder().setResource(resource).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on an organization resource. Replaces any existing policy. The
   * `resource` field should be the organization's resource name, for example: "organizations/123".
   *
   * <p>Authorization requires the IAM permission `resourcemanager.organizations.setIamPolicy` on
   * the specified organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationsClient organizationsClient = OrganizationsClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = organizationsClient.setIamPolicy(request);
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
   * Sets the access control policy on an organization resource. Replaces any existing policy. The
   * `resource` field should be the organization's resource name, for example: "organizations/123".
   *
   * <p>Authorization requires the IAM permission `resourcemanager.organizations.setIamPolicy` on
   * the specified organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationsClient organizationsClient = OrganizationsClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(OrganizationName.of("[ORGANIZATION]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = organizationsClient.setIamPolicyCallable().futureCall(request);
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
   * Returns the permissions that a caller has on the specified organization. The `resource` field
   * should be the organization's resource name, for example: "organizations/123".
   *
   * <p>There are no permissions required for making this API call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationsClient organizationsClient = OrganizationsClient.create()) {
   *   ResourceName resource = OrganizationName.of("[ORGANIZATION]");
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response =
   *       organizationsClient.testIamPermissions(resource, permissions);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      ResourceName resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the permissions that a caller has on the specified organization. The `resource` field
   * should be the organization's resource name, for example: "organizations/123".
   *
   * <p>There are no permissions required for making this API call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationsClient organizationsClient = OrganizationsClient.create()) {
   *   String resource = FolderName.of("[FOLDER]").toString();
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response =
   *       organizationsClient.testIamPermissions(resource, permissions);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      String resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the permissions that a caller has on the specified organization. The `resource` field
   * should be the organization's resource name, for example: "organizations/123".
   *
   * <p>There are no permissions required for making this API call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationsClient organizationsClient = OrganizationsClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(OrganizationName.of("[ORGANIZATION]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = organizationsClient.testIamPermissions(request);
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
   * Returns the permissions that a caller has on the specified organization. The `resource` field
   * should be the organization's resource name, for example: "organizations/123".
   *
   * <p>There are no permissions required for making this API call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (OrganizationsClient organizationsClient = OrganizationsClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(OrganizationName.of("[ORGANIZATION]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       organizationsClient.testIamPermissionsCallable().futureCall(request);
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

  public static class SearchOrganizationsPagedResponse
      extends AbstractPagedListResponse<
          SearchOrganizationsRequest,
          SearchOrganizationsResponse,
          Organization,
          SearchOrganizationsPage,
          SearchOrganizationsFixedSizeCollection> {

    public static ApiFuture<SearchOrganizationsPagedResponse> createAsync(
        PageContext<SearchOrganizationsRequest, SearchOrganizationsResponse, Organization> context,
        ApiFuture<SearchOrganizationsResponse> futureResponse) {
      ApiFuture<SearchOrganizationsPage> futurePage =
          SearchOrganizationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchOrganizationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchOrganizationsPagedResponse(SearchOrganizationsPage page) {
      super(page, SearchOrganizationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchOrganizationsPage
      extends AbstractPage<
          SearchOrganizationsRequest,
          SearchOrganizationsResponse,
          Organization,
          SearchOrganizationsPage> {

    private SearchOrganizationsPage(
        PageContext<SearchOrganizationsRequest, SearchOrganizationsResponse, Organization> context,
        SearchOrganizationsResponse response) {
      super(context, response);
    }

    private static SearchOrganizationsPage createEmptyPage() {
      return new SearchOrganizationsPage(null, null);
    }

    @Override
    protected SearchOrganizationsPage createPage(
        PageContext<SearchOrganizationsRequest, SearchOrganizationsResponse, Organization> context,
        SearchOrganizationsResponse response) {
      return new SearchOrganizationsPage(context, response);
    }

    @Override
    public ApiFuture<SearchOrganizationsPage> createPageAsync(
        PageContext<SearchOrganizationsRequest, SearchOrganizationsResponse, Organization> context,
        ApiFuture<SearchOrganizationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchOrganizationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchOrganizationsRequest,
          SearchOrganizationsResponse,
          Organization,
          SearchOrganizationsPage,
          SearchOrganizationsFixedSizeCollection> {

    private SearchOrganizationsFixedSizeCollection(
        List<SearchOrganizationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchOrganizationsFixedSizeCollection createEmptyCollection() {
      return new SearchOrganizationsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchOrganizationsFixedSizeCollection createCollection(
        List<SearchOrganizationsPage> pages, int collectionSize) {
      return new SearchOrganizationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
