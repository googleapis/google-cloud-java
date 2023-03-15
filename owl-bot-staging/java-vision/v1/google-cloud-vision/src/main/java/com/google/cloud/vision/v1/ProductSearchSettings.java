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

package com.google.cloud.vision.v1;

import static com.google.cloud.vision.v1.ProductSearchClient.ListProductSetsPagedResponse;
import static com.google.cloud.vision.v1.ProductSearchClient.ListProductsInProductSetPagedResponse;
import static com.google.cloud.vision.v1.ProductSearchClient.ListProductsPagedResponse;
import static com.google.cloud.vision.v1.ProductSearchClient.ListReferenceImagesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.vision.v1.stub.ProductSearchStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ProductSearchClient}.
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
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createProductSet to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ProductSearchSettings.Builder productSearchSettingsBuilder = ProductSearchSettings.newBuilder();
 * productSearchSettingsBuilder
 *     .createProductSetSettings()
 *     .setRetrySettings(
 *         productSearchSettingsBuilder
 *             .createProductSetSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ProductSearchSettings productSearchSettings = productSearchSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ProductSearchSettings extends ClientSettings<ProductSearchSettings> {

  /** Returns the object with the settings used for calls to createProductSet. */
  public UnaryCallSettings<CreateProductSetRequest, ProductSet> createProductSetSettings() {
    return ((ProductSearchStubSettings) getStubSettings()).createProductSetSettings();
  }

  /** Returns the object with the settings used for calls to listProductSets. */
  public PagedCallSettings<
          ListProductSetsRequest, ListProductSetsResponse, ListProductSetsPagedResponse>
      listProductSetsSettings() {
    return ((ProductSearchStubSettings) getStubSettings()).listProductSetsSettings();
  }

  /** Returns the object with the settings used for calls to getProductSet. */
  public UnaryCallSettings<GetProductSetRequest, ProductSet> getProductSetSettings() {
    return ((ProductSearchStubSettings) getStubSettings()).getProductSetSettings();
  }

  /** Returns the object with the settings used for calls to updateProductSet. */
  public UnaryCallSettings<UpdateProductSetRequest, ProductSet> updateProductSetSettings() {
    return ((ProductSearchStubSettings) getStubSettings()).updateProductSetSettings();
  }

  /** Returns the object with the settings used for calls to deleteProductSet. */
  public UnaryCallSettings<DeleteProductSetRequest, Empty> deleteProductSetSettings() {
    return ((ProductSearchStubSettings) getStubSettings()).deleteProductSetSettings();
  }

  /** Returns the object with the settings used for calls to createProduct. */
  public UnaryCallSettings<CreateProductRequest, Product> createProductSettings() {
    return ((ProductSearchStubSettings) getStubSettings()).createProductSettings();
  }

  /** Returns the object with the settings used for calls to listProducts. */
  public PagedCallSettings<ListProductsRequest, ListProductsResponse, ListProductsPagedResponse>
      listProductsSettings() {
    return ((ProductSearchStubSettings) getStubSettings()).listProductsSettings();
  }

  /** Returns the object with the settings used for calls to getProduct. */
  public UnaryCallSettings<GetProductRequest, Product> getProductSettings() {
    return ((ProductSearchStubSettings) getStubSettings()).getProductSettings();
  }

  /** Returns the object with the settings used for calls to updateProduct. */
  public UnaryCallSettings<UpdateProductRequest, Product> updateProductSettings() {
    return ((ProductSearchStubSettings) getStubSettings()).updateProductSettings();
  }

  /** Returns the object with the settings used for calls to deleteProduct. */
  public UnaryCallSettings<DeleteProductRequest, Empty> deleteProductSettings() {
    return ((ProductSearchStubSettings) getStubSettings()).deleteProductSettings();
  }

  /** Returns the object with the settings used for calls to createReferenceImage. */
  public UnaryCallSettings<CreateReferenceImageRequest, ReferenceImage>
      createReferenceImageSettings() {
    return ((ProductSearchStubSettings) getStubSettings()).createReferenceImageSettings();
  }

  /** Returns the object with the settings used for calls to deleteReferenceImage. */
  public UnaryCallSettings<DeleteReferenceImageRequest, Empty> deleteReferenceImageSettings() {
    return ((ProductSearchStubSettings) getStubSettings()).deleteReferenceImageSettings();
  }

  /** Returns the object with the settings used for calls to listReferenceImages. */
  public PagedCallSettings<
          ListReferenceImagesRequest, ListReferenceImagesResponse, ListReferenceImagesPagedResponse>
      listReferenceImagesSettings() {
    return ((ProductSearchStubSettings) getStubSettings()).listReferenceImagesSettings();
  }

  /** Returns the object with the settings used for calls to getReferenceImage. */
  public UnaryCallSettings<GetReferenceImageRequest, ReferenceImage> getReferenceImageSettings() {
    return ((ProductSearchStubSettings) getStubSettings()).getReferenceImageSettings();
  }

  /** Returns the object with the settings used for calls to addProductToProductSet. */
  public UnaryCallSettings<AddProductToProductSetRequest, Empty> addProductToProductSetSettings() {
    return ((ProductSearchStubSettings) getStubSettings()).addProductToProductSetSettings();
  }

  /** Returns the object with the settings used for calls to removeProductFromProductSet. */
  public UnaryCallSettings<RemoveProductFromProductSetRequest, Empty>
      removeProductFromProductSetSettings() {
    return ((ProductSearchStubSettings) getStubSettings()).removeProductFromProductSetSettings();
  }

  /** Returns the object with the settings used for calls to listProductsInProductSet. */
  public PagedCallSettings<
          ListProductsInProductSetRequest,
          ListProductsInProductSetResponse,
          ListProductsInProductSetPagedResponse>
      listProductsInProductSetSettings() {
    return ((ProductSearchStubSettings) getStubSettings()).listProductsInProductSetSettings();
  }

  /** Returns the object with the settings used for calls to importProductSets. */
  public UnaryCallSettings<ImportProductSetsRequest, Operation> importProductSetsSettings() {
    return ((ProductSearchStubSettings) getStubSettings()).importProductSetsSettings();
  }

  /** Returns the object with the settings used for calls to importProductSets. */
  public OperationCallSettings<
          ImportProductSetsRequest, ImportProductSetsResponse, BatchOperationMetadata>
      importProductSetsOperationSettings() {
    return ((ProductSearchStubSettings) getStubSettings()).importProductSetsOperationSettings();
  }

  /** Returns the object with the settings used for calls to purgeProducts. */
  public UnaryCallSettings<PurgeProductsRequest, Operation> purgeProductsSettings() {
    return ((ProductSearchStubSettings) getStubSettings()).purgeProductsSettings();
  }

  /** Returns the object with the settings used for calls to purgeProducts. */
  public OperationCallSettings<PurgeProductsRequest, Empty, BatchOperationMetadata>
      purgeProductsOperationSettings() {
    return ((ProductSearchStubSettings) getStubSettings()).purgeProductsOperationSettings();
  }

  public static final ProductSearchSettings create(ProductSearchStubSettings stub)
      throws IOException {
    return new ProductSearchSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ProductSearchStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ProductSearchStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ProductSearchStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ProductSearchStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ProductSearchStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ProductSearchStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ProductSearchStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ProductSearchStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected ProductSearchSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ProductSearchSettings. */
  public static class Builder extends ClientSettings.Builder<ProductSearchSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ProductSearchStubSettings.newBuilder(clientContext));
    }

    protected Builder(ProductSearchSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ProductSearchStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ProductSearchStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(ProductSearchStubSettings.newHttpJsonBuilder());
    }

    public ProductSearchStubSettings.Builder getStubSettingsBuilder() {
      return ((ProductSearchStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to createProductSet. */
    public UnaryCallSettings.Builder<CreateProductSetRequest, ProductSet>
        createProductSetSettings() {
      return getStubSettingsBuilder().createProductSetSettings();
    }

    /** Returns the builder for the settings used for calls to listProductSets. */
    public PagedCallSettings.Builder<
            ListProductSetsRequest, ListProductSetsResponse, ListProductSetsPagedResponse>
        listProductSetsSettings() {
      return getStubSettingsBuilder().listProductSetsSettings();
    }

    /** Returns the builder for the settings used for calls to getProductSet. */
    public UnaryCallSettings.Builder<GetProductSetRequest, ProductSet> getProductSetSettings() {
      return getStubSettingsBuilder().getProductSetSettings();
    }

    /** Returns the builder for the settings used for calls to updateProductSet. */
    public UnaryCallSettings.Builder<UpdateProductSetRequest, ProductSet>
        updateProductSetSettings() {
      return getStubSettingsBuilder().updateProductSetSettings();
    }

    /** Returns the builder for the settings used for calls to deleteProductSet. */
    public UnaryCallSettings.Builder<DeleteProductSetRequest, Empty> deleteProductSetSettings() {
      return getStubSettingsBuilder().deleteProductSetSettings();
    }

    /** Returns the builder for the settings used for calls to createProduct. */
    public UnaryCallSettings.Builder<CreateProductRequest, Product> createProductSettings() {
      return getStubSettingsBuilder().createProductSettings();
    }

    /** Returns the builder for the settings used for calls to listProducts. */
    public PagedCallSettings.Builder<
            ListProductsRequest, ListProductsResponse, ListProductsPagedResponse>
        listProductsSettings() {
      return getStubSettingsBuilder().listProductsSettings();
    }

    /** Returns the builder for the settings used for calls to getProduct. */
    public UnaryCallSettings.Builder<GetProductRequest, Product> getProductSettings() {
      return getStubSettingsBuilder().getProductSettings();
    }

    /** Returns the builder for the settings used for calls to updateProduct. */
    public UnaryCallSettings.Builder<UpdateProductRequest, Product> updateProductSettings() {
      return getStubSettingsBuilder().updateProductSettings();
    }

    /** Returns the builder for the settings used for calls to deleteProduct. */
    public UnaryCallSettings.Builder<DeleteProductRequest, Empty> deleteProductSettings() {
      return getStubSettingsBuilder().deleteProductSettings();
    }

    /** Returns the builder for the settings used for calls to createReferenceImage. */
    public UnaryCallSettings.Builder<CreateReferenceImageRequest, ReferenceImage>
        createReferenceImageSettings() {
      return getStubSettingsBuilder().createReferenceImageSettings();
    }

    /** Returns the builder for the settings used for calls to deleteReferenceImage. */
    public UnaryCallSettings.Builder<DeleteReferenceImageRequest, Empty>
        deleteReferenceImageSettings() {
      return getStubSettingsBuilder().deleteReferenceImageSettings();
    }

    /** Returns the builder for the settings used for calls to listReferenceImages. */
    public PagedCallSettings.Builder<
            ListReferenceImagesRequest,
            ListReferenceImagesResponse,
            ListReferenceImagesPagedResponse>
        listReferenceImagesSettings() {
      return getStubSettingsBuilder().listReferenceImagesSettings();
    }

    /** Returns the builder for the settings used for calls to getReferenceImage. */
    public UnaryCallSettings.Builder<GetReferenceImageRequest, ReferenceImage>
        getReferenceImageSettings() {
      return getStubSettingsBuilder().getReferenceImageSettings();
    }

    /** Returns the builder for the settings used for calls to addProductToProductSet. */
    public UnaryCallSettings.Builder<AddProductToProductSetRequest, Empty>
        addProductToProductSetSettings() {
      return getStubSettingsBuilder().addProductToProductSetSettings();
    }

    /** Returns the builder for the settings used for calls to removeProductFromProductSet. */
    public UnaryCallSettings.Builder<RemoveProductFromProductSetRequest, Empty>
        removeProductFromProductSetSettings() {
      return getStubSettingsBuilder().removeProductFromProductSetSettings();
    }

    /** Returns the builder for the settings used for calls to listProductsInProductSet. */
    public PagedCallSettings.Builder<
            ListProductsInProductSetRequest,
            ListProductsInProductSetResponse,
            ListProductsInProductSetPagedResponse>
        listProductsInProductSetSettings() {
      return getStubSettingsBuilder().listProductsInProductSetSettings();
    }

    /** Returns the builder for the settings used for calls to importProductSets. */
    public UnaryCallSettings.Builder<ImportProductSetsRequest, Operation>
        importProductSetsSettings() {
      return getStubSettingsBuilder().importProductSetsSettings();
    }

    /** Returns the builder for the settings used for calls to importProductSets. */
    public OperationCallSettings.Builder<
            ImportProductSetsRequest, ImportProductSetsResponse, BatchOperationMetadata>
        importProductSetsOperationSettings() {
      return getStubSettingsBuilder().importProductSetsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to purgeProducts. */
    public UnaryCallSettings.Builder<PurgeProductsRequest, Operation> purgeProductsSettings() {
      return getStubSettingsBuilder().purgeProductsSettings();
    }

    /** Returns the builder for the settings used for calls to purgeProducts. */
    public OperationCallSettings.Builder<PurgeProductsRequest, Empty, BatchOperationMetadata>
        purgeProductsOperationSettings() {
      return getStubSettingsBuilder().purgeProductsOperationSettings();
    }

    @Override
    public ProductSearchSettings build() throws IOException {
      return new ProductSearchSettings(this);
    }
  }
}
