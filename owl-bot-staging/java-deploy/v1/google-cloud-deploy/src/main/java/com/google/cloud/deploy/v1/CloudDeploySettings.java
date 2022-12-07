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

package com.google.cloud.deploy.v1;

import static com.google.cloud.deploy.v1.CloudDeployClient.ListDeliveryPipelinesPagedResponse;
import static com.google.cloud.deploy.v1.CloudDeployClient.ListJobRunsPagedResponse;
import static com.google.cloud.deploy.v1.CloudDeployClient.ListLocationsPagedResponse;
import static com.google.cloud.deploy.v1.CloudDeployClient.ListReleasesPagedResponse;
import static com.google.cloud.deploy.v1.CloudDeployClient.ListRolloutsPagedResponse;
import static com.google.cloud.deploy.v1.CloudDeployClient.ListTargetsPagedResponse;

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
import com.google.cloud.deploy.v1.stub.CloudDeployStubSettings;
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
 * Settings class to configure an instance of {@link CloudDeployClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (clouddeploy.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getDeliveryPipeline to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudDeploySettings.Builder cloudDeploySettingsBuilder = CloudDeploySettings.newBuilder();
 * cloudDeploySettingsBuilder
 *     .getDeliveryPipelineSettings()
 *     .setRetrySettings(
 *         cloudDeploySettingsBuilder.getDeliveryPipelineSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CloudDeploySettings cloudDeploySettings = cloudDeploySettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CloudDeploySettings extends ClientSettings<CloudDeploySettings> {

  /** Returns the object with the settings used for calls to listDeliveryPipelines. */
  public PagedCallSettings<
          ListDeliveryPipelinesRequest,
          ListDeliveryPipelinesResponse,
          ListDeliveryPipelinesPagedResponse>
      listDeliveryPipelinesSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).listDeliveryPipelinesSettings();
  }

  /** Returns the object with the settings used for calls to getDeliveryPipeline. */
  public UnaryCallSettings<GetDeliveryPipelineRequest, DeliveryPipeline>
      getDeliveryPipelineSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).getDeliveryPipelineSettings();
  }

  /** Returns the object with the settings used for calls to createDeliveryPipeline. */
  public UnaryCallSettings<CreateDeliveryPipelineRequest, Operation>
      createDeliveryPipelineSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).createDeliveryPipelineSettings();
  }

  /** Returns the object with the settings used for calls to createDeliveryPipeline. */
  public OperationCallSettings<CreateDeliveryPipelineRequest, DeliveryPipeline, OperationMetadata>
      createDeliveryPipelineOperationSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).createDeliveryPipelineOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateDeliveryPipeline. */
  public UnaryCallSettings<UpdateDeliveryPipelineRequest, Operation>
      updateDeliveryPipelineSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).updateDeliveryPipelineSettings();
  }

  /** Returns the object with the settings used for calls to updateDeliveryPipeline. */
  public OperationCallSettings<UpdateDeliveryPipelineRequest, DeliveryPipeline, OperationMetadata>
      updateDeliveryPipelineOperationSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).updateDeliveryPipelineOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteDeliveryPipeline. */
  public UnaryCallSettings<DeleteDeliveryPipelineRequest, Operation>
      deleteDeliveryPipelineSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).deleteDeliveryPipelineSettings();
  }

  /** Returns the object with the settings used for calls to deleteDeliveryPipeline. */
  public OperationCallSettings<DeleteDeliveryPipelineRequest, Empty, OperationMetadata>
      deleteDeliveryPipelineOperationSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).deleteDeliveryPipelineOperationSettings();
  }

  /** Returns the object with the settings used for calls to listTargets. */
  public PagedCallSettings<ListTargetsRequest, ListTargetsResponse, ListTargetsPagedResponse>
      listTargetsSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).listTargetsSettings();
  }

  /** Returns the object with the settings used for calls to getTarget. */
  public UnaryCallSettings<GetTargetRequest, Target> getTargetSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).getTargetSettings();
  }

  /** Returns the object with the settings used for calls to createTarget. */
  public UnaryCallSettings<CreateTargetRequest, Operation> createTargetSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).createTargetSettings();
  }

  /** Returns the object with the settings used for calls to createTarget. */
  public OperationCallSettings<CreateTargetRequest, Target, OperationMetadata>
      createTargetOperationSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).createTargetOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateTarget. */
  public UnaryCallSettings<UpdateTargetRequest, Operation> updateTargetSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).updateTargetSettings();
  }

  /** Returns the object with the settings used for calls to updateTarget. */
  public OperationCallSettings<UpdateTargetRequest, Target, OperationMetadata>
      updateTargetOperationSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).updateTargetOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteTarget. */
  public UnaryCallSettings<DeleteTargetRequest, Operation> deleteTargetSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).deleteTargetSettings();
  }

  /** Returns the object with the settings used for calls to deleteTarget. */
  public OperationCallSettings<DeleteTargetRequest, Empty, OperationMetadata>
      deleteTargetOperationSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).deleteTargetOperationSettings();
  }

  /** Returns the object with the settings used for calls to listReleases. */
  public PagedCallSettings<ListReleasesRequest, ListReleasesResponse, ListReleasesPagedResponse>
      listReleasesSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).listReleasesSettings();
  }

  /** Returns the object with the settings used for calls to getRelease. */
  public UnaryCallSettings<GetReleaseRequest, Release> getReleaseSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).getReleaseSettings();
  }

  /** Returns the object with the settings used for calls to createRelease. */
  public UnaryCallSettings<CreateReleaseRequest, Operation> createReleaseSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).createReleaseSettings();
  }

  /** Returns the object with the settings used for calls to createRelease. */
  public OperationCallSettings<CreateReleaseRequest, Release, OperationMetadata>
      createReleaseOperationSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).createReleaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to abandonRelease. */
  public UnaryCallSettings<AbandonReleaseRequest, AbandonReleaseResponse> abandonReleaseSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).abandonReleaseSettings();
  }

  /** Returns the object with the settings used for calls to approveRollout. */
  public UnaryCallSettings<ApproveRolloutRequest, ApproveRolloutResponse> approveRolloutSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).approveRolloutSettings();
  }

  /** Returns the object with the settings used for calls to listRollouts. */
  public PagedCallSettings<ListRolloutsRequest, ListRolloutsResponse, ListRolloutsPagedResponse>
      listRolloutsSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).listRolloutsSettings();
  }

  /** Returns the object with the settings used for calls to getRollout. */
  public UnaryCallSettings<GetRolloutRequest, Rollout> getRolloutSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).getRolloutSettings();
  }

  /** Returns the object with the settings used for calls to createRollout. */
  public UnaryCallSettings<CreateRolloutRequest, Operation> createRolloutSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).createRolloutSettings();
  }

  /** Returns the object with the settings used for calls to createRollout. */
  public OperationCallSettings<CreateRolloutRequest, Rollout, OperationMetadata>
      createRolloutOperationSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).createRolloutOperationSettings();
  }

  /** Returns the object with the settings used for calls to retryJob. */
  public UnaryCallSettings<RetryJobRequest, RetryJobResponse> retryJobSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).retryJobSettings();
  }

  /** Returns the object with the settings used for calls to listJobRuns. */
  public PagedCallSettings<ListJobRunsRequest, ListJobRunsResponse, ListJobRunsPagedResponse>
      listJobRunsSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).listJobRunsSettings();
  }

  /** Returns the object with the settings used for calls to getJobRun. */
  public UnaryCallSettings<GetJobRunRequest, JobRun> getJobRunSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).getJobRunSettings();
  }

  /** Returns the object with the settings used for calls to getConfig. */
  public UnaryCallSettings<GetConfigRequest, Config> getConfigSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).getConfigSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((CloudDeployStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((CloudDeployStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((CloudDeployStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final CloudDeploySettings create(CloudDeployStubSettings stub) throws IOException {
    return new CloudDeploySettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CloudDeployStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CloudDeployStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CloudDeployStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CloudDeployStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return CloudDeployStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CloudDeployStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CloudDeployStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CloudDeployStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected CloudDeploySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CloudDeploySettings. */
  public static class Builder extends ClientSettings.Builder<CloudDeploySettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(CloudDeployStubSettings.newBuilder(clientContext));
    }

    protected Builder(CloudDeploySettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CloudDeployStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CloudDeployStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(CloudDeployStubSettings.newHttpJsonBuilder());
    }

    public CloudDeployStubSettings.Builder getStubSettingsBuilder() {
      return ((CloudDeployStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listDeliveryPipelines. */
    public PagedCallSettings.Builder<
            ListDeliveryPipelinesRequest,
            ListDeliveryPipelinesResponse,
            ListDeliveryPipelinesPagedResponse>
        listDeliveryPipelinesSettings() {
      return getStubSettingsBuilder().listDeliveryPipelinesSettings();
    }

    /** Returns the builder for the settings used for calls to getDeliveryPipeline. */
    public UnaryCallSettings.Builder<GetDeliveryPipelineRequest, DeliveryPipeline>
        getDeliveryPipelineSettings() {
      return getStubSettingsBuilder().getDeliveryPipelineSettings();
    }

    /** Returns the builder for the settings used for calls to createDeliveryPipeline. */
    public UnaryCallSettings.Builder<CreateDeliveryPipelineRequest, Operation>
        createDeliveryPipelineSettings() {
      return getStubSettingsBuilder().createDeliveryPipelineSettings();
    }

    /** Returns the builder for the settings used for calls to createDeliveryPipeline. */
    public OperationCallSettings.Builder<
            CreateDeliveryPipelineRequest, DeliveryPipeline, OperationMetadata>
        createDeliveryPipelineOperationSettings() {
      return getStubSettingsBuilder().createDeliveryPipelineOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateDeliveryPipeline. */
    public UnaryCallSettings.Builder<UpdateDeliveryPipelineRequest, Operation>
        updateDeliveryPipelineSettings() {
      return getStubSettingsBuilder().updateDeliveryPipelineSettings();
    }

    /** Returns the builder for the settings used for calls to updateDeliveryPipeline. */
    public OperationCallSettings.Builder<
            UpdateDeliveryPipelineRequest, DeliveryPipeline, OperationMetadata>
        updateDeliveryPipelineOperationSettings() {
      return getStubSettingsBuilder().updateDeliveryPipelineOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDeliveryPipeline. */
    public UnaryCallSettings.Builder<DeleteDeliveryPipelineRequest, Operation>
        deleteDeliveryPipelineSettings() {
      return getStubSettingsBuilder().deleteDeliveryPipelineSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDeliveryPipeline. */
    public OperationCallSettings.Builder<DeleteDeliveryPipelineRequest, Empty, OperationMetadata>
        deleteDeliveryPipelineOperationSettings() {
      return getStubSettingsBuilder().deleteDeliveryPipelineOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listTargets. */
    public PagedCallSettings.Builder<
            ListTargetsRequest, ListTargetsResponse, ListTargetsPagedResponse>
        listTargetsSettings() {
      return getStubSettingsBuilder().listTargetsSettings();
    }

    /** Returns the builder for the settings used for calls to getTarget. */
    public UnaryCallSettings.Builder<GetTargetRequest, Target> getTargetSettings() {
      return getStubSettingsBuilder().getTargetSettings();
    }

    /** Returns the builder for the settings used for calls to createTarget. */
    public UnaryCallSettings.Builder<CreateTargetRequest, Operation> createTargetSettings() {
      return getStubSettingsBuilder().createTargetSettings();
    }

    /** Returns the builder for the settings used for calls to createTarget. */
    public OperationCallSettings.Builder<CreateTargetRequest, Target, OperationMetadata>
        createTargetOperationSettings() {
      return getStubSettingsBuilder().createTargetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateTarget. */
    public UnaryCallSettings.Builder<UpdateTargetRequest, Operation> updateTargetSettings() {
      return getStubSettingsBuilder().updateTargetSettings();
    }

    /** Returns the builder for the settings used for calls to updateTarget. */
    public OperationCallSettings.Builder<UpdateTargetRequest, Target, OperationMetadata>
        updateTargetOperationSettings() {
      return getStubSettingsBuilder().updateTargetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTarget. */
    public UnaryCallSettings.Builder<DeleteTargetRequest, Operation> deleteTargetSettings() {
      return getStubSettingsBuilder().deleteTargetSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTarget. */
    public OperationCallSettings.Builder<DeleteTargetRequest, Empty, OperationMetadata>
        deleteTargetOperationSettings() {
      return getStubSettingsBuilder().deleteTargetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listReleases. */
    public PagedCallSettings.Builder<
            ListReleasesRequest, ListReleasesResponse, ListReleasesPagedResponse>
        listReleasesSettings() {
      return getStubSettingsBuilder().listReleasesSettings();
    }

    /** Returns the builder for the settings used for calls to getRelease. */
    public UnaryCallSettings.Builder<GetReleaseRequest, Release> getReleaseSettings() {
      return getStubSettingsBuilder().getReleaseSettings();
    }

    /** Returns the builder for the settings used for calls to createRelease. */
    public UnaryCallSettings.Builder<CreateReleaseRequest, Operation> createReleaseSettings() {
      return getStubSettingsBuilder().createReleaseSettings();
    }

    /** Returns the builder for the settings used for calls to createRelease. */
    public OperationCallSettings.Builder<CreateReleaseRequest, Release, OperationMetadata>
        createReleaseOperationSettings() {
      return getStubSettingsBuilder().createReleaseOperationSettings();
    }

    /** Returns the builder for the settings used for calls to abandonRelease. */
    public UnaryCallSettings.Builder<AbandonReleaseRequest, AbandonReleaseResponse>
        abandonReleaseSettings() {
      return getStubSettingsBuilder().abandonReleaseSettings();
    }

    /** Returns the builder for the settings used for calls to approveRollout. */
    public UnaryCallSettings.Builder<ApproveRolloutRequest, ApproveRolloutResponse>
        approveRolloutSettings() {
      return getStubSettingsBuilder().approveRolloutSettings();
    }

    /** Returns the builder for the settings used for calls to listRollouts. */
    public PagedCallSettings.Builder<
            ListRolloutsRequest, ListRolloutsResponse, ListRolloutsPagedResponse>
        listRolloutsSettings() {
      return getStubSettingsBuilder().listRolloutsSettings();
    }

    /** Returns the builder for the settings used for calls to getRollout. */
    public UnaryCallSettings.Builder<GetRolloutRequest, Rollout> getRolloutSettings() {
      return getStubSettingsBuilder().getRolloutSettings();
    }

    /** Returns the builder for the settings used for calls to createRollout. */
    public UnaryCallSettings.Builder<CreateRolloutRequest, Operation> createRolloutSettings() {
      return getStubSettingsBuilder().createRolloutSettings();
    }

    /** Returns the builder for the settings used for calls to createRollout. */
    public OperationCallSettings.Builder<CreateRolloutRequest, Rollout, OperationMetadata>
        createRolloutOperationSettings() {
      return getStubSettingsBuilder().createRolloutOperationSettings();
    }

    /** Returns the builder for the settings used for calls to retryJob. */
    public UnaryCallSettings.Builder<RetryJobRequest, RetryJobResponse> retryJobSettings() {
      return getStubSettingsBuilder().retryJobSettings();
    }

    /** Returns the builder for the settings used for calls to listJobRuns. */
    public PagedCallSettings.Builder<
            ListJobRunsRequest, ListJobRunsResponse, ListJobRunsPagedResponse>
        listJobRunsSettings() {
      return getStubSettingsBuilder().listJobRunsSettings();
    }

    /** Returns the builder for the settings used for calls to getJobRun. */
    public UnaryCallSettings.Builder<GetJobRunRequest, JobRun> getJobRunSettings() {
      return getStubSettingsBuilder().getJobRunSettings();
    }

    /** Returns the builder for the settings used for calls to getConfig. */
    public UnaryCallSettings.Builder<GetConfigRequest, Config> getConfigSettings() {
      return getStubSettingsBuilder().getConfigSettings();
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
    public CloudDeploySettings build() throws IOException {
      return new CloudDeploySettings(this);
    }
  }
}
