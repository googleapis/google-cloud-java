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

import com.example.gameservices.realms.CreateRealm;
import com.example.gameservices.realms.DeleteRealm;
import com.example.gameservices.realms.GetRealm;
import com.example.gameservices.realms.ListRealms;
import com.example.gameservices.realms.UpdateRealm;
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
public class RealmTests {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String REGION_ID = "us-central1";

  private static String parentName =
      String.format("projects/%s/locations/%s", PROJECT_ID, REGION_ID);

  private static String realmId = "realm-" + GameServicesTestUtil.UID;
  private static String realmName = String.format("%s/realms/%s", parentName, realmId);

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
    GameServicesTestUtil.deleteExistingRealms(parentName);
    CreateRealm.createRealm(PROJECT_ID, REGION_ID, realmId);
  }

  @After
  public void tearDown() {
    System.setOut(originalOut);
    bout.reset();
  }

  @AfterClass
  public static void tearDownClass() {
    GameServicesTestUtil.deleteExistingRealms(parentName);
  }

  @Test
  public void createDeleteRealmTest()
      throws InterruptedException, ExecutionException, TimeoutException, IOException {
    String newRealmId = "realm-2";
    String newRealmName =
        String.format("projects/%s/locations/%s/realms/%s", PROJECT_ID, REGION_ID, newRealmId);
    CreateRealm.createRealm(PROJECT_ID, REGION_ID, newRealmId);
    DeleteRealm.deleteRealm(PROJECT_ID, REGION_ID, newRealmId);
    String output = bout.toString();
    assertTrue(output.contains("Realm created: " + newRealmName));
    assertTrue(output.contains("Realm deleted: " + newRealmName));
  }

  @Test
  public void getRealmTest() throws IOException {
    GetRealm.getRealm(PROJECT_ID, REGION_ID, realmId);

    assertTrue(bout.toString().contains("Realm found: " + realmName));
  }

  @Test
  public void listRealmsTest() throws IOException {
    ListRealms.listRealms(PROJECT_ID, REGION_ID);

    assertTrue(bout.toString().contains("Realm found: " + realmName));
  }

  @Test
  public void updateRealmTest()
      throws InterruptedException, ExecutionException, TimeoutException, IOException {
    UpdateRealm.updateRealm(PROJECT_ID, REGION_ID, realmId);

    assertTrue(bout.toString().contains("Realm updated: " + realmName));
  }
}
