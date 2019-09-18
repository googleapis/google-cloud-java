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

import static com.google.cloud.compute.v1.RegionTargetHttpsProxyClient.ListRegionTargetHttpsProxiesPagedResponse;

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
import com.google.cloud.compute.v1.stub.RegionTargetHttpsProxyStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link RegionTargetHttpsProxyClient}.
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
 * <p>For example, to set the total timeout of deleteRegionTargetHttpsProxy to 30 seconds:
 *
 * <pre>
 * <code>
 * RegionTargetHttpsProxySettings.Builder regionTargetHttpsProxySettingsBuilder =
 *     RegionTargetHttpsProxySettings.newBuilder();
 * regionTargetHttpsProxySettingsBuilder.deleteRegionTargetHttpsProxySettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * RegionTargetHttpsProxySettings regionTargetHttpsProxySettings = regionTargetHttpsProxySettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionTargetHttpsProxySettings extends ClientSettings<RegionTargetHttpsProxySettings> {
  /** Returns the object with the settings used for calls to deleteRegionTargetHttpsProxy. */
  public UnaryCallSettings<DeleteRegionTargetHttpsProxyHttpRequest, Operation>
      deleteRegionTargetHttpsProxySettings() {
    return ((RegionTargetHttpsProxyStubSettings) getStubSettings())
        .deleteRegionTargetHttpsProxySettings();
  }

  /** Returns the object with the settings used for calls to getRegionTargetHttpsProxy. */
  public UnaryCallSettings<GetRegionTargetHttpsProxyHttpRequest, TargetHttpsProxy>
      getRegionTargetHttpsProxySettings() {
    return ((RegionTargetHttpsProxyStubSettings) getStubSettings())
        .getRegionTargetHttpsProxySettings();
  }

  /** Returns the object with the settings used for calls to insertRegionTargetHttpsProxy. */
  public UnaryCallSettings<InsertRegionTargetHttpsProxyHttpRequest, Operation>
      insertRegionTargetHttpsProxySettings() {
    return ((RegionTargetHttpsProxyStubSettings) getStubSettings())
        .insertRegionTargetHttpsProxySettings();
  }

  /** Returns the object with the settings used for calls to listRegionTargetHttpsProxies. */
  public PagedCallSettings<
          ListRegionTargetHttpsProxiesHttpRequest,
          TargetHttpsProxyList,
          ListRegionTargetHttpsProxiesPagedResponse>
      listRegionTargetHttpsProxiesSettings() {
    return ((RegionTargetHttpsProxyStubSettings) getStubSettings())
        .listRegionTargetHttpsProxiesSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * setSslCertificatesRegionTargetHttpsProxy.
   */
  public UnaryCallSettings<SetSslCertificatesRegionTargetHttpsProxyHttpRequest, Operation>
      setSslCertificatesRegionTargetHttpsProxySettings() {
    return ((RegionTargetHttpsProxyStubSettings) getStubSettings())
        .setSslCertificatesRegionTargetHttpsProxySettings();
  }

  /** Returns the object with the settings used for calls to setUrlMapRegionTargetHttpsProxy. */
  public UnaryCallSettings<SetUrlMapRegionTargetHttpsProxyHttpRequest, Operation>
      setUrlMapRegionTargetHttpsProxySettings() {
    return ((RegionTargetHttpsProxyStubSettings) getStubSettings())
        .setUrlMapRegionTargetHttpsProxySettings();
  }

  public static final RegionTargetHttpsProxySettings create(RegionTargetHttpsProxyStubSettings stub)
      throws IOException {
    return new RegionTargetHttpsProxySettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RegionTargetHttpsProxyStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RegionTargetHttpsProxyStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return RegionTargetHttpsProxyStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RegionTargetHttpsProxyStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RegionTargetHttpsProxyStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RegionTargetHttpsProxyStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RegionTargetHttpsProxyStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RegionTargetHttpsProxyStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RegionTargetHttpsProxySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RegionTargetHttpsProxySettings. */
  public static class Builder
      extends ClientSettings.Builder<RegionTargetHttpsProxySettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(RegionTargetHttpsProxyStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(RegionTargetHttpsProxyStubSettings.newBuilder());
    }

    protected Builder(RegionTargetHttpsProxySettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RegionTargetHttpsProxyStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public RegionTargetHttpsProxyStubSettings.Builder getStubSettingsBuilder() {
      return ((RegionTargetHttpsProxyStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to deleteRegionTargetHttpsProxy. */
    public UnaryCallSettings.Builder<DeleteRegionTargetHttpsProxyHttpRequest, Operation>
        deleteRegionTargetHttpsProxySettings() {
      return getStubSettingsBuilder().deleteRegionTargetHttpsProxySettings();
    }

    /** Returns the builder for the settings used for calls to getRegionTargetHttpsProxy. */
    public UnaryCallSettings.Builder<GetRegionTargetHttpsProxyHttpRequest, TargetHttpsProxy>
        getRegionTargetHttpsProxySettings() {
      return getStubSettingsBuilder().getRegionTargetHttpsProxySettings();
    }

    /** Returns the builder for the settings used for calls to insertRegionTargetHttpsProxy. */
    public UnaryCallSettings.Builder<InsertRegionTargetHttpsProxyHttpRequest, Operation>
        insertRegionTargetHttpsProxySettings() {
      return getStubSettingsBuilder().insertRegionTargetHttpsProxySettings();
    }

    /** Returns the builder for the settings used for calls to listRegionTargetHttpsProxies. */
    public PagedCallSettings.Builder<
            ListRegionTargetHttpsProxiesHttpRequest,
            TargetHttpsProxyList,
            ListRegionTargetHttpsProxiesPagedResponse>
        listRegionTargetHttpsProxiesSettings() {
      return getStubSettingsBuilder().listRegionTargetHttpsProxiesSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * setSslCertificatesRegionTargetHttpsProxy.
     */
    public UnaryCallSettings.Builder<SetSslCertificatesRegionTargetHttpsProxyHttpRequest, Operation>
        setSslCertificatesRegionTargetHttpsProxySettings() {
      return getStubSettingsBuilder().setSslCertificatesRegionTargetHttpsProxySettings();
    }

    /** Returns the builder for the settings used for calls to setUrlMapRegionTargetHttpsProxy. */
    public UnaryCallSettings.Builder<SetUrlMapRegionTargetHttpsProxyHttpRequest, Operation>
        setUrlMapRegionTargetHttpsProxySettings() {
      return getStubSettingsBuilder().setUrlMapRegionTargetHttpsProxySettings();
    }

    @Override
    public RegionTargetHttpsProxySettings build() throws IOException {
      return new RegionTargetHttpsProxySettings(this);
    }
  }
}
