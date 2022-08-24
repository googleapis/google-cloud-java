/*
 * Copyright 2017 Google Inc.
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

package beta.example.language;

import static com.google.common.truth.Truth.assertThat;

import com.example.language.Analyze;
import com.google.cloud.language.v1beta2.Sentiment;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration (system) tests for {@link Analyze}. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class AnalyzeBetaIT {

  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown() {
    // restores print statements in the original method
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  public void analyzeSentiment_returnPositiveGerman() throws Exception {
    Sentiment sentiment =
        AnalyzeBeta.analyzeSentimentText("Ich hatte die schönste Erfahrung mit euch allen.", "DE");
    assertThat(sentiment.getMagnitude()).isGreaterThan(0.0F);
    assertThat(sentiment.getScore()).isGreaterThan(0.0F);
  }

  @Test
  public void analyzeCategoriesInTextReturnsExpectedResult() throws Exception {
    AnalyzeBeta.classifyText(
        "Android is a mobile operating system developed by Google, "
            + "based on the Linux kernel and designed primarily for touchscreen "
            + "mobile devices such as smartphones and tablets.");
    String got = bout.toString();
    assertThat(got).contains("Computers & Electronics");
  }

  @Test
  public void analyzeCategoriesInFileReturnsExpectedResult() throws Exception {
    String gcsFile = "gs://cloud-samples-data/language/android.txt";
    AnalyzeBeta.classifyFile(gcsFile);
    String got = bout.toString();
    assertThat(got).contains("Computers & Electronics");
  }
}
