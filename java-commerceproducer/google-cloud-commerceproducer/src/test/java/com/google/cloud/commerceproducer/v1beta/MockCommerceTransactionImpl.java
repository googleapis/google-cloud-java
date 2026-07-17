/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.commerceproducer.v1beta;

import com.google.api.core.BetaApi;
import com.google.cloud.commerceproducer.v1beta.CommerceTransactionGrpc.CommerceTransactionImplBase;
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
public class MockCommerceTransactionImpl extends CommerceTransactionImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockCommerceTransactionImpl() {
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
  public void listServices(
      ListServicesRequest request, StreamObserver<ListServicesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListServicesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListServicesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListServices, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListServicesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getService(GetServiceRequest request, StreamObserver<Service> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Service) {
      requests.add(request);
      responseObserver.onNext(((Service) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetService, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Service.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPrivateOffers(
      ListPrivateOffersRequest request,
      StreamObserver<ListPrivateOffersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPrivateOffersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPrivateOffersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPrivateOffers, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPrivateOffersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPrivateOffer(
      GetPrivateOfferRequest request, StreamObserver<PrivateOffer> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PrivateOffer) {
      requests.add(request);
      responseObserver.onNext(((PrivateOffer) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPrivateOffer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PrivateOffer.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createPrivateOffer(
      CreatePrivateOfferRequest request, StreamObserver<PrivateOffer> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PrivateOffer) {
      requests.add(request);
      responseObserver.onNext(((PrivateOffer) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreatePrivateOffer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PrivateOffer.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updatePrivateOffer(
      UpdatePrivateOfferRequest request, StreamObserver<PrivateOffer> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PrivateOffer) {
      requests.add(request);
      responseObserver.onNext(((PrivateOffer) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdatePrivateOffer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PrivateOffer.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void publishPrivateOffer(
      PublishPrivateOfferRequest request, StreamObserver<PrivateOffer> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PrivateOffer) {
      requests.add(request);
      responseObserver.onNext(((PrivateOffer) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method PublishPrivateOffer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PrivateOffer.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void cancelPrivateOffer(
      CancelPrivateOfferRequest request, StreamObserver<PrivateOffer> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PrivateOffer) {
      requests.add(request);
      responseObserver.onNext(((PrivateOffer) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CancelPrivateOffer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PrivateOffer.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deletePrivateOffer(
      DeletePrivateOfferRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeletePrivateOffer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPrivateOfferDocuments(
      ListPrivateOfferDocumentsRequest request,
      StreamObserver<ListPrivateOfferDocumentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPrivateOfferDocumentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPrivateOfferDocumentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPrivateOfferDocuments, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPrivateOfferDocumentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPrivateOfferDocument(
      GetPrivateOfferDocumentRequest request,
      StreamObserver<PrivateOfferDocument> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PrivateOfferDocument) {
      requests.add(request);
      responseObserver.onNext(((PrivateOfferDocument) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPrivateOfferDocument, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  PrivateOfferDocument.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createPrivateOfferDocument(
      CreatePrivateOfferDocumentRequest request,
      StreamObserver<PrivateOfferDocument> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PrivateOfferDocument) {
      requests.add(request);
      responseObserver.onNext(((PrivateOfferDocument) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreatePrivateOfferDocument, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PrivateOfferDocument.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updatePrivateOfferDocument(
      UpdatePrivateOfferDocumentRequest request,
      StreamObserver<PrivateOfferDocument> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PrivateOfferDocument) {
      requests.add(request);
      responseObserver.onNext(((PrivateOfferDocument) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdatePrivateOfferDocument, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PrivateOfferDocument.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deletePrivateOfferDocument(
      DeletePrivateOfferDocumentRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeletePrivateOfferDocument, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listStandardOffers(
      ListStandardOffersRequest request,
      StreamObserver<ListStandardOffersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListStandardOffersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListStandardOffersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListStandardOffers, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListStandardOffersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getStandardOffer(
      GetStandardOfferRequest request, StreamObserver<StandardOffer> responseObserver) {
    Object response = responses.poll();
    if (response instanceof StandardOffer) {
      requests.add(request);
      responseObserver.onNext(((StandardOffer) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetStandardOffer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  StandardOffer.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSku(GetSkuRequest request, StreamObserver<Sku> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Sku) {
      requests.add(request);
      responseObserver.onNext(((Sku) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSku, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Sku.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSkus(ListSkusRequest request, StreamObserver<ListSkusResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSkusResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSkusResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSkus, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSkusResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSkuGroup(GetSkuGroupRequest request, StreamObserver<SkuGroup> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SkuGroup) {
      requests.add(request);
      responseObserver.onNext(((SkuGroup) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSkuGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SkuGroup.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSkuGroups(
      ListSkuGroupsRequest request, StreamObserver<ListSkuGroupsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSkuGroupsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSkuGroupsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSkuGroups, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSkuGroupsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
