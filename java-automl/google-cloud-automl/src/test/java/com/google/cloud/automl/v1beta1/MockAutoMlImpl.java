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

package com.google.cloud.automl.v1beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.automl.v1beta1.AutoMlGrpc.AutoMlImplBase;
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
public class MockAutoMlImpl extends AutoMlImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAutoMlImpl() {
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
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDataset, expected %s or %s",
                  response.getClass().getName(),
                  Dataset.class.getName(),
                  Exception.class.getName())));
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
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDataset, expected %s or %s",
                  response.getClass().getName(),
                  Dataset.class.getName(),
                  Exception.class.getName())));
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
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDatasets, expected %s or %s",
                  response.getClass().getName(),
                  ListDatasetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDataset(
      UpdateDatasetRequest request, StreamObserver<Dataset> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Dataset) {
      requests.add(request);
      responseObserver.onNext(((Dataset) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDataset, expected %s or %s",
                  response.getClass().getName(),
                  Dataset.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDataset(
      DeleteDatasetRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method DeleteDataset, expected %s or %s",
                  response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
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
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ImportData, expected %s or %s",
                  response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
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
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ExportData, expected %s or %s",
                  response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAnnotationSpec(
      GetAnnotationSpecRequest request, StreamObserver<AnnotationSpec> responseObserver) {
    Object response = responses.remove();
    if (response instanceof AnnotationSpec) {
      requests.add(request);
      responseObserver.onNext(((AnnotationSpec) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAnnotationSpec, expected %s or %s",
                  response.getClass().getName(),
                  AnnotationSpec.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTableSpec(
      GetTableSpecRequest request, StreamObserver<TableSpec> responseObserver) {
    Object response = responses.remove();
    if (response instanceof TableSpec) {
      requests.add(request);
      responseObserver.onNext(((TableSpec) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTableSpec, expected %s or %s",
                  response.getClass().getName(),
                  TableSpec.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTableSpecs(
      ListTableSpecsRequest request, StreamObserver<ListTableSpecsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListTableSpecsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTableSpecsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTableSpecs, expected %s or %s",
                  response.getClass().getName(),
                  ListTableSpecsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTableSpec(
      UpdateTableSpecRequest request, StreamObserver<TableSpec> responseObserver) {
    Object response = responses.remove();
    if (response instanceof TableSpec) {
      requests.add(request);
      responseObserver.onNext(((TableSpec) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateTableSpec, expected %s or %s",
                  response.getClass().getName(),
                  TableSpec.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getColumnSpec(
      GetColumnSpecRequest request, StreamObserver<ColumnSpec> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ColumnSpec) {
      requests.add(request);
      responseObserver.onNext(((ColumnSpec) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetColumnSpec, expected %s or %s",
                  response.getClass().getName(),
                  ColumnSpec.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listColumnSpecs(
      ListColumnSpecsRequest request, StreamObserver<ListColumnSpecsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListColumnSpecsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListColumnSpecsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListColumnSpecs, expected %s or %s",
                  response.getClass().getName(),
                  ListColumnSpecsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateColumnSpec(
      UpdateColumnSpecRequest request, StreamObserver<ColumnSpec> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ColumnSpec) {
      requests.add(request);
      responseObserver.onNext(((ColumnSpec) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateColumnSpec, expected %s or %s",
                  response.getClass().getName(),
                  ColumnSpec.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createModel(CreateModelRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method CreateModel, expected %s or %s",
                  response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getModel(GetModelRequest request, StreamObserver<Model> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  Model.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listModels(
      ListModelsRequest request, StreamObserver<ListModelsResponse> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  ListModelsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteModel(DeleteModelRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deployModel(DeployModelRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method DeployModel, expected %s or %s",
                  response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void undeployModel(
      UndeployModelRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method UndeployModel, expected %s or %s",
                  response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void exportModel(ExportModelRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void exportEvaluatedExamples(
      ExportEvaluatedExamplesRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method ExportEvaluatedExamples, expected %s or %s",
                  response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getModelEvaluation(
      GetModelEvaluationRequest request, StreamObserver<ModelEvaluation> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  ModelEvaluation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listModelEvaluations(
      ListModelEvaluationsRequest request,
      StreamObserver<ListModelEvaluationsResponse> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  ListModelEvaluationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
