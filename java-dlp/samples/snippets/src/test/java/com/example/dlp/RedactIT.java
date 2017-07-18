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
public class RedactIT {
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
  public void testInfoTypesInStringAreReplaced() throws Exception {
    String text =
        "\"My phone number is (234) 456-7890 and my email address is gary@somedomain.com\"";
    Redact.main(new String[] {"-s", text, "-r", "_REDACTED_"});
    String output = bout.toString();
    assertTrue(output.contains("My phone number is _REDACTED_ and my email address is _REDACTED_"));
  }

  @After
  public void tearDown() {
    System.setOut(null);
    bout.reset();
  }
}
