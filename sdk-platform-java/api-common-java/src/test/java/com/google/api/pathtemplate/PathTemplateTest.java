/*
 * Copyright 2016, Google Inc.
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

package com.google.api.pathtemplate;

import com.google.common.collect.ImmutableMap;
import com.google.common.truth.Truth;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/** Tests for {@link PathTemplate}. */
class PathTemplateTest {

  // Match
  // =====

  @Test
  void matchAtomicResourceName() {
    PathTemplate template = PathTemplate.create("buckets/*/*/objects/*");
    assertPositionalMatch(template.match("buckets/f/o/objects/bar"), "f", "o", "bar");
  }

  @Test
  void matchTemplateWithUnboundedWildcard() {
    PathTemplate template = PathTemplate.create("buckets/*/objects/**");
    assertPositionalMatch(template.match("buckets/foo/objects/bar/baz"), "foo", "bar/baz");
  }

  @Test
  void matchWithForcedHostName() {
    PathTemplate template = PathTemplate.create("buckets/*/objects/*");
    Map<String, String> match = template.matchFromFullName("somewhere.io/buckets/b/objects/o");
    Truth.assertThat(match).isNotNull();
    Truth.assertThat(match.get(PathTemplate.HOSTNAME_VAR)).isEqualTo("somewhere.io");
    Truth.assertThat(match.get("$0")).isEqualTo("b");
    Truth.assertThat(match.get("$1")).isEqualTo("o");
  }

  @Test
  void matchWithHostName() {
    PathTemplate template = PathTemplate.create("buckets/*/objects/*");
    Map<String, String> match = template.match("//somewhere.io/buckets/b/objects/o");
    Truth.assertThat(match).isNotNull();
    Truth.assertThat(match.get(PathTemplate.HOSTNAME_VAR)).isEqualTo("//somewhere.io");
    Truth.assertThat(match.get("$0")).isEqualTo("b");
    Truth.assertThat(match.get("$1")).isEqualTo("o");
  }

  @Test
  void matchWithHostNameAndProtocol() {
    PathTemplate template = PathTemplate.create("projects/{project}/zones/{zone}");
    Map<String, String> match =
        template.match(
            "https://www.googleapis.com/compute/v1/projects/project-123/zones/europe-west3-c");
    Truth.assertThat(match).isNotNull();
    Truth.assertThat(match.get(PathTemplate.HOSTNAME_VAR)).isEqualTo("https://www.googleapis.com");
    Truth.assertThat(match.get("project")).isEqualTo("project-123");
    Truth.assertThat(match.get("zone")).isEqualTo("europe-west3-c");
  }

  @Test
  void matchWithHostNameAndProtocolWithTemplateStartWithBinding() {
    PathTemplate template = PathTemplate.create("{project}/zones/{zone}");
    Map<String, String> match =
        template.match(
            "https://www.googleapis.com/compute/v1/projects/project-123/zones/europe-west3-c");
    Truth.assertThat(match).isNotNull();
    Truth.assertThat(match.get(PathTemplate.HOSTNAME_VAR)).isEqualTo("https://www.googleapis.com");
    Truth.assertThat(match.get("project")).isEqualTo("project-123");
    Truth.assertThat(match.get("zone")).isEqualTo("europe-west3-c");
  }

  @Test
  void pathWildcards_matchZeroOrMoreSegments() {
    PathTemplate start = PathTemplate.create("{glob=**}/b");
    PathTemplate middle = PathTemplate.create("a/{glob=**}/b");
    PathTemplate end = PathTemplate.create("a/{glob=**}");
    PathTemplate endWithCustomVerb = PathTemplate.create("a/{glob=**}:foo");

    Truth.assertThat(start.match("b").get("glob")).isEmpty();
    Truth.assertThat(start.match("/b").get("glob")).isEmpty();
    Truth.assertThat(start.match("a/b").get("glob")).isEqualTo("a");
    Truth.assertThat(start.match("a/a/a/b").get("glob")).isEqualTo("a/a/a");

    Truth.assertThat(middle.match("a/b").get("glob")).isEmpty();
    Truth.assertThat(middle.match("a//b").get("glob")).isEmpty();
    Truth.assertThat(middle.match("a/x/b").get("glob")).isEqualTo("x");
    Truth.assertThat(middle.match("a/x/y/z/b").get("glob")).isEqualTo("x/y/z");

    Truth.assertThat(end.match("a").get("glob")).isEmpty();
    Truth.assertThat(end.match("a/").get("glob")).isEmpty();
    Truth.assertThat(end.match("a/b").get("glob")).isEqualTo("b");
    Truth.assertThat(end.match("a/b/b/b").get("glob")).isEqualTo("b/b/b");

    Truth.assertThat(endWithCustomVerb.match("a/:foo").get("glob")).isEmpty();
    Truth.assertThat(endWithCustomVerb.match("a/b:foo").get("glob")).isEqualTo("b");
    Truth.assertThat(endWithCustomVerb.match("a/b/b:foo").get("glob")).isEqualTo("b/b");
  }

