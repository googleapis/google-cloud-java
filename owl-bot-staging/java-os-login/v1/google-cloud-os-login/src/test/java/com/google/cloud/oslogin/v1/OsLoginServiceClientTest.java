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

package com.google.cloud.oslogin.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.oslogin.common.OsLoginProto;
import com.google.cloud.oslogin.common.PosixAccountName;
import com.google.cloud.oslogin.common.SshPublicKeyName;
import com.google.cloud.oslogin.common.UserName;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class OsLoginServiceClientTest {
  private static MockOsLoginService mockOsLoginService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private OsLoginServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockOsLoginService = new MockOsLoginService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockOsLoginService));
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
    OsLoginServiceSettings settings =
        OsLoginServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = OsLoginServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void deletePosixAccountTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockOsLoginService.addResponse(expectedResponse);

    PosixAccountName name = PosixAccountName.of("[USER]", "[PROJECT]");

    client.deletePosixAccount(name);

    List<AbstractMessage> actualRequests = mockOsLoginService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePosixAccountRequest actualRequest = ((DeletePosixAccountRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePosixAccountExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsLoginService.addException(exception);

    try {
      PosixAccountName name = PosixAccountName.of("[USER]", "[PROJECT]");
      client.deletePosixAccount(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePosixAccountTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockOsLoginService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deletePosixAccount(name);

    List<AbstractMessage> actualRequests = mockOsLoginService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePosixAccountRequest actualRequest = ((DeletePosixAccountRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePosixAccountExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsLoginService.addException(exception);

    try {
      String name = "name3373707";
      client.deletePosixAccount(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSshPublicKeyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockOsLoginService.addResponse(expectedResponse);

    SshPublicKeyName name = SshPublicKeyName.of("[USER]", "[FINGERPRINT]");

    client.deleteSshPublicKey(name);

    List<AbstractMessage> actualRequests = mockOsLoginService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSshPublicKeyRequest actualRequest = ((DeleteSshPublicKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSshPublicKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsLoginService.addException(exception);

    try {
      SshPublicKeyName name = SshPublicKeyName.of("[USER]", "[FINGERPRINT]");
      client.deleteSshPublicKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSshPublicKeyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockOsLoginService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteSshPublicKey(name);

    List<AbstractMessage> actualRequests = mockOsLoginService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSshPublicKeyRequest actualRequest = ((DeleteSshPublicKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSshPublicKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsLoginService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSshPublicKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLoginProfileTest() throws Exception {
    LoginProfile expectedResponse =
        LoginProfile.newBuilder()
            .setName("name3373707")
            .addAllPosixAccounts(new ArrayList<OsLoginProto.PosixAccount>())
            .putAllSshPublicKeys(new HashMap<String, OsLoginProto.SshPublicKey>())
            .build();
    mockOsLoginService.addResponse(expectedResponse);

    UserName name = UserName.of("[USER]");

    LoginProfile actualResponse = client.getLoginProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsLoginService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLoginProfileRequest actualRequest = ((GetLoginProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLoginProfileExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsLoginService.addException(exception);

    try {
      UserName name = UserName.of("[USER]");
      client.getLoginProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLoginProfileTest2() throws Exception {
    LoginProfile expectedResponse =
        LoginProfile.newBuilder()
            .setName("name3373707")
            .addAllPosixAccounts(new ArrayList<OsLoginProto.PosixAccount>())
            .putAllSshPublicKeys(new HashMap<String, OsLoginProto.SshPublicKey>())
            .build();
    mockOsLoginService.addResponse(expectedResponse);

    String name = "name3373707";

    LoginProfile actualResponse = client.getLoginProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsLoginService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLoginProfileRequest actualRequest = ((GetLoginProfileRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLoginProfileExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsLoginService.addException(exception);

    try {
      String name = "name3373707";
      client.getLoginProfile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSshPublicKeyTest() throws Exception {
    OsLoginProto.SshPublicKey expectedResponse =
        OsLoginProto.SshPublicKey.newBuilder()
            .setKey("key106079")
            .setExpirationTimeUsec(-2058878882)
            .setFingerprint("fingerprint-1375934236")
            .setName(SshPublicKeyName.of("[USER]", "[FINGERPRINT]").toString())
            .build();
    mockOsLoginService.addResponse(expectedResponse);

    SshPublicKeyName name = SshPublicKeyName.of("[USER]", "[FINGERPRINT]");

    OsLoginProto.SshPublicKey actualResponse = client.getSshPublicKey(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsLoginService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSshPublicKeyRequest actualRequest = ((GetSshPublicKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSshPublicKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsLoginService.addException(exception);

    try {
      SshPublicKeyName name = SshPublicKeyName.of("[USER]", "[FINGERPRINT]");
      client.getSshPublicKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSshPublicKeyTest2() throws Exception {
    OsLoginProto.SshPublicKey expectedResponse =
        OsLoginProto.SshPublicKey.newBuilder()
            .setKey("key106079")
            .setExpirationTimeUsec(-2058878882)
            .setFingerprint("fingerprint-1375934236")
            .setName(SshPublicKeyName.of("[USER]", "[FINGERPRINT]").toString())
            .build();
    mockOsLoginService.addResponse(expectedResponse);

    String name = "name3373707";

    OsLoginProto.SshPublicKey actualResponse = client.getSshPublicKey(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsLoginService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSshPublicKeyRequest actualRequest = ((GetSshPublicKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSshPublicKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsLoginService.addException(exception);

    try {
      String name = "name3373707";
      client.getSshPublicKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importSshPublicKeyTest() throws Exception {
    ImportSshPublicKeyResponse expectedResponse =
        ImportSshPublicKeyResponse.newBuilder()
            .setLoginProfile(LoginProfile.newBuilder().build())
            .build();
    mockOsLoginService.addResponse(expectedResponse);

    UserName parent = UserName.of("[USER]");
    OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();

    ImportSshPublicKeyResponse actualResponse = client.importSshPublicKey(parent, sshPublicKey);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsLoginService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportSshPublicKeyRequest actualRequest = ((ImportSshPublicKeyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(sshPublicKey, actualRequest.getSshPublicKey());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importSshPublicKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsLoginService.addException(exception);

    try {
      UserName parent = UserName.of("[USER]");
      OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
      client.importSshPublicKey(parent, sshPublicKey);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importSshPublicKeyTest2() throws Exception {
    ImportSshPublicKeyResponse expectedResponse =
        ImportSshPublicKeyResponse.newBuilder()
            .setLoginProfile(LoginProfile.newBuilder().build())
            .build();
    mockOsLoginService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();

    ImportSshPublicKeyResponse actualResponse = client.importSshPublicKey(parent, sshPublicKey);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsLoginService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportSshPublicKeyRequest actualRequest = ((ImportSshPublicKeyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(sshPublicKey, actualRequest.getSshPublicKey());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importSshPublicKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsLoginService.addException(exception);

    try {
      String parent = "parent-995424086";
      OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
      client.importSshPublicKey(parent, sshPublicKey);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importSshPublicKeyTest3() throws Exception {
    ImportSshPublicKeyResponse expectedResponse =
        ImportSshPublicKeyResponse.newBuilder()
            .setLoginProfile(LoginProfile.newBuilder().build())
            .build();
    mockOsLoginService.addResponse(expectedResponse);

    UserName parent = UserName.of("[USER]");
    OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
    String projectId = "projectId-894832108";

    ImportSshPublicKeyResponse actualResponse =
        client.importSshPublicKey(parent, sshPublicKey, projectId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsLoginService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportSshPublicKeyRequest actualRequest = ((ImportSshPublicKeyRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(sshPublicKey, actualRequest.getSshPublicKey());
    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importSshPublicKeyExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsLoginService.addException(exception);

    try {
      UserName parent = UserName.of("[USER]");
      OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
      String projectId = "projectId-894832108";
      client.importSshPublicKey(parent, sshPublicKey, projectId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importSshPublicKeyTest4() throws Exception {
    ImportSshPublicKeyResponse expectedResponse =
        ImportSshPublicKeyResponse.newBuilder()
            .setLoginProfile(LoginProfile.newBuilder().build())
            .build();
    mockOsLoginService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
    String projectId = "projectId-894832108";

    ImportSshPublicKeyResponse actualResponse =
        client.importSshPublicKey(parent, sshPublicKey, projectId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsLoginService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportSshPublicKeyRequest actualRequest = ((ImportSshPublicKeyRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(sshPublicKey, actualRequest.getSshPublicKey());
    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importSshPublicKeyExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsLoginService.addException(exception);

    try {
      String parent = "parent-995424086";
      OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
      String projectId = "projectId-894832108";
      client.importSshPublicKey(parent, sshPublicKey, projectId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSshPublicKeyTest() throws Exception {
    OsLoginProto.SshPublicKey expectedResponse =
        OsLoginProto.SshPublicKey.newBuilder()
            .setKey("key106079")
            .setExpirationTimeUsec(-2058878882)
            .setFingerprint("fingerprint-1375934236")
            .setName(SshPublicKeyName.of("[USER]", "[FINGERPRINT]").toString())
            .build();
    mockOsLoginService.addResponse(expectedResponse);

    SshPublicKeyName name = SshPublicKeyName.of("[USER]", "[FINGERPRINT]");
    OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();

    OsLoginProto.SshPublicKey actualResponse = client.updateSshPublicKey(name, sshPublicKey);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsLoginService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSshPublicKeyRequest actualRequest = ((UpdateSshPublicKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(sshPublicKey, actualRequest.getSshPublicKey());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSshPublicKeyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsLoginService.addException(exception);

    try {
      SshPublicKeyName name = SshPublicKeyName.of("[USER]", "[FINGERPRINT]");
      OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
      client.updateSshPublicKey(name, sshPublicKey);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSshPublicKeyTest2() throws Exception {
    OsLoginProto.SshPublicKey expectedResponse =
        OsLoginProto.SshPublicKey.newBuilder()
            .setKey("key106079")
            .setExpirationTimeUsec(-2058878882)
            .setFingerprint("fingerprint-1375934236")
            .setName(SshPublicKeyName.of("[USER]", "[FINGERPRINT]").toString())
            .build();
    mockOsLoginService.addResponse(expectedResponse);

    String name = "name3373707";
    OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();

    OsLoginProto.SshPublicKey actualResponse = client.updateSshPublicKey(name, sshPublicKey);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsLoginService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSshPublicKeyRequest actualRequest = ((UpdateSshPublicKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(sshPublicKey, actualRequest.getSshPublicKey());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSshPublicKeyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsLoginService.addException(exception);

    try {
      String name = "name3373707";
      OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
      client.updateSshPublicKey(name, sshPublicKey);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSshPublicKeyTest3() throws Exception {
    OsLoginProto.SshPublicKey expectedResponse =
        OsLoginProto.SshPublicKey.newBuilder()
            .setKey("key106079")
            .setExpirationTimeUsec(-2058878882)
            .setFingerprint("fingerprint-1375934236")
            .setName(SshPublicKeyName.of("[USER]", "[FINGERPRINT]").toString())
            .build();
    mockOsLoginService.addResponse(expectedResponse);

    SshPublicKeyName name = SshPublicKeyName.of("[USER]", "[FINGERPRINT]");
    OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    OsLoginProto.SshPublicKey actualResponse =
        client.updateSshPublicKey(name, sshPublicKey, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsLoginService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSshPublicKeyRequest actualRequest = ((UpdateSshPublicKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(sshPublicKey, actualRequest.getSshPublicKey());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSshPublicKeyExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsLoginService.addException(exception);

    try {
      SshPublicKeyName name = SshPublicKeyName.of("[USER]", "[FINGERPRINT]");
      OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSshPublicKey(name, sshPublicKey, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSshPublicKeyTest4() throws Exception {
    OsLoginProto.SshPublicKey expectedResponse =
        OsLoginProto.SshPublicKey.newBuilder()
            .setKey("key106079")
            .setExpirationTimeUsec(-2058878882)
            .setFingerprint("fingerprint-1375934236")
            .setName(SshPublicKeyName.of("[USER]", "[FINGERPRINT]").toString())
            .build();
    mockOsLoginService.addResponse(expectedResponse);

    String name = "name3373707";
    OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    OsLoginProto.SshPublicKey actualResponse =
        client.updateSshPublicKey(name, sshPublicKey, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockOsLoginService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSshPublicKeyRequest actualRequest = ((UpdateSshPublicKeyRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(sshPublicKey, actualRequest.getSshPublicKey());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSshPublicKeyExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockOsLoginService.addException(exception);

    try {
      String name = "name3373707";
      OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSshPublicKey(name, sshPublicKey, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
