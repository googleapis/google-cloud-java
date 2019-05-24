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

import static com.google.cloud.compute.v1.RegionBackendServiceClient.ListRegionBackendServicesPagedResponse;

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
import com.google.cloud.compute.v1.stub.RegionBackendServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link RegionBackendServiceClient}.
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
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of deleteRegionBackendService to 30 seconds:
 *
 * <pre>
 * <code>
 * RegionBackendServiceSettings.Builder regionBackendServiceSettingsBuilder =
 *     RegionBackendServiceSettings.newBuilder();
 * regionBackendServiceSettingsBuilder.deleteRegionBackendServiceSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * RegionBackendServiceSettings regionBackendServiceSettings = regionBackendServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionBackendServiceSettings extends ClientSettings<RegionBackendServiceSettings> {
  /** Returns the object with the settings used for calls to deleteRegionBackendService. */
  public UnaryCallSettings<DeleteRegionBackendServiceHttpRequest, Operation>
      deleteRegionBackendServiceSettings() {
    return ((RegionBackendServiceStubSettings) getStubSettings())
        .deleteRegionBackendServiceSettings();
  }

  /** Returns the object with the settings used for calls to getRegionBackendService. */
  public UnaryCallSettings<GetRegionBackendServiceHttpRequest, BackendService>
      getRegionBackendServiceSettings() {
    return ((RegionBackendServiceStubSettings) getStubSettings()).getRegionBackendServiceSettings();
  }

  /** Returns the object with the settings used for calls to getHealthRegionBackendService. */
  public UnaryCallSettings<GetHealthRegionBackendServiceHttpRequest, BackendServiceGroupHealth>
      getHealthRegionBackendServiceSettings() {
    return ((RegionBackendServiceStubSettings) getStubSettings())
        .getHealthRegionBackendServiceSettings();
  }

  /** Returns the object with the settings used for calls to insertRegionBackendService. */
  public UnaryCallSettings<InsertRegionBackendServiceHttpRequest, Operation>
      insertRegionBackendServiceSettings() {
    return ((RegionBackendServiceStubSettings) getStubSettings())
        .insertRegionBackendServiceSettings();
  }

  /** Returns the object with the settings used for calls to listRegionBackendServices. */
  public PagedCallSettings<
          ListRegionBackendServicesHttpRequest,
          BackendServiceList,
          ListRegionBackendServicesPagedResponse>
      listRegionBackendServicesSettings() {
    return ((RegionBackendServiceStubSettings) getStubSettings())
        .listRegionBackendServicesSettings();
  }

  /** Returns the object with the settings used for calls to patchRegionBackendService. */
  public UnaryCallSettings<PatchRegionBackendServiceHttpRequest, Operation>
      patchRegionBackendServiceSettings() {
    return ((RegionBackendServiceStubSettings) getStubSettings())
        .patchRegionBackendServiceSettings();
  }

  /** Returns the object with the settings used for calls to updateRegionBackendService. */
  public UnaryCallSettings<UpdateRegionBackendServiceHttpRequest, Operation>
      updateRegionBackendServiceSettings() {
    return ((RegionBackendServiceStubSettings) getStubSettings())
        .updateRegionBackendServiceSettings();
  }

  public static final RegionBackendServiceSettings create(RegionBackendServiceStubSettings stub)
      throws IOException {
    return new RegionBackendServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RegionBackendServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RegionBackendServiceStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return RegionBackendServiceStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RegionBackendServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RegionBackendServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RegionBackendServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RegionBackendServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RegionBackendServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RegionBackendServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RegionBackendServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<RegionBackendServiceSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(RegionBackendServiceStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(RegionBackendServiceStubSettings.newBuilder());
    }

    protected Builder(RegionBackendServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RegionBackendServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public RegionBackendServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((RegionBackendServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to deleteRegionBackendService. */
    public UnaryCallSettings.Builder<DeleteRegionBackendServiceHttpRequest, Operation>
        deleteRegionBackendServiceSettings() {
      return getStubSettingsBuilder().deleteRegionBackendServiceSettings();
    }

    /** Returns the builder for the settings used for calls to getRegionBackendService. */
    public UnaryCallSettings.Builder<GetRegionBackendServiceHttpRequest, BackendService>
        getRegionBackendServiceSettings() {
      return getStubSettingsBuilder().getRegionBackendServiceSettings();
    }

    /** Returns the builder for the settings used for calls to getHealthRegionBackendService. */
    public UnaryCallSettings.Builder<
            GetHealthRegionBackendServiceHttpRequest, BackendServiceGroupHealth>
        getHealthRegionBackendServiceSettings() {
      return getStubSettingsBuilder().getHealthRegionBackendServiceSettings();
    }

    /** Returns the builder for the settings used for calls to insertRegionBackendService. */
    public UnaryCallSettings.Builder<InsertRegionBackendServiceHttpRequest, Operation>
        insertRegionBackendServiceSettings() {
      return getStubSettingsBuilder().insertRegionBackendServiceSettings();
    }

    /** Returns the builder for the settings used for calls to listRegionBackendServices. */
    public PagedCallSettings.Builder<
            ListRegionBackendServicesHttpRequest,
            BackendServiceList,
            ListRegionBackendServicesPagedResponse>
        listRegionBackendServicesSettings() {
      return getStubSettingsBuilder().listRegionBackendServicesSettings();
    }

    /** Returns the builder for the settings used for calls to patchRegionBackendService. */
    public UnaryCallSettings.Builder<PatchRegionBackendServiceHttpRequest, Operation>
        patchRegionBackendServiceSettings() {
      return getStubSettingsBuilder().patchRegionBackendServiceSettings();
    }

    /** Returns the builder for the settings used for calls to updateRegionBackendService. */
    public UnaryCallSettings.Builder<UpdateRegionBackendServiceHttpRequest, Operation>
        updateRegionBackendServiceSettings() {
      return getStubSettingsBuilder().updateRegionBackendServiceSettings();
    }

    @Override
    public RegionBackendServiceSettings build() throws IOException {
      return new RegionBackendServiceSettings(this);
    }
  }
}
