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

package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.ProjectsClient.GetXpnResourcesPagedResponse;
import static com.google.cloud.compute.v1.ProjectsClient.ListXpnHostsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.ProjectsStubSettings;
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
 *   <li>The default service address (compute.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of get to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ProjectsSettings.Builder projectsSettingsBuilder = ProjectsSettings.newBuilder();
 * projectsSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         projectsSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ProjectsSettings projectsSettings = projectsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ProjectsSettings extends ClientSettings<ProjectsSettings> {

  /** Returns the object with the settings used for calls to disableXpnHost. */
  public UnaryCallSettings<DisableXpnHostProjectRequest, Operation> disableXpnHostSettings() {
    return ((ProjectsStubSettings) getStubSettings()).disableXpnHostSettings();
  }

  /** Returns the object with the settings used for calls to disableXpnHost. */
  public OperationCallSettings<DisableXpnHostProjectRequest, Operation, Operation>
      disableXpnHostOperationSettings() {
    return ((ProjectsStubSettings) getStubSettings()).disableXpnHostOperationSettings();
  }

  /** Returns the object with the settings used for calls to disableXpnResource. */
  public UnaryCallSettings<DisableXpnResourceProjectRequest, Operation>
      disableXpnResourceSettings() {
    return ((ProjectsStubSettings) getStubSettings()).disableXpnResourceSettings();
  }

  /** Returns the object with the settings used for calls to disableXpnResource. */
  public OperationCallSettings<DisableXpnResourceProjectRequest, Operation, Operation>
      disableXpnResourceOperationSettings() {
    return ((ProjectsStubSettings) getStubSettings()).disableXpnResourceOperationSettings();
  }

  /** Returns the object with the settings used for calls to enableXpnHost. */
  public UnaryCallSettings<EnableXpnHostProjectRequest, Operation> enableXpnHostSettings() {
    return ((ProjectsStubSettings) getStubSettings()).enableXpnHostSettings();
  }

  /** Returns the object with the settings used for calls to enableXpnHost. */
  public OperationCallSettings<EnableXpnHostProjectRequest, Operation, Operation>
      enableXpnHostOperationSettings() {
    return ((ProjectsStubSettings) getStubSettings()).enableXpnHostOperationSettings();
  }

  /** Returns the object with the settings used for calls to enableXpnResource. */
  public UnaryCallSettings<EnableXpnResourceProjectRequest, Operation> enableXpnResourceSettings() {
    return ((ProjectsStubSettings) getStubSettings()).enableXpnResourceSettings();
  }

  /** Returns the object with the settings used for calls to enableXpnResource. */
  public OperationCallSettings<EnableXpnResourceProjectRequest, Operation, Operation>
      enableXpnResourceOperationSettings() {
    return ((ProjectsStubSettings) getStubSettings()).enableXpnResourceOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetProjectRequest, Project> getSettings() {
    return ((ProjectsStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to getXpnHost. */
  public UnaryCallSettings<GetXpnHostProjectRequest, Project> getXpnHostSettings() {
    return ((ProjectsStubSettings) getStubSettings()).getXpnHostSettings();
  }

  /** Returns the object with the settings used for calls to getXpnResources. */
  public PagedCallSettings<
          GetXpnResourcesProjectsRequest, ProjectsGetXpnResources, GetXpnResourcesPagedResponse>
      getXpnResourcesSettings() {
    return ((ProjectsStubSettings) getStubSettings()).getXpnResourcesSettings();
  }

  /** Returns the object with the settings used for calls to listXpnHosts. */
  public PagedCallSettings<ListXpnHostsProjectsRequest, XpnHostList, ListXpnHostsPagedResponse>
      listXpnHostsSettings() {
    return ((ProjectsStubSettings) getStubSettings()).listXpnHostsSettings();
  }

  /** Returns the object with the settings used for calls to moveDisk. */
  public UnaryCallSettings<MoveDiskProjectRequest, Operation> moveDiskSettings() {
    return ((ProjectsStubSettings) getStubSettings()).moveDiskSettings();
  }

  /** Returns the object with the settings used for calls to moveDisk. */
  public OperationCallSettings<MoveDiskProjectRequest, Operation, Operation>
      moveDiskOperationSettings() {
    return ((ProjectsStubSettings) getStubSettings()).moveDiskOperationSettings();
  }

  /** Returns the object with the settings used for calls to moveInstance. */
  public UnaryCallSettings<MoveInstanceProjectRequest, Operation> moveInstanceSettings() {
    return ((ProjectsStubSettings) getStubSettings()).moveInstanceSettings();
  }

  /** Returns the object with the settings used for calls to moveInstance. */
  public OperationCallSettings<MoveInstanceProjectRequest, Operation, Operation>
      moveInstanceOperationSettings() {
    return ((ProjectsStubSettings) getStubSettings()).moveInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to setCommonInstanceMetadata. */
  public UnaryCallSettings<SetCommonInstanceMetadataProjectRequest, Operation>
      setCommonInstanceMetadataSettings() {
    return ((ProjectsStubSettings) getStubSettings()).setCommonInstanceMetadataSettings();
  }

  /** Returns the object with the settings used for calls to setCommonInstanceMetadata. */
  public OperationCallSettings<SetCommonInstanceMetadataProjectRequest, Operation, Operation>
      setCommonInstanceMetadataOperationSettings() {
    return ((ProjectsStubSettings) getStubSettings()).setCommonInstanceMetadataOperationSettings();
  }

  /** Returns the object with the settings used for calls to setDefaultNetworkTier. */
  public UnaryCallSettings<SetDefaultNetworkTierProjectRequest, Operation>
      setDefaultNetworkTierSettings() {
    return ((ProjectsStubSettings) getStubSettings()).setDefaultNetworkTierSettings();
  }

  /** Returns the object with the settings used for calls to setDefaultNetworkTier. */
  public OperationCallSettings<SetDefaultNetworkTierProjectRequest, Operation, Operation>
      setDefaultNetworkTierOperationSettings() {
    return ((ProjectsStubSettings) getStubSettings()).setDefaultNetworkTierOperationSettings();
  }

  /** Returns the object with the settings used for calls to setUsageExportBucket. */
  public UnaryCallSettings<SetUsageExportBucketProjectRequest, Operation>
      setUsageExportBucketSettings() {
    return ((ProjectsStubSettings) getStubSettings()).setUsageExportBucketSettings();
  }

  /** Returns the object with the settings used for calls to setUsageExportBucket. */
  public OperationCallSettings<SetUsageExportBucketProjectRequest, Operation, Operation>
      setUsageExportBucketOperationSettings() {
    return ((ProjectsStubSettings) getStubSettings()).setUsageExportBucketOperationSettings();
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

  /** Returns a builder for the default ChannelProvider for this service. */
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

    /** Returns the builder for the settings used for calls to disableXpnHost. */
    public UnaryCallSettings.Builder<DisableXpnHostProjectRequest, Operation>
        disableXpnHostSettings() {
      return getStubSettingsBuilder().disableXpnHostSettings();
    }

    /** Returns the builder for the settings used for calls to disableXpnHost. */
    public OperationCallSettings.Builder<DisableXpnHostProjectRequest, Operation, Operation>
        disableXpnHostOperationSettings() {
      return getStubSettingsBuilder().disableXpnHostOperationSettings();
    }

    /** Returns the builder for the settings used for calls to disableXpnResource. */
    public UnaryCallSettings.Builder<DisableXpnResourceProjectRequest, Operation>
        disableXpnResourceSettings() {
      return getStubSettingsBuilder().disableXpnResourceSettings();
    }

    /** Returns the builder for the settings used for calls to disableXpnResource. */
    public OperationCallSettings.Builder<DisableXpnResourceProjectRequest, Operation, Operation>
        disableXpnResourceOperationSettings() {
      return getStubSettingsBuilder().disableXpnResourceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to enableXpnHost. */
    public UnaryCallSettings.Builder<EnableXpnHostProjectRequest, Operation>
        enableXpnHostSettings() {
      return getStubSettingsBuilder().enableXpnHostSettings();
    }

    /** Returns the builder for the settings used for calls to enableXpnHost. */
    public OperationCallSettings.Builder<EnableXpnHostProjectRequest, Operation, Operation>
        enableXpnHostOperationSettings() {
      return getStubSettingsBuilder().enableXpnHostOperationSettings();
    }

    /** Returns the builder for the settings used for calls to enableXpnResource. */
    public UnaryCallSettings.Builder<EnableXpnResourceProjectRequest, Operation>
        enableXpnResourceSettings() {
      return getStubSettingsBuilder().enableXpnResourceSettings();
    }

    /** Returns the builder for the settings used for calls to enableXpnResource. */
    public OperationCallSettings.Builder<EnableXpnResourceProjectRequest, Operation, Operation>
        enableXpnResourceOperationSettings() {
      return getStubSettingsBuilder().enableXpnResourceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetProjectRequest, Project> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to getXpnHost. */
    public UnaryCallSettings.Builder<GetXpnHostProjectRequest, Project> getXpnHostSettings() {
      return getStubSettingsBuilder().getXpnHostSettings();
    }

    /** Returns the builder for the settings used for calls to getXpnResources. */
    public PagedCallSettings.Builder<
            GetXpnResourcesProjectsRequest, ProjectsGetXpnResources, GetXpnResourcesPagedResponse>
        getXpnResourcesSettings() {
      return getStubSettingsBuilder().getXpnResourcesSettings();
    }

    /** Returns the builder for the settings used for calls to listXpnHosts. */
    public PagedCallSettings.Builder<
            ListXpnHostsProjectsRequest, XpnHostList, ListXpnHostsPagedResponse>
        listXpnHostsSettings() {
      return getStubSettingsBuilder().listXpnHostsSettings();
    }

    /** Returns the builder for the settings used for calls to moveDisk. */
    public UnaryCallSettings.Builder<MoveDiskProjectRequest, Operation> moveDiskSettings() {
      return getStubSettingsBuilder().moveDiskSettings();
    }

    /** Returns the builder for the settings used for calls to moveDisk. */
    public OperationCallSettings.Builder<MoveDiskProjectRequest, Operation, Operation>
        moveDiskOperationSettings() {
      return getStubSettingsBuilder().moveDiskOperationSettings();
    }

    /** Returns the builder for the settings used for calls to moveInstance. */
    public UnaryCallSettings.Builder<MoveInstanceProjectRequest, Operation> moveInstanceSettings() {
      return getStubSettingsBuilder().moveInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to moveInstance. */
    public OperationCallSettings.Builder<MoveInstanceProjectRequest, Operation, Operation>
        moveInstanceOperationSettings() {
      return getStubSettingsBuilder().moveInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setCommonInstanceMetadata. */
    public UnaryCallSettings.Builder<SetCommonInstanceMetadataProjectRequest, Operation>
        setCommonInstanceMetadataSettings() {
      return getStubSettingsBuilder().setCommonInstanceMetadataSettings();
    }

    /** Returns the builder for the settings used for calls to setCommonInstanceMetadata. */
    public OperationCallSettings.Builder<
            SetCommonInstanceMetadataProjectRequest, Operation, Operation>
        setCommonInstanceMetadataOperationSettings() {
      return getStubSettingsBuilder().setCommonInstanceMetadataOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setDefaultNetworkTier. */
    public UnaryCallSettings.Builder<SetDefaultNetworkTierProjectRequest, Operation>
        setDefaultNetworkTierSettings() {
      return getStubSettingsBuilder().setDefaultNetworkTierSettings();
    }

    /** Returns the builder for the settings used for calls to setDefaultNetworkTier. */
    public OperationCallSettings.Builder<SetDefaultNetworkTierProjectRequest, Operation, Operation>
        setDefaultNetworkTierOperationSettings() {
      return getStubSettingsBuilder().setDefaultNetworkTierOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setUsageExportBucket. */
    public UnaryCallSettings.Builder<SetUsageExportBucketProjectRequest, Operation>
        setUsageExportBucketSettings() {
      return getStubSettingsBuilder().setUsageExportBucketSettings();
    }

    /** Returns the builder for the settings used for calls to setUsageExportBucket. */
    public OperationCallSettings.Builder<SetUsageExportBucketProjectRequest, Operation, Operation>
        setUsageExportBucketOperationSettings() {
      return getStubSettingsBuilder().setUsageExportBucketOperationSettings();
    }

    @Override
    public ProjectsSettings build() throws IOException {
      return new ProjectsSettings(this);
    }
  }
}
