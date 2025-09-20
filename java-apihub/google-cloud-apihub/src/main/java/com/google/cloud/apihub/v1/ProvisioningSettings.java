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

package com.google.cloud.apihub.v1;

import static com.google.cloud.apihub.v1.ProvisioningClient.ListLocationsPagedResponse;

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
import com.google.cloud.apihub.v1.stub.ProvisioningStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ProvisioningClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (apihub.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getApiHubInstance:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ProvisioningSettings.Builder provisioningSettingsBuilder = ProvisioningSettings.newBuilder();
 * provisioningSettingsBuilder
 *     .getApiHubInstanceSettings()
 *     .setRetrySettings(
 *         provisioningSettingsBuilder
 *             .getApiHubInstanceSettings()
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
 * ProvisioningSettings provisioningSettings = provisioningSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createApiHubInstance:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ProvisioningSettings.Builder provisioningSettingsBuilder = ProvisioningSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * provisioningSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ProvisioningSettings extends ClientSettings<ProvisioningSettings> {

  /** Returns the object with the settings used for calls to createApiHubInstance. */
  public UnaryCallSettings<CreateApiHubInstanceRequest, Operation> createApiHubInstanceSettings() {
    return ((ProvisioningStubSettings) getStubSettings()).createApiHubInstanceSettings();
  }

  /** Returns the object with the settings used for calls to createApiHubInstance. */
  public OperationCallSettings<CreateApiHubInstanceRequest, ApiHubInstance, OperationMetadata>
      createApiHubInstanceOperationSettings() {
    return ((ProvisioningStubSettings) getStubSettings()).createApiHubInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteApiHubInstance. */
  public UnaryCallSettings<DeleteApiHubInstanceRequest, Operation> deleteApiHubInstanceSettings() {
    return ((ProvisioningStubSettings) getStubSettings()).deleteApiHubInstanceSettings();
  }

  /** Returns the object with the settings used for calls to deleteApiHubInstance. */
  public OperationCallSettings<DeleteApiHubInstanceRequest, Empty, OperationMetadata>
      deleteApiHubInstanceOperationSettings() {
    return ((ProvisioningStubSettings) getStubSettings()).deleteApiHubInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to getApiHubInstance. */
  public UnaryCallSettings<GetApiHubInstanceRequest, ApiHubInstance> getApiHubInstanceSettings() {
    return ((ProvisioningStubSettings) getStubSettings()).getApiHubInstanceSettings();
  }

  /** Returns the object with the settings used for calls to lookupApiHubInstance. */
  public UnaryCallSettings<LookupApiHubInstanceRequest, LookupApiHubInstanceResponse>
      lookupApiHubInstanceSettings() {
    return ((ProvisioningStubSettings) getStubSettings()).lookupApiHubInstanceSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ProvisioningStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ProvisioningStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final ProvisioningSettings create(ProvisioningStubSettings stub)
      throws IOException {
    return new ProvisioningSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ProvisioningStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ProvisioningStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ProvisioningStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ProvisioningStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ProvisioningStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ProvisioningStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ProvisioningStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ProvisioningSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ProvisioningSettings. */
  public static class Builder extends ClientSettings.Builder<ProvisioningSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ProvisioningStubSettings.newBuilder(clientContext));
    }

    protected Builder(ProvisioningSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ProvisioningStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ProvisioningStubSettings.newBuilder());
    }

    public ProvisioningStubSettings.Builder getStubSettingsBuilder() {
      return ((ProvisioningStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createApiHubInstance. */
    public UnaryCallSettings.Builder<CreateApiHubInstanceRequest, Operation>
        createApiHubInstanceSettings() {
      return getStubSettingsBuilder().createApiHubInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to createApiHubInstance. */
    public OperationCallSettings.Builder<
            CreateApiHubInstanceRequest, ApiHubInstance, OperationMetadata>
        createApiHubInstanceOperationSettings() {
      return getStubSettingsBuilder().createApiHubInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteApiHubInstance. */
    public UnaryCallSettings.Builder<DeleteApiHubInstanceRequest, Operation>
        deleteApiHubInstanceSettings() {
      return getStubSettingsBuilder().deleteApiHubInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteApiHubInstance. */
    public OperationCallSettings.Builder<DeleteApiHubInstanceRequest, Empty, OperationMetadata>
        deleteApiHubInstanceOperationSettings() {
      return getStubSettingsBuilder().deleteApiHubInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getApiHubInstance. */
    public UnaryCallSettings.Builder<GetApiHubInstanceRequest, ApiHubInstance>
        getApiHubInstanceSettings() {
      return getStubSettingsBuilder().getApiHubInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to lookupApiHubInstance. */
    public UnaryCallSettings.Builder<LookupApiHubInstanceRequest, LookupApiHubInstanceResponse>
        lookupApiHubInstanceSettings() {
      return getStubSettingsBuilder().lookupApiHubInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    @Override
    public ProvisioningSettings build() throws IOException {
      return new ProvisioningSettings(this);
    }
  }
}
