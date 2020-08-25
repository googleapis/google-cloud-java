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

import static com.google.cloud.compute.v1.TargetGrpcProxyClient.ListTargetGrpcProxiesPagedResponse;

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
import com.google.cloud.compute.v1.stub.TargetGrpcProxyStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link TargetGrpcProxyClient}.
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
 * <p>For example, to set the total timeout of deleteTargetGrpcProxy to 30 seconds:
 *
 * <pre>
 * <code>
 * TargetGrpcProxySettings.Builder targetGrpcProxySettingsBuilder =
 *     TargetGrpcProxySettings.newBuilder();
 * targetGrpcProxySettingsBuilder
 *     .deleteTargetGrpcProxySettings()
 *     .setRetrySettings(
 *         targetGrpcProxySettingsBuilder.deleteTargetGrpcProxySettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TargetGrpcProxySettings targetGrpcProxySettings = targetGrpcProxySettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class TargetGrpcProxySettings extends ClientSettings<TargetGrpcProxySettings> {
  /** Returns the object with the settings used for calls to deleteTargetGrpcProxy. */
  public UnaryCallSettings<DeleteTargetGrpcProxyHttpRequest, Operation>
      deleteTargetGrpcProxySettings() {
    return ((TargetGrpcProxyStubSettings) getStubSettings()).deleteTargetGrpcProxySettings();
  }

  /** Returns the object with the settings used for calls to getTargetGrpcProxy. */
  public UnaryCallSettings<GetTargetGrpcProxyHttpRequest, TargetGrpcProxy>
      getTargetGrpcProxySettings() {
    return ((TargetGrpcProxyStubSettings) getStubSettings()).getTargetGrpcProxySettings();
  }

  /** Returns the object with the settings used for calls to insertTargetGrpcProxy. */
  public UnaryCallSettings<InsertTargetGrpcProxyHttpRequest, Operation>
      insertTargetGrpcProxySettings() {
    return ((TargetGrpcProxyStubSettings) getStubSettings()).insertTargetGrpcProxySettings();
  }

  /** Returns the object with the settings used for calls to listTargetGrpcProxies. */
  public PagedCallSettings<
          ListTargetGrpcProxiesHttpRequest, TargetGrpcProxyList, ListTargetGrpcProxiesPagedResponse>
      listTargetGrpcProxiesSettings() {
    return ((TargetGrpcProxyStubSettings) getStubSettings()).listTargetGrpcProxiesSettings();
  }

  /** Returns the object with the settings used for calls to patchTargetGrpcProxy. */
  public UnaryCallSettings<PatchTargetGrpcProxyHttpRequest, Operation>
      patchTargetGrpcProxySettings() {
    return ((TargetGrpcProxyStubSettings) getStubSettings()).patchTargetGrpcProxySettings();
  }

  public static final TargetGrpcProxySettings create(TargetGrpcProxyStubSettings stub)
      throws IOException {
    return new TargetGrpcProxySettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return TargetGrpcProxyStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return TargetGrpcProxyStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return TargetGrpcProxyStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return TargetGrpcProxyStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return TargetGrpcProxyStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return TargetGrpcProxyStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TargetGrpcProxyStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TargetGrpcProxyStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected TargetGrpcProxySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for TargetGrpcProxySettings. */
  public static class Builder extends ClientSettings.Builder<TargetGrpcProxySettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(TargetGrpcProxyStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(TargetGrpcProxyStubSettings.newBuilder());
    }

    protected Builder(TargetGrpcProxySettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(TargetGrpcProxyStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public TargetGrpcProxyStubSettings.Builder getStubSettingsBuilder() {
      return ((TargetGrpcProxyStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to deleteTargetGrpcProxy. */
    public UnaryCallSettings.Builder<DeleteTargetGrpcProxyHttpRequest, Operation>
        deleteTargetGrpcProxySettings() {
      return getStubSettingsBuilder().deleteTargetGrpcProxySettings();
    }

    /** Returns the builder for the settings used for calls to getTargetGrpcProxy. */
    public UnaryCallSettings.Builder<GetTargetGrpcProxyHttpRequest, TargetGrpcProxy>
        getTargetGrpcProxySettings() {
      return getStubSettingsBuilder().getTargetGrpcProxySettings();
    }

    /** Returns the builder for the settings used for calls to insertTargetGrpcProxy. */
    public UnaryCallSettings.Builder<InsertTargetGrpcProxyHttpRequest, Operation>
        insertTargetGrpcProxySettings() {
      return getStubSettingsBuilder().insertTargetGrpcProxySettings();
    }

    /** Returns the builder for the settings used for calls to listTargetGrpcProxies. */
    public PagedCallSettings.Builder<
            ListTargetGrpcProxiesHttpRequest,
            TargetGrpcProxyList,
            ListTargetGrpcProxiesPagedResponse>
        listTargetGrpcProxiesSettings() {
      return getStubSettingsBuilder().listTargetGrpcProxiesSettings();
    }

    /** Returns the builder for the settings used for calls to patchTargetGrpcProxy. */
    public UnaryCallSettings.Builder<PatchTargetGrpcProxyHttpRequest, Operation>
        patchTargetGrpcProxySettings() {
      return getStubSettingsBuilder().patchTargetGrpcProxySettings();
    }

    @Override
    public TargetGrpcProxySettings build() throws IOException {
      return new TargetGrpcProxySettings(this);
    }
  }
}
