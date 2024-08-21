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

package com.google.cloud.apihub.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.apihub.v1.ApiHubGrpc.ApiHubImplBase;
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
public class MockApiHubImpl extends ApiHubImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockApiHubImpl() {
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
  public void createVersion(
      CreateVersionRequest request, StreamObserver<Version> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Version) {
      requests.add(request);
      responseObserver.onNext(((Version) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Version.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getVersion(GetVersionRequest request, StreamObserver<Version> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Version) {
      requests.add(request);
      responseObserver.onNext(((Version) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Version.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listVersions(
      ListVersionsRequest request, StreamObserver<ListVersionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListVersionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListVersionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListVersions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListVersionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateVersion(
      UpdateVersionRequest request, StreamObserver<Version> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Version) {
      requests.add(request);
      responseObserver.onNext(((Version) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Version.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteVersion(DeleteVersionRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSpec(CreateSpecRequest request, StreamObserver<Spec> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Spec) {
      requests.add(request);
      responseObserver.onNext(((Spec) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSpec, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Spec.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSpec(GetSpecRequest request, StreamObserver<Spec> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Spec) {
      requests.add(request);
      responseObserver.onNext(((Spec) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSpec, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Spec.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSpecContents(
      GetSpecContentsRequest request, StreamObserver<SpecContents> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SpecContents) {
      requests.add(request);
      responseObserver.onNext(((SpecContents) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSpecContents, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SpecContents.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSpecs(
      ListSpecsRequest request, StreamObserver<ListSpecsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSpecsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSpecsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSpecs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSpecsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSpec(UpdateSpecRequest request, StreamObserver<Spec> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Spec) {
      requests.add(request);
      responseObserver.onNext(((Spec) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSpec, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Spec.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSpec(DeleteSpecRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteSpec, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getApiOperation(
      GetApiOperationRequest request, StreamObserver<ApiOperation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApiOperation) {
      requests.add(request);
      responseObserver.onNext(((ApiOperation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetApiOperation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApiOperation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listApiOperations(
      ListApiOperationsRequest request,
      StreamObserver<ListApiOperationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListApiOperationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListApiOperationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListApiOperations, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListApiOperationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDefinition(
      GetDefinitionRequest request, StreamObserver<Definition> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Definition) {
      requests.add(request);
      responseObserver.onNext(((Definition) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDefinition, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Definition.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDeployment(
      CreateDeploymentRequest request, StreamObserver<Deployment> responseObserver) {
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
                  "Unrecognized response type %s for method CreateDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Deployment.class.getName(),
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
  public void updateDeployment(
      UpdateDeploymentRequest request, StreamObserver<Deployment> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Deployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDeployment(
      DeleteDeploymentRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAttribute(
      CreateAttributeRequest request, StreamObserver<Attribute> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Attribute) {
      requests.add(request);
      responseObserver.onNext(((Attribute) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAttribute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Attribute.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAttribute(
      GetAttributeRequest request, StreamObserver<Attribute> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Attribute) {
      requests.add(request);
      responseObserver.onNext(((Attribute) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAttribute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Attribute.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAttribute(
      UpdateAttributeRequest request, StreamObserver<Attribute> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Attribute) {
      requests.add(request);
      responseObserver.onNext(((Attribute) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateAttribute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Attribute.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAttribute(
      DeleteAttributeRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAttribute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAttributes(
      ListAttributesRequest request, StreamObserver<ListAttributesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAttributesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAttributesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAttributes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAttributesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchResources(
      SearchResourcesRequest request, StreamObserver<SearchResourcesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchResourcesResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchResourcesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchResources, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchResourcesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createExternalApi(
      CreateExternalApiRequest request, StreamObserver<ExternalApi> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ExternalApi) {
      requests.add(request);
      responseObserver.onNext(((ExternalApi) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateExternalApi, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ExternalApi.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getExternalApi(
      GetExternalApiRequest request, StreamObserver<ExternalApi> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ExternalApi) {
      requests.add(request);
      responseObserver.onNext(((ExternalApi) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetExternalApi, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ExternalApi.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateExternalApi(
      UpdateExternalApiRequest request, StreamObserver<ExternalApi> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ExternalApi) {
      requests.add(request);
      responseObserver.onNext(((ExternalApi) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateExternalApi, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ExternalApi.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteExternalApi(
      DeleteExternalApiRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteExternalApi, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listExternalApis(
      ListExternalApisRequest request, StreamObserver<ListExternalApisResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListExternalApisResponse) {
      requests.add(request);
      responseObserver.onNext(((ListExternalApisResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListExternalApis, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListExternalApisResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
