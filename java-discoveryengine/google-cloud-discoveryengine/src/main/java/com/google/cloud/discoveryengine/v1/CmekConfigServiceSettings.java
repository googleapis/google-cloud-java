/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.discoveryengine.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.discoveryengine.v1.stub.CmekConfigServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CmekConfigServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (discoveryengine.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getCmekConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CmekConfigServiceSettings.Builder cmekConfigServiceSettingsBuilder =
 *     CmekConfigServiceSettings.newBuilder();
 * cmekConfigServiceSettingsBuilder
 *     .getCmekConfigSettings()
 *     .setRetrySettings(
 *         cmekConfigServiceSettingsBuilder
 *             .getCmekConfigSettings()
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
 * CmekConfigServiceSettings cmekConfigServiceSettings = cmekConfigServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for updateCmekConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CmekConfigServiceSettings.Builder cmekConfigServiceSettingsBuilder =
 *     CmekConfigServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * cmekConfigServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CmekConfigServiceSettings extends ClientSettings<CmekConfigServiceSettings> {

  /** Returns the object with the settings used for calls to updateCmekConfig. */
  public UnaryCallSettings<UpdateCmekConfigRequest, Operation> updateCmekConfigSettings() {
    return ((CmekConfigServiceStubSettings) getStubSettings()).updateCmekConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateCmekConfig. */
  public OperationCallSettings<UpdateCmekConfigRequest, CmekConfig, UpdateCmekConfigMetadata>
      updateCmekConfigOperationSettings() {
    return ((CmekConfigServiceStubSettings) getStubSettings()).updateCmekConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to getCmekConfig. */
  public UnaryCallSettings<GetCmekConfigRequest, CmekConfig> getCmekConfigSettings() {
    return ((CmekConfigServiceStubSettings) getStubSettings()).getCmekConfigSettings();
  }

  /** Returns the object with the settings used for calls to listCmekConfigs. */
  public UnaryCallSettings<ListCmekConfigsRequest, ListCmekConfigsResponse>
      listCmekConfigsSettings() {
    return ((CmekConfigServiceStubSettings) getStubSettings()).listCmekConfigsSettings();
  }

  /** Returns the object with the settings used for calls to deleteCmekConfig. */
  public UnaryCallSettings<DeleteCmekConfigRequest, Operation> deleteCmekConfigSettings() {
    return ((CmekConfigServiceStubSettings) getStubSettings()).deleteCmekConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteCmekConfig. */
  public OperationCallSettings<DeleteCmekConfigRequest, Empty, DeleteCmekConfigMetadata>
      deleteCmekConfigOperationSettings() {
    return ((CmekConfigServiceStubSettings) getStubSettings()).deleteCmekConfigOperationSettings();
  }

  public static final CmekConfigServiceSettings create(CmekConfigServiceStubSettings stub)
      throws IOException {
    return new CmekConfigServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CmekConfigServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CmekConfigServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CmekConfigServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CmekConfigServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return CmekConfigServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CmekConfigServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CmekConfigServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CmekConfigServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected CmekConfigServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CmekConfigServiceSettings. */
  public static class Builder extends ClientSettings.Builder<CmekConfigServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(CmekConfigServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(CmekConfigServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CmekConfigServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CmekConfigServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(CmekConfigServiceStubSettings.newHttpJsonBuilder());
    }

    public CmekConfigServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((CmekConfigServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to updateCmekConfig. */
    public UnaryCallSettings.Builder<UpdateCmekConfigRequest, Operation>
        updateCmekConfigSettings() {
      return getStubSettingsBuilder().updateCmekConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateCmekConfig. */
    public OperationCallSettings.Builder<
            UpdateCmekConfigRequest, CmekConfig, UpdateCmekConfigMetadata>
        updateCmekConfigOperationSettings() {
      return getStubSettingsBuilder().updateCmekConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getCmekConfig. */
    public UnaryCallSettings.Builder<GetCmekConfigRequest, CmekConfig> getCmekConfigSettings() {
      return getStubSettingsBuilder().getCmekConfigSettings();
    }

    /** Returns the builder for the settings used for calls to listCmekConfigs. */
    public UnaryCallSettings.Builder<ListCmekConfigsRequest, ListCmekConfigsResponse>
        listCmekConfigsSettings() {
      return getStubSettingsBuilder().listCmekConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCmekConfig. */
    public UnaryCallSettings.Builder<DeleteCmekConfigRequest, Operation>
        deleteCmekConfigSettings() {
      return getStubSettingsBuilder().deleteCmekConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCmekConfig. */
    public OperationCallSettings.Builder<DeleteCmekConfigRequest, Empty, DeleteCmekConfigMetadata>
        deleteCmekConfigOperationSettings() {
      return getStubSettingsBuilder().deleteCmekConfigOperationSettings();
    }

    @Override
    public CmekConfigServiceSettings build() throws IOException {
      return new CmekConfigServiceSettings(this);
    }
  }
}
