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

import static com.google.cloud.compute.v1.TargetSslProxiesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.stub.TargetSslProxiesStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TargetSslProxiesClient}.
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
 * TargetSslProxiesSettings.Builder targetSslProxiesSettingsBuilder =
 *     TargetSslProxiesSettings.newBuilder();
 * targetSslProxiesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         targetSslProxiesSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TargetSslProxiesSettings targetSslProxiesSettings = targetSslProxiesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TargetSslProxiesSettings extends ClientSettings<TargetSslProxiesSettings> {

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteTargetSslProxyRequest, Operation> deleteSettings() {
    return ((TargetSslProxiesStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteTargetSslProxyRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((TargetSslProxiesStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetTargetSslProxyRequest, TargetSslProxy> getSettings() {
    return ((TargetSslProxiesStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertTargetSslProxyRequest, Operation> insertSettings() {
    return ((TargetSslProxiesStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertTargetSslProxyRequest, Operation, Operation>
      insertOperationSettings() {
    return ((TargetSslProxiesStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListTargetSslProxiesRequest, TargetSslProxyList, ListPagedResponse>
      listSettings() {
    return ((TargetSslProxiesStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to setBackendService. */
  public UnaryCallSettings<SetBackendServiceTargetSslProxyRequest, Operation>
      setBackendServiceSettings() {
    return ((TargetSslProxiesStubSettings) getStubSettings()).setBackendServiceSettings();
  }

  /** Returns the object with the settings used for calls to setBackendService. */
  public OperationCallSettings<SetBackendServiceTargetSslProxyRequest, Operation, Operation>
      setBackendServiceOperationSettings() {
    return ((TargetSslProxiesStubSettings) getStubSettings()).setBackendServiceOperationSettings();
  }

  /** Returns the object with the settings used for calls to setCertificateMap. */
  public UnaryCallSettings<SetCertificateMapTargetSslProxyRequest, Operation>
      setCertificateMapSettings() {
    return ((TargetSslProxiesStubSettings) getStubSettings()).setCertificateMapSettings();
  }

  /** Returns the object with the settings used for calls to setCertificateMap. */
  public OperationCallSettings<SetCertificateMapTargetSslProxyRequest, Operation, Operation>
      setCertificateMapOperationSettings() {
    return ((TargetSslProxiesStubSettings) getStubSettings()).setCertificateMapOperationSettings();
  }

  /** Returns the object with the settings used for calls to setProxyHeader. */
  public UnaryCallSettings<SetProxyHeaderTargetSslProxyRequest, Operation>
      setProxyHeaderSettings() {
    return ((TargetSslProxiesStubSettings) getStubSettings()).setProxyHeaderSettings();
  }

  /** Returns the object with the settings used for calls to setProxyHeader. */
  public OperationCallSettings<SetProxyHeaderTargetSslProxyRequest, Operation, Operation>
      setProxyHeaderOperationSettings() {
    return ((TargetSslProxiesStubSettings) getStubSettings()).setProxyHeaderOperationSettings();
  }

  /** Returns the object with the settings used for calls to setSslCertificates. */
  public UnaryCallSettings<SetSslCertificatesTargetSslProxyRequest, Operation>
      setSslCertificatesSettings() {
    return ((TargetSslProxiesStubSettings) getStubSettings()).setSslCertificatesSettings();
  }

  /** Returns the object with the settings used for calls to setSslCertificates. */
  public OperationCallSettings<SetSslCertificatesTargetSslProxyRequest, Operation, Operation>
      setSslCertificatesOperationSettings() {
    return ((TargetSslProxiesStubSettings) getStubSettings()).setSslCertificatesOperationSettings();
  }

  /** Returns the object with the settings used for calls to setSslPolicy. */
  public UnaryCallSettings<SetSslPolicyTargetSslProxyRequest, Operation> setSslPolicySettings() {
    return ((TargetSslProxiesStubSettings) getStubSettings()).setSslPolicySettings();
  }

  /** Returns the object with the settings used for calls to setSslPolicy. */
  public OperationCallSettings<SetSslPolicyTargetSslProxyRequest, Operation, Operation>
      setSslPolicyOperationSettings() {
    return ((TargetSslProxiesStubSettings) getStubSettings()).setSslPolicyOperationSettings();
  }

  public static final TargetSslProxiesSettings create(TargetSslProxiesStubSettings stub)
      throws IOException {
    return new TargetSslProxiesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return TargetSslProxiesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return TargetSslProxiesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return TargetSslProxiesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return TargetSslProxiesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return TargetSslProxiesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TargetSslProxiesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TargetSslProxiesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected TargetSslProxiesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for TargetSslProxiesSettings. */
  public static class Builder extends ClientSettings.Builder<TargetSslProxiesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(TargetSslProxiesStubSettings.newBuilder(clientContext));
    }

    protected Builder(TargetSslProxiesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(TargetSslProxiesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(TargetSslProxiesStubSettings.newBuilder());
    }

    public TargetSslProxiesStubSettings.Builder getStubSettingsBuilder() {
      return ((TargetSslProxiesStubSettings.Builder) getStubSettings());
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
    public UnaryCallSettings.Builder<DeleteTargetSslProxyRequest, Operation> deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteTargetSslProxyRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetTargetSslProxyRequest, TargetSslProxy> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertTargetSslProxyRequest, Operation> insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertTargetSslProxyRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListTargetSslProxiesRequest, TargetSslProxyList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to setBackendService. */
    public UnaryCallSettings.Builder<SetBackendServiceTargetSslProxyRequest, Operation>
        setBackendServiceSettings() {
      return getStubSettingsBuilder().setBackendServiceSettings();
    }

    /** Returns the builder for the settings used for calls to setBackendService. */
    public OperationCallSettings.Builder<
            SetBackendServiceTargetSslProxyRequest, Operation, Operation>
        setBackendServiceOperationSettings() {
      return getStubSettingsBuilder().setBackendServiceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setCertificateMap. */
    public UnaryCallSettings.Builder<SetCertificateMapTargetSslProxyRequest, Operation>
        setCertificateMapSettings() {
      return getStubSettingsBuilder().setCertificateMapSettings();
    }

    /** Returns the builder for the settings used for calls to setCertificateMap. */
    public OperationCallSettings.Builder<
            SetCertificateMapTargetSslProxyRequest, Operation, Operation>
        setCertificateMapOperationSettings() {
      return getStubSettingsBuilder().setCertificateMapOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setProxyHeader. */
    public UnaryCallSettings.Builder<SetProxyHeaderTargetSslProxyRequest, Operation>
        setProxyHeaderSettings() {
      return getStubSettingsBuilder().setProxyHeaderSettings();
    }

    /** Returns the builder for the settings used for calls to setProxyHeader. */
    public OperationCallSettings.Builder<SetProxyHeaderTargetSslProxyRequest, Operation, Operation>
        setProxyHeaderOperationSettings() {
      return getStubSettingsBuilder().setProxyHeaderOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setSslCertificates. */
    public UnaryCallSettings.Builder<SetSslCertificatesTargetSslProxyRequest, Operation>
        setSslCertificatesSettings() {
      return getStubSettingsBuilder().setSslCertificatesSettings();
    }

    /** Returns the builder for the settings used for calls to setSslCertificates. */
    public OperationCallSettings.Builder<
            SetSslCertificatesTargetSslProxyRequest, Operation, Operation>
        setSslCertificatesOperationSettings() {
      return getStubSettingsBuilder().setSslCertificatesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setSslPolicy. */
    public UnaryCallSettings.Builder<SetSslPolicyTargetSslProxyRequest, Operation>
        setSslPolicySettings() {
      return getStubSettingsBuilder().setSslPolicySettings();
    }

    /** Returns the builder for the settings used for calls to setSslPolicy. */
    public OperationCallSettings.Builder<SetSslPolicyTargetSslProxyRequest, Operation, Operation>
        setSslPolicyOperationSettings() {
      return getStubSettingsBuilder().setSslPolicyOperationSettings();
    }

    @Override
    public TargetSslProxiesSettings build() throws IOException {
      return new TargetSslProxiesSettings(this);
    }
  }
}
