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

package com.google.cloud.workflows.v1beta;

import static com.google.cloud.workflows.v1beta.WorkflowsClient.ListWorkflowsPagedResponse;

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
import com.google.cloud.workflows.v1beta.stub.WorkflowsStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link WorkflowsClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (workflows.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getWorkflow to 30 seconds:
 *
 * <pre>{@code
 * WorkflowsSettings.Builder workflowsSettingsBuilder = WorkflowsSettings.newBuilder();
 * workflowsSettingsBuilder
 *     .getWorkflowSettings()
 *     .setRetrySettings(
 *         workflowsSettingsBuilder
 *             .getWorkflowSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * WorkflowsSettings workflowsSettings = workflowsSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class WorkflowsSettings extends ClientSettings<WorkflowsSettings> {

  /** Returns the object with the settings used for calls to listWorkflows. */
  public PagedCallSettings<ListWorkflowsRequest, ListWorkflowsResponse, ListWorkflowsPagedResponse>
      listWorkflowsSettings() {
    return ((WorkflowsStubSettings) getStubSettings()).listWorkflowsSettings();
  }

  /** Returns the object with the settings used for calls to getWorkflow. */
  public UnaryCallSettings<GetWorkflowRequest, Workflow> getWorkflowSettings() {
    return ((WorkflowsStubSettings) getStubSettings()).getWorkflowSettings();
  }

  /** Returns the object with the settings used for calls to createWorkflow. */
  public UnaryCallSettings<CreateWorkflowRequest, Operation> createWorkflowSettings() {
    return ((WorkflowsStubSettings) getStubSettings()).createWorkflowSettings();
  }

  /** Returns the object with the settings used for calls to createWorkflow. */
  public OperationCallSettings<CreateWorkflowRequest, Workflow, OperationMetadata>
      createWorkflowOperationSettings() {
    return ((WorkflowsStubSettings) getStubSettings()).createWorkflowOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteWorkflow. */
  public UnaryCallSettings<DeleteWorkflowRequest, Operation> deleteWorkflowSettings() {
    return ((WorkflowsStubSettings) getStubSettings()).deleteWorkflowSettings();
  }

  /** Returns the object with the settings used for calls to deleteWorkflow. */
  public OperationCallSettings<DeleteWorkflowRequest, Empty, OperationMetadata>
      deleteWorkflowOperationSettings() {
    return ((WorkflowsStubSettings) getStubSettings()).deleteWorkflowOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateWorkflow. */
  public UnaryCallSettings<UpdateWorkflowRequest, Operation> updateWorkflowSettings() {
    return ((WorkflowsStubSettings) getStubSettings()).updateWorkflowSettings();
  }

  /** Returns the object with the settings used for calls to updateWorkflow. */
  public OperationCallSettings<UpdateWorkflowRequest, Workflow, OperationMetadata>
      updateWorkflowOperationSettings() {
    return ((WorkflowsStubSettings) getStubSettings()).updateWorkflowOperationSettings();
  }

  public static final WorkflowsSettings create(WorkflowsStubSettings stub) throws IOException {
    return new WorkflowsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return WorkflowsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return WorkflowsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return WorkflowsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return WorkflowsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return WorkflowsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return WorkflowsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return WorkflowsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected WorkflowsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for WorkflowsSettings. */
  public static class Builder extends ClientSettings.Builder<WorkflowsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(WorkflowsStubSettings.newBuilder(clientContext));
    }

    protected Builder(WorkflowsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(WorkflowsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(WorkflowsStubSettings.newBuilder());
    }

    public WorkflowsStubSettings.Builder getStubSettingsBuilder() {
      return ((WorkflowsStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to listWorkflows. */
    public PagedCallSettings.Builder<
            ListWorkflowsRequest, ListWorkflowsResponse, ListWorkflowsPagedResponse>
        listWorkflowsSettings() {
      return getStubSettingsBuilder().listWorkflowsSettings();
    }

    /** Returns the builder for the settings used for calls to getWorkflow. */
    public UnaryCallSettings.Builder<GetWorkflowRequest, Workflow> getWorkflowSettings() {
      return getStubSettingsBuilder().getWorkflowSettings();
    }

    /** Returns the builder for the settings used for calls to createWorkflow. */
    public UnaryCallSettings.Builder<CreateWorkflowRequest, Operation> createWorkflowSettings() {
      return getStubSettingsBuilder().createWorkflowSettings();
    }

    /** Returns the builder for the settings used for calls to createWorkflow. */
    public OperationCallSettings.Builder<CreateWorkflowRequest, Workflow, OperationMetadata>
        createWorkflowOperationSettings() {
      return getStubSettingsBuilder().createWorkflowOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteWorkflow. */
    public UnaryCallSettings.Builder<DeleteWorkflowRequest, Operation> deleteWorkflowSettings() {
      return getStubSettingsBuilder().deleteWorkflowSettings();
    }

    /** Returns the builder for the settings used for calls to deleteWorkflow. */
    public OperationCallSettings.Builder<DeleteWorkflowRequest, Empty, OperationMetadata>
        deleteWorkflowOperationSettings() {
      return getStubSettingsBuilder().deleteWorkflowOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateWorkflow. */
    public UnaryCallSettings.Builder<UpdateWorkflowRequest, Operation> updateWorkflowSettings() {
      return getStubSettingsBuilder().updateWorkflowSettings();
    }

    /** Returns the builder for the settings used for calls to updateWorkflow. */
    public OperationCallSettings.Builder<UpdateWorkflowRequest, Workflow, OperationMetadata>
        updateWorkflowOperationSettings() {
      return getStubSettingsBuilder().updateWorkflowOperationSettings();
    }

    @Override
    public WorkflowsSettings build() throws IOException {
      return new WorkflowsSettings(this);
    }
  }
}
