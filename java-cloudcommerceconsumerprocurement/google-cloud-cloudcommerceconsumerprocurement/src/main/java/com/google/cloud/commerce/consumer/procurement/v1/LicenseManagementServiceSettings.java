/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.commerce.consumer.procurement.v1;

import static com.google.cloud.commerce.consumer.procurement.v1.LicenseManagementServiceClient.EnumerateLicensedUsersPagedResponse;

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
import com.google.cloud.commerce.consumer.procurement.v1.stub.LicenseManagementServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link LicenseManagementServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudcommerceconsumerprocurement.googleapis.com) and default
 *       port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getLicensePool:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LicenseManagementServiceSettings.Builder licenseManagementServiceSettingsBuilder =
 *     LicenseManagementServiceSettings.newBuilder();
 * licenseManagementServiceSettingsBuilder
 *     .getLicensePoolSettings()
 *     .setRetrySettings(
 *         licenseManagementServiceSettingsBuilder
 *             .getLicensePoolSettings()
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
 * LicenseManagementServiceSettings licenseManagementServiceSettings =
 *     licenseManagementServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class LicenseManagementServiceSettings
    extends ClientSettings<LicenseManagementServiceSettings> {

  /** Returns the object with the settings used for calls to getLicensePool. */
  public UnaryCallSettings<GetLicensePoolRequest, LicensePool> getLicensePoolSettings() {
    return ((LicenseManagementServiceStubSettings) getStubSettings()).getLicensePoolSettings();
  }

  /** Returns the object with the settings used for calls to updateLicensePool. */
  public UnaryCallSettings<UpdateLicensePoolRequest, LicensePool> updateLicensePoolSettings() {
    return ((LicenseManagementServiceStubSettings) getStubSettings()).updateLicensePoolSettings();
  }

  /** Returns the object with the settings used for calls to assign. */
  public UnaryCallSettings<AssignRequest, AssignResponse> assignSettings() {
    return ((LicenseManagementServiceStubSettings) getStubSettings()).assignSettings();
  }

  /** Returns the object with the settings used for calls to unassign. */
  public UnaryCallSettings<UnassignRequest, UnassignResponse> unassignSettings() {
    return ((LicenseManagementServiceStubSettings) getStubSettings()).unassignSettings();
  }

  /** Returns the object with the settings used for calls to enumerateLicensedUsers. */
  public PagedCallSettings<
          EnumerateLicensedUsersRequest,
          EnumerateLicensedUsersResponse,
          EnumerateLicensedUsersPagedResponse>
      enumerateLicensedUsersSettings() {
    return ((LicenseManagementServiceStubSettings) getStubSettings())
        .enumerateLicensedUsersSettings();
  }

  public static final LicenseManagementServiceSettings create(
      LicenseManagementServiceStubSettings stub) throws IOException {
    return new LicenseManagementServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return LicenseManagementServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return LicenseManagementServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return LicenseManagementServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return LicenseManagementServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return LicenseManagementServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return LicenseManagementServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return LicenseManagementServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return LicenseManagementServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected LicenseManagementServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for LicenseManagementServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<LicenseManagementServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(LicenseManagementServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(LicenseManagementServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(LicenseManagementServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(LicenseManagementServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(LicenseManagementServiceStubSettings.newHttpJsonBuilder());
    }

    public LicenseManagementServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((LicenseManagementServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getLicensePool. */
    public UnaryCallSettings.Builder<GetLicensePoolRequest, LicensePool> getLicensePoolSettings() {
      return getStubSettingsBuilder().getLicensePoolSettings();
    }

    /** Returns the builder for the settings used for calls to updateLicensePool. */
    public UnaryCallSettings.Builder<UpdateLicensePoolRequest, LicensePool>
        updateLicensePoolSettings() {
      return getStubSettingsBuilder().updateLicensePoolSettings();
    }

    /** Returns the builder for the settings used for calls to assign. */
    public UnaryCallSettings.Builder<AssignRequest, AssignResponse> assignSettings() {
      return getStubSettingsBuilder().assignSettings();
    }

    /** Returns the builder for the settings used for calls to unassign. */
    public UnaryCallSettings.Builder<UnassignRequest, UnassignResponse> unassignSettings() {
      return getStubSettingsBuilder().unassignSettings();
    }

    /** Returns the builder for the settings used for calls to enumerateLicensedUsers. */
    public PagedCallSettings.Builder<
            EnumerateLicensedUsersRequest,
            EnumerateLicensedUsersResponse,
            EnumerateLicensedUsersPagedResponse>
        enumerateLicensedUsersSettings() {
      return getStubSettingsBuilder().enumerateLicensedUsersSettings();
    }

    @Override
    public LicenseManagementServiceSettings build() throws IOException {
      return new LicenseManagementServiceSettings(this);
    }
  }
}
