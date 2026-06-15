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

import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.omni.Authentication.PasswordAuthenticationHandshakeRequest;
import com.google.cloud.spanner.omni.Authentication.PasswordAuthenticationProtocol;
import com.google.cloud.spanner.omni.Login.*;
import com.google.cloud.spanner.omni.opaque.OpaqueUtil;
import com.google.common.base.Preconditions;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.util.SecretBytes;
import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Client for {@link google.spanner.omni.v1.LoginServiceGrpc}. This class is used to authenticate to
 * Spanner Omni using username/password.
 */
public class LoginClient {
  private static final SecureRandom SECURE_RANDOM = new SecureRandom();

  private final LoginServiceGrpc.LoginServiceStub stub;

  public LoginClient(ManagedChannel channel) {
    this.stub = LoginServiceGrpc.newStub(channel);
  }

  /**
   * Logs in to Spanner Omni using OPAQUE protocol.
   *
   * @param username The username to login with.
   * @param password The password to login with.
   * @return The access token.
   * @throws SpannerException if login fails.
   */
  public AccessToken login(String username, SecretBytes password) throws SpannerException {
    Preconditions.checkNotNull(username);
    Preconditions.checkNotNull(password);
    byte[] passwordBytes = null;
    byte[] clientPrivateKeyshare = null;
    byte[] blind = null;
    byte[] blindedMessage = null;
    try {
      passwordBytes = password.toByteArray(InsecureSecretKeyAccess.get());
      byte[] randomNonce = OpaqueUtil.nonce();
      byte[][] keyPair =
          OpaqueUtil.generateKeyPair(
              OpaqueUtil.concat(
                  randomNonce,
                  OpaqueUtil.DIFFIE_HELLMAN_KEY_INFO.getBytes(StandardCharsets.UTF_8)));
      clientPrivateKeyshare = keyPair[0];
      byte[] clientPublicKeyshare = keyPair[1];
      byte[] clientNonce = OpaqueUtil.nonce();
      blind = new byte[32];
      SECURE_RANDOM.nextBytes(blind);

      blindedMessage = OpaqueUtil.blind(passwordBytes, blind);

      try (LoginStreamIOCall call =
          new LoginStreamIOCall(stub.withDeadlineAfter(60, TimeUnit.SECONDS))) {

        // 1. Send Handshake Request
        LoginRequest handshakeRequest =
            LoginRequest.newBuilder()
                .setUsername(username)
                .setHandshakeRequest(PasswordAuthenticationHandshakeRequest.newBuilder())
                .build();
        call.send(handshakeRequest);
        LoginResponse handshakeResponse = call.getResponse();

        if (handshakeResponse == null || !handshakeResponse.hasHandshakeResponse()) {
          throw SpannerExceptionFactory.newSpannerException(
              com.google.cloud.spanner.ErrorCode.UNAUTHENTICATED,
              "Failed to receive handshake response from server.");
        }

        PasswordAuthenticationProtocol method =
            handshakeResponse.getHandshakeResponse().getPasswordAuthenticationProtocol();
        if (method != PasswordAuthenticationProtocol.PASSWORD_AUTHENTICATION_PROTOCOL_OPAQUE) {
          throw SpannerExceptionFactory.newSpannerException(
              com.google.cloud.spanner.ErrorCode.UNAUTHENTICATED,
              "Unsupported authentication method: " + method);
        }

        // 2. Send Initial OPAQUE Request
        LoginRequest initialRequest =
            LoginRequest.newBuilder()
                .setUsername(username)
                .setOpaqueRequest(
                    OpaqueLoginRequest.newBuilder()
                        .setInitialRequest(
                            InitialOpaqueLoginRequest.newBuilder()
                                .setBlindedMessage(ByteString.copyFrom(blindedMessage))
                                .setClientNonce(ByteString.copyFrom(clientNonce))
                                .setClientPublicKeyshare(
                                    ByteString.copyFrom(clientPublicKeyshare))))
                .build();

        call.send(initialRequest);
        LoginResponse initialResponse = call.getResponse();

        InitialOpaqueLoginResponse initialOpaqueResponse =
            initialResponse.getOpaqueResponse().getInitialResponse();

        ByteString envelope = initialOpaqueResponse.getMaskedResponse();
        if (envelope.size() != 65) {
          throw new GeneralSecurityException("Invalid envelope size: " + envelope.size());
        }

        byte[] clientMac =
            generateClientMac(
                username,
                blind,
                clientNonce,
                clientPublicKeyshare,
                clientPrivateKeyshare,
                initialOpaqueResponse);

        LoginRequest finalRequest =
            LoginRequest.newBuilder()
                .setUsername(username)
                .setOpaqueRequest(
                    OpaqueLoginRequest.newBuilder()
                        .setFinalRequest(
                            FinalOpaqueLoginRequest.newBuilder()
                                .setClientMac(ByteString.copyFrom(clientMac))))
                .build();

        call.send(finalRequest);
        call.halfClose();
        LoginResponse finalResponse = call.getResponse();
        if (!finalResponse.hasAccessToken()) {
          throw SpannerExceptionFactory.newSpannerException(
              com.google.cloud.spanner.ErrorCode.UNAUTHENTICATED,
              "Server failed to return an access token.");
        }
        return finalResponse.getAccessToken();
      }
    } catch (Exception e) {
      if (e instanceof InterruptedException) {
        Thread.currentThread().interrupt();
      }
      throw SpannerExceptionFactory.newSpannerException(e);
    } finally {
      // Securely zero out all intermediate sensitive buffers to prevent them
      // from persisting in heap dumps or lingering in memory (memory scraping attacks).
      if (passwordBytes != null) {
        Arrays.fill(passwordBytes, (byte) 0);
      }
      if (clientPrivateKeyshare != null) {
        Arrays.fill(clientPrivateKeyshare, (byte) 0);
      }
      if (blind != null) {
        Arrays.fill(blind, (byte) 0);
      }
      if (blindedMessage != null) {
        Arrays.fill(blindedMessage, (byte) 0);
      }
    }
  }

