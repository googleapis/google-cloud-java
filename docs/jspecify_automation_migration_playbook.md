# Automation & Migration Playbook
Onboarding a large codebase to strict JSpecify null safety requires a systematic approach. This document details the automation workflow and best practices.

---

## 1. The 2-Step Automation Workflow
ErrorProne's built-in auto-patcher (`nullaway-patch`) only operates on compilable Java files and is restricted to adding `@Nullable` annotations to sites flagged as compilation errors by NullAway analysis. It has key limitations that require prior scripting steps:
* **No `@NullMarked` Injection**: The auto-patcher does not know how to default class-level or package-level nullability by adding `@NullMarked` annotations.
* **No Javax/Legacy Migration**: The auto-patcher does not automatically clean up or migrate legacy javax annotations (like `javax.annotation.Nullable`) or ensure they are repositioned to type-use positions.

### Part 1: Bulk `@NullMarked` & Legacy Javax Migration
To prepare your source trees for compilation checks, run this combined Python script on your handwritten directories to inject class-level `@NullMarked` annotations, migrate legacy `javax.annotation.Nullable` imports to JSpecify, and reposition them to type-use positions:
* **Migration Script PR Reference**: [PR #13889](https://github.com/googleapis/google-cloud-java/pull/13889)

### Part 2: ErrorProne Auto-Patching (`nullaway-patch`)
For the remaining manual nullness checks, configure ErrorProne's built-in Auto-Patching tool to scan your project, trace assignments, and write suggested `@Nullable` annotations directly to your source files.

#### Declare Profile B: Auto-Patching (`nullaway-patch`)
Add this profile to your `pom.xml`:
```xml
<profile>
  <id>nullaway-patch</id>
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>${maven-compiler-plugin.version}</version>
        <configuration>
          <fork>true</fork>
          <compilerArgs>
            <arg>-XDcompilePolicy=simple</arg>
            <arg>-XDshould-stop.ifError=FLOW</arg>
            <arg>-XDaddTypeAnnotationsToSymbol=true</arg>
            
            <!-- Configures ErrorProne patch checkers to write modifications IN_PLACE using JSpecify annotations -->
            <arg>-Xplugin:ErrorProne -XepDisableAllChecks -Xep:FieldMissingNullable:ERROR -Xep:ParameterMissingNullable:ERROR -Xep:ReturnMissingNullable:ERROR -Xep:EqualsMissingNullable:ERROR -XepPatchChecks:FieldMissingNullable,ParameterMissingNullable,ReturnMissingNullable,EqualsMissingNullable -XepPatchLocation:IN_PLACE -XepOpt:Nullness:DefaultNullnessAnnotation=org.jspecify.annotations.Nullable</arg>
            
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
          </annotationProcessorPaths>
        </configuration>
      </plugin>
    </plugins>
  </build>
</profile>
```

**Important Configuration Detail:**
The critical argument within the profile driving ErrorProne's in-place patching and JSpecify annotation injection is:
```xml
<!-- Configures ErrorProne patch checkers to write modifications IN_PLACE using JSpecify annotations -->
<arg>-Xplugin:ErrorProne -XepDisableAllChecks -Xep:FieldMissingNullable:ERROR -Xep:ParameterMissingNullable:ERROR -Xep:ReturnMissingNullable:ERROR -Xep:EqualsMissingNullable:ERROR -XepPatchChecks:FieldMissingNullable,ParameterMissingNullable,ReturnMissingNullable,EqualsMissingNullable -XepPatchLocation:IN_PLACE -XepOpt:Nullness:DefaultNullnessAnnotation=org.jspecify.annotations.Nullable</arg>
```

**Command to execute:**
```shell
mvn clean compile -Pnullaway-patch
```
*(Verify changes using `git diff` after compilation)*

---

## 2. References
* [Buganizer Issue 341380807](https://buganizer.corp.google.com/issues/341380807)
