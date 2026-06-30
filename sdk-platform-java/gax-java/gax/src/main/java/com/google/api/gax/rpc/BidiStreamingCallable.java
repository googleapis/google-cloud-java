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
 * A BidiStreamingCallable is an immutable object which is capable of making RPC calls to
 * bidirectional streaming API methods. Not all transports support streaming.
 *
 * <p>It is considered advanced usage for a user to create a BidiStreamingCallable themselves. This
 * class is intended to be created by a generated client class, and configured by instances of
 * StreamingCallSettings.Builder which are exposed through the client settings class.
 */
public abstract class BidiStreamingCallable<RequestT, ResponseT> {

  protected BidiStreamingCallable() {}

  /**
   * The "base" method from which other forms of {@code call}s are derived. Most users will not need
   * to call this method directly.
   *
   * <p>However, it is {@code public}, since library authors might want to call this method in
   * adaptor classes.
   */
  public abstract ClientStream<RequestT> internalCall(
      ResponseObserver<ResponseT> responseObserver,
      ClientStreamReadyObserver<RequestT> onReady,
      ApiCallContext context);

  /**
   * Listens to server responses and send requests when the network is free. Example usage:
   *
   * <pre>{@code
   * final Iterator<Integer> sourceDataIterator = intCollection.iterator();
   * BidiStreamObserver<Integer, String> bidiStreamObserver = new BidiStreamObserver<Integer, String>() {
   *   public void onStart(StreamController controller) {
   *     // no-op
   *   }
   *
   *   public void onResponse(String response) {
   *     System.out.println(response);
   *   }
   *
   *   public void onComplete() {
   *     System.out.println("done!");
   *   }
   *
   *   public void onError(Throwable t) {
   *     System.out.println("error: " + t);
   *   }
   *
   *   public void onReady(ClientStream<Integer> stream) {
   *     while (sourceDataIterator.hasNext()) {
   *       if (stream.isReady()) {
   *         stream.send(sourceDataIterator.next());
   *       } else {
   *         // It's OK we haven't consumed the whole iterator;
   *         // onReady will be called again when the network becomes free.
   *         return;
   *       }
   *     }
   *     // We ran out of things to send.
   *     stream.close();
   *   }
   * };
   *
   * bidiStreamingCallable.call(bidiStreamObserver);
   * }</pre>
   */
  public void call(final BidiStreamObserver<RequestT, ResponseT> bidiObserver) {
    call(bidiObserver, null);
  }

  /** Listens to server responses and send requests when the network is free. */
  public void call(
      final BidiStreamObserver<RequestT, ResponseT> bidiObserver, ApiCallContext context) {
    internalCall(bidiObserver, bidiObserver, context);
  }

  /**
   * Send requests and iterate over server responses.
   *
   * <p>This returns a live stream that must either be fully consumed or cancelled. Example usage:
   *
   * <pre>{@code
   * BidiStream<String, String> stream = bidiStreamingCallable.call()
   * for (String s : stream) {
   *   if ("needle".equals(s)) {
   *     // Cancelling the stream will cause `hasNext()` to return false on the next iteration,
   *     // naturally breaking the loop.
   *     stream.cancel();
   *   }
   *   stream.send(s);
   * }
   * }</pre>
   */
  public BidiStream<RequestT, ResponseT> call() {
    return call((ApiCallContext) null);
  }

  /**
   * Send requests and iterate over server responses.
   *
   * <p>This returns a live stream that must either be fully consumed or cancelled.
   */
  public BidiStream<RequestT, ResponseT> call(ApiCallContext context) {
    BidiStream<RequestT, ResponseT> stream = new BidiStream<>();
    ClientStream<RequestT> clientStream = splitCall(stream.observer(), context);
    stream.setClientStream(clientStream);
    return stream;
  }

  /**
   * Send requests to the server and listens to responses.
   *
   * <p>Example usage:
   *
   * <pre>{@code
   * ResponseObserver<String> responseObserver = new ResponseObserver<String>() {
   *   public void onStart(StreamController controller) {
   *     // no-op
   *   }
   *
   *  public void onResponse(String response) {
   *    System.out.println(response);
   *  }
   *
   *  public void onComplete() {
   *    System.out.println("done!");
   *  }
   *
   *  public void onError(Throwable t) {
   *    System.out.println("error: " + t);
   *  }
   * };
   *
   * ClientStream<Integer> clientStream = bidiStreamingCallable.splitCall(responseObserver);
   * clientStream.send(42);
   * clientStream.send(43);
   * clientStream.close();
   * }</pre>
   */
  public ClientStream<RequestT> splitCall(ResponseObserver<ResponseT> responseObserver) {
    return splitCall(responseObserver, null);
  }

  /** Send requests to the server and listens to responses. */
  public ClientStream<RequestT> splitCall(
      ResponseObserver<ResponseT> responseObserver, ApiCallContext context) {
    return internalCall(
        responseObserver,
        stream -> {
          // no op
        },
        context);
  }

  /**
   * Conduct a bidirectional streaming call with the given {@link ApiCallContext}.
   *
   * @param responseObserver {@link ApiStreamObserver} to observe the streaming responses
   * @param context {@link ApiCallContext} to provide context information for the RPC call.
   * @return {@link ApiStreamObserver} which is used for making streaming requests.
   * @deprecated Please use {@link #splitCall(ResponseObserver, ApiCallContext)} instead.
   */
  @Deprecated
  public ApiStreamObserver<RequestT> bidiStreamingCall(
      ApiStreamObserver<ResponseT> responseObserver, ApiCallContext context) {
    final ClientStream<RequestT> stream =
        splitCall(new ApiStreamObserverAdapter<>(responseObserver), context);
    return new ApiStreamObserver<RequestT>() {
      @Override
      public void onNext(RequestT request) {
        stream.send(request);
      }

      @Override
      public void onError(Throwable t) {
        stream.closeSendWithError(t);
      }

      @Override
      public void onCompleted() {
        stream.closeSend();
      }
    };
  }

  /**
   * Conduct a bidirectional streaming call
   *
   * @param responseObserver {@link ApiStreamObserver} to observe the streaming responses
   * @return {@link ApiStreamObserver} which is used for making streaming requests.
   * @deprecated Please use {@link #splitCall(ResponseObserver)} instead.
   */
  @Deprecated
  public ApiStreamObserver<RequestT> bidiStreamingCall(
      ApiStreamObserver<ResponseT> responseObserver) {
    return bidiStreamingCall(responseObserver, null);
  }

  /**
   * Returns a new {@code BidiStreamingCallable} with an {@link ApiCallContext} that is used as a
   * default when none is supplied in individual calls.
   *
   * @param defaultCallContext the default {@link ApiCallContext}.
   */
  public BidiStreamingCallable<RequestT, ResponseT> withDefaultCallContext(
      final ApiCallContext defaultCallContext) {
    return new BidiStreamingCallable<RequestT, ResponseT>() {
      @Override
      public ClientStream<RequestT> internalCall(
          ResponseObserver<ResponseT> responseObserver,
          ClientStreamReadyObserver<RequestT> onReady,
          ApiCallContext thisCallContext) {
        return BidiStreamingCallable.this.internalCall(
            responseObserver, onReady, defaultCallContext.merge(thisCallContext));
      }
    };
  }
}
