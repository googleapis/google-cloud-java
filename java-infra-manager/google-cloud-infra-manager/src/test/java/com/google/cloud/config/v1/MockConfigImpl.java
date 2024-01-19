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

package com.google.cloud.config.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.config.v1.ConfigGrpc.ConfigImplBase;
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
public class MockConfigImpl extends ConfigImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockConfigImpl() {
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
  public void listDeployments(
      ListDeploymentsRequest request, StreamObserver<ListDeploymentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDeploymentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDeploymentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDeployments, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDeploymentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDeployment(
      GetDeploymentRequest request, StreamObserver<Deployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Deployment) {
      requests.add(request);
      responseObserver.onNext(((Deployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Deployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDeployment(
      CreateDeploymentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDeployment(
      UpdateDeploymentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDeployment(
      DeleteDeploymentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRevisions(
      ListRevisionsRequest request, StreamObserver<ListRevisionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRevisionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRevisionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRevisions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRevisionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRevision(GetRevisionRequest request, StreamObserver<Revision> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Revision) {
      requests.add(request);
      responseObserver.onNext(((Revision) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRevision, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Revision.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getResource(GetResourceRequest request, StreamObserver<Resource> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Resource) {
      requests.add(request);
      responseObserver.onNext(((Resource) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetResource, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Resource.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listResources(
      ListResourcesRequest request, StreamObserver<ListResourcesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListResourcesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListResourcesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListResources, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListResourcesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void exportDeploymentStatefile(
      ExportDeploymentStatefileRequest request, StreamObserver<Statefile> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Statefile) {
      requests.add(request);
      responseObserver.onNext(((Statefile) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ExportDeploymentStatefile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Statefile.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void exportRevisionStatefile(
      ExportRevisionStatefileRequest request, StreamObserver<Statefile> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Statefile) {
      requests.add(request);
      responseObserver.onNext(((Statefile) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ExportRevisionStatefile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Statefile.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importStatefile(
      ImportStatefileRequest request, StreamObserver<Statefile> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Statefile) {
      requests.add(request);
      responseObserver.onNext(((Statefile) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ImportStatefile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Statefile.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteStatefile(
      DeleteStatefileRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteStatefile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void lockDeployment(
      LockDeploymentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method LockDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void unlockDeployment(
      UnlockDeploymentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UnlockDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void exportLockInfo(
      ExportLockInfoRequest request, StreamObserver<LockInfo> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LockInfo) {
      requests.add(request);
      responseObserver.onNext(((LockInfo) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ExportLockInfo, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LockInfo.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createPreview(
      CreatePreviewRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreatePreview, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPreview(GetPreviewRequest request, StreamObserver<Preview> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Preview) {
      requests.add(request);
      responseObserver.onNext(((Preview) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPreview, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Preview.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPreviews(
      ListPreviewsRequest request, StreamObserver<ListPreviewsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPreviewsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPreviewsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPreviews, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPreviewsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deletePreview(
      DeletePreviewRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeletePreview, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void exportPreviewResult(
      ExportPreviewResultRequest request,
      StreamObserver<ExportPreviewResultResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ExportPreviewResultResponse) {
      requests.add(request);
      responseObserver.onNext(((ExportPreviewResultResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ExportPreviewResult, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ExportPreviewResultResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
