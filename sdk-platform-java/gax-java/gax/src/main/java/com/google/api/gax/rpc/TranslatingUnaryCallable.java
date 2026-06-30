/*
 * Copyright 2017 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.rpc;

import static com.google.common.util.concurrent.MoreExecutors.directExecutor;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;

/**
 * A UnaryCallable that translates request types and response types using the given transformers.
 */
public class TranslatingUnaryCallable<InnerRequestT, InnerResponseT, OuterRequestT, OuterResponseT>
    extends UnaryCallable<OuterRequestT, OuterResponseT> {
  private final UnaryCallable<InnerRequestT, InnerResponseT> innerUnaryCallable;
  private final ApiFunction<OuterRequestT, InnerRequestT> requestTransformer;
  private final ApiFunction<InnerResponseT, OuterResponseT> responseTransformer;

  private TranslatingUnaryCallable(
      UnaryCallable<InnerRequestT, InnerResponseT> innerUnaryCallable,
      ApiFunction<OuterRequestT, InnerRequestT> requestTransformer,
      ApiFunction<InnerResponseT, OuterResponseT> responseTransformer) {
    this.innerUnaryCallable = innerUnaryCallable;
    this.requestTransformer = requestTransformer;
    this.responseTransformer = responseTransformer;
  }

  @Override
  public ApiFuture<OuterResponseT> futureCall(OuterRequestT request, ApiCallContext context) {
    InnerRequestT innerRequest = requestTransformer.apply(request);
    return ApiFutures.transform(
        innerUnaryCallable.futureCall(innerRequest, context),
        responseTransformer,
        directExecutor());
  }

  public static <InnerRequestT, InnerResponseT, OuterRequestT, OuterResponseT>
      TranslatingUnaryCallable<InnerRequestT, InnerResponseT, OuterRequestT, OuterResponseT> create(
          UnaryCallable<InnerRequestT, InnerResponseT> innerUnaryCallable,
          ApiFunction<OuterRequestT, InnerRequestT> requestTransformer,
          ApiFunction<InnerResponseT, OuterResponseT> responseTransformer) {
    return new TranslatingUnaryCallable<>(
        innerUnaryCallable, requestTransformer, responseTransformer);
  }
}
