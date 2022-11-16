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

package com.google.cloud.oslogin.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.oslogin.common.OsLoginProto;
import com.google.cloud.oslogin.v1.OsLoginServiceGrpc.OsLoginServiceImplBase;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockOsLoginServiceImpl extends OsLoginServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockOsLoginServiceImpl() {
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
  public void createSshPublicKey(
      CreateSshPublicKeyRequest request,
      StreamObserver<OsLoginProto.SshPublicKey> responseObserver) {
    Object response = responses.poll();
    if (response instanceof OsLoginProto.SshPublicKey) {
      requests.add(request);
      responseObserver.onNext(((OsLoginProto.SshPublicKey) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSshPublicKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  OsLoginProto.SshPublicKey.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deletePosixAccount(
      DeletePosixAccountRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeletePosixAccount, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSshPublicKey(
      DeleteSshPublicKeyRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteSshPublicKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getLoginProfile(
      GetLoginProfileRequest request, StreamObserver<LoginProfile> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LoginProfile) {
      requests.add(request);
      responseObserver.onNext(((LoginProfile) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetLoginProfile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LoginProfile.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSshPublicKey(
      GetSshPublicKeyRequest request, StreamObserver<OsLoginProto.SshPublicKey> responseObserver) {
    Object response = responses.poll();
    if (response instanceof OsLoginProto.SshPublicKey) {
      requests.add(request);
      responseObserver.onNext(((OsLoginProto.SshPublicKey) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSshPublicKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  OsLoginProto.SshPublicKey.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importSshPublicKey(
      ImportSshPublicKeyRequest request,
      StreamObserver<ImportSshPublicKeyResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ImportSshPublicKeyResponse) {
      requests.add(request);
      responseObserver.onNext(((ImportSshPublicKeyResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ImportSshPublicKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ImportSshPublicKeyResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSshPublicKey(
      UpdateSshPublicKeyRequest request,
      StreamObserver<OsLoginProto.SshPublicKey> responseObserver) {
    Object response = responses.poll();
    if (response instanceof OsLoginProto.SshPublicKey) {
      requests.add(request);
      responseObserver.onNext(((OsLoginProto.SshPublicKey) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSshPublicKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  OsLoginProto.SshPublicKey.class.getName(),
                  Exception.class.getName())));
    }
  }
}
