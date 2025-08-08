/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.run.v2.WorkerPoolsClient.ListWorkerPoolsPagedResponse;

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
import com.google.cloud.run.v2.stub.WorkerPoolsStubSettings;
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
 * Settings class to configure an instance of {@link WorkerPoolsClient}.
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
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getWorkerPool:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * WorkerPoolsSettings.Builder workerPoolsSettingsBuilder = WorkerPoolsSettings.newBuilder();
 * workerPoolsSettingsBuilder
 *     .getWorkerPoolSettings()
 *     .setRetrySettings(
 *         workerPoolsSettingsBuilder
 *             .getWorkerPoolSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * WorkerPoolsSettings workerPoolsSettings = workerPoolsSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createWorkerPool:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * WorkerPoolsSettings.Builder workerPoolsSettingsBuilder = WorkerPoolsSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * workerPoolsSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class WorkerPoolsSettings extends ClientSettings<WorkerPoolsSettings> {

  /** Returns the object with the settings used for calls to createWorkerPool. */
  public UnaryCallSettings<CreateWorkerPoolRequest, Operation> createWorkerPoolSettings() {
    return ((WorkerPoolsStubSettings) getStubSettings()).createWorkerPoolSettings();
  }

  /** Returns the object with the settings used for calls to createWorkerPool. */
  public OperationCallSettings<CreateWorkerPoolRequest, WorkerPool, WorkerPool>
      createWorkerPoolOperationSettings() {
    return ((WorkerPoolsStubSettings) getStubSettings()).createWorkerPoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to getWorkerPool. */
  public UnaryCallSettings<GetWorkerPoolRequest, WorkerPool> getWorkerPoolSettings() {
    return ((WorkerPoolsStubSettings) getStubSettings()).getWorkerPoolSettings();
  }

  /** Returns the object with the settings used for calls to listWorkerPools. */
  public PagedCallSettings<
          ListWorkerPoolsRequest, ListWorkerPoolsResponse, ListWorkerPoolsPagedResponse>
      listWorkerPoolsSettings() {
    return ((WorkerPoolsStubSettings) getStubSettings()).listWorkerPoolsSettings();
  }

  /** Returns the object with the settings used for calls to updateWorkerPool. */
  public UnaryCallSettings<UpdateWorkerPoolRequest, Operation> updateWorkerPoolSettings() {
    return ((WorkerPoolsStubSettings) getStubSettings()).updateWorkerPoolSettings();
  }

  /** Returns the object with the settings used for calls to updateWorkerPool. */
  public OperationCallSettings<UpdateWorkerPoolRequest, WorkerPool, WorkerPool>
      updateWorkerPoolOperationSettings() {
    return ((WorkerPoolsStubSettings) getStubSettings()).updateWorkerPoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteWorkerPool. */
  public UnaryCallSettings<DeleteWorkerPoolRequest, Operation> deleteWorkerPoolSettings() {
    return ((WorkerPoolsStubSettings) getStubSettings()).deleteWorkerPoolSettings();
  }

  /** Returns the object with the settings used for calls to deleteWorkerPool. */
  public OperationCallSettings<DeleteWorkerPoolRequest, WorkerPool, WorkerPool>
      deleteWorkerPoolOperationSettings() {
    return ((WorkerPoolsStubSettings) getStubSettings()).deleteWorkerPoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((WorkerPoolsStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((WorkerPoolsStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((WorkerPoolsStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final WorkerPoolsSettings create(WorkerPoolsStubSettings stub) throws IOException {
    return new WorkerPoolsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return WorkerPoolsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return WorkerPoolsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return WorkerPoolsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return WorkerPoolsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return WorkerPoolsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return WorkerPoolsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return WorkerPoolsStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return WorkerPoolsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected WorkerPoolsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for WorkerPoolsSettings. */
  public static class Builder extends ClientSettings.Builder<WorkerPoolsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(WorkerPoolsStubSettings.newBuilder(clientContext));
    }

    protected Builder(WorkerPoolsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(WorkerPoolsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(WorkerPoolsStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(WorkerPoolsStubSettings.newHttpJsonBuilder());
    }

    public WorkerPoolsStubSettings.Builder getStubSettingsBuilder() {
      return ((WorkerPoolsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createWorkerPool. */
    public UnaryCallSettings.Builder<CreateWorkerPoolRequest, Operation>
        createWorkerPoolSettings() {
      return getStubSettingsBuilder().createWorkerPoolSettings();
    }

    /** Returns the builder for the settings used for calls to createWorkerPool. */
    public OperationCallSettings.Builder<CreateWorkerPoolRequest, WorkerPool, WorkerPool>
        createWorkerPoolOperationSettings() {
      return getStubSettingsBuilder().createWorkerPoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getWorkerPool. */
    public UnaryCallSettings.Builder<GetWorkerPoolRequest, WorkerPool> getWorkerPoolSettings() {
      return getStubSettingsBuilder().getWorkerPoolSettings();
    }

    /** Returns the builder for the settings used for calls to listWorkerPools. */
    public PagedCallSettings.Builder<
            ListWorkerPoolsRequest, ListWorkerPoolsResponse, ListWorkerPoolsPagedResponse>
        listWorkerPoolsSettings() {
      return getStubSettingsBuilder().listWorkerPoolsSettings();
    }

    /** Returns the builder for the settings used for calls to updateWorkerPool. */
    public UnaryCallSettings.Builder<UpdateWorkerPoolRequest, Operation>
        updateWorkerPoolSettings() {
      return getStubSettingsBuilder().updateWorkerPoolSettings();
    }

    /** Returns the builder for the settings used for calls to updateWorkerPool. */
    public OperationCallSettings.Builder<UpdateWorkerPoolRequest, WorkerPool, WorkerPool>
        updateWorkerPoolOperationSettings() {
      return getStubSettingsBuilder().updateWorkerPoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteWorkerPool. */
    public UnaryCallSettings.Builder<DeleteWorkerPoolRequest, Operation>
        deleteWorkerPoolSettings() {
      return getStubSettingsBuilder().deleteWorkerPoolSettings();
    }

    /** Returns the builder for the settings used for calls to deleteWorkerPool. */
    public OperationCallSettings.Builder<DeleteWorkerPoolRequest, WorkerPool, WorkerPool>
        deleteWorkerPoolOperationSettings() {
      return getStubSettingsBuilder().deleteWorkerPoolOperationSettings();
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
    public WorkerPoolsSettings build() throws IOException {
      return new WorkerPoolsSettings(this);
    }
  }
}
