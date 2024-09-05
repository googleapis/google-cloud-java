/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.apihub.v1.HostProjectRegistrationServiceClient.ListHostProjectRegistrationsPagedResponse;
import static com.google.cloud.apihub.v1.HostProjectRegistrationServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.apihub.v1.stub.HostProjectRegistrationServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link HostProjectRegistrationServiceClient}.
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
 * <p>For example, to set the total timeout of createHostProjectRegistration to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * HostProjectRegistrationServiceSettings.Builder hostProjectRegistrationServiceSettingsBuilder =
 *     HostProjectRegistrationServiceSettings.newBuilder();
 * hostProjectRegistrationServiceSettingsBuilder
 *     .createHostProjectRegistrationSettings()
 *     .setRetrySettings(
 *         hostProjectRegistrationServiceSettingsBuilder
 *             .createHostProjectRegistrationSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * HostProjectRegistrationServiceSettings hostProjectRegistrationServiceSettings =
 *     hostProjectRegistrationServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class HostProjectRegistrationServiceSettings
    extends ClientSettings<HostProjectRegistrationServiceSettings> {

  /** Returns the object with the settings used for calls to createHostProjectRegistration. */
  public UnaryCallSettings<CreateHostProjectRegistrationRequest, HostProjectRegistration>
      createHostProjectRegistrationSettings() {
    return ((HostProjectRegistrationServiceStubSettings) getStubSettings())
        .createHostProjectRegistrationSettings();
  }

  /** Returns the object with the settings used for calls to getHostProjectRegistration. */
  public UnaryCallSettings<GetHostProjectRegistrationRequest, HostProjectRegistration>
      getHostProjectRegistrationSettings() {
    return ((HostProjectRegistrationServiceStubSettings) getStubSettings())
        .getHostProjectRegistrationSettings();
  }

  /** Returns the object with the settings used for calls to listHostProjectRegistrations. */
  public PagedCallSettings<
          ListHostProjectRegistrationsRequest,
          ListHostProjectRegistrationsResponse,
          ListHostProjectRegistrationsPagedResponse>
      listHostProjectRegistrationsSettings() {
    return ((HostProjectRegistrationServiceStubSettings) getStubSettings())
        .listHostProjectRegistrationsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((HostProjectRegistrationServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((HostProjectRegistrationServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final HostProjectRegistrationServiceSettings create(
      HostProjectRegistrationServiceStubSettings stub) throws IOException {
    return new HostProjectRegistrationServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return HostProjectRegistrationServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return HostProjectRegistrationServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return HostProjectRegistrationServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return HostProjectRegistrationServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return HostProjectRegistrationServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return HostProjectRegistrationServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return HostProjectRegistrationServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected HostProjectRegistrationServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for HostProjectRegistrationServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<HostProjectRegistrationServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(HostProjectRegistrationServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(HostProjectRegistrationServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(HostProjectRegistrationServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(HostProjectRegistrationServiceStubSettings.newBuilder());
    }

    public HostProjectRegistrationServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((HostProjectRegistrationServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createHostProjectRegistration. */
    public UnaryCallSettings.Builder<CreateHostProjectRegistrationRequest, HostProjectRegistration>
        createHostProjectRegistrationSettings() {
      return getStubSettingsBuilder().createHostProjectRegistrationSettings();
    }

    /** Returns the builder for the settings used for calls to getHostProjectRegistration. */
    public UnaryCallSettings.Builder<GetHostProjectRegistrationRequest, HostProjectRegistration>
        getHostProjectRegistrationSettings() {
      return getStubSettingsBuilder().getHostProjectRegistrationSettings();
    }

    /** Returns the builder for the settings used for calls to listHostProjectRegistrations. */
    public PagedCallSettings.Builder<
            ListHostProjectRegistrationsRequest,
            ListHostProjectRegistrationsResponse,
            ListHostProjectRegistrationsPagedResponse>
        listHostProjectRegistrationsSettings() {
      return getStubSettingsBuilder().listHostProjectRegistrationsSettings();
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
    public HostProjectRegistrationServiceSettings build() throws IOException {
      return new HostProjectRegistrationServiceSettings(this);
    }
  }
}
