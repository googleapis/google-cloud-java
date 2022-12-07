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

package com.google.cloud.iot.v1.stub;

import static com.google.cloud.iot.v1.DeviceManagerClient.ListDeviceRegistriesPagedResponse;
import static com.google.cloud.iot.v1.DeviceManagerClient.ListDevicesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
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
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the DeviceManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonDeviceManagerStub extends DeviceManagerStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateDeviceRegistryRequest, DeviceRegistry>
      createDeviceRegistryMethodDescriptor =
          ApiMethodDescriptor.<CreateDeviceRegistryRequest, DeviceRegistry>newBuilder()
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/CreateDeviceRegistry")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDeviceRegistryRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/registries",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDeviceRegistryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDeviceRegistryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("deviceRegistry", request.getDeviceRegistry(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeviceRegistry>newBuilder()
                      .setDefaultInstance(DeviceRegistry.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDeviceRegistryRequest, DeviceRegistry>
      getDeviceRegistryMethodDescriptor =
          ApiMethodDescriptor.<GetDeviceRegistryRequest, DeviceRegistry>newBuilder()
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/GetDeviceRegistry")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDeviceRegistryRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/registries/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeviceRegistryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeviceRegistryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeviceRegistry>newBuilder()
                      .setDefaultInstance(DeviceRegistry.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDeviceRegistryRequest, DeviceRegistry>
      updateDeviceRegistryMethodDescriptor =
          ApiMethodDescriptor.<UpdateDeviceRegistryRequest, DeviceRegistry>newBuilder()
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/UpdateDeviceRegistry")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDeviceRegistryRequest>newBuilder()
                      .setPath(
                          "/v1/{deviceRegistry.name=projects/*/locations/*/registries/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDeviceRegistryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "deviceRegistry.name",
                                request.getDeviceRegistry().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDeviceRegistryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("deviceRegistry", request.getDeviceRegistry(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeviceRegistry>newBuilder()
                      .setDefaultInstance(DeviceRegistry.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDeviceRegistryRequest, Empty>
      deleteDeviceRegistryMethodDescriptor =
          ApiMethodDescriptor.<DeleteDeviceRegistryRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/DeleteDeviceRegistry")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDeviceRegistryRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/registries/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDeviceRegistryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDeviceRegistryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListDeviceRegistriesRequest, ListDeviceRegistriesResponse>
      listDeviceRegistriesMethodDescriptor =
          ApiMethodDescriptor
              .<ListDeviceRegistriesRequest, ListDeviceRegistriesResponse>newBuilder()
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/ListDeviceRegistries")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDeviceRegistriesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/registries",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeviceRegistriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeviceRegistriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDeviceRegistriesResponse>newBuilder()
                      .setDefaultInstance(ListDeviceRegistriesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDeviceRequest, Device>
      createDeviceMethodDescriptor =
          ApiMethodDescriptor.<CreateDeviceRequest, Device>newBuilder()
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/CreateDevice")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDeviceRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/registries/*}/devices",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDeviceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDeviceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("device", request.getDevice(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Device>newBuilder()
                      .setDefaultInstance(Device.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDeviceRequest, Device> getDeviceMethodDescriptor =
      ApiMethodDescriptor.<GetDeviceRequest, Device>newBuilder()
          .setFullMethodName("google.cloud.iot.v1.DeviceManager/GetDevice")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetDeviceRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/registries/*/devices/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetDeviceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setAdditionalPaths(
                      "/v1/{name=projects/*/locations/*/registries/*/groups/*/devices/*}")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetDeviceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "fieldMask", request.getFieldMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Device>newBuilder()
                  .setDefaultInstance(Device.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateDeviceRequest, Device>
      updateDeviceMethodDescriptor =
          ApiMethodDescriptor.<UpdateDeviceRequest, Device>newBuilder()
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/UpdateDevice")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDeviceRequest>newBuilder()
                      .setPath(
                          "/v1/{device.name=projects/*/locations/*/registries/*/devices/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDeviceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "device.name", request.getDevice().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{device.name=projects/*/locations/*/registries/*/groups/*/devices/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDeviceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("device", request.getDevice(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Device>newBuilder()
                      .setDefaultInstance(Device.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDeviceRequest, Empty>
      deleteDeviceMethodDescriptor =
          ApiMethodDescriptor.<DeleteDeviceRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/DeleteDevice")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDeviceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/registries/*/devices/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDeviceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDeviceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDevicesRequest, ListDevicesResponse>
      listDevicesMethodDescriptor =
          ApiMethodDescriptor.<ListDevicesRequest, ListDevicesResponse>newBuilder()
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/ListDevices")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDevicesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/registries/*}/devices",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDevicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=projects/*/locations/*/registries/*/groups/*}/devices")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDevicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "deviceIds", request.getDeviceIdsList());
                            serializer.putQueryParam(
                                fields, "deviceNumIds", request.getDeviceNumIdsList());
                            serializer.putQueryParam(fields, "fieldMask", request.getFieldMask());
                            serializer.putQueryParam(
                                fields, "gatewayListOptions", request.getGatewayListOptions());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDevicesResponse>newBuilder()
                      .setDefaultInstance(ListDevicesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ModifyCloudToDeviceConfigRequest, DeviceConfig>
      modifyCloudToDeviceConfigMethodDescriptor =
          ApiMethodDescriptor.<ModifyCloudToDeviceConfigRequest, DeviceConfig>newBuilder()
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/ModifyCloudToDeviceConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ModifyCloudToDeviceConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/registries/*/devices/*}:modifyCloudToDeviceConfig",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ModifyCloudToDeviceConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=projects/*/locations/*/registries/*/groups/*/devices/*}:modifyCloudToDeviceConfig")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ModifyCloudToDeviceConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeviceConfig>newBuilder()
                      .setDefaultInstance(DeviceConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListDeviceConfigVersionsRequest, ListDeviceConfigVersionsResponse>
      listDeviceConfigVersionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListDeviceConfigVersionsRequest, ListDeviceConfigVersionsResponse>newBuilder()
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/ListDeviceConfigVersions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDeviceConfigVersionsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/registries/*/devices/*}/configVersions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeviceConfigVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=projects/*/locations/*/registries/*/groups/*/devices/*}/configVersions")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeviceConfigVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "numVersions", request.getNumVersions());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDeviceConfigVersionsResponse>newBuilder()
                      .setDefaultInstance(ListDeviceConfigVersionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDeviceStatesRequest, ListDeviceStatesResponse>
      listDeviceStatesMethodDescriptor =
          ApiMethodDescriptor.<ListDeviceStatesRequest, ListDeviceStatesResponse>newBuilder()
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/ListDeviceStates")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDeviceStatesRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/registries/*/devices/*}/states",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeviceStatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=projects/*/locations/*/registries/*/groups/*/devices/*}/states")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeviceStatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "numStates", request.getNumStates());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDeviceStatesResponse>newBuilder()
                      .setDefaultInstance(ListDeviceStatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/registries/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/registries/*/groups/*}:setIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/GetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/registries/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/registries/*/groups/*}:getIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/registries/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/registries/*/groups/*}:testIamPermissions")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SendCommandToDeviceRequest, SendCommandToDeviceResponse>
      sendCommandToDeviceMethodDescriptor =
          ApiMethodDescriptor.<SendCommandToDeviceRequest, SendCommandToDeviceResponse>newBuilder()
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/SendCommandToDevice")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SendCommandToDeviceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/registries/*/devices/*}:sendCommandToDevice",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SendCommandToDeviceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=projects/*/locations/*/registries/*/groups/*/devices/*}:sendCommandToDevice")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SendCommandToDeviceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SendCommandToDeviceResponse>newBuilder()
                      .setDefaultInstance(SendCommandToDeviceResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BindDeviceToGatewayRequest, BindDeviceToGatewayResponse>
      bindDeviceToGatewayMethodDescriptor =
          ApiMethodDescriptor.<BindDeviceToGatewayRequest, BindDeviceToGatewayResponse>newBuilder()
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/BindDeviceToGateway")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BindDeviceToGatewayRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/registries/*}:bindDeviceToGateway",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BindDeviceToGatewayRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=projects/*/locations/*/registries/*/groups/*}:bindDeviceToGateway")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BindDeviceToGatewayRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BindDeviceToGatewayResponse>newBuilder()
                      .setDefaultInstance(BindDeviceToGatewayResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UnbindDeviceFromGatewayRequest, UnbindDeviceFromGatewayResponse>
      unbindDeviceFromGatewayMethodDescriptor =
          ApiMethodDescriptor
              .<UnbindDeviceFromGatewayRequest, UnbindDeviceFromGatewayResponse>newBuilder()
              .setFullMethodName("google.cloud.iot.v1.DeviceManager/UnbindDeviceFromGateway")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UnbindDeviceFromGatewayRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/registries/*}:unbindDeviceFromGateway",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UnbindDeviceFromGatewayRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=projects/*/locations/*/registries/*/groups/*}:unbindDeviceFromGateway")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UnbindDeviceFromGatewayRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UnbindDeviceFromGatewayResponse>newBuilder()
                      .setDefaultInstance(UnbindDeviceFromGatewayResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDeviceManagerStub create(DeviceManagerStubSettings settings)
      throws IOException {
    return new HttpJsonDeviceManagerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDeviceManagerStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDeviceManagerStub(
        DeviceManagerStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDeviceManagerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDeviceManagerStub(
        DeviceManagerStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDeviceManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDeviceManagerStub(
      DeviceManagerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDeviceManagerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDeviceManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDeviceManagerStub(
      DeviceManagerStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateDeviceRegistryRequest, DeviceRegistry>
        createDeviceRegistryTransportSettings =
            HttpJsonCallSettings.<CreateDeviceRegistryRequest, DeviceRegistry>newBuilder()
                .setMethodDescriptor(createDeviceRegistryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetDeviceRegistryRequest, DeviceRegistry>
        getDeviceRegistryTransportSettings =
            HttpJsonCallSettings.<GetDeviceRegistryRequest, DeviceRegistry>newBuilder()
                .setMethodDescriptor(getDeviceRegistryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateDeviceRegistryRequest, DeviceRegistry>
        updateDeviceRegistryTransportSettings =
            HttpJsonCallSettings.<UpdateDeviceRegistryRequest, DeviceRegistry>newBuilder()
                .setMethodDescriptor(updateDeviceRegistryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteDeviceRegistryRequest, Empty> deleteDeviceRegistryTransportSettings =
        HttpJsonCallSettings.<DeleteDeviceRegistryRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDeviceRegistryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListDeviceRegistriesRequest, ListDeviceRegistriesResponse>
        listDeviceRegistriesTransportSettings =
            HttpJsonCallSettings
                .<ListDeviceRegistriesRequest, ListDeviceRegistriesResponse>newBuilder()
                .setMethodDescriptor(listDeviceRegistriesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateDeviceRequest, Device> createDeviceTransportSettings =
        HttpJsonCallSettings.<CreateDeviceRequest, Device>newBuilder()
            .setMethodDescriptor(createDeviceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetDeviceRequest, Device> getDeviceTransportSettings =
        HttpJsonCallSettings.<GetDeviceRequest, Device>newBuilder()
            .setMethodDescriptor(getDeviceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateDeviceRequest, Device> updateDeviceTransportSettings =
        HttpJsonCallSettings.<UpdateDeviceRequest, Device>newBuilder()
            .setMethodDescriptor(updateDeviceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteDeviceRequest, Empty> deleteDeviceTransportSettings =
        HttpJsonCallSettings.<DeleteDeviceRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDeviceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListDevicesRequest, ListDevicesResponse> listDevicesTransportSettings =
        HttpJsonCallSettings.<ListDevicesRequest, ListDevicesResponse>newBuilder()
            .setMethodDescriptor(listDevicesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ModifyCloudToDeviceConfigRequest, DeviceConfig>
        modifyCloudToDeviceConfigTransportSettings =
            HttpJsonCallSettings.<ModifyCloudToDeviceConfigRequest, DeviceConfig>newBuilder()
                .setMethodDescriptor(modifyCloudToDeviceConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListDeviceConfigVersionsRequest, ListDeviceConfigVersionsResponse>
        listDeviceConfigVersionsTransportSettings =
            HttpJsonCallSettings
                .<ListDeviceConfigVersionsRequest, ListDeviceConfigVersionsResponse>newBuilder()
                .setMethodDescriptor(listDeviceConfigVersionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListDeviceStatesRequest, ListDeviceStatesResponse>
        listDeviceStatesTransportSettings =
            HttpJsonCallSettings.<ListDeviceStatesRequest, ListDeviceStatesResponse>newBuilder()
                .setMethodDescriptor(listDeviceStatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SendCommandToDeviceRequest, SendCommandToDeviceResponse>
        sendCommandToDeviceTransportSettings =
            HttpJsonCallSettings
                .<SendCommandToDeviceRequest, SendCommandToDeviceResponse>newBuilder()
                .setMethodDescriptor(sendCommandToDeviceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<BindDeviceToGatewayRequest, BindDeviceToGatewayResponse>
        bindDeviceToGatewayTransportSettings =
            HttpJsonCallSettings
                .<BindDeviceToGatewayRequest, BindDeviceToGatewayResponse>newBuilder()
                .setMethodDescriptor(bindDeviceToGatewayMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UnbindDeviceFromGatewayRequest, UnbindDeviceFromGatewayResponse>
        unbindDeviceFromGatewayTransportSettings =
            HttpJsonCallSettings
                .<UnbindDeviceFromGatewayRequest, UnbindDeviceFromGatewayResponse>newBuilder()
                .setMethodDescriptor(unbindDeviceFromGatewayMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createDeviceRegistryMethodDescriptor);
    methodDescriptors.add(getDeviceRegistryMethodDescriptor);
    methodDescriptors.add(updateDeviceRegistryMethodDescriptor);
    methodDescriptors.add(deleteDeviceRegistryMethodDescriptor);
    methodDescriptors.add(listDeviceRegistriesMethodDescriptor);
    methodDescriptors.add(createDeviceMethodDescriptor);
    methodDescriptors.add(getDeviceMethodDescriptor);
    methodDescriptors.add(updateDeviceMethodDescriptor);
    methodDescriptors.add(deleteDeviceMethodDescriptor);
    methodDescriptors.add(listDevicesMethodDescriptor);
    methodDescriptors.add(modifyCloudToDeviceConfigMethodDescriptor);
    methodDescriptors.add(listDeviceConfigVersionsMethodDescriptor);
    methodDescriptors.add(listDeviceStatesMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    methodDescriptors.add(sendCommandToDeviceMethodDescriptor);
    methodDescriptors.add(bindDeviceToGatewayMethodDescriptor);
    methodDescriptors.add(unbindDeviceFromGatewayMethodDescriptor);
    return methodDescriptors;
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
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
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
