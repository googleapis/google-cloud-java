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

package com.google.cloud.beyondcorp.appconnections.v1;

import static com.google.cloud.beyondcorp.appconnections.v1.AppConnectionsServiceClient.ListAppConnectionsPagedResponse;
import static com.google.cloud.beyondcorp.appconnections.v1.AppConnectionsServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.beyondcorp.appconnections.v1.AppConnectionsServiceClient.ResolveAppConnectionsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.beyondcorp.appconnections.v1.stub.AppConnectionsServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Settings class to configure an instance of {@link AppConnectionsServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (beyondcorp.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getAppConnection to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AppConnectionsServiceSettings.Builder appConnectionsServiceSettingsBuilder =
 *     AppConnectionsServiceSettings.newBuilder();
 * appConnectionsServiceSettingsBuilder
 *     .getAppConnectionSettings()
 *     .setRetrySettings(
 *         appConnectionsServiceSettingsBuilder
 *             .getAppConnectionSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AppConnectionsServiceSettings appConnectionsServiceSettings =
 *     appConnectionsServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AppConnectionsServiceSettings extends ClientSettings<AppConnectionsServiceSettings> {

  /** Returns the object with the settings used for calls to listAppConnections. */
  public PagedCallSettings<
          ListAppConnectionsRequest, ListAppConnectionsResponse, ListAppConnectionsPagedResponse>
      listAppConnectionsSettings() {
    return ((AppConnectionsServiceStubSettings) getStubSettings()).listAppConnectionsSettings();
  }

  /** Returns the object with the settings used for calls to getAppConnection. */
  public UnaryCallSettings<GetAppConnectionRequest, AppConnection> getAppConnectionSettings() {
    return ((AppConnectionsServiceStubSettings) getStubSettings()).getAppConnectionSettings();
  }

  /** Returns the object with the settings used for calls to createAppConnection. */
  public UnaryCallSettings<CreateAppConnectionRequest, Operation> createAppConnectionSettings() {
    return ((AppConnectionsServiceStubSettings) getStubSettings()).createAppConnectionSettings();
  }

  /** Returns the object with the settings used for calls to createAppConnection. */
  public OperationCallSettings<
          CreateAppConnectionRequest, AppConnection, AppConnectionOperationMetadata>
      createAppConnectionOperationSettings() {
    return ((AppConnectionsServiceStubSettings) getStubSettings())
        .createAppConnectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateAppConnection. */
  public UnaryCallSettings<UpdateAppConnectionRequest, Operation> updateAppConnectionSettings() {
    return ((AppConnectionsServiceStubSettings) getStubSettings()).updateAppConnectionSettings();
  }

  /** Returns the object with the settings used for calls to updateAppConnection. */
  public OperationCallSettings<
          UpdateAppConnectionRequest, AppConnection, AppConnectionOperationMetadata>
      updateAppConnectionOperationSettings() {
    return ((AppConnectionsServiceStubSettings) getStubSettings())
        .updateAppConnectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteAppConnection. */
  public UnaryCallSettings<DeleteAppConnectionRequest, Operation> deleteAppConnectionSettings() {
    return ((AppConnectionsServiceStubSettings) getStubSettings()).deleteAppConnectionSettings();
  }

  /** Returns the object with the settings used for calls to deleteAppConnection. */
  public OperationCallSettings<DeleteAppConnectionRequest, Empty, AppConnectionOperationMetadata>
      deleteAppConnectionOperationSettings() {
    return ((AppConnectionsServiceStubSettings) getStubSettings())
        .deleteAppConnectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to resolveAppConnections. */
  public PagedCallSettings<
          ResolveAppConnectionsRequest,
          ResolveAppConnectionsResponse,
          ResolveAppConnectionsPagedResponse>
      resolveAppConnectionsSettings() {
    return ((AppConnectionsServiceStubSettings) getStubSettings()).resolveAppConnectionsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((AppConnectionsServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((AppConnectionsServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((AppConnectionsServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((AppConnectionsServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((AppConnectionsServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final AppConnectionsServiceSettings create(AppConnectionsServiceStubSettings stub)
      throws IOException {
    return new AppConnectionsServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AppConnectionsServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AppConnectionsServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AppConnectionsServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AppConnectionsServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AppConnectionsServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AppConnectionsServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AppConnectionsServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AppConnectionsServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AppConnectionsServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<AppConnectionsServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AppConnectionsServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(AppConnectionsServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AppConnectionsServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AppConnectionsServiceStubSettings.newBuilder());
    }

    public AppConnectionsServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((AppConnectionsServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listAppConnections. */
    public PagedCallSettings.Builder<
            ListAppConnectionsRequest, ListAppConnectionsResponse, ListAppConnectionsPagedResponse>
        listAppConnectionsSettings() {
      return getStubSettingsBuilder().listAppConnectionsSettings();
    }

    /** Returns the builder for the settings used for calls to getAppConnection. */
    public UnaryCallSettings.Builder<GetAppConnectionRequest, AppConnection>
        getAppConnectionSettings() {
      return getStubSettingsBuilder().getAppConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to createAppConnection. */
    public UnaryCallSettings.Builder<CreateAppConnectionRequest, Operation>
        createAppConnectionSettings() {
      return getStubSettingsBuilder().createAppConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to createAppConnection. */
    public OperationCallSettings.Builder<
            CreateAppConnectionRequest, AppConnection, AppConnectionOperationMetadata>
        createAppConnectionOperationSettings() {
      return getStubSettingsBuilder().createAppConnectionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateAppConnection. */
    public UnaryCallSettings.Builder<UpdateAppConnectionRequest, Operation>
        updateAppConnectionSettings() {
      return getStubSettingsBuilder().updateAppConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to updateAppConnection. */
    public OperationCallSettings.Builder<
            UpdateAppConnectionRequest, AppConnection, AppConnectionOperationMetadata>
        updateAppConnectionOperationSettings() {
      return getStubSettingsBuilder().updateAppConnectionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAppConnection. */
    public UnaryCallSettings.Builder<DeleteAppConnectionRequest, Operation>
        deleteAppConnectionSettings() {
      return getStubSettingsBuilder().deleteAppConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAppConnection. */
    public OperationCallSettings.Builder<
            DeleteAppConnectionRequest, Empty, AppConnectionOperationMetadata>
        deleteAppConnectionOperationSettings() {
      return getStubSettingsBuilder().deleteAppConnectionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to resolveAppConnections. */
    public PagedCallSettings.Builder<
            ResolveAppConnectionsRequest,
            ResolveAppConnectionsResponse,
            ResolveAppConnectionsPagedResponse>
        resolveAppConnectionsSettings() {
      return getStubSettingsBuilder().resolveAppConnectionsSettings();
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
    public AppConnectionsServiceSettings build() throws IOException {
      return new AppConnectionsServiceSettings(this);
    }
  }
}
