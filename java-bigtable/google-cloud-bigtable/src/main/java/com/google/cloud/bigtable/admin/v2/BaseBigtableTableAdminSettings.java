/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.admin.v2;

import static com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListSnapshotsPagedResponse;
import static com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListTablesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.bigtable.admin.v2.CheckConsistencyRequest;
import com.google.bigtable.admin.v2.CheckConsistencyResponse;
import com.google.bigtable.admin.v2.CreateTableFromSnapshotMetadata;
import com.google.bigtable.admin.v2.CreateTableFromSnapshotRequest;
import com.google.bigtable.admin.v2.CreateTableRequest;
import com.google.bigtable.admin.v2.DeleteSnapshotRequest;
import com.google.bigtable.admin.v2.DeleteTableRequest;
import com.google.bigtable.admin.v2.DropRowRangeRequest;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenRequest;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenResponse;
import com.google.bigtable.admin.v2.GetSnapshotRequest;
import com.google.bigtable.admin.v2.GetTableRequest;
import com.google.bigtable.admin.v2.ListSnapshotsRequest;
import com.google.bigtable.admin.v2.ListSnapshotsResponse;
import com.google.bigtable.admin.v2.ListTablesRequest;
import com.google.bigtable.admin.v2.ListTablesResponse;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest;
import com.google.bigtable.admin.v2.Snapshot;
import com.google.bigtable.admin.v2.SnapshotTableMetadata;
import com.google.bigtable.admin.v2.SnapshotTableRequest;
import com.google.bigtable.admin.v2.Table;
import com.google.cloud.bigtable.admin.v2.stub.BigtableTableAdminStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/** For internal use only. */
@Generated("by gapic-generator")
@InternalApi
public class BaseBigtableTableAdminSettings extends ClientSettings<BaseBigtableTableAdminSettings> {
  /** Returns the object with the settings used for calls to createTable. */
  public UnaryCallSettings<CreateTableRequest, Table> createTableSettings() {
    return ((BigtableTableAdminStubSettings) getStubSettings()).createTableSettings();
  }

  /** Returns the object with the settings used for calls to createTableFromSnapshot. */
  public UnaryCallSettings<CreateTableFromSnapshotRequest, Operation>
      createTableFromSnapshotSettings() {
    return ((BigtableTableAdminStubSettings) getStubSettings()).createTableFromSnapshotSettings();
  }

  /** Returns the object with the settings used for calls to createTableFromSnapshot. */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public OperationCallSettings<
          CreateTableFromSnapshotRequest, Table, CreateTableFromSnapshotMetadata>
      createTableFromSnapshotOperationSettings() {
    return ((BigtableTableAdminStubSettings) getStubSettings())
        .createTableFromSnapshotOperationSettings();
  }

  /** Returns the object with the settings used for calls to listTables. */
  public PagedCallSettings<ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>
      listTablesSettings() {
    return ((BigtableTableAdminStubSettings) getStubSettings()).listTablesSettings();
  }

  /** Returns the object with the settings used for calls to getTable. */
  public UnaryCallSettings<GetTableRequest, Table> getTableSettings() {
    return ((BigtableTableAdminStubSettings) getStubSettings()).getTableSettings();
  }

  /** Returns the object with the settings used for calls to deleteTable. */
  public UnaryCallSettings<DeleteTableRequest, Empty> deleteTableSettings() {
    return ((BigtableTableAdminStubSettings) getStubSettings()).deleteTableSettings();
  }

  /** Returns the object with the settings used for calls to modifyColumnFamilies. */
  public UnaryCallSettings<ModifyColumnFamiliesRequest, Table> modifyColumnFamiliesSettings() {
    return ((BigtableTableAdminStubSettings) getStubSettings()).modifyColumnFamiliesSettings();
  }

  /** Returns the object with the settings used for calls to dropRowRange. */
  public UnaryCallSettings<DropRowRangeRequest, Empty> dropRowRangeSettings() {
    return ((BigtableTableAdminStubSettings) getStubSettings()).dropRowRangeSettings();
  }

  /** Returns the object with the settings used for calls to generateConsistencyToken. */
  public UnaryCallSettings<GenerateConsistencyTokenRequest, GenerateConsistencyTokenResponse>
      generateConsistencyTokenSettings() {
    return ((BigtableTableAdminStubSettings) getStubSettings()).generateConsistencyTokenSettings();
  }

