/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.gkerecommender.v1;

import static com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient.FetchModelServerVersionsPagedResponse;
import static com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient.FetchModelServersPagedResponse;
import static com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient.FetchModelsPagedResponse;
import static com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient.FetchProfilesPagedResponse;

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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.gkerecommender.v1.stub.GkeInferenceQuickstartStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link GkeInferenceQuickstartClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (gkerecommender.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of generateOptimizedManifest:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GkeInferenceQuickstartSettings.Builder gkeInferenceQuickstartSettingsBuilder =
 *     GkeInferenceQuickstartSettings.newBuilder();
 * gkeInferenceQuickstartSettingsBuilder
 *     .generateOptimizedManifestSettings()
 *     .setRetrySettings(
 *         gkeInferenceQuickstartSettingsBuilder
 *             .generateOptimizedManifestSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * GkeInferenceQuickstartSettings gkeInferenceQuickstartSettings =
 *     gkeInferenceQuickstartSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class GkeInferenceQuickstartSettings extends ClientSettings<GkeInferenceQuickstartSettings> {

  /** Returns the object with the settings used for calls to fetchModels. */
  public PagedCallSettings<FetchModelsRequest, FetchModelsResponse, FetchModelsPagedResponse>
      fetchModelsSettings() {
    return ((GkeInferenceQuickstartStubSettings) getStubSettings()).fetchModelsSettings();
  }

  /** Returns the object with the settings used for calls to fetchModelServers. */
  public PagedCallSettings<
          FetchModelServersRequest, FetchModelServersResponse, FetchModelServersPagedResponse>
      fetchModelServersSettings() {
    return ((GkeInferenceQuickstartStubSettings) getStubSettings()).fetchModelServersSettings();
  }

  /** Returns the object with the settings used for calls to fetchModelServerVersions. */
  public PagedCallSettings<
          FetchModelServerVersionsRequest,
          FetchModelServerVersionsResponse,
          FetchModelServerVersionsPagedResponse>
      fetchModelServerVersionsSettings() {
    return ((GkeInferenceQuickstartStubSettings) getStubSettings())
        .fetchModelServerVersionsSettings();
  }

  /** Returns the object with the settings used for calls to fetchProfiles. */
  public PagedCallSettings<FetchProfilesRequest, FetchProfilesResponse, FetchProfilesPagedResponse>
      fetchProfilesSettings() {
    return ((GkeInferenceQuickstartStubSettings) getStubSettings()).fetchProfilesSettings();
  }

  /** Returns the object with the settings used for calls to generateOptimizedManifest. */
  public UnaryCallSettings<GenerateOptimizedManifestRequest, GenerateOptimizedManifestResponse>
      generateOptimizedManifestSettings() {
    return ((GkeInferenceQuickstartStubSettings) getStubSettings())
        .generateOptimizedManifestSettings();
  }

  /** Returns the object with the settings used for calls to fetchBenchmarkingData. */
  public UnaryCallSettings<FetchBenchmarkingDataRequest, FetchBenchmarkingDataResponse>
      fetchBenchmarkingDataSettings() {
    return ((GkeInferenceQuickstartStubSettings) getStubSettings()).fetchBenchmarkingDataSettings();
  }

  public static final GkeInferenceQuickstartSettings create(GkeInferenceQuickstartStubSettings stub)
      throws IOException {
    return new GkeInferenceQuickstartSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return GkeInferenceQuickstartStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return GkeInferenceQuickstartStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return GkeInferenceQuickstartStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GkeInferenceQuickstartStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return GkeInferenceQuickstartStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return GkeInferenceQuickstartStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return GkeInferenceQuickstartStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GkeInferenceQuickstartStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected GkeInferenceQuickstartSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for GkeInferenceQuickstartSettings. */
  public static class Builder
      extends ClientSettings.Builder<GkeInferenceQuickstartSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(GkeInferenceQuickstartStubSettings.newBuilder(clientContext));
    }

    protected Builder(GkeInferenceQuickstartSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(GkeInferenceQuickstartStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(GkeInferenceQuickstartStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(GkeInferenceQuickstartStubSettings.newHttpJsonBuilder());
    }

    public GkeInferenceQuickstartStubSettings.Builder getStubSettingsBuilder() {
      return ((GkeInferenceQuickstartStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to fetchModels. */
    public PagedCallSettings.Builder<
            FetchModelsRequest, FetchModelsResponse, FetchModelsPagedResponse>
        fetchModelsSettings() {
      return getStubSettingsBuilder().fetchModelsSettings();
    }

    /** Returns the builder for the settings used for calls to fetchModelServers. */
    public PagedCallSettings.Builder<
            FetchModelServersRequest, FetchModelServersResponse, FetchModelServersPagedResponse>
        fetchModelServersSettings() {
      return getStubSettingsBuilder().fetchModelServersSettings();
    }

    /** Returns the builder for the settings used for calls to fetchModelServerVersions. */
    public PagedCallSettings.Builder<
            FetchModelServerVersionsRequest,
            FetchModelServerVersionsResponse,
            FetchModelServerVersionsPagedResponse>
        fetchModelServerVersionsSettings() {
      return getStubSettingsBuilder().fetchModelServerVersionsSettings();
    }

    /** Returns the builder for the settings used for calls to fetchProfiles. */
    public PagedCallSettings.Builder<
            FetchProfilesRequest, FetchProfilesResponse, FetchProfilesPagedResponse>
        fetchProfilesSettings() {
      return getStubSettingsBuilder().fetchProfilesSettings();
    }

    /** Returns the builder for the settings used for calls to generateOptimizedManifest. */
    public UnaryCallSettings.Builder<
            GenerateOptimizedManifestRequest, GenerateOptimizedManifestResponse>
        generateOptimizedManifestSettings() {
      return getStubSettingsBuilder().generateOptimizedManifestSettings();
    }

    /** Returns the builder for the settings used for calls to fetchBenchmarkingData. */
    public UnaryCallSettings.Builder<FetchBenchmarkingDataRequest, FetchBenchmarkingDataResponse>
        fetchBenchmarkingDataSettings() {
      return getStubSettingsBuilder().fetchBenchmarkingDataSettings();
    }

    @Override
    public GkeInferenceQuickstartSettings build() throws IOException {
      return new GkeInferenceQuickstartSettings(this);
    }
  }
}
