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

package com.google.cloud.recommendationengine.v1beta1;

import static com.google.cloud.recommendationengine.v1beta1.CatalogServiceClient.ListCatalogItemsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.recommendationengine.v1beta1.stub.CatalogServiceStubSettings;
import com.google.longrunning.Operation;
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
 *   <li>The default service address (recommendationengine.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createCatalogItem to 30 seconds:
 *
 * <pre>{@code
 * CatalogServiceSettings.Builder catalogServiceSettingsBuilder =
 *     CatalogServiceSettings.newBuilder();
 * catalogServiceSettingsBuilder
 *     .createCatalogItemSettings()
 *     .setRetrySettings(
 *         catalogServiceSettingsBuilder
 *             .createCatalogItemSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CatalogServiceSettings catalogServiceSettings = catalogServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class CatalogServiceSettings extends ClientSettings<CatalogServiceSettings> {

  /** Returns the object with the settings used for calls to createCatalogItem. */
  public UnaryCallSettings<CreateCatalogItemRequest, CatalogItem> createCatalogItemSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).createCatalogItemSettings();
  }

  /** Returns the object with the settings used for calls to getCatalogItem. */
  public UnaryCallSettings<GetCatalogItemRequest, CatalogItem> getCatalogItemSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).getCatalogItemSettings();
  }

  /** Returns the object with the settings used for calls to listCatalogItems. */
  public PagedCallSettings<
          ListCatalogItemsRequest, ListCatalogItemsResponse, ListCatalogItemsPagedResponse>
      listCatalogItemsSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).listCatalogItemsSettings();
  }

  /** Returns the object with the settings used for calls to updateCatalogItem. */
  public UnaryCallSettings<UpdateCatalogItemRequest, CatalogItem> updateCatalogItemSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).updateCatalogItemSettings();
  }

  /** Returns the object with the settings used for calls to deleteCatalogItem. */
  public UnaryCallSettings<DeleteCatalogItemRequest, Empty> deleteCatalogItemSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).deleteCatalogItemSettings();
  }

  /** Returns the object with the settings used for calls to importCatalogItems. */
  public UnaryCallSettings<ImportCatalogItemsRequest, Operation> importCatalogItemsSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).importCatalogItemsSettings();
  }

  /** Returns the object with the settings used for calls to importCatalogItems. */
  public OperationCallSettings<
          ImportCatalogItemsRequest, ImportCatalogItemsResponse, ImportMetadata>
      importCatalogItemsOperationSettings() {
    return ((CatalogServiceStubSettings) getStubSettings()).importCatalogItemsOperationSettings();
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return CatalogServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CatalogServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CatalogServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

    public CatalogServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((CatalogServiceStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to createCatalogItem. */
    public UnaryCallSettings.Builder<CreateCatalogItemRequest, CatalogItem>
        createCatalogItemSettings() {
      return getStubSettingsBuilder().createCatalogItemSettings();
    }

    /** Returns the builder for the settings used for calls to getCatalogItem. */
    public UnaryCallSettings.Builder<GetCatalogItemRequest, CatalogItem> getCatalogItemSettings() {
      return getStubSettingsBuilder().getCatalogItemSettings();
    }

    /** Returns the builder for the settings used for calls to listCatalogItems. */
    public PagedCallSettings.Builder<
            ListCatalogItemsRequest, ListCatalogItemsResponse, ListCatalogItemsPagedResponse>
        listCatalogItemsSettings() {
      return getStubSettingsBuilder().listCatalogItemsSettings();
    }

    /** Returns the builder for the settings used for calls to updateCatalogItem. */
    public UnaryCallSettings.Builder<UpdateCatalogItemRequest, CatalogItem>
        updateCatalogItemSettings() {
      return getStubSettingsBuilder().updateCatalogItemSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCatalogItem. */
    public UnaryCallSettings.Builder<DeleteCatalogItemRequest, Empty> deleteCatalogItemSettings() {
      return getStubSettingsBuilder().deleteCatalogItemSettings();
    }

    /** Returns the builder for the settings used for calls to importCatalogItems. */
    public UnaryCallSettings.Builder<ImportCatalogItemsRequest, Operation>
        importCatalogItemsSettings() {
      return getStubSettingsBuilder().importCatalogItemsSettings();
    }

    /** Returns the builder for the settings used for calls to importCatalogItems. */
    public OperationCallSettings.Builder<
            ImportCatalogItemsRequest, ImportCatalogItemsResponse, ImportMetadata>
        importCatalogItemsOperationSettings() {
      return getStubSettingsBuilder().importCatalogItemsOperationSettings();
    }

    @Override
    public CatalogServiceSettings build() throws IOException {
      return new CatalogServiceSettings(this);
    }
  }
}
