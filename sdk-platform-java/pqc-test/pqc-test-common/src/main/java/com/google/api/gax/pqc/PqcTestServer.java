package com.google.api.gax.pqc;

import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsParameters;
import com.sun.net.httpserver.HttpsServer;
import io.grpc.Server;
import io.grpc.netty.NettyServerBuilder;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.security.Security;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;

/**
 * PqcTestServer is a specialized test harness designed to validate Post-Quantum Cryptography (PQC)
 * transport enforcement in the Google Cloud Java SDK.
 *
 * <h3>Rationale</h3>
 * As part of the PQC migration, we need to ensure that our transport layers (both HTTP/JSON and gRPC)
 * are capable of negotiating PQC algorithms and, critically, that we can enforce a "fail-fast" policy
 * where legacy clients or non-compliant configurations fail to connect to a PQC-enforcing endpoint.
 * This server provides that enforcing endpoint for testing purposes.
 *
 * <h3>Architecture</h3>
 * The server spins up two separate service endpoints on random ports:
 * <ol>
 *   <li>An HTTPS server using standard Java {@link com.sun.net.httpserver.HttpsServer}.</li>
 *   <li>A gRPC server using {@link io.grpc.netty.NettyServerBuilder}.</li>
 * </ol>
 *
 * <h3>PQC Enforcement Mechanism</h3>
 * The server enforces PQC by controlling the TLS handshake parameters:
 * <ul>
 *   <li><b>TLSv1.3 Only</b>: PQC algorithms are only supported in TLSv1.3. Both servers are configured
 *       to reject older TLS versions.</li>
 *   <li><b>Conscrypt Provider</b>: We register Conscrypt as the highest priority security provider
 *       to ensure PQC support is available.</li>
 *   <li><b>Named Groups Restriction</b>: We set the system property {@code jdk.tls.namedGroups} to
 *       {@code X25519MLKEM768}. This forces the JVM to only accept connections that agree to use
 *       this specific hybrid PQC algorithm for key exchange.</li>
 *   <li><b>gRPC Handler</b>: For gRPC, we force the use of the JDK SSL provider instead of native
 *       OpenSSL, ensuring it respects the {@code jdk.tls.namedGroups} property.</li>
 * </ul>
 *
 * <h3>Role in Test Matrix</h3>
 * This server is used by two different modules:
 * <ul>
 *   <li>{@code pqc-test-snapshot}: Runs against the latest SDK code. It is configured with
 *       {@code -Dpqc.enable=true} which triggers manual PQC injection on the client side, allowing
 *       successful connections (tests pass).</li>
 *   <li>{@code pqc-test-release}: Runs against a released version of GAX (v2.78.0). It does not have
 *       PQC support enabled, causing connections to fail (tests fail as expected), validating our
 *       detection of non-compliant clients.</li>
 * </ul>
 */
public class PqcTestServer {

  private HttpsServer httpServer;
  private Server grpcServer;
  private int httpPort;
  private int grpcPort;

  public void start() throws Exception {
    // CRITICAL: Register Conscrypt as the highest priority security provider.
    // This ensures that when we request TLSv1.3, Conscrypt is chosen, which supports PQC.
    Security.insertProviderAt(org.conscrypt.Conscrypt.newProvider(), 1);
    
    // CRITICAL: Force the JVM to ONLY use the X25519MLKEM768 named group for key agreement.
    // This is the post-quantum algorithm we want to enforce. By setting this globally on the server,
    // the server will reject any handshake that does not propose this specific group.
    System.setProperty("jdk.tls.namedGroups", "X25519MLKEM768");


		// PKCS12 is the key store format to bundle the private key + the certificate.
    KeyStore ks = KeyStore.getInstance("PKCS12");
    try (InputStream is = getClass().getResourceAsStream("/pqctest.p12")) {
      if (is == null) {
        throw new RuntimeException("pqctest.p12 not found in classpath");
      }
			// Load the key with a dummy password
      ks.load(is, "password".toCharArray());
    }

		// Key manager factory used to create instances responsible for choosing credentials
		// for the TLS handshake.
    KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    kmf.init(ks, "password".toCharArray());

		// This factory's instances decide whether a client should be trusted (if mTLS is enabled).
		// However, it is here only used to load the keystore.
    javax.net.ssl.TrustManagerFactory tmf = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm());
    tmf.init(ks);