  @Test
  void pathWildcard_canMatchTheEmptyString() {
    PathTemplate template = PathTemplate.create("{glob=**}");

    Truth.assertThat(template.match("").get("glob")).isEmpty();
    Truth.assertThat(template.match("a").get("glob")).isEqualTo("a");
    Truth.assertThat(template.match("a/b").get("glob")).isEqualTo("a/b");
  }

  @Test
  void matchWithCustomMethod() {
    PathTemplate template = PathTemplate.create("buckets/*/objects/*:custom");
    Map<String, String> match = template.match("buckets/b/objects/o:custom");
    Truth.assertThat(match).isNotNull();
    Truth.assertThat(match.get("$0")).isEqualTo("b");
    Truth.assertThat(match.get("$1")).isEqualTo("o");
  }

  @Test
  void matchFailWhenPathMismatch() {
    PathTemplate template = PathTemplate.create("buckets/*/*/objects/*");
    Truth.assertThat(template.match("buckets/f/o/o/objects/bar")).isNull();
  }

  @Test
  void matchFailWhenPathTooShort() {
    PathTemplate template = PathTemplate.create("buckets/*/*/objects/*");
    Truth.assertThat(template.match("buckets/f/o/objects")).isNull();
  }

  @Test
  void matchFailWhenPathTooLong() {
    PathTemplate template = PathTemplate.create("buckets/*/*/objects/*");
    Truth.assertThat(template.match("buckets/f/o/objects/too/long")).isNull();
  }

  @Test
  void matchWithUnboundInMiddle() {
    PathTemplate template = PathTemplate.create("bar/**/foo/*");
    assertPositionalMatch(template.match("bar/foo/foo/foo/bar"), "foo/foo", "bar");
  }

  @Test
  void matchWithNamedBindings() {
    PathTemplate template = PathTemplate.create("projects/*/{instance_id=instances/*}/**");
    Map<String, String> actual =
        template.match("projects/proj_foo/instances/instance_bar/table/table_baz");
    Truth.assertThat(actual).containsEntry("instance_id", "instances/instance_bar");
  }

  @Test
  void matchFailWithNamedBindingsWhenPathMismatches() {
    PathTemplate template = PathTemplate.create("projects/*/{instance_id=instances/*}/**");
    Map<String, String> actual =
        template.match("projects/proj_foo/instances_fail/instance_bar/table/table_baz");
    Truth.assertThat(actual).isNull();
  }

  @Test
  void matchWithNamedBindingsThatHasOnlyWildcard() {
    PathTemplate template = PathTemplate.create("profiles/{routing_id=*}");
    Map<String, String> actual = template.match("profiles/prof_qux");
    Truth.assertThat(actual).containsEntry("routing_id", "prof_qux");
  }

  @Test
  void matchFailWithNamedBindingsThatHasOnlyWildcardWhenPathMismatches() {
    PathTemplate template = PathTemplate.create("profiles/{routing_id=*}");
    Map<String, String> actual = template.match("profiles/prof_qux/fail");
    Truth.assertThat(actual).isNull();
  }

  @Test
  void matchWithCustomVerbs() {
    PathTemplate template = PathTemplate.create("**:foo");
    assertPositionalMatch(template.match("a/b/c:foo"), "a/b/c");
  }

  // Complex Resource ID Segments.
  // ========

  @Test
  void complexResourceIdBasicCases() {
    // Separate by "~".
    PathTemplate template = PathTemplate.create("projects/{project}/zones/{zone_a}~{zone_b}");
    Map<String, String> match =
        template.match(
            "https://www.googleapis.com/compute/v1/projects/project-123/zones/europe-west3-c~us-east3-a");
    Truth.assertThat(match).isNotNull();
    Truth.assertThat(match.get(PathTemplate.HOSTNAME_VAR)).isEqualTo("https://www.googleapis.com");
    Truth.assertThat(match.get("project")).isEqualTo("project-123");
    Truth.assertThat(match.get("zone_a}~{zone_b")).isNull();
    Truth.assertThat(match.get("zone_a")).isEqualTo("europe-west3-c");
    Truth.assertThat(match.get("zone_b")).isEqualTo("us-east3-a");

    // Separate by "-".
    template = PathTemplate.create("projects/{project}/zones/{zone_a}-{zone_b}");
    match = template.match("projects/project-123/zones/europe-west3-c~us-east3-a");
    Truth.assertThat(match).isNotNull();
    Truth.assertThat(match.get("project")).isEqualTo("project-123");
    Truth.assertThat(match.get("zone_a")).isEqualTo("europe");
    Truth.assertThat(match.get("zone_b")).isEqualTo("west3-c~us-east3-a");

    // Separate by ".".
    template = PathTemplate.create("projects/{project}/zones/{zone_a}.{zone_b}");
    match = template.match("projects/project-123/zones/europe-west3-c.us-east3-a");
    Truth.assertThat(match).isNotNull();
    Truth.assertThat(match.get("project")).isEqualTo("project-123");
    Truth.assertThat(match.get("zone_a")).isEqualTo("europe-west3-c");
    Truth.assertThat(match.get("zone_b")).isEqualTo("us-east3-a");

    // Separate by "_".
    template = PathTemplate.create("projects/{project}/zones/{zone_a}_{zone_b}");
    match = template.match("projects/project-123/zones/europe-west3-c_us-east3-a");
    Truth.assertThat(match).isNotNull();
    Truth.assertThat(match.get("project")).isEqualTo("project-123");
    Truth.assertThat(match.get("zone_a")).isEqualTo("europe-west3-c");
    Truth.assertThat(match.get("zone_b")).isEqualTo("us-east3-a");
  }

