package com.google.api.generator.gapic.protowriter;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.generator.engine.ast.PackageInfoDefinition;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.GapicPackageInfo;
import com.google.api.generator.gapic.model.ReflectConfig;
import com.google.common.collect.ImmutableList;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.protobuf.ByteString;
import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class WriterTest {
  private static final TypeToken<List<ReflectConfig>> REFLECT_CONFIG_JSON_FORMAT =
      new TypeToken<List<ReflectConfig>>() {};

  @TempDir Path tempDir;
  private JarOutputStream jarOutputStream;
  private File file;

  @BeforeEach
  void createJarOutputStream() throws IOException {
    Path path = tempDir.resolve("test.jar");
    jarOutputStream = new JarOutputStream(Files.newOutputStream(path));
    file = path.toFile();
  }

  private void closeJarOutputStream() throws IOException {
    jarOutputStream.finish();
    jarOutputStream.flush();
    jarOutputStream.close();
  }

  @AfterEach
  void assertJarOutputStream_isClosed() {
    assertThrows(
        IOException.class, () -> jarOutputStream.putNextEntry(new JarEntry("should.fail")));
  }

  @Test
  void reflectConfig_notWritten_ifEmptyInput() throws IOException {
    Writer.writeReflectConfigFile("com.google", Collections.emptyList(), jarOutputStream);

    closeJarOutputStream();

    try (JarFile jarFile = new JarFile(file)) {
      assertThat(jarFile.entries().hasMoreElements()).isFalse();
    }
  }

  @Test
  void reflectConfig_isWritten() throws IOException {
    Writer.writeReflectConfigFile(
        "com.google",
        Collections.singletonList(new ReflectConfig("com.google.Class")),
        jarOutputStream);

    closeJarOutputStream();

    try (JarFile jarFile = new JarFile(file)) {
      Enumeration<JarEntry> entries = jarFile.entries();
      assertThat(entries.hasMoreElements()).isTrue();
      JarEntry entry = entries.nextElement();
      assertThat(entries.hasMoreElements()).isFalse();

      try (Reader reader = new InputStreamReader(jarFile.getInputStream(entry))) {
        List<ReflectConfig> configs =
            new Gson().fromJson(reader, REFLECT_CONFIG_JSON_FORMAT.getType());

        assertThat(configs).hasSize(1);
        ReflectConfig config = configs.get(0);
        assertEquals("com.google.Class", config.getName());
      }
    }
  }

  @Test
  void write_emptyGapicContext_writesNoBytes() throws IOException {
    ByteString.Output output = ByteString.newOutput();
    CodeGeneratorResponse response =
        Writer.write(
            GapicContext.EMPTY,
            Collections.emptyList(),
            null,
            Collections.emptyList(),
            "temp-codegen.srcjar",
            jarOutputStream,
            output);
    assertTrue(output.size() == 0);
    closeJarOutputStream();
  }

  @Test
  void write_emptyGapicContextAndFilledPackageInfo_succeeds() throws IOException {
    ByteString.Output output = ByteString.newOutput();
    CodeGeneratorResponse response =
        Writer.write(
            GapicContext.EMPTY,
            ImmutableList.of(GapicClass.createNonGeneratedGapicClass()),
            GapicPackageInfo.with(PackageInfoDefinition.builder().setPakkage("com.test").build()),
            Collections.emptyList(),
            "temp-codegen.srcjar",
            jarOutputStream,
            output);
    assertTrue(output.size() == 0);
    closeJarOutputStream();
  }

  @Test
  void productionWrite_emptyGapicContext_succeeds() throws IOException {
    // This is a special case test to confirm the production function works as expected.
    // We don't need the output stream
    jarOutputStream.close();

    CodeGeneratorResponse result =
        Writer.write(
            GapicContext.EMPTY,
            ImmutableList.of(GapicClass.createNonGeneratedGapicClass()),
            GapicPackageInfo.with(PackageInfoDefinition.builder().setPakkage("com.test").build()),
            Collections.emptyList(),
            "temp-codegen.srcjar");
    assertNull(result);
  }
}
