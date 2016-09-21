/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.monitoring.spi.v3;

import com.google.common.collect.Lists;
import com.google.monitoring.v3.CreateGroupRequest;
import com.google.monitoring.v3.DeleteGroupRequest;
import com.google.monitoring.v3.GetGroupRequest;
import com.google.monitoring.v3.Group;
import com.google.monitoring.v3.GroupServiceGrpc.GroupService;
import com.google.monitoring.v3.ListGroupMembersRequest;
import com.google.monitoring.v3.ListGroupMembersResponse;
import com.google.monitoring.v3.ListGroupsRequest;
import com.google.monitoring.v3.ListGroupsResponse;
import com.google.monitoring.v3.UpdateGroupRequest;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@javax.annotation.Generated("by GAPIC")
public class MockGroupServiceImpl implements GroupService {
  private ArrayList<GeneratedMessage> requests;
  private Queue<GeneratedMessage> responses;

  public MockGroupServiceImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<GeneratedMessage> getRequests() {
    return requests;
  }

  public void setResponses(List<GeneratedMessage> responses) {
    this.responses = Lists.newLinkedList(responses);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void listGroups(
      ListGroupsRequest request, StreamObserver<ListGroupsResponse> responseObserver) {
    ListGroupsResponse response = (ListGroupsResponse) responses.remove();
    requests.add(request);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void getGroup(GetGroupRequest request, StreamObserver<Group> responseObserver) {
    Group response = (Group) responses.remove();
    requests.add(request);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void createGroup(CreateGroupRequest request, StreamObserver<Group> responseObserver) {
    Group response = (Group) responses.remove();
    requests.add(request);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void updateGroup(UpdateGroupRequest request, StreamObserver<Group> responseObserver) {
    Group response = (Group) responses.remove();
    requests.add(request);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void deleteGroup(DeleteGroupRequest request, StreamObserver<Empty> responseObserver) {
    Empty response = (Empty) responses.remove();
    requests.add(request);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void listGroupMembers(
      ListGroupMembersRequest request, StreamObserver<ListGroupMembersResponse> responseObserver) {
    ListGroupMembersResponse response = (ListGroupMembersResponse) responses.remove();
    requests.add(request);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
