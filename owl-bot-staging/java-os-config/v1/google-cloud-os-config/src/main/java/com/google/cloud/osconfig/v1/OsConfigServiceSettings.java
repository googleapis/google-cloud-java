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

package com.google.cloud.osconfig.v1;

import static com.google.cloud.osconfig.v1.OsConfigServiceClient.ListPatchDeploymentsPagedResponse;
import static com.google.cloud.osconfig.v1.OsConfigServiceClient.ListPatchJobInstanceDetailsPagedResponse;
import static com.google.cloud.osconfig.v1.OsConfigServiceClient.ListPatchJobsPagedResponse;

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
import com.google.cloud.osconfig.v1.stub.OsConfigServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link OsConfigServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (osconfig.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of executePatchJob to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OsConfigServiceSettings.Builder osConfigServiceSettingsBuilder =
 *     OsConfigServiceSettings.newBuilder();
 * osConfigServiceSettingsBuilder
 *     .executePatchJobSettings()
 *     .setRetrySettings(
 *         osConfigServiceSettingsBuilder.executePatchJobSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * OsConfigServiceSettings osConfigServiceSettings = osConfigServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class OsConfigServiceSettings extends ClientSettings<OsConfigServiceSettings> {

  /** Returns the object with the settings used for calls to executePatchJob. */
  public UnaryCallSettings<PatchJobs.ExecutePatchJobRequest, PatchJobs.PatchJob>
      executePatchJobSettings() {
    return ((OsConfigServiceStubSettings) getStubSettings()).executePatchJobSettings();
  }

  /** Returns the object with the settings used for calls to getPatchJob. */
  public UnaryCallSettings<PatchJobs.GetPatchJobRequest, PatchJobs.PatchJob> getPatchJobSettings() {
    return ((OsConfigServiceStubSettings) getStubSettings()).getPatchJobSettings();
  }

  /** Returns the object with the settings used for calls to cancelPatchJob. */
  public UnaryCallSettings<PatchJobs.CancelPatchJobRequest, PatchJobs.PatchJob>
      cancelPatchJobSettings() {
    return ((OsConfigServiceStubSettings) getStubSettings()).cancelPatchJobSettings();
  }

  /** Returns the object with the settings used for calls to listPatchJobs. */
  public PagedCallSettings<
          PatchJobs.ListPatchJobsRequest,
          PatchJobs.ListPatchJobsResponse,
          ListPatchJobsPagedResponse>
      listPatchJobsSettings() {
    return ((OsConfigServiceStubSettings) getStubSettings()).listPatchJobsSettings();
  }

  /** Returns the object with the settings used for calls to listPatchJobInstanceDetails. */
  public PagedCallSettings<
          PatchJobs.ListPatchJobInstanceDetailsRequest,
          PatchJobs.ListPatchJobInstanceDetailsResponse,
          ListPatchJobInstanceDetailsPagedResponse>
      listPatchJobInstanceDetailsSettings() {
    return ((OsConfigServiceStubSettings) getStubSettings()).listPatchJobInstanceDetailsSettings();
  }

  /** Returns the object with the settings used for calls to createPatchDeployment. */
  public UnaryCallSettings<
          PatchDeployments.CreatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      createPatchDeploymentSettings() {
    return ((OsConfigServiceStubSettings) getStubSettings()).createPatchDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to getPatchDeployment. */
  public UnaryCallSettings<
          PatchDeployments.GetPatchDeploymentRequest, PatchDeployments.PatchDeployment>
      getPatchDeploymentSettings() {
    return ((OsConfigServiceStubSettings) getStubSettings()).getPatchDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to listPatchDeployments. */
  public PagedCallSettings<
          PatchDeployments.ListPatchDeploymentsRequest,
          PatchDeployments.ListPatchDeploymentsResponse,
          ListPatchDeploymentsPagedResponse>
      listPatchDeploymentsSettings() {
    return ((OsConfigServiceStubSettings) getStubSettings()).listPatchDeploymentsSettings();
  }

  /** Returns the object with the settings used for calls to deletePatchDeployment. */
  public UnaryCallSettings<PatchDeployments.DeletePatchDeploymentRequest, Empty>
      deletePatchDeploymentSettings() {
    return ((OsConfigServiceStubSettings) getStubSettings()).deletePatchDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to updatePatchDeployment. */
  public UnaryCallSettings<
          PatchDeployments.UpdatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      updatePatchDeploymentSettings() {
    return ((OsConfigServiceStubSettings) getStubSettings()).updatePatchDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to pausePatchDeployment. */
  public UnaryCallSettings<
          PatchDeployments.PausePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      pausePatchDeploymentSettings() {
    return ((OsConfigServiceStubSettings) getStubSettings()).pausePatchDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to resumePatchDeployment. */
  public UnaryCallSettings<
          PatchDeployments.ResumePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      resumePatchDeploymentSettings() {
    return ((OsConfigServiceStubSettings) getStubSettings()).resumePatchDeploymentSettings();
  }

  public static final OsConfigServiceSettings create(OsConfigServiceStubSettings stub)
      throws IOException {
    return new OsConfigServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return OsConfigServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return OsConfigServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return OsConfigServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return OsConfigServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return OsConfigServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return OsConfigServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return OsConfigServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return OsConfigServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected OsConfigServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for OsConfigServiceSettings. */
  public static class Builder extends ClientSettings.Builder<OsConfigServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(OsConfigServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(OsConfigServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(OsConfigServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(OsConfigServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(OsConfigServiceStubSettings.newHttpJsonBuilder());
    }

    public OsConfigServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((OsConfigServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to executePatchJob. */
    public UnaryCallSettings.Builder<PatchJobs.ExecutePatchJobRequest, PatchJobs.PatchJob>
        executePatchJobSettings() {
      return getStubSettingsBuilder().executePatchJobSettings();
    }

    /** Returns the builder for the settings used for calls to getPatchJob. */
    public UnaryCallSettings.Builder<PatchJobs.GetPatchJobRequest, PatchJobs.PatchJob>
        getPatchJobSettings() {
      return getStubSettingsBuilder().getPatchJobSettings();
    }

    /** Returns the builder for the settings used for calls to cancelPatchJob. */
    public UnaryCallSettings.Builder<PatchJobs.CancelPatchJobRequest, PatchJobs.PatchJob>
        cancelPatchJobSettings() {
      return getStubSettingsBuilder().cancelPatchJobSettings();
    }

    /** Returns the builder for the settings used for calls to listPatchJobs. */
    public PagedCallSettings.Builder<
            PatchJobs.ListPatchJobsRequest,
            PatchJobs.ListPatchJobsResponse,
            ListPatchJobsPagedResponse>
        listPatchJobsSettings() {
      return getStubSettingsBuilder().listPatchJobsSettings();
    }

    /** Returns the builder for the settings used for calls to listPatchJobInstanceDetails. */
    public PagedCallSettings.Builder<
            PatchJobs.ListPatchJobInstanceDetailsRequest,
            PatchJobs.ListPatchJobInstanceDetailsResponse,
            ListPatchJobInstanceDetailsPagedResponse>
        listPatchJobInstanceDetailsSettings() {
      return getStubSettingsBuilder().listPatchJobInstanceDetailsSettings();
    }

    /** Returns the builder for the settings used for calls to createPatchDeployment. */
    public UnaryCallSettings.Builder<
            PatchDeployments.CreatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
        createPatchDeploymentSettings() {
      return getStubSettingsBuilder().createPatchDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to getPatchDeployment. */
    public UnaryCallSettings.Builder<
            PatchDeployments.GetPatchDeploymentRequest, PatchDeployments.PatchDeployment>
        getPatchDeploymentSettings() {
      return getStubSettingsBuilder().getPatchDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to listPatchDeployments. */
    public PagedCallSettings.Builder<
            PatchDeployments.ListPatchDeploymentsRequest,
            PatchDeployments.ListPatchDeploymentsResponse,
            ListPatchDeploymentsPagedResponse>
        listPatchDeploymentsSettings() {
      return getStubSettingsBuilder().listPatchDeploymentsSettings();
    }

    /** Returns the builder for the settings used for calls to deletePatchDeployment. */
    public UnaryCallSettings.Builder<PatchDeployments.DeletePatchDeploymentRequest, Empty>
        deletePatchDeploymentSettings() {
      return getStubSettingsBuilder().deletePatchDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to updatePatchDeployment. */
    public UnaryCallSettings.Builder<
            PatchDeployments.UpdatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
        updatePatchDeploymentSettings() {
      return getStubSettingsBuilder().updatePatchDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to pausePatchDeployment. */
    public UnaryCallSettings.Builder<
            PatchDeployments.PausePatchDeploymentRequest, PatchDeployments.PatchDeployment>
        pausePatchDeploymentSettings() {
      return getStubSettingsBuilder().pausePatchDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to resumePatchDeployment. */
    public UnaryCallSettings.Builder<
            PatchDeployments.ResumePatchDeploymentRequest, PatchDeployments.PatchDeployment>
        resumePatchDeploymentSettings() {
      return getStubSettingsBuilder().resumePatchDeploymentSettings();
    }

    @Override
    public OsConfigServiceSettings build() throws IOException {
      return new OsConfigServiceSettings(this);
    }
  }
}
