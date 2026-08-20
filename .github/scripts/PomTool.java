// Copyright 2026 Google LLC
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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * PomTool is a zero-dependency CLI tool that reads and updates Maven {@code pom.xml} files in CI
 * and Kokoro build scripts.
 *
 * <p>It replaces previous {@code xmllint} shell scripts by leveraging Java's built-in standard
 * library DOM parser ({@link DocumentBuilderFactory}) and standard W3C XPath evaluator ({@link
 * XPathFactory}), requiring no external packages or compilation.
 *
 * <p>Usage:
 *
 * <pre>
 *   java .github/scripts/PomTool.java get-version &lt;pom.xml&gt;
 *   java .github/scripts/PomTool.java set-version &lt;pom.xml&gt; &lt;newVersion&gt;
 *   java .github/scripts/PomTool.java set-dep-version &lt;pom.xml&gt; &lt;artifactId&gt; &lt;newVersion&gt;
 *   java .github/scripts/PomTool.java set-prop-version &lt;pom.xml&gt; &lt;propertyName&gt; &lt;newVersion&gt;
 *   java .github/scripts/PomTool.java find-versioned-dep &lt;artifactId&gt; [&lt;rootDir&gt;]
 *   java .github/scripts/PomTool.java has-versioned-dep &lt;pom.xml&gt; &lt;artifactId&gt;
 * </pre>
 */
public final class PomTool {

  private PomTool() {}

  /**
   * Creates a DocumentBuilder configured for fast, offline, and namespace-agnostic parsing.
   *
   * <ul>
   *   <li><b>setNamespaceAware(false)</b>: Maven POM files declare a default XML namespace ({@code
   *       <project xmlns="http://maven.apache.org/POM/4.0.0">}). Setting namespace awareness to
   *       false allows standard W3C XPath expressions (e.g. {@code /project/version} or {@code
   *       //dependency}) to match elements directly without needing namespace prefixes, matching
   *       the exact behavior of {@code xmllint}.
   *   <li><b>setValidating(false)</b>: Disables DTD/XSD schema validation against remote URLs. This
   *       prevents the parser from making network requests to download schemas from
   *       maven.apache.org, ensuring the tool runs hermetically and offline.
   *   <li><b>load-external-dtd = false</b>: Explicitly disables loading external DTD files from the
   *       internet or local filesystem, preventing XXE security vulnerabilities and avoiding
   *       network timeout delays.
   * </ul>
   */
  private static DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(false);
    factory.setValidating(false);
    factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

