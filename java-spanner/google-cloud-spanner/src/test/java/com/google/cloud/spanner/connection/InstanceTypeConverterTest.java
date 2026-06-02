/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.google.cloud.spanner.SpannerOptions.InstanceType;
import com.google.cloud.spanner.connection.ClientSideStatementImpl.CompileException;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.InstanceTypeConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class InstanceTypeConverterTest {

  @Test
  public void testConvert() throws CompileException {
    String allowedValues =
        "'"
            + java.util.Arrays.stream(InstanceType.values())
                .map(Enum::name)
                .collect(java.util.stream.Collectors.joining("|", "(", ")"))
            + "'";
    InstanceTypeConverter converter = new InstanceTypeConverter(allowedValues);

    assertEquals(InstanceType.CLOUD, converter.convert("cloud"));
    assertEquals(InstanceType.CLOUD, converter.convert("CLOUD"));
    assertEquals(InstanceType.CLOUD, converter.convert("Cloud"));

    assertEquals(InstanceType.OMNI, converter.convert("omni"));
    assertEquals(InstanceType.OMNI, converter.convert("OMNI"));
    assertEquals(InstanceType.OMNI, converter.convert("Omni"));

    assertNull(converter.convert(""));
    assertNull(converter.convert(" "));
    assertNull(converter.convert("random string"));
    assertNull(converter.convert("NULL"));
  }
}
