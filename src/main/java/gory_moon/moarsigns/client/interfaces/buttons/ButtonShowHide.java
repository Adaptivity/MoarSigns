package gory_moon.moarsigns.client.interfaces.buttons;

import gory_moon.moarsigns.client.interfaces.GuiBase;
import gory_moon.moarsigns.client.interfaces.GuiMoarSign;

public class ButtonShowHide extends GuiButtonSpecial {

    public boolean isHidden;
    public int id;

    public ButtonShowHide(int id, int x, int y, boolean isHidden) {
        super(x, y, 16, 16, isHidden ? 224: 240, 192);
        this.id = id;
        this.isHidden = isHidden;
    }

    @Override
    public void drawButton(GuiBase gui, int mouseX, int mouseY) {
        int srcX = isHidden ? 224: 240;
        int buttonType = inRect(mouseX, mouseY) ? srcY + h : srcY;

        super.draw(gui, srcX, buttonType);
    }

    @Override
    public String getButtonInfo() {
        return "";
    }

    @Override
    public void action(GuiBase gui) {
        isHidden = !isHidden;
        ((GuiMoarSign)gui).visibleRows[id] = !isHidden;
        System.out.println(id + ": " + isHidden);
    }
}
