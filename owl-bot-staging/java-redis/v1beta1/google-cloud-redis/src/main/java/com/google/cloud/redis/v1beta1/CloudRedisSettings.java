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

package com.google.cloud.redis.v1beta1;

import static com.google.cloud.redis.v1beta1.CloudRedisClient.ListInstancesPagedResponse;

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
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.redis.v1beta1.stub.CloudRedisStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CloudRedisClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (redis.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getInstance to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudRedisSettings.Builder cloudRedisSettingsBuilder = CloudRedisSettings.newBuilder();
 * cloudRedisSettingsBuilder
 *     .getInstanceSettings()
 *     .setRetrySettings(
 *         cloudRedisSettingsBuilder.getInstanceSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CloudRedisSettings cloudRedisSettings = cloudRedisSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class CloudRedisSettings extends ClientSettings<CloudRedisSettings> {

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings() {
    return ((CloudRedisStubSettings) getStubSettings()).listInstancesSettings();
  }

  /** Returns the object with the settings used for calls to getInstance. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings() {
    return ((CloudRedisStubSettings) getStubSettings()).getInstanceSettings();
  }

  /** Returns the object with the settings used for calls to getInstanceAuthString. */
  public UnaryCallSettings<GetInstanceAuthStringRequest, InstanceAuthString>
      getInstanceAuthStringSettings() {
    return ((CloudRedisStubSettings) getStubSettings()).getInstanceAuthStringSettings();
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public UnaryCallSettings<CreateInstanceRequest, Operation> createInstanceSettings() {
    return ((CloudRedisStubSettings) getStubSettings()).createInstanceSettings();
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public OperationCallSettings<CreateInstanceRequest, Instance, Any>
      createInstanceOperationSettings() {
    return ((CloudRedisStubSettings) getStubSettings()).createInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateInstance. */
  public UnaryCallSettings<UpdateInstanceRequest, Operation> updateInstanceSettings() {
    return ((CloudRedisStubSettings) getStubSettings()).updateInstanceSettings();
  }

  /** Returns the object with the settings used for calls to updateInstance. */
  public OperationCallSettings<UpdateInstanceRequest, Instance, Any>
      updateInstanceOperationSettings() {
    return ((CloudRedisStubSettings) getStubSettings()).updateInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to upgradeInstance. */
  public UnaryCallSettings<UpgradeInstanceRequest, Operation> upgradeInstanceSettings() {
    return ((CloudRedisStubSettings) getStubSettings()).upgradeInstanceSettings();
  }

  /** Returns the object with the settings used for calls to upgradeInstance. */
  public OperationCallSettings<UpgradeInstanceRequest, Instance, Any>
      upgradeInstanceOperationSettings() {
    return ((CloudRedisStubSettings) getStubSettings()).upgradeInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to importInstance. */
  public UnaryCallSettings<ImportInstanceRequest, Operation> importInstanceSettings() {
    return ((CloudRedisStubSettings) getStubSettings()).importInstanceSettings();
  }

  /** Returns the object with the settings used for calls to importInstance. */
  public OperationCallSettings<ImportInstanceRequest, Instance, Any>
      importInstanceOperationSettings() {
    return ((CloudRedisStubSettings) getStubSettings()).importInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to exportInstance. */
  public UnaryCallSettings<ExportInstanceRequest, Operation> exportInstanceSettings() {
    return ((CloudRedisStubSettings) getStubSettings()).exportInstanceSettings();
  }

  /** Returns the object with the settings used for calls to exportInstance. */
  public OperationCallSettings<ExportInstanceRequest, Instance, Any>
      exportInstanceOperationSettings() {
    return ((CloudRedisStubSettings) getStubSettings()).exportInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to failoverInstance. */
  public UnaryCallSettings<FailoverInstanceRequest, Operation> failoverInstanceSettings() {
    return ((CloudRedisStubSettings) getStubSettings()).failoverInstanceSettings();
  }

  /** Returns the object with the settings used for calls to failoverInstance. */
  public OperationCallSettings<FailoverInstanceRequest, Instance, Any>
      failoverInstanceOperationSettings() {
    return ((CloudRedisStubSettings) getStubSettings()).failoverInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public UnaryCallSettings<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
    return ((CloudRedisStubSettings) getStubSettings()).deleteInstanceSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public OperationCallSettings<DeleteInstanceRequest, Empty, Any>
      deleteInstanceOperationSettings() {
    return ((CloudRedisStubSettings) getStubSettings()).deleteInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to rescheduleMaintenance. */
  public UnaryCallSettings<RescheduleMaintenanceRequest, Operation>
      rescheduleMaintenanceSettings() {
    return ((CloudRedisStubSettings) getStubSettings()).rescheduleMaintenanceSettings();
  }

  /** Returns the object with the settings used for calls to rescheduleMaintenance. */
  public OperationCallSettings<RescheduleMaintenanceRequest, Instance, Any>
      rescheduleMaintenanceOperationSettings() {
    return ((CloudRedisStubSettings) getStubSettings()).rescheduleMaintenanceOperationSettings();
  }

  public static final CloudRedisSettings create(CloudRedisStubSettings stub) throws IOException {
    return new CloudRedisSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CloudRedisStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CloudRedisStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CloudRedisStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CloudRedisStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return CloudRedisStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CloudRedisStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CloudRedisStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CloudRedisStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected CloudRedisSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CloudRedisSettings. */
  public static class Builder extends ClientSettings.Builder<CloudRedisSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(CloudRedisStubSettings.newBuilder(clientContext));
    }

    protected Builder(CloudRedisSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CloudRedisStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CloudRedisStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(CloudRedisStubSettings.newHttpJsonBuilder());
    }

    public CloudRedisStubSettings.Builder getStubSettingsBuilder() {
      return ((CloudRedisStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getInstanceAuthString. */
    public UnaryCallSettings.Builder<GetInstanceAuthStringRequest, InstanceAuthString>
        getInstanceAuthStringSettings() {
      return getStubSettingsBuilder().getInstanceAuthStringSettings();
    }

    /** Returns the builder for the settings used for calls to createInstance. */
    public UnaryCallSettings.Builder<CreateInstanceRequest, Operation> createInstanceSettings() {
      return getStubSettingsBuilder().createInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to createInstance. */
    public OperationCallSettings.Builder<CreateInstanceRequest, Instance, Any>
        createInstanceOperationSettings() {
      return getStubSettingsBuilder().createInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateInstance. */
    public UnaryCallSettings.Builder<UpdateInstanceRequest, Operation> updateInstanceSettings() {
      return getStubSettingsBuilder().updateInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to updateInstance. */
    public OperationCallSettings.Builder<UpdateInstanceRequest, Instance, Any>
        updateInstanceOperationSettings() {
      return getStubSettingsBuilder().updateInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to upgradeInstance. */
    public UnaryCallSettings.Builder<UpgradeInstanceRequest, Operation> upgradeInstanceSettings() {
      return getStubSettingsBuilder().upgradeInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to upgradeInstance. */
    public OperationCallSettings.Builder<UpgradeInstanceRequest, Instance, Any>
        upgradeInstanceOperationSettings() {
      return getStubSettingsBuilder().upgradeInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to importInstance. */
    public UnaryCallSettings.Builder<ImportInstanceRequest, Operation> importInstanceSettings() {
      return getStubSettingsBuilder().importInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to importInstance. */
    public OperationCallSettings.Builder<ImportInstanceRequest, Instance, Any>
        importInstanceOperationSettings() {
      return getStubSettingsBuilder().importInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to exportInstance. */
    public UnaryCallSettings.Builder<ExportInstanceRequest, Operation> exportInstanceSettings() {
      return getStubSettingsBuilder().exportInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to exportInstance. */
    public OperationCallSettings.Builder<ExportInstanceRequest, Instance, Any>
        exportInstanceOperationSettings() {
      return getStubSettingsBuilder().exportInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to failoverInstance. */
    public UnaryCallSettings.Builder<FailoverInstanceRequest, Operation>
        failoverInstanceSettings() {
      return getStubSettingsBuilder().failoverInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to failoverInstance. */
    public OperationCallSettings.Builder<FailoverInstanceRequest, Instance, Any>
        failoverInstanceOperationSettings() {
      return getStubSettingsBuilder().failoverInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public UnaryCallSettings.Builder<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
      return getStubSettingsBuilder().deleteInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public OperationCallSettings.Builder<DeleteInstanceRequest, Empty, Any>
        deleteInstanceOperationSettings() {
      return getStubSettingsBuilder().deleteInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to rescheduleMaintenance. */
    public UnaryCallSettings.Builder<RescheduleMaintenanceRequest, Operation>
        rescheduleMaintenanceSettings() {
      return getStubSettingsBuilder().rescheduleMaintenanceSettings();
    }

    /** Returns the builder for the settings used for calls to rescheduleMaintenance. */
    public OperationCallSettings.Builder<RescheduleMaintenanceRequest, Instance, Any>
        rescheduleMaintenanceOperationSettings() {
      return getStubSettingsBuilder().rescheduleMaintenanceOperationSettings();
    }

    @Override
    public CloudRedisSettings build() throws IOException {
      return new CloudRedisSettings(this);
    }
  }
}
