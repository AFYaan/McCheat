package net.minecraft.afyaan.override;

import org.lwjgl.input.Keyboard;

import net.minecraft.afyaan.McCheatClient;
import net.minecraft.afyaan.clickgui.GuiUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.ServerListEntryLanDetected;
import net.minecraft.client.gui.ServerListEntryNormal;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.LanServerDetector;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.Session;

public class TestGui extends GuiScreen{
	private final GuiScreen field_146310_a;
	private String nick;
	private String guiname = "Set UserName";
    private GuiTextField field_146308_f;
    private GuiButton field_152176_i;
    private static final String __OBFID = "CL_00000695";

    public TestGui(GuiScreen p_i1033_1_, String nick)
    {
        this.field_146310_a = p_i1033_1_;
        this.nick = nick;
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        this.field_146308_f.updateCursorCounter();
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        //System.out.println(this.mc.isIntegratedServerRunning());
        if(!this.mc.isIntegratedServerRunning()){
        	this.buttonList.add(new GuiButton(0, this.width / 2 + 2, this.height / 4 + 96 + 18, 99, 20, I18n.format("Re connect", new Object[0])));
            this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 96 + 18, 99, 20, I18n.format("addServer.add", new Object[0])));
        }else{
        	this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 96 + 18, I18n.format("addServer.add", new Object[0])));
        }
        this.buttonList.add(new GuiButton(2, this.width / 2 - 100, this.height / 4 + 120 + 18, I18n.format("gui.cancel", new Object[0])));
        this.field_146308_f = new GuiTextField(this.fontRendererObj, this.width / 2 - 100, this.height / 3, 200, 20);
        this.field_146308_f.func_146203_f(128);
        this.field_146308_f.setText(nick);
    }

    /**
     * "Called when the screen is unloaded. Used to disable keyboard repeat events."
     */
    public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(false);
    }

    protected void actionPerformed(GuiButton p_146284_1_)
    {
        if (p_146284_1_.enabled)
        {
        	if (p_146284_1_.id == 0)
            {
        		ServerData sd = mc.func_147104_D();
        		Session.setUsername(this.field_146308_f.getText());
        		this.mc.theWorld.sendQuittingDisconnectingPacket();
                this.mc.loadWorld((WorldClient)null);
                this.mc.displayGuiScreen(new GuiConnecting(this, this.mc, sd));
                	
                
            }
        	else if (p_146284_1_.id == 2)
            {
            	this.mc.displayGuiScreen(this.field_146310_a);
                this.field_146310_a.confirmClicked(false, 0);
            }
            else if (p_146284_1_.id == 1)
            {
            	Session.setUsername(this.field_146308_f.getText());
                this.field_146310_a.confirmClicked(true, 0);
                this.mc.displayGuiScreen((GuiScreen)null);
                this.mc.setIngameFocus();
            }
        }
    }

    /**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
    protected void keyTyped(char p_73869_1_, int p_73869_2_)
    {
        this.field_146308_f.textboxKeyTyped(p_73869_1_, p_73869_2_);

        if (p_73869_2_ == 15)
        {
            this.field_146308_f.setFocused(!this.field_146308_f.isFocused());
        }

        if (p_73869_2_ == 28 || p_73869_2_ == 156)
        {
            this.actionPerformed((GuiButton)this.buttonList.get(0));
        }     
    }

    /**
     * Called when the mouse is clicked.
     */
    protected void mouseClicked(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
        super.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
        this.field_146308_f.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format(guiname, new Object[0]), this.width / 2, 17, 16777215);
        this.drawString(this.fontRendererObj, I18n.format("UserName", new Object[0]), this.width / 2 - 100, this.height / 3 - 12, 10526880);
        this.field_146308_f.drawTextBox();
        super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
    }
	

	
	
	

}
