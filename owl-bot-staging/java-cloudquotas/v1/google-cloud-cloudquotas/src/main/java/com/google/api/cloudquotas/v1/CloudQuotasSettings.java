/*
 * Copyright 2023 Google LLC
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

package com.google.api.cloudquotas.v1;

import static com.google.api.cloudquotas.v1.CloudQuotasClient.ListQuotaInfosPagedResponse;
import static com.google.api.cloudquotas.v1.CloudQuotasClient.ListQuotaPreferencesPagedResponse;

import com.google.api.cloudquotas.v1.stub.CloudQuotasStubSettings;
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
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CloudQuotasClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudquotas.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getQuotaInfo to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudQuotasSettings.Builder cloudQuotasSettingsBuilder = CloudQuotasSettings.newBuilder();
 * cloudQuotasSettingsBuilder
 *     .getQuotaInfoSettings()
 *     .setRetrySettings(
 *         cloudQuotasSettingsBuilder
 *             .getQuotaInfoSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CloudQuotasSettings cloudQuotasSettings = cloudQuotasSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CloudQuotasSettings extends ClientSettings<CloudQuotasSettings> {

  /** Returns the object with the settings used for calls to listQuotaInfos. */
  public PagedCallSettings<
          ListQuotaInfosRequest, ListQuotaInfosResponse, ListQuotaInfosPagedResponse>
      listQuotaInfosSettings() {
    return ((CloudQuotasStubSettings) getStubSettings()).listQuotaInfosSettings();
  }

  /** Returns the object with the settings used for calls to getQuotaInfo. */
  public UnaryCallSettings<GetQuotaInfoRequest, QuotaInfo> getQuotaInfoSettings() {
    return ((CloudQuotasStubSettings) getStubSettings()).getQuotaInfoSettings();
  }

  /** Returns the object with the settings used for calls to listQuotaPreferences. */
  public PagedCallSettings<
          ListQuotaPreferencesRequest,
          ListQuotaPreferencesResponse,
          ListQuotaPreferencesPagedResponse>
      listQuotaPreferencesSettings() {
    return ((CloudQuotasStubSettings) getStubSettings()).listQuotaPreferencesSettings();
  }

  /** Returns the object with the settings used for calls to getQuotaPreference. */
  public UnaryCallSettings<GetQuotaPreferenceRequest, QuotaPreference>
      getQuotaPreferenceSettings() {
    return ((CloudQuotasStubSettings) getStubSettings()).getQuotaPreferenceSettings();
  }

  /** Returns the object with the settings used for calls to createQuotaPreference. */
  public UnaryCallSettings<CreateQuotaPreferenceRequest, QuotaPreference>
      createQuotaPreferenceSettings() {
    return ((CloudQuotasStubSettings) getStubSettings()).createQuotaPreferenceSettings();
  }

  /** Returns the object with the settings used for calls to updateQuotaPreference. */
  public UnaryCallSettings<UpdateQuotaPreferenceRequest, QuotaPreference>
      updateQuotaPreferenceSettings() {
    return ((CloudQuotasStubSettings) getStubSettings()).updateQuotaPreferenceSettings();
  }

  public static final CloudQuotasSettings create(CloudQuotasStubSettings stub) throws IOException {
    return new CloudQuotasSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CloudQuotasStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CloudQuotasStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CloudQuotasStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CloudQuotasStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return CloudQuotasStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CloudQuotasStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CloudQuotasStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CloudQuotasStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected CloudQuotasSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CloudQuotasSettings. */
  public static class Builder extends ClientSettings.Builder<CloudQuotasSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(CloudQuotasStubSettings.newBuilder(clientContext));
    }

    protected Builder(CloudQuotasSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CloudQuotasStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CloudQuotasStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(CloudQuotasStubSettings.newHttpJsonBuilder());
    }

    public CloudQuotasStubSettings.Builder getStubSettingsBuilder() {
      return ((CloudQuotasStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listQuotaInfos. */
    public PagedCallSettings.Builder<
            ListQuotaInfosRequest, ListQuotaInfosResponse, ListQuotaInfosPagedResponse>
        listQuotaInfosSettings() {
      return getStubSettingsBuilder().listQuotaInfosSettings();
    }

    /** Returns the builder for the settings used for calls to getQuotaInfo. */
    public UnaryCallSettings.Builder<GetQuotaInfoRequest, QuotaInfo> getQuotaInfoSettings() {
      return getStubSettingsBuilder().getQuotaInfoSettings();
    }

    /** Returns the builder for the settings used for calls to listQuotaPreferences. */
    public PagedCallSettings.Builder<
            ListQuotaPreferencesRequest,
            ListQuotaPreferencesResponse,
            ListQuotaPreferencesPagedResponse>
        listQuotaPreferencesSettings() {
      return getStubSettingsBuilder().listQuotaPreferencesSettings();
    }

    /** Returns the builder for the settings used for calls to getQuotaPreference. */
    public UnaryCallSettings.Builder<GetQuotaPreferenceRequest, QuotaPreference>
        getQuotaPreferenceSettings() {
      return getStubSettingsBuilder().getQuotaPreferenceSettings();
    }

    /** Returns the builder for the settings used for calls to createQuotaPreference. */
    public UnaryCallSettings.Builder<CreateQuotaPreferenceRequest, QuotaPreference>
        createQuotaPreferenceSettings() {
      return getStubSettingsBuilder().createQuotaPreferenceSettings();
    }

    /** Returns the builder for the settings used for calls to updateQuotaPreference. */
    public UnaryCallSettings.Builder<UpdateQuotaPreferenceRequest, QuotaPreference>
        updateQuotaPreferenceSettings() {
      return getStubSettingsBuilder().updateQuotaPreferenceSettings();
    }

    @Override
    public CloudQuotasSettings build() throws IOException {
      return new CloudQuotasSettings(this);
    }
  }
}
