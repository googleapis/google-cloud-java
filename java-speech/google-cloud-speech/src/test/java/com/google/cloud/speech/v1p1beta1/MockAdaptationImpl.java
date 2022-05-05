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

package com.google.cloud.speech.v1p1beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.speech.v1p1beta1.AdaptationGrpc.AdaptationImplBase;
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
public class MockAdaptationImpl extends AdaptationImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAdaptationImpl() {
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
  public void createPhraseSet(
      CreatePhraseSetRequest request, StreamObserver<PhraseSet> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PhraseSet) {
      requests.add(request);
      responseObserver.onNext(((PhraseSet) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreatePhraseSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PhraseSet.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPhraseSet(
      GetPhraseSetRequest request, StreamObserver<PhraseSet> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PhraseSet) {
      requests.add(request);
      responseObserver.onNext(((PhraseSet) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPhraseSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PhraseSet.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPhraseSet(
      ListPhraseSetRequest request, StreamObserver<ListPhraseSetResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPhraseSetResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPhraseSetResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPhraseSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPhraseSetResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updatePhraseSet(
      UpdatePhraseSetRequest request, StreamObserver<PhraseSet> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PhraseSet) {
      requests.add(request);
      responseObserver.onNext(((PhraseSet) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdatePhraseSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PhraseSet.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deletePhraseSet(
      DeletePhraseSetRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeletePhraseSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCustomClass(
      CreateCustomClassRequest request, StreamObserver<CustomClass> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CustomClass) {
      requests.add(request);
      responseObserver.onNext(((CustomClass) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateCustomClass, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CustomClass.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCustomClass(
      GetCustomClassRequest request, StreamObserver<CustomClass> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CustomClass) {
      requests.add(request);
      responseObserver.onNext(((CustomClass) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCustomClass, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CustomClass.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCustomClasses(
      ListCustomClassesRequest request,
      StreamObserver<ListCustomClassesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCustomClassesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCustomClassesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCustomClasses, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCustomClassesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCustomClass(
      UpdateCustomClassRequest request, StreamObserver<CustomClass> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CustomClass) {
      requests.add(request);
      responseObserver.onNext(((CustomClass) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateCustomClass, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CustomClass.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteCustomClass(
      DeleteCustomClassRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteCustomClass, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
