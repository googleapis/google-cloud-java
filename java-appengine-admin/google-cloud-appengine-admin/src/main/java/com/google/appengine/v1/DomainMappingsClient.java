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

package com.google.appengine.v1;

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
import com.google.appengine.v1.stub.DomainMappingsStub;
import com.google.appengine.v1.stub.DomainMappingsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Manages domains serving an application.
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
 * try (DomainMappingsClient domainMappingsClient = DomainMappingsClient.create()) {
 *   GetDomainMappingRequest request =
 *       GetDomainMappingRequest.newBuilder().setName("name3373707").build();
 *   DomainMapping response = domainMappingsClient.getDomainMapping(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DomainMappingsClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of DomainMappingsSettings to
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
 * DomainMappingsSettings domainMappingsSettings =
 *     DomainMappingsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DomainMappingsClient domainMappingsClient = DomainMappingsClient.create(domainMappingsSettings);
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
 * DomainMappingsSettings domainMappingsSettings =
 *     DomainMappingsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DomainMappingsClient domainMappingsClient = DomainMappingsClient.create(domainMappingsSettings);
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
 * DomainMappingsSettings domainMappingsSettings =
 *     DomainMappingsSettings.newHttpJsonBuilder().build();
 * DomainMappingsClient domainMappingsClient = DomainMappingsClient.create(domainMappingsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DomainMappingsClient implements BackgroundResource {
  private final DomainMappingsSettings settings;
  private final DomainMappingsStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of DomainMappingsClient with default settings. */
  public static final DomainMappingsClient create() throws IOException {
    return create(DomainMappingsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DomainMappingsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DomainMappingsClient create(DomainMappingsSettings settings)
      throws IOException {
    return new DomainMappingsClient(settings);
  }

  /**
   * Constructs an instance of DomainMappingsClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(DomainMappingsSettings).
   */
  public static final DomainMappingsClient create(DomainMappingsStub stub) {
    return new DomainMappingsClient(stub);
  }

  /**
   * Constructs an instance of DomainMappingsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DomainMappingsClient(DomainMappingsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DomainMappingsStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected DomainMappingsClient(DomainMappingsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final DomainMappingsSettings getSettings() {
    return settings;
  }

  public DomainMappingsStub getStub() {
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
   * Lists the domain mappings on an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainMappingsClient domainMappingsClient = DomainMappingsClient.create()) {
   *   ListDomainMappingsRequest request =
   *       ListDomainMappingsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DomainMapping element : domainMappingsClient.listDomainMappings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDomainMappingsPagedResponse listDomainMappings(
      ListDomainMappingsRequest request) {
    return listDomainMappingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the domain mappings on an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainMappingsClient domainMappingsClient = DomainMappingsClient.create()) {
   *   ListDomainMappingsRequest request =
   *       ListDomainMappingsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DomainMapping> future =
   *       domainMappingsClient.listDomainMappingsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DomainMapping element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDomainMappingsRequest, ListDomainMappingsPagedResponse>
      listDomainMappingsPagedCallable() {
    return stub.listDomainMappingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the domain mappings on an application.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainMappingsClient domainMappingsClient = DomainMappingsClient.create()) {
   *   ListDomainMappingsRequest request =
   *       ListDomainMappingsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDomainMappingsResponse response =
   *         domainMappingsClient.listDomainMappingsCallable().call(request);
   *     for (DomainMapping element : response.getDomainMappingsList()) {
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
  public final UnaryCallable<ListDomainMappingsRequest, ListDomainMappingsResponse>
      listDomainMappingsCallable() {
    return stub.listDomainMappingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified domain mapping.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainMappingsClient domainMappingsClient = DomainMappingsClient.create()) {
   *   GetDomainMappingRequest request =
   *       GetDomainMappingRequest.newBuilder().setName("name3373707").build();
   *   DomainMapping response = domainMappingsClient.getDomainMapping(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DomainMapping getDomainMapping(GetDomainMappingRequest request) {
    return getDomainMappingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified domain mapping.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainMappingsClient domainMappingsClient = DomainMappingsClient.create()) {
   *   GetDomainMappingRequest request =
   *       GetDomainMappingRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<DomainMapping> future =
   *       domainMappingsClient.getDomainMappingCallable().futureCall(request);
   *   // Do something.
   *   DomainMapping response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDomainMappingRequest, DomainMapping> getDomainMappingCallable() {
    return stub.getDomainMappingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Maps a domain to an application. A user must be authorized to administer a domain in order to
   * map it to an application. For a list of available authorized domains, see
   * [`AuthorizedDomains.ListAuthorizedDomains`]().
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainMappingsClient domainMappingsClient = DomainMappingsClient.create()) {
   *   CreateDomainMappingRequest request =
   *       CreateDomainMappingRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setDomainMapping(DomainMapping.newBuilder().build())
   *           .setOverrideStrategy(DomainOverrideStrategy.forNumber(0))
   *           .build();
   *   DomainMapping response = domainMappingsClient.createDomainMappingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DomainMapping, OperationMetadataV1> createDomainMappingAsync(
      CreateDomainMappingRequest request) {
    return createDomainMappingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Maps a domain to an application. A user must be authorized to administer a domain in order to
   * map it to an application. For a list of available authorized domains, see
   * [`AuthorizedDomains.ListAuthorizedDomains`]().
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainMappingsClient domainMappingsClient = DomainMappingsClient.create()) {
   *   CreateDomainMappingRequest request =
   *       CreateDomainMappingRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setDomainMapping(DomainMapping.newBuilder().build())
   *           .setOverrideStrategy(DomainOverrideStrategy.forNumber(0))
   *           .build();
   *   OperationFuture<DomainMapping, OperationMetadataV1> future =
   *       domainMappingsClient.createDomainMappingOperationCallable().futureCall(request);
   *   // Do something.
   *   DomainMapping response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateDomainMappingRequest, DomainMapping, OperationMetadataV1>
      createDomainMappingOperationCallable() {
    return stub.createDomainMappingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Maps a domain to an application. A user must be authorized to administer a domain in order to
   * map it to an application. For a list of available authorized domains, see
   * [`AuthorizedDomains.ListAuthorizedDomains`]().
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainMappingsClient domainMappingsClient = DomainMappingsClient.create()) {
   *   CreateDomainMappingRequest request =
   *       CreateDomainMappingRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setDomainMapping(DomainMapping.newBuilder().build())
   *           .setOverrideStrategy(DomainOverrideStrategy.forNumber(0))
   *           .build();
   *   ApiFuture<Operation> future =
   *       domainMappingsClient.createDomainMappingCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDomainMappingRequest, Operation> createDomainMappingCallable() {
    return stub.createDomainMappingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified domain mapping. To map an SSL certificate to a domain mapping, update
   * `certificate_id` to point to an `AuthorizedCertificate` resource. A user must be authorized to
   * administer the associated domain in order to update a `DomainMapping` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainMappingsClient domainMappingsClient = DomainMappingsClient.create()) {
   *   UpdateDomainMappingRequest request =
   *       UpdateDomainMappingRequest.newBuilder()
   *           .setName("name3373707")
   *           .setDomainMapping(DomainMapping.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   DomainMapping response = domainMappingsClient.updateDomainMappingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DomainMapping, OperationMetadataV1> updateDomainMappingAsync(
      UpdateDomainMappingRequest request) {
    return updateDomainMappingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified domain mapping. To map an SSL certificate to a domain mapping, update
   * `certificate_id` to point to an `AuthorizedCertificate` resource. A user must be authorized to
   * administer the associated domain in order to update a `DomainMapping` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainMappingsClient domainMappingsClient = DomainMappingsClient.create()) {
   *   UpdateDomainMappingRequest request =
   *       UpdateDomainMappingRequest.newBuilder()
   *           .setName("name3373707")
   *           .setDomainMapping(DomainMapping.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<DomainMapping, OperationMetadataV1> future =
   *       domainMappingsClient.updateDomainMappingOperationCallable().futureCall(request);
   *   // Do something.
   *   DomainMapping response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateDomainMappingRequest, DomainMapping, OperationMetadataV1>
      updateDomainMappingOperationCallable() {
    return stub.updateDomainMappingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified domain mapping. To map an SSL certificate to a domain mapping, update
   * `certificate_id` to point to an `AuthorizedCertificate` resource. A user must be authorized to
   * administer the associated domain in order to update a `DomainMapping` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainMappingsClient domainMappingsClient = DomainMappingsClient.create()) {
   *   UpdateDomainMappingRequest request =
   *       UpdateDomainMappingRequest.newBuilder()
   *           .setName("name3373707")
   *           .setDomainMapping(DomainMapping.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       domainMappingsClient.updateDomainMappingCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDomainMappingRequest, Operation> updateDomainMappingCallable() {
    return stub.updateDomainMappingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified domain mapping. A user must be authorized to administer the associated
   * domain in order to delete a `DomainMapping` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainMappingsClient domainMappingsClient = DomainMappingsClient.create()) {
   *   DeleteDomainMappingRequest request =
   *       DeleteDomainMappingRequest.newBuilder().setName("name3373707").build();
   *   domainMappingsClient.deleteDomainMappingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadataV1> deleteDomainMappingAsync(
      DeleteDomainMappingRequest request) {
    return deleteDomainMappingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified domain mapping. A user must be authorized to administer the associated
   * domain in order to delete a `DomainMapping` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainMappingsClient domainMappingsClient = DomainMappingsClient.create()) {
   *   DeleteDomainMappingRequest request =
   *       DeleteDomainMappingRequest.newBuilder().setName("name3373707").build();
   *   OperationFuture<Empty, OperationMetadataV1> future =
   *       domainMappingsClient.deleteDomainMappingOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDomainMappingRequest, Empty, OperationMetadataV1>
      deleteDomainMappingOperationCallable() {
    return stub.deleteDomainMappingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified domain mapping. A user must be authorized to administer the associated
   * domain in order to delete a `DomainMapping` resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DomainMappingsClient domainMappingsClient = DomainMappingsClient.create()) {
   *   DeleteDomainMappingRequest request =
   *       DeleteDomainMappingRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Operation> future =
   *       domainMappingsClient.deleteDomainMappingCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDomainMappingRequest, Operation> deleteDomainMappingCallable() {
    return stub.deleteDomainMappingCallable();
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

  public static class ListDomainMappingsPagedResponse
      extends AbstractPagedListResponse<
          ListDomainMappingsRequest,
          ListDomainMappingsResponse,
          DomainMapping,
          ListDomainMappingsPage,
          ListDomainMappingsFixedSizeCollection> {

    public static ApiFuture<ListDomainMappingsPagedResponse> createAsync(
        PageContext<ListDomainMappingsRequest, ListDomainMappingsResponse, DomainMapping> context,
        ApiFuture<ListDomainMappingsResponse> futureResponse) {
      ApiFuture<ListDomainMappingsPage> futurePage =
          ListDomainMappingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDomainMappingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDomainMappingsPagedResponse(ListDomainMappingsPage page) {
      super(page, ListDomainMappingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDomainMappingsPage
      extends AbstractPage<
          ListDomainMappingsRequest,
          ListDomainMappingsResponse,
          DomainMapping,
          ListDomainMappingsPage> {

    private ListDomainMappingsPage(
        PageContext<ListDomainMappingsRequest, ListDomainMappingsResponse, DomainMapping> context,
        ListDomainMappingsResponse response) {
      super(context, response);
    }

    private static ListDomainMappingsPage createEmptyPage() {
      return new ListDomainMappingsPage(null, null);
    }

    @Override
    protected ListDomainMappingsPage createPage(
        PageContext<ListDomainMappingsRequest, ListDomainMappingsResponse, DomainMapping> context,
        ListDomainMappingsResponse response) {
      return new ListDomainMappingsPage(context, response);
    }

    @Override
    public ApiFuture<ListDomainMappingsPage> createPageAsync(
        PageContext<ListDomainMappingsRequest, ListDomainMappingsResponse, DomainMapping> context,
        ApiFuture<ListDomainMappingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDomainMappingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDomainMappingsRequest,
          ListDomainMappingsResponse,
          DomainMapping,
          ListDomainMappingsPage,
          ListDomainMappingsFixedSizeCollection> {

    private ListDomainMappingsFixedSizeCollection(
        List<ListDomainMappingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDomainMappingsFixedSizeCollection createEmptyCollection() {
      return new ListDomainMappingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDomainMappingsFixedSizeCollection createCollection(
        List<ListDomainMappingsPage> pages, int collectionSize) {
      return new ListDomainMappingsFixedSizeCollection(pages, collectionSize);
    }
  }
}
