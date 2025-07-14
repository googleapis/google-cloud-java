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

import static com.google.iam.v3.PolicyBindingsClient.ListPolicyBindingsPagedResponse;
import static com.google.iam.v3.PolicyBindingsClient.SearchTargetPolicyBindingsPagedResponse;

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
import com.google.iam.v3.stub.PolicyBindingsStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PolicyBindingsClient}.
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
 * of getPolicyBinding:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PolicyBindingsSettings.Builder policyBindingsSettingsBuilder =
 *     PolicyBindingsSettings.newBuilder();
 * policyBindingsSettingsBuilder
 *     .getPolicyBindingSettings()
 *     .setRetrySettings(
 *         policyBindingsSettingsBuilder
 *             .getPolicyBindingSettings()
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
 * PolicyBindingsSettings policyBindingsSettings = policyBindingsSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createPolicyBinding:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PolicyBindingsSettings.Builder policyBindingsSettingsBuilder =
 *     PolicyBindingsSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * policyBindingsSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class PolicyBindingsSettings extends ClientSettings<PolicyBindingsSettings> {

  /** Returns the object with the settings used for calls to createPolicyBinding. */
  public UnaryCallSettings<CreatePolicyBindingRequest, Operation> createPolicyBindingSettings() {
    return ((PolicyBindingsStubSettings) getStubSettings()).createPolicyBindingSettings();
  }

  /** Returns the object with the settings used for calls to createPolicyBinding. */
  public OperationCallSettings<CreatePolicyBindingRequest, PolicyBinding, OperationMetadata>
      createPolicyBindingOperationSettings() {
    return ((PolicyBindingsStubSettings) getStubSettings()).createPolicyBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to getPolicyBinding. */
  public UnaryCallSettings<GetPolicyBindingRequest, PolicyBinding> getPolicyBindingSettings() {
    return ((PolicyBindingsStubSettings) getStubSettings()).getPolicyBindingSettings();
  }

  /** Returns the object with the settings used for calls to updatePolicyBinding. */
  public UnaryCallSettings<UpdatePolicyBindingRequest, Operation> updatePolicyBindingSettings() {
    return ((PolicyBindingsStubSettings) getStubSettings()).updatePolicyBindingSettings();
  }

  /** Returns the object with the settings used for calls to updatePolicyBinding. */
  public OperationCallSettings<UpdatePolicyBindingRequest, PolicyBinding, OperationMetadata>
      updatePolicyBindingOperationSettings() {
    return ((PolicyBindingsStubSettings) getStubSettings()).updatePolicyBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to deletePolicyBinding. */
  public UnaryCallSettings<DeletePolicyBindingRequest, Operation> deletePolicyBindingSettings() {
    return ((PolicyBindingsStubSettings) getStubSettings()).deletePolicyBindingSettings();
  }

  /** Returns the object with the settings used for calls to deletePolicyBinding. */
  public OperationCallSettings<DeletePolicyBindingRequest, Empty, OperationMetadata>
      deletePolicyBindingOperationSettings() {
    return ((PolicyBindingsStubSettings) getStubSettings()).deletePolicyBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to listPolicyBindings. */
  public PagedCallSettings<
          ListPolicyBindingsRequest, ListPolicyBindingsResponse, ListPolicyBindingsPagedResponse>
      listPolicyBindingsSettings() {
    return ((PolicyBindingsStubSettings) getStubSettings()).listPolicyBindingsSettings();
  }

  /** Returns the object with the settings used for calls to searchTargetPolicyBindings. */
  public PagedCallSettings<
          SearchTargetPolicyBindingsRequest,
          SearchTargetPolicyBindingsResponse,
          SearchTargetPolicyBindingsPagedResponse>
      searchTargetPolicyBindingsSettings() {
    return ((PolicyBindingsStubSettings) getStubSettings()).searchTargetPolicyBindingsSettings();
  }

  public static final PolicyBindingsSettings create(PolicyBindingsStubSettings stub)
      throws IOException {
    return new PolicyBindingsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return PolicyBindingsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return PolicyBindingsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return PolicyBindingsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return PolicyBindingsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return PolicyBindingsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return PolicyBindingsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return PolicyBindingsStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PolicyBindingsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected PolicyBindingsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for PolicyBindingsSettings. */
  public static class Builder extends ClientSettings.Builder<PolicyBindingsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(PolicyBindingsStubSettings.newBuilder(clientContext));
    }

    protected Builder(PolicyBindingsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(PolicyBindingsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(PolicyBindingsStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(PolicyBindingsStubSettings.newHttpJsonBuilder());
    }

    public PolicyBindingsStubSettings.Builder getStubSettingsBuilder() {
      return ((PolicyBindingsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createPolicyBinding. */
    public UnaryCallSettings.Builder<CreatePolicyBindingRequest, Operation>
        createPolicyBindingSettings() {
      return getStubSettingsBuilder().createPolicyBindingSettings();
    }

    /** Returns the builder for the settings used for calls to createPolicyBinding. */
    public OperationCallSettings.Builder<
            CreatePolicyBindingRequest, PolicyBinding, OperationMetadata>
        createPolicyBindingOperationSettings() {
      return getStubSettingsBuilder().createPolicyBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getPolicyBinding. */
    public UnaryCallSettings.Builder<GetPolicyBindingRequest, PolicyBinding>
        getPolicyBindingSettings() {
      return getStubSettingsBuilder().getPolicyBindingSettings();
    }

    /** Returns the builder for the settings used for calls to updatePolicyBinding. */
    public UnaryCallSettings.Builder<UpdatePolicyBindingRequest, Operation>
        updatePolicyBindingSettings() {
      return getStubSettingsBuilder().updatePolicyBindingSettings();
    }

    /** Returns the builder for the settings used for calls to updatePolicyBinding. */
    public OperationCallSettings.Builder<
            UpdatePolicyBindingRequest, PolicyBinding, OperationMetadata>
        updatePolicyBindingOperationSettings() {
      return getStubSettingsBuilder().updatePolicyBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deletePolicyBinding. */
    public UnaryCallSettings.Builder<DeletePolicyBindingRequest, Operation>
        deletePolicyBindingSettings() {
      return getStubSettingsBuilder().deletePolicyBindingSettings();
    }

    /** Returns the builder for the settings used for calls to deletePolicyBinding. */
    public OperationCallSettings.Builder<DeletePolicyBindingRequest, Empty, OperationMetadata>
        deletePolicyBindingOperationSettings() {
      return getStubSettingsBuilder().deletePolicyBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listPolicyBindings. */
    public PagedCallSettings.Builder<
            ListPolicyBindingsRequest, ListPolicyBindingsResponse, ListPolicyBindingsPagedResponse>
        listPolicyBindingsSettings() {
      return getStubSettingsBuilder().listPolicyBindingsSettings();
    }

    /** Returns the builder for the settings used for calls to searchTargetPolicyBindings. */
    public PagedCallSettings.Builder<
            SearchTargetPolicyBindingsRequest,
            SearchTargetPolicyBindingsResponse,
            SearchTargetPolicyBindingsPagedResponse>
        searchTargetPolicyBindingsSettings() {
      return getStubSettingsBuilder().searchTargetPolicyBindingsSettings();
    }

    @Override
    public PolicyBindingsSettings build() throws IOException {
      return new PolicyBindingsSettings(this);
    }
  }
}
