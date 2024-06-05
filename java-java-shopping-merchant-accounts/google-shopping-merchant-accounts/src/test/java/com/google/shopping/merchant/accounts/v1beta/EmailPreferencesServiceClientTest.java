/*
 * Copyright 2024 Google LLC
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

package com.google.shopping.merchant.accounts.v1beta;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.FieldMask;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class EmailPreferencesServiceClientTest {
  private static MockEmailPreferencesService mockEmailPreferencesService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private EmailPreferencesServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockEmailPreferencesService = new MockEmailPreferencesService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockEmailPreferencesService));
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
    EmailPreferencesServiceSettings settings =
        EmailPreferencesServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = EmailPreferencesServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getEmailPreferencesTest() throws Exception {
    EmailPreferences expectedResponse =
        EmailPreferences.newBuilder()
            .setName(EmailPreferencesName.of("[ACCOUNT]", "[EMAIL]").toString())
            .build();
    mockEmailPreferencesService.addResponse(expectedResponse);

    EmailPreferencesName name = EmailPreferencesName.of("[ACCOUNT]", "[EMAIL]");

    EmailPreferences actualResponse = client.getEmailPreferences(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEmailPreferencesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEmailPreferencesRequest actualRequest = ((GetEmailPreferencesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEmailPreferencesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEmailPreferencesService.addException(exception);

    try {
      EmailPreferencesName name = EmailPreferencesName.of("[ACCOUNT]", "[EMAIL]");
      client.getEmailPreferences(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEmailPreferencesTest2() throws Exception {
    EmailPreferences expectedResponse =
        EmailPreferences.newBuilder()
            .setName(EmailPreferencesName.of("[ACCOUNT]", "[EMAIL]").toString())
            .build();
    mockEmailPreferencesService.addResponse(expectedResponse);

    String name = "name3373707";

    EmailPreferences actualResponse = client.getEmailPreferences(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEmailPreferencesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEmailPreferencesRequest actualRequest = ((GetEmailPreferencesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEmailPreferencesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEmailPreferencesService.addException(exception);

    try {
      String name = "name3373707";
      client.getEmailPreferences(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateEmailPreferencesTest() throws Exception {
    EmailPreferences expectedResponse =
        EmailPreferences.newBuilder()
            .setName(EmailPreferencesName.of("[ACCOUNT]", "[EMAIL]").toString())
            .build();
    mockEmailPreferencesService.addResponse(expectedResponse);

    EmailPreferences emailPreferences = EmailPreferences.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    EmailPreferences actualResponse = client.updateEmailPreferences(emailPreferences, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEmailPreferencesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEmailPreferencesRequest actualRequest =
        ((UpdateEmailPreferencesRequest) actualRequests.get(0));

    Assert.assertEquals(emailPreferences, actualRequest.getEmailPreferences());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEmailPreferencesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEmailPreferencesService.addException(exception);

    try {
      EmailPreferences emailPreferences = EmailPreferences.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEmailPreferences(emailPreferences, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
