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

// Package main implements check_existing_release_versions, a tool that verifies
// Maven release artifacts are not already published to Maven Central before
// merging Release Please pull requests.
package main

import (
	"encoding/xml"
	"fmt"
	"io"
	"net/http"
	"os"
	"path/filepath"
	"sort"
	"strings"
	"sync"
	"sync/atomic"
	"time"
)

const (
	// defaultMavenSite is the Google Cloud Storage Maven Central mirror used for fast artifact checks.
	defaultMavenSite = "https://maven-central.storage-download.googleapis.com/maven2"

	// defaultWorkerCount is the number of concurrent HTTP workers checking Maven Central.
	defaultWorkerCount = 20

	// maxPomSearchDepth limits the directory traversal depth when searching for releasable pom.xml files.
	maxPomSearchDepth = 3

	// httpTimeout is the per-request timeout for checking Maven Central.
	httpTimeout = 10 * time.Second

	// httpIdleConnTimeout is the keep-alive timeout for pooled HTTP connections.
	httpIdleConnTimeout = 90 * time.Second
)

// PomProject represents the Maven coordinates (<groupId>, <artifactId>, <version>)
// parsed from a pom.xml file.
type PomProject struct {
	XMLName    xml.Name `xml:"project"`
	GroupID    string   `xml:"groupId"`
	ArtifactID string   `xml:"artifactId"`
	Version    string   `xml:"version"`
}

// PomCheckTask represents a single POM check task for a worker goroutine.
type PomCheckTask struct {
	Index   int
	PomFile string
	Project *PomProject
}

// PomCheckResult captures the output and error status of a completed POM check.
type PomCheckResult struct {
	Index   int
	Output  string
	IsError bool
}

// shouldSkipPom implements filtering rules matching the original release check script.
// It skips sample directories, showcase modules, coverage reports, test proxies, and other
// non-releasable artifacts.
func shouldSkipPom(path string) bool {
	norm := filepath.ToSlash(path)
	if strings.Contains(norm, "samples") ||
		strings.Contains(norm, "showcase") ||
		strings.Contains(norm, "coverage-report") ||
		strings.HasSuffix(norm, "sdk-platform-java/pom.xml") ||
		strings.Contains(norm, "java-vertexai") ||
		strings.Contains(norm, "storage-shared-benchmarking") ||
		strings.Contains(norm, "java-bigtable/test-proxy") {
		return true
	}
	// Exclude aggregator java-shared-config/pom.xml but NOT child modules (e.g. java-shared-config/java-shared-config/pom.xml)
	if norm == "java-shared-config/pom.xml" || norm == "./java-shared-config/pom.xml" {
		return true
	}
	return false
}

// parsePomCoordinates reads a pom.xml file and extracts top-level GroupID, ArtifactID, and Version.
func parsePomCoordinates(path string) (*PomProject, error) {
	data, err := os.ReadFile(path)
	if err != nil {
		return nil, fmt.Errorf("reading %s: %w", path, err)
	}
	var proj PomProject
	if err := xml.Unmarshal(data, &proj); err != nil {
		return nil, fmt.Errorf("unmarshaling XML from %s: %w", path, err)
	}
	proj.GroupID = strings.TrimSpace(proj.GroupID)
	proj.ArtifactID = strings.TrimSpace(proj.ArtifactID)
	proj.Version = strings.TrimSpace(proj.Version)
	return &proj, nil
}

// pathDepth returns the directory nesting depth of a relative path.
func pathDepth(relPath string) int {
	clean := filepath.ToSlash(filepath.Clean(relPath))
	if clean == "." || clean == "" {
		return 0
	}
	return len(strings.Split(clean, "/"))
}

// findPomFiles walks the directory tree up to maxPomSearchDepth to find releasable pom.xml files.
func findPomFiles(rootDir string) ([]string, error) {
	var pomFiles []string
	err := filepath.Walk(rootDir, func(path string, info os.FileInfo, err error) error {
		if err != nil {
			return err
		}
		rel, err := filepath.Rel(rootDir, path)
		if err != nil {
			return err
		}
		if info.IsDir() {
			if pathDepth(rel) > maxPomSearchDepth {
				return filepath.SkipDir
			}
			return nil
		}
		if info.Name() == "pom.xml" {
			relPath := "./" + filepath.ToSlash(rel)
			if pathDepth(rel) <= maxPomSearchDepth && !shouldSkipPom(relPath) {
				pomFiles = append(pomFiles, relPath)
			}
		}
		return nil
	})
	if err != nil {
		return nil, err
	}
	sort.Strings(pomFiles)
	return pomFiles, nil
}

// buildMavenURL constructs the Maven repository URL for a given POM coordinate.
func buildMavenURL(mavenSite, groupID, artifactID, version string) string {
	groupIDPath := strings.ReplaceAll(groupID, ".", "/")
	return fmt.Sprintf("%s/%s/%s/%s/%s-%s.pom", mavenSite, groupIDPath, artifactID, version, artifactID, version)
}

// checkArtifactPublished performs an HTTP HEAD request to determine if an artifact is published.
func checkArtifactPublished(client *http.Client, url string) (exists bool, statusCode int, err error) {
	req, err := http.NewRequest(http.MethodHead, url, nil)
	if err != nil {
		return false, 0, fmt.Errorf("building request: %w", err)
	}

	resp, err := client.Do(req)
	if err != nil {
		return false, 0, fmt.Errorf("performing request: %w", err)
	}
	defer resp.Body.Close()
	io.Copy(io.Discard, resp.Body)

	return resp.StatusCode == http.StatusOK, resp.StatusCode, nil
}

