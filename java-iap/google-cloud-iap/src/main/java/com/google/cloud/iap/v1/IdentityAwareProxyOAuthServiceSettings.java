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

package com.google.cloud.iap.v1;

import static com.google.cloud.iap.v1.IdentityAwareProxyOAuthServiceClient.ListIdentityAwareProxyClientsPagedResponse;

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
import com.google.cloud.iap.v1.stub.IdentityAwareProxyOAuthServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link IdentityAwareProxyOAuthServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (iap.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of listBrands to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IdentityAwareProxyOAuthServiceSettings.Builder identityAwareProxyOAuthServiceSettingsBuilder =
 *     IdentityAwareProxyOAuthServiceSettings.newBuilder();
 * identityAwareProxyOAuthServiceSettingsBuilder
 *     .listBrandsSettings()
 *     .setRetrySettings(
 *         identityAwareProxyOAuthServiceSettingsBuilder
 *             .listBrandsSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * IdentityAwareProxyOAuthServiceSettings identityAwareProxyOAuthServiceSettings =
 *     identityAwareProxyOAuthServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class IdentityAwareProxyOAuthServiceSettings
    extends ClientSettings<IdentityAwareProxyOAuthServiceSettings> {

  /** Returns the object with the settings used for calls to listBrands. */
  public UnaryCallSettings<ListBrandsRequest, ListBrandsResponse> listBrandsSettings() {
    return ((IdentityAwareProxyOAuthServiceStubSettings) getStubSettings()).listBrandsSettings();
  }

  /** Returns the object with the settings used for calls to createBrand. */
  public UnaryCallSettings<CreateBrandRequest, Brand> createBrandSettings() {
    return ((IdentityAwareProxyOAuthServiceStubSettings) getStubSettings()).createBrandSettings();
  }

  /** Returns the object with the settings used for calls to getBrand. */
  public UnaryCallSettings<GetBrandRequest, Brand> getBrandSettings() {
    return ((IdentityAwareProxyOAuthServiceStubSettings) getStubSettings()).getBrandSettings();
  }

  /** Returns the object with the settings used for calls to createIdentityAwareProxyClient. */
  public UnaryCallSettings<CreateIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
      createIdentityAwareProxyClientSettings() {
    return ((IdentityAwareProxyOAuthServiceStubSettings) getStubSettings())
        .createIdentityAwareProxyClientSettings();
  }

  /** Returns the object with the settings used for calls to listIdentityAwareProxyClients. */
  public PagedCallSettings<
          ListIdentityAwareProxyClientsRequest,
          ListIdentityAwareProxyClientsResponse,
          ListIdentityAwareProxyClientsPagedResponse>
      listIdentityAwareProxyClientsSettings() {
    return ((IdentityAwareProxyOAuthServiceStubSettings) getStubSettings())
        .listIdentityAwareProxyClientsSettings();
  }

  /** Returns the object with the settings used for calls to getIdentityAwareProxyClient. */
  public UnaryCallSettings<GetIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
      getIdentityAwareProxyClientSettings() {
    return ((IdentityAwareProxyOAuthServiceStubSettings) getStubSettings())
        .getIdentityAwareProxyClientSettings();
  }

  /** Returns the object with the settings used for calls to resetIdentityAwareProxyClientSecret. */
  public UnaryCallSettings<ResetIdentityAwareProxyClientSecretRequest, IdentityAwareProxyClient>
      resetIdentityAwareProxyClientSecretSettings() {
    return ((IdentityAwareProxyOAuthServiceStubSettings) getStubSettings())
        .resetIdentityAwareProxyClientSecretSettings();
  }

  /** Returns the object with the settings used for calls to deleteIdentityAwareProxyClient. */
  public UnaryCallSettings<DeleteIdentityAwareProxyClientRequest, Empty>
      deleteIdentityAwareProxyClientSettings() {
    return ((IdentityAwareProxyOAuthServiceStubSettings) getStubSettings())
        .deleteIdentityAwareProxyClientSettings();
  }

  public static final IdentityAwareProxyOAuthServiceSettings create(
      IdentityAwareProxyOAuthServiceStubSettings stub) throws IOException {
    return new IdentityAwareProxyOAuthServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return IdentityAwareProxyOAuthServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return IdentityAwareProxyOAuthServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return IdentityAwareProxyOAuthServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return IdentityAwareProxyOAuthServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return IdentityAwareProxyOAuthServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return IdentityAwareProxyOAuthServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return IdentityAwareProxyOAuthServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return IdentityAwareProxyOAuthServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected IdentityAwareProxyOAuthServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for IdentityAwareProxyOAuthServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<IdentityAwareProxyOAuthServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(IdentityAwareProxyOAuthServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(IdentityAwareProxyOAuthServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(IdentityAwareProxyOAuthServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(IdentityAwareProxyOAuthServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(IdentityAwareProxyOAuthServiceStubSettings.newHttpJsonBuilder());
    }

    public IdentityAwareProxyOAuthServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((IdentityAwareProxyOAuthServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listBrands. */
    public UnaryCallSettings.Builder<ListBrandsRequest, ListBrandsResponse> listBrandsSettings() {
      return getStubSettingsBuilder().listBrandsSettings();
    }

    /** Returns the builder for the settings used for calls to createBrand. */
    public UnaryCallSettings.Builder<CreateBrandRequest, Brand> createBrandSettings() {
      return getStubSettingsBuilder().createBrandSettings();
    }

    /** Returns the builder for the settings used for calls to getBrand. */
    public UnaryCallSettings.Builder<GetBrandRequest, Brand> getBrandSettings() {
      return getStubSettingsBuilder().getBrandSettings();
    }

    /** Returns the builder for the settings used for calls to createIdentityAwareProxyClient. */
    public UnaryCallSettings.Builder<
            CreateIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
        createIdentityAwareProxyClientSettings() {
      return getStubSettingsBuilder().createIdentityAwareProxyClientSettings();
    }

    /** Returns the builder for the settings used for calls to listIdentityAwareProxyClients. */
    public PagedCallSettings.Builder<
            ListIdentityAwareProxyClientsRequest,
            ListIdentityAwareProxyClientsResponse,
            ListIdentityAwareProxyClientsPagedResponse>
        listIdentityAwareProxyClientsSettings() {
      return getStubSettingsBuilder().listIdentityAwareProxyClientsSettings();
    }

    /** Returns the builder for the settings used for calls to getIdentityAwareProxyClient. */
    public UnaryCallSettings.Builder<GetIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
        getIdentityAwareProxyClientSettings() {
      return getStubSettingsBuilder().getIdentityAwareProxyClientSettings();
    }

    /**
     * Returns the builder for the settings used for calls to resetIdentityAwareProxyClientSecret.
     */
    public UnaryCallSettings.Builder<
            ResetIdentityAwareProxyClientSecretRequest, IdentityAwareProxyClient>
        resetIdentityAwareProxyClientSecretSettings() {
      return getStubSettingsBuilder().resetIdentityAwareProxyClientSecretSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIdentityAwareProxyClient. */
    public UnaryCallSettings.Builder<DeleteIdentityAwareProxyClientRequest, Empty>
        deleteIdentityAwareProxyClientSettings() {
      return getStubSettingsBuilder().deleteIdentityAwareProxyClientSettings();
    }

    @Override
    public IdentityAwareProxyOAuthServiceSettings build() throws IOException {
      return new IdentityAwareProxyOAuthServiceSettings(this);
    }
  }
}
