/*
 * Copyright 2024 Google LLC
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

package com.google.shopping.merchant.lfp.v1beta;

import static com.google.shopping.merchant.lfp.v1beta.LfpStoreServiceClient.ListLfpStoresPagedResponse;

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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.lfp.v1beta.stub.LfpStoreServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link LfpStoreServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (merchantapi.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getLfpStore to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LfpStoreServiceSettings.Builder lfpStoreServiceSettingsBuilder =
 *     LfpStoreServiceSettings.newBuilder();
 * lfpStoreServiceSettingsBuilder
 *     .getLfpStoreSettings()
 *     .setRetrySettings(
 *         lfpStoreServiceSettingsBuilder
 *             .getLfpStoreSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * LfpStoreServiceSettings lfpStoreServiceSettings = lfpStoreServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class LfpStoreServiceSettings extends ClientSettings<LfpStoreServiceSettings> {

  /** Returns the object with the settings used for calls to getLfpStore. */
  public UnaryCallSettings<GetLfpStoreRequest, LfpStore> getLfpStoreSettings() {
    return ((LfpStoreServiceStubSettings) getStubSettings()).getLfpStoreSettings();
  }

  /** Returns the object with the settings used for calls to insertLfpStore. */
  public UnaryCallSettings<InsertLfpStoreRequest, LfpStore> insertLfpStoreSettings() {
    return ((LfpStoreServiceStubSettings) getStubSettings()).insertLfpStoreSettings();
  }

  /** Returns the object with the settings used for calls to deleteLfpStore. */
  public UnaryCallSettings<DeleteLfpStoreRequest, Empty> deleteLfpStoreSettings() {
    return ((LfpStoreServiceStubSettings) getStubSettings()).deleteLfpStoreSettings();
  }

  /** Returns the object with the settings used for calls to listLfpStores. */
  public PagedCallSettings<ListLfpStoresRequest, ListLfpStoresResponse, ListLfpStoresPagedResponse>
      listLfpStoresSettings() {
    return ((LfpStoreServiceStubSettings) getStubSettings()).listLfpStoresSettings();
  }

  public static final LfpStoreServiceSettings create(LfpStoreServiceStubSettings stub)
      throws IOException {
    return new LfpStoreServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return LfpStoreServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return LfpStoreServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return LfpStoreServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return LfpStoreServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return LfpStoreServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return LfpStoreServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return LfpStoreServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return LfpStoreServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
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

  protected LfpStoreServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for LfpStoreServiceSettings. */
  public static class Builder extends ClientSettings.Builder<LfpStoreServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(LfpStoreServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(LfpStoreServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(LfpStoreServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(LfpStoreServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(LfpStoreServiceStubSettings.newHttpJsonBuilder());
    }

    public LfpStoreServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((LfpStoreServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getLfpStore. */
    public UnaryCallSettings.Builder<GetLfpStoreRequest, LfpStore> getLfpStoreSettings() {
      return getStubSettingsBuilder().getLfpStoreSettings();
    }

    /** Returns the builder for the settings used for calls to insertLfpStore. */
    public UnaryCallSettings.Builder<InsertLfpStoreRequest, LfpStore> insertLfpStoreSettings() {
      return getStubSettingsBuilder().insertLfpStoreSettings();
    }

    /** Returns the builder for the settings used for calls to deleteLfpStore. */
    public UnaryCallSettings.Builder<DeleteLfpStoreRequest, Empty> deleteLfpStoreSettings() {
      return getStubSettingsBuilder().deleteLfpStoreSettings();
    }

    /** Returns the builder for the settings used for calls to listLfpStores. */
    public PagedCallSettings.Builder<
            ListLfpStoresRequest, ListLfpStoresResponse, ListLfpStoresPagedResponse>
        listLfpStoresSettings() {
      return getStubSettingsBuilder().listLfpStoresSettings();
    }

    @Override
    public LfpStoreServiceSettings build() throws IOException {
      return new LfpStoreServiceSettings(this);
    }
  }
}
