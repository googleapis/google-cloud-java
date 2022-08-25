/*
 * Copyright 2021 Google LLC
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

package beta.video;

import static com.google.common.truth.Truth.assertThat;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration (system) tests for {@link StreamingAutoMlObjectTracking}. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class StreamingAutoMlObjectTrackingIT {

  private static String PROJECT_ID = System.getenv().get("GOOGLE_CLOUD_PROJECT");
  private static String MODEL_ID = System.getenv().get("VIDEO_OBJECT_TRACKING_MODEL_ID");

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
  public void testStreamingAutoMlObjectTracking() {
    // Bad Gateway sporadically occurs
    int tryCount = 0;
    int maxTries = 3;
    while (tryCount < maxTries) {
      try {
        StreamingAutoMlObjectTracking.streamingAutoMlObjectTracking(
            "resources/cat.mp4", PROJECT_ID, MODEL_ID);
        assertThat(bout.toString()).contains("Video streamed successfully.");

        break;
      } catch (StatusRuntimeException ex) {
        if (ex.getStatus().getCode() == Status.Code.UNAVAILABLE) {
          assertThat(ex.getMessage()).contains("Bad Gateway");
          tryCount++;
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
