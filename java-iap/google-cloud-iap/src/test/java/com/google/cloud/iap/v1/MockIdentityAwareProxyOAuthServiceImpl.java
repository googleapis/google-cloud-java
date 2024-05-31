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

package com.google.cloud.iap.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.iap.v1.IdentityAwareProxyOAuthServiceGrpc.IdentityAwareProxyOAuthServiceImplBase;
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
public class MockIdentityAwareProxyOAuthServiceImpl extends IdentityAwareProxyOAuthServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockIdentityAwareProxyOAuthServiceImpl() {
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
  public void listBrands(
      ListBrandsRequest request, StreamObserver<ListBrandsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListBrandsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListBrandsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListBrands, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListBrandsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createBrand(CreateBrandRequest request, StreamObserver<Brand> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Brand) {
      requests.add(request);
      responseObserver.onNext(((Brand) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateBrand, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Brand.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getBrand(GetBrandRequest request, StreamObserver<Brand> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Brand) {
      requests.add(request);
      responseObserver.onNext(((Brand) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetBrand, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Brand.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createIdentityAwareProxyClient(
      CreateIdentityAwareProxyClientRequest request,
      StreamObserver<IdentityAwareProxyClient> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IdentityAwareProxyClient) {
      requests.add(request);
      responseObserver.onNext(((IdentityAwareProxyClient) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateIdentityAwareProxyClient, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  IdentityAwareProxyClient.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listIdentityAwareProxyClients(
      ListIdentityAwareProxyClientsRequest request,
      StreamObserver<ListIdentityAwareProxyClientsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListIdentityAwareProxyClientsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListIdentityAwareProxyClientsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListIdentityAwareProxyClients, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListIdentityAwareProxyClientsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getIdentityAwareProxyClient(
      GetIdentityAwareProxyClientRequest request,
      StreamObserver<IdentityAwareProxyClient> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IdentityAwareProxyClient) {
      requests.add(request);
      responseObserver.onNext(((IdentityAwareProxyClient) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetIdentityAwareProxyClient, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  IdentityAwareProxyClient.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void resetIdentityAwareProxyClientSecret(
      ResetIdentityAwareProxyClientSecretRequest request,
      StreamObserver<IdentityAwareProxyClient> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IdentityAwareProxyClient) {
      requests.add(request);
      responseObserver.onNext(((IdentityAwareProxyClient) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ResetIdentityAwareProxyClientSecret, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  IdentityAwareProxyClient.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteIdentityAwareProxyClient(
      DeleteIdentityAwareProxyClientRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteIdentityAwareProxyClient, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
