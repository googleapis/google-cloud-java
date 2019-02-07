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

import static com.google.cloud.compute.v1.TargetTcpProxyClient.ListTargetTcpProxiesPagedResponse;

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
import com.google.cloud.compute.v1.stub.TargetTcpProxyStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link TargetTcpProxyClient}.
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
 * example, to set the total timeout of deleteTargetTcpProxy to 30 seconds:
 *
 * <pre>
 * <code>
 * TargetTcpProxySettings.Builder targetTcpProxySettingsBuilder =
 *     TargetTcpProxySettings.newBuilder();
 * targetTcpProxySettingsBuilder.deleteTargetTcpProxySettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * TargetTcpProxySettings targetTcpProxySettings = targetTcpProxySettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class TargetTcpProxySettings extends ClientSettings<TargetTcpProxySettings> {
  /** Returns the object with the settings used for calls to deleteTargetTcpProxy. */
  public UnaryCallSettings<DeleteTargetTcpProxyHttpRequest, Operation>
      deleteTargetTcpProxySettings() {
    return ((TargetTcpProxyStubSettings) getStubSettings()).deleteTargetTcpProxySettings();
  }

  /** Returns the object with the settings used for calls to getTargetTcpProxy. */
  public UnaryCallSettings<GetTargetTcpProxyHttpRequest, TargetTcpProxy>
      getTargetTcpProxySettings() {
    return ((TargetTcpProxyStubSettings) getStubSettings()).getTargetTcpProxySettings();
  }

  /** Returns the object with the settings used for calls to insertTargetTcpProxy. */
  public UnaryCallSettings<InsertTargetTcpProxyHttpRequest, Operation>
      insertTargetTcpProxySettings() {
    return ((TargetTcpProxyStubSettings) getStubSettings()).insertTargetTcpProxySettings();
  }

  /** Returns the object with the settings used for calls to listTargetTcpProxies. */
  public PagedCallSettings<
          ListTargetTcpProxiesHttpRequest, TargetTcpProxyList, ListTargetTcpProxiesPagedResponse>
      listTargetTcpProxiesSettings() {
    return ((TargetTcpProxyStubSettings) getStubSettings()).listTargetTcpProxiesSettings();
  }

  /** Returns the object with the settings used for calls to setBackendServiceTargetTcpProxy. */
  public UnaryCallSettings<SetBackendServiceTargetTcpProxyHttpRequest, Operation>
      setBackendServiceTargetTcpProxySettings() {
    return ((TargetTcpProxyStubSettings) getStubSettings())
        .setBackendServiceTargetTcpProxySettings();
  }

  /** Returns the object with the settings used for calls to setProxyHeaderTargetTcpProxy. */
  public UnaryCallSettings<SetProxyHeaderTargetTcpProxyHttpRequest, Operation>
      setProxyHeaderTargetTcpProxySettings() {
    return ((TargetTcpProxyStubSettings) getStubSettings()).setProxyHeaderTargetTcpProxySettings();
  }

  public static final TargetTcpProxySettings create(TargetTcpProxyStubSettings stub)
      throws IOException {
    return new TargetTcpProxySettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return TargetTcpProxyStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return TargetTcpProxyStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return TargetTcpProxyStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return TargetTcpProxyStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return TargetTcpProxyStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return TargetTcpProxyStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TargetTcpProxyStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TargetTcpProxyStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected TargetTcpProxySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for TargetTcpProxySettings. */
  public static class Builder extends ClientSettings.Builder<TargetTcpProxySettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(TargetTcpProxyStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(TargetTcpProxyStubSettings.newBuilder());
    }

    protected Builder(TargetTcpProxySettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(TargetTcpProxyStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public TargetTcpProxyStubSettings.Builder getStubSettingsBuilder() {
      return ((TargetTcpProxyStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to deleteTargetTcpProxy. */
    public UnaryCallSettings.Builder<DeleteTargetTcpProxyHttpRequest, Operation>
        deleteTargetTcpProxySettings() {
      return getStubSettingsBuilder().deleteTargetTcpProxySettings();
    }

    /** Returns the builder for the settings used for calls to getTargetTcpProxy. */
    public UnaryCallSettings.Builder<GetTargetTcpProxyHttpRequest, TargetTcpProxy>
        getTargetTcpProxySettings() {
      return getStubSettingsBuilder().getTargetTcpProxySettings();
    }

    /** Returns the builder for the settings used for calls to insertTargetTcpProxy. */
    public UnaryCallSettings.Builder<InsertTargetTcpProxyHttpRequest, Operation>
        insertTargetTcpProxySettings() {
      return getStubSettingsBuilder().insertTargetTcpProxySettings();
    }

    /** Returns the builder for the settings used for calls to listTargetTcpProxies. */
    public PagedCallSettings.Builder<
            ListTargetTcpProxiesHttpRequest, TargetTcpProxyList, ListTargetTcpProxiesPagedResponse>
        listTargetTcpProxiesSettings() {
      return getStubSettingsBuilder().listTargetTcpProxiesSettings();
    }

    /** Returns the builder for the settings used for calls to setBackendServiceTargetTcpProxy. */
    public UnaryCallSettings.Builder<SetBackendServiceTargetTcpProxyHttpRequest, Operation>
        setBackendServiceTargetTcpProxySettings() {
      return getStubSettingsBuilder().setBackendServiceTargetTcpProxySettings();
    }

    /** Returns the builder for the settings used for calls to setProxyHeaderTargetTcpProxy. */
    public UnaryCallSettings.Builder<SetProxyHeaderTargetTcpProxyHttpRequest, Operation>
        setProxyHeaderTargetTcpProxySettings() {
      return getStubSettingsBuilder().setProxyHeaderTargetTcpProxySettings();
    }

    @Override
    public TargetTcpProxySettings build() throws IOException {
      return new TargetTcpProxySettings(this);
    }
  }
}
