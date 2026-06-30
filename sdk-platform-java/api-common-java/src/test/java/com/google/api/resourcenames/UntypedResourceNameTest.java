/*
 * Copyright 2018, Google Inc.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.resourcenames;

import static junit.framework.TestCase.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** Tests for {@link UntypedResourceNameTest}. */
class UntypedResourceNameTest {
  private static final String NAME_STRING = "sunshine";
  private static final String EMPTY_STRING = "";

  @Test
  void testGetFieldValues() {
    assertTrue(UntypedResourceName.isParsableFrom(NAME_STRING));
    UntypedResourceName fooName = UntypedResourceName.parse(NAME_STRING);

    Map<String, String> fieldValuesMap = fooName.getFieldValuesMap();
    assertTrue(fieldValuesMap.containsKey(EMPTY_STRING));
    assertEquals(NAME_STRING, fieldValuesMap.get(EMPTY_STRING));
    assertEquals(1, fieldValuesMap.size());
    assertEquals(null, fieldValuesMap.get(NAME_STRING));
  }

  @Test
  void testInsertIntoFieldValuesMap() {
    UntypedResourceName fooName = UntypedResourceName.parse(NAME_STRING);
    Map<String, String> fieldValuesMap = fooName.getFieldValuesMap();

    try {
      fieldValuesMap.put(EMPTY_STRING, "foo");
      fail("fieldValuesMap should prevent insertion into internal map. ");
    } catch (UnsupportedOperationException e) {
    }

    try {
      fieldValuesMap.put(null, "foo");
      fail("fieldValuesMap should prevent insertion into internal map. ");
    } catch (UnsupportedOperationException e) {
    }

    try {
      fieldValuesMap.put(NAME_STRING, NAME_STRING);
      fail("fieldValuesMap should prevent insertion into internal map. ");
    } catch (UnsupportedOperationException e) {
    }
  }

  @Test
  void testNullName() {
    assertFalse(UntypedResourceName.isParsableFrom(null));
    Assertions.assertThrows(NullPointerException.class, () -> UntypedResourceName.parse(null));
  }
}
