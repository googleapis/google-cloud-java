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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.UserServiceClient.ListUsersPagedResponse;

import com.google.ads.admanager.v1.BatchActivateUsersRequest;
import com.google.ads.admanager.v1.BatchActivateUsersResponse;
import com.google.ads.admanager.v1.BatchCreateUsersRequest;
import com.google.ads.admanager.v1.BatchCreateUsersResponse;
import com.google.ads.admanager.v1.BatchDeactivateUsersRequest;
import com.google.ads.admanager.v1.BatchDeactivateUsersResponse;
import com.google.ads.admanager.v1.BatchUpdateUsersRequest;
import com.google.ads.admanager.v1.BatchUpdateUsersResponse;
import com.google.ads.admanager.v1.CreateUserRequest;
import com.google.ads.admanager.v1.GetUserRequest;
import com.google.ads.admanager.v1.ListUsersRequest;
import com.google.ads.admanager.v1.ListUsersResponse;
import com.google.ads.admanager.v1.UpdateUserRequest;
import com.google.ads.admanager.v1.User;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the UserService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class UserServiceStub implements BackgroundResource {

  public UnaryCallable<GetUserRequest, User> getUserCallable() {
    throw new UnsupportedOperationException("Not implemented: getUserCallable()");
  }

  public UnaryCallable<ListUsersRequest, ListUsersPagedResponse> listUsersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listUsersPagedCallable()");
  }

  public UnaryCallable<ListUsersRequest, ListUsersResponse> listUsersCallable() {
    throw new UnsupportedOperationException("Not implemented: listUsersCallable()");
  }

  public UnaryCallable<CreateUserRequest, User> createUserCallable() {
    throw new UnsupportedOperationException("Not implemented: createUserCallable()");
  }

  public UnaryCallable<BatchCreateUsersRequest, BatchCreateUsersResponse>
      batchCreateUsersCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateUsersCallable()");
  }

  public UnaryCallable<BatchActivateUsersRequest, BatchActivateUsersResponse>
      batchActivateUsersCallable() {
    throw new UnsupportedOperationException("Not implemented: batchActivateUsersCallable()");
  }

  public UnaryCallable<BatchDeactivateUsersRequest, BatchDeactivateUsersResponse>
      batchDeactivateUsersCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeactivateUsersCallable()");
  }

  public UnaryCallable<UpdateUserRequest, User> updateUserCallable() {
    throw new UnsupportedOperationException("Not implemented: updateUserCallable()");
  }

  public UnaryCallable<BatchUpdateUsersRequest, BatchUpdateUsersResponse>
      batchUpdateUsersCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateUsersCallable()");
  }

  @Override
  public abstract void close();
}
