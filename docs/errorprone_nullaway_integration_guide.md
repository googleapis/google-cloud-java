# Guide for Integrating ErrorProne and NullAway
This guide outlines how to integrate ErrorProne and NullAway into your Java project. You can choose to implement basic ErrorProne analysis or extend it with NullAway for strict JSpecify nullability validation.

## Definitions
* **ErrorProne**: A Java compiler plugin created by Google that hooks into the compilation process to identify common bug patterns at compile-time.
* **NullAway**: A fast, low-overhead null-pointer checker designed as an ErrorProne plugin. It eliminates NullPointerExceptions (NPEs) by checking annotations on method signatures and variable declarations.
* **JSpecify**: A standard set of annotations (like `@NullMarked` and `@Nullable`) that define the nullness contracts for Java types. NullAway has a strict JSpecifyMode that aligns its rules with the JSpecify spec.

---

## 1. Basic ErrorProne Setup
ErrorProne hooks into the compilation process to identify bug patterns. This is configured directly inside the `maven-compiler-plugin`.

### Maven Configuration
Add ErrorProne to the `<annotationProcessorPaths>` of the `maven-compiler-plugin`:
```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-compiler-plugin</artifactId>
  <version>${maven-compiler-plugin.version}</version> <!-- Or omit if managed by parent POM -->
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
By default, NullAway checks nullability using legacy checking rules. Passing `-XepOpt:NullAway:JSpecifyMode=true` enables **JSpecify Mode**, which aligns NullAway's static analysis with the JSpecify 1.0 specifications:
* **Generics Nullability**: Enables checking annotations inside generic parameters (e.g. `List<@Nullable String>`).
* **Subclass Compatibility**: Enforces strict Liskov Substitution Principle compliance, ensuring subclasses do not accept fewer nulls or return more nulls than their parent class methods.
* **Array element checks**: Validates nullability contracts on array references and array type arguments.
* **Bytecode Symbol Dependency**: Checking generics and type-use nullability requires the compiler to preserve these type-use annotations in compiled bytecode symbols. Consequently, JSpecify Mode requires building on JDK 22+ or using OpenJDK 17/21 with the `-XDaddTypeAnnotationsToSymbol=true` compiler argument.

### Maven NullAway Setup
```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-compiler-plugin</artifactId>
  <version>${maven-compiler-plugin.version}</version> <!-- Or omit if managed by parent POM -->
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

---

## 5. Supported JDK Versions & Compiler Requirements
When `JSpecifyMode` is enabled, NullAway requires the compiler to support reading type-use annotations from bytecode symbols:
* **JDK 22 or higher**: Fully supported natively.
* **JDK 17 and 21**: You must pass `-XDaddTypeAnnotationsToSymbol=true` in `compilerArgs`.
  * **Important**: This flag is only supported by OpenJDK builds (e.g. Temurin, Zulu) as of release 21.0.8 / 17.0.19. It is not supported by Oracle JDK.
* **NullAway Version**: Use **`0.11.0` or higher** on JDK 21+ to avoid compiler crashes due to a known `NullPointerException` inside the analyzer's generics checks (e.g., `castToNonNull failed!` in `GenericsChecks`).
