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

package com.google.cloud.retail.v2alpha;

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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.retail.v2alpha.stub.ProjectServiceStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ProjectServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (retail.googleapis.com) and default port (443) are used.
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
 * ProjectServiceSettings.Builder projectServiceSettingsBuilder =
 *     ProjectServiceSettings.newBuilder();
 * projectServiceSettingsBuilder
 *     .getProjectSettings()
 *     .setRetrySettings(
 *         projectServiceSettingsBuilder
 *             .getProjectSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ProjectServiceSettings projectServiceSettings = projectServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ProjectServiceSettings extends ClientSettings<ProjectServiceSettings> {

  /** Returns the object with the settings used for calls to getProject. */
  public UnaryCallSettings<GetProjectRequest, Project> getProjectSettings() {
    return ((ProjectServiceStubSettings) getStubSettings()).getProjectSettings();
  }

  /** Returns the object with the settings used for calls to acceptTerms. */
  public UnaryCallSettings<AcceptTermsRequest, Project> acceptTermsSettings() {
    return ((ProjectServiceStubSettings) getStubSettings()).acceptTermsSettings();
  }

  /** Returns the object with the settings used for calls to enrollSolution. */
  public UnaryCallSettings<EnrollSolutionRequest, Operation> enrollSolutionSettings() {
    return ((ProjectServiceStubSettings) getStubSettings()).enrollSolutionSettings();
  }

  /** Returns the object with the settings used for calls to enrollSolution. */
  public OperationCallSettings<
          EnrollSolutionRequest, EnrollSolutionResponse, EnrollSolutionMetadata>
      enrollSolutionOperationSettings() {
    return ((ProjectServiceStubSettings) getStubSettings()).enrollSolutionOperationSettings();
  }

  /** Returns the object with the settings used for calls to listEnrolledSolutions. */
  public UnaryCallSettings<ListEnrolledSolutionsRequest, ListEnrolledSolutionsResponse>
      listEnrolledSolutionsSettings() {
    return ((ProjectServiceStubSettings) getStubSettings()).listEnrolledSolutionsSettings();
  }

  /** Returns the object with the settings used for calls to getLoggingConfig. */
  public UnaryCallSettings<GetLoggingConfigRequest, LoggingConfig> getLoggingConfigSettings() {
    return ((ProjectServiceStubSettings) getStubSettings()).getLoggingConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateLoggingConfig. */
  public UnaryCallSettings<UpdateLoggingConfigRequest, LoggingConfig>
      updateLoggingConfigSettings() {
    return ((ProjectServiceStubSettings) getStubSettings()).updateLoggingConfigSettings();
  }

  /** Returns the object with the settings used for calls to getAlertConfig. */
  public UnaryCallSettings<GetAlertConfigRequest, AlertConfig> getAlertConfigSettings() {
    return ((ProjectServiceStubSettings) getStubSettings()).getAlertConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateAlertConfig. */
  public UnaryCallSettings<UpdateAlertConfigRequest, AlertConfig> updateAlertConfigSettings() {
    return ((ProjectServiceStubSettings) getStubSettings()).updateAlertConfigSettings();
  }

  public static final ProjectServiceSettings create(ProjectServiceStubSettings stub)
      throws IOException {
    return new ProjectServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ProjectServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ProjectServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ProjectServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ProjectServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ProjectServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ProjectServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ProjectServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ProjectServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ProjectServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ProjectServiceSettings. */
  public static class Builder extends ClientSettings.Builder<ProjectServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ProjectServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ProjectServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ProjectServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ProjectServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(ProjectServiceStubSettings.newHttpJsonBuilder());
    }

    public ProjectServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ProjectServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to acceptTerms. */
    public UnaryCallSettings.Builder<AcceptTermsRequest, Project> acceptTermsSettings() {
      return getStubSettingsBuilder().acceptTermsSettings();
    }

    /** Returns the builder for the settings used for calls to enrollSolution. */
    public UnaryCallSettings.Builder<EnrollSolutionRequest, Operation> enrollSolutionSettings() {
      return getStubSettingsBuilder().enrollSolutionSettings();
    }

    /** Returns the builder for the settings used for calls to enrollSolution. */
    public OperationCallSettings.Builder<
            EnrollSolutionRequest, EnrollSolutionResponse, EnrollSolutionMetadata>
        enrollSolutionOperationSettings() {
      return getStubSettingsBuilder().enrollSolutionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listEnrolledSolutions. */
    public UnaryCallSettings.Builder<ListEnrolledSolutionsRequest, ListEnrolledSolutionsResponse>
        listEnrolledSolutionsSettings() {
      return getStubSettingsBuilder().listEnrolledSolutionsSettings();
    }

    /** Returns the builder for the settings used for calls to getLoggingConfig. */
    public UnaryCallSettings.Builder<GetLoggingConfigRequest, LoggingConfig>
        getLoggingConfigSettings() {
      return getStubSettingsBuilder().getLoggingConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateLoggingConfig. */
    public UnaryCallSettings.Builder<UpdateLoggingConfigRequest, LoggingConfig>
        updateLoggingConfigSettings() {
      return getStubSettingsBuilder().updateLoggingConfigSettings();
    }

    /** Returns the builder for the settings used for calls to getAlertConfig. */
    public UnaryCallSettings.Builder<GetAlertConfigRequest, AlertConfig> getAlertConfigSettings() {
      return getStubSettingsBuilder().getAlertConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateAlertConfig. */
    public UnaryCallSettings.Builder<UpdateAlertConfigRequest, AlertConfig>
        updateAlertConfigSettings() {
      return getStubSettingsBuilder().updateAlertConfigSettings();
    }

    @Override
    public ProjectServiceSettings build() throws IOException {
      return new ProjectServiceSettings(this);
    }
  }
}
