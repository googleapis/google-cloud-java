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
import java.io.File;
import java.io.PrintStream;

@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class InspectIT {
  private ByteArrayOutputStream bout;
  private PrintStream out;

  // Update to Google Cloud Storage path containing test.txt
  private String bucketName = System.getenv("GOOGLE_CLOUD_PROJECT") + "/dlp";

  // Update to Google Cloud Datastore Kind containing an entity
  // with phone number and email address properties.
  private String datastoreKind = "dlp";

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
    assertNotNull(System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));
  }

  @Test
  public void testStringInspectionReturnsInfoTypes() throws Exception {
    String text =
        "\"My phone number is (234) 456-7890 and my email address is gary@somedomain.com\"";
    Inspect.main(new String[] {"-s", text});
    String output = bout.toString();
    assertTrue(output.contains("PHONE_NUMBER"));
    assertTrue(output.contains("EMAIL_ADDRESS"));
  }

  @Test
  public void testTextFileInspectionReturnsInfoTypes() throws Exception {
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("test.txt").getFile());
    Inspect.main(new String[] {"-f", file.getAbsolutePath()});
    String output = bout.toString();
    assertTrue(output.contains("PHONE_NUMBER"));
    assertTrue(output.contains("EMAIL_ADDRESS"));
  }

  @Test
  public void testImageFileInspectionReturnsInfoTypes() throws Exception {
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("test.png").getFile());
    Inspect.main(new String[] {"-f", file.getAbsolutePath()});
    String output = bout.toString();
    assertTrue(output.contains("PHONE_NUMBER"));
    assertTrue(output.contains("EMAIL_ADDRESS"));
  }

  // Requires that bucket by the specified name exists
  @Test
  public void testGcsFileInspectionReturnsInfoTypes() throws Exception {
    Inspect.main(new String[] {"-gcs", "-bucketName", bucketName, "-fileName", "test.txt"});
    String output = bout.toString();
    assertTrue(output.contains("PHONE_NUMBER"));
    assertTrue(output.contains("EMAIL_ADDRESS"));
  }

  // Requires  a Datastore kind containing an entity
  // with phone number and email address properties.
  @Test
  public void testDatastoreInspectionReturnsInfoTypes() throws Exception {
    Inspect.main(new String[] {"-ds", "-kind", datastoreKind});
    String output = bout.toString();
    assertTrue(output.contains("PHONE_NUMBER"));
    assertTrue(output.contains("EMAIL_ADDRESS"));
  }

  @After
  public void tearDown() {
    System.setOut(null);
    bout.reset();
  }
}
