/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.biglake.hive.v1beta;

import static com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient.ListHiveCatalogsPagedResponse;
import static com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient.ListHiveDatabasesPagedResponse;
import static com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient.ListHiveTablesPagedResponse;

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
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.biglake.hive.v1beta.stub.HiveMetastoreServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link HiveMetastoreServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (biglake.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createHiveCatalog:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * HiveMetastoreServiceSettings.Builder hiveMetastoreServiceSettingsBuilder =
 *     HiveMetastoreServiceSettings.newBuilder();
 * hiveMetastoreServiceSettingsBuilder
 *     .createHiveCatalogSettings()
 *     .setRetrySettings(
 *         hiveMetastoreServiceSettingsBuilder
 *             .createHiveCatalogSettings()
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
 * HiveMetastoreServiceSettings hiveMetastoreServiceSettings =
 *     hiveMetastoreServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HiveMetastoreServiceSettings extends ClientSettings<HiveMetastoreServiceSettings> {

  /** Returns the object with the settings used for calls to createHiveCatalog. */
  public UnaryCallSettings<CreateHiveCatalogRequest, HiveCatalog> createHiveCatalogSettings() {
    return ((HiveMetastoreServiceStubSettings) getStubSettings()).createHiveCatalogSettings();
  }

  /** Returns the object with the settings used for calls to getHiveCatalog. */
  public UnaryCallSettings<GetHiveCatalogRequest, HiveCatalog> getHiveCatalogSettings() {
    return ((HiveMetastoreServiceStubSettings) getStubSettings()).getHiveCatalogSettings();
  }

  /** Returns the object with the settings used for calls to listHiveCatalogs. */
  public PagedCallSettings<
          ListHiveCatalogsRequest, ListHiveCatalogsResponse, ListHiveCatalogsPagedResponse>
      listHiveCatalogsSettings() {
    return ((HiveMetastoreServiceStubSettings) getStubSettings()).listHiveCatalogsSettings();
  }

  /** Returns the object with the settings used for calls to updateHiveCatalog. */
  public UnaryCallSettings<UpdateHiveCatalogRequest, HiveCatalog> updateHiveCatalogSettings() {
    return ((HiveMetastoreServiceStubSettings) getStubSettings()).updateHiveCatalogSettings();
  }

  /** Returns the object with the settings used for calls to deleteHiveCatalog. */
  public UnaryCallSettings<DeleteHiveCatalogRequest, Empty> deleteHiveCatalogSettings() {
    return ((HiveMetastoreServiceStubSettings) getStubSettings()).deleteHiveCatalogSettings();
  }

  /** Returns the object with the settings used for calls to createHiveDatabase. */
  public UnaryCallSettings<CreateHiveDatabaseRequest, HiveDatabase> createHiveDatabaseSettings() {
    return ((HiveMetastoreServiceStubSettings) getStubSettings()).createHiveDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to getHiveDatabase. */
  public UnaryCallSettings<GetHiveDatabaseRequest, HiveDatabase> getHiveDatabaseSettings() {
    return ((HiveMetastoreServiceStubSettings) getStubSettings()).getHiveDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to listHiveDatabases. */
  public PagedCallSettings<
          ListHiveDatabasesRequest, ListHiveDatabasesResponse, ListHiveDatabasesPagedResponse>
      listHiveDatabasesSettings() {
    return ((HiveMetastoreServiceStubSettings) getStubSettings()).listHiveDatabasesSettings();
  }

  /** Returns the object with the settings used for calls to updateHiveDatabase. */
  public UnaryCallSettings<UpdateHiveDatabaseRequest, HiveDatabase> updateHiveDatabaseSettings() {
    return ((HiveMetastoreServiceStubSettings) getStubSettings()).updateHiveDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to deleteHiveDatabase. */
  public UnaryCallSettings<DeleteHiveDatabaseRequest, Empty> deleteHiveDatabaseSettings() {
    return ((HiveMetastoreServiceStubSettings) getStubSettings()).deleteHiveDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to createHiveTable. */
  public UnaryCallSettings<CreateHiveTableRequest, HiveTable> createHiveTableSettings() {
    return ((HiveMetastoreServiceStubSettings) getStubSettings()).createHiveTableSettings();
  }

  /** Returns the object with the settings used for calls to getHiveTable. */
  public UnaryCallSettings<GetHiveTableRequest, HiveTable> getHiveTableSettings() {
    return ((HiveMetastoreServiceStubSettings) getStubSettings()).getHiveTableSettings();
  }

  /** Returns the object with the settings used for calls to listHiveTables. */
  public PagedCallSettings<
          ListHiveTablesRequest, ListHiveTablesResponse, ListHiveTablesPagedResponse>
      listHiveTablesSettings() {
    return ((HiveMetastoreServiceStubSettings) getStubSettings()).listHiveTablesSettings();
  }

  /** Returns the object with the settings used for calls to updateHiveTable. */
  public UnaryCallSettings<UpdateHiveTableRequest, HiveTable> updateHiveTableSettings() {
    return ((HiveMetastoreServiceStubSettings) getStubSettings()).updateHiveTableSettings();
  }

  /** Returns the object with the settings used for calls to deleteHiveTable. */
  public UnaryCallSettings<DeleteHiveTableRequest, Empty> deleteHiveTableSettings() {
    return ((HiveMetastoreServiceStubSettings) getStubSettings()).deleteHiveTableSettings();
  }

  /** Returns the object with the settings used for calls to batchCreatePartitions. */
  public UnaryCallSettings<BatchCreatePartitionsRequest, BatchCreatePartitionsResponse>
      batchCreatePartitionsSettings() {
    return ((HiveMetastoreServiceStubSettings) getStubSettings()).batchCreatePartitionsSettings();
  }

  /** Returns the object with the settings used for calls to batchDeletePartitions. */
  public UnaryCallSettings<BatchDeletePartitionsRequest, Empty> batchDeletePartitionsSettings() {
    return ((HiveMetastoreServiceStubSettings) getStubSettings()).batchDeletePartitionsSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdatePartitions. */
  public UnaryCallSettings<BatchUpdatePartitionsRequest, BatchUpdatePartitionsResponse>
      batchUpdatePartitionsSettings() {
    return ((HiveMetastoreServiceStubSettings) getStubSettings()).batchUpdatePartitionsSettings();
  }

  /** Returns the object with the settings used for calls to listPartitions. */
  public ServerStreamingCallSettings<ListPartitionsRequest, ListPartitionsResponse>
      listPartitionsSettings() {
    return ((HiveMetastoreServiceStubSettings) getStubSettings()).listPartitionsSettings();
  }

  public static final HiveMetastoreServiceSettings create(HiveMetastoreServiceStubSettings stub)
      throws IOException {
    return new HiveMetastoreServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return HiveMetastoreServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return HiveMetastoreServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return HiveMetastoreServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return HiveMetastoreServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return HiveMetastoreServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return HiveMetastoreServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return HiveMetastoreServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return HiveMetastoreServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected HiveMetastoreServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for HiveMetastoreServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<HiveMetastoreServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(HiveMetastoreServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(HiveMetastoreServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(HiveMetastoreServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(HiveMetastoreServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(HiveMetastoreServiceStubSettings.newHttpJsonBuilder());
    }

    public HiveMetastoreServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((HiveMetastoreServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createHiveCatalog. */
    public UnaryCallSettings.Builder<CreateHiveCatalogRequest, HiveCatalog>
        createHiveCatalogSettings() {
      return getStubSettingsBuilder().createHiveCatalogSettings();
    }

    /** Returns the builder for the settings used for calls to getHiveCatalog. */
    public UnaryCallSettings.Builder<GetHiveCatalogRequest, HiveCatalog> getHiveCatalogSettings() {
      return getStubSettingsBuilder().getHiveCatalogSettings();
    }

    /** Returns the builder for the settings used for calls to listHiveCatalogs. */
    public PagedCallSettings.Builder<
            ListHiveCatalogsRequest, ListHiveCatalogsResponse, ListHiveCatalogsPagedResponse>
        listHiveCatalogsSettings() {
      return getStubSettingsBuilder().listHiveCatalogsSettings();
    }

    /** Returns the builder for the settings used for calls to updateHiveCatalog. */
    public UnaryCallSettings.Builder<UpdateHiveCatalogRequest, HiveCatalog>
        updateHiveCatalogSettings() {
      return getStubSettingsBuilder().updateHiveCatalogSettings();
    }

    /** Returns the builder for the settings used for calls to deleteHiveCatalog. */
    public UnaryCallSettings.Builder<DeleteHiveCatalogRequest, Empty> deleteHiveCatalogSettings() {
      return getStubSettingsBuilder().deleteHiveCatalogSettings();
    }

    /** Returns the builder for the settings used for calls to createHiveDatabase. */
    public UnaryCallSettings.Builder<CreateHiveDatabaseRequest, HiveDatabase>
        createHiveDatabaseSettings() {
      return getStubSettingsBuilder().createHiveDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to getHiveDatabase. */
    public UnaryCallSettings.Builder<GetHiveDatabaseRequest, HiveDatabase>
        getHiveDatabaseSettings() {
      return getStubSettingsBuilder().getHiveDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to listHiveDatabases. */
    public PagedCallSettings.Builder<
            ListHiveDatabasesRequest, ListHiveDatabasesResponse, ListHiveDatabasesPagedResponse>
        listHiveDatabasesSettings() {
      return getStubSettingsBuilder().listHiveDatabasesSettings();
    }

    /** Returns the builder for the settings used for calls to updateHiveDatabase. */
    public UnaryCallSettings.Builder<UpdateHiveDatabaseRequest, HiveDatabase>
        updateHiveDatabaseSettings() {
      return getStubSettingsBuilder().updateHiveDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to deleteHiveDatabase. */
    public UnaryCallSettings.Builder<DeleteHiveDatabaseRequest, Empty>
        deleteHiveDatabaseSettings() {
      return getStubSettingsBuilder().deleteHiveDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to createHiveTable. */
    public UnaryCallSettings.Builder<CreateHiveTableRequest, HiveTable> createHiveTableSettings() {
      return getStubSettingsBuilder().createHiveTableSettings();
    }

    /** Returns the builder for the settings used for calls to getHiveTable. */
    public UnaryCallSettings.Builder<GetHiveTableRequest, HiveTable> getHiveTableSettings() {
      return getStubSettingsBuilder().getHiveTableSettings();
    }

    /** Returns the builder for the settings used for calls to listHiveTables. */
    public PagedCallSettings.Builder<
            ListHiveTablesRequest, ListHiveTablesResponse, ListHiveTablesPagedResponse>
        listHiveTablesSettings() {
      return getStubSettingsBuilder().listHiveTablesSettings();
    }

    /** Returns the builder for the settings used for calls to updateHiveTable. */
    public UnaryCallSettings.Builder<UpdateHiveTableRequest, HiveTable> updateHiveTableSettings() {
      return getStubSettingsBuilder().updateHiveTableSettings();
    }

    /** Returns the builder for the settings used for calls to deleteHiveTable. */
    public UnaryCallSettings.Builder<DeleteHiveTableRequest, Empty> deleteHiveTableSettings() {
      return getStubSettingsBuilder().deleteHiveTableSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreatePartitions. */
    public UnaryCallSettings.Builder<BatchCreatePartitionsRequest, BatchCreatePartitionsResponse>
        batchCreatePartitionsSettings() {
      return getStubSettingsBuilder().batchCreatePartitionsSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeletePartitions. */
    public UnaryCallSettings.Builder<BatchDeletePartitionsRequest, Empty>
        batchDeletePartitionsSettings() {
      return getStubSettingsBuilder().batchDeletePartitionsSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdatePartitions. */
    public UnaryCallSettings.Builder<BatchUpdatePartitionsRequest, BatchUpdatePartitionsResponse>
        batchUpdatePartitionsSettings() {
      return getStubSettingsBuilder().batchUpdatePartitionsSettings();
    }

    /** Returns the builder for the settings used for calls to listPartitions. */
    public ServerStreamingCallSettings.Builder<ListPartitionsRequest, ListPartitionsResponse>
        listPartitionsSettings() {
      return getStubSettingsBuilder().listPartitionsSettings();
    }

    @Override
    public HiveMetastoreServiceSettings build() throws IOException {
      return new HiveMetastoreServiceSettings(this);
    }
  }
}
