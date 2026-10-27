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

package com.google.cloud.lustre.v1;

import static com.google.cloud.lustre.v1.LustreClient.ListDirectoryPoliciesPagedResponse;
import static com.google.cloud.lustre.v1.LustreClient.ListInstancesPagedResponse;
import static com.google.cloud.lustre.v1.LustreClient.ListLocationsPagedResponse;
import static com.google.cloud.lustre.v1.LustreClient.ListMirrorsPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.lustre.v1.stub.LustreStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link LustreClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (lustre.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getInstance:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LustreSettings.Builder lustreSettingsBuilder = LustreSettings.newBuilder();
 * lustreSettingsBuilder
 *     .getInstanceSettings()
 *     .setRetrySettings(
 *         lustreSettingsBuilder
 *             .getInstanceSettings()
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
 * LustreSettings lustreSettings = lustreSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createInstance:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LustreSettings.Builder lustreSettingsBuilder = LustreSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * lustreSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@NullMarked
@Generated("by gapic-generator-java")
public class LustreSettings extends ClientSettings<LustreSettings> {

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings() {
    return ((LustreStubSettings) getStubSettings()).listInstancesSettings();
  }

  /** Returns the object with the settings used for calls to getInstance. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings() {
    return ((LustreStubSettings) getStubSettings()).getInstanceSettings();
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public UnaryCallSettings<CreateInstanceRequest, Operation> createInstanceSettings() {
    return ((LustreStubSettings) getStubSettings()).createInstanceSettings();
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public OperationCallSettings<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationSettings() {
    return ((LustreStubSettings) getStubSettings()).createInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateInstance. */
  public UnaryCallSettings<UpdateInstanceRequest, Operation> updateInstanceSettings() {
    return ((LustreStubSettings) getStubSettings()).updateInstanceSettings();
  }

  /** Returns the object with the settings used for calls to updateInstance. */
  public OperationCallSettings<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationSettings() {
    return ((LustreStubSettings) getStubSettings()).updateInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public UnaryCallSettings<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
    return ((LustreStubSettings) getStubSettings()).deleteInstanceSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public OperationCallSettings<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationSettings() {
    return ((LustreStubSettings) getStubSettings()).deleteInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to rescheduleMaintenance. */
  public UnaryCallSettings<RescheduleMaintenanceRequest, Operation>
      rescheduleMaintenanceSettings() {
    return ((LustreStubSettings) getStubSettings()).rescheduleMaintenanceSettings();
  }

  /** Returns the object with the settings used for calls to rescheduleMaintenance. */
  public OperationCallSettings<RescheduleMaintenanceRequest, Instance, OperationMetadata>
      rescheduleMaintenanceOperationSettings() {
    return ((LustreStubSettings) getStubSettings()).rescheduleMaintenanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to importData. */
  public UnaryCallSettings<ImportDataRequest, Operation> importDataSettings() {
    return ((LustreStubSettings) getStubSettings()).importDataSettings();
  }

  /** Returns the object with the settings used for calls to importData. */
  public OperationCallSettings<ImportDataRequest, ImportDataResponse, ImportDataMetadata>
      importDataOperationSettings() {
    return ((LustreStubSettings) getStubSettings()).importDataOperationSettings();
  }

  /** Returns the object with the settings used for calls to exportData. */
  public UnaryCallSettings<ExportDataRequest, Operation> exportDataSettings() {
    return ((LustreStubSettings) getStubSettings()).exportDataSettings();
  }

  /** Returns the object with the settings used for calls to exportData. */
  public OperationCallSettings<ExportDataRequest, ExportDataResponse, ExportDataMetadata>
      exportDataOperationSettings() {
    return ((LustreStubSettings) getStubSettings()).exportDataOperationSettings();
  }

  /** Returns the object with the settings used for calls to createMirror. */
  public UnaryCallSettings<CreateMirrorRequest, Operation> createMirrorSettings() {
    return ((LustreStubSettings) getStubSettings()).createMirrorSettings();
  }

  /** Returns the object with the settings used for calls to createMirror. */
  public OperationCallSettings<CreateMirrorRequest, Mirror, CreateMirrorMetadata>
      createMirrorOperationSettings() {
    return ((LustreStubSettings) getStubSettings()).createMirrorOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateMirror. */
  public UnaryCallSettings<UpdateMirrorRequest, Operation> updateMirrorSettings() {
    return ((LustreStubSettings) getStubSettings()).updateMirrorSettings();
  }

  /** Returns the object with the settings used for calls to updateMirror. */
  public OperationCallSettings<UpdateMirrorRequest, Mirror, OperationMetadata>
      updateMirrorOperationSettings() {
    return ((LustreStubSettings) getStubSettings()).updateMirrorOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteMirror. */
  public UnaryCallSettings<DeleteMirrorRequest, Operation> deleteMirrorSettings() {
    return ((LustreStubSettings) getStubSettings()).deleteMirrorSettings();
  }

  /** Returns the object with the settings used for calls to deleteMirror. */
  public OperationCallSettings<DeleteMirrorRequest, Empty, OperationMetadata>
      deleteMirrorOperationSettings() {
    return ((LustreStubSettings) getStubSettings()).deleteMirrorOperationSettings();
  }

  /** Returns the object with the settings used for calls to getMirror. */
  public UnaryCallSettings<GetMirrorRequest, Mirror> getMirrorSettings() {
    return ((LustreStubSettings) getStubSettings()).getMirrorSettings();
  }

  /** Returns the object with the settings used for calls to listMirrors. */
  public PagedCallSettings<ListMirrorsRequest, ListMirrorsResponse, ListMirrorsPagedResponse>
      listMirrorsSettings() {
    return ((LustreStubSettings) getStubSettings()).listMirrorsSettings();
  }

  /** Returns the object with the settings used for calls to createDirectoryPolicy. */
  public UnaryCallSettings<CreateDirectoryPolicyRequest, Operation>
      createDirectoryPolicySettings() {
    return ((LustreStubSettings) getStubSettings()).createDirectoryPolicySettings();
  }

  /** Returns the object with the settings used for calls to createDirectoryPolicy. */
  public OperationCallSettings<CreateDirectoryPolicyRequest, DirectoryPolicy, OperationMetadata>
      createDirectoryPolicyOperationSettings() {
    return ((LustreStubSettings) getStubSettings()).createDirectoryPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteDirectoryPolicy. */
  public UnaryCallSettings<DeleteDirectoryPolicyRequest, Operation>
      deleteDirectoryPolicySettings() {
    return ((LustreStubSettings) getStubSettings()).deleteDirectoryPolicySettings();
  }

  /** Returns the object with the settings used for calls to deleteDirectoryPolicy. */
  public OperationCallSettings<DeleteDirectoryPolicyRequest, Empty, OperationMetadata>
      deleteDirectoryPolicyOperationSettings() {
    return ((LustreStubSettings) getStubSettings()).deleteDirectoryPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to getDirectoryPolicy. */
  public UnaryCallSettings<GetDirectoryPolicyRequest, DirectoryPolicy>
      getDirectoryPolicySettings() {
    return ((LustreStubSettings) getStubSettings()).getDirectoryPolicySettings();
  }

  /** Returns the object with the settings used for calls to listDirectoryPolicies. */
  public PagedCallSettings<
          ListDirectoryPoliciesRequest,
          ListDirectoryPoliciesResponse,
          ListDirectoryPoliciesPagedResponse>
      listDirectoryPoliciesSettings() {
    return ((LustreStubSettings) getStubSettings()).listDirectoryPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((LustreStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((LustreStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final LustreSettings create(LustreStubSettings stub) throws IOException {
    return new LustreSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return LustreStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return LustreStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return LustreStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return LustreStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return LustreStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return LustreStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return LustreStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return LustreStubSettings.defaultApiClientHeaderProviderBuilder();
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
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected LustreSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for LustreSettings. */
  public static class Builder extends ClientSettings.Builder<LustreSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(LustreStubSettings.newBuilder(clientContext));
    }

    protected Builder(LustreSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(LustreStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(LustreStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(LustreStubSettings.newHttpJsonBuilder());
    }

    public LustreStubSettings.Builder getStubSettingsBuilder() {
      return ((LustreStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listInstances. */
    public PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings() {
      return getStubSettingsBuilder().listInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to getInstance. */
    public UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings() {
      return getStubSettingsBuilder().getInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to createInstance. */
    public UnaryCallSettings.Builder<CreateInstanceRequest, Operation> createInstanceSettings() {
      return getStubSettingsBuilder().createInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to createInstance. */
    public OperationCallSettings.Builder<CreateInstanceRequest, Instance, OperationMetadata>
        createInstanceOperationSettings() {
      return getStubSettingsBuilder().createInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateInstance. */
    public UnaryCallSettings.Builder<UpdateInstanceRequest, Operation> updateInstanceSettings() {
      return getStubSettingsBuilder().updateInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to updateInstance. */
    public OperationCallSettings.Builder<UpdateInstanceRequest, Instance, OperationMetadata>
        updateInstanceOperationSettings() {
      return getStubSettingsBuilder().updateInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public UnaryCallSettings.Builder<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
      return getStubSettingsBuilder().deleteInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public OperationCallSettings.Builder<DeleteInstanceRequest, Empty, OperationMetadata>
        deleteInstanceOperationSettings() {
      return getStubSettingsBuilder().deleteInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to rescheduleMaintenance. */
    public UnaryCallSettings.Builder<RescheduleMaintenanceRequest, Operation>
        rescheduleMaintenanceSettings() {
      return getStubSettingsBuilder().rescheduleMaintenanceSettings();
    }

    /** Returns the builder for the settings used for calls to rescheduleMaintenance. */
    public OperationCallSettings.Builder<RescheduleMaintenanceRequest, Instance, OperationMetadata>
        rescheduleMaintenanceOperationSettings() {
      return getStubSettingsBuilder().rescheduleMaintenanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to importData. */
    public UnaryCallSettings.Builder<ImportDataRequest, Operation> importDataSettings() {
      return getStubSettingsBuilder().importDataSettings();
    }

    /** Returns the builder for the settings used for calls to importData. */
    public OperationCallSettings.Builder<ImportDataRequest, ImportDataResponse, ImportDataMetadata>
        importDataOperationSettings() {
      return getStubSettingsBuilder().importDataOperationSettings();
    }

    /** Returns the builder for the settings used for calls to exportData. */
    public UnaryCallSettings.Builder<ExportDataRequest, Operation> exportDataSettings() {
      return getStubSettingsBuilder().exportDataSettings();
    }

    /** Returns the builder for the settings used for calls to exportData. */
    public OperationCallSettings.Builder<ExportDataRequest, ExportDataResponse, ExportDataMetadata>
        exportDataOperationSettings() {
      return getStubSettingsBuilder().exportDataOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createMirror. */
    public UnaryCallSettings.Builder<CreateMirrorRequest, Operation> createMirrorSettings() {
      return getStubSettingsBuilder().createMirrorSettings();
    }

    /** Returns the builder for the settings used for calls to createMirror. */
    public OperationCallSettings.Builder<CreateMirrorRequest, Mirror, CreateMirrorMetadata>
        createMirrorOperationSettings() {
      return getStubSettingsBuilder().createMirrorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateMirror. */
    public UnaryCallSettings.Builder<UpdateMirrorRequest, Operation> updateMirrorSettings() {
      return getStubSettingsBuilder().updateMirrorSettings();
    }

    /** Returns the builder for the settings used for calls to updateMirror. */
    public OperationCallSettings.Builder<UpdateMirrorRequest, Mirror, OperationMetadata>
        updateMirrorOperationSettings() {
      return getStubSettingsBuilder().updateMirrorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMirror. */
    public UnaryCallSettings.Builder<DeleteMirrorRequest, Operation> deleteMirrorSettings() {
      return getStubSettingsBuilder().deleteMirrorSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMirror. */
    public OperationCallSettings.Builder<DeleteMirrorRequest, Empty, OperationMetadata>
        deleteMirrorOperationSettings() {
      return getStubSettingsBuilder().deleteMirrorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getMirror. */
    public UnaryCallSettings.Builder<GetMirrorRequest, Mirror> getMirrorSettings() {
      return getStubSettingsBuilder().getMirrorSettings();
    }

    /** Returns the builder for the settings used for calls to listMirrors. */
    public PagedCallSettings.Builder<
            ListMirrorsRequest, ListMirrorsResponse, ListMirrorsPagedResponse>
        listMirrorsSettings() {
      return getStubSettingsBuilder().listMirrorsSettings();
    }

    /** Returns the builder for the settings used for calls to createDirectoryPolicy. */
    public UnaryCallSettings.Builder<CreateDirectoryPolicyRequest, Operation>
        createDirectoryPolicySettings() {
      return getStubSettingsBuilder().createDirectoryPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createDirectoryPolicy. */
    public OperationCallSettings.Builder<
            CreateDirectoryPolicyRequest, DirectoryPolicy, OperationMetadata>
        createDirectoryPolicyOperationSettings() {
      return getStubSettingsBuilder().createDirectoryPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDirectoryPolicy. */
    public UnaryCallSettings.Builder<DeleteDirectoryPolicyRequest, Operation>
        deleteDirectoryPolicySettings() {
      return getStubSettingsBuilder().deleteDirectoryPolicySettings();
    }

    /** Returns the builder for the settings used for calls to deleteDirectoryPolicy. */
    public OperationCallSettings.Builder<DeleteDirectoryPolicyRequest, Empty, OperationMetadata>
        deleteDirectoryPolicyOperationSettings() {
      return getStubSettingsBuilder().deleteDirectoryPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getDirectoryPolicy. */
    public UnaryCallSettings.Builder<GetDirectoryPolicyRequest, DirectoryPolicy>
        getDirectoryPolicySettings() {
      return getStubSettingsBuilder().getDirectoryPolicySettings();
    }

    /** Returns the builder for the settings used for calls to listDirectoryPolicies. */
    public PagedCallSettings.Builder<
            ListDirectoryPoliciesRequest,
            ListDirectoryPoliciesResponse,
            ListDirectoryPoliciesPagedResponse>
        listDirectoryPoliciesSettings() {
      return getStubSettingsBuilder().listDirectoryPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    @Override
    public LustreSettings build() throws IOException {
      return new LustreSettings(this);
    }
  }
}
