/*
 * Copyright 2016 Google LLC
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

import com.google.common.base.Preconditions;

/**
 * BatchedRequestIssuer receives a response or an exception and waits to set the given batchedFuture
 * until sendResult() is called.
 *
 * <p>This class is designed to be used by generated code.
 */
public final class BatchedRequestIssuer<ResponseT> {
  private final BatchedFuture<ResponseT> batchedFuture;
  private final long messageCount;
  private ResponseT responseToSend;
  private boolean hasResponse;
  private Throwable throwableToSend;

  public BatchedRequestIssuer(BatchedFuture<ResponseT> batchedFuture, long messageCount) {
    this.batchedFuture = batchedFuture;
    this.messageCount = messageCount;
    this.responseToSend = null;
    this.throwableToSend = null;
  }

  public long getMessageCount() {
    return messageCount;
  }

  /**
   * Set the response to set on the batched future. If this is called, setException cannot be
   * called.
   */
  public void setResponse(ResponseT response) {
    Preconditions.checkState(throwableToSend == null, "Cannot set both exception and response");
    hasResponse = true;
    responseToSend = response;
  }

  /**
   * Set the exception to set on the batched future. If this is called, setResponse cannot be
   * called.
   */
  public void setException(Throwable throwable) {
    Preconditions.checkState(!hasResponse, "Cannot set both exception and response");
    throwableToSend = throwable;
  }

  /** Sends back the result that was stored by either setResponse or setException */
  public void sendResult() {
    if (hasResponse) {
      batchedFuture.set(responseToSend);
    } else if (throwableToSend != null) {
      batchedFuture.setException(throwableToSend);
    } else {
      throw new IllegalStateException(
          "Neither response nor exception were set in BatchedRequestIssuer");
    }
  }
}
