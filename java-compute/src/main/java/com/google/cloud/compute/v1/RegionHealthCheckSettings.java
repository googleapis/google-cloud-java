/*
 * Copyright 2019 Google LLC
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

import static com.google.cloud.compute.v1.RegionHealthCheckClient.ListRegionHealthChecksPagedResponse;

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
import com.google.cloud.compute.v1.stub.RegionHealthCheckStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link RegionHealthCheckClient}.
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
 * <p>For example, to set the total timeout of deleteRegionHealthCheck to 30 seconds:
 *
 * <pre>
 * <code>
 * RegionHealthCheckSettings.Builder regionHealthCheckSettingsBuilder =
 *     RegionHealthCheckSettings.newBuilder();
 * regionHealthCheckSettingsBuilder.deleteRegionHealthCheckSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * RegionHealthCheckSettings regionHealthCheckSettings = regionHealthCheckSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionHealthCheckSettings extends ClientSettings<RegionHealthCheckSettings> {
  /** Returns the object with the settings used for calls to deleteRegionHealthCheck. */
  public UnaryCallSettings<DeleteRegionHealthCheckHttpRequest, Operation>
      deleteRegionHealthCheckSettings() {
    return ((RegionHealthCheckStubSettings) getStubSettings()).deleteRegionHealthCheckSettings();
  }

  /** Returns the object with the settings used for calls to getRegionHealthCheck. */
  public UnaryCallSettings<GetRegionHealthCheckHttpRequest, HealthCheck>
      getRegionHealthCheckSettings() {
    return ((RegionHealthCheckStubSettings) getStubSettings()).getRegionHealthCheckSettings();
  }

  /** Returns the object with the settings used for calls to insertRegionHealthCheck. */
  public UnaryCallSettings<InsertRegionHealthCheckHttpRequest, Operation>
      insertRegionHealthCheckSettings() {
    return ((RegionHealthCheckStubSettings) getStubSettings()).insertRegionHealthCheckSettings();
  }

  /** Returns the object with the settings used for calls to listRegionHealthChecks. */
  public PagedCallSettings<
          ListRegionHealthChecksHttpRequest, HealthCheckList, ListRegionHealthChecksPagedResponse>
      listRegionHealthChecksSettings() {
    return ((RegionHealthCheckStubSettings) getStubSettings()).listRegionHealthChecksSettings();
  }

  /** Returns the object with the settings used for calls to patchRegionHealthCheck. */
  public UnaryCallSettings<PatchRegionHealthCheckHttpRequest, Operation>
      patchRegionHealthCheckSettings() {
    return ((RegionHealthCheckStubSettings) getStubSettings()).patchRegionHealthCheckSettings();
  }

  /** Returns the object with the settings used for calls to updateRegionHealthCheck. */
  public UnaryCallSettings<UpdateRegionHealthCheckHttpRequest, Operation>
      updateRegionHealthCheckSettings() {
    return ((RegionHealthCheckStubSettings) getStubSettings()).updateRegionHealthCheckSettings();
  }

  public static final RegionHealthCheckSettings create(RegionHealthCheckStubSettings stub)
      throws IOException {
    return new RegionHealthCheckSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RegionHealthCheckStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RegionHealthCheckStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return RegionHealthCheckStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RegionHealthCheckStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RegionHealthCheckStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RegionHealthCheckStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RegionHealthCheckStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RegionHealthCheckStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RegionHealthCheckSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RegionHealthCheckSettings. */
  public static class Builder extends ClientSettings.Builder<RegionHealthCheckSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(RegionHealthCheckStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(RegionHealthCheckStubSettings.newBuilder());
    }

    protected Builder(RegionHealthCheckSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RegionHealthCheckStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public RegionHealthCheckStubSettings.Builder getStubSettingsBuilder() {
      return ((RegionHealthCheckStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to deleteRegionHealthCheck. */
    public UnaryCallSettings.Builder<DeleteRegionHealthCheckHttpRequest, Operation>
        deleteRegionHealthCheckSettings() {
      return getStubSettingsBuilder().deleteRegionHealthCheckSettings();
    }

    /** Returns the builder for the settings used for calls to getRegionHealthCheck. */
    public UnaryCallSettings.Builder<GetRegionHealthCheckHttpRequest, HealthCheck>
        getRegionHealthCheckSettings() {
      return getStubSettingsBuilder().getRegionHealthCheckSettings();
    }

    /** Returns the builder for the settings used for calls to insertRegionHealthCheck. */
    public UnaryCallSettings.Builder<InsertRegionHealthCheckHttpRequest, Operation>
        insertRegionHealthCheckSettings() {
      return getStubSettingsBuilder().insertRegionHealthCheckSettings();
    }

    /** Returns the builder for the settings used for calls to listRegionHealthChecks. */
    public PagedCallSettings.Builder<
            ListRegionHealthChecksHttpRequest, HealthCheckList, ListRegionHealthChecksPagedResponse>
        listRegionHealthChecksSettings() {
      return getStubSettingsBuilder().listRegionHealthChecksSettings();
    }

    /** Returns the builder for the settings used for calls to patchRegionHealthCheck. */
    public UnaryCallSettings.Builder<PatchRegionHealthCheckHttpRequest, Operation>
        patchRegionHealthCheckSettings() {
      return getStubSettingsBuilder().patchRegionHealthCheckSettings();
    }

    /** Returns the builder for the settings used for calls to updateRegionHealthCheck. */
    public UnaryCallSettings.Builder<UpdateRegionHealthCheckHttpRequest, Operation>
        updateRegionHealthCheckSettings() {
      return getStubSettingsBuilder().updateRegionHealthCheckSettings();
    }

    @Override
    public RegionHealthCheckSettings build() throws IOException {
      return new RegionHealthCheckSettings(this);
    }
  }
}
