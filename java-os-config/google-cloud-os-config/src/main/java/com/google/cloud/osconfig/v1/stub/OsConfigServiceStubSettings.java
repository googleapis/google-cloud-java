/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.osconfig.v1.stub;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.osconfig.v1.PatchDeployments.CreatePatchDeploymentRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.DeletePatchDeploymentRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.GetPatchDeploymentRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.ListPatchDeploymentsRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.ListPatchDeploymentsResponse;
import com.google.cloud.osconfig.v1.PatchDeployments.PatchDeployment;
import com.google.cloud.osconfig.v1.PatchJobs.CancelPatchJobRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ExecutePatchJobRequest;
import com.google.cloud.osconfig.v1.PatchJobs.GetPatchJobRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobInstanceDetailsRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobInstanceDetailsResponse;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobsRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobsResponse;
import com.google.cloud.osconfig.v1.PatchJobs.PatchJob;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link OsConfigServiceStub}.
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
 * <pre>
 * <code>
 * OsConfigServiceStubSettings.Builder osConfigServiceSettingsBuilder =
 *     OsConfigServiceStubSettings.newBuilder();
 * osConfigServiceSettingsBuilder
 *     .executePatchJobSettings()
 *     .setRetrySettings(
 *         osConfigServiceSettingsBuilder.executePatchJobSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * OsConfigServiceStubSettings osConfigServiceSettings = osConfigServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class OsConfigServiceStubSettings extends StubSettings<OsConfigServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<ExecutePatchJobRequest, PatchJob> executePatchJobSettings;
  private final UnaryCallSettings<GetPatchJobRequest, PatchJob> getPatchJobSettings;
  private final UnaryCallSettings<CancelPatchJobRequest, PatchJob> cancelPatchJobSettings;
  private final UnaryCallSettings<ListPatchJobsRequest, ListPatchJobsResponse>
      listPatchJobsSettings;
  private final UnaryCallSettings<
          ListPatchJobInstanceDetailsRequest, ListPatchJobInstanceDetailsResponse>
      listPatchJobInstanceDetailsSettings;
  private final UnaryCallSettings<CreatePatchDeploymentRequest, PatchDeployment>
      createPatchDeploymentSettings;
  private final UnaryCallSettings<GetPatchDeploymentRequest, PatchDeployment>
      getPatchDeploymentSettings;
  private final UnaryCallSettings<ListPatchDeploymentsRequest, ListPatchDeploymentsResponse>
      listPatchDeploymentsSettings;
  private final UnaryCallSettings<DeletePatchDeploymentRequest, Empty>
      deletePatchDeploymentSettings;

  /** Returns the object with the settings used for calls to executePatchJob. */
  public UnaryCallSettings<ExecutePatchJobRequest, PatchJob> executePatchJobSettings() {
    return executePatchJobSettings;
  }

  /** Returns the object with the settings used for calls to getPatchJob. */
  public UnaryCallSettings<GetPatchJobRequest, PatchJob> getPatchJobSettings() {
    return getPatchJobSettings;
  }

  /** Returns the object with the settings used for calls to cancelPatchJob. */
  public UnaryCallSettings<CancelPatchJobRequest, PatchJob> cancelPatchJobSettings() {
    return cancelPatchJobSettings;
  }

  /** Returns the object with the settings used for calls to listPatchJobs. */
  public UnaryCallSettings<ListPatchJobsRequest, ListPatchJobsResponse> listPatchJobsSettings() {
    return listPatchJobsSettings;
  }

  /** Returns the object with the settings used for calls to listPatchJobInstanceDetails. */
  public UnaryCallSettings<ListPatchJobInstanceDetailsRequest, ListPatchJobInstanceDetailsResponse>
      listPatchJobInstanceDetailsSettings() {
    return listPatchJobInstanceDetailsSettings;
  }

  /** Returns the object with the settings used for calls to createPatchDeployment. */
  public UnaryCallSettings<CreatePatchDeploymentRequest, PatchDeployment>
      createPatchDeploymentSettings() {
    return createPatchDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to getPatchDeployment. */
  public UnaryCallSettings<GetPatchDeploymentRequest, PatchDeployment>
      getPatchDeploymentSettings() {
    return getPatchDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to listPatchDeployments. */
  public UnaryCallSettings<ListPatchDeploymentsRequest, ListPatchDeploymentsResponse>
      listPatchDeploymentsSettings() {
    return listPatchDeploymentsSettings;
  }

  /** Returns the object with the settings used for calls to deletePatchDeployment. */
  public UnaryCallSettings<DeletePatchDeploymentRequest, Empty> deletePatchDeploymentSettings() {
    return deletePatchDeploymentSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public OsConfigServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcOsConfigServiceStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "osconfig.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(OsConfigServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
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

  protected OsConfigServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    executePatchJobSettings = settingsBuilder.executePatchJobSettings().build();
    getPatchJobSettings = settingsBuilder.getPatchJobSettings().build();
    cancelPatchJobSettings = settingsBuilder.cancelPatchJobSettings().build();
    listPatchJobsSettings = settingsBuilder.listPatchJobsSettings().build();
    listPatchJobInstanceDetailsSettings =
        settingsBuilder.listPatchJobInstanceDetailsSettings().build();
    createPatchDeploymentSettings = settingsBuilder.createPatchDeploymentSettings().build();
    getPatchDeploymentSettings = settingsBuilder.getPatchDeploymentSettings().build();
    listPatchDeploymentsSettings = settingsBuilder.listPatchDeploymentsSettings().build();
    deletePatchDeploymentSettings = settingsBuilder.deletePatchDeploymentSettings().build();
  }

  /** Builder for OsConfigServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<OsConfigServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<ExecutePatchJobRequest, PatchJob>
        executePatchJobSettings;
    private final UnaryCallSettings.Builder<GetPatchJobRequest, PatchJob> getPatchJobSettings;
    private final UnaryCallSettings.Builder<CancelPatchJobRequest, PatchJob> cancelPatchJobSettings;
    private final UnaryCallSettings.Builder<ListPatchJobsRequest, ListPatchJobsResponse>
        listPatchJobsSettings;
    private final UnaryCallSettings.Builder<
            ListPatchJobInstanceDetailsRequest, ListPatchJobInstanceDetailsResponse>
        listPatchJobInstanceDetailsSettings;
    private final UnaryCallSettings.Builder<CreatePatchDeploymentRequest, PatchDeployment>
        createPatchDeploymentSettings;
    private final UnaryCallSettings.Builder<GetPatchDeploymentRequest, PatchDeployment>
        getPatchDeploymentSettings;
    private final UnaryCallSettings.Builder<
            ListPatchDeploymentsRequest, ListPatchDeploymentsResponse>
        listPatchDeploymentsSettings;
    private final UnaryCallSettings.Builder<DeletePatchDeploymentRequest, Empty>
        deletePatchDeploymentSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      executePatchJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getPatchJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      cancelPatchJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listPatchJobsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listPatchJobInstanceDetailsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createPatchDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getPatchDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listPatchDeploymentsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deletePatchDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              executePatchJobSettings,
              getPatchJobSettings,
              cancelPatchJobSettings,
              listPatchJobsSettings,
              listPatchJobInstanceDetailsSettings,
              createPatchDeploymentSettings,
              getPatchDeploymentSettings,
              listPatchDeploymentsSettings,
              deletePatchDeploymentSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .executePatchJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getPatchJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .cancelPatchJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listPatchJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listPatchJobInstanceDetailsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createPatchDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getPatchDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listPatchDeploymentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deletePatchDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(OsConfigServiceStubSettings settings) {
      super(settings);

      executePatchJobSettings = settings.executePatchJobSettings.toBuilder();
      getPatchJobSettings = settings.getPatchJobSettings.toBuilder();
      cancelPatchJobSettings = settings.cancelPatchJobSettings.toBuilder();
      listPatchJobsSettings = settings.listPatchJobsSettings.toBuilder();
      listPatchJobInstanceDetailsSettings =
          settings.listPatchJobInstanceDetailsSettings.toBuilder();
      createPatchDeploymentSettings = settings.createPatchDeploymentSettings.toBuilder();
      getPatchDeploymentSettings = settings.getPatchDeploymentSettings.toBuilder();
      listPatchDeploymentsSettings = settings.listPatchDeploymentsSettings.toBuilder();
      deletePatchDeploymentSettings = settings.deletePatchDeploymentSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              executePatchJobSettings,
              getPatchJobSettings,
              cancelPatchJobSettings,
              listPatchJobsSettings,
              listPatchJobInstanceDetailsSettings,
              createPatchDeploymentSettings,
              getPatchDeploymentSettings,
              listPatchDeploymentsSettings,
              deletePatchDeploymentSettings);
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to executePatchJob. */
    public UnaryCallSettings.Builder<ExecutePatchJobRequest, PatchJob> executePatchJobSettings() {
      return executePatchJobSettings;
    }

    /** Returns the builder for the settings used for calls to getPatchJob. */
    public UnaryCallSettings.Builder<GetPatchJobRequest, PatchJob> getPatchJobSettings() {
      return getPatchJobSettings;
    }

    /** Returns the builder for the settings used for calls to cancelPatchJob. */
    public UnaryCallSettings.Builder<CancelPatchJobRequest, PatchJob> cancelPatchJobSettings() {
      return cancelPatchJobSettings;
    }

    /** Returns the builder for the settings used for calls to listPatchJobs. */
    public UnaryCallSettings.Builder<ListPatchJobsRequest, ListPatchJobsResponse>
        listPatchJobsSettings() {
      return listPatchJobsSettings;
    }

    /** Returns the builder for the settings used for calls to listPatchJobInstanceDetails. */
    public UnaryCallSettings.Builder<
            ListPatchJobInstanceDetailsRequest, ListPatchJobInstanceDetailsResponse>
        listPatchJobInstanceDetailsSettings() {
      return listPatchJobInstanceDetailsSettings;
    }

    /** Returns the builder for the settings used for calls to createPatchDeployment. */
    public UnaryCallSettings.Builder<CreatePatchDeploymentRequest, PatchDeployment>
        createPatchDeploymentSettings() {
      return createPatchDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to getPatchDeployment. */
    public UnaryCallSettings.Builder<GetPatchDeploymentRequest, PatchDeployment>
        getPatchDeploymentSettings() {
      return getPatchDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to listPatchDeployments. */
    public UnaryCallSettings.Builder<ListPatchDeploymentsRequest, ListPatchDeploymentsResponse>
        listPatchDeploymentsSettings() {
      return listPatchDeploymentsSettings;
    }

    /** Returns the builder for the settings used for calls to deletePatchDeployment. */
    public UnaryCallSettings.Builder<DeletePatchDeploymentRequest, Empty>
        deletePatchDeploymentSettings() {
      return deletePatchDeploymentSettings;
    }

    @Override
    public OsConfigServiceStubSettings build() throws IOException {
      return new OsConfigServiceStubSettings(this);
    }
  }
}
