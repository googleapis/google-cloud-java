/*
 * Copyright 2026 Google LLC
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

import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SlowTest;
import com.google.cloud.spanner.Statement;
import com.google.spanner.v1.ExecuteSqlRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@Category(SlowTest.class)
public class GrpcKeepAliveMockServerTest extends AbstractMockServerTest {

  @Before
  public void before() {
    SpannerPool.closeSpannerPool();
  }

  @After
  public void after() {
    SpannerPool.closeSpannerPool();
    mockSpanner.removeAllExecutionTimes();
  }

  @Test
  public void testKeepAliveDetectsDisconnect() throws Exception {
    // 1. Start proxy targeting the mock Spanner server
    try (SimpleProxy proxy = new SimpleProxy(getPort())) {
      // 2. Configure connection options using the proxy.
      // We set grpcKeepAliveTime to 10s, which is the absolute minimum client-side keepalive
      // time enforced by the gRPC library. Any value below 10s is clamped to 10s.
      // We set grpcKeepAliveTimeout to 5s.
      ConnectionOptions options =
          ConnectionOptions.newBuilder()
              .setUri(
                  String.format(
                      "cloudspanner://localhost:%d/projects/proj/instances/inst/databases/db"
                          + "?usePlainText=true;autocommit=true;retryAbortsInternally=true"
                          + ";numChannels=1;grpcKeepAliveTime='10s';grpcKeepAliveTimeout='5s'",
                      proxy.getPort()))
              .setCredentials(NoCredentials.getInstance())
              .build();

      try (Connection connection = createITConnection(options)) {
        // 3. Warm up the connection so session creation and dialect detection are done, then
        // make the mock Spanner server delay the execution of any following queries.
        try (ResultSet rs = connection.executeQuery(Statement.of("SELECT 1"))) {
          while (rs.next()) {
            // consume
          }
        }
        mockSpanner.setExecuteStreamingSqlExecutionTime(
            SimulatedExecutionTime.ofMinimumAndRandomTime(35000, 0));

        // 4. Run the query in a separate thread
        mockSpanner.clearRequests();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Void> future =
            executor.submit(
                () -> {
                  try (ResultSet rs = connection.executeQuery(Statement.of("SELECT 1"))) {
                    while (rs.next()) {
                      // consume
                    }
                  }
                  return null;
                });

        // 5. Wait until the query is actually in flight on the server, then trigger the
        // network blackhole.
        await()
            .atMost(Duration.ofSeconds(10))
            .until(() -> mockSpanner.countRequestsOfType(ExecuteSqlRequest.class) > 0);
        proxy.blackhole();
        long startTime = System.currentTimeMillis();

        // 6. Wait until the client detects the dead connection through the keepalive
        // (10s keepalive + 5s timeout) and drops it, then restore the proxy and clear the
        // execution delay so the retry succeeds immediately.
        await().atMost(Duration.ofSeconds(60)).until(proxy::isClientDisconnected);
        proxy.restore();
        mockSpanner.removeAllExecutionTimes();

        // 7. Wait for the query to recover and complete. The client has already dropped the
        // dead connection, so the retry runs over the restored proxy and succeeds immediately.
        try {
          future.get(10, TimeUnit.SECONDS);
          long elapsed = System.currentTimeMillis() - startTime;
          System.out.println("Query succeeded after blackhole recovery in " + elapsed + " ms");
          assertTrue(
              "Expected query to complete within 20 seconds, but took " + elapsed + "ms",
              elapsed < 20000L);
        } catch (Exception e) {
          e.printStackTrace();
          fail("Expected query to succeed after restoring connection, but got: " + e);
        } finally {
          executor.shutdown();
        }
      }
    }
  }

  static class SimpleProxy implements AutoCloseable {
    private final ServerSocket serverSocket;
    private final int localPort;
    private final int targetPort;
    private final AtomicBoolean blackholed = new AtomicBoolean(false);
    private final AtomicBoolean clientDisconnected = new AtomicBoolean(false);
    private final List<Socket> clientSockets = Collections.synchronizedList(new ArrayList<>());
    private final List<Socket> serverSockets = Collections.synchronizedList(new ArrayList<>());
    private final List<Thread> forwardingThreads = Collections.synchronizedList(new ArrayList<>());
    private final Thread acceptThread;

    SimpleProxy(int targetPort) throws IOException {
      this.serverSocket = new ServerSocket(0);
      this.localPort = serverSocket.getLocalPort();
      this.targetPort = targetPort;
      this.acceptThread = new Thread(this::acceptConnections, "SimpleProxy-accept");
      this.acceptThread.setDaemon(true);
      this.acceptThread.start();
    }

    int getPort() {
      return localPort;
    }

    /**
     * Returns true when the client has dropped a black-holed connection (which happens when the
     * client-side keepalive times out and the client closes the transport).
     */
    boolean isClientDisconnected() {
      return clientDisconnected.get();
    }

    void blackhole() {
      blackholed.set(true);
      synchronized (serverSockets) {
        for (Socket s : serverSockets) {
          try {
            s.close();
          } catch (IOException e) {
          }
        }
        serverSockets.clear();
      }
    }

    private void acceptConnections() {
      try {
        while (!serverSocket.isClosed()) {
          Socket clientSocket = serverSocket.accept();
          if (blackholed.get()) {
            clientSocket.close();
            continue;
          }
          clientSockets.add(clientSocket);
          try {
            Socket serverSocket = new Socket("localhost", targetPort);
            serverSockets.add(serverSocket);

            Thread forwardClientToServer =
                new Thread(() -> forward(clientSocket, serverSocket, true), "SimpleProxy-C2S");
            Thread forwardServerToClient =
                new Thread(() -> forward(serverSocket, clientSocket, false), "SimpleProxy-S2C");
            forwardClientToServer.setDaemon(true);
            forwardServerToClient.setDaemon(true);
            forwardingThreads.add(forwardClientToServer);
            forwardingThreads.add(forwardServerToClient);
            forwardClientToServer.start();
            forwardServerToClient.start();
          } catch (IOException e) {
            clientSocket.close();
          }
        }
      } catch (IOException e) {
        // expected on close
      }
    }

    /**
     * Forwards data from one socket to the other until the connection breaks or the blackhole is
     * triggered. Once this direction has seen the blackhole it is poisoned and never forwards
     * again: the client-to-server direction keeps reading and discarding, so the client closing the
     * connection after its keepalive timeout is detected and signals {@link #clientDisconnected},
     * while the server-to-client direction parks to keep the client socket open without delivering
     * any data.
     */
    private void forward(Socket input, Socket output, boolean fromClient) {
      boolean poisoned = false;
      try (InputStream in = input.getInputStream();
          OutputStream out = output.getOutputStream()) {
        byte[] buffer = new byte[4096];
        int read;
        while (true) {
          try {
            read = in.read(buffer);
          } catch (IOException e) {
            if (poisoned || blackholed.get()) {
              if (fromClient) {
                clientDisconnected.set(true);
              } else {
                blockIndefinitely();
              }
            }
            throw e;
          }
          if (read == -1) {
            if (poisoned || blackholed.get()) {
              if (fromClient) {
                clientDisconnected.set(true);
              } else {
                blockIndefinitely();
              }
            }
            break;
          }
          if (poisoned || blackholed.get()) {
            poisoned = true;
            if (fromClient) {
              // Silently drop the data, but keep reading so the connection close by the client
              // (after the keepalive timeout) is detected.
              continue;
            }
            blockIndefinitely();
            break;
          }
          try {
            out.write(buffer, 0, read);
            out.flush();
          } catch (IOException e) {
            if (blackholed.get()) {
              poisoned = true;
              if (fromClient) {
                // The server side is gone; keep draining the client so its disconnect is
                // detected.
                continue;
              }
              blockIndefinitely();
            }
            throw e;
          }
        }
      } catch (Exception e) {
        // ignore
      }
    }

    private void blockIndefinitely() {
      try {
        Thread.sleep(Long.MAX_VALUE);
      } catch (InterruptedException ie) {
        Thread.currentThread().interrupt();
      }
    }

    void restore() {
      blackholed.set(false);
    }

    @Override
    public void close() throws Exception {
      synchronized (clientSockets) {
        for (Socket s : clientSockets) {
          try {
            s.close();
          } catch (IOException e) {
            // ignore
          }
        }
        clientSockets.clear();
      }
      synchronized (serverSockets) {
        for (Socket s : serverSockets) {
          try {
            s.close();
          } catch (IOException e) {
            // ignore
          }
        }
        serverSockets.clear();
      }
      synchronized (forwardingThreads) {
        for (Thread t : forwardingThreads) {
          t.interrupt();
        }
        forwardingThreads.clear();
      }
      try {
        serverSocket.close();
      } catch (IOException e) {
        // ignore
      }
      try {
        acceptThread.join(1000L);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }
}
