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
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.appengine.v1.stub.AuthorizedCertificatesStub;
import com.google.appengine.v1.stub.AuthorizedCertificatesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Manages SSL certificates a user is authorized to administer. A user can
 * administer any SSL certificates applicable to their authorized domains.
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
 * try (AuthorizedCertificatesClient authorizedCertificatesClient =
 *     AuthorizedCertificatesClient.create()) {
 *   GetAuthorizedCertificateRequest request =
 *       GetAuthorizedCertificateRequest.newBuilder()
 *           .setName("name3373707")
 *           .setView(AuthorizedCertificateView.forNumber(0))
 *           .build();
 *   AuthorizedCertificate response =
 *       authorizedCertificatesClient.getAuthorizedCertificate(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AuthorizedCertificatesClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of AuthorizedCertificatesSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AuthorizedCertificatesSettings authorizedCertificatesSettings =
 *     AuthorizedCertificatesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AuthorizedCertificatesClient authorizedCertificatesClient =
 *     AuthorizedCertificatesClient.create(authorizedCertificatesSettings);
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
 * AuthorizedCertificatesSettings authorizedCertificatesSettings =
 *     AuthorizedCertificatesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AuthorizedCertificatesClient authorizedCertificatesClient =
 *     AuthorizedCertificatesClient.create(authorizedCertificatesSettings);
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
 * AuthorizedCertificatesSettings authorizedCertificatesSettings =
 *     AuthorizedCertificatesSettings.newHttpJsonBuilder().build();
 * AuthorizedCertificatesClient authorizedCertificatesClient =
 *     AuthorizedCertificatesClient.create(authorizedCertificatesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AuthorizedCertificatesClient implements BackgroundResource {
  private final AuthorizedCertificatesSettings settings;
  private final AuthorizedCertificatesStub stub;

  /** Constructs an instance of AuthorizedCertificatesClient with default settings. */
  public static final AuthorizedCertificatesClient create() throws IOException {
    return create(AuthorizedCertificatesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AuthorizedCertificatesClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AuthorizedCertificatesClient create(AuthorizedCertificatesSettings settings)
      throws IOException {
    return new AuthorizedCertificatesClient(settings);
  }

  /**
   * Constructs an instance of AuthorizedCertificatesClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(AuthorizedCertificatesSettings).
   */
  public static final AuthorizedCertificatesClient create(AuthorizedCertificatesStub stub) {
    return new AuthorizedCertificatesClient(stub);
  }

  /**
   * Constructs an instance of AuthorizedCertificatesClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected AuthorizedCertificatesClient(AuthorizedCertificatesSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((AuthorizedCertificatesStubSettings) settings.getStubSettings()).createStub();
  }

  protected AuthorizedCertificatesClient(AuthorizedCertificatesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AuthorizedCertificatesSettings getSettings() {
    return settings;
  }

  public AuthorizedCertificatesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all SSL certificates the user is authorized to administer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthorizedCertificatesClient authorizedCertificatesClient =
   *     AuthorizedCertificatesClient.create()) {
   *   ListAuthorizedCertificatesRequest request =
   *       ListAuthorizedCertificatesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setView(AuthorizedCertificateView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AuthorizedCertificate element :
   *       authorizedCertificatesClient.listAuthorizedCertificates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuthorizedCertificatesPagedResponse listAuthorizedCertificates(
      ListAuthorizedCertificatesRequest request) {
    return listAuthorizedCertificatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all SSL certificates the user is authorized to administer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthorizedCertificatesClient authorizedCertificatesClient =
   *     AuthorizedCertificatesClient.create()) {
   *   ListAuthorizedCertificatesRequest request =
   *       ListAuthorizedCertificatesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setView(AuthorizedCertificateView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AuthorizedCertificate> future =
   *       authorizedCertificatesClient
   *           .listAuthorizedCertificatesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (AuthorizedCertificate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListAuthorizedCertificatesRequest, ListAuthorizedCertificatesPagedResponse>
      listAuthorizedCertificatesPagedCallable() {
    return stub.listAuthorizedCertificatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all SSL certificates the user is authorized to administer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthorizedCertificatesClient authorizedCertificatesClient =
   *     AuthorizedCertificatesClient.create()) {
   *   ListAuthorizedCertificatesRequest request =
   *       ListAuthorizedCertificatesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setView(AuthorizedCertificateView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAuthorizedCertificatesResponse response =
   *         authorizedCertificatesClient.listAuthorizedCertificatesCallable().call(request);
   *     for (AuthorizedCertificate element : response.getCertificatesList()) {
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
  public final UnaryCallable<ListAuthorizedCertificatesRequest, ListAuthorizedCertificatesResponse>
      listAuthorizedCertificatesCallable() {
    return stub.listAuthorizedCertificatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified SSL certificate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthorizedCertificatesClient authorizedCertificatesClient =
   *     AuthorizedCertificatesClient.create()) {
   *   GetAuthorizedCertificateRequest request =
   *       GetAuthorizedCertificateRequest.newBuilder()
   *           .setName("name3373707")
   *           .setView(AuthorizedCertificateView.forNumber(0))
   *           .build();
   *   AuthorizedCertificate response =
   *       authorizedCertificatesClient.getAuthorizedCertificate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthorizedCertificate getAuthorizedCertificate(
      GetAuthorizedCertificateRequest request) {
    return getAuthorizedCertificateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified SSL certificate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthorizedCertificatesClient authorizedCertificatesClient =
   *     AuthorizedCertificatesClient.create()) {
   *   GetAuthorizedCertificateRequest request =
   *       GetAuthorizedCertificateRequest.newBuilder()
   *           .setName("name3373707")
   *           .setView(AuthorizedCertificateView.forNumber(0))
   *           .build();
   *   ApiFuture<AuthorizedCertificate> future =
   *       authorizedCertificatesClient.getAuthorizedCertificateCallable().futureCall(request);
   *   // Do something.
   *   AuthorizedCertificate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAuthorizedCertificateRequest, AuthorizedCertificate>
      getAuthorizedCertificateCallable() {
    return stub.getAuthorizedCertificateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads the specified SSL certificate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthorizedCertificatesClient authorizedCertificatesClient =
   *     AuthorizedCertificatesClient.create()) {
   *   CreateAuthorizedCertificateRequest request =
   *       CreateAuthorizedCertificateRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setCertificate(AuthorizedCertificate.newBuilder().build())
   *           .build();
   *   AuthorizedCertificate response =
   *       authorizedCertificatesClient.createAuthorizedCertificate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthorizedCertificate createAuthorizedCertificate(
      CreateAuthorizedCertificateRequest request) {
    return createAuthorizedCertificateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uploads the specified SSL certificate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthorizedCertificatesClient authorizedCertificatesClient =
   *     AuthorizedCertificatesClient.create()) {
   *   CreateAuthorizedCertificateRequest request =
   *       CreateAuthorizedCertificateRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setCertificate(AuthorizedCertificate.newBuilder().build())
   *           .build();
   *   ApiFuture<AuthorizedCertificate> future =
   *       authorizedCertificatesClient.createAuthorizedCertificateCallable().futureCall(request);
   *   // Do something.
   *   AuthorizedCertificate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAuthorizedCertificateRequest, AuthorizedCertificate>
      createAuthorizedCertificateCallable() {
    return stub.createAuthorizedCertificateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified SSL certificate. To renew a certificate and maintain its existing domain
   * mappings, update `certificate_data` with a new certificate. The new certificate must be
   * applicable to the same domains as the original certificate. The certificate `display_name` may
   * also be updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthorizedCertificatesClient authorizedCertificatesClient =
   *     AuthorizedCertificatesClient.create()) {
   *   UpdateAuthorizedCertificateRequest request =
   *       UpdateAuthorizedCertificateRequest.newBuilder()
   *           .setName("name3373707")
   *           .setCertificate(AuthorizedCertificate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AuthorizedCertificate response =
   *       authorizedCertificatesClient.updateAuthorizedCertificate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthorizedCertificate updateAuthorizedCertificate(
      UpdateAuthorizedCertificateRequest request) {
    return updateAuthorizedCertificateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified SSL certificate. To renew a certificate and maintain its existing domain
   * mappings, update `certificate_data` with a new certificate. The new certificate must be
   * applicable to the same domains as the original certificate. The certificate `display_name` may
   * also be updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthorizedCertificatesClient authorizedCertificatesClient =
   *     AuthorizedCertificatesClient.create()) {
   *   UpdateAuthorizedCertificateRequest request =
   *       UpdateAuthorizedCertificateRequest.newBuilder()
   *           .setName("name3373707")
   *           .setCertificate(AuthorizedCertificate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<AuthorizedCertificate> future =
   *       authorizedCertificatesClient.updateAuthorizedCertificateCallable().futureCall(request);
   *   // Do something.
   *   AuthorizedCertificate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAuthorizedCertificateRequest, AuthorizedCertificate>
      updateAuthorizedCertificateCallable() {
    return stub.updateAuthorizedCertificateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified SSL certificate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthorizedCertificatesClient authorizedCertificatesClient =
   *     AuthorizedCertificatesClient.create()) {
   *   DeleteAuthorizedCertificateRequest request =
   *       DeleteAuthorizedCertificateRequest.newBuilder().setName("name3373707").build();
   *   authorizedCertificatesClient.deleteAuthorizedCertificate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAuthorizedCertificate(DeleteAuthorizedCertificateRequest request) {
    deleteAuthorizedCertificateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified SSL certificate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthorizedCertificatesClient authorizedCertificatesClient =
   *     AuthorizedCertificatesClient.create()) {
   *   DeleteAuthorizedCertificateRequest request =
   *       DeleteAuthorizedCertificateRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Empty> future =
   *       authorizedCertificatesClient.deleteAuthorizedCertificateCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAuthorizedCertificateRequest, Empty>
      deleteAuthorizedCertificateCallable() {
    return stub.deleteAuthorizedCertificateCallable();
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

  public static class ListAuthorizedCertificatesPagedResponse
      extends AbstractPagedListResponse<
          ListAuthorizedCertificatesRequest,
          ListAuthorizedCertificatesResponse,
          AuthorizedCertificate,
          ListAuthorizedCertificatesPage,
          ListAuthorizedCertificatesFixedSizeCollection> {

    public static ApiFuture<ListAuthorizedCertificatesPagedResponse> createAsync(
        PageContext<
                ListAuthorizedCertificatesRequest,
                ListAuthorizedCertificatesResponse,
                AuthorizedCertificate>
            context,
        ApiFuture<ListAuthorizedCertificatesResponse> futureResponse) {
      ApiFuture<ListAuthorizedCertificatesPage> futurePage =
          ListAuthorizedCertificatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAuthorizedCertificatesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAuthorizedCertificatesPagedResponse(ListAuthorizedCertificatesPage page) {
      super(page, ListAuthorizedCertificatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAuthorizedCertificatesPage
      extends AbstractPage<
          ListAuthorizedCertificatesRequest,
          ListAuthorizedCertificatesResponse,
          AuthorizedCertificate,
          ListAuthorizedCertificatesPage> {

    private ListAuthorizedCertificatesPage(
        PageContext<
                ListAuthorizedCertificatesRequest,
                ListAuthorizedCertificatesResponse,
                AuthorizedCertificate>
            context,
        ListAuthorizedCertificatesResponse response) {
      super(context, response);
    }

    private static ListAuthorizedCertificatesPage createEmptyPage() {
      return new ListAuthorizedCertificatesPage(null, null);
    }

    @Override
    protected ListAuthorizedCertificatesPage createPage(
        PageContext<
                ListAuthorizedCertificatesRequest,
                ListAuthorizedCertificatesResponse,
                AuthorizedCertificate>
            context,
        ListAuthorizedCertificatesResponse response) {
      return new ListAuthorizedCertificatesPage(context, response);
    }

    @Override
    public ApiFuture<ListAuthorizedCertificatesPage> createPageAsync(
        PageContext<
                ListAuthorizedCertificatesRequest,
                ListAuthorizedCertificatesResponse,
                AuthorizedCertificate>
            context,
        ApiFuture<ListAuthorizedCertificatesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAuthorizedCertificatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAuthorizedCertificatesRequest,
          ListAuthorizedCertificatesResponse,
          AuthorizedCertificate,
          ListAuthorizedCertificatesPage,
          ListAuthorizedCertificatesFixedSizeCollection> {

    private ListAuthorizedCertificatesFixedSizeCollection(
        List<ListAuthorizedCertificatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAuthorizedCertificatesFixedSizeCollection createEmptyCollection() {
      return new ListAuthorizedCertificatesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAuthorizedCertificatesFixedSizeCollection createCollection(
        List<ListAuthorizedCertificatesPage> pages, int collectionSize) {
      return new ListAuthorizedCertificatesFixedSizeCollection(pages, collectionSize);
    }
  }
}
