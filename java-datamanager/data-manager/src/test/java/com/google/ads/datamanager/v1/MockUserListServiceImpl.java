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

import com.google.ads.datamanager.v1.UserListServiceGrpc.UserListServiceImplBase;
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
public class MockUserListServiceImpl extends UserListServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockUserListServiceImpl() {
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
  public void getUserList(GetUserListRequest request, StreamObserver<UserList> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UserList) {
      requests.add(request);
      responseObserver.onNext(((UserList) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetUserList, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UserList.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listUserLists(
      ListUserListsRequest request, StreamObserver<ListUserListsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListUserListsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListUserListsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListUserLists, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListUserListsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createUserList(
      CreateUserListRequest request, StreamObserver<UserList> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UserList) {
      requests.add(request);
      responseObserver.onNext(((UserList) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateUserList, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UserList.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateUserList(
      UpdateUserListRequest request, StreamObserver<UserList> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UserList) {
      requests.add(request);
      responseObserver.onNext(((UserList) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateUserList, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UserList.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteUserList(
      DeleteUserListRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteUserList, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
