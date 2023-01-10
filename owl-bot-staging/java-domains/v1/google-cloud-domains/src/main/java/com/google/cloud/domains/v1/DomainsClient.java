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

package com.google.cloud.domains.v1;

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
import com.google.cloud.domains.v1.stub.DomainsStub;
import com.google.cloud.domains.v1.stub.DomainsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.type.Money;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Cloud Domains API enables management and configuration of domain names.
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
 * try (DomainsClient domainsClient = DomainsClient.create()) {
 *   LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
 *   String query = "query107944136";
 *   SearchDomainsResponse response = domainsClient.searchDomains(location, query);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DomainsClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of DomainsSettings to create().
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
 * DomainsSettings domainsSettings =
 *     DomainsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DomainsClient domainsClient = DomainsClient.create(domainsSettings);
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
 * DomainsSettings domainsSettings = DomainsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DomainsClient domainsClient = DomainsClient.create(domainsSettings);
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
 * DomainsSettings domainsSettings = DomainsSettings.newHttpJsonBuilder().build();
 * DomainsClient domainsClient = DomainsClient.create(domainsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DomainsClient implements BackgroundResource {
  private final DomainsSettings settings;
  private final DomainsStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of DomainsClient with default settings. */
  public static final DomainsClient create() throws IOException {
    return create(DomainsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DomainsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DomainsClient create(DomainsSettings settings) throws IOException {
    return new DomainsClient(settings);
  }

  /**
   * Constructs an instance of DomainsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(DomainsSettings).
   */
  public static final DomainsClient create(DomainsStub stub) {
    return new DomainsClient(stub);
  }

  /**
   * Constructs an instance of DomainsClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected DomainsClient(DomainsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DomainsStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected DomainsClient(DomainsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final DomainsSettings getSettings() {
    return settings;
  }

  public DomainsStub getStub() {
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
   * Searches for available domain names similar to the provided query.
   *
   * <p>Availability results from this method are approximate; call `RetrieveRegisterParameters` on
   * a domain before registering to confirm availability.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String query = "query107944136";
   *   SearchDomainsResponse response = domainsClient.searchDomains(location, query);
   * }
   * }</pre>
   *
   * @param location Required. The location. Must be in the format `projects/&#42;/locations/&#42;`.
   * @param query Required. String used to search for available domain names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchDomainsResponse searchDomains(LocationName location, String query) {
    SearchDomainsRequest request =
        SearchDomainsRequest.newBuilder()
            .setLocation(location == null ? null : location.toString())
            .setQuery(query)
            .build();
    return searchDomains(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for available domain names similar to the provided query.
   *
   * <p>Availability results from this method are approximate; call `RetrieveRegisterParameters` on
   * a domain before registering to confirm availability.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   String location = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String query = "query107944136";
   *   SearchDomainsResponse response = domainsClient.searchDomains(location, query);
   * }
   * }</pre>
   *
   * @param location Required. The location. Must be in the format `projects/&#42;/locations/&#42;`.
   * @param query Required. String used to search for available domain names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchDomainsResponse searchDomains(String location, String query) {
    SearchDomainsRequest request =
        SearchDomainsRequest.newBuilder().setLocation(location).setQuery(query).build();
    return searchDomains(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for available domain names similar to the provided query.
   *
   * <p>Availability results from this method are approximate; call `RetrieveRegisterParameters` on
   * a domain before registering to confirm availability.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   SearchDomainsRequest request =
   *       SearchDomainsRequest.newBuilder()
   *           .setQuery("query107944136")
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   SearchDomainsResponse response = domainsClient.searchDomains(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchDomainsResponse searchDomains(SearchDomainsRequest request) {
    return searchDomainsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for available domain names similar to the provided query.
   *
   * <p>Availability results from this method are approximate; call `RetrieveRegisterParameters` on
   * a domain before registering to confirm availability.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   SearchDomainsRequest request =
   *       SearchDomainsRequest.newBuilder()
   *           .setQuery("query107944136")
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<SearchDomainsResponse> future =
   *       domainsClient.searchDomainsCallable().futureCall(request);
   *   // Do something.
   *   SearchDomainsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchDomainsRequest, SearchDomainsResponse> searchDomainsCallable() {
    return stub.searchDomainsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets parameters needed to register a new domain name, including price and up-to-date
   * availability. Use the returned values to call `RegisterDomain`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String domainName = "domainName-1244085905";
   *   RetrieveRegisterParametersResponse response =
   *       domainsClient.retrieveRegisterParameters(location, domainName);
   * }
   * }</pre>
   *
   * @param location Required. The location. Must be in the format `projects/&#42;/locations/&#42;`.
   * @param domainName Required. The domain name. Unicode domain names must be expressed in Punycode
   *     format.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetrieveRegisterParametersResponse retrieveRegisterParameters(
      LocationName location, String domainName) {
    RetrieveRegisterParametersRequest request =
        RetrieveRegisterParametersRequest.newBuilder()
            .setLocation(location == null ? null : location.toString())
            .setDomainName(domainName)
            .build();
    return retrieveRegisterParameters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets parameters needed to register a new domain name, including price and up-to-date
   * availability. Use the returned values to call `RegisterDomain`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   String location = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String domainName = "domainName-1244085905";
   *   RetrieveRegisterParametersResponse response =
   *       domainsClient.retrieveRegisterParameters(location, domainName);
   * }
   * }</pre>
   *
   * @param location Required. The location. Must be in the format `projects/&#42;/locations/&#42;`.
   * @param domainName Required. The domain name. Unicode domain names must be expressed in Punycode
   *     format.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetrieveRegisterParametersResponse retrieveRegisterParameters(
      String location, String domainName) {
    RetrieveRegisterParametersRequest request =
        RetrieveRegisterParametersRequest.newBuilder()
            .setLocation(location)
            .setDomainName(domainName)
            .build();
    return retrieveRegisterParameters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets parameters needed to register a new domain name, including price and up-to-date
   * availability. Use the returned values to call `RegisterDomain`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   RetrieveRegisterParametersRequest request =
   *       RetrieveRegisterParametersRequest.newBuilder()
   *           .setDomainName("domainName-1244085905")
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   RetrieveRegisterParametersResponse response =
   *       domainsClient.retrieveRegisterParameters(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetrieveRegisterParametersResponse retrieveRegisterParameters(
      RetrieveRegisterParametersRequest request) {
    return retrieveRegisterParametersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets parameters needed to register a new domain name, including price and up-to-date
   * availability. Use the returned values to call `RegisterDomain`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   RetrieveRegisterParametersRequest request =
   *       RetrieveRegisterParametersRequest.newBuilder()
   *           .setDomainName("domainName-1244085905")
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<RetrieveRegisterParametersResponse> future =
   *       domainsClient.retrieveRegisterParametersCallable().futureCall(request);
   *   // Do something.
   *   RetrieveRegisterParametersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RetrieveRegisterParametersRequest, RetrieveRegisterParametersResponse>
      retrieveRegisterParametersCallable() {
    return stub.retrieveRegisterParametersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers a new domain name and creates a corresponding `Registration` resource.
   *
   * <p>Call `RetrieveRegisterParameters` first to check availability of the domain name and
   * determine parameters like price that are needed to build a call to this method.
   *
   * <p>A successful call creates a `Registration` resource in state `REGISTRATION_PENDING`, which
   * resolves to `ACTIVE` within 1-2 minutes, indicating that the domain was successfully
   * registered. If the resource ends up in state `REGISTRATION_FAILED`, it indicates that the
   * domain was not registered successfully, and you can safely delete the resource and retry
   * registration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Registration registration = Registration.newBuilder().build();
   *   Money yearlyPrice = Money.newBuilder().build();
   *   Registration response =
   *       domainsClient.registerDomainAsync(parent, registration, yearlyPrice).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the `Registration`. Must be in the format
   *     `projects/&#42;/locations/&#42;`.
   * @param registration Required. The complete `Registration` resource to be created.
   * @param yearlyPrice Required. Yearly price to register or renew the domain. The value that
   *     should be put here can be obtained from RetrieveRegisterParameters or SearchDomains calls.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Registration, OperationMetadata> registerDomainAsync(
      LocationName parent, Registration registration, Money yearlyPrice) {
    RegisterDomainRequest request =
        RegisterDomainRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRegistration(registration)
            .setYearlyPrice(yearlyPrice)
            .build();
    return registerDomainAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers a new domain name and creates a corresponding `Registration` resource.
   *
   * <p>Call `RetrieveRegisterParameters` first to check availability of the domain name and
   * determine parameters like price that are needed to build a call to this method.
   *
   * <p>A successful call creates a `Registration` resource in state `REGISTRATION_PENDING`, which
   * resolves to `ACTIVE` within 1-2 minutes, indicating that the domain was successfully
   * registered. If the resource ends up in state `REGISTRATION_FAILED`, it indicates that the
   * domain was not registered successfully, and you can safely delete the resource and retry
   * registration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Registration registration = Registration.newBuilder().build();
   *   Money yearlyPrice = Money.newBuilder().build();
   *   Registration response =
   *       domainsClient.registerDomainAsync(parent, registration, yearlyPrice).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the `Registration`. Must be in the format
   *     `projects/&#42;/locations/&#42;`.
   * @param registration Required. The complete `Registration` resource to be created.
   * @param yearlyPrice Required. Yearly price to register or renew the domain. The value that
   *     should be put here can be obtained from RetrieveRegisterParameters or SearchDomains calls.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Registration, OperationMetadata> registerDomainAsync(
      String parent, Registration registration, Money yearlyPrice) {
    RegisterDomainRequest request =
        RegisterDomainRequest.newBuilder()
            .setParent(parent)
            .setRegistration(registration)
            .setYearlyPrice(yearlyPrice)
            .build();
    return registerDomainAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers a new domain name and creates a corresponding `Registration` resource.
   *
   * <p>Call `RetrieveRegisterParameters` first to check availability of the domain name and
   * determine parameters like price that are needed to build a call to this method.
   *
   * <p>A successful call creates a `Registration` resource in state `REGISTRATION_PENDING`, which
   * resolves to `ACTIVE` within 1-2 minutes, indicating that the domain was successfully
   * registered. If the resource ends up in state `REGISTRATION_FAILED`, it indicates that the
   * domain was not registered successfully, and you can safely delete the resource and retry
   * registration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   RegisterDomainRequest request =
   *       RegisterDomainRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRegistration(Registration.newBuilder().build())
   *           .addAllDomainNotices(new ArrayList<DomainNotice>())
   *           .addAllContactNotices(new ArrayList<ContactNotice>())
   *           .setYearlyPrice(Money.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Registration response = domainsClient.registerDomainAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Registration, OperationMetadata> registerDomainAsync(
      RegisterDomainRequest request) {
    return registerDomainOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers a new domain name and creates a corresponding `Registration` resource.
   *
   * <p>Call `RetrieveRegisterParameters` first to check availability of the domain name and
   * determine parameters like price that are needed to build a call to this method.
   *
   * <p>A successful call creates a `Registration` resource in state `REGISTRATION_PENDING`, which
   * resolves to `ACTIVE` within 1-2 minutes, indicating that the domain was successfully
   * registered. If the resource ends up in state `REGISTRATION_FAILED`, it indicates that the
   * domain was not registered successfully, and you can safely delete the resource and retry
   * registration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   RegisterDomainRequest request =
   *       RegisterDomainRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRegistration(Registration.newBuilder().build())
   *           .addAllDomainNotices(new ArrayList<DomainNotice>())
   *           .addAllContactNotices(new ArrayList<ContactNotice>())
   *           .setYearlyPrice(Money.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Registration, OperationMetadata> future =
   *       domainsClient.registerDomainOperationCallable().futureCall(request);
   *   // Do something.
   *   Registration response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RegisterDomainRequest, Registration, OperationMetadata>
      registerDomainOperationCallable() {
    return stub.registerDomainOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Registers a new domain name and creates a corresponding `Registration` resource.
   *
   * <p>Call `RetrieveRegisterParameters` first to check availability of the domain name and
   * determine parameters like price that are needed to build a call to this method.
   *
   * <p>A successful call creates a `Registration` resource in state `REGISTRATION_PENDING`, which
   * resolves to `ACTIVE` within 1-2 minutes, indicating that the domain was successfully
   * registered. If the resource ends up in state `REGISTRATION_FAILED`, it indicates that the
   * domain was not registered successfully, and you can safely delete the resource and retry
   * registration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   RegisterDomainRequest request =
   *       RegisterDomainRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRegistration(Registration.newBuilder().build())
   *           .addAllDomainNotices(new ArrayList<DomainNotice>())
   *           .addAllContactNotices(new ArrayList<ContactNotice>())
   *           .setYearlyPrice(Money.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = domainsClient.registerDomainCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RegisterDomainRequest, Operation> registerDomainCallable() {
    return stub.registerDomainCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets parameters needed to transfer a domain name from another registrar to Cloud Domains. For
   * domains managed by Google Domains, transferring to Cloud Domains is not supported.
   *
   * <p>Use the returned values to call `TransferDomain`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String domainName = "domainName-1244085905";
   *   RetrieveTransferParametersResponse response =
   *       domainsClient.retrieveTransferParameters(location, domainName);
   * }
   * }</pre>
   *
   * @param location Required. The location. Must be in the format `projects/&#42;/locations/&#42;`.
   * @param domainName Required. The domain name. Unicode domain names must be expressed in Punycode
   *     format.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetrieveTransferParametersResponse retrieveTransferParameters(
      LocationName location, String domainName) {
    RetrieveTransferParametersRequest request =
        RetrieveTransferParametersRequest.newBuilder()
            .setLocation(location == null ? null : location.toString())
            .setDomainName(domainName)
            .build();
    return retrieveTransferParameters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets parameters needed to transfer a domain name from another registrar to Cloud Domains. For
   * domains managed by Google Domains, transferring to Cloud Domains is not supported.
   *
   * <p>Use the returned values to call `TransferDomain`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   String location = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String domainName = "domainName-1244085905";
   *   RetrieveTransferParametersResponse response =
   *       domainsClient.retrieveTransferParameters(location, domainName);
   * }
   * }</pre>
   *
   * @param location Required. The location. Must be in the format `projects/&#42;/locations/&#42;`.
   * @param domainName Required. The domain name. Unicode domain names must be expressed in Punycode
   *     format.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetrieveTransferParametersResponse retrieveTransferParameters(
      String location, String domainName) {
    RetrieveTransferParametersRequest request =
        RetrieveTransferParametersRequest.newBuilder()
            .setLocation(location)
            .setDomainName(domainName)
            .build();
    return retrieveTransferParameters(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets parameters needed to transfer a domain name from another registrar to Cloud Domains. For
   * domains managed by Google Domains, transferring to Cloud Domains is not supported.
   *
   * <p>Use the returned values to call `TransferDomain`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   RetrieveTransferParametersRequest request =
   *       RetrieveTransferParametersRequest.newBuilder()
   *           .setDomainName("domainName-1244085905")
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   RetrieveTransferParametersResponse response =
   *       domainsClient.retrieveTransferParameters(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetrieveTransferParametersResponse retrieveTransferParameters(
      RetrieveTransferParametersRequest request) {
    return retrieveTransferParametersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets parameters needed to transfer a domain name from another registrar to Cloud Domains. For
   * domains managed by Google Domains, transferring to Cloud Domains is not supported.
   *
   * <p>Use the returned values to call `TransferDomain`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   RetrieveTransferParametersRequest request =
   *       RetrieveTransferParametersRequest.newBuilder()
   *           .setDomainName("domainName-1244085905")
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<RetrieveTransferParametersResponse> future =
   *       domainsClient.retrieveTransferParametersCallable().futureCall(request);
   *   // Do something.
   *   RetrieveTransferParametersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RetrieveTransferParametersRequest, RetrieveTransferParametersResponse>
      retrieveTransferParametersCallable() {
    return stub.retrieveTransferParametersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Transfers a domain name from another registrar to Cloud Domains. For domains managed by Google
   * Domains, transferring to Cloud Domains is not supported.
   *
   * <p>Before calling this method, go to the domain's current registrar to unlock the domain for
   * transfer and retrieve the domain's transfer authorization code. Then call
   * `RetrieveTransferParameters` to confirm that the domain is unlocked and to get values needed to
   * build a call to this method.
   *
   * <p>A successful call creates a `Registration` resource in state `TRANSFER_PENDING`. It can take
   * several days to complete the transfer process. The registrant can often speed up this process
   * by approving the transfer through the current registrar, either by clicking a link in an email
   * from the registrar or by visiting the registrar's website.
   *
   * <p>A few minutes after transfer approval, the resource transitions to state `ACTIVE`,
   * indicating that the transfer was successful. If the transfer is rejected or the request expires
   * without being approved, the resource can end up in state `TRANSFER_FAILED`. If transfer fails,
   * you can safely delete the resource and retry the transfer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Registration registration = Registration.newBuilder().build();
   *   Money yearlyPrice = Money.newBuilder().build();
   *   AuthorizationCode authorizationCode = AuthorizationCode.newBuilder().build();
   *   Registration response =
   *       domainsClient
   *           .transferDomainAsync(parent, registration, yearlyPrice, authorizationCode)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the `Registration`. Must be in the format
   *     `projects/&#42;/locations/&#42;`.
   * @param registration Required. The complete `Registration` resource to be created.
   *     <p>You can leave `registration.dns_settings` unset to import the domain's current DNS
   *     configuration from its current registrar. Use this option only if you are sure that the
   *     domain's current DNS service does not cease upon transfer, as is often the case for DNS
   *     services provided for free by the registrar.
   * @param yearlyPrice Required. Acknowledgement of the price to transfer or renew the domain for
   *     one year. Call `RetrieveTransferParameters` to obtain the price, which you must
   *     acknowledge.
   * @param authorizationCode The domain's transfer authorization code. You can obtain this from the
   *     domain's current registrar.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Registration, OperationMetadata> transferDomainAsync(
      LocationName parent,
      Registration registration,
      Money yearlyPrice,
      AuthorizationCode authorizationCode) {
    TransferDomainRequest request =
        TransferDomainRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRegistration(registration)
            .setYearlyPrice(yearlyPrice)
            .setAuthorizationCode(authorizationCode)
            .build();
    return transferDomainAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Transfers a domain name from another registrar to Cloud Domains. For domains managed by Google
   * Domains, transferring to Cloud Domains is not supported.
   *
   * <p>Before calling this method, go to the domain's current registrar to unlock the domain for
   * transfer and retrieve the domain's transfer authorization code. Then call
   * `RetrieveTransferParameters` to confirm that the domain is unlocked and to get values needed to
   * build a call to this method.
   *
   * <p>A successful call creates a `Registration` resource in state `TRANSFER_PENDING`. It can take
   * several days to complete the transfer process. The registrant can often speed up this process
   * by approving the transfer through the current registrar, either by clicking a link in an email
   * from the registrar or by visiting the registrar's website.
   *
   * <p>A few minutes after transfer approval, the resource transitions to state `ACTIVE`,
   * indicating that the transfer was successful. If the transfer is rejected or the request expires
   * without being approved, the resource can end up in state `TRANSFER_FAILED`. If transfer fails,
   * you can safely delete the resource and retry the transfer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Registration registration = Registration.newBuilder().build();
   *   Money yearlyPrice = Money.newBuilder().build();
   *   AuthorizationCode authorizationCode = AuthorizationCode.newBuilder().build();
   *   Registration response =
   *       domainsClient
   *           .transferDomainAsync(parent, registration, yearlyPrice, authorizationCode)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the `Registration`. Must be in the format
   *     `projects/&#42;/locations/&#42;`.
   * @param registration Required. The complete `Registration` resource to be created.
   *     <p>You can leave `registration.dns_settings` unset to import the domain's current DNS
   *     configuration from its current registrar. Use this option only if you are sure that the
   *     domain's current DNS service does not cease upon transfer, as is often the case for DNS
   *     services provided for free by the registrar.
   * @param yearlyPrice Required. Acknowledgement of the price to transfer or renew the domain for
   *     one year. Call `RetrieveTransferParameters` to obtain the price, which you must
   *     acknowledge.
   * @param authorizationCode The domain's transfer authorization code. You can obtain this from the
   *     domain's current registrar.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Registration, OperationMetadata> transferDomainAsync(
      String parent,
      Registration registration,
      Money yearlyPrice,
      AuthorizationCode authorizationCode) {
    TransferDomainRequest request =
        TransferDomainRequest.newBuilder()
            .setParent(parent)
            .setRegistration(registration)
            .setYearlyPrice(yearlyPrice)
            .setAuthorizationCode(authorizationCode)
            .build();
    return transferDomainAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Transfers a domain name from another registrar to Cloud Domains. For domains managed by Google
   * Domains, transferring to Cloud Domains is not supported.
   *
   * <p>Before calling this method, go to the domain's current registrar to unlock the domain for
   * transfer and retrieve the domain's transfer authorization code. Then call
   * `RetrieveTransferParameters` to confirm that the domain is unlocked and to get values needed to
   * build a call to this method.
   *
   * <p>A successful call creates a `Registration` resource in state `TRANSFER_PENDING`. It can take
   * several days to complete the transfer process. The registrant can often speed up this process
   * by approving the transfer through the current registrar, either by clicking a link in an email
   * from the registrar or by visiting the registrar's website.
   *
   * <p>A few minutes after transfer approval, the resource transitions to state `ACTIVE`,
   * indicating that the transfer was successful. If the transfer is rejected or the request expires
   * without being approved, the resource can end up in state `TRANSFER_FAILED`. If transfer fails,
   * you can safely delete the resource and retry the transfer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   TransferDomainRequest request =
   *       TransferDomainRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRegistration(Registration.newBuilder().build())
   *           .addAllContactNotices(new ArrayList<ContactNotice>())
   *           .setYearlyPrice(Money.newBuilder().build())
   *           .setAuthorizationCode(AuthorizationCode.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Registration response = domainsClient.transferDomainAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Registration, OperationMetadata> transferDomainAsync(
      TransferDomainRequest request) {
    return transferDomainOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Transfers a domain name from another registrar to Cloud Domains. For domains managed by Google
   * Domains, transferring to Cloud Domains is not supported.
   *
   * <p>Before calling this method, go to the domain's current registrar to unlock the domain for
   * transfer and retrieve the domain's transfer authorization code. Then call
   * `RetrieveTransferParameters` to confirm that the domain is unlocked and to get values needed to
   * build a call to this method.
   *
   * <p>A successful call creates a `Registration` resource in state `TRANSFER_PENDING`. It can take
   * several days to complete the transfer process. The registrant can often speed up this process
   * by approving the transfer through the current registrar, either by clicking a link in an email
   * from the registrar or by visiting the registrar's website.
   *
   * <p>A few minutes after transfer approval, the resource transitions to state `ACTIVE`,
   * indicating that the transfer was successful. If the transfer is rejected or the request expires
   * without being approved, the resource can end up in state `TRANSFER_FAILED`. If transfer fails,
   * you can safely delete the resource and retry the transfer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   TransferDomainRequest request =
   *       TransferDomainRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRegistration(Registration.newBuilder().build())
   *           .addAllContactNotices(new ArrayList<ContactNotice>())
   *           .setYearlyPrice(Money.newBuilder().build())
   *           .setAuthorizationCode(AuthorizationCode.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Registration, OperationMetadata> future =
   *       domainsClient.transferDomainOperationCallable().futureCall(request);
   *   // Do something.
   *   Registration response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<TransferDomainRequest, Registration, OperationMetadata>
      transferDomainOperationCallable() {
    return stub.transferDomainOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Transfers a domain name from another registrar to Cloud Domains. For domains managed by Google
   * Domains, transferring to Cloud Domains is not supported.
   *
   * <p>Before calling this method, go to the domain's current registrar to unlock the domain for
   * transfer and retrieve the domain's transfer authorization code. Then call
   * `RetrieveTransferParameters` to confirm that the domain is unlocked and to get values needed to
   * build a call to this method.
   *
   * <p>A successful call creates a `Registration` resource in state `TRANSFER_PENDING`. It can take
   * several days to complete the transfer process. The registrant can often speed up this process
   * by approving the transfer through the current registrar, either by clicking a link in an email
   * from the registrar or by visiting the registrar's website.
   *
   * <p>A few minutes after transfer approval, the resource transitions to state `ACTIVE`,
   * indicating that the transfer was successful. If the transfer is rejected or the request expires
   * without being approved, the resource can end up in state `TRANSFER_FAILED`. If transfer fails,
   * you can safely delete the resource and retry the transfer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   TransferDomainRequest request =
   *       TransferDomainRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRegistration(Registration.newBuilder().build())
   *           .addAllContactNotices(new ArrayList<ContactNotice>())
   *           .setYearlyPrice(Money.newBuilder().build())
   *           .setAuthorizationCode(AuthorizationCode.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = domainsClient.transferDomainCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TransferDomainRequest, Operation> transferDomainCallable() {
    return stub.transferDomainCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `Registration` resources in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Registration element : domainsClient.listRegistrations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which to list `Registration`s, specified
   *     in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRegistrationsPagedResponse listRegistrations(LocationName parent) {
    ListRegistrationsRequest request =
        ListRegistrationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRegistrations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `Registration` resources in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Registration element : domainsClient.listRegistrations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which to list `Registration`s, specified
   *     in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRegistrationsPagedResponse listRegistrations(String parent) {
    ListRegistrationsRequest request =
        ListRegistrationsRequest.newBuilder().setParent(parent).build();
    return listRegistrations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `Registration` resources in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   ListRegistrationsRequest request =
   *       ListRegistrationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Registration element : domainsClient.listRegistrations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRegistrationsPagedResponse listRegistrations(ListRegistrationsRequest request) {
    return listRegistrationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `Registration` resources in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   ListRegistrationsRequest request =
   *       ListRegistrationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Registration> future =
   *       domainsClient.listRegistrationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Registration element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRegistrationsRequest, ListRegistrationsPagedResponse>
      listRegistrationsPagedCallable() {
    return stub.listRegistrationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the `Registration` resources in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   ListRegistrationsRequest request =
   *       ListRegistrationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListRegistrationsResponse response =
   *         domainsClient.listRegistrationsCallable().call(request);
   *     for (Registration element : response.getRegistrationsList()) {
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
  public final UnaryCallable<ListRegistrationsRequest, ListRegistrationsResponse>
      listRegistrationsCallable() {
    return stub.listRegistrationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a `Registration` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   RegistrationName name = RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]");
   *   Registration response = domainsClient.getRegistration(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the `Registration` to get, in the format
   *     `projects/&#42;/locations/&#42;/registrations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Registration getRegistration(RegistrationName name) {
    GetRegistrationRequest request =
        GetRegistrationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRegistration(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a `Registration` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   String name = RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString();
   *   Registration response = domainsClient.getRegistration(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the `Registration` to get, in the format
   *     `projects/&#42;/locations/&#42;/registrations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Registration getRegistration(String name) {
    GetRegistrationRequest request = GetRegistrationRequest.newBuilder().setName(name).build();
    return getRegistration(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a `Registration` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   GetRegistrationRequest request =
   *       GetRegistrationRequest.newBuilder()
   *           .setName(RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
   *           .build();
   *   Registration response = domainsClient.getRegistration(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Registration getRegistration(GetRegistrationRequest request) {
    return getRegistrationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a `Registration` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   GetRegistrationRequest request =
   *       GetRegistrationRequest.newBuilder()
   *           .setName(RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
   *           .build();
   *   ApiFuture<Registration> future = domainsClient.getRegistrationCallable().futureCall(request);
   *   // Do something.
   *   Registration response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRegistrationRequest, Registration> getRegistrationCallable() {
    return stub.getRegistrationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates select fields of a `Registration` resource, notably `labels`. To update other fields,
   * use the appropriate custom update method:
   *
   * <ul>
   *   <li>To update management settings, see `ConfigureManagementSettings`
   *   <li>To update DNS configuration, see `ConfigureDnsSettings`
   *   <li>To update contact information, see `ConfigureContactSettings`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   Registration registration = Registration.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Registration response = domainsClient.updateRegistrationAsync(registration, updateMask).get();
   * }
   * }</pre>
   *
   * @param registration Fields of the `Registration` to update.
   * @param updateMask Required. The field mask describing which fields to update as a
   *     comma-separated list. For example, if only the labels are being updated, the `update_mask`
   *     is `"labels"`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Registration, OperationMetadata> updateRegistrationAsync(
      Registration registration, FieldMask updateMask) {
    UpdateRegistrationRequest request =
        UpdateRegistrationRequest.newBuilder()
            .setRegistration(registration)
            .setUpdateMask(updateMask)
            .build();
    return updateRegistrationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates select fields of a `Registration` resource, notably `labels`. To update other fields,
   * use the appropriate custom update method:
   *
   * <ul>
   *   <li>To update management settings, see `ConfigureManagementSettings`
   *   <li>To update DNS configuration, see `ConfigureDnsSettings`
   *   <li>To update contact information, see `ConfigureContactSettings`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   UpdateRegistrationRequest request =
   *       UpdateRegistrationRequest.newBuilder()
   *           .setRegistration(Registration.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Registration response = domainsClient.updateRegistrationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Registration, OperationMetadata> updateRegistrationAsync(
      UpdateRegistrationRequest request) {
    return updateRegistrationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates select fields of a `Registration` resource, notably `labels`. To update other fields,
   * use the appropriate custom update method:
   *
   * <ul>
   *   <li>To update management settings, see `ConfigureManagementSettings`
   *   <li>To update DNS configuration, see `ConfigureDnsSettings`
   *   <li>To update contact information, see `ConfigureContactSettings`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   UpdateRegistrationRequest request =
   *       UpdateRegistrationRequest.newBuilder()
   *           .setRegistration(Registration.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Registration, OperationMetadata> future =
   *       domainsClient.updateRegistrationOperationCallable().futureCall(request);
   *   // Do something.
   *   Registration response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateRegistrationRequest, Registration, OperationMetadata>
      updateRegistrationOperationCallable() {
    return stub.updateRegistrationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates select fields of a `Registration` resource, notably `labels`. To update other fields,
   * use the appropriate custom update method:
   *
   * <ul>
   *   <li>To update management settings, see `ConfigureManagementSettings`
   *   <li>To update DNS configuration, see `ConfigureDnsSettings`
   *   <li>To update contact information, see `ConfigureContactSettings`
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   UpdateRegistrationRequest request =
   *       UpdateRegistrationRequest.newBuilder()
   *           .setRegistration(Registration.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = domainsClient.updateRegistrationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRegistrationRequest, Operation> updateRegistrationCallable() {
    return stub.updateRegistrationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Registration`'s management settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   RegistrationName registration =
   *       RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]");
   *   ManagementSettings managementSettings = ManagementSettings.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Registration response =
   *       domainsClient
   *           .configureManagementSettingsAsync(registration, managementSettings, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param registration Required. The name of the `Registration` whose management settings are
   *     being updated, in the format `projects/&#42;/locations/&#42;/registrations/&#42;`.
   * @param managementSettings Fields of the `ManagementSettings` to update.
   * @param updateMask Required. The field mask describing which fields to update as a
   *     comma-separated list. For example, if only the transfer lock is being updated, the
   *     `update_mask` is `"transfer_lock_state"`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Registration, OperationMetadata> configureManagementSettingsAsync(
      RegistrationName registration, ManagementSettings managementSettings, FieldMask updateMask) {
    ConfigureManagementSettingsRequest request =
        ConfigureManagementSettingsRequest.newBuilder()
            .setRegistration(registration == null ? null : registration.toString())
            .setManagementSettings(managementSettings)
            .setUpdateMask(updateMask)
            .build();
    return configureManagementSettingsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Registration`'s management settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   String registration =
   *       RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString();
   *   ManagementSettings managementSettings = ManagementSettings.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Registration response =
   *       domainsClient
   *           .configureManagementSettingsAsync(registration, managementSettings, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param registration Required. The name of the `Registration` whose management settings are
   *     being updated, in the format `projects/&#42;/locations/&#42;/registrations/&#42;`.
   * @param managementSettings Fields of the `ManagementSettings` to update.
   * @param updateMask Required. The field mask describing which fields to update as a
   *     comma-separated list. For example, if only the transfer lock is being updated, the
   *     `update_mask` is `"transfer_lock_state"`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Registration, OperationMetadata> configureManagementSettingsAsync(
      String registration, ManagementSettings managementSettings, FieldMask updateMask) {
    ConfigureManagementSettingsRequest request =
        ConfigureManagementSettingsRequest.newBuilder()
            .setRegistration(registration)
            .setManagementSettings(managementSettings)
            .setUpdateMask(updateMask)
            .build();
    return configureManagementSettingsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Registration`'s management settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   ConfigureManagementSettingsRequest request =
   *       ConfigureManagementSettingsRequest.newBuilder()
   *           .setRegistration(
   *               RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
   *           .setManagementSettings(ManagementSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Registration response = domainsClient.configureManagementSettingsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Registration, OperationMetadata> configureManagementSettingsAsync(
      ConfigureManagementSettingsRequest request) {
    return configureManagementSettingsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Registration`'s management settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   ConfigureManagementSettingsRequest request =
   *       ConfigureManagementSettingsRequest.newBuilder()
   *           .setRegistration(
   *               RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
   *           .setManagementSettings(ManagementSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Registration, OperationMetadata> future =
   *       domainsClient.configureManagementSettingsOperationCallable().futureCall(request);
   *   // Do something.
   *   Registration response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ConfigureManagementSettingsRequest, Registration, OperationMetadata>
      configureManagementSettingsOperationCallable() {
    return stub.configureManagementSettingsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Registration`'s management settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   ConfigureManagementSettingsRequest request =
   *       ConfigureManagementSettingsRequest.newBuilder()
   *           .setRegistration(
   *               RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
   *           .setManagementSettings(ManagementSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       domainsClient.configureManagementSettingsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ConfigureManagementSettingsRequest, Operation>
      configureManagementSettingsCallable() {
    return stub.configureManagementSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Registration`'s DNS settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   RegistrationName registration =
   *       RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]");
   *   DnsSettings dnsSettings = DnsSettings.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Registration response =
   *       domainsClient.configureDnsSettingsAsync(registration, dnsSettings, updateMask).get();
   * }
   * }</pre>
   *
   * @param registration Required. The name of the `Registration` whose DNS settings are being
   *     updated, in the format `projects/&#42;/locations/&#42;/registrations/&#42;`.
   * @param dnsSettings Fields of the `DnsSettings` to update.
   * @param updateMask Required. The field mask describing which fields to update as a
   *     comma-separated list. For example, if only the name servers are being updated for an
   *     existing Custom DNS configuration, the `update_mask` is `"custom_dns.name_servers"`.
   *     <p>When changing the DNS provider from one type to another, pass the new provider's field
   *     name as part of the field mask. For example, when changing from a Google Domains DNS
   *     configuration to a Custom DNS configuration, the `update_mask` is `"custom_dns"`. //
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Registration, OperationMetadata> configureDnsSettingsAsync(
      RegistrationName registration, DnsSettings dnsSettings, FieldMask updateMask) {
    ConfigureDnsSettingsRequest request =
        ConfigureDnsSettingsRequest.newBuilder()
            .setRegistration(registration == null ? null : registration.toString())
            .setDnsSettings(dnsSettings)
            .setUpdateMask(updateMask)
            .build();
    return configureDnsSettingsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Registration`'s DNS settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   String registration =
   *       RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString();
   *   DnsSettings dnsSettings = DnsSettings.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Registration response =
   *       domainsClient.configureDnsSettingsAsync(registration, dnsSettings, updateMask).get();
   * }
   * }</pre>
   *
   * @param registration Required. The name of the `Registration` whose DNS settings are being
   *     updated, in the format `projects/&#42;/locations/&#42;/registrations/&#42;`.
   * @param dnsSettings Fields of the `DnsSettings` to update.
   * @param updateMask Required. The field mask describing which fields to update as a
   *     comma-separated list. For example, if only the name servers are being updated for an
   *     existing Custom DNS configuration, the `update_mask` is `"custom_dns.name_servers"`.
   *     <p>When changing the DNS provider from one type to another, pass the new provider's field
   *     name as part of the field mask. For example, when changing from a Google Domains DNS
   *     configuration to a Custom DNS configuration, the `update_mask` is `"custom_dns"`. //
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Registration, OperationMetadata> configureDnsSettingsAsync(
      String registration, DnsSettings dnsSettings, FieldMask updateMask) {
    ConfigureDnsSettingsRequest request =
        ConfigureDnsSettingsRequest.newBuilder()
            .setRegistration(registration)
            .setDnsSettings(dnsSettings)
            .setUpdateMask(updateMask)
            .build();
    return configureDnsSettingsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Registration`'s DNS settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   ConfigureDnsSettingsRequest request =
   *       ConfigureDnsSettingsRequest.newBuilder()
   *           .setRegistration(
   *               RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
   *           .setDnsSettings(DnsSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Registration response = domainsClient.configureDnsSettingsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Registration, OperationMetadata> configureDnsSettingsAsync(
      ConfigureDnsSettingsRequest request) {
    return configureDnsSettingsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Registration`'s DNS settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   ConfigureDnsSettingsRequest request =
   *       ConfigureDnsSettingsRequest.newBuilder()
   *           .setRegistration(
   *               RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
   *           .setDnsSettings(DnsSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Registration, OperationMetadata> future =
   *       domainsClient.configureDnsSettingsOperationCallable().futureCall(request);
   *   // Do something.
   *   Registration response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ConfigureDnsSettingsRequest, Registration, OperationMetadata>
      configureDnsSettingsOperationCallable() {
    return stub.configureDnsSettingsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Registration`'s DNS settings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   ConfigureDnsSettingsRequest request =
   *       ConfigureDnsSettingsRequest.newBuilder()
   *           .setRegistration(
   *               RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
   *           .setDnsSettings(DnsSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       domainsClient.configureDnsSettingsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ConfigureDnsSettingsRequest, Operation>
      configureDnsSettingsCallable() {
    return stub.configureDnsSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Registration`'s contact settings. Some changes require confirmation by the domain's
   * registrant contact .
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   RegistrationName registration =
   *       RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]");
   *   ContactSettings contactSettings = ContactSettings.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Registration response =
   *       domainsClient
   *           .configureContactSettingsAsync(registration, contactSettings, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param registration Required. The name of the `Registration` whose contact settings are being
   *     updated, in the format `projects/&#42;/locations/&#42;/registrations/&#42;`.
   * @param contactSettings Fields of the `ContactSettings` to update.
   * @param updateMask Required. The field mask describing which fields to update as a
   *     comma-separated list. For example, if only the registrant contact is being updated, the
   *     `update_mask` is `"registrant_contact"`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Registration, OperationMetadata> configureContactSettingsAsync(
      RegistrationName registration, ContactSettings contactSettings, FieldMask updateMask) {
    ConfigureContactSettingsRequest request =
        ConfigureContactSettingsRequest.newBuilder()
            .setRegistration(registration == null ? null : registration.toString())
            .setContactSettings(contactSettings)
            .setUpdateMask(updateMask)
            .build();
    return configureContactSettingsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Registration`'s contact settings. Some changes require confirmation by the domain's
   * registrant contact .
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   String registration =
   *       RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString();
   *   ContactSettings contactSettings = ContactSettings.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Registration response =
   *       domainsClient
   *           .configureContactSettingsAsync(registration, contactSettings, updateMask)
   *           .get();
   * }
   * }</pre>
   *
   * @param registration Required. The name of the `Registration` whose contact settings are being
   *     updated, in the format `projects/&#42;/locations/&#42;/registrations/&#42;`.
   * @param contactSettings Fields of the `ContactSettings` to update.
   * @param updateMask Required. The field mask describing which fields to update as a
   *     comma-separated list. For example, if only the registrant contact is being updated, the
   *     `update_mask` is `"registrant_contact"`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Registration, OperationMetadata> configureContactSettingsAsync(
      String registration, ContactSettings contactSettings, FieldMask updateMask) {
    ConfigureContactSettingsRequest request =
        ConfigureContactSettingsRequest.newBuilder()
            .setRegistration(registration)
            .setContactSettings(contactSettings)
            .setUpdateMask(updateMask)
            .build();
    return configureContactSettingsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Registration`'s contact settings. Some changes require confirmation by the domain's
   * registrant contact .
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   ConfigureContactSettingsRequest request =
   *       ConfigureContactSettingsRequest.newBuilder()
   *           .setRegistration(
   *               RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
   *           .setContactSettings(ContactSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .addAllContactNotices(new ArrayList<ContactNotice>())
   *           .setValidateOnly(true)
   *           .build();
   *   Registration response = domainsClient.configureContactSettingsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Registration, OperationMetadata> configureContactSettingsAsync(
      ConfigureContactSettingsRequest request) {
    return configureContactSettingsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Registration`'s contact settings. Some changes require confirmation by the domain's
   * registrant contact .
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   ConfigureContactSettingsRequest request =
   *       ConfigureContactSettingsRequest.newBuilder()
   *           .setRegistration(
   *               RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
   *           .setContactSettings(ContactSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .addAllContactNotices(new ArrayList<ContactNotice>())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Registration, OperationMetadata> future =
   *       domainsClient.configureContactSettingsOperationCallable().futureCall(request);
   *   // Do something.
   *   Registration response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ConfigureContactSettingsRequest, Registration, OperationMetadata>
      configureContactSettingsOperationCallable() {
    return stub.configureContactSettingsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Registration`'s contact settings. Some changes require confirmation by the domain's
   * registrant contact .
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   ConfigureContactSettingsRequest request =
   *       ConfigureContactSettingsRequest.newBuilder()
   *           .setRegistration(
   *               RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
   *           .setContactSettings(ContactSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .addAllContactNotices(new ArrayList<ContactNotice>())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       domainsClient.configureContactSettingsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ConfigureContactSettingsRequest, Operation>
      configureContactSettingsCallable() {
    return stub.configureContactSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a `Registration` resource, such that it is no longer managed by Cloud Domains.
   *
   * <p>When an active domain is successfully exported, you can continue to use the domain in
   * [Google Domains](https://domains.google/) until it expires. The calling user becomes the
   * domain's sole owner in Google Domains, and permissions for the domain are subsequently managed
   * there. The domain does not renew automatically unless the new owner sets up billing in Google
   * Domains.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   RegistrationName name = RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]");
   *   Registration response = domainsClient.exportRegistrationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `Registration` to export, in the format
   *     `projects/&#42;/locations/&#42;/registrations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Registration, OperationMetadata> exportRegistrationAsync(
      RegistrationName name) {
    ExportRegistrationRequest request =
        ExportRegistrationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return exportRegistrationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a `Registration` resource, such that it is no longer managed by Cloud Domains.
   *
   * <p>When an active domain is successfully exported, you can continue to use the domain in
   * [Google Domains](https://domains.google/) until it expires. The calling user becomes the
   * domain's sole owner in Google Domains, and permissions for the domain are subsequently managed
   * there. The domain does not renew automatically unless the new owner sets up billing in Google
   * Domains.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   String name = RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString();
   *   Registration response = domainsClient.exportRegistrationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `Registration` to export, in the format
   *     `projects/&#42;/locations/&#42;/registrations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Registration, OperationMetadata> exportRegistrationAsync(
      String name) {
    ExportRegistrationRequest request =
        ExportRegistrationRequest.newBuilder().setName(name).build();
    return exportRegistrationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a `Registration` resource, such that it is no longer managed by Cloud Domains.
   *
   * <p>When an active domain is successfully exported, you can continue to use the domain in
   * [Google Domains](https://domains.google/) until it expires. The calling user becomes the
   * domain's sole owner in Google Domains, and permissions for the domain are subsequently managed
   * there. The domain does not renew automatically unless the new owner sets up billing in Google
   * Domains.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   ExportRegistrationRequest request =
   *       ExportRegistrationRequest.newBuilder()
   *           .setName(RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
   *           .build();
   *   Registration response = domainsClient.exportRegistrationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Registration, OperationMetadata> exportRegistrationAsync(
      ExportRegistrationRequest request) {
    return exportRegistrationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a `Registration` resource, such that it is no longer managed by Cloud Domains.
   *
   * <p>When an active domain is successfully exported, you can continue to use the domain in
   * [Google Domains](https://domains.google/) until it expires. The calling user becomes the
   * domain's sole owner in Google Domains, and permissions for the domain are subsequently managed
   * there. The domain does not renew automatically unless the new owner sets up billing in Google
   * Domains.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   ExportRegistrationRequest request =
   *       ExportRegistrationRequest.newBuilder()
   *           .setName(RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
   *           .build();
   *   OperationFuture<Registration, OperationMetadata> future =
   *       domainsClient.exportRegistrationOperationCallable().futureCall(request);
   *   // Do something.
   *   Registration response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ExportRegistrationRequest, Registration, OperationMetadata>
      exportRegistrationOperationCallable() {
    return stub.exportRegistrationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a `Registration` resource, such that it is no longer managed by Cloud Domains.
   *
   * <p>When an active domain is successfully exported, you can continue to use the domain in
   * [Google Domains](https://domains.google/) until it expires. The calling user becomes the
   * domain's sole owner in Google Domains, and permissions for the domain are subsequently managed
   * there. The domain does not renew automatically unless the new owner sets up billing in Google
   * Domains.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   ExportRegistrationRequest request =
   *       ExportRegistrationRequest.newBuilder()
   *           .setName(RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
   *           .build();
   *   ApiFuture<Operation> future = domainsClient.exportRegistrationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportRegistrationRequest, Operation> exportRegistrationCallable() {
    return stub.exportRegistrationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `Registration` resource.
   *
   * <p>This method works on any `Registration` resource using [Subscription or Commitment
   * billing](/domains/pricing#billing-models), provided that the resource was created at least 1
   * day in the past.
   *
   * <p>For `Registration` resources using [Monthly billing](/domains/pricing#billing-models), this
   * method works if:
   *
   * <ul>
   *   <li>`state` is `EXPORTED` with `expire_time` in the past
   *   <li>`state` is `REGISTRATION_FAILED`
   *   <li>`state` is `TRANSFER_FAILED`
   * </ul>
   *
   * <p>When an active registration is successfully deleted, you can continue to use the domain in
   * [Google Domains](https://domains.google/) until it expires. The calling user becomes the
   * domain's sole owner in Google Domains, and permissions for the domain are subsequently managed
   * there. The domain does not renew automatically unless the new owner sets up billing in Google
   * Domains.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   RegistrationName name = RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]");
   *   domainsClient.deleteRegistrationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `Registration` to delete, in the format
   *     `projects/&#42;/locations/&#42;/registrations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRegistrationAsync(
      RegistrationName name) {
    DeleteRegistrationRequest request =
        DeleteRegistrationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteRegistrationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `Registration` resource.
   *
   * <p>This method works on any `Registration` resource using [Subscription or Commitment
   * billing](/domains/pricing#billing-models), provided that the resource was created at least 1
   * day in the past.
   *
   * <p>For `Registration` resources using [Monthly billing](/domains/pricing#billing-models), this
   * method works if:
   *
   * <ul>
   *   <li>`state` is `EXPORTED` with `expire_time` in the past
   *   <li>`state` is `REGISTRATION_FAILED`
   *   <li>`state` is `TRANSFER_FAILED`
   * </ul>
   *
   * <p>When an active registration is successfully deleted, you can continue to use the domain in
   * [Google Domains](https://domains.google/) until it expires. The calling user becomes the
   * domain's sole owner in Google Domains, and permissions for the domain are subsequently managed
   * there. The domain does not renew automatically unless the new owner sets up billing in Google
   * Domains.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   String name = RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString();
   *   domainsClient.deleteRegistrationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the `Registration` to delete, in the format
   *     `projects/&#42;/locations/&#42;/registrations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRegistrationAsync(String name) {
    DeleteRegistrationRequest request =
        DeleteRegistrationRequest.newBuilder().setName(name).build();
    return deleteRegistrationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `Registration` resource.
   *
   * <p>This method works on any `Registration` resource using [Subscription or Commitment
   * billing](/domains/pricing#billing-models), provided that the resource was created at least 1
   * day in the past.
   *
   * <p>For `Registration` resources using [Monthly billing](/domains/pricing#billing-models), this
   * method works if:
   *
   * <ul>
   *   <li>`state` is `EXPORTED` with `expire_time` in the past
   *   <li>`state` is `REGISTRATION_FAILED`
   *   <li>`state` is `TRANSFER_FAILED`
   * </ul>
   *
   * <p>When an active registration is successfully deleted, you can continue to use the domain in
   * [Google Domains](https://domains.google/) until it expires. The calling user becomes the
   * domain's sole owner in Google Domains, and permissions for the domain are subsequently managed
   * there. The domain does not renew automatically unless the new owner sets up billing in Google
   * Domains.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   DeleteRegistrationRequest request =
   *       DeleteRegistrationRequest.newBuilder()
   *           .setName(RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
   *           .build();
   *   domainsClient.deleteRegistrationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRegistrationAsync(
      DeleteRegistrationRequest request) {
    return deleteRegistrationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `Registration` resource.
   *
   * <p>This method works on any `Registration` resource using [Subscription or Commitment
   * billing](/domains/pricing#billing-models), provided that the resource was created at least 1
   * day in the past.
   *
   * <p>For `Registration` resources using [Monthly billing](/domains/pricing#billing-models), this
   * method works if:
   *
   * <ul>
   *   <li>`state` is `EXPORTED` with `expire_time` in the past
   *   <li>`state` is `REGISTRATION_FAILED`
   *   <li>`state` is `TRANSFER_FAILED`
   * </ul>
   *
   * <p>When an active registration is successfully deleted, you can continue to use the domain in
   * [Google Domains](https://domains.google/) until it expires. The calling user becomes the
   * domain's sole owner in Google Domains, and permissions for the domain are subsequently managed
   * there. The domain does not renew automatically unless the new owner sets up billing in Google
   * Domains.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   DeleteRegistrationRequest request =
   *       DeleteRegistrationRequest.newBuilder()
   *           .setName(RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       domainsClient.deleteRegistrationOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRegistrationRequest, Empty, OperationMetadata>
      deleteRegistrationOperationCallable() {
    return stub.deleteRegistrationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a `Registration` resource.
   *
   * <p>This method works on any `Registration` resource using [Subscription or Commitment
   * billing](/domains/pricing#billing-models), provided that the resource was created at least 1
   * day in the past.
   *
   * <p>For `Registration` resources using [Monthly billing](/domains/pricing#billing-models), this
   * method works if:
   *
   * <ul>
   *   <li>`state` is `EXPORTED` with `expire_time` in the past
   *   <li>`state` is `REGISTRATION_FAILED`
   *   <li>`state` is `TRANSFER_FAILED`
   * </ul>
   *
   * <p>When an active registration is successfully deleted, you can continue to use the domain in
   * [Google Domains](https://domains.google/) until it expires. The calling user becomes the
   * domain's sole owner in Google Domains, and permissions for the domain are subsequently managed
   * there. The domain does not renew automatically unless the new owner sets up billing in Google
   * Domains.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   DeleteRegistrationRequest request =
   *       DeleteRegistrationRequest.newBuilder()
   *           .setName(RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
   *           .build();
   *   ApiFuture<Operation> future = domainsClient.deleteRegistrationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRegistrationRequest, Operation> deleteRegistrationCallable() {
    return stub.deleteRegistrationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the authorization code of the `Registration` for the purpose of transferring the domain to
   * another registrar.
   *
   * <p>You can call this method only after 60 days have elapsed since the initial domain
   * registration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   RegistrationName registration =
   *       RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]");
   *   AuthorizationCode response = domainsClient.retrieveAuthorizationCode(registration);
   * }
   * }</pre>
   *
   * @param registration Required. The name of the `Registration` whose authorization code is being
   *     retrieved, in the format `projects/&#42;/locations/&#42;/registrations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthorizationCode retrieveAuthorizationCode(RegistrationName registration) {
    RetrieveAuthorizationCodeRequest request =
        RetrieveAuthorizationCodeRequest.newBuilder()
            .setRegistration(registration == null ? null : registration.toString())
            .build();
    return retrieveAuthorizationCode(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the authorization code of the `Registration` for the purpose of transferring the domain to
   * another registrar.
   *
   * <p>You can call this method only after 60 days have elapsed since the initial domain
   * registration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   String registration =
   *       RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString();
   *   AuthorizationCode response = domainsClient.retrieveAuthorizationCode(registration);
   * }
   * }</pre>
   *
   * @param registration Required. The name of the `Registration` whose authorization code is being
   *     retrieved, in the format `projects/&#42;/locations/&#42;/registrations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthorizationCode retrieveAuthorizationCode(String registration) {
    RetrieveAuthorizationCodeRequest request =
        RetrieveAuthorizationCodeRequest.newBuilder().setRegistration(registration).build();
    return retrieveAuthorizationCode(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the authorization code of the `Registration` for the purpose of transferring the domain to
   * another registrar.
   *
   * <p>You can call this method only after 60 days have elapsed since the initial domain
   * registration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   RetrieveAuthorizationCodeRequest request =
   *       RetrieveAuthorizationCodeRequest.newBuilder()
   *           .setRegistration(
   *               RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
   *           .build();
   *   AuthorizationCode response = domainsClient.retrieveAuthorizationCode(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthorizationCode retrieveAuthorizationCode(
      RetrieveAuthorizationCodeRequest request) {
    return retrieveAuthorizationCodeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the authorization code of the `Registration` for the purpose of transferring the domain to
   * another registrar.
   *
   * <p>You can call this method only after 60 days have elapsed since the initial domain
   * registration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   RetrieveAuthorizationCodeRequest request =
   *       RetrieveAuthorizationCodeRequest.newBuilder()
   *           .setRegistration(
   *               RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
   *           .build();
   *   ApiFuture<AuthorizationCode> future =
   *       domainsClient.retrieveAuthorizationCodeCallable().futureCall(request);
   *   // Do something.
   *   AuthorizationCode response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RetrieveAuthorizationCodeRequest, AuthorizationCode>
      retrieveAuthorizationCodeCallable() {
    return stub.retrieveAuthorizationCodeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets the authorization code of the `Registration` to a new random string.
   *
   * <p>You can call this method only after 60 days have elapsed since the initial domain
   * registration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   RegistrationName registration =
   *       RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]");
   *   AuthorizationCode response = domainsClient.resetAuthorizationCode(registration);
   * }
   * }</pre>
   *
   * @param registration Required. The name of the `Registration` whose authorization code is being
   *     reset, in the format `projects/&#42;/locations/&#42;/registrations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthorizationCode resetAuthorizationCode(RegistrationName registration) {
    ResetAuthorizationCodeRequest request =
        ResetAuthorizationCodeRequest.newBuilder()
            .setRegistration(registration == null ? null : registration.toString())
            .build();
    return resetAuthorizationCode(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets the authorization code of the `Registration` to a new random string.
   *
   * <p>You can call this method only after 60 days have elapsed since the initial domain
   * registration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   String registration =
   *       RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString();
   *   AuthorizationCode response = domainsClient.resetAuthorizationCode(registration);
   * }
   * }</pre>
   *
   * @param registration Required. The name of the `Registration` whose authorization code is being
   *     reset, in the format `projects/&#42;/locations/&#42;/registrations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthorizationCode resetAuthorizationCode(String registration) {
    ResetAuthorizationCodeRequest request =
        ResetAuthorizationCodeRequest.newBuilder().setRegistration(registration).build();
    return resetAuthorizationCode(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets the authorization code of the `Registration` to a new random string.
   *
   * <p>You can call this method only after 60 days have elapsed since the initial domain
   * registration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   ResetAuthorizationCodeRequest request =
   *       ResetAuthorizationCodeRequest.newBuilder()
   *           .setRegistration(
   *               RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
   *           .build();
   *   AuthorizationCode response = domainsClient.resetAuthorizationCode(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthorizationCode resetAuthorizationCode(ResetAuthorizationCodeRequest request) {
    return resetAuthorizationCodeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resets the authorization code of the `Registration` to a new random string.
   *
   * <p>You can call this method only after 60 days have elapsed since the initial domain
   * registration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainsClient domainsClient = DomainsClient.create()) {
   *   ResetAuthorizationCodeRequest request =
   *       ResetAuthorizationCodeRequest.newBuilder()
   *           .setRegistration(
   *               RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
   *           .build();
   *   ApiFuture<AuthorizationCode> future =
   *       domainsClient.resetAuthorizationCodeCallable().futureCall(request);
   *   // Do something.
   *   AuthorizationCode response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResetAuthorizationCodeRequest, AuthorizationCode>
      resetAuthorizationCodeCallable() {
    return stub.resetAuthorizationCodeCallable();
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

  public static class ListRegistrationsPagedResponse
      extends AbstractPagedListResponse<
          ListRegistrationsRequest,
          ListRegistrationsResponse,
          Registration,
          ListRegistrationsPage,
          ListRegistrationsFixedSizeCollection> {

    public static ApiFuture<ListRegistrationsPagedResponse> createAsync(
        PageContext<ListRegistrationsRequest, ListRegistrationsResponse, Registration> context,
        ApiFuture<ListRegistrationsResponse> futureResponse) {
      ApiFuture<ListRegistrationsPage> futurePage =
          ListRegistrationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRegistrationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRegistrationsPagedResponse(ListRegistrationsPage page) {
      super(page, ListRegistrationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRegistrationsPage
      extends AbstractPage<
          ListRegistrationsRequest,
          ListRegistrationsResponse,
          Registration,
          ListRegistrationsPage> {

    private ListRegistrationsPage(
        PageContext<ListRegistrationsRequest, ListRegistrationsResponse, Registration> context,
        ListRegistrationsResponse response) {
      super(context, response);
    }

    private static ListRegistrationsPage createEmptyPage() {
      return new ListRegistrationsPage(null, null);
    }

    @Override
    protected ListRegistrationsPage createPage(
        PageContext<ListRegistrationsRequest, ListRegistrationsResponse, Registration> context,
        ListRegistrationsResponse response) {
      return new ListRegistrationsPage(context, response);
    }

    @Override
    public ApiFuture<ListRegistrationsPage> createPageAsync(
        PageContext<ListRegistrationsRequest, ListRegistrationsResponse, Registration> context,
        ApiFuture<ListRegistrationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRegistrationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegistrationsRequest,
          ListRegistrationsResponse,
          Registration,
          ListRegistrationsPage,
          ListRegistrationsFixedSizeCollection> {

    private ListRegistrationsFixedSizeCollection(
        List<ListRegistrationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRegistrationsFixedSizeCollection createEmptyCollection() {
      return new ListRegistrationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRegistrationsFixedSizeCollection createCollection(
        List<ListRegistrationsPage> pages, int collectionSize) {
      return new ListRegistrationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
