/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.otobikb.inputmethod.latin.utils;

import io.github.otobikb.inputmethod.latin.about.AboutPreferences;
import io.github.otobikb.inputmethod.latin.settings.AdvancedSettingsFragment;
import io.github.otobikb.inputmethod.latin.settings.AppearanceSettingsFragment;
import io.github.otobikb.inputmethod.latin.settings.CorrectionSettingsFragment;
import io.github.otobikb.inputmethod.latin.settings.CustomInputStyleSettingsFragment;
import io.github.otobikb.inputmethod.latin.settings.DebugSettingsFragment;
import io.github.otobikb.inputmethod.latin.settings.GestureSettingsFragment;
import io.github.otobikb.inputmethod.latin.settings.PreferencesSettingsFragment;
import io.github.otobikb.inputmethod.latin.settings.SettingsFragment;
import io.github.otobikb.inputmethod.latin.settings.AboutFragment;
import io.github.otobikb.inputmethod.latin.settings.ThemeSettingsFragment;
import io.github.otobikb.inputmethod.latin.spellcheck.SpellCheckerSettingsFragment;
import io.github.otobikb.inputmethod.latin.userdictionary.UserDictionaryAddWordFragment;
import io.github.otobikb.inputmethod.latin.userdictionary.UserDictionaryList;
import io.github.otobikb.inputmethod.latin.userdictionary.UserDictionaryLocalePicker;
import io.github.otobikb.inputmethod.latin.userdictionary.UserDictionarySettings;

import java.util.HashSet;

public class FragmentUtils {
    private static final HashSet<String> sLatinImeFragments = new HashSet<>();
    static {
        sLatinImeFragments.add(AboutPreferences.class.getName());
        sLatinImeFragments.add(PreferencesSettingsFragment.class.getName());
        sLatinImeFragments.add(AppearanceSettingsFragment.class.getName());
        sLatinImeFragments.add(ThemeSettingsFragment.class.getName());
        sLatinImeFragments.add(CustomInputStyleSettingsFragment.class.getName());
        sLatinImeFragments.add(GestureSettingsFragment.class.getName());
        sLatinImeFragments.add(CorrectionSettingsFragment.class.getName());
        sLatinImeFragments.add(AdvancedSettingsFragment.class.getName());
        sLatinImeFragments.add(DebugSettingsFragment.class.getName());
        sLatinImeFragments.add(SettingsFragment.class.getName());
        sLatinImeFragments.add(AboutFragment.class.getName());
        sLatinImeFragments.add(SpellCheckerSettingsFragment.class.getName());
        sLatinImeFragments.add(UserDictionaryAddWordFragment.class.getName());
        sLatinImeFragments.add(UserDictionaryList.class.getName());
        sLatinImeFragments.add(UserDictionaryLocalePicker.class.getName());
        sLatinImeFragments.add(UserDictionarySettings.class.getName());
    }

    public static boolean isValidFragment(String fragmentName) {
        return sLatinImeFragments.contains(fragmentName);
    }
}
