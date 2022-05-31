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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Timestamp;
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
public class MessagesV1Beta3ClientTest {
  private static MockMessagesV1Beta3 mockMessagesV1Beta3;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private MessagesV1Beta3Client client;

  @BeforeClass
  public static void startStaticServer() {
    mockMessagesV1Beta3 = new MockMessagesV1Beta3();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockMessagesV1Beta3));
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
    MessagesV1Beta3Settings settings =
        MessagesV1Beta3Settings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MessagesV1Beta3Client.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listJobMessagesTest() throws Exception {
    JobMessage responsesElement = JobMessage.newBuilder().build();
    ListJobMessagesResponse expectedResponse =
        ListJobMessagesResponse.newBuilder()
            .setNextPageToken("")
            .addAllJobMessages(Arrays.asList(responsesElement))
            .build();
    mockMessagesV1Beta3.addResponse(expectedResponse);

    ListJobMessagesRequest request =
        ListJobMessagesRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setJobId("jobId101296568")
            .setMinimumImportance(JobMessageImportance.forNumber(0))
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setLocation("location1901043637")
            .build();

    ListJobMessagesPagedResponse pagedListResponse = client.listJobMessages(request);

    List<JobMessage> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobMessagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockMessagesV1Beta3.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListJobMessagesRequest actualRequest = ((ListJobMessagesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getJobId(), actualRequest.getJobId());
    Assert.assertEquals(request.getMinimumImportance(), actualRequest.getMinimumImportance());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getStartTime(), actualRequest.getStartTime());
    Assert.assertEquals(request.getEndTime(), actualRequest.getEndTime());
    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listJobMessagesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockMessagesV1Beta3.addException(exception);

    try {
      ListJobMessagesRequest request =
          ListJobMessagesRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setJobId("jobId101296568")
              .setMinimumImportance(JobMessageImportance.forNumber(0))
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setStartTime(Timestamp.newBuilder().build())
              .setEndTime(Timestamp.newBuilder().build())
              .setLocation("location1901043637")
              .build();
      client.listJobMessages(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
