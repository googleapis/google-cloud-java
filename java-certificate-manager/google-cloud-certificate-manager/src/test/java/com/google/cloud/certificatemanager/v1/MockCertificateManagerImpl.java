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

package com.google.cloud.certificatemanager.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.certificatemanager.v1.CertificateManagerGrpc.CertificateManagerImplBase;
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
public class MockCertificateManagerImpl extends CertificateManagerImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockCertificateManagerImpl() {
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
  public void createCertificate(
      CreateCertificateRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateCertificate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCertificate(
      UpdateCertificateRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateCertificate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteCertificate(
      DeleteCertificateRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteCertificate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCertificateMaps(
      ListCertificateMapsRequest request,
      StreamObserver<ListCertificateMapsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCertificateMapsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCertificateMapsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCertificateMaps, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCertificateMapsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCertificateMap(
      GetCertificateMapRequest request, StreamObserver<CertificateMap> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CertificateMap) {
      requests.add(request);
      responseObserver.onNext(((CertificateMap) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCertificateMap, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CertificateMap.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCertificateMap(
      CreateCertificateMapRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateCertificateMap, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCertificateMap(
      UpdateCertificateMapRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateCertificateMap, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteCertificateMap(
      DeleteCertificateMapRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteCertificateMap, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCertificateMapEntries(
      ListCertificateMapEntriesRequest request,
      StreamObserver<ListCertificateMapEntriesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCertificateMapEntriesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCertificateMapEntriesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCertificateMapEntries, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCertificateMapEntriesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCertificateMapEntry(
      GetCertificateMapEntryRequest request, StreamObserver<CertificateMapEntry> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CertificateMapEntry) {
      requests.add(request);
      responseObserver.onNext(((CertificateMapEntry) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCertificateMapEntry, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CertificateMapEntry.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCertificateMapEntry(
      CreateCertificateMapEntryRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateCertificateMapEntry, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCertificateMapEntry(
      UpdateCertificateMapEntryRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateCertificateMapEntry, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteCertificateMapEntry(
      DeleteCertificateMapEntryRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteCertificateMapEntry, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDnsAuthorizations(
      ListDnsAuthorizationsRequest request,
      StreamObserver<ListDnsAuthorizationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDnsAuthorizationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDnsAuthorizationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDnsAuthorizations, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDnsAuthorizationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDnsAuthorization(
      GetDnsAuthorizationRequest request, StreamObserver<DnsAuthorization> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DnsAuthorization) {
      requests.add(request);
      responseObserver.onNext(((DnsAuthorization) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDnsAuthorization, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DnsAuthorization.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDnsAuthorization(
      CreateDnsAuthorizationRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateDnsAuthorization, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDnsAuthorization(
      UpdateDnsAuthorizationRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateDnsAuthorization, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDnsAuthorization(
      DeleteDnsAuthorizationRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteDnsAuthorization, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
