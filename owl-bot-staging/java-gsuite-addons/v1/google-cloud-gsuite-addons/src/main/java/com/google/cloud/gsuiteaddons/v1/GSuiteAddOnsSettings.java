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

package com.google.cloud.gsuiteaddons.v1;

import static com.google.cloud.gsuiteaddons.v1.GSuiteAddOnsClient.ListDeploymentsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.gsuiteaddons.v1.stub.GSuiteAddOnsStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link GSuiteAddOnsClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (gsuiteaddons.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getAuthorization to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GSuiteAddOnsSettings.Builder gSuiteAddOnsSettingsBuilder = GSuiteAddOnsSettings.newBuilder();
 * gSuiteAddOnsSettingsBuilder
 *     .getAuthorizationSettings()
 *     .setRetrySettings(
 *         gSuiteAddOnsSettingsBuilder
 *             .getAuthorizationSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * GSuiteAddOnsSettings gSuiteAddOnsSettings = gSuiteAddOnsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class GSuiteAddOnsSettings extends ClientSettings<GSuiteAddOnsSettings> {

  /** Returns the object with the settings used for calls to getAuthorization. */
  public UnaryCallSettings<GetAuthorizationRequest, Authorization> getAuthorizationSettings() {
    return ((GSuiteAddOnsStubSettings) getStubSettings()).getAuthorizationSettings();
  }

  /** Returns the object with the settings used for calls to createDeployment. */
  public UnaryCallSettings<CreateDeploymentRequest, Deployment> createDeploymentSettings() {
    return ((GSuiteAddOnsStubSettings) getStubSettings()).createDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to replaceDeployment. */
  public UnaryCallSettings<ReplaceDeploymentRequest, Deployment> replaceDeploymentSettings() {
    return ((GSuiteAddOnsStubSettings) getStubSettings()).replaceDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to getDeployment. */
  public UnaryCallSettings<GetDeploymentRequest, Deployment> getDeploymentSettings() {
    return ((GSuiteAddOnsStubSettings) getStubSettings()).getDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to listDeployments. */
  public PagedCallSettings<
          ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
      listDeploymentsSettings() {
    return ((GSuiteAddOnsStubSettings) getStubSettings()).listDeploymentsSettings();
  }

  /** Returns the object with the settings used for calls to deleteDeployment. */
  public UnaryCallSettings<DeleteDeploymentRequest, Empty> deleteDeploymentSettings() {
    return ((GSuiteAddOnsStubSettings) getStubSettings()).deleteDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to installDeployment. */
  public UnaryCallSettings<InstallDeploymentRequest, Empty> installDeploymentSettings() {
    return ((GSuiteAddOnsStubSettings) getStubSettings()).installDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to uninstallDeployment. */
  public UnaryCallSettings<UninstallDeploymentRequest, Empty> uninstallDeploymentSettings() {
    return ((GSuiteAddOnsStubSettings) getStubSettings()).uninstallDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to getInstallStatus. */
  public UnaryCallSettings<GetInstallStatusRequest, InstallStatus> getInstallStatusSettings() {
    return ((GSuiteAddOnsStubSettings) getStubSettings()).getInstallStatusSettings();
  }

  public static final GSuiteAddOnsSettings create(GSuiteAddOnsStubSettings stub)
      throws IOException {
    return new GSuiteAddOnsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return GSuiteAddOnsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return GSuiteAddOnsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return GSuiteAddOnsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GSuiteAddOnsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return GSuiteAddOnsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return GSuiteAddOnsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return GSuiteAddOnsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GSuiteAddOnsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected GSuiteAddOnsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for GSuiteAddOnsSettings. */
  public static class Builder extends ClientSettings.Builder<GSuiteAddOnsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(GSuiteAddOnsStubSettings.newBuilder(clientContext));
    }

    protected Builder(GSuiteAddOnsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(GSuiteAddOnsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(GSuiteAddOnsStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(GSuiteAddOnsStubSettings.newHttpJsonBuilder());
    }

    public GSuiteAddOnsStubSettings.Builder getStubSettingsBuilder() {
      return ((GSuiteAddOnsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getAuthorization. */
    public UnaryCallSettings.Builder<GetAuthorizationRequest, Authorization>
        getAuthorizationSettings() {
      return getStubSettingsBuilder().getAuthorizationSettings();
    }

    /** Returns the builder for the settings used for calls to createDeployment. */
    public UnaryCallSettings.Builder<CreateDeploymentRequest, Deployment>
        createDeploymentSettings() {
      return getStubSettingsBuilder().createDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to replaceDeployment. */
    public UnaryCallSettings.Builder<ReplaceDeploymentRequest, Deployment>
        replaceDeploymentSettings() {
      return getStubSettingsBuilder().replaceDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to getDeployment. */
    public UnaryCallSettings.Builder<GetDeploymentRequest, Deployment> getDeploymentSettings() {
      return getStubSettingsBuilder().getDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to listDeployments. */
    public PagedCallSettings.Builder<
            ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
        listDeploymentsSettings() {
      return getStubSettingsBuilder().listDeploymentsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDeployment. */
    public UnaryCallSettings.Builder<DeleteDeploymentRequest, Empty> deleteDeploymentSettings() {
      return getStubSettingsBuilder().deleteDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to installDeployment. */
    public UnaryCallSettings.Builder<InstallDeploymentRequest, Empty> installDeploymentSettings() {
      return getStubSettingsBuilder().installDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to uninstallDeployment. */
    public UnaryCallSettings.Builder<UninstallDeploymentRequest, Empty>
        uninstallDeploymentSettings() {
      return getStubSettingsBuilder().uninstallDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to getInstallStatus. */
    public UnaryCallSettings.Builder<GetInstallStatusRequest, InstallStatus>
        getInstallStatusSettings() {
      return getStubSettingsBuilder().getInstallStatusSettings();
    }

    @Override
    public GSuiteAddOnsSettings build() throws IOException {
      return new GSuiteAddOnsSettings(this);
    }
  }
}
