/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.cloud.NoCredentials;
import io.grpc.ForwardingServerCall;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import java.net.InetSocketAddress;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

abstract class AbstractNettyMockServerTest {
  protected static MockSpannerServiceImpl mockSpanner;

  protected static Server server;
  protected static InetSocketAddress address;
  static ExecutorService executor;
  protected static LocalChannelProvider channelProvider;
  protected static final AtomicReference<Float> fakeServerTiming =
      new AtomicReference<>((float) (new Random().nextDouble() * 1000) + 1);
  protected static final AtomicReference<Float> fakeAFEServerTiming =
      new AtomicReference<>((float) new Random().nextInt(500) + 1);

  protected Spanner spanner;

  @BeforeClass
  public static void startMockServer() throws Exception {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D); // We don't want any unpredictable aborted transactions.

    address = new InetSocketAddress("localhost", 0);
    server =
        NettyServerBuilder.forAddress(address)
            .addService(mockSpanner)
            .intercept(
                new ServerInterceptor() {
                  @Override
                  public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
                      ServerCall<ReqT, RespT> serverCall,
                      Metadata headers,
                      ServerCallHandler<ReqT, RespT> serverCallHandler) {
                    return serverCallHandler.startCall(
                        new ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT>(
                            serverCall) {
                          @Override
                          public void sendHeaders(Metadata headers) {
                            headers.put(
                                Metadata.Key.of("server-timing", Metadata.ASCII_STRING_MARSHALLER),
                                String.format(
                                    "afe; dur=%f, gfet4t7; dur=%f",
                                    fakeAFEServerTiming.get(), fakeServerTiming.get()));
                            super.sendHeaders(headers);
                          }
                        },
                        headers);
                  }
                })
            .build()
            .start();
    executor = Executors.newSingleThreadExecutor();
  }

  @AfterClass
  public static void stopMockServer() throws InterruptedException {
    server.shutdown();
    server.awaitTermination();
    executor.shutdown();
  }

  @Before
  public void createSpannerInstance() {
    String endpoint = address.getHostString() + ":" + server.getPort();
    spanner =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
            .setHost("http://" + endpoint)
            .setCredentials(NoCredentials.getInstance())
            .setSessionPoolOption(SessionPoolOptions.newBuilder().setFailOnSessionLeak().build())
            .build()
            .getService();
  }

  @After
  public void cleanup() {
    spanner.close();
    mockSpanner.reset();
    mockSpanner.removeAllExecutionTimes();
  }
}
