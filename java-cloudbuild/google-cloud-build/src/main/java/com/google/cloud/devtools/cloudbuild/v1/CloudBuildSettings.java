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

package com.google.cloud.devtools.cloudbuild.v1;

import static com.google.cloud.devtools.cloudbuild.v1.CloudBuildClient.ListBuildTriggersPagedResponse;
import static com.google.cloud.devtools.cloudbuild.v1.CloudBuildClient.ListBuildsPagedResponse;
import static com.google.cloud.devtools.cloudbuild.v1.CloudBuildClient.ListWorkerPoolsPagedResponse;

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
import com.google.cloud.devtools.cloudbuild.v1.stub.CloudBuildStubSettings;
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
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CloudBuildClient}.
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
 * CloudBuildSettings.Builder cloudBuildSettingsBuilder = CloudBuildSettings.newBuilder();
 * cloudBuildSettingsBuilder
 *     .getBuildSettings()
 *     .setRetrySettings(
 *         cloudBuildSettingsBuilder.getBuildSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CloudBuildSettings cloudBuildSettings = cloudBuildSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CloudBuildSettings extends ClientSettings<CloudBuildSettings> {

  /** Returns the object with the settings used for calls to createBuild. */
  public UnaryCallSettings<CreateBuildRequest, Operation> createBuildSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).createBuildSettings();
  }

  /** Returns the object with the settings used for calls to createBuild. */
  public OperationCallSettings<CreateBuildRequest, Build, BuildOperationMetadata>
      createBuildOperationSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).createBuildOperationSettings();
  }

  /** Returns the object with the settings used for calls to getBuild. */
  public UnaryCallSettings<GetBuildRequest, Build> getBuildSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).getBuildSettings();
  }

  /** Returns the object with the settings used for calls to listBuilds. */
  public PagedCallSettings<ListBuildsRequest, ListBuildsResponse, ListBuildsPagedResponse>
      listBuildsSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).listBuildsSettings();
  }

  /** Returns the object with the settings used for calls to cancelBuild. */
  public UnaryCallSettings<CancelBuildRequest, Build> cancelBuildSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).cancelBuildSettings();
  }

  /** Returns the object with the settings used for calls to retryBuild. */
  public UnaryCallSettings<RetryBuildRequest, Operation> retryBuildSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).retryBuildSettings();
  }

  /** Returns the object with the settings used for calls to retryBuild. */
  public OperationCallSettings<RetryBuildRequest, Build, BuildOperationMetadata>
      retryBuildOperationSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).retryBuildOperationSettings();
  }

  /** Returns the object with the settings used for calls to approveBuild. */
  public UnaryCallSettings<ApproveBuildRequest, Operation> approveBuildSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).approveBuildSettings();
  }

  /** Returns the object with the settings used for calls to approveBuild. */
  public OperationCallSettings<ApproveBuildRequest, Build, BuildOperationMetadata>
      approveBuildOperationSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).approveBuildOperationSettings();
  }

  /** Returns the object with the settings used for calls to createBuildTrigger. */
  public UnaryCallSettings<CreateBuildTriggerRequest, BuildTrigger> createBuildTriggerSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).createBuildTriggerSettings();
  }

  /** Returns the object with the settings used for calls to getBuildTrigger. */
  public UnaryCallSettings<GetBuildTriggerRequest, BuildTrigger> getBuildTriggerSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).getBuildTriggerSettings();
  }

  /** Returns the object with the settings used for calls to listBuildTriggers. */
  public PagedCallSettings<
          ListBuildTriggersRequest, ListBuildTriggersResponse, ListBuildTriggersPagedResponse>
      listBuildTriggersSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).listBuildTriggersSettings();
  }

  /** Returns the object with the settings used for calls to deleteBuildTrigger. */
  public UnaryCallSettings<DeleteBuildTriggerRequest, Empty> deleteBuildTriggerSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).deleteBuildTriggerSettings();
  }

  /** Returns the object with the settings used for calls to updateBuildTrigger. */
  public UnaryCallSettings<UpdateBuildTriggerRequest, BuildTrigger> updateBuildTriggerSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).updateBuildTriggerSettings();
  }

  /** Returns the object with the settings used for calls to runBuildTrigger. */
  public UnaryCallSettings<RunBuildTriggerRequest, Operation> runBuildTriggerSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).runBuildTriggerSettings();
  }

  /** Returns the object with the settings used for calls to runBuildTrigger. */
  public OperationCallSettings<RunBuildTriggerRequest, Build, BuildOperationMetadata>
      runBuildTriggerOperationSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).runBuildTriggerOperationSettings();
  }

  /** Returns the object with the settings used for calls to receiveTriggerWebhook. */
  public UnaryCallSettings<ReceiveTriggerWebhookRequest, ReceiveTriggerWebhookResponse>
      receiveTriggerWebhookSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).receiveTriggerWebhookSettings();
  }

  /** Returns the object with the settings used for calls to createWorkerPool. */
  public UnaryCallSettings<CreateWorkerPoolRequest, Operation> createWorkerPoolSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).createWorkerPoolSettings();
  }

  /** Returns the object with the settings used for calls to createWorkerPool. */
  public OperationCallSettings<
          CreateWorkerPoolRequest, WorkerPool, CreateWorkerPoolOperationMetadata>
      createWorkerPoolOperationSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).createWorkerPoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to getWorkerPool. */
  public UnaryCallSettings<GetWorkerPoolRequest, WorkerPool> getWorkerPoolSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).getWorkerPoolSettings();
  }

  /** Returns the object with the settings used for calls to deleteWorkerPool. */
  public UnaryCallSettings<DeleteWorkerPoolRequest, Operation> deleteWorkerPoolSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).deleteWorkerPoolSettings();
  }

  /** Returns the object with the settings used for calls to deleteWorkerPool. */
  public OperationCallSettings<DeleteWorkerPoolRequest, Empty, DeleteWorkerPoolOperationMetadata>
      deleteWorkerPoolOperationSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).deleteWorkerPoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateWorkerPool. */
  public UnaryCallSettings<UpdateWorkerPoolRequest, Operation> updateWorkerPoolSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).updateWorkerPoolSettings();
  }

  /** Returns the object with the settings used for calls to updateWorkerPool. */
  public OperationCallSettings<
          UpdateWorkerPoolRequest, WorkerPool, UpdateWorkerPoolOperationMetadata>
      updateWorkerPoolOperationSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).updateWorkerPoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to listWorkerPools. */
  public PagedCallSettings<
          ListWorkerPoolsRequest, ListWorkerPoolsResponse, ListWorkerPoolsPagedResponse>
      listWorkerPoolsSettings() {
    return ((CloudBuildStubSettings) getStubSettings()).listWorkerPoolsSettings();
  }

  public static final CloudBuildSettings create(CloudBuildStubSettings stub) throws IOException {
    return new CloudBuildSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CloudBuildStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CloudBuildStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CloudBuildStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CloudBuildStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return CloudBuildStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CloudBuildStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CloudBuildStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CloudBuildStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected CloudBuildSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CloudBuildSettings. */
  public static class Builder extends ClientSettings.Builder<CloudBuildSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(CloudBuildStubSettings.newBuilder(clientContext));
    }

    protected Builder(CloudBuildSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CloudBuildStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CloudBuildStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(CloudBuildStubSettings.newHttpJsonBuilder());
    }

    public CloudBuildStubSettings.Builder getStubSettingsBuilder() {
      return ((CloudBuildStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createBuild. */
    public UnaryCallSettings.Builder<CreateBuildRequest, Operation> createBuildSettings() {
      return getStubSettingsBuilder().createBuildSettings();
    }

    /** Returns the builder for the settings used for calls to createBuild. */
    public OperationCallSettings.Builder<CreateBuildRequest, Build, BuildOperationMetadata>
        createBuildOperationSettings() {
      return getStubSettingsBuilder().createBuildOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getBuild. */
    public UnaryCallSettings.Builder<GetBuildRequest, Build> getBuildSettings() {
      return getStubSettingsBuilder().getBuildSettings();
    }

    /** Returns the builder for the settings used for calls to listBuilds. */
    public PagedCallSettings.Builder<ListBuildsRequest, ListBuildsResponse, ListBuildsPagedResponse>
        listBuildsSettings() {
      return getStubSettingsBuilder().listBuildsSettings();
    }

    /** Returns the builder for the settings used for calls to cancelBuild. */
    public UnaryCallSettings.Builder<CancelBuildRequest, Build> cancelBuildSettings() {
      return getStubSettingsBuilder().cancelBuildSettings();
    }

    /** Returns the builder for the settings used for calls to retryBuild. */
    public UnaryCallSettings.Builder<RetryBuildRequest, Operation> retryBuildSettings() {
      return getStubSettingsBuilder().retryBuildSettings();
    }

    /** Returns the builder for the settings used for calls to retryBuild. */
    public OperationCallSettings.Builder<RetryBuildRequest, Build, BuildOperationMetadata>
        retryBuildOperationSettings() {
      return getStubSettingsBuilder().retryBuildOperationSettings();
    }

    /** Returns the builder for the settings used for calls to approveBuild. */
    public UnaryCallSettings.Builder<ApproveBuildRequest, Operation> approveBuildSettings() {
      return getStubSettingsBuilder().approveBuildSettings();
    }

    /** Returns the builder for the settings used for calls to approveBuild. */
    public OperationCallSettings.Builder<ApproveBuildRequest, Build, BuildOperationMetadata>
        approveBuildOperationSettings() {
      return getStubSettingsBuilder().approveBuildOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createBuildTrigger. */
    public UnaryCallSettings.Builder<CreateBuildTriggerRequest, BuildTrigger>
        createBuildTriggerSettings() {
      return getStubSettingsBuilder().createBuildTriggerSettings();
    }

    /** Returns the builder for the settings used for calls to getBuildTrigger. */
    public UnaryCallSettings.Builder<GetBuildTriggerRequest, BuildTrigger>
        getBuildTriggerSettings() {
      return getStubSettingsBuilder().getBuildTriggerSettings();
    }

    /** Returns the builder for the settings used for calls to listBuildTriggers. */
    public PagedCallSettings.Builder<
            ListBuildTriggersRequest, ListBuildTriggersResponse, ListBuildTriggersPagedResponse>
        listBuildTriggersSettings() {
      return getStubSettingsBuilder().listBuildTriggersSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBuildTrigger. */
    public UnaryCallSettings.Builder<DeleteBuildTriggerRequest, Empty>
        deleteBuildTriggerSettings() {
      return getStubSettingsBuilder().deleteBuildTriggerSettings();
    }

    /** Returns the builder for the settings used for calls to updateBuildTrigger. */
    public UnaryCallSettings.Builder<UpdateBuildTriggerRequest, BuildTrigger>
        updateBuildTriggerSettings() {
      return getStubSettingsBuilder().updateBuildTriggerSettings();
    }

    /** Returns the builder for the settings used for calls to runBuildTrigger. */
    public UnaryCallSettings.Builder<RunBuildTriggerRequest, Operation> runBuildTriggerSettings() {
      return getStubSettingsBuilder().runBuildTriggerSettings();
    }

    /** Returns the builder for the settings used for calls to runBuildTrigger. */
    public OperationCallSettings.Builder<RunBuildTriggerRequest, Build, BuildOperationMetadata>
        runBuildTriggerOperationSettings() {
      return getStubSettingsBuilder().runBuildTriggerOperationSettings();
    }

    /** Returns the builder for the settings used for calls to receiveTriggerWebhook. */
    public UnaryCallSettings.Builder<ReceiveTriggerWebhookRequest, ReceiveTriggerWebhookResponse>
        receiveTriggerWebhookSettings() {
      return getStubSettingsBuilder().receiveTriggerWebhookSettings();
    }

    /** Returns the builder for the settings used for calls to createWorkerPool. */
    public UnaryCallSettings.Builder<CreateWorkerPoolRequest, Operation>
        createWorkerPoolSettings() {
      return getStubSettingsBuilder().createWorkerPoolSettings();
    }

    /** Returns the builder for the settings used for calls to createWorkerPool. */
    public OperationCallSettings.Builder<
            CreateWorkerPoolRequest, WorkerPool, CreateWorkerPoolOperationMetadata>
        createWorkerPoolOperationSettings() {
      return getStubSettingsBuilder().createWorkerPoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getWorkerPool. */
    public UnaryCallSettings.Builder<GetWorkerPoolRequest, WorkerPool> getWorkerPoolSettings() {
      return getStubSettingsBuilder().getWorkerPoolSettings();
    }

    /** Returns the builder for the settings used for calls to deleteWorkerPool. */
    public UnaryCallSettings.Builder<DeleteWorkerPoolRequest, Operation>
        deleteWorkerPoolSettings() {
      return getStubSettingsBuilder().deleteWorkerPoolSettings();
    }

    /** Returns the builder for the settings used for calls to deleteWorkerPool. */
    public OperationCallSettings.Builder<
            DeleteWorkerPoolRequest, Empty, DeleteWorkerPoolOperationMetadata>
        deleteWorkerPoolOperationSettings() {
      return getStubSettingsBuilder().deleteWorkerPoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateWorkerPool. */
    public UnaryCallSettings.Builder<UpdateWorkerPoolRequest, Operation>
        updateWorkerPoolSettings() {
      return getStubSettingsBuilder().updateWorkerPoolSettings();
    }

    /** Returns the builder for the settings used for calls to updateWorkerPool. */
    public OperationCallSettings.Builder<
            UpdateWorkerPoolRequest, WorkerPool, UpdateWorkerPoolOperationMetadata>
        updateWorkerPoolOperationSettings() {
      return getStubSettingsBuilder().updateWorkerPoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listWorkerPools. */
    public PagedCallSettings.Builder<
            ListWorkerPoolsRequest, ListWorkerPoolsResponse, ListWorkerPoolsPagedResponse>
        listWorkerPoolsSettings() {
      return getStubSettingsBuilder().listWorkerPoolsSettings();
    }

    @Override
    public CloudBuildSettings build() throws IOException {
      return new CloudBuildSettings(this);
    }
  }
}