// checkSinglePom verifies a single POM task: checking for SNAPSHOT versions and querying Maven Central.
func checkSinglePom(client *http.Client, mavenSite string, task PomCheckTask) PomCheckResult {
	proj := task.Project

	// If groupId or version is empty, the POM inherits coordinates from its parent.
	// In Maven, such child modules are released with their parent POM.
	if proj.GroupID == "" || proj.Version == "" {
		out := fmt.Sprintf("Checking %s:%s:%s:Skipping file without explicit coordinates (likely inherits): %s\n",
			proj.GroupID, proj.ArtifactID, proj.Version, task.PomFile)
		return PomCheckResult{Index: task.Index, Output: out, IsError: false}
	}

	var sb strings.Builder
	sb.WriteString(fmt.Sprintf("Checking %s:%s:%s:", proj.GroupID, proj.ArtifactID, proj.Version))
	isErr := false

	// Check for unexpected SNAPSHOT versions on release branches
	if strings.Contains(proj.Version, "SNAPSHOT") && proj.ArtifactID != "google-cloud-java" {
		sb.WriteString(" Release Please pull request contains SNAPSHOT version. Please investigate.\n")
		isErr = true
	}

	url := buildMavenURL(mavenSite, proj.GroupID, proj.ArtifactID, proj.Version)
	exists, statusCode, err := checkArtifactPublished(client, url)
	if err != nil {
		sb.WriteString(fmt.Sprintf(" Error checking %s: %v\n", url, err))
		return PomCheckResult{Index: task.Index, Output: sb.String(), IsError: true}
	}

	if exists {
		sb.WriteString(fmt.Sprintf(" The version already exists at %s. Please investigate.\n", url))
		isErr = true
	} else {
		sb.WriteString(fmt.Sprintf(" The version does not exists (status_code %d for %s). Good.\n", statusCode, url))
	}

	return PomCheckResult{Index: task.Index, Output: sb.String(), IsError: isErr}
}

// buildTasks parses all POM files into individual check tasks.
func buildTasks(pomFiles []string) ([]PomCheckTask, error) {
	var tasks []PomCheckTask
	for i, pomFile := range pomFiles {
		proj, err := parsePomCoordinates(pomFile)
		if err != nil {
			return nil, fmt.Errorf("couldn't parse pom file %s: %w", pomFile, err)
		}
		if proj.ArtifactID == "" {
			return nil, fmt.Errorf("couldn't parse artifact_id in the pom file: %s", pomFile)
		}
		tasks = append(tasks, PomCheckTask{
			Index:   i,
			PomFile: pomFile,
			Project: proj,
		})
	}
	return tasks, nil
}

// runWorkerPool runs checkSinglePom concurrently across tasks using worker goroutines.
func runWorkerPool(tasks []PomCheckTask, numWorkers int, workerFn func(PomCheckTask) PomCheckResult) []PomCheckResult {
	if len(tasks) == 0 {
		return nil
	}
	if numWorkers > len(tasks) {
		numWorkers = len(tasks)
	}

	taskCh := make(chan PomCheckTask, len(tasks))
	resultCh := make(chan PomCheckResult, len(tasks))

	var wg sync.WaitGroup
	for w := 0; w < numWorkers; w++ {
		wg.Add(1)
		go func() {
			defer wg.Done()
			for task := range taskCh {
				resultCh <- workerFn(task)
			}
		}()
	}

	for _, task := range tasks {
		taskCh <- task
	}
	close(taskCh)

	go func() {
		wg.Wait()
		close(resultCh)
	}()

	// Collect results into an indexed slice to preserve deterministic logging order
	results := make([]PomCheckResult, len(tasks))
	for res := range resultCh {
		results[res.Index] = res
	}

	return results
}

// runChecks validates a list of POM files against Maven Central and aggregates the output.
func runChecks(pomFiles []string, mavenSite string, client *http.Client) (bool, string) {
	tasks, err := buildTasks(pomFiles)
	if err != nil {
		return true, fmt.Sprintf("%v\n", err)
	}

	results := runWorkerPool(tasks, defaultWorkerCount, func(task PomCheckTask) PomCheckResult {
		return checkSinglePom(client, mavenSite, task)
	})

	var hasError atomic.Bool
	var allOutput strings.Builder
	for _, res := range results {
		if res.IsError {
			hasError.Store(true)
		}
		allOutput.WriteString(res.Output)
	}

	return hasError.Load(), allOutput.String()
}

func main() {
	mavenSite := os.Getenv("MAVEN_SITE")
	if mavenSite == "" {
		mavenSite = defaultMavenSite
	}

	client := &http.Client{
		Transport: &http.Transport{
			MaxIdleConns:        100,
			MaxIdleConnsPerHost: 100,
			IdleConnTimeout:     httpIdleConnTimeout,
		},
		Timeout: httpTimeout,
	}

	pomFiles, err := findPomFiles(".")
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error finding pom files: %v\n", err)
		os.Exit(1)
	}

	hasError, output := runChecks(pomFiles, mavenSite, client)
	fmt.Print(output)

	if hasError {
		os.Exit(1)
	}
}
