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

package com.google.cloud.chronicle.v1;

import static com.google.cloud.chronicle.v1.DataTableServiceClient.ListDataTableRowsPagedResponse;
import static com.google.cloud.chronicle.v1.DataTableServiceClient.ListDataTablesPagedResponse;

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
import com.google.cloud.chronicle.v1.stub.DataTableServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataTableServiceClient}.
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
 * of createDataTable:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataTableServiceSettings.Builder dataTableServiceSettingsBuilder =
 *     DataTableServiceSettings.newBuilder();
 * dataTableServiceSettingsBuilder
 *     .createDataTableSettings()
 *     .setRetrySettings(
 *         dataTableServiceSettingsBuilder
 *             .createDataTableSettings()
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
 * DataTableServiceSettings dataTableServiceSettings = dataTableServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@Generated("by gapic-generator-java")
public class DataTableServiceSettings extends ClientSettings<DataTableServiceSettings> {

  /** Returns the object with the settings used for calls to createDataTable. */
  public UnaryCallSettings<CreateDataTableRequest, DataTable> createDataTableSettings() {
    return ((DataTableServiceStubSettings) getStubSettings()).createDataTableSettings();
  }

  /** Returns the object with the settings used for calls to listDataTables. */
  public PagedCallSettings<
          ListDataTablesRequest, ListDataTablesResponse, ListDataTablesPagedResponse>
      listDataTablesSettings() {
    return ((DataTableServiceStubSettings) getStubSettings()).listDataTablesSettings();
  }

  /** Returns the object with the settings used for calls to getDataTable. */
  public UnaryCallSettings<GetDataTableRequest, DataTable> getDataTableSettings() {
    return ((DataTableServiceStubSettings) getStubSettings()).getDataTableSettings();
  }

  /** Returns the object with the settings used for calls to updateDataTable. */
  public UnaryCallSettings<UpdateDataTableRequest, DataTable> updateDataTableSettings() {
    return ((DataTableServiceStubSettings) getStubSettings()).updateDataTableSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataTable. */
  public UnaryCallSettings<DeleteDataTableRequest, Empty> deleteDataTableSettings() {
    return ((DataTableServiceStubSettings) getStubSettings()).deleteDataTableSettings();
  }

  /** Returns the object with the settings used for calls to createDataTableRow. */
  public UnaryCallSettings<CreateDataTableRowRequest, DataTableRow> createDataTableRowSettings() {
    return ((DataTableServiceStubSettings) getStubSettings()).createDataTableRowSettings();
  }

  /** Returns the object with the settings used for calls to updateDataTableRow. */
  public UnaryCallSettings<UpdateDataTableRowRequest, DataTableRow> updateDataTableRowSettings() {
    return ((DataTableServiceStubSettings) getStubSettings()).updateDataTableRowSettings();
  }

  /** Returns the object with the settings used for calls to listDataTableRows. */
  public PagedCallSettings<
          ListDataTableRowsRequest, ListDataTableRowsResponse, ListDataTableRowsPagedResponse>
      listDataTableRowsSettings() {
    return ((DataTableServiceStubSettings) getStubSettings()).listDataTableRowsSettings();
  }

  /** Returns the object with the settings used for calls to getDataTableRow. */
  public UnaryCallSettings<GetDataTableRowRequest, DataTableRow> getDataTableRowSettings() {
    return ((DataTableServiceStubSettings) getStubSettings()).getDataTableRowSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataTableRow. */
  public UnaryCallSettings<DeleteDataTableRowRequest, Empty> deleteDataTableRowSettings() {
    return ((DataTableServiceStubSettings) getStubSettings()).deleteDataTableRowSettings();
  }

  /** Returns the object with the settings used for calls to bulkCreateDataTableRows. */
  public UnaryCallSettings<BulkCreateDataTableRowsRequest, BulkCreateDataTableRowsResponse>
      bulkCreateDataTableRowsSettings() {
    return ((DataTableServiceStubSettings) getStubSettings()).bulkCreateDataTableRowsSettings();
  }

  /** Returns the object with the settings used for calls to bulkGetDataTableRows. */
  public UnaryCallSettings<BulkGetDataTableRowsRequest, BulkGetDataTableRowsResponse>
      bulkGetDataTableRowsSettings() {
    return ((DataTableServiceStubSettings) getStubSettings()).bulkGetDataTableRowsSettings();
  }

  /** Returns the object with the settings used for calls to bulkReplaceDataTableRows. */
  public UnaryCallSettings<BulkReplaceDataTableRowsRequest, BulkReplaceDataTableRowsResponse>
      bulkReplaceDataTableRowsSettings() {
    return ((DataTableServiceStubSettings) getStubSettings()).bulkReplaceDataTableRowsSettings();
  }

  /** Returns the object with the settings used for calls to bulkUpdateDataTableRows. */
  public UnaryCallSettings<BulkUpdateDataTableRowsRequest, BulkUpdateDataTableRowsResponse>
      bulkUpdateDataTableRowsSettings() {
    return ((DataTableServiceStubSettings) getStubSettings()).bulkUpdateDataTableRowsSettings();
  }

  /** Returns the object with the settings used for calls to getDataTableOperationErrors. */
  public UnaryCallSettings<GetDataTableOperationErrorsRequest, DataTableOperationErrors>
      getDataTableOperationErrorsSettings() {
    return ((DataTableServiceStubSettings) getStubSettings()).getDataTableOperationErrorsSettings();
  }

  public static final DataTableServiceSettings create(DataTableServiceStubSettings stub)
      throws IOException {
    return new DataTableServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DataTableServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DataTableServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DataTableServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DataTableServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DataTableServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DataTableServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DataTableServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataTableServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DataTableServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DataTableServiceSettings. */
  public static class Builder extends ClientSettings.Builder<DataTableServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DataTableServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DataTableServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DataTableServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DataTableServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(DataTableServiceStubSettings.newHttpJsonBuilder());
    }

    public DataTableServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DataTableServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createDataTable. */
    public UnaryCallSettings.Builder<CreateDataTableRequest, DataTable> createDataTableSettings() {
      return getStubSettingsBuilder().createDataTableSettings();
    }

    /** Returns the builder for the settings used for calls to listDataTables. */
    public PagedCallSettings.Builder<
            ListDataTablesRequest, ListDataTablesResponse, ListDataTablesPagedResponse>
        listDataTablesSettings() {
      return getStubSettingsBuilder().listDataTablesSettings();
    }

    /** Returns the builder for the settings used for calls to getDataTable. */
    public UnaryCallSettings.Builder<GetDataTableRequest, DataTable> getDataTableSettings() {
      return getStubSettingsBuilder().getDataTableSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataTable. */
    public UnaryCallSettings.Builder<UpdateDataTableRequest, DataTable> updateDataTableSettings() {
      return getStubSettingsBuilder().updateDataTableSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataTable. */
    public UnaryCallSettings.Builder<DeleteDataTableRequest, Empty> deleteDataTableSettings() {
      return getStubSettingsBuilder().deleteDataTableSettings();
    }

    /** Returns the builder for the settings used for calls to createDataTableRow. */
    public UnaryCallSettings.Builder<CreateDataTableRowRequest, DataTableRow>
        createDataTableRowSettings() {
      return getStubSettingsBuilder().createDataTableRowSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataTableRow. */
    public UnaryCallSettings.Builder<UpdateDataTableRowRequest, DataTableRow>
        updateDataTableRowSettings() {
      return getStubSettingsBuilder().updateDataTableRowSettings();
    }

    /** Returns the builder for the settings used for calls to listDataTableRows. */
    public PagedCallSettings.Builder<
            ListDataTableRowsRequest, ListDataTableRowsResponse, ListDataTableRowsPagedResponse>
        listDataTableRowsSettings() {
      return getStubSettingsBuilder().listDataTableRowsSettings();
    }

    /** Returns the builder for the settings used for calls to getDataTableRow. */
    public UnaryCallSettings.Builder<GetDataTableRowRequest, DataTableRow>
        getDataTableRowSettings() {
      return getStubSettingsBuilder().getDataTableRowSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataTableRow. */
    public UnaryCallSettings.Builder<DeleteDataTableRowRequest, Empty>
        deleteDataTableRowSettings() {
      return getStubSettingsBuilder().deleteDataTableRowSettings();
    }

    /** Returns the builder for the settings used for calls to bulkCreateDataTableRows. */
    public UnaryCallSettings.Builder<
            BulkCreateDataTableRowsRequest, BulkCreateDataTableRowsResponse>
        bulkCreateDataTableRowsSettings() {
      return getStubSettingsBuilder().bulkCreateDataTableRowsSettings();
    }

    /** Returns the builder for the settings used for calls to bulkGetDataTableRows. */
    public UnaryCallSettings.Builder<BulkGetDataTableRowsRequest, BulkGetDataTableRowsResponse>
        bulkGetDataTableRowsSettings() {
      return getStubSettingsBuilder().bulkGetDataTableRowsSettings();
    }

    /** Returns the builder for the settings used for calls to bulkReplaceDataTableRows. */
    public UnaryCallSettings.Builder<
            BulkReplaceDataTableRowsRequest, BulkReplaceDataTableRowsResponse>
        bulkReplaceDataTableRowsSettings() {
      return getStubSettingsBuilder().bulkReplaceDataTableRowsSettings();
    }

    /** Returns the builder for the settings used for calls to bulkUpdateDataTableRows. */
    public UnaryCallSettings.Builder<
            BulkUpdateDataTableRowsRequest, BulkUpdateDataTableRowsResponse>
        bulkUpdateDataTableRowsSettings() {
      return getStubSettingsBuilder().bulkUpdateDataTableRowsSettings();
    }

    /** Returns the builder for the settings used for calls to getDataTableOperationErrors. */
    public UnaryCallSettings.Builder<GetDataTableOperationErrorsRequest, DataTableOperationErrors>
        getDataTableOperationErrorsSettings() {
      return getStubSettingsBuilder().getDataTableOperationErrorsSettings();
    }

    @Override
    public DataTableServiceSettings build() throws IOException {
      return new DataTableServiceSettings(this);
    }
  }
}
