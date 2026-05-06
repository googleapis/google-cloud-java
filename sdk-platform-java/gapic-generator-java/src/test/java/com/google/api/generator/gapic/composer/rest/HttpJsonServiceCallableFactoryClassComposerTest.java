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

package com.google.api.generator.gapic.composer.rest;

import com.google.api.generator.engine.writer.JavaWriterVisitor;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.test.framework.Assert;
import com.google.api.generator.test.framework.GoldenFileWriter;
import com.google.api.generator.test.protoloader.RestTestProtoLoader;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

class HttpJsonServiceCallableFactoryClassComposerTest {
  @Test
  void generateServiceClasses() {
    GapicContext context = RestTestProtoLoader.instance().parseCompliance();
    Service echoProtoService = context.services().get(0);
    GapicClass clazz =
        HttpJsonServiceCallableFactoryClassComposer.instance().generate(context, echoProtoService);

    JavaWriterVisitor visitor = new JavaWriterVisitor();
    clazz.classDefinition().accept(visitor);
    GoldenFileWriter.saveCodegenToFile(
        this.getClass(), "HttpJsonComplianceCallableFactory.golden", visitor.write());
    Path goldenFilePath =
        Paths.get(
            GoldenFileWriter.getGoldenDir(this.getClass()),
            "HttpJsonComplianceCallableFactory.golden");
    Assert.assertCodeEquals(goldenFilePath, visitor.write());
  }
}
