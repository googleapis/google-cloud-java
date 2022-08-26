/*
 * Copyright 2020 Google LLC
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

package dlp.snippets;

import static com.google.common.truth.Truth.assertWithMessage;

import com.google.common.collect.ImmutableList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;

/** Common base class for DLP snippet tests */
abstract class TestBase {

  protected static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  protected static final String GCS_PATH = System.getenv("GCS_PATH");
  protected static final String TOPIC_ID = System.getenv("PUB_SUB_TOPIC");
  protected static final String SUBSCRIPTION_ID = System.getenv("PUB_SUB_SUBSCRIPTION");
  protected static final String DATASET_ID = System.getenv("BIGQUERY_DATASET");
  protected static final String TABLE_ID = System.getenv("BIGQUERY_TABLE");
  protected static final String wrappedKey = System.getenv("DLP_DEID_WRAPPED_KEY");
  protected static final String kmsKeyName = System.getenv("DLP_DEID_KEY_NAME");

  protected ByteArrayOutputStream bout;
  private PrintStream originalOut = System.out;

  protected abstract ImmutableList<String> requiredEnvVars();

  private static void requireEnvVar(String varName) {
    assertWithMessage(
            String.format("Environment variable '%s' must be set to perform these tests.", varName))
        .that(System.getenv(varName))
        .isNotEmpty();
  }

  @Before
  public void beforeBase() {
    requiredEnvVars().stream().forEach(TestBase::requireEnvVar);

    // Capture stdout
    bout = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bout));
  }

  @After
  public void afterBase() {
    // Restore stdout
    System.setOut(originalOut);
    bout.reset();
  }
}
