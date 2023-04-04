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

package com.google.cloud.contentwarehouse.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.contentwarehouse.v1.SynonymSetServiceGrpc.SynonymSetServiceImplBase;
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
public class MockSynonymSetServiceImpl extends SynonymSetServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockSynonymSetServiceImpl() {
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
  public void createSynonymSet(
      CreateSynonymSetRequest request, StreamObserver<SynonymSet> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SynonymSet) {
      requests.add(request);
      responseObserver.onNext(((SynonymSet) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSynonymSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SynonymSet.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSynonymSet(
      GetSynonymSetRequest request, StreamObserver<SynonymSet> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SynonymSet) {
      requests.add(request);
      responseObserver.onNext(((SynonymSet) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSynonymSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SynonymSet.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSynonymSet(
      UpdateSynonymSetRequest request, StreamObserver<SynonymSet> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SynonymSet) {
      requests.add(request);
      responseObserver.onNext(((SynonymSet) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSynonymSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SynonymSet.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSynonymSet(
      DeleteSynonymSetRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteSynonymSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSynonymSets(
      ListSynonymSetsRequest request, StreamObserver<ListSynonymSetsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSynonymSetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSynonymSetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSynonymSets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSynonymSetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
