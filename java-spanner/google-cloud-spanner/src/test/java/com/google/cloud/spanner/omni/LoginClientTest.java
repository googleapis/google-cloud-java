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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.omni.Authentication.HashParameters;
import com.google.cloud.spanner.omni.Authentication.PasswordAuthenticationHandshakeResponse;
import com.google.cloud.spanner.omni.Authentication.PasswordAuthenticationProtocol;
import com.google.cloud.spanner.omni.Login.AccessToken;
import com.google.cloud.spanner.omni.Login.InitialOpaqueLoginRequest;
import com.google.cloud.spanner.omni.Login.InitialOpaqueLoginResponse;
import com.google.cloud.spanner.omni.Login.LoginRequest;
import com.google.cloud.spanner.omni.Login.LoginResponse;
import com.google.cloud.spanner.omni.Login.OpaqueLoginResponse;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.util.SecretBytes;
import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.StreamObserver;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LoginClientTest {

  @Test
  public void testConstructor() {
    ManagedChannel channel =
        ManagedChannelBuilder.forTarget("localhost:15000").usePlaintext().build();
    LoginClient client = new LoginClient(channel);
    assertNotNull(client);
  }

  @Test
  public void testExpectedEnvelopeSize() {
    // The envelope size must match the sum of the public key, nonce, and auth tag lengths.
    // If the server changes the lengths in cl/940065095, this test will catch any mismatch.
    org.junit.Assert.assertEquals(
        "Envelope size should be 97 bytes (33 + 32 + 32)", 97, LoginClient.EXPECTED_ENVELOPE_SIZE);
  }

  @Test
  public void testLoginRejectsPointAtInfinityEvaluatedMessage() throws Exception {
    HashParameters fastHashParams =
        HashParameters.newBuilder()
            .setArgon2IdParameters(
                HashParameters.Argon2IdParameters.newBuilder()
                    .setIterationCount(1)
                    .setMemoryUsage(8)
                    .setParallelism(1)
                    .setHashSize(32)
                    .build())
            .build();

    LoginServiceGrpc.LoginServiceImplBase rogueServer =
        new LoginServiceGrpc.LoginServiceImplBase() {
          @Override
          public StreamObserver<LoginRequest> login(
              StreamObserver<LoginResponse> responseObserver) {
            return new StreamObserver<LoginRequest>() {
              @Override
              public void onNext(LoginRequest request) {
                try {
                  if (request.hasHandshakeRequest()) {
                    responseObserver.onNext(
                        LoginResponse.newBuilder()
                            .setHandshakeResponse(
                                PasswordAuthenticationHandshakeResponse.newBuilder()
                                    .setPasswordAuthenticationProtocol(
                                        PasswordAuthenticationProtocol
                                            .PASSWORD_AUTHENTICATION_PROTOCOL_OPAQUE)
                                    .setHashParameters(fastHashParams)
                                    .build())
                            .build());
                  } else if (request.hasOpaqueRequest()
                      && request.getOpaqueRequest().hasInitialRequest()) {
                    InitialOpaqueLoginRequest initReq =
                        request.getOpaqueRequest().getInitialRequest();
                    String username = request.getUsername();
                    byte[] infinity = new byte[] {0x00};

                    // A rogue server without the password derives all keys from oprf = {0x00}.
                    byte[] stretched = OpaqueUtil.stretch(infinity, fastHashParams);
                    byte[] randomizedPassword =
                        OpaqueUtil.extract(OpaqueUtil.concat(infinity, stretched));
                    byte[] maskingKey =
                        OpaqueUtil.expand(
                            randomizedPassword,
                            OpaqueUtil.MASKING_KEY_INFO.getBytes(StandardCharsets.UTF_8),
                            32);

                    byte[] maskingNonce = new byte[32];
                    Arrays.fill(maskingNonce, (byte) 0x11);
                    byte[] pad =
                        OpaqueUtil.expand(
                            maskingKey,
                            OpaqueUtil.concat(
                                maskingNonce,
                                "CredentialResponsePad".getBytes(StandardCharsets.UTF_8)),
                            LoginClient.EXPECTED_ENVELOPE_SIZE);

                    byte[][] serverKeyPair =
                        OpaqueUtil.generateKeyPair("rogue-server".getBytes(StandardCharsets.UTF_8));
                    byte[] envelopeNonce = new byte[32];
                    Arrays.fill(envelopeNonce, (byte) 0x22);
                    byte[] authKey =
                        OpaqueUtil.expand(
                            randomizedPassword,
                            OpaqueUtil.concat(
                                envelopeNonce,
                                OpaqueUtil.AUTH_KEY_INFO.getBytes(StandardCharsets.UTF_8)),
                            32);
                    byte[] authTag =
                        OpaqueUtil.mac(
                            authKey,
                            OpaqueUtil.concat(
                                envelopeNonce,
                                serverKeyPair[1],
                                username.getBytes(StandardCharsets.UTF_8)));
                    byte[] envelope = OpaqueUtil.concat(serverKeyPair[1], envelopeNonce, authTag);
                    byte[] maskedResponse = OpaqueUtil.xorBytes(envelope, pad);

                    byte[] clientSeed =
                        OpaqueUtil.expand(
                            randomizedPassword,
                            OpaqueUtil.concat(
                                envelopeNonce,
                                OpaqueUtil.PRIVATE_KEY_INFO.getBytes(StandardCharsets.UTF_8)),
                            32);
                    byte[][] clientKeyPair =
                        OpaqueUtil.generateKeyPair(
                            OpaqueUtil.concat(
                                clientSeed,
                                OpaqueUtil.DIFFIE_HELLMAN_KEY_INFO.getBytes(
                                    StandardCharsets.UTF_8)));

                    byte[][] serverKeysharePair =
                        OpaqueUtil.generateKeyPair(
                            "rogue-keyshare".getBytes(StandardCharsets.UTF_8));
                    byte[] serverNonce = new byte[32];
                    Arrays.fill(serverNonce, (byte) 0x33);

                    byte[] dh1 =
                        OpaqueUtil.diffieHellman(
                            serverKeysharePair[0], initReq.getClientPublicKeyshare().toByteArray());
                    byte[] dh2 =
                        OpaqueUtil.diffieHellman(
                            serverKeyPair[0], initReq.getClientPublicKeyshare().toByteArray());
                    byte[] dh3 = OpaqueUtil.diffieHellman(serverKeysharePair[0], clientKeyPair[1]);

                    byte[] preamble =
                        OpaqueUtil.concat(
                            "OPAQUEv1-".getBytes(StandardCharsets.UTF_8),
                            username.getBytes(StandardCharsets.UTF_8),
                            initReq.getClientNonce().toByteArray(),
                            initReq.getClientPublicKeyshare().toByteArray(),
                            serverKeyPair[1],
                            infinity,
                            serverNonce,
                            serverKeysharePair[1]);
                    byte[] prk = OpaqueUtil.extract(OpaqueUtil.concat(dh1, dh2, dh3));
                    byte[] preambleHash = OpaqueUtil.sha256(preamble);
                    byte[] handshakeSecret =
                        OpaqueUtil.expand(
                            prk,
                            OpaqueUtil.concat(
                                "OPAQUE-HandshakeSecret".getBytes(StandardCharsets.UTF_8),
                                preambleHash),
                            32);
                    byte[] km2 =
                        OpaqueUtil.expand(
                            handshakeSecret,
                            "OPAQUE-ServerMAC".getBytes(StandardCharsets.UTF_8),
                            32);
                    byte[] serverMac = OpaqueUtil.mac(km2, preambleHash);

                    responseObserver.onNext(
                        LoginResponse.newBuilder()
                            .setOpaqueResponse(
                                OpaqueLoginResponse.newBuilder()
                                    .setInitialResponse(
                                        InitialOpaqueLoginResponse.newBuilder()
                                            .setEvaluatedMessage(ByteString.copyFrom(infinity))
                                            .setMaskingNonce(ByteString.copyFrom(maskingNonce))
                                            .setMaskedResponse(ByteString.copyFrom(maskedResponse))
                                            .setServerNonce(ByteString.copyFrom(serverNonce))
                                            .setServerPublicKeyshare(
                                                ByteString.copyFrom(serverKeysharePair[1]))
                                            .setServerMac(ByteString.copyFrom(serverMac))
                                            .build())
                                    .build())
                            .build());
                  } else if (request.hasOpaqueRequest()
                      && request.getOpaqueRequest().hasFinalRequest()) {
                    responseObserver.onNext(
                        LoginResponse.newBuilder()
                            .setAccessToken(AccessToken.newBuilder().build())
                            .build());
                    responseObserver.onCompleted();
                  }
                } catch (Exception e) {
                  responseObserver.onError(e);
                }
              }

              @Override
              public void onError(Throwable t) {}

              @Override
              public void onCompleted() {}
            };
          }
        };

    String serverName = InProcessServerBuilder.generateName();
    Server server =
        InProcessServerBuilder.forName(serverName)
            .directExecutor()
            .addService(rogueServer)
            .build()
            .start();
    ManagedChannel channel = InProcessChannelBuilder.forName(serverName).directExecutor().build();
    try {
      LoginClient client = new LoginClient(channel);
      SecretBytes password =
          SecretBytes.copyFrom(
              "super-secret-password".getBytes(StandardCharsets.UTF_8),
              InsecureSecretKeyAccess.get());

      SpannerException exception =
          assertThrows(SpannerException.class, () -> client.login("alice", password));
      assertTrue(exception.getCause() instanceof GeneralSecurityException);
      assertTrue(exception.getCause().getMessage().contains("evaluatedMessage"));
    } finally {
      channel.shutdownNow();
      server.shutdownNow();
      channel.awaitTermination(5, TimeUnit.SECONDS);
      server.awaitTermination(5, TimeUnit.SECONDS);
    }
  }
}
