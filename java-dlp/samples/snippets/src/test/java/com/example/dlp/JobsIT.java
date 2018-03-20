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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

// CHECKSTYLE OFF: AbbreviationAsWordInName
@RunWith(JUnit4.class)
public class JobsIT {
  // CHECKSTYLE ON: AbbreviationAsWordInName

  private ByteArrayOutputStream bout;
  private PrintStream out;

  private static final Pattern jobIdPattern = Pattern.compile("projects/.*/dlpJobs/i-\\d+");

  // Update to Google Cloud Storage path containing test.txt
  private String bucketName = System.getenv("GOOGLE_CLOUD_PROJECT") + "/dlp";

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
    assertNotNull(System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));
  }

  @After
  public void tearDown() {
    System.setOut(null);
    bout.reset();
  }

  @Test
  public void testListJobs() throws Exception {
    Jobs.main(new String[] {"-l", "-filter", "state=DONE"});
    String output = bout.toString();
    Matcher matcher = jobIdPattern.matcher(bout.toString());
    assertTrue("List must contain results.", matcher.find());
  }

  @Test
  public void testDeleteJobs() throws Exception {
    // Get a list of JobIds, and extract one to delete
    Jobs.main(new String[] {"-l", "-filter", "state=DONE"});
    String jobList = bout.toString();
    Matcher matcher = jobIdPattern.matcher(jobList);
    assertTrue("List must contain results.", matcher.find());
    // Extract just the ID
    String jobId = matcher.group(0).split("/")[3];
    bout.reset();

    // Delete the Job
    Jobs.main(new String[] {"-d", "-jobId", jobId});
    String output = bout.toString();
    assertThat(output, containsString("Job deleted successfully."));
  }
}
