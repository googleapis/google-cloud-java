/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.compute.v1.RegionTargetHttpsProxiesClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
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
import com.google.cloud.compute.v1.stub.RegionTargetHttpsProxiesStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RegionTargetHttpsProxiesClient}.
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
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of get:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionTargetHttpsProxiesSettings.Builder regionTargetHttpsProxiesSettingsBuilder =
 *     RegionTargetHttpsProxiesSettings.newBuilder();
 * regionTargetHttpsProxiesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         regionTargetHttpsProxiesSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * RegionTargetHttpsProxiesSettings regionTargetHttpsProxiesSettings =
 *     regionTargetHttpsProxiesSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for delete:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionTargetHttpsProxiesSettings.Builder regionTargetHttpsProxiesSettingsBuilder =
 *     RegionTargetHttpsProxiesSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * regionTargetHttpsProxiesSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RegionTargetHttpsProxiesSettings
    extends ClientSettings<RegionTargetHttpsProxiesSettings> {

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteRegionTargetHttpsProxyRequest, Operation> deleteSettings() {
    return ((RegionTargetHttpsProxiesStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteRegionTargetHttpsProxyRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((RegionTargetHttpsProxiesStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetRegionTargetHttpsProxyRequest, TargetHttpsProxy> getSettings() {
    return ((RegionTargetHttpsProxiesStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertRegionTargetHttpsProxyRequest, Operation> insertSettings() {
    return ((RegionTargetHttpsProxiesStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertRegionTargetHttpsProxyRequest, Operation, Operation>
      insertOperationSettings() {
    return ((RegionTargetHttpsProxiesStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<
          ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList, ListPagedResponse>
      listSettings() {
    return ((RegionTargetHttpsProxiesStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchRegionTargetHttpsProxyRequest, Operation> patchSettings() {
    return ((RegionTargetHttpsProxiesStubSettings) getStubSettings()).patchSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchRegionTargetHttpsProxyRequest, Operation, Operation>
      patchOperationSettings() {
    return ((RegionTargetHttpsProxiesStubSettings) getStubSettings()).patchOperationSettings();
  }

  /** Returns the object with the settings used for calls to setSslCertificates. */
  public UnaryCallSettings<SetSslCertificatesRegionTargetHttpsProxyRequest, Operation>
      setSslCertificatesSettings() {
    return ((RegionTargetHttpsProxiesStubSettings) getStubSettings()).setSslCertificatesSettings();
  }

  /** Returns the object with the settings used for calls to setSslCertificates. */
  public OperationCallSettings<
          SetSslCertificatesRegionTargetHttpsProxyRequest, Operation, Operation>
      setSslCertificatesOperationSettings() {
    return ((RegionTargetHttpsProxiesStubSettings) getStubSettings())
        .setSslCertificatesOperationSettings();
  }

  /** Returns the object with the settings used for calls to setUrlMap. */
  public UnaryCallSettings<SetUrlMapRegionTargetHttpsProxyRequest, Operation> setUrlMapSettings() {
    return ((RegionTargetHttpsProxiesStubSettings) getStubSettings()).setUrlMapSettings();
  }

  /** Returns the object with the settings used for calls to setUrlMap. */
  public OperationCallSettings<SetUrlMapRegionTargetHttpsProxyRequest, Operation, Operation>
      setUrlMapOperationSettings() {
    return ((RegionTargetHttpsProxiesStubSettings) getStubSettings()).setUrlMapOperationSettings();
  }

  public static final RegionTargetHttpsProxiesSettings create(
      RegionTargetHttpsProxiesStubSettings stub) throws IOException {
    return new RegionTargetHttpsProxiesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RegionTargetHttpsProxiesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RegionTargetHttpsProxiesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RegionTargetHttpsProxiesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RegionTargetHttpsProxiesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RegionTargetHttpsProxiesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RegionTargetHttpsProxiesStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RegionTargetHttpsProxiesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RegionTargetHttpsProxiesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RegionTargetHttpsProxiesSettings. */
  public static class Builder
      extends ClientSettings.Builder<RegionTargetHttpsProxiesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(RegionTargetHttpsProxiesStubSettings.newBuilder(clientContext));
    }

    protected Builder(RegionTargetHttpsProxiesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RegionTargetHttpsProxiesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(RegionTargetHttpsProxiesStubSettings.newBuilder());
    }

    public RegionTargetHttpsProxiesStubSettings.Builder getStubSettingsBuilder() {
      return ((RegionTargetHttpsProxiesStubSettings.Builder) getStubSettings());
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
    public UnaryCallSettings.Builder<DeleteRegionTargetHttpsProxyRequest, Operation>
        deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteRegionTargetHttpsProxyRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetRegionTargetHttpsProxyRequest, TargetHttpsProxy>
        getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertRegionTargetHttpsProxyRequest, Operation>
        insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertRegionTargetHttpsProxyRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListRegionTargetHttpsProxiesRequest, TargetHttpsProxyList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchRegionTargetHttpsProxyRequest, Operation>
        patchSettings() {
      return getStubSettingsBuilder().patchSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<PatchRegionTargetHttpsProxyRequest, Operation, Operation>
        patchOperationSettings() {
      return getStubSettingsBuilder().patchOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setSslCertificates. */
    public UnaryCallSettings.Builder<SetSslCertificatesRegionTargetHttpsProxyRequest, Operation>
        setSslCertificatesSettings() {
      return getStubSettingsBuilder().setSslCertificatesSettings();
    }

    /** Returns the builder for the settings used for calls to setSslCertificates. */
    public OperationCallSettings.Builder<
            SetSslCertificatesRegionTargetHttpsProxyRequest, Operation, Operation>
        setSslCertificatesOperationSettings() {
      return getStubSettingsBuilder().setSslCertificatesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setUrlMap. */
    public UnaryCallSettings.Builder<SetUrlMapRegionTargetHttpsProxyRequest, Operation>
        setUrlMapSettings() {
      return getStubSettingsBuilder().setUrlMapSettings();
    }

    /** Returns the builder for the settings used for calls to setUrlMap. */
    public OperationCallSettings.Builder<
            SetUrlMapRegionTargetHttpsProxyRequest, Operation, Operation>
        setUrlMapOperationSettings() {
      return getStubSettingsBuilder().setUrlMapOperationSettings();
    }

    @Override
    public RegionTargetHttpsProxiesSettings build() throws IOException {
      return new RegionTargetHttpsProxiesSettings(this);
    }
  }
}
