/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.TargetTcpProxiesClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.TargetTcpProxiesStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TargetTcpProxiesClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (compute.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of get to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TargetTcpProxiesSettings.Builder targetTcpProxiesSettingsBuilder =
 *     TargetTcpProxiesSettings.newBuilder();
 * targetTcpProxiesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         targetTcpProxiesSettingsBuilder.getSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TargetTcpProxiesSettings targetTcpProxiesSettings = targetTcpProxiesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TargetTcpProxiesSettings extends ClientSettings<TargetTcpProxiesSettings> {

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteTargetTcpProxyRequest, Operation> deleteSettings() {
    return ((TargetTcpProxiesStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteTargetTcpProxyRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((TargetTcpProxiesStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetTargetTcpProxyRequest, TargetTcpProxy> getSettings() {
    return ((TargetTcpProxiesStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertTargetTcpProxyRequest, Operation> insertSettings() {
    return ((TargetTcpProxiesStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertTargetTcpProxyRequest, Operation, Operation>
      insertOperationSettings() {
    return ((TargetTcpProxiesStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListTargetTcpProxiesRequest, TargetTcpProxyList, ListPagedResponse>
      listSettings() {
    return ((TargetTcpProxiesStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to setBackendService. */
  public UnaryCallSettings<SetBackendServiceTargetTcpProxyRequest, Operation>
      setBackendServiceSettings() {
    return ((TargetTcpProxiesStubSettings) getStubSettings()).setBackendServiceSettings();
  }

  /** Returns the object with the settings used for calls to setBackendService. */
  public OperationCallSettings<SetBackendServiceTargetTcpProxyRequest, Operation, Operation>
      setBackendServiceOperationSettings() {
    return ((TargetTcpProxiesStubSettings) getStubSettings()).setBackendServiceOperationSettings();
  }

  /** Returns the object with the settings used for calls to setProxyHeader. */
  public UnaryCallSettings<SetProxyHeaderTargetTcpProxyRequest, Operation>
      setProxyHeaderSettings() {
    return ((TargetTcpProxiesStubSettings) getStubSettings()).setProxyHeaderSettings();
  }

  /** Returns the object with the settings used for calls to setProxyHeader. */
  public OperationCallSettings<SetProxyHeaderTargetTcpProxyRequest, Operation, Operation>
      setProxyHeaderOperationSettings() {
    return ((TargetTcpProxiesStubSettings) getStubSettings()).setProxyHeaderOperationSettings();
  }

  public static final TargetTcpProxiesSettings create(TargetTcpProxiesStubSettings stub)
      throws IOException {
    return new TargetTcpProxiesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return TargetTcpProxiesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return TargetTcpProxiesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return TargetTcpProxiesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return TargetTcpProxiesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return TargetTcpProxiesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TargetTcpProxiesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TargetTcpProxiesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected TargetTcpProxiesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for TargetTcpProxiesSettings. */
  public static class Builder extends ClientSettings.Builder<TargetTcpProxiesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(TargetTcpProxiesStubSettings.newBuilder(clientContext));
    }

    protected Builder(TargetTcpProxiesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(TargetTcpProxiesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(TargetTcpProxiesStubSettings.newBuilder());
    }

    public TargetTcpProxiesStubSettings.Builder getStubSettingsBuilder() {
      return ((TargetTcpProxiesStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteTargetTcpProxyRequest, Operation> deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteTargetTcpProxyRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetTargetTcpProxyRequest, TargetTcpProxy> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertTargetTcpProxyRequest, Operation> insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertTargetTcpProxyRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListTargetTcpProxiesRequest, TargetTcpProxyList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to setBackendService. */
    public UnaryCallSettings.Builder<SetBackendServiceTargetTcpProxyRequest, Operation>
        setBackendServiceSettings() {
      return getStubSettingsBuilder().setBackendServiceSettings();
    }

    /** Returns the builder for the settings used for calls to setBackendService. */
    public OperationCallSettings.Builder<
            SetBackendServiceTargetTcpProxyRequest, Operation, Operation>
        setBackendServiceOperationSettings() {
      return getStubSettingsBuilder().setBackendServiceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setProxyHeader. */
    public UnaryCallSettings.Builder<SetProxyHeaderTargetTcpProxyRequest, Operation>
        setProxyHeaderSettings() {
      return getStubSettingsBuilder().setProxyHeaderSettings();
    }

    /** Returns the builder for the settings used for calls to setProxyHeader. */
    public OperationCallSettings.Builder<SetProxyHeaderTargetTcpProxyRequest, Operation, Operation>
        setProxyHeaderOperationSettings() {
      return getStubSettingsBuilder().setProxyHeaderOperationSettings();
    }

    @Override
    public TargetTcpProxiesSettings build() throws IOException {
      return new TargetTcpProxiesSettings(this);
    }
  }
}