  @Test
  void complexResourceIdCustomVerb() {
    // Separate by "~".
    PathTemplate template = PathTemplate.create("projects/{project}/zones/{zone_a}~{zone_b}:hello");
    Map<String, String> match =
        template.match(
            "https://www.googleapis.com/compute/v1/projects/project-123/zones/europe-west3-c~us-east3-a:hello");
    Truth.assertThat(match).isNotNull();
    Truth.assertThat(match.get(PathTemplate.HOSTNAME_VAR)).isEqualTo("https://www.googleapis.com");
    Truth.assertThat(match.get("project")).isEqualTo("project-123");
    Truth.assertThat(match.get("zone_a}~{zone_b")).isNull();
    Truth.assertThat(match.get("zone_a")).isEqualTo("europe-west3-c");
    Truth.assertThat(match.get("zone_b")).isEqualTo("us-east3-a");

    // Separate by "-".
    template = PathTemplate.create("projects/{project}/zones/{zone_a}-{zone_b}:hello");
    match = template.match("projects/project-123/zones/europe-west3-c~us-east3-a:hello");
    Truth.assertThat(match).isNotNull();
    Truth.assertThat(match.get("project")).isEqualTo("project-123");
    Truth.assertThat(match.get("zone_a")).isEqualTo("europe");
    Truth.assertThat(match.get("zone_b")).isEqualTo("west3-c~us-east3-a");

    // Separate by ".".
    template = PathTemplate.create("projects/{project}/zones/{zone_a}.{zone_b}:hello");
    match = template.match("projects/project-123/zones/europe-west3-c.us-east3-a:hello");
    Truth.assertThat(match).isNotNull();
    Truth.assertThat(match.get("project")).isEqualTo("project-123");
    Truth.assertThat(match.get("zone_a")).isEqualTo("europe-west3-c");
    Truth.assertThat(match.get("zone_b")).isEqualTo("us-east3-a");

    // Separate by "_".
    template = PathTemplate.create("projects/{project}/zones/{zone_a}_{zone_b}:hello");
    match = template.match("projects/project-123/zones/europe-west3-c_us-east3-a:hello");
    Truth.assertThat(match).isNotNull();
    Truth.assertThat(match.get("project")).isEqualTo("project-123");
    Truth.assertThat(match.get("zone_a")).isEqualTo("europe-west3-c");
    Truth.assertThat(match.get("zone_b")).isEqualTo("us-east3-a");
  }

  @Test
  void complexResourceIdEqualsWildcard() {
    PathTemplate template = PathTemplate.create("projects/{project=*}/zones/{zone_a=*}~{zone_b=*}");
    Map<String, String> match =
        template.match("projects/project-123/zones/europe-west3-c~us-east3-a");
    Truth.assertThat(match).isNotNull();
    Truth.assertThat(match.get("project")).isEqualTo("project-123");
    Truth.assertThat(match.get("zone_a}~{zone_b")).isNull();
    Truth.assertThat(match.get("zone_a")).isEqualTo("europe-west3-c");
    Truth.assertThat(match.get("zone_b")).isEqualTo("us-east3-a");
  }

  @Test
  void complexResourceIdEqualsPathWildcard() {
    Exception exception =
        Assertions.assertThrows(
            ValidationException.class,
            () -> PathTemplate.create("projects/{project=*}/zones/{zone_a=**}~{zone_b}"));
    Assertions.assertEquals(
        String.format(
            "parse error: wildcard path not allowed in complex ID resource '%s'", "zone_a"),
        exception.getMessage());
  }

  @Test
  void complexResourceIdMissingMatches() {
    PathTemplate template = PathTemplate.create("projects/{project}/zones/{zone_a}~{zone_b}");
    Truth.assertThat(template.match("projects/project-123/zones/europe-west3-c")).isNull();

    template = PathTemplate.create("projects/{project}/zones/{zone_a}~{zone_b}.{zone_c}");
    Map<String, String> match =
        template.match("projects/project-123/zones/europe-west3-c~.us-east3-a");
    Truth.assertThat(match).isNotNull();
    Truth.assertThat(match.get("project")).isEqualTo("project-123");
    Truth.assertThat(match.get("zone_a}~{zone_b")).isNull();
    Truth.assertThat(match.get("zone_a")).isEqualTo("europe-west3-c");
    Truth.assertThat(match.get("zone_b")).isEmpty();
    Truth.assertThat(match.get("zone_c")).isEqualTo("us-east3-a");
  }

