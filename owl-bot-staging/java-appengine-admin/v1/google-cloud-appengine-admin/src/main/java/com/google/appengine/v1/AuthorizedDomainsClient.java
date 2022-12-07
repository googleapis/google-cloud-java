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
import com.google.appengine.v1.stub.AuthorizedDomainsStub;
import com.google.appengine.v1.stub.AuthorizedDomainsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Manages domains a user is authorized to administer. To authorize use of a
 * domain, verify ownership via [Webmaster
 * Central](https://www.google.com/webmasters/verification/home).
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
 * try (AuthorizedDomainsClient authorizedDomainsClient = AuthorizedDomainsClient.create()) {
 *   ListAuthorizedDomainsRequest request =
 *       ListAuthorizedDomainsRequest.newBuilder()
 *           .setParent("parent-995424086")
 *           .setPageSize(883849137)
 *           .setPageToken("pageToken873572522")
 *           .build();
 *   for (AuthorizedDomain element :
 *       authorizedDomainsClient.listAuthorizedDomains(request).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AuthorizedDomainsClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of AuthorizedDomainsSettings to
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
 * AuthorizedDomainsSettings authorizedDomainsSettings =
 *     AuthorizedDomainsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AuthorizedDomainsClient authorizedDomainsClient =
 *     AuthorizedDomainsClient.create(authorizedDomainsSettings);
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
 * AuthorizedDomainsSettings authorizedDomainsSettings =
 *     AuthorizedDomainsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AuthorizedDomainsClient authorizedDomainsClient =
 *     AuthorizedDomainsClient.create(authorizedDomainsSettings);
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
 * AuthorizedDomainsSettings authorizedDomainsSettings =
 *     AuthorizedDomainsSettings.newHttpJsonBuilder().build();
 * AuthorizedDomainsClient authorizedDomainsClient =
 *     AuthorizedDomainsClient.create(authorizedDomainsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AuthorizedDomainsClient implements BackgroundResource {
  private final AuthorizedDomainsSettings settings;
  private final AuthorizedDomainsStub stub;

  /** Constructs an instance of AuthorizedDomainsClient with default settings. */
  public static final AuthorizedDomainsClient create() throws IOException {
    return create(AuthorizedDomainsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AuthorizedDomainsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AuthorizedDomainsClient create(AuthorizedDomainsSettings settings)
      throws IOException {
    return new AuthorizedDomainsClient(settings);
  }

  /**
   * Constructs an instance of AuthorizedDomainsClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(AuthorizedDomainsSettings).
   */
  public static final AuthorizedDomainsClient create(AuthorizedDomainsStub stub) {
    return new AuthorizedDomainsClient(stub);
  }

  /**
   * Constructs an instance of AuthorizedDomainsClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AuthorizedDomainsClient(AuthorizedDomainsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AuthorizedDomainsStubSettings) settings.getStubSettings()).createStub();
  }

  protected AuthorizedDomainsClient(AuthorizedDomainsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AuthorizedDomainsSettings getSettings() {
    return settings;
  }

  public AuthorizedDomainsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all domains the user is authorized to administer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthorizedDomainsClient authorizedDomainsClient = AuthorizedDomainsClient.create()) {
   *   ListAuthorizedDomainsRequest request =
   *       ListAuthorizedDomainsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AuthorizedDomain element :
   *       authorizedDomainsClient.listAuthorizedDomains(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuthorizedDomainsPagedResponse listAuthorizedDomains(
      ListAuthorizedDomainsRequest request) {
    return listAuthorizedDomainsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all domains the user is authorized to administer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthorizedDomainsClient authorizedDomainsClient = AuthorizedDomainsClient.create()) {
   *   ListAuthorizedDomainsRequest request =
   *       ListAuthorizedDomainsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AuthorizedDomain> future =
   *       authorizedDomainsClient.listAuthorizedDomainsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AuthorizedDomain element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAuthorizedDomainsRequest, ListAuthorizedDomainsPagedResponse>
      listAuthorizedDomainsPagedCallable() {
    return stub.listAuthorizedDomainsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all domains the user is authorized to administer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AuthorizedDomainsClient authorizedDomainsClient = AuthorizedDomainsClient.create()) {
   *   ListAuthorizedDomainsRequest request =
   *       ListAuthorizedDomainsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAuthorizedDomainsResponse response =
   *         authorizedDomainsClient.listAuthorizedDomainsCallable().call(request);
   *     for (AuthorizedDomain element : response.getDomainsList()) {
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
  public final UnaryCallable<ListAuthorizedDomainsRequest, ListAuthorizedDomainsResponse>
      listAuthorizedDomainsCallable() {
    return stub.listAuthorizedDomainsCallable();
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

  public static class ListAuthorizedDomainsPagedResponse
      extends AbstractPagedListResponse<
          ListAuthorizedDomainsRequest,
          ListAuthorizedDomainsResponse,
          AuthorizedDomain,
          ListAuthorizedDomainsPage,
          ListAuthorizedDomainsFixedSizeCollection> {

    public static ApiFuture<ListAuthorizedDomainsPagedResponse> createAsync(
        PageContext<ListAuthorizedDomainsRequest, ListAuthorizedDomainsResponse, AuthorizedDomain>
            context,
        ApiFuture<ListAuthorizedDomainsResponse> futureResponse) {
      ApiFuture<ListAuthorizedDomainsPage> futurePage =
          ListAuthorizedDomainsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAuthorizedDomainsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAuthorizedDomainsPagedResponse(ListAuthorizedDomainsPage page) {
      super(page, ListAuthorizedDomainsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAuthorizedDomainsPage
      extends AbstractPage<
          ListAuthorizedDomainsRequest,
          ListAuthorizedDomainsResponse,
          AuthorizedDomain,
          ListAuthorizedDomainsPage> {

    private ListAuthorizedDomainsPage(
        PageContext<ListAuthorizedDomainsRequest, ListAuthorizedDomainsResponse, AuthorizedDomain>
            context,
        ListAuthorizedDomainsResponse response) {
      super(context, response);
    }

    private static ListAuthorizedDomainsPage createEmptyPage() {
      return new ListAuthorizedDomainsPage(null, null);
    }

    @Override
    protected ListAuthorizedDomainsPage createPage(
        PageContext<ListAuthorizedDomainsRequest, ListAuthorizedDomainsResponse, AuthorizedDomain>
            context,
        ListAuthorizedDomainsResponse response) {
      return new ListAuthorizedDomainsPage(context, response);
    }

    @Override
    public ApiFuture<ListAuthorizedDomainsPage> createPageAsync(
        PageContext<ListAuthorizedDomainsRequest, ListAuthorizedDomainsResponse, AuthorizedDomain>
            context,
        ApiFuture<ListAuthorizedDomainsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAuthorizedDomainsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAuthorizedDomainsRequest,
          ListAuthorizedDomainsResponse,
          AuthorizedDomain,
          ListAuthorizedDomainsPage,
          ListAuthorizedDomainsFixedSizeCollection> {

    private ListAuthorizedDomainsFixedSizeCollection(
        List<ListAuthorizedDomainsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAuthorizedDomainsFixedSizeCollection createEmptyCollection() {
      return new ListAuthorizedDomainsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAuthorizedDomainsFixedSizeCollection createCollection(
        List<ListAuthorizedDomainsPage> pages, int collectionSize) {
      return new ListAuthorizedDomainsFixedSizeCollection(pages, collectionSize);
    }
  }
}
