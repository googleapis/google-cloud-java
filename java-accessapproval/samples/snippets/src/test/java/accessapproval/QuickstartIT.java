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

package accessapproval;

import static org.junit.Assert.assertEquals;

import com.google.cloud.testing.junit4.StdOutCaptureRule;
import com.google.common.base.Strings;
import java.io.IOException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

public class QuickstartIT {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");

  @Rule public StdOutCaptureRule stdOutCap = new StdOutCaptureRule();

  @BeforeClass
  public static void beforeAll() throws Exception {
    Assert.assertFalse("missing GOOGLE_CLOUD_PROJECT", Strings.isNullOrEmpty(PROJECT_ID));
  }

  @Test
  public void testQuickstart() throws IOException {
    Quickstart quickstart = new Quickstart();
    quickstart.quickstart(PROJECT_ID);
    assertEquals("No approval requests found\n", stdOutCap.getCapturedOutputAsUtf8String());
  }
}
