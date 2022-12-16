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

package com.google.cloud.retail.v2beta;

import com.google.api.HttpBody;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2beta.stub.UserEventServiceStub;
import com.google.cloud.retail.v2beta.stub.UserEventServiceStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for ingesting end user actions on the customer website.
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
 * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
 *   WriteUserEventRequest request =
 *       WriteUserEventRequest.newBuilder()
 *           .setParent("parent-995424086")
 *           .setUserEvent(UserEvent.newBuilder().build())
 *           .setWriteAsync(true)
 *           .build();
 *   UserEvent response = userEventServiceClient.writeUserEvent(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the UserEventServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 * <p>This class can be customized by passing in a custom instance of UserEventServiceSettings to
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
 * UserEventServiceSettings userEventServiceSettings =
 *     UserEventServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * UserEventServiceClient userEventServiceClient =
 *     UserEventServiceClient.create(userEventServiceSettings);
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
 * UserEventServiceSettings userEventServiceSettings =
 *     UserEventServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * UserEventServiceClient userEventServiceClient =
 *     UserEventServiceClient.create(userEventServiceSettings);
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
 * UserEventServiceSettings userEventServiceSettings =
 *     UserEventServiceSettings.newHttpJsonBuilder().build();
 * UserEventServiceClient userEventServiceClient =
 *     UserEventServiceClient.create(userEventServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class UserEventServiceClient implements BackgroundResource {
  private final UserEventServiceSettings settings;
  private final UserEventServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of UserEventServiceClient with default settings. */
  public static final UserEventServiceClient create() throws IOException {
    return create(UserEventServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of UserEventServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final UserEventServiceClient create(UserEventServiceSettings settings)
      throws IOException {
    return new UserEventServiceClient(settings);
  }

  /**
   * Constructs an instance of UserEventServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(UserEventServiceSettings).
   */
  public static final UserEventServiceClient create(UserEventServiceStub stub) {
    return new UserEventServiceClient(stub);
  }

  /**
   * Constructs an instance of UserEventServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected UserEventServiceClient(UserEventServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((UserEventServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected UserEventServiceClient(UserEventServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final UserEventServiceSettings getSettings() {
    return settings;
  }

  public UserEventServiceStub getStub() {
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
   * Writes a single user event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   WriteUserEventRequest request =
   *       WriteUserEventRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setUserEvent(UserEvent.newBuilder().build())
   *           .setWriteAsync(true)
   *           .build();
   *   UserEvent response = userEventServiceClient.writeUserEvent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserEvent writeUserEvent(WriteUserEventRequest request) {
    return writeUserEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Writes a single user event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   WriteUserEventRequest request =
   *       WriteUserEventRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setUserEvent(UserEvent.newBuilder().build())
   *           .setWriteAsync(true)
   *           .build();
   *   ApiFuture<UserEvent> future =
   *       userEventServiceClient.writeUserEventCallable().futureCall(request);
   *   // Do something.
   *   UserEvent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<WriteUserEventRequest, UserEvent> writeUserEventCallable() {
    return stub.writeUserEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Writes a single user event from the browser. This uses a GET request to due to browser
   * restriction of POST-ing to a 3rd party domain.
   *
   * <p>This method is used only by the Retail API JavaScript pixel and Google Tag Manager. Users
   * should not call this method directly.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   CollectUserEventRequest request =
   *       CollectUserEventRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setUserEvent("userEvent315571599")
   *           .setUri("uri116076")
   *           .setEts(100772)
   *           .setRawJson("rawJson985449776")
   *           .build();
   *   HttpBody response = userEventServiceClient.collectUserEvent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpBody collectUserEvent(CollectUserEventRequest request) {
    return collectUserEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Writes a single user event from the browser. This uses a GET request to due to browser
   * restriction of POST-ing to a 3rd party domain.
   *
   * <p>This method is used only by the Retail API JavaScript pixel and Google Tag Manager. Users
   * should not call this method directly.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   CollectUserEventRequest request =
   *       CollectUserEventRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setUserEvent("userEvent315571599")
   *           .setUri("uri116076")
   *           .setEts(100772)
   *           .setRawJson("rawJson985449776")
   *           .build();
   *   ApiFuture<HttpBody> future =
   *       userEventServiceClient.collectUserEventCallable().futureCall(request);
   *   // Do something.
   *   HttpBody response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CollectUserEventRequest, HttpBody> collectUserEventCallable() {
    return stub.collectUserEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes permanently all user events specified by the filter provided. Depending on the number
   * of events specified by the filter, this operation could take hours or days to complete. To test
   * a filter, use the list command first.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   PurgeUserEventsRequest request =
   *       PurgeUserEventsRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setFilter("filter-1274492040")
   *           .setForce(true)
   *           .build();
   *   PurgeUserEventsResponse response = userEventServiceClient.purgeUserEventsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<PurgeUserEventsResponse, PurgeMetadata> purgeUserEventsAsync(
      PurgeUserEventsRequest request) {
    return purgeUserEventsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes permanently all user events specified by the filter provided. Depending on the number
   * of events specified by the filter, this operation could take hours or days to complete. To test
   * a filter, use the list command first.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   PurgeUserEventsRequest request =
   *       PurgeUserEventsRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setFilter("filter-1274492040")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<PurgeUserEventsResponse, PurgeMetadata> future =
   *       userEventServiceClient.purgeUserEventsOperationCallable().futureCall(request);
   *   // Do something.
   *   PurgeUserEventsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PurgeUserEventsRequest, PurgeUserEventsResponse, PurgeMetadata>
      purgeUserEventsOperationCallable() {
    return stub.purgeUserEventsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes permanently all user events specified by the filter provided. Depending on the number
   * of events specified by the filter, this operation could take hours or days to complete. To test
   * a filter, use the list command first.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   PurgeUserEventsRequest request =
   *       PurgeUserEventsRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setFilter("filter-1274492040")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       userEventServiceClient.purgeUserEventsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PurgeUserEventsRequest, Operation> purgeUserEventsCallable() {
    return stub.purgeUserEventsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Bulk import of User events. Request processing might be synchronous. Events that already exist
   * are skipped. Use this method for backfilling historical user events.
   *
   * <p>`Operation.response` is of type `ImportResponse`. Note that it is possible for a subset of
   * the items to be successfully inserted. `Operation.metadata` is of type `ImportMetadata`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   ImportUserEventsRequest request =
   *       ImportUserEventsRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setInputConfig(UserEventInputConfig.newBuilder().build())
   *           .setErrorsConfig(ImportErrorsConfig.newBuilder().build())
   *           .build();
   *   ImportUserEventsResponse response =
   *       userEventServiceClient.importUserEventsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportUserEventsResponse, ImportMetadata> importUserEventsAsync(
      ImportUserEventsRequest request) {
    return importUserEventsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Bulk import of User events. Request processing might be synchronous. Events that already exist
   * are skipped. Use this method for backfilling historical user events.
   *
   * <p>`Operation.response` is of type `ImportResponse`. Note that it is possible for a subset of
   * the items to be successfully inserted. `Operation.metadata` is of type `ImportMetadata`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   ImportUserEventsRequest request =
   *       ImportUserEventsRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setInputConfig(UserEventInputConfig.newBuilder().build())
   *           .setErrorsConfig(ImportErrorsConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<ImportUserEventsResponse, ImportMetadata> future =
   *       userEventServiceClient.importUserEventsOperationCallable().futureCall(request);
   *   // Do something.
   *   ImportUserEventsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ImportUserEventsRequest, ImportUserEventsResponse, ImportMetadata>
      importUserEventsOperationCallable() {
    return stub.importUserEventsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Bulk import of User events. Request processing might be synchronous. Events that already exist
   * are skipped. Use this method for backfilling historical user events.
   *
   * <p>`Operation.response` is of type `ImportResponse`. Note that it is possible for a subset of
   * the items to be successfully inserted. `Operation.metadata` is of type `ImportMetadata`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   ImportUserEventsRequest request =
   *       ImportUserEventsRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setInputConfig(UserEventInputConfig.newBuilder().build())
   *           .setErrorsConfig(ImportErrorsConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       userEventServiceClient.importUserEventsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportUserEventsRequest, Operation> importUserEventsCallable() {
    return stub.importUserEventsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a user-event rejoin operation with latest product catalog. Events are not annotated with
   * detailed product information for products that are missing from the catalog when the user event
   * is ingested. These events are stored as unjoined events with limited usage on training and
   * serving. You can use this method to start a join operation on specified events with the latest
   * version of product catalog. You can also use this method to correct events joined with the
   * wrong product catalog. A rejoin operation can take hours or days to complete.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   RejoinUserEventsRequest request =
   *       RejoinUserEventsRequest.newBuilder().setParent("parent-995424086").build();
   *   RejoinUserEventsResponse response =
   *       userEventServiceClient.rejoinUserEventsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RejoinUserEventsResponse, RejoinUserEventsMetadata>
      rejoinUserEventsAsync(RejoinUserEventsRequest request) {
    return rejoinUserEventsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a user-event rejoin operation with latest product catalog. Events are not annotated with
   * detailed product information for products that are missing from the catalog when the user event
   * is ingested. These events are stored as unjoined events with limited usage on training and
   * serving. You can use this method to start a join operation on specified events with the latest
   * version of product catalog. You can also use this method to correct events joined with the
   * wrong product catalog. A rejoin operation can take hours or days to complete.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   RejoinUserEventsRequest request =
   *       RejoinUserEventsRequest.newBuilder().setParent("parent-995424086").build();
   *   OperationFuture<RejoinUserEventsResponse, RejoinUserEventsMetadata> future =
   *       userEventServiceClient.rejoinUserEventsOperationCallable().futureCall(request);
   *   // Do something.
   *   RejoinUserEventsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RejoinUserEventsRequest, RejoinUserEventsResponse, RejoinUserEventsMetadata>
      rejoinUserEventsOperationCallable() {
    return stub.rejoinUserEventsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a user-event rejoin operation with latest product catalog. Events are not annotated with
   * detailed product information for products that are missing from the catalog when the user event
   * is ingested. These events are stored as unjoined events with limited usage on training and
   * serving. You can use this method to start a join operation on specified events with the latest
   * version of product catalog. You can also use this method to correct events joined with the
   * wrong product catalog. A rejoin operation can take hours or days to complete.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   RejoinUserEventsRequest request =
   *       RejoinUserEventsRequest.newBuilder().setParent("parent-995424086").build();
   *   ApiFuture<Operation> future =
   *       userEventServiceClient.rejoinUserEventsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RejoinUserEventsRequest, Operation> rejoinUserEventsCallable() {
    return stub.rejoinUserEventsCallable();
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
}
