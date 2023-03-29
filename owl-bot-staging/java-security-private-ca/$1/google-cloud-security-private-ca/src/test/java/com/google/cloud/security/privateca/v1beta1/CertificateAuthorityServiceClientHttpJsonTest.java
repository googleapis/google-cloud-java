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

package com.google.cloud.security.privateca.v1beta1;

import static com.google.cloud.security.privateca.v1beta1.CertificateAuthorityServiceClient.ListCertificateAuthoritiesPagedResponse;
import static com.google.cloud.security.privateca.v1beta1.CertificateAuthorityServiceClient.ListCertificateRevocationListsPagedResponse;
import static com.google.cloud.security.privateca.v1beta1.CertificateAuthorityServiceClient.ListCertificatesPagedResponse;
import static com.google.cloud.security.privateca.v1beta1.CertificateAuthorityServiceClient.ListReusableConfigsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.security.privateca.v1beta1.stub.HttpJsonCertificateAuthorityServiceStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class CertificateAuthorityServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static CertificateAuthorityServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCertificateAuthorityServiceStub.getMethodDescriptors(),
            CertificateAuthorityServiceSettings.getDefaultEndpoint());
    CertificateAuthorityServiceSettings settings =
        CertificateAuthorityServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                CertificateAuthorityServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CertificateAuthorityServiceClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void createCertificateTest() throws Exception {
    Certificate expectedResponse =
        Certificate.newBuilder()
            .setName(
                CertificateName.of(
                        "[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]")
                    .toString())
            .setLifetime(Duration.newBuilder().build())
            .setRevocationDetails(Certificate.RevocationDetails.newBuilder().build())
            .setPemCertificate("pemCertificate153491807")
            .setCertificateDescription(CertificateDescription.newBuilder().build())
            .addAllPemCertificateChain(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    CertificateAuthorityName parent =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
    Certificate certificate = Certificate.newBuilder().build();
    String certificateId = "certificateId-644529902";

    Certificate actualResponse = client.createCertificate(parent, certificate, certificateId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createCertificateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CertificateAuthorityName parent =
          CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
      Certificate certificate = Certificate.newBuilder().build();
      String certificateId = "certificateId-644529902";
      client.createCertificate(parent, certificate, certificateId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCertificateTest2() throws Exception {
    Certificate expectedResponse =
        Certificate.newBuilder()
            .setName(
                CertificateName.of(
                        "[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]")
                    .toString())
            .setLifetime(Duration.newBuilder().build())
            .setRevocationDetails(Certificate.RevocationDetails.newBuilder().build())
            .setPemCertificate("pemCertificate153491807")
            .setCertificateDescription(CertificateDescription.newBuilder().build())
            .addAllPemCertificateChain(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-2053/locations/location-2053/certificateAuthorities/certificateAuthoritie-2053";
    Certificate certificate = Certificate.newBuilder().build();
    String certificateId = "certificateId-644529902";

    Certificate actualResponse = client.createCertificate(parent, certificate, certificateId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createCertificateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-2053/locations/location-2053/certificateAuthorities/certificateAuthoritie-2053";
      Certificate certificate = Certificate.newBuilder().build();
      String certificateId = "certificateId-644529902";
      client.createCertificate(parent, certificate, certificateId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCertificateTest() throws Exception {
    Certificate expectedResponse =
        Certificate.newBuilder()
            .setName(
                CertificateName.of(
                        "[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]")
                    .toString())
            .setLifetime(Duration.newBuilder().build())
            .setRevocationDetails(Certificate.RevocationDetails.newBuilder().build())
            .setPemCertificate("pemCertificate153491807")
            .setCertificateDescription(CertificateDescription.newBuilder().build())
            .addAllPemCertificateChain(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    CertificateName name =
        CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]");

    Certificate actualResponse = client.getCertificate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getCertificateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CertificateName name =
          CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]");
      client.getCertificate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCertificateTest2() throws Exception {
    Certificate expectedResponse =
        Certificate.newBuilder()
            .setName(
                CertificateName.of(
                        "[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]")
                    .toString())
            .setLifetime(Duration.newBuilder().build())
            .setRevocationDetails(Certificate.RevocationDetails.newBuilder().build())
            .setPemCertificate("pemCertificate153491807")
            .setCertificateDescription(CertificateDescription.newBuilder().build())
            .addAllPemCertificateChain(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8612/locations/location-8612/certificateAuthorities/certificateAuthoritie-8612/certificates/certificate-8612";

    Certificate actualResponse = client.getCertificate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getCertificateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8612/locations/location-8612/certificateAuthorities/certificateAuthoritie-8612/certificates/certificate-8612";
      client.getCertificate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCertificatesTest() throws Exception {
    Certificate responsesElement = Certificate.newBuilder().build();
    ListCertificatesResponse expectedResponse =
        ListCertificatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCertificates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CertificateAuthorityName parent =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

    ListCertificatesPagedResponse pagedListResponse = client.listCertificates(parent);

    List<Certificate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCertificatesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listCertificatesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CertificateAuthorityName parent =
          CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
      client.listCertificates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCertificatesTest2() throws Exception {
    Certificate responsesElement = Certificate.newBuilder().build();
    ListCertificatesResponse expectedResponse =
        ListCertificatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCertificates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-2053/locations/location-2053/certificateAuthorities/certificateAuthoritie-2053";

    ListCertificatesPagedResponse pagedListResponse = client.listCertificates(parent);

    List<Certificate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCertificatesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listCertificatesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-2053/locations/location-2053/certificateAuthorities/certificateAuthoritie-2053";
      client.listCertificates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void revokeCertificateTest() throws Exception {
    Certificate expectedResponse =
        Certificate.newBuilder()
            .setName(
                CertificateName.of(
                        "[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]")
                    .toString())
            .setLifetime(Duration.newBuilder().build())
            .setRevocationDetails(Certificate.RevocationDetails.newBuilder().build())
            .setPemCertificate("pemCertificate153491807")
            .setCertificateDescription(CertificateDescription.newBuilder().build())
            .addAllPemCertificateChain(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    CertificateName name =
        CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]");

    Certificate actualResponse = client.revokeCertificate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void revokeCertificateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CertificateName name =
          CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]");
      client.revokeCertificate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void revokeCertificateTest2() throws Exception {
    Certificate expectedResponse =
        Certificate.newBuilder()
            .setName(
                CertificateName.of(
                        "[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]")
                    .toString())
            .setLifetime(Duration.newBuilder().build())
            .setRevocationDetails(Certificate.RevocationDetails.newBuilder().build())
            .setPemCertificate("pemCertificate153491807")
            .setCertificateDescription(CertificateDescription.newBuilder().build())
            .addAllPemCertificateChain(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8612/locations/location-8612/certificateAuthorities/certificateAuthoritie-8612/certificates/certificate-8612";

    Certificate actualResponse = client.revokeCertificate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void revokeCertificateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8612/locations/location-8612/certificateAuthorities/certificateAuthoritie-8612/certificates/certificate-8612";
      client.revokeCertificate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCertificateTest() throws Exception {
    Certificate expectedResponse =
        Certificate.newBuilder()
            .setName(
                CertificateName.of(
                        "[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]")
                    .toString())
            .setLifetime(Duration.newBuilder().build())
            .setRevocationDetails(Certificate.RevocationDetails.newBuilder().build())
            .setPemCertificate("pemCertificate153491807")
            .setCertificateDescription(CertificateDescription.newBuilder().build())
            .addAllPemCertificateChain(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    Certificate certificate =
        Certificate.newBuilder()
            .setName(
                CertificateName.of(
                        "[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]")
                    .toString())
            .setLifetime(Duration.newBuilder().build())
            .setRevocationDetails(Certificate.RevocationDetails.newBuilder().build())
            .setPemCertificate("pemCertificate153491807")
            .setCertificateDescription(CertificateDescription.newBuilder().build())
            .addAllPemCertificateChain(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Certificate actualResponse = client.updateCertificate(certificate, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateCertificateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Certificate certificate =
          Certificate.newBuilder()
              .setName(
                  CertificateName.of(
                          "[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE]")
                      .toString())
              .setLifetime(Duration.newBuilder().build())
              .setRevocationDetails(Certificate.RevocationDetails.newBuilder().build())
              .setPemCertificate("pemCertificate153491807")
              .setCertificateDescription(CertificateDescription.newBuilder().build())
              .addAllPemCertificateChain(new ArrayList<String>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCertificate(certificate, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void activateCertificateAuthorityTest() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder()
            .setName(
                CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setCertificatePolicy(
                CertificateAuthority.CertificateAuthorityPolicy.newBuilder().build())
            .setIssuingOptions(CertificateAuthority.IssuingOptions.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("activateCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CertificateAuthorityName name =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

    CertificateAuthority actualResponse = client.activateCertificateAuthorityAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void activateCertificateAuthorityExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CertificateAuthorityName name =
          CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
      client.activateCertificateAuthorityAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void activateCertificateAuthorityTest2() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder()
            .setName(
                CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setCertificatePolicy(
                CertificateAuthority.CertificateAuthorityPolicy.newBuilder().build())
            .setIssuingOptions(CertificateAuthority.IssuingOptions.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("activateCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-5194/locations/location-5194/certificateAuthorities/certificateAuthoritie-5194";

    CertificateAuthority actualResponse = client.activateCertificateAuthorityAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void activateCertificateAuthorityExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5194/locations/location-5194/certificateAuthorities/certificateAuthoritie-5194";
      client.activateCertificateAuthorityAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createCertificateAuthorityTest() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder()
            .setName(
                CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setCertificatePolicy(
                CertificateAuthority.CertificateAuthorityPolicy.newBuilder().build())
            .setIssuingOptions(CertificateAuthority.IssuingOptions.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    CertificateAuthority certificateAuthority = CertificateAuthority.newBuilder().build();
    String certificateAuthorityId = "certificateAuthorityId-1652580953";

    CertificateAuthority actualResponse =
        client
            .createCertificateAuthorityAsync(parent, certificateAuthority, certificateAuthorityId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createCertificateAuthorityExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      CertificateAuthority certificateAuthority = CertificateAuthority.newBuilder().build();
      String certificateAuthorityId = "certificateAuthorityId-1652580953";
      client
          .createCertificateAuthorityAsync(parent, certificateAuthority, certificateAuthorityId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createCertificateAuthorityTest2() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder()
            .setName(
                CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setCertificatePolicy(
                CertificateAuthority.CertificateAuthorityPolicy.newBuilder().build())
            .setIssuingOptions(CertificateAuthority.IssuingOptions.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    CertificateAuthority certificateAuthority = CertificateAuthority.newBuilder().build();
    String certificateAuthorityId = "certificateAuthorityId-1652580953";

    CertificateAuthority actualResponse =
        client
            .createCertificateAuthorityAsync(parent, certificateAuthority, certificateAuthorityId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createCertificateAuthorityExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      CertificateAuthority certificateAuthority = CertificateAuthority.newBuilder().build();
      String certificateAuthorityId = "certificateAuthorityId-1652580953";
      client
          .createCertificateAuthorityAsync(parent, certificateAuthority, certificateAuthorityId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void disableCertificateAuthorityTest() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder()
            .setName(
                CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setCertificatePolicy(
                CertificateAuthority.CertificateAuthorityPolicy.newBuilder().build())
            .setIssuingOptions(CertificateAuthority.IssuingOptions.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("disableCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CertificateAuthorityName name =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

    CertificateAuthority actualResponse = client.disableCertificateAuthorityAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void disableCertificateAuthorityExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CertificateAuthorityName name =
          CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
      client.disableCertificateAuthorityAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void disableCertificateAuthorityTest2() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder()
            .setName(
                CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setCertificatePolicy(
                CertificateAuthority.CertificateAuthorityPolicy.newBuilder().build())
            .setIssuingOptions(CertificateAuthority.IssuingOptions.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("disableCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-5194/locations/location-5194/certificateAuthorities/certificateAuthoritie-5194";

    CertificateAuthority actualResponse = client.disableCertificateAuthorityAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void disableCertificateAuthorityExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5194/locations/location-5194/certificateAuthorities/certificateAuthoritie-5194";
      client.disableCertificateAuthorityAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void enableCertificateAuthorityTest() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder()
            .setName(
                CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setCertificatePolicy(
                CertificateAuthority.CertificateAuthorityPolicy.newBuilder().build())
            .setIssuingOptions(CertificateAuthority.IssuingOptions.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("enableCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CertificateAuthorityName name =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

    CertificateAuthority actualResponse = client.enableCertificateAuthorityAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void enableCertificateAuthorityExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CertificateAuthorityName name =
          CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
      client.enableCertificateAuthorityAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void enableCertificateAuthorityTest2() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder()
            .setName(
                CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setCertificatePolicy(
                CertificateAuthority.CertificateAuthorityPolicy.newBuilder().build())
            .setIssuingOptions(CertificateAuthority.IssuingOptions.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("enableCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-5194/locations/location-5194/certificateAuthorities/certificateAuthoritie-5194";

    CertificateAuthority actualResponse = client.enableCertificateAuthorityAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void enableCertificateAuthorityExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5194/locations/location-5194/certificateAuthorities/certificateAuthoritie-5194";
      client.enableCertificateAuthorityAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void fetchCertificateAuthorityCsrTest() throws Exception {
    FetchCertificateAuthorityCsrResponse expectedResponse =
        FetchCertificateAuthorityCsrResponse.newBuilder().setPemCsr("pemCsr-991911478").build();
    mockService.addResponse(expectedResponse);

    CertificateAuthorityName name =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

    FetchCertificateAuthorityCsrResponse actualResponse = client.fetchCertificateAuthorityCsr(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void fetchCertificateAuthorityCsrExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CertificateAuthorityName name =
          CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
      client.fetchCertificateAuthorityCsr(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchCertificateAuthorityCsrTest2() throws Exception {
    FetchCertificateAuthorityCsrResponse expectedResponse =
        FetchCertificateAuthorityCsrResponse.newBuilder().setPemCsr("pemCsr-991911478").build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5194/locations/location-5194/certificateAuthorities/certificateAuthoritie-5194";

    FetchCertificateAuthorityCsrResponse actualResponse = client.fetchCertificateAuthorityCsr(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void fetchCertificateAuthorityCsrExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5194/locations/location-5194/certificateAuthorities/certificateAuthoritie-5194";
      client.fetchCertificateAuthorityCsr(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCertificateAuthorityTest() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder()
            .setName(
                CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setCertificatePolicy(
                CertificateAuthority.CertificateAuthorityPolicy.newBuilder().build())
            .setIssuingOptions(CertificateAuthority.IssuingOptions.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    CertificateAuthorityName name =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

    CertificateAuthority actualResponse = client.getCertificateAuthority(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getCertificateAuthorityExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CertificateAuthorityName name =
          CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
      client.getCertificateAuthority(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCertificateAuthorityTest2() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder()
            .setName(
                CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setCertificatePolicy(
                CertificateAuthority.CertificateAuthorityPolicy.newBuilder().build())
            .setIssuingOptions(CertificateAuthority.IssuingOptions.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5194/locations/location-5194/certificateAuthorities/certificateAuthoritie-5194";

    CertificateAuthority actualResponse = client.getCertificateAuthority(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getCertificateAuthorityExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5194/locations/location-5194/certificateAuthorities/certificateAuthoritie-5194";
      client.getCertificateAuthority(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCertificateAuthoritiesTest() throws Exception {
    CertificateAuthority responsesElement = CertificateAuthority.newBuilder().build();
    ListCertificateAuthoritiesResponse expectedResponse =
        ListCertificateAuthoritiesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCertificateAuthorities(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCertificateAuthoritiesPagedResponse pagedListResponse =
        client.listCertificateAuthorities(parent);

    List<CertificateAuthority> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCertificateAuthoritiesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listCertificateAuthoritiesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCertificateAuthorities(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCertificateAuthoritiesTest2() throws Exception {
    CertificateAuthority responsesElement = CertificateAuthority.newBuilder().build();
    ListCertificateAuthoritiesResponse expectedResponse =
        ListCertificateAuthoritiesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCertificateAuthorities(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListCertificateAuthoritiesPagedResponse pagedListResponse =
        client.listCertificateAuthorities(parent);

    List<CertificateAuthority> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCertificateAuthoritiesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listCertificateAuthoritiesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listCertificateAuthorities(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void restoreCertificateAuthorityTest() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder()
            .setName(
                CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setCertificatePolicy(
                CertificateAuthority.CertificateAuthorityPolicy.newBuilder().build())
            .setIssuingOptions(CertificateAuthority.IssuingOptions.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CertificateAuthorityName name =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

    CertificateAuthority actualResponse = client.restoreCertificateAuthorityAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void restoreCertificateAuthorityExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CertificateAuthorityName name =
          CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
      client.restoreCertificateAuthorityAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void restoreCertificateAuthorityTest2() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder()
            .setName(
                CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setCertificatePolicy(
                CertificateAuthority.CertificateAuthorityPolicy.newBuilder().build())
            .setIssuingOptions(CertificateAuthority.IssuingOptions.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restoreCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-5194/locations/location-5194/certificateAuthorities/certificateAuthoritie-5194";

    CertificateAuthority actualResponse = client.restoreCertificateAuthorityAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void restoreCertificateAuthorityExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5194/locations/location-5194/certificateAuthorities/certificateAuthoritie-5194";
      client.restoreCertificateAuthorityAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void scheduleDeleteCertificateAuthorityTest() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder()
            .setName(
                CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setCertificatePolicy(
                CertificateAuthority.CertificateAuthorityPolicy.newBuilder().build())
            .setIssuingOptions(CertificateAuthority.IssuingOptions.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("scheduleDeleteCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CertificateAuthorityName name =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

    CertificateAuthority actualResponse =
        client.scheduleDeleteCertificateAuthorityAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void scheduleDeleteCertificateAuthorityExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CertificateAuthorityName name =
          CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
      client.scheduleDeleteCertificateAuthorityAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void scheduleDeleteCertificateAuthorityTest2() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder()
            .setName(
                CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setCertificatePolicy(
                CertificateAuthority.CertificateAuthorityPolicy.newBuilder().build())
            .setIssuingOptions(CertificateAuthority.IssuingOptions.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("scheduleDeleteCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-5194/locations/location-5194/certificateAuthorities/certificateAuthoritie-5194";

    CertificateAuthority actualResponse =
        client.scheduleDeleteCertificateAuthorityAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void scheduleDeleteCertificateAuthorityExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5194/locations/location-5194/certificateAuthorities/certificateAuthoritie-5194";
      client.scheduleDeleteCertificateAuthorityAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateCertificateAuthorityTest() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder()
            .setName(
                CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setCertificatePolicy(
                CertificateAuthority.CertificateAuthorityPolicy.newBuilder().build())
            .setIssuingOptions(CertificateAuthority.IssuingOptions.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CertificateAuthority certificateAuthority =
        CertificateAuthority.newBuilder()
            .setName(
                CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setCertificatePolicy(
                CertificateAuthority.CertificateAuthorityPolicy.newBuilder().build())
            .setIssuingOptions(CertificateAuthority.IssuingOptions.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CertificateAuthority actualResponse =
        client.updateCertificateAuthorityAsync(certificateAuthority, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateCertificateAuthorityExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CertificateAuthority certificateAuthority =
          CertificateAuthority.newBuilder()
              .setName(
                  CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
                      .toString())
              .setConfig(CertificateConfig.newBuilder().build())
              .setLifetime(Duration.newBuilder().build())
              .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
              .setCertificatePolicy(
                  CertificateAuthority.CertificateAuthorityPolicy.newBuilder().build())
              .setIssuingOptions(CertificateAuthority.IssuingOptions.newBuilder().build())
              .setSubordinateConfig(SubordinateConfig.newBuilder().build())
              .addAllPemCaCertificates(new ArrayList<String>())
              .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
              .setGcsBucket("gcsBucket239654881")
              .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDeleteTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCertificateAuthorityAsync(certificateAuthority, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getCertificateRevocationListTest() throws Exception {
    CertificateRevocationList expectedResponse =
        CertificateRevocationList.newBuilder()
            .setName(
                CertificateRevocationListName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[CERTIFICATE_AUTHORITY]",
                        "[CERTIFICATE_REVOCATION_LIST]")
                    .toString())
            .setSequenceNumber(-1309190777)
            .addAllRevokedCertificates(
                new ArrayList<CertificateRevocationList.RevokedCertificate>())
            .setPemCrl("pemCrl-991911515")
            .setAccessUrl("accessUrl-2115048085")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    CertificateRevocationListName name =
        CertificateRevocationListName.of(
            "[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]", "[CERTIFICATE_REVOCATION_LIST]");

    CertificateRevocationList actualResponse = client.getCertificateRevocationList(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getCertificateRevocationListExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
      // Expected exception.
    }
  }

  @Test
  public void getCertificateRevocationListTest2() throws Exception {
    CertificateRevocationList expectedResponse =
        CertificateRevocationList.newBuilder()
            .setName(
                CertificateRevocationListName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[CERTIFICATE_AUTHORITY]",
                        "[CERTIFICATE_REVOCATION_LIST]")
                    .toString())
            .setSequenceNumber(-1309190777)
            .addAllRevokedCertificates(
                new ArrayList<CertificateRevocationList.RevokedCertificate>())
            .setPemCrl("pemCrl-991911515")
            .setAccessUrl("accessUrl-2115048085")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-8416/locations/location-8416/certificateAuthorities/certificateAuthoritie-8416/certificateRevocationLists/certificateRevocationList-8416";

    CertificateRevocationList actualResponse = client.getCertificateRevocationList(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getCertificateRevocationListExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8416/locations/location-8416/certificateAuthorities/certificateAuthoritie-8416/certificateRevocationLists/certificateRevocationList-8416";
      client.getCertificateRevocationList(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCertificateRevocationListsTest() throws Exception {
    CertificateRevocationList responsesElement = CertificateRevocationList.newBuilder().build();
    ListCertificateRevocationListsResponse expectedResponse =
        ListCertificateRevocationListsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCertificateRevocationLists(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CertificateAuthorityName parent =
        CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");

    ListCertificateRevocationListsPagedResponse pagedListResponse =
        client.listCertificateRevocationLists(parent);

    List<CertificateRevocationList> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getCertificateRevocationListsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listCertificateRevocationListsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CertificateAuthorityName parent =
          CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]");
      client.listCertificateRevocationLists(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCertificateRevocationListsTest2() throws Exception {
    CertificateRevocationList responsesElement = CertificateRevocationList.newBuilder().build();
    ListCertificateRevocationListsResponse expectedResponse =
        ListCertificateRevocationListsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCertificateRevocationLists(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-2053/locations/location-2053/certificateAuthorities/certificateAuthoritie-2053";

    ListCertificateRevocationListsPagedResponse pagedListResponse =
        client.listCertificateRevocationLists(parent);

    List<CertificateRevocationList> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getCertificateRevocationListsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listCertificateRevocationListsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-2053/locations/location-2053/certificateAuthorities/certificateAuthoritie-2053";
      client.listCertificateRevocationLists(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCertificateRevocationListTest() throws Exception {
    CertificateRevocationList expectedResponse =
        CertificateRevocationList.newBuilder()
            .setName(
                CertificateRevocationListName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[CERTIFICATE_AUTHORITY]",
                        "[CERTIFICATE_REVOCATION_LIST]")
                    .toString())
            .setSequenceNumber(-1309190777)
            .addAllRevokedCertificates(
                new ArrayList<CertificateRevocationList.RevokedCertificate>())
            .setPemCrl("pemCrl-991911515")
            .setAccessUrl("accessUrl-2115048085")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateCertificateRevocationListTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CertificateRevocationList certificateRevocationList =
        CertificateRevocationList.newBuilder()
            .setName(
                CertificateRevocationListName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[CERTIFICATE_AUTHORITY]",
                        "[CERTIFICATE_REVOCATION_LIST]")
                    .toString())
            .setSequenceNumber(-1309190777)
            .addAllRevokedCertificates(
                new ArrayList<CertificateRevocationList.RevokedCertificate>())
            .setPemCrl("pemCrl-991911515")
            .setAccessUrl("accessUrl-2115048085")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CertificateRevocationList actualResponse =
        client.updateCertificateRevocationListAsync(certificateRevocationList, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateCertificateRevocationListExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CertificateRevocationList certificateRevocationList =
          CertificateRevocationList.newBuilder()
              .setName(
                  CertificateRevocationListName.of(
                          "[PROJECT]",
                          "[LOCATION]",
                          "[CERTIFICATE_AUTHORITY]",
                          "[CERTIFICATE_REVOCATION_LIST]")
                      .toString())
              .setSequenceNumber(-1309190777)
              .addAllRevokedCertificates(
                  new ArrayList<CertificateRevocationList.RevokedCertificate>())
              .setPemCrl("pemCrl-991911515")
              .setAccessUrl("accessUrl-2115048085")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCertificateRevocationListAsync(certificateRevocationList, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getReusableConfigTest() throws Exception {
    ReusableConfig expectedResponse =
        ReusableConfig.newBuilder()
            .setName(
                ReusableConfigName.of("[PROJECT]", "[LOCATION]", "[REUSABLE_CONFIG]").toString())
            .setValues(ReusableConfigValues.newBuilder().build())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    ReusableConfigName name = ReusableConfigName.of("[PROJECT]", "[LOCATION]", "[REUSABLE_CONFIG]");

    ReusableConfig actualResponse = client.getReusableConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getReusableConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReusableConfigName name =
          ReusableConfigName.of("[PROJECT]", "[LOCATION]", "[REUSABLE_CONFIG]");
      client.getReusableConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReusableConfigTest2() throws Exception {
    ReusableConfig expectedResponse =
        ReusableConfig.newBuilder()
            .setName(
                ReusableConfigName.of("[PROJECT]", "[LOCATION]", "[REUSABLE_CONFIG]").toString())
            .setValues(ReusableConfigValues.newBuilder().build())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5380/locations/location-5380/reusableConfigs/reusableConfig-5380";

    ReusableConfig actualResponse = client.getReusableConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getReusableConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5380/locations/location-5380/reusableConfigs/reusableConfig-5380";
      client.getReusableConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReusableConfigsTest() throws Exception {
    ReusableConfig responsesElement = ReusableConfig.newBuilder().build();
    ListReusableConfigsResponse expectedResponse =
        ListReusableConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReusableConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListReusableConfigsPagedResponse pagedListResponse = client.listReusableConfigs(parent);

    List<ReusableConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReusableConfigsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listReusableConfigsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listReusableConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReusableConfigsTest2() throws Exception {
    ReusableConfig responsesElement = ReusableConfig.newBuilder().build();
    ListReusableConfigsResponse expectedResponse =
        ListReusableConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReusableConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListReusableConfigsPagedResponse pagedListResponse = client.listReusableConfigs(parent);

    List<ReusableConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReusableConfigsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listReusableConfigsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listReusableConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
