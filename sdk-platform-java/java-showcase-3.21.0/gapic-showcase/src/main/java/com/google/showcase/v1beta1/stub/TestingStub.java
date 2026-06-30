/*
 * Copyright 2025 Google LLC
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

import static com.google.showcase.v1beta1.TestingClient.ListLocationsPagedResponse;
import static com.google.showcase.v1beta1.TestingClient.ListSessionsPagedResponse;
import static com.google.showcase.v1beta1.TestingClient.ListTestsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
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
import com.google.protobuf.Empty;
import com.google.showcase.v1beta1.CreateSessionRequest;
import com.google.showcase.v1beta1.DeleteSessionRequest;
import com.google.showcase.v1beta1.DeleteTestRequest;
import com.google.showcase.v1beta1.GetSessionRequest;
import com.google.showcase.v1beta1.ListSessionsRequest;
import com.google.showcase.v1beta1.ListSessionsResponse;
import com.google.showcase.v1beta1.ListTestsRequest;
import com.google.showcase.v1beta1.ListTestsResponse;
import com.google.showcase.v1beta1.ReportSessionRequest;
import com.google.showcase.v1beta1.ReportSessionResponse;
import com.google.showcase.v1beta1.Session;
import com.google.showcase.v1beta1.VerifyTestRequest;
import com.google.showcase.v1beta1.VerifyTestResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Testing service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class TestingStub implements BackgroundResource {

  public UnaryCallable<CreateSessionRequest, Session> createSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: createSessionCallable()");
  }

  public UnaryCallable<GetSessionRequest, Session> getSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: getSessionCallable()");
  }

  public UnaryCallable<ListSessionsRequest, ListSessionsPagedResponse> listSessionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSessionsPagedCallable()");
  }

  public UnaryCallable<ListSessionsRequest, ListSessionsResponse> listSessionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSessionsCallable()");
  }

  public UnaryCallable<DeleteSessionRequest, Empty> deleteSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSessionCallable()");
  }

  public UnaryCallable<ReportSessionRequest, ReportSessionResponse> reportSessionCallable() {
    throw new UnsupportedOperationException("Not implemented: reportSessionCallable()");
  }

  public UnaryCallable<ListTestsRequest, ListTestsPagedResponse> listTestsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTestsPagedCallable()");
  }

  public UnaryCallable<ListTestsRequest, ListTestsResponse> listTestsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTestsCallable()");
  }

  public UnaryCallable<DeleteTestRequest, Empty> deleteTestCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTestCallable()");
  }

  public UnaryCallable<VerifyTestRequest, VerifyTestResponse> verifyTestCallable() {
    throw new UnsupportedOperationException("Not implemented: verifyTestCallable()");
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
