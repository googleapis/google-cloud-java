/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dialogflow.cx;

import static com.google.common.truth.Truth.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListTestCaseResultsIT {

  private static String PROJECT_ID = System.getenv().get("GOOGLE_CLOUD_PROJECT");
  private static String agentId = "1499b8e1-ab7d-43fd-9b08-30ee57194fc1";
  private static String testId = "694a5447-6c40-4752-944e-e3e70580b273";
  private static String location = "global";

  private ByteArrayOutputStream stdOut;
  private static PrintStream originalOut;

  @Before
  public void setUp() throws IOException {
    originalOut = System.out;
    stdOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOut));
  }

  @After
  public void tearDown() throws IOException {
    System.setOut(originalOut);
  }

  @Test
  public void testListTestCaseResults() throws IOException {
    ListTestCaseResults.listTestCaseResults(PROJECT_ID, agentId, testId, location);
    assertThat(stdOut.toString()).contains(testId);
  }
}
