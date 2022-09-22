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

package com.google.cloud.resourcemanager.v3;

import static com.google.cloud.resourcemanager.v3.ProjectsClient.ListProjectsPagedResponse;
import static com.google.cloud.resourcemanager.v3.ProjectsClient.SearchProjectsPagedResponse;

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
import com.google.cloud.resourcemanager.v3.stub.ProjectsStubSettings;
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
 * Settings class to configure an instance of {@link ProjectsClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudresourcemanager.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getProject to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ProjectsSettings.Builder projectsSettingsBuilder = ProjectsSettings.newBuilder();
 * projectsSettingsBuilder
 *     .getProjectSettings()
 *     .setRetrySettings(
 *         projectsSettingsBuilder.getProjectSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ProjectsSettings projectsSettings = projectsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ProjectsSettings extends ClientSettings<ProjectsSettings> {

  /** Returns the object with the settings used for calls to getProject. */
  public UnaryCallSettings<GetProjectRequest, Project> getProjectSettings() {
    return ((ProjectsStubSettings) getStubSettings()).getProjectSettings();
  }

  /** Returns the object with the settings used for calls to listProjects. */
  public PagedCallSettings<ListProjectsRequest, ListProjectsResponse, ListProjectsPagedResponse>
      listProjectsSettings() {
    return ((ProjectsStubSettings) getStubSettings()).listProjectsSettings();
  }

  /** Returns the object with the settings used for calls to searchProjects. */
  public PagedCallSettings<
          SearchProjectsRequest, SearchProjectsResponse, SearchProjectsPagedResponse>
      searchProjectsSettings() {
    return ((ProjectsStubSettings) getStubSettings()).searchProjectsSettings();
  }

  /** Returns the object with the settings used for calls to createProject. */
  public UnaryCallSettings<CreateProjectRequest, Operation> createProjectSettings() {
    return ((ProjectsStubSettings) getStubSettings()).createProjectSettings();
  }

  /** Returns the object with the settings used for calls to createProject. */
  public OperationCallSettings<CreateProjectRequest, Project, CreateProjectMetadata>
      createProjectOperationSettings() {
    return ((ProjectsStubSettings) getStubSettings()).createProjectOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateProject. */
  public UnaryCallSettings<UpdateProjectRequest, Operation> updateProjectSettings() {
    return ((ProjectsStubSettings) getStubSettings()).updateProjectSettings();
  }

  /** Returns the object with the settings used for calls to updateProject. */
  public OperationCallSettings<UpdateProjectRequest, Project, UpdateProjectMetadata>
      updateProjectOperationSettings() {
    return ((ProjectsStubSettings) getStubSettings()).updateProjectOperationSettings();
  }

  /** Returns the object with the settings used for calls to moveProject. */
  public UnaryCallSettings<MoveProjectRequest, Operation> moveProjectSettings() {
    return ((ProjectsStubSettings) getStubSettings()).moveProjectSettings();
  }

  /** Returns the object with the settings used for calls to moveProject. */
  public OperationCallSettings<MoveProjectRequest, Project, MoveProjectMetadata>
      moveProjectOperationSettings() {
    return ((ProjectsStubSettings) getStubSettings()).moveProjectOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteProject. */
  public UnaryCallSettings<DeleteProjectRequest, Operation> deleteProjectSettings() {
    return ((ProjectsStubSettings) getStubSettings()).deleteProjectSettings();
  }

  /** Returns the object with the settings used for calls to deleteProject. */
  public OperationCallSettings<DeleteProjectRequest, Project, DeleteProjectMetadata>
      deleteProjectOperationSettings() {
    return ((ProjectsStubSettings) getStubSettings()).deleteProjectOperationSettings();
  }

  /** Returns the object with the settings used for calls to undeleteProject. */
  public UnaryCallSettings<UndeleteProjectRequest, Operation> undeleteProjectSettings() {
    return ((ProjectsStubSettings) getStubSettings()).undeleteProjectSettings();
  }

  /** Returns the object with the settings used for calls to undeleteProject. */
  public OperationCallSettings<UndeleteProjectRequest, Project, UndeleteProjectMetadata>
      undeleteProjectOperationSettings() {
    return ((ProjectsStubSettings) getStubSettings()).undeleteProjectOperationSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((ProjectsStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((ProjectsStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((ProjectsStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final ProjectsSettings create(ProjectsStubSettings stub) throws IOException {
    return new ProjectsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ProjectsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ProjectsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ProjectsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ProjectsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ProjectsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ProjectsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ProjectsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ProjectsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ProjectsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ProjectsSettings. */
  public static class Builder extends ClientSettings.Builder<ProjectsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ProjectsStubSettings.newBuilder(clientContext));
    }

    protected Builder(ProjectsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ProjectsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ProjectsStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(ProjectsStubSettings.newHttpJsonBuilder());
    }

    public ProjectsStubSettings.Builder getStubSettingsBuilder() {
      return ((ProjectsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getProject. */
    public UnaryCallSettings.Builder<GetProjectRequest, Project> getProjectSettings() {
      return getStubSettingsBuilder().getProjectSettings();
    }

    /** Returns the builder for the settings used for calls to listProjects. */
    public PagedCallSettings.Builder<
            ListProjectsRequest, ListProjectsResponse, ListProjectsPagedResponse>
        listProjectsSettings() {
      return getStubSettingsBuilder().listProjectsSettings();
    }

    /** Returns the builder for the settings used for calls to searchProjects. */
    public PagedCallSettings.Builder<
            SearchProjectsRequest, SearchProjectsResponse, SearchProjectsPagedResponse>
        searchProjectsSettings() {
      return getStubSettingsBuilder().searchProjectsSettings();
    }

    /** Returns the builder for the settings used for calls to createProject. */
    public UnaryCallSettings.Builder<CreateProjectRequest, Operation> createProjectSettings() {
      return getStubSettingsBuilder().createProjectSettings();
    }

    /** Returns the builder for the settings used for calls to createProject. */
    public OperationCallSettings.Builder<CreateProjectRequest, Project, CreateProjectMetadata>
        createProjectOperationSettings() {
      return getStubSettingsBuilder().createProjectOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateProject. */
    public UnaryCallSettings.Builder<UpdateProjectRequest, Operation> updateProjectSettings() {
      return getStubSettingsBuilder().updateProjectSettings();
    }

    /** Returns the builder for the settings used for calls to updateProject. */
    public OperationCallSettings.Builder<UpdateProjectRequest, Project, UpdateProjectMetadata>
        updateProjectOperationSettings() {
      return getStubSettingsBuilder().updateProjectOperationSettings();
    }

    /** Returns the builder for the settings used for calls to moveProject. */
    public UnaryCallSettings.Builder<MoveProjectRequest, Operation> moveProjectSettings() {
      return getStubSettingsBuilder().moveProjectSettings();
    }

    /** Returns the builder for the settings used for calls to moveProject. */
    public OperationCallSettings.Builder<MoveProjectRequest, Project, MoveProjectMetadata>
        moveProjectOperationSettings() {
      return getStubSettingsBuilder().moveProjectOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteProject. */
    public UnaryCallSettings.Builder<DeleteProjectRequest, Operation> deleteProjectSettings() {
      return getStubSettingsBuilder().deleteProjectSettings();
    }

    /** Returns the builder for the settings used for calls to deleteProject. */
    public OperationCallSettings.Builder<DeleteProjectRequest, Project, DeleteProjectMetadata>
        deleteProjectOperationSettings() {
      return getStubSettingsBuilder().deleteProjectOperationSettings();
    }

    /** Returns the builder for the settings used for calls to undeleteProject. */
    public UnaryCallSettings.Builder<UndeleteProjectRequest, Operation> undeleteProjectSettings() {
      return getStubSettingsBuilder().undeleteProjectSettings();
    }

    /** Returns the builder for the settings used for calls to undeleteProject. */
    public OperationCallSettings.Builder<UndeleteProjectRequest, Project, UndeleteProjectMetadata>
        undeleteProjectOperationSettings() {
      return getStubSettingsBuilder().undeleteProjectOperationSettings();
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
    public ProjectsSettings build() throws IOException {
      return new ProjectsSettings(this);
    }
  }
}
