// Copyright 2024 Google LLC
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

// Package main implements pomtool, a lightweight, zero-dependency CLI tool for
// inspecting and modifying Maven pom.xml files in CI and Kokoro build scripts.
//
// Why this exists:
// CI workflows historically depended on `xmllint` (via `apt-get install libxml2-utils`).
// On GitHub Actions Ubuntu 24.04 (noble) runners, apt mirror network hangs frequently caused
// 5+ minute timeouts during step execution. Additionally, `xmllint --shell` commands are
// fragile, difficult to read, and have edge cases around XML namespaces.
//
// Design decisions:
//  1. Zero external dependencies: Uses only Go standard library packages (encoding/xml, regexp, os, etc.).
//     Go is pre-installed on GitHub Actions runners, so `go run pomtool.go` executes with 0s overhead
//     and requires no apt package installation.
//  2. Preserves exact formatting and comments: Modifying POMs via standard XML unmarshal -> marshal
//     destroys XML comments, changes whitespace/indentation, and reorders XML elements. To prevent this,
//     pomtool uses targeted streaming XML decoding for element location combined with scoped regex
//     replacement to edit POMs in-place while keeping indentation, whitespace, and comments intact.
package main

import (
	"bytes"
	"encoding/xml"
	"fmt"
	"io"
	"os"
	"regexp"
	"strings"
)

// GetProjectVersion extracts the top-level <project><version> from a Maven POM file.
// It uses a streaming xml.Decoder to locate the direct child <version> of <project> (depth 2),
// ignoring versions nested inside <parent>, <dependencies>, or <build>.
func GetProjectVersion(pomPath string) (string, error) {
	data, err := os.ReadFile(pomPath)
	if err != nil {
		return "", fmt.Errorf("reading POM file %s: %w", pomPath, err)
	}

	decoder := xml.NewDecoder(bytes.NewReader(data))
	var depth int
	var inProject bool

	for {
		tok, err := decoder.Token()
		if err == io.EOF {
			break
		}
		if err != nil {
			return "", fmt.Errorf("parsing XML in %s: %w", pomPath, err)
		}

		switch t := tok.(type) {
		case xml.StartElement:
			depth++
			if depth == 1 && t.Name.Local == "project" {
				inProject = true
			}
			// Top-level version is a direct child of <project> at depth 2
			if inProject && depth == 2 && t.Name.Local == "version" {
				var v string
				if err := decoder.DecodeElement(&v, &t); err != nil {
					return "", fmt.Errorf("decoding version element: %w", err)
				}
				depth-- // DecodeElement consumes the matching EndElement
				return strings.TrimSpace(v), nil
			}
		case xml.EndElement:
			depth--
			if depth == 0 {
				inProject = false
			}
		}
	}

	return "", fmt.Errorf("top-level <version> not found in %s", pomPath)
}

// SetProjectVersion updates the top-level <project><version> in-place within the POM file.
// It first detects the existing version using streaming XML parsing, and then performs a
// targeted string replacement of the top-level <version> tag, preserving all comments and formatting.
func SetProjectVersion(pomPath, newVersion string) error {
	data, err := os.ReadFile(pomPath)
	if err != nil {
		return fmt.Errorf("reading POM file %s: %w", pomPath, err)
	}

	// 1. Locate the existing top-level version value
	decoder := xml.NewDecoder(bytes.NewReader(data))
	var depth int
	var inProject bool
	var versionFound bool
	var oldVersion string

	for {
		tok, err := decoder.Token()
		if err == io.EOF {
			break
		}
		if err != nil {
			return fmt.Errorf("parsing XML in %s: %w", pomPath, err)
		}

		switch t := tok.(type) {
		case xml.StartElement:
			depth++
			if depth == 1 && t.Name.Local == "project" {
				inProject = true
			}
			if inProject && depth == 2 && t.Name.Local == "version" {
				if err := decoder.DecodeElement(&oldVersion, &t); err != nil {
					return fmt.Errorf("decoding version element: %w", err)
				}
				depth--
				versionFound = true
				break
			}
		case xml.EndElement:
			depth--
			if depth == 0 {
				inProject = false
			}
		}
		if versionFound {
			break
		}
	}

	if !versionFound {
		return fmt.Errorf("top-level <version> element not found in %s", pomPath)
	}

	// 2. Perform targeted replacement of the first matching top-level version tag
	re := regexp.MustCompile(`(<version\s*>)(.*?)(</version>)`)
	matched := false
	replaced := re.ReplaceAllFunc(data, func(match []byte) []byte {
		if matched {
			return match
		}
		sub := re.FindSubmatch(match)
		if len(sub) == 4 && string(sub[2]) == oldVersion {
			matched = true
			return []byte(string(sub[1]) + newVersion + string(sub[3]))
		}
		return match
	})

	if !matched {
		return fmt.Errorf("failed to replace top-level version in file content of %s", pomPath)
	}

	return os.WriteFile(pomPath, replaced, 0644)
}

