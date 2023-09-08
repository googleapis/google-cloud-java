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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
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
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the MigrationCenter service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcMigrationCenterStub extends MigrationCenterStub {
  private static final MethodDescriptor<ListAssetsRequest, ListAssetsResponse>
      listAssetsMethodDescriptor =
          MethodDescriptor.<ListAssetsRequest, ListAssetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/ListAssets")
              .setRequestMarshaller(ProtoUtils.marshaller(ListAssetsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListAssetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAssetRequest, Asset> getAssetMethodDescriptor =
      MethodDescriptor.<GetAssetRequest, Asset>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/GetAsset")
          .setRequestMarshaller(ProtoUtils.marshaller(GetAssetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Asset.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateAssetRequest, Asset> updateAssetMethodDescriptor =
      MethodDescriptor.<UpdateAssetRequest, Asset>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/UpdateAsset")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateAssetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Asset.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<BatchUpdateAssetsRequest, BatchUpdateAssetsResponse>
      batchUpdateAssetsMethodDescriptor =
          MethodDescriptor.<BatchUpdateAssetsRequest, BatchUpdateAssetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/BatchUpdateAssets")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchUpdateAssetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchUpdateAssetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAssetRequest, Empty> deleteAssetMethodDescriptor =
      MethodDescriptor.<DeleteAssetRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/DeleteAsset")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteAssetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<BatchDeleteAssetsRequest, Empty>
      batchDeleteAssetsMethodDescriptor =
          MethodDescriptor.<BatchDeleteAssetsRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/BatchDeleteAssets")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchDeleteAssetsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ReportAssetFramesRequest, ReportAssetFramesResponse>
      reportAssetFramesMethodDescriptor =
          MethodDescriptor.<ReportAssetFramesRequest, ReportAssetFramesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/ReportAssetFrames")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReportAssetFramesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ReportAssetFramesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AggregateAssetsValuesRequest, AggregateAssetsValuesResponse>
      aggregateAssetsValuesMethodDescriptor =
          MethodDescriptor.<AggregateAssetsValuesRequest, AggregateAssetsValuesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/AggregateAssetsValues")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AggregateAssetsValuesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AggregateAssetsValuesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateImportJobRequest, Operation>
      createImportJobMethodDescriptor =
          MethodDescriptor.<CreateImportJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/CreateImportJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateImportJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListImportJobsRequest, ListImportJobsResponse>
      listImportJobsMethodDescriptor =
          MethodDescriptor.<ListImportJobsRequest, ListImportJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/ListImportJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListImportJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListImportJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetImportJobRequest, ImportJob>
      getImportJobMethodDescriptor =
          MethodDescriptor.<GetImportJobRequest, ImportJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/GetImportJob")
              .setRequestMarshaller(ProtoUtils.marshaller(GetImportJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ImportJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteImportJobRequest, Operation>
      deleteImportJobMethodDescriptor =
          MethodDescriptor.<DeleteImportJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/DeleteImportJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteImportJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateImportJobRequest, Operation>
      updateImportJobMethodDescriptor =
          MethodDescriptor.<UpdateImportJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/UpdateImportJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateImportJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ValidateImportJobRequest, Operation>
      validateImportJobMethodDescriptor =
          MethodDescriptor.<ValidateImportJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/ValidateImportJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ValidateImportJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RunImportJobRequest, Operation>
      runImportJobMethodDescriptor =
          MethodDescriptor.<RunImportJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/RunImportJob")
              .setRequestMarshaller(ProtoUtils.marshaller(RunImportJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetImportDataFileRequest, ImportDataFile>
      getImportDataFileMethodDescriptor =
          MethodDescriptor.<GetImportDataFileRequest, ImportDataFile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/GetImportDataFile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetImportDataFileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ImportDataFile.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListImportDataFilesRequest, ListImportDataFilesResponse>
      listImportDataFilesMethodDescriptor =
          MethodDescriptor.<ListImportDataFilesRequest, ListImportDataFilesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/ListImportDataFiles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListImportDataFilesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListImportDataFilesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateImportDataFileRequest, Operation>
      createImportDataFileMethodDescriptor =
          MethodDescriptor.<CreateImportDataFileRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/CreateImportDataFile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateImportDataFileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteImportDataFileRequest, Operation>
      deleteImportDataFileMethodDescriptor =
          MethodDescriptor.<DeleteImportDataFileRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/DeleteImportDataFile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteImportDataFileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListGroupsRequest, ListGroupsResponse>
      listGroupsMethodDescriptor =
          MethodDescriptor.<ListGroupsRequest, ListGroupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/ListGroups")
              .setRequestMarshaller(ProtoUtils.marshaller(ListGroupsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListGroupsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetGroupRequest, Group> getGroupMethodDescriptor =
      MethodDescriptor.<GetGroupRequest, Group>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/GetGroup")
          .setRequestMarshaller(ProtoUtils.marshaller(GetGroupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Group.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateGroupRequest, Operation> createGroupMethodDescriptor =
      MethodDescriptor.<CreateGroupRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/CreateGroup")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateGroupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateGroupRequest, Operation> updateGroupMethodDescriptor =
      MethodDescriptor.<UpdateGroupRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/UpdateGroup")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateGroupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteGroupRequest, Operation> deleteGroupMethodDescriptor =
      MethodDescriptor.<DeleteGroupRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/DeleteGroup")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteGroupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<AddAssetsToGroupRequest, Operation>
      addAssetsToGroupMethodDescriptor =
          MethodDescriptor.<AddAssetsToGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/AddAssetsToGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AddAssetsToGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RemoveAssetsFromGroupRequest, Operation>
      removeAssetsFromGroupMethodDescriptor =
          MethodDescriptor.<RemoveAssetsFromGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/RemoveAssetsFromGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RemoveAssetsFromGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListErrorFramesRequest, ListErrorFramesResponse>
      listErrorFramesMethodDescriptor =
          MethodDescriptor.<ListErrorFramesRequest, ListErrorFramesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/ListErrorFrames")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListErrorFramesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListErrorFramesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetErrorFrameRequest, ErrorFrame>
      getErrorFrameMethodDescriptor =
          MethodDescriptor.<GetErrorFrameRequest, ErrorFrame>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/GetErrorFrame")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetErrorFrameRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ErrorFrame.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSourcesRequest, ListSourcesResponse>
      listSourcesMethodDescriptor =
          MethodDescriptor.<ListSourcesRequest, ListSourcesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/ListSources")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSourcesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSourceRequest, Source> getSourceMethodDescriptor =
      MethodDescriptor.<GetSourceRequest, Source>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/GetSource")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSourceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Source.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateSourceRequest, Operation>
      createSourceMethodDescriptor =
          MethodDescriptor.<CreateSourceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/CreateSource")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSourceRequest, Operation>
      updateSourceMethodDescriptor =
          MethodDescriptor.<UpdateSourceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/UpdateSource")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSourceRequest, Operation>
      deleteSourceMethodDescriptor =
          MethodDescriptor.<DeleteSourceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/DeleteSource")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListPreferenceSetsRequest, ListPreferenceSetsResponse>
      listPreferenceSetsMethodDescriptor =
          MethodDescriptor.<ListPreferenceSetsRequest, ListPreferenceSetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/ListPreferenceSets")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPreferenceSetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPreferenceSetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPreferenceSetRequest, PreferenceSet>
      getPreferenceSetMethodDescriptor =
          MethodDescriptor.<GetPreferenceSetRequest, PreferenceSet>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/GetPreferenceSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPreferenceSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PreferenceSet.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreatePreferenceSetRequest, Operation>
      createPreferenceSetMethodDescriptor =
          MethodDescriptor.<CreatePreferenceSetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/CreatePreferenceSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePreferenceSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdatePreferenceSetRequest, Operation>
      updatePreferenceSetMethodDescriptor =
          MethodDescriptor.<UpdatePreferenceSetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/UpdatePreferenceSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdatePreferenceSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeletePreferenceSetRequest, Operation>
      deletePreferenceSetMethodDescriptor =
          MethodDescriptor.<DeletePreferenceSetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/DeletePreferenceSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePreferenceSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSettingsRequest, Settings> getSettingsMethodDescriptor =
      MethodDescriptor.<GetSettingsRequest, Settings>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/GetSettings")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSettingsRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Settings.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateSettingsRequest, Operation>
      updateSettingsMethodDescriptor =
          MethodDescriptor.<UpdateSettingsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/UpdateSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateReportConfigRequest, Operation>
      createReportConfigMethodDescriptor =
          MethodDescriptor.<CreateReportConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/CreateReportConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateReportConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetReportConfigRequest, ReportConfig>
      getReportConfigMethodDescriptor =
          MethodDescriptor.<GetReportConfigRequest, ReportConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/GetReportConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetReportConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReportConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListReportConfigsRequest, ListReportConfigsResponse>
      listReportConfigsMethodDescriptor =
          MethodDescriptor.<ListReportConfigsRequest, ListReportConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/ListReportConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListReportConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListReportConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteReportConfigRequest, Operation>
      deleteReportConfigMethodDescriptor =
          MethodDescriptor.<DeleteReportConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.migrationcenter.v1.MigrationCenter/DeleteReportConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteReportConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateReportRequest, Operation>
      createReportMethodDescriptor =
          MethodDescriptor.<CreateReportRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/CreateReport")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateReportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetReportRequest, Report> getReportMethodDescriptor =
      MethodDescriptor.<GetReportRequest, Report>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/GetReport")
          .setRequestMarshaller(ProtoUtils.marshaller(GetReportRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Report.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListReportsRequest, ListReportsResponse>
      listReportsMethodDescriptor =
          MethodDescriptor.<ListReportsRequest, ListReportsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/ListReports")
              .setRequestMarshaller(ProtoUtils.marshaller(ListReportsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListReportsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteReportRequest, Operation>
      deleteReportMethodDescriptor =
          MethodDescriptor.<DeleteReportRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.migrationcenter.v1.MigrationCenter/DeleteReport")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteReportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcMigrationCenterStub create(MigrationCenterStubSettings settings)
      throws IOException {
    return new GrpcMigrationCenterStub(settings, ClientContext.create(settings));
  }

  public static final GrpcMigrationCenterStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcMigrationCenterStub(
        MigrationCenterStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMigrationCenterStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMigrationCenterStub(
        MigrationCenterStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcMigrationCenterStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMigrationCenterStub(
      MigrationCenterStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcMigrationCenterCallableFactory());
  }

  /**
   * Constructs an instance of GrpcMigrationCenterStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMigrationCenterStub(
      MigrationCenterStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListAssetsRequest, ListAssetsResponse> listAssetsTransportSettings =
        GrpcCallSettings.<ListAssetsRequest, ListAssetsResponse>newBuilder()
            .setMethodDescriptor(listAssetsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetAssetRequest, Asset> getAssetTransportSettings =
        GrpcCallSettings.<GetAssetRequest, Asset>newBuilder()
            .setMethodDescriptor(getAssetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateAssetRequest, Asset> updateAssetTransportSettings =
        GrpcCallSettings.<UpdateAssetRequest, Asset>newBuilder()
            .setMethodDescriptor(updateAssetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("asset.name", String.valueOf(request.getAsset().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BatchUpdateAssetsRequest, BatchUpdateAssetsResponse>
        batchUpdateAssetsTransportSettings =
            GrpcCallSettings.<BatchUpdateAssetsRequest, BatchUpdateAssetsResponse>newBuilder()
                .setMethodDescriptor(batchUpdateAssetsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteAssetRequest, Empty> deleteAssetTransportSettings =
        GrpcCallSettings.<DeleteAssetRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAssetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BatchDeleteAssetsRequest, Empty> batchDeleteAssetsTransportSettings =
        GrpcCallSettings.<BatchDeleteAssetsRequest, Empty>newBuilder()
            .setMethodDescriptor(batchDeleteAssetsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ReportAssetFramesRequest, ReportAssetFramesResponse>
        reportAssetFramesTransportSettings =
            GrpcCallSettings.<ReportAssetFramesRequest, ReportAssetFramesResponse>newBuilder()
                .setMethodDescriptor(reportAssetFramesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<AggregateAssetsValuesRequest, AggregateAssetsValuesResponse>
        aggregateAssetsValuesTransportSettings =
            GrpcCallSettings
                .<AggregateAssetsValuesRequest, AggregateAssetsValuesResponse>newBuilder()
                .setMethodDescriptor(aggregateAssetsValuesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateImportJobRequest, Operation> createImportJobTransportSettings =
        GrpcCallSettings.<CreateImportJobRequest, Operation>newBuilder()
            .setMethodDescriptor(createImportJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListImportJobsRequest, ListImportJobsResponse>
        listImportJobsTransportSettings =
            GrpcCallSettings.<ListImportJobsRequest, ListImportJobsResponse>newBuilder()
                .setMethodDescriptor(listImportJobsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetImportJobRequest, ImportJob> getImportJobTransportSettings =
        GrpcCallSettings.<GetImportJobRequest, ImportJob>newBuilder()
            .setMethodDescriptor(getImportJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteImportJobRequest, Operation> deleteImportJobTransportSettings =
        GrpcCallSettings.<DeleteImportJobRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteImportJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateImportJobRequest, Operation> updateImportJobTransportSettings =
        GrpcCallSettings.<UpdateImportJobRequest, Operation>newBuilder()
            .setMethodDescriptor(updateImportJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("import_job.name", String.valueOf(request.getImportJob().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ValidateImportJobRequest, Operation> validateImportJobTransportSettings =
        GrpcCallSettings.<ValidateImportJobRequest, Operation>newBuilder()
            .setMethodDescriptor(validateImportJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RunImportJobRequest, Operation> runImportJobTransportSettings =
        GrpcCallSettings.<RunImportJobRequest, Operation>newBuilder()
            .setMethodDescriptor(runImportJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetImportDataFileRequest, ImportDataFile> getImportDataFileTransportSettings =
        GrpcCallSettings.<GetImportDataFileRequest, ImportDataFile>newBuilder()
            .setMethodDescriptor(getImportDataFileMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListImportDataFilesRequest, ListImportDataFilesResponse>
        listImportDataFilesTransportSettings =
            GrpcCallSettings.<ListImportDataFilesRequest, ListImportDataFilesResponse>newBuilder()
                .setMethodDescriptor(listImportDataFilesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateImportDataFileRequest, Operation> createImportDataFileTransportSettings =
        GrpcCallSettings.<CreateImportDataFileRequest, Operation>newBuilder()
            .setMethodDescriptor(createImportDataFileMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteImportDataFileRequest, Operation> deleteImportDataFileTransportSettings =
        GrpcCallSettings.<DeleteImportDataFileRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteImportDataFileMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListGroupsRequest, ListGroupsResponse> listGroupsTransportSettings =
        GrpcCallSettings.<ListGroupsRequest, ListGroupsResponse>newBuilder()
            .setMethodDescriptor(listGroupsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetGroupRequest, Group> getGroupTransportSettings =
        GrpcCallSettings.<GetGroupRequest, Group>newBuilder()
            .setMethodDescriptor(getGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateGroupRequest, Operation> createGroupTransportSettings =
        GrpcCallSettings.<CreateGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(createGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateGroupRequest, Operation> updateGroupTransportSettings =
        GrpcCallSettings.<UpdateGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(updateGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("group.name", String.valueOf(request.getGroup().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteGroupRequest, Operation> deleteGroupTransportSettings =
        GrpcCallSettings.<DeleteGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<AddAssetsToGroupRequest, Operation> addAssetsToGroupTransportSettings =
        GrpcCallSettings.<AddAssetsToGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(addAssetsToGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("group", String.valueOf(request.getGroup()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RemoveAssetsFromGroupRequest, Operation>
        removeAssetsFromGroupTransportSettings =
            GrpcCallSettings.<RemoveAssetsFromGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(removeAssetsFromGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("group", String.valueOf(request.getGroup()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListErrorFramesRequest, ListErrorFramesResponse>
        listErrorFramesTransportSettings =
            GrpcCallSettings.<ListErrorFramesRequest, ListErrorFramesResponse>newBuilder()
                .setMethodDescriptor(listErrorFramesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetErrorFrameRequest, ErrorFrame> getErrorFrameTransportSettings =
        GrpcCallSettings.<GetErrorFrameRequest, ErrorFrame>newBuilder()
            .setMethodDescriptor(getErrorFrameMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSourcesRequest, ListSourcesResponse> listSourcesTransportSettings =
        GrpcCallSettings.<ListSourcesRequest, ListSourcesResponse>newBuilder()
            .setMethodDescriptor(listSourcesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSourceRequest, Source> getSourceTransportSettings =
        GrpcCallSettings.<GetSourceRequest, Source>newBuilder()
            .setMethodDescriptor(getSourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateSourceRequest, Operation> createSourceTransportSettings =
        GrpcCallSettings.<CreateSourceRequest, Operation>newBuilder()
            .setMethodDescriptor(createSourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSourceRequest, Operation> updateSourceTransportSettings =
        GrpcCallSettings.<UpdateSourceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("source.name", String.valueOf(request.getSource().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSourceRequest, Operation> deleteSourceTransportSettings =
        GrpcCallSettings.<DeleteSourceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListPreferenceSetsRequest, ListPreferenceSetsResponse>
        listPreferenceSetsTransportSettings =
            GrpcCallSettings.<ListPreferenceSetsRequest, ListPreferenceSetsResponse>newBuilder()
                .setMethodDescriptor(listPreferenceSetsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetPreferenceSetRequest, PreferenceSet> getPreferenceSetTransportSettings =
        GrpcCallSettings.<GetPreferenceSetRequest, PreferenceSet>newBuilder()
            .setMethodDescriptor(getPreferenceSetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreatePreferenceSetRequest, Operation> createPreferenceSetTransportSettings =
        GrpcCallSettings.<CreatePreferenceSetRequest, Operation>newBuilder()
            .setMethodDescriptor(createPreferenceSetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdatePreferenceSetRequest, Operation> updatePreferenceSetTransportSettings =
        GrpcCallSettings.<UpdatePreferenceSetRequest, Operation>newBuilder()
            .setMethodDescriptor(updatePreferenceSetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "preference_set.name", String.valueOf(request.getPreferenceSet().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeletePreferenceSetRequest, Operation> deletePreferenceSetTransportSettings =
        GrpcCallSettings.<DeletePreferenceSetRequest, Operation>newBuilder()
            .setMethodDescriptor(deletePreferenceSetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSettingsRequest, Settings> getSettingsTransportSettings =
        GrpcCallSettings.<GetSettingsRequest, Settings>newBuilder()
            .setMethodDescriptor(getSettingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSettingsRequest, Operation> updateSettingsTransportSettings =
        GrpcCallSettings.<UpdateSettingsRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSettingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("settings.name", String.valueOf(request.getSettings().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateReportConfigRequest, Operation> createReportConfigTransportSettings =
        GrpcCallSettings.<CreateReportConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(createReportConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetReportConfigRequest, ReportConfig> getReportConfigTransportSettings =
        GrpcCallSettings.<GetReportConfigRequest, ReportConfig>newBuilder()
            .setMethodDescriptor(getReportConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListReportConfigsRequest, ListReportConfigsResponse>
        listReportConfigsTransportSettings =
            GrpcCallSettings.<ListReportConfigsRequest, ListReportConfigsResponse>newBuilder()
                .setMethodDescriptor(listReportConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteReportConfigRequest, Operation> deleteReportConfigTransportSettings =
        GrpcCallSettings.<DeleteReportConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteReportConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateReportRequest, Operation> createReportTransportSettings =
        GrpcCallSettings.<CreateReportRequest, Operation>newBuilder()
            .setMethodDescriptor(createReportMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetReportRequest, Report> getReportTransportSettings =
        GrpcCallSettings.<GetReportRequest, Report>newBuilder()
            .setMethodDescriptor(getReportMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListReportsRequest, ListReportsResponse> listReportsTransportSettings =
        GrpcCallSettings.<ListReportsRequest, ListReportsResponse>newBuilder()
            .setMethodDescriptor(listReportsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteReportRequest, Operation> deleteReportTransportSettings =
        GrpcCallSettings.<DeleteReportRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteReportMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
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
            operationsStub);
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
            operationsStub);
    this.updateImportJobCallable =
        callableFactory.createUnaryCallable(
            updateImportJobTransportSettings, settings.updateImportJobSettings(), clientContext);
    this.updateImportJobOperationCallable =
        callableFactory.createOperationCallable(
            updateImportJobTransportSettings,
            settings.updateImportJobOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
    this.runImportJobCallable =
        callableFactory.createUnaryCallable(
            runImportJobTransportSettings, settings.runImportJobSettings(), clientContext);
    this.runImportJobOperationCallable =
        callableFactory.createOperationCallable(
            runImportJobTransportSettings,
            settings.runImportJobOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
    this.updateGroupCallable =
        callableFactory.createUnaryCallable(
            updateGroupTransportSettings, settings.updateGroupSettings(), clientContext);
    this.updateGroupOperationCallable =
        callableFactory.createOperationCallable(
            updateGroupTransportSettings,
            settings.updateGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteGroupCallable =
        callableFactory.createUnaryCallable(
            deleteGroupTransportSettings, settings.deleteGroupSettings(), clientContext);
    this.deleteGroupOperationCallable =
        callableFactory.createOperationCallable(
            deleteGroupTransportSettings,
            settings.deleteGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.addAssetsToGroupCallable =
        callableFactory.createUnaryCallable(
            addAssetsToGroupTransportSettings, settings.addAssetsToGroupSettings(), clientContext);
    this.addAssetsToGroupOperationCallable =
        callableFactory.createOperationCallable(
            addAssetsToGroupTransportSettings,
            settings.addAssetsToGroupOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
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
            operationsStub);
    this.updateSourceCallable =
        callableFactory.createUnaryCallable(
            updateSourceTransportSettings, settings.updateSourceSettings(), clientContext);
    this.updateSourceOperationCallable =
        callableFactory.createOperationCallable(
            updateSourceTransportSettings,
            settings.updateSourceOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteSourceCallable =
        callableFactory.createUnaryCallable(
            deleteSourceTransportSettings, settings.deleteSourceSettings(), clientContext);
    this.deleteSourceOperationCallable =
        callableFactory.createOperationCallable(
            deleteSourceTransportSettings,
            settings.deleteSourceOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
    this.createReportCallable =
        callableFactory.createUnaryCallable(
            createReportTransportSettings, settings.createReportSettings(), clientContext);
    this.createReportOperationCallable =
        callableFactory.createOperationCallable(
            createReportTransportSettings,
            settings.createReportOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
