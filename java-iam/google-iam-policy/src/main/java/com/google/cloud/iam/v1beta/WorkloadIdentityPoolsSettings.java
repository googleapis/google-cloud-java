/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.iam.v1beta;

import static com.google.cloud.iam.v1beta.WorkloadIdentityPoolsClient.ListWorkloadIdentityPoolProvidersPagedResponse;
import static com.google.cloud.iam.v1beta.WorkloadIdentityPoolsClient.ListWorkloadIdentityPoolsPagedResponse;

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
import com.google.cloud.iam.v1beta.stub.WorkloadIdentityPoolsStubSettings;
import com.google.iam.v1beta.CreateWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.CreateWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.DeleteWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.DeleteWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.GetWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.GetWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersRequest;
import com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersResponse;
import com.google.iam.v1beta.ListWorkloadIdentityPoolsRequest;
import com.google.iam.v1beta.ListWorkloadIdentityPoolsResponse;
import com.google.iam.v1beta.UndeleteWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.UndeleteWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.UpdateWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.UpdateWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.WorkloadIdentityPool;
import com.google.iam.v1beta.WorkloadIdentityPoolOperationMetadata;
import com.google.iam.v1beta.WorkloadIdentityPoolProvider;
import com.google.iam.v1beta.WorkloadIdentityPoolProviderOperationMetadata;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link WorkloadIdentityPoolsClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (iam.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getWorkloadIdentityPool to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * WorkloadIdentityPoolsSettings.Builder workloadIdentityPoolsSettingsBuilder =
 *     WorkloadIdentityPoolsSettings.newBuilder();
 * workloadIdentityPoolsSettingsBuilder
 *     .getWorkloadIdentityPoolSettings()
 *     .setRetrySettings(
 *         workloadIdentityPoolsSettingsBuilder
 *             .getWorkloadIdentityPoolSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * WorkloadIdentityPoolsSettings workloadIdentityPoolsSettings =
 *     workloadIdentityPoolsSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class WorkloadIdentityPoolsSettings extends ClientSettings<WorkloadIdentityPoolsSettings> {

  /** Returns the object with the settings used for calls to listWorkloadIdentityPools. */
  public PagedCallSettings<
          ListWorkloadIdentityPoolsRequest,
          ListWorkloadIdentityPoolsResponse,
          ListWorkloadIdentityPoolsPagedResponse>
      listWorkloadIdentityPoolsSettings() {
    return ((WorkloadIdentityPoolsStubSettings) getStubSettings())
        .listWorkloadIdentityPoolsSettings();
  }

  /** Returns the object with the settings used for calls to getWorkloadIdentityPool. */
  public UnaryCallSettings<GetWorkloadIdentityPoolRequest, WorkloadIdentityPool>
      getWorkloadIdentityPoolSettings() {
    return ((WorkloadIdentityPoolsStubSettings) getStubSettings())
        .getWorkloadIdentityPoolSettings();
  }

  /** Returns the object with the settings used for calls to createWorkloadIdentityPool. */
  public UnaryCallSettings<CreateWorkloadIdentityPoolRequest, Operation>
      createWorkloadIdentityPoolSettings() {
    return ((WorkloadIdentityPoolsStubSettings) getStubSettings())
        .createWorkloadIdentityPoolSettings();
  }

  /** Returns the object with the settings used for calls to createWorkloadIdentityPool. */
  public OperationCallSettings<
          CreateWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      createWorkloadIdentityPoolOperationSettings() {
    return ((WorkloadIdentityPoolsStubSettings) getStubSettings())
        .createWorkloadIdentityPoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateWorkloadIdentityPool. */
  public UnaryCallSettings<UpdateWorkloadIdentityPoolRequest, Operation>
      updateWorkloadIdentityPoolSettings() {
    return ((WorkloadIdentityPoolsStubSettings) getStubSettings())
        .updateWorkloadIdentityPoolSettings();
  }

  /** Returns the object with the settings used for calls to updateWorkloadIdentityPool. */
  public OperationCallSettings<
          UpdateWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      updateWorkloadIdentityPoolOperationSettings() {
    return ((WorkloadIdentityPoolsStubSettings) getStubSettings())
        .updateWorkloadIdentityPoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteWorkloadIdentityPool. */
  public UnaryCallSettings<DeleteWorkloadIdentityPoolRequest, Operation>
      deleteWorkloadIdentityPoolSettings() {
    return ((WorkloadIdentityPoolsStubSettings) getStubSettings())
        .deleteWorkloadIdentityPoolSettings();
  }

  /** Returns the object with the settings used for calls to deleteWorkloadIdentityPool. */
  public OperationCallSettings<
          DeleteWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      deleteWorkloadIdentityPoolOperationSettings() {
    return ((WorkloadIdentityPoolsStubSettings) getStubSettings())
        .deleteWorkloadIdentityPoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to undeleteWorkloadIdentityPool. */
  public UnaryCallSettings<UndeleteWorkloadIdentityPoolRequest, Operation>
      undeleteWorkloadIdentityPoolSettings() {
    return ((WorkloadIdentityPoolsStubSettings) getStubSettings())
        .undeleteWorkloadIdentityPoolSettings();
  }

  /** Returns the object with the settings used for calls to undeleteWorkloadIdentityPool. */
  public OperationCallSettings<
          UndeleteWorkloadIdentityPoolRequest,
          WorkloadIdentityPool,
          WorkloadIdentityPoolOperationMetadata>
      undeleteWorkloadIdentityPoolOperationSettings() {
    return ((WorkloadIdentityPoolsStubSettings) getStubSettings())
        .undeleteWorkloadIdentityPoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to listWorkloadIdentityPoolProviders. */
  public PagedCallSettings<
          ListWorkloadIdentityPoolProvidersRequest,
          ListWorkloadIdentityPoolProvidersResponse,
          ListWorkloadIdentityPoolProvidersPagedResponse>
      listWorkloadIdentityPoolProvidersSettings() {
    return ((WorkloadIdentityPoolsStubSettings) getStubSettings())
        .listWorkloadIdentityPoolProvidersSettings();
  }

  /** Returns the object with the settings used for calls to getWorkloadIdentityPoolProvider. */
  public UnaryCallSettings<GetWorkloadIdentityPoolProviderRequest, WorkloadIdentityPoolProvider>
      getWorkloadIdentityPoolProviderSettings() {
    return ((WorkloadIdentityPoolsStubSettings) getStubSettings())
        .getWorkloadIdentityPoolProviderSettings();
  }

  /** Returns the object with the settings used for calls to createWorkloadIdentityPoolProvider. */
  public UnaryCallSettings<CreateWorkloadIdentityPoolProviderRequest, Operation>
      createWorkloadIdentityPoolProviderSettings() {
    return ((WorkloadIdentityPoolsStubSettings) getStubSettings())
        .createWorkloadIdentityPoolProviderSettings();
  }

  /** Returns the object with the settings used for calls to createWorkloadIdentityPoolProvider. */
  public OperationCallSettings<
          CreateWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      createWorkloadIdentityPoolProviderOperationSettings() {
    return ((WorkloadIdentityPoolsStubSettings) getStubSettings())
        .createWorkloadIdentityPoolProviderOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateWorkloadIdentityPoolProvider. */
  public UnaryCallSettings<UpdateWorkloadIdentityPoolProviderRequest, Operation>
      updateWorkloadIdentityPoolProviderSettings() {
    return ((WorkloadIdentityPoolsStubSettings) getStubSettings())
        .updateWorkloadIdentityPoolProviderSettings();
  }

  /** Returns the object with the settings used for calls to updateWorkloadIdentityPoolProvider. */
  public OperationCallSettings<
          UpdateWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      updateWorkloadIdentityPoolProviderOperationSettings() {
    return ((WorkloadIdentityPoolsStubSettings) getStubSettings())
        .updateWorkloadIdentityPoolProviderOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteWorkloadIdentityPoolProvider. */
  public UnaryCallSettings<DeleteWorkloadIdentityPoolProviderRequest, Operation>
      deleteWorkloadIdentityPoolProviderSettings() {
    return ((WorkloadIdentityPoolsStubSettings) getStubSettings())
        .deleteWorkloadIdentityPoolProviderSettings();
  }

  /** Returns the object with the settings used for calls to deleteWorkloadIdentityPoolProvider. */
  public OperationCallSettings<
          DeleteWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      deleteWorkloadIdentityPoolProviderOperationSettings() {
    return ((WorkloadIdentityPoolsStubSettings) getStubSettings())
        .deleteWorkloadIdentityPoolProviderOperationSettings();
  }

  /**
   * Returns the object with the settings used for calls to undeleteWorkloadIdentityPoolProvider.
   */
  public UnaryCallSettings<UndeleteWorkloadIdentityPoolProviderRequest, Operation>
      undeleteWorkloadIdentityPoolProviderSettings() {
    return ((WorkloadIdentityPoolsStubSettings) getStubSettings())
        .undeleteWorkloadIdentityPoolProviderSettings();
  }

  /**
   * Returns the object with the settings used for calls to undeleteWorkloadIdentityPoolProvider.
   */
  public OperationCallSettings<
          UndeleteWorkloadIdentityPoolProviderRequest,
          WorkloadIdentityPoolProvider,
          WorkloadIdentityPoolProviderOperationMetadata>
      undeleteWorkloadIdentityPoolProviderOperationSettings() {
    return ((WorkloadIdentityPoolsStubSettings) getStubSettings())
        .undeleteWorkloadIdentityPoolProviderOperationSettings();
  }

  public static final WorkloadIdentityPoolsSettings create(WorkloadIdentityPoolsStubSettings stub)
      throws IOException {
    return new WorkloadIdentityPoolsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return WorkloadIdentityPoolsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return WorkloadIdentityPoolsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return WorkloadIdentityPoolsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return WorkloadIdentityPoolsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return WorkloadIdentityPoolsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return WorkloadIdentityPoolsStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return WorkloadIdentityPoolsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected WorkloadIdentityPoolsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for WorkloadIdentityPoolsSettings. */
  public static class Builder
      extends ClientSettings.Builder<WorkloadIdentityPoolsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(WorkloadIdentityPoolsStubSettings.newBuilder(clientContext));
    }

    protected Builder(WorkloadIdentityPoolsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(WorkloadIdentityPoolsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(WorkloadIdentityPoolsStubSettings.newBuilder());
    }

    public WorkloadIdentityPoolsStubSettings.Builder getStubSettingsBuilder() {
      return ((WorkloadIdentityPoolsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listWorkloadIdentityPools. */
    public PagedCallSettings.Builder<
            ListWorkloadIdentityPoolsRequest,
            ListWorkloadIdentityPoolsResponse,
            ListWorkloadIdentityPoolsPagedResponse>
        listWorkloadIdentityPoolsSettings() {
      return getStubSettingsBuilder().listWorkloadIdentityPoolsSettings();
    }

    /** Returns the builder for the settings used for calls to getWorkloadIdentityPool. */
    public UnaryCallSettings.Builder<GetWorkloadIdentityPoolRequest, WorkloadIdentityPool>
        getWorkloadIdentityPoolSettings() {
      return getStubSettingsBuilder().getWorkloadIdentityPoolSettings();
    }

    /** Returns the builder for the settings used for calls to createWorkloadIdentityPool. */
    public UnaryCallSettings.Builder<CreateWorkloadIdentityPoolRequest, Operation>
        createWorkloadIdentityPoolSettings() {
      return getStubSettingsBuilder().createWorkloadIdentityPoolSettings();
    }

    /** Returns the builder for the settings used for calls to createWorkloadIdentityPool. */
    public OperationCallSettings.Builder<
            CreateWorkloadIdentityPoolRequest,
            WorkloadIdentityPool,
            WorkloadIdentityPoolOperationMetadata>
        createWorkloadIdentityPoolOperationSettings() {
      return getStubSettingsBuilder().createWorkloadIdentityPoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateWorkloadIdentityPool. */
    public UnaryCallSettings.Builder<UpdateWorkloadIdentityPoolRequest, Operation>
        updateWorkloadIdentityPoolSettings() {
      return getStubSettingsBuilder().updateWorkloadIdentityPoolSettings();
    }

    /** Returns the builder for the settings used for calls to updateWorkloadIdentityPool. */
    public OperationCallSettings.Builder<
            UpdateWorkloadIdentityPoolRequest,
            WorkloadIdentityPool,
            WorkloadIdentityPoolOperationMetadata>
        updateWorkloadIdentityPoolOperationSettings() {
      return getStubSettingsBuilder().updateWorkloadIdentityPoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteWorkloadIdentityPool. */
    public UnaryCallSettings.Builder<DeleteWorkloadIdentityPoolRequest, Operation>
        deleteWorkloadIdentityPoolSettings() {
      return getStubSettingsBuilder().deleteWorkloadIdentityPoolSettings();
    }

    /** Returns the builder for the settings used for calls to deleteWorkloadIdentityPool. */
    public OperationCallSettings.Builder<
            DeleteWorkloadIdentityPoolRequest,
            WorkloadIdentityPool,
            WorkloadIdentityPoolOperationMetadata>
        deleteWorkloadIdentityPoolOperationSettings() {
      return getStubSettingsBuilder().deleteWorkloadIdentityPoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to undeleteWorkloadIdentityPool. */
    public UnaryCallSettings.Builder<UndeleteWorkloadIdentityPoolRequest, Operation>
        undeleteWorkloadIdentityPoolSettings() {
      return getStubSettingsBuilder().undeleteWorkloadIdentityPoolSettings();
    }

    /** Returns the builder for the settings used for calls to undeleteWorkloadIdentityPool. */
    public OperationCallSettings.Builder<
            UndeleteWorkloadIdentityPoolRequest,
            WorkloadIdentityPool,
            WorkloadIdentityPoolOperationMetadata>
        undeleteWorkloadIdentityPoolOperationSettings() {
      return getStubSettingsBuilder().undeleteWorkloadIdentityPoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listWorkloadIdentityPoolProviders. */
    public PagedCallSettings.Builder<
            ListWorkloadIdentityPoolProvidersRequest,
            ListWorkloadIdentityPoolProvidersResponse,
            ListWorkloadIdentityPoolProvidersPagedResponse>
        listWorkloadIdentityPoolProvidersSettings() {
      return getStubSettingsBuilder().listWorkloadIdentityPoolProvidersSettings();
    }

    /** Returns the builder for the settings used for calls to getWorkloadIdentityPoolProvider. */
    public UnaryCallSettings.Builder<
            GetWorkloadIdentityPoolProviderRequest, WorkloadIdentityPoolProvider>
        getWorkloadIdentityPoolProviderSettings() {
      return getStubSettingsBuilder().getWorkloadIdentityPoolProviderSettings();
    }

    /**
     * Returns the builder for the settings used for calls to createWorkloadIdentityPoolProvider.
     */
    public UnaryCallSettings.Builder<CreateWorkloadIdentityPoolProviderRequest, Operation>
        createWorkloadIdentityPoolProviderSettings() {
      return getStubSettingsBuilder().createWorkloadIdentityPoolProviderSettings();
    }

    /**
     * Returns the builder for the settings used for calls to createWorkloadIdentityPoolProvider.
     */
    public OperationCallSettings.Builder<
            CreateWorkloadIdentityPoolProviderRequest,
            WorkloadIdentityPoolProvider,
            WorkloadIdentityPoolProviderOperationMetadata>
        createWorkloadIdentityPoolProviderOperationSettings() {
      return getStubSettingsBuilder().createWorkloadIdentityPoolProviderOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to updateWorkloadIdentityPoolProvider.
     */
    public UnaryCallSettings.Builder<UpdateWorkloadIdentityPoolProviderRequest, Operation>
        updateWorkloadIdentityPoolProviderSettings() {
      return getStubSettingsBuilder().updateWorkloadIdentityPoolProviderSettings();
    }

    /**
     * Returns the builder for the settings used for calls to updateWorkloadIdentityPoolProvider.
     */
    public OperationCallSettings.Builder<
            UpdateWorkloadIdentityPoolProviderRequest,
            WorkloadIdentityPoolProvider,
            WorkloadIdentityPoolProviderOperationMetadata>
        updateWorkloadIdentityPoolProviderOperationSettings() {
      return getStubSettingsBuilder().updateWorkloadIdentityPoolProviderOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to deleteWorkloadIdentityPoolProvider.
     */
    public UnaryCallSettings.Builder<DeleteWorkloadIdentityPoolProviderRequest, Operation>
        deleteWorkloadIdentityPoolProviderSettings() {
      return getStubSettingsBuilder().deleteWorkloadIdentityPoolProviderSettings();
    }

    /**
     * Returns the builder for the settings used for calls to deleteWorkloadIdentityPoolProvider.
     */
    public OperationCallSettings.Builder<
            DeleteWorkloadIdentityPoolProviderRequest,
            WorkloadIdentityPoolProvider,
            WorkloadIdentityPoolProviderOperationMetadata>
        deleteWorkloadIdentityPoolProviderOperationSettings() {
      return getStubSettingsBuilder().deleteWorkloadIdentityPoolProviderOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to undeleteWorkloadIdentityPoolProvider.
     */
    public UnaryCallSettings.Builder<UndeleteWorkloadIdentityPoolProviderRequest, Operation>
        undeleteWorkloadIdentityPoolProviderSettings() {
      return getStubSettingsBuilder().undeleteWorkloadIdentityPoolProviderSettings();
    }

    /**
     * Returns the builder for the settings used for calls to undeleteWorkloadIdentityPoolProvider.
     */
    public OperationCallSettings.Builder<
            UndeleteWorkloadIdentityPoolProviderRequest,
            WorkloadIdentityPoolProvider,
            WorkloadIdentityPoolProviderOperationMetadata>
        undeleteWorkloadIdentityPoolProviderOperationSettings() {
      return getStubSettingsBuilder().undeleteWorkloadIdentityPoolProviderOperationSettings();
    }

    @Override
    public WorkloadIdentityPoolsSettings build() throws IOException {
      return new WorkloadIdentityPoolsSettings(this);
    }
  }
}
