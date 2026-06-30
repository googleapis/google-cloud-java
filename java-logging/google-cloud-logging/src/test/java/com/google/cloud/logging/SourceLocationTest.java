/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.logging;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SourceLocationTest {

  private static final String FILE = "file";
  private static final Long LINE = 42L;
  private static final String FUNCTION = "function";
  private static final SourceLocation SOURCE_LOCATION =
      SourceLocation.newBuilder().setFile(FILE).setLine(LINE).setFunction(FUNCTION).build();

  @Test
  public void testBuilder() {
    assertEquals(FILE, SOURCE_LOCATION.getFile());
    assertEquals(LINE, SOURCE_LOCATION.getLine());
    assertEquals(FUNCTION, SOURCE_LOCATION.getFunction());
  }

  @Test
  public void testToBuilder() {
    compareSourceLocation(SOURCE_LOCATION, SOURCE_LOCATION.toBuilder().build());
    SourceLocation sourceLocation =
        SOURCE_LOCATION.toBuilder()
            .setFile("newFile")
            .setLine(43L)
            .setFunction("newFunction")
            .build();
    assertEquals("newFile", sourceLocation.getFile());
    assertEquals(Long.valueOf(43L), sourceLocation.getLine());
    assertEquals("newFunction", sourceLocation.getFunction());
    sourceLocation =
        sourceLocation.toBuilder().setFile(FILE).setLine(LINE).setFunction(FUNCTION).build();
    compareSourceLocation(SOURCE_LOCATION, sourceLocation);
  }

  @Test
  public void testToAndFromPb() {
    compareSourceLocation(SOURCE_LOCATION, SourceLocation.fromPb(SOURCE_LOCATION.toPb()));
  }

  @Test
  public void testFromCurrentContext() {
    StackTraceElement expectedData = new Exception().getStackTrace()[0];
    SourceLocation data = SourceLocation.fromCurrentContext();
    assertEquals(expectedData.getFileName(), data.getFile());
    assertEquals(expectedData.getMethodName(), data.getFunction());
    // mind the assertion is vs (expectedData.lineNumber + 1). it is because the
    // source location
    // info of the expectedData is one line above the source location of the tested
    // data.
    assertEquals(Long.valueOf(expectedData.getLineNumber() + 1), data.getLine());
  }

  @Test
  public void testFromCurrentContextWithExclusionList() {
    StackTraceElement expectedData = new Exception().getStackTrace()[0];
    SourceLocation data = SourceLocation.fromCurrentContext(LoggingImpl.class.getName());
    assertEquals(expectedData.getFileName(), data.getFile());
    assertEquals(expectedData.getMethodName(), data.getFunction());
    // mind the assertion is vs (expectedData.lineNumber + 1). it is because the
    // source location
    // info of the expectedData is one line above the source location of the tested
    // data.
    assertEquals(Long.valueOf(expectedData.getLineNumber() + 1), data.getLine());
  }

  @Test
  public void testFromCurrentContextWithVeryLargeLevel() {
    SourceLocation data =
        SourceLocation.fromCurrentContext("com.google", "sun", "java", "jdk", "org");
    assertNull(data);
  }

  private void compareSourceLocation(SourceLocation expected, SourceLocation value) {
    assertEquals(expected, value);
    assertEquals(expected.getFile(), value.getFile());
    assertEquals(expected.getLine(), value.getLine());
    assertEquals(expected.getFunction(), value.getFunction());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }
}
