/*
 * Copyright 2024 Google LLC
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
import com.google.cloud.spanner.omni.Login.*;
import com.google.cloud.spanner.omni.opaque.OpaqueUtil;
import com.google.common.base.Preconditions;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.util.SecretBytes;
import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Client for {@link google.spanner.omni.v1.LoginServiceGrpc}. This class is used to authenticate to
 * Spanner Omni using username/password.
 */
public class LoginClient {
  private static final java.security.SecureRandom SECURE_RANDOM = new java.security.SecureRandom();

  private final LoginServiceGrpc.LoginServiceStub stub;

  public LoginClient(ManagedChannel channel) {
    this.stub =
        LoginServiceGrpc.newStub(channel)
            .withDeadlineAfter(60, java.util.concurrent.TimeUnit.SECONDS);
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
    try {
      passwordBytes = password.toByteArray(InsecureSecretKeyAccess.get());
      byte[] randomNonce = OpaqueUtil.nonce();
      byte[][] keyPair =
          OpaqueUtil.generateKeyPair(
              OpaqueUtil.concat(
                  randomNonce,
                  OpaqueUtil.DIFFIE_HELLMAN_KEY_INFO.getBytes(
                      java.nio.charset.StandardCharsets.UTF_8)));
      byte[] clientPrivateKeyshare = keyPair[0];
      byte[] clientPublicKeyshare = keyPair[1];
      byte[] clientNonce = OpaqueUtil.nonce();
      byte[] blind = new byte[32];
      SECURE_RANDOM.nextBytes(blind);

      byte[] blindedMessage = OpaqueUtil.blind(passwordBytes, blind);

      LoginStreamIOCall call = new LoginStreamIOCall(stub);

      // 1. Send Handshake Request
      LoginRequest handshakeRequest =
          LoginRequest.newBuilder()
              .setUsername(username)
              .setHandshakeRequest(AuthenticationHandshakeRequest.newBuilder())
              .build();
      call.send(handshakeRequest);
      LoginResponse handshakeResponse = call.getResponse();

      if (handshakeResponse == null || !handshakeResponse.hasHandshakeResponse()) {
        throw SpannerExceptionFactory.newSpannerException(
            com.google.cloud.spanner.ErrorCode.UNAUTHENTICATED,
            "Failed to receive handshake response from server.");
      }

      AuthenticationMethod method =
          handshakeResponse.getHandshakeResponse().getAuthenticationMethod();
      if (method != AuthenticationMethod.AUTHENTICATION_METHOD_OPAQUE) {
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
                              .setClientPublicKeyshare(ByteString.copyFrom(clientPublicKeyshare))))
              .build();

      call.send(initialRequest);
      LoginResponse initialResponse = call.getResponse();

      InitialOpaqueLoginResponse initialOpaqueResponse =
          initialResponse.getOpaqueResponse().getInitialResponse();

      byte[] clientMac =
          generateClientMac(
              username,
              passwordBytes,
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
      return finalResponse.getAccessToken();
    } catch (GeneralSecurityException | IOException | InterruptedException e) {
      if (e instanceof InterruptedException) {
        Thread.currentThread().interrupt();
      }
      throw SpannerExceptionFactory.newSpannerException(e);
    } finally {
      if (passwordBytes != null) {
        java.util.Arrays.fill(passwordBytes, (byte) 0);
      }
    }
  }

