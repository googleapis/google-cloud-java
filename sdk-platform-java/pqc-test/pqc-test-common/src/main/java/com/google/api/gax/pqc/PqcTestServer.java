/*
 * Copyright 2026 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.pqc;

import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsParameters;
import com.sun.net.httpserver.HttpsServer;
import io.grpc.Server;
import io.grpc.netty.NettyServerBuilder;
import io.netty.handler.ssl.ApplicationProtocolConfig;
import io.netty.handler.ssl.ClientAuth;
import io.netty.handler.ssl.IdentityCipherSuiteFilter;
import io.netty.handler.ssl.JdkSslContext;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.util.List;
import java.util.function.BiFunction;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;

/**
 * PqcTestServer is a specialized test harness designed to validate Post-Quantum Cryptography (PQC)
 * transport enforcement in the Google Cloud Java SDK.
 */
public class PqcTestServer {

  private HttpsServer httpServerPqc;
  private HttpsServer httpServerClassical;
  private Server grpcServerPqc;
  private Server grpcServerClassical;
  private int httpPqcPort;
  private int httpClassicalPort;
  private int grpcPqcPort;
  private int grpcClassicalPort;

  public void start() throws Exception {

    KeyStore ks = KeyStore.getInstance("PKCS12");
    try (InputStream is = getClass().getResourceAsStream("/pqctest.p12")) {
      if (is == null) {
        throw new RuntimeException("pqctest.p12 not found in classpath");
      }
      ks.load(is, "password".toCharArray());
    }

    KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    kmf.init(ks, "password".toCharArray());

    javax.net.ssl.TrustManagerFactory tmf =
        javax.net.ssl.TrustManagerFactory.getInstance(
            javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm());
    tmf.init(ks);

    BouncyCastleProvider bcProvider = new BouncyCastleProvider();
    BouncyCastleJsseProvider bcJsseProvider = new BouncyCastleJsseProvider(bcProvider);
    SSLContext bcContext = SSLContext.getInstance("TLSv1.3", bcJsseProvider);
    bcContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

    SSLContext pqcEnforcingSslContext =
        new SSLContext(
            new PqcEnforcingSSLContextSpi(bcContext),
            bcContext.getProvider(),
            bcContext.getProtocol()) {};

    SSLContext classicalSslContext = bcContext;

    httpServerPqc = HttpsServer.create(new InetSocketAddress(0), 0);
    configureHttpServer(httpServerPqc, pqcEnforcingSslContext);
    httpServerPqc.start();
    httpPqcPort = httpServerPqc.getAddress().getPort();

    httpServerClassical = HttpsServer.create(new InetSocketAddress(0), 0);
    configureHttpServer(httpServerClassical, classicalSslContext);
    httpServerClassical.start();
    httpClassicalPort = httpServerClassical.getAddress().getPort();

    ApplicationProtocolConfig apn =
        new ApplicationProtocolConfig(
            ApplicationProtocolConfig.Protocol.ALPN,
            ApplicationProtocolConfig.SelectorFailureBehavior.NO_ADVERTISE,
            ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT,
            "h2");

    io.netty.handler.ssl.SslContext nettySslContextPqc =
        new JdkSslContext(
            pqcEnforcingSslContext, false, null, IdentityCipherSuiteFilter.INSTANCE, apn, ClientAuth.NONE);

    io.netty.handler.ssl.SslContext nettySslContextClassical =
        new JdkSslContext(
            classicalSslContext, false, null, IdentityCipherSuiteFilter.INSTANCE, apn, ClientAuth.NONE);

    grpcServerPqc = createGrpcServer(nettySslContextPqc);
    grpcServerPqc.start();
    grpcPqcPort = grpcServerPqc.getPort();

    grpcServerClassical = createGrpcServer(nettySslContextClassical);
    grpcServerClassical.start();
    grpcClassicalPort = grpcServerClassical.getPort();
  }

