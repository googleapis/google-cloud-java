package com.google.api.gax.httpjson;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.gax.pqc.PqcTestServer;
import io.grpc.ManagedChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import java.io.InputStream;
import java.net.URL;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.Security;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.NoCredentials;
import com.google.cloud.TransportOptions;
import com.google.cloud.http.HttpTransportOptions;
import com.google.auth.http.HttpTransportFactory;

/**
 * PqcConnectivityTest serves as the base class for validating Post-Quantum Cryptography (PQC)
 * connectivity in the Google Cloud Java SDK.
 */
public class PqcConnectivityTest {

  private static PqcTestServer server;

  @BeforeAll
  public static void setup() throws Exception {
    System.setProperty("javax.net.debug", "all");
    
    // NOTE: Enforcing MLKEM768 globally via system property is strictly isolated to this test JVM execution.
    // This ensures that the SunJSSE engine (used by old released libraries when pqc.enable is false)
    // attempts to negotiate MLKEM768. Since SunJSSE does not implement MLKEM768, it immediately
    // aborts the handshake with a handshake_failure, allowing us to confirm that older client libraries
    // cleanly fail-fast as expected, validating the integration test negative assertions.
    System.setProperty("jdk.tls.namedGroups", "MLKEM768");
    
    Security.addProvider(new BouncyCastleProvider());
    if (Boolean.getBoolean("pqc.enable")) {
        Security.insertProviderAt(new BouncyCastleJsseProvider(), 1);
    } else {
        Security.addProvider(new BouncyCastleJsseProvider());
    }
    
    server = new PqcTestServer();
    server.start();
  }

  @AfterAll
  public static void teardown() {
    if (server != null) {
      server.stop();
    }
    Security.removeProvider("BCJSSE");
    Security.removeProvider("BC");
  }

  public void runTests() throws Exception {
    testHttpPqc();
    testGrpcPqc();
    testBigQueryPqc();
  }

  @Test
  public void testHttpPqc() throws Exception {
    java.security.KeyStore ks = java.security.KeyStore.getInstance("PKCS12");
    ks.load(PqcTestServer.class.getResourceAsStream("/pqctest.p12"), "password".toCharArray());
    
    javax.net.ssl.TrustManagerFactory tmf = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm());
    tmf.init(ks);
    
    // Build a custom HttpTransport explicitly trusting the self-signed certificate keystore.
    com.google.api.client.http.HttpTransport httpTransport = new com.google.api.client.http.javanet.NetHttpTransport.Builder()
        .trustCertificates(ks)
        .build();
        
    // Pass the pre-configured httpTransport to the InstantiatingHttpJsonChannelProvider.
    InstantiatingHttpJsonChannelProvider provider = InstantiatingHttpJsonChannelProvider.newBuilder()
        .setEndpoint("localhost:" + server.getHttpPort())
        .setHeaderProvider(() -> java.util.Collections.emptyMap())
        .setHttpTransport(httpTransport)
        .build();

    HttpJsonTransportChannel transportChannel = provider.getTransportChannel();
    ManagedHttpJsonChannel managedChannel = transportChannel.getManagedChannel();
    
    while (managedChannel instanceof ManagedHttpJsonInterceptorChannel) {
      managedChannel = ((ManagedHttpJsonInterceptorChannel) managedChannel).getChannel();
    }
    
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

    InstantiatingGrpcChannelProvider.Builder providerBuilder = InstantiatingGrpcChannelProvider.newBuilder()
        .setEndpoint("localhost:" + server.getGrpcPort())
        .setHeaderProvider(() -> java.util.Collections.emptyMap());
        
