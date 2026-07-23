# Automation & Migration Playbook
Onboarding a large codebase to strict JSpecify null safety requires a systematic approach. This document details the automation workflow and best practices.

---

## 1. Generated vs. Handwritten Code Handling
Before starting the migration, identify which parts of the codebase are generated vs. handwritten:
* **Handwritten Modules (GAX, Auth, parent modules)**: Apply the 3-step automation workflow below directly to the source tree.
* **Generated Modules**: Do not edit generated classes manually! Instead, update the code generator engine (`gapic-generator-java`) to output JSpecify annotations (`@NullMarked` on classes/packages and `@Nullable` on generic/nullable return methods) during its code generation phase.

---

## 2. The 3-Step Automation Workflow
Use these three parts in order to automate the mechanical tasks of JSpecify migration.

### Part 1: Bulk `@NullMarked` Annotation (Automated Script)
Use a python script to search Java source directories and inject `@NullMarked` at the package or class level:
* **Package-level**: Add to `package-info.java` files.
* **Class-level**: Prepend `@NullMarked` to top-level classes, interfaces, or enums.

*Example class-level injection pattern (Python)*:
```python
package_match = re.search(r"^(package\s+[\w\.]+;)", content, re.MULTILINE)
if package_match:
    package_line = package_match.group(1)
    content = content.replace(package_line, package_line + "\nimport org.jspecify.annotations.NullMarked;")
# Add @NullMarked before the class/interface/enum
content = re.sub(r"\n(public\s+)?(class|interface|enum)\s+", r"\n@NullMarked\n\2 ", content)
```

---

### Part 2: Legacy Javax Migration (Automated Script)
Translate legacy annotations (e.g. `javax.annotation.Nullable`) to JSpecify `@Nullable`. If annotations are in declaration positions, programmatically reposition them to type-use positions:
```python
# Reposition from declaration-use to type-use position if necessary
content = re.sub(r"@Nullable\s+public\s+(\w+)", r"public @Nullable \1", content)
# Replace imports
content = content.replace("import javax.annotation.Nullable;", "import org.jspecify.annotations.Nullable;")
```

---

### Part 3: ErrorProne Auto-Patching (`nullaway-patch`)
For the remaining manual nullness checks, configure ErrorProne's built-in **Auto-Patching tool** to scan your project, trace assignments, and write suggested `@Nullable` annotations directly to your source files.

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
        <version>${maven-compiler-plugin.version}</version> <!-- Or omit if managed by parent POM -->
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
            <path>
              <groupId>com.uber.nullaway</groupId>
              <artifactId>nullaway</artifactId>
              <version>${nullaway.version}</version>
            </path>
          </annotationProcessorPaths>
        </configuration>
      </plugin>
    </plugins>
  </build>
</profile>
```
**Command to execute:**
```shell
mvn clean compile -Pnullaway-patch
```
*(Verify changes using `git diff` after compilation)*

---

## 3. Reference
https://buganizer.corp.google.com/issues/341380807 
