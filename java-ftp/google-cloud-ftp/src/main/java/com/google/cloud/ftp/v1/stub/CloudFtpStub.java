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

package com.google.cloud.ftp.v1.stub;

import static com.google.cloud.ftp.v1.CloudFtpClient.ListLocationsPagedResponse;
import static com.google.cloud.ftp.v1.CloudFtpClient.ListServersPagedResponse;
import static com.google.cloud.ftp.v1.CloudFtpClient.ListUsersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.stub.OperationsStub;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.ftp.v1.CreateServerRequest;
import com.google.cloud.ftp.v1.CreateUserRequest;
import com.google.cloud.ftp.v1.DeleteServerRequest;
import com.google.cloud.ftp.v1.DeleteUserRequest;
import com.google.cloud.ftp.v1.GetServerRequest;
import com.google.cloud.ftp.v1.GetUserRequest;
import com.google.cloud.ftp.v1.ListServersRequest;
import com.google.cloud.ftp.v1.ListServersResponse;
import com.google.cloud.ftp.v1.ListUsersRequest;
import com.google.cloud.ftp.v1.ListUsersResponse;
import com.google.cloud.ftp.v1.OperationMetadata;
import com.google.cloud.ftp.v1.Server;
import com.google.cloud.ftp.v1.StartServerRequest;
import com.google.cloud.ftp.v1.StopServerRequest;
import com.google.cloud.ftp.v1.UpdateServerRequest;
import com.google.cloud.ftp.v1.UpdateUserRequest;
import com.google.cloud.ftp.v1.User;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CloudFtp service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class CloudFtpStub implements BackgroundResource {

  public @Nullable OperationsStub getHttpJsonOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getHttpJsonOperationsStub()");
  }

  public UnaryCallable<ListServersRequest, ListServersPagedResponse> listServersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listServersPagedCallable()");
  }

  public UnaryCallable<ListServersRequest, ListServersResponse> listServersCallable() {
    throw new UnsupportedOperationException("Not implemented: listServersCallable()");
  }

  public UnaryCallable<GetServerRequest, Server> getServerCallable() {
    throw new UnsupportedOperationException("Not implemented: getServerCallable()");
  }

  public OperationCallable<CreateServerRequest, Server, OperationMetadata>
      createServerOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createServerOperationCallable()");
  }

  public UnaryCallable<CreateServerRequest, Operation> createServerCallable() {
    throw new UnsupportedOperationException("Not implemented: createServerCallable()");
  }

  public OperationCallable<UpdateServerRequest, Server, OperationMetadata>
      updateServerOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateServerOperationCallable()");
  }

  public UnaryCallable<UpdateServerRequest, Operation> updateServerCallable() {
    throw new UnsupportedOperationException("Not implemented: updateServerCallable()");
  }

  public OperationCallable<DeleteServerRequest, Empty, OperationMetadata>
      deleteServerOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteServerOperationCallable()");
  }

  public UnaryCallable<DeleteServerRequest, Operation> deleteServerCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteServerCallable()");
  }

  public UnaryCallable<ListUsersRequest, ListUsersPagedResponse> listUsersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listUsersPagedCallable()");
  }

  public UnaryCallable<ListUsersRequest, ListUsersResponse> listUsersCallable() {
    throw new UnsupportedOperationException("Not implemented: listUsersCallable()");
  }

  public UnaryCallable<GetUserRequest, User> getUserCallable() {
    throw new UnsupportedOperationException("Not implemented: getUserCallable()");
  }

  public OperationCallable<CreateUserRequest, User, OperationMetadata>
      createUserOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createUserOperationCallable()");
  }

  public UnaryCallable<CreateUserRequest, Operation> createUserCallable() {
    throw new UnsupportedOperationException("Not implemented: createUserCallable()");
  }

  public OperationCallable<UpdateUserRequest, User, OperationMetadata>
      updateUserOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateUserOperationCallable()");
  }

  public UnaryCallable<UpdateUserRequest, Operation> updateUserCallable() {
    throw new UnsupportedOperationException("Not implemented: updateUserCallable()");
  }

  public OperationCallable<DeleteUserRequest, Empty, OperationMetadata>
      deleteUserOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteUserOperationCallable()");
  }

  public UnaryCallable<DeleteUserRequest, Operation> deleteUserCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteUserCallable()");
  }

  public OperationCallable<StartServerRequest, Server, OperationMetadata>
      startServerOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: startServerOperationCallable()");
  }

  public UnaryCallable<StartServerRequest, Operation> startServerCallable() {
    throw new UnsupportedOperationException("Not implemented: startServerCallable()");
  }

  public OperationCallable<StopServerRequest, Server, OperationMetadata>
      stopServerOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: stopServerOperationCallable()");
  }

  public UnaryCallable<StopServerRequest, Operation> stopServerCallable() {
    throw new UnsupportedOperationException("Not implemented: stopServerCallable()");
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

  @Override
  public abstract void close();
}