// SetDependencyVersion finds any <dependency> or <plugin> block containing <artifactId>targetArtifactID</artifactId>
// and updates its <version> tag in-place.
//
// This replaces commands like:
//
//	xmllint --shell pom.xml <<EOF
//	setns x=http://maven.apache.org/POM/4.0.0
//	cd .//x:artifactId[text()="google-cloud-shared-config"]
//	cd ../x:version
//	set 1.2.3
//	save pom.xml
//	EOF
func SetDependencyVersion(pomPath, targetArtifactID, newVersion string) error {
	content, err := os.ReadFile(pomPath)
	if err != nil {
		return fmt.Errorf("reading POM file %s: %w", pomPath, err)
	}

	// Regex to match individual <dependency>...</dependency> or <plugin>...</plugin> blocks
	blockRe := regexp.MustCompile(`(?s)(<(?:dependency|plugin)\b[^>]*>)(.*?)(</(?:dependency|plugin)>)`)
	artRe := regexp.MustCompile(`(?s)<artifactId\s*>(\s*` + regexp.QuoteMeta(targetArtifactID) + `\s*)</artifactId>`)
	verRe := regexp.MustCompile(`(?s)(<version\s*>)(.*?)(</version>)`)

	found := false
	modified := blockRe.ReplaceAllFunc(content, func(block []byte) []byte {
		if !artRe.Match(block) {
			return block
		}
		if verRe.Match(block) {
			found = true
			return verRe.ReplaceAll(block, []byte("${1}"+newVersion+"${3}"))
		}
		return block
	})

	if !found {
		return fmt.Errorf("dependency or plugin %q with an explicit <version> tag not found in %s", targetArtifactID, pomPath)
	}

	return os.WriteFile(pomPath, modified, 0644)
}

// SetPropertyVersion updates a property tag <propertyName>value</propertyName> inside the POM in-place.
//
// This replaces commands like:
//
//	xmllint --shell pom.xml <<EOF
//	setns x=http://maven.apache.org/POM/4.0.0
//	cd .//x:properties/x:google-cloud-shared-dependencies.version
//	set 1.2.3
//	save pom.xml
//	EOF
func SetPropertyVersion(pomPath, propertyName, newVersion string) error {
	content, err := os.ReadFile(pomPath)
	if err != nil {
		return fmt.Errorf("reading POM file %s: %w", pomPath, err)
	}

	propRe := regexp.MustCompile(`(?s)(<` + regexp.QuoteMeta(propertyName) + `\b[^>]*>)(.*?)(</` + regexp.QuoteMeta(propertyName) + `>)`)
	if !propRe.Match(content) {
		return fmt.Errorf("property tag <%s> not found in %s", propertyName, pomPath)
	}

	modified := propRe.ReplaceAll(content, []byte("${1}"+newVersion+"${3}"))
	return os.WriteFile(pomPath, modified, 0644)
}