  private byte[] generateClientMac(
      String username,
      byte[] blind,
      byte[] clientNonce,
      byte[] clientPublicKeyshare,
      byte[] clientPrivateKeyshare,
      InitialOpaqueLoginResponse initialOpaqueResponse)
      throws GeneralSecurityException, IOException {
    byte[] oprf = null;
    byte[] stretchedOprf = null;
    byte[] randomizedPassword = null;
    byte[] maskingKey = null;
    byte[] credentialResponsePad = null;
    byte[] authKey = null;
    byte[] seed = null;
    byte[] dh1 = null;
    byte[] dh2 = null;
    byte[] dh3 = null;
    byte[] inputKeyMaterial = null;
    byte[] handshakeSecret = null;
    byte[] km2 = null;
    byte[] km3 = null;
    byte[] clientPrivateKey = null;
    byte[] prk = null;

    try {
      oprf = OpaqueUtil.finalize(blind, initialOpaqueResponse.getEvaluatedMessage().toByteArray());
      stretchedOprf = OpaqueUtil.stretch(oprf);
      byte[] oprfConcat = OpaqueUtil.concat(oprf, stretchedOprf);
      try {
        randomizedPassword = OpaqueUtil.extract(oprfConcat);
      } finally {
        Arrays.fill(oprfConcat, (byte) 0);
      }
      maskingKey =
          OpaqueUtil.expand(
              randomizedPassword, OpaqueUtil.MASKING_KEY_INFO.getBytes(StandardCharsets.UTF_8), 32);
      credentialResponsePad =
          OpaqueUtil.expand(
              maskingKey,
              OpaqueUtil.concat(
                  initialOpaqueResponse.getMaskingNonce().toByteArray(),
                  "CredentialResponsePad".getBytes(java.nio.charset.StandardCharsets.UTF_8)),
              16 + 33 + 16);
      byte[] serializedEnvelope =
          OpaqueUtil.xorBytes(
              initialOpaqueResponse.getMaskedResponse().toByteArray(), credentialResponsePad);
      ByteString envelope = ByteString.copyFrom(serializedEnvelope);
      if (envelope.size() != 65) {
        throw new GeneralSecurityException("Invalid envelope size: " + envelope.size());
      }
      ByteString serverPublicKey = envelope.substring(0, 33);
      ByteString envelopeNonce = envelope.substring(33, 33 + 16);
      ByteString authTag = envelope.substring(33 + 16, 33 + 16 + 16);

      authKey =
          OpaqueUtil.expand(
              randomizedPassword,
              OpaqueUtil.concat(
                  envelopeNonce.toByteArray(),
                  OpaqueUtil.AUTH_KEY_INFO.getBytes(StandardCharsets.UTF_8)),
              32);
      seed =
          OpaqueUtil.expand(
              randomizedPassword,
              OpaqueUtil.concat(
                  envelopeNonce.toByteArray(),
                  OpaqueUtil.PRIVATE_KEY_INFO.getBytes(StandardCharsets.UTF_8)),
              32);
      byte[] seedConcat =
          OpaqueUtil.concat(
              seed, OpaqueUtil.DIFFIE_HELLMAN_KEY_INFO.getBytes(StandardCharsets.UTF_8));
      byte[][] clientKeyPair;
      try {
        clientKeyPair = OpaqueUtil.generateKeyPair(seedConcat);
      } finally {
        Arrays.fill(seedConcat, (byte) 0);
      }
      clientPrivateKey = clientKeyPair[0];
      byte[] clientPublicKey = clientKeyPair[1];

      byte[] expectedTag =
          OpaqueUtil.mac(
              authKey,
              OpaqueUtil.concat(
                  envelopeNonce.toByteArray(),
                  serverPublicKey.toByteArray(),
                  username.getBytes(StandardCharsets.UTF_8)));
      // Use MessageDigest.isEqual for constant-time comparison to prevent timing attacks.
      // A standard Arrays.equals or ByteString.equals fails fast and can reveal byte matches.
      if (!MessageDigest.isEqual(expectedTag, authTag.toByteArray())) {
        throw new GeneralSecurityException("Auth tag mismatch");
      }

      dh1 =
          OpaqueUtil.diffieHellman(
              clientPrivateKeyshare, initialOpaqueResponse.getServerPublicKeyshare().toByteArray());
      dh2 = OpaqueUtil.diffieHellman(clientPrivateKeyshare, serverPublicKey.toByteArray());
      dh3 =
          OpaqueUtil.diffieHellman(
              clientPrivateKey, initialOpaqueResponse.getServerPublicKeyshare().toByteArray());

      inputKeyMaterial = OpaqueUtil.concat(dh1, dh2, dh3);

      byte[] preamble =
          OpaqueUtil.concat(
              "OPAQUEv1-".getBytes(StandardCharsets.UTF_8),
              username.getBytes(StandardCharsets.UTF_8),
              clientNonce,
              clientPublicKeyshare,
              serverPublicKey.toByteArray(),
              initialOpaqueResponse.getEvaluatedMessage().toByteArray(),
              initialOpaqueResponse.getServerNonce().toByteArray(),
              initialOpaqueResponse.getServerPublicKeyshare().toByteArray());
      prk = OpaqueUtil.extract(inputKeyMaterial);
      byte[] preambleHash = OpaqueUtil.sha256(preamble);
      handshakeSecret =
          OpaqueUtil.expand(
              prk,
              OpaqueUtil.concat(
                  "OPAQUE-HandshakeSecret".getBytes(StandardCharsets.UTF_8), preambleHash),
              32);
      km2 =
          OpaqueUtil.expand(
              handshakeSecret, "OPAQUE-ServerMAC".getBytes(StandardCharsets.UTF_8), 32);
      km3 =
          OpaqueUtil.expand(
              handshakeSecret, "OPAQUE-ClientMAC".getBytes(StandardCharsets.UTF_8), 32);

      byte[] expectedServerMac = OpaqueUtil.mac(km2, OpaqueUtil.sha256(preamble));
      if (!MessageDigest.isEqual(
          expectedServerMac, initialOpaqueResponse.getServerMac().toByteArray())) {
        throw new GeneralSecurityException("Server MAC mismatch");
      }
      return OpaqueUtil.mac(km3, OpaqueUtil.sha256(OpaqueUtil.concat(preamble, expectedServerMac)));
    } finally {
      // Zero out derived keys and diffie-hellman secrets to prevent credential scraping.
      if (oprf != null) Arrays.fill(oprf, (byte) 0);
      if (stretchedOprf != null) Arrays.fill(stretchedOprf, (byte) 0);
      if (randomizedPassword != null) Arrays.fill(randomizedPassword, (byte) 0);
      if (maskingKey != null) Arrays.fill(maskingKey, (byte) 0);
      if (credentialResponsePad != null) Arrays.fill(credentialResponsePad, (byte) 0);
      if (authKey != null) Arrays.fill(authKey, (byte) 0);
      if (seed != null) Arrays.fill(seed, (byte) 0);
      if (dh1 != null) Arrays.fill(dh1, (byte) 0);
      if (dh2 != null) Arrays.fill(dh2, (byte) 0);
      if (dh3 != null) Arrays.fill(dh3, (byte) 0);
      if (inputKeyMaterial != null) Arrays.fill(inputKeyMaterial, (byte) 0);
      if (handshakeSecret != null) Arrays.fill(handshakeSecret, (byte) 0);
      if (km2 != null) Arrays.fill(km2, (byte) 0);
      if (km3 != null) Arrays.fill(km3, (byte) 0);
      if (clientPrivateKey != null) Arrays.fill(clientPrivateKey, (byte) 0);
      if (prk != null) Arrays.fill(prk, (byte) 0);
    }
  }

