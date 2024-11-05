/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.stub;

import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StreamController;
import java.util.function.Function;

/** Callable to help crossing api boundary lines between models and protos */
class TransformingServerStreamingCallable<OuterReqT, OuterRespT, InnerReqT, InnerRespT>
    extends ServerStreamingCallable<OuterReqT, OuterRespT> {
  private final ServerStreamingCallable<InnerReqT, InnerRespT> inner;
  private final Function<OuterReqT, InnerReqT> requestTransformer;
  private final Function<InnerRespT, OuterRespT> responseTransformer;

  public TransformingServerStreamingCallable(
      ServerStreamingCallable<InnerReqT, InnerRespT> inner,
      Function<OuterReqT, InnerReqT> requestTransformer,
      Function<InnerRespT, OuterRespT> responseTransformer) {
    this.inner = inner;
    this.requestTransformer = requestTransformer;
    this.responseTransformer = responseTransformer;
  }

  @Override
  public void call(
      OuterReqT outerReqT,
      ResponseObserver<OuterRespT> outerObserver,
      ApiCallContext apiCallContext) {
    InnerReqT innerReq = requestTransformer.apply(outerReqT);

    inner.call(
        innerReq,
        new ResponseObserver<InnerRespT>() {
          @Override
          public void onStart(StreamController streamController) {
            outerObserver.onStart(streamController);
          }

          @Override
          public void onResponse(InnerRespT innerResp) {
            outerObserver.onResponse(responseTransformer.apply(innerResp));
          }

          @Override
          public void onError(Throwable throwable) {
            outerObserver.onError(throwable);
          }

          @Override
          public void onComplete() {
            outerObserver.onComplete();
          }
        },
        apiCallContext);
  }
}
