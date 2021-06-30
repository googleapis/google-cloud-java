/*
 * Copyright 2020 Google Inc.
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

package com.example.datacatalog;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.cloud.datacatalog.v1.EntryGroupName;
import com.google.cloud.datacatalog.v1.LocationName;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ListEntryGroupsIT {

  private static final String ID = UUID.randomUUID().toString().substring(0, 8);
  private static final String LOCATION = "us-central1";
  private final Logger log = Logger.getLogger(this.getClass().getName());
  private String entryGroup;
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  private static final String PROJECT_ID = requireEnvVar("GOOGLE_CLOUD_PROJECT");

  private static String requireEnvVar(String varName) {
    String value = System.getenv(varName);
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
    return value;
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
  }

  @Before
  public void setUp() throws IOException {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
    entryGroup = "LIST_ENTRY_GROUPS_TEST_" + ID;
    // create temporary entry group
    CreateEntryGroup.createEntryGroup(PROJECT_ID, LOCATION, entryGroup);
  }

  @After
  public void tearDown() throws IOException {
    // clean up
    EntryGroupName name = EntryGroupName.of(PROJECT_ID, LOCATION, entryGroup);
    DeleteEntryGroup.deleteEntryGroup(name);
    // restores print statements in the original method
    System.out.flush();
    System.setOut(originalPrintStream);
    log.log(Level.INFO, bout.toString());
  }

  @Test
  public void testListEntryGroups() throws IOException {
    ListEntryGroups.listEntryGroups(LocationName.of(PROJECT_ID, LOCATION));
    assertThat(bout.toString()).contains("Entry group name :");
  }
}
