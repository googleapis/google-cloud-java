/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.iot.v1;

import static com.google.cloud.iot.v1.DeviceManagerClient.ListDeviceRegistriesPagedResponse;
import static com.google.cloud.iot.v1.DeviceManagerClient.ListDevicesPagedResponse;

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
import com.google.cloud.iot.v1.stub.DeviceManagerStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DeviceManagerClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudiot.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createDeviceRegistry to 30 seconds:
 *
 * <pre>{@code
 * DeviceManagerSettings.Builder deviceManagerSettingsBuilder = DeviceManagerSettings.newBuilder();
 * deviceManagerSettingsBuilder
 *     .createDeviceRegistrySettings()
 *     .setRetrySettings(
 *         deviceManagerSettingsBuilder
 *             .createDeviceRegistrySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DeviceManagerSettings deviceManagerSettings = deviceManagerSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DeviceManagerSettings extends ClientSettings<DeviceManagerSettings> {

  /** Returns the object with the settings used for calls to createDeviceRegistry. */
  public UnaryCallSettings<CreateDeviceRegistryRequest, DeviceRegistry>
      createDeviceRegistrySettings() {
    return ((DeviceManagerStubSettings) getStubSettings()).createDeviceRegistrySettings();
  }

  /** Returns the object with the settings used for calls to getDeviceRegistry. */
  public UnaryCallSettings<GetDeviceRegistryRequest, DeviceRegistry> getDeviceRegistrySettings() {
    return ((DeviceManagerStubSettings) getStubSettings()).getDeviceRegistrySettings();
  }

  /** Returns the object with the settings used for calls to updateDeviceRegistry. */
  public UnaryCallSettings<UpdateDeviceRegistryRequest, DeviceRegistry>
      updateDeviceRegistrySettings() {
    return ((DeviceManagerStubSettings) getStubSettings()).updateDeviceRegistrySettings();
  }

  /** Returns the object with the settings used for calls to deleteDeviceRegistry. */
  public UnaryCallSettings<DeleteDeviceRegistryRequest, Empty> deleteDeviceRegistrySettings() {
    return ((DeviceManagerStubSettings) getStubSettings()).deleteDeviceRegistrySettings();
  }

  /** Returns the object with the settings used for calls to listDeviceRegistries. */
  public PagedCallSettings<
          ListDeviceRegistriesRequest,
          ListDeviceRegistriesResponse,
          ListDeviceRegistriesPagedResponse>
      listDeviceRegistriesSettings() {
    return ((DeviceManagerStubSettings) getStubSettings()).listDeviceRegistriesSettings();
  }

  /** Returns the object with the settings used for calls to createDevice. */
  public UnaryCallSettings<CreateDeviceRequest, Device> createDeviceSettings() {
    return ((DeviceManagerStubSettings) getStubSettings()).createDeviceSettings();
  }

  /** Returns the object with the settings used for calls to getDevice. */
  public UnaryCallSettings<GetDeviceRequest, Device> getDeviceSettings() {
    return ((DeviceManagerStubSettings) getStubSettings()).getDeviceSettings();
  }

  /** Returns the object with the settings used for calls to updateDevice. */
  public UnaryCallSettings<UpdateDeviceRequest, Device> updateDeviceSettings() {
    return ((DeviceManagerStubSettings) getStubSettings()).updateDeviceSettings();
  }

  /** Returns the object with the settings used for calls to deleteDevice. */
  public UnaryCallSettings<DeleteDeviceRequest, Empty> deleteDeviceSettings() {
    return ((DeviceManagerStubSettings) getStubSettings()).deleteDeviceSettings();
  }

  /** Returns the object with the settings used for calls to listDevices. */
  public PagedCallSettings<ListDevicesRequest, ListDevicesResponse, ListDevicesPagedResponse>
      listDevicesSettings() {
    return ((DeviceManagerStubSettings) getStubSettings()).listDevicesSettings();
  }

  /** Returns the object with the settings used for calls to modifyCloudToDeviceConfig. */
  public UnaryCallSettings<ModifyCloudToDeviceConfigRequest, DeviceConfig>
      modifyCloudToDeviceConfigSettings() {
    return ((DeviceManagerStubSettings) getStubSettings()).modifyCloudToDeviceConfigSettings();
  }

  /** Returns the object with the settings used for calls to listDeviceConfigVersions. */
  public UnaryCallSettings<ListDeviceConfigVersionsRequest, ListDeviceConfigVersionsResponse>
      listDeviceConfigVersionsSettings() {
    return ((DeviceManagerStubSettings) getStubSettings()).listDeviceConfigVersionsSettings();
  }

  /** Returns the object with the settings used for calls to listDeviceStates. */
  public UnaryCallSettings<ListDeviceStatesRequest, ListDeviceStatesResponse>
      listDeviceStatesSettings() {
    return ((DeviceManagerStubSettings) getStubSettings()).listDeviceStatesSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((DeviceManagerStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((DeviceManagerStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((DeviceManagerStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  /** Returns the object with the settings used for calls to sendCommandToDevice. */
  public UnaryCallSettings<SendCommandToDeviceRequest, SendCommandToDeviceResponse>
      sendCommandToDeviceSettings() {
    return ((DeviceManagerStubSettings) getStubSettings()).sendCommandToDeviceSettings();
  }

  /** Returns the object with the settings used for calls to bindDeviceToGateway. */
  public UnaryCallSettings<BindDeviceToGatewayRequest, BindDeviceToGatewayResponse>
      bindDeviceToGatewaySettings() {
    return ((DeviceManagerStubSettings) getStubSettings()).bindDeviceToGatewaySettings();
  }

  /** Returns the object with the settings used for calls to unbindDeviceFromGateway. */
  public UnaryCallSettings<UnbindDeviceFromGatewayRequest, UnbindDeviceFromGatewayResponse>
      unbindDeviceFromGatewaySettings() {
    return ((DeviceManagerStubSettings) getStubSettings()).unbindDeviceFromGatewaySettings();
  }

  public static final DeviceManagerSettings create(DeviceManagerStubSettings stub)
      throws IOException {
    return new DeviceManagerSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DeviceManagerStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DeviceManagerStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DeviceManagerStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DeviceManagerStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DeviceManagerStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DeviceManagerStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DeviceManagerStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DeviceManagerSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DeviceManagerSettings. */
  public static class Builder extends ClientSettings.Builder<DeviceManagerSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DeviceManagerStubSettings.newBuilder(clientContext));
    }

    protected Builder(DeviceManagerSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DeviceManagerStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DeviceManagerStubSettings.newBuilder());
    }

    public DeviceManagerStubSettings.Builder getStubSettingsBuilder() {
      return ((DeviceManagerStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to createDeviceRegistry. */
    public UnaryCallSettings.Builder<CreateDeviceRegistryRequest, DeviceRegistry>
        createDeviceRegistrySettings() {
      return getStubSettingsBuilder().createDeviceRegistrySettings();
    }

    /** Returns the builder for the settings used for calls to getDeviceRegistry. */
    public UnaryCallSettings.Builder<GetDeviceRegistryRequest, DeviceRegistry>
        getDeviceRegistrySettings() {
      return getStubSettingsBuilder().getDeviceRegistrySettings();
    }

    /** Returns the builder for the settings used for calls to updateDeviceRegistry. */
    public UnaryCallSettings.Builder<UpdateDeviceRegistryRequest, DeviceRegistry>
        updateDeviceRegistrySettings() {
      return getStubSettingsBuilder().updateDeviceRegistrySettings();
    }

    /** Returns the builder for the settings used for calls to deleteDeviceRegistry. */
    public UnaryCallSettings.Builder<DeleteDeviceRegistryRequest, Empty>
        deleteDeviceRegistrySettings() {
      return getStubSettingsBuilder().deleteDeviceRegistrySettings();
    }

    /** Returns the builder for the settings used for calls to listDeviceRegistries. */
    public PagedCallSettings.Builder<
            ListDeviceRegistriesRequest,
            ListDeviceRegistriesResponse,
            ListDeviceRegistriesPagedResponse>
        listDeviceRegistriesSettings() {
      return getStubSettingsBuilder().listDeviceRegistriesSettings();
    }

    /** Returns the builder for the settings used for calls to createDevice. */
    public UnaryCallSettings.Builder<CreateDeviceRequest, Device> createDeviceSettings() {
      return getStubSettingsBuilder().createDeviceSettings();
    }

    /** Returns the builder for the settings used for calls to getDevice. */
    public UnaryCallSettings.Builder<GetDeviceRequest, Device> getDeviceSettings() {
      return getStubSettingsBuilder().getDeviceSettings();
    }

    /** Returns the builder for the settings used for calls to updateDevice. */
    public UnaryCallSettings.Builder<UpdateDeviceRequest, Device> updateDeviceSettings() {
      return getStubSettingsBuilder().updateDeviceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDevice. */
    public UnaryCallSettings.Builder<DeleteDeviceRequest, Empty> deleteDeviceSettings() {
      return getStubSettingsBuilder().deleteDeviceSettings();
    }

    /** Returns the builder for the settings used for calls to listDevices. */
    public PagedCallSettings.Builder<
            ListDevicesRequest, ListDevicesResponse, ListDevicesPagedResponse>
        listDevicesSettings() {
      return getStubSettingsBuilder().listDevicesSettings();
    }

    /** Returns the builder for the settings used for calls to modifyCloudToDeviceConfig. */
    public UnaryCallSettings.Builder<ModifyCloudToDeviceConfigRequest, DeviceConfig>
        modifyCloudToDeviceConfigSettings() {
      return getStubSettingsBuilder().modifyCloudToDeviceConfigSettings();
    }

    /** Returns the builder for the settings used for calls to listDeviceConfigVersions. */
    public UnaryCallSettings.Builder<
            ListDeviceConfigVersionsRequest, ListDeviceConfigVersionsResponse>
        listDeviceConfigVersionsSettings() {
      return getStubSettingsBuilder().listDeviceConfigVersionsSettings();
    }

    /** Returns the builder for the settings used for calls to listDeviceStates. */
    public UnaryCallSettings.Builder<ListDeviceStatesRequest, ListDeviceStatesResponse>
        listDeviceStatesSettings() {
      return getStubSettingsBuilder().listDeviceStatesSettings();
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

    /** Returns the builder for the settings used for calls to sendCommandToDevice. */
    public UnaryCallSettings.Builder<SendCommandToDeviceRequest, SendCommandToDeviceResponse>
        sendCommandToDeviceSettings() {
      return getStubSettingsBuilder().sendCommandToDeviceSettings();
    }

    /** Returns the builder for the settings used for calls to bindDeviceToGateway. */
    public UnaryCallSettings.Builder<BindDeviceToGatewayRequest, BindDeviceToGatewayResponse>
        bindDeviceToGatewaySettings() {
      return getStubSettingsBuilder().bindDeviceToGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to unbindDeviceFromGateway. */
    public UnaryCallSettings.Builder<
            UnbindDeviceFromGatewayRequest, UnbindDeviceFromGatewayResponse>
        unbindDeviceFromGatewaySettings() {
      return getStubSettingsBuilder().unbindDeviceFromGatewaySettings();
    }

    @Override
    public DeviceManagerSettings build() throws IOException {
      return new DeviceManagerSettings(this);
    }
  }
}