  static class LoginStreamIOCall implements AutoCloseable {
    private static final Object COMPLETED_SENTINEL = new Object();
    private final LoginServiceGrpc.LoginServiceStub stub;
    private final BlockingQueue<Object> responseQueue = new LinkedBlockingQueue<>();
    private final StreamObserver<LoginRequest> requestObserver;
    private boolean closed = false;

    LoginStreamIOCall(LoginServiceGrpc.LoginServiceStub stub) {
      this.stub = stub;
      this.requestObserver =
          stub.login(
              new StreamObserver<LoginResponse>() {
                @Override
                public void onNext(LoginResponse value) {
                  responseQueue.add(value);
                }

                @Override
                public void onError(Throwable t) {
                  responseQueue.add(t);
                }

                @Override
                public void onCompleted() {
                  responseQueue.add(COMPLETED_SENTINEL);
                }
              });
    }

    void send(LoginRequest request) {
      requestObserver.onNext(request);
    }

    LoginResponse getResponse() throws InterruptedException {
      Object response = responseQueue.take();
      if (response instanceof Throwable) {
        throw SpannerExceptionFactory.newSpannerException((Throwable) response);
      }
      if (response == COMPLETED_SENTINEL) {
        return null;
      }
      return (LoginResponse) response;
    }

    void halfClose() {
      requestObserver.onCompleted();
      closed = true;
    }

    @Override
    public void close() {
      if (!closed) {
        closed = true;
        try {
          requestObserver.onError(new RuntimeException("Client cancelled the login stream"));
        } catch (Exception e) {
          // Ignore
        }
      }
    }
  }
}
