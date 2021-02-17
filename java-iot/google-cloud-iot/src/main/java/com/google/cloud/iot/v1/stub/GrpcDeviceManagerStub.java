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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
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
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DeviceManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDeviceManagerStub extends DeviceManagerStub {
  private static final MethodDescriptor<CreateDeviceRegistryRequest, DeviceRegistry>
      createDeviceRegistryMethodDescriptor =
          MethodDescriptor.<CreateDeviceRegistryRequest, DeviceRegistry>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/CreateDeviceRegistry")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDeviceRegistryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DeviceRegistry.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDeviceRegistryRequest, DeviceRegistry>
      getDeviceRegistryMethodDescriptor =
          MethodDescriptor.<GetDeviceRegistryRequest, DeviceRegistry>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/GetDeviceRegistry")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDeviceRegistryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DeviceRegistry.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDeviceRegistryRequest, DeviceRegistry>
      updateDeviceRegistryMethodDescriptor =
          MethodDescriptor.<UpdateDeviceRegistryRequest, DeviceRegistry>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/UpdateDeviceRegistry")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDeviceRegistryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DeviceRegistry.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDeviceRegistryRequest, Empty>
      deleteDeviceRegistryMethodDescriptor =
          MethodDescriptor.<DeleteDeviceRegistryRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/DeleteDeviceRegistry")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDeviceRegistryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDeviceRegistriesRequest, ListDeviceRegistriesResponse>
      listDeviceRegistriesMethodDescriptor =
          MethodDescriptor.<ListDeviceRegistriesRequest, ListDeviceRegistriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/ListDeviceRegistries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDeviceRegistriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDeviceRegistriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDeviceRequest, Device> createDeviceMethodDescriptor =
      MethodDescriptor.<CreateDeviceRequest, Device>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.iot.v1.DeviceManager/CreateDevice")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateDeviceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Device.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetDeviceRequest, Device> getDeviceMethodDescriptor =
      MethodDescriptor.<GetDeviceRequest, Device>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.iot.v1.DeviceManager/GetDevice")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDeviceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Device.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateDeviceRequest, Device> updateDeviceMethodDescriptor =
      MethodDescriptor.<UpdateDeviceRequest, Device>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.iot.v1.DeviceManager/UpdateDevice")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateDeviceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Device.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteDeviceRequest, Empty> deleteDeviceMethodDescriptor =
      MethodDescriptor.<DeleteDeviceRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.iot.v1.DeviceManager/DeleteDevice")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteDeviceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListDevicesRequest, ListDevicesResponse>
      listDevicesMethodDescriptor =
          MethodDescriptor.<ListDevicesRequest, ListDevicesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/ListDevices")
              .setRequestMarshaller(ProtoUtils.marshaller(ListDevicesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDevicesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ModifyCloudToDeviceConfigRequest, DeviceConfig>
      modifyCloudToDeviceConfigMethodDescriptor =
          MethodDescriptor.<ModifyCloudToDeviceConfigRequest, DeviceConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/ModifyCloudToDeviceConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ModifyCloudToDeviceConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DeviceConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListDeviceConfigVersionsRequest, ListDeviceConfigVersionsResponse>
      listDeviceConfigVersionsMethodDescriptor =
          MethodDescriptor
              .<ListDeviceConfigVersionsRequest, ListDeviceConfigVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/ListDeviceConfigVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDeviceConfigVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDeviceConfigVersionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDeviceStatesRequest, ListDeviceStatesResponse>
      listDeviceStatesMethodDescriptor =
          MethodDescriptor.<ListDeviceStatesRequest, ListDeviceStatesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/ListDeviceStates")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDeviceStatesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDeviceStatesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.iot.v1.DeviceManager/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.iot.v1.DeviceManager/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SendCommandToDeviceRequest, SendCommandToDeviceResponse>
      sendCommandToDeviceMethodDescriptor =
          MethodDescriptor.<SendCommandToDeviceRequest, SendCommandToDeviceResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/SendCommandToDevice")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SendCommandToDeviceRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SendCommandToDeviceResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BindDeviceToGatewayRequest, BindDeviceToGatewayResponse>
      bindDeviceToGatewayMethodDescriptor =
          MethodDescriptor.<BindDeviceToGatewayRequest, BindDeviceToGatewayResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/BindDeviceToGateway")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BindDeviceToGatewayRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BindDeviceToGatewayResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          UnbindDeviceFromGatewayRequest, UnbindDeviceFromGatewayResponse>
      unbindDeviceFromGatewayMethodDescriptor =
          MethodDescriptor
              .<UnbindDeviceFromGatewayRequest, UnbindDeviceFromGatewayResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/UnbindDeviceFromGateway")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UnbindDeviceFromGatewayRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UnbindDeviceFromGatewayResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateDeviceRegistryRequest, DeviceRegistry>
      createDeviceRegistryCallable;
  private final UnaryCallable<GetDeviceRegistryRequest, DeviceRegistry> getDeviceRegistryCallable;
  private final UnaryCallable<UpdateDeviceRegistryRequest, DeviceRegistry>
      updateDeviceRegistryCallable;
  private final UnaryCallable<DeleteDeviceRegistryRequest, Empty> deleteDeviceRegistryCallable;
  private final UnaryCallable<ListDeviceRegistriesRequest, ListDeviceRegistriesResponse>
      listDeviceRegistriesCallable;
  private final UnaryCallable<ListDeviceRegistriesRequest, ListDeviceRegistriesPagedResponse>
      listDeviceRegistriesPagedCallable;
  private final UnaryCallable<CreateDeviceRequest, Device> createDeviceCallable;
  private final UnaryCallable<GetDeviceRequest, Device> getDeviceCallable;
  private final UnaryCallable<UpdateDeviceRequest, Device> updateDeviceCallable;
  private final UnaryCallable<DeleteDeviceRequest, Empty> deleteDeviceCallable;
  private final UnaryCallable<ListDevicesRequest, ListDevicesResponse> listDevicesCallable;
  private final UnaryCallable<ListDevicesRequest, ListDevicesPagedResponse>
      listDevicesPagedCallable;
  private final UnaryCallable<ModifyCloudToDeviceConfigRequest, DeviceConfig>
      modifyCloudToDeviceConfigCallable;
  private final UnaryCallable<ListDeviceConfigVersionsRequest, ListDeviceConfigVersionsResponse>
      listDeviceConfigVersionsCallable;
  private final UnaryCallable<ListDeviceStatesRequest, ListDeviceStatesResponse>
      listDeviceStatesCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;
  private final UnaryCallable<SendCommandToDeviceRequest, SendCommandToDeviceResponse>
      sendCommandToDeviceCallable;
  private final UnaryCallable<BindDeviceToGatewayRequest, BindDeviceToGatewayResponse>
      bindDeviceToGatewayCallable;
  private final UnaryCallable<UnbindDeviceFromGatewayRequest, UnbindDeviceFromGatewayResponse>
      unbindDeviceFromGatewayCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDeviceManagerStub create(DeviceManagerStubSettings settings)
      throws IOException {
    return new GrpcDeviceManagerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDeviceManagerStub create(ClientContext clientContext) throws IOException {
    return new GrpcDeviceManagerStub(DeviceManagerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDeviceManagerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDeviceManagerStub(
        DeviceManagerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDeviceManagerStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDeviceManagerStub(DeviceManagerStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDeviceManagerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDeviceManagerStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDeviceManagerStub(
      DeviceManagerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateDeviceRegistryRequest, DeviceRegistry>
        createDeviceRegistryTransportSettings =
            GrpcCallSettings.<CreateDeviceRegistryRequest, DeviceRegistry>newBuilder()
                .setMethodDescriptor(createDeviceRegistryMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CreateDeviceRegistryRequest>() {
                      @Override
                      public Map<String, String> extract(CreateDeviceRegistryRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetDeviceRegistryRequest, DeviceRegistry> getDeviceRegistryTransportSettings =
        GrpcCallSettings.<GetDeviceRegistryRequest, DeviceRegistry>newBuilder()
            .setMethodDescriptor(getDeviceRegistryMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetDeviceRegistryRequest>() {
                  @Override
                  public Map<String, String> extract(GetDeviceRegistryRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateDeviceRegistryRequest, DeviceRegistry>
        updateDeviceRegistryTransportSettings =
            GrpcCallSettings.<UpdateDeviceRegistryRequest, DeviceRegistry>newBuilder()
                .setMethodDescriptor(updateDeviceRegistryMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<UpdateDeviceRegistryRequest>() {
                      @Override
                      public Map<String, String> extract(UpdateDeviceRegistryRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put(
                            "device_registry.name",
                            String.valueOf(request.getDeviceRegistry().getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeleteDeviceRegistryRequest, Empty> deleteDeviceRegistryTransportSettings =
        GrpcCallSettings.<DeleteDeviceRegistryRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDeviceRegistryMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteDeviceRegistryRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteDeviceRegistryRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListDeviceRegistriesRequest, ListDeviceRegistriesResponse>
        listDeviceRegistriesTransportSettings =
            GrpcCallSettings.<ListDeviceRegistriesRequest, ListDeviceRegistriesResponse>newBuilder()
                .setMethodDescriptor(listDeviceRegistriesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListDeviceRegistriesRequest>() {
                      @Override
                      public Map<String, String> extract(ListDeviceRegistriesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CreateDeviceRequest, Device> createDeviceTransportSettings =
        GrpcCallSettings.<CreateDeviceRequest, Device>newBuilder()
            .setMethodDescriptor(createDeviceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateDeviceRequest>() {
                  @Override
                  public Map<String, String> extract(CreateDeviceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetDeviceRequest, Device> getDeviceTransportSettings =
        GrpcCallSettings.<GetDeviceRequest, Device>newBuilder()
            .setMethodDescriptor(getDeviceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetDeviceRequest>() {
                  @Override
                  public Map<String, String> extract(GetDeviceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateDeviceRequest, Device> updateDeviceTransportSettings =
        GrpcCallSettings.<UpdateDeviceRequest, Device>newBuilder()
            .setMethodDescriptor(updateDeviceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateDeviceRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateDeviceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("device.name", String.valueOf(request.getDevice().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteDeviceRequest, Empty> deleteDeviceTransportSettings =
        GrpcCallSettings.<DeleteDeviceRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDeviceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteDeviceRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteDeviceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListDevicesRequest, ListDevicesResponse> listDevicesTransportSettings =
        GrpcCallSettings.<ListDevicesRequest, ListDevicesResponse>newBuilder()
            .setMethodDescriptor(listDevicesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListDevicesRequest>() {
                  @Override
                  public Map<String, String> extract(ListDevicesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ModifyCloudToDeviceConfigRequest, DeviceConfig>
        modifyCloudToDeviceConfigTransportSettings =
            GrpcCallSettings.<ModifyCloudToDeviceConfigRequest, DeviceConfig>newBuilder()
                .setMethodDescriptor(modifyCloudToDeviceConfigMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ModifyCloudToDeviceConfigRequest>() {
                      @Override
                      public Map<String, String> extract(ModifyCloudToDeviceConfigRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ListDeviceConfigVersionsRequest, ListDeviceConfigVersionsResponse>
        listDeviceConfigVersionsTransportSettings =
            GrpcCallSettings
                .<ListDeviceConfigVersionsRequest, ListDeviceConfigVersionsResponse>newBuilder()
                .setMethodDescriptor(listDeviceConfigVersionsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListDeviceConfigVersionsRequest>() {
                      @Override
                      public Map<String, String> extract(ListDeviceConfigVersionsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ListDeviceStatesRequest, ListDeviceStatesResponse>
        listDeviceStatesTransportSettings =
            GrpcCallSettings.<ListDeviceStatesRequest, ListDeviceStatesResponse>newBuilder()
                .setMethodDescriptor(listDeviceStatesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListDeviceStatesRequest>() {
                      @Override
                      public Map<String, String> extract(ListDeviceStatesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SetIamPolicyRequest>() {
                  @Override
                  public Map<String, String> extract(SetIamPolicyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("resource", String.valueOf(request.getResource()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetIamPolicyRequest>() {
                  @Override
                  public Map<String, String> extract(GetIamPolicyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("resource", String.valueOf(request.getResource()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<TestIamPermissionsRequest>() {
                      @Override
                      public Map<String, String> extract(TestIamPermissionsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("resource", String.valueOf(request.getResource()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<SendCommandToDeviceRequest, SendCommandToDeviceResponse>
        sendCommandToDeviceTransportSettings =
            GrpcCallSettings.<SendCommandToDeviceRequest, SendCommandToDeviceResponse>newBuilder()
                .setMethodDescriptor(sendCommandToDeviceMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<SendCommandToDeviceRequest>() {
                      @Override
                      public Map<String, String> extract(SendCommandToDeviceRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<BindDeviceToGatewayRequest, BindDeviceToGatewayResponse>
        bindDeviceToGatewayTransportSettings =
            GrpcCallSettings.<BindDeviceToGatewayRequest, BindDeviceToGatewayResponse>newBuilder()
                .setMethodDescriptor(bindDeviceToGatewayMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<BindDeviceToGatewayRequest>() {
                      @Override
                      public Map<String, String> extract(BindDeviceToGatewayRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<UnbindDeviceFromGatewayRequest, UnbindDeviceFromGatewayResponse>
        unbindDeviceFromGatewayTransportSettings =
            GrpcCallSettings
                .<UnbindDeviceFromGatewayRequest, UnbindDeviceFromGatewayResponse>newBuilder()
                .setMethodDescriptor(unbindDeviceFromGatewayMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<UnbindDeviceFromGatewayRequest>() {
                      @Override
                      public Map<String, String> extract(UnbindDeviceFromGatewayRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();

    this.createDeviceRegistryCallable =
        callableFactory.createUnaryCallable(
            createDeviceRegistryTransportSettings,
            settings.createDeviceRegistrySettings(),
            clientContext);
    this.getDeviceRegistryCallable =
        callableFactory.createUnaryCallable(
            getDeviceRegistryTransportSettings,
            settings.getDeviceRegistrySettings(),
            clientContext);
    this.updateDeviceRegistryCallable =
        callableFactory.createUnaryCallable(
            updateDeviceRegistryTransportSettings,
            settings.updateDeviceRegistrySettings(),
            clientContext);
    this.deleteDeviceRegistryCallable =
        callableFactory.createUnaryCallable(
            deleteDeviceRegistryTransportSettings,
            settings.deleteDeviceRegistrySettings(),
            clientContext);
    this.listDeviceRegistriesCallable =
        callableFactory.createUnaryCallable(
            listDeviceRegistriesTransportSettings,
            settings.listDeviceRegistriesSettings(),
            clientContext);
    this.listDeviceRegistriesPagedCallable =
        callableFactory.createPagedCallable(
            listDeviceRegistriesTransportSettings,
            settings.listDeviceRegistriesSettings(),
            clientContext);
    this.createDeviceCallable =
        callableFactory.createUnaryCallable(
            createDeviceTransportSettings, settings.createDeviceSettings(), clientContext);
    this.getDeviceCallable =
        callableFactory.createUnaryCallable(
            getDeviceTransportSettings, settings.getDeviceSettings(), clientContext);
    this.updateDeviceCallable =
        callableFactory.createUnaryCallable(
            updateDeviceTransportSettings, settings.updateDeviceSettings(), clientContext);
    this.deleteDeviceCallable =
        callableFactory.createUnaryCallable(
            deleteDeviceTransportSettings, settings.deleteDeviceSettings(), clientContext);
    this.listDevicesCallable =
        callableFactory.createUnaryCallable(
            listDevicesTransportSettings, settings.listDevicesSettings(), clientContext);
    this.listDevicesPagedCallable =
        callableFactory.createPagedCallable(
            listDevicesTransportSettings, settings.listDevicesSettings(), clientContext);
    this.modifyCloudToDeviceConfigCallable =
        callableFactory.createUnaryCallable(
            modifyCloudToDeviceConfigTransportSettings,
            settings.modifyCloudToDeviceConfigSettings(),
            clientContext);
    this.listDeviceConfigVersionsCallable =
        callableFactory.createUnaryCallable(
            listDeviceConfigVersionsTransportSettings,
            settings.listDeviceConfigVersionsSettings(),
            clientContext);
    this.listDeviceStatesCallable =
        callableFactory.createUnaryCallable(
            listDeviceStatesTransportSettings, settings.listDeviceStatesSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);
    this.sendCommandToDeviceCallable =
        callableFactory.createUnaryCallable(
            sendCommandToDeviceTransportSettings,
            settings.sendCommandToDeviceSettings(),
            clientContext);
    this.bindDeviceToGatewayCallable =
        callableFactory.createUnaryCallable(
            bindDeviceToGatewayTransportSettings,
            settings.bindDeviceToGatewaySettings(),
            clientContext);
    this.unbindDeviceFromGatewayCallable =
        callableFactory.createUnaryCallable(
            unbindDeviceFromGatewayTransportSettings,
            settings.unbindDeviceFromGatewaySettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateDeviceRegistryRequest, DeviceRegistry> createDeviceRegistryCallable() {
    return createDeviceRegistryCallable;
  }

  @Override
  public UnaryCallable<GetDeviceRegistryRequest, DeviceRegistry> getDeviceRegistryCallable() {
    return getDeviceRegistryCallable;
  }

  @Override
  public UnaryCallable<UpdateDeviceRegistryRequest, DeviceRegistry> updateDeviceRegistryCallable() {
    return updateDeviceRegistryCallable;
  }

  @Override
  public UnaryCallable<DeleteDeviceRegistryRequest, Empty> deleteDeviceRegistryCallable() {
    return deleteDeviceRegistryCallable;
  }

  @Override
  public UnaryCallable<ListDeviceRegistriesRequest, ListDeviceRegistriesResponse>
      listDeviceRegistriesCallable() {
    return listDeviceRegistriesCallable;
  }

  @Override
  public UnaryCallable<ListDeviceRegistriesRequest, ListDeviceRegistriesPagedResponse>
      listDeviceRegistriesPagedCallable() {
    return listDeviceRegistriesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateDeviceRequest, Device> createDeviceCallable() {
    return createDeviceCallable;
  }

  @Override
  public UnaryCallable<GetDeviceRequest, Device> getDeviceCallable() {
    return getDeviceCallable;
  }

  @Override
  public UnaryCallable<UpdateDeviceRequest, Device> updateDeviceCallable() {
    return updateDeviceCallable;
  }

  @Override
  public UnaryCallable<DeleteDeviceRequest, Empty> deleteDeviceCallable() {
    return deleteDeviceCallable;
  }

  @Override
  public UnaryCallable<ListDevicesRequest, ListDevicesResponse> listDevicesCallable() {
    return listDevicesCallable;
  }

  @Override
  public UnaryCallable<ListDevicesRequest, ListDevicesPagedResponse> listDevicesPagedCallable() {
    return listDevicesPagedCallable;
  }

  @Override
  public UnaryCallable<ModifyCloudToDeviceConfigRequest, DeviceConfig>
      modifyCloudToDeviceConfigCallable() {
    return modifyCloudToDeviceConfigCallable;
  }

  @Override
  public UnaryCallable<ListDeviceConfigVersionsRequest, ListDeviceConfigVersionsResponse>
      listDeviceConfigVersionsCallable() {
    return listDeviceConfigVersionsCallable;
  }

  @Override
  public UnaryCallable<ListDeviceStatesRequest, ListDeviceStatesResponse>
      listDeviceStatesCallable() {
    return listDeviceStatesCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public UnaryCallable<SendCommandToDeviceRequest, SendCommandToDeviceResponse>
      sendCommandToDeviceCallable() {
    return sendCommandToDeviceCallable;
  }

  @Override
  public UnaryCallable<BindDeviceToGatewayRequest, BindDeviceToGatewayResponse>
      bindDeviceToGatewayCallable() {
    return bindDeviceToGatewayCallable;
  }

  @Override
  public UnaryCallable<UnbindDeviceFromGatewayRequest, UnbindDeviceFromGatewayResponse>
      unbindDeviceFromGatewayCallable() {
    return unbindDeviceFromGatewayCallable;
  }

  @Override
  public final void close() {
    shutdown();
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
