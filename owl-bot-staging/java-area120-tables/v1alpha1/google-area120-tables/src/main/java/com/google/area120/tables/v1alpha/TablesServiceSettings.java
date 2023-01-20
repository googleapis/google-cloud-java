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

package com.google.area120.tables.v1alpha;

import static com.google.area120.tables.v1alpha.TablesServiceClient.ListRowsPagedResponse;
import static com.google.area120.tables.v1alpha.TablesServiceClient.ListTablesPagedResponse;
import static com.google.area120.tables.v1alpha.TablesServiceClient.ListWorkspacesPagedResponse;

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
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.area120.tables.v1alpha.stub.TablesServiceStubSettings;
import com.google.area120.tables.v1alpha1.BatchCreateRowsRequest;
import com.google.area120.tables.v1alpha1.BatchCreateRowsResponse;
import com.google.area120.tables.v1alpha1.BatchDeleteRowsRequest;
import com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest;
import com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse;
import com.google.area120.tables.v1alpha1.CreateRowRequest;
import com.google.area120.tables.v1alpha1.DeleteRowRequest;
import com.google.area120.tables.v1alpha1.GetRowRequest;
import com.google.area120.tables.v1alpha1.GetTableRequest;
import com.google.area120.tables.v1alpha1.GetWorkspaceRequest;
import com.google.area120.tables.v1alpha1.ListRowsRequest;
import com.google.area120.tables.v1alpha1.ListRowsResponse;
import com.google.area120.tables.v1alpha1.ListTablesRequest;
import com.google.area120.tables.v1alpha1.ListTablesResponse;
import com.google.area120.tables.v1alpha1.ListWorkspacesRequest;
import com.google.area120.tables.v1alpha1.ListWorkspacesResponse;
import com.google.area120.tables.v1alpha1.Row;
import com.google.area120.tables.v1alpha1.Table;
import com.google.area120.tables.v1alpha1.UpdateRowRequest;
import com.google.area120.tables.v1alpha1.Workspace;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TablesServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (area120tables.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getTable to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TablesServiceSettings.Builder tablesServiceSettingsBuilder = TablesServiceSettings.newBuilder();
 * tablesServiceSettingsBuilder
 *     .getTableSettings()
 *     .setRetrySettings(
 *         tablesServiceSettingsBuilder
 *             .getTableSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TablesServiceSettings tablesServiceSettings = tablesServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class TablesServiceSettings extends ClientSettings<TablesServiceSettings> {

  /** Returns the object with the settings used for calls to getTable. */
  public UnaryCallSettings<GetTableRequest, Table> getTableSettings() {
    return ((TablesServiceStubSettings) getStubSettings()).getTableSettings();
  }

  /** Returns the object with the settings used for calls to listTables. */
  public PagedCallSettings<ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>
      listTablesSettings() {
    return ((TablesServiceStubSettings) getStubSettings()).listTablesSettings();
  }

  /** Returns the object with the settings used for calls to getWorkspace. */
  public UnaryCallSettings<GetWorkspaceRequest, Workspace> getWorkspaceSettings() {
    return ((TablesServiceStubSettings) getStubSettings()).getWorkspaceSettings();
  }

  /** Returns the object with the settings used for calls to listWorkspaces. */
  public PagedCallSettings<
          ListWorkspacesRequest, ListWorkspacesResponse, ListWorkspacesPagedResponse>
      listWorkspacesSettings() {
    return ((TablesServiceStubSettings) getStubSettings()).listWorkspacesSettings();
  }

  /** Returns the object with the settings used for calls to getRow. */
  public UnaryCallSettings<GetRowRequest, Row> getRowSettings() {
    return ((TablesServiceStubSettings) getStubSettings()).getRowSettings();
  }

  /** Returns the object with the settings used for calls to listRows. */
  public PagedCallSettings<ListRowsRequest, ListRowsResponse, ListRowsPagedResponse>
      listRowsSettings() {
    return ((TablesServiceStubSettings) getStubSettings()).listRowsSettings();
  }

  /** Returns the object with the settings used for calls to createRow. */
  public UnaryCallSettings<CreateRowRequest, Row> createRowSettings() {
    return ((TablesServiceStubSettings) getStubSettings()).createRowSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateRows. */
  public UnaryCallSettings<BatchCreateRowsRequest, BatchCreateRowsResponse>
      batchCreateRowsSettings() {
    return ((TablesServiceStubSettings) getStubSettings()).batchCreateRowsSettings();
  }

  /** Returns the object with the settings used for calls to updateRow. */
  public UnaryCallSettings<UpdateRowRequest, Row> updateRowSettings() {
    return ((TablesServiceStubSettings) getStubSettings()).updateRowSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateRows. */
  public UnaryCallSettings<BatchUpdateRowsRequest, BatchUpdateRowsResponse>
      batchUpdateRowsSettings() {
    return ((TablesServiceStubSettings) getStubSettings()).batchUpdateRowsSettings();
  }

  /** Returns the object with the settings used for calls to deleteRow. */
  public UnaryCallSettings<DeleteRowRequest, Empty> deleteRowSettings() {
    return ((TablesServiceStubSettings) getStubSettings()).deleteRowSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteRows. */
  public UnaryCallSettings<BatchDeleteRowsRequest, Empty> batchDeleteRowsSettings() {
    return ((TablesServiceStubSettings) getStubSettings()).batchDeleteRowsSettings();
  }

  public static final TablesServiceSettings create(TablesServiceStubSettings stub)
      throws IOException {
    return new TablesServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return TablesServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return TablesServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return TablesServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return TablesServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return TablesServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return TablesServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TablesServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TablesServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
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

  protected TablesServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for TablesServiceSettings. */
  public static class Builder extends ClientSettings.Builder<TablesServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(TablesServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(TablesServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(TablesServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(TablesServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(TablesServiceStubSettings.newHttpJsonBuilder());
    }

    public TablesServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((TablesServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getTable. */
    public UnaryCallSettings.Builder<GetTableRequest, Table> getTableSettings() {
      return getStubSettingsBuilder().getTableSettings();
    }

    /** Returns the builder for the settings used for calls to listTables. */
    public PagedCallSettings.Builder<ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>
        listTablesSettings() {
      return getStubSettingsBuilder().listTablesSettings();
    }

    /** Returns the builder for the settings used for calls to getWorkspace. */
    public UnaryCallSettings.Builder<GetWorkspaceRequest, Workspace> getWorkspaceSettings() {
      return getStubSettingsBuilder().getWorkspaceSettings();
    }

    /** Returns the builder for the settings used for calls to listWorkspaces. */
    public PagedCallSettings.Builder<
            ListWorkspacesRequest, ListWorkspacesResponse, ListWorkspacesPagedResponse>
        listWorkspacesSettings() {
      return getStubSettingsBuilder().listWorkspacesSettings();
    }

    /** Returns the builder for the settings used for calls to getRow. */
    public UnaryCallSettings.Builder<GetRowRequest, Row> getRowSettings() {
      return getStubSettingsBuilder().getRowSettings();
    }

    /** Returns the builder for the settings used for calls to listRows. */
    public PagedCallSettings.Builder<ListRowsRequest, ListRowsResponse, ListRowsPagedResponse>
        listRowsSettings() {
      return getStubSettingsBuilder().listRowsSettings();
    }

    /** Returns the builder for the settings used for calls to createRow. */
    public UnaryCallSettings.Builder<CreateRowRequest, Row> createRowSettings() {
      return getStubSettingsBuilder().createRowSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateRows. */
    public UnaryCallSettings.Builder<BatchCreateRowsRequest, BatchCreateRowsResponse>
        batchCreateRowsSettings() {
      return getStubSettingsBuilder().batchCreateRowsSettings();
    }

    /** Returns the builder for the settings used for calls to updateRow. */
    public UnaryCallSettings.Builder<UpdateRowRequest, Row> updateRowSettings() {
      return getStubSettingsBuilder().updateRowSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateRows. */
    public UnaryCallSettings.Builder<BatchUpdateRowsRequest, BatchUpdateRowsResponse>
        batchUpdateRowsSettings() {
      return getStubSettingsBuilder().batchUpdateRowsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRow. */
    public UnaryCallSettings.Builder<DeleteRowRequest, Empty> deleteRowSettings() {
      return getStubSettingsBuilder().deleteRowSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteRows. */
    public UnaryCallSettings.Builder<BatchDeleteRowsRequest, Empty> batchDeleteRowsSettings() {
      return getStubSettingsBuilder().batchDeleteRowsSettings();
    }

    @Override
    public TablesServiceSettings build() throws IOException {
      return new TablesServiceSettings(this);
    }
  }
}
