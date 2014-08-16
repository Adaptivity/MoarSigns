package gory_moon.moarsigns.client.interfaces.buttons;

import gory_moon.moarsigns.client.interfaces.GuiBase;
import gory_moon.moarsigns.client.interfaces.GuiColor;
import gory_moon.moarsigns.client.interfaces.GuiMoarSign;
import net.minecraft.client.gui.GuiScreen;

public class ButtonCopy extends GuiButton {

    public ButtonCopy(int x, int y) {
        super(x, y, 16);
    }

    @Override
    public String getButtonInfo() {
        return "Copy\n" + GuiColor.GRAY + "Copies the selected text\n" + GuiColor.GRAY + "to the clipboard";
    }

    @Override
    public void action(GuiBase gui) {
        GuiMoarSign guiM = (GuiMoarSign)gui;
        GuiScreen.setClipboardString(guiM.guiTextFields[guiM.selectedTextField].getSelectedText());
    }

    @Override
    public void update(GuiMoarSign gui) {
        isDisabled = gui.selectedTextField == -1 || gui.guiTextFields[gui.selectedTextField].getSelectedText().equals("");
    }
}
