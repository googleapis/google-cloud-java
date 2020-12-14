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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }
}
