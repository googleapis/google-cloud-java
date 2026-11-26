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

package com.google.cloud.apihub.v1;

import static com.google.cloud.apihub.v1.ApiHubAddonClient.ListAddonsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubAddonClient.ListLocationsPagedResponse;

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
import com.google.cloud.apihub.v1.stub.ApiHubAddonStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ApiHubAddonClient}.
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
 * of getAddon:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ApiHubAddonSettings.Builder apiHubAddonSettingsBuilder = ApiHubAddonSettings.newBuilder();
 * apiHubAddonSettingsBuilder
 *     .getAddonSettings()
 *     .setRetrySettings(
 *         apiHubAddonSettingsBuilder
 *             .getAddonSettings()
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
 * ApiHubAddonSettings apiHubAddonSettings = apiHubAddonSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for manageAddonConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ApiHubAddonSettings.Builder apiHubAddonSettingsBuilder = ApiHubAddonSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * apiHubAddonSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@NullMarked
@Generated("by gapic-generator-java")
public class ApiHubAddonSettings extends ClientSettings<ApiHubAddonSettings> {

  /** Returns the object with the settings used for calls to getAddon. */
  public UnaryCallSettings<GetAddonRequest, Addon> getAddonSettings() {
    return ((ApiHubAddonStubSettings) getStubSettings()).getAddonSettings();
  }

  /** Returns the object with the settings used for calls to manageAddonConfig. */
  public UnaryCallSettings<ManageAddonConfigRequest, Operation> manageAddonConfigSettings() {
    return ((ApiHubAddonStubSettings) getStubSettings()).manageAddonConfigSettings();
  }

  /** Returns the object with the settings used for calls to manageAddonConfig. */
  public OperationCallSettings<ManageAddonConfigRequest, Addon, OperationMetadata>
      manageAddonConfigOperationSettings() {
    return ((ApiHubAddonStubSettings) getStubSettings()).manageAddonConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to listAddons. */
  public PagedCallSettings<ListAddonsRequest, ListAddonsResponse, ListAddonsPagedResponse>
      listAddonsSettings() {
    return ((ApiHubAddonStubSettings) getStubSettings()).listAddonsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ApiHubAddonStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ApiHubAddonStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final ApiHubAddonSettings create(ApiHubAddonStubSettings stub) throws IOException {
    return new ApiHubAddonSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ApiHubAddonStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ApiHubAddonStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ApiHubAddonStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ApiHubAddonStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ApiHubAddonStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ApiHubAddonStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiHubAddonStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected ApiHubAddonSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ApiHubAddonSettings. */
  public static class Builder extends ClientSettings.Builder<ApiHubAddonSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(ApiHubAddonStubSettings.newBuilder(clientContext));
    }

    protected Builder(ApiHubAddonSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ApiHubAddonStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ApiHubAddonStubSettings.newBuilder());
    }

    public ApiHubAddonStubSettings.Builder getStubSettingsBuilder() {
      return ((ApiHubAddonStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getAddon. */
    public UnaryCallSettings.Builder<GetAddonRequest, Addon> getAddonSettings() {
      return getStubSettingsBuilder().getAddonSettings();
    }

    /** Returns the builder for the settings used for calls to manageAddonConfig. */
    public UnaryCallSettings.Builder<ManageAddonConfigRequest, Operation>
        manageAddonConfigSettings() {
      return getStubSettingsBuilder().manageAddonConfigSettings();
    }

    /** Returns the builder for the settings used for calls to manageAddonConfig. */
    public OperationCallSettings.Builder<ManageAddonConfigRequest, Addon, OperationMetadata>
        manageAddonConfigOperationSettings() {
      return getStubSettingsBuilder().manageAddonConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listAddons. */
    public PagedCallSettings.Builder<ListAddonsRequest, ListAddonsResponse, ListAddonsPagedResponse>
        listAddonsSettings() {
      return getStubSettingsBuilder().listAddonsSettings();
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
    public ApiHubAddonSettings build() throws IOException {
      return new ApiHubAddonSettings(this);
    }
  }
}
