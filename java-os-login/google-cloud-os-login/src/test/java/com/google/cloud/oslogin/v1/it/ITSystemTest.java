/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.oslogin.v1.it;

import static org.junit.Assert.assertEquals;

import com.google.api.gax.rpc.NotFoundException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.oslogin.common.OsLoginProto;
import com.google.cloud.oslogin.v1.FingerprintName;
import com.google.cloud.oslogin.v1.ImportSshPublicKeyResponse;
import com.google.cloud.oslogin.v1.LoginProfile;
import com.google.cloud.oslogin.v1.OsLoginServiceClient;
import com.google.cloud.oslogin.v1.UserName;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSystemTest {
  private OsLoginServiceClient osLoginServiceClient;
  private UserName parent;
  private static String user;
  private static String clientId;

  private static final String PROJECT = ServiceOptions.getDefaultProjectId();
  private static final String GOOGLE_API_CLIENT_ID = "clientId";
  private static final String GOOGLE_API_CLIENT_EMAIL_ID = "clientEmail";
  private static final String GOOGLE_API_CLOUD_PLATFORM_LINK =
      "https://www.googleapis.com/auth/cloud-platform";
  private static final String NON_EXISTENT_FINGERPRINT_NAME = "test-fingerprint";
  private static final String REGEXP = "^\"|\"$";
  private static final OsLoginProto.SshPublicKey SSH_PUBLIC_KEY =
      OsLoginProto.SshPublicKey.newBuilder().build();
  private static final Gson GSON = new Gson();

  @BeforeClass
  public static void setup() throws Exception {
    user = getFromCredential(GOOGLE_API_CLIENT_EMAIL_ID);
    clientId = getFromCredential(GOOGLE_API_CLIENT_ID);
  }

  @Before
  public void before() throws Exception {
    osLoginServiceClient = OsLoginServiceClient.create();
    parent = UserName.of(user);
  }

  @After
  public void after() {
    osLoginServiceClient.close();
  }

  private static String getFromCredential(String key) throws Exception {
    GoogleCredentials credentials =
        GoogleCredentials.getApplicationDefault().createScoped(GOOGLE_API_CLOUD_PLATFORM_LINK);
    JsonObject jsonObject = GSON.fromJson(GSON.toJson(credentials), JsonObject.class);
    return jsonObject.get(key).toString().replaceAll(REGEXP, "");
  }

  @Test
  public void getLoginProfileTest() {
    LoginProfile profile = osLoginServiceClient.getLoginProfile(parent);
    assertEquals(clientId, profile.getName());
  }

  @Test(expected = NotFoundException.class)
  public void getSshPublicKeyExceptionTest() {
    FingerprintName name = FingerprintName.of(user, NON_EXISTENT_FINGERPRINT_NAME);
    OsLoginProto.SshPublicKey sshPublicKey = osLoginServiceClient.getSshPublicKey(name);
  }

  @Test
  public void importSshPublicKeyTest() {
    ImportSshPublicKeyResponse publicKeyResponse =
        osLoginServiceClient.importSshPublicKey(parent, SSH_PUBLIC_KEY);
    assertEquals(clientId, publicKeyResponse.getLoginProfile().getName());
    assertEquals(1, publicKeyResponse.getLoginProfile().getPosixAccountsCount());
  }

  @Test
  public void importSshPublicKeyWithProjectTest() {
    ImportSshPublicKeyResponse keyResponse =
        osLoginServiceClient.importSshPublicKey(parent, SSH_PUBLIC_KEY, PROJECT);
    assertEquals(clientId, keyResponse.getLoginProfile().getName());
    assertEquals(1, keyResponse.getLoginProfile().getPosixAccountsCount());
  }
}
