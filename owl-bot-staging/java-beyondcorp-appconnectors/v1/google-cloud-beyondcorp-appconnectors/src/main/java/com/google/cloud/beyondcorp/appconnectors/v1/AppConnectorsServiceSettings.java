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

package com.google.cloud.beyondcorp.appconnectors.v1;

import static com.google.cloud.beyondcorp.appconnectors.v1.AppConnectorsServiceClient.ListAppConnectorsPagedResponse;
import static com.google.cloud.beyondcorp.appconnectors.v1.AppConnectorsServiceClient.ListLocationsPagedResponse;

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
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.beyondcorp.appconnectors.v1.stub.AppConnectorsServiceStubSettings;
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
 * Settings class to configure an instance of {@link AppConnectorsServiceClient}.
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
 * <p>For example, to set the total timeout of getAppConnector to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AppConnectorsServiceSettings.Builder appConnectorsServiceSettingsBuilder =
 *     AppConnectorsServiceSettings.newBuilder();
 * appConnectorsServiceSettingsBuilder
 *     .getAppConnectorSettings()
 *     .setRetrySettings(
 *         appConnectorsServiceSettingsBuilder
 *             .getAppConnectorSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AppConnectorsServiceSettings appConnectorsServiceSettings =
 *     appConnectorsServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AppConnectorsServiceSettings extends ClientSettings<AppConnectorsServiceSettings> {

  /** Returns the object with the settings used for calls to listAppConnectors. */
  public PagedCallSettings<
          ListAppConnectorsRequest, ListAppConnectorsResponse, ListAppConnectorsPagedResponse>
      listAppConnectorsSettings() {
    return ((AppConnectorsServiceStubSettings) getStubSettings()).listAppConnectorsSettings();
  }

  /** Returns the object with the settings used for calls to getAppConnector. */
  public UnaryCallSettings<GetAppConnectorRequest, AppConnector> getAppConnectorSettings() {
    return ((AppConnectorsServiceStubSettings) getStubSettings()).getAppConnectorSettings();
  }

  /** Returns the object with the settings used for calls to createAppConnector. */
  public UnaryCallSettings<CreateAppConnectorRequest, Operation> createAppConnectorSettings() {
    return ((AppConnectorsServiceStubSettings) getStubSettings()).createAppConnectorSettings();
  }

  /** Returns the object with the settings used for calls to createAppConnector. */
  public OperationCallSettings<
          CreateAppConnectorRequest, AppConnector, AppConnectorOperationMetadata>
      createAppConnectorOperationSettings() {
    return ((AppConnectorsServiceStubSettings) getStubSettings())
        .createAppConnectorOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateAppConnector. */
  public UnaryCallSettings<UpdateAppConnectorRequest, Operation> updateAppConnectorSettings() {
    return ((AppConnectorsServiceStubSettings) getStubSettings()).updateAppConnectorSettings();
  }

  /** Returns the object with the settings used for calls to updateAppConnector. */
  public OperationCallSettings<
          UpdateAppConnectorRequest, AppConnector, AppConnectorOperationMetadata>
      updateAppConnectorOperationSettings() {
    return ((AppConnectorsServiceStubSettings) getStubSettings())
        .updateAppConnectorOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteAppConnector. */
  public UnaryCallSettings<DeleteAppConnectorRequest, Operation> deleteAppConnectorSettings() {
    return ((AppConnectorsServiceStubSettings) getStubSettings()).deleteAppConnectorSettings();
  }

  /** Returns the object with the settings used for calls to deleteAppConnector. */
  public OperationCallSettings<DeleteAppConnectorRequest, Empty, AppConnectorOperationMetadata>
      deleteAppConnectorOperationSettings() {
    return ((AppConnectorsServiceStubSettings) getStubSettings())
        .deleteAppConnectorOperationSettings();
  }

  /** Returns the object with the settings used for calls to reportStatus. */
  public UnaryCallSettings<ReportStatusRequest, Operation> reportStatusSettings() {
    return ((AppConnectorsServiceStubSettings) getStubSettings()).reportStatusSettings();
  }

  /** Returns the object with the settings used for calls to reportStatus. */
  public OperationCallSettings<ReportStatusRequest, AppConnector, AppConnectorOperationMetadata>
      reportStatusOperationSettings() {
    return ((AppConnectorsServiceStubSettings) getStubSettings()).reportStatusOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((AppConnectorsServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((AppConnectorsServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((AppConnectorsServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((AppConnectorsServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((AppConnectorsServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final AppConnectorsServiceSettings create(AppConnectorsServiceStubSettings stub)
      throws IOException {
    return new AppConnectorsServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AppConnectorsServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AppConnectorsServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AppConnectorsServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AppConnectorsServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AppConnectorsServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AppConnectorsServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AppConnectorsServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AppConnectorsServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AppConnectorsServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<AppConnectorsServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AppConnectorsServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(AppConnectorsServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AppConnectorsServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AppConnectorsServiceStubSettings.newBuilder());
    }

    public AppConnectorsServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((AppConnectorsServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listAppConnectors. */
    public PagedCallSettings.Builder<
            ListAppConnectorsRequest, ListAppConnectorsResponse, ListAppConnectorsPagedResponse>
        listAppConnectorsSettings() {
      return getStubSettingsBuilder().listAppConnectorsSettings();
    }

    /** Returns the builder for the settings used for calls to getAppConnector. */
    public UnaryCallSettings.Builder<GetAppConnectorRequest, AppConnector>
        getAppConnectorSettings() {
      return getStubSettingsBuilder().getAppConnectorSettings();
    }

    /** Returns the builder for the settings used for calls to createAppConnector. */
    public UnaryCallSettings.Builder<CreateAppConnectorRequest, Operation>
        createAppConnectorSettings() {
      return getStubSettingsBuilder().createAppConnectorSettings();
    }

    /** Returns the builder for the settings used for calls to createAppConnector. */
    public OperationCallSettings.Builder<
            CreateAppConnectorRequest, AppConnector, AppConnectorOperationMetadata>
        createAppConnectorOperationSettings() {
      return getStubSettingsBuilder().createAppConnectorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateAppConnector. */
    public UnaryCallSettings.Builder<UpdateAppConnectorRequest, Operation>
        updateAppConnectorSettings() {
      return getStubSettingsBuilder().updateAppConnectorSettings();
    }

    /** Returns the builder for the settings used for calls to updateAppConnector. */
    public OperationCallSettings.Builder<
            UpdateAppConnectorRequest, AppConnector, AppConnectorOperationMetadata>
        updateAppConnectorOperationSettings() {
      return getStubSettingsBuilder().updateAppConnectorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAppConnector. */
    public UnaryCallSettings.Builder<DeleteAppConnectorRequest, Operation>
        deleteAppConnectorSettings() {
      return getStubSettingsBuilder().deleteAppConnectorSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAppConnector. */
    public OperationCallSettings.Builder<
            DeleteAppConnectorRequest, Empty, AppConnectorOperationMetadata>
        deleteAppConnectorOperationSettings() {
      return getStubSettingsBuilder().deleteAppConnectorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to reportStatus. */
    public UnaryCallSettings.Builder<ReportStatusRequest, Operation> reportStatusSettings() {
      return getStubSettingsBuilder().reportStatusSettings();
    }

    /** Returns the builder for the settings used for calls to reportStatus. */
    public OperationCallSettings.Builder<
            ReportStatusRequest, AppConnector, AppConnectorOperationMetadata>
        reportStatusOperationSettings() {
      return getStubSettingsBuilder().reportStatusOperationSettings();
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
    public AppConnectorsServiceSettings build() throws IOException {
      return new AppConnectorsServiceSettings(this);
    }
  }
}
