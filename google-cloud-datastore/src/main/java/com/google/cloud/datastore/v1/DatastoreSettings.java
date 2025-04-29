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

package com.google.cloud.datastore.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.datastore.v1.stub.DatastoreStubSettings;
import com.google.datastore.v1.AllocateIdsRequest;
import com.google.datastore.v1.AllocateIdsResponse;
import com.google.datastore.v1.BeginTransactionRequest;
import com.google.datastore.v1.BeginTransactionResponse;
import com.google.datastore.v1.CommitRequest;
import com.google.datastore.v1.CommitResponse;
import com.google.datastore.v1.LookupRequest;
import com.google.datastore.v1.LookupResponse;
import com.google.datastore.v1.ReserveIdsRequest;
import com.google.datastore.v1.ReserveIdsResponse;
import com.google.datastore.v1.RollbackRequest;
import com.google.datastore.v1.RollbackResponse;
import com.google.datastore.v1.RunAggregationQueryRequest;
import com.google.datastore.v1.RunAggregationQueryResponse;
import com.google.datastore.v1.RunQueryRequest;
import com.google.datastore.v1.RunQueryResponse;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DatastoreClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (datastore.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of lookup:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DatastoreSettings.Builder datastoreSettingsBuilder = DatastoreSettings.newBuilder();
 * datastoreSettingsBuilder
 *     .lookupSettings()
 *     .setRetrySettings(
 *         datastoreSettingsBuilder
 *             .lookupSettings()
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
 * DatastoreSettings datastoreSettings = datastoreSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class DatastoreSettings extends ClientSettings<DatastoreSettings> {

  /** Returns the object with the settings used for calls to lookup. */
  public UnaryCallSettings<LookupRequest, LookupResponse> lookupSettings() {
    return ((DatastoreStubSettings) getStubSettings()).lookupSettings();
  }

  /** Returns the object with the settings used for calls to runQuery. */
  public UnaryCallSettings<RunQueryRequest, RunQueryResponse> runQuerySettings() {
    return ((DatastoreStubSettings) getStubSettings()).runQuerySettings();
  }

  /** Returns the object with the settings used for calls to runAggregationQuery. */
  public UnaryCallSettings<RunAggregationQueryRequest, RunAggregationQueryResponse>
      runAggregationQuerySettings() {
    return ((DatastoreStubSettings) getStubSettings()).runAggregationQuerySettings();
  }

  /** Returns the object with the settings used for calls to beginTransaction. */
  public UnaryCallSettings<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionSettings() {
    return ((DatastoreStubSettings) getStubSettings()).beginTransactionSettings();
  }

  /** Returns the object with the settings used for calls to commit. */
  public UnaryCallSettings<CommitRequest, CommitResponse> commitSettings() {
    return ((DatastoreStubSettings) getStubSettings()).commitSettings();
  }

  /** Returns the object with the settings used for calls to rollback. */
  public UnaryCallSettings<RollbackRequest, RollbackResponse> rollbackSettings() {
    return ((DatastoreStubSettings) getStubSettings()).rollbackSettings();
  }

  /** Returns the object with the settings used for calls to allocateIds. */
  public UnaryCallSettings<AllocateIdsRequest, AllocateIdsResponse> allocateIdsSettings() {
    return ((DatastoreStubSettings) getStubSettings()).allocateIdsSettings();
  }

  /** Returns the object with the settings used for calls to reserveIds. */
  public UnaryCallSettings<ReserveIdsRequest, ReserveIdsResponse> reserveIdsSettings() {
    return ((DatastoreStubSettings) getStubSettings()).reserveIdsSettings();
  }

  public static final DatastoreSettings create(DatastoreStubSettings stub) throws IOException {
    return new DatastoreSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DatastoreStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DatastoreStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DatastoreStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DatastoreStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DatastoreStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DatastoreStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DatastoreStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DatastoreStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DatastoreSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DatastoreSettings. */
  public static class Builder extends ClientSettings.Builder<DatastoreSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DatastoreStubSettings.newBuilder(clientContext));
    }

    protected Builder(DatastoreSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DatastoreStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DatastoreStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(DatastoreStubSettings.newHttpJsonBuilder());
    }

    public DatastoreStubSettings.Builder getStubSettingsBuilder() {
      return ((DatastoreStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to lookup. */
    public UnaryCallSettings.Builder<LookupRequest, LookupResponse> lookupSettings() {
      return getStubSettingsBuilder().lookupSettings();
    }

    /** Returns the builder for the settings used for calls to runQuery. */
    public UnaryCallSettings.Builder<RunQueryRequest, RunQueryResponse> runQuerySettings() {
      return getStubSettingsBuilder().runQuerySettings();
    }

    /** Returns the builder for the settings used for calls to runAggregationQuery. */
    public UnaryCallSettings.Builder<RunAggregationQueryRequest, RunAggregationQueryResponse>
        runAggregationQuerySettings() {
      return getStubSettingsBuilder().runAggregationQuerySettings();
    }

    /** Returns the builder for the settings used for calls to beginTransaction. */
    public UnaryCallSettings.Builder<BeginTransactionRequest, BeginTransactionResponse>
        beginTransactionSettings() {
      return getStubSettingsBuilder().beginTransactionSettings();
    }

    /** Returns the builder for the settings used for calls to commit. */
    public UnaryCallSettings.Builder<CommitRequest, CommitResponse> commitSettings() {
      return getStubSettingsBuilder().commitSettings();
    }

    /** Returns the builder for the settings used for calls to rollback. */
    public UnaryCallSettings.Builder<RollbackRequest, RollbackResponse> rollbackSettings() {
      return getStubSettingsBuilder().rollbackSettings();
    }

    /** Returns the builder for the settings used for calls to allocateIds. */
    public UnaryCallSettings.Builder<AllocateIdsRequest, AllocateIdsResponse>
        allocateIdsSettings() {
      return getStubSettingsBuilder().allocateIdsSettings();
    }

    /** Returns the builder for the settings used for calls to reserveIds. */
    public UnaryCallSettings.Builder<ReserveIdsRequest, ReserveIdsResponse> reserveIdsSettings() {
      return getStubSettingsBuilder().reserveIdsSettings();
    }

    @Override
    public DatastoreSettings build() throws IOException {
      return new DatastoreSettings(this);
    }
  }
}
