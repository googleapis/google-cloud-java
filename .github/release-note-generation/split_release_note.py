# Script to split a main release note into CHANGELOG.md in each module.

# 1st argument: the path to a file that contains the main changelog. You can get
#     the body of a pull request via `gh pr view
#     https://github.com/googleapis/google-cloud-java/pull/9502 --json body
#     --jq '.body'`
# 2nd argument: the path to a directory that whose child directories contain
#     ".Owlbot-hermetic.yaml", "pom.xml", and "CHANGELOG.md". It's the root directory
#     of the google-cloud-java repository.
# Example:
#   google-cloud-java$ python3 split_release_note.py main_changelog.txt .
# where the last "." indicates the root of the repository copy.

import sys
import re
from collections import defaultdict
from pathlib import Path
import json
import xml.etree.ElementTree as ET
from dataclasses import dataclass, field


class LibraryModule:
    """A module that represents one of the top-level library folders in
    the google-cloud-java repository"""
    def __init__(self, path: Path, api_name: str, version: str,
        changelog: Path):
        self.path = path
        self.api_name = api_name
        self.version = version
        self.changelog = changelog

    def __str__(self):
        return f"LibraryModule({self.path}, {self.api_name}, {self.version}, {self.changelog})"

    def __repr__(self):
        return f"LibraryModule({self.path}, {self.api_name}, {self.version}, {self.changelog})"


@dataclass
class ChangesOnApi:
    """Per-module changes, categorized as breaking changes, features, bug fixes,
    and dependency upgrades"""
    breaking_changes: [str] = field(default_factory=list)
    features: [str] = field(default_factory=list)
    bug_fixes: [str] = field(default_factory=list)
    dependency_upgrades: [str] = field(default_factory=list)

    def __len__(self):
        return len(self.breaking_changes) + len(self.features) \
            + len(self.bug_fixes) + len(self.dependency_upgrades)


POM_NAMESPACES = {'mvn': 'http://maven.apache.org/POM/4.0.0'}


# Returns the list of target modules that has CHANGELOG.md
def detect_modules(root_directory: Path):
    modules = []
    for repo_metadata_path in root_directory.glob('*/.repo-metadata.json'):
        # This CHANGELOG.md might not exist for newly created libraries
        changelog = repo_metadata_path.parent / 'CHANGELOG.md'

        module_path = repo_metadata_path.parent
        module_pom_xml = module_path / 'pom.xml'
        owlbot_yaml_path = module_path/ '.OwlBot-hermetic.yaml'
        if not module_pom_xml.exists():
            continue
        tree = ET.parse(module_pom_xml)
        root = tree.getroot()
        version = root.find('mvn:version', POM_NAMESPACES).text
        if owlbot_yaml_path.exists():
            # If OwlBot configuration file exists (most cases), it's the better
            # source to get the OwlBot-generated pull request title prefix than
            # the repo-metadata.json
            with open(owlbot_yaml_path, 'r') as file:
                owlbot_yaml_content = file.read()
                match = re.search(r'api-name: (.+)', owlbot_yaml_content)
                if match:
                    api_name = match.group(1)
                    modules.append(LibraryModule(module_path, api_name,
                                                 version,
                                                 changelog))
        else:
            # vertexai (handwritten) does not have OwlBot yaml file
            with open(repo_metadata_path, 'r') as file:
                repo_metadata = json.load(file)
                api_name = repo_metadata['api_shortname']
                if api_name:
                    modules.append(LibraryModule(repo_metadata_path.parent, api_name,
                                                 version,
                                                 changelog))
                else:
                    raise Exception(f'repo_metadata_path {repo_metadata_path} does'
                                    f' not have api_shortname field')

    return modules


CHANGELOG_HEADER_MARK = '# Changelog'
BREAKING_CHANGE_SECTION = '⚠ BREAKING CHANGES'
FEATURES_SECTION = 'Features'
BUG_FIXES_SECTION = 'Bug Fixes'
DEPENDENCIES_SECTION = 'Dependencies'


