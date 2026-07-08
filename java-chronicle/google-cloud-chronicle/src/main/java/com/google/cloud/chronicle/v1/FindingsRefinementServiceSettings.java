/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.chronicle.v1;

import static com.google.cloud.chronicle.v1.FindingsRefinementServiceClient.ListAllFindingsRefinementDeploymentsPagedResponse;
import static com.google.cloud.chronicle.v1.FindingsRefinementServiceClient.ListFindingsRefinementsPagedResponse;

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
import com.google.cloud.chronicle.v1.stub.FindingsRefinementServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link FindingsRefinementServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (chronicle.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getFindingsRefinement:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FindingsRefinementServiceSettings.Builder findingsRefinementServiceSettingsBuilder =
 *     FindingsRefinementServiceSettings.newBuilder();
 * findingsRefinementServiceSettingsBuilder
 *     .getFindingsRefinementSettings()
 *     .setRetrySettings(
 *         findingsRefinementServiceSettingsBuilder
 *             .getFindingsRefinementSettings()
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
 * FindingsRefinementServiceSettings findingsRefinementServiceSettings =
 *     findingsRefinementServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@Generated("by gapic-generator-java")
public class FindingsRefinementServiceSettings
    extends ClientSettings<FindingsRefinementServiceSettings> {

  /** Returns the object with the settings used for calls to getFindingsRefinement. */
  public UnaryCallSettings<GetFindingsRefinementRequest, FindingsRefinement>
      getFindingsRefinementSettings() {
    return ((FindingsRefinementServiceStubSettings) getStubSettings())
        .getFindingsRefinementSettings();
  }

  /** Returns the object with the settings used for calls to listFindingsRefinements. */
  public PagedCallSettings<
          ListFindingsRefinementsRequest,
          ListFindingsRefinementsResponse,
          ListFindingsRefinementsPagedResponse>
      listFindingsRefinementsSettings() {
    return ((FindingsRefinementServiceStubSettings) getStubSettings())
        .listFindingsRefinementsSettings();
  }

  /** Returns the object with the settings used for calls to createFindingsRefinement. */
  public UnaryCallSettings<CreateFindingsRefinementRequest, FindingsRefinement>
      createFindingsRefinementSettings() {
    return ((FindingsRefinementServiceStubSettings) getStubSettings())
        .createFindingsRefinementSettings();
  }

  /** Returns the object with the settings used for calls to updateFindingsRefinement. */
  public UnaryCallSettings<UpdateFindingsRefinementRequest, FindingsRefinement>
      updateFindingsRefinementSettings() {
    return ((FindingsRefinementServiceStubSettings) getStubSettings())
        .updateFindingsRefinementSettings();
  }

  /** Returns the object with the settings used for calls to getFindingsRefinementDeployment. */
  public UnaryCallSettings<GetFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
      getFindingsRefinementDeploymentSettings() {
    return ((FindingsRefinementServiceStubSettings) getStubSettings())
        .getFindingsRefinementDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to updateFindingsRefinementDeployment. */
  public UnaryCallSettings<UpdateFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
      updateFindingsRefinementDeploymentSettings() {
    return ((FindingsRefinementServiceStubSettings) getStubSettings())
        .updateFindingsRefinementDeploymentSettings();
  }

  /**
   * Returns the object with the settings used for calls to listAllFindingsRefinementDeployments.
   */
  public PagedCallSettings<
          ListAllFindingsRefinementDeploymentsRequest,
          ListAllFindingsRefinementDeploymentsResponse,
          ListAllFindingsRefinementDeploymentsPagedResponse>
      listAllFindingsRefinementDeploymentsSettings() {
    return ((FindingsRefinementServiceStubSettings) getStubSettings())
        .listAllFindingsRefinementDeploymentsSettings();
  }

  /** Returns the object with the settings used for calls to computeFindingsRefinementActivity. */
  public UnaryCallSettings<
          ComputeFindingsRefinementActivityRequest, ComputeFindingsRefinementActivityResponse>
      computeFindingsRefinementActivitySettings() {
    return ((FindingsRefinementServiceStubSettings) getStubSettings())
        .computeFindingsRefinementActivitySettings();
  }

  /**
   * Returns the object with the settings used for calls to computeAllFindingsRefinementActivities.
   */
  public UnaryCallSettings<
          ComputeAllFindingsRefinementActivitiesRequest,
          ComputeAllFindingsRefinementActivitiesResponse>
      computeAllFindingsRefinementActivitiesSettings() {
    return ((FindingsRefinementServiceStubSettings) getStubSettings())
        .computeAllFindingsRefinementActivitiesSettings();
  }

  public static final FindingsRefinementServiceSettings create(
      FindingsRefinementServiceStubSettings stub) throws IOException {
    return new FindingsRefinementServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return FindingsRefinementServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return FindingsRefinementServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return FindingsRefinementServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return FindingsRefinementServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return FindingsRefinementServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return FindingsRefinementServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return FindingsRefinementServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return FindingsRefinementServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected FindingsRefinementServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for FindingsRefinementServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<FindingsRefinementServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(FindingsRefinementServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(FindingsRefinementServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(FindingsRefinementServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(FindingsRefinementServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(FindingsRefinementServiceStubSettings.newHttpJsonBuilder());
    }

    public FindingsRefinementServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((FindingsRefinementServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getFindingsRefinement. */
    public UnaryCallSettings.Builder<GetFindingsRefinementRequest, FindingsRefinement>
        getFindingsRefinementSettings() {
      return getStubSettingsBuilder().getFindingsRefinementSettings();
    }

    /** Returns the builder for the settings used for calls to listFindingsRefinements. */
    public PagedCallSettings.Builder<
            ListFindingsRefinementsRequest,
            ListFindingsRefinementsResponse,
            ListFindingsRefinementsPagedResponse>
        listFindingsRefinementsSettings() {
      return getStubSettingsBuilder().listFindingsRefinementsSettings();
    }

    /** Returns the builder for the settings used for calls to createFindingsRefinement. */
    public UnaryCallSettings.Builder<CreateFindingsRefinementRequest, FindingsRefinement>
        createFindingsRefinementSettings() {
      return getStubSettingsBuilder().createFindingsRefinementSettings();
    }

    /** Returns the builder for the settings used for calls to updateFindingsRefinement. */
    public UnaryCallSettings.Builder<UpdateFindingsRefinementRequest, FindingsRefinement>
        updateFindingsRefinementSettings() {
      return getStubSettingsBuilder().updateFindingsRefinementSettings();
    }

    /** Returns the builder for the settings used for calls to getFindingsRefinementDeployment. */
    public UnaryCallSettings.Builder<
            GetFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
        getFindingsRefinementDeploymentSettings() {
      return getStubSettingsBuilder().getFindingsRefinementDeploymentSettings();
    }

    /**
     * Returns the builder for the settings used for calls to updateFindingsRefinementDeployment.
     */
    public UnaryCallSettings.Builder<
            UpdateFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
        updateFindingsRefinementDeploymentSettings() {
      return getStubSettingsBuilder().updateFindingsRefinementDeploymentSettings();
    }

    /**
     * Returns the builder for the settings used for calls to listAllFindingsRefinementDeployments.
     */
    public PagedCallSettings.Builder<
            ListAllFindingsRefinementDeploymentsRequest,
            ListAllFindingsRefinementDeploymentsResponse,
            ListAllFindingsRefinementDeploymentsPagedResponse>
        listAllFindingsRefinementDeploymentsSettings() {
      return getStubSettingsBuilder().listAllFindingsRefinementDeploymentsSettings();
    }

    /** Returns the builder for the settings used for calls to computeFindingsRefinementActivity. */
    public UnaryCallSettings.Builder<
            ComputeFindingsRefinementActivityRequest, ComputeFindingsRefinementActivityResponse>
        computeFindingsRefinementActivitySettings() {
      return getStubSettingsBuilder().computeFindingsRefinementActivitySettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * computeAllFindingsRefinementActivities.
     */
    public UnaryCallSettings.Builder<
            ComputeAllFindingsRefinementActivitiesRequest,
            ComputeAllFindingsRefinementActivitiesResponse>
        computeAllFindingsRefinementActivitiesSettings() {
      return getStubSettingsBuilder().computeAllFindingsRefinementActivitiesSettings();
    }

    @Override
    public FindingsRefinementServiceSettings build() throws IOException {
      return new FindingsRefinementServiceSettings(this);
    }
  }
}
