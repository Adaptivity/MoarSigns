package gory_moon.moarsigns.client.interfaces.buttons;

import gory_moon.moarsigns.client.interfaces.GuiBase;
import gory_moon.moarsigns.client.interfaces.GuiColor;
import gory_moon.moarsigns.client.interfaces.GuiMoarSign;

public class ButtonColorPicker extends GuiButtonToggleable {

    public ButtonColorPicker(int x, int y) {
        super(x, y, 112);
    }

    @Override
    public String getButtonInfo() {
        return "Color Selector\n" + GuiColor.GRAY + "Add color to the text\n" + GuiColor.GRAY + "at the cursor position";
    }

    @Override
    public void action(GuiBase gui) {
        GuiMoarSign guiM = (GuiMoarSign)gui;
        guiM.showColors = true;
    }

    @Override
    public void update(GuiMoarSign gui) {
        if (gui.selectedTextField != -1) {
            isDisabled = false;
        } else {
            isDisabled = true;
            gui.showColors = false;
        }

        if (!getState()) gui.showColors = false;
    }

    @Override
    public boolean onClick(GuiMoarSign gui, int x, int y) {
        if (super.onClick(gui, x, y)) {
            setState(!getState());
            return true;
        } else {
            setState(false);
            gui.showColors = false;
            return false;
        }
    }
}
