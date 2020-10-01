/*
 * Copyright (C) 2012 The Android Open Source Project
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


import androidx.collection.ArraySet;

import java.util.Locale;
import java.util.TreeMap;

/**
 * A class to help with handling different writing scripts.
 */
public class ScriptUtils {

    // Used for hardware keyboards
    public static final int SCRIPT_UNKNOWN = -1;

    public static final int SCRIPT_BENGALI = 2;
    public static final int SCRIPT_LATIN = 11;

    private static final TreeMap<String, Integer> mLanguageCodeToScriptCode;
    private final static ArraySet<String> NON_UPPERCASE_SCRIPTS = new ArraySet<>();


    static {
        mLanguageCodeToScriptCode = new TreeMap<>();
        mLanguageCodeToScriptCode.put("", SCRIPT_LATIN); // default
        mLanguageCodeToScriptCode.put("bn", SCRIPT_BENGALI);
    }


    public static boolean scriptSupportsUppercase(String language) {
        return !NON_UPPERCASE_SCRIPTS.contains(language);
    }

    /*
     * Returns whether the code point is a letter that makes sense for the specified
     * locale for this spell checker.
     * The dictionaries supported by Latin IME are described in res/xml/spellchecker.xml
     * and is limited to EFIGS languages and Russian.
     * Hence at the moment this explicitly tests for Cyrillic characters or Latin characters
     * as appropriate, and explicitly excludes CJK, Arabic and Hebrew characters.
     */
    public static boolean isLetterPartOfScript(final int codePoint, final int scriptId) {
        switch (scriptId) {
            case SCRIPT_BENGALI:
                // Bengali unicode block is U+0980..U+09FF
                return (codePoint >= 0x980 && codePoint <= 0x9FF);
            case SCRIPT_LATIN:
                // Our supported latin script dictionaries (EFIGS) at the moment only include
                // characters in the C0, C1, Latin Extended A and B, IPA extensions unicode
                // blocks. As it happens, those are back-to-back in the code range 0x40 to 0x2AF,
                // so the below is a very efficient way to test for it. As for the 0-0x3F, it's
                // excluded from isLetter anyway.
                return codePoint <= 0x2AF && Character.isLetter(codePoint);
            case SCRIPT_UNKNOWN:
                return true;
            default:
                // Should never come here
                throw new RuntimeException("Impossible value of script: " + scriptId);
        }
    }

    /**
     * @param locale spell checker locale
     * @return internal Latin IME script code that maps to a language code
     * {@see http://en.wikipedia.org/wiki/List_of_ISO_639-1_codes}
     */
    public static int getScriptFromSpellCheckerLocale(final Locale locale) {
        String language = locale.getLanguage();
        Integer script = mLanguageCodeToScriptCode.get(language);
        if (script == null) {
            // Default to Latin.
            script = mLanguageCodeToScriptCode.get("");
        }
        return script;
    }
}
