/*
 * Copyright 2025 Google LLC
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

package com.google.ads.marketingplatform.admin.v1alpha;

import com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceGrpc.MarketingplatformAdminServiceImplBase;
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
public class MockMarketingplatformAdminServiceImpl extends MarketingplatformAdminServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockMarketingplatformAdminServiceImpl() {
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
  public void getOrganization(
      GetOrganizationRequest request, StreamObserver<Organization> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Organization) {
      requests.add(request);
      responseObserver.onNext(((Organization) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetOrganization, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Organization.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAnalyticsAccountLinks(
      ListAnalyticsAccountLinksRequest request,
      StreamObserver<ListAnalyticsAccountLinksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAnalyticsAccountLinksResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAnalyticsAccountLinksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAnalyticsAccountLinks, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAnalyticsAccountLinksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAnalyticsAccountLink(
      CreateAnalyticsAccountLinkRequest request,
      StreamObserver<AnalyticsAccountLink> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AnalyticsAccountLink) {
      requests.add(request);
      responseObserver.onNext(((AnalyticsAccountLink) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAnalyticsAccountLink, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AnalyticsAccountLink.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAnalyticsAccountLink(
      DeleteAnalyticsAccountLinkRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAnalyticsAccountLink, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void setPropertyServiceLevel(
      SetPropertyServiceLevelRequest request,
      StreamObserver<SetPropertyServiceLevelResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SetPropertyServiceLevelResponse) {
      requests.add(request);
      responseObserver.onNext(((SetPropertyServiceLevelResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SetPropertyServiceLevel, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  SetPropertyServiceLevelResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
