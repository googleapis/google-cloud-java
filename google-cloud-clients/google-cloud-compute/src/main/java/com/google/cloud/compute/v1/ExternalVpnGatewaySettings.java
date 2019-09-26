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

import static com.google.cloud.compute.v1.ExternalVpnGatewayClient.ListExternalVpnGatewaysPagedResponse;

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
import com.google.cloud.compute.v1.stub.ExternalVpnGatewayStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link ExternalVpnGatewayClient}.
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
 * <p>For example, to set the total timeout of deleteExternalVpnGateway to 30 seconds:
 *
 * <pre>
 * <code>
 * ExternalVpnGatewaySettings.Builder externalVpnGatewaySettingsBuilder =
 *     ExternalVpnGatewaySettings.newBuilder();
 * externalVpnGatewaySettingsBuilder.deleteExternalVpnGatewaySettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * ExternalVpnGatewaySettings externalVpnGatewaySettings = externalVpnGatewaySettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ExternalVpnGatewaySettings extends ClientSettings<ExternalVpnGatewaySettings> {
  /** Returns the object with the settings used for calls to deleteExternalVpnGateway. */
  public UnaryCallSettings<DeleteExternalVpnGatewayHttpRequest, Operation>
      deleteExternalVpnGatewaySettings() {
    return ((ExternalVpnGatewayStubSettings) getStubSettings()).deleteExternalVpnGatewaySettings();
  }

  /** Returns the object with the settings used for calls to getExternalVpnGateway. */
  public UnaryCallSettings<GetExternalVpnGatewayHttpRequest, ExternalVpnGateway>
      getExternalVpnGatewaySettings() {
    return ((ExternalVpnGatewayStubSettings) getStubSettings()).getExternalVpnGatewaySettings();
  }

  /** Returns the object with the settings used for calls to insertExternalVpnGateway. */
  public UnaryCallSettings<InsertExternalVpnGatewayHttpRequest, Operation>
      insertExternalVpnGatewaySettings() {
    return ((ExternalVpnGatewayStubSettings) getStubSettings()).insertExternalVpnGatewaySettings();
  }

  /** Returns the object with the settings used for calls to listExternalVpnGateways. */
  public PagedCallSettings<
          ListExternalVpnGatewaysHttpRequest,
          ExternalVpnGatewayList,
          ListExternalVpnGatewaysPagedResponse>
      listExternalVpnGatewaysSettings() {
    return ((ExternalVpnGatewayStubSettings) getStubSettings()).listExternalVpnGatewaysSettings();
  }

  /** Returns the object with the settings used for calls to setLabelsExternalVpnGateway. */
  public UnaryCallSettings<SetLabelsExternalVpnGatewayHttpRequest, Operation>
      setLabelsExternalVpnGatewaySettings() {
    return ((ExternalVpnGatewayStubSettings) getStubSettings())
        .setLabelsExternalVpnGatewaySettings();
  }

  /**
   * Returns the object with the settings used for calls to testIamPermissionsExternalVpnGateway.
   */
  public UnaryCallSettings<TestIamPermissionsExternalVpnGatewayHttpRequest, TestPermissionsResponse>
      testIamPermissionsExternalVpnGatewaySettings() {
    return ((ExternalVpnGatewayStubSettings) getStubSettings())
        .testIamPermissionsExternalVpnGatewaySettings();
  }

  public static final ExternalVpnGatewaySettings create(ExternalVpnGatewayStubSettings stub)
      throws IOException {
    return new ExternalVpnGatewaySettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ExternalVpnGatewayStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ExternalVpnGatewayStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return ExternalVpnGatewayStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ExternalVpnGatewayStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ExternalVpnGatewayStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ExternalVpnGatewayStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ExternalVpnGatewayStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ExternalVpnGatewayStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ExternalVpnGatewaySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ExternalVpnGatewaySettings. */
  public static class Builder extends ClientSettings.Builder<ExternalVpnGatewaySettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(ExternalVpnGatewayStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(ExternalVpnGatewayStubSettings.newBuilder());
    }

    protected Builder(ExternalVpnGatewaySettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ExternalVpnGatewayStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public ExternalVpnGatewayStubSettings.Builder getStubSettingsBuilder() {
      return ((ExternalVpnGatewayStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to deleteExternalVpnGateway. */
    public UnaryCallSettings.Builder<DeleteExternalVpnGatewayHttpRequest, Operation>
        deleteExternalVpnGatewaySettings() {
      return getStubSettingsBuilder().deleteExternalVpnGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to getExternalVpnGateway. */
    public UnaryCallSettings.Builder<GetExternalVpnGatewayHttpRequest, ExternalVpnGateway>
        getExternalVpnGatewaySettings() {
      return getStubSettingsBuilder().getExternalVpnGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to insertExternalVpnGateway. */
    public UnaryCallSettings.Builder<InsertExternalVpnGatewayHttpRequest, Operation>
        insertExternalVpnGatewaySettings() {
      return getStubSettingsBuilder().insertExternalVpnGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to listExternalVpnGateways. */
    public PagedCallSettings.Builder<
            ListExternalVpnGatewaysHttpRequest,
            ExternalVpnGatewayList,
            ListExternalVpnGatewaysPagedResponse>
        listExternalVpnGatewaysSettings() {
      return getStubSettingsBuilder().listExternalVpnGatewaysSettings();
    }

    /** Returns the builder for the settings used for calls to setLabelsExternalVpnGateway. */
    public UnaryCallSettings.Builder<SetLabelsExternalVpnGatewayHttpRequest, Operation>
        setLabelsExternalVpnGatewaySettings() {
      return getStubSettingsBuilder().setLabelsExternalVpnGatewaySettings();
    }

    /**
     * Returns the builder for the settings used for calls to testIamPermissionsExternalVpnGateway.
     */
    public UnaryCallSettings.Builder<
            TestIamPermissionsExternalVpnGatewayHttpRequest, TestPermissionsResponse>
        testIamPermissionsExternalVpnGatewaySettings() {
      return getStubSettingsBuilder().testIamPermissionsExternalVpnGatewaySettings();
    }

    @Override
    public ExternalVpnGatewaySettings build() throws IOException {
      return new ExternalVpnGatewaySettings(this);
    }
  }
}
