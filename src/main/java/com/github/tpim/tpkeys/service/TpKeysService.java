package com.github.tpim.tpkeys.service;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.keymap.Keymap;
import com.intellij.openapi.keymap.KeymapManager;
import com.intellij.openapi.keymap.ex.KeymapManagerEx;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.wm.WindowManager;
import org.apache.batik.svggen.font.table.GsubTable;
import org.jetbrains.annotations.NotNull;

public class TpKeysService {
    private static final String DEFAULT_ERGOKEYS_KEYMAP = "TpKeys(QWERTY)";
    private final KeymapManagerEx keymapManagerEx = (KeymapManagerEx) KeymapManager.getInstance();
    private final Keymap currentKeymap = keymapManagerEx.getActiveKeymap();
    private final ProjectManager projectManager;
    private final WindowManager windowManager;


    private Keymap commandKeymap;
    private Keymap insertKeymap;

    public TpKeysService() {

        projectManager = ProjectManager.getInstance();
        windowManager = WindowManager.getInstance();
    }

    public static TpKeysService getInstance() {
        return ServiceManager.getService(TpKeysService.class);

    }


    public void initKeymap() {


        if (insertKeymap == null && commandKeymap == null) {


            this.insertKeymap = keymapManagerEx.getKeymap(KeymapManagerEx.MAC_OS_X_10_5_PLUS_KEYMAP);

            this.commandKeymap = keymapManagerEx.getKeymap(DEFAULT_ERGOKEYS_KEYMAP);

        }
    }

    public void activateCommandMode(Editor editor) {
        this.initKeymap();
        this.setTextOnStatusBar("Command");
        editor.getSettings().setBlockCursor(true);
        changeKeymap(this.commandKeymap);
    }

    public void activateInsertMode(Editor editor) {
        this.setTextOnStatusBar("Insert");
        editor.getSettings().setBlockCursor(false);
        changeKeymap(this.insertKeymap);
    }

    public void changeKeymap(Keymap keymap) {

        if (insertKeymap == null || commandKeymap == null) {

            return;
        }

        keymapManagerEx.setActiveKeymap(keymap);


    }

    public void setTextOnStatusBar(String text) {
        Project[] projects = projectManager.getOpenProjects();
        for (var project : projects) {
            windowManager.getStatusBar(project).setInfo(text);
        }

    }
}
