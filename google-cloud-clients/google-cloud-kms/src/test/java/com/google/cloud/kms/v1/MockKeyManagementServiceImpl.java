/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.kms.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.kms.v1.KeyManagementServiceGrpc.KeyManagementServiceImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@javax.annotation.Generated("by GAPIC")
@BetaApi
public class MockKeyManagementServiceImpl extends KeyManagementServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockKeyManagementServiceImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<AbstractMessage> getRequests() {
    return requests;
  }

  public void addResponse(AbstractMessage response) {
    responses.add(response);
  }

  public void setResponses(List<AbstractMessage> responses) {
    this.responses = new LinkedList<Object>(responses);
  }

  public void addException(Exception exception) {
    responses.add(exception);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void listKeyRings(
      ListKeyRingsRequest request, StreamObserver<ListKeyRingsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListKeyRingsResponse) {
      requests.add(request);
      responseObserver.onNext((ListKeyRingsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listCryptoKeys(
      ListCryptoKeysRequest request, StreamObserver<ListCryptoKeysResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListCryptoKeysResponse) {
      requests.add(request);
      responseObserver.onNext((ListCryptoKeysResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listCryptoKeyVersions(
      ListCryptoKeyVersionsRequest request,
      StreamObserver<ListCryptoKeyVersionsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListCryptoKeyVersionsResponse) {
      requests.add(request);
      responseObserver.onNext((ListCryptoKeyVersionsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getKeyRing(GetKeyRingRequest request, StreamObserver<KeyRing> responseObserver) {
    Object response = responses.remove();
    if (response instanceof KeyRing) {
      requests.add(request);
      responseObserver.onNext((KeyRing) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getCryptoKey(
      GetCryptoKeyRequest request, StreamObserver<CryptoKey> responseObserver) {
    Object response = responses.remove();
    if (response instanceof CryptoKey) {
      requests.add(request);
      responseObserver.onNext((CryptoKey) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getCryptoKeyVersion(
      GetCryptoKeyVersionRequest request, StreamObserver<CryptoKeyVersion> responseObserver) {
    Object response = responses.remove();
    if (response instanceof CryptoKeyVersion) {
      requests.add(request);
      responseObserver.onNext((CryptoKeyVersion) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getPublicKey(
      GetPublicKeyRequest request, StreamObserver<PublicKey> responseObserver) {
    Object response = responses.remove();
    if (response instanceof PublicKey) {
      requests.add(request);
      responseObserver.onNext((PublicKey) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void createKeyRing(
      CreateKeyRingRequest request, StreamObserver<KeyRing> responseObserver) {
    Object response = responses.remove();
    if (response instanceof KeyRing) {
      requests.add(request);
      responseObserver.onNext((KeyRing) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void createCryptoKey(
      CreateCryptoKeyRequest request, StreamObserver<CryptoKey> responseObserver) {
    Object response = responses.remove();
    if (response instanceof CryptoKey) {
      requests.add(request);
      responseObserver.onNext((CryptoKey) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void createCryptoKeyVersion(
      CreateCryptoKeyVersionRequest request, StreamObserver<CryptoKeyVersion> responseObserver) {
    Object response = responses.remove();
    if (response instanceof CryptoKeyVersion) {
      requests.add(request);
      responseObserver.onNext((CryptoKeyVersion) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void updateCryptoKey(
      UpdateCryptoKeyRequest request, StreamObserver<CryptoKey> responseObserver) {
    Object response = responses.remove();
    if (response instanceof CryptoKey) {
      requests.add(request);
      responseObserver.onNext((CryptoKey) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void updateCryptoKeyVersion(
      UpdateCryptoKeyVersionRequest request, StreamObserver<CryptoKeyVersion> responseObserver) {
    Object response = responses.remove();
    if (response instanceof CryptoKeyVersion) {
      requests.add(request);
      responseObserver.onNext((CryptoKeyVersion) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void encrypt(EncryptRequest request, StreamObserver<EncryptResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof EncryptResponse) {
      requests.add(request);
      responseObserver.onNext((EncryptResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void decrypt(DecryptRequest request, StreamObserver<DecryptResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof DecryptResponse) {
      requests.add(request);
      responseObserver.onNext((DecryptResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void asymmetricSign(
      AsymmetricSignRequest request, StreamObserver<AsymmetricSignResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof AsymmetricSignResponse) {
      requests.add(request);
      responseObserver.onNext((AsymmetricSignResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void asymmetricDecrypt(
      AsymmetricDecryptRequest request,
      StreamObserver<AsymmetricDecryptResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof AsymmetricDecryptResponse) {
      requests.add(request);
      responseObserver.onNext((AsymmetricDecryptResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void updateCryptoKeyPrimaryVersion(
      UpdateCryptoKeyPrimaryVersionRequest request, StreamObserver<CryptoKey> responseObserver) {
    Object response = responses.remove();
    if (response instanceof CryptoKey) {
      requests.add(request);
      responseObserver.onNext((CryptoKey) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void destroyCryptoKeyVersion(
      DestroyCryptoKeyVersionRequest request, StreamObserver<CryptoKeyVersion> responseObserver) {
    Object response = responses.remove();
    if (response instanceof CryptoKeyVersion) {
      requests.add(request);
      responseObserver.onNext((CryptoKeyVersion) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void restoreCryptoKeyVersion(
      RestoreCryptoKeyVersionRequest request, StreamObserver<CryptoKeyVersion> responseObserver) {
    Object response = responses.remove();
    if (response instanceof CryptoKeyVersion) {
      requests.add(request);
      responseObserver.onNext((CryptoKeyVersion) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }
}
