/*
 * Copyright 2023 Google LLC
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

package com.google.analytics.admin.v1alpha;

import com.google.analytics.admin.v1alpha.AnalyticsAdminServiceGrpc.AnalyticsAdminServiceImplBase;
import com.google.api.core.BetaApi;
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
public class MockAnalyticsAdminServiceImpl extends AnalyticsAdminServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAnalyticsAdminServiceImpl() {
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
  public void getAccount(GetAccountRequest request, StreamObserver<Account> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Account) {
      requests.add(request);
      responseObserver.onNext(((Account) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAccount, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Account.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAccounts(
      ListAccountsRequest request, StreamObserver<ListAccountsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAccountsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAccountsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAccounts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAccountsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAccount(DeleteAccountRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAccount, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAccount(
      UpdateAccountRequest request, StreamObserver<Account> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Account) {
      requests.add(request);
      responseObserver.onNext(((Account) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateAccount, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Account.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void provisionAccountTicket(
      ProvisionAccountTicketRequest request,
      StreamObserver<ProvisionAccountTicketResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ProvisionAccountTicketResponse) {
      requests.add(request);
      responseObserver.onNext(((ProvisionAccountTicketResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ProvisionAccountTicket, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ProvisionAccountTicketResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAccountSummaries(
      ListAccountSummariesRequest request,
      StreamObserver<ListAccountSummariesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAccountSummariesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAccountSummariesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAccountSummaries, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAccountSummariesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getProperty(GetPropertyRequest request, StreamObserver<Property> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Property) {
      requests.add(request);
      responseObserver.onNext(((Property) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetProperty, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Property.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listProperties(
      ListPropertiesRequest request, StreamObserver<ListPropertiesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPropertiesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPropertiesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListProperties, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPropertiesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createProperty(
      CreatePropertyRequest request, StreamObserver<Property> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Property) {
      requests.add(request);
      responseObserver.onNext(((Property) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateProperty, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Property.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteProperty(
      DeletePropertyRequest request, StreamObserver<Property> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Property) {
      requests.add(request);
      responseObserver.onNext(((Property) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteProperty, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Property.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateProperty(
      UpdatePropertyRequest request, StreamObserver<Property> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Property) {
      requests.add(request);
      responseObserver.onNext(((Property) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateProperty, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Property.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createFirebaseLink(
      CreateFirebaseLinkRequest request, StreamObserver<FirebaseLink> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FirebaseLink) {
      requests.add(request);
      responseObserver.onNext(((FirebaseLink) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateFirebaseLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FirebaseLink.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteFirebaseLink(
      DeleteFirebaseLinkRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteFirebaseLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFirebaseLinks(
      ListFirebaseLinksRequest request,
      StreamObserver<ListFirebaseLinksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFirebaseLinksResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFirebaseLinksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFirebaseLinks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFirebaseLinksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getGlobalSiteTag(
      GetGlobalSiteTagRequest request, StreamObserver<GlobalSiteTag> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GlobalSiteTag) {
      requests.add(request);
      responseObserver.onNext(((GlobalSiteTag) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetGlobalSiteTag, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GlobalSiteTag.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createGoogleAdsLink(
      CreateGoogleAdsLinkRequest request, StreamObserver<GoogleAdsLink> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GoogleAdsLink) {
      requests.add(request);
      responseObserver.onNext(((GoogleAdsLink) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateGoogleAdsLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GoogleAdsLink.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateGoogleAdsLink(
      UpdateGoogleAdsLinkRequest request, StreamObserver<GoogleAdsLink> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GoogleAdsLink) {
      requests.add(request);
      responseObserver.onNext(((GoogleAdsLink) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateGoogleAdsLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GoogleAdsLink.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteGoogleAdsLink(
      DeleteGoogleAdsLinkRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteGoogleAdsLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listGoogleAdsLinks(
      ListGoogleAdsLinksRequest request,
      StreamObserver<ListGoogleAdsLinksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListGoogleAdsLinksResponse) {
      requests.add(request);
      responseObserver.onNext(((ListGoogleAdsLinksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListGoogleAdsLinks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListGoogleAdsLinksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDataSharingSettings(
      GetDataSharingSettingsRequest request, StreamObserver<DataSharingSettings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataSharingSettings) {
      requests.add(request);
      responseObserver.onNext(((DataSharingSettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDataSharingSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataSharingSettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMeasurementProtocolSecret(
      GetMeasurementProtocolSecretRequest request,
      StreamObserver<MeasurementProtocolSecret> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MeasurementProtocolSecret) {
      requests.add(request);
      responseObserver.onNext(((MeasurementProtocolSecret) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMeasurementProtocolSecret, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MeasurementProtocolSecret.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMeasurementProtocolSecrets(
      ListMeasurementProtocolSecretsRequest request,
      StreamObserver<ListMeasurementProtocolSecretsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMeasurementProtocolSecretsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMeasurementProtocolSecretsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMeasurementProtocolSecrets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMeasurementProtocolSecretsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createMeasurementProtocolSecret(
      CreateMeasurementProtocolSecretRequest request,
      StreamObserver<MeasurementProtocolSecret> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MeasurementProtocolSecret) {
      requests.add(request);
      responseObserver.onNext(((MeasurementProtocolSecret) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateMeasurementProtocolSecret, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MeasurementProtocolSecret.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteMeasurementProtocolSecret(
      DeleteMeasurementProtocolSecretRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteMeasurementProtocolSecret, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateMeasurementProtocolSecret(
      UpdateMeasurementProtocolSecretRequest request,
      StreamObserver<MeasurementProtocolSecret> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MeasurementProtocolSecret) {
      requests.add(request);
      responseObserver.onNext(((MeasurementProtocolSecret) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateMeasurementProtocolSecret, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MeasurementProtocolSecret.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void acknowledgeUserDataCollection(
      AcknowledgeUserDataCollectionRequest request,
      StreamObserver<AcknowledgeUserDataCollectionResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AcknowledgeUserDataCollectionResponse) {
      requests.add(request);
      responseObserver.onNext(((AcknowledgeUserDataCollectionResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AcknowledgeUserDataCollection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AcknowledgeUserDataCollectionResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSKAdNetworkConversionValueSchema(
      GetSKAdNetworkConversionValueSchemaRequest request,
      StreamObserver<SKAdNetworkConversionValueSchema> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SKAdNetworkConversionValueSchema) {
      requests.add(request);
      responseObserver.onNext(((SKAdNetworkConversionValueSchema) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSKAdNetworkConversionValueSchema, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SKAdNetworkConversionValueSchema.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSKAdNetworkConversionValueSchema(
      CreateSKAdNetworkConversionValueSchemaRequest request,
      StreamObserver<SKAdNetworkConversionValueSchema> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SKAdNetworkConversionValueSchema) {
      requests.add(request);
      responseObserver.onNext(((SKAdNetworkConversionValueSchema) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSKAdNetworkConversionValueSchema, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SKAdNetworkConversionValueSchema.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSKAdNetworkConversionValueSchema(
      DeleteSKAdNetworkConversionValueSchemaRequest request,
      StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteSKAdNetworkConversionValueSchema, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSKAdNetworkConversionValueSchema(
      UpdateSKAdNetworkConversionValueSchemaRequest request,
      StreamObserver<SKAdNetworkConversionValueSchema> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SKAdNetworkConversionValueSchema) {
      requests.add(request);
      responseObserver.onNext(((SKAdNetworkConversionValueSchema) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSKAdNetworkConversionValueSchema, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SKAdNetworkConversionValueSchema.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSKAdNetworkConversionValueSchemas(
      ListSKAdNetworkConversionValueSchemasRequest request,
      StreamObserver<ListSKAdNetworkConversionValueSchemasResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSKAdNetworkConversionValueSchemasResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSKAdNetworkConversionValueSchemasResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSKAdNetworkConversionValueSchemas, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSKAdNetworkConversionValueSchemasResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchChangeHistoryEvents(
      SearchChangeHistoryEventsRequest request,
      StreamObserver<SearchChangeHistoryEventsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchChangeHistoryEventsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchChangeHistoryEventsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchChangeHistoryEvents, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchChangeHistoryEventsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getGoogleSignalsSettings(
      GetGoogleSignalsSettingsRequest request,
      StreamObserver<GoogleSignalsSettings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GoogleSignalsSettings) {
      requests.add(request);
      responseObserver.onNext(((GoogleSignalsSettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetGoogleSignalsSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GoogleSignalsSettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateGoogleSignalsSettings(
      UpdateGoogleSignalsSettingsRequest request,
      StreamObserver<GoogleSignalsSettings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GoogleSignalsSettings) {
      requests.add(request);
      responseObserver.onNext(((GoogleSignalsSettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateGoogleSignalsSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GoogleSignalsSettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createConversionEvent(
      CreateConversionEventRequest request, StreamObserver<ConversionEvent> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ConversionEvent) {
      requests.add(request);
      responseObserver.onNext(((ConversionEvent) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateConversionEvent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ConversionEvent.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateConversionEvent(
      UpdateConversionEventRequest request, StreamObserver<ConversionEvent> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ConversionEvent) {
      requests.add(request);
      responseObserver.onNext(((ConversionEvent) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateConversionEvent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ConversionEvent.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getConversionEvent(
      GetConversionEventRequest request, StreamObserver<ConversionEvent> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ConversionEvent) {
      requests.add(request);
      responseObserver.onNext(((ConversionEvent) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetConversionEvent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ConversionEvent.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteConversionEvent(
      DeleteConversionEventRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteConversionEvent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listConversionEvents(
      ListConversionEventsRequest request,
      StreamObserver<ListConversionEventsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListConversionEventsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListConversionEventsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListConversionEvents, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListConversionEventsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDisplayVideo360AdvertiserLink(
      GetDisplayVideo360AdvertiserLinkRequest request,
      StreamObserver<DisplayVideo360AdvertiserLink> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DisplayVideo360AdvertiserLink) {
      requests.add(request);
      responseObserver.onNext(((DisplayVideo360AdvertiserLink) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDisplayVideo360AdvertiserLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DisplayVideo360AdvertiserLink.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDisplayVideo360AdvertiserLinks(
      ListDisplayVideo360AdvertiserLinksRequest request,
      StreamObserver<ListDisplayVideo360AdvertiserLinksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDisplayVideo360AdvertiserLinksResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDisplayVideo360AdvertiserLinksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDisplayVideo360AdvertiserLinks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDisplayVideo360AdvertiserLinksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDisplayVideo360AdvertiserLink(
      CreateDisplayVideo360AdvertiserLinkRequest request,
      StreamObserver<DisplayVideo360AdvertiserLink> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DisplayVideo360AdvertiserLink) {
      requests.add(request);
      responseObserver.onNext(((DisplayVideo360AdvertiserLink) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDisplayVideo360AdvertiserLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DisplayVideo360AdvertiserLink.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDisplayVideo360AdvertiserLink(
      DeleteDisplayVideo360AdvertiserLinkRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteDisplayVideo360AdvertiserLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDisplayVideo360AdvertiserLink(
      UpdateDisplayVideo360AdvertiserLinkRequest request,
      StreamObserver<DisplayVideo360AdvertiserLink> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DisplayVideo360AdvertiserLink) {
      requests.add(request);
      responseObserver.onNext(((DisplayVideo360AdvertiserLink) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDisplayVideo360AdvertiserLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DisplayVideo360AdvertiserLink.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDisplayVideo360AdvertiserLinkProposal(
      GetDisplayVideo360AdvertiserLinkProposalRequest request,
      StreamObserver<DisplayVideo360AdvertiserLinkProposal> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DisplayVideo360AdvertiserLinkProposal) {
      requests.add(request);
      responseObserver.onNext(((DisplayVideo360AdvertiserLinkProposal) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDisplayVideo360AdvertiserLinkProposal, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DisplayVideo360AdvertiserLinkProposal.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDisplayVideo360AdvertiserLinkProposals(
      ListDisplayVideo360AdvertiserLinkProposalsRequest request,
      StreamObserver<ListDisplayVideo360AdvertiserLinkProposalsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDisplayVideo360AdvertiserLinkProposalsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDisplayVideo360AdvertiserLinkProposalsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDisplayVideo360AdvertiserLinkProposals, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDisplayVideo360AdvertiserLinkProposalsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDisplayVideo360AdvertiserLinkProposal(
      CreateDisplayVideo360AdvertiserLinkProposalRequest request,
      StreamObserver<DisplayVideo360AdvertiserLinkProposal> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DisplayVideo360AdvertiserLinkProposal) {
      requests.add(request);
      responseObserver.onNext(((DisplayVideo360AdvertiserLinkProposal) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDisplayVideo360AdvertiserLinkProposal, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DisplayVideo360AdvertiserLinkProposal.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDisplayVideo360AdvertiserLinkProposal(
      DeleteDisplayVideo360AdvertiserLinkProposalRequest request,
      StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteDisplayVideo360AdvertiserLinkProposal, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void approveDisplayVideo360AdvertiserLinkProposal(
      ApproveDisplayVideo360AdvertiserLinkProposalRequest request,
      StreamObserver<ApproveDisplayVideo360AdvertiserLinkProposalResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApproveDisplayVideo360AdvertiserLinkProposalResponse) {
      requests.add(request);
      responseObserver.onNext(((ApproveDisplayVideo360AdvertiserLinkProposalResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ApproveDisplayVideo360AdvertiserLinkProposal, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApproveDisplayVideo360AdvertiserLinkProposalResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void cancelDisplayVideo360AdvertiserLinkProposal(
      CancelDisplayVideo360AdvertiserLinkProposalRequest request,
      StreamObserver<DisplayVideo360AdvertiserLinkProposal> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DisplayVideo360AdvertiserLinkProposal) {
      requests.add(request);
      responseObserver.onNext(((DisplayVideo360AdvertiserLinkProposal) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CancelDisplayVideo360AdvertiserLinkProposal, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DisplayVideo360AdvertiserLinkProposal.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCustomDimension(
      CreateCustomDimensionRequest request, StreamObserver<CustomDimension> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CustomDimension) {
      requests.add(request);
      responseObserver.onNext(((CustomDimension) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateCustomDimension, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CustomDimension.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCustomDimension(
      UpdateCustomDimensionRequest request, StreamObserver<CustomDimension> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CustomDimension) {
      requests.add(request);
      responseObserver.onNext(((CustomDimension) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateCustomDimension, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CustomDimension.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCustomDimensions(
      ListCustomDimensionsRequest request,
      StreamObserver<ListCustomDimensionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCustomDimensionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCustomDimensionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCustomDimensions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCustomDimensionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void archiveCustomDimension(
      ArchiveCustomDimensionRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method ArchiveCustomDimension, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCustomDimension(
      GetCustomDimensionRequest request, StreamObserver<CustomDimension> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CustomDimension) {
      requests.add(request);
      responseObserver.onNext(((CustomDimension) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCustomDimension, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CustomDimension.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCustomMetric(
      CreateCustomMetricRequest request, StreamObserver<CustomMetric> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CustomMetric) {
      requests.add(request);
      responseObserver.onNext(((CustomMetric) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateCustomMetric, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CustomMetric.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCustomMetric(
      UpdateCustomMetricRequest request, StreamObserver<CustomMetric> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CustomMetric) {
      requests.add(request);
      responseObserver.onNext(((CustomMetric) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateCustomMetric, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CustomMetric.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCustomMetrics(
      ListCustomMetricsRequest request,
      StreamObserver<ListCustomMetricsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCustomMetricsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCustomMetricsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCustomMetrics, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCustomMetricsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void archiveCustomMetric(
      ArchiveCustomMetricRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method ArchiveCustomMetric, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCustomMetric(
      GetCustomMetricRequest request, StreamObserver<CustomMetric> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CustomMetric) {
      requests.add(request);
      responseObserver.onNext(((CustomMetric) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCustomMetric, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CustomMetric.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDataRetentionSettings(
      GetDataRetentionSettingsRequest request,
      StreamObserver<DataRetentionSettings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataRetentionSettings) {
      requests.add(request);
      responseObserver.onNext(((DataRetentionSettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDataRetentionSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataRetentionSettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDataRetentionSettings(
      UpdateDataRetentionSettingsRequest request,
      StreamObserver<DataRetentionSettings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataRetentionSettings) {
      requests.add(request);
      responseObserver.onNext(((DataRetentionSettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDataRetentionSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataRetentionSettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDataStream(
      CreateDataStreamRequest request, StreamObserver<DataStream> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataStream) {
      requests.add(request);
      responseObserver.onNext(((DataStream) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDataStream, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataStream.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDataStream(
      DeleteDataStreamRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteDataStream, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDataStream(
      UpdateDataStreamRequest request, StreamObserver<DataStream> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataStream) {
      requests.add(request);
      responseObserver.onNext(((DataStream) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDataStream, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataStream.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDataStreams(
      ListDataStreamsRequest request, StreamObserver<ListDataStreamsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDataStreamsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDataStreamsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDataStreams, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDataStreamsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDataStream(
      GetDataStreamRequest request, StreamObserver<DataStream> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataStream) {
      requests.add(request);
      responseObserver.onNext(((DataStream) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDataStream, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataStream.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAudience(GetAudienceRequest request, StreamObserver<Audience> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Audience) {
      requests.add(request);
      responseObserver.onNext(((Audience) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAudience, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Audience.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAudiences(
      ListAudiencesRequest request, StreamObserver<ListAudiencesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAudiencesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAudiencesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAudiences, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAudiencesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAudience(
      CreateAudienceRequest request, StreamObserver<Audience> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Audience) {
      requests.add(request);
      responseObserver.onNext(((Audience) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAudience, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Audience.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAudience(
      UpdateAudienceRequest request, StreamObserver<Audience> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Audience) {
      requests.add(request);
      responseObserver.onNext(((Audience) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateAudience, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Audience.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void archiveAudience(
      ArchiveAudienceRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method ArchiveAudience, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSearchAds360Link(
      GetSearchAds360LinkRequest request, StreamObserver<SearchAds360Link> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchAds360Link) {
      requests.add(request);
      responseObserver.onNext(((SearchAds360Link) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSearchAds360Link, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchAds360Link.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSearchAds360Links(
      ListSearchAds360LinksRequest request,
      StreamObserver<ListSearchAds360LinksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSearchAds360LinksResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSearchAds360LinksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSearchAds360Links, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSearchAds360LinksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSearchAds360Link(
      CreateSearchAds360LinkRequest request, StreamObserver<SearchAds360Link> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchAds360Link) {
      requests.add(request);
      responseObserver.onNext(((SearchAds360Link) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSearchAds360Link, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchAds360Link.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSearchAds360Link(
      DeleteSearchAds360LinkRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteSearchAds360Link, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSearchAds360Link(
      UpdateSearchAds360LinkRequest request, StreamObserver<SearchAds360Link> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchAds360Link) {
      requests.add(request);
      responseObserver.onNext(((SearchAds360Link) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSearchAds360Link, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchAds360Link.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAttributionSettings(
      GetAttributionSettingsRequest request, StreamObserver<AttributionSettings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AttributionSettings) {
      requests.add(request);
      responseObserver.onNext(((AttributionSettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAttributionSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AttributionSettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAttributionSettings(
      UpdateAttributionSettingsRequest request,
      StreamObserver<AttributionSettings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AttributionSettings) {
      requests.add(request);
      responseObserver.onNext(((AttributionSettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateAttributionSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AttributionSettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void runAccessReport(
      RunAccessReportRequest request, StreamObserver<RunAccessReportResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RunAccessReportResponse) {
      requests.add(request);
      responseObserver.onNext(((RunAccessReportResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RunAccessReport, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RunAccessReportResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAccessBinding(
      CreateAccessBindingRequest request, StreamObserver<AccessBinding> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AccessBinding) {
      requests.add(request);
      responseObserver.onNext(((AccessBinding) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAccessBinding, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AccessBinding.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAccessBinding(
      GetAccessBindingRequest request, StreamObserver<AccessBinding> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AccessBinding) {
      requests.add(request);
      responseObserver.onNext(((AccessBinding) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAccessBinding, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AccessBinding.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAccessBinding(
      UpdateAccessBindingRequest request, StreamObserver<AccessBinding> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AccessBinding) {
      requests.add(request);
      responseObserver.onNext(((AccessBinding) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateAccessBinding, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AccessBinding.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAccessBinding(
      DeleteAccessBindingRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAccessBinding, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAccessBindings(
      ListAccessBindingsRequest request,
      StreamObserver<ListAccessBindingsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAccessBindingsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAccessBindingsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAccessBindings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAccessBindingsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchCreateAccessBindings(
      BatchCreateAccessBindingsRequest request,
      StreamObserver<BatchCreateAccessBindingsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchCreateAccessBindingsResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchCreateAccessBindingsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchCreateAccessBindings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchCreateAccessBindingsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchGetAccessBindings(
      BatchGetAccessBindingsRequest request,
      StreamObserver<BatchGetAccessBindingsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchGetAccessBindingsResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchGetAccessBindingsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchGetAccessBindings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchGetAccessBindingsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchUpdateAccessBindings(
      BatchUpdateAccessBindingsRequest request,
      StreamObserver<BatchUpdateAccessBindingsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchUpdateAccessBindingsResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchUpdateAccessBindingsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchUpdateAccessBindings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchUpdateAccessBindingsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchDeleteAccessBindings(
      BatchDeleteAccessBindingsRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method BatchDeleteAccessBindings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getExpandedDataSet(
      GetExpandedDataSetRequest request, StreamObserver<ExpandedDataSet> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ExpandedDataSet) {
      requests.add(request);
      responseObserver.onNext(((ExpandedDataSet) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetExpandedDataSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ExpandedDataSet.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listExpandedDataSets(
      ListExpandedDataSetsRequest request,
      StreamObserver<ListExpandedDataSetsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListExpandedDataSetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListExpandedDataSetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListExpandedDataSets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListExpandedDataSetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createExpandedDataSet(
      CreateExpandedDataSetRequest request, StreamObserver<ExpandedDataSet> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ExpandedDataSet) {
      requests.add(request);
      responseObserver.onNext(((ExpandedDataSet) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateExpandedDataSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ExpandedDataSet.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateExpandedDataSet(
      UpdateExpandedDataSetRequest request, StreamObserver<ExpandedDataSet> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ExpandedDataSet) {
      requests.add(request);
      responseObserver.onNext(((ExpandedDataSet) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateExpandedDataSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ExpandedDataSet.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteExpandedDataSet(
      DeleteExpandedDataSetRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteExpandedDataSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getChannelGroup(
      GetChannelGroupRequest request, StreamObserver<ChannelGroup> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ChannelGroup) {
      requests.add(request);
      responseObserver.onNext(((ChannelGroup) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetChannelGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ChannelGroup.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listChannelGroups(
      ListChannelGroupsRequest request,
      StreamObserver<ListChannelGroupsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListChannelGroupsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListChannelGroupsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListChannelGroups, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListChannelGroupsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createChannelGroup(
      CreateChannelGroupRequest request, StreamObserver<ChannelGroup> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ChannelGroup) {
      requests.add(request);
      responseObserver.onNext(((ChannelGroup) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateChannelGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ChannelGroup.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateChannelGroup(
      UpdateChannelGroupRequest request, StreamObserver<ChannelGroup> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ChannelGroup) {
      requests.add(request);
      responseObserver.onNext(((ChannelGroup) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateChannelGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ChannelGroup.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteChannelGroup(
      DeleteChannelGroupRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteChannelGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void setAutomatedGa4ConfigurationOptOut(
      SetAutomatedGa4ConfigurationOptOutRequest request,
      StreamObserver<SetAutomatedGa4ConfigurationOptOutResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SetAutomatedGa4ConfigurationOptOutResponse) {
      requests.add(request);
      responseObserver.onNext(((SetAutomatedGa4ConfigurationOptOutResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SetAutomatedGa4ConfigurationOptOut, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SetAutomatedGa4ConfigurationOptOutResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchAutomatedGa4ConfigurationOptOut(
      FetchAutomatedGa4ConfigurationOptOutRequest request,
      StreamObserver<FetchAutomatedGa4ConfigurationOptOutResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchAutomatedGa4ConfigurationOptOutResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchAutomatedGa4ConfigurationOptOutResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchAutomatedGa4ConfigurationOptOut, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchAutomatedGa4ConfigurationOptOutResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getBigQueryLink(
      GetBigQueryLinkRequest request, StreamObserver<BigQueryLink> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BigQueryLink) {
      requests.add(request);
      responseObserver.onNext(((BigQueryLink) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetBigQueryLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BigQueryLink.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listBigQueryLinks(
      ListBigQueryLinksRequest request,
      StreamObserver<ListBigQueryLinksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListBigQueryLinksResponse) {
      requests.add(request);
      responseObserver.onNext(((ListBigQueryLinksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListBigQueryLinks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListBigQueryLinksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEnhancedMeasurementSettings(
      GetEnhancedMeasurementSettingsRequest request,
      StreamObserver<EnhancedMeasurementSettings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EnhancedMeasurementSettings) {
      requests.add(request);
      responseObserver.onNext(((EnhancedMeasurementSettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEnhancedMeasurementSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EnhancedMeasurementSettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateEnhancedMeasurementSettings(
      UpdateEnhancedMeasurementSettingsRequest request,
      StreamObserver<EnhancedMeasurementSettings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EnhancedMeasurementSettings) {
      requests.add(request);
      responseObserver.onNext(((EnhancedMeasurementSettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateEnhancedMeasurementSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EnhancedMeasurementSettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createConnectedSiteTag(
      CreateConnectedSiteTagRequest request,
      StreamObserver<CreateConnectedSiteTagResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CreateConnectedSiteTagResponse) {
      requests.add(request);
      responseObserver.onNext(((CreateConnectedSiteTagResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateConnectedSiteTag, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CreateConnectedSiteTagResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteConnectedSiteTag(
      DeleteConnectedSiteTagRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteConnectedSiteTag, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listConnectedSiteTags(
      ListConnectedSiteTagsRequest request,
      StreamObserver<ListConnectedSiteTagsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListConnectedSiteTagsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListConnectedSiteTagsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListConnectedSiteTags, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListConnectedSiteTagsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchConnectedGa4Property(
      FetchConnectedGa4PropertyRequest request,
      StreamObserver<FetchConnectedGa4PropertyResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchConnectedGa4PropertyResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchConnectedGa4PropertyResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchConnectedGa4Property, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchConnectedGa4PropertyResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAdSenseLink(
      GetAdSenseLinkRequest request, StreamObserver<AdSenseLink> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AdSenseLink) {
      requests.add(request);
      responseObserver.onNext(((AdSenseLink) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAdSenseLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AdSenseLink.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAdSenseLink(
      CreateAdSenseLinkRequest request, StreamObserver<AdSenseLink> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AdSenseLink) {
      requests.add(request);
      responseObserver.onNext(((AdSenseLink) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAdSenseLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AdSenseLink.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAdSenseLink(
      DeleteAdSenseLinkRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAdSenseLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAdSenseLinks(
      ListAdSenseLinksRequest request, StreamObserver<ListAdSenseLinksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAdSenseLinksResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAdSenseLinksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAdSenseLinks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAdSenseLinksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEventCreateRule(
      GetEventCreateRuleRequest request, StreamObserver<EventCreateRule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EventCreateRule) {
      requests.add(request);
      responseObserver.onNext(((EventCreateRule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEventCreateRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EventCreateRule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listEventCreateRules(
      ListEventCreateRulesRequest request,
      StreamObserver<ListEventCreateRulesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEventCreateRulesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEventCreateRulesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEventCreateRules, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEventCreateRulesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createEventCreateRule(
      CreateEventCreateRuleRequest request, StreamObserver<EventCreateRule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EventCreateRule) {
      requests.add(request);
      responseObserver.onNext(((EventCreateRule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateEventCreateRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EventCreateRule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateEventCreateRule(
      UpdateEventCreateRuleRequest request, StreamObserver<EventCreateRule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EventCreateRule) {
      requests.add(request);
      responseObserver.onNext(((EventCreateRule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateEventCreateRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EventCreateRule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteEventCreateRule(
      DeleteEventCreateRuleRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteEventCreateRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDataRedactionSettings(
      UpdateDataRedactionSettingsRequest request,
      StreamObserver<DataRedactionSettings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataRedactionSettings) {
      requests.add(request);
      responseObserver.onNext(((DataRedactionSettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDataRedactionSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataRedactionSettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDataRedactionSettings(
      GetDataRedactionSettingsRequest request,
      StreamObserver<DataRedactionSettings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataRedactionSettings) {
      requests.add(request);
      responseObserver.onNext(((DataRedactionSettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDataRedactionSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataRedactionSettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createRollupProperty(
      CreateRollupPropertyRequest request,
      StreamObserver<CreateRollupPropertyResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CreateRollupPropertyResponse) {
      requests.add(request);
      responseObserver.onNext(((CreateRollupPropertyResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateRollupProperty, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CreateRollupPropertyResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRollupPropertySourceLink(
      GetRollupPropertySourceLinkRequest request,
      StreamObserver<RollupPropertySourceLink> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RollupPropertySourceLink) {
      requests.add(request);
      responseObserver.onNext(((RollupPropertySourceLink) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRollupPropertySourceLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RollupPropertySourceLink.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRollupPropertySourceLinks(
      ListRollupPropertySourceLinksRequest request,
      StreamObserver<ListRollupPropertySourceLinksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRollupPropertySourceLinksResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRollupPropertySourceLinksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRollupPropertySourceLinks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRollupPropertySourceLinksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createRollupPropertySourceLink(
      CreateRollupPropertySourceLinkRequest request,
      StreamObserver<RollupPropertySourceLink> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RollupPropertySourceLink) {
      requests.add(request);
      responseObserver.onNext(((RollupPropertySourceLink) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateRollupPropertySourceLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RollupPropertySourceLink.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteRollupPropertySourceLink(
      DeleteRollupPropertySourceLinkRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteRollupPropertySourceLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSubproperty(
      CreateSubpropertyRequest request,
      StreamObserver<CreateSubpropertyResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CreateSubpropertyResponse) {
      requests.add(request);
      responseObserver.onNext(((CreateSubpropertyResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSubproperty, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CreateSubpropertyResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSubpropertyEventFilter(
      CreateSubpropertyEventFilterRequest request,
      StreamObserver<SubpropertyEventFilter> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SubpropertyEventFilter) {
      requests.add(request);
      responseObserver.onNext(((SubpropertyEventFilter) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSubpropertyEventFilter, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SubpropertyEventFilter.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSubpropertyEventFilter(
      GetSubpropertyEventFilterRequest request,
      StreamObserver<SubpropertyEventFilter> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SubpropertyEventFilter) {
      requests.add(request);
      responseObserver.onNext(((SubpropertyEventFilter) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSubpropertyEventFilter, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SubpropertyEventFilter.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSubpropertyEventFilters(
      ListSubpropertyEventFiltersRequest request,
      StreamObserver<ListSubpropertyEventFiltersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSubpropertyEventFiltersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSubpropertyEventFiltersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSubpropertyEventFilters, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSubpropertyEventFiltersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSubpropertyEventFilter(
      UpdateSubpropertyEventFilterRequest request,
      StreamObserver<SubpropertyEventFilter> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SubpropertyEventFilter) {
      requests.add(request);
      responseObserver.onNext(((SubpropertyEventFilter) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSubpropertyEventFilter, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SubpropertyEventFilter.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSubpropertyEventFilter(
      DeleteSubpropertyEventFilterRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteSubpropertyEventFilter, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
