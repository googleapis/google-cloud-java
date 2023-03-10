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

package com.google.appengine.v1;

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
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.appengine.v1.stub.ApplicationsStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ApplicationsClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (appengine.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getApplication to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ApplicationsSettings.Builder applicationsSettingsBuilder = ApplicationsSettings.newBuilder();
 * applicationsSettingsBuilder
 *     .getApplicationSettings()
 *     .setRetrySettings(
 *         applicationsSettingsBuilder
 *             .getApplicationSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ApplicationsSettings applicationsSettings = applicationsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ApplicationsSettings extends ClientSettings<ApplicationsSettings> {

  /** Returns the object with the settings used for calls to getApplication. */
  public UnaryCallSettings<GetApplicationRequest, Application> getApplicationSettings() {
    return ((ApplicationsStubSettings) getStubSettings()).getApplicationSettings();
  }

  /** Returns the object with the settings used for calls to createApplication. */
  public UnaryCallSettings<CreateApplicationRequest, Operation> createApplicationSettings() {
    return ((ApplicationsStubSettings) getStubSettings()).createApplicationSettings();
  }

  /** Returns the object with the settings used for calls to createApplication. */
  public OperationCallSettings<CreateApplicationRequest, Application, OperationMetadataV1>
      createApplicationOperationSettings() {
    return ((ApplicationsStubSettings) getStubSettings()).createApplicationOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateApplication. */
  public UnaryCallSettings<UpdateApplicationRequest, Operation> updateApplicationSettings() {
    return ((ApplicationsStubSettings) getStubSettings()).updateApplicationSettings();
  }

  /** Returns the object with the settings used for calls to updateApplication. */
  public OperationCallSettings<UpdateApplicationRequest, Application, OperationMetadataV1>
      updateApplicationOperationSettings() {
    return ((ApplicationsStubSettings) getStubSettings()).updateApplicationOperationSettings();
  }

  /** Returns the object with the settings used for calls to repairApplication. */
  public UnaryCallSettings<RepairApplicationRequest, Operation> repairApplicationSettings() {
    return ((ApplicationsStubSettings) getStubSettings()).repairApplicationSettings();
  }

  /** Returns the object with the settings used for calls to repairApplication. */
  public OperationCallSettings<RepairApplicationRequest, Application, OperationMetadataV1>
      repairApplicationOperationSettings() {
    return ((ApplicationsStubSettings) getStubSettings()).repairApplicationOperationSettings();
  }

  public static final ApplicationsSettings create(ApplicationsStubSettings stub)
      throws IOException {
    return new ApplicationsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ApplicationsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ApplicationsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ApplicationsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ApplicationsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ApplicationsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ApplicationsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ApplicationsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApplicationsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ApplicationsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ApplicationsSettings. */
  public static class Builder extends ClientSettings.Builder<ApplicationsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ApplicationsStubSettings.newBuilder(clientContext));
    }

    protected Builder(ApplicationsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ApplicationsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ApplicationsStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(ApplicationsStubSettings.newHttpJsonBuilder());
    }

    public ApplicationsStubSettings.Builder getStubSettingsBuilder() {
      return ((ApplicationsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getApplication. */
    public UnaryCallSettings.Builder<GetApplicationRequest, Application> getApplicationSettings() {
      return getStubSettingsBuilder().getApplicationSettings();
    }

    /** Returns the builder for the settings used for calls to createApplication. */
    public UnaryCallSettings.Builder<CreateApplicationRequest, Operation>
        createApplicationSettings() {
      return getStubSettingsBuilder().createApplicationSettings();
    }

    /** Returns the builder for the settings used for calls to createApplication. */
    public OperationCallSettings.Builder<CreateApplicationRequest, Application, OperationMetadataV1>
        createApplicationOperationSettings() {
      return getStubSettingsBuilder().createApplicationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateApplication. */
    public UnaryCallSettings.Builder<UpdateApplicationRequest, Operation>
        updateApplicationSettings() {
      return getStubSettingsBuilder().updateApplicationSettings();
    }

    /** Returns the builder for the settings used for calls to updateApplication. */
    public OperationCallSettings.Builder<UpdateApplicationRequest, Application, OperationMetadataV1>
        updateApplicationOperationSettings() {
      return getStubSettingsBuilder().updateApplicationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to repairApplication. */
    public UnaryCallSettings.Builder<RepairApplicationRequest, Operation>
        repairApplicationSettings() {
      return getStubSettingsBuilder().repairApplicationSettings();
    }

    /** Returns the builder for the settings used for calls to repairApplication. */
    public OperationCallSettings.Builder<RepairApplicationRequest, Application, OperationMetadataV1>
        repairApplicationOperationSettings() {
      return getStubSettingsBuilder().repairApplicationOperationSettings();
    }

    @Override
    public ApplicationsSettings build() throws IOException {
      return new ApplicationsSettings(this);
    }
  }
}
