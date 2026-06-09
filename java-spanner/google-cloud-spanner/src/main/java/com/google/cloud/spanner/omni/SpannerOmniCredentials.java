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
import com.google.crypto.tink.util.SecretBytes;
import io.grpc.ManagedChannel;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContext;
import java.io.IOException;
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
  private ManagedChannel loginChannel;

  public SpannerOmniCredentials(String username, SecretBytes password, String target) {
    this.username = com.google.common.base.Preconditions.checkNotNull(username);
    this.password = com.google.common.base.Preconditions.checkNotNull(password);
    com.google.common.base.Preconditions.checkNotNull(target);

    // Parse target and initialize channel. If target starts with http://, use plaintext.
    if (target.startsWith("http://")) {
      this.target = target.substring(7);
      this.loginChannel = NettyChannelBuilder.forTarget(this.target).usePlaintext().build();
    } else if (target.startsWith("https://")) {
      this.target = target.substring(8);
      this.loginChannel = NettyChannelBuilder.forTarget(this.target).build();
    } else {
      this.target = target;
      this.loginChannel = NettyChannelBuilder.forTarget(this.target).build();
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
    if (this.loginChannel != null) {
      this.loginChannel.shutdown();
    }
    NettyChannelBuilder builder = NettyChannelBuilder.forTarget(this.target);
    if (usePlainText) {
      builder.usePlaintext();
    } else if (sslContext != null) {
      builder.sslContext(sslContext);
    }
    this.loginChannel = builder.build();
  }

  @Override
  public AccessToken refreshAccessToken() throws IOException {
    try {
      LoginClient loginClient = new LoginClient(this.loginChannel);
      com.google.cloud.spanner.omni.Login.AccessToken protoToken =
          loginClient.login(username, password);
      String tokenValue = Base64.getEncoder().encodeToString(protoToken.toByteArray());

      long createTimeMillis =
          protoToken.getCreationTime().getSeconds() * 1000
              + protoToken.getCreationTime().getNanos() / 1000000;
      long expireTimeMillis =
          protoToken.getExpirationTime().getSeconds() * 1000
              + protoToken.getExpirationTime().getNanos() / 1000000;

      long tokenLifetimeMillis = expireTimeMillis - createTimeMillis;
      if (tokenLifetimeMillis <= 0) {
        tokenLifetimeMillis = TimeUnit.MINUTES.toMillis(60);
      }

      return new AccessToken(
          tokenValue, new Date(System.currentTimeMillis() + tokenLifetimeMillis));
    } catch (Exception e) {
      if (e instanceof InterruptedException || e.getCause() instanceof InterruptedException) {
        Thread.currentThread().interrupt();
      }
      throw new IOException("Failed to login to Spanner Omni", e);
    }
  }
}
