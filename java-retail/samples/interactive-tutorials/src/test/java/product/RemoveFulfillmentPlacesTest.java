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

package product;

import static com.google.common.truth.Truth.assertThat;
import static product.RemoveFulfillmentPlaces.removeFulfillmentPlaces;
import static setup.SetupCleanup.createProduct;
import static setup.SetupCleanup.deleteProduct;
import static setup.SetupCleanup.getProduct;

import com.google.cloud.ServiceOptions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RemoveFulfillmentPlacesTest {

  private ByteArrayOutputStream bout;
  private PrintStream originalPrintStream;

  @Before
  public void setUp() throws IOException, InterruptedException, ExecutionException {
    String projectId = ServiceOptions.getDefaultProjectId();
    String generatedProductId = UUID.randomUUID().toString();
    String productName =
        String.format(
            "projects/%s/locations/global/catalogs/default_catalog/branches/0/products/%s",
            projectId, generatedProductId);
    bout = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);

    createProduct(generatedProductId);
    removeFulfillmentPlaces(productName, "store0");
    getProduct(productName);
    deleteProduct(productName);
  }

  @Test
  public void testRemoveFulfillmentPlaces() {
    String outputResult = bout.toString();

    assertThat(outputResult).contains("Remove fulfilment places with current date");
    assertThat(outputResult).contains("Remove fulfillment places, wait 30 seconds");
    assertThat(outputResult).contains("Delete product request name");
    assertThat(outputResult).contains("was deleted");
  }

  @After
  public void tearDown() {
    System.out.flush();
    System.setOut(originalPrintStream);
  }
}
