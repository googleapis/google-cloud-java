// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.generator.gapic.composer.samplecode;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThrows;

import com.google.api.generator.test.utils.LineFormatter;
import org.junit.jupiter.api.Test;

class SampleBodyJavaFormatterTest {

  @Test
  void validFormatSampleCode_tryCatchStatement() {
    String samplecode = LineFormatter.lines("try(boolean condition = false){", "int x = 3;", "}");
    String result = SampleBodyJavaFormatter.format(samplecode);
    String expected =
        LineFormatter.lines("try (boolean condition = false) {\n", "  int x = 3;\n", "}");
    assertEquals(expected, result);
  }

  @Test
  void validFormatSampleCode_longLineStatement() {
    String sampleCode =
        "SubscriptionAdminSettings subscriptionAdminSettings = "
            + "SubscriptionAdminSettings.newBuilder().setEndpoint(myEndpoint).build();";
    String result = SampleBodyJavaFormatter.format(sampleCode);
    String expected =
        LineFormatter.lines(
            "SubscriptionAdminSettings subscriptionAdminSettings =\n",
            "    SubscriptionAdminSettings.newBuilder().setEndpoint(myEndpoint).build();");
    assertEquals(expected, result);
  }

  @Test
  void validFormatSampleCode_longChainMethod() {
    String sampleCode =
        "echoSettingsBuilder.echoSettings().setRetrySettings("
            + "echoSettingsBuilder.echoSettings().getRetrySettings().toBuilder()"
            + ".setTotalTimeout(Duration.ofSeconds(30)).build());";
    String result = SampleBodyJavaFormatter.format(sampleCode);
    String expected =
        LineFormatter.lines(
            "echoSettingsBuilder\n",
            "    .echoSettings()\n",
            "    .setRetrySettings(\n",
            "        echoSettingsBuilder\n",
            "            .echoSettings()\n",
            "            .getRetrySettings()\n",
            "            .toBuilder()\n",
            "            .setTotalTimeout(Duration.ofSeconds(30))\n",
            "            .build());");
    assertEquals(expected, result);
  }

  @Test
  void invalidFormatSampleCode_nonStatement() {
    assertThrows(
        SampleBodyJavaFormatter.FormatException.class,
        () -> {
          SampleBodyJavaFormatter.format("abc");
        });
  }
}
