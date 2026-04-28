import argparse
import re
import subprocess
import sys


def run_cmd(cmd, cwd=None):
    """Runs a shell command and returns the output."""
    result = subprocess.run(
        cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True, cwd=cwd
    )
    if result.returncode != 0:
        print(f"Error running command: {' '.join(cmd)}", file=sys.stderr)
        print(result.stderr, file=sys.stderr)
        sys.exit(result.returncode)
    return result.stdout


def find_version_boundaries(file_path, pattern, target_version, module=None):
    """Scans history of a file to find release boundaries moving forward."""
    log_cmd = [
        "git",
        "log",
        "--oneline",
        "--all",
        "--",
        file_path,
    ]
    try:
        log_output = run_cmd(log_cmd)
        commits = [line.split()[0] for line in log_output.splitlines() if line]
        commits.reverse()  # Move forward in time!
        
        first_prev_commit = None
        target_release_commit = None
        prev_version = None

        for commit in commits:
            # Check if file exists at that commit to avoid noisy errors
            check_cmd = ["git", "cat-file", "-e", f"{commit}:{file_path}"]
            check_result = subprocess.run(check_cmd, stderr=subprocess.PIPE)
            if check_result.returncode != 0:
                continue
                
            show_cmd = ["git", "show", f"{commit}:{file_path}"]
            try:
                content = run_cmd(show_cmd)
            except SystemExit:
                continue
                
            found_ver = None
            match = pattern.search(content)
            if match:
                found_ver = match.group(1)
                    
            if found_ver:
                if found_ver == target_version:
                    target_release_commit = commit
                    break  # Stop as soon as we find the target release!

                # Track the first occurrence of the latest stable version before target
                if found_ver != target_version and "-SNAPSHOT" not in found_ver and (not prev_version or found_ver != prev_version):
                    prev_version = found_ver
                    first_prev_commit = commit
            
        return first_prev_commit, target_release_commit, prev_version
    except SystemExit:
        return None, None, None


def verify_commit(commit_hash, directory, module, allowed_versions):
    """Verifies if a commit belongs to the release based on file state."""
    if directory == ".":
        pom_path = "gapic-libraries-bom/pom.xml"
    else:
        pom_path = f"{directory}/pom.xml"
        
    # Check if file exists at that commit to avoid noisy errors
    check_cmd = ["git", "cat-file", "-e", f"{commit_hash}:{pom_path}"]
    check_result = subprocess.run(check_cmd, stderr=subprocess.PIPE)
    if check_result.returncode != 0:
        return False
        
    try:
        content = run_cmd(["git", "show", f"{commit_hash}:{pom_path}"])
        # Allow optional <packaging> tag in between artifactId and version
        pattern = re.compile(rf"<artifactId>{re.escape(module)}</artifactId>\s*(?:<packaging>[^<]+</packaging>\s*)?<version>([^<]+)</version>", re.DOTALL)
        
        match = pattern.search(content)
        if match and match.group(1) in allowed_versions:
            return True
    except SystemExit:
        pass
        
    return False


def parse_commit_overrides(commit_data, short_name, prefix_regex, commit_hash, categorize_callback):
    """Parses commit overrides and calls callback for each item."""
    match = re.search(r"BEGIN_COMMIT_OVERRIDE(.*?)END_COMMIT_OVERRIDE", commit_data, re.DOTALL)
    if not match:
        return False
        
    override_content = match.group(1)
    current_item = []
    in_module_item = False

    for line in override_content.splitlines():
        line_stripped = line.strip()
        if not line_stripped:
            continue

        is_new_item = prefix_regex.match(line_stripped)

        if is_new_item:
            if in_module_item and current_item:
                categorize_callback(commit_hash, " ".join(current_item))
                current_item = []
                in_module_item = False

            should_include = False
            if short_name:
                if f"[{short_name}]" in line_stripped:
                    should_include = True
            else:
                should_include = True

            if should_include:
                in_module_item = True
                current_item.append(line_stripped)
        elif in_module_item:
            if line_stripped.startswith(("PiperOrigin-RevId:", "Source Link:")):
                continue
            if line_stripped in ("END_NESTED_COMMIT", "BEGIN_NESTED_COMMIT"):
                continue
            current_item.append(line_stripped)

    if in_module_item and current_item:
        categorize_callback(commit_hash, " ".join(current_item))
        
    return True


def get_tag_or_commit(commit_hash, target_version):
    """Returns the tag pointing at the commit if there is exactly one, else the commit hash."""
    if not commit_hash:
        return None
    try:
        # Remove ~1 if present to find the actual tag pointing at the commit
        clean_hash = commit_hash.split("~")[0]
        tags_output = run_cmd(["git", "tag", "--points-at", clean_hash])
        tags = [line.strip() for line in tags_output.splitlines() if line.strip()]
        if len(tags) == 1:
            return tags[0]
        elif len(tags) > 1:
            for tag in tags:
                if target_version in tag:
                    return tag
    except SystemExit:
        pass
    return commit_hash


