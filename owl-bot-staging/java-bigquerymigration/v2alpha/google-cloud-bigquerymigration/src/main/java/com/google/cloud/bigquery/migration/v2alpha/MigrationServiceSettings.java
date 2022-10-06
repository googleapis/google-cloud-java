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

package com.google.cloud.bigquery.migration.v2alpha;

import static com.google.cloud.bigquery.migration.v2alpha.MigrationServiceClient.ListMigrationSubtasksPagedResponse;
import static com.google.cloud.bigquery.migration.v2alpha.MigrationServiceClient.ListMigrationWorkflowsPagedResponse;

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
import com.google.cloud.bigquery.migration.v2alpha.stub.MigrationServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MigrationServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (bigquerymigration.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createMigrationWorkflow to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MigrationServiceSettings.Builder migrationServiceSettingsBuilder =
 *     MigrationServiceSettings.newBuilder();
 * migrationServiceSettingsBuilder
 *     .createMigrationWorkflowSettings()
 *     .setRetrySettings(
 *         migrationServiceSettingsBuilder
 *             .createMigrationWorkflowSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * MigrationServiceSettings migrationServiceSettings = migrationServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MigrationServiceSettings extends ClientSettings<MigrationServiceSettings> {

  /** Returns the object with the settings used for calls to createMigrationWorkflow. */
  public UnaryCallSettings<CreateMigrationWorkflowRequest, MigrationWorkflow>
      createMigrationWorkflowSettings() {
    return ((MigrationServiceStubSettings) getStubSettings()).createMigrationWorkflowSettings();
  }

  /** Returns the object with the settings used for calls to getMigrationWorkflow. */
  public UnaryCallSettings<GetMigrationWorkflowRequest, MigrationWorkflow>
      getMigrationWorkflowSettings() {
    return ((MigrationServiceStubSettings) getStubSettings()).getMigrationWorkflowSettings();
  }

  /** Returns the object with the settings used for calls to listMigrationWorkflows. */
  public PagedCallSettings<
          ListMigrationWorkflowsRequest,
          ListMigrationWorkflowsResponse,
          ListMigrationWorkflowsPagedResponse>
      listMigrationWorkflowsSettings() {
    return ((MigrationServiceStubSettings) getStubSettings()).listMigrationWorkflowsSettings();
  }

  /** Returns the object with the settings used for calls to deleteMigrationWorkflow. */
  public UnaryCallSettings<DeleteMigrationWorkflowRequest, Empty>
      deleteMigrationWorkflowSettings() {
    return ((MigrationServiceStubSettings) getStubSettings()).deleteMigrationWorkflowSettings();
  }

  /** Returns the object with the settings used for calls to startMigrationWorkflow. */
  public UnaryCallSettings<StartMigrationWorkflowRequest, Empty> startMigrationWorkflowSettings() {
    return ((MigrationServiceStubSettings) getStubSettings()).startMigrationWorkflowSettings();
  }

  /** Returns the object with the settings used for calls to getMigrationSubtask. */
  public UnaryCallSettings<GetMigrationSubtaskRequest, MigrationSubtask>
      getMigrationSubtaskSettings() {
    return ((MigrationServiceStubSettings) getStubSettings()).getMigrationSubtaskSettings();
  }

  /** Returns the object with the settings used for calls to listMigrationSubtasks. */
  public PagedCallSettings<
          ListMigrationSubtasksRequest,
          ListMigrationSubtasksResponse,
          ListMigrationSubtasksPagedResponse>
      listMigrationSubtasksSettings() {
    return ((MigrationServiceStubSettings) getStubSettings()).listMigrationSubtasksSettings();
  }

  public static final MigrationServiceSettings create(MigrationServiceStubSettings stub)
      throws IOException {
    return new MigrationServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return MigrationServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return MigrationServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return MigrationServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return MigrationServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return MigrationServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return MigrationServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return MigrationServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MigrationServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected MigrationServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for MigrationServiceSettings. */
  public static class Builder extends ClientSettings.Builder<MigrationServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(MigrationServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(MigrationServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(MigrationServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(MigrationServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(MigrationServiceStubSettings.newHttpJsonBuilder());
    }

    public MigrationServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((MigrationServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createMigrationWorkflow. */
    public UnaryCallSettings.Builder<CreateMigrationWorkflowRequest, MigrationWorkflow>
        createMigrationWorkflowSettings() {
      return getStubSettingsBuilder().createMigrationWorkflowSettings();
    }

    /** Returns the builder for the settings used for calls to getMigrationWorkflow. */
    public UnaryCallSettings.Builder<GetMigrationWorkflowRequest, MigrationWorkflow>
        getMigrationWorkflowSettings() {
      return getStubSettingsBuilder().getMigrationWorkflowSettings();
    }

    /** Returns the builder for the settings used for calls to listMigrationWorkflows. */
    public PagedCallSettings.Builder<
            ListMigrationWorkflowsRequest,
            ListMigrationWorkflowsResponse,
            ListMigrationWorkflowsPagedResponse>
        listMigrationWorkflowsSettings() {
      return getStubSettingsBuilder().listMigrationWorkflowsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMigrationWorkflow. */
    public UnaryCallSettings.Builder<DeleteMigrationWorkflowRequest, Empty>
        deleteMigrationWorkflowSettings() {
      return getStubSettingsBuilder().deleteMigrationWorkflowSettings();
    }

    /** Returns the builder for the settings used for calls to startMigrationWorkflow. */
    public UnaryCallSettings.Builder<StartMigrationWorkflowRequest, Empty>
        startMigrationWorkflowSettings() {
      return getStubSettingsBuilder().startMigrationWorkflowSettings();
    }

    /** Returns the builder for the settings used for calls to getMigrationSubtask. */
    public UnaryCallSettings.Builder<GetMigrationSubtaskRequest, MigrationSubtask>
        getMigrationSubtaskSettings() {
      return getStubSettingsBuilder().getMigrationSubtaskSettings();
    }

    /** Returns the builder for the settings used for calls to listMigrationSubtasks. */
    public PagedCallSettings.Builder<
            ListMigrationSubtasksRequest,
            ListMigrationSubtasksResponse,
            ListMigrationSubtasksPagedResponse>
        listMigrationSubtasksSettings() {
      return getStubSettingsBuilder().listMigrationSubtasksSettings();
    }

    @Override
    public MigrationServiceSettings build() throws IOException {
      return new MigrationServiceSettings(this);
    }
  }
}
