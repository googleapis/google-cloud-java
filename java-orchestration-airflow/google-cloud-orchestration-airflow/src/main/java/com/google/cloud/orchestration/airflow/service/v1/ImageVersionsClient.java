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

package com.google.cloud.orchestration.airflow.service.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.orchestration.airflow.service.v1.stub.ImageVersionsStub;
import com.google.cloud.orchestration.airflow.service.v1.stub.ImageVersionsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Readonly service to query available ImageVersions.
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
 * try (ImageVersionsClient imageVersionsClient = ImageVersionsClient.create()) {
 *   String parent = "parent-995424086";
 *   for (ImageVersion element : imageVersionsClient.listImageVersions(parent).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ImageVersionsClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of ImageVersionsSettings to
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
 * ImageVersionsSettings imageVersionsSettings =
 *     ImageVersionsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ImageVersionsClient imageVersionsClient = ImageVersionsClient.create(imageVersionsSettings);
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
 * ImageVersionsSettings imageVersionsSettings =
 *     ImageVersionsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ImageVersionsClient imageVersionsClient = ImageVersionsClient.create(imageVersionsSettings);
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
 * ImageVersionsSettings imageVersionsSettings =
 *     ImageVersionsSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             ImageVersionsSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * ImageVersionsClient imageVersionsClient = ImageVersionsClient.create(imageVersionsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ImageVersionsClient implements BackgroundResource {
  private final ImageVersionsSettings settings;
  private final ImageVersionsStub stub;

  /** Constructs an instance of ImageVersionsClient with default settings. */
  public static final ImageVersionsClient create() throws IOException {
    return create(ImageVersionsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ImageVersionsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ImageVersionsClient create(ImageVersionsSettings settings)
      throws IOException {
    return new ImageVersionsClient(settings);
  }

  /**
   * Constructs an instance of ImageVersionsClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ImageVersionsSettings).
   */
  public static final ImageVersionsClient create(ImageVersionsStub stub) {
    return new ImageVersionsClient(stub);
  }

  /**
   * Constructs an instance of ImageVersionsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ImageVersionsClient(ImageVersionsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ImageVersionsStubSettings) settings.getStubSettings()).createStub();
  }

  protected ImageVersionsClient(ImageVersionsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ImageVersionsSettings getSettings() {
    return settings;
  }

  public ImageVersionsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List ImageVersions for provided location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ImageVersionsClient imageVersionsClient = ImageVersionsClient.create()) {
   *   String parent = "parent-995424086";
   *   for (ImageVersion element : imageVersionsClient.listImageVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent List ImageVersions in the given project and location, in the form:
   *     "projects/{projectId}/locations/{locationId}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListImageVersionsPagedResponse listImageVersions(String parent) {
    ListImageVersionsRequest request =
        ListImageVersionsRequest.newBuilder().setParent(parent).build();
    return listImageVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List ImageVersions for provided location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ImageVersionsClient imageVersionsClient = ImageVersionsClient.create()) {
   *   ListImageVersionsRequest request =
   *       ListImageVersionsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setIncludePastReleases(true)
   *           .build();
   *   for (ImageVersion element : imageVersionsClient.listImageVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListImageVersionsPagedResponse listImageVersions(ListImageVersionsRequest request) {
    return listImageVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List ImageVersions for provided location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ImageVersionsClient imageVersionsClient = ImageVersionsClient.create()) {
   *   ListImageVersionsRequest request =
   *       ListImageVersionsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setIncludePastReleases(true)
   *           .build();
   *   ApiFuture<ImageVersion> future =
   *       imageVersionsClient.listImageVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ImageVersion element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListImageVersionsRequest, ListImageVersionsPagedResponse>
      listImageVersionsPagedCallable() {
    return stub.listImageVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List ImageVersions for provided location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ImageVersionsClient imageVersionsClient = ImageVersionsClient.create()) {
   *   ListImageVersionsRequest request =
   *       ListImageVersionsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setIncludePastReleases(true)
   *           .build();
   *   while (true) {
   *     ListImageVersionsResponse response =
   *         imageVersionsClient.listImageVersionsCallable().call(request);
   *     for (ImageVersion element : response.getImageVersionsList()) {
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
  public final UnaryCallable<ListImageVersionsRequest, ListImageVersionsResponse>
      listImageVersionsCallable() {
    return stub.listImageVersionsCallable();
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

  public static class ListImageVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListImageVersionsRequest,
          ListImageVersionsResponse,
          ImageVersion,
          ListImageVersionsPage,
          ListImageVersionsFixedSizeCollection> {

    public static ApiFuture<ListImageVersionsPagedResponse> createAsync(
        PageContext<ListImageVersionsRequest, ListImageVersionsResponse, ImageVersion> context,
        ApiFuture<ListImageVersionsResponse> futureResponse) {
      ApiFuture<ListImageVersionsPage> futurePage =
          ListImageVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListImageVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListImageVersionsPagedResponse(ListImageVersionsPage page) {
      super(page, ListImageVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListImageVersionsPage
      extends AbstractPage<
          ListImageVersionsRequest,
          ListImageVersionsResponse,
          ImageVersion,
          ListImageVersionsPage> {

    private ListImageVersionsPage(
        PageContext<ListImageVersionsRequest, ListImageVersionsResponse, ImageVersion> context,
        ListImageVersionsResponse response) {
      super(context, response);
    }

    private static ListImageVersionsPage createEmptyPage() {
      return new ListImageVersionsPage(null, null);
    }

    @Override
    protected ListImageVersionsPage createPage(
        PageContext<ListImageVersionsRequest, ListImageVersionsResponse, ImageVersion> context,
        ListImageVersionsResponse response) {
      return new ListImageVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListImageVersionsPage> createPageAsync(
        PageContext<ListImageVersionsRequest, ListImageVersionsResponse, ImageVersion> context,
        ApiFuture<ListImageVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListImageVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListImageVersionsRequest,
          ListImageVersionsResponse,
          ImageVersion,
          ListImageVersionsPage,
          ListImageVersionsFixedSizeCollection> {

    private ListImageVersionsFixedSizeCollection(
        List<ListImageVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListImageVersionsFixedSizeCollection createEmptyCollection() {
      return new ListImageVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListImageVersionsFixedSizeCollection createCollection(
        List<ListImageVersionsPage> pages, int collectionSize) {
      return new ListImageVersionsFixedSizeCollection(pages, collectionSize);
    }
  }
}
