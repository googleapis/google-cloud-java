/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.executor.spanner;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.api.gax.rpc.TransportChannel;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.spanner.spi.v1.TraceContextInterceptor;
import com.google.common.net.HostAndPort;
import io.grpc.ManagedChannelBuilder;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.InternalNettyChannelBuilder;
import io.grpc.netty.shaded.io.grpc.netty.NegotiationType;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContext;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;

public class CloudUtil {

  // If this is set too low, the peer server may return RESOURCE_EXHAUSTED errors if the response
  // error message causes the trailing headers to exceed this limit.
  private static final int GRPC_MAX_HEADER_LIST_SIZE_BYTES = 10 * 1024 * 1024;

  private static final String TEST_HOST_IN_CERT = "test-cert-2";

  public static TransportChannelProvider newChannelProviderHelper(int port) {
    NettyChannelBuilder builder =
        (NettyChannelBuilder)
            getChannelBuilderForTestGFE("localhost", port, WorkerProxy.cert, TEST_HOST_IN_CERT)
                .maxInboundMessageSize(100 * 1024 * 1024 /* 100 MB */);
    if (WorkerProxy.usePlainTextChannel) {
      builder.usePlaintext();
    }
    TransportChannel channel =
        GrpcTransportChannel.newBuilder()
            .setManagedChannel(
                builder.maxInboundMetadataSize(GRPC_MAX_HEADER_LIST_SIZE_BYTES).build())
            .build();
    return FixedTransportChannelProvider.create(channel);
  }

  public static ManagedChannelBuilder<?> getChannelBuilderForTestGFE(
      String host, int sslPort, String certPath, String hostInCert) {
    SslContext sslContext;
    try {
      sslContext =
          GrpcSslContexts.forClient()
              .trustManager(CertUtil.copyCert(certPath))
              .ciphers(null)
              .build();
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }

    HostAndPort hostPort = HostAndPort.fromParts(host, sslPort);
    String target;
    try {
      target = new URI("dns", "", "/" + hostPort, null).toString();
    } catch (URISyntaxException ex) {
      throw new RuntimeException(ex);
    }
    try {
      NettyChannelBuilder channelBuilder = NettyChannelBuilder.forTarget(target);
      InternalNettyChannelBuilder.disableCheckAuthority(channelBuilder);

      return channelBuilder
          .overrideAuthority(hostInCert)
          .sslContext(sslContext)
          .intercept(new TraceContextInterceptor(WorkerProxy.openTelemetrySdk))
          .negotiationType(NegotiationType.TLS);
    } catch (Throwable t) {
      throw new RuntimeException(t);
    }
  }

  static final class CertUtil {
    private CertUtil() {
      // prevent instantiation
    }

    /** Copies cert resource to file, stripping out PEM comments. */
    public static File copyCert(String certFileName) throws IOException {
      File certFile = new File(certFileName);
      File file = File.createTempFile("CAcert", "pem");
      file.deleteOnExit();
      try (BufferedReader in =
              new BufferedReader(new InputStreamReader(new FileInputStream(certFile), UTF_8));
          Writer out = new OutputStreamWriter(new FileOutputStream(file), UTF_8)) {
        String line;
        do {
          while ((line = in.readLine()) != null) {
            if ("-----BEGIN CERTIFICATE-----".equals(line)) {
              break;
            }
          }
          out.append(line);
          out.append("\n");
          while ((line = in.readLine()) != null) {
            out.append(line);
            out.append("\n");
            if ("-----END CERTIFICATE-----".equals(line)) {
              break;
            }
          }
        } while (line != null);
      }
      return file;
    }
  }
}
