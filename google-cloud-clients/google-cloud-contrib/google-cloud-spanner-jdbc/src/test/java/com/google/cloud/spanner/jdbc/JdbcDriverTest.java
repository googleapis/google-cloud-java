/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.jdbc;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.google.cloud.spanner.MockSpannerServiceImpl;
import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JdbcDriverTest {
  /**
   * Make sure the JDBC driver class is loaded. This is needed when running the test using Maven.
   */
  static {
    try {
      Class.forName("com.google.cloud.spanner.jdbc.JdbcDriver");
    } catch (ClassNotFoundException e) {
      throw new IllegalStateException(
          "JdbcDataSource failed to load com.google.cloud.spanner.jdbc.JdbcDriver", e);
    }
  }

  private static MockSpannerServiceImpl mockSpanner;
  private static Server server;
  private static InetSocketAddress address;
  private static final String TEST_KEY_PATH =
      ConnectionOptionsTest.class.getResource("test-key.json").getFile();

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockSpanner = new MockSpannerServiceImpl();
    address = new InetSocketAddress("localhost", 0);
    server = NettyServerBuilder.forAddress(address).addService(mockSpanner).build().start();
  }

  @AfterClass
  public static void stopServer() throws Exception {
    SpannerPool.closeSpannerPool();
    server.shutdown();
    server.awaitTermination();
  }

  @Test
  public void testConnect() throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner://localhost:%d/projects/test-project/instances/static-test-instance/databases/test-database;usePlainText=true;credentials=%s",
                server.getPort(), TEST_KEY_PATH))) {
      assertThat(connection.isClosed(), is(false));
    }
  }

  @Test(expected = SQLException.class)
  public void testInvalidConnect() throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner://localhost:%d/projects/test-project/instances/static-test-instance/databases/test-database;usePlainText=true;credentialsUrl=%s",
                server.getPort(), TEST_KEY_PATH))) {
      assertThat(connection.isClosed(), is(false));
    }
  }
}
