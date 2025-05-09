/*
 * Copyright 2025 Google LLC
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

package com.google.apps.meet.v2beta;

import static com.google.apps.meet.v2beta.SpacesServiceClient.ListMembersPagedResponse;

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
public class SpacesServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockSpacesService mockSpacesService;
  private LocalChannelProvider channelProvider;
  private SpacesServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSpacesService = new MockSpacesService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockSpacesService));
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
    SpacesServiceSettings settings =
        SpacesServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SpacesServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createSpaceTest() throws Exception {
    Space expectedResponse =
        Space.newBuilder()
            .setName(SpaceName.of("[SPACE]").toString())
            .setMeetingUri("meetingUri802788657")
            .setMeetingCode("meetingCode-883894584")
            .setConfig(SpaceConfig.newBuilder().build())
            .setActiveConference(ActiveConference.newBuilder().build())
            .build();
    mockSpacesService.addResponse(expectedResponse);

    Space space = Space.newBuilder().build();

    Space actualResponse = client.createSpace(space);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpacesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSpaceRequest actualRequest = ((CreateSpaceRequest) actualRequests.get(0));

    Assert.assertEquals(space, actualRequest.getSpace());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSpaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpacesService.addException(exception);

    try {
      Space space = Space.newBuilder().build();
      client.createSpace(space);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSpaceTest() throws Exception {
    Space expectedResponse =
        Space.newBuilder()
            .setName(SpaceName.of("[SPACE]").toString())
            .setMeetingUri("meetingUri802788657")
            .setMeetingCode("meetingCode-883894584")
            .setConfig(SpaceConfig.newBuilder().build())
            .setActiveConference(ActiveConference.newBuilder().build())
            .build();
    mockSpacesService.addResponse(expectedResponse);

    SpaceName name = SpaceName.of("[SPACE]");

    Space actualResponse = client.getSpace(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpacesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSpaceRequest actualRequest = ((GetSpaceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSpaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpacesService.addException(exception);

    try {
      SpaceName name = SpaceName.of("[SPACE]");
      client.getSpace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSpaceTest2() throws Exception {
    Space expectedResponse =
        Space.newBuilder()
            .setName(SpaceName.of("[SPACE]").toString())
            .setMeetingUri("meetingUri802788657")
            .setMeetingCode("meetingCode-883894584")
            .setConfig(SpaceConfig.newBuilder().build())
            .setActiveConference(ActiveConference.newBuilder().build())
            .build();
    mockSpacesService.addResponse(expectedResponse);

    String name = "name3373707";

    Space actualResponse = client.getSpace(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpacesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSpaceRequest actualRequest = ((GetSpaceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSpaceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpacesService.addException(exception);

    try {
      String name = "name3373707";
      client.getSpace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSpaceTest() throws Exception {
    Space expectedResponse =
        Space.newBuilder()
            .setName(SpaceName.of("[SPACE]").toString())
            .setMeetingUri("meetingUri802788657")
            .setMeetingCode("meetingCode-883894584")
            .setConfig(SpaceConfig.newBuilder().build())
            .setActiveConference(ActiveConference.newBuilder().build())
            .build();
    mockSpacesService.addResponse(expectedResponse);

    Space space = Space.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Space actualResponse = client.updateSpace(space, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpacesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSpaceRequest actualRequest = ((UpdateSpaceRequest) actualRequests.get(0));

    Assert.assertEquals(space, actualRequest.getSpace());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSpaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpacesService.addException(exception);

    try {
      Space space = Space.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSpace(space, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void connectActiveConferenceTest() throws Exception {
    ConnectActiveConferenceResponse expectedResponse =
        ConnectActiveConferenceResponse.newBuilder()
            .setAnswer("answer-1412808770")
            .setTraceId("traceId-1067401920")
            .build();
    mockSpacesService.addResponse(expectedResponse);

    SpaceName name = SpaceName.of("[SPACE]");

    ConnectActiveConferenceResponse actualResponse = client.connectActiveConference(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpacesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ConnectActiveConferenceRequest actualRequest =
        ((ConnectActiveConferenceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void connectActiveConferenceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpacesService.addException(exception);

    try {
      SpaceName name = SpaceName.of("[SPACE]");
      client.connectActiveConference(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void connectActiveConferenceTest2() throws Exception {
    ConnectActiveConferenceResponse expectedResponse =
        ConnectActiveConferenceResponse.newBuilder()
            .setAnswer("answer-1412808770")
            .setTraceId("traceId-1067401920")
            .build();
    mockSpacesService.addResponse(expectedResponse);

    String name = "name3373707";

    ConnectActiveConferenceResponse actualResponse = client.connectActiveConference(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpacesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ConnectActiveConferenceRequest actualRequest =
        ((ConnectActiveConferenceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void connectActiveConferenceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpacesService.addException(exception);

    try {
      String name = "name3373707";
      client.connectActiveConference(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void endActiveConferenceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSpacesService.addResponse(expectedResponse);

    SpaceName name = SpaceName.of("[SPACE]");

    client.endActiveConference(name);

    List<AbstractMessage> actualRequests = mockSpacesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EndActiveConferenceRequest actualRequest = ((EndActiveConferenceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void endActiveConferenceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpacesService.addException(exception);

    try {
      SpaceName name = SpaceName.of("[SPACE]");
      client.endActiveConference(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void endActiveConferenceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSpacesService.addResponse(expectedResponse);

    String name = "name3373707";

    client.endActiveConference(name);

    List<AbstractMessage> actualRequests = mockSpacesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EndActiveConferenceRequest actualRequest = ((EndActiveConferenceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void endActiveConferenceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpacesService.addException(exception);

    try {
      String name = "name3373707";
      client.endActiveConference(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMemberTest() throws Exception {
    Member expectedResponse =
        Member.newBuilder()
            .setName(MemberName.of("[SPACE]", "[MEMBER]").toString())
            .setEmail("email96619420")
            .setUser("user3599307")
            .build();
    mockSpacesService.addResponse(expectedResponse);

    SpaceName parent = SpaceName.of("[SPACE]");
    Member member = Member.newBuilder().build();

    Member actualResponse = client.createMember(parent, member);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpacesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMemberRequest actualRequest = ((CreateMemberRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(member, actualRequest.getMember());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMemberExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpacesService.addException(exception);

    try {
      SpaceName parent = SpaceName.of("[SPACE]");
      Member member = Member.newBuilder().build();
      client.createMember(parent, member);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMemberTest2() throws Exception {
    Member expectedResponse =
        Member.newBuilder()
            .setName(MemberName.of("[SPACE]", "[MEMBER]").toString())
            .setEmail("email96619420")
            .setUser("user3599307")
            .build();
    mockSpacesService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Member member = Member.newBuilder().build();

    Member actualResponse = client.createMember(parent, member);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpacesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMemberRequest actualRequest = ((CreateMemberRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(member, actualRequest.getMember());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMemberExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpacesService.addException(exception);

    try {
      String parent = "parent-995424086";
      Member member = Member.newBuilder().build();
      client.createMember(parent, member);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMemberTest() throws Exception {
    Member expectedResponse =
        Member.newBuilder()
            .setName(MemberName.of("[SPACE]", "[MEMBER]").toString())
            .setEmail("email96619420")
            .setUser("user3599307")
            .build();
    mockSpacesService.addResponse(expectedResponse);

    MemberName name = MemberName.of("[SPACE]", "[MEMBER]");

    Member actualResponse = client.getMember(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpacesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMemberRequest actualRequest = ((GetMemberRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMemberExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpacesService.addException(exception);

    try {
      MemberName name = MemberName.of("[SPACE]", "[MEMBER]");
      client.getMember(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMemberTest2() throws Exception {
    Member expectedResponse =
        Member.newBuilder()
            .setName(MemberName.of("[SPACE]", "[MEMBER]").toString())
            .setEmail("email96619420")
            .setUser("user3599307")
            .build();
    mockSpacesService.addResponse(expectedResponse);

    String name = "name3373707";

    Member actualResponse = client.getMember(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSpacesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMemberRequest actualRequest = ((GetMemberRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMemberExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpacesService.addException(exception);

    try {
      String name = "name3373707";
      client.getMember(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMembersTest() throws Exception {
    Member responsesElement = Member.newBuilder().build();
    ListMembersResponse expectedResponse =
        ListMembersResponse.newBuilder()
            .setNextPageToken("")
            .addAllMembers(Arrays.asList(responsesElement))
            .build();
    mockSpacesService.addResponse(expectedResponse);

    SpaceName parent = SpaceName.of("[SPACE]");

    ListMembersPagedResponse pagedListResponse = client.listMembers(parent);

    List<Member> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMembersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSpacesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMembersRequest actualRequest = ((ListMembersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMembersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpacesService.addException(exception);

    try {
      SpaceName parent = SpaceName.of("[SPACE]");
      client.listMembers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMembersTest2() throws Exception {
    Member responsesElement = Member.newBuilder().build();
    ListMembersResponse expectedResponse =
        ListMembersResponse.newBuilder()
            .setNextPageToken("")
            .addAllMembers(Arrays.asList(responsesElement))
            .build();
    mockSpacesService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMembersPagedResponse pagedListResponse = client.listMembers(parent);

    List<Member> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMembersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSpacesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMembersRequest actualRequest = ((ListMembersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMembersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpacesService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMembers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMemberTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSpacesService.addResponse(expectedResponse);

    MemberName name = MemberName.of("[SPACE]", "[MEMBER]");

    client.deleteMember(name);

    List<AbstractMessage> actualRequests = mockSpacesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMemberRequest actualRequest = ((DeleteMemberRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMemberExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpacesService.addException(exception);

    try {
      MemberName name = MemberName.of("[SPACE]", "[MEMBER]");
      client.deleteMember(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMemberTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSpacesService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteMember(name);

    List<AbstractMessage> actualRequests = mockSpacesService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMemberRequest actualRequest = ((DeleteMemberRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMemberExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpacesService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteMember(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
