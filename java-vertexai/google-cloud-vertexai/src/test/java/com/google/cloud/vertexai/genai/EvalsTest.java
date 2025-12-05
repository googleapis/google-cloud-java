/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.vertexai.genai;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.genai.errors.ClientException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class EvalsTest {

  @Test
  public void testEvals_getEvaluationItem() {
    Client client = Client.builder().vertexAI(true).build();
    String evalItemName =
        "projects/964831358985/locations/us-central1/evaluationItems/7028650070790635520";

    // Assuming an invalid resource name causes a ClientException with status code 404.
    ClientException e =
        assertThrows(
            ClientException.class, () -> client.evals.privateGetEvaluationItem(evalItemName, null));
    assertThat(e.code()).isEqualTo(404);
  }
}
