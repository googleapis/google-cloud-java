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

package com.google.cloud.osconfig.v1.stub;

import static com.google.cloud.osconfig.v1.OsConfigZonalServiceClient.ListInventoriesPagedResponse;
import static com.google.cloud.osconfig.v1.OsConfigZonalServiceClient.ListOSPolicyAssignmentReportsPagedResponse;
import static com.google.cloud.osconfig.v1.OsConfigZonalServiceClient.ListOSPolicyAssignmentRevisionsPagedResponse;
import static com.google.cloud.osconfig.v1.OsConfigZonalServiceClient.ListOSPolicyAssignmentsPagedResponse;
import static com.google.cloud.osconfig.v1.OsConfigZonalServiceClient.ListVulnerabilityReportsPagedResponse;

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
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.osconfig.v1.CreateOSPolicyAssignmentRequest;
import com.google.cloud.osconfig.v1.DeleteOSPolicyAssignmentRequest;
import com.google.cloud.osconfig.v1.GetInventoryRequest;
import com.google.cloud.osconfig.v1.GetOSPolicyAssignmentReportRequest;
import com.google.cloud.osconfig.v1.GetOSPolicyAssignmentRequest;
import com.google.cloud.osconfig.v1.GetVulnerabilityReportRequest;
import com.google.cloud.osconfig.v1.Inventory;
import com.google.cloud.osconfig.v1.ListInventoriesRequest;
import com.google.cloud.osconfig.v1.ListInventoriesResponse;
import com.google.cloud.osconfig.v1.ListOSPolicyAssignmentReportsRequest;
import com.google.cloud.osconfig.v1.ListOSPolicyAssignmentReportsResponse;
import com.google.cloud.osconfig.v1.ListOSPolicyAssignmentRevisionsRequest;
import com.google.cloud.osconfig.v1.ListOSPolicyAssignmentRevisionsResponse;
import com.google.cloud.osconfig.v1.ListOSPolicyAssignmentsRequest;
import com.google.cloud.osconfig.v1.ListOSPolicyAssignmentsResponse;
import com.google.cloud.osconfig.v1.ListVulnerabilityReportsRequest;
import com.google.cloud.osconfig.v1.ListVulnerabilityReportsResponse;
import com.google.cloud.osconfig.v1.OSPolicyAssignment;
import com.google.cloud.osconfig.v1.OSPolicyAssignmentOperationMetadata;
import com.google.cloud.osconfig.v1.OSPolicyAssignmentReport;
import com.google.cloud.osconfig.v1.UpdateOSPolicyAssignmentRequest;
import com.google.cloud.osconfig.v1.VulnerabilityReport;
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
 * REST stub implementation for the OsConfigZonalService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonOsConfigZonalServiceStub extends OsConfigZonalServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(OSPolicyAssignmentOperationMetadata.getDescriptor())
          .add(OSPolicyAssignment.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateOSPolicyAssignmentRequest, Operation>
      createOSPolicyAssignmentMethodDescriptor =
          ApiMethodDescriptor.<CreateOSPolicyAssignmentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.osconfig.v1.OsConfigZonalService/CreateOSPolicyAssignment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateOSPolicyAssignmentRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/osPolicyAssignments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateOSPolicyAssignmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateOSPolicyAssignmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "osPolicyAssignmentId", request.getOsPolicyAssignmentId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "osPolicyAssignment", request.getOsPolicyAssignment(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateOSPolicyAssignmentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateOSPolicyAssignmentRequest, Operation>
      updateOSPolicyAssignmentMethodDescriptor =
          ApiMethodDescriptor.<UpdateOSPolicyAssignmentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.osconfig.v1.OsConfigZonalService/UpdateOSPolicyAssignment")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateOSPolicyAssignmentRequest>newBuilder()
                      .setPath(
                          "/v1/{osPolicyAssignment.name=projects/*/locations/*/osPolicyAssignments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateOSPolicyAssignmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "osPolicyAssignment.name",
                                request.getOsPolicyAssignment().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateOSPolicyAssignmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "osPolicyAssignment", request.getOsPolicyAssignment(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateOSPolicyAssignmentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetOSPolicyAssignmentRequest, OSPolicyAssignment>
      getOSPolicyAssignmentMethodDescriptor =
          ApiMethodDescriptor.<GetOSPolicyAssignmentRequest, OSPolicyAssignment>newBuilder()
              .setFullMethodName(
                  "google.cloud.osconfig.v1.OsConfigZonalService/GetOSPolicyAssignment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetOSPolicyAssignmentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/osPolicyAssignments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetOSPolicyAssignmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetOSPolicyAssignmentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<OSPolicyAssignment>newBuilder()
                      .setDefaultInstance(OSPolicyAssignment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListOSPolicyAssignmentsRequest, ListOSPolicyAssignmentsResponse>
      listOSPolicyAssignmentsMethodDescriptor =
          ApiMethodDescriptor
              .<ListOSPolicyAssignmentsRequest, ListOSPolicyAssignmentsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.osconfig.v1.OsConfigZonalService/ListOSPolicyAssignments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListOSPolicyAssignmentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/osPolicyAssignments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListOSPolicyAssignmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListOSPolicyAssignmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListOSPolicyAssignmentsResponse>newBuilder()
                      .setDefaultInstance(ListOSPolicyAssignmentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListOSPolicyAssignmentRevisionsRequest, ListOSPolicyAssignmentRevisionsResponse>
      listOSPolicyAssignmentRevisionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListOSPolicyAssignmentRevisionsRequest, ListOSPolicyAssignmentRevisionsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.osconfig.v1.OsConfigZonalService/ListOSPolicyAssignmentRevisions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListOSPolicyAssignmentRevisionsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/osPolicyAssignments/*}:listRevisions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListOSPolicyAssignmentRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListOSPolicyAssignmentRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListOSPolicyAssignmentRevisionsResponse>newBuilder()
                      .setDefaultInstance(
                          ListOSPolicyAssignmentRevisionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteOSPolicyAssignmentRequest, Operation>
      deleteOSPolicyAssignmentMethodDescriptor =
          ApiMethodDescriptor.<DeleteOSPolicyAssignmentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.osconfig.v1.OsConfigZonalService/DeleteOSPolicyAssignment")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteOSPolicyAssignmentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/osPolicyAssignments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteOSPolicyAssignmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteOSPolicyAssignmentRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (DeleteOSPolicyAssignmentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          GetOSPolicyAssignmentReportRequest, OSPolicyAssignmentReport>
      getOSPolicyAssignmentReportMethodDescriptor =
          ApiMethodDescriptor
              .<GetOSPolicyAssignmentReportRequest, OSPolicyAssignmentReport>newBuilder()
              .setFullMethodName(
                  "google.cloud.osconfig.v1.OsConfigZonalService/GetOSPolicyAssignmentReport")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetOSPolicyAssignmentReportRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/osPolicyAssignments/*/report}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetOSPolicyAssignmentReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetOSPolicyAssignmentReportRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<OSPolicyAssignmentReport>newBuilder()
                      .setDefaultInstance(OSPolicyAssignmentReport.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListOSPolicyAssignmentReportsRequest, ListOSPolicyAssignmentReportsResponse>
      listOSPolicyAssignmentReportsMethodDescriptor =
          ApiMethodDescriptor
              .<ListOSPolicyAssignmentReportsRequest, ListOSPolicyAssignmentReportsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.osconfig.v1.OsConfigZonalService/ListOSPolicyAssignmentReports")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListOSPolicyAssignmentReportsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*/osPolicyAssignments/*}/reports",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListOSPolicyAssignmentReportsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListOSPolicyAssignmentReportsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListOSPolicyAssignmentReportsResponse>newBuilder()
                      .setDefaultInstance(
                          ListOSPolicyAssignmentReportsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetInventoryRequest, Inventory>
      getInventoryMethodDescriptor =
          ApiMethodDescriptor.<GetInventoryRequest, Inventory>newBuilder()
              .setFullMethodName("google.cloud.osconfig.v1.OsConfigZonalService/GetInventory")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetInventoryRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/inventory}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetInventoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetInventoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getView());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Inventory>newBuilder()
                      .setDefaultInstance(Inventory.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListInventoriesRequest, ListInventoriesResponse>
      listInventoriesMethodDescriptor =
          ApiMethodDescriptor.<ListInventoriesRequest, ListInventoriesResponse>newBuilder()
              .setFullMethodName("google.cloud.osconfig.v1.OsConfigZonalService/ListInventories")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInventoriesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/inventories",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListInventoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListInventoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getView());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListInventoriesResponse>newBuilder()
                      .setDefaultInstance(ListInventoriesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetVulnerabilityReportRequest, VulnerabilityReport>
      getVulnerabilityReportMethodDescriptor =
          ApiMethodDescriptor.<GetVulnerabilityReportRequest, VulnerabilityReport>newBuilder()
              .setFullMethodName(
                  "google.cloud.osconfig.v1.OsConfigZonalService/GetVulnerabilityReport")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetVulnerabilityReportRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/vulnerabilityReport}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetVulnerabilityReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetVulnerabilityReportRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<VulnerabilityReport>newBuilder()
                      .setDefaultInstance(VulnerabilityReport.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListVulnerabilityReportsRequest, ListVulnerabilityReportsResponse>
      listVulnerabilityReportsMethodDescriptor =
          ApiMethodDescriptor
              .<ListVulnerabilityReportsRequest, ListVulnerabilityReportsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.osconfig.v1.OsConfigZonalService/ListVulnerabilityReports")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListVulnerabilityReportsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/vulnerabilityReports",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListVulnerabilityReportsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListVulnerabilityReportsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListVulnerabilityReportsResponse>newBuilder()
                      .setDefaultInstance(ListVulnerabilityReportsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateOSPolicyAssignmentRequest, Operation>
      createOSPolicyAssignmentCallable;
  private final OperationCallable<
          CreateOSPolicyAssignmentRequest, OSPolicyAssignment, OSPolicyAssignmentOperationMetadata>
      createOSPolicyAssignmentOperationCallable;
  private final UnaryCallable<UpdateOSPolicyAssignmentRequest, Operation>
      updateOSPolicyAssignmentCallable;
  private final OperationCallable<
          UpdateOSPolicyAssignmentRequest, OSPolicyAssignment, OSPolicyAssignmentOperationMetadata>
      updateOSPolicyAssignmentOperationCallable;
  private final UnaryCallable<GetOSPolicyAssignmentRequest, OSPolicyAssignment>
      getOSPolicyAssignmentCallable;
  private final UnaryCallable<ListOSPolicyAssignmentsRequest, ListOSPolicyAssignmentsResponse>
      listOSPolicyAssignmentsCallable;
  private final UnaryCallable<ListOSPolicyAssignmentsRequest, ListOSPolicyAssignmentsPagedResponse>
      listOSPolicyAssignmentsPagedCallable;
  private final UnaryCallable<
          ListOSPolicyAssignmentRevisionsRequest, ListOSPolicyAssignmentRevisionsResponse>
      listOSPolicyAssignmentRevisionsCallable;
  private final UnaryCallable<
          ListOSPolicyAssignmentRevisionsRequest, ListOSPolicyAssignmentRevisionsPagedResponse>
      listOSPolicyAssignmentRevisionsPagedCallable;
  private final UnaryCallable<DeleteOSPolicyAssignmentRequest, Operation>
      deleteOSPolicyAssignmentCallable;
  private final OperationCallable<
          DeleteOSPolicyAssignmentRequest, Empty, OSPolicyAssignmentOperationMetadata>
      deleteOSPolicyAssignmentOperationCallable;
  private final UnaryCallable<GetOSPolicyAssignmentReportRequest, OSPolicyAssignmentReport>
      getOSPolicyAssignmentReportCallable;
  private final UnaryCallable<
          ListOSPolicyAssignmentReportsRequest, ListOSPolicyAssignmentReportsResponse>
      listOSPolicyAssignmentReportsCallable;
  private final UnaryCallable<
          ListOSPolicyAssignmentReportsRequest, ListOSPolicyAssignmentReportsPagedResponse>
      listOSPolicyAssignmentReportsPagedCallable;
  private final UnaryCallable<GetInventoryRequest, Inventory> getInventoryCallable;
  private final UnaryCallable<ListInventoriesRequest, ListInventoriesResponse>
      listInventoriesCallable;
  private final UnaryCallable<ListInventoriesRequest, ListInventoriesPagedResponse>
      listInventoriesPagedCallable;
  private final UnaryCallable<GetVulnerabilityReportRequest, VulnerabilityReport>
      getVulnerabilityReportCallable;
  private final UnaryCallable<ListVulnerabilityReportsRequest, ListVulnerabilityReportsResponse>
      listVulnerabilityReportsCallable;
  private final UnaryCallable<
          ListVulnerabilityReportsRequest, ListVulnerabilityReportsPagedResponse>
      listVulnerabilityReportsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonOsConfigZonalServiceStub create(
      OsConfigZonalServiceStubSettings settings) throws IOException {
    return new HttpJsonOsConfigZonalServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonOsConfigZonalServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonOsConfigZonalServiceStub(
        OsConfigZonalServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonOsConfigZonalServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonOsConfigZonalServiceStub(
        OsConfigZonalServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonOsConfigZonalServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonOsConfigZonalServiceStub(
      OsConfigZonalServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonOsConfigZonalServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonOsConfigZonalServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonOsConfigZonalServiceStub(
      OsConfigZonalServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateOSPolicyAssignmentRequest, Operation>
        createOSPolicyAssignmentTransportSettings =
            HttpJsonCallSettings.<CreateOSPolicyAssignmentRequest, Operation>newBuilder()
                .setMethodDescriptor(createOSPolicyAssignmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateOSPolicyAssignmentRequest, Operation>
        updateOSPolicyAssignmentTransportSettings =
            HttpJsonCallSettings.<UpdateOSPolicyAssignmentRequest, Operation>newBuilder()
                .setMethodDescriptor(updateOSPolicyAssignmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetOSPolicyAssignmentRequest, OSPolicyAssignment>
        getOSPolicyAssignmentTransportSettings =
            HttpJsonCallSettings.<GetOSPolicyAssignmentRequest, OSPolicyAssignment>newBuilder()
                .setMethodDescriptor(getOSPolicyAssignmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListOSPolicyAssignmentsRequest, ListOSPolicyAssignmentsResponse>
        listOSPolicyAssignmentsTransportSettings =
            HttpJsonCallSettings
                .<ListOSPolicyAssignmentsRequest, ListOSPolicyAssignmentsResponse>newBuilder()
                .setMethodDescriptor(listOSPolicyAssignmentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            ListOSPolicyAssignmentRevisionsRequest, ListOSPolicyAssignmentRevisionsResponse>
        listOSPolicyAssignmentRevisionsTransportSettings =
            HttpJsonCallSettings
                .<ListOSPolicyAssignmentRevisionsRequest, ListOSPolicyAssignmentRevisionsResponse>
                    newBuilder()
                .setMethodDescriptor(listOSPolicyAssignmentRevisionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteOSPolicyAssignmentRequest, Operation>
        deleteOSPolicyAssignmentTransportSettings =
            HttpJsonCallSettings.<DeleteOSPolicyAssignmentRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteOSPolicyAssignmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetOSPolicyAssignmentReportRequest, OSPolicyAssignmentReport>
        getOSPolicyAssignmentReportTransportSettings =
            HttpJsonCallSettings
                .<GetOSPolicyAssignmentReportRequest, OSPolicyAssignmentReport>newBuilder()
                .setMethodDescriptor(getOSPolicyAssignmentReportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            ListOSPolicyAssignmentReportsRequest, ListOSPolicyAssignmentReportsResponse>
        listOSPolicyAssignmentReportsTransportSettings =
            HttpJsonCallSettings
                .<ListOSPolicyAssignmentReportsRequest, ListOSPolicyAssignmentReportsResponse>
                    newBuilder()
                .setMethodDescriptor(listOSPolicyAssignmentReportsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetInventoryRequest, Inventory> getInventoryTransportSettings =
        HttpJsonCallSettings.<GetInventoryRequest, Inventory>newBuilder()
            .setMethodDescriptor(getInventoryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListInventoriesRequest, ListInventoriesResponse>
        listInventoriesTransportSettings =
            HttpJsonCallSettings.<ListInventoriesRequest, ListInventoriesResponse>newBuilder()
                .setMethodDescriptor(listInventoriesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetVulnerabilityReportRequest, VulnerabilityReport>
        getVulnerabilityReportTransportSettings =
            HttpJsonCallSettings.<GetVulnerabilityReportRequest, VulnerabilityReport>newBuilder()
                .setMethodDescriptor(getVulnerabilityReportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListVulnerabilityReportsRequest, ListVulnerabilityReportsResponse>
        listVulnerabilityReportsTransportSettings =
            HttpJsonCallSettings
                .<ListVulnerabilityReportsRequest, ListVulnerabilityReportsResponse>newBuilder()
                .setMethodDescriptor(listVulnerabilityReportsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.createOSPolicyAssignmentCallable =
        callableFactory.createUnaryCallable(
            createOSPolicyAssignmentTransportSettings,
            settings.createOSPolicyAssignmentSettings(),
            clientContext);
    this.createOSPolicyAssignmentOperationCallable =
        callableFactory.createOperationCallable(
            createOSPolicyAssignmentTransportSettings,
            settings.createOSPolicyAssignmentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateOSPolicyAssignmentCallable =
        callableFactory.createUnaryCallable(
            updateOSPolicyAssignmentTransportSettings,
            settings.updateOSPolicyAssignmentSettings(),
            clientContext);
    this.updateOSPolicyAssignmentOperationCallable =
        callableFactory.createOperationCallable(
            updateOSPolicyAssignmentTransportSettings,
            settings.updateOSPolicyAssignmentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getOSPolicyAssignmentCallable =
        callableFactory.createUnaryCallable(
            getOSPolicyAssignmentTransportSettings,
            settings.getOSPolicyAssignmentSettings(),
            clientContext);
    this.listOSPolicyAssignmentsCallable =
        callableFactory.createUnaryCallable(
            listOSPolicyAssignmentsTransportSettings,
            settings.listOSPolicyAssignmentsSettings(),
            clientContext);
    this.listOSPolicyAssignmentsPagedCallable =
        callableFactory.createPagedCallable(
            listOSPolicyAssignmentsTransportSettings,
            settings.listOSPolicyAssignmentsSettings(),
            clientContext);
    this.listOSPolicyAssignmentRevisionsCallable =
        callableFactory.createUnaryCallable(
            listOSPolicyAssignmentRevisionsTransportSettings,
            settings.listOSPolicyAssignmentRevisionsSettings(),
            clientContext);
    this.listOSPolicyAssignmentRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listOSPolicyAssignmentRevisionsTransportSettings,
            settings.listOSPolicyAssignmentRevisionsSettings(),
            clientContext);
    this.deleteOSPolicyAssignmentCallable =
        callableFactory.createUnaryCallable(
            deleteOSPolicyAssignmentTransportSettings,
            settings.deleteOSPolicyAssignmentSettings(),
            clientContext);
    this.deleteOSPolicyAssignmentOperationCallable =
        callableFactory.createOperationCallable(
            deleteOSPolicyAssignmentTransportSettings,
            settings.deleteOSPolicyAssignmentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getOSPolicyAssignmentReportCallable =
        callableFactory.createUnaryCallable(
            getOSPolicyAssignmentReportTransportSettings,
            settings.getOSPolicyAssignmentReportSettings(),
            clientContext);
    this.listOSPolicyAssignmentReportsCallable =
        callableFactory.createUnaryCallable(
            listOSPolicyAssignmentReportsTransportSettings,
            settings.listOSPolicyAssignmentReportsSettings(),
            clientContext);
    this.listOSPolicyAssignmentReportsPagedCallable =
        callableFactory.createPagedCallable(
            listOSPolicyAssignmentReportsTransportSettings,
            settings.listOSPolicyAssignmentReportsSettings(),
            clientContext);
    this.getInventoryCallable =
        callableFactory.createUnaryCallable(
            getInventoryTransportSettings, settings.getInventorySettings(), clientContext);
    this.listInventoriesCallable =
        callableFactory.createUnaryCallable(
            listInventoriesTransportSettings, settings.listInventoriesSettings(), clientContext);
    this.listInventoriesPagedCallable =
        callableFactory.createPagedCallable(
            listInventoriesTransportSettings, settings.listInventoriesSettings(), clientContext);
    this.getVulnerabilityReportCallable =
        callableFactory.createUnaryCallable(
            getVulnerabilityReportTransportSettings,
            settings.getVulnerabilityReportSettings(),
            clientContext);
    this.listVulnerabilityReportsCallable =
        callableFactory.createUnaryCallable(
            listVulnerabilityReportsTransportSettings,
            settings.listVulnerabilityReportsSettings(),
            clientContext);
    this.listVulnerabilityReportsPagedCallable =
        callableFactory.createPagedCallable(
            listVulnerabilityReportsTransportSettings,
            settings.listVulnerabilityReportsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createOSPolicyAssignmentMethodDescriptor);
    methodDescriptors.add(updateOSPolicyAssignmentMethodDescriptor);
    methodDescriptors.add(getOSPolicyAssignmentMethodDescriptor);
    methodDescriptors.add(listOSPolicyAssignmentsMethodDescriptor);
    methodDescriptors.add(listOSPolicyAssignmentRevisionsMethodDescriptor);
    methodDescriptors.add(deleteOSPolicyAssignmentMethodDescriptor);
    methodDescriptors.add(getOSPolicyAssignmentReportMethodDescriptor);
    methodDescriptors.add(listOSPolicyAssignmentReportsMethodDescriptor);
    methodDescriptors.add(getInventoryMethodDescriptor);
    methodDescriptors.add(listInventoriesMethodDescriptor);
    methodDescriptors.add(getVulnerabilityReportMethodDescriptor);
    methodDescriptors.add(listVulnerabilityReportsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateOSPolicyAssignmentRequest, Operation>
      createOSPolicyAssignmentCallable() {
    return createOSPolicyAssignmentCallable;
  }

  @Override
  public OperationCallable<
          CreateOSPolicyAssignmentRequest, OSPolicyAssignment, OSPolicyAssignmentOperationMetadata>
      createOSPolicyAssignmentOperationCallable() {
    return createOSPolicyAssignmentOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateOSPolicyAssignmentRequest, Operation>
      updateOSPolicyAssignmentCallable() {
    return updateOSPolicyAssignmentCallable;
  }

  @Override
  public OperationCallable<
          UpdateOSPolicyAssignmentRequest, OSPolicyAssignment, OSPolicyAssignmentOperationMetadata>
      updateOSPolicyAssignmentOperationCallable() {
    return updateOSPolicyAssignmentOperationCallable;
  }

  @Override
  public UnaryCallable<GetOSPolicyAssignmentRequest, OSPolicyAssignment>
      getOSPolicyAssignmentCallable() {
    return getOSPolicyAssignmentCallable;
  }

  @Override
  public UnaryCallable<ListOSPolicyAssignmentsRequest, ListOSPolicyAssignmentsResponse>
      listOSPolicyAssignmentsCallable() {
    return listOSPolicyAssignmentsCallable;
  }

  @Override
  public UnaryCallable<ListOSPolicyAssignmentsRequest, ListOSPolicyAssignmentsPagedResponse>
      listOSPolicyAssignmentsPagedCallable() {
    return listOSPolicyAssignmentsPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListOSPolicyAssignmentRevisionsRequest, ListOSPolicyAssignmentRevisionsResponse>
      listOSPolicyAssignmentRevisionsCallable() {
    return listOSPolicyAssignmentRevisionsCallable;
  }

  @Override
  public UnaryCallable<
          ListOSPolicyAssignmentRevisionsRequest, ListOSPolicyAssignmentRevisionsPagedResponse>
      listOSPolicyAssignmentRevisionsPagedCallable() {
    return listOSPolicyAssignmentRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteOSPolicyAssignmentRequest, Operation>
      deleteOSPolicyAssignmentCallable() {
    return deleteOSPolicyAssignmentCallable;
  }

  @Override
  public OperationCallable<
          DeleteOSPolicyAssignmentRequest, Empty, OSPolicyAssignmentOperationMetadata>
      deleteOSPolicyAssignmentOperationCallable() {
    return deleteOSPolicyAssignmentOperationCallable;
  }

  @Override
  public UnaryCallable<GetOSPolicyAssignmentReportRequest, OSPolicyAssignmentReport>
      getOSPolicyAssignmentReportCallable() {
    return getOSPolicyAssignmentReportCallable;
  }

  @Override
  public UnaryCallable<ListOSPolicyAssignmentReportsRequest, ListOSPolicyAssignmentReportsResponse>
      listOSPolicyAssignmentReportsCallable() {
    return listOSPolicyAssignmentReportsCallable;
  }

  @Override
  public UnaryCallable<
          ListOSPolicyAssignmentReportsRequest, ListOSPolicyAssignmentReportsPagedResponse>
      listOSPolicyAssignmentReportsPagedCallable() {
    return listOSPolicyAssignmentReportsPagedCallable;
  }

  @Override
  public UnaryCallable<GetInventoryRequest, Inventory> getInventoryCallable() {
    return getInventoryCallable;
  }

  @Override
  public UnaryCallable<ListInventoriesRequest, ListInventoriesResponse> listInventoriesCallable() {
    return listInventoriesCallable;
  }

  @Override
  public UnaryCallable<ListInventoriesRequest, ListInventoriesPagedResponse>
      listInventoriesPagedCallable() {
    return listInventoriesPagedCallable;
  }

  @Override
  public UnaryCallable<GetVulnerabilityReportRequest, VulnerabilityReport>
      getVulnerabilityReportCallable() {
    return getVulnerabilityReportCallable;
  }

  @Override
  public UnaryCallable<ListVulnerabilityReportsRequest, ListVulnerabilityReportsResponse>
      listVulnerabilityReportsCallable() {
    return listVulnerabilityReportsCallable;
  }

  @Override
  public UnaryCallable<ListVulnerabilityReportsRequest, ListVulnerabilityReportsPagedResponse>
      listVulnerabilityReportsPagedCallable() {
    return listVulnerabilityReportsPagedCallable;
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
