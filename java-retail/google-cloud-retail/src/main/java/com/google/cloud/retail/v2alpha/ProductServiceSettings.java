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

package com.google.cloud.retail.v2alpha;

import static com.google.cloud.retail.v2alpha.ProductServiceClient.ListProductsPagedResponse;

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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.retail.v2alpha.stub.ProductServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ProductServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (retail.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createProduct to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ProductServiceSettings.Builder productServiceSettingsBuilder =
 *     ProductServiceSettings.newBuilder();
 * productServiceSettingsBuilder
 *     .createProductSettings()
 *     .setRetrySettings(
 *         productServiceSettingsBuilder
 *             .createProductSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ProductServiceSettings productServiceSettings = productServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ProductServiceSettings extends ClientSettings<ProductServiceSettings> {

  /** Returns the object with the settings used for calls to createProduct. */
  public UnaryCallSettings<CreateProductRequest, Product> createProductSettings() {
    return ((ProductServiceStubSettings) getStubSettings()).createProductSettings();
  }

  /** Returns the object with the settings used for calls to getProduct. */
  public UnaryCallSettings<GetProductRequest, Product> getProductSettings() {
    return ((ProductServiceStubSettings) getStubSettings()).getProductSettings();
  }

  /** Returns the object with the settings used for calls to listProducts. */
  public PagedCallSettings<ListProductsRequest, ListProductsResponse, ListProductsPagedResponse>
      listProductsSettings() {
    return ((ProductServiceStubSettings) getStubSettings()).listProductsSettings();
  }

  /** Returns the object with the settings used for calls to updateProduct. */
  public UnaryCallSettings<UpdateProductRequest, Product> updateProductSettings() {
    return ((ProductServiceStubSettings) getStubSettings()).updateProductSettings();
  }

  /** Returns the object with the settings used for calls to deleteProduct. */
  public UnaryCallSettings<DeleteProductRequest, Empty> deleteProductSettings() {
    return ((ProductServiceStubSettings) getStubSettings()).deleteProductSettings();
  }

  /** Returns the object with the settings used for calls to purgeProducts. */
  public UnaryCallSettings<PurgeProductsRequest, Operation> purgeProductsSettings() {
    return ((ProductServiceStubSettings) getStubSettings()).purgeProductsSettings();
  }

  /** Returns the object with the settings used for calls to purgeProducts. */
  public OperationCallSettings<PurgeProductsRequest, PurgeProductsResponse, PurgeProductsMetadata>
      purgeProductsOperationSettings() {
    return ((ProductServiceStubSettings) getStubSettings()).purgeProductsOperationSettings();
  }

  /** Returns the object with the settings used for calls to importProducts. */
  public UnaryCallSettings<ImportProductsRequest, Operation> importProductsSettings() {
    return ((ProductServiceStubSettings) getStubSettings()).importProductsSettings();
  }

  /** Returns the object with the settings used for calls to importProducts. */
  public OperationCallSettings<ImportProductsRequest, ImportProductsResponse, ImportMetadata>
      importProductsOperationSettings() {
    return ((ProductServiceStubSettings) getStubSettings()).importProductsOperationSettings();
  }

  /** Returns the object with the settings used for calls to setInventory. */
  public UnaryCallSettings<SetInventoryRequest, Operation> setInventorySettings() {
    return ((ProductServiceStubSettings) getStubSettings()).setInventorySettings();
  }

  /** Returns the object with the settings used for calls to setInventory. */
  public OperationCallSettings<SetInventoryRequest, SetInventoryResponse, SetInventoryMetadata>
      setInventoryOperationSettings() {
    return ((ProductServiceStubSettings) getStubSettings()).setInventoryOperationSettings();
  }

  /** Returns the object with the settings used for calls to addFulfillmentPlaces. */
  public UnaryCallSettings<AddFulfillmentPlacesRequest, Operation> addFulfillmentPlacesSettings() {
    return ((ProductServiceStubSettings) getStubSettings()).addFulfillmentPlacesSettings();
  }

  /** Returns the object with the settings used for calls to addFulfillmentPlaces. */
  public OperationCallSettings<
          AddFulfillmentPlacesRequest, AddFulfillmentPlacesResponse, AddFulfillmentPlacesMetadata>
      addFulfillmentPlacesOperationSettings() {
    return ((ProductServiceStubSettings) getStubSettings()).addFulfillmentPlacesOperationSettings();
  }

  /** Returns the object with the settings used for calls to removeFulfillmentPlaces. */
  public UnaryCallSettings<RemoveFulfillmentPlacesRequest, Operation>
      removeFulfillmentPlacesSettings() {
    return ((ProductServiceStubSettings) getStubSettings()).removeFulfillmentPlacesSettings();
  }

  /** Returns the object with the settings used for calls to removeFulfillmentPlaces. */
  public OperationCallSettings<
          RemoveFulfillmentPlacesRequest,
          RemoveFulfillmentPlacesResponse,
          RemoveFulfillmentPlacesMetadata>
      removeFulfillmentPlacesOperationSettings() {
    return ((ProductServiceStubSettings) getStubSettings())
        .removeFulfillmentPlacesOperationSettings();
  }

  /** Returns the object with the settings used for calls to addLocalInventories. */
  public UnaryCallSettings<AddLocalInventoriesRequest, Operation> addLocalInventoriesSettings() {
    return ((ProductServiceStubSettings) getStubSettings()).addLocalInventoriesSettings();
  }

  /** Returns the object with the settings used for calls to addLocalInventories. */
  public OperationCallSettings<
          AddLocalInventoriesRequest, AddLocalInventoriesResponse, AddLocalInventoriesMetadata>
      addLocalInventoriesOperationSettings() {
    return ((ProductServiceStubSettings) getStubSettings()).addLocalInventoriesOperationSettings();
  }

  /** Returns the object with the settings used for calls to removeLocalInventories. */
  public UnaryCallSettings<RemoveLocalInventoriesRequest, Operation>
      removeLocalInventoriesSettings() {
    return ((ProductServiceStubSettings) getStubSettings()).removeLocalInventoriesSettings();
  }

  /** Returns the object with the settings used for calls to removeLocalInventories. */
  public OperationCallSettings<
          RemoveLocalInventoriesRequest,
          RemoveLocalInventoriesResponse,
          RemoveLocalInventoriesMetadata>
      removeLocalInventoriesOperationSettings() {
    return ((ProductServiceStubSettings) getStubSettings())
        .removeLocalInventoriesOperationSettings();
  }

  public static final ProductServiceSettings create(ProductServiceStubSettings stub)
      throws IOException {
    return new ProductServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ProductServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ProductServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ProductServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ProductServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ProductServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ProductServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ProductServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ProductServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ProductServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ProductServiceSettings. */
  public static class Builder extends ClientSettings.Builder<ProductServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ProductServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ProductServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ProductServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ProductServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(ProductServiceStubSettings.newHttpJsonBuilder());
    }

    public ProductServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ProductServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createProduct. */
    public UnaryCallSettings.Builder<CreateProductRequest, Product> createProductSettings() {
      return getStubSettingsBuilder().createProductSettings();
    }

    /** Returns the builder for the settings used for calls to getProduct. */
    public UnaryCallSettings.Builder<GetProductRequest, Product> getProductSettings() {
      return getStubSettingsBuilder().getProductSettings();
    }

    /** Returns the builder for the settings used for calls to listProducts. */
    public PagedCallSettings.Builder<
            ListProductsRequest, ListProductsResponse, ListProductsPagedResponse>
        listProductsSettings() {
      return getStubSettingsBuilder().listProductsSettings();
    }

    /** Returns the builder for the settings used for calls to updateProduct. */
    public UnaryCallSettings.Builder<UpdateProductRequest, Product> updateProductSettings() {
      return getStubSettingsBuilder().updateProductSettings();
    }

    /** Returns the builder for the settings used for calls to deleteProduct. */
    public UnaryCallSettings.Builder<DeleteProductRequest, Empty> deleteProductSettings() {
      return getStubSettingsBuilder().deleteProductSettings();
    }

    /** Returns the builder for the settings used for calls to purgeProducts. */
    public UnaryCallSettings.Builder<PurgeProductsRequest, Operation> purgeProductsSettings() {
      return getStubSettingsBuilder().purgeProductsSettings();
    }

    /** Returns the builder for the settings used for calls to purgeProducts. */
    public OperationCallSettings.Builder<
            PurgeProductsRequest, PurgeProductsResponse, PurgeProductsMetadata>
        purgeProductsOperationSettings() {
      return getStubSettingsBuilder().purgeProductsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to importProducts. */
    public UnaryCallSettings.Builder<ImportProductsRequest, Operation> importProductsSettings() {
      return getStubSettingsBuilder().importProductsSettings();
    }

    /** Returns the builder for the settings used for calls to importProducts. */
    public OperationCallSettings.Builder<
            ImportProductsRequest, ImportProductsResponse, ImportMetadata>
        importProductsOperationSettings() {
      return getStubSettingsBuilder().importProductsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setInventory. */
    public UnaryCallSettings.Builder<SetInventoryRequest, Operation> setInventorySettings() {
      return getStubSettingsBuilder().setInventorySettings();
    }

    /** Returns the builder for the settings used for calls to setInventory. */
    public OperationCallSettings.Builder<
            SetInventoryRequest, SetInventoryResponse, SetInventoryMetadata>
        setInventoryOperationSettings() {
      return getStubSettingsBuilder().setInventoryOperationSettings();
    }

    /** Returns the builder for the settings used for calls to addFulfillmentPlaces. */
    public UnaryCallSettings.Builder<AddFulfillmentPlacesRequest, Operation>
        addFulfillmentPlacesSettings() {
      return getStubSettingsBuilder().addFulfillmentPlacesSettings();
    }

    /** Returns the builder for the settings used for calls to addFulfillmentPlaces. */
    public OperationCallSettings.Builder<
            AddFulfillmentPlacesRequest, AddFulfillmentPlacesResponse, AddFulfillmentPlacesMetadata>
        addFulfillmentPlacesOperationSettings() {
      return getStubSettingsBuilder().addFulfillmentPlacesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to removeFulfillmentPlaces. */
    public UnaryCallSettings.Builder<RemoveFulfillmentPlacesRequest, Operation>
        removeFulfillmentPlacesSettings() {
      return getStubSettingsBuilder().removeFulfillmentPlacesSettings();
    }

    /** Returns the builder for the settings used for calls to removeFulfillmentPlaces. */
    public OperationCallSettings.Builder<
            RemoveFulfillmentPlacesRequest,
            RemoveFulfillmentPlacesResponse,
            RemoveFulfillmentPlacesMetadata>
        removeFulfillmentPlacesOperationSettings() {
      return getStubSettingsBuilder().removeFulfillmentPlacesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to addLocalInventories. */
    public UnaryCallSettings.Builder<AddLocalInventoriesRequest, Operation>
        addLocalInventoriesSettings() {
      return getStubSettingsBuilder().addLocalInventoriesSettings();
    }

    /** Returns the builder for the settings used for calls to addLocalInventories. */
    public OperationCallSettings.Builder<
            AddLocalInventoriesRequest, AddLocalInventoriesResponse, AddLocalInventoriesMetadata>
        addLocalInventoriesOperationSettings() {
      return getStubSettingsBuilder().addLocalInventoriesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to removeLocalInventories. */
    public UnaryCallSettings.Builder<RemoveLocalInventoriesRequest, Operation>
        removeLocalInventoriesSettings() {
      return getStubSettingsBuilder().removeLocalInventoriesSettings();
    }

    /** Returns the builder for the settings used for calls to removeLocalInventories. */
    public OperationCallSettings.Builder<
            RemoveLocalInventoriesRequest,
            RemoveLocalInventoriesResponse,
            RemoveLocalInventoriesMetadata>
        removeLocalInventoriesOperationSettings() {
      return getStubSettingsBuilder().removeLocalInventoriesOperationSettings();
    }

    @Override
    public ProductServiceSettings build() throws IOException {
      return new ProductServiceSettings(this);
    }
  }
}
