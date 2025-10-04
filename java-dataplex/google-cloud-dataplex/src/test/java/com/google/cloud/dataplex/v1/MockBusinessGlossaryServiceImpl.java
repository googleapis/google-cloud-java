/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.dataplex.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.dataplex.v1.BusinessGlossaryServiceGrpc.BusinessGlossaryServiceImplBase;
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
public class MockBusinessGlossaryServiceImpl extends BusinessGlossaryServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockBusinessGlossaryServiceImpl() {
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
  public void createGlossary(
      CreateGlossaryRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateGlossary, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateGlossary(
      UpdateGlossaryRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateGlossary, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteGlossary(
      DeleteGlossaryRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteGlossary, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getGlossary(GetGlossaryRequest request, StreamObserver<Glossary> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Glossary) {
      requests.add(request);
      responseObserver.onNext(((Glossary) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetGlossary, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Glossary.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listGlossaries(
      ListGlossariesRequest request, StreamObserver<ListGlossariesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListGlossariesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListGlossariesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListGlossaries, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListGlossariesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createGlossaryCategory(
      CreateGlossaryCategoryRequest request, StreamObserver<GlossaryCategory> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GlossaryCategory) {
      requests.add(request);
      responseObserver.onNext(((GlossaryCategory) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateGlossaryCategory, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  GlossaryCategory.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateGlossaryCategory(
      UpdateGlossaryCategoryRequest request, StreamObserver<GlossaryCategory> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GlossaryCategory) {
      requests.add(request);
      responseObserver.onNext(((GlossaryCategory) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateGlossaryCategory, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  GlossaryCategory.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteGlossaryCategory(
      DeleteGlossaryCategoryRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteGlossaryCategory, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getGlossaryCategory(
      GetGlossaryCategoryRequest request, StreamObserver<GlossaryCategory> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GlossaryCategory) {
      requests.add(request);
      responseObserver.onNext(((GlossaryCategory) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetGlossaryCategory, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GlossaryCategory.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listGlossaryCategories(
      ListGlossaryCategoriesRequest request,
      StreamObserver<ListGlossaryCategoriesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListGlossaryCategoriesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListGlossaryCategoriesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListGlossaryCategories, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListGlossaryCategoriesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createGlossaryTerm(
      CreateGlossaryTermRequest request, StreamObserver<GlossaryTerm> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GlossaryTerm) {
      requests.add(request);
      responseObserver.onNext(((GlossaryTerm) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateGlossaryTerm, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GlossaryTerm.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateGlossaryTerm(
      UpdateGlossaryTermRequest request, StreamObserver<GlossaryTerm> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GlossaryTerm) {
      requests.add(request);
      responseObserver.onNext(((GlossaryTerm) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateGlossaryTerm, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GlossaryTerm.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteGlossaryTerm(
      DeleteGlossaryTermRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteGlossaryTerm, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getGlossaryTerm(
      GetGlossaryTermRequest request, StreamObserver<GlossaryTerm> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GlossaryTerm) {
      requests.add(request);
      responseObserver.onNext(((GlossaryTerm) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetGlossaryTerm, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GlossaryTerm.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listGlossaryTerms(
      ListGlossaryTermsRequest request,
      StreamObserver<ListGlossaryTermsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListGlossaryTermsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListGlossaryTermsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListGlossaryTerms, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListGlossaryTermsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
