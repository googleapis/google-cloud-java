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

package com.google.cloud.aiplatform.v1;

import static com.google.cloud.aiplatform.v1.PipelineServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.PipelineServiceClient.ListPipelineJobsPagedResponse;
import static com.google.cloud.aiplatform.v1.PipelineServiceClient.ListTrainingPipelinesPagedResponse;

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
import com.google.cloud.aiplatform.v1.stub.PipelineServiceStubSettings;
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
 * Settings class to configure an instance of {@link PipelineServiceClient}.
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
 * <p>For example, to set the total timeout of createTrainingPipeline to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PipelineServiceSettings.Builder pipelineServiceSettingsBuilder =
 *     PipelineServiceSettings.newBuilder();
 * pipelineServiceSettingsBuilder
 *     .createTrainingPipelineSettings()
 *     .setRetrySettings(
 *         pipelineServiceSettingsBuilder
 *             .createTrainingPipelineSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PipelineServiceSettings pipelineServiceSettings = pipelineServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class PipelineServiceSettings extends ClientSettings<PipelineServiceSettings> {

  /** Returns the object with the settings used for calls to createTrainingPipeline. */
  public UnaryCallSettings<CreateTrainingPipelineRequest, TrainingPipeline>
      createTrainingPipelineSettings() {
    return ((PipelineServiceStubSettings) getStubSettings()).createTrainingPipelineSettings();
  }

  /** Returns the object with the settings used for calls to getTrainingPipeline. */
  public UnaryCallSettings<GetTrainingPipelineRequest, TrainingPipeline>
      getTrainingPipelineSettings() {
    return ((PipelineServiceStubSettings) getStubSettings()).getTrainingPipelineSettings();
  }

  /** Returns the object with the settings used for calls to listTrainingPipelines. */
  public PagedCallSettings<
          ListTrainingPipelinesRequest,
          ListTrainingPipelinesResponse,
          ListTrainingPipelinesPagedResponse>
      listTrainingPipelinesSettings() {
    return ((PipelineServiceStubSettings) getStubSettings()).listTrainingPipelinesSettings();
  }

  /** Returns the object with the settings used for calls to deleteTrainingPipeline. */
  public UnaryCallSettings<DeleteTrainingPipelineRequest, Operation>
      deleteTrainingPipelineSettings() {
    return ((PipelineServiceStubSettings) getStubSettings()).deleteTrainingPipelineSettings();
  }

  /** Returns the object with the settings used for calls to deleteTrainingPipeline. */
  public OperationCallSettings<DeleteTrainingPipelineRequest, Empty, DeleteOperationMetadata>
      deleteTrainingPipelineOperationSettings() {
    return ((PipelineServiceStubSettings) getStubSettings())
        .deleteTrainingPipelineOperationSettings();
  }

  /** Returns the object with the settings used for calls to cancelTrainingPipeline. */
  public UnaryCallSettings<CancelTrainingPipelineRequest, Empty> cancelTrainingPipelineSettings() {
    return ((PipelineServiceStubSettings) getStubSettings()).cancelTrainingPipelineSettings();
  }

  /** Returns the object with the settings used for calls to createPipelineJob. */
  public UnaryCallSettings<CreatePipelineJobRequest, PipelineJob> createPipelineJobSettings() {
    return ((PipelineServiceStubSettings) getStubSettings()).createPipelineJobSettings();
  }

  /** Returns the object with the settings used for calls to getPipelineJob. */
  public UnaryCallSettings<GetPipelineJobRequest, PipelineJob> getPipelineJobSettings() {
    return ((PipelineServiceStubSettings) getStubSettings()).getPipelineJobSettings();
  }

  /** Returns the object with the settings used for calls to listPipelineJobs. */
  public PagedCallSettings<
          ListPipelineJobsRequest, ListPipelineJobsResponse, ListPipelineJobsPagedResponse>
      listPipelineJobsSettings() {
    return ((PipelineServiceStubSettings) getStubSettings()).listPipelineJobsSettings();
  }

  /** Returns the object with the settings used for calls to deletePipelineJob. */
  public UnaryCallSettings<DeletePipelineJobRequest, Operation> deletePipelineJobSettings() {
    return ((PipelineServiceStubSettings) getStubSettings()).deletePipelineJobSettings();
  }

  /** Returns the object with the settings used for calls to deletePipelineJob. */
  public OperationCallSettings<DeletePipelineJobRequest, Empty, DeleteOperationMetadata>
      deletePipelineJobOperationSettings() {
    return ((PipelineServiceStubSettings) getStubSettings()).deletePipelineJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to cancelPipelineJob. */
  public UnaryCallSettings<CancelPipelineJobRequest, Empty> cancelPipelineJobSettings() {
    return ((PipelineServiceStubSettings) getStubSettings()).cancelPipelineJobSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((PipelineServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((PipelineServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((PipelineServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((PipelineServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((PipelineServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final PipelineServiceSettings create(PipelineServiceStubSettings stub)
      throws IOException {
    return new PipelineServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return PipelineServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return PipelineServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return PipelineServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return PipelineServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return PipelineServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return PipelineServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PipelineServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected PipelineServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for PipelineServiceSettings. */
  public static class Builder extends ClientSettings.Builder<PipelineServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(PipelineServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(PipelineServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(PipelineServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(PipelineServiceStubSettings.newBuilder());
    }

    public PipelineServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((PipelineServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createTrainingPipeline. */
    public UnaryCallSettings.Builder<CreateTrainingPipelineRequest, TrainingPipeline>
        createTrainingPipelineSettings() {
      return getStubSettingsBuilder().createTrainingPipelineSettings();
    }

    /** Returns the builder for the settings used for calls to getTrainingPipeline. */
    public UnaryCallSettings.Builder<GetTrainingPipelineRequest, TrainingPipeline>
        getTrainingPipelineSettings() {
      return getStubSettingsBuilder().getTrainingPipelineSettings();
    }

    /** Returns the builder for the settings used for calls to listTrainingPipelines. */
    public PagedCallSettings.Builder<
            ListTrainingPipelinesRequest,
            ListTrainingPipelinesResponse,
            ListTrainingPipelinesPagedResponse>
        listTrainingPipelinesSettings() {
      return getStubSettingsBuilder().listTrainingPipelinesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTrainingPipeline. */
    public UnaryCallSettings.Builder<DeleteTrainingPipelineRequest, Operation>
        deleteTrainingPipelineSettings() {
      return getStubSettingsBuilder().deleteTrainingPipelineSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTrainingPipeline. */
    public OperationCallSettings.Builder<
            DeleteTrainingPipelineRequest, Empty, DeleteOperationMetadata>
        deleteTrainingPipelineOperationSettings() {
      return getStubSettingsBuilder().deleteTrainingPipelineOperationSettings();
    }

    /** Returns the builder for the settings used for calls to cancelTrainingPipeline. */
    public UnaryCallSettings.Builder<CancelTrainingPipelineRequest, Empty>
        cancelTrainingPipelineSettings() {
      return getStubSettingsBuilder().cancelTrainingPipelineSettings();
    }

    /** Returns the builder for the settings used for calls to createPipelineJob. */
    public UnaryCallSettings.Builder<CreatePipelineJobRequest, PipelineJob>
        createPipelineJobSettings() {
      return getStubSettingsBuilder().createPipelineJobSettings();
    }

    /** Returns the builder for the settings used for calls to getPipelineJob. */
    public UnaryCallSettings.Builder<GetPipelineJobRequest, PipelineJob> getPipelineJobSettings() {
      return getStubSettingsBuilder().getPipelineJobSettings();
    }

    /** Returns the builder for the settings used for calls to listPipelineJobs. */
    public PagedCallSettings.Builder<
            ListPipelineJobsRequest, ListPipelineJobsResponse, ListPipelineJobsPagedResponse>
        listPipelineJobsSettings() {
      return getStubSettingsBuilder().listPipelineJobsSettings();
    }

    /** Returns the builder for the settings used for calls to deletePipelineJob. */
    public UnaryCallSettings.Builder<DeletePipelineJobRequest, Operation>
        deletePipelineJobSettings() {
      return getStubSettingsBuilder().deletePipelineJobSettings();
    }

    /** Returns the builder for the settings used for calls to deletePipelineJob. */
    public OperationCallSettings.Builder<DeletePipelineJobRequest, Empty, DeleteOperationMetadata>
        deletePipelineJobOperationSettings() {
      return getStubSettingsBuilder().deletePipelineJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to cancelPipelineJob. */
    public UnaryCallSettings.Builder<CancelPipelineJobRequest, Empty> cancelPipelineJobSettings() {
      return getStubSettingsBuilder().cancelPipelineJobSettings();
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
    public PipelineServiceSettings build() throws IOException {
      return new PipelineServiceSettings(this);
    }
  }
}
