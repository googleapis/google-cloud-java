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

package com.google.cloud.migrationcenter.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.migrationcenter.v1.MigrationCenterGrpc.MigrationCenterImplBase;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockMigrationCenterImpl extends MigrationCenterImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockMigrationCenterImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<AbstractMessage> getRequests() {
    return requests;
  }

  public void addResponse(AbstractMessage response) {
    responses.add(response);
  }

  public void setResponses(List<AbstractMessage> responses) {
    this.responses = new LinkedList<Object>(responses);
  }

  public void addException(Exception exception) {
    responses.add(exception);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void listAssets(
      ListAssetsRequest request, StreamObserver<ListAssetsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAssetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAssetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAssets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAssetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAsset(GetAssetRequest request, StreamObserver<Asset> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Asset) {
      requests.add(request);
      responseObserver.onNext(((Asset) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAsset, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Asset.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAsset(UpdateAssetRequest request, StreamObserver<Asset> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Asset) {
      requests.add(request);
      responseObserver.onNext(((Asset) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateAsset, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Asset.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchUpdateAssets(
      BatchUpdateAssetsRequest request,
      StreamObserver<BatchUpdateAssetsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchUpdateAssetsResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchUpdateAssetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchUpdateAssets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchUpdateAssetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAsset(DeleteAssetRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteAsset, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchDeleteAssets(
      BatchDeleteAssetsRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchDeleteAssets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void reportAssetFrames(
      ReportAssetFramesRequest request,
      StreamObserver<ReportAssetFramesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ReportAssetFramesResponse) {
      requests.add(request);
      responseObserver.onNext(((ReportAssetFramesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ReportAssetFrames, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ReportAssetFramesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void aggregateAssetsValues(
      AggregateAssetsValuesRequest request,
      StreamObserver<AggregateAssetsValuesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AggregateAssetsValuesResponse) {
      requests.add(request);
      responseObserver.onNext(((AggregateAssetsValuesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AggregateAssetsValues, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AggregateAssetsValuesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createImportJob(
      CreateImportJobRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateImportJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listImportJobs(
      ListImportJobsRequest request, StreamObserver<ListImportJobsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListImportJobsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListImportJobsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListImportJobs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListImportJobsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getImportJob(
      GetImportJobRequest request, StreamObserver<ImportJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ImportJob) {
      requests.add(request);
      responseObserver.onNext(((ImportJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetImportJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ImportJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteImportJob(
      DeleteImportJobRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteImportJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateImportJob(
      UpdateImportJobRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateImportJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void validateImportJob(
      ValidateImportJobRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ValidateImportJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void runImportJob(
      RunImportJobRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RunImportJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getImportDataFile(
      GetImportDataFileRequest request, StreamObserver<ImportDataFile> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ImportDataFile) {
      requests.add(request);
      responseObserver.onNext(((ImportDataFile) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetImportDataFile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ImportDataFile.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listImportDataFiles(
      ListImportDataFilesRequest request,
      StreamObserver<ListImportDataFilesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListImportDataFilesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListImportDataFilesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListImportDataFiles, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListImportDataFilesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createImportDataFile(
      CreateImportDataFileRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateImportDataFile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteImportDataFile(
      DeleteImportDataFileRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteImportDataFile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listGroups(
      ListGroupsRequest request, StreamObserver<ListGroupsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListGroupsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListGroupsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListGroups, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListGroupsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getGroup(GetGroupRequest request, StreamObserver<Group> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Group) {
      requests.add(request);
      responseObserver.onNext(((Group) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Group.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createGroup(CreateGroupRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateGroup(UpdateGroupRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteGroup(DeleteGroupRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void addAssetsToGroup(
      AddAssetsToGroupRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AddAssetsToGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void removeAssetsFromGroup(
      RemoveAssetsFromGroupRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RemoveAssetsFromGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listErrorFrames(
      ListErrorFramesRequest request, StreamObserver<ListErrorFramesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListErrorFramesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListErrorFramesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListErrorFrames, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListErrorFramesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getErrorFrame(
      GetErrorFrameRequest request, StreamObserver<ErrorFrame> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ErrorFrame) {
      requests.add(request);
      responseObserver.onNext(((ErrorFrame) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetErrorFrame, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ErrorFrame.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSources(
      ListSourcesRequest request, StreamObserver<ListSourcesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSourcesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSourcesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSources, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSourcesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSource(GetSourceRequest request, StreamObserver<Source> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Source) {
      requests.add(request);
      responseObserver.onNext(((Source) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSource, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Source.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSource(
      CreateSourceRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSource, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSource(
      UpdateSourceRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSource, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSource(
      DeleteSourceRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteSource, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPreferenceSets(
      ListPreferenceSetsRequest request,
      StreamObserver<ListPreferenceSetsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPreferenceSetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPreferenceSetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPreferenceSets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPreferenceSetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPreferenceSet(
      GetPreferenceSetRequest request, StreamObserver<PreferenceSet> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PreferenceSet) {
      requests.add(request);
      responseObserver.onNext(((PreferenceSet) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPreferenceSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PreferenceSet.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createPreferenceSet(
      CreatePreferenceSetRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreatePreferenceSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updatePreferenceSet(
      UpdatePreferenceSetRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdatePreferenceSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deletePreferenceSet(
      DeletePreferenceSetRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeletePreferenceSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSettings(GetSettingsRequest request, StreamObserver<Settings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Settings) {
      requests.add(request);
      responseObserver.onNext(((Settings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Settings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSettings(
      UpdateSettingsRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createReportConfig(
      CreateReportConfigRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateReportConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getReportConfig(
      GetReportConfigRequest request, StreamObserver<ReportConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ReportConfig) {
      requests.add(request);
      responseObserver.onNext(((ReportConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetReportConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ReportConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listReportConfigs(
      ListReportConfigsRequest request,
      StreamObserver<ListReportConfigsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListReportConfigsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListReportConfigsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListReportConfigs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListReportConfigsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteReportConfig(
      DeleteReportConfigRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteReportConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createReport(
      CreateReportRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateReport, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getReport(GetReportRequest request, StreamObserver<Report> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Report) {
      requests.add(request);
      responseObserver.onNext(((Report) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetReport, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Report.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listReports(
      ListReportsRequest request, StreamObserver<ListReportsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListReportsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListReportsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListReports, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListReportsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteReport(
      DeleteReportRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteReport, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
