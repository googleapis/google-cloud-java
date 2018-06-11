/*
 * Copyright 2018 Google LLC
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

import static com.google.cloud.compute.v1.RegionAutoscalerClient.ListRegionAutoscalersPagedResponse;

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
import com.google.cloud.compute.v1.stub.RegionAutoscalerStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link RegionAutoscalerClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://www.googleapis.com/compute/v1/projects/) and default
 *       port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of deleteRegionAutoscaler to 30 seconds:
 *
 * <pre>
 * <code>
 * RegionAutoscalerSettings.Builder regionAutoscalerSettingsBuilder =
 *     RegionAutoscalerSettings.newBuilder();
 * regionAutoscalerSettingsBuilder.deleteRegionAutoscalerSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * RegionAutoscalerSettings regionAutoscalerSettings = regionAutoscalerSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionAutoscalerSettings extends ClientSettings<RegionAutoscalerSettings> {
  /** Returns the object with the settings used for calls to deleteRegionAutoscaler. */
  public UnaryCallSettings<DeleteRegionAutoscalerHttpRequest, Operation>
      deleteRegionAutoscalerSettings() {
    return ((RegionAutoscalerStubSettings) getStubSettings()).deleteRegionAutoscalerSettings();
  }

  /** Returns the object with the settings used for calls to getRegionAutoscaler. */
  public UnaryCallSettings<GetRegionAutoscalerHttpRequest, Autoscaler>
      getRegionAutoscalerSettings() {
    return ((RegionAutoscalerStubSettings) getStubSettings()).getRegionAutoscalerSettings();
  }

  /** Returns the object with the settings used for calls to insertRegionAutoscaler. */
  public UnaryCallSettings<InsertRegionAutoscalerHttpRequest, Operation>
      insertRegionAutoscalerSettings() {
    return ((RegionAutoscalerStubSettings) getStubSettings()).insertRegionAutoscalerSettings();
  }

  /** Returns the object with the settings used for calls to listRegionAutoscalers. */
  public PagedCallSettings<
          ListRegionAutoscalersHttpRequest, RegionAutoscalerList,
          ListRegionAutoscalersPagedResponse>
      listRegionAutoscalersSettings() {
    return ((RegionAutoscalerStubSettings) getStubSettings()).listRegionAutoscalersSettings();
  }

  /** Returns the object with the settings used for calls to patchRegionAutoscaler. */
  public UnaryCallSettings<PatchRegionAutoscalerHttpRequest, Operation>
      patchRegionAutoscalerSettings() {
    return ((RegionAutoscalerStubSettings) getStubSettings()).patchRegionAutoscalerSettings();
  }

  /** Returns the object with the settings used for calls to updateRegionAutoscaler. */
  public UnaryCallSettings<UpdateRegionAutoscalerHttpRequest, Operation>
      updateRegionAutoscalerSettings() {
    return ((RegionAutoscalerStubSettings) getStubSettings()).updateRegionAutoscalerSettings();
  }

  public static final RegionAutoscalerSettings create(RegionAutoscalerStubSettings stub)
      throws IOException {
    return new RegionAutoscalerSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RegionAutoscalerStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RegionAutoscalerStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return RegionAutoscalerStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RegionAutoscalerStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RegionAutoscalerStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RegionAutoscalerStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RegionAutoscalerStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RegionAutoscalerStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RegionAutoscalerSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RegionAutoscalerSettings. */
  public static class Builder extends ClientSettings.Builder<RegionAutoscalerSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(RegionAutoscalerStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(RegionAutoscalerStubSettings.newBuilder());
    }

    protected Builder(RegionAutoscalerSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RegionAutoscalerStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public RegionAutoscalerStubSettings.Builder getStubSettingsBuilder() {
      return ((RegionAutoscalerStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to deleteRegionAutoscaler. */
    public UnaryCallSettings.Builder<DeleteRegionAutoscalerHttpRequest, Operation>
        deleteRegionAutoscalerSettings() {
      return getStubSettingsBuilder().deleteRegionAutoscalerSettings();
    }

    /** Returns the builder for the settings used for calls to getRegionAutoscaler. */
    public UnaryCallSettings.Builder<GetRegionAutoscalerHttpRequest, Autoscaler>
        getRegionAutoscalerSettings() {
      return getStubSettingsBuilder().getRegionAutoscalerSettings();
    }

    /** Returns the builder for the settings used for calls to insertRegionAutoscaler. */
    public UnaryCallSettings.Builder<InsertRegionAutoscalerHttpRequest, Operation>
        insertRegionAutoscalerSettings() {
      return getStubSettingsBuilder().insertRegionAutoscalerSettings();
    }

    /** Returns the builder for the settings used for calls to listRegionAutoscalers. */
    public PagedCallSettings.Builder<
            ListRegionAutoscalersHttpRequest, RegionAutoscalerList,
            ListRegionAutoscalersPagedResponse>
        listRegionAutoscalersSettings() {
      return getStubSettingsBuilder().listRegionAutoscalersSettings();
    }

    /** Returns the builder for the settings used for calls to patchRegionAutoscaler. */
    public UnaryCallSettings.Builder<PatchRegionAutoscalerHttpRequest, Operation>
        patchRegionAutoscalerSettings() {
      return getStubSettingsBuilder().patchRegionAutoscalerSettings();
    }

    /** Returns the builder for the settings used for calls to updateRegionAutoscaler. */
    public UnaryCallSettings.Builder<UpdateRegionAutoscalerHttpRequest, Operation>
        updateRegionAutoscalerSettings() {
      return getStubSettingsBuilder().updateRegionAutoscalerSettings();
    }

    @Override
    public RegionAutoscalerSettings build() throws IOException {
      return new RegionAutoscalerSettings(this);
    }
  }
}