  @Test
  void complexResourceIdNoSeparator() {
    Exception exception =
        Assertions.assertThrows(
            ValidationException.class,
            () -> PathTemplate.create("projects/{project}/zones/{zone_a}{zone_b}"));
    Assertions.assertEquals(
        String.format(
            "parse error: missing or 2+ consecutive delimiter characters in '%s'",
            "{zone_a}{zone_b}"),
        exception.getMessage());

    exception =
        Assertions.assertThrows(
            ValidationException.class,
            () -> PathTemplate.create("projects/{project}/zones/{zone_a}_{zone_b}{zone_c}"));
    Assertions.assertEquals(
        String.format(
            "parse error: missing or 2+ consecutive delimiter characters in '%s'",
            "{zone_a}_{zone_b}{zone_c}"),
        exception.getMessage());

    exception =
        Assertions.assertThrows(
            ValidationException.class,
            () -> PathTemplate.create("projects/{project=*}/zones/{zone_a}{{zone_b}"));
    Assertions.assertEquals(
        String.format(
            "parse error: missing or 2+ consecutive delimiter characters in '%s'",
            "{zone_a}{{zone_b}"),
        exception.getMessage());
  }

  @ParameterizedTest
  @MethodSource("invalidDelimiters")
  void complexResourceIdInvalidDelimiter(String invalidDelimiter) {
    ValidationException exception =
        Assertions.assertThrows(
            ValidationException.class,
            () ->
                PathTemplate.create(
                    String.format(
                        "projects/{project=*}/zones/{zone_a}%s{zone_b}", invalidDelimiter)));
    Assertions.assertEquals(
        String.format(
            "parse error: invalid complex resource ID delimiter character in '%s'",
            String.format("zone_a}%s{zone_b}", invalidDelimiter)),
        exception.getMessage());
  }

  static Stream<String> invalidDelimiters() {
    return Stream.of("|", "!", "@", "a", "1", ",", ")");
  }

  @Test
  void complexResourceIdMixedSeparators() {
    // Separate by a mix of delimiters.
    PathTemplate template =
        PathTemplate.create("projects/{project}/zones/{zone_a}~{zone_b}.{zone_c}-{zone_d}");
    Map<String, String> match =
        template.match(
            "https://www.googleapis.com/compute/v1/projects/project-123/zones/europe-west3-c~us-east3-a.us-west2-b-europe-west2-b");
    Truth.assertThat(match).isNotNull();
    Truth.assertThat(match.get(PathTemplate.HOSTNAME_VAR)).isEqualTo("https://www.googleapis.com");
    Truth.assertThat(match.get("project")).isEqualTo("project-123");
    Truth.assertThat(match.get("zone_a")).isEqualTo("europe-west3-c");
    Truth.assertThat(match.get("zone_b")).isEqualTo("us-east3-a");
    Truth.assertThat(match.get("zone_c")).isEqualTo("us");
    Truth.assertThat(match.get("zone_d")).isEqualTo("west2-b-europe-west2-b");

    template = PathTemplate.create("projects/{project}/zones/{zone_a}.{zone_b}.{zone_c}~{zone_d}");
    match =
        template.match(
            "https://www.googleapis.com/compute/v1/projects/project-123/zones/europe-west3-c.us-east3-a.us-west2-b~europe-west2-b");
    Truth.assertThat(match).isNotNull();
    Truth.assertThat(match.get(PathTemplate.HOSTNAME_VAR)).isEqualTo("https://www.googleapis.com");
    Truth.assertThat(match.get("project")).isEqualTo("project-123");
    Truth.assertThat(match.get("zone_a")).isEqualTo("europe-west3-c");
    Truth.assertThat(match.get("zone_b")).isEqualTo("us-east3-a");
    Truth.assertThat(match.get("zone_c")).isEqualTo("us-west2-b");
    Truth.assertThat(match.get("zone_d")).isEqualTo("europe-west2-b");
  }

  @Test
  void collectionWildcardMatchingInParent() {
    PathTemplate template = PathTemplate.create("v1/publishers/-/books/{book}");
    Map<String, String> match =
        template.match(
            "https://example.googleapis.com/v1/publishers/publisher-abc/books/blockchain_for_babies");
    Truth.assertThat(match).isNotNull();

    template = PathTemplate.create("/v1/{parent=rooms/-}/blurbs/{blurb}");
    match = template.match("https://example.googleapis.com/v1/rooms/den/blurbs/asdf");
    Truth.assertThat(match).isNotNull();
  }

  @Test
  void collectionWildcardMatchingInvalid() {
    ValidationException exception =
        Assertions.assertThrows(
            ValidationException.class,
            () -> PathTemplate.create("v1/publishers/{publisher}/books/-"));
  }
  ;

  @Test
  void complexResourceIdPubSubDeletedTopic() {
    PathTemplate template = PathTemplate.create("_deleted-topic_");
    Truth.assertThat(template).isNotNull();
  }

