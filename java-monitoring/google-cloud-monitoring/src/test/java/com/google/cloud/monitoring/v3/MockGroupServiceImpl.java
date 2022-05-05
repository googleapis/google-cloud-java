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

package com.google.cloud.monitoring.v3;

import com.google.api.core.BetaApi;
import com.google.monitoring.v3.CreateGroupRequest;
import com.google.monitoring.v3.DeleteGroupRequest;
import com.google.monitoring.v3.GetGroupRequest;
import com.google.monitoring.v3.Group;
import com.google.monitoring.v3.GroupServiceGrpc.GroupServiceImplBase;
import com.google.monitoring.v3.ListGroupMembersRequest;
import com.google.monitoring.v3.ListGroupMembersResponse;
import com.google.monitoring.v3.ListGroupsRequest;
import com.google.monitoring.v3.ListGroupsResponse;
import com.google.monitoring.v3.UpdateGroupRequest;
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
public class MockGroupServiceImpl extends GroupServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockGroupServiceImpl() {
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
  public void listGroups(
      ListGroupsRequest request, StreamObserver<ListGroupsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListGroupsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListGroupsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListGroups, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListGroupsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getGroup(GetGroupRequest request, StreamObserver<Group> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Group) {
      requests.add(request);
      responseObserver.onNext(((Group) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Group.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createGroup(CreateGroupRequest request, StreamObserver<Group> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Group) {
      requests.add(request);
      responseObserver.onNext(((Group) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Group.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateGroup(UpdateGroupRequest request, StreamObserver<Group> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Group) {
      requests.add(request);
      responseObserver.onNext(((Group) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Group.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteGroup(DeleteGroupRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listGroupMembers(
      ListGroupMembersRequest request, StreamObserver<ListGroupMembersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListGroupMembersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListGroupMembersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListGroupMembers, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListGroupMembersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
