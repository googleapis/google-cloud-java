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

import static com.google.shopping.merchant.accounts.v1beta.ProgramsServiceClient.ListProgramsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
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
public class ProgramsServiceClientTest {
  private static MockProgramsService mockProgramsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ProgramsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockProgramsService = new MockProgramsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockProgramsService));
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
    ProgramsServiceSettings settings =
        ProgramsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ProgramsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getProgramTest() throws Exception {
    Program expectedResponse =
        Program.newBuilder()
            .setName(ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString())
            .setDocumentationUri("documentationUri-1487620014")
            .addAllActiveRegionCodes(new ArrayList<String>())
            .addAllUnmetRequirements(new ArrayList<Program.Requirement>())
            .build();
    mockProgramsService.addResponse(expectedResponse);

    ProgramName name = ProgramName.of("[ACCOUNT]", "[PROGRAM]");

    Program actualResponse = client.getProgram(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProgramsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProgramRequest actualRequest = ((GetProgramRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProgramExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProgramsService.addException(exception);

    try {
      ProgramName name = ProgramName.of("[ACCOUNT]", "[PROGRAM]");
      client.getProgram(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProgramTest2() throws Exception {
    Program expectedResponse =
        Program.newBuilder()
            .setName(ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString())
            .setDocumentationUri("documentationUri-1487620014")
            .addAllActiveRegionCodes(new ArrayList<String>())
            .addAllUnmetRequirements(new ArrayList<Program.Requirement>())
            .build();
    mockProgramsService.addResponse(expectedResponse);

    String name = "name3373707";

    Program actualResponse = client.getProgram(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProgramsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProgramRequest actualRequest = ((GetProgramRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProgramExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProgramsService.addException(exception);

    try {
      String name = "name3373707";
      client.getProgram(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProgramsTest() throws Exception {
    Program responsesElement = Program.newBuilder().build();
    ListProgramsResponse expectedResponse =
        ListProgramsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrograms(Arrays.asList(responsesElement))
            .build();
    mockProgramsService.addResponse(expectedResponse);

    AccountName parent = AccountName.of("[ACCOUNT]");

    ListProgramsPagedResponse pagedListResponse = client.listPrograms(parent);

    List<Program> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProgramsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockProgramsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProgramsRequest actualRequest = ((ListProgramsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProgramsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProgramsService.addException(exception);

    try {
      AccountName parent = AccountName.of("[ACCOUNT]");
      client.listPrograms(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProgramsTest2() throws Exception {
    Program responsesElement = Program.newBuilder().build();
    ListProgramsResponse expectedResponse =
        ListProgramsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPrograms(Arrays.asList(responsesElement))
            .build();
    mockProgramsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListProgramsPagedResponse pagedListResponse = client.listPrograms(parent);

    List<Program> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProgramsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockProgramsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProgramsRequest actualRequest = ((ListProgramsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProgramsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProgramsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPrograms(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enableProgramTest() throws Exception {
    Program expectedResponse =
        Program.newBuilder()
            .setName(ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString())
            .setDocumentationUri("documentationUri-1487620014")
            .addAllActiveRegionCodes(new ArrayList<String>())
            .addAllUnmetRequirements(new ArrayList<Program.Requirement>())
            .build();
    mockProgramsService.addResponse(expectedResponse);

    ProgramName name = ProgramName.of("[ACCOUNT]", "[PROGRAM]");

    Program actualResponse = client.enableProgram(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProgramsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EnableProgramRequest actualRequest = ((EnableProgramRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void enableProgramExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProgramsService.addException(exception);

    try {
      ProgramName name = ProgramName.of("[ACCOUNT]", "[PROGRAM]");
      client.enableProgram(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void enableProgramTest2() throws Exception {
    Program expectedResponse =
        Program.newBuilder()
            .setName(ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString())
            .setDocumentationUri("documentationUri-1487620014")
            .addAllActiveRegionCodes(new ArrayList<String>())
            .addAllUnmetRequirements(new ArrayList<Program.Requirement>())
            .build();
    mockProgramsService.addResponse(expectedResponse);

    String name = "name3373707";

    Program actualResponse = client.enableProgram(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProgramsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EnableProgramRequest actualRequest = ((EnableProgramRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void enableProgramExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProgramsService.addException(exception);

    try {
      String name = "name3373707";
      client.enableProgram(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void disableProgramTest() throws Exception {
    Program expectedResponse =
        Program.newBuilder()
            .setName(ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString())
            .setDocumentationUri("documentationUri-1487620014")
            .addAllActiveRegionCodes(new ArrayList<String>())
            .addAllUnmetRequirements(new ArrayList<Program.Requirement>())
            .build();
    mockProgramsService.addResponse(expectedResponse);

    ProgramName name = ProgramName.of("[ACCOUNT]", "[PROGRAM]");

    Program actualResponse = client.disableProgram(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProgramsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DisableProgramRequest actualRequest = ((DisableProgramRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void disableProgramExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProgramsService.addException(exception);

    try {
      ProgramName name = ProgramName.of("[ACCOUNT]", "[PROGRAM]");
      client.disableProgram(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void disableProgramTest2() throws Exception {
    Program expectedResponse =
        Program.newBuilder()
            .setName(ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString())
            .setDocumentationUri("documentationUri-1487620014")
            .addAllActiveRegionCodes(new ArrayList<String>())
            .addAllUnmetRequirements(new ArrayList<Program.Requirement>())
            .build();
    mockProgramsService.addResponse(expectedResponse);

    String name = "name3373707";

    Program actualResponse = client.disableProgram(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockProgramsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DisableProgramRequest actualRequest = ((DisableProgramRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void disableProgramExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockProgramsService.addException(exception);

    try {
      String name = "name3373707";
      client.disableProgram(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
