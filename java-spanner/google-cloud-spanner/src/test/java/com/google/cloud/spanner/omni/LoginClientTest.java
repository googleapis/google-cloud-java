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

  /**
   * Verifies that {@link LoginClient#login} aborts with a {@link SpannerException} when a rogue
   * server returns the point at infinity ({@code {0x00}}) as {@code evaluated_message}, even if the
   * server forges an otherwise valid OPAQUE envelope and server MAC from {@code oprf = {0x00}}.
   */
  @Test
  public void testLoginRejectsPointAtInfinityEvaluatedMessage() throws Exception {
    HashParameters fastHashParams = createFastArgon2HashParameters();
    LoginServiceGrpc.LoginServiceImplBase rogueServer =
        createRoguePointAtInfinityServer(fastHashParams);

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

  /** Creates minimal Argon2id parameters so the OPAQUE test executes quickly. */
  private static HashParameters createFastArgon2HashParameters() {
    return HashParameters.newBuilder()
        .setArgon2IdParameters(
            HashParameters.Argon2IdParameters.newBuilder()
                .setIterationCount(1)
                .setMemoryUsage(8)
                .setParallelism(1)
                .setHashSize(32)
                .build())
        .build();
  }

  /**
   * Builds a fake {@code LoginService} that negotiates OPAQUE, responds to the initial request with
   * {@code evaluated_message = {0x00}} and forged envelope/MAC material, and would issue an access
   * token if the client did not reject the point at infinity.
   */
  private static LoginServiceGrpc.LoginServiceImplBase createRoguePointAtInfinityServer(
      HashParameters hashParams) {
    return new LoginServiceGrpc.LoginServiceImplBase() {
      @Override
      public StreamObserver<LoginRequest> login(StreamObserver<LoginResponse> responseObserver) {
        return new StreamObserver<LoginRequest>() {
          @Override
          public void onNext(LoginRequest request) {
            try {
              if (request.hasHandshakeRequest()) {
                responseObserver.onNext(buildHandshakeResponse(hashParams));
              } else if (request.hasOpaqueRequest()
                  && request.getOpaqueRequest().hasInitialRequest()) {
                responseObserver.onNext(
                    buildForgedInitialOpaqueResponse(
                        request.getUsername(),
                        request.getOpaqueRequest().getInitialRequest(),
                        hashParams));
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
  }

  /** Builds the OPAQUE handshake response advertising the test Argon2id parameters. */
  private static LoginResponse buildHandshakeResponse(HashParameters hashParams) {
    return LoginResponse.newBuilder()
        .setHandshakeResponse(
            PasswordAuthenticationHandshakeResponse.newBuilder()
                .setPasswordAuthenticationProtocol(
                    PasswordAuthenticationProtocol.PASSWORD_AUTHENTICATION_PROTOCOL_OPAQUE)
                .setHashParameters(hashParams)
                .build())
        .build();
  }

  /**
   * Builds a forged initial OPAQUE response using {@code evaluated_message = {0x00}} (point at
   * infinity). Without point validation, {@code OpaqueUtil.finalize} would return {@code {0x00}},
   * allowing a rogue server without the password to derive the same envelope and AKE keys.
   */
  private static LoginResponse buildForgedInitialOpaqueResponse(
      String username, InitialOpaqueLoginRequest initReq, HashParameters hashParams)
      throws GeneralSecurityException {
    byte[] infinity = new byte[] {0x00};

    // Derive password-independent OPRF output keys assuming finalize(blind, {0x00}) == {0x00}.
    byte[] stretched = OpaqueUtil.stretch(infinity, hashParams);
    byte[] randomizedPassword = OpaqueUtil.extract(OpaqueUtil.concat(infinity, stretched));
    byte[] maskingKey =
        OpaqueUtil.expand(
            randomizedPassword, OpaqueUtil.MASKING_KEY_INFO.getBytes(StandardCharsets.UTF_8), 32);

    byte[] maskingNonce = new byte[32];
    Arrays.fill(maskingNonce, (byte) 0x11);
    byte[] pad =
        OpaqueUtil.expand(
            maskingKey,
            OpaqueUtil.concat(
                maskingNonce, "CredentialResponsePad".getBytes(StandardCharsets.UTF_8)),
            LoginClient.EXPECTED_ENVELOPE_SIZE);

    // Forge an envelope containing the attacker's public key and a matching auth tag.
    byte[][] serverKeyPair =
        OpaqueUtil.generateKeyPair("rogue-server".getBytes(StandardCharsets.UTF_8));
    byte[] envelopeNonce = new byte[32];
    Arrays.fill(envelopeNonce, (byte) 0x22);
    byte[] authKey =
        OpaqueUtil.expand(
            randomizedPassword,
            OpaqueUtil.concat(
                envelopeNonce, OpaqueUtil.AUTH_KEY_INFO.getBytes(StandardCharsets.UTF_8)),
            32);
    byte[] authTag =
        OpaqueUtil.mac(
            authKey,
            OpaqueUtil.concat(
                envelopeNonce, serverKeyPair[1], username.getBytes(StandardCharsets.UTF_8)));
    byte[] maskedResponse =
        OpaqueUtil.xorBytes(OpaqueUtil.concat(serverKeyPair[1], envelopeNonce, authTag), pad);

    // Derive the client's static public key from the known randomizedPassword to forge AKE DH3.
    byte[] clientSeed =
        OpaqueUtil.expand(
            randomizedPassword,
            OpaqueUtil.concat(
                envelopeNonce, OpaqueUtil.PRIVATE_KEY_INFO.getBytes(StandardCharsets.UTF_8)),
            32);
    byte[][] clientKeyPair =
        OpaqueUtil.generateKeyPair(
            OpaqueUtil.concat(
                clientSeed, OpaqueUtil.DIFFIE_HELLMAN_KEY_INFO.getBytes(StandardCharsets.UTF_8)));

    byte[][] serverKeysharePair =
        OpaqueUtil.generateKeyPair("rogue-keyshare".getBytes(StandardCharsets.UTF_8));
    byte[] serverNonce = new byte[32];
    Arrays.fill(serverNonce, (byte) 0x33);

    byte[] serverMac =
        computeForgedServerMac(
            username,
            initReq,
            infinity,
            serverNonce,
            serverKeyPair,
            serverKeysharePair,
            clientKeyPair[1]);

    return LoginResponse.newBuilder()
        .setOpaqueResponse(
            OpaqueLoginResponse.newBuilder()
                .setInitialResponse(
                    InitialOpaqueLoginResponse.newBuilder()
                        .setEvaluatedMessage(ByteString.copyFrom(infinity))
                        .setMaskingNonce(ByteString.copyFrom(maskingNonce))
                        .setMaskedResponse(ByteString.copyFrom(maskedResponse))
                        .setServerNonce(ByteString.copyFrom(serverNonce))
                        .setServerPublicKeyshare(ByteString.copyFrom(serverKeysharePair[1]))
                        .setServerMac(ByteString.copyFrom(serverMac))
                        .build())
                .build())
        .build();
  }

  /** Computes the OPAQUE 3DH handshake secret and server MAC for the forged initial response. */
  private static byte[] computeForgedServerMac(
      String username,
      InitialOpaqueLoginRequest initReq,
      byte[] evaluatedMessage,
      byte[] serverNonce,
      byte[][] serverKeyPair,
      byte[][] serverKeysharePair,
      byte[] clientPublicKey)
      throws GeneralSecurityException {
    byte[] clientPublicKeyshare = initReq.getClientPublicKeyshare().toByteArray();
    byte[] dh1 = OpaqueUtil.diffieHellman(serverKeysharePair[0], clientPublicKeyshare);
    byte[] dh2 = OpaqueUtil.diffieHellman(serverKeyPair[0], clientPublicKeyshare);
    byte[] dh3 = OpaqueUtil.diffieHellman(serverKeysharePair[0], clientPublicKey);

    byte[] preamble =
        OpaqueUtil.concat(
            "OPAQUEv1-".getBytes(StandardCharsets.UTF_8),
            username.getBytes(StandardCharsets.UTF_8),
            initReq.getClientNonce().toByteArray(),
            clientPublicKeyshare,
            serverKeyPair[1],
            evaluatedMessage,
            serverNonce,
            serverKeysharePair[1]);
    byte[] prk = OpaqueUtil.extract(OpaqueUtil.concat(dh1, dh2, dh3));
    byte[] preambleHash = OpaqueUtil.sha256(preamble);
    byte[] handshakeSecret =
        OpaqueUtil.expand(
            prk,
            OpaqueUtil.concat(
                "OPAQUE-HandshakeSecret".getBytes(StandardCharsets.UTF_8), preambleHash),
            32);
    byte[] km2 =
        OpaqueUtil.expand(handshakeSecret, "OPAQUE-ServerMAC".getBytes(StandardCharsets.UTF_8), 32);
    return OpaqueUtil.mac(km2, preambleHash);
  }
}