  private byte[] generateClientMac(
      String username,
      byte[] password,
      byte[] blind,
      byte[] clientNonce,
      byte[] clientPublicKeyshare,
      byte[] clientPrivateKeyshare,
      InitialOpaqueLoginResponse initialOpaqueResponse)
      throws GeneralSecurityException, IOException {
    byte[] oprf =
        OpaqueUtil.finalize(blind, initialOpaqueResponse.getEvaluatedMessage().toByteArray());
    byte[] stretchedOprf = OpaqueUtil.stretch(oprf);
    byte[] randomizedPassword = OpaqueUtil.extract(OpaqueUtil.concat(oprf, stretchedOprf));
    byte[] maskingKey =
        OpaqueUtil.expand(
            randomizedPassword,
            OpaqueUtil.MASKING_KEY_INFO.getBytes(java.nio.charset.StandardCharsets.UTF_8),
            32);
    byte[] credentialResponsePad =
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
    ByteString serverPublicKey = envelope.substring(0, 33);
    ByteString envelopeNonce = envelope.substring(33, 33 + 16);
    ByteString authTag = envelope.substring(33 + 16, 33 + 16 + 16);

    byte[] authKey =
        OpaqueUtil.expand(
            randomizedPassword,
            OpaqueUtil.concat(
                envelopeNonce.toByteArray(),
                OpaqueUtil.AUTH_KEY_INFO.getBytes(java.nio.charset.StandardCharsets.UTF_8)),
            32);
    byte[] seed =
        OpaqueUtil.expand(
            randomizedPassword,
            OpaqueUtil.concat(
                envelopeNonce.toByteArray(),
                OpaqueUtil.PRIVATE_KEY_INFO.getBytes(java.nio.charset.StandardCharsets.UTF_8)),
            32);
    byte[][] clientKeyPair =
        OpaqueUtil.generateKeyPair(
            OpaqueUtil.concat(
                seed,
                OpaqueUtil.DIFFIE_HELLMAN_KEY_INFO.getBytes(
                    java.nio.charset.StandardCharsets.UTF_8)));
    byte[] clientPrivateKey = clientKeyPair[0];
    byte[] clientPublicKey = clientKeyPair[1];

    byte[] expectedTag =
        OpaqueUtil.mac(
            authKey,
            OpaqueUtil.concat(
                envelopeNonce.toByteArray(),
                serverPublicKey.toByteArray(),
                username.getBytes(java.nio.charset.StandardCharsets.UTF_8)));
    if (!ByteString.copyFrom(expectedTag).equals(authTag)) {
      throw new GeneralSecurityException("Auth tag mismatch");
    }

    byte[] dh1 =
        OpaqueUtil.diffieHellman(
            clientPrivateKeyshare, initialOpaqueResponse.getServerPublicKeyshare().toByteArray());
    byte[] dh2 = OpaqueUtil.diffieHellman(clientPrivateKeyshare, serverPublicKey.toByteArray());
    byte[] dh3 =
        OpaqueUtil.diffieHellman(
            clientPrivateKey, initialOpaqueResponse.getServerPublicKeyshare().toByteArray());

    byte[] inputKeyMaterial = OpaqueUtil.concat(dh1, dh2, dh3);

    byte[] preamble =
        OpaqueUtil.concat(
            "OPAQUEv1-".getBytes(java.nio.charset.StandardCharsets.UTF_8),
            username.getBytes(java.nio.charset.StandardCharsets.UTF_8),
            clientNonce,
            clientPublicKeyshare,
            serverPublicKey.toByteArray(),
            initialOpaqueResponse.getEvaluatedMessage().toByteArray(),
            initialOpaqueResponse.getServerNonce().toByteArray(),
            initialOpaqueResponse.getServerPublicKeyshare().toByteArray());
    byte[] prk = OpaqueUtil.extract(inputKeyMaterial);
    byte[] preambleHash = OpaqueUtil.sha256(preamble);
    byte[] handshakeSecret =
        OpaqueUtil.expand(
            prk,
            OpaqueUtil.concat(
                "OPAQUE-HandshakeSecret".getBytes(java.nio.charset.StandardCharsets.UTF_8),
                preambleHash),
            32);
    byte[] km2 =
        OpaqueUtil.expand(
            handshakeSecret,
            "OPAQUE-ServerMAC".getBytes(java.nio.charset.StandardCharsets.UTF_8),
            32);
    byte[] km3 =
        OpaqueUtil.expand(
            handshakeSecret,
            "OPAQUE-ClientMAC".getBytes(java.nio.charset.StandardCharsets.UTF_8),
            32);

    byte[] expectedServerMac = OpaqueUtil.mac(km2, OpaqueUtil.sha256(preamble));
    if (!ByteString.copyFrom(expectedServerMac).equals(initialOpaqueResponse.getServerMac())) {
      throw new GeneralSecurityException("Server MAC mismatch");
    }
    return OpaqueUtil.mac(km3, OpaqueUtil.sha256(OpaqueUtil.concat(preamble, expectedServerMac)));
  }

  static class LoginStreamIOCall {
    private final LoginServiceGrpc.LoginServiceStub stub;
    private final java.util.concurrent.BlockingQueue<LoginResponse> responseQueue =
        new java.util.concurrent.LinkedBlockingQueue<>();
    private StreamObserver<LoginRequest> requestObserver;
    private Throwable error;
    private boolean completed = false;

    LoginStreamIOCall(LoginServiceGrpc.LoginServiceStub stub) {
      this.stub = stub;
      requestObserver =
          stub.login(
              new StreamObserver<LoginResponse>() {
                @Override
                public void onNext(LoginResponse value) {
                  responseQueue.add(value);
                }

                @Override
                public void onError(Throwable t) {
                  error = t;
                  // Add a dummy response to unblock getResponse if it's waiting
                  responseQueue.add(LoginResponse.getDefaultInstance());
                }

                @Override
                public void onCompleted() {
                  completed = true;
                  // Add a dummy response to unblock getResponse if it's waiting
                  responseQueue.add(LoginResponse.getDefaultInstance());
                }
              });
    }

    void send(LoginRequest request) {
      requestObserver.onNext(request);
    }

    LoginResponse getResponse() throws InterruptedException {
      LoginResponse response = responseQueue.take();
      if (error != null) {
        throw SpannerExceptionFactory.newSpannerException(error);
      }
      if (response == LoginResponse.getDefaultInstance() && completed) {
        return null;
      }
      return response;
    }

    void halfClose() {
      requestObserver.onCompleted();
    }
  }
}
