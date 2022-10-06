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

package com.google.appengine.v1;

import static com.google.appengine.v1.AuthorizedCertificatesClient.ListAuthorizedCertificatesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class AuthorizedCertificatesClientTest {
  private static MockAuthorizedCertificates mockAuthorizedCertificates;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private AuthorizedCertificatesClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockAuthorizedCertificates = new MockAuthorizedCertificates();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockAuthorizedCertificates));
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
    AuthorizedCertificatesSettings settings =
        AuthorizedCertificatesSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = AuthorizedCertificatesClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listAuthorizedCertificatesTest() throws Exception {
    AuthorizedCertificate responsesElement = AuthorizedCertificate.newBuilder().build();
    ListAuthorizedCertificatesResponse expectedResponse =
        ListAuthorizedCertificatesResponse.newBuilder()
            .setNextPageToken("")
            .addAllCertificates(Arrays.asList(responsesElement))
            .build();
    mockAuthorizedCertificates.addResponse(expectedResponse);

    ListAuthorizedCertificatesRequest request =
        ListAuthorizedCertificatesRequest.newBuilder()
            .setParent("parent-995424086")
            .setView(AuthorizedCertificateView.forNumber(0))
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListAuthorizedCertificatesPagedResponse pagedListResponse =
        client.listAuthorizedCertificates(request);

    List<AuthorizedCertificate> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCertificatesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockAuthorizedCertificates.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAuthorizedCertificatesRequest actualRequest =
        ((ListAuthorizedCertificatesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getView(), actualRequest.getView());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAuthorizedCertificatesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthorizedCertificates.addException(exception);

    try {
      ListAuthorizedCertificatesRequest request =
          ListAuthorizedCertificatesRequest.newBuilder()
              .setParent("parent-995424086")
              .setView(AuthorizedCertificateView.forNumber(0))
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listAuthorizedCertificates(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAuthorizedCertificateTest() throws Exception {
    AuthorizedCertificate expectedResponse =
        AuthorizedCertificate.newBuilder()
            .setName("name3373707")
            .setId("id3355")
            .setDisplayName("displayName1714148973")
            .addAllDomainNames(new ArrayList<String>())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCertificateRawData(CertificateRawData.newBuilder().build())
            .setManagedCertificate(ManagedCertificate.newBuilder().build())
            .addAllVisibleDomainMappings(new ArrayList<String>())
            .setDomainMappingsCount(-307278192)
            .build();
    mockAuthorizedCertificates.addResponse(expectedResponse);

    GetAuthorizedCertificateRequest request =
        GetAuthorizedCertificateRequest.newBuilder()
            .setName("name3373707")
            .setView(AuthorizedCertificateView.forNumber(0))
            .build();

    AuthorizedCertificate actualResponse = client.getAuthorizedCertificate(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuthorizedCertificates.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAuthorizedCertificateRequest actualRequest =
        ((GetAuthorizedCertificateRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getView(), actualRequest.getView());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAuthorizedCertificateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthorizedCertificates.addException(exception);

    try {
      GetAuthorizedCertificateRequest request =
          GetAuthorizedCertificateRequest.newBuilder()
              .setName("name3373707")
              .setView(AuthorizedCertificateView.forNumber(0))
              .build();
      client.getAuthorizedCertificate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAuthorizedCertificateTest() throws Exception {
    AuthorizedCertificate expectedResponse =
        AuthorizedCertificate.newBuilder()
            .setName("name3373707")
            .setId("id3355")
            .setDisplayName("displayName1714148973")
            .addAllDomainNames(new ArrayList<String>())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCertificateRawData(CertificateRawData.newBuilder().build())
            .setManagedCertificate(ManagedCertificate.newBuilder().build())
            .addAllVisibleDomainMappings(new ArrayList<String>())
            .setDomainMappingsCount(-307278192)
            .build();
    mockAuthorizedCertificates.addResponse(expectedResponse);

    CreateAuthorizedCertificateRequest request =
        CreateAuthorizedCertificateRequest.newBuilder()
            .setParent("parent-995424086")
            .setCertificate(AuthorizedCertificate.newBuilder().build())
            .build();

    AuthorizedCertificate actualResponse = client.createAuthorizedCertificate(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuthorizedCertificates.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAuthorizedCertificateRequest actualRequest =
        ((CreateAuthorizedCertificateRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getCertificate(), actualRequest.getCertificate());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAuthorizedCertificateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthorizedCertificates.addException(exception);

    try {
      CreateAuthorizedCertificateRequest request =
          CreateAuthorizedCertificateRequest.newBuilder()
              .setParent("parent-995424086")
              .setCertificate(AuthorizedCertificate.newBuilder().build())
              .build();
      client.createAuthorizedCertificate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAuthorizedCertificateTest() throws Exception {
    AuthorizedCertificate expectedResponse =
        AuthorizedCertificate.newBuilder()
            .setName("name3373707")
            .setId("id3355")
            .setDisplayName("displayName1714148973")
            .addAllDomainNames(new ArrayList<String>())
            .setExpireTime(Timestamp.newBuilder().build())
            .setCertificateRawData(CertificateRawData.newBuilder().build())
            .setManagedCertificate(ManagedCertificate.newBuilder().build())
            .addAllVisibleDomainMappings(new ArrayList<String>())
            .setDomainMappingsCount(-307278192)
            .build();
    mockAuthorizedCertificates.addResponse(expectedResponse);

    UpdateAuthorizedCertificateRequest request =
        UpdateAuthorizedCertificateRequest.newBuilder()
            .setName("name3373707")
            .setCertificate(AuthorizedCertificate.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    AuthorizedCertificate actualResponse = client.updateAuthorizedCertificate(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockAuthorizedCertificates.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAuthorizedCertificateRequest actualRequest =
        ((UpdateAuthorizedCertificateRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getCertificate(), actualRequest.getCertificate());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAuthorizedCertificateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthorizedCertificates.addException(exception);

    try {
      UpdateAuthorizedCertificateRequest request =
          UpdateAuthorizedCertificateRequest.newBuilder()
              .setName("name3373707")
              .setCertificate(AuthorizedCertificate.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateAuthorizedCertificate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAuthorizedCertificateTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockAuthorizedCertificates.addResponse(expectedResponse);

    DeleteAuthorizedCertificateRequest request =
        DeleteAuthorizedCertificateRequest.newBuilder().setName("name3373707").build();

    client.deleteAuthorizedCertificate(request);

    List<AbstractMessage> actualRequests = mockAuthorizedCertificates.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAuthorizedCertificateRequest actualRequest =
        ((DeleteAuthorizedCertificateRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAuthorizedCertificateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockAuthorizedCertificates.addException(exception);

    try {
      DeleteAuthorizedCertificateRequest request =
          DeleteAuthorizedCertificateRequest.newBuilder().setName("name3373707").build();
      client.deleteAuthorizedCertificate(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
