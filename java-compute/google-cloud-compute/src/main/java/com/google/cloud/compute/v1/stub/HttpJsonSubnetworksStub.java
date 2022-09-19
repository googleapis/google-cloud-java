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

import static com.google.cloud.compute.v1.SubnetworksClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.SubnetworksClient.ListPagedResponse;
import static com.google.cloud.compute.v1.SubnetworksClient.ListUsablePagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListSubnetworksRequest;
import com.google.cloud.compute.v1.DeleteSubnetworkRequest;
import com.google.cloud.compute.v1.ExpandIpCidrRangeSubnetworkRequest;
import com.google.cloud.compute.v1.GetIamPolicySubnetworkRequest;
import com.google.cloud.compute.v1.GetSubnetworkRequest;
import com.google.cloud.compute.v1.InsertSubnetworkRequest;
import com.google.cloud.compute.v1.ListSubnetworksRequest;
import com.google.cloud.compute.v1.ListUsableSubnetworksRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchSubnetworkRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicySubnetworkRequest;
import com.google.cloud.compute.v1.SetPrivateIpGoogleAccessSubnetworkRequest;
import com.google.cloud.compute.v1.Subnetwork;
import com.google.cloud.compute.v1.SubnetworkAggregatedList;
import com.google.cloud.compute.v1.SubnetworkList;
import com.google.cloud.compute.v1.TestIamPermissionsSubnetworkRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.cloud.compute.v1.UsableSubnetworksAggregatedList;
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
 * REST stub implementation for the Subnetworks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonSubnetworksStub extends SubnetworksStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<
          AggregatedListSubnetworksRequest, SubnetworkAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListSubnetworksRequest, SubnetworkAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Subnetworks/AggregatedList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListSubnetworksRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/subnetworks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListSubnetworksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListSubnetworksRequest> serializer =
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
                  ProtoMessageResponseParser.<SubnetworkAggregatedList>newBuilder()
                      .setDefaultInstance(SubnetworkAggregatedList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSubnetworkRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteSubnetworkRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Subnetworks/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSubnetworkRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/subnetworks/{subnetwork}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSubnetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "subnetwork", request.getSubnetwork());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSubnetworkRequest> serializer =
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
                  (DeleteSubnetworkRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<ExpandIpCidrRangeSubnetworkRequest, Operation>
      expandIpCidrRangeMethodDescriptor =
          ApiMethodDescriptor.<ExpandIpCidrRangeSubnetworkRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Subnetworks/ExpandIpCidrRange")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExpandIpCidrRangeSubnetworkRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/subnetworks/{subnetwork}/expandIpCidrRange",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExpandIpCidrRangeSubnetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "subnetwork", request.getSubnetwork());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExpandIpCidrRangeSubnetworkRequest> serializer =
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
                                      "subnetworksExpandIpCidrRangeRequestResource",
                                      request.getSubnetworksExpandIpCidrRangeRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExpandIpCidrRangeSubnetworkRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<GetSubnetworkRequest, Subnetwork> getMethodDescriptor =
      ApiMethodDescriptor.<GetSubnetworkRequest, Subnetwork>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Subnetworks/Get")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSubnetworkRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/subnetworks/{subnetwork}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetSubnetworkRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "region", request.getRegion());
                        serializer.putPathParam(fields, "subnetwork", request.getSubnetwork());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetSubnetworkRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Subnetwork>newBuilder()
                  .setDefaultInstance(Subnetwork.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetIamPolicySubnetworkRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicySubnetworkRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Subnetworks/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicySubnetworkRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/subnetworks/{resource}/getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicySubnetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicySubnetworkRequest> serializer =
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

  private static final ApiMethodDescriptor<InsertSubnetworkRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertSubnetworkRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Subnetworks/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertSubnetworkRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/subnetworks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertSubnetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertSubnetworkRequest> serializer =
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
                                      "subnetworkResource", request.getSubnetworkResource(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertSubnetworkRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<ListSubnetworksRequest, SubnetworkList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListSubnetworksRequest, SubnetworkList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Subnetworks/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSubnetworksRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/subnetworks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSubnetworksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSubnetworksRequest> serializer =
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
                  ProtoMessageResponseParser.<SubnetworkList>newBuilder()
                      .setDefaultInstance(SubnetworkList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList>
      listUsableMethodDescriptor =
          ApiMethodDescriptor
              .<ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Subnetworks/ListUsable")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListUsableSubnetworksRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/subnetworks/listUsable",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListUsableSubnetworksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListUsableSubnetworksRequest> serializer =
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
                  ProtoMessageResponseParser.<UsableSubnetworksAggregatedList>newBuilder()
                      .setDefaultInstance(UsableSubnetworksAggregatedList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchSubnetworkRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchSubnetworkRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Subnetworks/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchSubnetworkRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/subnetworks/{subnetwork}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchSubnetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "subnetwork", request.getSubnetwork());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchSubnetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasDrainTimeoutSeconds()) {
                              serializer.putQueryParam(
                                  fields, "drainTimeoutSeconds", request.getDrainTimeoutSeconds());
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
                                      "subnetworkResource", request.getSubnetworkResource(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PatchSubnetworkRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<SetIamPolicySubnetworkRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicySubnetworkRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Subnetworks/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicySubnetworkRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/subnetworks/{resource}/setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicySubnetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicySubnetworkRequest> serializer =
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

  private static final ApiMethodDescriptor<SetPrivateIpGoogleAccessSubnetworkRequest, Operation>
      setPrivateIpGoogleAccessMethodDescriptor =
          ApiMethodDescriptor.<SetPrivateIpGoogleAccessSubnetworkRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Subnetworks/SetPrivateIpGoogleAccess")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SetPrivateIpGoogleAccessSubnetworkRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/subnetworks/{subnetwork}/setPrivateIpGoogleAccess",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetPrivateIpGoogleAccessSubnetworkRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "subnetwork", request.getSubnetwork());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetPrivateIpGoogleAccessSubnetworkRequest>
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
                                      "subnetworksSetPrivateIpGoogleAccessRequestResource",
                                      request
                                          .getSubnetworksSetPrivateIpGoogleAccessRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetPrivateIpGoogleAccessSubnetworkRequest request, Operation response) -> {
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
          TestIamPermissionsSubnetworkRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsSubnetworkRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Subnetworks/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsSubnetworkRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/subnetworks/{resource}/testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsSubnetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsSubnetworkRequest> serializer =
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

  private final UnaryCallable<AggregatedListSubnetworksRequest, SubnetworkAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListSubnetworksRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteSubnetworkRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteSubnetworkRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<ExpandIpCidrRangeSubnetworkRequest, Operation>
      expandIpCidrRangeCallable;
  private final OperationCallable<ExpandIpCidrRangeSubnetworkRequest, Operation, Operation>
      expandIpCidrRangeOperationCallable;
  private final UnaryCallable<GetSubnetworkRequest, Subnetwork> getCallable;
  private final UnaryCallable<GetIamPolicySubnetworkRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<InsertSubnetworkRequest, Operation> insertCallable;
  private final OperationCallable<InsertSubnetworkRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListSubnetworksRequest, SubnetworkList> listCallable;
  private final UnaryCallable<ListSubnetworksRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList>
      listUsableCallable;
  private final UnaryCallable<ListUsableSubnetworksRequest, ListUsablePagedResponse>
      listUsablePagedCallable;
  private final UnaryCallable<PatchSubnetworkRequest, Operation> patchCallable;
  private final OperationCallable<PatchSubnetworkRequest, Operation, Operation>
      patchOperationCallable;
  private final UnaryCallable<SetIamPolicySubnetworkRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<SetPrivateIpGoogleAccessSubnetworkRequest, Operation>
      setPrivateIpGoogleAccessCallable;
  private final OperationCallable<SetPrivateIpGoogleAccessSubnetworkRequest, Operation, Operation>
      setPrivateIpGoogleAccessOperationCallable;
  private final UnaryCallable<TestIamPermissionsSubnetworkRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonRegionOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSubnetworksStub create(SubnetworksStubSettings settings)
      throws IOException {
    return new HttpJsonSubnetworksStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSubnetworksStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSubnetworksStub(SubnetworksStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonSubnetworksStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSubnetworksStub(
        SubnetworksStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSubnetworksStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSubnetworksStub(SubnetworksStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonSubnetworksCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSubnetworksStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSubnetworksStub(
      SubnetworksStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonRegionOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<AggregatedListSubnetworksRequest, SubnetworkAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListSubnetworksRequest, SubnetworkAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteSubnetworkRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteSubnetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ExpandIpCidrRangeSubnetworkRequest, Operation>
        expandIpCidrRangeTransportSettings =
            HttpJsonCallSettings.<ExpandIpCidrRangeSubnetworkRequest, Operation>newBuilder()
                .setMethodDescriptor(expandIpCidrRangeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetSubnetworkRequest, Subnetwork> getTransportSettings =
        HttpJsonCallSettings.<GetSubnetworkRequest, Subnetwork>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetIamPolicySubnetworkRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicySubnetworkRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<InsertSubnetworkRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertSubnetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListSubnetworksRequest, SubnetworkList> listTransportSettings =
        HttpJsonCallSettings.<ListSubnetworksRequest, SubnetworkList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList>
        listUsableTransportSettings =
            HttpJsonCallSettings
                .<ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList>newBuilder()
                .setMethodDescriptor(listUsableMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<PatchSubnetworkRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchSubnetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetIamPolicySubnetworkRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicySubnetworkRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetPrivateIpGoogleAccessSubnetworkRequest, Operation>
        setPrivateIpGoogleAccessTransportSettings =
            HttpJsonCallSettings.<SetPrivateIpGoogleAccessSubnetworkRequest, Operation>newBuilder()
                .setMethodDescriptor(setPrivateIpGoogleAccessMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<TestIamPermissionsSubnetworkRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsSubnetworkRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.aggregatedListCallable =
        callableFactory.createUnaryCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.aggregatedListPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.deleteOperationCallable =
        callableFactory.createOperationCallable(
            deleteTransportSettings,
            settings.deleteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.expandIpCidrRangeCallable =
        callableFactory.createUnaryCallable(
            expandIpCidrRangeTransportSettings,
            settings.expandIpCidrRangeSettings(),
            clientContext);
    this.expandIpCidrRangeOperationCallable =
        callableFactory.createOperationCallable(
            expandIpCidrRangeTransportSettings,
            settings.expandIpCidrRangeOperationSettings(),
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
    this.listUsableCallable =
        callableFactory.createUnaryCallable(
            listUsableTransportSettings, settings.listUsableSettings(), clientContext);
    this.listUsablePagedCallable =
        callableFactory.createPagedCallable(
            listUsableTransportSettings, settings.listUsableSettings(), clientContext);
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
    this.patchOperationCallable =
        callableFactory.createOperationCallable(
            patchTransportSettings,
            settings.patchOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.setPrivateIpGoogleAccessCallable =
        callableFactory.createUnaryCallable(
            setPrivateIpGoogleAccessTransportSettings,
            settings.setPrivateIpGoogleAccessSettings(),
            clientContext);
    this.setPrivateIpGoogleAccessOperationCallable =
        callableFactory.createOperationCallable(
            setPrivateIpGoogleAccessTransportSettings,
            settings.setPrivateIpGoogleAccessOperationSettings(),
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
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(expandIpCidrRangeMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(listUsableMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(setPrivateIpGoogleAccessMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AggregatedListSubnetworksRequest, SubnetworkAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListSubnetworksRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteSubnetworkRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteSubnetworkRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<ExpandIpCidrRangeSubnetworkRequest, Operation> expandIpCidrRangeCallable() {
    return expandIpCidrRangeCallable;
  }

  @Override
  public OperationCallable<ExpandIpCidrRangeSubnetworkRequest, Operation, Operation>
      expandIpCidrRangeOperationCallable() {
    return expandIpCidrRangeOperationCallable;
  }

  @Override
  public UnaryCallable<GetSubnetworkRequest, Subnetwork> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicySubnetworkRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<InsertSubnetworkRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertSubnetworkRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListSubnetworksRequest, SubnetworkList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListSubnetworksRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList>
      listUsableCallable() {
    return listUsableCallable;
  }

  @Override
  public UnaryCallable<ListUsableSubnetworksRequest, ListUsablePagedResponse>
      listUsablePagedCallable() {
    return listUsablePagedCallable;
  }

  @Override
  public UnaryCallable<PatchSubnetworkRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchSubnetworkRequest, Operation, Operation> patchOperationCallable() {
    return patchOperationCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicySubnetworkRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetPrivateIpGoogleAccessSubnetworkRequest, Operation>
      setPrivateIpGoogleAccessCallable() {
    return setPrivateIpGoogleAccessCallable;
  }

  @Override
  public OperationCallable<SetPrivateIpGoogleAccessSubnetworkRequest, Operation, Operation>
      setPrivateIpGoogleAccessOperationCallable() {
    return setPrivateIpGoogleAccessOperationCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsSubnetworkRequest, TestPermissionsResponse>
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
