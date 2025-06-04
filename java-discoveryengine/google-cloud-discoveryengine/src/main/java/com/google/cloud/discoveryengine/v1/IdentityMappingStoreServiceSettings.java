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

import static com.google.cloud.discoveryengine.v1.IdentityMappingStoreServiceClient.ListIdentityMappingStoresPagedResponse;
import static com.google.cloud.discoveryengine.v1.IdentityMappingStoreServiceClient.ListIdentityMappingsPagedResponse;

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
import com.google.cloud.discoveryengine.v1.stub.IdentityMappingStoreServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link IdentityMappingStoreServiceClient}.
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
 * of createIdentityMappingStore:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IdentityMappingStoreServiceSettings.Builder identityMappingStoreServiceSettingsBuilder =
 *     IdentityMappingStoreServiceSettings.newBuilder();
 * identityMappingStoreServiceSettingsBuilder
 *     .createIdentityMappingStoreSettings()
 *     .setRetrySettings(
 *         identityMappingStoreServiceSettingsBuilder
 *             .createIdentityMappingStoreSettings()
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
 * IdentityMappingStoreServiceSettings identityMappingStoreServiceSettings =
 *     identityMappingStoreServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for deleteIdentityMappingStore:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IdentityMappingStoreServiceSettings.Builder identityMappingStoreServiceSettingsBuilder =
 *     IdentityMappingStoreServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * identityMappingStoreServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class IdentityMappingStoreServiceSettings
    extends ClientSettings<IdentityMappingStoreServiceSettings> {

  /** Returns the object with the settings used for calls to createIdentityMappingStore. */
  public UnaryCallSettings<CreateIdentityMappingStoreRequest, IdentityMappingStore>
      createIdentityMappingStoreSettings() {
    return ((IdentityMappingStoreServiceStubSettings) getStubSettings())
        .createIdentityMappingStoreSettings();
  }

  /** Returns the object with the settings used for calls to getIdentityMappingStore. */
  public UnaryCallSettings<GetIdentityMappingStoreRequest, IdentityMappingStore>
      getIdentityMappingStoreSettings() {
    return ((IdentityMappingStoreServiceStubSettings) getStubSettings())
        .getIdentityMappingStoreSettings();
  }

  /** Returns the object with the settings used for calls to deleteIdentityMappingStore. */
  public UnaryCallSettings<DeleteIdentityMappingStoreRequest, Operation>
      deleteIdentityMappingStoreSettings() {
    return ((IdentityMappingStoreServiceStubSettings) getStubSettings())
        .deleteIdentityMappingStoreSettings();
  }

  /** Returns the object with the settings used for calls to deleteIdentityMappingStore. */
  public OperationCallSettings<
          DeleteIdentityMappingStoreRequest, Empty, DeleteIdentityMappingStoreMetadata>
      deleteIdentityMappingStoreOperationSettings() {
    return ((IdentityMappingStoreServiceStubSettings) getStubSettings())
        .deleteIdentityMappingStoreOperationSettings();
  }

  /** Returns the object with the settings used for calls to importIdentityMappings. */
  public UnaryCallSettings<ImportIdentityMappingsRequest, Operation>
      importIdentityMappingsSettings() {
    return ((IdentityMappingStoreServiceStubSettings) getStubSettings())
        .importIdentityMappingsSettings();
  }

  /** Returns the object with the settings used for calls to importIdentityMappings. */
  public OperationCallSettings<
          ImportIdentityMappingsRequest,
          ImportIdentityMappingsResponse,
          IdentityMappingEntryOperationMetadata>
      importIdentityMappingsOperationSettings() {
    return ((IdentityMappingStoreServiceStubSettings) getStubSettings())
        .importIdentityMappingsOperationSettings();
  }

  /** Returns the object with the settings used for calls to purgeIdentityMappings. */
  public UnaryCallSettings<PurgeIdentityMappingsRequest, Operation>
      purgeIdentityMappingsSettings() {
    return ((IdentityMappingStoreServiceStubSettings) getStubSettings())
        .purgeIdentityMappingsSettings();
  }

  /** Returns the object with the settings used for calls to purgeIdentityMappings. */
  public OperationCallSettings<
          PurgeIdentityMappingsRequest, Empty, IdentityMappingEntryOperationMetadata>
      purgeIdentityMappingsOperationSettings() {
    return ((IdentityMappingStoreServiceStubSettings) getStubSettings())
        .purgeIdentityMappingsOperationSettings();
  }

  /** Returns the object with the settings used for calls to listIdentityMappings. */
  public PagedCallSettings<
          ListIdentityMappingsRequest,
          ListIdentityMappingsResponse,
          ListIdentityMappingsPagedResponse>
      listIdentityMappingsSettings() {
    return ((IdentityMappingStoreServiceStubSettings) getStubSettings())
        .listIdentityMappingsSettings();
  }

  /** Returns the object with the settings used for calls to listIdentityMappingStores. */
  public PagedCallSettings<
          ListIdentityMappingStoresRequest,
          ListIdentityMappingStoresResponse,
          ListIdentityMappingStoresPagedResponse>
      listIdentityMappingStoresSettings() {
    return ((IdentityMappingStoreServiceStubSettings) getStubSettings())
        .listIdentityMappingStoresSettings();
  }

  public static final IdentityMappingStoreServiceSettings create(
      IdentityMappingStoreServiceStubSettings stub) throws IOException {
    return new IdentityMappingStoreServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return IdentityMappingStoreServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return IdentityMappingStoreServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return IdentityMappingStoreServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return IdentityMappingStoreServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return IdentityMappingStoreServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return IdentityMappingStoreServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return IdentityMappingStoreServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return IdentityMappingStoreServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected IdentityMappingStoreServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for IdentityMappingStoreServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<IdentityMappingStoreServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(IdentityMappingStoreServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(IdentityMappingStoreServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(IdentityMappingStoreServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(IdentityMappingStoreServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(IdentityMappingStoreServiceStubSettings.newHttpJsonBuilder());
    }

    public IdentityMappingStoreServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((IdentityMappingStoreServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createIdentityMappingStore. */
    public UnaryCallSettings.Builder<CreateIdentityMappingStoreRequest, IdentityMappingStore>
        createIdentityMappingStoreSettings() {
      return getStubSettingsBuilder().createIdentityMappingStoreSettings();
    }

    /** Returns the builder for the settings used for calls to getIdentityMappingStore. */
    public UnaryCallSettings.Builder<GetIdentityMappingStoreRequest, IdentityMappingStore>
        getIdentityMappingStoreSettings() {
      return getStubSettingsBuilder().getIdentityMappingStoreSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIdentityMappingStore. */
    public UnaryCallSettings.Builder<DeleteIdentityMappingStoreRequest, Operation>
        deleteIdentityMappingStoreSettings() {
      return getStubSettingsBuilder().deleteIdentityMappingStoreSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIdentityMappingStore. */
    public OperationCallSettings.Builder<
            DeleteIdentityMappingStoreRequest, Empty, DeleteIdentityMappingStoreMetadata>
        deleteIdentityMappingStoreOperationSettings() {
      return getStubSettingsBuilder().deleteIdentityMappingStoreOperationSettings();
    }

    /** Returns the builder for the settings used for calls to importIdentityMappings. */
    public UnaryCallSettings.Builder<ImportIdentityMappingsRequest, Operation>
        importIdentityMappingsSettings() {
      return getStubSettingsBuilder().importIdentityMappingsSettings();
    }

    /** Returns the builder for the settings used for calls to importIdentityMappings. */
    public OperationCallSettings.Builder<
            ImportIdentityMappingsRequest,
            ImportIdentityMappingsResponse,
            IdentityMappingEntryOperationMetadata>
        importIdentityMappingsOperationSettings() {
      return getStubSettingsBuilder().importIdentityMappingsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to purgeIdentityMappings. */
    public UnaryCallSettings.Builder<PurgeIdentityMappingsRequest, Operation>
        purgeIdentityMappingsSettings() {
      return getStubSettingsBuilder().purgeIdentityMappingsSettings();
    }

    /** Returns the builder for the settings used for calls to purgeIdentityMappings. */
    public OperationCallSettings.Builder<
            PurgeIdentityMappingsRequest, Empty, IdentityMappingEntryOperationMetadata>
        purgeIdentityMappingsOperationSettings() {
      return getStubSettingsBuilder().purgeIdentityMappingsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listIdentityMappings. */
    public PagedCallSettings.Builder<
            ListIdentityMappingsRequest,
            ListIdentityMappingsResponse,
            ListIdentityMappingsPagedResponse>
        listIdentityMappingsSettings() {
      return getStubSettingsBuilder().listIdentityMappingsSettings();
    }

    /** Returns the builder for the settings used for calls to listIdentityMappingStores. */
    public PagedCallSettings.Builder<
            ListIdentityMappingStoresRequest,
            ListIdentityMappingStoresResponse,
            ListIdentityMappingStoresPagedResponse>
        listIdentityMappingStoresSettings() {
      return getStubSettingsBuilder().listIdentityMappingStoresSettings();
    }

    @Override
    public IdentityMappingStoreServiceSettings build() throws IOException {
      return new IdentityMappingStoreServiceSettings(this);
    }
  }
}
