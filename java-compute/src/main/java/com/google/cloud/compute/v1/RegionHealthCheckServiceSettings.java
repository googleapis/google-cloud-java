/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.RegionHealthCheckServiceClient.ListRegionHealthCheckServicesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.RegionHealthCheckServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link RegionHealthCheckServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://compute.googleapis.com/compute/v1/projects/) and
 *       default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of deleteRegionHealthCheckService to 30 seconds:
 *
 * <pre>
 * <code>
 * RegionHealthCheckServiceSettings.Builder regionHealthCheckServiceSettingsBuilder =
 *     RegionHealthCheckServiceSettings.newBuilder();
 * regionHealthCheckServiceSettingsBuilder
 *     .deleteRegionHealthCheckServiceSettings()
 *     .setRetrySettings(
 *         regionHealthCheckServiceSettingsBuilder.deleteRegionHealthCheckServiceSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RegionHealthCheckServiceSettings regionHealthCheckServiceSettings = regionHealthCheckServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionHealthCheckServiceSettings
    extends ClientSettings<RegionHealthCheckServiceSettings> {
  /** Returns the object with the settings used for calls to deleteRegionHealthCheckService. */
  public UnaryCallSettings<DeleteRegionHealthCheckServiceHttpRequest, Operation>
      deleteRegionHealthCheckServiceSettings() {
    return ((RegionHealthCheckServiceStubSettings) getStubSettings())
        .deleteRegionHealthCheckServiceSettings();
  }

  /** Returns the object with the settings used for calls to getRegionHealthCheckService. */
  public UnaryCallSettings<GetRegionHealthCheckServiceHttpRequest, HealthCheckService>
      getRegionHealthCheckServiceSettings() {
    return ((RegionHealthCheckServiceStubSettings) getStubSettings())
        .getRegionHealthCheckServiceSettings();
  }

  /** Returns the object with the settings used for calls to insertRegionHealthCheckService. */
  public UnaryCallSettings<InsertRegionHealthCheckServiceHttpRequest, Operation>
      insertRegionHealthCheckServiceSettings() {
    return ((RegionHealthCheckServiceStubSettings) getStubSettings())
        .insertRegionHealthCheckServiceSettings();
  }

  /** Returns the object with the settings used for calls to listRegionHealthCheckServices. */
  public PagedCallSettings<
          ListRegionHealthCheckServicesHttpRequest,
          HealthCheckServicesList,
          ListRegionHealthCheckServicesPagedResponse>
      listRegionHealthCheckServicesSettings() {
    return ((RegionHealthCheckServiceStubSettings) getStubSettings())
        .listRegionHealthCheckServicesSettings();
  }

  /** Returns the object with the settings used for calls to patchRegionHealthCheckService. */
  public UnaryCallSettings<PatchRegionHealthCheckServiceHttpRequest, Operation>
      patchRegionHealthCheckServiceSettings() {
    return ((RegionHealthCheckServiceStubSettings) getStubSettings())
        .patchRegionHealthCheckServiceSettings();
  }

  public static final RegionHealthCheckServiceSettings create(
      RegionHealthCheckServiceStubSettings stub) throws IOException {
    return new RegionHealthCheckServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RegionHealthCheckServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RegionHealthCheckServiceStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return RegionHealthCheckServiceStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RegionHealthCheckServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RegionHealthCheckServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RegionHealthCheckServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RegionHealthCheckServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RegionHealthCheckServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RegionHealthCheckServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RegionHealthCheckServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<RegionHealthCheckServiceSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(RegionHealthCheckServiceStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(RegionHealthCheckServiceStubSettings.newBuilder());
    }

    protected Builder(RegionHealthCheckServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RegionHealthCheckServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public RegionHealthCheckServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((RegionHealthCheckServiceStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
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

    /** Returns the builder for the settings used for calls to deleteRegionHealthCheckService. */
    public UnaryCallSettings.Builder<DeleteRegionHealthCheckServiceHttpRequest, Operation>
        deleteRegionHealthCheckServiceSettings() {
      return getStubSettingsBuilder().deleteRegionHealthCheckServiceSettings();
    }

    /** Returns the builder for the settings used for calls to getRegionHealthCheckService. */
    public UnaryCallSettings.Builder<GetRegionHealthCheckServiceHttpRequest, HealthCheckService>
        getRegionHealthCheckServiceSettings() {
      return getStubSettingsBuilder().getRegionHealthCheckServiceSettings();
    }

    /** Returns the builder for the settings used for calls to insertRegionHealthCheckService. */
    public UnaryCallSettings.Builder<InsertRegionHealthCheckServiceHttpRequest, Operation>
        insertRegionHealthCheckServiceSettings() {
      return getStubSettingsBuilder().insertRegionHealthCheckServiceSettings();
    }

    /** Returns the builder for the settings used for calls to listRegionHealthCheckServices. */
    public PagedCallSettings.Builder<
            ListRegionHealthCheckServicesHttpRequest,
            HealthCheckServicesList,
            ListRegionHealthCheckServicesPagedResponse>
        listRegionHealthCheckServicesSettings() {
      return getStubSettingsBuilder().listRegionHealthCheckServicesSettings();
    }

    /** Returns the builder for the settings used for calls to patchRegionHealthCheckService. */
    public UnaryCallSettings.Builder<PatchRegionHealthCheckServiceHttpRequest, Operation>
        patchRegionHealthCheckServiceSettings() {
      return getStubSettingsBuilder().patchRegionHealthCheckServiceSettings();
    }

    @Override
    public RegionHealthCheckServiceSettings build() throws IOException {
      return new RegionHealthCheckServiceSettings(this);
    }
  }
}