    DocumentBuilder builder = factory.newDocumentBuilder();
    builder.setErrorHandler(new SilentErrorHandler());
    return builder;
  }

  /** Parses an XML file into a DOM Document. */
  public static Document parsePom(File pomFile)
      throws IOException, SAXException, ParserConfigurationException {
    if (!pomFile.exists() || pomFile.length() == 0) {
      throw new IOException("POM file does not exist or is empty: " + pomFile);
    }
    return newDocumentBuilder().parse(pomFile);
  }

  /**
   * Serializes a DOM Document back to the POM file.
   *
   * <ul>
   *   <li><b>OutputKeys.METHOD = "xml"</b>: Emits well-formed XML with XML declarations and proper
   *       element tags, rather than HTML or text format.
   *   <li><b>OutputKeys.ENCODING = "UTF-8"</b>: Explicitly enforces UTF-8 character encoding to
   *       prevent corruption across different operating system locales.
   * </ul>
   */
  public static void writePom(Document doc, File pomFile) throws TransformerException {
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

    DOMSource source = new DOMSource(doc);
    StreamResult result = new StreamResult(pomFile);
    transformer.transform(source, result);
  }

  /**
   * Extracts the project version from a POM file.
   *
   * <p>If the top-level {@code <project><version>} is omitted (as is common in child modules of a
   * multi-module build), this method falls back to the parent POM version ({@code
   * <project><parent><version>}), matching standard Maven coordinate resolution.
   *
   * @param pomFile the pom.xml file to inspect
   * @return the resolved version string
   */
  public static String getProjectVersion(File pomFile)
      throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {
    Document doc = parsePom(pomFile);
    XPath xpath = XPathFactory.newInstance().newXPath();

    String version = (String) xpath.evaluate("/project/version/text()", doc, XPathConstants.STRING);
    if (version != null && !version.trim().isEmpty()) {
      return version.trim();
    }

    // Fallback: Check parent version if child inherits version from its parent POM
    version = (String) xpath.evaluate("/project/parent/version/text()", doc, XPathConstants.STRING);
    if (version != null && !version.trim().isEmpty()) {
      return version.trim();
    }

    throw new IllegalArgumentException(
        "Project version not found in <project><version> or <parent><version> in " + pomFile);
  }

  /**
   * Updates the top-level {@code <project><version>} element in-place.
   *
   * @param pomFile the target pom.xml file
   * @param newVersion the new version value
   */
  public static void setProjectVersion(File pomFile, String newVersion)
      throws IOException,
          SAXException,
          ParserConfigurationException,
          XPathExpressionException,
          TransformerException {
    Document doc = parsePom(pomFile);
    XPath xpath = XPathFactory.newInstance().newXPath();

    Node versionNode = (Node) xpath.evaluate("/project/version", doc, XPathConstants.NODE);
    if (versionNode == null) {
      throw new IllegalArgumentException("Top-level <project><version> not found in " + pomFile);
    }

    versionNode.setTextContent(newVersion);
    writePom(doc, pomFile);
  }

  /**
   * Updates the {@code <version>} tag for any {@code <dependency>} or {@code <plugin>} block
   * matching {@code targetArtifactId}.
   *
   * <p>The XPath query matches:
   *
   * <ul>
   *   <li>{@code //}: Recursively searches anywhere in the document (under {@code <dependencies>},
   *       {@code <dependencyManagement>}, {@code <build><plugins>}, {@code <pluginManagement>}, or
   *       {@code <profiles>}).
   *   <li>{@code *[self::dependency or self::plugin]}: Matches elements whose tag is either {@code
   *       <dependency>} or {@code <plugin>}.
   *   <li>{@code [artifactId='<targetArtifactId>']}: Filters to blocks where the child {@code
   *       <artifactId>} matches the target ID.
   *   <li>{@code /version}: Selects the child {@code <version>} node to update.
   * </ul>
   *
   * @param pomFile the target pom.xml file
   * @param targetArtifactId the artifactId of the dependency or plugin to update
   * @param newVersion the new version value
   */
  public static void setDependencyVersion(File pomFile, String targetArtifactId, String newVersion)
      throws IOException,
          SAXException,
          ParserConfigurationException,
          XPathExpressionException,
          TransformerException {
    Document doc = parsePom(pomFile);
    XPath xpath = XPathFactory.newInstance().newXPath();

    String query =
        "//*[self::dependency or self::plugin][artifactId='" + targetArtifactId + "']/version";
    NodeList versionNodes = (NodeList) xpath.evaluate(query, doc, XPathConstants.NODESET);

    if (versionNodes.getLength() == 0) {
      throw new IllegalArgumentException(
          "Dependency or plugin '"
              + targetArtifactId
              + "' with explicit <version> not found in "
              + pomFile);
    }

    for (int i = 0; i < versionNodes.getLength(); i++) {
      versionNodes.item(i).setTextContent(newVersion);
    }

    writePom(doc, pomFile);
  }

  /**
   * Updates a property tag ({@code <properties><propertyName>value</propertyName>}) in-place.
   *
   * @param pomFile the target pom.xml file
   * @param propertyName the name of the property element under {@code <properties>}
   * @param newVersion the new property value
   */
  public static void setPropertyVersion(File pomFile, String propertyName, String newVersion)
      throws IOException,
          SAXException,
          ParserConfigurationException,
          XPathExpressionException,
          TransformerException {
    Document doc = parsePom(pomFile);
    XPath xpath = XPathFactory.newInstance().newXPath();

    Node propNode =
        (Node) xpath.evaluate("/project/properties/" + propertyName, doc, XPathConstants.NODE);
    if (propNode == null) {
      throw new IllegalArgumentException(
          "Property <" + propertyName + "> not found under <properties> in " + pomFile);
    }

    propNode.setTextContent(newVersion);
    writePom(doc, pomFile);
  }

  /**
   * Checks if a POM file contains a {@code <dependency>} or {@code <plugin>} with an explicit
   * {@code <version>} tag for {@code targetArtifactId}.
   *
   * @param pomFile the pom.xml file to inspect
   * @param targetArtifactId the artifactId to check
   * @return true if the artifact has an explicit version tag, false otherwise
   */
  public static boolean hasVersionedDependency(File pomFile, String targetArtifactId) {
    try {
      Document doc = parsePom(pomFile);
      XPath xpath = XPathFactory.newInstance().newXPath();
      String query =
          "//*[self::dependency or self::plugin][artifactId='"
              + targetArtifactId
              + "']/version/text()";
      String ver = (String) xpath.evaluate(query, doc, XPathConstants.STRING);
      return ver != null && !ver.trim().isEmpty();
    } catch (Exception ignored) {
      return false;
    }
  }

  /**
   * Recursively finds all {@code pom.xml} files within {@code rootDir} across the entire repository
   * that declare an explicit {@code <version>} for {@code targetArtifactId}.
   *
   * <p>This is used by {@code .kokoro/common.sh} (inside {@code
   * find_all_poms_with_versioned_dependency}) to locate all client library modules that need
   * dependency version updates.
   *
   * <p>It searches all files across the repository tree (excluding {@code .git} metadata
   * directories) in a single fast in-process pass.
   *
   * @param rootDir the root directory to search from
   * @param targetArtifactId the artifactId to check
   */
  public static void findPomsWithVersionedDependency(File rootDir, String targetArtifactId)
      throws IOException {
    Path rootPath = rootDir.toPath();
    String query =
        "//*[self::dependency or self::plugin][artifactId='"
            + targetArtifactId
            + "']/version/text()";

    try (Stream<Path> stream = Files.walk(rootPath)) {
      stream
          .filter(path -> !path.toString().contains("/.git/"))
          .filter(path -> path.getFileName().toString().equals("pom.xml"))
          .filter(path -> path.toFile().length() > 0)
          .sorted(Comparator.comparing(Path::toString))
          .forEach(
              path -> {
                try {
                  Document doc = newDocumentBuilder().parse(path.toFile());
                  XPath xpath = XPathFactory.newInstance().newXPath();
                  String ver = (String) xpath.evaluate(query, doc, XPathConstants.STRING);
                  if (ver != null && !ver.trim().isEmpty()) {
                    String relPath = rootPath.relativize(path).toString();
                    System.out.println(relPath.startsWith(".") ? relPath : "./" + relPath);
                  }
                } catch (Exception ignored) {
                  // Skip malformed or unparseable POM files during directory scans
                }
              });
    } catch (Exception e) {
      throw new IOException("Error searching for pom.xml files in " + rootDir, e);
    }
  }

  private static void printUsage() {
    System.err.println(
        "Usage: java PomTool.java <command> [arguments...]\n\n"
            + "Commands:\n"
            + "  get-version <pom.xml>\n"
            + "      Print project version (or inherited parent version)\n\n"
            + "  set-version <pom.xml> <new-version>\n"
            + "      Update /project/version in-place\n\n"
            + "  set-dep-version <pom.xml> <artifactId> <new-version>\n"
            + "      Update <version> of dependency or plugin with artifactId in-place\n\n"
            + "  set-prop-version <pom.xml> <propertyName> <new-version>\n"
            + "      Update <properties><propertyName> in-place\n\n"
            + "  find-versioned-dep <artifactId> [<rootDir>]\n"
            + "      Print relative paths to all POMs containing an explicit <version> for"
            + " artifactId\n\n"
            + "  has-versioned-dep <pom.xml> <artifactId>\n"
            + "      Exit 0 if dependency has an explicit <version>, exit 1 otherwise\n");
  }

  public static void main(String[] args) {
    if (args.length < 2) {
      printUsage();
      System.exit(1);
    }

    String command = args[0];

    try {
      switch (command) {
        case "get-version":
          {
            File pomFile = new File(args[1]);
            String version = getProjectVersion(pomFile);
            System.out.println(version);
            break;
          }

        case "set-version":
          {
            if (args.length < 3) {
              System.err.println("Usage: java PomTool.java set-version <pom.xml> <newVersion>");
              System.exit(1);
            }
            File pomFile = new File(args[1]);
            setProjectVersion(pomFile, args[2]);
            break;
          }

        case "set-dep-version":
          {
            if (args.length < 4) {
              System.err.println(
                  "Usage: java PomTool.java set-dep-version <pom.xml> <artifactId> <newVersion>");
              System.exit(1);
            }
            File pomFile = new File(args[1]);
            setDependencyVersion(pomFile, args[2], args[3]);
            break;
          }

        case "set-prop-version":
          {
            if (args.length < 4) {
              System.err.println(
                  "Usage: java PomTool.java set-prop-version <pom.xml> <propertyName>"
                      + " <newVersion>");
              System.exit(1);
            }
            File pomFile = new File(args[1]);
            setPropertyVersion(pomFile, args[2], args[3]);
            break;
          }

        case "find-versioned-dep":
          {
            String artifactId = args[1];
            File rootDir = args.length > 2 ? new File(args[2]) : new File(".");
            findPomsWithVersionedDependency(rootDir, artifactId);
            break;
          }

        case "has-versioned-dep":
          {
            if (args.length < 3) {
              System.err.println(
                  "Usage: java PomTool.java has-versioned-dep <pom.xml> <artifactId>");
              System.exit(1);
            }
            File pomFile = new File(args[1]);
            boolean hasDep = hasVersionedDependency(pomFile, args[2]);
            System.exit(hasDep ? 0 : 1);
            break;
          }

        default:
          System.err.println("Unknown command: " + command + "\n");
          printUsage();
          System.exit(1);
      }
    } catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
      System.exit(1);
    }
  }

  /**
   * ErrorHandler that suppresses non-fatal SAX parser warnings/errors during batch scans (e.g. from
   * empty test POMs or temporary files created during test suites).
   */
  private static final class SilentErrorHandler implements ErrorHandler {
    @Override
    public void warning(SAXParseException exception) {}

    @Override
    public void error(SAXParseException exception) {}

    @Override
    public void fatalError(SAXParseException exception) {}
  }
}
