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

package com.google.cloud.dialogflow.cx.v3beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.dialogflow.cx.v3beta1.PlaybooksGrpc.PlaybooksImplBase;
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
public class MockPlaybooksImpl extends PlaybooksImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockPlaybooksImpl() {
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
  public void createPlaybook(
      CreatePlaybookRequest request, StreamObserver<Playbook> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Playbook) {
      requests.add(request);
      responseObserver.onNext(((Playbook) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreatePlaybook, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Playbook.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deletePlaybook(
      DeletePlaybookRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeletePlaybook, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPlaybooks(
      ListPlaybooksRequest request, StreamObserver<ListPlaybooksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPlaybooksResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPlaybooksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPlaybooks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPlaybooksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPlaybook(GetPlaybookRequest request, StreamObserver<Playbook> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Playbook) {
      requests.add(request);
      responseObserver.onNext(((Playbook) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPlaybook, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Playbook.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updatePlaybook(
      UpdatePlaybookRequest request, StreamObserver<Playbook> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Playbook) {
      requests.add(request);
      responseObserver.onNext(((Playbook) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdatePlaybook, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Playbook.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createPlaybookVersion(
      CreatePlaybookVersionRequest request, StreamObserver<PlaybookVersion> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PlaybookVersion) {
      requests.add(request);
      responseObserver.onNext(((PlaybookVersion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreatePlaybookVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PlaybookVersion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPlaybookVersion(
      GetPlaybookVersionRequest request, StreamObserver<PlaybookVersion> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PlaybookVersion) {
      requests.add(request);
      responseObserver.onNext(((PlaybookVersion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPlaybookVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PlaybookVersion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPlaybookVersions(
      ListPlaybookVersionsRequest request,
      StreamObserver<ListPlaybookVersionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPlaybookVersionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPlaybookVersionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPlaybookVersions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPlaybookVersionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deletePlaybookVersion(
      DeletePlaybookVersionRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeletePlaybookVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
