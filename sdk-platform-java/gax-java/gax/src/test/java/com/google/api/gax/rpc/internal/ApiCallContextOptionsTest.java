/*
 * Copyright 2021 Google LLC
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
 *     * Neither the name of Google LLC nor the names of its
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
package com.google.api.gax.rpc.internal;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.rpc.ApiCallContext;
import org.junit.jupiter.api.Test;

class ApiCallContextOptionsTest {

  private static final ApiCallContext.Key<Integer> INTEGER_KEY = ApiCallContext.Key.create("key1");
  private static final ApiCallContext.Key<String> STRING_KEY = ApiCallContext.Key.create("key2");
  private static final ApiCallContext.Key<Double> DOUBLE_KEY = ApiCallContext.Key.create("key3");

  @Test
  void testWithOption() {
    ApiCallContextOptions options =
        ApiCallContextOptions.getDefaultOptions()
            .withOption(INTEGER_KEY, 1)
            .withOption(STRING_KEY, "test")
            .withOption(DOUBLE_KEY, 2.0);
    assertThat(options.getOption(INTEGER_KEY)).isEqualTo(1);
    assertThat(options.getOption(STRING_KEY)).isEqualTo("test");
    assertThat(options.getOption(DOUBLE_KEY)).isEqualTo(2.0);

    ApiCallContextOptions updatedOptions = options.withOption(INTEGER_KEY, 10);
    assertThat(updatedOptions.getOption(INTEGER_KEY)).isEqualTo(10);
    assertThat(options.getOption(STRING_KEY)).isEqualTo("test");
    assertThat(options.getOption(DOUBLE_KEY)).isEqualTo(2.0);
  }

  @Test
  void testMergeEmpty() {
    ApiCallContextOptions options =
        ApiCallContextOptions.getDefaultOptions()
            .withOption(INTEGER_KEY, 1)
            .withOption(STRING_KEY, "test");

    ApiCallContextOptions defaultOptions = ApiCallContextOptions.getDefaultOptions();

    ApiCallContextOptions mergedOptions1 = options.merge(defaultOptions);
    assertThat(mergedOptions1.getOption(INTEGER_KEY)).isEqualTo(1);
    assertThat(mergedOptions1.getOption(STRING_KEY)).isEqualTo("test");

    ApiCallContextOptions mergedOptions2 = defaultOptions.merge(options);
    assertThat(mergedOptions2.getOption(INTEGER_KEY)).isEqualTo(1);
    assertThat(mergedOptions2.getOption(STRING_KEY)).isEqualTo("test");
  }

  @Test
  void testMergeDifferentKeys() {
    ApiCallContextOptions options1 =
        ApiCallContextOptions.getDefaultOptions()
            .withOption(INTEGER_KEY, 1)
            .withOption(STRING_KEY, "test");
    ApiCallContextOptions options2 =
        ApiCallContextOptions.getDefaultOptions().withOption(DOUBLE_KEY, 5.0);
    ApiCallContextOptions mergedOptions = options1.merge(options2);
    assertThat(mergedOptions.getOption(INTEGER_KEY)).isEqualTo(1);
    assertThat(mergedOptions.getOption(STRING_KEY)).isEqualTo("test");
    assertThat(mergedOptions.getOption(DOUBLE_KEY)).isEqualTo(5.0);
  }

  @Test
  void testMergeDuplicateKeys() {
    ApiCallContextOptions options1 =
        ApiCallContextOptions.getDefaultOptions()
            .withOption(INTEGER_KEY, 1)
            .withOption(STRING_KEY, "test");
    ApiCallContextOptions options2 =
        ApiCallContextOptions.getDefaultOptions()
            .withOption(STRING_KEY, "newTest")
            .withOption(DOUBLE_KEY, 5.0);
    ApiCallContextOptions mergedOptions = options1.merge(options2);
    assertThat(mergedOptions.getOption(INTEGER_KEY)).isEqualTo(1);
    assertThat(mergedOptions.getOption(STRING_KEY)).isEqualTo("newTest");
    assertThat(mergedOptions.getOption(DOUBLE_KEY)).isEqualTo(5.0);
  }
}
