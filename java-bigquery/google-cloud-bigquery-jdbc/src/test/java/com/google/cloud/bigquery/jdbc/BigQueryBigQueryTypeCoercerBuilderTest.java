/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.bigquery.jdbc.TestType.Text;
import org.junit.Test;

public class BigQueryBigQueryTypeCoercerBuilderTest {

  @Test
  public void shouldBeAbleToConvertCustomTypes() {
    byte[] bytesArray = {72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100, 33};
    Text text = new Text(bytesArray);

    BigQueryTypeCoercer bigQueryTypeCoercer =
        new BigQueryTypeCoercerBuilder().registerTypeCoercion(new TextToStringCoercion()).build();

    assertThat(bigQueryTypeCoercer.coerceTo(String.class, text)).isEqualTo("Hello World!");
  }

  private static class TextToStringCoercion implements BigQueryCoercion<Text, String> {
    @Override
    public String coerce(Text value) {
      return new String(value.getBytes());
    }
  }
}
