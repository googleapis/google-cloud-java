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

package com.google.cloud.vmmigration.v1.stub;

import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListCloneJobsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListCutoverJobsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListDatacenterConnectorsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListGroupsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListMigratingVmsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListSourcesPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListTargetProjectsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListUtilizationReportsPagedResponse;

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
import com.google.cloud.vmmigration.v1.AddGroupMigrationRequest;
import com.google.cloud.vmmigration.v1.AddGroupMigrationResponse;
import com.google.cloud.vmmigration.v1.CancelCloneJobRequest;
import com.google.cloud.vmmigration.v1.CancelCloneJobResponse;
import com.google.cloud.vmmigration.v1.CancelCutoverJobRequest;
import com.google.cloud.vmmigration.v1.CancelCutoverJobResponse;
import com.google.cloud.vmmigration.v1.CloneJob;
import com.google.cloud.vmmigration.v1.CreateCloneJobRequest;
import com.google.cloud.vmmigration.v1.CreateCutoverJobRequest;
import com.google.cloud.vmmigration.v1.CreateDatacenterConnectorRequest;
import com.google.cloud.vmmigration.v1.CreateGroupRequest;
import com.google.cloud.vmmigration.v1.CreateMigratingVmRequest;
import com.google.cloud.vmmigration.v1.CreateSourceRequest;
import com.google.cloud.vmmigration.v1.CreateTargetProjectRequest;
import com.google.cloud.vmmigration.v1.CreateUtilizationReportRequest;
import com.google.cloud.vmmigration.v1.CutoverJob;
import com.google.cloud.vmmigration.v1.DatacenterConnector;
import com.google.cloud.vmmigration.v1.DeleteDatacenterConnectorRequest;
import com.google.cloud.vmmigration.v1.DeleteGroupRequest;
import com.google.cloud.vmmigration.v1.DeleteMigratingVmRequest;
import com.google.cloud.vmmigration.v1.DeleteSourceRequest;
import com.google.cloud.vmmigration.v1.DeleteTargetProjectRequest;
import com.google.cloud.vmmigration.v1.DeleteUtilizationReportRequest;
import com.google.cloud.vmmigration.v1.FetchInventoryRequest;
import com.google.cloud.vmmigration.v1.FetchInventoryResponse;
import com.google.cloud.vmmigration.v1.FinalizeMigrationRequest;
import com.google.cloud.vmmigration.v1.FinalizeMigrationResponse;
import com.google.cloud.vmmigration.v1.GetCloneJobRequest;
import com.google.cloud.vmmigration.v1.GetCutoverJobRequest;
import com.google.cloud.vmmigration.v1.GetDatacenterConnectorRequest;
import com.google.cloud.vmmigration.v1.GetGroupRequest;
import com.google.cloud.vmmigration.v1.GetMigratingVmRequest;
import com.google.cloud.vmmigration.v1.GetSourceRequest;
import com.google.cloud.vmmigration.v1.GetTargetProjectRequest;
import com.google.cloud.vmmigration.v1.GetUtilizationReportRequest;
import com.google.cloud.vmmigration.v1.Group;
import com.google.cloud.vmmigration.v1.ListCloneJobsRequest;
import com.google.cloud.vmmigration.v1.ListCloneJobsResponse;
import com.google.cloud.vmmigration.v1.ListCutoverJobsRequest;
import com.google.cloud.vmmigration.v1.ListCutoverJobsResponse;
import com.google.cloud.vmmigration.v1.ListDatacenterConnectorsRequest;
import com.google.cloud.vmmigration.v1.ListDatacenterConnectorsResponse;
import com.google.cloud.vmmigration.v1.ListGroupsRequest;
import com.google.cloud.vmmigration.v1.ListGroupsResponse;
import com.google.cloud.vmmigration.v1.ListMigratingVmsRequest;
import com.google.cloud.vmmigration.v1.ListMigratingVmsResponse;
import com.google.cloud.vmmigration.v1.ListSourcesRequest;
import com.google.cloud.vmmigration.v1.ListSourcesResponse;
import com.google.cloud.vmmigration.v1.ListTargetProjectsRequest;
import com.google.cloud.vmmigration.v1.ListTargetProjectsResponse;
import com.google.cloud.vmmigration.v1.ListUtilizationReportsRequest;
import com.google.cloud.vmmigration.v1.ListUtilizationReportsResponse;
import com.google.cloud.vmmigration.v1.MigratingVm;
import com.google.cloud.vmmigration.v1.OperationMetadata;
import com.google.cloud.vmmigration.v1.PauseMigrationRequest;
import com.google.cloud.vmmigration.v1.PauseMigrationResponse;
import com.google.cloud.vmmigration.v1.RemoveGroupMigrationRequest;
import com.google.cloud.vmmigration.v1.RemoveGroupMigrationResponse;
import com.google.cloud.vmmigration.v1.ResumeMigrationRequest;
import com.google.cloud.vmmigration.v1.ResumeMigrationResponse;
import com.google.cloud.vmmigration.v1.Source;
import com.google.cloud.vmmigration.v1.StartMigrationRequest;
import com.google.cloud.vmmigration.v1.StartMigrationResponse;
import com.google.cloud.vmmigration.v1.TargetProject;
import com.google.cloud.vmmigration.v1.UpdateGroupRequest;
import com.google.cloud.vmmigration.v1.UpdateMigratingVmRequest;
import com.google.cloud.vmmigration.v1.UpdateSourceRequest;
import com.google.cloud.vmmigration.v1.UpdateTargetProjectRequest;
import com.google.cloud.vmmigration.v1.UpgradeApplianceRequest;
import com.google.cloud.vmmigration.v1.UpgradeApplianceResponse;
import com.google.cloud.vmmigration.v1.UtilizationReport;
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
 * REST stub implementation for the VmMigration service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonVmMigrationStub extends VmMigrationStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(DatacenterConnector.getDescriptor())
          .add(MigratingVm.getDescriptor())
          .add(ResumeMigrationResponse.getDescriptor())
          .add(UtilizationReport.getDescriptor())
          .add(CutoverJob.getDescriptor())
          .add(CancelCloneJobResponse.getDescriptor())
          .add(FinalizeMigrationResponse.getDescriptor())
          .add(RemoveGroupMigrationResponse.getDescriptor())
          .add(Empty.getDescriptor())
          .add(TargetProject.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(CancelCutoverJobResponse.getDescriptor())
          .add(Source.getDescriptor())
          .add(CloneJob.getDescriptor())
          .add(AddGroupMigrationResponse.getDescriptor())
          .add(Group.getDescriptor())
          .add(StartMigrationResponse.getDescriptor())
          .add(UpgradeApplianceResponse.getDescriptor())
          .add(PauseMigrationResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListSourcesRequest, ListSourcesResponse>
      listSourcesMethodDescriptor =
          ApiMethodDescriptor.<ListSourcesRequest, ListSourcesResponse>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/ListSources")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSourcesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/sources",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSourcesResponse>newBuilder()
                      .setDefaultInstance(ListSourcesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSourceRequest, Source> getSourceMethodDescriptor =
      ApiMethodDescriptor.<GetSourceRequest, Source>newBuilder()
          .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/GetSource")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSourceRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/sources/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetSourceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetSourceRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Source>newBuilder()
                  .setDefaultInstance(Source.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateSourceRequest, Operation>
      createSourceMethodDescriptor =
          ApiMethodDescriptor.<CreateSourceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/CreateSource")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSourceRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/sources",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "sourceId", request.getSourceId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("source", request.getSource(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateSourceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateSourceRequest, Operation>
      updateSourceMethodDescriptor =
          ApiMethodDescriptor.<UpdateSourceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/UpdateSource")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSourceRequest>newBuilder()
                      .setPath(
                          "/v1/{source.name=projects/*/locations/*/sources/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "source.name", request.getSource().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("source", request.getSource(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateSourceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteSourceRequest, Operation>
      deleteSourceMethodDescriptor =
          ApiMethodDescriptor.<DeleteSourceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/DeleteSource")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSourceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/sources/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSourceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteSourceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<FetchInventoryRequest, FetchInventoryResponse>
      fetchInventoryMethodDescriptor =
          ApiMethodDescriptor.<FetchInventoryRequest, FetchInventoryResponse>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/FetchInventory")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchInventoryRequest>newBuilder()
                      .setPath(
                          "/v1/{source=projects/*/locations/*/sources/*}:fetchInventory",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchInventoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "source", request.getSource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchInventoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "forceRefresh", request.getForceRefresh());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchInventoryResponse>newBuilder()
                      .setDefaultInstance(FetchInventoryResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListUtilizationReportsRequest, ListUtilizationReportsResponse>
      listUtilizationReportsMethodDescriptor =
          ApiMethodDescriptor
              .<ListUtilizationReportsRequest, ListUtilizationReportsResponse>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/ListUtilizationReports")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListUtilizationReportsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/sources/*}/utilizationReports",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListUtilizationReportsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListUtilizationReportsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getView());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListUtilizationReportsResponse>newBuilder()
                      .setDefaultInstance(ListUtilizationReportsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetUtilizationReportRequest, UtilizationReport>
      getUtilizationReportMethodDescriptor =
          ApiMethodDescriptor.<GetUtilizationReportRequest, UtilizationReport>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/GetUtilizationReport")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetUtilizationReportRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/sources/*/utilizationReports/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetUtilizationReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetUtilizationReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getView());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UtilizationReport>newBuilder()
                      .setDefaultInstance(UtilizationReport.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateUtilizationReportRequest, Operation>
      createUtilizationReportMethodDescriptor =
          ApiMethodDescriptor.<CreateUtilizationReportRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/CreateUtilizationReport")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateUtilizationReportRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/sources/*}/utilizationReports",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUtilizationReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUtilizationReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "utilizationReportId", request.getUtilizationReportId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "utilizationReport", request.getUtilizationReport(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateUtilizationReportRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteUtilizationReportRequest, Operation>
      deleteUtilizationReportMethodDescriptor =
          ApiMethodDescriptor.<DeleteUtilizationReportRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/DeleteUtilizationReport")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteUtilizationReportRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/sources/*/utilizationReports/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteUtilizationReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteUtilizationReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteUtilizationReportRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListDatacenterConnectorsRequest, ListDatacenterConnectorsResponse>
      listDatacenterConnectorsMethodDescriptor =
          ApiMethodDescriptor
              .<ListDatacenterConnectorsRequest, ListDatacenterConnectorsResponse>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/ListDatacenterConnectors")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDatacenterConnectorsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/sources/*}/datacenterConnectors",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDatacenterConnectorsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDatacenterConnectorsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDatacenterConnectorsResponse>newBuilder()
                      .setDefaultInstance(ListDatacenterConnectorsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDatacenterConnectorRequest, DatacenterConnector>
      getDatacenterConnectorMethodDescriptor =
          ApiMethodDescriptor.<GetDatacenterConnectorRequest, DatacenterConnector>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/GetDatacenterConnector")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDatacenterConnectorRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/sources/*/datacenterConnectors/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDatacenterConnectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDatacenterConnectorRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DatacenterConnector>newBuilder()
                      .setDefaultInstance(DatacenterConnector.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDatacenterConnectorRequest, Operation>
      createDatacenterConnectorMethodDescriptor =
          ApiMethodDescriptor.<CreateDatacenterConnectorRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.vmmigration.v1.VmMigration/CreateDatacenterConnector")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDatacenterConnectorRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/sources/*}/datacenterConnectors",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDatacenterConnectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDatacenterConnectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "datacenterConnectorId",
                                request.getDatacenterConnectorId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "datacenterConnector",
                                      request.getDatacenterConnector(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateDatacenterConnectorRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteDatacenterConnectorRequest, Operation>
      deleteDatacenterConnectorMethodDescriptor =
          ApiMethodDescriptor.<DeleteDatacenterConnectorRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.vmmigration.v1.VmMigration/DeleteDatacenterConnector")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDatacenterConnectorRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/sources/*/datacenterConnectors/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDatacenterConnectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDatacenterConnectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteDatacenterConnectorRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpgradeApplianceRequest, Operation>
      upgradeApplianceMethodDescriptor =
          ApiMethodDescriptor.<UpgradeApplianceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/UpgradeAppliance")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpgradeApplianceRequest>newBuilder()
                      .setPath(
                          "/v1/{datacenterConnector=projects/*/locations/*/sources/*/datacenterConnectors/*}:upgradeAppliance",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpgradeApplianceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "datacenterConnector", request.getDatacenterConnector());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpgradeApplianceRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearDatacenterConnector().build(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpgradeApplianceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateMigratingVmRequest, Operation>
      createMigratingVmMethodDescriptor =
          ApiMethodDescriptor.<CreateMigratingVmRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/CreateMigratingVm")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateMigratingVmRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/sources/*}/migratingVms",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMigratingVmRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMigratingVmRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "migratingVmId", request.getMigratingVmId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("migratingVm", request.getMigratingVm(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateMigratingVmRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListMigratingVmsRequest, ListMigratingVmsResponse>
      listMigratingVmsMethodDescriptor =
          ApiMethodDescriptor.<ListMigratingVmsRequest, ListMigratingVmsResponse>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/ListMigratingVms")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMigratingVmsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/sources/*}/migratingVms",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMigratingVmsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMigratingVmsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getView());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListMigratingVmsResponse>newBuilder()
                      .setDefaultInstance(ListMigratingVmsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetMigratingVmRequest, MigratingVm>
      getMigratingVmMethodDescriptor =
          ApiMethodDescriptor.<GetMigratingVmRequest, MigratingVm>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/GetMigratingVm")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetMigratingVmRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/sources/*/migratingVms/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetMigratingVmRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetMigratingVmRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getView());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<MigratingVm>newBuilder()
                      .setDefaultInstance(MigratingVm.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateMigratingVmRequest, Operation>
      updateMigratingVmMethodDescriptor =
          ApiMethodDescriptor.<UpdateMigratingVmRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/UpdateMigratingVm")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateMigratingVmRequest>newBuilder()
                      .setPath(
                          "/v1/{migratingVm.name=projects/*/locations/*/sources/*/migratingVms/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMigratingVmRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "migratingVm.name", request.getMigratingVm().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMigratingVmRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("migratingVm", request.getMigratingVm(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateMigratingVmRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteMigratingVmRequest, Operation>
      deleteMigratingVmMethodDescriptor =
          ApiMethodDescriptor.<DeleteMigratingVmRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/DeleteMigratingVm")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteMigratingVmRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/sources/*/migratingVms/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMigratingVmRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMigratingVmRequest> serializer =
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
                  (DeleteMigratingVmRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<StartMigrationRequest, Operation>
      startMigrationMethodDescriptor =
          ApiMethodDescriptor.<StartMigrationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/StartMigration")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StartMigrationRequest>newBuilder()
                      .setPath(
                          "/v1/{migratingVm=projects/*/locations/*/sources/*/migratingVms/*}:startMigration",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StartMigrationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "migratingVm", request.getMigratingVm());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StartMigrationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearMigratingVm().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (StartMigrationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ResumeMigrationRequest, Operation>
      resumeMigrationMethodDescriptor =
          ApiMethodDescriptor.<ResumeMigrationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/ResumeMigration")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResumeMigrationRequest>newBuilder()
                      .setPath(
                          "/v1/{migratingVm=projects/*/locations/*/sources/*/migratingVms/*}:resumeMigration",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ResumeMigrationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "migratingVm", request.getMigratingVm());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ResumeMigrationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearMigratingVm().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ResumeMigrationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<PauseMigrationRequest, Operation>
      pauseMigrationMethodDescriptor =
          ApiMethodDescriptor.<PauseMigrationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/PauseMigration")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PauseMigrationRequest>newBuilder()
                      .setPath(
                          "/v1/{migratingVm=projects/*/locations/*/sources/*/migratingVms/*}:pauseMigration",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PauseMigrationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "migratingVm", request.getMigratingVm());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PauseMigrationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearMigratingVm().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PauseMigrationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<FinalizeMigrationRequest, Operation>
      finalizeMigrationMethodDescriptor =
          ApiMethodDescriptor.<FinalizeMigrationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/FinalizeMigration")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FinalizeMigrationRequest>newBuilder()
                      .setPath(
                          "/v1/{migratingVm=projects/*/locations/*/sources/*/migratingVms/*}:finalizeMigration",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FinalizeMigrationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "migratingVm", request.getMigratingVm());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FinalizeMigrationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearMigratingVm().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (FinalizeMigrationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateCloneJobRequest, Operation>
      createCloneJobMethodDescriptor =
          ApiMethodDescriptor.<CreateCloneJobRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/CreateCloneJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCloneJobRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/sources/*/migratingVms/*}/cloneJobs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCloneJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCloneJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "cloneJobId", request.getCloneJobId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("cloneJob", request.getCloneJob(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateCloneJobRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CancelCloneJobRequest, Operation>
      cancelCloneJobMethodDescriptor =
          ApiMethodDescriptor.<CancelCloneJobRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/CancelCloneJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CancelCloneJobRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/sources/*/migratingVms/*/cloneJobs/*}:cancel",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CancelCloneJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CancelCloneJobRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CancelCloneJobRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListCloneJobsRequest, ListCloneJobsResponse>
      listCloneJobsMethodDescriptor =
          ApiMethodDescriptor.<ListCloneJobsRequest, ListCloneJobsResponse>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/ListCloneJobs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCloneJobsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/sources/*/migratingVms/*}/cloneJobs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCloneJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCloneJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCloneJobsResponse>newBuilder()
                      .setDefaultInstance(ListCloneJobsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCloneJobRequest, CloneJob>
      getCloneJobMethodDescriptor =
          ApiMethodDescriptor.<GetCloneJobRequest, CloneJob>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/GetCloneJob")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCloneJobRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/sources/*/migratingVms/*/cloneJobs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCloneJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCloneJobRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CloneJob>newBuilder()
                      .setDefaultInstance(CloneJob.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCutoverJobRequest, Operation>
      createCutoverJobMethodDescriptor =
          ApiMethodDescriptor.<CreateCutoverJobRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/CreateCutoverJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCutoverJobRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/sources/*/migratingVms/*}/cutoverJobs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCutoverJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCutoverJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "cutoverJobId", request.getCutoverJobId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("cutoverJob", request.getCutoverJob(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateCutoverJobRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CancelCutoverJobRequest, Operation>
      cancelCutoverJobMethodDescriptor =
          ApiMethodDescriptor.<CancelCutoverJobRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/CancelCutoverJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CancelCutoverJobRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/sources/*/migratingVms/*/cutoverJobs/*}:cancel",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CancelCutoverJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CancelCutoverJobRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CancelCutoverJobRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListCutoverJobsRequest, ListCutoverJobsResponse>
      listCutoverJobsMethodDescriptor =
          ApiMethodDescriptor.<ListCutoverJobsRequest, ListCutoverJobsResponse>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/ListCutoverJobs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCutoverJobsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/sources/*/migratingVms/*}/cutoverJobs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCutoverJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCutoverJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCutoverJobsResponse>newBuilder()
                      .setDefaultInstance(ListCutoverJobsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCutoverJobRequest, CutoverJob>
      getCutoverJobMethodDescriptor =
          ApiMethodDescriptor.<GetCutoverJobRequest, CutoverJob>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/GetCutoverJob")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCutoverJobRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/sources/*/migratingVms/*/cutoverJobs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCutoverJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCutoverJobRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CutoverJob>newBuilder()
                      .setDefaultInstance(CutoverJob.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListGroupsRequest, ListGroupsResponse>
      listGroupsMethodDescriptor =
          ApiMethodDescriptor.<ListGroupsRequest, ListGroupsResponse>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/ListGroups")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGroupsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/groups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListGroupsResponse>newBuilder()
                      .setDefaultInstance(ListGroupsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetGroupRequest, Group> getGroupMethodDescriptor =
      ApiMethodDescriptor.<GetGroupRequest, Group>newBuilder()
          .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/GetGroup")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetGroupRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/groups/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetGroupRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetGroupRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Group>newBuilder()
                  .setDefaultInstance(Group.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateGroupRequest, Operation>
      createGroupMethodDescriptor =
          ApiMethodDescriptor.<CreateGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/CreateGroup")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/groups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "groupId", request.getGroupId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("group", request.getGroup(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateGroupRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateGroupRequest, Operation>
      updateGroupMethodDescriptor =
          ApiMethodDescriptor.<UpdateGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/UpdateGroup")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{group.name=projects/*/locations/*/groups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "group.name", request.getGroup().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("group", request.getGroup(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateGroupRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteGroupRequest, Operation>
      deleteGroupMethodDescriptor =
          ApiMethodDescriptor.<DeleteGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/DeleteGroup")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/groups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteGroupRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<AddGroupMigrationRequest, Operation>
      addGroupMigrationMethodDescriptor =
          ApiMethodDescriptor.<AddGroupMigrationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/AddGroupMigration")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddGroupMigrationRequest>newBuilder()
                      .setPath(
                          "/v1/{group=projects/*/locations/*/groups/*}:addGroupMigration",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddGroupMigrationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "group", request.getGroup());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddGroupMigrationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearGroup().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AddGroupMigrationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RemoveGroupMigrationRequest, Operation>
      removeGroupMigrationMethodDescriptor =
          ApiMethodDescriptor.<RemoveGroupMigrationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/RemoveGroupMigration")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveGroupMigrationRequest>newBuilder()
                      .setPath(
                          "/v1/{group=projects/*/locations/*/groups/*}:removeGroupMigration",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveGroupMigrationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "group", request.getGroup());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveGroupMigrationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearGroup().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RemoveGroupMigrationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListTargetProjectsRequest, ListTargetProjectsResponse>
      listTargetProjectsMethodDescriptor =
          ApiMethodDescriptor.<ListTargetProjectsRequest, ListTargetProjectsResponse>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/ListTargetProjects")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTargetProjectsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/targetProjects",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTargetProjectsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTargetProjectsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTargetProjectsResponse>newBuilder()
                      .setDefaultInstance(ListTargetProjectsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTargetProjectRequest, TargetProject>
      getTargetProjectMethodDescriptor =
          ApiMethodDescriptor.<GetTargetProjectRequest, TargetProject>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/GetTargetProject")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTargetProjectRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/targetProjects/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTargetProjectRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTargetProjectRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetProject>newBuilder()
                      .setDefaultInstance(TargetProject.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateTargetProjectRequest, Operation>
      createTargetProjectMethodDescriptor =
          ApiMethodDescriptor.<CreateTargetProjectRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/CreateTargetProject")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateTargetProjectRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/targetProjects",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTargetProjectRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTargetProjectRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "targetProjectId", request.getTargetProjectId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("targetProject", request.getTargetProject(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateTargetProjectRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateTargetProjectRequest, Operation>
      updateTargetProjectMethodDescriptor =
          ApiMethodDescriptor.<UpdateTargetProjectRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/UpdateTargetProject")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateTargetProjectRequest>newBuilder()
                      .setPath(
                          "/v1/{targetProject.name=projects/*/locations/*/targetProjects/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTargetProjectRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "targetProject.name", request.getTargetProject().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTargetProjectRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("targetProject", request.getTargetProject(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateTargetProjectRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteTargetProjectRequest, Operation>
      deleteTargetProjectMethodDescriptor =
          ApiMethodDescriptor.<DeleteTargetProjectRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/DeleteTargetProject")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTargetProjectRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/targetProjects/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTargetProjectRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTargetProjectRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteTargetProjectRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<ListSourcesRequest, ListSourcesResponse> listSourcesCallable;
  private final UnaryCallable<ListSourcesRequest, ListSourcesPagedResponse>
      listSourcesPagedCallable;
  private final UnaryCallable<GetSourceRequest, Source> getSourceCallable;
  private final UnaryCallable<CreateSourceRequest, Operation> createSourceCallable;
  private final OperationCallable<CreateSourceRequest, Source, OperationMetadata>
      createSourceOperationCallable;
  private final UnaryCallable<UpdateSourceRequest, Operation> updateSourceCallable;
  private final OperationCallable<UpdateSourceRequest, Source, OperationMetadata>
      updateSourceOperationCallable;
  private final UnaryCallable<DeleteSourceRequest, Operation> deleteSourceCallable;
  private final OperationCallable<DeleteSourceRequest, Empty, OperationMetadata>
      deleteSourceOperationCallable;
  private final UnaryCallable<FetchInventoryRequest, FetchInventoryResponse> fetchInventoryCallable;
  private final UnaryCallable<ListUtilizationReportsRequest, ListUtilizationReportsResponse>
      listUtilizationReportsCallable;
  private final UnaryCallable<ListUtilizationReportsRequest, ListUtilizationReportsPagedResponse>
      listUtilizationReportsPagedCallable;
  private final UnaryCallable<GetUtilizationReportRequest, UtilizationReport>
      getUtilizationReportCallable;
  private final UnaryCallable<CreateUtilizationReportRequest, Operation>
      createUtilizationReportCallable;
  private final OperationCallable<
          CreateUtilizationReportRequest, UtilizationReport, OperationMetadata>
      createUtilizationReportOperationCallable;
  private final UnaryCallable<DeleteUtilizationReportRequest, Operation>
      deleteUtilizationReportCallable;
  private final OperationCallable<DeleteUtilizationReportRequest, Empty, OperationMetadata>
      deleteUtilizationReportOperationCallable;
  private final UnaryCallable<ListDatacenterConnectorsRequest, ListDatacenterConnectorsResponse>
      listDatacenterConnectorsCallable;
  private final UnaryCallable<
          ListDatacenterConnectorsRequest, ListDatacenterConnectorsPagedResponse>
      listDatacenterConnectorsPagedCallable;
  private final UnaryCallable<GetDatacenterConnectorRequest, DatacenterConnector>
      getDatacenterConnectorCallable;
  private final UnaryCallable<CreateDatacenterConnectorRequest, Operation>
      createDatacenterConnectorCallable;
  private final OperationCallable<
          CreateDatacenterConnectorRequest, DatacenterConnector, OperationMetadata>
      createDatacenterConnectorOperationCallable;
  private final UnaryCallable<DeleteDatacenterConnectorRequest, Operation>
      deleteDatacenterConnectorCallable;
  private final OperationCallable<DeleteDatacenterConnectorRequest, Empty, OperationMetadata>
      deleteDatacenterConnectorOperationCallable;
  private final UnaryCallable<UpgradeApplianceRequest, Operation> upgradeApplianceCallable;
  private final OperationCallable<
          UpgradeApplianceRequest, UpgradeApplianceResponse, OperationMetadata>
      upgradeApplianceOperationCallable;
  private final UnaryCallable<CreateMigratingVmRequest, Operation> createMigratingVmCallable;
  private final OperationCallable<CreateMigratingVmRequest, MigratingVm, OperationMetadata>
      createMigratingVmOperationCallable;
  private final UnaryCallable<ListMigratingVmsRequest, ListMigratingVmsResponse>
      listMigratingVmsCallable;
  private final UnaryCallable<ListMigratingVmsRequest, ListMigratingVmsPagedResponse>
      listMigratingVmsPagedCallable;
  private final UnaryCallable<GetMigratingVmRequest, MigratingVm> getMigratingVmCallable;
  private final UnaryCallable<UpdateMigratingVmRequest, Operation> updateMigratingVmCallable;
  private final OperationCallable<UpdateMigratingVmRequest, MigratingVm, OperationMetadata>
      updateMigratingVmOperationCallable;
  private final UnaryCallable<DeleteMigratingVmRequest, Operation> deleteMigratingVmCallable;
  private final OperationCallable<DeleteMigratingVmRequest, Empty, OperationMetadata>
      deleteMigratingVmOperationCallable;
  private final UnaryCallable<StartMigrationRequest, Operation> startMigrationCallable;
  private final OperationCallable<StartMigrationRequest, StartMigrationResponse, OperationMetadata>
      startMigrationOperationCallable;
  private final UnaryCallable<ResumeMigrationRequest, Operation> resumeMigrationCallable;
  private final OperationCallable<
          ResumeMigrationRequest, ResumeMigrationResponse, OperationMetadata>
      resumeMigrationOperationCallable;
  private final UnaryCallable<PauseMigrationRequest, Operation> pauseMigrationCallable;
  private final OperationCallable<PauseMigrationRequest, PauseMigrationResponse, OperationMetadata>
      pauseMigrationOperationCallable;
  private final UnaryCallable<FinalizeMigrationRequest, Operation> finalizeMigrationCallable;
  private final OperationCallable<
          FinalizeMigrationRequest, FinalizeMigrationResponse, OperationMetadata>
      finalizeMigrationOperationCallable;
  private final UnaryCallable<CreateCloneJobRequest, Operation> createCloneJobCallable;
  private final OperationCallable<CreateCloneJobRequest, CloneJob, OperationMetadata>
      createCloneJobOperationCallable;
  private final UnaryCallable<CancelCloneJobRequest, Operation> cancelCloneJobCallable;
  private final OperationCallable<CancelCloneJobRequest, CancelCloneJobResponse, OperationMetadata>
      cancelCloneJobOperationCallable;
  private final UnaryCallable<ListCloneJobsRequest, ListCloneJobsResponse> listCloneJobsCallable;
  private final UnaryCallable<ListCloneJobsRequest, ListCloneJobsPagedResponse>
      listCloneJobsPagedCallable;
  private final UnaryCallable<GetCloneJobRequest, CloneJob> getCloneJobCallable;
  private final UnaryCallable<CreateCutoverJobRequest, Operation> createCutoverJobCallable;
  private final OperationCallable<CreateCutoverJobRequest, CutoverJob, OperationMetadata>
      createCutoverJobOperationCallable;
  private final UnaryCallable<CancelCutoverJobRequest, Operation> cancelCutoverJobCallable;
  private final OperationCallable<
          CancelCutoverJobRequest, CancelCutoverJobResponse, OperationMetadata>
      cancelCutoverJobOperationCallable;
  private final UnaryCallable<ListCutoverJobsRequest, ListCutoverJobsResponse>
      listCutoverJobsCallable;
  private final UnaryCallable<ListCutoverJobsRequest, ListCutoverJobsPagedResponse>
      listCutoverJobsPagedCallable;
  private final UnaryCallable<GetCutoverJobRequest, CutoverJob> getCutoverJobCallable;
  private final UnaryCallable<ListGroupsRequest, ListGroupsResponse> listGroupsCallable;
  private final UnaryCallable<ListGroupsRequest, ListGroupsPagedResponse> listGroupsPagedCallable;
  private final UnaryCallable<GetGroupRequest, Group> getGroupCallable;
  private final UnaryCallable<CreateGroupRequest, Operation> createGroupCallable;
  private final OperationCallable<CreateGroupRequest, Group, OperationMetadata>
      createGroupOperationCallable;
  private final UnaryCallable<UpdateGroupRequest, Operation> updateGroupCallable;
  private final OperationCallable<UpdateGroupRequest, Group, OperationMetadata>
      updateGroupOperationCallable;
  private final UnaryCallable<DeleteGroupRequest, Operation> deleteGroupCallable;
  private final OperationCallable<DeleteGroupRequest, Empty, OperationMetadata>
      deleteGroupOperationCallable;
  private final UnaryCallable<AddGroupMigrationRequest, Operation> addGroupMigrationCallable;
  private final OperationCallable<
          AddGroupMigrationRequest, AddGroupMigrationResponse, OperationMetadata>
      addGroupMigrationOperationCallable;
  private final UnaryCallable<RemoveGroupMigrationRequest, Operation> removeGroupMigrationCallable;
  private final OperationCallable<
          RemoveGroupMigrationRequest, RemoveGroupMigrationResponse, OperationMetadata>
      removeGroupMigrationOperationCallable;
  private final UnaryCallable<ListTargetProjectsRequest, ListTargetProjectsResponse>
      listTargetProjectsCallable;
  private final UnaryCallable<ListTargetProjectsRequest, ListTargetProjectsPagedResponse>
      listTargetProjectsPagedCallable;
  private final UnaryCallable<GetTargetProjectRequest, TargetProject> getTargetProjectCallable;
  private final UnaryCallable<CreateTargetProjectRequest, Operation> createTargetProjectCallable;
  private final OperationCallable<CreateTargetProjectRequest, TargetProject, OperationMetadata>
      createTargetProjectOperationCallable;
  private final UnaryCallable<UpdateTargetProjectRequest, Operation> updateTargetProjectCallable;
  private final OperationCallable<UpdateTargetProjectRequest, TargetProject, OperationMetadata>
      updateTargetProjectOperationCallable;
  private final UnaryCallable<DeleteTargetProjectRequest, Operation> deleteTargetProjectCallable;
  private final OperationCallable<DeleteTargetProjectRequest, Empty, OperationMetadata>
      deleteTargetProjectOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonVmMigrationStub create(VmMigrationStubSettings settings)
      throws IOException {
    return new HttpJsonVmMigrationStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonVmMigrationStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonVmMigrationStub(
        VmMigrationStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonVmMigrationStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonVmMigrationStub(
        VmMigrationStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonVmMigrationStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonVmMigrationStub(VmMigrationStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonVmMigrationCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonVmMigrationStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonVmMigrationStub(
      VmMigrationStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListSourcesRequest, ListSourcesResponse> listSourcesTransportSettings =
        HttpJsonCallSettings.<ListSourcesRequest, ListSourcesResponse>newBuilder()
            .setMethodDescriptor(listSourcesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetSourceRequest, Source> getSourceTransportSettings =
        HttpJsonCallSettings.<GetSourceRequest, Source>newBuilder()
            .setMethodDescriptor(getSourceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateSourceRequest, Operation> createSourceTransportSettings =
        HttpJsonCallSettings.<CreateSourceRequest, Operation>newBuilder()
            .setMethodDescriptor(createSourceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateSourceRequest, Operation> updateSourceTransportSettings =
        HttpJsonCallSettings.<UpdateSourceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSourceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteSourceRequest, Operation> deleteSourceTransportSettings =
        HttpJsonCallSettings.<DeleteSourceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSourceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<FetchInventoryRequest, FetchInventoryResponse>
        fetchInventoryTransportSettings =
            HttpJsonCallSettings.<FetchInventoryRequest, FetchInventoryResponse>newBuilder()
                .setMethodDescriptor(fetchInventoryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListUtilizationReportsRequest, ListUtilizationReportsResponse>
        listUtilizationReportsTransportSettings =
            HttpJsonCallSettings
                .<ListUtilizationReportsRequest, ListUtilizationReportsResponse>newBuilder()
                .setMethodDescriptor(listUtilizationReportsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetUtilizationReportRequest, UtilizationReport>
        getUtilizationReportTransportSettings =
            HttpJsonCallSettings.<GetUtilizationReportRequest, UtilizationReport>newBuilder()
                .setMethodDescriptor(getUtilizationReportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateUtilizationReportRequest, Operation>
        createUtilizationReportTransportSettings =
            HttpJsonCallSettings.<CreateUtilizationReportRequest, Operation>newBuilder()
                .setMethodDescriptor(createUtilizationReportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteUtilizationReportRequest, Operation>
        deleteUtilizationReportTransportSettings =
            HttpJsonCallSettings.<DeleteUtilizationReportRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteUtilizationReportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListDatacenterConnectorsRequest, ListDatacenterConnectorsResponse>
        listDatacenterConnectorsTransportSettings =
            HttpJsonCallSettings
                .<ListDatacenterConnectorsRequest, ListDatacenterConnectorsResponse>newBuilder()
                .setMethodDescriptor(listDatacenterConnectorsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetDatacenterConnectorRequest, DatacenterConnector>
        getDatacenterConnectorTransportSettings =
            HttpJsonCallSettings.<GetDatacenterConnectorRequest, DatacenterConnector>newBuilder()
                .setMethodDescriptor(getDatacenterConnectorMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateDatacenterConnectorRequest, Operation>
        createDatacenterConnectorTransportSettings =
            HttpJsonCallSettings.<CreateDatacenterConnectorRequest, Operation>newBuilder()
                .setMethodDescriptor(createDatacenterConnectorMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteDatacenterConnectorRequest, Operation>
        deleteDatacenterConnectorTransportSettings =
            HttpJsonCallSettings.<DeleteDatacenterConnectorRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteDatacenterConnectorMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpgradeApplianceRequest, Operation> upgradeApplianceTransportSettings =
        HttpJsonCallSettings.<UpgradeApplianceRequest, Operation>newBuilder()
            .setMethodDescriptor(upgradeApplianceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateMigratingVmRequest, Operation> createMigratingVmTransportSettings =
        HttpJsonCallSettings.<CreateMigratingVmRequest, Operation>newBuilder()
            .setMethodDescriptor(createMigratingVmMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListMigratingVmsRequest, ListMigratingVmsResponse>
        listMigratingVmsTransportSettings =
            HttpJsonCallSettings.<ListMigratingVmsRequest, ListMigratingVmsResponse>newBuilder()
                .setMethodDescriptor(listMigratingVmsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetMigratingVmRequest, MigratingVm> getMigratingVmTransportSettings =
        HttpJsonCallSettings.<GetMigratingVmRequest, MigratingVm>newBuilder()
            .setMethodDescriptor(getMigratingVmMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateMigratingVmRequest, Operation> updateMigratingVmTransportSettings =
        HttpJsonCallSettings.<UpdateMigratingVmRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMigratingVmMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteMigratingVmRequest, Operation> deleteMigratingVmTransportSettings =
        HttpJsonCallSettings.<DeleteMigratingVmRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMigratingVmMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<StartMigrationRequest, Operation> startMigrationTransportSettings =
        HttpJsonCallSettings.<StartMigrationRequest, Operation>newBuilder()
            .setMethodDescriptor(startMigrationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ResumeMigrationRequest, Operation> resumeMigrationTransportSettings =
        HttpJsonCallSettings.<ResumeMigrationRequest, Operation>newBuilder()
            .setMethodDescriptor(resumeMigrationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<PauseMigrationRequest, Operation> pauseMigrationTransportSettings =
        HttpJsonCallSettings.<PauseMigrationRequest, Operation>newBuilder()
            .setMethodDescriptor(pauseMigrationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<FinalizeMigrationRequest, Operation> finalizeMigrationTransportSettings =
        HttpJsonCallSettings.<FinalizeMigrationRequest, Operation>newBuilder()
            .setMethodDescriptor(finalizeMigrationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateCloneJobRequest, Operation> createCloneJobTransportSettings =
        HttpJsonCallSettings.<CreateCloneJobRequest, Operation>newBuilder()
            .setMethodDescriptor(createCloneJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CancelCloneJobRequest, Operation> cancelCloneJobTransportSettings =
        HttpJsonCallSettings.<CancelCloneJobRequest, Operation>newBuilder()
            .setMethodDescriptor(cancelCloneJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListCloneJobsRequest, ListCloneJobsResponse>
        listCloneJobsTransportSettings =
            HttpJsonCallSettings.<ListCloneJobsRequest, ListCloneJobsResponse>newBuilder()
                .setMethodDescriptor(listCloneJobsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetCloneJobRequest, CloneJob> getCloneJobTransportSettings =
        HttpJsonCallSettings.<GetCloneJobRequest, CloneJob>newBuilder()
            .setMethodDescriptor(getCloneJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateCutoverJobRequest, Operation> createCutoverJobTransportSettings =
        HttpJsonCallSettings.<CreateCutoverJobRequest, Operation>newBuilder()
            .setMethodDescriptor(createCutoverJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CancelCutoverJobRequest, Operation> cancelCutoverJobTransportSettings =
        HttpJsonCallSettings.<CancelCutoverJobRequest, Operation>newBuilder()
            .setMethodDescriptor(cancelCutoverJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListCutoverJobsRequest, ListCutoverJobsResponse>
        listCutoverJobsTransportSettings =
            HttpJsonCallSettings.<ListCutoverJobsRequest, ListCutoverJobsResponse>newBuilder()
                .setMethodDescriptor(listCutoverJobsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetCutoverJobRequest, CutoverJob> getCutoverJobTransportSettings =
        HttpJsonCallSettings.<GetCutoverJobRequest, CutoverJob>newBuilder()
            .setMethodDescriptor(getCutoverJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListGroupsRequest, ListGroupsResponse> listGroupsTransportSettings =
        HttpJsonCallSettings.<ListGroupsRequest, ListGroupsResponse>newBuilder()
            .setMethodDescriptor(listGroupsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetGroupRequest, Group> getGroupTransportSettings =
        HttpJsonCallSettings.<GetGroupRequest, Group>newBuilder()
            .setMethodDescriptor(getGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateGroupRequest, Operation> createGroupTransportSettings =
        HttpJsonCallSettings.<CreateGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(createGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateGroupRequest, Operation> updateGroupTransportSettings =
        HttpJsonCallSettings.<UpdateGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(updateGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteGroupRequest, Operation> deleteGroupTransportSettings =
        HttpJsonCallSettings.<DeleteGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<AddGroupMigrationRequest, Operation> addGroupMigrationTransportSettings =
        HttpJsonCallSettings.<AddGroupMigrationRequest, Operation>newBuilder()
            .setMethodDescriptor(addGroupMigrationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RemoveGroupMigrationRequest, Operation>
        removeGroupMigrationTransportSettings =
            HttpJsonCallSettings.<RemoveGroupMigrationRequest, Operation>newBuilder()
                .setMethodDescriptor(removeGroupMigrationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListTargetProjectsRequest, ListTargetProjectsResponse>
        listTargetProjectsTransportSettings =
            HttpJsonCallSettings.<ListTargetProjectsRequest, ListTargetProjectsResponse>newBuilder()
                .setMethodDescriptor(listTargetProjectsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetTargetProjectRequest, TargetProject> getTargetProjectTransportSettings =
        HttpJsonCallSettings.<GetTargetProjectRequest, TargetProject>newBuilder()
            .setMethodDescriptor(getTargetProjectMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateTargetProjectRequest, Operation>
        createTargetProjectTransportSettings =
            HttpJsonCallSettings.<CreateTargetProjectRequest, Operation>newBuilder()
                .setMethodDescriptor(createTargetProjectMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateTargetProjectRequest, Operation>
        updateTargetProjectTransportSettings =
            HttpJsonCallSettings.<UpdateTargetProjectRequest, Operation>newBuilder()
                .setMethodDescriptor(updateTargetProjectMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteTargetProjectRequest, Operation>
        deleteTargetProjectTransportSettings =
            HttpJsonCallSettings.<DeleteTargetProjectRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteTargetProjectMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.listSourcesCallable =
        callableFactory.createUnaryCallable(
            listSourcesTransportSettings, settings.listSourcesSettings(), clientContext);
    this.listSourcesPagedCallable =
        callableFactory.createPagedCallable(
            listSourcesTransportSettings, settings.listSourcesSettings(), clientContext);
    this.getSourceCallable =
        callableFactory.createUnaryCallable(
            getSourceTransportSettings, settings.getSourceSettings(), clientContext);
    this.createSourceCallable =
        callableFactory.createUnaryCallable(
            createSourceTransportSettings, settings.createSourceSettings(), clientContext);
    this.createSourceOperationCallable =
        callableFactory.createOperationCallable(
            createSourceTransportSettings,
            settings.createSourceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateSourceCallable =
        callableFactory.createUnaryCallable(
            updateSourceTransportSettings, settings.updateSourceSettings(), clientContext);
    this.updateSourceOperationCallable =
        callableFactory.createOperationCallable(
            updateSourceTransportSettings,
            settings.updateSourceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteSourceCallable =
        callableFactory.createUnaryCallable(
            deleteSourceTransportSettings, settings.deleteSourceSettings(), clientContext);
    this.deleteSourceOperationCallable =
        callableFactory.createOperationCallable(
            deleteSourceTransportSettings,
            settings.deleteSourceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.fetchInventoryCallable =
        callableFactory.createUnaryCallable(
            fetchInventoryTransportSettings, settings.fetchInventorySettings(), clientContext);
    this.listUtilizationReportsCallable =
        callableFactory.createUnaryCallable(
            listUtilizationReportsTransportSettings,
            settings.listUtilizationReportsSettings(),
            clientContext);
    this.listUtilizationReportsPagedCallable =
        callableFactory.createPagedCallable(
            listUtilizationReportsTransportSettings,
            settings.listUtilizationReportsSettings(),
            clientContext);
    this.getUtilizationReportCallable =
        callableFactory.createUnaryCallable(
            getUtilizationReportTransportSettings,
            settings.getUtilizationReportSettings(),
            clientContext);
    this.createUtilizationReportCallable =
        callableFactory.createUnaryCallable(
            createUtilizationReportTransportSettings,
            settings.createUtilizationReportSettings(),
            clientContext);
    this.createUtilizationReportOperationCallable =
        callableFactory.createOperationCallable(
            createUtilizationReportTransportSettings,
            settings.createUtilizationReportOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteUtilizationReportCallable =
        callableFactory.createUnaryCallable(
            deleteUtilizationReportTransportSettings,
            settings.deleteUtilizationReportSettings(),
            clientContext);
    this.deleteUtilizationReportOperationCallable =
        callableFactory.createOperationCallable(
            deleteUtilizationReportTransportSettings,
            settings.deleteUtilizationReportOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listDatacenterConnectorsCallable =
        callableFactory.createUnaryCallable(
            listDatacenterConnectorsTransportSettings,
            settings.listDatacenterConnectorsSettings(),
            clientContext);
    this.listDatacenterConnectorsPagedCallable =
        callableFactory.createPagedCallable(
            listDatacenterConnectorsTransportSettings,
            settings.listDatacenterConnectorsSettings(),
            clientContext);
    this.getDatacenterConnectorCallable =
        callableFactory.createUnaryCallable(
            getDatacenterConnectorTransportSettings,
            settings.getDatacenterConnectorSettings(),
            clientContext);
    this.createDatacenterConnectorCallable =
        callableFactory.createUnaryCallable(
            createDatacenterConnectorTransportSettings,
            settings.createDatacenterConnectorSettings(),
            clientContext);
    this.createDatacenterConnectorOperationCallable =
        callableFactory.createOperationCallable(
            createDatacenterConnectorTransportSettings,
            settings.createDatacenterConnectorOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteDatacenterConnectorCallable =
        callableFactory.createUnaryCallable(
            deleteDatacenterConnectorTransportSettings,
            settings.deleteDatacenterConnectorSettings(),
            clientContext);
    this.deleteDatacenterConnectorOperationCallable =
        callableFactory.createOperationCallable(
            deleteDatacenterConnectorTransportSettings,
            settings.deleteDatacenterConnectorOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.upgradeApplianceCallable =
        callableFactory.createUnaryCallable(
            upgradeApplianceTransportSettings, settings.upgradeApplianceSettings(), clientContext);
    this.upgradeApplianceOperationCallable =
        callableFactory.createOperationCallable(
            upgradeApplianceTransportSettings,
            settings.upgradeApplianceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createMigratingVmCallable =
        callableFactory.createUnaryCallable(
            createMigratingVmTransportSettings,
            settings.createMigratingVmSettings(),
            clientContext);
    this.createMigratingVmOperationCallable =
        callableFactory.createOperationCallable(
            createMigratingVmTransportSettings,
            settings.createMigratingVmOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listMigratingVmsCallable =
        callableFactory.createUnaryCallable(
            listMigratingVmsTransportSettings, settings.listMigratingVmsSettings(), clientContext);
    this.listMigratingVmsPagedCallable =
        callableFactory.createPagedCallable(
            listMigratingVmsTransportSettings, settings.listMigratingVmsSettings(), clientContext);
    this.getMigratingVmCallable =
        callableFactory.createUnaryCallable(
            getMigratingVmTransportSettings, settings.getMigratingVmSettings(), clientContext);
    this.updateMigratingVmCallable =
        callableFactory.createUnaryCallable(
            updateMigratingVmTransportSettings,
            settings.updateMigratingVmSettings(),
            clientContext);
    this.updateMigratingVmOperationCallable =
        callableFactory.createOperationCallable(
            updateMigratingVmTransportSettings,
            settings.updateMigratingVmOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteMigratingVmCallable =
        callableFactory.createUnaryCallable(
            deleteMigratingVmTransportSettings,
            settings.deleteMigratingVmSettings(),
            clientContext);
    this.deleteMigratingVmOperationCallable =
        callableFactory.createOperationCallable(
            deleteMigratingVmTransportSettings,
            settings.deleteMigratingVmOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.startMigrationCallable =
        callableFactory.createUnaryCallable(
            startMigrationTransportSettings, settings.startMigrationSettings(), clientContext);
    this.startMigrationOperationCallable =
        callableFactory.createOperationCallable(
            startMigrationTransportSettings,
            settings.startMigrationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.resumeMigrationCallable =
        callableFactory.createUnaryCallable(
            resumeMigrationTransportSettings, settings.resumeMigrationSettings(), clientContext);
    this.resumeMigrationOperationCallable =
        callableFactory.createOperationCallable(
            resumeMigrationTransportSettings,
            settings.resumeMigrationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.pauseMigrationCallable =
        callableFactory.createUnaryCallable(
            pauseMigrationTransportSettings, settings.pauseMigrationSettings(), clientContext);
    this.pauseMigrationOperationCallable =
        callableFactory.createOperationCallable(
            pauseMigrationTransportSettings,
            settings.pauseMigrationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.finalizeMigrationCallable =
        callableFactory.createUnaryCallable(
            finalizeMigrationTransportSettings,
            settings.finalizeMigrationSettings(),
            clientContext);
    this.finalizeMigrationOperationCallable =
        callableFactory.createOperationCallable(
            finalizeMigrationTransportSettings,
            settings.finalizeMigrationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createCloneJobCallable =
        callableFactory.createUnaryCallable(
            createCloneJobTransportSettings, settings.createCloneJobSettings(), clientContext);
    this.createCloneJobOperationCallable =
        callableFactory.createOperationCallable(
            createCloneJobTransportSettings,
            settings.createCloneJobOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.cancelCloneJobCallable =
        callableFactory.createUnaryCallable(
            cancelCloneJobTransportSettings, settings.cancelCloneJobSettings(), clientContext);
    this.cancelCloneJobOperationCallable =
        callableFactory.createOperationCallable(
            cancelCloneJobTransportSettings,
            settings.cancelCloneJobOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listCloneJobsCallable =
        callableFactory.createUnaryCallable(
            listCloneJobsTransportSettings, settings.listCloneJobsSettings(), clientContext);
    this.listCloneJobsPagedCallable =
        callableFactory.createPagedCallable(
            listCloneJobsTransportSettings, settings.listCloneJobsSettings(), clientContext);
    this.getCloneJobCallable =
        callableFactory.createUnaryCallable(
            getCloneJobTransportSettings, settings.getCloneJobSettings(), clientContext);
    this.createCutoverJobCallable =
        callableFactory.createUnaryCallable(
            createCutoverJobTransportSettings, settings.createCutoverJobSettings(), clientContext);
    this.createCutoverJobOperationCallable =
        callableFactory.createOperationCallable(
            createCutoverJobTransportSettings,
            settings.createCutoverJobOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.cancelCutoverJobCallable =
        callableFactory.createUnaryCallable(
            cancelCutoverJobTransportSettings, settings.cancelCutoverJobSettings(), clientContext);
    this.cancelCutoverJobOperationCallable =
        callableFactory.createOperationCallable(
            cancelCutoverJobTransportSettings,
            settings.cancelCutoverJobOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listCutoverJobsCallable =
        callableFactory.createUnaryCallable(
            listCutoverJobsTransportSettings, settings.listCutoverJobsSettings(), clientContext);
    this.listCutoverJobsPagedCallable =
        callableFactory.createPagedCallable(
            listCutoverJobsTransportSettings, settings.listCutoverJobsSettings(), clientContext);
    this.getCutoverJobCallable =
        callableFactory.createUnaryCallable(
            getCutoverJobTransportSettings, settings.getCutoverJobSettings(), clientContext);
    this.listGroupsCallable =
        callableFactory.createUnaryCallable(
            listGroupsTransportSettings, settings.listGroupsSettings(), clientContext);
    this.listGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listGroupsTransportSettings, settings.listGroupsSettings(), clientContext);
    this.getGroupCallable =
        callableFactory.createUnaryCallable(
            getGroupTransportSettings, settings.getGroupSettings(), clientContext);
    this.createGroupCallable =
        callableFactory.createUnaryCallable(
            createGroupTransportSettings, settings.createGroupSettings(), clientContext);
    this.createGroupOperationCallable =
        callableFactory.createOperationCallable(
            createGroupTransportSettings,
            settings.createGroupOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateGroupCallable =
        callableFactory.createUnaryCallable(
            updateGroupTransportSettings, settings.updateGroupSettings(), clientContext);
    this.updateGroupOperationCallable =
        callableFactory.createOperationCallable(
            updateGroupTransportSettings,
            settings.updateGroupOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteGroupCallable =
        callableFactory.createUnaryCallable(
            deleteGroupTransportSettings, settings.deleteGroupSettings(), clientContext);
    this.deleteGroupOperationCallable =
        callableFactory.createOperationCallable(
            deleteGroupTransportSettings,
            settings.deleteGroupOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.addGroupMigrationCallable =
        callableFactory.createUnaryCallable(
            addGroupMigrationTransportSettings,
            settings.addGroupMigrationSettings(),
            clientContext);
    this.addGroupMigrationOperationCallable =
        callableFactory.createOperationCallable(
            addGroupMigrationTransportSettings,
            settings.addGroupMigrationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.removeGroupMigrationCallable =
        callableFactory.createUnaryCallable(
            removeGroupMigrationTransportSettings,
            settings.removeGroupMigrationSettings(),
            clientContext);
    this.removeGroupMigrationOperationCallable =
        callableFactory.createOperationCallable(
            removeGroupMigrationTransportSettings,
            settings.removeGroupMigrationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listTargetProjectsCallable =
        callableFactory.createUnaryCallable(
            listTargetProjectsTransportSettings,
            settings.listTargetProjectsSettings(),
            clientContext);
    this.listTargetProjectsPagedCallable =
        callableFactory.createPagedCallable(
            listTargetProjectsTransportSettings,
            settings.listTargetProjectsSettings(),
            clientContext);
    this.getTargetProjectCallable =
        callableFactory.createUnaryCallable(
            getTargetProjectTransportSettings, settings.getTargetProjectSettings(), clientContext);
    this.createTargetProjectCallable =
        callableFactory.createUnaryCallable(
            createTargetProjectTransportSettings,
            settings.createTargetProjectSettings(),
            clientContext);
    this.createTargetProjectOperationCallable =
        callableFactory.createOperationCallable(
            createTargetProjectTransportSettings,
            settings.createTargetProjectOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateTargetProjectCallable =
        callableFactory.createUnaryCallable(
            updateTargetProjectTransportSettings,
            settings.updateTargetProjectSettings(),
            clientContext);
    this.updateTargetProjectOperationCallable =
        callableFactory.createOperationCallable(
            updateTargetProjectTransportSettings,
            settings.updateTargetProjectOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteTargetProjectCallable =
        callableFactory.createUnaryCallable(
            deleteTargetProjectTransportSettings,
            settings.deleteTargetProjectSettings(),
            clientContext);
    this.deleteTargetProjectOperationCallable =
        callableFactory.createOperationCallable(
            deleteTargetProjectTransportSettings,
            settings.deleteTargetProjectOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listSourcesMethodDescriptor);
    methodDescriptors.add(getSourceMethodDescriptor);
    methodDescriptors.add(createSourceMethodDescriptor);
    methodDescriptors.add(updateSourceMethodDescriptor);
    methodDescriptors.add(deleteSourceMethodDescriptor);
    methodDescriptors.add(fetchInventoryMethodDescriptor);
    methodDescriptors.add(listUtilizationReportsMethodDescriptor);
    methodDescriptors.add(getUtilizationReportMethodDescriptor);
    methodDescriptors.add(createUtilizationReportMethodDescriptor);
    methodDescriptors.add(deleteUtilizationReportMethodDescriptor);
    methodDescriptors.add(listDatacenterConnectorsMethodDescriptor);
    methodDescriptors.add(getDatacenterConnectorMethodDescriptor);
    methodDescriptors.add(createDatacenterConnectorMethodDescriptor);
    methodDescriptors.add(deleteDatacenterConnectorMethodDescriptor);
    methodDescriptors.add(upgradeApplianceMethodDescriptor);
    methodDescriptors.add(createMigratingVmMethodDescriptor);
    methodDescriptors.add(listMigratingVmsMethodDescriptor);
    methodDescriptors.add(getMigratingVmMethodDescriptor);
    methodDescriptors.add(updateMigratingVmMethodDescriptor);
    methodDescriptors.add(deleteMigratingVmMethodDescriptor);
    methodDescriptors.add(startMigrationMethodDescriptor);
    methodDescriptors.add(resumeMigrationMethodDescriptor);
    methodDescriptors.add(pauseMigrationMethodDescriptor);
    methodDescriptors.add(finalizeMigrationMethodDescriptor);
    methodDescriptors.add(createCloneJobMethodDescriptor);
    methodDescriptors.add(cancelCloneJobMethodDescriptor);
    methodDescriptors.add(listCloneJobsMethodDescriptor);
    methodDescriptors.add(getCloneJobMethodDescriptor);
    methodDescriptors.add(createCutoverJobMethodDescriptor);
    methodDescriptors.add(cancelCutoverJobMethodDescriptor);
    methodDescriptors.add(listCutoverJobsMethodDescriptor);
    methodDescriptors.add(getCutoverJobMethodDescriptor);
    methodDescriptors.add(listGroupsMethodDescriptor);
    methodDescriptors.add(getGroupMethodDescriptor);
    methodDescriptors.add(createGroupMethodDescriptor);
    methodDescriptors.add(updateGroupMethodDescriptor);
    methodDescriptors.add(deleteGroupMethodDescriptor);
    methodDescriptors.add(addGroupMigrationMethodDescriptor);
    methodDescriptors.add(removeGroupMigrationMethodDescriptor);
    methodDescriptors.add(listTargetProjectsMethodDescriptor);
    methodDescriptors.add(getTargetProjectMethodDescriptor);
    methodDescriptors.add(createTargetProjectMethodDescriptor);
    methodDescriptors.add(updateTargetProjectMethodDescriptor);
    methodDescriptors.add(deleteTargetProjectMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListSourcesRequest, ListSourcesResponse> listSourcesCallable() {
    return listSourcesCallable;
  }

  @Override
  public UnaryCallable<ListSourcesRequest, ListSourcesPagedResponse> listSourcesPagedCallable() {
    return listSourcesPagedCallable;
  }

  @Override
  public UnaryCallable<GetSourceRequest, Source> getSourceCallable() {
    return getSourceCallable;
  }

  @Override
  public UnaryCallable<CreateSourceRequest, Operation> createSourceCallable() {
    return createSourceCallable;
  }

  @Override
  public OperationCallable<CreateSourceRequest, Source, OperationMetadata>
      createSourceOperationCallable() {
    return createSourceOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateSourceRequest, Operation> updateSourceCallable() {
    return updateSourceCallable;
  }

  @Override
  public OperationCallable<UpdateSourceRequest, Source, OperationMetadata>
      updateSourceOperationCallable() {
    return updateSourceOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteSourceRequest, Operation> deleteSourceCallable() {
    return deleteSourceCallable;
  }

  @Override
  public OperationCallable<DeleteSourceRequest, Empty, OperationMetadata>
      deleteSourceOperationCallable() {
    return deleteSourceOperationCallable;
  }

  @Override
  public UnaryCallable<FetchInventoryRequest, FetchInventoryResponse> fetchInventoryCallable() {
    return fetchInventoryCallable;
  }

  @Override
  public UnaryCallable<ListUtilizationReportsRequest, ListUtilizationReportsResponse>
      listUtilizationReportsCallable() {
    return listUtilizationReportsCallable;
  }

  @Override
  public UnaryCallable<ListUtilizationReportsRequest, ListUtilizationReportsPagedResponse>
      listUtilizationReportsPagedCallable() {
    return listUtilizationReportsPagedCallable;
  }

  @Override
  public UnaryCallable<GetUtilizationReportRequest, UtilizationReport>
      getUtilizationReportCallable() {
    return getUtilizationReportCallable;
  }

  @Override
  public UnaryCallable<CreateUtilizationReportRequest, Operation>
      createUtilizationReportCallable() {
    return createUtilizationReportCallable;
  }

  @Override
  public OperationCallable<CreateUtilizationReportRequest, UtilizationReport, OperationMetadata>
      createUtilizationReportOperationCallable() {
    return createUtilizationReportOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteUtilizationReportRequest, Operation>
      deleteUtilizationReportCallable() {
    return deleteUtilizationReportCallable;
  }

  @Override
  public OperationCallable<DeleteUtilizationReportRequest, Empty, OperationMetadata>
      deleteUtilizationReportOperationCallable() {
    return deleteUtilizationReportOperationCallable;
  }

  @Override
  public UnaryCallable<ListDatacenterConnectorsRequest, ListDatacenterConnectorsResponse>
      listDatacenterConnectorsCallable() {
    return listDatacenterConnectorsCallable;
  }

  @Override
  public UnaryCallable<ListDatacenterConnectorsRequest, ListDatacenterConnectorsPagedResponse>
      listDatacenterConnectorsPagedCallable() {
    return listDatacenterConnectorsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDatacenterConnectorRequest, DatacenterConnector>
      getDatacenterConnectorCallable() {
    return getDatacenterConnectorCallable;
  }

  @Override
  public UnaryCallable<CreateDatacenterConnectorRequest, Operation>
      createDatacenterConnectorCallable() {
    return createDatacenterConnectorCallable;
  }

  @Override
  public OperationCallable<CreateDatacenterConnectorRequest, DatacenterConnector, OperationMetadata>
      createDatacenterConnectorOperationCallable() {
    return createDatacenterConnectorOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDatacenterConnectorRequest, Operation>
      deleteDatacenterConnectorCallable() {
    return deleteDatacenterConnectorCallable;
  }

  @Override
  public OperationCallable<DeleteDatacenterConnectorRequest, Empty, OperationMetadata>
      deleteDatacenterConnectorOperationCallable() {
    return deleteDatacenterConnectorOperationCallable;
  }

  @Override
  public UnaryCallable<UpgradeApplianceRequest, Operation> upgradeApplianceCallable() {
    return upgradeApplianceCallable;
  }

  @Override
  public OperationCallable<UpgradeApplianceRequest, UpgradeApplianceResponse, OperationMetadata>
      upgradeApplianceOperationCallable() {
    return upgradeApplianceOperationCallable;
  }

  @Override
  public UnaryCallable<CreateMigratingVmRequest, Operation> createMigratingVmCallable() {
    return createMigratingVmCallable;
  }

  @Override
  public OperationCallable<CreateMigratingVmRequest, MigratingVm, OperationMetadata>
      createMigratingVmOperationCallable() {
    return createMigratingVmOperationCallable;
  }

  @Override
  public UnaryCallable<ListMigratingVmsRequest, ListMigratingVmsResponse>
      listMigratingVmsCallable() {
    return listMigratingVmsCallable;
  }

  @Override
  public UnaryCallable<ListMigratingVmsRequest, ListMigratingVmsPagedResponse>
      listMigratingVmsPagedCallable() {
    return listMigratingVmsPagedCallable;
  }

  @Override
  public UnaryCallable<GetMigratingVmRequest, MigratingVm> getMigratingVmCallable() {
    return getMigratingVmCallable;
  }

  @Override
  public UnaryCallable<UpdateMigratingVmRequest, Operation> updateMigratingVmCallable() {
    return updateMigratingVmCallable;
  }

  @Override
  public OperationCallable<UpdateMigratingVmRequest, MigratingVm, OperationMetadata>
      updateMigratingVmOperationCallable() {
    return updateMigratingVmOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteMigratingVmRequest, Operation> deleteMigratingVmCallable() {
    return deleteMigratingVmCallable;
  }

  @Override
  public OperationCallable<DeleteMigratingVmRequest, Empty, OperationMetadata>
      deleteMigratingVmOperationCallable() {
    return deleteMigratingVmOperationCallable;
  }

  @Override
  public UnaryCallable<StartMigrationRequest, Operation> startMigrationCallable() {
    return startMigrationCallable;
  }

  @Override
  public OperationCallable<StartMigrationRequest, StartMigrationResponse, OperationMetadata>
      startMigrationOperationCallable() {
    return startMigrationOperationCallable;
  }

  @Override
  public UnaryCallable<ResumeMigrationRequest, Operation> resumeMigrationCallable() {
    return resumeMigrationCallable;
  }

  @Override
  public OperationCallable<ResumeMigrationRequest, ResumeMigrationResponse, OperationMetadata>
      resumeMigrationOperationCallable() {
    return resumeMigrationOperationCallable;
  }

  @Override
  public UnaryCallable<PauseMigrationRequest, Operation> pauseMigrationCallable() {
    return pauseMigrationCallable;
  }

  @Override
  public OperationCallable<PauseMigrationRequest, PauseMigrationResponse, OperationMetadata>
      pauseMigrationOperationCallable() {
    return pauseMigrationOperationCallable;
  }

  @Override
  public UnaryCallable<FinalizeMigrationRequest, Operation> finalizeMigrationCallable() {
    return finalizeMigrationCallable;
  }

  @Override
  public OperationCallable<FinalizeMigrationRequest, FinalizeMigrationResponse, OperationMetadata>
      finalizeMigrationOperationCallable() {
    return finalizeMigrationOperationCallable;
  }

  @Override
  public UnaryCallable<CreateCloneJobRequest, Operation> createCloneJobCallable() {
    return createCloneJobCallable;
  }

  @Override
  public OperationCallable<CreateCloneJobRequest, CloneJob, OperationMetadata>
      createCloneJobOperationCallable() {
    return createCloneJobOperationCallable;
  }

  @Override
  public UnaryCallable<CancelCloneJobRequest, Operation> cancelCloneJobCallable() {
    return cancelCloneJobCallable;
  }

  @Override
  public OperationCallable<CancelCloneJobRequest, CancelCloneJobResponse, OperationMetadata>
      cancelCloneJobOperationCallable() {
    return cancelCloneJobOperationCallable;
  }

  @Override
  public UnaryCallable<ListCloneJobsRequest, ListCloneJobsResponse> listCloneJobsCallable() {
    return listCloneJobsCallable;
  }

  @Override
  public UnaryCallable<ListCloneJobsRequest, ListCloneJobsPagedResponse>
      listCloneJobsPagedCallable() {
    return listCloneJobsPagedCallable;
  }

  @Override
  public UnaryCallable<GetCloneJobRequest, CloneJob> getCloneJobCallable() {
    return getCloneJobCallable;
  }

  @Override
  public UnaryCallable<CreateCutoverJobRequest, Operation> createCutoverJobCallable() {
    return createCutoverJobCallable;
  }

  @Override
  public OperationCallable<CreateCutoverJobRequest, CutoverJob, OperationMetadata>
      createCutoverJobOperationCallable() {
    return createCutoverJobOperationCallable;
  }

  @Override
  public UnaryCallable<CancelCutoverJobRequest, Operation> cancelCutoverJobCallable() {
    return cancelCutoverJobCallable;
  }

  @Override
  public OperationCallable<CancelCutoverJobRequest, CancelCutoverJobResponse, OperationMetadata>
      cancelCutoverJobOperationCallable() {
    return cancelCutoverJobOperationCallable;
  }

  @Override
  public UnaryCallable<ListCutoverJobsRequest, ListCutoverJobsResponse> listCutoverJobsCallable() {
    return listCutoverJobsCallable;
  }

  @Override
  public UnaryCallable<ListCutoverJobsRequest, ListCutoverJobsPagedResponse>
      listCutoverJobsPagedCallable() {
    return listCutoverJobsPagedCallable;
  }

  @Override
  public UnaryCallable<GetCutoverJobRequest, CutoverJob> getCutoverJobCallable() {
    return getCutoverJobCallable;
  }

  @Override
  public UnaryCallable<ListGroupsRequest, ListGroupsResponse> listGroupsCallable() {
    return listGroupsCallable;
  }

  @Override
  public UnaryCallable<ListGroupsRequest, ListGroupsPagedResponse> listGroupsPagedCallable() {
    return listGroupsPagedCallable;
  }

  @Override
  public UnaryCallable<GetGroupRequest, Group> getGroupCallable() {
    return getGroupCallable;
  }

  @Override
  public UnaryCallable<CreateGroupRequest, Operation> createGroupCallable() {
    return createGroupCallable;
  }

  @Override
  public OperationCallable<CreateGroupRequest, Group, OperationMetadata>
      createGroupOperationCallable() {
    return createGroupOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateGroupRequest, Operation> updateGroupCallable() {
    return updateGroupCallable;
  }

  @Override
  public OperationCallable<UpdateGroupRequest, Group, OperationMetadata>
      updateGroupOperationCallable() {
    return updateGroupOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteGroupRequest, Operation> deleteGroupCallable() {
    return deleteGroupCallable;
  }

  @Override
  public OperationCallable<DeleteGroupRequest, Empty, OperationMetadata>
      deleteGroupOperationCallable() {
    return deleteGroupOperationCallable;
  }

  @Override
  public UnaryCallable<AddGroupMigrationRequest, Operation> addGroupMigrationCallable() {
    return addGroupMigrationCallable;
  }

  @Override
  public OperationCallable<AddGroupMigrationRequest, AddGroupMigrationResponse, OperationMetadata>
      addGroupMigrationOperationCallable() {
    return addGroupMigrationOperationCallable;
  }

  @Override
  public UnaryCallable<RemoveGroupMigrationRequest, Operation> removeGroupMigrationCallable() {
    return removeGroupMigrationCallable;
  }

  @Override
  public OperationCallable<
          RemoveGroupMigrationRequest, RemoveGroupMigrationResponse, OperationMetadata>
      removeGroupMigrationOperationCallable() {
    return removeGroupMigrationOperationCallable;
  }

  @Override
  public UnaryCallable<ListTargetProjectsRequest, ListTargetProjectsResponse>
      listTargetProjectsCallable() {
    return listTargetProjectsCallable;
  }

  @Override
  public UnaryCallable<ListTargetProjectsRequest, ListTargetProjectsPagedResponse>
      listTargetProjectsPagedCallable() {
    return listTargetProjectsPagedCallable;
  }

  @Override
  public UnaryCallable<GetTargetProjectRequest, TargetProject> getTargetProjectCallable() {
    return getTargetProjectCallable;
  }

  @Override
  public UnaryCallable<CreateTargetProjectRequest, Operation> createTargetProjectCallable() {
    return createTargetProjectCallable;
  }

  @Override
  public OperationCallable<CreateTargetProjectRequest, TargetProject, OperationMetadata>
      createTargetProjectOperationCallable() {
    return createTargetProjectOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateTargetProjectRequest, Operation> updateTargetProjectCallable() {
    return updateTargetProjectCallable;
  }

  @Override
  public OperationCallable<UpdateTargetProjectRequest, TargetProject, OperationMetadata>
      updateTargetProjectOperationCallable() {
    return updateTargetProjectOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteTargetProjectRequest, Operation> deleteTargetProjectCallable() {
    return deleteTargetProjectCallable;
  }

  @Override
  public OperationCallable<DeleteTargetProjectRequest, Empty, OperationMetadata>
      deleteTargetProjectOperationCallable() {
    return deleteTargetProjectOperationCallable;
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
