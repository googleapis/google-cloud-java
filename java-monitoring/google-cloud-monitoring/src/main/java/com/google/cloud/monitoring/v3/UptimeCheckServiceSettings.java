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

package com.google.cloud.monitoring.v3;

import static com.google.cloud.monitoring.v3.UptimeCheckServiceClient.ListUptimeCheckConfigsPagedResponse;
import static com.google.cloud.monitoring.v3.UptimeCheckServiceClient.ListUptimeCheckIpsPagedResponse;

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
import com.google.cloud.monitoring.v3.stub.UptimeCheckServiceStubSettings;
import com.google.monitoring.v3.CreateUptimeCheckConfigRequest;
import com.google.monitoring.v3.DeleteUptimeCheckConfigRequest;
import com.google.monitoring.v3.GetUptimeCheckConfigRequest;
import com.google.monitoring.v3.ListUptimeCheckConfigsRequest;
import com.google.monitoring.v3.ListUptimeCheckConfigsResponse;
import com.google.monitoring.v3.ListUptimeCheckIpsRequest;
import com.google.monitoring.v3.ListUptimeCheckIpsResponse;
import com.google.monitoring.v3.UpdateUptimeCheckConfigRequest;
import com.google.monitoring.v3.UptimeCheckConfig;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link UptimeCheckServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (monitoring.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getUptimeCheckConfig to 30 seconds:
 *
 * <pre>{@code
 * UptimeCheckServiceSettings.Builder uptimeCheckServiceSettingsBuilder =
 *     UptimeCheckServiceSettings.newBuilder();
 * uptimeCheckServiceSettingsBuilder
 *     .getUptimeCheckConfigSettings()
 *     .setRetrySettings(
 *         uptimeCheckServiceSettingsBuilder
 *             .getUptimeCheckConfigSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * UptimeCheckServiceSettings uptimeCheckServiceSettings =
 *     uptimeCheckServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class UptimeCheckServiceSettings extends ClientSettings<UptimeCheckServiceSettings> {

  /** Returns the object with the settings used for calls to listUptimeCheckConfigs. */
  public PagedCallSettings<
          ListUptimeCheckConfigsRequest,
          ListUptimeCheckConfigsResponse,
          ListUptimeCheckConfigsPagedResponse>
      listUptimeCheckConfigsSettings() {
    return ((UptimeCheckServiceStubSettings) getStubSettings()).listUptimeCheckConfigsSettings();
  }

  /** Returns the object with the settings used for calls to getUptimeCheckConfig. */
  public UnaryCallSettings<GetUptimeCheckConfigRequest, UptimeCheckConfig>
      getUptimeCheckConfigSettings() {
    return ((UptimeCheckServiceStubSettings) getStubSettings()).getUptimeCheckConfigSettings();
  }

  /** Returns the object with the settings used for calls to createUptimeCheckConfig. */
  public UnaryCallSettings<CreateUptimeCheckConfigRequest, UptimeCheckConfig>
      createUptimeCheckConfigSettings() {
    return ((UptimeCheckServiceStubSettings) getStubSettings()).createUptimeCheckConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateUptimeCheckConfig. */
  public UnaryCallSettings<UpdateUptimeCheckConfigRequest, UptimeCheckConfig>
      updateUptimeCheckConfigSettings() {
    return ((UptimeCheckServiceStubSettings) getStubSettings()).updateUptimeCheckConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteUptimeCheckConfig. */
  public UnaryCallSettings<DeleteUptimeCheckConfigRequest, Empty>
      deleteUptimeCheckConfigSettings() {
    return ((UptimeCheckServiceStubSettings) getStubSettings()).deleteUptimeCheckConfigSettings();
  }

  /** Returns the object with the settings used for calls to listUptimeCheckIps. */
  public PagedCallSettings<
          ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse, ListUptimeCheckIpsPagedResponse>
      listUptimeCheckIpsSettings() {
    return ((UptimeCheckServiceStubSettings) getStubSettings()).listUptimeCheckIpsSettings();
  }

  public static final UptimeCheckServiceSettings create(UptimeCheckServiceStubSettings stub)
      throws IOException {
    return new UptimeCheckServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return UptimeCheckServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return UptimeCheckServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return UptimeCheckServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return UptimeCheckServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return UptimeCheckServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return UptimeCheckServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return UptimeCheckServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected UptimeCheckServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for UptimeCheckServiceSettings. */
  public static class Builder extends ClientSettings.Builder<UptimeCheckServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(UptimeCheckServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(UptimeCheckServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(UptimeCheckServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(UptimeCheckServiceStubSettings.newBuilder());
    }

    public UptimeCheckServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((UptimeCheckServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listUptimeCheckConfigs. */
    public PagedCallSettings.Builder<
            ListUptimeCheckConfigsRequest,
            ListUptimeCheckConfigsResponse,
            ListUptimeCheckConfigsPagedResponse>
        listUptimeCheckConfigsSettings() {
      return getStubSettingsBuilder().listUptimeCheckConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to getUptimeCheckConfig. */
    public UnaryCallSettings.Builder<GetUptimeCheckConfigRequest, UptimeCheckConfig>
        getUptimeCheckConfigSettings() {
      return getStubSettingsBuilder().getUptimeCheckConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createUptimeCheckConfig. */
    public UnaryCallSettings.Builder<CreateUptimeCheckConfigRequest, UptimeCheckConfig>
        createUptimeCheckConfigSettings() {
      return getStubSettingsBuilder().createUptimeCheckConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateUptimeCheckConfig. */
    public UnaryCallSettings.Builder<UpdateUptimeCheckConfigRequest, UptimeCheckConfig>
        updateUptimeCheckConfigSettings() {
      return getStubSettingsBuilder().updateUptimeCheckConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteUptimeCheckConfig. */
    public UnaryCallSettings.Builder<DeleteUptimeCheckConfigRequest, Empty>
        deleteUptimeCheckConfigSettings() {
      return getStubSettingsBuilder().deleteUptimeCheckConfigSettings();
    }

    /** Returns the builder for the settings used for calls to listUptimeCheckIps. */
    public PagedCallSettings.Builder<
            ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse, ListUptimeCheckIpsPagedResponse>
        listUptimeCheckIpsSettings() {
      return getStubSettingsBuilder().listUptimeCheckIpsSettings();
    }

    @Override
    public UptimeCheckServiceSettings build() throws IOException {
      return new UptimeCheckServiceSettings(this);
    }
  }
}
