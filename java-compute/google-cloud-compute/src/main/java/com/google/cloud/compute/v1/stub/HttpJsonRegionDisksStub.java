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

import static com.google.cloud.compute.v1.RegionDisksClient.ListPagedResponse;

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
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddResourcePoliciesRegionDiskRequest;
import com.google.cloud.compute.v1.CreateSnapshotRegionDiskRequest;
import com.google.cloud.compute.v1.DeleteRegionDiskRequest;
import com.google.cloud.compute.v1.Disk;
import com.google.cloud.compute.v1.DiskList;
import com.google.cloud.compute.v1.GetIamPolicyRegionDiskRequest;
import com.google.cloud.compute.v1.GetRegionDiskRequest;
import com.google.cloud.compute.v1.InsertRegionDiskRequest;
import com.google.cloud.compute.v1.ListRegionDisksRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.RemoveResourcePoliciesRegionDiskRequest;
import com.google.cloud.compute.v1.ResizeRegionDiskRequest;
import com.google.cloud.compute.v1.SetIamPolicyRegionDiskRequest;
import com.google.cloud.compute.v1.SetLabelsRegionDiskRequest;
import com.google.cloud.compute.v1.TestIamPermissionsRegionDiskRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
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
 * REST stub implementation for the RegionDisks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonRegionDisksStub extends RegionDisksStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<AddResourcePoliciesRegionDiskRequest, Operation>
      addResourcePoliciesMethodDescriptor =
          ApiMethodDescriptor.<AddResourcePoliciesRegionDiskRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks/AddResourcePolicies")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddResourcePoliciesRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks/{disk}/addResourcePolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddResourcePoliciesRegionDiskRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "disk", request.getDisk());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddResourcePoliciesRegionDiskRequest> serializer =
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
                                      "regionDisksAddResourcePoliciesRequestResource",
                                      request.getRegionDisksAddResourcePoliciesRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AddResourcePoliciesRegionDiskRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<CreateSnapshotRegionDiskRequest, Operation>
      createSnapshotMethodDescriptor =
          ApiMethodDescriptor.<CreateSnapshotRegionDiskRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks/CreateSnapshot")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSnapshotRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks/{disk}/createSnapshot",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSnapshotRegionDiskRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "disk", request.getDisk());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSnapshotRegionDiskRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("snapshotResource", request.getSnapshotResource(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateSnapshotRegionDiskRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<DeleteRegionDiskRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionDiskRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks/{disk}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegionDiskRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "disk", request.getDisk());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegionDiskRequest> serializer =
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
                  (DeleteRegionDiskRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<GetRegionDiskRequest, Disk> getMethodDescriptor =
      ApiMethodDescriptor.<GetRegionDiskRequest, Disk>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.RegionDisks/Get")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetRegionDiskRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/disks/{disk}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetRegionDiskRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "disk", request.getDisk());
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "region", request.getRegion());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetRegionDiskRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Disk>newBuilder()
                  .setDefaultInstance(Disk.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetIamPolicyRegionDiskRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRegionDiskRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks/{resource}/getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRegionDiskRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRegionDiskRequest> serializer =
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

  private static final ApiMethodDescriptor<InsertRegionDiskRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionDiskRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertRegionDiskRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertRegionDiskRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            if (request.hasSourceImage()) {
                              serializer.putQueryParam(
                                  fields, "sourceImage", request.getSourceImage());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("diskResource", request.getDiskResource(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertRegionDiskRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<ListRegionDisksRequest, DiskList> listMethodDescriptor =
      ApiMethodDescriptor.<ListRegionDisksRequest, DiskList>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.RegionDisks/List")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<ListRegionDisksRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/disks",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<ListRegionDisksRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "region", request.getRegion());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<ListRegionDisksRequest> serializer =
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
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<DiskList>newBuilder()
                  .setDefaultInstance(DiskList.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<RemoveResourcePoliciesRegionDiskRequest, Operation>
      removeResourcePoliciesMethodDescriptor =
          ApiMethodDescriptor.<RemoveResourcePoliciesRegionDiskRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks/RemoveResourcePolicies")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveResourcePoliciesRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks/{disk}/removeResourcePolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveResourcePoliciesRegionDiskRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "disk", request.getDisk());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveResourcePoliciesRegionDiskRequest>
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
                                      "regionDisksRemoveResourcePoliciesRequestResource",
                                      request.getRegionDisksRemoveResourcePoliciesRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RemoveResourcePoliciesRegionDiskRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<ResizeRegionDiskRequest, Operation>
      resizeMethodDescriptor =
          ApiMethodDescriptor.<ResizeRegionDiskRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks/Resize")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResizeRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks/{disk}/resize",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ResizeRegionDiskRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "disk", request.getDisk());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ResizeRegionDiskRequest> serializer =
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
                                      "regionDisksResizeRequestResource",
                                      request.getRegionDisksResizeRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ResizeRegionDiskRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyRegionDiskRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRegionDiskRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks/{resource}/setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRegionDiskRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRegionDiskRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "regionSetPolicyRequestResource",
                                      request.getRegionSetPolicyRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetLabelsRegionDiskRequest, Operation>
      setLabelsMethodDescriptor =
          ApiMethodDescriptor.<SetLabelsRegionDiskRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks/SetLabels")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetLabelsRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks/{resource}/setLabels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetLabelsRegionDiskRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetLabelsRegionDiskRequest> serializer =
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
                                      "regionSetLabelsRequestResource",
                                      request.getRegionSetLabelsRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetLabelsRegionDiskRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
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
          TestIamPermissionsRegionDiskRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsRegionDiskRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks/{resource}/testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRegionDiskRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRegionDiskRequest> serializer =
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

  private final UnaryCallable<AddResourcePoliciesRegionDiskRequest, Operation>
      addResourcePoliciesCallable;
  private final OperationCallable<AddResourcePoliciesRegionDiskRequest, Operation, Operation>
      addResourcePoliciesOperationCallable;
  private final UnaryCallable<CreateSnapshotRegionDiskRequest, Operation> createSnapshotCallable;
  private final OperationCallable<CreateSnapshotRegionDiskRequest, Operation, Operation>
      createSnapshotOperationCallable;
  private final UnaryCallable<DeleteRegionDiskRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteRegionDiskRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetRegionDiskRequest, Disk> getCallable;
  private final UnaryCallable<GetIamPolicyRegionDiskRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<InsertRegionDiskRequest, Operation> insertCallable;
  private final OperationCallable<InsertRegionDiskRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListRegionDisksRequest, DiskList> listCallable;
  private final UnaryCallable<ListRegionDisksRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<RemoveResourcePoliciesRegionDiskRequest, Operation>
      removeResourcePoliciesCallable;
  private final OperationCallable<RemoveResourcePoliciesRegionDiskRequest, Operation, Operation>
      removeResourcePoliciesOperationCallable;
  private final UnaryCallable<ResizeRegionDiskRequest, Operation> resizeCallable;
  private final OperationCallable<ResizeRegionDiskRequest, Operation, Operation>
      resizeOperationCallable;
  private final UnaryCallable<SetIamPolicyRegionDiskRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<SetLabelsRegionDiskRequest, Operation> setLabelsCallable;
  private final OperationCallable<SetLabelsRegionDiskRequest, Operation, Operation>
      setLabelsOperationCallable;
  private final UnaryCallable<TestIamPermissionsRegionDiskRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonRegionOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionDisksStub create(RegionDisksStubSettings settings)
      throws IOException {
    return new HttpJsonRegionDisksStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionDisksStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionDisksStub(RegionDisksStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionDisksStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionDisksStub(
        RegionDisksStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionDisksStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRegionDisksStub(RegionDisksStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRegionDisksCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionDisksStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRegionDisksStub(
      RegionDisksStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonRegionOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<AddResourcePoliciesRegionDiskRequest, Operation>
        addResourcePoliciesTransportSettings =
            HttpJsonCallSettings.<AddResourcePoliciesRegionDiskRequest, Operation>newBuilder()
                .setMethodDescriptor(addResourcePoliciesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateSnapshotRegionDiskRequest, Operation>
        createSnapshotTransportSettings =
            HttpJsonCallSettings.<CreateSnapshotRegionDiskRequest, Operation>newBuilder()
                .setMethodDescriptor(createSnapshotMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteRegionDiskRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteRegionDiskRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetRegionDiskRequest, Disk> getTransportSettings =
        HttpJsonCallSettings.<GetRegionDiskRequest, Disk>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetIamPolicyRegionDiskRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRegionDiskRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<InsertRegionDiskRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertRegionDiskRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListRegionDisksRequest, DiskList> listTransportSettings =
        HttpJsonCallSettings.<ListRegionDisksRequest, DiskList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RemoveResourcePoliciesRegionDiskRequest, Operation>
        removeResourcePoliciesTransportSettings =
            HttpJsonCallSettings.<RemoveResourcePoliciesRegionDiskRequest, Operation>newBuilder()
                .setMethodDescriptor(removeResourcePoliciesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ResizeRegionDiskRequest, Operation> resizeTransportSettings =
        HttpJsonCallSettings.<ResizeRegionDiskRequest, Operation>newBuilder()
            .setMethodDescriptor(resizeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetIamPolicyRegionDiskRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRegionDiskRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetLabelsRegionDiskRequest, Operation> setLabelsTransportSettings =
        HttpJsonCallSettings.<SetLabelsRegionDiskRequest, Operation>newBuilder()
            .setMethodDescriptor(setLabelsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<TestIamPermissionsRegionDiskRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsRegionDiskRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

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
    this.createSnapshotCallable =
        callableFactory.createUnaryCallable(
            createSnapshotTransportSettings, settings.createSnapshotSettings(), clientContext);
    this.createSnapshotOperationCallable =
        callableFactory.createOperationCallable(
            createSnapshotTransportSettings,
            settings.createSnapshotOperationSettings(),
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
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
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
    this.resizeCallable =
        callableFactory.createUnaryCallable(
            resizeTransportSettings, settings.resizeSettings(), clientContext);
    this.resizeOperationCallable =
        callableFactory.createOperationCallable(
            resizeTransportSettings,
            settings.resizeOperationSettings(),
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
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(addResourcePoliciesMethodDescriptor);
    methodDescriptors.add(createSnapshotMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(removeResourcePoliciesMethodDescriptor);
    methodDescriptors.add(resizeMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(setLabelsMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AddResourcePoliciesRegionDiskRequest, Operation>
      addResourcePoliciesCallable() {
    return addResourcePoliciesCallable;
  }

  @Override
  public OperationCallable<AddResourcePoliciesRegionDiskRequest, Operation, Operation>
      addResourcePoliciesOperationCallable() {
    return addResourcePoliciesOperationCallable;
  }

  @Override
  public UnaryCallable<CreateSnapshotRegionDiskRequest, Operation> createSnapshotCallable() {
    return createSnapshotCallable;
  }

  @Override
  public OperationCallable<CreateSnapshotRegionDiskRequest, Operation, Operation>
      createSnapshotOperationCallable() {
    return createSnapshotOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteRegionDiskRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteRegionDiskRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetRegionDiskRequest, Disk> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRegionDiskRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<InsertRegionDiskRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertRegionDiskRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListRegionDisksRequest, DiskList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListRegionDisksRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<RemoveResourcePoliciesRegionDiskRequest, Operation>
      removeResourcePoliciesCallable() {
    return removeResourcePoliciesCallable;
  }

  @Override
  public OperationCallable<RemoveResourcePoliciesRegionDiskRequest, Operation, Operation>
      removeResourcePoliciesOperationCallable() {
    return removeResourcePoliciesOperationCallable;
  }

  @Override
  public UnaryCallable<ResizeRegionDiskRequest, Operation> resizeCallable() {
    return resizeCallable;
  }

  @Override
  public OperationCallable<ResizeRegionDiskRequest, Operation, Operation>
      resizeOperationCallable() {
    return resizeOperationCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRegionDiskRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetLabelsRegionDiskRequest, Operation> setLabelsCallable() {
    return setLabelsCallable;
  }

  @Override
  public OperationCallable<SetLabelsRegionDiskRequest, Operation, Operation>
      setLabelsOperationCallable() {
    return setLabelsOperationCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRegionDiskRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
