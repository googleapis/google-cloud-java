/*
 * Copyright 2020 Google LLC
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
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  Account.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAccounts(
      ListAccountsRequest request, StreamObserver<ListAccountsResponse> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  ListAccountsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAccount(DeleteAccountRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAccount(
      UpdateAccountRequest request, StreamObserver<Account> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  Account.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void provisionAccountTicket(
      ProvisionAccountTicketRequest request,
      StreamObserver<ProvisionAccountTicketResponse> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  ProvisionAccountTicketResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAccountSummaries(
      ListAccountSummariesRequest request,
      StreamObserver<ListAccountSummariesResponse> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  ListAccountSummariesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getProperty(GetPropertyRequest request, StreamObserver<Property> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  Property.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listProperties(
      ListPropertiesRequest request, StreamObserver<ListPropertiesResponse> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  ListPropertiesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createProperty(
      CreatePropertyRequest request, StreamObserver<Property> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  Property.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteProperty(
      DeletePropertyRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method DeleteProperty, expected %s or %s",
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateProperty(
      UpdatePropertyRequest request, StreamObserver<Property> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  Property.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getUserLink(GetUserLinkRequest request, StreamObserver<UserLink> responseObserver) {
    Object response = responses.remove();
    if (response instanceof UserLink) {
      requests.add(request);
      responseObserver.onNext(((UserLink) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetUserLink, expected %s or %s",
                  response.getClass().getName(),
                  UserLink.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchGetUserLinks(
      BatchGetUserLinksRequest request,
      StreamObserver<BatchGetUserLinksResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof BatchGetUserLinksResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchGetUserLinksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchGetUserLinks, expected %s or %s",
                  response.getClass().getName(),
                  BatchGetUserLinksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listUserLinks(
      ListUserLinksRequest request, StreamObserver<ListUserLinksResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListUserLinksResponse) {
      requests.add(request);
      responseObserver.onNext(((ListUserLinksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListUserLinks, expected %s or %s",
                  response.getClass().getName(),
                  ListUserLinksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void auditUserLinks(
      AuditUserLinksRequest request, StreamObserver<AuditUserLinksResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof AuditUserLinksResponse) {
      requests.add(request);
      responseObserver.onNext(((AuditUserLinksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AuditUserLinks, expected %s or %s",
                  response.getClass().getName(),
                  AuditUserLinksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createUserLink(
      CreateUserLinkRequest request, StreamObserver<UserLink> responseObserver) {
    Object response = responses.remove();
    if (response instanceof UserLink) {
      requests.add(request);
      responseObserver.onNext(((UserLink) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateUserLink, expected %s or %s",
                  response.getClass().getName(),
                  UserLink.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchCreateUserLinks(
      BatchCreateUserLinksRequest request,
      StreamObserver<BatchCreateUserLinksResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof BatchCreateUserLinksResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchCreateUserLinksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchCreateUserLinks, expected %s or %s",
                  response.getClass().getName(),
                  BatchCreateUserLinksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateUserLink(
      UpdateUserLinkRequest request, StreamObserver<UserLink> responseObserver) {
    Object response = responses.remove();
    if (response instanceof UserLink) {
      requests.add(request);
      responseObserver.onNext(((UserLink) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateUserLink, expected %s or %s",
                  response.getClass().getName(),
                  UserLink.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchUpdateUserLinks(
      BatchUpdateUserLinksRequest request,
      StreamObserver<BatchUpdateUserLinksResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof BatchUpdateUserLinksResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchUpdateUserLinksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchUpdateUserLinks, expected %s or %s",
                  response.getClass().getName(),
                  BatchUpdateUserLinksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteUserLink(
      DeleteUserLinkRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method DeleteUserLink, expected %s or %s",
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchDeleteUserLinks(
      BatchDeleteUserLinksRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method BatchDeleteUserLinks, expected %s or %s",
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getWebDataStream(
      GetWebDataStreamRequest request, StreamObserver<WebDataStream> responseObserver) {
    Object response = responses.remove();
    if (response instanceof WebDataStream) {
      requests.add(request);
      responseObserver.onNext(((WebDataStream) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetWebDataStream, expected %s or %s",
                  response.getClass().getName(),
                  WebDataStream.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteWebDataStream(
      DeleteWebDataStreamRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method DeleteWebDataStream, expected %s or %s",
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateWebDataStream(
      UpdateWebDataStreamRequest request, StreamObserver<WebDataStream> responseObserver) {
    Object response = responses.remove();
    if (response instanceof WebDataStream) {
      requests.add(request);
      responseObserver.onNext(((WebDataStream) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateWebDataStream, expected %s or %s",
                  response.getClass().getName(),
                  WebDataStream.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createWebDataStream(
      CreateWebDataStreamRequest request, StreamObserver<WebDataStream> responseObserver) {
    Object response = responses.remove();
    if (response instanceof WebDataStream) {
      requests.add(request);
      responseObserver.onNext(((WebDataStream) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateWebDataStream, expected %s or %s",
                  response.getClass().getName(),
                  WebDataStream.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listWebDataStreams(
      ListWebDataStreamsRequest request,
      StreamObserver<ListWebDataStreamsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListWebDataStreamsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListWebDataStreamsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListWebDataStreams, expected %s or %s",
                  response.getClass().getName(),
                  ListWebDataStreamsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getIosAppDataStream(
      GetIosAppDataStreamRequest request, StreamObserver<IosAppDataStream> responseObserver) {
    Object response = responses.remove();
    if (response instanceof IosAppDataStream) {
      requests.add(request);
      responseObserver.onNext(((IosAppDataStream) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetIosAppDataStream, expected %s or %s",
                  response.getClass().getName(),
                  IosAppDataStream.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteIosAppDataStream(
      DeleteIosAppDataStreamRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method DeleteIosAppDataStream, expected %s or %s",
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateIosAppDataStream(
      UpdateIosAppDataStreamRequest request, StreamObserver<IosAppDataStream> responseObserver) {
    Object response = responses.remove();
    if (response instanceof IosAppDataStream) {
      requests.add(request);
      responseObserver.onNext(((IosAppDataStream) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateIosAppDataStream, expected %s or %s",
                  response.getClass().getName(),
                  IosAppDataStream.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createIosAppDataStream(
      CreateIosAppDataStreamRequest request, StreamObserver<IosAppDataStream> responseObserver) {
    Object response = responses.remove();
    if (response instanceof IosAppDataStream) {
      requests.add(request);
      responseObserver.onNext(((IosAppDataStream) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateIosAppDataStream, expected %s or %s",
                  response.getClass().getName(),
                  IosAppDataStream.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listIosAppDataStreams(
      ListIosAppDataStreamsRequest request,
      StreamObserver<ListIosAppDataStreamsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListIosAppDataStreamsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListIosAppDataStreamsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListIosAppDataStreams, expected %s or %s",
                  response.getClass().getName(),
                  ListIosAppDataStreamsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAndroidAppDataStream(
      GetAndroidAppDataStreamRequest request,
      StreamObserver<AndroidAppDataStream> responseObserver) {
    Object response = responses.remove();
    if (response instanceof AndroidAppDataStream) {
      requests.add(request);
      responseObserver.onNext(((AndroidAppDataStream) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAndroidAppDataStream, expected %s or %s",
                  response.getClass().getName(),
                  AndroidAppDataStream.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAndroidAppDataStream(
      DeleteAndroidAppDataStreamRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method DeleteAndroidAppDataStream, expected %s or %s",
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAndroidAppDataStream(
      UpdateAndroidAppDataStreamRequest request,
      StreamObserver<AndroidAppDataStream> responseObserver) {
    Object response = responses.remove();
    if (response instanceof AndroidAppDataStream) {
      requests.add(request);
      responseObserver.onNext(((AndroidAppDataStream) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateAndroidAppDataStream, expected %s or %s",
                  response.getClass().getName(),
                  AndroidAppDataStream.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAndroidAppDataStream(
      CreateAndroidAppDataStreamRequest request,
      StreamObserver<AndroidAppDataStream> responseObserver) {
    Object response = responses.remove();
    if (response instanceof AndroidAppDataStream) {
      requests.add(request);
      responseObserver.onNext(((AndroidAppDataStream) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAndroidAppDataStream, expected %s or %s",
                  response.getClass().getName(),
                  AndroidAppDataStream.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAndroidAppDataStreams(
      ListAndroidAppDataStreamsRequest request,
      StreamObserver<ListAndroidAppDataStreamsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListAndroidAppDataStreamsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAndroidAppDataStreamsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAndroidAppDataStreams, expected %s or %s",
                  response.getClass().getName(),
                  ListAndroidAppDataStreamsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEnhancedMeasurementSettings(
      GetEnhancedMeasurementSettingsRequest request,
      StreamObserver<EnhancedMeasurementSettings> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  EnhancedMeasurementSettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateEnhancedMeasurementSettings(
      UpdateEnhancedMeasurementSettingsRequest request,
      StreamObserver<EnhancedMeasurementSettings> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  EnhancedMeasurementSettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createFirebaseLink(
      CreateFirebaseLinkRequest request, StreamObserver<FirebaseLink> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  FirebaseLink.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateFirebaseLink(
      UpdateFirebaseLinkRequest request, StreamObserver<FirebaseLink> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method UpdateFirebaseLink, expected %s or %s",
                  response.getClass().getName(),
                  FirebaseLink.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteFirebaseLink(
      DeleteFirebaseLinkRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFirebaseLinks(
      ListFirebaseLinksRequest request,
      StreamObserver<ListFirebaseLinksResponse> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  ListFirebaseLinksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getGlobalSiteTag(
      GetGlobalSiteTagRequest request, StreamObserver<GlobalSiteTag> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  GlobalSiteTag.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createGoogleAdsLink(
      CreateGoogleAdsLinkRequest request, StreamObserver<GoogleAdsLink> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  GoogleAdsLink.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateGoogleAdsLink(
      UpdateGoogleAdsLinkRequest request, StreamObserver<GoogleAdsLink> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  GoogleAdsLink.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteGoogleAdsLink(
      DeleteGoogleAdsLinkRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listGoogleAdsLinks(
      ListGoogleAdsLinksRequest request,
      StreamObserver<ListGoogleAdsLinksResponse> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  ListGoogleAdsLinksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDataSharingSettings(
      GetDataSharingSettingsRequest request, StreamObserver<DataSharingSettings> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  DataSharingSettings.class.getName(),
                  Exception.class.getName())));
    }
  }
}
