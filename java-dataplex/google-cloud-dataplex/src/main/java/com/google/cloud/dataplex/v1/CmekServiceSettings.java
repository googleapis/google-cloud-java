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

package com.google.cloud.dataplex.v1;

import static com.google.cloud.dataplex.v1.CmekServiceClient.ListEncryptionConfigsPagedResponse;
import static com.google.cloud.dataplex.v1.CmekServiceClient.ListLocationsPagedResponse;

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
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.dataplex.v1.stub.CmekServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CmekServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataplex.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getEncryptionConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CmekServiceSettings.Builder cmekServiceSettingsBuilder = CmekServiceSettings.newBuilder();
 * cmekServiceSettingsBuilder
 *     .getEncryptionConfigSettings()
 *     .setRetrySettings(
 *         cmekServiceSettingsBuilder
 *             .getEncryptionConfigSettings()
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
 * CmekServiceSettings cmekServiceSettings = cmekServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createEncryptionConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CmekServiceSettings.Builder cmekServiceSettingsBuilder = CmekServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * cmekServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CmekServiceSettings extends ClientSettings<CmekServiceSettings> {

  /** Returns the object with the settings used for calls to createEncryptionConfig. */
  public UnaryCallSettings<CreateEncryptionConfigRequest, Operation>
      createEncryptionConfigSettings() {
    return ((CmekServiceStubSettings) getStubSettings()).createEncryptionConfigSettings();
  }

  /** Returns the object with the settings used for calls to createEncryptionConfig. */
  public OperationCallSettings<CreateEncryptionConfigRequest, EncryptionConfig, OperationMetadata>
      createEncryptionConfigOperationSettings() {
    return ((CmekServiceStubSettings) getStubSettings()).createEncryptionConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateEncryptionConfig. */
  public UnaryCallSettings<UpdateEncryptionConfigRequest, Operation>
      updateEncryptionConfigSettings() {
    return ((CmekServiceStubSettings) getStubSettings()).updateEncryptionConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateEncryptionConfig. */
  public OperationCallSettings<UpdateEncryptionConfigRequest, EncryptionConfig, OperationMetadata>
      updateEncryptionConfigOperationSettings() {
    return ((CmekServiceStubSettings) getStubSettings()).updateEncryptionConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteEncryptionConfig. */
  public UnaryCallSettings<DeleteEncryptionConfigRequest, Operation>
      deleteEncryptionConfigSettings() {
    return ((CmekServiceStubSettings) getStubSettings()).deleteEncryptionConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteEncryptionConfig. */
  public OperationCallSettings<DeleteEncryptionConfigRequest, Empty, OperationMetadata>
      deleteEncryptionConfigOperationSettings() {
    return ((CmekServiceStubSettings) getStubSettings()).deleteEncryptionConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to listEncryptionConfigs. */
  public PagedCallSettings<
          ListEncryptionConfigsRequest,
          ListEncryptionConfigsResponse,
          ListEncryptionConfigsPagedResponse>
      listEncryptionConfigsSettings() {
    return ((CmekServiceStubSettings) getStubSettings()).listEncryptionConfigsSettings();
  }

  /** Returns the object with the settings used for calls to getEncryptionConfig. */
  public UnaryCallSettings<GetEncryptionConfigRequest, EncryptionConfig>
      getEncryptionConfigSettings() {
    return ((CmekServiceStubSettings) getStubSettings()).getEncryptionConfigSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((CmekServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((CmekServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final CmekServiceSettings create(CmekServiceStubSettings stub) throws IOException {
    return new CmekServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CmekServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CmekServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CmekServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CmekServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return CmekServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CmekServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CmekServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CmekServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected CmekServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CmekServiceSettings. */
  public static class Builder extends ClientSettings.Builder<CmekServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(CmekServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(CmekServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CmekServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CmekServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(CmekServiceStubSettings.newHttpJsonBuilder());
    }

    public CmekServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((CmekServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createEncryptionConfig. */
    public UnaryCallSettings.Builder<CreateEncryptionConfigRequest, Operation>
        createEncryptionConfigSettings() {
      return getStubSettingsBuilder().createEncryptionConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createEncryptionConfig. */
    public OperationCallSettings.Builder<
            CreateEncryptionConfigRequest, EncryptionConfig, OperationMetadata>
        createEncryptionConfigOperationSettings() {
      return getStubSettingsBuilder().createEncryptionConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateEncryptionConfig. */
    public UnaryCallSettings.Builder<UpdateEncryptionConfigRequest, Operation>
        updateEncryptionConfigSettings() {
      return getStubSettingsBuilder().updateEncryptionConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateEncryptionConfig. */
    public OperationCallSettings.Builder<
            UpdateEncryptionConfigRequest, EncryptionConfig, OperationMetadata>
        updateEncryptionConfigOperationSettings() {
      return getStubSettingsBuilder().updateEncryptionConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEncryptionConfig. */
    public UnaryCallSettings.Builder<DeleteEncryptionConfigRequest, Operation>
        deleteEncryptionConfigSettings() {
      return getStubSettingsBuilder().deleteEncryptionConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEncryptionConfig. */
    public OperationCallSettings.Builder<DeleteEncryptionConfigRequest, Empty, OperationMetadata>
        deleteEncryptionConfigOperationSettings() {
      return getStubSettingsBuilder().deleteEncryptionConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listEncryptionConfigs. */
    public PagedCallSettings.Builder<
            ListEncryptionConfigsRequest,
            ListEncryptionConfigsResponse,
            ListEncryptionConfigsPagedResponse>
        listEncryptionConfigsSettings() {
      return getStubSettingsBuilder().listEncryptionConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to getEncryptionConfig. */
    public UnaryCallSettings.Builder<GetEncryptionConfigRequest, EncryptionConfig>
        getEncryptionConfigSettings() {
      return getStubSettingsBuilder().getEncryptionConfigSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    @Override
    public CmekServiceSettings build() throws IOException {
      return new CmekServiceSettings(this);
    }
  }
}
