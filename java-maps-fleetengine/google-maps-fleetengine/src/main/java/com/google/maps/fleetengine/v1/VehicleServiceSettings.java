/*
 * Copyright 2023 Google LLC
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

package google.maps.fleetengine.v1;

import static google.maps.fleetengine.v1.VehicleServiceClient.ListVehiclesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import google.maps.fleetengine.v1.stub.VehicleServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link VehicleServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (fleetengine.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createVehicle to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VehicleServiceSettings.Builder vehicleServiceSettingsBuilder =
 *     VehicleServiceSettings.newBuilder();
 * vehicleServiceSettingsBuilder
 *     .createVehicleSettings()
 *     .setRetrySettings(
 *         vehicleServiceSettingsBuilder
 *             .createVehicleSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * VehicleServiceSettings vehicleServiceSettings = vehicleServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class VehicleServiceSettings extends ClientSettings<VehicleServiceSettings> {

  /** Returns the object with the settings used for calls to createVehicle. */
  public UnaryCallSettings<CreateVehicleRequest, Vehicle> createVehicleSettings() {
    return ((VehicleServiceStubSettings) getStubSettings()).createVehicleSettings();
  }

  /** Returns the object with the settings used for calls to getVehicle. */
  public UnaryCallSettings<GetVehicleRequest, Vehicle> getVehicleSettings() {
    return ((VehicleServiceStubSettings) getStubSettings()).getVehicleSettings();
  }

  /** Returns the object with the settings used for calls to updateVehicle. */
  public UnaryCallSettings<UpdateVehicleRequest, Vehicle> updateVehicleSettings() {
    return ((VehicleServiceStubSettings) getStubSettings()).updateVehicleSettings();
  }

  /**
   * Returns the object with the settings used for calls to updateVehicleLocation.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<UpdateVehicleLocationRequest, VehicleLocation>
      updateVehicleLocationSettings() {
    return ((VehicleServiceStubSettings) getStubSettings()).updateVehicleLocationSettings();
  }

  /** Returns the object with the settings used for calls to updateVehicleAttributes. */
  public UnaryCallSettings<UpdateVehicleAttributesRequest, UpdateVehicleAttributesResponse>
      updateVehicleAttributesSettings() {
    return ((VehicleServiceStubSettings) getStubSettings()).updateVehicleAttributesSettings();
  }

  /** Returns the object with the settings used for calls to listVehicles. */
  public PagedCallSettings<ListVehiclesRequest, ListVehiclesResponse, ListVehiclesPagedResponse>
      listVehiclesSettings() {
    return ((VehicleServiceStubSettings) getStubSettings()).listVehiclesSettings();
  }

  /** Returns the object with the settings used for calls to searchVehicles. */
  public UnaryCallSettings<SearchVehiclesRequest, SearchVehiclesResponse> searchVehiclesSettings() {
    return ((VehicleServiceStubSettings) getStubSettings()).searchVehiclesSettings();
  }

  /**
   * Returns the object with the settings used for calls to searchFuzzedVehicles.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<SearchVehiclesRequest, SearchVehiclesResponse>
      searchFuzzedVehiclesSettings() {
    return ((VehicleServiceStubSettings) getStubSettings()).searchFuzzedVehiclesSettings();
  }

  public static final VehicleServiceSettings create(VehicleServiceStubSettings stub)
      throws IOException {
    return new VehicleServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return VehicleServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return VehicleServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return VehicleServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return VehicleServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return VehicleServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return VehicleServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return VehicleServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected VehicleServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for VehicleServiceSettings. */
  public static class Builder extends ClientSettings.Builder<VehicleServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(VehicleServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(VehicleServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(VehicleServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(VehicleServiceStubSettings.newBuilder());
    }

    public VehicleServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((VehicleServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createVehicle. */
    public UnaryCallSettings.Builder<CreateVehicleRequest, Vehicle> createVehicleSettings() {
      return getStubSettingsBuilder().createVehicleSettings();
    }

    /** Returns the builder for the settings used for calls to getVehicle. */
    public UnaryCallSettings.Builder<GetVehicleRequest, Vehicle> getVehicleSettings() {
      return getStubSettingsBuilder().getVehicleSettings();
    }

    /** Returns the builder for the settings used for calls to updateVehicle. */
    public UnaryCallSettings.Builder<UpdateVehicleRequest, Vehicle> updateVehicleSettings() {
      return getStubSettingsBuilder().updateVehicleSettings();
    }

    /**
     * Returns the builder for the settings used for calls to updateVehicleLocation.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<UpdateVehicleLocationRequest, VehicleLocation>
        updateVehicleLocationSettings() {
      return getStubSettingsBuilder().updateVehicleLocationSettings();
    }

    /** Returns the builder for the settings used for calls to updateVehicleAttributes. */
    public UnaryCallSettings.Builder<
            UpdateVehicleAttributesRequest, UpdateVehicleAttributesResponse>
        updateVehicleAttributesSettings() {
      return getStubSettingsBuilder().updateVehicleAttributesSettings();
    }

    /** Returns the builder for the settings used for calls to listVehicles. */
    public PagedCallSettings.Builder<
            ListVehiclesRequest, ListVehiclesResponse, ListVehiclesPagedResponse>
        listVehiclesSettings() {
      return getStubSettingsBuilder().listVehiclesSettings();
    }

    /** Returns the builder for the settings used for calls to searchVehicles. */
    public UnaryCallSettings.Builder<SearchVehiclesRequest, SearchVehiclesResponse>
        searchVehiclesSettings() {
      return getStubSettingsBuilder().searchVehiclesSettings();
    }

    /**
     * Returns the builder for the settings used for calls to searchFuzzedVehicles.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<SearchVehiclesRequest, SearchVehiclesResponse>
        searchFuzzedVehiclesSettings() {
      return getStubSettingsBuilder().searchFuzzedVehiclesSettings();
    }

    @Override
    public VehicleServiceSettings build() throws IOException {
      return new VehicleServiceSettings(this);
    }
  }
}
