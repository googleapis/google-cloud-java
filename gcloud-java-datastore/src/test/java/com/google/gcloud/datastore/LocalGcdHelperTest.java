/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.datastore;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.gcloud.datastore.testing.LocalGcdHelper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.net.ServerSocket;

@RunWith(JUnit4.class)
public class LocalGcdHelperTest {

  private static final String PROJECT_ID = LocalGcdHelper.DEFAULT_PROJECT_ID;
  private static final int PORT = LocalGcdHelper.findAvailablePort(LocalGcdHelper.DEFAULT_PORT);

  @Test
  public void testFindAvailablePort() {
    int chosenPort = LocalGcdHelper.findAvailablePort(LocalGcdHelper.DEFAULT_PORT);
    try (ServerSocket tempSocket = new ServerSocket(chosenPort)) {
      // success
    } catch (IOException e) {
      if (chosenPort != LocalGcdHelper.DEFAULT_PORT) {
        fail("Chosen port not free, even though LocalGcdHelper claimed it was.");
      }
    }
  }

  @Test
  public void testSendQuitRequest() throws IOException, InterruptedException {
    LocalGcdHelper gcdHelper = LocalGcdHelper.start(PROJECT_ID, PORT);
    assertTrue(LocalGcdHelper.sendQuitRequest(PORT));
    long timeoutMillis = 30000;
    long startTime = System.currentTimeMillis();
    boolean datastoreActive = LocalGcdHelper.isActive(PROJECT_ID, PORT);
    while (datastoreActive && System.currentTimeMillis() - startTime < timeoutMillis) {
      datastoreActive = LocalGcdHelper.isActive(PROJECT_ID, PORT);
    }
    assertFalse(datastoreActive);
    assertFalse(LocalGcdHelper.sendQuitRequest(PORT));
    gcdHelper.stop();
  }

  @Test
  public void testStartStop() throws IOException, InterruptedException {
    LocalGcdHelper gcdHelper = LocalGcdHelper.start(PROJECT_ID, PORT);
    assertFalse(LocalGcdHelper.isActive("wrong-project-id", PORT));
    assertTrue(LocalGcdHelper.isActive(PROJECT_ID, PORT));
    gcdHelper.stop();
    assertFalse(LocalGcdHelper.isActive(PROJECT_ID, PORT));
  }
}
