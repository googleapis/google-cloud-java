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
import com.google.api.gax.rpc.OperationCallable;
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
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the MigrationCenter service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class MigrationCenterStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListAssetsRequest, ListAssetsPagedResponse> listAssetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAssetsPagedCallable()");
  }

  public UnaryCallable<ListAssetsRequest, ListAssetsResponse> listAssetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAssetsCallable()");
  }

  public UnaryCallable<GetAssetRequest, Asset> getAssetCallable() {
    throw new UnsupportedOperationException("Not implemented: getAssetCallable()");
  }

  public UnaryCallable<UpdateAssetRequest, Asset> updateAssetCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAssetCallable()");
  }

  public UnaryCallable<BatchUpdateAssetsRequest, BatchUpdateAssetsResponse>
      batchUpdateAssetsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateAssetsCallable()");
  }

  public UnaryCallable<DeleteAssetRequest, Empty> deleteAssetCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAssetCallable()");
  }

  public UnaryCallable<BatchDeleteAssetsRequest, Empty> batchDeleteAssetsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeleteAssetsCallable()");
  }

  public UnaryCallable<ReportAssetFramesRequest, ReportAssetFramesResponse>
      reportAssetFramesCallable() {
    throw new UnsupportedOperationException("Not implemented: reportAssetFramesCallable()");
  }

  public UnaryCallable<AggregateAssetsValuesRequest, AggregateAssetsValuesResponse>
      aggregateAssetsValuesCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregateAssetsValuesCallable()");
  }

  public OperationCallable<CreateImportJobRequest, ImportJob, OperationMetadata>
      createImportJobOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createImportJobOperationCallable()");
  }

  public UnaryCallable<CreateImportJobRequest, Operation> createImportJobCallable() {
    throw new UnsupportedOperationException("Not implemented: createImportJobCallable()");
  }

  public UnaryCallable<ListImportJobsRequest, ListImportJobsPagedResponse>
      listImportJobsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listImportJobsPagedCallable()");
  }

  public UnaryCallable<ListImportJobsRequest, ListImportJobsResponse> listImportJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listImportJobsCallable()");
  }

  public UnaryCallable<GetImportJobRequest, ImportJob> getImportJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getImportJobCallable()");
  }

  public OperationCallable<DeleteImportJobRequest, Empty, OperationMetadata>
      deleteImportJobOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteImportJobOperationCallable()");
  }

  public UnaryCallable<DeleteImportJobRequest, Operation> deleteImportJobCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteImportJobCallable()");
  }

  public OperationCallable<UpdateImportJobRequest, ImportJob, OperationMetadata>
      updateImportJobOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateImportJobOperationCallable()");
  }

  public UnaryCallable<UpdateImportJobRequest, Operation> updateImportJobCallable() {
    throw new UnsupportedOperationException("Not implemented: updateImportJobCallable()");
  }

  public OperationCallable<ValidateImportJobRequest, Empty, OperationMetadata>
      validateImportJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: validateImportJobOperationCallable()");
  }

  public UnaryCallable<ValidateImportJobRequest, Operation> validateImportJobCallable() {
    throw new UnsupportedOperationException("Not implemented: validateImportJobCallable()");
  }

  public OperationCallable<RunImportJobRequest, Empty, OperationMetadata>
      runImportJobOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: runImportJobOperationCallable()");
  }

  public UnaryCallable<RunImportJobRequest, Operation> runImportJobCallable() {
    throw new UnsupportedOperationException("Not implemented: runImportJobCallable()");
  }

  public UnaryCallable<GetImportDataFileRequest, ImportDataFile> getImportDataFileCallable() {
    throw new UnsupportedOperationException("Not implemented: getImportDataFileCallable()");
  }

  public UnaryCallable<ListImportDataFilesRequest, ListImportDataFilesPagedResponse>
      listImportDataFilesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listImportDataFilesPagedCallable()");
  }

  public UnaryCallable<ListImportDataFilesRequest, ListImportDataFilesResponse>
      listImportDataFilesCallable() {
    throw new UnsupportedOperationException("Not implemented: listImportDataFilesCallable()");
  }

  public OperationCallable<CreateImportDataFileRequest, ImportDataFile, OperationMetadata>
      createImportDataFileOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createImportDataFileOperationCallable()");
  }

  public UnaryCallable<CreateImportDataFileRequest, Operation> createImportDataFileCallable() {
    throw new UnsupportedOperationException("Not implemented: createImportDataFileCallable()");
  }

  public OperationCallable<DeleteImportDataFileRequest, Empty, OperationMetadata>
      deleteImportDataFileOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteImportDataFileOperationCallable()");
  }

  public UnaryCallable<DeleteImportDataFileRequest, Operation> deleteImportDataFileCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteImportDataFileCallable()");
  }

  public UnaryCallable<ListGroupsRequest, ListGroupsPagedResponse> listGroupsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listGroupsPagedCallable()");
  }

  public UnaryCallable<ListGroupsRequest, ListGroupsResponse> listGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listGroupsCallable()");
  }

  public UnaryCallable<GetGroupRequest, Group> getGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getGroupCallable()");
  }

  public OperationCallable<CreateGroupRequest, Group, OperationMetadata>
      createGroupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createGroupOperationCallable()");
  }

  public UnaryCallable<CreateGroupRequest, Operation> createGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: createGroupCallable()");
  }

  public OperationCallable<UpdateGroupRequest, Group, OperationMetadata>
      updateGroupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateGroupOperationCallable()");
  }

  public UnaryCallable<UpdateGroupRequest, Operation> updateGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: updateGroupCallable()");
  }

  public OperationCallable<DeleteGroupRequest, Empty, OperationMetadata>
      deleteGroupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteGroupOperationCallable()");
  }

  public UnaryCallable<DeleteGroupRequest, Operation> deleteGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteGroupCallable()");
  }

  public OperationCallable<AddAssetsToGroupRequest, Group, OperationMetadata>
      addAssetsToGroupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: addAssetsToGroupOperationCallable()");
  }

  public UnaryCallable<AddAssetsToGroupRequest, Operation> addAssetsToGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: addAssetsToGroupCallable()");
  }

  public OperationCallable<RemoveAssetsFromGroupRequest, Group, OperationMetadata>
      removeAssetsFromGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: removeAssetsFromGroupOperationCallable()");
  }

  public UnaryCallable<RemoveAssetsFromGroupRequest, Operation> removeAssetsFromGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: removeAssetsFromGroupCallable()");
  }

  public UnaryCallable<ListErrorFramesRequest, ListErrorFramesPagedResponse>
      listErrorFramesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listErrorFramesPagedCallable()");
  }

  public UnaryCallable<ListErrorFramesRequest, ListErrorFramesResponse> listErrorFramesCallable() {
    throw new UnsupportedOperationException("Not implemented: listErrorFramesCallable()");
  }

  public UnaryCallable<GetErrorFrameRequest, ErrorFrame> getErrorFrameCallable() {
    throw new UnsupportedOperationException("Not implemented: getErrorFrameCallable()");
  }

  public UnaryCallable<ListSourcesRequest, ListSourcesPagedResponse> listSourcesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSourcesPagedCallable()");
  }

  public UnaryCallable<ListSourcesRequest, ListSourcesResponse> listSourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: listSourcesCallable()");
  }

  public UnaryCallable<GetSourceRequest, Source> getSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: getSourceCallable()");
  }

  public OperationCallable<CreateSourceRequest, Source, OperationMetadata>
      createSourceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createSourceOperationCallable()");
  }

  public UnaryCallable<CreateSourceRequest, Operation> createSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: createSourceCallable()");
  }

  public OperationCallable<UpdateSourceRequest, Source, OperationMetadata>
      updateSourceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSourceOperationCallable()");
  }

  public UnaryCallable<UpdateSourceRequest, Operation> updateSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSourceCallable()");
  }

  public OperationCallable<DeleteSourceRequest, Empty, OperationMetadata>
      deleteSourceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSourceOperationCallable()");
  }

  public UnaryCallable<DeleteSourceRequest, Operation> deleteSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSourceCallable()");
  }

  public UnaryCallable<ListPreferenceSetsRequest, ListPreferenceSetsPagedResponse>
      listPreferenceSetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPreferenceSetsPagedCallable()");
  }

  public UnaryCallable<ListPreferenceSetsRequest, ListPreferenceSetsResponse>
      listPreferenceSetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPreferenceSetsCallable()");
  }

  public UnaryCallable<GetPreferenceSetRequest, PreferenceSet> getPreferenceSetCallable() {
    throw new UnsupportedOperationException("Not implemented: getPreferenceSetCallable()");
  }

  public OperationCallable<CreatePreferenceSetRequest, PreferenceSet, OperationMetadata>
      createPreferenceSetOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createPreferenceSetOperationCallable()");
  }

  public UnaryCallable<CreatePreferenceSetRequest, Operation> createPreferenceSetCallable() {
    throw new UnsupportedOperationException("Not implemented: createPreferenceSetCallable()");
  }

  public OperationCallable<UpdatePreferenceSetRequest, PreferenceSet, OperationMetadata>
      updatePreferenceSetOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updatePreferenceSetOperationCallable()");
  }

  public UnaryCallable<UpdatePreferenceSetRequest, Operation> updatePreferenceSetCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePreferenceSetCallable()");
  }

  public OperationCallable<DeletePreferenceSetRequest, Empty, OperationMetadata>
      deletePreferenceSetOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deletePreferenceSetOperationCallable()");
  }

  public UnaryCallable<DeletePreferenceSetRequest, Operation> deletePreferenceSetCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePreferenceSetCallable()");
  }

  public UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: getSettingsCallable()");
  }

  public OperationCallable<UpdateSettingsRequest, Settings, OperationMetadata>
      updateSettingsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSettingsOperationCallable()");
  }

  public UnaryCallable<UpdateSettingsRequest, Operation> updateSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSettingsCallable()");
  }

  public OperationCallable<CreateReportConfigRequest, ReportConfig, OperationMetadata>
      createReportConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createReportConfigOperationCallable()");
  }

  public UnaryCallable<CreateReportConfigRequest, Operation> createReportConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createReportConfigCallable()");
  }

  public UnaryCallable<GetReportConfigRequest, ReportConfig> getReportConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getReportConfigCallable()");
  }

  public UnaryCallable<ListReportConfigsRequest, ListReportConfigsPagedResponse>
      listReportConfigsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listReportConfigsPagedCallable()");
  }

  public UnaryCallable<ListReportConfigsRequest, ListReportConfigsResponse>
      listReportConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listReportConfigsCallable()");
  }

  public OperationCallable<DeleteReportConfigRequest, Empty, OperationMetadata>
      deleteReportConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteReportConfigOperationCallable()");
  }

  public UnaryCallable<DeleteReportConfigRequest, Operation> deleteReportConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteReportConfigCallable()");
  }

  public OperationCallable<CreateReportRequest, Report, OperationMetadata>
      createReportOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createReportOperationCallable()");
  }

  public UnaryCallable<CreateReportRequest, Operation> createReportCallable() {
    throw new UnsupportedOperationException("Not implemented: createReportCallable()");
  }

  public UnaryCallable<GetReportRequest, Report> getReportCallable() {
    throw new UnsupportedOperationException("Not implemented: getReportCallable()");
  }

  public UnaryCallable<ListReportsRequest, ListReportsPagedResponse> listReportsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listReportsPagedCallable()");
  }

  public UnaryCallable<ListReportsRequest, ListReportsResponse> listReportsCallable() {
    throw new UnsupportedOperationException("Not implemented: listReportsCallable()");
  }

  public OperationCallable<DeleteReportRequest, Empty, OperationMetadata>
      deleteReportOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteReportOperationCallable()");
  }

  public UnaryCallable<DeleteReportRequest, Operation> deleteReportCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteReportCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