    if (Boolean.getBoolean("pqc.enable")) {
        providerBuilder.setChannelConfigurator(new com.google.api.core.ApiFunction<io.grpc.ManagedChannelBuilder, io.grpc.ManagedChannelBuilder>() {
            @Override
            public io.grpc.ManagedChannelBuilder apply(io.grpc.ManagedChannelBuilder builder) {
                builder.overrideAuthority("localhost");
                
                // Using reflection for the test since grpc-netty-shaded is runtime in gax-grpc compilation context,
                // but we can configure it dynamically using SslContextBuilder's sslContextProvider.
                String builderClassName = builder.getClass().getName();
                if ("io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder".equals(builderClassName)) {
                    try {
                        // Reflectively configure shaded Netty using Bouncy Castle JJSSE
                        Class<?> sslContextBuilderClass = Class.forName("io.grpc.netty.shaded.io.netty.handler.ssl.SslContextBuilder");
                        Class<?> sslProviderEnum = Class.forName("io.grpc.netty.shaded.io.netty.handler.ssl.SslProvider");
                        Object sslProviderJdk = Enum.valueOf((Class<Enum>) sslProviderEnum, "JDK");
                        
                        Class<?> apnClass = Class.forName("io.grpc.netty.shaded.io.netty.handler.ssl.ApplicationProtocolConfig");
                        Class<?> protocolEnum = Class.forName("io.grpc.netty.shaded.io.netty.handler.ssl.ApplicationProtocolConfig$Protocol");
                        Object alpnProtocol = Enum.valueOf((Class<Enum>) protocolEnum, "ALPN");
                        Class<?> selectorBehaviorEnum = Class.forName("io.grpc.netty.shaded.io.netty.handler.ssl.ApplicationProtocolConfig$SelectorFailureBehavior");
                        Object noAdvertiseBehavior = Enum.valueOf((Class<Enum>) selectorBehaviorEnum, "NO_ADVERTISE");
                        Class<?> listenerBehaviorEnum = Class.forName("io.grpc.netty.shaded.io.netty.handler.ssl.ApplicationProtocolConfig$SelectedListenerFailureBehavior");
                        Object acceptBehavior = Enum.valueOf((Class<Enum>) listenerBehaviorEnum, "ACCEPT");
                        
                        java.lang.reflect.Constructor<?> apnConstructor = apnClass.getConstructor(
                            protocolEnum, selectorBehaviorEnum, listenerBehaviorEnum, String[].class
                        );
                        Object apn = apnConstructor.newInstance(alpnProtocol, noAdvertiseBehavior, acceptBehavior, new String[]{"h2"});

                        Class<?> tmFactoryClass = Class.forName("io.grpc.netty.shaded.io.netty.handler.ssl.util.InsecureTrustManagerFactory");
                        Object tmFactoryInstance = tmFactoryClass.getField("INSTANCE").get(null);

                        java.lang.reflect.Method forClientMethod = Class.forName("io.grpc.netty.shaded.io.netty.handler.ssl.SslContextBuilder").getMethod("forClient");
                        Object scBuilder = forClientMethod.invoke(null);
                        
                        // Configure SslContextBuilder
                        scBuilder.getClass().getMethod("sslProvider", sslProviderEnum).invoke(scBuilder, sslProviderJdk);
                        scBuilder.getClass().getMethod("sslContextProvider", java.security.Provider.class).invoke(scBuilder, new BouncyCastleJsseProvider());
                        scBuilder.getClass().getMethod("protocols", String[].class).invoke(scBuilder, (Object) new String[]{"TLSv1.3"});
                        scBuilder.getClass().getMethod("applicationProtocolConfig", apnClass).invoke(scBuilder, apn);
                        scBuilder.getClass().getMethod("trustManager", javax.net.ssl.TrustManagerFactory.class).invoke(scBuilder, tmFactoryInstance);
                        
                        Object shadedSslContext = scBuilder.getClass().getMethod("build").invoke(scBuilder);
                        
                        Class<?> sslContextClass = Class.forName("io.grpc.netty.shaded.io.netty.handler.ssl.SslContext");
                        builder.getClass().getMethod("sslContext", sslContextClass).invoke(builder, shadedSslContext);
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

  @Test
  public void testBigQueryPqc() throws Exception {
    java.security.KeyStore ks = java.security.KeyStore.getInstance("PKCS12");
    ks.load(PqcTestServer.class.getResourceAsStream("/pqctest.p12"), "password".toCharArray());
    
    // Build a custom HttpTransport explicitly trusting the self-signed certificate keystore.
    final com.google.api.client.http.HttpTransport httpTransport = new com.google.api.client.http.javanet.NetHttpTransport.Builder()
        .trustCertificates(ks)
        .build();
        
    TransportOptions transportOptions = HttpTransportOptions.newBuilder()
        .setHttpTransportFactory(new HttpTransportFactory() {
          @Override
          public com.google.api.client.http.HttpTransport create() {
            return httpTransport;
          }
        })
        .build();

    BigQueryOptions bigqueryOptions = BigQueryOptions.newBuilder()
        .setProjectId("test-project")
        .setHost("https://localhost:" + server.getHttpPort())
        .setCredentials(NoCredentials.getInstance())
        .setTransportOptions(transportOptions)
        .build();

    BigQuery bigquery = bigqueryOptions.getService();
    
    // This will trigger a request to https://localhost:httpPort/bigquery/v2/projects/test-project/datasets
    // Handshake must succeed. If it fails, it throws SSLHandshakeException.
    bigquery.listDatasets();
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