  @Test
  void complexResourceIdInParent() {
    // One parent has a complex resource ID.
    PathTemplate template =
        PathTemplate.create(
            "projects/{project}/zones/{zone_a}-{zone_b}_{zone_c}/machines/{machine}");
    Map<String, String> match =
        template.match(
            "https://www.googleapis.com/compute/v1/projects/project-123/zones/europe-west3-c-us-east3-a_us-west2-b/machines/roomba");
    Truth.assertThat(match).isNotNull();
    Truth.assertThat(match.get(PathTemplate.HOSTNAME_VAR)).isEqualTo("https://www.googleapis.com");
    Truth.assertThat(match.get("project")).isEqualTo("project-123");
    Truth.assertThat(match.get("zone_a")).isEqualTo("europe");
    Truth.assertThat(match.get("zone_b")).isEqualTo("west3-c-us-east3-a");
    Truth.assertThat(match.get("zone_c")).isEqualTo("us-west2-b");
    Truth.assertThat(match.get("machine")).isEqualTo("roomba");

    // All parents and resource IDs have complex resource IDs.
    template =
        PathTemplate.create(
            "projects/{foo}_{bar}/zones/{zone_a}-{zone_b}_{zone_c}/machines/{cell1}.{cell2}");
    match =
        template.match(
            "https://www.googleapis.com/compute/v1/projects/project_123/zones/europe-west3-c-us-east3-a_us-west2-b/machines/roomba.broomba");
    Truth.assertThat(match).isNotNull();
    Truth.assertThat(match.get(PathTemplate.HOSTNAME_VAR)).isEqualTo("https://www.googleapis.com");
    Truth.assertThat(match.get("foo")).isEqualTo("project");
    Truth.assertThat(match.get("bar")).isEqualTo("123");
    Truth.assertThat(match.get("zone_a")).isEqualTo("europe");
    Truth.assertThat(match.get("zone_b")).isEqualTo("west3-c-us-east3-a");
    Truth.assertThat(match.get("zone_c")).isEqualTo("us-west2-b");
    Truth.assertThat(match.get("cell1")).isEqualTo("roomba");
    Truth.assertThat(match.get("cell2")).isEqualTo("broomba");
  }

  @Test
  void complexResourcePathTemplateVariables() {
    String pattern =
        "projects/{foo}_{bar}/zones/{zone_a}-{zone_b}_{zone_c}/machines/{cell1}.{cell2}";
    PathTemplate template = PathTemplate.create(pattern);
    Set<String> variables = template.vars();
    Truth.assertThat(variables)
        .containsExactly("foo", "bar", "zone_a", "zone_b", "zone_c", "cell1", "cell2");

    pattern = "projects/{foo}_{bar}/zones/*";
    template = PathTemplate.create(pattern);
    Map<String, String> match =
        template.match("https://www.googleapis.com/compute/v1/projects/foo1_bar2/zones/azone");
    Truth.assertThat(match).isNotNull();
    Truth.assertThat(match.get("foo")).isEqualTo("foo1");
    Truth.assertThat(match.get("bar")).isEqualTo("bar2");
    variables = template.vars();
    System.out.println("DEL: vars: " + variables);
  }

  @Test
  void complexResourceBasicInvalidIds() {
    ValidationException exception =
        Assertions.assertThrows(
            ValidationException.class, () -> PathTemplate.create("projects/*/zones/~{zone_a}"));
    Assertions.assertEquals(
        String.format("parse error: invalid begin or end character in '%s'", "~{zone_a}"),
        exception.getMessage());
    exception =
        Assertions.assertThrows(
            ValidationException.class, () -> PathTemplate.create("projects/*/zones/{zone_a}~"));
    Assertions.assertEquals(
        String.format("parse error: invalid begin or end character in '%s'", "{zone_a}~"),
        exception.getMessage());
    exception =
        Assertions.assertThrows(
            ValidationException.class, () -> PathTemplate.create("projects/*/zones/.{zone_a}"));
    Assertions.assertEquals(
        String.format("parse error: invalid begin or end character in '%s'", ".{zone_a}"),
        exception.getMessage());
    exception =
        Assertions.assertThrows(
            ValidationException.class, () -> PathTemplate.create("projects/*/zones/{zone_a}."));
    Assertions.assertEquals(
        String.format("parse error: invalid begin or end character in '%s'", "{zone_a}."),
        exception.getMessage());
    exception =
        Assertions.assertThrows(
            ValidationException.class, () -> PathTemplate.create("projects/*/zones/-{zone_a}"));
    Assertions.assertEquals(
        String.format("parse error: invalid begin or end character in '%s'", "-{zone_a}"),
        exception.getMessage());
    exception =
        Assertions.assertThrows(
            ValidationException.class, () -> PathTemplate.create("projects/*/zones/{zone_a}-"));
    Assertions.assertEquals(
        String.format("parse error: invalid begin or end character in '%s'", "{zone_a}-"),
        exception.getMessage());
    exception =
        Assertions.assertThrows(
            ValidationException.class, () -> PathTemplate.create("projects/*/zones/_{zone_a}"));
    Assertions.assertEquals(
        String.format("parse error: invalid begin or end character in '%s'", "_{zone_a}"),
        exception.getMessage());
    exception =
        Assertions.assertThrows(
            ValidationException.class, () -> PathTemplate.create("projects/*/zones/{zone_a}_"));
    Assertions.assertEquals(
        String.format("parse error: invalid begin or end character in '%s'", "{zone_a}_"),
        exception.getMessage());
  }

