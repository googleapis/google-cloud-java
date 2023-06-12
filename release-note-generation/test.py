import unittest

import split_release_note
from pathlib import Path
from datetime import date

dummy_module = split_release_note.LibraryModule(Path('release-note-generation/test/java-analyics-admin'),
                              'foo-api', '1.2.3',
                                                Path('release-note-generation/test/java-analyics-admin/CHANGELOG.md'))

class TestCase(unittest.TestCase):

    def test_something(self):
        split_release_note.current_date = date(2023, 6, 10)
        # do something
        entry = split_release_note.create_changelog_entry(
            dummy_module,
            ['Add support for disabling Pod overprovisioning',
             'Enhanced query generation performance']
        )
        self.assertEqual(entry, f'''## 1.2.3 (2023-06-10)

### Features

* Add support for disabling Pod overprovisioning
* Enhanced query generation performance
''')

if __name__ == "__main__":
    unittest.main()