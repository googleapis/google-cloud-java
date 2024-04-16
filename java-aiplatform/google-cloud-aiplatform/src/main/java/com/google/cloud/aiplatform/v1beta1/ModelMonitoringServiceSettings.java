/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.ListModelMonitoringJobsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.ListModelMonitorsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.SearchModelMonitoringAlertsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.SearchModelMonitoringStatsPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.stub.ModelMonitoringServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ModelMonitoringServiceClient}.
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
 * <p>For example, to set the total timeout of getModelMonitor to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ModelMonitoringServiceSettings.Builder modelMonitoringServiceSettingsBuilder =
 *     ModelMonitoringServiceSettings.newBuilder();
 * modelMonitoringServiceSettingsBuilder
 *     .getModelMonitorSettings()
 *     .setRetrySettings(
 *         modelMonitoringServiceSettingsBuilder
 *             .getModelMonitorSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ModelMonitoringServiceSettings modelMonitoringServiceSettings =
 *     modelMonitoringServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ModelMonitoringServiceSettings extends ClientSettings<ModelMonitoringServiceSettings> {

  /** Returns the object with the settings used for calls to createModelMonitor. */
  public UnaryCallSettings<CreateModelMonitorRequest, Operation> createModelMonitorSettings() {
    return ((ModelMonitoringServiceStubSettings) getStubSettings()).createModelMonitorSettings();
  }

  /** Returns the object with the settings used for calls to createModelMonitor. */
  public OperationCallSettings<
          CreateModelMonitorRequest, ModelMonitor, CreateModelMonitorOperationMetadata>
      createModelMonitorOperationSettings() {
    return ((ModelMonitoringServiceStubSettings) getStubSettings())
        .createModelMonitorOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateModelMonitor. */
  public UnaryCallSettings<UpdateModelMonitorRequest, Operation> updateModelMonitorSettings() {
    return ((ModelMonitoringServiceStubSettings) getStubSettings()).updateModelMonitorSettings();
  }

  /** Returns the object with the settings used for calls to updateModelMonitor. */
  public OperationCallSettings<
          UpdateModelMonitorRequest, ModelMonitor, UpdateModelMonitorOperationMetadata>
      updateModelMonitorOperationSettings() {
    return ((ModelMonitoringServiceStubSettings) getStubSettings())
        .updateModelMonitorOperationSettings();
  }

  /** Returns the object with the settings used for calls to getModelMonitor. */
  public UnaryCallSettings<GetModelMonitorRequest, ModelMonitor> getModelMonitorSettings() {
    return ((ModelMonitoringServiceStubSettings) getStubSettings()).getModelMonitorSettings();
  }

  /** Returns the object with the settings used for calls to listModelMonitors. */
  public PagedCallSettings<
          ListModelMonitorsRequest, ListModelMonitorsResponse, ListModelMonitorsPagedResponse>
      listModelMonitorsSettings() {
    return ((ModelMonitoringServiceStubSettings) getStubSettings()).listModelMonitorsSettings();
  }

  /** Returns the object with the settings used for calls to deleteModelMonitor. */
  public UnaryCallSettings<DeleteModelMonitorRequest, Operation> deleteModelMonitorSettings() {
    return ((ModelMonitoringServiceStubSettings) getStubSettings()).deleteModelMonitorSettings();
  }

  /** Returns the object with the settings used for calls to deleteModelMonitor. */
  public OperationCallSettings<DeleteModelMonitorRequest, Empty, DeleteOperationMetadata>
      deleteModelMonitorOperationSettings() {
    return ((ModelMonitoringServiceStubSettings) getStubSettings())
        .deleteModelMonitorOperationSettings();
  }

  /** Returns the object with the settings used for calls to createModelMonitoringJob. */
  public UnaryCallSettings<CreateModelMonitoringJobRequest, ModelMonitoringJob>
      createModelMonitoringJobSettings() {
    return ((ModelMonitoringServiceStubSettings) getStubSettings())
        .createModelMonitoringJobSettings();
  }

  /** Returns the object with the settings used for calls to getModelMonitoringJob. */
  public UnaryCallSettings<GetModelMonitoringJobRequest, ModelMonitoringJob>
      getModelMonitoringJobSettings() {
    return ((ModelMonitoringServiceStubSettings) getStubSettings()).getModelMonitoringJobSettings();
  }

  /** Returns the object with the settings used for calls to listModelMonitoringJobs. */
  public PagedCallSettings<
          ListModelMonitoringJobsRequest,
          ListModelMonitoringJobsResponse,
          ListModelMonitoringJobsPagedResponse>
      listModelMonitoringJobsSettings() {
    return ((ModelMonitoringServiceStubSettings) getStubSettings())
        .listModelMonitoringJobsSettings();
  }

  /** Returns the object with the settings used for calls to deleteModelMonitoringJob. */
  public UnaryCallSettings<DeleteModelMonitoringJobRequest, Operation>
      deleteModelMonitoringJobSettings() {
    return ((ModelMonitoringServiceStubSettings) getStubSettings())
        .deleteModelMonitoringJobSettings();
  }

  /** Returns the object with the settings used for calls to deleteModelMonitoringJob. */
  public OperationCallSettings<DeleteModelMonitoringJobRequest, Empty, DeleteOperationMetadata>
      deleteModelMonitoringJobOperationSettings() {
    return ((ModelMonitoringServiceStubSettings) getStubSettings())
        .deleteModelMonitoringJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to searchModelMonitoringStats. */
  public PagedCallSettings<
          SearchModelMonitoringStatsRequest,
          SearchModelMonitoringStatsResponse,
          SearchModelMonitoringStatsPagedResponse>
      searchModelMonitoringStatsSettings() {
    return ((ModelMonitoringServiceStubSettings) getStubSettings())
        .searchModelMonitoringStatsSettings();
  }

  /** Returns the object with the settings used for calls to searchModelMonitoringAlerts. */
  public PagedCallSettings<
          SearchModelMonitoringAlertsRequest,
          SearchModelMonitoringAlertsResponse,
          SearchModelMonitoringAlertsPagedResponse>
      searchModelMonitoringAlertsSettings() {
    return ((ModelMonitoringServiceStubSettings) getStubSettings())
        .searchModelMonitoringAlertsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ModelMonitoringServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ModelMonitoringServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((ModelMonitoringServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((ModelMonitoringServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((ModelMonitoringServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final ModelMonitoringServiceSettings create(ModelMonitoringServiceStubSettings stub)
      throws IOException {
    return new ModelMonitoringServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ModelMonitoringServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ModelMonitoringServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ModelMonitoringServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ModelMonitoringServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ModelMonitoringServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ModelMonitoringServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ModelMonitoringServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ModelMonitoringServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ModelMonitoringServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<ModelMonitoringServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ModelMonitoringServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ModelMonitoringServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ModelMonitoringServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ModelMonitoringServiceStubSettings.newBuilder());
    }

    public ModelMonitoringServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ModelMonitoringServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createModelMonitor. */
    public UnaryCallSettings.Builder<CreateModelMonitorRequest, Operation>
        createModelMonitorSettings() {
      return getStubSettingsBuilder().createModelMonitorSettings();
    }

    /** Returns the builder for the settings used for calls to createModelMonitor. */
    public OperationCallSettings.Builder<
            CreateModelMonitorRequest, ModelMonitor, CreateModelMonitorOperationMetadata>
        createModelMonitorOperationSettings() {
      return getStubSettingsBuilder().createModelMonitorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateModelMonitor. */
    public UnaryCallSettings.Builder<UpdateModelMonitorRequest, Operation>
        updateModelMonitorSettings() {
      return getStubSettingsBuilder().updateModelMonitorSettings();
    }

    /** Returns the builder for the settings used for calls to updateModelMonitor. */
    public OperationCallSettings.Builder<
            UpdateModelMonitorRequest, ModelMonitor, UpdateModelMonitorOperationMetadata>
        updateModelMonitorOperationSettings() {
      return getStubSettingsBuilder().updateModelMonitorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getModelMonitor. */
    public UnaryCallSettings.Builder<GetModelMonitorRequest, ModelMonitor>
        getModelMonitorSettings() {
      return getStubSettingsBuilder().getModelMonitorSettings();
    }

    /** Returns the builder for the settings used for calls to listModelMonitors. */
    public PagedCallSettings.Builder<
            ListModelMonitorsRequest, ListModelMonitorsResponse, ListModelMonitorsPagedResponse>
        listModelMonitorsSettings() {
      return getStubSettingsBuilder().listModelMonitorsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteModelMonitor. */
    public UnaryCallSettings.Builder<DeleteModelMonitorRequest, Operation>
        deleteModelMonitorSettings() {
      return getStubSettingsBuilder().deleteModelMonitorSettings();
    }

    /** Returns the builder for the settings used for calls to deleteModelMonitor. */
    public OperationCallSettings.Builder<DeleteModelMonitorRequest, Empty, DeleteOperationMetadata>
        deleteModelMonitorOperationSettings() {
      return getStubSettingsBuilder().deleteModelMonitorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createModelMonitoringJob. */
    public UnaryCallSettings.Builder<CreateModelMonitoringJobRequest, ModelMonitoringJob>
        createModelMonitoringJobSettings() {
      return getStubSettingsBuilder().createModelMonitoringJobSettings();
    }

    /** Returns the builder for the settings used for calls to getModelMonitoringJob. */
    public UnaryCallSettings.Builder<GetModelMonitoringJobRequest, ModelMonitoringJob>
        getModelMonitoringJobSettings() {
      return getStubSettingsBuilder().getModelMonitoringJobSettings();
    }

    /** Returns the builder for the settings used for calls to listModelMonitoringJobs. */
    public PagedCallSettings.Builder<
            ListModelMonitoringJobsRequest,
            ListModelMonitoringJobsResponse,
            ListModelMonitoringJobsPagedResponse>
        listModelMonitoringJobsSettings() {
      return getStubSettingsBuilder().listModelMonitoringJobsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteModelMonitoringJob. */
    public UnaryCallSettings.Builder<DeleteModelMonitoringJobRequest, Operation>
        deleteModelMonitoringJobSettings() {
      return getStubSettingsBuilder().deleteModelMonitoringJobSettings();
    }

    /** Returns the builder for the settings used for calls to deleteModelMonitoringJob. */
    public OperationCallSettings.Builder<
            DeleteModelMonitoringJobRequest, Empty, DeleteOperationMetadata>
        deleteModelMonitoringJobOperationSettings() {
      return getStubSettingsBuilder().deleteModelMonitoringJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to searchModelMonitoringStats. */
    public PagedCallSettings.Builder<
            SearchModelMonitoringStatsRequest,
            SearchModelMonitoringStatsResponse,
            SearchModelMonitoringStatsPagedResponse>
        searchModelMonitoringStatsSettings() {
      return getStubSettingsBuilder().searchModelMonitoringStatsSettings();
    }

    /** Returns the builder for the settings used for calls to searchModelMonitoringAlerts. */
    public PagedCallSettings.Builder<
            SearchModelMonitoringAlertsRequest,
            SearchModelMonitoringAlertsResponse,
            SearchModelMonitoringAlertsPagedResponse>
        searchModelMonitoringAlertsSettings() {
      return getStubSettingsBuilder().searchModelMonitoringAlertsSettings();
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

    @Override
    public ModelMonitoringServiceSettings build() throws IOException {
      return new ModelMonitoringServiceSettings(this);
    }
  }
}
