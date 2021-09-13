/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.osconfig.v1;

import static com.google.cloud.osconfig.v1.OsConfigZonalServiceClient.ListInventoriesPagedResponse;
import static com.google.cloud.osconfig.v1.OsConfigZonalServiceClient.ListVulnerabilityReportsPagedResponse;

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
import com.google.cloud.osconfig.v1.stub.OsConfigZonalServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link OsConfigZonalServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (osconfig.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getInventory to 30 seconds:
 *
 * <pre>{@code
 * OsConfigZonalServiceSettings.Builder osConfigZonalServiceSettingsBuilder =
 *     OsConfigZonalServiceSettings.newBuilder();
 * osConfigZonalServiceSettingsBuilder
 *     .getInventorySettings()
 *     .setRetrySettings(
 *         osConfigZonalServiceSettingsBuilder
 *             .getInventorySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * OsConfigZonalServiceSettings osConfigZonalServiceSettings =
 *     osConfigZonalServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class OsConfigZonalServiceSettings extends ClientSettings<OsConfigZonalServiceSettings> {

  /** Returns the object with the settings used for calls to getInventory. */
  public UnaryCallSettings<GetInventoryRequest, Inventory> getInventorySettings() {
    return ((OsConfigZonalServiceStubSettings) getStubSettings()).getInventorySettings();
  }

  /** Returns the object with the settings used for calls to listInventories. */
  public PagedCallSettings<
          ListInventoriesRequest, ListInventoriesResponse, ListInventoriesPagedResponse>
      listInventoriesSettings() {
    return ((OsConfigZonalServiceStubSettings) getStubSettings()).listInventoriesSettings();
  }

  /** Returns the object with the settings used for calls to getVulnerabilityReport. */
  public UnaryCallSettings<GetVulnerabilityReportRequest, VulnerabilityReport>
      getVulnerabilityReportSettings() {
    return ((OsConfigZonalServiceStubSettings) getStubSettings()).getVulnerabilityReportSettings();
  }

  /** Returns the object with the settings used for calls to listVulnerabilityReports. */
  public PagedCallSettings<
          ListVulnerabilityReportsRequest,
          ListVulnerabilityReportsResponse,
          ListVulnerabilityReportsPagedResponse>
      listVulnerabilityReportsSettings() {
    return ((OsConfigZonalServiceStubSettings) getStubSettings())
        .listVulnerabilityReportsSettings();
  }

  public static final OsConfigZonalServiceSettings create(OsConfigZonalServiceStubSettings stub)
      throws IOException {
    return new OsConfigZonalServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return OsConfigZonalServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return OsConfigZonalServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return OsConfigZonalServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return OsConfigZonalServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return OsConfigZonalServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return OsConfigZonalServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return OsConfigZonalServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected OsConfigZonalServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for OsConfigZonalServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<OsConfigZonalServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(OsConfigZonalServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(OsConfigZonalServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(OsConfigZonalServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(OsConfigZonalServiceStubSettings.newBuilder());
    }

    public OsConfigZonalServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((OsConfigZonalServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getInventory. */
    public UnaryCallSettings.Builder<GetInventoryRequest, Inventory> getInventorySettings() {
      return getStubSettingsBuilder().getInventorySettings();
    }

    /** Returns the builder for the settings used for calls to listInventories. */
    public PagedCallSettings.Builder<
            ListInventoriesRequest, ListInventoriesResponse, ListInventoriesPagedResponse>
        listInventoriesSettings() {
      return getStubSettingsBuilder().listInventoriesSettings();
    }

    /** Returns the builder for the settings used for calls to getVulnerabilityReport. */
    public UnaryCallSettings.Builder<GetVulnerabilityReportRequest, VulnerabilityReport>
        getVulnerabilityReportSettings() {
      return getStubSettingsBuilder().getVulnerabilityReportSettings();
    }

    /** Returns the builder for the settings used for calls to listVulnerabilityReports. */
    public PagedCallSettings.Builder<
            ListVulnerabilityReportsRequest,
            ListVulnerabilityReportsResponse,
            ListVulnerabilityReportsPagedResponse>
        listVulnerabilityReportsSettings() {
      return getStubSettingsBuilder().listVulnerabilityReportsSettings();
    }

    @Override
    public OsConfigZonalServiceSettings build() throws IOException {
      return new OsConfigZonalServiceSettings(this);
    }
  }
}
