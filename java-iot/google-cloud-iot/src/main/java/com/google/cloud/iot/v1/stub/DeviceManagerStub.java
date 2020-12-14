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
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DeviceManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class DeviceManagerStub implements BackgroundResource {

  public UnaryCallable<CreateDeviceRegistryRequest, DeviceRegistry> createDeviceRegistryCallable() {
    throw new UnsupportedOperationException("Not implemented: createDeviceRegistryCallable()");
  }

  public UnaryCallable<GetDeviceRegistryRequest, DeviceRegistry> getDeviceRegistryCallable() {
    throw new UnsupportedOperationException("Not implemented: getDeviceRegistryCallable()");
  }

  public UnaryCallable<UpdateDeviceRegistryRequest, DeviceRegistry> updateDeviceRegistryCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDeviceRegistryCallable()");
  }

  public UnaryCallable<DeleteDeviceRegistryRequest, Empty> deleteDeviceRegistryCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDeviceRegistryCallable()");
  }

  public UnaryCallable<ListDeviceRegistriesRequest, ListDeviceRegistriesPagedResponse>
      listDeviceRegistriesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDeviceRegistriesPagedCallable()");
  }

  public UnaryCallable<ListDeviceRegistriesRequest, ListDeviceRegistriesResponse>
      listDeviceRegistriesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDeviceRegistriesCallable()");
  }

  public UnaryCallable<CreateDeviceRequest, Device> createDeviceCallable() {
    throw new UnsupportedOperationException("Not implemented: createDeviceCallable()");
  }

  public UnaryCallable<GetDeviceRequest, Device> getDeviceCallable() {
    throw new UnsupportedOperationException("Not implemented: getDeviceCallable()");
  }

  public UnaryCallable<UpdateDeviceRequest, Device> updateDeviceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDeviceCallable()");
  }

  public UnaryCallable<DeleteDeviceRequest, Empty> deleteDeviceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDeviceCallable()");
  }

  public UnaryCallable<ListDevicesRequest, ListDevicesPagedResponse> listDevicesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDevicesPagedCallable()");
  }

  public UnaryCallable<ListDevicesRequest, ListDevicesResponse> listDevicesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDevicesCallable()");
  }

  public UnaryCallable<ModifyCloudToDeviceConfigRequest, DeviceConfig>
      modifyCloudToDeviceConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: modifyCloudToDeviceConfigCallable()");
  }

  public UnaryCallable<ListDeviceConfigVersionsRequest, ListDeviceConfigVersionsResponse>
      listDeviceConfigVersionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDeviceConfigVersionsCallable()");
  }

  public UnaryCallable<ListDeviceStatesRequest, ListDeviceStatesResponse>
      listDeviceStatesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDeviceStatesCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  public UnaryCallable<SendCommandToDeviceRequest, SendCommandToDeviceResponse>
      sendCommandToDeviceCallable() {
    throw new UnsupportedOperationException("Not implemented: sendCommandToDeviceCallable()");
  }

  public UnaryCallable<BindDeviceToGatewayRequest, BindDeviceToGatewayResponse>
      bindDeviceToGatewayCallable() {
    throw new UnsupportedOperationException("Not implemented: bindDeviceToGatewayCallable()");
  }

  public UnaryCallable<UnbindDeviceFromGatewayRequest, UnbindDeviceFromGatewayResponse>
      unbindDeviceFromGatewayCallable() {
    throw new UnsupportedOperationException("Not implemented: unbindDeviceFromGatewayCallable()");
  }

  @Override
  public abstract void close();
}
