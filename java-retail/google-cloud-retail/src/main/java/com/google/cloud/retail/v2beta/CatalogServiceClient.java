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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2beta.stub.CatalogServiceStub;
import com.google.cloud.retail.v2beta.stub.CatalogServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
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
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
 *   Catalog catalog = Catalog.newBuilder().build();
 *   FieldMask updateMask = FieldMask.newBuilder().build();
 *   Catalog response = catalogServiceClient.updateCatalog(catalog, updateMask);
 * }
 * }</pre>
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CatalogServiceSettings catalogServiceSettings =
 *     CatalogServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CatalogServiceClient catalogServiceClient = CatalogServiceClient.create(catalogServiceSettings);
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
 * CatalogServiceSettings catalogServiceSettings =
 *     CatalogServiceSettings.newHttpJsonBuilder().build();
 * CatalogServiceClient catalogServiceClient = CatalogServiceClient.create(catalogServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
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

  protected CatalogServiceClient(CatalogServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CatalogServiceSettings getSettings() {
    return settings;
  }

  public CatalogServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [Catalog][google.cloud.retail.v2beta.Catalog]s associated with the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Catalog element : catalogServiceClient.listCatalogs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The account resource name with an associated location.
   *     <p>If the caller does not have permission to list
   *     [Catalog][google.cloud.retail.v2beta.Catalog]s under this location, regardless of whether
   *     or not this location exists, a PERMISSION_DENIED error is returned.
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
   * Lists all the [Catalog][google.cloud.retail.v2beta.Catalog]s associated with the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Catalog element : catalogServiceClient.listCatalogs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The account resource name with an associated location.
   *     <p>If the caller does not have permission to list
   *     [Catalog][google.cloud.retail.v2beta.Catalog]s under this location, regardless of whether
   *     or not this location exists, a PERMISSION_DENIED error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCatalogsPagedResponse listCatalogs(String parent) {
    ListCatalogsRequest request = ListCatalogsRequest.newBuilder().setParent(parent).build();
    return listCatalogs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [Catalog][google.cloud.retail.v2beta.Catalog]s associated with the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   ListCatalogsRequest request =
   *       ListCatalogsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Catalog element : catalogServiceClient.listCatalogs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCatalogsPagedResponse listCatalogs(ListCatalogsRequest request) {
    return listCatalogsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [Catalog][google.cloud.retail.v2beta.Catalog]s associated with the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   ListCatalogsRequest request =
   *       ListCatalogsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Catalog> future =
   *       catalogServiceClient.listCatalogsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Catalog element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCatalogsRequest, ListCatalogsPagedResponse>
      listCatalogsPagedCallable() {
    return stub.listCatalogsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [Catalog][google.cloud.retail.v2beta.Catalog]s associated with the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   ListCatalogsRequest request =
   *       ListCatalogsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListCatalogsResponse response = catalogServiceClient.listCatalogsCallable().call(request);
   *     for (Catalog element : response.getCatalogsList()) {
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
  public final UnaryCallable<ListCatalogsRequest, ListCatalogsResponse> listCatalogsCallable() {
    return stub.listCatalogsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [Catalog][google.cloud.retail.v2beta.Catalog]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   Catalog catalog = Catalog.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Catalog response = catalogServiceClient.updateCatalog(catalog, updateMask);
   * }
   * }</pre>
   *
   * @param catalog Required. The [Catalog][google.cloud.retail.v2beta.Catalog] to update.
   *     <p>If the caller does not have permission to update the
   *     [Catalog][google.cloud.retail.v2beta.Catalog], regardless of whether or not it exists, a
   *     PERMISSION_DENIED error is returned.
   *     <p>If the [Catalog][google.cloud.retail.v2beta.Catalog] to update does not exist, a
   *     NOT_FOUND error is returned.
   * @param updateMask Indicates which fields in the provided
   *     [Catalog][google.cloud.retail.v2beta.Catalog] to update.
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
   * Updates the [Catalog][google.cloud.retail.v2beta.Catalog]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   UpdateCatalogRequest request =
   *       UpdateCatalogRequest.newBuilder()
   *           .setCatalog(Catalog.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Catalog response = catalogServiceClient.updateCatalog(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Catalog updateCatalog(UpdateCatalogRequest request) {
    return updateCatalogCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [Catalog][google.cloud.retail.v2beta.Catalog]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   UpdateCatalogRequest request =
   *       UpdateCatalogRequest.newBuilder()
   *           .setCatalog(Catalog.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Catalog> future = catalogServiceClient.updateCatalogCallable().futureCall(request);
   *   // Do something.
   *   Catalog response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCatalogRequest, Catalog> updateCatalogCallable() {
    return stub.updateCatalogCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Set a specified branch id as default branch. API methods such as
   * [SearchService.Search][google.cloud.retail.v2beta.SearchService.Search],
   * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct],
   * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts] will
   * treat requests using "default_branch" to the actual branch id set as default.
   *
   * <p>For example, if `projects/&#42;/locations/&#42;/catalogs/&#42;/branches/1` is set as
   * default, setting [SearchRequest.branch][google.cloud.retail.v2beta.SearchRequest.branch] to
   * `projects/&#42;/locations/&#42;/catalogs/&#42;/branches/default_branch` is equivalent to
   * setting [SearchRequest.branch][google.cloud.retail.v2beta.SearchRequest.branch] to
   * `projects/&#42;/locations/&#42;/catalogs/&#42;/branches/1`.
   *
   * <p>Using multiple branches can be useful when developers would like to have a staging branch to
   * test and verify for future usage. When it becomes ready, developers switch on the staging
   * branch using this API while keeping using
   * `projects/&#42;/locations/&#42;/catalogs/&#42;/branches/default_branch` as
   * [SearchRequest.branch][google.cloud.retail.v2beta.SearchRequest.branch] to route the traffic to
   * this staging branch.
   *
   * <p>CAUTION: If you have live predict/search traffic, switching the default branch could
   * potentially cause outages if the ID space of the new branch is very different from the old one.
   *
   * <p>More specifically:
   *
   * <ul>
   *   <li>PredictionService will only return product IDs from branch {newBranch}.
   *   <li>SearchService will only return product IDs from branch {newBranch} (if branch is not
   *       explicitly set).
   *   <li>UserEventService will only join events with products from branch {newBranch}.
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
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   CatalogName catalog = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   catalogServiceClient.setDefaultBranch(catalog);
   * }
   * }</pre>
   *
   * @param catalog Full resource name of the catalog, such as
   *     `projects/&#42;/locations/global/catalogs/default_catalog`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void setDefaultBranch(CatalogName catalog) {
    SetDefaultBranchRequest request =
        SetDefaultBranchRequest.newBuilder()
            .setCatalog(catalog == null ? null : catalog.toString())
            .build();
    setDefaultBranch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Set a specified branch id as default branch. API methods such as
   * [SearchService.Search][google.cloud.retail.v2beta.SearchService.Search],
   * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct],
   * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts] will
   * treat requests using "default_branch" to the actual branch id set as default.
   *
   * <p>For example, if `projects/&#42;/locations/&#42;/catalogs/&#42;/branches/1` is set as
   * default, setting [SearchRequest.branch][google.cloud.retail.v2beta.SearchRequest.branch] to
   * `projects/&#42;/locations/&#42;/catalogs/&#42;/branches/default_branch` is equivalent to
   * setting [SearchRequest.branch][google.cloud.retail.v2beta.SearchRequest.branch] to
   * `projects/&#42;/locations/&#42;/catalogs/&#42;/branches/1`.
   *
   * <p>Using multiple branches can be useful when developers would like to have a staging branch to
   * test and verify for future usage. When it becomes ready, developers switch on the staging
   * branch using this API while keeping using
   * `projects/&#42;/locations/&#42;/catalogs/&#42;/branches/default_branch` as
   * [SearchRequest.branch][google.cloud.retail.v2beta.SearchRequest.branch] to route the traffic to
   * this staging branch.
   *
   * <p>CAUTION: If you have live predict/search traffic, switching the default branch could
   * potentially cause outages if the ID space of the new branch is very different from the old one.
   *
   * <p>More specifically:
   *
   * <ul>
   *   <li>PredictionService will only return product IDs from branch {newBranch}.
   *   <li>SearchService will only return product IDs from branch {newBranch} (if branch is not
   *       explicitly set).
   *   <li>UserEventService will only join events with products from branch {newBranch}.
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
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String catalog = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString();
   *   catalogServiceClient.setDefaultBranch(catalog);
   * }
   * }</pre>
   *
   * @param catalog Full resource name of the catalog, such as
   *     `projects/&#42;/locations/global/catalogs/default_catalog`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void setDefaultBranch(String catalog) {
    SetDefaultBranchRequest request =
        SetDefaultBranchRequest.newBuilder().setCatalog(catalog).build();
    setDefaultBranch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Set a specified branch id as default branch. API methods such as
   * [SearchService.Search][google.cloud.retail.v2beta.SearchService.Search],
   * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct],
   * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts] will
   * treat requests using "default_branch" to the actual branch id set as default.
   *
   * <p>For example, if `projects/&#42;/locations/&#42;/catalogs/&#42;/branches/1` is set as
   * default, setting [SearchRequest.branch][google.cloud.retail.v2beta.SearchRequest.branch] to
   * `projects/&#42;/locations/&#42;/catalogs/&#42;/branches/default_branch` is equivalent to
   * setting [SearchRequest.branch][google.cloud.retail.v2beta.SearchRequest.branch] to
   * `projects/&#42;/locations/&#42;/catalogs/&#42;/branches/1`.
   *
   * <p>Using multiple branches can be useful when developers would like to have a staging branch to
   * test and verify for future usage. When it becomes ready, developers switch on the staging
   * branch using this API while keeping using
   * `projects/&#42;/locations/&#42;/catalogs/&#42;/branches/default_branch` as
   * [SearchRequest.branch][google.cloud.retail.v2beta.SearchRequest.branch] to route the traffic to
   * this staging branch.
   *
   * <p>CAUTION: If you have live predict/search traffic, switching the default branch could
   * potentially cause outages if the ID space of the new branch is very different from the old one.
   *
   * <p>More specifically:
   *
   * <ul>
   *   <li>PredictionService will only return product IDs from branch {newBranch}.
   *   <li>SearchService will only return product IDs from branch {newBranch} (if branch is not
   *       explicitly set).
   *   <li>UserEventService will only join events with products from branch {newBranch}.
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
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   SetDefaultBranchRequest request =
   *       SetDefaultBranchRequest.newBuilder()
   *           .setCatalog(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setBranchId(
   *               BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
   *           .setNote("note3387378")
   *           .setForce(true)
   *           .build();
   *   catalogServiceClient.setDefaultBranch(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void setDefaultBranch(SetDefaultBranchRequest request) {
    setDefaultBranchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Set a specified branch id as default branch. API methods such as
   * [SearchService.Search][google.cloud.retail.v2beta.SearchService.Search],
   * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct],
   * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts] will
   * treat requests using "default_branch" to the actual branch id set as default.
   *
   * <p>For example, if `projects/&#42;/locations/&#42;/catalogs/&#42;/branches/1` is set as
   * default, setting [SearchRequest.branch][google.cloud.retail.v2beta.SearchRequest.branch] to
   * `projects/&#42;/locations/&#42;/catalogs/&#42;/branches/default_branch` is equivalent to
   * setting [SearchRequest.branch][google.cloud.retail.v2beta.SearchRequest.branch] to
   * `projects/&#42;/locations/&#42;/catalogs/&#42;/branches/1`.
   *
   * <p>Using multiple branches can be useful when developers would like to have a staging branch to
   * test and verify for future usage. When it becomes ready, developers switch on the staging
   * branch using this API while keeping using
   * `projects/&#42;/locations/&#42;/catalogs/&#42;/branches/default_branch` as
   * [SearchRequest.branch][google.cloud.retail.v2beta.SearchRequest.branch] to route the traffic to
   * this staging branch.
   *
   * <p>CAUTION: If you have live predict/search traffic, switching the default branch could
   * potentially cause outages if the ID space of the new branch is very different from the old one.
   *
   * <p>More specifically:
   *
   * <ul>
   *   <li>PredictionService will only return product IDs from branch {newBranch}.
   *   <li>SearchService will only return product IDs from branch {newBranch} (if branch is not
   *       explicitly set).
   *   <li>UserEventService will only join events with products from branch {newBranch}.
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
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   SetDefaultBranchRequest request =
   *       SetDefaultBranchRequest.newBuilder()
   *           .setCatalog(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setBranchId(
   *               BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
   *           .setNote("note3387378")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future = catalogServiceClient.setDefaultBranchCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetDefaultBranchRequest, Empty> setDefaultBranchCallable() {
    return stub.setDefaultBranchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get which branch is currently default branch set by
   * [CatalogService.SetDefaultBranch][google.cloud.retail.v2beta.CatalogService.SetDefaultBranch]
   * method under a specified parent catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   CatalogName catalog = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   GetDefaultBranchResponse response = catalogServiceClient.getDefaultBranch(catalog);
   * }
   * }</pre>
   *
   * @param catalog The parent catalog resource name, such as
   *     `projects/&#42;/locations/global/catalogs/default_catalog`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetDefaultBranchResponse getDefaultBranch(CatalogName catalog) {
    GetDefaultBranchRequest request =
        GetDefaultBranchRequest.newBuilder()
            .setCatalog(catalog == null ? null : catalog.toString())
            .build();
    return getDefaultBranch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get which branch is currently default branch set by
   * [CatalogService.SetDefaultBranch][google.cloud.retail.v2beta.CatalogService.SetDefaultBranch]
   * method under a specified parent catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String catalog = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString();
   *   GetDefaultBranchResponse response = catalogServiceClient.getDefaultBranch(catalog);
   * }
   * }</pre>
   *
   * @param catalog The parent catalog resource name, such as
   *     `projects/&#42;/locations/global/catalogs/default_catalog`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetDefaultBranchResponse getDefaultBranch(String catalog) {
    GetDefaultBranchRequest request =
        GetDefaultBranchRequest.newBuilder().setCatalog(catalog).build();
    return getDefaultBranch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get which branch is currently default branch set by
   * [CatalogService.SetDefaultBranch][google.cloud.retail.v2beta.CatalogService.SetDefaultBranch]
   * method under a specified parent catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   GetDefaultBranchRequest request =
   *       GetDefaultBranchRequest.newBuilder()
   *           .setCatalog(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .build();
   *   GetDefaultBranchResponse response = catalogServiceClient.getDefaultBranch(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetDefaultBranchResponse getDefaultBranch(GetDefaultBranchRequest request) {
    return getDefaultBranchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get which branch is currently default branch set by
   * [CatalogService.SetDefaultBranch][google.cloud.retail.v2beta.CatalogService.SetDefaultBranch]
   * method under a specified parent catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   GetDefaultBranchRequest request =
   *       GetDefaultBranchRequest.newBuilder()
   *           .setCatalog(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .build();
   *   ApiFuture<GetDefaultBranchResponse> future =
   *       catalogServiceClient.getDefaultBranchCallable().futureCall(request);
   *   // Do something.
   *   GetDefaultBranchResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDefaultBranchRequest, GetDefaultBranchResponse>
      getDefaultBranchCallable() {
    return stub.getDefaultBranchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [CompletionConfig][google.cloud.retail.v2beta.CompletionConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   CompletionConfigName name = CompletionConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   CompletionConfig response = catalogServiceClient.getCompletionConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Full CompletionConfig resource name. Format:
   *     `projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/completionConfig`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CompletionConfig getCompletionConfig(CompletionConfigName name) {
    GetCompletionConfigRequest request =
        GetCompletionConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCompletionConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [CompletionConfig][google.cloud.retail.v2beta.CompletionConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String name = CompletionConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString();
   *   CompletionConfig response = catalogServiceClient.getCompletionConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Full CompletionConfig resource name. Format:
   *     `projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/completionConfig`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CompletionConfig getCompletionConfig(String name) {
    GetCompletionConfigRequest request =
        GetCompletionConfigRequest.newBuilder().setName(name).build();
    return getCompletionConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [CompletionConfig][google.cloud.retail.v2beta.CompletionConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   GetCompletionConfigRequest request =
   *       GetCompletionConfigRequest.newBuilder()
   *           .setName(CompletionConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .build();
   *   CompletionConfig response = catalogServiceClient.getCompletionConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CompletionConfig getCompletionConfig(GetCompletionConfigRequest request) {
    return getCompletionConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [CompletionConfig][google.cloud.retail.v2beta.CompletionConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   GetCompletionConfigRequest request =
   *       GetCompletionConfigRequest.newBuilder()
   *           .setName(CompletionConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .build();
   *   ApiFuture<CompletionConfig> future =
   *       catalogServiceClient.getCompletionConfigCallable().futureCall(request);
   *   // Do something.
   *   CompletionConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCompletionConfigRequest, CompletionConfig>
      getCompletionConfigCallable() {
    return stub.getCompletionConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [CompletionConfig][google.cloud.retail.v2beta.CompletionConfig]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   CompletionConfig completionConfig = CompletionConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CompletionConfig response =
   *       catalogServiceClient.updateCompletionConfig(completionConfig, updateMask);
   * }
   * }</pre>
   *
   * @param completionConfig Required. The
   *     [CompletionConfig][google.cloud.retail.v2beta.CompletionConfig] to update.
   *     <p>If the caller does not have permission to update the
   *     [CompletionConfig][google.cloud.retail.v2beta.CompletionConfig], then a PERMISSION_DENIED
   *     error is returned.
   *     <p>If the [CompletionConfig][google.cloud.retail.v2beta.CompletionConfig] to update does
   *     not exist, a NOT_FOUND error is returned.
   * @param updateMask Indicates which fields in the provided
   *     [CompletionConfig][google.cloud.retail.v2beta.CompletionConfig] to update. The following
   *     are the only supported fields:
   *     <ul>
   *       <li>[CompletionConfig.matching_order][google.cloud.retail.v2beta.CompletionConfig.matching_order]
   *       <li>[CompletionConfig.max_suggestions][google.cloud.retail.v2beta.CompletionConfig.max_suggestions]
   *       <li>[CompletionConfig.min_prefix_length][google.cloud.retail.v2beta.CompletionConfig.min_prefix_length]
   *       <li>[CompletionConfig.auto_learning][google.cloud.retail.v2beta.CompletionConfig.auto_learning]
   *     </ul>
   *     <p>If not set, all supported fields are updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CompletionConfig updateCompletionConfig(
      CompletionConfig completionConfig, FieldMask updateMask) {
    UpdateCompletionConfigRequest request =
        UpdateCompletionConfigRequest.newBuilder()
            .setCompletionConfig(completionConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateCompletionConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [CompletionConfig][google.cloud.retail.v2beta.CompletionConfig]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   UpdateCompletionConfigRequest request =
   *       UpdateCompletionConfigRequest.newBuilder()
   *           .setCompletionConfig(CompletionConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   CompletionConfig response = catalogServiceClient.updateCompletionConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CompletionConfig updateCompletionConfig(UpdateCompletionConfigRequest request) {
    return updateCompletionConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [CompletionConfig][google.cloud.retail.v2beta.CompletionConfig]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   UpdateCompletionConfigRequest request =
   *       UpdateCompletionConfigRequest.newBuilder()
   *           .setCompletionConfig(CompletionConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<CompletionConfig> future =
   *       catalogServiceClient.updateCompletionConfigCallable().futureCall(request);
   *   // Do something.
   *   CompletionConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCompletionConfigRequest, CompletionConfig>
      updateCompletionConfigCallable() {
    return stub.updateCompletionConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   AttributesConfigName name = AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   AttributesConfig response = catalogServiceClient.getAttributesConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Full AttributesConfig resource name. Format:
   *     `projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/attributesConfig`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AttributesConfig getAttributesConfig(AttributesConfigName name) {
    GetAttributesConfigRequest request =
        GetAttributesConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAttributesConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String name = AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString();
   *   AttributesConfig response = catalogServiceClient.getAttributesConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Full AttributesConfig resource name. Format:
   *     `projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/attributesConfig`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AttributesConfig getAttributesConfig(String name) {
    GetAttributesConfigRequest request =
        GetAttributesConfigRequest.newBuilder().setName(name).build();
    return getAttributesConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   GetAttributesConfigRequest request =
   *       GetAttributesConfigRequest.newBuilder()
   *           .setName(AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .build();
   *   AttributesConfig response = catalogServiceClient.getAttributesConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AttributesConfig getAttributesConfig(GetAttributesConfigRequest request) {
    return getAttributesConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   GetAttributesConfigRequest request =
   *       GetAttributesConfigRequest.newBuilder()
   *           .setName(AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .build();
   *   ApiFuture<AttributesConfig> future =
   *       catalogServiceClient.getAttributesConfigCallable().futureCall(request);
   *   // Do something.
   *   AttributesConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAttributesConfigRequest, AttributesConfig>
      getAttributesConfigCallable() {
    return stub.getAttributesConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
   *
   * <p>The catalog attributes in the request will be updated in the catalog, or inserted if they do
   * not exist. Existing catalog attributes not included in the request will remain unchanged.
   * Attributes that are assigned to products, but do not exist at the catalog level, are always
   * included in the response. The product attribute is assigned default values for missing catalog
   * attribute fields, e.g., searchable and dynamic facetable options.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   AttributesConfig attributesConfig = AttributesConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AttributesConfig response =
   *       catalogServiceClient.updateAttributesConfig(attributesConfig, updateMask);
   * }
   * }</pre>
   *
   * @param attributesConfig Required. The
   *     [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig] to update.
   * @param updateMask Indicates which fields in the provided
   *     [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig] to update. The following is
   *     the only supported field:
   *     <ul>
   *       <li>[AttributesConfig.catalog_attributes][google.cloud.retail.v2beta.AttributesConfig.catalog_attributes]
   *     </ul>
   *     <p>If not set, all supported fields are updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AttributesConfig updateAttributesConfig(
      AttributesConfig attributesConfig, FieldMask updateMask) {
    UpdateAttributesConfigRequest request =
        UpdateAttributesConfigRequest.newBuilder()
            .setAttributesConfig(attributesConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateAttributesConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
   *
   * <p>The catalog attributes in the request will be updated in the catalog, or inserted if they do
   * not exist. Existing catalog attributes not included in the request will remain unchanged.
   * Attributes that are assigned to products, but do not exist at the catalog level, are always
   * included in the response. The product attribute is assigned default values for missing catalog
   * attribute fields, e.g., searchable and dynamic facetable options.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   UpdateAttributesConfigRequest request =
   *       UpdateAttributesConfigRequest.newBuilder()
   *           .setAttributesConfig(AttributesConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AttributesConfig response = catalogServiceClient.updateAttributesConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AttributesConfig updateAttributesConfig(UpdateAttributesConfigRequest request) {
    return updateAttributesConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
   *
   * <p>The catalog attributes in the request will be updated in the catalog, or inserted if they do
   * not exist. Existing catalog attributes not included in the request will remain unchanged.
   * Attributes that are assigned to products, but do not exist at the catalog level, are always
   * included in the response. The product attribute is assigned default values for missing catalog
   * attribute fields, e.g., searchable and dynamic facetable options.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   UpdateAttributesConfigRequest request =
   *       UpdateAttributesConfigRequest.newBuilder()
   *           .setAttributesConfig(AttributesConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<AttributesConfig> future =
   *       catalogServiceClient.updateAttributesConfigCallable().futureCall(request);
   *   // Do something.
   *   AttributesConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAttributesConfigRequest, AttributesConfig>
      updateAttributesConfigCallable() {
    return stub.updateAttributesConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds the specified [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to the
   * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
   *
   * <p>If the [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to add already
   * exists, an ALREADY_EXISTS error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   AddCatalogAttributeRequest request =
   *       AddCatalogAttributeRequest.newBuilder()
   *           .setAttributesConfig(
   *               AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setCatalogAttribute(CatalogAttribute.newBuilder().build())
   *           .build();
   *   AttributesConfig response = catalogServiceClient.addCatalogAttribute(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AttributesConfig addCatalogAttribute(AddCatalogAttributeRequest request) {
    return addCatalogAttributeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds the specified [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to the
   * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
   *
   * <p>If the [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to add already
   * exists, an ALREADY_EXISTS error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   AddCatalogAttributeRequest request =
   *       AddCatalogAttributeRequest.newBuilder()
   *           .setAttributesConfig(
   *               AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setCatalogAttribute(CatalogAttribute.newBuilder().build())
   *           .build();
   *   ApiFuture<AttributesConfig> future =
   *       catalogServiceClient.addCatalogAttributeCallable().futureCall(request);
   *   // Do something.
   *   AttributesConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddCatalogAttributeRequest, AttributesConfig>
      addCatalogAttributeCallable() {
    return stub.addCatalogAttributeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes the specified [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] from the
   * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
   *
   * <p>If the [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to remove does not
   * exist, a NOT_FOUND error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   RemoveCatalogAttributeRequest request =
   *       RemoveCatalogAttributeRequest.newBuilder()
   *           .setAttributesConfig(
   *               AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setKey("key106079")
   *           .build();
   *   AttributesConfig response = catalogServiceClient.removeCatalogAttribute(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AttributesConfig removeCatalogAttribute(RemoveCatalogAttributeRequest request) {
    return removeCatalogAttributeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes the specified [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] from the
   * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
   *
   * <p>If the [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to remove does not
   * exist, a NOT_FOUND error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   RemoveCatalogAttributeRequest request =
   *       RemoveCatalogAttributeRequest.newBuilder()
   *           .setAttributesConfig(
   *               AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setKey("key106079")
   *           .build();
   *   ApiFuture<AttributesConfig> future =
   *       catalogServiceClient.removeCatalogAttributeCallable().futureCall(request);
   *   // Do something.
   *   AttributesConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveCatalogAttributeRequest, AttributesConfig>
      removeCatalogAttributeCallable() {
    return stub.removeCatalogAttributeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes all specified [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute]s from the
   * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   BatchRemoveCatalogAttributesRequest request =
   *       BatchRemoveCatalogAttributesRequest.newBuilder()
   *           .setAttributesConfig(
   *               AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .addAllAttributeKeys(new ArrayList<String>())
   *           .build();
   *   BatchRemoveCatalogAttributesResponse response =
   *       catalogServiceClient.batchRemoveCatalogAttributes(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRemoveCatalogAttributesResponse batchRemoveCatalogAttributes(
      BatchRemoveCatalogAttributesRequest request) {
    return batchRemoveCatalogAttributesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes all specified [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute]s from the
   * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   BatchRemoveCatalogAttributesRequest request =
   *       BatchRemoveCatalogAttributesRequest.newBuilder()
   *           .setAttributesConfig(
   *               AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .addAllAttributeKeys(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchRemoveCatalogAttributesResponse> future =
   *       catalogServiceClient.batchRemoveCatalogAttributesCallable().futureCall(request);
   *   // Do something.
   *   BatchRemoveCatalogAttributesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchRemoveCatalogAttributesRequest, BatchRemoveCatalogAttributesResponse>
      batchRemoveCatalogAttributesCallable() {
    return stub.batchRemoveCatalogAttributesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Replaces the specified [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] in the
   * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig] by updating the catalog
   * attribute with the same
   * [CatalogAttribute.key][google.cloud.retail.v2beta.CatalogAttribute.key].
   *
   * <p>If the [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to replace does not
   * exist, a NOT_FOUND error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   ReplaceCatalogAttributeRequest request =
   *       ReplaceCatalogAttributeRequest.newBuilder()
   *           .setAttributesConfig(
   *               AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setCatalogAttribute(CatalogAttribute.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AttributesConfig response = catalogServiceClient.replaceCatalogAttribute(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AttributesConfig replaceCatalogAttribute(ReplaceCatalogAttributeRequest request) {
    return replaceCatalogAttributeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Replaces the specified [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] in the
   * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig] by updating the catalog
   * attribute with the same
   * [CatalogAttribute.key][google.cloud.retail.v2beta.CatalogAttribute.key].
   *
   * <p>If the [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to replace does not
   * exist, a NOT_FOUND error is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   ReplaceCatalogAttributeRequest request =
   *       ReplaceCatalogAttributeRequest.newBuilder()
   *           .setAttributesConfig(
   *               AttributesConfigName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setCatalogAttribute(CatalogAttribute.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<AttributesConfig> future =
   *       catalogServiceClient.replaceCatalogAttributeCallable().futureCall(request);
   *   // Do something.
   *   AttributesConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReplaceCatalogAttributeRequest, AttributesConfig>
      replaceCatalogAttributeCallable() {
    return stub.replaceCatalogAttributeCallable();
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
          input -> new ListCatalogsPagedResponse(input),
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
