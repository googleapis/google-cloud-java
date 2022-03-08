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

package init;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.StreamGobbler;

public class CreateTestResourcesTest {

  private String output;

  @Before
  public void setUp() throws IOException, InterruptedException, ExecutionException {
    Process exec =
        Runtime.getRuntime()
            .exec("mvn compile exec:java -Dexec.mainClass=init.CreateTestResources");
    StreamGobbler streamGobbler = new StreamGobbler(exec.getInputStream());
    Future<String> stringFuture = Executors.newSingleThreadExecutor().submit(streamGobbler);

    output = stringFuture.get();
  }

  @Test
  public void testCreateTestResources() {
    Assert.assertTrue(output.matches("(?s)^(.*Creating new bucket.*)$"));
    Assert.assertTrue(output.matches("(?s)^(.*Import products operation is completed.*)$"));
    Assert.assertTrue(output.matches("(?s)^(.*Number of successfully imported products:.*)$"));
    Assert.assertTrue(output.matches("(?s)^(.*Number of failures during the importing:.*)$"));
    Assert.assertTrue(output.matches("(?s)^(.*Creating new bucket:.*)$"));
    Assert.assertTrue(output.matches("(?s)^(.*Json from GCS successfully loaded in a table.*)$"));
  }
}
