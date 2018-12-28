/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.vision.v1;

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
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.vision.v1.stub.ProductSearchStub;
import com.google.cloud.vision.v1.stub.ProductSearchStubSettings;
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
 * <p>- The API has a collection of [ProductSet][google.cloud.vision.v1.ProductSet] resources, named
 * `projects/&#42;/locations/&#42;/productSets/&#42;`, which acts as a way to put different products
 * into groups to limit identification.
 *
 * <p>In parallel,
 *
 * <p>- The API has a collection of [Product][google.cloud.vision.v1.Product] resources, named
 * `projects/&#42;/locations/&#42;/products/&#42;`
 *
 * <p>- Each [Product][google.cloud.vision.v1.Product] has a collection of
 * [ReferenceImage][google.cloud.vision.v1.ReferenceImage] resources, named
 * `projects/&#42;/locations/&#42;/products/&#42;/referenceImages/&#42;`
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
 *   String formattedParent = ProductSearchClient.formatLocationName("[PROJECT]", "[LOCATION]");
 *   Product product = Product.newBuilder().build();
 *   String productId = "";
 *   Product response = productSearchClient.createProduct(formattedParent, product, productId);
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
public class ProductSearchClient implements BackgroundResource {
  private final ProductSearchSettings settings;
  private final ProductSearchStub stub;
  private final OperationsClient operationsClient;

  private static final PathTemplate LOCATION_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/locations/{location}");

  private static final PathTemplate PRODUCT_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/products/{product}");

  private static final PathTemplate PRODUCT_SET_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/productSets/{product_set}");

  private static final PathTemplate IMAGE_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/products/{product}/referenceImages/{image}");

