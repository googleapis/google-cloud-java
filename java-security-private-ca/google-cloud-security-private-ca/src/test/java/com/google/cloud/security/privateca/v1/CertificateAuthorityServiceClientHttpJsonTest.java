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

package com.google.cloud.security.privateca.v1;

import static com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient.ListCaPoolsPagedResponse;
import static com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient.ListCertificateAuthoritiesPagedResponse;
import static com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient.ListCertificateRevocationListsPagedResponse;
import static com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient.ListCertificateTemplatesPagedResponse;
import static com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient.ListCertificatesPagedResponse;
import static com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.security.privateca.v1.stub.HttpJsonCertificateAuthorityServiceStub;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
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
                CertificateName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE]")
                    .toString())
            .setIssuerCertificateAuthority(
                CertificateAuthorityName.of(
                        "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setLifetime(Duration.newBuilder().build())
            .setCertificateTemplate(
                CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]")
                    .toString())
            .setSubjectMode(SubjectRequestMode.forNumber(0))
            .setRevocationDetails(Certificate.RevocationDetails.newBuilder().build())
            .setPemCertificate("pemCertificate153491807")
            .setCertificateDescription(CertificateDescription.newBuilder().build())
            .addAllPemCertificateChain(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    CaPoolName parent = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]");
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
      CaPoolName parent = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]");
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
                CertificateName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE]")
                    .toString())
            .setIssuerCertificateAuthority(
                CertificateAuthorityName.of(
                        "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setLifetime(Duration.newBuilder().build())
            .setCertificateTemplate(
                CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]")
                    .toString())
            .setSubjectMode(SubjectRequestMode.forNumber(0))
            .setRevocationDetails(Certificate.RevocationDetails.newBuilder().build())
            .setPemCertificate("pemCertificate153491807")
            .setCertificateDescription(CertificateDescription.newBuilder().build())
            .addAllPemCertificateChain(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-6494/locations/location-6494/caPools/caPool-6494";
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
      String parent = "projects/project-6494/locations/location-6494/caPools/caPool-6494";
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
                CertificateName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE]")
                    .toString())
            .setIssuerCertificateAuthority(
                CertificateAuthorityName.of(
                        "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setLifetime(Duration.newBuilder().build())
            .setCertificateTemplate(
                CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]")
                    .toString())
            .setSubjectMode(SubjectRequestMode.forNumber(0))
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
        CertificateName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE]");

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
          CertificateName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE]");
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
                CertificateName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE]")
                    .toString())
            .setIssuerCertificateAuthority(
                CertificateAuthorityName.of(
                        "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setLifetime(Duration.newBuilder().build())
            .setCertificateTemplate(
                CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]")
                    .toString())
            .setSubjectMode(SubjectRequestMode.forNumber(0))
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
        "projects/project-1351/locations/location-1351/caPools/caPool-1351/certificates/certificate-1351";

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
          "projects/project-1351/locations/location-1351/caPools/caPool-1351/certificates/certificate-1351";
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

    CaPoolName parent = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]");

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
      CaPoolName parent = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]");
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

    String parent = "projects/project-6494/locations/location-6494/caPools/caPool-6494";

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
      String parent = "projects/project-6494/locations/location-6494/caPools/caPool-6494";
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
                CertificateName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE]")
                    .toString())
            .setIssuerCertificateAuthority(
                CertificateAuthorityName.of(
                        "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setLifetime(Duration.newBuilder().build())
            .setCertificateTemplate(
                CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]")
                    .toString())
            .setSubjectMode(SubjectRequestMode.forNumber(0))
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
        CertificateName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE]");

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
          CertificateName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE]");
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
                CertificateName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE]")
                    .toString())
            .setIssuerCertificateAuthority(
                CertificateAuthorityName.of(
                        "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setLifetime(Duration.newBuilder().build())
            .setCertificateTemplate(
                CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]")
                    .toString())
            .setSubjectMode(SubjectRequestMode.forNumber(0))
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
        "projects/project-1351/locations/location-1351/caPools/caPool-1351/certificates/certificate-1351";

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
          "projects/project-1351/locations/location-1351/caPools/caPool-1351/certificates/certificate-1351";
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
                CertificateName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE]")
                    .toString())
            .setIssuerCertificateAuthority(
                CertificateAuthorityName.of(
                        "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setLifetime(Duration.newBuilder().build())
            .setCertificateTemplate(
                CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]")
                    .toString())
            .setSubjectMode(SubjectRequestMode.forNumber(0))
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
                CertificateName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE]")
                    .toString())
            .setIssuerCertificateAuthority(
                CertificateAuthorityName.of(
                        "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setLifetime(Duration.newBuilder().build())
            .setCertificateTemplate(
                CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]")
                    .toString())
            .setSubjectMode(SubjectRequestMode.forNumber(0))
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
                  CertificateName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE]")
                      .toString())
              .setIssuerCertificateAuthority(
                  CertificateAuthorityName.of(
                          "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                      .toString())
              .setLifetime(Duration.newBuilder().build())
              .setCertificateTemplate(
                  CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]")
                      .toString())
              .setSubjectMode(SubjectRequestMode.forNumber(0))
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
                CertificateAuthorityName.of(
                        "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
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
        CertificateAuthorityName.of(
            "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]");

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
          CertificateAuthorityName.of(
              "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]");
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
                CertificateAuthorityName.of(
                        "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
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
        "projects/project-6987/locations/location-6987/caPools/caPool-6987/certificateAuthorities/certificateAuthoritie-6987";

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
          "projects/project-6987/locations/location-6987/caPools/caPool-6987/certificateAuthorities/certificateAuthoritie-6987";
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
                CertificateAuthorityName.of(
                        "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CaPoolName parent = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]");
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
      CaPoolName parent = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]");
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
                CertificateAuthorityName.of(
                        "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-6494/locations/location-6494/caPools/caPool-6494";
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
      String parent = "projects/project-6494/locations/location-6494/caPools/caPool-6494";
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
                CertificateAuthorityName.of(
                        "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
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
        CertificateAuthorityName.of(
            "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]");

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
          CertificateAuthorityName.of(
              "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]");
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
                CertificateAuthorityName.of(
                        "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
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
        "projects/project-6987/locations/location-6987/caPools/caPool-6987/certificateAuthorities/certificateAuthoritie-6987";

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
          "projects/project-6987/locations/location-6987/caPools/caPool-6987/certificateAuthorities/certificateAuthoritie-6987";
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
                CertificateAuthorityName.of(
                        "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
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
        CertificateAuthorityName.of(
            "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]");

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
          CertificateAuthorityName.of(
              "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]");
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
                CertificateAuthorityName.of(
                        "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
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
        "projects/project-6987/locations/location-6987/caPools/caPool-6987/certificateAuthorities/certificateAuthoritie-6987";

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
          "projects/project-6987/locations/location-6987/caPools/caPool-6987/certificateAuthorities/certificateAuthoritie-6987";
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
        CertificateAuthorityName.of(
            "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]");

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
          CertificateAuthorityName.of(
              "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]");
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
        "projects/project-6987/locations/location-6987/caPools/caPool-6987/certificateAuthorities/certificateAuthoritie-6987";

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
          "projects/project-6987/locations/location-6987/caPools/caPool-6987/certificateAuthorities/certificateAuthoritie-6987";
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
                CertificateAuthorityName.of(
                        "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    CertificateAuthorityName name =
        CertificateAuthorityName.of(
            "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]");

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
          CertificateAuthorityName.of(
              "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]");
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
                CertificateAuthorityName.of(
                        "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6987/locations/location-6987/caPools/caPool-6987/certificateAuthorities/certificateAuthoritie-6987";

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
          "projects/project-6987/locations/location-6987/caPools/caPool-6987/certificateAuthorities/certificateAuthoritie-6987";
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

    CaPoolName parent = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]");

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
      CaPoolName parent = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]");
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

    String parent = "projects/project-6494/locations/location-6494/caPools/caPool-6494";

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
      String parent = "projects/project-6494/locations/location-6494/caPools/caPool-6494";
      client.listCertificateAuthorities(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void undeleteCertificateAuthorityTest() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder()
            .setName(
                CertificateAuthorityName.of(
                        "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeleteCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CertificateAuthorityName name =
        CertificateAuthorityName.of(
            "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]");

    CertificateAuthority actualResponse = client.undeleteCertificateAuthorityAsync(name).get();
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
  public void undeleteCertificateAuthorityExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CertificateAuthorityName name =
          CertificateAuthorityName.of(
              "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]");
      client.undeleteCertificateAuthorityAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void undeleteCertificateAuthorityTest2() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder()
            .setName(
                CertificateAuthorityName.of(
                        "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeleteCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-6987/locations/location-6987/caPools/caPool-6987/certificateAuthorities/certificateAuthoritie-6987";

    CertificateAuthority actualResponse = client.undeleteCertificateAuthorityAsync(name).get();
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
  public void undeleteCertificateAuthorityExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6987/locations/location-6987/caPools/caPool-6987/certificateAuthorities/certificateAuthoritie-6987";
      client.undeleteCertificateAuthorityAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteCertificateAuthorityTest() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder()
            .setName(
                CertificateAuthorityName.of(
                        "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CertificateAuthorityName name =
        CertificateAuthorityName.of(
            "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]");

    CertificateAuthority actualResponse = client.deleteCertificateAuthorityAsync(name).get();
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
  public void deleteCertificateAuthorityExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CertificateAuthorityName name =
          CertificateAuthorityName.of(
              "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]");
      client.deleteCertificateAuthorityAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteCertificateAuthorityTest2() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder()
            .setName(
                CertificateAuthorityName.of(
                        "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCertificateAuthorityTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-6987/locations/location-6987/caPools/caPool-6987/certificateAuthorities/certificateAuthoritie-6987";

    CertificateAuthority actualResponse = client.deleteCertificateAuthorityAsync(name).get();
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
  public void deleteCertificateAuthorityExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6987/locations/location-6987/caPools/caPool-6987/certificateAuthorities/certificateAuthoritie-6987";
      client.deleteCertificateAuthorityAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateCertificateAuthorityTest() throws Exception {
    CertificateAuthority expectedResponse =
        CertificateAuthority.newBuilder()
            .setName(
                CertificateAuthorityName.of(
                        "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
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
                CertificateAuthorityName.of(
                        "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                    .toString())
            .setConfig(CertificateConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
            .setSubordinateConfig(SubordinateConfig.newBuilder().build())
            .addAllPemCaCertificates(new ArrayList<String>())
            .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
            .setGcsBucket("gcsBucket239654881")
            .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
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
                  CertificateAuthorityName.of(
                          "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]")
                      .toString())
              .setConfig(CertificateConfig.newBuilder().build())
              .setLifetime(Duration.newBuilder().build())
              .setKeySpec(CertificateAuthority.KeyVersionSpec.newBuilder().build())
              .setSubordinateConfig(SubordinateConfig.newBuilder().build())
              .addAllPemCaCertificates(new ArrayList<String>())
              .addAllCaCertificateDescriptions(new ArrayList<CertificateDescription>())
              .setGcsBucket("gcsBucket239654881")
              .setAccessUrls(CertificateAuthority.AccessUrls.newBuilder().build())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDeleteTime(Timestamp.newBuilder().build())
              .setExpireTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCertificateAuthorityAsync(certificateAuthority, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createCaPoolTest() throws Exception {
    CaPool expectedResponse =
        CaPool.newBuilder()
            .setName(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
            .setIssuancePolicy(CaPool.IssuancePolicy.newBuilder().build())
            .setPublishingOptions(CaPool.PublishingOptions.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCaPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    CaPool caPool = CaPool.newBuilder().build();
    String caPoolId = "caPoolId-970668971";

    CaPool actualResponse = client.createCaPoolAsync(parent, caPool, caPoolId).get();
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
  public void createCaPoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      CaPool caPool = CaPool.newBuilder().build();
      String caPoolId = "caPoolId-970668971";
      client.createCaPoolAsync(parent, caPool, caPoolId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createCaPoolTest2() throws Exception {
    CaPool expectedResponse =
        CaPool.newBuilder()
            .setName(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
            .setIssuancePolicy(CaPool.IssuancePolicy.newBuilder().build())
            .setPublishingOptions(CaPool.PublishingOptions.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCaPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    CaPool caPool = CaPool.newBuilder().build();
    String caPoolId = "caPoolId-970668971";

    CaPool actualResponse = client.createCaPoolAsync(parent, caPool, caPoolId).get();
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
  public void createCaPoolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      CaPool caPool = CaPool.newBuilder().build();
      String caPoolId = "caPoolId-970668971";
      client.createCaPoolAsync(parent, caPool, caPoolId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateCaPoolTest() throws Exception {
    CaPool expectedResponse =
        CaPool.newBuilder()
            .setName(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
            .setIssuancePolicy(CaPool.IssuancePolicy.newBuilder().build())
            .setPublishingOptions(CaPool.PublishingOptions.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateCaPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CaPool caPool =
        CaPool.newBuilder()
            .setName(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
            .setIssuancePolicy(CaPool.IssuancePolicy.newBuilder().build())
            .setPublishingOptions(CaPool.PublishingOptions.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CaPool actualResponse = client.updateCaPoolAsync(caPool, updateMask).get();
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
  public void updateCaPoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CaPool caPool =
          CaPool.newBuilder()
              .setName(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
              .setIssuancePolicy(CaPool.IssuancePolicy.newBuilder().build())
              .setPublishingOptions(CaPool.PublishingOptions.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCaPoolAsync(caPool, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getCaPoolTest() throws Exception {
    CaPool expectedResponse =
        CaPool.newBuilder()
            .setName(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
            .setIssuancePolicy(CaPool.IssuancePolicy.newBuilder().build())
            .setPublishingOptions(CaPool.PublishingOptions.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    CaPoolName name = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]");

    CaPool actualResponse = client.getCaPool(name);
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
  public void getCaPoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CaPoolName name = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]");
      client.getCaPool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCaPoolTest2() throws Exception {
    CaPool expectedResponse =
        CaPool.newBuilder()
            .setName(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
            .setIssuancePolicy(CaPool.IssuancePolicy.newBuilder().build())
            .setPublishingOptions(CaPool.PublishingOptions.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2703/locations/location-2703/caPools/caPool-2703";

    CaPool actualResponse = client.getCaPool(name);
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
  public void getCaPoolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2703/locations/location-2703/caPools/caPool-2703";
      client.getCaPool(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCaPoolsTest() throws Exception {
    CaPool responsesElement = CaPool.newBuilder().build();
    ListCaPoolsResponse expectedResponse =
        ListCaPoolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCaPools(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCaPoolsPagedResponse pagedListResponse = client.listCaPools(parent);

    List<CaPool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCaPoolsList().get(0), resources.get(0));

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
  public void listCaPoolsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCaPools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCaPoolsTest2() throws Exception {
    CaPool responsesElement = CaPool.newBuilder().build();
    ListCaPoolsResponse expectedResponse =
        ListCaPoolsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCaPools(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListCaPoolsPagedResponse pagedListResponse = client.listCaPools(parent);

    List<CaPool> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCaPoolsList().get(0), resources.get(0));

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
  public void listCaPoolsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listCaPools(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCaPoolTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCaPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CaPoolName name = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]");

    client.deleteCaPoolAsync(name).get();

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
  public void deleteCaPoolExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CaPoolName name = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]");
      client.deleteCaPoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteCaPoolTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCaPoolTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-2703/locations/location-2703/caPools/caPool-2703";

    client.deleteCaPoolAsync(name).get();

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
  public void deleteCaPoolExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2703/locations/location-2703/caPools/caPool-2703";
      client.deleteCaPoolAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void fetchCaCertsTest() throws Exception {
    FetchCaCertsResponse expectedResponse =
        FetchCaCertsResponse.newBuilder()
            .addAllCaCerts(new ArrayList<FetchCaCertsResponse.CertChain>())
            .build();
    mockService.addResponse(expectedResponse);

    CaPoolName caPool = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]");

    FetchCaCertsResponse actualResponse = client.fetchCaCerts(caPool);
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
  public void fetchCaCertsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CaPoolName caPool = CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]");
      client.fetchCaCerts(caPool);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchCaCertsTest2() throws Exception {
    FetchCaCertsResponse expectedResponse =
        FetchCaCertsResponse.newBuilder()
            .addAllCaCerts(new ArrayList<FetchCaCertsResponse.CertChain>())
            .build();
    mockService.addResponse(expectedResponse);

    String caPool = "projects/project-9774/locations/location-9774/caPools/caPool-9774";

    FetchCaCertsResponse actualResponse = client.fetchCaCerts(caPool);
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
  public void fetchCaCertsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String caPool = "projects/project-9774/locations/location-9774/caPools/caPool-9774";
      client.fetchCaCerts(caPool);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
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
                        "[CA_POOL]",
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
            .setRevisionId("revisionId-1507445162")
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    CertificateRevocationListName name =
        CertificateRevocationListName.of(
            "[PROJECT]",
            "[LOCATION]",
            "[CA_POOL]",
            "[CERTIFICATE_AUTHORITY]",
            "[CERTIFICATE_REVOCATION_LIST]");

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
              "[CA_POOL]",
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
                        "[CA_POOL]",
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
            .setRevisionId("revisionId-1507445162")
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4203/locations/location-4203/caPools/caPool-4203/certificateAuthorities/certificateAuthoritie-4203/certificateRevocationLists/certificateRevocationList-4203";

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
          "projects/project-4203/locations/location-4203/caPools/caPool-4203/certificateAuthorities/certificateAuthoritie-4203/certificateRevocationLists/certificateRevocationList-4203";
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
        CertificateAuthorityName.of(
            "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]");

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
          CertificateAuthorityName.of(
              "[PROJECT]", "[LOCATION]", "[CA_POOL]", "[CERTIFICATE_AUTHORITY]");
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
        "projects/project-6570/locations/location-6570/caPools/caPool-6570/certificateAuthorities/certificateAuthoritie-6570";

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
          "projects/project-6570/locations/location-6570/caPools/caPool-6570/certificateAuthorities/certificateAuthoritie-6570";
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
                        "[CA_POOL]",
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
            .setRevisionId("revisionId-1507445162")
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
                        "[CA_POOL]",
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
            .setRevisionId("revisionId-1507445162")
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
                          "[CA_POOL]",
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
              .setRevisionId("revisionId-1507445162")
              .putAllLabels(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCertificateRevocationListAsync(certificateRevocationList, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createCertificateTemplateTest() throws Exception {
    CertificateTemplate expectedResponse =
        CertificateTemplate.newBuilder()
            .setName(
                CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]")
                    .toString())
            .setPredefinedValues(X509Parameters.newBuilder().build())
            .setIdentityConstraints(CertificateIdentityConstraints.newBuilder().build())
            .setPassthroughExtensions(CertificateExtensionConstraints.newBuilder().build())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCertificateTemplateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    CertificateTemplate certificateTemplate = CertificateTemplate.newBuilder().build();
    String certificateTemplateId = "certificateTemplateId1920134188";

    CertificateTemplate actualResponse =
        client
            .createCertificateTemplateAsync(parent, certificateTemplate, certificateTemplateId)
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
  public void createCertificateTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      CertificateTemplate certificateTemplate = CertificateTemplate.newBuilder().build();
      String certificateTemplateId = "certificateTemplateId1920134188";
      client
          .createCertificateTemplateAsync(parent, certificateTemplate, certificateTemplateId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createCertificateTemplateTest2() throws Exception {
    CertificateTemplate expectedResponse =
        CertificateTemplate.newBuilder()
            .setName(
                CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]")
                    .toString())
            .setPredefinedValues(X509Parameters.newBuilder().build())
            .setIdentityConstraints(CertificateIdentityConstraints.newBuilder().build())
            .setPassthroughExtensions(CertificateExtensionConstraints.newBuilder().build())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCertificateTemplateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    CertificateTemplate certificateTemplate = CertificateTemplate.newBuilder().build();
    String certificateTemplateId = "certificateTemplateId1920134188";

    CertificateTemplate actualResponse =
        client
            .createCertificateTemplateAsync(parent, certificateTemplate, certificateTemplateId)
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
  public void createCertificateTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      CertificateTemplate certificateTemplate = CertificateTemplate.newBuilder().build();
      String certificateTemplateId = "certificateTemplateId1920134188";
      client
          .createCertificateTemplateAsync(parent, certificateTemplate, certificateTemplateId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteCertificateTemplateTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCertificateTemplateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CertificateTemplateName name =
        CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]");

    client.deleteCertificateTemplateAsync(name).get();

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
  public void deleteCertificateTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CertificateTemplateName name =
          CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]");
      client.deleteCertificateTemplateAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteCertificateTemplateTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCertificateTemplateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-5118/locations/location-5118/certificateTemplates/certificateTemplate-5118";

    client.deleteCertificateTemplateAsync(name).get();

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
  public void deleteCertificateTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5118/locations/location-5118/certificateTemplates/certificateTemplate-5118";
      client.deleteCertificateTemplateAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getCertificateTemplateTest() throws Exception {
    CertificateTemplate expectedResponse =
        CertificateTemplate.newBuilder()
            .setName(
                CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]")
                    .toString())
            .setPredefinedValues(X509Parameters.newBuilder().build())
            .setIdentityConstraints(CertificateIdentityConstraints.newBuilder().build())
            .setPassthroughExtensions(CertificateExtensionConstraints.newBuilder().build())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    CertificateTemplateName name =
        CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]");

    CertificateTemplate actualResponse = client.getCertificateTemplate(name);
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
  public void getCertificateTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CertificateTemplateName name =
          CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]");
      client.getCertificateTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCertificateTemplateTest2() throws Exception {
    CertificateTemplate expectedResponse =
        CertificateTemplate.newBuilder()
            .setName(
                CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]")
                    .toString())
            .setPredefinedValues(X509Parameters.newBuilder().build())
            .setIdentityConstraints(CertificateIdentityConstraints.newBuilder().build())
            .setPassthroughExtensions(CertificateExtensionConstraints.newBuilder().build())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5118/locations/location-5118/certificateTemplates/certificateTemplate-5118";

    CertificateTemplate actualResponse = client.getCertificateTemplate(name);
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
  public void getCertificateTemplateExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5118/locations/location-5118/certificateTemplates/certificateTemplate-5118";
      client.getCertificateTemplate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCertificateTemplatesTest() throws Exception {
    CertificateTemplate responsesElement = CertificateTemplate.newBuilder().build();
    ListCertificateTemplatesResponse expectedResponse =
        ListCertificateTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCertificateTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCertificateTemplatesPagedResponse pagedListResponse =
        client.listCertificateTemplates(parent);

    List<CertificateTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCertificateTemplatesList().get(0), resources.get(0));

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
  public void listCertificateTemplatesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCertificateTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCertificateTemplatesTest2() throws Exception {
    CertificateTemplate responsesElement = CertificateTemplate.newBuilder().build();
    ListCertificateTemplatesResponse expectedResponse =
        ListCertificateTemplatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCertificateTemplates(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListCertificateTemplatesPagedResponse pagedListResponse =
        client.listCertificateTemplates(parent);

    List<CertificateTemplate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCertificateTemplatesList().get(0), resources.get(0));

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
  public void listCertificateTemplatesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listCertificateTemplates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCertificateTemplateTest() throws Exception {
    CertificateTemplate expectedResponse =
        CertificateTemplate.newBuilder()
            .setName(
                CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]")
                    .toString())
            .setPredefinedValues(X509Parameters.newBuilder().build())
            .setIdentityConstraints(CertificateIdentityConstraints.newBuilder().build())
            .setPassthroughExtensions(CertificateExtensionConstraints.newBuilder().build())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateCertificateTemplateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CertificateTemplate certificateTemplate =
        CertificateTemplate.newBuilder()
            .setName(
                CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]")
                    .toString())
            .setPredefinedValues(X509Parameters.newBuilder().build())
            .setIdentityConstraints(CertificateIdentityConstraints.newBuilder().build())
            .setPassthroughExtensions(CertificateExtensionConstraints.newBuilder().build())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CertificateTemplate actualResponse =
        client.updateCertificateTemplateAsync(certificateTemplate, updateMask).get();
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
  public void updateCertificateTemplateExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CertificateTemplate certificateTemplate =
          CertificateTemplate.newBuilder()
              .setName(
                  CertificateTemplateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_TEMPLATE]")
                      .toString())
              .setPredefinedValues(X509Parameters.newBuilder().build())
              .setIdentityConstraints(CertificateIdentityConstraints.newBuilder().build())
              .setPassthroughExtensions(CertificateExtensionConstraints.newBuilder().build())
              .setDescription("description-1724546052")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCertificateTemplateAsync(certificateTemplate, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("projects/project-3664")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

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
  public void listLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("projects/project-3664")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    GetLocationRequest request =
        GetLocationRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .build();

    Location actualResponse = client.getLocation(request);
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
  public void getLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetLocationRequest request =
          GetLocationRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
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
  public void setIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
              .setPolicy(Policy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
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
  public void getIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockService.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
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
  public void testIamPermissionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(CaPoolName.of("[PROJECT]", "[LOCATION]", "[CA_POOL]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
