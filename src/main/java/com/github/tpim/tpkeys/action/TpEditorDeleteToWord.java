/*
 * Copyright 2018 Ami E. Bizamcher. All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */

package com.github.tpim.tpkeys.action;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.DumbAwareAction;
import com.intellij.openapi.util.TextRange;

public class TpEditorDeleteToWord extends DumbAwareAction {
    final private ActionManager actionManager = ActionManager.getInstance();

    @Override
    public void actionPerformed(AnActionEvent e) {

        actionManager.getAction(IdeActions.ACTION_EDITOR_DELETE_TO_WORD_START).actionPerformed(e);
        actionManager.getAction(IdeActions.ACTION_EDITOR_DELETE_TO_WORD_END).actionPerformed(e);
        return;
    }
}
