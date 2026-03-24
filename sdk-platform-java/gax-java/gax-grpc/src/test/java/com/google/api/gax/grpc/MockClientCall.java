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
package com.google.api.gax.grpc;

import io.grpc.ClientCall;
import io.grpc.Metadata;
import io.grpc.Status;
import javax.annotation.Nullable;

public class MockClientCall<RequestT, ResponseT> extends ClientCall<RequestT, ResponseT> {

  private ResponseT response;
  private Listener<ResponseT> responseListener;
  private Metadata headers;
  private Status status;

  public MockClientCall(ResponseT response, Status status) {
    this.response = response;
    this.status = status;
  }

  @Override
  public synchronized void start(Listener<ResponseT> responseListener, Metadata headers) {
    this.responseListener = responseListener;
    this.headers = headers;
  }

  @Override
  public void request(int numMessages) {}

  @Override
  public void cancel(@Nullable String message, @Nullable Throwable cause) {}

  @Override
  public void halfClose() {}

  @Override
  public void sendMessage(RequestT message) {
    responseListener.onHeaders(headers);
    responseListener.onMessage(response);
    responseListener.onClose(status, headers);
  }
}
