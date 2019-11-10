/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.spanner.admin.database.v1;

import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListDatabasesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
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
import com.google.cloud.spanner.admin.database.v1.stub.DatabaseAdminStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.database.v1.CreateDatabaseRequest;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.database.v1.DropDatabaseRequest;
import com.google.spanner.admin.database.v1.GetDatabaseDdlRequest;
import com.google.spanner.admin.database.v1.GetDatabaseDdlResponse;
import com.google.spanner.admin.database.v1.GetDatabaseRequest;
import com.google.spanner.admin.database.v1.ListDatabasesRequest;
import com.google.spanner.admin.database.v1.ListDatabasesResponse;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link DatabaseAdminClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (spanner.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getDatabase to 30 seconds:
 *
 * <pre>
 * <code>
 * DatabaseAdminSettings.Builder databaseAdminSettingsBuilder =
 *     DatabaseAdminSettings.newBuilder();
 * databaseAdminSettingsBuilder.getDatabaseSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * DatabaseAdminSettings databaseAdminSettings = databaseAdminSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class DatabaseAdminSettings extends ClientSettings<DatabaseAdminSettings> {
  /** Returns the object with the settings used for calls to createDatabase. */
  public UnaryCallSettings<CreateDatabaseRequest, Operation> createDatabaseSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).createDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to createDatabase. */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public OperationCallSettings<CreateDatabaseRequest, Database, CreateDatabaseMetadata>
      createDatabaseOperationSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).createDatabaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to getDatabase. */
  public UnaryCallSettings<GetDatabaseRequest, Database> getDatabaseSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).getDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to updateDatabaseDdl. */
  public UnaryCallSettings<UpdateDatabaseDdlRequest, Operation> updateDatabaseDdlSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).updateDatabaseDdlSettings();
  }

  /** Returns the object with the settings used for calls to updateDatabaseDdl. */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public OperationCallSettings<UpdateDatabaseDdlRequest, Empty, UpdateDatabaseDdlMetadata>
      updateDatabaseDdlOperationSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).updateDatabaseDdlOperationSettings();
  }

  /** Returns the object with the settings used for calls to dropDatabase. */
  public UnaryCallSettings<DropDatabaseRequest, Empty> dropDatabaseSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).dropDatabaseSettings();
  }

  /** Returns the object with the settings used for calls to getDatabaseDdl. */
  public UnaryCallSettings<GetDatabaseDdlRequest, GetDatabaseDdlResponse> getDatabaseDdlSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).getDatabaseDdlSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  /** Returns the object with the settings used for calls to listDatabases. */
  public PagedCallSettings<ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>
      listDatabasesSettings() {
    return ((DatabaseAdminStubSettings) getStubSettings()).listDatabasesSettings();
  }

  public static final DatabaseAdminSettings create(DatabaseAdminStubSettings stub)
      throws IOException {
    return new DatabaseAdminSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DatabaseAdminStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DatabaseAdminStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DatabaseAdminStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DatabaseAdminStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DatabaseAdminStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DatabaseAdminStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DatabaseAdminStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DatabaseAdminSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DatabaseAdminSettings. */
  public static class Builder extends ClientSettings.Builder<DatabaseAdminSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(DatabaseAdminStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(DatabaseAdminStubSettings.newBuilder());
    }

    protected Builder(DatabaseAdminSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DatabaseAdminStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public DatabaseAdminStubSettings.Builder getStubSettingsBuilder() {
      return ((DatabaseAdminStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createDatabase. */
    public UnaryCallSettings.Builder<CreateDatabaseRequest, Operation> createDatabaseSettings() {
      return getStubSettingsBuilder().createDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to createDatabase. */
    @BetaApi(
        "The surface for long-running operations is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateDatabaseRequest, Database, CreateDatabaseMetadata>
        createDatabaseOperationSettings() {
      return getStubSettingsBuilder().createDatabaseOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getDatabase. */
    public UnaryCallSettings.Builder<GetDatabaseRequest, Database> getDatabaseSettings() {
      return getStubSettingsBuilder().getDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to updateDatabaseDdl. */
    public UnaryCallSettings.Builder<UpdateDatabaseDdlRequest, Operation>
        updateDatabaseDdlSettings() {
      return getStubSettingsBuilder().updateDatabaseDdlSettings();
    }

    /** Returns the builder for the settings used for calls to updateDatabaseDdl. */
    @BetaApi(
        "The surface for long-running operations is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateDatabaseDdlRequest, Empty, UpdateDatabaseDdlMetadata>
        updateDatabaseDdlOperationSettings() {
      return getStubSettingsBuilder().updateDatabaseDdlOperationSettings();
    }

    /** Returns the builder for the settings used for calls to dropDatabase. */
    public UnaryCallSettings.Builder<DropDatabaseRequest, Empty> dropDatabaseSettings() {
      return getStubSettingsBuilder().dropDatabaseSettings();
    }

    /** Returns the builder for the settings used for calls to getDatabaseDdl. */
    public UnaryCallSettings.Builder<GetDatabaseDdlRequest, GetDatabaseDdlResponse>
        getDatabaseDdlSettings() {
      return getStubSettingsBuilder().getDatabaseDdlSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    /** Returns the builder for the settings used for calls to listDatabases. */
    public PagedCallSettings.Builder<
            ListDatabasesRequest, ListDatabasesResponse, ListDatabasesPagedResponse>
        listDatabasesSettings() {
      return getStubSettingsBuilder().listDatabasesSettings();
    }

    @Override
    public DatabaseAdminSettings build() throws IOException {
      return new DatabaseAdminSettings(this);
    }
  }
}
