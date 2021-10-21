/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.dialogflow.cx.v3;

import static com.google.cloud.dialogflow.cx.v3.ChangelogsClient.ListChangelogsPagedResponse;

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
public class ChangelogsClientTest {
  private static MockChangelogs mockChangelogs;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ChangelogsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockChangelogs = new MockChangelogs();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockChangelogs));
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
    ChangelogsSettings settings =
        ChangelogsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ChangelogsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listChangelogsTest() throws Exception {
    Changelog responsesElement = Changelog.newBuilder().build();
    ListChangelogsResponse expectedResponse =
        ListChangelogsResponse.newBuilder()
            .setNextPageToken("")
            .addAllChangelogs(Arrays.asList(responsesElement))
            .build();
    mockChangelogs.addResponse(expectedResponse);

    AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");

    ListChangelogsPagedResponse pagedListResponse = client.listChangelogs(parent);

    List<Changelog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChangelogsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockChangelogs.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListChangelogsRequest actualRequest = ((ListChangelogsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listChangelogsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChangelogs.addException(exception);

    try {
      AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
      client.listChangelogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listChangelogsTest2() throws Exception {
    Changelog responsesElement = Changelog.newBuilder().build();
    ListChangelogsResponse expectedResponse =
        ListChangelogsResponse.newBuilder()
            .setNextPageToken("")
            .addAllChangelogs(Arrays.asList(responsesElement))
            .build();
    mockChangelogs.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListChangelogsPagedResponse pagedListResponse = client.listChangelogs(parent);

    List<Changelog> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getChangelogsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockChangelogs.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListChangelogsRequest actualRequest = ((ListChangelogsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listChangelogsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChangelogs.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listChangelogs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getChangelogTest() throws Exception {
    Changelog expectedResponse =
        Changelog.newBuilder()
            .setName(
                ChangelogName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[CHANGELOG]").toString())
            .setUserEmail("userEmail315299473")
            .setDisplayName("displayName1714148973")
            .setAction("action-1422950858")
            .setType("type3575610")
            .setResource("resource-341064690")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockChangelogs.addResponse(expectedResponse);

    ChangelogName name = ChangelogName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[CHANGELOG]");

    Changelog actualResponse = client.getChangelog(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChangelogs.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetChangelogRequest actualRequest = ((GetChangelogRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getChangelogExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChangelogs.addException(exception);

    try {
      ChangelogName name = ChangelogName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[CHANGELOG]");
      client.getChangelog(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getChangelogTest2() throws Exception {
    Changelog expectedResponse =
        Changelog.newBuilder()
            .setName(
                ChangelogName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[CHANGELOG]").toString())
            .setUserEmail("userEmail315299473")
            .setDisplayName("displayName1714148973")
            .setAction("action-1422950858")
            .setType("type3575610")
            .setResource("resource-341064690")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockChangelogs.addResponse(expectedResponse);

    String name = "name3373707";

    Changelog actualResponse = client.getChangelog(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChangelogs.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetChangelogRequest actualRequest = ((GetChangelogRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getChangelogExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChangelogs.addException(exception);

    try {
      String name = "name3373707";
      client.getChangelog(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
