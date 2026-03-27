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

import static com.google.showcase.v1beta1.ComplianceClient.ListLocationsPagedResponse;

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
import com.google.showcase.v1beta1.EnumRequest;
import com.google.showcase.v1beta1.EnumResponse;
import com.google.showcase.v1beta1.RepeatRequest;
import com.google.showcase.v1beta1.RepeatResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Compliance service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class ComplianceStub implements BackgroundResource {

  public UnaryCallable<RepeatRequest, RepeatResponse> repeatDataBodyCallable() {
    throw new UnsupportedOperationException("Not implemented: repeatDataBodyCallable()");
  }

  public UnaryCallable<RepeatRequest, RepeatResponse> repeatDataBodyInfoCallable() {
    throw new UnsupportedOperationException("Not implemented: repeatDataBodyInfoCallable()");
  }

  public UnaryCallable<RepeatRequest, RepeatResponse> repeatDataQueryCallable() {
    throw new UnsupportedOperationException("Not implemented: repeatDataQueryCallable()");
  }

  public UnaryCallable<RepeatRequest, RepeatResponse> repeatDataSimplePathCallable() {
    throw new UnsupportedOperationException("Not implemented: repeatDataSimplePathCallable()");
  }

  public UnaryCallable<RepeatRequest, RepeatResponse> repeatDataPathResourceCallable() {
    throw new UnsupportedOperationException("Not implemented: repeatDataPathResourceCallable()");
  }

  public UnaryCallable<RepeatRequest, RepeatResponse> repeatDataPathTrailingResourceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: repeatDataPathTrailingResourceCallable()");
  }

  public UnaryCallable<RepeatRequest, RepeatResponse> repeatDataBodyPutCallable() {
    throw new UnsupportedOperationException("Not implemented: repeatDataBodyPutCallable()");
  }

  public UnaryCallable<RepeatRequest, RepeatResponse> repeatDataBodyPatchCallable() {
    throw new UnsupportedOperationException("Not implemented: repeatDataBodyPatchCallable()");
  }

  public UnaryCallable<EnumRequest, EnumResponse> getEnumCallable() {
    throw new UnsupportedOperationException("Not implemented: getEnumCallable()");
  }

  public UnaryCallable<EnumResponse, EnumResponse> verifyEnumCallable() {
    throw new UnsupportedOperationException("Not implemented: verifyEnumCallable()");
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
