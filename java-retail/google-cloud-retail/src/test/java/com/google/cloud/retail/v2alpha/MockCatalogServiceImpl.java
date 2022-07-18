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

package com.google.cloud.retail.v2alpha;

import com.google.api.core.BetaApi;
import com.google.cloud.retail.v2alpha.CatalogServiceGrpc.CatalogServiceImplBase;
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
public class MockCatalogServiceImpl extends CatalogServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockCatalogServiceImpl() {
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
  public void listCatalogs(
      ListCatalogsRequest request, StreamObserver<ListCatalogsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCatalogsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCatalogsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCatalogs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCatalogsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCatalog(
      UpdateCatalogRequest request, StreamObserver<Catalog> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Catalog) {
      requests.add(request);
      responseObserver.onNext(((Catalog) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateCatalog, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Catalog.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void setDefaultBranch(
      SetDefaultBranchRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method SetDefaultBranch, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDefaultBranch(
      GetDefaultBranchRequest request, StreamObserver<GetDefaultBranchResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GetDefaultBranchResponse) {
      requests.add(request);
      responseObserver.onNext(((GetDefaultBranchResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDefaultBranch, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GetDefaultBranchResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCompletionConfig(
      GetCompletionConfigRequest request, StreamObserver<CompletionConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CompletionConfig) {
      requests.add(request);
      responseObserver.onNext(((CompletionConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCompletionConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CompletionConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCompletionConfig(
      UpdateCompletionConfigRequest request, StreamObserver<CompletionConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CompletionConfig) {
      requests.add(request);
      responseObserver.onNext(((CompletionConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateCompletionConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CompletionConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAttributesConfig(
      GetAttributesConfigRequest request, StreamObserver<AttributesConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AttributesConfig) {
      requests.add(request);
      responseObserver.onNext(((AttributesConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAttributesConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AttributesConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAttributesConfig(
      UpdateAttributesConfigRequest request, StreamObserver<AttributesConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AttributesConfig) {
      requests.add(request);
      responseObserver.onNext(((AttributesConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateAttributesConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AttributesConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void addCatalogAttribute(
      AddCatalogAttributeRequest request, StreamObserver<AttributesConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AttributesConfig) {
      requests.add(request);
      responseObserver.onNext(((AttributesConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AddCatalogAttribute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AttributesConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void removeCatalogAttribute(
      RemoveCatalogAttributeRequest request, StreamObserver<AttributesConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AttributesConfig) {
      requests.add(request);
      responseObserver.onNext(((AttributesConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RemoveCatalogAttribute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AttributesConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void replaceCatalogAttribute(
      ReplaceCatalogAttributeRequest request, StreamObserver<AttributesConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AttributesConfig) {
      requests.add(request);
      responseObserver.onNext(((AttributesConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ReplaceCatalogAttribute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AttributesConfig.class.getName(),
                  Exception.class.getName())));
    }
  }
}
