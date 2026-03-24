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

package com.google.api.generator.gapic.protoparser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.gapic.model.Field;
import com.google.api.generator.gapic.model.MethodArgument;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class MethodSignatureParserTest {

  @Test
  void flattenMethodSignatures_basic() {
    String fooName = "fooName";
    TypeNode fooTypeOne =
        TypeNode.withReference(
            VaporReference.builder().setName("FooName").setPakkage("com.google.foobar").build());
    TypeNode fooTypeTwo =
        TypeNode.withReference(
            VaporReference.builder().setName("FooTwoName").setPakkage("com.google.foobar").build());

    List<String> argumentNames = Arrays.asList(fooName);

    BiFunction<String, TypeNode, MethodArgument> methodArgFn =
        (name, type) ->
            MethodArgument.builder()
                .setName(name)
                .setType(type)
                .setField(Field.builder().setName(name).setType(type).build())
                .build();
    List<MethodArgument> fooArgs =
        Arrays.asList(TypeNode.STRING, fooTypeOne, fooTypeTwo).stream()
            .map(t -> methodArgFn.apply(fooName, t))
            .collect(Collectors.toList());
    Map<String, List<MethodArgument>> argumentNameToOverloads = new HashMap<>();
    argumentNameToOverloads.put(fooName, fooArgs);

    List<List<MethodArgument>> flattenedSignatures =
        MethodSignatureParser.flattenMethodSignatureVariants(
            argumentNames, argumentNameToOverloads);

    assertEquals(3, flattenedSignatures.size());

    assertTrue(containsTypes(flattenedSignatures, Arrays.asList(TypeNode.STRING)));
    assertTrue(containsTypes(flattenedSignatures, Arrays.asList(fooTypeOne)));
    assertTrue(containsTypes(flattenedSignatures, Arrays.asList(fooTypeTwo)));
  }

  @Test
  void flattenMethodSignatures_oneToMany() {
    String fooName = "fooName";
    String anInt = "anInt";

    TypeNode fooTypeOne =
        TypeNode.withReference(
            VaporReference.builder().setName("FooName").setPakkage("com.google.foobar").build());
    TypeNode fooTypeTwo =
        TypeNode.withReference(
            VaporReference.builder().setName("FooTwoName").setPakkage("com.google.foobar").build());

    List<String> argumentNames = Arrays.asList(anInt, fooName);

    BiFunction<String, TypeNode, MethodArgument> methodArgFn =
        (name, type) ->
            MethodArgument.builder()
                .setName(name)
                .setType(type)
                .setField(Field.builder().setName(name).setType(type).build())
                .build();
    List<MethodArgument> fooArgs =
        Arrays.asList(TypeNode.STRING, fooTypeOne, fooTypeTwo).stream()
            .map(t -> methodArgFn.apply(fooName, t))
            .collect(Collectors.toList());
    Map<String, List<MethodArgument>> argumentNameToOverloads = new HashMap<>();
    argumentNameToOverloads.put(fooName, fooArgs);
    argumentNameToOverloads.put(anInt, Arrays.asList(methodArgFn.apply(anInt, TypeNode.INT)));

    List<List<MethodArgument>> flattenedSignatures =
        MethodSignatureParser.flattenMethodSignatureVariants(
            argumentNames, argumentNameToOverloads);

    assertEquals(3, flattenedSignatures.size());

    assertTrue(containsTypes(flattenedSignatures, Arrays.asList(TypeNode.INT, TypeNode.STRING)));
    assertTrue(containsTypes(flattenedSignatures, Arrays.asList(TypeNode.INT, fooTypeOne)));
    assertTrue(containsTypes(flattenedSignatures, Arrays.asList(TypeNode.INT, fooTypeTwo)));
  }

  @Test
  void flattenMethodSignatures_manyToOne() {
    String fooName = "fooName";
    String anInt = "anInt";

    TypeNode fooTypeOne =
        TypeNode.withReference(
            VaporReference.builder().setName("FooName").setPakkage("com.google.foobar").build());
    TypeNode fooTypeTwo =
        TypeNode.withReference(
            VaporReference.builder().setName("FooTwoName").setPakkage("com.google.foobar").build());

    List<String> argumentNames = Arrays.asList(fooName, anInt);

    BiFunction<String, TypeNode, MethodArgument> methodArgFn =
        (name, type) ->
            MethodArgument.builder()
                .setName(name)
                .setType(type)
                .setField(Field.builder().setName(name).setType(type).build())
                .build();
    List<MethodArgument> fooArgs =
        Arrays.asList(TypeNode.STRING, fooTypeOne, fooTypeTwo).stream()
            .map(t -> methodArgFn.apply(fooName, t))
            .collect(Collectors.toList());
    Map<String, List<MethodArgument>> argumentNameToOverloads = new HashMap<>();
    argumentNameToOverloads.put(fooName, fooArgs);
    argumentNameToOverloads.put(anInt, Arrays.asList(methodArgFn.apply(anInt, TypeNode.INT)));

    List<List<MethodArgument>> flattenedSignatures =
        MethodSignatureParser.flattenMethodSignatureVariants(
            argumentNames, argumentNameToOverloads);

    assertEquals(3, flattenedSignatures.size());
    assertTrue(containsTypes(flattenedSignatures, Arrays.asList(TypeNode.STRING, TypeNode.INT)));
    assertTrue(containsTypes(flattenedSignatures, Arrays.asList(fooTypeOne, TypeNode.INT)));

    assertTrue(containsTypes(flattenedSignatures, Arrays.asList(fooTypeTwo, TypeNode.INT)));
  }

  @Test
  void flattenMethodSignatures_manyToMany() {
    String fooName = "fooName";
    String barName = "barName";
    String anInt = "anInt";
    String anotherInt = "anotherInt";

    TypeNode fooTypeOne =
        TypeNode.withReference(
            VaporReference.builder().setName("FooName").setPakkage("com.google.foobar").build());
    TypeNode fooTypeTwo =
        TypeNode.withReference(
            VaporReference.builder().setName("FooTwoName").setPakkage("com.google.foobar").build());
    TypeNode barTypeOne =
        TypeNode.withReference(
            VaporReference.builder().setName("BarName").setPakkage("com.google.foobar").build());
    TypeNode barTypeTwo =
        TypeNode.withReference(
            VaporReference.builder().setName("BarTwoName").setPakkage("com.google.foobar").build());
    TypeNode barTypeThree =
        TypeNode.withReference(
            VaporReference.builder().setName("BarCarName").setPakkage("com.google.foobar").build());

    List<String> argumentNames = Arrays.asList(fooName, anInt, barName, anotherInt);

    BiFunction<String, TypeNode, MethodArgument> methodArgFn =
        (name, type) ->
            MethodArgument.builder()
                .setName(name)
                .setType(type)
                .setField(Field.builder().setName(name).setType(type).build())
                .build();
    List<MethodArgument> fooArgs =
        Arrays.asList(TypeNode.STRING, fooTypeOne, fooTypeTwo).stream()
            .map(t -> methodArgFn.apply(fooName, t))
            .collect(Collectors.toList());
    List<MethodArgument> barArgs =
        Arrays.asList(TypeNode.STRING, barTypeOne, barTypeTwo, barTypeThree).stream()
            .map(t -> methodArgFn.apply(barName, t))
            .collect(Collectors.toList());
    Map<String, List<MethodArgument>> argumentNameToOverloads = new HashMap<>();
    argumentNameToOverloads.put(fooName, fooArgs);
    argumentNameToOverloads.put(anInt, Arrays.asList(methodArgFn.apply(anInt, TypeNode.INT)));
    argumentNameToOverloads.put(barName, barArgs);
    argumentNameToOverloads.put(
        anotherInt, Arrays.asList(methodArgFn.apply(anotherInt, TypeNode.INT)));

    List<List<MethodArgument>> flattenedSignatures =
        MethodSignatureParser.flattenMethodSignatureVariants(
            argumentNames, argumentNameToOverloads);

    assertEquals(12, flattenedSignatures.size());

    // Types 0 - 4: String, int, {String, BarName, BarTwoName, BarCarName}, int.
    assertTrue(
        containsTypes(
            flattenedSignatures,
            Arrays.asList(TypeNode.STRING, TypeNode.INT, TypeNode.STRING, TypeNode.INT)));
    assertTrue(
        containsTypes(
            flattenedSignatures,
            Arrays.asList(TypeNode.STRING, TypeNode.INT, barTypeOne, TypeNode.INT)));
    assertTrue(
        containsTypes(
            flattenedSignatures,
            Arrays.asList(TypeNode.STRING, TypeNode.INT, barTypeTwo, TypeNode.INT)));
    assertTrue(
        containsTypes(
            flattenedSignatures,
            Arrays.asList(TypeNode.STRING, TypeNode.INT, barTypeThree, TypeNode.INT)));

    // Types 5 - 8: FooName, int, {String, BarName, BarTwoName, BarCarName}, int.
    assertTrue(
        containsTypes(
            flattenedSignatures,
            Arrays.asList(fooTypeOne, TypeNode.INT, TypeNode.STRING, TypeNode.INT)));
    assertTrue(
        containsTypes(
            flattenedSignatures,
            Arrays.asList(fooTypeOne, TypeNode.INT, barTypeOne, TypeNode.INT)));
    assertTrue(
        containsTypes(
            flattenedSignatures,
            Arrays.asList(fooTypeOne, TypeNode.INT, barTypeTwo, TypeNode.INT)));
    assertTrue(
        containsTypes(
            flattenedSignatures,
            Arrays.asList(fooTypeOne, TypeNode.INT, barTypeThree, TypeNode.INT)));

    // Types 9 - 12: FooTwoName, int, {String, BarName, BarTwoName, BarCarName}, int.
    assertTrue(
        containsTypes(
            flattenedSignatures,
            Arrays.asList(fooTypeTwo, TypeNode.INT, TypeNode.STRING, TypeNode.INT)));
    assertTrue(
        containsTypes(
            flattenedSignatures,
            Arrays.asList(fooTypeTwo, TypeNode.INT, barTypeOne, TypeNode.INT)));
    assertTrue(
        containsTypes(
            flattenedSignatures,
            Arrays.asList(fooTypeTwo, TypeNode.INT, barTypeTwo, TypeNode.INT)));
    assertTrue(
        containsTypes(
            flattenedSignatures,
            Arrays.asList(fooTypeTwo, TypeNode.INT, barTypeThree, TypeNode.INT)));
  }

  private static boolean containsTypes(
      List<List<MethodArgument>> flattenedSignatures, List<TypeNode> types) {
    // Brute-force search. Feel free to improve this if you've got cycles 🙃.
    Function<List<MethodArgument>, List<TypeNode>> typeExtractorFn =
        methodArgs -> methodArgs.stream().map(m -> m.type()).collect(Collectors.toList());
    for (List<MethodArgument> args : flattenedSignatures) {
      if (typeExtractorFn.apply(args).equals(types)) {
        return true;
      }
    }
    return false;
  }
}
