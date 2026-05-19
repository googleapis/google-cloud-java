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
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * PqcTestServer is a specialized test harness designed to validate Post-Quantum Cryptography (PQC)
 * transport enforcement in the Google Cloud Java SDK.
 */
public class PqcTestServer {

  private HttpsServer httpServer;
  private Server grpcServer;
  private int httpPort;
  private int grpcPort;

  public void start() throws Exception {
    // 1. BouncyCastleProvider (JCA provider, name "BC"): Implements low-level cryptographic algorithms
    //    like signature generation, hashing, key agreement, and ML-KEM key representations.
    Security.addProvider(new BouncyCastleProvider());
    
    // 2. BouncyCastleJsseProvider (JSSE provider, name "BCJSSE"): Implements high-level TLS protocol support
    //    (TLSv1.3 engines, cipher suites, extensions, and socket factories). It depends on the JCA provider.
    Security.addProvider(new BouncyCastleJsseProvider());
    
    // Set system property to strictly enforce ML-KEM hybrid named group on the server.
    // NOTE: This system property is set strictly inside test harness setup.
    // Since this server class is only compiled and executed inside integration test contexts,
    // it has zero impact on production runtimes (which never load or execute this class).
    System.setProperty("jdk.tls.namedGroups", "MLKEM768");

    // PKCS12 is the key store format to bundle the private key + the certificate.
    KeyStore ks = KeyStore.getInstance("PKCS12");
    try (InputStream is = getClass().getResourceAsStream("/pqctest.p12")) {
      if (is == null) {
        throw new RuntimeException("pqctest.p12 not found in classpath");
      }
      // Load the key with a dummy password
      ks.load(is, "password".toCharArray());
    }

    // Key manager factory used to choose credentials for the TLS handshake.
    KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    kmf.init(ks, "password".toCharArray());

    // Trust manager factory used to decide whether a client should be trusted.
    javax.net.ssl.TrustManagerFactory tmf = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm());
    tmf.init(ks);

    // 1. Start HTTP Server utilizing Bouncy Castle JJSSE
    BouncyCastleJsseProvider bcProvider = new BouncyCastleJsseProvider();
    SSLContext sslContext = SSLContext.getInstance("TLSv1.3", bcProvider);
    sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

    httpServer = HttpsServer.create(new InetSocketAddress(0), 0);
    httpServer.setHttpsConfigurator(new HttpsConfigurator(sslContext) {
      @Override
      public void configure(HttpsParameters params) {
        SSLParameters sslparams = getSSLContext().getDefaultSSLParameters();
        // Enforce TLSv1.3 protocol
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

    // 2. Start gRPC Server using JDK SSL Provider bound specifically to Bouncy Castle JJSSE
    io.netty.handler.ssl.SslContext nettySslContext = io.grpc.netty.GrpcSslContexts.configure(
        io.netty.handler.ssl.SslContextBuilder.forServer(kmf)
            .sslContextProvider(bcProvider), // Bind Netty statically to BC JJSSE!
        io.netty.handler.ssl.SslProvider.JDK
    )
    .protocols("TLSv1.3") // Enforce TLSv1.3
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
  }

  public void stop() {
    if (httpServer != null) httpServer.stop(0);
    if (grpcServer != null) grpcServer.shutdown();
    // Remove BC JCA and JSSE providers on stop
    Security.removeProvider("BCJSSE");
    Security.removeProvider("BC");
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
