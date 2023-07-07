/*
 * Copyright 2023 Google LLC
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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddResourcePoliciesRegionDiskRequest;
import com.google.cloud.compute.v1.BulkInsertRegionDiskRequest;
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
import com.google.cloud.compute.v1.StartAsyncReplicationRegionDiskRequest;
import com.google.cloud.compute.v1.StopAsyncReplicationRegionDiskRequest;
import com.google.cloud.compute.v1.StopGroupAsyncReplicationRegionDiskRequest;
import com.google.cloud.compute.v1.TestIamPermissionsRegionDiskRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.cloud.compute.v1.UpdateRegionDiskRequest;
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

  private static final ApiMethodDescriptor<BulkInsertRegionDiskRequest, Operation>
      bulkInsertMethodDescriptor =
          ApiMethodDescriptor.<BulkInsertRegionDiskRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks/BulkInsert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BulkInsertRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks/bulkInsert",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BulkInsertRegionDiskRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BulkInsertRegionDiskRequest> serializer =
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
                                      "bulkInsertDiskResourceResource",
                                      request.getBulkInsertDiskResourceResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (BulkInsertRegionDiskRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<StartAsyncReplicationRegionDiskRequest, Operation>
      startAsyncReplicationMethodDescriptor =
          ApiMethodDescriptor.<StartAsyncReplicationRegionDiskRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks/StartAsyncReplication")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StartAsyncReplicationRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks/{disk}/startAsyncReplication",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StartAsyncReplicationRegionDiskRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "disk", request.getDisk());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StartAsyncReplicationRegionDiskRequest> serializer =
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
                                      "regionDisksStartAsyncReplicationRequestResource",
                                      request.getRegionDisksStartAsyncReplicationRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (StartAsyncReplicationRegionDiskRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<StopAsyncReplicationRegionDiskRequest, Operation>
      stopAsyncReplicationMethodDescriptor =
          ApiMethodDescriptor.<StopAsyncReplicationRegionDiskRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks/StopAsyncReplication")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StopAsyncReplicationRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks/{disk}/stopAsyncReplication",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StopAsyncReplicationRegionDiskRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "disk", request.getDisk());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StopAsyncReplicationRegionDiskRequest> serializer =
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
                  (StopAsyncReplicationRegionDiskRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<StopGroupAsyncReplicationRegionDiskRequest, Operation>
      stopGroupAsyncReplicationMethodDescriptor =
          ApiMethodDescriptor.<StopGroupAsyncReplicationRegionDiskRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks/StopGroupAsyncReplication")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<StopGroupAsyncReplicationRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks/stopGroupAsyncReplication",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StopGroupAsyncReplicationRegionDiskRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StopGroupAsyncReplicationRegionDiskRequest>
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
                                      "disksStopGroupAsyncReplicationResourceResource",
                                      request.getDisksStopGroupAsyncReplicationResourceResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (StopGroupAsyncReplicationRegionDiskRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<UpdateRegionDiskRequest, Operation>
      updateMethodDescriptor =
          ApiMethodDescriptor.<UpdateRegionDiskRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks/Update")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks/{disk}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRegionDiskRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "disk", request.getDisk());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRegionDiskRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasPaths()) {
                              serializer.putQueryParam(fields, "paths", request.getPaths());
                            }
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            if (request.hasUpdateMask()) {
                              serializer.putQueryParam(
                                  fields, "updateMask", request.getUpdateMask());
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
                  (UpdateRegionDiskRequest request, Operation response) -> {
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

  private final UnaryCallable<AddResourcePoliciesRegionDiskRequest, Operation>
      addResourcePoliciesCallable;
  private final OperationCallable<AddResourcePoliciesRegionDiskRequest, Operation, Operation>
      addResourcePoliciesOperationCallable;
  private final UnaryCallable<BulkInsertRegionDiskRequest, Operation> bulkInsertCallable;
  private final OperationCallable<BulkInsertRegionDiskRequest, Operation, Operation>
      bulkInsertOperationCallable;
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
  private final UnaryCallable<StartAsyncReplicationRegionDiskRequest, Operation>
      startAsyncReplicationCallable;
  private final OperationCallable<StartAsyncReplicationRegionDiskRequest, Operation, Operation>
      startAsyncReplicationOperationCallable;
  private final UnaryCallable<StopAsyncReplicationRegionDiskRequest, Operation>
      stopAsyncReplicationCallable;
  private final OperationCallable<StopAsyncReplicationRegionDiskRequest, Operation, Operation>
      stopAsyncReplicationOperationCallable;
  private final UnaryCallable<StopGroupAsyncReplicationRegionDiskRequest, Operation>
      stopGroupAsyncReplicationCallable;
  private final OperationCallable<StopGroupAsyncReplicationRegionDiskRequest, Operation, Operation>
      stopGroupAsyncReplicationOperationCallable;
  private final UnaryCallable<TestIamPermissionsRegionDiskRequest, TestPermissionsResponse>
      testIamPermissionsCallable;
  private final UnaryCallable<UpdateRegionDiskRequest, Operation> updateCallable;
  private final OperationCallable<UpdateRegionDiskRequest, Operation, Operation>
      updateOperationCallable;

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
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("disk", String.valueOf(request.getDisk()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BulkInsertRegionDiskRequest, Operation> bulkInsertTransportSettings =
        HttpJsonCallSettings.<BulkInsertRegionDiskRequest, Operation>newBuilder()
            .setMethodDescriptor(bulkInsertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("region", String.valueOf(request.getRegion()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateSnapshotRegionDiskRequest, Operation>
        createSnapshotTransportSettings =
            HttpJsonCallSettings.<CreateSnapshotRegionDiskRequest, Operation>newBuilder()
                .setMethodDescriptor(createSnapshotMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("disk", String.valueOf(request.getDisk()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteRegionDiskRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteRegionDiskRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("disk", String.valueOf(request.getDisk()));
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("region", String.valueOf(request.getRegion()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetRegionDiskRequest, Disk> getTransportSettings =
        HttpJsonCallSettings.<GetRegionDiskRequest, Disk>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("disk", String.valueOf(request.getDisk()));
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("region", String.valueOf(request.getRegion()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetIamPolicyRegionDiskRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRegionDiskRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("region", String.valueOf(request.getRegion()));
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<InsertRegionDiskRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertRegionDiskRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("region", String.valueOf(request.getRegion()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListRegionDisksRequest, DiskList> listTransportSettings =
        HttpJsonCallSettings.<ListRegionDisksRequest, DiskList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("region", String.valueOf(request.getRegion()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RemoveResourcePoliciesRegionDiskRequest, Operation>
        removeResourcePoliciesTransportSettings =
            HttpJsonCallSettings.<RemoveResourcePoliciesRegionDiskRequest, Operation>newBuilder()
                .setMethodDescriptor(removeResourcePoliciesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("disk", String.valueOf(request.getDisk()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ResizeRegionDiskRequest, Operation> resizeTransportSettings =
        HttpJsonCallSettings.<ResizeRegionDiskRequest, Operation>newBuilder()
            .setMethodDescriptor(resizeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("disk", String.valueOf(request.getDisk()));
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("region", String.valueOf(request.getRegion()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SetIamPolicyRegionDiskRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRegionDiskRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("region", String.valueOf(request.getRegion()));
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SetLabelsRegionDiskRequest, Operation> setLabelsTransportSettings =
        HttpJsonCallSettings.<SetLabelsRegionDiskRequest, Operation>newBuilder()
            .setMethodDescriptor(setLabelsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("region", String.valueOf(request.getRegion()));
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<StartAsyncReplicationRegionDiskRequest, Operation>
        startAsyncReplicationTransportSettings =
            HttpJsonCallSettings.<StartAsyncReplicationRegionDiskRequest, Operation>newBuilder()
                .setMethodDescriptor(startAsyncReplicationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("disk", String.valueOf(request.getDisk()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<StopAsyncReplicationRegionDiskRequest, Operation>
        stopAsyncReplicationTransportSettings =
            HttpJsonCallSettings.<StopAsyncReplicationRegionDiskRequest, Operation>newBuilder()
                .setMethodDescriptor(stopAsyncReplicationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("disk", String.valueOf(request.getDisk()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<StopGroupAsyncReplicationRegionDiskRequest, Operation>
        stopGroupAsyncReplicationTransportSettings =
            HttpJsonCallSettings.<StopGroupAsyncReplicationRegionDiskRequest, Operation>newBuilder()
                .setMethodDescriptor(stopGroupAsyncReplicationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<TestIamPermissionsRegionDiskRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsRegionDiskRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateRegionDiskRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<UpdateRegionDiskRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("disk", String.valueOf(request.getDisk()));
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("region", String.valueOf(request.getRegion()));
                  return builder.build();
                })
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
    this.bulkInsertCallable =
        callableFactory.createUnaryCallable(
            bulkInsertTransportSettings, settings.bulkInsertSettings(), clientContext);
    this.bulkInsertOperationCallable =
        callableFactory.createOperationCallable(
            bulkInsertTransportSettings,
            settings.bulkInsertOperationSettings(),
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
    this.startAsyncReplicationCallable =
        callableFactory.createUnaryCallable(
            startAsyncReplicationTransportSettings,
            settings.startAsyncReplicationSettings(),
            clientContext);
    this.startAsyncReplicationOperationCallable =
        callableFactory.createOperationCallable(
            startAsyncReplicationTransportSettings,
            settings.startAsyncReplicationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.stopAsyncReplicationCallable =
        callableFactory.createUnaryCallable(
            stopAsyncReplicationTransportSettings,
            settings.stopAsyncReplicationSettings(),
            clientContext);
    this.stopAsyncReplicationOperationCallable =
        callableFactory.createOperationCallable(
            stopAsyncReplicationTransportSettings,
            settings.stopAsyncReplicationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.stopGroupAsyncReplicationCallable =
        callableFactory.createUnaryCallable(
            stopGroupAsyncReplicationTransportSettings,
            settings.stopGroupAsyncReplicationSettings(),
            clientContext);
    this.stopGroupAsyncReplicationOperationCallable =
        callableFactory.createOperationCallable(
            stopGroupAsyncReplicationTransportSettings,
            settings.stopGroupAsyncReplicationOperationSettings(),
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(addResourcePoliciesMethodDescriptor);
    methodDescriptors.add(bulkInsertMethodDescriptor);
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
    methodDescriptors.add(startAsyncReplicationMethodDescriptor);
    methodDescriptors.add(stopAsyncReplicationMethodDescriptor);
    methodDescriptors.add(stopGroupAsyncReplicationMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    methodDescriptors.add(updateMethodDescriptor);
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
  public UnaryCallable<BulkInsertRegionDiskRequest, Operation> bulkInsertCallable() {
    return bulkInsertCallable;
  }

  @Override
  public OperationCallable<BulkInsertRegionDiskRequest, Operation, Operation>
      bulkInsertOperationCallable() {
    return bulkInsertOperationCallable;
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
  public UnaryCallable<StartAsyncReplicationRegionDiskRequest, Operation>
      startAsyncReplicationCallable() {
    return startAsyncReplicationCallable;
  }

  @Override
  public OperationCallable<StartAsyncReplicationRegionDiskRequest, Operation, Operation>
      startAsyncReplicationOperationCallable() {
    return startAsyncReplicationOperationCallable;
  }

  @Override
  public UnaryCallable<StopAsyncReplicationRegionDiskRequest, Operation>
      stopAsyncReplicationCallable() {
    return stopAsyncReplicationCallable;
  }

  @Override
  public OperationCallable<StopAsyncReplicationRegionDiskRequest, Operation, Operation>
      stopAsyncReplicationOperationCallable() {
    return stopAsyncReplicationOperationCallable;
  }

  @Override
  public UnaryCallable<StopGroupAsyncReplicationRegionDiskRequest, Operation>
      stopGroupAsyncReplicationCallable() {
    return stopGroupAsyncReplicationCallable;
  }

  @Override
  public OperationCallable<StopGroupAsyncReplicationRegionDiskRequest, Operation, Operation>
      stopGroupAsyncReplicationOperationCallable() {
    return stopGroupAsyncReplicationOperationCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRegionDiskRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public UnaryCallable<UpdateRegionDiskRequest, Operation> updateCallable() {
    return updateCallable;
  }

  @Override
  public OperationCallable<UpdateRegionDiskRequest, Operation, Operation>
      updateOperationCallable() {
    return updateOperationCallable;
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
