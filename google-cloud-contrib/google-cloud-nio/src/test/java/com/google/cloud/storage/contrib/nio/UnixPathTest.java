/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.storage.contrib.nio;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assume.assumeTrue;

import com.google.common.testing.EqualsTester;
import com.google.common.testing.NullPointerTester;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Unit tests for {@link UnixPath}.
 */
@RunWith(JUnit4.class)
public class UnixPathTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Test
  public void testNormalize() {
    assertThat(p(".").normalize()).isEqualTo(p(""));
    assertThat(p("/").normalize()).isEqualTo(p("/"));
    assertThat(p("/.").normalize()).isEqualTo(p("/"));
    assertThat(p("/a/b/../c").normalize()).isEqualTo(p("/a/c"));
    assertThat(p("/a/b/./c").normalize()).isEqualTo(p("/a/b/c"));
    assertThat(p("a/b/../c").normalize()).isEqualTo(p("a/c"));
    assertThat(p("a/b/./c").normalize()).isEqualTo(p("a/b/c"));
    assertThat(p("/a/b/../../c").normalize()).isEqualTo(p("/c"));
    assertThat(p("/a/b/./.././.././c").normalize()).isEqualTo(p("/c"));
  }

  @Test
  public void testNormalize_empty_returnsEmpty() {
    assertThat(p("").normalize()).isEqualTo(p(""));
  }

  @Test
  public void testNormalize_underflow_isAllowed() {
    assertThat(p("../").normalize()).isEqualTo(p(""));
  }

  @Test
  public void testNormalize_extraSlashes_getRemoved() {
    assertThat(p("///").normalize()).isEqualTo(p("/"));
    assertThat(p("/hi//there").normalize()).isEqualTo(p("/hi/there"));
    assertThat(p("/hi////.///there").normalize()).isEqualTo(p("/hi/there"));
  }

  @Test
  public void testNormalize_trailingSlash() {
    assertThat(p("/hi/there/").normalize()).isEqualTo(p("/hi/there/"));
    assertThat(p("/hi/there/../").normalize()).isEqualTo(p("/hi/"));
    assertThat(p("/hi/there/..").normalize()).isEqualTo(p("/hi/"));
    assertThat(p("hi/../").normalize()).isEqualTo(p(""));
    assertThat(p("/hi/../").normalize()).isEqualTo(p("/"));
    assertThat(p("hi/..").normalize()).isEqualTo(p(""));
    assertThat(p("/hi/..").normalize()).isEqualTo(p("/"));
  }

  @Test
  public void testNormalize_sameObjectOptimization() {
    UnixPath path = p("/hi/there");
    assertThat(path.normalize()).isSameAs(path);
    path = p("/hi/there/");
    assertThat(path.normalize()).isSameAs(path);
  }

  @Test
  public void testResolve() {
    assertThat(p("/hello").resolve(p("cat"))).isEqualTo(p("/hello/cat"));
    assertThat(p("/hello/").resolve(p("cat"))).isEqualTo(p("/hello/cat"));
    assertThat(p("hello/").resolve(p("cat"))).isEqualTo(p("hello/cat"));
    assertThat(p("hello/").resolve(p("cat/"))).isEqualTo(p("hello/cat/"));
    assertThat(p("hello/").resolve(p(""))).isEqualTo(p("hello/"));
    assertThat(p("hello/").resolve(p("/hi/there"))).isEqualTo(p("/hi/there"));
  }

  @Test
  public void testResolve_sameObjectOptimization() {
    UnixPath path = p("/hi/there");
    assertThat(path.resolve(p(""))).isSameAs(path);
    assertThat(p("hello").resolve(path)).isSameAs(path);
  }

  @Test
  public void testGetPath() {
    assertThat(UnixPath.getPath(false, "hello")).isEqualTo(p("hello"));
    assertThat(UnixPath.getPath(false, "hello", "cat")).isEqualTo(p("hello/cat"));
    assertThat(UnixPath.getPath(false, "/hello", "cat")).isEqualTo(p("/hello/cat"));
    assertThat(UnixPath.getPath(false, "/hello", "cat", "inc.")).isEqualTo(p("/hello/cat/inc."));
    assertThat(UnixPath.getPath(false, "hello/", "/hi/there")).isEqualTo(p("/hi/there"));
  }

  @Test
  public void testResolveSibling() {
    assertThat(p("/hello/cat").resolveSibling(p("dog"))).isEqualTo(p("/hello/dog"));
    assertThat(p("/").resolveSibling(p("dog"))).isEqualTo(p("dog"));
  }

  @Test
  public void testResolveSibling_preservesTrailingSlash() {
    assertThat(p("/hello/cat").resolveSibling(p("dog/"))).isEqualTo(p("/hello/dog/"));
    assertThat(p("/").resolveSibling(p("dog/"))).isEqualTo(p("dog/"));
  }

  @Test
  public void testRelativize() {
    assertThat(p("/foo/bar/hop/dog").relativize(p("/foo/mop/top")))
        .isEqualTo(p("../../../mop/top"));
    assertThat(p("/foo/bar/dog").relativize(p("/foo/mop/top"))).isEqualTo(p("../../mop/top"));
    assertThat(p("/foo/bar/hop/dog").relativize(p("/foo/mop/top/../../mog")))
        .isEqualTo(p("../../../mop/top/../../mog"));
    assertThat(p("/foo/bar/hop/dog").relativize(p("/foo/../mog"))).isEqualTo(p("../../../../mog"));
    assertThat(p("").relativize(p("foo/mop/top/"))).isEqualTo(p("foo/mop/top/"));
  }

  @Test
  public void testRelativize_absoluteMismatch_notAllowed() {
    thrown.expect(IllegalArgumentException.class);
    p("/a/b/").relativize(p(""));
  }

  @Test
  public void testRelativize_preservesTrailingSlash() {
    // This behavior actually diverges from sun.nio.fs.UnixPath:
    //   bsh % print(Paths.get("/a/b/").relativize(Paths.get("/etc/")));
    //   ../../etc
    assertThat(p("/foo/bar/hop/dog").relativize(p("/foo/../mog/")))
        .isEqualTo(p("../../../../mog/"));
    assertThat(p("/a/b/").relativize(p("/etc/"))).isEqualTo(p("../../etc/"));
  }

  @Test
  public void testStartsWith() {
    assertThat(p("/hi/there").startsWith(p("/hi/there"))).isTrue();
    assertThat(p("/hi/there").startsWith(p("/hi/therf"))).isFalse();
    assertThat(p("/hi/there").startsWith(p("/hi"))).isTrue();
    assertThat(p("/hi/there").startsWith(p("/hi/"))).isTrue();
    assertThat(p("/hi/there").startsWith(p("hi"))).isFalse();
    assertThat(p("/hi/there").startsWith(p("/"))).isTrue();
    assertThat(p("/hi/there").startsWith(p(""))).isFalse();
    assertThat(p("/a/b").startsWith(p("a/b/"))).isFalse();
    assertThat(p("/a/b/").startsWith(p("a/b/"))).isFalse();
    assertThat(p("/hi/there").startsWith(p(""))).isFalse();
    assertThat(p("").startsWith(p(""))).isTrue();
  }

  @Test
  public void testStartsWith_comparesComponentsIndividually() {
    assertThat(p("/hello").startsWith(p("/hell"))).isFalse();
    assertThat(p("/hello").startsWith(p("/hello"))).isTrue();
  }

  @Test
  public void testEndsWith() {
    assertThat(p("/hi/there").endsWith(p("there"))).isTrue();
    assertThat(p("/hi/there").endsWith(p("therf"))).isFalse();
    assertThat(p("/hi/there").endsWith(p("/blag/therf"))).isFalse();
    assertThat(p("/hi/there").endsWith(p("/hi/there"))).isTrue();
    assertThat(p("/hi/there").endsWith(p("/there"))).isFalse();
    assertThat(p("/human/that/you/cry").endsWith(p("that/you/cry"))).isTrue();
    assertThat(p("/human/that/you/cry").endsWith(p("that/you/cry/"))).isTrue();
    assertThat(p("/hi/there/").endsWith(p("/"))).isFalse();
    assertThat(p("/hi/there").endsWith(p(""))).isFalse();
    assertThat(p("").endsWith(p(""))).isTrue();
  }

  @Test
  public void testEndsWith_comparesComponentsIndividually() {
    assertThat(p("/hello").endsWith(p("lo"))).isFalse();
    assertThat(p("/hello").endsWith(p("hello"))).isTrue();
  }

  @Test
  public void testGetParent() {
    assertThat(p("").getParent()).isNull();
    assertThat(p("/").getParent()).isNull();
    assertThat(p("aaa/").getParent()).isNull();
    assertThat(p("aaa").getParent()).isNull();
    assertThat(p("/aaa/").getParent()).isEqualTo(p("/"));
    assertThat(p("a/b/c").getParent()).isEqualTo(p("a/b/"));
    assertThat(p("a/b/c/").getParent()).isEqualTo(p("a/b/"));
    assertThat(p("a/b/").getParent()).isEqualTo(p("a/"));
  }

  @Test
  public void testGetRoot() {
    assertThat(p("/hello").getRoot()).isEqualTo(p("/"));
    assertThat(p("hello").getRoot()).isNull();
  }

  @Test
  public void testGetFileName() {
    assertThat(p("").getFileName()).isEqualTo(p(""));
    assertThat(p("/").getFileName()).isNull();
    assertThat(p("/dark").getFileName()).isEqualTo(p("dark"));
    assertThat(p("/angels/").getFileName()).isEqualTo(p("angels"));
  }

  @Test
  public void testEquals() {
    assertThat(p("/a/").equals(p("/a/"))).isTrue();
    assertThat(p("/a/").equals(p("/b/"))).isFalse();
    assertThat(p("/b/").equals(p("/b"))).isFalse();
    assertThat(p("/b").equals(p("/b/"))).isFalse();
    assertThat(p("b").equals(p("/b"))).isFalse();
    assertThat(p("b").equals(p("b"))).isTrue();
  }

  @Test
  public void testSplit() {
    assertThat(p("").split().hasNext()).isFalse();
    assertThat(p("hi/there").split().hasNext()).isTrue();
    assertThat(p(p("hi/there").split().next())).isEqualTo(p("hi"));
  }

  @Test
  public void testToAbsolute() {
    assertThat(p("lol").toAbsolutePath(UnixPath.ROOT_PATH)).isEqualTo(p("/lol"));
    assertThat(p("lol/cat").toAbsolutePath(UnixPath.ROOT_PATH)).isEqualTo(p("/lol/cat"));
  }

  @Test
  public void testToAbsolute_withCurrentDirectory() {
    assertThat(p("cat").toAbsolutePath(p("/lol"))).isEqualTo(p("/lol/cat"));
    assertThat(p("cat").toAbsolutePath(p("/lol/"))).isEqualTo(p("/lol/cat"));
    assertThat(p("/hi/there").toAbsolutePath(p("/lol"))).isEqualTo(p("/hi/there"));
  }

  @Test
  public void testToAbsolute_preservesTrailingSlash() {
    assertThat(p("cat/").toAbsolutePath(p("/lol"))).isEqualTo(p("/lol/cat/"));
  }

  @Test
  public void testSubpath() {
    assertThat(p("/eins/zwei/drei/vier").subpath(0, 1)).isEqualTo(p("eins"));
    assertThat(p("/eins/zwei/drei/vier").subpath(0, 2)).isEqualTo(p("eins/zwei"));
    assertThat(p("eins/zwei/drei/vier/").subpath(1, 4)).isEqualTo(p("zwei/drei/vier"));
    assertThat(p("eins/zwei/drei/vier/").subpath(2, 4)).isEqualTo(p("drei/vier"));
  }

  @Test
  public void testSubpath_empty_returnsEmpty() {
    assertThat(p("").subpath(0, 1)).isEqualTo(p(""));
  }

  @Test
  public void testSubpath_root_throwsIae() {
    thrown.expect(IllegalArgumentException.class);
    p("/").subpath(0, 1);
  }

  @Test
  public void testSubpath_negativeIndex_throwsIae() {
    thrown.expect(IllegalArgumentException.class);
    p("/eins/zwei/drei/vier").subpath(-1, 1);
  }

  @Test
  public void testSubpath_notEnoughElements_throwsIae() {
    thrown.expect(IllegalArgumentException.class);
    p("/eins/zwei/drei/vier").subpath(0, 5);
  }

  @Test
  public void testSubpath_beginAboveEnd_throwsIae() {
    thrown.expect(IllegalArgumentException.class);
    p("/eins/zwei/drei/vier").subpath(1, 0);
  }

  @Test
  public void testSubpath_beginAndEndEqual_throwsIae() {
    thrown.expect(IllegalArgumentException.class);
    p("/eins/zwei/drei/vier").subpath(0, 0);
  }

  @Test
  public void testNameCount() {
    assertThat(p("").getNameCount()).isEqualTo(1);
    assertThat(p("/").getNameCount()).isEqualTo(0);
    assertThat(p("/hi/").getNameCount()).isEqualTo(1);
    assertThat(p("/hi/yo").getNameCount()).isEqualTo(2);
    assertThat(p("hi/yo").getNameCount()).isEqualTo(2);
  }

  @Test
  public void testNameCount_dontPermitEmptyComponents_emptiesGetIgnored() {
    assertThat(p("hi//yo").getNameCount()).isEqualTo(2);
    assertThat(p("//hi//yo//").getNameCount()).isEqualTo(2);
  }

  @Test
  public void testNameCount_permitEmptyComponents_emptiesGetCounted() {
    assertThat(pp("hi//yo").getNameCount()).isEqualTo(3);
    assertThat(pp("hi//yo/").getNameCount()).isEqualTo(4);
    assertThat(pp("hi//yo//").getNameCount()).isEqualTo(5);
  }

  @Test
  public void testNameCount_permitEmptyComponents_rootComponentDoesntCount() {
    assertThat(pp("hi/yo").getNameCount()).isEqualTo(2);
    assertThat(pp("/hi/yo").getNameCount()).isEqualTo(2);
    assertThat(pp("//hi/yo").getNameCount()).isEqualTo(3);
  }

  @Test
  public void testGetName() {
    assertThat(p("").getName(0)).isEqualTo(p(""));
    assertThat(p("/hi").getName(0)).isEqualTo(p("hi"));
    assertThat(p("hi/there").getName(1)).isEqualTo(p("there"));
  }

  @Test
  public void testCompareTo() {
    assertThat(p("/hi/there").compareTo(p("/hi/there"))).isEqualTo(0);
    assertThat(p("/hi/there").compareTo(p("/hi/therf"))).isEqualTo(-1);
    assertThat(p("/hi/there").compareTo(p("/hi/therd"))).isEqualTo(1);
  }

  @Test
  public void testCompareTo_dontPermitEmptyComponents_emptiesGetIgnored() {
    assertThat(p("a/b").compareTo(p("a//b"))).isEqualTo(0);
  }

  @Test
  public void testCompareTo_permitEmptyComponents_behaviorChanges() {
    assertThat(p("a/b").compareTo(pp("a//b"))).isEqualTo(1);
    assertThat(pp("a/b").compareTo(pp("a//b"))).isEqualTo(1);
  }

  @Test
  public void testCompareTo_comparesComponentsIndividually() {
    assumeTrue('.' < '/');
    assertThat("hi./there".compareTo("hi/there")).isEqualTo(-1);
    assertThat("hi.".compareTo("hi")).isEqualTo(1);
    assertThat(p("hi./there").compareTo(p("hi/there"))).isEqualTo(1);
    assertThat(p("hi./there").compareTo(p("hi/there"))).isEqualTo(1);
    assumeTrue('0' > '/');
    assertThat("hi0/there".compareTo("hi/there")).isEqualTo(1);
    assertThat("hi0".compareTo("hi")).isEqualTo(1);
    assertThat(p("hi0/there").compareTo(p("hi/there"))).isEqualTo(1);
  }

  @Test
  public void testSeemsLikeADirectory() {
    assertThat(p("a").seemsLikeADirectory()).isFalse();
    assertThat(p("a.").seemsLikeADirectory()).isFalse();
    assertThat(p("a..").seemsLikeADirectory()).isFalse();
    assertThat(p("").seemsLikeADirectory()).isTrue();
    assertThat(p("/").seemsLikeADirectory()).isTrue();
    assertThat(p(".").seemsLikeADirectory()).isTrue();
    assertThat(p("/.").seemsLikeADirectory()).isTrue();
    assertThat(p("..").seemsLikeADirectory()).isTrue();
    assertThat(p("/..").seemsLikeADirectory()).isTrue();
  }

  @Test
  public void testEquals_equalsTester() {
    new EqualsTester()
        .addEqualityGroup(p("/lol"), p("/lol"))
        .addEqualityGroup(p("/lol//"), p("/lol//"))
        .addEqualityGroup(p("dust"))
        .testEquals();
  }

  @Test
  public void testNullness() throws Exception {
    NullPointerTester tester = new NullPointerTester();
    tester.ignore(UnixPath.class.getMethod("equals", Object.class));
    tester.testAllPublicStaticMethods(UnixPath.class);
    tester.testAllPublicInstanceMethods(p("solo"));
  }

  private static UnixPath p(String path) {
    return UnixPath.getPath(false, path);
  }

  private static UnixPath pp(String path) {
    return UnixPath.getPath(true, path);
  }
}
