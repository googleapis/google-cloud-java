/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.vision.v1p4beta1;

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
import com.google.cloud.vision.v1p4beta1.stub.ProductSearchStub;
import com.google.cloud.vision.v1p4beta1.stub.ProductSearchStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Manages Products and ProductSets of reference images for use in product
 * search. It uses the following resource model:
 *
 * <p>- The API has a collection of [ProductSet][google.cloud.vision.v1p4beta1.ProductSet]
 * resources, named `projects/&#42;/locations/&#42;/productSets/&#42;`, which acts as a way to put
 * different products into groups to limit identification.
 *
 * <p>In parallel,
 *
 * <p>- The API has a collection of [Product][google.cloud.vision.v1p4beta1.Product] resources,
 * named `projects/&#42;/locations/&#42;/products/&#42;`
 *
 * <p>- Each [Product][google.cloud.vision.v1p4beta1.Product] has a collection of
 * [ReferenceImage][google.cloud.vision.v1p4beta1.ReferenceImage] resources, named
 * `projects/&#42;/locations/&#42;/products/&#42;/referenceImages/&#42;`
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   ProductSet productSet = ProductSet.newBuilder().build();
 *   String productSetId = "";
 *   ProductSet response = productSearchClient.createProductSet(parent, productSet, productSetId);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the productSearchClient object to clean up resources such
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
 * <pre>
 * <code>
 * ProductSearchSettings productSearchSettings =
 *     ProductSearchSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ProductSearchClient productSearchClient =
 *     ProductSearchClient.create(productSearchSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ProductSearchSettings productSearchSettings =
 *     ProductSearchSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ProductSearchClient productSearchClient =
 *     ProductSearchClient.create(productSearchSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
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
   * for advanced usage - prefer to use ProductSearchSettings}.
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
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates and returns a new ProductSet resource.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns INVALID_ARGUMENT if display_name is missing, or is longer than 4096
   * characters.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ProductSet productSet = ProductSet.newBuilder().build();
   *   String productSetId = "";
   *   ProductSet response = productSearchClient.createProductSet(parent, productSet, productSetId);
   * }
   * </code></pre>
   *
   * @param parent The project in which the ProductSet should be created.
   *     <p>Format is `projects/PROJECT_ID/locations/LOC_ID`.
   * @param productSet The ProductSet to create.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates and returns a new ProductSet resource.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns INVALID_ARGUMENT if display_name is missing, or is longer than 4096
   * characters.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ProductSet productSet = ProductSet.newBuilder().build();
   *   String productSetId = "";
   *   ProductSet response = productSearchClient.createProductSet(parent.toString(), productSet, productSetId);
   * }
   * </code></pre>
   *
   * @param parent The project in which the ProductSet should be created.
   *     <p>Format is `projects/PROJECT_ID/locations/LOC_ID`.
   * @param productSet The ProductSet to create.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates and returns a new ProductSet resource.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns INVALID_ARGUMENT if display_name is missing, or is longer than 4096
   * characters.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ProductSet productSet = ProductSet.newBuilder().build();
   *   String productSetId = "";
   *   CreateProductSetRequest request = CreateProductSetRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setProductSet(productSet)
   *     .setProductSetId(productSetId)
   *     .build();
   *   ProductSet response = productSearchClient.createProductSet(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProductSet createProductSet(CreateProductSetRequest request) {
    return createProductSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates and returns a new ProductSet resource.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns INVALID_ARGUMENT if display_name is missing, or is longer than 4096
   * characters.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ProductSet productSet = ProductSet.newBuilder().build();
   *   String productSetId = "";
   *   CreateProductSetRequest request = CreateProductSetRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setProductSet(productSet)
   *     .setProductSetId(productSetId)
   *     .build();
   *   ApiFuture&lt;ProductSet&gt; future = productSearchClient.createProductSetCallable().futureCall(request);
   *   // Do something
   *   ProductSet response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateProductSetRequest, ProductSet> createProductSetCallable() {
    return stub.createProductSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists ProductSets in an unspecified order.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns INVALID_ARGUMENT if page_size is greater than 100, or less than 1.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ProductSet element : productSearchClient.listProductSets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent The project from which ProductSets should be listed.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists ProductSets in an unspecified order.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns INVALID_ARGUMENT if page_size is greater than 100, or less than 1.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ProductSet element : productSearchClient.listProductSets(parent.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent The project from which ProductSets should be listed.
   *     <p>Format is `projects/PROJECT_ID/locations/LOC_ID`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductSetsPagedResponse listProductSets(String parent) {
    ListProductSetsRequest request = ListProductSetsRequest.newBuilder().setParent(parent).build();
    return listProductSets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists ProductSets in an unspecified order.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns INVALID_ARGUMENT if page_size is greater than 100, or less than 1.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListProductSetsRequest request = ListProductSetsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (ProductSet element : productSearchClient.listProductSets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductSetsPagedResponse listProductSets(ListProductSetsRequest request) {
    return listProductSetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists ProductSets in an unspecified order.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns INVALID_ARGUMENT if page_size is greater than 100, or less than 1.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListProductSetsRequest request = ListProductSetsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListProductSetsPagedResponse&gt; future = productSearchClient.listProductSetsPagedCallable().futureCall(request);
   *   // Do something
   *   for (ProductSet element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListProductSetsRequest, ListProductSetsPagedResponse>
      listProductSetsPagedCallable() {
    return stub.listProductSetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists ProductSets in an unspecified order.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns INVALID_ARGUMENT if page_size is greater than 100, or less than 1.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListProductSetsRequest request = ListProductSetsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListProductSetsResponse response = productSearchClient.listProductSetsCallable().call(request);
   *     for (ProductSet element : response.getProductSetsList()) {
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
   * </code></pre>
   */
  public final UnaryCallable<ListProductSetsRequest, ListProductSetsResponse>
      listProductSetsCallable() {
    return stub.listProductSetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets information associated with a ProductSet.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the ProductSet does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   ProductSet response = productSearchClient.getProductSet(name);
   * }
   * </code></pre>
   *
   * @param name Resource name of the ProductSet to get.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOG_ID/productSets/PRODUCT_SET_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProductSet getProductSet(ProductSetName name) {

    GetProductSetRequest request =
        GetProductSetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets information associated with a ProductSet.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the ProductSet does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   ProductSet response = productSearchClient.getProductSet(name.toString());
   * }
   * </code></pre>
   *
   * @param name Resource name of the ProductSet to get.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOG_ID/productSets/PRODUCT_SET_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProductSet getProductSet(String name) {

    GetProductSetRequest request = GetProductSetRequest.newBuilder().setName(name).build();
    return getProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets information associated with a ProductSet.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the ProductSet does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   GetProductSetRequest request = GetProductSetRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ProductSet response = productSearchClient.getProductSet(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProductSet getProductSet(GetProductSetRequest request) {
    return getProductSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets information associated with a ProductSet.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the ProductSet does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   GetProductSetRequest request = GetProductSetRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;ProductSet&gt; future = productSearchClient.getProductSetCallable().futureCall(request);
   *   // Do something
   *   ProductSet response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetProductSetRequest, ProductSet> getProductSetCallable() {
    return stub.getProductSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Makes changes to a ProductSet resource. Only display_name can be updated currently.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the ProductSet does not exist. &#42; Returns INVALID_ARGUMENT if
   * display_name is present in update_mask but missing from the request or longer than 4096
   * characters.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSet productSet = ProductSet.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ProductSet response = productSearchClient.updateProductSet(productSet, updateMask);
   * }
   * </code></pre>
   *
   * @param productSet The ProductSet resource which replaces the one on the server.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Makes changes to a ProductSet resource. Only display_name can be updated currently.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the ProductSet does not exist. &#42; Returns INVALID_ARGUMENT if
   * display_name is present in update_mask but missing from the request or longer than 4096
   * characters.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSet productSet = ProductSet.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateProductSetRequest request = UpdateProductSetRequest.newBuilder()
   *     .setProductSet(productSet)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   ProductSet response = productSearchClient.updateProductSet(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProductSet updateProductSet(UpdateProductSetRequest request) {
    return updateProductSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Makes changes to a ProductSet resource. Only display_name can be updated currently.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the ProductSet does not exist. &#42; Returns INVALID_ARGUMENT if
   * display_name is present in update_mask but missing from the request or longer than 4096
   * characters.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSet productSet = ProductSet.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateProductSetRequest request = UpdateProductSetRequest.newBuilder()
   *     .setProductSet(productSet)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   ApiFuture&lt;ProductSet&gt; future = productSearchClient.updateProductSetCallable().futureCall(request);
   *   // Do something
   *   ProductSet response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateProductSetRequest, ProductSet> updateProductSetCallable() {
    return stub.updateProductSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Permanently deletes a ProductSet. Products and ReferenceImages in the ProductSet are not
   * deleted.
   *
   * <p>The actual image files are not deleted from Google Cloud Storage.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the ProductSet does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   productSearchClient.deleteProductSet(name);
   * }
   * </code></pre>
   *
   * @param name Resource name of the ProductSet to delete.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProductSet(ProductSetName name) {

    DeleteProductSetRequest request =
        DeleteProductSetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Permanently deletes a ProductSet. Products and ReferenceImages in the ProductSet are not
   * deleted.
   *
   * <p>The actual image files are not deleted from Google Cloud Storage.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the ProductSet does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   productSearchClient.deleteProductSet(name.toString());
   * }
   * </code></pre>
   *
   * @param name Resource name of the ProductSet to delete.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProductSet(String name) {

    DeleteProductSetRequest request = DeleteProductSetRequest.newBuilder().setName(name).build();
    deleteProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Permanently deletes a ProductSet. Products and ReferenceImages in the ProductSet are not
   * deleted.
   *
   * <p>The actual image files are not deleted from Google Cloud Storage.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the ProductSet does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   DeleteProductSetRequest request = DeleteProductSetRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   productSearchClient.deleteProductSet(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProductSet(DeleteProductSetRequest request) {
    deleteProductSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Permanently deletes a ProductSet. Products and ReferenceImages in the ProductSet are not
   * deleted.
   *
   * <p>The actual image files are not deleted from Google Cloud Storage.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the ProductSet does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   DeleteProductSetRequest request = DeleteProductSetRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = productSearchClient.deleteProductSetCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteProductSetRequest, Empty> deleteProductSetCallable() {
    return stub.deleteProductSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates and returns a new product resource.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns INVALID_ARGUMENT if display_name is missing or longer than 4096 characters.
   * &#42; Returns INVALID_ARGUMENT if description is longer than 4096 characters. &#42; Returns
   * INVALID_ARGUMENT if product_category is missing or invalid.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Product product = Product.newBuilder().build();
   *   String productId = "";
   *   Product response = productSearchClient.createProduct(parent, product, productId);
   * }
   * </code></pre>
   *
   * @param parent The project in which the Product should be created.
   *     <p>Format is `projects/PROJECT_ID/locations/LOC_ID`.
   * @param product The product to create.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates and returns a new product resource.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns INVALID_ARGUMENT if display_name is missing or longer than 4096 characters.
   * &#42; Returns INVALID_ARGUMENT if description is longer than 4096 characters. &#42; Returns
   * INVALID_ARGUMENT if product_category is missing or invalid.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Product product = Product.newBuilder().build();
   *   String productId = "";
   *   Product response = productSearchClient.createProduct(parent.toString(), product, productId);
   * }
   * </code></pre>
   *
   * @param parent The project in which the Product should be created.
   *     <p>Format is `projects/PROJECT_ID/locations/LOC_ID`.
   * @param product The product to create.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates and returns a new product resource.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns INVALID_ARGUMENT if display_name is missing or longer than 4096 characters.
   * &#42; Returns INVALID_ARGUMENT if description is longer than 4096 characters. &#42; Returns
   * INVALID_ARGUMENT if product_category is missing or invalid.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Product product = Product.newBuilder().build();
   *   String productId = "";
   *   CreateProductRequest request = CreateProductRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setProduct(product)
   *     .setProductId(productId)
   *     .build();
   *   Product response = productSearchClient.createProduct(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product createProduct(CreateProductRequest request) {
    return createProductCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates and returns a new product resource.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns INVALID_ARGUMENT if display_name is missing or longer than 4096 characters.
   * &#42; Returns INVALID_ARGUMENT if description is longer than 4096 characters. &#42; Returns
   * INVALID_ARGUMENT if product_category is missing or invalid.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Product product = Product.newBuilder().build();
   *   String productId = "";
   *   CreateProductRequest request = CreateProductRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setProduct(product)
   *     .setProductId(productId)
   *     .build();
   *   ApiFuture&lt;Product&gt; future = productSearchClient.createProductCallable().futureCall(request);
   *   // Do something
   *   Product response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateProductRequest, Product> createProductCallable() {
    return stub.createProductCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists products in an unspecified order.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Product element : productSearchClient.listProducts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent The project OR ProductSet from which Products should be listed.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists products in an unspecified order.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Product element : productSearchClient.listProducts(parent.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent The project OR ProductSet from which Products should be listed.
   *     <p>Format: `projects/PROJECT_ID/locations/LOC_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductsPagedResponse listProducts(String parent) {
    ListProductsRequest request = ListProductsRequest.newBuilder().setParent(parent).build();
    return listProducts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists products in an unspecified order.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListProductsRequest request = ListProductsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (Product element : productSearchClient.listProducts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductsPagedResponse listProducts(ListProductsRequest request) {
    return listProductsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists products in an unspecified order.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListProductsRequest request = ListProductsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListProductsPagedResponse&gt; future = productSearchClient.listProductsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Product element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListProductsRequest, ListProductsPagedResponse>
      listProductsPagedCallable() {
    return stub.listProductsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists products in an unspecified order.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListProductsRequest request = ListProductsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListProductsResponse response = productSearchClient.listProductsCallable().call(request);
   *     for (Product element : response.getProductsList()) {
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
   * </code></pre>
   */
  public final UnaryCallable<ListProductsRequest, ListProductsResponse> listProductsCallable() {
    return stub.listProductsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets information associated with a Product.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the Product does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductName name = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   Product response = productSearchClient.getProduct(name);
   * }
   * </code></pre>
   *
   * @param name Resource name of the Product to get.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product getProduct(ProductName name) {

    GetProductRequest request =
        GetProductRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets information associated with a Product.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the Product does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductName name = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   Product response = productSearchClient.getProduct(name.toString());
   * }
   * </code></pre>
   *
   * @param name Resource name of the Product to get.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product getProduct(String name) {

    GetProductRequest request = GetProductRequest.newBuilder().setName(name).build();
    return getProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets information associated with a Product.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the Product does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductName name = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   GetProductRequest request = GetProductRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Product response = productSearchClient.getProduct(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product getProduct(GetProductRequest request) {
    return getProductCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets information associated with a Product.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the Product does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductName name = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   GetProductRequest request = GetProductRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Product&gt; future = productSearchClient.getProductCallable().futureCall(request);
   *   // Do something
   *   Product response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetProductRequest, Product> getProductCallable() {
    return stub.getProductCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Makes changes to a Product resource. Only the `display_name`, `description`, and `labels`
   * fields can be updated right now.
   *
   * <p>If labels are updated, the change will not be reflected in queries until the next index
   * time.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the Product does not exist. &#42; Returns INVALID_ARGUMENT if
   * display_name is present in update_mask but is missing from the request or longer than 4096
   * characters. &#42; Returns INVALID_ARGUMENT if description is present in update_mask but is
   * longer than 4096 characters. &#42; Returns INVALID_ARGUMENT if product_category is present in
   * update_mask.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   Product product = Product.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Product response = productSearchClient.updateProduct(product, updateMask);
   * }
   * </code></pre>
   *
   * @param product The Product resource which replaces the one on the server. product.name is
   *     immutable.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Makes changes to a Product resource. Only the `display_name`, `description`, and `labels`
   * fields can be updated right now.
   *
   * <p>If labels are updated, the change will not be reflected in queries until the next index
   * time.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the Product does not exist. &#42; Returns INVALID_ARGUMENT if
   * display_name is present in update_mask but is missing from the request or longer than 4096
   * characters. &#42; Returns INVALID_ARGUMENT if description is present in update_mask but is
   * longer than 4096 characters. &#42; Returns INVALID_ARGUMENT if product_category is present in
   * update_mask.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   Product product = Product.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateProductRequest request = UpdateProductRequest.newBuilder()
   *     .setProduct(product)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   Product response = productSearchClient.updateProduct(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product updateProduct(UpdateProductRequest request) {
    return updateProductCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Makes changes to a Product resource. Only the `display_name`, `description`, and `labels`
   * fields can be updated right now.
   *
   * <p>If labels are updated, the change will not be reflected in queries until the next index
   * time.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the Product does not exist. &#42; Returns INVALID_ARGUMENT if
   * display_name is present in update_mask but is missing from the request or longer than 4096
   * characters. &#42; Returns INVALID_ARGUMENT if description is present in update_mask but is
   * longer than 4096 characters. &#42; Returns INVALID_ARGUMENT if product_category is present in
   * update_mask.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   Product product = Product.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateProductRequest request = UpdateProductRequest.newBuilder()
   *     .setProduct(product)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   ApiFuture&lt;Product&gt; future = productSearchClient.updateProductCallable().futureCall(request);
   *   // Do something
   *   Product response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateProductRequest, Product> updateProductCallable() {
    return stub.updateProductCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Permanently deletes a product and its reference images.
   *
   * <p>Metadata of the product and all its images will be deleted right away, but search queries
   * against ProductSets containing the product may still work until all related caches are
   * refreshed.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the product does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductName name = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   productSearchClient.deleteProduct(name);
   * }
   * </code></pre>
   *
   * @param name Resource name of product to delete.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProduct(ProductName name) {

    DeleteProductRequest request =
        DeleteProductRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Permanently deletes a product and its reference images.
   *
   * <p>Metadata of the product and all its images will be deleted right away, but search queries
   * against ProductSets containing the product may still work until all related caches are
   * refreshed.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the product does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductName name = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   productSearchClient.deleteProduct(name.toString());
   * }
   * </code></pre>
   *
   * @param name Resource name of product to delete.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProduct(String name) {

    DeleteProductRequest request = DeleteProductRequest.newBuilder().setName(name).build();
    deleteProduct(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Permanently deletes a product and its reference images.
   *
   * <p>Metadata of the product and all its images will be deleted right away, but search queries
   * against ProductSets containing the product may still work until all related caches are
   * refreshed.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the product does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductName name = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   DeleteProductRequest request = DeleteProductRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   productSearchClient.deleteProduct(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProduct(DeleteProductRequest request) {
    deleteProductCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Permanently deletes a product and its reference images.
   *
   * <p>Metadata of the product and all its images will be deleted right away, but search queries
   * against ProductSets containing the product may still work until all related caches are
   * refreshed.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the product does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductName name = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   DeleteProductRequest request = DeleteProductRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = productSearchClient.deleteProductCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteProductRequest, Empty> deleteProductCallable() {
    return stub.deleteProductCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
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
   * <p>&#42; Returns INVALID_ARGUMENT if the image_uri is missing or longer than 4096 characters.
   * &#42; Returns INVALID_ARGUMENT if the product does not exist. &#42; Returns INVALID_ARGUMENT if
   * bounding_poly is not provided, and nothing compatible with the parent product's
   * product_category is detected. &#42; Returns INVALID_ARGUMENT if bounding_poly contains more
   * than 10 polygons.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductName parent = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   ReferenceImage referenceImage = ReferenceImage.newBuilder().build();
   *   String referenceImageId = "";
   *   ReferenceImage response = productSearchClient.createReferenceImage(parent, referenceImage, referenceImageId);
   * }
   * </code></pre>
   *
   * @param parent Resource name of the product in which to create the reference image.
   *     <p>Format is `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`.
   * @param referenceImage The reference image to create. If an image ID is specified, it is
   *     ignored.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
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
   * <p>&#42; Returns INVALID_ARGUMENT if the image_uri is missing or longer than 4096 characters.
   * &#42; Returns INVALID_ARGUMENT if the product does not exist. &#42; Returns INVALID_ARGUMENT if
   * bounding_poly is not provided, and nothing compatible with the parent product's
   * product_category is detected. &#42; Returns INVALID_ARGUMENT if bounding_poly contains more
   * than 10 polygons.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductName parent = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   ReferenceImage referenceImage = ReferenceImage.newBuilder().build();
   *   String referenceImageId = "";
   *   ReferenceImage response = productSearchClient.createReferenceImage(parent.toString(), referenceImage, referenceImageId);
   * }
   * </code></pre>
   *
   * @param parent Resource name of the product in which to create the reference image.
   *     <p>Format is `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`.
   * @param referenceImage The reference image to create. If an image ID is specified, it is
   *     ignored.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
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
   * <p>&#42; Returns INVALID_ARGUMENT if the image_uri is missing or longer than 4096 characters.
   * &#42; Returns INVALID_ARGUMENT if the product does not exist. &#42; Returns INVALID_ARGUMENT if
   * bounding_poly is not provided, and nothing compatible with the parent product's
   * product_category is detected. &#42; Returns INVALID_ARGUMENT if bounding_poly contains more
   * than 10 polygons.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductName parent = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   ReferenceImage referenceImage = ReferenceImage.newBuilder().build();
   *   String referenceImageId = "";
   *   CreateReferenceImageRequest request = CreateReferenceImageRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setReferenceImage(referenceImage)
   *     .setReferenceImageId(referenceImageId)
   *     .build();
   *   ReferenceImage response = productSearchClient.createReferenceImage(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReferenceImage createReferenceImage(CreateReferenceImageRequest request) {
    return createReferenceImageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
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
   * <p>&#42; Returns INVALID_ARGUMENT if the image_uri is missing or longer than 4096 characters.
   * &#42; Returns INVALID_ARGUMENT if the product does not exist. &#42; Returns INVALID_ARGUMENT if
   * bounding_poly is not provided, and nothing compatible with the parent product's
   * product_category is detected. &#42; Returns INVALID_ARGUMENT if bounding_poly contains more
   * than 10 polygons.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductName parent = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   ReferenceImage referenceImage = ReferenceImage.newBuilder().build();
   *   String referenceImageId = "";
   *   CreateReferenceImageRequest request = CreateReferenceImageRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setReferenceImage(referenceImage)
   *     .setReferenceImageId(referenceImageId)
   *     .build();
   *   ApiFuture&lt;ReferenceImage&gt; future = productSearchClient.createReferenceImageCallable().futureCall(request);
   *   // Do something
   *   ReferenceImage response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateReferenceImageRequest, ReferenceImage>
      createReferenceImageCallable() {
    return stub.createReferenceImageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
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
   * <p>&#42; Returns NOT_FOUND if the reference image does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ReferenceImageName name = ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]");
   *   productSearchClient.deleteReferenceImage(name);
   * }
   * </code></pre>
   *
   * @param name The resource name of the reference image to delete.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
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
   * <p>&#42; Returns NOT_FOUND if the reference image does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ReferenceImageName name = ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]");
   *   productSearchClient.deleteReferenceImage(name.toString());
   * }
   * </code></pre>
   *
   * @param name The resource name of the reference image to delete.
   *     <p>Format is:
   *     <p>`projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID/referenceImages/IMAGE_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReferenceImage(String name) {

    DeleteReferenceImageRequest request =
        DeleteReferenceImageRequest.newBuilder().setName(name).build();
    deleteReferenceImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
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
   * <p>&#42; Returns NOT_FOUND if the reference image does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ReferenceImageName name = ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]");
   *   DeleteReferenceImageRequest request = DeleteReferenceImageRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   productSearchClient.deleteReferenceImage(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReferenceImage(DeleteReferenceImageRequest request) {
    deleteReferenceImageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
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
   * <p>&#42; Returns NOT_FOUND if the reference image does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ReferenceImageName name = ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]");
   *   DeleteReferenceImageRequest request = DeleteReferenceImageRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = productSearchClient.deleteReferenceImageCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteReferenceImageRequest, Empty> deleteReferenceImageCallable() {
    return stub.deleteReferenceImageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists reference images.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the parent product does not exist. &#42; Returns INVALID_ARGUMENT
   * if the page_size is greater than 100, or less than 1.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductName parent = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   for (ReferenceImage element : productSearchClient.listReferenceImages(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Resource name of the product containing the reference images.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists reference images.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the parent product does not exist. &#42; Returns INVALID_ARGUMENT
   * if the page_size is greater than 100, or less than 1.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductName parent = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   for (ReferenceImage element : productSearchClient.listReferenceImages(parent.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Resource name of the product containing the reference images.
   *     <p>Format is `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReferenceImagesPagedResponse listReferenceImages(String parent) {
    ListReferenceImagesRequest request =
        ListReferenceImagesRequest.newBuilder().setParent(parent).build();
    return listReferenceImages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists reference images.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the parent product does not exist. &#42; Returns INVALID_ARGUMENT
   * if the page_size is greater than 100, or less than 1.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductName parent = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   ListReferenceImagesRequest request = ListReferenceImagesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (ReferenceImage element : productSearchClient.listReferenceImages(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReferenceImagesPagedResponse listReferenceImages(
      ListReferenceImagesRequest request) {
    return listReferenceImagesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists reference images.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the parent product does not exist. &#42; Returns INVALID_ARGUMENT
   * if the page_size is greater than 100, or less than 1.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductName parent = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   ListReferenceImagesRequest request = ListReferenceImagesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListReferenceImagesPagedResponse&gt; future = productSearchClient.listReferenceImagesPagedCallable().futureCall(request);
   *   // Do something
   *   for (ReferenceImage element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListReferenceImagesRequest, ListReferenceImagesPagedResponse>
      listReferenceImagesPagedCallable() {
    return stub.listReferenceImagesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists reference images.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the parent product does not exist. &#42; Returns INVALID_ARGUMENT
   * if the page_size is greater than 100, or less than 1.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductName parent = ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   ListReferenceImagesRequest request = ListReferenceImagesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListReferenceImagesResponse response = productSearchClient.listReferenceImagesCallable().call(request);
   *     for (ReferenceImage element : response.getReferenceImagesList()) {
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
   * </code></pre>
   */
  public final UnaryCallable<ListReferenceImagesRequest, ListReferenceImagesResponse>
      listReferenceImagesCallable() {
    return stub.listReferenceImagesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets information associated with a ReferenceImage.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the specified image does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ReferenceImageName name = ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]");
   *   ReferenceImage response = productSearchClient.getReferenceImage(name);
   * }
   * </code></pre>
   *
   * @param name The resource name of the ReferenceImage to get.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets information associated with a ReferenceImage.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the specified image does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ReferenceImageName name = ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]");
   *   ReferenceImage response = productSearchClient.getReferenceImage(name.toString());
   * }
   * </code></pre>
   *
   * @param name The resource name of the ReferenceImage to get.
   *     <p>Format is:
   *     <p>`projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID/referenceImages/IMAGE_ID`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReferenceImage getReferenceImage(String name) {

    GetReferenceImageRequest request = GetReferenceImageRequest.newBuilder().setName(name).build();
    return getReferenceImage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets information associated with a ReferenceImage.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the specified image does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ReferenceImageName name = ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]");
   *   GetReferenceImageRequest request = GetReferenceImageRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ReferenceImage response = productSearchClient.getReferenceImage(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReferenceImage getReferenceImage(GetReferenceImageRequest request) {
    return getReferenceImageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets information associated with a ReferenceImage.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the specified image does not exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ReferenceImageName name = ReferenceImageName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[REFERENCE_IMAGE]");
   *   GetReferenceImageRequest request = GetReferenceImageRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;ReferenceImage&gt; future = productSearchClient.getReferenceImageCallable().futureCall(request);
   *   // Do something
   *   ReferenceImage response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetReferenceImageRequest, ReferenceImage> getReferenceImageCallable() {
    return stub.getReferenceImageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds a Product to the specified ProductSet. If the Product is already present, no change is
   * made.
   *
   * <p>One Product can be added to at most 100 ProductSets.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the Product or the ProductSet doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   String product = "";
   *   productSearchClient.addProductToProductSet(name, product);
   * }
   * </code></pre>
   *
   * @param name The resource name for the ProductSet to modify.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
   * @param product The resource name for the Product to be added to this ProductSet.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds a Product to the specified ProductSet. If the Product is already present, no change is
   * made.
   *
   * <p>One Product can be added to at most 100 ProductSets.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the Product or the ProductSet doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   String product = "";
   *   productSearchClient.addProductToProductSet(name.toString(), product);
   * }
   * </code></pre>
   *
   * @param name The resource name for the ProductSet to modify.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
   * @param product The resource name for the Product to be added to this ProductSet.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void addProductToProductSet(String name, String product) {

    AddProductToProductSetRequest request =
        AddProductToProductSetRequest.newBuilder().setName(name).setProduct(product).build();
    addProductToProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds a Product to the specified ProductSet. If the Product is already present, no change is
   * made.
   *
   * <p>One Product can be added to at most 100 ProductSets.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the Product or the ProductSet doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   String product = "";
   *   AddProductToProductSetRequest request = AddProductToProductSetRequest.newBuilder()
   *     .setName(name.toString())
   *     .setProduct(product)
   *     .build();
   *   productSearchClient.addProductToProductSet(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void addProductToProductSet(AddProductToProductSetRequest request) {
    addProductToProductSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds a Product to the specified ProductSet. If the Product is already present, no change is
   * made.
   *
   * <p>One Product can be added to at most 100 ProductSets.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND if the Product or the ProductSet doesn't exist.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   String product = "";
   *   AddProductToProductSetRequest request = AddProductToProductSetRequest.newBuilder()
   *     .setName(name.toString())
   *     .setProduct(product)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = productSearchClient.addProductToProductSetCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AddProductToProductSetRequest, Empty>
      addProductToProductSetCallable() {
    return stub.addProductToProductSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes a Product from the specified ProductSet.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND If the Product is not found under the ProductSet.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   String product = "";
   *   productSearchClient.removeProductFromProductSet(name, product);
   * }
   * </code></pre>
   *
   * @param name The resource name for the ProductSet to modify.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
   * @param product The resource name for the Product to be removed from this ProductSet.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes a Product from the specified ProductSet.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND If the Product is not found under the ProductSet.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   String product = "";
   *   productSearchClient.removeProductFromProductSet(name.toString(), product);
   * }
   * </code></pre>
   *
   * @param name The resource name for the ProductSet to modify.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
   * @param product The resource name for the Product to be removed from this ProductSet.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void removeProductFromProductSet(String name, String product) {

    RemoveProductFromProductSetRequest request =
        RemoveProductFromProductSetRequest.newBuilder().setName(name).setProduct(product).build();
    removeProductFromProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes a Product from the specified ProductSet.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND If the Product is not found under the ProductSet.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   String product = "";
   *   RemoveProductFromProductSetRequest request = RemoveProductFromProductSetRequest.newBuilder()
   *     .setName(name.toString())
   *     .setProduct(product)
   *     .build();
   *   productSearchClient.removeProductFromProductSet(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void removeProductFromProductSet(RemoveProductFromProductSetRequest request) {
    removeProductFromProductSetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes a Product from the specified ProductSet.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns NOT_FOUND If the Product is not found under the ProductSet.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   String product = "";
   *   RemoveProductFromProductSetRequest request = RemoveProductFromProductSetRequest.newBuilder()
   *     .setName(name.toString())
   *     .setProduct(product)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = productSearchClient.removeProductFromProductSetCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RemoveProductFromProductSetRequest, Empty>
      removeProductFromProductSetCallable() {
    return stub.removeProductFromProductSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the Products in a ProductSet, in an unspecified order. If the ProductSet does not exist,
   * the products field of the response will be empty.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   for (Product element : productSearchClient.listProductsInProductSet(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param name The ProductSet resource for which to retrieve Products.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the Products in a ProductSet, in an unspecified order. If the ProductSet does not exist,
   * the products field of the response will be empty.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   for (Product element : productSearchClient.listProductsInProductSet(name.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param name The ProductSet resource for which to retrieve Products.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductsInProductSetPagedResponse listProductsInProductSet(String name) {
    ListProductsInProductSetRequest request =
        ListProductsInProductSetRequest.newBuilder().setName(name).build();
    return listProductsInProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the Products in a ProductSet, in an unspecified order. If the ProductSet does not exist,
   * the products field of the response will be empty.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   ListProductsInProductSetRequest request = ListProductsInProductSetRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   for (Product element : productSearchClient.listProductsInProductSet(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProductsInProductSetPagedResponse listProductsInProductSet(
      ListProductsInProductSetRequest request) {
    return listProductsInProductSetPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the Products in a ProductSet, in an unspecified order. If the ProductSet does not exist,
   * the products field of the response will be empty.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   ListProductsInProductSetRequest request = ListProductsInProductSetRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;ListProductsInProductSetPagedResponse&gt; future = productSearchClient.listProductsInProductSetPagedCallable().futureCall(request);
   *   // Do something
   *   for (Product element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListProductsInProductSetRequest, ListProductsInProductSetPagedResponse>
      listProductsInProductSetPagedCallable() {
    return stub.listProductsInProductSetPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the Products in a ProductSet, in an unspecified order. If the ProductSet does not exist,
   * the products field of the response will be empty.
   *
   * <p>Possible errors:
   *
   * <p>&#42; Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   ProductSetName name = ProductSetName.of("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   ListProductsInProductSetRequest request = ListProductsInProductSetRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   while (true) {
   *     ListProductsInProductSetResponse response = productSearchClient.listProductsInProductSetCallable().call(request);
   *     for (Product element : response.getProductsList()) {
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
   * </code></pre>
   */
  public final UnaryCallable<ListProductsInProductSetRequest, ListProductsInProductSetResponse>
      listProductsInProductSetCallable() {
    return stub.listProductsInProductSetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
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
   * [ImportProductSetsGcsSource.csv_file_uri][google.cloud.vision.v1p4beta1.ImportProductSetsGcsSource.csv_file_uri].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ImportProductSetsInputConfig inputConfig = ImportProductSetsInputConfig.newBuilder().build();
   *   ImportProductSetsResponse response = productSearchClient.importProductSetsAsync(parent, inputConfig).get();
   * }
   * </code></pre>
   *
   * @param parent The project in which the ProductSets should be imported.
   *     <p>Format is `projects/PROJECT_ID/locations/LOC_ID`.
   * @param inputConfig The input content for the list of requests.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<ImportProductSetsResponse, BatchOperationMetadata>
      importProductSetsAsync(LocationName parent, ImportProductSetsInputConfig inputConfig) {

    ImportProductSetsRequest request =
        ImportProductSetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInputConfig(inputConfig)
            .build();
    return importProductSetsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
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
   * [ImportProductSetsGcsSource.csv_file_uri][google.cloud.vision.v1p4beta1.ImportProductSetsGcsSource.csv_file_uri].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ImportProductSetsInputConfig inputConfig = ImportProductSetsInputConfig.newBuilder().build();
   *   ImportProductSetsResponse response = productSearchClient.importProductSetsAsync(parent.toString(), inputConfig).get();
   * }
   * </code></pre>
   *
   * @param parent The project in which the ProductSets should be imported.
   *     <p>Format is `projects/PROJECT_ID/locations/LOC_ID`.
   * @param inputConfig The input content for the list of requests.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<ImportProductSetsResponse, BatchOperationMetadata>
      importProductSetsAsync(String parent, ImportProductSetsInputConfig inputConfig) {

    ImportProductSetsRequest request =
        ImportProductSetsRequest.newBuilder().setParent(parent).setInputConfig(inputConfig).build();
    return importProductSetsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
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
   * [ImportProductSetsGcsSource.csv_file_uri][google.cloud.vision.v1p4beta1.ImportProductSetsGcsSource.csv_file_uri].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ImportProductSetsInputConfig inputConfig = ImportProductSetsInputConfig.newBuilder().build();
   *   ImportProductSetsRequest request = ImportProductSetsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setInputConfig(inputConfig)
   *     .build();
   *   ImportProductSetsResponse response = productSearchClient.importProductSetsAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<ImportProductSetsResponse, BatchOperationMetadata>
      importProductSetsAsync(ImportProductSetsRequest request) {
    return importProductSetsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
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
   * [ImportProductSetsGcsSource.csv_file_uri][google.cloud.vision.v1p4beta1.ImportProductSetsGcsSource.csv_file_uri].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ImportProductSetsInputConfig inputConfig = ImportProductSetsInputConfig.newBuilder().build();
   *   ImportProductSetsRequest request = ImportProductSetsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setInputConfig(inputConfig)
   *     .build();
   *   OperationFuture&lt;ImportProductSetsResponse, BatchOperationMetadata&gt; future = productSearchClient.importProductSetsOperationCallable().futureCall(request);
   *   // Do something
   *   ImportProductSetsResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<
          ImportProductSetsRequest, ImportProductSetsResponse, BatchOperationMetadata>
      importProductSetsOperationCallable() {
    return stub.importProductSetsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
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
   * [ImportProductSetsGcsSource.csv_file_uri][google.cloud.vision.v1p4beta1.ImportProductSetsGcsSource.csv_file_uri].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ImportProductSetsInputConfig inputConfig = ImportProductSetsInputConfig.newBuilder().build();
   *   ImportProductSetsRequest request = ImportProductSetsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setInputConfig(inputConfig)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = productSearchClient.importProductSetsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
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
