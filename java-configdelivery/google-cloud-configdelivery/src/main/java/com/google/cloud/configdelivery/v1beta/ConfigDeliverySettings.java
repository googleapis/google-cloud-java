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

package com.google.cloud.configdelivery.v1beta;

import static com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient.ListFleetPackagesPagedResponse;
import static com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient.ListLocationsPagedResponse;
import static com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient.ListReleasesPagedResponse;
import static com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient.ListResourceBundlesPagedResponse;
import static com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient.ListRolloutsPagedResponse;
import static com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient.ListVariantsPagedResponse;

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
import com.google.cloud.configdelivery.v1beta.stub.ConfigDeliveryStubSettings;
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
 * Settings class to configure an instance of {@link ConfigDeliveryClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (configdelivery.googleapis.com) and default port (443) are
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
 * of getResourceBundle:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConfigDeliverySettings.Builder configDeliverySettingsBuilder =
 *     ConfigDeliverySettings.newBuilder();
 * configDeliverySettingsBuilder
 *     .getResourceBundleSettings()
 *     .setRetrySettings(
 *         configDeliverySettingsBuilder
 *             .getResourceBundleSettings()
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
 * ConfigDeliverySettings configDeliverySettings = configDeliverySettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createResourceBundle:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConfigDeliverySettings.Builder configDeliverySettingsBuilder =
 *     ConfigDeliverySettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * configDeliverySettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ConfigDeliverySettings extends ClientSettings<ConfigDeliverySettings> {

  /** Returns the object with the settings used for calls to listResourceBundles. */
  public PagedCallSettings<
          ListResourceBundlesRequest, ListResourceBundlesResponse, ListResourceBundlesPagedResponse>
      listResourceBundlesSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).listResourceBundlesSettings();
  }

  /** Returns the object with the settings used for calls to getResourceBundle. */
  public UnaryCallSettings<GetResourceBundleRequest, ResourceBundle> getResourceBundleSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).getResourceBundleSettings();
  }

  /** Returns the object with the settings used for calls to createResourceBundle. */
  public UnaryCallSettings<CreateResourceBundleRequest, Operation> createResourceBundleSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).createResourceBundleSettings();
  }

  /** Returns the object with the settings used for calls to createResourceBundle. */
  public OperationCallSettings<CreateResourceBundleRequest, ResourceBundle, OperationMetadata>
      createResourceBundleOperationSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).createResourceBundleOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateResourceBundle. */
  public UnaryCallSettings<UpdateResourceBundleRequest, Operation> updateResourceBundleSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).updateResourceBundleSettings();
  }

  /** Returns the object with the settings used for calls to updateResourceBundle. */
  public OperationCallSettings<UpdateResourceBundleRequest, ResourceBundle, OperationMetadata>
      updateResourceBundleOperationSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).updateResourceBundleOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteResourceBundle. */
  public UnaryCallSettings<DeleteResourceBundleRequest, Operation> deleteResourceBundleSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).deleteResourceBundleSettings();
  }

  /** Returns the object with the settings used for calls to deleteResourceBundle. */
  public OperationCallSettings<DeleteResourceBundleRequest, Empty, OperationMetadata>
      deleteResourceBundleOperationSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).deleteResourceBundleOperationSettings();
  }

  /** Returns the object with the settings used for calls to listFleetPackages. */
  public PagedCallSettings<
          ListFleetPackagesRequest, ListFleetPackagesResponse, ListFleetPackagesPagedResponse>
      listFleetPackagesSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).listFleetPackagesSettings();
  }

  /** Returns the object with the settings used for calls to getFleetPackage. */
  public UnaryCallSettings<GetFleetPackageRequest, FleetPackage> getFleetPackageSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).getFleetPackageSettings();
  }

  /** Returns the object with the settings used for calls to createFleetPackage. */
  public UnaryCallSettings<CreateFleetPackageRequest, Operation> createFleetPackageSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).createFleetPackageSettings();
  }

  /** Returns the object with the settings used for calls to createFleetPackage. */
  public OperationCallSettings<CreateFleetPackageRequest, FleetPackage, OperationMetadata>
      createFleetPackageOperationSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).createFleetPackageOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateFleetPackage. */
  public UnaryCallSettings<UpdateFleetPackageRequest, Operation> updateFleetPackageSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).updateFleetPackageSettings();
  }

  /** Returns the object with the settings used for calls to updateFleetPackage. */
  public OperationCallSettings<UpdateFleetPackageRequest, FleetPackage, OperationMetadata>
      updateFleetPackageOperationSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).updateFleetPackageOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteFleetPackage. */
  public UnaryCallSettings<DeleteFleetPackageRequest, Operation> deleteFleetPackageSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).deleteFleetPackageSettings();
  }

  /** Returns the object with the settings used for calls to deleteFleetPackage. */
  public OperationCallSettings<DeleteFleetPackageRequest, Empty, OperationMetadata>
      deleteFleetPackageOperationSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).deleteFleetPackageOperationSettings();
  }

  /** Returns the object with the settings used for calls to listReleases. */
  public PagedCallSettings<ListReleasesRequest, ListReleasesResponse, ListReleasesPagedResponse>
      listReleasesSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).listReleasesSettings();
  }

  /** Returns the object with the settings used for calls to getRelease. */
  public UnaryCallSettings<GetReleaseRequest, Release> getReleaseSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).getReleaseSettings();
  }

  /** Returns the object with the settings used for calls to createRelease. */
  public UnaryCallSettings<CreateReleaseRequest, Operation> createReleaseSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).createReleaseSettings();
  }

  /** Returns the object with the settings used for calls to createRelease. */
  public OperationCallSettings<CreateReleaseRequest, Release, OperationMetadata>
      createReleaseOperationSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).createReleaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateRelease. */
  public UnaryCallSettings<UpdateReleaseRequest, Operation> updateReleaseSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).updateReleaseSettings();
  }

  /** Returns the object with the settings used for calls to updateRelease. */
  public OperationCallSettings<UpdateReleaseRequest, Release, OperationMetadata>
      updateReleaseOperationSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).updateReleaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteRelease. */
  public UnaryCallSettings<DeleteReleaseRequest, Operation> deleteReleaseSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).deleteReleaseSettings();
  }

  /** Returns the object with the settings used for calls to deleteRelease. */
  public OperationCallSettings<DeleteReleaseRequest, Empty, OperationMetadata>
      deleteReleaseOperationSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).deleteReleaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to listVariants. */
  public PagedCallSettings<ListVariantsRequest, ListVariantsResponse, ListVariantsPagedResponse>
      listVariantsSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).listVariantsSettings();
  }

  /** Returns the object with the settings used for calls to getVariant. */
  public UnaryCallSettings<GetVariantRequest, Variant> getVariantSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).getVariantSettings();
  }

  /** Returns the object with the settings used for calls to createVariant. */
  public UnaryCallSettings<CreateVariantRequest, Operation> createVariantSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).createVariantSettings();
  }

  /** Returns the object with the settings used for calls to createVariant. */
  public OperationCallSettings<CreateVariantRequest, Variant, OperationMetadata>
      createVariantOperationSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).createVariantOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateVariant. */
  public UnaryCallSettings<UpdateVariantRequest, Operation> updateVariantSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).updateVariantSettings();
  }

  /** Returns the object with the settings used for calls to updateVariant. */
  public OperationCallSettings<UpdateVariantRequest, Variant, OperationMetadata>
      updateVariantOperationSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).updateVariantOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteVariant. */
  public UnaryCallSettings<DeleteVariantRequest, Operation> deleteVariantSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).deleteVariantSettings();
  }

  /** Returns the object with the settings used for calls to deleteVariant. */
  public OperationCallSettings<DeleteVariantRequest, Empty, OperationMetadata>
      deleteVariantOperationSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).deleteVariantOperationSettings();
  }

  /** Returns the object with the settings used for calls to listRollouts. */
  public PagedCallSettings<ListRolloutsRequest, ListRolloutsResponse, ListRolloutsPagedResponse>
      listRolloutsSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).listRolloutsSettings();
  }

  /** Returns the object with the settings used for calls to getRollout. */
  public UnaryCallSettings<GetRolloutRequest, Rollout> getRolloutSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).getRolloutSettings();
  }

  /** Returns the object with the settings used for calls to suspendRollout. */
  public UnaryCallSettings<SuspendRolloutRequest, Operation> suspendRolloutSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).suspendRolloutSettings();
  }

  /** Returns the object with the settings used for calls to suspendRollout. */
  public OperationCallSettings<SuspendRolloutRequest, Rollout, OperationMetadata>
      suspendRolloutOperationSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).suspendRolloutOperationSettings();
  }

  /** Returns the object with the settings used for calls to resumeRollout. */
  public UnaryCallSettings<ResumeRolloutRequest, Operation> resumeRolloutSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).resumeRolloutSettings();
  }

  /** Returns the object with the settings used for calls to resumeRollout. */
  public OperationCallSettings<ResumeRolloutRequest, Rollout, OperationMetadata>
      resumeRolloutOperationSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).resumeRolloutOperationSettings();
  }

  /** Returns the object with the settings used for calls to abortRollout. */
  public UnaryCallSettings<AbortRolloutRequest, Operation> abortRolloutSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).abortRolloutSettings();
  }

  /** Returns the object with the settings used for calls to abortRollout. */
  public OperationCallSettings<AbortRolloutRequest, Rollout, OperationMetadata>
      abortRolloutOperationSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).abortRolloutOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ConfigDeliveryStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final ConfigDeliverySettings create(ConfigDeliveryStubSettings stub)
      throws IOException {
    return new ConfigDeliverySettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ConfigDeliveryStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ConfigDeliveryStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ConfigDeliveryStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ConfigDeliveryStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ConfigDeliveryStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ConfigDeliveryStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ConfigDeliveryStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ConfigDeliveryStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ConfigDeliverySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ConfigDeliverySettings. */
  public static class Builder extends ClientSettings.Builder<ConfigDeliverySettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ConfigDeliveryStubSettings.newBuilder(clientContext));
    }

    protected Builder(ConfigDeliverySettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ConfigDeliveryStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ConfigDeliveryStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(ConfigDeliveryStubSettings.newHttpJsonBuilder());
    }

    public ConfigDeliveryStubSettings.Builder getStubSettingsBuilder() {
      return ((ConfigDeliveryStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listResourceBundles. */
    public PagedCallSettings.Builder<
            ListResourceBundlesRequest,
            ListResourceBundlesResponse,
            ListResourceBundlesPagedResponse>
        listResourceBundlesSettings() {
      return getStubSettingsBuilder().listResourceBundlesSettings();
    }

    /** Returns the builder for the settings used for calls to getResourceBundle. */
    public UnaryCallSettings.Builder<GetResourceBundleRequest, ResourceBundle>
        getResourceBundleSettings() {
      return getStubSettingsBuilder().getResourceBundleSettings();
    }

    /** Returns the builder for the settings used for calls to createResourceBundle. */
    public UnaryCallSettings.Builder<CreateResourceBundleRequest, Operation>
        createResourceBundleSettings() {
      return getStubSettingsBuilder().createResourceBundleSettings();
    }

    /** Returns the builder for the settings used for calls to createResourceBundle. */
    public OperationCallSettings.Builder<
            CreateResourceBundleRequest, ResourceBundle, OperationMetadata>
        createResourceBundleOperationSettings() {
      return getStubSettingsBuilder().createResourceBundleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateResourceBundle. */
    public UnaryCallSettings.Builder<UpdateResourceBundleRequest, Operation>
        updateResourceBundleSettings() {
      return getStubSettingsBuilder().updateResourceBundleSettings();
    }

    /** Returns the builder for the settings used for calls to updateResourceBundle. */
    public OperationCallSettings.Builder<
            UpdateResourceBundleRequest, ResourceBundle, OperationMetadata>
        updateResourceBundleOperationSettings() {
      return getStubSettingsBuilder().updateResourceBundleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteResourceBundle. */
    public UnaryCallSettings.Builder<DeleteResourceBundleRequest, Operation>
        deleteResourceBundleSettings() {
      return getStubSettingsBuilder().deleteResourceBundleSettings();
    }

    /** Returns the builder for the settings used for calls to deleteResourceBundle. */
    public OperationCallSettings.Builder<DeleteResourceBundleRequest, Empty, OperationMetadata>
        deleteResourceBundleOperationSettings() {
      return getStubSettingsBuilder().deleteResourceBundleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listFleetPackages. */
    public PagedCallSettings.Builder<
            ListFleetPackagesRequest, ListFleetPackagesResponse, ListFleetPackagesPagedResponse>
        listFleetPackagesSettings() {
      return getStubSettingsBuilder().listFleetPackagesSettings();
    }

    /** Returns the builder for the settings used for calls to getFleetPackage. */
    public UnaryCallSettings.Builder<GetFleetPackageRequest, FleetPackage>
        getFleetPackageSettings() {
      return getStubSettingsBuilder().getFleetPackageSettings();
    }

    /** Returns the builder for the settings used for calls to createFleetPackage. */
    public UnaryCallSettings.Builder<CreateFleetPackageRequest, Operation>
        createFleetPackageSettings() {
      return getStubSettingsBuilder().createFleetPackageSettings();
    }

    /** Returns the builder for the settings used for calls to createFleetPackage. */
    public OperationCallSettings.Builder<CreateFleetPackageRequest, FleetPackage, OperationMetadata>
        createFleetPackageOperationSettings() {
      return getStubSettingsBuilder().createFleetPackageOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateFleetPackage. */
    public UnaryCallSettings.Builder<UpdateFleetPackageRequest, Operation>
        updateFleetPackageSettings() {
      return getStubSettingsBuilder().updateFleetPackageSettings();
    }

    /** Returns the builder for the settings used for calls to updateFleetPackage. */
    public OperationCallSettings.Builder<UpdateFleetPackageRequest, FleetPackage, OperationMetadata>
        updateFleetPackageOperationSettings() {
      return getStubSettingsBuilder().updateFleetPackageOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFleetPackage. */
    public UnaryCallSettings.Builder<DeleteFleetPackageRequest, Operation>
        deleteFleetPackageSettings() {
      return getStubSettingsBuilder().deleteFleetPackageSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFleetPackage. */
    public OperationCallSettings.Builder<DeleteFleetPackageRequest, Empty, OperationMetadata>
        deleteFleetPackageOperationSettings() {
      return getStubSettingsBuilder().deleteFleetPackageOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listReleases. */
    public PagedCallSettings.Builder<
            ListReleasesRequest, ListReleasesResponse, ListReleasesPagedResponse>
        listReleasesSettings() {
      return getStubSettingsBuilder().listReleasesSettings();
    }

    /** Returns the builder for the settings used for calls to getRelease. */
    public UnaryCallSettings.Builder<GetReleaseRequest, Release> getReleaseSettings() {
      return getStubSettingsBuilder().getReleaseSettings();
    }

    /** Returns the builder for the settings used for calls to createRelease. */
    public UnaryCallSettings.Builder<CreateReleaseRequest, Operation> createReleaseSettings() {
      return getStubSettingsBuilder().createReleaseSettings();
    }

    /** Returns the builder for the settings used for calls to createRelease. */
    public OperationCallSettings.Builder<CreateReleaseRequest, Release, OperationMetadata>
        createReleaseOperationSettings() {
      return getStubSettingsBuilder().createReleaseOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateRelease. */
    public UnaryCallSettings.Builder<UpdateReleaseRequest, Operation> updateReleaseSettings() {
      return getStubSettingsBuilder().updateReleaseSettings();
    }

    /** Returns the builder for the settings used for calls to updateRelease. */
    public OperationCallSettings.Builder<UpdateReleaseRequest, Release, OperationMetadata>
        updateReleaseOperationSettings() {
      return getStubSettingsBuilder().updateReleaseOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRelease. */
    public UnaryCallSettings.Builder<DeleteReleaseRequest, Operation> deleteReleaseSettings() {
      return getStubSettingsBuilder().deleteReleaseSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRelease. */
    public OperationCallSettings.Builder<DeleteReleaseRequest, Empty, OperationMetadata>
        deleteReleaseOperationSettings() {
      return getStubSettingsBuilder().deleteReleaseOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listVariants. */
    public PagedCallSettings.Builder<
            ListVariantsRequest, ListVariantsResponse, ListVariantsPagedResponse>
        listVariantsSettings() {
      return getStubSettingsBuilder().listVariantsSettings();
    }

    /** Returns the builder for the settings used for calls to getVariant. */
    public UnaryCallSettings.Builder<GetVariantRequest, Variant> getVariantSettings() {
      return getStubSettingsBuilder().getVariantSettings();
    }

    /** Returns the builder for the settings used for calls to createVariant. */
    public UnaryCallSettings.Builder<CreateVariantRequest, Operation> createVariantSettings() {
      return getStubSettingsBuilder().createVariantSettings();
    }

    /** Returns the builder for the settings used for calls to createVariant. */
    public OperationCallSettings.Builder<CreateVariantRequest, Variant, OperationMetadata>
        createVariantOperationSettings() {
      return getStubSettingsBuilder().createVariantOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateVariant. */
    public UnaryCallSettings.Builder<UpdateVariantRequest, Operation> updateVariantSettings() {
      return getStubSettingsBuilder().updateVariantSettings();
    }

    /** Returns the builder for the settings used for calls to updateVariant. */
    public OperationCallSettings.Builder<UpdateVariantRequest, Variant, OperationMetadata>
        updateVariantOperationSettings() {
      return getStubSettingsBuilder().updateVariantOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteVariant. */
    public UnaryCallSettings.Builder<DeleteVariantRequest, Operation> deleteVariantSettings() {
      return getStubSettingsBuilder().deleteVariantSettings();
    }

    /** Returns the builder for the settings used for calls to deleteVariant. */
    public OperationCallSettings.Builder<DeleteVariantRequest, Empty, OperationMetadata>
        deleteVariantOperationSettings() {
      return getStubSettingsBuilder().deleteVariantOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listRollouts. */
    public PagedCallSettings.Builder<
            ListRolloutsRequest, ListRolloutsResponse, ListRolloutsPagedResponse>
        listRolloutsSettings() {
      return getStubSettingsBuilder().listRolloutsSettings();
    }

    /** Returns the builder for the settings used for calls to getRollout. */
    public UnaryCallSettings.Builder<GetRolloutRequest, Rollout> getRolloutSettings() {
      return getStubSettingsBuilder().getRolloutSettings();
    }

    /** Returns the builder for the settings used for calls to suspendRollout. */
    public UnaryCallSettings.Builder<SuspendRolloutRequest, Operation> suspendRolloutSettings() {
      return getStubSettingsBuilder().suspendRolloutSettings();
    }

    /** Returns the builder for the settings used for calls to suspendRollout. */
    public OperationCallSettings.Builder<SuspendRolloutRequest, Rollout, OperationMetadata>
        suspendRolloutOperationSettings() {
      return getStubSettingsBuilder().suspendRolloutOperationSettings();
    }

    /** Returns the builder for the settings used for calls to resumeRollout. */
    public UnaryCallSettings.Builder<ResumeRolloutRequest, Operation> resumeRolloutSettings() {
      return getStubSettingsBuilder().resumeRolloutSettings();
    }

    /** Returns the builder for the settings used for calls to resumeRollout. */
    public OperationCallSettings.Builder<ResumeRolloutRequest, Rollout, OperationMetadata>
        resumeRolloutOperationSettings() {
      return getStubSettingsBuilder().resumeRolloutOperationSettings();
    }

    /** Returns the builder for the settings used for calls to abortRollout. */
    public UnaryCallSettings.Builder<AbortRolloutRequest, Operation> abortRolloutSettings() {
      return getStubSettingsBuilder().abortRolloutSettings();
    }

    /** Returns the builder for the settings used for calls to abortRollout. */
    public OperationCallSettings.Builder<AbortRolloutRequest, Rollout, OperationMetadata>
        abortRolloutOperationSettings() {
      return getStubSettingsBuilder().abortRolloutOperationSettings();
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
    public ConfigDeliverySettings build() throws IOException {
      return new ConfigDeliverySettings(this);
    }
  }
}
