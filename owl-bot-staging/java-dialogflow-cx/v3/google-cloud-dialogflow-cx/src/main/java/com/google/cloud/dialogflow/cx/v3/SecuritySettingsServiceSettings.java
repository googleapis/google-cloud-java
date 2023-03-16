/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.dialogflow.cx.v3;

import static com.google.cloud.dialogflow.cx.v3.SecuritySettingsServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.SecuritySettingsServiceClient.ListSecuritySettingsPagedResponse;

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
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.dialogflow.cx.v3.stub.SecuritySettingsServiceStubSettings;
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
 * Settings class to configure an instance of {@link SecuritySettingsServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dialogflow.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createSecuritySettings to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SecuritySettingsServiceSettings.Builder securitySettingsServiceSettingsBuilder =
 *     SecuritySettingsServiceSettings.newBuilder();
 * securitySettingsServiceSettingsBuilder
 *     .createSecuritySettingsSettings()
 *     .setRetrySettings(
 *         securitySettingsServiceSettingsBuilder
 *             .createSecuritySettingsSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SecuritySettingsServiceSettings securitySettingsServiceSettings =
 *     securitySettingsServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SecuritySettingsServiceSettings
    extends ClientSettings<SecuritySettingsServiceSettings> {

  /** Returns the object with the settings used for calls to createSecuritySettings. */
  public UnaryCallSettings<CreateSecuritySettingsRequest, SecuritySettings>
      createSecuritySettingsSettings() {
    return ((SecuritySettingsServiceStubSettings) getStubSettings())
        .createSecuritySettingsSettings();
  }

  /** Returns the object with the settings used for calls to getSecuritySettings. */
  public UnaryCallSettings<GetSecuritySettingsRequest, SecuritySettings>
      getSecuritySettingsSettings() {
    return ((SecuritySettingsServiceStubSettings) getStubSettings()).getSecuritySettingsSettings();
  }

  /** Returns the object with the settings used for calls to updateSecuritySettings. */
  public UnaryCallSettings<UpdateSecuritySettingsRequest, SecuritySettings>
      updateSecuritySettingsSettings() {
    return ((SecuritySettingsServiceStubSettings) getStubSettings())
        .updateSecuritySettingsSettings();
  }

  /** Returns the object with the settings used for calls to listSecuritySettings. */
  public PagedCallSettings<
          ListSecuritySettingsRequest,
          ListSecuritySettingsResponse,
          ListSecuritySettingsPagedResponse>
      listSecuritySettingsSettings() {
    return ((SecuritySettingsServiceStubSettings) getStubSettings()).listSecuritySettingsSettings();
  }

  /** Returns the object with the settings used for calls to deleteSecuritySettings. */
  public UnaryCallSettings<DeleteSecuritySettingsRequest, Empty> deleteSecuritySettingsSettings() {
    return ((SecuritySettingsServiceStubSettings) getStubSettings())
        .deleteSecuritySettingsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((SecuritySettingsServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((SecuritySettingsServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final SecuritySettingsServiceSettings create(
      SecuritySettingsServiceStubSettings stub) throws IOException {
    return new SecuritySettingsServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SecuritySettingsServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SecuritySettingsServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SecuritySettingsServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SecuritySettingsServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SecuritySettingsServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SecuritySettingsServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SecuritySettingsServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SecuritySettingsServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
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

  protected SecuritySettingsServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SecuritySettingsServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<SecuritySettingsServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(SecuritySettingsServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(SecuritySettingsServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SecuritySettingsServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SecuritySettingsServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(SecuritySettingsServiceStubSettings.newHttpJsonBuilder());
    }

    public SecuritySettingsServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((SecuritySettingsServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createSecuritySettings. */
    public UnaryCallSettings.Builder<CreateSecuritySettingsRequest, SecuritySettings>
        createSecuritySettingsSettings() {
      return getStubSettingsBuilder().createSecuritySettingsSettings();
    }

    /** Returns the builder for the settings used for calls to getSecuritySettings. */
    public UnaryCallSettings.Builder<GetSecuritySettingsRequest, SecuritySettings>
        getSecuritySettingsSettings() {
      return getStubSettingsBuilder().getSecuritySettingsSettings();
    }

    /** Returns the builder for the settings used for calls to updateSecuritySettings. */
    public UnaryCallSettings.Builder<UpdateSecuritySettingsRequest, SecuritySettings>
        updateSecuritySettingsSettings() {
      return getStubSettingsBuilder().updateSecuritySettingsSettings();
    }

    /** Returns the builder for the settings used for calls to listSecuritySettings. */
    public PagedCallSettings.Builder<
            ListSecuritySettingsRequest,
            ListSecuritySettingsResponse,
            ListSecuritySettingsPagedResponse>
        listSecuritySettingsSettings() {
      return getStubSettingsBuilder().listSecuritySettingsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSecuritySettings. */
    public UnaryCallSettings.Builder<DeleteSecuritySettingsRequest, Empty>
        deleteSecuritySettingsSettings() {
      return getStubSettingsBuilder().deleteSecuritySettingsSettings();
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
    public SecuritySettingsServiceSettings build() throws IOException {
      return new SecuritySettingsServiceSettings(this);
    }
  }
}
