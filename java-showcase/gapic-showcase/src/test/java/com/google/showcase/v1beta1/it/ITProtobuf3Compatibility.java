/*
 * Copyright 2026 Google LLC
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

package com.google.showcase.v1beta1.it;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.op.Ops;
import org.tensorflow.op.core.Constant;
import org.tensorflow.op.math.Add;
import org.tensorflow.proto.GraphDef;
import org.tensorflow.types.TInt32;

/**
 * Tensorflow depends on protobuf 3.x gen code and runtime, we test it in showcase module to prove
 * that it works with protobuf 4.33+ gen code and runtime that comes with client libraries.
 */
class ITProtobuf3Compatibility {

  @Test
  void testTensorflow_helloWorldExample() {
    try (Graph graph = new Graph()) {
      // Hello world example for "10 + 32" operation.
      Ops tf = Ops.create(graph);

      int expectedValue1 = 10;
      int expectedValue2 = 32;
      int expectedSum = 42;

      String name1 = "constant1";
      String name2 = "constant2";

      Constant<TInt32> constant1 = tf.withName(name1).constant(expectedValue1);
      Constant<TInt32> constant2 = tf.withName(name2).constant(expectedValue2);

      Add<TInt32> sum = tf.math.add(constant1, constant2);

      try (Session s = new Session(graph)) {
        try (TInt32 result = (TInt32) s.runner().fetch(sum).run().get(0)) {
          int actualResult = result.getInt();
          assertThat(actualResult).isEqualTo(expectedSum);
        }
      }

      // GraphDef is a protobuf gen code.
      GraphDef graphDef = graph.toGraphDef();

      // Inspect the protobuf gen code
      Integer actual1 = getValueFromGraphDefByName(graphDef, name1);
      Integer actual2 = getValueFromGraphDefByName(graphDef, name2);

      assertThat(actual1).isEqualTo(expectedValue1);
      assertThat(actual2).isEqualTo(expectedValue2);
    }
  }

  private static Integer getValueFromGraphDefByName(GraphDef graphDef, String name1) {
    return graphDef.getNodeList().stream()
        .filter(nodeDef -> nodeDef.getName().equals(name1))
        .findFirst()
        .get()
        .getAttrOrThrow("value")
        .getTensor()
        .getIntValList()
        .get(0);
  }
}
