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

package com.example.analytics;

import static com.google.common.truth.Truth.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for the GetMetadataByPropertyId sample. */
@RunWith(JUnit4.class)
public class GetMetadataByPropertyIdSampleTest {

  private String ga4PropertyId =
      System.getProperty("analyticsdata.quickstart.ga4PropertyId", "222596558");

  private String runSample(String ga4PropertyId) throws Exception {
    PrintStream stdOut = System.out;
    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bout);
    System.setOut(out);

    // Run the test using default system credentials.
    GetMetadataByPropertyIdSample.sampleGetMetadataByPropertyId(ga4PropertyId);
    System.setOut(stdOut);
    return bout.toString();
  }

  @Test
  public void testGetMetadataByPropertyId() throws Exception {
    // Act
    String out = runSample(ga4PropertyId);

    // Assert
    assertThat(out).contains("Dimensions and metrics");
  }
}
