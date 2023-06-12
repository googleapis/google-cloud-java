import unittest

# Unit tests for split_release_note.py

from split_release_note import LibraryModule, create_changelog_entry, group_changes_by_api
import split_release_note as srn
from pathlib import Path
from datetime import date

dummy_module = LibraryModule(
    Path('release-note-generation/test/java-analyics-admin'),
    'foo-api', '1.2.3',
    Path('release-note-generation/test/java-analyics-admin/CHANGELOG.md'))


class TestCase(unittest.TestCase):

    def test_create_changelog_entry(self):
        srn.current_date = date(2023, 6, 10)
        # do something
        entry = create_changelog_entry(
            dummy_module,
            ['Add support for disabling Pod overprovisioning',
             'Enhanced query generation performance']
        )
        self.assertEqual(entry, f'''## 1.2.3 (2023-06-10)

### Features

* Add support for disabling Pod overprovisioning
* Enhanced query generation performance
''')


    def test_group_changes_by_api(self):
        main_changes = [
            '# Features',
            '* [foo-api] This is Change A',
            '* [bar-api] This is Change B'
        ]
        changes_by_api = group_changes_by_api(main_changes)
        self.assertEqual(set(changes_by_api.keys()),
                         {'foo-api', 'bar-api'})
        self.assertEqual(changes_by_api['bar-api'],
                         ['This is Change B'])
        self.assertEqual(changes_by_api.get('nonexistent',
                                     ['No change']),
                         ['No change'])


if __name__ == "__main__":
    unittest.main()
