package net.minecraft.afyaan.clickgui;

import java.util.List;
 
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.network.Packet;
 
public class GuiUtils
{
        private static Minecraft mc = Minecraft.getMinecraft();
        private static RenderItem itemRenderer = new RenderItem();
 
 
       
        
        
        public static void drawRoundedRect(float x, float y, float x1, float y1, int borderC, int insideC) {
        x *= 2; y *= 2; x1 *= 2; y1 *= 2;
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        drawVLine(x, y + 1, y1 -2, borderC);
        drawVLine(x1 - 1, y + 1, y1 - 2, borderC);
        drawHLine(x + 2, x1 - 3, y, borderC);
        drawHLine(x + 2, x1 - 3, y1 -1, borderC);
        drawHLine(x + 1, x + 1, y + 1, borderC);
        drawHLine(x1 - 2, x1 - 2, y + 1, borderC);
        drawHLine(x1 - 2, x1 - 2, y1 - 2, borderC);
        drawHLine(x + 1, x + 1, y1 - 2, borderC);
        drawRect(x + 1, y + 1, x1 - 1, y1 - 1, insideC);
        GL11.glScalef(2.0F, 2.0F, 2.0F);
        }
 
        public static void drawBorderedRect(float x, float y, float x1, float y1, int borderC, int insideC)
        {
                x *= 2; x1 *= 2; y *= 2; y1 *= 2;
                GL11.glScalef(0.5F, 0.5F, 0.5F);
                drawVLine(x, y, y1 - 1, borderC);
                drawVLine(x1 - 1, y , y1, borderC);
                drawHLine(x, x1 - 1, y, borderC);
                drawHLine(x, x1 - 2, y1 -1, borderC);
                drawRect(x + 1, y + 1, x1 - 1, y1 - 1, insideC);
                GL11.glScalef(2.0F, 2.0F, 2.0F);
        }
 
        public static void sendPacket(Packet p)
        {
                mc.thePlayer.sendQueue.addToSendQueue(p);
        }
       
        public static boolean stringListContains(List<String> list, String needle) {
                for(String s: list) {
                        if(s.trim().equalsIgnoreCase(needle.trim())) {
                                return true;
                        }
                }
                return false;
        }
 
       
        public static void drawBorderedRect(double x, double y, double x2, double y2, float l1, int col1, int col2) {
        drawRect((float)x, (float)y, (float)x2, (float)y2, col2);
 
        float f = (float)(col1 >> 24 & 0xFF) / 255F;
        float f1 = (float)(col1 >> 16 & 0xFF) / 255F;
        float f2 = (float)(col1 >> 8 & 0xFF) / 255F;
        float f3 = (float)(col1 & 0xFF) / 255F;
 
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
 
        GL11.glPushMatrix();
        GL11.glColor4f(f1, f2, f3, f);
        GL11.glLineWidth(l1);
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex2d(x, y);
        GL11.glVertex2d(x, y2);
        GL11.glVertex2d(x2, y2);
        GL11.glVertex2d(x2, y);
        GL11.glVertex2d(x, y);
        GL11.glVertex2d(x2, y);
        GL11.glVertex2d(x, y2);
        GL11.glVertex2d(x2, y2);
        GL11.glEnd();
        GL11.glPopMatrix();
 
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
}
 
 
 
        public static void drawHLine(float par1, float par2, float par3, int par4)
        {
                if (par2 < par1)
                {
                        float var5 = par1;
                        par1 = par2;
                        par2 = var5;
                }
 
                drawRect(par1, par3, par2 + 1, par3 + 1, par4);
        }
 
        public static void drawVLine(float par1, float par2, float par3, int par4)
        {
                if (par3 < par2)
                {
                        float var5 = par2;
                        par2 = par3;
                        par3 = var5;
                }
 
                drawRect(par1, par2 + 1, par1 + 1, par3, par4);
        }
 
