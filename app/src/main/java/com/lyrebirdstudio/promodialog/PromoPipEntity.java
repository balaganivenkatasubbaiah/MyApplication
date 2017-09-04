package com.lyrebirdstudio.promodialog;

public class PromoPipEntity {
    float dx;
    float dy;
    int iconId;
    int maskId;
    int shadeId;

    public PromoPipEntity(float dx, float dy, int maskId, int shadeId, int iconId) {
        this.dx = dx;
        this.dy = dy;
        this.maskId = maskId;
        this.shadeId = shadeId;
        this.iconId = iconId;
    }
}