  private void configureHttpServer(HttpsServer server, SSLContext sslContext) {
    server.setHttpsConfigurator(
        new HttpsConfigurator(sslContext) {
          @Override
          public void configure(HttpsParameters params) {
            SSLParameters sslparams = getSSLContext().getDefaultSSLParameters();
            sslparams.setProtocols(new String[] {"TLSv1.3"});
            params.setSSLParameters(sslparams);
          }
        });

    server.createContext(
        "/test",
        exchange -> {
          String response = "PQC HTTP OK";
          exchange.sendResponseHeaders(200, response.length());
          exchange.getResponseBody().write(response.getBytes());
          exchange.getResponseBody().close();
        });

    server.createContext(
        "/bigquery/v2/projects/test-project/datasets",
        exchange -> {
          String response = "{\"kind\": \"bigquery#datasetList\"}";
          exchange.getResponseHeaders().set("Content-Type", "application/json");
          exchange.sendResponseHeaders(200, response.length());
          exchange.getResponseBody().write(response.getBytes());
          exchange.getResponseBody().close();
        });

    server.createContext(
        "/v3/",
        exchange -> {
          if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
            String response =
                "{\"translations\": [{\"translatedText\": \"mocked translated text\"}]}";
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.length());
            try (OutputStream os = exchange.getResponseBody()) {
              os.write(response.getBytes());
            }
          }
        });
  }

  private Server createGrpcServer(io.netty.handler.ssl.SslContext nettySslContext) {
    io.grpc.MethodDescriptor<byte[], byte[]> method =
        io.grpc.MethodDescriptor.<byte[], byte[]>newBuilder()
            .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
            .setFullMethodName("Greeter/SayHello")
            .setRequestMarshaller(new ByteMarshaller())
            .setResponseMarshaller(new ByteMarshaller())
            .build();

    io.grpc.ServerServiceDefinition serviceDef =
        io.grpc.ServerServiceDefinition.builder("Greeter")
            .addMethod(
                method,
                io.grpc.stub.ServerCalls.asyncUnaryCall(
                    (request, responseObserver) -> {
                      responseObserver.onNext("PQC gRPC OK".getBytes());
                      responseObserver.onCompleted();
                    }))
            .build();

    io.grpc.MethodDescriptor<byte[], byte[]> translateMethod =
        io.grpc.MethodDescriptor.<byte[], byte[]>newBuilder()
            .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
            .setFullMethodName("google.cloud.translation.v3.TranslationService/TranslateText")
            .setRequestMarshaller(new ByteMarshaller())
            .setResponseMarshaller(new ByteMarshaller())
            .build();

    io.grpc.ServerServiceDefinition translationServiceDef =
        io.grpc.ServerServiceDefinition.builder("google.cloud.translation.v3.TranslationService")
            .addMethod(
                translateMethod,
                io.grpc.stub.ServerCalls.asyncUnaryCall(
                    (request, responseObserver) -> {
                      responseObserver.onNext(new byte[0]); // Empty proto response
                      responseObserver.onCompleted();
                    }))
            .build();

    return NettyServerBuilder.forPort(0)
        .sslContext(nettySslContext)
        .addService(serviceDef)
        .addService(translationServiceDef)
        .build();
  }

  public void stop() {
    if (httpServerPqc != null) httpServerPqc.stop(0);
    if (httpServerClassical != null) httpServerClassical.stop(0);
    if (grpcServerPqc != null) grpcServerPqc.shutdown();
    if (grpcServerClassical != null) grpcServerClassical.shutdown();
  }

  public int getHttpPqcPort() {
    return httpPqcPort;
  }

  public int getHttpClassicalPort() {
    return httpClassicalPort;
  }

  public int getGrpcPqcPort() {
    return grpcPqcPort;
  }

  public int getGrpcClassicalPort() {
    return grpcClassicalPort;
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

  public static void main(String[] args) throws Exception {
    PqcTestServer server = new PqcTestServer();
    server.start();

    System.out.println("HTTP_PQC_PORT: " + server.getHttpPqcPort());
    System.out.println("HTTP_CLASSICAL_PORT: " + server.getHttpClassicalPort());
    System.out.println("GRPC_PQC_PORT: " + server.getGrpcPqcPort());
    System.out.println("GRPC_CLASSICAL_PORT: " + server.getGrpcClassicalPort());
    System.out.flush();

    try {
      while (System.in.read() != -1) {
        Thread.sleep(1000);
      }
    } catch (Exception e) {
    } finally {
      server.stop();
    }
  }

  @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
  private static class PqcEnforcingSSLEngine extends javax.net.ssl.SSLEngine {
    private final javax.net.ssl.SSLEngine delegate;

    PqcEnforcingSSLEngine(javax.net.ssl.SSLEngine delegate) {
      this.delegate = delegate;
    }

    @Override
    public void setSSLParameters(javax.net.ssl.SSLParameters params) {
      delegate.setSSLParameters(params);
      Object objEngine = delegate;
      if (objEngine instanceof org.bouncycastle.jsse.BCSSLEngine) {
        org.bouncycastle.jsse.BCSSLEngine bcEngine = (org.bouncycastle.jsse.BCSSLEngine) objEngine;
        org.bouncycastle.jsse.BCSSLParameters bcParams = bcEngine.getParameters();
        bcParams.setNamedGroups(new String[] {"X25519MLKEM768"});
        bcEngine.setParameters(bcParams);
      }
    }

    @Override
    public void setHandshakeApplicationProtocolSelector(
        BiFunction<SSLEngine, List<String>, String> selector) {
      delegate.setHandshakeApplicationProtocolSelector(
          (engine, protocols) -> selector.apply(this, protocols));
    }

    @Override
    public BiFunction<SSLEngine, List<String>, String> getHandshakeApplicationProtocolSelector() {
      return delegate.getHandshakeApplicationProtocolSelector();
    }

    @Override
    public String getApplicationProtocol() {
      return delegate.getApplicationProtocol();
    }

    @Override
    public String getHandshakeApplicationProtocol() {
      return delegate.getHandshakeApplicationProtocol();
    }

    @Override
    public javax.net.ssl.SSLParameters getSSLParameters() {
      return delegate.getSSLParameters();
    }

    @Override
    public void beginHandshake() throws javax.net.ssl.SSLException {
      delegate.beginHandshake();
    }

    @Override
    public void closeInbound() throws javax.net.ssl.SSLException {
      delegate.closeInbound();
    }

    @Override
    public void closeOutbound() {
      delegate.closeOutbound();
    }

    @Override
    public java.lang.Runnable getDelegatedTask() {
      return delegate.getDelegatedTask();
    }

    @Override
    public java.lang.String[] getEnabledCipherSuites() {
      return delegate.getEnabledCipherSuites();
    }

    @Override
    public java.lang.String[] getEnabledProtocols() {
      return delegate.getEnabledProtocols();
    }

    @Override
    public javax.net.ssl.SSLEngineResult.HandshakeStatus getHandshakeStatus() {
      return delegate.getHandshakeStatus();
    }

    @Override
    public boolean getNeedClientAuth() {
      return delegate.getNeedClientAuth();
    }

    @Override
    public javax.net.ssl.SSLSession getSession() {
      return delegate.getSession();
    }

    @Override
    public java.lang.String[] getSupportedCipherSuites() {
      return delegate.getSupportedCipherSuites();
    }

    @Override
    public java.lang.String[] getSupportedProtocols() {
      return delegate.getSupportedProtocols();
    }

    @Override
    public boolean getUseClientMode() {
      return delegate.getUseClientMode();
    }

    @Override
    public boolean getWantClientAuth() {
      return delegate.getWantClientAuth();
    }

    @Override
    public boolean isInboundDone() {
      return delegate.isInboundDone();
    }

    @Override
    public boolean isOutboundDone() {
      return delegate.isOutboundDone();
    }

    @Override
    public void setEnabledCipherSuites(java.lang.String[] suites) {
      delegate.setEnabledCipherSuites(suites);
    }

    @Override
    public void setEnabledProtocols(java.lang.String[] protocols) {
      delegate.setEnabledProtocols(protocols);
    }

    @Override
    public void setNeedClientAuth(boolean need) {
      delegate.setNeedClientAuth(need);
    }

    @Override
    public void setUseClientMode(boolean mode) {
      delegate.setUseClientMode(mode);
    }

    @Override
    public void setWantClientAuth(boolean want) {
      delegate.setWantClientAuth(want);
    }

    @Override
    public javax.net.ssl.SSLEngineResult unwrap(
        java.nio.ByteBuffer src, java.nio.ByteBuffer[] dsts, int offset, int length)
        throws javax.net.ssl.SSLException {
      return delegate.unwrap(src, dsts, offset, length);
    }

    @Override
    public javax.net.ssl.SSLEngineResult wrap(
        java.nio.ByteBuffer[] srcs, int offset, int length, java.nio.ByteBuffer dst)
        throws javax.net.ssl.SSLException {
      return delegate.wrap(srcs, offset, length, dst);
    }

    @Override
    public boolean getEnableSessionCreation() {
      return delegate.getEnableSessionCreation();
    }

    @Override
    public void setEnableSessionCreation(boolean flag) {
      delegate.setEnableSessionCreation(flag);
    }

    @Override
    public javax.net.ssl.SSLSession getHandshakeSession() {
      return delegate.getHandshakeSession();
    }
  }

  private static class PqcEnforcingSSLContextSpi extends javax.net.ssl.SSLContextSpi {
    private final javax.net.ssl.SSLContext delegate;

    PqcEnforcingSSLContextSpi(javax.net.ssl.SSLContext delegate) {
      this.delegate = delegate;
    }

    @Override
    protected javax.net.ssl.SSLEngine engineCreateSSLEngine() {
      return new PqcEnforcingSSLEngine(delegate.createSSLEngine());
    }

    @Override
    protected javax.net.ssl.SSLEngine engineCreateSSLEngine(java.lang.String host, int port) {
      return new PqcEnforcingSSLEngine(delegate.createSSLEngine(host, port));
    }

    @Override
    protected javax.net.ssl.SSLSessionContext engineGetClientSessionContext() {
      return delegate.getClientSessionContext();
    }

    @Override
    protected javax.net.ssl.SSLSessionContext engineGetServerSessionContext() {
      return delegate.getServerSessionContext();
    }

    @Override
    protected javax.net.ssl.SSLServerSocketFactory engineGetServerSocketFactory() {
      return delegate.getServerSocketFactory();
    }

    @Override
    protected javax.net.ssl.SSLSocketFactory engineGetSocketFactory() {
      return delegate.getSocketFactory();
    }

    @Override
    protected void engineInit(
        javax.net.ssl.KeyManager[] km,
        javax.net.ssl.TrustManager[] tm,
        java.security.SecureRandom sr)
        throws java.security.KeyManagementException {}
  }
}
