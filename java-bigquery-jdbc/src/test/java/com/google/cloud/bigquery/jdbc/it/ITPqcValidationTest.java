/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ITPqcValidationTest extends ITBase {

  private static final String EXPECTED_PROTOCOL = "TLSv1.3";
  private static final String EXPECTED_KEY_EXCHANGE = "X25519MLKEM768";

  private static class HandshakeRecord {
    final String peerHost;
    final String providerClass;
    final boolean conscryptSocket;
    final String protocol;
    final String cipherSuite;
    final String keyExchangeGroup;

    HandshakeRecord(
        String peerHost,
        String providerClass,
        boolean conscryptSocket,
        String protocol,
        String cipherSuite,
        String keyExchangeGroup) {
      this.peerHost = peerHost;
      this.providerClass = providerClass;
      this.conscryptSocket = conscryptSocket;
      this.protocol = protocol;
      this.cipherSuite = cipherSuite;
      this.keyExchangeGroup = keyExchangeGroup;
    }
  }

  @Test
  @Tag("advanced")
  public void testRestTransportNegotiatesMlkem() throws Exception {
    Class<?> proxyUtilClass =
        Class.forName(
            String.join(
                ".", "com", "google", "cloud", "bigquery", "jdbc", "BigQueryJdbcProxyUtility"));
    Field dtField = proxyUtilClass.getDeclaredField("DEFAULT_TRANSPORT");
    dtField.setAccessible(true);
    Object defaultTransport = dtField.get(null);

    Field ssfField = defaultTransport.getClass().getDeclaredField("sslSocketFactory");
    ssfField.setAccessible(true);
    final SSLSocketFactory origFactory = (SSLSocketFactory) ssfField.get(defaultTransport);
    assertNotNull(origFactory, "DEFAULT_TRANSPORT sslSocketFactory should be configured");

    final List<HandshakeRecord> handshakes = new CopyOnWriteArrayList<>();

    SSLSocketFactory inspectingFactory =
        new SSLSocketFactory() {
          private Socket wrapSocket(Socket s) {
            if (s instanceof SSLSocket) {
              final SSLSocket sslSocket = (SSLSocket) s;
              sslSocket.addHandshakeCompletedListener(
                  event -> {
                    String curve = extractConscryptCurveName(sslSocket);
                    handshakes.add(
                        new HandshakeRecord(
                            event.getSession().getPeerHost(),
                            sslSocket.getClass().getName(),
                            isConscryptSocket(sslSocket),
                            event.getSession().getProtocol(),
                            event.getCipherSuite(),
                            curve));
                  });
            }
            return s;
          }

          @Override
          public String[] getDefaultCipherSuites() {
            return origFactory.getDefaultCipherSuites();
          }

          @Override
          public String[] getSupportedCipherSuites() {
            return origFactory.getSupportedCipherSuites();
          }

          @Override
          public Socket createSocket(Socket s, String host, int port, boolean autoClose)
              throws IOException {
            return wrapSocket(origFactory.createSocket(s, host, port, autoClose));
          }

          @Override
          public Socket createSocket(String host, int port) throws IOException {
            return wrapSocket(origFactory.createSocket(host, port));
          }

          @Override
          public Socket createSocket(String host, int port, InetAddress localHost, int localPort)
              throws IOException {
            return wrapSocket(origFactory.createSocket(host, port, localHost, localPort));
          }

          @Override
          public Socket createSocket(InetAddress host, int port) throws IOException {
            return wrapSocket(origFactory.createSocket(host, port));
          }

          @Override
          public Socket createSocket(
              InetAddress address, int port, InetAddress localAddress, int localPort)
              throws IOException {
            return wrapSocket(origFactory.createSocket(address, port, localAddress, localPort));
          }
        };

    ssfField.set(defaultTransport, inspectingFactory);
    try (Connection connection = DriverManager.getConnection(ITBase.connectionUrl);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT 1")) {
      assertTrue(rs.next());
      assertEquals(1, rs.getInt(1));
    } finally {
      ssfField.set(defaultTransport, origFactory);
    }

    assertFalse(handshakes.isEmpty(), "Expected at least one REST TLS handshake to be recorded");
    for (HandshakeRecord record : handshakes) {
      assertTrue(
          record.conscryptSocket,
          "Expected Conscrypt SSLSocket for REST transport, but got: " + record.providerClass);
      assertEquals(
          EXPECTED_PROTOCOL,
          record.protocol,
          "Expected TLSv1.3 for REST handshake to " + record.peerHost);
      assertTrue(
          record.cipherSuite.startsWith("TLS_AES_"),
          "Expected TLS 1.3 AEAD cipher suite, but got: " + record.cipherSuite);
      assertEquals(
          EXPECTED_KEY_EXCHANGE,
          record.keyExchangeGroup,
          "Expected post-quantum hybrid X25519MLKEM768 key exchange for REST handshake to "
              + record.peerHost);
    }
  }

  @Test
  @Tag("advanced")
  public void testGrpcTransportNegotiatesMlkem() throws Exception {
    Class<?> openSslClass =
        Class.forName(
            String.join(
                ".", "io", "grpc", "netty", "shaded", "io", "netty", "handler", "ssl", "OpenSsl"));
    boolean isAvailable = Boolean.TRUE.equals(openSslClass.getMethod("isAvailable").invoke(null));
    Object unavailabilityCause = openSslClass.getMethod("unavailabilityCause").invoke(null);
    assertTrue(
        isAvailable,
        "Expected Netty OpenSsl (tcnative BoringSSL) to be available, unavailability cause: "
            + unavailabilityCause);
    assertEquals("BoringSSL", openSslClass.getMethod("versionString").invoke(null));

    Field defaultGroupsField = openSslClass.getDeclaredField("NAMED_GROUPS");
    defaultGroupsField.setAccessible(true);
    String[] defaultGroups = (String[]) defaultGroupsField.get(null);
    assertNotNull(defaultGroups);
    assertTrue(
        Arrays.asList(defaultGroups).contains(EXPECTED_KEY_EXCHANGE),
        "Expected OpenSsl.NAMED_GROUPS to contain X25519MLKEM768, but got: "
            + Arrays.toString(defaultGroups));
    assertEquals(
        EXPECTED_KEY_EXCHANGE,
        defaultGroups[0],
        "Expected X25519MLKEM768 to be the preferred key share in OpenSsl.NAMED_GROUPS");

    String htapiUrl = ITBase.connectionUrl + ITBase.FORCE_READ_API_PROPERTIES + "MaxResults=100;";
    try (Connection connection = DriverManager.getConnection(htapiUrl);
        Statement statement = connection.createStatement()) {
      ITBase.validateStatement(statement, 1000, "BigQueryArrowResultSet");

      List<HandshakeRecord> grpcSessions = inspectActiveGrpcTlsSessions(connection, defaultGroups);
      assertFalse(
          grpcSessions.isEmpty(),
          "Expected at least one active Netty BoringSSL gRPC session on BigQueryReadClient");

      for (HandshakeRecord record : grpcSessions) {
        assertEquals(
            EXPECTED_PROTOCOL,
            record.protocol,
            "Expected TLSv1.3 for gRPC handshake to " + record.peerHost);
        assertTrue(
            record.cipherSuite.startsWith("TLS_AES_"),
            "Expected TLS 1.3 AEAD cipher suite for gRPC, but got: " + record.cipherSuite);
        assertEquals(
            EXPECTED_KEY_EXCHANGE,
            record.keyExchangeGroup,
            "Expected X25519MLKEM768 primary key share on gRPC engine for " + record.peerHost);
      }
    }
  }

  private static boolean isConscryptSocket(Socket socket) {
    try {
      Class<?> conscryptClass = Class.forName(String.join(".", "org", "conscrypt", "Conscrypt"));
      Method isConscrypt = conscryptClass.getMethod("isConscrypt", Socket.class);
      return Boolean.TRUE.equals(isConscrypt.invoke(null, socket));
    } catch (Throwable t) {
      return socket.getClass().getName().contains("conscrypt");
    }
  }

  private static String extractConscryptCurveName(SSLSocket sslSocket) {
    try {
      Class<?> cls = sslSocket.getClass();
      Field engineField = null;
      while (cls != null && engineField == null) {
        try {
          engineField = cls.getDeclaredField("engine");
        } catch (NoSuchFieldException e) {
          cls = cls.getSuperclass();
        }
      }
      if (engineField == null) {
        return "unknown (not ConscryptEngineSocket)";
      }
      engineField.setAccessible(true);
      Object conscryptEngine = engineField.get(sslSocket);
      Field sslField = conscryptEngine.getClass().getDeclaredField("ssl");
      sslField.setAccessible(true);
      Object nativeSsl = sslField.get(conscryptEngine);
      Method getCurveMethod = nativeSsl.getClass().getDeclaredMethod("getCurveNameForTesting");
      getCurveMethod.setAccessible(true);
      Object curve = getCurveMethod.invoke(nativeSsl);
      return curve != null ? curve.toString() : "unknown";
    } catch (Throwable t) {
      return "unavailable (" + t.getMessage() + ")";
    }
  }

  private static List<HandshakeRecord> inspectActiveGrpcTlsSessions(
      Connection conn, String[] defaultGroups) throws Exception {
    List<HandshakeRecord> results = new ArrayList<>();
    Class<?> openSslCtxClass =
        Class.forName(
            String.join(
                ".",
                "io",
                "grpc",
                "netty",
                "shaded",
                "io",
                "netty",
                "handler",
                "ssl",
                "ReferenceCountedOpenSslContext"));
    Class<?> openSslEngineClass =
        Class.forName(
            String.join(
                ".",
                "io",
                "grpc",
                "netty",
                "shaded",
                "io",
                "netty",
                "handler",
                "ssl",
                "ReferenceCountedOpenSslEngine"));

    Class<?> bqConnClass =
        Class.forName(
            String.join(".", "com", "google", "cloud", "bigquery", "jdbc", "BigQueryConnection"));
    Object bqConn = conn.isWrapperFor(bqConnClass) ? conn.unwrap(bqConnClass) : conn;
    Field readClientField = bqConnClass.getDeclaredField("bigQueryReadClient");
    readClientField.setAccessible(true);
    Object readClient = readClientField.get(bqConn);
    assertNotNull(readClient, "Expected bigQueryReadClient to be initialized after HTAPI query");

    List<Object> contexts = findInstancesInGraph(readClient, openSslCtxClass, 25);
    for (Object ctx : contexts) {
      Field enginesField = openSslCtxClass.getDeclaredField("engines");
      enginesField.setAccessible(true);
      Map<?, ?> engines = (Map<?, ?>) enginesField.get(ctx);
      for (Object engineObj : engines.values()) {
        if (openSslEngineClass.isInstance(engineObj)) {
          SSLEngine engine = (SSLEngine) engineObj;
          SSLSession session = engine.getSession();
          Field groupsField = openSslEngineClass.getDeclaredField("groups");
          groupsField.setAccessible(true);
          String[] engineGroups = (String[]) groupsField.get(engineObj);
          if (engineGroups == null || engineGroups.length == 0) {
            engineGroups = defaultGroups;
          }
          String primaryKeyShare =
              (engineGroups != null && engineGroups.length > 0) ? engineGroups[0] : "unknown";
          results.add(
              new HandshakeRecord(
                  session.getPeerHost(),
                  engine.getClass().getName(),
                  false,
                  session.getProtocol(),
                  session.getCipherSuite(),
                  primaryKeyShare));
        }
      }
    }
    return results;
  }

  private static List<Object> findInstancesInGraph(
      Object root, Class<?> targetClass, int maxDepth) {
    List<Object> found = new ArrayList<>();
    if (root == null) {
      return found;
    }
    Map<Object, Boolean> visited = new IdentityHashMap<>();
    Queue<Object> queue = new ArrayDeque<>();
    Queue<Integer> depths = new ArrayDeque<>();
    visited.put(root, Boolean.TRUE);
    queue.add(root);
    depths.add(0);

    while (!queue.isEmpty()) {
      Object current = queue.poll();
      int depth = depths.poll();
      if (targetClass.isInstance(current)) {
        found.add(current);
        continue;
      }
      if (depth >= maxDepth) {
        continue;
      }
      Class<?> cls = current.getClass();
      if (cls.isArray()) {
        if (!cls.getComponentType().isPrimitive()) {
          int len = Array.getLength(current);
          for (int i = 0; i < Math.min(len, 64); i++) {
            Object elem = Array.get(current, i);
            if (elem != null && !visited.containsKey(elem)) {
              visited.put(elem, Boolean.TRUE);
              queue.add(elem);
              depths.add(depth + 1);
            }
          }
        }
        continue;
      }
      if (current instanceof AtomicReference<?>) {
        Object elem = ((AtomicReference<?>) current).get();
        if (elem != null && !visited.containsKey(elem)) {
          visited.put(elem, Boolean.TRUE);
          queue.add(elem);
          depths.add(depth + 1);
        }
        continue;
      }
      if (current instanceof Iterable<?>) {
        int count = 0;
        for (Object elem : (Iterable<?>) current) {
          if (count++ > 64) {
            break;
          }
          if (elem != null && !visited.containsKey(elem)) {
            visited.put(elem, Boolean.TRUE);
            queue.add(elem);
            depths.add(depth + 1);
          }
        }
      }
      if (current instanceof Map<?, ?>) {
        int count = 0;
        for (Object elem : ((Map<?, ?>) current).values()) {
          if (count++ > 64) {
            break;
          }
          if (elem != null && !visited.containsKey(elem)) {
            visited.put(elem, Boolean.TRUE);
            queue.add(elem);
            depths.add(depth + 1);
          }
        }
      }
      while (cls != null && cls != Object.class) {
        String pkg = cls.getName();
        if (pkg.startsWith("java.")
            || pkg.startsWith("javax.")
            || pkg.startsWith("jdk.")
            || pkg.startsWith("sun.")) {
          cls = cls.getSuperclass();
          continue;
        }
        for (Field f : cls.getDeclaredFields()) {
          if (Modifier.isStatic(f.getModifiers()) || f.getType().isPrimitive()) {
            continue;
          }
          try {
            f.setAccessible(true);
            Object val = f.get(current);
            if (val != null && !visited.containsKey(val)) {
              visited.put(val, Boolean.TRUE);
              queue.add(val);
              depths.add(depth + 1);
            }
          } catch (Throwable ignored) {
          }
        }
        cls = cls.getSuperclass();
      }
    }
    return found;
  }
}