  /** Returns the object with the settings used for calls to checkConsistency. */
  public UnaryCallSettings<CheckConsistencyRequest, CheckConsistencyResponse>
      checkConsistencySettings() {
    return ((BigtableTableAdminStubSettings) getStubSettings()).checkConsistencySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((BigtableTableAdminStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((BigtableTableAdminStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((BigtableTableAdminStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  /** Returns the object with the settings used for calls to snapshotTable. */
  public UnaryCallSettings<SnapshotTableRequest, Operation> snapshotTableSettings() {
    return ((BigtableTableAdminStubSettings) getStubSettings()).snapshotTableSettings();
  }

  /** Returns the object with the settings used for calls to snapshotTable. */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public OperationCallSettings<SnapshotTableRequest, Snapshot, SnapshotTableMetadata>
      snapshotTableOperationSettings() {
    return ((BigtableTableAdminStubSettings) getStubSettings()).snapshotTableOperationSettings();
  }

  /** Returns the object with the settings used for calls to getSnapshot. */
  public UnaryCallSettings<GetSnapshotRequest, Snapshot> getSnapshotSettings() {
    return ((BigtableTableAdminStubSettings) getStubSettings()).getSnapshotSettings();
  }

  /** Returns the object with the settings used for calls to listSnapshots. */
  public PagedCallSettings<ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
      listSnapshotsSettings() {
    return ((BigtableTableAdminStubSettings) getStubSettings()).listSnapshotsSettings();
  }

  /** Returns the object with the settings used for calls to deleteSnapshot. */
  public UnaryCallSettings<DeleteSnapshotRequest, Empty> deleteSnapshotSettings() {
    return ((BigtableTableAdminStubSettings) getStubSettings()).deleteSnapshotSettings();
  }

  public static final BaseBigtableTableAdminSettings create(BigtableTableAdminStubSettings stub)
      throws IOException {
    return new BaseBigtableTableAdminSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return BigtableTableAdminStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return BigtableTableAdminStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return BigtableTableAdminStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return BigtableTableAdminStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return BigtableTableAdminStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return BigtableTableAdminStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BigtableTableAdminStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected BaseBigtableTableAdminSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for BaseBigtableTableAdminSettings. */
  public static class Builder
      extends ClientSettings.Builder<BaseBigtableTableAdminSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(BigtableTableAdminStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(BigtableTableAdminStubSettings.newBuilder());
    }

    protected Builder(BaseBigtableTableAdminSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(BigtableTableAdminStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public BigtableTableAdminStubSettings.Builder getStubSettingsBuilder() {
      return ((BigtableTableAdminStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to createTable. */
    public UnaryCallSettings.Builder<CreateTableRequest, Table> createTableSettings() {
      return getStubSettingsBuilder().createTableSettings();
    }

    /** Returns the builder for the settings used for calls to createTableFromSnapshot. */
    public UnaryCallSettings.Builder<CreateTableFromSnapshotRequest, Operation>
        createTableFromSnapshotSettings() {
      return getStubSettingsBuilder().createTableFromSnapshotSettings();
    }

    /** Returns the builder for the settings used for calls to createTableFromSnapshot. */
    @BetaApi(
        "The surface for long-running operations is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateTableFromSnapshotRequest, Table, CreateTableFromSnapshotMetadata>
        createTableFromSnapshotOperationSettings() {
      return getStubSettingsBuilder().createTableFromSnapshotOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listTables. */
    public PagedCallSettings.Builder<ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>
        listTablesSettings() {
      return getStubSettingsBuilder().listTablesSettings();
    }

    /** Returns the builder for the settings used for calls to getTable. */
    public UnaryCallSettings.Builder<GetTableRequest, Table> getTableSettings() {
      return getStubSettingsBuilder().getTableSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTable. */
    public UnaryCallSettings.Builder<DeleteTableRequest, Empty> deleteTableSettings() {
      return getStubSettingsBuilder().deleteTableSettings();
    }

    /** Returns the builder for the settings used for calls to modifyColumnFamilies. */
    public UnaryCallSettings.Builder<ModifyColumnFamiliesRequest, Table>
        modifyColumnFamiliesSettings() {
      return getStubSettingsBuilder().modifyColumnFamiliesSettings();
    }

    /** Returns the builder for the settings used for calls to dropRowRange. */
    public UnaryCallSettings.Builder<DropRowRangeRequest, Empty> dropRowRangeSettings() {
      return getStubSettingsBuilder().dropRowRangeSettings();
    }

    /** Returns the builder for the settings used for calls to generateConsistencyToken. */
    public UnaryCallSettings.Builder<
            GenerateConsistencyTokenRequest, GenerateConsistencyTokenResponse>
        generateConsistencyTokenSettings() {
      return getStubSettingsBuilder().generateConsistencyTokenSettings();
    }

    /** Returns the builder for the settings used for calls to checkConsistency. */
    public UnaryCallSettings.Builder<CheckConsistencyRequest, CheckConsistencyResponse>
        checkConsistencySettings() {
      return getStubSettingsBuilder().checkConsistencySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    /** Returns the builder for the settings used for calls to snapshotTable. */
    public UnaryCallSettings.Builder<SnapshotTableRequest, Operation> snapshotTableSettings() {
      return getStubSettingsBuilder().snapshotTableSettings();
    }

    /** Returns the builder for the settings used for calls to snapshotTable. */
    @BetaApi(
        "The surface for long-running operations is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SnapshotTableRequest, Snapshot, SnapshotTableMetadata>
        snapshotTableOperationSettings() {
      return getStubSettingsBuilder().snapshotTableOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getSnapshot. */
    public UnaryCallSettings.Builder<GetSnapshotRequest, Snapshot> getSnapshotSettings() {
      return getStubSettingsBuilder().getSnapshotSettings();
    }

    /** Returns the builder for the settings used for calls to listSnapshots. */
    public PagedCallSettings.Builder<
            ListSnapshotsRequest, ListSnapshotsResponse, ListSnapshotsPagedResponse>
        listSnapshotsSettings() {
      return getStubSettingsBuilder().listSnapshotsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSnapshot. */
    public UnaryCallSettings.Builder<DeleteSnapshotRequest, Empty> deleteSnapshotSettings() {
      return getStubSettingsBuilder().deleteSnapshotSettings();
    }

    @Override
    public BaseBigtableTableAdminSettings build() throws IOException {
      return new BaseBigtableTableAdminSettings(this);
    }
  }
}
