/*
 * Copyright 2022 Google LLC
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

package com.google.api.gax.rpc;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.pathtemplate.PathTemplate;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RequestParamsBuilderTest {

  private RequestParamsBuilder requestParamsBuilder;

  @BeforeEach
  void setUp() {
    requestParamsBuilder = RequestParamsBuilder.create();
  }

  @Test
  void add_happyPath() {
    Map<String, String> actual =
        getRoutingHeaders(
            "projects/**/{table_location=instances/*}",
            "projects/my_cozy_home/instances/living_room");
    assertThat(actual).containsExactly("table_location", "instances/living_room");
  }

  @Test
  void add_twoParams_happyPath() {
    requestParamsBuilder.add("table_location", "instances/living_room");
    Map<String, String> actual = requestParamsBuilder.build();
    assertThat(actual).containsExactly("table_location", "instances/living_room");
  }

  @Test
  void add_containsNonEncodedHeaderAndValue() {
    PathTemplate pathTemplate = PathTemplate.create("projects/**/{table$$_++location=instances/*}");
    requestParamsBuilder.add(
        "projects/my_cozy_home/instances/living_room", "table$$_++location", pathTemplate);
    Map<String, String> actual = requestParamsBuilder.build();
    assertThat(actual).containsExactly("table$$_++location", "instances/living_room");
  }

  @Test
  void add_twoParams_containsNonEncodedHeaderAndValue() {
    requestParamsBuilder.add("table$$_++location", "instances/living_room");
    Map<String, String> actual = requestParamsBuilder.build();
    assertThat(actual).containsExactly("table$$_++location", "instances/living_room");
  }

  @Test
  void build_shouldKeepLastEntryIfMultipleEntriesHaveTheSameKeyRatherThanErrorOut() {
    requestParamsBuilder.add(
        "projects/my_cozy_home/instances/living_room",
        "table_location",
        PathTemplate.create("projects/**/{table_location=instances/*}"));
    requestParamsBuilder.add(
        "projects/my_cozy_home/instances/living_room",
        "table_location",
        PathTemplate.create("{table_location=**}"));
    requestParamsBuilder.add(
        "projects/my_cozy_home/instances/living_room",
        "routing_id",
        PathTemplate.create("{routing_id=**}"));
    Map<String, String> actual = requestParamsBuilder.build();

    // Should contain two entries instead of three, also should only keep the last entry if there
    // are multiple entries with the same key
    assertThat(actual)
        .containsExactly(
            "table_location",
            "projects/my_cozy_home/instances/living_room",
            "routing_id",
            "projects/my_cozy_home/instances/living_room");
  }

  @Test
  void add_matchedValuesWithNoRoutingHeaderKey() {
    Map<String, String> actual = getRoutingHeaders("projects/**", "projects/my_cozy_home/");
    assertThat(actual).isEmpty();
  }

  @Test
  void add_emptyMatchedValues() {
    Map<String, String> actual =
        getRoutingHeaders("projects/**/{table_location=instances/*}", "projects/does_not_matter");
    assertThat(actual).isEmpty();
  }

  @Test
  void add_nullFieldValue() {
    Map<String, String> actual = getRoutingHeaders("projects/**", null);
    assertThat(actual).isEmpty();
  }

  @Test
  void addWithTwoParams_nullFieldValue() {
    requestParamsBuilder.add("test", null);
    Map<String, String> actual = requestParamsBuilder.build();
    assertThat(actual).isEmpty();
  }

  @Test
  void add_emptyString_noMatches() {
    // protobuf's default value for string is empty string. The `**` pathtemplate would match
    // for empty string if it's not explicitly filtered out
    Map<String, String> actual = getRoutingHeaders("{table_location=**}", "");
    assertThat(actual).isEmpty();
  }

  @Test
  void addWithTwoParams_emptyString_noMatches() {
    // protobuf's default value for string is empty string. The `**` pathtemplate would match
    // for empty string if it's not explicitly filtered out
    Map<String, String> actual = getRoutingHeaders("{table_location=**}", "");
    assertThat(actual).isEmpty();
  }

  @Test
  void add_nullHeader_noMatches() {
    requestParamsBuilder.add(null, "projects/does_not_matter");
    Map<String, String> actual = requestParamsBuilder.build();
    assertThat(actual).isEmpty();
  }

  @Test
  void addWithTwoParams_nullHeader_noMatches() {
    requestParamsBuilder.add(null, "hello");
    Map<String, String> actual = requestParamsBuilder.build();
    assertThat(actual).isEmpty();
  }

  @Test
  void addWithTwoParams_emptyHeader_noMatches() {
    requestParamsBuilder.add("", "hello");
    Map<String, String> actual = requestParamsBuilder.build();
    assertThat(actual).isEmpty();
  }

  private Map<String, String> getRoutingHeaders(String patternString, String fieldValue) {
    PathTemplate pathTemplate = PathTemplate.create(patternString);
    requestParamsBuilder.add(fieldValue, "table_location", pathTemplate);
    return requestParamsBuilder.build();
  }
}
