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

package com.google.cloud.chronicle.v1;

import static com.google.cloud.chronicle.v1.DataAccessControlServiceClient.ListDataAccessLabelsPagedResponse;
import static com.google.cloud.chronicle.v1.DataAccessControlServiceClient.ListDataAccessScopesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.chronicle.v1.stub.DataAccessControlServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataAccessControlServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (chronicle.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createDataAccessLabel:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataAccessControlServiceSettings.Builder dataAccessControlServiceSettingsBuilder =
 *     DataAccessControlServiceSettings.newBuilder();
 * dataAccessControlServiceSettingsBuilder
 *     .createDataAccessLabelSettings()
 *     .setRetrySettings(
 *         dataAccessControlServiceSettingsBuilder
 *             .createDataAccessLabelSettings()
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
 * DataAccessControlServiceSettings dataAccessControlServiceSettings =
 *     dataAccessControlServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class DataAccessControlServiceSettings
    extends ClientSettings<DataAccessControlServiceSettings> {

  /** Returns the object with the settings used for calls to createDataAccessLabel. */
  public UnaryCallSettings<CreateDataAccessLabelRequest, DataAccessLabel>
      createDataAccessLabelSettings() {
    return ((DataAccessControlServiceStubSettings) getStubSettings())
        .createDataAccessLabelSettings();
  }

  /** Returns the object with the settings used for calls to getDataAccessLabel. */
  public UnaryCallSettings<GetDataAccessLabelRequest, DataAccessLabel>
      getDataAccessLabelSettings() {
    return ((DataAccessControlServiceStubSettings) getStubSettings()).getDataAccessLabelSettings();
  }

  /** Returns the object with the settings used for calls to listDataAccessLabels. */
  public PagedCallSettings<
          ListDataAccessLabelsRequest,
          ListDataAccessLabelsResponse,
          ListDataAccessLabelsPagedResponse>
      listDataAccessLabelsSettings() {
    return ((DataAccessControlServiceStubSettings) getStubSettings())
        .listDataAccessLabelsSettings();
  }

  /** Returns the object with the settings used for calls to updateDataAccessLabel. */
  public UnaryCallSettings<UpdateDataAccessLabelRequest, DataAccessLabel>
      updateDataAccessLabelSettings() {
    return ((DataAccessControlServiceStubSettings) getStubSettings())
        .updateDataAccessLabelSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataAccessLabel. */
  public UnaryCallSettings<DeleteDataAccessLabelRequest, Empty> deleteDataAccessLabelSettings() {
    return ((DataAccessControlServiceStubSettings) getStubSettings())
        .deleteDataAccessLabelSettings();
  }

  /** Returns the object with the settings used for calls to createDataAccessScope. */
  public UnaryCallSettings<CreateDataAccessScopeRequest, DataAccessScope>
      createDataAccessScopeSettings() {
    return ((DataAccessControlServiceStubSettings) getStubSettings())
        .createDataAccessScopeSettings();
  }

  /** Returns the object with the settings used for calls to getDataAccessScope. */
  public UnaryCallSettings<GetDataAccessScopeRequest, DataAccessScope>
      getDataAccessScopeSettings() {
    return ((DataAccessControlServiceStubSettings) getStubSettings()).getDataAccessScopeSettings();
  }

  /** Returns the object with the settings used for calls to listDataAccessScopes. */
  public PagedCallSettings<
          ListDataAccessScopesRequest,
          ListDataAccessScopesResponse,
          ListDataAccessScopesPagedResponse>
      listDataAccessScopesSettings() {
    return ((DataAccessControlServiceStubSettings) getStubSettings())
        .listDataAccessScopesSettings();
  }

  /** Returns the object with the settings used for calls to updateDataAccessScope. */
  public UnaryCallSettings<UpdateDataAccessScopeRequest, DataAccessScope>
      updateDataAccessScopeSettings() {
    return ((DataAccessControlServiceStubSettings) getStubSettings())
        .updateDataAccessScopeSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataAccessScope. */
  public UnaryCallSettings<DeleteDataAccessScopeRequest, Empty> deleteDataAccessScopeSettings() {
    return ((DataAccessControlServiceStubSettings) getStubSettings())
        .deleteDataAccessScopeSettings();
  }

  public static final DataAccessControlServiceSettings create(
      DataAccessControlServiceStubSettings stub) throws IOException {
    return new DataAccessControlServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DataAccessControlServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DataAccessControlServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DataAccessControlServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DataAccessControlServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DataAccessControlServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DataAccessControlServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DataAccessControlServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataAccessControlServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DataAccessControlServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DataAccessControlServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<DataAccessControlServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DataAccessControlServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DataAccessControlServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DataAccessControlServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DataAccessControlServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(DataAccessControlServiceStubSettings.newHttpJsonBuilder());
    }

    public DataAccessControlServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DataAccessControlServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createDataAccessLabel. */
    public UnaryCallSettings.Builder<CreateDataAccessLabelRequest, DataAccessLabel>
        createDataAccessLabelSettings() {
      return getStubSettingsBuilder().createDataAccessLabelSettings();
    }

    /** Returns the builder for the settings used for calls to getDataAccessLabel. */
    public UnaryCallSettings.Builder<GetDataAccessLabelRequest, DataAccessLabel>
        getDataAccessLabelSettings() {
      return getStubSettingsBuilder().getDataAccessLabelSettings();
    }

    /** Returns the builder for the settings used for calls to listDataAccessLabels. */
    public PagedCallSettings.Builder<
            ListDataAccessLabelsRequest,
            ListDataAccessLabelsResponse,
            ListDataAccessLabelsPagedResponse>
        listDataAccessLabelsSettings() {
      return getStubSettingsBuilder().listDataAccessLabelsSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataAccessLabel. */
    public UnaryCallSettings.Builder<UpdateDataAccessLabelRequest, DataAccessLabel>
        updateDataAccessLabelSettings() {
      return getStubSettingsBuilder().updateDataAccessLabelSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataAccessLabel. */
    public UnaryCallSettings.Builder<DeleteDataAccessLabelRequest, Empty>
        deleteDataAccessLabelSettings() {
      return getStubSettingsBuilder().deleteDataAccessLabelSettings();
    }

    /** Returns the builder for the settings used for calls to createDataAccessScope. */
    public UnaryCallSettings.Builder<CreateDataAccessScopeRequest, DataAccessScope>
        createDataAccessScopeSettings() {
      return getStubSettingsBuilder().createDataAccessScopeSettings();
    }

    /** Returns the builder for the settings used for calls to getDataAccessScope. */
    public UnaryCallSettings.Builder<GetDataAccessScopeRequest, DataAccessScope>
        getDataAccessScopeSettings() {
      return getStubSettingsBuilder().getDataAccessScopeSettings();
    }

    /** Returns the builder for the settings used for calls to listDataAccessScopes. */
    public PagedCallSettings.Builder<
            ListDataAccessScopesRequest,
            ListDataAccessScopesResponse,
            ListDataAccessScopesPagedResponse>
        listDataAccessScopesSettings() {
      return getStubSettingsBuilder().listDataAccessScopesSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataAccessScope. */
    public UnaryCallSettings.Builder<UpdateDataAccessScopeRequest, DataAccessScope>
        updateDataAccessScopeSettings() {
      return getStubSettingsBuilder().updateDataAccessScopeSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataAccessScope. */
    public UnaryCallSettings.Builder<DeleteDataAccessScopeRequest, Empty>
        deleteDataAccessScopeSettings() {
      return getStubSettingsBuilder().deleteDataAccessScopeSettings();
    }

    @Override
    public DataAccessControlServiceSettings build() throws IOException {
      return new DataAccessControlServiceSettings(this);
    }
  }
}
