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

package com.google.cloud.bigqueryconnection.v1.stub;

import static com.google.cloud.bigqueryconnection.v1.ConnectionServiceClient.ListConnectionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.connection.v1.Connection;
import com.google.cloud.bigquery.connection.v1.CreateConnectionRequest;
import com.google.cloud.bigquery.connection.v1.DeleteConnectionRequest;
import com.google.cloud.bigquery.connection.v1.GetConnectionRequest;
import com.google.cloud.bigquery.connection.v1.ListConnectionsRequest;
import com.google.cloud.bigquery.connection.v1.ListConnectionsResponse;
import com.google.cloud.bigquery.connection.v1.UpdateConnectionRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ConnectionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ConnectionServiceStub implements BackgroundResource {

  public UnaryCallable<CreateConnectionRequest, Connection> createConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: createConnectionCallable()");
  }

  public UnaryCallable<GetConnectionRequest, Connection> getConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: getConnectionCallable()");
  }

  public UnaryCallable<ListConnectionsRequest, ListConnectionsPagedResponse>
      listConnectionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listConnectionsPagedCallable()");
  }

  public UnaryCallable<ListConnectionsRequest, ListConnectionsResponse> listConnectionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listConnectionsCallable()");
  }

  public UnaryCallable<UpdateConnectionRequest, Connection> updateConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateConnectionCallable()");
  }

  public UnaryCallable<DeleteConnectionRequest, Empty> deleteConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteConnectionCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
