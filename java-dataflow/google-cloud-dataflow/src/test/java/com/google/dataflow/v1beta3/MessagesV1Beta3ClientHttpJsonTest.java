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

package com.google.dataflow.v1beta3;

import static com.google.dataflow.v1beta3.MessagesV1Beta3Client.ListJobMessagesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import com.google.dataflow.v1beta3.stub.HttpJsonMessagesV1Beta3Stub;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class MessagesV1Beta3ClientHttpJsonTest {
  private static MockHttpService mockService;
  private static MessagesV1Beta3Client client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonMessagesV1Beta3Stub.getMethodDescriptors(),
            MessagesV1Beta3Settings.getDefaultEndpoint());
    MessagesV1Beta3Settings settings =
        MessagesV1Beta3Settings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                MessagesV1Beta3Settings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MessagesV1Beta3Client.create(settings);
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
  public void listJobMessagesTest() throws Exception {
    JobMessage responsesElement = JobMessage.newBuilder().build();
    ListJobMessagesResponse expectedResponse =
        ListJobMessagesResponse.newBuilder()
            .setNextPageToken("")
            .addAllJobMessages(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListJobMessagesRequest request =
        ListJobMessagesRequest.newBuilder()
            .setProjectId("projectId-1530")
            .setJobId("jobId-3646")
            .setMinimumImportance(JobMessageImportance.forNumber(0))
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setLocation("location-9355")
            .build();

    ListJobMessagesPagedResponse pagedListResponse = client.listJobMessages(request);

    List<JobMessage> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobMessagesList().get(0), resources.get(0));

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
  public void listJobMessagesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListJobMessagesRequest request =
          ListJobMessagesRequest.newBuilder()
              .setProjectId("projectId-1530")
              .setJobId("jobId-3646")
              .setMinimumImportance(JobMessageImportance.forNumber(0))
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setStartTime(Timestamp.newBuilder().build())
              .setEndTime(Timestamp.newBuilder().build())
              .setLocation("location-9355")
              .build();
      client.listJobMessages(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
