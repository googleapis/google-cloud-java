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

package com.google.cloud.run.v2;

import static com.google.cloud.run.v2.JobsClient.ListJobsPagedResponse;

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
import com.google.cloud.run.v2.stub.JobsStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link JobsClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (run.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getJob to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * JobsSettings.Builder jobsSettingsBuilder = JobsSettings.newBuilder();
 * jobsSettingsBuilder
 *     .getJobSettings()
 *     .setRetrySettings(
 *         jobsSettingsBuilder
 *             .getJobSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * JobsSettings jobsSettings = jobsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class JobsSettings extends ClientSettings<JobsSettings> {

  /** Returns the object with the settings used for calls to createJob. */
  public UnaryCallSettings<CreateJobRequest, Operation> createJobSettings() {
    return ((JobsStubSettings) getStubSettings()).createJobSettings();
  }

  /** Returns the object with the settings used for calls to createJob. */
  public OperationCallSettings<CreateJobRequest, Job, Job> createJobOperationSettings() {
    return ((JobsStubSettings) getStubSettings()).createJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to getJob. */
  public UnaryCallSettings<GetJobRequest, Job> getJobSettings() {
    return ((JobsStubSettings) getStubSettings()).getJobSettings();
  }

  /** Returns the object with the settings used for calls to listJobs. */
  public PagedCallSettings<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
      listJobsSettings() {
    return ((JobsStubSettings) getStubSettings()).listJobsSettings();
  }

  /** Returns the object with the settings used for calls to updateJob. */
  public UnaryCallSettings<UpdateJobRequest, Operation> updateJobSettings() {
    return ((JobsStubSettings) getStubSettings()).updateJobSettings();
  }

  /** Returns the object with the settings used for calls to updateJob. */
  public OperationCallSettings<UpdateJobRequest, Job, Job> updateJobOperationSettings() {
    return ((JobsStubSettings) getStubSettings()).updateJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteJob. */
  public UnaryCallSettings<DeleteJobRequest, Operation> deleteJobSettings() {
    return ((JobsStubSettings) getStubSettings()).deleteJobSettings();
  }

  /** Returns the object with the settings used for calls to deleteJob. */
  public OperationCallSettings<DeleteJobRequest, Job, Job> deleteJobOperationSettings() {
    return ((JobsStubSettings) getStubSettings()).deleteJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to runJob. */
  public UnaryCallSettings<RunJobRequest, Operation> runJobSettings() {
    return ((JobsStubSettings) getStubSettings()).runJobSettings();
  }

  /** Returns the object with the settings used for calls to runJob. */
  public OperationCallSettings<RunJobRequest, Execution, Execution> runJobOperationSettings() {
    return ((JobsStubSettings) getStubSettings()).runJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((JobsStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((JobsStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((JobsStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final JobsSettings create(JobsStubSettings stub) throws IOException {
    return new JobsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return JobsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return JobsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return JobsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return JobsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return JobsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return JobsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return JobsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return JobsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected JobsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for JobsSettings. */
  public static class Builder extends ClientSettings.Builder<JobsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(JobsStubSettings.newBuilder(clientContext));
    }

    protected Builder(JobsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(JobsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(JobsStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(JobsStubSettings.newHttpJsonBuilder());
    }

    public JobsStubSettings.Builder getStubSettingsBuilder() {
      return ((JobsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createJob. */
    public UnaryCallSettings.Builder<CreateJobRequest, Operation> createJobSettings() {
      return getStubSettingsBuilder().createJobSettings();
    }

    /** Returns the builder for the settings used for calls to createJob. */
    public OperationCallSettings.Builder<CreateJobRequest, Job, Job> createJobOperationSettings() {
      return getStubSettingsBuilder().createJobOperationSettings();
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
    public UnaryCallSettings.Builder<UpdateJobRequest, Operation> updateJobSettings() {
      return getStubSettingsBuilder().updateJobSettings();
    }

    /** Returns the builder for the settings used for calls to updateJob. */
    public OperationCallSettings.Builder<UpdateJobRequest, Job, Job> updateJobOperationSettings() {
      return getStubSettingsBuilder().updateJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteJob. */
    public UnaryCallSettings.Builder<DeleteJobRequest, Operation> deleteJobSettings() {
      return getStubSettingsBuilder().deleteJobSettings();
    }

    /** Returns the builder for the settings used for calls to deleteJob. */
    public OperationCallSettings.Builder<DeleteJobRequest, Job, Job> deleteJobOperationSettings() {
      return getStubSettingsBuilder().deleteJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to runJob. */
    public UnaryCallSettings.Builder<RunJobRequest, Operation> runJobSettings() {
      return getStubSettingsBuilder().runJobSettings();
    }

    /** Returns the builder for the settings used for calls to runJob. */
    public OperationCallSettings.Builder<RunJobRequest, Execution, Execution>
        runJobOperationSettings() {
      return getStubSettingsBuilder().runJobOperationSettings();
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

    @Override
    public JobsSettings build() throws IOException {
      return new JobsSettings(this);
    }
  }
}
