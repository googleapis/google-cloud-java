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

package com.google.iam.v3;

import static com.google.iam.v3.PrincipalAccessBoundaryPoliciesClient.ListPrincipalAccessBoundaryPoliciesPagedResponse;
import static com.google.iam.v3.PrincipalAccessBoundaryPoliciesClient.SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse;

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
import com.google.iam.v3.stub.PrincipalAccessBoundaryPoliciesStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PrincipalAccessBoundaryPoliciesClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (iam.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getPrincipalAccessBoundaryPolicy:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PrincipalAccessBoundaryPoliciesSettings.Builder principalAccessBoundaryPoliciesSettingsBuilder =
 *     PrincipalAccessBoundaryPoliciesSettings.newBuilder();
 * principalAccessBoundaryPoliciesSettingsBuilder
 *     .getPrincipalAccessBoundaryPolicySettings()
 *     .setRetrySettings(
 *         principalAccessBoundaryPoliciesSettingsBuilder
 *             .getPrincipalAccessBoundaryPolicySettings()
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
 * PrincipalAccessBoundaryPoliciesSettings principalAccessBoundaryPoliciesSettings =
 *     principalAccessBoundaryPoliciesSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createPrincipalAccessBoundaryPolicy:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PrincipalAccessBoundaryPoliciesSettings.Builder principalAccessBoundaryPoliciesSettingsBuilder =
 *     PrincipalAccessBoundaryPoliciesSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * principalAccessBoundaryPoliciesSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class PrincipalAccessBoundaryPoliciesSettings
    extends ClientSettings<PrincipalAccessBoundaryPoliciesSettings> {

  /** Returns the object with the settings used for calls to createPrincipalAccessBoundaryPolicy. */
  public UnaryCallSettings<CreatePrincipalAccessBoundaryPolicyRequest, Operation>
      createPrincipalAccessBoundaryPolicySettings() {
    return ((PrincipalAccessBoundaryPoliciesStubSettings) getStubSettings())
        .createPrincipalAccessBoundaryPolicySettings();
  }

  /** Returns the object with the settings used for calls to createPrincipalAccessBoundaryPolicy. */
  public OperationCallSettings<
          CreatePrincipalAccessBoundaryPolicyRequest,
          PrincipalAccessBoundaryPolicy,
          OperationMetadata>
      createPrincipalAccessBoundaryPolicyOperationSettings() {
    return ((PrincipalAccessBoundaryPoliciesStubSettings) getStubSettings())
        .createPrincipalAccessBoundaryPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to getPrincipalAccessBoundaryPolicy. */
  public UnaryCallSettings<GetPrincipalAccessBoundaryPolicyRequest, PrincipalAccessBoundaryPolicy>
      getPrincipalAccessBoundaryPolicySettings() {
    return ((PrincipalAccessBoundaryPoliciesStubSettings) getStubSettings())
        .getPrincipalAccessBoundaryPolicySettings();
  }

  /** Returns the object with the settings used for calls to updatePrincipalAccessBoundaryPolicy. */
  public UnaryCallSettings<UpdatePrincipalAccessBoundaryPolicyRequest, Operation>
      updatePrincipalAccessBoundaryPolicySettings() {
    return ((PrincipalAccessBoundaryPoliciesStubSettings) getStubSettings())
        .updatePrincipalAccessBoundaryPolicySettings();
  }

  /** Returns the object with the settings used for calls to updatePrincipalAccessBoundaryPolicy. */
  public OperationCallSettings<
          UpdatePrincipalAccessBoundaryPolicyRequest,
          PrincipalAccessBoundaryPolicy,
          OperationMetadata>
      updatePrincipalAccessBoundaryPolicyOperationSettings() {
    return ((PrincipalAccessBoundaryPoliciesStubSettings) getStubSettings())
        .updatePrincipalAccessBoundaryPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to deletePrincipalAccessBoundaryPolicy. */
  public UnaryCallSettings<DeletePrincipalAccessBoundaryPolicyRequest, Operation>
      deletePrincipalAccessBoundaryPolicySettings() {
    return ((PrincipalAccessBoundaryPoliciesStubSettings) getStubSettings())
        .deletePrincipalAccessBoundaryPolicySettings();
  }

  /** Returns the object with the settings used for calls to deletePrincipalAccessBoundaryPolicy. */
  public OperationCallSettings<DeletePrincipalAccessBoundaryPolicyRequest, Empty, OperationMetadata>
      deletePrincipalAccessBoundaryPolicyOperationSettings() {
    return ((PrincipalAccessBoundaryPoliciesStubSettings) getStubSettings())
        .deletePrincipalAccessBoundaryPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to listPrincipalAccessBoundaryPolicies. */
  public PagedCallSettings<
          ListPrincipalAccessBoundaryPoliciesRequest,
          ListPrincipalAccessBoundaryPoliciesResponse,
          ListPrincipalAccessBoundaryPoliciesPagedResponse>
      listPrincipalAccessBoundaryPoliciesSettings() {
    return ((PrincipalAccessBoundaryPoliciesStubSettings) getStubSettings())
        .listPrincipalAccessBoundaryPoliciesSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * searchPrincipalAccessBoundaryPolicyBindings.
   */
  public PagedCallSettings<
          SearchPrincipalAccessBoundaryPolicyBindingsRequest,
          SearchPrincipalAccessBoundaryPolicyBindingsResponse,
          SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse>
      searchPrincipalAccessBoundaryPolicyBindingsSettings() {
    return ((PrincipalAccessBoundaryPoliciesStubSettings) getStubSettings())
        .searchPrincipalAccessBoundaryPolicyBindingsSettings();
  }

  public static final PrincipalAccessBoundaryPoliciesSettings create(
      PrincipalAccessBoundaryPoliciesStubSettings stub) throws IOException {
    return new PrincipalAccessBoundaryPoliciesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return PrincipalAccessBoundaryPoliciesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return PrincipalAccessBoundaryPoliciesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return PrincipalAccessBoundaryPoliciesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return PrincipalAccessBoundaryPoliciesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return PrincipalAccessBoundaryPoliciesStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return PrincipalAccessBoundaryPoliciesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return PrincipalAccessBoundaryPoliciesStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PrincipalAccessBoundaryPoliciesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected PrincipalAccessBoundaryPoliciesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for PrincipalAccessBoundaryPoliciesSettings. */
  public static class Builder
      extends ClientSettings.Builder<PrincipalAccessBoundaryPoliciesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(PrincipalAccessBoundaryPoliciesStubSettings.newBuilder(clientContext));
    }

    protected Builder(PrincipalAccessBoundaryPoliciesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(PrincipalAccessBoundaryPoliciesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(PrincipalAccessBoundaryPoliciesStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(PrincipalAccessBoundaryPoliciesStubSettings.newHttpJsonBuilder());
    }

    public PrincipalAccessBoundaryPoliciesStubSettings.Builder getStubSettingsBuilder() {
      return ((PrincipalAccessBoundaryPoliciesStubSettings.Builder) getStubSettings());
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

    /**
     * Returns the builder for the settings used for calls to createPrincipalAccessBoundaryPolicy.
     */
    public UnaryCallSettings.Builder<CreatePrincipalAccessBoundaryPolicyRequest, Operation>
        createPrincipalAccessBoundaryPolicySettings() {
      return getStubSettingsBuilder().createPrincipalAccessBoundaryPolicySettings();
    }

    /**
     * Returns the builder for the settings used for calls to createPrincipalAccessBoundaryPolicy.
     */
    public OperationCallSettings.Builder<
            CreatePrincipalAccessBoundaryPolicyRequest,
            PrincipalAccessBoundaryPolicy,
            OperationMetadata>
        createPrincipalAccessBoundaryPolicyOperationSettings() {
      return getStubSettingsBuilder().createPrincipalAccessBoundaryPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getPrincipalAccessBoundaryPolicy. */
    public UnaryCallSettings.Builder<
            GetPrincipalAccessBoundaryPolicyRequest, PrincipalAccessBoundaryPolicy>
        getPrincipalAccessBoundaryPolicySettings() {
      return getStubSettingsBuilder().getPrincipalAccessBoundaryPolicySettings();
    }

    /**
     * Returns the builder for the settings used for calls to updatePrincipalAccessBoundaryPolicy.
     */
    public UnaryCallSettings.Builder<UpdatePrincipalAccessBoundaryPolicyRequest, Operation>
        updatePrincipalAccessBoundaryPolicySettings() {
      return getStubSettingsBuilder().updatePrincipalAccessBoundaryPolicySettings();
    }

    /**
     * Returns the builder for the settings used for calls to updatePrincipalAccessBoundaryPolicy.
     */
    public OperationCallSettings.Builder<
            UpdatePrincipalAccessBoundaryPolicyRequest,
            PrincipalAccessBoundaryPolicy,
            OperationMetadata>
        updatePrincipalAccessBoundaryPolicyOperationSettings() {
      return getStubSettingsBuilder().updatePrincipalAccessBoundaryPolicyOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to deletePrincipalAccessBoundaryPolicy.
     */
    public UnaryCallSettings.Builder<DeletePrincipalAccessBoundaryPolicyRequest, Operation>
        deletePrincipalAccessBoundaryPolicySettings() {
      return getStubSettingsBuilder().deletePrincipalAccessBoundaryPolicySettings();
    }

    /**
     * Returns the builder for the settings used for calls to deletePrincipalAccessBoundaryPolicy.
     */
    public OperationCallSettings.Builder<
            DeletePrincipalAccessBoundaryPolicyRequest, Empty, OperationMetadata>
        deletePrincipalAccessBoundaryPolicyOperationSettings() {
      return getStubSettingsBuilder().deletePrincipalAccessBoundaryPolicyOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to listPrincipalAccessBoundaryPolicies.
     */
    public PagedCallSettings.Builder<
            ListPrincipalAccessBoundaryPoliciesRequest,
            ListPrincipalAccessBoundaryPoliciesResponse,
            ListPrincipalAccessBoundaryPoliciesPagedResponse>
        listPrincipalAccessBoundaryPoliciesSettings() {
      return getStubSettingsBuilder().listPrincipalAccessBoundaryPoliciesSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * searchPrincipalAccessBoundaryPolicyBindings.
     */
    public PagedCallSettings.Builder<
            SearchPrincipalAccessBoundaryPolicyBindingsRequest,
            SearchPrincipalAccessBoundaryPolicyBindingsResponse,
            SearchPrincipalAccessBoundaryPolicyBindingsPagedResponse>
        searchPrincipalAccessBoundaryPolicyBindingsSettings() {
      return getStubSettingsBuilder().searchPrincipalAccessBoundaryPolicyBindingsSettings();
    }

    @Override
    public PrincipalAccessBoundaryPoliciesSettings build() throws IOException {
      return new PrincipalAccessBoundaryPoliciesSettings(this);
    }
  }
}
