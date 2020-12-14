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

package com.google.cloud.securitycenter.settings.v1beta1;

import static com.google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsServiceClient.ListComponentsPagedResponse;
import static com.google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsServiceClient.ListDetectorsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.securitycenter.settings.v1beta1.stub.SecurityCenterSettingsServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SecurityCenterSettingsServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (securitycenter.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getServiceAccount to 30 seconds:
 *
 * <pre>{@code
 * SecurityCenterSettingsServiceSettings.Builder securityCenterSettingsServiceSettingsBuilder =
 *     SecurityCenterSettingsServiceSettings.newBuilder();
 * securityCenterSettingsServiceSettingsBuilder
 *     .getServiceAccountSettings()
 *     .setRetrySettings(
 *         securityCenterSettingsServiceSettingsBuilder
 *             .getServiceAccountSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SecurityCenterSettingsServiceSettings securityCenterSettingsServiceSettings =
 *     securityCenterSettingsServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SecurityCenterSettingsServiceSettings
    extends ClientSettings<SecurityCenterSettingsServiceSettings> {

  /** Returns the object with the settings used for calls to getServiceAccount. */
  public UnaryCallSettings<GetServiceAccountRequest, ServiceAccount> getServiceAccountSettings() {
    return ((SecurityCenterSettingsServiceStubSettings) getStubSettings())
        .getServiceAccountSettings();
  }

  /** Returns the object with the settings used for calls to getSettings. */
  public UnaryCallSettings<GetSettingsRequest, Settings> getSettingsSettings() {
    return ((SecurityCenterSettingsServiceStubSettings) getStubSettings()).getSettingsSettings();
  }

  /** Returns the object with the settings used for calls to updateSettings. */
  public UnaryCallSettings<UpdateSettingsRequest, Settings> updateSettingsSettings() {
    return ((SecurityCenterSettingsServiceStubSettings) getStubSettings()).updateSettingsSettings();
  }

  /** Returns the object with the settings used for calls to resetSettings. */
  public UnaryCallSettings<ResetSettingsRequest, Empty> resetSettingsSettings() {
    return ((SecurityCenterSettingsServiceStubSettings) getStubSettings()).resetSettingsSettings();
  }

  /** Returns the object with the settings used for calls to batchGetSettings. */
  public UnaryCallSettings<BatchGetSettingsRequest, BatchGetSettingsResponse>
      batchGetSettingsSettings() {
    return ((SecurityCenterSettingsServiceStubSettings) getStubSettings())
        .batchGetSettingsSettings();
  }

  /** Returns the object with the settings used for calls to calculateEffectiveSettings. */
  public UnaryCallSettings<CalculateEffectiveSettingsRequest, Settings>
      calculateEffectiveSettingsSettings() {
    return ((SecurityCenterSettingsServiceStubSettings) getStubSettings())
        .calculateEffectiveSettingsSettings();
  }

  /** Returns the object with the settings used for calls to batchCalculateEffectiveSettings. */
  public UnaryCallSettings<
          BatchCalculateEffectiveSettingsRequest, BatchCalculateEffectiveSettingsResponse>
      batchCalculateEffectiveSettingsSettings() {
    return ((SecurityCenterSettingsServiceStubSettings) getStubSettings())
        .batchCalculateEffectiveSettingsSettings();
  }

  /** Returns the object with the settings used for calls to getComponentSettings. */
  public UnaryCallSettings<GetComponentSettingsRequest, ComponentSettings>
      getComponentSettingsSettings() {
    return ((SecurityCenterSettingsServiceStubSettings) getStubSettings())
        .getComponentSettingsSettings();
  }

  /** Returns the object with the settings used for calls to updateComponentSettings. */
  public UnaryCallSettings<UpdateComponentSettingsRequest, ComponentSettings>
      updateComponentSettingsSettings() {
    return ((SecurityCenterSettingsServiceStubSettings) getStubSettings())
        .updateComponentSettingsSettings();
  }

  /** Returns the object with the settings used for calls to resetComponentSettings. */
  public UnaryCallSettings<ResetComponentSettingsRequest, Empty> resetComponentSettingsSettings() {
    return ((SecurityCenterSettingsServiceStubSettings) getStubSettings())
        .resetComponentSettingsSettings();
  }

  /** Returns the object with the settings used for calls to calculateEffectiveComponentSettings. */
  public UnaryCallSettings<CalculateEffectiveComponentSettingsRequest, ComponentSettings>
      calculateEffectiveComponentSettingsSettings() {
    return ((SecurityCenterSettingsServiceStubSettings) getStubSettings())
        .calculateEffectiveComponentSettingsSettings();
  }

  /** Returns the object with the settings used for calls to listDetectors. */
  public PagedCallSettings<ListDetectorsRequest, ListDetectorsResponse, ListDetectorsPagedResponse>
      listDetectorsSettings() {
    return ((SecurityCenterSettingsServiceStubSettings) getStubSettings()).listDetectorsSettings();
  }

  /** Returns the object with the settings used for calls to listComponents. */
  public PagedCallSettings<
          ListComponentsRequest, ListComponentsResponse, ListComponentsPagedResponse>
      listComponentsSettings() {
    return ((SecurityCenterSettingsServiceStubSettings) getStubSettings()).listComponentsSettings();
  }

  public static final SecurityCenterSettingsServiceSettings create(
      SecurityCenterSettingsServiceStubSettings stub) throws IOException {
    return new SecurityCenterSettingsServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SecurityCenterSettingsServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SecurityCenterSettingsServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SecurityCenterSettingsServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SecurityCenterSettingsServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SecurityCenterSettingsServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SecurityCenterSettingsServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SecurityCenterSettingsServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SecurityCenterSettingsServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SecurityCenterSettingsServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<SecurityCenterSettingsServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(SecurityCenterSettingsServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(SecurityCenterSettingsServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SecurityCenterSettingsServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SecurityCenterSettingsServiceStubSettings.newBuilder());
    }

    public SecurityCenterSettingsServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((SecurityCenterSettingsServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getServiceAccount. */
    public UnaryCallSettings.Builder<GetServiceAccountRequest, ServiceAccount>
        getServiceAccountSettings() {
      return getStubSettingsBuilder().getServiceAccountSettings();
    }

    /** Returns the builder for the settings used for calls to getSettings. */
    public UnaryCallSettings.Builder<GetSettingsRequest, Settings> getSettingsSettings() {
      return getStubSettingsBuilder().getSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to updateSettings. */
    public UnaryCallSettings.Builder<UpdateSettingsRequest, Settings> updateSettingsSettings() {
      return getStubSettingsBuilder().updateSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to resetSettings. */
    public UnaryCallSettings.Builder<ResetSettingsRequest, Empty> resetSettingsSettings() {
      return getStubSettingsBuilder().resetSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to batchGetSettings. */
    public UnaryCallSettings.Builder<BatchGetSettingsRequest, BatchGetSettingsResponse>
        batchGetSettingsSettings() {
      return getStubSettingsBuilder().batchGetSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to calculateEffectiveSettings. */
    public UnaryCallSettings.Builder<CalculateEffectiveSettingsRequest, Settings>
        calculateEffectiveSettingsSettings() {
      return getStubSettingsBuilder().calculateEffectiveSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to batchCalculateEffectiveSettings. */
    public UnaryCallSettings.Builder<
            BatchCalculateEffectiveSettingsRequest, BatchCalculateEffectiveSettingsResponse>
        batchCalculateEffectiveSettingsSettings() {
      return getStubSettingsBuilder().batchCalculateEffectiveSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to getComponentSettings. */
    public UnaryCallSettings.Builder<GetComponentSettingsRequest, ComponentSettings>
        getComponentSettingsSettings() {
      return getStubSettingsBuilder().getComponentSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to updateComponentSettings. */
    public UnaryCallSettings.Builder<UpdateComponentSettingsRequest, ComponentSettings>
        updateComponentSettingsSettings() {
      return getStubSettingsBuilder().updateComponentSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to resetComponentSettings. */
    public UnaryCallSettings.Builder<ResetComponentSettingsRequest, Empty>
        resetComponentSettingsSettings() {
      return getStubSettingsBuilder().resetComponentSettingsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to calculateEffectiveComponentSettings.
     */
    public UnaryCallSettings.Builder<CalculateEffectiveComponentSettingsRequest, ComponentSettings>
        calculateEffectiveComponentSettingsSettings() {
      return getStubSettingsBuilder().calculateEffectiveComponentSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to listDetectors. */
    public PagedCallSettings.Builder<
            ListDetectorsRequest, ListDetectorsResponse, ListDetectorsPagedResponse>
        listDetectorsSettings() {
      return getStubSettingsBuilder().listDetectorsSettings();
    }

    /** Returns the builder for the settings used for calls to listComponents. */
    public PagedCallSettings.Builder<
            ListComponentsRequest, ListComponentsResponse, ListComponentsPagedResponse>
        listComponentsSettings() {
      return getStubSettingsBuilder().listComponentsSettings();
    }

    @Override
    public SecurityCenterSettingsServiceSettings build() throws IOException {
      return new SecurityCenterSettingsServiceSettings(this);
    }
  }
}
