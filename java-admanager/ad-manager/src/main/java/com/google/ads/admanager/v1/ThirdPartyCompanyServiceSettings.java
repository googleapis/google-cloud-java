/*
 * Copyright 2026 Google LLC
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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.ThirdPartyCompanyServiceClient.ListThirdPartyCompaniesPagedResponse;

import com.google.ads.admanager.v1.stub.ThirdPartyCompanyServiceStubSettings;
import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ThirdPartyCompanyServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (admanager.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getThirdPartyCompany:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ThirdPartyCompanyServiceSettings.Builder thirdPartyCompanyServiceSettingsBuilder =
 *     ThirdPartyCompanyServiceSettings.newBuilder();
 * thirdPartyCompanyServiceSettingsBuilder
 *     .getThirdPartyCompanySettings()
 *     .setRetrySettings(
 *         thirdPartyCompanyServiceSettingsBuilder
 *             .getThirdPartyCompanySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * ThirdPartyCompanyServiceSettings thirdPartyCompanyServiceSettings =
 *     thirdPartyCompanyServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class ThirdPartyCompanyServiceSettings
    extends ClientSettings<ThirdPartyCompanyServiceSettings> {

  /** Returns the object with the settings used for calls to getThirdPartyCompany. */
  public UnaryCallSettings<GetThirdPartyCompanyRequest, ThirdPartyCompany>
      getThirdPartyCompanySettings() {
    return ((ThirdPartyCompanyServiceStubSettings) getStubSettings())
        .getThirdPartyCompanySettings();
  }

  /** Returns the object with the settings used for calls to listThirdPartyCompanies. */
  public PagedCallSettings<
          ListThirdPartyCompaniesRequest,
          ListThirdPartyCompaniesResponse,
          ListThirdPartyCompaniesPagedResponse>
      listThirdPartyCompaniesSettings() {
    return ((ThirdPartyCompanyServiceStubSettings) getStubSettings())
        .listThirdPartyCompaniesSettings();
  }

  public static final ThirdPartyCompanyServiceSettings create(
      ThirdPartyCompanyServiceStubSettings stub) throws IOException {
    return new ThirdPartyCompanyServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ThirdPartyCompanyServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ThirdPartyCompanyServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ThirdPartyCompanyServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ThirdPartyCompanyServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ThirdPartyCompanyServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ThirdPartyCompanyServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ThirdPartyCompanyServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected ThirdPartyCompanyServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ThirdPartyCompanyServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<ThirdPartyCompanyServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(ThirdPartyCompanyServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ThirdPartyCompanyServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ThirdPartyCompanyServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ThirdPartyCompanyServiceStubSettings.newBuilder());
    }

    public ThirdPartyCompanyServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ThirdPartyCompanyServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getThirdPartyCompany. */
    public UnaryCallSettings.Builder<GetThirdPartyCompanyRequest, ThirdPartyCompany>
        getThirdPartyCompanySettings() {
      return getStubSettingsBuilder().getThirdPartyCompanySettings();
    }

    /** Returns the builder for the settings used for calls to listThirdPartyCompanies. */
    public PagedCallSettings.Builder<
            ListThirdPartyCompaniesRequest,
            ListThirdPartyCompaniesResponse,
            ListThirdPartyCompaniesPagedResponse>
        listThirdPartyCompaniesSettings() {
      return getStubSettingsBuilder().listThirdPartyCompaniesSettings();
    }

    @Override
    public ThirdPartyCompanyServiceSettings build() throws IOException {
      return new ThirdPartyCompanyServiceSettings(this);
    }
  }
}