def main():
    parser = argparse.ArgumentParser(
        description="Generate release notes based on commit history for a specific module."
    )
    parser.add_argument(
        "--module", required=True, help="Module name as specified in versions.txt"
    )
    parser.add_argument(
        "--directory", required=True, help="Path in the monorepo where the module has code"
    )
    parser.add_argument("--version", required=True, help="Target version")
    parser.add_argument(
        "--short-name", help="Module short-name used in commit overrides (e.g., aiplatform). Omit for repo-wide generation."
    )
    args = parser.parse_args()

    module = args.module
    directory = args.directory
    target_version = args.version

    # 1. Scan history of pom.xml
    if directory == ".":
        pom_path = "gapic-libraries-bom/pom.xml"
    else:
        pom_path = f"{directory}/pom.xml"
    pom_pattern = re.compile(r"<version>([^<]+)</version>")
    
    prev_commit, target_release_commit, prev_version = find_version_boundaries(pom_path, pom_pattern, target_version)
    
    target_commit = None
    if target_release_commit:
        target_commit = target_release_commit
        print(f"Found target release commit at {target_release_commit}. Using inclusive upper boundary {target_commit}", file=sys.stderr)
    
    if not target_commit:
        print(f"Target version {target_version} not found in history of {pom_path}.", file=sys.stderr)
        sys.exit(1)

    range_desc = f"between {prev_commit} and {target_commit}" if prev_commit else f"up to {target_commit}"
    print(
        f"Generating notes {range_desc} for directory {directory}", file=sys.stderr
    )

    # 2. Generate commit history in that range affecting that directory
    # Use format that includes hash, subject, and body
    notes_cmd = [
        "git",
        "log",
        "--format=%H %s%n%b%n--END_OF_COMMIT--",
        f"{prev_commit}~1..{target_commit}" if prev_commit else target_commit,
    ]
    if directory != ".":
        notes_cmd.extend(["--", directory])
    notes_output = run_cmd(notes_cmd)



    # Filter commit titles based on allowed prefixes and categorize them
    # Supports scopes in parentheses, e.g., feat(spanner):
    prefix_regex = re.compile(r"^(feat|fix|deps|docs|chore\(deps\)|build\(deps\))(\([^)]+\))?(!)?:")
    
    breaking_changes = []
    features = []
    bug_fixes = []
    dependency_upgrades = []
    documentation = []

    def categorize_and_append(commit_hash, text):
        match = prefix_regex.match(text)
        if not match:
            return
            
        prefix = match.group(1)
        is_breaking = match.group(3) == "!"
        
        commit_link = f"([{commit_hash[:7]}](https://github.com/googleapis/google-cloud-java/commit/{commit_hash}))"
        full_item = f"{text} {commit_link}"
        
        if is_breaking:
            breaking_changes.append(full_item)
        elif prefix == "feat":
            features.append(full_item)
        elif prefix == "fix":
            bug_fixes.append(full_item)
        elif prefix == "deps" or prefix in ("chore(deps)", "build(deps)"):
            dependency_upgrades.append(full_item)
        elif prefix == "docs":
            documentation.append(full_item)

    commits_data = notes_output.split("--END_OF_COMMIT--")
    
    for commit_data in commits_data:
        commit_data = commit_data.strip()
        if not commit_data:
            continue
            
        lines = commit_data.splitlines()
        if not lines:
            continue
            
        header_parts = lines[0].split(" ", 1)
        commit_hash = header_parts[0]
        subject = header_parts[1] if len(header_parts) > 1 else ""
        
        body = "\n".join(lines[1:])
        
        # Verify if commit belongs to this release based on file state
        target_snapshot = f"{target_version}-SNAPSHOT"
        allowed_versions = (prev_version, target_snapshot) if prev_version else (target_snapshot,)
        
        target_module = "gapic-libraries-bom" if directory == "." else module
        if not verify_commit(commit_hash, directory, target_module, allowed_versions):
            continue
        
        # Check for override in the entire message
        if "BEGIN_COMMIT_OVERRIDE" in body or "BEGIN_COMMIT_OVERRIDE" in subject:
            if parse_commit_overrides(commit_data, args.short_name, prefix_regex, commit_hash, categorize_and_append):
                continue
            
        # Fallback to title check if no override
        if prefix_regex.match(subject):
            categorize_and_append(commit_hash, subject)

    # Get dates and build header
    target_date = run_cmd(["git", "log", "-1", "--format=%cI", target_commit]).strip()
    date_str = target_date.split("T")[0]  # Get YYYY-MM-DD
    
    prev_ref = get_tag_or_commit(prev_commit, prev_version) if prev_version else prev_commit
    target_ref = get_tag_or_commit(target_commit, target_version)
    
    compare_url = f"https://github.com/googleapis/google-cloud-java/compare/{prev_ref}...{target_ref}" if prev_ref else f"https://github.com/googleapis/google-cloud-java/commit/{target_ref}"
    
    print(f"## [{target_version}]({compare_url}) ({date_str})")
    print()

    if not any([breaking_changes, features, bug_fixes, dependency_upgrades, documentation]):
        print("* No change")
    else:
        if breaking_changes:
            print("### ⚠ BREAKING CHANGES\n")
            for item in breaking_changes:
                print(f"* {item}")
            print()

        if features:
            print("### Features\n")
            for item in features:
                print(f"* {item}")
            print()

        if bug_fixes:
            print("### Bug Fixes\n")
            for item in bug_fixes:
                print(f"* {item}")
            print()

        if documentation:
            print("### Documentation\n")
            for item in documentation:
                print(f"* {item}")
            print()

        if dependency_upgrades:
            print("### Dependencies\n")
            for item in dependency_upgrades:
                print(f"* {item}")
            print()



if __name__ == "__main__":
    main()
