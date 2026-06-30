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

import static com.google.showcase.v1beta1.EchoClient.ListLocationsPagedResponse;
import static com.google.showcase.v1beta1.EchoClient.PagedExpandLegacyMappedPagedResponse;
import static com.google.showcase.v1beta1.EchoClient.PagedExpandPagedResponse;

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
import com.google.showcase.v1beta1.BlockRequest;
import com.google.showcase.v1beta1.BlockResponse;
import com.google.showcase.v1beta1.EchoErrorDetailsRequest;
import com.google.showcase.v1beta1.EchoErrorDetailsResponse;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.EchoResponse;
import com.google.showcase.v1beta1.ExpandRequest;
import com.google.showcase.v1beta1.FailEchoWithDetailsRequest;
import com.google.showcase.v1beta1.FailEchoWithDetailsResponse;
import com.google.showcase.v1beta1.PagedExpandLegacyMappedResponse;
import com.google.showcase.v1beta1.PagedExpandLegacyRequest;
import com.google.showcase.v1beta1.PagedExpandRequest;
import com.google.showcase.v1beta1.PagedExpandResponse;
import com.google.showcase.v1beta1.WaitMetadata;
import com.google.showcase.v1beta1.WaitRequest;
import com.google.showcase.v1beta1.WaitResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Echo service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class EchoStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<EchoRequest, EchoResponse> echoCallable() {
    throw new UnsupportedOperationException("Not implemented: echoCallable()");
  }

  public UnaryCallable<EchoErrorDetailsRequest, EchoErrorDetailsResponse>
      echoErrorDetailsCallable() {
    throw new UnsupportedOperationException("Not implemented: echoErrorDetailsCallable()");
  }

  public UnaryCallable<FailEchoWithDetailsRequest, FailEchoWithDetailsResponse>
      failEchoWithDetailsCallable() {
    throw new UnsupportedOperationException("Not implemented: failEchoWithDetailsCallable()");
  }

  public ServerStreamingCallable<ExpandRequest, EchoResponse> expandCallable() {
    throw new UnsupportedOperationException("Not implemented: expandCallable()");
  }

  public ClientStreamingCallable<EchoRequest, EchoResponse> collectCallable() {
    throw new UnsupportedOperationException("Not implemented: collectCallable()");
  }

  public BidiStreamingCallable<EchoRequest, EchoResponse> chatCallable() {
    throw new UnsupportedOperationException("Not implemented: chatCallable()");
  }

  public UnaryCallable<PagedExpandRequest, PagedExpandPagedResponse> pagedExpandPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: pagedExpandPagedCallable()");
  }

  public UnaryCallable<PagedExpandRequest, PagedExpandResponse> pagedExpandCallable() {
    throw new UnsupportedOperationException("Not implemented: pagedExpandCallable()");
  }

  public UnaryCallable<PagedExpandLegacyRequest, PagedExpandResponse> pagedExpandLegacyCallable() {
    throw new UnsupportedOperationException("Not implemented: pagedExpandLegacyCallable()");
  }

  public UnaryCallable<PagedExpandRequest, PagedExpandLegacyMappedPagedResponse>
      pagedExpandLegacyMappedPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: pagedExpandLegacyMappedPagedCallable()");
  }

  public UnaryCallable<PagedExpandRequest, PagedExpandLegacyMappedResponse>
      pagedExpandLegacyMappedCallable() {
    throw new UnsupportedOperationException("Not implemented: pagedExpandLegacyMappedCallable()");
  }

  public OperationCallable<WaitRequest, WaitResponse, WaitMetadata> waitOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: waitOperationCallable()");
  }

  public UnaryCallable<WaitRequest, Operation> waitCallable() {
    throw new UnsupportedOperationException("Not implemented: waitCallable()");
  }

  public UnaryCallable<BlockRequest, BlockResponse> blockCallable() {
    throw new UnsupportedOperationException("Not implemented: blockCallable()");
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
