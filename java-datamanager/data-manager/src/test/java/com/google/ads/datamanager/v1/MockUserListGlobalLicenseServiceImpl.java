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

package com.google.ads.datamanager.v1;

import com.google.ads.datamanager.v1.UserListGlobalLicenseServiceGrpc.UserListGlobalLicenseServiceImplBase;
import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockUserListGlobalLicenseServiceImpl extends UserListGlobalLicenseServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockUserListGlobalLicenseServiceImpl() {
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
  public void createUserListGlobalLicense(
      CreateUserListGlobalLicenseRequest request,
      StreamObserver<UserListGlobalLicense> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UserListGlobalLicense) {
      requests.add(request);
      responseObserver.onNext(((UserListGlobalLicense) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateUserListGlobalLicense, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UserListGlobalLicense.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateUserListGlobalLicense(
      UpdateUserListGlobalLicenseRequest request,
      StreamObserver<UserListGlobalLicense> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UserListGlobalLicense) {
      requests.add(request);
      responseObserver.onNext(((UserListGlobalLicense) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateUserListGlobalLicense, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UserListGlobalLicense.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getUserListGlobalLicense(
      GetUserListGlobalLicenseRequest request,
      StreamObserver<UserListGlobalLicense> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UserListGlobalLicense) {
      requests.add(request);
      responseObserver.onNext(((UserListGlobalLicense) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetUserListGlobalLicense, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UserListGlobalLicense.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listUserListGlobalLicenses(
      ListUserListGlobalLicensesRequest request,
      StreamObserver<ListUserListGlobalLicensesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListUserListGlobalLicensesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListUserListGlobalLicensesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListUserListGlobalLicenses, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListUserListGlobalLicensesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listUserListGlobalLicenseCustomerInfos(
      ListUserListGlobalLicenseCustomerInfosRequest request,
      StreamObserver<ListUserListGlobalLicenseCustomerInfosResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListUserListGlobalLicenseCustomerInfosResponse) {
      requests.add(request);
      responseObserver.onNext(((ListUserListGlobalLicenseCustomerInfosResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListUserListGlobalLicenseCustomerInfos,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListUserListGlobalLicenseCustomerInfosResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