# Returns the dictionary from api name to ChangesOnApi
def group_changes_by_api(main_changes: [str]):
    api_to_changelog = defaultdict(ChangesOnApi)
    section = None
    for changelog in main_changes:
        if changelog.endswith(BREAKING_CHANGE_SECTION):
            section = BREAKING_CHANGE_SECTION
            continue
        if changelog.endswith(FEATURES_SECTION):
            section = FEATURES_SECTION
            continue
        if changelog.endswith(BUG_FIXES_SECTION):
            section = BUG_FIXES_SECTION
            continue
        if changelog.endswith(DEPENDENCIES_SECTION):
            section = DEPENDENCIES_SECTION
            continue

        match = re.search(r'\* \[(.+?)] (.+)', changelog)
        if match:
            api_name = match.group(1)
            note = match.group(2)
            if section == BREAKING_CHANGE_SECTION:
                api_to_changelog[api_name].breaking_changes.append(note)
            elif section == FEATURES_SECTION:
                api_to_changelog[api_name].features.append(note)
            elif section == BUG_FIXES_SECTION:
                api_to_changelog[api_name].bug_fixes.append(note)
            elif section == DEPENDENCIES_SECTION:
                api_to_changelog[api_name].dependencies.append(note)
    return api_to_changelog


def find_repo_wide_dependency_changes(main_changes: [str]):
    repo_wide_changes = []
    for changelog in main_changes:
        match = re.search(r'\* (.+com\.google\.cloud:google-cloud-shared.+)',
                          changelog)
        if match:
            note = match.group(1)
            repo_wide_changes.append(note)
    return repo_wide_changes


def create_changelog_entry(current_date: str, module: LibraryModule,
                           changes: ChangesOnApi):
    changelog_entry = f'## {module.version} ({current_date})\n\n'
    if changes.breaking_changes:
        changelog_entry += f'### {BREAKING_CHANGE_SECTION}\n\n'
        for line in changes.breaking_changes:
            changelog_entry += f'* {line}\n'
        changelog_entry += '\n'
    if changes.features:
        changelog_entry += f'### {FEATURES_SECTION}\n\n'
        for line in changes.features:
            changelog_entry += f'* {line}\n'
        changelog_entry += '\n'
    if changes.bug_fixes:
        changelog_entry += f'### {BUG_FIXES_SECTION}\n\n'
        for line in changes.bug_fixes:
            changelog_entry += f'* {line}\n'
        changelog_entry += '\n'
    if changes.dependency_upgrades:
        changelog_entry += f"### {DEPENDENCIES_SECTION}\n\n"
        for line in changes.dependency_upgrades:
            changelog_entry += f'* {line}\n'

    if len(changes) == 0:
        changelog_entry += '* No change\n'
    return changelog_entry


def write_changelog(current_date: str, module: LibraryModule,
                    changelog_entries: [str]):
    changelog_file = module.changelog
    if changelog_file.exists():
        with open(changelog_file, 'r') as file:
            changelog_content = file.read()
    else:
        changelog_content = CHANGELOG_HEADER_MARK

    # Avoid adding the same version twice
    if re.search(f'## {module.version}', changelog_content):
        return

    entry = create_changelog_entry(current_date, module, changelog_entries)
    replaced = changelog_content.replace(CHANGELOG_HEADER_MARK,
                                         f'{CHANGELOG_HEADER_MARK}'
                                         f'\n\n{entry}')
    with open(module.changelog, 'w') as file:
        file.write(replaced)


def main():
    if len(sys.argv) != 3:
        print("Please specify main changelog file and path to the repository "
              "root")
        sys.exit(1)

    # Step 1: Reads the main changelog from the argument
    main_changes = []
    main_release_note_file = sys.argv[1]
    with open(main_release_note_file, 'r') as file:
        for line in file:
            main_changes.append(line.strip())

    release_date = None
    for line in main_changes:
        match = re.search(r'## .* \((\d\d\d\d-\d\d-\d\d)\)', line)
        if match:
            release_date = match.group(1)
            break


    # Step 2: Detects target modules by .Owlbot-hermetic.yaml for
    # the "api-name:" field.
    root_directory = sys.argv[2]
    modules = detect_modules(Path(root_directory))
    api_to_modules = {module.api_name: module for module in modules}

    # Step 3: Splits the changelog to ~100 modules
    api_to_changelog_entries = group_changes_by_api(main_changes)
    global_dependency_change_entries = find_repo_wide_dependency_changes(main_changes)

    # Step 4: Writes the changelog entry to the CHANGELOG.md files in the
    # modules. The global dependency changes appear in each module.
    for module in modules:
        changes = api_to_changelog_entries.get(module.api_name,
                                               ChangesOnApi())
        if global_dependency_change_entries:
            changes.dependency_upgrades.extend(global_dependency_change_entries)
        write_changelog(release_date, module, changes)


if __name__ == '__main__':
    main()
