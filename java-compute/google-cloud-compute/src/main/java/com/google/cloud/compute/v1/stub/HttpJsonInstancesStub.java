/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.InstancesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.InstancesClient.ListPagedResponse;
import static com.google.cloud.compute.v1.InstancesClient.ListReferrersPagedResponse;

import com.google.api.client.http.HttpMethods;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.FieldsExtractor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddAccessConfigInstanceRequest;
import com.google.cloud.compute.v1.AddResourcePoliciesInstanceRequest;
import com.google.cloud.compute.v1.AggregatedListInstancesRequest;
import com.google.cloud.compute.v1.AttachDiskInstanceRequest;
import com.google.cloud.compute.v1.DeleteAccessConfigInstanceRequest;
import com.google.cloud.compute.v1.DeleteInstanceRequest;
import com.google.cloud.compute.v1.DetachDiskInstanceRequest;
import com.google.cloud.compute.v1.GetGuestAttributesInstanceRequest;
import com.google.cloud.compute.v1.GetIamPolicyInstanceRequest;
import com.google.cloud.compute.v1.GetInstanceRequest;
import com.google.cloud.compute.v1.GetScreenshotInstanceRequest;
import com.google.cloud.compute.v1.GetSerialPortOutputInstanceRequest;
import com.google.cloud.compute.v1.GetShieldedInstanceIdentityInstanceRequest;
import com.google.cloud.compute.v1.GuestAttributes;
import com.google.cloud.compute.v1.InsertInstanceRequest;
import com.google.cloud.compute.v1.Instance;
import com.google.cloud.compute.v1.InstanceAggregatedList;
import com.google.cloud.compute.v1.InstanceList;
import com.google.cloud.compute.v1.InstanceListReferrers;
import com.google.cloud.compute.v1.ListInstancesRequest;
import com.google.cloud.compute.v1.ListReferrersInstancesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.RemoveResourcePoliciesInstanceRequest;
import com.google.cloud.compute.v1.ResetInstanceRequest;
import com.google.cloud.compute.v1.Screenshot;
import com.google.cloud.compute.v1.SerialPortOutput;
import com.google.cloud.compute.v1.SetDeletionProtectionInstanceRequest;
import com.google.cloud.compute.v1.SetDiskAutoDeleteInstanceRequest;
import com.google.cloud.compute.v1.SetIamPolicyInstanceRequest;
import com.google.cloud.compute.v1.SetLabelsInstanceRequest;
import com.google.cloud.compute.v1.SetMachineResourcesInstanceRequest;
import com.google.cloud.compute.v1.SetMachineTypeInstanceRequest;
import com.google.cloud.compute.v1.SetMetadataInstanceRequest;
import com.google.cloud.compute.v1.SetMinCpuPlatformInstanceRequest;
import com.google.cloud.compute.v1.SetSchedulingInstanceRequest;
import com.google.cloud.compute.v1.SetServiceAccountInstanceRequest;
import com.google.cloud.compute.v1.SetShieldedInstanceIntegrityPolicyInstanceRequest;
import com.google.cloud.compute.v1.SetTagsInstanceRequest;
import com.google.cloud.compute.v1.ShieldedInstanceIdentity;
import com.google.cloud.compute.v1.SimulateMaintenanceEventInstanceRequest;
import com.google.cloud.compute.v1.StartInstanceRequest;
import com.google.cloud.compute.v1.StartWithEncryptionKeyInstanceRequest;
import com.google.cloud.compute.v1.StopInstanceRequest;
import com.google.cloud.compute.v1.TestIamPermissionsInstanceRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.cloud.compute.v1.UpdateAccessConfigInstanceRequest;
import com.google.cloud.compute.v1.UpdateDisplayDeviceInstanceRequest;
import com.google.cloud.compute.v1.UpdateInstanceRequest;
import com.google.cloud.compute.v1.UpdateNetworkInterfaceInstanceRequest;
import com.google.cloud.compute.v1.UpdateShieldedInstanceConfigInstanceRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * REST stub implementation for Google Compute Engine API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonInstancesStub extends InstancesStub {

  @InternalApi
  public static final ApiMethodDescriptor<AddAccessConfigInstanceRequest, Operation>
      addAccessConfigMethodDescriptor =
          ApiMethodDescriptor.<AddAccessConfigInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.AddAccessConfig")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddAccessConfigInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/addAccessConfig",
                          new FieldsExtractor<
                              AddAccessConfigInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AddAccessConfigInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AddAccessConfigInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AddAccessConfigInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AddAccessConfigInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AddAccessConfigInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putQueryParam(
                                  fields, "networkInterface", request.getNetworkInterface());
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<AddAccessConfigInstanceRequest, String>() {
                            @Override
                            public String extract(AddAccessConfigInstanceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "accessConfigResource", request.getAccessConfigResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<AddResourcePoliciesInstanceRequest, Operation>
      addResourcePoliciesMethodDescriptor =
          ApiMethodDescriptor.<AddResourcePoliciesInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.AddResourcePolicies")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddResourcePoliciesInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/addResourcePolicies",
                          new FieldsExtractor<
                              AddResourcePoliciesInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AddResourcePoliciesInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AddResourcePoliciesInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AddResourcePoliciesInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AddResourcePoliciesInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AddResourcePoliciesInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<AddResourcePoliciesInstanceRequest, String>() {
                            @Override
                            public String extract(AddResourcePoliciesInstanceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instancesAddResourcePoliciesRequestResource",
                                      request.getInstancesAddResourcePoliciesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<AggregatedListInstancesRequest, InstanceAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor.<AggregatedListInstancesRequest, InstanceAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.AggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListInstancesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/instances",
                          new FieldsExtractor<
                              AggregatedListInstancesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AggregatedListInstancesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListInstancesRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AggregatedListInstancesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AggregatedListInstancesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListInstancesRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasFilter()) {
                                serializer.putQueryParam(fields, "filter", request.getFilter());
                              }
                              if (request.hasIncludeAllScopes()) {
                                serializer.putQueryParam(
                                    fields, "includeAllScopes", request.getIncludeAllScopes());
                              }
                              if (request.hasMaxResults()) {
                                serializer.putQueryParam(
                                    fields, "maxResults", request.getMaxResults());
                              }
                              if (request.hasOrderBy()) {
                                serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                              }
                              if (request.hasPageToken()) {
                                serializer.putQueryParam(
                                    fields, "pageToken", request.getPageToken());
                              }
                              if (request.hasReturnPartialSuccess()) {
                                serializer.putQueryParam(
                                    fields,
                                    "returnPartialSuccess",
                                    request.getReturnPartialSuccess());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<AggregatedListInstancesRequest, String>() {
                            @Override
                            public String extract(AggregatedListInstancesRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstanceAggregatedList>newBuilder()
                      .setDefaultInstance(InstanceAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<AttachDiskInstanceRequest, Operation>
      attachDiskMethodDescriptor =
          ApiMethodDescriptor.<AttachDiskInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.AttachDisk")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AttachDiskInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/attachDisk",
                          new FieldsExtractor<AttachDiskInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(AttachDiskInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AttachDiskInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AttachDiskInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AttachDiskInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AttachDiskInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasForceAttach()) {
                                serializer.putQueryParam(
                                    fields, "forceAttach", request.getForceAttach());
                              }
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<AttachDiskInstanceRequest, String>() {
                            @Override
                            public String extract(AttachDiskInstanceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "attachedDiskResource", request.getAttachedDiskResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteInstanceRequest, Operation> deleteMethodDescriptor =
      ApiMethodDescriptor.<DeleteInstanceRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Instances.Delete")
          .setHttpMethod(HttpMethods.DELETE)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteInstanceRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}",
                      new FieldsExtractor<DeleteInstanceRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(DeleteInstanceRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<DeleteInstanceRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "zone", request.getZone());
                          serializer.putPathParam(fields, "instance", request.getInstance());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<DeleteInstanceRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(DeleteInstanceRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<DeleteInstanceRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<DeleteInstanceRequest, String>() {
                        @Override
                        public String extract(DeleteInstanceRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteAccessConfigInstanceRequest, Operation>
      deleteAccessConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteAccessConfigInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.DeleteAccessConfig")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAccessConfigInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/deleteAccessConfig",
                          new FieldsExtractor<
                              DeleteAccessConfigInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteAccessConfigInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteAccessConfigInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteAccessConfigInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteAccessConfigInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteAccessConfigInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putQueryParam(
                                  fields, "accessConfig", request.getAccessConfig());
                              serializer.putQueryParam(
                                  fields, "networkInterface", request.getNetworkInterface());
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteAccessConfigInstanceRequest, String>() {
                            @Override
                            public String extract(DeleteAccessConfigInstanceRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DetachDiskInstanceRequest, Operation>
      detachDiskMethodDescriptor =
          ApiMethodDescriptor.<DetachDiskInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.DetachDisk")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DetachDiskInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/detachDisk",
                          new FieldsExtractor<DetachDiskInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(DetachDiskInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DetachDiskInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DetachDiskInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DetachDiskInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DetachDiskInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putQueryParam(
                                  fields, "deviceName", request.getDeviceName());
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DetachDiskInstanceRequest, String>() {
                            @Override
                            public String extract(DetachDiskInstanceRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetInstanceRequest, Instance> getMethodDescriptor =
      ApiMethodDescriptor.<GetInstanceRequest, Instance>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Instances.Get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetInstanceRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}",
                      new FieldsExtractor<GetInstanceRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(GetInstanceRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<GetInstanceRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "zone", request.getZone());
                          serializer.putPathParam(fields, "instance", request.getInstance());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<GetInstanceRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(GetInstanceRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<GetInstanceRequest> serializer =
                              ProtoRestSerializer.create();

                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<GetInstanceRequest, String>() {
                        @Override
                        public String extract(GetInstanceRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Instance>newBuilder()
                  .setDefaultInstance(Instance.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetGuestAttributesInstanceRequest, GuestAttributes>
      getGuestAttributesMethodDescriptor =
          ApiMethodDescriptor.<GetGuestAttributesInstanceRequest, GuestAttributes>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.GetGuestAttributes")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGuestAttributesInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/getGuestAttributes",
                          new FieldsExtractor<
                              GetGuestAttributesInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetGuestAttributesInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetGuestAttributesInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetGuestAttributesInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetGuestAttributesInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetGuestAttributesInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasQueryPath()) {
                                serializer.putQueryParam(
                                    fields, "queryPath", request.getQueryPath());
                              }
                              if (request.hasVariableKey()) {
                                serializer.putQueryParam(
                                    fields, "variableKey", request.getVariableKey());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetGuestAttributesInstanceRequest, String>() {
                            @Override
                            public String extract(GetGuestAttributesInstanceRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GuestAttributes>newBuilder()
                      .setDefaultInstance(GuestAttributes.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetIamPolicyInstanceRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyInstanceRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.GetIamPolicy")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{resource}/getIamPolicy",
                          new FieldsExtractor<GetIamPolicyInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetIamPolicyInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetIamPolicyInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetIamPolicyInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetIamPolicyInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetIamPolicyInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasOptionsRequestedPolicyVersion()) {
                                serializer.putQueryParam(
                                    fields,
                                    "optionsRequestedPolicyVersion",
                                    request.getOptionsRequestedPolicyVersion());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetIamPolicyInstanceRequest, String>() {
                            @Override
                            public String extract(GetIamPolicyInstanceRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetScreenshotInstanceRequest, Screenshot>
      getScreenshotMethodDescriptor =
          ApiMethodDescriptor.<GetScreenshotInstanceRequest, Screenshot>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.GetScreenshot")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetScreenshotInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/screenshot",
                          new FieldsExtractor<GetScreenshotInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetScreenshotInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetScreenshotInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetScreenshotInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetScreenshotInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetScreenshotInstanceRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetScreenshotInstanceRequest, String>() {
                            @Override
                            public String extract(GetScreenshotInstanceRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Screenshot>newBuilder()
                      .setDefaultInstance(Screenshot.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetSerialPortOutputInstanceRequest, SerialPortOutput>
      getSerialPortOutputMethodDescriptor =
          ApiMethodDescriptor.<GetSerialPortOutputInstanceRequest, SerialPortOutput>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.GetSerialPortOutput")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSerialPortOutputInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/serialPort",
                          new FieldsExtractor<
                              GetSerialPortOutputInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetSerialPortOutputInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetSerialPortOutputInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetSerialPortOutputInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetSerialPortOutputInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetSerialPortOutputInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasPort()) {
                                serializer.putQueryParam(fields, "port", request.getPort());
                              }
                              if (request.hasStart()) {
                                serializer.putQueryParam(fields, "start", request.getStart());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetSerialPortOutputInstanceRequest, String>() {
                            @Override
                            public String extract(GetSerialPortOutputInstanceRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SerialPortOutput>newBuilder()
                      .setDefaultInstance(SerialPortOutput.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          GetShieldedInstanceIdentityInstanceRequest, ShieldedInstanceIdentity>
      getShieldedInstanceIdentityMethodDescriptor =
          ApiMethodDescriptor
              .<GetShieldedInstanceIdentityInstanceRequest, ShieldedInstanceIdentity>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.GetShieldedInstanceIdentity")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetShieldedInstanceIdentityInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/getShieldedInstanceIdentity",
                          new FieldsExtractor<
                              GetShieldedInstanceIdentityInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetShieldedInstanceIdentityInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetShieldedInstanceIdentityInstanceRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetShieldedInstanceIdentityInstanceRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetShieldedInstanceIdentityInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetShieldedInstanceIdentityInstanceRequest>
                                  serializer = ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<
                              GetShieldedInstanceIdentityInstanceRequest, String>() {
                            @Override
                            public String extract(
                                GetShieldedInstanceIdentityInstanceRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ShieldedInstanceIdentity>newBuilder()
                      .setDefaultInstance(ShieldedInstanceIdentity.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertInstanceRequest, Operation> insertMethodDescriptor =
      ApiMethodDescriptor.<InsertInstanceRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Instances.Insert")
          .setHttpMethod(HttpMethods.POST)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<InsertInstanceRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/instances",
                      new FieldsExtractor<InsertInstanceRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(InsertInstanceRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<InsertInstanceRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "zone", request.getZone());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<InsertInstanceRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(InsertInstanceRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<InsertInstanceRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          if (request.hasSourceInstanceTemplate()) {
                            serializer.putQueryParam(
                                fields,
                                "sourceInstanceTemplate",
                                request.getSourceInstanceTemplate());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<InsertInstanceRequest, String>() {
                        @Override
                        public String extract(InsertInstanceRequest request) {
                          return ProtoRestSerializer.create()
                              .toBody("instanceResource", request.getInstanceResource());
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListInstancesRequest, InstanceList> listMethodDescriptor =
      ApiMethodDescriptor.<ListInstancesRequest, InstanceList>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Instances.List")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<ListInstancesRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/instances",
                      new FieldsExtractor<ListInstancesRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(ListInstancesRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<ListInstancesRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "zone", request.getZone());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<ListInstancesRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(ListInstancesRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<ListInstancesRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasFilter()) {
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                          }
                          if (request.hasMaxResults()) {
                            serializer.putQueryParam(fields, "maxResults", request.getMaxResults());
                          }
                          if (request.hasOrderBy()) {
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                          }
                          if (request.hasPageToken()) {
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                          }
                          if (request.hasReturnPartialSuccess()) {
                            serializer.putQueryParam(
                                fields, "returnPartialSuccess", request.getReturnPartialSuccess());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<ListInstancesRequest, String>() {
                        @Override
                        public String extract(ListInstancesRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<InstanceList>newBuilder()
                  .setDefaultInstance(InstanceList.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListReferrersInstancesRequest, InstanceListReferrers>
      listReferrersMethodDescriptor =
          ApiMethodDescriptor.<ListReferrersInstancesRequest, InstanceListReferrers>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.ListReferrers")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReferrersInstancesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/referrers",
                          new FieldsExtractor<
                              ListReferrersInstancesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListReferrersInstancesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListReferrersInstancesRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListReferrersInstancesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListReferrersInstancesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListReferrersInstancesRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasFilter()) {
                                serializer.putQueryParam(fields, "filter", request.getFilter());
                              }
                              if (request.hasMaxResults()) {
                                serializer.putQueryParam(
                                    fields, "maxResults", request.getMaxResults());
                              }
                              if (request.hasOrderBy()) {
                                serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                              }
                              if (request.hasPageToken()) {
                                serializer.putQueryParam(
                                    fields, "pageToken", request.getPageToken());
                              }
                              if (request.hasReturnPartialSuccess()) {
                                serializer.putQueryParam(
                                    fields,
                                    "returnPartialSuccess",
                                    request.getReturnPartialSuccess());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<ListReferrersInstancesRequest, String>() {
                            @Override
                            public String extract(ListReferrersInstancesRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstanceListReferrers>newBuilder()
                      .setDefaultInstance(InstanceListReferrers.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<RemoveResourcePoliciesInstanceRequest, Operation>
      removeResourcePoliciesMethodDescriptor =
          ApiMethodDescriptor.<RemoveResourcePoliciesInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.RemoveResourcePolicies")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveResourcePoliciesInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/removeResourcePolicies",
                          new FieldsExtractor<
                              RemoveResourcePoliciesInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                RemoveResourcePoliciesInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<RemoveResourcePoliciesInstanceRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              RemoveResourcePoliciesInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                RemoveResourcePoliciesInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<RemoveResourcePoliciesInstanceRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<RemoveResourcePoliciesInstanceRequest, String>() {
                            @Override
                            public String extract(RemoveResourcePoliciesInstanceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instancesRemoveResourcePoliciesRequestResource",
                                      request.getInstancesRemoveResourcePoliciesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ResetInstanceRequest, Operation> resetMethodDescriptor =
      ApiMethodDescriptor.<ResetInstanceRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Instances.Reset")
          .setHttpMethod(HttpMethods.POST)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<ResetInstanceRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/reset",
                      new FieldsExtractor<ResetInstanceRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(ResetInstanceRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<ResetInstanceRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "zone", request.getZone());
                          serializer.putPathParam(fields, "instance", request.getInstance());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<ResetInstanceRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(ResetInstanceRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<ResetInstanceRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<ResetInstanceRequest, String>() {
                        @Override
                        public String extract(ResetInstanceRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetDeletionProtectionInstanceRequest, Operation>
      setDeletionProtectionMethodDescriptor =
          ApiMethodDescriptor.<SetDeletionProtectionInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.SetDeletionProtection")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetDeletionProtectionInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{resource}/setDeletionProtection",
                          new FieldsExtractor<
                              SetDeletionProtectionInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetDeletionProtectionInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetDeletionProtectionInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetDeletionProtectionInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetDeletionProtectionInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetDeletionProtectionInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasDeletionProtection()) {
                                serializer.putQueryParam(
                                    fields, "deletionProtection", request.getDeletionProtection());
                              }
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetDeletionProtectionInstanceRequest, String>() {
                            @Override
                            public String extract(SetDeletionProtectionInstanceRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetDiskAutoDeleteInstanceRequest, Operation>
      setDiskAutoDeleteMethodDescriptor =
          ApiMethodDescriptor.<SetDiskAutoDeleteInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.SetDiskAutoDelete")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetDiskAutoDeleteInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/setDiskAutoDelete",
                          new FieldsExtractor<
                              SetDiskAutoDeleteInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetDiskAutoDeleteInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetDiskAutoDeleteInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetDiskAutoDeleteInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetDiskAutoDeleteInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetDiskAutoDeleteInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putQueryParam(
                                  fields, "autoDelete", request.getAutoDelete());
                              serializer.putQueryParam(
                                  fields, "deviceName", request.getDeviceName());
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetDiskAutoDeleteInstanceRequest, String>() {
                            @Override
                            public String extract(SetDiskAutoDeleteInstanceRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetIamPolicyInstanceRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyInstanceRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.SetIamPolicy")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{resource}/setIamPolicy",
                          new FieldsExtractor<SetIamPolicyInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetIamPolicyInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetIamPolicyInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetIamPolicyInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetIamPolicyInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetIamPolicyInstanceRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetIamPolicyInstanceRequest, String>() {
                            @Override
                            public String extract(SetIamPolicyInstanceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "zoneSetPolicyRequestResource",
                                      request.getZoneSetPolicyRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetLabelsInstanceRequest, Operation>
      setLabelsMethodDescriptor =
          ApiMethodDescriptor.<SetLabelsInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.SetLabels")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetLabelsInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/setLabels",
                          new FieldsExtractor<SetLabelsInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(SetLabelsInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetLabelsInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetLabelsInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetLabelsInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetLabelsInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetLabelsInstanceRequest, String>() {
                            @Override
                            public String extract(SetLabelsInstanceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instancesSetLabelsRequestResource",
                                      request.getInstancesSetLabelsRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetMachineResourcesInstanceRequest, Operation>
      setMachineResourcesMethodDescriptor =
          ApiMethodDescriptor.<SetMachineResourcesInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.SetMachineResources")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetMachineResourcesInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/setMachineResources",
                          new FieldsExtractor<
                              SetMachineResourcesInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetMachineResourcesInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetMachineResourcesInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetMachineResourcesInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetMachineResourcesInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetMachineResourcesInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetMachineResourcesInstanceRequest, String>() {
                            @Override
                            public String extract(SetMachineResourcesInstanceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instancesSetMachineResourcesRequestResource",
                                      request.getInstancesSetMachineResourcesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetMachineTypeInstanceRequest, Operation>
      setMachineTypeMethodDescriptor =
          ApiMethodDescriptor.<SetMachineTypeInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.SetMachineType")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetMachineTypeInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/setMachineType",
                          new FieldsExtractor<
                              SetMachineTypeInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetMachineTypeInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetMachineTypeInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetMachineTypeInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetMachineTypeInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetMachineTypeInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetMachineTypeInstanceRequest, String>() {
                            @Override
                            public String extract(SetMachineTypeInstanceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instancesSetMachineTypeRequestResource",
                                      request.getInstancesSetMachineTypeRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetMetadataInstanceRequest, Operation>
      setMetadataMethodDescriptor =
          ApiMethodDescriptor.<SetMetadataInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.SetMetadata")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetMetadataInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/setMetadata",
                          new FieldsExtractor<SetMetadataInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(SetMetadataInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetMetadataInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetMetadataInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetMetadataInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetMetadataInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetMetadataInstanceRequest, String>() {
                            @Override
                            public String extract(SetMetadataInstanceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("metadataResource", request.getMetadataResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetMinCpuPlatformInstanceRequest, Operation>
      setMinCpuPlatformMethodDescriptor =
          ApiMethodDescriptor.<SetMinCpuPlatformInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.SetMinCpuPlatform")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetMinCpuPlatformInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/setMinCpuPlatform",
                          new FieldsExtractor<
                              SetMinCpuPlatformInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetMinCpuPlatformInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetMinCpuPlatformInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetMinCpuPlatformInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetMinCpuPlatformInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetMinCpuPlatformInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetMinCpuPlatformInstanceRequest, String>() {
                            @Override
                            public String extract(SetMinCpuPlatformInstanceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instancesSetMinCpuPlatformRequestResource",
                                      request.getInstancesSetMinCpuPlatformRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetSchedulingInstanceRequest, Operation>
      setSchedulingMethodDescriptor =
          ApiMethodDescriptor.<SetSchedulingInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.SetScheduling")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetSchedulingInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/setScheduling",
                          new FieldsExtractor<SetSchedulingInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetSchedulingInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetSchedulingInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetSchedulingInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetSchedulingInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetSchedulingInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetSchedulingInstanceRequest, String>() {
                            @Override
                            public String extract(SetSchedulingInstanceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("schedulingResource", request.getSchedulingResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetServiceAccountInstanceRequest, Operation>
      setServiceAccountMethodDescriptor =
          ApiMethodDescriptor.<SetServiceAccountInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.SetServiceAccount")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetServiceAccountInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/setServiceAccount",
                          new FieldsExtractor<
                              SetServiceAccountInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetServiceAccountInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetServiceAccountInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetServiceAccountInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetServiceAccountInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetServiceAccountInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetServiceAccountInstanceRequest, String>() {
                            @Override
                            public String extract(SetServiceAccountInstanceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instancesSetServiceAccountRequestResource",
                                      request.getInstancesSetServiceAccountRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation>
      setShieldedInstanceIntegrityPolicyMethodDescriptor =
          ApiMethodDescriptor
              .<SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.Instances.SetShieldedInstanceIntegrityPolicy")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SetShieldedInstanceIntegrityPolicyInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/setShieldedInstanceIntegrityPolicy",
                          new FieldsExtractor<
                              SetShieldedInstanceIntegrityPolicyInstanceRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetShieldedInstanceIntegrityPolicyInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetShieldedInstanceIntegrityPolicyInstanceRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetShieldedInstanceIntegrityPolicyInstanceRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetShieldedInstanceIntegrityPolicyInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetShieldedInstanceIntegrityPolicyInstanceRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<
                              SetShieldedInstanceIntegrityPolicyInstanceRequest, String>() {
                            @Override
                            public String extract(
                                SetShieldedInstanceIntegrityPolicyInstanceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "shieldedInstanceIntegrityPolicyResource",
                                      request.getShieldedInstanceIntegrityPolicyResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetTagsInstanceRequest, Operation>
      setTagsMethodDescriptor =
          ApiMethodDescriptor.<SetTagsInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.SetTags")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetTagsInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/setTags",
                          new FieldsExtractor<SetTagsInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(SetTagsInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetTagsInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<SetTagsInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetTagsInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetTagsInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetTagsInstanceRequest, String>() {
                            @Override
                            public String extract(SetTagsInstanceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("tagsResource", request.getTagsResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SimulateMaintenanceEventInstanceRequest, Operation>
      simulateMaintenanceEventMethodDescriptor =
          ApiMethodDescriptor.<SimulateMaintenanceEventInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.SimulateMaintenanceEvent")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SimulateMaintenanceEventInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/simulateMaintenanceEvent",
                          new FieldsExtractor<
                              SimulateMaintenanceEventInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SimulateMaintenanceEventInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SimulateMaintenanceEventInstanceRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SimulateMaintenanceEventInstanceRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SimulateMaintenanceEventInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SimulateMaintenanceEventInstanceRequest>
                                  serializer = ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SimulateMaintenanceEventInstanceRequest, String>() {
                            @Override
                            public String extract(SimulateMaintenanceEventInstanceRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<StartInstanceRequest, Operation> startMethodDescriptor =
      ApiMethodDescriptor.<StartInstanceRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Instances.Start")
          .setHttpMethod(HttpMethods.POST)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<StartInstanceRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/start",
                      new FieldsExtractor<StartInstanceRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(StartInstanceRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<StartInstanceRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "zone", request.getZone());
                          serializer.putPathParam(fields, "instance", request.getInstance());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<StartInstanceRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(StartInstanceRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<StartInstanceRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<StartInstanceRequest, String>() {
                        @Override
                        public String extract(StartInstanceRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<StartWithEncryptionKeyInstanceRequest, Operation>
      startWithEncryptionKeyMethodDescriptor =
          ApiMethodDescriptor.<StartWithEncryptionKeyInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.StartWithEncryptionKey")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StartWithEncryptionKeyInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/startWithEncryptionKey",
                          new FieldsExtractor<
                              StartWithEncryptionKeyInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                StartWithEncryptionKeyInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<StartWithEncryptionKeyInstanceRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              StartWithEncryptionKeyInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                StartWithEncryptionKeyInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<StartWithEncryptionKeyInstanceRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<StartWithEncryptionKeyInstanceRequest, String>() {
                            @Override
                            public String extract(StartWithEncryptionKeyInstanceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instancesStartWithEncryptionKeyRequestResource",
                                      request.getInstancesStartWithEncryptionKeyRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<StopInstanceRequest, Operation> stopMethodDescriptor =
      ApiMethodDescriptor.<StopInstanceRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Instances.Stop")
          .setHttpMethod(HttpMethods.POST)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<StopInstanceRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/stop",
                      new FieldsExtractor<StopInstanceRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(StopInstanceRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<StopInstanceRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "zone", request.getZone());
                          serializer.putPathParam(fields, "instance", request.getInstance());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<StopInstanceRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(StopInstanceRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<StopInstanceRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<StopInstanceRequest, String>() {
                        @Override
                        public String extract(StopInstanceRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          TestIamPermissionsInstanceRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsInstanceRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.TestIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{resource}/testIamPermissions",
                          new FieldsExtractor<
                              TestIamPermissionsInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                TestIamPermissionsInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              TestIamPermissionsInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                TestIamPermissionsInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsInstanceRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<TestIamPermissionsInstanceRequest, String>() {
                            @Override
                            public String extract(TestIamPermissionsInstanceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "testPermissionsRequestResource",
                                      request.getTestPermissionsRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestPermissionsResponse.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<UpdateInstanceRequest, Operation> updateMethodDescriptor =
      ApiMethodDescriptor.<UpdateInstanceRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Instances.Update")
          .setHttpMethod(HttpMethods.PUT)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateInstanceRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}",
                      new FieldsExtractor<UpdateInstanceRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(UpdateInstanceRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<UpdateInstanceRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "zone", request.getZone());
                          serializer.putPathParam(fields, "instance", request.getInstance());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<UpdateInstanceRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(UpdateInstanceRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<UpdateInstanceRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasMinimalAction()) {
                            serializer.putQueryParam(
                                fields, "minimalAction", request.getMinimalAction());
                          }
                          if (request.hasMostDisruptiveAllowedAction()) {
                            serializer.putQueryParam(
                                fields,
                                "mostDisruptiveAllowedAction",
                                request.getMostDisruptiveAllowedAction());
                          }
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<UpdateInstanceRequest, String>() {
                        @Override
                        public String extract(UpdateInstanceRequest request) {
                          return ProtoRestSerializer.create()
                              .toBody("instanceResource", request.getInstanceResource());
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<UpdateAccessConfigInstanceRequest, Operation>
      updateAccessConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateAccessConfigInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.UpdateAccessConfig")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAccessConfigInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/updateAccessConfig",
                          new FieldsExtractor<
                              UpdateAccessConfigInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                UpdateAccessConfigInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateAccessConfigInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              UpdateAccessConfigInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                UpdateAccessConfigInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateAccessConfigInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putQueryParam(
                                  fields, "networkInterface", request.getNetworkInterface());
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<UpdateAccessConfigInstanceRequest, String>() {
                            @Override
                            public String extract(UpdateAccessConfigInstanceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "accessConfigResource", request.getAccessConfigResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<UpdateDisplayDeviceInstanceRequest, Operation>
      updateDisplayDeviceMethodDescriptor =
          ApiMethodDescriptor.<UpdateDisplayDeviceInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.UpdateDisplayDevice")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDisplayDeviceInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/updateDisplayDevice",
                          new FieldsExtractor<
                              UpdateDisplayDeviceInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                UpdateDisplayDeviceInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateDisplayDeviceInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              UpdateDisplayDeviceInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                UpdateDisplayDeviceInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateDisplayDeviceInstanceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<UpdateDisplayDeviceInstanceRequest, String>() {
                            @Override
                            public String extract(UpdateDisplayDeviceInstanceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "displayDeviceResource", request.getDisplayDeviceResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<UpdateNetworkInterfaceInstanceRequest, Operation>
      updateNetworkInterfaceMethodDescriptor =
          ApiMethodDescriptor.<UpdateNetworkInterfaceInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.UpdateNetworkInterface")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateNetworkInterfaceInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/updateNetworkInterface",
                          new FieldsExtractor<
                              UpdateNetworkInterfaceInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                UpdateNetworkInterfaceInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateNetworkInterfaceInstanceRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              UpdateNetworkInterfaceInstanceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                UpdateNetworkInterfaceInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateNetworkInterfaceInstanceRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putQueryParam(
                                  fields, "networkInterface", request.getNetworkInterface());
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<UpdateNetworkInterfaceInstanceRequest, String>() {
                            @Override
                            public String extract(UpdateNetworkInterfaceInstanceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "networkInterfaceResource",
                                      request.getNetworkInterfaceResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<UpdateShieldedInstanceConfigInstanceRequest, Operation>
      updateShieldedInstanceConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateShieldedInstanceConfigInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances.UpdateShieldedInstanceConfig")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<UpdateShieldedInstanceConfigInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/updateShieldedInstanceConfig",
                          new FieldsExtractor<
                              UpdateShieldedInstanceConfigInstanceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                UpdateShieldedInstanceConfigInstanceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateShieldedInstanceConfigInstanceRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "instance", request.getInstance());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              UpdateShieldedInstanceConfigInstanceRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                UpdateShieldedInstanceConfigInstanceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateShieldedInstanceConfigInstanceRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<
                              UpdateShieldedInstanceConfigInstanceRequest, String>() {
                            @Override
                            public String extract(
                                UpdateShieldedInstanceConfigInstanceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "shieldedInstanceConfigResource",
                                      request.getShieldedInstanceConfigResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AddAccessConfigInstanceRequest, Operation> addAccessConfigCallable;
  private final UnaryCallable<AddResourcePoliciesInstanceRequest, Operation>
      addResourcePoliciesCallable;
  private final UnaryCallable<AggregatedListInstancesRequest, InstanceAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListInstancesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<AttachDiskInstanceRequest, Operation> attachDiskCallable;
  private final UnaryCallable<DeleteInstanceRequest, Operation> deleteCallable;
  private final UnaryCallable<DeleteAccessConfigInstanceRequest, Operation>
      deleteAccessConfigCallable;
  private final UnaryCallable<DetachDiskInstanceRequest, Operation> detachDiskCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getCallable;
  private final UnaryCallable<GetGuestAttributesInstanceRequest, GuestAttributes>
      getGuestAttributesCallable;
  private final UnaryCallable<GetIamPolicyInstanceRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<GetScreenshotInstanceRequest, Screenshot> getScreenshotCallable;
  private final UnaryCallable<GetSerialPortOutputInstanceRequest, SerialPortOutput>
      getSerialPortOutputCallable;
  private final UnaryCallable<GetShieldedInstanceIdentityInstanceRequest, ShieldedInstanceIdentity>
      getShieldedInstanceIdentityCallable;
  private final UnaryCallable<InsertInstanceRequest, Operation> insertCallable;
  private final UnaryCallable<ListInstancesRequest, InstanceList> listCallable;
  private final UnaryCallable<ListInstancesRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<ListReferrersInstancesRequest, InstanceListReferrers>
      listReferrersCallable;
  private final UnaryCallable<ListReferrersInstancesRequest, ListReferrersPagedResponse>
      listReferrersPagedCallable;
  private final UnaryCallable<RemoveResourcePoliciesInstanceRequest, Operation>
      removeResourcePoliciesCallable;
  private final UnaryCallable<ResetInstanceRequest, Operation> resetCallable;
  private final UnaryCallable<SetDeletionProtectionInstanceRequest, Operation>
      setDeletionProtectionCallable;
  private final UnaryCallable<SetDiskAutoDeleteInstanceRequest, Operation>
      setDiskAutoDeleteCallable;
  private final UnaryCallable<SetIamPolicyInstanceRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<SetLabelsInstanceRequest, Operation> setLabelsCallable;
  private final UnaryCallable<SetMachineResourcesInstanceRequest, Operation>
      setMachineResourcesCallable;
  private final UnaryCallable<SetMachineTypeInstanceRequest, Operation> setMachineTypeCallable;
  private final UnaryCallable<SetMetadataInstanceRequest, Operation> setMetadataCallable;
  private final UnaryCallable<SetMinCpuPlatformInstanceRequest, Operation>
      setMinCpuPlatformCallable;
  private final UnaryCallable<SetSchedulingInstanceRequest, Operation> setSchedulingCallable;
  private final UnaryCallable<SetServiceAccountInstanceRequest, Operation>
      setServiceAccountCallable;
  private final UnaryCallable<SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation>
      setShieldedInstanceIntegrityPolicyCallable;
  private final UnaryCallable<SetTagsInstanceRequest, Operation> setTagsCallable;
  private final UnaryCallable<SimulateMaintenanceEventInstanceRequest, Operation>
      simulateMaintenanceEventCallable;
  private final UnaryCallable<StartInstanceRequest, Operation> startCallable;
  private final UnaryCallable<StartWithEncryptionKeyInstanceRequest, Operation>
      startWithEncryptionKeyCallable;
  private final UnaryCallable<StopInstanceRequest, Operation> stopCallable;
  private final UnaryCallable<TestIamPermissionsInstanceRequest, TestPermissionsResponse>
      testIamPermissionsCallable;
  private final UnaryCallable<UpdateInstanceRequest, Operation> updateCallable;
  private final UnaryCallable<UpdateAccessConfigInstanceRequest, Operation>
      updateAccessConfigCallable;
  private final UnaryCallable<UpdateDisplayDeviceInstanceRequest, Operation>
      updateDisplayDeviceCallable;
  private final UnaryCallable<UpdateNetworkInterfaceInstanceRequest, Operation>
      updateNetworkInterfaceCallable;
  private final UnaryCallable<UpdateShieldedInstanceConfigInstanceRequest, Operation>
      updateShieldedInstanceConfigCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonInstancesStub create(InstancesStubSettings settings)
      throws IOException {
    return new HttpJsonInstancesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonInstancesStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonInstancesStub(InstancesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonInstancesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonInstancesStub(
        InstancesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonInstancesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonInstancesStub(InstancesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonInstancesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonInstancesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonInstancesStub(
      InstancesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AddAccessConfigInstanceRequest, Operation>
        addAccessConfigTransportSettings =
            HttpJsonCallSettings.<AddAccessConfigInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(addAccessConfigMethodDescriptor)
                .build();
    HttpJsonCallSettings<AddResourcePoliciesInstanceRequest, Operation>
        addResourcePoliciesTransportSettings =
            HttpJsonCallSettings.<AddResourcePoliciesInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(addResourcePoliciesMethodDescriptor)
                .build();
    HttpJsonCallSettings<AggregatedListInstancesRequest, InstanceAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListInstancesRequest, InstanceAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .build();
    HttpJsonCallSettings<AttachDiskInstanceRequest, Operation> attachDiskTransportSettings =
        HttpJsonCallSettings.<AttachDiskInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(attachDiskMethodDescriptor)
            .build();
    HttpJsonCallSettings<DeleteInstanceRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<DeleteAccessConfigInstanceRequest, Operation>
        deleteAccessConfigTransportSettings =
            HttpJsonCallSettings.<DeleteAccessConfigInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteAccessConfigMethodDescriptor)
                .build();
    HttpJsonCallSettings<DetachDiskInstanceRequest, Operation> detachDiskTransportSettings =
        HttpJsonCallSettings.<DetachDiskInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(detachDiskMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetInstanceRequest, Instance> getTransportSettings =
        HttpJsonCallSettings.<GetInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetGuestAttributesInstanceRequest, GuestAttributes>
        getGuestAttributesTransportSettings =
            HttpJsonCallSettings.<GetGuestAttributesInstanceRequest, GuestAttributes>newBuilder()
                .setMethodDescriptor(getGuestAttributesMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetIamPolicyInstanceRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyInstanceRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetScreenshotInstanceRequest, Screenshot> getScreenshotTransportSettings =
        HttpJsonCallSettings.<GetScreenshotInstanceRequest, Screenshot>newBuilder()
            .setMethodDescriptor(getScreenshotMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetSerialPortOutputInstanceRequest, SerialPortOutput>
        getSerialPortOutputTransportSettings =
            HttpJsonCallSettings.<GetSerialPortOutputInstanceRequest, SerialPortOutput>newBuilder()
                .setMethodDescriptor(getSerialPortOutputMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetShieldedInstanceIdentityInstanceRequest, ShieldedInstanceIdentity>
        getShieldedInstanceIdentityTransportSettings =
            HttpJsonCallSettings
                .<GetShieldedInstanceIdentityInstanceRequest, ShieldedInstanceIdentity>newBuilder()
                .setMethodDescriptor(getShieldedInstanceIdentityMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertInstanceRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListInstancesRequest, InstanceList> listTransportSettings =
        HttpJsonCallSettings.<ListInstancesRequest, InstanceList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListReferrersInstancesRequest, InstanceListReferrers>
        listReferrersTransportSettings =
            HttpJsonCallSettings.<ListReferrersInstancesRequest, InstanceListReferrers>newBuilder()
                .setMethodDescriptor(listReferrersMethodDescriptor)
                .build();
    HttpJsonCallSettings<RemoveResourcePoliciesInstanceRequest, Operation>
        removeResourcePoliciesTransportSettings =
            HttpJsonCallSettings.<RemoveResourcePoliciesInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(removeResourcePoliciesMethodDescriptor)
                .build();
    HttpJsonCallSettings<ResetInstanceRequest, Operation> resetTransportSettings =
        HttpJsonCallSettings.<ResetInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(resetMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetDeletionProtectionInstanceRequest, Operation>
        setDeletionProtectionTransportSettings =
            HttpJsonCallSettings.<SetDeletionProtectionInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(setDeletionProtectionMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetDiskAutoDeleteInstanceRequest, Operation>
        setDiskAutoDeleteTransportSettings =
            HttpJsonCallSettings.<SetDiskAutoDeleteInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(setDiskAutoDeleteMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetIamPolicyInstanceRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyInstanceRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetLabelsInstanceRequest, Operation> setLabelsTransportSettings =
        HttpJsonCallSettings.<SetLabelsInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(setLabelsMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetMachineResourcesInstanceRequest, Operation>
        setMachineResourcesTransportSettings =
            HttpJsonCallSettings.<SetMachineResourcesInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(setMachineResourcesMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetMachineTypeInstanceRequest, Operation> setMachineTypeTransportSettings =
        HttpJsonCallSettings.<SetMachineTypeInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(setMachineTypeMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetMetadataInstanceRequest, Operation> setMetadataTransportSettings =
        HttpJsonCallSettings.<SetMetadataInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(setMetadataMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetMinCpuPlatformInstanceRequest, Operation>
        setMinCpuPlatformTransportSettings =
            HttpJsonCallSettings.<SetMinCpuPlatformInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(setMinCpuPlatformMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetSchedulingInstanceRequest, Operation> setSchedulingTransportSettings =
        HttpJsonCallSettings.<SetSchedulingInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(setSchedulingMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetServiceAccountInstanceRequest, Operation>
        setServiceAccountTransportSettings =
            HttpJsonCallSettings.<SetServiceAccountInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(setServiceAccountMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation>
        setShieldedInstanceIntegrityPolicyTransportSettings =
            HttpJsonCallSettings
                .<SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(setShieldedInstanceIntegrityPolicyMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetTagsInstanceRequest, Operation> setTagsTransportSettings =
        HttpJsonCallSettings.<SetTagsInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(setTagsMethodDescriptor)
            .build();
    HttpJsonCallSettings<SimulateMaintenanceEventInstanceRequest, Operation>
        simulateMaintenanceEventTransportSettings =
            HttpJsonCallSettings.<SimulateMaintenanceEventInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(simulateMaintenanceEventMethodDescriptor)
                .build();
    HttpJsonCallSettings<StartInstanceRequest, Operation> startTransportSettings =
        HttpJsonCallSettings.<StartInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(startMethodDescriptor)
            .build();
    HttpJsonCallSettings<StartWithEncryptionKeyInstanceRequest, Operation>
        startWithEncryptionKeyTransportSettings =
            HttpJsonCallSettings.<StartWithEncryptionKeyInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(startWithEncryptionKeyMethodDescriptor)
                .build();
    HttpJsonCallSettings<StopInstanceRequest, Operation> stopTransportSettings =
        HttpJsonCallSettings.<StopInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(stopMethodDescriptor)
            .build();
    HttpJsonCallSettings<TestIamPermissionsInstanceRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsInstanceRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .build();
    HttpJsonCallSettings<UpdateInstanceRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<UpdateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMethodDescriptor)
            .build();
    HttpJsonCallSettings<UpdateAccessConfigInstanceRequest, Operation>
        updateAccessConfigTransportSettings =
            HttpJsonCallSettings.<UpdateAccessConfigInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(updateAccessConfigMethodDescriptor)
                .build();
    HttpJsonCallSettings<UpdateDisplayDeviceInstanceRequest, Operation>
        updateDisplayDeviceTransportSettings =
            HttpJsonCallSettings.<UpdateDisplayDeviceInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(updateDisplayDeviceMethodDescriptor)
                .build();
    HttpJsonCallSettings<UpdateNetworkInterfaceInstanceRequest, Operation>
        updateNetworkInterfaceTransportSettings =
            HttpJsonCallSettings.<UpdateNetworkInterfaceInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(updateNetworkInterfaceMethodDescriptor)
                .build();
    HttpJsonCallSettings<UpdateShieldedInstanceConfigInstanceRequest, Operation>
        updateShieldedInstanceConfigTransportSettings =
            HttpJsonCallSettings
                .<UpdateShieldedInstanceConfigInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(updateShieldedInstanceConfigMethodDescriptor)
                .build();

    this.addAccessConfigCallable =
        callableFactory.createUnaryCallable(
            addAccessConfigTransportSettings, settings.addAccessConfigSettings(), clientContext);
    this.addResourcePoliciesCallable =
        callableFactory.createUnaryCallable(
            addResourcePoliciesTransportSettings,
            settings.addResourcePoliciesSettings(),
            clientContext);
    this.aggregatedListCallable =
        callableFactory.createUnaryCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.aggregatedListPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.attachDiskCallable =
        callableFactory.createUnaryCallable(
            attachDiskTransportSettings, settings.attachDiskSettings(), clientContext);
    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.deleteAccessConfigCallable =
        callableFactory.createUnaryCallable(
            deleteAccessConfigTransportSettings,
            settings.deleteAccessConfigSettings(),
            clientContext);
    this.detachDiskCallable =
        callableFactory.createUnaryCallable(
            detachDiskTransportSettings, settings.detachDiskSettings(), clientContext);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.getGuestAttributesCallable =
        callableFactory.createUnaryCallable(
            getGuestAttributesTransportSettings,
            settings.getGuestAttributesSettings(),
            clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.getScreenshotCallable =
        callableFactory.createUnaryCallable(
            getScreenshotTransportSettings, settings.getScreenshotSettings(), clientContext);
    this.getSerialPortOutputCallable =
        callableFactory.createUnaryCallable(
            getSerialPortOutputTransportSettings,
            settings.getSerialPortOutputSettings(),
            clientContext);
    this.getShieldedInstanceIdentityCallable =
        callableFactory.createUnaryCallable(
            getShieldedInstanceIdentityTransportSettings,
            settings.getShieldedInstanceIdentitySettings(),
            clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listReferrersCallable =
        callableFactory.createUnaryCallable(
            listReferrersTransportSettings, settings.listReferrersSettings(), clientContext);
    this.listReferrersPagedCallable =
        callableFactory.createPagedCallable(
            listReferrersTransportSettings, settings.listReferrersSettings(), clientContext);
    this.removeResourcePoliciesCallable =
        callableFactory.createUnaryCallable(
            removeResourcePoliciesTransportSettings,
            settings.removeResourcePoliciesSettings(),
            clientContext);
    this.resetCallable =
        callableFactory.createUnaryCallable(
            resetTransportSettings, settings.resetSettings(), clientContext);
    this.setDeletionProtectionCallable =
        callableFactory.createUnaryCallable(
            setDeletionProtectionTransportSettings,
            settings.setDeletionProtectionSettings(),
            clientContext);
    this.setDiskAutoDeleteCallable =
        callableFactory.createUnaryCallable(
            setDiskAutoDeleteTransportSettings,
            settings.setDiskAutoDeleteSettings(),
            clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.setLabelsCallable =
        callableFactory.createUnaryCallable(
            setLabelsTransportSettings, settings.setLabelsSettings(), clientContext);
    this.setMachineResourcesCallable =
        callableFactory.createUnaryCallable(
            setMachineResourcesTransportSettings,
            settings.setMachineResourcesSettings(),
            clientContext);
    this.setMachineTypeCallable =
        callableFactory.createUnaryCallable(
            setMachineTypeTransportSettings, settings.setMachineTypeSettings(), clientContext);
    this.setMetadataCallable =
        callableFactory.createUnaryCallable(
            setMetadataTransportSettings, settings.setMetadataSettings(), clientContext);
    this.setMinCpuPlatformCallable =
        callableFactory.createUnaryCallable(
            setMinCpuPlatformTransportSettings,
            settings.setMinCpuPlatformSettings(),
            clientContext);
    this.setSchedulingCallable =
        callableFactory.createUnaryCallable(
            setSchedulingTransportSettings, settings.setSchedulingSettings(), clientContext);
    this.setServiceAccountCallable =
        callableFactory.createUnaryCallable(
            setServiceAccountTransportSettings,
            settings.setServiceAccountSettings(),
            clientContext);
    this.setShieldedInstanceIntegrityPolicyCallable =
        callableFactory.createUnaryCallable(
            setShieldedInstanceIntegrityPolicyTransportSettings,
            settings.setShieldedInstanceIntegrityPolicySettings(),
            clientContext);
    this.setTagsCallable =
        callableFactory.createUnaryCallable(
            setTagsTransportSettings, settings.setTagsSettings(), clientContext);
    this.simulateMaintenanceEventCallable =
        callableFactory.createUnaryCallable(
            simulateMaintenanceEventTransportSettings,
            settings.simulateMaintenanceEventSettings(),
            clientContext);
    this.startCallable =
        callableFactory.createUnaryCallable(
            startTransportSettings, settings.startSettings(), clientContext);
    this.startWithEncryptionKeyCallable =
        callableFactory.createUnaryCallable(
            startWithEncryptionKeyTransportSettings,
            settings.startWithEncryptionKeySettings(),
            clientContext);
    this.stopCallable =
        callableFactory.createUnaryCallable(
            stopTransportSettings, settings.stopSettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);
    this.updateCallable =
        callableFactory.createUnaryCallable(
            updateTransportSettings, settings.updateSettings(), clientContext);
    this.updateAccessConfigCallable =
        callableFactory.createUnaryCallable(
            updateAccessConfigTransportSettings,
            settings.updateAccessConfigSettings(),
            clientContext);
    this.updateDisplayDeviceCallable =
        callableFactory.createUnaryCallable(
            updateDisplayDeviceTransportSettings,
            settings.updateDisplayDeviceSettings(),
            clientContext);
    this.updateNetworkInterfaceCallable =
        callableFactory.createUnaryCallable(
            updateNetworkInterfaceTransportSettings,
            settings.updateNetworkInterfaceSettings(),
            clientContext);
    this.updateShieldedInstanceConfigCallable =
        callableFactory.createUnaryCallable(
            updateShieldedInstanceConfigTransportSettings,
            settings.updateShieldedInstanceConfigSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<AddAccessConfigInstanceRequest, Operation> addAccessConfigCallable() {
    return addAccessConfigCallable;
  }

  public UnaryCallable<AddResourcePoliciesInstanceRequest, Operation>
      addResourcePoliciesCallable() {
    return addResourcePoliciesCallable;
  }

  public UnaryCallable<AggregatedListInstancesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  public UnaryCallable<AggregatedListInstancesRequest, InstanceAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  public UnaryCallable<AttachDiskInstanceRequest, Operation> attachDiskCallable() {
    return attachDiskCallable;
  }

  public UnaryCallable<DeleteInstanceRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<DeleteAccessConfigInstanceRequest, Operation> deleteAccessConfigCallable() {
    return deleteAccessConfigCallable;
  }

  public UnaryCallable<DetachDiskInstanceRequest, Operation> detachDiskCallable() {
    return detachDiskCallable;
  }

  public UnaryCallable<GetInstanceRequest, Instance> getCallable() {
    return getCallable;
  }

  public UnaryCallable<GetGuestAttributesInstanceRequest, GuestAttributes>
      getGuestAttributesCallable() {
    return getGuestAttributesCallable;
  }

  public UnaryCallable<GetIamPolicyInstanceRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  public UnaryCallable<GetScreenshotInstanceRequest, Screenshot> getScreenshotCallable() {
    return getScreenshotCallable;
  }

  public UnaryCallable<GetSerialPortOutputInstanceRequest, SerialPortOutput>
      getSerialPortOutputCallable() {
    return getSerialPortOutputCallable;
  }

  public UnaryCallable<GetShieldedInstanceIdentityInstanceRequest, ShieldedInstanceIdentity>
      getShieldedInstanceIdentityCallable() {
    return getShieldedInstanceIdentityCallable;
  }

  public UnaryCallable<InsertInstanceRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListInstancesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListInstancesRequest, InstanceList> listCallable() {
    return listCallable;
  }

  public UnaryCallable<ListReferrersInstancesRequest, ListReferrersPagedResponse>
      listReferrersPagedCallable() {
    return listReferrersPagedCallable;
  }

  public UnaryCallable<ListReferrersInstancesRequest, InstanceListReferrers>
      listReferrersCallable() {
    return listReferrersCallable;
  }

  public UnaryCallable<RemoveResourcePoliciesInstanceRequest, Operation>
      removeResourcePoliciesCallable() {
    return removeResourcePoliciesCallable;
  }

  public UnaryCallable<ResetInstanceRequest, Operation> resetCallable() {
    return resetCallable;
  }

  public UnaryCallable<SetDeletionProtectionInstanceRequest, Operation>
      setDeletionProtectionCallable() {
    return setDeletionProtectionCallable;
  }

  public UnaryCallable<SetDiskAutoDeleteInstanceRequest, Operation> setDiskAutoDeleteCallable() {
    return setDiskAutoDeleteCallable;
  }

  public UnaryCallable<SetIamPolicyInstanceRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  public UnaryCallable<SetLabelsInstanceRequest, Operation> setLabelsCallable() {
    return setLabelsCallable;
  }

  public UnaryCallable<SetMachineResourcesInstanceRequest, Operation>
      setMachineResourcesCallable() {
    return setMachineResourcesCallable;
  }

  public UnaryCallable<SetMachineTypeInstanceRequest, Operation> setMachineTypeCallable() {
    return setMachineTypeCallable;
  }

  public UnaryCallable<SetMetadataInstanceRequest, Operation> setMetadataCallable() {
    return setMetadataCallable;
  }

  public UnaryCallable<SetMinCpuPlatformInstanceRequest, Operation> setMinCpuPlatformCallable() {
    return setMinCpuPlatformCallable;
  }

  public UnaryCallable<SetSchedulingInstanceRequest, Operation> setSchedulingCallable() {
    return setSchedulingCallable;
  }

  public UnaryCallable<SetServiceAccountInstanceRequest, Operation> setServiceAccountCallable() {
    return setServiceAccountCallable;
  }

  public UnaryCallable<SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation>
      setShieldedInstanceIntegrityPolicyCallable() {
    return setShieldedInstanceIntegrityPolicyCallable;
  }

  public UnaryCallable<SetTagsInstanceRequest, Operation> setTagsCallable() {
    return setTagsCallable;
  }

  public UnaryCallable<SimulateMaintenanceEventInstanceRequest, Operation>
      simulateMaintenanceEventCallable() {
    return simulateMaintenanceEventCallable;
  }

  public UnaryCallable<StartInstanceRequest, Operation> startCallable() {
    return startCallable;
  }

  public UnaryCallable<StartWithEncryptionKeyInstanceRequest, Operation>
      startWithEncryptionKeyCallable() {
    return startWithEncryptionKeyCallable;
  }

  public UnaryCallable<StopInstanceRequest, Operation> stopCallable() {
    return stopCallable;
  }

  public UnaryCallable<TestIamPermissionsInstanceRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  public UnaryCallable<UpdateInstanceRequest, Operation> updateCallable() {
    return updateCallable;
  }

  public UnaryCallable<UpdateAccessConfigInstanceRequest, Operation> updateAccessConfigCallable() {
    return updateAccessConfigCallable;
  }

  public UnaryCallable<UpdateDisplayDeviceInstanceRequest, Operation>
      updateDisplayDeviceCallable() {
    return updateDisplayDeviceCallable;
  }

  public UnaryCallable<UpdateNetworkInterfaceInstanceRequest, Operation>
      updateNetworkInterfaceCallable() {
    return updateNetworkInterfaceCallable;
  }

  public UnaryCallable<UpdateShieldedInstanceConfigInstanceRequest, Operation>
      updateShieldedInstanceConfigCallable() {
    return updateShieldedInstanceConfigCallable;
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
