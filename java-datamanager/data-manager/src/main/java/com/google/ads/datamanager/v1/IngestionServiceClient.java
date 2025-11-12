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

package com.google.ads.datamanager.v1;

import com.google.ads.datamanager.v1.stub.IngestionServiceStub;
import com.google.ads.datamanager.v1.stub.IngestionServiceStubSettings;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for sending audience data to supported destinations.
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
 * try (IngestionServiceClient ingestionServiceClient = IngestionServiceClient.create()) {
 *   IngestAudienceMembersRequest request =
 *       IngestAudienceMembersRequest.newBuilder()
 *           .addAllDestinations(new ArrayList<Destination>())
 *           .addAllAudienceMembers(new ArrayList<AudienceMember>())
 *           .setConsent(Consent.newBuilder().build())
 *           .setValidateOnly(true)
 *           .setEncoding(Encoding.forNumber(0))
 *           .setEncryptionInfo(EncryptionInfo.newBuilder().build())
 *           .setTermsOfService(TermsOfService.newBuilder().build())
 *           .build();
 *   IngestAudienceMembersResponse response =
 *       ingestionServiceClient.ingestAudienceMembers(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the IngestionServiceClient object to clean up resources
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
 *      <td><p> IngestAudienceMembers</td>
 *      <td><p> Uploads a list of [AudienceMember][google.ads.datamanager.v1.AudienceMember] resources to the provided [Destination][google.ads.datamanager.v1.Destination].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> ingestAudienceMembers(IngestAudienceMembersRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> ingestAudienceMembersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RemoveAudienceMembers</td>
 *      <td><p> Removes a list of [AudienceMember][google.ads.datamanager.v1.AudienceMember] resources from the provided [Destination][google.ads.datamanager.v1.Destination].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> removeAudienceMembers(RemoveAudienceMembersRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> removeAudienceMembersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> IngestEvents</td>
 *      <td><p> Uploads a list of [Event][google.ads.datamanager.v1.Event] resources from the provided [Destination][google.ads.datamanager.v1.Destination].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> ingestEvents(IngestEventsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> ingestEventsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RetrieveRequestStatus</td>
 *      <td><p> Gets the status of a request given request id.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> retrieveRequestStatus(RetrieveRequestStatusRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> retrieveRequestStatusCallable()
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
 * <p>This class can be customized by passing in a custom instance of IngestionServiceSettings to
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
 * IngestionServiceSettings ingestionServiceSettings =
 *     IngestionServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * IngestionServiceClient ingestionServiceClient =
 *     IngestionServiceClient.create(ingestionServiceSettings);
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
 * IngestionServiceSettings ingestionServiceSettings =
 *     IngestionServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * IngestionServiceClient ingestionServiceClient =
 *     IngestionServiceClient.create(ingestionServiceSettings);
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
 * IngestionServiceSettings ingestionServiceSettings =
 *     IngestionServiceSettings.newHttpJsonBuilder().build();
 * IngestionServiceClient ingestionServiceClient =
 *     IngestionServiceClient.create(ingestionServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class IngestionServiceClient implements BackgroundResource {
  private final IngestionServiceSettings settings;
  private final IngestionServiceStub stub;

  /** Constructs an instance of IngestionServiceClient with default settings. */
  public static final IngestionServiceClient create() throws IOException {
    return create(IngestionServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of IngestionServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final IngestionServiceClient create(IngestionServiceSettings settings)
      throws IOException {
    return new IngestionServiceClient(settings);
  }

  /**
   * Constructs an instance of IngestionServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(IngestionServiceSettings).
   */
  public static final IngestionServiceClient create(IngestionServiceStub stub) {
    return new IngestionServiceClient(stub);
  }

  /**
   * Constructs an instance of IngestionServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected IngestionServiceClient(IngestionServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((IngestionServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected IngestionServiceClient(IngestionServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final IngestionServiceSettings getSettings() {
    return settings;
  }

  public IngestionServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads a list of [AudienceMember][google.ads.datamanager.v1.AudienceMember] resources to the
   * provided [Destination][google.ads.datamanager.v1.Destination].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IngestionServiceClient ingestionServiceClient = IngestionServiceClient.create()) {
   *   IngestAudienceMembersRequest request =
   *       IngestAudienceMembersRequest.newBuilder()
   *           .addAllDestinations(new ArrayList<Destination>())
   *           .addAllAudienceMembers(new ArrayList<AudienceMember>())
   *           .setConsent(Consent.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setEncoding(Encoding.forNumber(0))
   *           .setEncryptionInfo(EncryptionInfo.newBuilder().build())
   *           .setTermsOfService(TermsOfService.newBuilder().build())
   *           .build();
   *   IngestAudienceMembersResponse response =
   *       ingestionServiceClient.ingestAudienceMembers(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IngestAudienceMembersResponse ingestAudienceMembers(
      IngestAudienceMembersRequest request) {
    return ingestAudienceMembersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads a list of [AudienceMember][google.ads.datamanager.v1.AudienceMember] resources to the
   * provided [Destination][google.ads.datamanager.v1.Destination].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IngestionServiceClient ingestionServiceClient = IngestionServiceClient.create()) {
   *   IngestAudienceMembersRequest request =
   *       IngestAudienceMembersRequest.newBuilder()
   *           .addAllDestinations(new ArrayList<Destination>())
   *           .addAllAudienceMembers(new ArrayList<AudienceMember>())
   *           .setConsent(Consent.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setEncoding(Encoding.forNumber(0))
   *           .setEncryptionInfo(EncryptionInfo.newBuilder().build())
   *           .setTermsOfService(TermsOfService.newBuilder().build())
   *           .build();
   *   ApiFuture<IngestAudienceMembersResponse> future =
   *       ingestionServiceClient.ingestAudienceMembersCallable().futureCall(request);
   *   // Do something.
   *   IngestAudienceMembersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<IngestAudienceMembersRequest, IngestAudienceMembersResponse>
      ingestAudienceMembersCallable() {
    return stub.ingestAudienceMembersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a list of [AudienceMember][google.ads.datamanager.v1.AudienceMember] resources from the
   * provided [Destination][google.ads.datamanager.v1.Destination].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IngestionServiceClient ingestionServiceClient = IngestionServiceClient.create()) {
   *   RemoveAudienceMembersRequest request =
   *       RemoveAudienceMembersRequest.newBuilder()
   *           .addAllDestinations(new ArrayList<Destination>())
   *           .addAllAudienceMembers(new ArrayList<AudienceMember>())
   *           .setValidateOnly(true)
   *           .setEncoding(Encoding.forNumber(0))
   *           .setEncryptionInfo(EncryptionInfo.newBuilder().build())
   *           .build();
   *   RemoveAudienceMembersResponse response =
   *       ingestionServiceClient.removeAudienceMembers(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RemoveAudienceMembersResponse removeAudienceMembers(
      RemoveAudienceMembersRequest request) {
    return removeAudienceMembersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a list of [AudienceMember][google.ads.datamanager.v1.AudienceMember] resources from the
   * provided [Destination][google.ads.datamanager.v1.Destination].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IngestionServiceClient ingestionServiceClient = IngestionServiceClient.create()) {
   *   RemoveAudienceMembersRequest request =
   *       RemoveAudienceMembersRequest.newBuilder()
   *           .addAllDestinations(new ArrayList<Destination>())
   *           .addAllAudienceMembers(new ArrayList<AudienceMember>())
   *           .setValidateOnly(true)
   *           .setEncoding(Encoding.forNumber(0))
   *           .setEncryptionInfo(EncryptionInfo.newBuilder().build())
   *           .build();
   *   ApiFuture<RemoveAudienceMembersResponse> future =
   *       ingestionServiceClient.removeAudienceMembersCallable().futureCall(request);
   *   // Do something.
   *   RemoveAudienceMembersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveAudienceMembersRequest, RemoveAudienceMembersResponse>
      removeAudienceMembersCallable() {
    return stub.removeAudienceMembersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads a list of [Event][google.ads.datamanager.v1.Event] resources from the provided
   * [Destination][google.ads.datamanager.v1.Destination].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IngestionServiceClient ingestionServiceClient = IngestionServiceClient.create()) {
   *   IngestEventsRequest request =
   *       IngestEventsRequest.newBuilder()
   *           .addAllDestinations(new ArrayList<Destination>())
   *           .addAllEvents(new ArrayList<Event>())
   *           .setConsent(Consent.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setEncoding(Encoding.forNumber(0))
   *           .setEncryptionInfo(EncryptionInfo.newBuilder().build())
   *           .build();
   *   IngestEventsResponse response = ingestionServiceClient.ingestEvents(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IngestEventsResponse ingestEvents(IngestEventsRequest request) {
    return ingestEventsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads a list of [Event][google.ads.datamanager.v1.Event] resources from the provided
   * [Destination][google.ads.datamanager.v1.Destination].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IngestionServiceClient ingestionServiceClient = IngestionServiceClient.create()) {
   *   IngestEventsRequest request =
   *       IngestEventsRequest.newBuilder()
   *           .addAllDestinations(new ArrayList<Destination>())
   *           .addAllEvents(new ArrayList<Event>())
   *           .setConsent(Consent.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setEncoding(Encoding.forNumber(0))
   *           .setEncryptionInfo(EncryptionInfo.newBuilder().build())
   *           .build();
   *   ApiFuture<IngestEventsResponse> future =
   *       ingestionServiceClient.ingestEventsCallable().futureCall(request);
   *   // Do something.
   *   IngestEventsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<IngestEventsRequest, IngestEventsResponse> ingestEventsCallable() {
    return stub.ingestEventsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the status of a request given request id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IngestionServiceClient ingestionServiceClient = IngestionServiceClient.create()) {
   *   RetrieveRequestStatusRequest request =
   *       RetrieveRequestStatusRequest.newBuilder().setRequestId("requestId693933066").build();
   *   RetrieveRequestStatusResponse response =
   *       ingestionServiceClient.retrieveRequestStatus(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetrieveRequestStatusResponse retrieveRequestStatus(
      RetrieveRequestStatusRequest request) {
    return retrieveRequestStatusCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the status of a request given request id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IngestionServiceClient ingestionServiceClient = IngestionServiceClient.create()) {
   *   RetrieveRequestStatusRequest request =
   *       RetrieveRequestStatusRequest.newBuilder().setRequestId("requestId693933066").build();
   *   ApiFuture<RetrieveRequestStatusResponse> future =
   *       ingestionServiceClient.retrieveRequestStatusCallable().futureCall(request);
   *   // Do something.
   *   RetrieveRequestStatusResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RetrieveRequestStatusRequest, RetrieveRequestStatusResponse>
      retrieveRequestStatusCallable() {
    return stub.retrieveRequestStatusCallable();
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
