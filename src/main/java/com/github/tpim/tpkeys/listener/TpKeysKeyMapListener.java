package com.github.tpim.tpkeys.listener;

import com.github.tpim.tpkeys.service.TpKeysService;
import com.intellij.openapi.keymap.Keymap;
import com.intellij.openapi.keymap.KeymapManagerListener;
import org.jetbrains.annotations.Nullable;

public class TpKeysKeyMapListener implements KeymapManagerListener {

    private final TpKeysService service;

    public TpKeysKeyMapListener(){
        service = TpKeysService.getInstance();
    }

    @Override
    public void activeKeymapChanged(@Nullable Keymap keymap) {
        service.initKeymap(keymap);
    }
}
