/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.vertexai.api.stub;

import com.google.api.HttpBody;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vertexai.api.DirectPredictRequest;
import com.google.cloud.vertexai.api.DirectPredictResponse;
import com.google.cloud.vertexai.api.DirectRawPredictRequest;
import com.google.cloud.vertexai.api.DirectRawPredictResponse;
import com.google.cloud.vertexai.api.ExplainRequest;
import com.google.cloud.vertexai.api.ExplainResponse;
import com.google.cloud.vertexai.api.GenerateContentRequest;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.api.PredictRequest;
import com.google.cloud.vertexai.api.PredictResponse;
import com.google.cloud.vertexai.api.PredictionServiceClient.ListLocationsPagedResponse;
import com.google.cloud.vertexai.api.RawPredictRequest;
import com.google.cloud.vertexai.api.StreamDirectPredictRequest;
import com.google.cloud.vertexai.api.StreamDirectPredictResponse;
import com.google.cloud.vertexai.api.StreamDirectRawPredictRequest;
import com.google.cloud.vertexai.api.StreamDirectRawPredictResponse;
import com.google.cloud.vertexai.api.StreamRawPredictRequest;
import com.google.cloud.vertexai.api.StreamingPredictRequest;
import com.google.cloud.vertexai.api.StreamingPredictResponse;
import com.google.cloud.vertexai.api.StreamingRawPredictRequest;
import com.google.cloud.vertexai.api.StreamingRawPredictResponse;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the PredictionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class PredictionServiceStub implements BackgroundResource {

  public UnaryCallable<PredictRequest, PredictResponse> predictCallable() {
    throw new UnsupportedOperationException("Not implemented: predictCallable()");
  }

  public UnaryCallable<RawPredictRequest, HttpBody> rawPredictCallable() {
    throw new UnsupportedOperationException("Not implemented: rawPredictCallable()");
  }

  public ServerStreamingCallable<StreamRawPredictRequest, HttpBody> streamRawPredictCallable() {
    throw new UnsupportedOperationException("Not implemented: streamRawPredictCallable()");
  }

  public UnaryCallable<DirectPredictRequest, DirectPredictResponse> directPredictCallable() {
    throw new UnsupportedOperationException("Not implemented: directPredictCallable()");
  }

  public UnaryCallable<DirectRawPredictRequest, DirectRawPredictResponse>
      directRawPredictCallable() {
    throw new UnsupportedOperationException("Not implemented: directRawPredictCallable()");
  }

  public BidiStreamingCallable<StreamDirectPredictRequest, StreamDirectPredictResponse>
      streamDirectPredictCallable() {
    throw new UnsupportedOperationException("Not implemented: streamDirectPredictCallable()");
  }

  public BidiStreamingCallable<StreamDirectRawPredictRequest, StreamDirectRawPredictResponse>
      streamDirectRawPredictCallable() {
    throw new UnsupportedOperationException("Not implemented: streamDirectRawPredictCallable()");
  }

  public BidiStreamingCallable<StreamingPredictRequest, StreamingPredictResponse>
      streamingPredictCallable() {
    throw new UnsupportedOperationException("Not implemented: streamingPredictCallable()");
  }

  public ServerStreamingCallable<StreamingPredictRequest, StreamingPredictResponse>
      serverStreamingPredictCallable() {
    throw new UnsupportedOperationException("Not implemented: serverStreamingPredictCallable()");
  }

  public BidiStreamingCallable<StreamingRawPredictRequest, StreamingRawPredictResponse>
      streamingRawPredictCallable() {
    throw new UnsupportedOperationException("Not implemented: streamingRawPredictCallable()");
  }

  public UnaryCallable<ExplainRequest, ExplainResponse> explainCallable() {
    throw new UnsupportedOperationException("Not implemented: explainCallable()");
  }

  public UnaryCallable<GenerateContentRequest, GenerateContentResponse> generateContentCallable() {
    throw new UnsupportedOperationException("Not implemented: generateContentCallable()");
  }

  public ServerStreamingCallable<GenerateContentRequest, GenerateContentResponse>
      streamGenerateContentCallable() {
    throw new UnsupportedOperationException("Not implemented: streamGenerateContentCallable()");
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
