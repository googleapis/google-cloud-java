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

package com.google.cloud.iot.v1.stub;

import static com.google.cloud.iot.v1.DeviceManagerClient.ListDeviceRegistriesPagedResponse;
import static com.google.cloud.iot.v1.DeviceManagerClient.ListDevicesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.iot.v1.BindDeviceToGatewayRequest;
import com.google.cloud.iot.v1.BindDeviceToGatewayResponse;
import com.google.cloud.iot.v1.CreateDeviceRegistryRequest;
import com.google.cloud.iot.v1.CreateDeviceRequest;
import com.google.cloud.iot.v1.DeleteDeviceRegistryRequest;
import com.google.cloud.iot.v1.DeleteDeviceRequest;
import com.google.cloud.iot.v1.Device;
import com.google.cloud.iot.v1.DeviceConfig;
import com.google.cloud.iot.v1.DeviceRegistry;
import com.google.cloud.iot.v1.GetDeviceRegistryRequest;
import com.google.cloud.iot.v1.GetDeviceRequest;
import com.google.cloud.iot.v1.ListDeviceConfigVersionsRequest;
import com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse;
import com.google.cloud.iot.v1.ListDeviceRegistriesRequest;
import com.google.cloud.iot.v1.ListDeviceRegistriesResponse;
import com.google.cloud.iot.v1.ListDeviceStatesRequest;
import com.google.cloud.iot.v1.ListDeviceStatesResponse;
import com.google.cloud.iot.v1.ListDevicesRequest;
import com.google.cloud.iot.v1.ListDevicesResponse;
import com.google.cloud.iot.v1.ModifyCloudToDeviceConfigRequest;
import com.google.cloud.iot.v1.SendCommandToDeviceRequest;
import com.google.cloud.iot.v1.SendCommandToDeviceResponse;
import com.google.cloud.iot.v1.UnbindDeviceFromGatewayRequest;
import com.google.cloud.iot.v1.UnbindDeviceFromGatewayResponse;
import com.google.cloud.iot.v1.UpdateDeviceRegistryRequest;
import com.google.cloud.iot.v1.UpdateDeviceRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DeviceManagerStub}.
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
 * DeviceManagerStubSettings.Builder deviceManagerSettingsBuilder =
 *     DeviceManagerStubSettings.newBuilder();
 * deviceManagerSettingsBuilder
 *     .createDeviceRegistrySettings()
 *     .setRetrySettings(
 *         deviceManagerSettingsBuilder
 *             .createDeviceRegistrySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DeviceManagerStubSettings deviceManagerSettings = deviceManagerSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DeviceManagerStubSettings extends StubSettings<DeviceManagerStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloudiot")
          .build();

  private final UnaryCallSettings<CreateDeviceRegistryRequest, DeviceRegistry>
      createDeviceRegistrySettings;
  private final UnaryCallSettings<GetDeviceRegistryRequest, DeviceRegistry>
      getDeviceRegistrySettings;
  private final UnaryCallSettings<UpdateDeviceRegistryRequest, DeviceRegistry>
      updateDeviceRegistrySettings;
  private final UnaryCallSettings<DeleteDeviceRegistryRequest, Empty> deleteDeviceRegistrySettings;
  private final PagedCallSettings<
          ListDeviceRegistriesRequest,
          ListDeviceRegistriesResponse,
          ListDeviceRegistriesPagedResponse>
      listDeviceRegistriesSettings;
  private final UnaryCallSettings<CreateDeviceRequest, Device> createDeviceSettings;
  private final UnaryCallSettings<GetDeviceRequest, Device> getDeviceSettings;
  private final UnaryCallSettings<UpdateDeviceRequest, Device> updateDeviceSettings;
  private final UnaryCallSettings<DeleteDeviceRequest, Empty> deleteDeviceSettings;
  private final PagedCallSettings<ListDevicesRequest, ListDevicesResponse, ListDevicesPagedResponse>
      listDevicesSettings;
  private final UnaryCallSettings<ModifyCloudToDeviceConfigRequest, DeviceConfig>
      modifyCloudToDeviceConfigSettings;
  private final UnaryCallSettings<ListDeviceConfigVersionsRequest, ListDeviceConfigVersionsResponse>
      listDeviceConfigVersionsSettings;
  private final UnaryCallSettings<ListDeviceStatesRequest, ListDeviceStatesResponse>
      listDeviceStatesSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;
  private final UnaryCallSettings<SendCommandToDeviceRequest, SendCommandToDeviceResponse>
      sendCommandToDeviceSettings;
  private final UnaryCallSettings<BindDeviceToGatewayRequest, BindDeviceToGatewayResponse>
      bindDeviceToGatewaySettings;
  private final UnaryCallSettings<UnbindDeviceFromGatewayRequest, UnbindDeviceFromGatewayResponse>
      unbindDeviceFromGatewaySettings;

  private static final PagedListDescriptor<
          ListDeviceRegistriesRequest, ListDeviceRegistriesResponse, DeviceRegistry>
      LIST_DEVICE_REGISTRIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDeviceRegistriesRequest, ListDeviceRegistriesResponse, DeviceRegistry>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDeviceRegistriesRequest injectToken(
                ListDeviceRegistriesRequest payload, String token) {
              return ListDeviceRegistriesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDeviceRegistriesRequest injectPageSize(
                ListDeviceRegistriesRequest payload, int pageSize) {
              return ListDeviceRegistriesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDeviceRegistriesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDeviceRegistriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DeviceRegistry> extractResources(ListDeviceRegistriesResponse payload) {
              return payload.getDeviceRegistriesList() == null
                  ? ImmutableList.<DeviceRegistry>of()
                  : payload.getDeviceRegistriesList();
            }
          };

  private static final PagedListDescriptor<ListDevicesRequest, ListDevicesResponse, Device>
      LIST_DEVICES_PAGE_STR_DESC =
          new PagedListDescriptor<ListDevicesRequest, ListDevicesResponse, Device>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDevicesRequest injectToken(ListDevicesRequest payload, String token) {
              return ListDevicesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDevicesRequest injectPageSize(ListDevicesRequest payload, int pageSize) {
              return ListDevicesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDevicesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDevicesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Device> extractResources(ListDevicesResponse payload) {
              return payload.getDevicesList() == null
                  ? ImmutableList.<Device>of()
                  : payload.getDevicesList();
            }
          };

  private static final PagedListResponseFactory<
          ListDeviceRegistriesRequest,
          ListDeviceRegistriesResponse,
          ListDeviceRegistriesPagedResponse>
      LIST_DEVICE_REGISTRIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDeviceRegistriesRequest,
              ListDeviceRegistriesResponse,
              ListDeviceRegistriesPagedResponse>() {
            @Override
            public ApiFuture<ListDeviceRegistriesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDeviceRegistriesRequest, ListDeviceRegistriesResponse> callable,
                ListDeviceRegistriesRequest request,
                ApiCallContext context,
                ApiFuture<ListDeviceRegistriesResponse> futureResponse) {
              PageContext<ListDeviceRegistriesRequest, ListDeviceRegistriesResponse, DeviceRegistry>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DEVICE_REGISTRIES_PAGE_STR_DESC, request, context);
              return ListDeviceRegistriesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDevicesRequest, ListDevicesResponse, ListDevicesPagedResponse>
      LIST_DEVICES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDevicesRequest, ListDevicesResponse, ListDevicesPagedResponse>() {
            @Override
            public ApiFuture<ListDevicesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDevicesRequest, ListDevicesResponse> callable,
                ListDevicesRequest request,
                ApiCallContext context,
                ApiFuture<ListDevicesResponse> futureResponse) {
              PageContext<ListDevicesRequest, ListDevicesResponse, Device> pageContext =
                  PageContext.create(callable, LIST_DEVICES_PAGE_STR_DESC, request, context);
              return ListDevicesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createDeviceRegistry. */
  public UnaryCallSettings<CreateDeviceRegistryRequest, DeviceRegistry>
      createDeviceRegistrySettings() {
    return createDeviceRegistrySettings;
  }

  /** Returns the object with the settings used for calls to getDeviceRegistry. */
  public UnaryCallSettings<GetDeviceRegistryRequest, DeviceRegistry> getDeviceRegistrySettings() {
    return getDeviceRegistrySettings;
  }

  /** Returns the object with the settings used for calls to updateDeviceRegistry. */
  public UnaryCallSettings<UpdateDeviceRegistryRequest, DeviceRegistry>
      updateDeviceRegistrySettings() {
    return updateDeviceRegistrySettings;
  }

  /** Returns the object with the settings used for calls to deleteDeviceRegistry. */
  public UnaryCallSettings<DeleteDeviceRegistryRequest, Empty> deleteDeviceRegistrySettings() {
    return deleteDeviceRegistrySettings;
  }

  /** Returns the object with the settings used for calls to listDeviceRegistries. */
  public PagedCallSettings<
          ListDeviceRegistriesRequest,
          ListDeviceRegistriesResponse,
          ListDeviceRegistriesPagedResponse>
      listDeviceRegistriesSettings() {
    return listDeviceRegistriesSettings;
  }

  /** Returns the object with the settings used for calls to createDevice. */
  public UnaryCallSettings<CreateDeviceRequest, Device> createDeviceSettings() {
    return createDeviceSettings;
  }

  /** Returns the object with the settings used for calls to getDevice. */
  public UnaryCallSettings<GetDeviceRequest, Device> getDeviceSettings() {
    return getDeviceSettings;
  }

  /** Returns the object with the settings used for calls to updateDevice. */
  public UnaryCallSettings<UpdateDeviceRequest, Device> updateDeviceSettings() {
    return updateDeviceSettings;
  }

  /** Returns the object with the settings used for calls to deleteDevice. */
  public UnaryCallSettings<DeleteDeviceRequest, Empty> deleteDeviceSettings() {
    return deleteDeviceSettings;
  }

  /** Returns the object with the settings used for calls to listDevices. */
  public PagedCallSettings<ListDevicesRequest, ListDevicesResponse, ListDevicesPagedResponse>
      listDevicesSettings() {
    return listDevicesSettings;
  }

  /** Returns the object with the settings used for calls to modifyCloudToDeviceConfig. */
  public UnaryCallSettings<ModifyCloudToDeviceConfigRequest, DeviceConfig>
      modifyCloudToDeviceConfigSettings() {
    return modifyCloudToDeviceConfigSettings;
  }

  /** Returns the object with the settings used for calls to listDeviceConfigVersions. */
  public UnaryCallSettings<ListDeviceConfigVersionsRequest, ListDeviceConfigVersionsResponse>
      listDeviceConfigVersionsSettings() {
    return listDeviceConfigVersionsSettings;
  }

  /** Returns the object with the settings used for calls to listDeviceStates. */
  public UnaryCallSettings<ListDeviceStatesRequest, ListDeviceStatesResponse>
      listDeviceStatesSettings() {
    return listDeviceStatesSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  /** Returns the object with the settings used for calls to sendCommandToDevice. */
  public UnaryCallSettings<SendCommandToDeviceRequest, SendCommandToDeviceResponse>
      sendCommandToDeviceSettings() {
    return sendCommandToDeviceSettings;
  }

  /** Returns the object with the settings used for calls to bindDeviceToGateway. */
  public UnaryCallSettings<BindDeviceToGatewayRequest, BindDeviceToGatewayResponse>
      bindDeviceToGatewaySettings() {
    return bindDeviceToGatewaySettings;
  }

  /** Returns the object with the settings used for calls to unbindDeviceFromGateway. */
  public UnaryCallSettings<UnbindDeviceFromGatewayRequest, UnbindDeviceFromGatewayResponse>
      unbindDeviceFromGatewaySettings() {
    return unbindDeviceFromGatewaySettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DeviceManagerStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDeviceManagerStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "cloudiot.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DeviceManagerStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
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

  protected DeviceManagerStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createDeviceRegistrySettings = settingsBuilder.createDeviceRegistrySettings().build();
    getDeviceRegistrySettings = settingsBuilder.getDeviceRegistrySettings().build();
    updateDeviceRegistrySettings = settingsBuilder.updateDeviceRegistrySettings().build();
    deleteDeviceRegistrySettings = settingsBuilder.deleteDeviceRegistrySettings().build();
    listDeviceRegistriesSettings = settingsBuilder.listDeviceRegistriesSettings().build();
    createDeviceSettings = settingsBuilder.createDeviceSettings().build();
    getDeviceSettings = settingsBuilder.getDeviceSettings().build();
    updateDeviceSettings = settingsBuilder.updateDeviceSettings().build();
    deleteDeviceSettings = settingsBuilder.deleteDeviceSettings().build();
    listDevicesSettings = settingsBuilder.listDevicesSettings().build();
    modifyCloudToDeviceConfigSettings = settingsBuilder.modifyCloudToDeviceConfigSettings().build();
    listDeviceConfigVersionsSettings = settingsBuilder.listDeviceConfigVersionsSettings().build();
    listDeviceStatesSettings = settingsBuilder.listDeviceStatesSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
    sendCommandToDeviceSettings = settingsBuilder.sendCommandToDeviceSettings().build();
    bindDeviceToGatewaySettings = settingsBuilder.bindDeviceToGatewaySettings().build();
    unbindDeviceFromGatewaySettings = settingsBuilder.unbindDeviceFromGatewaySettings().build();
  }

  /** Builder for DeviceManagerStubSettings. */
  public static class Builder extends StubSettings.Builder<DeviceManagerStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateDeviceRegistryRequest, DeviceRegistry>
        createDeviceRegistrySettings;
    private final UnaryCallSettings.Builder<GetDeviceRegistryRequest, DeviceRegistry>
        getDeviceRegistrySettings;
    private final UnaryCallSettings.Builder<UpdateDeviceRegistryRequest, DeviceRegistry>
        updateDeviceRegistrySettings;
    private final UnaryCallSettings.Builder<DeleteDeviceRegistryRequest, Empty>
        deleteDeviceRegistrySettings;
    private final PagedCallSettings.Builder<
            ListDeviceRegistriesRequest,
            ListDeviceRegistriesResponse,
            ListDeviceRegistriesPagedResponse>
        listDeviceRegistriesSettings;
    private final UnaryCallSettings.Builder<CreateDeviceRequest, Device> createDeviceSettings;
    private final UnaryCallSettings.Builder<GetDeviceRequest, Device> getDeviceSettings;
    private final UnaryCallSettings.Builder<UpdateDeviceRequest, Device> updateDeviceSettings;
    private final UnaryCallSettings.Builder<DeleteDeviceRequest, Empty> deleteDeviceSettings;
    private final PagedCallSettings.Builder<
            ListDevicesRequest, ListDevicesResponse, ListDevicesPagedResponse>
        listDevicesSettings;
    private final UnaryCallSettings.Builder<ModifyCloudToDeviceConfigRequest, DeviceConfig>
        modifyCloudToDeviceConfigSettings;
    private final UnaryCallSettings.Builder<
            ListDeviceConfigVersionsRequest, ListDeviceConfigVersionsResponse>
        listDeviceConfigVersionsSettings;
    private final UnaryCallSettings.Builder<ListDeviceStatesRequest, ListDeviceStatesResponse>
        listDeviceStatesSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private final UnaryCallSettings.Builder<SendCommandToDeviceRequest, SendCommandToDeviceResponse>
        sendCommandToDeviceSettings;
    private final UnaryCallSettings.Builder<BindDeviceToGatewayRequest, BindDeviceToGatewayResponse>
        bindDeviceToGatewaySettings;
    private final UnaryCallSettings.Builder<
            UnbindDeviceFromGatewayRequest, UnbindDeviceFromGatewayResponse>
        unbindDeviceFromGatewaySettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.DEADLINE_EXCEEDED)));
      definitions.put(
          "retry_policy_2_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE,
                  StatusCode.Code.DEADLINE_EXCEEDED,
                  StatusCode.Code.RESOURCE_EXHAUSTED)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(120000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(120000L))
              .setTotalTimeout(Duration.ofMillis(120000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(120000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(120000L))
              .setTotalTimeout(Duration.ofMillis(120000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(120000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(120000L))
              .setTotalTimeout(Duration.ofMillis(120000L))
              .build();
      definitions.put("retry_policy_2_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createDeviceRegistrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDeviceRegistrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDeviceRegistrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDeviceRegistrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDeviceRegistriesSettings =
          PagedCallSettings.newBuilder(LIST_DEVICE_REGISTRIES_PAGE_STR_FACT);
      createDeviceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDeviceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDeviceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDeviceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDevicesSettings = PagedCallSettings.newBuilder(LIST_DEVICES_PAGE_STR_FACT);
      modifyCloudToDeviceConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDeviceConfigVersionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDeviceStatesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      sendCommandToDeviceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      bindDeviceToGatewaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      unbindDeviceFromGatewaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDeviceRegistrySettings,
              getDeviceRegistrySettings,
              updateDeviceRegistrySettings,
              deleteDeviceRegistrySettings,
              listDeviceRegistriesSettings,
              createDeviceSettings,
              getDeviceSettings,
              updateDeviceSettings,
              deleteDeviceSettings,
              listDevicesSettings,
              modifyCloudToDeviceConfigSettings,
              listDeviceConfigVersionsSettings,
              listDeviceStatesSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings,
              sendCommandToDeviceSettings,
              bindDeviceToGatewaySettings,
              unbindDeviceFromGatewaySettings);
      initDefaults(this);
    }

    protected Builder(DeviceManagerStubSettings settings) {
      super(settings);

      createDeviceRegistrySettings = settings.createDeviceRegistrySettings.toBuilder();
      getDeviceRegistrySettings = settings.getDeviceRegistrySettings.toBuilder();
      updateDeviceRegistrySettings = settings.updateDeviceRegistrySettings.toBuilder();
      deleteDeviceRegistrySettings = settings.deleteDeviceRegistrySettings.toBuilder();
      listDeviceRegistriesSettings = settings.listDeviceRegistriesSettings.toBuilder();
      createDeviceSettings = settings.createDeviceSettings.toBuilder();
      getDeviceSettings = settings.getDeviceSettings.toBuilder();
      updateDeviceSettings = settings.updateDeviceSettings.toBuilder();
      deleteDeviceSettings = settings.deleteDeviceSettings.toBuilder();
      listDevicesSettings = settings.listDevicesSettings.toBuilder();
      modifyCloudToDeviceConfigSettings = settings.modifyCloudToDeviceConfigSettings.toBuilder();
      listDeviceConfigVersionsSettings = settings.listDeviceConfigVersionsSettings.toBuilder();
      listDeviceStatesSettings = settings.listDeviceStatesSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();
      sendCommandToDeviceSettings = settings.sendCommandToDeviceSettings.toBuilder();
      bindDeviceToGatewaySettings = settings.bindDeviceToGatewaySettings.toBuilder();
      unbindDeviceFromGatewaySettings = settings.unbindDeviceFromGatewaySettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDeviceRegistrySettings,
              getDeviceRegistrySettings,
              updateDeviceRegistrySettings,
              deleteDeviceRegistrySettings,
              listDeviceRegistriesSettings,
              createDeviceSettings,
              getDeviceSettings,
              updateDeviceSettings,
              deleteDeviceSettings,
              listDevicesSettings,
              modifyCloudToDeviceConfigSettings,
              listDeviceConfigVersionsSettings,
              listDeviceStatesSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings,
              sendCommandToDeviceSettings,
              bindDeviceToGatewaySettings,
              unbindDeviceFromGatewaySettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createDeviceRegistrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getDeviceRegistrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .updateDeviceRegistrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteDeviceRegistrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listDeviceRegistriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .createDeviceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getDeviceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .updateDeviceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteDeviceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listDevicesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .modifyCloudToDeviceConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .listDeviceConfigVersionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listDeviceStatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .sendCommandToDeviceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .bindDeviceToGatewaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .unbindDeviceFromGatewaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      return builder;
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to createDeviceRegistry. */
    public UnaryCallSettings.Builder<CreateDeviceRegistryRequest, DeviceRegistry>
        createDeviceRegistrySettings() {
      return createDeviceRegistrySettings;
    }

    /** Returns the builder for the settings used for calls to getDeviceRegistry. */
    public UnaryCallSettings.Builder<GetDeviceRegistryRequest, DeviceRegistry>
        getDeviceRegistrySettings() {
      return getDeviceRegistrySettings;
    }

    /** Returns the builder for the settings used for calls to updateDeviceRegistry. */
    public UnaryCallSettings.Builder<UpdateDeviceRegistryRequest, DeviceRegistry>
        updateDeviceRegistrySettings() {
      return updateDeviceRegistrySettings;
    }

    /** Returns the builder for the settings used for calls to deleteDeviceRegistry. */
    public UnaryCallSettings.Builder<DeleteDeviceRegistryRequest, Empty>
        deleteDeviceRegistrySettings() {
      return deleteDeviceRegistrySettings;
    }

    /** Returns the builder for the settings used for calls to listDeviceRegistries. */
    public PagedCallSettings.Builder<
            ListDeviceRegistriesRequest,
            ListDeviceRegistriesResponse,
            ListDeviceRegistriesPagedResponse>
        listDeviceRegistriesSettings() {
      return listDeviceRegistriesSettings;
    }

    /** Returns the builder for the settings used for calls to createDevice. */
    public UnaryCallSettings.Builder<CreateDeviceRequest, Device> createDeviceSettings() {
      return createDeviceSettings;
    }

    /** Returns the builder for the settings used for calls to getDevice. */
    public UnaryCallSettings.Builder<GetDeviceRequest, Device> getDeviceSettings() {
      return getDeviceSettings;
    }

    /** Returns the builder for the settings used for calls to updateDevice. */
    public UnaryCallSettings.Builder<UpdateDeviceRequest, Device> updateDeviceSettings() {
      return updateDeviceSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDevice. */
    public UnaryCallSettings.Builder<DeleteDeviceRequest, Empty> deleteDeviceSettings() {
      return deleteDeviceSettings;
    }

    /** Returns the builder for the settings used for calls to listDevices. */
    public PagedCallSettings.Builder<
            ListDevicesRequest, ListDevicesResponse, ListDevicesPagedResponse>
        listDevicesSettings() {
      return listDevicesSettings;
    }

    /** Returns the builder for the settings used for calls to modifyCloudToDeviceConfig. */
    public UnaryCallSettings.Builder<ModifyCloudToDeviceConfigRequest, DeviceConfig>
        modifyCloudToDeviceConfigSettings() {
      return modifyCloudToDeviceConfigSettings;
    }

    /** Returns the builder for the settings used for calls to listDeviceConfigVersions. */
    public UnaryCallSettings.Builder<
            ListDeviceConfigVersionsRequest, ListDeviceConfigVersionsResponse>
        listDeviceConfigVersionsSettings() {
      return listDeviceConfigVersionsSettings;
    }

    /** Returns the builder for the settings used for calls to listDeviceStates. */
    public UnaryCallSettings.Builder<ListDeviceStatesRequest, ListDeviceStatesResponse>
        listDeviceStatesSettings() {
      return listDeviceStatesSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    /** Returns the builder for the settings used for calls to sendCommandToDevice. */
    public UnaryCallSettings.Builder<SendCommandToDeviceRequest, SendCommandToDeviceResponse>
        sendCommandToDeviceSettings() {
      return sendCommandToDeviceSettings;
    }

    /** Returns the builder for the settings used for calls to bindDeviceToGateway. */
    public UnaryCallSettings.Builder<BindDeviceToGatewayRequest, BindDeviceToGatewayResponse>
        bindDeviceToGatewaySettings() {
      return bindDeviceToGatewaySettings;
    }

    /** Returns the builder for the settings used for calls to unbindDeviceFromGateway. */
    public UnaryCallSettings.Builder<
            UnbindDeviceFromGatewayRequest, UnbindDeviceFromGatewayResponse>
        unbindDeviceFromGatewaySettings() {
      return unbindDeviceFromGatewaySettings;
    }

    @Override
    public DeviceManagerStubSettings build() throws IOException {
      return new DeviceManagerStubSettings(this);
    }
  }
}