    // 1. Start HTTP Server
    // We explicitly request TLSv1.3 and force the use of the Conscrypt provider
    // which we registered above and configured to use only the PQC group.
    SSLContext sslContext = SSLContext.getInstance("TLSv1.3", "Conscrypt");
    sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

    httpServer = HttpsServer.create(new InetSocketAddress(0), 0);
    httpServer.setHttpsConfigurator(new HttpsConfigurator(sslContext) {
      @Override
      public void configure(HttpsParameters params) {
        SSLParameters sslparams = getSSLContext().getDefaultSSLParameters();
        // Enforce TLSv1.3 protocol, as PQC algorithms are only supported in TLSv1.3.
				// Java 11+ supports TLSv1.3, so does gRPC, therefore we expect the failures not to
				// be due to TLS version but about the missing PQC algorithm.
        sslparams.setProtocols(new String[]{"TLSv1.3"});
        params.setSSLParameters(sslparams);
      }
    });
    httpServer.createContext("/test", exchange -> {
      String response = "PQC HTTP OK";
      exchange.sendResponseHeaders(200, response.length());
      exchange.getResponseBody().write(response.getBytes());
      exchange.getResponseBody().close();
    });
    httpServer.start();
    httpPort = httpServer.getAddress().getPort();

    // 2. Start gRPC Server
    // For gRPC, we use Netty's SslContextBuilder but explicitly choose the JDK provider.
    // This forces Netty to use the standard Java JCA/JSSE mechanisms instead of native OpenSSL/BoringSSL.
    // Since we configured the JDK (via Conscrypt and system properties) to only allow the PQC group,
    // this ensures the gRPC server also enforces PQC.
    io.netty.handler.ssl.SslContext nettySslContext = io.grpc.netty.GrpcSslContexts.configure(
        io.netty.handler.ssl.SslContextBuilder.forServer(kmf),
        io.netty.handler.ssl.SslProvider.JDK
    )
    .protocols("TLSv1.3") // Enforce TLSv1.3 for gRPC as well
    .build();

    io.grpc.MethodDescriptor<byte[], byte[]> method = io.grpc.MethodDescriptor.<byte[], byte[]>newBuilder()
        .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
        .setFullMethodName("Greeter/SayHello")
        .setRequestMarshaller(new ByteMarshaller())
        .setResponseMarshaller(new ByteMarshaller())
        .build();

    io.grpc.ServerServiceDefinition serviceDef = io.grpc.ServerServiceDefinition.builder("Greeter")
        .addMethod(method, io.grpc.stub.ServerCalls.asyncUnaryCall(
            (request, responseObserver) -> {
              responseObserver.onNext("PQC gRPC OK".getBytes());
              responseObserver.onCompleted();
            }))
        .build();

    grpcServer = NettyServerBuilder.forPort(0)
        .sslContext(nettySslContext)
        .addService(serviceDef)
        .build()
        .start();
    grpcPort = grpcServer.getPort();
    
    // Remove Conscrypt from global providers so client doesn't use it by default
    java.security.Security.removeProvider("Conscrypt");
  }

  public void stop() {
    if (httpServer != null) httpServer.stop(0);
    if (grpcServer != null) grpcServer.shutdown();
  }

  public int getHttpPort() { return httpPort; }
  public int getGrpcPort() { return grpcPort; }

  private static class ByteMarshaller implements io.grpc.MethodDescriptor.Marshaller<byte[]> {
    @Override
    public InputStream stream(byte[] value) {
      return new java.io.ByteArrayInputStream(value);
    }
    @Override
    public byte[] parse(InputStream stream) {
      try {
        return com.google.common.io.ByteStreams.toByteArray(stream);
      } catch (java.io.IOException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
