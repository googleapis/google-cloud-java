/*
 * Copyright 2024 Google LLC
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

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.ImmutableSet;
import com.google.common.truth.Truth;
import com.google.showcase.v1beta1.BlockRequest;
import com.google.showcase.v1beta1.BlockResponse;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.threeten.bp.Duration;

class ITClientShutdown {

  private static final long DEFAULT_RPC_TIMEOUT_MS = 15000L;
  private static final long DEFAULT_CLIENT_TERMINATION_MS = 5000L;

  // Test to ensure the client can close + terminate properly
  @Test
  @Timeout(15)
  void testGrpc_closeClient() throws Exception {
    EchoClient grpcClient = TestClientInitializer.createGrpcEchoClient();
    assertClientTerminated(grpcClient);
  }

  // Test to ensure the client can close + terminate properly
  @Test
  @Timeout(15)
  void testHttpJson_closeClient() throws Exception {
    EchoClient httpjsonClient = TestClientInitializer.createHttpJsonEchoClient();
    assertClientTerminated(httpjsonClient);
  }

  // Test to ensure the client can close + terminate after a quick RPC invocation
  @Test
  @Timeout(15)
  void testGrpc_rpcInvoked_closeClient() throws Exception {
    EchoClient grpcClient = TestClientInitializer.createGrpcEchoClient();
    // Response is ignored for this test
    grpcClient.echo(EchoRequest.newBuilder().setContent("Test").build());
    assertClientTerminated(grpcClient);
  }

  // Test to ensure the client can close + terminate after a quick RPC invocation
  @Test
  @Timeout(15)
  void testHttpJson_rpcInvoked_closeClient() throws Exception {
    EchoClient httpjsonClient = TestClientInitializer.createHttpJsonEchoClient();
    // Response is ignored for this test
    httpjsonClient.echo(EchoRequest.newBuilder().setContent("Test").build());
    assertClientTerminated(httpjsonClient);
  }

  // This test is to ensure that the client is able to close + terminate any resources
  // once a response has been received. Set a max test duration of 15s to ensure that
  // the test does not continue on forever.
  @Test
  @Timeout(15)
  void testGrpc_rpcInvokedWithLargeTimeout_closeClientOnceResponseReceived() throws Exception {
    // Set the maxAttempts to 1 to ensure there are no retries scheduled. The single RPC
    // invocation should time out in 15s, but the client will receive a response in 2s.
    // Any outstanding tasks (timeout tasks) should be cancelled once a response has been
    // received so the client can properly terminate.
    RetrySettings defaultRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeout(Duration.ofMillis(DEFAULT_RPC_TIMEOUT_MS))
            .setMaxRpcTimeout(Duration.ofMillis(DEFAULT_RPC_TIMEOUT_MS))
            .setTotalTimeout(Duration.ofMillis(DEFAULT_RPC_TIMEOUT_MS))
            .setMaxAttempts(1)
            .build();
    EchoClient grpcClient =
        TestClientInitializer.createGrpcEchoClientCustomBlockSettings(
            defaultRetrySettings, ImmutableSet.of(StatusCode.Code.DEADLINE_EXCEEDED));

    BlockRequest blockRequest =
        BlockRequest.newBuilder()
            .setSuccess(BlockResponse.newBuilder().setContent("gRPCBlockContent_2sDelay"))
            .setResponseDelay(com.google.protobuf.Duration.newBuilder().setSeconds(2).build())
            .build();

    // Response is ignored for this test
    grpcClient.block(blockRequest);

    assertClientTerminated(grpcClient);
  }

  // This test is to ensure that the client is able to close + terminate any resources
  // once a response has been received. Set a max test duration of 15s to ensure that
  // the test does not continue on forever.
  @Test
  @Timeout(15)
  void testHttpJson_rpcInvokedWithLargeTimeout_closeClientOnceResponseReceived() throws Exception {
    // Set the maxAttempts to 1 to ensure there are no retries scheduled. The single RPC
    // invocation should time out in 15s, but the client will receive a response in 2s.
    // Any outstanding tasks (timeout tasks) should be cancelled once a response has been
    // received so the client can properly terminate.
    RetrySettings defaultRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeout(Duration.ofMillis(DEFAULT_RPC_TIMEOUT_MS))
            .setMaxRpcTimeout(Duration.ofMillis(DEFAULT_RPC_TIMEOUT_MS))
            .setTotalTimeout(Duration.ofMillis(DEFAULT_RPC_TIMEOUT_MS))
            .setMaxAttempts(1)
            .build();
    EchoClient httpjsonClient =
        TestClientInitializer.createHttpJsonEchoClientCustomBlockSettings(
            defaultRetrySettings, ImmutableSet.of(StatusCode.Code.DEADLINE_EXCEEDED));

    BlockRequest blockRequest =
        BlockRequest.newBuilder()
            .setSuccess(BlockResponse.newBuilder().setContent("httpjsonBlockContent_2sDelay"))
            .setResponseDelay(com.google.protobuf.Duration.newBuilder().setSeconds(2).build())
            .build();

    // Response is ignored for this test
    httpjsonClient.block(blockRequest);

    assertClientTerminated(httpjsonClient);
  }

  // This helper method asserts that the client is able to terminate within
  // `AWAIT_TERMINATION_SECONDS`
  private void assertClientTerminated(EchoClient echoClient) throws InterruptedException {
    long start = System.currentTimeMillis();
    // Intentionally do not run echoClient.awaitTermination(...) as this test will
    // check that everything is properly terminated after close() is called.
    echoClient.close();

    // Loop until the client has terminated successfully. For tests that use this,
    // try to ensure there is a timeout associated, otherwise this may run forever.
    // Future enhancement: Use awaitility instead of busy waiting
    while (!echoClient.isTerminated()) {
      Thread.sleep(500L);
    }
    // The busy-wait time won't be accurate, so account for a bit of buffer
    long end = System.currentTimeMillis();

    Truth.assertThat(echoClient.isShutdown()).isTrue();

    // Check the termination time. If all the tasks/ resources are closed successfully,
    // the termination time should only occur shortly after `close()` was invoked. The
    // `DEFAULT_TERMINATION_MS` value should include a bit of buffer.
    long terminationTime = end - start;
    Truth.assertThat(terminationTime).isLessThan(DEFAULT_CLIENT_TERMINATION_MS);
  }
}
