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
package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.ProjectClient.GetXpnResourcesProjectsPagedResponse;
import static com.google.cloud.compute.v1.ProjectClient.ListXpnHostsProjectsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.ProjectStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link ProjectClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://www.googleapis.com/compute/v1/projects/) and default
 *       port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of disableXpnHostProject to 30 seconds:
 *
 * <pre>
 * <code>
 * ProjectSettings.Builder projectSettingsBuilder =
 *     ProjectSettings.newBuilder();
 * projectSettingsBuilder.disableXpnHostProjectSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * ProjectSettings projectSettings = projectSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ProjectSettings extends ClientSettings<ProjectSettings> {
  /** Returns the object with the settings used for calls to disableXpnHostProject. */
  public UnaryCallSettings<DisableXpnHostProjectHttpRequest, Operation>
      disableXpnHostProjectSettings() {
    return ((ProjectStubSettings) getStubSettings()).disableXpnHostProjectSettings();
  }

  /** Returns the object with the settings used for calls to disableXpnResourceProject. */
  public UnaryCallSettings<DisableXpnResourceProjectHttpRequest, Operation>
      disableXpnResourceProjectSettings() {
    return ((ProjectStubSettings) getStubSettings()).disableXpnResourceProjectSettings();
  }

  /** Returns the object with the settings used for calls to enableXpnHostProject. */
  public UnaryCallSettings<EnableXpnHostProjectHttpRequest, Operation>
      enableXpnHostProjectSettings() {
    return ((ProjectStubSettings) getStubSettings()).enableXpnHostProjectSettings();
  }

  /** Returns the object with the settings used for calls to enableXpnResourceProject. */
  public UnaryCallSettings<EnableXpnResourceProjectHttpRequest, Operation>
      enableXpnResourceProjectSettings() {
    return ((ProjectStubSettings) getStubSettings()).enableXpnResourceProjectSettings();
  }

  /** Returns the object with the settings used for calls to getProject. */
  public UnaryCallSettings<GetProjectHttpRequest, Project> getProjectSettings() {
    return ((ProjectStubSettings) getStubSettings()).getProjectSettings();
  }

  /** Returns the object with the settings used for calls to getXpnHostProject. */
  public UnaryCallSettings<GetXpnHostProjectHttpRequest, Project> getXpnHostProjectSettings() {
    return ((ProjectStubSettings) getStubSettings()).getXpnHostProjectSettings();
  }

  /** Returns the object with the settings used for calls to getXpnResourcesProjects. */
  public PagedCallSettings<
          GetXpnResourcesProjectsHttpRequest, ProjectsGetXpnResources,
          GetXpnResourcesProjectsPagedResponse>
      getXpnResourcesProjectsSettings() {
    return ((ProjectStubSettings) getStubSettings()).getXpnResourcesProjectsSettings();
  }

  /** Returns the object with the settings used for calls to listXpnHostsProjects. */
  public PagedCallSettings<
          ListXpnHostsProjectsHttpRequest, XpnHostList, ListXpnHostsProjectsPagedResponse>
      listXpnHostsProjectsSettings() {
    return ((ProjectStubSettings) getStubSettings()).listXpnHostsProjectsSettings();
  }

  /** Returns the object with the settings used for calls to moveDiskProject. */
  public UnaryCallSettings<MoveDiskProjectHttpRequest, Operation> moveDiskProjectSettings() {
    return ((ProjectStubSettings) getStubSettings()).moveDiskProjectSettings();
  }

  /** Returns the object with the settings used for calls to moveInstanceProject. */
  public UnaryCallSettings<MoveInstanceProjectHttpRequest, Operation>
      moveInstanceProjectSettings() {
    return ((ProjectStubSettings) getStubSettings()).moveInstanceProjectSettings();
  }

  /** Returns the object with the settings used for calls to setCommonInstanceMetadataProject. */
  public UnaryCallSettings<SetCommonInstanceMetadataProjectHttpRequest, Operation>
      setCommonInstanceMetadataProjectSettings() {
    return ((ProjectStubSettings) getStubSettings()).setCommonInstanceMetadataProjectSettings();
  }

  /** Returns the object with the settings used for calls to setUsageExportBucketProject. */
  public UnaryCallSettings<SetUsageExportBucketProjectHttpRequest, Operation>
      setUsageExportBucketProjectSettings() {
    return ((ProjectStubSettings) getStubSettings()).setUsageExportBucketProjectSettings();
  }

  public static final ProjectSettings create(ProjectStubSettings stub) throws IOException {
    return new ProjectSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ProjectStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ProjectStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return ProjectStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ProjectStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ProjectStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ProjectStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ProjectStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ProjectStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ProjectSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ProjectSettings. */
  public static class Builder extends ClientSettings.Builder<ProjectSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(ProjectStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(ProjectStubSettings.newBuilder());
    }

    protected Builder(ProjectSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ProjectStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public ProjectStubSettings.Builder getStubSettingsBuilder() {
      return ((ProjectStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
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

    /** Returns the builder for the settings used for calls to disableXpnHostProject. */
    public UnaryCallSettings.Builder<DisableXpnHostProjectHttpRequest, Operation>
        disableXpnHostProjectSettings() {
      return getStubSettingsBuilder().disableXpnHostProjectSettings();
    }

    /** Returns the builder for the settings used for calls to disableXpnResourceProject. */
    public UnaryCallSettings.Builder<DisableXpnResourceProjectHttpRequest, Operation>
        disableXpnResourceProjectSettings() {
      return getStubSettingsBuilder().disableXpnResourceProjectSettings();
    }

    /** Returns the builder for the settings used for calls to enableXpnHostProject. */
    public UnaryCallSettings.Builder<EnableXpnHostProjectHttpRequest, Operation>
        enableXpnHostProjectSettings() {
      return getStubSettingsBuilder().enableXpnHostProjectSettings();
    }

    /** Returns the builder for the settings used for calls to enableXpnResourceProject. */
    public UnaryCallSettings.Builder<EnableXpnResourceProjectHttpRequest, Operation>
        enableXpnResourceProjectSettings() {
      return getStubSettingsBuilder().enableXpnResourceProjectSettings();
    }

    /** Returns the builder for the settings used for calls to getProject. */
    public UnaryCallSettings.Builder<GetProjectHttpRequest, Project> getProjectSettings() {
      return getStubSettingsBuilder().getProjectSettings();
    }

    /** Returns the builder for the settings used for calls to getXpnHostProject. */
    public UnaryCallSettings.Builder<GetXpnHostProjectHttpRequest, Project>
        getXpnHostProjectSettings() {
      return getStubSettingsBuilder().getXpnHostProjectSettings();
    }

    /** Returns the builder for the settings used for calls to getXpnResourcesProjects. */
    public PagedCallSettings.Builder<
            GetXpnResourcesProjectsHttpRequest, ProjectsGetXpnResources,
            GetXpnResourcesProjectsPagedResponse>
        getXpnResourcesProjectsSettings() {
      return getStubSettingsBuilder().getXpnResourcesProjectsSettings();
    }

    /** Returns the builder for the settings used for calls to listXpnHostsProjects. */
    public PagedCallSettings.Builder<
            ListXpnHostsProjectsHttpRequest, XpnHostList, ListXpnHostsProjectsPagedResponse>
        listXpnHostsProjectsSettings() {
      return getStubSettingsBuilder().listXpnHostsProjectsSettings();
    }

    /** Returns the builder for the settings used for calls to moveDiskProject. */
    public UnaryCallSettings.Builder<MoveDiskProjectHttpRequest, Operation>
        moveDiskProjectSettings() {
      return getStubSettingsBuilder().moveDiskProjectSettings();
    }

    /** Returns the builder for the settings used for calls to moveInstanceProject. */
    public UnaryCallSettings.Builder<MoveInstanceProjectHttpRequest, Operation>
        moveInstanceProjectSettings() {
      return getStubSettingsBuilder().moveInstanceProjectSettings();
    }

    /** Returns the builder for the settings used for calls to setCommonInstanceMetadataProject. */
    public UnaryCallSettings.Builder<SetCommonInstanceMetadataProjectHttpRequest, Operation>
        setCommonInstanceMetadataProjectSettings() {
      return getStubSettingsBuilder().setCommonInstanceMetadataProjectSettings();
    }

    /** Returns the builder for the settings used for calls to setUsageExportBucketProject. */
    public UnaryCallSettings.Builder<SetUsageExportBucketProjectHttpRequest, Operation>
        setUsageExportBucketProjectSettings() {
      return getStubSettingsBuilder().setUsageExportBucketProjectSettings();
    }

    @Override
    public ProjectSettings build() throws IOException {
      return new ProjectSettings(this);
    }
  }
}
