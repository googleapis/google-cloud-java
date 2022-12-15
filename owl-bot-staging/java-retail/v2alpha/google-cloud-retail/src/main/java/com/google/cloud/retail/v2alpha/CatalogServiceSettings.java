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

import static com.google.cloud.retail.v2alpha.CatalogServiceClient.ListCatalogsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.retail.v2alpha.stub.CatalogServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CatalogServiceClient}.
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
 * <p>For example, to set the total timeout of updateCatalog to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CatalogServiceSettings.Builder catalogServiceSettingsBuilder =
 *     CatalogServiceSettings.newBuilder();
 * catalogServiceSettingsBuilder
 *     .updateCatalogSettings()
 *     .setRetrySettings(
 *         catalogServiceSettingsBuilder.updateCatalogSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CatalogServiceSettings catalogServiceSettings = catalogServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class CatalogServiceSettings extends ClientSettings<CatalogServiceSettings> {

  /** Returns the object with the settings used for calls to listCatalogs. */
  public PagedCallSettings<ListCatalogsRequest, ListCatalogsResponse, ListCatalogsPagedResponse>
      listCatalogsSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).listCatalogsSettings();
  }

  /** Returns the object with the settings used for calls to updateCatalog. */
  public UnaryCallSettings<UpdateCatalogRequest, Catalog> updateCatalogSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).updateCatalogSettings();
  }

  /** Returns the object with the settings used for calls to setDefaultBranch. */
  public UnaryCallSettings<SetDefaultBranchRequest, Empty> setDefaultBranchSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).setDefaultBranchSettings();
  }

  /** Returns the object with the settings used for calls to getDefaultBranch. */
  public UnaryCallSettings<GetDefaultBranchRequest, GetDefaultBranchResponse>
      getDefaultBranchSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).getDefaultBranchSettings();
  }

  /** Returns the object with the settings used for calls to getCompletionConfig. */
  public UnaryCallSettings<GetCompletionConfigRequest, CompletionConfig>
      getCompletionConfigSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).getCompletionConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateCompletionConfig. */
  public UnaryCallSettings<UpdateCompletionConfigRequest, CompletionConfig>
      updateCompletionConfigSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).updateCompletionConfigSettings();
  }

  /** Returns the object with the settings used for calls to getAttributesConfig. */
  public UnaryCallSettings<GetAttributesConfigRequest, AttributesConfig>
      getAttributesConfigSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).getAttributesConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateAttributesConfig. */
  public UnaryCallSettings<UpdateAttributesConfigRequest, AttributesConfig>
      updateAttributesConfigSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).updateAttributesConfigSettings();
  }

  /** Returns the object with the settings used for calls to addCatalogAttribute. */
  public UnaryCallSettings<AddCatalogAttributeRequest, AttributesConfig>
      addCatalogAttributeSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).addCatalogAttributeSettings();
  }

  /** Returns the object with the settings used for calls to removeCatalogAttribute. */
  public UnaryCallSettings<RemoveCatalogAttributeRequest, AttributesConfig>
      removeCatalogAttributeSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).removeCatalogAttributeSettings();
  }

  /** Returns the object with the settings used for calls to batchRemoveCatalogAttributes. */
  public UnaryCallSettings<
          BatchRemoveCatalogAttributesRequest, BatchRemoveCatalogAttributesResponse>
      batchRemoveCatalogAttributesSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).batchRemoveCatalogAttributesSettings();
  }

  /** Returns the object with the settings used for calls to replaceCatalogAttribute. */
  public UnaryCallSettings<ReplaceCatalogAttributeRequest, AttributesConfig>
      replaceCatalogAttributeSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).replaceCatalogAttributeSettings();
  }

  public static final CatalogServiceSettings create(CatalogServiceStubSettings stub)
      throws IOException {
    return new CatalogServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CatalogServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CatalogServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CatalogServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CatalogServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return CatalogServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CatalogServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CatalogServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CatalogServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected CatalogServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CatalogServiceSettings. */
  public static class Builder extends ClientSettings.Builder<CatalogServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(CatalogServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(CatalogServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CatalogServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CatalogServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(CatalogServiceStubSettings.newHttpJsonBuilder());
    }

    public CatalogServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((CatalogServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listCatalogs. */
    public PagedCallSettings.Builder<
            ListCatalogsRequest, ListCatalogsResponse, ListCatalogsPagedResponse>
        listCatalogsSettings() {
      return getStubSettingsBuilder().listCatalogsSettings();
    }

    /** Returns the builder for the settings used for calls to updateCatalog. */
    public UnaryCallSettings.Builder<UpdateCatalogRequest, Catalog> updateCatalogSettings() {
      return getStubSettingsBuilder().updateCatalogSettings();
    }

    /** Returns the builder for the settings used for calls to setDefaultBranch. */
    public UnaryCallSettings.Builder<SetDefaultBranchRequest, Empty> setDefaultBranchSettings() {
      return getStubSettingsBuilder().setDefaultBranchSettings();
    }

    /** Returns the builder for the settings used for calls to getDefaultBranch. */
    public UnaryCallSettings.Builder<GetDefaultBranchRequest, GetDefaultBranchResponse>
        getDefaultBranchSettings() {
      return getStubSettingsBuilder().getDefaultBranchSettings();
    }

    /** Returns the builder for the settings used for calls to getCompletionConfig. */
    public UnaryCallSettings.Builder<GetCompletionConfigRequest, CompletionConfig>
        getCompletionConfigSettings() {
      return getStubSettingsBuilder().getCompletionConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateCompletionConfig. */
    public UnaryCallSettings.Builder<UpdateCompletionConfigRequest, CompletionConfig>
        updateCompletionConfigSettings() {
      return getStubSettingsBuilder().updateCompletionConfigSettings();
    }

    /** Returns the builder for the settings used for calls to getAttributesConfig. */
    public UnaryCallSettings.Builder<GetAttributesConfigRequest, AttributesConfig>
        getAttributesConfigSettings() {
      return getStubSettingsBuilder().getAttributesConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateAttributesConfig. */
    public UnaryCallSettings.Builder<UpdateAttributesConfigRequest, AttributesConfig>
        updateAttributesConfigSettings() {
      return getStubSettingsBuilder().updateAttributesConfigSettings();
    }

    /** Returns the builder for the settings used for calls to addCatalogAttribute. */
    public UnaryCallSettings.Builder<AddCatalogAttributeRequest, AttributesConfig>
        addCatalogAttributeSettings() {
      return getStubSettingsBuilder().addCatalogAttributeSettings();
    }

    /** Returns the builder for the settings used for calls to removeCatalogAttribute. */
    public UnaryCallSettings.Builder<RemoveCatalogAttributeRequest, AttributesConfig>
        removeCatalogAttributeSettings() {
      return getStubSettingsBuilder().removeCatalogAttributeSettings();
    }

    /** Returns the builder for the settings used for calls to batchRemoveCatalogAttributes. */
    public UnaryCallSettings.Builder<
            BatchRemoveCatalogAttributesRequest, BatchRemoveCatalogAttributesResponse>
        batchRemoveCatalogAttributesSettings() {
      return getStubSettingsBuilder().batchRemoveCatalogAttributesSettings();
    }

    /** Returns the builder for the settings used for calls to replaceCatalogAttribute. */
    public UnaryCallSettings.Builder<ReplaceCatalogAttributeRequest, AttributesConfig>
        replaceCatalogAttributeSettings() {
      return getStubSettingsBuilder().replaceCatalogAttributeSettings();
    }

    @Override
    public CatalogServiceSettings build() throws IOException {
      return new CatalogServiceSettings(this);
    }
  }
}
