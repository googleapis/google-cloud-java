# Guide for Integrating ErrorProne and NullAway
This guide outlines how to integrate ErrorProne and NullAway into your Java project. You can choose to implement basic ErrorProne analysis or extend it with NullAway for strict JSpecify nullability validation.

## Definitions
* **ErrorProne**: A Java compiler plugin created by Google that hooks into the compilation process to identify common bug patterns at compile-time.
* **NullAway**: A fast, low-overhead null-pointer checker designed as an ErrorProne plugin. It eliminates NullPointerExceptions (NPEs) by checking annotations on method signatures and variable declarations.
* **JSpecify**: A standard set of annotations (like `@NullMarked` and `@Nullable`) that define the nullness contracts for Java types. NullAway has a strict JSpecifyMode that aligns its rules with the JSpecify spec.

---

## 0. Prerequisites

### Compiler JVM Runtime (JSpecify Mode Prerequisites)
When `JSpecifyMode` is enabled, NullAway requires the compiler to preserve type-use annotations inside compiled bytecode symbols. Compatibility and setup requirements depend on your build environment:
* **JDK 22 or higher**: Fully supported natively out-of-the-box (no extra compiler arguments needed).
* **JDK 17 and 21**: Supported conditionally:
  * You must pass the compiler argument `-XDaddTypeAnnotationsToSymbol=true` in `compilerArgs`.
  * **OpenJDK Only**: This flag is only supported by OpenJDK distributions (e.g., Eclipse Temurin, Amazon Corretto, Azul Zulu) as of releases 21.0.8 / 17.0.19. It is not supported by Oracle JDK.
  * **Generics Fallback**: If you compile on JDK 17 or 21 without this argument (or if using Oracle JDK), NullAway will compile successfully but will skip/ignore generics and type-use nullability checks on compiled dependency symbols.
* **NullAway Version**: Use `0.11.0` or higher on JDK 21+ to avoid compiler crashes (like `NullPointerException` or `castToNonNull failed!` in `GenericsChecks`) due to a known generics analysis bug.
* **JDK 11**: Not Supported for JSpecify generics/type-use symbol checking. The compiler flag `-XDaddTypeAnnotationsToSymbol=true` does not exist in JDK 11.
* **JDK 8**: Not Supported. Modern ErrorProne releases (v2.11.0+) require JDK 11+ to run, and a compiler running on a JDK 8 JVM cannot load the plugin.

### ErrorProne & JDK Compatibility
ErrorProne interacts directly with the Java compiler's internal APIs. Depending on your build environment, keep the following requirements in mind:
* **JDK 11+ Requirement**: Modern versions of ErrorProne (v2.11.0+) require building with JDK 11 or higher.
* **JDK 16+ (JVM Exports)**: Since JDK 16, Java enforces strict encapsulation of compiler internals. If compiling on JDK 16 or higher, you must supply compiler exports (`--add-exports` and `--add-opens`) to give ErrorProne access to the compiler modules. See the Maven configuration in Section 2 for the exact list of export arguments.
* **JDK 21 Compatibility**: If building with JDK 21, use ErrorProne version 2.22.0 or higher to ensure compatibility with compiler changes and prevent internal crashes.
* **JDK 8 Support**: If you must compile on a JDK 8 JVM runtime, you must use a legacy version of ErrorProne (2.10.0 or lower). Modern versions of ErrorProne (v2.11.0+) require JDK 11+ to run.

---

## 1. Basic ErrorProne Setup
ErrorProne hooks into the compilation process to identify bug patterns. This is configured directly inside the `maven-compiler-plugin`.

### Maven Configuration
Add ErrorProne to the `<annotationProcessorPaths>` of the `maven-compiler-plugin`:
```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-compiler-plugin</artifactId>
  <version>${maven-compiler-plugin.version}</version>
  <configuration>
    <annotationProcessorPaths>
      <path>
        <groupId>com.google.errorprone</groupId>
        <artifactId>error_prone_core</artifactId>
        <version>${errorprone.version}</version>
      </path>
    </annotationProcessorPaths>
  </configuration>
</plugin>
```

### Gradle Configuration
```groovy
plugins {
  id("net.ltgt.errorprone") version "${errorprone.plugin.version}"
}
dependencies {
  errorprone("com.google.errorprone:error_prone_core:${errorprone.version}")
}
```

---

## 2. Adding NullAway
NullAway runs as an annotation processor plug-in inside ErrorProne. To configure it:
1. Add NullAway to the compiler's annotation processor paths.
2. Pass flags enabling NullAway and setting packages to scan.

### [Optional] Understanding NullAway JSpecify Mode
By default, NullAway checks nullability using legacy checking rules. Passing `-XepOpt:NullAway:JSpecifyMode=true` enables JSpecify Mode, which aligns NullAway's static analysis with the JSpecify 1.0 specifications:
* **Generics Nullability**: Enables checking annotations inside generic parameters (e.g. `List<@Nullable String>`).
* **Subclass Compatibility**: Enforces strict Liskov Substitution Principle compliance, ensuring subclasses do not accept fewer nulls or return more nulls than their parent class methods.
* **Array element checks**: Validates nullability contracts on array references and array type arguments.
* **Bytecode Symbol Dependency**: Checking generics and type-use nullability requires the compiler to preserve these type-use annotations in compiled bytecode symbols. Consequently, JSpecify Mode requires building on JDK 22+ or using OpenJDK 17/21 with the `-XDaddTypeAnnotationsToSymbol=true` compiler argument.