  /** Formats a string containing the fully-qualified path to represent a location resource. */
  public static final String formatLocationName(String project, String location) {
    return LOCATION_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location);
  }

  /** Formats a string containing the fully-qualified path to represent a product resource. */
  public static final String formatProductName(String project, String location, String product) {
    return PRODUCT_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location,
        "product", product);
  }

  /** Formats a string containing the fully-qualified path to represent a product_set resource. */
  public static final String formatProductSetName(
      String project, String location, String productSet) {
    return PRODUCT_SET_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location,
        "product_set", productSet);
  }

  /** Formats a string containing the fully-qualified path to represent a image resource. */
  public static final String formatImageName(
      String project, String location, String product, String image) {
    return IMAGE_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location,
        "product", product,
        "image", image);
  }

  /**
   * Parses the project from the given fully-qualified path which represents a location resource.
   */
  public static final String parseProjectFromLocationName(String locationName) {
    return LOCATION_PATH_TEMPLATE.parse(locationName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a location resource.
   */
  public static final String parseLocationFromLocationName(String locationName) {
    return LOCATION_PATH_TEMPLATE.parse(locationName).get("location");
  }

  /** Parses the project from the given fully-qualified path which represents a product resource. */
  public static final String parseProjectFromProductName(String productName) {
    return PRODUCT_PATH_TEMPLATE.parse(productName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a product resource.
   */
  public static final String parseLocationFromProductName(String productName) {
    return PRODUCT_PATH_TEMPLATE.parse(productName).get("location");
  }

  /** Parses the product from the given fully-qualified path which represents a product resource. */
  public static final String parseProductFromProductName(String productName) {
    return PRODUCT_PATH_TEMPLATE.parse(productName).get("product");
  }

  /**
   * Parses the project from the given fully-qualified path which represents a product_set resource.
   */
  public static final String parseProjectFromProductSetName(String productSetName) {
    return PRODUCT_SET_PATH_TEMPLATE.parse(productSetName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a product_set
   * resource.
   */
  public static final String parseLocationFromProductSetName(String productSetName) {
    return PRODUCT_SET_PATH_TEMPLATE.parse(productSetName).get("location");
  }

  /**
   * Parses the product_set from the given fully-qualified path which represents a product_set
   * resource.
   */
  public static final String parseProductSetFromProductSetName(String productSetName) {
    return PRODUCT_SET_PATH_TEMPLATE.parse(productSetName).get("product_set");
  }

  /** Parses the project from the given fully-qualified path which represents a image resource. */
  public static final String parseProjectFromImageName(String imageName) {
    return IMAGE_PATH_TEMPLATE.parse(imageName).get("project");
  }

  /** Parses the location from the given fully-qualified path which represents a image resource. */
  public static final String parseLocationFromImageName(String imageName) {
    return IMAGE_PATH_TEMPLATE.parse(imageName).get("location");
  }

  /** Parses the product from the given fully-qualified path which represents a image resource. */
  public static final String parseProductFromImageName(String imageName) {
    return IMAGE_PATH_TEMPLATE.parse(imageName).get("product");
  }

  /** Parses the image from the given fully-qualified path which represents a image resource. */
  public static final String parseImageFromImageName(String imageName) {
    return IMAGE_PATH_TEMPLATE.parse(imageName).get("image");
  }

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
   *   String formattedParent = ProductSearchClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   Product product = Product.newBuilder().build();
   *   String productId = "";
   *   Product response = productSearchClient.createProduct(formattedParent, product, productId);
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
    LOCATION_PATH_TEMPLATE.validate(parent, "createProduct");
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
   *   String formattedParent = ProductSearchClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   Product product = Product.newBuilder().build();
   *   CreateProductRequest request = CreateProductRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setProduct(product)
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
   *   String formattedParent = ProductSearchClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   Product product = Product.newBuilder().build();
   *   CreateProductRequest request = CreateProductRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setProduct(product)
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
   *   String formattedParent = ProductSearchClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   for (Product element : productSearchClient.listProducts(formattedParent).iterateAll()) {
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
    LOCATION_PATH_TEMPLATE.validate(parent, "listProducts");
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
   *   String formattedParent = ProductSearchClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ListProductsRequest request = ListProductsRequest.newBuilder()
   *     .setParent(formattedParent)
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
   *   String formattedParent = ProductSearchClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ListProductsRequest request = ListProductsRequest.newBuilder()
   *     .setParent(formattedParent)
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
   *   String formattedParent = ProductSearchClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ListProductsRequest request = ListProductsRequest.newBuilder()
   *     .setParent(formattedParent)
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
   *   String formattedName = ProductSearchClient.formatProductName("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   Product response = productSearchClient.getProduct(formattedName);
   * }
   * </code></pre>
   *
   * @param name Resource name of the Product to get.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Product getProduct(String name) {
    PRODUCT_PATH_TEMPLATE.validate(name, "getProduct");
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
   *   String formattedName = ProductSearchClient.formatProductName("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   GetProductRequest request = GetProductRequest.newBuilder()
   *     .setName(formattedName)
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
   *   String formattedName = ProductSearchClient.formatProductName("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   GetProductRequest request = GetProductRequest.newBuilder()
   *     .setName(formattedName)
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
   *   UpdateProductRequest request = UpdateProductRequest.newBuilder()
   *     .setProduct(product)
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
   *   UpdateProductRequest request = UpdateProductRequest.newBuilder()
   *     .setProduct(product)
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
   *   String formattedName = ProductSearchClient.formatProductName("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   productSearchClient.deleteProduct(formattedName);
   * }
   * </code></pre>
   *
   * @param name Resource name of product to delete.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProduct(String name) {
    PRODUCT_PATH_TEMPLATE.validate(name, "deleteProduct");
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
   *   String formattedName = ProductSearchClient.formatProductName("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   DeleteProductRequest request = DeleteProductRequest.newBuilder()
   *     .setName(formattedName)
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
   *   String formattedName = ProductSearchClient.formatProductName("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   DeleteProductRequest request = DeleteProductRequest.newBuilder()
   *     .setName(formattedName)
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
   *   String formattedParent = ProductSearchClient.formatProductName("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   for (ReferenceImage element : productSearchClient.listReferenceImages(formattedParent).iterateAll()) {
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
    PRODUCT_PATH_TEMPLATE.validate(parent, "listReferenceImages");
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
   *   String formattedParent = ProductSearchClient.formatProductName("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   ListReferenceImagesRequest request = ListReferenceImagesRequest.newBuilder()
   *     .setParent(formattedParent)
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
   *   String formattedParent = ProductSearchClient.formatProductName("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   ListReferenceImagesRequest request = ListReferenceImagesRequest.newBuilder()
   *     .setParent(formattedParent)
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
   *   String formattedParent = ProductSearchClient.formatProductName("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   ListReferenceImagesRequest request = ListReferenceImagesRequest.newBuilder()
   *     .setParent(formattedParent)
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
   *   String formattedName = ProductSearchClient.formatImageName("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[IMAGE]");
   *   ReferenceImage response = productSearchClient.getReferenceImage(formattedName);
   * }
   * </code></pre>
   *
   * @param name The resource name of the ReferenceImage to get.
   *     <p>Format is:
   *     <p>`projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID/referenceImages/IMAGE_ID`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReferenceImage getReferenceImage(String name) {
    IMAGE_PATH_TEMPLATE.validate(name, "getReferenceImage");
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
   *   String formattedName = ProductSearchClient.formatImageName("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[IMAGE]");
   *   GetReferenceImageRequest request = GetReferenceImageRequest.newBuilder()
   *     .setName(formattedName)
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
   *   String formattedName = ProductSearchClient.formatImageName("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[IMAGE]");
   *   GetReferenceImageRequest request = GetReferenceImageRequest.newBuilder()
   *     .setName(formattedName)
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
   *   String formattedName = ProductSearchClient.formatImageName("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[IMAGE]");
   *   productSearchClient.deleteReferenceImage(formattedName);
   * }
   * </code></pre>
   *
   * @param name The resource name of the reference image to delete.
   *     <p>Format is:
   *     <p>`projects/PROJECT_ID/locations/LOC_ID/products/PRODUCT_ID/referenceImages/IMAGE_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReferenceImage(String name) {
    IMAGE_PATH_TEMPLATE.validate(name, "deleteReferenceImage");
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
   *   String formattedName = ProductSearchClient.formatImageName("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[IMAGE]");
   *   DeleteReferenceImageRequest request = DeleteReferenceImageRequest.newBuilder()
   *     .setName(formattedName)
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
   *   String formattedName = ProductSearchClient.formatImageName("[PROJECT]", "[LOCATION]", "[PRODUCT]", "[IMAGE]");
   *   DeleteReferenceImageRequest request = DeleteReferenceImageRequest.newBuilder()
   *     .setName(formattedName)
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
   *   String formattedParent = ProductSearchClient.formatProductName("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   ReferenceImage referenceImage = ReferenceImage.newBuilder().build();
   *   String referenceImageId = "";
   *   ReferenceImage response = productSearchClient.createReferenceImage(formattedParent, referenceImage, referenceImageId);
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
    PRODUCT_PATH_TEMPLATE.validate(parent, "createReferenceImage");
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
   *   String formattedParent = ProductSearchClient.formatProductName("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   ReferenceImage referenceImage = ReferenceImage.newBuilder().build();
   *   CreateReferenceImageRequest request = CreateReferenceImageRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setReferenceImage(referenceImage)
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
   *   String formattedParent = ProductSearchClient.formatProductName("[PROJECT]", "[LOCATION]", "[PRODUCT]");
   *   ReferenceImage referenceImage = ReferenceImage.newBuilder().build();
   *   CreateReferenceImageRequest request = CreateReferenceImageRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setReferenceImage(referenceImage)
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
   *   String formattedParent = ProductSearchClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ProductSet productSet = ProductSet.newBuilder().build();
   *   String productSetId = "";
   *   ProductSet response = productSearchClient.createProductSet(formattedParent, productSet, productSetId);
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
    LOCATION_PATH_TEMPLATE.validate(parent, "createProductSet");
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
   *   String formattedParent = ProductSearchClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ProductSet productSet = ProductSet.newBuilder().build();
   *   CreateProductSetRequest request = CreateProductSetRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setProductSet(productSet)
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
   *   String formattedParent = ProductSearchClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ProductSet productSet = ProductSet.newBuilder().build();
   *   CreateProductSetRequest request = CreateProductSetRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setProductSet(productSet)
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
   *   String formattedParent = ProductSearchClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   for (ProductSet element : productSearchClient.listProductSets(formattedParent).iterateAll()) {
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
    LOCATION_PATH_TEMPLATE.validate(parent, "listProductSets");
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
   *   String formattedParent = ProductSearchClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ListProductSetsRequest request = ListProductSetsRequest.newBuilder()
   *     .setParent(formattedParent)
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
   *   String formattedParent = ProductSearchClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ListProductSetsRequest request = ListProductSetsRequest.newBuilder()
   *     .setParent(formattedParent)
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
   *   String formattedParent = ProductSearchClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ListProductSetsRequest request = ListProductSetsRequest.newBuilder()
   *     .setParent(formattedParent)
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
   *   String formattedName = ProductSearchClient.formatProductSetName("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   ProductSet response = productSearchClient.getProductSet(formattedName);
   * }
   * </code></pre>
   *
   * @param name Resource name of the ProductSet to get.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOG_ID/productSets/PRODUCT_SET_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProductSet getProductSet(String name) {
    PRODUCT_SET_PATH_TEMPLATE.validate(name, "getProductSet");
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
   *   String formattedName = ProductSearchClient.formatProductSetName("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   GetProductSetRequest request = GetProductSetRequest.newBuilder()
   *     .setName(formattedName)
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
   *   String formattedName = ProductSearchClient.formatProductSetName("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   GetProductSetRequest request = GetProductSetRequest.newBuilder()
   *     .setName(formattedName)
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
   *   UpdateProductSetRequest request = UpdateProductSetRequest.newBuilder()
   *     .setProductSet(productSet)
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
   *   UpdateProductSetRequest request = UpdateProductSetRequest.newBuilder()
   *     .setProductSet(productSet)
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
   * Permanently deletes a ProductSet. All Products and ReferenceImages in the ProductSet will be
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
   *   String formattedName = ProductSearchClient.formatProductSetName("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   productSearchClient.deleteProductSet(formattedName);
   * }
   * </code></pre>
   *
   * @param name Resource name of the ProductSet to delete.
   *     <p>Format is: `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProductSet(String name) {
    PRODUCT_SET_PATH_TEMPLATE.validate(name, "deleteProductSet");
    DeleteProductSetRequest request = DeleteProductSetRequest.newBuilder().setName(name).build();
    deleteProductSet(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Permanently deletes a ProductSet. All Products and ReferenceImages in the ProductSet will be
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
   *   String formattedName = ProductSearchClient.formatProductSetName("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   DeleteProductSetRequest request = DeleteProductSetRequest.newBuilder()
   *     .setName(formattedName)
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
   * Permanently deletes a ProductSet. All Products and ReferenceImages in the ProductSet will be
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
   *   String formattedName = ProductSearchClient.formatProductSetName("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   DeleteProductSetRequest request = DeleteProductSetRequest.newBuilder()
   *     .setName(formattedName)
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
   *   String formattedName = ProductSearchClient.formatProductSetName("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   String product = "";
   *   productSearchClient.addProductToProductSet(formattedName, product);
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
    PRODUCT_SET_PATH_TEMPLATE.validate(name, "addProductToProductSet");
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
   *   String formattedName = ProductSearchClient.formatProductSetName("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   String product = "";
   *   AddProductToProductSetRequest request = AddProductToProductSetRequest.newBuilder()
   *     .setName(formattedName)
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
   *   String formattedName = ProductSearchClient.formatProductSetName("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   String product = "";
   *   AddProductToProductSetRequest request = AddProductToProductSetRequest.newBuilder()
   *     .setName(formattedName)
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
   *   String formattedName = ProductSearchClient.formatProductSetName("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   String product = "";
   *   productSearchClient.removeProductFromProductSet(formattedName, product);
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
    PRODUCT_SET_PATH_TEMPLATE.validate(name, "removeProductFromProductSet");
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
   *   String formattedName = ProductSearchClient.formatProductSetName("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   String product = "";
   *   RemoveProductFromProductSetRequest request = RemoveProductFromProductSetRequest.newBuilder()
   *     .setName(formattedName)
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
   *   String formattedName = ProductSearchClient.formatProductSetName("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   String product = "";
   *   RemoveProductFromProductSetRequest request = RemoveProductFromProductSetRequest.newBuilder()
   *     .setName(formattedName)
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
   *   String formattedName = ProductSearchClient.formatProductSetName("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   for (Product element : productSearchClient.listProductsInProductSet(formattedName).iterateAll()) {
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
    PRODUCT_SET_PATH_TEMPLATE.validate(name, "listProductsInProductSet");
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
   *   String formattedName = ProductSearchClient.formatProductSetName("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   ListProductsInProductSetRequest request = ListProductsInProductSetRequest.newBuilder()
   *     .setName(formattedName)
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
   *   String formattedName = ProductSearchClient.formatProductSetName("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   ListProductsInProductSetRequest request = ListProductsInProductSetRequest.newBuilder()
   *     .setName(formattedName)
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
   *   String formattedName = ProductSearchClient.formatProductSetName("[PROJECT]", "[LOCATION]", "[PRODUCT_SET]");
   *   ListProductsInProductSetRequest request = ListProductsInProductSetRequest.newBuilder()
   *     .setName(formattedName)
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
   * [ImportProductSetsGcsSource.csv_file_uri][google.cloud.vision.v1.ImportProductSetsGcsSource.csv_file_uri].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   String formattedParent = ProductSearchClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ImportProductSetsInputConfig inputConfig = ImportProductSetsInputConfig.newBuilder().build();
   *   ImportProductSetsResponse response = productSearchClient.importProductSetsAsync(formattedParent, inputConfig).get();
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
    LOCATION_PATH_TEMPLATE.validate(parent, "importProductSets");
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
   * [ImportProductSetsGcsSource.csv_file_uri][google.cloud.vision.v1.ImportProductSetsGcsSource.csv_file_uri].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   String formattedParent = ProductSearchClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ImportProductSetsInputConfig inputConfig = ImportProductSetsInputConfig.newBuilder().build();
   *   ImportProductSetsRequest request = ImportProductSetsRequest.newBuilder()
   *     .setParent(formattedParent)
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
   * [ImportProductSetsGcsSource.csv_file_uri][google.cloud.vision.v1.ImportProductSetsGcsSource.csv_file_uri].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   String formattedParent = ProductSearchClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ImportProductSetsInputConfig inputConfig = ImportProductSetsInputConfig.newBuilder().build();
   *   ImportProductSetsRequest request = ImportProductSetsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setInputConfig(inputConfig)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = productSearchClient.importProductSetsOperationCallable().futureCall(request);
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
   * [ImportProductSetsGcsSource.csv_file_uri][google.cloud.vision.v1.ImportProductSetsGcsSource.csv_file_uri].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
   *   String formattedParent = ProductSearchClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   ImportProductSetsInputConfig inputConfig = ImportProductSetsInputConfig.newBuilder().build();
   *   ImportProductSetsRequest request = ImportProductSetsRequest.newBuilder()
   *     .setParent(formattedParent)
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
          });
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
          });
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
          });
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
          });
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
