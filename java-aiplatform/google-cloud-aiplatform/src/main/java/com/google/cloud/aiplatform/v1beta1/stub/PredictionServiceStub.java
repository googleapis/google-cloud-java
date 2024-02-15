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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.PredictionServiceClient.ListLocationsPagedResponse;

import com.google.api.HttpBody;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.CountTokensRequest;
import com.google.cloud.aiplatform.v1beta1.CountTokensResponse;
import com.google.cloud.aiplatform.v1beta1.DirectPredictRequest;
import com.google.cloud.aiplatform.v1beta1.DirectPredictResponse;
import com.google.cloud.aiplatform.v1beta1.DirectRawPredictRequest;
import com.google.cloud.aiplatform.v1beta1.DirectRawPredictResponse;
import com.google.cloud.aiplatform.v1beta1.ExplainRequest;
import com.google.cloud.aiplatform.v1beta1.ExplainResponse;
import com.google.cloud.aiplatform.v1beta1.GenerateContentRequest;
import com.google.cloud.aiplatform.v1beta1.GenerateContentResponse;
import com.google.cloud.aiplatform.v1beta1.PredictRequest;
import com.google.cloud.aiplatform.v1beta1.PredictResponse;
import com.google.cloud.aiplatform.v1beta1.RawPredictRequest;
import com.google.cloud.aiplatform.v1beta1.StreamDirectPredictRequest;
import com.google.cloud.aiplatform.v1beta1.StreamDirectPredictResponse;
import com.google.cloud.aiplatform.v1beta1.StreamDirectRawPredictRequest;
import com.google.cloud.aiplatform.v1beta1.StreamDirectRawPredictResponse;
import com.google.cloud.aiplatform.v1beta1.StreamingPredictRequest;
import com.google.cloud.aiplatform.v1beta1.StreamingPredictResponse;
import com.google.cloud.aiplatform.v1beta1.StreamingRawPredictRequest;
import com.google.cloud.aiplatform.v1beta1.StreamingRawPredictResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
@BetaApi
@Generated("by gapic-generator-java")
public abstract class PredictionServiceStub implements BackgroundResource {

  public UnaryCallable<PredictRequest, PredictResponse> predictCallable() {
    throw new UnsupportedOperationException("Not implemented: predictCallable()");
  }

  public UnaryCallable<RawPredictRequest, HttpBody> rawPredictCallable() {
    throw new UnsupportedOperationException("Not implemented: rawPredictCallable()");
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

  public UnaryCallable<CountTokensRequest, CountTokensResponse> countTokensCallable() {
    throw new UnsupportedOperationException("Not implemented: countTokensCallable()");
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
