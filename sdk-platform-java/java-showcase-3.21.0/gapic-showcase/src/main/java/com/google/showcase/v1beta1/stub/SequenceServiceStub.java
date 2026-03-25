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

import static com.google.showcase.v1beta1.SequenceServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
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
import com.google.protobuf.Empty;
import com.google.showcase.v1beta1.AttemptSequenceRequest;
import com.google.showcase.v1beta1.AttemptStreamingSequenceRequest;
import com.google.showcase.v1beta1.AttemptStreamingSequenceResponse;
import com.google.showcase.v1beta1.CreateSequenceRequest;
import com.google.showcase.v1beta1.CreateStreamingSequenceRequest;
import com.google.showcase.v1beta1.GetSequenceReportRequest;
import com.google.showcase.v1beta1.GetStreamingSequenceReportRequest;
import com.google.showcase.v1beta1.Sequence;
import com.google.showcase.v1beta1.SequenceReport;
import com.google.showcase.v1beta1.StreamingSequence;
import com.google.showcase.v1beta1.StreamingSequenceReport;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SequenceService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class SequenceServiceStub implements BackgroundResource {

  public UnaryCallable<CreateSequenceRequest, Sequence> createSequenceCallable() {
    throw new UnsupportedOperationException("Not implemented: createSequenceCallable()");
  }

  public UnaryCallable<CreateStreamingSequenceRequest, StreamingSequence>
      createStreamingSequenceCallable() {
    throw new UnsupportedOperationException("Not implemented: createStreamingSequenceCallable()");
  }

  public UnaryCallable<GetSequenceReportRequest, SequenceReport> getSequenceReportCallable() {
    throw new UnsupportedOperationException("Not implemented: getSequenceReportCallable()");
  }

  public UnaryCallable<GetStreamingSequenceReportRequest, StreamingSequenceReport>
      getStreamingSequenceReportCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getStreamingSequenceReportCallable()");
  }

  public UnaryCallable<AttemptSequenceRequest, Empty> attemptSequenceCallable() {
    throw new UnsupportedOperationException("Not implemented: attemptSequenceCallable()");
  }

  public ServerStreamingCallable<AttemptStreamingSequenceRequest, AttemptStreamingSequenceResponse>
      attemptStreamingSequenceCallable() {
    throw new UnsupportedOperationException("Not implemented: attemptStreamingSequenceCallable()");
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
