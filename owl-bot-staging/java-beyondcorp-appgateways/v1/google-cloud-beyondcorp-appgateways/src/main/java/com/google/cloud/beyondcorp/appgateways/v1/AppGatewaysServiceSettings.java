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

package com.google.cloud.beyondcorp.appgateways.v1;

import static com.google.cloud.beyondcorp.appgateways.v1.AppGatewaysServiceClient.ListAppGatewaysPagedResponse;
import static com.google.cloud.beyondcorp.appgateways.v1.AppGatewaysServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.beyondcorp.appgateways.v1.stub.AppGatewaysServiceStubSettings;
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
 * Settings class to configure an instance of {@link AppGatewaysServiceClient}.
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
 * <p>For example, to set the total timeout of getAppGateway to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AppGatewaysServiceSettings.Builder appGatewaysServiceSettingsBuilder =
 *     AppGatewaysServiceSettings.newBuilder();
 * appGatewaysServiceSettingsBuilder
 *     .getAppGatewaySettings()
 *     .setRetrySettings(
 *         appGatewaysServiceSettingsBuilder
 *             .getAppGatewaySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AppGatewaysServiceSettings appGatewaysServiceSettings =
 *     appGatewaysServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AppGatewaysServiceSettings extends ClientSettings<AppGatewaysServiceSettings> {

  /** Returns the object with the settings used for calls to listAppGateways. */
  public PagedCallSettings<
          ListAppGatewaysRequest, ListAppGatewaysResponse, ListAppGatewaysPagedResponse>
      listAppGatewaysSettings() {
    return ((AppGatewaysServiceStubSettings) getStubSettings()).listAppGatewaysSettings();
  }

  /** Returns the object with the settings used for calls to getAppGateway. */
  public UnaryCallSettings<GetAppGatewayRequest, AppGateway> getAppGatewaySettings() {
    return ((AppGatewaysServiceStubSettings) getStubSettings()).getAppGatewaySettings();
  }

  /** Returns the object with the settings used for calls to createAppGateway. */
  public UnaryCallSettings<CreateAppGatewayRequest, Operation> createAppGatewaySettings() {
    return ((AppGatewaysServiceStubSettings) getStubSettings()).createAppGatewaySettings();
  }

  /** Returns the object with the settings used for calls to createAppGateway. */
  public OperationCallSettings<CreateAppGatewayRequest, AppGateway, AppGatewayOperationMetadata>
      createAppGatewayOperationSettings() {
    return ((AppGatewaysServiceStubSettings) getStubSettings()).createAppGatewayOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteAppGateway. */
  public UnaryCallSettings<DeleteAppGatewayRequest, Operation> deleteAppGatewaySettings() {
    return ((AppGatewaysServiceStubSettings) getStubSettings()).deleteAppGatewaySettings();
  }

  /** Returns the object with the settings used for calls to deleteAppGateway. */
  public OperationCallSettings<DeleteAppGatewayRequest, Empty, AppGatewayOperationMetadata>
      deleteAppGatewayOperationSettings() {
    return ((AppGatewaysServiceStubSettings) getStubSettings()).deleteAppGatewayOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((AppGatewaysServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((AppGatewaysServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((AppGatewaysServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((AppGatewaysServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((AppGatewaysServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final AppGatewaysServiceSettings create(AppGatewaysServiceStubSettings stub)
      throws IOException {
    return new AppGatewaysServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AppGatewaysServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AppGatewaysServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AppGatewaysServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AppGatewaysServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AppGatewaysServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AppGatewaysServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AppGatewaysServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AppGatewaysServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AppGatewaysServiceSettings. */
  public static class Builder extends ClientSettings.Builder<AppGatewaysServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AppGatewaysServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(AppGatewaysServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AppGatewaysServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AppGatewaysServiceStubSettings.newBuilder());
    }

    public AppGatewaysServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((AppGatewaysServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listAppGateways. */
    public PagedCallSettings.Builder<
            ListAppGatewaysRequest, ListAppGatewaysResponse, ListAppGatewaysPagedResponse>
        listAppGatewaysSettings() {
      return getStubSettingsBuilder().listAppGatewaysSettings();
    }

    /** Returns the builder for the settings used for calls to getAppGateway. */
    public UnaryCallSettings.Builder<GetAppGatewayRequest, AppGateway> getAppGatewaySettings() {
      return getStubSettingsBuilder().getAppGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to createAppGateway. */
    public UnaryCallSettings.Builder<CreateAppGatewayRequest, Operation>
        createAppGatewaySettings() {
      return getStubSettingsBuilder().createAppGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to createAppGateway. */
    public OperationCallSettings.Builder<
            CreateAppGatewayRequest, AppGateway, AppGatewayOperationMetadata>
        createAppGatewayOperationSettings() {
      return getStubSettingsBuilder().createAppGatewayOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAppGateway. */
    public UnaryCallSettings.Builder<DeleteAppGatewayRequest, Operation>
        deleteAppGatewaySettings() {
      return getStubSettingsBuilder().deleteAppGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to deleteAppGateway. */
    public OperationCallSettings.Builder<
            DeleteAppGatewayRequest, Empty, AppGatewayOperationMetadata>
        deleteAppGatewayOperationSettings() {
      return getStubSettingsBuilder().deleteAppGatewayOperationSettings();
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
    public AppGatewaysServiceSettings build() throws IOException {
      return new AppGatewaysServiceSettings(this);
    }
  }
}