  @Test
  void complexResourceMultipleDelimiters() {
    ValidationException exception =
        Assertions.assertThrows(
            ValidationException.class,
            () -> PathTemplate.create("projects/*/zones/{zone_a}~.{zone_b}"));
    Assertions.assertEquals(
        String.format(
            "parse error: missing or 2+ consecutive delimiter characters in '%s'",
            "{zone_a}~.{zone_b}"),
        exception.getMessage());
    exception =
        Assertions.assertThrows(
            ValidationException.class,
            () -> PathTemplate.create("projects/*/zones/{zone_a}~{zone_b}..{zone_c}"));
    Assertions.assertEquals(
        String.format(
            "parse error: missing or 2+ consecutive delimiter characters in '%s'",
            "{zone_a}~{zone_b}..{zone_c}"),
        exception.getMessage());
    String pathString = "projects/project_123/zones/lorum~ipsum";
    PathTemplate template = PathTemplate.create("projects/*/zones/{zone_.~-a}~{zone_b}");
    template.validate(pathString, "");
    // No assertion - success is no exception thrown from template.validate().
    Map<String, String> match = template.match(pathString);
    Truth.assertThat(match).isNotNull();
    Truth.assertThat(match.get("zone_.~-a")).isEqualTo("lorum");
    Truth.assertThat(match.get("zone_b")).isEqualTo("ipsum");
  }

  // Validate
  // ========

  @Test
  void validateSuccess() {
    String templateString = "buckets/*/objects/*";
    String pathString = "buckets/bucket/objects/object";
    PathTemplate template = PathTemplate.create(templateString);
    template.validate(pathString, "");
    // No assertion - success is no exception thrown from template.validate
  }

  @Test
  void validateFailure() {
    String templateString = "buckets/*/objects/*";
    String pathString = "buckets/bucket/invalid/object";
    PathTemplate template = PathTemplate.create(templateString);
    ValidationException exception =
        Assertions.assertThrows(ValidationException.class, () -> template.validate(pathString, ""));
    Assertions.assertEquals(
        String.format(": Parameter \"%s\" must be in the form \"%s\"", pathString, templateString),
        exception.getMessage());
  }

  @Test
  void validateMatchSuccess() {
    String templateString = "buckets/*/objects/{object_id}";
    String pathString = "buckets/bucket/objects/object";
    PathTemplate template = PathTemplate.create(templateString);
    Map<String, String> matchMap = template.validatedMatch(pathString, "");
    Truth.assertThat(matchMap.get("$0")).isEqualTo("bucket");
    Truth.assertThat(matchMap.get("object_id")).isEqualTo("object");
  }

  @Test
  void validateMatchFailure() {
    String templateString = "buckets/*/objects/*";
    String pathString = "buckets/bucket/invalid/object";
    PathTemplate template = PathTemplate.create(templateString);
    ValidationException exception =
        Assertions.assertThrows(
            ValidationException.class, () -> template.validatedMatch(pathString, ""));
    Assertions.assertEquals(
        String.format(": Parameter \"%s\" must be in the form \"%s\"", pathString, templateString),
        exception.getMessage());
  }

  // Instantiate
  // ===========

  @Test
  void instantiateAtomicResource() {
    PathTemplate template = PathTemplate.create("buckets/*/*/*/objects/*");
    String url = template.instantiate("$0", "f", "$1", "o", "$2", "o", "$3", "bar");
    Truth.assertThat(url).isEqualTo("buckets/f/o/o/objects/bar");
  }

  @Test
  void instantiateEscapeUnsafeChar() {
    PathTemplate template = PathTemplate.create("buckets/*/objects/*");
    Truth.assertThat(template.instantiate("$0", "f/o/o", "$1", "b/a/r"))
        .isEqualTo("buckets/f%2Fo%2Fo/objects/b%2Fa%2Fr");
  }

  @Test
  void instantiateNotEscapeForUnboundedWildcard() {
    PathTemplate template = PathTemplate.create("buckets/*/objects/**");
    Truth.assertThat(template.instantiate("$0", "f/o/o", "$1", "b/a/r"))
        .isEqualTo("buckets/f%2Fo%2Fo/objects/b/a/r");
  }

  @Test
  void instantiateFailWhenTooFewVariables() {
    PathTemplate template = PathTemplate.create("buckets/*/*/*/objects/*");
    ValidationException exception =
        Assertions.assertThrows(
            ValidationException.class, () -> template.instantiate("$0", "f", "1", "o"));
  }

  @Test
  void instantiateWithUnboundInMiddle() {
    PathTemplate template = PathTemplate.create("bar/**/foo/*");
    Truth.assertThat(template.instantiate("$0", "1/2", "$1", "3")).isEqualTo("bar/1/2/foo/3");
  }

