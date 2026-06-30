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

package com.google.api.generator.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.api.generator.test.utils.LineFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.junit.jupiter.api.Test;

class TrieTest {
  @Test
  void insertAndSearch_stringTrie() {
    Trie<String> trie = new Trie<>();

    Function<String, List<String>> wordToCharListFn = w -> Arrays.asList(w.split("(?!^)"));
    List<String> wordCat = wordToCharListFn.apply("cat");
    assertFalse(trie.search(wordCat));

    trie.insert(wordCat);
    assertTrue(trie.search(wordCat));
    assertFalse(trie.search(wordToCharListFn.apply("car")));
    assertTrue(trie.hasPrefix(wordToCharListFn.apply("ca")));

    trie.insert(wordToCharListFn.apply("car"));
    trie.insert(wordToCharListFn.apply("dog"));
    assertTrue(trie.search(wordToCharListFn.apply("car")));
    assertTrue(trie.search(wordToCharListFn.apply("dog")));
  }

  @Test
  void insertAndSearch_multiStringTrie() {
    Trie<String> trie = new Trie<>();
    assertFalse(trie.search(Arrays.asList("user", "identity", "name")));

    trie.insert(Arrays.asList("user", "identity", "name"));
    trie.insert(Arrays.asList("user", "identity", "age"));
    trie.insert(Arrays.asList("user", "contact", "email"));

    assertTrue(trie.search(Arrays.asList("user", "identity", "name")));
    assertTrue(trie.search(Arrays.asList("user", "identity", "age")));
    assertFalse(trie.search(Arrays.asList("user", "identity", "eyeColor")));
    assertTrue(trie.search(Arrays.asList("user", "contact", "email")));
    assertTrue(trie.hasPrefix(Arrays.asList("user", "identity")));
    assertTrue(trie.hasPrefix(Arrays.asList("user", "contact")));
    assertTrue(trie.hasPrefix(Arrays.asList("user")));

    assertFalse(trie.hasPrefix(Arrays.asList("identity")));
    assertFalse(trie.hasPrefix(Arrays.asList("contact")));
  }

  @Test
  void dfsTraverseAndReduce_emptyTrie() {
    // Add up points in the tree, where each parent gets (num child node points) * 2 + 1.
    Function<String, Integer> parentPreprocFn = nodeVal -> new Integer(0);
    BiFunction<String, Integer, Integer> leafReduceFn =
        (nodeVal, accVal) -> new Integer(accVal + 1);
    TriFunction<String, Integer, Integer, Integer> parentPostprocFn =
        (nodeVal, baseVal, accVal) -> new Integer(nodeVal == null ? 0 : accVal * 2 + 1);

    Trie<String> trie = new Trie<>();
    int finalValue = trie.dfsTraverseAndReduce(parentPreprocFn, parentPostprocFn, leafReduceFn, 0);
    assertEquals(0, finalValue);
  }

  @Test
  void dfsTraverseAndReduce_singleNodeTrie() {
    // Add up points in the tree, where each parent gets (num child node points) * 2 + 1.
    Function<String, Integer> parentPreprocFn = nodeVal -> new Integer(0);
    BiFunction<String, Integer, Integer> leafReduceFn =
        (nodeVal, accVal) -> new Integer(accVal + 1);
    TriFunction<String, Integer, Integer, Integer> parentPostprocFn =
        (nodeVal, baseVal, accVal) -> new Integer(nodeVal == null ? accVal : accVal * 2 + 1);

    Trie<String> trie = new Trie<>();
    trie.insert(Arrays.asList("user"));
    int finalValue = trie.dfsTraverseAndReduce(parentPreprocFn, parentPostprocFn, leafReduceFn, 0);
    assertEquals(1, finalValue);
  }

  @Test
  void dfsTraverseAndReduce_oneParentOneChildBranchTrie() {
    Function<String, String> toUpperCaseFn = s -> s.substring(0, 1).toUpperCase() + s.substring(1);
    Function<String, StringBuilder> parentPreprocFn =
        nodeVal ->
            new StringBuilder(String.format("%s.newBuilder()", toUpperCaseFn.apply(nodeVal)));
    BiFunction<String, StringBuilder, StringBuilder> leafReduceFn =
        (nodeVal, parentAccVal) -> {
          parentAccVal.append(
              String.format(
                  ".set%s(\"%s\")", toUpperCaseFn.apply(nodeVal.toString()), nodeVal.toString()));
          return parentAccVal;
        };
    TriFunction<String, StringBuilder, StringBuilder, StringBuilder> parentPostprocFn =
        (nodeVal, baseVal, accVal) -> {
          boolean isRootNode = nodeVal == null;
          if (!isRootNode) {
            baseVal.append(
                String.format(
                    ".set%s(%s.build())",
                    toUpperCaseFn.apply(nodeVal.toString()), accVal.toString()));
          }
          return isRootNode ? accVal : baseVal;
        };
    StringBuilder baseVal = new StringBuilder("RequestType.newBuilder()");

    Trie<String> trie = new Trie<>();
    trie.insert(Arrays.asList("user", "identity"));
    String finalValue =
        trie.dfsTraverseAndReduce(parentPreprocFn, parentPostprocFn, leafReduceFn, baseVal)
            .toString();

    assertEquals(
        LineFormatter.lines(
            "RequestType.newBuilder()",
            ".setUser(User.newBuilder()",
            ".setIdentity(\"identity\").build())",
            ".build();"),
        finalValue + ".build();");
  }

