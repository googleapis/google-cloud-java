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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.InstancesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.InstancesClient.ListPagedResponse;
import static com.google.cloud.compute.v1.InstancesClient.ListReferrersPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddAccessConfigInstanceRequest;
import com.google.cloud.compute.v1.AddResourcePoliciesInstanceRequest;
import com.google.cloud.compute.v1.AggregatedListInstancesRequest;
import com.google.cloud.compute.v1.AttachDiskInstanceRequest;
import com.google.cloud.compute.v1.BulkInsertInstanceRequest;
import com.google.cloud.compute.v1.DeleteAccessConfigInstanceRequest;
import com.google.cloud.compute.v1.DeleteInstanceRequest;
import com.google.cloud.compute.v1.DetachDiskInstanceRequest;
import com.google.cloud.compute.v1.GetEffectiveFirewallsInstanceRequest;
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
import com.google.cloud.compute.v1.InstancesGetEffectiveFirewallsResponse;
import com.google.cloud.compute.v1.ListInstancesRequest;
import com.google.cloud.compute.v1.ListReferrersInstancesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.RemoveResourcePoliciesInstanceRequest;
import com.google.cloud.compute.v1.ResetInstanceRequest;
import com.google.cloud.compute.v1.ResumeInstanceRequest;
import com.google.cloud.compute.v1.Screenshot;
import com.google.cloud.compute.v1.SendDiagnosticInterruptInstanceRequest;
import com.google.cloud.compute.v1.SendDiagnosticInterruptInstanceResponse;
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
import com.google.cloud.compute.v1.SuspendInstanceRequest;
import com.google.cloud.compute.v1.TestIamPermissionsInstanceRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.cloud.compute.v1.UpdateAccessConfigInstanceRequest;
import com.google.cloud.compute.v1.UpdateDisplayDeviceInstanceRequest;
import com.google.cloud.compute.v1.UpdateInstanceRequest;
import com.google.cloud.compute.v1.UpdateNetworkInterfaceInstanceRequest;
import com.google.cloud.compute.v1.UpdateShieldedInstanceConfigInstanceRequest;
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
 * REST stub implementation for the Instances service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonInstancesStub extends InstancesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<AddAccessConfigInstanceRequest, Operation>
      addAccessConfigMethodDescriptor =
          ApiMethodDescriptor.<AddAccessConfigInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/AddAccessConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddAccessConfigInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/addAccessConfig",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddAccessConfigInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddAccessConfigInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "networkInterface", request.getNetworkInterface());
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "accessConfigResource",
                                      request.getAccessConfigResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AddAccessConfigInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<AddResourcePoliciesInstanceRequest, Operation>
      addResourcePoliciesMethodDescriptor =
          ApiMethodDescriptor.<AddResourcePoliciesInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/AddResourcePolicies")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddResourcePoliciesInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/addResourcePolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddResourcePoliciesInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddResourcePoliciesInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "instancesAddResourcePoliciesRequestResource",
                                      request.getInstancesAddResourcePoliciesRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AddResourcePoliciesInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<AggregatedListInstancesRequest, InstanceAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor.<AggregatedListInstancesRequest, InstanceAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/AggregatedList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListInstancesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/instances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListInstancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
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
                              serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            }
                            if (request.hasReturnPartialSuccess()) {
                              serializer.putQueryParam(
                                  fields,
                                  "returnPartialSuccess",
                                  request.getReturnPartialSuccess());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstanceAggregatedList>newBuilder()
                      .setDefaultInstance(InstanceAggregatedList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AttachDiskInstanceRequest, Operation>
      attachDiskMethodDescriptor =
          ApiMethodDescriptor.<AttachDiskInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/AttachDisk")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AttachDiskInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/attachDisk",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AttachDiskInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AttachDiskInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasForceAttach()) {
                              serializer.putQueryParam(
                                  fields, "forceAttach", request.getForceAttach());
                            }
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "attachedDiskResource",
                                      request.getAttachedDiskResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AttachDiskInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<BulkInsertInstanceRequest, Operation>
      bulkInsertMethodDescriptor =
          ApiMethodDescriptor.<BulkInsertInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/BulkInsert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BulkInsertInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/bulkInsert",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BulkInsertInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BulkInsertInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "bulkInsertInstanceResourceResource",
                                      request.getBulkInsertInstanceResourceResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (BulkInsertInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<DeleteInstanceRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<DeleteAccessConfigInstanceRequest, Operation>
      deleteAccessConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteAccessConfigInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/DeleteAccessConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAccessConfigInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/deleteAccessConfig",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAccessConfigInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAccessConfigInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "accessConfig", request.getAccessConfig());
                            serializer.putQueryParam(
                                fields, "networkInterface", request.getNetworkInterface());
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteAccessConfigInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<DetachDiskInstanceRequest, Operation>
      detachDiskMethodDescriptor =
          ApiMethodDescriptor.<DetachDiskInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/DetachDisk")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DetachDiskInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/detachDisk",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DetachDiskInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DetachDiskInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "deviceName", request.getDeviceName());
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DetachDiskInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<GetInstanceRequest, Instance> getMethodDescriptor =
      ApiMethodDescriptor.<GetInstanceRequest, Instance>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Instances/Get")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetInstanceRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetInstanceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "instance", request.getInstance());
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "zone", request.getZone());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetInstanceRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Instance>newBuilder()
                  .setDefaultInstance(Instance.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<
          GetEffectiveFirewallsInstanceRequest, InstancesGetEffectiveFirewallsResponse>
      getEffectiveFirewallsMethodDescriptor =
          ApiMethodDescriptor
              .<GetEffectiveFirewallsInstanceRequest, InstancesGetEffectiveFirewallsResponse>
                  newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/GetEffectiveFirewalls")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEffectiveFirewallsInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/getEffectiveFirewalls",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEffectiveFirewallsInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEffectiveFirewallsInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "networkInterface", request.getNetworkInterface());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstancesGetEffectiveFirewallsResponse>newBuilder()
                      .setDefaultInstance(
                          InstancesGetEffectiveFirewallsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetGuestAttributesInstanceRequest, GuestAttributes>
      getGuestAttributesMethodDescriptor =
          ApiMethodDescriptor.<GetGuestAttributesInstanceRequest, GuestAttributes>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/GetGuestAttributes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGuestAttributesInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/getGuestAttributes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGuestAttributesInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGuestAttributesInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasQueryPath()) {
                              serializer.putQueryParam(fields, "queryPath", request.getQueryPath());
                            }
                            if (request.hasVariableKey()) {
                              serializer.putQueryParam(
                                  fields, "variableKey", request.getVariableKey());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GuestAttributes>newBuilder()
                      .setDefaultInstance(GuestAttributes.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyInstanceRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyInstanceRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{resource}/getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
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
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetScreenshotInstanceRequest, Screenshot>
      getScreenshotMethodDescriptor =
          ApiMethodDescriptor.<GetScreenshotInstanceRequest, Screenshot>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/GetScreenshot")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetScreenshotInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/screenshot",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetScreenshotInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetScreenshotInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Screenshot>newBuilder()
                      .setDefaultInstance(Screenshot.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSerialPortOutputInstanceRequest, SerialPortOutput>
      getSerialPortOutputMethodDescriptor =
          ApiMethodDescriptor.<GetSerialPortOutputInstanceRequest, SerialPortOutput>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/GetSerialPortOutput")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSerialPortOutputInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/serialPort",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSerialPortOutputInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
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
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SerialPortOutput>newBuilder()
                      .setDefaultInstance(SerialPortOutput.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetShieldedInstanceIdentityInstanceRequest, ShieldedInstanceIdentity>
      getShieldedInstanceIdentityMethodDescriptor =
          ApiMethodDescriptor
              .<GetShieldedInstanceIdentityInstanceRequest, ShieldedInstanceIdentity>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/GetShieldedInstanceIdentity")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetShieldedInstanceIdentityInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/getShieldedInstanceIdentity",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetShieldedInstanceIdentityInstanceRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetShieldedInstanceIdentityInstanceRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ShieldedInstanceIdentity>newBuilder()
                      .setDefaultInstance(ShieldedInstanceIdentity.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertInstanceRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
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
                            if (request.hasSourceMachineImage()) {
                              serializer.putQueryParam(
                                  fields, "sourceMachineImage", request.getSourceMachineImage());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("instanceResource", request.getInstanceResource(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<ListInstancesRequest, InstanceList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListInstancesRequest, InstanceList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInstancesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListInstancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListInstancesRequest> serializer =
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
                              serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            }
                            if (request.hasReturnPartialSuccess()) {
                              serializer.putQueryParam(
                                  fields,
                                  "returnPartialSuccess",
                                  request.getReturnPartialSuccess());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstanceList>newBuilder()
                      .setDefaultInstance(InstanceList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListReferrersInstancesRequest, InstanceListReferrers>
      listReferrersMethodDescriptor =
          ApiMethodDescriptor.<ListReferrersInstancesRequest, InstanceListReferrers>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/ListReferrers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReferrersInstancesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/referrers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReferrersInstancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
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
                              serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            }
                            if (request.hasReturnPartialSuccess()) {
                              serializer.putQueryParam(
                                  fields,
                                  "returnPartialSuccess",
                                  request.getReturnPartialSuccess());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstanceListReferrers>newBuilder()
                      .setDefaultInstance(InstanceListReferrers.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RemoveResourcePoliciesInstanceRequest, Operation>
      removeResourcePoliciesMethodDescriptor =
          ApiMethodDescriptor.<RemoveResourcePoliciesInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/RemoveResourcePolicies")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveResourcePoliciesInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/removeResourcePolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveResourcePoliciesInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveResourcePoliciesInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "instancesRemoveResourcePoliciesRequestResource",
                                      request.getInstancesRemoveResourcePoliciesRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RemoveResourcePoliciesInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<ResetInstanceRequest, Operation> resetMethodDescriptor =
      ApiMethodDescriptor.<ResetInstanceRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Instances/Reset")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<ResetInstanceRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/reset",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<ResetInstanceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "instance", request.getInstance());
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "zone", request.getZone());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<ResetInstanceRequest> serializer =
                            ProtoRestSerializer.create();
                        if (request.hasRequestId()) {
                          serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        }
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (ResetInstanceRequest request, Operation response) -> {
                StringBuilder opName = new StringBuilder(response.getName());
                opName.append(":").append(request.getProject());
                opName.append(":").append(request.getZone());
                return HttpJsonOperationSnapshot.newBuilder()
                    .setName(opName.toString())
                    .setMetadata(response)
                    .setDone(Status.DONE.equals(response.getStatus()))
                    .setResponse(response)
                    .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                    .build();
              })
          .build();

  private static final ApiMethodDescriptor<ResumeInstanceRequest, Operation>
      resumeMethodDescriptor =
          ApiMethodDescriptor.<ResumeInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/Resume")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResumeInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/resume",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ResumeInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ResumeInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ResumeInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<
          SendDiagnosticInterruptInstanceRequest, SendDiagnosticInterruptInstanceResponse>
      sendDiagnosticInterruptMethodDescriptor =
          ApiMethodDescriptor
              .<SendDiagnosticInterruptInstanceRequest, SendDiagnosticInterruptInstanceResponse>
                  newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/SendDiagnosticInterrupt")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SendDiagnosticInterruptInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/sendDiagnosticInterrupt",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SendDiagnosticInterruptInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SendDiagnosticInterruptInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SendDiagnosticInterruptInstanceResponse>newBuilder()
                      .setDefaultInstance(
                          SendDiagnosticInterruptInstanceResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetDeletionProtectionInstanceRequest, Operation>
      setDeletionProtectionMethodDescriptor =
          ApiMethodDescriptor.<SetDeletionProtectionInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/SetDeletionProtection")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetDeletionProtectionInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{resource}/setDeletionProtection",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetDeletionProtectionInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetDeletionProtectionInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasDeletionProtection()) {
                              serializer.putQueryParam(
                                  fields, "deletionProtection", request.getDeletionProtection());
                            }
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetDeletionProtectionInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<SetDiskAutoDeleteInstanceRequest, Operation>
      setDiskAutoDeleteMethodDescriptor =
          ApiMethodDescriptor.<SetDiskAutoDeleteInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/SetDiskAutoDelete")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetDiskAutoDeleteInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/setDiskAutoDelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetDiskAutoDeleteInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetDiskAutoDeleteInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "autoDelete", request.getAutoDelete());
                            serializer.putQueryParam(fields, "deviceName", request.getDeviceName());
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetDiskAutoDeleteInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyInstanceRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyInstanceRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{resource}/setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "zoneSetPolicyRequestResource",
                                      request.getZoneSetPolicyRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetLabelsInstanceRequest, Operation>
      setLabelsMethodDescriptor =
          ApiMethodDescriptor.<SetLabelsInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/SetLabels")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetLabelsInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/setLabels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetLabelsInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetLabelsInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "instancesSetLabelsRequestResource",
                                      request.getInstancesSetLabelsRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetLabelsInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<SetMachineResourcesInstanceRequest, Operation>
      setMachineResourcesMethodDescriptor =
          ApiMethodDescriptor.<SetMachineResourcesInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/SetMachineResources")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetMachineResourcesInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/setMachineResources",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetMachineResourcesInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetMachineResourcesInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "instancesSetMachineResourcesRequestResource",
                                      request.getInstancesSetMachineResourcesRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetMachineResourcesInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<SetMachineTypeInstanceRequest, Operation>
      setMachineTypeMethodDescriptor =
          ApiMethodDescriptor.<SetMachineTypeInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/SetMachineType")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetMachineTypeInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/setMachineType",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetMachineTypeInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetMachineTypeInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "instancesSetMachineTypeRequestResource",
                                      request.getInstancesSetMachineTypeRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetMachineTypeInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<SetMetadataInstanceRequest, Operation>
      setMetadataMethodDescriptor =
          ApiMethodDescriptor.<SetMetadataInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/SetMetadata")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetMetadataInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/setMetadata",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetMetadataInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetMetadataInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("metadataResource", request.getMetadataResource(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetMetadataInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<SetMinCpuPlatformInstanceRequest, Operation>
      setMinCpuPlatformMethodDescriptor =
          ApiMethodDescriptor.<SetMinCpuPlatformInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/SetMinCpuPlatform")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetMinCpuPlatformInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/setMinCpuPlatform",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetMinCpuPlatformInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetMinCpuPlatformInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "instancesSetMinCpuPlatformRequestResource",
                                      request.getInstancesSetMinCpuPlatformRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetMinCpuPlatformInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<SetSchedulingInstanceRequest, Operation>
      setSchedulingMethodDescriptor =
          ApiMethodDescriptor.<SetSchedulingInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/SetScheduling")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetSchedulingInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/setScheduling",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetSchedulingInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetSchedulingInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "schedulingResource", request.getSchedulingResource(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetSchedulingInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<SetServiceAccountInstanceRequest, Operation>
      setServiceAccountMethodDescriptor =
          ApiMethodDescriptor.<SetServiceAccountInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/SetServiceAccount")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetServiceAccountInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/setServiceAccount",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetServiceAccountInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetServiceAccountInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "instancesSetServiceAccountRequestResource",
                                      request.getInstancesSetServiceAccountRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetServiceAccountInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<
          SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation>
      setShieldedInstanceIntegrityPolicyMethodDescriptor =
          ApiMethodDescriptor
              .<SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.Instances/SetShieldedInstanceIntegrityPolicy")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SetShieldedInstanceIntegrityPolicyInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/setShieldedInstanceIntegrityPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetShieldedInstanceIntegrityPolicyInstanceRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetShieldedInstanceIntegrityPolicyInstanceRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "shieldedInstanceIntegrityPolicyResource",
                                      request.getShieldedInstanceIntegrityPolicyResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetShieldedInstanceIntegrityPolicyInstanceRequest request,
                      Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<SetTagsInstanceRequest, Operation>
      setTagsMethodDescriptor =
          ApiMethodDescriptor.<SetTagsInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/SetTags")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetTagsInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/setTags",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetTagsInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetTagsInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("tagsResource", request.getTagsResource(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetTagsInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<SimulateMaintenanceEventInstanceRequest, Operation>
      simulateMaintenanceEventMethodDescriptor =
          ApiMethodDescriptor.<SimulateMaintenanceEventInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/SimulateMaintenanceEvent")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SimulateMaintenanceEventInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/simulateMaintenanceEvent",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SimulateMaintenanceEventInstanceRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SimulateMaintenanceEventInstanceRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SimulateMaintenanceEventInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<StartInstanceRequest, Operation> startMethodDescriptor =
      ApiMethodDescriptor.<StartInstanceRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Instances/Start")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<StartInstanceRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/start",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<StartInstanceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "instance", request.getInstance());
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "zone", request.getZone());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<StartInstanceRequest> serializer =
                            ProtoRestSerializer.create();
                        if (request.hasRequestId()) {
                          serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        }
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (StartInstanceRequest request, Operation response) -> {
                StringBuilder opName = new StringBuilder(response.getName());
                opName.append(":").append(request.getProject());
                opName.append(":").append(request.getZone());
                return HttpJsonOperationSnapshot.newBuilder()
                    .setName(opName.toString())
                    .setMetadata(response)
                    .setDone(Status.DONE.equals(response.getStatus()))
                    .setResponse(response)
                    .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                    .build();
              })
          .build();

  private static final ApiMethodDescriptor<StartWithEncryptionKeyInstanceRequest, Operation>
      startWithEncryptionKeyMethodDescriptor =
          ApiMethodDescriptor.<StartWithEncryptionKeyInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/StartWithEncryptionKey")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StartWithEncryptionKeyInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/startWithEncryptionKey",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StartWithEncryptionKeyInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StartWithEncryptionKeyInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "instancesStartWithEncryptionKeyRequestResource",
                                      request.getInstancesStartWithEncryptionKeyRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (StartWithEncryptionKeyInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<StopInstanceRequest, Operation> stopMethodDescriptor =
      ApiMethodDescriptor.<StopInstanceRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Instances/Stop")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<StopInstanceRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/stop",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<StopInstanceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "instance", request.getInstance());
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "zone", request.getZone());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<StopInstanceRequest> serializer =
                            ProtoRestSerializer.create();
                        if (request.hasDiscardLocalSsd()) {
                          serializer.putQueryParam(
                              fields, "discardLocalSsd", request.getDiscardLocalSsd());
                        }
                        if (request.hasRequestId()) {
                          serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        }
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (StopInstanceRequest request, Operation response) -> {
                StringBuilder opName = new StringBuilder(response.getName());
                opName.append(":").append(request.getProject());
                opName.append(":").append(request.getZone());
                return HttpJsonOperationSnapshot.newBuilder()
                    .setName(opName.toString())
                    .setMetadata(response)
                    .setDone(Status.DONE.equals(response.getStatus()))
                    .setResponse(response)
                    .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                    .build();
              })
          .build();

  private static final ApiMethodDescriptor<SuspendInstanceRequest, Operation>
      suspendMethodDescriptor =
          ApiMethodDescriptor.<SuspendInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/Suspend")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SuspendInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/suspend",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SuspendInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SuspendInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasDiscardLocalSsd()) {
                              serializer.putQueryParam(
                                  fields, "discardLocalSsd", request.getDiscardLocalSsd());
                            }
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SuspendInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<
          TestIamPermissionsInstanceRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsInstanceRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{resource}/testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "testPermissionsRequestResource",
                                      request.getTestPermissionsRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateInstanceRequest, Operation>
      updateMethodDescriptor =
          ApiMethodDescriptor.<UpdateInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/Update")
              .setHttpMethod("PUT")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
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
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("instanceResource", request.getInstanceResource(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<UpdateAccessConfigInstanceRequest, Operation>
      updateAccessConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateAccessConfigInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/UpdateAccessConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAccessConfigInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/updateAccessConfig",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAccessConfigInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAccessConfigInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "networkInterface", request.getNetworkInterface());
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "accessConfigResource",
                                      request.getAccessConfigResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateAccessConfigInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<UpdateDisplayDeviceInstanceRequest, Operation>
      updateDisplayDeviceMethodDescriptor =
          ApiMethodDescriptor.<UpdateDisplayDeviceInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/UpdateDisplayDevice")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDisplayDeviceInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/updateDisplayDevice",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDisplayDeviceInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDisplayDeviceInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "displayDeviceResource",
                                      request.getDisplayDeviceResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateDisplayDeviceInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<UpdateNetworkInterfaceInstanceRequest, Operation>
      updateNetworkInterfaceMethodDescriptor =
          ApiMethodDescriptor.<UpdateNetworkInterfaceInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/UpdateNetworkInterface")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateNetworkInterfaceInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/updateNetworkInterface",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateNetworkInterfaceInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateNetworkInterfaceInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "networkInterface", request.getNetworkInterface());
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "networkInterfaceResource",
                                      request.getNetworkInterfaceResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateNetworkInterfaceInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<UpdateShieldedInstanceConfigInstanceRequest, Operation>
      updateShieldedInstanceConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateShieldedInstanceConfigInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Instances/UpdateShieldedInstanceConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<UpdateShieldedInstanceConfigInstanceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instances/{instance}/updateShieldedInstanceConfig",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateShieldedInstanceConfigInstanceRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateShieldedInstanceConfigInstanceRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "shieldedInstanceConfigResource",
                                      request.getShieldedInstanceConfigResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateShieldedInstanceConfigInstanceRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private final UnaryCallable<AddAccessConfigInstanceRequest, Operation> addAccessConfigCallable;
  private final OperationCallable<AddAccessConfigInstanceRequest, Operation, Operation>
      addAccessConfigOperationCallable;
  private final UnaryCallable<AddResourcePoliciesInstanceRequest, Operation>
      addResourcePoliciesCallable;
  private final OperationCallable<AddResourcePoliciesInstanceRequest, Operation, Operation>
      addResourcePoliciesOperationCallable;
  private final UnaryCallable<AggregatedListInstancesRequest, InstanceAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListInstancesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<AttachDiskInstanceRequest, Operation> attachDiskCallable;
  private final OperationCallable<AttachDiskInstanceRequest, Operation, Operation>
      attachDiskOperationCallable;
  private final UnaryCallable<BulkInsertInstanceRequest, Operation> bulkInsertCallable;
  private final OperationCallable<BulkInsertInstanceRequest, Operation, Operation>
      bulkInsertOperationCallable;
  private final UnaryCallable<DeleteInstanceRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteInstanceRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<DeleteAccessConfigInstanceRequest, Operation>
      deleteAccessConfigCallable;
  private final OperationCallable<DeleteAccessConfigInstanceRequest, Operation, Operation>
      deleteAccessConfigOperationCallable;
  private final UnaryCallable<DetachDiskInstanceRequest, Operation> detachDiskCallable;
  private final OperationCallable<DetachDiskInstanceRequest, Operation, Operation>
      detachDiskOperationCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getCallable;
  private final UnaryCallable<
          GetEffectiveFirewallsInstanceRequest, InstancesGetEffectiveFirewallsResponse>
      getEffectiveFirewallsCallable;
  private final UnaryCallable<GetGuestAttributesInstanceRequest, GuestAttributes>
      getGuestAttributesCallable;
  private final UnaryCallable<GetIamPolicyInstanceRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<GetScreenshotInstanceRequest, Screenshot> getScreenshotCallable;
  private final UnaryCallable<GetSerialPortOutputInstanceRequest, SerialPortOutput>
      getSerialPortOutputCallable;
  private final UnaryCallable<GetShieldedInstanceIdentityInstanceRequest, ShieldedInstanceIdentity>
      getShieldedInstanceIdentityCallable;
  private final UnaryCallable<InsertInstanceRequest, Operation> insertCallable;
  private final OperationCallable<InsertInstanceRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListInstancesRequest, InstanceList> listCallable;
  private final UnaryCallable<ListInstancesRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<ListReferrersInstancesRequest, InstanceListReferrers>
      listReferrersCallable;
  private final UnaryCallable<ListReferrersInstancesRequest, ListReferrersPagedResponse>
      listReferrersPagedCallable;
  private final UnaryCallable<RemoveResourcePoliciesInstanceRequest, Operation>
      removeResourcePoliciesCallable;
  private final OperationCallable<RemoveResourcePoliciesInstanceRequest, Operation, Operation>
      removeResourcePoliciesOperationCallable;
  private final UnaryCallable<ResetInstanceRequest, Operation> resetCallable;
  private final OperationCallable<ResetInstanceRequest, Operation, Operation>
      resetOperationCallable;
  private final UnaryCallable<ResumeInstanceRequest, Operation> resumeCallable;
  private final OperationCallable<ResumeInstanceRequest, Operation, Operation>
      resumeOperationCallable;
  private final UnaryCallable<
          SendDiagnosticInterruptInstanceRequest, SendDiagnosticInterruptInstanceResponse>
      sendDiagnosticInterruptCallable;
  private final UnaryCallable<SetDeletionProtectionInstanceRequest, Operation>
      setDeletionProtectionCallable;
  private final OperationCallable<SetDeletionProtectionInstanceRequest, Operation, Operation>
      setDeletionProtectionOperationCallable;
  private final UnaryCallable<SetDiskAutoDeleteInstanceRequest, Operation>
      setDiskAutoDeleteCallable;
  private final OperationCallable<SetDiskAutoDeleteInstanceRequest, Operation, Operation>
      setDiskAutoDeleteOperationCallable;
  private final UnaryCallable<SetIamPolicyInstanceRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<SetLabelsInstanceRequest, Operation> setLabelsCallable;
  private final OperationCallable<SetLabelsInstanceRequest, Operation, Operation>
      setLabelsOperationCallable;
  private final UnaryCallable<SetMachineResourcesInstanceRequest, Operation>
      setMachineResourcesCallable;
  private final OperationCallable<SetMachineResourcesInstanceRequest, Operation, Operation>
      setMachineResourcesOperationCallable;
  private final UnaryCallable<SetMachineTypeInstanceRequest, Operation> setMachineTypeCallable;
  private final OperationCallable<SetMachineTypeInstanceRequest, Operation, Operation>
      setMachineTypeOperationCallable;
  private final UnaryCallable<SetMetadataInstanceRequest, Operation> setMetadataCallable;
  private final OperationCallable<SetMetadataInstanceRequest, Operation, Operation>
      setMetadataOperationCallable;
  private final UnaryCallable<SetMinCpuPlatformInstanceRequest, Operation>
      setMinCpuPlatformCallable;
  private final OperationCallable<SetMinCpuPlatformInstanceRequest, Operation, Operation>
      setMinCpuPlatformOperationCallable;
  private final UnaryCallable<SetSchedulingInstanceRequest, Operation> setSchedulingCallable;
  private final OperationCallable<SetSchedulingInstanceRequest, Operation, Operation>
      setSchedulingOperationCallable;
  private final UnaryCallable<SetServiceAccountInstanceRequest, Operation>
      setServiceAccountCallable;
  private final OperationCallable<SetServiceAccountInstanceRequest, Operation, Operation>
      setServiceAccountOperationCallable;
  private final UnaryCallable<SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation>
      setShieldedInstanceIntegrityPolicyCallable;
  private final OperationCallable<
          SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation, Operation>
      setShieldedInstanceIntegrityPolicyOperationCallable;
  private final UnaryCallable<SetTagsInstanceRequest, Operation> setTagsCallable;
  private final OperationCallable<SetTagsInstanceRequest, Operation, Operation>
      setTagsOperationCallable;
  private final UnaryCallable<SimulateMaintenanceEventInstanceRequest, Operation>
      simulateMaintenanceEventCallable;
  private final OperationCallable<SimulateMaintenanceEventInstanceRequest, Operation, Operation>
      simulateMaintenanceEventOperationCallable;
  private final UnaryCallable<StartInstanceRequest, Operation> startCallable;
  private final OperationCallable<StartInstanceRequest, Operation, Operation>
      startOperationCallable;
  private final UnaryCallable<StartWithEncryptionKeyInstanceRequest, Operation>
      startWithEncryptionKeyCallable;
  private final OperationCallable<StartWithEncryptionKeyInstanceRequest, Operation, Operation>
      startWithEncryptionKeyOperationCallable;
  private final UnaryCallable<StopInstanceRequest, Operation> stopCallable;
  private final OperationCallable<StopInstanceRequest, Operation, Operation> stopOperationCallable;
  private final UnaryCallable<SuspendInstanceRequest, Operation> suspendCallable;
  private final OperationCallable<SuspendInstanceRequest, Operation, Operation>
      suspendOperationCallable;
  private final UnaryCallable<TestIamPermissionsInstanceRequest, TestPermissionsResponse>
      testIamPermissionsCallable;
  private final UnaryCallable<UpdateInstanceRequest, Operation> updateCallable;
  private final OperationCallable<UpdateInstanceRequest, Operation, Operation>
      updateOperationCallable;
  private final UnaryCallable<UpdateAccessConfigInstanceRequest, Operation>
      updateAccessConfigCallable;
  private final OperationCallable<UpdateAccessConfigInstanceRequest, Operation, Operation>
      updateAccessConfigOperationCallable;
  private final UnaryCallable<UpdateDisplayDeviceInstanceRequest, Operation>
      updateDisplayDeviceCallable;
  private final OperationCallable<UpdateDisplayDeviceInstanceRequest, Operation, Operation>
      updateDisplayDeviceOperationCallable;
  private final UnaryCallable<UpdateNetworkInterfaceInstanceRequest, Operation>
      updateNetworkInterfaceCallable;
  private final OperationCallable<UpdateNetworkInterfaceInstanceRequest, Operation, Operation>
      updateNetworkInterfaceOperationCallable;
  private final UnaryCallable<UpdateShieldedInstanceConfigInstanceRequest, Operation>
      updateShieldedInstanceConfigCallable;
  private final OperationCallable<UpdateShieldedInstanceConfigInstanceRequest, Operation, Operation>
      updateShieldedInstanceConfigOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonZoneOperationsStub httpJsonOperationsStub;
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
    this.httpJsonOperationsStub = HttpJsonZoneOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<AddAccessConfigInstanceRequest, Operation>
        addAccessConfigTransportSettings =
            HttpJsonCallSettings.<AddAccessConfigInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(addAccessConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AddResourcePoliciesInstanceRequest, Operation>
        addResourcePoliciesTransportSettings =
            HttpJsonCallSettings.<AddResourcePoliciesInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(addResourcePoliciesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AggregatedListInstancesRequest, InstanceAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListInstancesRequest, InstanceAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AttachDiskInstanceRequest, Operation> attachDiskTransportSettings =
        HttpJsonCallSettings.<AttachDiskInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(attachDiskMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<BulkInsertInstanceRequest, Operation> bulkInsertTransportSettings =
        HttpJsonCallSettings.<BulkInsertInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(bulkInsertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteInstanceRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteAccessConfigInstanceRequest, Operation>
        deleteAccessConfigTransportSettings =
            HttpJsonCallSettings.<DeleteAccessConfigInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteAccessConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DetachDiskInstanceRequest, Operation> detachDiskTransportSettings =
        HttpJsonCallSettings.<DetachDiskInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(detachDiskMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetInstanceRequest, Instance> getTransportSettings =
        HttpJsonCallSettings.<GetInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<
            GetEffectiveFirewallsInstanceRequest, InstancesGetEffectiveFirewallsResponse>
        getEffectiveFirewallsTransportSettings =
            HttpJsonCallSettings
                .<GetEffectiveFirewallsInstanceRequest, InstancesGetEffectiveFirewallsResponse>
                    newBuilder()
                .setMethodDescriptor(getEffectiveFirewallsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetGuestAttributesInstanceRequest, GuestAttributes>
        getGuestAttributesTransportSettings =
            HttpJsonCallSettings.<GetGuestAttributesInstanceRequest, GuestAttributes>newBuilder()
                .setMethodDescriptor(getGuestAttributesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetIamPolicyInstanceRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyInstanceRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetScreenshotInstanceRequest, Screenshot> getScreenshotTransportSettings =
        HttpJsonCallSettings.<GetScreenshotInstanceRequest, Screenshot>newBuilder()
            .setMethodDescriptor(getScreenshotMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetSerialPortOutputInstanceRequest, SerialPortOutput>
        getSerialPortOutputTransportSettings =
            HttpJsonCallSettings.<GetSerialPortOutputInstanceRequest, SerialPortOutput>newBuilder()
                .setMethodDescriptor(getSerialPortOutputMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetShieldedInstanceIdentityInstanceRequest, ShieldedInstanceIdentity>
        getShieldedInstanceIdentityTransportSettings =
            HttpJsonCallSettings
                .<GetShieldedInstanceIdentityInstanceRequest, ShieldedInstanceIdentity>newBuilder()
                .setMethodDescriptor(getShieldedInstanceIdentityMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<InsertInstanceRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListInstancesRequest, InstanceList> listTransportSettings =
        HttpJsonCallSettings.<ListInstancesRequest, InstanceList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListReferrersInstancesRequest, InstanceListReferrers>
        listReferrersTransportSettings =
            HttpJsonCallSettings.<ListReferrersInstancesRequest, InstanceListReferrers>newBuilder()
                .setMethodDescriptor(listReferrersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RemoveResourcePoliciesInstanceRequest, Operation>
        removeResourcePoliciesTransportSettings =
            HttpJsonCallSettings.<RemoveResourcePoliciesInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(removeResourcePoliciesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ResetInstanceRequest, Operation> resetTransportSettings =
        HttpJsonCallSettings.<ResetInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(resetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ResumeInstanceRequest, Operation> resumeTransportSettings =
        HttpJsonCallSettings.<ResumeInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(resumeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<
            SendDiagnosticInterruptInstanceRequest, SendDiagnosticInterruptInstanceResponse>
        sendDiagnosticInterruptTransportSettings =
            HttpJsonCallSettings
                .<SendDiagnosticInterruptInstanceRequest, SendDiagnosticInterruptInstanceResponse>
                    newBuilder()
                .setMethodDescriptor(sendDiagnosticInterruptMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetDeletionProtectionInstanceRequest, Operation>
        setDeletionProtectionTransportSettings =
            HttpJsonCallSettings.<SetDeletionProtectionInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(setDeletionProtectionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetDiskAutoDeleteInstanceRequest, Operation>
        setDiskAutoDeleteTransportSettings =
            HttpJsonCallSettings.<SetDiskAutoDeleteInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(setDiskAutoDeleteMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetIamPolicyInstanceRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyInstanceRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetLabelsInstanceRequest, Operation> setLabelsTransportSettings =
        HttpJsonCallSettings.<SetLabelsInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(setLabelsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetMachineResourcesInstanceRequest, Operation>
        setMachineResourcesTransportSettings =
            HttpJsonCallSettings.<SetMachineResourcesInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(setMachineResourcesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetMachineTypeInstanceRequest, Operation> setMachineTypeTransportSettings =
        HttpJsonCallSettings.<SetMachineTypeInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(setMachineTypeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetMetadataInstanceRequest, Operation> setMetadataTransportSettings =
        HttpJsonCallSettings.<SetMetadataInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(setMetadataMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetMinCpuPlatformInstanceRequest, Operation>
        setMinCpuPlatformTransportSettings =
            HttpJsonCallSettings.<SetMinCpuPlatformInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(setMinCpuPlatformMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetSchedulingInstanceRequest, Operation> setSchedulingTransportSettings =
        HttpJsonCallSettings.<SetSchedulingInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(setSchedulingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetServiceAccountInstanceRequest, Operation>
        setServiceAccountTransportSettings =
            HttpJsonCallSettings.<SetServiceAccountInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(setServiceAccountMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation>
        setShieldedInstanceIntegrityPolicyTransportSettings =
            HttpJsonCallSettings
                .<SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(setShieldedInstanceIntegrityPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetTagsInstanceRequest, Operation> setTagsTransportSettings =
        HttpJsonCallSettings.<SetTagsInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(setTagsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SimulateMaintenanceEventInstanceRequest, Operation>
        simulateMaintenanceEventTransportSettings =
            HttpJsonCallSettings.<SimulateMaintenanceEventInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(simulateMaintenanceEventMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<StartInstanceRequest, Operation> startTransportSettings =
        HttpJsonCallSettings.<StartInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(startMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<StartWithEncryptionKeyInstanceRequest, Operation>
        startWithEncryptionKeyTransportSettings =
            HttpJsonCallSettings.<StartWithEncryptionKeyInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(startWithEncryptionKeyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<StopInstanceRequest, Operation> stopTransportSettings =
        HttpJsonCallSettings.<StopInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(stopMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SuspendInstanceRequest, Operation> suspendTransportSettings =
        HttpJsonCallSettings.<SuspendInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(suspendMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<TestIamPermissionsInstanceRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsInstanceRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateInstanceRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<UpdateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateAccessConfigInstanceRequest, Operation>
        updateAccessConfigTransportSettings =
            HttpJsonCallSettings.<UpdateAccessConfigInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(updateAccessConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateDisplayDeviceInstanceRequest, Operation>
        updateDisplayDeviceTransportSettings =
            HttpJsonCallSettings.<UpdateDisplayDeviceInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(updateDisplayDeviceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateNetworkInterfaceInstanceRequest, Operation>
        updateNetworkInterfaceTransportSettings =
            HttpJsonCallSettings.<UpdateNetworkInterfaceInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(updateNetworkInterfaceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateShieldedInstanceConfigInstanceRequest, Operation>
        updateShieldedInstanceConfigTransportSettings =
            HttpJsonCallSettings
                .<UpdateShieldedInstanceConfigInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(updateShieldedInstanceConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.addAccessConfigCallable =
        callableFactory.createUnaryCallable(
            addAccessConfigTransportSettings, settings.addAccessConfigSettings(), clientContext);
    this.addAccessConfigOperationCallable =
        callableFactory.createOperationCallable(
            addAccessConfigTransportSettings,
            settings.addAccessConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.addResourcePoliciesCallable =
        callableFactory.createUnaryCallable(
            addResourcePoliciesTransportSettings,
            settings.addResourcePoliciesSettings(),
            clientContext);
    this.addResourcePoliciesOperationCallable =
        callableFactory.createOperationCallable(
            addResourcePoliciesTransportSettings,
            settings.addResourcePoliciesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.aggregatedListCallable =
        callableFactory.createUnaryCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.aggregatedListPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.attachDiskCallable =
        callableFactory.createUnaryCallable(
            attachDiskTransportSettings, settings.attachDiskSettings(), clientContext);
    this.attachDiskOperationCallable =
        callableFactory.createOperationCallable(
            attachDiskTransportSettings,
            settings.attachDiskOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.bulkInsertCallable =
        callableFactory.createUnaryCallable(
            bulkInsertTransportSettings, settings.bulkInsertSettings(), clientContext);
    this.bulkInsertOperationCallable =
        callableFactory.createOperationCallable(
            bulkInsertTransportSettings,
            settings.bulkInsertOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.deleteOperationCallable =
        callableFactory.createOperationCallable(
            deleteTransportSettings,
            settings.deleteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteAccessConfigCallable =
        callableFactory.createUnaryCallable(
            deleteAccessConfigTransportSettings,
            settings.deleteAccessConfigSettings(),
            clientContext);
    this.deleteAccessConfigOperationCallable =
        callableFactory.createOperationCallable(
            deleteAccessConfigTransportSettings,
            settings.deleteAccessConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.detachDiskCallable =
        callableFactory.createUnaryCallable(
            detachDiskTransportSettings, settings.detachDiskSettings(), clientContext);
    this.detachDiskOperationCallable =
        callableFactory.createOperationCallable(
            detachDiskTransportSettings,
            settings.detachDiskOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.getEffectiveFirewallsCallable =
        callableFactory.createUnaryCallable(
            getEffectiveFirewallsTransportSettings,
            settings.getEffectiveFirewallsSettings(),
            clientContext);
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
    this.insertOperationCallable =
        callableFactory.createOperationCallable(
            insertTransportSettings,
            settings.insertOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
    this.removeResourcePoliciesOperationCallable =
        callableFactory.createOperationCallable(
            removeResourcePoliciesTransportSettings,
            settings.removeResourcePoliciesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.resetCallable =
        callableFactory.createUnaryCallable(
            resetTransportSettings, settings.resetSettings(), clientContext);
    this.resetOperationCallable =
        callableFactory.createOperationCallable(
            resetTransportSettings,
            settings.resetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.resumeCallable =
        callableFactory.createUnaryCallable(
            resumeTransportSettings, settings.resumeSettings(), clientContext);
    this.resumeOperationCallable =
        callableFactory.createOperationCallable(
            resumeTransportSettings,
            settings.resumeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.sendDiagnosticInterruptCallable =
        callableFactory.createUnaryCallable(
            sendDiagnosticInterruptTransportSettings,
            settings.sendDiagnosticInterruptSettings(),
            clientContext);
    this.setDeletionProtectionCallable =
        callableFactory.createUnaryCallable(
            setDeletionProtectionTransportSettings,
            settings.setDeletionProtectionSettings(),
            clientContext);
    this.setDeletionProtectionOperationCallable =
        callableFactory.createOperationCallable(
            setDeletionProtectionTransportSettings,
            settings.setDeletionProtectionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setDiskAutoDeleteCallable =
        callableFactory.createUnaryCallable(
            setDiskAutoDeleteTransportSettings,
            settings.setDiskAutoDeleteSettings(),
            clientContext);
    this.setDiskAutoDeleteOperationCallable =
        callableFactory.createOperationCallable(
            setDiskAutoDeleteTransportSettings,
            settings.setDiskAutoDeleteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.setLabelsCallable =
        callableFactory.createUnaryCallable(
            setLabelsTransportSettings, settings.setLabelsSettings(), clientContext);
    this.setLabelsOperationCallable =
        callableFactory.createOperationCallable(
            setLabelsTransportSettings,
            settings.setLabelsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setMachineResourcesCallable =
        callableFactory.createUnaryCallable(
            setMachineResourcesTransportSettings,
            settings.setMachineResourcesSettings(),
            clientContext);
    this.setMachineResourcesOperationCallable =
        callableFactory.createOperationCallable(
            setMachineResourcesTransportSettings,
            settings.setMachineResourcesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setMachineTypeCallable =
        callableFactory.createUnaryCallable(
            setMachineTypeTransportSettings, settings.setMachineTypeSettings(), clientContext);
    this.setMachineTypeOperationCallable =
        callableFactory.createOperationCallable(
            setMachineTypeTransportSettings,
            settings.setMachineTypeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setMetadataCallable =
        callableFactory.createUnaryCallable(
            setMetadataTransportSettings, settings.setMetadataSettings(), clientContext);
    this.setMetadataOperationCallable =
        callableFactory.createOperationCallable(
            setMetadataTransportSettings,
            settings.setMetadataOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setMinCpuPlatformCallable =
        callableFactory.createUnaryCallable(
            setMinCpuPlatformTransportSettings,
            settings.setMinCpuPlatformSettings(),
            clientContext);
    this.setMinCpuPlatformOperationCallable =
        callableFactory.createOperationCallable(
            setMinCpuPlatformTransportSettings,
            settings.setMinCpuPlatformOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setSchedulingCallable =
        callableFactory.createUnaryCallable(
            setSchedulingTransportSettings, settings.setSchedulingSettings(), clientContext);
    this.setSchedulingOperationCallable =
        callableFactory.createOperationCallable(
            setSchedulingTransportSettings,
            settings.setSchedulingOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setServiceAccountCallable =
        callableFactory.createUnaryCallable(
            setServiceAccountTransportSettings,
            settings.setServiceAccountSettings(),
            clientContext);
    this.setServiceAccountOperationCallable =
        callableFactory.createOperationCallable(
            setServiceAccountTransportSettings,
            settings.setServiceAccountOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setShieldedInstanceIntegrityPolicyCallable =
        callableFactory.createUnaryCallable(
            setShieldedInstanceIntegrityPolicyTransportSettings,
            settings.setShieldedInstanceIntegrityPolicySettings(),
            clientContext);
    this.setShieldedInstanceIntegrityPolicyOperationCallable =
        callableFactory.createOperationCallable(
            setShieldedInstanceIntegrityPolicyTransportSettings,
            settings.setShieldedInstanceIntegrityPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setTagsCallable =
        callableFactory.createUnaryCallable(
            setTagsTransportSettings, settings.setTagsSettings(), clientContext);
    this.setTagsOperationCallable =
        callableFactory.createOperationCallable(
            setTagsTransportSettings,
            settings.setTagsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.simulateMaintenanceEventCallable =
        callableFactory.createUnaryCallable(
            simulateMaintenanceEventTransportSettings,
            settings.simulateMaintenanceEventSettings(),
            clientContext);
    this.simulateMaintenanceEventOperationCallable =
        callableFactory.createOperationCallable(
            simulateMaintenanceEventTransportSettings,
            settings.simulateMaintenanceEventOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.startCallable =
        callableFactory.createUnaryCallable(
            startTransportSettings, settings.startSettings(), clientContext);
    this.startOperationCallable =
        callableFactory.createOperationCallable(
            startTransportSettings,
            settings.startOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.startWithEncryptionKeyCallable =
        callableFactory.createUnaryCallable(
            startWithEncryptionKeyTransportSettings,
            settings.startWithEncryptionKeySettings(),
            clientContext);
    this.startWithEncryptionKeyOperationCallable =
        callableFactory.createOperationCallable(
            startWithEncryptionKeyTransportSettings,
            settings.startWithEncryptionKeyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.stopCallable =
        callableFactory.createUnaryCallable(
            stopTransportSettings, settings.stopSettings(), clientContext);
    this.stopOperationCallable =
        callableFactory.createOperationCallable(
            stopTransportSettings,
            settings.stopOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.suspendCallable =
        callableFactory.createUnaryCallable(
            suspendTransportSettings, settings.suspendSettings(), clientContext);
    this.suspendOperationCallable =
        callableFactory.createOperationCallable(
            suspendTransportSettings,
            settings.suspendOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);
    this.updateCallable =
        callableFactory.createUnaryCallable(
            updateTransportSettings, settings.updateSettings(), clientContext);
    this.updateOperationCallable =
        callableFactory.createOperationCallable(
            updateTransportSettings,
            settings.updateOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateAccessConfigCallable =
        callableFactory.createUnaryCallable(
            updateAccessConfigTransportSettings,
            settings.updateAccessConfigSettings(),
            clientContext);
    this.updateAccessConfigOperationCallable =
        callableFactory.createOperationCallable(
            updateAccessConfigTransportSettings,
            settings.updateAccessConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateDisplayDeviceCallable =
        callableFactory.createUnaryCallable(
            updateDisplayDeviceTransportSettings,
            settings.updateDisplayDeviceSettings(),
            clientContext);
    this.updateDisplayDeviceOperationCallable =
        callableFactory.createOperationCallable(
            updateDisplayDeviceTransportSettings,
            settings.updateDisplayDeviceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateNetworkInterfaceCallable =
        callableFactory.createUnaryCallable(
            updateNetworkInterfaceTransportSettings,
            settings.updateNetworkInterfaceSettings(),
            clientContext);
    this.updateNetworkInterfaceOperationCallable =
        callableFactory.createOperationCallable(
            updateNetworkInterfaceTransportSettings,
            settings.updateNetworkInterfaceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateShieldedInstanceConfigCallable =
        callableFactory.createUnaryCallable(
            updateShieldedInstanceConfigTransportSettings,
            settings.updateShieldedInstanceConfigSettings(),
            clientContext);
    this.updateShieldedInstanceConfigOperationCallable =
        callableFactory.createOperationCallable(
            updateShieldedInstanceConfigTransportSettings,
            settings.updateShieldedInstanceConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(addAccessConfigMethodDescriptor);
    methodDescriptors.add(addResourcePoliciesMethodDescriptor);
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(attachDiskMethodDescriptor);
    methodDescriptors.add(bulkInsertMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(deleteAccessConfigMethodDescriptor);
    methodDescriptors.add(detachDiskMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(getEffectiveFirewallsMethodDescriptor);
    methodDescriptors.add(getGuestAttributesMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(getScreenshotMethodDescriptor);
    methodDescriptors.add(getSerialPortOutputMethodDescriptor);
    methodDescriptors.add(getShieldedInstanceIdentityMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(listReferrersMethodDescriptor);
    methodDescriptors.add(removeResourcePoliciesMethodDescriptor);
    methodDescriptors.add(resetMethodDescriptor);
    methodDescriptors.add(resumeMethodDescriptor);
    methodDescriptors.add(sendDiagnosticInterruptMethodDescriptor);
    methodDescriptors.add(setDeletionProtectionMethodDescriptor);
    methodDescriptors.add(setDiskAutoDeleteMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(setLabelsMethodDescriptor);
    methodDescriptors.add(setMachineResourcesMethodDescriptor);
    methodDescriptors.add(setMachineTypeMethodDescriptor);
    methodDescriptors.add(setMetadataMethodDescriptor);
    methodDescriptors.add(setMinCpuPlatformMethodDescriptor);
    methodDescriptors.add(setSchedulingMethodDescriptor);
    methodDescriptors.add(setServiceAccountMethodDescriptor);
    methodDescriptors.add(setShieldedInstanceIntegrityPolicyMethodDescriptor);
    methodDescriptors.add(setTagsMethodDescriptor);
    methodDescriptors.add(simulateMaintenanceEventMethodDescriptor);
    methodDescriptors.add(startMethodDescriptor);
    methodDescriptors.add(startWithEncryptionKeyMethodDescriptor);
    methodDescriptors.add(stopMethodDescriptor);
    methodDescriptors.add(suspendMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    methodDescriptors.add(updateMethodDescriptor);
    methodDescriptors.add(updateAccessConfigMethodDescriptor);
    methodDescriptors.add(updateDisplayDeviceMethodDescriptor);
    methodDescriptors.add(updateNetworkInterfaceMethodDescriptor);
    methodDescriptors.add(updateShieldedInstanceConfigMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AddAccessConfigInstanceRequest, Operation> addAccessConfigCallable() {
    return addAccessConfigCallable;
  }

  @Override
  public OperationCallable<AddAccessConfigInstanceRequest, Operation, Operation>
      addAccessConfigOperationCallable() {
    return addAccessConfigOperationCallable;
  }

  @Override
  public UnaryCallable<AddResourcePoliciesInstanceRequest, Operation>
      addResourcePoliciesCallable() {
    return addResourcePoliciesCallable;
  }

  @Override
  public OperationCallable<AddResourcePoliciesInstanceRequest, Operation, Operation>
      addResourcePoliciesOperationCallable() {
    return addResourcePoliciesOperationCallable;
  }

  @Override
  public UnaryCallable<AggregatedListInstancesRequest, InstanceAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListInstancesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<AttachDiskInstanceRequest, Operation> attachDiskCallable() {
    return attachDiskCallable;
  }

  @Override
  public OperationCallable<AttachDiskInstanceRequest, Operation, Operation>
      attachDiskOperationCallable() {
    return attachDiskOperationCallable;
  }

  @Override
  public UnaryCallable<BulkInsertInstanceRequest, Operation> bulkInsertCallable() {
    return bulkInsertCallable;
  }

  @Override
  public OperationCallable<BulkInsertInstanceRequest, Operation, Operation>
      bulkInsertOperationCallable() {
    return bulkInsertOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInstanceRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteInstanceRequest, Operation, Operation> deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAccessConfigInstanceRequest, Operation> deleteAccessConfigCallable() {
    return deleteAccessConfigCallable;
  }

  @Override
  public OperationCallable<DeleteAccessConfigInstanceRequest, Operation, Operation>
      deleteAccessConfigOperationCallable() {
    return deleteAccessConfigOperationCallable;
  }

  @Override
  public UnaryCallable<DetachDiskInstanceRequest, Operation> detachDiskCallable() {
    return detachDiskCallable;
  }

  @Override
  public OperationCallable<DetachDiskInstanceRequest, Operation, Operation>
      detachDiskOperationCallable() {
    return detachDiskOperationCallable;
  }

  @Override
  public UnaryCallable<GetInstanceRequest, Instance> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetEffectiveFirewallsInstanceRequest, InstancesGetEffectiveFirewallsResponse>
      getEffectiveFirewallsCallable() {
    return getEffectiveFirewallsCallable;
  }

  @Override
  public UnaryCallable<GetGuestAttributesInstanceRequest, GuestAttributes>
      getGuestAttributesCallable() {
    return getGuestAttributesCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyInstanceRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetScreenshotInstanceRequest, Screenshot> getScreenshotCallable() {
    return getScreenshotCallable;
  }

  @Override
  public UnaryCallable<GetSerialPortOutputInstanceRequest, SerialPortOutput>
      getSerialPortOutputCallable() {
    return getSerialPortOutputCallable;
  }

  @Override
  public UnaryCallable<GetShieldedInstanceIdentityInstanceRequest, ShieldedInstanceIdentity>
      getShieldedInstanceIdentityCallable() {
    return getShieldedInstanceIdentityCallable;
  }

  @Override
  public UnaryCallable<InsertInstanceRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertInstanceRequest, Operation, Operation> insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, InstanceList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<ListReferrersInstancesRequest, InstanceListReferrers>
      listReferrersCallable() {
    return listReferrersCallable;
  }

  @Override
  public UnaryCallable<ListReferrersInstancesRequest, ListReferrersPagedResponse>
      listReferrersPagedCallable() {
    return listReferrersPagedCallable;
  }

  @Override
  public UnaryCallable<RemoveResourcePoliciesInstanceRequest, Operation>
      removeResourcePoliciesCallable() {
    return removeResourcePoliciesCallable;
  }

  @Override
  public OperationCallable<RemoveResourcePoliciesInstanceRequest, Operation, Operation>
      removeResourcePoliciesOperationCallable() {
    return removeResourcePoliciesOperationCallable;
  }

  @Override
  public UnaryCallable<ResetInstanceRequest, Operation> resetCallable() {
    return resetCallable;
  }

  @Override
  public OperationCallable<ResetInstanceRequest, Operation, Operation> resetOperationCallable() {
    return resetOperationCallable;
  }

  @Override
  public UnaryCallable<ResumeInstanceRequest, Operation> resumeCallable() {
    return resumeCallable;
  }

  @Override
  public OperationCallable<ResumeInstanceRequest, Operation, Operation> resumeOperationCallable() {
    return resumeOperationCallable;
  }

  @Override
  public UnaryCallable<
          SendDiagnosticInterruptInstanceRequest, SendDiagnosticInterruptInstanceResponse>
      sendDiagnosticInterruptCallable() {
    return sendDiagnosticInterruptCallable;
  }

  @Override
  public UnaryCallable<SetDeletionProtectionInstanceRequest, Operation>
      setDeletionProtectionCallable() {
    return setDeletionProtectionCallable;
  }

  @Override
  public OperationCallable<SetDeletionProtectionInstanceRequest, Operation, Operation>
      setDeletionProtectionOperationCallable() {
    return setDeletionProtectionOperationCallable;
  }

  @Override
  public UnaryCallable<SetDiskAutoDeleteInstanceRequest, Operation> setDiskAutoDeleteCallable() {
    return setDiskAutoDeleteCallable;
  }

  @Override
  public OperationCallable<SetDiskAutoDeleteInstanceRequest, Operation, Operation>
      setDiskAutoDeleteOperationCallable() {
    return setDiskAutoDeleteOperationCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyInstanceRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetLabelsInstanceRequest, Operation> setLabelsCallable() {
    return setLabelsCallable;
  }

  @Override
  public OperationCallable<SetLabelsInstanceRequest, Operation, Operation>
      setLabelsOperationCallable() {
    return setLabelsOperationCallable;
  }

  @Override
  public UnaryCallable<SetMachineResourcesInstanceRequest, Operation>
      setMachineResourcesCallable() {
    return setMachineResourcesCallable;
  }

  @Override
  public OperationCallable<SetMachineResourcesInstanceRequest, Operation, Operation>
      setMachineResourcesOperationCallable() {
    return setMachineResourcesOperationCallable;
  }

  @Override
  public UnaryCallable<SetMachineTypeInstanceRequest, Operation> setMachineTypeCallable() {
    return setMachineTypeCallable;
  }

  @Override
  public OperationCallable<SetMachineTypeInstanceRequest, Operation, Operation>
      setMachineTypeOperationCallable() {
    return setMachineTypeOperationCallable;
  }

  @Override
  public UnaryCallable<SetMetadataInstanceRequest, Operation> setMetadataCallable() {
    return setMetadataCallable;
  }

  @Override
  public OperationCallable<SetMetadataInstanceRequest, Operation, Operation>
      setMetadataOperationCallable() {
    return setMetadataOperationCallable;
  }

  @Override
  public UnaryCallable<SetMinCpuPlatformInstanceRequest, Operation> setMinCpuPlatformCallable() {
    return setMinCpuPlatformCallable;
  }

  @Override
  public OperationCallable<SetMinCpuPlatformInstanceRequest, Operation, Operation>
      setMinCpuPlatformOperationCallable() {
    return setMinCpuPlatformOperationCallable;
  }

  @Override
  public UnaryCallable<SetSchedulingInstanceRequest, Operation> setSchedulingCallable() {
    return setSchedulingCallable;
  }

  @Override
  public OperationCallable<SetSchedulingInstanceRequest, Operation, Operation>
      setSchedulingOperationCallable() {
    return setSchedulingOperationCallable;
  }

  @Override
  public UnaryCallable<SetServiceAccountInstanceRequest, Operation> setServiceAccountCallable() {
    return setServiceAccountCallable;
  }

  @Override
  public OperationCallable<SetServiceAccountInstanceRequest, Operation, Operation>
      setServiceAccountOperationCallable() {
    return setServiceAccountOperationCallable;
  }

  @Override
  public UnaryCallable<SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation>
      setShieldedInstanceIntegrityPolicyCallable() {
    return setShieldedInstanceIntegrityPolicyCallable;
  }

  @Override
  public OperationCallable<SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation, Operation>
      setShieldedInstanceIntegrityPolicyOperationCallable() {
    return setShieldedInstanceIntegrityPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<SetTagsInstanceRequest, Operation> setTagsCallable() {
    return setTagsCallable;
  }

  @Override
  public OperationCallable<SetTagsInstanceRequest, Operation, Operation>
      setTagsOperationCallable() {
    return setTagsOperationCallable;
  }

  @Override
  public UnaryCallable<SimulateMaintenanceEventInstanceRequest, Operation>
      simulateMaintenanceEventCallable() {
    return simulateMaintenanceEventCallable;
  }

  @Override
  public OperationCallable<SimulateMaintenanceEventInstanceRequest, Operation, Operation>
      simulateMaintenanceEventOperationCallable() {
    return simulateMaintenanceEventOperationCallable;
  }

  @Override
  public UnaryCallable<StartInstanceRequest, Operation> startCallable() {
    return startCallable;
  }

  @Override
  public OperationCallable<StartInstanceRequest, Operation, Operation> startOperationCallable() {
    return startOperationCallable;
  }

  @Override
  public UnaryCallable<StartWithEncryptionKeyInstanceRequest, Operation>
      startWithEncryptionKeyCallable() {
    return startWithEncryptionKeyCallable;
  }

  @Override
  public OperationCallable<StartWithEncryptionKeyInstanceRequest, Operation, Operation>
      startWithEncryptionKeyOperationCallable() {
    return startWithEncryptionKeyOperationCallable;
  }

  @Override
  public UnaryCallable<StopInstanceRequest, Operation> stopCallable() {
    return stopCallable;
  }

  @Override
  public OperationCallable<StopInstanceRequest, Operation, Operation> stopOperationCallable() {
    return stopOperationCallable;
  }

  @Override
  public UnaryCallable<SuspendInstanceRequest, Operation> suspendCallable() {
    return suspendCallable;
  }

  @Override
  public OperationCallable<SuspendInstanceRequest, Operation, Operation>
      suspendOperationCallable() {
    return suspendOperationCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsInstanceRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public UnaryCallable<UpdateInstanceRequest, Operation> updateCallable() {
    return updateCallable;
  }

  @Override
  public OperationCallable<UpdateInstanceRequest, Operation, Operation> updateOperationCallable() {
    return updateOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAccessConfigInstanceRequest, Operation> updateAccessConfigCallable() {
    return updateAccessConfigCallable;
  }

  @Override
  public OperationCallable<UpdateAccessConfigInstanceRequest, Operation, Operation>
      updateAccessConfigOperationCallable() {
    return updateAccessConfigOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDisplayDeviceInstanceRequest, Operation>
      updateDisplayDeviceCallable() {
    return updateDisplayDeviceCallable;
  }

  @Override
  public OperationCallable<UpdateDisplayDeviceInstanceRequest, Operation, Operation>
      updateDisplayDeviceOperationCallable() {
    return updateDisplayDeviceOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateNetworkInterfaceInstanceRequest, Operation>
      updateNetworkInterfaceCallable() {
    return updateNetworkInterfaceCallable;
  }

  @Override
  public OperationCallable<UpdateNetworkInterfaceInstanceRequest, Operation, Operation>
      updateNetworkInterfaceOperationCallable() {
    return updateNetworkInterfaceOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateShieldedInstanceConfigInstanceRequest, Operation>
      updateShieldedInstanceConfigCallable() {
    return updateShieldedInstanceConfigCallable;
  }

  @Override
  public OperationCallable<UpdateShieldedInstanceConfigInstanceRequest, Operation, Operation>
      updateShieldedInstanceConfigOperationCallable() {
    return updateShieldedInstanceConfigOperationCallable;
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
