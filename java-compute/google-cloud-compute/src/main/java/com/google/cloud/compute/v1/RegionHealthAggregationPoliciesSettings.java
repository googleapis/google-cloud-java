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

package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.RegionHealthAggregationPoliciesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.RegionHealthAggregationPoliciesClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.RegionHealthAggregationPoliciesStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RegionHealthAggregationPoliciesClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (compute.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of get:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionHealthAggregationPoliciesSettings.Builder regionHealthAggregationPoliciesSettingsBuilder =
 *     RegionHealthAggregationPoliciesSettings.newBuilder();
 * regionHealthAggregationPoliciesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         regionHealthAggregationPoliciesSettingsBuilder
 *             .getSettings()
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
 * RegionHealthAggregationPoliciesSettings regionHealthAggregationPoliciesSettings =
 *     regionHealthAggregationPoliciesSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for delete:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionHealthAggregationPoliciesSettings.Builder regionHealthAggregationPoliciesSettingsBuilder =
 *     RegionHealthAggregationPoliciesSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * regionHealthAggregationPoliciesSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RegionHealthAggregationPoliciesSettings
    extends ClientSettings<RegionHealthAggregationPoliciesSettings> {

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListRegionHealthAggregationPoliciesRequest,
          HealthAggregationPolicyAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings() {
    return ((RegionHealthAggregationPoliciesStubSettings) getStubSettings())
        .aggregatedListSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteRegionHealthAggregationPolicyRequest, Operation> deleteSettings() {
    return ((RegionHealthAggregationPoliciesStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteRegionHealthAggregationPolicyRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((RegionHealthAggregationPoliciesStubSettings) getStubSettings())
        .deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetRegionHealthAggregationPolicyRequest, HealthAggregationPolicy>
      getSettings() {
    return ((RegionHealthAggregationPoliciesStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertRegionHealthAggregationPolicyRequest, Operation> insertSettings() {
    return ((RegionHealthAggregationPoliciesStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertRegionHealthAggregationPolicyRequest, Operation, Operation>
      insertOperationSettings() {
    return ((RegionHealthAggregationPoliciesStubSettings) getStubSettings())
        .insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<
          ListRegionHealthAggregationPoliciesRequest,
          HealthAggregationPolicyList,
          ListPagedResponse>
      listSettings() {
    return ((RegionHealthAggregationPoliciesStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchRegionHealthAggregationPolicyRequest, Operation> patchSettings() {
    return ((RegionHealthAggregationPoliciesStubSettings) getStubSettings()).patchSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchRegionHealthAggregationPolicyRequest, Operation, Operation>
      patchOperationSettings() {
    return ((RegionHealthAggregationPoliciesStubSettings) getStubSettings())
        .patchOperationSettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<
          TestIamPermissionsRegionHealthAggregationPolicyRequest, TestPermissionsResponse>
      testIamPermissionsSettings() {
    return ((RegionHealthAggregationPoliciesStubSettings) getStubSettings())
        .testIamPermissionsSettings();
  }

  public static final RegionHealthAggregationPoliciesSettings create(
      RegionHealthAggregationPoliciesStubSettings stub) throws IOException {
    return new RegionHealthAggregationPoliciesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RegionHealthAggregationPoliciesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RegionHealthAggregationPoliciesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RegionHealthAggregationPoliciesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RegionHealthAggregationPoliciesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RegionHealthAggregationPoliciesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RegionHealthAggregationPoliciesStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RegionHealthAggregationPoliciesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RegionHealthAggregationPoliciesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RegionHealthAggregationPoliciesSettings. */
  public static class Builder
      extends ClientSettings.Builder<RegionHealthAggregationPoliciesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(RegionHealthAggregationPoliciesStubSettings.newBuilder(clientContext));
    }

    protected Builder(RegionHealthAggregationPoliciesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RegionHealthAggregationPoliciesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(RegionHealthAggregationPoliciesStubSettings.newBuilder());
    }

    public RegionHealthAggregationPoliciesStubSettings.Builder getStubSettingsBuilder() {
      return ((RegionHealthAggregationPoliciesStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListRegionHealthAggregationPoliciesRequest,
            HealthAggregationPolicyAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings() {
      return getStubSettingsBuilder().aggregatedListSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteRegionHealthAggregationPolicyRequest, Operation>
        deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<
            DeleteRegionHealthAggregationPolicyRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<
            GetRegionHealthAggregationPolicyRequest, HealthAggregationPolicy>
        getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertRegionHealthAggregationPolicyRequest, Operation>
        insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<
            InsertRegionHealthAggregationPolicyRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListRegionHealthAggregationPoliciesRequest,
            HealthAggregationPolicyList,
            ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchRegionHealthAggregationPolicyRequest, Operation>
        patchSettings() {
      return getStubSettingsBuilder().patchSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<
            PatchRegionHealthAggregationPolicyRequest, Operation, Operation>
        patchOperationSettings() {
      return getStubSettingsBuilder().patchOperationSettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsRegionHealthAggregationPolicyRequest, TestPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public RegionHealthAggregationPoliciesSettings build() throws IOException {
      return new RegionHealthAggregationPoliciesSettings(this);
    }
  }
}
