/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.security.privateca.v1beta1;

import static com.google.cloud.security.privateca.v1beta1.CertificateAuthorityServiceClient.ListCertificateAuthoritiesPagedResponse;
import static com.google.cloud.security.privateca.v1beta1.CertificateAuthorityServiceClient.ListCertificateRevocationListsPagedResponse;
import static com.google.cloud.security.privateca.v1beta1.CertificateAuthorityServiceClient.ListCertificatesPagedResponse;
import static com.google.cloud.security.privateca.v1beta1.CertificateAuthorityServiceClient.ListReusableConfigsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class CertificateAuthorityServiceClientTest {
  private static MockCertificateAuthorityService mockCertificateAuthorityService;
  private static MockServiceHelper serviceHelper;
  private CertificateAuthorityServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockCertificateAuthorityService = new MockCertificateAuthorityService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockCertificateAuthorityService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    CertificateAuthorityServiceSettings settings =
        CertificateAuthorityServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CertificateAuthorityServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createCertificateTest() {
    CertificateName name =
        CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]");
    String pemCsr = "pemCsr-683665829";
    String pemCertificate = "pemCertificate1234463984";
    Certificate expectedResponse =
        Certificate.newBuilder()
            .setName(name.toString())
            .setPemCsr(pemCsr)
            .setPemCertificate(pemCertificate)
            .build();
    mockCertificateAuthorityService.addResponse(expectedResponse);

    CertificateAuthorityName parent =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
    Certificate certificate = Certificate.newBuilder().build();
    String certificateId = "certificateId1494430915";

    Certificate actualResponse = client.createCertificate(parent, certificate, certificateId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCertificateRequest actualRequest = (CreateCertificateRequest) actualRequests.get(0);

    Assert.assertEquals(parent, CertificateAuthorityName.parse(actualRequest.getParent()));
    Assert.assertEquals(certificate, actualRequest.getCertificate());
    Assert.assertEquals(certificateId, actualRequest.getCertificateId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createCertificateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCertificateAuthorityService.addException(exception);

    try {
      CertificateAuthorityName parent =
          CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
      Certificate certificate = Certificate.newBuilder().build();
      String certificateId = "certificateId1494430915";

      client.createCertificate(parent, certificate, certificateId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getCertificateTest() {
    CertificateName name2 =
        CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]");
    String pemCsr = "pemCsr-683665829";
    String pemCertificate = "pemCertificate1234463984";
    Certificate expectedResponse =
        Certificate.newBuilder()
            .setName(name2.toString())
            .setPemCsr(pemCsr)
            .setPemCertificate(pemCertificate)
            .build();
    mockCertificateAuthorityService.addResponse(expectedResponse);

    CertificateName name =
        CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]");

    Certificate actualResponse = client.getCertificate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCertificateRequest actualRequest = (GetCertificateRequest) actualRequests.get(0);

    Assert.assertEquals(name, CertificateName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getCertificateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCertificateAuthorityService.addException(exception);

    try {
      CertificateName name =
          CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]");

      client.getCertificate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listCertificatesTest() {
    String nextPageToken = "";
    Certificate certificatesElement = Certificate.newBuilder().build();
    List<Certificate> certificates = Arrays.asList(certificatesElement);
    ListCertificatesResponse expectedResponse =
        ListCertificatesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllCertificates(certificates)
            .build();
    mockCertificateAuthorityService.addResponse(expectedResponse);

    CertificateAuthorityName parent =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

    ListCertificatesPagedResponse pagedListResponse = client.listCertificates(parent);

    List<Certificate> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCertificatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCertificatesRequest actualRequest = (ListCertificatesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, CertificateAuthorityName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listCertificatesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCertificateAuthorityService.addException(exception);

    try {
      CertificateAuthorityName parent =
          CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

      client.listCertificates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void revokeCertificateTest() {
    CertificateName name2 =
        CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]");
    String pemCsr = "pemCsr-683665829";
    String pemCertificate = "pemCertificate1234463984";
    Certificate expectedResponse =
        Certificate.newBuilder()
            .setName(name2.toString())
            .setPemCsr(pemCsr)
            .setPemCertificate(pemCertificate)
            .build();
    mockCertificateAuthorityService.addResponse(expectedResponse);

    CertificateName name =
        CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]");

    Certificate actualResponse = client.revokeCertificate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RevokeCertificateRequest actualRequest = (RevokeCertificateRequest) actualRequests.get(0);

    Assert.assertEquals(name, CertificateName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void revokeCertificateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCertificateAuthorityService.addException(exception);

    try {
      CertificateName name =
          CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]");

      client.revokeCertificate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateCertificateTest() {
    CertificateName name =
        CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]");
    String pemCsr = "pemCsr-683665829";
    String pemCertificate = "pemCertificate1234463984";
    Certificate expectedResponse =
        Certificate.newBuilder()
            .setName(name.toString())
            .setPemCsr(pemCsr)
            .setPemCertificate(pemCertificate)
            .build();
    mockCertificateAuthorityService.addResponse(expectedResponse);

    Certificate certificate = Certificate.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Certificate actualResponse = client.updateCertificate(certificate, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCertificateRequest actualRequest = (UpdateCertificateRequest) actualRequests.get(0);

    Assert.assertEquals(certificate, actualRequest.getCertificate());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateCertificateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCertificateAuthorityService.addException(exception);

    try {
      Certificate certificate = Certificate.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateCertificate(certificate, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void activateCertificateAuthorityTest() throws Exception {
    CertificateAuthorityName name2 =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
    String gcsBucket = "gcsBucket-1720393710";
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder().setName(name2.toString()).setGcsBucket(gcsBucket).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("activateCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateAuthorityService.addResponse(resultOperation);

    CertificateAuthorityName name =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

    CertificateAuthority actualResponse = client.activateCertificateAuthorityAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ActivateCertificateAuthorityRequest actualRequest =
        (ActivateCertificateAuthorityRequest) actualRequests.get(0);

    Assert.assertEquals(name, CertificateAuthorityName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void activateCertificateAuthorityExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCertificateAuthorityService.addException(exception);

    try {
      CertificateAuthorityName name =
          CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

      client.activateCertificateAuthorityAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createCertificateAuthorityTest() throws Exception {
    CertificateAuthorityName name =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
    String gcsBucket = "gcsBucket-1720393710";
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder().setName(name.toString()).setGcsBucket(gcsBucket).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateAuthorityService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    CertificateAuthority certificateAuthority = CertificateAuthority.newBuilder().build();
    String certificateAuthorityId = "certificateAuthorityId561919295";

    CertificateAuthority actualResponse =
        client
            .createCertificateAuthorityAsync(parent, certificateAuthority, certificateAuthorityId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCertificateAuthorityRequest actualRequest =
        (CreateCertificateAuthorityRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(certificateAuthority, actualRequest.getCertificateAuthority());
    Assert.assertEquals(certificateAuthorityId, actualRequest.getCertificateAuthorityId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createCertificateAuthorityExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCertificateAuthorityService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      CertificateAuthority certificateAuthority = CertificateAuthority.newBuilder().build();
      String certificateAuthorityId = "certificateAuthorityId561919295";

      client
          .createCertificateAuthorityAsync(parent, certificateAuthority, certificateAuthorityId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void disableCertificateAuthorityTest() throws Exception {
    CertificateAuthorityName name2 =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
    String gcsBucket = "gcsBucket-1720393710";
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder().setName(name2.toString()).setGcsBucket(gcsBucket).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("disableCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateAuthorityService.addResponse(resultOperation);

    CertificateAuthorityName name =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

    CertificateAuthority actualResponse = client.disableCertificateAuthorityAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DisableCertificateAuthorityRequest actualRequest =
        (DisableCertificateAuthorityRequest) actualRequests.get(0);

    Assert.assertEquals(name, CertificateAuthorityName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void disableCertificateAuthorityExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCertificateAuthorityService.addException(exception);

    try {
      CertificateAuthorityName name =
          CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

      client.disableCertificateAuthorityAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void enableCertificateAuthorityTest() throws Exception {
    CertificateAuthorityName name2 =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
    String gcsBucket = "gcsBucket-1720393710";
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder().setName(name2.toString()).setGcsBucket(gcsBucket).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("enableCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateAuthorityService.addResponse(resultOperation);

    CertificateAuthorityName name =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

    CertificateAuthority actualResponse = client.enableCertificateAuthorityAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EnableCertificateAuthorityRequest actualRequest =
        (EnableCertificateAuthorityRequest) actualRequests.get(0);

    Assert.assertEquals(name, CertificateAuthorityName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void enableCertificateAuthorityExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCertificateAuthorityService.addException(exception);

    try {
      CertificateAuthorityName name =
          CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

      client.enableCertificateAuthorityAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void fetchCertificateAuthorityCsrTest() {
    String pemCsr = "pemCsr-683665829";
    FetchCertificateAuthorityCsrResponse expectedResponse =
        FetchCertificateAuthorityCsrResponse.newBuilder().setPemCsr(pemCsr).build();
    mockCertificateAuthorityService.addResponse(expectedResponse);

    CertificateAuthorityName name =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

    FetchCertificateAuthorityCsrResponse actualResponse = client.fetchCertificateAuthorityCsr(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchCertificateAuthorityCsrRequest actualRequest =
        (FetchCertificateAuthorityCsrRequest) actualRequests.get(0);

    Assert.assertEquals(name, CertificateAuthorityName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void fetchCertificateAuthorityCsrExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCertificateAuthorityService.addException(exception);

    try {
      CertificateAuthorityName name =
          CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

      client.fetchCertificateAuthorityCsr(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getCertificateAuthorityTest() {
    CertificateAuthorityName name2 =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
    String gcsBucket = "gcsBucket-1720393710";
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder().setName(name2.toString()).setGcsBucket(gcsBucket).build();
    mockCertificateAuthorityService.addResponse(expectedResponse);

    CertificateAuthorityName name =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

    CertificateAuthority actualResponse = client.getCertificateAuthority(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCertificateAuthorityRequest actualRequest =
        (GetCertificateAuthorityRequest) actualRequests.get(0);

    Assert.assertEquals(name, CertificateAuthorityName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getCertificateAuthorityExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCertificateAuthorityService.addException(exception);

    try {
      CertificateAuthorityName name =
          CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

      client.getCertificateAuthority(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listCertificateAuthoritiesTest() {
    String nextPageToken = "";
    CertificateAuthority certificateAuthoritiesElement = CertificateAuthority.newBuilder().build();
    List<CertificateAuthority> certificateAuthorities =
        Arrays.asList(certificateAuthoritiesElement);
    ListCertificateAuthoritiesResponse expectedResponse =
        ListCertificateAuthoritiesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllCertificateAuthorities(certificateAuthorities)
            .build();
    mockCertificateAuthorityService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCertificateAuthoritiesPagedResponse pagedListResponse =
        client.listCertificateAuthorities(parent);

    List<CertificateAuthority> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCertificateAuthoritiesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCertificateAuthoritiesRequest actualRequest =
        (ListCertificateAuthoritiesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listCertificateAuthoritiesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCertificateAuthorityService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

      client.listCertificateAuthorities(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void restoreCertificateAuthorityTest() throws Exception {
    CertificateAuthorityName name2 =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
    String gcsBucket = "gcsBucket-1720393710";
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder().setName(name2.toString()).setGcsBucket(gcsBucket).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateAuthorityService.addResponse(resultOperation);

    CertificateAuthorityName name =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

    CertificateAuthority actualResponse = client.restoreCertificateAuthorityAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestoreCertificateAuthorityRequest actualRequest =
        (RestoreCertificateAuthorityRequest) actualRequests.get(0);

    Assert.assertEquals(name, CertificateAuthorityName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void restoreCertificateAuthorityExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCertificateAuthorityService.addException(exception);

    try {
      CertificateAuthorityName name =
          CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

      client.restoreCertificateAuthorityAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void scheduleDeleteCertificateAuthorityTest() throws Exception {
    CertificateAuthorityName name2 =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
    String gcsBucket = "gcsBucket-1720393710";
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder().setName(name2.toString()).setGcsBucket(gcsBucket).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("scheduleDeleteCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateAuthorityService.addResponse(resultOperation);

    CertificateAuthorityName name =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

    CertificateAuthority actualResponse =
        client.scheduleDeleteCertificateAuthorityAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ScheduleDeleteCertificateAuthorityRequest actualRequest =
        (ScheduleDeleteCertificateAuthorityRequest) actualRequests.get(0);

    Assert.assertEquals(name, CertificateAuthorityName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void scheduleDeleteCertificateAuthorityExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCertificateAuthorityService.addException(exception);

    try {
      CertificateAuthorityName name =
          CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

      client.scheduleDeleteCertificateAuthorityAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateCertificateAuthorityTest() throws Exception {
    CertificateAuthorityName name =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
    String gcsBucket = "gcsBucket-1720393710";
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder().setName(name.toString()).setGcsBucket(gcsBucket).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateAuthorityService.addResponse(resultOperation);

    CertificateAuthority certificateAuthority = CertificateAuthority.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CertificateAuthority actualResponse =
        client.updateCertificateAuthorityAsync(certificateAuthority, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCertificateAuthorityRequest actualRequest =
        (UpdateCertificateAuthorityRequest) actualRequests.get(0);

    Assert.assertEquals(certificateAuthority, actualRequest.getCertificateAuthority());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateCertificateAuthorityExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCertificateAuthorityService.addException(exception);

    try {
      CertificateAuthority certificateAuthority = CertificateAuthority.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateCertificateAuthorityAsync(certificateAuthority, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createCertificateRevocationListTest() throws Exception {
    CertificateRevocationListName name =
        CertificateRevocationListName.of(
            "[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE_REVOCATION_LIST]");
    long sequenceNumber = 1309190777L;
    String pemCrl = "pemCrl-683665866";
    String accessUrl = "accessUrl-1141680108";
    CertificateRevocationList expectedResponse =
        CertificateRevocationList.newBuilder()
            .setName(name.toString())
            .setSequenceNumber(sequenceNumber)
            .setPemCrl(pemCrl)
            .setAccessUrl(accessUrl)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCertificateRevocationListTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateAuthorityService.addResponse(resultOperation);

    CertificateAuthorityName parent =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
    CertificateRevocationList certificateRevocationList =
        CertificateRevocationList.newBuilder().build();
    String certificateRevocationListId = "certificateRevocationListId1847074915";

    CertificateRevocationList actualResponse =
        client
            .createCertificateRevocationListAsync(
                parent, certificateRevocationList, certificateRevocationListId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCertificateRevocationListRequest actualRequest =
        (CreateCertificateRevocationListRequest) actualRequests.get(0);

    Assert.assertEquals(parent, CertificateAuthorityName.parse(actualRequest.getParent()));
    Assert.assertEquals(certificateRevocationList, actualRequest.getCertificateRevocationList());
    Assert.assertEquals(
        certificateRevocationListId, actualRequest.getCertificateRevocationListId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createCertificateRevocationListExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCertificateAuthorityService.addException(exception);

    try {
      CertificateAuthorityName parent =
          CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
      CertificateRevocationList certificateRevocationList =
          CertificateRevocationList.newBuilder().build();
      String certificateRevocationListId = "certificateRevocationListId1847074915";

      client
          .createCertificateRevocationListAsync(
              parent, certificateRevocationList, certificateRevocationListId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getCertificateRevocationListTest() {
    CertificateRevocationListName name2 =
        CertificateRevocationListName.of(
            "[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE_REVOCATION_LIST]");
    long sequenceNumber = 1309190777L;
    String pemCrl = "pemCrl-683665866";
    String accessUrl = "accessUrl-1141680108";
    CertificateRevocationList expectedResponse =
        CertificateRevocationList.newBuilder()
            .setName(name2.toString())
            .setSequenceNumber(sequenceNumber)
            .setPemCrl(pemCrl)
            .setAccessUrl(accessUrl)
            .build();
    mockCertificateAuthorityService.addResponse(expectedResponse);

    CertificateRevocationListName name =
        CertificateRevocationListName.of(
            "[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE_REVOCATION_LIST]");

    CertificateRevocationList actualResponse = client.getCertificateRevocationList(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCertificateRevocationListRequest actualRequest =
        (GetCertificateRevocationListRequest) actualRequests.get(0);

    Assert.assertEquals(name, CertificateRevocationListName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getCertificateRevocationListExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCertificateAuthorityService.addException(exception);

    try {
      CertificateRevocationListName name =
          CertificateRevocationListName.of(
              "[PROJECT]",
              "[LOCATION]",
              "[CERTIFICATE_AUTHORITY]",
              "[CERTIFICATE_REVOCATION_LIST]");

      client.getCertificateRevocationList(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listCertificateRevocationListsTest() {
    String nextPageToken = "";
    CertificateRevocationList certificateRevocationListsElement =
        CertificateRevocationList.newBuilder().build();
    List<CertificateRevocationList> certificateRevocationLists =
        Arrays.asList(certificateRevocationListsElement);
    ListCertificateRevocationListsResponse expectedResponse =
        ListCertificateRevocationListsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllCertificateRevocationLists(certificateRevocationLists)
            .build();
    mockCertificateAuthorityService.addResponse(expectedResponse);

    CertificateAuthorityName parent =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

    ListCertificateRevocationListsPagedResponse pagedListResponse =
        client.listCertificateRevocationLists(parent);

    List<CertificateRevocationList> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getCertificateRevocationListsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCertificateRevocationListsRequest actualRequest =
        (ListCertificateRevocationListsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, CertificateAuthorityName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listCertificateRevocationListsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCertificateAuthorityService.addException(exception);

    try {
      CertificateAuthorityName parent =
          CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

      client.listCertificateRevocationLists(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateCertificateRevocationListTest() throws Exception {
    CertificateRevocationListName name =
        CertificateRevocationListName.of(
            "[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE_REVOCATION_LIST]");
    long sequenceNumber = 1309190777L;
    String pemCrl = "pemCrl-683665866";
    String accessUrl = "accessUrl-1141680108";
    CertificateRevocationList expectedResponse =
        CertificateRevocationList.newBuilder()
            .setName(name.toString())
            .setSequenceNumber(sequenceNumber)
            .setPemCrl(pemCrl)
            .setAccessUrl(accessUrl)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateCertificateRevocationListTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateAuthorityService.addResponse(resultOperation);

    CertificateRevocationList certificateRevocationList =
        CertificateRevocationList.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CertificateRevocationList actualResponse =
        client.updateCertificateRevocationListAsync(certificateRevocationList, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCertificateRevocationListRequest actualRequest =
        (UpdateCertificateRevocationListRequest) actualRequests.get(0);

    Assert.assertEquals(certificateRevocationList, actualRequest.getCertificateRevocationList());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateCertificateRevocationListExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCertificateAuthorityService.addException(exception);

    try {
      CertificateRevocationList certificateRevocationList =
          CertificateRevocationList.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateCertificateRevocationListAsync(certificateRevocationList, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createReusableConfigTest() throws Exception {
    ReusableConfigName name = ReusableConfigName.of("[PROJECT]", "[LOCATION]", "[REUSABLE_CONFIG]");
    String description = "description-1724546052";
    ReusableConfig expectedResponse =
        ReusableConfig.newBuilder().setName(name.toString()).setDescription(description).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createReusableConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateAuthorityService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ReusableConfig reusableConfig = ReusableConfig.newBuilder().build();
    String reusableConfigId = "reusableConfigId685940964";

    ReusableConfig actualResponse =
        client.createReusableConfigAsync(parent, reusableConfig, reusableConfigId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReusableConfigRequest actualRequest = (CreateReusableConfigRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(reusableConfig, actualRequest.getReusableConfig());
    Assert.assertEquals(reusableConfigId, actualRequest.getReusableConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createReusableConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCertificateAuthorityService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ReusableConfig reusableConfig = ReusableConfig.newBuilder().build();
      String reusableConfigId = "reusableConfigId685940964";

      client.createReusableConfigAsync(parent, reusableConfig, reusableConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteReusableConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteReusableConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateAuthorityService.addResponse(resultOperation);

    ReusableConfigName name = ReusableConfigName.of("[PROJECT]", "[LOCATION]", "[REUSABLE_CONFIG]");

    Empty actualResponse = client.deleteReusableConfigAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteReusableConfigRequest actualRequest = (DeleteReusableConfigRequest) actualRequests.get(0);

    Assert.assertEquals(name, ReusableConfigName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteReusableConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCertificateAuthorityService.addException(exception);

    try {
      ReusableConfigName name =
          ReusableConfigName.of("[PROJECT]", "[LOCATION]", "[REUSABLE_CONFIG]");

      client.deleteReusableConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getReusableConfigTest() {
    ReusableConfigName name2 =
        ReusableConfigName.of("[PROJECT]", "[LOCATION]", "[REUSABLE_CONFIG]");
    String description = "description-1724546052";
    ReusableConfig expectedResponse =
        ReusableConfig.newBuilder().setName(name2.toString()).setDescription(description).build();
    mockCertificateAuthorityService.addResponse(expectedResponse);

    ReusableConfigName name = ReusableConfigName.of("[PROJECT]", "[LOCATION]", "[REUSABLE_CONFIG]");

    ReusableConfig actualResponse = client.getReusableConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetReusableConfigRequest actualRequest = (GetReusableConfigRequest) actualRequests.get(0);

    Assert.assertEquals(name, ReusableConfigName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getReusableConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCertificateAuthorityService.addException(exception);

    try {
      ReusableConfigName name =
          ReusableConfigName.of("[PROJECT]", "[LOCATION]", "[REUSABLE_CONFIG]");

      client.getReusableConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listReusableConfigsTest() {
    String nextPageToken = "";
    ReusableConfig reusableConfigsElement = ReusableConfig.newBuilder().build();
    List<ReusableConfig> reusableConfigs = Arrays.asList(reusableConfigsElement);
    ListReusableConfigsResponse expectedResponse =
        ListReusableConfigsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllReusableConfigs(reusableConfigs)
            .build();
    mockCertificateAuthorityService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListReusableConfigsPagedResponse pagedListResponse = client.listReusableConfigs(parent);

    List<ReusableConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReusableConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListReusableConfigsRequest actualRequest = (ListReusableConfigsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listReusableConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCertificateAuthorityService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

      client.listReusableConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateReusableConfigTest() throws Exception {
    ReusableConfigName name = ReusableConfigName.of("[PROJECT]", "[LOCATION]", "[REUSABLE_CONFIG]");
    String description = "description-1724546052";
    ReusableConfig expectedResponse =
        ReusableConfig.newBuilder().setName(name.toString()).setDescription(description).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateReusableConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateAuthorityService.addResponse(resultOperation);

    ReusableConfig reusableConfig = ReusableConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ReusableConfig actualResponse =
        client.updateReusableConfigAsync(reusableConfig, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateAuthorityService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateReusableConfigRequest actualRequest = (UpdateReusableConfigRequest) actualRequests.get(0);

    Assert.assertEquals(reusableConfig, actualRequest.getReusableConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateReusableConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockCertificateAuthorityService.addException(exception);

    try {
      ReusableConfig reusableConfig = ReusableConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateReusableConfigAsync(reusableConfig, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
