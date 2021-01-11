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

package com.google.cloud.retail.v2.stub;

import com.google.api.core.ApiFunction;
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
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.retail.v2.CreateProductRequest;
import com.google.cloud.retail.v2.DeleteProductRequest;
import com.google.cloud.retail.v2.GetProductRequest;
import com.google.cloud.retail.v2.ImportMetadata;
import com.google.cloud.retail.v2.ImportProductsRequest;
import com.google.cloud.retail.v2.ImportProductsResponse;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.UpdateProductRequest;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ProductServiceStub}.
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
 * ProductServiceStubSettings.Builder productServiceSettingsBuilder =
 *     ProductServiceStubSettings.newBuilder();
 * productServiceSettingsBuilder
 *     .createProductSettings()
 *     .setRetrySettings(
 *         productServiceSettingsBuilder
 *             .createProductSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ProductServiceStubSettings productServiceSettings = productServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ProductServiceStubSettings extends StubSettings<ProductServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateProductRequest, Product> createProductSettings;
  private final UnaryCallSettings<GetProductRequest, Product> getProductSettings;
  private final UnaryCallSettings<UpdateProductRequest, Product> updateProductSettings;
  private final UnaryCallSettings<DeleteProductRequest, Empty> deleteProductSettings;
  private final UnaryCallSettings<ImportProductsRequest, Operation> importProductsSettings;
  private final OperationCallSettings<ImportProductsRequest, ImportProductsResponse, ImportMetadata>
      importProductsOperationSettings;

  /** Returns the object with the settings used for calls to createProduct. */
  public UnaryCallSettings<CreateProductRequest, Product> createProductSettings() {
    return createProductSettings;
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

  /** Returns the object with the settings used for calls to importProducts. */
  public UnaryCallSettings<ImportProductsRequest, Operation> importProductsSettings() {
    return importProductsSettings;
  }

  /** Returns the object with the settings used for calls to importProducts. */
  public OperationCallSettings<ImportProductsRequest, ImportProductsResponse, ImportMetadata>
      importProductsOperationSettings() {
    return importProductsOperationSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ProductServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcProductServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "retail.googleapis.com:443";
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
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ProductServiceStubSettings.class))
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

  protected ProductServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createProductSettings = settingsBuilder.createProductSettings().build();
    getProductSettings = settingsBuilder.getProductSettings().build();
    updateProductSettings = settingsBuilder.updateProductSettings().build();
    deleteProductSettings = settingsBuilder.deleteProductSettings().build();
    importProductsSettings = settingsBuilder.importProductsSettings().build();
    importProductsOperationSettings = settingsBuilder.importProductsOperationSettings().build();
  }

  /** Builder for ProductServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<ProductServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateProductRequest, Product> createProductSettings;
    private final UnaryCallSettings.Builder<GetProductRequest, Product> getProductSettings;
    private final UnaryCallSettings.Builder<UpdateProductRequest, Product> updateProductSettings;
    private final UnaryCallSettings.Builder<DeleteProductRequest, Empty> deleteProductSettings;
    private final UnaryCallSettings.Builder<ImportProductsRequest, Operation>
        importProductsSettings;
    private final OperationCallSettings.Builder<
            ImportProductsRequest, ImportProductsResponse, ImportMetadata>
        importProductsOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.DEADLINE_EXCEEDED)));
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
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createProductSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getProductSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateProductSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteProductSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importProductsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importProductsOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createProductSettings,
              getProductSettings,
              updateProductSettings,
              deleteProductSettings,
              importProductsSettings);
      initDefaults(this);
    }

    protected Builder(ProductServiceStubSettings settings) {
      super(settings);

      createProductSettings = settings.createProductSettings.toBuilder();
      getProductSettings = settings.getProductSettings.toBuilder();
      updateProductSettings = settings.updateProductSettings.toBuilder();
      deleteProductSettings = settings.deleteProductSettings.toBuilder();
      importProductsSettings = settings.importProductsSettings.toBuilder();
      importProductsOperationSettings = settings.importProductsOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createProductSettings,
              getProductSettings,
              updateProductSettings,
              deleteProductSettings,
              importProductsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createProductSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getProductSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateProductSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteProductSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .importProductsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .importProductsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ImportProductsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ImportProductsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(ImportMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
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

    /** Returns the builder for the settings used for calls to importProducts. */
    public UnaryCallSettings.Builder<ImportProductsRequest, Operation> importProductsSettings() {
      return importProductsSettings;
    }

    /** Returns the builder for the settings used for calls to importProducts. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ImportProductsRequest, ImportProductsResponse, ImportMetadata>
        importProductsOperationSettings() {
      return importProductsOperationSettings;
    }

    @Override
    public ProductServiceStubSettings build() throws IOException {
      return new ProductServiceStubSettings(this);
    }
  }
}
