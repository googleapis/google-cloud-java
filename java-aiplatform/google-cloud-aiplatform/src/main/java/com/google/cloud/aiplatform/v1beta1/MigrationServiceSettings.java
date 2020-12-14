/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.MigrationServiceClient.SearchMigratableResourcesPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.stub.MigrationServiceStubSettings;
import com.google.longrunning.Operation;
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
 *   <li>The default service address (aiplatform.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of searchMigratableResources to 30 seconds:
 *
 * <pre>{@code
 * MigrationServiceSettings.Builder migrationServiceSettingsBuilder =
 *     MigrationServiceSettings.newBuilder();
 * migrationServiceSettingsBuilder
 *     .searchMigratableResourcesSettings()
 *     .setRetrySettings(
 *         migrationServiceSettingsBuilder
 *             .searchMigratableResourcesSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * MigrationServiceSettings migrationServiceSettings = migrationServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class MigrationServiceSettings extends ClientSettings<MigrationServiceSettings> {

  /** Returns the object with the settings used for calls to searchMigratableResources. */
  public PagedCallSettings<
          SearchMigratableResourcesRequest,
          SearchMigratableResourcesResponse,
          SearchMigratableResourcesPagedResponse>
      searchMigratableResourcesSettings() {
    return ((MigrationServiceStubSettings) getStubSettings()).searchMigratableResourcesSettings();
  }

  /** Returns the object with the settings used for calls to batchMigrateResources. */
  public UnaryCallSettings<BatchMigrateResourcesRequest, Operation>
      batchMigrateResourcesSettings() {
    return ((MigrationServiceStubSettings) getStubSettings()).batchMigrateResourcesSettings();
  }

  /** Returns the object with the settings used for calls to batchMigrateResources. */
  public OperationCallSettings<
          BatchMigrateResourcesRequest,
          BatchMigrateResourcesResponse,
          BatchMigrateResourcesOperationMetadata>
      batchMigrateResourcesOperationSettings() {
    return ((MigrationServiceStubSettings) getStubSettings())
        .batchMigrateResourcesOperationSettings();
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return MigrationServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return MigrationServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MigrationServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

    public MigrationServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((MigrationServiceStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
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

    /** Returns the builder for the settings used for calls to searchMigratableResources. */
    public PagedCallSettings.Builder<
            SearchMigratableResourcesRequest,
            SearchMigratableResourcesResponse,
            SearchMigratableResourcesPagedResponse>
        searchMigratableResourcesSettings() {
      return getStubSettingsBuilder().searchMigratableResourcesSettings();
    }

    /** Returns the builder for the settings used for calls to batchMigrateResources. */
    public UnaryCallSettings.Builder<BatchMigrateResourcesRequest, Operation>
        batchMigrateResourcesSettings() {
      return getStubSettingsBuilder().batchMigrateResourcesSettings();
    }

    /** Returns the builder for the settings used for calls to batchMigrateResources. */
    public OperationCallSettings.Builder<
            BatchMigrateResourcesRequest,
            BatchMigrateResourcesResponse,
            BatchMigrateResourcesOperationMetadata>
        batchMigrateResourcesOperationSettings() {
      return getStubSettingsBuilder().batchMigrateResourcesOperationSettings();
    }

    @Override
    public MigrationServiceSettings build() throws IOException {
      return new MigrationServiceSettings(this);
    }
  }
}
