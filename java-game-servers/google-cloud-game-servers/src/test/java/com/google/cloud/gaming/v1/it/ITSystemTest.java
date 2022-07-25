/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.gaming.v1.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.ServiceOptions;
import com.google.cloud.gaming.v1.CreateGameServerConfigRequest;
import com.google.cloud.gaming.v1.CreateGameServerDeploymentRequest;
import com.google.cloud.gaming.v1.DeleteGameServerConfigRequest;
import com.google.cloud.gaming.v1.DeleteGameServerDeploymentRequest;
import com.google.cloud.gaming.v1.FetchDeploymentStateRequest;
import com.google.cloud.gaming.v1.FetchDeploymentStateResponse;
import com.google.cloud.gaming.v1.GameServerConfig;
import com.google.cloud.gaming.v1.GameServerConfigName;
import com.google.cloud.gaming.v1.GameServerConfigsServiceClient;
import com.google.cloud.gaming.v1.GameServerDeployment;
import com.google.cloud.gaming.v1.GameServerDeploymentName;
import com.google.cloud.gaming.v1.GameServerDeploymentRollout;
import com.google.cloud.gaming.v1.GameServerDeploymentsServiceClient;
import com.google.cloud.gaming.v1.GetGameServerConfigRequest;
import com.google.cloud.gaming.v1.GetGameServerDeploymentRequest;
import com.google.cloud.gaming.v1.GetGameServerDeploymentRolloutRequest;
import com.google.cloud.gaming.v1.ListGameServerConfigsRequest;
import com.google.cloud.gaming.v1.ListGameServerDeploymentsRequest;
import com.google.cloud.gaming.v1.LocationName;
import com.google.cloud.gaming.v1.PreviewGameServerDeploymentRolloutRequest;
import com.google.cloud.gaming.v1.PreviewGameServerDeploymentRolloutResponse;
import com.google.cloud.gaming.v1.Realm;
import com.google.cloud.gaming.v1.RealmName;
import com.google.cloud.gaming.v1.RealmsServiceClient;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSystemTest {

  private static RealmsServiceClient realmsServiceClient;
  private static GameServerDeploymentsServiceClient deploymentsServiceClient;
  private static GameServerConfigsServiceClient configsServiceClient;

  /* Realms Service Client */
  private static final String PROJECT = ServiceOptions.getDefaultProjectId();
  private static final String ID = UUID.randomUUID().toString();
  private static final String LOCATION = "us-central1";
  private static final String REALM_ID = "realm-" + ID;
  private static final String TIME_ZONE = "US/Central";
  private static final String DESCRIPTION = "description";
  private static final LocationName PARENT = LocationName.of(PROJECT, LOCATION);
  private static final RealmName REALM_NAME = RealmName.of(PROJECT, LOCATION, REALM_ID);

  /* Game Server Deployments Service Client */
  private static final String GLOBAL_LOCATION = "global";
  private static final String DEPLOYMENT_ID = "test-deployment-" + ID;
  private static final GameServerDeploymentName GAME_SERVER_DEPLOYMENT_NAME =
      GameServerDeploymentName.of(PROJECT, GLOBAL_LOCATION, DEPLOYMENT_ID);
  private static final LocationName GAME_SERVER_DEPLOYMENT_PARENT =
      LocationName.of(PROJECT, GLOBAL_LOCATION);

  /* Game Server Configs Service Client */
  private static final String GAME_SERVER_NAME = "game-server-" + ID;
  private static final String CONFIG_ID = "test-config-" + ID;
  private static final GameServerConfigName GAME_SERVER_CONFIG_NAME =
      GameServerConfigName.of(PROJECT, GLOBAL_LOCATION, DEPLOYMENT_ID, CONFIG_ID);

  @BeforeClass
  public static void setUp() throws IOException, ExecutionException, InterruptedException {
    /* Realms Service Client */
    realmsServiceClient = RealmsServiceClient.create();
    Realm realm =
        Realm.newBuilder()
            .setName(REALM_NAME.toString())
            .setTimeZone(TIME_ZONE)
            .setDescription(DESCRIPTION)
            .build();
    realmsServiceClient.createRealmAsync(PARENT, realm, REALM_ID).get();

    /*Game Server Deployments Service Client*/
    deploymentsServiceClient = GameServerDeploymentsServiceClient.create();
    GameServerDeployment gameServerDeployment =
        GameServerDeployment.newBuilder()
            .setName(GAME_SERVER_DEPLOYMENT_NAME.toString())
            .setDescription(DESCRIPTION)
            .build();
    CreateGameServerDeploymentRequest request =
        CreateGameServerDeploymentRequest.newBuilder()
            .setParent(GAME_SERVER_DEPLOYMENT_PARENT.toString())
            .setDeploymentId(DEPLOYMENT_ID)
            .setGameServerDeployment(gameServerDeployment)
            .build();
    deploymentsServiceClient.createGameServerDeploymentAsync(request).get();

    /* Game Server Configs Service Client */
    configsServiceClient = GameServerConfigsServiceClient.create();
    GameServerConfig gameServerConfig =
        GameServerConfig.newBuilder().setName(GAME_SERVER_NAME).setDescription(DESCRIPTION).build();
    CreateGameServerConfigRequest configRequest =
        CreateGameServerConfigRequest.newBuilder()
            .setParent(GAME_SERVER_DEPLOYMENT_NAME.toString())
            .setConfigId(CONFIG_ID)
            .setGameServerConfig(gameServerConfig)
            .build();
    configsServiceClient.createGameServerConfigAsync(configRequest).get();
  }

  @AfterClass
  public static void tearDown() throws ExecutionException, InterruptedException {
    /* Realms Service Client */
    realmsServiceClient.deleteRealmAsync(REALM_NAME).get();
    realmsServiceClient.close();

    /* GameServerConfigsServiceClient */
    DeleteGameServerConfigRequest deleteGameServerConfigRequest =
        DeleteGameServerConfigRequest.newBuilder()
            .setName(GAME_SERVER_CONFIG_NAME.toString())
            .build();
    configsServiceClient.deleteGameServerConfigAsync(deleteGameServerConfigRequest).get();
    configsServiceClient.close();

    /* Game Server Deployments Service Client */
    DeleteGameServerDeploymentRequest request =
        DeleteGameServerDeploymentRequest.newBuilder()
            .setName(GAME_SERVER_DEPLOYMENT_NAME.toString())
            .build();
    deploymentsServiceClient.deleteGameServerDeploymentAsync(request).get();
    deploymentsServiceClient.close();
  }

  @Test
  public void getRealmTest() {
    Realm realm = realmsServiceClient.getRealm(REALM_NAME);
    assertNotNull(realm);
    assertNotNull(realm.getCreateTime());
    assertNotNull(realm.getEtag());
    assertEquals(REALM_NAME.toString(), realm.getName());
    assertEquals(TIME_ZONE, realm.getTimeZone());
    assertEquals(DESCRIPTION, realm.getDescription());
  }

  @Test
  public void listRealmsTest() {
    List<Realm> realms = Lists.newArrayList(realmsServiceClient.listRealms(PARENT).iterateAll());
    assertTrue(realms.size() > 0);
    boolean found = false;
    for (Realm realm : realms) {
      if (REALM_NAME.toString().equals(realm.getName())) {
        found = true;
        assertEquals(TIME_ZONE, realm.getTimeZone());
        assertEquals(DESCRIPTION, realm.getDescription());
        assertNotNull(realm.getCreateTime());
        assertNotNull(realm.getEtag());
      }
    }
    assertTrue("expected to find realm by resource name", found);
  }

  @Test
  public void getGameServerDeploymentTest() {
    GetGameServerDeploymentRequest request =
        GetGameServerDeploymentRequest.newBuilder()
            .setName(GAME_SERVER_DEPLOYMENT_NAME.toString())
            .build();
    GameServerDeployment gameServerDeployment =
        deploymentsServiceClient.getGameServerDeployment(request);
    assertNotNull(gameServerDeployment);
    assertNotNull(gameServerDeployment.getCreateTime());
    assertNotNull(gameServerDeployment.getEtag());
    assertEquals(GAME_SERVER_DEPLOYMENT_NAME.toString(), gameServerDeployment.getName());
    assertEquals(DESCRIPTION, gameServerDeployment.getDescription());
  }

  @Test
  public void listGameServerDeploymentsTest() {
    ListGameServerDeploymentsRequest request =
        ListGameServerDeploymentsRequest.newBuilder()
            .setParent(GAME_SERVER_DEPLOYMENT_PARENT.toString())
            .build();
    List<GameServerDeployment> gameServerDeployments =
        Lists.newArrayList(
            deploymentsServiceClient.listGameServerDeployments(request).iterateAll());
    assertEquals(1, gameServerDeployments.size());
    assertNotNull(gameServerDeployments.get(0).getCreateTime());
    assertNotNull(gameServerDeployments.get(0).getEtag());
    assertEquals(GAME_SERVER_DEPLOYMENT_NAME.toString(), gameServerDeployments.get(0).getName());
  }

  @Test
  public void fetchDeploymentStateTest() {
    FetchDeploymentStateResponse expectedResponse =
        FetchDeploymentStateResponse.newBuilder().build();
    FetchDeploymentStateRequest request =
        FetchDeploymentStateRequest.newBuilder()
            .setName(GAME_SERVER_DEPLOYMENT_NAME.toString())
            .build();
    FetchDeploymentStateResponse stateResponse =
        deploymentsServiceClient.fetchDeploymentState(request);
    assertEquals(expectedResponse, stateResponse);
  }

  @Test
  public void getGameServerDeploymentRolloutTest() {
    GetGameServerDeploymentRolloutRequest rolloutRequest =
        GetGameServerDeploymentRolloutRequest.newBuilder()
            .setName(GAME_SERVER_DEPLOYMENT_NAME.toString())
            .build();
    GameServerDeploymentRollout response =
        deploymentsServiceClient.getGameServerDeploymentRollout(rolloutRequest);
    assertNotNull(response);
    assertNotNull(response.getCreateTime());
    assertNotNull(response.getEtag());
    assertEquals(GAME_SERVER_DEPLOYMENT_NAME.toString() + "/rollout", response.getName());
  }

  @Test
  public void previewGameServerDeploymentRolloutTest() {
    GameServerDeploymentRollout rollout =
        GameServerDeploymentRollout.newBuilder()
            .setName(GAME_SERVER_DEPLOYMENT_NAME.toString())
            .build();
    PreviewGameServerDeploymentRolloutRequest request =
        PreviewGameServerDeploymentRolloutRequest.newBuilder().setRollout(rollout).build();
    PreviewGameServerDeploymentRolloutResponse response =
        deploymentsServiceClient.previewGameServerDeploymentRollout(request);
    assertNotNull(response);
    assertNotNull(response.getTargetState());
    assertNotNull(response.getEtag());
  }

  @Test
  public void getGameServerConfigTest() {
    GetGameServerConfigRequest request =
        GetGameServerConfigRequest.newBuilder().setName(GAME_SERVER_CONFIG_NAME.toString()).build();
    GameServerConfig gameServerConfig = configsServiceClient.getGameServerConfig(request);
    assertNotNull(gameServerConfig);
    assertNotNull(gameServerConfig.getCreateTime());
    assertEquals(GAME_SERVER_CONFIG_NAME.toString(), gameServerConfig.getName());
    assertEquals(DESCRIPTION, gameServerConfig.getDescription());
  }

  @Test
  public void listGameServerConfigsTest() {
    ListGameServerConfigsRequest request =
        ListGameServerConfigsRequest.newBuilder()
            .setParent(GAME_SERVER_DEPLOYMENT_NAME.toString())
            .build();
    List<GameServerConfig> gameServerConfigs =
        Lists.newArrayList(configsServiceClient.listGameServerConfigs(request).iterateAll());
    boolean found = false;
    for (GameServerConfig gameServerConfig : gameServerConfigs) {
      assertNotNull(gameServerConfig.getCreateTime());
      if (GAME_SERVER_CONFIG_NAME.toString().equals(gameServerConfig.getName())) {
        found = true;
        assertEquals(DESCRIPTION, gameServerConfig.getDescription());
      }
    }
    assertTrue("expected to find game servcer config by resource name", found);
  }
}
