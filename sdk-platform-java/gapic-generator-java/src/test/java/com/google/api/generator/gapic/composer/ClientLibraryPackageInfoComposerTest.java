// Copyright 2022 Google LLC
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

package com.google.api.generator.gapic.composer;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.google.api.generator.engine.writer.JavaWriterVisitor;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.GapicPackageInfo;
import com.google.api.generator.test.framework.Assert;
import com.google.api.generator.test.framework.GoldenFileWriter;
import com.google.api.generator.test.protoloader.TestProtoLoader;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

class ClientLibraryPackageInfoComposerTest {
  private GapicContext context = TestProtoLoader.instance().parseShowcaseEcho();

  @Test
  void composePackageInfo_showcase() {
    GapicPackageInfo packageInfo = ClientLibraryPackageInfoComposer.generatePackageInfo(context);
    JavaWriterVisitor visitor = new JavaWriterVisitor();
    packageInfo.packageInfo().accept(visitor);
    GoldenFileWriter.saveCodegenToFile(
        this.getClass(), "ShowcaseWithEchoPackageInfo.golden", visitor.write());
    Path goldenFilePath =
        Paths.get(
            GoldenFileWriter.getGoldenDir(this.getClass()), "ShowcaseWithEchoPackageInfo.golden");
    Assert.assertCodeEquals(goldenFilePath, visitor.write());
  }

  @Test
  void testGeneratePackageInfo_noServices_returnsNullPackageInfo() {
    assertNull(ClientLibraryPackageInfoComposer.generatePackageInfo(GapicContext.EMPTY));
  }
}