  @Test
  void instantiatePartial() {
    PathTemplate template = PathTemplate.create("bar/*/foo/*");
    String instance = template.instantiatePartial(ImmutableMap.of("$0", "_1"));
    Truth.assertThat(instance).isEqualTo("bar/_1/foo/*");
  }

  @Test
  void instantiateWithHostName() {
    PathTemplate template = PathTemplate.create("bar/*");
    String instance =
        template.instantiate(
            ImmutableMap.of(PathTemplate.HOSTNAME_VAR, "//somewhere.io", "$0", "foo"));
    Truth.assertThat(instance).isEqualTo("//somewhere.io/bar/foo");
  }

  @Test
  void instantiateEscapeUnsafeCharNoEncoding() {
    PathTemplate template = PathTemplate.createWithoutUrlEncoding("buckets/*/objects/*");
    ValidationException exception =
        Assertions.assertThrows(
            ValidationException.class, () -> template.instantiate("$0", "f/o/o", "$1", "b/a/r"));
    Assertions.assertEquals(
        String.format("Invalid character \"/\" in path section \"f/o/o\"."),
        exception.getMessage());
  }

  @Test
  void instantiateNotEscapeForUnboundedWildcardNoEncoding() {
    PathTemplate template = PathTemplate.createWithoutUrlEncoding("buckets/*/objects/**");
    Truth.assertThat(template.instantiate("$0", "foo", "$1", "b/a/r"))
        .isEqualTo("buckets/foo/objects/b/a/r");
  }

  @Test
  void instantiateWithGoogProject() {
    PathTemplate template = PathTemplate.create("projects/{project}");
    String instance = template.instantiate(ImmutableMap.of("project", "google.com:test-proj"));
    Truth.assertThat(instance).isEqualTo("projects/google.com%3Atest-proj");
  }

  @Test
  void instantiateWithGoogProjectNoEncoding() {
    PathTemplate template = PathTemplate.createWithoutUrlEncoding("projects/{project}");
    String instance = template.instantiate(ImmutableMap.of("project", "google.com:test-proj"));
    Truth.assertThat(instance).isEqualTo("projects/google.com:test-proj");
  }

  @Test
  void instantiateWithUnusualCharactersNoEncoding() {
    PathTemplate template = PathTemplate.createWithoutUrlEncoding("bar/*");
    String instance = template.instantiate(ImmutableMap.of("$0", "asdf:;`~,.<>[]!@#$%^&*()"));
    Truth.assertThat(instance).isEqualTo("bar/asdf:;`~,.<>[]!@#$%^&*()");
  }

  @Test
  void instantiateWithComplexResourceId_basic() {
    PathTemplate template = PathTemplate.create("projects/{project}/zones/{zone_a}~{zone_b}");
    String instance =
        template.instantiate("project", "a/b/c", "zone_a", "apple", "zone_b", "baseball");
    Truth.assertThat(instance).isEqualTo("projects/a%2Fb%2Fc/zones/apple~baseball");
  }

  @Test
  void instantiateWithComplexResourceId_customVerb() {
    PathTemplate template = PathTemplate.create("projects/{project}/zones/{zone_a}~{zone_b}:hello");
    String instance =
        template.instantiate("project", "a/b/c", "zone_a", "apple", "zone_b", "baseball");
    Truth.assertThat(instance).isEqualTo("projects/a%2Fb%2Fc/zones/apple~baseball:hello");

    template = PathTemplate.create("projects/{project}/zones/{zone_a}~{zone_b}/stuff:hello");
    instance = template.instantiate("project", "a/b/c", "zone_a", "apple", "zone_b", "baseball");
    Truth.assertThat(instance).isEqualTo("projects/a%2Fb%2Fc/zones/apple~baseball/stuff:hello");
  }

  @Test
  void instantiateWithComplexResourceId_mixedSeparators() {
    PathTemplate template =
        PathTemplate.create(
            "projects/{project}/zones/{zone_a}~{zone_b}.{zone_c}-{zone_d}~{zone_e}");
    String instance =
        template.instantiate(
            "project",
            "a/b/c",
            "zone_a",
            "apple",
            "zone_b",
            "baseball/basketball",
            "zone_c",
            "cat/kitty",
            "zone_d",
            "dog/hound",
            "zone_e",
            "12345");
    Truth.assertThat(instance)
        .isEqualTo(
            "projects/a%2Fb%2Fc/zones/apple~baseball%2Fbasketball.cat%2Fkitty-dog%2Fhound~12345");
  }

  @Test
  void instantiateWithComplexResourceId_mixedSeparatorsInParent() {
    PathTemplate template =
        PathTemplate.create("projects/{project_a}~{project_b}.{project_c}/zones/{zone_a}~{zone_b}");
    String instance =
        template.instantiate(
            "project_a",
            "a/b/c",
            "project_b",
            "foo",
            "project_c",
            "bar",
            "zone_a",
            "apple",
            "zone_b",
            "baseball");
    Truth.assertThat(instance).isEqualTo("projects/a%2Fb%2Fc~foo.bar/zones/apple~baseball");
  }

