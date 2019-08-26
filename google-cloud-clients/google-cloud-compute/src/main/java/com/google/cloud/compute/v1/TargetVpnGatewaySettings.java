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

import static com.google.cloud.compute.v1.TargetVpnGatewayClient.AggregatedListTargetVpnGatewaysPagedResponse;
import static com.google.cloud.compute.v1.TargetVpnGatewayClient.ListTargetVpnGatewaysPagedResponse;

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
import com.google.cloud.compute.v1.stub.TargetVpnGatewayStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link TargetVpnGatewayClient}.
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
 * <p>For example, to set the total timeout of deleteTargetVpnGateway to 30 seconds:
 *
 * <pre>
 * <code>
 * TargetVpnGatewaySettings.Builder targetVpnGatewaySettingsBuilder =
 *     TargetVpnGatewaySettings.newBuilder();
 * targetVpnGatewaySettingsBuilder.deleteTargetVpnGatewaySettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * TargetVpnGatewaySettings targetVpnGatewaySettings = targetVpnGatewaySettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class TargetVpnGatewaySettings extends ClientSettings<TargetVpnGatewaySettings> {
  /** Returns the object with the settings used for calls to aggregatedListTargetVpnGateways. */
  public PagedCallSettings<
          AggregatedListTargetVpnGatewaysHttpRequest,
          TargetVpnGatewayAggregatedList,
          AggregatedListTargetVpnGatewaysPagedResponse>
      aggregatedListTargetVpnGatewaysSettings() {
    return ((TargetVpnGatewayStubSettings) getStubSettings())
        .aggregatedListTargetVpnGatewaysSettings();
  }

  /** Returns the object with the settings used for calls to deleteTargetVpnGateway. */
  public UnaryCallSettings<DeleteTargetVpnGatewayHttpRequest, Operation>
      deleteTargetVpnGatewaySettings() {
    return ((TargetVpnGatewayStubSettings) getStubSettings()).deleteTargetVpnGatewaySettings();
  }

  /** Returns the object with the settings used for calls to getTargetVpnGateway. */
  public UnaryCallSettings<GetTargetVpnGatewayHttpRequest, TargetVpnGateway>
      getTargetVpnGatewaySettings() {
    return ((TargetVpnGatewayStubSettings) getStubSettings()).getTargetVpnGatewaySettings();
  }

  /** Returns the object with the settings used for calls to insertTargetVpnGateway. */
  public UnaryCallSettings<InsertTargetVpnGatewayHttpRequest, Operation>
      insertTargetVpnGatewaySettings() {
    return ((TargetVpnGatewayStubSettings) getStubSettings()).insertTargetVpnGatewaySettings();
  }

  /** Returns the object with the settings used for calls to listTargetVpnGateways. */
  public PagedCallSettings<
          ListTargetVpnGatewaysHttpRequest,
          TargetVpnGatewayList,
          ListTargetVpnGatewaysPagedResponse>
      listTargetVpnGatewaysSettings() {
    return ((TargetVpnGatewayStubSettings) getStubSettings()).listTargetVpnGatewaysSettings();
  }

  public static final TargetVpnGatewaySettings create(TargetVpnGatewayStubSettings stub)
      throws IOException {
    return new TargetVpnGatewaySettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return TargetVpnGatewayStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return TargetVpnGatewayStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return TargetVpnGatewayStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return TargetVpnGatewayStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return TargetVpnGatewayStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return TargetVpnGatewayStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TargetVpnGatewayStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TargetVpnGatewayStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected TargetVpnGatewaySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for TargetVpnGatewaySettings. */
  public static class Builder extends ClientSettings.Builder<TargetVpnGatewaySettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(TargetVpnGatewayStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(TargetVpnGatewayStubSettings.newBuilder());
    }

    protected Builder(TargetVpnGatewaySettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(TargetVpnGatewayStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public TargetVpnGatewayStubSettings.Builder getStubSettingsBuilder() {
      return ((TargetVpnGatewayStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to aggregatedListTargetVpnGateways. */
    public PagedCallSettings.Builder<
            AggregatedListTargetVpnGatewaysHttpRequest,
            TargetVpnGatewayAggregatedList,
            AggregatedListTargetVpnGatewaysPagedResponse>
        aggregatedListTargetVpnGatewaysSettings() {
      return getStubSettingsBuilder().aggregatedListTargetVpnGatewaysSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTargetVpnGateway. */
    public UnaryCallSettings.Builder<DeleteTargetVpnGatewayHttpRequest, Operation>
        deleteTargetVpnGatewaySettings() {
      return getStubSettingsBuilder().deleteTargetVpnGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to getTargetVpnGateway. */
    public UnaryCallSettings.Builder<GetTargetVpnGatewayHttpRequest, TargetVpnGateway>
        getTargetVpnGatewaySettings() {
      return getStubSettingsBuilder().getTargetVpnGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to insertTargetVpnGateway. */
    public UnaryCallSettings.Builder<InsertTargetVpnGatewayHttpRequest, Operation>
        insertTargetVpnGatewaySettings() {
      return getStubSettingsBuilder().insertTargetVpnGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to listTargetVpnGateways. */
    public PagedCallSettings.Builder<
            ListTargetVpnGatewaysHttpRequest,
            TargetVpnGatewayList,
            ListTargetVpnGatewaysPagedResponse>
        listTargetVpnGatewaysSettings() {
      return getStubSettingsBuilder().listTargetVpnGatewaysSettings();
    }

    @Override
    public TargetVpnGatewaySettings build() throws IOException {
      return new TargetVpnGatewaySettings(this);
    }
  }
}