        public static void drawRect(float paramXStart, float paramYStart, float paramXEnd, float paramYEnd, int paramColor)
        {
                float alpha = (float)(paramColor >> 24 & 0xFF) / 255F;
                float red = (float)(paramColor >> 16 & 0xFF) / 255F;
                float green = (float)(paramColor >> 8 & 0xFF) / 255F;
                float blue = (float)(paramColor & 0xFF) / 255F;
 
                GL11.glEnable(GL11.GL_BLEND);
                GL11.glDisable(GL11.GL_TEXTURE_2D);
                GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
                GL11.glEnable(GL11.GL_LINE_SMOOTH);
 
                GL11.glPushMatrix();
                GL11.glColor4f(red, green, blue, alpha);
                GL11.glBegin(GL11.GL_QUADS);
                GL11.glVertex2d(paramXEnd, paramYStart);
                GL11.glVertex2d(paramXStart, paramYStart);
                GL11.glVertex2d(paramXStart, paramYEnd);
                GL11.glVertex2d(paramXEnd, paramYEnd);
                GL11.glEnd();
                GL11.glPopMatrix();
 
                GL11.glEnable(GL11.GL_TEXTURE_2D);
                GL11.glDisable(GL11.GL_BLEND);
                GL11.glDisable(GL11.GL_LINE_SMOOTH);
        }
 
        public static void drawGradientRect(double x, double y, double x2, double y2, int col1, int col2)
        {
                float f = (float)(col1 >> 24 & 0xFF) / 255F;
                float f1 = (float)(col1 >> 16 & 0xFF) / 255F;
                float f2 = (float)(col1 >> 8 & 0xFF) / 255F;
                float f3 = (float)(col1 & 0xFF) / 255F;
 
                float f4 = (float)(col2 >> 24 & 0xFF) / 255F;
                float f5 = (float)(col2 >> 16 & 0xFF) / 255F;
                float f6 = (float)(col2 >> 8 & 0xFF) / 255F;
                float f7 = (float)(col2 & 0xFF) / 255F;
 
                GL11.glEnable(GL11.GL_BLEND);
                GL11.glDisable(GL11.GL_TEXTURE_2D);
                GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
                GL11.glEnable(GL11.GL_LINE_SMOOTH);
                GL11.glShadeModel(GL11.GL_SMOOTH);
 
                GL11.glPushMatrix();
                GL11.glBegin(GL11.GL_QUADS);
                GL11.glColor4f(f1, f2, f3, f);
                GL11.glVertex2d(x2, y);
                GL11.glVertex2d(x, y);
 
                GL11.glColor4f(f5, f6, f7, f4);
                GL11.glVertex2d(x, y2);
                GL11.glVertex2d(x2, y2);
                GL11.glEnd();
                GL11.glPopMatrix();
 
                GL11.glEnable(GL11.GL_TEXTURE_2D);
                GL11.glDisable(GL11.GL_BLEND);
                GL11.glDisable(GL11.GL_LINE_SMOOTH);
                GL11.glShadeModel(GL11.GL_FLAT);
        }
 
        public static void drawGradientBorderedRect(double x, double y, double x2, double y2, float l1, int col1, int col2, int col3)
        {
                float f = (float)(col1 >> 24 & 0xFF) / 255F;
                float f1 = (float)(col1 >> 16 & 0xFF) / 255F;
                float f2 = (float)(col1 >> 8 & 0xFF) / 255F;
                float f3 = (float)(col1 & 0xFF) / 255F;
 
                GL11.glDisable(GL11.GL_TEXTURE_2D);
                GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
                GL11.glEnable(GL11.GL_LINE_SMOOTH);
                GL11.glDisable(GL11.GL_BLEND);
 
                GL11.glPushMatrix();
                GL11.glColor4f(f1, f2, f3, f);
                GL11.glLineWidth(1F);
                GL11.glBegin(GL11.GL_LINES);
                GL11.glVertex2d(x, y);
                GL11.glVertex2d(x, y2);
                GL11.glVertex2d(x2, y2);
                GL11.glVertex2d(x2, y);
                GL11.glVertex2d(x, y);
                GL11.glVertex2d(x2, y);
                GL11.glVertex2d(x, y2);
                GL11.glVertex2d(x2, y2);
                GL11.glEnd();
                GL11.glPopMatrix();
 
                drawGradientRect(x, y, x2, y2, col2, col3);
 
                GL11.glEnable(GL11.GL_BLEND);
                GL11.glEnable(GL11.GL_TEXTURE_2D);
                GL11.glDisable(GL11.GL_LINE_SMOOTH);
        }//Welcome guys! - Rooky & Rees
}