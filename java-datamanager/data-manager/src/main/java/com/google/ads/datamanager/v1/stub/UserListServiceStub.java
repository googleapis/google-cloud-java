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

package com.google.ads.datamanager.v1.stub;

import static com.google.ads.datamanager.v1.UserListServiceClient.ListUserListsPagedResponse;

import com.google.ads.datamanager.v1.CreateUserListRequest;
import com.google.ads.datamanager.v1.DeleteUserListRequest;
import com.google.ads.datamanager.v1.GetUserListRequest;
import com.google.ads.datamanager.v1.ListUserListsRequest;
import com.google.ads.datamanager.v1.ListUserListsResponse;
import com.google.ads.datamanager.v1.UpdateUserListRequest;
import com.google.ads.datamanager.v1.UserList;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the UserListService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class UserListServiceStub implements BackgroundResource {

  public UnaryCallable<GetUserListRequest, UserList> getUserListCallable() {
    throw new UnsupportedOperationException("Not implemented: getUserListCallable()");
  }

  public UnaryCallable<ListUserListsRequest, ListUserListsPagedResponse>
      listUserListsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listUserListsPagedCallable()");
  }

  public UnaryCallable<ListUserListsRequest, ListUserListsResponse> listUserListsCallable() {
    throw new UnsupportedOperationException("Not implemented: listUserListsCallable()");
  }

  public UnaryCallable<CreateUserListRequest, UserList> createUserListCallable() {
    throw new UnsupportedOperationException("Not implemented: createUserListCallable()");
  }

  public UnaryCallable<UpdateUserListRequest, UserList> updateUserListCallable() {
    throw new UnsupportedOperationException("Not implemented: updateUserListCallable()");
  }

  public UnaryCallable<DeleteUserListRequest, Empty> deleteUserListCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteUserListCallable()");
  }

  @Override
  public abstract void close();
}
