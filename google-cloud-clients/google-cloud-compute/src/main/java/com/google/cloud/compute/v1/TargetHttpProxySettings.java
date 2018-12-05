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

import static com.google.cloud.compute.v1.TargetHttpProxyClient.ListTargetHttpProxiesPagedResponse;

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
import com.google.cloud.compute.v1.stub.TargetHttpProxyStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link TargetHttpProxyClient}.
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
 * example, to set the total timeout of deleteTargetHttpProxy to 30 seconds:
 *
 * <pre>
 * <code>
 * TargetHttpProxySettings.Builder targetHttpProxySettingsBuilder =
 *     TargetHttpProxySettings.newBuilder();
 * targetHttpProxySettingsBuilder.deleteTargetHttpProxySettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * TargetHttpProxySettings targetHttpProxySettings = targetHttpProxySettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class TargetHttpProxySettings extends ClientSettings<TargetHttpProxySettings> {
  /** Returns the object with the settings used for calls to deleteTargetHttpProxy. */
  public UnaryCallSettings<DeleteTargetHttpProxyHttpRequest, Operation>
      deleteTargetHttpProxySettings() {
    return ((TargetHttpProxyStubSettings) getStubSettings()).deleteTargetHttpProxySettings();
  }

  /** Returns the object with the settings used for calls to getTargetHttpProxy. */
  public UnaryCallSettings<GetTargetHttpProxyHttpRequest, TargetHttpProxy>
      getTargetHttpProxySettings() {
    return ((TargetHttpProxyStubSettings) getStubSettings()).getTargetHttpProxySettings();
  }

  /** Returns the object with the settings used for calls to insertTargetHttpProxy. */
  public UnaryCallSettings<InsertTargetHttpProxyHttpRequest, Operation>
      insertTargetHttpProxySettings() {
    return ((TargetHttpProxyStubSettings) getStubSettings()).insertTargetHttpProxySettings();
  }

  /** Returns the object with the settings used for calls to listTargetHttpProxies. */
  public PagedCallSettings<
          ListTargetHttpProxiesHttpRequest, TargetHttpProxyList, ListTargetHttpProxiesPagedResponse>
      listTargetHttpProxiesSettings() {
    return ((TargetHttpProxyStubSettings) getStubSettings()).listTargetHttpProxiesSettings();
  }

  /** Returns the object with the settings used for calls to setUrlMapTargetHttpProxy. */
  public UnaryCallSettings<SetUrlMapTargetHttpProxyHttpRequest, Operation>
      setUrlMapTargetHttpProxySettings() {
    return ((TargetHttpProxyStubSettings) getStubSettings()).setUrlMapTargetHttpProxySettings();
  }

  public static final TargetHttpProxySettings create(TargetHttpProxyStubSettings stub)
      throws IOException {
    return new TargetHttpProxySettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return TargetHttpProxyStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return TargetHttpProxyStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return TargetHttpProxyStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return TargetHttpProxyStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return TargetHttpProxyStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return TargetHttpProxyStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TargetHttpProxyStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TargetHttpProxyStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected TargetHttpProxySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for TargetHttpProxySettings. */
  public static class Builder extends ClientSettings.Builder<TargetHttpProxySettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(TargetHttpProxyStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(TargetHttpProxyStubSettings.newBuilder());
    }

    protected Builder(TargetHttpProxySettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(TargetHttpProxyStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public TargetHttpProxyStubSettings.Builder getStubSettingsBuilder() {
      return ((TargetHttpProxyStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to deleteTargetHttpProxy. */
    public UnaryCallSettings.Builder<DeleteTargetHttpProxyHttpRequest, Operation>
        deleteTargetHttpProxySettings() {
      return getStubSettingsBuilder().deleteTargetHttpProxySettings();
    }

    /** Returns the builder for the settings used for calls to getTargetHttpProxy. */
    public UnaryCallSettings.Builder<GetTargetHttpProxyHttpRequest, TargetHttpProxy>
        getTargetHttpProxySettings() {
      return getStubSettingsBuilder().getTargetHttpProxySettings();
    }

    /** Returns the builder for the settings used for calls to insertTargetHttpProxy. */
    public UnaryCallSettings.Builder<InsertTargetHttpProxyHttpRequest, Operation>
        insertTargetHttpProxySettings() {
      return getStubSettingsBuilder().insertTargetHttpProxySettings();
    }

    /** Returns the builder for the settings used for calls to listTargetHttpProxies. */
    public PagedCallSettings.Builder<
            ListTargetHttpProxiesHttpRequest,
            TargetHttpProxyList,
            ListTargetHttpProxiesPagedResponse>
        listTargetHttpProxiesSettings() {
      return getStubSettingsBuilder().listTargetHttpProxiesSettings();
    }

    /** Returns the builder for the settings used for calls to setUrlMapTargetHttpProxy. */
    public UnaryCallSettings.Builder<SetUrlMapTargetHttpProxyHttpRequest, Operation>
        setUrlMapTargetHttpProxySettings() {
      return getStubSettingsBuilder().setUrlMapTargetHttpProxySettings();
    }

    @Override
    public TargetHttpProxySettings build() throws IOException {
      return new TargetHttpProxySettings(this);
    }
  }
}
