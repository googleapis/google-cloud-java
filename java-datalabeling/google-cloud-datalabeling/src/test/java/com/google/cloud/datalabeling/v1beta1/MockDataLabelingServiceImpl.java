/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.datalabeling.v1beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceGrpc.DataLabelingServiceImplBase;
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
public class MockDataLabelingServiceImpl extends DataLabelingServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDataLabelingServiceImpl() {
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
  public void createDataset(
      CreateDatasetRequest request, StreamObserver<Dataset> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Dataset) {
      requests.add(request);
      responseObserver.onNext(((Dataset) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getDataset(GetDatasetRequest request, StreamObserver<Dataset> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Dataset) {
      requests.add(request);
      responseObserver.onNext(((Dataset) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listDatasets(
      ListDatasetsRequest request, StreamObserver<ListDatasetsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListDatasetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDatasetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deleteDataset(DeleteDatasetRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void importData(ImportDataRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void exportData(ExportDataRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getDataItem(GetDataItemRequest request, StreamObserver<DataItem> responseObserver) {
    Object response = responses.remove();
    if (response instanceof DataItem) {
      requests.add(request);
      responseObserver.onNext(((DataItem) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listDataItems(
      ListDataItemsRequest request, StreamObserver<ListDataItemsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListDataItemsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDataItemsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getAnnotatedDataset(
      GetAnnotatedDatasetRequest request, StreamObserver<AnnotatedDataset> responseObserver) {
    Object response = responses.remove();
    if (response instanceof AnnotatedDataset) {
      requests.add(request);
      responseObserver.onNext(((AnnotatedDataset) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listAnnotatedDatasets(
      ListAnnotatedDatasetsRequest request,
      StreamObserver<ListAnnotatedDatasetsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListAnnotatedDatasetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAnnotatedDatasetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deleteAnnotatedDataset(
      DeleteAnnotatedDatasetRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void labelImage(LabelImageRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void labelVideo(LabelVideoRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void labelText(LabelTextRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getExample(GetExampleRequest request, StreamObserver<Example> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Example) {
      requests.add(request);
      responseObserver.onNext(((Example) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listExamples(
      ListExamplesRequest request, StreamObserver<ListExamplesResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListExamplesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListExamplesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void createAnnotationSpecSet(
      CreateAnnotationSpecSetRequest request, StreamObserver<AnnotationSpecSet> responseObserver) {
    Object response = responses.remove();
    if (response instanceof AnnotationSpecSet) {
      requests.add(request);
      responseObserver.onNext(((AnnotationSpecSet) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getAnnotationSpecSet(
      GetAnnotationSpecSetRequest request, StreamObserver<AnnotationSpecSet> responseObserver) {
    Object response = responses.remove();
    if (response instanceof AnnotationSpecSet) {
      requests.add(request);
      responseObserver.onNext(((AnnotationSpecSet) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listAnnotationSpecSets(
      ListAnnotationSpecSetsRequest request,
      StreamObserver<ListAnnotationSpecSetsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListAnnotationSpecSetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAnnotationSpecSetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deleteAnnotationSpecSet(
      DeleteAnnotationSpecSetRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void createInstruction(
      CreateInstructionRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getInstruction(
      GetInstructionRequest request, StreamObserver<Instruction> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Instruction) {
      requests.add(request);
      responseObserver.onNext(((Instruction) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listInstructions(
      ListInstructionsRequest request, StreamObserver<ListInstructionsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListInstructionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListInstructionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deleteInstruction(
      DeleteInstructionRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getEvaluation(
      GetEvaluationRequest request, StreamObserver<Evaluation> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Evaluation) {
      requests.add(request);
      responseObserver.onNext(((Evaluation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void searchEvaluations(
      SearchEvaluationsRequest request,
      StreamObserver<SearchEvaluationsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof SearchEvaluationsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchEvaluationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void searchExampleComparisons(
      SearchExampleComparisonsRequest request,
      StreamObserver<SearchExampleComparisonsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof SearchExampleComparisonsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchExampleComparisonsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void createEvaluationJob(
      CreateEvaluationJobRequest request, StreamObserver<EvaluationJob> responseObserver) {
    Object response = responses.remove();
    if (response instanceof EvaluationJob) {
      requests.add(request);
      responseObserver.onNext(((EvaluationJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void updateEvaluationJob(
      UpdateEvaluationJobRequest request, StreamObserver<EvaluationJob> responseObserver) {
    Object response = responses.remove();
    if (response instanceof EvaluationJob) {
      requests.add(request);
      responseObserver.onNext(((EvaluationJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getEvaluationJob(
      GetEvaluationJobRequest request, StreamObserver<EvaluationJob> responseObserver) {
    Object response = responses.remove();
    if (response instanceof EvaluationJob) {
      requests.add(request);
      responseObserver.onNext(((EvaluationJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void pauseEvaluationJob(
      PauseEvaluationJobRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void resumeEvaluationJob(
      ResumeEvaluationJobRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deleteEvaluationJob(
      DeleteEvaluationJobRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listEvaluationJobs(
      ListEvaluationJobsRequest request,
      StreamObserver<ListEvaluationJobsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListEvaluationJobsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEvaluationJobsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }
}
