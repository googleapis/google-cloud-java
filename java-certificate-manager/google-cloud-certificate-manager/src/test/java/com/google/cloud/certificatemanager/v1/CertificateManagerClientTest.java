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

import static com.google.cloud.certificatemanager.v1.CertificateManagerClient.ListCertificateIssuanceConfigsPagedResponse;
import static com.google.cloud.certificatemanager.v1.CertificateManagerClient.ListCertificateMapEntriesPagedResponse;
import static com.google.cloud.certificatemanager.v1.CertificateManagerClient.ListCertificateMapsPagedResponse;
import static com.google.cloud.certificatemanager.v1.CertificateManagerClient.ListCertificatesPagedResponse;
import static com.google.cloud.certificatemanager.v1.CertificateManagerClient.ListDnsAuthorizationsPagedResponse;
import static com.google.cloud.certificatemanager.v1.CertificateManagerClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class CertificateManagerClientTest {
  private static MockCertificateManager mockCertificateManager;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CertificateManagerClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCertificateManager = new MockCertificateManager();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockCertificateManager, mockLocations));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    CertificateManagerSettings settings =
        CertificateManagerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CertificateManagerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listCertificatesTest() throws Exception {
    Certificate responsesElement = Certificate.newBuilder().build();
    ListCertificatesResponse expectedResponse =
        ListCertificatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCertificates(Arrays.asList(responsesElement))
            .build();
    mockCertificateManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCertificatesPagedResponse pagedListResponse = client.listCertificates(parent);

    List<Certificate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCertificatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCertificatesRequest actualRequest = ((ListCertificatesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCertificatesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
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
    mockCertificateManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCertificatesPagedResponse pagedListResponse = client.listCertificates(parent);

    List<Certificate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCertificatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCertificatesRequest actualRequest = ((ListCertificatesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCertificatesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCertificates(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCertificateTest() throws Exception {
    Certificate expectedResponse =
        Certificate.newBuilder()
            .setName(CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllSanDnsnames(new ArrayList<String>())
            .setPemCertificate("pemCertificate153491807")
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockCertificateManager.addResponse(expectedResponse);

    CertificateName name = CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE]");

    Certificate actualResponse = client.getCertificate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCertificateRequest actualRequest = ((GetCertificateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCertificateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      CertificateName name = CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE]");
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
            .setName(CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllSanDnsnames(new ArrayList<String>())
            .setPemCertificate("pemCertificate153491807")
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    mockCertificateManager.addResponse(expectedResponse);

    String name = "name3373707";

    Certificate actualResponse = client.getCertificate(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCertificateRequest actualRequest = ((GetCertificateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCertificateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      String name = "name3373707";
      client.getCertificate(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCertificateTest() throws Exception {
    Certificate expectedResponse =
        Certificate.newBuilder()
            .setName(CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllSanDnsnames(new ArrayList<String>())
            .setPemCertificate("pemCertificate153491807")
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCertificateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateManager.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Certificate certificate = Certificate.newBuilder().build();
    String certificateId = "certificateId-644529902";

    Certificate actualResponse =
        client.createCertificateAsync(parent, certificate, certificateId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCertificateRequest actualRequest = ((CreateCertificateRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(certificate, actualRequest.getCertificate());
    Assert.assertEquals(certificateId, actualRequest.getCertificateId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCertificateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Certificate certificate = Certificate.newBuilder().build();
      String certificateId = "certificateId-644529902";
      client.createCertificateAsync(parent, certificate, certificateId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createCertificateTest2() throws Exception {
    Certificate expectedResponse =
        Certificate.newBuilder()
            .setName(CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllSanDnsnames(new ArrayList<String>())
            .setPemCertificate("pemCertificate153491807")
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCertificateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateManager.addResponse(resultOperation);

    String parent = "parent-995424086";
    Certificate certificate = Certificate.newBuilder().build();
    String certificateId = "certificateId-644529902";

    Certificate actualResponse =
        client.createCertificateAsync(parent, certificate, certificateId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCertificateRequest actualRequest = ((CreateCertificateRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(certificate, actualRequest.getCertificate());
    Assert.assertEquals(certificateId, actualRequest.getCertificateId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCertificateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      String parent = "parent-995424086";
      Certificate certificate = Certificate.newBuilder().build();
      String certificateId = "certificateId-644529902";
      client.createCertificateAsync(parent, certificate, certificateId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateCertificateTest() throws Exception {
    Certificate expectedResponse =
        Certificate.newBuilder()
            .setName(CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllSanDnsnames(new ArrayList<String>())
            .setPemCertificate("pemCertificate153491807")
            .setExpireTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateCertificateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateManager.addResponse(resultOperation);

    Certificate certificate = Certificate.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Certificate actualResponse = client.updateCertificateAsync(certificate, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCertificateRequest actualRequest = ((UpdateCertificateRequest) actualRequests.get(0));

    Assert.assertEquals(certificate, actualRequest.getCertificate());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCertificateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      Certificate certificate = Certificate.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCertificateAsync(certificate, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteCertificateTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCertificateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateManager.addResponse(resultOperation);

    CertificateName name = CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE]");

    client.deleteCertificateAsync(name).get();

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCertificateRequest actualRequest = ((DeleteCertificateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCertificateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      CertificateName name = CertificateName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE]");
      client.deleteCertificateAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteCertificateTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCertificateTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateManager.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteCertificateAsync(name).get();

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCertificateRequest actualRequest = ((DeleteCertificateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCertificateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteCertificateAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listCertificateMapsTest() throws Exception {
    CertificateMap responsesElement = CertificateMap.newBuilder().build();
    ListCertificateMapsResponse expectedResponse =
        ListCertificateMapsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCertificateMaps(Arrays.asList(responsesElement))
            .build();
    mockCertificateManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCertificateMapsPagedResponse pagedListResponse = client.listCertificateMaps(parent);

    List<CertificateMap> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCertificateMapsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCertificateMapsRequest actualRequest = ((ListCertificateMapsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCertificateMapsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCertificateMaps(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCertificateMapsTest2() throws Exception {
    CertificateMap responsesElement = CertificateMap.newBuilder().build();
    ListCertificateMapsResponse expectedResponse =
        ListCertificateMapsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCertificateMaps(Arrays.asList(responsesElement))
            .build();
    mockCertificateManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCertificateMapsPagedResponse pagedListResponse = client.listCertificateMaps(parent);

    List<CertificateMap> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCertificateMapsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCertificateMapsRequest actualRequest = ((ListCertificateMapsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCertificateMapsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCertificateMaps(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCertificateMapTest() throws Exception {
    CertificateMap expectedResponse =
        CertificateMap.newBuilder()
            .setName(
                CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllGclbTargets(new ArrayList<CertificateMap.GclbTarget>())
            .build();
    mockCertificateManager.addResponse(expectedResponse);

    CertificateMapName name = CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]");

    CertificateMap actualResponse = client.getCertificateMap(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCertificateMapRequest actualRequest = ((GetCertificateMapRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCertificateMapExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      CertificateMapName name =
          CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]");
      client.getCertificateMap(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCertificateMapTest2() throws Exception {
    CertificateMap expectedResponse =
        CertificateMap.newBuilder()
            .setName(
                CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllGclbTargets(new ArrayList<CertificateMap.GclbTarget>())
            .build();
    mockCertificateManager.addResponse(expectedResponse);

    String name = "name3373707";

    CertificateMap actualResponse = client.getCertificateMap(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCertificateMapRequest actualRequest = ((GetCertificateMapRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCertificateMapExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      String name = "name3373707";
      client.getCertificateMap(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCertificateMapTest() throws Exception {
    CertificateMap expectedResponse =
        CertificateMap.newBuilder()
            .setName(
                CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllGclbTargets(new ArrayList<CertificateMap.GclbTarget>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCertificateMapTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateManager.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    CertificateMap certificateMap = CertificateMap.newBuilder().build();
    String certificateMapId = "certificateMapId1612184640";

    CertificateMap actualResponse =
        client.createCertificateMapAsync(parent, certificateMap, certificateMapId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCertificateMapRequest actualRequest =
        ((CreateCertificateMapRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(certificateMap, actualRequest.getCertificateMap());
    Assert.assertEquals(certificateMapId, actualRequest.getCertificateMapId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCertificateMapExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      CertificateMap certificateMap = CertificateMap.newBuilder().build();
      String certificateMapId = "certificateMapId1612184640";
      client.createCertificateMapAsync(parent, certificateMap, certificateMapId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createCertificateMapTest2() throws Exception {
    CertificateMap expectedResponse =
        CertificateMap.newBuilder()
            .setName(
                CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllGclbTargets(new ArrayList<CertificateMap.GclbTarget>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCertificateMapTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateManager.addResponse(resultOperation);

    String parent = "parent-995424086";
    CertificateMap certificateMap = CertificateMap.newBuilder().build();
    String certificateMapId = "certificateMapId1612184640";

    CertificateMap actualResponse =
        client.createCertificateMapAsync(parent, certificateMap, certificateMapId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCertificateMapRequest actualRequest =
        ((CreateCertificateMapRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(certificateMap, actualRequest.getCertificateMap());
    Assert.assertEquals(certificateMapId, actualRequest.getCertificateMapId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCertificateMapExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      String parent = "parent-995424086";
      CertificateMap certificateMap = CertificateMap.newBuilder().build();
      String certificateMapId = "certificateMapId1612184640";
      client.createCertificateMapAsync(parent, certificateMap, certificateMapId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateCertificateMapTest() throws Exception {
    CertificateMap expectedResponse =
        CertificateMap.newBuilder()
            .setName(
                CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]").toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllGclbTargets(new ArrayList<CertificateMap.GclbTarget>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateCertificateMapTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateManager.addResponse(resultOperation);

    CertificateMap certificateMap = CertificateMap.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CertificateMap actualResponse =
        client.updateCertificateMapAsync(certificateMap, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCertificateMapRequest actualRequest =
        ((UpdateCertificateMapRequest) actualRequests.get(0));

    Assert.assertEquals(certificateMap, actualRequest.getCertificateMap());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCertificateMapExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      CertificateMap certificateMap = CertificateMap.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCertificateMapAsync(certificateMap, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteCertificateMapTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCertificateMapTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateManager.addResponse(resultOperation);

    CertificateMapName name = CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]");

    client.deleteCertificateMapAsync(name).get();

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCertificateMapRequest actualRequest =
        ((DeleteCertificateMapRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCertificateMapExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      CertificateMapName name =
          CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]");
      client.deleteCertificateMapAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteCertificateMapTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCertificateMapTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateManager.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteCertificateMapAsync(name).get();

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCertificateMapRequest actualRequest =
        ((DeleteCertificateMapRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCertificateMapExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteCertificateMapAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listCertificateMapEntriesTest() throws Exception {
    CertificateMapEntry responsesElement = CertificateMapEntry.newBuilder().build();
    ListCertificateMapEntriesResponse expectedResponse =
        ListCertificateMapEntriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCertificateMapEntries(Arrays.asList(responsesElement))
            .build();
    mockCertificateManager.addResponse(expectedResponse);

    CertificateMapName parent =
        CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]");

    ListCertificateMapEntriesPagedResponse pagedListResponse =
        client.listCertificateMapEntries(parent);

    List<CertificateMapEntry> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCertificateMapEntriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCertificateMapEntriesRequest actualRequest =
        ((ListCertificateMapEntriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCertificateMapEntriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      CertificateMapName parent =
          CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]");
      client.listCertificateMapEntries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCertificateMapEntriesTest2() throws Exception {
    CertificateMapEntry responsesElement = CertificateMapEntry.newBuilder().build();
    ListCertificateMapEntriesResponse expectedResponse =
        ListCertificateMapEntriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCertificateMapEntries(Arrays.asList(responsesElement))
            .build();
    mockCertificateManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCertificateMapEntriesPagedResponse pagedListResponse =
        client.listCertificateMapEntries(parent);

    List<CertificateMapEntry> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCertificateMapEntriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCertificateMapEntriesRequest actualRequest =
        ((ListCertificateMapEntriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCertificateMapEntriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCertificateMapEntries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCertificateMapEntryTest() throws Exception {
    CertificateMapEntry expectedResponse =
        CertificateMapEntry.newBuilder()
            .setName(
                CertificateMapEntryName.of(
                        "[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]", "[CERTIFICATE_MAP_ENTRY]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllCertificates(new ArrayList<String>())
            .setState(ServingState.forNumber(0))
            .build();
    mockCertificateManager.addResponse(expectedResponse);

    CertificateMapEntryName name =
        CertificateMapEntryName.of(
            "[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]", "[CERTIFICATE_MAP_ENTRY]");

    CertificateMapEntry actualResponse = client.getCertificateMapEntry(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCertificateMapEntryRequest actualRequest =
        ((GetCertificateMapEntryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCertificateMapEntryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      CertificateMapEntryName name =
          CertificateMapEntryName.of(
              "[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]", "[CERTIFICATE_MAP_ENTRY]");
      client.getCertificateMapEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCertificateMapEntryTest2() throws Exception {
    CertificateMapEntry expectedResponse =
        CertificateMapEntry.newBuilder()
            .setName(
                CertificateMapEntryName.of(
                        "[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]", "[CERTIFICATE_MAP_ENTRY]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllCertificates(new ArrayList<String>())
            .setState(ServingState.forNumber(0))
            .build();
    mockCertificateManager.addResponse(expectedResponse);

    String name = "name3373707";

    CertificateMapEntry actualResponse = client.getCertificateMapEntry(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCertificateMapEntryRequest actualRequest =
        ((GetCertificateMapEntryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCertificateMapEntryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      String name = "name3373707";
      client.getCertificateMapEntry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCertificateMapEntryTest() throws Exception {
    CertificateMapEntry expectedResponse =
        CertificateMapEntry.newBuilder()
            .setName(
                CertificateMapEntryName.of(
                        "[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]", "[CERTIFICATE_MAP_ENTRY]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllCertificates(new ArrayList<String>())
            .setState(ServingState.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCertificateMapEntryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateManager.addResponse(resultOperation);

    CertificateMapName parent =
        CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]");
    CertificateMapEntry certificateMapEntry = CertificateMapEntry.newBuilder().build();
    String certificateMapEntryId = "certificateMapEntryId-859079384";

    CertificateMapEntry actualResponse =
        client
            .createCertificateMapEntryAsync(parent, certificateMapEntry, certificateMapEntryId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCertificateMapEntryRequest actualRequest =
        ((CreateCertificateMapEntryRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(certificateMapEntry, actualRequest.getCertificateMapEntry());
    Assert.assertEquals(certificateMapEntryId, actualRequest.getCertificateMapEntryId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCertificateMapEntryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      CertificateMapName parent =
          CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]");
      CertificateMapEntry certificateMapEntry = CertificateMapEntry.newBuilder().build();
      String certificateMapEntryId = "certificateMapEntryId-859079384";
      client
          .createCertificateMapEntryAsync(parent, certificateMapEntry, certificateMapEntryId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createCertificateMapEntryTest2() throws Exception {
    CertificateMapEntry expectedResponse =
        CertificateMapEntry.newBuilder()
            .setName(
                CertificateMapEntryName.of(
                        "[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]", "[CERTIFICATE_MAP_ENTRY]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllCertificates(new ArrayList<String>())
            .setState(ServingState.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCertificateMapEntryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateManager.addResponse(resultOperation);

    String parent = "parent-995424086";
    CertificateMapEntry certificateMapEntry = CertificateMapEntry.newBuilder().build();
    String certificateMapEntryId = "certificateMapEntryId-859079384";

    CertificateMapEntry actualResponse =
        client
            .createCertificateMapEntryAsync(parent, certificateMapEntry, certificateMapEntryId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCertificateMapEntryRequest actualRequest =
        ((CreateCertificateMapEntryRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(certificateMapEntry, actualRequest.getCertificateMapEntry());
    Assert.assertEquals(certificateMapEntryId, actualRequest.getCertificateMapEntryId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCertificateMapEntryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      String parent = "parent-995424086";
      CertificateMapEntry certificateMapEntry = CertificateMapEntry.newBuilder().build();
      String certificateMapEntryId = "certificateMapEntryId-859079384";
      client
          .createCertificateMapEntryAsync(parent, certificateMapEntry, certificateMapEntryId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateCertificateMapEntryTest() throws Exception {
    CertificateMapEntry expectedResponse =
        CertificateMapEntry.newBuilder()
            .setName(
                CertificateMapEntryName.of(
                        "[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]", "[CERTIFICATE_MAP_ENTRY]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllCertificates(new ArrayList<String>())
            .setState(ServingState.forNumber(0))
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateCertificateMapEntryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateManager.addResponse(resultOperation);

    CertificateMapEntry certificateMapEntry = CertificateMapEntry.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CertificateMapEntry actualResponse =
        client.updateCertificateMapEntryAsync(certificateMapEntry, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCertificateMapEntryRequest actualRequest =
        ((UpdateCertificateMapEntryRequest) actualRequests.get(0));

    Assert.assertEquals(certificateMapEntry, actualRequest.getCertificateMapEntry());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCertificateMapEntryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      CertificateMapEntry certificateMapEntry = CertificateMapEntry.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCertificateMapEntryAsync(certificateMapEntry, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteCertificateMapEntryTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCertificateMapEntryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateManager.addResponse(resultOperation);

    CertificateMapEntryName name =
        CertificateMapEntryName.of(
            "[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]", "[CERTIFICATE_MAP_ENTRY]");

    client.deleteCertificateMapEntryAsync(name).get();

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCertificateMapEntryRequest actualRequest =
        ((DeleteCertificateMapEntryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCertificateMapEntryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      CertificateMapEntryName name =
          CertificateMapEntryName.of(
              "[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]", "[CERTIFICATE_MAP_ENTRY]");
      client.deleteCertificateMapEntryAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteCertificateMapEntryTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCertificateMapEntryTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateManager.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteCertificateMapEntryAsync(name).get();

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCertificateMapEntryRequest actualRequest =
        ((DeleteCertificateMapEntryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCertificateMapEntryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteCertificateMapEntryAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listDnsAuthorizationsTest() throws Exception {
    DnsAuthorization responsesElement = DnsAuthorization.newBuilder().build();
    ListDnsAuthorizationsResponse expectedResponse =
        ListDnsAuthorizationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDnsAuthorizations(Arrays.asList(responsesElement))
            .build();
    mockCertificateManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDnsAuthorizationsPagedResponse pagedListResponse = client.listDnsAuthorizations(parent);

    List<DnsAuthorization> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDnsAuthorizationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDnsAuthorizationsRequest actualRequest =
        ((ListDnsAuthorizationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDnsAuthorizationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDnsAuthorizations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDnsAuthorizationsTest2() throws Exception {
    DnsAuthorization responsesElement = DnsAuthorization.newBuilder().build();
    ListDnsAuthorizationsResponse expectedResponse =
        ListDnsAuthorizationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDnsAuthorizations(Arrays.asList(responsesElement))
            .build();
    mockCertificateManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDnsAuthorizationsPagedResponse pagedListResponse = client.listDnsAuthorizations(parent);

    List<DnsAuthorization> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDnsAuthorizationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDnsAuthorizationsRequest actualRequest =
        ((ListDnsAuthorizationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDnsAuthorizationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDnsAuthorizations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDnsAuthorizationTest() throws Exception {
    DnsAuthorization expectedResponse =
        DnsAuthorization.newBuilder()
            .setName(
                DnsAuthorizationName.of("[PROJECT]", "[LOCATION]", "[DNS_AUTHORIZATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setDomain("domain-1326197564")
            .setDnsResourceRecord(DnsAuthorization.DnsResourceRecord.newBuilder().build())
            .build();
    mockCertificateManager.addResponse(expectedResponse);

    DnsAuthorizationName name =
        DnsAuthorizationName.of("[PROJECT]", "[LOCATION]", "[DNS_AUTHORIZATION]");

    DnsAuthorization actualResponse = client.getDnsAuthorization(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDnsAuthorizationRequest actualRequest = ((GetDnsAuthorizationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDnsAuthorizationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      DnsAuthorizationName name =
          DnsAuthorizationName.of("[PROJECT]", "[LOCATION]", "[DNS_AUTHORIZATION]");
      client.getDnsAuthorization(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDnsAuthorizationTest2() throws Exception {
    DnsAuthorization expectedResponse =
        DnsAuthorization.newBuilder()
            .setName(
                DnsAuthorizationName.of("[PROJECT]", "[LOCATION]", "[DNS_AUTHORIZATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setDomain("domain-1326197564")
            .setDnsResourceRecord(DnsAuthorization.DnsResourceRecord.newBuilder().build())
            .build();
    mockCertificateManager.addResponse(expectedResponse);

    String name = "name3373707";

    DnsAuthorization actualResponse = client.getDnsAuthorization(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDnsAuthorizationRequest actualRequest = ((GetDnsAuthorizationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDnsAuthorizationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      String name = "name3373707";
      client.getDnsAuthorization(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDnsAuthorizationTest() throws Exception {
    DnsAuthorization expectedResponse =
        DnsAuthorization.newBuilder()
            .setName(
                DnsAuthorizationName.of("[PROJECT]", "[LOCATION]", "[DNS_AUTHORIZATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setDomain("domain-1326197564")
            .setDnsResourceRecord(DnsAuthorization.DnsResourceRecord.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDnsAuthorizationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateManager.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    DnsAuthorization dnsAuthorization = DnsAuthorization.newBuilder().build();
    String dnsAuthorizationId = "dnsAuthorizationId-2054763765";

    DnsAuthorization actualResponse =
        client.createDnsAuthorizationAsync(parent, dnsAuthorization, dnsAuthorizationId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDnsAuthorizationRequest actualRequest =
        ((CreateDnsAuthorizationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dnsAuthorization, actualRequest.getDnsAuthorization());
    Assert.assertEquals(dnsAuthorizationId, actualRequest.getDnsAuthorizationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDnsAuthorizationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      DnsAuthorization dnsAuthorization = DnsAuthorization.newBuilder().build();
      String dnsAuthorizationId = "dnsAuthorizationId-2054763765";
      client.createDnsAuthorizationAsync(parent, dnsAuthorization, dnsAuthorizationId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createDnsAuthorizationTest2() throws Exception {
    DnsAuthorization expectedResponse =
        DnsAuthorization.newBuilder()
            .setName(
                DnsAuthorizationName.of("[PROJECT]", "[LOCATION]", "[DNS_AUTHORIZATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setDomain("domain-1326197564")
            .setDnsResourceRecord(DnsAuthorization.DnsResourceRecord.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createDnsAuthorizationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateManager.addResponse(resultOperation);

    String parent = "parent-995424086";
    DnsAuthorization dnsAuthorization = DnsAuthorization.newBuilder().build();
    String dnsAuthorizationId = "dnsAuthorizationId-2054763765";

    DnsAuthorization actualResponse =
        client.createDnsAuthorizationAsync(parent, dnsAuthorization, dnsAuthorizationId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDnsAuthorizationRequest actualRequest =
        ((CreateDnsAuthorizationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dnsAuthorization, actualRequest.getDnsAuthorization());
    Assert.assertEquals(dnsAuthorizationId, actualRequest.getDnsAuthorizationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDnsAuthorizationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      String parent = "parent-995424086";
      DnsAuthorization dnsAuthorization = DnsAuthorization.newBuilder().build();
      String dnsAuthorizationId = "dnsAuthorizationId-2054763765";
      client.createDnsAuthorizationAsync(parent, dnsAuthorization, dnsAuthorizationId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateDnsAuthorizationTest() throws Exception {
    DnsAuthorization expectedResponse =
        DnsAuthorization.newBuilder()
            .setName(
                DnsAuthorizationName.of("[PROJECT]", "[LOCATION]", "[DNS_AUTHORIZATION]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setDomain("domain-1326197564")
            .setDnsResourceRecord(DnsAuthorization.DnsResourceRecord.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateDnsAuthorizationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateManager.addResponse(resultOperation);

    DnsAuthorization dnsAuthorization = DnsAuthorization.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DnsAuthorization actualResponse =
        client.updateDnsAuthorizationAsync(dnsAuthorization, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDnsAuthorizationRequest actualRequest =
        ((UpdateDnsAuthorizationRequest) actualRequests.get(0));

    Assert.assertEquals(dnsAuthorization, actualRequest.getDnsAuthorization());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDnsAuthorizationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      DnsAuthorization dnsAuthorization = DnsAuthorization.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDnsAuthorizationAsync(dnsAuthorization, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDnsAuthorizationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDnsAuthorizationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateManager.addResponse(resultOperation);

    DnsAuthorizationName name =
        DnsAuthorizationName.of("[PROJECT]", "[LOCATION]", "[DNS_AUTHORIZATION]");

    client.deleteDnsAuthorizationAsync(name).get();

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDnsAuthorizationRequest actualRequest =
        ((DeleteDnsAuthorizationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDnsAuthorizationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      DnsAuthorizationName name =
          DnsAuthorizationName.of("[PROJECT]", "[LOCATION]", "[DNS_AUTHORIZATION]");
      client.deleteDnsAuthorizationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteDnsAuthorizationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteDnsAuthorizationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateManager.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteDnsAuthorizationAsync(name).get();

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDnsAuthorizationRequest actualRequest =
        ((DeleteDnsAuthorizationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDnsAuthorizationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDnsAuthorizationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listCertificateIssuanceConfigsTest() throws Exception {
    CertificateIssuanceConfig responsesElement = CertificateIssuanceConfig.newBuilder().build();
    ListCertificateIssuanceConfigsResponse expectedResponse =
        ListCertificateIssuanceConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCertificateIssuanceConfigs(Arrays.asList(responsesElement))
            .build();
    mockCertificateManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCertificateIssuanceConfigsPagedResponse pagedListResponse =
        client.listCertificateIssuanceConfigs(parent);

    List<CertificateIssuanceConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getCertificateIssuanceConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCertificateIssuanceConfigsRequest actualRequest =
        ((ListCertificateIssuanceConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCertificateIssuanceConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listCertificateIssuanceConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCertificateIssuanceConfigsTest2() throws Exception {
    CertificateIssuanceConfig responsesElement = CertificateIssuanceConfig.newBuilder().build();
    ListCertificateIssuanceConfigsResponse expectedResponse =
        ListCertificateIssuanceConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCertificateIssuanceConfigs(Arrays.asList(responsesElement))
            .build();
    mockCertificateManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCertificateIssuanceConfigsPagedResponse pagedListResponse =
        client.listCertificateIssuanceConfigs(parent);

    List<CertificateIssuanceConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getCertificateIssuanceConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCertificateIssuanceConfigsRequest actualRequest =
        ((ListCertificateIssuanceConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCertificateIssuanceConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCertificateIssuanceConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCertificateIssuanceConfigTest() throws Exception {
    CertificateIssuanceConfig expectedResponse =
        CertificateIssuanceConfig.newBuilder()
            .setName(
                CertificateIssuanceConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[CERTIFICATE_ISSUANCE_CONFIG]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setCertificateAuthorityConfig(
                CertificateIssuanceConfig.CertificateAuthorityConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setRotationWindowPercentage(873917384)
            .build();
    mockCertificateManager.addResponse(expectedResponse);

    CertificateIssuanceConfigName name =
        CertificateIssuanceConfigName.of(
            "[PROJECT]", "[LOCATION]", "[CERTIFICATE_ISSUANCE_CONFIG]");

    CertificateIssuanceConfig actualResponse = client.getCertificateIssuanceConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCertificateIssuanceConfigRequest actualRequest =
        ((GetCertificateIssuanceConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCertificateIssuanceConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      CertificateIssuanceConfigName name =
          CertificateIssuanceConfigName.of(
              "[PROJECT]", "[LOCATION]", "[CERTIFICATE_ISSUANCE_CONFIG]");
      client.getCertificateIssuanceConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCertificateIssuanceConfigTest2() throws Exception {
    CertificateIssuanceConfig expectedResponse =
        CertificateIssuanceConfig.newBuilder()
            .setName(
                CertificateIssuanceConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[CERTIFICATE_ISSUANCE_CONFIG]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setCertificateAuthorityConfig(
                CertificateIssuanceConfig.CertificateAuthorityConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setRotationWindowPercentage(873917384)
            .build();
    mockCertificateManager.addResponse(expectedResponse);

    String name = "name3373707";

    CertificateIssuanceConfig actualResponse = client.getCertificateIssuanceConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCertificateIssuanceConfigRequest actualRequest =
        ((GetCertificateIssuanceConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCertificateIssuanceConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      String name = "name3373707";
      client.getCertificateIssuanceConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCertificateIssuanceConfigTest() throws Exception {
    CertificateIssuanceConfig expectedResponse =
        CertificateIssuanceConfig.newBuilder()
            .setName(
                CertificateIssuanceConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[CERTIFICATE_ISSUANCE_CONFIG]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setCertificateAuthorityConfig(
                CertificateIssuanceConfig.CertificateAuthorityConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setRotationWindowPercentage(873917384)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCertificateIssuanceConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateManager.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    CertificateIssuanceConfig certificateIssuanceConfig =
        CertificateIssuanceConfig.newBuilder().build();
    String certificateIssuanceConfigId = "certificateIssuanceConfigId1910303023";

    CertificateIssuanceConfig actualResponse =
        client
            .createCertificateIssuanceConfigAsync(
                parent, certificateIssuanceConfig, certificateIssuanceConfigId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCertificateIssuanceConfigRequest actualRequest =
        ((CreateCertificateIssuanceConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(certificateIssuanceConfig, actualRequest.getCertificateIssuanceConfig());
    Assert.assertEquals(
        certificateIssuanceConfigId, actualRequest.getCertificateIssuanceConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCertificateIssuanceConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      CertificateIssuanceConfig certificateIssuanceConfig =
          CertificateIssuanceConfig.newBuilder().build();
      String certificateIssuanceConfigId = "certificateIssuanceConfigId1910303023";
      client
          .createCertificateIssuanceConfigAsync(
              parent, certificateIssuanceConfig, certificateIssuanceConfigId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createCertificateIssuanceConfigTest2() throws Exception {
    CertificateIssuanceConfig expectedResponse =
        CertificateIssuanceConfig.newBuilder()
            .setName(
                CertificateIssuanceConfigName.of(
                        "[PROJECT]", "[LOCATION]", "[CERTIFICATE_ISSUANCE_CONFIG]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setCertificateAuthorityConfig(
                CertificateIssuanceConfig.CertificateAuthorityConfig.newBuilder().build())
            .setLifetime(Duration.newBuilder().build())
            .setRotationWindowPercentage(873917384)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCertificateIssuanceConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateManager.addResponse(resultOperation);

    String parent = "parent-995424086";
    CertificateIssuanceConfig certificateIssuanceConfig =
        CertificateIssuanceConfig.newBuilder().build();
    String certificateIssuanceConfigId = "certificateIssuanceConfigId1910303023";

    CertificateIssuanceConfig actualResponse =
        client
            .createCertificateIssuanceConfigAsync(
                parent, certificateIssuanceConfig, certificateIssuanceConfigId)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCertificateIssuanceConfigRequest actualRequest =
        ((CreateCertificateIssuanceConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(certificateIssuanceConfig, actualRequest.getCertificateIssuanceConfig());
    Assert.assertEquals(
        certificateIssuanceConfigId, actualRequest.getCertificateIssuanceConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCertificateIssuanceConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      String parent = "parent-995424086";
      CertificateIssuanceConfig certificateIssuanceConfig =
          CertificateIssuanceConfig.newBuilder().build();
      String certificateIssuanceConfigId = "certificateIssuanceConfigId1910303023";
      client
          .createCertificateIssuanceConfigAsync(
              parent, certificateIssuanceConfig, certificateIssuanceConfigId)
          .get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteCertificateIssuanceConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCertificateIssuanceConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateManager.addResponse(resultOperation);

    CertificateIssuanceConfigName name =
        CertificateIssuanceConfigName.of(
            "[PROJECT]", "[LOCATION]", "[CERTIFICATE_ISSUANCE_CONFIG]");

    client.deleteCertificateIssuanceConfigAsync(name).get();

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCertificateIssuanceConfigRequest actualRequest =
        ((DeleteCertificateIssuanceConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCertificateIssuanceConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      CertificateIssuanceConfigName name =
          CertificateIssuanceConfigName.of(
              "[PROJECT]", "[LOCATION]", "[CERTIFICATE_ISSUANCE_CONFIG]");
      client.deleteCertificateIssuanceConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteCertificateIssuanceConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCertificateIssuanceConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCertificateManager.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteCertificateIssuanceConfigAsync(name).get();

    List<AbstractMessage> actualRequests = mockCertificateManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCertificateIssuanceConfigRequest actualRequest =
        ((DeleteCertificateIssuanceConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCertificateIssuanceConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCertificateManager.addException(exception);

    try {
      String name = "name3373707";
      client.deleteCertificateIssuanceConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
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
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
