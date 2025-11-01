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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.PlacementServiceClient.ListPlacementsPagedResponse;

import com.google.ads.admanager.v1.stub.PlacementServiceStubSettings;
import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PlacementServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (admanager.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getPlacement:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PlacementServiceSettings.Builder placementServiceSettingsBuilder =
 *     PlacementServiceSettings.newBuilder();
 * placementServiceSettingsBuilder
 *     .getPlacementSettings()
 *     .setRetrySettings(
 *         placementServiceSettingsBuilder
 *             .getPlacementSettings()
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
 * PlacementServiceSettings placementServiceSettings = placementServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class PlacementServiceSettings extends ClientSettings<PlacementServiceSettings> {

  /** Returns the object with the settings used for calls to getPlacement. */
  public UnaryCallSettings<GetPlacementRequest, Placement> getPlacementSettings() {
    return ((PlacementServiceStubSettings) getStubSettings()).getPlacementSettings();
  }

  /** Returns the object with the settings used for calls to listPlacements. */
  public PagedCallSettings<
          ListPlacementsRequest, ListPlacementsResponse, ListPlacementsPagedResponse>
      listPlacementsSettings() {
    return ((PlacementServiceStubSettings) getStubSettings()).listPlacementsSettings();
  }

  /** Returns the object with the settings used for calls to createPlacement. */
  public UnaryCallSettings<CreatePlacementRequest, Placement> createPlacementSettings() {
    return ((PlacementServiceStubSettings) getStubSettings()).createPlacementSettings();
  }

  /** Returns the object with the settings used for calls to updatePlacement. */
  public UnaryCallSettings<UpdatePlacementRequest, Placement> updatePlacementSettings() {
    return ((PlacementServiceStubSettings) getStubSettings()).updatePlacementSettings();
  }

  /** Returns the object with the settings used for calls to batchCreatePlacements. */
  public UnaryCallSettings<BatchCreatePlacementsRequest, BatchCreatePlacementsResponse>
      batchCreatePlacementsSettings() {
    return ((PlacementServiceStubSettings) getStubSettings()).batchCreatePlacementsSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdatePlacements. */
  public UnaryCallSettings<BatchUpdatePlacementsRequest, BatchUpdatePlacementsResponse>
      batchUpdatePlacementsSettings() {
    return ((PlacementServiceStubSettings) getStubSettings()).batchUpdatePlacementsSettings();
  }

  /** Returns the object with the settings used for calls to batchActivatePlacements. */
  public UnaryCallSettings<BatchActivatePlacementsRequest, BatchActivatePlacementsResponse>
      batchActivatePlacementsSettings() {
    return ((PlacementServiceStubSettings) getStubSettings()).batchActivatePlacementsSettings();
  }

  /** Returns the object with the settings used for calls to batchDeactivatePlacements. */
  public UnaryCallSettings<BatchDeactivatePlacementsRequest, BatchDeactivatePlacementsResponse>
      batchDeactivatePlacementsSettings() {
    return ((PlacementServiceStubSettings) getStubSettings()).batchDeactivatePlacementsSettings();
  }

  /** Returns the object with the settings used for calls to batchArchivePlacements. */
  public UnaryCallSettings<BatchArchivePlacementsRequest, BatchArchivePlacementsResponse>
      batchArchivePlacementsSettings() {
    return ((PlacementServiceStubSettings) getStubSettings()).batchArchivePlacementsSettings();
  }

  public static final PlacementServiceSettings create(PlacementServiceStubSettings stub)
      throws IOException {
    return new PlacementServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return PlacementServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return PlacementServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return PlacementServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return PlacementServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return PlacementServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return PlacementServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PlacementServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected PlacementServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for PlacementServiceSettings. */
  public static class Builder extends ClientSettings.Builder<PlacementServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(PlacementServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(PlacementServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(PlacementServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(PlacementServiceStubSettings.newBuilder());
    }

    public PlacementServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((PlacementServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getPlacement. */
    public UnaryCallSettings.Builder<GetPlacementRequest, Placement> getPlacementSettings() {
      return getStubSettingsBuilder().getPlacementSettings();
    }

    /** Returns the builder for the settings used for calls to listPlacements. */
    public PagedCallSettings.Builder<
            ListPlacementsRequest, ListPlacementsResponse, ListPlacementsPagedResponse>
        listPlacementsSettings() {
      return getStubSettingsBuilder().listPlacementsSettings();
    }

    /** Returns the builder for the settings used for calls to createPlacement. */
    public UnaryCallSettings.Builder<CreatePlacementRequest, Placement> createPlacementSettings() {
      return getStubSettingsBuilder().createPlacementSettings();
    }

    /** Returns the builder for the settings used for calls to updatePlacement. */
    public UnaryCallSettings.Builder<UpdatePlacementRequest, Placement> updatePlacementSettings() {
      return getStubSettingsBuilder().updatePlacementSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreatePlacements. */
    public UnaryCallSettings.Builder<BatchCreatePlacementsRequest, BatchCreatePlacementsResponse>
        batchCreatePlacementsSettings() {
      return getStubSettingsBuilder().batchCreatePlacementsSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdatePlacements. */
    public UnaryCallSettings.Builder<BatchUpdatePlacementsRequest, BatchUpdatePlacementsResponse>
        batchUpdatePlacementsSettings() {
      return getStubSettingsBuilder().batchUpdatePlacementsSettings();
    }

    /** Returns the builder for the settings used for calls to batchActivatePlacements. */
    public UnaryCallSettings.Builder<
            BatchActivatePlacementsRequest, BatchActivatePlacementsResponse>
        batchActivatePlacementsSettings() {
      return getStubSettingsBuilder().batchActivatePlacementsSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeactivatePlacements. */
    public UnaryCallSettings.Builder<
            BatchDeactivatePlacementsRequest, BatchDeactivatePlacementsResponse>
        batchDeactivatePlacementsSettings() {
      return getStubSettingsBuilder().batchDeactivatePlacementsSettings();
    }

    /** Returns the builder for the settings used for calls to batchArchivePlacements. */
    public UnaryCallSettings.Builder<BatchArchivePlacementsRequest, BatchArchivePlacementsResponse>
        batchArchivePlacementsSettings() {
      return getStubSettingsBuilder().batchArchivePlacementsSettings();
    }

    @Override
    public PlacementServiceSettings build() throws IOException {
      return new PlacementServiceSettings(this);
    }
  }
}
