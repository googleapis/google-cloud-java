/*
 * Copyright 2022 Google LLC
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

package com.example.bigtable;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KeySaltingTest extends MobileTimeSeriesBaseTest {
  public static final String ROW_KEY = "phone#4c410523#20190501";

  @BeforeClass
  public static void beforeClass() throws IOException {
    initializeVariables();
    createTable();
  }

  @AfterClass
  public static void afterClass() throws IOException {
    cleanupTable();
  }

  @Test
  public void testWriteAndRead() throws IOException {
    KeySalting.writeSaltedRow(projectId, instanceId, TABLE_ID, ROW_KEY);
    KeySalting.readSaltedRow(projectId, instanceId, TABLE_ID, ROW_KEY);

    String output = bout.toString();
    assertEquals(
        "Successfully wrote row phone#4c410523#20190501 as 0-phone#4c410523#20190501\n"
            + "Successfully read row 0-phone#4c410523#20190501\n",
        output);
  }

  @Test
  public void testScans() throws IOException, ExecutionException, InterruptedException {
    String prefix = "abc-";
    for (int i = 0; i < 8; i++) {
      KeySalting.writeSaltedRow(projectId, instanceId, TABLE_ID, prefix + i);
    }
    bout.reset();

    KeySalting.scanSaltedRows(projectId, instanceId, TABLE_ID, prefix);

    String output = bout.toString();
    assertEquals(
        "Successfully fetched 8 rows\n"
            + "Successfully read row 0-abc-3\n"
            + "Successfully read row 0-abc-7\n"
            + "Successfully read row 1-abc-0\n"
            + "Successfully read row 1-abc-4\n"
            + "Successfully read row 2-abc-1\n"
            + "Successfully read row 2-abc-5\n"
            + "Successfully read row 3-abc-2\n"
            + "Successfully read row 3-abc-6\n",
        output);
  }

  @Test
  public void testKeySalting() {
    Map<String, String> exampleKeys = new HashMap<String, String>();
    exampleKeys.put("abc-1", "2-abc-1");
    exampleKeys.put("abc-2", "3-abc-2");
    exampleKeys.put("abc-3", "0-abc-3");
    exampleKeys.put("abc-4", "1-abc-4");

    exampleKeys.forEach((k, v) -> assertEquals(v, KeySalting.getSaltedRowKey(k, 4)));
  }
}
