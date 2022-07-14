/*
 * Copyright 2020 Google LLC
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

package aiplatform;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PredictTabularRegressionSampleTest {

  private static final String PROJECT = System.getenv("UCAIP_PROJECT_ID");
  private static final String INSTANCE =
      "[{\n"
          + "    \"BOOLEAN_2unique_NULLABLE\": False,\n"
          + "    \"DATETIME_1unique_NULLABLE\": '2019-01-01 00:00:00',\n"
          + "    \"DATE_1unique_NULLABLE\": '2019-01-01',\n"
          + "    \"FLOAT_5000unique_NULLABLE\": 1611,\n"
          + "    \"FLOAT_5000unique_REPEATED\": [2320,1192],\n"
          + "    \"INTEGER_5000unique_NULLABLE\": '8',\n"
          + "    \"NUMERIC_5000unique_NULLABLE\": 16,\n"
          + "    \"STRING_5000unique_NULLABLE\": 'str-2',\n"
          + "    \"STRUCT_NULLABLE\": {\n"
          + "        'BOOLEAN_2unique_NULLABLE': False,\n"
          + "        'DATE_1unique_NULLABLE': '2019-01-01',\n"
          + "        'DATETIME_1unique_NULLABLE': '2019-01-01 00:00:00',\n"
          + "        'FLOAT_5000unique_NULLABLE': 1308,\n"
          + "        'FLOAT_5000unique_REPEATED': [2323, 1178],\n"
          + "        'FLOAT_5000unique_REQUIRED': 3089,\n"
          + "        'INTEGER_5000unique_NULLABLE': '1777',\n"
          + "        'NUMERIC_5000unique_NULLABLE': 3323,\n"
          + "        'TIME_1unique_NULLABLE': '23:59:59.999999',\n"
          + "        'STRING_5000unique_NULLABLE': 'str-49',\n"
          + "        'TIMESTAMP_1unique_NULLABLE': '1546387199999999'\n"
          + "    },\n"
          + "    \"TIMESTAMP_1unique_NULLABLE\": '1546387199999999',\n"
          + "    \"TIME_1unique_NULLABLE\": '23:59:59.999999'\n"
          + "}]";
  private static final String ENDPOINT_ID = System.getenv("PREDICT_TABLES_REGRESSION_ENDPOINT_ID");
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  private static void requireEnvVar(String varName) {
    String errorMessage =
        String.format("Environment variable '%s' is required to perform these tests.", varName);
    assertNotNull(errorMessage, System.getenv(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("UCAIP_PROJECT_ID");
    requireEnvVar("PREDICT_TABLES_REGRESSION_ENDPOINT_ID");
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown() {
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  public void testPredictTabularRegression() throws IOException {
    // Act
    PredictTabularRegressionSample.predictTabularRegression(INSTANCE, PROJECT, ENDPOINT_ID);

    // Assert
    String got = bout.toString();
    assertThat(got).contains("Predict Tabular Regression Response");
  }
}
