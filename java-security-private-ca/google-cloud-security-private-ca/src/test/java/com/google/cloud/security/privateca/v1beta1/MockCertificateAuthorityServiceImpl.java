/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.security.privateca.v1beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.security.privateca.v1beta1.CertificateAuthorityServiceGrpc.CertificateAuthorityServiceImplBase;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockCertificateAuthorityServiceImpl extends CertificateAuthorityServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockCertificateAuthorityServiceImpl() {
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
  public void createCertificate(
      CreateCertificateRequest request, StreamObserver<Certificate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Certificate) {
      requests.add(request);
      responseObserver.onNext(((Certificate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateCertificate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Certificate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCertificate(
      GetCertificateRequest request, StreamObserver<Certificate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Certificate) {
      requests.add(request);
      responseObserver.onNext(((Certificate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCertificate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Certificate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCertificates(
      ListCertificatesRequest request, StreamObserver<ListCertificatesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCertificatesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCertificatesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCertificates, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCertificatesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void revokeCertificate(
      RevokeCertificateRequest request, StreamObserver<Certificate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Certificate) {
      requests.add(request);
      responseObserver.onNext(((Certificate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RevokeCertificate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Certificate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCertificate(
      UpdateCertificateRequest request, StreamObserver<Certificate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Certificate) {
      requests.add(request);
      responseObserver.onNext(((Certificate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateCertificate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Certificate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void activateCertificateAuthority(
      ActivateCertificateAuthorityRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ActivateCertificateAuthority, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCertificateAuthority(
      CreateCertificateAuthorityRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateCertificateAuthority, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void disableCertificateAuthority(
      DisableCertificateAuthorityRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DisableCertificateAuthority, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void enableCertificateAuthority(
      EnableCertificateAuthorityRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method EnableCertificateAuthority, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchCertificateAuthorityCsr(
      FetchCertificateAuthorityCsrRequest request,
      StreamObserver<FetchCertificateAuthorityCsrResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchCertificateAuthorityCsrResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchCertificateAuthorityCsrResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchCertificateAuthorityCsr, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchCertificateAuthorityCsrResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCertificateAuthority(
      GetCertificateAuthorityRequest request,
      StreamObserver<CertificateAuthority> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CertificateAuthority) {
      requests.add(request);
      responseObserver.onNext(((CertificateAuthority) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCertificateAuthority, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CertificateAuthority.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCertificateAuthorities(
      ListCertificateAuthoritiesRequest request,
      StreamObserver<ListCertificateAuthoritiesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCertificateAuthoritiesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCertificateAuthoritiesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCertificateAuthorities, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCertificateAuthoritiesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void restoreCertificateAuthority(
      RestoreCertificateAuthorityRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RestoreCertificateAuthority, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void scheduleDeleteCertificateAuthority(
      ScheduleDeleteCertificateAuthorityRequest request,
      StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ScheduleDeleteCertificateAuthority, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCertificateAuthority(
      UpdateCertificateAuthorityRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateCertificateAuthority, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCertificateRevocationList(
      GetCertificateRevocationListRequest request,
      StreamObserver<CertificateRevocationList> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CertificateRevocationList) {
      requests.add(request);
      responseObserver.onNext(((CertificateRevocationList) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCertificateRevocationList, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CertificateRevocationList.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCertificateRevocationLists(
      ListCertificateRevocationListsRequest request,
      StreamObserver<ListCertificateRevocationListsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCertificateRevocationListsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCertificateRevocationListsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCertificateRevocationLists, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCertificateRevocationListsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCertificateRevocationList(
      UpdateCertificateRevocationListRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateCertificateRevocationList, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getReusableConfig(
      GetReusableConfigRequest request, StreamObserver<ReusableConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ReusableConfig) {
      requests.add(request);
      responseObserver.onNext(((ReusableConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetReusableConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ReusableConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listReusableConfigs(
      ListReusableConfigsRequest request,
      StreamObserver<ListReusableConfigsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListReusableConfigsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListReusableConfigsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListReusableConfigs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListReusableConfigsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
