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

package com.google.cloud.securitycentermanagement.v1;

import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListDescendantEventThreatDetectionCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListEffectiveEventThreatDetectionCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListEventThreatDetectionCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListLocationsPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListSecurityHealthAnalyticsCustomModulesPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.securitycentermanagement.v1.stub.SecurityCenterManagementStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SecurityCenterManagementClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (securitycentermanagement.googleapis.com) and default port
 *       (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getEffectiveSecurityHealthAnalyticsCustomModule to 30
 * seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SecurityCenterManagementSettings.Builder securityCenterManagementSettingsBuilder =
 *     SecurityCenterManagementSettings.newBuilder();
 * securityCenterManagementSettingsBuilder
 *     .getEffectiveSecurityHealthAnalyticsCustomModuleSettings()
 *     .setRetrySettings(
 *         securityCenterManagementSettingsBuilder
 *             .getEffectiveSecurityHealthAnalyticsCustomModuleSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SecurityCenterManagementSettings securityCenterManagementSettings =
 *     securityCenterManagementSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SecurityCenterManagementSettings
    extends ClientSettings<SecurityCenterManagementSettings> {

  /**
   * Returns the object with the settings used for calls to
   * listEffectiveSecurityHealthAnalyticsCustomModules.
   */
  public PagedCallSettings<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
          ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse>
      listEffectiveSecurityHealthAnalyticsCustomModulesSettings() {
    return ((SecurityCenterManagementStubSettings) getStubSettings())
        .listEffectiveSecurityHealthAnalyticsCustomModulesSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * getEffectiveSecurityHealthAnalyticsCustomModule.
   */
  public UnaryCallSettings<
          GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
          EffectiveSecurityHealthAnalyticsCustomModule>
      getEffectiveSecurityHealthAnalyticsCustomModuleSettings() {
    return ((SecurityCenterManagementStubSettings) getStubSettings())
        .getEffectiveSecurityHealthAnalyticsCustomModuleSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * listSecurityHealthAnalyticsCustomModules.
   */
  public PagedCallSettings<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesResponse,
          ListSecurityHealthAnalyticsCustomModulesPagedResponse>
      listSecurityHealthAnalyticsCustomModulesSettings() {
    return ((SecurityCenterManagementStubSettings) getStubSettings())
        .listSecurityHealthAnalyticsCustomModulesSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * listDescendantSecurityHealthAnalyticsCustomModules.
   */
  public PagedCallSettings<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
          ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse>
      listDescendantSecurityHealthAnalyticsCustomModulesSettings() {
    return ((SecurityCenterManagementStubSettings) getStubSettings())
        .listDescendantSecurityHealthAnalyticsCustomModulesSettings();
  }

  /**
   * Returns the object with the settings used for calls to getSecurityHealthAnalyticsCustomModule.
   */
  public UnaryCallSettings<
          GetSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      getSecurityHealthAnalyticsCustomModuleSettings() {
    return ((SecurityCenterManagementStubSettings) getStubSettings())
        .getSecurityHealthAnalyticsCustomModuleSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * createSecurityHealthAnalyticsCustomModule.
   */
  public UnaryCallSettings<
          CreateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      createSecurityHealthAnalyticsCustomModuleSettings() {
    return ((SecurityCenterManagementStubSettings) getStubSettings())
        .createSecurityHealthAnalyticsCustomModuleSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * updateSecurityHealthAnalyticsCustomModule.
   */
  public UnaryCallSettings<
          UpdateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      updateSecurityHealthAnalyticsCustomModuleSettings() {
    return ((SecurityCenterManagementStubSettings) getStubSettings())
        .updateSecurityHealthAnalyticsCustomModuleSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * deleteSecurityHealthAnalyticsCustomModule.
   */
  public UnaryCallSettings<DeleteSecurityHealthAnalyticsCustomModuleRequest, Empty>
      deleteSecurityHealthAnalyticsCustomModuleSettings() {
    return ((SecurityCenterManagementStubSettings) getStubSettings())
        .deleteSecurityHealthAnalyticsCustomModuleSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * simulateSecurityHealthAnalyticsCustomModule.
   */
  public UnaryCallSettings<
          SimulateSecurityHealthAnalyticsCustomModuleRequest,
          SimulateSecurityHealthAnalyticsCustomModuleResponse>
      simulateSecurityHealthAnalyticsCustomModuleSettings() {
    return ((SecurityCenterManagementStubSettings) getStubSettings())
        .simulateSecurityHealthAnalyticsCustomModuleSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * listEffectiveEventThreatDetectionCustomModules.
   */
  public PagedCallSettings<
          ListEffectiveEventThreatDetectionCustomModulesRequest,
          ListEffectiveEventThreatDetectionCustomModulesResponse,
          ListEffectiveEventThreatDetectionCustomModulesPagedResponse>
      listEffectiveEventThreatDetectionCustomModulesSettings() {
    return ((SecurityCenterManagementStubSettings) getStubSettings())
        .listEffectiveEventThreatDetectionCustomModulesSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * getEffectiveEventThreatDetectionCustomModule.
   */
  public UnaryCallSettings<
          GetEffectiveEventThreatDetectionCustomModuleRequest,
          EffectiveEventThreatDetectionCustomModule>
      getEffectiveEventThreatDetectionCustomModuleSettings() {
    return ((SecurityCenterManagementStubSettings) getStubSettings())
        .getEffectiveEventThreatDetectionCustomModuleSettings();
  }

  /**
   * Returns the object with the settings used for calls to listEventThreatDetectionCustomModules.
   */
  public PagedCallSettings<
          ListEventThreatDetectionCustomModulesRequest,
          ListEventThreatDetectionCustomModulesResponse,
          ListEventThreatDetectionCustomModulesPagedResponse>
      listEventThreatDetectionCustomModulesSettings() {
    return ((SecurityCenterManagementStubSettings) getStubSettings())
        .listEventThreatDetectionCustomModulesSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * listDescendantEventThreatDetectionCustomModules.
   */
  public PagedCallSettings<
          ListDescendantEventThreatDetectionCustomModulesRequest,
          ListDescendantEventThreatDetectionCustomModulesResponse,
          ListDescendantEventThreatDetectionCustomModulesPagedResponse>
      listDescendantEventThreatDetectionCustomModulesSettings() {
    return ((SecurityCenterManagementStubSettings) getStubSettings())
        .listDescendantEventThreatDetectionCustomModulesSettings();
  }

  /** Returns the object with the settings used for calls to getEventThreatDetectionCustomModule. */
  public UnaryCallSettings<
          GetEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      getEventThreatDetectionCustomModuleSettings() {
    return ((SecurityCenterManagementStubSettings) getStubSettings())
        .getEventThreatDetectionCustomModuleSettings();
  }

  /**
   * Returns the object with the settings used for calls to createEventThreatDetectionCustomModule.
   */
  public UnaryCallSettings<
          CreateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      createEventThreatDetectionCustomModuleSettings() {
    return ((SecurityCenterManagementStubSettings) getStubSettings())
        .createEventThreatDetectionCustomModuleSettings();
  }

  /**
   * Returns the object with the settings used for calls to updateEventThreatDetectionCustomModule.
   */
  public UnaryCallSettings<
          UpdateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      updateEventThreatDetectionCustomModuleSettings() {
    return ((SecurityCenterManagementStubSettings) getStubSettings())
        .updateEventThreatDetectionCustomModuleSettings();
  }

  /**
   * Returns the object with the settings used for calls to deleteEventThreatDetectionCustomModule.
   */
  public UnaryCallSettings<DeleteEventThreatDetectionCustomModuleRequest, Empty>
      deleteEventThreatDetectionCustomModuleSettings() {
    return ((SecurityCenterManagementStubSettings) getStubSettings())
        .deleteEventThreatDetectionCustomModuleSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * validateEventThreatDetectionCustomModule.
   */
  public UnaryCallSettings<
          ValidateEventThreatDetectionCustomModuleRequest,
          ValidateEventThreatDetectionCustomModuleResponse>
      validateEventThreatDetectionCustomModuleSettings() {
    return ((SecurityCenterManagementStubSettings) getStubSettings())
        .validateEventThreatDetectionCustomModuleSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((SecurityCenterManagementStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((SecurityCenterManagementStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final SecurityCenterManagementSettings create(
      SecurityCenterManagementStubSettings stub) throws IOException {
    return new SecurityCenterManagementSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SecurityCenterManagementStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SecurityCenterManagementStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SecurityCenterManagementStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SecurityCenterManagementStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SecurityCenterManagementStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SecurityCenterManagementStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SecurityCenterManagementStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SecurityCenterManagementStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SecurityCenterManagementSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SecurityCenterManagementSettings. */
  public static class Builder
      extends ClientSettings.Builder<SecurityCenterManagementSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(SecurityCenterManagementStubSettings.newBuilder(clientContext));
    }

    protected Builder(SecurityCenterManagementSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SecurityCenterManagementStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SecurityCenterManagementStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(SecurityCenterManagementStubSettings.newHttpJsonBuilder());
    }

    public SecurityCenterManagementStubSettings.Builder getStubSettingsBuilder() {
      return ((SecurityCenterManagementStubSettings.Builder) getStubSettings());
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

    /**
     * Returns the builder for the settings used for calls to
     * listEffectiveSecurityHealthAnalyticsCustomModules.
     */
    public PagedCallSettings.Builder<
            ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
            ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
            ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse>
        listEffectiveSecurityHealthAnalyticsCustomModulesSettings() {
      return getStubSettingsBuilder().listEffectiveSecurityHealthAnalyticsCustomModulesSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * getEffectiveSecurityHealthAnalyticsCustomModule.
     */
    public UnaryCallSettings.Builder<
            GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
            EffectiveSecurityHealthAnalyticsCustomModule>
        getEffectiveSecurityHealthAnalyticsCustomModuleSettings() {
      return getStubSettingsBuilder().getEffectiveSecurityHealthAnalyticsCustomModuleSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * listSecurityHealthAnalyticsCustomModules.
     */
    public PagedCallSettings.Builder<
            ListSecurityHealthAnalyticsCustomModulesRequest,
            ListSecurityHealthAnalyticsCustomModulesResponse,
            ListSecurityHealthAnalyticsCustomModulesPagedResponse>
        listSecurityHealthAnalyticsCustomModulesSettings() {
      return getStubSettingsBuilder().listSecurityHealthAnalyticsCustomModulesSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * listDescendantSecurityHealthAnalyticsCustomModules.
     */
    public PagedCallSettings.Builder<
            ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
            ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
            ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse>
        listDescendantSecurityHealthAnalyticsCustomModulesSettings() {
      return getStubSettingsBuilder().listDescendantSecurityHealthAnalyticsCustomModulesSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * getSecurityHealthAnalyticsCustomModule.
     */
    public UnaryCallSettings.Builder<
            GetSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
        getSecurityHealthAnalyticsCustomModuleSettings() {
      return getStubSettingsBuilder().getSecurityHealthAnalyticsCustomModuleSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * createSecurityHealthAnalyticsCustomModule.
     */
    public UnaryCallSettings.Builder<
            CreateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
        createSecurityHealthAnalyticsCustomModuleSettings() {
      return getStubSettingsBuilder().createSecurityHealthAnalyticsCustomModuleSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * updateSecurityHealthAnalyticsCustomModule.
     */
    public UnaryCallSettings.Builder<
            UpdateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
        updateSecurityHealthAnalyticsCustomModuleSettings() {
      return getStubSettingsBuilder().updateSecurityHealthAnalyticsCustomModuleSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * deleteSecurityHealthAnalyticsCustomModule.
     */
    public UnaryCallSettings.Builder<DeleteSecurityHealthAnalyticsCustomModuleRequest, Empty>
        deleteSecurityHealthAnalyticsCustomModuleSettings() {
      return getStubSettingsBuilder().deleteSecurityHealthAnalyticsCustomModuleSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * simulateSecurityHealthAnalyticsCustomModule.
     */
    public UnaryCallSettings.Builder<
            SimulateSecurityHealthAnalyticsCustomModuleRequest,
            SimulateSecurityHealthAnalyticsCustomModuleResponse>
        simulateSecurityHealthAnalyticsCustomModuleSettings() {
      return getStubSettingsBuilder().simulateSecurityHealthAnalyticsCustomModuleSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * listEffectiveEventThreatDetectionCustomModules.
     */
    public PagedCallSettings.Builder<
            ListEffectiveEventThreatDetectionCustomModulesRequest,
            ListEffectiveEventThreatDetectionCustomModulesResponse,
            ListEffectiveEventThreatDetectionCustomModulesPagedResponse>
        listEffectiveEventThreatDetectionCustomModulesSettings() {
      return getStubSettingsBuilder().listEffectiveEventThreatDetectionCustomModulesSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * getEffectiveEventThreatDetectionCustomModule.
     */
    public UnaryCallSettings.Builder<
            GetEffectiveEventThreatDetectionCustomModuleRequest,
            EffectiveEventThreatDetectionCustomModule>
        getEffectiveEventThreatDetectionCustomModuleSettings() {
      return getStubSettingsBuilder().getEffectiveEventThreatDetectionCustomModuleSettings();
    }

    /**
     * Returns the builder for the settings used for calls to listEventThreatDetectionCustomModules.
     */
    public PagedCallSettings.Builder<
            ListEventThreatDetectionCustomModulesRequest,
            ListEventThreatDetectionCustomModulesResponse,
            ListEventThreatDetectionCustomModulesPagedResponse>
        listEventThreatDetectionCustomModulesSettings() {
      return getStubSettingsBuilder().listEventThreatDetectionCustomModulesSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * listDescendantEventThreatDetectionCustomModules.
     */
    public PagedCallSettings.Builder<
            ListDescendantEventThreatDetectionCustomModulesRequest,
            ListDescendantEventThreatDetectionCustomModulesResponse,
            ListDescendantEventThreatDetectionCustomModulesPagedResponse>
        listDescendantEventThreatDetectionCustomModulesSettings() {
      return getStubSettingsBuilder().listDescendantEventThreatDetectionCustomModulesSettings();
    }

    /**
     * Returns the builder for the settings used for calls to getEventThreatDetectionCustomModule.
     */
    public UnaryCallSettings.Builder<
            GetEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
        getEventThreatDetectionCustomModuleSettings() {
      return getStubSettingsBuilder().getEventThreatDetectionCustomModuleSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * createEventThreatDetectionCustomModule.
     */
    public UnaryCallSettings.Builder<
            CreateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
        createEventThreatDetectionCustomModuleSettings() {
      return getStubSettingsBuilder().createEventThreatDetectionCustomModuleSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * updateEventThreatDetectionCustomModule.
     */
    public UnaryCallSettings.Builder<
            UpdateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
        updateEventThreatDetectionCustomModuleSettings() {
      return getStubSettingsBuilder().updateEventThreatDetectionCustomModuleSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * deleteEventThreatDetectionCustomModule.
     */
    public UnaryCallSettings.Builder<DeleteEventThreatDetectionCustomModuleRequest, Empty>
        deleteEventThreatDetectionCustomModuleSettings() {
      return getStubSettingsBuilder().deleteEventThreatDetectionCustomModuleSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * validateEventThreatDetectionCustomModule.
     */
    public UnaryCallSettings.Builder<
            ValidateEventThreatDetectionCustomModuleRequest,
            ValidateEventThreatDetectionCustomModuleResponse>
        validateEventThreatDetectionCustomModuleSettings() {
      return getStubSettingsBuilder().validateEventThreatDetectionCustomModuleSettings();
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
    public SecurityCenterManagementSettings build() throws IOException {
      return new SecurityCenterManagementSettings(this);
    }
  }
}
