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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.oslogin.common.OsLoginProto;
import com.google.cloud.oslogin.v1.stub.HttpJsonOsLoginServiceStub;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class OsLoginServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static OsLoginServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonOsLoginServiceStub.getMethodDescriptors(),
            OsLoginServiceSettings.getDefaultEndpoint());
    OsLoginServiceSettings settings =
        OsLoginServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                OsLoginServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = OsLoginServiceClient.create(settings);
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
  public void deletePosixAccountTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ProjectName name = ProjectName.of("[USER]", "[PROJECT]");

    client.deletePosixAccount(name);

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
  public void deletePosixAccountExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName name = ProjectName.of("[USER]", "[PROJECT]");
      client.deletePosixAccount(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePosixAccountTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "users/user-9716/projects/project-9716";

    client.deletePosixAccount(name);

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
  public void deletePosixAccountExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "users/user-9716/projects/project-9716";
      client.deletePosixAccount(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSshPublicKeyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    FingerprintName name = FingerprintName.of("[USER]", "[FINGERPRINT]");

    client.deleteSshPublicKey(name);

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
  public void deleteSshPublicKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FingerprintName name = FingerprintName.of("[USER]", "[FINGERPRINT]");
      client.deleteSshPublicKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSshPublicKeyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "users/user-7353/sshPublicKeys/sshPublicKey-7353";

    client.deleteSshPublicKey(name);

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
  public void deleteSshPublicKeyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "users/user-7353/sshPublicKeys/sshPublicKey-7353";
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
    mockService.addResponse(expectedResponse);

    UserName name = UserName.of("[USER]");

    LoginProfile actualResponse = client.getLoginProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

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
  public void getLoginProfileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "users/user-6376";

    LoginProfile actualResponse = client.getLoginProfile(name);
    Assert.assertEquals(expectedResponse, actualResponse);

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
  public void getLoginProfileExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "users/user-6376";
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
            .setName(FingerprintName.of("[USER]", "[FINGERPRINT]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    FingerprintName name = FingerprintName.of("[USER]", "[FINGERPRINT]");

    OsLoginProto.SshPublicKey actualResponse = client.getSshPublicKey(name);
    Assert.assertEquals(expectedResponse, actualResponse);

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
  public void getSshPublicKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FingerprintName name = FingerprintName.of("[USER]", "[FINGERPRINT]");
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
            .setName(FingerprintName.of("[USER]", "[FINGERPRINT]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "users/user-7353/sshPublicKeys/sshPublicKey-7353";

    OsLoginProto.SshPublicKey actualResponse = client.getSshPublicKey(name);
    Assert.assertEquals(expectedResponse, actualResponse);

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
  public void getSshPublicKeyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "users/user-7353/sshPublicKeys/sshPublicKey-7353";
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
    mockService.addResponse(expectedResponse);

    UserName parent = UserName.of("[USER]");
    OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();

    ImportSshPublicKeyResponse actualResponse = client.importSshPublicKey(parent, sshPublicKey);
    Assert.assertEquals(expectedResponse, actualResponse);

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
  public void importSshPublicKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "users/user-1015";
    OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();

    ImportSshPublicKeyResponse actualResponse = client.importSshPublicKey(parent, sshPublicKey);
    Assert.assertEquals(expectedResponse, actualResponse);

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
  public void importSshPublicKeyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "users/user-1015";
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
    mockService.addResponse(expectedResponse);

    UserName parent = UserName.of("[USER]");
    OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
    String projectId = "projectId-894832108";

    ImportSshPublicKeyResponse actualResponse =
        client.importSshPublicKey(parent, sshPublicKey, projectId);
    Assert.assertEquals(expectedResponse, actualResponse);

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
  public void importSshPublicKeyExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "users/user-1015";
    OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
    String projectId = "projectId-894832108";

    ImportSshPublicKeyResponse actualResponse =
        client.importSshPublicKey(parent, sshPublicKey, projectId);
    Assert.assertEquals(expectedResponse, actualResponse);

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
  public void importSshPublicKeyExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "users/user-1015";
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
            .setName(FingerprintName.of("[USER]", "[FINGERPRINT]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    FingerprintName name = FingerprintName.of("[USER]", "[FINGERPRINT]");
    OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();

    OsLoginProto.SshPublicKey actualResponse = client.updateSshPublicKey(name, sshPublicKey);
    Assert.assertEquals(expectedResponse, actualResponse);

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
  public void updateSshPublicKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FingerprintName name = FingerprintName.of("[USER]", "[FINGERPRINT]");
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
            .setName(FingerprintName.of("[USER]", "[FINGERPRINT]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "users/user-7353/sshPublicKeys/sshPublicKey-7353";
    OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();

    OsLoginProto.SshPublicKey actualResponse = client.updateSshPublicKey(name, sshPublicKey);
    Assert.assertEquals(expectedResponse, actualResponse);

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
  public void updateSshPublicKeyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "users/user-7353/sshPublicKeys/sshPublicKey-7353";
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
            .setName(FingerprintName.of("[USER]", "[FINGERPRINT]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    FingerprintName name = FingerprintName.of("[USER]", "[FINGERPRINT]");
    OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    OsLoginProto.SshPublicKey actualResponse =
        client.updateSshPublicKey(name, sshPublicKey, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

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
  public void updateSshPublicKeyExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FingerprintName name = FingerprintName.of("[USER]", "[FINGERPRINT]");
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
            .setName(FingerprintName.of("[USER]", "[FINGERPRINT]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "users/user-7353/sshPublicKeys/sshPublicKey-7353";
    OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    OsLoginProto.SshPublicKey actualResponse =
        client.updateSshPublicKey(name, sshPublicKey, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

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
  public void updateSshPublicKeyExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "users/user-7353/sshPublicKeys/sshPublicKey-7353";
      OsLoginProto.SshPublicKey sshPublicKey = OsLoginProto.SshPublicKey.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSshPublicKey(name, sshPublicKey, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
