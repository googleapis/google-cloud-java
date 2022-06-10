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

package com.google.cloud.apigeeregistry.v1;

import com.google.api.HttpBody;
import com.google.api.core.BetaApi;
import com.google.cloud.apigeeregistry.v1.RegistryGrpc.RegistryImplBase;
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
public class MockRegistryImpl extends RegistryImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockRegistryImpl() {
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
  public void listApis(ListApisRequest request, StreamObserver<ListApisResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListApisResponse) {
      requests.add(request);
      responseObserver.onNext(((ListApisResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListApis, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListApisResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getApi(GetApiRequest request, StreamObserver<Api> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Api) {
      requests.add(request);
      responseObserver.onNext(((Api) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetApi, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Api.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createApi(CreateApiRequest request, StreamObserver<Api> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Api) {
      requests.add(request);
      responseObserver.onNext(((Api) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateApi, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Api.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateApi(UpdateApiRequest request, StreamObserver<Api> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Api) {
      requests.add(request);
      responseObserver.onNext(((Api) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateApi, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Api.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteApi(DeleteApiRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteApi, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listApiVersions(
      ListApiVersionsRequest request, StreamObserver<ListApiVersionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListApiVersionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListApiVersionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListApiVersions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListApiVersionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getApiVersion(
      GetApiVersionRequest request, StreamObserver<ApiVersion> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApiVersion) {
      requests.add(request);
      responseObserver.onNext(((ApiVersion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetApiVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApiVersion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createApiVersion(
      CreateApiVersionRequest request, StreamObserver<ApiVersion> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApiVersion) {
      requests.add(request);
      responseObserver.onNext(((ApiVersion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateApiVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApiVersion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateApiVersion(
      UpdateApiVersionRequest request, StreamObserver<ApiVersion> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApiVersion) {
      requests.add(request);
      responseObserver.onNext(((ApiVersion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateApiVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApiVersion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteApiVersion(
      DeleteApiVersionRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteApiVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listApiSpecs(
      ListApiSpecsRequest request, StreamObserver<ListApiSpecsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListApiSpecsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListApiSpecsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListApiSpecs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListApiSpecsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getApiSpec(GetApiSpecRequest request, StreamObserver<ApiSpec> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApiSpec) {
      requests.add(request);
      responseObserver.onNext(((ApiSpec) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetApiSpec, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApiSpec.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getApiSpecContents(
      GetApiSpecContentsRequest request, StreamObserver<HttpBody> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HttpBody) {
      requests.add(request);
      responseObserver.onNext(((HttpBody) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetApiSpecContents, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HttpBody.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createApiSpec(
      CreateApiSpecRequest request, StreamObserver<ApiSpec> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApiSpec) {
      requests.add(request);
      responseObserver.onNext(((ApiSpec) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateApiSpec, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApiSpec.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateApiSpec(
      UpdateApiSpecRequest request, StreamObserver<ApiSpec> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApiSpec) {
      requests.add(request);
      responseObserver.onNext(((ApiSpec) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateApiSpec, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApiSpec.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteApiSpec(DeleteApiSpecRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteApiSpec, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void tagApiSpecRevision(
      TagApiSpecRevisionRequest request, StreamObserver<ApiSpec> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApiSpec) {
      requests.add(request);
      responseObserver.onNext(((ApiSpec) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method TagApiSpecRevision, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApiSpec.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listApiSpecRevisions(
      ListApiSpecRevisionsRequest request,
      StreamObserver<ListApiSpecRevisionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListApiSpecRevisionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListApiSpecRevisionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListApiSpecRevisions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListApiSpecRevisionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void rollbackApiSpec(
      RollbackApiSpecRequest request, StreamObserver<ApiSpec> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApiSpec) {
      requests.add(request);
      responseObserver.onNext(((ApiSpec) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RollbackApiSpec, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApiSpec.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteApiSpecRevision(
      DeleteApiSpecRevisionRequest request, StreamObserver<ApiSpec> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApiSpec) {
      requests.add(request);
      responseObserver.onNext(((ApiSpec) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteApiSpecRevision, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApiSpec.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listApiDeployments(
      ListApiDeploymentsRequest request,
      StreamObserver<ListApiDeploymentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListApiDeploymentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListApiDeploymentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListApiDeployments, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListApiDeploymentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getApiDeployment(
      GetApiDeploymentRequest request, StreamObserver<ApiDeployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApiDeployment) {
      requests.add(request);
      responseObserver.onNext(((ApiDeployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetApiDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApiDeployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createApiDeployment(
      CreateApiDeploymentRequest request, StreamObserver<ApiDeployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApiDeployment) {
      requests.add(request);
      responseObserver.onNext(((ApiDeployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateApiDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApiDeployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateApiDeployment(
      UpdateApiDeploymentRequest request, StreamObserver<ApiDeployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApiDeployment) {
      requests.add(request);
      responseObserver.onNext(((ApiDeployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateApiDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApiDeployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteApiDeployment(
      DeleteApiDeploymentRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteApiDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void tagApiDeploymentRevision(
      TagApiDeploymentRevisionRequest request, StreamObserver<ApiDeployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApiDeployment) {
      requests.add(request);
      responseObserver.onNext(((ApiDeployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method TagApiDeploymentRevision, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApiDeployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listApiDeploymentRevisions(
      ListApiDeploymentRevisionsRequest request,
      StreamObserver<ListApiDeploymentRevisionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListApiDeploymentRevisionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListApiDeploymentRevisionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListApiDeploymentRevisions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListApiDeploymentRevisionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void rollbackApiDeployment(
      RollbackApiDeploymentRequest request, StreamObserver<ApiDeployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApiDeployment) {
      requests.add(request);
      responseObserver.onNext(((ApiDeployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RollbackApiDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApiDeployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteApiDeploymentRevision(
      DeleteApiDeploymentRevisionRequest request, StreamObserver<ApiDeployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApiDeployment) {
      requests.add(request);
      responseObserver.onNext(((ApiDeployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteApiDeploymentRevision, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApiDeployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listArtifacts(
      ListArtifactsRequest request, StreamObserver<ListArtifactsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListArtifactsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListArtifactsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListArtifacts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListArtifactsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getArtifact(GetArtifactRequest request, StreamObserver<Artifact> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Artifact) {
      requests.add(request);
      responseObserver.onNext(((Artifact) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetArtifact, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Artifact.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getArtifactContents(
      GetArtifactContentsRequest request, StreamObserver<HttpBody> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HttpBody) {
      requests.add(request);
      responseObserver.onNext(((HttpBody) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetArtifactContents, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HttpBody.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createArtifact(
      CreateArtifactRequest request, StreamObserver<Artifact> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Artifact) {
      requests.add(request);
      responseObserver.onNext(((Artifact) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateArtifact, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Artifact.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void replaceArtifact(
      ReplaceArtifactRequest request, StreamObserver<Artifact> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Artifact) {
      requests.add(request);
      responseObserver.onNext(((Artifact) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ReplaceArtifact, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Artifact.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteArtifact(
      DeleteArtifactRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteArtifact, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
