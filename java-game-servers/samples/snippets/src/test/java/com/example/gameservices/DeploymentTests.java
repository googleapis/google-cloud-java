/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.gameservices;

import static org.junit.Assert.assertTrue;

import com.example.gameservices.deployments.CreateDeployment;
import com.example.gameservices.deployments.DeleteDeployment;
import com.example.gameservices.deployments.GetDeployment;
import com.example.gameservices.deployments.ListDeployments;
import com.example.gameservices.deployments.UpdateDeployment;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Ignore
@RunWith(JUnit4.class)
public class DeploymentTests {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");

  private static String parentName = String.format("projects/%s/locations/global", PROJECT_ID);
  private static String deploymentId = "deployment-" + GameServicesTestUtil.UID;
  private static String deploymentName =
      String.format("%s/gameServerDeployments/%s", parentName, deploymentId);

  private final PrintStream originalOut = System.out;
  private ByteArrayOutputStream bout;

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bout));
  }

  @BeforeClass
  public static void init()
      throws InterruptedException, ExecutionException, TimeoutException, IOException {
    GameServicesTestUtil.deleteExistingDeployments(parentName);
    CreateDeployment.createGameServerDeployment(PROJECT_ID, deploymentId);
  }

  @After
  public void tearDown() {
    System.setOut(originalOut);
    bout.reset();
  }

  @AfterClass
  public static void tearDownClass() {
    GameServicesTestUtil.deleteExistingDeployments(parentName);
  }

  @Test
  public void createDeleteGameServerDeploymentTest()
      throws InterruptedException, ExecutionException, TimeoutException, IOException {
    String newDeploymentId = "deployment-2";
    String newDeploymentName =
        String.format("%s/gameServerDeployments/%s", parentName, newDeploymentId);
    CreateDeployment.createGameServerDeployment(PROJECT_ID, newDeploymentId);
    DeleteDeployment.deleteGameServerDeployment(PROJECT_ID, newDeploymentId);
    assertTrue(bout.toString().contains("Game Server Deployment created: " + newDeploymentName));
    assertTrue(bout.toString().contains("Game Server Deployment deleted: " + newDeploymentName));
  }

  @Test
  public void getGameServerDeploymentTest() throws IOException {
    GetDeployment.getGameServerDeployment(PROJECT_ID, deploymentId);

    assertTrue(bout.toString().contains("Game Server Deployment found: " + deploymentName));
  }

  @Test
  public void listGameServerDeploymentsTest() throws IOException {
    ListDeployments.listGameServerDeployments(PROJECT_ID);

    assertTrue(bout.toString().contains("Game Server Deployment found: " + deploymentName));
  }

  @Test
  public void updateGameServerDeploymentTest()
      throws InterruptedException, ExecutionException, TimeoutException, IOException {
    UpdateDeployment.updateGameServerDeployment(PROJECT_ID, deploymentId);
    assertTrue(bout.toString().contains("Game Server Deployment updated: " + deploymentName));
  }
}
