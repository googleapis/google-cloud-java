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

package prediction;

import static com.google.common.truth.Truth.assertThat;
import static prediction.PredictionWithParameters.predict;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PredictionWithParametersTest {

  private ByteArrayOutputStream bout;
  private PrintStream originalPrintStream;

  @Before
  public void setUp() throws IOException, InterruptedException {
    bout = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @Test
  public void testPredict() {
    String projectId = System.getenv("GOOGLE_CLOUD_PROJECT");
    String placementId = System.getenv("GOOGLE_CLOUD_PLACEMENT");
    String predictPlacement =
        String.format(
            "projects/%s/locations/global/catalogs/default_catalog/placements/%s",
            projectId, placementId);

    predict(predictPlacement);

    String outputResult = bout.toString();

    assertThat(outputResult).contains("Predict request");
    assertThat(outputResult)
        .contains(
            "params {\n"
                + "  key: \"priceRerankLevel\"\n"
                + "  value {\n"
                + "    string_value: \"low-price-reranking\"\n"
                + "  }\n"
                + "}");
    assertThat(outputResult).contains("Predict response");
  }

  @After
  public void tearDown() {
    System.out.flush();
    System.setOut(originalPrintStream);
  }
}
