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

import static com.google.cloud.compute.v1.RegionUrlMapClient.ListRegionUrlMapsPagedResponse;

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
import com.google.cloud.compute.v1.stub.RegionUrlMapStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link RegionUrlMapClient}.
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
 * <p>For example, to set the total timeout of deleteRegionUrlMap to 30 seconds:
 *
 * <pre>
 * <code>
 * RegionUrlMapSettings.Builder regionUrlMapSettingsBuilder =
 *     RegionUrlMapSettings.newBuilder();
 * regionUrlMapSettingsBuilder.deleteRegionUrlMapSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * RegionUrlMapSettings regionUrlMapSettings = regionUrlMapSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionUrlMapSettings extends ClientSettings<RegionUrlMapSettings> {
  /** Returns the object with the settings used for calls to deleteRegionUrlMap. */
  public UnaryCallSettings<DeleteRegionUrlMapHttpRequest, Operation> deleteRegionUrlMapSettings() {
    return ((RegionUrlMapStubSettings) getStubSettings()).deleteRegionUrlMapSettings();
  }

  /** Returns the object with the settings used for calls to getRegionUrlMap. */
  public UnaryCallSettings<GetRegionUrlMapHttpRequest, UrlMap> getRegionUrlMapSettings() {
    return ((RegionUrlMapStubSettings) getStubSettings()).getRegionUrlMapSettings();
  }

  /** Returns the object with the settings used for calls to insertRegionUrlMap. */
  public UnaryCallSettings<InsertRegionUrlMapHttpRequest, Operation> insertRegionUrlMapSettings() {
    return ((RegionUrlMapStubSettings) getStubSettings()).insertRegionUrlMapSettings();
  }

  /** Returns the object with the settings used for calls to listRegionUrlMaps. */
  public PagedCallSettings<ListRegionUrlMapsHttpRequest, UrlMapList, ListRegionUrlMapsPagedResponse>
      listRegionUrlMapsSettings() {
    return ((RegionUrlMapStubSettings) getStubSettings()).listRegionUrlMapsSettings();
  }

  /** Returns the object with the settings used for calls to patchRegionUrlMap. */
  public UnaryCallSettings<PatchRegionUrlMapHttpRequest, Operation> patchRegionUrlMapSettings() {
    return ((RegionUrlMapStubSettings) getStubSettings()).patchRegionUrlMapSettings();
  }

  /** Returns the object with the settings used for calls to updateRegionUrlMap. */
  public UnaryCallSettings<UpdateRegionUrlMapHttpRequest, Operation> updateRegionUrlMapSettings() {
    return ((RegionUrlMapStubSettings) getStubSettings()).updateRegionUrlMapSettings();
  }

  /** Returns the object with the settings used for calls to validateRegionUrlMap. */
  public UnaryCallSettings<ValidateRegionUrlMapHttpRequest, UrlMapsValidateResponse>
      validateRegionUrlMapSettings() {
    return ((RegionUrlMapStubSettings) getStubSettings()).validateRegionUrlMapSettings();
  }

  public static final RegionUrlMapSettings create(RegionUrlMapStubSettings stub)
      throws IOException {
    return new RegionUrlMapSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RegionUrlMapStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RegionUrlMapStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return RegionUrlMapStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RegionUrlMapStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RegionUrlMapStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RegionUrlMapStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RegionUrlMapStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RegionUrlMapStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RegionUrlMapSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RegionUrlMapSettings. */
  public static class Builder extends ClientSettings.Builder<RegionUrlMapSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(RegionUrlMapStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(RegionUrlMapStubSettings.newBuilder());
    }

    protected Builder(RegionUrlMapSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RegionUrlMapStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public RegionUrlMapStubSettings.Builder getStubSettingsBuilder() {
      return ((RegionUrlMapStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to deleteRegionUrlMap. */
    public UnaryCallSettings.Builder<DeleteRegionUrlMapHttpRequest, Operation>
        deleteRegionUrlMapSettings() {
      return getStubSettingsBuilder().deleteRegionUrlMapSettings();
    }

    /** Returns the builder for the settings used for calls to getRegionUrlMap. */
    public UnaryCallSettings.Builder<GetRegionUrlMapHttpRequest, UrlMap> getRegionUrlMapSettings() {
      return getStubSettingsBuilder().getRegionUrlMapSettings();
    }

    /** Returns the builder for the settings used for calls to insertRegionUrlMap. */
    public UnaryCallSettings.Builder<InsertRegionUrlMapHttpRequest, Operation>
        insertRegionUrlMapSettings() {
      return getStubSettingsBuilder().insertRegionUrlMapSettings();
    }

    /** Returns the builder for the settings used for calls to listRegionUrlMaps. */
    public PagedCallSettings.Builder<
            ListRegionUrlMapsHttpRequest, UrlMapList, ListRegionUrlMapsPagedResponse>
        listRegionUrlMapsSettings() {
      return getStubSettingsBuilder().listRegionUrlMapsSettings();
    }

    /** Returns the builder for the settings used for calls to patchRegionUrlMap. */
    public UnaryCallSettings.Builder<PatchRegionUrlMapHttpRequest, Operation>
        patchRegionUrlMapSettings() {
      return getStubSettingsBuilder().patchRegionUrlMapSettings();
    }

    /** Returns the builder for the settings used for calls to updateRegionUrlMap. */
    public UnaryCallSettings.Builder<UpdateRegionUrlMapHttpRequest, Operation>
        updateRegionUrlMapSettings() {
      return getStubSettingsBuilder().updateRegionUrlMapSettings();
    }

    /** Returns the builder for the settings used for calls to validateRegionUrlMap. */
    public UnaryCallSettings.Builder<ValidateRegionUrlMapHttpRequest, UrlMapsValidateResponse>
        validateRegionUrlMapSettings() {
      return getStubSettingsBuilder().validateRegionUrlMapSettings();
    }

    @Override
    public RegionUrlMapSettings build() throws IOException {
      return new RegionUrlMapSettings(this);
    }
  }
}
