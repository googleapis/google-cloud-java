/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.showcase.v1beta1.it;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ClientStream;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.EchoResponse;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ITBidiStreaming {

  private static EchoClient grpcClient;

  @BeforeAll
  static void createClients() throws Exception {
    // Create gRPC Echo Client
    grpcClient = TestClientInitializer.createGrpcEchoClient();
  }

  @AfterAll
  static void destroyClients() throws Exception {
    grpcClient.close();
    grpcClient.awaitTermination(TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
  }

  // The current implementation of BIDI streaming on Echo showcase server is that it would echo the
  // request content back on every request, so this test verifies that the response content is
  // exactly the same as request content.
  // Ideally we should make the BIDI streaming server more generic, e.g. only respond when there are
  // three requests, respond twice for every request etc. If that happens, the response content may
  // not be exactly the same as request content.
  @Test
  void testGrpc_splitCall_shouldListensToResponse() throws Exception {
    // given
    List<String> expected = Arrays.asList("The rain in Spain stays mainly on the plain".split(" "));
    TestResponseObserver responseObserver = new TestResponseObserver();

    // when
    ClientStream<EchoRequest> clientStream = grpcClient.chatCallable().splitCall(responseObserver);
    expected.forEach(
        requestContent -> {
          EchoRequest request = EchoRequest.newBuilder().setContent(requestContent).build();
          clientStream.send(request);
        });
    clientStream.closeSend();

    // then
    List<String> actual = responseObserver.getFuture().get();
    assertThat(actual).containsExactlyElementsIn(expected).inOrder();
  }

  private static class TestResponseObserver implements ResponseObserver<EchoResponse> {
    private final List<String> responses = new ArrayList<>();
    private final SettableApiFuture<List<String>> future = SettableApiFuture.create();

    @Override
    public void onStart(StreamController controller) {
      // no-op
    }

    @Override
    public void onResponse(EchoResponse response) {
      responses.add(response.getContent());
    }

    @Override
    public void onError(Throwable t) {
      // no-op
    }

    @Override
    public void onComplete() {
      future.set(responses);
    }

    public SettableApiFuture<List<String>> getFuture() {
      return future;
    }
  }
}
