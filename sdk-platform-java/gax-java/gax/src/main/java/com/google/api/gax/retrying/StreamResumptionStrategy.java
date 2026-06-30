/*
 * Copyright 2018 Google LLC
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
package com.google.api.gax.retrying;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * This is part of the server streaming retry api. Its implementers are responsible for tracking the
 * progress of the stream and calculating a request to resume it in case of an error.
 *
 * <p>Implementations don't have to be threadsafe because all of the calls will be serialized.
 */
public interface StreamResumptionStrategy<RequestT, ResponseT> {

  /** Creates a new instance of this StreamResumptionStrategy without accumulated state */
  @Nonnull
  StreamResumptionStrategy<RequestT, ResponseT> createNew();

  /**
   * Called by the {@code ServerStreamingAttemptCallable} when a response has been successfully
   * received. This method accomplishes two goals:
   *
   * <ol>
   *   <li>It allows the strategy implementation to update its internal state so that it can compose
   *       the resume request
   *   <li>It allows the strategy to alter the incoming responses to adjust for after resume. For
   *       example, if the responses are numbered sequentially from the start of the stream, upon
   *       resume, the strategy could rewrite the messages to continue the sequence from where it
   *       left off. Please note that all messages (even for the first attempt) will be passed
   *       through this method.
   * </ol>
   */
  @Nonnull
  ResponseT processResponse(ResponseT response);

  /**
   * Called when a stream needs to be restarted, the implementation should generate a request that
   * will yield a new stream whose first response would come right after the last response received
   * by processResponse.
   *
   * @return A request that can be used to resume the stream.
   */
  @Nullable
  RequestT getResumeRequest(RequestT originalRequest);

  /** If a resume request can be created. */
  boolean canResume();
}