  @Test
  void instantiateWithCustomVerbs() {
    PathTemplate template = PathTemplate.create("/v1/{name=operations/**}:cancel");
    String templateInstance = template.instantiate("name", "operations/3373707");
    Truth.assertThat(templateInstance).isEqualTo("v1/operations/3373707:cancel");
    Truth.assertThat(template.matches(templateInstance)).isTrue();
  }

  @Test
  void instantiateWithASegmentStartsWithADelimiter() {
    PathTemplate pathTemplate =
        PathTemplate.create(
            "v1beta1/{parent=projects/*/locations/*/clusters/*}/.well-known/openid-configuration");
    String pattern =
        "v1beta1/projects/abc/locations/def/clusters/yte/.well-known/openid-configuration";
    Truth.assertThat(pathTemplate.matches(pattern)).isTrue();
  }

  @Test
  void instantiateWithASegmentContainingComplexResourceNamesAndStartsWithADelimiter() {
    ValidationException exception =
        Assertions.assertThrows(
            ValidationException.class,
            () ->
                PathTemplate.create(
                    "v1beta1/{parent=projects/*/locations/*/clusters/*}/.{well}-{known}/openid-configuration"));
    Assertions.assertEquals(
        String.format("parse error: invalid begin or end character in '%s'", ".{well}-{known}"),
        exception.getMessage());
  }

  @Test
  void instantiateWithASegmentContainingNoComplexResourceNamesAndStartsWithMultipleDelimiters() {
    PathTemplate pathTemplate =
        PathTemplate.create(
            "v1beta1/{parent=projects/*/locations/*/clusters/*}/.-~well-known/openid-configuration");
    String pattern =
        "v1beta1/projects/abc/locations/def/clusters/yte/.-~well-known/openid-configuration";
    Truth.assertThat(pathTemplate.matches(pattern)).isTrue();
  }

  @Test
  void instantiateWithASegmentOnlyContainingOneDelimiter() {
    ValidationException exception =
        Assertions.assertThrows(
            ValidationException.class,
            () -> PathTemplate.create("v1/publishers/{publisher}/books/."));
    Assertions.assertEquals(
        String.format("parse error: invalid begin or end character in '%s'", "."),
        exception.getMessage());
  }

  @Test
  void instantiateWithASegmentOnlyContainingOneCharacter() {
    PathTemplate pathTemplate = PathTemplate.create("v1/publishers/{publisher}/books/a");
    String pattern = "v1/publishers/o'reilly/books/a";
    Truth.assertThat(pathTemplate.matches(pattern)).isTrue();
  }

  @Test
  void instantiateWithASegmentEndsWithADelimiter() {
    PathTemplate pathTemplate =
        PathTemplate.create(
            "v1beta1/{parent=projects/*/locations/*/clusters/*}/well-known./openid-configuration");
    String pattern =
        "v1beta1/projects/abc/locations/def/clusters/yte/well-known./openid-configuration";
    Truth.assertThat(pathTemplate.matches(pattern)).isTrue();
  }

  @Test
  void instantiateWithASegmentContainingComplexResourceNamesAndEndsWithADelimiter() {
    ValidationException exception =
        Assertions.assertThrows(
            ValidationException.class,
            () ->
                PathTemplate.create(
                    "v1beta1/{parent=projects/*/locations/*/clusters/*}/{well}-{known}./openid-configuration"));
    Assertions.assertEquals(
        String.format("parse error: invalid begin or end character in '%s'", "{well}-{known}."),
        exception.getMessage());
  }

  @Test
  void instantiateWithASegmentContainingNoComplexResourceNamesAndEndsWithMultipleDelimiters() {
    PathTemplate pathTemplate =
        PathTemplate.create(
            "v1beta1/{parent=projects/*/locations/*/clusters/*}/well-known.-~/openid-configuration");
    String pattern =
        "v1beta1/projects/abc/locations/def/clusters/yte/well-known.-~/openid-configuration";
    Truth.assertThat(pathTemplate.matches(pattern)).isTrue();
  }

  // Other
  // =====

  @Test
  void testMultiplePathWildcardFailure() {
    Assertions.assertThrows(
        IllegalArgumentException.class, () -> PathTemplate.create("bar/**/{name=foo/**}:verb"));
  }

  @Test
  void testTemplateWithSimpleBinding() {
    PathTemplate template = PathTemplate.create("/v1/messages/{message_id}");
    String url = template.instantiate("message_id", "mymessage");
    Truth.assertThat(url).isEqualTo("v1/messages/mymessage");
  }

  @Test
  void testTemplateWithMultipleSimpleBindings() {
    PathTemplate template = PathTemplate.create("v1/shelves/{shelf}/books/{book}");
    String url = template.instantiate("shelf", "s1", "book", "b1");
    Truth.assertThat(url).isEqualTo("v1/shelves/s1/books/b1");
  }

  private static void assertPositionalMatch(Map<String, String> match, String... expected) {
    Truth.assertThat(match).isNotNull();
    int i = 0;
    for (; i < expected.length; ++i) {
      Truth.assertThat(expected[i]).isEqualTo(match.get("$" + i));
    }
    Truth.assertThat(i).isEqualTo(match.size());
  }
}
