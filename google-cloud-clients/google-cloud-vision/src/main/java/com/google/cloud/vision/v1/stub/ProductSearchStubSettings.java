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
package com.google.cloud.vision.v1.stub;

import static com.google.cloud.vision.v1.ProductSearchClient.ListProductSetsPagedResponse;
import static com.google.cloud.vision.v1.ProductSearchClient.ListProductsInProductSetPagedResponse;
import static com.google.cloud.vision.v1.ProductSearchClient.ListProductsPagedResponse;
import static com.google.cloud.vision.v1.ProductSearchClient.ListReferenceImagesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.vision.v1.AddProductToProductSetRequest;
import com.google.cloud.vision.v1.BatchOperationMetadata;
import com.google.cloud.vision.v1.CreateProductRequest;
import com.google.cloud.vision.v1.CreateProductSetRequest;
import com.google.cloud.vision.v1.CreateReferenceImageRequest;
import com.google.cloud.vision.v1.DeleteProductRequest;
import com.google.cloud.vision.v1.DeleteProductSetRequest;
import com.google.cloud.vision.v1.DeleteReferenceImageRequest;
import com.google.cloud.vision.v1.GetProductRequest;
import com.google.cloud.vision.v1.GetProductSetRequest;
import com.google.cloud.vision.v1.GetReferenceImageRequest;
import com.google.cloud.vision.v1.ImportProductSetsRequest;
import com.google.cloud.vision.v1.ImportProductSetsResponse;
import com.google.cloud.vision.v1.ListProductSetsRequest;
import com.google.cloud.vision.v1.ListProductSetsResponse;
import com.google.cloud.vision.v1.ListProductsInProductSetRequest;
import com.google.cloud.vision.v1.ListProductsInProductSetResponse;
import com.google.cloud.vision.v1.ListProductsRequest;
import com.google.cloud.vision.v1.ListProductsResponse;
import com.google.cloud.vision.v1.ListReferenceImagesRequest;
import com.google.cloud.vision.v1.ListReferenceImagesResponse;
import com.google.cloud.vision.v1.Product;
import com.google.cloud.vision.v1.ProductSet;
import com.google.cloud.vision.v1.ReferenceImage;
import com.google.cloud.vision.v1.RemoveProductFromProductSetRequest;
import com.google.cloud.vision.v1.UpdateProductRequest;
import com.google.cloud.vision.v1.UpdateProductSetRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link ProductSearchStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (vision.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of createProduct to 30 seconds:
 *
 * <pre>
 * <code>
 * ProductSearchStubSettings.Builder productSearchSettingsBuilder =
 *     ProductSearchStubSettings.newBuilder();
 * productSearchSettingsBuilder.createProductSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * ProductSearchStubSettings productSearchSettings = productSearchSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
public class ProductSearchStubSettings extends StubSettings<ProductSearchStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-vision")
          .build();

  private final UnaryCallSettings<CreateProductRequest, Product> createProductSettings;
  private final PagedCallSettings<
          ListProductsRequest, ListProductsResponse, ListProductsPagedResponse>
      listProductsSettings;
  private final UnaryCallSettings<GetProductRequest, Product> getProductSettings;
  private final UnaryCallSettings<UpdateProductRequest, Product> updateProductSettings;
  private final UnaryCallSettings<DeleteProductRequest, Empty> deleteProductSettings;
  private final PagedCallSettings<
          ListReferenceImagesRequest, ListReferenceImagesResponse, ListReferenceImagesPagedResponse>
      listReferenceImagesSettings;
  private final UnaryCallSettings<GetReferenceImageRequest, ReferenceImage>
      getReferenceImageSettings;
  private final UnaryCallSettings<DeleteReferenceImageRequest, Empty> deleteReferenceImageSettings;
  private final UnaryCallSettings<CreateReferenceImageRequest, ReferenceImage>
      createReferenceImageSettings;
  private final UnaryCallSettings<CreateProductSetRequest, ProductSet> createProductSetSettings;
  private final PagedCallSettings<
          ListProductSetsRequest, ListProductSetsResponse, ListProductSetsPagedResponse>
      listProductSetsSettings;
  private final UnaryCallSettings<GetProductSetRequest, ProductSet> getProductSetSettings;
  private final UnaryCallSettings<UpdateProductSetRequest, ProductSet> updateProductSetSettings;
  private final UnaryCallSettings<DeleteProductSetRequest, Empty> deleteProductSetSettings;
  private final UnaryCallSettings<AddProductToProductSetRequest, Empty>
      addProductToProductSetSettings;
  private final UnaryCallSettings<RemoveProductFromProductSetRequest, Empty>
      removeProductFromProductSetSettings;
  private final PagedCallSettings<
          ListProductsInProductSetRequest,
          ListProductsInProductSetResponse,
          ListProductsInProductSetPagedResponse>
      listProductsInProductSetSettings;
  private final UnaryCallSettings<ImportProductSetsRequest, Operation> importProductSetsSettings;
  private final OperationCallSettings<
          ImportProductSetsRequest, ImportProductSetsResponse, BatchOperationMetadata>
      importProductSetsOperationSettings;

  /** Returns the object with the settings used for calls to createProduct. */
  public UnaryCallSettings<CreateProductRequest, Product> createProductSettings() {
    return createProductSettings;
  }

  /** Returns the object with the settings used for calls to listProducts. */
  public PagedCallSettings<ListProductsRequest, ListProductsResponse, ListProductsPagedResponse>
      listProductsSettings() {
    return listProductsSettings;
  }

  /** Returns the object with the settings used for calls to getProduct. */
  public UnaryCallSettings<GetProductRequest, Product> getProductSettings() {
    return getProductSettings;
  }

  /** Returns the object with the settings used for calls to updateProduct. */
  public UnaryCallSettings<UpdateProductRequest, Product> updateProductSettings() {
    return updateProductSettings;
  }

  /** Returns the object with the settings used for calls to deleteProduct. */
  public UnaryCallSettings<DeleteProductRequest, Empty> deleteProductSettings() {
    return deleteProductSettings;
  }

  /** Returns the object with the settings used for calls to listReferenceImages. */
  public PagedCallSettings<
          ListReferenceImagesRequest, ListReferenceImagesResponse, ListReferenceImagesPagedResponse>
      listReferenceImagesSettings() {
    return listReferenceImagesSettings;
  }

  /** Returns the object with the settings used for calls to getReferenceImage. */
  public UnaryCallSettings<GetReferenceImageRequest, ReferenceImage> getReferenceImageSettings() {
    return getReferenceImageSettings;
  }

  /** Returns the object with the settings used for calls to deleteReferenceImage. */
  public UnaryCallSettings<DeleteReferenceImageRequest, Empty> deleteReferenceImageSettings() {
    return deleteReferenceImageSettings;
  }

  /** Returns the object with the settings used for calls to createReferenceImage. */
  public UnaryCallSettings<CreateReferenceImageRequest, ReferenceImage>
      createReferenceImageSettings() {
    return createReferenceImageSettings;
  }

  /** Returns the object with the settings used for calls to createProductSet. */
  public UnaryCallSettings<CreateProductSetRequest, ProductSet> createProductSetSettings() {
    return createProductSetSettings;
  }

  /** Returns the object with the settings used for calls to listProductSets. */
  public PagedCallSettings<
          ListProductSetsRequest, ListProductSetsResponse, ListProductSetsPagedResponse>
      listProductSetsSettings() {
    return listProductSetsSettings;
  }

  /** Returns the object with the settings used for calls to getProductSet. */
  public UnaryCallSettings<GetProductSetRequest, ProductSet> getProductSetSettings() {
    return getProductSetSettings;
  }

  /** Returns the object with the settings used for calls to updateProductSet. */
  public UnaryCallSettings<UpdateProductSetRequest, ProductSet> updateProductSetSettings() {
    return updateProductSetSettings;
  }

  /** Returns the object with the settings used for calls to deleteProductSet. */
  public UnaryCallSettings<DeleteProductSetRequest, Empty> deleteProductSetSettings() {
    return deleteProductSetSettings;
  }

  /** Returns the object with the settings used for calls to addProductToProductSet. */
  public UnaryCallSettings<AddProductToProductSetRequest, Empty> addProductToProductSetSettings() {
    return addProductToProductSetSettings;
  }

  /** Returns the object with the settings used for calls to removeProductFromProductSet. */
  public UnaryCallSettings<RemoveProductFromProductSetRequest, Empty>
      removeProductFromProductSetSettings() {
    return removeProductFromProductSetSettings;
  }

  /** Returns the object with the settings used for calls to listProductsInProductSet. */
  public PagedCallSettings<
          ListProductsInProductSetRequest,
          ListProductsInProductSetResponse,
          ListProductsInProductSetPagedResponse>
      listProductsInProductSetSettings() {
    return listProductsInProductSetSettings;
  }

  /** Returns the object with the settings used for calls to importProductSets. */
  public UnaryCallSettings<ImportProductSetsRequest, Operation> importProductSetsSettings() {
    return importProductSetsSettings;
  }

  /** Returns the object with the settings used for calls to importProductSets. */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallSettings<
          ImportProductSetsRequest, ImportProductSetsResponse, BatchOperationMetadata>
      importProductSetsOperationSettings() {
    return importProductSetsOperationSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ProductSearchStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcProductSearchStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "vision.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ProductSearchStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected ProductSearchStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createProductSettings = settingsBuilder.createProductSettings().build();
    listProductsSettings = settingsBuilder.listProductsSettings().build();
    getProductSettings = settingsBuilder.getProductSettings().build();
    updateProductSettings = settingsBuilder.updateProductSettings().build();
    deleteProductSettings = settingsBuilder.deleteProductSettings().build();
    listReferenceImagesSettings = settingsBuilder.listReferenceImagesSettings().build();
    getReferenceImageSettings = settingsBuilder.getReferenceImageSettings().build();
    deleteReferenceImageSettings = settingsBuilder.deleteReferenceImageSettings().build();
    createReferenceImageSettings = settingsBuilder.createReferenceImageSettings().build();
    createProductSetSettings = settingsBuilder.createProductSetSettings().build();
    listProductSetsSettings = settingsBuilder.listProductSetsSettings().build();
    getProductSetSettings = settingsBuilder.getProductSetSettings().build();
    updateProductSetSettings = settingsBuilder.updateProductSetSettings().build();
    deleteProductSetSettings = settingsBuilder.deleteProductSetSettings().build();
    addProductToProductSetSettings = settingsBuilder.addProductToProductSetSettings().build();
    removeProductFromProductSetSettings =
        settingsBuilder.removeProductFromProductSetSettings().build();
    listProductsInProductSetSettings = settingsBuilder.listProductsInProductSetSettings().build();
    importProductSetsSettings = settingsBuilder.importProductSetsSettings().build();
    importProductSetsOperationSettings =
        settingsBuilder.importProductSetsOperationSettings().build();
  }

  private static final PagedListDescriptor<ListProductsRequest, ListProductsResponse, Product>
      LIST_PRODUCTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListProductsRequest, ListProductsResponse, Product>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListProductsRequest injectToken(ListProductsRequest payload, String token) {
              return ListProductsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListProductsRequest injectPageSize(ListProductsRequest payload, int pageSize) {
              return ListProductsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListProductsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListProductsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Product> extractResources(ListProductsResponse payload) {
              return payload.getProductsList() != null
                  ? payload.getProductsList()
                  : ImmutableList.<Product>of();
            }
          };

  private static final PagedListDescriptor<
          ListReferenceImagesRequest, ListReferenceImagesResponse, ReferenceImage>
      LIST_REFERENCE_IMAGES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListReferenceImagesRequest, ListReferenceImagesResponse, ReferenceImage>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListReferenceImagesRequest injectToken(
                ListReferenceImagesRequest payload, String token) {
              return ListReferenceImagesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListReferenceImagesRequest injectPageSize(
                ListReferenceImagesRequest payload, int pageSize) {
              return ListReferenceImagesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListReferenceImagesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListReferenceImagesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ReferenceImage> extractResources(ListReferenceImagesResponse payload) {
              return payload.getReferenceImagesList() != null
                  ? payload.getReferenceImagesList()
                  : ImmutableList.<ReferenceImage>of();
            }
          };

  private static final PagedListDescriptor<
          ListProductSetsRequest, ListProductSetsResponse, ProductSet>
      LIST_PRODUCT_SETS_PAGE_STR_DESC =
          new PagedListDescriptor<ListProductSetsRequest, ListProductSetsResponse, ProductSet>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListProductSetsRequest injectToken(
                ListProductSetsRequest payload, String token) {
              return ListProductSetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListProductSetsRequest injectPageSize(
                ListProductSetsRequest payload, int pageSize) {
              return ListProductSetsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListProductSetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListProductSetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ProductSet> extractResources(ListProductSetsResponse payload) {
              return payload.getProductSetsList() != null
                  ? payload.getProductSetsList()
                  : ImmutableList.<ProductSet>of();
            }
          };

  private static final PagedListDescriptor<
          ListProductsInProductSetRequest, ListProductsInProductSetResponse, Product>
      LIST_PRODUCTS_IN_PRODUCT_SET_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListProductsInProductSetRequest, ListProductsInProductSetResponse, Product>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListProductsInProductSetRequest injectToken(
                ListProductsInProductSetRequest payload, String token) {
              return ListProductsInProductSetRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListProductsInProductSetRequest injectPageSize(
                ListProductsInProductSetRequest payload, int pageSize) {
              return ListProductsInProductSetRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListProductsInProductSetRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListProductsInProductSetResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Product> extractResources(ListProductsInProductSetResponse payload) {
              return payload.getProductsList() != null
                  ? payload.getProductsList()
                  : ImmutableList.<Product>of();
            }
          };

  private static final PagedListResponseFactory<
          ListProductsRequest, ListProductsResponse, ListProductsPagedResponse>
      LIST_PRODUCTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListProductsRequest, ListProductsResponse, ListProductsPagedResponse>() {
            @Override
            public ApiFuture<ListProductsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListProductsRequest, ListProductsResponse> callable,
                ListProductsRequest request,
                ApiCallContext context,
                ApiFuture<ListProductsResponse> futureResponse) {
              PageContext<ListProductsRequest, ListProductsResponse, Product> pageContext =
                  PageContext.create(callable, LIST_PRODUCTS_PAGE_STR_DESC, request, context);
              return ListProductsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListReferenceImagesRequest, ListReferenceImagesResponse, ListReferenceImagesPagedResponse>
      LIST_REFERENCE_IMAGES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListReferenceImagesRequest,
              ListReferenceImagesResponse,
              ListReferenceImagesPagedResponse>() {
            @Override
            public ApiFuture<ListReferenceImagesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListReferenceImagesRequest, ListReferenceImagesResponse> callable,
                ListReferenceImagesRequest request,
                ApiCallContext context,
                ApiFuture<ListReferenceImagesResponse> futureResponse) {
              PageContext<ListReferenceImagesRequest, ListReferenceImagesResponse, ReferenceImage>
                  pageContext =
                      PageContext.create(
                          callable, LIST_REFERENCE_IMAGES_PAGE_STR_DESC, request, context);
              return ListReferenceImagesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListProductSetsRequest, ListProductSetsResponse, ListProductSetsPagedResponse>
      LIST_PRODUCT_SETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListProductSetsRequest, ListProductSetsResponse, ListProductSetsPagedResponse>() {
            @Override
            public ApiFuture<ListProductSetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListProductSetsRequest, ListProductSetsResponse> callable,
                ListProductSetsRequest request,
                ApiCallContext context,
                ApiFuture<ListProductSetsResponse> futureResponse) {
              PageContext<ListProductSetsRequest, ListProductSetsResponse, ProductSet> pageContext =
                  PageContext.create(callable, LIST_PRODUCT_SETS_PAGE_STR_DESC, request, context);
              return ListProductSetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListProductsInProductSetRequest,
          ListProductsInProductSetResponse,
          ListProductsInProductSetPagedResponse>
      LIST_PRODUCTS_IN_PRODUCT_SET_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListProductsInProductSetRequest,
              ListProductsInProductSetResponse,
              ListProductsInProductSetPagedResponse>() {
            @Override
            public ApiFuture<ListProductsInProductSetPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListProductsInProductSetRequest, ListProductsInProductSetResponse>
                    callable,
                ListProductsInProductSetRequest request,
                ApiCallContext context,
                ApiFuture<ListProductsInProductSetResponse> futureResponse) {
              PageContext<
                      ListProductsInProductSetRequest, ListProductsInProductSetResponse, Product>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PRODUCTS_IN_PRODUCT_SET_PAGE_STR_DESC, request, context);
              return ListProductsInProductSetPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for ProductSearchStubSettings. */
  public static class Builder extends StubSettings.Builder<ProductSearchStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<CreateProductRequest, Product> createProductSettings;
    private final PagedCallSettings.Builder<
            ListProductsRequest, ListProductsResponse, ListProductsPagedResponse>
        listProductsSettings;
    private final UnaryCallSettings.Builder<GetProductRequest, Product> getProductSettings;
    private final UnaryCallSettings.Builder<UpdateProductRequest, Product> updateProductSettings;
    private final UnaryCallSettings.Builder<DeleteProductRequest, Empty> deleteProductSettings;
    private final PagedCallSettings.Builder<
            ListReferenceImagesRequest,
            ListReferenceImagesResponse,
            ListReferenceImagesPagedResponse>
        listReferenceImagesSettings;
    private final UnaryCallSettings.Builder<GetReferenceImageRequest, ReferenceImage>
        getReferenceImageSettings;
    private final UnaryCallSettings.Builder<DeleteReferenceImageRequest, Empty>
        deleteReferenceImageSettings;
    private final UnaryCallSettings.Builder<CreateReferenceImageRequest, ReferenceImage>
        createReferenceImageSettings;
    private final UnaryCallSettings.Builder<CreateProductSetRequest, ProductSet>
        createProductSetSettings;
    private final PagedCallSettings.Builder<
            ListProductSetsRequest, ListProductSetsResponse, ListProductSetsPagedResponse>
        listProductSetsSettings;
    private final UnaryCallSettings.Builder<GetProductSetRequest, ProductSet> getProductSetSettings;
    private final UnaryCallSettings.Builder<UpdateProductSetRequest, ProductSet>
        updateProductSetSettings;
    private final UnaryCallSettings.Builder<DeleteProductSetRequest, Empty>
        deleteProductSetSettings;
    private final UnaryCallSettings.Builder<AddProductToProductSetRequest, Empty>
        addProductToProductSetSettings;
    private final UnaryCallSettings.Builder<RemoveProductFromProductSetRequest, Empty>
        removeProductFromProductSetSettings;
    private final PagedCallSettings.Builder<
            ListProductsInProductSetRequest,
            ListProductsInProductSetResponse,
            ListProductsInProductSetPagedResponse>
        listProductsInProductSetSettings;
    private final UnaryCallSettings.Builder<ImportProductSetsRequest, Operation>
        importProductSetsSettings;
    private final OperationCallSettings.Builder<
            ImportProductSetsRequest, ImportProductSetsResponse, BatchOperationMetadata>
        importProductSetsOperationSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createProductSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listProductsSettings = PagedCallSettings.newBuilder(LIST_PRODUCTS_PAGE_STR_FACT);

      getProductSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateProductSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteProductSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listReferenceImagesSettings =
          PagedCallSettings.newBuilder(LIST_REFERENCE_IMAGES_PAGE_STR_FACT);

      getReferenceImageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteReferenceImageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createReferenceImageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createProductSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listProductSetsSettings = PagedCallSettings.newBuilder(LIST_PRODUCT_SETS_PAGE_STR_FACT);

      getProductSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateProductSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteProductSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      addProductToProductSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      removeProductFromProductSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listProductsInProductSetSettings =
          PagedCallSettings.newBuilder(LIST_PRODUCTS_IN_PRODUCT_SET_PAGE_STR_FACT);

      importProductSetsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      importProductSetsOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createProductSettings,
              listProductsSettings,
              getProductSettings,
              updateProductSettings,
              deleteProductSettings,
              listReferenceImagesSettings,
              getReferenceImageSettings,
              deleteReferenceImageSettings,
              createReferenceImageSettings,
              createProductSetSettings,
              listProductSetsSettings,
              getProductSetSettings,
              updateProductSetSettings,
              deleteProductSetSettings,
              addProductToProductSetSettings,
              removeProductFromProductSetSettings,
              listProductsInProductSetSettings,
              importProductSetsSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .createProductSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listProductsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getProductSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateProductSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteProductSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listReferenceImagesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getReferenceImageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteReferenceImageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createReferenceImageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createProductSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listProductSetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getProductSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateProductSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteProductSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .addProductToProductSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .removeProductFromProductSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listProductsInProductSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .importProductSetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));
      builder
          .importProductSetsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ImportProductSetsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ImportProductSetsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(BatchOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(20000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO) // ignored
                      .setRpcTimeoutMultiplier(1.0) // ignored
                      .setMaxRpcTimeout(Duration.ZERO) // ignored
                      .setTotalTimeout(Duration.ofMillis(86400000L))
                      .build()));

      return builder;
    }

    protected Builder(ProductSearchStubSettings settings) {
      super(settings);

      createProductSettings = settings.createProductSettings.toBuilder();
      listProductsSettings = settings.listProductsSettings.toBuilder();
      getProductSettings = settings.getProductSettings.toBuilder();
      updateProductSettings = settings.updateProductSettings.toBuilder();
      deleteProductSettings = settings.deleteProductSettings.toBuilder();
      listReferenceImagesSettings = settings.listReferenceImagesSettings.toBuilder();
      getReferenceImageSettings = settings.getReferenceImageSettings.toBuilder();
      deleteReferenceImageSettings = settings.deleteReferenceImageSettings.toBuilder();
      createReferenceImageSettings = settings.createReferenceImageSettings.toBuilder();
      createProductSetSettings = settings.createProductSetSettings.toBuilder();
      listProductSetsSettings = settings.listProductSetsSettings.toBuilder();
      getProductSetSettings = settings.getProductSetSettings.toBuilder();
      updateProductSetSettings = settings.updateProductSetSettings.toBuilder();
      deleteProductSetSettings = settings.deleteProductSetSettings.toBuilder();
      addProductToProductSetSettings = settings.addProductToProductSetSettings.toBuilder();
      removeProductFromProductSetSettings =
          settings.removeProductFromProductSetSettings.toBuilder();
      listProductsInProductSetSettings = settings.listProductsInProductSetSettings.toBuilder();
      importProductSetsSettings = settings.importProductSetsSettings.toBuilder();
      importProductSetsOperationSettings = settings.importProductSetsOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createProductSettings,
              listProductsSettings,
              getProductSettings,
              updateProductSettings,
              deleteProductSettings,
              listReferenceImagesSettings,
              getReferenceImageSettings,
              deleteReferenceImageSettings,
              createReferenceImageSettings,
              createProductSetSettings,
              listProductSetsSettings,
              getProductSetSettings,
              updateProductSetSettings,
              deleteProductSetSettings,
              addProductToProductSetSettings,
              removeProductFromProductSetSettings,
              listProductsInProductSetSettings,
              importProductSetsSettings);
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to createProduct. */
    public UnaryCallSettings.Builder<CreateProductRequest, Product> createProductSettings() {
      return createProductSettings;
    }

    /** Returns the builder for the settings used for calls to listProducts. */
    public PagedCallSettings.Builder<
            ListProductsRequest, ListProductsResponse, ListProductsPagedResponse>
        listProductsSettings() {
      return listProductsSettings;
    }

    /** Returns the builder for the settings used for calls to getProduct. */
    public UnaryCallSettings.Builder<GetProductRequest, Product> getProductSettings() {
      return getProductSettings;
    }

    /** Returns the builder for the settings used for calls to updateProduct. */
    public UnaryCallSettings.Builder<UpdateProductRequest, Product> updateProductSettings() {
      return updateProductSettings;
    }

    /** Returns the builder for the settings used for calls to deleteProduct. */
    public UnaryCallSettings.Builder<DeleteProductRequest, Empty> deleteProductSettings() {
      return deleteProductSettings;
    }

    /** Returns the builder for the settings used for calls to listReferenceImages. */
    public PagedCallSettings.Builder<
            ListReferenceImagesRequest,
            ListReferenceImagesResponse,
            ListReferenceImagesPagedResponse>
        listReferenceImagesSettings() {
      return listReferenceImagesSettings;
    }

    /** Returns the builder for the settings used for calls to getReferenceImage. */
    public UnaryCallSettings.Builder<GetReferenceImageRequest, ReferenceImage>
        getReferenceImageSettings() {
      return getReferenceImageSettings;
    }

    /** Returns the builder for the settings used for calls to deleteReferenceImage. */
    public UnaryCallSettings.Builder<DeleteReferenceImageRequest, Empty>
        deleteReferenceImageSettings() {
      return deleteReferenceImageSettings;
    }

    /** Returns the builder for the settings used for calls to createReferenceImage. */
    public UnaryCallSettings.Builder<CreateReferenceImageRequest, ReferenceImage>
        createReferenceImageSettings() {
      return createReferenceImageSettings;
    }

    /** Returns the builder for the settings used for calls to createProductSet. */
    public UnaryCallSettings.Builder<CreateProductSetRequest, ProductSet>
        createProductSetSettings() {
      return createProductSetSettings;
    }

    /** Returns the builder for the settings used for calls to listProductSets. */
    public PagedCallSettings.Builder<
            ListProductSetsRequest, ListProductSetsResponse, ListProductSetsPagedResponse>
        listProductSetsSettings() {
      return listProductSetsSettings;
    }

    /** Returns the builder for the settings used for calls to getProductSet. */
    public UnaryCallSettings.Builder<GetProductSetRequest, ProductSet> getProductSetSettings() {
      return getProductSetSettings;
    }

    /** Returns the builder for the settings used for calls to updateProductSet. */
    public UnaryCallSettings.Builder<UpdateProductSetRequest, ProductSet>
        updateProductSetSettings() {
      return updateProductSetSettings;
    }

    /** Returns the builder for the settings used for calls to deleteProductSet. */
    public UnaryCallSettings.Builder<DeleteProductSetRequest, Empty> deleteProductSetSettings() {
      return deleteProductSetSettings;
    }

    /** Returns the builder for the settings used for calls to addProductToProductSet. */
    public UnaryCallSettings.Builder<AddProductToProductSetRequest, Empty>
        addProductToProductSetSettings() {
      return addProductToProductSetSettings;
    }

    /** Returns the builder for the settings used for calls to removeProductFromProductSet. */
    public UnaryCallSettings.Builder<RemoveProductFromProductSetRequest, Empty>
        removeProductFromProductSetSettings() {
      return removeProductFromProductSetSettings;
    }

    /** Returns the builder for the settings used for calls to listProductsInProductSet. */
    public PagedCallSettings.Builder<
            ListProductsInProductSetRequest,
            ListProductsInProductSetResponse,
            ListProductsInProductSetPagedResponse>
        listProductsInProductSetSettings() {
      return listProductsInProductSetSettings;
    }

    /** Returns the builder for the settings used for calls to importProductSets. */
    public UnaryCallSettings.Builder<ImportProductSetsRequest, Operation>
        importProductSetsSettings() {
      return importProductSetsSettings;
    }

    /** Returns the builder for the settings used for calls to importProductSets. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ImportProductSetsRequest, ImportProductSetsResponse, BatchOperationMetadata>
        importProductSetsOperationSettings() {
      return importProductSetsOperationSettings;
    }

    @Override
    public ProductSearchStubSettings build() throws IOException {
      return new ProductSearchStubSettings(this);
    }
  }
}
