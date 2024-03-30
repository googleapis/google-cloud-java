/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.aiplatform.v1beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.aiplatform.v1beta1.VertexRagDataServiceGrpc.VertexRagDataServiceImplBase;
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
public class MockVertexRagDataServiceImpl extends VertexRagDataServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockVertexRagDataServiceImpl() {
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
  public void createRagCorpus(
      CreateRagCorpusRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateRagCorpus, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRagCorpus(
      GetRagCorpusRequest request, StreamObserver<RagCorpus> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RagCorpus) {
      requests.add(request);
      responseObserver.onNext(((RagCorpus) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRagCorpus, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RagCorpus.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRagCorpora(
      ListRagCorporaRequest request, StreamObserver<ListRagCorporaResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRagCorporaResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRagCorporaResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRagCorpora, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRagCorporaResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteRagCorpus(
      DeleteRagCorpusRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteRagCorpus, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void uploadRagFile(
      UploadRagFileRequest request, StreamObserver<UploadRagFileResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UploadRagFileResponse) {
      requests.add(request);
      responseObserver.onNext(((UploadRagFileResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UploadRagFile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UploadRagFileResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importRagFiles(
      ImportRagFilesRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ImportRagFiles, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRagFile(GetRagFileRequest request, StreamObserver<RagFile> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RagFile) {
      requests.add(request);
      responseObserver.onNext(((RagFile) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRagFile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RagFile.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRagFiles(
      ListRagFilesRequest request, StreamObserver<ListRagFilesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRagFilesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRagFilesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRagFiles, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRagFilesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteRagFile(
      DeleteRagFileRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteRagFile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
