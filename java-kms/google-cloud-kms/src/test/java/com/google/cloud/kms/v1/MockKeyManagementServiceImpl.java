/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
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
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
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
    Object response = responses.poll();
    if (response instanceof ListKeyRingsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListKeyRingsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListKeyRings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListKeyRingsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCryptoKeys(
      ListCryptoKeysRequest request, StreamObserver<ListCryptoKeysResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCryptoKeysResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCryptoKeysResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCryptoKeys, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCryptoKeysResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCryptoKeyVersions(
      ListCryptoKeyVersionsRequest request,
      StreamObserver<ListCryptoKeyVersionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCryptoKeyVersionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCryptoKeyVersionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCryptoKeyVersions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCryptoKeyVersionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listImportJobs(
      ListImportJobsRequest request, StreamObserver<ListImportJobsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListImportJobsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListImportJobsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListImportJobs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListImportJobsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getKeyRing(GetKeyRingRequest request, StreamObserver<KeyRing> responseObserver) {
    Object response = responses.poll();
    if (response instanceof KeyRing) {
      requests.add(request);
      responseObserver.onNext(((KeyRing) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetKeyRing, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  KeyRing.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCryptoKey(
      GetCryptoKeyRequest request, StreamObserver<CryptoKey> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CryptoKey) {
      requests.add(request);
      responseObserver.onNext(((CryptoKey) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCryptoKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CryptoKey.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCryptoKeyVersion(
      GetCryptoKeyVersionRequest request, StreamObserver<CryptoKeyVersion> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CryptoKeyVersion) {
      requests.add(request);
      responseObserver.onNext(((CryptoKeyVersion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCryptoKeyVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CryptoKeyVersion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPublicKey(
      GetPublicKeyRequest request, StreamObserver<PublicKey> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PublicKey) {
      requests.add(request);
      responseObserver.onNext(((PublicKey) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPublicKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PublicKey.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getImportJob(
      GetImportJobRequest request, StreamObserver<ImportJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ImportJob) {
      requests.add(request);
      responseObserver.onNext(((ImportJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetImportJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ImportJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createKeyRing(
      CreateKeyRingRequest request, StreamObserver<KeyRing> responseObserver) {
    Object response = responses.poll();
    if (response instanceof KeyRing) {
      requests.add(request);
      responseObserver.onNext(((KeyRing) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateKeyRing, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  KeyRing.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCryptoKey(
      CreateCryptoKeyRequest request, StreamObserver<CryptoKey> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CryptoKey) {
      requests.add(request);
      responseObserver.onNext(((CryptoKey) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateCryptoKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CryptoKey.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCryptoKeyVersion(
      CreateCryptoKeyVersionRequest request, StreamObserver<CryptoKeyVersion> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CryptoKeyVersion) {
      requests.add(request);
      responseObserver.onNext(((CryptoKeyVersion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateCryptoKeyVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CryptoKeyVersion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importCryptoKeyVersion(
      ImportCryptoKeyVersionRequest request, StreamObserver<CryptoKeyVersion> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CryptoKeyVersion) {
      requests.add(request);
      responseObserver.onNext(((CryptoKeyVersion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ImportCryptoKeyVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CryptoKeyVersion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createImportJob(
      CreateImportJobRequest request, StreamObserver<ImportJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ImportJob) {
      requests.add(request);
      responseObserver.onNext(((ImportJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateImportJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ImportJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCryptoKey(
      UpdateCryptoKeyRequest request, StreamObserver<CryptoKey> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CryptoKey) {
      requests.add(request);
      responseObserver.onNext(((CryptoKey) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateCryptoKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CryptoKey.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCryptoKeyVersion(
      UpdateCryptoKeyVersionRequest request, StreamObserver<CryptoKeyVersion> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CryptoKeyVersion) {
      requests.add(request);
      responseObserver.onNext(((CryptoKeyVersion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateCryptoKeyVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CryptoKeyVersion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCryptoKeyPrimaryVersion(
      UpdateCryptoKeyPrimaryVersionRequest request, StreamObserver<CryptoKey> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CryptoKey) {
      requests.add(request);
      responseObserver.onNext(((CryptoKey) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateCryptoKeyPrimaryVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CryptoKey.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void destroyCryptoKeyVersion(
      DestroyCryptoKeyVersionRequest request, StreamObserver<CryptoKeyVersion> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CryptoKeyVersion) {
      requests.add(request);
      responseObserver.onNext(((CryptoKeyVersion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DestroyCryptoKeyVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CryptoKeyVersion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void restoreCryptoKeyVersion(
      RestoreCryptoKeyVersionRequest request, StreamObserver<CryptoKeyVersion> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CryptoKeyVersion) {
      requests.add(request);
      responseObserver.onNext(((CryptoKeyVersion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RestoreCryptoKeyVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CryptoKeyVersion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void encrypt(EncryptRequest request, StreamObserver<EncryptResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EncryptResponse) {
      requests.add(request);
      responseObserver.onNext(((EncryptResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method Encrypt, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EncryptResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void decrypt(DecryptRequest request, StreamObserver<DecryptResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DecryptResponse) {
      requests.add(request);
      responseObserver.onNext(((DecryptResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method Decrypt, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DecryptResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void asymmetricSign(
      AsymmetricSignRequest request, StreamObserver<AsymmetricSignResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AsymmetricSignResponse) {
      requests.add(request);
      responseObserver.onNext(((AsymmetricSignResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AsymmetricSign, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AsymmetricSignResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void asymmetricDecrypt(
      AsymmetricDecryptRequest request,
      StreamObserver<AsymmetricDecryptResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AsymmetricDecryptResponse) {
      requests.add(request);
      responseObserver.onNext(((AsymmetricDecryptResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AsymmetricDecrypt, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AsymmetricDecryptResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void macSign(MacSignRequest request, StreamObserver<MacSignResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MacSignResponse) {
      requests.add(request);
      responseObserver.onNext(((MacSignResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method MacSign, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MacSignResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void macVerify(
      MacVerifyRequest request, StreamObserver<MacVerifyResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MacVerifyResponse) {
      requests.add(request);
      responseObserver.onNext(((MacVerifyResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method MacVerify, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MacVerifyResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateRandomBytes(
      GenerateRandomBytesRequest request,
      StreamObserver<GenerateRandomBytesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateRandomBytesResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateRandomBytesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateRandomBytes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateRandomBytesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
