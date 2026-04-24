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

package com.google.showcase.v1beta1.stub;

import static com.google.showcase.v1beta1.MessagingClient.ListBlurbsPagedResponse;
import static com.google.showcase.v1beta1.MessagingClient.ListLocationsPagedResponse;
import static com.google.showcase.v1beta1.MessagingClient.ListRoomsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import com.google.showcase.v1beta1.Blurb;
import com.google.showcase.v1beta1.ConnectRequest;
import com.google.showcase.v1beta1.CreateBlurbRequest;
import com.google.showcase.v1beta1.CreateRoomRequest;
import com.google.showcase.v1beta1.DeleteBlurbRequest;
import com.google.showcase.v1beta1.DeleteRoomRequest;
import com.google.showcase.v1beta1.GetBlurbRequest;
import com.google.showcase.v1beta1.GetRoomRequest;
import com.google.showcase.v1beta1.ListBlurbsRequest;
import com.google.showcase.v1beta1.ListBlurbsResponse;
import com.google.showcase.v1beta1.ListRoomsRequest;
import com.google.showcase.v1beta1.ListRoomsResponse;
import com.google.showcase.v1beta1.Room;
import com.google.showcase.v1beta1.SearchBlurbsMetadata;
import com.google.showcase.v1beta1.SearchBlurbsRequest;
import com.google.showcase.v1beta1.SearchBlurbsResponse;
import com.google.showcase.v1beta1.SendBlurbsResponse;
import com.google.showcase.v1beta1.StreamBlurbsRequest;
import com.google.showcase.v1beta1.StreamBlurbsResponse;
import com.google.showcase.v1beta1.UpdateBlurbRequest;
import com.google.showcase.v1beta1.UpdateRoomRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Messaging service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class MessagingStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<CreateRoomRequest, Room> createRoomCallable() {
    throw new UnsupportedOperationException("Not implemented: createRoomCallable()");
  }

  public UnaryCallable<GetRoomRequest, Room> getRoomCallable() {
    throw new UnsupportedOperationException("Not implemented: getRoomCallable()");
  }

  public UnaryCallable<UpdateRoomRequest, Room> updateRoomCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRoomCallable()");
  }

  public UnaryCallable<DeleteRoomRequest, Empty> deleteRoomCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRoomCallable()");
  }

  public UnaryCallable<ListRoomsRequest, ListRoomsPagedResponse> listRoomsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRoomsPagedCallable()");
  }

  public UnaryCallable<ListRoomsRequest, ListRoomsResponse> listRoomsCallable() {
    throw new UnsupportedOperationException("Not implemented: listRoomsCallable()");
  }

  public UnaryCallable<CreateBlurbRequest, Blurb> createBlurbCallable() {
    throw new UnsupportedOperationException("Not implemented: createBlurbCallable()");
  }

  public UnaryCallable<GetBlurbRequest, Blurb> getBlurbCallable() {
    throw new UnsupportedOperationException("Not implemented: getBlurbCallable()");
  }

  public UnaryCallable<UpdateBlurbRequest, Blurb> updateBlurbCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBlurbCallable()");
  }

  public UnaryCallable<DeleteBlurbRequest, Empty> deleteBlurbCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBlurbCallable()");
  }

  public UnaryCallable<ListBlurbsRequest, ListBlurbsPagedResponse> listBlurbsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBlurbsPagedCallable()");
  }

  public UnaryCallable<ListBlurbsRequest, ListBlurbsResponse> listBlurbsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBlurbsCallable()");
  }

  public OperationCallable<SearchBlurbsRequest, SearchBlurbsResponse, SearchBlurbsMetadata>
      searchBlurbsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: searchBlurbsOperationCallable()");
  }

  public UnaryCallable<SearchBlurbsRequest, Operation> searchBlurbsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchBlurbsCallable()");
  }

  public ServerStreamingCallable<StreamBlurbsRequest, StreamBlurbsResponse> streamBlurbsCallable() {
    throw new UnsupportedOperationException("Not implemented: streamBlurbsCallable()");
  }

  public ClientStreamingCallable<CreateBlurbRequest, SendBlurbsResponse> sendBlurbsCallable() {
    throw new UnsupportedOperationException("Not implemented: sendBlurbsCallable()");
  }

  public BidiStreamingCallable<ConnectRequest, StreamBlurbsResponse> connectCallable() {
    throw new UnsupportedOperationException("Not implemented: connectCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
