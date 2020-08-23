package com.github.tpim.tpkeys.service;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.keymap.Keymap;
import com.intellij.openapi.keymap.KeymapManager;
import com.intellij.openapi.keymap.ex.KeymapManagerEx;
import org.apache.batik.svggen.font.table.GsubTable;

public class TpKeysService {
    private static final String DEFAULT_ERGOKEYS_KEYMAP = "TpKeys(QWERTY)";
    private final KeymapManagerEx keymapManagerEx;

    private Keymap commandKeymap;
    private Keymap insertKeymap;

    public TpKeysService() {
        keymapManagerEx = KeymapManagerEx.getInstanceEx();
    }

    public static TpKeysService getInstance() {
        return ServiceManager.getService(TpKeysService.class);
    }


    public void initKeymap(Keymap keymap)
    {
        if(insertKeymap == null && commandKeymap== null)
        {
            System.out.println("initKeymap");
            this.insertKeymap = keymapManagerEx.getKeymap(KeymapManagerEx.MAC_OS_X_10_5_PLUS_KEYMAP);
            System.out.println(this.insertKeymap);
            this.commandKeymap = keymapManagerEx.getKeymap(DEFAULT_ERGOKEYS_KEYMAP);
            System.out.println(this.commandKeymap);
        }
    }


    public void activateCommandMode(Editor editor) {
        editor.getSettings().setBlockCursor(true);
        changeKeymap(this.commandKeymap);
    }

    public void activateInsertMode(Editor editor){
        editor.getSettings().setBlockCursor(false);
        changeKeymap(this.insertKeymap);
        System.out.println(this.insertKeymap);
    }

    public void changeKeymap(Keymap keymap) {

        if (insertKeymap == null || commandKeymap == null) {
            System.out.println("do not init keymap.");
            return;
        }

        keymapManagerEx.setActiveKeymap(keymap);


    }
}