### Maven NullAway Setup
```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-compiler-plugin</artifactId>
  <version>${maven-compiler-plugin.version}</version>
  <configuration>
    <fork>true</fork>
    <compilerArgs>
      <arg>-XDcompilePolicy=simple</arg>
      <!-- Enforces NullAway JSpecify violations -->
      <arg>-Xplugin:ErrorProne -Xep:NullAway:ERROR -XepOpt:NullAway:AnnotatedPackages=<your.package.prefix> -XepOpt:NullAway:JSpecifyMode=true</arg>
      <arg>-XDshould-stop.ifError=FLOW</arg>
      <arg>-XDaddTypeAnnotationsToSymbol=true</arg>
      
      <!-- JDK 16+ exports (only when running on Java 16+) -->
      <arg>-J--add-exports=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED</arg>
      <arg>-J--add-exports=jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED</arg>
      <arg>-J--add-exports=jdk.compiler/com.sun.tools.javac.main=ALL-UNNAMED</arg>
      <arg>-J--add-exports=jdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED</arg>
      <arg>-J--add-exports=jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED</arg>
      <arg>-J--add-exports=jdk.compiler/com.sun.tools.javac.processing=ALL-UNNAMED</arg>
      <arg>-J--add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED</arg>
      <arg>-J--add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED</arg>
      <arg>-J--add-opens=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED</arg>
      <arg>-J--add-opens=jdk.compiler/com.sun.tools.javac.comp=ALL-UNNAMED</arg>
    </compilerArgs>
    <annotationProcessorPaths>
      <path>
        <groupId>com.google.errorprone</groupId>
        <artifactId>error_prone_core</artifactId>
        <version>${errorprone.version}</version>
      </path>
      <path>
        <groupId>com.uber.nullaway</groupId>
        <artifactId>nullaway</artifactId>
        <version>${nullaway.version}</version>
      </path>
    </annotationProcessorPaths>
  </configuration>
</plugin>
```

### Gradle NullAway Setup
```groovy
dependencies {
  errorprone("com.uber.nullaway:nullaway:${nullaway.version}")
}

tasks.withType(JavaCompile).configureEach {
  options.errorprone {
    check("NullAway", CheckSeverity.ERROR)
    option("NullAway:AnnotatedPackages", "your.package.prefix")
    option("NullAway:JSpecifyMode", "true")
  }
}
```
Configure the compiler plugin to run ErrorProne as a compiler plugin and NullAway as an annotation processor.

* **Classpath Note**: Ensure `error_prone_api` is on the classpath to prevent runtime failures.
* **Recommendation for Build Severity**: If your project has many existing violations, default to `WARN` initially. Upgrade to `ERROR` to break the build only after those issues are resolved.

---

## 3. Running On-Demand with Maven Profiles (Optional)
Because running deep nullness checks on every compile slows down build times, we encapsulate these checks into a Maven Profile to run them on-demand.

### Profile A: Strict Check (`nullaway`)
This profile enforces NullAway checks on annotated packages and breaks the build on any violation: 
```xml
<profiles>
  <profile>
    <id>nullaway</id>
    <build>
      <plugins>
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>${maven-compiler-plugin.version}</version> <!-- Or omit if managed by parent POM -->
          <configuration>
            <!-- Insert compiler configuration from Section 2 here -->
          </configuration>
        </plugin>
      </plugins>
    </build>
  </profile>
</profiles>
```

---

## 4. Verification & Testing

### Understanding NullAway Configuration Flags
* **`-Xep:NullAway:ERROR`** (Recommended Setting: `ERROR` / `WARN`): Set to `ERROR` to break the build on any nullability contract violation and try to resolve the flagged reports. If too many to be resolved, set to `WARN` to print warnings without failing the compilation.
* **`AnnotatedPackages`** (Recommended Setting: `<your.package.prefix>`): Required. A comma-separated list of package prefixes that NullAway scans. Anything outside these package prefixes will be ignored.
* **`JSpecifyMode`** (Recommended Setting: `true`): Required for JSpecify. Enforces strict JSpecify rules, including type-use checks, array type-argument checks, and subclass compatibility constraints.

### How to Verify Success
Run the compilation command:
```shell
mvn clean compile
```
*(or `mvn clean compile -Pnullaway` if using the profile)*

* **Success**: You see `BUILD SUCCESS`. This guarantees your code has no nullability violations within the annotated packages.
* **To verify the checks are actively running**:
  1. Add an intentional bug method (introduce a temporary violation to one of your Java files).
  2. Run the build with `mvn clean compile -X` and search the output logs for `-Xplugin:ErrorProne` or `NullAway`. If Maven is passing those arguments to the compiler, the checker is active.
* **Failure**: The compiler fails with clear error messages pointing to code lines. Ex:
  `[ERROR] /path/to/File.java:[45,12] error: [NullAway] passing @Nullable parameter to a @NonNull method`
