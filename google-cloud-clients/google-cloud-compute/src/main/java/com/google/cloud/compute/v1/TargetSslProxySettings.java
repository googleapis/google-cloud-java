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

import static com.google.cloud.compute.v1.TargetSslProxyClient.ListTargetSslProxiesPagedResponse;

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
import com.google.cloud.compute.v1.stub.TargetSslProxyStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link TargetSslProxyClient}.
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
 * <p>For example, to set the total timeout of deleteTargetSslProxy to 30 seconds:
 *
 * <pre>
 * <code>
 * TargetSslProxySettings.Builder targetSslProxySettingsBuilder =
 *     TargetSslProxySettings.newBuilder();
 * targetSslProxySettingsBuilder.deleteTargetSslProxySettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * TargetSslProxySettings targetSslProxySettings = targetSslProxySettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class TargetSslProxySettings extends ClientSettings<TargetSslProxySettings> {
  /** Returns the object with the settings used for calls to deleteTargetSslProxy. */
  public UnaryCallSettings<DeleteTargetSslProxyHttpRequest, Operation>
      deleteTargetSslProxySettings() {
    return ((TargetSslProxyStubSettings) getStubSettings()).deleteTargetSslProxySettings();
  }

  /** Returns the object with the settings used for calls to getTargetSslProxy. */
  public UnaryCallSettings<GetTargetSslProxyHttpRequest, TargetSslProxy>
      getTargetSslProxySettings() {
    return ((TargetSslProxyStubSettings) getStubSettings()).getTargetSslProxySettings();
  }

  /** Returns the object with the settings used for calls to insertTargetSslProxy. */
  public UnaryCallSettings<InsertTargetSslProxyHttpRequest, Operation>
      insertTargetSslProxySettings() {
    return ((TargetSslProxyStubSettings) getStubSettings()).insertTargetSslProxySettings();
  }

  /** Returns the object with the settings used for calls to listTargetSslProxies. */
  public PagedCallSettings<
          ListTargetSslProxiesHttpRequest, TargetSslProxyList, ListTargetSslProxiesPagedResponse>
      listTargetSslProxiesSettings() {
    return ((TargetSslProxyStubSettings) getStubSettings()).listTargetSslProxiesSettings();
  }

  /** Returns the object with the settings used for calls to setBackendServiceTargetSslProxy. */
  public UnaryCallSettings<SetBackendServiceTargetSslProxyHttpRequest, Operation>
      setBackendServiceTargetSslProxySettings() {
    return ((TargetSslProxyStubSettings) getStubSettings())
        .setBackendServiceTargetSslProxySettings();
  }

  /** Returns the object with the settings used for calls to setProxyHeaderTargetSslProxy. */
  public UnaryCallSettings<SetProxyHeaderTargetSslProxyHttpRequest, Operation>
      setProxyHeaderTargetSslProxySettings() {
    return ((TargetSslProxyStubSettings) getStubSettings()).setProxyHeaderTargetSslProxySettings();
  }

  /** Returns the object with the settings used for calls to setSslCertificatesTargetSslProxy. */
  public UnaryCallSettings<SetSslCertificatesTargetSslProxyHttpRequest, Operation>
      setSslCertificatesTargetSslProxySettings() {
    return ((TargetSslProxyStubSettings) getStubSettings())
        .setSslCertificatesTargetSslProxySettings();
  }

  /** Returns the object with the settings used for calls to setSslPolicyTargetSslProxy. */
  public UnaryCallSettings<SetSslPolicyTargetSslProxyHttpRequest, Operation>
      setSslPolicyTargetSslProxySettings() {
    return ((TargetSslProxyStubSettings) getStubSettings()).setSslPolicyTargetSslProxySettings();
  }

  public static final TargetSslProxySettings create(TargetSslProxyStubSettings stub)
      throws IOException {
    return new TargetSslProxySettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return TargetSslProxyStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return TargetSslProxyStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return TargetSslProxyStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return TargetSslProxyStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return TargetSslProxyStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return TargetSslProxyStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TargetSslProxyStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TargetSslProxyStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected TargetSslProxySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for TargetSslProxySettings. */
  public static class Builder extends ClientSettings.Builder<TargetSslProxySettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(TargetSslProxyStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(TargetSslProxyStubSettings.newBuilder());
    }

    protected Builder(TargetSslProxySettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(TargetSslProxyStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public TargetSslProxyStubSettings.Builder getStubSettingsBuilder() {
      return ((TargetSslProxyStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to deleteTargetSslProxy. */
    public UnaryCallSettings.Builder<DeleteTargetSslProxyHttpRequest, Operation>
        deleteTargetSslProxySettings() {
      return getStubSettingsBuilder().deleteTargetSslProxySettings();
    }

    /** Returns the builder for the settings used for calls to getTargetSslProxy. */
    public UnaryCallSettings.Builder<GetTargetSslProxyHttpRequest, TargetSslProxy>
        getTargetSslProxySettings() {
      return getStubSettingsBuilder().getTargetSslProxySettings();
    }

    /** Returns the builder for the settings used for calls to insertTargetSslProxy. */
    public UnaryCallSettings.Builder<InsertTargetSslProxyHttpRequest, Operation>
        insertTargetSslProxySettings() {
      return getStubSettingsBuilder().insertTargetSslProxySettings();
    }

    /** Returns the builder for the settings used for calls to listTargetSslProxies. */
    public PagedCallSettings.Builder<
            ListTargetSslProxiesHttpRequest, TargetSslProxyList, ListTargetSslProxiesPagedResponse>
        listTargetSslProxiesSettings() {
      return getStubSettingsBuilder().listTargetSslProxiesSettings();
    }

    /** Returns the builder for the settings used for calls to setBackendServiceTargetSslProxy. */
    public UnaryCallSettings.Builder<SetBackendServiceTargetSslProxyHttpRequest, Operation>
        setBackendServiceTargetSslProxySettings() {
      return getStubSettingsBuilder().setBackendServiceTargetSslProxySettings();
    }

    /** Returns the builder for the settings used for calls to setProxyHeaderTargetSslProxy. */
    public UnaryCallSettings.Builder<SetProxyHeaderTargetSslProxyHttpRequest, Operation>
        setProxyHeaderTargetSslProxySettings() {
      return getStubSettingsBuilder().setProxyHeaderTargetSslProxySettings();
    }

    /** Returns the builder for the settings used for calls to setSslCertificatesTargetSslProxy. */
    public UnaryCallSettings.Builder<SetSslCertificatesTargetSslProxyHttpRequest, Operation>
        setSslCertificatesTargetSslProxySettings() {
      return getStubSettingsBuilder().setSslCertificatesTargetSslProxySettings();
    }

    /** Returns the builder for the settings used for calls to setSslPolicyTargetSslProxy. */
    public UnaryCallSettings.Builder<SetSslPolicyTargetSslProxyHttpRequest, Operation>
        setSslPolicyTargetSslProxySettings() {
      return getStubSettingsBuilder().setSslPolicyTargetSslProxySettings();
    }

    @Override
    public TargetSslProxySettings build() throws IOException {
      return new TargetSslProxySettings(this);
    }
  }
}
