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

package com.google.cloud.devtools.cloudbuild.v1.stub;

import static com.google.cloud.devtools.cloudbuild.v1.CloudBuildClient.ListBuildTriggersPagedResponse;
import static com.google.cloud.devtools.cloudbuild.v1.CloudBuildClient.ListBuildsPagedResponse;
import static com.google.cloud.devtools.cloudbuild.v1.CloudBuildClient.ListWorkerPoolsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloudbuild.v1.ApproveBuildRequest;
import com.google.cloudbuild.v1.Build;
import com.google.cloudbuild.v1.BuildOperationMetadata;
import com.google.cloudbuild.v1.BuildTrigger;
import com.google.cloudbuild.v1.CancelBuildRequest;
import com.google.cloudbuild.v1.CreateBuildRequest;
import com.google.cloudbuild.v1.CreateBuildTriggerRequest;
import com.google.cloudbuild.v1.CreateWorkerPoolOperationMetadata;
import com.google.cloudbuild.v1.CreateWorkerPoolRequest;
import com.google.cloudbuild.v1.DeleteBuildTriggerRequest;
import com.google.cloudbuild.v1.DeleteWorkerPoolOperationMetadata;
import com.google.cloudbuild.v1.DeleteWorkerPoolRequest;
import com.google.cloudbuild.v1.GetBuildRequest;
import com.google.cloudbuild.v1.GetBuildTriggerRequest;
import com.google.cloudbuild.v1.GetWorkerPoolRequest;
import com.google.cloudbuild.v1.ListBuildTriggersRequest;
import com.google.cloudbuild.v1.ListBuildTriggersResponse;
import com.google.cloudbuild.v1.ListBuildsRequest;
import com.google.cloudbuild.v1.ListBuildsResponse;
import com.google.cloudbuild.v1.ListWorkerPoolsRequest;
import com.google.cloudbuild.v1.ListWorkerPoolsResponse;
import com.google.cloudbuild.v1.ReceiveTriggerWebhookRequest;
import com.google.cloudbuild.v1.ReceiveTriggerWebhookResponse;
import com.google.cloudbuild.v1.RetryBuildRequest;
import com.google.cloudbuild.v1.RunBuildTriggerRequest;
import com.google.cloudbuild.v1.UpdateBuildTriggerRequest;
import com.google.cloudbuild.v1.UpdateWorkerPoolOperationMetadata;
import com.google.cloudbuild.v1.UpdateWorkerPoolRequest;
import com.google.cloudbuild.v1.WorkerPool;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CloudBuildStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudbuild.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getBuild to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudBuildStubSettings.Builder cloudBuildSettingsBuilder = CloudBuildStubSettings.newBuilder();
 * cloudBuildSettingsBuilder
 *     .getBuildSettings()
 *     .setRetrySettings(
 *         cloudBuildSettingsBuilder.getBuildSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CloudBuildStubSettings cloudBuildSettings = cloudBuildSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CloudBuildStubSettings extends StubSettings<CloudBuildStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateBuildRequest, Operation> createBuildSettings;
  private final OperationCallSettings<CreateBuildRequest, Build, BuildOperationMetadata>
      createBuildOperationSettings;
  private final UnaryCallSettings<GetBuildRequest, Build> getBuildSettings;
  private final PagedCallSettings<ListBuildsRequest, ListBuildsResponse, ListBuildsPagedResponse>
      listBuildsSettings;
  private final UnaryCallSettings<CancelBuildRequest, Build> cancelBuildSettings;
  private final UnaryCallSettings<RetryBuildRequest, Operation> retryBuildSettings;
  private final OperationCallSettings<RetryBuildRequest, Build, BuildOperationMetadata>
      retryBuildOperationSettings;
  private final UnaryCallSettings<ApproveBuildRequest, Operation> approveBuildSettings;
  private final OperationCallSettings<ApproveBuildRequest, Build, BuildOperationMetadata>
      approveBuildOperationSettings;
  private final UnaryCallSettings<CreateBuildTriggerRequest, BuildTrigger>
      createBuildTriggerSettings;
  private final UnaryCallSettings<GetBuildTriggerRequest, BuildTrigger> getBuildTriggerSettings;
  private final PagedCallSettings<
          ListBuildTriggersRequest, ListBuildTriggersResponse, ListBuildTriggersPagedResponse>
      listBuildTriggersSettings;
  private final UnaryCallSettings<DeleteBuildTriggerRequest, Empty> deleteBuildTriggerSettings;
  private final UnaryCallSettings<UpdateBuildTriggerRequest, BuildTrigger>
      updateBuildTriggerSettings;
  private final UnaryCallSettings<RunBuildTriggerRequest, Operation> runBuildTriggerSettings;
  private final OperationCallSettings<RunBuildTriggerRequest, Build, BuildOperationMetadata>
      runBuildTriggerOperationSettings;
  private final UnaryCallSettings<ReceiveTriggerWebhookRequest, ReceiveTriggerWebhookResponse>
      receiveTriggerWebhookSettings;
  private final UnaryCallSettings<CreateWorkerPoolRequest, Operation> createWorkerPoolSettings;
  private final OperationCallSettings<
          CreateWorkerPoolRequest, WorkerPool, CreateWorkerPoolOperationMetadata>
      createWorkerPoolOperationSettings;
  private final UnaryCallSettings<GetWorkerPoolRequest, WorkerPool> getWorkerPoolSettings;
  private final UnaryCallSettings<DeleteWorkerPoolRequest, Operation> deleteWorkerPoolSettings;
  private final OperationCallSettings<
          DeleteWorkerPoolRequest, Empty, DeleteWorkerPoolOperationMetadata>
      deleteWorkerPoolOperationSettings;
  private final UnaryCallSettings<UpdateWorkerPoolRequest, Operation> updateWorkerPoolSettings;
  private final OperationCallSettings<
          UpdateWorkerPoolRequest, WorkerPool, UpdateWorkerPoolOperationMetadata>
      updateWorkerPoolOperationSettings;
  private final PagedCallSettings<
          ListWorkerPoolsRequest, ListWorkerPoolsResponse, ListWorkerPoolsPagedResponse>
      listWorkerPoolsSettings;

  private static final PagedListDescriptor<ListBuildsRequest, ListBuildsResponse, Build>
      LIST_BUILDS_PAGE_STR_DESC =
          new PagedListDescriptor<ListBuildsRequest, ListBuildsResponse, Build>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBuildsRequest injectToken(ListBuildsRequest payload, String token) {
              return ListBuildsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBuildsRequest injectPageSize(ListBuildsRequest payload, int pageSize) {
              return ListBuildsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBuildsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBuildsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Build> extractResources(ListBuildsResponse payload) {
              return payload.getBuildsList() == null
                  ? ImmutableList.<Build>of()
                  : payload.getBuildsList();
            }
          };

  private static final PagedListDescriptor<
          ListBuildTriggersRequest, ListBuildTriggersResponse, BuildTrigger>
      LIST_BUILD_TRIGGERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListBuildTriggersRequest, ListBuildTriggersResponse, BuildTrigger>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBuildTriggersRequest injectToken(
                ListBuildTriggersRequest payload, String token) {
              return ListBuildTriggersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBuildTriggersRequest injectPageSize(
                ListBuildTriggersRequest payload, int pageSize) {
              return ListBuildTriggersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBuildTriggersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBuildTriggersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<BuildTrigger> extractResources(ListBuildTriggersResponse payload) {
              return payload.getTriggersList() == null
                  ? ImmutableList.<BuildTrigger>of()
                  : payload.getTriggersList();
            }
          };

  private static final PagedListDescriptor<
          ListWorkerPoolsRequest, ListWorkerPoolsResponse, WorkerPool>
      LIST_WORKER_POOLS_PAGE_STR_DESC =
          new PagedListDescriptor<ListWorkerPoolsRequest, ListWorkerPoolsResponse, WorkerPool>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListWorkerPoolsRequest injectToken(
                ListWorkerPoolsRequest payload, String token) {
              return ListWorkerPoolsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListWorkerPoolsRequest injectPageSize(
                ListWorkerPoolsRequest payload, int pageSize) {
              return ListWorkerPoolsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListWorkerPoolsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListWorkerPoolsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<WorkerPool> extractResources(ListWorkerPoolsResponse payload) {
              return payload.getWorkerPoolsList() == null
                  ? ImmutableList.<WorkerPool>of()
                  : payload.getWorkerPoolsList();
            }
          };

  private static final PagedListResponseFactory<
          ListBuildsRequest, ListBuildsResponse, ListBuildsPagedResponse>
      LIST_BUILDS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBuildsRequest, ListBuildsResponse, ListBuildsPagedResponse>() {
            @Override
            public ApiFuture<ListBuildsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBuildsRequest, ListBuildsResponse> callable,
                ListBuildsRequest request,
                ApiCallContext context,
                ApiFuture<ListBuildsResponse> futureResponse) {
              PageContext<ListBuildsRequest, ListBuildsResponse, Build> pageContext =
                  PageContext.create(callable, LIST_BUILDS_PAGE_STR_DESC, request, context);
              return ListBuildsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBuildTriggersRequest, ListBuildTriggersResponse, ListBuildTriggersPagedResponse>
      LIST_BUILD_TRIGGERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBuildTriggersRequest,
              ListBuildTriggersResponse,
              ListBuildTriggersPagedResponse>() {
            @Override
            public ApiFuture<ListBuildTriggersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBuildTriggersRequest, ListBuildTriggersResponse> callable,
                ListBuildTriggersRequest request,
                ApiCallContext context,
                ApiFuture<ListBuildTriggersResponse> futureResponse) {
              PageContext<ListBuildTriggersRequest, ListBuildTriggersResponse, BuildTrigger>
                  pageContext =
                      PageContext.create(
                          callable, LIST_BUILD_TRIGGERS_PAGE_STR_DESC, request, context);
              return ListBuildTriggersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListWorkerPoolsRequest, ListWorkerPoolsResponse, ListWorkerPoolsPagedResponse>
      LIST_WORKER_POOLS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListWorkerPoolsRequest, ListWorkerPoolsResponse, ListWorkerPoolsPagedResponse>() {
            @Override
            public ApiFuture<ListWorkerPoolsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListWorkerPoolsRequest, ListWorkerPoolsResponse> callable,
                ListWorkerPoolsRequest request,
                ApiCallContext context,
                ApiFuture<ListWorkerPoolsResponse> futureResponse) {
              PageContext<ListWorkerPoolsRequest, ListWorkerPoolsResponse, WorkerPool> pageContext =
                  PageContext.create(callable, LIST_WORKER_POOLS_PAGE_STR_DESC, request, context);
              return ListWorkerPoolsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createBuild. */
  public UnaryCallSettings<CreateBuildRequest, Operation> createBuildSettings() {
    return createBuildSettings;
  }

  /** Returns the object with the settings used for calls to createBuild. */
  public OperationCallSettings<CreateBuildRequest, Build, BuildOperationMetadata>
      createBuildOperationSettings() {
    return createBuildOperationSettings;
  }

  /** Returns the object with the settings used for calls to getBuild. */
  public UnaryCallSettings<GetBuildRequest, Build> getBuildSettings() {
    return getBuildSettings;
  }

  /** Returns the object with the settings used for calls to listBuilds. */
  public PagedCallSettings<ListBuildsRequest, ListBuildsResponse, ListBuildsPagedResponse>
      listBuildsSettings() {
    return listBuildsSettings;
  }

  /** Returns the object with the settings used for calls to cancelBuild. */
  public UnaryCallSettings<CancelBuildRequest, Build> cancelBuildSettings() {
    return cancelBuildSettings;
  }

  /** Returns the object with the settings used for calls to retryBuild. */
  public UnaryCallSettings<RetryBuildRequest, Operation> retryBuildSettings() {
    return retryBuildSettings;
  }

  /** Returns the object with the settings used for calls to retryBuild. */
  public OperationCallSettings<RetryBuildRequest, Build, BuildOperationMetadata>
      retryBuildOperationSettings() {
    return retryBuildOperationSettings;
  }

  /** Returns the object with the settings used for calls to approveBuild. */
  public UnaryCallSettings<ApproveBuildRequest, Operation> approveBuildSettings() {
    return approveBuildSettings;
  }

  /** Returns the object with the settings used for calls to approveBuild. */
  public OperationCallSettings<ApproveBuildRequest, Build, BuildOperationMetadata>
      approveBuildOperationSettings() {
    return approveBuildOperationSettings;
  }

  /** Returns the object with the settings used for calls to createBuildTrigger. */
  public UnaryCallSettings<CreateBuildTriggerRequest, BuildTrigger> createBuildTriggerSettings() {
    return createBuildTriggerSettings;
  }

  /** Returns the object with the settings used for calls to getBuildTrigger. */
  public UnaryCallSettings<GetBuildTriggerRequest, BuildTrigger> getBuildTriggerSettings() {
    return getBuildTriggerSettings;
  }

  /** Returns the object with the settings used for calls to listBuildTriggers. */
  public PagedCallSettings<
          ListBuildTriggersRequest, ListBuildTriggersResponse, ListBuildTriggersPagedResponse>
      listBuildTriggersSettings() {
    return listBuildTriggersSettings;
  }

  /** Returns the object with the settings used for calls to deleteBuildTrigger. */
  public UnaryCallSettings<DeleteBuildTriggerRequest, Empty> deleteBuildTriggerSettings() {
    return deleteBuildTriggerSettings;
  }

  /** Returns the object with the settings used for calls to updateBuildTrigger. */
  public UnaryCallSettings<UpdateBuildTriggerRequest, BuildTrigger> updateBuildTriggerSettings() {
    return updateBuildTriggerSettings;
  }

  /** Returns the object with the settings used for calls to runBuildTrigger. */
  public UnaryCallSettings<RunBuildTriggerRequest, Operation> runBuildTriggerSettings() {
    return runBuildTriggerSettings;
  }

  /** Returns the object with the settings used for calls to runBuildTrigger. */
  public OperationCallSettings<RunBuildTriggerRequest, Build, BuildOperationMetadata>
      runBuildTriggerOperationSettings() {
    return runBuildTriggerOperationSettings;
  }

  /** Returns the object with the settings used for calls to receiveTriggerWebhook. */
  public UnaryCallSettings<ReceiveTriggerWebhookRequest, ReceiveTriggerWebhookResponse>
      receiveTriggerWebhookSettings() {
    return receiveTriggerWebhookSettings;
  }

  /** Returns the object with the settings used for calls to createWorkerPool. */
  public UnaryCallSettings<CreateWorkerPoolRequest, Operation> createWorkerPoolSettings() {
    return createWorkerPoolSettings;
  }

  /** Returns the object with the settings used for calls to createWorkerPool. */
  public OperationCallSettings<
          CreateWorkerPoolRequest, WorkerPool, CreateWorkerPoolOperationMetadata>
      createWorkerPoolOperationSettings() {
    return createWorkerPoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to getWorkerPool. */
  public UnaryCallSettings<GetWorkerPoolRequest, WorkerPool> getWorkerPoolSettings() {
    return getWorkerPoolSettings;
  }

  /** Returns the object with the settings used for calls to deleteWorkerPool. */
  public UnaryCallSettings<DeleteWorkerPoolRequest, Operation> deleteWorkerPoolSettings() {
    return deleteWorkerPoolSettings;
  }

  /** Returns the object with the settings used for calls to deleteWorkerPool. */
  public OperationCallSettings<DeleteWorkerPoolRequest, Empty, DeleteWorkerPoolOperationMetadata>
      deleteWorkerPoolOperationSettings() {
    return deleteWorkerPoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateWorkerPool. */
  public UnaryCallSettings<UpdateWorkerPoolRequest, Operation> updateWorkerPoolSettings() {
    return updateWorkerPoolSettings;
  }

  /** Returns the object with the settings used for calls to updateWorkerPool. */
  public OperationCallSettings<
          UpdateWorkerPoolRequest, WorkerPool, UpdateWorkerPoolOperationMetadata>
      updateWorkerPoolOperationSettings() {
    return updateWorkerPoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to listWorkerPools. */
  public PagedCallSettings<
          ListWorkerPoolsRequest, ListWorkerPoolsResponse, ListWorkerPoolsPagedResponse>
      listWorkerPoolsSettings() {
    return listWorkerPoolsSettings;
  }

  public CloudBuildStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcCloudBuildStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonCloudBuildStub.create(this);
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
    return "cloudbuild.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "cloudbuild.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(CloudBuildStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(CloudBuildStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CloudBuildStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected CloudBuildStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createBuildSettings = settingsBuilder.createBuildSettings().build();
    createBuildOperationSettings = settingsBuilder.createBuildOperationSettings().build();
    getBuildSettings = settingsBuilder.getBuildSettings().build();
    listBuildsSettings = settingsBuilder.listBuildsSettings().build();
    cancelBuildSettings = settingsBuilder.cancelBuildSettings().build();
    retryBuildSettings = settingsBuilder.retryBuildSettings().build();
    retryBuildOperationSettings = settingsBuilder.retryBuildOperationSettings().build();
    approveBuildSettings = settingsBuilder.approveBuildSettings().build();
    approveBuildOperationSettings = settingsBuilder.approveBuildOperationSettings().build();
    createBuildTriggerSettings = settingsBuilder.createBuildTriggerSettings().build();
    getBuildTriggerSettings = settingsBuilder.getBuildTriggerSettings().build();
    listBuildTriggersSettings = settingsBuilder.listBuildTriggersSettings().build();
    deleteBuildTriggerSettings = settingsBuilder.deleteBuildTriggerSettings().build();
    updateBuildTriggerSettings = settingsBuilder.updateBuildTriggerSettings().build();
    runBuildTriggerSettings = settingsBuilder.runBuildTriggerSettings().build();
    runBuildTriggerOperationSettings = settingsBuilder.runBuildTriggerOperationSettings().build();
    receiveTriggerWebhookSettings = settingsBuilder.receiveTriggerWebhookSettings().build();
    createWorkerPoolSettings = settingsBuilder.createWorkerPoolSettings().build();
    createWorkerPoolOperationSettings = settingsBuilder.createWorkerPoolOperationSettings().build();
    getWorkerPoolSettings = settingsBuilder.getWorkerPoolSettings().build();
    deleteWorkerPoolSettings = settingsBuilder.deleteWorkerPoolSettings().build();
    deleteWorkerPoolOperationSettings = settingsBuilder.deleteWorkerPoolOperationSettings().build();
    updateWorkerPoolSettings = settingsBuilder.updateWorkerPoolSettings().build();
    updateWorkerPoolOperationSettings = settingsBuilder.updateWorkerPoolOperationSettings().build();
    listWorkerPoolsSettings = settingsBuilder.listWorkerPoolsSettings().build();
  }

  /** Builder for CloudBuildStubSettings. */
  public static class Builder extends StubSettings.Builder<CloudBuildStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateBuildRequest, Operation> createBuildSettings;
    private final OperationCallSettings.Builder<CreateBuildRequest, Build, BuildOperationMetadata>
        createBuildOperationSettings;
    private final UnaryCallSettings.Builder<GetBuildRequest, Build> getBuildSettings;
    private final PagedCallSettings.Builder<
            ListBuildsRequest, ListBuildsResponse, ListBuildsPagedResponse>
        listBuildsSettings;
    private final UnaryCallSettings.Builder<CancelBuildRequest, Build> cancelBuildSettings;
    private final UnaryCallSettings.Builder<RetryBuildRequest, Operation> retryBuildSettings;
    private final OperationCallSettings.Builder<RetryBuildRequest, Build, BuildOperationMetadata>
        retryBuildOperationSettings;
    private final UnaryCallSettings.Builder<ApproveBuildRequest, Operation> approveBuildSettings;
    private final OperationCallSettings.Builder<ApproveBuildRequest, Build, BuildOperationMetadata>
        approveBuildOperationSettings;
    private final UnaryCallSettings.Builder<CreateBuildTriggerRequest, BuildTrigger>
        createBuildTriggerSettings;
    private final UnaryCallSettings.Builder<GetBuildTriggerRequest, BuildTrigger>
        getBuildTriggerSettings;
    private final PagedCallSettings.Builder<
            ListBuildTriggersRequest, ListBuildTriggersResponse, ListBuildTriggersPagedResponse>
        listBuildTriggersSettings;
    private final UnaryCallSettings.Builder<DeleteBuildTriggerRequest, Empty>
        deleteBuildTriggerSettings;
    private final UnaryCallSettings.Builder<UpdateBuildTriggerRequest, BuildTrigger>
        updateBuildTriggerSettings;
    private final UnaryCallSettings.Builder<RunBuildTriggerRequest, Operation>
        runBuildTriggerSettings;
    private final OperationCallSettings.Builder<
            RunBuildTriggerRequest, Build, BuildOperationMetadata>
        runBuildTriggerOperationSettings;
    private final UnaryCallSettings.Builder<
            ReceiveTriggerWebhookRequest, ReceiveTriggerWebhookResponse>
        receiveTriggerWebhookSettings;
    private final UnaryCallSettings.Builder<CreateWorkerPoolRequest, Operation>
        createWorkerPoolSettings;
    private final OperationCallSettings.Builder<
            CreateWorkerPoolRequest, WorkerPool, CreateWorkerPoolOperationMetadata>
        createWorkerPoolOperationSettings;
    private final UnaryCallSettings.Builder<GetWorkerPoolRequest, WorkerPool> getWorkerPoolSettings;
    private final UnaryCallSettings.Builder<DeleteWorkerPoolRequest, Operation>
        deleteWorkerPoolSettings;
    private final OperationCallSettings.Builder<
            DeleteWorkerPoolRequest, Empty, DeleteWorkerPoolOperationMetadata>
        deleteWorkerPoolOperationSettings;
    private final UnaryCallSettings.Builder<UpdateWorkerPoolRequest, Operation>
        updateWorkerPoolSettings;
    private final OperationCallSettings.Builder<
            UpdateWorkerPoolRequest, WorkerPool, UpdateWorkerPoolOperationMetadata>
        updateWorkerPoolOperationSettings;
    private final PagedCallSettings.Builder<
            ListWorkerPoolsRequest, ListWorkerPoolsResponse, ListWorkerPoolsPagedResponse>
        listWorkerPoolsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.DEADLINE_EXCEEDED)));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_1_params", settings);
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
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createBuildSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBuildOperationSettings = OperationCallSettings.newBuilder();
      getBuildSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listBuildsSettings = PagedCallSettings.newBuilder(LIST_BUILDS_PAGE_STR_FACT);
      cancelBuildSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      retryBuildSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      retryBuildOperationSettings = OperationCallSettings.newBuilder();
      approveBuildSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      approveBuildOperationSettings = OperationCallSettings.newBuilder();
      createBuildTriggerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getBuildTriggerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listBuildTriggersSettings = PagedCallSettings.newBuilder(LIST_BUILD_TRIGGERS_PAGE_STR_FACT);
      deleteBuildTriggerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBuildTriggerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      runBuildTriggerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      runBuildTriggerOperationSettings = OperationCallSettings.newBuilder();
      receiveTriggerWebhookSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createWorkerPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createWorkerPoolOperationSettings = OperationCallSettings.newBuilder();
      getWorkerPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteWorkerPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteWorkerPoolOperationSettings = OperationCallSettings.newBuilder();
      updateWorkerPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateWorkerPoolOperationSettings = OperationCallSettings.newBuilder();
      listWorkerPoolsSettings = PagedCallSettings.newBuilder(LIST_WORKER_POOLS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createBuildSettings,
              getBuildSettings,
              listBuildsSettings,
              cancelBuildSettings,
              retryBuildSettings,
              approveBuildSettings,
              createBuildTriggerSettings,
              getBuildTriggerSettings,
              listBuildTriggersSettings,
              deleteBuildTriggerSettings,
              updateBuildTriggerSettings,
              runBuildTriggerSettings,
              receiveTriggerWebhookSettings,
              createWorkerPoolSettings,
              getWorkerPoolSettings,
              deleteWorkerPoolSettings,
              updateWorkerPoolSettings,
              listWorkerPoolsSettings);
      initDefaults(this);
    }

    protected Builder(CloudBuildStubSettings settings) {
      super(settings);

      createBuildSettings = settings.createBuildSettings.toBuilder();
      createBuildOperationSettings = settings.createBuildOperationSettings.toBuilder();
      getBuildSettings = settings.getBuildSettings.toBuilder();
      listBuildsSettings = settings.listBuildsSettings.toBuilder();
      cancelBuildSettings = settings.cancelBuildSettings.toBuilder();
      retryBuildSettings = settings.retryBuildSettings.toBuilder();
      retryBuildOperationSettings = settings.retryBuildOperationSettings.toBuilder();
      approveBuildSettings = settings.approveBuildSettings.toBuilder();
      approveBuildOperationSettings = settings.approveBuildOperationSettings.toBuilder();
      createBuildTriggerSettings = settings.createBuildTriggerSettings.toBuilder();
      getBuildTriggerSettings = settings.getBuildTriggerSettings.toBuilder();
      listBuildTriggersSettings = settings.listBuildTriggersSettings.toBuilder();
      deleteBuildTriggerSettings = settings.deleteBuildTriggerSettings.toBuilder();
      updateBuildTriggerSettings = settings.updateBuildTriggerSettings.toBuilder();
      runBuildTriggerSettings = settings.runBuildTriggerSettings.toBuilder();
      runBuildTriggerOperationSettings = settings.runBuildTriggerOperationSettings.toBuilder();
      receiveTriggerWebhookSettings = settings.receiveTriggerWebhookSettings.toBuilder();
      createWorkerPoolSettings = settings.createWorkerPoolSettings.toBuilder();
      createWorkerPoolOperationSettings = settings.createWorkerPoolOperationSettings.toBuilder();
      getWorkerPoolSettings = settings.getWorkerPoolSettings.toBuilder();
      deleteWorkerPoolSettings = settings.deleteWorkerPoolSettings.toBuilder();
      deleteWorkerPoolOperationSettings = settings.deleteWorkerPoolOperationSettings.toBuilder();
      updateWorkerPoolSettings = settings.updateWorkerPoolSettings.toBuilder();
      updateWorkerPoolOperationSettings = settings.updateWorkerPoolOperationSettings.toBuilder();
      listWorkerPoolsSettings = settings.listWorkerPoolsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createBuildSettings,
              getBuildSettings,
              listBuildsSettings,
              cancelBuildSettings,
              retryBuildSettings,
              approveBuildSettings,
              createBuildTriggerSettings,
              getBuildTriggerSettings,
              listBuildTriggersSettings,
              deleteBuildTriggerSettings,
              updateBuildTriggerSettings,
              runBuildTriggerSettings,
              receiveTriggerWebhookSettings,
              createWorkerPoolSettings,
              getWorkerPoolSettings,
              deleteWorkerPoolSettings,
              updateWorkerPoolSettings,
              listWorkerPoolsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createBuildSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getBuildSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listBuildsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .cancelBuildSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .retryBuildSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .approveBuildSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createBuildTriggerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getBuildTriggerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listBuildTriggersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteBuildTriggerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateBuildTriggerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .runBuildTriggerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .receiveTriggerWebhookSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createWorkerPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getWorkerPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteWorkerPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateWorkerPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listWorkerPoolsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createBuildOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateBuildRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Build.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(BuildOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .retryBuildOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<RetryBuildRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Build.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(BuildOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .approveBuildOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ApproveBuildRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Build.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(BuildOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .runBuildTriggerOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RunBuildTriggerRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Build.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(BuildOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createWorkerPoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateWorkerPoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(WorkerPool.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateWorkerPoolOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteWorkerPoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteWorkerPoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  DeleteWorkerPoolOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateWorkerPoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateWorkerPoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(WorkerPool.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UpdateWorkerPoolOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to createBuild. */
    public UnaryCallSettings.Builder<CreateBuildRequest, Operation> createBuildSettings() {
      return createBuildSettings;
    }

    /** Returns the builder for the settings used for calls to createBuild. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateBuildRequest, Build, BuildOperationMetadata>
        createBuildOperationSettings() {
      return createBuildOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getBuild. */
    public UnaryCallSettings.Builder<GetBuildRequest, Build> getBuildSettings() {
      return getBuildSettings;
    }

    /** Returns the builder for the settings used for calls to listBuilds. */
    public PagedCallSettings.Builder<ListBuildsRequest, ListBuildsResponse, ListBuildsPagedResponse>
        listBuildsSettings() {
      return listBuildsSettings;
    }

    /** Returns the builder for the settings used for calls to cancelBuild. */
    public UnaryCallSettings.Builder<CancelBuildRequest, Build> cancelBuildSettings() {
      return cancelBuildSettings;
    }

    /** Returns the builder for the settings used for calls to retryBuild. */
    public UnaryCallSettings.Builder<RetryBuildRequest, Operation> retryBuildSettings() {
      return retryBuildSettings;
    }

    /** Returns the builder for the settings used for calls to retryBuild. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<RetryBuildRequest, Build, BuildOperationMetadata>
        retryBuildOperationSettings() {
      return retryBuildOperationSettings;
    }

    /** Returns the builder for the settings used for calls to approveBuild. */
    public UnaryCallSettings.Builder<ApproveBuildRequest, Operation> approveBuildSettings() {
      return approveBuildSettings;
    }

    /** Returns the builder for the settings used for calls to approveBuild. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<ApproveBuildRequest, Build, BuildOperationMetadata>
        approveBuildOperationSettings() {
      return approveBuildOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createBuildTrigger. */
    public UnaryCallSettings.Builder<CreateBuildTriggerRequest, BuildTrigger>
        createBuildTriggerSettings() {
      return createBuildTriggerSettings;
    }

    /** Returns the builder for the settings used for calls to getBuildTrigger. */
    public UnaryCallSettings.Builder<GetBuildTriggerRequest, BuildTrigger>
        getBuildTriggerSettings() {
      return getBuildTriggerSettings;
    }

    /** Returns the builder for the settings used for calls to listBuildTriggers. */
    public PagedCallSettings.Builder<
            ListBuildTriggersRequest, ListBuildTriggersResponse, ListBuildTriggersPagedResponse>
        listBuildTriggersSettings() {
      return listBuildTriggersSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBuildTrigger. */
    public UnaryCallSettings.Builder<DeleteBuildTriggerRequest, Empty>
        deleteBuildTriggerSettings() {
      return deleteBuildTriggerSettings;
    }

    /** Returns the builder for the settings used for calls to updateBuildTrigger. */
    public UnaryCallSettings.Builder<UpdateBuildTriggerRequest, BuildTrigger>
        updateBuildTriggerSettings() {
      return updateBuildTriggerSettings;
    }

    /** Returns the builder for the settings used for calls to runBuildTrigger. */
    public UnaryCallSettings.Builder<RunBuildTriggerRequest, Operation> runBuildTriggerSettings() {
      return runBuildTriggerSettings;
    }

    /** Returns the builder for the settings used for calls to runBuildTrigger. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<RunBuildTriggerRequest, Build, BuildOperationMetadata>
        runBuildTriggerOperationSettings() {
      return runBuildTriggerOperationSettings;
    }

    /** Returns the builder for the settings used for calls to receiveTriggerWebhook. */
    public UnaryCallSettings.Builder<ReceiveTriggerWebhookRequest, ReceiveTriggerWebhookResponse>
        receiveTriggerWebhookSettings() {
      return receiveTriggerWebhookSettings;
    }

    /** Returns the builder for the settings used for calls to createWorkerPool. */
    public UnaryCallSettings.Builder<CreateWorkerPoolRequest, Operation>
        createWorkerPoolSettings() {
      return createWorkerPoolSettings;
    }

    /** Returns the builder for the settings used for calls to createWorkerPool. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateWorkerPoolRequest, WorkerPool, CreateWorkerPoolOperationMetadata>
        createWorkerPoolOperationSettings() {
      return createWorkerPoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getWorkerPool. */
    public UnaryCallSettings.Builder<GetWorkerPoolRequest, WorkerPool> getWorkerPoolSettings() {
      return getWorkerPoolSettings;
    }

    /** Returns the builder for the settings used for calls to deleteWorkerPool. */
    public UnaryCallSettings.Builder<DeleteWorkerPoolRequest, Operation>
        deleteWorkerPoolSettings() {
      return deleteWorkerPoolSettings;
    }

    /** Returns the builder for the settings used for calls to deleteWorkerPool. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeleteWorkerPoolRequest, Empty, DeleteWorkerPoolOperationMetadata>
        deleteWorkerPoolOperationSettings() {
      return deleteWorkerPoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateWorkerPool. */
    public UnaryCallSettings.Builder<UpdateWorkerPoolRequest, Operation>
        updateWorkerPoolSettings() {
      return updateWorkerPoolSettings;
    }

    /** Returns the builder for the settings used for calls to updateWorkerPool. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateWorkerPoolRequest, WorkerPool, UpdateWorkerPoolOperationMetadata>
        updateWorkerPoolOperationSettings() {
      return updateWorkerPoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listWorkerPools. */
    public PagedCallSettings.Builder<
            ListWorkerPoolsRequest, ListWorkerPoolsResponse, ListWorkerPoolsPagedResponse>
        listWorkerPoolsSettings() {
      return listWorkerPoolsSettings;
    }

    @Override
    public CloudBuildStubSettings build() throws IOException {
      return new CloudBuildStubSettings(this);
    }
  }
}