// HasVersionedDependency checks if a POM file contains a <dependency> or <plugin> block for targetArtifactID
// that declares its own explicit <version> (as opposed to inheriting version from dependencyManagement or parent).
//
// Returns true if an explicit version tag exists, false otherwise.
//
// This replaces XPath queries like:
//
//	xmllint --xpath "//*[local-name()='artifactId' and text()='truth']/following-sibling::*[local-name()='version']" pom.xml
func HasVersionedDependency(pomPath, targetArtifactID string) bool {
	content, err := os.ReadFile(pomPath)
	if err != nil {
		return false
	}

	blockRe := regexp.MustCompile(`(?s)<(?:dependency|plugin)\b[^>]*>.*?</(?:dependency|plugin)>`)
	artRe := regexp.MustCompile(`(?s)<artifactId\s*>\s*` + regexp.QuoteMeta(targetArtifactID) + `\s*</artifactId>`)
	verRe := regexp.MustCompile(`(?s)<version\s*>.*?</version>`)

	for _, block := range blockRe.FindAll(content, -1) {
		if artRe.Match(block) && verRe.Match(block) {
			return true
		}
	}
	return false
}

func printUsage() {
	fmt.Fprintf(os.Stderr, `Usage: pomtool <command> [arguments...]

A lightweight tool for reading and updating Maven pom.xml files in CI scripts.

Commands:
  get-version <pom.xml>
      Print /project/version text

  set-version <pom.xml> <new-version>
      Update /project/version in-place

  set-dep-version <pom.xml> <artifactId> <new-version>
      Update <version> of dependency or plugin with artifactId in-place

  set-prop-version <pom.xml> <propertyName> <new-version>
      Update <properties><propertyName> in-place

  has-versioned-dep <pom.xml> <artifactId>
      Exit 0 if dependency has an explicit <version>, exit 1 otherwise
`)
}

func main() {
	if len(os.Args) < 2 {
		printUsage()
		os.Exit(1)
	}

	cmd := os.Args[1]

	switch cmd {
	case "get-version":
		if len(os.Args) < 3 {
			fmt.Fprintf(os.Stderr, "Usage: pomtool get-version <pom.xml>\n")
			os.Exit(1)
		}
		v, err := GetProjectVersion(os.Args[2])
		if err != nil {
			fmt.Fprintf(os.Stderr, "Error: %v\n", err)
			os.Exit(1)
		}
		fmt.Println(v)

	case "set-version":
		if len(os.Args) < 4 {
			fmt.Fprintf(os.Stderr, "Usage: pomtool set-version <pom.xml> <new-version>\n")
			os.Exit(1)
		}
		if err := SetProjectVersion(os.Args[2], os.Args[3]); err != nil {
			fmt.Fprintf(os.Stderr, "Error: %v\n", err)
			os.Exit(1)
		}

	case "set-dep-version":
		if len(os.Args) < 5 {
			fmt.Fprintf(os.Stderr, "Usage: pomtool set-dep-version <pom.xml> <artifactId> <new-version>\n")
			os.Exit(1)
		}
		if err := SetDependencyVersion(os.Args[2], os.Args[3], os.Args[4]); err != nil {
			fmt.Fprintf(os.Stderr, "Error: %v\n", err)
			os.Exit(1)
		}

	case "set-prop-version":
		if len(os.Args) < 5 {
			fmt.Fprintf(os.Stderr, "Usage: pomtool set-prop-version <pom.xml> <propertyName> <new-version>\n")
			os.Exit(1)
		}
		if err := SetPropertyVersion(os.Args[2], os.Args[3], os.Args[4]); err != nil {
			fmt.Fprintf(os.Stderr, "Error: %v\n", err)
			os.Exit(1)
		}

	case "has-versioned-dep":
		if len(os.Args) < 4 {
			fmt.Fprintf(os.Stderr, "Usage: pomtool has-versioned-dep <pom.xml> <artifactId>\n")
			os.Exit(1)
		}
		if HasVersionedDependency(os.Args[2], os.Args[3]) {
			os.Exit(0)
		}
		os.Exit(1)

	default:
		fmt.Fprintf(os.Stderr, "Unknown command: %s\n\n", cmd)
		printUsage()
		os.Exit(1)
	}
}
