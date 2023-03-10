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

package com.google.cloud.managedidentities.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.managedidentities.v1.stub.ManagedIdentitiesServiceStub;
import com.google.cloud.managedidentities.v1.stub.ManagedIdentitiesServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: API Overview
 *
 * <p>The `managedidentites.googleapis.com` service implements the Google Cloud Managed Identites
 * API for identity services (e.g. Microsoft Active Directory).
 *
 * <p>The Managed Identities service provides methods to manage (create/read/update/delete) domains,
 * reset managed identities admin password, add/remove domain controllers in GCP regions and
 * add/remove VPC peering.
 *
 * <p>Data Model
 *
 * <p>The Managed Identities service exposes the following resources:
 *
 * <ul>
 *   <li>Locations as global, named as follows: `projects/{project_id}/locations/global`.
 * </ul>
 *
 * <ul>
 *   <li>Domains, named as follows: `/projects/{project_id}/locations/global/domain/{domain_name}`.
 * </ul>
 *
 * <p>The `{domain_name}` refers to fully qualified domain name in the customer project e.g.
 * mydomain.myorganization.com, with the following restrictions:
 *
 * <p>&#42; Must contain only lowercase letters, numbers, periods and hyphens. &#42; Must start with
 * a letter. &#42; Must contain between 2-64 characters. &#42; Must end with a number or a letter.
 * &#42; Must not start with period. &#42; First segement length (mydomain form example above)
 * shouldn't exceed 15 chars. &#42; The last segment cannot be fully numeric. &#42; Must be unique
 * within the customer project.
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
 * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
 *     ManagedIdentitiesServiceClient.create()) {
 *   DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");
 *   ResetAdminPasswordResponse response = managedIdentitiesServiceClient.resetAdminPassword(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ManagedIdentitiesServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of
 * ManagedIdentitiesServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ManagedIdentitiesServiceSettings managedIdentitiesServiceSettings =
 *     ManagedIdentitiesServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
 *     ManagedIdentitiesServiceClient.create(managedIdentitiesServiceSettings);
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
 * ManagedIdentitiesServiceSettings managedIdentitiesServiceSettings =
 *     ManagedIdentitiesServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
 *     ManagedIdentitiesServiceClient.create(managedIdentitiesServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ManagedIdentitiesServiceClient implements BackgroundResource {
  private final ManagedIdentitiesServiceSettings settings;
  private final ManagedIdentitiesServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of ManagedIdentitiesServiceClient with default settings. */
  public static final ManagedIdentitiesServiceClient create() throws IOException {
    return create(ManagedIdentitiesServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ManagedIdentitiesServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final ManagedIdentitiesServiceClient create(
      ManagedIdentitiesServiceSettings settings) throws IOException {
    return new ManagedIdentitiesServiceClient(settings);
  }

  /**
   * Constructs an instance of ManagedIdentitiesServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(ManagedIdentitiesServiceSettings).
   */
  public static final ManagedIdentitiesServiceClient create(ManagedIdentitiesServiceStub stub) {
    return new ManagedIdentitiesServiceClient(stub);
  }

  /**
   * Constructs an instance of ManagedIdentitiesServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ManagedIdentitiesServiceClient(ManagedIdentitiesServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((ManagedIdentitiesServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected ManagedIdentitiesServiceClient(ManagedIdentitiesServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final ManagedIdentitiesServiceSettings getSettings() {
    return settings;
  }

  public ManagedIdentitiesServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Microsoft AD domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String domainName = "domainName-1244085905";
   *   Domain domain = Domain.newBuilder().build();
   *   Domain response =
   *       managedIdentitiesServiceClient
   *           .createMicrosoftAdDomainAsync(parent, domainName, domain)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource project name and location using the form:
   *     `projects/{project_id}/locations/global`
   * @param domainName Required. The fully qualified domain name. e.g. mydomain.myorganization.com,
   *     with the following restrictions:
   *     <p>&#42; Must contain only lowercase letters, numbers, periods and hyphens. &#42; Must
   *     start with a letter. &#42; Must contain between 2-64 characters. &#42; Must end with a
   *     number or a letter. &#42; Must not start with period. &#42; First segement length (mydomain
   *     form example above) shouldn't exceed 15 chars. &#42; The last segment cannot be fully
   *     numeric. &#42; Must be unique within the customer project.
   * @param domain Required. A Managed Identity domain resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Domain, OpMetadata> createMicrosoftAdDomainAsync(
      LocationName parent, String domainName, Domain domain) {
    CreateMicrosoftAdDomainRequest request =
        CreateMicrosoftAdDomainRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDomainName(domainName)
            .setDomain(domain)
            .build();
    return createMicrosoftAdDomainAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Microsoft AD domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String domainName = "domainName-1244085905";
   *   Domain domain = Domain.newBuilder().build();
   *   Domain response =
   *       managedIdentitiesServiceClient
   *           .createMicrosoftAdDomainAsync(parent, domainName, domain)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource project name and location using the form:
   *     `projects/{project_id}/locations/global`
   * @param domainName Required. The fully qualified domain name. e.g. mydomain.myorganization.com,
   *     with the following restrictions:
   *     <p>&#42; Must contain only lowercase letters, numbers, periods and hyphens. &#42; Must
   *     start with a letter. &#42; Must contain between 2-64 characters. &#42; Must end with a
   *     number or a letter. &#42; Must not start with period. &#42; First segement length (mydomain
   *     form example above) shouldn't exceed 15 chars. &#42; The last segment cannot be fully
   *     numeric. &#42; Must be unique within the customer project.
   * @param domain Required. A Managed Identity domain resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Domain, OpMetadata> createMicrosoftAdDomainAsync(
      String parent, String domainName, Domain domain) {
    CreateMicrosoftAdDomainRequest request =
        CreateMicrosoftAdDomainRequest.newBuilder()
            .setParent(parent)
            .setDomainName(domainName)
            .setDomain(domain)
            .build();
    return createMicrosoftAdDomainAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Microsoft AD domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   CreateMicrosoftAdDomainRequest request =
   *       CreateMicrosoftAdDomainRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDomainName("domainName-1244085905")
   *           .setDomain(Domain.newBuilder().build())
   *           .build();
   *   Domain response = managedIdentitiesServiceClient.createMicrosoftAdDomainAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Domain, OpMetadata> createMicrosoftAdDomainAsync(
      CreateMicrosoftAdDomainRequest request) {
    return createMicrosoftAdDomainOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Microsoft AD domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   CreateMicrosoftAdDomainRequest request =
   *       CreateMicrosoftAdDomainRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDomainName("domainName-1244085905")
   *           .setDomain(Domain.newBuilder().build())
   *           .build();
   *   OperationFuture<Domain, OpMetadata> future =
   *       managedIdentitiesServiceClient
   *           .createMicrosoftAdDomainOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Domain response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateMicrosoftAdDomainRequest, Domain, OpMetadata>
      createMicrosoftAdDomainOperationCallable() {
    return stub.createMicrosoftAdDomainOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Microsoft AD domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   CreateMicrosoftAdDomainRequest request =
   *       CreateMicrosoftAdDomainRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDomainName("domainName-1244085905")
   *           .setDomain(Domain.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       managedIdentitiesServiceClient.createMicrosoftAdDomainCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMicrosoftAdDomainRequest, Operation>
      createMicrosoftAdDomainCallable() {
    return stub.createMicrosoftAdDomainCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets a domain's administrator password.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");
   *   ResetAdminPasswordResponse response = managedIdentitiesServiceClient.resetAdminPassword(name);
   * }
   * }</pre>
   *
   * @param name Required. The domain resource name using the form:
   *     `projects/{project_id}/locations/global/domains/{domain_name}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResetAdminPasswordResponse resetAdminPassword(DomainName name) {
    ResetAdminPasswordRequest request =
        ResetAdminPasswordRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return resetAdminPassword(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets a domain's administrator password.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   String name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString();
   *   ResetAdminPasswordResponse response = managedIdentitiesServiceClient.resetAdminPassword(name);
   * }
   * }</pre>
   *
   * @param name Required. The domain resource name using the form:
   *     `projects/{project_id}/locations/global/domains/{domain_name}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResetAdminPasswordResponse resetAdminPassword(String name) {
    ResetAdminPasswordRequest request =
        ResetAdminPasswordRequest.newBuilder().setName(name).build();
    return resetAdminPassword(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets a domain's administrator password.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   ResetAdminPasswordRequest request =
   *       ResetAdminPasswordRequest.newBuilder()
   *           .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
   *           .build();
   *   ResetAdminPasswordResponse response =
   *       managedIdentitiesServiceClient.resetAdminPassword(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResetAdminPasswordResponse resetAdminPassword(ResetAdminPasswordRequest request) {
    return resetAdminPasswordCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets a domain's administrator password.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   ResetAdminPasswordRequest request =
   *       ResetAdminPasswordRequest.newBuilder()
   *           .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
   *           .build();
   *   ApiFuture<ResetAdminPasswordResponse> future =
   *       managedIdentitiesServiceClient.resetAdminPasswordCallable().futureCall(request);
   *   // Do something.
   *   ResetAdminPasswordResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResetAdminPasswordRequest, ResetAdminPasswordResponse>
      resetAdminPasswordCallable() {
    return stub.resetAdminPasswordCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists domains in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Domain element : managedIdentitiesServiceClient.listDomains(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the domain location using the form:
   *     `projects/{project_id}/locations/global`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDomainsPagedResponse listDomains(LocationName parent) {
    ListDomainsRequest request =
        ListDomainsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDomains(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists domains in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Domain element : managedIdentitiesServiceClient.listDomains(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the domain location using the form:
   *     `projects/{project_id}/locations/global`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDomainsPagedResponse listDomains(String parent) {
    ListDomainsRequest request = ListDomainsRequest.newBuilder().setParent(parent).build();
    return listDomains(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists domains in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   ListDomainsRequest request =
   *       ListDomainsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Domain element : managedIdentitiesServiceClient.listDomains(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDomainsPagedResponse listDomains(ListDomainsRequest request) {
    return listDomainsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists domains in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   ListDomainsRequest request =
   *       ListDomainsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Domain> future =
   *       managedIdentitiesServiceClient.listDomainsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Domain element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDomainsRequest, ListDomainsPagedResponse>
      listDomainsPagedCallable() {
    return stub.listDomainsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists domains in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   ListDomainsRequest request =
   *       ListDomainsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDomainsResponse response =
   *         managedIdentitiesServiceClient.listDomainsCallable().call(request);
   *     for (Domain element : response.getDomainsList()) {
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
  public final UnaryCallable<ListDomainsRequest, ListDomainsResponse> listDomainsCallable() {
    return stub.listDomainsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");
   *   Domain response = managedIdentitiesServiceClient.getDomain(name);
   * }
   * }</pre>
   *
   * @param name Required. The domain resource name using the form:
   *     `projects/{project_id}/locations/global/domains/{domain_name}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Domain getDomain(DomainName name) {
    GetDomainRequest request =
        GetDomainRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDomain(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   String name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString();
   *   Domain response = managedIdentitiesServiceClient.getDomain(name);
   * }
   * }</pre>
   *
   * @param name Required. The domain resource name using the form:
   *     `projects/{project_id}/locations/global/domains/{domain_name}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Domain getDomain(String name) {
    GetDomainRequest request = GetDomainRequest.newBuilder().setName(name).build();
    return getDomain(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   GetDomainRequest request =
   *       GetDomainRequest.newBuilder()
   *           .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
   *           .build();
   *   Domain response = managedIdentitiesServiceClient.getDomain(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Domain getDomain(GetDomainRequest request) {
    return getDomainCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   GetDomainRequest request =
   *       GetDomainRequest.newBuilder()
   *           .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
   *           .build();
   *   ApiFuture<Domain> future =
   *       managedIdentitiesServiceClient.getDomainCallable().futureCall(request);
   *   // Do something.
   *   Domain response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDomainRequest, Domain> getDomainCallable() {
    return stub.getDomainCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the metadata and configuration of a domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   Domain domain = Domain.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Domain response = managedIdentitiesServiceClient.updateDomainAsync(domain, updateMask).get();
   * }
   * }</pre>
   *
   * @param domain Required. Domain message with updated fields. Only supported fields specified in
   *     update_mask are updated.
   * @param updateMask Required. Mask of fields to update. At least one path must be supplied in
   *     this field. The elements of the repeated paths field may only include fields from
   *     [Domain][google.cloud.managedidentities.v1.Domain]: &#42; `labels` &#42; `locations` &#42;
   *     `authorized_networks`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Domain, OpMetadata> updateDomainAsync(
      Domain domain, FieldMask updateMask) {
    UpdateDomainRequest request =
        UpdateDomainRequest.newBuilder().setDomain(domain).setUpdateMask(updateMask).build();
    return updateDomainAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the metadata and configuration of a domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   UpdateDomainRequest request =
   *       UpdateDomainRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDomain(Domain.newBuilder().build())
   *           .build();
   *   Domain response = managedIdentitiesServiceClient.updateDomainAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Domain, OpMetadata> updateDomainAsync(UpdateDomainRequest request) {
    return updateDomainOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the metadata and configuration of a domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   UpdateDomainRequest request =
   *       UpdateDomainRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDomain(Domain.newBuilder().build())
   *           .build();
   *   OperationFuture<Domain, OpMetadata> future =
   *       managedIdentitiesServiceClient.updateDomainOperationCallable().futureCall(request);
   *   // Do something.
   *   Domain response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateDomainRequest, Domain, OpMetadata>
      updateDomainOperationCallable() {
    return stub.updateDomainOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the metadata and configuration of a domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   UpdateDomainRequest request =
   *       UpdateDomainRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDomain(Domain.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       managedIdentitiesServiceClient.updateDomainCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDomainRequest, Operation> updateDomainCallable() {
    return stub.updateDomainCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");
   *   managedIdentitiesServiceClient.deleteDomainAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The domain resource name using the form:
   *     `projects/{project_id}/locations/global/domains/{domain_name}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OpMetadata> deleteDomainAsync(DomainName name) {
    DeleteDomainRequest request =
        DeleteDomainRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteDomainAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   String name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString();
   *   managedIdentitiesServiceClient.deleteDomainAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The domain resource name using the form:
   *     `projects/{project_id}/locations/global/domains/{domain_name}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OpMetadata> deleteDomainAsync(String name) {
    DeleteDomainRequest request = DeleteDomainRequest.newBuilder().setName(name).build();
    return deleteDomainAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   DeleteDomainRequest request =
   *       DeleteDomainRequest.newBuilder()
   *           .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
   *           .build();
   *   managedIdentitiesServiceClient.deleteDomainAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OpMetadata> deleteDomainAsync(DeleteDomainRequest request) {
    return deleteDomainOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   DeleteDomainRequest request =
   *       DeleteDomainRequest.newBuilder()
   *           .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
   *           .build();
   *   OperationFuture<Empty, OpMetadata> future =
   *       managedIdentitiesServiceClient.deleteDomainOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDomainRequest, Empty, OpMetadata>
      deleteDomainOperationCallable() {
    return stub.deleteDomainOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   DeleteDomainRequest request =
   *       DeleteDomainRequest.newBuilder()
   *           .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       managedIdentitiesServiceClient.deleteDomainCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDomainRequest, Operation> deleteDomainCallable() {
    return stub.deleteDomainCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds an AD trust to a domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");
   *   Trust trust = Trust.newBuilder().build();
   *   Domain response = managedIdentitiesServiceClient.attachTrustAsync(name, trust).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource domain name, project name and location using the form:
   *     `projects/{project_id}/locations/global/domains/{domain_name}`
   * @param trust Required. The domain trust resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Domain, OpMetadata> attachTrustAsync(DomainName name, Trust trust) {
    AttachTrustRequest request =
        AttachTrustRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setTrust(trust)
            .build();
    return attachTrustAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds an AD trust to a domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   String name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString();
   *   Trust trust = Trust.newBuilder().build();
   *   Domain response = managedIdentitiesServiceClient.attachTrustAsync(name, trust).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource domain name, project name and location using the form:
   *     `projects/{project_id}/locations/global/domains/{domain_name}`
   * @param trust Required. The domain trust resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Domain, OpMetadata> attachTrustAsync(String name, Trust trust) {
    AttachTrustRequest request =
        AttachTrustRequest.newBuilder().setName(name).setTrust(trust).build();
    return attachTrustAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds an AD trust to a domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   AttachTrustRequest request =
   *       AttachTrustRequest.newBuilder()
   *           .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
   *           .setTrust(Trust.newBuilder().build())
   *           .build();
   *   Domain response = managedIdentitiesServiceClient.attachTrustAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Domain, OpMetadata> attachTrustAsync(AttachTrustRequest request) {
    return attachTrustOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds an AD trust to a domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   AttachTrustRequest request =
   *       AttachTrustRequest.newBuilder()
   *           .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
   *           .setTrust(Trust.newBuilder().build())
   *           .build();
   *   OperationFuture<Domain, OpMetadata> future =
   *       managedIdentitiesServiceClient.attachTrustOperationCallable().futureCall(request);
   *   // Do something.
   *   Domain response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<AttachTrustRequest, Domain, OpMetadata>
      attachTrustOperationCallable() {
    return stub.attachTrustOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds an AD trust to a domain.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   AttachTrustRequest request =
   *       AttachTrustRequest.newBuilder()
   *           .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
   *           .setTrust(Trust.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       managedIdentitiesServiceClient.attachTrustCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AttachTrustRequest, Operation> attachTrustCallable() {
    return stub.attachTrustCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the DNS conditional forwarder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");
   *   String targetDomainName = "targetDomainName2065239520";
   *   List<String> targetDnsIpAddresses = new ArrayList<>();
   *   Domain response =
   *       managedIdentitiesServiceClient
   *           .reconfigureTrustAsync(name, targetDomainName, targetDnsIpAddresses)
   *           .get();
   * }
   * }</pre>
   *
   * @param name Required. The resource domain name, project name and location using the form:
   *     `projects/{project_id}/locations/global/domains/{domain_name}`
   * @param targetDomainName Required. The fully-qualified target domain name which will be in trust
   *     with current domain.
   * @param targetDnsIpAddresses Required. The target DNS server IP addresses to resolve the remote
   *     domain involved in the trust.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Domain, OpMetadata> reconfigureTrustAsync(
      DomainName name, String targetDomainName, List<String> targetDnsIpAddresses) {
    ReconfigureTrustRequest request =
        ReconfigureTrustRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setTargetDomainName(targetDomainName)
            .addAllTargetDnsIpAddresses(targetDnsIpAddresses)
            .build();
    return reconfigureTrustAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the DNS conditional forwarder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   String name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString();
   *   String targetDomainName = "targetDomainName2065239520";
   *   List<String> targetDnsIpAddresses = new ArrayList<>();
   *   Domain response =
   *       managedIdentitiesServiceClient
   *           .reconfigureTrustAsync(name, targetDomainName, targetDnsIpAddresses)
   *           .get();
   * }
   * }</pre>
   *
   * @param name Required. The resource domain name, project name and location using the form:
   *     `projects/{project_id}/locations/global/domains/{domain_name}`
   * @param targetDomainName Required. The fully-qualified target domain name which will be in trust
   *     with current domain.
   * @param targetDnsIpAddresses Required. The target DNS server IP addresses to resolve the remote
   *     domain involved in the trust.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Domain, OpMetadata> reconfigureTrustAsync(
      String name, String targetDomainName, List<String> targetDnsIpAddresses) {
    ReconfigureTrustRequest request =
        ReconfigureTrustRequest.newBuilder()
            .setName(name)
            .setTargetDomainName(targetDomainName)
            .addAllTargetDnsIpAddresses(targetDnsIpAddresses)
            .build();
    return reconfigureTrustAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the DNS conditional forwarder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   ReconfigureTrustRequest request =
   *       ReconfigureTrustRequest.newBuilder()
   *           .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
   *           .setTargetDomainName("targetDomainName2065239520")
   *           .addAllTargetDnsIpAddresses(new ArrayList<String>())
   *           .build();
   *   Domain response = managedIdentitiesServiceClient.reconfigureTrustAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Domain, OpMetadata> reconfigureTrustAsync(
      ReconfigureTrustRequest request) {
    return reconfigureTrustOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the DNS conditional forwarder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   ReconfigureTrustRequest request =
   *       ReconfigureTrustRequest.newBuilder()
   *           .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
   *           .setTargetDomainName("targetDomainName2065239520")
   *           .addAllTargetDnsIpAddresses(new ArrayList<String>())
   *           .build();
   *   OperationFuture<Domain, OpMetadata> future =
   *       managedIdentitiesServiceClient.reconfigureTrustOperationCallable().futureCall(request);
   *   // Do something.
   *   Domain response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ReconfigureTrustRequest, Domain, OpMetadata>
      reconfigureTrustOperationCallable() {
    return stub.reconfigureTrustOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the DNS conditional forwarder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   ReconfigureTrustRequest request =
   *       ReconfigureTrustRequest.newBuilder()
   *           .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
   *           .setTargetDomainName("targetDomainName2065239520")
   *           .addAllTargetDnsIpAddresses(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       managedIdentitiesServiceClient.reconfigureTrustCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReconfigureTrustRequest, Operation> reconfigureTrustCallable() {
    return stub.reconfigureTrustCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an AD trust.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");
   *   Trust trust = Trust.newBuilder().build();
   *   Domain response = managedIdentitiesServiceClient.detachTrustAsync(name, trust).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource domain name, project name, and location using the form:
   *     `projects/{project_id}/locations/global/domains/{domain_name}`
   * @param trust Required. The domain trust resource to removed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Domain, OpMetadata> detachTrustAsync(DomainName name, Trust trust) {
    DetachTrustRequest request =
        DetachTrustRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setTrust(trust)
            .build();
    return detachTrustAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an AD trust.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   String name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString();
   *   Trust trust = Trust.newBuilder().build();
   *   Domain response = managedIdentitiesServiceClient.detachTrustAsync(name, trust).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource domain name, project name, and location using the form:
   *     `projects/{project_id}/locations/global/domains/{domain_name}`
   * @param trust Required. The domain trust resource to removed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Domain, OpMetadata> detachTrustAsync(String name, Trust trust) {
    DetachTrustRequest request =
        DetachTrustRequest.newBuilder().setName(name).setTrust(trust).build();
    return detachTrustAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an AD trust.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   DetachTrustRequest request =
   *       DetachTrustRequest.newBuilder()
   *           .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
   *           .setTrust(Trust.newBuilder().build())
   *           .build();
   *   Domain response = managedIdentitiesServiceClient.detachTrustAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Domain, OpMetadata> detachTrustAsync(DetachTrustRequest request) {
    return detachTrustOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an AD trust.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   DetachTrustRequest request =
   *       DetachTrustRequest.newBuilder()
   *           .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
   *           .setTrust(Trust.newBuilder().build())
   *           .build();
   *   OperationFuture<Domain, OpMetadata> future =
   *       managedIdentitiesServiceClient.detachTrustOperationCallable().futureCall(request);
   *   // Do something.
   *   Domain response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DetachTrustRequest, Domain, OpMetadata>
      detachTrustOperationCallable() {
    return stub.detachTrustOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes an AD trust.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   DetachTrustRequest request =
   *       DetachTrustRequest.newBuilder()
   *           .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
   *           .setTrust(Trust.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       managedIdentitiesServiceClient.detachTrustCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DetachTrustRequest, Operation> detachTrustCallable() {
    return stub.detachTrustCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Validates a trust state, that the target domain is reachable, and that the target domain is
   * able to accept incoming trust requests.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");
   *   Trust trust = Trust.newBuilder().build();
   *   Domain response = managedIdentitiesServiceClient.validateTrustAsync(name, trust).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource domain name, project name, and location using the form:
   *     `projects/{project_id}/locations/global/domains/{domain_name}`
   * @param trust Required. The domain trust to validate trust state for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Domain, OpMetadata> validateTrustAsync(
      DomainName name, Trust trust) {
    ValidateTrustRequest request =
        ValidateTrustRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setTrust(trust)
            .build();
    return validateTrustAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Validates a trust state, that the target domain is reachable, and that the target domain is
   * able to accept incoming trust requests.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   String name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString();
   *   Trust trust = Trust.newBuilder().build();
   *   Domain response = managedIdentitiesServiceClient.validateTrustAsync(name, trust).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource domain name, project name, and location using the form:
   *     `projects/{project_id}/locations/global/domains/{domain_name}`
   * @param trust Required. The domain trust to validate trust state for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Domain, OpMetadata> validateTrustAsync(String name, Trust trust) {
    ValidateTrustRequest request =
        ValidateTrustRequest.newBuilder().setName(name).setTrust(trust).build();
    return validateTrustAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Validates a trust state, that the target domain is reachable, and that the target domain is
   * able to accept incoming trust requests.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   ValidateTrustRequest request =
   *       ValidateTrustRequest.newBuilder()
   *           .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
   *           .setTrust(Trust.newBuilder().build())
   *           .build();
   *   Domain response = managedIdentitiesServiceClient.validateTrustAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Domain, OpMetadata> validateTrustAsync(
      ValidateTrustRequest request) {
    return validateTrustOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Validates a trust state, that the target domain is reachable, and that the target domain is
   * able to accept incoming trust requests.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   ValidateTrustRequest request =
   *       ValidateTrustRequest.newBuilder()
   *           .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
   *           .setTrust(Trust.newBuilder().build())
   *           .build();
   *   OperationFuture<Domain, OpMetadata> future =
   *       managedIdentitiesServiceClient.validateTrustOperationCallable().futureCall(request);
   *   // Do something.
   *   Domain response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ValidateTrustRequest, Domain, OpMetadata>
      validateTrustOperationCallable() {
    return stub.validateTrustOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Validates a trust state, that the target domain is reachable, and that the target domain is
   * able to accept incoming trust requests.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
   *     ManagedIdentitiesServiceClient.create()) {
   *   ValidateTrustRequest request =
   *       ValidateTrustRequest.newBuilder()
   *           .setName(DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]").toString())
   *           .setTrust(Trust.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       managedIdentitiesServiceClient.validateTrustCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ValidateTrustRequest, Operation> validateTrustCallable() {
    return stub.validateTrustCallable();
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

  public static class ListDomainsPagedResponse
      extends AbstractPagedListResponse<
          ListDomainsRequest,
          ListDomainsResponse,
          Domain,
          ListDomainsPage,
          ListDomainsFixedSizeCollection> {

    public static ApiFuture<ListDomainsPagedResponse> createAsync(
        PageContext<ListDomainsRequest, ListDomainsResponse, Domain> context,
        ApiFuture<ListDomainsResponse> futureResponse) {
      ApiFuture<ListDomainsPage> futurePage =
          ListDomainsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListDomainsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListDomainsPagedResponse(ListDomainsPage page) {
      super(page, ListDomainsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDomainsPage
      extends AbstractPage<ListDomainsRequest, ListDomainsResponse, Domain, ListDomainsPage> {

    private ListDomainsPage(
        PageContext<ListDomainsRequest, ListDomainsResponse, Domain> context,
        ListDomainsResponse response) {
      super(context, response);
    }

    private static ListDomainsPage createEmptyPage() {
      return new ListDomainsPage(null, null);
    }

    @Override
    protected ListDomainsPage createPage(
        PageContext<ListDomainsRequest, ListDomainsResponse, Domain> context,
        ListDomainsResponse response) {
      return new ListDomainsPage(context, response);
    }

    @Override
    public ApiFuture<ListDomainsPage> createPageAsync(
        PageContext<ListDomainsRequest, ListDomainsResponse, Domain> context,
        ApiFuture<ListDomainsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDomainsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDomainsRequest,
          ListDomainsResponse,
          Domain,
          ListDomainsPage,
          ListDomainsFixedSizeCollection> {

    private ListDomainsFixedSizeCollection(List<ListDomainsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDomainsFixedSizeCollection createEmptyCollection() {
      return new ListDomainsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDomainsFixedSizeCollection createCollection(
        List<ListDomainsPage> pages, int collectionSize) {
      return new ListDomainsFixedSizeCollection(pages, collectionSize);
    }
  }
}
