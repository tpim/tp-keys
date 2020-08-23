package com.github.tpim.tpkeys.action;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.IdeActions;
import com.intellij.openapi.application.ApplicationManager;

public class TpKeysPasteNextLineAction extends AnAction {

    private final ActionManager actionManager = ActionManager.getInstance();

    @Override
    public void actionPerformed(AnActionEvent e) {


        actionManager.getAction("TpInsertNextLine").actionPerformed(e);
        actionManager.getAction(IdeActions.ACTION_PASTE).actionPerformed(e);
        return;

    }
}
