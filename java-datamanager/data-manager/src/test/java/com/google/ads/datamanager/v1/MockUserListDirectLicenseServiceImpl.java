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

import com.google.ads.datamanager.v1.UserListDirectLicenseServiceGrpc.UserListDirectLicenseServiceImplBase;
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
public class MockUserListDirectLicenseServiceImpl extends UserListDirectLicenseServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockUserListDirectLicenseServiceImpl() {
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
  public void createUserListDirectLicense(
      CreateUserListDirectLicenseRequest request,
      StreamObserver<UserListDirectLicense> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UserListDirectLicense) {
      requests.add(request);
      responseObserver.onNext(((UserListDirectLicense) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateUserListDirectLicense, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UserListDirectLicense.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getUserListDirectLicense(
      GetUserListDirectLicenseRequest request,
      StreamObserver<UserListDirectLicense> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UserListDirectLicense) {
      requests.add(request);
      responseObserver.onNext(((UserListDirectLicense) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetUserListDirectLicense, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UserListDirectLicense.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateUserListDirectLicense(
      UpdateUserListDirectLicenseRequest request,
      StreamObserver<UserListDirectLicense> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UserListDirectLicense) {
      requests.add(request);
      responseObserver.onNext(((UserListDirectLicense) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateUserListDirectLicense, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UserListDirectLicense.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listUserListDirectLicenses(
      ListUserListDirectLicensesRequest request,
      StreamObserver<ListUserListDirectLicensesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListUserListDirectLicensesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListUserListDirectLicensesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListUserListDirectLicenses, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListUserListDirectLicensesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
