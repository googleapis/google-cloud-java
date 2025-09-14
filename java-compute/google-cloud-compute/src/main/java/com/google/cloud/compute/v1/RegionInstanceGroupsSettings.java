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

package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.RegionInstanceGroupsClient.ListInstancesPagedResponse;
import static com.google.cloud.compute.v1.RegionInstanceGroupsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.stub.RegionInstanceGroupsStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RegionInstanceGroupsClient}.
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
 * RegionInstanceGroupsSettings.Builder regionInstanceGroupsSettingsBuilder =
 *     RegionInstanceGroupsSettings.newBuilder();
 * regionInstanceGroupsSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         regionInstanceGroupsSettingsBuilder
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
 * RegionInstanceGroupsSettings regionInstanceGroupsSettings =
 *     regionInstanceGroupsSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for setNamedPorts:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionInstanceGroupsSettings.Builder regionInstanceGroupsSettingsBuilder =
 *     RegionInstanceGroupsSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * regionInstanceGroupsSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RegionInstanceGroupsSettings extends ClientSettings<RegionInstanceGroupsSettings> {

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetRegionInstanceGroupRequest, InstanceGroup> getSettings() {
    return ((RegionInstanceGroupsStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<
          ListRegionInstanceGroupsRequest, RegionInstanceGroupList, ListPagedResponse>
      listSettings() {
    return ((RegionInstanceGroupsStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<
          ListInstancesRegionInstanceGroupsRequest,
          RegionInstanceGroupsListInstances,
          ListInstancesPagedResponse>
      listInstancesSettings() {
    return ((RegionInstanceGroupsStubSettings) getStubSettings()).listInstancesSettings();
  }

  /** Returns the object with the settings used for calls to setNamedPorts. */
  public UnaryCallSettings<SetNamedPortsRegionInstanceGroupRequest, Operation>
      setNamedPortsSettings() {
    return ((RegionInstanceGroupsStubSettings) getStubSettings()).setNamedPortsSettings();
  }

  /** Returns the object with the settings used for calls to setNamedPorts. */
  public OperationCallSettings<SetNamedPortsRegionInstanceGroupRequest, Operation, Operation>
      setNamedPortsOperationSettings() {
    return ((RegionInstanceGroupsStubSettings) getStubSettings()).setNamedPortsOperationSettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRegionInstanceGroupRequest, TestPermissionsResponse>
      testIamPermissionsSettings() {
    return ((RegionInstanceGroupsStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final RegionInstanceGroupsSettings create(RegionInstanceGroupsStubSettings stub)
      throws IOException {
    return new RegionInstanceGroupsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RegionInstanceGroupsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RegionInstanceGroupsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RegionInstanceGroupsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RegionInstanceGroupsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RegionInstanceGroupsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RegionInstanceGroupsStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RegionInstanceGroupsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RegionInstanceGroupsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RegionInstanceGroupsSettings. */
  public static class Builder
      extends ClientSettings.Builder<RegionInstanceGroupsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(RegionInstanceGroupsStubSettings.newBuilder(clientContext));
    }

    protected Builder(RegionInstanceGroupsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RegionInstanceGroupsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(RegionInstanceGroupsStubSettings.newBuilder());
    }

    public RegionInstanceGroupsStubSettings.Builder getStubSettingsBuilder() {
      return ((RegionInstanceGroupsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetRegionInstanceGroupRequest, InstanceGroup> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListRegionInstanceGroupsRequest, RegionInstanceGroupList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to listInstances. */
    public PagedCallSettings.Builder<
            ListInstancesRegionInstanceGroupsRequest,
            RegionInstanceGroupsListInstances,
            ListInstancesPagedResponse>
        listInstancesSettings() {
      return getStubSettingsBuilder().listInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to setNamedPorts. */
    public UnaryCallSettings.Builder<SetNamedPortsRegionInstanceGroupRequest, Operation>
        setNamedPortsSettings() {
      return getStubSettingsBuilder().setNamedPortsSettings();
    }

    /** Returns the builder for the settings used for calls to setNamedPorts. */
    public OperationCallSettings.Builder<
            SetNamedPortsRegionInstanceGroupRequest, Operation, Operation>
        setNamedPortsOperationSettings() {
      return getStubSettingsBuilder().setNamedPortsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsRegionInstanceGroupRequest, TestPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public RegionInstanceGroupsSettings build() throws IOException {
      return new RegionInstanceGroupsSettings(this);
    }
  }
}
