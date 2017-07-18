/**
 * Copyright 2017, Google, Inc. Licensed under the Apache License, Version 2.0 (the "License"); you
 * may not use this file except in compliance with the License. You may obtain a copy of the License
 * at
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.dlp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class MetadataIT {

  private ByteArrayOutputStream bout;
  private PrintStream out;

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
    assertNotNull(System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));
  }

  @Test
  public void testRootCategoriesAreRetrieved() throws Exception {
    Metadata.main(new String[] {});
    String output = bout.toString();
    assertTrue(output.contains("GOVERNMENT"));
    assertTrue(output.contains("HEALTH"));
  }

  @Test
  public void testInfoTypesAreRetrieved() throws Exception {
    Metadata.main(new String[] {"-category", "GOVERNMENT"});
    String output = bout.toString();
    assertTrue(output.contains("AUSTRALIA_TAX_FILE_NUMBER"));
  }

  @After
  public void tearDown() {
    System.setOut(null);
  }
}
