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

package com.google.cloud.migrationcenter.v1.stub;

import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListAssetsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListErrorFramesPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListGroupsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListImportDataFilesPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListImportJobsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListLocationsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListPreferenceSetsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListReportConfigsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListReportsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListSourcesPagedResponse;

import com.google.api.HttpRule;
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
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.migrationcenter.v1.AddAssetsToGroupRequest;
import com.google.cloud.migrationcenter.v1.AggregateAssetsValuesRequest;
import com.google.cloud.migrationcenter.v1.AggregateAssetsValuesResponse;
import com.google.cloud.migrationcenter.v1.Asset;
import com.google.cloud.migrationcenter.v1.BatchDeleteAssetsRequest;
import com.google.cloud.migrationcenter.v1.BatchUpdateAssetsRequest;
import com.google.cloud.migrationcenter.v1.BatchUpdateAssetsResponse;
import com.google.cloud.migrationcenter.v1.CreateGroupRequest;
import com.google.cloud.migrationcenter.v1.CreateImportDataFileRequest;
import com.google.cloud.migrationcenter.v1.CreateImportJobRequest;
import com.google.cloud.migrationcenter.v1.CreatePreferenceSetRequest;
import com.google.cloud.migrationcenter.v1.CreateReportConfigRequest;
import com.google.cloud.migrationcenter.v1.CreateReportRequest;
import com.google.cloud.migrationcenter.v1.CreateSourceRequest;
import com.google.cloud.migrationcenter.v1.DeleteAssetRequest;
import com.google.cloud.migrationcenter.v1.DeleteGroupRequest;
import com.google.cloud.migrationcenter.v1.DeleteImportDataFileRequest;
import com.google.cloud.migrationcenter.v1.DeleteImportJobRequest;
import com.google.cloud.migrationcenter.v1.DeletePreferenceSetRequest;
import com.google.cloud.migrationcenter.v1.DeleteReportConfigRequest;
import com.google.cloud.migrationcenter.v1.DeleteReportRequest;
import com.google.cloud.migrationcenter.v1.DeleteSourceRequest;
import com.google.cloud.migrationcenter.v1.ErrorFrame;
import com.google.cloud.migrationcenter.v1.GetAssetRequest;
import com.google.cloud.migrationcenter.v1.GetErrorFrameRequest;
import com.google.cloud.migrationcenter.v1.GetGroupRequest;
import com.google.cloud.migrationcenter.v1.GetImportDataFileRequest;
import com.google.cloud.migrationcenter.v1.GetImportJobRequest;
import com.google.cloud.migrationcenter.v1.GetPreferenceSetRequest;
import com.google.cloud.migrationcenter.v1.GetReportConfigRequest;
import com.google.cloud.migrationcenter.v1.GetReportRequest;
import com.google.cloud.migrationcenter.v1.GetSettingsRequest;
import com.google.cloud.migrationcenter.v1.GetSourceRequest;
import com.google.cloud.migrationcenter.v1.Group;
import com.google.cloud.migrationcenter.v1.ImportDataFile;
import com.google.cloud.migrationcenter.v1.ImportJob;
import com.google.cloud.migrationcenter.v1.ListAssetsRequest;
import com.google.cloud.migrationcenter.v1.ListAssetsResponse;
import com.google.cloud.migrationcenter.v1.ListErrorFramesRequest;
import com.google.cloud.migrationcenter.v1.ListErrorFramesResponse;
import com.google.cloud.migrationcenter.v1.ListGroupsRequest;
import com.google.cloud.migrationcenter.v1.ListGroupsResponse;
import com.google.cloud.migrationcenter.v1.ListImportDataFilesRequest;
import com.google.cloud.migrationcenter.v1.ListImportDataFilesResponse;
import com.google.cloud.migrationcenter.v1.ListImportJobsRequest;
import com.google.cloud.migrationcenter.v1.ListImportJobsResponse;
import com.google.cloud.migrationcenter.v1.ListPreferenceSetsRequest;
import com.google.cloud.migrationcenter.v1.ListPreferenceSetsResponse;
import com.google.cloud.migrationcenter.v1.ListReportConfigsRequest;
import com.google.cloud.migrationcenter.v1.ListReportConfigsResponse;
import com.google.cloud.migrationcenter.v1.ListReportsRequest;
import com.google.cloud.migrationcenter.v1.ListReportsResponse;
import com.google.cloud.migrationcenter.v1.ListSourcesRequest;
import com.google.cloud.migrationcenter.v1.ListSourcesResponse;
import com.google.cloud.migrationcenter.v1.OperationMetadata;
import com.google.cloud.migrationcenter.v1.PreferenceSet;
import com.google.cloud.migrationcenter.v1.RemoveAssetsFromGroupRequest;
import com.google.cloud.migrationcenter.v1.Report;
import com.google.cloud.migrationcenter.v1.ReportAssetFramesRequest;
import com.google.cloud.migrationcenter.v1.ReportAssetFramesResponse;
import com.google.cloud.migrationcenter.v1.ReportConfig;
import com.google.cloud.migrationcenter.v1.RunImportJobRequest;
import com.google.cloud.migrationcenter.v1.Settings;
import com.google.cloud.migrationcenter.v1.Source;
import com.google.cloud.migrationcenter.v1.UpdateAssetRequest;
import com.google.cloud.migrationcenter.v1.UpdateGroupRequest;
import com.google.cloud.migrationcenter.v1.UpdateImportJobRequest;
import com.google.cloud.migrationcenter.v1.UpdatePreferenceSetRequest;
import com.google.cloud.migrationcenter.v1.UpdateSettingsRequest;
import com.google.cloud.migrationcenter.v1.UpdateSourceRequest;
import com.google.cloud.migrationcenter.v1.ValidateImportJobRequest;
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
 * REST stub implementation for the MigrationCenter service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonMigrationCenterStub extends MigrationCenterStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(ImportDataFile.getDescriptor())
          .add(Source.getDescriptor())
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(ReportConfig.getDescriptor())
          .add(PreferenceSet.getDescriptor())
          .add(Settings.getDescriptor())
          .add(Report.getDescriptor())
          .add(ImportJob.getDescriptor())
          .add(Group.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListAssetsRequest, ListAssetsResponse>
      listAssetsMethodDescriptor =
          ApiMethodDescriptor.<ListAssetsRequest, ListAssetsResponse>newBuilder()
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/ListAssets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAssetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/assets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAssetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAssetsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAssetsResponse>newBuilder()
                      .setDefaultInstance(ListAssetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAssetRequest, Asset> getAssetMethodDescriptor =
      ApiMethodDescriptor.<GetAssetRequest, Asset>newBuilder()
          .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/GetAsset")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetAssetRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/assets/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetAssetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetAssetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "view", request.getViewValue());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Asset>newBuilder()
                  .setDefaultInstance(Asset.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateAssetRequest, Asset> updateAssetMethodDescriptor =
      ApiMethodDescriptor.<UpdateAssetRequest, Asset>newBuilder()
          .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/UpdateAsset")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateAssetRequest>newBuilder()
                  .setPath(
                      "/v1/{asset.name=projects/*/locations/*/assets/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateAssetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "asset.name", request.getAsset().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateAssetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("asset", request.getAsset(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Asset>newBuilder()
                  .setDefaultInstance(Asset.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<BatchUpdateAssetsRequest, BatchUpdateAssetsResponse>
      batchUpdateAssetsMethodDescriptor =
          ApiMethodDescriptor.<BatchUpdateAssetsRequest, BatchUpdateAssetsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/BatchUpdateAssets")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateAssetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/assets:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateAssetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateAssetsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdateAssetsResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateAssetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAssetRequest, Empty> deleteAssetMethodDescriptor =
      ApiMethodDescriptor.<DeleteAssetRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/DeleteAsset")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteAssetRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/assets/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteAssetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteAssetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "requestId", request.getRequestId());
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

  private static final ApiMethodDescriptor<BatchDeleteAssetsRequest, Empty>
      batchDeleteAssetsMethodDescriptor =
          ApiMethodDescriptor.<BatchDeleteAssetsRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/BatchDeleteAssets")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDeleteAssetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/assets:batchDelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteAssetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteAssetsRequest> serializer =
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
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ReportAssetFramesRequest, ReportAssetFramesResponse>
      reportAssetFramesMethodDescriptor =
          ApiMethodDescriptor.<ReportAssetFramesRequest, ReportAssetFramesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/ReportAssetFrames")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ReportAssetFramesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/assets:reportAssetFrames",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ReportAssetFramesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ReportAssetFramesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "source", request.getSource());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("frames", request.getFrames(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReportAssetFramesResponse>newBuilder()
                      .setDefaultInstance(ReportAssetFramesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          AggregateAssetsValuesRequest, AggregateAssetsValuesResponse>
      aggregateAssetsValuesMethodDescriptor =
          ApiMethodDescriptor
              .<AggregateAssetsValuesRequest, AggregateAssetsValuesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/AggregateAssetsValues")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregateAssetsValuesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/assets:aggregateValues",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregateAssetsValuesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AggregateAssetsValuesRequest> serializer =
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
                  ProtoMessageResponseParser.<AggregateAssetsValuesResponse>newBuilder()
                      .setDefaultInstance(AggregateAssetsValuesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateImportJobRequest, Operation>
      createImportJobMethodDescriptor =
          ApiMethodDescriptor.<CreateImportJobRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/CreateImportJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateImportJobRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/importJobs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateImportJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateImportJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "importJobId", request.getImportJobId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("importJob", request.getImportJob(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateImportJobRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListImportJobsRequest, ListImportJobsResponse>
      listImportJobsMethodDescriptor =
          ApiMethodDescriptor.<ListImportJobsRequest, ListImportJobsResponse>newBuilder()
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/ListImportJobs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListImportJobsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/importJobs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListImportJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListImportJobsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListImportJobsResponse>newBuilder()
                      .setDefaultInstance(ListImportJobsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetImportJobRequest, ImportJob>
      getImportJobMethodDescriptor =
          ApiMethodDescriptor.<GetImportJobRequest, ImportJob>newBuilder()
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/GetImportJob")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetImportJobRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/importJobs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetImportJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetImportJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ImportJob>newBuilder()
                      .setDefaultInstance(ImportJob.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteImportJobRequest, Operation>
      deleteImportJobMethodDescriptor =
          ApiMethodDescriptor.<DeleteImportJobRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/DeleteImportJob")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteImportJobRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/importJobs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteImportJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteImportJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
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
                  (DeleteImportJobRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateImportJobRequest, Operation>
      updateImportJobMethodDescriptor =
          ApiMethodDescriptor.<UpdateImportJobRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/UpdateImportJob")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateImportJobRequest>newBuilder()
                      .setPath(
                          "/v1/{importJob.name=projects/*/locations/*/importJobs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateImportJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "importJob.name", request.getImportJob().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateImportJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("importJob", request.getImportJob(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateImportJobRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ValidateImportJobRequest, Operation>
      validateImportJobMethodDescriptor =
          ApiMethodDescriptor.<ValidateImportJobRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/ValidateImportJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ValidateImportJobRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/importJobs/*}:validate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ValidateImportJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ValidateImportJobRequest> serializer =
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
                  (ValidateImportJobRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RunImportJobRequest, Operation>
      runImportJobMethodDescriptor =
          ApiMethodDescriptor.<RunImportJobRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/RunImportJob")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RunImportJobRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/importJobs/*}:run",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RunImportJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RunImportJobRequest> serializer =
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
                  (RunImportJobRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetImportDataFileRequest, ImportDataFile>
      getImportDataFileMethodDescriptor =
          ApiMethodDescriptor.<GetImportDataFileRequest, ImportDataFile>newBuilder()
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/GetImportDataFile")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetImportDataFileRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/importJobs/*/importDataFiles/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetImportDataFileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetImportDataFileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ImportDataFile>newBuilder()
                      .setDefaultInstance(ImportDataFile.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListImportDataFilesRequest, ListImportDataFilesResponse>
      listImportDataFilesMethodDescriptor =
          ApiMethodDescriptor.<ListImportDataFilesRequest, ListImportDataFilesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/ListImportDataFiles")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListImportDataFilesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/importJobs/*}/importDataFiles",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListImportDataFilesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListImportDataFilesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListImportDataFilesResponse>newBuilder()
                      .setDefaultInstance(ListImportDataFilesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateImportDataFileRequest, Operation>
      createImportDataFileMethodDescriptor =
          ApiMethodDescriptor.<CreateImportDataFileRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/CreateImportDataFile")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateImportDataFileRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/importJobs/*}/importDataFiles",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateImportDataFileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateImportDataFileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "importDataFileId", request.getImportDataFileId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("importDataFile", request.getImportDataFile(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateImportDataFileRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteImportDataFileRequest, Operation>
      deleteImportDataFileMethodDescriptor =
          ApiMethodDescriptor.<DeleteImportDataFileRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/DeleteImportDataFile")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteImportDataFileRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/importJobs/*/importDataFiles/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteImportDataFileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteImportDataFileRequest> serializer =
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
                  (DeleteImportDataFileRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListGroupsRequest, ListGroupsResponse>
      listGroupsMethodDescriptor =
          ApiMethodDescriptor.<ListGroupsRequest, ListGroupsResponse>newBuilder()
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/ListGroups")
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
          .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/GetGroup")
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
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/CreateGroup")
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
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/UpdateGroup")
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
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/DeleteGroup")
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

  private static final ApiMethodDescriptor<AddAssetsToGroupRequest, Operation>
      addAssetsToGroupMethodDescriptor =
          ApiMethodDescriptor.<AddAssetsToGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/AddAssetsToGroup")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddAssetsToGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{group=projects/*/locations/*/groups/*}:addAssets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddAssetsToGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "group", request.getGroup());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddAssetsToGroupRequest> serializer =
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
                  (AddAssetsToGroupRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RemoveAssetsFromGroupRequest, Operation>
      removeAssetsFromGroupMethodDescriptor =
          ApiMethodDescriptor.<RemoveAssetsFromGroupRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/RemoveAssetsFromGroup")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveAssetsFromGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{group=projects/*/locations/*/groups/*}:removeAssets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveAssetsFromGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "group", request.getGroup());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveAssetsFromGroupRequest> serializer =
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
                  (RemoveAssetsFromGroupRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListErrorFramesRequest, ListErrorFramesResponse>
      listErrorFramesMethodDescriptor =
          ApiMethodDescriptor.<ListErrorFramesRequest, ListErrorFramesResponse>newBuilder()
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/ListErrorFrames")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListErrorFramesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/sources/*}/errorFrames",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListErrorFramesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListErrorFramesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListErrorFramesResponse>newBuilder()
                      .setDefaultInstance(ListErrorFramesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetErrorFrameRequest, ErrorFrame>
      getErrorFrameMethodDescriptor =
          ApiMethodDescriptor.<GetErrorFrameRequest, ErrorFrame>newBuilder()
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/GetErrorFrame")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetErrorFrameRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/sources/*/errorFrames/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetErrorFrameRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetErrorFrameRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ErrorFrame>newBuilder()
                      .setDefaultInstance(ErrorFrame.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListSourcesRequest, ListSourcesResponse>
      listSourcesMethodDescriptor =
          ApiMethodDescriptor.<ListSourcesRequest, ListSourcesResponse>newBuilder()
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/ListSources")
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
          .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/GetSource")
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
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/CreateSource")
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
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/UpdateSource")
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
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/DeleteSource")
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

  private static final ApiMethodDescriptor<ListPreferenceSetsRequest, ListPreferenceSetsResponse>
      listPreferenceSetsMethodDescriptor =
          ApiMethodDescriptor.<ListPreferenceSetsRequest, ListPreferenceSetsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/ListPreferenceSets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPreferenceSetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/preferenceSets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPreferenceSetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPreferenceSetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPreferenceSetsResponse>newBuilder()
                      .setDefaultInstance(ListPreferenceSetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPreferenceSetRequest, PreferenceSet>
      getPreferenceSetMethodDescriptor =
          ApiMethodDescriptor.<GetPreferenceSetRequest, PreferenceSet>newBuilder()
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/GetPreferenceSet")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPreferenceSetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/preferenceSets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPreferenceSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPreferenceSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PreferenceSet>newBuilder()
                      .setDefaultInstance(PreferenceSet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreatePreferenceSetRequest, Operation>
      createPreferenceSetMethodDescriptor =
          ApiMethodDescriptor.<CreatePreferenceSetRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/CreatePreferenceSet")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePreferenceSetRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/preferenceSets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePreferenceSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePreferenceSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "preferenceSetId", request.getPreferenceSetId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("preferenceSet", request.getPreferenceSet(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreatePreferenceSetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdatePreferenceSetRequest, Operation>
      updatePreferenceSetMethodDescriptor =
          ApiMethodDescriptor.<UpdatePreferenceSetRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/UpdatePreferenceSet")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePreferenceSetRequest>newBuilder()
                      .setPath(
                          "/v1/{preferenceSet.name=projects/*/locations/*/preferenceSets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePreferenceSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "preferenceSet.name", request.getPreferenceSet().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePreferenceSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("preferenceSet", request.getPreferenceSet(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdatePreferenceSetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeletePreferenceSetRequest, Operation>
      deletePreferenceSetMethodDescriptor =
          ApiMethodDescriptor.<DeletePreferenceSetRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/DeletePreferenceSet")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePreferenceSetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/preferenceSets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePreferenceSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePreferenceSetRequest> serializer =
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
                  (DeletePreferenceSetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetSettingsRequest, Settings>
      getSettingsMethodDescriptor =
          ApiMethodDescriptor.<GetSettingsRequest, Settings>newBuilder()
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/GetSettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSettingsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/settings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Settings>newBuilder()
                      .setDefaultInstance(Settings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSettingsRequest, Operation>
      updateSettingsMethodDescriptor =
          ApiMethodDescriptor.<UpdateSettingsRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/UpdateSettings")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSettingsRequest>newBuilder()
                      .setPath(
                          "/v1/{settings.name=projects/*/locations/*/settings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "settings.name", request.getSettings().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("settings", request.getSettings(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateSettingsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateReportConfigRequest, Operation>
      createReportConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateReportConfigRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/CreateReportConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateReportConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/reportConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReportConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReportConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "reportConfigId", request.getReportConfigId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("reportConfig", request.getReportConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateReportConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetReportConfigRequest, ReportConfig>
      getReportConfigMethodDescriptor =
          ApiMethodDescriptor.<GetReportConfigRequest, ReportConfig>newBuilder()
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/GetReportConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetReportConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/reportConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetReportConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetReportConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReportConfig>newBuilder()
                      .setDefaultInstance(ReportConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListReportConfigsRequest, ListReportConfigsResponse>
      listReportConfigsMethodDescriptor =
          ApiMethodDescriptor.<ListReportConfigsRequest, ListReportConfigsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/ListReportConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReportConfigsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/reportConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReportConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListReportConfigsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListReportConfigsResponse>newBuilder()
                      .setDefaultInstance(ListReportConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteReportConfigRequest, Operation>
      deleteReportConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteReportConfigRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/DeleteReportConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteReportConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/reportConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteReportConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteReportConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
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
                  (DeleteReportConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateReportRequest, Operation>
      createReportMethodDescriptor =
          ApiMethodDescriptor.<CreateReportRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/CreateReport")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateReportRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/reportConfigs/*}/reports",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "reportId", request.getReportId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("report", request.getReport(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateReportRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetReportRequest, Report> getReportMethodDescriptor =
      ApiMethodDescriptor.<GetReportRequest, Report>newBuilder()
          .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/GetReport")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetReportRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/reportConfigs/*/reports/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetReportRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetReportRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "view", request.getViewValue());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Report>newBuilder()
                  .setDefaultInstance(Report.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListReportsRequest, ListReportsResponse>
      listReportsMethodDescriptor =
          ApiMethodDescriptor.<ListReportsRequest, ListReportsResponse>newBuilder()
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/ListReports")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReportsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/reportConfigs/*}/reports",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReportsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListReportsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListReportsResponse>newBuilder()
                      .setDefaultInstance(ListReportsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteReportRequest, Operation>
      deleteReportMethodDescriptor =
          ApiMethodDescriptor.<DeleteReportRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/DeleteReport")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteReportRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/reportConfigs/*/reports/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteReportRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteReportRequest> serializer =
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
                  (DeleteReportRequest request, Operation response) ->
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

  private final UnaryCallable<ListAssetsRequest, ListAssetsResponse> listAssetsCallable;
  private final UnaryCallable<ListAssetsRequest, ListAssetsPagedResponse> listAssetsPagedCallable;
  private final UnaryCallable<GetAssetRequest, Asset> getAssetCallable;
  private final UnaryCallable<UpdateAssetRequest, Asset> updateAssetCallable;
  private final UnaryCallable<BatchUpdateAssetsRequest, BatchUpdateAssetsResponse>
      batchUpdateAssetsCallable;
  private final UnaryCallable<DeleteAssetRequest, Empty> deleteAssetCallable;
  private final UnaryCallable<BatchDeleteAssetsRequest, Empty> batchDeleteAssetsCallable;
  private final UnaryCallable<ReportAssetFramesRequest, ReportAssetFramesResponse>
      reportAssetFramesCallable;
  private final UnaryCallable<AggregateAssetsValuesRequest, AggregateAssetsValuesResponse>
      aggregateAssetsValuesCallable;
  private final UnaryCallable<CreateImportJobRequest, Operation> createImportJobCallable;
  private final OperationCallable<CreateImportJobRequest, ImportJob, OperationMetadata>
      createImportJobOperationCallable;
  private final UnaryCallable<ListImportJobsRequest, ListImportJobsResponse> listImportJobsCallable;
  private final UnaryCallable<ListImportJobsRequest, ListImportJobsPagedResponse>
      listImportJobsPagedCallable;
  private final UnaryCallable<GetImportJobRequest, ImportJob> getImportJobCallable;
  private final UnaryCallable<DeleteImportJobRequest, Operation> deleteImportJobCallable;
  private final OperationCallable<DeleteImportJobRequest, Empty, OperationMetadata>
      deleteImportJobOperationCallable;
  private final UnaryCallable<UpdateImportJobRequest, Operation> updateImportJobCallable;
  private final OperationCallable<UpdateImportJobRequest, ImportJob, OperationMetadata>
      updateImportJobOperationCallable;
  private final UnaryCallable<ValidateImportJobRequest, Operation> validateImportJobCallable;
  private final OperationCallable<ValidateImportJobRequest, Empty, OperationMetadata>
      validateImportJobOperationCallable;
  private final UnaryCallable<RunImportJobRequest, Operation> runImportJobCallable;
  private final OperationCallable<RunImportJobRequest, Empty, OperationMetadata>
      runImportJobOperationCallable;
  private final UnaryCallable<GetImportDataFileRequest, ImportDataFile> getImportDataFileCallable;
  private final UnaryCallable<ListImportDataFilesRequest, ListImportDataFilesResponse>
      listImportDataFilesCallable;
  private final UnaryCallable<ListImportDataFilesRequest, ListImportDataFilesPagedResponse>
      listImportDataFilesPagedCallable;
  private final UnaryCallable<CreateImportDataFileRequest, Operation> createImportDataFileCallable;
  private final OperationCallable<CreateImportDataFileRequest, ImportDataFile, OperationMetadata>
      createImportDataFileOperationCallable;
  private final UnaryCallable<DeleteImportDataFileRequest, Operation> deleteImportDataFileCallable;
  private final OperationCallable<DeleteImportDataFileRequest, Empty, OperationMetadata>
      deleteImportDataFileOperationCallable;
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
  private final UnaryCallable<AddAssetsToGroupRequest, Operation> addAssetsToGroupCallable;
  private final OperationCallable<AddAssetsToGroupRequest, Group, OperationMetadata>
      addAssetsToGroupOperationCallable;
  private final UnaryCallable<RemoveAssetsFromGroupRequest, Operation>
      removeAssetsFromGroupCallable;
  private final OperationCallable<RemoveAssetsFromGroupRequest, Group, OperationMetadata>
      removeAssetsFromGroupOperationCallable;
  private final UnaryCallable<ListErrorFramesRequest, ListErrorFramesResponse>
      listErrorFramesCallable;
  private final UnaryCallable<ListErrorFramesRequest, ListErrorFramesPagedResponse>
      listErrorFramesPagedCallable;
  private final UnaryCallable<GetErrorFrameRequest, ErrorFrame> getErrorFrameCallable;
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
  private final UnaryCallable<ListPreferenceSetsRequest, ListPreferenceSetsResponse>
      listPreferenceSetsCallable;
  private final UnaryCallable<ListPreferenceSetsRequest, ListPreferenceSetsPagedResponse>
      listPreferenceSetsPagedCallable;
  private final UnaryCallable<GetPreferenceSetRequest, PreferenceSet> getPreferenceSetCallable;
  private final UnaryCallable<CreatePreferenceSetRequest, Operation> createPreferenceSetCallable;
  private final OperationCallable<CreatePreferenceSetRequest, PreferenceSet, OperationMetadata>
      createPreferenceSetOperationCallable;
  private final UnaryCallable<UpdatePreferenceSetRequest, Operation> updatePreferenceSetCallable;
  private final OperationCallable<UpdatePreferenceSetRequest, PreferenceSet, OperationMetadata>
      updatePreferenceSetOperationCallable;
  private final UnaryCallable<DeletePreferenceSetRequest, Operation> deletePreferenceSetCallable;
  private final OperationCallable<DeletePreferenceSetRequest, Empty, OperationMetadata>
      deletePreferenceSetOperationCallable;
  private final UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable;
  private final UnaryCallable<UpdateSettingsRequest, Operation> updateSettingsCallable;
  private final OperationCallable<UpdateSettingsRequest, Settings, OperationMetadata>
      updateSettingsOperationCallable;
  private final UnaryCallable<CreateReportConfigRequest, Operation> createReportConfigCallable;
  private final OperationCallable<CreateReportConfigRequest, ReportConfig, OperationMetadata>
      createReportConfigOperationCallable;
  private final UnaryCallable<GetReportConfigRequest, ReportConfig> getReportConfigCallable;
  private final UnaryCallable<ListReportConfigsRequest, ListReportConfigsResponse>
      listReportConfigsCallable;
  private final UnaryCallable<ListReportConfigsRequest, ListReportConfigsPagedResponse>
      listReportConfigsPagedCallable;
  private final UnaryCallable<DeleteReportConfigRequest, Operation> deleteReportConfigCallable;
  private final OperationCallable<DeleteReportConfigRequest, Empty, OperationMetadata>
      deleteReportConfigOperationCallable;
  private final UnaryCallable<CreateReportRequest, Operation> createReportCallable;
  private final OperationCallable<CreateReportRequest, Report, OperationMetadata>
      createReportOperationCallable;
  private final UnaryCallable<GetReportRequest, Report> getReportCallable;
  private final UnaryCallable<ListReportsRequest, ListReportsResponse> listReportsCallable;
  private final UnaryCallable<ListReportsRequest, ListReportsPagedResponse>
      listReportsPagedCallable;
  private final UnaryCallable<DeleteReportRequest, Operation> deleteReportCallable;
  private final OperationCallable<DeleteReportRequest, Empty, OperationMetadata>
      deleteReportOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonMigrationCenterStub create(MigrationCenterStubSettings settings)
      throws IOException {
    return new HttpJsonMigrationCenterStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonMigrationCenterStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonMigrationCenterStub(
        MigrationCenterStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonMigrationCenterStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonMigrationCenterStub(
        MigrationCenterStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonMigrationCenterStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonMigrationCenterStub(
      MigrationCenterStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonMigrationCenterCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonMigrationCenterStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonMigrationCenterStub(
      MigrationCenterStubSettings settings,
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

    HttpJsonCallSettings<ListAssetsRequest, ListAssetsResponse> listAssetsTransportSettings =
        HttpJsonCallSettings.<ListAssetsRequest, ListAssetsResponse>newBuilder()
            .setMethodDescriptor(listAssetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetAssetRequest, Asset> getAssetTransportSettings =
        HttpJsonCallSettings.<GetAssetRequest, Asset>newBuilder()
            .setMethodDescriptor(getAssetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateAssetRequest, Asset> updateAssetTransportSettings =
        HttpJsonCallSettings.<UpdateAssetRequest, Asset>newBuilder()
            .setMethodDescriptor(updateAssetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("asset.name", String.valueOf(request.getAsset().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchUpdateAssetsRequest, BatchUpdateAssetsResponse>
        batchUpdateAssetsTransportSettings =
            HttpJsonCallSettings.<BatchUpdateAssetsRequest, BatchUpdateAssetsResponse>newBuilder()
                .setMethodDescriptor(batchUpdateAssetsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteAssetRequest, Empty> deleteAssetTransportSettings =
        HttpJsonCallSettings.<DeleteAssetRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAssetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchDeleteAssetsRequest, Empty> batchDeleteAssetsTransportSettings =
        HttpJsonCallSettings.<BatchDeleteAssetsRequest, Empty>newBuilder()
            .setMethodDescriptor(batchDeleteAssetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ReportAssetFramesRequest, ReportAssetFramesResponse>
        reportAssetFramesTransportSettings =
            HttpJsonCallSettings.<ReportAssetFramesRequest, ReportAssetFramesResponse>newBuilder()
                .setMethodDescriptor(reportAssetFramesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<AggregateAssetsValuesRequest, AggregateAssetsValuesResponse>
        aggregateAssetsValuesTransportSettings =
            HttpJsonCallSettings
                .<AggregateAssetsValuesRequest, AggregateAssetsValuesResponse>newBuilder()
                .setMethodDescriptor(aggregateAssetsValuesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateImportJobRequest, Operation> createImportJobTransportSettings =
        HttpJsonCallSettings.<CreateImportJobRequest, Operation>newBuilder()
            .setMethodDescriptor(createImportJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListImportJobsRequest, ListImportJobsResponse>
        listImportJobsTransportSettings =
            HttpJsonCallSettings.<ListImportJobsRequest, ListImportJobsResponse>newBuilder()
                .setMethodDescriptor(listImportJobsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetImportJobRequest, ImportJob> getImportJobTransportSettings =
        HttpJsonCallSettings.<GetImportJobRequest, ImportJob>newBuilder()
            .setMethodDescriptor(getImportJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteImportJobRequest, Operation> deleteImportJobTransportSettings =
        HttpJsonCallSettings.<DeleteImportJobRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteImportJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateImportJobRequest, Operation> updateImportJobTransportSettings =
        HttpJsonCallSettings.<UpdateImportJobRequest, Operation>newBuilder()
            .setMethodDescriptor(updateImportJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("import_job.name", String.valueOf(request.getImportJob().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ValidateImportJobRequest, Operation> validateImportJobTransportSettings =
        HttpJsonCallSettings.<ValidateImportJobRequest, Operation>newBuilder()
            .setMethodDescriptor(validateImportJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RunImportJobRequest, Operation> runImportJobTransportSettings =
        HttpJsonCallSettings.<RunImportJobRequest, Operation>newBuilder()
            .setMethodDescriptor(runImportJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetImportDataFileRequest, ImportDataFile>
        getImportDataFileTransportSettings =
            HttpJsonCallSettings.<GetImportDataFileRequest, ImportDataFile>newBuilder()
                .setMethodDescriptor(getImportDataFileMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListImportDataFilesRequest, ListImportDataFilesResponse>
        listImportDataFilesTransportSettings =
            HttpJsonCallSettings
                .<ListImportDataFilesRequest, ListImportDataFilesResponse>newBuilder()
                .setMethodDescriptor(listImportDataFilesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateImportDataFileRequest, Operation>
        createImportDataFileTransportSettings =
            HttpJsonCallSettings.<CreateImportDataFileRequest, Operation>newBuilder()
                .setMethodDescriptor(createImportDataFileMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteImportDataFileRequest, Operation>
        deleteImportDataFileTransportSettings =
            HttpJsonCallSettings.<DeleteImportDataFileRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteImportDataFileMethodDescriptor)
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
    HttpJsonCallSettings<AddAssetsToGroupRequest, Operation> addAssetsToGroupTransportSettings =
        HttpJsonCallSettings.<AddAssetsToGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(addAssetsToGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("group", String.valueOf(request.getGroup()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RemoveAssetsFromGroupRequest, Operation>
        removeAssetsFromGroupTransportSettings =
            HttpJsonCallSettings.<RemoveAssetsFromGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(removeAssetsFromGroupMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("group", String.valueOf(request.getGroup()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListErrorFramesRequest, ListErrorFramesResponse>
        listErrorFramesTransportSettings =
            HttpJsonCallSettings.<ListErrorFramesRequest, ListErrorFramesResponse>newBuilder()
                .setMethodDescriptor(listErrorFramesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetErrorFrameRequest, ErrorFrame> getErrorFrameTransportSettings =
        HttpJsonCallSettings.<GetErrorFrameRequest, ErrorFrame>newBuilder()
            .setMethodDescriptor(getErrorFrameMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
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
    HttpJsonCallSettings<ListPreferenceSetsRequest, ListPreferenceSetsResponse>
        listPreferenceSetsTransportSettings =
            HttpJsonCallSettings.<ListPreferenceSetsRequest, ListPreferenceSetsResponse>newBuilder()
                .setMethodDescriptor(listPreferenceSetsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetPreferenceSetRequest, PreferenceSet> getPreferenceSetTransportSettings =
        HttpJsonCallSettings.<GetPreferenceSetRequest, PreferenceSet>newBuilder()
            .setMethodDescriptor(getPreferenceSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreatePreferenceSetRequest, Operation>
        createPreferenceSetTransportSettings =
            HttpJsonCallSettings.<CreatePreferenceSetRequest, Operation>newBuilder()
                .setMethodDescriptor(createPreferenceSetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdatePreferenceSetRequest, Operation>
        updatePreferenceSetTransportSettings =
            HttpJsonCallSettings.<UpdatePreferenceSetRequest, Operation>newBuilder()
                .setMethodDescriptor(updatePreferenceSetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "preference_set.name",
                          String.valueOf(request.getPreferenceSet().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeletePreferenceSetRequest, Operation>
        deletePreferenceSetTransportSettings =
            HttpJsonCallSettings.<DeletePreferenceSetRequest, Operation>newBuilder()
                .setMethodDescriptor(deletePreferenceSetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetSettingsRequest, Settings> getSettingsTransportSettings =
        HttpJsonCallSettings.<GetSettingsRequest, Settings>newBuilder()
            .setMethodDescriptor(getSettingsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateSettingsRequest, Operation> updateSettingsTransportSettings =
        HttpJsonCallSettings.<UpdateSettingsRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSettingsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("settings.name", String.valueOf(request.getSettings().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateReportConfigRequest, Operation> createReportConfigTransportSettings =
        HttpJsonCallSettings.<CreateReportConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(createReportConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetReportConfigRequest, ReportConfig> getReportConfigTransportSettings =
        HttpJsonCallSettings.<GetReportConfigRequest, ReportConfig>newBuilder()
            .setMethodDescriptor(getReportConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListReportConfigsRequest, ListReportConfigsResponse>
        listReportConfigsTransportSettings =
            HttpJsonCallSettings.<ListReportConfigsRequest, ListReportConfigsResponse>newBuilder()
                .setMethodDescriptor(listReportConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteReportConfigRequest, Operation> deleteReportConfigTransportSettings =
        HttpJsonCallSettings.<DeleteReportConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteReportConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateReportRequest, Operation> createReportTransportSettings =
        HttpJsonCallSettings.<CreateReportRequest, Operation>newBuilder()
            .setMethodDescriptor(createReportMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetReportRequest, Report> getReportTransportSettings =
        HttpJsonCallSettings.<GetReportRequest, Report>newBuilder()
            .setMethodDescriptor(getReportMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListReportsRequest, ListReportsResponse> listReportsTransportSettings =
        HttpJsonCallSettings.<ListReportsRequest, ListReportsResponse>newBuilder()
            .setMethodDescriptor(listReportsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteReportRequest, Operation> deleteReportTransportSettings =
        HttpJsonCallSettings.<DeleteReportRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteReportMethodDescriptor)
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

    this.listAssetsCallable =
        callableFactory.createUnaryCallable(
            listAssetsTransportSettings, settings.listAssetsSettings(), clientContext);
    this.listAssetsPagedCallable =
        callableFactory.createPagedCallable(
            listAssetsTransportSettings, settings.listAssetsSettings(), clientContext);
    this.getAssetCallable =
        callableFactory.createUnaryCallable(
            getAssetTransportSettings, settings.getAssetSettings(), clientContext);
    this.updateAssetCallable =
        callableFactory.createUnaryCallable(
            updateAssetTransportSettings, settings.updateAssetSettings(), clientContext);
    this.batchUpdateAssetsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateAssetsTransportSettings,
            settings.batchUpdateAssetsSettings(),
            clientContext);
    this.deleteAssetCallable =
        callableFactory.createUnaryCallable(
            deleteAssetTransportSettings, settings.deleteAssetSettings(), clientContext);
    this.batchDeleteAssetsCallable =
        callableFactory.createUnaryCallable(
            batchDeleteAssetsTransportSettings,
            settings.batchDeleteAssetsSettings(),
            clientContext);
    this.reportAssetFramesCallable =
        callableFactory.createUnaryCallable(
            reportAssetFramesTransportSettings,
            settings.reportAssetFramesSettings(),
            clientContext);
    this.aggregateAssetsValuesCallable =
        callableFactory.createUnaryCallable(
            aggregateAssetsValuesTransportSettings,
            settings.aggregateAssetsValuesSettings(),
            clientContext);
    this.createImportJobCallable =
        callableFactory.createUnaryCallable(
            createImportJobTransportSettings, settings.createImportJobSettings(), clientContext);
    this.createImportJobOperationCallable =
        callableFactory.createOperationCallable(
            createImportJobTransportSettings,
            settings.createImportJobOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listImportJobsCallable =
        callableFactory.createUnaryCallable(
            listImportJobsTransportSettings, settings.listImportJobsSettings(), clientContext);
    this.listImportJobsPagedCallable =
        callableFactory.createPagedCallable(
            listImportJobsTransportSettings, settings.listImportJobsSettings(), clientContext);
    this.getImportJobCallable =
        callableFactory.createUnaryCallable(
            getImportJobTransportSettings, settings.getImportJobSettings(), clientContext);
    this.deleteImportJobCallable =
        callableFactory.createUnaryCallable(
            deleteImportJobTransportSettings, settings.deleteImportJobSettings(), clientContext);
    this.deleteImportJobOperationCallable =
        callableFactory.createOperationCallable(
            deleteImportJobTransportSettings,
            settings.deleteImportJobOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateImportJobCallable =
        callableFactory.createUnaryCallable(
            updateImportJobTransportSettings, settings.updateImportJobSettings(), clientContext);
    this.updateImportJobOperationCallable =
        callableFactory.createOperationCallable(
            updateImportJobTransportSettings,
            settings.updateImportJobOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.validateImportJobCallable =
        callableFactory.createUnaryCallable(
            validateImportJobTransportSettings,
            settings.validateImportJobSettings(),
            clientContext);
    this.validateImportJobOperationCallable =
        callableFactory.createOperationCallable(
            validateImportJobTransportSettings,
            settings.validateImportJobOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.runImportJobCallable =
        callableFactory.createUnaryCallable(
            runImportJobTransportSettings, settings.runImportJobSettings(), clientContext);
    this.runImportJobOperationCallable =
        callableFactory.createOperationCallable(
            runImportJobTransportSettings,
            settings.runImportJobOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getImportDataFileCallable =
        callableFactory.createUnaryCallable(
            getImportDataFileTransportSettings,
            settings.getImportDataFileSettings(),
            clientContext);
    this.listImportDataFilesCallable =
        callableFactory.createUnaryCallable(
            listImportDataFilesTransportSettings,
            settings.listImportDataFilesSettings(),
            clientContext);
    this.listImportDataFilesPagedCallable =
        callableFactory.createPagedCallable(
            listImportDataFilesTransportSettings,
            settings.listImportDataFilesSettings(),
            clientContext);
    this.createImportDataFileCallable =
        callableFactory.createUnaryCallable(
            createImportDataFileTransportSettings,
            settings.createImportDataFileSettings(),
            clientContext);
    this.createImportDataFileOperationCallable =
        callableFactory.createOperationCallable(
            createImportDataFileTransportSettings,
            settings.createImportDataFileOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteImportDataFileCallable =
        callableFactory.createUnaryCallable(
            deleteImportDataFileTransportSettings,
            settings.deleteImportDataFileSettings(),
            clientContext);
    this.deleteImportDataFileOperationCallable =
        callableFactory.createOperationCallable(
            deleteImportDataFileTransportSettings,
            settings.deleteImportDataFileOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
    this.addAssetsToGroupCallable =
        callableFactory.createUnaryCallable(
            addAssetsToGroupTransportSettings, settings.addAssetsToGroupSettings(), clientContext);
    this.addAssetsToGroupOperationCallable =
        callableFactory.createOperationCallable(
            addAssetsToGroupTransportSettings,
            settings.addAssetsToGroupOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.removeAssetsFromGroupCallable =
        callableFactory.createUnaryCallable(
            removeAssetsFromGroupTransportSettings,
            settings.removeAssetsFromGroupSettings(),
            clientContext);
    this.removeAssetsFromGroupOperationCallable =
        callableFactory.createOperationCallable(
            removeAssetsFromGroupTransportSettings,
            settings.removeAssetsFromGroupOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listErrorFramesCallable =
        callableFactory.createUnaryCallable(
            listErrorFramesTransportSettings, settings.listErrorFramesSettings(), clientContext);
    this.listErrorFramesPagedCallable =
        callableFactory.createPagedCallable(
            listErrorFramesTransportSettings, settings.listErrorFramesSettings(), clientContext);
    this.getErrorFrameCallable =
        callableFactory.createUnaryCallable(
            getErrorFrameTransportSettings, settings.getErrorFrameSettings(), clientContext);
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
    this.listPreferenceSetsCallable =
        callableFactory.createUnaryCallable(
            listPreferenceSetsTransportSettings,
            settings.listPreferenceSetsSettings(),
            clientContext);
    this.listPreferenceSetsPagedCallable =
        callableFactory.createPagedCallable(
            listPreferenceSetsTransportSettings,
            settings.listPreferenceSetsSettings(),
            clientContext);
    this.getPreferenceSetCallable =
        callableFactory.createUnaryCallable(
            getPreferenceSetTransportSettings, settings.getPreferenceSetSettings(), clientContext);
    this.createPreferenceSetCallable =
        callableFactory.createUnaryCallable(
            createPreferenceSetTransportSettings,
            settings.createPreferenceSetSettings(),
            clientContext);
    this.createPreferenceSetOperationCallable =
        callableFactory.createOperationCallable(
            createPreferenceSetTransportSettings,
            settings.createPreferenceSetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updatePreferenceSetCallable =
        callableFactory.createUnaryCallable(
            updatePreferenceSetTransportSettings,
            settings.updatePreferenceSetSettings(),
            clientContext);
    this.updatePreferenceSetOperationCallable =
        callableFactory.createOperationCallable(
            updatePreferenceSetTransportSettings,
            settings.updatePreferenceSetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deletePreferenceSetCallable =
        callableFactory.createUnaryCallable(
            deletePreferenceSetTransportSettings,
            settings.deletePreferenceSetSettings(),
            clientContext);
    this.deletePreferenceSetOperationCallable =
        callableFactory.createOperationCallable(
            deletePreferenceSetTransportSettings,
            settings.deletePreferenceSetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getSettingsCallable =
        callableFactory.createUnaryCallable(
            getSettingsTransportSettings, settings.getSettingsSettings(), clientContext);
    this.updateSettingsCallable =
        callableFactory.createUnaryCallable(
            updateSettingsTransportSettings, settings.updateSettingsSettings(), clientContext);
    this.updateSettingsOperationCallable =
        callableFactory.createOperationCallable(
            updateSettingsTransportSettings,
            settings.updateSettingsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createReportConfigCallable =
        callableFactory.createUnaryCallable(
            createReportConfigTransportSettings,
            settings.createReportConfigSettings(),
            clientContext);
    this.createReportConfigOperationCallable =
        callableFactory.createOperationCallable(
            createReportConfigTransportSettings,
            settings.createReportConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getReportConfigCallable =
        callableFactory.createUnaryCallable(
            getReportConfigTransportSettings, settings.getReportConfigSettings(), clientContext);
    this.listReportConfigsCallable =
        callableFactory.createUnaryCallable(
            listReportConfigsTransportSettings,
            settings.listReportConfigsSettings(),
            clientContext);
    this.listReportConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listReportConfigsTransportSettings,
            settings.listReportConfigsSettings(),
            clientContext);
    this.deleteReportConfigCallable =
        callableFactory.createUnaryCallable(
            deleteReportConfigTransportSettings,
            settings.deleteReportConfigSettings(),
            clientContext);
    this.deleteReportConfigOperationCallable =
        callableFactory.createOperationCallable(
            deleteReportConfigTransportSettings,
            settings.deleteReportConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createReportCallable =
        callableFactory.createUnaryCallable(
            createReportTransportSettings, settings.createReportSettings(), clientContext);
    this.createReportOperationCallable =
        callableFactory.createOperationCallable(
            createReportTransportSettings,
            settings.createReportOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getReportCallable =
        callableFactory.createUnaryCallable(
            getReportTransportSettings, settings.getReportSettings(), clientContext);
    this.listReportsCallable =
        callableFactory.createUnaryCallable(
            listReportsTransportSettings, settings.listReportsSettings(), clientContext);
    this.listReportsPagedCallable =
        callableFactory.createPagedCallable(
            listReportsTransportSettings, settings.listReportsSettings(), clientContext);
    this.deleteReportCallable =
        callableFactory.createUnaryCallable(
            deleteReportTransportSettings, settings.deleteReportSettings(), clientContext);
    this.deleteReportOperationCallable =
        callableFactory.createOperationCallable(
            deleteReportTransportSettings,
            settings.deleteReportOperationSettings(),
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
    methodDescriptors.add(listAssetsMethodDescriptor);
    methodDescriptors.add(getAssetMethodDescriptor);
    methodDescriptors.add(updateAssetMethodDescriptor);
    methodDescriptors.add(batchUpdateAssetsMethodDescriptor);
    methodDescriptors.add(deleteAssetMethodDescriptor);
    methodDescriptors.add(batchDeleteAssetsMethodDescriptor);
    methodDescriptors.add(reportAssetFramesMethodDescriptor);
    methodDescriptors.add(aggregateAssetsValuesMethodDescriptor);
    methodDescriptors.add(createImportJobMethodDescriptor);
    methodDescriptors.add(listImportJobsMethodDescriptor);
    methodDescriptors.add(getImportJobMethodDescriptor);
    methodDescriptors.add(deleteImportJobMethodDescriptor);
    methodDescriptors.add(updateImportJobMethodDescriptor);
    methodDescriptors.add(validateImportJobMethodDescriptor);
    methodDescriptors.add(runImportJobMethodDescriptor);
    methodDescriptors.add(getImportDataFileMethodDescriptor);
    methodDescriptors.add(listImportDataFilesMethodDescriptor);
    methodDescriptors.add(createImportDataFileMethodDescriptor);
    methodDescriptors.add(deleteImportDataFileMethodDescriptor);
    methodDescriptors.add(listGroupsMethodDescriptor);
    methodDescriptors.add(getGroupMethodDescriptor);
    methodDescriptors.add(createGroupMethodDescriptor);
    methodDescriptors.add(updateGroupMethodDescriptor);
    methodDescriptors.add(deleteGroupMethodDescriptor);
    methodDescriptors.add(addAssetsToGroupMethodDescriptor);
    methodDescriptors.add(removeAssetsFromGroupMethodDescriptor);
    methodDescriptors.add(listErrorFramesMethodDescriptor);
    methodDescriptors.add(getErrorFrameMethodDescriptor);
    methodDescriptors.add(listSourcesMethodDescriptor);
    methodDescriptors.add(getSourceMethodDescriptor);
    methodDescriptors.add(createSourceMethodDescriptor);
    methodDescriptors.add(updateSourceMethodDescriptor);
    methodDescriptors.add(deleteSourceMethodDescriptor);
    methodDescriptors.add(listPreferenceSetsMethodDescriptor);
    methodDescriptors.add(getPreferenceSetMethodDescriptor);
    methodDescriptors.add(createPreferenceSetMethodDescriptor);
    methodDescriptors.add(updatePreferenceSetMethodDescriptor);
    methodDescriptors.add(deletePreferenceSetMethodDescriptor);
    methodDescriptors.add(getSettingsMethodDescriptor);
    methodDescriptors.add(updateSettingsMethodDescriptor);
    methodDescriptors.add(createReportConfigMethodDescriptor);
    methodDescriptors.add(getReportConfigMethodDescriptor);
    methodDescriptors.add(listReportConfigsMethodDescriptor);
    methodDescriptors.add(deleteReportConfigMethodDescriptor);
    methodDescriptors.add(createReportMethodDescriptor);
    methodDescriptors.add(getReportMethodDescriptor);
    methodDescriptors.add(listReportsMethodDescriptor);
    methodDescriptors.add(deleteReportMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListAssetsRequest, ListAssetsResponse> listAssetsCallable() {
    return listAssetsCallable;
  }

  @Override
  public UnaryCallable<ListAssetsRequest, ListAssetsPagedResponse> listAssetsPagedCallable() {
    return listAssetsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAssetRequest, Asset> getAssetCallable() {
    return getAssetCallable;
  }

  @Override
  public UnaryCallable<UpdateAssetRequest, Asset> updateAssetCallable() {
    return updateAssetCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateAssetsRequest, BatchUpdateAssetsResponse>
      batchUpdateAssetsCallable() {
    return batchUpdateAssetsCallable;
  }

  @Override
  public UnaryCallable<DeleteAssetRequest, Empty> deleteAssetCallable() {
    return deleteAssetCallable;
  }

  @Override
  public UnaryCallable<BatchDeleteAssetsRequest, Empty> batchDeleteAssetsCallable() {
    return batchDeleteAssetsCallable;
  }

  @Override
  public UnaryCallable<ReportAssetFramesRequest, ReportAssetFramesResponse>
      reportAssetFramesCallable() {
    return reportAssetFramesCallable;
  }

  @Override
  public UnaryCallable<AggregateAssetsValuesRequest, AggregateAssetsValuesResponse>
      aggregateAssetsValuesCallable() {
    return aggregateAssetsValuesCallable;
  }

  @Override
  public UnaryCallable<CreateImportJobRequest, Operation> createImportJobCallable() {
    return createImportJobCallable;
  }

  @Override
  public OperationCallable<CreateImportJobRequest, ImportJob, OperationMetadata>
      createImportJobOperationCallable() {
    return createImportJobOperationCallable;
  }

  @Override
  public UnaryCallable<ListImportJobsRequest, ListImportJobsResponse> listImportJobsCallable() {
    return listImportJobsCallable;
  }

  @Override
  public UnaryCallable<ListImportJobsRequest, ListImportJobsPagedResponse>
      listImportJobsPagedCallable() {
    return listImportJobsPagedCallable;
  }

  @Override
  public UnaryCallable<GetImportJobRequest, ImportJob> getImportJobCallable() {
    return getImportJobCallable;
  }

  @Override
  public UnaryCallable<DeleteImportJobRequest, Operation> deleteImportJobCallable() {
    return deleteImportJobCallable;
  }

  @Override
  public OperationCallable<DeleteImportJobRequest, Empty, OperationMetadata>
      deleteImportJobOperationCallable() {
    return deleteImportJobOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateImportJobRequest, Operation> updateImportJobCallable() {
    return updateImportJobCallable;
  }

  @Override
  public OperationCallable<UpdateImportJobRequest, ImportJob, OperationMetadata>
      updateImportJobOperationCallable() {
    return updateImportJobOperationCallable;
  }

  @Override
  public UnaryCallable<ValidateImportJobRequest, Operation> validateImportJobCallable() {
    return validateImportJobCallable;
  }

  @Override
  public OperationCallable<ValidateImportJobRequest, Empty, OperationMetadata>
      validateImportJobOperationCallable() {
    return validateImportJobOperationCallable;
  }

  @Override
  public UnaryCallable<RunImportJobRequest, Operation> runImportJobCallable() {
    return runImportJobCallable;
  }

  @Override
  public OperationCallable<RunImportJobRequest, Empty, OperationMetadata>
      runImportJobOperationCallable() {
    return runImportJobOperationCallable;
  }

  @Override
  public UnaryCallable<GetImportDataFileRequest, ImportDataFile> getImportDataFileCallable() {
    return getImportDataFileCallable;
  }

  @Override
  public UnaryCallable<ListImportDataFilesRequest, ListImportDataFilesResponse>
      listImportDataFilesCallable() {
    return listImportDataFilesCallable;
  }

  @Override
  public UnaryCallable<ListImportDataFilesRequest, ListImportDataFilesPagedResponse>
      listImportDataFilesPagedCallable() {
    return listImportDataFilesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateImportDataFileRequest, Operation> createImportDataFileCallable() {
    return createImportDataFileCallable;
  }

  @Override
  public OperationCallable<CreateImportDataFileRequest, ImportDataFile, OperationMetadata>
      createImportDataFileOperationCallable() {
    return createImportDataFileOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteImportDataFileRequest, Operation> deleteImportDataFileCallable() {
    return deleteImportDataFileCallable;
  }

  @Override
  public OperationCallable<DeleteImportDataFileRequest, Empty, OperationMetadata>
      deleteImportDataFileOperationCallable() {
    return deleteImportDataFileOperationCallable;
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
  public UnaryCallable<AddAssetsToGroupRequest, Operation> addAssetsToGroupCallable() {
    return addAssetsToGroupCallable;
  }

  @Override
  public OperationCallable<AddAssetsToGroupRequest, Group, OperationMetadata>
      addAssetsToGroupOperationCallable() {
    return addAssetsToGroupOperationCallable;
  }

  @Override
  public UnaryCallable<RemoveAssetsFromGroupRequest, Operation> removeAssetsFromGroupCallable() {
    return removeAssetsFromGroupCallable;
  }

  @Override
  public OperationCallable<RemoveAssetsFromGroupRequest, Group, OperationMetadata>
      removeAssetsFromGroupOperationCallable() {
    return removeAssetsFromGroupOperationCallable;
  }

  @Override
  public UnaryCallable<ListErrorFramesRequest, ListErrorFramesResponse> listErrorFramesCallable() {
    return listErrorFramesCallable;
  }

  @Override
  public UnaryCallable<ListErrorFramesRequest, ListErrorFramesPagedResponse>
      listErrorFramesPagedCallable() {
    return listErrorFramesPagedCallable;
  }

  @Override
  public UnaryCallable<GetErrorFrameRequest, ErrorFrame> getErrorFrameCallable() {
    return getErrorFrameCallable;
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
  public UnaryCallable<ListPreferenceSetsRequest, ListPreferenceSetsResponse>
      listPreferenceSetsCallable() {
    return listPreferenceSetsCallable;
  }

  @Override
  public UnaryCallable<ListPreferenceSetsRequest, ListPreferenceSetsPagedResponse>
      listPreferenceSetsPagedCallable() {
    return listPreferenceSetsPagedCallable;
  }

  @Override
  public UnaryCallable<GetPreferenceSetRequest, PreferenceSet> getPreferenceSetCallable() {
    return getPreferenceSetCallable;
  }

  @Override
  public UnaryCallable<CreatePreferenceSetRequest, Operation> createPreferenceSetCallable() {
    return createPreferenceSetCallable;
  }

  @Override
  public OperationCallable<CreatePreferenceSetRequest, PreferenceSet, OperationMetadata>
      createPreferenceSetOperationCallable() {
    return createPreferenceSetOperationCallable;
  }

  @Override
  public UnaryCallable<UpdatePreferenceSetRequest, Operation> updatePreferenceSetCallable() {
    return updatePreferenceSetCallable;
  }

  @Override
  public OperationCallable<UpdatePreferenceSetRequest, PreferenceSet, OperationMetadata>
      updatePreferenceSetOperationCallable() {
    return updatePreferenceSetOperationCallable;
  }

  @Override
  public UnaryCallable<DeletePreferenceSetRequest, Operation> deletePreferenceSetCallable() {
    return deletePreferenceSetCallable;
  }

  @Override
  public OperationCallable<DeletePreferenceSetRequest, Empty, OperationMetadata>
      deletePreferenceSetOperationCallable() {
    return deletePreferenceSetOperationCallable;
  }

  @Override
  public UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable() {
    return getSettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateSettingsRequest, Operation> updateSettingsCallable() {
    return updateSettingsCallable;
  }

  @Override
  public OperationCallable<UpdateSettingsRequest, Settings, OperationMetadata>
      updateSettingsOperationCallable() {
    return updateSettingsOperationCallable;
  }

  @Override
  public UnaryCallable<CreateReportConfigRequest, Operation> createReportConfigCallable() {
    return createReportConfigCallable;
  }

  @Override
  public OperationCallable<CreateReportConfigRequest, ReportConfig, OperationMetadata>
      createReportConfigOperationCallable() {
    return createReportConfigOperationCallable;
  }

  @Override
  public UnaryCallable<GetReportConfigRequest, ReportConfig> getReportConfigCallable() {
    return getReportConfigCallable;
  }

  @Override
  public UnaryCallable<ListReportConfigsRequest, ListReportConfigsResponse>
      listReportConfigsCallable() {
    return listReportConfigsCallable;
  }

  @Override
  public UnaryCallable<ListReportConfigsRequest, ListReportConfigsPagedResponse>
      listReportConfigsPagedCallable() {
    return listReportConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteReportConfigRequest, Operation> deleteReportConfigCallable() {
    return deleteReportConfigCallable;
  }

  @Override
  public OperationCallable<DeleteReportConfigRequest, Empty, OperationMetadata>
      deleteReportConfigOperationCallable() {
    return deleteReportConfigOperationCallable;
  }

  @Override
  public UnaryCallable<CreateReportRequest, Operation> createReportCallable() {
    return createReportCallable;
  }

  @Override
  public OperationCallable<CreateReportRequest, Report, OperationMetadata>
      createReportOperationCallable() {
    return createReportOperationCallable;
  }

  @Override
  public UnaryCallable<GetReportRequest, Report> getReportCallable() {
    return getReportCallable;
  }

  @Override
  public UnaryCallable<ListReportsRequest, ListReportsResponse> listReportsCallable() {
    return listReportsCallable;
  }

  @Override
  public UnaryCallable<ListReportsRequest, ListReportsPagedResponse> listReportsPagedCallable() {
    return listReportsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteReportRequest, Operation> deleteReportCallable() {
    return deleteReportCallable;
  }

  @Override
  public OperationCallable<DeleteReportRequest, Empty, OperationMetadata>
      deleteReportOperationCallable() {
    return deleteReportOperationCallable;
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