  @Test
  void dfsTraverseAndReduce_oneDeepBranchTrie() {
    // Add up points in the tree, where each parent gets (num child node points) * 2 + 1.
    int simpleBaseValue = 0;
    Function<String, Integer> simpleParentPreprocFn = nodeVal -> new Integer(0);
    BiFunction<String, Integer, Integer> simpleLeafReduceFn =
        (nodeVal, accVal) -> new Integer(accVal + 1);
    TriFunction<String, Integer, Integer, Integer> simpleParentPostprocFn =
        (nodeVal, baseVal, accVal) -> new Integer(nodeVal == null ? accVal : accVal * 2 + 1);

    Trie<String> trie = new Trie<>();
    trie.insert(Arrays.asList("user", "identity", "name", "firstName"));
    int simpleFinalValue =
        trie.dfsTraverseAndReduce(
            simpleParentPreprocFn, simpleParentPostprocFn, simpleLeafReduceFn, simpleBaseValue);
    assertEquals(15, simpleFinalValue);

    Function<String, String> toUpperCaseFn = s -> s.substring(0, 1).toUpperCase() + s.substring(1);
    Function<String, StringBuilder> parentPreprocFn =
        nodeVal ->
            new StringBuilder(String.format("%s.newBuilder()", toUpperCaseFn.apply(nodeVal)));
    BiFunction<String, StringBuilder, StringBuilder> leafReduceFn =
        (nodeVal, parentAccVal) -> {
          parentAccVal.append(
              String.format(
                  ".set%s(\"%s\")", toUpperCaseFn.apply(nodeVal.toString()), nodeVal.toString()));
          return parentAccVal;
        };
    TriFunction<String, StringBuilder, StringBuilder, StringBuilder> parentPostprocFn =
        (nodeVal, baseVal, accVal) -> {
          boolean isRootNode = nodeVal == null;
          if (!isRootNode) {
            baseVal.append(
                String.format(
                    ".set%s(%s.build())",
                    toUpperCaseFn.apply(nodeVal.toString()), accVal.toString()));
          }
          return isRootNode ? accVal : baseVal;
        };
    StringBuilder baseVal = new StringBuilder("RequestType.newBuilder()");

    String finalValue =
        trie.dfsTraverseAndReduce(parentPreprocFn, parentPostprocFn, leafReduceFn, baseVal)
            .toString();

    assertEquals(
        LineFormatter.lines(
            "RequestType.newBuilder()",
            ".setUser(User.newBuilder()",
            ".setIdentity(Identity.newBuilder()",
            ".setName(Name.newBuilder()",
            ".setFirstName(\"firstName\").build())",
            ".build())",
            ".build())",
            ".build();"),
        finalValue + ".build();");
  }

  @Test
  void dfsTraverseAndReduce_depthAndBreathTrie() {
    Function<String, String> toUpperCaseFn = s -> s.substring(0, 1).toUpperCase() + s.substring(1);
    Function<String, StringBuilder> parentPreprocFn =
        nodeVal ->
            new StringBuilder(String.format("%s.newBuilder()", toUpperCaseFn.apply(nodeVal)));
    BiFunction<String, StringBuilder, StringBuilder> leafReduceFn =
        (nodeVal, parentAccVal) -> {
          parentAccVal.append(
              String.format(
                  ".set%s(\"%s\")", toUpperCaseFn.apply(nodeVal.toString()), nodeVal.toString()));
          return parentAccVal;
        };
    TriFunction<String, StringBuilder, StringBuilder, StringBuilder> parentPostprocFn =
        (nodeVal, baseVal, accVal) -> {
          boolean isRootNode = nodeVal == null;
          if (!isRootNode) {
            baseVal.append(
                String.format(
                    ".set%s(%s.build())",
                    toUpperCaseFn.apply(nodeVal.toString()), accVal.toString()));
          }
          return isRootNode ? accVal : baseVal;
        };
    StringBuilder baseVal = new StringBuilder("RequestType.newBuilder()");

    Trie<String> trie = new Trie<>();
    trie.insert(Arrays.asList("user", "identity", "name", "firstName"));
    trie.insert(Arrays.asList("user", "identity", "name", "lastName"));
    trie.insert(Arrays.asList("user", "email"));
    trie.insert(Arrays.asList("user", "age"));
    trie.insert(Arrays.asList("user", "hobby", "hobbyName"));
    trie.insert(Arrays.asList("user", "hobby", "frequency"));

    String finalValue =
        trie.dfsTraverseAndReduce(parentPreprocFn, parentPostprocFn, leafReduceFn, baseVal)
            .toString();

    assertEquals(
        LineFormatter.lines(
            "RequestType.newBuilder()",
            ".setUser(User.newBuilder()",
            ".setIdentity(Identity.newBuilder()",
            ".setName(Name.newBuilder()",
            ".setFirstName(\"firstName\")",
            ".setLastName(\"lastName\").build())", // Name.newBuilder().build().
            ".build())", // Identity.newBuilder().build().
            ".setEmail(\"email\")",
            ".setAge(\"age\")",
            ".setHobby(Hobby.newBuilder()",
            ".setHobbyName(\"hobbyName\")",
            ".setFrequency(\"frequency\").build())", // Hobby.newBuilder().build().
            ".build())", // User.newBuilder().build().
            ".build();"),
        finalValue + ".build();");
  }
}
