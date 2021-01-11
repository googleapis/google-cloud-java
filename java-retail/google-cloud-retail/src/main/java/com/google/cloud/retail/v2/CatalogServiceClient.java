/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.retail.v2;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2.stub.CatalogServiceStub;
import com.google.cloud.retail.v2.stub.CatalogServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing catalog configuration.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the CatalogServiceClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of CatalogServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * CatalogServiceSettings catalogServiceSettings =
 *     CatalogServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CatalogServiceClient catalogServiceClient = CatalogServiceClient.create(catalogServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * CatalogServiceSettings catalogServiceSettings =
 *     CatalogServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CatalogServiceClient catalogServiceClient = CatalogServiceClient.create(catalogServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CatalogServiceClient implements BackgroundResource {
  private final CatalogServiceSettings settings;
  private final CatalogServiceStub stub;

  /** Constructs an instance of CatalogServiceClient with default settings. */
  public static final CatalogServiceClient create() throws IOException {
    return create(CatalogServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CatalogServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CatalogServiceClient create(CatalogServiceSettings settings)
      throws IOException {
    return new CatalogServiceClient(settings);
  }

  /**
   * Constructs an instance of CatalogServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(CatalogServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final CatalogServiceClient create(CatalogServiceStub stub) {
    return new CatalogServiceClient(stub);
  }

  /**
   * Constructs an instance of CatalogServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CatalogServiceClient(CatalogServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CatalogServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected CatalogServiceClient(CatalogServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CatalogServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public CatalogServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [Catalog][google.cloud.retail.v2.Catalog]s associated with the project.
   *
   * @param parent Required. The account resource name with an associated location.
   *     <p>If the caller does not have permission to list
   *     [Catalog][google.cloud.retail.v2.Catalog]s under this location, regardless of whether or
   *     not this location exists, a PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCatalogsPagedResponse listCatalogs(LocationName parent) {
    ListCatalogsRequest request =
        ListCatalogsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCatalogs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [Catalog][google.cloud.retail.v2.Catalog]s associated with the project.
   *
   * @param parent Required. The account resource name with an associated location.
   *     <p>If the caller does not have permission to list
   *     [Catalog][google.cloud.retail.v2.Catalog]s under this location, regardless of whether or
   *     not this location exists, a PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCatalogsPagedResponse listCatalogs(String parent) {
    ListCatalogsRequest request = ListCatalogsRequest.newBuilder().setParent(parent).build();
    return listCatalogs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [Catalog][google.cloud.retail.v2.Catalog]s associated with the project.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCatalogsPagedResponse listCatalogs(ListCatalogsRequest request) {
    return listCatalogsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [Catalog][google.cloud.retail.v2.Catalog]s associated with the project.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListCatalogsRequest, ListCatalogsPagedResponse>
      listCatalogsPagedCallable() {
    return stub.listCatalogsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [Catalog][google.cloud.retail.v2.Catalog]s associated with the project.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListCatalogsRequest, ListCatalogsResponse> listCatalogsCallable() {
    return stub.listCatalogsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [Catalog][google.cloud.retail.v2.Catalog]s.
   *
   * @param catalog Required. The [Catalog][google.cloud.retail.v2.Catalog] to update.
   *     <p>If the caller does not have permission to update the
   *     [Catalog][google.cloud.retail.v2.Catalog], regardless of whether or not it exists, a
   *     PERMISSION_DENIED error is returned.
   *     <p>If the [Catalog][google.cloud.retail.v2.Catalog] to update does not exist, a NOT_FOUND
   *     error is returned.
   * @param updateMask Indicates which fields in the provided
   *     [Catalog][google.cloud.retail.v2.Catalog] to update. If not set, will only update the
   *     [Catalog.product_level_config][google.cloud.retail.v2.Catalog.product_level_config] field,
   *     which is also the only currently supported field to update.
   *     <p>If an unsupported or unknown field is provided, an INVALID_ARGUMENT error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Catalog updateCatalog(Catalog catalog, FieldMask updateMask) {
    UpdateCatalogRequest request =
        UpdateCatalogRequest.newBuilder().setCatalog(catalog).setUpdateMask(updateMask).build();
    return updateCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [Catalog][google.cloud.retail.v2.Catalog]s.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Catalog updateCatalog(UpdateCatalogRequest request) {
    return updateCatalogCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [Catalog][google.cloud.retail.v2.Catalog]s.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateCatalogRequest, Catalog> updateCatalogCallable() {
    return stub.updateCatalogCallable();
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

  public static class ListCatalogsPagedResponse
      extends AbstractPagedListResponse<
          ListCatalogsRequest,
          ListCatalogsResponse,
          Catalog,
          ListCatalogsPage,
          ListCatalogsFixedSizeCollection> {

    public static ApiFuture<ListCatalogsPagedResponse> createAsync(
        PageContext<ListCatalogsRequest, ListCatalogsResponse, Catalog> context,
        ApiFuture<ListCatalogsResponse> futureResponse) {
      ApiFuture<ListCatalogsPage> futurePage =
          ListCatalogsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListCatalogsPage, ListCatalogsPagedResponse>() {
            @Override
            public ListCatalogsPagedResponse apply(ListCatalogsPage input) {
              return new ListCatalogsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListCatalogsPagedResponse(ListCatalogsPage page) {
      super(page, ListCatalogsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCatalogsPage
      extends AbstractPage<ListCatalogsRequest, ListCatalogsResponse, Catalog, ListCatalogsPage> {

    private ListCatalogsPage(
        PageContext<ListCatalogsRequest, ListCatalogsResponse, Catalog> context,
        ListCatalogsResponse response) {
      super(context, response);
    }

    private static ListCatalogsPage createEmptyPage() {
      return new ListCatalogsPage(null, null);
    }

    @Override
    protected ListCatalogsPage createPage(
        PageContext<ListCatalogsRequest, ListCatalogsResponse, Catalog> context,
        ListCatalogsResponse response) {
      return new ListCatalogsPage(context, response);
    }

    @Override
    public ApiFuture<ListCatalogsPage> createPageAsync(
        PageContext<ListCatalogsRequest, ListCatalogsResponse, Catalog> context,
        ApiFuture<ListCatalogsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCatalogsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCatalogsRequest,
          ListCatalogsResponse,
          Catalog,
          ListCatalogsPage,
          ListCatalogsFixedSizeCollection> {

    private ListCatalogsFixedSizeCollection(List<ListCatalogsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCatalogsFixedSizeCollection createEmptyCollection() {
      return new ListCatalogsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCatalogsFixedSizeCollection createCollection(
        List<ListCatalogsPage> pages, int collectionSize) {
      return new ListCatalogsFixedSizeCollection(pages, collectionSize);
    }
  }
}
