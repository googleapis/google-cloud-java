/*
 * Copyright 2021 Google LLC
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
package com.google.cloud.spanner.connection;

import static com.google.cloud.spanner.MockSpannerTestUtil.SELECT1;
import static com.google.cloud.spanner.MockSpannerTestUtil.SELECT1_RESULTSET;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import java.net.InetSocketAddress;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LocalConnectionCheckerTest {

  private static MockSpannerServiceImpl mockSpanner;
  private static Server server;
  private LocalConnectionChecker connectionChecker;

  @BeforeClass
  public static void beforeClass() throws Exception {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D); // We don't want any unpredictable aborted transactions.

    final InetSocketAddress address = new InetSocketAddress("localhost", 0);
    server = NettyServerBuilder.forAddress(address).addService(mockSpanner).build();
    server.start();
  }

  @AfterClass
  public static void afterClass() throws Exception {
    server.shutdown();
    server.awaitTermination();
  }

  @Before
  public void setUp() {
    mockSpanner.reset();
    connectionChecker = new LocalConnectionChecker();
  }

  @Test
  public void testMockSpanner() {
    final String uri =
        String.format(
            "cloudspanner://localhost:%d/projects/proj/instances/inst/databases/db?usePlainText=true",
            server.getPort());
    final ConnectionOptions connectionOptions = ConnectionOptions.newBuilder().setUri(uri).build();
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.query(SELECT1, SELECT1_RESULTSET));

    try (Connection connection = connectionOptions.getConnection();
        ResultSet resultSet = connection.executeQuery(SELECT1)) {
      while (resultSet.next()) {}
    }
  }

  @Test
  public void testNoRunningEmulator() {
    final int port = server.getPort() - 1;
    final String uri =
        String.format(
            "cloudspanner://localhost:%d/projects/proj/instances/inst/databases/db?usePlainText=true",
            port);
    final ConnectionOptions connectionOptions = ConnectionOptions.newBuilder().setUri(uri).build();

    try {
      connectionChecker.checkLocalConnection(connectionOptions);
      fail("Unavailable exception expected");
    } catch (SpannerException e) {
      assertEquals(
          "UNAVAILABLE: The connection string '"
              + uri
              + "' contains host 'localhost:"
              + port
              + "', but no running emulator or other server could be found at that address.\n"
              + "Please check the connection string and/or that the emulator is running.",
          e.getMessage());
    }
  }
}
