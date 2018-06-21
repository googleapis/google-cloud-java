/*
 * Copyright 2018 Google Inc.
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

package com.example.dlp;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
// CHECKSTYLE OFF: AbbreviationAsWordInName
public class TriggersIT {

  //CHECKSTYLE ON: AbbreviationAsWordInName

  private ByteArrayOutputStream bout;

  private String bucketName = System.getenv("GOOGLE_CLOUD_PROJECT") + "/dlp";

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bout));
    assertNotNull(System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));
  }

  @After
  public void tearDown() {
    System.setOut(null);
    bout.reset();
  }

  @Test
  public void testCreateTrigger() throws Exception {
    Triggers.main(
        new String[] {
          "-c",
          "-displayName",
          String.format("trigger-name-%s", UUID.randomUUID()),
          "-triggerId",
          String.format("trigger%s", UUID.randomUUID()),
          "-description",
          String.format("description-%s", UUID.randomUUID()),
          "-bucketName",
          bucketName,
          "-fileName",
          "test.txt",
          "-autoPopulateTimespan",
          "-scanPeriod",
          "1"
        });
    String output = bout.toString();
    assertThat(output, containsString("Created Trigger:"));
  }

  @Test
  public void testListTrigger() throws Exception {
    Triggers.main(new String[] {"-l"});
    String output = bout.toString();
    assertThat(output, containsString("Trigger:"));
  }

  @Test
  public void testDeleteTrigger() throws Exception {
    Triggers.main(new String[] {"-l"});
    String output = bout.toString();
    Matcher templateIds = Pattern.compile("(?<=jobTriggers/)[0-9]+").matcher(output);
    assertTrue(templateIds.find());
    String triggerId = templateIds.group(0);
    bout.reset();
    Triggers.main(
        new String[] {
          "-d", "-triggerId", triggerId,
        });
    output = bout.toString();
    assertThat(output, containsString("Trigger deleted:"));
  }
}
