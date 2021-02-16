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

package com.google.cloud.vision.v1p3beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.vision.v1p3beta1.stub.ProductSearchStub;
import com.google.cloud.vision.v1p3beta1.stub.ProductSearchStubSettings;
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
 * Service Description: Manages Products and ProductSets of reference images for use in product
 * search. It uses the following resource model:
 *
 * <p>- The API has a collection of [ProductSet][google.cloud.vision.v1p3beta1.ProductSet]
 * resources, named `projects/&#42;/locations/&#42;/productSets/&#42;`, which acts as a way to put
 * different products into groups to limit identification.
 *
 * <p>In parallel,
 *
 * <p>- The API has a collection of [Product][google.cloud.vision.v1p3beta1.Product] resources,
 * named `projects/&#42;/locations/&#42;/products/&#42;`
 *
 * <p>- Each [Product][google.cloud.vision.v1p3beta1.Product] has a collection of
 * [ReferenceImage][google.cloud.vision.v1p3beta1.ReferenceImage] resources, named
 * `projects/&#42;/locations/&#42;/products/&#42;/referenceImages/&#42;`
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   ProductSet productSet = ProductSet.newBuilder().build();
 *   String productSetId = "productSetId1003042158";
 *   ProductSet response = productSearchClient.createProductSet(parent, productSet, productSetId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ProductSearchClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of ProductSearchSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * ProductSearchSettings productSearchSettings =
 *     ProductSearchSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ProductSearchClient productSearchClient = ProductSearchClient.create(productSearchSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * ProductSearchSettings productSearchSettings =
 *     ProductSearchSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ProductSearchClient productSearchClient = ProductSearchClient.create(productSearchSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ProductSearchClient implements BackgroundResource {
  private final ProductSearchSettings settings;
  private final ProductSearchStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of ProductSearchClient with default settings. */
  public static final ProductSearchClient create() throws IOException {
    return create(ProductSearchSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ProductSearchClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ProductSearchClient create(ProductSearchSettings settings)
      throws IOException {
    return new ProductSearchClient(settings);
  }

  /**
   * Constructs an instance of ProductSearchClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ProductSearchSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ProductSearchClient create(ProductSearchStub stub) {
    return new ProductSearchClient(stub);
  }

  /**
   * Constructs an instance of ProductSearchClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ProductSearchClient(ProductSearchSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ProductSearchStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ProductSearchClient(ProductSearchStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final ProductSearchSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ProductSearchStub getStub() {
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
   * Creates and returns a new ProductSet resource.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if display_name is missing, or is longer than 4096 characters.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ProductSet productSet = ProductSet.newBuilder().build();
   *   String productSetId = "productSetId1003042158";
   *   ProductSet response = productSearchClient.createProductSet(parent, productSet, productSetId);
   * }
   * }</pre>
   *
   * @param parent Required. The project in which the ProductSet should be created.
   *     <p>Format is `projects/PROJECT_ID/locations/LOC_ID`.
   * @param productSet Required. The ProductSet to create.
   * @param productSetId A user-supplied resource id for this ProductSet. If set, the server will
   *     attempt to use this value as the resource id. If it is already in use, an error is returned
   *     with code ALREADY_EXISTS. Must be at most 128 characters long. It cannot contain the
   *     character `/`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProductSet createProductSet(
      LocationName parent, ProductSet productSet, String productSetId) {
    CreateProductSetRequest request =
        CreateProductSetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setProductSet(productSet)
            .setProductSetId(productSetId)
            .build();
    return createProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and returns a new ProductSet resource.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if display_name is missing, or is longer than 4096 characters.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ProductSet productSet = ProductSet.newBuilder().build();
   *   String productSetId = "productSetId1003042158";
   *   ProductSet response = productSearchClient.createProductSet(parent, productSet, productSetId);
   * }
   * }</pre>
   *
   * @param parent Required. The project in which the ProductSet should be created.
   *     <p>Format is `projects/PROJECT_ID/locations/LOC_ID`.
   * @param productSet Required. The ProductSet to create.
   * @param productSetId A user-supplied resource id for this ProductSet. If set, the server will
   *     attempt to use this value as the resource id. If it is already in use, an error is returned
   *     with code ALREADY_EXISTS. Must be at most 128 characters long. It cannot contain the
   *     character `/`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProductSet createProductSet(
      String parent, ProductSet productSet, String productSetId) {
    CreateProductSetRequest request =
        CreateProductSetRequest.newBuilder()
            .setParent(parent)
            .setProductSet(productSet)
            .setProductSetId(productSetId)
            .build();
    return createProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and returns a new ProductSet resource.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if display_name is missing, or is longer than 4096 characters.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   CreateProductSetRequest request =
   *       CreateProductSetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setProductSet(ProductSet.newBuilder().build())
   *           .setProductSetId("productSetId1003042158")
   *           .build();
   *   ProductSet response = productSearchClient.createProductSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProductSet createProductSet(CreateProductSetRequest request) {
    return createProductSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and returns a new ProductSet resource.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if display_name is missing, or is longer than 4096 characters.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   CreateProductSetRequest request =
   *       CreateProductSetRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setProductSet(ProductSet.newBuilder().build())
   *           .setProductSetId("productSetId1003042158")
   *           .build();
   *   ApiFuture<ProductSet> future =
   *       productSearchClient.createProductSetCallable().futureCall(request);
   *   // Do something.
   *   ProductSet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateProductSetRequest, ProductSet> createProductSetCallable() {
    return stub.createProductSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ProductSets in an unspecified order.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if page_size is greater than 100, or less than 1.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ProductSet element : productSearchClient.listProductSets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project from which ProductSets should be listed.
   *     <p>Format is `projects/PROJECT_ID/locations/LOC_ID`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductSetsPagedResponse listProductSets(LocationName parent) {
    ListProductSetsRequest request =
        ListProductSetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listProductSets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ProductSets in an unspecified order.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if page_size is greater than 100, or less than 1.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ProductSet element : productSearchClient.listProductSets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project from which ProductSets should be listed.
   *     <p>Format is `projects/PROJECT_ID/locations/LOC_ID`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductSetsPagedResponse listProductSets(String parent) {
    ListProductSetsRequest request = ListProductSetsRequest.newBuilder().setParent(parent).build();
    return listProductSets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ProductSets in an unspecified order.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if page_size is greater than 100, or less than 1.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ListProductSetsRequest request =
   *       ListProductSetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ProductSet element : productSearchClient.listProductSets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductSetsPagedResponse listProductSets(ListProductSetsRequest request) {
    return listProductSetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ProductSets in an unspecified order.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if page_size is greater than 100, or less than 1.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ListProductSetsRequest request =
   *       ListProductSetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ProductSet> future =
   *       productSearchClient.listProductSetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ProductSet element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListProductSetsRequest, ListProductSetsPagedResponse>
      listProductSetsPagedCallable() {
    return stub.listProductSetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ProductSets in an unspecified order.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if page_size is greater than 100, or less than 1.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   while (true) {
   *     ListProductSetsResponse response =
   *         productSearchClient.listProductSetsCallable().call(request);
   *     for (ProductSet element : response.getResponsesList()) {
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
  public final UnaryCallable<ListProductSetsRequest, ListProductSetsResponse>
      listProductSetsCallable() {
    return stub.listProductSetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information associated with a ProductSet.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the ProductSet does not exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   ProductSet response = productSearchClient.getProductSet(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the ProductSet to get.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProductSet getProductSet(ProductSetName name) {
    GetProductSetRequest request =
        GetProductSetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information associated with a ProductSet.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the ProductSet does not exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   String name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]").toString();
   *   ProductSet response = productSearchClient.getProductSet(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the ProductSet to get.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProductSet getProductSet(String name) {
    GetProductSetRequest request = GetProductSetRequest.newBuilder().setName(name).build();
    return getProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information associated with a ProductSet.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the ProductSet does not exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   GetProductSetRequest request =
   *       GetProductSetRequest.newBuilder()
   *           .setName(ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]").toString())
   *           .build();
   *   ProductSet response = productSearchClient.getProductSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProductSet getProductSet(GetProductSetRequest request) {
    return getProductSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information associated with a ProductSet.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the ProductSet does not exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   GetProductSetRequest request =
   *       GetProductSetRequest.newBuilder()
   *           .setName(ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]").toString())
   *           .build();
   *   ApiFuture<ProductSet> future =
   *       productSearchClient.getProductSetCallable().futureCall(request);
   *   // Do something.
   *   ProductSet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetProductSetRequest, ProductSet> getProductSetCallable() {
    return stub.getProductSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Makes changes to a ProductSet resource. Only display_name can be updated currently.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the ProductSet does not exist.
   *   <li>Returns INVALID_ARGUMENT if display_name is present in update_mask but missing from the
   *       request or longer than 4096 characters.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSet productSet = ProductSet.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ProductSet response = productSearchClient.updateProductSet(productSet, updateMask);
   * }
   * }</pre>
   *
   * @param productSet Required. The ProductSet resource which replaces the one on the server.
   * @param updateMask The [FieldMask][google.protobuf.FieldMask] that specifies which fields to
   *     update. If update_mask isn't specified, all mutable fields are to be updated. Valid mask
   *     path is `display_name`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProductSet updateProductSet(ProductSet productSet, FieldMask updateMask) {
    UpdateProductSetRequest request =
        UpdateProductSetRequest.newBuilder()
            .setProductSet(productSet)
            .setUpdateMask(updateMask)
            .build();
    return updateProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Makes changes to a ProductSet resource. Only display_name can be updated currently.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the ProductSet does not exist.
   *   <li>Returns INVALID_ARGUMENT if display_name is present in update_mask but missing from the
   *       request or longer than 4096 characters.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   UpdateProductSetRequest request =
   *       UpdateProductSetRequest.newBuilder()
   *           .setProductSet(ProductSet.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ProductSet response = productSearchClient.updateProductSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProductSet updateProductSet(UpdateProductSetRequest request) {
    return updateProductSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Makes changes to a ProductSet resource. Only display_name can be updated currently.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the ProductSet does not exist.
   *   <li>Returns INVALID_ARGUMENT if display_name is present in update_mask but missing from the
   *       request or longer than 4096 characters.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   UpdateProductSetRequest request =
   *       UpdateProductSetRequest.newBuilder()
   *           .setProductSet(ProductSet.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ProductSet> future =
   *       productSearchClient.updateProductSetCallable().futureCall(request);
   *   // Do something.
   *   ProductSet response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateProductSetRequest, ProductSet> updateProductSetCallable() {
    return stub.updateProductSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes a ProductSet. All Products and ReferenceImages in the ProductSet will be
   * deleted.
   *
   * <p>The actual image files are not deleted from Google Cloud Storage.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the ProductSet does not exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   productSearchClient.deleteProductSet(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the ProductSet to delete.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProductSet(ProductSetName name) {
    DeleteProductSetRequest request =
        DeleteProductSetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes a ProductSet. All Products and ReferenceImages in the ProductSet will be
   * deleted.
   *
   * <p>The actual image files are not deleted from Google Cloud Storage.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the ProductSet does not exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   String name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]").toString();
   *   productSearchClient.deleteProductSet(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the ProductSet to delete.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProductSet(String name) {
    DeleteProductSetRequest request = DeleteProductSetRequest.newBuilder().setName(name).build();
    deleteProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes a ProductSet. All Products and ReferenceImages in the ProductSet will be
   * deleted.
   *
   * <p>The actual image files are not deleted from Google Cloud Storage.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the ProductSet does not exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   DeleteProductSetRequest request =
   *       DeleteProductSetRequest.newBuilder()
   *           .setName(ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]").toString())
   *           .build();
   *   productSearchClient.deleteProductSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProductSet(DeleteProductSetRequest request) {
    deleteProductSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes a ProductSet. All Products and ReferenceImages in the ProductSet will be
   * deleted.
   *
   * <p>The actual image files are not deleted from Google Cloud Storage.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the ProductSet does not exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   DeleteProductSetRequest request =
   *       DeleteProductSetRequest.newBuilder()
   *           .setName(ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]").toString())
   *           .build();
   *   ApiFuture<Empty> future = productSearchClient.deleteProductSetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteProductSetRequest, Empty> deleteProductSetCallable() {
    return stub.deleteProductSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and returns a new product resource.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if display_name is missing or longer than 4096 characters.
   *   <li>Returns INVALID_ARGUMENT if description is longer than 4096 characters.
   *   <li>Returns INVALID_ARGUMENT if product_category is missing or invalid.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Product product = Product.newBuilder().build();
   *   String productId = "productId-1051830678";
   *   Product response = productSearchClient.createProduct(parent, product, productId);
   * }
   * }</pre>
   *
   * @param parent Required. The project in which the Product should be created.
   *     <p>Format is `projects/PROJECT_ID/locations/LOC_ID`.
   * @param product Required. The product to create.
   * @param productId A user-supplied resource id for this Product. If set, the server will attempt
   *     to use this value as the resource id. If it is already in use, an error is returned with
   *     code ALREADY_EXISTS. Must be at most 128 characters long. It cannot contain the character
   *     `/`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product createProduct(LocationName parent, Product product, String productId) {
    CreateProductRequest request =
        CreateProductRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setProduct(product)
            .setProductId(productId)
            .build();
    return createProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and returns a new product resource.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if display_name is missing or longer than 4096 characters.
   *   <li>Returns INVALID_ARGUMENT if description is longer than 4096 characters.
   *   <li>Returns INVALID_ARGUMENT if product_category is missing or invalid.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Product product = Product.newBuilder().build();
   *   String productId = "productId-1051830678";
   *   Product response = productSearchClient.createProduct(parent, product, productId);
   * }
   * }</pre>
   *
   * @param parent Required. The project in which the Product should be created.
   *     <p>Format is `projects/PROJECT_ID/locations/LOC_ID`.
   * @param product Required. The product to create.
   * @param productId A user-supplied resource id for this Product. If set, the server will attempt
   *     to use this value as the resource id. If it is already in use, an error is returned with
   *     code ALREADY_EXISTS. Must be at most 128 characters long. It cannot contain the character
   *     `/`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product createProduct(String parent, Product product, String productId) {
    CreateProductRequest request =
        CreateProductRequest.newBuilder()
            .setParent(parent)
            .setProduct(product)
            .setProductId(productId)
            .build();
    return createProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and returns a new product resource.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if display_name is missing or longer than 4096 characters.
   *   <li>Returns INVALID_ARGUMENT if description is longer than 4096 characters.
   *   <li>Returns INVALID_ARGUMENT if product_category is missing or invalid.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   CreateProductRequest request =
   *       CreateProductRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setProduct(Product.newBuilder().build())
   *           .setProductId("productId-1051830678")
   *           .build();
   *   Product response = productSearchClient.createProduct(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product createProduct(CreateProductRequest request) {
    return createProductCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and returns a new product resource.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if display_name is missing or longer than 4096 characters.
   *   <li>Returns INVALID_ARGUMENT if description is longer than 4096 characters.
   *   <li>Returns INVALID_ARGUMENT if product_category is missing or invalid.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   CreateProductRequest request =
   *       CreateProductRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setProduct(Product.newBuilder().build())
   *           .setProductId("productId-1051830678")
   *           .build();
   *   ApiFuture<Product> future = productSearchClient.createProductCallable().futureCall(request);
   *   // Do something.
   *   Product response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateProductRequest, Product> createProductCallable() {
    return stub.createProductCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists products in an unspecified order.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Product element : productSearchClient.listProducts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project OR ProductSet from which Products should be listed.
   *     <p>Format: `projects/PROJECT_ID/locations/LOC_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductsPagedResponse listProducts(LocationName parent) {
    ListProductsRequest request =
        ListProductsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listProducts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists products in an unspecified order.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Product element : productSearchClient.listProducts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project OR ProductSet from which Products should be listed.
   *     <p>Format: `projects/PROJECT_ID/locations/LOC_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductsPagedResponse listProducts(String parent) {
    ListProductsRequest request = ListProductsRequest.newBuilder().setParent(parent).build();
    return listProducts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists products in an unspecified order.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ListProductsRequest request =
   *       ListProductsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Product element : productSearchClient.listProducts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductsPagedResponse listProducts(ListProductsRequest request) {
    return listProductsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists products in an unspecified order.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ListProductsRequest request =
   *       ListProductsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Product> future =
   *       productSearchClient.listProductsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Product element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListProductsRequest, ListProductsPagedResponse>
      listProductsPagedCallable() {
    return stub.listProductsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists products in an unspecified order.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   while (true) {
   *     ListProductsResponse response = productSearchClient.listProductsCallable().call(request);
   *     for (Product element : response.getResponsesList()) {
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
  public final UnaryCallable<ListProductsRequest, ListProductsResponse> listProductsCallable() {
    return stub.listProductsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information associated with a Product.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the Product does not exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductName name = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   Product response = productSearchClient.getProduct(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the Product to get.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product getProduct(ProductName name) {
    GetProductRequest request =
        GetProductRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information associated with a Product.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the Product does not exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   String name = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString();
   *   Product response = productSearchClient.getProduct(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the Product to get.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product getProduct(String name) {
    GetProductRequest request = GetProductRequest.newBuilder().setName(name).build();
    return getProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information associated with a Product.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the Product does not exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   GetProductRequest request =
   *       GetProductRequest.newBuilder()
   *           .setName(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
   *           .build();
   *   Product response = productSearchClient.getProduct(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product getProduct(GetProductRequest request) {
    return getProductCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information associated with a Product.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the Product does not exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   GetProductRequest request =
   *       GetProductRequest.newBuilder()
   *           .setName(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
   *           .build();
   *   ApiFuture<Product> future = productSearchClient.getProductCallable().futureCall(request);
   *   // Do something.
   *   Product response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetProductRequest, Product> getProductCallable() {
    return stub.getProductCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Makes changes to a Product resource. Only display_name, description and labels can be updated
   * right now.
   *
   * <p>If labels are updated, the change will not be reflected in queries until the next index
   * time.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the Product does not exist.
   *   <li>Returns INVALID_ARGUMENT if display_name is present in update_mask but is missing from
   *       the request or longer than 4096 characters.
   *   <li>Returns INVALID_ARGUMENT if description is present in update_mask but is longer than 4096
   *       characters.
   *   <li>Returns INVALID_ARGUMENT if product_category is present in update_mask.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   Product product = Product.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Product response = productSearchClient.updateProduct(product, updateMask);
   * }
   * }</pre>
   *
   * @param product Required. The Product resource which replaces the one on the server.
   *     product.name is immutable.
   * @param updateMask The [FieldMask][google.protobuf.FieldMask] that specifies which fields to
   *     update. If update_mask isn't specified, all mutable fields are to be updated. Valid mask
   *     paths include `product_labels`, `display_name`, and `description`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product updateProduct(Product product, FieldMask updateMask) {
    UpdateProductRequest request =
        UpdateProductRequest.newBuilder().setProduct(product).setUpdateMask(updateMask).build();
    return updateProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Makes changes to a Product resource. Only display_name, description and labels can be updated
   * right now.
   *
   * <p>If labels are updated, the change will not be reflected in queries until the next index
   * time.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the Product does not exist.
   *   <li>Returns INVALID_ARGUMENT if display_name is present in update_mask but is missing from
   *       the request or longer than 4096 characters.
   *   <li>Returns INVALID_ARGUMENT if description is present in update_mask but is longer than 4096
   *       characters.
   *   <li>Returns INVALID_ARGUMENT if product_category is present in update_mask.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   UpdateProductRequest request =
   *       UpdateProductRequest.newBuilder()
   *           .setProduct(Product.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Product response = productSearchClient.updateProduct(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product updateProduct(UpdateProductRequest request) {
    return updateProductCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Makes changes to a Product resource. Only display_name, description and labels can be updated
   * right now.
   *
   * <p>If labels are updated, the change will not be reflected in queries until the next index
   * time.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the Product does not exist.
   *   <li>Returns INVALID_ARGUMENT if display_name is present in update_mask but is missing from
   *       the request or longer than 4096 characters.
   *   <li>Returns INVALID_ARGUMENT if description is present in update_mask but is longer than 4096
   *       characters.
   *   <li>Returns INVALID_ARGUMENT if product_category is present in update_mask.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   UpdateProductRequest request =
   *       UpdateProductRequest.newBuilder()
   *           .setProduct(Product.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Product> future = productSearchClient.updateProductCallable().futureCall(request);
   *   // Do something.
   *   Product response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateProductRequest, Product> updateProductCallable() {
    return stub.updateProductCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes a product and its reference images.
   *
   * <p>Metadata of the product and all its images will be deleted right away, but search queries
   * against ProductSets containing the product may still work until all related caches are
   * refreshed.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the product does not exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductName name = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   productSearchClient.deleteProduct(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of product to delete.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProduct(ProductName name) {
    DeleteProductRequest request =
        DeleteProductRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes a product and its reference images.
   *
   * <p>Metadata of the product and all its images will be deleted right away, but search queries
   * against ProductSets containing the product may still work until all related caches are
   * refreshed.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the product does not exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   String name = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString();
   *   productSearchClient.deleteProduct(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of product to delete.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProduct(String name) {
    DeleteProductRequest request = DeleteProductRequest.newBuilder().setName(name).build();
    deleteProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes a product and its reference images.
   *
   * <p>Metadata of the product and all its images will be deleted right away, but search queries
   * against ProductSets containing the product may still work until all related caches are
   * refreshed.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the product does not exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   DeleteProductRequest request =
   *       DeleteProductRequest.newBuilder()
   *           .setName(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
   *           .build();
   *   productSearchClient.deleteProduct(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProduct(DeleteProductRequest request) {
    deleteProductCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes a product and its reference images.
   *
   * <p>Metadata of the product and all its images will be deleted right away, but search queries
   * against ProductSets containing the product may still work until all related caches are
   * refreshed.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the product does not exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   DeleteProductRequest request =
   *       DeleteProductRequest.newBuilder()
   *           .setName(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
   *           .build();
   *   ApiFuture<Empty> future = productSearchClient.deleteProductCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteProductRequest, Empty> deleteProductCallable() {
    return stub.deleteProductCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and returns a new ReferenceImage resource.
   *
   * <p>The `bounding_poly` field is optional. If `bounding_poly` is not specified, the system will
   * try to detect regions of interest in the image that are compatible with the product_category on
   * the parent product. If it is specified, detection is ALWAYS skipped. The system converts
   * polygons into non-rotated rectangles.
   *
   * <p>Note that the pipeline will resize the image if the image resolution is too large to process
   * (above 50MP).
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if the image_uri is missing or longer than 4096 characters.
   *   <li>Returns INVALID_ARGUMENT if the product does not exist.
   *   <li>Returns INVALID_ARGUMENT if bounding_poly is not provided, and nothing compatible with
   *       the parent product's product_category is detected.
   *   <li>Returns INVALID_ARGUMENT if bounding_poly contains more than 10 polygons.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductName parent = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   ReferenceImage referenceImage = ReferenceImage.newBuilder().build();
   *   String referenceImageId = "referenceImageId1224107531";
   *   ReferenceImage response =
   *       productSearchClient.createReferenceImage(parent, referenceImage, referenceImageId);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the product in which to create the reference image.
   *     <p>Format is `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`.
   * @param referenceImage Required. The reference image to create. If an image ID is specified, it
   *     is ignored.
   * @param referenceImageId A user-supplied resource id for the ReferenceImage to be added. If set,
   *     the server will attempt to use this value as the resource id. If it is already in use, an
   *     error is returned with code ALREADY_EXISTS. Must be at most 128 characters long. It cannot
   *     contain the character `/`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReferenceImage createReferenceImage(
      ProductName parent, ReferenceImage referenceImage, String referenceImageId) {
    CreateReferenceImageRequest request =
        CreateReferenceImageRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setReferenceImage(referenceImage)
            .setReferenceImageId(referenceImageId)
            .build();
    return createReferenceImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and returns a new ReferenceImage resource.
   *
   * <p>The `bounding_poly` field is optional. If `bounding_poly` is not specified, the system will
   * try to detect regions of interest in the image that are compatible with the product_category on
   * the parent product. If it is specified, detection is ALWAYS skipped. The system converts
   * polygons into non-rotated rectangles.
   *
   * <p>Note that the pipeline will resize the image if the image resolution is too large to process
   * (above 50MP).
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if the image_uri is missing or longer than 4096 characters.
   *   <li>Returns INVALID_ARGUMENT if the product does not exist.
   *   <li>Returns INVALID_ARGUMENT if bounding_poly is not provided, and nothing compatible with
   *       the parent product's product_category is detected.
   *   <li>Returns INVALID_ARGUMENT if bounding_poly contains more than 10 polygons.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   String parent = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString();
   *   ReferenceImage referenceImage = ReferenceImage.newBuilder().build();
   *   String referenceImageId = "referenceImageId1224107531";
   *   ReferenceImage response =
   *       productSearchClient.createReferenceImage(parent, referenceImage, referenceImageId);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the product in which to create the reference image.
   *     <p>Format is `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`.
   * @param referenceImage Required. The reference image to create. If an image ID is specified, it
   *     is ignored.
   * @param referenceImageId A user-supplied resource id for the ReferenceImage to be added. If set,
   *     the server will attempt to use this value as the resource id. If it is already in use, an
   *     error is returned with code ALREADY_EXISTS. Must be at most 128 characters long. It cannot
   *     contain the character `/`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReferenceImage createReferenceImage(
      String parent, ReferenceImage referenceImage, String referenceImageId) {
    CreateReferenceImageRequest request =
        CreateReferenceImageRequest.newBuilder()
            .setParent(parent)
            .setReferenceImage(referenceImage)
            .setReferenceImageId(referenceImageId)
            .build();
    return createReferenceImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and returns a new ReferenceImage resource.
   *
   * <p>The `bounding_poly` field is optional. If `bounding_poly` is not specified, the system will
   * try to detect regions of interest in the image that are compatible with the product_category on
   * the parent product. If it is specified, detection is ALWAYS skipped. The system converts
   * polygons into non-rotated rectangles.
   *
   * <p>Note that the pipeline will resize the image if the image resolution is too large to process
   * (above 50MP).
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if the image_uri is missing or longer than 4096 characters.
   *   <li>Returns INVALID_ARGUMENT if the product does not exist.
   *   <li>Returns INVALID_ARGUMENT if bounding_poly is not provided, and nothing compatible with
   *       the parent product's product_category is detected.
   *   <li>Returns INVALID_ARGUMENT if bounding_poly contains more than 10 polygons.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   CreateReferenceImageRequest request =
   *       CreateReferenceImageRequest.newBuilder()
   *           .setParent(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
   *           .setReferenceImage(ReferenceImage.newBuilder().build())
   *           .setReferenceImageId("referenceImageId1224107531")
   *           .build();
   *   ReferenceImage response = productSearchClient.createReferenceImage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReferenceImage createReferenceImage(CreateReferenceImageRequest request) {
    return createReferenceImageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and returns a new ReferenceImage resource.
   *
   * <p>The `bounding_poly` field is optional. If `bounding_poly` is not specified, the system will
   * try to detect regions of interest in the image that are compatible with the product_category on
   * the parent product. If it is specified, detection is ALWAYS skipped. The system converts
   * polygons into non-rotated rectangles.
   *
   * <p>Note that the pipeline will resize the image if the image resolution is too large to process
   * (above 50MP).
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if the image_uri is missing or longer than 4096 characters.
   *   <li>Returns INVALID_ARGUMENT if the product does not exist.
   *   <li>Returns INVALID_ARGUMENT if bounding_poly is not provided, and nothing compatible with
   *       the parent product's product_category is detected.
   *   <li>Returns INVALID_ARGUMENT if bounding_poly contains more than 10 polygons.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   CreateReferenceImageRequest request =
   *       CreateReferenceImageRequest.newBuilder()
   *           .setParent(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
   *           .setReferenceImage(ReferenceImage.newBuilder().build())
   *           .setReferenceImageId("referenceImageId1224107531")
   *           .build();
   *   ApiFuture<ReferenceImage> future =
   *       productSearchClient.createReferenceImageCallable().futureCall(request);
   *   // Do something.
   *   ReferenceImage response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateReferenceImageRequest, ReferenceImage>
      createReferenceImageCallable() {
    return stub.createReferenceImageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes a reference image.
   *
   * <p>The image metadata will be deleted right away, but search queries against ProductSets
   * containing the image may still work until all related caches are refreshed.
   *
   * <p>The actual image files are not deleted from Google Cloud Storage.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the reference image does not exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ReferenceImageName name =
   *       ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]");
   *   productSearchClient.deleteReferenceImage(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the reference image to delete.
   *     <p>Format is:
   *     <p>`projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID/referenceImages/IMAGE_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReferenceImage(ReferenceImageName name) {
    DeleteReferenceImageRequest request =
        DeleteReferenceImageRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteReferenceImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes a reference image.
   *
   * <p>The image metadata will be deleted right away, but search queries against ProductSets
   * containing the image may still work until all related caches are refreshed.
   *
   * <p>The actual image files are not deleted from Google Cloud Storage.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the reference image does not exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   String name =
   *       ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]")
   *           .toString();
   *   productSearchClient.deleteReferenceImage(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the reference image to delete.
   *     <p>Format is:
   *     <p>`projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID/referenceImages/IMAGE_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReferenceImage(String name) {
    DeleteReferenceImageRequest request =
        DeleteReferenceImageRequest.newBuilder().setName(name).build();
    deleteReferenceImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes a reference image.
   *
   * <p>The image metadata will be deleted right away, but search queries against ProductSets
   * containing the image may still work until all related caches are refreshed.
   *
   * <p>The actual image files are not deleted from Google Cloud Storage.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the reference image does not exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   DeleteReferenceImageRequest request =
   *       DeleteReferenceImageRequest.newBuilder()
   *           .setName(
   *               ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]")
   *                   .toString())
   *           .build();
   *   productSearchClient.deleteReferenceImage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReferenceImage(DeleteReferenceImageRequest request) {
    deleteReferenceImageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Permanently deletes a reference image.
   *
   * <p>The image metadata will be deleted right away, but search queries against ProductSets
   * containing the image may still work until all related caches are refreshed.
   *
   * <p>The actual image files are not deleted from Google Cloud Storage.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the reference image does not exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   DeleteReferenceImageRequest request =
   *       DeleteReferenceImageRequest.newBuilder()
   *           .setName(
   *               ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       productSearchClient.deleteReferenceImageCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteReferenceImageRequest, Empty> deleteReferenceImageCallable() {
    return stub.deleteReferenceImageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists reference images.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the parent product does not exist.
   *   <li>Returns INVALID_ARGUMENT if the page_size is greater than 100, or less than 1.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductName parent = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   for (ReferenceImage element : productSearchClient.listReferenceImages(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the product containing the reference images.
   *     <p>Format is `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReferenceImagesPagedResponse listReferenceImages(ProductName parent) {
    ListReferenceImagesRequest request =
        ListReferenceImagesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listReferenceImages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists reference images.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the parent product does not exist.
   *   <li>Returns INVALID_ARGUMENT if the page_size is greater than 100, or less than 1.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   String parent = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString();
   *   for (ReferenceImage element : productSearchClient.listReferenceImages(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the product containing the reference images.
   *     <p>Format is `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReferenceImagesPagedResponse listReferenceImages(String parent) {
    ListReferenceImagesRequest request =
        ListReferenceImagesRequest.newBuilder().setParent(parent).build();
    return listReferenceImages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists reference images.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the parent product does not exist.
   *   <li>Returns INVALID_ARGUMENT if the page_size is greater than 100, or less than 1.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ListReferenceImagesRequest request =
   *       ListReferenceImagesRequest.newBuilder()
   *           .setParent(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ReferenceImage element : productSearchClient.listReferenceImages(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReferenceImagesPagedResponse listReferenceImages(
      ListReferenceImagesRequest request) {
    return listReferenceImagesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists reference images.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the parent product does not exist.
   *   <li>Returns INVALID_ARGUMENT if the page_size is greater than 100, or less than 1.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ListReferenceImagesRequest request =
   *       ListReferenceImagesRequest.newBuilder()
   *           .setParent(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ReferenceImage> future =
   *       productSearchClient.listReferenceImagesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ReferenceImage element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReferenceImagesRequest, ListReferenceImagesPagedResponse>
      listReferenceImagesPagedCallable() {
    return stub.listReferenceImagesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists reference images.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the parent product does not exist.
   *   <li>Returns INVALID_ARGUMENT if the page_size is greater than 100, or less than 1.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   while (true) {
   *     ListReferenceImagesResponse response =
   *         productSearchClient.listReferenceImagesCallable().call(request);
   *     for (ReferenceImage element : response.getResponsesList()) {
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
  public final UnaryCallable<ListReferenceImagesRequest, ListReferenceImagesResponse>
      listReferenceImagesCallable() {
    return stub.listReferenceImagesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information associated with a ReferenceImage.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the specified image does not exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ReferenceImageName name =
   *       ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]");
   *   ReferenceImage response = productSearchClient.getReferenceImage(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ReferenceImage to get.
   *     <p>Format is:
   *     <p>`projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID/referenceImages/IMAGE_ID`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReferenceImage getReferenceImage(ReferenceImageName name) {
    GetReferenceImageRequest request =
        GetReferenceImageRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getReferenceImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information associated with a ReferenceImage.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the specified image does not exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   String name =
   *       ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]")
   *           .toString();
   *   ReferenceImage response = productSearchClient.getReferenceImage(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ReferenceImage to get.
   *     <p>Format is:
   *     <p>`projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID/referenceImages/IMAGE_ID`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReferenceImage getReferenceImage(String name) {
    GetReferenceImageRequest request = GetReferenceImageRequest.newBuilder().setName(name).build();
    return getReferenceImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information associated with a ReferenceImage.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the specified image does not exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   GetReferenceImageRequest request =
   *       GetReferenceImageRequest.newBuilder()
   *           .setName(
   *               ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]")
   *                   .toString())
   *           .build();
   *   ReferenceImage response = productSearchClient.getReferenceImage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReferenceImage getReferenceImage(GetReferenceImageRequest request) {
    return getReferenceImageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information associated with a ReferenceImage.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the specified image does not exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   GetReferenceImageRequest request =
   *       GetReferenceImageRequest.newBuilder()
   *           .setName(
   *               ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ReferenceImage> future =
   *       productSearchClient.getReferenceImageCallable().futureCall(request);
   *   // Do something.
   *   ReferenceImage response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetReferenceImageRequest, ReferenceImage> getReferenceImageCallable() {
    return stub.getReferenceImageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a Product to the specified ProductSet. If the Product is already present, no change is
   * made.
   *
   * <p>One Product can be added to at most 100 ProductSets.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the Product or the ProductSet doesn't exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   ProductName product = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   productSearchClient.addProductToProductSet(name, product);
   * }
   * }</pre>
   *
   * @param name Required. The resource name for the ProductSet to modify.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
   * @param product Required. The resource name for the Product to be added to this ProductSet.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void addProductToProductSet(ProductSetName name, ProductName product) {
    AddProductToProductSetRequest request =
        AddProductToProductSetRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setProduct(product == null ? null : product.toString())
            .build();
    addProductToProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a Product to the specified ProductSet. If the Product is already present, no change is
   * made.
   *
   * <p>One Product can be added to at most 100 ProductSets.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the Product or the ProductSet doesn't exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   String product = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString();
   *   productSearchClient.addProductToProductSet(name, product);
   * }
   * }</pre>
   *
   * @param name Required. The resource name for the ProductSet to modify.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
   * @param product Required. The resource name for the Product to be added to this ProductSet.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void addProductToProductSet(ProductSetName name, String product) {
    AddProductToProductSetRequest request =
        AddProductToProductSetRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setProduct(product)
            .build();
    addProductToProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a Product to the specified ProductSet. If the Product is already present, no change is
   * made.
   *
   * <p>One Product can be added to at most 100 ProductSets.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the Product or the ProductSet doesn't exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   String name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]").toString();
   *   ProductName product = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   productSearchClient.addProductToProductSet(name, product);
   * }
   * }</pre>
   *
   * @param name Required. The resource name for the ProductSet to modify.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
   * @param product Required. The resource name for the Product to be added to this ProductSet.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void addProductToProductSet(String name, ProductName product) {
    AddProductToProductSetRequest request =
        AddProductToProductSetRequest.newBuilder()
            .setName(name)
            .setProduct(product == null ? null : product.toString())
            .build();
    addProductToProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a Product to the specified ProductSet. If the Product is already present, no change is
   * made.
   *
   * <p>One Product can be added to at most 100 ProductSets.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the Product or the ProductSet doesn't exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   String name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]").toString();
   *   String product = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString();
   *   productSearchClient.addProductToProductSet(name, product);
   * }
   * }</pre>
   *
   * @param name Required. The resource name for the ProductSet to modify.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
   * @param product Required. The resource name for the Product to be added to this ProductSet.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void addProductToProductSet(String name, String product) {
    AddProductToProductSetRequest request =
        AddProductToProductSetRequest.newBuilder().setName(name).setProduct(product).build();
    addProductToProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a Product to the specified ProductSet. If the Product is already present, no change is
   * made.
   *
   * <p>One Product can be added to at most 100 ProductSets.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the Product or the ProductSet doesn't exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   AddProductToProductSetRequest request =
   *       AddProductToProductSetRequest.newBuilder()
   *           .setName(ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]").toString())
   *           .setProduct(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
   *           .build();
   *   productSearchClient.addProductToProductSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void addProductToProductSet(AddProductToProductSetRequest request) {
    addProductToProductSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a Product to the specified ProductSet. If the Product is already present, no change is
   * made.
   *
   * <p>One Product can be added to at most 100 ProductSets.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND if the Product or the ProductSet doesn't exist.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   AddProductToProductSetRequest request =
   *       AddProductToProductSetRequest.newBuilder()
   *           .setName(ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]").toString())
   *           .setProduct(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       productSearchClient.addProductToProductSetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddProductToProductSetRequest, Empty>
      addProductToProductSetCallable() {
    return stub.addProductToProductSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Product from the specified ProductSet.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND If the Product is not found under the ProductSet.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   ProductName product = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   productSearchClient.removeProductFromProductSet(name, product);
   * }
   * }</pre>
   *
   * @param name Required. The resource name for the ProductSet to modify.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
   * @param product Required. The resource name for the Product to be removed from this ProductSet.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void removeProductFromProductSet(ProductSetName name, ProductName product) {
    RemoveProductFromProductSetRequest request =
        RemoveProductFromProductSetRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setProduct(product == null ? null : product.toString())
            .build();
    removeProductFromProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Product from the specified ProductSet.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND If the Product is not found under the ProductSet.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   String product = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString();
   *   productSearchClient.removeProductFromProductSet(name, product);
   * }
   * }</pre>
   *
   * @param name Required. The resource name for the ProductSet to modify.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
   * @param product Required. The resource name for the Product to be removed from this ProductSet.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void removeProductFromProductSet(ProductSetName name, String product) {
    RemoveProductFromProductSetRequest request =
        RemoveProductFromProductSetRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setProduct(product)
            .build();
    removeProductFromProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Product from the specified ProductSet.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND If the Product is not found under the ProductSet.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   String name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]").toString();
   *   ProductName product = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   productSearchClient.removeProductFromProductSet(name, product);
   * }
   * }</pre>
   *
   * @param name Required. The resource name for the ProductSet to modify.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
   * @param product Required. The resource name for the Product to be removed from this ProductSet.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void removeProductFromProductSet(String name, ProductName product) {
    RemoveProductFromProductSetRequest request =
        RemoveProductFromProductSetRequest.newBuilder()
            .setName(name)
            .setProduct(product == null ? null : product.toString())
            .build();
    removeProductFromProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Product from the specified ProductSet.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND If the Product is not found under the ProductSet.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   String name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]").toString();
   *   String product = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString();
   *   productSearchClient.removeProductFromProductSet(name, product);
   * }
   * }</pre>
   *
   * @param name Required. The resource name for the ProductSet to modify.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
   * @param product Required. The resource name for the Product to be removed from this ProductSet.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void removeProductFromProductSet(String name, String product) {
    RemoveProductFromProductSetRequest request =
        RemoveProductFromProductSetRequest.newBuilder().setName(name).setProduct(product).build();
    removeProductFromProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Product from the specified ProductSet.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND If the Product is not found under the ProductSet.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   RemoveProductFromProductSetRequest request =
   *       RemoveProductFromProductSetRequest.newBuilder()
   *           .setName(ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]").toString())
   *           .setProduct(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
   *           .build();
   *   productSearchClient.removeProductFromProductSet(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void removeProductFromProductSet(RemoveProductFromProductSetRequest request) {
    removeProductFromProductSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes a Product from the specified ProductSet.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns NOT_FOUND If the Product is not found under the ProductSet.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   RemoveProductFromProductSetRequest request =
   *       RemoveProductFromProductSetRequest.newBuilder()
   *           .setName(ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]").toString())
   *           .setProduct(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       productSearchClient.removeProductFromProductSetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveProductFromProductSetRequest, Empty>
      removeProductFromProductSetCallable() {
    return stub.removeProductFromProductSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Products in a ProductSet, in an unspecified order. If the ProductSet does not exist,
   * the products field of the response will be empty.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   for (Product element : productSearchClient.listProductsInProductSet(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The ProductSet resource for which to retrieve Products.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductsInProductSetPagedResponse listProductsInProductSet(ProductSetName name) {
    ListProductsInProductSetRequest request =
        ListProductsInProductSetRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return listProductsInProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Products in a ProductSet, in an unspecified order. If the ProductSet does not exist,
   * the products field of the response will be empty.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   String name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]").toString();
   *   for (Product element : productSearchClient.listProductsInProductSet(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The ProductSet resource for which to retrieve Products.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductsInProductSetPagedResponse listProductsInProductSet(String name) {
    ListProductsInProductSetRequest request =
        ListProductsInProductSetRequest.newBuilder().setName(name).build();
    return listProductsInProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Products in a ProductSet, in an unspecified order. If the ProductSet does not exist,
   * the products field of the response will be empty.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ListProductsInProductSetRequest request =
   *       ListProductsInProductSetRequest.newBuilder()
   *           .setName(ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Product element : productSearchClient.listProductsInProductSet(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductsInProductSetPagedResponse listProductsInProductSet(
      ListProductsInProductSetRequest request) {
    return listProductsInProductSetPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Products in a ProductSet, in an unspecified order. If the ProductSet does not exist,
   * the products field of the response will be empty.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ListProductsInProductSetRequest request =
   *       ListProductsInProductSetRequest.newBuilder()
   *           .setName(ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Product> future =
   *       productSearchClient.listProductsInProductSetPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Product element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListProductsInProductSetRequest, ListProductsInProductSetPagedResponse>
      listProductsInProductSetPagedCallable() {
    return stub.listProductsInProductSetPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Products in a ProductSet, in an unspecified order. If the ProductSet does not exist,
   * the products field of the response will be empty.
   *
   * <p>Possible errors:
   *
   * <ul>
   *   <li>Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   while (true) {
   *     ListProductsInProductSetResponse response =
   *         productSearchClient.listProductsInProductSetCallable().call(request);
   *     for (Product element : response.getResponsesList()) {
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
  public final UnaryCallable<ListProductsInProductSetRequest, ListProductsInProductSetResponse>
      listProductsInProductSetCallable() {
    return stub.listProductsInProductSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Asynchronous API that imports a list of reference images to specified product sets based on a
   * list of image information.
   *
   * <p>The [google.longrunning.Operation][google.longrunning.Operation] API can be used to keep
   * track of the progress and results of the request. `Operation.metadata` contains
   * `BatchOperationMetadata`. (progress) `Operation.response` contains `ImportProductSetsResponse`.
   * (results)
   *
   * <p>The input source of this method is a csv file on Google Cloud Storage. For the format of the
   * csv file please see
   * [ImportProductSetsGcsSource.csv_file_uri][google.cloud.vision.v1p3beta1.ImportProductSetsGcsSource.csv_file_uri].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ImportProductSetsInputConfig inputConfig = ImportProductSetsInputConfig.newBuilder().build();
   *   ImportProductSetsResponse response =
   *       productSearchClient.importProductSetsAsync(parent, inputConfig).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project in which the ProductSets should be imported.
   *     <p>Format is `projects/PROJECT_ID/locations/LOC_ID`.
   * @param inputConfig Required. The input content for the list of requests.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportProductSetsResponse, BatchOperationMetadata>
      importProductSetsAsync(LocationName parent, ImportProductSetsInputConfig inputConfig) {
    ImportProductSetsRequest request =
        ImportProductSetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInputConfig(inputConfig)
            .build();
    return importProductSetsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Asynchronous API that imports a list of reference images to specified product sets based on a
   * list of image information.
   *
   * <p>The [google.longrunning.Operation][google.longrunning.Operation] API can be used to keep
   * track of the progress and results of the request. `Operation.metadata` contains
   * `BatchOperationMetadata`. (progress) `Operation.response` contains `ImportProductSetsResponse`.
   * (results)
   *
   * <p>The input source of this method is a csv file on Google Cloud Storage. For the format of the
   * csv file please see
   * [ImportProductSetsGcsSource.csv_file_uri][google.cloud.vision.v1p3beta1.ImportProductSetsGcsSource.csv_file_uri].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ImportProductSetsInputConfig inputConfig = ImportProductSetsInputConfig.newBuilder().build();
   *   ImportProductSetsResponse response =
   *       productSearchClient.importProductSetsAsync(parent, inputConfig).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project in which the ProductSets should be imported.
   *     <p>Format is `projects/PROJECT_ID/locations/LOC_ID`.
   * @param inputConfig Required. The input content for the list of requests.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportProductSetsResponse, BatchOperationMetadata>
      importProductSetsAsync(String parent, ImportProductSetsInputConfig inputConfig) {
    ImportProductSetsRequest request =
        ImportProductSetsRequest.newBuilder().setParent(parent).setInputConfig(inputConfig).build();
    return importProductSetsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Asynchronous API that imports a list of reference images to specified product sets based on a
   * list of image information.
   *
   * <p>The [google.longrunning.Operation][google.longrunning.Operation] API can be used to keep
   * track of the progress and results of the request. `Operation.metadata` contains
   * `BatchOperationMetadata`. (progress) `Operation.response` contains `ImportProductSetsResponse`.
   * (results)
   *
   * <p>The input source of this method is a csv file on Google Cloud Storage. For the format of the
   * csv file please see
   * [ImportProductSetsGcsSource.csv_file_uri][google.cloud.vision.v1p3beta1.ImportProductSetsGcsSource.csv_file_uri].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ImportProductSetsRequest request =
   *       ImportProductSetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInputConfig(ImportProductSetsInputConfig.newBuilder().build())
   *           .build();
   *   ImportProductSetsResponse response =
   *       productSearchClient.importProductSetsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportProductSetsResponse, BatchOperationMetadata>
      importProductSetsAsync(ImportProductSetsRequest request) {
    return importProductSetsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Asynchronous API that imports a list of reference images to specified product sets based on a
   * list of image information.
   *
   * <p>The [google.longrunning.Operation][google.longrunning.Operation] API can be used to keep
   * track of the progress and results of the request. `Operation.metadata` contains
   * `BatchOperationMetadata`. (progress) `Operation.response` contains `ImportProductSetsResponse`.
   * (results)
   *
   * <p>The input source of this method is a csv file on Google Cloud Storage. For the format of the
   * csv file please see
   * [ImportProductSetsGcsSource.csv_file_uri][google.cloud.vision.v1p3beta1.ImportProductSetsGcsSource.csv_file_uri].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ImportProductSetsRequest request =
   *       ImportProductSetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInputConfig(ImportProductSetsInputConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<ImportProductSetsResponse, BatchOperationMetadata> future =
   *       productSearchClient.importProductSetsOperationCallable().futureCall(request);
   *   // Do something.
   *   ImportProductSetsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ImportProductSetsRequest, ImportProductSetsResponse, BatchOperationMetadata>
      importProductSetsOperationCallable() {
    return stub.importProductSetsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Asynchronous API that imports a list of reference images to specified product sets based on a
   * list of image information.
   *
   * <p>The [google.longrunning.Operation][google.longrunning.Operation] API can be used to keep
   * track of the progress and results of the request. `Operation.metadata` contains
   * `BatchOperationMetadata`. (progress) `Operation.response` contains `ImportProductSetsResponse`.
   * (results)
   *
   * <p>The input source of this method is a csv file on Google Cloud Storage. For the format of the
   * csv file please see
   * [ImportProductSetsGcsSource.csv_file_uri][google.cloud.vision.v1p3beta1.ImportProductSetsGcsSource.csv_file_uri].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ImportProductSetsRequest request =
   *       ImportProductSetsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInputConfig(ImportProductSetsInputConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       productSearchClient.importProductSetsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportProductSetsRequest, Operation> importProductSetsCallable() {
    return stub.importProductSetsCallable();
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

  public static class ListProductSetsPagedResponse
      extends AbstractPagedListResponse<
          ListProductSetsRequest,
          ListProductSetsResponse,
          ProductSet,
          ListProductSetsPage,
          ListProductSetsFixedSizeCollection> {

    public static ApiFuture<ListProductSetsPagedResponse> createAsync(
        PageContext<ListProductSetsRequest, ListProductSetsResponse, ProductSet> context,
        ApiFuture<ListProductSetsResponse> futureResponse) {
      ApiFuture<ListProductSetsPage> futurePage =
          ListProductSetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListProductSetsPage, ListProductSetsPagedResponse>() {
            @Override
            public ListProductSetsPagedResponse apply(ListProductSetsPage input) {
              return new ListProductSetsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListProductSetsPagedResponse(ListProductSetsPage page) {
      super(page, ListProductSetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListProductSetsPage
      extends AbstractPage<
          ListProductSetsRequest, ListProductSetsResponse, ProductSet, ListProductSetsPage> {

    private ListProductSetsPage(
        PageContext<ListProductSetsRequest, ListProductSetsResponse, ProductSet> context,
        ListProductSetsResponse response) {
      super(context, response);
    }

    private static ListProductSetsPage createEmptyPage() {
      return new ListProductSetsPage(null, null);
    }

    @Override
    protected ListProductSetsPage createPage(
        PageContext<ListProductSetsRequest, ListProductSetsResponse, ProductSet> context,
        ListProductSetsResponse response) {
      return new ListProductSetsPage(context, response);
    }

    @Override
    public ApiFuture<ListProductSetsPage> createPageAsync(
        PageContext<ListProductSetsRequest, ListProductSetsResponse, ProductSet> context,
        ApiFuture<ListProductSetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListProductSetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListProductSetsRequest,
          ListProductSetsResponse,
          ProductSet,
          ListProductSetsPage,
          ListProductSetsFixedSizeCollection> {

    private ListProductSetsFixedSizeCollection(
        List<ListProductSetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListProductSetsFixedSizeCollection createEmptyCollection() {
      return new ListProductSetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListProductSetsFixedSizeCollection createCollection(
        List<ListProductSetsPage> pages, int collectionSize) {
      return new ListProductSetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListProductsPagedResponse
      extends AbstractPagedListResponse<
          ListProductsRequest,
          ListProductsResponse,
          Product,
          ListProductsPage,
          ListProductsFixedSizeCollection> {

    public static ApiFuture<ListProductsPagedResponse> createAsync(
        PageContext<ListProductsRequest, ListProductsResponse, Product> context,
        ApiFuture<ListProductsResponse> futureResponse) {
      ApiFuture<ListProductsPage> futurePage =
          ListProductsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListProductsPage, ListProductsPagedResponse>() {
            @Override
            public ListProductsPagedResponse apply(ListProductsPage input) {
              return new ListProductsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListProductsPagedResponse(ListProductsPage page) {
      super(page, ListProductsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListProductsPage
      extends AbstractPage<ListProductsRequest, ListProductsResponse, Product, ListProductsPage> {

    private ListProductsPage(
        PageContext<ListProductsRequest, ListProductsResponse, Product> context,
        ListProductsResponse response) {
      super(context, response);
    }

    private static ListProductsPage createEmptyPage() {
      return new ListProductsPage(null, null);
    }

    @Override
    protected ListProductsPage createPage(
        PageContext<ListProductsRequest, ListProductsResponse, Product> context,
        ListProductsResponse response) {
      return new ListProductsPage(context, response);
    }

    @Override
    public ApiFuture<ListProductsPage> createPageAsync(
        PageContext<ListProductsRequest, ListProductsResponse, Product> context,
        ApiFuture<ListProductsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListProductsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListProductsRequest,
          ListProductsResponse,
          Product,
          ListProductsPage,
          ListProductsFixedSizeCollection> {

    private ListProductsFixedSizeCollection(List<ListProductsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListProductsFixedSizeCollection createEmptyCollection() {
      return new ListProductsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListProductsFixedSizeCollection createCollection(
        List<ListProductsPage> pages, int collectionSize) {
      return new ListProductsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListReferenceImagesPagedResponse
      extends AbstractPagedListResponse<
          ListReferenceImagesRequest,
          ListReferenceImagesResponse,
          ReferenceImage,
          ListReferenceImagesPage,
          ListReferenceImagesFixedSizeCollection> {

    public static ApiFuture<ListReferenceImagesPagedResponse> createAsync(
        PageContext<ListReferenceImagesRequest, ListReferenceImagesResponse, ReferenceImage>
            context,
        ApiFuture<ListReferenceImagesResponse> futureResponse) {
      ApiFuture<ListReferenceImagesPage> futurePage =
          ListReferenceImagesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListReferenceImagesPage, ListReferenceImagesPagedResponse>() {
            @Override
            public ListReferenceImagesPagedResponse apply(ListReferenceImagesPage input) {
              return new ListReferenceImagesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListReferenceImagesPagedResponse(ListReferenceImagesPage page) {
      super(page, ListReferenceImagesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReferenceImagesPage
      extends AbstractPage<
          ListReferenceImagesRequest,
          ListReferenceImagesResponse,
          ReferenceImage,
          ListReferenceImagesPage> {

    private ListReferenceImagesPage(
        PageContext<ListReferenceImagesRequest, ListReferenceImagesResponse, ReferenceImage>
            context,
        ListReferenceImagesResponse response) {
      super(context, response);
    }

    private static ListReferenceImagesPage createEmptyPage() {
      return new ListReferenceImagesPage(null, null);
    }

    @Override
    protected ListReferenceImagesPage createPage(
        PageContext<ListReferenceImagesRequest, ListReferenceImagesResponse, ReferenceImage>
            context,
        ListReferenceImagesResponse response) {
      return new ListReferenceImagesPage(context, response);
    }

    @Override
    public ApiFuture<ListReferenceImagesPage> createPageAsync(
        PageContext<ListReferenceImagesRequest, ListReferenceImagesResponse, ReferenceImage>
            context,
        ApiFuture<ListReferenceImagesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReferenceImagesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReferenceImagesRequest,
          ListReferenceImagesResponse,
          ReferenceImage,
          ListReferenceImagesPage,
          ListReferenceImagesFixedSizeCollection> {

    private ListReferenceImagesFixedSizeCollection(
        List<ListReferenceImagesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReferenceImagesFixedSizeCollection createEmptyCollection() {
      return new ListReferenceImagesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReferenceImagesFixedSizeCollection createCollection(
        List<ListReferenceImagesPage> pages, int collectionSize) {
      return new ListReferenceImagesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListProductsInProductSetPagedResponse
      extends AbstractPagedListResponse<
          ListProductsInProductSetRequest,
          ListProductsInProductSetResponse,
          Product,
          ListProductsInProductSetPage,
          ListProductsInProductSetFixedSizeCollection> {

    public static ApiFuture<ListProductsInProductSetPagedResponse> createAsync(
        PageContext<ListProductsInProductSetRequest, ListProductsInProductSetResponse, Product>
            context,
        ApiFuture<ListProductsInProductSetResponse> futureResponse) {
      ApiFuture<ListProductsInProductSetPage> futurePage =
          ListProductsInProductSetPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListProductsInProductSetPage, ListProductsInProductSetPagedResponse>() {
            @Override
            public ListProductsInProductSetPagedResponse apply(ListProductsInProductSetPage input) {
              return new ListProductsInProductSetPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListProductsInProductSetPagedResponse(ListProductsInProductSetPage page) {
      super(page, ListProductsInProductSetFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListProductsInProductSetPage
      extends AbstractPage<
          ListProductsInProductSetRequest,
          ListProductsInProductSetResponse,
          Product,
          ListProductsInProductSetPage> {

    private ListProductsInProductSetPage(
        PageContext<ListProductsInProductSetRequest, ListProductsInProductSetResponse, Product>
            context,
        ListProductsInProductSetResponse response) {
      super(context, response);
    }

    private static ListProductsInProductSetPage createEmptyPage() {
      return new ListProductsInProductSetPage(null, null);
    }

    @Override
    protected ListProductsInProductSetPage createPage(
        PageContext<ListProductsInProductSetRequest, ListProductsInProductSetResponse, Product>
            context,
        ListProductsInProductSetResponse response) {
      return new ListProductsInProductSetPage(context, response);
    }

    @Override
    public ApiFuture<ListProductsInProductSetPage> createPageAsync(
        PageContext<ListProductsInProductSetRequest, ListProductsInProductSetResponse, Product>
            context,
        ApiFuture<ListProductsInProductSetResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListProductsInProductSetFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListProductsInProductSetRequest,
          ListProductsInProductSetResponse,
          Product,
          ListProductsInProductSetPage,
          ListProductsInProductSetFixedSizeCollection> {

    private ListProductsInProductSetFixedSizeCollection(
        List<ListProductsInProductSetPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListProductsInProductSetFixedSizeCollection createEmptyCollection() {
      return new ListProductsInProductSetFixedSizeCollection(null, 0);
    }

    @Override
    protected ListProductsInProductSetFixedSizeCollection createCollection(
        List<ListProductsInProductSetPage> pages, int collectionSize) {
      return new ListProductsInProductSetFixedSizeCollection(pages, collectionSize);
    }
  }
}
