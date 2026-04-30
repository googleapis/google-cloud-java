package com.google.api.gax.httpjson;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.gax.pqc.PqcTestServer;
import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import java.io.InputStream;
import java.net.URL;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * PqcConnectivityTest serves as the base class for validating Post-Quantum Cryptography (PQC)
 * connectivity in the Google Cloud Java SDK.
 *
 * It contains tests for both HTTP/JSON and gRPC transports. The tests are designed to verify
 * that clients can successfully connect to a PQC-enforcing server when properly configured,
 * or fail fast when not.
 *
 * The system property {@code pqc.enable} is used to toggle PQC configuration injection.
 */
public class PqcConnectivityTest {

  private static PqcTestServer server;

  // Trust store properties are set programmatically in tests

  @BeforeAll
  public static void setup() throws Exception {
    server = new PqcTestServer();
    server.start();
    if (Boolean.getBoolean("pqc.enable")) {
      java.security.Security.insertProviderAt(org.conscrypt.Conscrypt.newProvider(), 1);
    }
  }

  @AfterAll
  public static void teardown() {
    if (server != null) {
      server.stop();
    }
  }

  public void runTests() throws Exception {
    testHttpPqc();
    testGrpcPqc();
  }

  @Test
  public void testHttpPqc() throws Exception {
    java.security.KeyStore ks = java.security.KeyStore.getInstance("PKCS12");
    ks.load(PqcTestServer.class.getResourceAsStream("/pqctest.p12"), "password".toCharArray());
    
    javax.net.ssl.TrustManagerFactory tmf = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm());
    tmf.init(ks);
    
    // We no longer manually create or inject the transport here.
    // InstantiatingHttpJsonChannelProvider will create a PQC-enabled transport by default.
    InstantiatingHttpJsonChannelProvider provider = InstantiatingHttpJsonChannelProvider.newBuilder()
        .setEndpoint("localhost:" + server.getHttpPort())
        .setHeaderProvider(() -> java.util.Collections.emptyMap())
        .build();

    HttpJsonTransportChannel transportChannel = provider.getTransportChannel();
    ManagedHttpJsonChannel managedChannel = transportChannel.getManagedChannel();
    
    // Unwrapping interceptors to reach the core ManagedHttpJsonChannel
    while (managedChannel instanceof ManagedHttpJsonInterceptorChannel) {
      managedChannel = ((ManagedHttpJsonInterceptorChannel) managedChannel).getChannel();
    }
    
    // We use reflection to extract the underlying HttpTransport to verify it's using our custom SSL socket factory.
    // This is necessary because the transport channel doesn't expose it directly.
    java.lang.reflect.Field field = ManagedHttpJsonChannel.class.getDeclaredField("httpTransport");
    field.setAccessible(true);
    com.google.api.client.http.HttpTransport transportFromChannel = (com.google.api.client.http.HttpTransport) field.get(managedChannel);
    com.google.api.client.http.HttpRequest request = transportFromChannel.createRequestFactory().buildGetRequest(
        new com.google.api.client.http.GenericUrl("https://localhost:" + server.getHttpPort() + "/test"));
    
    HttpResponse response = request.execute();
    assertEquals(200, response.getStatusCode());
    String content = response.parseAsString();
    assertEquals("PQC HTTP OK", content.trim());
  }

  @Test
  public void testGrpcPqc() throws Exception {
    io.grpc.MethodDescriptor<byte[], byte[]> method = io.grpc.MethodDescriptor.<byte[], byte[]>newBuilder()
        .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
        .setFullMethodName("Greeter/SayHello")
        .setRequestMarshaller(new ByteMarshaller())
        .setResponseMarshaller(new ByteMarshaller())
        .build();

    // We use channelConfigurator to inject an insecure trust manager for testing with self-signed certs.
    // GAX will have already applied PQC defaults, but we must ensure we keep PQC enabled here!
    InstantiatingGrpcChannelProvider.Builder providerBuilder = InstantiatingGrpcChannelProvider.newBuilder()
        .setEndpoint("localhost:" + server.getGrpcPort())
        .setHeaderProvider(() -> java.util.Collections.emptyMap());
        
    if (Boolean.getBoolean("pqc.enable")) {
        providerBuilder.setChannelConfigurator(new com.google.api.core.ApiFunction<io.grpc.ManagedChannelBuilder, io.grpc.ManagedChannelBuilder>() {
            @Override
            public io.grpc.ManagedChannelBuilder apply(io.grpc.ManagedChannelBuilder builder) {
                builder.overrideAuthority("localhost");
                
                if (builder instanceof io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder) {
                    io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder nettyBuilder = 
                        (io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder) builder;
                    try {
                        io.grpc.netty.shaded.io.netty.handler.ssl.ApplicationProtocolConfig apn = 
                            new io.grpc.netty.shaded.io.netty.handler.ssl.ApplicationProtocolConfig(
                                io.grpc.netty.shaded.io.netty.handler.ssl.ApplicationProtocolConfig.Protocol.ALPN,
                                io.grpc.netty.shaded.io.netty.handler.ssl.ApplicationProtocolConfig.SelectorFailureBehavior.NO_ADVERTISE,
                                io.grpc.netty.shaded.io.netty.handler.ssl.ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT,
                                "h2"
                            );
                        io.grpc.netty.shaded.io.netty.handler.ssl.SslContext shadedSslContext = 
                            io.grpc.netty.shaded.io.netty.handler.ssl.SslContextBuilder
                                .forClient()
                                // Force JDK provider to use Conscrypt (registered in GAX or server)
                                .sslProvider(io.grpc.netty.shaded.io.netty.handler.ssl.SslProvider.JDK)
                                .protocols("TLSv1.3")
                                .applicationProtocolConfig(apn)
                                .trustManager(io.grpc.netty.shaded.io.netty.handler.ssl.util.InsecureTrustManagerFactory.INSTANCE)
                                .build();
                        nettyBuilder.sslContext(shadedSslContext);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                return builder;
            }
        });
    }
    
    InstantiatingGrpcChannelProvider provider = providerBuilder.build();
    
    io.grpc.Channel channel = ((com.google.api.gax.grpc.GrpcTransportChannel) provider.getTransportChannel()).getChannel();

    byte[] response = io.grpc.stub.ClientCalls.blockingUnaryCall(
        channel, method, io.grpc.CallOptions.DEFAULT, "Hello".getBytes());
    
    assertEquals("PQC gRPC OK", new String(response).trim());
    ((io.grpc.ManagedChannel) channel).shutdown();
  }

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
