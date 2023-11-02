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

import static google.maps.fleetengine.v1.TripServiceClient.SearchTripsPagedResponse;

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
import com.google.protobuf.Empty;
import google.maps.fleetengine.v1.stub.TripServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TripServiceClient}.
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
 * <p>For example, to set the total timeout of createTrip to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TripServiceSettings.Builder tripServiceSettingsBuilder = TripServiceSettings.newBuilder();
 * tripServiceSettingsBuilder
 *     .createTripSettings()
 *     .setRetrySettings(
 *         tripServiceSettingsBuilder
 *             .createTripSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TripServiceSettings tripServiceSettings = tripServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TripServiceSettings extends ClientSettings<TripServiceSettings> {

  /** Returns the object with the settings used for calls to createTrip. */
  public UnaryCallSettings<CreateTripRequest, Trip> createTripSettings() {
    return ((TripServiceStubSettings) getStubSettings()).createTripSettings();
  }

  /** Returns the object with the settings used for calls to getTrip. */
  public UnaryCallSettings<GetTripRequest, Trip> getTripSettings() {
    return ((TripServiceStubSettings) getStubSettings()).getTripSettings();
  }

  /** Returns the object with the settings used for calls to reportBillableTrip. */
  public UnaryCallSettings<ReportBillableTripRequest, Empty> reportBillableTripSettings() {
    return ((TripServiceStubSettings) getStubSettings()).reportBillableTripSettings();
  }

  /** Returns the object with the settings used for calls to searchTrips. */
  public PagedCallSettings<SearchTripsRequest, SearchTripsResponse, SearchTripsPagedResponse>
      searchTripsSettings() {
    return ((TripServiceStubSettings) getStubSettings()).searchTripsSettings();
  }

  /** Returns the object with the settings used for calls to updateTrip. */
  public UnaryCallSettings<UpdateTripRequest, Trip> updateTripSettings() {
    return ((TripServiceStubSettings) getStubSettings()).updateTripSettings();
  }

  public static final TripServiceSettings create(TripServiceStubSettings stub) throws IOException {
    return new TripServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return TripServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return TripServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return TripServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return TripServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return TripServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TripServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TripServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected TripServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for TripServiceSettings. */
  public static class Builder extends ClientSettings.Builder<TripServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(TripServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(TripServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(TripServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(TripServiceStubSettings.newBuilder());
    }

    public TripServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((TripServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createTrip. */
    public UnaryCallSettings.Builder<CreateTripRequest, Trip> createTripSettings() {
      return getStubSettingsBuilder().createTripSettings();
    }

    /** Returns the builder for the settings used for calls to getTrip. */
    public UnaryCallSettings.Builder<GetTripRequest, Trip> getTripSettings() {
      return getStubSettingsBuilder().getTripSettings();
    }

    /** Returns the builder for the settings used for calls to reportBillableTrip. */
    public UnaryCallSettings.Builder<ReportBillableTripRequest, Empty>
        reportBillableTripSettings() {
      return getStubSettingsBuilder().reportBillableTripSettings();
    }

    /** Returns the builder for the settings used for calls to searchTrips. */
    public PagedCallSettings.Builder<
            SearchTripsRequest, SearchTripsResponse, SearchTripsPagedResponse>
        searchTripsSettings() {
      return getStubSettingsBuilder().searchTripsSettings();
    }

    /** Returns the builder for the settings used for calls to updateTrip. */
    public UnaryCallSettings.Builder<UpdateTripRequest, Trip> updateTripSettings() {
      return getStubSettingsBuilder().updateTripSettings();
    }

    @Override
    public TripServiceSettings build() throws IOException {
      return new TripServiceSettings(this);
    }
  }
}
