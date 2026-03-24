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
package com.google.api.gax.rpc;

/**
 * A wrapper used to send requests to the server.
 *
 * <p>After sending requests, users must either call {@link #closeSend()} or {@link
 * #closeSendWithError(Throwable)} on the stream. The error, if any, will be propagated to the
 * server.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * ClientStream<String> stream = ...;
 * List<String> lines = getLinesFromFile();
 * for (String line : lines) {
 *   stream.send(line);
 * }
 * stream.closeSend();
 * }</pre>
 *
 * @param <RequestT> The type of each request.
 */
public interface ClientStream<RequestT> {
  /** Sends a request to the server. It is an error to call this if the stream is already closed. */
  void send(RequestT request);

  /**
   * Closes the stream with an error. If called, this must be the last call on this {@code
   * ClientStream}.
   */
  void closeSendWithError(Throwable t);

  /**
   * Closes the stream. If called, this must be the last call on this {@code ClientStream}.
   *
   * <p>Note that if {@code close()} itself throws, a further call to {@code closeSendWithError} is
   * not allowed.
   */
  void closeSend();

  /**
   * Reports whether a new request can be sent without excessive buffering.
   *
   * <p>This is only an optimization hint to the user. It is correct, if suboptimal, to call {@code
   * send} if {@code isSendReady} returns false.
   */
  boolean isSendReady();
}
