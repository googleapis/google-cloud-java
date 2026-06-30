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

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.rpc.testing.FakeCallableFactory;
import com.google.api.gax.rpc.testing.FakeChannel;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.api.gax.rpc.testing.FakeStreamingApi.BidiStreamingStashCallable;
import com.google.api.gax.rpc.testing.FakeTransportChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.junit.jupiter.api.Test;

class BidiStreamingCallableTest {
  private ClientContext clientContext =
      ClientContext.newBuilder()
          .setDefaultCallContext(FakeCallContext.createDefault())
          .setTransportChannel(FakeTransportChannel.create(new FakeChannel()))
          .build();

  @Test
  void bidiStreaming_ResponseObserver() {
    BidiStreamingStashCallable<Integer, Integer> callIntList =
        new BidiStreamingStashCallable<>(Arrays.asList(0, 1, 2));

    BidiStreamingCallable<Integer, Integer> callable =
        FakeCallableFactory.createBidiStreamingCallable(
            callIntList,
            StreamingCallSettings.<Integer, Integer>newBuilder().build(),
            clientContext);

    AccumulatingStreamObserver responseObserver = new AccumulatingStreamObserver();

    ClientStream<Integer> stream = callable.splitCall(responseObserver);
    stream.send(3);
    stream.send(4);
    stream.send(5);
    stream.closeSend();

    assertThat(responseObserver.getValues()).containsExactly(0, 1, 2).inOrder();
    assertThat(callIntList.getActualRequests()).containsExactly(3, 4, 5).inOrder();
  }

  @Test
  void bidiStreaming_BidiStreamObserver() throws InterruptedException {
    BidiStreamingStashCallable<Integer, Integer> callIntList =
        new BidiStreamingStashCallable<>(Arrays.asList(0, 1, 2));

    BidiStreamingCallable<Integer, Integer> callable =
        FakeCallableFactory.createBidiStreamingCallable(
            callIntList,
            StreamingCallSettings.<Integer, Integer>newBuilder().build(),
            clientContext);

    AccumulatingBidiObserver observer = new AccumulatingBidiObserver(Arrays.asList(3, 4, 5));
    callable.call(observer);

    assertThat(observer.getResponses()).containsExactly(0, 1, 2).inOrder();
    assertThat(callIntList.getActualRequests()).containsExactly(3, 4, 5).inOrder();
  }

  @Test
  public void bidiStreaming_BidiStream() {
    BidiStreamingStashCallable<Integer, Integer> callIntList =
        new BidiStreamingStashCallable<>(Arrays.asList(0, 1, 2));
    BidiStreamingCallable<Integer, Integer> callable =
        FakeCallableFactory.createBidiStreamingCallable(
            callIntList,
            StreamingCallSettings.<Integer, Integer>newBuilder().build(),
            clientContext);

    BidiStream<Integer, Integer> stream = callIntList.call();
    stream.send(3);
    stream.send(4);
    stream.send(5);
    stream.closeSend();

    assertThat(callIntList.getActualRequests()).containsExactly(3, 4, 5).inOrder();
    assertThat(stream).containsExactly(0, 1, 2).inOrder();
  }

  private static class AccumulatingBidiObserver implements BidiStreamObserver<Integer, Integer> {
    private final List<Integer> received = new ArrayList<>();
    private Throwable error;
    private final CountDownLatch latch = new CountDownLatch(1);

    private final Iterator<Integer> toSend;

    AccumulatingBidiObserver(Collection<Integer> toSend) {
      this.toSend = toSend.iterator();
    }

    @Override
    public void onStart(StreamController controller) {
      // no-op
    }

    @Override
    public void onResponse(Integer response) {
      received.add(response);
    }

    @Override
    public void onComplete() {
      latch.countDown();
    }

    @Override
    public void onError(Throwable t) {
      error = t;
      latch.countDown();
    }

    @Override
    public void onReady(ClientStream<Integer> stream) {
      while (toSend.hasNext()) {
        if (stream.isSendReady()) {
          stream.send(toSend.next());
        } else {
          // It's OK we haven't consumed the whole iterator;
          // onReady will be called again when the network becomes free.
          return;
        }
      }
      // We ran out of things to send.
      stream.closeSend();
    }

    List<Integer> getResponses() throws InterruptedException {
      latch.await();
      if (error != null) {
        throw ApiExceptionFactory.createException(error, FakeStatusCode.of(Code.UNKNOWN), false);
      }
      return received;
    }
  }
}
