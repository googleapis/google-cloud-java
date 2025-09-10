/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.vmmigration.v1.VmMigrationClient.FetchStorageInventoryPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListCloneJobsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListCutoverJobsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListDatacenterConnectorsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListDiskMigrationJobsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListGroupsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListImageImportJobsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListImageImportsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListLocationsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListMigratingVmsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListReplicationCyclesPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListSourcesPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListTargetProjectsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListUtilizationReportsPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vmmigration.v1.AddGroupMigrationRequest;
import com.google.cloud.vmmigration.v1.AddGroupMigrationResponse;
import com.google.cloud.vmmigration.v1.CancelCloneJobRequest;
import com.google.cloud.vmmigration.v1.CancelCloneJobResponse;
import com.google.cloud.vmmigration.v1.CancelCutoverJobRequest;
import com.google.cloud.vmmigration.v1.CancelCutoverJobResponse;
import com.google.cloud.vmmigration.v1.CancelDiskMigrationJobRequest;
import com.google.cloud.vmmigration.v1.CancelDiskMigrationJobResponse;
import com.google.cloud.vmmigration.v1.CancelImageImportJobRequest;
import com.google.cloud.vmmigration.v1.CancelImageImportJobResponse;
import com.google.cloud.vmmigration.v1.CloneJob;
import com.google.cloud.vmmigration.v1.CreateCloneJobRequest;
import com.google.cloud.vmmigration.v1.CreateCutoverJobRequest;
import com.google.cloud.vmmigration.v1.CreateDatacenterConnectorRequest;
import com.google.cloud.vmmigration.v1.CreateDiskMigrationJobRequest;
import com.google.cloud.vmmigration.v1.CreateGroupRequest;
import com.google.cloud.vmmigration.v1.CreateImageImportRequest;
import com.google.cloud.vmmigration.v1.CreateMigratingVmRequest;
import com.google.cloud.vmmigration.v1.CreateSourceRequest;
import com.google.cloud.vmmigration.v1.CreateTargetProjectRequest;
import com.google.cloud.vmmigration.v1.CreateUtilizationReportRequest;
import com.google.cloud.vmmigration.v1.CutoverJob;
import com.google.cloud.vmmigration.v1.DatacenterConnector;
import com.google.cloud.vmmigration.v1.DeleteDatacenterConnectorRequest;
import com.google.cloud.vmmigration.v1.DeleteDiskMigrationJobRequest;
import com.google.cloud.vmmigration.v1.DeleteGroupRequest;
import com.google.cloud.vmmigration.v1.DeleteImageImportRequest;
import com.google.cloud.vmmigration.v1.DeleteMigratingVmRequest;
import com.google.cloud.vmmigration.v1.DeleteSourceRequest;
import com.google.cloud.vmmigration.v1.DeleteTargetProjectRequest;
import com.google.cloud.vmmigration.v1.DeleteUtilizationReportRequest;
import com.google.cloud.vmmigration.v1.DiskMigrationJob;
import com.google.cloud.vmmigration.v1.ExtendMigrationRequest;
import com.google.cloud.vmmigration.v1.ExtendMigrationResponse;
import com.google.cloud.vmmigration.v1.FetchInventoryRequest;
import com.google.cloud.vmmigration.v1.FetchInventoryResponse;
import com.google.cloud.vmmigration.v1.FetchStorageInventoryRequest;
import com.google.cloud.vmmigration.v1.FetchStorageInventoryResponse;
import com.google.cloud.vmmigration.v1.FinalizeMigrationRequest;
import com.google.cloud.vmmigration.v1.FinalizeMigrationResponse;
import com.google.cloud.vmmigration.v1.GetCloneJobRequest;
import com.google.cloud.vmmigration.v1.GetCutoverJobRequest;
import com.google.cloud.vmmigration.v1.GetDatacenterConnectorRequest;
import com.google.cloud.vmmigration.v1.GetDiskMigrationJobRequest;
import com.google.cloud.vmmigration.v1.GetGroupRequest;
import com.google.cloud.vmmigration.v1.GetImageImportJobRequest;
import com.google.cloud.vmmigration.v1.GetImageImportRequest;
import com.google.cloud.vmmigration.v1.GetMigratingVmRequest;
import com.google.cloud.vmmigration.v1.GetReplicationCycleRequest;
import com.google.cloud.vmmigration.v1.GetSourceRequest;
import com.google.cloud.vmmigration.v1.GetTargetProjectRequest;
import com.google.cloud.vmmigration.v1.GetUtilizationReportRequest;
import com.google.cloud.vmmigration.v1.Group;
import com.google.cloud.vmmigration.v1.ImageImport;
import com.google.cloud.vmmigration.v1.ImageImportJob;
import com.google.cloud.vmmigration.v1.ListCloneJobsRequest;
import com.google.cloud.vmmigration.v1.ListCloneJobsResponse;
import com.google.cloud.vmmigration.v1.ListCutoverJobsRequest;
import com.google.cloud.vmmigration.v1.ListCutoverJobsResponse;
import com.google.cloud.vmmigration.v1.ListDatacenterConnectorsRequest;
import com.google.cloud.vmmigration.v1.ListDatacenterConnectorsResponse;
import com.google.cloud.vmmigration.v1.ListDiskMigrationJobsRequest;
import com.google.cloud.vmmigration.v1.ListDiskMigrationJobsResponse;
import com.google.cloud.vmmigration.v1.ListGroupsRequest;
import com.google.cloud.vmmigration.v1.ListGroupsResponse;
import com.google.cloud.vmmigration.v1.ListImageImportJobsRequest;
import com.google.cloud.vmmigration.v1.ListImageImportJobsResponse;
import com.google.cloud.vmmigration.v1.ListImageImportsRequest;
import com.google.cloud.vmmigration.v1.ListImageImportsResponse;
import com.google.cloud.vmmigration.v1.ListMigratingVmsRequest;
import com.google.cloud.vmmigration.v1.ListMigratingVmsResponse;
import com.google.cloud.vmmigration.v1.ListReplicationCyclesRequest;
import com.google.cloud.vmmigration.v1.ListReplicationCyclesResponse;
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
import com.google.cloud.vmmigration.v1.ReplicationCycle;
import com.google.cloud.vmmigration.v1.ResumeMigrationRequest;
import com.google.cloud.vmmigration.v1.ResumeMigrationResponse;
import com.google.cloud.vmmigration.v1.RunDiskMigrationJobRequest;
import com.google.cloud.vmmigration.v1.RunDiskMigrationJobResponse;
import com.google.cloud.vmmigration.v1.Source;
import com.google.cloud.vmmigration.v1.StartMigrationRequest;
import com.google.cloud.vmmigration.v1.StartMigrationResponse;
import com.google.cloud.vmmigration.v1.TargetProject;
import com.google.cloud.vmmigration.v1.UpdateDiskMigrationJobRequest;
import com.google.cloud.vmmigration.v1.UpdateGroupRequest;
import com.google.cloud.vmmigration.v1.UpdateMigratingVmRequest;
import com.google.cloud.vmmigration.v1.UpdateSourceRequest;
import com.google.cloud.vmmigration.v1.UpdateTargetProjectRequest;
import com.google.cloud.vmmigration.v1.UpgradeApplianceRequest;
import com.google.cloud.vmmigration.v1.UpgradeApplianceResponse;
import com.google.cloud.vmmigration.v1.UtilizationReport;
import com.google.common.collect.ImmutableMap;
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
public class HttpJsonVmMigrationStub extends VmMigrationStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(DiskMigrationJob.getDescriptor())
          .add(DatacenterConnector.getDescriptor())
          .add(MigratingVm.getDescriptor())
          .add(Empty.getDescriptor())
          .add(TargetProject.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(CancelCutoverJobResponse.getDescriptor())
          .add(Source.getDescriptor())
          .add(ExtendMigrationResponse.getDescriptor())
          .add(CloneJob.getDescriptor())
          .add(AddGroupMigrationResponse.getDescriptor())
          .add(CancelDiskMigrationJobResponse.getDescriptor())
          .add(ResumeMigrationResponse.getDescriptor())
          .add(UtilizationReport.getDescriptor())
          .add(CutoverJob.getDescriptor())
          .add(ImageImport.getDescriptor())
          .add(CancelCloneJobResponse.getDescriptor())
          .add(FinalizeMigrationResponse.getDescriptor())
          .add(RemoveGroupMigrationResponse.getDescriptor())
          .add(CancelImageImportJobResponse.getDescriptor())
          .add(RunDiskMigrationJobResponse.getDescriptor())
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("source", request.getSource(), true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("source", request.getSource(), true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
          FetchStorageInventoryRequest, FetchStorageInventoryResponse>
      fetchStorageInventoryMethodDescriptor =
          ApiMethodDescriptor
              .<FetchStorageInventoryRequest, FetchStorageInventoryResponse>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/FetchStorageInventory")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchStorageInventoryRequest>newBuilder()
                      .setPath(
                          "/v1/{source=projects/*/locations/*/sources/*}:fetchStorageInventory",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchStorageInventoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "source", request.getSource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchStorageInventoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "forceRefresh", request.getForceRefresh());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "type", request.getTypeValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchStorageInventoryResponse>newBuilder()
                      .setDefaultInstance(FetchStorageInventoryResponse.getDefaultInstance())
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
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "utilizationReport", request.getUtilizationReport(), true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "datacenterConnector",
                                      request.getDatacenterConnector(),
                                      true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearDatacenterConnector().build(),
                                      true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("migratingVm", request.getMigratingVm(), true))
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
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("migratingVm", request.getMigratingVm(), true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearMigratingVm().build(), true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearMigratingVm().build(), true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearMigratingVm().build(), true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearMigratingVm().build(), true))
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

  private static final ApiMethodDescriptor<ExtendMigrationRequest, Operation>
      extendMigrationMethodDescriptor =
          ApiMethodDescriptor.<ExtendMigrationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/ExtendMigration")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExtendMigrationRequest>newBuilder()
                      .setPath(
                          "/v1/{migratingVm=projects/*/locations/*/sources/*/migratingVms/*}:extendMigration",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExtendMigrationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "migratingVm", request.getMigratingVm());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExtendMigrationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearMigratingVm().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExtendMigrationRequest request, Operation response) ->
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("cloneJob", request.getCloneJob(), true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("cutoverJob", request.getCutoverJob(), true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("group", request.getGroup(), true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("group", request.getGroup(), true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearGroup().build(), true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearGroup().build(), true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("targetProject", request.getTargetProject(), true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("targetProject", request.getTargetProject(), true))
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<
          ListReplicationCyclesRequest, ListReplicationCyclesResponse>
      listReplicationCyclesMethodDescriptor =
          ApiMethodDescriptor
              .<ListReplicationCyclesRequest, ListReplicationCyclesResponse>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/ListReplicationCycles")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReplicationCyclesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/sources/*/migratingVms/*}/replicationCycles",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReplicationCyclesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListReplicationCyclesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListReplicationCyclesResponse>newBuilder()
                      .setDefaultInstance(ListReplicationCyclesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetReplicationCycleRequest, ReplicationCycle>
      getReplicationCycleMethodDescriptor =
          ApiMethodDescriptor.<GetReplicationCycleRequest, ReplicationCycle>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/GetReplicationCycle")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetReplicationCycleRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/sources/*/migratingVms/*/replicationCycles/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetReplicationCycleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetReplicationCycleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReplicationCycle>newBuilder()
                      .setDefaultInstance(ReplicationCycle.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListImageImportsRequest, ListImageImportsResponse>
      listImageImportsMethodDescriptor =
          ApiMethodDescriptor.<ListImageImportsRequest, ListImageImportsResponse>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/ListImageImports")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListImageImportsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/imageImports",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListImageImportsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListImageImportsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListImageImportsResponse>newBuilder()
                      .setDefaultInstance(ListImageImportsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetImageImportRequest, ImageImport>
      getImageImportMethodDescriptor =
          ApiMethodDescriptor.<GetImageImportRequest, ImageImport>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/GetImageImport")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetImageImportRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/imageImports/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetImageImportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetImageImportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ImageImport>newBuilder()
                      .setDefaultInstance(ImageImport.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateImageImportRequest, Operation>
      createImageImportMethodDescriptor =
          ApiMethodDescriptor.<CreateImageImportRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/CreateImageImport")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateImageImportRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/imageImports",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateImageImportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateImageImportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "imageImportId", request.getImageImportId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("imageImport", request.getImageImport(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateImageImportRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteImageImportRequest, Operation>
      deleteImageImportMethodDescriptor =
          ApiMethodDescriptor.<DeleteImageImportRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/DeleteImageImport")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteImageImportRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/imageImports/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteImageImportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteImageImportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                  (DeleteImageImportRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListImageImportJobsRequest, ListImageImportJobsResponse>
      listImageImportJobsMethodDescriptor =
          ApiMethodDescriptor.<ListImageImportJobsRequest, ListImageImportJobsResponse>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/ListImageImportJobs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListImageImportJobsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/imageImports/*}/imageImportJobs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListImageImportJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListImageImportJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListImageImportJobsResponse>newBuilder()
                      .setDefaultInstance(ListImageImportJobsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetImageImportJobRequest, ImageImportJob>
      getImageImportJobMethodDescriptor =
          ApiMethodDescriptor.<GetImageImportJobRequest, ImageImportJob>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/GetImageImportJob")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetImageImportJobRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/imageImports/*/imageImportJobs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetImageImportJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetImageImportJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ImageImportJob>newBuilder()
                      .setDefaultInstance(ImageImportJob.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CancelImageImportJobRequest, Operation>
      cancelImageImportJobMethodDescriptor =
          ApiMethodDescriptor.<CancelImageImportJobRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/CancelImageImportJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CancelImageImportJobRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/imageImports/*/imageImportJobs/*}:cancel",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CancelImageImportJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CancelImageImportJobRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CancelImageImportJobRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateDiskMigrationJobRequest, Operation>
      createDiskMigrationJobMethodDescriptor =
          ApiMethodDescriptor.<CreateDiskMigrationJobRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/CreateDiskMigrationJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDiskMigrationJobRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/sources/*}/diskMigrationJobs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDiskMigrationJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDiskMigrationJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "diskMigrationJobId", request.getDiskMigrationJobId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("diskMigrationJob", request.getDiskMigrationJob(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateDiskMigrationJobRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListDiskMigrationJobsRequest, ListDiskMigrationJobsResponse>
      listDiskMigrationJobsMethodDescriptor =
          ApiMethodDescriptor
              .<ListDiskMigrationJobsRequest, ListDiskMigrationJobsResponse>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/ListDiskMigrationJobs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDiskMigrationJobsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/sources/*}/diskMigrationJobs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDiskMigrationJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDiskMigrationJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDiskMigrationJobsResponse>newBuilder()
                      .setDefaultInstance(ListDiskMigrationJobsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDiskMigrationJobRequest, DiskMigrationJob>
      getDiskMigrationJobMethodDescriptor =
          ApiMethodDescriptor.<GetDiskMigrationJobRequest, DiskMigrationJob>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/GetDiskMigrationJob")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDiskMigrationJobRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/sources/*/diskMigrationJobs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDiskMigrationJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDiskMigrationJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DiskMigrationJob>newBuilder()
                      .setDefaultInstance(DiskMigrationJob.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDiskMigrationJobRequest, Operation>
      updateDiskMigrationJobMethodDescriptor =
          ApiMethodDescriptor.<UpdateDiskMigrationJobRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/UpdateDiskMigrationJob")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDiskMigrationJobRequest>newBuilder()
                      .setPath(
                          "/v1/{diskMigrationJob.name=projects/*/locations/*/sources/*/diskMigrationJobs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDiskMigrationJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "diskMigrationJob.name",
                                request.getDiskMigrationJob().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDiskMigrationJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("diskMigrationJob", request.getDiskMigrationJob(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateDiskMigrationJobRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteDiskMigrationJobRequest, Operation>
      deleteDiskMigrationJobMethodDescriptor =
          ApiMethodDescriptor.<DeleteDiskMigrationJobRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/DeleteDiskMigrationJob")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDiskMigrationJobRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/sources/*/diskMigrationJobs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDiskMigrationJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDiskMigrationJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                  (DeleteDiskMigrationJobRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RunDiskMigrationJobRequest, Operation>
      runDiskMigrationJobMethodDescriptor =
          ApiMethodDescriptor.<RunDiskMigrationJobRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/RunDiskMigrationJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RunDiskMigrationJobRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/sources/*/diskMigrationJobs/*}:run",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RunDiskMigrationJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RunDiskMigrationJobRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RunDiskMigrationJobRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CancelDiskMigrationJobRequest, Operation>
      cancelDiskMigrationJobMethodDescriptor =
          ApiMethodDescriptor.<CancelDiskMigrationJobRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/CancelDiskMigrationJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CancelDiskMigrationJobRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/sources/*/diskMigrationJobs/*}:cancel",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CancelDiskMigrationJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CancelDiskMigrationJobRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CancelDiskMigrationJobRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
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
  private final UnaryCallable<FetchStorageInventoryRequest, FetchStorageInventoryResponse>
      fetchStorageInventoryCallable;
  private final UnaryCallable<FetchStorageInventoryRequest, FetchStorageInventoryPagedResponse>
      fetchStorageInventoryPagedCallable;
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
  private final UnaryCallable<ExtendMigrationRequest, Operation> extendMigrationCallable;
  private final OperationCallable<
          ExtendMigrationRequest, ExtendMigrationResponse, OperationMetadata>
      extendMigrationOperationCallable;
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
  private final UnaryCallable<ListReplicationCyclesRequest, ListReplicationCyclesResponse>
      listReplicationCyclesCallable;
  private final UnaryCallable<ListReplicationCyclesRequest, ListReplicationCyclesPagedResponse>
      listReplicationCyclesPagedCallable;
  private final UnaryCallable<GetReplicationCycleRequest, ReplicationCycle>
      getReplicationCycleCallable;
  private final UnaryCallable<ListImageImportsRequest, ListImageImportsResponse>
      listImageImportsCallable;
  private final UnaryCallable<ListImageImportsRequest, ListImageImportsPagedResponse>
      listImageImportsPagedCallable;
  private final UnaryCallable<GetImageImportRequest, ImageImport> getImageImportCallable;
  private final UnaryCallable<CreateImageImportRequest, Operation> createImageImportCallable;
  private final OperationCallable<CreateImageImportRequest, ImageImport, OperationMetadata>
      createImageImportOperationCallable;
  private final UnaryCallable<DeleteImageImportRequest, Operation> deleteImageImportCallable;
  private final OperationCallable<DeleteImageImportRequest, Empty, OperationMetadata>
      deleteImageImportOperationCallable;
  private final UnaryCallable<ListImageImportJobsRequest, ListImageImportJobsResponse>
      listImageImportJobsCallable;
  private final UnaryCallable<ListImageImportJobsRequest, ListImageImportJobsPagedResponse>
      listImageImportJobsPagedCallable;
  private final UnaryCallable<GetImageImportJobRequest, ImageImportJob> getImageImportJobCallable;
  private final UnaryCallable<CancelImageImportJobRequest, Operation> cancelImageImportJobCallable;
  private final OperationCallable<
          CancelImageImportJobRequest, CancelImageImportJobResponse, OperationMetadata>
      cancelImageImportJobOperationCallable;
  private final UnaryCallable<CreateDiskMigrationJobRequest, Operation>
      createDiskMigrationJobCallable;
  private final OperationCallable<
          CreateDiskMigrationJobRequest, DiskMigrationJob, OperationMetadata>
      createDiskMigrationJobOperationCallable;
  private final UnaryCallable<ListDiskMigrationJobsRequest, ListDiskMigrationJobsResponse>
      listDiskMigrationJobsCallable;
  private final UnaryCallable<ListDiskMigrationJobsRequest, ListDiskMigrationJobsPagedResponse>
      listDiskMigrationJobsPagedCallable;
  private final UnaryCallable<GetDiskMigrationJobRequest, DiskMigrationJob>
      getDiskMigrationJobCallable;
  private final UnaryCallable<UpdateDiskMigrationJobRequest, Operation>
      updateDiskMigrationJobCallable;
  private final OperationCallable<
          UpdateDiskMigrationJobRequest, DiskMigrationJob, OperationMetadata>
      updateDiskMigrationJobOperationCallable;
  private final UnaryCallable<DeleteDiskMigrationJobRequest, Operation>
      deleteDiskMigrationJobCallable;
  private final OperationCallable<DeleteDiskMigrationJobRequest, Empty, OperationMetadata>
      deleteDiskMigrationJobOperationCallable;
  private final UnaryCallable<RunDiskMigrationJobRequest, Operation> runDiskMigrationJobCallable;
  private final OperationCallable<
          RunDiskMigrationJobRequest, RunDiskMigrationJobResponse, OperationMetadata>
      runDiskMigrationJobOperationCallable;
  private final UnaryCallable<CancelDiskMigrationJobRequest, Operation>
      cancelDiskMigrationJobCallable;
  private final OperationCallable<
          CancelDiskMigrationJobRequest, CancelDiskMigrationJobResponse, OperationMetadata>
      cancelDiskMigrationJobOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

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
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<ListSourcesRequest, ListSourcesResponse> listSourcesTransportSettings =
        HttpJsonCallSettings.<ListSourcesRequest, ListSourcesResponse>newBuilder()
            .setMethodDescriptor(listSourcesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetSourceRequest, Source> getSourceTransportSettings =
        HttpJsonCallSettings.<GetSourceRequest, Source>newBuilder()
            .setMethodDescriptor(getSourceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateSourceRequest, Operation> createSourceTransportSettings =
        HttpJsonCallSettings.<CreateSourceRequest, Operation>newBuilder()
            .setMethodDescriptor(createSourceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateSourceRequest, Operation> updateSourceTransportSettings =
        HttpJsonCallSettings.<UpdateSourceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSourceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("source.name", String.valueOf(request.getSource().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteSourceRequest, Operation> deleteSourceTransportSettings =
        HttpJsonCallSettings.<DeleteSourceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSourceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<FetchInventoryRequest, FetchInventoryResponse>
        fetchInventoryTransportSettings =
            HttpJsonCallSettings.<FetchInventoryRequest, FetchInventoryResponse>newBuilder()
                .setMethodDescriptor(fetchInventoryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("source", String.valueOf(request.getSource()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<FetchStorageInventoryRequest, FetchStorageInventoryResponse>
        fetchStorageInventoryTransportSettings =
            HttpJsonCallSettings
                .<FetchStorageInventoryRequest, FetchStorageInventoryResponse>newBuilder()
                .setMethodDescriptor(fetchStorageInventoryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("source", String.valueOf(request.getSource()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListUtilizationReportsRequest, ListUtilizationReportsResponse>
        listUtilizationReportsTransportSettings =
            HttpJsonCallSettings
                .<ListUtilizationReportsRequest, ListUtilizationReportsResponse>newBuilder()
                .setMethodDescriptor(listUtilizationReportsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetUtilizationReportRequest, UtilizationReport>
        getUtilizationReportTransportSettings =
            HttpJsonCallSettings.<GetUtilizationReportRequest, UtilizationReport>newBuilder()
                .setMethodDescriptor(getUtilizationReportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateUtilizationReportRequest, Operation>
        createUtilizationReportTransportSettings =
            HttpJsonCallSettings.<CreateUtilizationReportRequest, Operation>newBuilder()
                .setMethodDescriptor(createUtilizationReportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteUtilizationReportRequest, Operation>
        deleteUtilizationReportTransportSettings =
            HttpJsonCallSettings.<DeleteUtilizationReportRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteUtilizationReportMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListDatacenterConnectorsRequest, ListDatacenterConnectorsResponse>
        listDatacenterConnectorsTransportSettings =
            HttpJsonCallSettings
                .<ListDatacenterConnectorsRequest, ListDatacenterConnectorsResponse>newBuilder()
                .setMethodDescriptor(listDatacenterConnectorsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDatacenterConnectorRequest, DatacenterConnector>
        getDatacenterConnectorTransportSettings =
            HttpJsonCallSettings.<GetDatacenterConnectorRequest, DatacenterConnector>newBuilder()
                .setMethodDescriptor(getDatacenterConnectorMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateDatacenterConnectorRequest, Operation>
        createDatacenterConnectorTransportSettings =
            HttpJsonCallSettings.<CreateDatacenterConnectorRequest, Operation>newBuilder()
                .setMethodDescriptor(createDatacenterConnectorMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteDatacenterConnectorRequest, Operation>
        deleteDatacenterConnectorTransportSettings =
            HttpJsonCallSettings.<DeleteDatacenterConnectorRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteDatacenterConnectorMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpgradeApplianceRequest, Operation> upgradeApplianceTransportSettings =
        HttpJsonCallSettings.<UpgradeApplianceRequest, Operation>newBuilder()
            .setMethodDescriptor(upgradeApplianceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "datacenter_connector", String.valueOf(request.getDatacenterConnector()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateMigratingVmRequest, Operation> createMigratingVmTransportSettings =
        HttpJsonCallSettings.<CreateMigratingVmRequest, Operation>newBuilder()
            .setMethodDescriptor(createMigratingVmMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListMigratingVmsRequest, ListMigratingVmsResponse>
        listMigratingVmsTransportSettings =
            HttpJsonCallSettings.<ListMigratingVmsRequest, ListMigratingVmsResponse>newBuilder()
                .setMethodDescriptor(listMigratingVmsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetMigratingVmRequest, MigratingVm> getMigratingVmTransportSettings =
        HttpJsonCallSettings.<GetMigratingVmRequest, MigratingVm>newBuilder()
            .setMethodDescriptor(getMigratingVmMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateMigratingVmRequest, Operation> updateMigratingVmTransportSettings =
        HttpJsonCallSettings.<UpdateMigratingVmRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMigratingVmMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "migrating_vm.name", String.valueOf(request.getMigratingVm().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteMigratingVmRequest, Operation> deleteMigratingVmTransportSettings =
        HttpJsonCallSettings.<DeleteMigratingVmRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMigratingVmMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<StartMigrationRequest, Operation> startMigrationTransportSettings =
        HttpJsonCallSettings.<StartMigrationRequest, Operation>newBuilder()
            .setMethodDescriptor(startMigrationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("migrating_vm", String.valueOf(request.getMigratingVm()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ResumeMigrationRequest, Operation> resumeMigrationTransportSettings =
        HttpJsonCallSettings.<ResumeMigrationRequest, Operation>newBuilder()
            .setMethodDescriptor(resumeMigrationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("migrating_vm", String.valueOf(request.getMigratingVm()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<PauseMigrationRequest, Operation> pauseMigrationTransportSettings =
        HttpJsonCallSettings.<PauseMigrationRequest, Operation>newBuilder()
            .setMethodDescriptor(pauseMigrationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("migrating_vm", String.valueOf(request.getMigratingVm()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<FinalizeMigrationRequest, Operation> finalizeMigrationTransportSettings =
        HttpJsonCallSettings.<FinalizeMigrationRequest, Operation>newBuilder()
            .setMethodDescriptor(finalizeMigrationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("migrating_vm", String.valueOf(request.getMigratingVm()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ExtendMigrationRequest, Operation> extendMigrationTransportSettings =
        HttpJsonCallSettings.<ExtendMigrationRequest, Operation>newBuilder()
            .setMethodDescriptor(extendMigrationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("migrating_vm", String.valueOf(request.getMigratingVm()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateCloneJobRequest, Operation> createCloneJobTransportSettings =
        HttpJsonCallSettings.<CreateCloneJobRequest, Operation>newBuilder()
            .setMethodDescriptor(createCloneJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CancelCloneJobRequest, Operation> cancelCloneJobTransportSettings =
        HttpJsonCallSettings.<CancelCloneJobRequest, Operation>newBuilder()
            .setMethodDescriptor(cancelCloneJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListCloneJobsRequest, ListCloneJobsResponse>
        listCloneJobsTransportSettings =
            HttpJsonCallSettings.<ListCloneJobsRequest, ListCloneJobsResponse>newBuilder()
                .setMethodDescriptor(listCloneJobsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetCloneJobRequest, CloneJob> getCloneJobTransportSettings =
        HttpJsonCallSettings.<GetCloneJobRequest, CloneJob>newBuilder()
            .setMethodDescriptor(getCloneJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateCutoverJobRequest, Operation> createCutoverJobTransportSettings =
        HttpJsonCallSettings.<CreateCutoverJobRequest, Operation>newBuilder()
            .setMethodDescriptor(createCutoverJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CancelCutoverJobRequest, Operation> cancelCutoverJobTransportSettings =
        HttpJsonCallSettings.<CancelCutoverJobRequest, Operation>newBuilder()
            .setMethodDescriptor(cancelCutoverJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListCutoverJobsRequest, ListCutoverJobsResponse>
        listCutoverJobsTransportSettings =
            HttpJsonCallSettings.<ListCutoverJobsRequest, ListCutoverJobsResponse>newBuilder()
                .setMethodDescriptor(listCutoverJobsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetCutoverJobRequest, CutoverJob> getCutoverJobTransportSettings =
        HttpJsonCallSettings.<GetCutoverJobRequest, CutoverJob>newBuilder()
            .setMethodDescriptor(getCutoverJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListGroupsRequest, ListGroupsResponse> listGroupsTransportSettings =
        HttpJsonCallSettings.<ListGroupsRequest, ListGroupsResponse>newBuilder()
            .setMethodDescriptor(listGroupsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetGroupRequest, Group> getGroupTransportSettings =
        HttpJsonCallSettings.<GetGroupRequest, Group>newBuilder()
            .setMethodDescriptor(getGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateGroupRequest, Operation> createGroupTransportSettings =
        HttpJsonCallSettings.<CreateGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(createGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateGroupRequest, Operation> updateGroupTransportSettings =
        HttpJsonCallSettings.<UpdateGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(updateGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("group.name", String.valueOf(request.getGroup().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteGroupRequest, Operation> deleteGroupTransportSettings =
        HttpJsonCallSettings.<DeleteGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<AddGroupMigrationRequest, Operation> addGroupMigrationTransportSettings =
        HttpJsonCallSettings.<AddGroupMigrationRequest, Operation>newBuilder()
            .setMethodDescriptor(addGroupMigrationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("group", String.valueOf(request.getGroup()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RemoveGroupMigrationRequest, Operation>
        removeGroupMigrationTransportSettings =
            HttpJsonCallSettings.<RemoveGroupMigrationRequest, Operation>newBuilder()
                .setMethodDescriptor(removeGroupMigrationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("group", String.valueOf(request.getGroup()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListTargetProjectsRequest, ListTargetProjectsResponse>
        listTargetProjectsTransportSettings =
            HttpJsonCallSettings.<ListTargetProjectsRequest, ListTargetProjectsResponse>newBuilder()
                .setMethodDescriptor(listTargetProjectsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetTargetProjectRequest, TargetProject> getTargetProjectTransportSettings =
        HttpJsonCallSettings.<GetTargetProjectRequest, TargetProject>newBuilder()
            .setMethodDescriptor(getTargetProjectMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateTargetProjectRequest, Operation>
        createTargetProjectTransportSettings =
            HttpJsonCallSettings.<CreateTargetProjectRequest, Operation>newBuilder()
                .setMethodDescriptor(createTargetProjectMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateTargetProjectRequest, Operation>
        updateTargetProjectTransportSettings =
            HttpJsonCallSettings.<UpdateTargetProjectRequest, Operation>newBuilder()
                .setMethodDescriptor(updateTargetProjectMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "target_project.name",
                          String.valueOf(request.getTargetProject().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteTargetProjectRequest, Operation>
        deleteTargetProjectTransportSettings =
            HttpJsonCallSettings.<DeleteTargetProjectRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteTargetProjectMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListReplicationCyclesRequest, ListReplicationCyclesResponse>
        listReplicationCyclesTransportSettings =
            HttpJsonCallSettings
                .<ListReplicationCyclesRequest, ListReplicationCyclesResponse>newBuilder()
                .setMethodDescriptor(listReplicationCyclesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetReplicationCycleRequest, ReplicationCycle>
        getReplicationCycleTransportSettings =
            HttpJsonCallSettings.<GetReplicationCycleRequest, ReplicationCycle>newBuilder()
                .setMethodDescriptor(getReplicationCycleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListImageImportsRequest, ListImageImportsResponse>
        listImageImportsTransportSettings =
            HttpJsonCallSettings.<ListImageImportsRequest, ListImageImportsResponse>newBuilder()
                .setMethodDescriptor(listImageImportsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetImageImportRequest, ImageImport> getImageImportTransportSettings =
        HttpJsonCallSettings.<GetImageImportRequest, ImageImport>newBuilder()
            .setMethodDescriptor(getImageImportMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateImageImportRequest, Operation> createImageImportTransportSettings =
        HttpJsonCallSettings.<CreateImageImportRequest, Operation>newBuilder()
            .setMethodDescriptor(createImageImportMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteImageImportRequest, Operation> deleteImageImportTransportSettings =
        HttpJsonCallSettings.<DeleteImageImportRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteImageImportMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListImageImportJobsRequest, ListImageImportJobsResponse>
        listImageImportJobsTransportSettings =
            HttpJsonCallSettings
                .<ListImageImportJobsRequest, ListImageImportJobsResponse>newBuilder()
                .setMethodDescriptor(listImageImportJobsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetImageImportJobRequest, ImageImportJob>
        getImageImportJobTransportSettings =
            HttpJsonCallSettings.<GetImageImportJobRequest, ImageImportJob>newBuilder()
                .setMethodDescriptor(getImageImportJobMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CancelImageImportJobRequest, Operation>
        cancelImageImportJobTransportSettings =
            HttpJsonCallSettings.<CancelImageImportJobRequest, Operation>newBuilder()
                .setMethodDescriptor(cancelImageImportJobMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateDiskMigrationJobRequest, Operation>
        createDiskMigrationJobTransportSettings =
            HttpJsonCallSettings.<CreateDiskMigrationJobRequest, Operation>newBuilder()
                .setMethodDescriptor(createDiskMigrationJobMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListDiskMigrationJobsRequest, ListDiskMigrationJobsResponse>
        listDiskMigrationJobsTransportSettings =
            HttpJsonCallSettings
                .<ListDiskMigrationJobsRequest, ListDiskMigrationJobsResponse>newBuilder()
                .setMethodDescriptor(listDiskMigrationJobsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDiskMigrationJobRequest, DiskMigrationJob>
        getDiskMigrationJobTransportSettings =
            HttpJsonCallSettings.<GetDiskMigrationJobRequest, DiskMigrationJob>newBuilder()
                .setMethodDescriptor(getDiskMigrationJobMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateDiskMigrationJobRequest, Operation>
        updateDiskMigrationJobTransportSettings =
            HttpJsonCallSettings.<UpdateDiskMigrationJobRequest, Operation>newBuilder()
                .setMethodDescriptor(updateDiskMigrationJobMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "disk_migration_job.name",
                          String.valueOf(request.getDiskMigrationJob().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteDiskMigrationJobRequest, Operation>
        deleteDiskMigrationJobTransportSettings =
            HttpJsonCallSettings.<DeleteDiskMigrationJobRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteDiskMigrationJobMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RunDiskMigrationJobRequest, Operation>
        runDiskMigrationJobTransportSettings =
            HttpJsonCallSettings.<RunDiskMigrationJobRequest, Operation>newBuilder()
                .setMethodDescriptor(runDiskMigrationJobMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CancelDiskMigrationJobRequest, Operation>
        cancelDiskMigrationJobTransportSettings =
            HttpJsonCallSettings.<CancelDiskMigrationJobRequest, Operation>newBuilder()
                .setMethodDescriptor(cancelDiskMigrationJobMethodDescriptor)
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
    this.fetchStorageInventoryCallable =
        callableFactory.createUnaryCallable(
            fetchStorageInventoryTransportSettings,
            settings.fetchStorageInventorySettings(),
            clientContext);
    this.fetchStorageInventoryPagedCallable =
        callableFactory.createPagedCallable(
            fetchStorageInventoryTransportSettings,
            settings.fetchStorageInventorySettings(),
            clientContext);
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
    this.extendMigrationCallable =
        callableFactory.createUnaryCallable(
            extendMigrationTransportSettings, settings.extendMigrationSettings(), clientContext);
    this.extendMigrationOperationCallable =
        callableFactory.createOperationCallable(
            extendMigrationTransportSettings,
            settings.extendMigrationOperationSettings(),
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
    this.listReplicationCyclesCallable =
        callableFactory.createUnaryCallable(
            listReplicationCyclesTransportSettings,
            settings.listReplicationCyclesSettings(),
            clientContext);
    this.listReplicationCyclesPagedCallable =
        callableFactory.createPagedCallable(
            listReplicationCyclesTransportSettings,
            settings.listReplicationCyclesSettings(),
            clientContext);
    this.getReplicationCycleCallable =
        callableFactory.createUnaryCallable(
            getReplicationCycleTransportSettings,
            settings.getReplicationCycleSettings(),
            clientContext);
    this.listImageImportsCallable =
        callableFactory.createUnaryCallable(
            listImageImportsTransportSettings, settings.listImageImportsSettings(), clientContext);
    this.listImageImportsPagedCallable =
        callableFactory.createPagedCallable(
            listImageImportsTransportSettings, settings.listImageImportsSettings(), clientContext);
    this.getImageImportCallable =
        callableFactory.createUnaryCallable(
            getImageImportTransportSettings, settings.getImageImportSettings(), clientContext);
    this.createImageImportCallable =
        callableFactory.createUnaryCallable(
            createImageImportTransportSettings,
            settings.createImageImportSettings(),
            clientContext);
    this.createImageImportOperationCallable =
        callableFactory.createOperationCallable(
            createImageImportTransportSettings,
            settings.createImageImportOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteImageImportCallable =
        callableFactory.createUnaryCallable(
            deleteImageImportTransportSettings,
            settings.deleteImageImportSettings(),
            clientContext);
    this.deleteImageImportOperationCallable =
        callableFactory.createOperationCallable(
            deleteImageImportTransportSettings,
            settings.deleteImageImportOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listImageImportJobsCallable =
        callableFactory.createUnaryCallable(
            listImageImportJobsTransportSettings,
            settings.listImageImportJobsSettings(),
            clientContext);
    this.listImageImportJobsPagedCallable =
        callableFactory.createPagedCallable(
            listImageImportJobsTransportSettings,
            settings.listImageImportJobsSettings(),
            clientContext);
    this.getImageImportJobCallable =
        callableFactory.createUnaryCallable(
            getImageImportJobTransportSettings,
            settings.getImageImportJobSettings(),
            clientContext);
    this.cancelImageImportJobCallable =
        callableFactory.createUnaryCallable(
            cancelImageImportJobTransportSettings,
            settings.cancelImageImportJobSettings(),
            clientContext);
    this.cancelImageImportJobOperationCallable =
        callableFactory.createOperationCallable(
            cancelImageImportJobTransportSettings,
            settings.cancelImageImportJobOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createDiskMigrationJobCallable =
        callableFactory.createUnaryCallable(
            createDiskMigrationJobTransportSettings,
            settings.createDiskMigrationJobSettings(),
            clientContext);
    this.createDiskMigrationJobOperationCallable =
        callableFactory.createOperationCallable(
            createDiskMigrationJobTransportSettings,
            settings.createDiskMigrationJobOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listDiskMigrationJobsCallable =
        callableFactory.createUnaryCallable(
            listDiskMigrationJobsTransportSettings,
            settings.listDiskMigrationJobsSettings(),
            clientContext);
    this.listDiskMigrationJobsPagedCallable =
        callableFactory.createPagedCallable(
            listDiskMigrationJobsTransportSettings,
            settings.listDiskMigrationJobsSettings(),
            clientContext);
    this.getDiskMigrationJobCallable =
        callableFactory.createUnaryCallable(
            getDiskMigrationJobTransportSettings,
            settings.getDiskMigrationJobSettings(),
            clientContext);
    this.updateDiskMigrationJobCallable =
        callableFactory.createUnaryCallable(
            updateDiskMigrationJobTransportSettings,
            settings.updateDiskMigrationJobSettings(),
            clientContext);
    this.updateDiskMigrationJobOperationCallable =
        callableFactory.createOperationCallable(
            updateDiskMigrationJobTransportSettings,
            settings.updateDiskMigrationJobOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteDiskMigrationJobCallable =
        callableFactory.createUnaryCallable(
            deleteDiskMigrationJobTransportSettings,
            settings.deleteDiskMigrationJobSettings(),
            clientContext);
    this.deleteDiskMigrationJobOperationCallable =
        callableFactory.createOperationCallable(
            deleteDiskMigrationJobTransportSettings,
            settings.deleteDiskMigrationJobOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.runDiskMigrationJobCallable =
        callableFactory.createUnaryCallable(
            runDiskMigrationJobTransportSettings,
            settings.runDiskMigrationJobSettings(),
            clientContext);
    this.runDiskMigrationJobOperationCallable =
        callableFactory.createOperationCallable(
            runDiskMigrationJobTransportSettings,
            settings.runDiskMigrationJobOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.cancelDiskMigrationJobCallable =
        callableFactory.createUnaryCallable(
            cancelDiskMigrationJobTransportSettings,
            settings.cancelDiskMigrationJobSettings(),
            clientContext);
    this.cancelDiskMigrationJobOperationCallable =
        callableFactory.createOperationCallable(
            cancelDiskMigrationJobTransportSettings,
            settings.cancelDiskMigrationJobOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

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
    methodDescriptors.add(fetchStorageInventoryMethodDescriptor);
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
    methodDescriptors.add(extendMigrationMethodDescriptor);
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
    methodDescriptors.add(listReplicationCyclesMethodDescriptor);
    methodDescriptors.add(getReplicationCycleMethodDescriptor);
    methodDescriptors.add(listImageImportsMethodDescriptor);
    methodDescriptors.add(getImageImportMethodDescriptor);
    methodDescriptors.add(createImageImportMethodDescriptor);
    methodDescriptors.add(deleteImageImportMethodDescriptor);
    methodDescriptors.add(listImageImportJobsMethodDescriptor);
    methodDescriptors.add(getImageImportJobMethodDescriptor);
    methodDescriptors.add(cancelImageImportJobMethodDescriptor);
    methodDescriptors.add(createDiskMigrationJobMethodDescriptor);
    methodDescriptors.add(listDiskMigrationJobsMethodDescriptor);
    methodDescriptors.add(getDiskMigrationJobMethodDescriptor);
    methodDescriptors.add(updateDiskMigrationJobMethodDescriptor);
    methodDescriptors.add(deleteDiskMigrationJobMethodDescriptor);
    methodDescriptors.add(runDiskMigrationJobMethodDescriptor);
    methodDescriptors.add(cancelDiskMigrationJobMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
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
  public UnaryCallable<FetchStorageInventoryRequest, FetchStorageInventoryResponse>
      fetchStorageInventoryCallable() {
    return fetchStorageInventoryCallable;
  }

  @Override
  public UnaryCallable<FetchStorageInventoryRequest, FetchStorageInventoryPagedResponse>
      fetchStorageInventoryPagedCallable() {
    return fetchStorageInventoryPagedCallable;
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
  public UnaryCallable<ExtendMigrationRequest, Operation> extendMigrationCallable() {
    return extendMigrationCallable;
  }

  @Override
  public OperationCallable<ExtendMigrationRequest, ExtendMigrationResponse, OperationMetadata>
      extendMigrationOperationCallable() {
    return extendMigrationOperationCallable;
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
  public UnaryCallable<ListReplicationCyclesRequest, ListReplicationCyclesResponse>
      listReplicationCyclesCallable() {
    return listReplicationCyclesCallable;
  }

  @Override
  public UnaryCallable<ListReplicationCyclesRequest, ListReplicationCyclesPagedResponse>
      listReplicationCyclesPagedCallable() {
    return listReplicationCyclesPagedCallable;
  }

  @Override
  public UnaryCallable<GetReplicationCycleRequest, ReplicationCycle> getReplicationCycleCallable() {
    return getReplicationCycleCallable;
  }

  @Override
  public UnaryCallable<ListImageImportsRequest, ListImageImportsResponse>
      listImageImportsCallable() {
    return listImageImportsCallable;
  }

  @Override
  public UnaryCallable<ListImageImportsRequest, ListImageImportsPagedResponse>
      listImageImportsPagedCallable() {
    return listImageImportsPagedCallable;
  }

  @Override
  public UnaryCallable<GetImageImportRequest, ImageImport> getImageImportCallable() {
    return getImageImportCallable;
  }

  @Override
  public UnaryCallable<CreateImageImportRequest, Operation> createImageImportCallable() {
    return createImageImportCallable;
  }

  @Override
  public OperationCallable<CreateImageImportRequest, ImageImport, OperationMetadata>
      createImageImportOperationCallable() {
    return createImageImportOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteImageImportRequest, Operation> deleteImageImportCallable() {
    return deleteImageImportCallable;
  }

  @Override
  public OperationCallable<DeleteImageImportRequest, Empty, OperationMetadata>
      deleteImageImportOperationCallable() {
    return deleteImageImportOperationCallable;
  }

  @Override
  public UnaryCallable<ListImageImportJobsRequest, ListImageImportJobsResponse>
      listImageImportJobsCallable() {
    return listImageImportJobsCallable;
  }

  @Override
  public UnaryCallable<ListImageImportJobsRequest, ListImageImportJobsPagedResponse>
      listImageImportJobsPagedCallable() {
    return listImageImportJobsPagedCallable;
  }

  @Override
  public UnaryCallable<GetImageImportJobRequest, ImageImportJob> getImageImportJobCallable() {
    return getImageImportJobCallable;
  }

  @Override
  public UnaryCallable<CancelImageImportJobRequest, Operation> cancelImageImportJobCallable() {
    return cancelImageImportJobCallable;
  }

  @Override
  public OperationCallable<
          CancelImageImportJobRequest, CancelImageImportJobResponse, OperationMetadata>
      cancelImageImportJobOperationCallable() {
    return cancelImageImportJobOperationCallable;
  }

  @Override
  public UnaryCallable<CreateDiskMigrationJobRequest, Operation> createDiskMigrationJobCallable() {
    return createDiskMigrationJobCallable;
  }

  @Override
  public OperationCallable<CreateDiskMigrationJobRequest, DiskMigrationJob, OperationMetadata>
      createDiskMigrationJobOperationCallable() {
    return createDiskMigrationJobOperationCallable;
  }

  @Override
  public UnaryCallable<ListDiskMigrationJobsRequest, ListDiskMigrationJobsResponse>
      listDiskMigrationJobsCallable() {
    return listDiskMigrationJobsCallable;
  }

  @Override
  public UnaryCallable<ListDiskMigrationJobsRequest, ListDiskMigrationJobsPagedResponse>
      listDiskMigrationJobsPagedCallable() {
    return listDiskMigrationJobsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDiskMigrationJobRequest, DiskMigrationJob> getDiskMigrationJobCallable() {
    return getDiskMigrationJobCallable;
  }

  @Override
  public UnaryCallable<UpdateDiskMigrationJobRequest, Operation> updateDiskMigrationJobCallable() {
    return updateDiskMigrationJobCallable;
  }

  @Override
  public OperationCallable<UpdateDiskMigrationJobRequest, DiskMigrationJob, OperationMetadata>
      updateDiskMigrationJobOperationCallable() {
    return updateDiskMigrationJobOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDiskMigrationJobRequest, Operation> deleteDiskMigrationJobCallable() {
    return deleteDiskMigrationJobCallable;
  }

  @Override
  public OperationCallable<DeleteDiskMigrationJobRequest, Empty, OperationMetadata>
      deleteDiskMigrationJobOperationCallable() {
    return deleteDiskMigrationJobOperationCallable;
  }

  @Override
  public UnaryCallable<RunDiskMigrationJobRequest, Operation> runDiskMigrationJobCallable() {
    return runDiskMigrationJobCallable;
  }

  @Override
  public OperationCallable<
          RunDiskMigrationJobRequest, RunDiskMigrationJobResponse, OperationMetadata>
      runDiskMigrationJobOperationCallable() {
    return runDiskMigrationJobOperationCallable;
  }

  @Override
  public UnaryCallable<CancelDiskMigrationJobRequest, Operation> cancelDiskMigrationJobCallable() {
    return cancelDiskMigrationJobCallable;
  }

  @Override
  public OperationCallable<
          CancelDiskMigrationJobRequest, CancelDiskMigrationJobResponse, OperationMetadata>
      cancelDiskMigrationJobOperationCallable() {
    return cancelDiskMigrationJobOperationCallable;
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
