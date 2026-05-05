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

package com.google.iam.v3beta;

import static com.google.iam.v3beta.AccessPoliciesClient.ListAccessPoliciesPagedResponse;
import static com.google.iam.v3beta.AccessPoliciesClient.SearchAccessPolicyBindingsPagedResponse;

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
import com.google.iam.v3beta.stub.AccessPoliciesStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AccessPoliciesClient}.
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
 * of getAccessPolicy:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AccessPoliciesSettings.Builder accessPoliciesSettingsBuilder =
 *     AccessPoliciesSettings.newBuilder();
 * accessPoliciesSettingsBuilder
 *     .getAccessPolicySettings()
 *     .setRetrySettings(
 *         accessPoliciesSettingsBuilder
 *             .getAccessPolicySettings()
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
 * AccessPoliciesSettings accessPoliciesSettings = accessPoliciesSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createAccessPolicy:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AccessPoliciesSettings.Builder accessPoliciesSettingsBuilder =
 *     AccessPoliciesSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * accessPoliciesSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AccessPoliciesSettings extends ClientSettings<AccessPoliciesSettings> {

  /** Returns the object with the settings used for calls to createAccessPolicy. */
  public UnaryCallSettings<CreateAccessPolicyRequest, Operation> createAccessPolicySettings() {
    return ((AccessPoliciesStubSettings) getStubSettings()).createAccessPolicySettings();
  }

  /** Returns the object with the settings used for calls to createAccessPolicy. */
  public OperationCallSettings<CreateAccessPolicyRequest, AccessPolicy, OperationMetadata>
      createAccessPolicyOperationSettings() {
    return ((AccessPoliciesStubSettings) getStubSettings()).createAccessPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to getAccessPolicy. */
  public UnaryCallSettings<GetAccessPolicyRequest, AccessPolicy> getAccessPolicySettings() {
    return ((AccessPoliciesStubSettings) getStubSettings()).getAccessPolicySettings();
  }

  /** Returns the object with the settings used for calls to updateAccessPolicy. */
  public UnaryCallSettings<UpdateAccessPolicyRequest, Operation> updateAccessPolicySettings() {
    return ((AccessPoliciesStubSettings) getStubSettings()).updateAccessPolicySettings();
  }

  /** Returns the object with the settings used for calls to updateAccessPolicy. */
  public OperationCallSettings<UpdateAccessPolicyRequest, AccessPolicy, OperationMetadata>
      updateAccessPolicyOperationSettings() {
    return ((AccessPoliciesStubSettings) getStubSettings()).updateAccessPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteAccessPolicy. */
  public UnaryCallSettings<DeleteAccessPolicyRequest, Operation> deleteAccessPolicySettings() {
    return ((AccessPoliciesStubSettings) getStubSettings()).deleteAccessPolicySettings();
  }

  /** Returns the object with the settings used for calls to deleteAccessPolicy. */
  public OperationCallSettings<DeleteAccessPolicyRequest, Empty, OperationMetadata>
      deleteAccessPolicyOperationSettings() {
    return ((AccessPoliciesStubSettings) getStubSettings()).deleteAccessPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to listAccessPolicies. */
  public PagedCallSettings<
          ListAccessPoliciesRequest, ListAccessPoliciesResponse, ListAccessPoliciesPagedResponse>
      listAccessPoliciesSettings() {
    return ((AccessPoliciesStubSettings) getStubSettings()).listAccessPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to searchAccessPolicyBindings. */
  public PagedCallSettings<
          SearchAccessPolicyBindingsRequest,
          SearchAccessPolicyBindingsResponse,
          SearchAccessPolicyBindingsPagedResponse>
      searchAccessPolicyBindingsSettings() {
    return ((AccessPoliciesStubSettings) getStubSettings()).searchAccessPolicyBindingsSettings();
  }

  public static final AccessPoliciesSettings create(AccessPoliciesStubSettings stub)
      throws IOException {
    return new AccessPoliciesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AccessPoliciesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AccessPoliciesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AccessPoliciesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AccessPoliciesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AccessPoliciesStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AccessPoliciesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AccessPoliciesStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AccessPoliciesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AccessPoliciesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AccessPoliciesSettings. */
  public static class Builder extends ClientSettings.Builder<AccessPoliciesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AccessPoliciesStubSettings.newBuilder(clientContext));
    }

    protected Builder(AccessPoliciesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AccessPoliciesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AccessPoliciesStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(AccessPoliciesStubSettings.newHttpJsonBuilder());
    }

    public AccessPoliciesStubSettings.Builder getStubSettingsBuilder() {
      return ((AccessPoliciesStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createAccessPolicy. */
    public UnaryCallSettings.Builder<CreateAccessPolicyRequest, Operation>
        createAccessPolicySettings() {
      return getStubSettingsBuilder().createAccessPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createAccessPolicy. */
    public OperationCallSettings.Builder<CreateAccessPolicyRequest, AccessPolicy, OperationMetadata>
        createAccessPolicyOperationSettings() {
      return getStubSettingsBuilder().createAccessPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getAccessPolicy. */
    public UnaryCallSettings.Builder<GetAccessPolicyRequest, AccessPolicy>
        getAccessPolicySettings() {
      return getStubSettingsBuilder().getAccessPolicySettings();
    }

    /** Returns the builder for the settings used for calls to updateAccessPolicy. */
    public UnaryCallSettings.Builder<UpdateAccessPolicyRequest, Operation>
        updateAccessPolicySettings() {
      return getStubSettingsBuilder().updateAccessPolicySettings();
    }

    /** Returns the builder for the settings used for calls to updateAccessPolicy. */
    public OperationCallSettings.Builder<UpdateAccessPolicyRequest, AccessPolicy, OperationMetadata>
        updateAccessPolicyOperationSettings() {
      return getStubSettingsBuilder().updateAccessPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAccessPolicy. */
    public UnaryCallSettings.Builder<DeleteAccessPolicyRequest, Operation>
        deleteAccessPolicySettings() {
      return getStubSettingsBuilder().deleteAccessPolicySettings();
    }

    /** Returns the builder for the settings used for calls to deleteAccessPolicy. */
    public OperationCallSettings.Builder<DeleteAccessPolicyRequest, Empty, OperationMetadata>
        deleteAccessPolicyOperationSettings() {
      return getStubSettingsBuilder().deleteAccessPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listAccessPolicies. */
    public PagedCallSettings.Builder<
            ListAccessPoliciesRequest, ListAccessPoliciesResponse, ListAccessPoliciesPagedResponse>
        listAccessPoliciesSettings() {
      return getStubSettingsBuilder().listAccessPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to searchAccessPolicyBindings. */
    public PagedCallSettings.Builder<
            SearchAccessPolicyBindingsRequest,
            SearchAccessPolicyBindingsResponse,
            SearchAccessPolicyBindingsPagedResponse>
        searchAccessPolicyBindingsSettings() {
      return getStubSettingsBuilder().searchAccessPolicyBindingsSettings();
    }

    @Override
    public AccessPoliciesSettings build() throws IOException {
      return new AccessPoliciesSettings(this);
    }
  }
}
