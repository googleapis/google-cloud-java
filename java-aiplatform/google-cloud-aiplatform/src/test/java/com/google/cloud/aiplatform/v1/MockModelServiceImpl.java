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

package com.google.cloud.aiplatform.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.aiplatform.v1.ModelServiceGrpc.ModelServiceImplBase;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockModelServiceImpl extends ModelServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockModelServiceImpl() {
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
  public void uploadModel(UploadModelRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UploadModel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getModel(GetModelRequest request, StreamObserver<Model> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Model) {
      requests.add(request);
      responseObserver.onNext(((Model) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetModel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Model.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listModels(
      ListModelsRequest request, StreamObserver<ListModelsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListModelsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListModelsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListModels, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListModelsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listModelVersions(
      ListModelVersionsRequest request,
      StreamObserver<ListModelVersionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListModelVersionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListModelVersionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListModelVersions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListModelVersionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateModel(UpdateModelRequest request, StreamObserver<Model> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Model) {
      requests.add(request);
      responseObserver.onNext(((Model) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateModel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Model.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteModel(DeleteModelRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteModel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteModelVersion(
      DeleteModelVersionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteModelVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void mergeVersionAliases(
      MergeVersionAliasesRequest request, StreamObserver<Model> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Model) {
      requests.add(request);
      responseObserver.onNext(((Model) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method MergeVersionAliases, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Model.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void exportModel(ExportModelRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ExportModel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importModelEvaluation(
      ImportModelEvaluationRequest request, StreamObserver<ModelEvaluation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ModelEvaluation) {
      requests.add(request);
      responseObserver.onNext(((ModelEvaluation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ImportModelEvaluation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ModelEvaluation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchImportModelEvaluationSlices(
      BatchImportModelEvaluationSlicesRequest request,
      StreamObserver<BatchImportModelEvaluationSlicesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchImportModelEvaluationSlicesResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchImportModelEvaluationSlicesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchImportModelEvaluationSlices, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchImportModelEvaluationSlicesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getModelEvaluation(
      GetModelEvaluationRequest request, StreamObserver<ModelEvaluation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ModelEvaluation) {
      requests.add(request);
      responseObserver.onNext(((ModelEvaluation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetModelEvaluation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ModelEvaluation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listModelEvaluations(
      ListModelEvaluationsRequest request,
      StreamObserver<ListModelEvaluationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListModelEvaluationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListModelEvaluationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListModelEvaluations, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListModelEvaluationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getModelEvaluationSlice(
      GetModelEvaluationSliceRequest request,
      StreamObserver<ModelEvaluationSlice> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ModelEvaluationSlice) {
      requests.add(request);
      responseObserver.onNext(((ModelEvaluationSlice) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetModelEvaluationSlice, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ModelEvaluationSlice.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listModelEvaluationSlices(
      ListModelEvaluationSlicesRequest request,
      StreamObserver<ListModelEvaluationSlicesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListModelEvaluationSlicesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListModelEvaluationSlicesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListModelEvaluationSlices, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListModelEvaluationSlicesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
