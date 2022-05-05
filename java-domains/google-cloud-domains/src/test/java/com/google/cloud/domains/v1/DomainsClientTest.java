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

package com.google.cloud.domains.v1;

import static com.google.cloud.domains.v1.DomainsClient.ListRegistrationsPagedResponse;

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
import com.google.protobuf.Timestamp;
import com.google.type.Money;
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
public class DomainsClientTest {
  private static MockDomains mockDomains;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DomainsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDomains = new MockDomains();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDomains));
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
    DomainsSettings settings =
        DomainsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DomainsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void searchDomainsTest() throws Exception {
    SearchDomainsResponse expectedResponse =
        SearchDomainsResponse.newBuilder()
            .addAllRegisterParameters(new ArrayList<RegisterParameters>())
            .build();
    mockDomains.addResponse(expectedResponse);

    LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
    String query = "query107944136";

    SearchDomainsResponse actualResponse = client.searchDomains(location, query);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchDomainsRequest actualRequest = ((SearchDomainsRequest) actualRequests.get(0));

    Assert.assertEquals(location.toString(), actualRequest.getLocation());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchDomainsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
      String query = "query107944136";
      client.searchDomains(location, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchDomainsTest2() throws Exception {
    SearchDomainsResponse expectedResponse =
        SearchDomainsResponse.newBuilder()
            .addAllRegisterParameters(new ArrayList<RegisterParameters>())
            .build();
    mockDomains.addResponse(expectedResponse);

    String location = "location1901043637";
    String query = "query107944136";

    SearchDomainsResponse actualResponse = client.searchDomains(location, query);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchDomainsRequest actualRequest = ((SearchDomainsRequest) actualRequests.get(0));

    Assert.assertEquals(location, actualRequest.getLocation());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchDomainsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      String location = "location1901043637";
      String query = "query107944136";
      client.searchDomains(location, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retrieveRegisterParametersTest() throws Exception {
    RetrieveRegisterParametersResponse expectedResponse =
        RetrieveRegisterParametersResponse.newBuilder()
            .setRegisterParameters(RegisterParameters.newBuilder().build())
            .build();
    mockDomains.addResponse(expectedResponse);

    LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
    String domainName = "domainName-1244085905";

    RetrieveRegisterParametersResponse actualResponse =
        client.retrieveRegisterParameters(location, domainName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveRegisterParametersRequest actualRequest =
        ((RetrieveRegisterParametersRequest) actualRequests.get(0));

    Assert.assertEquals(location.toString(), actualRequest.getLocation());
    Assert.assertEquals(domainName, actualRequest.getDomainName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveRegisterParametersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
      String domainName = "domainName-1244085905";
      client.retrieveRegisterParameters(location, domainName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retrieveRegisterParametersTest2() throws Exception {
    RetrieveRegisterParametersResponse expectedResponse =
        RetrieveRegisterParametersResponse.newBuilder()
            .setRegisterParameters(RegisterParameters.newBuilder().build())
            .build();
    mockDomains.addResponse(expectedResponse);

    String location = "location1901043637";
    String domainName = "domainName-1244085905";

    RetrieveRegisterParametersResponse actualResponse =
        client.retrieveRegisterParameters(location, domainName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveRegisterParametersRequest actualRequest =
        ((RetrieveRegisterParametersRequest) actualRequests.get(0));

    Assert.assertEquals(location, actualRequest.getLocation());
    Assert.assertEquals(domainName, actualRequest.getDomainName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveRegisterParametersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      String location = "location1901043637";
      String domainName = "domainName-1244085905";
      client.retrieveRegisterParameters(location, domainName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void registerDomainTest() throws Exception {
    Registration expectedResponse =
        Registration.newBuilder()
            .setName(RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
            .setDomainName("domainName-1244085905")
            .setCreateTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllIssues(new ArrayList<Registration.Issue>())
            .putAllLabels(new HashMap<String, String>())
            .setManagementSettings(ManagementSettings.newBuilder().build())
            .setDnsSettings(DnsSettings.newBuilder().build())
            .setContactSettings(ContactSettings.newBuilder().build())
            .setPendingContactSettings(ContactSettings.newBuilder().build())
            .addAllSupportedPrivacy(new ArrayList<ContactPrivacy>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("registerDomainTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDomains.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Registration registration = Registration.newBuilder().build();
    Money yearlyPrice = Money.newBuilder().build();

    Registration actualResponse =
        client.registerDomainAsync(parent, registration, yearlyPrice).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RegisterDomainRequest actualRequest = ((RegisterDomainRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(registration, actualRequest.getRegistration());
    Assert.assertEquals(yearlyPrice, actualRequest.getYearlyPrice());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void registerDomainExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Registration registration = Registration.newBuilder().build();
      Money yearlyPrice = Money.newBuilder().build();
      client.registerDomainAsync(parent, registration, yearlyPrice).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void registerDomainTest2() throws Exception {
    Registration expectedResponse =
        Registration.newBuilder()
            .setName(RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
            .setDomainName("domainName-1244085905")
            .setCreateTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllIssues(new ArrayList<Registration.Issue>())
            .putAllLabels(new HashMap<String, String>())
            .setManagementSettings(ManagementSettings.newBuilder().build())
            .setDnsSettings(DnsSettings.newBuilder().build())
            .setContactSettings(ContactSettings.newBuilder().build())
            .setPendingContactSettings(ContactSettings.newBuilder().build())
            .addAllSupportedPrivacy(new ArrayList<ContactPrivacy>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("registerDomainTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDomains.addResponse(resultOperation);

    String parent = "parent-995424086";
    Registration registration = Registration.newBuilder().build();
    Money yearlyPrice = Money.newBuilder().build();

    Registration actualResponse =
        client.registerDomainAsync(parent, registration, yearlyPrice).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RegisterDomainRequest actualRequest = ((RegisterDomainRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(registration, actualRequest.getRegistration());
    Assert.assertEquals(yearlyPrice, actualRequest.getYearlyPrice());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void registerDomainExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      String parent = "parent-995424086";
      Registration registration = Registration.newBuilder().build();
      Money yearlyPrice = Money.newBuilder().build();
      client.registerDomainAsync(parent, registration, yearlyPrice).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void retrieveTransferParametersTest() throws Exception {
    RetrieveTransferParametersResponse expectedResponse =
        RetrieveTransferParametersResponse.newBuilder()
            .setTransferParameters(TransferParameters.newBuilder().build())
            .build();
    mockDomains.addResponse(expectedResponse);

    LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
    String domainName = "domainName-1244085905";

    RetrieveTransferParametersResponse actualResponse =
        client.retrieveTransferParameters(location, domainName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveTransferParametersRequest actualRequest =
        ((RetrieveTransferParametersRequest) actualRequests.get(0));

    Assert.assertEquals(location.toString(), actualRequest.getLocation());
    Assert.assertEquals(domainName, actualRequest.getDomainName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveTransferParametersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
      String domainName = "domainName-1244085905";
      client.retrieveTransferParameters(location, domainName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retrieveTransferParametersTest2() throws Exception {
    RetrieveTransferParametersResponse expectedResponse =
        RetrieveTransferParametersResponse.newBuilder()
            .setTransferParameters(TransferParameters.newBuilder().build())
            .build();
    mockDomains.addResponse(expectedResponse);

    String location = "location1901043637";
    String domainName = "domainName-1244085905";

    RetrieveTransferParametersResponse actualResponse =
        client.retrieveTransferParameters(location, domainName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveTransferParametersRequest actualRequest =
        ((RetrieveTransferParametersRequest) actualRequests.get(0));

    Assert.assertEquals(location, actualRequest.getLocation());
    Assert.assertEquals(domainName, actualRequest.getDomainName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveTransferParametersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      String location = "location1901043637";
      String domainName = "domainName-1244085905";
      client.retrieveTransferParameters(location, domainName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void transferDomainTest() throws Exception {
    Registration expectedResponse =
        Registration.newBuilder()
            .setName(RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
            .setDomainName("domainName-1244085905")
            .setCreateTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllIssues(new ArrayList<Registration.Issue>())
            .putAllLabels(new HashMap<String, String>())
            .setManagementSettings(ManagementSettings.newBuilder().build())
            .setDnsSettings(DnsSettings.newBuilder().build())
            .setContactSettings(ContactSettings.newBuilder().build())
            .setPendingContactSettings(ContactSettings.newBuilder().build())
            .addAllSupportedPrivacy(new ArrayList<ContactPrivacy>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("transferDomainTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDomains.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Registration registration = Registration.newBuilder().build();
    Money yearlyPrice = Money.newBuilder().build();
    AuthorizationCode authorizationCode = AuthorizationCode.newBuilder().build();

    Registration actualResponse =
        client.transferDomainAsync(parent, registration, yearlyPrice, authorizationCode).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TransferDomainRequest actualRequest = ((TransferDomainRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(registration, actualRequest.getRegistration());
    Assert.assertEquals(yearlyPrice, actualRequest.getYearlyPrice());
    Assert.assertEquals(authorizationCode, actualRequest.getAuthorizationCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void transferDomainExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Registration registration = Registration.newBuilder().build();
      Money yearlyPrice = Money.newBuilder().build();
      AuthorizationCode authorizationCode = AuthorizationCode.newBuilder().build();
      client.transferDomainAsync(parent, registration, yearlyPrice, authorizationCode).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void transferDomainTest2() throws Exception {
    Registration expectedResponse =
        Registration.newBuilder()
            .setName(RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
            .setDomainName("domainName-1244085905")
            .setCreateTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllIssues(new ArrayList<Registration.Issue>())
            .putAllLabels(new HashMap<String, String>())
            .setManagementSettings(ManagementSettings.newBuilder().build())
            .setDnsSettings(DnsSettings.newBuilder().build())
            .setContactSettings(ContactSettings.newBuilder().build())
            .setPendingContactSettings(ContactSettings.newBuilder().build())
            .addAllSupportedPrivacy(new ArrayList<ContactPrivacy>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("transferDomainTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDomains.addResponse(resultOperation);

    String parent = "parent-995424086";
    Registration registration = Registration.newBuilder().build();
    Money yearlyPrice = Money.newBuilder().build();
    AuthorizationCode authorizationCode = AuthorizationCode.newBuilder().build();

    Registration actualResponse =
        client.transferDomainAsync(parent, registration, yearlyPrice, authorizationCode).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TransferDomainRequest actualRequest = ((TransferDomainRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(registration, actualRequest.getRegistration());
    Assert.assertEquals(yearlyPrice, actualRequest.getYearlyPrice());
    Assert.assertEquals(authorizationCode, actualRequest.getAuthorizationCode());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void transferDomainExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      String parent = "parent-995424086";
      Registration registration = Registration.newBuilder().build();
      Money yearlyPrice = Money.newBuilder().build();
      AuthorizationCode authorizationCode = AuthorizationCode.newBuilder().build();
      client.transferDomainAsync(parent, registration, yearlyPrice, authorizationCode).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listRegistrationsTest() throws Exception {
    Registration responsesElement = Registration.newBuilder().build();
    ListRegistrationsResponse expectedResponse =
        ListRegistrationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRegistrations(Arrays.asList(responsesElement))
            .build();
    mockDomains.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRegistrationsPagedResponse pagedListResponse = client.listRegistrations(parent);

    List<Registration> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRegistrationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRegistrationsRequest actualRequest = ((ListRegistrationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRegistrationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listRegistrations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRegistrationsTest2() throws Exception {
    Registration responsesElement = Registration.newBuilder().build();
    ListRegistrationsResponse expectedResponse =
        ListRegistrationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRegistrations(Arrays.asList(responsesElement))
            .build();
    mockDomains.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRegistrationsPagedResponse pagedListResponse = client.listRegistrations(parent);

    List<Registration> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRegistrationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRegistrationsRequest actualRequest = ((ListRegistrationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRegistrationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRegistrations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRegistrationTest() throws Exception {
    Registration expectedResponse =
        Registration.newBuilder()
            .setName(RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
            .setDomainName("domainName-1244085905")
            .setCreateTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllIssues(new ArrayList<Registration.Issue>())
            .putAllLabels(new HashMap<String, String>())
            .setManagementSettings(ManagementSettings.newBuilder().build())
            .setDnsSettings(DnsSettings.newBuilder().build())
            .setContactSettings(ContactSettings.newBuilder().build())
            .setPendingContactSettings(ContactSettings.newBuilder().build())
            .addAllSupportedPrivacy(new ArrayList<ContactPrivacy>())
            .build();
    mockDomains.addResponse(expectedResponse);

    RegistrationName name = RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]");

    Registration actualResponse = client.getRegistration(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRegistrationRequest actualRequest = ((GetRegistrationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRegistrationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      RegistrationName name = RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]");
      client.getRegistration(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRegistrationTest2() throws Exception {
    Registration expectedResponse =
        Registration.newBuilder()
            .setName(RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
            .setDomainName("domainName-1244085905")
            .setCreateTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllIssues(new ArrayList<Registration.Issue>())
            .putAllLabels(new HashMap<String, String>())
            .setManagementSettings(ManagementSettings.newBuilder().build())
            .setDnsSettings(DnsSettings.newBuilder().build())
            .setContactSettings(ContactSettings.newBuilder().build())
            .setPendingContactSettings(ContactSettings.newBuilder().build())
            .addAllSupportedPrivacy(new ArrayList<ContactPrivacy>())
            .build();
    mockDomains.addResponse(expectedResponse);

    String name = "name3373707";

    Registration actualResponse = client.getRegistration(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRegistrationRequest actualRequest = ((GetRegistrationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRegistrationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      String name = "name3373707";
      client.getRegistration(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateRegistrationTest() throws Exception {
    Registration expectedResponse =
        Registration.newBuilder()
            .setName(RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
            .setDomainName("domainName-1244085905")
            .setCreateTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllIssues(new ArrayList<Registration.Issue>())
            .putAllLabels(new HashMap<String, String>())
            .setManagementSettings(ManagementSettings.newBuilder().build())
            .setDnsSettings(DnsSettings.newBuilder().build())
            .setContactSettings(ContactSettings.newBuilder().build())
            .setPendingContactSettings(ContactSettings.newBuilder().build())
            .addAllSupportedPrivacy(new ArrayList<ContactPrivacy>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateRegistrationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDomains.addResponse(resultOperation);

    Registration registration = Registration.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Registration actualResponse = client.updateRegistrationAsync(registration, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateRegistrationRequest actualRequest = ((UpdateRegistrationRequest) actualRequests.get(0));

    Assert.assertEquals(registration, actualRequest.getRegistration());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateRegistrationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      Registration registration = Registration.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRegistrationAsync(registration, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void configureManagementSettingsTest() throws Exception {
    Registration expectedResponse =
        Registration.newBuilder()
            .setName(RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
            .setDomainName("domainName-1244085905")
            .setCreateTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllIssues(new ArrayList<Registration.Issue>())
            .putAllLabels(new HashMap<String, String>())
            .setManagementSettings(ManagementSettings.newBuilder().build())
            .setDnsSettings(DnsSettings.newBuilder().build())
            .setContactSettings(ContactSettings.newBuilder().build())
            .setPendingContactSettings(ContactSettings.newBuilder().build())
            .addAllSupportedPrivacy(new ArrayList<ContactPrivacy>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("configureManagementSettingsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDomains.addResponse(resultOperation);

    RegistrationName registration =
        RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]");
    ManagementSettings managementSettings = ManagementSettings.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Registration actualResponse =
        client.configureManagementSettingsAsync(registration, managementSettings, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ConfigureManagementSettingsRequest actualRequest =
        ((ConfigureManagementSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(registration.toString(), actualRequest.getRegistration());
    Assert.assertEquals(managementSettings, actualRequest.getManagementSettings());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void configureManagementSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      RegistrationName registration =
          RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]");
      ManagementSettings managementSettings = ManagementSettings.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.configureManagementSettingsAsync(registration, managementSettings, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void configureManagementSettingsTest2() throws Exception {
    Registration expectedResponse =
        Registration.newBuilder()
            .setName(RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
            .setDomainName("domainName-1244085905")
            .setCreateTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllIssues(new ArrayList<Registration.Issue>())
            .putAllLabels(new HashMap<String, String>())
            .setManagementSettings(ManagementSettings.newBuilder().build())
            .setDnsSettings(DnsSettings.newBuilder().build())
            .setContactSettings(ContactSettings.newBuilder().build())
            .setPendingContactSettings(ContactSettings.newBuilder().build())
            .addAllSupportedPrivacy(new ArrayList<ContactPrivacy>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("configureManagementSettingsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDomains.addResponse(resultOperation);

    String registration = "registration-1350309703";
    ManagementSettings managementSettings = ManagementSettings.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Registration actualResponse =
        client.configureManagementSettingsAsync(registration, managementSettings, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ConfigureManagementSettingsRequest actualRequest =
        ((ConfigureManagementSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(registration, actualRequest.getRegistration());
    Assert.assertEquals(managementSettings, actualRequest.getManagementSettings());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void configureManagementSettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      String registration = "registration-1350309703";
      ManagementSettings managementSettings = ManagementSettings.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.configureManagementSettingsAsync(registration, managementSettings, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void configureDnsSettingsTest() throws Exception {
    Registration expectedResponse =
        Registration.newBuilder()
            .setName(RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
            .setDomainName("domainName-1244085905")
            .setCreateTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllIssues(new ArrayList<Registration.Issue>())
            .putAllLabels(new HashMap<String, String>())
            .setManagementSettings(ManagementSettings.newBuilder().build())
            .setDnsSettings(DnsSettings.newBuilder().build())
            .setContactSettings(ContactSettings.newBuilder().build())
            .setPendingContactSettings(ContactSettings.newBuilder().build())
            .addAllSupportedPrivacy(new ArrayList<ContactPrivacy>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("configureDnsSettingsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDomains.addResponse(resultOperation);

    RegistrationName registration =
        RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]");
    DnsSettings dnsSettings = DnsSettings.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Registration actualResponse =
        client.configureDnsSettingsAsync(registration, dnsSettings, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ConfigureDnsSettingsRequest actualRequest =
        ((ConfigureDnsSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(registration.toString(), actualRequest.getRegistration());
    Assert.assertEquals(dnsSettings, actualRequest.getDnsSettings());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void configureDnsSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      RegistrationName registration =
          RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]");
      DnsSettings dnsSettings = DnsSettings.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.configureDnsSettingsAsync(registration, dnsSettings, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void configureDnsSettingsTest2() throws Exception {
    Registration expectedResponse =
        Registration.newBuilder()
            .setName(RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
            .setDomainName("domainName-1244085905")
            .setCreateTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllIssues(new ArrayList<Registration.Issue>())
            .putAllLabels(new HashMap<String, String>())
            .setManagementSettings(ManagementSettings.newBuilder().build())
            .setDnsSettings(DnsSettings.newBuilder().build())
            .setContactSettings(ContactSettings.newBuilder().build())
            .setPendingContactSettings(ContactSettings.newBuilder().build())
            .addAllSupportedPrivacy(new ArrayList<ContactPrivacy>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("configureDnsSettingsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDomains.addResponse(resultOperation);

    String registration = "registration-1350309703";
    DnsSettings dnsSettings = DnsSettings.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Registration actualResponse =
        client.configureDnsSettingsAsync(registration, dnsSettings, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ConfigureDnsSettingsRequest actualRequest =
        ((ConfigureDnsSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(registration, actualRequest.getRegistration());
    Assert.assertEquals(dnsSettings, actualRequest.getDnsSettings());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void configureDnsSettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      String registration = "registration-1350309703";
      DnsSettings dnsSettings = DnsSettings.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.configureDnsSettingsAsync(registration, dnsSettings, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void configureContactSettingsTest() throws Exception {
    Registration expectedResponse =
        Registration.newBuilder()
            .setName(RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
            .setDomainName("domainName-1244085905")
            .setCreateTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllIssues(new ArrayList<Registration.Issue>())
            .putAllLabels(new HashMap<String, String>())
            .setManagementSettings(ManagementSettings.newBuilder().build())
            .setDnsSettings(DnsSettings.newBuilder().build())
            .setContactSettings(ContactSettings.newBuilder().build())
            .setPendingContactSettings(ContactSettings.newBuilder().build())
            .addAllSupportedPrivacy(new ArrayList<ContactPrivacy>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("configureContactSettingsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDomains.addResponse(resultOperation);

    RegistrationName registration =
        RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]");
    ContactSettings contactSettings = ContactSettings.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Registration actualResponse =
        client.configureContactSettingsAsync(registration, contactSettings, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ConfigureContactSettingsRequest actualRequest =
        ((ConfigureContactSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(registration.toString(), actualRequest.getRegistration());
    Assert.assertEquals(contactSettings, actualRequest.getContactSettings());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void configureContactSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      RegistrationName registration =
          RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]");
      ContactSettings contactSettings = ContactSettings.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.configureContactSettingsAsync(registration, contactSettings, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void configureContactSettingsTest2() throws Exception {
    Registration expectedResponse =
        Registration.newBuilder()
            .setName(RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
            .setDomainName("domainName-1244085905")
            .setCreateTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllIssues(new ArrayList<Registration.Issue>())
            .putAllLabels(new HashMap<String, String>())
            .setManagementSettings(ManagementSettings.newBuilder().build())
            .setDnsSettings(DnsSettings.newBuilder().build())
            .setContactSettings(ContactSettings.newBuilder().build())
            .setPendingContactSettings(ContactSettings.newBuilder().build())
            .addAllSupportedPrivacy(new ArrayList<ContactPrivacy>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("configureContactSettingsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDomains.addResponse(resultOperation);

    String registration = "registration-1350309703";
    ContactSettings contactSettings = ContactSettings.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Registration actualResponse =
        client.configureContactSettingsAsync(registration, contactSettings, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ConfigureContactSettingsRequest actualRequest =
        ((ConfigureContactSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(registration, actualRequest.getRegistration());
    Assert.assertEquals(contactSettings, actualRequest.getContactSettings());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void configureContactSettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      String registration = "registration-1350309703";
      ContactSettings contactSettings = ContactSettings.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.configureContactSettingsAsync(registration, contactSettings, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportRegistrationTest() throws Exception {
    Registration expectedResponse =
        Registration.newBuilder()
            .setName(RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
            .setDomainName("domainName-1244085905")
            .setCreateTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllIssues(new ArrayList<Registration.Issue>())
            .putAllLabels(new HashMap<String, String>())
            .setManagementSettings(ManagementSettings.newBuilder().build())
            .setDnsSettings(DnsSettings.newBuilder().build())
            .setContactSettings(ContactSettings.newBuilder().build())
            .setPendingContactSettings(ContactSettings.newBuilder().build())
            .addAllSupportedPrivacy(new ArrayList<ContactPrivacy>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportRegistrationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDomains.addResponse(resultOperation);

    RegistrationName name = RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]");

    Registration actualResponse = client.exportRegistrationAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportRegistrationRequest actualRequest = ((ExportRegistrationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportRegistrationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      RegistrationName name = RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]");
      client.exportRegistrationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void exportRegistrationTest2() throws Exception {
    Registration expectedResponse =
        Registration.newBuilder()
            .setName(RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]").toString())
            .setDomainName("domainName-1244085905")
            .setCreateTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .addAllIssues(new ArrayList<Registration.Issue>())
            .putAllLabels(new HashMap<String, String>())
            .setManagementSettings(ManagementSettings.newBuilder().build())
            .setDnsSettings(DnsSettings.newBuilder().build())
            .setContactSettings(ContactSettings.newBuilder().build())
            .setPendingContactSettings(ContactSettings.newBuilder().build())
            .addAllSupportedPrivacy(new ArrayList<ContactPrivacy>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportRegistrationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDomains.addResponse(resultOperation);

    String name = "name3373707";

    Registration actualResponse = client.exportRegistrationAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportRegistrationRequest actualRequest = ((ExportRegistrationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportRegistrationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      String name = "name3373707";
      client.exportRegistrationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteRegistrationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRegistrationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDomains.addResponse(resultOperation);

    RegistrationName name = RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]");

    client.deleteRegistrationAsync(name).get();

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRegistrationRequest actualRequest = ((DeleteRegistrationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRegistrationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      RegistrationName name = RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]");
      client.deleteRegistrationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteRegistrationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteRegistrationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDomains.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteRegistrationAsync(name).get();

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRegistrationRequest actualRequest = ((DeleteRegistrationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRegistrationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRegistrationAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void retrieveAuthorizationCodeTest() throws Exception {
    AuthorizationCode expectedResponse =
        AuthorizationCode.newBuilder().setCode("code3059181").build();
    mockDomains.addResponse(expectedResponse);

    RegistrationName registration =
        RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]");

    AuthorizationCode actualResponse = client.retrieveAuthorizationCode(registration);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveAuthorizationCodeRequest actualRequest =
        ((RetrieveAuthorizationCodeRequest) actualRequests.get(0));

    Assert.assertEquals(registration.toString(), actualRequest.getRegistration());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveAuthorizationCodeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      RegistrationName registration =
          RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]");
      client.retrieveAuthorizationCode(registration);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retrieveAuthorizationCodeTest2() throws Exception {
    AuthorizationCode expectedResponse =
        AuthorizationCode.newBuilder().setCode("code3059181").build();
    mockDomains.addResponse(expectedResponse);

    String registration = "registration-1350309703";

    AuthorizationCode actualResponse = client.retrieveAuthorizationCode(registration);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveAuthorizationCodeRequest actualRequest =
        ((RetrieveAuthorizationCodeRequest) actualRequests.get(0));

    Assert.assertEquals(registration, actualRequest.getRegistration());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveAuthorizationCodeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      String registration = "registration-1350309703";
      client.retrieveAuthorizationCode(registration);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resetAuthorizationCodeTest() throws Exception {
    AuthorizationCode expectedResponse =
        AuthorizationCode.newBuilder().setCode("code3059181").build();
    mockDomains.addResponse(expectedResponse);

    RegistrationName registration =
        RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]");

    AuthorizationCode actualResponse = client.resetAuthorizationCode(registration);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResetAuthorizationCodeRequest actualRequest =
        ((ResetAuthorizationCodeRequest) actualRequests.get(0));

    Assert.assertEquals(registration.toString(), actualRequest.getRegistration());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resetAuthorizationCodeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      RegistrationName registration =
          RegistrationName.of("[PROJECT]", "[LOCATION]", "[REGISTRATION]");
      client.resetAuthorizationCode(registration);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resetAuthorizationCodeTest2() throws Exception {
    AuthorizationCode expectedResponse =
        AuthorizationCode.newBuilder().setCode("code3059181").build();
    mockDomains.addResponse(expectedResponse);

    String registration = "registration-1350309703";

    AuthorizationCode actualResponse = client.resetAuthorizationCode(registration);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDomains.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ResetAuthorizationCodeRequest actualRequest =
        ((ResetAuthorizationCodeRequest) actualRequests.get(0));

    Assert.assertEquals(registration, actualRequest.getRegistration());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void resetAuthorizationCodeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDomains.addException(exception);

    try {
      String registration = "registration-1350309703";
      client.resetAuthorizationCode(registration);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
