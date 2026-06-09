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

package com.google.cloud.spanner.omni;

import com.google.api.core.InternalApi;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.base.Preconditions;
import com.google.crypto.tink.util.SecretBytes;
import io.grpc.ManagedChannel;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContext;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Credentials implementation for Spanner Omni. Uses the OPAQUE protocol to authenticate and fetches
 * short-lived access tokens.
 */
public class SpannerOmniCredentials extends GoogleCredentials {
  private static final Logger logger = Logger.getLogger(SpannerOmniCredentials.class.getName());

  private final String username;
  private final SecretBytes password;
  private String target;
  private boolean usePlainText = false;
  private SslContext sslContext = null;

  public static SecretBytes convertToSecretBytes(char[] passwordChars) {
    byte[] passwordBytes = null;
    try {
      CharsetEncoder encoder = StandardCharsets.UTF_8.newEncoder();
      CharBuffer charBuffer = CharBuffer.wrap(passwordChars);
      ByteBuffer byteBuffer =
          ByteBuffer.allocate((int) (encoder.maxBytesPerChar() * charBuffer.remaining()));
      encoder.encode(charBuffer, byteBuffer, true);
      encoder.flush(byteBuffer);
      byteBuffer.flip();
      passwordBytes = new byte[byteBuffer.remaining()];
      byteBuffer.get(passwordBytes);
      Arrays.fill(byteBuffer.array(), (byte) 0);
      return SecretBytes.copyFrom(
          passwordBytes, com.google.crypto.tink.InsecureSecretKeyAccess.get());
    } finally {
      if (passwordBytes != null) {
        Arrays.fill(passwordBytes, (byte) 0);
      }
      Arrays.fill(passwordChars, '\0');
    }
  }

  public SpannerOmniCredentials(String username, SecretBytes password, String target) {
    this.username = Preconditions.checkNotNull(username);
    this.password = Preconditions.checkNotNull(password);
    Preconditions.checkNotNull(target);

    // Parse target and initialize settings. If target starts with http://, use plaintext.
    if (target.startsWith("http://")) {
      this.target = target.substring(7);
      this.usePlainText = true;
    } else if (target.startsWith("https://")) {
      this.target = target.substring(8);
    } else {
      this.target = target;
    }
  }

  @InternalApi
  public void initChannel(boolean usePlainText, SslContext sslContext) {
    logger.info(
        "initChannel called: usePlainText="
            + usePlainText
            + ", sslContext="
            + (sslContext != null ? "non-null" : "null")
            + ", target="
            + target);
    this.usePlainText = usePlainText;
    this.sslContext = sslContext;
  }

  @Override
  public AccessToken refreshAccessToken() throws IOException {
    // Create a new gRPC channel for every token refresh. We don't reuse a persistent channel
    // because token refresh happens infrequently (e.g. once an hour) and keeping a long-lived
    // connection open can lead to resource leaks (threads, TCP connections) if the credentials
    // object is discarded without explicit shutdown.
    ManagedChannel loginChannel = null;
    try {
      NettyChannelBuilder builder = NettyChannelBuilder.forTarget(this.target);
      if (this.usePlainText) {
        builder.usePlaintext();
      } else if (this.sslContext != null) {
        builder.sslContext(this.sslContext);
      }
      loginChannel = builder.build();

      LoginClient loginClient = new LoginClient(loginChannel);
      Login.AccessToken protoToken = loginClient.login(username, password);
      String tokenValue = Base64.getEncoder().encodeToString(protoToken.toByteArray());

      long expireTimeMillis;
      if (protoToken.hasExpirationTime()) {
        expireTimeMillis =
            protoToken.getExpirationTime().getSeconds() * 1000
                + protoToken.getExpirationTime().getNanos() / 1000000;
      } else {
        expireTimeMillis = System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(60);
      }

      return new AccessToken(tokenValue, new Date(expireTimeMillis));
    } catch (Exception e) {
      if (e instanceof InterruptedException || e.getCause() instanceof InterruptedException) {
        Thread.currentThread().interrupt();
      }
      throw new IOException("Failed to login to Spanner Omni", e);
    } finally {
      // Ensure the channel is shut down immediately after the token is fetched
      // to avoid leaking any Netty threads or HTTP/2 connections.
      if (loginChannel != null) {
        loginChannel.shutdown();
        try {
          if (!loginChannel.awaitTermination(5, TimeUnit.SECONDS)) {
            loginChannel.shutdownNow();
          }
        } catch (InterruptedException e) {
          loginChannel.shutdownNow();
          Thread.currentThread().interrupt();
        }
      }
    }
  }
}
