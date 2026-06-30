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
 * The marker exception thrown when a timeout is exceeded.
 *
 * <p>This error can be thrown under 2 circumstances:
 *
 * <ul>
 *   <li>A wait timeout has exceeded, which means that the client timed out waiting for the next
 *       message from the server. In this case, {@link #isRetryable()} will be true.
 *   <li>An idle timeout has exceeded, which means that the stream is using manual flow control and
 *       the caller has not called {@link StreamController#request(int)} (in case of callback api)
 *       or next on {@link ServerStream#iterator()} (in case of blocking api).
 * </ul>
 */
public class WatchdogTimeoutException extends ApiException {
  private static final long serialVersionUID = -777463630112442086L;

  public static final StatusCode LOCAL_ABORTED_STATUS_CODE =
      new StatusCode() {
        @Override
        public Code getCode() {
          return Code.ABORTED;
        }

        @Override
        public Object getTransportCode() {
          return null;
        }
      };

  /** Package private for internal use. */
  WatchdogTimeoutException(String message, boolean retry) {
    super(message, null, LOCAL_ABORTED_STATUS_CODE, retry);
  }
}
