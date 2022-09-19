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

import static com.google.cloud.compute.v1.TargetHttpsProxiesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.TargetHttpsProxiesClient.ListPagedResponse;

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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.TargetHttpsProxiesStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TargetHttpsProxiesClient}.
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
 * TargetHttpsProxiesSettings.Builder targetHttpsProxiesSettingsBuilder =
 *     TargetHttpsProxiesSettings.newBuilder();
 * targetHttpsProxiesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         targetHttpsProxiesSettingsBuilder.getSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TargetHttpsProxiesSettings targetHttpsProxiesSettings =
 *     targetHttpsProxiesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TargetHttpsProxiesSettings extends ClientSettings<TargetHttpsProxiesSettings> {

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListTargetHttpsProxiesRequest,
          TargetHttpsProxyAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings() {
    return ((TargetHttpsProxiesStubSettings) getStubSettings()).aggregatedListSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteTargetHttpsProxyRequest, Operation> deleteSettings() {
    return ((TargetHttpsProxiesStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteTargetHttpsProxyRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((TargetHttpsProxiesStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetTargetHttpsProxyRequest, TargetHttpsProxy> getSettings() {
    return ((TargetHttpsProxiesStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertTargetHttpsProxyRequest, Operation> insertSettings() {
    return ((TargetHttpsProxiesStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertTargetHttpsProxyRequest, Operation, Operation>
      insertOperationSettings() {
    return ((TargetHttpsProxiesStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListTargetHttpsProxiesRequest, TargetHttpsProxyList, ListPagedResponse>
      listSettings() {
    return ((TargetHttpsProxiesStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchTargetHttpsProxyRequest, Operation> patchSettings() {
    return ((TargetHttpsProxiesStubSettings) getStubSettings()).patchSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchTargetHttpsProxyRequest, Operation, Operation>
      patchOperationSettings() {
    return ((TargetHttpsProxiesStubSettings) getStubSettings()).patchOperationSettings();
  }

  /** Returns the object with the settings used for calls to setCertificateMap. */
  public UnaryCallSettings<SetCertificateMapTargetHttpsProxyRequest, Operation>
      setCertificateMapSettings() {
    return ((TargetHttpsProxiesStubSettings) getStubSettings()).setCertificateMapSettings();
  }

  /** Returns the object with the settings used for calls to setCertificateMap. */
  public OperationCallSettings<SetCertificateMapTargetHttpsProxyRequest, Operation, Operation>
      setCertificateMapOperationSettings() {
    return ((TargetHttpsProxiesStubSettings) getStubSettings())
        .setCertificateMapOperationSettings();
  }

  /** Returns the object with the settings used for calls to setQuicOverride. */
  public UnaryCallSettings<SetQuicOverrideTargetHttpsProxyRequest, Operation>
      setQuicOverrideSettings() {
    return ((TargetHttpsProxiesStubSettings) getStubSettings()).setQuicOverrideSettings();
  }

  /** Returns the object with the settings used for calls to setQuicOverride. */
  public OperationCallSettings<SetQuicOverrideTargetHttpsProxyRequest, Operation, Operation>
      setQuicOverrideOperationSettings() {
    return ((TargetHttpsProxiesStubSettings) getStubSettings()).setQuicOverrideOperationSettings();
  }

  /** Returns the object with the settings used for calls to setSslCertificates. */
  public UnaryCallSettings<SetSslCertificatesTargetHttpsProxyRequest, Operation>
      setSslCertificatesSettings() {
    return ((TargetHttpsProxiesStubSettings) getStubSettings()).setSslCertificatesSettings();
  }

  /** Returns the object with the settings used for calls to setSslCertificates. */
  public OperationCallSettings<SetSslCertificatesTargetHttpsProxyRequest, Operation, Operation>
      setSslCertificatesOperationSettings() {
    return ((TargetHttpsProxiesStubSettings) getStubSettings())
        .setSslCertificatesOperationSettings();
  }

  /** Returns the object with the settings used for calls to setSslPolicy. */
  public UnaryCallSettings<SetSslPolicyTargetHttpsProxyRequest, Operation> setSslPolicySettings() {
    return ((TargetHttpsProxiesStubSettings) getStubSettings()).setSslPolicySettings();
  }

  /** Returns the object with the settings used for calls to setSslPolicy. */
  public OperationCallSettings<SetSslPolicyTargetHttpsProxyRequest, Operation, Operation>
      setSslPolicyOperationSettings() {
    return ((TargetHttpsProxiesStubSettings) getStubSettings()).setSslPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to setUrlMap. */
  public UnaryCallSettings<SetUrlMapTargetHttpsProxyRequest, Operation> setUrlMapSettings() {
    return ((TargetHttpsProxiesStubSettings) getStubSettings()).setUrlMapSettings();
  }

  /** Returns the object with the settings used for calls to setUrlMap. */
  public OperationCallSettings<SetUrlMapTargetHttpsProxyRequest, Operation, Operation>
      setUrlMapOperationSettings() {
    return ((TargetHttpsProxiesStubSettings) getStubSettings()).setUrlMapOperationSettings();
  }

  public static final TargetHttpsProxiesSettings create(TargetHttpsProxiesStubSettings stub)
      throws IOException {
    return new TargetHttpsProxiesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return TargetHttpsProxiesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return TargetHttpsProxiesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return TargetHttpsProxiesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return TargetHttpsProxiesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return TargetHttpsProxiesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TargetHttpsProxiesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TargetHttpsProxiesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected TargetHttpsProxiesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for TargetHttpsProxiesSettings. */
  public static class Builder extends ClientSettings.Builder<TargetHttpsProxiesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(TargetHttpsProxiesStubSettings.newBuilder(clientContext));
    }

    protected Builder(TargetHttpsProxiesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(TargetHttpsProxiesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(TargetHttpsProxiesStubSettings.newBuilder());
    }

    public TargetHttpsProxiesStubSettings.Builder getStubSettingsBuilder() {
      return ((TargetHttpsProxiesStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListTargetHttpsProxiesRequest,
            TargetHttpsProxyAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings() {
      return getStubSettingsBuilder().aggregatedListSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteTargetHttpsProxyRequest, Operation> deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteTargetHttpsProxyRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetTargetHttpsProxyRequest, TargetHttpsProxy> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertTargetHttpsProxyRequest, Operation> insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertTargetHttpsProxyRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListTargetHttpsProxiesRequest, TargetHttpsProxyList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchTargetHttpsProxyRequest, Operation> patchSettings() {
      return getStubSettingsBuilder().patchSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<PatchTargetHttpsProxyRequest, Operation, Operation>
        patchOperationSettings() {
      return getStubSettingsBuilder().patchOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setCertificateMap. */
    public UnaryCallSettings.Builder<SetCertificateMapTargetHttpsProxyRequest, Operation>
        setCertificateMapSettings() {
      return getStubSettingsBuilder().setCertificateMapSettings();
    }

    /** Returns the builder for the settings used for calls to setCertificateMap. */
    public OperationCallSettings.Builder<
            SetCertificateMapTargetHttpsProxyRequest, Operation, Operation>
        setCertificateMapOperationSettings() {
      return getStubSettingsBuilder().setCertificateMapOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setQuicOverride. */
    public UnaryCallSettings.Builder<SetQuicOverrideTargetHttpsProxyRequest, Operation>
        setQuicOverrideSettings() {
      return getStubSettingsBuilder().setQuicOverrideSettings();
    }

    /** Returns the builder for the settings used for calls to setQuicOverride. */
    public OperationCallSettings.Builder<
            SetQuicOverrideTargetHttpsProxyRequest, Operation, Operation>
        setQuicOverrideOperationSettings() {
      return getStubSettingsBuilder().setQuicOverrideOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setSslCertificates. */
    public UnaryCallSettings.Builder<SetSslCertificatesTargetHttpsProxyRequest, Operation>
        setSslCertificatesSettings() {
      return getStubSettingsBuilder().setSslCertificatesSettings();
    }

    /** Returns the builder for the settings used for calls to setSslCertificates. */
    public OperationCallSettings.Builder<
            SetSslCertificatesTargetHttpsProxyRequest, Operation, Operation>
        setSslCertificatesOperationSettings() {
      return getStubSettingsBuilder().setSslCertificatesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setSslPolicy. */
    public UnaryCallSettings.Builder<SetSslPolicyTargetHttpsProxyRequest, Operation>
        setSslPolicySettings() {
      return getStubSettingsBuilder().setSslPolicySettings();
    }

    /** Returns the builder for the settings used for calls to setSslPolicy. */
    public OperationCallSettings.Builder<SetSslPolicyTargetHttpsProxyRequest, Operation, Operation>
        setSslPolicyOperationSettings() {
      return getStubSettingsBuilder().setSslPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setUrlMap. */
    public UnaryCallSettings.Builder<SetUrlMapTargetHttpsProxyRequest, Operation>
        setUrlMapSettings() {
      return getStubSettingsBuilder().setUrlMapSettings();
    }

    /** Returns the builder for the settings used for calls to setUrlMap. */
    public OperationCallSettings.Builder<SetUrlMapTargetHttpsProxyRequest, Operation, Operation>
        setUrlMapOperationSettings() {
      return getStubSettingsBuilder().setUrlMapOperationSettings();
    }

    @Override
    public TargetHttpsProxiesSettings build() throws IOException {
      return new TargetHttpsProxiesSettings(this);
    }
  }
}
