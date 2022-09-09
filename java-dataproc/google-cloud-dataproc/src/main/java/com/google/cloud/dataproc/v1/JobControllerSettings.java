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

package com.google.cloud.dataproc.v1;

import static com.google.cloud.dataproc.v1.JobControllerClient.ListJobsPagedResponse;

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
import com.google.cloud.dataproc.v1.stub.JobControllerStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link JobControllerClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataproc.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of submitJob to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * JobControllerSettings.Builder jobControllerSettingsBuilder = JobControllerSettings.newBuilder();
 * jobControllerSettingsBuilder
 *     .submitJobSettings()
 *     .setRetrySettings(
 *         jobControllerSettingsBuilder.submitJobSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * JobControllerSettings jobControllerSettings = jobControllerSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class JobControllerSettings extends ClientSettings<JobControllerSettings> {

  /** Returns the object with the settings used for calls to submitJob. */
  public UnaryCallSettings<SubmitJobRequest, Job> submitJobSettings() {
    return ((JobControllerStubSettings) getStubSettings()).submitJobSettings();
  }

  /** Returns the object with the settings used for calls to submitJobAs. */
  public UnaryCallSettings<SubmitJobRequest, Operation> submitJobAsOperationSettings() {
    return ((JobControllerStubSettings) getStubSettings()).submitJobAsOperationSettings();
  }

  /** Returns the object with the settings used for calls to submitJobAsOperation. */
  public OperationCallSettings<SubmitJobRequest, Job, JobMetadata>
      submitJobAsOperationOperationSettings() {
    return ((JobControllerStubSettings) getStubSettings()).submitJobAsOperationOperationSettings();
  }

  /** Returns the object with the settings used for calls to getJob. */
  public UnaryCallSettings<GetJobRequest, Job> getJobSettings() {
    return ((JobControllerStubSettings) getStubSettings()).getJobSettings();
  }

  /** Returns the object with the settings used for calls to listJobs. */
  public PagedCallSettings<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
      listJobsSettings() {
    return ((JobControllerStubSettings) getStubSettings()).listJobsSettings();
  }

  /** Returns the object with the settings used for calls to updateJob. */
  public UnaryCallSettings<UpdateJobRequest, Job> updateJobSettings() {
    return ((JobControllerStubSettings) getStubSettings()).updateJobSettings();
  }

  /** Returns the object with the settings used for calls to cancelJob. */
  public UnaryCallSettings<CancelJobRequest, Job> cancelJobSettings() {
    return ((JobControllerStubSettings) getStubSettings()).cancelJobSettings();
  }

  /** Returns the object with the settings used for calls to deleteJob. */
  public UnaryCallSettings<DeleteJobRequest, Empty> deleteJobSettings() {
    return ((JobControllerStubSettings) getStubSettings()).deleteJobSettings();
  }

  public static final JobControllerSettings create(JobControllerStubSettings stub)
      throws IOException {
    return new JobControllerSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return JobControllerStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return JobControllerStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return JobControllerStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return JobControllerStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return JobControllerStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return JobControllerStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return JobControllerStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return JobControllerStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected JobControllerSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for JobControllerSettings. */
  public static class Builder extends ClientSettings.Builder<JobControllerSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(JobControllerStubSettings.newBuilder(clientContext));
    }

    protected Builder(JobControllerSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(JobControllerStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(JobControllerStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(JobControllerStubSettings.newHttpJsonBuilder());
    }

    public JobControllerStubSettings.Builder getStubSettingsBuilder() {
      return ((JobControllerStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to submitJob. */
    public UnaryCallSettings.Builder<SubmitJobRequest, Job> submitJobSettings() {
      return getStubSettingsBuilder().submitJobSettings();
    }

    /** Returns the builder for the settings used for calls to submitJobAs. */
    public UnaryCallSettings.Builder<SubmitJobRequest, Operation> submitJobAsOperationSettings() {
      return getStubSettingsBuilder().submitJobAsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to submitJobAsOperation. */
    public OperationCallSettings.Builder<SubmitJobRequest, Job, JobMetadata>
        submitJobAsOperationOperationSettings() {
      return getStubSettingsBuilder().submitJobAsOperationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getJob. */
    public UnaryCallSettings.Builder<GetJobRequest, Job> getJobSettings() {
      return getStubSettingsBuilder().getJobSettings();
    }

    /** Returns the builder for the settings used for calls to listJobs. */
    public PagedCallSettings.Builder<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
        listJobsSettings() {
      return getStubSettingsBuilder().listJobsSettings();
    }

    /** Returns the builder for the settings used for calls to updateJob. */
    public UnaryCallSettings.Builder<UpdateJobRequest, Job> updateJobSettings() {
      return getStubSettingsBuilder().updateJobSettings();
    }

    /** Returns the builder for the settings used for calls to cancelJob. */
    public UnaryCallSettings.Builder<CancelJobRequest, Job> cancelJobSettings() {
      return getStubSettingsBuilder().cancelJobSettings();
    }

    /** Returns the builder for the settings used for calls to deleteJob. */
    public UnaryCallSettings.Builder<DeleteJobRequest, Empty> deleteJobSettings() {
      return getStubSettingsBuilder().deleteJobSettings();
    }

    @Override
    public JobControllerSettings build() throws IOException {
      return new JobControllerSettings(this);
    }
  }
}
