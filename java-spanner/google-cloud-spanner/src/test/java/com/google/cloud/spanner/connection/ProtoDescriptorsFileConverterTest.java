/*
 * Copyright 2024 Google LLC
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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.connection.ClientSideStatementImpl.CompileException;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.ProtoDescriptorsFileConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ProtoDescriptorsFileConverterTest {
  @Test
  public void testConvert() throws CompileException {
    String allowedValues =
        ReadOnlyStalenessConverterTest.getAllowedValues(
            ProtoDescriptorsFileConverter.class, Dialect.GOOGLE_STANDARD_SQL);
    assertNotNull(allowedValues);
    ProtoDescriptorsFileConverter converter = new ProtoDescriptorsFileConverter(allowedValues);

    assertNull(converter.convert(""));
    assertNull(converter.convert(null));

    String filePath = "com/google/cloud/spanner/descriptors.pb";
    assertEquals(converter.convert(filePath), filePath);
  }
}
