/*
 * Copyright 2022 Google LLC
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
package com.google.api.gax.httpjson;

import javax.annotation.Nullable;

// This class mimics the structure and behavior of the corresponding ClientCall from gRPC package as
// closely as possible.
/**
 * An instance of a call to a remote method. A call will send zero or more request messages to the
 * server and receive zero or more response messages back.
 *
 * <p>Instances are created by a {@link HttpJsonChannel} and used by stubs to invoke their remote
 * behavior.
 *
 * <p>{@link #start} must be called prior to calling any other methods, with the exception of {@link
 * #cancel}. Whereas {@link #cancel} must not be followed by any other methods, but can be called
 * more than once, while only the first one has effect.
 *
 * <p>Methods are potentially blocking but are designed to execute quickly. The implementations of
 * this class are expected to be thread-safe.
 *
 * <p>There is a race between {@link #cancel} and the completion/failure of the RPC in other ways.
 * If {@link #cancel} won the race, {@link HttpJsonClientCall.Listener#onClose Listener.onClose()}
 * is called with {@code statusCode} corresponding to {@link
 * com.google.api.gax.rpc.StatusCode.Code#CANCELLED CANCELLED}. Otherwise, {@link
 * HttpJsonClientCall.Listener#onClose Listener.onClose()} is called with whatever status the RPC
 * was finished. We ensure that at most one is called.
 *
 * @param <RequestT> type of message sent to the server
 * @param <ResponseT> type of message received one or more times from the server
 */
public abstract class HttpJsonClientCall<RequestT, ResponseT> {
  /**
   * Callbacks for receiving metadata, response messages and completion status from the server.
   *
   * <p>Implementations are discouraged to block for extended periods of time. Implementations are
   * not required to be thread-safe, but they must not be thread-hostile. The caller is free to call
   * an instance from multiple threads, but only one call simultaneously.
   */
  public abstract static class Listener<T> {
    /**
     * The response headers have been received. Headers always precede messages.
     *
     * @param responseHeaders containing metadata sent by the server at the start of the response
     */
    public void onHeaders(HttpJsonMetadata responseHeaders) {}

    /**
     * A response message has been received. May be called zero or more times depending on whether
     * the call response is empty, a single message or a stream of messages.
     *
     * @param message returned by the server
     */
    public void onMessage(T message) {}

    /**
     * The ClientCall has been closed. Any additional calls to the {@code ClientCall} will not be
     * processed by the server. No further receiving will occur and no further notifications will be
     * made.
     *
     * <p>This method should not throw. If this method throws, there is no way to be notified of the
     * exception. Implementations should therefore be careful of exceptions which can accidentally
     * leak resources.
     *
     * @param statusCode the HTTP status code representing the result of the remote call
     * @param trailers metadata provided at call completion
     */
    public void onClose(int statusCode, HttpJsonMetadata trailers) {}
  }

  /**
   * Start a call, using {@code responseListener} for processing response messages.
   *
   * <p>It must be called prior to any other method on this class, except for {@link #cancel} which
   * may be called at any time.
   *
   * @param responseListener receives response messages
   * @param requestHeaders which can contain extra call metadata, e.g. authentication credentials.
   */
  public abstract void start(Listener<ResponseT> responseListener, HttpJsonMetadata requestHeaders);

  /**
   * Requests up to the given number of messages from the call to be delivered to {@link
   * HttpJsonClientCall.Listener#onMessage(Object)}. No additional messages will be delivered.
   *
   * <p>Message delivery is guaranteed to be sequential in the order received. In addition, the
   * listener methods will not be accessed concurrently. While it is not guaranteed that the same
   * thread will always be used, it is guaranteed that only a single thread will access the listener
   * at a time.
   *
   * <p>If called multiple times, the number of messages able to delivered will be the sum of the
   * calls.
   *
   * <p>This method is safe to call from multiple threads without external synchronization.
   *
   * @param numMessages the requested number of messages to be delivered to the listener. Must be
   *     non-negative.
   */
  public abstract void request(int numMessages);

  /**
   * Prevent any further processing for this {@code HttpJsonClientCall}. No further messages may be
   * sent or will be received. The server is not informed of cancellations. Cancellation is
   * permitted even if previously {@link #halfClose}d. Cancelling an already {@code cancel()}ed
   * {@code ClientCall} has no effect.
   *
   * <p>No other methods on this class can be called after this method has been called.
   *
   * @param message if not {@code null}, will appear as the description of the CANCELLED status
   * @param cause if not {@code null}, will appear as the cause of the CANCELLED status
   */
  public abstract void cancel(@Nullable String message, @Nullable Throwable cause);

  /**
   * Close the call for request message sending. Incoming response messages are unaffected. This
   * should be called when no more messages will be sent from the client.
   */
  public abstract void halfClose();

  /**
   * Send a request message to the server. May be called zero or more times but for unary and server
   * streaming calls it must be called not more than once.
   *
   * @param message message to be sent to the server.
   */
  public abstract void sendMessage(RequestT message);
}
