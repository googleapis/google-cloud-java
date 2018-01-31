/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.dataproc.v1.stub;

import static com.google.cloud.dataproc.v1.PagedResponseWrappers.ListJobsPagedResponse;

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
import com.google.cloud.dataproc.v1.CancelJobRequest;
import com.google.cloud.dataproc.v1.DeleteJobRequest;
import com.google.cloud.dataproc.v1.GetJobRequest;
import com.google.cloud.dataproc.v1.Job;
import com.google.cloud.dataproc.v1.ListJobsRequest;
import com.google.cloud.dataproc.v1.ListJobsResponse;
import com.google.cloud.dataproc.v1.SubmitJobRequest;
import com.google.cloud.dataproc.v1.UpdateJobRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link JobControllerStub}.
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
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of submitJob to 30 seconds:
 *
 * <pre>
 * <code>
 * JobControllerStubSettings.Builder jobControllerSettingsBuilder =
 *     JobControllerStubSettings.newBuilder();
 * jobControllerSettingsBuilder.submitJobSettings().getRetrySettingsBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * JobControllerStubSettings jobControllerSettings = jobControllerSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class JobControllerStubSettings extends StubSettings<JobControllerStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<SubmitJobRequest, Job> submitJobSettings;
  private final UnaryCallSettings<GetJobRequest, Job> getJobSettings;
  private final PagedCallSettings<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
      listJobsSettings;
  private final UnaryCallSettings<UpdateJobRequest, Job> updateJobSettings;
  private final UnaryCallSettings<CancelJobRequest, Job> cancelJobSettings;
  private final UnaryCallSettings<DeleteJobRequest, Empty> deleteJobSettings;

  /** Returns the object with the settings used for calls to submitJob. */
  public UnaryCallSettings<SubmitJobRequest, Job> submitJobSettings() {
    return submitJobSettings;
  }

  /** Returns the object with the settings used for calls to getJob. */
  public UnaryCallSettings<GetJobRequest, Job> getJobSettings() {
    return getJobSettings;
  }

  /** Returns the object with the settings used for calls to listJobs. */
  public PagedCallSettings<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
      listJobsSettings() {
    return listJobsSettings;
  }

  /** Returns the object with the settings used for calls to updateJob. */
  public UnaryCallSettings<UpdateJobRequest, Job> updateJobSettings() {
    return updateJobSettings;
  }

  /** Returns the object with the settings used for calls to cancelJob. */
  public UnaryCallSettings<CancelJobRequest, Job> cancelJobSettings() {
    return cancelJobSettings;
  }

  /** Returns the object with the settings used for calls to deleteJob. */
  public UnaryCallSettings<DeleteJobRequest, Empty> deleteJobSettings() {
    return deleteJobSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public JobControllerStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcJobControllerStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "dataproc.googleapis.com:443";
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
    return InstantiatingGrpcChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(JobControllerStubSettings.class))
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

  protected JobControllerStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    submitJobSettings = settingsBuilder.submitJobSettings().build();
    getJobSettings = settingsBuilder.getJobSettings().build();
    listJobsSettings = settingsBuilder.listJobsSettings().build();
    updateJobSettings = settingsBuilder.updateJobSettings().build();
    cancelJobSettings = settingsBuilder.cancelJobSettings().build();
    deleteJobSettings = settingsBuilder.deleteJobSettings().build();
  }

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
              return payload.getJobsList();
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

  /** Builder for JobControllerStubSettings. */
  public static class Builder extends StubSettings.Builder<JobControllerStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<SubmitJobRequest, Job> submitJobSettings;
    private final UnaryCallSettings.Builder<GetJobRequest, Job> getJobSettings;
    private final PagedCallSettings.Builder<
            ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
        listJobsSettings;
    private final UnaryCallSettings.Builder<UpdateJobRequest, Job> updateJobSettings;
    private final UnaryCallSettings.Builder<CancelJobRequest, Job> cancelJobSettings;
    private final UnaryCallSettings.Builder<DeleteJobRequest, Empty> deleteJobSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      submitJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listJobsSettings = PagedCallSettings.newBuilder(LIST_JOBS_PAGE_STR_FACT);

      updateJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      cancelJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              submitJobSettings,
              getJobSettings,
              listJobsSettings,
              updateJobSettings,
              cancelJobSettings,
              deleteJobSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .submitJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .cancelJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(JobControllerStubSettings settings) {
      super(settings);

      submitJobSettings = settings.submitJobSettings.toBuilder();
      getJobSettings = settings.getJobSettings.toBuilder();
      listJobsSettings = settings.listJobsSettings.toBuilder();
      updateJobSettings = settings.updateJobSettings.toBuilder();
      cancelJobSettings = settings.cancelJobSettings.toBuilder();
      deleteJobSettings = settings.deleteJobSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              submitJobSettings,
              getJobSettings,
              listJobsSettings,
              updateJobSettings,
              cancelJobSettings,
              deleteJobSettings);
    }

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

    /** Returns the builder for the settings used for calls to submitJob. */
    public UnaryCallSettings.Builder<SubmitJobRequest, Job> submitJobSettings() {
      return submitJobSettings;
    }

    /** Returns the builder for the settings used for calls to getJob. */
    public UnaryCallSettings.Builder<GetJobRequest, Job> getJobSettings() {
      return getJobSettings;
    }

    /** Returns the builder for the settings used for calls to listJobs. */
    public PagedCallSettings.Builder<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
        listJobsSettings() {
      return listJobsSettings;
    }

    /** Returns the builder for the settings used for calls to updateJob. */
    public UnaryCallSettings.Builder<UpdateJobRequest, Job> updateJobSettings() {
      return updateJobSettings;
    }

    /** Returns the builder for the settings used for calls to cancelJob. */
    public UnaryCallSettings.Builder<CancelJobRequest, Job> cancelJobSettings() {
      return cancelJobSettings;
    }

    /** Returns the builder for the settings used for calls to deleteJob. */
    public UnaryCallSettings.Builder<DeleteJobRequest, Empty> deleteJobSettings() {
      return deleteJobSettings;
    }

    @Override
    public JobControllerStubSettings build() throws IOException {
      return new JobControllerStubSettings(this);
    }
  }
}
