package com.github.tpim.tpkeys.action;

import com.github.tpim.tpkeys.service.TpKeysService;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;

public class TpKeysInsertMode extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        Editor editor = e.getData(CommonDataKeys.EDITOR);
        if(editor == null)
        {
            return;
        }


        TpKeysService.getInstance().activateInsertMode(editor);
    }
}
