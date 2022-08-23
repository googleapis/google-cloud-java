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

package com.google.cloud.iot.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.iot.v1.DeviceManagerGrpc.DeviceManagerImplBase;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockDeviceManagerImpl extends DeviceManagerImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDeviceManagerImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<AbstractMessage> getRequests() {
    return requests;
  }

  public void addResponse(AbstractMessage response) {
    responses.add(response);
  }

  public void setResponses(List<AbstractMessage> responses) {
    this.responses = new LinkedList<Object>(responses);
  }

  public void addException(Exception exception) {
    responses.add(exception);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void createDeviceRegistry(
      CreateDeviceRegistryRequest request, StreamObserver<DeviceRegistry> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DeviceRegistry) {
      requests.add(request);
      responseObserver.onNext(((DeviceRegistry) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDeviceRegistry, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DeviceRegistry.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDeviceRegistry(
      GetDeviceRegistryRequest request, StreamObserver<DeviceRegistry> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DeviceRegistry) {
      requests.add(request);
      responseObserver.onNext(((DeviceRegistry) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDeviceRegistry, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DeviceRegistry.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDeviceRegistry(
      UpdateDeviceRegistryRequest request, StreamObserver<DeviceRegistry> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DeviceRegistry) {
      requests.add(request);
      responseObserver.onNext(((DeviceRegistry) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDeviceRegistry, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DeviceRegistry.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDeviceRegistry(
      DeleteDeviceRegistryRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteDeviceRegistry, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDeviceRegistries(
      ListDeviceRegistriesRequest request,
      StreamObserver<ListDeviceRegistriesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDeviceRegistriesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDeviceRegistriesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDeviceRegistries, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDeviceRegistriesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDevice(CreateDeviceRequest request, StreamObserver<Device> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Device) {
      requests.add(request);
      responseObserver.onNext(((Device) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDevice, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Device.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDevice(GetDeviceRequest request, StreamObserver<Device> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Device) {
      requests.add(request);
      responseObserver.onNext(((Device) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDevice, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Device.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDevice(UpdateDeviceRequest request, StreamObserver<Device> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Device) {
      requests.add(request);
      responseObserver.onNext(((Device) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDevice, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Device.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDevice(DeleteDeviceRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteDevice, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDevices(
      ListDevicesRequest request, StreamObserver<ListDevicesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDevicesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDevicesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDevices, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDevicesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void modifyCloudToDeviceConfig(
      ModifyCloudToDeviceConfigRequest request, StreamObserver<DeviceConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DeviceConfig) {
      requests.add(request);
      responseObserver.onNext(((DeviceConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ModifyCloudToDeviceConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DeviceConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDeviceConfigVersions(
      ListDeviceConfigVersionsRequest request,
      StreamObserver<ListDeviceConfigVersionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDeviceConfigVersionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDeviceConfigVersionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDeviceConfigVersions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDeviceConfigVersionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDeviceStates(
      ListDeviceStatesRequest request, StreamObserver<ListDeviceStatesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDeviceStatesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDeviceStatesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDeviceStates, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDeviceStatesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void setIamPolicy(SetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Policy) {
      requests.add(request);
      responseObserver.onNext(((Policy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SetIamPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Policy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getIamPolicy(GetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Policy) {
      requests.add(request);
      responseObserver.onNext(((Policy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetIamPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Policy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void testIamPermissions(
      TestIamPermissionsRequest request,
      StreamObserver<TestIamPermissionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TestIamPermissionsResponse) {
      requests.add(request);
      responseObserver.onNext(((TestIamPermissionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method TestIamPermissions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TestIamPermissionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void sendCommandToDevice(
      SendCommandToDeviceRequest request,
      StreamObserver<SendCommandToDeviceResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SendCommandToDeviceResponse) {
      requests.add(request);
      responseObserver.onNext(((SendCommandToDeviceResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SendCommandToDevice, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SendCommandToDeviceResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void bindDeviceToGateway(
      BindDeviceToGatewayRequest request,
      StreamObserver<BindDeviceToGatewayResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BindDeviceToGatewayResponse) {
      requests.add(request);
      responseObserver.onNext(((BindDeviceToGatewayResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BindDeviceToGateway, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BindDeviceToGatewayResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void unbindDeviceFromGateway(
      UnbindDeviceFromGatewayRequest request,
      StreamObserver<UnbindDeviceFromGatewayResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UnbindDeviceFromGatewayResponse) {
      requests.add(request);
      responseObserver.onNext(((UnbindDeviceFromGatewayResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UnbindDeviceFromGateway, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UnbindDeviceFromGatewayResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
