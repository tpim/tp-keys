package com.github.tpim.tpkeys.action;

import com.intellij.openapi.actionSystem.*;

public class TpInsertNextLine extends AnAction {

    final private ActionManager  actionManager = ActionManager.getInstance();

    @Override
    public void actionPerformed(AnActionEvent e) {

        actionManager.getAction("ErgoKeysEndOfLineOrParagraphAction").actionPerformed(e);
        actionManager.getAction(IdeActions.ACTION_EDITOR_ENTER).actionPerformed(e);
    }
}
