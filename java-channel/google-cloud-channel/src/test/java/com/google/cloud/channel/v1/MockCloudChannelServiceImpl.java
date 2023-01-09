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

package com.google.cloud.channel.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.channel.v1.CloudChannelServiceGrpc.CloudChannelServiceImplBase;
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
public class MockCloudChannelServiceImpl extends CloudChannelServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockCloudChannelServiceImpl() {
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
  public void listCustomers(
      ListCustomersRequest request, StreamObserver<ListCustomersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCustomersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCustomersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCustomers, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCustomersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCustomer(GetCustomerRequest request, StreamObserver<Customer> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Customer) {
      requests.add(request);
      responseObserver.onNext(((Customer) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCustomer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Customer.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void checkCloudIdentityAccountsExist(
      CheckCloudIdentityAccountsExistRequest request,
      StreamObserver<CheckCloudIdentityAccountsExistResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CheckCloudIdentityAccountsExistResponse) {
      requests.add(request);
      responseObserver.onNext(((CheckCloudIdentityAccountsExistResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CheckCloudIdentityAccountsExist, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CheckCloudIdentityAccountsExistResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCustomer(
      CreateCustomerRequest request, StreamObserver<Customer> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Customer) {
      requests.add(request);
      responseObserver.onNext(((Customer) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateCustomer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Customer.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCustomer(
      UpdateCustomerRequest request, StreamObserver<Customer> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Customer) {
      requests.add(request);
      responseObserver.onNext(((Customer) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateCustomer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Customer.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteCustomer(
      DeleteCustomerRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteCustomer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importCustomer(
      ImportCustomerRequest request, StreamObserver<Customer> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Customer) {
      requests.add(request);
      responseObserver.onNext(((Customer) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ImportCustomer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Customer.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void provisionCloudIdentity(
      ProvisionCloudIdentityRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ProvisionCloudIdentity, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listEntitlements(
      ListEntitlementsRequest request, StreamObserver<ListEntitlementsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEntitlementsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEntitlementsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEntitlements, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEntitlementsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTransferableSkus(
      ListTransferableSkusRequest request,
      StreamObserver<ListTransferableSkusResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTransferableSkusResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTransferableSkusResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTransferableSkus, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTransferableSkusResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTransferableOffers(
      ListTransferableOffersRequest request,
      StreamObserver<ListTransferableOffersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTransferableOffersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTransferableOffersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTransferableOffers, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTransferableOffersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEntitlement(
      GetEntitlementRequest request, StreamObserver<Entitlement> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Entitlement) {
      requests.add(request);
      responseObserver.onNext(((Entitlement) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEntitlement, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Entitlement.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createEntitlement(
      CreateEntitlementRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateEntitlement, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void changeParameters(
      ChangeParametersRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ChangeParameters, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void changeRenewalSettings(
      ChangeRenewalSettingsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ChangeRenewalSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void changeOffer(ChangeOfferRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ChangeOffer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void startPaidService(
      StartPaidServiceRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method StartPaidService, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void suspendEntitlement(
      SuspendEntitlementRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method SuspendEntitlement, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void cancelEntitlement(
      CancelEntitlementRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CancelEntitlement, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void activateEntitlement(
      ActivateEntitlementRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ActivateEntitlement, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void transferEntitlements(
      TransferEntitlementsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method TransferEntitlements, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void transferEntitlementsToGoogle(
      TransferEntitlementsToGoogleRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method TransferEntitlementsToGoogle, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listChannelPartnerLinks(
      ListChannelPartnerLinksRequest request,
      StreamObserver<ListChannelPartnerLinksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListChannelPartnerLinksResponse) {
      requests.add(request);
      responseObserver.onNext(((ListChannelPartnerLinksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListChannelPartnerLinks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListChannelPartnerLinksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getChannelPartnerLink(
      GetChannelPartnerLinkRequest request, StreamObserver<ChannelPartnerLink> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ChannelPartnerLink) {
      requests.add(request);
      responseObserver.onNext(((ChannelPartnerLink) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetChannelPartnerLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ChannelPartnerLink.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createChannelPartnerLink(
      CreateChannelPartnerLinkRequest request,
      StreamObserver<ChannelPartnerLink> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ChannelPartnerLink) {
      requests.add(request);
      responseObserver.onNext(((ChannelPartnerLink) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateChannelPartnerLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ChannelPartnerLink.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateChannelPartnerLink(
      UpdateChannelPartnerLinkRequest request,
      StreamObserver<ChannelPartnerLink> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ChannelPartnerLink) {
      requests.add(request);
      responseObserver.onNext(((ChannelPartnerLink) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateChannelPartnerLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ChannelPartnerLink.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCustomerRepricingConfig(
      GetCustomerRepricingConfigRequest request,
      StreamObserver<CustomerRepricingConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CustomerRepricingConfig) {
      requests.add(request);
      responseObserver.onNext(((CustomerRepricingConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCustomerRepricingConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CustomerRepricingConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCustomerRepricingConfigs(
      ListCustomerRepricingConfigsRequest request,
      StreamObserver<ListCustomerRepricingConfigsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCustomerRepricingConfigsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCustomerRepricingConfigsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCustomerRepricingConfigs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCustomerRepricingConfigsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCustomerRepricingConfig(
      CreateCustomerRepricingConfigRequest request,
      StreamObserver<CustomerRepricingConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CustomerRepricingConfig) {
      requests.add(request);
      responseObserver.onNext(((CustomerRepricingConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateCustomerRepricingConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CustomerRepricingConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCustomerRepricingConfig(
      UpdateCustomerRepricingConfigRequest request,
      StreamObserver<CustomerRepricingConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CustomerRepricingConfig) {
      requests.add(request);
      responseObserver.onNext(((CustomerRepricingConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateCustomerRepricingConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CustomerRepricingConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteCustomerRepricingConfig(
      DeleteCustomerRepricingConfigRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteCustomerRepricingConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getChannelPartnerRepricingConfig(
      GetChannelPartnerRepricingConfigRequest request,
      StreamObserver<ChannelPartnerRepricingConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ChannelPartnerRepricingConfig) {
      requests.add(request);
      responseObserver.onNext(((ChannelPartnerRepricingConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetChannelPartnerRepricingConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ChannelPartnerRepricingConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listChannelPartnerRepricingConfigs(
      ListChannelPartnerRepricingConfigsRequest request,
      StreamObserver<ListChannelPartnerRepricingConfigsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListChannelPartnerRepricingConfigsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListChannelPartnerRepricingConfigsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListChannelPartnerRepricingConfigs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListChannelPartnerRepricingConfigsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createChannelPartnerRepricingConfig(
      CreateChannelPartnerRepricingConfigRequest request,
      StreamObserver<ChannelPartnerRepricingConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ChannelPartnerRepricingConfig) {
      requests.add(request);
      responseObserver.onNext(((ChannelPartnerRepricingConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateChannelPartnerRepricingConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ChannelPartnerRepricingConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateChannelPartnerRepricingConfig(
      UpdateChannelPartnerRepricingConfigRequest request,
      StreamObserver<ChannelPartnerRepricingConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ChannelPartnerRepricingConfig) {
      requests.add(request);
      responseObserver.onNext(((ChannelPartnerRepricingConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateChannelPartnerRepricingConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ChannelPartnerRepricingConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteChannelPartnerRepricingConfig(
      DeleteChannelPartnerRepricingConfigRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteChannelPartnerRepricingConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void lookupOffer(LookupOfferRequest request, StreamObserver<Offer> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Offer) {
      requests.add(request);
      responseObserver.onNext(((Offer) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method LookupOffer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Offer.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listProducts(
      ListProductsRequest request, StreamObserver<ListProductsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListProductsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListProductsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListProducts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListProductsResponse.class.getName(),
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
  public void listOffers(
      ListOffersRequest request, StreamObserver<ListOffersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListOffersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListOffersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListOffers, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListOffersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPurchasableSkus(
      ListPurchasableSkusRequest request,
      StreamObserver<ListPurchasableSkusResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPurchasableSkusResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPurchasableSkusResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPurchasableSkus, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPurchasableSkusResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPurchasableOffers(
      ListPurchasableOffersRequest request,
      StreamObserver<ListPurchasableOffersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPurchasableOffersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPurchasableOffersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPurchasableOffers, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPurchasableOffersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void registerSubscriber(
      RegisterSubscriberRequest request,
      StreamObserver<RegisterSubscriberResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RegisterSubscriberResponse) {
      requests.add(request);
      responseObserver.onNext(((RegisterSubscriberResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RegisterSubscriber, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RegisterSubscriberResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void unregisterSubscriber(
      UnregisterSubscriberRequest request,
      StreamObserver<UnregisterSubscriberResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UnregisterSubscriberResponse) {
      requests.add(request);
      responseObserver.onNext(((UnregisterSubscriberResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UnregisterSubscriber, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UnregisterSubscriberResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSubscribers(
      ListSubscribersRequest request, StreamObserver<ListSubscribersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSubscribersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSubscribersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSubscribers, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSubscribersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
