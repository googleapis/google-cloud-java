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

package com.google.api.generator.gapic.composer.grpc;

import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.test.framework.Assert;
import com.google.api.generator.test.protoloader.TestProtoLoader;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ServiceStubClassComposerTest {
  static Stream<Arguments> data() {
    return Stream.of(
        Arguments.of("EchoStub", TestProtoLoader.instance().parseShowcaseEcho(), "", "", 0),
        Arguments.of(
            "DeprecatedServiceStub",
            TestProtoLoader.instance().parseDeprecatedService(),
            "",
            "",
            0),
        Arguments.of(
            "EchoServiceSelectiveGapicClientStub",
            TestProtoLoader.instance().parseSelectiveGenerationTesting(),
            "",
            "",
            1));
  }

  @ParameterizedTest
  @MethodSource("data")
  void generateServiceStubClasses(
      String name,
      GapicContext context,
      String apiShortNameExpected,
      String packageVersionExpected,
      int serviceIndex) {
    Service service = context.services().get(serviceIndex);
    GapicClass clazz = ServiceStubClassComposer.instance().generate(context, service);

    Assert.assertGoldenClass(this.getClass(), clazz, name + ".golden");
    Assert.assertEmptySamples(clazz.samples());
    Assert.assertCodeEquals(clazz.apiShortName(), apiShortNameExpected);
    Assert.assertCodeEquals(clazz.packageVersion(), packageVersionExpected);
  }
}
