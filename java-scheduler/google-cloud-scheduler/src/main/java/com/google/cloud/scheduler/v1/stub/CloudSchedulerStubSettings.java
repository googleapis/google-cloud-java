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

package com.google.cloud.scheduler.v1.stub;

import static com.google.cloud.scheduler.v1.CloudSchedulerClient.ListJobsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.scheduler.v1.CreateJobRequest;
import com.google.cloud.scheduler.v1.DeleteJobRequest;
import com.google.cloud.scheduler.v1.GetJobRequest;
import com.google.cloud.scheduler.v1.Job;
import com.google.cloud.scheduler.v1.ListJobsRequest;
import com.google.cloud.scheduler.v1.ListJobsResponse;
import com.google.cloud.scheduler.v1.PauseJobRequest;
import com.google.cloud.scheduler.v1.ResumeJobRequest;
import com.google.cloud.scheduler.v1.RunJobRequest;
import com.google.cloud.scheduler.v1.UpdateJobRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CloudSchedulerStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudscheduler.googleapis.com) and default port (443) are
 *       used.
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
 * CloudSchedulerStubSettings.Builder cloudSchedulerSettingsBuilder =
 *     CloudSchedulerStubSettings.newBuilder();
 * cloudSchedulerSettingsBuilder
 *     .getJobSettings()
 *     .setRetrySettings(
 *         cloudSchedulerSettingsBuilder
 *             .getJobSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CloudSchedulerStubSettings cloudSchedulerSettings = cloudSchedulerSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CloudSchedulerStubSettings extends StubSettings<CloudSchedulerStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
      listJobsSettings;
  private final UnaryCallSettings<GetJobRequest, Job> getJobSettings;
  private final UnaryCallSettings<CreateJobRequest, Job> createJobSettings;
  private final UnaryCallSettings<UpdateJobRequest, Job> updateJobSettings;
  private final UnaryCallSettings<DeleteJobRequest, Empty> deleteJobSettings;
  private final UnaryCallSettings<PauseJobRequest, Job> pauseJobSettings;
  private final UnaryCallSettings<ResumeJobRequest, Job> resumeJobSettings;
  private final UnaryCallSettings<RunJobRequest, Job> runJobSettings;

  private static final PagedListDescriptor<ListJobsRequest, ListJobsResponse, Job>
      LIST_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<ListJobsRequest, ListJobsResponse, Job>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListJobsRequest injectToken(ListJobsRequest payload, String token) {
              return ListJobsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListJobsRequest injectPageSize(ListJobsRequest payload, int pageSize) {
              return ListJobsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Job> extractResources(ListJobsResponse payload) {
              return payload.getJobsList() == null
                  ? ImmutableList.<Job>of()
                  : payload.getJobsList();
            }
          };

  private static final PagedListResponseFactory<
          ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
      LIST_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>() {
            @Override
            public ApiFuture<ListJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListJobsRequest, ListJobsResponse> callable,
                ListJobsRequest request,
                ApiCallContext context,
                ApiFuture<ListJobsResponse> futureResponse) {
              PageContext<ListJobsRequest, ListJobsResponse, Job> pageContext =
                  PageContext.create(callable, LIST_JOBS_PAGE_STR_DESC, request, context);
              return ListJobsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listJobs. */
  public PagedCallSettings<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
      listJobsSettings() {
    return listJobsSettings;
  }

  /** Returns the object with the settings used for calls to getJob. */
  public UnaryCallSettings<GetJobRequest, Job> getJobSettings() {
    return getJobSettings;
  }

  /** Returns the object with the settings used for calls to createJob. */
  public UnaryCallSettings<CreateJobRequest, Job> createJobSettings() {
    return createJobSettings;
  }

  /** Returns the object with the settings used for calls to updateJob. */
  public UnaryCallSettings<UpdateJobRequest, Job> updateJobSettings() {
    return updateJobSettings;
  }

  /** Returns the object with the settings used for calls to deleteJob. */
  public UnaryCallSettings<DeleteJobRequest, Empty> deleteJobSettings() {
    return deleteJobSettings;
  }

  /** Returns the object with the settings used for calls to pauseJob. */
  public UnaryCallSettings<PauseJobRequest, Job> pauseJobSettings() {
    return pauseJobSettings;
  }

  /** Returns the object with the settings used for calls to resumeJob. */
  public UnaryCallSettings<ResumeJobRequest, Job> resumeJobSettings() {
    return resumeJobSettings;
  }

  /** Returns the object with the settings used for calls to runJob. */
  public UnaryCallSettings<RunJobRequest, Job> runJobSettings() {
    return runJobSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public CloudSchedulerStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcCloudSchedulerStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "cloudscheduler.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(CloudSchedulerStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
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

  protected CloudSchedulerStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listJobsSettings = settingsBuilder.listJobsSettings().build();
    getJobSettings = settingsBuilder.getJobSettings().build();
    createJobSettings = settingsBuilder.createJobSettings().build();
    updateJobSettings = settingsBuilder.updateJobSettings().build();
    deleteJobSettings = settingsBuilder.deleteJobSettings().build();
    pauseJobSettings = settingsBuilder.pauseJobSettings().build();
    resumeJobSettings = settingsBuilder.resumeJobSettings().build();
    runJobSettings = settingsBuilder.runJobSettings().build();
  }

  /** Builder for CloudSchedulerStubSettings. */
  public static class Builder extends StubSettings.Builder<CloudSchedulerStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
        listJobsSettings;
    private final UnaryCallSettings.Builder<GetJobRequest, Job> getJobSettings;
    private final UnaryCallSettings.Builder<CreateJobRequest, Job> createJobSettings;
    private final UnaryCallSettings.Builder<UpdateJobRequest, Job> updateJobSettings;
    private final UnaryCallSettings.Builder<DeleteJobRequest, Empty> deleteJobSettings;
    private final UnaryCallSettings.Builder<PauseJobRequest, Job> pauseJobSettings;
    private final UnaryCallSettings.Builder<ResumeJobRequest, Job> resumeJobSettings;
    private final UnaryCallSettings.Builder<RunJobRequest, Job> runJobSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listJobsSettings = PagedCallSettings.newBuilder(LIST_JOBS_PAGE_STR_FACT);
      getJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      pauseJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resumeJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      runJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listJobsSettings,
              getJobSettings,
              createJobSettings,
              updateJobSettings,
              deleteJobSettings,
              pauseJobSettings,
              resumeJobSettings,
              runJobSettings);
      initDefaults(this);
    }

    protected Builder(CloudSchedulerStubSettings settings) {
      super(settings);

      listJobsSettings = settings.listJobsSettings.toBuilder();
      getJobSettings = settings.getJobSettings.toBuilder();
      createJobSettings = settings.createJobSettings.toBuilder();
      updateJobSettings = settings.updateJobSettings.toBuilder();
      deleteJobSettings = settings.deleteJobSettings.toBuilder();
      pauseJobSettings = settings.pauseJobSettings.toBuilder();
      resumeJobSettings = settings.resumeJobSettings.toBuilder();
      runJobSettings = settings.runJobSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listJobsSettings,
              getJobSettings,
              createJobSettings,
              updateJobSettings,
              deleteJobSettings,
              pauseJobSettings,
              resumeJobSettings,
              runJobSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .pauseJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .resumeJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .runJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      return builder;
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to listJobs. */
    public PagedCallSettings.Builder<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
        listJobsSettings() {
      return listJobsSettings;
    }

    /** Returns the builder for the settings used for calls to getJob. */
    public UnaryCallSettings.Builder<GetJobRequest, Job> getJobSettings() {
      return getJobSettings;
    }

    /** Returns the builder for the settings used for calls to createJob. */
    public UnaryCallSettings.Builder<CreateJobRequest, Job> createJobSettings() {
      return createJobSettings;
    }

    /** Returns the builder for the settings used for calls to updateJob. */
    public UnaryCallSettings.Builder<UpdateJobRequest, Job> updateJobSettings() {
      return updateJobSettings;
    }

    /** Returns the builder for the settings used for calls to deleteJob. */
    public UnaryCallSettings.Builder<DeleteJobRequest, Empty> deleteJobSettings() {
      return deleteJobSettings;
    }

    /** Returns the builder for the settings used for calls to pauseJob. */
    public UnaryCallSettings.Builder<PauseJobRequest, Job> pauseJobSettings() {
      return pauseJobSettings;
    }

    /** Returns the builder for the settings used for calls to resumeJob. */
    public UnaryCallSettings.Builder<ResumeJobRequest, Job> resumeJobSettings() {
      return resumeJobSettings;
    }

    /** Returns the builder for the settings used for calls to runJob. */
    public UnaryCallSettings.Builder<RunJobRequest, Job> runJobSettings() {
      return runJobSettings;
    }

    @Override
    public CloudSchedulerStubSettings build() throws IOException {
      return new CloudSchedulerStubSettings(this);
    }
  }
}
