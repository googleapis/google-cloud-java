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
    //    Required so the JVM's security architecture recognizes post-quantum key formats and algorithms.
    Security.addProvider(new BouncyCastleProvider());
    
    // 2. BouncyCastleJsseProvider (JSSE provider, name "BCJSSE"): Implements high-level TLS protocol support
    //    (TLSv1.3 engines, cipher suites, extensions, and socket factories). It depends on the JCA provider.
    //    Required to negotiate PQC Named Groups (ML-KEM-768) during the TLS handshake.
    Security.addProvider(new BouncyCastleJsseProvider());
    
    // 3. Initialize the KeyStore instance utilizing PKCS12 format.
    //    PKCS12 format is an industry-standard format used to bundle the private key and certificate chain.
    KeyStore ks = KeyStore.getInstance("PKCS12");
    try (InputStream is = getClass().getResourceAsStream("/pqctest.p12")) {
      if (is == null) {
        throw new RuntimeException("pqctest.p12 not found in classpath");
      }
      // Load the self-signed certificate/private key from the resource archive with a dummy password.
      ks.load(is, "password".toCharArray());
    }

    // 4. Initialize KeyManagerFactory using the standard JRE algorithm (SunX509).
    //    Key managers choose the private key credentials (the server's identity) during TLS handshake negotiation.
    KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    kmf.init(ks, "password".toCharArray());

    // 5. Initialize TrustManagerFactory using the default JRE algorithm (PKIX).
    //    Trust managers evaluate whether peer certificates presented during TLS are trusted and valid.
    javax.net.ssl.TrustManagerFactory tmf = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm());
    tmf.init(ks);

    // 6. Initialize a dedicated SSLContext scoped specifically to Bouncy Castle JSSE.
    //    Specifying BouncyCastleJsseProvider prevents contamination of default JRE TLS contexts.
    BouncyCastleJsseProvider bcProvider = new BouncyCastleJsseProvider();
    SSLContext sslContext = SSLContext.getInstance("TLSv1.3", bcProvider);
    sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

    // 7. Instantiate a local mock HttpServer (bound to an ephemeral port 0).
    httpServer = HttpsServer.create(new InetSocketAddress(0), 0);
    
    // 8. Set HttpsConfigurator to intercept incoming connections and customize TLS handshakes.
    httpServer.setHttpsConfigurator(new HttpsConfigurator(sslContext) {
      @Override
      public void configure(HttpsParameters params) {
        // Retrieve the SSLContext default parameters.
        SSLParameters sslparams = getSSLContext().getDefaultSSLParameters();
        
        // Enforce TLSv1.3 protocol exclusively to guarantee modern cipher suites.
        sslparams.setProtocols(new String[]{"TLSv1.3"});
        
        // Note: Direct invocation of sslparams.setNamedGroups(new String[]{"MLKEM768"}) fails to compile
        // because this module targets Java 8, whereas setNamedGroups was introduced in Java 20.
        // Reflection is used here compile-safely to invoke the method when running under JRE 20+.
        try {
          java.lang.reflect.Method setNamedGroupsMethod = javax.net.ssl.SSLParameters.class.getMethod("setNamedGroups", String[].class);
          setNamedGroupsMethod.invoke(sslparams, (Object) new String[]{"MLKEM768"});
        } catch (Exception e) {
          // Fallback on JRE 17: Bouncy Castle JJSSE automatically reads the "org.bouncycastle.jsse.server.namedGroups"
          // system property to configure the accepted named groups on the server context.
          // Documentation reference: https://www.bouncycastle.org/docs/tlsdocs.html#SystemProperties
        }
        // Commit parameters to the active connection context.
        params.setSSLParameters(sslparams);
      }
    });
    
    // 9. Map simple mock endpoint contexts to simulate vanilla API server behavior.
    httpServer.createContext("/test", exchange -> {
      String response = "PQC HTTP OK";
      exchange.sendResponseHeaders(200, response.length());
      exchange.getResponseBody().write(response.getBytes());
      exchange.getResponseBody().close();
    });
    
    // 10. Map mock BigQuery datasets endpoint to simulate vanilla BigQuery dataset listing responses.
    httpServer.createContext("/bigquery/v2/projects/test-project/datasets", exchange -> {
      String response = "{\"kind\": \"bigquery#datasetList\"}";
      exchange.getResponseHeaders().set("Content-Type", "application/json");
      exchange.sendResponseHeaders(200, response.length());
      exchange.getResponseBody().write(response.getBytes());
      exchange.getResponseBody().close();
    });
    
    // 11. Start the HTTP Server and retrieve the dynamically allocated local ephemeral port.
    httpServer.start();
    httpPort = httpServer.getAddress().getPort();

    // 12. Initialize netty SSL Context builder to establish gRPC server channel secure layers.
    //     Bind the builder explicitly to Bouncy Castle JSSE provider context.
    io.netty.handler.ssl.SslContextBuilder nettySslContextBuilder = io.netty.handler.ssl.SslContextBuilder.forServer(kmf)
        .sslContextProvider(bcProvider);
    
    // 13. Reflectively configure the Netty SslContextBuilder accepted curves.
    //     Netty API curves methods differ depending on whether Netty is utilizing older Iterable-based
    //     curves signatures or modern String[] array-based curves signatures.
    try {
      try {
        java.lang.reflect.Method curvesMethod = nettySslContextBuilder.getClass().getMethod("curves", String[].class);
        curvesMethod.invoke(nettySslContextBuilder, (Object) new String[]{"MLKEM768"});
      } catch (NoSuchMethodException e) {
        java.lang.reflect.Method curvesMethod = nettySslContextBuilder.getClass().getMethod("curves", java.lang.Iterable.class);
        curvesMethod.invoke(nettySslContextBuilder, java.util.Arrays.asList("MLKEM768"));
      }
    } catch (Exception e) {
      System.err.println("Warning: Failed to programmatically configure Netty curves: " + e.getMessage());
    }

    // 14. Finalize compiling standard Netty SSL configurations.
    //     Force Netty to execute handshakes utilizing the standard JRE (JDK) SSL Provider
    //     so Bouncy Castle JJSSE (registered in the provider context) manages the secure pipelines.
    io.netty.handler.ssl.SslContext nettySslContext = io.grpc.netty.GrpcSslContexts.configure(
        nettySslContextBuilder,
        io.netty.handler.ssl.SslProvider.JDK
    )
    .protocols("TLSv1.3") // Force TLSv1.3 protocols
    .build();

    // 15. Build a raw gRPC method descriptor to mock a unary SayHello endpoint.
    io.grpc.MethodDescriptor<byte[], byte[]> method = io.grpc.MethodDescriptor.<byte[], byte[]>newBuilder()
        .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
        .setFullMethodName("Greeter/SayHello")
        .setRequestMarshaller(new ByteMarshaller())
        .setResponseMarshaller(new ByteMarshaller())
        .build();

    // 16. Wrap the method descriptor into a custom gRPC server service definition.
    io.grpc.ServerServiceDefinition serviceDef = io.grpc.ServerServiceDefinition.builder("Greeter")
        .addMethod(method, io.grpc.stub.ServerCalls.asyncUnaryCall(
            (request, responseObserver) -> {
              responseObserver.onNext("PQC gRPC OK".getBytes());
              responseObserver.onCompleted();
            }))
        .build();

    // 17. Start the Netty gRPC Server on a dynamically allocated ephemeral port.
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
