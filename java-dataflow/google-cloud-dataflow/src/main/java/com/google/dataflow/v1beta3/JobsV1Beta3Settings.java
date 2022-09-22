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

package com.google.dataflow.v1beta3;

import static com.google.dataflow.v1beta3.JobsV1Beta3Client.AggregatedListJobsPagedResponse;
import static com.google.dataflow.v1beta3.JobsV1Beta3Client.ListJobsPagedResponse;

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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.dataflow.v1beta3.stub.JobsV1Beta3StubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link JobsV1Beta3Client}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataflow.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createJob to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * JobsV1Beta3Settings.Builder jobsV1Beta3SettingsBuilder = JobsV1Beta3Settings.newBuilder();
 * jobsV1Beta3SettingsBuilder
 *     .createJobSettings()
 *     .setRetrySettings(
 *         jobsV1Beta3SettingsBuilder.createJobSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * JobsV1Beta3Settings jobsV1Beta3Settings = jobsV1Beta3SettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class JobsV1Beta3Settings extends ClientSettings<JobsV1Beta3Settings> {

  /** Returns the object with the settings used for calls to createJob. */
  public UnaryCallSettings<CreateJobRequest, Job> createJobSettings() {
    return ((JobsV1Beta3StubSettings) getStubSettings()).createJobSettings();
  }

  /** Returns the object with the settings used for calls to getJob. */
  public UnaryCallSettings<GetJobRequest, Job> getJobSettings() {
    return ((JobsV1Beta3StubSettings) getStubSettings()).getJobSettings();
  }

  /** Returns the object with the settings used for calls to updateJob. */
  public UnaryCallSettings<UpdateJobRequest, Job> updateJobSettings() {
    return ((JobsV1Beta3StubSettings) getStubSettings()).updateJobSettings();
  }

  /** Returns the object with the settings used for calls to listJobs. */
  public PagedCallSettings<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
      listJobsSettings() {
    return ((JobsV1Beta3StubSettings) getStubSettings()).listJobsSettings();
  }

  /** Returns the object with the settings used for calls to aggregatedListJobs. */
  public PagedCallSettings<ListJobsRequest, ListJobsResponse, AggregatedListJobsPagedResponse>
      aggregatedListJobsSettings() {
    return ((JobsV1Beta3StubSettings) getStubSettings()).aggregatedListJobsSettings();
  }

  /** Returns the object with the settings used for calls to checkActiveJobs. */
  public UnaryCallSettings<CheckActiveJobsRequest, CheckActiveJobsResponse>
      checkActiveJobsSettings() {
    return ((JobsV1Beta3StubSettings) getStubSettings()).checkActiveJobsSettings();
  }

  /** Returns the object with the settings used for calls to snapshotJob. */
  public UnaryCallSettings<SnapshotJobRequest, Snapshot> snapshotJobSettings() {
    return ((JobsV1Beta3StubSettings) getStubSettings()).snapshotJobSettings();
  }

  public static final JobsV1Beta3Settings create(JobsV1Beta3StubSettings stub) throws IOException {
    return new JobsV1Beta3Settings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return JobsV1Beta3StubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return JobsV1Beta3StubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return JobsV1Beta3StubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return JobsV1Beta3StubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return JobsV1Beta3StubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return JobsV1Beta3StubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return JobsV1Beta3StubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return JobsV1Beta3StubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected JobsV1Beta3Settings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for JobsV1Beta3Settings. */
  public static class Builder extends ClientSettings.Builder<JobsV1Beta3Settings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(JobsV1Beta3StubSettings.newBuilder(clientContext));
    }

    protected Builder(JobsV1Beta3Settings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(JobsV1Beta3StubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(JobsV1Beta3StubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(JobsV1Beta3StubSettings.newHttpJsonBuilder());
    }

    public JobsV1Beta3StubSettings.Builder getStubSettingsBuilder() {
      return ((JobsV1Beta3StubSettings.Builder) getStubSettings());
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
    public UnaryCallSettings.Builder<CreateJobRequest, Job> createJobSettings() {
      return getStubSettingsBuilder().createJobSettings();
    }

    /** Returns the builder for the settings used for calls to getJob. */
    public UnaryCallSettings.Builder<GetJobRequest, Job> getJobSettings() {
      return getStubSettingsBuilder().getJobSettings();
    }

    /** Returns the builder for the settings used for calls to updateJob. */
    public UnaryCallSettings.Builder<UpdateJobRequest, Job> updateJobSettings() {
      return getStubSettingsBuilder().updateJobSettings();
    }

    /** Returns the builder for the settings used for calls to listJobs. */
    public PagedCallSettings.Builder<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
        listJobsSettings() {
      return getStubSettingsBuilder().listJobsSettings();
    }

    /** Returns the builder for the settings used for calls to aggregatedListJobs. */
    public PagedCallSettings.Builder<
            ListJobsRequest, ListJobsResponse, AggregatedListJobsPagedResponse>
        aggregatedListJobsSettings() {
      return getStubSettingsBuilder().aggregatedListJobsSettings();
    }

    /** Returns the builder for the settings used for calls to checkActiveJobs. */
    public UnaryCallSettings.Builder<CheckActiveJobsRequest, CheckActiveJobsResponse>
        checkActiveJobsSettings() {
      return getStubSettingsBuilder().checkActiveJobsSettings();
    }

    /** Returns the builder for the settings used for calls to snapshotJob. */
    public UnaryCallSettings.Builder<SnapshotJobRequest, Snapshot> snapshotJobSettings() {
      return getStubSettingsBuilder().snapshotJobSettings();
    }

    @Override
    public JobsV1Beta3Settings build() throws IOException {
      return new JobsV1Beta3Settings(this);
    }
  }
}
