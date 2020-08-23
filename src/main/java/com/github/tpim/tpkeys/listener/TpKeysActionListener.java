package com.github.tpim.tpkeys.listener;

import com.github.tpim.tpkeys.action.TpEditorDeleteToWord;
import com.github.tpim.tpkeys.service.TpKeysService;
import com.intellij.find.actions.FindInPathAction;
import com.intellij.ide.actions.SearchEverywhereAction;
import com.intellij.ide.actions.ViewStructureAction;
import com.intellij.ide.actions.runAnything.RunAnythingAction;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.actionSystem.ex.AnActionListener;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actions.IncrementalFindAction;
import org.jetbrains.annotations.NotNull;

public class TpKeysActionListener implements AnActionListener {


    private final TpKeysService service;

    public TpKeysActionListener(){
        service = TpKeysService.getInstance();
    }

    @Override
    public void beforeActionPerformed(@NotNull AnAction action, @NotNull DataContext dataContext, @NotNull AnActionEvent event) {


        if (action.getClass().equals(SearchEverywhereAction.class) ||
                action.getClass().equals(RunAnythingAction.class) ||
                action.getClass().equals(IncrementalFindAction.class) ||
                action.getClass().equals(FindInPathAction.class) ||
                action.getClass().equals(ViewStructureAction.class) ||
                action.getClass().equals(TpEditorDeleteToWord.class) ||
                action.equals(IdeActions.ACTION_FILE_STRUCTURE_POPUP) ||
                action.equals(IdeActions.ACTION_FIND_IN_PATH)
        ) {
            final Editor editor = dataContext.getData(CommonDataKeys.EDITOR);
            service.activateInsertMode(editor);
        }
    }

    @Override
    public void beforeEditorTyping(char c, @NotNull DataContext dataContext) {
        System.out.println("type char:");
        System.out.println(c);
    }
}
