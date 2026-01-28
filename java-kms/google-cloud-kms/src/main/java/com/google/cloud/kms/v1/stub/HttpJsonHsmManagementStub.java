/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.kms.v1.stub;

import static com.google.cloud.kms.v1.HsmManagementClient.ListLocationsPagedResponse;
import static com.google.cloud.kms.v1.HsmManagementClient.ListSingleTenantHsmInstanceProposalsPagedResponse;
import static com.google.cloud.kms.v1.HsmManagementClient.ListSingleTenantHsmInstancesPagedResponse;

import com.google.api.HttpRule;
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
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalRequest;
import com.google.cloud.kms.v1.ApproveSingleTenantHsmInstanceProposalResponse;
import com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceMetadata;
import com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceProposalMetadata;
import com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceProposalRequest;
import com.google.cloud.kms.v1.CreateSingleTenantHsmInstanceRequest;
import com.google.cloud.kms.v1.DeleteSingleTenantHsmInstanceProposalRequest;
import com.google.cloud.kms.v1.ExecuteSingleTenantHsmInstanceProposalMetadata;
import com.google.cloud.kms.v1.ExecuteSingleTenantHsmInstanceProposalRequest;
import com.google.cloud.kms.v1.ExecuteSingleTenantHsmInstanceProposalResponse;
import com.google.cloud.kms.v1.GetSingleTenantHsmInstanceProposalRequest;
import com.google.cloud.kms.v1.GetSingleTenantHsmInstanceRequest;
import com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsRequest;
import com.google.cloud.kms.v1.ListSingleTenantHsmInstanceProposalsResponse;
import com.google.cloud.kms.v1.ListSingleTenantHsmInstancesRequest;
import com.google.cloud.kms.v1.ListSingleTenantHsmInstancesResponse;
import com.google.cloud.kms.v1.SingleTenantHsmInstance;
import com.google.cloud.kms.v1.SingleTenantHsmInstanceProposal;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the HsmManagement service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonHsmManagementStub extends HsmManagementStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(ExecuteSingleTenantHsmInstanceProposalResponse.getDescriptor())
          .add(SingleTenantHsmInstance.getDescriptor())
          .add(SingleTenantHsmInstanceProposal.getDescriptor())
          .add(CreateSingleTenantHsmInstanceProposalMetadata.getDescriptor())
          .add(ExecuteSingleTenantHsmInstanceProposalMetadata.getDescriptor())
          .add(CreateSingleTenantHsmInstanceMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          ListSingleTenantHsmInstancesRequest, ListSingleTenantHsmInstancesResponse>
      listSingleTenantHsmInstancesMethodDescriptor =
          ApiMethodDescriptor
              .<ListSingleTenantHsmInstancesRequest, ListSingleTenantHsmInstancesResponse>
                  newBuilder()
              .setFullMethodName("google.cloud.kms.v1.HsmManagement/ListSingleTenantHsmInstances")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSingleTenantHsmInstancesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/singleTenantHsmInstances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSingleTenantHsmInstancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSingleTenantHsmInstancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "showDeleted", request.getShowDeleted());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSingleTenantHsmInstancesResponse>newBuilder()
                      .setDefaultInstance(ListSingleTenantHsmInstancesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetSingleTenantHsmInstanceRequest, SingleTenantHsmInstance>
      getSingleTenantHsmInstanceMethodDescriptor =
          ApiMethodDescriptor
              .<GetSingleTenantHsmInstanceRequest, SingleTenantHsmInstance>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.HsmManagement/GetSingleTenantHsmInstance")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSingleTenantHsmInstanceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/singleTenantHsmInstances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSingleTenantHsmInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSingleTenantHsmInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SingleTenantHsmInstance>newBuilder()
                      .setDefaultInstance(SingleTenantHsmInstance.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateSingleTenantHsmInstanceRequest, Operation>
      createSingleTenantHsmInstanceMethodDescriptor =
          ApiMethodDescriptor.<CreateSingleTenantHsmInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.kms.v1.HsmManagement/CreateSingleTenantHsmInstance")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSingleTenantHsmInstanceRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/singleTenantHsmInstances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSingleTenantHsmInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSingleTenantHsmInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "singleTenantHsmInstanceId",
                                request.getSingleTenantHsmInstanceId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "singleTenantHsmInstance",
                                      request.getSingleTenantHsmInstance(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateSingleTenantHsmInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateSingleTenantHsmInstanceProposalRequest, Operation>
      createSingleTenantHsmInstanceProposalMethodDescriptor =
          ApiMethodDescriptor.<CreateSingleTenantHsmInstanceProposalRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.kms.v1.HsmManagement/CreateSingleTenantHsmInstanceProposal")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<CreateSingleTenantHsmInstanceProposalRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/singleTenantHsmInstances/*}/proposals",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSingleTenantHsmInstanceProposalRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSingleTenantHsmInstanceProposalRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "singleTenantHsmInstanceProposalId",
                                request.getSingleTenantHsmInstanceProposalId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "singleTenantHsmInstanceProposal",
                                      request.getSingleTenantHsmInstanceProposal(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateSingleTenantHsmInstanceProposalRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ApproveSingleTenantHsmInstanceProposalRequest,
          ApproveSingleTenantHsmInstanceProposalResponse>
      approveSingleTenantHsmInstanceProposalMethodDescriptor =
          ApiMethodDescriptor
              .<ApproveSingleTenantHsmInstanceProposalRequest,
                  ApproveSingleTenantHsmInstanceProposalResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.kms.v1.HsmManagement/ApproveSingleTenantHsmInstanceProposal")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ApproveSingleTenantHsmInstanceProposalRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/singleTenantHsmInstances/*/proposals/*}:approve",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ApproveSingleTenantHsmInstanceProposalRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ApproveSingleTenantHsmInstanceProposalRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<ApproveSingleTenantHsmInstanceProposalResponse>newBuilder()
                      .setDefaultInstance(
                          ApproveSingleTenantHsmInstanceProposalResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ExecuteSingleTenantHsmInstanceProposalRequest, Operation>
      executeSingleTenantHsmInstanceProposalMethodDescriptor =
          ApiMethodDescriptor.<ExecuteSingleTenantHsmInstanceProposalRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.kms.v1.HsmManagement/ExecuteSingleTenantHsmInstanceProposal")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ExecuteSingleTenantHsmInstanceProposalRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/singleTenantHsmInstances/*/proposals/*}:execute",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExecuteSingleTenantHsmInstanceProposalRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExecuteSingleTenantHsmInstanceProposalRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExecuteSingleTenantHsmInstanceProposalRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          GetSingleTenantHsmInstanceProposalRequest, SingleTenantHsmInstanceProposal>
      getSingleTenantHsmInstanceProposalMethodDescriptor =
          ApiMethodDescriptor
              .<GetSingleTenantHsmInstanceProposalRequest, SingleTenantHsmInstanceProposal>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.kms.v1.HsmManagement/GetSingleTenantHsmInstanceProposal")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetSingleTenantHsmInstanceProposalRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/singleTenantHsmInstances/*/proposals/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSingleTenantHsmInstanceProposalRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSingleTenantHsmInstanceProposalRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SingleTenantHsmInstanceProposal>newBuilder()
                      .setDefaultInstance(SingleTenantHsmInstanceProposal.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListSingleTenantHsmInstanceProposalsRequest, ListSingleTenantHsmInstanceProposalsResponse>
      listSingleTenantHsmInstanceProposalsMethodDescriptor =
          ApiMethodDescriptor
              .<ListSingleTenantHsmInstanceProposalsRequest,
                  ListSingleTenantHsmInstanceProposalsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.kms.v1.HsmManagement/ListSingleTenantHsmInstanceProposals")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListSingleTenantHsmInstanceProposalsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/singleTenantHsmInstances/*}/proposals",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSingleTenantHsmInstanceProposalsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSingleTenantHsmInstanceProposalsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "showDeleted", request.getShowDeleted());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<ListSingleTenantHsmInstanceProposalsResponse>newBuilder()
                      .setDefaultInstance(
                          ListSingleTenantHsmInstanceProposalsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSingleTenantHsmInstanceProposalRequest, Empty>
      deleteSingleTenantHsmInstanceProposalMethodDescriptor =
          ApiMethodDescriptor.<DeleteSingleTenantHsmInstanceProposalRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.kms.v1.HsmManagement/DeleteSingleTenantHsmInstanceProposal")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeleteSingleTenantHsmInstanceProposalRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/singleTenantHsmInstances/*/proposals/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSingleTenantHsmInstanceProposalRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSingleTenantHsmInstanceProposalRequest>
                                serializer = ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/keyRings/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/keyRings/*/cryptoKeys/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/keyRings/*/importJobs/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/ekmConfig}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/ekmConnections/*}:setIamPolicy")
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
              .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/keyRings/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/keyRings/*/cryptoKeys/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/keyRings/*/importJobs/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/ekmConfig}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/ekmConnections/*}:getIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/keyRings/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/keyRings/*/cryptoKeys/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/keyRings/*/importJobs/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/ekmConfig}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/ekmConnections/*}:testIamPermissions")
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

  private final UnaryCallable<
          ListSingleTenantHsmInstancesRequest, ListSingleTenantHsmInstancesResponse>
      listSingleTenantHsmInstancesCallable;
  private final UnaryCallable<
          ListSingleTenantHsmInstancesRequest, ListSingleTenantHsmInstancesPagedResponse>
      listSingleTenantHsmInstancesPagedCallable;
  private final UnaryCallable<GetSingleTenantHsmInstanceRequest, SingleTenantHsmInstance>
      getSingleTenantHsmInstanceCallable;
  private final UnaryCallable<CreateSingleTenantHsmInstanceRequest, Operation>
      createSingleTenantHsmInstanceCallable;
  private final OperationCallable<
          CreateSingleTenantHsmInstanceRequest,
          SingleTenantHsmInstance,
          CreateSingleTenantHsmInstanceMetadata>
      createSingleTenantHsmInstanceOperationCallable;
  private final UnaryCallable<CreateSingleTenantHsmInstanceProposalRequest, Operation>
      createSingleTenantHsmInstanceProposalCallable;
  private final OperationCallable<
          CreateSingleTenantHsmInstanceProposalRequest,
          SingleTenantHsmInstanceProposal,
          CreateSingleTenantHsmInstanceProposalMetadata>
      createSingleTenantHsmInstanceProposalOperationCallable;
  private final UnaryCallable<
          ApproveSingleTenantHsmInstanceProposalRequest,
          ApproveSingleTenantHsmInstanceProposalResponse>
      approveSingleTenantHsmInstanceProposalCallable;
  private final UnaryCallable<ExecuteSingleTenantHsmInstanceProposalRequest, Operation>
      executeSingleTenantHsmInstanceProposalCallable;
  private final OperationCallable<
          ExecuteSingleTenantHsmInstanceProposalRequest,
          ExecuteSingleTenantHsmInstanceProposalResponse,
          ExecuteSingleTenantHsmInstanceProposalMetadata>
      executeSingleTenantHsmInstanceProposalOperationCallable;
  private final UnaryCallable<
          GetSingleTenantHsmInstanceProposalRequest, SingleTenantHsmInstanceProposal>
      getSingleTenantHsmInstanceProposalCallable;
  private final UnaryCallable<
          ListSingleTenantHsmInstanceProposalsRequest, ListSingleTenantHsmInstanceProposalsResponse>
      listSingleTenantHsmInstanceProposalsCallable;
  private final UnaryCallable<
          ListSingleTenantHsmInstanceProposalsRequest,
          ListSingleTenantHsmInstanceProposalsPagedResponse>
      listSingleTenantHsmInstanceProposalsPagedCallable;
  private final UnaryCallable<DeleteSingleTenantHsmInstanceProposalRequest, Empty>
      deleteSingleTenantHsmInstanceProposalCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonHsmManagementStub create(HsmManagementStubSettings settings)
      throws IOException {
    return new HttpJsonHsmManagementStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonHsmManagementStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonHsmManagementStub(
        HsmManagementStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonHsmManagementStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonHsmManagementStub(
        HsmManagementStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonHsmManagementStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonHsmManagementStub(
      HsmManagementStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonHsmManagementCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonHsmManagementStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonHsmManagementStub(
      HsmManagementStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .build());

    HttpJsonCallSettings<ListSingleTenantHsmInstancesRequest, ListSingleTenantHsmInstancesResponse>
        listSingleTenantHsmInstancesTransportSettings =
            HttpJsonCallSettings
                .<ListSingleTenantHsmInstancesRequest, ListSingleTenantHsmInstancesResponse>
                    newBuilder()
                .setMethodDescriptor(listSingleTenantHsmInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetSingleTenantHsmInstanceRequest, SingleTenantHsmInstance>
        getSingleTenantHsmInstanceTransportSettings =
            HttpJsonCallSettings
                .<GetSingleTenantHsmInstanceRequest, SingleTenantHsmInstance>newBuilder()
                .setMethodDescriptor(getSingleTenantHsmInstanceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateSingleTenantHsmInstanceRequest, Operation>
        createSingleTenantHsmInstanceTransportSettings =
            HttpJsonCallSettings.<CreateSingleTenantHsmInstanceRequest, Operation>newBuilder()
                .setMethodDescriptor(createSingleTenantHsmInstanceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateSingleTenantHsmInstanceProposalRequest, Operation>
        createSingleTenantHsmInstanceProposalTransportSettings =
            HttpJsonCallSettings
                .<CreateSingleTenantHsmInstanceProposalRequest, Operation>newBuilder()
                .setMethodDescriptor(createSingleTenantHsmInstanceProposalMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ApproveSingleTenantHsmInstanceProposalRequest,
            ApproveSingleTenantHsmInstanceProposalResponse>
        approveSingleTenantHsmInstanceProposalTransportSettings =
            HttpJsonCallSettings
                .<ApproveSingleTenantHsmInstanceProposalRequest,
                    ApproveSingleTenantHsmInstanceProposalResponse>
                    newBuilder()
                .setMethodDescriptor(approveSingleTenantHsmInstanceProposalMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ExecuteSingleTenantHsmInstanceProposalRequest, Operation>
        executeSingleTenantHsmInstanceProposalTransportSettings =
            HttpJsonCallSettings
                .<ExecuteSingleTenantHsmInstanceProposalRequest, Operation>newBuilder()
                .setMethodDescriptor(executeSingleTenantHsmInstanceProposalMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetSingleTenantHsmInstanceProposalRequest, SingleTenantHsmInstanceProposal>
        getSingleTenantHsmInstanceProposalTransportSettings =
            HttpJsonCallSettings
                .<GetSingleTenantHsmInstanceProposalRequest, SingleTenantHsmInstanceProposal>
                    newBuilder()
                .setMethodDescriptor(getSingleTenantHsmInstanceProposalMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListSingleTenantHsmInstanceProposalsRequest,
            ListSingleTenantHsmInstanceProposalsResponse>
        listSingleTenantHsmInstanceProposalsTransportSettings =
            HttpJsonCallSettings
                .<ListSingleTenantHsmInstanceProposalsRequest,
                    ListSingleTenantHsmInstanceProposalsResponse>
                    newBuilder()
                .setMethodDescriptor(listSingleTenantHsmInstanceProposalsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteSingleTenantHsmInstanceProposalRequest, Empty>
        deleteSingleTenantHsmInstanceProposalTransportSettings =
            HttpJsonCallSettings.<DeleteSingleTenantHsmInstanceProposalRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteSingleTenantHsmInstanceProposalMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.listSingleTenantHsmInstancesCallable =
        callableFactory.createUnaryCallable(
            listSingleTenantHsmInstancesTransportSettings,
            settings.listSingleTenantHsmInstancesSettings(),
            clientContext);
    this.listSingleTenantHsmInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listSingleTenantHsmInstancesTransportSettings,
            settings.listSingleTenantHsmInstancesSettings(),
            clientContext);
    this.getSingleTenantHsmInstanceCallable =
        callableFactory.createUnaryCallable(
            getSingleTenantHsmInstanceTransportSettings,
            settings.getSingleTenantHsmInstanceSettings(),
            clientContext);
    this.createSingleTenantHsmInstanceCallable =
        callableFactory.createUnaryCallable(
            createSingleTenantHsmInstanceTransportSettings,
            settings.createSingleTenantHsmInstanceSettings(),
            clientContext);
    this.createSingleTenantHsmInstanceOperationCallable =
        callableFactory.createOperationCallable(
            createSingleTenantHsmInstanceTransportSettings,
            settings.createSingleTenantHsmInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createSingleTenantHsmInstanceProposalCallable =
        callableFactory.createUnaryCallable(
            createSingleTenantHsmInstanceProposalTransportSettings,
            settings.createSingleTenantHsmInstanceProposalSettings(),
            clientContext);
    this.createSingleTenantHsmInstanceProposalOperationCallable =
        callableFactory.createOperationCallable(
            createSingleTenantHsmInstanceProposalTransportSettings,
            settings.createSingleTenantHsmInstanceProposalOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.approveSingleTenantHsmInstanceProposalCallable =
        callableFactory.createUnaryCallable(
            approveSingleTenantHsmInstanceProposalTransportSettings,
            settings.approveSingleTenantHsmInstanceProposalSettings(),
            clientContext);
    this.executeSingleTenantHsmInstanceProposalCallable =
        callableFactory.createUnaryCallable(
            executeSingleTenantHsmInstanceProposalTransportSettings,
            settings.executeSingleTenantHsmInstanceProposalSettings(),
            clientContext);
    this.executeSingleTenantHsmInstanceProposalOperationCallable =
        callableFactory.createOperationCallable(
            executeSingleTenantHsmInstanceProposalTransportSettings,
            settings.executeSingleTenantHsmInstanceProposalOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getSingleTenantHsmInstanceProposalCallable =
        callableFactory.createUnaryCallable(
            getSingleTenantHsmInstanceProposalTransportSettings,
            settings.getSingleTenantHsmInstanceProposalSettings(),
            clientContext);
    this.listSingleTenantHsmInstanceProposalsCallable =
        callableFactory.createUnaryCallable(
            listSingleTenantHsmInstanceProposalsTransportSettings,
            settings.listSingleTenantHsmInstanceProposalsSettings(),
            clientContext);
    this.listSingleTenantHsmInstanceProposalsPagedCallable =
        callableFactory.createPagedCallable(
            listSingleTenantHsmInstanceProposalsTransportSettings,
            settings.listSingleTenantHsmInstanceProposalsSettings(),
            clientContext);
    this.deleteSingleTenantHsmInstanceProposalCallable =
        callableFactory.createUnaryCallable(
            deleteSingleTenantHsmInstanceProposalTransportSettings,
            settings.deleteSingleTenantHsmInstanceProposalSettings(),
            clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listSingleTenantHsmInstancesMethodDescriptor);
    methodDescriptors.add(getSingleTenantHsmInstanceMethodDescriptor);
    methodDescriptors.add(createSingleTenantHsmInstanceMethodDescriptor);
    methodDescriptors.add(createSingleTenantHsmInstanceProposalMethodDescriptor);
    methodDescriptors.add(approveSingleTenantHsmInstanceProposalMethodDescriptor);
    methodDescriptors.add(executeSingleTenantHsmInstanceProposalMethodDescriptor);
    methodDescriptors.add(getSingleTenantHsmInstanceProposalMethodDescriptor);
    methodDescriptors.add(listSingleTenantHsmInstanceProposalsMethodDescriptor);
    methodDescriptors.add(deleteSingleTenantHsmInstanceProposalMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListSingleTenantHsmInstancesRequest, ListSingleTenantHsmInstancesResponse>
      listSingleTenantHsmInstancesCallable() {
    return listSingleTenantHsmInstancesCallable;
  }

  @Override
  public UnaryCallable<
          ListSingleTenantHsmInstancesRequest, ListSingleTenantHsmInstancesPagedResponse>
      listSingleTenantHsmInstancesPagedCallable() {
    return listSingleTenantHsmInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<GetSingleTenantHsmInstanceRequest, SingleTenantHsmInstance>
      getSingleTenantHsmInstanceCallable() {
    return getSingleTenantHsmInstanceCallable;
  }

  @Override
  public UnaryCallable<CreateSingleTenantHsmInstanceRequest, Operation>
      createSingleTenantHsmInstanceCallable() {
    return createSingleTenantHsmInstanceCallable;
  }

  @Override
  public OperationCallable<
          CreateSingleTenantHsmInstanceRequest,
          SingleTenantHsmInstance,
          CreateSingleTenantHsmInstanceMetadata>
      createSingleTenantHsmInstanceOperationCallable() {
    return createSingleTenantHsmInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<CreateSingleTenantHsmInstanceProposalRequest, Operation>
      createSingleTenantHsmInstanceProposalCallable() {
    return createSingleTenantHsmInstanceProposalCallable;
  }

  @Override
  public OperationCallable<
          CreateSingleTenantHsmInstanceProposalRequest,
          SingleTenantHsmInstanceProposal,
          CreateSingleTenantHsmInstanceProposalMetadata>
      createSingleTenantHsmInstanceProposalOperationCallable() {
    return createSingleTenantHsmInstanceProposalOperationCallable;
  }

  @Override
  public UnaryCallable<
          ApproveSingleTenantHsmInstanceProposalRequest,
          ApproveSingleTenantHsmInstanceProposalResponse>
      approveSingleTenantHsmInstanceProposalCallable() {
    return approveSingleTenantHsmInstanceProposalCallable;
  }

  @Override
  public UnaryCallable<ExecuteSingleTenantHsmInstanceProposalRequest, Operation>
      executeSingleTenantHsmInstanceProposalCallable() {
    return executeSingleTenantHsmInstanceProposalCallable;
  }

  @Override
  public OperationCallable<
          ExecuteSingleTenantHsmInstanceProposalRequest,
          ExecuteSingleTenantHsmInstanceProposalResponse,
          ExecuteSingleTenantHsmInstanceProposalMetadata>
      executeSingleTenantHsmInstanceProposalOperationCallable() {
    return executeSingleTenantHsmInstanceProposalOperationCallable;
  }

  @Override
  public UnaryCallable<GetSingleTenantHsmInstanceProposalRequest, SingleTenantHsmInstanceProposal>
      getSingleTenantHsmInstanceProposalCallable() {
    return getSingleTenantHsmInstanceProposalCallable;
  }

  @Override
  public UnaryCallable<
          ListSingleTenantHsmInstanceProposalsRequest, ListSingleTenantHsmInstanceProposalsResponse>
      listSingleTenantHsmInstanceProposalsCallable() {
    return listSingleTenantHsmInstanceProposalsCallable;
  }

  @Override
  public UnaryCallable<
          ListSingleTenantHsmInstanceProposalsRequest,
          ListSingleTenantHsmInstanceProposalsPagedResponse>
      listSingleTenantHsmInstanceProposalsPagedCallable() {
    return listSingleTenantHsmInstanceProposalsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteSingleTenantHsmInstanceProposalRequest, Empty>
      deleteSingleTenantHsmInstanceProposalCallable() {
    return deleteSingleTenantHsmInstanceProposalCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
