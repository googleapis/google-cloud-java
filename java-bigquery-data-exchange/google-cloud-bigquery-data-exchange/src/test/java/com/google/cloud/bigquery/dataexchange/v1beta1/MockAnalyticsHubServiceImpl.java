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

package com.google.cloud.bigquery.dataexchange.v1beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubServiceGrpc.AnalyticsHubServiceImplBase;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
public class MockAnalyticsHubServiceImpl extends AnalyticsHubServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAnalyticsHubServiceImpl() {
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
  public void listDataExchanges(
      ListDataExchangesRequest request,
      StreamObserver<ListDataExchangesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDataExchangesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDataExchangesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDataExchanges, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDataExchangesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listOrgDataExchanges(
      ListOrgDataExchangesRequest request,
      StreamObserver<ListOrgDataExchangesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListOrgDataExchangesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListOrgDataExchangesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListOrgDataExchanges, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListOrgDataExchangesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDataExchange(
      GetDataExchangeRequest request, StreamObserver<DataExchange> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataExchange) {
      requests.add(request);
      responseObserver.onNext(((DataExchange) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDataExchange, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataExchange.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDataExchange(
      CreateDataExchangeRequest request, StreamObserver<DataExchange> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataExchange) {
      requests.add(request);
      responseObserver.onNext(((DataExchange) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDataExchange, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataExchange.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDataExchange(
      UpdateDataExchangeRequest request, StreamObserver<DataExchange> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataExchange) {
      requests.add(request);
      responseObserver.onNext(((DataExchange) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDataExchange, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataExchange.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDataExchange(
      DeleteDataExchangeRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteDataExchange, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listListings(
      ListListingsRequest request, StreamObserver<ListListingsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListListingsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListListingsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListListings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListListingsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getListing(GetListingRequest request, StreamObserver<Listing> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Listing) {
      requests.add(request);
      responseObserver.onNext(((Listing) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetListing, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Listing.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createListing(
      CreateListingRequest request, StreamObserver<Listing> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Listing) {
      requests.add(request);
      responseObserver.onNext(((Listing) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateListing, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Listing.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateListing(
      UpdateListingRequest request, StreamObserver<Listing> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Listing) {
      requests.add(request);
      responseObserver.onNext(((Listing) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateListing, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Listing.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteListing(DeleteListingRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteListing, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void subscribeListing(
      SubscribeListingRequest request, StreamObserver<SubscribeListingResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SubscribeListingResponse) {
      requests.add(request);
      responseObserver.onNext(((SubscribeListingResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SubscribeListing, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SubscribeListingResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getIamPolicy(GetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Policy) {
      requests.add(request);
      responseObserver.onNext(((Policy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetIamPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Policy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void setIamPolicy(SetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Policy) {
      requests.add(request);
      responseObserver.onNext(((Policy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SetIamPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Policy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void testIamPermissions(
      TestIamPermissionsRequest request,
      StreamObserver<TestIamPermissionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TestIamPermissionsResponse) {
      requests.add(request);
      responseObserver.onNext(((TestIamPermissionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method TestIamPermissions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TestIamPermissionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
