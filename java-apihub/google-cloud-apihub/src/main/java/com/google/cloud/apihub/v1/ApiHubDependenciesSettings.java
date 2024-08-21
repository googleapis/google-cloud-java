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

import static com.google.cloud.apihub.v1.ApiHubDependenciesClient.ListDependenciesPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubDependenciesClient.ListLocationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.apihub.v1.stub.ApiHubDependenciesStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ApiHubDependenciesClient}.
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
 * <p>For example, to set the total timeout of createDependency to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ApiHubDependenciesSettings.Builder apiHubDependenciesSettingsBuilder =
 *     ApiHubDependenciesSettings.newBuilder();
 * apiHubDependenciesSettingsBuilder
 *     .createDependencySettings()
 *     .setRetrySettings(
 *         apiHubDependenciesSettingsBuilder
 *             .createDependencySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ApiHubDependenciesSettings apiHubDependenciesSettings =
 *     apiHubDependenciesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ApiHubDependenciesSettings extends ClientSettings<ApiHubDependenciesSettings> {

  /** Returns the object with the settings used for calls to createDependency. */
  public UnaryCallSettings<CreateDependencyRequest, Dependency> createDependencySettings() {
    return ((ApiHubDependenciesStubSettings) getStubSettings()).createDependencySettings();
  }

  /** Returns the object with the settings used for calls to getDependency. */
  public UnaryCallSettings<GetDependencyRequest, Dependency> getDependencySettings() {
    return ((ApiHubDependenciesStubSettings) getStubSettings()).getDependencySettings();
  }

  /** Returns the object with the settings used for calls to updateDependency. */
  public UnaryCallSettings<UpdateDependencyRequest, Dependency> updateDependencySettings() {
    return ((ApiHubDependenciesStubSettings) getStubSettings()).updateDependencySettings();
  }

  /** Returns the object with the settings used for calls to deleteDependency. */
  public UnaryCallSettings<DeleteDependencyRequest, Empty> deleteDependencySettings() {
    return ((ApiHubDependenciesStubSettings) getStubSettings()).deleteDependencySettings();
  }

  /** Returns the object with the settings used for calls to listDependencies. */
  public PagedCallSettings<
          ListDependenciesRequest, ListDependenciesResponse, ListDependenciesPagedResponse>
      listDependenciesSettings() {
    return ((ApiHubDependenciesStubSettings) getStubSettings()).listDependenciesSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ApiHubDependenciesStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ApiHubDependenciesStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final ApiHubDependenciesSettings create(ApiHubDependenciesStubSettings stub)
      throws IOException {
    return new ApiHubDependenciesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ApiHubDependenciesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ApiHubDependenciesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ApiHubDependenciesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ApiHubDependenciesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ApiHubDependenciesStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ApiHubDependenciesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ApiHubDependenciesStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiHubDependenciesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ApiHubDependenciesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ApiHubDependenciesSettings. */
  public static class Builder extends ClientSettings.Builder<ApiHubDependenciesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ApiHubDependenciesStubSettings.newBuilder(clientContext));
    }

    protected Builder(ApiHubDependenciesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ApiHubDependenciesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ApiHubDependenciesStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(ApiHubDependenciesStubSettings.newHttpJsonBuilder());
    }

    public ApiHubDependenciesStubSettings.Builder getStubSettingsBuilder() {
      return ((ApiHubDependenciesStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createDependency. */
    public UnaryCallSettings.Builder<CreateDependencyRequest, Dependency>
        createDependencySettings() {
      return getStubSettingsBuilder().createDependencySettings();
    }

    /** Returns the builder for the settings used for calls to getDependency. */
    public UnaryCallSettings.Builder<GetDependencyRequest, Dependency> getDependencySettings() {
      return getStubSettingsBuilder().getDependencySettings();
    }

    /** Returns the builder for the settings used for calls to updateDependency. */
    public UnaryCallSettings.Builder<UpdateDependencyRequest, Dependency>
        updateDependencySettings() {
      return getStubSettingsBuilder().updateDependencySettings();
    }

    /** Returns the builder for the settings used for calls to deleteDependency. */
    public UnaryCallSettings.Builder<DeleteDependencyRequest, Empty> deleteDependencySettings() {
      return getStubSettingsBuilder().deleteDependencySettings();
    }

    /** Returns the builder for the settings used for calls to listDependencies. */
    public PagedCallSettings.Builder<
            ListDependenciesRequest, ListDependenciesResponse, ListDependenciesPagedResponse>
        listDependenciesSettings() {
      return getStubSettingsBuilder().listDependenciesSettings();
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
    public ApiHubDependenciesSettings build() throws IOException {
      return new ApiHubDependenciesSettings(this);
    }
  }
}
