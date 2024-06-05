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

package com.google.cloud.networkservices.v1;

import static com.google.cloud.networkservices.v1.DepServiceClient.ListLbRouteExtensionsPagedResponse;
import static com.google.cloud.networkservices.v1.DepServiceClient.ListLbTrafficExtensionsPagedResponse;
import static com.google.cloud.networkservices.v1.DepServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networkservices.v1.stub.DepServiceStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DepServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networkservices.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getLbTrafficExtension to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DepServiceSettings.Builder depServiceSettingsBuilder = DepServiceSettings.newBuilder();
 * depServiceSettingsBuilder
 *     .getLbTrafficExtensionSettings()
 *     .setRetrySettings(
 *         depServiceSettingsBuilder
 *             .getLbTrafficExtensionSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DepServiceSettings depServiceSettings = depServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DepServiceSettings extends ClientSettings<DepServiceSettings> {

  /** Returns the object with the settings used for calls to listLbTrafficExtensions. */
  public PagedCallSettings<
          ListLbTrafficExtensionsRequest,
          ListLbTrafficExtensionsResponse,
          ListLbTrafficExtensionsPagedResponse>
      listLbTrafficExtensionsSettings() {
    return ((DepServiceStubSettings) getStubSettings()).listLbTrafficExtensionsSettings();
  }

  /** Returns the object with the settings used for calls to getLbTrafficExtension. */
  public UnaryCallSettings<GetLbTrafficExtensionRequest, LbTrafficExtension>
      getLbTrafficExtensionSettings() {
    return ((DepServiceStubSettings) getStubSettings()).getLbTrafficExtensionSettings();
  }

  /** Returns the object with the settings used for calls to createLbTrafficExtension. */
  public UnaryCallSettings<CreateLbTrafficExtensionRequest, Operation>
      createLbTrafficExtensionSettings() {
    return ((DepServiceStubSettings) getStubSettings()).createLbTrafficExtensionSettings();
  }

  /** Returns the object with the settings used for calls to createLbTrafficExtension. */
  public OperationCallSettings<
          CreateLbTrafficExtensionRequest, LbTrafficExtension, OperationMetadata>
      createLbTrafficExtensionOperationSettings() {
    return ((DepServiceStubSettings) getStubSettings()).createLbTrafficExtensionOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateLbTrafficExtension. */
  public UnaryCallSettings<UpdateLbTrafficExtensionRequest, Operation>
      updateLbTrafficExtensionSettings() {
    return ((DepServiceStubSettings) getStubSettings()).updateLbTrafficExtensionSettings();
  }

  /** Returns the object with the settings used for calls to updateLbTrafficExtension. */
  public OperationCallSettings<
          UpdateLbTrafficExtensionRequest, LbTrafficExtension, OperationMetadata>
      updateLbTrafficExtensionOperationSettings() {
    return ((DepServiceStubSettings) getStubSettings()).updateLbTrafficExtensionOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteLbTrafficExtension. */
  public UnaryCallSettings<DeleteLbTrafficExtensionRequest, Operation>
      deleteLbTrafficExtensionSettings() {
    return ((DepServiceStubSettings) getStubSettings()).deleteLbTrafficExtensionSettings();
  }

  /** Returns the object with the settings used for calls to deleteLbTrafficExtension. */
  public OperationCallSettings<DeleteLbTrafficExtensionRequest, Empty, OperationMetadata>
      deleteLbTrafficExtensionOperationSettings() {
    return ((DepServiceStubSettings) getStubSettings()).deleteLbTrafficExtensionOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLbRouteExtensions. */
  public PagedCallSettings<
          ListLbRouteExtensionsRequest,
          ListLbRouteExtensionsResponse,
          ListLbRouteExtensionsPagedResponse>
      listLbRouteExtensionsSettings() {
    return ((DepServiceStubSettings) getStubSettings()).listLbRouteExtensionsSettings();
  }

  /** Returns the object with the settings used for calls to getLbRouteExtension. */
  public UnaryCallSettings<GetLbRouteExtensionRequest, LbRouteExtension>
      getLbRouteExtensionSettings() {
    return ((DepServiceStubSettings) getStubSettings()).getLbRouteExtensionSettings();
  }

  /** Returns the object with the settings used for calls to createLbRouteExtension. */
  public UnaryCallSettings<CreateLbRouteExtensionRequest, Operation>
      createLbRouteExtensionSettings() {
    return ((DepServiceStubSettings) getStubSettings()).createLbRouteExtensionSettings();
  }

  /** Returns the object with the settings used for calls to createLbRouteExtension. */
  public OperationCallSettings<CreateLbRouteExtensionRequest, LbRouteExtension, OperationMetadata>
      createLbRouteExtensionOperationSettings() {
    return ((DepServiceStubSettings) getStubSettings()).createLbRouteExtensionOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateLbRouteExtension. */
  public UnaryCallSettings<UpdateLbRouteExtensionRequest, Operation>
      updateLbRouteExtensionSettings() {
    return ((DepServiceStubSettings) getStubSettings()).updateLbRouteExtensionSettings();
  }

  /** Returns the object with the settings used for calls to updateLbRouteExtension. */
  public OperationCallSettings<UpdateLbRouteExtensionRequest, LbRouteExtension, OperationMetadata>
      updateLbRouteExtensionOperationSettings() {
    return ((DepServiceStubSettings) getStubSettings()).updateLbRouteExtensionOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteLbRouteExtension. */
  public UnaryCallSettings<DeleteLbRouteExtensionRequest, Operation>
      deleteLbRouteExtensionSettings() {
    return ((DepServiceStubSettings) getStubSettings()).deleteLbRouteExtensionSettings();
  }

  /** Returns the object with the settings used for calls to deleteLbRouteExtension. */
  public OperationCallSettings<DeleteLbRouteExtensionRequest, Empty, OperationMetadata>
      deleteLbRouteExtensionOperationSettings() {
    return ((DepServiceStubSettings) getStubSettings()).deleteLbRouteExtensionOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((DepServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((DepServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((DepServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((DepServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((DepServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final DepServiceSettings create(DepServiceStubSettings stub) throws IOException {
    return new DepServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DepServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DepServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DepServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DepServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DepServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DepServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DepServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DepServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DepServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DepServiceSettings. */
  public static class Builder extends ClientSettings.Builder<DepServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DepServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DepServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DepServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DepServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(DepServiceStubSettings.newHttpJsonBuilder());
    }

    public DepServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DepServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listLbTrafficExtensions. */
    public PagedCallSettings.Builder<
            ListLbTrafficExtensionsRequest,
            ListLbTrafficExtensionsResponse,
            ListLbTrafficExtensionsPagedResponse>
        listLbTrafficExtensionsSettings() {
      return getStubSettingsBuilder().listLbTrafficExtensionsSettings();
    }

    /** Returns the builder for the settings used for calls to getLbTrafficExtension. */
    public UnaryCallSettings.Builder<GetLbTrafficExtensionRequest, LbTrafficExtension>
        getLbTrafficExtensionSettings() {
      return getStubSettingsBuilder().getLbTrafficExtensionSettings();
    }

    /** Returns the builder for the settings used for calls to createLbTrafficExtension. */
    public UnaryCallSettings.Builder<CreateLbTrafficExtensionRequest, Operation>
        createLbTrafficExtensionSettings() {
      return getStubSettingsBuilder().createLbTrafficExtensionSettings();
    }

    /** Returns the builder for the settings used for calls to createLbTrafficExtension. */
    public OperationCallSettings.Builder<
            CreateLbTrafficExtensionRequest, LbTrafficExtension, OperationMetadata>
        createLbTrafficExtensionOperationSettings() {
      return getStubSettingsBuilder().createLbTrafficExtensionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateLbTrafficExtension. */
    public UnaryCallSettings.Builder<UpdateLbTrafficExtensionRequest, Operation>
        updateLbTrafficExtensionSettings() {
      return getStubSettingsBuilder().updateLbTrafficExtensionSettings();
    }

    /** Returns the builder for the settings used for calls to updateLbTrafficExtension. */
    public OperationCallSettings.Builder<
            UpdateLbTrafficExtensionRequest, LbTrafficExtension, OperationMetadata>
        updateLbTrafficExtensionOperationSettings() {
      return getStubSettingsBuilder().updateLbTrafficExtensionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteLbTrafficExtension. */
    public UnaryCallSettings.Builder<DeleteLbTrafficExtensionRequest, Operation>
        deleteLbTrafficExtensionSettings() {
      return getStubSettingsBuilder().deleteLbTrafficExtensionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteLbTrafficExtension. */
    public OperationCallSettings.Builder<DeleteLbTrafficExtensionRequest, Empty, OperationMetadata>
        deleteLbTrafficExtensionOperationSettings() {
      return getStubSettingsBuilder().deleteLbTrafficExtensionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listLbRouteExtensions. */
    public PagedCallSettings.Builder<
            ListLbRouteExtensionsRequest,
            ListLbRouteExtensionsResponse,
            ListLbRouteExtensionsPagedResponse>
        listLbRouteExtensionsSettings() {
      return getStubSettingsBuilder().listLbRouteExtensionsSettings();
    }

    /** Returns the builder for the settings used for calls to getLbRouteExtension. */
    public UnaryCallSettings.Builder<GetLbRouteExtensionRequest, LbRouteExtension>
        getLbRouteExtensionSettings() {
      return getStubSettingsBuilder().getLbRouteExtensionSettings();
    }

    /** Returns the builder for the settings used for calls to createLbRouteExtension. */
    public UnaryCallSettings.Builder<CreateLbRouteExtensionRequest, Operation>
        createLbRouteExtensionSettings() {
      return getStubSettingsBuilder().createLbRouteExtensionSettings();
    }

    /** Returns the builder for the settings used for calls to createLbRouteExtension. */
    public OperationCallSettings.Builder<
            CreateLbRouteExtensionRequest, LbRouteExtension, OperationMetadata>
        createLbRouteExtensionOperationSettings() {
      return getStubSettingsBuilder().createLbRouteExtensionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateLbRouteExtension. */
    public UnaryCallSettings.Builder<UpdateLbRouteExtensionRequest, Operation>
        updateLbRouteExtensionSettings() {
      return getStubSettingsBuilder().updateLbRouteExtensionSettings();
    }

    /** Returns the builder for the settings used for calls to updateLbRouteExtension. */
    public OperationCallSettings.Builder<
            UpdateLbRouteExtensionRequest, LbRouteExtension, OperationMetadata>
        updateLbRouteExtensionOperationSettings() {
      return getStubSettingsBuilder().updateLbRouteExtensionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteLbRouteExtension. */
    public UnaryCallSettings.Builder<DeleteLbRouteExtensionRequest, Operation>
        deleteLbRouteExtensionSettings() {
      return getStubSettingsBuilder().deleteLbRouteExtensionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteLbRouteExtension. */
    public OperationCallSettings.Builder<DeleteLbRouteExtensionRequest, Empty, OperationMetadata>
        deleteLbRouteExtensionOperationSettings() {
      return getStubSettingsBuilder().deleteLbRouteExtensionOperationSettings();
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

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public DepServiceSettings build() throws IOException {
      return new DepServiceSettings(this);
    }
  }
}
